import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
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

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine {
   @ObfuscatedName("ak")
   static boolean field1188;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 661620623
   )
   static int field983;
   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   static class232 field923;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -709524235
   )
   @Export("rights")
   public static int rights;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1267018671
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = 1362188451
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("lm")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field1052;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1532267913
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = -486798229
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = 804711719
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -2088433601
   )
   @Export("gameState")
   @Hook("gameStateChanged")
   static int gameState;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = -108400503
   )
   static int field1138;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -1858976201
   )
   static int field974;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1255530869
   )
   @Export("world")
   static int world;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = 861506517
   )
   static int field1116;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = -719990843
   )
   static int field1117;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      longValue = 8355630169067595559L
   )
   static long field1126;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = 1316231819
   )
   static int field1050;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1323558855
   )
   static int field1148;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -1115173227
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1724245911
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("ja")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("mp")
   static boolean[] field1118;
   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   static class275 field929;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -1100557975
   )
   @Export("packetType")
   static int packetType;
   @ObfuscatedName("je")
   static boolean[] field1021;
   @ObfuscatedName("jo")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = -1017989471
   )
   static int field1029;
   @ObfuscatedName("mt")
   static boolean[] field1034;
   @ObfuscatedName("mv")
   static boolean[] field1119;
   @ObfuscatedName("js")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = 231594007
   )
   @Export("secondLastFrameId")
   static int secondLastFrameId;
   @ObfuscatedName("lg")
   static boolean field1094;
   @ObfuscatedName("bn")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("ex")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -1172874931
   )
   @Export("packetLength")
   static int packetLength;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -1618170933
   )
   static int field1063;
   @ObfuscatedName("eo")
   @ObfuscatedSignature(
      signature = "Lfd;"
   )
   @Export("secretPacketBuffer2")
   static PacketBuffer secretPacketBuffer2;
   @ObfuscatedName("bd")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 1756214679
   )
   @Export("thridLastFrameId")
   static int thridLastFrameId;
   @ObfuscatedName("nc")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("jt")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = 805151453
   )
   static int field958;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -638218957
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("ll")
   static boolean field1091;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = -62726891
   )
   static int field1030;
   @ObfuscatedName("ol")
   static boolean field1151;
   @ObfuscatedName("bv")
   static boolean field1123;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = 159247921
   )
   static int field1088;
   @ObfuscatedName("kd")
   static boolean field961;
   @ObfuscatedName("jy")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = 2141240703
   )
   static int field1089;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      longValue = -6948804920244288885L
   )
   static long field1144;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = -1998318611
   )
   static int field1092;
   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "Lfd;"
   )
   @Export("secretPacketBuffer1")
   public static PacketBuffer secretPacketBuffer1;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -1619901843
   )
   static int field1010;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -466208755
   )
   static int field933;
   @ObfuscatedName("jr")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -2137529889
   )
   static int field934;
   @ObfuscatedName("lt")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field1047;
   @ObfuscatedName("bw")
   static boolean field935;
   @ObfuscatedName("jp")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = 954483837
   )
   @Export(
      value = "gameDrawingMode",
      setter = true
   )
   static int gameDrawingMode;
   @ObfuscatedName("kc")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("be")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("mo")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = -735008495
   )
   static int field1122;
   @ObfuscatedName("mf")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = 239946345
   )
   static int field1093;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 635509155
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1812072059
   )
   static int field938;
   @ObfuscatedName("kw")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -1913626795
   )
   static int field939;
   @ObfuscatedName("lx")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field1085;
   @ObfuscatedName("jm")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1316939417
   )
   static int field940;
   @ObfuscatedName("mb")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = -241109223
   )
   static int field1031;
   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "[Lbw;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -64901137
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = 579347909
   )
   static int field982;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1600791891
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("jh")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("mq")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("km")
   static String field1071;
   @ObfuscatedName("it")
   static String field1067;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 2098586753
   )
   static int field927;
   @ObfuscatedName("jj")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -128564187
   )
   static int field979;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1563626423
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("me")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("kh")
   static String field948;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = 2136939401
   )
   static int field980;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 176417731
   )
   static int field944;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 948027309
   )
   static int field1173;
   @ObfuscatedName("ra")
   @ObfuscatedSignature(
      signature = "Lbh;"
   )
   static final class72 field1189;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 2046768213
   )
   static int field945;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = 918764997
   )
   static int field1095;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfq;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -1617234823
   )
   static int field1023;
   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   static IndexData field1193;
   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   static class89 field946;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = -788858779
   )
   static int field1096;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = 1970696783
   )
   static int field1086;
   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   static class89 field947;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 1433666375
   )
   static int field1114;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -598908659
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = -1435772577
   )
   static int field1024;
   @ObfuscatedName("iq")
   static boolean field1105;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = 325069221
   )
   static int field1127;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = -518620499
   )
   static int field1019;
   @ObfuscatedName("mn")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   static Deque field1112;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -625286011
   )
   static int field1020;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = 349711663
   )
   static int field1026;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 577697241
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("rv")
   static int[] field1190;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = 798503283
   )
   static int field1135;
   @ObfuscatedName("rq")
   static int[] field1191;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = -106908097
   )
   static int field1171;
   @ObfuscatedName("lk")
   static boolean field1159;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = 118437831
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -412981917
   )
   static int field969;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 427703383
   )
   static int field1017;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = -1329383267
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = -195414825
   )
   static int field1025;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = -2101713993
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   static class149 field957;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -814926059
   )
   @Export("lastFrameId")
   static int lastFrameId;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -1684626721
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("dh")
   static byte[] field981;
   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "[Lcs;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = 236394013
   )
   @Export("npcIndexesCount")
   static int npcIndexesCount;
   @ObfuscatedName("dm")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 1841443835
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("eb")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = -1125610427
   )
   static int field1186;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = 1514469339
   )
   static int field1111;
   @ObfuscatedName("qd")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   static PlayerComposition field1179;
   @ObfuscatedName("le")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field952;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = -1924968433
   )
   static int field1187;
   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "Lfd;"
   )
   static PacketBuffer field965;
   @ObfuscatedName("fg")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("io")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("iy")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "[[[Lgh;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -147428347
   )
   @Export("audioEffectCount")
   static int audioEffectCount;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -716361035
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = -1440857573
   )
   static int field1106;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = -699750707
   )
   static int field1036;
   @ObfuscatedName("fv")
   @Export("landRegionFielIds")
   static int[] landRegionFielIds;
   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      signature = "[Lj;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = 2016617603
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("kv")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field1077;
   @ObfuscatedName("fh")
   static int[][][] field986;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = -1382420011
   )
   static int field1129;
   @ObfuscatedName("ez")
   static HashMap field932;
   @ObfuscatedName("qg")
   @ObfuscatedSignature(
      signature = "[Lba;"
   )
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("pt")
   static boolean field1160;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -2077769855
   )
   static int field1016;
   @ObfuscatedName("pj")
   static boolean[] field1161;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = -1296409283
   )
   static int field1183;
   @ObfuscatedName("lj")
   static int[] field1152;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = 1274581025
   )
   static int field1018;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = -1728954975
   )
   static int field1108;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = 746529683
   )
   static int field1104;
   @ObfuscatedName("im")
   static int[] field1037;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = -1232391905
   )
   static int field1110;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = 1878759629
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = 1616758867
   )
   static int field1061;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -14275271
   )
   static int field1064;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = -846552591
   )
   static int field976;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = 621221673
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 2090861771
   )
   static int field1065;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -1831139663
   )
   static int field970;
   @ObfuscatedName("px")
   static int[] field1162;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -574967071
   )
   static int field989;
   @ObfuscatedName("pa")
   static int[] field1056;
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      longValue = 3943244019053167167L
   )
   static long field1137;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = -37413715
   )
   static int field1180;
   @ObfuscatedName("pd")
   static int[] field1164;
   @ObfuscatedName("pr")
   static int[] field1165;
   @ObfuscatedName("kq")
   static boolean field1082;
   @ObfuscatedName("hx")
   static boolean field1003;
   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = -1304897411
   )
   static int field1109;
   @ObfuscatedName("lb")
   static int[] field1099;
   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -8664159
   )
   static int field1100;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = 477192833
   )
   static int field942;
   @ObfuscatedName("fw")
   static final int[] field987;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 489268627
   )
   static int field990;
   @ObfuscatedName("pf")
   static short field1167;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = 575085247
   )
   static int field1154;
   @ObfuscatedName("po")
   static short field1166;
   @ObfuscatedName("op")
   static int[] field1155;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -337488665
   )
   static int field1035;
   @ObfuscatedName("pi")
   static int[] field1156;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 1765396395
   )
   static int field992;
   @ObfuscatedName("id")
   static int[] field1041;
   @ObfuscatedName("hs")
   static int[][] field1015;
   @ObfuscatedName("qc")
   static short field1172;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -729926387
   )
   static int field1072;
   @ObfuscatedName("pk")
   static int[] field1157;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = -389809805
   )
   static int field1141;
   @ObfuscatedName("qn")
   static short field1062;
   @ObfuscatedName("oc")
   static int[] field1142;
   @ObfuscatedName("gg")
   static boolean field993;
   @ObfuscatedName("qy")
   static short field1059;
   @ObfuscatedName("pe")
   static short field1169;
   @ObfuscatedName("pg")
   @ObfuscatedSignature(
      signature = "[Lcf;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = -992040939
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("pw")
   static short field1168;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -1558225191
   )
   static int field921;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 924172665
   )
   static int field994;
   @ObfuscatedName("qs")
   static short field1001;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = 1668871185
   )
   static int field1107;
   @ObfuscatedName("pc")
   static int[] field1158;
   @ObfuscatedName("qi")
   @ObfuscatedSignature(
      signature = "[Lbu;"
   )
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("lv")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = 1520329415
   )
   static int field1102;
   @ObfuscatedName("oq")
   static int[] field1143;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = -697298007
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 2069198121
   )
   static int field1149;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 1678497187
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -141622089
   )
   static int field941;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 403616107
   )
   static int field1153;
   @ObfuscatedName("of")
   @ObfuscatedSignature(
      signature = "[Lkr;"
   )
   static SpritePixels[] field1176;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = 1109105279
   )
   static int field1000;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 882799941
   )
   static int field1002;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = 893067749
   )
   static int field1140;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = 284818807
   )
   static int field1124;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = -1508822133
   )
   static int field1005;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = -1709102871
   )
   static int field1006;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = -1798791025
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("hc")
   static int[] field1007;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -1793425263
   )
   static int field931;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 1368877589
   )
   static int field956;
   @ObfuscatedName("hj")
   static int[] field1008;
   @ObfuscatedName("ho")
   static int[] field1009;
   @ObfuscatedName("na")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("hk")
   static int[] field1083;
   @ObfuscatedName("qa")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   static class195 field998;
   @ObfuscatedName("hh")
   static int[] field1011;
   @ObfuscatedName("jc")
   static boolean field1184;
   @ObfuscatedName("hq")
   static int[] field1012;
   @ObfuscatedName("hy")
   static int[] field1066;
   @ObfuscatedName("nx")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = 833459087
   )
   static int field1075;
   @ObfuscatedName("hn")
   static String[] field1133;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 1503811323
   )
   static int field1076;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 1410017727
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 700755173
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -412043285
   )
   static int field1081;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = -2098402669
   )
   static int field1113;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = 1932157999
   )
   static int field1175;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = -1666873073
   )
   static int field1134;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = 60807055
   )
   static int field1069;
   @ObfuscatedName("ne")
   static long[] field1132;
   @ObfuscatedName("ic")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = -729528429
   )
   static int field1053;
   @ObfuscatedName("nl")
   static int[] field1136;
   @ObfuscatedName("nh")
   static int[] field1185;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = 1045184925
   )
   @Export(
      value = "chatCycle",
      setter = true
   )
   static int chatCycle;
   @ObfuscatedName("mg")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   static Deque field1125;
   @ObfuscatedName("mi")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   static Deque field1090;
   @ObfuscatedName("jx")
   static boolean field1060;
   @ObfuscatedName("nm")
   static int[] field1128;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = 154778747
   )
   static int field1070;
   @ObfuscatedName("ls")
   static boolean field978;
   @ObfuscatedName("nb")
   static String field1131;
   public static boolean RUNELITE_PACKET;

   static {
      field1188 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field1123 = true;
      gameCycle = 0;
      field1144 = -1L;
      field1010 = -1;
      field933 = -1;
      field934 = -1;
      field935 = true;
      displayFps = false;
      field983 = 0;
      field938 = 0;
      field939 = 0;
      field940 = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowType = 0;
      field944 = 0;
      field945 = 0;
      field946 = class89.field1403;
      field947 = class89.field1403;
      loadingStage = 0;
      js5State = 0;
      field1148 = 0;
      field958 = 0;
      loginState = 0;
      field1030 = 0;
      field1138 = 0;
      field1017 = 0;
      field957 = class149.field2209;
      field981 = null;
      cachedNPCs = new NPC['耀'];
      npcIndexesCount = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      secretPacketBuffer1 = new PacketBuffer(5000);
      field965 = new PacketBuffer(5000);
      secretPacketBuffer2 = new PacketBuffer(15000);
      packetLength = 0;
      packetType = 0;
      field969 = 0;
      audioEffectCount = 0;
      lastFrameId = 0;
      secondLastFrameId = 0;
      thridLastFrameId = 0;
      field974 = 0;
      socketError = false;
      field929 = new class275();
      field932 = new HashMap();
      field982 = 0;
      field979 = 1;
      field980 = 0;
      field1173 = 1;
      field1031 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field986 = new int[4][13][13];
      field987 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field1122 = 0;
      field989 = 2301979;
      field990 = 5063219;
      field1072 = 3353893;
      field992 = 7759444;
      field993 = false;
      field994 = 0;
      field921 = 128;
      mapAngle = 0;
      field1149 = 0;
      field941 = 0;
      field1153 = 0;
      field1000 = 0;
      field1002 = 50;
      field970 = 0;
      field1003 = false;
      field1124 = 0;
      field1005 = 0;
      field1006 = 50;
      field1007 = new int[field1006];
      field1008 = new int[field1006];
      field1009 = new int[field1006];
      field1083 = new int[field1006];
      field1011 = new int[field1006];
      field1012 = new int[field1006];
      field1066 = new int[field1006];
      field1133 = new String[field1006];
      field1015 = new int[104][104];
      field1016 = 0;
      screenY = -1;
      screenX = -1;
      field1019 = 0;
      field1020 = 0;
      field1171 = 0;
      cursorState = 0;
      field1023 = 0;
      field1024 = 0;
      field1025 = 0;
      field1026 = 0;
      field1135 = 0;
      field1113 = 0;
      field1105 = false;
      field1127 = 0;
      field1175 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field1035 = 0;
      field1036 = 0;
      field1037 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field1041 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field1061 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field1050 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field1021 = new boolean[500];
      field1060 = false;
      field1184 = false;
      field1029 = -1;
      field1063 = -1;
      field1064 = 0;
      field1065 = 50;
      itemSelectionState = 0;
      field1067 = null;
      spellSelected = false;
      field1069 = -1;
      field1070 = -1;
      field1071 = null;
      field948 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field1075 = 0;
      field1076 = 0;
      field1077 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1081 = -1;
      field1082 = false;
      field961 = false;
      field978 = false;
      field1085 = null;
      field1052 = null;
      field1047 = null;
      field1088 = 0;
      field1089 = 0;
      field952 = null;
      field1091 = false;
      field1092 = -1;
      field1093 = -1;
      field1094 = false;
      field1095 = -1;
      field1096 = -1;
      field1159 = false;
      cycleCntr = 1;
      field1099 = new int[32];
      field1100 = 0;
      interfaceItemTriggers = new int[32];
      field1102 = 0;
      field1152 = new int[32];
      field1104 = 0;
      chatCycle = 0;
      field1106 = 0;
      field1107 = 0;
      field1108 = 0;
      field1109 = 0;
      field1110 = 0;
      field1111 = 0;
      field1112 = new Deque();
      field1125 = new Deque();
      field1090 = new Deque();
      widgetFlags = new HashTable(512);
      field1116 = 0;
      field1117 = -2;
      field1118 = new boolean[100];
      field1119 = new boolean[100];
      field1034 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1126 = 0L;
      isResized = true;
      field1128 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field1129 = 0;
      field1018 = 0;
      field1131 = "";
      field1132 = new long[100];
      field1053 = 0;
      field1134 = 0;
      field1185 = new int[128];
      field1136 = new int[128];
      field1137 = -1L;
      clanChatOwner = null;
      clanChatName = null;
      field1140 = -1;
      field1141 = 0;
      field1142 = new int[1000];
      field1143 = new int[1000];
      field1176 = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1183 = 0;
      field976 = 255;
      field1086 = -1;
      field1151 = false;
      field942 = 127;
      field1114 = 127;
      field1154 = 0;
      field1155 = new int[50];
      field1156 = new int[50];
      field1157 = new int[50];
      field1158 = new int[50];
      audioEffects = new SoundEffect[50];
      field1160 = false;
      field1161 = new boolean[5];
      field1162 = new int[5];
      field1056 = new int[5];
      field1164 = new int[5];
      field1165 = new int[5];
      field1166 = 256;
      field1167 = 205;
      field1168 = 256;
      field1169 = 320;
      field1001 = 1;
      field1059 = 32767;
      field1172 = 1;
      field1062 = 32767;
      field931 = 0;
      field956 = 0;
      viewportHeight = 0;
      viewportWidth = 0;
      scale = 0;
      friendCount = 0;
      field1180 = 0;
      friends = new Friend[400];
      field998 = new class195();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1179 = new PlayerComposition();
      field1186 = -1;
      field1187 = 1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field1189 = new class72();
      field1190 = new int[50];
      field1191 = new int[50];
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1036337222"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         boolean var1 = DynamicObject.method1933();
         if(!var1) {
            this.method1208();
         }

      }
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-71"
   )
   void method1297() {
      int var1 = class60.canvasWidth;
      int var2 = class48.canvasHeight;
      if(super.field713 < var1) {
         var1 = super.field713;
      }

      if(super.field714 < var2) {
         var2 = super.field714;
      }

      if(class23.preferences != null) {
         try {
            class52.method796(PendingSpawn.clientInstance, "resize", new Object[]{Integer.valueOf(class19.method142())});
         } catch (Throwable var4) {
            ;
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "506800678"
   )
   protected final void vmethod1206() {
      if(GZipDecompressor.chatMessages.changed()) {
         GZipDecompressor.chatMessages.serialize();
      }

      if(class110.field1653 != null) {
         class110.field1653.field859 = false;
      }

      class110.field1653 = null;
      if(class268.rssocket != null) {
         class268.rssocket.close();
         class268.rssocket = null;
      }

      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var1 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

      class27.method204();
      WorldMapType3.field396 = null;
      if(class1.soundSystem0 != null) {
         class1.soundSystem0.method2118();
      }

      if(class40.soundSystem1 != null) {
         class40.soundSystem1.method2118();
      }

      class211.method4048();
      Object var9 = class236.field3236;
      synchronized(class236.field3236) {
         if(class236.field3234 != 0) {
            class236.field3234 = 1;

            try {
               class236.field3236.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      if(class66.field832 != null) {
         class66.field832.method2970();
         class66.field832 = null;
      }

      try {
         class155.field2261.method2410();

         for(int var4 = 0; var4 < class267.field3668; ++var4) {
            class96.field1514[var4].method2410();
         }

         class155.field2260.method2410();
         class155.field2258.method2410();
      } catch (Exception var7) {
         ;
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1633753465"
   )
   protected final void vmethod1203() {
      SceneTilePaint.field2023 = socketType == 0?'ꩊ':world + '鱀';
      AbstractSoundSystem.field1631 = socketType == 0?443:world + '썐';
      class18.myWorldPort = SceneTilePaint.field2023;
      class152.colorsToFind = class214.field2641;
      class208.colorsToReplace = class214.field2640;
      TextureProvider.field1767 = class214.field2639;
      SoundTask.field1648 = class214.field2642;
      class66.field832 = new class147();
      this.method877();
      this.method924();
      WorldMapType3.field396 = this.method945();
      class204.field2552 = new IndexFile(255, class155.field2261, class155.field2260, 500000);
      class23.preferences = class18.method137();
      this.method875();
      ScriptState.method1124(this, FileSystem.field3202);
      if(socketType != 0) {
         displayFps = true;
      }

      Friend.method1135(class23.preferences.screenType);
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1565695859"
   )
   final void method1213(boolean var1) {
      int var2 = widgetRoot;
      int var3 = class60.canvasWidth;
      int var4 = class48.canvasHeight;
      if(class93.loadWidget(var2)) {
         FaceNormal.method2938(class177.widgets[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "97"
   )
   @Export("error")
   void error(int var1) {
      class277.socket = null;
      class61.rssocket = null;
      js5State = 0;
      if(SceneTilePaint.field2023 == class18.myWorldPort) {
         class18.myWorldPort = AbstractSoundSystem.field1631;
      } else {
         class18.myWorldPort = SceneTilePaint.field2023;
      }

      ++field958;
      if(field958 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field1148 = 3000;
         }
      } else if(field958 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field958 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field1148 = 3000;
         }
      }

   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "771787284"
   )
   final boolean method1216() {
      int var1 = menuOptionCount - 1;
      if(menuOptionCount > 2) {
         if(field1050 != 1 || field1021[var1]) {
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

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "65"
   )
   protected final void vmethod1200() {
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-683726112"
   )
   final void method1217(int var1, int var2) {
      int var3 = Friend.field827.method4918("Choose Option");

      int var4;
      int var5;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         var5 = Friend.field827.method4918(class87.method1776(var4));
         if(var5 > var3) {
            var3 = var5;
         }
      }

      var3 += 8;
      var4 = 22 + menuOptionCount * 15;
      var5 = var1 - var3 / 2;
      if(var5 + var3 > class60.canvasWidth) {
         var5 = class60.canvasWidth - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      int var6 = var2;
      if(var2 + var4 > class48.canvasHeight) {
         var6 = class48.canvasHeight - var4;
      }

      if(var6 < 0) {
         var6 = 0;
      }

      class8.region.method2794(class5.plane, var1, var2, false);
      isMenuOpen = true;
      class54.menuX = var5;
      class10.menuY = var6;
      class20.menuWidth = var3;
      class28.menuHeight = 22 + menuOptionCount * 15;
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "61"
   )
   @Export("processServerPacket")
   final boolean processServerPacket() {
      if(class268.rssocket == null) {
         return false;
      } else {
         int var3;
         String var24;
         try {
            int var1 = class268.rssocket.available();
            if(var1 == 0) {
               return false;
            }

            if(packetType == -1) {
               class268.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               packetLength = RUNELITE_PACKET?-2:class272.field3710[packetType];
               --var1;
            }

            if(packetLength == -1) {
               if(var1 <= 0) {
                  return false;
               }

               class268.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               packetLength = secretPacketBuffer2.payload[0] & 255;
               --var1;
            }

            if(packetLength == -2) {
               if(var1 <= 1) {
                  return false;
               }

               class268.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();
               var1 -= 2;
            }

            if(var1 < packetLength) {
               return false;
            }

            secretPacketBuffer2.offset = 0;
            class268.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
            field929.method5001();
            field969 = 0;
            thridLastFrameId = secondLastFrameId;
            secondLastFrameId = lastFrameId;
            lastFrameId = packetType;
            int var2;
            if(packetType == Opcodes.PACKET_SERVER_114) {
               field1160 = false;

               for(var2 = 0; var2 < 5; ++var2) {
                  field1161[var2] = false;
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_58) {
               field1180 = 1;
               field1106 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_219) {
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

            int var11;
            int var13;
            int var14;
            int var25;
            int var26;
            String var83;
            PacketBuffer var102;
            int var107;
            String var112;
            if(packetType == Opcodes.PACKET_SERVER_233) {
               var102 = secretPacketBuffer2;
               var3 = packetLength;
               ClassInfo var92 = new ClassInfo();
               var92.count = var102.readUnsignedByte();
               var92.field3756 = var102.readInt();
               var92.type = new int[var92.count];
               var92.errorIdentifiers = new int[var92.count];
               var92.fields = new Field[var92.count];
               var92.field3761 = new int[var92.count];
               var92.methods = new Method[var92.count];
               var92.args = new byte[var92.count][][];

               for(var26 = 0; var26 < var92.count; ++var26) {
                  try {
                     var25 = var102.readUnsignedByte();
                     String var111;
                     if(var25 != 0 && var25 != 1 && var25 != 2) {
                        if(var25 == 3 || var25 == 4) {
                           var83 = var102.readString();
                           var111 = var102.readString();
                           var107 = var102.readUnsignedByte();
                           String[] var90 = new String[var107];

                           for(var11 = 0; var11 < var107; ++var11) {
                              var90[var11] = var102.readString();
                           }

                           var112 = var102.readString();
                           byte[][] var12 = new byte[var107][];
                           if(var25 == 3) {
                              for(var13 = 0; var13 < var107; ++var13) {
                                 var14 = var102.readInt();
                                 var12[var13] = new byte[var14];
                                 var102.readBytes(var12[var13], 0, var14);
                              }
                           }

                           var92.type[var26] = var25;
                           Class[] var114 = new Class[var107];

                           for(var14 = 0; var14 < var107; ++var14) {
                              var114[var14] = class41.method594(var90[var14]);
                           }

                           Class var115 = class41.method594(var112);
                           if(class41.method594(var83).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var15 = class41.method594(var83).getDeclaredMethods();
                           Method[] var16 = var15;

                           for(int var17 = 0; var17 < var16.length; ++var17) {
                              Method var18 = var16[var17];
                              if(Reflection.getMethodName(var18).equals(var111)) {
                                 Class[] var19 = Reflection.getParameterTypes(var18);
                                 if(var114.length == var19.length) {
                                    boolean var20 = true;

                                    for(int var21 = 0; var21 < var114.length; ++var21) {
                                       if(var19[var21] != var114[var21]) {
                                          var20 = false;
                                          break;
                                       }
                                    }

                                    if(var20 && var115 == var18.getReturnType()) {
                                       var92.methods[var26] = var18;
                                    }
                                 }
                              }
                           }

                           var92.args[var26] = var12;
                        }
                     } else {
                        var83 = var102.readString();
                        var111 = var102.readString();
                        var107 = 0;
                        if(var25 == 1) {
                           var107 = var102.readInt();
                        }

                        var92.type[var26] = var25;
                        var92.field3761[var26] = var107;
                        if(class41.method594(var83).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var92.fields[var26] = Reflection.findField(class41.method594(var83), var111);
                     }
                  } catch (ClassNotFoundException var59) {
                     var92.errorIdentifiers[var26] = -1;
                  } catch (SecurityException var60) {
                     var92.errorIdentifiers[var26] = -2;
                  } catch (NullPointerException var61) {
                     var92.errorIdentifiers[var26] = -3;
                  } catch (Exception var62) {
                     var92.errorIdentifiers[var26] = -4;
                  } catch (Throwable var63) {
                     var92.errorIdentifiers[var26] = -5;
                  }
               }

               class281.field3766.method3660(var92);
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_208) {
               class94.playerIndexesCount = 0;

               for(var2 = 0; var2 < 2048; ++var2) {
                  class94.field1478[var2] = null;
                  class94.field1477[var2] = 1;
               }

               for(var2 = 0; var2 < 2048; ++var2) {
                  cachedPlayers[var2] = null;
               }

               WorldMapType1.initializeGPI(secretPacketBuffer2);
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_182) {
               for(var2 = 0; var2 < class181.field2452; ++var2) {
                  VarPlayerType var101 = Buffer.method3461(var2);
                  if(var101 != null) {
                     class211.settings[var2] = 0;
                     class211.widgetSettings[var2] = 0;
                  }
               }

               ItemLayer.method2495();
               field1100 += 32;
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_28) {
               class181.method3546();
               packetType = -1;
               return false;
            }

            if(packetType == Opcodes.PACKET_SERVER_221) {
               for(var2 = 0; var2 < class211.widgetSettings.length; ++var2) {
                  if(class211.settings[var2] != class211.widgetSettings[var2]) {
                     class211.widgetSettings[var2] = class211.settings[var2];
                     WidgetNode.method1139(var2);
                     field1099[++field1100 - 1 & 31] = var2;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_83) {
               class36.method487(secretPacketBuffer2, packetLength);
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_190) {
               if(widgetRoot != -1) {
                  var2 = widgetRoot;
                  if(class93.loadWidget(var2)) {
                     class251.method4526(class177.widgets[var2], 0);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_133) {
               field1183 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_174) {
               field983 = secretPacketBuffer2.readUnsignedShort() * 30;
               field1110 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_186) {
               class39.field551 = class236.method4309(secretPacketBuffer2.readUnsignedByte());
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_193) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3326();
               }

               class29.field435 = GameEngine.taskManager.createHost(var2);
               packetType = -1;
               return true;
            }

            int var23;
            if(packetType == Opcodes.PACKET_SERVER_222) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3299();
               }

               if(var2 == '\uffff') {
                  var2 = -1;
               }

               if(var2 == -1 && !field1151) {
                  CombatInfoListHolder.method1750();
               } else if(var2 != -1 && var2 != field1086 && field976 != 0 && !field1151) {
                  IndexData var100 = class268.indexTrack1;
                  var23 = field976;
                  class203.field2521 = 1;
                  class203.field2522 = var100;
                  class203.field2520 = var2;
                  Frames.field2138 = 0;
                  class148.field2203 = var23;
                  BufferProvider.field3778 = false;
                  class288.field3814 = 2;
               }

               field1086 = var2;
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_235) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedShort();
               }

               ItemContainer var97 = (ItemContainer)ItemContainer.itemContainers.get((long)var2);
               if(var97 != null) {
                  var97.unlink();
               }

               interfaceItemTriggers[++field1102 - 1 & 31] = var2 & 32767;
               packetType = -1;
               return true;
            }

            Widget var95;
            if(packetType == Opcodes.PACKET_SERVER_2) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readInt();
               }

               var95 = PacketBuffer.method3528(var2);

               for(var23 = 0; var23 < var95.itemIds.length; ++var23) {
                  var95.itemIds[var23] = -1;
                  var95.itemIds[var23] = 0;
               }

               class25.method172(var95);
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_120) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3283();
               }

               var95 = PacketBuffer.method3528(var2);
               var95.modelType = 3;
               var95.modelId = AbstractByteBuffer.localPlayer.composition.method4070();
               class25.method172(var95);
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_249) {
               ItemLayer.method2495();
               weight = secretPacketBuffer2.readShort();
               field1110 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_226) {
               ItemLayer.method2495();
               energy = secretPacketBuffer2.readUnsignedByte();
               field1110 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_141) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readInt();
               }

               WidgetNode var94 = (WidgetNode)componentTable.get((long)var2);
               if(var94 != null) {
                  PendingSpawn.method1584(var94, true);
               }

               if(field1077 != null) {
                  class25.method172(field1077);
                  field1077 = null;
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_30) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedShort();
               }

               widgetRoot = var2;
               this.method1213(false);
               WorldMapType1.method266(var2);
               WorldMapType3.method203(widgetRoot);

               for(var3 = 0; var3 < 100; ++var3) {
                  field1118[var3] = true;
               }

               packetType = -1;
               return true;
            }

            String var4;
            String var22;
            int var35;
            long var39;
            int var53;
            String var69;
            String var72;
            int var117;
            if(packetType == Opcodes.PACKET_SERVER_128) {
               if(RUNELITE_PACKET) {
                  var24 = secretPacketBuffer2.runeliteReadString();
               } else {
                  var24 = secretPacketBuffer2.readString();
               }

               class148.sessionToken = var24;

               try {
                  var22 = PendingSpawn.clientInstance.getParameter(Parameters.field3729.key);
                  var4 = PendingSpawn.clientInstance.getParameter(Parameters.field3730.key);
                  var69 = var22 + "settings=" + var24 + "; version=1; path=/; domain=" + var4;
                  if(var24.length() == 0) {
                     var69 = var69 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var72 = var69 + "; Expires=";
                     var39 = class147.currentTimeMs() + 94608000000L;
                     class182.field2459.setTime(new Date(var39));
                     var35 = class182.field2459.get(7);
                     var11 = class182.field2459.get(5);
                     var117 = class182.field2459.get(2);
                     var13 = class182.field2459.get(1);
                     var14 = class182.field2459.get(11);
                     var53 = class182.field2459.get(12);
                     int var54 = class182.field2459.get(13);
                     var83 = class182.field2458[var35 - 1] + ", " + var11 / 10 + var11 % 10 + "-" + class182.field2460[0][var117] + "-" + var13 + " " + var14 / 10 + var14 % 10 + ":" + var53 / 10 + var53 % 10 + ":" + var54 / 10 + var54 % 10 + " GMT";
                     var69 = var72 + var83 + "; Max-Age=" + 94608000L;
                  }

                  class52.method793(PendingSpawn.clientInstance, "document.cookie=\"" + var69 + "\"");
               } catch (Throwable var56) {
                  ;
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_146) {
               if(RUNELITE_PACKET) {
                  var24 = secretPacketBuffer2.runeliteReadString();
               } else {
                  var24 = secretPacketBuffer2.readString();
               }

               var22 = FontTypeFace.appendTags(DecorativeObject.method2967(class229.method4204(secretPacketBuffer2)));
               MessageNode.sendGameMessage(6, var24, var22);
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_203) {
               secretPacketBuffer2.offset += 28;
               if(secretPacketBuffer2.checkCrc()) {
                  var102 = secretPacketBuffer2;
                  var3 = secretPacketBuffer2.offset - 28;
                  WorldMapType2.method523(var102.payload, var3);
                  if(class155.field2258 != null) {
                     try {
                        class155.field2258.seek(0L);
                        class155.field2258.write(var102.payload, var3, 24);
                     } catch (Exception var57) {
                        ;
                     }
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_185) {
               byte var103;
               if(RUNELITE_PACKET) {
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var103 = secretPacketBuffer2.runeliteReadByte();
               } else {
                  var103 = secretPacketBuffer2.method3268();
                  var3 = secretPacketBuffer2.method3274();
               }

               class211.settings[var3] = var103;
               if(class211.widgetSettings[var3] != var103) {
                  class211.widgetSettings[var3] = var103;
               }

               WidgetNode.method1139(var3);
               field1099[++field1100 - 1 & 31] = var3;
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_109) {
               Actor.field1270 = secretPacketBuffer2.readUnsignedByte();
               class31.field453 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_159) {
               field1129 = secretPacketBuffer2.readUnsignedByte();
               field1018 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_88) {
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

            if(packetType == Opcodes.PACKET_SERVER_90) {
               var2 = secretPacketBuffer2.method3299();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var3 = secretPacketBuffer2.method3277();
               if(field976 != 0 && var2 != -1) {
                  IndexFile.method3094(Renderable.indexTrack2, var2, 0, field976, false);
                  field1151 = true;
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_97) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               if(secretPacketBuffer2.readUnsignedByte() == 0) {
                  grandExchangeOffers[var2] = new GrandExchangeOffer();
                  secretPacketBuffer2.offset += 18;
               } else {
                  --secretPacketBuffer2.offset;
                  grandExchangeOffers[var2] = new GrandExchangeOffer(secretPacketBuffer2, false);
               }

               field1108 = cycleCntr;
               packetType = -1;
               return true;
            }

            long var41;
            if(packetType == Opcodes.PACKET_SERVER_129) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readInt();
               }

               var26 = 0;
               if(class23.field356 == null || !class23.field356.isValid()) {
                  try {
                     Iterator var84 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var84.hasNext()) {
                        GarbageCollectorMXBean var81 = (GarbageCollectorMXBean)var84.next();
                        if(var81.isValid()) {
                           class23.field356 = var81;
                           GameEngine.field724 = -1L;
                           GameEngine.field730 = -1L;
                        }
                     }
                  } catch (Throwable var58) {
                     ;
                  }
               }

               if(class23.field356 != null) {
                  long var37 = class147.currentTimeMs();
                  var39 = class23.field356.getCollectionTime();
                  if(GameEngine.field730 != -1L) {
                     var41 = var39 - GameEngine.field730;
                     long var43 = var37 - GameEngine.field724;
                     if(0L != var43) {
                        var26 = (int)(100L * var41 / var43);
                     }
                  }

                  GameEngine.field730 = var39;
                  GameEngine.field724 = var37;
               }

               secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_228);
               if(RUNELITE_PACKET) {
                  secretPacketBuffer1.runeliteWriteInt(GameEngine.FPS);
                  secretPacketBuffer1.runeliteWriteInt(var26);
                  secretPacketBuffer1.runeliteWriteInt(var2);
                  secretPacketBuffer1.runeliteWriteInt(var3);
               } else {
                  secretPacketBuffer1.method3263(GameEngine.FPS);
                  secretPacketBuffer1.putLEInt(var26);
                  secretPacketBuffer1.putInt(var2);
                  secretPacketBuffer1.putInt(var3);
               }

               packetType = -1;
               return true;
            }

            boolean var66;
            Widget var67;
            if(packetType == Opcodes.PACKET_SERVER_55) {
               var66 = secretPacketBuffer2.method3265() == 1;
               var3 = secretPacketBuffer2.method3283();
               var67 = PacketBuffer.method3528(var3);
               if(var66 != var67.isHidden) {
                  var67.isHidden = var66;
                  class25.method172(var67);
               }

               packetType = -1;
               return true;
            }

            int var34;
            if(packetType == Opcodes.PACKET_SERVER_49) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3272();
                  var3 = secretPacketBuffer2.method3309();
               }

               var23 = var2 >> 10 & 31;
               var26 = var2 >> 5 & 31;
               var25 = var2 & 31;
               var34 = (var26 << 11) + (var23 << 19) + (var25 << 3);
               Widget var109 = PacketBuffer.method3528(var3);
               if(var34 != var109.textColor) {
                  var109.textColor = var34;
                  class25.method172(var109);
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_254) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3309();
                  var3 = secretPacketBuffer2.method3275();
               }

               var67 = PacketBuffer.method3528(var2);
               if(var3 != var67.field2649 || var3 == -1) {
                  var67.field2649 = var3;
                  var67.field2776 = 0;
                  var67.field2781 = 0;
                  class25.method172(var67);
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_153) {
               if(RUNELITE_PACKET) {
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3299();
                  var3 = secretPacketBuffer2.method3309();
               }

               var67 = PacketBuffer.method3528(var3);
               if(var67.modelType != 2 || var2 != var67.modelId) {
                  var67.modelType = 2;
                  var67.modelId = var2;
                  class25.method172(var67);
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_244) {
               if(RUNELITE_PACKET) {
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3272();
                  var3 = secretPacketBuffer2.method3326();
               }

               var67 = PacketBuffer.method3528(var3);
               if(var67.modelType != 1 || var2 != var67.modelId) {
                  var67.modelType = 1;
                  var67.modelId = var2;
                  class25.method172(var67);
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_24) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readUnsignedShort();
               }

               var67 = PacketBuffer.method3528(var2);
               if(var67 != null && var67.type == 0) {
                  if(var3 > var67.scrollHeight - var67.height) {
                     var3 = var67.scrollHeight - var67.height;
                  }

                  if(var3 < 0) {
                     var3 = 0;
                  }

                  if(var3 != var67.scrollY) {
                     var67.scrollY = var3;
                     class25.method172(var67);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_126) {
               Actor.field1270 = secretPacketBuffer2.readUnsignedShortOb1();
               class31.field453 = secretPacketBuffer2.readUnsignedShortOb1();

               for(var2 = class31.field453; var2 < class31.field453 + 8; ++var2) {
                  for(var3 = Actor.field1270; var3 < Actor.field1270 + 8; ++var3) {
                     if(groundItemDeque[class5.plane][var2][var3] != null) {
                        groundItemDeque[class5.plane][var2][var3] = null;
                        class47.groundItemSpawned(var2, var3);
                     }
                  }
               }

               for(PendingSpawn var98 = (PendingSpawn)pendingSpawns.getFront(); var98 != null; var98 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var98.x >= class31.field453 && var98.x < class31.field453 + 8 && var98.y >= Actor.field1270 && var98.y < Actor.field1270 + 8 && var98.level == class5.plane) {
                     var98.hitpoints = 0;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_9) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  var3 = secretPacketBuffer2.method3309();
               }

               class211.settings[var2] = var3;
               if(class211.widgetSettings[var2] != var3) {
                  class211.widgetSettings[var2] = var3;
               }

               WidgetNode.method1139(var2);
               field1099[++field1100 - 1 & 31] = var2;
               packetType = -1;
               return true;
            }

            WidgetNode var5;
            Widget var73;
            if(packetType == Opcodes.PACKET_SERVER_16) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.method3309();
               }

               WidgetNode var91 = (WidgetNode)componentTable.get((long)var2);
               var5 = (WidgetNode)componentTable.get((long)var3);
               if(var5 != null) {
                  PendingSpawn.method1584(var5, var91 == null || var91.id != var5.id);
               }

               if(var91 != null) {
                  var91.unlink();
                  componentTable.put(var91, (long)var3);
               }

               var73 = PacketBuffer.method3528(var2);
               if(var73 != null) {
                  class25.method172(var73);
               }

               var73 = PacketBuffer.method3528(var3);
               if(var73 != null) {
                  class25.method172(var73);
                  BaseVarType.method17(class177.widgets[var73.id >>> 16], var73, true);
               }

               if(widgetRoot != -1) {
                  var34 = widgetRoot;
                  if(class93.loadWidget(var34)) {
                     class251.method4526(class177.widgets[var34], 1);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_14) {
               var66 = secretPacketBuffer2.readUnsignedByte() == 1;
               if(var66) {
                  class51.field675 = class147.currentTimeMs() - secretPacketBuffer2.readLong();
                  class19.field330 = new class13(secretPacketBuffer2, true);
               } else {
                  class19.field330 = null;
               }

               field1109 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_42) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var22 = secretPacketBuffer2.runeliteReadString();
               } else {
                  var2 = secretPacketBuffer2.readInt();
                  var22 = secretPacketBuffer2.readString();
               }

               var67 = PacketBuffer.method3528(var2);
               if(!var22.equals(var67.text)) {
                  var67.text = var22;
                  class25.method172(var67);
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_152) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var23 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  var3 = secretPacketBuffer2.readUnsignedByte();
                  var23 = secretPacketBuffer2.readUnsignedShort();
               }

               WidgetNode.method1140(var2, var3, var23);
               packetType = -1;
               return true;
            }

            Widget var71;
            if(packetType == Opcodes.PACKET_SERVER_64) {
               if(RUNELITE_PACKET) {
                  var23 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  var3 = secretPacketBuffer2.method3272();
                  var23 = secretPacketBuffer2.method3326();
               }

               var71 = PacketBuffer.method3528(var23);
               var71.field2714 = var2 + (var3 << 16);
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_33) {
               if(RUNELITE_PACKET) {
                  var23 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  ItemLayer.method2495();
               } else {
                  ItemLayer.method2495();
                  var2 = secretPacketBuffer2.readUnsignedByte();
                  var3 = secretPacketBuffer2.readUnsignedByte();
                  var23 = secretPacketBuffer2.method3283();
               }

               skillExperiences[var3] = var23;
               boostedSkillLevels[var3] = var2;
               realSkillLevels[var3] = 1;

               for(var26 = 0; var26 < 98; ++var26) {
                  if(var23 >= class222.field2842[var26]) {
                     realSkillLevels[var3] = var26 + 2;
                  }
               }

               field1152[++field1104 - 1 & 31] = var3;
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_188) {
               if(RUNELITE_PACKET) {
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var23 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3275();
                  var3 = secretPacketBuffer2.method3309();
                  var23 = secretPacketBuffer2.readShort();
               }

               var71 = PacketBuffer.method3528(var3);
               if(var23 != var71.originalX || var2 != var71.originalY || var71.field2645 != 0 || var71.field2664 != 0) {
                  var71.originalX = var23;
                  var71.originalY = var2;
                  var71.field2645 = 0;
                  var71.field2664 = 0;
                  class25.method172(var71);
                  this.method1312(var71);
                  if(var71.type == 0) {
                     BaseVarType.method17(class177.widgets[var3 >> 16], var71, false);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_20) {
               var2 = secretPacketBuffer2.method3326();
               var3 = secretPacketBuffer2.method3272();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               var23 = secretPacketBuffer2.method3326();
               var71 = PacketBuffer.method3528(var2);
               ItemComposition var79;
               if(!var71.hasScript) {
                  if(var3 == -1) {
                     var71.modelType = 0;
                     packetType = -1;
                     return true;
                  }

                  var79 = class46.getItemDefinition(var3);
                  var71.modelType = 4;
                  var71.modelId = var3;
                  var71.rotationX = var79.xan2d;
                  var71.rotationZ = var79.yan2d;
                  var71.modelZoom = var79.zoom2d * 100 / var23;
                  class25.method172(var71);
               } else {
                  var71.itemId = var3;
                  var71.itemQuantity = var23;
                  var79 = class46.getItemDefinition(var3);
                  var71.rotationX = var79.xan2d;
                  var71.rotationZ = var79.yan2d;
                  var71.rotationY = var79.zan2d;
                  var71.field2707 = var79.offsetX2d;
                  var71.field2708 = var79.offsetY2d;
                  var71.modelZoom = var79.zoom2d;
                  if(var79.isStackable == 1) {
                     var71.field2716 = 1;
                  } else {
                     var71.field2716 = 2;
                  }

                  if(var71.field2713 > 0) {
                     var71.modelZoom = var71.modelZoom * 32 / var71.field2713;
                  } else if(var71.originalWidth > 0) {
                     var71.modelZoom = var71.modelZoom * 32 / var71.originalWidth;
                  }

                  class25.method172(var71);
               }

               packetType = -1;
               return true;
            }

            int var82;
            if(packetType == Opcodes.PACKET_SERVER_127) {
               if(RUNELITE_PACKET) {
                  var23 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3418();
                  var3 = secretPacketBuffer2.method3272();
                  var23 = secretPacketBuffer2.method3283();
               }

               var5 = (WidgetNode)componentTable.get((long)var23);
               if(var5 != null) {
                  PendingSpawn.method1584(var5, var3 != var5.id);
               }

               WidgetNode var77 = new WidgetNode();
               var77.id = var3;
               var77.owner = var2;
               componentTable.put(var77, (long)var23);
               WorldMapType1.method266(var3);
               Widget var80 = PacketBuffer.method3528(var23);
               class25.method172(var80);
               if(field1077 != null) {
                  class25.method172(field1077);
                  field1077 = null;
               }

               class14.method86();
               BaseVarType.method17(class177.widgets[var23 >> 16], var80, false);
               WorldMapType3.method203(var3);
               if(widgetRoot != -1) {
                  var82 = widgetRoot;
                  if(class93.loadWidget(var82)) {
                     class251.method4526(class177.widgets[var82], 1);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType != 57 && packetType != 40 && packetType != 163 && packetType != 143 && packetType != 44 && packetType != 195 && packetType != 187 && packetType != 23 && packetType != 19) {
               if(packetType == Opcodes.PACKET_SERVER_117) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var4 = secretPacketBuffer2.runeliteReadString();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3418();
                     var3 = secretPacketBuffer2.method3265();
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

               if(packetType == Opcodes.PACKET_SERVER_155) {
                  World var96 = new World();
                  var96.address = secretPacketBuffer2.readString();
                  var96.id = secretPacketBuffer2.readUnsignedShort();
                  var3 = secretPacketBuffer2.readInt();
                  var96.mask = var3;
                  FrameMap.setGameState(45);
                  class268.rssocket.close();
                  class268.rssocket = null;
                  class86.method1775(var96);
                  packetType = -1;
                  return false;
               }

               boolean var99;
               if(packetType == Opcodes.PACKET_SERVER_54) {
                  var24 = secretPacketBuffer2.readString();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  byte var104 = secretPacketBuffer2.readByte();
                  var99 = false;
                  if(var104 == -128) {
                     var99 = true;
                  }

                  if(var99) {
                     if(class21.clanChatCount == 0) {
                        packetType = -1;
                        return true;
                     }

                     boolean var105 = false;

                     for(var25 = 0; var25 < class21.clanChatCount && (!WorldMapType1.clanMembers[var25].username.equals(var24) || var3 != WorldMapType1.clanMembers[var25].world); ++var25) {
                        ;
                     }

                     if(var25 < class21.clanChatCount) {
                        while(var25 < class21.clanChatCount - 1) {
                           WorldMapType1.clanMembers[var25] = WorldMapType1.clanMembers[var25 + 1];
                           ++var25;
                        }

                        --class21.clanChatCount;
                        WorldMapType1.clanMembers[class21.clanChatCount] = null;
                     }
                  } else {
                     secretPacketBuffer2.readString();
                     ClanMember var74 = new ClanMember();
                     var74.username = var24;
                     var74.field910 = class207.method3989(var74.username, class5.field42);
                     var74.world = var3;
                     var74.rank = var104;

                     for(var34 = class21.clanChatCount - 1; var34 >= 0; --var34) {
                        var82 = WorldMapType1.clanMembers[var34].field910.compareTo(var74.field910);
                        if(var82 == 0) {
                           WorldMapType1.clanMembers[var34].world = var3;
                           WorldMapType1.clanMembers[var34].rank = var104;
                           if(var24.equals(AbstractByteBuffer.localPlayer.name)) {
                              Occluder.clanChatRank = var104;
                           }

                           field1107 = cycleCntr;
                           packetType = -1;
                           return true;
                        }

                        if(var82 < 0) {
                           break;
                        }
                     }

                     if(class21.clanChatCount >= WorldMapType1.clanMembers.length) {
                        packetType = -1;
                        return true;
                     }

                     for(var82 = class21.clanChatCount - 1; var82 > var34; --var82) {
                        WorldMapType1.clanMembers[var82 + 1] = WorldMapType1.clanMembers[var82];
                     }

                     if(class21.clanChatCount == 0) {
                        WorldMapType1.clanMembers = new ClanMember[100];
                     }

                     WorldMapType1.clanMembers[var34 + 1] = var74;
                     ++class21.clanChatCount;
                     if(var24.equals(AbstractByteBuffer.localPlayer.name)) {
                        Occluder.clanChatRank = var104;
                     }
                  }

                  field1107 = cycleCntr;
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_70) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var23 = secretPacketBuffer2.runeliteReadInt();
                     var26 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readUnsignedByte();
                     var3 = secretPacketBuffer2.readUnsignedByte();
                     var23 = secretPacketBuffer2.readUnsignedByte();
                     var26 = secretPacketBuffer2.readUnsignedByte();
                  }

                  field1161[var2] = true;
                  field1162[var2] = var3;
                  field1056[var2] = var23;
                  field1164[var2] = var26;
                  field1165[var2] = 0;
                  packetType = -1;
                  return true;
               }

               long var27;
               if(packetType == Opcodes.PACKET_SERVER_72) {
                  var2 = secretPacketBuffer2.method3299();
                  if(var2 == '\uffff') {
                     var2 = -1;
                  }

                  var3 = secretPacketBuffer2.method3283();
                  var23 = secretPacketBuffer2.readInt();
                  var26 = secretPacketBuffer2.method3299();
                  if(var26 == '\uffff') {
                     var26 = -1;
                  }

                  for(var25 = var2; var25 <= var26; ++var25) {
                     var27 = (long)var25 + ((long)var23 << 32);
                     Node var85 = widgetFlags.get(var27);
                     if(var85 != null) {
                        var85.unlink();
                     }

                     widgetFlags.put(new IntegerNode(var3), var27);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_27) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var23 = secretPacketBuffer2.runeliteReadInt();
                     var26 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readInt();
                     var3 = secretPacketBuffer2.method3272();
                     var23 = secretPacketBuffer2.readUnsignedShort();
                     var26 = secretPacketBuffer2.readUnsignedShort();
                  }

                  var73 = PacketBuffer.method3528(var2);
                  if(var23 != var73.rotationX || var3 != var73.rotationZ || var26 != var73.modelZoom) {
                     var73.rotationX = var23;
                     var73.rotationZ = var3;
                     var73.modelZoom = var26;
                     class25.method172(var73);
                  }

                  packetType = -1;
                  return true;
               }

               String var33;
               long var47;
               long var51;
               if(packetType == Opcodes.PACKET_SERVER_37) {
                  var24 = secretPacketBuffer2.readString();
                  var51 = (long)secretPacketBuffer2.readUnsignedShort();
                  var47 = (long)secretPacketBuffer2.read24BitInt();
                  Permission var78 = (Permission)class48.forOrdinal(ClanMember.method1195(), secretPacketBuffer2.readUnsignedByte());
                  var39 = var47 + (var51 << 32);
                  boolean var116 = false;

                  for(var11 = 0; var11 < 100; ++var11) {
                     if(field1132[var11] == var39) {
                        var116 = true;
                        break;
                     }
                  }

                  if(class162.isIgnored(var24)) {
                     var116 = true;
                  }

                  if(!var116 && field1175 == 0) {
                     field1132[field1053] = var39;
                     field1053 = (field1053 + 1) % 100;
                     var112 = FontTypeFace.appendTags(DecorativeObject.method2967(class229.method4204(secretPacketBuffer2)));
                     byte var118;
                     if(var78.field3182) {
                        var118 = 7;
                     } else {
                        var118 = 3;
                     }

                     if(var78.field3181 != -1) {
                        var53 = var78.field3181;
                        var33 = "<img=" + var53 + ">";
                        MessageNode.sendGameMessage(var118, var33 + var24, var112);
                     } else {
                        MessageNode.sendGameMessage(var118, var24, var112);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               boolean var75;
               if(packetType == Opcodes.PACKET_SERVER_100) {
                  var2 = secretPacketBuffer2.getUSmart();
                  var75 = secretPacketBuffer2.readUnsignedByte() == 1;
                  var4 = "";
                  var99 = false;
                  if(var75) {
                     var4 = secretPacketBuffer2.readString();
                     if(class162.isIgnored(var4)) {
                        var99 = true;
                     }
                  }

                  var72 = secretPacketBuffer2.readString();
                  if(!var99) {
                     MessageNode.sendGameMessage(var2, var4, var72);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_144) {
                  var24 = secretPacketBuffer2.readString();
                  Object[] var93 = new Object[var24.length() + 1];

                  for(var23 = var24.length() - 1; var23 >= 0; --var23) {
                     if(var24.charAt(var23) == 115) {
                        var93[var23 + 1] = secretPacketBuffer2.readString();
                     } else {
                        var93[var23 + 1] = new Integer(secretPacketBuffer2.readInt());
                     }
                  }

                  var93[0] = new Integer(secretPacketBuffer2.readInt());
                  ScriptEvent var86 = new ScriptEvent();
                  var86.field846 = var93;
                  CollisionData.method3128(var86);
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_86) {
                  while(secretPacketBuffer2.offset < packetLength) {
                     var2 = secretPacketBuffer2.readUnsignedByte();
                     var75 = (var2 & 1) == 1;
                     var4 = secretPacketBuffer2.readString();
                     var69 = secretPacketBuffer2.readString();
                     secretPacketBuffer2.readString();

                     for(var25 = 0; var25 < ignoreCount; ++var25) {
                        Ignore var76 = ignores[var25];
                        if(var75) {
                           if(var69.equals(var76.name)) {
                              var76.name = var4;
                              var76.previousName = var69;
                              var4 = null;
                              break;
                           }
                        } else if(var4.equals(var76.name)) {
                           var76.name = var4;
                           var76.previousName = var69;
                           var4 = null;
                           break;
                        }
                     }

                     if(var4 != null && ignoreCount < 400) {
                        Ignore var70 = new Ignore();
                        ignores[ignoreCount] = var70;
                        var70.name = var4;
                        var70.previousName = var69;
                        ++ignoreCount;
                     }
                  }

                  field1106 = cycleCntr;
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_11) {
                  field1160 = true;
                  class110.field1656 = secretPacketBuffer2.readUnsignedByte();
                  ItemContainer.field801 = secretPacketBuffer2.readUnsignedByte();
                  class15.field303 = secretPacketBuffer2.readUnsignedShort();
                  class221.field2820 = secretPacketBuffer2.readUnsignedByte();
                  class66.field830 = secretPacketBuffer2.readUnsignedByte();
                  if(class66.field830 >= 100) {
                     class211.cameraX = 64 + class110.field1656 * 128;
                     ChatLineBuffer.cameraY = 64 + ItemContainer.field801 * 128;
                     ScriptState.cameraZ = CacheFile.getTileHeight(class211.cameraX, ChatLineBuffer.cameraY, class5.plane) - class15.field303;
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_180) {
                  field1160 = true;
                  class51.field672 = secretPacketBuffer2.readUnsignedByte();
                  class35.field514 = secretPacketBuffer2.readUnsignedByte();
                  class170.field2359 = secretPacketBuffer2.readUnsignedShort();
                  class181.field2454 = secretPacketBuffer2.readUnsignedByte();
                  class28.field427 = secretPacketBuffer2.readUnsignedByte();
                  if(class28.field427 >= 100) {
                     var2 = 64 + class51.field672 * 128;
                     var3 = 64 + class35.field514 * 128;
                     var23 = CacheFile.getTileHeight(var2, var3, class5.plane) - class170.field2359;
                     var26 = var2 - class211.cameraX;
                     var25 = var23 - ScriptState.cameraZ;
                     var34 = var3 - ChatLineBuffer.cameraY;
                     var82 = (int)Math.sqrt((double)(var26 * var26 + var34 * var34));
                     class9.cameraPitch = (int)(Math.atan2((double)var25, (double)var82) * 325.949D) & 2047;
                     class174.cameraYaw = (int)(Math.atan2((double)var26, (double)var34) * -325.949D) & 2047;
                     if(class9.cameraPitch < 128) {
                        class9.cameraPitch = 128;
                     }

                     if(class9.cameraPitch > 383) {
                        class9.cameraPitch = 383;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               boolean var36;
               if(packetType == Opcodes.PACKET_SERVER_168) {
                  var24 = secretPacketBuffer2.readString();
                  var51 = secretPacketBuffer2.readLong();
                  var47 = (long)secretPacketBuffer2.readUnsignedShort();
                  var27 = (long)secretPacketBuffer2.read24BitInt();
                  Permission var9 = (Permission)class48.forOrdinal(ClanMember.method1195(), secretPacketBuffer2.readUnsignedByte());
                  var41 = (var47 << 32) + var27;
                  var36 = false;

                  for(var13 = 0; var13 < 100; ++var13) {
                     if(field1132[var13] == var41) {
                        var36 = true;
                        break;
                     }
                  }

                  if(var9.field3183 && class162.isIgnored(var24)) {
                     var36 = true;
                  }

                  if(!var36 && field1175 == 0) {
                     field1132[field1053] = var41;
                     field1053 = (field1053 + 1) % 100;
                     String var113 = FontTypeFace.appendTags(DecorativeObject.method2967(class229.method4204(secretPacketBuffer2)));
                     if(var9.field3181 != -1) {
                        var53 = var9.field3181;
                        var33 = "<img=" + var53 + ">";
                        WorldMapType2.addChatMessage(9, var33 + var24, var113, CombatInfo1.method1610(var51));
                     } else {
                        WorldMapType2.addChatMessage(9, var24, var113, CombatInfo1.method1610(var51));
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_197) {
                  field938 = secretPacketBuffer2.readUnsignedByte();
                  if(field938 == 1) {
                     field939 = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(field938 >= 2 && field938 <= 6) {
                     if(field938 == 2) {
                        field944 = 64;
                        field945 = 64;
                     }

                     if(field938 == 3) {
                        field944 = 0;
                        field945 = 64;
                     }

                     if(field938 == 4) {
                        field944 = 128;
                        field945 = 64;
                     }

                     if(field938 == 5) {
                        field944 = 64;
                        field945 = 0;
                     }

                     if(field938 == 6) {
                        field944 = 64;
                        field945 = 128;
                     }

                     field938 = 2;
                     hintArrowX = secretPacketBuffer2.readUnsignedShort();
                     hintArrowY = secretPacketBuffer2.readUnsignedShort();
                     hintArrowType = secretPacketBuffer2.readUnsignedByte();
                  }

                  if(field938 == 10) {
                     field940 = secretPacketBuffer2.readUnsignedShort();
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_89) {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 < -70000) {
                     var3 += '耀';
                  }

                  if(var2 >= 0) {
                     var67 = PacketBuffer.method3528(var2);
                  } else {
                     var67 = null;
                  }

                  if(var67 != null) {
                     for(var26 = 0; var26 < var67.itemIds.length; ++var26) {
                        var67.itemIds[var26] = 0;
                        var67.itemQuantities[var26] = 0;
                     }
                  }

                  ItemContainer var68 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
                  if(var68 != null) {
                     for(var25 = 0; var25 < var68.itemIds.length; ++var25) {
                        var68.itemIds[var25] = -1;
                        var68.stackSizes[var25] = 0;
                     }
                  }

                  var26 = secretPacketBuffer2.readUnsignedShort();

                  for(var25 = 0; var25 < var26; ++var25) {
                     var34 = secretPacketBuffer2.method3272();
                     var82 = secretPacketBuffer2.readUnsignedByte();
                     if(var82 == 255) {
                        var82 = secretPacketBuffer2.readInt();
                     }

                     if(var67 != null && var25 < var67.itemIds.length) {
                        var67.itemIds[var25] = var34;
                        var67.itemQuantities[var25] = var82;
                     }

                     WorldMapData.setItemTableSlot(var3, var25, var34 - 1, var82);
                  }

                  if(var67 != null) {
                     class25.method172(var67);
                  }

                  ItemLayer.method2495();
                  interfaceItemTriggers[++field1102 - 1 & 31] = var3 & 32767;
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_65) {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 < -70000) {
                     var3 += '耀';
                  }

                  if(var2 >= 0) {
                     var67 = PacketBuffer.method3528(var2);
                  } else {
                     var67 = null;
                  }

                  for(; secretPacketBuffer2.offset < packetLength; WorldMapData.setItemTableSlot(var3, var26, var25 - 1, var34)) {
                     var26 = secretPacketBuffer2.getUSmart();
                     var25 = secretPacketBuffer2.readUnsignedShort();
                     var34 = 0;
                     if(var25 != 0) {
                        var34 = secretPacketBuffer2.readUnsignedByte();
                        if(var34 == 255) {
                           var34 = secretPacketBuffer2.readInt();
                        }
                     }

                     if(var67 != null && var26 >= 0 && var26 < var67.itemIds.length) {
                        var67.itemIds[var26] = var25;
                        var67.itemQuantities[var26] = var34;
                     }
                  }

                  if(var67 != null) {
                     class25.method172(var67);
                  }

                  ItemLayer.method2495();
                  interfaceItemTriggers[++field1102 - 1 & 31] = var3 & 32767;
                  packetType = -1;
                  return true;
               }

               boolean var30;
               if(packetType == Opcodes.PACKET_SERVER_115) {
                  field1107 = cycleCntr;
                  if(packetLength == 0) {
                     clanChatOwner = null;
                     clanChatName = null;
                     class21.clanChatCount = 0;
                     WorldMapType1.clanMembers = null;
                     packetType = -1;
                     return true;
                  }

                  clanChatName = secretPacketBuffer2.readString();
                  long var45 = secretPacketBuffer2.readLong();
                  var47 = var45;
                  if(var45 > 0L && var45 < 6582952005840035281L) {
                     if(var45 % 37L == 0L) {
                        var4 = null;
                     } else {
                        var34 = 0;

                        for(var39 = var45; 0L != var39; var39 /= 37L) {
                           ++var34;
                        }

                        StringBuilder var88 = new StringBuilder(var34);

                        while(0L != var47) {
                           long var49 = var47;
                           var47 /= 37L;
                           var88.append(class268.field3678[(int)(var49 - 37L * var47)]);
                        }

                        var4 = var88.reverse().toString();
                     }
                  } else {
                     var4 = null;
                  }

                  clanChatOwner = var4;
                  class46.field618 = secretPacketBuffer2.readByte();
                  var34 = secretPacketBuffer2.readUnsignedByte();
                  if(var34 == 255) {
                     packetType = -1;
                     return true;
                  }

                  class21.clanChatCount = var34;
                  ClanMember[] var108 = new ClanMember[100];

                  for(var107 = 0; var107 < class21.clanChatCount; ++var107) {
                     var108[var107] = new ClanMember();
                     var108[var107].username = secretPacketBuffer2.readString();
                     var108[var107].field910 = class207.method3989(var108[var107].username, class5.field42);
                     var108[var107].world = secretPacketBuffer2.readUnsignedShort();
                     var108[var107].rank = secretPacketBuffer2.readByte();
                     secretPacketBuffer2.readString();
                     if(var108[var107].username.equals(AbstractByteBuffer.localPlayer.name)) {
                        Occluder.clanChatRank = var108[var107].rank;
                     }
                  }

                  var30 = false;
                  var11 = class21.clanChatCount;

                  while(var11 > 0) {
                     var30 = true;
                     --var11;

                     for(var117 = 0; var117 < var11; ++var117) {
                        if(var108[var117].field910.compareTo(var108[var117 + 1].field910) > 0) {
                           ClanMember var89 = var108[var117];
                           var108[var117] = var108[var117 + 1];
                           var108[var117 + 1] = var89;
                           var30 = false;
                        }
                     }

                     if(var30) {
                        break;
                     }
                  }

                  WorldMapType1.clanMembers = var108;
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_17) {
                  var2 = packetLength + secretPacketBuffer2.offset;
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  var23 = secretPacketBuffer2.readUnsignedShort();
                  if(var3 != widgetRoot) {
                     widgetRoot = var3;
                     this.method1213(false);
                     WorldMapType1.method266(widgetRoot);
                     WorldMapType3.method203(widgetRoot);

                     for(var26 = 0; var26 < 100; ++var26) {
                        field1118[var26] = true;
                     }
                  }

                  WidgetNode var106;
                  for(; var23-- > 0; var106.field836 = true) {
                     var26 = secretPacketBuffer2.readInt();
                     var25 = secretPacketBuffer2.readUnsignedShort();
                     var34 = secretPacketBuffer2.readUnsignedByte();
                     var106 = (WidgetNode)componentTable.get((long)var26);
                     if(var106 != null && var25 != var106.id) {
                        PendingSpawn.method1584(var106, true);
                        var106 = null;
                     }

                     if(var106 == null) {
                        WidgetNode var87 = new WidgetNode();
                        var87.id = var25;
                        var87.owner = var34;
                        componentTable.put(var87, (long)var26);
                        WorldMapType1.method266(var25);
                        Widget var110 = PacketBuffer.method3528(var26);
                        class25.method172(var110);
                        if(field1077 != null) {
                           class25.method172(field1077);
                           field1077 = null;
                        }

                        class14.method86();
                        BaseVarType.method17(class177.widgets[var26 >> 16], var110, false);
                        WorldMapType3.method203(var25);
                        if(widgetRoot != -1) {
                           var117 = widgetRoot;
                           if(class93.loadWidget(var117)) {
                              class251.method4526(class177.widgets[var117], 1);
                           }
                        }

                        var106 = var87;
                     }
                  }

                  for(var5 = (WidgetNode)componentTable.method3646(); var5 != null; var5 = (WidgetNode)componentTable.method3647()) {
                     if(var5.field836) {
                        var5.field836 = false;
                     } else {
                        PendingSpawn.method1584(var5, true);
                     }
                  }

                  widgetFlags = new HashTable(512);

                  while(secretPacketBuffer2.offset < var2) {
                     var26 = secretPacketBuffer2.readInt();
                     var25 = secretPacketBuffer2.readUnsignedShort();
                     var34 = secretPacketBuffer2.readUnsignedShort();
                     var82 = secretPacketBuffer2.readInt();

                     for(var107 = var25; var107 <= var34; ++var107) {
                        var41 = ((long)var26 << 32) + (long)var107;
                        widgetFlags.put(new IntegerNode(var82), var41);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_18) {
                  while(secretPacketBuffer2.offset < packetLength) {
                     var66 = secretPacketBuffer2.readUnsignedByte() == 1;
                     var22 = secretPacketBuffer2.readString();
                     var4 = secretPacketBuffer2.readString();
                     var26 = secretPacketBuffer2.readUnsignedShort();
                     var25 = secretPacketBuffer2.readUnsignedByte();
                     var34 = secretPacketBuffer2.readUnsignedByte();
                     boolean var8 = (var34 & 2) != 0;
                     var30 = (var34 & 1) != 0;
                     if(var26 > 0) {
                        secretPacketBuffer2.readString();
                        secretPacketBuffer2.readUnsignedByte();
                        secretPacketBuffer2.readInt();
                     }

                     secretPacketBuffer2.readString();

                     for(var35 = 0; var35 < friendCount; ++var35) {
                        Friend var31 = friends[var35];
                        if(!var66) {
                           if(var22.equals(var31.name)) {
                              if(var26 != var31.world) {
                                 var36 = true;

                                 for(class66 var32 = (class66)field998.method3745(); var32 != null; var32 = (class66)field998.method3751()) {
                                    if(var32.field829.equals(var22)) {
                                       if(var26 != 0 && var32.field828 == 0) {
                                          var32.method3757();
                                          var36 = false;
                                       } else if(var26 == 0 && var32.field828 != 0) {
                                          var32.method3757();
                                          var36 = false;
                                       }
                                    }
                                 }

                                 if(var36) {
                                    field998.method3754(new class66(var22, var26));
                                 }

                                 var31.world = var26;
                              }

                              var31.previousName = var4;
                              var31.rank = var25;
                              var31.field823 = var8;
                              var31.field825 = var30;
                              var22 = null;
                              break;
                           }
                        } else if(var4.equals(var31.name)) {
                           var31.name = var22;
                           var31.previousName = var4;
                           var22 = null;
                           break;
                        }
                     }

                     if(var22 != null && friendCount < 400) {
                        Friend var10 = new Friend();
                        friends[friendCount] = var10;
                        var10.name = var22;
                        var10.previousName = var4;
                        var10.world = var26;
                        var10.rank = var25;
                        var10.field823 = var8;
                        var10.field825 = var30;
                        ++friendCount;
                     }
                  }

                  field1180 = 2;
                  field1106 = cycleCntr;
                  var66 = false;
                  var3 = friendCount;

                  while(var3 > 0) {
                     var66 = true;
                     --var3;

                     for(var23 = 0; var23 < var3; ++var23) {
                        var99 = false;
                        Friend var6 = friends[var23];
                        Friend var7 = friends[var23 + 1];
                        if(var6.world != world && var7.world == world) {
                           var99 = true;
                        }

                        if(!var99 && var6.world == 0 && var7.world != 0) {
                           var99 = true;
                        }

                        if(!var99 && !var6.field823 && var7.field823) {
                           var99 = true;
                        }

                        if(!var99 && !var6.field825 && var7.field825) {
                           var99 = true;
                        }

                        if(var99) {
                           Friend var29 = friends[var23];
                           friends[var23] = friends[var23 + 1];
                           friends[var23 + 1] = var29;
                           var66 = false;
                        }
                     }

                     if(var66) {
                        break;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_150) {
                  class86.xteaChanged(false);
                  secretPacketBuffer2.readOpcode();
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  class36.method487(secretPacketBuffer2, var2);
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_148) {
                  class86.xteaChanged(true);
                  secretPacketBuffer2.readOpcode();
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  class36.method487(secretPacketBuffer2, var2);
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_108) {
                  class270.method4974(true);
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_76) {
                  class270.method4974(false);
                  packetType = -1;
                  return true;
               }

               if(packetType != Opcodes.PACKET_SERVER_178) {
                  if(packetType == Opcodes.PACKET_SERVER_104) {
                     class31.field453 = secretPacketBuffer2.readUnsignedShortOb1();
                     Actor.field1270 = secretPacketBuffer2.method3418();

                     while(secretPacketBuffer2.offset < packetLength) {
                        packetType = secretPacketBuffer2.readUnsignedByte();
                        class41.method592();
                     }

                     packetType = -1;
                     return true;
                  }

                  DynamicObject.method1932("" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength, (Throwable)null);
                  class181.method3546();
                  return true;
               }
            }

            class41.method592();
            packetType = -1;
            return true;
         } catch (IOException var64) {
            IndexFile.method3106();
         } catch (Exception var65) {
            var24 = "" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength + "," + (AbstractByteBuffer.localPlayer.pathX[0] + WallObject.baseX) + "," + (AbstractByteBuffer.localPlayer.pathY[0] + Varcs.baseY) + ",";

            for(var3 = 0; var3 < packetLength && var3 < 50; ++var3) {
               var24 = var24 + secretPacketBuffer2.payload[var3] + ",";
            }

            DynamicObject.method1932(var24, var65);
            class181.method3546();
         }

         return true;
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1234976950"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();

      while(true) {
         Deque var2 = class236.field3237;
         FileSystem var1;
         synchronized(class236.field3237) {
            var1 = (FileSystem)class236.field3233.popFront();
         }

         if(var1 == null) {
            int var43;
            try {
               if(class203.field2521 == 1) {
                  var43 = class203.field2523.method3865();
                  if(var43 > 0 && class203.field2523.method3870()) {
                     var43 -= class288.field3814;
                     if(var43 < 0) {
                        var43 = 0;
                     }

                     class203.field2523.method3797(var43);
                  } else {
                     class203.field2523.method3803();
                     class203.field2523.method3824();
                     if(class203.field2522 != null) {
                        class203.field2521 = 2;
                     } else {
                        class203.field2521 = 0;
                     }

                     class35.field516 = null;
                     class203.field2524 = null;
                  }
               }
            } catch (Exception var53) {
               var53.printStackTrace();
               class203.field2523.method3803();
               class203.field2521 = 0;
               class35.field516 = null;
               class203.field2524 = null;
               class203.field2522 = null;
            }

            class28.method234();
            KeyFocusListener var54 = KeyFocusListener.keyboard;
            int var44;
            synchronized(KeyFocusListener.keyboard) {
               ++KeyFocusListener.keyboardIdleTicks;
               KeyFocusListener.field666 = KeyFocusListener.field665;
               KeyFocusListener.field662 = 0;
               if(KeyFocusListener.field654 >= 0) {
                  while(KeyFocusListener.field657 != KeyFocusListener.field654) {
                     var44 = KeyFocusListener.field656[KeyFocusListener.field657];
                     KeyFocusListener.field657 = KeyFocusListener.field657 + 1 & 127;
                     if(var44 < 0) {
                        KeyFocusListener.field655[~var44] = false;
                     } else {
                        if(!KeyFocusListener.field655[var44] && KeyFocusListener.field662 < KeyFocusListener.field658.length - 1) {
                           KeyFocusListener.field658[++KeyFocusListener.field662 - 1] = var44;
                        }

                        KeyFocusListener.field655[var44] = true;
                     }
                  }
               } else {
                  for(var44 = 0; var44 < 112; ++var44) {
                     KeyFocusListener.field655[var44] = false;
                  }

                  KeyFocusListener.field654 = KeyFocusListener.field657;
               }

               if(KeyFocusListener.field662 > 0) {
                  KeyFocusListener.keyboardIdleTicks = 0;
               }

               KeyFocusListener.field665 = KeyFocusListener.field664;
            }

            MouseInput var55 = MouseInput.mouse;
            synchronized(MouseInput.mouse) {
               MouseInput.field738 = MouseInput.field740 * -1698716909;
               MouseInput.field745 = MouseInput.mouseX;
               MouseInput.field746 = MouseInput.mouseY;
               MouseInput.field741 = MouseInput.field749;
               MouseInput.field752 = MouseInput.field748;
               MouseInput.field753 = MouseInput.field737;
               MouseInput.field754 = MouseInput.field750;
               MouseInput.field749 = 0;
            }

            if(WorldMapType3.field396 != null) {
               var43 = WorldMapType3.field396.vmethod3053();
               field1111 = var43;
            }

            if(gameState == 0) {
               class96.load();
               class21.method150();
            } else if(gameState == 5) {
               ItemLayer.method2496(this);
               class96.load();
               class21.method150();
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  ItemLayer.method2496(this);
                  this.method1209();
               } else if(gameState == 25) {
                  class29.flush(false);
                  field982 = 0;
                  boolean var57 = true;

                  for(var44 = 0; var44 < class37.field529.length; ++var44) {
                     if(BuildType.field3191[var44] != -1 && class37.field529[var44] == null) {
                        class37.field529[var44] = class226.indexMaps.getConfigData(BuildType.field3191[var44], 0);
                        if(class37.field529[var44] == null) {
                           var57 = false;
                           ++field982;
                        }
                     }

                     if(landRegionFielIds[var44] != -1 && class12.field277[var44] == null) {
                        class12.field277[var44] = class226.indexMaps.getConfigData(landRegionFielIds[var44], 0, class37.xteaKeys[var44]);
                        if(class12.field277[var44] == null) {
                           var57 = false;
                           ++field982;
                        }
                     }
                  }

                  if(!var57) {
                     field1031 = 1;
                  } else {
                     field980 = 0;
                     var57 = true;

                     int var4;
                     int var5;
                     for(var44 = 0; var44 < class37.field529.length; ++var44) {
                        byte[] var3 = class12.field277[var44];
                        if(var3 != null) {
                           var4 = (CombatInfo1.mapRegions[var44] >> 8) * 64 - WallObject.baseX;
                           var5 = (CombatInfo1.mapRegions[var44] & 255) * 64 - Varcs.baseY;
                           if(isDynamicRegion) {
                              var4 = 10;
                              var5 = 10;
                           }

                           var57 &= IndexFile.method3107(var3, var4, var5);
                        }
                     }

                     if(!var57) {
                        field1031 = 2;
                     } else {
                        if(field1031 != 0) {
                           class14.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        class28.method234();
                        WorldMapType1.method264();
                        class28.method234();
                        class8.region.reset();
                        class28.method234();
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

                        class28.method234();
                        class61.field773 = 99;
                        class61.underlayIds = new byte[4][104][104];
                        class61.overlayIds = new byte[4][104][104];
                        class277.overlayPaths = new byte[4][104][104];
                        class61.overlayRotations = new byte[4][104][104];
                        class168.field2350 = new int[4][105][105];
                        class174.field2411 = new byte[4][105][105];
                        class60.field762 = new int[105][105];
                        class170.blendedHue = new int[104];
                        class35.blendedSaturation = new int[104];
                        class10.field262 = new int[104];
                        class61.field769 = new int[104];
                        Huffman.field2332 = new int[104];
                        var44 = class37.field529.length;

                        for(class80 var56 = (class80)class80.field1324.getFront(); var56 != null; var56 = (class80)class80.field1324.getNext()) {
                           if(var56.field1313 != null) {
                              CombatInfoListHolder.field1364.method1949(var56.field1313);
                              var56.field1313 = null;
                           }

                           if(var56.field1315 != null) {
                              CombatInfoListHolder.field1364.method1949(var56.field1315);
                              var56.field1315 = null;
                           }
                        }

                        class80.field1324.clear();
                        class29.flush(true);
                        int var46;
                        if(!isDynamicRegion) {
                           byte[] var6;
                           for(var45 = 0; var45 < var44; ++var45) {
                              var4 = (CombatInfo1.mapRegions[var45] >> 8) * 64 - WallObject.baseX;
                              var5 = (CombatInfo1.mapRegions[var45] & 255) * 64 - Varcs.baseY;
                              var6 = class37.field529[var45];
                              if(var6 != null) {
                                 class28.method234();
                                 class56.method849(var6, var4, var5, class43.field589 * 8 - 48, Signlink.field2245 * 8 - 48, collisionMaps);
                              }
                           }

                           for(var45 = 0; var45 < var44; ++var45) {
                              var4 = (CombatInfo1.mapRegions[var45] >> 8) * 64 - WallObject.baseX;
                              var5 = (CombatInfo1.mapRegions[var45] & 255) * 64 - Varcs.baseY;
                              var6 = class37.field529[var45];
                              if(var6 == null && Signlink.field2245 < 800) {
                                 class28.method234();
                                 class54.method812(var4, var5, 64, 64);
                              }
                           }

                           class29.flush(true);

                           for(var45 = 0; var45 < var44; ++var45) {
                              byte[] var48 = class12.field277[var45];
                              if(var48 != null) {
                                 var5 = (CombatInfo1.mapRegions[var45] >> 8) * 64 - WallObject.baseX;
                                 var46 = (CombatInfo1.mapRegions[var45] & 255) * 64 - Varcs.baseY;
                                 class28.method234();
                                 FileOnDisk.method2466(var48, var5, var46, class8.region, collisionMaps);
                              }
                           }
                        }

                        int var7;
                        int var8;
                        int var9;
                        if(isDynamicRegion) {
                           var45 = 0;

                           label497:
                           while(true) {
                              int var10;
                              int var11;
                              int var12;
                              if(var45 >= 4) {
                                 for(var45 = 0; var45 < 13; ++var45) {
                                    for(var4 = 0; var4 < 13; ++var4) {
                                       var5 = field986[0][var45][var4];
                                       if(var5 == -1) {
                                          class54.method812(var45 * 8, var4 * 8, 8, 8);
                                       }
                                    }
                                 }

                                 class29.flush(true);
                                 var45 = 0;

                                 while(true) {
                                    if(var45 >= 4) {
                                       break label497;
                                    }

                                    class28.method234();

                                    for(var4 = 0; var4 < 13; ++var4) {
                                       label454:
                                       for(var5 = 0; var5 < 13; ++var5) {
                                          var46 = field986[var45][var4][var5];
                                          if(var46 != -1) {
                                             var7 = var46 >> 24 & 3;
                                             var8 = var46 >> 1 & 3;
                                             var9 = var46 >> 14 & 1023;
                                             var10 = var46 >> 3 & 2047;
                                             var11 = (var9 / 8 << 8) + var10 / 8;

                                             for(var12 = 0; var12 < CombatInfo1.mapRegions.length; ++var12) {
                                                if(CombatInfo1.mapRegions[var12] == var11 && class12.field277[var12] != null) {
                                                   byte[] var47 = class12.field277[var12];
                                                   int var14 = var4 * 8;
                                                   int var15 = var5 * 8;
                                                   int var16 = (var9 & 7) * 8;
                                                   int var17 = (var10 & 7) * 8;
                                                   Region var18 = class8.region;
                                                   CollisionData[] var19 = collisionMaps;
                                                   Buffer var20 = new Buffer(var47);
                                                   int var21 = -1;

                                                   while(true) {
                                                      int var22 = var20.getUSmart();
                                                      if(var22 == 0) {
                                                         continue label454;
                                                      }

                                                      var21 += var22;
                                                      int var23 = 0;

                                                      while(true) {
                                                         int var24 = var20.getUSmart();
                                                         if(var24 == 0) {
                                                            break;
                                                         }

                                                         var23 += var24 - 1;
                                                         int var25 = var23 & 63;
                                                         int var26 = var23 >> 6 & 63;
                                                         int var27 = var23 >> 12;
                                                         int var28 = var20.readUnsignedByte();
                                                         int var29 = var28 >> 2;
                                                         int var30 = var28 & 3;
                                                         if(var7 == var27 && var26 >= var16 && var26 < var16 + 8 && var25 >= var17 && var25 < var17 + 8) {
                                                            ObjectComposition var31 = Occluder.getObjectDefinition(var21);
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

                                                            var39 = var14 + var33;
                                                            int var40 = var15 + class207.method3999(var26 & 7, var25 & 7, var8, var31.sizeX, var31.sizeY, var30);
                                                            if(var39 > 0 && var40 > 0 && var39 < 103 && var40 < 103) {
                                                               int var41 = var45;
                                                               if((class61.tileSettings[1][var39][var40] & 2) == 2) {
                                                                  var41 = var45 - 1;
                                                               }

                                                               CollisionData var42 = null;
                                                               if(var41 >= 0) {
                                                                  var42 = var19[var41];
                                                               }

                                                               World.addObject(var45, var39, var40, var21, var8 + var30 & 3, var29, var18, var42);
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

                              class28.method234();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    boolean var58 = false;
                                    var7 = field986[var45][var4][var5];
                                    if(var7 != -1) {
                                       var8 = var7 >> 24 & 3;
                                       var9 = var7 >> 1 & 3;
                                       var10 = var7 >> 14 & 1023;
                                       var11 = var7 >> 3 & 2047;
                                       var12 = (var10 / 8 << 8) + var11 / 8;

                                       for(int var13 = 0; var13 < CombatInfo1.mapRegions.length; ++var13) {
                                          if(CombatInfo1.mapRegions[var13] == var12 && class37.field529[var13] != null) {
                                             ISAACCipher.method3540(class37.field529[var13], var45, var4 * 8, var5 * 8, var8, (var10 & 7) * 8, (var11 & 7) * 8, var9, collisionMaps);
                                             var58 = true;
                                             break;
                                          }
                                       }
                                    }

                                    if(!var58) {
                                       BaseVarType.method16(var45, var4 * 8, var5 * 8);
                                    }
                                 }
                              }

                              ++var45;
                           }
                        }

                        class29.flush(true);
                        WorldMapType1.method264();
                        class28.method234();
                        class36.method490(class8.region, collisionMaps);
                        class29.flush(true);
                        var45 = class61.field773;
                        if(var45 > class5.plane) {
                           var45 = class5.plane;
                        }

                        if(var45 < class5.plane - 1) {
                           var45 = class5.plane - 1;
                        }

                        if(lowMemory) {
                           class8.region.setup(class61.field773);
                        } else {
                           class8.region.setup(0);
                        }

                        for(var4 = 0; var4 < 104; ++var4) {
                           for(var5 = 0; var5 < 104; ++var5) {
                              class47.groundItemSpawned(var4, var5);
                           }
                        }

                        class28.method234();
                        DynamicObject.method1928();
                        ObjectComposition.field3484.reset();
                        if(PendingSpawn.clientInstance.method904()) {
                           secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_64);
                           if(RUNELITE_PACKET) {
                              secretPacketBuffer1.runeliteWriteInt(1057001181);
                           } else {
                              secretPacketBuffer1.putInt(1057001181);
                           }
                        }

                        if(!isDynamicRegion) {
                           var4 = (class43.field589 - 6) / 8;
                           var5 = (class43.field589 + 6) / 8;
                           var46 = (Signlink.field2245 - 6) / 8;
                           var7 = (Signlink.field2245 + 6) / 8;

                           for(var8 = var4 - 1; var8 <= var5 + 1; ++var8) {
                              for(var9 = var46 - 1; var9 <= var7 + 1; ++var9) {
                                 if(var8 < var4 || var8 > var5 || var9 < var46 || var9 > var7) {
                                    class226.indexMaps.method4268("m" + var8 + "_" + var9);
                                    class226.indexMaps.method4268("l" + var8 + "_" + var9);
                                 }
                              }
                           }
                        }

                        FrameMap.setGameState(30);
                        class28.method234();
                        class61.underlayIds = null;
                        class61.overlayIds = null;
                        class277.overlayPaths = null;
                        class61.overlayRotations = null;
                        class168.field2350 = null;
                        class174.field2411 = null;
                        class60.field762 = null;
                        class170.blendedHue = null;
                        class35.blendedSaturation = null;
                        class10.field262 = null;
                        class61.field769 = null;
                        Huffman.field2332 = null;
                        secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_REGION_CHANGED);
                        class21.method150();
                     }
                  }
               }
            } else {
               ItemLayer.method2496(this);
            }

            if(gameState == 30) {
               this.method1210();
            } else if(gameState == 40 || gameState == 45) {
               this.method1209();
            }

            return;
         }

         var1.data.method4319(var1.index, (int)var1.hash, var1.field3203, false);
      }
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "51"
   )
   void method1208() {
      if(class238.field3257 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class238.field3271 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field1148 = 3000;
            class238.field3271 = 3;
         }

         if(--field1148 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  class277.socket = GameEngine.taskManager.createSocket(GameEngine.host, class18.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(class277.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(class277.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  class61.rssocket = new RSSocket((Socket)class277.socket.value, GameEngine.taskManager);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(155);
                  class61.rssocket.queueForWrite(var1.payload, 0, 5);
                  ++js5State;
                  WidgetNode.field838 = class147.currentTimeMs();
               }

               if(js5State == 3) {
                  if(gameState > 5 && class61.rssocket.available() <= 0) {
                     if(class147.currentTimeMs() - WidgetNode.field838 > 30000L) {
                        this.error(-2);
                        return;
                     }
                  } else {
                     int var5 = class61.rssocket.readByte();
                     if(var5 != 0) {
                        this.error(var5);
                        return;
                     }

                     ++js5State;
                  }
               }

               if(js5State == 4) {
                  RSSocket var10 = class61.rssocket;
                  boolean var2 = gameState > 20;
                  if(class238.field3265 != null) {
                     try {
                        class238.field3265.close();
                     } catch (Exception var8) {
                        ;
                     }

                     class238.field3265 = null;
                  }

                  class238.field3265 = var10;
                  IndexDataBase.sendConInfo(var2);
                  class238.field3270.offset = 0;
                  class238.currentRequest = null;
                  RSCanvas.field678 = null;
                  class238.field3266 = 0;

                  while(true) {
                     FileRequest var3 = (FileRequest)class238.field3256.method3646();
                     if(var3 == null) {
                        while(true) {
                           var3 = (FileRequest)class238.field3261.method3646();
                           if(var3 == null) {
                              if(class238.field3269 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.putByte(4);
                                    var11.putByte(class238.field3269);
                                    var11.putShort(0);
                                    class238.field3265.queueForWrite(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class238.field3265.close();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class238.field3271;
                                    class238.field3265 = null;
                                 }
                              }

                              class238.field3252 = 0;
                              class238.field3268 = class147.currentTimeMs();
                              class277.socket = null;
                              class61.rssocket = null;
                              js5State = 0;
                              field958 = 0;
                              return;
                           }

                           class238.field3258.setHead(var3);
                           class238.field3259.put(var3, var3.hash);
                           ++class238.field3254;
                           --class238.field3262;
                        }
                     }

                     class238.field3251.put(var3, var3.hash);
                     ++class238.field3255;
                     --class238.field3253;
                  }
               }
            } catch (IOException var9) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-690277715"
   )
   final void method1365() {
      int var1;
      if(widgetRoot != -1) {
         var1 = widgetRoot;
         if(class93.loadWidget(var1)) {
            class39.method537(class177.widgets[var1], -1);
         }
      }

      for(var1 = 0; var1 < field1116; ++var1) {
         if(field1118[var1]) {
            field1119[var1] = true;
         }

         field1034[var1] = field1118[var1];
         field1118[var1] = false;
      }

      field1117 = gameCycle;
      field1029 = -1;
      field1063 = -1;
      Timer.field2270 = null;
      if(widgetRoot != -1) {
         field1116 = 0;
         BaseVarType.method13(widgetRoot, 0, 0, class60.canvasWidth, class48.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      int var2;
      int var3;
      int var4;
      int var6;
      int var7;
      int var8;
      if(!isMenuOpen) {
         if(field1029 != -1) {
            class81.method1726(field1029, field1063);
         }
      } else {
         var1 = class54.menuX;
         var2 = class10.menuY;
         var3 = class20.menuWidth;
         var4 = class28.menuHeight;
         int var5 = 6116423;
         Rasterizer2D.method5129(var1, var2, var3, var4, var5);
         Rasterizer2D.method5129(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
         Friend.field827.method4840("Choose Option", var1 + 3, var2 + 14, var5, -1);
         var6 = MouseInput.field745;
         var7 = MouseInput.field746;

         int var9;
         int var10;
         for(var8 = 0; var8 < menuOptionCount; ++var8) {
            var9 = var2 + 31 + (menuOptionCount - 1 - var8) * 15;
            var10 = 16777215;
            if(var6 > var1 && var6 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
               var10 = 16776960;
            }

            Friend.field827.method4840(class87.method1776(var8), var1 + 3, var9, var10, 0);
         }

         var8 = class54.menuX;
         var9 = class10.menuY;
         var10 = class20.menuWidth;
         int var11 = class28.menuHeight;

         for(int var12 = 0; var12 < field1116; ++var12) {
            if(widgetBoundsWidth[var12] + widgetPositionX[var12] > var8 && widgetPositionX[var12] < var10 + var8 && widgetBoundsHeight[var12] + widgetPositionY[var12] > var9 && widgetPositionY[var12] < var11 + var9) {
               field1119[var12] = true;
            }
         }
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < field1116; ++var1) {
            if(field1034[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1119[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = class5.plane;
      var2 = AbstractByteBuffer.localPlayer.x;
      var3 = AbstractByteBuffer.localPlayer.y;
      var4 = field1122;

      for(class80 var13 = (class80)class80.field1324.getFront(); var13 != null; var13 = (class80)class80.field1324.getNext()) {
         if(var13.field1318 != -1 || var13.field1322 != null) {
            var6 = 0;
            if(var2 > var13.field1319) {
               var6 += var2 - var13.field1319;
            } else if(var2 < var13.field1311) {
               var6 += var13.field1311 - var2;
            }

            if(var3 > var13.field1316) {
               var6 += var3 - var13.field1316;
            } else if(var3 < var13.field1326) {
               var6 += var13.field1326 - var3;
            }

            if(var6 - 64 <= var13.field1317 && field1114 != 0 && var1 == var13.field1312) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = (var13.field1317 - var6) * field1114 / var13.field1317;
               Object var10000;
               if(var13.field1313 == null) {
                  if(var13.field1318 >= 0) {
                     var10000 = null;
                     SoundEffect var14 = SoundEffect.getTrack(BaseVarType.field34, var13.field1318, 0);
                     if(var14 != null) {
                        class105 var15 = var14.method2011().method2053(Renderable.field2113);
                        class115 var16 = class115.method2201(var15, 100, var7);
                        var16.method2346(-1);
                        CombatInfoListHolder.field1364.method1979(var16);
                        var13.field1313 = var16;
                     }
                  }
               } else {
                  var13.field1313.method2205(var7);
               }

               if(var13.field1315 == null) {
                  if(var13.field1322 != null && (var13.field1323 -= var4) <= 0) {
                     var8 = (int)(Math.random() * (double)var13.field1322.length);
                     var10000 = null;
                     SoundEffect var18 = SoundEffect.getTrack(BaseVarType.field34, var13.field1322[var8], 0);
                     if(var18 != null) {
                        class105 var19 = var18.method2011().method2053(Renderable.field2113);
                        class115 var17 = class115.method2201(var19, 100, var7);
                        var17.method2346(0);
                        CombatInfoListHolder.field1364.method1979(var17);
                        var13.field1315 = var17;
                        var13.field1323 = var13.field1320 + (int)(Math.random() * (double)(var13.field1321 - var13.field1320));
                     }
                  }
               } else {
                  var13.field1315.method2205(var7);
                  if(!var13.field1315.linked()) {
                     var13.field1315 = null;
                  }
               }
            } else {
               if(var13.field1313 != null) {
                  CombatInfoListHolder.field1364.method1949(var13.field1313);
                  var13.field1313 = null;
               }

               if(var13.field1315 != null) {
                  CombatInfoListHolder.field1364.method1949(var13.field1315);
                  var13.field1315 = null;
               }
            }
         }
      }

      field1122 = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2051276775"
   )
   protected final void vmethod1211() {
      field1126 = class147.currentTimeMs() + 500L;
      this.method1297();
      if(widgetRoot != -1) {
         this.method1213(true);
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-87"
   )
   @Hook("clientMainLoop")
   protected final void vmethod1205(boolean var1) {
      boolean var2 = DynamicObject.method1934();
      if(var2 && field1151 && class1.soundSystem0 != null) {
         class1.soundSystem0.method2086();
      }

      if((gameState == 10 || gameState == 20 || gameState == 30) && field1126 != 0L && class147.currentTimeMs() > field1126) {
         Friend.method1135(class19.method142());
      }

      int var3;
      if(var1) {
         for(var3 = 0; var3 < 100; ++var3) {
            field1118[var3] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class90.loadingBarPercentage, class90.loadingText, var1);
      } else if(gameState == 5) {
         PendingSpawn.drawLoginScreen(Friend.field827, class9.field257, class20.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            PendingSpawn.drawLoginScreen(Friend.field827, class9.field257, class20.font_p12full, var1);
         } else if(gameState == 25) {
            if(field1031 == 1) {
               if(field982 > field979) {
                  field979 = field982;
               }

               var3 = (field979 * 50 - field982 * 50) / field979;
               class14.drawStatusBox("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else if(field1031 == 2) {
               if(field980 > field1173) {
                  field1173 = field980;
               }

               var3 = 50 + (field1173 * 50 - field980 * 50) / field1173;
               class14.drawStatusBox("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else {
               class14.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1365();
         } else if(gameState == 40) {
            class14.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class14.drawStatusBox("Please wait...", false);
         }
      } else {
         PendingSpawn.drawLoginScreen(Friend.field827, class9.field257, class20.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var3 = 0; var3 < field1116; ++var3) {
            if(field1119[var3]) {
               class12.field275.vmethod5133(widgetPositionX[var3], widgetPositionY[var3], widgetBoundsWidth[var3], widgetBoundsHeight[var3]);
               field1119[var3] = false;
            }
         }
      } else if(gameState > 0) {
         class12.field275.vmethod5136(0, 0);

         for(var3 = 0; var3 < field1116; ++var3) {
            field1119[var3] = false;
         }
      }

   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-34"
   )
   final void method1209() {
      try {
         if(loginState == 0) {
            if(class268.rssocket != null) {
               class268.rssocket.close();
               class268.rssocket = null;
            }

            class51.field671 = null;
            socketError = false;
            field1030 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(class51.field671 == null) {
               class51.field671 = GameEngine.taskManager.createSocket(GameEngine.host, class18.myWorldPort);
            }

            if(class51.field671.status == 2) {
               throw new IOException();
            }

            if(class51.field671.status == 1) {
               class268.rssocket = new RSSocket((Socket)class51.field671.value, GameEngine.taskManager);
               class51.field671 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(14);
            class268.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, 1);
            secretPacketBuffer2.offset = 0;
            loginState = 3;
         }

         int var1;
         if(loginState == 3) {
            if(class1.soundSystem0 != null) {
               class1.soundSystem0.method2117();
            }

            if(class40.soundSystem1 != null) {
               class40.soundSystem1.method2117();
            }

            var1 = class268.rssocket.readByte();
            if(class1.soundSystem0 != null) {
               class1.soundSystem0.method2117();
            }

            if(class40.soundSystem1 != null) {
               class40.soundSystem1.method2117();
            }

            if(var1 != 0) {
               class236.method4311(var1);
               return;
            }

            secretPacketBuffer2.offset = 0;
            loginState = 4;
         }

         if(loginState == 4) {
            if(secretPacketBuffer2.offset < 8) {
               var1 = class268.rssocket.available();
               if(var1 > 8 - secretPacketBuffer2.offset) {
                  var1 = 8 - secretPacketBuffer2.offset;
               }

               if(var1 > 0) {
                  class268.rssocket.read(secretPacketBuffer2.payload, secretPacketBuffer2.offset, var1);
                  secretPacketBuffer2.offset += var1;
               }
            }

            if(secretPacketBuffer2.offset == 8) {
               secretPacketBuffer2.offset = 0;
               MessageNode.field875 = secretPacketBuffer2.readLong();
               loginState = 5;
            }
         }

         int var2;
         int var6;
         int var7;
         if(loginState == 5) {
            int[] var9 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(MessageNode.field875 >> 32), (int)(MessageNode.field875 & -1L)};
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(1);
            secretPacketBuffer1.putByte(field957.rsOrdinal());
            secretPacketBuffer1.putInt(var9[0]);
            secretPacketBuffer1.putInt(var9[1]);
            secretPacketBuffer1.putInt(var9[2]);
            secretPacketBuffer1.putInt(var9[3]);
            switch(field957.field2211) {
            case 0:
               secretPacketBuffer1.offset += 8;
               break;
            case 1:
            case 3:
               secretPacketBuffer1.put24bitInt(FrameMap.field2042);
               secretPacketBuffer1.offset += 5;
               break;
            case 2:
               PacketBuffer var10 = secretPacketBuffer1;
               LinkedHashMap var11 = class23.preferences.preferences;
               String var5 = class90.username;
               var6 = var5.length();
               var7 = 0;

               for(int var8 = 0; var8 < var6; ++var8) {
                  var7 = (var7 << 5) - var7 + var5.charAt(var8);
               }

               var10.putInt(((Integer)var11.get(Integer.valueOf(var7))).intValue());
               secretPacketBuffer1.offset += 4;
            }

            secretPacketBuffer1.putString(class90.password);
            secretPacketBuffer1.encryptRsa(class88.rsaKeyExponent, class88.rsaKeyModulus);
            field965.offset = 0;
            if(gameState == 40) {
               field965.putByte(18);
            } else {
               field965.putByte(16);
            }

            field965.putShort(0);
            var2 = field965.offset;
            field965.putInt(155);
            field965.putBytes(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
            int var3 = field965.offset;
            field965.putString(class90.username);
            field965.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            field965.putShort(class60.canvasWidth);
            field965.putShort(class48.canvasHeight);
            PacketBuffer var4 = field965;
            if(field981 != null) {
               var4.putBytes(field981, 0, field981.length);
            } else {
               byte[] var20 = DecorativeObject.method2965();
               var4.putBytes(var20, 0, var20.length);
            }

            field965.putString(class148.sessionToken);
            field965.putInt(class85.field1377);
            Buffer var21 = new Buffer(WorldMapType3.field378.method5500());
            WorldMapType3.field378.method5508(var21);
            field965.putBytes(var21.payload, 0, var21.payload.length);
            field965.putByte(field927);
            field965.putInt(0);
            field965.putInt(class64.indexInterfaces.crc);
            field965.putInt(Varcs.indexSoundEffects.crc);
            field965.putInt(FaceNormal.configsIndex.crc);
            field965.putInt(ClanMember.field918.crc);
            field965.putInt(BaseVarType.field34.crc);
            field965.putInt(class226.indexMaps.crc);
            field965.putInt(class268.indexTrack1.crc);
            field965.putInt(GraphicsObject.indexModels.crc);
            field965.putInt(class37.indexSprites.crc);
            field965.putInt(class8.indexTextures.crc);
            field965.putInt(field1193.crc);
            field965.putInt(Renderable.indexTrack2.crc);
            field965.putInt(class51.indexScripts.crc);
            field965.putInt(class31.field458.crc);
            field965.putInt(KeyFocusListener.vorbisIndex.crc);
            field965.putInt(class54.field686.crc);
            field965.putInt(class41.indexWorldMap.crc);
            field965.encryptXtea(var9, var3, field965.offset);
            field965.putShortLength(field965.offset - var2);
            class268.rssocket.queueForWrite(field965.payload, 0, field965.offset);
            secretPacketBuffer1.seed(var9);

            for(var6 = 0; var6 < 4; ++var6) {
               var9[var6] += 50;
            }

            secretPacketBuffer2.seed(var9);
            loginState = 6;
         }

         if(loginState == 6 && class268.rssocket.available() > 0) {
            var1 = class268.rssocket.readByte();
            if(var1 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var1 == 2) {
               loginState = 9;
            } else if(var1 == 15 && gameState == 40) {
               packetLength = -1;
               loginState = 13;
            } else if(var1 == 23 && field1138 < 1) {
               ++field1138;
               loginState = 0;
            } else {
               if(var1 != 29) {
                  class236.method4311(var1);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && class268.rssocket.available() > 0) {
            field1017 = (class268.rssocket.readByte() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field1030 = 0;
            class1.method3("You have only just left another world.", "Your profile will be transferred in:", field1017 / 60 + " seconds.");
            if(--field1017 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && class268.rssocket.available() >= 13) {
               boolean var18 = class268.rssocket.readByte() == 1;
               class268.rssocket.read(secretPacketBuffer2.payload, 0, 4);
               secretPacketBuffer2.offset = 0;
               boolean var17 = false;
               if(var18) {
                  var2 = secretPacketBuffer2.readOpcode() << 24;
                  var2 |= secretPacketBuffer2.readOpcode() << 16;
                  var2 |= secretPacketBuffer2.readOpcode() << 8;
                  var2 |= secretPacketBuffer2.readOpcode();
                  String var19 = class90.username;
                  int var13 = var19.length();
                  var6 = 0;

                  for(var7 = 0; var7 < var13; ++var7) {
                     var6 = (var6 << 5) - var6 + var19.charAt(var7);
                  }

                  if(class23.preferences.preferences.size() >= 10 && !class23.preferences.preferences.containsKey(Integer.valueOf(var6))) {
                     Iterator var14 = class23.preferences.preferences.entrySet().iterator();
                     var14.next();
                     var14.remove();
                  }

                  class23.preferences.preferences.put(Integer.valueOf(var6), Integer.valueOf(var2));
               }

               if(class90.field1414) {
                  class23.preferences.field1306 = class90.username;
               } else {
                  class23.preferences.field1306 = null;
               }

               class10.method58();
               rights = class268.rssocket.readByte();
               field1082 = class268.rssocket.readByte() == 1;
               localInteractingIndex = class268.rssocket.readByte();
               localInteractingIndex <<= 8;
               localInteractingIndex += class268.rssocket.readByte();
               field1035 = class268.rssocket.readByte();
               class268.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               class268.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();

               try {
                  class52.method795(PendingSpawn.clientInstance, "zap");
               } catch (Throwable var15) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(class268.rssocket.available() >= packetLength) {
                  secretPacketBuffer2.offset = 0;
                  class268.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                  field929.method4995();
                  class31.method268();
                  WorldMapType1.initializeGPI(secretPacketBuffer2);
                  class43.field589 = -1;
                  class86.xteaChanged(false);
                  packetType = -1;
               }

            } else {
               if(loginState == 11 && class268.rssocket.available() >= 2) {
                  secretPacketBuffer2.offset = 0;
                  class268.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                  secretPacketBuffer2.offset = 0;
                  class46.field613 = secretPacketBuffer2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && class268.rssocket.available() >= class46.field613) {
                  secretPacketBuffer2.offset = 0;
                  class268.rssocket.read(secretPacketBuffer2.payload, 0, class46.field613);
                  secretPacketBuffer2.offset = 0;
                  String var22 = secretPacketBuffer2.readString();
                  String var23 = secretPacketBuffer2.readString();
                  String var24 = secretPacketBuffer2.readString();
                  class1.method3(var22, var23, var24);
                  FrameMap.setGameState(10);
               }

               if(loginState == 13) {
                  if(packetLength == -1) {
                     if(class268.rssocket.available() < 2) {
                        return;
                     }

                     class268.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                     secretPacketBuffer2.offset = 0;
                     packetLength = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(class268.rssocket.available() >= packetLength) {
                     class268.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                     secretPacketBuffer2.offset = 0;
                     var1 = packetLength;
                     field929.method5014();
                     class149.method2996();
                     WorldMapType1.initializeGPI(secretPacketBuffer2);
                     if(var1 != secretPacketBuffer2.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field1030;
                  if(field1030 > 2000) {
                     if(field1138 < 1) {
                        if(class18.myWorldPort == SceneTilePaint.field2023) {
                           class18.myWorldPort = AbstractSoundSystem.field1631;
                        } else {
                           class18.myWorldPort = SceneTilePaint.field2023;
                        }

                        ++field1138;
                        loginState = 0;
                     } else {
                        class236.method4311(-3);
                     }
                  }
               }
            }
         }
      } catch (IOException var16) {
         if(field1138 < 1) {
            if(class18.myWorldPort == SceneTilePaint.field2023) {
               class18.myWorldPort = AbstractSoundSystem.field1631;
            } else {
               class18.myWorldPort = SceneTilePaint.field2023;
            }

            ++field1138;
            loginState = 0;
         } else {
            class236.method4311(-2);
         }
      }
   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1866476521"
   )
   final void method1210() {
      if(field983 > 1) {
         --field983;
      }

      if(field974 > 0) {
         --field974;
      }

      if(socketError) {
         socketError = false;
         IndexFile.method3106();
      } else {
         if(!isMenuOpen) {
            menuOptionCount = 0;
            isMenuOpen = false;
            menuOptions[0] = "Cancel";
            menuTargets[0] = "";
            menuTypes[0] = 1006;
            field1021[0] = false;
            menuOptionCount = 1;
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.processServerPacket(); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(Projectile.method1823()) {
               secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_255);
               if(RUNELITE_PACKET) {
                  secretPacketBuffer1.runeliteWriteInt(0);
               } else {
                  secretPacketBuffer1.putByte(0);
               }

               var1 = secretPacketBuffer1.offset;
               class70.encodeClassVerifier(secretPacketBuffer1);
               secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var1);
            }

            if(field929.field3735) {
               secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_70);
               if(RUNELITE_PACKET) {
                  secretPacketBuffer1.runeliteWriteInt(0);
               } else {
                  secretPacketBuffer1.putByte(0);
               }

               var1 = secretPacketBuffer1.offset;
               field929.method4998(secretPacketBuffer1);
               secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var1);
               field929.method4996();
            }

            Object var15 = class110.field1653.field860;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            synchronized(class110.field1653.field860) {
               if(!field1188) {
                  class110.field1653.field861 = 0;
               } else if(MouseInput.field741 != 0 || class110.field1653.field861 >= 40) {
                  secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_212);
                  if(RUNELITE_PACKET) {
                     secretPacketBuffer1.runeliteWriteInt(0);
                  } else {
                     secretPacketBuffer1.putByte(0);
                  }

                  var2 = secretPacketBuffer1.offset;
                  var3 = 0;

                  for(var4 = 0; var4 < class110.field1653.field861 && secretPacketBuffer1.offset - var2 < 240; ++var4) {
                     ++var3;
                     var5 = class110.field1653.field863[var4];
                     if(var5 < 0) {
                        var5 = 0;
                     } else if(var5 > 502) {
                        var5 = 502;
                     }

                     var6 = class110.field1653.field862[var4];
                     if(var6 < 0) {
                        var6 = 0;
                     } else if(var6 > 764) {
                        var6 = 764;
                     }

                     var7 = var6 + var5 * 765;
                     if(class110.field1653.field863[var4] == -1 && class110.field1653.field862[var4] == -1) {
                        var6 = -1;
                        var5 = -1;
                        var7 = 524287;
                     }

                     if(var6 == field1010 && var5 == field933) {
                        if(field934 < 2047) {
                           ++field934;
                        }
                     } else {
                        var8 = var6 - field1010;
                        field1010 = var6;
                        var9 = var5 - field933;
                        field933 = var5;
                        if(field934 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                           var8 += 32;
                           var9 += 32;
                           secretPacketBuffer1.putShort(var9 + (field934 << 12) + (var8 << 6));
                           field934 = 0;
                        } else if(field934 < 8) {
                           secretPacketBuffer1.put24bitInt((field934 << 19) + var7 + 8388608);
                           field934 = 0;
                        } else {
                           secretPacketBuffer1.putInt((field934 << 19) + var7 + -1073741824);
                           field934 = 0;
                        }
                     }
                  }

                  secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var2);
                  if(var3 >= class110.field1653.field861) {
                     class110.field1653.field861 = 0;
                  } else {
                     class110.field1653.field861 -= var3;

                     for(var4 = 0; var4 < class110.field1653.field861; ++var4) {
                        class110.field1653.field862[var4] = class110.field1653.field862[var3 + var4];
                        class110.field1653.field863[var4] = class110.field1653.field863[var3 + var4];
                     }
                  }
               }
            }

            if(MouseInput.field741 == 1 || !class110.field1650 && MouseInput.field741 == 4 || MouseInput.field741 == 2) {
               long var16 = (MouseInput.field754 - field1144) / 50L;
               if(var16 > 4095L) {
                  var16 = 4095L;
               }

               field1144 = MouseInput.field754;
               var3 = MouseInput.field753;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > class48.canvasHeight) {
                  var3 = class48.canvasHeight;
               }

               var4 = MouseInput.field752;
               if(var4 < 0) {
                  var4 = 0;
               } else if(var4 > class60.canvasWidth) {
                  var4 = class60.canvasWidth;
               }

               var5 = (int)var16;
               secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CLICK_ANYWHERE);
               secretPacketBuffer1.putShort((var5 << 1) + (MouseInput.field741 == 2?1:0));
               secretPacketBuffer1.putShort(var4);
               secretPacketBuffer1.putShort(var3);
            }

            if(KeyFocusListener.field662 > 0) {
               secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_TYPE_ON_KEYBOARD);
               if(RUNELITE_PACKET) {
                  secretPacketBuffer1.runeliteWriteInt(0);
               } else {
                  secretPacketBuffer1.putShort(0);
               }

               var1 = secretPacketBuffer1.offset;
               long var18 = class147.currentTimeMs();

               for(var4 = 0; var4 < KeyFocusListener.field662; ++var4) {
                  long var20 = var18 - field1137;
                  if(var20 > 16777215L) {
                     var20 = 16777215L;
                  }

                  field1137 = var18;
                  secretPacketBuffer1.method3307((int)var20);
                  secretPacketBuffer1.method3263(KeyFocusListener.field658[var4]);
               }

               secretPacketBuffer1.putShortLength(secretPacketBuffer1.offset - var1);
            }

            if(field970 > 0) {
               --field970;
            }

            if(KeyFocusListener.field655[96] || KeyFocusListener.field655[97] || KeyFocusListener.field655[98] || KeyFocusListener.field655[99]) {
               field1003 = true;
            }

            if(field1003 && field970 <= 0) {
               field970 = 20;
               field1003 = false;
               secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_56);
               if(RUNELITE_PACKET) {
                  secretPacketBuffer1.runeliteWriteInt(mapAngle);
                  secretPacketBuffer1.runeliteWriteInt(field921);
               } else {
                  secretPacketBuffer1.putShortLE(mapAngle);
                  secretPacketBuffer1.method3365(field921);
               }
            }

            if(class43.field595 && !field935) {
               field935 = true;
               secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_41);
               if(RUNELITE_PACKET) {
                  secretPacketBuffer1.runeliteWriteInt(1);
               } else {
                  secretPacketBuffer1.putByte(1);
               }
            }

            if(!class43.field595 && field935) {
               field935 = false;
               secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_41);
               if(RUNELITE_PACKET) {
                  secretPacketBuffer1.runeliteWriteInt(0);
               } else {
                  secretPacketBuffer1.putByte(0);
               }
            }

            int[] var22;
            if(field1140 != class5.plane) {
               field1140 = class5.plane;
               var1 = class5.plane;
               var22 = BaseVarType.field33.image;
               var3 = var22.length;

               for(var4 = 0; var4 < var3; ++var4) {
                  var22[var4] = 0;
               }

               for(var4 = 1; var4 < 103; ++var4) {
                  var5 = 24628 + (103 - var4) * 2048;

                  for(var6 = 1; var6 < 103; ++var6) {
                     if((class61.tileSettings[var1][var6][var4] & 24) == 0) {
                        class8.region.method2791(var22, var5, 512, var1, var6, var4);
                     }

                     if(var1 < 3 && (class61.tileSettings[var1 + 1][var6][var4] & 8) != 0) {
                        class8.region.method2791(var22, var5, 512, var1 + 1, var6, var4);
                     }

                     var5 += 4;
                  }
               }

               var4 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
               var5 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
               BaseVarType.field33.method5166();

               for(var6 = 1; var6 < 103; ++var6) {
                  for(var7 = 1; var7 < 103; ++var7) {
                     if((class61.tileSettings[var1][var7][var6] & 24) == 0) {
                        class34.method482(var1, var7, var6, var4, var5);
                     }

                     if(var1 < 3 && (class61.tileSettings[var1 + 1][var7][var6] & 8) != 0) {
                        class34.method482(var1 + 1, var7, var6, var4, var5);
                     }
                  }
               }

               field1141 = 0;

               for(var6 = 0; var6 < 104; ++var6) {
                  for(var7 = 0; var7 < 104; ++var7) {
                     var8 = class8.region.method2841(class5.plane, var6, var7);
                     if(var8 != 0) {
                        var8 = var8 >> 14 & 32767;
                        var9 = Occluder.getObjectDefinition(var8).mapIconId;
                        if(var9 >= 0) {
                           field1176[field1141] = class3.field24[var9].method4395(false);
                           field1142[field1141] = var6;
                           field1143[field1141] = var7;
                           ++field1141;
                        }
                     }
                  }
               }

               class12.field275.setRaster();
            }

            if(gameState == 30) {
               class44.method640();
               Friend.method1137();
               ++field969;
               if(field969 > 750) {
                  IndexFile.method3106();
               } else {
                  var1 = class94.playerIndexesCount;
                  var22 = class94.field1480;

                  for(var3 = 0; var3 < var1; ++var3) {
                     Player var23 = cachedPlayers[var22[var3]];
                     if(var23 != null) {
                        class44.method629(var23, 1);
                     }
                  }

                  for(var1 = 0; var1 < npcIndexesCount; ++var1) {
                     var2 = npcIndices[var1];
                     NPC var24 = cachedNPCs[var2];
                     if(var24 != null) {
                        class44.method629(var24, var24.composition.field3559);
                     }
                  }

                  class2.method6();
                  ++field1122;
                  if(cursorState != 0) {
                     field1171 += 20;
                     if(field1171 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(SceneTilePaint.field2031 != null) {
                     ++field1023;
                     if(field1023 >= 15) {
                        class25.method172(SceneTilePaint.field2031);
                        SceneTilePaint.field2031 = null;
                     }
                  }

                  Widget var32 = class27.field403;
                  Widget var33 = class48.field635;
                  class27.field403 = null;
                  class48.field635 = null;
                  field952 = null;
                  field1094 = false;
                  field1091 = false;
                  field1134 = 0;

                  while(class1.method0() && field1134 < 128) {
                     if(rights >= 2 && KeyFocusListener.field655[82] && class94.field1491 == 66) {
                        String var35 = class80.method1662();
                        PendingSpawn.clientInstance.method876(var35);
                     } else {
                        field1136[field1134] = class94.field1491;
                        field1185[field1134] = ChatLineBuffer.field1546;
                        ++field1134;
                     }
                  }

                  boolean var30 = rights >= 2;
                  if(var30 && KeyFocusListener.field655[82] && KeyFocusListener.field655[81] && field1111 != 0) {
                     var4 = AbstractByteBuffer.localPlayer.field894 - field1111;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 3) {
                        var4 = 3;
                     }

                     if(var4 != AbstractByteBuffer.localPlayer.field894) {
                        var5 = AbstractByteBuffer.localPlayer.pathX[0] + WallObject.baseX;
                        var6 = AbstractByteBuffer.localPlayer.pathY[0] + Varcs.baseY;
                        secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_201);
                        if(RUNELITE_PACKET) {
                           secretPacketBuffer1.runeliteWriteInt(var6);
                           secretPacketBuffer1.runeliteWriteInt(var5);
                           secretPacketBuffer1.runeliteWriteInt(var4);
                        } else {
                           secretPacketBuffer1.method3365(var6);
                           secretPacketBuffer1.method3270(var5);
                           secretPacketBuffer1.method3263(var4);
                        }
                     }

                     field1111 = 0;
                  }

                  if(widgetRoot != -1) {
                     var4 = widgetRoot;
                     var5 = class60.canvasWidth;
                     var6 = class48.canvasHeight;
                     if(class93.loadWidget(var4)) {
                        GrandExchangeOffer.method100(class177.widgets[var4], -1, 0, 0, var5, var6, 0, 0);
                     }
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var25;
                     Widget var26;
                     ScriptEvent var34;
                     do {
                        var34 = (ScriptEvent)field1125.popFront();
                        if(var34 == null) {
                           while(true) {
                              do {
                                 var34 = (ScriptEvent)field1090.popFront();
                                 if(var34 == null) {
                                    while(true) {
                                       do {
                                          var34 = (ScriptEvent)field1112.popFront();
                                          if(var34 == null) {
                                             this.method1215();
                                             if(GameObject.renderOverview != null) {
                                                GameObject.renderOverview.method5326(class5.plane, (AbstractByteBuffer.localPlayer.x >> 7) + WallObject.baseX, (AbstractByteBuffer.localPlayer.y >> 7) + Varcs.baseY, false);
                                                GameObject.renderOverview.method5373();
                                             }

                                             if(field1052 != null) {
                                                this.method1533();
                                             }

                                             if(ClanMember.field915 != null) {
                                                class25.method172(ClanMember.field915);
                                                ++field1127;
                                                if(MouseInput.field738 == 0) {
                                                   if(field1105) {
                                                      if(Timer.field2270 == ClanMember.field915 && field1113 != field1025) {
                                                         Widget var36 = ClanMember.field915;
                                                         byte var31 = 0;
                                                         if(field1076 == 1 && var36.contentType == 206) {
                                                            var31 = 1;
                                                         }

                                                         if(var36.itemIds[field1113] <= 0) {
                                                            var31 = 0;
                                                         }

                                                         if(class39.method538(class244.getWidgetConfig(var36))) {
                                                            var6 = field1025;
                                                            var7 = field1113;
                                                            var36.itemIds[var7] = var36.itemIds[var6];
                                                            var36.itemQuantities[var7] = var36.itemQuantities[var6];
                                                            var36.itemIds[var6] = -1;
                                                            var36.itemQuantities[var6] = 0;
                                                         } else if(var31 == 1) {
                                                            var6 = field1025;
                                                            var7 = field1113;

                                                            while(var6 != var7) {
                                                               if(var6 > var7) {
                                                                  var36.method4113(var6 - 1, var6);
                                                                  --var6;
                                                               } else if(var6 < var7) {
                                                                  var36.method4113(var6 + 1, var6);
                                                                  ++var6;
                                                               }
                                                            }
                                                         } else {
                                                            var36.method4113(field1113, field1025);
                                                         }

                                                         secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_185);
                                                         if(RUNELITE_PACKET) {
                                                            secretPacketBuffer1.runeliteWriteInt(field1113);
                                                            secretPacketBuffer1.runeliteWriteInt(ClanMember.field915.id);
                                                            secretPacketBuffer1.runeliteWriteInt(field1025);
                                                            secretPacketBuffer1.runeliteWriteInt(var31);
                                                         } else {
                                                            secretPacketBuffer1.method3270(field1113);
                                                            secretPacketBuffer1.method3279(ClanMember.field915.id);
                                                            secretPacketBuffer1.putShortLE(field1025);
                                                            secretPacketBuffer1.method3261(var31);
                                                         }
                                                      }
                                                   } else if(this.method1216()) {
                                                      this.method1217(field1026, field1135);
                                                   } else if(menuOptionCount > 0) {
                                                      PendingSpawn.method1586(field1026, field1135);
                                                   }

                                                   field1023 = 10;
                                                   MouseInput.field741 = 0;
                                                   ClanMember.field915 = null;
                                                } else if(field1127 >= 5 && (MouseInput.field745 > field1026 + 5 || MouseInput.field745 < field1026 - 5 || MouseInput.field746 > field1135 + 5 || MouseInput.field746 < field1135 - 5)) {
                                                   field1105 = true;
                                                }
                                             }

                                             if(Region.method2805()) {
                                                var4 = Region.selectedRegionTileX;
                                                var5 = Region.selectedRegionTileY;
                                                secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CLICK_IN_GAME_WALK);
                                                if(RUNELITE_PACKET) {
                                                   secretPacketBuffer1.runeliteWriteInt(5);
                                                } else {
                                                   secretPacketBuffer1.putByte(5);
                                                }

                                                secretPacketBuffer1.method3261(KeyFocusListener.field655[82]?(KeyFocusListener.field655[81]?2:1):0);
                                                secretPacketBuffer1.putShortLE(var4 + WallObject.baseX);
                                                secretPacketBuffer1.putShort(var5 + Varcs.baseY);
                                                Region.method2796();
                                                field1019 = MouseInput.field752;
                                                field1020 = MouseInput.field753;
                                                cursorState = 1;
                                                field1171 = 0;
                                                destinationX = var4;
                                                destinationY = var5;
                                             }

                                             if(var32 != class27.field403) {
                                                if(var32 != null) {
                                                   class25.method172(var32);
                                                }

                                                if(class27.field403 != null) {
                                                   class25.method172(class27.field403);
                                                }
                                             }

                                             if(var33 != class48.field635 && field1064 == field1065) {
                                                if(var33 != null) {
                                                   class25.method172(var33);
                                                }

                                                if(class48.field635 != null) {
                                                   class25.method172(class48.field635);
                                                }
                                             }

                                             if(class48.field635 != null) {
                                                if(field1064 < field1065) {
                                                   ++field1064;
                                                   if(field1065 == field1064) {
                                                      class25.method172(class48.field635);
                                                   }
                                                }
                                             } else if(field1064 > 0) {
                                                --field1064;
                                             }

                                             PendingSpawn.method1581();
                                             if(field1160) {
                                                var4 = 64 + class110.field1656 * 128;
                                                var5 = 64 + ItemContainer.field801 * 128;
                                                var6 = CacheFile.getTileHeight(var4, var5, class5.plane) - class15.field303;
                                                if(class211.cameraX < var4) {
                                                   class211.cameraX = (var4 - class211.cameraX) * class66.field830 / 1000 + class211.cameraX + class221.field2820;
                                                   if(class211.cameraX > var4) {
                                                      class211.cameraX = var4;
                                                   }
                                                }

                                                if(class211.cameraX > var4) {
                                                   class211.cameraX -= class66.field830 * (class211.cameraX - var4) / 1000 + class221.field2820;
                                                   if(class211.cameraX < var4) {
                                                      class211.cameraX = var4;
                                                   }
                                                }

                                                if(ScriptState.cameraZ < var6) {
                                                   ScriptState.cameraZ += class221.field2820 + (var6 - ScriptState.cameraZ) * class66.field830 / 1000;
                                                   if(ScriptState.cameraZ > var6) {
                                                      ScriptState.cameraZ = var6;
                                                   }
                                                }

                                                if(ScriptState.cameraZ > var6) {
                                                   ScriptState.cameraZ -= class66.field830 * (ScriptState.cameraZ - var6) / 1000 + class221.field2820;
                                                   if(ScriptState.cameraZ < var6) {
                                                      ScriptState.cameraZ = var6;
                                                   }
                                                }

                                                if(ChatLineBuffer.cameraY < var5) {
                                                   ChatLineBuffer.cameraY += class221.field2820 + (var5 - ChatLineBuffer.cameraY) * class66.field830 / 1000;
                                                   if(ChatLineBuffer.cameraY > var5) {
                                                      ChatLineBuffer.cameraY = var5;
                                                   }
                                                }

                                                if(ChatLineBuffer.cameraY > var5) {
                                                   ChatLineBuffer.cameraY -= class66.field830 * (ChatLineBuffer.cameraY - var5) / 1000 + class221.field2820;
                                                   if(ChatLineBuffer.cameraY < var5) {
                                                      ChatLineBuffer.cameraY = var5;
                                                   }
                                                }

                                                var4 = 64 + class51.field672 * 128;
                                                var5 = 64 + class35.field514 * 128;
                                                var6 = CacheFile.getTileHeight(var4, var5, class5.plane) - class170.field2359;
                                                var7 = var4 - class211.cameraX;
                                                var8 = var6 - ScriptState.cameraZ;
                                                var9 = var5 - ChatLineBuffer.cameraY;
                                                int var10 = (int)Math.sqrt((double)(var7 * var7 + var9 * var9));
                                                int var11 = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
                                                int var12 = (int)(Math.atan2((double)var7, (double)var9) * -325.949D) & 2047;
                                                if(var11 < 128) {
                                                   var11 = 128;
                                                }

                                                if(var11 > 383) {
                                                   var11 = 383;
                                                }

                                                if(class9.cameraPitch < var11) {
                                                   class9.cameraPitch += (var11 - class9.cameraPitch) * class28.field427 / 1000 + class181.field2454;
                                                   if(class9.cameraPitch > var11) {
                                                      class9.cameraPitch = var11;
                                                   }
                                                }

                                                if(class9.cameraPitch > var11) {
                                                   class9.cameraPitch -= class181.field2454 + class28.field427 * (class9.cameraPitch - var11) / 1000;
                                                   if(class9.cameraPitch < var11) {
                                                      class9.cameraPitch = var11;
                                                   }
                                                }

                                                int var13 = var12 - class174.cameraYaw;
                                                if(var13 > 1024) {
                                                   var13 -= 2048;
                                                }

                                                if(var13 < -1024) {
                                                   var13 += 2048;
                                                }

                                                if(var13 > 0) {
                                                   class174.cameraYaw = var13 * class28.field427 / 1000 + class174.cameraYaw + class181.field2454;
                                                   class174.cameraYaw &= 2047;
                                                }

                                                if(var13 < 0) {
                                                   class174.cameraYaw -= -var13 * class28.field427 / 1000 + class181.field2454;
                                                   class174.cameraYaw &= 2047;
                                                }

                                                int var14 = var12 - class174.cameraYaw;
                                                if(var14 > 1024) {
                                                   var14 -= 2048;
                                                }

                                                if(var14 < -1024) {
                                                   var14 += 2048;
                                                }

                                                if(var14 < 0 && var13 > 0 || var14 > 0 && var13 < 0) {
                                                   class174.cameraYaw = var12;
                                                }
                                             }

                                             for(var4 = 0; var4 < 5; ++var4) {
                                                ++field1165[var4];
                                             }

                                             GZipDecompressor.chatMessages.process();
                                             var4 = class24.method168();
                                             var5 = class31.method267();
                                             if(var4 > 15000 && var5 > 15000) {
                                                field974 = 250;
                                                Varcs.method1894(14500);
                                                secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_149);
                                             }

                                             for(class66 var37 = (class66)field998.method3745(); var37 != null; var37 = (class66)field998.method3751()) {
                                                if((long)var37.field833 < class147.currentTimeMs() / 1000L - 5L) {
                                                   if(var37.field828 > 0) {
                                                      MessageNode.sendGameMessage(5, "", var37.field829 + " has logged in.");
                                                   }

                                                   if(var37.field828 == 0) {
                                                      MessageNode.sendGameMessage(5, "", var37.field829 + " has logged out.");
                                                   }

                                                   var37.method3757();
                                                }
                                             }

                                             ++audioEffectCount;
                                             if(audioEffectCount > 50) {
                                                secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_KEEPALIVE);
                                             }

                                             try {
                                                if(class268.rssocket != null && secretPacketBuffer1.offset > 0) {
                                                   class268.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
                                                   secretPacketBuffer1.offset = 0;
                                                   audioEffectCount = 0;
                                                }
                                             } catch (IOException var28) {
                                                IndexFile.method3106();
                                             }

                                             return;
                                          }

                                          var25 = var34.widget;
                                          if(var25.index < 0) {
                                             break;
                                          }

                                          var26 = PacketBuffer.method3528(var25.parentId);
                                       } while(var26 == null || var26.children == null || var25.index >= var26.children.length || var25 != var26.children[var25.index]);

                                       CollisionData.method3128(var34);
                                    }
                                 }

                                 var25 = var34.widget;
                                 if(var25.index < 0) {
                                    break;
                                 }

                                 var26 = PacketBuffer.method3528(var25.parentId);
                              } while(var26 == null || var26.children == null || var25.index >= var26.children.length || var25 != var26.children[var25.index]);

                              CollisionData.method3128(var34);
                           }
                        }

                        var25 = var34.widget;
                        if(var25.index < 0) {
                           break;
                        }

                        var26 = PacketBuffer.method3528(var25.parentId);
                     } while(var26 == null || var26.children == null || var25.index >= var26.children.length || var25 != var26.children[var25.index]);

                     CollisionData.method3128(var34);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(Lhj;I)V",
      garbageValue = "1965119693"
   )
   void method1312(Widget var1) {
      Widget var2 = var1.parentId == -1?null:PacketBuffer.method3528(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = class60.canvasWidth;
         var4 = class48.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      TextureProvider.method2478(var1, var3, var4, false);
      WorldMapType2.method499(var1, var3, var4);
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1945081050"
   )
   final void method1215() {
      class7.method41();
      if(ClanMember.field915 == null) {
         if(field1052 == null) {
            int var1 = MouseInput.field741;
            int var2;
            int var4;
            int var5;
            int var6;
            int var7;
            int var9;
            if(isMenuOpen) {
               int var3;
               if(var1 != 1 && (class110.field1650 || var1 != 4)) {
                  var2 = MouseInput.field745;
                  var3 = MouseInput.field746;
                  if(var2 < class54.menuX - 10 || var2 > class54.menuX + class20.menuWidth + 10 || var3 < class10.menuY - 10 || var3 > class10.menuY + class28.menuHeight + 10) {
                     isMenuOpen = false;
                     MilliTimer.method3014(class54.menuX, class10.menuY, class20.menuWidth, class28.menuHeight);
                  }
               }

               if(var1 == 1 || !class110.field1650 && var1 == 4) {
                  var2 = class54.menuX;
                  var3 = class10.menuY;
                  var4 = class20.menuWidth;
                  var5 = MouseInput.field752;
                  var6 = MouseInput.field753;
                  var7 = -1;

                  int var17;
                  for(var17 = 0; var17 < menuOptionCount; ++var17) {
                     var9 = var3 + 31 + (menuOptionCount - 1 - var17) * 15;
                     if(var5 > var2 && var5 < var2 + var4 && var6 > var9 - 13 && var6 < var9 + 3) {
                        var7 = var17;
                     }
                  }

                  if(var7 != -1 && var7 >= 0) {
                     var17 = menuActionParams0[var7];
                     var9 = menuActionParams1[var7];
                     int var10 = menuTypes[var7];
                     int var11 = menuIdentifiers[var7];
                     String var12 = menuOptions[var7];
                     String var13 = menuTargets[var7];
                     class257.menuAction(var17, var9, var10, var11, var12, var13, MouseInput.field752, MouseInput.field753);
                  }

                  isMenuOpen = false;
                  MilliTimer.method3014(class54.menuX, class10.menuY, class20.menuWidth, class28.menuHeight);
               }
            } else {
               label269: {
                  var2 = menuOptionCount - 1;
                  if((var1 == 1 || !class110.field1650 && var1 == 4) && var2 >= 0) {
                     var4 = menuTypes[var2];
                     if(var4 == 39 || var4 == 40 || var4 == 41 || var4 == 42 || var4 == 43 || var4 == 33 || var4 == 34 || var4 == 35 || var4 == 36 || var4 == 37 || var4 == 38 || var4 == 1005) {
                        var5 = menuActionParams0[var2];
                        var6 = menuActionParams1[var2];
                        Widget var14 = PacketBuffer.method3528(var6);
                        var9 = class244.getWidgetConfig(var14);
                        boolean var8 = (var9 >> 28 & 1) != 0;
                        if(var8) {
                           break label269;
                        }

                        Object var10000 = null;
                        if(class39.method538(class244.getWidgetConfig(var14))) {
                           break label269;
                        }
                     }
                  }

                  if((var1 == 1 || !class110.field1650 && var1 == 4) && this.method1216()) {
                     var1 = 2;
                  }

                  if((var1 == 1 || !class110.field1650 && var1 == 4) && menuOptionCount > 0 && var2 >= 0) {
                     var4 = menuActionParams0[var2];
                     var5 = menuActionParams1[var2];
                     var6 = menuTypes[var2];
                     var7 = menuIdentifiers[var2];
                     String var15 = menuOptions[var2];
                     String var16 = menuTargets[var2];
                     class257.menuAction(var4, var5, var6, var7, var15, var16, MouseInput.field752, MouseInput.field753);
                  }

                  if(var1 == 2 && menuOptionCount > 0) {
                     this.method1217(MouseInput.field752, MouseInput.field753);
                  }

                  return;
               }

               if(ClanMember.field915 != null && !field1105 && menuOptionCount > 0 && !this.method1216()) {
                  PendingSpawn.method1586(field1026, field1135);
               }

               field1105 = false;
               field1127 = 0;
               if(ClanMember.field915 != null) {
                  class25.method172(ClanMember.field915);
               }

               ClanMember.field915 = PacketBuffer.method3528(var6);
               field1025 = var5;
               field1026 = MouseInput.field752;
               field1135 = MouseInput.field753;
               if(var2 >= 0) {
                  ScriptVarType.field239 = new class87();
                  ScriptVarType.field239.field1392 = menuActionParams0[var2];
                  ScriptVarType.field239.field1391 = menuActionParams1[var2];
                  ScriptVarType.field239.field1390 = menuTypes[var2];
                  ScriptVarType.field239.field1393 = menuIdentifiers[var2];
                  ScriptVarType.field239.field1394 = menuOptions[var2];
               }

               class25.method172(ClanMember.field915);
               return;
            }

         }
      }
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1965211147"
   )
   final void method1533() {
      class25.method172(field1052);
      ++Timer.field2268;
      if(field1094 && field1091) {
         int var1 = MouseInput.field745;
         int var2 = MouseInput.field746;
         var1 -= field1088;
         var2 -= field1089;
         if(var1 < field1092) {
            var1 = field1092;
         }

         if(var1 + field1052.width > field1092 + field1047.width) {
            var1 = field1092 + field1047.width - field1052.width;
         }

         if(var2 < field1093) {
            var2 = field1093;
         }

         if(var2 + field1052.height > field1093 + field1047.height) {
            var2 = field1093 + field1047.height - field1052.height;
         }

         int var3 = var1 - field1095;
         int var4 = var2 - field1096;
         int var5 = field1052.field2734;
         if(Timer.field2268 > field1052.field2757 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1159 = true;
         }

         int var6 = var1 - field1092 + field1047.scrollX;
         int var7 = var2 - field1093 + field1047.scrollY;
         ScriptEvent var8;
         if(field1052.field2747 != null && field1159) {
            var8 = new ScriptEvent();
            var8.widget = field1052;
            var8.field847 = var6;
            var8.field848 = var7;
            var8.field846 = field1052.field2747;
            CollisionData.method3128(var8);
         }

         if(MouseInput.field738 == 0) {
            if(field1159) {
               if(field1052.field2748 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field1052;
                  var8.field847 = var6;
                  var8.field848 = var7;
                  var8.field850 = field952;
                  var8.field846 = field1052.field2748;
                  CollisionData.method3128(var8);
               }

               if(field952 != null && class223.method4190(field1052) != null) {
                  secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_DRAG_ITEM_ACROSS_WIDGETS);
                  if(RUNELITE_PACKET) {
                     secretPacketBuffer1.runeliteWriteInt(field952.index);
                     secretPacketBuffer1.runeliteWriteInt(field952.itemId);
                     secretPacketBuffer1.runeliteWriteInt(field952.id);
                     secretPacketBuffer1.runeliteWriteInt(field1052.itemId);
                     secretPacketBuffer1.runeliteWriteInt(field1052.index);
                     secretPacketBuffer1.runeliteWriteInt(field1052.id);
                  } else {
                     secretPacketBuffer1.method3270(field952.index);
                     secretPacketBuffer1.putShort(field952.itemId);
                     secretPacketBuffer1.method3279(field952.id);
                     secretPacketBuffer1.putShortLE(field1052.itemId);
                     secretPacketBuffer1.method3365(field1052.index);
                     secretPacketBuffer1.method3279(field1052.id);
                  }
               }
            } else if(this.method1216()) {
               this.method1217(field1088 + field1095, field1096 + field1089);
            } else if(menuOptionCount > 0) {
               PendingSpawn.method1586(field1088 + field1095, field1096 + field1089);
            }

            field1052 = null;
         }

      } else {
         if(Timer.field2268 > 1) {
            field1052 = null;
         }

      }
   }

   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = class9.method47();

         int var6;
         for(int var2 = 0; var2 < var1.length; ++var2) {
            Parameters var3 = var1[var2];
            String var4 = this.getParameter(var3.key);
            if(var4 != null) {
               switch(Integer.parseInt(var3.key)) {
               case 1:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 2:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
               case 3:
               case 9:
               case 13:
               default:
                  break;
               case 4:
                  class232[] var23 = new class232[]{class232.field3199, class232.field3194, class232.field3192, class232.field3196, class232.field3193, class232.field3197};
                  field923 = (class232)class48.forOrdinal(var23, Integer.parseInt(var4));
                  if(class232.field3197 == field923) {
                     class5.field42 = class290.field3869;
                  } else {
                     class5.field42 = class290.field3872;
                  }
                  break;
               case 5:
                  var6 = Integer.parseInt(var4);
                  BuildType[] var7 = class211.method4047();
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

                  class210.field2614 = var5;
                  break;
               case 6:
                  field927 = Integer.parseInt(var4);
                  break;
               case 7:
                  DState.field2392 = var4;
                  break;
               case 8:
                  world = Integer.parseInt(var4);
                  break;
               case 10:
                  languageId = Integer.parseInt(var4);
                  break;
               case 11:
                  class148.sessionToken = var4;
                  break;
               case 12:
                  class85.field1377 = Integer.parseInt(var4);
                  break;
               case 14:
                  flags = Integer.parseInt(var4);
                  break;
               case 15:
                  socketType = Integer.parseInt(var4);
               }
            }
         }

         Region.lowMemory = false;
         lowMemory = false;
         GameEngine.host = this.getCodeBase().getHost();
         String var18 = class210.field2614.identifier;
         byte var19 = 0;

         try {
            class267.field3668 = 17;
            Ignore.field858 = var19;

            try {
               class2.osName = System.getProperty("os.name");
            } catch (Exception var15) {
               class2.osName = "Unknown";
            }

            class110.osNameLC = class2.osName.toLowerCase();

            try {
               class89.userHome = System.getProperty("user.home");
               if(class89.userHome != null) {
                  class89.userHome = class89.userHome + "/";
               }
            } catch (Exception var14) {
               ;
            }

            try {
               if(class110.osNameLC.startsWith("win")) {
                  if(class89.userHome == null) {
                     class89.userHome = System.getenv("USERPROFILE");
                  }
               } else if(class89.userHome == null) {
                  class89.userHome = System.getenv("HOME");
               }

               if(class89.userHome != null) {
                  class89.userHome = class89.userHome + "/";
               }
            } catch (Exception var13) {
               ;
            }

            if(class89.userHome == null) {
               class89.userHome = "~/";
            }

            class17.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class89.userHome, "/tmp/", ""};
            class72.field879 = new String[]{".jagex_cache_" + Ignore.field858, ".file_store_" + Ignore.field858};

            File var26;
            label153:
            for(int var10 = 0; var10 < 4; ++var10) {
               class155.field2256 = AbstractSoundSystem.method2129("oldschool", var18, var10);
               if(!class155.field2256.exists()) {
                  class155.field2256.mkdirs();
               }

               File[] var21 = class155.field2256.listFiles();
               if(var21 == null) {
                  break;
               }

               File[] var24 = var21;
               var6 = 0;

               while(true) {
                  if(var6 >= var24.length) {
                     break label153;
                  }

                  var26 = var24[var6];
                  if(!MessageNode.method1155(var26, false)) {
                     break;
                  }

                  ++var6;
               }
            }

            File var20 = class155.field2256;
            class157.field2264 = var20;
            if(!class157.field2264.exists()) {
               throw new RuntimeException("");
            }

            class157.field2265 = true;

            try {
               File var22 = new File(class89.userHome, "random.dat");
               if(var22.exists()) {
                  class155.field2258 = new CacheFile(new FileOnDisk(var22, "rw", 25L), 24, 0);
               } else {
                  label131:
                  for(int var11 = 0; var11 < class72.field879.length; ++var11) {
                     for(var6 = 0; var6 < class17.cacheLocations.length; ++var6) {
                        var26 = new File(class17.cacheLocations[var6] + class72.field879[var11] + File.separatorChar + "random.dat");
                        if(var26.exists()) {
                           class155.field2258 = new CacheFile(new FileOnDisk(var26, "rw", 25L), 24, 0);
                           break label131;
                        }
                     }
                  }
               }

               if(class155.field2258 == null) {
                  RandomAccessFile var25 = new RandomAccessFile(var22, "rw");
                  var6 = var25.read();
                  var25.seek(0L);
                  var25.write(var6);
                  var25.seek(0L);
                  var25.close();
                  class155.field2258 = new CacheFile(new FileOnDisk(var22, "rw", 25L), 24, 0);
               }
            } catch (IOException var16) {
               ;
            }

            class155.field2261 = new CacheFile(new FileOnDisk(IndexFile.method3104("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class155.field2260 = new CacheFile(new FileOnDisk(IndexFile.method3104("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class96.field1514 = new CacheFile[class267.field3668];

            for(int var12 = 0; var12 < class267.field3668; ++var12) {
               class96.field1514[var12] = new CacheFile(new FileOnDisk(IndexFile.method3104("main_file_cache.idx" + var12), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var17) {
            DynamicObject.method1932((String)null, var17);
         }

         PendingSpawn.clientInstance = this;
         this.initialize(765, 503, 155);
      }
   }
}
