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
   @ObfuscatedName("jh")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      longValue = 7248468098182346983L
   )
   static long field925;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -567562277
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("or")
   static SpritePixels[] field927;
   @ObfuscatedName("be")
   static class289 field928;
   @ObfuscatedName("bv")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("bt")
   static boolean field930;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -2017794749
   )
   static int field931;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -65787909
   )
   @Export("gameState")
   @Hook("gameStateChanged")
   static int gameState;
   @ObfuscatedName("bm")
   static boolean field934;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -134168631
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      longValue = 167538832964274053L
   )
   static long field936;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = 128619517
   )
   static int field937;
   @ObfuscatedName("ha")
   static int[] field938;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1908360401
   )
   static int field939;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -2047564953
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("bf")
   static boolean field941;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -1717334073
   )
   static int field942;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -802317489
   )
   static int field943;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -753932491
   )
   static int field944;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = 1785808227
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1774797781
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = 605985197
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -1461405183
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("du")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 601194655
   )
   static int field950;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = -182291421
   )
   static int field951;
   @ObfuscatedName("ch")
   static class91 field952;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 2121802623
   )
   static int field953;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1145797937
   )
   static int field954;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -1909317803
   )
   static int field955;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 1430816639
   )
   static int field956;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -837516649
   )
   static int field957;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = -587991875
   )
   static int field958;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = 160813165
   )
   static int field959;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 1611601913
   )
   static int field960;
   @ObfuscatedName("dq")
   static byte[] field961;
   @ObfuscatedName("dh")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("ke")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -55907845
   )
   static int field964;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -2094388453
   )
   static int field965;
   @ObfuscatedName("il")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -271962153
   )
   static int field967;
   @ObfuscatedName("ef")
   @Export("secretPacketBuffer1")
   static PacketBuffer secretPacketBuffer1;
   @ObfuscatedName("et")
   static PacketBuffer field969;
   @ObfuscatedName("ex")
   @Export("secretPacketBuffer2")
   static PacketBuffer secretPacketBuffer2;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = -374488129
   )
   @Export("packetLength")
   static int packetLength;
   @ObfuscatedName("jc")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -1441305797
   )
   static int field973;
   @ObfuscatedName("ag")
   static boolean field974;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 1875929111
   )
   static int field975;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = -1590766769
   )
   static int field976;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 1739316727
   )
   static int field977;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -835851787
   )
   static int field978;
   @ObfuscatedName("en")
   static boolean field979;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1751580747
   )
   static int field980;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -690092307
   )
   @Export("packetType")
   static int packetType;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = -1454127981
   )
   static int field982;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 228207307
   )
   static int field983;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 590999603
   )
   static int field984;
   @ObfuscatedName("ja")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("fu")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("fy")
   static int[][][] field988;
   @ObfuscatedName("fd")
   static final int[] field989;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 1464103407
   )
   static int field990;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = -1332381313
   )
   static int field991;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = 855301949
   )
   static int field992;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -2074568913
   )
   static int field993;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -1200562601
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -644956321
   )
   static int field995;
   @ObfuscatedName("pk")
   static int[] field996;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -665921397
   )
   static int field997;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 944782635
   )
   @Export("mapOffset")
   static int mapOffset;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 1083794937
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -2102716331
   )
   static int field1000;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 1655412211
   )
   static int field1001;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 2133800363
   )
   static int field1002;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -1978901237
   )
   static int field1003;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = -933404277
   )
   static int field1004;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -1077365635
   )
   static int field1005;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 48036581
   )
   static int field1006;
   @ObfuscatedName("gd")
   static boolean field1007;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -957114541
   )
   static int field1008;
   @ObfuscatedName("hq")
   static int[] field1009;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -1692805001
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("oo")
   static int[] field1011;
   @ObfuscatedName("ck")
   static class91 field1012;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = -1566749653
   )
   static int field1013;
   @ObfuscatedName("oj")
   static boolean field1014;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 404124949
   )
   static int field1015;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = -1680149971
   )
   static int field1016;
   @ObfuscatedName("hj")
   static boolean field1017;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = -901419675
   )
   static int field1018;
   @ObfuscatedName("jb")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = -466278327
   )
   static int field1020;
   @ObfuscatedName("hc")
   static int[] field1021;
   @ObfuscatedName("hv")
   static int[] field1022;
   @ObfuscatedName("jl")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("hr")
   static int[] field1024;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 431894117
   )
   static int field1025;
   @ObfuscatedName("do")
   static int[] field1026;
   @ObfuscatedName("hp")
   static int[] field1027;
   @ObfuscatedName("hw")
   static String[] field1028;
   @ObfuscatedName("qb")
   static class195 field1029;
   @ObfuscatedName("ml")
   static boolean[] field1030;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 402388475
   )
   static int field1031;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = -210047501
   )
   static int field1032;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -311294849
   )
   static int field1033;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = -1152753709
   )
   static int field1034;
   @ObfuscatedName("mg")
   static Deque field1035;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -991456099
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = 992573133
   )
   static int field1037;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = -503828801
   )
   static int field1038;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = -1678707641
   )
   static int field1039;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -113772529
   )
   static int field1040;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = -106733151
   )
   static int field1041;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -2077409537
   )
   static int field1042;
   @ObfuscatedName("ik")
   static boolean field1043;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = -1361753897
   )
   static int field1044;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -1976237821
   )
   static int field1045;
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = -1656497923
   )
   static int field1046;
   @ObfuscatedName("ng")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = -784300341
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = 1573780963
   )
   static int field1049;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 853519289
   )
   static int field1050;
   @ObfuscatedName("in")
   static int[] field1051;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -1046211743
   )
   static int field1052;
   @ObfuscatedName("rx")
   static int[] field1053;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 684176081
   )
   static int field1054;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -1213693803
   )
   static int field1055;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -1013741015
   )
   static int field1056;
   @ObfuscatedName("na")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("hy")
   static int[][] field1058;
   @ObfuscatedName("jm")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("jy")
   static Deque field1060;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = -251951651
   )
   static int field1061;
   @ObfuscatedName("br")
   static String field1062;
   @ObfuscatedName("jo")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = 552196973
   )
   static int field1064;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = -1114668847
   )
   static int field1065;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -1173019241
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = 299742685
   )
   static int field1067;
   @ObfuscatedName("jj")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("lf")
   static boolean field1069;
   @ObfuscatedName("jz")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("jk")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = 2108181969
   )
   static int field1072;
   @ObfuscatedName("ka")
   static boolean field1073;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = 1062808217
   )
   static int field1074;
   @ObfuscatedName("kj")
   static boolean field1075;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 1738349315
   )
   static int field1076;
   @ObfuscatedName("je")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("kd")
   static String field1078;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = 1445870979
   )
   static int field1079;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = 1507969511
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("it")
   @Export("selectedItemName")
   static String selectedItemName;
   @ObfuscatedName("kz")
   static boolean field1082;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = -1349577323
   )
   static int field1083;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -709374917
   )
   static int field1084;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 1659439725
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("jp")
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 666429679
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("kn")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = -747449965
   )
   static int field1089;
   @ObfuscatedName("bn")
   static boolean field1090;
   @ObfuscatedName("kg")
   static Widget field1091;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = -1477020681
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 3163697
   )
   static int field1093;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = 1865936115
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("jf")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("lg")
   static boolean field1096;
   @ObfuscatedName("lw")
   static boolean field1097;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = -906210597
   )
   static int field1098;
   @ObfuscatedName("lb")
   static Widget field1099;
   @ObfuscatedName("la")
   static Widget field1100;
   @ObfuscatedName("lo")
   static Widget field1101;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = 1406142281
   )
   static int field1102;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -2116005485
   )
   static int field1103;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 700114361
   )
   static int field1104;
   @ObfuscatedName("lq")
   static Widget field1105;
   @ObfuscatedName("jr")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = 389946335
   )
   static int field1107;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 888152433
   )
   static int field1108;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -67336079
   )
   static int field1109;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = -678992705
   )
   static int field1110;
   @ObfuscatedName("ll")
   static boolean field1111;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = 1663757081
   )
   static int field1112;
   @ObfuscatedName("mq")
   static int[] field1113;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -830373883
   )
   static int field1114;
   @ObfuscatedName("mk")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = -1838856649
   )
   static int field1116;
   @ObfuscatedName("mj")
   static int[] field1117;
   @ObfuscatedName("qh")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = 2072301701
   )
   static int field1119;
   @ObfuscatedName("rl")
   @ObfuscatedGetter(
      longValue = -2583683208705519181L
   )
   static long field1120;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = 1517115953
   )
   static int field1121;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = -34843465
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("ju")
   static int[] field1123;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = 2121660935
   )
   static int field1124;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = 1855739033
   )
   static int field1125;
   @ObfuscatedName("qk")
   static short field1126;
   @ObfuscatedName("mi")
   static Deque field1127;
   @ObfuscatedName("mw")
   static Deque field1128;
   @ObfuscatedName("mx")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -347494989
   )
   static int field1130;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = 1834022629
   )
   static int field1131;
   @ObfuscatedName("mv")
   static boolean[] field1132;
   @ObfuscatedName("ma")
   static boolean[] field1133;
   @ObfuscatedName("ey")
   static HashMap field1134;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -574486665
   )
   static int field1135;
   @ObfuscatedName("ny")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("nl")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("nq")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = -2103423627
   )
   @Export(
      value = "gameDrawingMode",
      setter = true
   )
   static int gameDrawingMode;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      longValue = 5292899068453965093L
   )
   static long field1140;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = 1397302557
   )
   static int field1141;
   @ObfuscatedName("nz")
   static int[] field1142;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = 394066429
   )
   static int field1143;
   @ObfuscatedName("ri")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("nc")
   static String field1145;
   @ObfuscatedName("nb")
   static long[] field1146;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = 46582019
   )
   static int field1147;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = -1444692491
   )
   static int field1148;
   @ObfuscatedName("nj")
   static int[] field1149;
   @ObfuscatedName("nx")
   static int[] field1150;
   @ObfuscatedName("hl")
   static int[] field1151;
   @ObfuscatedName("os")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("ov")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = 1851423691
   )
   static int field1154;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      intValue = -765737529
   )
   static int field1155;
   @ObfuscatedName("oe")
   static int[] field1156;
   @ObfuscatedName("dj")
   static class153 field1157;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 1221457903
   )
   static int field1158;
   @ObfuscatedName("ku")
   static String field1159;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = 523061993
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("ob")
   @ObfuscatedGetter(
      intValue = 1581907207
   )
   static int field1161;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = -13882777
   )
   static int field1162;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = 107096801
   )
   static int field1163;
   @ObfuscatedName("px")
   static int[] field1164;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = -470184995
   )
   static int field1165;
   @ObfuscatedName("qo")
   static short field1166;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1816222573
   )
   @Export("world")
   static int world;
   @ObfuscatedName("pl")
   static int[] field1168;
   @ObfuscatedName("pp")
   static int[] field1169;
   @ObfuscatedName("ps")
   static int[] field1170;
   @ObfuscatedName("pt")
   static int[] field1171;
   @ObfuscatedName("pu")
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("py")
   static boolean field1173;
   @ObfuscatedName("pb")
   static boolean[] field1174;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = -1133397171
   )
   static int field1175;
   @ObfuscatedName("lh")
   static boolean field1176;
   @ObfuscatedName("qd")
   static int[] field1177;
   @ObfuscatedName("qc")
   static int[] field1178;
   @ObfuscatedName("qq")
   static short field1179;
   @ObfuscatedName("qr")
   static short field1180;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = -2002045201
   )
   static int field1181;
   @ObfuscatedName("qa")
   static short field1182;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -741980333
   )
   static int field1183;
   @ObfuscatedName("qn")
   static short field1184;
   @ObfuscatedName("qp")
   static short field1185;
   @ObfuscatedName("qm")
   static short field1186;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = -269667163
   )
   static int field1187;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 650182341
   )
   static int field1188;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 564929087
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = -1636667767
   )
   static int field1190;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 1431572451
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = -340921381
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = -92104077
   )
   static int field1193;
   @ObfuscatedName("qv")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -370053621
   )
   static int field1195;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = -945264169
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -739869949
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("qs")
   static PlayerComposition field1198;
   @ObfuscatedName("li")
   static boolean field1199;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = -182413147
   )
   static int field1200;
   @ObfuscatedName("ji")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 2103267763
   )
   static int field1202;
   @ObfuscatedName("rp")
   @ObfuscatedGetter(
      longValue = -5809422450451253103L
   )
   static long field1203;
   @ObfuscatedName("rk")
   static final class73 field1204;
   @ObfuscatedName("rw")
   static int[] field1205;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -1121258119
   )
   @Export("audioEffectCount")
   static int audioEffectCount;
   @ObfuscatedName("bc")
   static class232 field1207;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = 581412713
   )
   static int field1208;

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1781341341"
   )
   protected final void vmethod1184() {
   }

   public final void init() {
      if(this.method882()) {
         class274[] var1 = Widget.method3999();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class274 var3 = var1[var2];
            String var4 = this.getParameter(var3.field3726);
            if(var4 != null) {
               switch(Integer.parseInt(var3.field3726)) {
               case 1:
                  WorldMapType1.field443 = var4;
                  break;
               case 2:
                  world = Integer.parseInt(var4);
               case 3:
               case 4:
               case 5:
               default:
                  break;
               case 6:
                  int var25 = Integer.parseInt(var4);
                  class231[] var7 = class35.method507();
                  int var8 = 0;

                  class231 var36;
                  while(true) {
                     if(var8 >= var7.length) {
                        var36 = null;
                        break;
                     }

                     class231 var9 = var7[var8];
                     if(var9.field3196 == var25) {
                        var36 = var9;
                        break;
                     }

                     ++var8;
                  }

                  class165.field2332 = var36;
                  break;
               case 7:
                  field1062 = var4;
                  break;
               case 8:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 9:
                  Coordinates.field2618 = Integer.parseInt(var4);
                  break;
               case 10:
                  class33.field480 = Integer.parseInt(var4);
                  break;
               case 11:
                  field931 = Integer.parseInt(var4);
                  break;
               case 12:
                  class232[] var5 = new class232[]{class232.field3199, class232.field3201, class232.field3204, class232.field3202, class232.field3198, class232.field3200};
                  field1207 = (class232)class134.method2577(var5, Integer.parseInt(var4));
                  if(field1207 == class232.field3199) {
                     field928 = class289.field3862;
                  } else {
                     field928 = class289.field3861;
                  }
                  break;
               case 13:
                  flags = Integer.parseInt(var4);
                  break;
               case 14:
                  field1202 = Integer.parseInt(var4);
                  break;
               case 15:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
               }
            }
         }

         Region.field2094 = false;
         field930 = false;
         class172.host = this.getCodeBase().getHost();
         String var32 = class165.field2332.field3194;
         byte var33 = 0;

         try {
            class182.field2445 = 17;
            class35.field514 = var33;

            try {
               class155.field2263 = System.getProperty("os.name");
            } catch (Exception var28) {
               class155.field2263 = "Unknown";
            }

            class155.field2261 = class155.field2263.toLowerCase();

            try {
               GraphicsObject.field1383 = System.getProperty("user.home");
               if(GraphicsObject.field1383 != null) {
                  GraphicsObject.field1383 = GraphicsObject.field1383 + "/";
               }
            } catch (Exception var27) {
               ;
            }

            try {
               if(class155.field2261.startsWith("win")) {
                  if(GraphicsObject.field1383 == null) {
                     GraphicsObject.field1383 = System.getenv("USERPROFILE");
                  }
               } else if(GraphicsObject.field1383 == null) {
                  GraphicsObject.field1383 = System.getenv("HOME");
               }

               if(GraphicsObject.field1383 != null) {
                  GraphicsObject.field1383 = GraphicsObject.field1383 + "/";
               }
            } catch (Exception var26) {
               ;
            }

            if(GraphicsObject.field1383 == null) {
               GraphicsObject.field1383 = "~/";
            }

            class37.field533 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", GraphicsObject.field1383, "/tmp/", ""};
            FaceNormal.field2153 = new String[]{".jagex_cache_" + class35.field514, ".file_store_" + class35.field514};
            int var17 = 0;

            label264:
            while(var17 < 4) {
               String var37 = var17 == 0?"":"" + var17;
               class155.field2257 = new File(GraphicsObject.field1383, "jagex_cl_oldschool_" + var32 + var37 + ".dat");
               String var6 = null;
               String var39 = null;
               boolean var40 = false;
               File var43;
               if(class155.field2257.exists()) {
                  try {
                     FileOnDisk var41 = new FileOnDisk(class155.field2257, "rw", 10000L);

                     Buffer var10;
                     int var11;
                     for(var10 = new Buffer((int)var41.method2379()); var10.offset < var10.payload.length; var10.offset += var11) {
                        var11 = var41.method2367(var10.payload, var10.offset, var10.payload.length - var10.offset);
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
                        var6 = var10.method3155();
                        if(var12 == 1) {
                           var39 = var10.method3155();
                        }
                     } else {
                        var6 = var10.method3156();
                        if(var12 == 1) {
                           var39 = var10.method3156();
                        }
                     }

                     var41.method2381();
                  } catch (IOException var30) {
                     var30.printStackTrace();
                  }

                  if(var6 != null) {
                     var43 = new File(var6);
                     if(!var43.exists()) {
                        var6 = null;
                     }
                  }

                  if(var6 != null) {
                     var43 = new File(var6, "test.dat");
                     if(!class61.method1100(var43, true)) {
                        var6 = null;
                     }
                  }
               }

               if(var6 == null && var17 == 0) {
                  label240:
                  for(int var18 = 0; var18 < FaceNormal.field2153.length; ++var18) {
                     for(int var19 = 0; var19 < class37.field533.length; ++var19) {
                        File var20 = new File(class37.field533[var19] + FaceNormal.field2153[var18] + File.separatorChar + "oldschool" + File.separatorChar);
                        if(var20.exists() && class61.method1100(new File(var20, "test.dat"), true)) {
                           var6 = var20.toString();
                           var40 = true;
                           break label240;
                        }
                     }
                  }
               }

               if(var6 == null) {
                  var6 = GraphicsObject.field1383 + File.separatorChar + "jagexcache" + var37 + File.separatorChar + "oldschool" + File.separatorChar + var32 + File.separatorChar;
                  var40 = true;
               }

               if(var39 != null) {
                  File var42 = new File(var39);
                  var43 = new File(var6);

                  try {
                     File[] var45 = var42.listFiles();
                     File[] var22 = var45;

                     for(int var13 = 0; var13 < var22.length; ++var13) {
                        File var14 = var22[var13];
                        File var15 = new File(var43, var14.getName());
                        boolean var16 = var14.renameTo(var15);
                        if(!var16) {
                           throw new IOException();
                        }
                     }
                  } catch (Exception var29) {
                     var29.printStackTrace();
                  }

                  var40 = true;
               }

               if(var40) {
                  Friend.method1118(new File(var6), (File)null);
               }

               File var35 = new File(var6);
               Frames.field2158 = var35;
               if(!Frames.field2158.exists()) {
                  Frames.field2158.mkdirs();
               }

               File[] var38 = Frames.field2158.listFiles();
               if(var38 == null) {
                  break;
               }

               File[] var44 = var38;
               int var23 = 0;

               while(true) {
                  if(var23 >= var44.length) {
                     break label264;
                  }

                  File var24 = var44[var23];
                  if(!class61.method1100(var24, false)) {
                     ++var17;
                     break;
                  }

                  ++var23;
               }
            }

            File var34 = Frames.field2158;
            class157.field2268 = var34;
            if(!class157.field2268.exists()) {
               throw new RuntimeException("");
            }

            class157.field2271 = true;
            Player.method1177();
            class155.field2259 = new class123(new FileOnDisk(class40.method561("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class155.field2262 = new class123(new FileOnDisk(class40.method561("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class4.field32 = new class123[class182.field2445];

            for(int var21 = 0; var21 < class182.field2445; ++var21) {
               class4.field32[var21] = new class123(new FileOnDisk(class40.method561("main_file_cache.idx" + var21), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var31) {
            class151.method2912((String)null, var31);
         }

         class261.field3632 = this;
         this.method895(765, 503, 148);
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "446180837"
   )
   protected final void vmethod1186() {
      class33.field481 = field1202 == 0?'ꩊ':world + '鱀';
      class37.field529 = field1202 == 0?443:world + '썐';
      class96.field1530 = class33.field481;
      class18.field323 = class214.field2638;
      PlayerComposition.field2627 = class214.field2631;
      NPC.field1398 = class214.field2633;
      PlayerComposition.field2620 = class214.field2634;
      this.method919();
      this.method875();
      class2.field16 = this.method913();
      Ignore.field861 = new IndexFile(255, class155.field2259, class155.field2262, 500000);
      FileOnDisk var2 = null;
      Preferences var3 = new Preferences();

      int var5;
      try {
         var2 = class22.getPreferencesFile("", field1207.field3203, false);
         byte[] var4 = new byte[(int)var2.method2379()];

         int var6;
         for(var5 = 0; var5 < var4.length; var5 += var6) {
            var6 = var2.method2367(var4, var5, var4.length - var5);
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
            var2.method2381();
         }
      } catch (Exception var8) {
         ;
      }

      class8.field247 = var3;
      this.method909();
      String var10 = GameEngine.field735;
      class56.field699 = this;
      class56.field705 = var10;
      if(field1202 != 0) {
         field941 = true;
      }

      int var7 = class8.field247.field1325;
      field1140 = 0L;
      if(var7 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      var5 = isResized?2:1;
      if(var5 == 1) {
         class261.field3632.method869(765, 503);
      } else {
         class261.field3632.method869(7680, 2160);
      }

      if(gameState >= 25) {
         class5.method18();
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1797794752"
   )
   protected final void vmethod1189() {
      if(class71.chatMessages.method1811()) {
         class71.chatMessages.method1809();
      }

      if(WorldMapType3.field393 != null) {
         WorldMapType3.field393.field874 = false;
      }

      WorldMapType3.field393 = null;
      if(class244.rssocket != null) {
         class244.rssocket.close();
         class244.rssocket = null;
      }

      if(class50.keyboard != null) {
         class50 var1 = class50.keyboard;
         synchronized(class50.keyboard) {
            class50.keyboard = null;
         }
      }

      if(class59.mouse != null) {
         class59 var9 = class59.mouse;
         synchronized(class59.mouse) {
            class59.mouse = null;
         }
      }

      class2.field16 = null;
      if(FrameMap.field2065 != null) {
         FrameMap.field2065.method2025();
      }

      if(class59.field755 != null) {
         class59.field755.method2025();
      }

      class231.method4105();
      Object var10 = class236.field3244;
      synchronized(class236.field3244) {
         if(class236.field3243 != 0) {
            class236.field3243 = 1;

            try {
               class236.field3244.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      class217.method4045();
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1598096844"
   )
   void method1190() {
      if(gameState != 1000) {
         boolean var1 = class96.method1799();
         if(!var1) {
            this.method1195();
         }

      }
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "938011508"
   )
   void method1192(int var1) {
      class89.field1430 = null;
      FileOnDisk.rssocket = null;
      field954 = 0;
      if(class33.field481 == class96.field1530) {
         class96.field1530 = class37.field529;
      } else {
         class96.field1530 = class33.field481;
      }

      ++field956;
      if(field956 < 2 || var1 != 7 && var1 != 9) {
         if(field956 >= 2 && var1 == 6) {
            this.method933("js5connect_outofdate");
            gameState = 1000;
         } else if(field956 >= 4) {
            if(gameState <= 5) {
               this.method933("js5connect");
               gameState = 1000;
            } else {
               field955 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method933("js5connect_full");
         gameState = 1000;
      } else {
         field955 = 3000;
      }

   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-123"
   )
   final void method1193() {
      try {
         if(loginState == 0) {
            if(class244.rssocket != null) {
               class244.rssocket.close();
               class244.rssocket = null;
            }

            field1157 = null;
            field979 = false;
            field958 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(field1157 == null) {
               field1157 = GameEngine.field720.method2926(class172.host, class96.field1530);
            }

            if(field1157.status == 2) {
               throw new IOException();
            }

            if(field1157.status == 1) {
               class244.rssocket = new RSSocket((Socket)field1157.field2239, GameEngine.field720);
               field1157 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(14);
            class244.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, 1);
            secretPacketBuffer2.offset = 0;
            loginState = 3;
         }

         int var1;
         if(loginState == 3) {
            if(FrameMap.field2065 != null) {
               FrameMap.field2065.method2062();
            }

            if(class59.field755 != null) {
               class59.field755.method2062();
            }

            var1 = class244.rssocket.readByte();
            if(FrameMap.field2065 != null) {
               FrameMap.field2065.method2062();
            }

            if(class59.field755 != null) {
               class59.field755.method2062();
            }

            if(var1 != 0) {
               class15.method86(var1);
               return;
            }

            secretPacketBuffer2.offset = 0;
            loginState = 4;
         }

         if(loginState == 4) {
            if(secretPacketBuffer2.offset < 8) {
               var1 = class244.rssocket.available();
               if(var1 > 8 - secretPacketBuffer2.offset) {
                  var1 = 8 - secretPacketBuffer2.offset;
               }

               if(var1 > 0) {
                  class244.rssocket.read(secretPacketBuffer2.payload, secretPacketBuffer2.offset, var1);
                  secretPacketBuffer2.offset += var1;
               }
            }

            if(secretPacketBuffer2.offset == 8) {
               secretPacketBuffer2.offset = 0;
               class24.field368 = secretPacketBuffer2.readLong();
               loginState = 5;
            }
         }

         int var2;
         int var3;
         if(loginState == 5) {
            int[] var6 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class24.field368 >> 32), (int)(class24.field368 & -1L)};
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(1);
            secretPacketBuffer1.putByte(class92.field1472.rsOrdinal());
            secretPacketBuffer1.putInt(var6[0]);
            secretPacketBuffer1.putInt(var6[1]);
            secretPacketBuffer1.putInt(var6[2]);
            secretPacketBuffer1.putInt(var6[3]);
            switch(class92.field1472.field2220) {
            case 0:
            case 1:
               secretPacketBuffer1.put24bitInt(Script.authCodeForLogin);
               secretPacketBuffer1.offset += 5;
               break;
            case 2:
               secretPacketBuffer1.putInt(((Integer)class8.field247.preferences.get(Integer.valueOf(class6.method30(class92.username)))).intValue());
               secretPacketBuffer1.offset += 4;
               break;
            case 3:
               secretPacketBuffer1.offset += 8;
            }

            secretPacketBuffer1.method3137(class92.password);
            secretPacketBuffer1.encryptRsa(class90.rsaKeyExponent, class90.rsaKeyModulus);
            field969.offset = 0;
            if(gameState == 40) {
               field969.putByte(18);
            } else {
               field969.putByte(16);
            }

            field969.putShort(0);
            var2 = field969.offset;
            field969.putInt(148);
            field969.putBytes(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
            var3 = field969.offset;
            field969.method3137(class92.username);
            field969.putByte((isResized?1:0) << 1 | (field930?1:0));
            field969.putShort(class45.canvasWidth);
            field969.putShort(CollisionData.canvasHeight);
            class73.method1152(field969);
            field969.method3137(field1062);
            field969.putInt(class33.field480);
            Buffer var4 = new Buffer(Ignore.field866.method5370());
            Ignore.field866.method5372(var4);
            field969.putBytes(var4.payload, 0, var4.payload.length);
            field969.putByte(Coordinates.field2618);
            field969.putInt(0);
            field969.putInt(class44.indexInterfaces.field3231);
            field969.putInt(class261.indexSoundEffects.field3231);
            field969.putInt(class91.field1446.field3231);
            field969.putInt(class10.field259.field3231);
            field969.putInt(class98.field1545.field3231);
            field969.putInt(Frames.indexMaps.field3231);
            field969.putInt(class44.indexTrack1.field3231);
            field969.putInt(class1.indexModels.field3231);
            field969.putInt(class18.indexSprites.field3231);
            field969.putInt(class87.indexTextures.field3231);
            field969.putInt(DecorativeObject.field2194.field3231);
            field969.putInt(XGrandExchangeOffer.indexTrack2.field3231);
            field969.putInt(class169.indexScripts.field3231);
            field969.putInt(RSCanvas.field693.field3231);
            field969.putInt(class12.field274.field3231);
            field969.putInt(class28.field424.field3231);
            field969.putInt(class61.indexWorldMap.field3231);
            field969.encryptXtea(var6, var3, field969.offset);
            field969.putShortLength(field969.offset - var2);
            class244.rssocket.queueForWrite(field969.payload, 0, field969.offset);
            secretPacketBuffer1.seed(var6);

            for(int var5 = 0; var5 < 4; ++var5) {
               var6[var5] += 50;
            }

            secretPacketBuffer2.seed(var6);
            loginState = 6;
         }

         if(loginState == 6 && class244.rssocket.available() > 0) {
            var1 = class244.rssocket.readByte();
            if(var1 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var1 == 2) {
               loginState = 9;
            } else if(var1 == 15 && gameState == 40) {
               packetLength = -1;
               loginState = 13;
            } else if(var1 == 23 && field959 < 1) {
               ++field959;
               loginState = 0;
            } else {
               if(var1 != 29) {
                  class15.method86(var1);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && class244.rssocket.available() > 0) {
            field1093 = (class244.rssocket.readByte() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field958 = 0;
            class13.method64("You have only just left another world.", "Your profile will be transferred in:", field1093 / 60 + " seconds.");
            if(--field1093 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && class244.rssocket.available() >= 13) {
               boolean var12 = class244.rssocket.readByte() == 1;
               class244.rssocket.read(secretPacketBuffer2.payload, 0, 4);
               secretPacketBuffer2.offset = 0;
               boolean var11 = false;
               if(var12) {
                  var2 = secretPacketBuffer2.readOpcode() << 24;
                  var2 |= secretPacketBuffer2.readOpcode() << 16;
                  var2 |= secretPacketBuffer2.readOpcode() << 8;
                  var2 |= secretPacketBuffer2.readOpcode();
                  var3 = class6.method30(class92.username);
                  if(class8.field247.preferences.size() >= 10 && !class8.field247.preferences.containsKey(Integer.valueOf(var3))) {
                     Iterator var13 = class8.field247.preferences.entrySet().iterator();
                     var13.next();
                     var13.remove();
                  }

                  class8.field247.preferences.put(Integer.valueOf(var3), Integer.valueOf(var2));
                  class1.method3();
               }

               rights = class244.rssocket.readByte();
               field1096 = class244.rssocket.readByte() == 1;
               localInteractingIndex = class244.rssocket.readByte();
               localInteractingIndex <<= 8;
               localInteractingIndex += class244.rssocket.readByte();
               field1049 = class244.rssocket.readByte();
               class244.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               class244.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();

               try {
                  Client var7 = class261.field3632;
                  JSObject.getWindow(var7).call("zap", (Object[])null);
               } catch (Throwable var9) {
                  ;
               }

               loginState = 10;
            }

            if(loginState != 10) {
               if(loginState == 11 && class244.rssocket.available() >= 2) {
                  secretPacketBuffer2.offset = 0;
                  class244.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                  secretPacketBuffer2.offset = 0;
                  class224.field2853 = secretPacketBuffer2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && class244.rssocket.available() >= class224.field2853) {
                  secretPacketBuffer2.offset = 0;
                  class244.rssocket.read(secretPacketBuffer2.payload, 0, class224.field2853);
                  secretPacketBuffer2.offset = 0;
                  String var17 = secretPacketBuffer2.readString();
                  String var20 = secretPacketBuffer2.readString();
                  String var19 = secretPacketBuffer2.readString();
                  class13.method64(var17, var20, var19);
                  TextureProvider.setGameState(10);
               }

               if(loginState == 13) {
                  if(packetLength == -1) {
                     if(class244.rssocket.available() < 2) {
                        return;
                     }

                     class244.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                     secretPacketBuffer2.offset = 0;
                     packetLength = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(class244.rssocket.available() >= packetLength) {
                     class244.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                     secretPacketBuffer2.offset = 0;
                     var1 = packetLength;
                     class31.method266();
                     class17.method119(secretPacketBuffer2);
                     if(var1 != secretPacketBuffer2.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field958;
                  if(field958 > 2000) {
                     if(field959 < 1) {
                        if(class33.field481 == class96.field1530) {
                           class96.field1530 = class37.field529;
                        } else {
                           class96.field1530 = class33.field481;
                        }

                        ++field959;
                        loginState = 0;
                     } else {
                        class15.method86(-3);
                     }
                  }
               }
            } else {
               if(class244.rssocket.available() >= packetLength) {
                  secretPacketBuffer2.offset = 0;
                  class244.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                  field936 = -1L;
                  field939 = -1;
                  WorldMapType3.field393.field878 = 0;
                  class21.field342 = true;
                  field1090 = true;
                  field925 = -1L;
                  class280.field3755 = new CombatInfoList();
                  secretPacketBuffer1.offset = 0;
                  secretPacketBuffer2.offset = 0;
                  packetType = -1;
                  field964 = 1;
                  field976 = -1;
                  field977 = -1;
                  field973 = 0;
                  field942 = 0;
                  field978 = 0;
                  field943 = 0;
                  class60.method1055();
                  class83.method1674(0);
                  class8.method44();
                  itemSelectionState = 0;
                  field1082 = false;
                  field1181 = 0;
                  field1072 = (int)(Math.random() * 100.0D) - 50;
                  field1033 = (int)(Math.random() * 110.0D) - 55;
                  field951 = (int)(Math.random() * 80.0D) - 40;
                  mapScale = (int)(Math.random() * 120.0D) - 60;
                  mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
                  mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
                  field1161 = 0;
                  field1154 = -1;
                  destinationX = 0;
                  destinationY = 0;
                  field1012 = class91.field1441;
                  field952 = class91.field1441;
                  field937 = 0;
                  method1525();

                  for(var1 = 0; var1 < 2048; ++var1) {
                     cachedPlayers[var1] = null;
                  }

                  for(var1 = 0; var1 < '耀'; ++var1) {
                     cachedNPCs[var1] = null;
                  }

                  field1056 = -1;
                  projectiles.method3582();
                  field1060.method3582();

                  for(var1 = 0; var1 < 4; ++var1) {
                     for(var2 = 0; var2 < 104; ++var2) {
                        for(var3 = 0; var3 < 104; ++var3) {
                           groundItemDeque[var1][var2][var3] = null;
                        }
                     }
                  }

                  pendingSpawns = new Deque();
                  field1193 = 0;
                  friendCount = 0;
                  ignoreCount = 0;

                  for(var1 = 0; var1 < class241.field3289; ++var1) {
                     class241 var18 = (class241)class241.field3290.get((long)var1);
                     class241 var8;
                     if(var18 != null) {
                        var8 = var18;
                     } else {
                        byte[] var14 = class241.field3292.getConfigData(16, var1);
                        var18 = new class241();
                        if(var14 != null) {
                           var18.method4281(new Buffer(var14));
                        }

                        class241.field3290.put(var18, (long)var1);
                        var8 = var18;
                     }

                     if(var8 != null) {
                        class211.settings[var1] = 0;
                        class211.widgetSettings[var1] = 0;
                     }
                  }

                  class71.chatMessages.method1810();
                  field1065 = -1;
                  if(widgetRoot != -1) {
                     PacketBuffer.method3411(widgetRoot);
                  }

                  for(WidgetNode var15 = (WidgetNode)componentTable.method3533(); var15 != null; var15 = (WidgetNode)componentTable.method3538()) {
                     class95.method1780(var15, true);
                  }

                  widgetRoot = -1;
                  componentTable = new XHashTable(8);
                  field1091 = null;
                  class60.method1055();
                  field1198.method3962((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var1 = 0; var1 < 8; ++var1) {
                     playerOptions[var1] = null;
                     playerOptionsPriorities[var1] = false;
                  }

                  class1.method0();
                  field934 = true;

                  for(var1 = 0; var1 < 100; ++var1) {
                     field1132[var1] = true;
                  }

                  secretPacketBuffer1.putOpcode(226);
                  PacketBuffer var16 = secretPacketBuffer1;
                  var2 = isResized?2:1;
                  var16.putByte(var2);
                  secretPacketBuffer1.putShort(class45.canvasWidth);
                  secretPacketBuffer1.putShort(CollisionData.canvasHeight);
                  clanChatOwner = null;
                  class28.clanChatCount = 0;
                  class11.clanMembers = null;

                  for(var1 = 0; var1 < 8; ++var1) {
                     grandExchangeOffers[var1] = new XGrandExchangeOffer();
                  }

                  class66.field833 = null;
                  class17.method119(secretPacketBuffer2);
                  World.field1321 = -1;
                  class1.xteaChanged(false);
                  packetType = -1;
               }

            }
         }
      } catch (IOException var10) {
         if(field959 < 1) {
            if(class33.field481 == class96.field1530) {
               class96.field1530 = class37.field529;
            } else {
               class96.field1530 = class33.field481;
            }

            ++field959;
            loginState = 0;
         } else {
            class15.method86(-2);
         }
      }
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-37"
   )
   final void method1194() {
      if(field942 > 1) {
         --field942;
      }

      if(field978 > 0) {
         --field978;
      }

      if(field979) {
         field979 = false;
         class13.method60();
      } else {
         if(!isMenuOpen) {
            class60.method1055();
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
            while(class223.method4072()) {
               secretPacketBuffer1.putOpcode(74);
               secretPacketBuffer1.putByte(0);
               var1 = secretPacketBuffer1.offset;
               class205.method3805(secretPacketBuffer1);
               secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var1);
            }

            Object var13 = WorldMapType3.field393.field869;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            synchronized(WorldMapType3.field393.field869) {
               if(!field974) {
                  WorldMapType3.field393.field878 = 0;
               } else if(class59.field742 != 0 || WorldMapType3.field393.field878 >= 40) {
                  secretPacketBuffer1.putOpcode(54);
                  secretPacketBuffer1.putByte(0);
                  var2 = secretPacketBuffer1.offset;
                  var3 = 0;

                  for(var4 = 0; var4 < WorldMapType3.field393.field878 && secretPacketBuffer1.offset - var2 < 240; ++var4) {
                     ++var3;
                     var5 = WorldMapType3.field393.field872[var4];
                     if(var5 < 0) {
                        var5 = 0;
                     } else if(var5 > 502) {
                        var5 = 502;
                     }

                     var6 = WorldMapType3.field393.field871[var4];
                     if(var6 < 0) {
                        var6 = 0;
                     } else if(var6 > 764) {
                        var6 = 764;
                     }

                     var7 = var5 * 765 + var6;
                     if(WorldMapType3.field393.field872[var4] == -1 && WorldMapType3.field393.field871[var4] == -1) {
                        var6 = -1;
                        var5 = -1;
                        var7 = 524287;
                     }

                     if(field1130 == var6 && var5 == field953) {
                        if(field939 < 2047) {
                           ++field939;
                        }
                     } else {
                        var8 = var6 - field1130;
                        field1130 = var6;
                        var9 = var5 - field953;
                        field953 = var5;
                        if(field939 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                           var8 += 32;
                           var9 += 32;
                           secretPacketBuffer1.putShort((var8 << 6) + (field939 << 12) + var9);
                           field939 = 0;
                        } else if(field939 < 8) {
                           secretPacketBuffer1.put24bitInt((field939 << 19) + 8388608 + var7);
                           field939 = 0;
                        } else {
                           secretPacketBuffer1.putInt(var7 + (field939 << 19) + -1073741824);
                           field939 = 0;
                        }
                     }
                  }

                  secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var2);
                  if(var3 >= WorldMapType3.field393.field878) {
                     WorldMapType3.field393.field878 = 0;
                  } else {
                     WorldMapType3.field393.field878 -= var3;

                     for(var4 = 0; var4 < WorldMapType3.field393.field878; ++var4) {
                        WorldMapType3.field393.field871[var4] = WorldMapType3.field393.field871[var3 + var4];
                        WorldMapType3.field393.field872[var4] = WorldMapType3.field393.field872[var3 + var4];
                     }
                  }
               }
            }

            if(class59.field742 == 1 || !class34.field499 && class59.field742 == 4 || class59.field742 == 2) {
               long var14 = (class59.field757 - field936) / 50L;
               if(var14 > 4095L) {
                  var14 = 4095L;
               }

               field936 = class59.field757;
               var3 = class59.field756;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > CollisionData.canvasHeight) {
                  var3 = CollisionData.canvasHeight;
               }

               var4 = class59.field747;
               if(var4 < 0) {
                  var4 = 0;
               } else if(var4 > class45.canvasWidth) {
                  var4 = class45.canvasWidth;
               }

               var5 = (int)var14;
               secretPacketBuffer1.putOpcode(171);
               secretPacketBuffer1.putShort((var5 << 1) + (class59.field742 == 2?1:0));
               secretPacketBuffer1.putShort(var4);
               secretPacketBuffer1.putShort(var3);
            }

            if(class50.field671 > 0) {
               secretPacketBuffer1.putOpcode(3);
               secretPacketBuffer1.putShort(0);
               var1 = secretPacketBuffer1.offset;
               long var16 = class172.method3128();

               for(var4 = 0; var4 < class50.field671; ++var4) {
                  long var18 = var16 - field925;
                  if(var18 > 16777215L) {
                     var18 = 16777215L;
                  }

                  field925 = var16;
                  secretPacketBuffer1.method3184((int)var18);
                  secretPacketBuffer1.putShortLE(class50.field670[var4]);
               }

               secretPacketBuffer1.putShortLength(secretPacketBuffer1.offset - var1);
            }

            if(field1016 > 0) {
               --field1016;
            }

            if(class50.field659[96] || class50.field659[97] || class50.field659[98] || class50.field659[99]) {
               field1017 = true;
            }

            if(field1017 && field1016 <= 0) {
               field1016 = 20;
               field1017 = false;
               secretPacketBuffer1.putOpcode(50);
               secretPacketBuffer1.putShortOb2(field1052);
               secretPacketBuffer1.putIntOb1(mapAngle);
            }

            if(class21.field342 && !field1090) {
               field1090 = true;
               secretPacketBuffer1.putOpcode(154);
               secretPacketBuffer1.putByte(1);
            }

            if(!class21.field342 && field1090) {
               field1090 = false;
               secretPacketBuffer1.putOpcode(154);
               secretPacketBuffer1.putByte(0);
            }

            class18.method132();
            if(gameState == 30) {
               for(PendingSpawn var30 = (PendingSpawn)pendingSpawns.method3584(); var30 != null; var30 = (PendingSpawn)pendingSpawns.method3578()) {
                  if(var30.hitpoints > 0) {
                     --var30.hitpoints;
                  }

                  ObjectComposition var20;
                  boolean var27;
                  if(var30.hitpoints == 0) {
                     if(var30.field1209 >= 0) {
                        var3 = var30.field1209;
                        var4 = var30.field1222;
                        var20 = class251.getObjectDefinition(var3);
                        if(var4 == 11) {
                           var4 = 10;
                        }

                        if(var4 >= 5 && var4 <= 8) {
                           var4 = 4;
                        }

                        var27 = var20.method4515(var4);
                        if(!var27) {
                           continue;
                        }
                     }

                     Friend.method1119(var30.level, var30.type, var30.x, var30.y, var30.field1209, var30.field1214, var30.field1222);
                     var30.unlink();
                  } else {
                     if(var30.delay > 0) {
                        --var30.delay;
                     }

                     if(var30.delay == 0 && var30.x >= 1 && var30.y >= 1 && var30.x <= 102 && var30.y <= 102) {
                        if(var30.id >= 0) {
                           var3 = var30.id;
                           var4 = var30.field1223;
                           var20 = class251.getObjectDefinition(var3);
                           if(var4 == 11) {
                              var4 = 10;
                           }

                           if(var4 >= 5 && var4 <= 8) {
                              var4 = 4;
                           }

                           var27 = var20.method4515(var4);
                           if(!var27) {
                              continue;
                           }
                        }

                        Friend.method1119(var30.level, var30.type, var30.x, var30.y, var30.id, var30.orientation, var30.field1223);
                        var30.delay = -1;
                        if(var30.field1209 == var30.id && var30.field1209 == -1) {
                           var30.unlink();
                        } else if(var30.field1209 == var30.id && var30.field1214 == var30.orientation && var30.field1223 == var30.field1222) {
                           var30.unlink();
                        }
                     }
                  }
               }

               for(var1 = 0; var1 < field1181; ++var1) {
                  --field1170[var1];
                  if(field1170[var1] >= -10) {
                     SoundEffect var22 = audioEffects[var1];
                     if(var22 == null) {
                        Object var10000 = null;
                        var22 = SoundEffect.method1954(class98.field1545, field1168[var1], 0);
                        if(var22 == null) {
                           continue;
                        }

                        field1170[var1] += var22.method1944();
                        audioEffects[var1] = var22;
                     }

                     if(field1170[var1] < 0) {
                        if(field1171[var1] != 0) {
                           var4 = (field1171[var1] & 255) * 128;
                           var5 = field1171[var1] >> 16 & 255;
                           var6 = var5 * 128 + 64 - XItemContainer.localPlayer.x;
                           if(var6 < 0) {
                              var6 = -var6;
                           }

                           var7 = field1171[var1] >> 8 & 255;
                           var8 = var7 * 128 + 64 - XItemContainer.localPlayer.y;
                           if(var8 < 0) {
                              var8 = -var8;
                           }

                           var9 = var8 + var6 - 128;
                           if(var9 > var4) {
                              field1170[var1] = -100;
                              continue;
                           }

                           if(var9 < 0) {
                              var9 = 0;
                           }

                           var3 = (var4 - var9) * field1098 / var4;
                        } else {
                           var3 = field1165;
                        }

                        if(var3 > 0) {
                           class107 var23 = var22.method1942().method1989(class225.field2896);
                           class117 var32 = class117.method2229(var23, 100, var3);
                           var32.method2126(field1169[var1] - 1);
                           class19.field328.method1890(var32);
                        }

                        field1170[var1] = -100;
                     }
                  } else {
                     --field1181;

                     for(var2 = var1; var2 < field1181; ++var2) {
                        field1168[var2] = field1168[var2 + 1];
                        audioEffects[var2] = audioEffects[var2 + 1];
                        field1169[var2] = field1169[var2 + 1];
                        field1170[var2] = field1170[var2 + 1];
                        field1171[var2] = field1171[var2 + 1];
                     }

                     --var1;
                  }
               }

               if(field1014 && !class89.method1718()) {
                  if(field1162 != 0 && field1163 != -1) {
                     class29.method232(class44.indexTrack1, field1163, 0, field1162, false);
                  }

                  field1014 = false;
               }

               ++field973;
               if(field973 > 750) {
                  class13.method60();
               } else {
                  class29.method234();

                  for(var1 = 0; var1 < field937; ++var1) {
                     var2 = npcIndices[var1];
                     NPC var21 = cachedNPCs[var2];
                     if(var21 != null) {
                        RSCanvas.method809(var21, var21.composition.field3561);
                     }
                  }

                  ISAACCipher.method3422();
                  ++field1002;
                  if(cursorState != 0) {
                     field967 += 20;
                     if(field967 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(Buffer.field2405 != null) {
                     ++field997;
                     if(field997 >= 15) {
                        class88.method1714(Buffer.field2405);
                        Buffer.field2405 = null;
                     }
                  }

                  Widget var31 = KitDefinition.field3371;
                  Widget var38 = PendingSpawn.field1211;
                  KitDefinition.field3371 = null;
                  PendingSpawn.field1211 = null;
                  field1105 = null;
                  field1176 = false;
                  field1069 = false;
                  field1037 = 0;

                  while(class14.method77() && field1037 < 128) {
                     if(rights >= 2 && class50.field659[82] && class168.field2346 == 66) {
                        String var34 = WallObject.method2865();
                        class261.field3632.method972(var34);
                     } else {
                        field1150[field1037] = class168.field2346;
                        field1149[field1037] = IndexDataBase.field3238;
                        ++field1037;
                     }
                  }

                  if(widgetRoot != -1) {
                     var3 = widgetRoot;
                     var4 = class45.canvasWidth;
                     var5 = CollisionData.canvasHeight;
                     if(class66.method1121(var3)) {
                        WorldMapType1.method262(class46.widgets[var3], -1, 0, 0, var4, var5, 0, 0);
                     }
                  }

                  ++field1112;

                  while(true) {
                     Widget var33;
                     class69 var35;
                     Widget var39;
                     do {
                        var35 = (class69)field1127.method3587();
                        if(var35 == null) {
                           while(true) {
                              do {
                                 var35 = (class69)field1128.method3587();
                                 if(var35 == null) {
                                    while(true) {
                                       do {
                                          var35 = (class69)field1035.method3587();
                                          if(var35 == null) {
                                             this.method1199();
                                             if(class43.renderOverview != null) {
                                                class43.renderOverview.method5187(WallObject.plane, (XItemContainer.localPlayer.x >> 7) + class50.baseX, (XItemContainer.localPlayer.y >> 7) + class266.baseY, false);
                                                class43.renderOverview.method5201();
                                             }

                                             if(field1100 != null) {
                                                this.method1436();
                                             }

                                             if(class95.field1513 != null) {
                                                class88.method1714(class95.field1513);
                                                ++field1044;
                                                if(class59.field754 == 0) {
                                                   if(field1043) {
                                                      if(FaceNormal.field2155 == class95.field1513 && field1039 != field1042) {
                                                         Widget var37 = class95.field1513;
                                                         byte var29 = 0;
                                                         if(field1141 == 1 && var37.contentType == 206) {
                                                            var29 = 1;
                                                         }

                                                         if(var37.itemIds[field1042] <= 0) {
                                                            var29 = 0;
                                                         }

                                                         if(class29.method235(WorldMapType3.method199(var37))) {
                                                            var5 = field1039;
                                                            var6 = field1042;
                                                            var37.itemIds[var6] = var37.itemIds[var5];
                                                            var37.itemQuantities[var6] = var37.itemQuantities[var5];
                                                            var37.itemIds[var5] = -1;
                                                            var37.itemQuantities[var5] = 0;
                                                         } else if(var29 == 1) {
                                                            var5 = field1039;
                                                            var6 = field1042;

                                                            while(var5 != var6) {
                                                               if(var5 > var6) {
                                                                  var37.method4006(var5 - 1, var5);
                                                                  --var5;
                                                               } else if(var5 < var6) {
                                                                  var37.method4006(var5 + 1, var5);
                                                                  ++var5;
                                                               }
                                                            }
                                                         } else {
                                                            var37.method4006(field1042, field1039);
                                                         }

                                                         secretPacketBuffer1.putOpcode(19);
                                                         secretPacketBuffer1.method3257(class95.field1513.id);
                                                         secretPacketBuffer1.putIntOb1(field1039);
                                                         secretPacketBuffer1.method3265(var29);
                                                         secretPacketBuffer1.putShortOb2(field1042);
                                                      }
                                                   } else {
                                                      label1204: {
                                                         label953: {
                                                            var3 = class2.method7();
                                                            if(menuOptionCount > 2) {
                                                               if(field1064 == 1 && !FaceNormal.method2868()) {
                                                                  break label953;
                                                               }

                                                               boolean var28;
                                                               if(var3 < 0) {
                                                                  var28 = false;
                                                               } else {
                                                                  var5 = menuTypes[var3];
                                                                  if(var5 >= 2000) {
                                                                     var5 -= 2000;
                                                                  }

                                                                  if(var5 == 1007) {
                                                                     var28 = true;
                                                                  } else {
                                                                     var28 = false;
                                                                  }
                                                               }

                                                               if(var28) {
                                                                  break label953;
                                                               }
                                                            }

                                                            if(menuOptionCount > 0) {
                                                               var4 = field1040;
                                                               var5 = field1041;
                                                               class67.method1122(class13.field281, var4, var5);
                                                               class13.field281 = null;
                                                            }
                                                            break label1204;
                                                         }

                                                         this.method1200(field1040, field1041);
                                                      }
                                                   }

                                                   field997 = 10;
                                                   class59.field742 = 0;
                                                   class95.field1513 = null;
                                                } else if(field1044 >= 5 && (class59.field748 > field1040 + 5 || class59.field748 < field1040 - 5 || class59.field749 > field1041 + 5 || class59.field749 < field1041 - 5)) {
                                                   field1043 = true;
                                                }
                                             }

                                             if(Region.method2705()) {
                                                var3 = Region.selectedRegionTileX;
                                                var4 = Region.selectedRegionTileY;
                                                secretPacketBuffer1.putOpcode(96);
                                                secretPacketBuffer1.putByte(5);
                                                secretPacketBuffer1.putShortLE(class50.field659[82]?(class50.field659[81]?2:1):0);
                                                secretPacketBuffer1.putShort(var4 + class266.baseY);
                                                secretPacketBuffer1.putShort(var3 + class50.baseX);
                                                Region.method2832();
                                                field1190 = class59.field747;
                                                field1034 = class59.field756;
                                                cursorState = 1;
                                                field967 = 0;
                                                destinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(var31 != KitDefinition.field3371) {
                                                if(var31 != null) {
                                                   class88.method1714(var31);
                                                }

                                                if(KitDefinition.field3371 != null) {
                                                   class88.method1714(KitDefinition.field3371);
                                                }
                                             }

                                             if(var38 != PendingSpawn.field1211 && field1079 == field1054) {
                                                if(var38 != null) {
                                                   class88.method1714(var38);
                                                }

                                                if(PendingSpawn.field1211 != null) {
                                                   class88.method1714(PendingSpawn.field1211);
                                                }
                                             }

                                             if(PendingSpawn.field1211 != null) {
                                                if(field1054 < field1079) {
                                                   ++field1054;
                                                   if(field1054 == field1079) {
                                                      class88.method1714(PendingSpawn.field1211);
                                                   }
                                                }
                                             } else if(field1054 > 0) {
                                                --field1054;
                                             }

                                             var3 = field1072 + XItemContainer.localPlayer.x;
                                             var4 = field1033 + XItemContainer.localPlayer.y;
                                             if(Ignore.field860 - var3 < -500 || Ignore.field860 - var3 > 500 || class31.field456 - var4 < -500 || class31.field456 - var4 > 500) {
                                                Ignore.field860 = var3;
                                                class31.field456 = var4;
                                             }

                                             if(var3 != Ignore.field860) {
                                                Ignore.field860 += (var3 - Ignore.field860) / 16;
                                             }

                                             if(var4 != class31.field456) {
                                                class31.field456 += (var4 - class31.field456) / 16;
                                             }

                                             if(class59.field754 == 4 && class34.field499) {
                                                var5 = class59.field749 - field1055;
                                                field1195 = var5 * 2;
                                                field1055 = var5 != -1 && var5 != 1?(class59.field749 + field1055) / 2:class59.field749;
                                                var6 = field1013 - class59.field748;
                                                field1148 = var6 * 2;
                                                field1013 = var6 != -1 && var6 != 1?(field1013 + class59.field748) / 2:class59.field748;
                                             } else {
                                                if(class50.field659[96]) {
                                                   field1148 += (-24 - field1148) / 2;
                                                } else if(class50.field659[97]) {
                                                   field1148 += (24 - field1148) / 2;
                                                } else {
                                                   field1148 /= 2;
                                                }

                                                if(class50.field659[98]) {
                                                   field1195 += (12 - field1195) / 2;
                                                } else if(class50.field659[99]) {
                                                   field1195 += (-12 - field1195) / 2;
                                                } else {
                                                   field1195 /= 2;
                                                }

                                                field1055 = class59.field749;
                                                field1013 = class59.field748;
                                             }

                                             mapAngle = field1148 / 2 + mapAngle & 2047;
                                             field1052 += field1195 / 2;
                                             if(field1052 < 128) {
                                                field1052 = 128;
                                             }

                                             if(field1052 > 383) {
                                                field1052 = 383;
                                             }

                                             var5 = Ignore.field860 >> 7;
                                             var6 = class31.field456 >> 7;
                                             var7 = WorldMapData.method343(Ignore.field860, class31.field456, WallObject.plane);
                                             var8 = 0;
                                             if(var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
                                                for(var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
                                                   for(int var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                      int var11 = WallObject.plane;
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

                                             if(var9 > field1018) {
                                                field1018 += (var9 - field1018) / 24;
                                             } else if(var9 < field1018) {
                                                field1018 += (var9 - field1018) / 80;
                                             }

                                             if(field1173) {
                                                class66.method1120();
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field1178[var3];
                                             }

                                             class71.chatMessages.method1833();
                                             var3 = FrameMap.method2662();
                                             var4 = class60.method1047();
                                             if(var3 > 15000 && var4 > 15000) {
                                                field978 = 250;
                                                class83.method1674(14500);
                                                secretPacketBuffer1.putOpcode(224);
                                             }

                                             ++field991;
                                             if(field991 > 500) {
                                                field991 = 0;
                                                var5 = (int)(Math.random() * 8.0D);
                                                if((var5 & 1) == 1) {
                                                   field1072 += field1135;
                                                }

                                                if((var5 & 2) == 2) {
                                                   field1033 += field993;
                                                }

                                                if((var5 & 4) == 4) {
                                                   field951 += field995;
                                                }
                                             }

                                             if(field1072 < -50) {
                                                field1135 = 2;
                                             }

                                             if(field1072 > 50) {
                                                field1135 = -2;
                                             }

                                             if(field1033 < -55) {
                                                field993 = 2;
                                             }

                                             if(field1033 > 55) {
                                                field993 = -2;
                                             }

                                             if(field951 < -40) {
                                                field995 = 1;
                                             }

                                             if(field951 > 40) {
                                                field995 = -1;
                                             }

                                             ++field1001;
                                             if(field1001 > 500) {
                                                field1001 = 0;
                                                var5 = (int)(Math.random() * 8.0D);
                                                if((var5 & 1) == 1) {
                                                   mapScale += mapOffset;
                                                }

                                                if((var5 & 2) == 2) {
                                                   mapScaleDelta += field1000;
                                                }
                                             }

                                             if(mapScale < -60) {
                                                mapOffset = 2;
                                             }

                                             if(mapScale > 60) {
                                                mapOffset = -2;
                                             }

                                             if(mapScaleDelta < -20) {
                                                field1000 = 1;
                                             }

                                             if(mapScaleDelta > 10) {
                                                field1000 = -1;
                                             }

                                             for(class67 var36 = (class67)field1029.method3612(); var36 != null; var36 = (class67)field1029.method3607()) {
                                                if((long)var36.field836 < class172.method3128() / 1000L - 5L) {
                                                   if(var36.field837 > 0) {
                                                      class152.sendGameMessage(5, "", var36.field841 + " has logged in.");
                                                   }

                                                   if(var36.field837 == 0) {
                                                      class152.sendGameMessage(5, "", var36.field841 + " has logged out.");
                                                   }

                                                   var36.method3615();
                                                }
                                             }

                                             ++audioEffectCount;
                                             if(audioEffectCount > 50) {
                                                secretPacketBuffer1.putOpcode(203);
                                             }

                                             try {
                                                if(class244.rssocket != null && secretPacketBuffer1.offset > 0) {
                                                   class244.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
                                                   secretPacketBuffer1.offset = 0;
                                                   audioEffectCount = 0;
                                                }
                                             } catch (IOException var25) {
                                                class13.method60();
                                             }

                                             return;
                                          }

                                          var39 = var35.field849;
                                          if(var39.index < 0) {
                                             break;
                                          }

                                          var33 = PacketBuffer.method3403(var39.parentId);
                                       } while(var33 == null || var33.children == null || var39.index >= var33.children.length || var33.children[var39.index] != var39);

                                       class14.method76(var35);
                                    }
                                 }

                                 var39 = var35.field849;
                                 if(var39.index < 0) {
                                    break;
                                 }

                                 var33 = PacketBuffer.method3403(var39.parentId);
                              } while(var33 == null || var33.children == null || var39.index >= var33.children.length || var33.children[var39.index] != var39);

                              class14.method76(var35);
                           }
                        }

                        var39 = var35.field849;
                        if(var39.index < 0) {
                           break;
                        }

                        var33 = PacketBuffer.method3403(var39.parentId);
                     } while(var33 == null || var33.children == null || var39.index >= var33.children.length || var33.children[var39.index] != var39);

                     class14.method76(var35);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-157536255"
   )
   void method1195() {
      if(class238.field3277 >= 4) {
         this.method933("js5crc");
         gameState = 1000;
      } else {
         if(class238.field3278 >= 4) {
            if(gameState <= 5) {
               this.method933("js5io");
               gameState = 1000;
               return;
            }

            field955 = 3000;
            class238.field3278 = 3;
         }

         if(--field955 + 1 <= 0) {
            try {
               if(field954 == 0) {
                  class89.field1430 = GameEngine.field720.method2926(class172.host, class96.field1530);
                  ++field954;
               }

               if(field954 == 1) {
                  if(class89.field1430.status == 2) {
                     this.method1192(-1);
                     return;
                  }

                  if(class89.field1430.status == 1) {
                     ++field954;
                  }
               }

               if(field954 == 2) {
                  FileOnDisk.rssocket = new RSSocket((Socket)class89.field1430.field2239, GameEngine.field720);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(148);
                  FileOnDisk.rssocket.queueForWrite(var1.payload, 0, 5);
                  ++field954;
                  class12.field272 = class172.method3128();
               }

               if(field954 == 3) {
                  if(gameState > 5 && FileOnDisk.rssocket.available() <= 0) {
                     if(class172.method3128() - class12.field272 > 30000L) {
                        this.method1192(-2);
                        return;
                     }
                  } else {
                     int var5 = FileOnDisk.rssocket.readByte();
                     if(var5 != 0) {
                        this.method1192(var5);
                        return;
                     }

                     ++field954;
                  }
               }

               if(field954 == 4) {
                  RSSocket var10 = FileOnDisk.rssocket;
                  boolean var2 = gameState > 20;
                  if(class238.field3272 != null) {
                     try {
                        class238.field3272.close();
                     } catch (Exception var8) {
                        ;
                     }

                     class238.field3272 = null;
                  }

                  class238.field3272 = var10;
                  class170.method3115(var2);
                  class238.field3264.offset = 0;
                  class7.field237 = null;
                  class39.field559 = null;
                  class238.field3273 = 0;

                  while(true) {
                     class234 var3 = (class234)class238.field3275.method3533();
                     if(var3 == null) {
                        while(true) {
                           var3 = (class234)class238.field3270.method3533();
                           if(var3 == null) {
                              if(class238.field3276 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.putByte(4);
                                    var11.putByte(class238.field3276);
                                    var11.putShort(0);
                                    class238.field3272.queueForWrite(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class238.field3272.close();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class238.field3278;
                                    class238.field3272 = null;
                                 }
                              }

                              class238.field3261 = 0;
                              class238.field3263 = class172.method3128();
                              class89.field1430 = null;
                              FileOnDisk.rssocket = null;
                              field954 = 0;
                              field956 = 0;
                              return;
                           }

                           class238.field3267.method3467(var3);
                           class238.field3268.method3529(var3, var3.hash);
                           ++class238.field3269;
                           --class238.field3271;
                        }
                     }

                     class238.field3260.method3529(var3, var3.hash);
                     ++class238.field3266;
                     --class238.field3265;
                  }
               }
            } catch (IOException var9) {
               this.method1192(-3);
            }

         }
      }
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1407266445"
   )
   void method1196() {
      int var1 = class45.canvasWidth;
      int var2 = CollisionData.canvasHeight;
      if(super.field728 < var1) {
         var1 = super.field728;
      }

      if(super.field726 < var2) {
         var2 = super.field726;
      }

      if(class8.field247 != null) {
         try {
            Client var3 = class261.field3632;
            int var4 = isResized?2:1;
            class52.method796(var3, "resize", new Object[]{Integer.valueOf(var4)});
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-120"
   )
   final void method1197() {
      int var1;
      if(widgetRoot != -1) {
         var1 = widgetRoot;
         if(class66.method1121(var1)) {
            class20.method141(class46.widgets[var1], -1);
         }
      }

      for(var1 = 0; var1 < field1061; ++var1) {
         if(field1132[var1]) {
            field1133[var1] = true;
         }

         field1030[var1] = field1132[var1];
         field1132[var1] = false;
      }

      field1131 = gameCycle;
      field1076 = -1;
      field1003 = -1;
      FaceNormal.field2155 = null;
      if(widgetRoot != -1) {
         field1061 = 0;
         Signlink.drawWidget(widgetRoot, 0, 0, class45.canvasWidth, CollisionData.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.method4923();
      if(!isMenuOpen) {
         if(field1076 != -1) {
            var1 = field1076;
            int var2 = field1003;
            if(menuOptionCount >= 2 || itemSelectionState != 0 || field1082) {
               int var3 = class2.method7();
               String var4;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var4 = "Use" + " " + selectedItemName + " " + "->";
               } else if(field1082 && menuOptionCount < 2) {
                  var4 = field1078 + " " + field1159 + " " + "->";
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
                  var4 = var4 + class220.method4055(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               World.field1322.drawRandomizedMouseoverText(var4, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         class286.method5141();
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < field1061; ++var1) {
            if(field1030[var1]) {
               Rasterizer2D.method4931(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1133[var1]) {
               Rasterizer2D.method4931(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      class5.method20(WallObject.plane, XItemContainer.localPlayer.x, XItemContainer.localPlayer.y, field1002);
      field1002 = 0;
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1199022522"
   )
   @Export("processServerPacket")
   final boolean processServerPacket() {
      if(class244.rssocket == null) {
         return false;
      } else {
         String var19;
         int var20;
         try {
            int var1 = class244.rssocket.available();
            if(var1 == 0) {
               return false;
            }

            if(packetType == -1) {
               class244.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               packetLength = class272.field3709[packetType];
               --var1;
            }

            if(packetLength == -1) {
               if(var1 <= 0) {
                  return false;
               }

               class244.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               packetLength = secretPacketBuffer2.payload[0] & 255;
               --var1;
            }

            if(packetLength == -2) {
               if(var1 <= 1) {
                  return false;
               }

               class244.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();
               var1 -= 2;
            }

            if(var1 < packetLength) {
               return false;
            }

            secretPacketBuffer2.offset = 0;
            class244.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
            field973 = 0;
            field977 = field976;
            field976 = field964 * -1;
            field964 = packetType * -1;
            int var2;
            if(packetType == 51) {
               field1173 = false;

               for(var2 = 0; var2 < 5; ++var2) {
                  field1174[var2] = false;
               }

               packetType = -1;
               return true;
            }

            Widget var63;
            if(packetType == 136) {
               var2 = secretPacketBuffer2.method3190();
               var63 = PacketBuffer.method3403(var2);
               var63.modelType = 3;
               var63.modelId = XItemContainer.localPlayer.composition.method3938();
               class88.method1714(var63);
               packetType = -1;
               return true;
            }

            int var6;
            int var7;
            int var8;
            boolean var62;
            boolean var67;
            if(packetType == 228) {
               var19 = secretPacketBuffer2.readString();
               var20 = secretPacketBuffer2.readUnsignedShort();
               byte var70 = secretPacketBuffer2.readByte();
               var62 = false;
               if(var70 == -128) {
                  var62 = true;
               }

               if(var62) {
                  if(class28.clanChatCount == 0) {
                     packetType = -1;
                     return true;
                  }

                  var67 = false;

                  for(var6 = 0; var6 < class28.clanChatCount && (!class11.clanMembers[var6].username.equals(var19) || var20 != class11.clanMembers[var6].world); ++var6) {
                     ;
                  }

                  if(var6 < class28.clanChatCount) {
                     while(var6 < class28.clanChatCount - 1) {
                        class11.clanMembers[var6] = class11.clanMembers[var6 + 1];
                        ++var6;
                     }

                     --class28.clanChatCount;
                     class11.clanMembers[class28.clanChatCount] = null;
                  }
               } else {
                  secretPacketBuffer2.readString();
                  XClanMember var86 = new XClanMember();
                  var86.username = var19;
                  var86.field919 = Player.method1179(var86.username, field928);
                  var86.world = var20;
                  var86.rank = var70;

                  for(var7 = class28.clanChatCount - 1; var7 >= 0; --var7) {
                     var8 = class11.clanMembers[var7].field919.compareTo(var86.field919);
                     if(var8 == 0) {
                        class11.clanMembers[var7].world = var20;
                        class11.clanMembers[var7].rank = var70;
                        if(var19.equals(XItemContainer.localPlayer.name)) {
                           class35.clanChatRank = var70;
                        }

                        field1121 = field1112;
                        packetType = -1;
                        return true;
                     }

                     if(var8 < 0) {
                        break;
                     }
                  }

                  if(class28.clanChatCount >= class11.clanMembers.length) {
                     packetType = -1;
                     return true;
                  }

                  for(var8 = class28.clanChatCount - 1; var8 > var7; --var8) {
                     class11.clanMembers[var8 + 1] = class11.clanMembers[var8];
                  }

                  if(class28.clanChatCount == 0) {
                     class11.clanMembers = new XClanMember[100];
                  }

                  class11.clanMembers[var7 + 1] = var86;
                  ++class28.clanChatCount;
                  if(var19.equals(XItemContainer.localPlayer.name)) {
                     class35.clanChatRank = var70;
                  }
               }

               field1121 = field1112;
               packetType = -1;
               return true;
            }

            if(packetType == 118) {
               for(var2 = 0; var2 < class211.widgetSettings.length; ++var2) {
                  if(class211.widgetSettings[var2] != class211.settings[var2]) {
                     class211.widgetSettings[var2] = class211.settings[var2];
                     Preferences.method1614(var2);
                     field1113[++field975 - 1 & 31] = var2;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 64) {
               field1173 = true;
               field1208 = secretPacketBuffer2.readUnsignedByte();
               class207.field2591 = secretPacketBuffer2.readUnsignedByte();
               class95.field1515 = secretPacketBuffer2.readUnsignedShort();
               class34.field500 = secretPacketBuffer2.readUnsignedByte();
               class31.field457 = secretPacketBuffer2.readUnsignedByte();
               if(class31.field457 >= 100) {
                  class155.cameraX = field1208 * 128 + 64;
                  class157.cameraY = class207.field2591 * 128 + 64;
                  class60.cameraZ = WorldMapData.method343(class155.cameraX, class157.cameraY, WallObject.plane) - class95.field1515;
               }

               packetType = -1;
               return true;
            }

            int var4;
            int var5;
            if(packetType == 200) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               var20 = secretPacketBuffer2.readUnsignedByte();
               var4 = secretPacketBuffer2.readUnsignedByte();
               var5 = secretPacketBuffer2.readUnsignedByte();
               field1174[var2] = true;
               field1164[var2] = var20;
               field996[var2] = var4;
               field1177[var2] = var5;
               field1178[var2] = 0;
               packetType = -1;
               return true;
            }

            Widget var84;
            if(packetType == 106) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               var20 = secretPacketBuffer2.readInt();
               var4 = secretPacketBuffer2.readUnsignedShortOb1();
               var5 = secretPacketBuffer2.method3318();
               var84 = PacketBuffer.method3403(var20);
               if(var84.rotationX != var2 || var84.rotationZ != var4 || var84.field2650 != var5) {
                  var84.rotationX = var2;
                  var84.rotationZ = var4;
                  var84.field2650 = var5;
                  class88.method1714(var84);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 67) {
               var19 = secretPacketBuffer2.readString();
               Object[] var66 = new Object[var19.length() + 1];

               for(var4 = var19.length() - 1; var4 >= 0; --var4) {
                  if(var19.charAt(var4) == 115) {
                     var66[var4 + 1] = secretPacketBuffer2.readString();
                  } else {
                     var66[var4 + 1] = new Integer(secretPacketBuffer2.readInt());
                  }
               }

               var66[0] = new Integer(secretPacketBuffer2.readInt());
               class69 var106 = new class69();
               var106.field857 = var66;
               class14.method76(var106);
               packetType = -1;
               return true;
            }

            if(packetType == 41) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               var20 = secretPacketBuffer2.readUnsignedByte();
               var4 = secretPacketBuffer2.readUnsignedShort();
               class34.method356(var2, var20, var4);
               packetType = -1;
               return true;
            }

            if(packetType == 245) {
               method1525();

               for(var2 = 0; var2 < 2048; ++var2) {
                  cachedPlayers[var2] = null;
               }

               class17.method119(secretPacketBuffer2);
               packetType = -1;
               return true;
            }

            if(packetType == 174) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               if(secretPacketBuffer2.readUnsignedByte() == 0) {
                  grandExchangeOffers[var2] = new XGrandExchangeOffer();
                  secretPacketBuffer2.offset += 18;
               } else {
                  --secretPacketBuffer2.offset;
                  grandExchangeOffers[var2] = new XGrandExchangeOffer(secretPacketBuffer2, false);
               }

               field1110 = field1112;
               packetType = -1;
               return true;
            }

            if(packetType == 229) {
               field1173 = true;
               class66.field832 = secretPacketBuffer2.readUnsignedByte();
               ISAACCipher.field2438 = secretPacketBuffer2.readUnsignedByte();
               IndexFile.field2289 = secretPacketBuffer2.readUnsignedShort();
               class174.field2414 = secretPacketBuffer2.readUnsignedByte();
               class151.field2223 = secretPacketBuffer2.readUnsignedByte();
               if(class151.field2223 >= 100) {
                  var2 = class66.field832 * 128 + 64;
                  var20 = ISAACCipher.field2438 * 128 + 64;
                  var4 = WorldMapData.method343(var2, var20, WallObject.plane) - IndexFile.field2289;
                  var5 = var2 - class155.cameraX;
                  var6 = var4 - class60.cameraZ;
                  var7 = var20 - class157.cameraY;
                  var8 = (int)Math.sqrt((double)(var5 * var5 + var7 * var7));
                  Player.cameraPitch = (int)(Math.atan2((double)var6, (double)var8) * 325.949D) & 2047;
                  class22.cameraYaw = (int)(Math.atan2((double)var5, (double)var7) * -325.949D) & 2047;
                  if(Player.cameraPitch < 128) {
                     Player.cameraPitch = 128;
                  }

                  if(Player.cameraPitch > 383) {
                     Player.cameraPitch = 383;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 145) {
               class29.field428 = secretPacketBuffer2.method3324();
               Player.field900 = secretPacketBuffer2.readUnsignedByte();

               for(var2 = Player.field900; var2 < Player.field900 + 8; ++var2) {
                  for(var20 = class29.field428; var20 < class29.field428 + 8; ++var20) {
                     if(groundItemDeque[WallObject.plane][var2][var20] != null) {
                        groundItemDeque[WallObject.plane][var2][var20] = null;
                        class146.groundItemSpawned(var2, var20);
                     }
                  }
               }

               for(PendingSpawn var81 = (PendingSpawn)pendingSpawns.method3584(); var81 != null; var81 = (PendingSpawn)pendingSpawns.method3578()) {
                  if(var81.x >= Player.field900 && var81.x < Player.field900 + 8 && var81.y >= class29.field428 && var81.y < class29.field428 + 8 && var81.level == WallObject.plane) {
                     var81.hitpoints = 0;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 29) {
               class69.method1135();
               energy = secretPacketBuffer2.readUnsignedByte();
               field1124 = field1112;
               packetType = -1;
               return true;
            }

            boolean var65;
            if(packetType == 95) {
               var65 = secretPacketBuffer2.readUnsignedByte() == 1;
               if(var65) {
                  class43.field599 = class172.method3128() - secretPacketBuffer2.readLong();
                  class66.field833 = new class13(secretPacketBuffer2, true);
               } else {
                  class66.field833 = null;
               }

               field1004 = field1112;
               packetType = -1;
               return true;
            }

            if(packetType == 27) {
               field1193 = 1;
               field1025 = field1112;
               packetType = -1;
               return true;
            }

            if(packetType == 184) {
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

            String var59;
            if(packetType == 21) {
               var2 = secretPacketBuffer2.method3173();
               var59 = secretPacketBuffer2.readString();
               var4 = secretPacketBuffer2.readUnsignedByte();
               if(var4 >= 1 && var4 <= 8) {
                  if(var59.equalsIgnoreCase("null")) {
                     var59 = null;
                  }

                  playerOptions[var4 - 1] = var59;
                  playerOptionsPriorities[var4 - 1] = var2 == 0;
               }

               packetType = -1;
               return true;
            }

            Widget var22;
            if(packetType == 201) {
               var2 = secretPacketBuffer2.readIntOb3();
               var20 = secretPacketBuffer2.method3318();
               var22 = PacketBuffer.method3403(var2);
               if(var22.modelType != 2 || var20 != var22.modelId) {
                  var22.modelType = 2;
                  var22.modelId = var20;
                  class88.method1714(var22);
               }

               packetType = -1;
               return true;
            }

            Widget var94;
            if(packetType == 151) {
               var2 = secretPacketBuffer2.readUnsignedShortOb1();
               var20 = secretPacketBuffer2.method3190();
               var4 = secretPacketBuffer2.method3318();
               var94 = PacketBuffer.method3403(var20);
               var94.field2710 = var4 + (var2 << 16);
               packetType = -1;
               return true;
            }

            if(packetType == 141) {
               var2 = secretPacketBuffer2.readShortOb3();
               var20 = secretPacketBuffer2.readShortOb3();
               var4 = secretPacketBuffer2.readInt();
               var94 = PacketBuffer.method3403(var4);
               if(var94.originalX != var2 || var20 != var94.originalY || var94.field2659 != 0 || var94.field2660 != 0) {
                  var94.originalX = var2;
                  var94.originalY = var20;
                  var94.field2659 = 0;
                  var94.field2660 = 0;
                  class88.method1714(var94);
                  this.method1343(var94);
                  if(var94.type == 0) {
                     WorldMapType2.method546(class46.widgets[var4 >> 16], var94, false);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 111) {
               var19 = secretPacketBuffer2.readString();
               var20 = secretPacketBuffer2.method3190();
               var22 = PacketBuffer.method3403(var20);
               if(!var19.equals(var22.text)) {
                  var22.text = var19;
                  class88.method1714(var22);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 195) {
               var2 = secretPacketBuffer2.method3190();
               class20.field339 = GameEngine.field720.method2930(var2);
               packetType = -1;
               return true;
            }

            if(packetType == 107) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               XItemContainer var64 = (XItemContainer)XItemContainer.itemContainers.method3530((long)var2);
               if(var64 != null) {
                  var64.unlink();
               }

               interfaceItemTriggers[++field1116 - 1 & 31] = var2 & 32767;
               packetType = -1;
               return true;
            }

            if(packetType == 114) {
               class29.field428 = secretPacketBuffer2.readUnsignedByte();
               Player.field900 = secretPacketBuffer2.method3324();

               while(secretPacketBuffer2.offset < packetLength) {
                  packetType = secretPacketBuffer2.readUnsignedByte();
                  Actor.method1557();
               }

               packetType = -1;
               return true;
            }

            int var9;
            long var10;
            WidgetNode var96;
            if(packetType == 17) {
               var2 = packetLength + secretPacketBuffer2.offset;
               var20 = secretPacketBuffer2.readUnsignedShort();
               var4 = secretPacketBuffer2.readUnsignedShort();
               if(var20 != widgetRoot) {
                  widgetRoot = var20;
                  this.method1201(false);
                  class222.method4070(widgetRoot);
                  Ignore.method1136(widgetRoot);

                  for(var5 = 0; var5 < 100; ++var5) {
                     field1132[var5] = true;
                  }
               }

               WidgetNode var92;
               for(; var4-- > 0; var92.field845 = true) {
                  var5 = secretPacketBuffer2.readInt();
                  var6 = secretPacketBuffer2.readUnsignedShort();
                  var7 = secretPacketBuffer2.readUnsignedByte();
                  var92 = (WidgetNode)componentTable.method3530((long)var5);
                  if(var92 != null && var92.id != var6) {
                     class95.method1780(var92, true);
                     var92 = null;
                  }

                  if(var92 == null) {
                     var92 = class29.method233(var5, var6, var7);
                  }
               }

               for(var96 = (WidgetNode)componentTable.method3533(); var96 != null; var96 = (WidgetNode)componentTable.method3538()) {
                  if(var96.field845) {
                     var96.field845 = false;
                  } else {
                     class95.method1780(var96, true);
                  }
               }

               widgetFlags = new XHashTable(512);

               while(secretPacketBuffer2.offset < var2) {
                  var5 = secretPacketBuffer2.readInt();
                  var6 = secretPacketBuffer2.readUnsignedShort();
                  var7 = secretPacketBuffer2.readUnsignedShort();
                  var8 = secretPacketBuffer2.readInt();

                  for(var9 = var6; var9 <= var7; ++var9) {
                     var10 = (long)var9 + ((long)var5 << 32);
                     widgetFlags.method3529(new class198(var8), var10);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 25) {
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

            if(packetType == 40) {
               var2 = secretPacketBuffer2.method3190();
               var20 = secretPacketBuffer2.method3190();
               WidgetNode var102 = (WidgetNode)componentTable.method3530((long)var20);
               var96 = (WidgetNode)componentTable.method3530((long)var2);
               if(var96 != null) {
                  class95.method1780(var96, var102 == null || var96.id != var102.id);
               }

               if(var102 != null) {
                  var102.unlink();
                  componentTable.method3529(var102, (long)var2);
               }

               var84 = PacketBuffer.method3403(var20);
               if(var84 != null) {
                  class88.method1714(var84);
               }

               var84 = PacketBuffer.method3403(var2);
               if(var84 != null) {
                  class88.method1714(var84);
                  WorldMapType2.method546(class46.widgets[var84.id >>> 16], var84, true);
               }

               if(widgetRoot != -1) {
                  var7 = widgetRoot;
                  if(class66.method1121(var7)) {
                     class5.method22(class46.widgets[var7], 1);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 15) {
               secretPacketBuffer2.offset += 28;
               if(secretPacketBuffer2.method3168()) {
                  class39.method556(secretPacketBuffer2, secretPacketBuffer2.offset - 28);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 251) {
               Player.field900 = secretPacketBuffer2.readUnsignedByte();
               class29.field428 = secretPacketBuffer2.method3173();
               packetType = -1;
               return true;
            }

            int var11;
            int var14;
            long var25;
            long var27;
            long var30;
            if(packetType == 163) {
               var19 = secretPacketBuffer2.readString();
               var25 = (long)secretPacketBuffer2.readUnsignedShort();
               var27 = (long)secretPacketBuffer2.read24BitInt();
               class230 var107 = (class230)class134.method2577(Widget.method4032(), secretPacketBuffer2.readUnsignedByte());
               var30 = (var25 << 32) + var27;
               boolean var108 = false;

               for(var11 = 0; var11 < 100; ++var11) {
                  if(field1146[var11] == var30) {
                     var108 = true;
                     break;
                  }
               }

               if(class1.method2(var19)) {
                  var108 = true;
               }

               if(!var108 && field1045 == 0) {
                  field1146[field1147] = var30;
                  field1147 = (field1147 + 1) % 100;
                  PacketBuffer var12 = secretPacketBuffer2;

                  String var72;
                  try {
                     var14 = var12.method3159();
                     if(var14 > 32767) {
                        var14 = 32767;
                     }

                     byte[] var74 = new byte[var14];
                     var12.offset += class265.field3665.method3062(var12.payload, var12.offset, var74, 0, var14);
                     String var16 = class48.method755(var74, 0, var14);
                     var72 = var16;
                  } catch (Exception var55) {
                     var72 = "Cabbage";
                  }

                  var72 = FontTypeFace.method4835(FaceNormal.method2870(var72));
                  byte var73;
                  if(var107.field3184) {
                     var73 = 7;
                  } else {
                     var73 = 3;
                  }

                  if(var107.field3186 != -1) {
                     class152.sendGameMessage(var73, class41.method609(var107.field3186) + var19, var72);
                  } else {
                     class152.sendGameMessage(var73, var19, var72);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 235) {
               byte var71 = secretPacketBuffer2.method3207();
               var20 = secretPacketBuffer2.method3318();
               class211.settings[var20] = var71;
               if(var71 != class211.widgetSettings[var20]) {
                  class211.widgetSettings[var20] = var71;
               }

               Preferences.method1614(var20);
               field1113[++field975 - 1 & 31] = var20;
               packetType = -1;
               return true;
            }

            if(packetType == 105) {
               var2 = secretPacketBuffer2.readUnsignedShortOb1();
               var20 = secretPacketBuffer2.readIntOb3();
               class211.settings[var2] = var20;
               if(var20 != class211.widgetSettings[var2]) {
                  class211.widgetSettings[var2] = var20;
               }

               Preferences.method1614(var2);
               field1113[++field975 - 1 & 31] = var2;
               packetType = -1;
               return true;
            }

            if(packetType == 79) {
               field943 = secretPacketBuffer2.readUnsignedByte();
               if(field943 == 1) {
                  field944 = secretPacketBuffer2.readUnsignedShort();
               }

               if(field943 >= 2 && field943 <= 6) {
                  if(field943 == 2) {
                     field980 = 64;
                     field950 = 64;
                  }

                  if(field943 == 3) {
                     field980 = 0;
                     field950 = 64;
                  }

                  if(field943 == 4) {
                     field980 = 128;
                     field950 = 64;
                  }

                  if(field943 == 5) {
                     field980 = 64;
                     field950 = 0;
                  }

                  if(field943 == 6) {
                     field980 = 64;
                     field950 = 128;
                  }

                  field943 = 2;
                  hintArrowX = secretPacketBuffer2.readUnsignedShort();
                  hintArrowY = secretPacketBuffer2.readUnsignedShort();
                  hintArrowType = secretPacketBuffer2.readUnsignedByte();
               }

               if(field943 == 10) {
                  field1183 = secretPacketBuffer2.readUnsignedShort();
               }

               packetType = -1;
               return true;
            }

            if(packetType == 98) {
               field1143 = secretPacketBuffer2.readUnsignedByte();
               field1032 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == 56 || packetType == 58 || packetType == 202 || packetType == 82 || packetType == 63 || packetType == 92 || packetType == 97 || packetType == 44 || packetType == 194 || packetType == 215) {
               Actor.method1557();
               packetType = -1;
               return true;
            }

            if(packetType == 28) {
               var2 = secretPacketBuffer2.method3175();
               var63 = PacketBuffer.method3403(var2);

               for(var4 = 0; var4 < var63.itemIds.length; ++var4) {
                  var63.itemIds[var4] = -1;
                  var63.itemIds[var4] = 0;
               }

               class88.method1714(var63);
               packetType = -1;
               return true;
            }

            if(packetType == 72) {
               class69.method1135();
               var2 = secretPacketBuffer2.readInt();
               var20 = secretPacketBuffer2.readUnsignedByte();
               var4 = secretPacketBuffer2.method3173();
               skillExperiences[var20] = var2;
               boostedSkillLevels[var20] = var4;
               realSkillLevels[var20] = 1;

               for(var5 = 0; var5 < 98; ++var5) {
                  if(var2 >= class222.field2845[var5]) {
                     realSkillLevels[var20] = var5 + 2;
                  }
               }

               field1117[++field1067 - 1 & 31] = var20;
               packetType = -1;
               return true;
            }

            long var34;
            if(packetType == 196) {
               var2 = secretPacketBuffer2.readInt();
               var20 = secretPacketBuffer2.readInt();
               if(class39.field558 == null || !class39.field558.isValid()) {
                  try {
                     Iterator var100 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var100.hasNext()) {
                        GarbageCollectorMXBean var97 = (GarbageCollectorMXBean)var100.next();
                        if(var97.isValid()) {
                           class39.field558 = var97;
                           field1203 = -1L;
                           field1120 = -1L;
                        }
                     }
                  } catch (Throwable var56) {
                     ;
                  }
               }

               long var39 = class172.method3128();
               var6 = -1;
               if(class39.field558 != null) {
                  var34 = class39.field558.getCollectionTime();
                  if(-1L != field1120) {
                     long var41 = var34 - field1120;
                     long var45 = var39 - field1203;
                     if(0L != var45) {
                        var6 = (int)(100L * var41 / var45);
                     }
                  }

                  field1120 = var34;
                  field1203 = var39;
               }

               secretPacketBuffer1.putOpcode(174);
               secretPacketBuffer1.method3265(var6);
               secretPacketBuffer1.putInt(var2);
               secretPacketBuffer1.method3233(var20);
               secretPacketBuffer1.method3265(GameEngine.FPS);
               packetType = -1;
               return true;
            }

            int var38;
            int var44;
            boolean var110;
            if(packetType == 238) {
               var19 = secretPacketBuffer2.readString();
               var25 = secretPacketBuffer2.readLong();
               var27 = (long)secretPacketBuffer2.readUnsignedShort();
               var34 = (long)secretPacketBuffer2.read24BitInt();
               class230 var109 = (class230)class134.method2577(Widget.method4032(), secretPacketBuffer2.readUnsignedByte());
               var10 = var34 + (var27 << 32);
               var110 = false;

               for(var38 = 0; var38 < 100; ++var38) {
                  if(field1146[var38] == var10) {
                     var110 = true;
                     break;
                  }
               }

               if(var109.field3188 && class1.method2(var19)) {
                  var110 = true;
               }

               if(!var110 && field1045 == 0) {
                  field1146[field1147] = var10;
                  field1147 = (field1147 + 1) % 100;
                  PacketBuffer var43 = secretPacketBuffer2;

                  String var15;
                  try {
                     var44 = var43.method3159();
                     if(var44 > 32767) {
                        var44 = 32767;
                     }

                     byte[] var17 = new byte[var44];
                     var43.offset += class265.field3665.method3062(var43.payload, var43.offset, var17, 0, var44);
                     String var18 = class48.method755(var17, 0, var44);
                     var15 = var18;
                  } catch (Exception var54) {
                     var15 = "Cabbage";
                  }

                  var15 = FontTypeFace.method4835(FaceNormal.method2870(var15));
                  if(var109.field3186 != -1) {
                     WorldMapData.addChatMessage(9, class41.method609(var109.field3186) + var19, var15, class56.method850(var25));
                  } else {
                     WorldMapData.addChatMessage(9, var19, var15, class56.method850(var25));
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 119) {
               var2 = secretPacketBuffer2.readInt();
               var20 = secretPacketBuffer2.readByteOb1();
               var4 = var20 >> 10 & 31;
               var5 = var20 >> 5 & 31;
               var6 = var20 & 31;
               var7 = (var5 << 11) + (var4 << 19) + (var6 << 3);
               Widget var90 = PacketBuffer.method3403(var2);
               if(var90.textColor != var7) {
                  var90.textColor = var7;
                  class88.method1714(var90);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 220) {
               var2 = secretPacketBuffer2.readInt();
               var20 = secretPacketBuffer2.readUnsignedShort();
               if(var2 < -70000) {
                  var20 += '耀';
               }

               if(var2 >= 0) {
                  var22 = PacketBuffer.method3403(var2);
               } else {
                  var22 = null;
               }

               for(; secretPacketBuffer2.offset < packetLength; PendingSpawn.method1528(var20, var5, var6 - 1, var7)) {
                  var5 = secretPacketBuffer2.method3159();
                  var6 = secretPacketBuffer2.readUnsignedShort();
                  var7 = 0;
                  if(var6 != 0) {
                     var7 = secretPacketBuffer2.readUnsignedByte();
                     if(var7 == 255) {
                        var7 = secretPacketBuffer2.readInt();
                     }
                  }

                  if(var22 != null && var5 >= 0 && var5 < var22.itemIds.length) {
                     var22.itemIds[var5] = var6;
                     var22.itemQuantities[var5] = var7;
                  }
               }

               if(var22 != null) {
                  class88.method1714(var22);
               }

               class69.method1135();
               interfaceItemTriggers[++field1116 - 1 & 31] = var20 & 32767;
               packetType = -1;
               return true;
            }

            String var23;
            if(packetType == 30) {
               var19 = secretPacketBuffer2.readString();
               PacketBuffer var98 = secretPacketBuffer2;

               try {
                  var6 = var98.method3159();
                  if(var6 > 32767) {
                     var6 = 32767;
                  }

                  byte[] var105 = new byte[var6];
                  var98.offset += class265.field3665.method3062(var98.payload, var98.offset, var105, 0, var6);
                  String var87 = class48.method755(var105, 0, var6);
                  var23 = var87;
               } catch (Exception var53) {
                  var23 = "Cabbage";
               }

               var23 = FontTypeFace.method4835(FaceNormal.method2870(var23));
               class152.sendGameMessage(6, var19, var23);
               packetType = -1;
               return true;
            }

            if(packetType == 159) {
               var2 = secretPacketBuffer2.method3318();
               var20 = secretPacketBuffer2.readIntOb3();
               var4 = secretPacketBuffer2.method3173();
               var96 = (WidgetNode)componentTable.method3530((long)var20);
               if(var96 != null) {
                  class95.method1780(var96, var96.id != var2);
               }

               class29.method233(var20, var2, var4);
               packetType = -1;
               return true;
            }

            if(packetType == 214) {
               class239.method4268(secretPacketBuffer2, packetLength);
               packetType = -1;
               return true;
            }

            PacketBuffer var3;
            if(packetType == 166) {
               class1.xteaChanged(true);
               secretPacketBuffer2.readOpcode();
               var2 = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2;
               var4 = var3.offset;
               class96.field1525 = 0;
               class90.method1722(var3);
               Preferences.updatePlayersFlag(var3);
               if(var2 != var3.offset - var4) {
                  throw new RuntimeException(var3.offset - var4 + " " + var2);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 7) {
               if(widgetRoot != -1) {
                  var2 = widgetRoot;
                  if(class66.method1121(var2)) {
                     class5.method22(class46.widgets[var2], 0);
                  }
               }

               packetType = -1;
               return true;
            }

            String var83;
            boolean var95;
            if(packetType == 182) {
               while(secretPacketBuffer2.offset < packetLength) {
                  var2 = secretPacketBuffer2.readUnsignedByte();
                  var95 = (var2 & 1) == 1;
                  var83 = secretPacketBuffer2.readString();
                  var23 = secretPacketBuffer2.readString();
                  secretPacketBuffer2.readString();

                  for(var6 = 0; var6 < ignoreCount; ++var6) {
                     Ignore var104 = ignores[var6];
                     if(var95) {
                        if(var23.equals(var104.name)) {
                           var104.name = var83;
                           var104.previousName = var23;
                           var83 = null;
                           break;
                        }
                     } else if(var83.equals(var104.name)) {
                        var104.name = var83;
                        var104.previousName = var23;
                        var83 = null;
                        break;
                     }
                  }

                  if(var83 != null && ignoreCount < 400) {
                     Ignore var82 = new Ignore();
                     ignores[ignoreCount] = var82;
                     var82.name = var83;
                     var82.previousName = var23;
                     ++ignoreCount;
                  }
               }

               field1025 = field1112;
               packetType = -1;
               return true;
            }

            if(packetType == 134) {
               var2 = secretPacketBuffer2.readIntOb3();
               var20 = secretPacketBuffer2.readShort();
               var22 = PacketBuffer.method3403(var2);
               if(var20 != var22.field2717 || var20 == -1) {
                  var22.field2717 = var20;
                  var22.field2788 = 0;
                  var22.field2777 = 0;
                  class88.method1714(var22);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 96) {
               PacketBuffer var77 = secretPacketBuffer2;
               var20 = packetLength;
               var4 = var77.offset;
               class96.field1525 = 0;
               class90.method1722(var77);
               Preferences.updatePlayersFlag(var77);
               if(var20 != var77.offset - var4) {
                  throw new RuntimeException(var77.offset - var4 + " " + var20);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 14) {
               var2 = secretPacketBuffer2.readIntOb3();
               var20 = secretPacketBuffer2.method3190();
               var4 = secretPacketBuffer2.readUnsignedShort();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               var94 = PacketBuffer.method3403(var2);
               ItemComposition var80;
               if(!var94.hasScript) {
                  if(var4 == -1) {
                     var94.modelType = 0;
                     packetType = -1;
                     return true;
                  }

                  var80 = class176.getItemDefinition(var4);
                  var94.modelType = 4;
                  var94.modelId = var4;
                  var94.rotationX = var80.xan2d;
                  var94.rotationZ = var80.yan2d;
                  var94.field2650 = var80.zoom2d * 100 / var20;
                  class88.method1714(var94);
               } else {
                  var94.itemId = var4;
                  var94.itemQuantity = var20;
                  var80 = class176.getItemDefinition(var4);
                  var94.rotationX = var80.xan2d;
                  var94.rotationZ = var80.yan2d;
                  var94.rotationY = var80.zan2d;
                  var94.field2703 = var80.offsetX2d;
                  var94.field2704 = var80.offsetY2d;
                  var94.field2650 = var80.zoom2d;
                  if(var80.isStackable == 1) {
                     var94.field2784 = 1;
                  } else {
                     var94.field2784 = 2;
                  }

                  if(var94.field2709 > 0) {
                     var94.field2650 = var94.field2650 * 32 / var94.field2709;
                  } else if(var94.originalWidth > 0) {
                     var94.field2650 = var94.field2650 * 32 / var94.originalWidth;
                  }

                  class88.method1714(var94);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 24) {
               var2 = secretPacketBuffer2.readIntOb3();
               var20 = secretPacketBuffer2.readByteOb1();
               var22 = PacketBuffer.method3403(var2);
               if(var22.modelType != 1 || var20 != var22.modelId) {
                  var22.modelType = 1;
                  var22.modelId = var20;
                  class88.method1714(var22);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 218) {
               World var76 = new World();
               var76.address = secretPacketBuffer2.readString();
               var76.id = secretPacketBuffer2.readUnsignedShort();
               var20 = secretPacketBuffer2.readInt();
               var76.mask = var20;
               TextureProvider.setGameState(45);
               class244.rssocket.close();
               class244.rssocket = null;
               class89.method1719(var76);
               packetType = -1;
               return false;
            }

            if(packetType == 139) {
               PlayerComposition.method3933(false);
               packetType = -1;
               return true;
            }

            if(packetType == 227) {
               PlayerComposition.method3933(true);
               packetType = -1;
               return true;
            }

            if(packetType == 225) {
               var2 = secretPacketBuffer2.method3190();
               var95 = secretPacketBuffer2.method3173() == 1;
               var22 = PacketBuffer.method3403(var2);
               if(var95 != var22.isHidden) {
                  var22.isHidden = var95;
                  class88.method1714(var22);
               }

               packetType = -1;
               return true;
            }

            int var32;
            if(packetType == 52) {
               while(secretPacketBuffer2.offset < packetLength) {
                  var65 = secretPacketBuffer2.readUnsignedByte() == 1;
                  var59 = secretPacketBuffer2.readString();
                  var83 = secretPacketBuffer2.readString();
                  var5 = secretPacketBuffer2.readUnsignedShort();
                  var6 = secretPacketBuffer2.readUnsignedByte();
                  var7 = secretPacketBuffer2.readUnsignedByte();
                  boolean var68 = (var7 & 2) != 0;
                  boolean var69 = (var7 & 1) != 0;
                  if(var5 > 0) {
                     secretPacketBuffer2.readString();
                     secretPacketBuffer2.readUnsignedByte();
                     secretPacketBuffer2.readInt();
                  }

                  secretPacketBuffer2.readString();

                  for(var32 = 0; var32 < friendCount; ++var32) {
                     Friend var33 = friends[var32];
                     if(!var65) {
                        if(var59.equals(var33.name)) {
                           if(var33.world != var5) {
                              var110 = true;

                              for(class67 var13 = (class67)field1029.method3612(); var13 != null; var13 = (class67)field1029.method3607()) {
                                 if(var13.field841.equals(var59)) {
                                    if(var5 != 0 && var13.field837 == 0) {
                                       var13.method3615();
                                       var110 = false;
                                    } else if(var5 == 0 && var13.field837 != 0) {
                                       var13.method3615();
                                       var110 = false;
                                    }
                                 }
                              }

                              if(var110) {
                                 field1029.method3608(new class67(var59, var5));
                              }

                              var33.world = var5;
                           }

                           var33.previousName = var83;
                           var33.rank = var6;
                           var33.field824 = var68;
                           var33.field825 = var69;
                           var59 = null;
                           break;
                        }
                     } else if(var83.equals(var33.name)) {
                        var33.name = var59;
                        var33.previousName = var83;
                        var59 = null;
                        break;
                     }
                  }

                  if(var59 != null && friendCount < 400) {
                     Friend var47 = new Friend();
                     friends[friendCount] = var47;
                     var47.name = var59;
                     var47.previousName = var83;
                     var47.world = var5;
                     var47.rank = var6;
                     var47.field824 = var68;
                     var47.field825 = var69;
                     ++friendCount;
                  }
               }

               field1193 = 2;
               field1025 = field1112;
               var65 = false;
               var20 = friendCount;

               while(var20 > 0) {
                  var65 = true;
                  --var20;

                  for(var4 = 0; var4 < var20; ++var4) {
                     var62 = false;
                     Friend var79 = friends[var4];
                     Friend var103 = friends[var4 + 1];
                     if(var79.world != world && var103.world == world) {
                        var62 = true;
                     }

                     if(!var62 && var79.world == 0 && var103.world != 0) {
                        var62 = true;
                     }

                     if(!var62 && !var79.field824 && var103.field824) {
                        var62 = true;
                     }

                     if(!var62 && !var79.field825 && var103.field825) {
                        var62 = true;
                     }

                     if(var62) {
                        Friend var24 = friends[var4];
                        friends[var4] = friends[var4 + 1];
                        friends[var4 + 1] = var24;
                        var65 = false;
                     }
                  }

                  if(var65) {
                     break;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 190) {
               field1121 = field1112;
               if(packetLength == 0) {
                  clanChatOwner = null;
                  clanChatName = null;
                  class28.clanChatCount = 0;
                  class11.clanMembers = null;
                  packetType = -1;
                  return true;
               }

               clanChatName = secretPacketBuffer2.readString();
               long var48 = secretPacketBuffer2.readLong();
               clanChatOwner = XClanMember.method1182(var48);
               class12.field271 = secretPacketBuffer2.readByte();
               var4 = secretPacketBuffer2.readUnsignedByte();
               if(var4 == 255) {
                  packetType = -1;
                  return true;
               }

               class28.clanChatCount = var4;
               XClanMember[] var93 = new XClanMember[100];

               for(var6 = 0; var6 < class28.clanChatCount; ++var6) {
                  var93[var6] = new XClanMember();
                  var93[var6].username = secretPacketBuffer2.readString();
                  var93[var6].field919 = Player.method1179(var93[var6].username, field928);
                  var93[var6].world = secretPacketBuffer2.readUnsignedShort();
                  var93[var6].rank = secretPacketBuffer2.readByte();
                  secretPacketBuffer2.readString();
                  if(var93[var6].username.equals(XItemContainer.localPlayer.name)) {
                     class35.clanChatRank = var93[var6].rank;
                  }
               }

               var67 = false;
               var8 = class28.clanChatCount;

               while(var8 > 0) {
                  var67 = true;
                  --var8;

                  for(var9 = 0; var9 < var8; ++var9) {
                     if(var93[var9].field919.compareTo(var93[var9 + 1].field919) > 0) {
                        XClanMember var101 = var93[var9];
                        var93[var9] = var93[var9 + 1];
                        var93[var9 + 1] = var101;
                        var67 = false;
                     }
                  }

                  if(var67) {
                     break;
                  }
               }

               class11.clanMembers = var93;
               packetType = -1;
               return true;
            }

            if(packetType == 129) {
               var2 = secretPacketBuffer2.readInt();
               WidgetNode var61 = (WidgetNode)componentTable.method3530((long)var2);
               if(var61 != null) {
                  class95.method1780(var61, true);
               }

               if(field1091 != null) {
                  class88.method1714(field1091);
                  field1091 = null;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 247) {
               field1161 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            String var21;
            if(packetType == 36) {
               var2 = secretPacketBuffer2.method3159();
               var95 = secretPacketBuffer2.readUnsignedByte() == 1;
               var83 = "";
               var62 = false;
               if(var95) {
                  var83 = secretPacketBuffer2.readString();
                  if(class1.method2(var83)) {
                     var62 = true;
                  }
               }

               var21 = secretPacketBuffer2.readString();
               if(!var62) {
                  class152.sendGameMessage(var2, var83, var21);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 239) {
               var20 = secretPacketBuffer2.readUnsignedByte();
               class276[] var88 = new class276[]{class276.field3739, class276.field3737, class276.field3740};
               class276[] var91 = var88;
               var6 = 0;

               class276 var75;
               while(true) {
                  if(var6 >= var91.length) {
                     var75 = null;
                     break;
                  }

                  class276 var99 = var91[var6];
                  if(var20 == var99.field3738) {
                     var75 = var99;
                     break;
                  }

                  ++var6;
               }

               class61.field787 = var75;
               packetType = -1;
               return true;
            }

            if(packetType == 240) {
               var2 = secretPacketBuffer2.method3318();
               widgetRoot = var2;
               this.method1201(false);
               class222.method4070(var2);
               Ignore.method1136(widgetRoot);

               for(var20 = 0; var20 < 100; ++var20) {
                  field1132[var20] = true;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 243) {
               var2 = secretPacketBuffer2.readInt();
               var20 = secretPacketBuffer2.readUnsignedShort();
               var22 = PacketBuffer.method3403(var2);
               if(var22 != null && var22.type == 0) {
                  if(var20 > var22.scrollHeight - var22.height) {
                     var20 = var22.scrollHeight - var22.height;
                  }

                  if(var20 < 0) {
                     var20 = 0;
                  }

                  if(var20 != var22.scrollY) {
                     var22.scrollY = var20;
                     class88.method1714(var22);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 207) {
               var2 = secretPacketBuffer2.readByteOb1();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               class266.method4842(var2);
               packetType = -1;
               return true;
            }

            if(packetType == 46) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var20 = secretPacketBuffer2.read24BitInt();
               if(field1162 != 0 && var2 != -1) {
                  class29.method232(XGrandExchangeOffer.indexTrack2, var2, 0, field1162, false);
                  field1014 = true;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 237) {
               for(var2 = 0; var2 < class241.field3289; ++var2) {
                  class241 var85 = (class241)class241.field3290.get((long)var2);
                  class241 var60;
                  if(var85 != null) {
                     var60 = var85;
                  } else {
                     byte[] var89 = class241.field3292.getConfigData(16, var2);
                     var85 = new class241();
                     if(var89 != null) {
                        var85.method4281(new Buffer(var89));
                     }

                     class241.field3290.put(var85, (long)var2);
                     var60 = var85;
                  }

                  if(var60 != null) {
                     class211.settings[var2] = 0;
                     class211.widgetSettings[var2] = 0;
                  }
               }

               class69.method1135();
               field975 += 32;
               packetType = -1;
               return true;
            }

            if(packetType == 177) {
               class64.method1116();
               packetType = -1;
               return false;
            }

            if(packetType == 155) {
               var19 = secretPacketBuffer2.readString();
               field1062 = var19;

               try {
                  var59 = class261.field3632.getParameter(class274.field3719.field3726);
                  var83 = class261.field3632.getParameter(class274.field3732.field3726);
                  var23 = var59 + "settings=" + var19 + "; version=1; path=/; domain=" + var83;
                  String var29;
                  if(var19.length() == 0) {
                     var23 = var23 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var21 = var23 + "; Expires=";
                     var30 = class172.method3128() + 94608000000L;
                     class182.field2446.setTime(new Date(var30));
                     var32 = class182.field2446.get(7);
                     var11 = class182.field2446.get(5);
                     int var37 = class182.field2446.get(2);
                     var38 = class182.field2446.get(1);
                     var14 = class182.field2446.get(11);
                     int var50 = class182.field2446.get(12);
                     var44 = class182.field2446.get(13);
                     var29 = class182.field2443[var32 - 1] + ", " + var11 / 10 + var11 % 10 + "-" + class182.field2444[0][var37] + "-" + var38 + " " + var14 / 10 + var14 % 10 + ":" + var50 / 10 + var50 % 10 + ":" + var44 / 10 + var44 % 10 + " GMT";
                     var23 = var21 + var29 + "; Max-Age=" + 94608000L;
                  }

                  Client var78 = class261.field3632;
                  var29 = "document.cookie=\"" + var23 + "\"";
                  JSObject.getWindow(var78).eval(var29);
               } catch (Throwable var52) {
                  ;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 156) {
               class1.xteaChanged(false);
               secretPacketBuffer2.readOpcode();
               var2 = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2;
               var4 = var3.offset;
               class96.field1525 = 0;
               class90.method1722(var3);
               Preferences.updatePlayersFlag(var3);
               if(var2 != var3.offset - var4) {
                  throw new RuntimeException(var3.offset - var4 + " " + var2);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 248) {
               var2 = secretPacketBuffer2.method3318();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var20 = secretPacketBuffer2.readByteOb1();
               if(var20 == '\uffff') {
                  var20 = -1;
               }

               var4 = secretPacketBuffer2.method3190();
               var5 = secretPacketBuffer2.readInt();

               for(var6 = var2; var6 <= var20; ++var6) {
                  var34 = ((long)var5 << 32) + (long)var6;
                  Node var36 = widgetFlags.method3530(var34);
                  if(var36 != null) {
                     var36.unlink();
                  }

                  widgetFlags.method3529(new class198(var4), var34);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 75) {
               field942 = secretPacketBuffer2.readUnsignedShort() * 30;
               field1124 = field1112;
               packetType = -1;
               return true;
            }

            if(packetType == 122) {
               class69.method1135();
               weight = secretPacketBuffer2.readShort();
               field1124 = field1112;
               packetType = -1;
               return true;
            }

            if(packetType == 124) {
               var2 = secretPacketBuffer2.readInt();
               var20 = secretPacketBuffer2.readUnsignedShort();
               if(var2 < -70000) {
                  var20 += '耀';
               }

               if(var2 >= 0) {
                  var22 = PacketBuffer.method3403(var2);
               } else {
                  var22 = null;
               }

               if(var22 != null) {
                  for(var5 = 0; var5 < var22.itemIds.length; ++var5) {
                     var22.itemIds[var5] = 0;
                     var22.itemQuantities[var5] = 0;
                  }
               }

               class243.method4314(var20);
               var5 = secretPacketBuffer2.readUnsignedShort();

               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = secretPacketBuffer2.method3173();
                  if(var7 == 255) {
                     var7 = secretPacketBuffer2.method3190();
                  }

                  var8 = secretPacketBuffer2.readByteOb1();
                  if(var22 != null && var6 < var22.itemIds.length) {
                     var22.itemIds[var6] = var8;
                     var22.itemQuantities[var6] = var7;
                  }

                  PendingSpawn.method1528(var20, var6, var8 - 1, var7);
               }

               if(var22 != null) {
                  class88.method1714(var22);
               }

               class69.method1135();
               interfaceItemTriggers[++field1116 - 1 & 31] = var20 & 32767;
               packetType = -1;
               return true;
            }

            class151.method2912("" + packetType + "," + field976 + "," + field977 + "," + packetLength, (Throwable)null);
            class64.method1116();
         } catch (IOException var57) {
            class13.method60();
         } catch (Exception var58) {
            var19 = "" + packetType + "," + field976 + "," + field977 + "," + packetLength + "," + (XItemContainer.localPlayer.pathX[0] + class50.baseX) + "," + (XItemContainer.localPlayer.pathY[0] + class266.baseY) + ",";

            for(var20 = 0; var20 < packetLength && var20 < 50; ++var20) {
               var19 = var19 + secretPacketBuffer2.payload[var20] + ",";
            }

            class151.method2912(var19, var58);
            class64.method1116();
         }

         return true;
      }
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2075714416"
   )
   final void method1199() {
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
               if(field1074 != -1) {
                  if(var2 == field1074) {
                     field1074 = var2 + 1;
                  } else if(var2 + 1 == field1074) {
                     field1074 = var2;
                  }
               }

               var1 = false;
            }
         }
      }

      if(class95.field1513 == null) {
         if(field1100 == null) {
            int var20 = class59.field742;
            int var6;
            int var8;
            int var9;
            int var11;
            int var14;
            int var15;
            if(isMenuOpen) {
               if(var20 != 1 && (class34.field499 || var20 != 4)) {
                  var2 = class59.field748;
                  var14 = class59.field749;
                  if(var2 < ScriptState.menuX - 10 || var2 > WorldMapType1.menuWidth + ScriptState.menuX + 10 || var14 < Coordinates.menuY - 10 || var14 > MessageNode.menuHeight + Coordinates.menuY + 10) {
                     isMenuOpen = false;
                     Coordinates.method3911(ScriptState.menuX, Coordinates.menuY, WorldMapType1.menuWidth, MessageNode.menuHeight);
                  }
               }

               if(var20 == 1 || !class34.field499 && var20 == 4) {
                  var2 = ScriptState.menuX;
                  var14 = Coordinates.menuY;
                  var15 = WorldMapType1.menuWidth;
                  var5 = class59.field747;
                  var6 = class59.field756;
                  int var21 = -1;

                  for(var8 = 0; var8 < menuOptionCount; ++var8) {
                     var9 = (menuOptionCount - 1 - var8) * 15 + var14 + 31;
                     if(var5 > var2 && var5 < var2 + var15 && var6 > var9 - 13 && var6 < var9 + 3) {
                        var21 = var8;
                     }
                  }

                  if(var21 != -1 && var21 >= 0) {
                     var8 = menuActionParams0[var21];
                     var9 = menuActionParams1[var21];
                     int var22 = menuTypes[var21];
                     var11 = menuIdentifiers[var21];
                     String var19 = menuOptions[var21];
                     String var13 = menuTargets[var21];
                     Item.menuAction(var8, var9, var22, var11, var19, var13, class59.field747, class59.field756);
                  }

                  isMenuOpen = false;
                  Coordinates.method3911(ScriptState.menuX, Coordinates.menuY, WorldMapType1.menuWidth, MessageNode.menuHeight);
               }
            } else {
               var2 = class2.method7();
               if((var20 == 1 || !class34.field499 && var20 == 4) && var2 >= 0) {
                  var14 = menuTypes[var2];
                  if(var14 == 39 || var14 == 40 || var14 == 41 || var14 == 42 || var14 == 43 || var14 == 33 || var14 == 34 || var14 == 35 || var14 == 36 || var14 == 37 || var14 == 38 || var14 == 1005) {
                     label341: {
                        var15 = menuActionParams0[var2];
                        var5 = menuActionParams1[var2];
                        Widget var16 = PacketBuffer.method3403(var5);
                        var8 = WorldMapType3.method199(var16);
                        boolean var7 = (var8 >> 28 & 1) != 0;
                        if(!var7) {
                           Object var10000 = null;
                           if(!class29.method235(WorldMapType3.method199(var16))) {
                              break label341;
                           }
                        }

                        if(class95.field1513 != null && !field1043) {
                           var9 = class2.method7();
                           if(field1064 != 1) {
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
                                 var11 = field1040;
                                 int var12 = field1041;
                                 class67.method1122(class13.field281, var11, var12);
                                 class13.field281 = null;
                              }
                           }
                        }

                        field1043 = false;
                        field1044 = 0;
                        if(class95.field1513 != null) {
                           class88.method1714(class95.field1513);
                        }

                        class95.field1513 = PacketBuffer.method3403(var5);
                        field1039 = var15;
                        field1040 = class59.field747;
                        field1041 = class59.field756;
                        if(var2 >= 0) {
                           class13.field281 = new class89();
                           class13.field281.field1433 = menuActionParams0[var2];
                           class13.field281.field1429 = menuActionParams1[var2];
                           class13.field281.field1427 = menuTypes[var2];
                           class13.field281.field1428 = menuIdentifiers[var2];
                           class13.field281.field1425 = menuOptions[var2];
                        }

                        class88.method1714(class95.field1513);
                        return;
                     }
                  }
               }

               if(var20 == 1 || !class34.field499 && var20 == 4) {
                  label345: {
                     if(field1064 != 1 || menuOptionCount <= 2 || FaceNormal.method2868()) {
                        boolean var23;
                        if(var2 < 0) {
                           var23 = false;
                        } else {
                           var15 = menuTypes[var2];
                           if(var15 >= 2000) {
                              var15 -= 2000;
                           }

                           if(var15 == 1007) {
                              var23 = true;
                           } else {
                              var23 = false;
                           }
                        }

                        if(!var23) {
                           break label345;
                        }
                     }

                     var20 = 2;
                  }
               }

               if((var20 == 1 || !class34.field499 && var20 == 4) && menuOptionCount > 0 && var2 >= 0) {
                  var14 = menuActionParams0[var2];
                  var15 = menuActionParams1[var2];
                  var5 = menuTypes[var2];
                  var6 = menuIdentifiers[var2];
                  String var17 = menuOptions[var2];
                  String var18 = menuTargets[var2];
                  Item.menuAction(var14, var15, var5, var6, var17, var18, class59.field747, class59.field756);
               }

               if(var20 == 2 && menuOptionCount > 0) {
                  this.method1200(class59.field747, class59.field756);
               }
            }

         }
      }
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "862765742"
   )
   final void method1200(int var1, int var2) {
      int var3 = World.field1322.method4773("Choose Option");

      int var4;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         Font var5 = World.field1322;
         String var6;
         if(var4 < 0) {
            var6 = "";
         } else if(menuTargets[var4].length() > 0) {
            var6 = menuOptions[var4] + " " + menuTargets[var4];
         } else {
            var6 = menuOptions[var4];
         }

         int var7 = var5.method4773(var6);
         if(var7 > var3) {
            var3 = var7;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      int var8 = var1 - var3 / 2;
      if(var3 + var8 > class45.canvasWidth) {
         var8 = class45.canvasWidth - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var9 = var2;
      if(var4 + var2 > CollisionData.canvasHeight) {
         var9 = CollisionData.canvasHeight - var4;
      }

      if(var9 < 0) {
         var9 = 0;
      }

      class2.region.method2703(WallObject.plane, var1, var2, false);
      isMenuOpen = true;
      ScriptState.menuX = var8;
      Coordinates.menuY = var9;
      WorldMapType1.menuWidth = var3;
      MessageNode.menuHeight = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "2"
   )
   final void method1201(boolean var1) {
      WorldMapType3.method202(widgetRoot, class45.canvasWidth, CollisionData.canvasHeight, var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass219;III)LScript;",
      garbageValue = "-206563317"
   )
   static Script method1231(class219 var0, int var1, int var2) {
      int var3 = class134.method2579(var1, var0);
      Script var4 = ObjectComposition.method4573(var3, var0);
      if(var4 != null) {
         return var4;
      } else {
         var3 = class59.method1018(var2, var0);
         var4 = ObjectComposition.method4573(var3, var0);
         return var4 != null?var4:null;
      }
   }

   static {
      field974 = true;
      world = 1;
      flags = 0;
      field1202 = 0;
      isMembers = false;
      field930 = false;
      field931 = 0;
      gameState = 0;
      field934 = true;
      gameCycle = 0;
      field936 = -1L;
      field1130 = -1;
      field953 = -1;
      field939 = -1;
      field1090 = true;
      field941 = false;
      field942 = 0;
      field943 = 0;
      field944 = 0;
      field1183 = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowType = 0;
      field980 = 0;
      field950 = 0;
      field1012 = class91.field1441;
      field952 = class91.field1441;
      loadingStage = 0;
      field954 = 0;
      field955 = 0;
      field956 = 0;
      loginState = 0;
      field958 = 0;
      field959 = 0;
      field1093 = 0;
      field961 = null;
      cachedNPCs = new NPC['耀'];
      field937 = 0;
      npcIndices = new int['耀'];
      field965 = 0;
      field1026 = new int[250];
      secretPacketBuffer1 = new PacketBuffer(5000);
      field969 = new PacketBuffer(5000);
      secretPacketBuffer2 = new PacketBuffer(15000);
      packetLength = 0;
      packetType = 0;
      field973 = 0;
      audioEffectCount = 0;
      field964 = 0;
      field976 = 0;
      field977 = 0;
      field978 = 0;
      field979 = false;
      field1134 = new HashMap();
      field1083 = 0;
      field982 = 1;
      field983 = 0;
      field984 = 1;
      field1104 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field988 = new int[4][13][13];
      field989 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field1072 = 0;
      field1135 = 2;
      field1033 = 0;
      field993 = 2;
      field951 = 0;
      field995 = 1;
      field991 = 0;
      mapScale = 0;
      mapOffset = 2;
      mapScaleDelta = 0;
      field1000 = 1;
      field1001 = 0;
      field1002 = 0;
      field1108 = 2301979;
      field990 = 5063219;
      field1005 = 3353893;
      field1006 = 7759444;
      field1007 = false;
      field1008 = 0;
      field1052 = 128;
      mapAngle = 0;
      field1148 = 0;
      field1195 = 0;
      field1013 = 0;
      field1055 = 0;
      field1015 = 50;
      field1016 = 0;
      field1017 = false;
      field1018 = 0;
      field1046 = 0;
      field1020 = 50;
      field1021 = new int[field1020];
      field1022 = new int[field1020];
      field1009 = new int[field1020];
      field1024 = new int[field1020];
      field938 = new int[field1020];
      field1151 = new int[field1020];
      field1027 = new int[field1020];
      field1028 = new String[field1020];
      field1058 = new int[104][104];
      field957 = 0;
      field1031 = -1;
      field992 = -1;
      field1190 = 0;
      field1034 = 0;
      field967 = 0;
      cursorState = 0;
      field997 = 0;
      field1114 = 0;
      field1039 = 0;
      field1040 = 0;
      field1041 = 0;
      field1042 = 0;
      field1043 = false;
      field1044 = 0;
      field1045 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field1049 = 0;
      field1050 = 0;
      field1051 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field1123 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field1056 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      field1060 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field1064 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field1073 = false;
      field1074 = -1;
      field1075 = false;
      field1076 = -1;
      field1003 = -1;
      field1054 = 0;
      field1079 = 50;
      itemSelectionState = 0;
      selectedItemName = null;
      field1082 = false;
      field1158 = -1;
      field1084 = -1;
      field1078 = null;
      field1159 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field1089 = 0;
      field1141 = 0;
      field1091 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1065 = -1;
      field1096 = false;
      field1097 = false;
      field1199 = false;
      field1099 = null;
      field1100 = null;
      field1101 = null;
      field1102 = 0;
      field1103 = 0;
      field1105 = null;
      field1069 = false;
      field1175 = -1;
      field1107 = -1;
      field1176 = false;
      field1109 = -1;
      field960 = -1;
      field1111 = false;
      field1112 = 1;
      field1113 = new int[32];
      field975 = 0;
      interfaceItemTriggers = new int[32];
      field1116 = 0;
      field1117 = new int[32];
      field1067 = 0;
      field1119 = 0;
      field1025 = 0;
      field1121 = 0;
      field1110 = 0;
      field1004 = 0;
      field1124 = 0;
      field1125 = 0;
      field1035 = new Deque();
      field1127 = new Deque();
      field1128 = new Deque();
      widgetFlags = new XHashTable(512);
      field1061 = 0;
      field1131 = -2;
      field1132 = new boolean[100];
      field1133 = new boolean[100];
      field1030 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1140 = 0L;
      isResized = true;
      field1142 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field1143 = 0;
      field1032 = 0;
      field1145 = "";
      field1146 = new long[100];
      field1147 = 0;
      field1037 = 0;
      field1149 = new int[128];
      field1150 = new int[128];
      field925 = -1L;
      clanChatOwner = null;
      clanChatName = null;
      field1154 = -1;
      field1155 = 0;
      field1156 = new int[1000];
      field1011 = new int[1000];
      field927 = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1161 = 0;
      field1162 = 255;
      field1163 = -1;
      field1014 = false;
      field1165 = 127;
      field1098 = 127;
      field1181 = 0;
      field1168 = new int[50];
      field1169 = new int[50];
      field1170 = new int[50];
      field1171 = new int[50];
      audioEffects = new SoundEffect[50];
      field1173 = false;
      field1174 = new boolean[5];
      field1164 = new int[5];
      field996 = new int[5];
      field1177 = new int[5];
      field1178 = new int[5];
      field1179 = 256;
      field1180 = 205;
      field1126 = 256;
      field1182 = 320;
      field1166 = 1;
      field1184 = 32767;
      field1185 = 1;
      field1186 = 32767;
      field1187 = 0;
      field1188 = 0;
      viewportHeight = 0;
      viewportWidth = 0;
      scale = 0;
      friendCount = 0;
      field1193 = 0;
      friends = new Friend[400];
      field1029 = new class195();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1198 = new PlayerComposition();
      field1038 = -1;
      field1200 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field1120 = -1L;
      field1203 = -1L;
      field1204 = new class73();
      field1205 = new int[50];
      field1053 = new int[50];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "890021798"
   )
   protected final void vmethod1324() {
      field1140 = class172.method3128() + 500L;
      this.method1196();
      if(widgetRoot != -1) {
         this.method1201(true);
      }

   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-1378839515"
   )
   void method1343(Widget var1) {
      Widget var2 = var1.parentId == -1?null:PacketBuffer.method3403(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = class45.canvasWidth;
         var4 = CollisionData.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      WallObject.method2866(var1, var3, var4, false);
      class14.method65(var1, var3, var4);
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1049941921"
   )
   final void method1436() {
      class88.method1714(field1100);
      ++class220.field2809;
      if(field1176 && field1069) {
         int var1 = class59.field748;
         int var2 = class59.field749;
         var1 -= field1102;
         var2 -= field1103;
         if(var1 < field1175) {
            var1 = field1175;
         }

         if(var1 + field1100.width > field1175 + field1101.width) {
            var1 = field1175 + field1101.width - field1100.width;
         }

         if(var2 < field1107) {
            var2 = field1107;
         }

         if(var2 + field1100.height > field1107 + field1101.height) {
            var2 = field1107 + field1101.height - field1100.height;
         }

         int var3 = var1 - field1109;
         int var4 = var2 - field960;
         int var5 = field1100.field2730;
         if(class220.field2809 > field1100.field2720 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1111 = true;
         }

         int var6 = var1 - field1175 + field1101.scrollX;
         int var7 = var2 - field1107 + field1101.scrollY;
         class69 var8;
         if(field1100.field2643 != null && field1111) {
            var8 = new class69();
            var8.field849 = field1100;
            var8.field850 = var6;
            var8.field853 = var7;
            var8.field857 = field1100.field2643;
            class14.method76(var8);
         }

         if(class59.field754 == 0) {
            int var10;
            if(field1111) {
               if(field1100.field2744 != null) {
                  var8 = new class69();
                  var8.field849 = field1100;
                  var8.field850 = var6;
                  var8.field853 = var7;
                  var8.field859 = field1105;
                  var8.field857 = field1100.field2744;
                  class14.method76(var8);
               }

               if(field1105 != null) {
                  Widget var9 = field1100;
                  int var11 = WorldMapType3.method199(var9);
                  var10 = var11 >> 17 & 7;
                  int var12 = var10;
                  Widget var16;
                  if(var10 == 0) {
                     var16 = null;
                  } else {
                     int var13 = 0;

                     while(true) {
                        if(var13 >= var12) {
                           var16 = var9;
                           break;
                        }

                        var9 = PacketBuffer.method3403(var9.parentId);
                        if(var9 == null) {
                           var16 = null;
                           break;
                        }

                        ++var13;
                     }
                  }

                  if(var16 != null) {
                     secretPacketBuffer1.putOpcode(101);
                     secretPacketBuffer1.method3233(field1105.id);
                     secretPacketBuffer1.putShortOb2(field1105.index);
                     secretPacketBuffer1.putInt(field1100.id);
                     secretPacketBuffer1.putIntOb1(field1100.index);
                     secretPacketBuffer1.putShort(field1100.itemId);
                     secretPacketBuffer1.putShort(field1105.itemId);
                  }
               }
            } else {
               label158: {
                  int var14 = class2.method7();
                  if(menuOptionCount > 2) {
                     label161: {
                        if(field1064 != 1 || FaceNormal.method2868()) {
                           boolean var15;
                           if(var14 < 0) {
                              var15 = false;
                           } else {
                              var10 = menuTypes[var14];
                              if(var10 >= 2000) {
                                 var10 -= 2000;
                              }

                              if(var10 == 1007) {
                                 var15 = true;
                              } else {
                                 var15 = false;
                              }
                           }

                           if(!var15) {
                              break label161;
                           }
                        }

                        this.method1200(field1109 + field1102, field960 + field1103);
                        break label158;
                     }
                  }

                  if(menuOptionCount > 0) {
                     int var17 = field1102 + field1109;
                     var10 = field1103 + field960;
                     class67.method1122(class13.field281, var17, var10);
                     class13.field281 = null;
                  }
               }
            }

            field1100 = null;
         }

      } else {
         if(class220.field2809 > 1) {
            field1100 = null;
         }

      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "0"
   )
   protected final void vmethod1455(boolean var1) {
      boolean var2;
      label193: {
         try {
            if(class203.field2508 == 2) {
               if(class222.field2843 == null) {
                  class222.field2843 = Track1.method3890(class61.field785, class203.field2511, class203.field2512);
                  if(class222.field2843 == null) {
                     var2 = false;
                     break label193;
                  }
               }

               if(class20.field335 == null) {
                  class20.field335 = new class112(class203.field2507, class203.field2514);
               }

               if(class203.field2509.method3669(class222.field2843, class203.field2506, class20.field335, 22050)) {
                  class203.field2509.method3666();
                  class203.field2509.method3694(class203.field2513);
                  class203.field2509.method3672(class222.field2843, class203.field2515);
                  class203.field2508 = 0;
                  class222.field2843 = null;
                  class20.field335 = null;
                  class61.field785 = null;
                  var2 = true;
                  break label193;
               }
            }
         } catch (Exception var7) {
            var7.printStackTrace();
            class203.field2509.method3740();
            class203.field2508 = 0;
            class222.field2843 = null;
            class20.field335 = null;
            class61.field785 = null;
         }

         var2 = false;
      }

      if(var2 && field1014 && FrameMap.field2065 != null) {
         FrameMap.field2065.method2024();
      }

      int var4;
      if((gameState == 10 || gameState == 20 || gameState == 30) && field1140 != 0L && class172.method3128() > field1140) {
         var4 = isResized?2:1;
         field1140 = 0L;
         if(var4 >= 2) {
            isResized = true;
         } else {
            isResized = false;
         }

         int var5 = isResized?2:1;
         if(var5 == 1) {
            class261.field3632.method869(765, 503);
         } else {
            class261.field3632.method869(7680, 2160);
         }

         if(gameState >= 25) {
            class5.method18();
         }
      }

      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1132[var4] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class92.loadingBarPercentage, class92.loadingText, var1);
      } else if(gameState == 5) {
         class89.drawLoginScreen(World.field1322, class45.field618, class37.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class89.drawLoginScreen(World.field1322, class45.field618, class37.font_p12full, var1);
         } else if(gameState == 25) {
            if(field1104 == 1) {
               if(field1083 > field982) {
                  field982 = field1083;
               }

               var4 = (field982 * 50 - field1083 * 50) / field982;
               class2.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field1104 == 2) {
               if(field983 > field984) {
                  field984 = field983;
               }

               var4 = (field984 * 50 - field983 * 50) / field984 + 50;
               class2.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class2.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1197();
         } else if(gameState == 40) {
            class2.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class2.drawStatusBox("Please wait...", false);
         }
      } else {
         class89.drawLoginScreen(World.field1322, class45.field618, class37.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1) {
         for(var4 = 0; var4 < field1061; ++var4) {
            if(field1133[var4]) {
               class43.field602.vmethod5008(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field1133[var4] = false;
            }
         }
      } else if(gameState > 0) {
         class43.field602.vmethod5007(0, 0);

         for(var4 = 0; var4 < field1061; ++var4) {
            field1133[var4] = false;
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-751553860"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method1190();

      while(true) {
         Deque var2 = class236.field3247;
         FileSystem var1;
         synchronized(class236.field3247) {
            var1 = (FileSystem)class236.field3242.method3587();
         }

         if(var1 == null) {
            int var5;
            try {
               if(class203.field2508 == 1) {
                  var5 = class203.field2509.method3668();
                  if(var5 > 0 && class203.field2509.method3674()) {
                     var5 -= class203.field2517;
                     if(var5 < 0) {
                        var5 = 0;
                     }

                     class203.field2509.method3694(var5);
                  } else {
                     class203.field2509.method3740();
                     class203.field2509.method3671();
                     if(class61.field785 != null) {
                        class203.field2508 = 2;
                     } else {
                        class203.field2508 = 0;
                     }

                     class222.field2843 = null;
                     class20.field335 = null;
                  }
               }
            } catch (Exception var8) {
               var8.printStackTrace();
               class203.field2509.method3740();
               class203.field2508 = 0;
               class222.field2843 = null;
               class20.field335 = null;
               class61.field785 = null;
            }

            class14.method67();
            class33.method346();
            class59 var9 = class59.mouse;
            synchronized(class59.mouse) {
               class59.field754 = class59.field744;
               class59.field748 = class59.mouseX;
               class59.field749 = class59.mouseY;
               class59.field742 = class59.field762;
               class59.field747 = class59.field751;
               class59.field756 = class59.field752;
               class59.field757 = class59.field760;
               class59.field762 = 0;
            }

            if(class2.field16 != null) {
               var5 = class2.field16.vmethod2960();
               field1125 = var5;
            }

            if(gameState == 0) {
               class60.load();
               class95.method1782();
            } else if(gameState == 5) {
               ItemComposition.method4633(this);
               class60.load();
               class95.method1782();
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  ItemComposition.method4633(this);
                  this.method1193();
               } else if(gameState == 25) {
                  class17.method114();
               }
            } else {
               ItemComposition.method4633(this);
            }

            if(gameState == 30) {
               this.method1194();
            } else if(gameState == 40 || gameState == 45) {
               this.method1193();
            }

            return;
         }

         var1.data.method4220(var1.index, (int)var1.hash, var1.field3215, false);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   static void method1525() {
      class96.field1521 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class96.field1520[var0] = null;
         class96.field1519[var0] = 1;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LRegion;[LCollisionData;I)V",
      garbageValue = "1006662751"
   )
   static final void method1527(Region var0, CollisionData[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class61.tileSettings[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class61.tileSettings[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method3010(var3, var4);
                  }
               }
            }
         }
      }

      class61.field779 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field779 < -8) {
         class61.field779 = -8;
      }

      if(class61.field779 > 8) {
         class61.field779 = 8;
      }

      class61.field782 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field782 < -16) {
         class61.field782 = -16;
      }

      if(class61.field782 > 16) {
         class61.field782 = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var42 = class61.field771[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class61.tileHeights[var2][var12 + 1][var11] - class61.tileHeights[var2][var12 - 1][var11];
               var14 = class61.tileHeights[var2][var12][var11 + 1] - class61.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var13 * var13 + 65536 + var14 * var14));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var18 * -50 + var16 * -50 + var17 * -10) / var10 + 96;
               var20 = (var42[var12][var11] >> 1) + (var42[var12 - 1][var11] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11 - 1] >> 2) + (var42[var12][1 + var11] >> 3);
               class61.field774[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class17.field316[var11] = 0;
            class230.field3190[var11] = 0;
            class10.field258[var11] = 0;
            class158.field2273[var11] = 0;
            Buffer.field2406[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class61.underlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = class220.method4054(var14 - 1);
                     class17.field316[var12] += var43.field3351;
                     class230.field3190[var12] += var43.field3348;
                     class10.field258[var12] += var43.field3353;
                     class158.field2273[var12] += var43.field3354;
                     ++Buffer.field2406[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class61.underlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = class220.method4054(var15 - 1);
                     class17.field316[var12] -= var44.field3351;
                     class230.field3190[var12] -= var44.field3348;
                     class10.field258[var12] -= var44.field3353;
                     class158.field2273[var12] -= var44.field3354;
                     --Buffer.field2406[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = var17 + 5;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class17.field316[var18];
                     var13 += class230.field3190[var18];
                     var14 += class10.field258[var18];
                     var15 += class158.field2273[var18];
                     var16 += Buffer.field2406[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class17.field316[var19];
                     var13 -= class230.field3190[var19];
                     var14 -= class10.field258[var19];
                     var15 -= class158.field2273[var19];
                     var16 -= Buffer.field2406[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!field930 || (class61.tileSettings[0][var11][var17] & 2) != 0 || (class61.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class61.field770) {
                        class61.field770 = var2;
                     }

                     var20 = class61.underlayIds[var2][var11][var17] & 255;
                     int var21 = class61.overlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class61.tileHeights[var2][var11][var17];
                        int var23 = class61.tileHeights[var2][var11 + 1][var17];
                        int var24 = class61.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class61.tileHeights[var2][var11][var17 + 1];
                        int var26 = class61.field774[var11][var17];
                        int var27 = class61.field774[var11 + 1][var17];
                        int var28 = class61.field774[var11 + 1][var17 + 1];
                        int var29 = class61.field774[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class205.method3801(var32, var33, var34);
                           var32 = var32 + class61.field779 & 255;
                           var34 += class61.field782;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class205.method3801(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var46 = true;
                           if(var20 == 0 && class36.overlayPaths[var2][var11][var17] != 0) {
                              var46 = false;
                           }

                           if(var21 > 0 && !NPC.method1706(var21 - 1).isHidden) {
                              var46 = false;
                           }

                           if(var46 && var22 == var23 && var24 == var22 && var25 == var22) {
                              class39.field555[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class136.colorPalette[class61.method1102(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method2668(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class61.method1102(var30, var26), class61.method1102(var30, var27), class61.method1102(var30, var28), class61.method1102(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class36.overlayPaths[var2][var11][var17] + 1;
                           byte var47 = class67.overlayRotations[var2][var11][var17];
                           Overlay var35 = NPC.method1706(var21 - 1);
                           int var36 = var35.texture;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = class136.field2028.vmethod2876(var36);
                              var37 = -1;
                           } else if(var35.color == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class205.method3801(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class61.field779 & 255;
                              var40 = var35.lightness + class61.field782;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class205.method3801(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = class136.colorPalette[class39.method557(var38, 96)];
                           }

                           if(var35.field3601 != -1) {
                              var40 = var35.field3596 + class61.field779 & 255;
                              int var41 = var35.field3594 + class61.field782;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class205.method3801(var40, var35.field3602, var41);
                              var39 = class136.colorPalette[class39.method557(var38, 96)];
                           }

                           var0.method2668(var2, var11, var17, var33, var47, var36, var22, var23, var24, var25, class61.method1102(var30, var26), class61.method1102(var30, var27), class61.method1102(var30, var28), class61.method1102(var30, var29), class39.method557(var37, var26), class39.method557(var37, var27), class39.method557(var37, var28), class39.method557(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.method2671(var2, var12, var11, Tile.method2485(var2, var12, var11));
            }
         }

         class61.underlayIds[var2] = null;
         class61.overlayIds[var2] = null;
         class36.overlayPaths[var2] = null;
         class67.overlayRotations[var2] = null;
         class61.field771[var2] = null;
      }

      var0.method2697(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class61.tileSettings[1][var2][var3] & 2) == 2) {
               var0.method2766(var2, var3);
            }
         }
      }

      var2 = 1;
      var3 = 2;
      var4 = 4;

      for(var5 = 0; var5 < 4; ++var5) {
         if(var5 > 0) {
            var2 <<= 3;
            var3 <<= 3;
            var4 <<= 3;
         }

         for(int var6 = 0; var6 <= var5; ++var6) {
            for(int var7 = 0; var7 <= 104; ++var7) {
               for(int var8 = 0; var8 <= 104; ++var8) {
                  short var45;
                  if((class39.field555[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class39.field555[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class39.field555[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label471:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class39.field555[var11 - 1][var8][var13] & var2) == 0) {
                              break label471;
                           }
                        }

                        --var11;
                     }

                     label460:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class39.field555[var12 + 1][var8][var13] & var2) == 0) {
                              break label460;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + (var10 - var9)) * (1 + var12 - var11);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class61.tileHeights[var12][var8][var9] - var45;
                        var16 = class61.tileHeights[var11][var8][var9];
                        Region.method2670(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class39.field555[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class39.field555[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class39.field555[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class39.field555[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label524:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class39.field555[var11 - 1][var13][var7] & var3) == 0) {
                              break label524;
                           }
                        }

                        --var11;
                     }

                     label513:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class39.field555[var12 + 1][var13][var7] & var3) == 0) {
                              break label513;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class61.tileHeights[var12][var9][var7] - var45;
                        var16 = class61.tileHeights[var11][var9][var7];
                        Region.method2670(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class39.field555[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class39.field555[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class39.field555[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class39.field555[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label577:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class39.field555[var6][var9 - 1][var13] & var4) == 0) {
                              break label577;
                           }
                        }

                        --var9;
                     }

                     label566:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class39.field555[var6][var10 + 1][var13] & var4) == 0) {
                              break label566;
                           }
                        }

                        ++var10;
                     }

                     if((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
                        var13 = class61.tileHeights[var6][var9][var11];
                        Region.method2670(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class39.field555[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }
}
