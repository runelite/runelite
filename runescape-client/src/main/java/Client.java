import java.io.File;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.net.Socket;
import java.util.Date;
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
   static boolean field908;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1139677919
   )
   static int field986;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -660459319
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 519564331
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("la")
   static Widget field1079;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = 170002305
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1583326921
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1399180527
   )
   @Export("gameState")
   @Hook("gameStateChanged")
   static int gameState;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = 1751932291
   )
   static int field941;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = -41442539
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -72098075
   )
   @Export("world")
   static int world;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = -427148501
   )
   static int field958;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = -461123161
   )
   static int field1006;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 342321423
   )
   static int field1110;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      longValue = 1603960261392673345L
   )
   static long field951;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 229651861
   )
   static int field935;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1450920495
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1403964587
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("jp")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("mc")
   static boolean[] field1111;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -1086435805
   )
   @Export("packetType")
   static int packetType;
   @ObfuscatedName("mv")
   static boolean[] field938;
   @ObfuscatedName("my")
   static boolean[] field1112;
   @ObfuscatedName("jn")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -1850238333
   )
   static int field1055;
   @ObfuscatedName("kf")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("lu")
   static boolean field1087;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 432784621
   )
   @Export("secondLastFrameId")
   static int secondLastFrameId;
   @ObfuscatedName("bd")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("eu")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -213782409
   )
   @Export("packetLength")
   static int packetLength;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = 1238670715
   )
   static int field915;
   @ObfuscatedName("ew")
   @Export("secretPacketBuffer2")
   static PacketBuffer secretPacketBuffer2;
   @ObfuscatedName("ky")
   static boolean field1054;
   @ObfuscatedName("bl")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("jt")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 233705419
   )
   @Export("thridLastFrameId")
   static int thridLastFrameId;
   @ObfuscatedName("nj")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1072528917
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = -9736951
   )
   static int field937;
   @ObfuscatedName("lc")
   static boolean field1084;
   @ObfuscatedName("lh")
   static boolean field1076;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = -678576855
   )
   static int field939;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = -2044261867
   )
   static int field940;
   @ObfuscatedName("oq")
   static boolean field946;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = -1453746961
   )
   static int field1043;
   @ObfuscatedName("bk")
   static boolean field987;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = 1853266875
   )
   static int field1081;
   @ObfuscatedName("jx")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = -1737218257
   )
   static int field1082;
   @ObfuscatedName("ju")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      longValue = 375085351291985483L
   )
   static long field916;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = -1445532103
   )
   @Export(
      value = "gameDrawingMode",
      setter = true
   )
   static int gameDrawingMode;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = 1465797299
   )
   static int field1085;
   @ObfuscatedName("ei")
   @Export("secretPacketBuffer1")
   static PacketBuffer secretPacketBuffer1;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 93406547
   )
   static int field917;
   @ObfuscatedName("ma")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -102931237
   )
   static int field918;
   @ObfuscatedName("jf")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = 871361115
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1929953693
   )
   static int field919;
   @ObfuscatedName("kw")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 460740413
   )
   static int field982;
   @ObfuscatedName("lz")
   static Widget field920;
   @ObfuscatedName("bj")
   static boolean field1069;
   @ObfuscatedName("iq")
   static boolean field1023;
   @ObfuscatedName("kn")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("bq")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("nk")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = -699391025
   )
   static int field1051;
   @ObfuscatedName("nv")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("jd")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = -1474167947
   )
   static int field971;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = 929460115
   )
   static int field1137;
   @ObfuscatedName("jw")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = 1908234229
   )
   static int field1142;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1438664593
   )
   static int field1120;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -1803883597
   )
   static int field961;
   @ObfuscatedName("it")
   @Export("selectedItemName")
   static String selectedItemName;
   @ObfuscatedName("ku")
   static String field1064;
   @ObfuscatedName("je")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -274230107
   )
   static int field924;
   @ObfuscatedName("ng")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -1132680995
   )
   static int field962;
   @ObfuscatedName("nu")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -1570148317
   )
   static int field927;
   @ObfuscatedName("kz")
   static String field1019;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = 303774115
   )
   static int field963;
   @ObfuscatedName("rk")
   static int[] field1185;
   @ObfuscatedName("rh")
   static int[] field1091;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -265290295
   )
   static int field1032;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 1793986457
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = -64482829
   )
   static int field964;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = -1396642911
   )
   static int field1021;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = -365868623
   )
   static int field1017;
   @ObfuscatedName("rt")
   static final class73 field1184;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 1255790273
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 1754482651
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 1423380805
   )
   static int field929;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = 2011023753
   )
   static int field943;
   @ObfuscatedName("ld")
   static Widget field1078;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = -1662005079
   )
   static int field1104;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = -2007184565
   )
   static int field1048;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = -2016816741
   )
   static int field930;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = -1479144469
   )
   static int field1046;
   @ObfuscatedName("cu")
   static class91 field931;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 1658581347
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -1022520541
   )
   static int field1089;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -1219641789
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("cy")
   static class91 field932;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = 917457023
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = -838936645
   )
   static int field1172;
   @ObfuscatedName("id")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = -804854691
   )
   static int field1013;
   @ObfuscatedName("mp")
   static Deque field1105;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = 683366371
   )
   static int field1071;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = -2070112131
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = 1281175647
   )
   static int field1090;
   @ObfuscatedName("ci")
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = 585503965
   )
   static int field1015;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = -1934771133
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("ln")
   static boolean field1174;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -1399970065
   )
   @Export("audioEffectCount")
   static int audioEffectCount;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = 939732689
   )
   @Export("lastFrameId")
   static int lastFrameId;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = -364466471
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = -1752094959
   )
   static int field954;
   @ObfuscatedName("cm")
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("df")
   static byte[] field942;
   @ObfuscatedName("dg")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 600186319
   )
   static int field944;
   @ObfuscatedName("ee")
   static HashMap field960;
   @ObfuscatedName("da")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = 278028773
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("dv")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("rl")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = 1794469511
   )
   static int field1178;
   @ObfuscatedName("ki")
   static Widget field1070;
   @ObfuscatedName("qo")
   static PlayerComposition field1177;
   @ObfuscatedName("ej")
   static PacketBuffer field949;
   @ObfuscatedName("pn")
   static boolean[] field1153;
   @ObfuscatedName("pw")
   static int[] field1154;
   @ObfuscatedName("lg")
   static Widget field1083;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = -1164369799
   )
   static int field1045;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = 1098081135
   )
   static int field1066;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = 1627313019
   )
   static int field1101;
   @ObfuscatedName("pd")
   static int[] field1155;
   @ObfuscatedName("ft")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("qr")
   static int[] field1156;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = -271625279
   )
   static int field1103;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = 150615577
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("qm")
   static int[] field1157;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = 645940625
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = -482830803
   )
   static int field1056;
   @ObfuscatedName("qe")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = 954036553
   )
   static int field1099;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -2078123949
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 431821773
   )
   static int field1059;
   @ObfuscatedName("qg")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = 1601250515
   )
   static int field1010;
   @ObfuscatedName("pv")
   static boolean field1152;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      intValue = 962157163
   )
   static int field1080;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = 1983748251
   )
   static int field1140;
   @ObfuscatedName("pf")
   static int[] field1147;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -1775088879
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("mj")
   static int[] field1096;
   @ObfuscatedName("pz")
   static int[] field965;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = 841013903
   )
   static int field1097;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = -541359291
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = -731994309
   )
   static int field996;
   @ObfuscatedName("pg")
   static int[] field1149;
   @ObfuscatedName("mk")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("pe")
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("mr")
   static int[] field1092;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = -360840891
   )
   static int field1095;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = 747530699
   )
   static int field1093;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = -1678853183
   )
   static int field1183;
   @ObfuscatedName("pl")
   static int[] field1014;
   @ObfuscatedName("ha")
   static boolean field997;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 560642431
   )
   static int field1132;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -1189597743
   )
   static int field983;
   @ObfuscatedName("jo")
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = 274971989
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("jh")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("fm")
   static int[][][] field1119;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 1065817479
   )
   static int field925;
   @ObfuscatedName("ra")
   @ObfuscatedGetter(
      longValue = -8351178371626247853L
   )
   static long field1053;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = -307584275
   )
   static int field1100;
   @ObfuscatedName("rf")
   @ObfuscatedGetter(
      longValue = 3987331145493709675L
   )
   static long field1182;
   @ObfuscatedName("lv")
   static boolean field1075;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      longValue = 6957233859378799653L
   )
   static long field1130;
   @ObfuscatedName("qi")
   static class195 field1179;
   @ObfuscatedName("ok")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = 208747499
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("ow")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("fw")
   static final int[] field934;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = -269498525
   )
   static int field1134;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 388575245
   )
   static int field989;
   @ObfuscatedName("ov")
   static int[] field1135;
   @ObfuscatedName("no")
   static long[] field1125;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = -1642285963
   )
   static int field923;
   @ObfuscatedName("om")
   static int[] field1136;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = -1569722553
   )
   static int field970;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -1292090467
   )
   static int field1025;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -1865898663
   )
   static int field1113;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = 1207066745
   )
   static int field1028;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = -984639365
   )
   static int field1126;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 436676499
   )
   static int field974;
   @ObfuscatedName("ob")
   static SpritePixels[] field1035;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 516556377
   )
   static int field1050;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = 1584742515
   )
   static int field973;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = 196352507
   )
   static int field1133;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 983326405
   )
   static int field969;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = 1825937887
   )
   static int field1144;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = 761925771
   )
   static int field922;
   @ObfuscatedName("hw")
   static int[][] field1009;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = 1618983731
   )
   static int field976;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = 757330789
   )
   @Export("mapOffset")
   static int mapOffset;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -103888159
   )
   static int field1060;
   @ObfuscatedName("jl")
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 373829701
   )
   static int field980;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = 1471718305
   )
   static int field1123;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 1377565881
   )
   static int field981;
   @ObfuscatedName("ja")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 99211395
   )
   static int field1068;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 1717334759
   )
   static int field985;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -659622687
   )
   static int field972;
   @ObfuscatedName("qf")
   static short field1159;
   @ObfuscatedName("qk")
   static short field1007;
   @ObfuscatedName("gx")
   static boolean field1121;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -569546973
   )
   static int field988;
   @ObfuscatedName("jy")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("qd")
   static short field1164;
   @ObfuscatedName("jc")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("qt")
   static short field1165;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = -2090738375
   )
   static int field991;
   @ObfuscatedName("ql")
   static short field1127;
   @ObfuscatedName("qq")
   static short field1161;
   @ObfuscatedName("qj")
   static short field1160;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = 537098785
   )
   static int field992;
   @ObfuscatedName("qh")
   static short field1162;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = 332850715
   )
   static int field1065;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = 76407681
   )
   static int field994;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -875984539
   )
   static int field995;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = 1233155801
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -170005271
   )
   static int field1074;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = 1890376777
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = 890606225
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = 1473696705
   )
   static int field998;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 110102745
   )
   static int field999;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = 229175561
   )
   static int field1188;
   @ObfuscatedName("hh")
   static int[] field1186;
   @ObfuscatedName("ht")
   static int[] field1002;
   @ObfuscatedName("hg")
   static int[] field1003;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = -1823366121
   )
   static int field906;
   @ObfuscatedName("hf")
   static int[] field1004;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = -1604343831
   )
   static int field1166;
   @ObfuscatedName("ml")
   @ObfuscatedGetter(
      intValue = -1906678281
   )
   static int field1102;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = -685358557
   )
   static int field1143;
   @ObfuscatedName("hi")
   static int[] field1005;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = -353811067
   )
   static int field1029;
   @ObfuscatedName("hk")
   static int[] field1163;
   @ObfuscatedName("hq")
   static int[] field1167;
   @ObfuscatedName("np")
   static int[] field1169;
   @ObfuscatedName("hn")
   static String[] field1008;
   @ObfuscatedName("mb")
   static Deque field1106;
   @ObfuscatedName("nq")
   static int[] field1001;
   @ObfuscatedName("mm")
   static Deque field1115;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = -1815169513
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("ic")
   static int[] field1030;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = 1411223017
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = 1233904359
   )
   static int field1022;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 1671036607
   )
   static int field1062;
   @ObfuscatedName("js")
   static int[] field1034;
   @ObfuscatedName("jk")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("lm")
   static boolean field1026;
   @ObfuscatedName("kl")
   static boolean field1052;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = 1712256313
   )
   static int field910;
   @ObfuscatedName("rx")
   static short[] field1181;
   @ObfuscatedName("nw")
   static String field1124;
   @ObfuscatedName("nm")
   static int[] field1024;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -1513273183
   )
   static int field1063;

   static {
      field908 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field987 = true;
      gameCycle = 0;
      field916 = -1L;
      field917 = -1;
      field918 = -1;
      field919 = -1;
      field1069 = true;
      displayFps = false;
      field986 = 0;
      field1120 = 0;
      field924 = 0;
      field927 = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowType = 0;
      field929 = 0;
      field930 = 0;
      field931 = class91.field1409;
      field932 = class91.field1409;
      loadingStage = 0;
      js5State = 0;
      field935 = 0;
      field937 = 0;
      loginState = 0;
      field939 = 0;
      field941 = 0;
      field954 = 0;
      field942 = null;
      cachedNPCs = new NPC['耀'];
      field944 = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      secretPacketBuffer1 = new PacketBuffer(5000);
      field949 = new PacketBuffer(5000);
      secretPacketBuffer2 = new PacketBuffer(15000);
      packetLength = 0;
      packetType = 0;
      field1090 = 0;
      audioEffectCount = 0;
      lastFrameId = 0;
      secondLastFrameId = 0;
      thridLastFrameId = 0;
      field958 = 0;
      socketError = false;
      field960 = new HashMap();
      field961 = 0;
      field962 = 1;
      field963 = 0;
      field964 = 1;
      field971 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field1119 = new int[4][13][13];
      field934 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field970 = 0;
      field1113 = 2;
      field1050 = 0;
      field973 = 2;
      field969 = 0;
      field922 = 1;
      field976 = 0;
      mapScale = 0;
      mapOffset = 2;
      mapScaleDelta = 0;
      field980 = 1;
      field981 = 0;
      field982 = 0;
      field983 = 2301979;
      field974 = 5063219;
      field985 = 3353893;
      field1144 = 7759444;
      field1121 = false;
      field988 = 0;
      field989 = 128;
      mapAngle = 0;
      field991 = 0;
      field992 = 0;
      field1065 = 0;
      field994 = 0;
      field995 = 50;
      field996 = 0;
      field997 = false;
      field998 = 0;
      field999 = 0;
      field1188 = 50;
      field1186 = new int[field1188];
      field1002 = new int[field1188];
      field1003 = new int[field1188];
      field1004 = new int[field1188];
      field1005 = new int[field1188];
      field1163 = new int[field1188];
      field1167 = new int[field1188];
      field1008 = new String[field1188];
      field1009 = new int[104][104];
      field1010 = 0;
      screenY = -1;
      screenX = -1;
      field1013 = 0;
      field1071 = 0;
      field1015 = 0;
      cursorState = 0;
      field1017 = 0;
      field1048 = 0;
      field943 = 0;
      field1032 = 0;
      field1021 = 0;
      field1022 = 0;
      field1023 = false;
      field1051 = 0;
      field1025 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field1028 = 0;
      field1029 = 0;
      field1030 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field1034 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field925 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field1043 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field1052 = false;
      field940 = -1;
      field1054 = false;
      field1055 = -1;
      field915 = -1;
      field1132 = 0;
      field1183 = 50;
      itemSelectionState = 0;
      selectedItemName = null;
      spellSelected = false;
      field1062 = -1;
      field1063 = -1;
      field1064 = null;
      field1019 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field1068 = 0;
      field972 = 0;
      field1070 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1074 = -1;
      field1075 = false;
      field1076 = false;
      field1026 = false;
      field1078 = null;
      field1079 = null;
      field920 = null;
      field1081 = 0;
      field1082 = 0;
      field1083 = null;
      field1084 = false;
      field1085 = -1;
      field1137 = -1;
      field1087 = false;
      field1046 = -1;
      field1089 = -1;
      field1174 = false;
      field1045 = 1;
      field1092 = new int[32];
      field1093 = 0;
      interfaceItemTriggers = new int[32];
      field1095 = 0;
      field1096 = new int[32];
      field1097 = 0;
      field910 = 0;
      field1099 = 0;
      field1100 = 0;
      field1101 = 0;
      field1102 = 0;
      field1103 = 0;
      field1104 = 0;
      field1105 = new Deque();
      field1106 = new Deque();
      field1115 = new Deque();
      widgetFlags = new XHashTable(512);
      field1006 = 0;
      field1110 = -2;
      field1111 = new boolean[100];
      field1112 = new boolean[100];
      field938 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field951 = 0L;
      isResized = true;
      field1024 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field1060 = 0;
      field1123 = 0;
      field1124 = "";
      field1125 = new long[100];
      field1126 = 0;
      field906 = 0;
      field1001 = new int[128];
      field1169 = new int[128];
      field1130 = -1L;
      clanChatOwner = null;
      clanChatName = null;
      field1133 = -1;
      field1134 = 0;
      field1135 = new int[1000];
      field1136 = new int[1000];
      field1035 = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1140 = 0;
      field923 = 255;
      field1142 = -1;
      field946 = false;
      field1059 = 127;
      field1172 = 127;
      field1080 = 0;
      field1147 = new int[50];
      field965 = new int[50];
      field1149 = new int[50];
      field1014 = new int[50];
      audioEffects = new SoundEffect[50];
      field1152 = false;
      field1153 = new boolean[5];
      field1154 = new int[5];
      field1155 = new int[5];
      field1156 = new int[5];
      field1157 = new int[5];
      field1007 = 256;
      field1159 = 205;
      field1160 = 256;
      field1161 = 320;
      field1162 = 1;
      field1127 = 32767;
      field1164 = 1;
      field1165 = 32767;
      field1166 = 0;
      field1143 = 0;
      viewportHeight = 0;
      viewportWidth = 0;
      scale = 0;
      friendCount = 0;
      field1056 = 0;
      friends = new Friend[400];
      field1179 = new class195();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1177 = new PlayerComposition();
      field1178 = -1;
      field1066 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field1182 = -1L;
      field1053 = -1L;
      field1184 = new class73();
      field1185 = new int[50];
      field1091 = new int[50];
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-125603941"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         boolean var1 = PlayerComposition.method3961();
         if(!var1) {
            this.method1150();
         }

      }
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-7424"
   )
   void method1155() {
      int var1 = class77.canvasWidth;
      int var2 = FloorUnderlayDefinition.canvasHeight;
      if(super.field699 < var1) {
         var1 = super.field699;
      }

      if(super.field693 < var2) {
         var2 = super.field693;
      }

      if(class23.preferences != null) {
         try {
            Client var3 = class28.clientInstance;
            Object[] var4 = new Object[]{Integer.valueOf(Player.method1119())};
            JSObject.getWindow(var3).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1865510384"
   )
   protected final void vmethod1148() {
      if(class46.chatMessages.changed()) {
         class46.chatMessages.serialize();
      }

      if(KeyFocusListener.field641 != null) {
         KeyFocusListener.field641.field848 = false;
      }

      KeyFocusListener.field641 = null;
      if(Occluder.rssocket != null) {
         Occluder.rssocket.close();
         Occluder.rssocket = null;
      }

      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var1 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

      class66.method1086();
      Actor.field1274 = null;
      if(class290.soundSystem0 != null) {
         class290.soundSystem0.method1988();
      }

      if(KeyFocusListener.soundSystem1 != null) {
         KeyFocusListener.soundSystem1.method1988();
      }

      if(class238.field3264 != null) {
         class238.field3264.close();
      }

      class152.method2917();
      FrameMap.method2664();
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "315332154"
   )
   protected final void vmethod1145() {
      class87.field1388 = socketType == 0?'ꩊ':world + '鱀';
      GameObject.field2188 = socketType == 0?443:world + '썐';
      class9.myWorldPort = class87.field1388;
      PlayerComposition.colorsToFind = class214.field2635;
      class203.colorsToReplace = class214.field2634;
      PlayerComposition.field2621 = class214.field2638;
      class91.field1414 = class214.field2636;
      this.method856();
      this.method857();
      Actor.field1274 = this.method853();
      World.field1295 = new IndexFile(255, class155.field2237, class155.field2246, 500000);
      class23.preferences = class261.method4654();
      this.method854();
      class95.method1747(this, Spotanim.field3340);
      if(socketType != 0) {
         displayFps = true;
      }

      class1.method1(class23.preferences.screenType);
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-935818403"
   )
   final void method1160(boolean var1) {
      int var2 = widgetRoot;
      int var3 = class77.canvasWidth;
      int var4 = FloorUnderlayDefinition.canvasHeight;
      if(class33.loadWidget(var2)) {
         class17.method120(Widget.widgets[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "38"
   )
   @Export("error")
   void error(int var1) {
      BaseVarType.socket = null;
      class96.rssocket = null;
      js5State = 0;
      if(class9.myWorldPort == class87.field1388) {
         class9.myWorldPort = GameObject.field2188;
      } else {
         class9.myWorldPort = class87.field1388;
      }

      ++field937;
      if(field937 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field935 = 3000;
         }
      } else if(field937 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field937 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field935 = 3000;
         }
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1825419509"
   )
   protected final void vmethod1143() {
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "24"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();
      RSCanvas.method797();
      class140.method2855();
      class46.method712();
      class90.method1691();
      MouseInput var1 = MouseInput.mouse;
      synchronized(MouseInput.mouse) {
         MouseInput.field721 = MouseInput.field718 * 1223886835;
         MouseInput.field722 = MouseInput.mouseX;
         MouseInput.field723 = MouseInput.mouseY;
         MouseInput.field728 = MouseInput.field715;
         MouseInput.field735 = MouseInput.field725;
         MouseInput.field730 = MouseInput.field726;
         MouseInput.field729 = MouseInput.field714;
         MouseInput.field715 = 0;
      }

      if(Actor.field1274 != null) {
         int var24 = Actor.field1274.vmethod2964();
         field1104 = var24;
      }

      if(gameState == 0) {
         BaseVarType.load();
         class14.method78();
      } else if(gameState == 5) {
         class29.method239(this);
         BaseVarType.load();
         class14.method78();
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class29.method239(this);
            this.method1152();
         } else if(gameState == 25) {
            class134.flush(false);
            field961 = 0;
            boolean var39 = true;

            int var2;
            for(var2 = 0; var2 < class39.field525.length; ++var2) {
               if(class10.field259[var2] != -1 && class39.field525[var2] == null) {
                  class39.field525[var2] = class12.indexMaps.getConfigData(class10.field259[var2], 0);
                  if(class39.field525[var2] == null) {
                     var39 = false;
                     ++field961;
                  }
               }

               if(CombatInfoListHolder.landRegionFielIds[var2] != -1 && class25.field365[var2] == null) {
                  class25.field365[var2] = class12.indexMaps.getConfigData(CombatInfoListHolder.landRegionFielIds[var2], 0, class73.xteaKeys[var2]);
                  if(class25.field365[var2] == null) {
                     var39 = false;
                     ++field961;
                  }
               }
            }

            if(!var39) {
               field971 = 1;
            } else {
               field963 = 0;
               var39 = true;

               int var4;
               int var5;
               Buffer var9;
               int var10;
               int var11;
               int var12;
               int var14;
               int var15;
               int var16;
               int var17;
               int var18;
               int var19;
               for(var2 = 0; var2 < class39.field525.length; ++var2) {
                  byte[] var3 = class25.field365[var2];
                  if(var3 != null) {
                     var4 = (RSCanvas.mapRegions[var2] >> 8) * 64 - class163.baseX;
                     var5 = (RSCanvas.mapRegions[var2] & 255) * 64 - class10.baseY;
                     if(isDynamicRegion) {
                        var4 = 10;
                        var5 = 10;
                     }

                     boolean var8 = true;
                     var9 = new Buffer(var3);
                     var10 = -1;

                     label586:
                     while(true) {
                        var11 = var9.getUSmart();
                        if(var11 == 0) {
                           var39 &= var8;
                           break;
                        }

                        var10 += var11;
                        var12 = 0;
                        boolean var13 = false;

                        while(true) {
                           while(!var13) {
                              var14 = var9.getUSmart();
                              if(var14 == 0) {
                                 continue label586;
                              }

                              var12 += var14 - 1;
                              var15 = var12 & 63;
                              var16 = var12 >> 6 & 63;
                              var17 = var9.readUnsignedByte() >> 2;
                              var18 = var4 + var16;
                              var19 = var5 + var15;
                              if(var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
                                 ObjectComposition var20 = PlayerComposition.getObjectDefinition(var10);
                                 if(var17 != 22 || !lowMemory || var20.field3453 != 0 || var20.interactType == 1 || var20.field3472) {
                                    if(!var20.method4468()) {
                                       ++field963;
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

               if(!var39) {
                  field971 = 2;
               } else {
                  if(field971 != 0) {
                     class89.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                  }

                  class46.method712();
                  MilliTimer.method2912();
                  class46.method712();
                  class29.region.reset();
                  class46.method712();
                  System.gc();

                  for(var2 = 0; var2 < 4; ++var2) {
                     collisionMaps[var2].reset();
                  }

                  int var25;
                  for(var2 = 0; var2 < 4; ++var2) {
                     for(var25 = 0; var25 < 104; ++var25) {
                        for(var4 = 0; var4 < 104; ++var4) {
                           class61.tileSettings[var2][var25][var4] = 0;
                        }
                     }
                  }

                  class46.method712();
                  class7.method22();
                  var2 = class39.field525.length;
                  class12.method67();
                  class134.flush(true);
                  int var6;
                  int var7;
                  int var36;
                  int var38;
                  if(!isDynamicRegion) {
                     var25 = 0;

                     label524:
                     while(true) {
                        byte[] var26;
                        if(var25 >= var2) {
                           for(var25 = 0; var25 < var2; ++var25) {
                              var4 = (RSCanvas.mapRegions[var25] >> 8) * 64 - class163.baseX;
                              var5 = (RSCanvas.mapRegions[var25] & 255) * 64 - class10.baseY;
                              var26 = class39.field525[var25];
                              if(var26 == null && class31.field435 < 800) {
                                 class46.method712();
                                 CacheFile.method2351(var4, var5, 64, 64);
                              }
                           }

                           class134.flush(true);
                           var25 = 0;

                           while(true) {
                              if(var25 >= var2) {
                                 break label524;
                              }

                              byte[] var29 = class25.field365[var25];
                              if(var29 != null) {
                                 var5 = (RSCanvas.mapRegions[var25] >> 8) * 64 - class163.baseX;
                                 var6 = (RSCanvas.mapRegions[var25] & 255) * 64 - class10.baseY;
                                 class46.method712();
                                 Region var30 = class29.region;
                                 CollisionData[] var31 = collisionMaps;
                                 var9 = new Buffer(var29);
                                 var10 = -1;

                                 while(true) {
                                    var11 = var9.getUSmart();
                                    if(var11 == 0) {
                                       break;
                                    }

                                    var10 += var11;
                                    var12 = 0;

                                    while(true) {
                                       var38 = var9.getUSmart();
                                       if(var38 == 0) {
                                          break;
                                       }

                                       var12 += var38 - 1;
                                       var14 = var12 & 63;
                                       var15 = var12 >> 6 & 63;
                                       var16 = var12 >> 12;
                                       var17 = var9.readUnsignedByte();
                                       var18 = var17 >> 2;
                                       var19 = var17 & 3;
                                       int var32 = var5 + var15;
                                       int var21 = var14 + var6;
                                       if(var32 > 0 && var21 > 0 && var32 < 103 && var21 < 103) {
                                          int var22 = var16;
                                          if((class61.tileSettings[1][var32][var21] & 2) == 2) {
                                             var22 = var16 - 1;
                                          }

                                          CollisionData var23 = null;
                                          if(var22 >= 0) {
                                             var23 = var31[var22];
                                          }

                                          class60.addObject(var16, var32, var21, var10, var19, var18, var30, var23);
                                       }
                                    }
                                 }
                              }

                              ++var25;
                           }
                        }

                        var4 = (RSCanvas.mapRegions[var25] >> 8) * 64 - class163.baseX;
                        var5 = (RSCanvas.mapRegions[var25] & 255) * 64 - class10.baseY;
                        var26 = class39.field525[var25];
                        if(var26 != null) {
                           class46.method712();
                           var7 = class37.field494 * 8 - 48;
                           var36 = class31.field435 * 8 - 48;
                           CollisionData[] var37 = collisionMaps;
                           var10 = 0;

                           label521:
                           while(true) {
                              if(var10 >= 4) {
                                 Buffer var28 = new Buffer(var26);
                                 var11 = 0;

                                 while(true) {
                                    if(var11 >= 4) {
                                       break label521;
                                    }

                                    for(var12 = 0; var12 < 64; ++var12) {
                                       for(var38 = 0; var38 < 64; ++var38) {
                                          class96.loadTerrain(var28, var11, var12 + var4, var38 + var5, var7, var36, 0);
                                       }
                                    }

                                    ++var11;
                                 }
                              }

                              for(var11 = 0; var11 < 64; ++var11) {
                                 for(var12 = 0; var12 < 64; ++var12) {
                                    if(var4 + var11 > 0 && var11 + var4 < 103 && var5 + var12 > 0 && var12 + var5 < 103) {
                                       var37[var10].flags[var11 + var4][var12 + var5] &= -16777217;
                                    }
                                 }
                              }

                              ++var10;
                           }
                        }

                        ++var25;
                     }
                  }

                  int var27;
                  if(isDynamicRegion) {
                     var25 = 0;

                     label457:
                     while(true) {
                        if(var25 >= 4) {
                           for(var25 = 0; var25 < 13; ++var25) {
                              for(var4 = 0; var4 < 13; ++var4) {
                                 var5 = field1119[0][var25][var4];
                                 if(var5 == -1) {
                                    CacheFile.method2351(var25 * 8, var4 * 8, 8, 8);
                                 }
                              }
                           }

                           class134.flush(true);
                           var25 = 0;

                           while(true) {
                              if(var25 >= 4) {
                                 break label457;
                              }

                              class46.method712();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    var6 = field1119[var25][var4][var5];
                                    if(var6 != -1) {
                                       var7 = var6 >> 24 & 3;
                                       var36 = var6 >> 1 & 3;
                                       var27 = var6 >> 14 & 1023;
                                       var10 = var6 >> 3 & 2047;
                                       var11 = (var27 / 8 << 8) + var10 / 8;

                                       for(var12 = 0; var12 < RSCanvas.mapRegions.length; ++var12) {
                                          if(RSCanvas.mapRegions[var12] == var11 && class25.field365[var12] != null) {
                                             class27.method216(class25.field365[var12], var25, var4 * 8, var5 * 8, var7, (var27 & 7) * 8, (var10 & 7) * 8, var36, class29.region, collisionMaps);
                                             break;
                                          }
                                       }
                                    }
                                 }
                              }

                              ++var25;
                           }
                        }

                        class46.method712();

                        for(var4 = 0; var4 < 13; ++var4) {
                           for(var5 = 0; var5 < 13; ++var5) {
                              boolean var35 = false;
                              var7 = field1119[var25][var4][var5];
                              if(var7 != -1) {
                                 var36 = var7 >> 24 & 3;
                                 var27 = var7 >> 1 & 3;
                                 var10 = var7 >> 14 & 1023;
                                 var11 = var7 >> 3 & 2047;
                                 var12 = (var10 / 8 << 8) + var11 / 8;

                                 for(var38 = 0; var38 < RSCanvas.mapRegions.length; ++var38) {
                                    if(RSCanvas.mapRegions[var38] == var12 && class39.field525[var38] != null) {
                                       class8.method41(class39.field525[var38], var25, var4 * 8, var5 * 8, var36, (var10 & 7) * 8, (var11 & 7) * 8, var27, collisionMaps);
                                       var35 = true;
                                       break;
                                    }
                                 }
                              }

                              if(!var35) {
                                 XGrandExchangeOffer.method117(var25, var4 * 8, var5 * 8);
                              }
                           }
                        }

                        ++var25;
                     }
                  }

                  class134.flush(true);
                  MilliTimer.method2912();
                  class46.method712();
                  PendingSpawn.method1476(class29.region, collisionMaps);
                  class134.flush(true);
                  var25 = class61.field747;
                  if(var25 > class45.plane) {
                     var25 = class45.plane;
                  }

                  if(var25 < class45.plane - 1) {
                     var25 = class45.plane - 1;
                  }

                  if(lowMemory) {
                     class29.region.setup(class61.field747);
                  } else {
                     class29.region.setup(0);
                  }

                  for(var4 = 0; var4 < 104; ++var4) {
                     for(var5 = 0; var5 < 104; ++var5) {
                        class47.groundItemSpawned(var4, var5);
                     }
                  }

                  class46.method712();
                  Signlink.method2954();
                  ObjectComposition.field3446.reset();
                  if(class28.clientInstance.method884()) {
                     secretPacketBuffer1.putOpcode(65);
                     secretPacketBuffer1.putInt(1057001181);
                  }

                  if(!isDynamicRegion) {
                     var4 = (class37.field494 - 6) / 8;
                     var5 = (class37.field494 + 6) / 8;
                     var6 = (class31.field435 - 6) / 8;
                     var7 = (class31.field435 + 6) / 8;

                     for(var36 = var4 - 1; var36 <= var5 + 1; ++var36) {
                        for(var27 = var6 - 1; var27 <= var7 + 1; ++var27) {
                           if(var36 < var4 || var36 > var5 || var27 < var6 || var27 > var7) {
                              class12.indexMaps.method4103("m" + var36 + "_" + var27);
                              class12.indexMaps.method4103("l" + var36 + "_" + var27);
                           }
                        }
                     }
                  }

                  WorldMapType2.setGameState(30);
                  class46.method712();
                  class1.resetMapInfo();
                  secretPacketBuffer1.putOpcode(90);
                  class14.method78();
               }
            }
         }
      } else {
         class29.method239(this);
      }

      if(gameState == 30) {
         this.method1153();
      } else if(gameState == 40 || gameState == 45) {
         this.method1152();
      }

   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-115"
   )
   @Export("processServerPacket")
   final boolean processServerPacket() {
      if(Occluder.rssocket == null) {
         return false;
      } else {
         int var3;
         String var25;
         try {
            int var1 = Occluder.rssocket.available();
            if(var1 == 0) {
               return false;
            }

            if(packetType == -1) {
               Occluder.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               packetLength = class272.field3703[packetType];
               --var1;
            }

            if(packetLength == -1) {
               if(var1 <= 0) {
                  return false;
               }

               Occluder.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               packetLength = secretPacketBuffer2.payload[0] & 255;
               --var1;
            }

            if(packetLength == -2) {
               if(var1 <= 1) {
                  return false;
               }

               Occluder.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();
               var1 -= 2;
            }

            if(var1 < packetLength) {
               return false;
            }

            secretPacketBuffer2.offset = 0;
            Occluder.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
            field1090 = 0;
            thridLastFrameId = secondLastFrameId;
            secondLastFrameId = lastFrameId;
            lastFrameId = packetType;
            int var2;
            if(packetType == 131) {
               field1152 = false;

               for(var2 = 0; var2 < 5; ++var2) {
                  field1153[var2] = false;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 180) {
               field1056 = 1;
               field1099 = field1045;
               packetType = -1;
               return true;
            }

            if(packetType == 79) {
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

            if(packetType == 106) {
               for(var2 = 0; var2 < VarPlayerType.field3283; ++var2) {
                  VarPlayerType var89 = class169.method3109(var2);
                  if(var89 != null) {
                     class211.settings[var2] = 0;
                     class211.widgetSettings[var2] = 0;
                  }
               }

               class7.method35();
               field1093 += 32;
               packetType = -1;
               return true;
            }

            if(packetType == 228) {
               for(var2 = 0; var2 < class211.widgetSettings.length; ++var2) {
                  if(class211.widgetSettings[var2] != class211.settings[var2]) {
                     class211.widgetSettings[var2] = class211.settings[var2];
                     class3.method8(var2);
                     field1092[++field1093 - 1 & 31] = var2;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 107) {
               field1140 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == 186) {
               field986 = secretPacketBuffer2.readUnsignedShortOb1() * 30;
               field1103 = field1045;
               packetType = -1;
               return true;
            }

            int var22;
            if(packetType == 123) {
               var3 = secretPacketBuffer2.readUnsignedByte();
               class276[] var110 = new class276[]{class276.field3732, class276.field3730, class276.field3734};
               class276[] var115 = var110;
               var22 = 0;

               class276 var108;
               while(true) {
                  if(var22 >= var115.length) {
                     var108 = null;
                     break;
                  }

                  class276 var95 = var115[var22];
                  if(var3 == var95.field3731) {
                     var108 = var95;
                     break;
                  }

                  ++var22;
               }

               MouseInput.field732 = var108;
               packetType = -1;
               return true;
            }

            int var10;
            int var15;
            int var33;
            long var44;
            int var47;
            String var66;
            int var75;
            String var81;
            String var85;
            String var113;
            if(packetType == 23) {
               var25 = secretPacketBuffer2.readString();
               class8.sessionToken = var25;

               try {
                  var81 = class28.clientInstance.getParameter(Parameters.field3720.key);
                  var85 = class28.clientInstance.getParameter(Parameters.field3725.key);
                  var113 = var81 + "settings=" + var25 + "; version=1; path=/; domain=" + var85;
                  String var94;
                  if(var25.length() == 0) {
                     var113 = var113 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var66 = var113 + "; Expires=";
                     var44 = class46.currentTimeMs() + 94608000000L;
                     class182.field2438.setTime(new Date(var44));
                     var10 = class182.field2438.get(7);
                     var33 = class182.field2438.get(5);
                     var75 = class182.field2438.get(2);
                     int var116 = class182.field2438.get(1);
                     var47 = class182.field2438.get(11);
                     var15 = class182.field2438.get(12);
                     int var48 = class182.field2438.get(13);
                     var94 = class182.field2436[var10 - 1] + ", " + var33 / 10 + var33 % 10 + "-" + class182.field2440[0][var75] + "-" + var116 + " " + var47 / 10 + var47 % 10 + ":" + var15 / 10 + var15 % 10 + ":" + var48 / 10 + var48 % 10 + " GMT";
                     var113 = var66 + var94 + "; Max-Age=" + 94608000L;
                  }

                  Client var72 = class28.clientInstance;
                  var94 = "document.cookie=\"" + var113 + "\"";
                  JSObject.getWindow(var72).eval(var94);
               } catch (Throwable var56) {
                  ;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 185) {
               var2 = secretPacketBuffer2.method3263();
               class8.field244 = GameEngine.taskManager.createHost(var2);
               packetType = -1;
               return true;
            }

            int var4;
            if(packetType == 168) {
               var2 = secretPacketBuffer2.readByteOb1();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               if(var2 == -1 && !field946) {
                  class203.field2500.method3703();
                  class203.field2501 = 1;
                  class203.field2502 = null;
               } else if(var2 != -1 && var2 != field1142 && field923 != 0 && !field946) {
                  IndexData var87 = class182.indexTrack1;
                  var4 = field923;
                  class203.field2501 = 1;
                  class203.field2502 = var87;
                  class203.field2503 = var2;
                  MilliTimer.field2204 = 0;
                  class203.field2504 = var4;
                  class203.field2505 = false;
                  class73.field861 = 2;
               }

               field1142 = var2;
               packetType = -1;
               return true;
            }

            if(packetType == 212) {
               var2 = secretPacketBuffer2.method3176();
               XItemContainer var86 = (XItemContainer)XItemContainer.itemContainers.get((long)var2);
               if(var86 != null) {
                  var86.unlink();
               }

               interfaceItemTriggers[++field1095 - 1 & 31] = var2 & 32767;
               packetType = -1;
               return true;
            }

            Widget var84;
            if(packetType == 127) {
               var2 = secretPacketBuffer2.method3263();
               var84 = class61.method1038(var2);

               for(var4 = 0; var4 < var84.itemIds.length; ++var4) {
                  var84.itemIds[var4] = -1;
                  var84.itemIds[var4] = 0;
               }

               class48.method749(var84);
               packetType = -1;
               return true;
            }

            if(packetType == 28) {
               var2 = secretPacketBuffer2.method3184();
               var84 = class61.method1038(var2);
               var84.modelType = 3;
               var84.modelId = Script.localPlayer.composition.method3941();
               class48.method749(var84);
               packetType = -1;
               return true;
            }

            if(packetType == 136) {
               class7.method35();
               weight = secretPacketBuffer2.readShort();
               field1103 = field1045;
               packetType = -1;
               return true;
            }

            if(packetType == 72) {
               class7.method35();
               energy = secretPacketBuffer2.readUnsignedByte();
               field1103 = field1045;
               packetType = -1;
               return true;
            }

            if(packetType == 80) {
               field1060 = secretPacketBuffer2.readUnsignedByte();
               field1123 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == 141) {
               WorldMapType2.field514 = secretPacketBuffer2.readUnsignedByte();
               class251.field3390 = secretPacketBuffer2.method3165();
               packetType = -1;
               return true;
            }

            if(packetType == 14) {
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

            if(packetType == 234) {
               var2 = secretPacketBuffer2.method3180();
               var3 = secretPacketBuffer2.readUnsignedShort();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               if(field923 != 0 && var3 != -1) {
                  Friend.method1083(class10.indexTrack2, var3, 0, field923, false);
                  field946 = true;
               }

               packetType = -1;
               return true;
            }

            boolean var63;
            if(packetType == 223) {
               var63 = secretPacketBuffer2.readUnsignedByte() == 1;
               if(var63) {
                  Ignore.field843 = class46.currentTimeMs() - secretPacketBuffer2.readLong();
                  XClanMember.field904 = new class13(secretPacketBuffer2, true);
               } else {
                  XClanMember.field904 = null;
               }

               field1102 = field1045;
               packetType = -1;
               return true;
            }

            if(packetType == 216) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               if(secretPacketBuffer2.readUnsignedByte() == 0) {
                  grandExchangeOffers[var2] = new XGrandExchangeOffer();
                  secretPacketBuffer2.offset += 18;
               } else {
                  --secretPacketBuffer2.offset;
                  grandExchangeOffers[var2] = new XGrandExchangeOffer(secretPacketBuffer2, false);
               }

               field1101 = field1045;
               packetType = -1;
               return true;
            }

            if(packetType == 52) {
               var25 = secretPacketBuffer2.readString();
               PacketBuffer var109 = secretPacketBuffer2;

               try {
                  var22 = var109.getUSmart();
                  if(var22 > 32767) {
                     var22 = 32767;
                  }

                  byte[] var92 = new byte[var22];
                  var109.offset += class265.field3657.decompress(var109.payload, var109.offset, var92, 0, var22);
                  String var105 = class7.getString(var92, 0, var22);
                  var113 = var105;
               } catch (Exception var57) {
                  var113 = "Cabbage";
               }

               var113 = FontTypeFace.appendTags(XGrandExchangeOffer.method116(var113));
               WidgetNode.sendGameMessage(6, var25, var113);
               packetType = -1;
               return true;
            }

            Widget var93;
            if(packetType == 244) {
               var25 = secretPacketBuffer2.readString();
               var3 = secretPacketBuffer2.method3263();
               var93 = class61.method1038(var3);
               if(!var25.equals(var93.text)) {
                  var93.text = var25;
                  class48.method749(var93);
               }

               packetType = -1;
               return true;
            }

            int var5;
            int var7;
            if(packetType == 177) {
               var2 = secretPacketBuffer2.method3184();
               var3 = secretPacketBuffer2.readByteOb1();
               var4 = var3 >> 10 & 31;
               var5 = var3 >> 5 & 31;
               var22 = var3 & 31;
               var7 = (var5 << 11) + (var4 << 19) + (var22 << 3);
               Widget var103 = class61.method1038(var2);
               if(var7 != var103.textColor) {
                  var103.textColor = var7;
                  class48.method749(var103);
               }

               packetType = -1;
               return true;
            }

            boolean var74;
            if(packetType == 154) {
               var2 = secretPacketBuffer2.readInt();
               var74 = secretPacketBuffer2.readUnsignedByte() == 1;
               var93 = class61.method1038(var2);
               if(var74 != var93.isHidden) {
                  var93.isHidden = var74;
                  class48.method749(var93);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 200) {
               var2 = secretPacketBuffer2.method3184();
               var3 = secretPacketBuffer2.method3179();
               var93 = class61.method1038(var2);
               if(var3 != var93.field2777 || var3 == -1) {
                  var93.field2777 = var3;
                  var93.field2772 = 0;
                  var93.field2776 = 0;
                  class48.method749(var93);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 227) {
               var2 = secretPacketBuffer2.method3263();
               var3 = secretPacketBuffer2.method3176();
               var93 = class61.method1038(var2);
               if(var93.modelType != 1 || var3 != var93.modelId) {
                  var93.modelType = 1;
                  var93.modelId = var3;
                  class48.method749(var93);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 161) {
               var2 = secretPacketBuffer2.method3263();
               var3 = secretPacketBuffer2.readByteOb1();
               var93 = class61.method1038(var2);
               if(var93.modelType != 2 || var3 != var93.modelId) {
                  var93.modelType = 2;
                  var93.modelId = var3;
                  class48.method749(var93);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 252) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.readUnsignedShortOb1();
               var93 = class61.method1038(var2);
               if(var93 != null && var93.type == 0) {
                  if(var3 > var93.scrollHeight - var93.height) {
                     var3 = var93.scrollHeight - var93.height;
                  }

                  if(var3 < 0) {
                     var3 = 0;
                  }

                  if(var3 != var93.scrollY) {
                     var93.scrollY = var3;
                     class48.method749(var93);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 120) {
               class251.field3390 = secretPacketBuffer2.method3249();
               WorldMapType2.field514 = secretPacketBuffer2.method3249();

               for(var2 = WorldMapType2.field514; var2 < WorldMapType2.field514 + 8; ++var2) {
                  for(var3 = class251.field3390; var3 < class251.field3390 + 8; ++var3) {
                     if(groundItemDeque[class45.plane][var2][var3] != null) {
                        groundItemDeque[class45.plane][var2][var3] = null;
                        class47.groundItemSpawned(var2, var3);
                     }
                  }
               }

               for(PendingSpawn var107 = (PendingSpawn)pendingSpawns.getFront(); var107 != null; var107 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var107.x >= WorldMapType2.field514 && var107.x < WorldMapType2.field514 + 8 && var107.y >= class251.field3390 && var107.y < class251.field3390 + 8 && var107.level == class45.plane) {
                     var107.hitpoints = 0;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 217) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.readUnsignedShort();
               class211.settings[var3] = var2;
               if(class211.widgetSettings[var3] != var2) {
                  class211.widgetSettings[var3] = var2;
               }

               class3.method8(var3);
               field1092[++field1093 - 1 & 31] = var3;
               packetType = -1;
               return true;
            }

            if(packetType != 248 && packetType != 214 && packetType != 122 && packetType != 102 && packetType != 221 && packetType != 56 && packetType != 105 && packetType != 34 && packetType != 109) {
               if(packetType == 189) {
                  var2 = secretPacketBuffer2.method3176();
                  byte var77 = secretPacketBuffer2.method3169();
                  class211.settings[var2] = var77;
                  if(class211.widgetSettings[var2] != var77) {
                     class211.widgetSettings[var2] = var77;
                  }

                  class3.method8(var2);
                  field1092[++field1093 - 1 & 31] = var2;
                  packetType = -1;
                  return true;
               }

               if(packetType == 62) {
                  var2 = secretPacketBuffer2.readUnsignedByte();
                  var3 = secretPacketBuffer2.method3166();
                  var85 = secretPacketBuffer2.readString();
                  if(var3 >= 1 && var3 <= 8) {
                     if(var85.equalsIgnoreCase("null")) {
                        var85 = null;
                     }

                     playerOptions[var3 - 1] = var85;
                     playerOptionsPriorities[var3 - 1] = var2 == 0;
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 19) {
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  var3 = secretPacketBuffer2.readUnsignedByte();
                  var4 = secretPacketBuffer2.readUnsignedShort();
                  if(field1059 != 0 && var3 != 0 && field1080 < 50) {
                     field1147[field1080] = var2;
                     field965[field1080] = var3;
                     field1149[field1080] = var4;
                     audioEffects[field1080] = null;
                     field1014[field1080] = 0;
                     ++field1080;
                  }

                  packetType = -1;
                  return true;
               }

               Widget var114;
               if(packetType == 215) {
                  var2 = secretPacketBuffer2.readByteOb1();
                  var3 = secretPacketBuffer2.method3176();
                  var4 = secretPacketBuffer2.method3260();
                  var114 = class61.method1038(var4);
                  var114.field2709 = var2 + (var3 << 16);
                  packetType = -1;
                  return true;
               }

               if(packetType == 226) {
                  class7.method35();
                  var2 = secretPacketBuffer2.method3184();
                  var3 = secretPacketBuffer2.method3166();
                  var4 = secretPacketBuffer2.method3166();
                  skillExperiences[var4] = var2;
                  boostedSkillLevels[var4] = var3;
                  realSkillLevels[var4] = 1;

                  for(var5 = 0; var5 < 98; ++var5) {
                     if(var2 >= class222.field2839[var5]) {
                        realSkillLevels[var4] = var5 + 2;
                     }
                  }

                  field1096[++field1097 - 1 & 31] = var4;
                  packetType = -1;
                  return true;
               }

               if(packetType == 162) {
                  var2 = secretPacketBuffer2.method3260();
                  var3 = secretPacketBuffer2.method3324();
                  var4 = secretPacketBuffer2.method3178();
                  var114 = class61.method1038(var2);
                  if(var4 != var114.originalX || var3 != var114.originalY || var114.field2658 != 0 || var114.field2659 != 0) {
                     var114.originalX = var4;
                     var114.originalY = var3;
                     var114.field2658 = 0;
                     var114.field2659 = 0;
                     class48.method749(var114);
                     this.method1346(var114);
                     if(var114.type == 0) {
                        class36.method487(Widget.widgets[var2 >> 16], var114, false);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 57) {
                  var2 = secretPacketBuffer2.method3260();
                  var3 = secretPacketBuffer2.readInt();
                  var4 = secretPacketBuffer2.readByteOb1();
                  if(var4 == '\uffff') {
                     var4 = -1;
                  }

                  var114 = class61.method1038(var2);
                  ItemComposition var70;
                  if(!var114.hasScript) {
                     if(var4 == -1) {
                        var114.modelType = 0;
                        packetType = -1;
                        return true;
                     }

                     var70 = class83.getItemDefinition(var4);
                     var114.modelType = 4;
                     var114.modelId = var4;
                     var114.rotationX = var70.xan2d;
                     var114.rotationZ = var70.yan2d;
                     var114.modelZoom = var70.zoom2d * 100 / var3;
                     class48.method749(var114);
                  } else {
                     var114.itemId = var4;
                     var114.itemQuantity = var3;
                     var70 = class83.getItemDefinition(var4);
                     var114.rotationX = var70.xan2d;
                     var114.rotationZ = var70.yan2d;
                     var114.rotationY = var70.zan2d;
                     var114.field2702 = var70.offsetX2d;
                     var114.field2670 = var70.offsetY2d;
                     var114.modelZoom = var70.zoom2d;
                     if(var70.isStackable == 1) {
                        var114.field2711 = 1;
                     } else {
                        var114.field2711 = 2;
                     }

                     if(var114.field2648 > 0) {
                        var114.modelZoom = var114.modelZoom * 32 / var114.field2648;
                     } else if(var114.originalWidth > 0) {
                        var114.modelZoom = var114.modelZoom * 32 / var114.originalWidth;
                     }

                     class48.method749(var114);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 100) {
                  var2 = secretPacketBuffer2.readUnsignedByte();
                  var3 = secretPacketBuffer2.readUnsignedByte();
                  var4 = secretPacketBuffer2.readUnsignedByte();
                  var5 = secretPacketBuffer2.readUnsignedByte();
                  field1153[var2] = true;
                  field1154[var2] = var3;
                  field1155[var2] = var4;
                  field1156[var2] = var5;
                  field1157[var2] = 0;
                  packetType = -1;
                  return true;
               }

               if(packetType == 203) {
                  while(secretPacketBuffer2.offset < packetLength) {
                     var2 = secretPacketBuffer2.readUnsignedByte();
                     var74 = (var2 & 1) == 1;
                     var85 = secretPacketBuffer2.readString();
                     var113 = secretPacketBuffer2.readString();
                     secretPacketBuffer2.readString();

                     for(var22 = 0; var22 < ignoreCount; ++var22) {
                        Ignore var90 = ignores[var22];
                        if(var74) {
                           if(var113.equals(var90.name)) {
                              var90.name = var85;
                              var90.previousName = var113;
                              var85 = null;
                              break;
                           }
                        } else if(var85.equals(var90.name)) {
                           var90.name = var85;
                           var90.previousName = var113;
                           var85 = null;
                           break;
                        }
                     }

                     if(var85 != null && ignoreCount < 400) {
                        Ignore var69 = new Ignore();
                        ignores[ignoreCount] = var69;
                        var69.name = var85;
                        var69.previousName = var113;
                        ++ignoreCount;
                     }
                  }

                  field1099 = field1045;
                  packetType = -1;
                  return true;
               }

               int var8;
               boolean var64;
               if(packetType == 11) {
                  var25 = secretPacketBuffer2.readString();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  byte var68 = secretPacketBuffer2.readByte();
                  var64 = false;
                  if(var68 == -128) {
                     var64 = true;
                  }

                  if(var64) {
                     if(Signlink.clanChatCount == 0) {
                        packetType = -1;
                        return true;
                     }

                     boolean var97 = false;

                     for(var22 = 0; var22 < Signlink.clanChatCount && (!class44.clanMembers[var22].username.equals(var25) || var3 != class44.clanMembers[var22].world); ++var22) {
                        ;
                     }

                     if(var22 < Signlink.clanChatCount) {
                        while(var22 < Signlink.clanChatCount - 1) {
                           class44.clanMembers[var22] = class44.clanMembers[var22 + 1];
                           ++var22;
                        }

                        --Signlink.clanChatCount;
                        class44.clanMembers[Signlink.clanChatCount] = null;
                     }
                  } else {
                     secretPacketBuffer2.readString();
                     XClanMember var67 = new XClanMember();
                     var67.username = var25;
                     var67.field898 = class202.method3682(var67.username, class164.field2317);
                     var67.world = var3;
                     var67.rank = var68;

                     for(var7 = Signlink.clanChatCount - 1; var7 >= 0; --var7) {
                        var8 = class44.clanMembers[var7].field898.compareTo(var67.field898);
                        if(var8 == 0) {
                           class44.clanMembers[var7].world = var3;
                           class44.clanMembers[var7].rank = var68;
                           if(var25.equals(Script.localPlayer.name)) {
                              class27.clanChatRank = var68;
                           }

                           field1100 = field1045;
                           packetType = -1;
                           return true;
                        }

                        if(var8 < 0) {
                           break;
                        }
                     }

                     if(Signlink.clanChatCount >= class44.clanMembers.length) {
                        packetType = -1;
                        return true;
                     }

                     for(var8 = Signlink.clanChatCount - 1; var8 > var7; --var8) {
                        class44.clanMembers[var8 + 1] = class44.clanMembers[var8];
                     }

                     if(Signlink.clanChatCount == 0) {
                        class44.clanMembers = new XClanMember[100];
                     }

                     class44.clanMembers[var7 + 1] = var67;
                     ++Signlink.clanChatCount;
                     if(var25.equals(Script.localPlayer.name)) {
                        class27.clanChatRank = var68;
                     }
                  }

                  field1100 = field1045;
                  packetType = -1;
                  return true;
               }

               if(packetType == 70) {
                  class96.field1499 = 0;

                  for(var2 = 0; var2 < 2048; ++var2) {
                     class96.field1490[var2] = null;
                     class96.field1487[var2] = 1;
                  }

                  for(var2 = 0; var2 < 2048; ++var2) {
                     cachedPlayers[var2] = null;
                  }

                  class90.initializeGPI(secretPacketBuffer2);
                  packetType = -1;
                  return true;
               }

               long var38;
               if(packetType == 169) {
                  var2 = secretPacketBuffer2.method3263();
                  var3 = secretPacketBuffer2.readByteOb1();
                  if(var3 == '\uffff') {
                     var3 = -1;
                  }

                  var4 = secretPacketBuffer2.readUnsignedShortOb1();
                  if(var4 == '\uffff') {
                     var4 = -1;
                  }

                  var5 = secretPacketBuffer2.method3263();

                  for(var22 = var3; var22 <= var4; ++var22) {
                     var38 = (long)var22 + ((long)var2 << 32);
                     Node var117 = widgetFlags.get(var38);
                     if(var117 != null) {
                        var117.unlink();
                     }

                     widgetFlags.put(new WidgetConfig(var5), var38);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 81) {
                  var2 = secretPacketBuffer2.getUSmart();
                  var74 = secretPacketBuffer2.readUnsignedByte() == 1;
                  var85 = "";
                  var64 = false;
                  if(var74) {
                     var85 = secretPacketBuffer2.readString();
                     if(MilliTimer.isIgnored(var85)) {
                        var64 = true;
                     }
                  }

                  var66 = secretPacketBuffer2.readString();
                  if(!var64) {
                     WidgetNode.sendGameMessage(var2, var85, var66);
                  }

                  packetType = -1;
                  return true;
               }

               Widget var6;
               if(packetType == 71) {
                  var2 = secretPacketBuffer2.readByteOb1();
                  var3 = secretPacketBuffer2.readUnsignedShortOb1();
                  var4 = secretPacketBuffer2.readUnsignedShortOb1();
                  var5 = secretPacketBuffer2.method3260();
                  var6 = class61.method1038(var5);
                  if(var3 != var6.rotationX || var4 != var6.rotationZ || var2 != var6.modelZoom) {
                     var6.rotationX = var3;
                     var6.rotationZ = var4;
                     var6.modelZoom = var2;
                     class48.method749(var6);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 198) {
                  field1152 = true;
                  ScriptState.field771 = secretPacketBuffer2.readUnsignedByte();
                  XItemContainer.field782 = secretPacketBuffer2.readUnsignedByte();
                  PendingSpawn.field1203 = secretPacketBuffer2.readUnsignedShort();
                  DecorativeObject.field2171 = secretPacketBuffer2.readUnsignedByte();
                  class43.field559 = secretPacketBuffer2.readUnsignedByte();
                  if(class43.field559 >= 100) {
                     class41.cameraX = ScriptState.field771 * 128 + 64;
                     class7.cameraY = XItemContainer.field782 * 128 + 64;
                     XItemContainer.cameraZ = Actor.getTileHeight(class41.cameraX, class7.cameraY, class45.plane) - PendingSpawn.field1203;
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 190) {
                  field1152 = true;
                  class181.field2434 = secretPacketBuffer2.readUnsignedByte();
                  GraphicsObject.field1354 = secretPacketBuffer2.readUnsignedByte();
                  BaseVarType.field29 = secretPacketBuffer2.readUnsignedShort();
                  Timer.field2255 = secretPacketBuffer2.readUnsignedByte();
                  class37.field498 = secretPacketBuffer2.readUnsignedByte();
                  if(class37.field498 >= 100) {
                     var2 = class181.field2434 * 128 + 64;
                     var3 = GraphicsObject.field1354 * 128 + 64;
                     var4 = Actor.getTileHeight(var2, var3, class45.plane) - BaseVarType.field29;
                     var5 = var2 - class41.cameraX;
                     var22 = var4 - XItemContainer.cameraZ;
                     var7 = var3 - class7.cameraY;
                     var8 = (int)Math.sqrt((double)(var5 * var5 + var7 * var7));
                     class8.cameraPitch = (int)(Math.atan2((double)var22, (double)var8) * 325.949D) & 2047;
                     Friend.cameraYaw = (int)(Math.atan2((double)var5, (double)var7) * -325.949D) & 2047;
                     if(class8.cameraPitch < 128) {
                        class8.cameraPitch = 128;
                     }

                     if(class8.cameraPitch > 383) {
                        class8.cameraPitch = 383;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               long var27;
               long var29;
               long var31;
               if(packetType == 41) {
                  var25 = secretPacketBuffer2.readString();
                  var27 = (long)secretPacketBuffer2.readUnsignedShort();
                  var29 = (long)secretPacketBuffer2.read24BitInt();
                  Permission[] var88 = new Permission[]{Permission.field3176, Permission.field3175, Permission.field3174, Permission.field3180, Permission.field3177, Permission.field3179};
                  Permission var100 = (Permission)PendingSpawn.forOrdinal(var88, secretPacketBuffer2.readUnsignedByte());
                  var31 = (var27 << 32) + var29;
                  boolean var111 = false;

                  for(var75 = 0; var75 < 100; ++var75) {
                     if(var31 == field1125[var75]) {
                        var111 = true;
                        break;
                     }
                  }

                  if(MilliTimer.isIgnored(var25)) {
                     var111 = true;
                  }

                  if(!var111 && field1025 == 0) {
                     field1125[field1126] = var31;
                     field1126 = (field1126 + 1) % 100;
                     PacketBuffer var76 = secretPacketBuffer2;

                     String var14;
                     try {
                        var15 = var76.getUSmart();
                        if(var15 > 32767) {
                           var15 = 32767;
                        }

                        byte[] var79 = new byte[var15];
                        var76.offset += class265.field3657.decompress(var76.payload, var76.offset, var79, 0, var15);
                        String var17 = class7.getString(var79, 0, var15);
                        var14 = var17;
                     } catch (Exception var58) {
                        var14 = "Cabbage";
                     }

                     var14 = FontTypeFace.appendTags(XGrandExchangeOffer.method116(var14));
                     byte var78;
                     if(var100.field3181) {
                        var78 = 7;
                     } else {
                        var78 = 3;
                     }

                     if(var100.field3178 != -1) {
                        WidgetNode.sendGameMessage(var78, CombatInfo1.method1517(var100.field3178) + var25, var14);
                     } else {
                        WidgetNode.sendGameMessage(var78, var25, var14);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 239) {
                  field1120 = secretPacketBuffer2.readUnsignedByte();
                  if(field1120 == 1) {
                     field924 = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(field1120 >= 2 && field1120 <= 6) {
                     if(field1120 == 2) {
                        field929 = 64;
                        field930 = 64;
                     }

                     if(field1120 == 3) {
                        field929 = 0;
                        field930 = 64;
                     }

                     if(field1120 == 4) {
                        field929 = 128;
                        field930 = 64;
                     }

                     if(field1120 == 5) {
                        field929 = 64;
                        field930 = 0;
                     }

                     if(field1120 == 6) {
                        field929 = 64;
                        field930 = 128;
                     }

                     field1120 = 2;
                     hintArrowX = secretPacketBuffer2.readUnsignedShort();
                     hintArrowY = secretPacketBuffer2.readUnsignedShort();
                     hintArrowType = secretPacketBuffer2.readUnsignedByte();
                  }

                  if(field1120 == 10) {
                     field927 = secretPacketBuffer2.readUnsignedShort();
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 94) {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 < -70000) {
                     var3 += '耀';
                  }

                  if(var2 >= 0) {
                     var93 = class61.method1038(var2);
                  } else {
                     var93 = null;
                  }

                  if(var93 != null) {
                     for(var5 = 0; var5 < var93.itemIds.length; ++var5) {
                        var93.itemIds[var5] = 0;
                        var93.itemQuantities[var5] = 0;
                     }
                  }

                  class9.resetItemTable(var3);
                  var5 = secretPacketBuffer2.readUnsignedShort();

                  for(var22 = 0; var22 < var5; ++var22) {
                     var7 = secretPacketBuffer2.readByteOb1();
                     var8 = secretPacketBuffer2.readUnsignedByte();
                     if(var8 == 255) {
                        var8 = secretPacketBuffer2.method3184();
                     }

                     if(var93 != null && var22 < var93.itemIds.length) {
                        var93.itemIds[var22] = var7;
                        var93.itemQuantities[var22] = var8;
                     }

                     class27.setItemTableSlot(var3, var22, var7 - 1, var8);
                  }

                  if(var93 != null) {
                     class48.method749(var93);
                  }

                  class7.method35();
                  interfaceItemTriggers[++field1095 - 1 & 31] = var3 & 32767;
                  packetType = -1;
                  return true;
               }

               if(packetType == 0) {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 < -70000) {
                     var3 += '耀';
                  }

                  if(var2 >= 0) {
                     var93 = class61.method1038(var2);
                  } else {
                     var93 = null;
                  }

                  for(; secretPacketBuffer2.offset < packetLength; class27.setItemTableSlot(var3, var5, var22 - 1, var7)) {
                     var5 = secretPacketBuffer2.getUSmart();
                     var22 = secretPacketBuffer2.readUnsignedShort();
                     var7 = 0;
                     if(var22 != 0) {
                        var7 = secretPacketBuffer2.readUnsignedByte();
                        if(var7 == 255) {
                           var7 = secretPacketBuffer2.readInt();
                        }
                     }

                     if(var93 != null && var5 >= 0 && var5 < var93.itemIds.length) {
                        var93.itemIds[var5] = var22;
                        var93.itemQuantities[var5] = var7;
                     }
                  }

                  if(var93 != null) {
                     class48.method749(var93);
                  }

                  class7.method35();
                  interfaceItemTriggers[++field1095 - 1 & 31] = var3 & 32767;
                  packetType = -1;
                  return true;
               }

               long var40;
               if(packetType == 59) {
                  var25 = secretPacketBuffer2.readString();
                  var27 = secretPacketBuffer2.readLong();
                  var29 = (long)secretPacketBuffer2.readUnsignedShort();
                  var38 = (long)secretPacketBuffer2.read24BitInt();
                  Permission[] var51 = new Permission[]{Permission.field3176, Permission.field3175, Permission.field3174, Permission.field3180, Permission.field3177, Permission.field3179};
                  Permission var106 = (Permission)PendingSpawn.forOrdinal(var51, secretPacketBuffer2.readUnsignedByte());
                  var40 = (var29 << 32) + var38;
                  boolean var46 = false;

                  for(var47 = 0; var47 < 100; ++var47) {
                     if(field1125[var47] == var40) {
                        var46 = true;
                        break;
                     }
                  }

                  if(var106.field3182 && MilliTimer.isIgnored(var25)) {
                     var46 = true;
                  }

                  if(!var46 && field1025 == 0) {
                     field1125[field1126] = var40;
                     field1126 = (field1126 + 1) % 100;
                     PacketBuffer var52 = secretPacketBuffer2;

                     String var16;
                     try {
                        int var53 = var52.getUSmart();
                        if(var53 > 32767) {
                           var53 = 32767;
                        }

                        byte[] var18 = new byte[var53];
                        var52.offset += class265.field3657.decompress(var52.payload, var52.offset, var18, 0, var53);
                        String var19 = class7.getString(var18, 0, var53);
                        var16 = var19;
                     } catch (Exception var55) {
                        var16 = "Cabbage";
                     }

                     var16 = FontTypeFace.appendTags(XGrandExchangeOffer.method116(var16));
                     if(var106.field3178 != -1) {
                        class18.addChatMessage(9, CombatInfo1.method1517(var106.field3178) + var25, var16, PendingSpawn.method1478(var27));
                     } else {
                        class18.addChatMessage(9, var25, var16, PendingSpawn.method1478(var27));
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 126) {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readInt();
                  if(Player.field894 == null || !Player.field894.isValid()) {
                     try {
                        Iterator var91 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                        while(var91.hasNext()) {
                           GarbageCollectorMXBean var112 = (GarbageCollectorMXBean)var91.next();
                           if(var112.isValid()) {
                              Player.field894 = var112;
                              field1053 = -1L;
                              field1182 = -1L;
                           }
                        }
                     } catch (Throwable var60) {
                        ;
                     }
                  }

                  long var36 = class46.currentTimeMs();
                  var22 = -1;
                  if(Player.field894 != null) {
                     var38 = Player.field894.getCollectionTime();
                     if(-1L != field1182) {
                        var31 = var38 - field1182;
                        var40 = var36 - field1053;
                        if(var40 != 0L) {
                           var22 = (int)(var31 * 100L / var40);
                        }
                     }

                     field1182 = var38;
                     field1053 = var36;
                  }

                  secretPacketBuffer1.putOpcode(234);
                  secretPacketBuffer1.method3164(GameEngine.FPS);
                  secretPacketBuffer1.method3127(var22);
                  secretPacketBuffer1.method3291(var2);
                  secretPacketBuffer1.method3181(var3);
                  packetType = -1;
                  return true;
               }

               int var9;
               boolean var73;
               if(packetType == 209) {
                  field1100 = field1045;
                  if(packetLength == 0) {
                     clanChatOwner = null;
                     clanChatName = null;
                     Signlink.clanChatCount = 0;
                     class44.clanMembers = null;
                     packetType = -1;
                     return true;
                  }

                  clanChatName = secretPacketBuffer2.readString();
                  long var42 = secretPacketBuffer2.readLong();
                  var29 = var42;
                  if(var42 > 0L && var42 < 6582952005840035281L) {
                     if(var42 % 37L == 0L) {
                        var85 = null;
                     } else {
                        var7 = 0;

                        for(var44 = var42; var44 != 0L; var44 /= 37L) {
                           ++var7;
                        }

                        StringBuilder var101 = new StringBuilder(var7);

                        while(0L != var29) {
                           var40 = var29;
                           var29 /= 37L;
                           var101.append(class268.field3672[(int)(var40 - 37L * var29)]);
                        }

                        var85 = var101.reverse().toString();
                     }
                  } else {
                     var85 = null;
                  }

                  clanChatOwner = var85;
                  FaceNormal.field2133 = secretPacketBuffer2.readByte();
                  var7 = secretPacketBuffer2.readUnsignedByte();
                  if(var7 == 255) {
                     packetType = -1;
                     return true;
                  }

                  Signlink.clanChatCount = var7;
                  XClanMember[] var98 = new XClanMember[100];

                  for(var9 = 0; var9 < Signlink.clanChatCount; ++var9) {
                     var98[var9] = new XClanMember();
                     var98[var9].username = secretPacketBuffer2.readString();
                     var98[var9].field898 = class202.method3682(var98[var9].username, class164.field2317);
                     var98[var9].world = secretPacketBuffer2.readUnsignedShort();
                     var98[var9].rank = secretPacketBuffer2.readByte();
                     secretPacketBuffer2.readString();
                     if(var98[var9].username.equals(Script.localPlayer.name)) {
                        class27.clanChatRank = var98[var9].rank;
                     }
                  }

                  var73 = false;
                  var33 = Signlink.clanChatCount;

                  while(var33 > 0) {
                     var73 = true;
                     --var33;

                     for(var75 = 0; var75 < var33; ++var75) {
                        if(var98[var75].field898.compareTo(var98[var75 + 1].field898) > 0) {
                           XClanMember var104 = var98[var75];
                           var98[var75] = var98[var75 + 1];
                           var98[var75 + 1] = var104;
                           var73 = false;
                        }
                     }

                     if(var73) {
                        break;
                     }
                  }

                  class44.clanMembers = var98;
                  packetType = -1;
                  return true;
               }

               if(packetType == 153) {
                  while(secretPacketBuffer2.offset < packetLength) {
                     var63 = secretPacketBuffer2.readUnsignedByte() == 1;
                     var81 = secretPacketBuffer2.readString();
                     var85 = secretPacketBuffer2.readString();
                     var5 = secretPacketBuffer2.readUnsignedShort();
                     var22 = secretPacketBuffer2.readUnsignedByte();
                     var7 = secretPacketBuffer2.readUnsignedByte();
                     boolean var71 = (var7 & 2) != 0;
                     var73 = (var7 & 1) != 0;
                     if(var5 > 0) {
                        secretPacketBuffer2.readString();
                        secretPacketBuffer2.readUnsignedByte();
                        secretPacketBuffer2.readInt();
                     }

                     secretPacketBuffer2.readString();

                     for(var10 = 0; var10 < friendCount; ++var10) {
                        Friend var11 = friends[var10];
                        if(!var63) {
                           if(var81.equals(var11.name)) {
                              if(var5 != var11.world) {
                                 boolean var12 = true;

                                 for(class67 var13 = (class67)field1179.method3636(); var13 != null; var13 = (class67)field1179.method3629()) {
                                    if(var13.field817.equals(var81)) {
                                       if(var5 != 0 && var13.field818 == 0) {
                                          var13.method3639();
                                          var12 = false;
                                       } else if(var5 == 0 && var13.field818 != 0) {
                                          var13.method3639();
                                          var12 = false;
                                       }
                                    }
                                 }

                                 if(var12) {
                                    field1179.method3627(new class67(var81, var5));
                                 }

                                 var11.world = var5;
                              }

                              var11.previousName = var85;
                              var11.rank = var22;
                              var11.field805 = var71;
                              var11.field801 = var73;
                              var81 = null;
                              break;
                           }
                        } else if(var85.equals(var11.name)) {
                           var11.name = var81;
                           var11.previousName = var85;
                           var81 = null;
                           break;
                        }
                     }

                     if(var81 != null && friendCount < 400) {
                        Friend var26 = new Friend();
                        friends[friendCount] = var26;
                        var26.name = var81;
                        var26.previousName = var85;
                        var26.world = var5;
                        var26.rank = var22;
                        var26.field805 = var71;
                        var26.field801 = var73;
                        ++friendCount;
                     }
                  }

                  field1056 = 2;
                  field1099 = field1045;
                  var63 = false;
                  var3 = friendCount;

                  while(var3 > 0) {
                     var63 = true;
                     --var3;

                     for(var4 = 0; var4 < var3; ++var4) {
                        var64 = false;
                        Friend var65 = friends[var4];
                        Friend var23 = friends[var4 + 1];
                        if(var65.world != world && var23.world == world) {
                           var64 = true;
                        }

                        if(!var64 && var65.world == 0 && var23.world != 0) {
                           var64 = true;
                        }

                        if(!var64 && !var65.field805 && var23.field805) {
                           var64 = true;
                        }

                        if(!var64 && !var65.field801 && var23.field801) {
                           var64 = true;
                        }

                        if(var64) {
                           Friend var96 = friends[var4];
                           friends[var4] = friends[var4 + 1];
                           friends[var4 + 1] = var96;
                           var63 = false;
                        }
                     }

                     if(var63) {
                        break;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 137) {
                  class163.decodeClassVerifier(secretPacketBuffer2, packetLength);
                  packetType = -1;
                  return true;
               }

               if(packetType == 165) {
                  class207.method3867();
                  packetType = -1;
                  return false;
               }

               if(packetType == 232) {
                  secretPacketBuffer2.offset += 28;
                  if(secretPacketBuffer2.checkCrc()) {
                     PacketBuffer var102 = secretPacketBuffer2;
                     var3 = secretPacketBuffer2.offset - 28;
                     byte[] var83 = var102.payload;
                     if(field942 == null) {
                        field942 = new byte[24];
                     }

                     class183.method3429(var83, var3, field942, 0, 24);
                     if(class155.field2239 != null) {
                        try {
                           class155.field2239.seek(0L);
                           class155.field2239.write(var102.payload, var3, 24);
                        } catch (Exception var59) {
                           ;
                        }
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 17) {
                  World var99 = new World();
                  var99.address = secretPacketBuffer2.readString();
                  var99.id = secretPacketBuffer2.readUnsignedShort();
                  var3 = secretPacketBuffer2.readInt();
                  var99.mask = var3;
                  WorldMapType2.setGameState(45);
                  Occluder.rssocket.close();
                  Occluder.rssocket = null;
                  class31.method276(var99);
                  packetType = -1;
                  return false;
               }

               if(packetType == 84) {
                  class51.method784(false);
                  packetType = -1;
                  return true;
               }

               if(packetType == 151) {
                  class51.method784(true);
                  packetType = -1;
                  return true;
               }

               if(packetType != 121) {
                  if(packetType == 167) {
                     class251.field3390 = secretPacketBuffer2.method3165();
                     WorldMapType2.field514 = secretPacketBuffer2.method3166();

                     while(secretPacketBuffer2.offset < packetLength) {
                        packetType = secretPacketBuffer2.readUnsignedByte();
                        class236.method4172();
                     }

                     packetType = -1;
                     return true;
                  }

                  if(packetType == 16) {
                     GroundObject.method2477(secretPacketBuffer2, packetLength);
                     packetType = -1;
                     return true;
                  }

                  if(packetType == 60) {
                     class5.xteaChanged(false);
                     secretPacketBuffer2.readOpcode();
                     var2 = secretPacketBuffer2.readUnsignedShort();
                     GroundObject.method2477(secretPacketBuffer2, var2);
                     packetType = -1;
                     return true;
                  }

                  if(packetType == 44) {
                     class5.xteaChanged(true);
                     secretPacketBuffer2.readOpcode();
                     var2 = secretPacketBuffer2.readUnsignedShort();
                     GroundObject.method2477(secretPacketBuffer2, var2);
                     packetType = -1;
                     return true;
                  }

                  if(packetType == 55) {
                     if(widgetRoot != -1) {
                        class31.method275(widgetRoot, 0);
                     }

                     packetType = -1;
                     return true;
                  }

                  if(packetType == 6) {
                     var2 = secretPacketBuffer2.readInt();
                     WidgetNode var80 = (WidgetNode)componentTable.get((long)var2);
                     if(var80 != null) {
                        MilliTimer.method2909(var80, true);
                     }

                     if(field1070 != null) {
                        class48.method749(field1070);
                        field1070 = null;
                     }

                     packetType = -1;
                     return true;
                  }

                  if(packetType == 129) {
                     var2 = secretPacketBuffer2.readUnsignedShortOb1();
                     widgetRoot = var2;
                     this.method1160(false);
                     class22.method168(var2);
                     class229.method4069(widgetRoot);

                     for(var3 = 0; var3 < 100; ++var3) {
                        field1111[var3] = true;
                     }

                     packetType = -1;
                     return true;
                  }

                  WidgetNode var35;
                  if(packetType == 78) {
                     var2 = secretPacketBuffer2.method3184();
                     var3 = secretPacketBuffer2.method3184();
                     WidgetNode var82 = (WidgetNode)componentTable.get((long)var2);
                     var35 = (WidgetNode)componentTable.get((long)var3);
                     if(var35 != null) {
                        MilliTimer.method2909(var35, var82 == null || var35.id != var82.id);
                     }

                     if(var82 != null) {
                        var82.unlink();
                        componentTable.put(var82, (long)var3);
                     }

                     var6 = class61.method1038(var2);
                     if(var6 != null) {
                        class48.method749(var6);
                     }

                     var6 = class61.method1038(var3);
                     if(var6 != null) {
                        class48.method749(var6);
                        class36.method487(Widget.widgets[var6.id >>> 16], var6, true);
                     }

                     if(widgetRoot != -1) {
                        class31.method275(widgetRoot, 1);
                     }

                     packetType = -1;
                     return true;
                  }

                  if(packetType == 111) {
                     var2 = secretPacketBuffer2.method3166();
                     var3 = secretPacketBuffer2.method3260();
                     var4 = secretPacketBuffer2.readUnsignedShortOb1();
                     var35 = (WidgetNode)componentTable.get((long)var3);
                     if(var35 != null) {
                        MilliTimer.method2909(var35, var4 != var35.id);
                     }

                     GameObject.method2891(var3, var4, var2);
                     packetType = -1;
                     return true;
                  }

                  if(packetType == 42) {
                     var25 = secretPacketBuffer2.readString();
                     Object[] var20 = new Object[var25.length() + 1];

                     for(var4 = var25.length() - 1; var4 >= 0; --var4) {
                        if(var25.charAt(var4) == 115) {
                           var20[var4 + 1] = secretPacketBuffer2.readString();
                        } else {
                           var20[var4 + 1] = new Integer(secretPacketBuffer2.readInt());
                        }
                     }

                     var20[0] = new Integer(secretPacketBuffer2.readInt());
                     ScriptEvent var21 = new ScriptEvent();
                     var21.field839 = var20;
                     class89.method1689(var21);
                     packetType = -1;
                     return true;
                  }

                  if(packetType == 128) {
                     var2 = packetLength + secretPacketBuffer2.offset;
                     var3 = secretPacketBuffer2.readUnsignedShort();
                     var4 = secretPacketBuffer2.readUnsignedShort();
                     if(var3 != widgetRoot) {
                        widgetRoot = var3;
                        this.method1160(false);
                        class22.method168(widgetRoot);
                        class229.method4069(widgetRoot);

                        for(var5 = 0; var5 < 100; ++var5) {
                           field1111[var5] = true;
                        }
                     }

                     WidgetNode var24;
                     for(; var4-- > 0; var24.field824 = true) {
                        var5 = secretPacketBuffer2.readInt();
                        var22 = secretPacketBuffer2.readUnsignedShort();
                        var7 = secretPacketBuffer2.readUnsignedByte();
                        var24 = (WidgetNode)componentTable.get((long)var5);
                        if(var24 != null && var22 != var24.id) {
                           MilliTimer.method2909(var24, true);
                           var24 = null;
                        }

                        if(var24 == null) {
                           var24 = GameObject.method2891(var5, var22, var7);
                        }
                     }

                     for(var35 = (WidgetNode)componentTable.method3538(); var35 != null; var35 = (WidgetNode)componentTable.method3539()) {
                        if(var35.field824) {
                           var35.field824 = false;
                        } else {
                           MilliTimer.method2909(var35, true);
                        }
                     }

                     widgetFlags = new XHashTable(512);

                     while(secretPacketBuffer2.offset < var2) {
                        var5 = secretPacketBuffer2.readInt();
                        var22 = secretPacketBuffer2.readUnsignedShort();
                        var7 = secretPacketBuffer2.readUnsignedShort();
                        var8 = secretPacketBuffer2.readInt();

                        for(var9 = var22; var9 <= var7; ++var9) {
                           long var49 = (long)var9 + ((long)var5 << 32);
                           widgetFlags.put(new WidgetConfig(var8), var49);
                        }
                     }

                     packetType = -1;
                     return true;
                  }

                  class54.method800("" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength, (Throwable)null);
                  class207.method3867();
                  return true;
               }
            }

            class236.method4172();
            packetType = -1;
            return true;
         } catch (IOException var61) {
            if(field958 > 0) {
               class207.method3867();
            } else {
               WorldMapType2.setGameState(40);
               class261.field3623 = Occluder.rssocket;
               Occluder.rssocket = null;
            }
         } catch (Exception var62) {
            var25 = "" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength + "," + (Script.localPlayer.pathX[0] + class163.baseX) + "," + (Script.localPlayer.pathY[0] + class10.baseY) + ",";

            for(var3 = 0; var3 < packetLength && var3 < 50; ++var3) {
               var25 = var25 + secretPacketBuffer2.payload[var3] + ",";
            }

            class54.method800(var25, var62);
            class207.method3867();
         }

         return true;
      }
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-45"
   )
   void method1150() {
      if(class238.field3258 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class238.field3252 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field935 = 3000;
            class238.field3252 = 3;
         }

         if(--field935 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  BaseVarType.socket = GameEngine.taskManager.createSocket(class18.host, class9.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(BaseVarType.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(BaseVarType.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  class96.rssocket = new RSSocket((Socket)BaseVarType.socket.value, GameEngine.taskManager);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(149);
                  class96.rssocket.queueForWrite(var1.payload, 0, 5);
                  ++js5State;
                  class48.field608 = class46.currentTimeMs();
               }

               if(js5State == 3) {
                  if(gameState > 5 && class96.rssocket.available() <= 0) {
                     if(class46.currentTimeMs() - class48.field608 > 30000L) {
                        this.error(-2);
                        return;
                     }
                  } else {
                     int var5 = class96.rssocket.readByte();
                     if(var5 != 0) {
                        this.error(var5);
                        return;
                     }

                     ++js5State;
                  }
               }

               if(js5State == 4) {
                  RSSocket var10 = class96.rssocket;
                  boolean var2 = gameState > 20;
                  if(class238.field3264 != null) {
                     try {
                        class238.field3264.close();
                     } catch (Exception var8) {
                        ;
                     }

                     class238.field3264 = null;
                  }

                  class238.field3264 = var10;
                  Actor.sendConInfo(var2);
                  class238.field3266.offset = 0;
                  class268.currentRequest = null;
                  class1.field0 = null;
                  class238.field3265 = 0;

                  while(true) {
                     FileRequest var3 = (FileRequest)class238.field3269.method3538();
                     if(var3 == null) {
                        while(true) {
                           var3 = (FileRequest)class238.field3262.method3538();
                           if(var3 == null) {
                              if(class238.field3268 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.putByte(4);
                                    var11.putByte(class238.field3268);
                                    var11.putShort(0);
                                    class238.field3264.queueForWrite(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class238.field3264.close();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class238.field3252;
                                    class238.field3264 = null;
                                 }
                              }

                              class238.field3253 = 0;
                              class238.field3254 = class46.currentTimeMs();
                              BaseVarType.socket = null;
                              class96.rssocket = null;
                              js5State = 0;
                              field937 = 0;
                              return;
                           }

                           class238.field3259.setHead(var3);
                           class238.field3260.put(var3, var3.hash);
                           ++class238.field3256;
                           --class238.field3263;
                        }
                     }

                     class238.field3255.put(var3, var3.hash);
                     ++class238.field3272;
                     --class238.field3257;
                  }
               }
            } catch (IOException var9) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "224940088"
   )
   final void method1159(int var1, int var2) {
      int var3 = class21.field338.method4721("Choose Option");

      int var4;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         Font var5 = class21.field338;
         String var6;
         if(var4 < 0) {
            var6 = "";
         } else if(menuTargets[var4].length() > 0) {
            var6 = menuOptions[var4] + " " + menuTargets[var4];
         } else {
            var6 = menuOptions[var4];
         }

         int var7 = var5.method4721(var6);
         if(var7 > var3) {
            var3 = var7;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      int var8 = var1 - var3 / 2;
      if(var8 + var3 > class77.canvasWidth) {
         var8 = class77.canvasWidth - var3;
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

      class29.region.method2703(class45.plane, var1, var2, false);
      isMenuOpen = true;
      class61.menuX = var8;
      class10.menuY = var9;
      class10.menuWidth = var3;
      class23.menuHeight = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "76646516"
   )
   final void method1156() {
      int var1;
      if(widgetRoot != -1) {
         var1 = widgetRoot;
         if(class33.loadWidget(var1)) {
            class272.method4829(Widget.widgets[var1], -1);
         }
      }

      for(var1 = 0; var1 < field1006; ++var1) {
         if(field1111[var1]) {
            field1112[var1] = true;
         }

         field938[var1] = field1111[var1];
         field1111[var1] = false;
      }

      field1110 = gameCycle;
      field1055 = -1;
      field915 = -1;
      class66.field813 = null;
      if(widgetRoot != -1) {
         field1006 = 0;
         VertexNormal.drawWidget(widgetRoot, 0, 0, class77.canvasWidth, FloorUnderlayDefinition.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      int var2;
      int var3;
      if(!isMenuOpen) {
         if(field1055 != -1) {
            var1 = field1055;
            var2 = field915;
            if(menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) {
               var3 = class134.method2587();
               String var4;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var4 = "Use" + " " + selectedItemName + " " + "->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var4 = field1064 + " " + field1019 + " " + "->";
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
                  var4 = var4 + class46.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               class21.field338.drawRandomizedMouseoverText(var4, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         Player.method1136();
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < field1006; ++var1) {
            if(field938[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1112[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = class45.plane;
      var2 = Script.localPlayer.x;
      var3 = Script.localPlayer.y;
      int var12 = field982;

      for(class82 var14 = (class82)class82.field1322.getFront(); var14 != null; var14 = (class82)class82.field1322.getNext()) {
         if(var14.field1318 != -1 || var14.field1325 != null) {
            int var6 = 0;
            if(var2 > var14.field1315) {
               var6 += var2 - var14.field1315;
            } else if(var2 < var14.field1313) {
               var6 += var14.field1313 - var2;
            }

            if(var3 > var14.field1319) {
               var6 += var3 - var14.field1319;
            } else if(var3 < var14.field1314) {
               var6 += var14.field1314 - var3;
            }

            if(var6 - 64 <= var14.field1316 && field1172 != 0 && var1 == var14.field1312) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               int var7 = (var14.field1316 - var6) * field1172 / var14.field1316;
               Object var10000;
               if(var14.field1324 == null) {
                  if(var14.field1318 >= 0) {
                     var10000 = null;
                     SoundEffect var8 = SoundEffect.getTrack(WorldMapType2.field502, var14.field1318, 0);
                     if(var8 != null) {
                        class107 var9 = var8.method1906().method1955(Overlay.field3593);
                        class117 var10 = class117.method2195(var9, 100, var7);
                        var10.method2212(-1);
                        class203.field2511.method1880(var10);
                        var14.field1324 = var10;
                     }
                  }
               } else {
                  var14.field1324.method2117(var7);
               }

               if(var14.field1321 == null) {
                  if(var14.field1325 != null && (var14.field1323 -= var12) <= 0) {
                     int var13 = (int)(Math.random() * (double)var14.field1325.length);
                     var10000 = null;
                     SoundEffect var15 = SoundEffect.getTrack(WorldMapType2.field502, var14.field1325[var13], 0);
                     if(var15 != null) {
                        class107 var16 = var15.method1906().method1955(Overlay.field3593);
                        class117 var11 = class117.method2195(var16, 100, var7);
                        var11.method2212(0);
                        class203.field2511.method1880(var11);
                        var14.field1321 = var11;
                        var14.field1323 = var14.field1320 + (int)(Math.random() * (double)(var14.field1317 - var14.field1320));
                     }
                  }
               } else {
                  var14.field1321.method2117(var7);
                  if(!var14.field1321.linked()) {
                     var14.field1321 = null;
                  }
               }
            } else {
               if(var14.field1324 != null) {
                  class203.field2511.method1867(var14.field1324);
                  var14.field1324 = null;
               }

               if(var14.field1321 != null) {
                  class203.field2511.method1867(var14.field1321);
                  var14.field1321 = null;
               }
            }
         }
      }

      field982 = 0;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-24450237"
   )
   @Hook("clientMainLoop")
   protected final void vmethod1415(boolean var1) {
      boolean var2;
      label168: {
         try {
            if(class203.field2501 == 2) {
               if(class149.field2196 == null) {
                  class149.field2196 = Track1.getMusicFile(class203.field2502, class203.field2503, MilliTimer.field2204);
                  if(class149.field2196 == null) {
                     var2 = false;
                     break label168;
                  }
               }

               if(class203.field2506 == null) {
                  class203.field2506 = new class112(class203.field2499, class270.field3683);
               }

               if(class203.field2500.method3699(class149.field2196, class203.field2498, class203.field2506, 22050)) {
                  class203.field2500.method3786();
                  class203.field2500.method3697(class203.field2504);
                  class203.field2500.method3702(class149.field2196, class203.field2505);
                  class203.field2501 = 0;
                  class149.field2196 = null;
                  class203.field2506 = null;
                  class203.field2502 = null;
                  var2 = true;
                  break label168;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class203.field2500.method3703();
            class203.field2501 = 0;
            class149.field2196 = null;
            class203.field2506 = null;
            class203.field2502 = null;
         }

         var2 = false;
      }

      if(var2 && field946 && class290.soundSystem0 != null) {
         class290.soundSystem0.method1987();
      }

      if((gameState == 10 || gameState == 20 || gameState == 30) && field951 != 0L && class46.currentTimeMs() > field951) {
         class1.method1(Player.method1119());
      }

      int var4;
      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1111[var4] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class92.loadingBarPercentage, class92.loadingText, var1);
      } else if(gameState == 5) {
         XClanMember.drawLoginScreen(class21.field338, class223.field2847, class5.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            XClanMember.drawLoginScreen(class21.field338, class223.field2847, class5.font_p12full, var1);
         } else if(gameState == 25) {
            if(field971 == 1) {
               if(field961 > field962) {
                  field962 = field961;
               }

               var4 = (field962 * 50 - field961 * 50) / field962;
               class89.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field971 == 2) {
               if(field963 > field964) {
                  field964 = field963;
               }

               var4 = (field964 * 50 - field963 * 50) / field964 + 50;
               class89.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class89.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1156();
         } else if(gameState == 40) {
            class89.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class89.drawStatusBox("Please wait...", false);
         }
      } else {
         XClanMember.drawLoginScreen(class21.field338, class223.field2847, class5.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var4 = 0; var4 < field1006; ++var4) {
            if(field1112[var4]) {
               GZipDecompressor.field2327.vmethod4935(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field1112[var4] = false;
            }
         }
      } else if(gameState > 0) {
         GZipDecompressor.field2327.vmethod4942(0, 0);

         for(var4 = 0; var4 < field1006; ++var4) {
            field1112[var4] = false;
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1818172068"
   )
   protected final void vmethod1273() {
      field951 = class46.currentTimeMs() + 500L;
      this.method1155();
      if(widgetRoot != -1) {
         this.method1160(true);
      }

   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "669026842"
   )
   final void method1152() {
      try {
         if(loginState == 0) {
            if(Occluder.rssocket != null) {
               Occluder.rssocket.close();
               Occluder.rssocket = null;
            }

            class10.field262 = null;
            socketError = false;
            field939 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(class10.field262 == null) {
               class10.field262 = GameEngine.taskManager.createSocket(class18.host, class9.myWorldPort);
            }

            if(class10.field262.status == 2) {
               throw new IOException();
            }

            if(class10.field262.status == 1) {
               Occluder.rssocket = new RSSocket((Socket)class10.field262.value, GameEngine.taskManager);
               class10.field262 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(14);
            Occluder.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, 1);
            secretPacketBuffer2.offset = 0;
            loginState = 3;
         }

         int var1;
         if(loginState == 3) {
            if(class290.soundSystem0 != null) {
               class290.soundSystem0.method2030();
            }

            if(KeyFocusListener.soundSystem1 != null) {
               KeyFocusListener.soundSystem1.method2030();
            }

            var1 = Occluder.rssocket.readByte();
            if(class290.soundSystem0 != null) {
               class290.soundSystem0.method2030();
            }

            if(KeyFocusListener.soundSystem1 != null) {
               KeyFocusListener.soundSystem1.method2030();
            }

            if(var1 != 0) {
               class23.method169(var1);
               return;
            }

            secretPacketBuffer2.offset = 0;
            loginState = 4;
         }

         if(loginState == 4) {
            if(secretPacketBuffer2.offset < 8) {
               var1 = Occluder.rssocket.available();
               if(var1 > 8 - secretPacketBuffer2.offset) {
                  var1 = 8 - secretPacketBuffer2.offset;
               }

               if(var1 > 0) {
                  Occluder.rssocket.read(secretPacketBuffer2.payload, secretPacketBuffer2.offset, var1);
                  secretPacketBuffer2.offset += var1;
               }
            }

            if(secretPacketBuffer2.offset == 8) {
               secretPacketBuffer2.offset = 0;
               class18.field320 = secretPacketBuffer2.readLong();
               loginState = 5;
            }
         }

         int var2;
         int var3;
         if(loginState == 5) {
            int[] var6 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class18.field320 >> 32), (int)(class18.field320 & -1L)};
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(1);
            secretPacketBuffer1.putByte(class92.field1430.rsOrdinal());
            secretPacketBuffer1.putInt(var6[0]);
            secretPacketBuffer1.putInt(var6[1]);
            secretPacketBuffer1.putInt(var6[2]);
            secretPacketBuffer1.putInt(var6[3]);
            switch(class92.field1430.field2193) {
            case 0:
               secretPacketBuffer1.putInt(((Integer)class23.preferences.preferences.get(Integer.valueOf(class232.method4077(class92.username)))).intValue());
               secretPacketBuffer1.offset += 4;
               break;
            case 1:
            case 2:
               secretPacketBuffer1.put24bitInt(class3.authCodeForLogin);
               secretPacketBuffer1.offset += 5;
               break;
            case 3:
               secretPacketBuffer1.offset += 8;
            }

            secretPacketBuffer1.putString(class92.password);
            secretPacketBuffer1.encryptRsa(class90.rsaKeyExponent, class90.rsaKeyModulus);
            field949.offset = 0;
            if(gameState == 40) {
               field949.putByte(18);
            } else {
               field949.putByte(16);
            }

            field949.putShort(0);
            var2 = field949.offset;
            field949.putInt(149);
            field949.putBytes(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
            var3 = field949.offset;
            field949.putString(class92.username);
            field949.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            field949.putShort(class77.canvasWidth);
            field949.putShort(FloorUnderlayDefinition.canvasHeight);
            Renderable.method2863(field949);
            field949.putString(class8.sessionToken);
            field949.putInt(class25.field371);
            Buffer var4 = new Buffer(class202.field2496.method5283());
            class202.field2496.method5282(var4);
            field949.putBytes(var4.payload, 0, var4.payload.length);
            field949.putByte(class31.field437);
            field949.putInt(0);
            field949.putInt(class31.indexInterfaces.crc);
            field949.putInt(indexSoundEffects.crc);
            field949.putInt(Tile.configsIndex.crc);
            field949.putInt(BuildType.field3190.crc);
            field949.putInt(WorldMapType2.field502.crc);
            field949.putInt(class12.indexMaps.crc);
            field949.putInt(class182.indexTrack1.crc);
            field949.putInt(Renderable.indexModels.crc);
            field949.putInt(class17.indexSprites.crc);
            field949.putInt(indexTextures.crc);
            field949.putInt(class54.field660.crc);
            field949.putInt(class10.indexTrack2.crc);
            field949.putInt(class265.indexScripts.crc);
            field949.putInt(Player.field881.crc);
            field949.putInt(class71.vorbisIndex.crc);
            field949.putInt(class56.field675.crc);
            field949.putInt(class3.indexWorldMap.crc);
            field949.encryptXtea(var6, var3, field949.offset);
            field949.putShortLength(field949.offset - var2);
            Occluder.rssocket.queueForWrite(field949.payload, 0, field949.offset);
            secretPacketBuffer1.seed(var6);

            for(int var5 = 0; var5 < 4; ++var5) {
               var6[var5] += 50;
            }

            secretPacketBuffer2.seed(var6);
            loginState = 6;
         }

         if(loginState == 6 && Occluder.rssocket.available() > 0) {
            var1 = Occluder.rssocket.readByte();
            if(var1 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var1 == 2) {
               loginState = 9;
            } else if(var1 == 15 && gameState == 40) {
               packetLength = -1;
               loginState = 13;
            } else if(var1 == 23 && field941 < 1) {
               ++field941;
               loginState = 0;
            } else {
               if(var1 != 29) {
                  class23.method169(var1);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && Occluder.rssocket.available() > 0) {
            field954 = (Occluder.rssocket.readByte() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field939 = 0;
            class2.method6("You have only just left another world.", "Your profile will be transferred in:", field954 / 60 + " seconds.");
            if(--field954 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && Occluder.rssocket.available() >= 13) {
               boolean var12 = Occluder.rssocket.readByte() == 1;
               Occluder.rssocket.read(secretPacketBuffer2.payload, 0, 4);
               secretPacketBuffer2.offset = 0;
               boolean var11 = false;
               if(var12) {
                  var2 = secretPacketBuffer2.readOpcode() << 24;
                  var2 |= secretPacketBuffer2.readOpcode() << 16;
                  var2 |= secretPacketBuffer2.readOpcode() << 8;
                  var2 |= secretPacketBuffer2.readOpcode();
                  var3 = class232.method4077(class92.username);
                  if(class23.preferences.preferences.size() >= 10 && !class23.preferences.preferences.containsKey(Integer.valueOf(var3))) {
                     Iterator var13 = class23.preferences.preferences.entrySet().iterator();
                     var13.next();
                     var13.remove();
                  }

                  class23.preferences.preferences.put(Integer.valueOf(var3), Integer.valueOf(var2));
                  PendingSpawn.method1475();
               }

               rights = Occluder.rssocket.readByte();
               field1075 = Occluder.rssocket.readByte() == 1;
               localInteractingIndex = Occluder.rssocket.readByte();
               localInteractingIndex <<= 8;
               localInteractingIndex += Occluder.rssocket.readByte();
               field1028 = Occluder.rssocket.readByte();
               Occluder.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               Occluder.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();

               try {
                  class52.method787(class28.clientInstance, "zap");
               } catch (Throwable var9) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(Occluder.rssocket.available() >= packetLength) {
                  secretPacketBuffer2.offset = 0;
                  Occluder.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                  class3.method7();
                  class90.initializeGPI(secretPacketBuffer2);
                  class37.field494 = -1;
                  class5.xteaChanged(false);
                  packetType = -1;
               }

            } else {
               if(loginState == 11 && Occluder.rssocket.available() >= 2) {
                  secretPacketBuffer2.offset = 0;
                  Occluder.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                  secretPacketBuffer2.offset = 0;
                  class252.field3393 = secretPacketBuffer2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && Occluder.rssocket.available() >= class252.field3393) {
                  secretPacketBuffer2.offset = 0;
                  Occluder.rssocket.read(secretPacketBuffer2.payload, 0, class252.field3393);
                  secretPacketBuffer2.offset = 0;
                  String var14 = secretPacketBuffer2.readString();
                  String var7 = secretPacketBuffer2.readString();
                  String var8 = secretPacketBuffer2.readString();
                  class2.method6(var14, var7, var8);
                  WorldMapType2.setGameState(10);
               }

               if(loginState != 13) {
                  ++field939;
                  if(field939 > 2000) {
                     if(field941 < 1) {
                        if(class9.myWorldPort == class87.field1388) {
                           class9.myWorldPort = GameObject.field2188;
                        } else {
                           class9.myWorldPort = class87.field1388;
                        }

                        ++field941;
                        loginState = 0;
                     } else {
                        class23.method169(-3);
                     }
                  }
               } else {
                  if(packetLength == -1) {
                     if(Occluder.rssocket.available() < 2) {
                        return;
                     }

                     Occluder.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                     secretPacketBuffer2.offset = 0;
                     packetLength = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(Occluder.rssocket.available() >= packetLength) {
                     Occluder.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                     secretPacketBuffer2.offset = 0;
                     var1 = packetLength;
                     secretPacketBuffer1.offset = 0;
                     secretPacketBuffer2.offset = 0;
                     packetType = -1;
                     lastFrameId = -1;
                     secondLastFrameId = -1;
                     thridLastFrameId = -1;
                     packetLength = 0;
                     field1090 = 0;
                     field986 = 0;
                     menuOptionCount = 0;
                     field940 = -1;
                     isMenuOpen = false;
                     field1140 = 0;
                     destinationX = 0;

                     for(var2 = 0; var2 < 2048; ++var2) {
                        cachedPlayers[var2] = null;
                     }

                     Script.localPlayer = null;

                     for(var2 = 0; var2 < cachedNPCs.length; ++var2) {
                        NPC var15 = cachedNPCs[var2];
                        if(var15 != null) {
                           var15.interacting = -1;
                           var15.field1271 = false;
                        }
                     }

                     XItemContainer.itemContainers = new XHashTable(32);
                     WorldMapType2.setGameState(30);

                     for(var2 = 0; var2 < 100; ++var2) {
                        field1111[var2] = true;
                     }

                     class34.method480();
                     class90.initializeGPI(secretPacketBuffer2);
                     if(var1 != secretPacketBuffer2.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var10) {
         if(field941 < 1) {
            if(class9.myWorldPort == class87.field1388) {
               class9.myWorldPort = GameObject.field2188;
            } else {
               class9.myWorldPort = class87.field1388;
            }

            ++field941;
            loginState = 0;
         } else {
            class23.method169(-2);
         }
      }
   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1193504570"
   )
   final void method1153() {
      if(field986 > 1) {
         --field986;
      }

      if(field958 > 0) {
         --field958;
      }

      if(socketError) {
         socketError = false;
         if(field958 > 0) {
            class207.method3867();
         } else {
            WorldMapType2.setGameState(40);
            class261.field3623 = Occluder.rssocket;
            Occluder.rssocket = null;
         }

      } else {
         if(!isMenuOpen) {
            menuOptionCount = 0;
            field940 = -1;
            isMenuOpen = false;
            menuOptions[0] = "Cancel";
            menuTargets[0] = "";
            menuTypes[0] = 1006;
            menuOptionCount = 1;
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.processServerPacket(); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(class8.method42()) {
               secretPacketBuffer1.putOpcode(161);
               secretPacketBuffer1.putByte(0);
               var1 = secretPacketBuffer1.offset;
               class239.encodeClassVerifier(secretPacketBuffer1);
               secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var1);
            }

            Object var14 = KeyFocusListener.field641.field852;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            synchronized(KeyFocusListener.field641.field852) {
               if(!field908) {
                  KeyFocusListener.field641.field849 = 0;
               } else if(MouseInput.field728 != 0 || KeyFocusListener.field641.field849 >= 40) {
                  secretPacketBuffer1.putOpcode(206);
                  secretPacketBuffer1.putByte(0);
                  var2 = secretPacketBuffer1.offset;
                  var3 = 0;

                  for(var4 = 0; var4 < KeyFocusListener.field641.field849 && secretPacketBuffer1.offset - var2 < 240; ++var4) {
                     ++var3;
                     var5 = KeyFocusListener.field641.field851[var4];
                     if(var5 < 0) {
                        var5 = 0;
                     } else if(var5 > 502) {
                        var5 = 502;
                     }

                     var6 = KeyFocusListener.field641.field850[var4];
                     if(var6 < 0) {
                        var6 = 0;
                     } else if(var6 > 764) {
                        var6 = 764;
                     }

                     var7 = var6 + 765 * var5;
                     if(KeyFocusListener.field641.field851[var4] == -1 && KeyFocusListener.field641.field850[var4] == -1) {
                        var6 = -1;
                        var5 = -1;
                        var7 = 524287;
                     }

                     if(var6 == field917 && var5 == field918) {
                        if(field919 < 2047) {
                           ++field919;
                        }
                     } else {
                        var8 = var6 - field917;
                        field917 = var6;
                        var9 = var5 - field918;
                        field918 = var5;
                        if(field919 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                           var8 += 32;
                           var9 += 32;
                           secretPacketBuffer1.putShort(var9 + (field919 << 12) + (var8 << 6));
                           field919 = 0;
                        } else if(field919 < 8) {
                           secretPacketBuffer1.put24bitInt((field919 << 19) + 8388608 + var7);
                           field919 = 0;
                        } else {
                           secretPacketBuffer1.putInt(var7 + (field919 << 19) + -1073741824);
                           field919 = 0;
                        }
                     }
                  }

                  secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var2);
                  if(var3 >= KeyFocusListener.field641.field849) {
                     KeyFocusListener.field641.field849 = 0;
                  } else {
                     KeyFocusListener.field641.field849 -= var3;

                     for(var4 = 0; var4 < KeyFocusListener.field641.field849; ++var4) {
                        KeyFocusListener.field641.field850[var4] = KeyFocusListener.field641.field850[var3 + var4];
                        KeyFocusListener.field641.field851[var4] = KeyFocusListener.field641.field851[var3 + var4];
                     }
                  }
               }
            }

            if(MouseInput.field728 == 1 || !class33.field461 && MouseInput.field728 == 4 || MouseInput.field728 == 2) {
               long var15 = (MouseInput.field729 - field916) / 50L;
               if(var15 > 4095L) {
                  var15 = 4095L;
               }

               field916 = MouseInput.field729;
               var3 = MouseInput.field730;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > FloorUnderlayDefinition.canvasHeight) {
                  var3 = FloorUnderlayDefinition.canvasHeight;
               }

               var4 = MouseInput.field735;
               if(var4 < 0) {
                  var4 = 0;
               } else if(var4 > class77.canvasWidth) {
                  var4 = class77.canvasWidth;
               }

               var5 = (int)var15;
               secretPacketBuffer1.putOpcode(11);
               secretPacketBuffer1.putShort((var5 << 1) + (MouseInput.field728 == 2?1:0));
               secretPacketBuffer1.putShort(var4);
               secretPacketBuffer1.putShort(var3);
            }

            if(KeyFocusListener.field634 > 0) {
               secretPacketBuffer1.putOpcode(184);
               secretPacketBuffer1.putShort(0);
               var1 = secretPacketBuffer1.offset;
               long var17 = class46.currentTimeMs();

               for(var4 = 0; var4 < KeyFocusListener.field634; ++var4) {
                  long var19 = var17 - field1130;
                  if(var19 > 16777215L) {
                     var19 = 16777215L;
                  }

                  field1130 = var17;
                  secretPacketBuffer1.putByte(KeyFocusListener.field633[var4]);
                  secretPacketBuffer1.put24bitInt((int)var19);
               }

               secretPacketBuffer1.putShortLength(secretPacketBuffer1.offset - var1);
            }

            if(field996 > 0) {
               --field996;
            }

            if(KeyFocusListener.field626[96] || KeyFocusListener.field626[97] || KeyFocusListener.field626[98] || KeyFocusListener.field626[99]) {
               field997 = true;
            }

            if(field997 && field996 <= 0) {
               field996 = 20;
               field997 = false;
               secretPacketBuffer1.putOpcode(193);
               secretPacketBuffer1.putShortOb2(mapAngle);
               secretPacketBuffer1.putShortOb2(field989);
            }

            if(class21.field339 && !field1069) {
               field1069 = true;
               secretPacketBuffer1.putOpcode(138);
               secretPacketBuffer1.putByte(1);
            }

            if(!class21.field339 && field1069) {
               field1069 = false;
               secretPacketBuffer1.putOpcode(138);
               secretPacketBuffer1.putByte(0);
            }

            class7.method25();
            if(gameState == 30) {
               class2.method5();

               for(var1 = 0; var1 < field1080; ++var1) {
                  --field1149[var1];
                  if(field1149[var1] >= -10) {
                     SoundEffect var21 = audioEffects[var1];
                     if(var21 == null) {
                        Object var10000 = null;
                        var21 = SoundEffect.getTrack(WorldMapType2.field502, field1147[var1], 0);
                        if(var21 == null) {
                           continue;
                        }

                        field1149[var1] += var21.calculateDelay();
                        audioEffects[var1] = var21;
                     }

                     if(field1149[var1] < 0) {
                        if(field1014[var1] != 0) {
                           var4 = (field1014[var1] & 255) * 128;
                           var5 = field1014[var1] >> 16 & 255;
                           var6 = var5 * 128 + 64 - Script.localPlayer.x;
                           if(var6 < 0) {
                              var6 = -var6;
                           }

                           var7 = field1014[var1] >> 8 & 255;
                           var8 = var7 * 128 + 64 - Script.localPlayer.y;
                           if(var8 < 0) {
                              var8 = -var8;
                           }

                           var9 = var8 + var6 - 128;
                           if(var9 > var4) {
                              field1149[var1] = -100;
                              continue;
                           }

                           if(var9 < 0) {
                              var9 = 0;
                           }

                           var3 = (var4 - var9) * field1172 / var4;
                        } else {
                           var3 = field1059;
                        }

                        if(var3 > 0) {
                           class107 var22 = var21.method1906().method1955(Overlay.field3593);
                           class117 var23 = class117.method2195(var22, 100, var3);
                           var23.method2212(field965[var1] - 1);
                           class203.field2511.method1880(var23);
                        }

                        field1149[var1] = -100;
                     }
                  } else {
                     --field1080;

                     for(var2 = var1; var2 < field1080; ++var2) {
                        field1147[var2] = field1147[var2 + 1];
                        audioEffects[var2] = audioEffects[var2 + 1];
                        field965[var2] = field965[var2 + 1];
                        field1149[var2] = field1149[var2 + 1];
                        field1014[var2] = field1014[var2 + 1];
                     }

                     --var1;
                  }
               }

               if(field946) {
                  boolean var29;
                  if(class203.field2501 != 0) {
                     var29 = true;
                  } else {
                     var29 = class203.field2500.method3704();
                  }

                  if(!var29) {
                     if(field923 != 0 && field1142 != -1) {
                        Friend.method1083(class182.indexTrack1, field1142, 0, field923, false);
                     }

                     field946 = false;
                  }
               }

               ++field1090;
               if(field1090 > 750) {
                  if(field958 > 0) {
                     class207.method3867();
                  } else {
                     WorldMapType2.setGameState(40);
                     class261.field3623 = Occluder.rssocket;
                     Occluder.rssocket = null;
                  }

               } else {
                  var1 = class96.field1499;
                  int[] var34 = class96.field1492;

                  for(var3 = 0; var3 < var1; ++var3) {
                     Player var35 = cachedPlayers[var34[var3]];
                     if(var35 != null) {
                        WorldMapType1.method272(var35, 1);
                     }
                  }

                  for(var1 = 0; var1 < field944; ++var1) {
                     var2 = npcIndices[var1];
                     NPC var24 = cachedNPCs[var2];
                     if(var24 != null) {
                        WorldMapType1.method272(var24, var24.composition.field3557);
                     }
                  }

                  class11.method59();
                  ++field982;
                  if(cursorState != 0) {
                     field1015 += 20;
                     if(field1015 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class35.field482 != null) {
                     ++field1017;
                     if(field1017 >= 15) {
                        class48.method749(class35.field482);
                        class35.field482 = null;
                     }
                  }

                  Widget var33 = XGrandExchangeOffer.field308;
                  Widget var36 = class35.field483;
                  XGrandExchangeOffer.field308 = null;
                  class35.field483 = null;
                  field1083 = null;
                  field1087 = false;
                  field1084 = false;
                  field906 = 0;

                  while(class112.method2078() && field906 < 128) {
                     if(rights >= 2 && KeyFocusListener.field626[82] && KeyFocusListener.field627 == 66) {
                        String var37 = "";

                        MessageNode var25;
                        for(Iterator var38 = class98.field1520.iterator(); var38.hasNext(); var37 = var37 + var25.name + ':' + var25.value + '\n') {
                           var25 = (MessageNode)var38.next();
                        }

                        class28.clientInstance.method855(var37);
                     } else {
                        field1169[field906] = KeyFocusListener.field627;
                        field1001[field906] = class203.field2510;
                        ++field906;
                     }
                  }

                  if(widgetRoot != -1) {
                     class45.method667(widgetRoot, 0, 0, class77.canvasWidth, FloorUnderlayDefinition.canvasHeight, 0, 0);
                  }

                  ++field1045;

                  while(true) {
                     Widget var39;
                     Widget var40;
                     ScriptEvent var41;
                     do {
                        var41 = (ScriptEvent)field1106.popFront();
                        if(var41 == null) {
                           while(true) {
                              do {
                                 var41 = (ScriptEvent)field1115.popFront();
                                 if(var41 == null) {
                                    while(true) {
                                       do {
                                          var41 = (ScriptEvent)field1105.popFront();
                                          if(var41 == null) {
                                             this.method1158();
                                             class90.method1693();
                                             if(field1079 != null) {
                                                this.method1162();
                                             }

                                             if(Ignore.field841 != null) {
                                                class48.method749(Ignore.field841);
                                                ++field1051;
                                                if(MouseInput.field721 == 0) {
                                                   if(field1023) {
                                                      if(class66.field813 == Ignore.field841 && field943 != field1022) {
                                                         Widget var42 = Ignore.field841;
                                                         byte var32 = 0;
                                                         if(field972 == 1 && var42.contentType == 206) {
                                                            var32 = 1;
                                                         }

                                                         if(var42.itemIds[field1022] <= 0) {
                                                            var32 = 0;
                                                         }

                                                         var6 = class46.getWidgetConfig(var42);
                                                         boolean var31 = (var6 >> 29 & 1) != 0;
                                                         if(var31) {
                                                            var7 = field943;
                                                            var8 = field1022;
                                                            var42.itemIds[var8] = var42.itemIds[var7];
                                                            var42.itemQuantities[var8] = var42.itemQuantities[var7];
                                                            var42.itemIds[var7] = -1;
                                                            var42.itemQuantities[var7] = 0;
                                                         } else if(var32 == 1) {
                                                            var7 = field943;
                                                            var8 = field1022;

                                                            while(var7 != var8) {
                                                               if(var7 > var8) {
                                                                  var42.method3975(var7 - 1, var7);
                                                                  --var7;
                                                               } else if(var7 < var8) {
                                                                  var42.method3975(var7 + 1, var7);
                                                                  ++var7;
                                                               }
                                                            }
                                                         } else {
                                                            var42.method3975(field1022, field943);
                                                         }

                                                         secretPacketBuffer1.putOpcode(116);
                                                         secretPacketBuffer1.method3164(var32);
                                                         secretPacketBuffer1.putLEInt(Ignore.field841.id);
                                                         secretPacketBuffer1.putShort(field1022);
                                                         secretPacketBuffer1.putLEShortA(field943);
                                                      }
                                                   } else {
                                                      label1113: {
                                                         label1131: {
                                                            var3 = class134.method2587();
                                                            if(menuOptionCount > 2) {
                                                               boolean var30;
                                                               if(field1043 == 1) {
                                                                  if(menuOptionCount <= 0) {
                                                                     var30 = false;
                                                                  } else if(field1054 && KeyFocusListener.field626[81] && field940 != -1) {
                                                                     var30 = true;
                                                                  } else {
                                                                     var30 = false;
                                                                  }

                                                                  if(!var30) {
                                                                     break label1131;
                                                                  }
                                                               }

                                                               if(var3 < 0) {
                                                                  var30 = false;
                                                               } else {
                                                                  var5 = menuTypes[var3];
                                                                  if(var5 >= 2000) {
                                                                     var5 -= 2000;
                                                                  }

                                                                  if(var5 == 1007) {
                                                                     var30 = true;
                                                                  } else {
                                                                     var30 = false;
                                                                  }
                                                               }

                                                               if(var30) {
                                                                  break label1131;
                                                               }
                                                            }

                                                            if(menuOptionCount > 0) {
                                                               var4 = field1032;
                                                               var5 = field1021;
                                                               class33.method353(class98.field1525, var4, var5);
                                                               class98.field1525 = null;
                                                            }
                                                            break label1113;
                                                         }

                                                         this.method1159(field1032, field1021);
                                                      }
                                                   }

                                                   field1017 = 10;
                                                   MouseInput.field728 = 0;
                                                   Ignore.field841 = null;
                                                } else if(field1051 >= 5 && (MouseInput.field722 > field1032 + 5 || MouseInput.field722 < field1032 - 5 || MouseInput.field723 > field1021 + 5 || MouseInput.field723 < field1021 - 5)) {
                                                   field1023 = true;
                                                }
                                             }

                                             if(Region.method2705()) {
                                                var3 = Region.selectedRegionTileX;
                                                var4 = Region.selectedRegionTileY;
                                                secretPacketBuffer1.putOpcode(4);
                                                secretPacketBuffer1.putByte(5);
                                                secretPacketBuffer1.putShortLE(KeyFocusListener.field626[82]?(KeyFocusListener.field626[81]?2:1):0);
                                                secretPacketBuffer1.putLEShortA(var3 + class163.baseX);
                                                secretPacketBuffer1.putShortOb2(var4 + class10.baseY);
                                                Region.method2742();
                                                field1013 = MouseInput.field735;
                                                field1071 = MouseInput.field730;
                                                cursorState = 1;
                                                field1015 = 0;
                                                destinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(var33 != XGrandExchangeOffer.field308) {
                                                if(var33 != null) {
                                                   class48.method749(var33);
                                                }

                                                if(XGrandExchangeOffer.field308 != null) {
                                                   class48.method749(XGrandExchangeOffer.field308);
                                                }
                                             }

                                             if(var36 != class35.field483 && field1183 == field1132) {
                                                if(var36 != null) {
                                                   class48.method749(var36);
                                                }

                                                if(class35.field483 != null) {
                                                   class48.method749(class35.field483);
                                                }
                                             }

                                             if(class35.field483 != null) {
                                                if(field1132 < field1183) {
                                                   ++field1132;
                                                   if(field1183 == field1132) {
                                                      class48.method749(class35.field483);
                                                   }
                                                }
                                             } else if(field1132 > 0) {
                                                --field1132;
                                             }

                                             class56.method829();
                                             if(field1152) {
                                                var3 = ScriptState.field771 * 128 + 64;
                                                var4 = XItemContainer.field782 * 128 + 64;
                                                var5 = Actor.getTileHeight(var3, var4, class45.plane) - PendingSpawn.field1203;
                                                if(class41.cameraX < var3) {
                                                   class41.cameraX += DecorativeObject.field2171 + class43.field559 * (var3 - class41.cameraX) / 1000;
                                                   if(class41.cameraX > var3) {
                                                      class41.cameraX = var3;
                                                   }
                                                }

                                                if(class41.cameraX > var3) {
                                                   class41.cameraX -= class43.field559 * (class41.cameraX - var3) / 1000 + DecorativeObject.field2171;
                                                   if(class41.cameraX < var3) {
                                                      class41.cameraX = var3;
                                                   }
                                                }

                                                if(XItemContainer.cameraZ < var5) {
                                                   XItemContainer.cameraZ += (var5 - XItemContainer.cameraZ) * class43.field559 / 1000 + DecorativeObject.field2171;
                                                   if(XItemContainer.cameraZ > var5) {
                                                      XItemContainer.cameraZ = var5;
                                                   }
                                                }

                                                if(XItemContainer.cameraZ > var5) {
                                                   XItemContainer.cameraZ -= class43.field559 * (XItemContainer.cameraZ - var5) / 1000 + DecorativeObject.field2171;
                                                   if(XItemContainer.cameraZ < var5) {
                                                      XItemContainer.cameraZ = var5;
                                                   }
                                                }

                                                if(class7.cameraY < var4) {
                                                   class7.cameraY += (var4 - class7.cameraY) * class43.field559 / 1000 + DecorativeObject.field2171;
                                                   if(class7.cameraY > var4) {
                                                      class7.cameraY = var4;
                                                   }
                                                }

                                                if(class7.cameraY > var4) {
                                                   class7.cameraY -= class43.field559 * (class7.cameraY - var4) / 1000 + DecorativeObject.field2171;
                                                   if(class7.cameraY < var4) {
                                                      class7.cameraY = var4;
                                                   }
                                                }

                                                var3 = class181.field2434 * 128 + 64;
                                                var4 = GraphicsObject.field1354 * 128 + 64;
                                                var5 = Actor.getTileHeight(var3, var4, class45.plane) - BaseVarType.field29;
                                                var6 = var3 - class41.cameraX;
                                                var7 = var5 - XItemContainer.cameraZ;
                                                var8 = var4 - class7.cameraY;
                                                var9 = (int)Math.sqrt((double)(var6 * var6 + var8 * var8));
                                                int var10 = (int)(Math.atan2((double)var7, (double)var9) * 325.949D) & 2047;
                                                int var11 = (int)(Math.atan2((double)var6, (double)var8) * -325.949D) & 2047;
                                                if(var10 < 128) {
                                                   var10 = 128;
                                                }

                                                if(var10 > 383) {
                                                   var10 = 383;
                                                }

                                                if(class8.cameraPitch < var10) {
                                                   class8.cameraPitch += (var10 - class8.cameraPitch) * class37.field498 / 1000 + Timer.field2255;
                                                   if(class8.cameraPitch > var10) {
                                                      class8.cameraPitch = var10;
                                                   }
                                                }

                                                if(class8.cameraPitch > var10) {
                                                   class8.cameraPitch -= class37.field498 * (class8.cameraPitch - var10) / 1000 + Timer.field2255;
                                                   if(class8.cameraPitch < var10) {
                                                      class8.cameraPitch = var10;
                                                   }
                                                }

                                                int var12 = var11 - Friend.cameraYaw;
                                                if(var12 > 1024) {
                                                   var12 -= 2048;
                                                }

                                                if(var12 < -1024) {
                                                   var12 += 2048;
                                                }

                                                if(var12 > 0) {
                                                   Friend.cameraYaw += Timer.field2255 + var12 * class37.field498 / 1000;
                                                   Friend.cameraYaw &= 2047;
                                                }

                                                if(var12 < 0) {
                                                   Friend.cameraYaw -= -var12 * class37.field498 / 1000 + Timer.field2255;
                                                   Friend.cameraYaw &= 2047;
                                                }

                                                int var13 = var11 - Friend.cameraYaw;
                                                if(var13 > 1024) {
                                                   var13 -= 2048;
                                                }

                                                if(var13 < -1024) {
                                                   var13 += 2048;
                                                }

                                                if(var13 < 0 && var12 > 0 || var13 > 0 && var12 < 0) {
                                                   Friend.cameraYaw = var11;
                                                }
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field1157[var3];
                                             }

                                             class46.chatMessages.process();
                                             var3 = class8.method43();
                                             var4 = KeyFocusListener.keyboardIdleTicks;
                                             if(var3 > 15000 && var4 > 15000) {
                                                field958 = 250;
                                                MouseInput.mouseIdleTicks = 14500;
                                                secretPacketBuffer1.putOpcode(194);
                                             }

                                             ++field976;
                                             if(field976 > 500) {
                                                field976 = 0;
                                                var6 = (int)(Math.random() * 8.0D);
                                                if((var6 & 1) == 1) {
                                                   field970 += field1113;
                                                }

                                                if((var6 & 2) == 2) {
                                                   field1050 += field973;
                                                }

                                                if((var6 & 4) == 4) {
                                                   field969 += field922;
                                                }
                                             }

                                             if(field970 < -50) {
                                                field1113 = 2;
                                             }

                                             if(field970 > 50) {
                                                field1113 = -2;
                                             }

                                             if(field1050 < -55) {
                                                field973 = 2;
                                             }

                                             if(field1050 > 55) {
                                                field973 = -2;
                                             }

                                             if(field969 < -40) {
                                                field922 = 1;
                                             }

                                             if(field969 > 40) {
                                                field922 = -1;
                                             }

                                             ++field981;
                                             if(field981 > 500) {
                                                field981 = 0;
                                                var6 = (int)(Math.random() * 8.0D);
                                                if((var6 & 1) == 1) {
                                                   mapScale += mapOffset;
                                                }

                                                if((var6 & 2) == 2) {
                                                   mapScaleDelta += field980;
                                                }
                                             }

                                             if(mapScale < -60) {
                                                mapOffset = 2;
                                             }

                                             if(mapScale > 60) {
                                                mapOffset = -2;
                                             }

                                             if(mapScaleDelta < -20) {
                                                field980 = 1;
                                             }

                                             if(mapScaleDelta > 10) {
                                                field980 = -1;
                                             }

                                             for(class67 var43 = (class67)field1179.method3636(); var43 != null; var43 = (class67)field1179.method3629()) {
                                                if((long)var43.field820 < class46.currentTimeMs() / 1000L - 5L) {
                                                   if(var43.field818 > 0) {
                                                      WidgetNode.sendGameMessage(5, "", var43.field817 + " has logged in.");
                                                   }

                                                   if(var43.field818 == 0) {
                                                      WidgetNode.sendGameMessage(5, "", var43.field817 + " has logged out.");
                                                   }

                                                   var43.method3639();
                                                }
                                             }

                                             ++audioEffectCount;
                                             if(audioEffectCount > 50) {
                                                secretPacketBuffer1.putOpcode(102);
                                             }

                                             try {
                                                if(Occluder.rssocket != null && secretPacketBuffer1.offset > 0) {
                                                   Occluder.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
                                                   secretPacketBuffer1.offset = 0;
                                                   audioEffectCount = 0;
                                                }
                                             } catch (IOException var27) {
                                                if(field958 > 0) {
                                                   class207.method3867();
                                                } else {
                                                   WorldMapType2.setGameState(40);
                                                   class261.field3623 = Occluder.rssocket;
                                                   Occluder.rssocket = null;
                                                }
                                             }

                                             return;
                                          }

                                          var39 = var41.widget;
                                          if(var39.index < 0) {
                                             break;
                                          }

                                          var40 = class61.method1038(var39.parentId);
                                       } while(var40 == null || var40.children == null || var39.index >= var40.children.length || var39 != var40.children[var39.index]);

                                       class89.method1689(var41);
                                    }
                                 }

                                 var39 = var41.widget;
                                 if(var39.index < 0) {
                                    break;
                                 }

                                 var40 = class61.method1038(var39.parentId);
                              } while(var40 == null || var40.children == null || var39.index >= var40.children.length || var39 != var40.children[var39.index]);

                              class89.method1689(var41);
                           }
                        }

                        var39 = var41.widget;
                        if(var39.index < 0) {
                           break;
                        }

                        var40 = class61.method1038(var39.parentId);
                     } while(var40 == null || var40.children == null || var39.index >= var40.children.length || var39 != var40.children[var39.index]);

                     class89.method1689(var41);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-2100373548"
   )
   void method1346(Widget var1) {
      Widget var2 = var1.parentId == -1?null:class61.method1038(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = class77.canvasWidth;
         var4 = FloorUnderlayDefinition.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class181.method3424(var1, var3, var4, false);
      class164.method3055(var1, var3, var4);
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1028015639"
   )
   final void method1158() {
      World.method1562();
      if(Ignore.field841 == null) {
         if(field1079 == null) {
            int var1 = MouseInput.field728;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var8;
            int var9;
            int var11;
            if(isMenuOpen) {
               if(var1 != 1 && (class33.field461 || var1 != 4)) {
                  var2 = MouseInput.field722;
                  var3 = MouseInput.field723;
                  if(var2 < class61.menuX - 10 || var2 > class10.menuWidth + class61.menuX + 10 || var3 < class10.menuY - 10 || var3 > class23.menuHeight + class10.menuY + 10) {
                     isMenuOpen = false;
                     class39.method549(class61.menuX, class10.menuY, class10.menuWidth, class23.menuHeight);
                  }
               }

               if(var1 == 1 || !class33.field461 && var1 == 4) {
                  var2 = class61.menuX;
                  var3 = class10.menuY;
                  var4 = class10.menuWidth;
                  var5 = MouseInput.field735;
                  var6 = MouseInput.field730;
                  int var19 = -1;

                  for(var8 = 0; var8 < menuOptionCount; ++var8) {
                     var9 = var3 + 31 + (menuOptionCount - 1 - var8) * 15;
                     if(var5 > var2 && var5 < var4 + var2 && var6 > var9 - 13 && var6 < var9 + 3) {
                        var19 = var8;
                     }
                  }

                  if(var19 != -1 && var19 >= 0) {
                     var8 = menuActionParams0[var19];
                     var9 = menuActionParams1[var19];
                     int var20 = menuTypes[var19];
                     var11 = menuIdentifiers[var19];
                     String var12 = menuOptions[var19];
                     String var13 = menuTargets[var19];
                     class34.menuAction(var8, var9, var20, var11, var12, var13, MouseInput.field735, MouseInput.field730);
                  }

                  isMenuOpen = false;
                  class39.method549(class61.menuX, class10.menuY, class10.menuWidth, class23.menuHeight);
               }
            } else {
               var2 = class134.method2587();
               if((var1 == 1 || !class33.field461 && var1 == 4) && var2 >= 0) {
                  var3 = menuTypes[var2];
                  if(var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
                     label336: {
                        var4 = menuActionParams0[var2];
                        var5 = menuActionParams1[var2];
                        Widget var14 = class61.method1038(var5);
                        var8 = class46.getWidgetConfig(var14);
                        boolean var7 = (var8 >> 28 & 1) != 0;
                        if(!var7) {
                           Object var10000 = null;
                           if(!MilliTimer.method2901(class46.getWidgetConfig(var14))) {
                              break label336;
                           }
                        }

                        if(Ignore.field841 != null && !field1023) {
                           var9 = class134.method2587();
                           if(field1043 != 1) {
                              boolean var10;
                              if(var9 < 0) {
                                 var10 = false;
                              } else {
                                 var11 = menuTypes[var9];
                                 if(var11 >= 2000) {
                                    var11 -= 2000;
                                 }

                                 if(var11 == 1007) {
                                    var10 = true;
                                 } else {
                                    var10 = false;
                                 }
                              }

                              if(!var10 && menuOptionCount > 0) {
                                 var11 = field1032;
                                 int var15 = field1021;
                                 class33.method353(class98.field1525, var11, var15);
                                 class98.field1525 = null;
                              }
                           }
                        }

                        field1023 = false;
                        field1051 = 0;
                        if(Ignore.field841 != null) {
                           class48.method749(Ignore.field841);
                        }

                        Ignore.field841 = class61.method1038(var5);
                        field943 = var4;
                        field1032 = MouseInput.field735;
                        field1021 = MouseInput.field730;
                        if(var2 >= 0) {
                           class98.field1525 = new class89();
                           class98.field1525.field1402 = menuActionParams0[var2];
                           class98.field1525.field1399 = menuActionParams1[var2];
                           class98.field1525.field1400 = menuTypes[var2];
                           class98.field1525.field1403 = menuIdentifiers[var2];
                           class98.field1525.field1401 = menuOptions[var2];
                        }

                        class48.method749(Ignore.field841);
                        return;
                     }
                  }
               }

               if(var1 == 1 || !class33.field461 && var1 == 4) {
                  label338: {
                     label322: {
                        boolean var18;
                        if(field1043 == 1 && menuOptionCount > 2) {
                           if(menuOptionCount <= 0) {
                              var18 = false;
                           } else if(field1054 && KeyFocusListener.field626[81] && field940 != -1) {
                              var18 = true;
                           } else {
                              var18 = false;
                           }

                           if(!var18) {
                              break label322;
                           }
                        }

                        if(var2 < 0) {
                           var18 = false;
                        } else {
                           var4 = menuTypes[var2];
                           if(var4 >= 2000) {
                              var4 -= 2000;
                           }

                           if(var4 == 1007) {
                              var18 = true;
                           } else {
                              var18 = false;
                           }
                        }

                        if(!var18) {
                           break label338;
                        }
                     }

                     var1 = 2;
                  }
               }

               if((var1 == 1 || !class33.field461 && var1 == 4) && menuOptionCount > 0 && var2 >= 0) {
                  var3 = menuActionParams0[var2];
                  var4 = menuActionParams1[var2];
                  var5 = menuTypes[var2];
                  var6 = menuIdentifiers[var2];
                  String var16 = menuOptions[var2];
                  String var17 = menuTargets[var2];
                  class34.menuAction(var3, var4, var5, var6, var16, var17, MouseInput.field735, MouseInput.field730);
               }

               if(var1 == 2 && menuOptionCount > 0) {
                  this.method1159(MouseInput.field735, MouseInput.field730);
               }
            }

         }
      }
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-138100901"
   )
   final void method1162() {
      class48.method749(field1079);
      ++class33.field454;
      if(field1087 && field1084) {
         int var1 = MouseInput.field722;
         int var2 = MouseInput.field723;
         var1 -= field1081;
         var2 -= field1082;
         if(var1 < field1085) {
            var1 = field1085;
         }

         if(var1 + field1079.width > field1085 + field920.width) {
            var1 = field1085 + field920.width - field1079.width;
         }

         if(var2 < field1137) {
            var2 = field1137;
         }

         if(var2 + field1079.height > field1137 + field920.height) {
            var2 = field1137 + field920.height - field1079.height;
         }

         int var3 = var1 - field1046;
         int var4 = var2 - field1089;
         int var5 = field1079.field2729;
         if(class33.field454 > field1079.field2730 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1174 = true;
         }

         int var6 = var1 - field1085 + field920.scrollX;
         int var7 = var2 - field1137 + field920.scrollY;
         ScriptEvent var8;
         if(field1079.field2742 != null && field1174) {
            var8 = new ScriptEvent();
            var8.widget = field1079;
            var8.field831 = var6;
            var8.field828 = var7;
            var8.field839 = field1079.field2742;
            class89.method1689(var8);
         }

         if(MouseInput.field721 == 0) {
            if(field1174) {
               if(field1079.field2726 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field1079;
                  var8.field831 = var6;
                  var8.field828 = var7;
                  var8.field833 = field1083;
                  var8.field839 = field1079.field2726;
                  class89.method1689(var8);
               }

               if(field1083 != null && class77.method1480(field1079) != null) {
                  secretPacketBuffer1.putOpcode(239);
                  secretPacketBuffer1.method3291(field1083.id);
                  secretPacketBuffer1.method3171(field1079.index);
                  secretPacketBuffer1.method3171(field1079.itemId);
                  secretPacketBuffer1.putLEInt(field1079.id);
                  secretPacketBuffer1.putShort(field1083.index);
                  secretPacketBuffer1.putShortOb2(field1083.itemId);
               }
            } else {
               label121: {
                  label93: {
                     int var11 = class134.method2587();
                     int var10;
                     if(menuOptionCount > 2) {
                        if(field1043 == 1 && !Coordinates.method3932()) {
                           break label93;
                        }

                        boolean var9;
                        if(var11 < 0) {
                           var9 = false;
                        } else {
                           var10 = menuTypes[var11];
                           if(var10 >= 2000) {
                              var10 -= 2000;
                           }

                           if(var10 == 1007) {
                              var9 = true;
                           } else {
                              var9 = false;
                           }
                        }

                        if(var9) {
                           break label93;
                        }
                     }

                     if(menuOptionCount > 0) {
                        int var12 = field1081 + field1046;
                        var10 = field1082 + field1089;
                        class33.method353(class98.field1525, var12, var10);
                        class98.field1525 = null;
                     }
                     break label121;
                  }

                  this.method1159(field1081 + field1046, field1089 + field1082);
               }
            }

            field1079 = null;
         }

      } else {
         if(class33.field454 > 1) {
            field1079 = null;
         }

      }
   }

   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = new Parameters[]{Parameters.field3713, Parameters.field3714, Parameters.field3727, Parameters.field3712, Parameters.field3722, Parameters.field3717, Parameters.field3718, Parameters.field3720, Parameters.field3716, Parameters.field3724, Parameters.field3721, Parameters.field3725, Parameters.field3726, Parameters.field3715, Parameters.field3719};
         Parameters[] var2 = var1;

         int var3;
         String var5;
         int var19;
         int var22;
         for(var3 = 0; var3 < var2.length; ++var3) {
            Parameters var4 = var2[var3];
            var5 = this.getParameter(var4.key);
            if(var5 != null) {
               switch(Integer.parseInt(var4.key)) {
               case 2:
                  class31.field437 = Integer.parseInt(var5);
                  break;
               case 3:
                  MouseInput.field733 = var5;
               case 4:
               case 14:
               default:
                  break;
               case 5:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 6:
                  class8.sessionToken = var5;
                  break;
               case 7:
                  class232[] var36 = new class232[]{class232.field3193, class232.field3195, class232.field3192, class232.field3194, class232.field3197, class232.field3196};
                  Varcs.field1515 = (class232)PendingSpawn.forOrdinal(var36, Integer.parseInt(var5));
                  if(class232.field3193 == Varcs.field1515) {
                     class164.field2317 = class289.field3857;
                  } else {
                     class164.field2317 = class289.field3860;
                  }
                  break;
               case 8:
                  var22 = Integer.parseInt(var5);
                  BuildType[] var23 = new BuildType[]{BuildType.BUILD_LIVE, BuildType.WIP, BuildType.LIVE, BuildType.RC};
                  BuildType[] var9 = var23;
                  var19 = 0;

                  BuildType var6;
                  while(true) {
                     if(var19 >= var9.length) {
                        var6 = null;
                        break;
                     }

                     BuildType var20 = var9[var19];
                     if(var22 == var20.ordinal) {
                        var6 = var20;
                        break;
                     }

                     ++var19;
                  }

                  class11.field269 = var6;
                  break;
               case 9:
                  flags = Integer.parseInt(var5);
                  break;
               case 10:
                  socketType = Integer.parseInt(var5);
                  break;
               case 11:
                  languageId = Integer.parseInt(var5);
                  break;
               case 12:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 13:
                  class25.field371 = Integer.parseInt(var5);
                  break;
               case 15:
                  world = Integer.parseInt(var5);
               }
            }
         }

         class35.method484();
         class18.host = this.getCodeBase().getHost();
         String var33 = class11.field269.identifier;
         byte var17 = 0;

         try {
            class155.field2241 = 17;
            WorldMapType2.field512 = var17;

            try {
               class155.osName = System.getProperty("os.name");
            } catch (Exception var29) {
               class155.osName = "Unknown";
            }

            class13.osNameLC = class155.osName.toLowerCase();

            try {
               class66.userHome = System.getProperty("user.home");
               if(class66.userHome != null) {
                  class66.userHome = class66.userHome + "/";
               }
            } catch (Exception var28) {
               ;
            }

            try {
               if(class13.osNameLC.startsWith("win")) {
                  if(class66.userHome == null) {
                     class66.userHome = System.getenv("USERPROFILE");
                  }
               } else if(class66.userHome == null) {
                  class66.userHome = System.getenv("HOME");
               }

               if(class66.userHome != null) {
                  class66.userHome = class66.userHome + "/";
               }
            } catch (Exception var27) {
               ;
            }

            if(class66.userHome == null) {
               class66.userHome = "~/";
            }

            class2.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class66.userHome, "/tmp/", ""};
            class77.field1212 = new String[]{".jagex_cache_" + WorldMapType2.field512, ".file_store_" + WorldMapType2.field512};
            var3 = 0;

            label271:
            while(var3 < 4) {
               var5 = var3 == 0?"":"" + var3;
               class155.field2244 = new File(class66.userHome, "jagex_cl_oldschool_" + var33 + var5 + ".dat");
               String var37 = null;
               String var7 = null;
               boolean var8 = false;
               Buffer var10;
               File var40;
               if(class155.field2244.exists()) {
                  try {
                     FileOnDisk var38 = new FileOnDisk(class155.field2244, "rw", 10000L);

                     int var11;
                     for(var10 = new Buffer((int)var38.length()); var10.offset < var10.payload.length; var10.offset += var11) {
                        var11 = var38.read(var10.payload, var10.offset, var10.payload.length - var10.offset);
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
                        var37 = var10.getJagString();
                        if(var12 == 1) {
                           var7 = var10.getJagString();
                        }
                     } else {
                        var37 = var10.getCESU8();
                        if(var12 == 1) {
                           var7 = var10.getCESU8();
                        }
                     }

                     var38.close();
                  } catch (IOException var31) {
                     var31.printStackTrace();
                  }

                  if(var37 != null) {
                     var40 = new File(var37);
                     if(!var40.exists()) {
                        var37 = null;
                     }
                  }

                  if(var37 != null) {
                     var40 = new File(var37, "test.dat");
                     if(!class7.method28(var40, true)) {
                        var37 = null;
                     }
                  }
               }

               if(var37 == null && var3 == 0) {
                  label246:
                  for(int var18 = 0; var18 < class77.field1212.length; ++var18) {
                     for(var19 = 0; var19 < class2.cacheLocations.length; ++var19) {
                        File var42 = new File(class2.cacheLocations[var19] + class77.field1212[var18] + File.separatorChar + "oldschool" + File.separatorChar);
                        if(var42.exists() && class7.method28(new File(var42, "test.dat"), true)) {
                           var37 = var42.toString();
                           var8 = true;
                           break label246;
                        }
                     }
                  }
               }

               if(var37 == null) {
                  var37 = class66.userHome + File.separatorChar + "jagexcache" + var5 + File.separatorChar + "oldschool" + File.separatorChar + var33 + File.separatorChar;
                  var8 = true;
               }

               File var39;
               if(var7 != null) {
                  var39 = new File(var7);
                  var40 = new File(var37);

                  try {
                     File[] var43 = var39.listFiles();
                     File[] var21 = var43;

                     for(int var13 = 0; var13 < var21.length; ++var13) {
                        File var14 = var21[var13];
                        File var15 = new File(var40, var14.getName());
                        boolean var16 = var14.renameTo(var15);
                        if(!var16) {
                           throw new IOException();
                        }
                     }
                  } catch (Exception var30) {
                     var30.printStackTrace();
                  }

                  var8 = true;
               }

               if(var8) {
                  var39 = new File(var37);
                  var10 = null;

                  try {
                     FileOnDisk var44 = new FileOnDisk(class155.field2244, "rw", 10000L);
                     Buffer var45 = new Buffer(500);
                     var45.putByte(3);
                     var45.putByte(var10 != null?1:0);
                     var45.putCESU8(var39.getPath());
                     if(var10 != null) {
                        var45.putCESU8("");
                     }

                     var44.write(var45.payload, 0, var45.offset);
                     var44.close();
                  } catch (IOException var26) {
                     var26.printStackTrace();
                  }
               }

               File var34 = new File(var37);
               class155.field2243 = var34;
               if(!class155.field2243.exists()) {
                  class155.field2243.mkdirs();
               }

               File[] var35 = class155.field2243.listFiles();
               if(var35 != null) {
                  File[] var41 = var35;

                  for(var22 = 0; var22 < var41.length; ++var22) {
                     File var46 = var41[var22];
                     if(!class7.method28(var46, false)) {
                        ++var3;
                        continue label271;
                     }
                  }
               }
               break;
            }

            File var24 = class155.field2243;
            class157.field2254 = var24;
            if(!class157.field2254.exists()) {
               throw new RuntimeException("");
            }

            class157.field2250 = true;
            class43.method628();
            class155.field2237 = new CacheFile(new FileOnDisk(class21.method156("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class155.field2246 = new CacheFile(new FileOnDisk(class21.method156("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class155.field2247 = new CacheFile[class155.field2241];

            for(int var25 = 0; var25 < class155.field2241; ++var25) {
               class155.field2247[var25] = new CacheFile(new FileOnDisk(class21.method156("main_file_cache.idx" + var25), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var32) {
            class54.method800((String)null, var32);
         }

         class28.clientInstance = this;
         this.initialize(765, 503, 149);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;LIndexDataBase;I)V",
      garbageValue = "-2047908332"
   )
   public static void method1165(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      Sequence.seq_ref = var0;
      Sequence.skel_ref = var1;
      class46.skin_ref = var2;
   }
}
