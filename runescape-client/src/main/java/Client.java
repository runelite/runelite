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
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -2017794749
   )
   @Export("languageId")
   static int languageId;
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
   @Export("displayFps")
   static boolean displayFps;
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
   @Export("js5State")
   static int js5State;
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
   @Export("lastFrameId")
   static int lastFrameId;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -2094388453
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
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
   @Export("secondLastFrameId")
   static int secondLastFrameId;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 1739316727
   )
   @Export("thridLastFrameId")
   static int thridLastFrameId;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -835851787
   )
   static int field978;
   @ObfuscatedName("en")
   @Export("socketError")
   static boolean socketError;
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
   @Export("screenX")
   static int screenX;
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
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
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
   @Export("screenY")
   static int screenY;
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
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = -251951651
   )
   static int field1061;
   @ObfuscatedName("br")
   @Export("sessionToken")
   static String sessionToken;
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
   @Export("spellSelected")
   static boolean spellSelected;
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
   static Task field1157;
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
   @Export("socketType")
   static int socketType;
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
      if(this.isValidHost()) {
         Parameters[] var1 = Widget.method3999();
         int var2 = 0;

         while(true) {
            if(var2 >= var1.length) {
               Region.lowMemory = false;
               lowMemory = false;
               DState.host = this.getCodeBase().getHost();
               String var23 = Huffman.field2332.identifier;
               byte var24 = 0;

               try {
                  class182.field2445 = 17;
                  class35.field514 = var24;

                  try {
                     class155.osName = System.getProperty("os.name");
                  } catch (Exception var19) {
                     class155.osName = "Unknown";
                  }

                  class155.osNameLC = class155.osName.toLowerCase();

                  try {
                     GraphicsObject.userHome = System.getProperty("user.home");
                     if(GraphicsObject.userHome != null) {
                        GraphicsObject.userHome = GraphicsObject.userHome + "/";
                     }
                  } catch (Exception var18) {
                     ;
                  }

                  try {
                     if(class155.osNameLC.startsWith("win")) {
                        if(GraphicsObject.userHome == null) {
                           GraphicsObject.userHome = System.getenv("USERPROFILE");
                        }
                     } else if(GraphicsObject.userHome == null) {
                        GraphicsObject.userHome = System.getenv("HOME");
                     }

                     if(GraphicsObject.userHome != null) {
                        GraphicsObject.userHome = GraphicsObject.userHome + "/";
                     }
                  } catch (Exception var17) {
                     ;
                  }

                  if(GraphicsObject.userHome == null) {
                     GraphicsObject.userHome = "~/";
                  }

                  class37.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", GraphicsObject.userHome, "/tmp/", ""};
                  FaceNormal.field2153 = new String[]{".jagex_cache_" + class35.field514, ".file_store_" + class35.field514};
                  int var25 = 0;

                  label247:
                  while(var25 < 4) {
                     String var26 = var25 == 0?"":"" + var25;
                     class155.field2257 = new File(GraphicsObject.userHome, "jagex_cl_oldschool_" + var23 + var26 + ".dat");
                     String var28 = null;
                     String var29 = null;
                     boolean var30 = false;
                     int var13;
                     File var32;
                     if(class155.field2257.exists()) {
                        try {
                           FileOnDisk var10 = new FileOnDisk(class155.field2257, "rw", 10000L);

                           Buffer var11;
                           int var12;
                           for(var11 = new Buffer((int)var10.length()); var11.offset < var11.payload.length; var11.offset += var12) {
                              var12 = var10.read(var11.payload, var11.offset, var11.payload.length - var11.offset);
                              if(var12 == -1) {
                                 throw new IOException();
                              }
                           }

                           var11.offset = 0;
                           var12 = var11.readUnsignedByte();
                           if(var12 < 1 || var12 > 3) {
                              throw new IOException("" + var12);
                           }

                           var13 = 0;
                           if(var12 > 1) {
                              var13 = var11.readUnsignedByte();
                           }

                           if(var12 <= 2) {
                              var28 = var11.getJagString();
                              if(var13 == 1) {
                                 var29 = var11.getJagString();
                              }
                           } else {
                              var28 = var11.getCESU8();
                              if(var13 == 1) {
                                 var29 = var11.getCESU8();
                              }
                           }

                           var10.close();
                        } catch (IOException var21) {
                           var21.printStackTrace();
                        }

                        if(var28 != null) {
                           var32 = new File(var28);
                           if(!var32.exists()) {
                              var28 = null;
                           }
                        }

                        if(var28 != null) {
                           var32 = new File(var28, "test.dat");
                           if(!class61.method1100(var32, true)) {
                              var28 = null;
                           }
                        }
                     }

                     if(var28 == null && var25 == 0) {
                        label223:
                        for(int var33 = 0; var33 < FaceNormal.field2153.length; ++var33) {
                           for(int var36 = 0; var36 < class37.cacheLocations.length; ++var36) {
                              File var38 = new File(class37.cacheLocations[var36] + FaceNormal.field2153[var33] + File.separatorChar + "oldschool" + File.separatorChar);
                              if(var38.exists() && class61.method1100(new File(var38, "test.dat"), true)) {
                                 var28 = var38.toString();
                                 var30 = true;
                                 break label223;
                              }
                           }
                        }
                     }

                     if(var28 == null) {
                        var28 = GraphicsObject.userHome + File.separatorChar + "jagexcache" + var26 + File.separatorChar + "oldschool" + File.separatorChar + var23 + File.separatorChar;
                        var30 = true;
                     }

                     File var14;
                     File var35;
                     File[] var37;
                     File[] var39;
                     if(var29 != null) {
                        var35 = new File(var29);
                        var32 = new File(var28);

                        try {
                           var37 = var35.listFiles();
                           var39 = var37;

                           for(var13 = 0; var13 < var39.length; ++var13) {
                              var14 = var39[var13];
                              File var15 = new File(var32, var14.getName());
                              boolean var16 = var14.renameTo(var15);
                              if(!var16) {
                                 throw new IOException();
                              }
                           }
                        } catch (Exception var20) {
                           var20.printStackTrace();
                        }

                        var30 = true;
                     }

                     if(var30) {
                        Friend.method1118(new File(var28), (File)null);
                     }

                     var35 = new File(var28);
                     Frames.field2158 = var35;
                     if(!Frames.field2158.exists()) {
                        Frames.field2158.mkdirs();
                     }

                     var37 = Frames.field2158.listFiles();
                     if(var37 == null) {
                        break;
                     }

                     var39 = var37;
                     var13 = 0;

                     while(true) {
                        if(var13 >= var39.length) {
                           break label247;
                        }

                        var14 = var39[var13];
                        if(!class61.method1100(var14, false)) {
                           ++var25;
                           break;
                        }

                        ++var13;
                     }
                  }

                  File var27 = Frames.field2158;
                  class157.field2268 = var27;
                  if(!class157.field2268.exists()) {
                     throw new RuntimeException("");
                  }

                  class157.field2271 = true;
                  Player.method1177();
                  class155.field2259 = new CacheFile(new FileOnDisk(class40.method561("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
                  class155.field2262 = new CacheFile(new FileOnDisk(class40.method561("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
                  BaseVarType.field32 = new CacheFile[class182.field2445];

                  for(int var34 = 0; var34 < class182.field2445; ++var34) {
                     BaseVarType.field32[var34] = new CacheFile(new FileOnDisk(class40.method561("main_file_cache.idx" + var34), "rw", 1048576L), 6000, 0);
                  }
               } catch (Exception var22) {
                  MilliTimer.method2912((String)null, var22);
               }

               class261.clientInstance = this;
               this.initialize(765, 503, 148);
               break;
            }

            Parameters var3 = var1[var2];
            String var4 = this.getParameter(var3.key);
            if(var4 != null) {
               switch(Integer.parseInt(var3.key)) {
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
                  int var5 = Integer.parseInt(var4);
                  BuildType[] var6 = class35.method507();
                  int var7 = 0;

                  BuildType var8;
                  while(true) {
                     if(var7 >= var6.length) {
                        var8 = null;
                        break;
                     }

                     BuildType var31 = var6[var7];
                     if(var31.ordinal == var5) {
                        var8 = var31;
                        break;
                     }

                     ++var7;
                  }

                  Huffman.field2332 = var8;
                  break;
               case 7:
                  sessionToken = var4;
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
                  languageId = Integer.parseInt(var4);
                  break;
               case 12:
                  class232[] var9 = new class232[]{class232.field3199, class232.field3201, class232.field3204, class232.field3202, class232.field3198, class232.field3200};
                  field1207 = (class232)class134.forOrdinal(var9, Integer.parseInt(var4));
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
                  socketType = Integer.parseInt(var4);
                  break;
               case 15:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
               }
            }

            ++var2;
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "446180837"
   )
   protected final void vmethod1186() {
      class33.field481 = socketType == 0?'ꩊ':world + '鱀';
      class37.field529 = socketType == 0?443:world + '썐';
      class96.myWorldPort = class33.field481;
      class18.colorsToFind = class214.field2638;
      PlayerComposition.colorsToReplace = class214.field2631;
      NPC.field1398 = class214.field2633;
      PlayerComposition.field2620 = class214.field2634;
      this.method919();
      this.method875();
      class2.field16 = this.method913();
      Ignore.field861 = new IndexFile(255, class155.field2259, class155.field2262, 500000);
      FileOnDisk var1 = null;
      Preferences var2 = new Preferences();

      int var3;
      int var5;
      try {
         var1 = class22.getPreferencesFile("", field1207.field3203, false);
         byte[] var4 = new byte[(int)var1.length()];

         for(var3 = 0; var3 < var4.length; var3 += var5) {
            var5 = var1.read(var4, var3, var4.length - var3);
            if(var5 == -1) {
               throw new IOException();
            }
         }

         var2 = new Preferences(new Buffer(var4));
      } catch (Exception var7) {
         ;
      }

      try {
         if(var1 != null) {
            var1.close();
         }
      } catch (Exception var6) {
         ;
      }

      class8.settings = var2;
      this.method909();
      String var8 = GameEngine.field735;
      class56.field699 = this;
      class56.field705 = var8;
      if(socketType != 0) {
         displayFps = true;
      }

      var5 = class8.settings.screenType;
      field1140 = 0L;
      if(var5 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      var3 = isResized?2:1;
      if(var3 == 1) {
         class261.clientInstance.method869(765, 503);
      } else {
         class261.clientInstance.method869(7680, 2160);
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
      if(class71.chatMessages.changed()) {
         class71.chatMessages.serialize();
      }

      if(WorldMapType3.field393 != null) {
         WorldMapType3.field393.field874 = false;
      }

      WorldMapType3.field393 = null;
      if(class244.rssocket != null) {
         class244.rssocket.close();
         class244.rssocket = null;
      }

      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var1 = KeyFocusListener.keyboard;
         KeyFocusListener var2 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

      if(MouseInput.mouse != null) {
         MouseInput var10 = MouseInput.mouse;
         MouseInput var12 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

      class2.field16 = null;
      if(FrameMap.soundSystem0 != null) {
         FrameMap.soundSystem0.method2025();
      }

      if(MouseInput.soundSystem1 != null) {
         MouseInput.soundSystem1.method2025();
      }

      BuildType.method4105();
      Object var11 = class236.field3244;
      Object var13 = class236.field3244;
      synchronized(class236.field3244) {
         if(class236.field3243 != 0) {
            class236.field3243 = 1;

            try {
               class236.field3244.wait();
            } catch (InterruptedException var6) {
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
   @Export("processJS5Connection")
   void processJS5Connection() {
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
   @Export("error")
   void error(int var1) {
      class89.socket = null;
      FileOnDisk.rssocket = null;
      js5State = 0;
      if(class33.field481 == class96.myWorldPort) {
         class96.myWorldPort = class37.field529;
      } else {
         class96.myWorldPort = class33.field481;
      }

      ++field956;
      if(field956 < 2 || var1 != 7 && var1 != 9) {
         if(field956 >= 2 && var1 == 6) {
            this.error("js5connect_outofdate");
            gameState = 1000;
         } else if(field956 >= 4) {
            if(gameState <= 5) {
               this.error("js5connect");
               gameState = 1000;
            } else {
               field955 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.error("js5connect_full");
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
            socketError = false;
            field958 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(field1157 == null) {
               field1157 = GameEngine.taskManager.createSocket(DState.host, class96.myWorldPort);
            }

            if(field1157.status == 2) {
               throw new IOException();
            }

            if(field1157.status == 1) {
               class244.rssocket = new RSSocket((Socket)field1157.value, GameEngine.taskManager);
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
            if(FrameMap.soundSystem0 != null) {
               FrameMap.soundSystem0.method2062();
            }

            if(MouseInput.soundSystem1 != null) {
               MouseInput.soundSystem1.method2062();
            }

            var1 = class244.rssocket.readByte();
            if(FrameMap.soundSystem0 != null) {
               FrameMap.soundSystem0.method2062();
            }

            if(MouseInput.soundSystem1 != null) {
               MouseInput.soundSystem1.method2062();
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
            int[] var4 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class24.field368 >> 32), (int)(class24.field368 & -1L)};
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(1);
            secretPacketBuffer1.putByte(class92.field1472.rsOrdinal());
            secretPacketBuffer1.putInt(var4[0]);
            secretPacketBuffer1.putInt(var4[1]);
            secretPacketBuffer1.putInt(var4[2]);
            secretPacketBuffer1.putInt(var4[3]);
            switch(class92.field1472.field2220) {
            case 0:
            case 1:
               secretPacketBuffer1.put24bitInt(Script.authCodeForLogin);
               secretPacketBuffer1.offset += 5;
               break;
            case 2:
               secretPacketBuffer1.putInt(((Integer)class8.settings.preferences.get(Integer.valueOf(ScriptVarType.method30(class92.username)))).intValue());
               secretPacketBuffer1.offset += 4;
               break;
            case 3:
               secretPacketBuffer1.offset += 8;
            }

            secretPacketBuffer1.putString(class92.password);
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
            field969.putString(class92.username);
            field969.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            field969.putShort(class45.canvasWidth);
            field969.putShort(CollisionData.canvasHeight);
            class73.method1152(field969);
            field969.putString(sessionToken);
            field969.putInt(class33.field480);
            Buffer var5 = new Buffer(Ignore.field866.method5370());
            Ignore.field866.method5372(var5);
            field969.putBytes(var5.payload, 0, var5.payload.length);
            field969.putByte(Coordinates.field2618);
            field969.putInt(0);
            field969.putInt(class44.indexInterfaces.crc);
            field969.putInt(class261.indexSoundEffects.crc);
            field969.putInt(class91.configsIndex.crc);
            field969.putInt(class10.field259.crc);
            field969.putInt(class98.field1545.crc);
            field969.putInt(Frames.indexMaps.crc);
            field969.putInt(class44.indexTrack1.crc);
            field969.putInt(class1.indexModels.crc);
            field969.putInt(class18.indexSprites.crc);
            field969.putInt(class87.indexTextures.crc);
            field969.putInt(DecorativeObject.field2194.crc);
            field969.putInt(XGrandExchangeOffer.indexTrack2.crc);
            field969.putInt(class169.indexScripts.crc);
            field969.putInt(RSCanvas.field693.crc);
            field969.putInt(class12.vorbisIndex.crc);
            field969.putInt(class28.field424.crc);
            field969.putInt(class61.indexWorldMap.crc);
            field969.encryptXtea(var4, var3, field969.offset);
            field969.putShortLength(field969.offset - var2);
            class244.rssocket.queueForWrite(field969.payload, 0, field969.offset);
            secretPacketBuffer1.seed(var4);

            for(int var6 = 0; var6 < 4; ++var6) {
               var4[var6] += 50;
            }

            secretPacketBuffer2.seed(var4);
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
               boolean var9 = class244.rssocket.readByte() == 1;
               class244.rssocket.read(secretPacketBuffer2.payload, 0, 4);
               secretPacketBuffer2.offset = 0;
               boolean var12 = false;
               if(var9) {
                  var2 = secretPacketBuffer2.readOpcode() << 24;
                  var2 |= secretPacketBuffer2.readOpcode() << 16;
                  var2 |= secretPacketBuffer2.readOpcode() << 8;
                  var2 |= secretPacketBuffer2.readOpcode();
                  var3 = ScriptVarType.method30(class92.username);
                  if(class8.settings.preferences.size() >= 10 && !class8.settings.preferences.containsKey(Integer.valueOf(var3))) {
                     Iterator var17 = class8.settings.preferences.entrySet().iterator();
                     var17.next();
                     var17.remove();
                  }

                  class8.settings.preferences.put(Integer.valueOf(var3), Integer.valueOf(var2));
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
                  Client var18 = class261.clientInstance;
                  JSObject.getWindow(var18).call("zap", (Object[])null);
               } catch (Throwable var7) {
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
                  String var10 = secretPacketBuffer2.readString();
                  String var13 = secretPacketBuffer2.readString();
                  String var19 = secretPacketBuffer2.readString();
                  class13.method64(var10, var13, var19);
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
                     class17.initializeGPI(secretPacketBuffer2);
                     if(var1 != secretPacketBuffer2.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field958;
                  if(field958 > 2000) {
                     if(field959 < 1) {
                        if(class33.field481 == class96.myWorldPort) {
                           class96.myWorldPort = class37.field529;
                        } else {
                           class96.myWorldPort = class33.field481;
                        }

                        ++field959;
                        loginState = 0;
                     } else {
                        class15.method86(-3);
                     }
                  }
               }
            } else if(class244.rssocket.available() >= packetLength) {
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
               lastFrameId = 1;
               secondLastFrameId = -1;
               thridLastFrameId = -1;
               field973 = 0;
               field942 = 0;
               field978 = 0;
               field943 = 0;
               class60.method1055();
               class83.method1674(0);
               class8.method44();
               itemSelectionState = 0;
               spellSelected = false;
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
               field1193 = 0;
               friendCount = 0;
               ignoreCount = 0;

               for(var1 = 0; var1 < VarPlayerType.field3289; ++var1) {
                  VarPlayerType var11 = (VarPlayerType)VarPlayerType.varplayers.get((long)var1);
                  VarPlayerType var15;
                  if(var11 != null) {
                     var15 = var11;
                  } else {
                     byte[] var20 = VarPlayerType.varplayer_ref.getConfigData(16, var1);
                     var11 = new VarPlayerType();
                     if(var20 != null) {
                        var11.decode(new Buffer(var20));
                     }

                     VarPlayerType.varplayers.put(var11, (long)var1);
                     var15 = var11;
                  }

                  if(var15 != null) {
                     class211.settings[var1] = 0;
                     class211.widgetSettings[var1] = 0;
                  }
               }

               class71.chatMessages.reset();
               field1065 = -1;
               if(widgetRoot != -1) {
                  PacketBuffer.method3411(widgetRoot);
               }

               for(WidgetNode var14 = (WidgetNode)componentTable.method3533(); var14 != null; var14 = (WidgetNode)componentTable.method3538()) {
                  class95.method1780(var14, true);
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
               class17.initializeGPI(secretPacketBuffer2);
               World.field1321 = -1;
               class1.xteaChanged(false);
               packetType = -1;
            }
         }
      } catch (IOException var8) {
         if(field959 < 1) {
            if(class33.field481 == class96.myWorldPort) {
               class96.myWorldPort = class37.field529;
            } else {
               class96.myWorldPort = class33.field481;
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

      if(socketError) {
         socketError = false;
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
               class205.encodeClassVerifier(secretPacketBuffer1);
               secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var1);
            }

            Object var2 = WorldMapType3.field393.field869;
            Object var11 = WorldMapType3.field393.field869;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            synchronized(WorldMapType3.field393.field869) {
               if(!field974) {
                  WorldMapType3.field393.field878 = 0;
               } else if(MouseInput.field742 != 0 || WorldMapType3.field393.field878 >= 40) {
                  secretPacketBuffer1.putOpcode(54);
                  secretPacketBuffer1.putByte(0);
                  var3 = secretPacketBuffer1.offset;
                  var4 = 0;

                  for(var5 = 0; var5 < WorldMapType3.field393.field878 && secretPacketBuffer1.offset - var3 < 240; ++var5) {
                     ++var4;
                     var6 = WorldMapType3.field393.field872[var5];
                     if(var6 < 0) {
                        var6 = 0;
                     } else if(var6 > 502) {
                        var6 = 502;
                     }

                     var7 = WorldMapType3.field393.field871[var5];
                     if(var7 < 0) {
                        var7 = 0;
                     } else if(var7 > 764) {
                        var7 = 764;
                     }

                     var8 = var6 * 765 + var7;
                     if(WorldMapType3.field393.field872[var5] == -1 && WorldMapType3.field393.field871[var5] == -1) {
                        var7 = -1;
                        var6 = -1;
                        var8 = 524287;
                     }

                     if(field1130 == var7 && var6 == field953) {
                        if(field939 < 2047) {
                           ++field939;
                        }
                     } else {
                        var9 = var7 - field1130;
                        field1130 = var7;
                        var10 = var6 - field953;
                        field953 = var6;
                        if(field939 < 8 && var9 >= -32 && var9 <= 31 && var10 >= -32 && var10 <= 31) {
                           var9 += 32;
                           var10 += 32;
                           secretPacketBuffer1.putShort((var9 << 6) + (field939 << 12) + var10);
                           field939 = 0;
                        } else if(field939 < 8) {
                           secretPacketBuffer1.put24bitInt((field939 << 19) + 8388608 + var8);
                           field939 = 0;
                        } else {
                           secretPacketBuffer1.putInt(var8 + (field939 << 19) + -1073741824);
                           field939 = 0;
                        }
                     }
                  }

                  secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var3);
                  if(var4 >= WorldMapType3.field393.field878) {
                     WorldMapType3.field393.field878 = 0;
                  } else {
                     WorldMapType3.field393.field878 -= var4;

                     for(var5 = 0; var5 < WorldMapType3.field393.field878; ++var5) {
                        WorldMapType3.field393.field871[var5] = WorldMapType3.field393.field871[var4 + var5];
                        WorldMapType3.field393.field872[var5] = WorldMapType3.field393.field872[var4 + var5];
                     }
                  }
               }
            }

            long var21;
            if(MouseInput.field742 == 1 || !class34.field499 && MouseInput.field742 == 4 || MouseInput.field742 == 2) {
               var21 = (MouseInput.field757 - field936) / 50L;
               if(var21 > 4095L) {
                  var21 = 4095L;
               }

               field936 = MouseInput.field757;
               var4 = MouseInput.field756;
               if(var4 < 0) {
                  var4 = 0;
               } else if(var4 > CollisionData.canvasHeight) {
                  var4 = CollisionData.canvasHeight;
               }

               var5 = MouseInput.field747;
               if(var5 < 0) {
                  var5 = 0;
               } else if(var5 > class45.canvasWidth) {
                  var5 = class45.canvasWidth;
               }

               var6 = (int)var21;
               secretPacketBuffer1.putOpcode(171);
               secretPacketBuffer1.putShort((var6 << 1) + (MouseInput.field742 == 2?1:0));
               secretPacketBuffer1.putShort(var5);
               secretPacketBuffer1.putShort(var4);
            }

            if(KeyFocusListener.field671 > 0) {
               secretPacketBuffer1.putOpcode(3);
               secretPacketBuffer1.putShort(0);
               var1 = secretPacketBuffer1.offset;
               var21 = DState.currentTimeMs();

               for(var5 = 0; var5 < KeyFocusListener.field671; ++var5) {
                  long var13 = var21 - field925;
                  if(var13 > 16777215L) {
                     var13 = 16777215L;
                  }

                  field925 = var21;
                  secretPacketBuffer1.method3184((int)var13);
                  secretPacketBuffer1.putShortLE(KeyFocusListener.field670[var5]);
               }

               secretPacketBuffer1.putShortLength(secretPacketBuffer1.offset - var1);
            }

            if(field1016 > 0) {
               --field1016;
            }

            if(KeyFocusListener.field659[96] || KeyFocusListener.field659[97] || KeyFocusListener.field659[98] || KeyFocusListener.field659[99]) {
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
               ObjectComposition var12;
               for(PendingSpawn var22 = (PendingSpawn)pendingSpawns.getFront(); var22 != null; var22 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var22.hitpoints > 0) {
                     --var22.hitpoints;
                  }

                  boolean var26;
                  if(var22.hitpoints == 0) {
                     if(var22.field1209 >= 0) {
                        var4 = var22.field1209;
                        var5 = var22.field1222;
                        var12 = class251.getObjectDefinition(var4);
                        if(var5 == 11) {
                           var5 = 10;
                        }

                        if(var5 >= 5 && var5 <= 8) {
                           var5 = 4;
                        }

                        var26 = var12.method4515(var5);
                        if(!var26) {
                           continue;
                        }
                     }

                     Friend.method1119(var22.level, var22.type, var22.x, var22.y, var22.field1209, var22.field1214, var22.field1222);
                     var22.unlink();
                  } else {
                     if(var22.delay > 0) {
                        --var22.delay;
                     }

                     if(var22.delay == 0 && var22.x >= 1 && var22.y >= 1 && var22.x <= 102 && var22.y <= 102) {
                        if(var22.id >= 0) {
                           var4 = var22.id;
                           var5 = var22.field1223;
                           var12 = class251.getObjectDefinition(var4);
                           if(var5 == 11) {
                              var5 = 10;
                           }

                           if(var5 >= 5 && var5 <= 8) {
                              var5 = 4;
                           }

                           var26 = var12.method4515(var5);
                           if(!var26) {
                              continue;
                           }
                        }

                        Friend.method1119(var22.level, var22.type, var22.x, var22.y, var22.id, var22.orientation, var22.field1223);
                        var22.delay = -1;
                        if(var22.field1209 == var22.id && var22.field1209 == -1) {
                           var22.unlink();
                        } else if(var22.field1209 == var22.id && var22.field1214 == var22.orientation && var22.field1223 == var22.field1222) {
                           var22.unlink();
                        }
                     }
                  }
               }

               for(var1 = 0; var1 < field1181; ++var1) {
                  --field1170[var1];
                  if(field1170[var1] >= -10) {
                     SoundEffect var24 = audioEffects[var1];
                     if(var24 == null) {
                        var12 = null;
                        var24 = SoundEffect.getTrack(class98.field1545, field1168[var1], 0);
                        if(var24 == null) {
                           continue;
                        }

                        field1170[var1] += var24.calculateDelay();
                        audioEffects[var1] = var24;
                     }

                     if(field1170[var1] < 0) {
                        if(field1171[var1] != 0) {
                           var5 = (field1171[var1] & 255) * 128;
                           var6 = field1171[var1] >> 16 & 255;
                           var7 = var6 * 128 + 64 - XItemContainer.localPlayer.x;
                           if(var7 < 0) {
                              var7 = -var7;
                           }

                           var8 = field1171[var1] >> 8 & 255;
                           var9 = var8 * 128 + 64 - XItemContainer.localPlayer.y;
                           if(var9 < 0) {
                              var9 = -var9;
                           }

                           var10 = var9 + var7 - 128;
                           if(var10 > var5) {
                              field1170[var1] = -100;
                              continue;
                           }

                           if(var10 < 0) {
                              var10 = 0;
                           }

                           var4 = (var5 - var10) * field1098 / var5;
                        } else {
                           var4 = field1165;
                        }

                        if(var4 > 0) {
                           class107 var23 = var24.method1942().method1989(class225.field2896);
                           class117 var29 = class117.method2229(var23, 100, var4);
                           var29.method2126(field1169[var1] - 1);
                           class19.field328.method1890(var29);
                        }

                        field1170[var1] = -100;
                     }
                  } else {
                     --field1181;

                     for(var3 = var1; var3 < field1181; ++var3) {
                        field1168[var3] = field1168[var3 + 1];
                        audioEffects[var3] = audioEffects[var3 + 1];
                        field1169[var3] = field1169[var3 + 1];
                        field1170[var3] = field1170[var3 + 1];
                        field1171[var3] = field1171[var3 + 1];
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
               if(field973 <= 750) {
                  class29.method234();

                  for(var1 = 0; var1 < field937; ++var1) {
                     var3 = npcIndices[var1];
                     NPC var27 = cachedNPCs[var3];
                     if(var27 != null) {
                        RSCanvas.method809(var27, var27.composition.field3561);
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

                  Widget var28 = KitDefinition.field3371;
                  Widget var25 = PendingSpawn.field1211;
                  KitDefinition.field3371 = null;
                  PendingSpawn.field1211 = null;
                  field1105 = null;
                  field1176 = false;
                  field1069 = false;
                  field1037 = 0;

                  while(class14.method77() && field1037 < 128) {
                     if(rights >= 2 && KeyFocusListener.field659[82] && class168.field2346 == 66) {
                        String var30 = WallObject.method2865();
                        class261.clientInstance.method972(var30);
                     } else {
                        field1150[field1037] = class168.field2346;
                        field1149[field1037] = IndexDataBase.field3238;
                        ++field1037;
                     }
                  }

                  if(widgetRoot != -1) {
                     var4 = widgetRoot;
                     var5 = class45.canvasWidth;
                     var6 = CollisionData.canvasHeight;
                     if(class66.loadWidget(var4)) {
                        WorldMapType1.method262(class46.widgets[var4], -1, 0, 0, var5, var6, 0, 0);
                     }
                  }

                  ++field1112;

                  while(true) {
                     ScriptEvent var14;
                     Widget var15;
                     Widget var31;
                     do {
                        var14 = (ScriptEvent)field1127.popFront();
                        if(var14 == null) {
                           while(true) {
                              do {
                                 var14 = (ScriptEvent)field1128.popFront();
                                 if(var14 == null) {
                                    while(true) {
                                       do {
                                          var14 = (ScriptEvent)field1035.popFront();
                                          if(var14 == null) {
                                             this.method1199();
                                             if(class43.renderOverview != null) {
                                                class43.renderOverview.method5187(WallObject.plane, (XItemContainer.localPlayer.x >> 7) + KeyFocusListener.baseX, (XItemContainer.localPlayer.y >> 7) + class266.baseY, false);
                                                class43.renderOverview.method5201();
                                             }

                                             if(field1100 != null) {
                                                this.method1436();
                                             }

                                             if(class95.field1513 != null) {
                                                class88.method1714(class95.field1513);
                                                ++field1044;
                                                if(MouseInput.field754 == 0) {
                                                   if(field1043) {
                                                      if(FaceNormal.field2155 == class95.field1513 && field1039 != field1042) {
                                                         Widget var32 = class95.field1513;
                                                         byte var17 = 0;
                                                         if(field1141 == 1 && var32.contentType == 206) {
                                                            var17 = 1;
                                                         }

                                                         if(var32.itemIds[field1042] <= 0) {
                                                            var17 = 0;
                                                         }

                                                         if(class29.method235(WorldMapType3.getWidgetConfig(var32))) {
                                                            var6 = field1039;
                                                            var7 = field1042;
                                                            var32.itemIds[var7] = var32.itemIds[var6];
                                                            var32.itemQuantities[var7] = var32.itemQuantities[var6];
                                                            var32.itemIds[var6] = -1;
                                                            var32.itemQuantities[var6] = 0;
                                                         } else if(var17 == 1) {
                                                            var6 = field1039;
                                                            var7 = field1042;

                                                            while(var6 != var7) {
                                                               if(var6 > var7) {
                                                                  var32.method4006(var6 - 1, var6);
                                                                  --var6;
                                                               } else if(var6 < var7) {
                                                                  var32.method4006(var6 + 1, var6);
                                                                  ++var6;
                                                               }
                                                            }
                                                         } else {
                                                            var32.method4006(field1042, field1039);
                                                         }

                                                         secretPacketBuffer1.putOpcode(19);
                                                         secretPacketBuffer1.method3257(class95.field1513.id);
                                                         secretPacketBuffer1.putIntOb1(field1039);
                                                         secretPacketBuffer1.method3265(var17);
                                                         secretPacketBuffer1.putShortOb2(field1042);
                                                      }
                                                   } else {
                                                      label964: {
                                                         var4 = class2.method7();
                                                         if(menuOptionCount > 2) {
                                                            label974: {
                                                               if(field1064 != 1 || FaceNormal.method2868()) {
                                                                  boolean var16;
                                                                  if(var4 < 0) {
                                                                     var16 = false;
                                                                  } else {
                                                                     var6 = menuTypes[var4];
                                                                     if(var6 >= 2000) {
                                                                        var6 -= 2000;
                                                                     }

                                                                     if(var6 == 1007) {
                                                                        var16 = true;
                                                                     } else {
                                                                        var16 = false;
                                                                     }
                                                                  }

                                                                  if(!var16) {
                                                                     break label974;
                                                                  }
                                                               }

                                                               this.method1200(field1040, field1041);
                                                               break label964;
                                                            }
                                                         }

                                                         if(menuOptionCount > 0) {
                                                            var5 = field1040;
                                                            var6 = field1041;
                                                            class67.method1122(class13.field281, var5, var6);
                                                            class13.field281 = null;
                                                         }
                                                      }
                                                   }

                                                   field997 = 10;
                                                   MouseInput.field742 = 0;
                                                   class95.field1513 = null;
                                                } else if(field1044 >= 5 && (MouseInput.field748 > field1040 + 5 || MouseInput.field748 < field1040 - 5 || MouseInput.field749 > field1041 + 5 || MouseInput.field749 < field1041 - 5)) {
                                                   field1043 = true;
                                                }
                                             }

                                             if(Region.method2705()) {
                                                var4 = Region.selectedRegionTileX;
                                                var5 = Region.selectedRegionTileY;
                                                secretPacketBuffer1.putOpcode(96);
                                                secretPacketBuffer1.putByte(5);
                                                secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?(KeyFocusListener.field659[81]?2:1):0);
                                                secretPacketBuffer1.putShort(var5 + class266.baseY);
                                                secretPacketBuffer1.putShort(var4 + KeyFocusListener.baseX);
                                                Region.method2832();
                                                field1190 = MouseInput.field747;
                                                field1034 = MouseInput.field756;
                                                cursorState = 1;
                                                field967 = 0;
                                                destinationX = var4;
                                                destinationY = var5;
                                             }

                                             if(var28 != KitDefinition.field3371) {
                                                if(var28 != null) {
                                                   class88.method1714(var28);
                                                }

                                                if(KitDefinition.field3371 != null) {
                                                   class88.method1714(KitDefinition.field3371);
                                                }
                                             }

                                             if(var25 != PendingSpawn.field1211 && field1079 == field1054) {
                                                if(var25 != null) {
                                                   class88.method1714(var25);
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

                                             var4 = field1072 + XItemContainer.localPlayer.x;
                                             var5 = field1033 + XItemContainer.localPlayer.y;
                                             if(Ignore.field860 - var4 < -500 || Ignore.field860 - var4 > 500 || class31.field456 - var5 < -500 || class31.field456 - var5 > 500) {
                                                Ignore.field860 = var4;
                                                class31.field456 = var5;
                                             }

                                             if(var4 != Ignore.field860) {
                                                Ignore.field860 += (var4 - Ignore.field860) / 16;
                                             }

                                             if(var5 != class31.field456) {
                                                class31.field456 += (var5 - class31.field456) / 16;
                                             }

                                             if(MouseInput.field754 == 4 && class34.field499) {
                                                var6 = MouseInput.field749 - field1055;
                                                field1195 = var6 * 2;
                                                field1055 = var6 != -1 && var6 != 1?(MouseInput.field749 + field1055) / 2:MouseInput.field749;
                                                var7 = field1013 - MouseInput.field748;
                                                field1148 = var7 * 2;
                                                field1013 = var7 != -1 && var7 != 1?(field1013 + MouseInput.field748) / 2:MouseInput.field748;
                                             } else {
                                                if(KeyFocusListener.field659[96]) {
                                                   field1148 += (-24 - field1148) / 2;
                                                } else if(KeyFocusListener.field659[97]) {
                                                   field1148 += (24 - field1148) / 2;
                                                } else {
                                                   field1148 /= 2;
                                                }

                                                if(KeyFocusListener.field659[98]) {
                                                   field1195 += (12 - field1195) / 2;
                                                } else if(KeyFocusListener.field659[99]) {
                                                   field1195 += (-12 - field1195) / 2;
                                                } else {
                                                   field1195 /= 2;
                                                }

                                                field1055 = MouseInput.field749;
                                                field1013 = MouseInput.field748;
                                             }

                                             mapAngle = field1148 / 2 + mapAngle & 2047;
                                             field1052 += field1195 / 2;
                                             if(field1052 < 128) {
                                                field1052 = 128;
                                             }

                                             if(field1052 > 383) {
                                                field1052 = 383;
                                             }

                                             var6 = Ignore.field860 >> 7;
                                             var7 = class31.field456 >> 7;
                                             var8 = WorldMapData.getTileHeight(Ignore.field860, class31.field456, WallObject.plane);
                                             var9 = 0;
                                             if(var6 > 3 && var7 > 3 && var6 < 100 && var7 < 100) {
                                                for(var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                   for(int var33 = var7 - 4; var33 <= var7 + 4; ++var33) {
                                                      int var35 = WallObject.plane;
                                                      if(var35 < 3 && (class61.tileSettings[1][var10][var33] & 2) == 2) {
                                                         ++var35;
                                                      }

                                                      int var18 = var8 - class61.tileHeights[var35][var10][var33];
                                                      if(var18 > var9) {
                                                         var9 = var18;
                                                      }
                                                   }
                                                }
                                             }

                                             var10 = var9 * 192;
                                             if(var10 > 98048) {
                                                var10 = 98048;
                                             }

                                             if(var10 < '耀') {
                                                var10 = '耀';
                                             }

                                             if(var10 > field1018) {
                                                field1018 += (var10 - field1018) / 24;
                                             } else if(var10 < field1018) {
                                                field1018 += (var10 - field1018) / 80;
                                             }

                                             if(field1173) {
                                                class66.method1120();
                                             }

                                             for(var4 = 0; var4 < 5; ++var4) {
                                                ++field1178[var4];
                                             }

                                             class71.chatMessages.process();
                                             var4 = FrameMap.method2662();
                                             var5 = class60.method1047();
                                             if(var4 > 15000 && var5 > 15000) {
                                                field978 = 250;
                                                class83.method1674(14500);
                                                secretPacketBuffer1.putOpcode(224);
                                             }

                                             ++field991;
                                             if(field991 > 500) {
                                                field991 = 0;
                                                var6 = (int)(Math.random() * 8.0D);
                                                if((var6 & 1) == 1) {
                                                   field1072 += field1135;
                                                }

                                                if((var6 & 2) == 2) {
                                                   field1033 += field993;
                                                }

                                                if((var6 & 4) == 4) {
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
                                                var6 = (int)(Math.random() * 8.0D);
                                                if((var6 & 1) == 1) {
                                                   mapScale += mapOffset;
                                                }

                                                if((var6 & 2) == 2) {
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

                                             for(class67 var34 = (class67)field1029.method3612(); var34 != null; var34 = (class67)field1029.method3607()) {
                                                if((long)var34.field836 < DState.currentTimeMs() / 1000L - 5L) {
                                                   if(var34.field837 > 0) {
                                                      class152.sendGameMessage(5, "", var34.field841 + " has logged in.");
                                                   }

                                                   if(var34.field837 == 0) {
                                                      class152.sendGameMessage(5, "", var34.field841 + " has logged out.");
                                                   }

                                                   var34.method3615();
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
                                             } catch (IOException var19) {
                                                class13.method60();
                                             }

                                             return;
                                          }

                                          var15 = var14.widget;
                                          if(var15.index < 0) {
                                             break;
                                          }

                                          var31 = PacketBuffer.method3403(var15.parentId);
                                       } while(var31 == null || var31.children == null || var15.index >= var31.children.length || var31.children[var15.index] != var15);

                                       class14.method76(var14);
                                    }
                                 }

                                 var15 = var14.widget;
                                 if(var15.index < 0) {
                                    break;
                                 }

                                 var31 = PacketBuffer.method3403(var15.parentId);
                              } while(var31 == null || var31.children == null || var15.index >= var31.children.length || var31.children[var15.index] != var15);

                              class14.method76(var14);
                           }
                        }

                        var15 = var14.widget;
                        if(var15.index < 0) {
                           break;
                        }

                        var31 = PacketBuffer.method3403(var15.parentId);
                     } while(var31 == null || var31.children == null || var15.index >= var31.children.length || var31.children[var15.index] != var15);

                     class14.method76(var14);
                  }
               }

               class13.method60();
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
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class238.field3278 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field955 = 3000;
            class238.field3278 = 3;
         }

         if(--field955 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  class89.socket = GameEngine.taskManager.createSocket(DState.host, class96.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(class89.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(class89.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  FileOnDisk.rssocket = new RSSocket((Socket)class89.socket.value, GameEngine.taskManager);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(148);
                  FileOnDisk.rssocket.queueForWrite(var1.payload, 0, 5);
                  ++js5State;
                  class12.field272 = DState.currentTimeMs();
               }

               if(js5State == 3) {
                  if(gameState > 5 && FileOnDisk.rssocket.available() <= 0) {
                     if(DState.currentTimeMs() - class12.field272 > 30000L) {
                        this.error(-2);
                        return;
                     }
                  } else {
                     int var10 = FileOnDisk.rssocket.readByte();
                     if(var10 != 0) {
                        this.error(var10);
                        return;
                     }

                     ++js5State;
                  }
               }

               if(js5State == 4) {
                  RSSocket var11 = FileOnDisk.rssocket;
                  boolean var2 = gameState > 20;
                  if(class238.field3272 != null) {
                     try {
                        class238.field3272.close();
                     } catch (Exception var8) {
                        ;
                     }

                     class238.field3272 = null;
                  }

                  class238.field3272 = var11;
                  class170.sendConInfo(var2);
                  class238.field3264.offset = 0;
                  class7.currentRequest = null;
                  class39.field559 = null;
                  class238.field3273 = 0;

                  while(true) {
                     FileRequest var3 = (FileRequest)class238.field3275.method3533();
                     if(var3 == null) {
                        while(true) {
                           var3 = (FileRequest)class238.field3270.method3533();
                           if(var3 == null) {
                              if(class238.field3276 != 0) {
                                 try {
                                    Buffer var4 = new Buffer(4);
                                    var4.putByte(4);
                                    var4.putByte(class238.field3276);
                                    var4.putShort(0);
                                    class238.field3272.queueForWrite(var4.payload, 0, 4);
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
                              class238.field3263 = DState.currentTimeMs();
                              class89.socket = null;
                              FileOnDisk.rssocket = null;
                              js5State = 0;
                              field956 = 0;
                              return;
                           }

                           class238.field3267.setHead(var3);
                           class238.field3268.put(var3, var3.hash);
                           ++class238.field3269;
                           --class238.field3271;
                        }
                     }

                     class238.field3260.put(var3, var3.hash);
                     ++class238.field3266;
                     --class238.field3265;
                  }
               }
            } catch (IOException var9) {
               this.error(-3);
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

      if(class8.settings != null) {
         try {
            Client var3 = class261.clientInstance;
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
         if(class66.loadWidget(var1)) {
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

      Rasterizer2D.noClip();
      if(!isMenuOpen) {
         if(field1076 != -1) {
            var1 = field1076;
            int var2 = field1003;
            if(menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) {
               int var3 = class2.method7();
               String var4;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var4 = "Use " + selectedItemName + " ->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var4 = field1078 + " " + field1159 + " ->";
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
                  var4 = var4 + class220.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
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
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1133[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
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
         String var1;
         int var2;
         try {
            int var3 = class244.rssocket.available();
            if(var3 == 0) {
               return false;
            }

            if(packetType == -1) {
               class244.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               packetLength = class272.field3709[packetType];
               --var3;
            }

            if(packetLength == -1) {
               if(var3 <= 0) {
                  return false;
               }

               class244.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               packetLength = secretPacketBuffer2.payload[0] & 255;
               --var3;
            }

            if(packetLength == -2) {
               if(var3 <= 1) {
                  return false;
               }

               class244.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();
               var3 -= 2;
            }

            if(var3 < packetLength) {
               return false;
            }

            secretPacketBuffer2.offset = 0;
            class244.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
            field973 = 0;
            thridLastFrameId = secondLastFrameId;
            secondLastFrameId = lastFrameId * -1;
            lastFrameId = packetType * -1;
            int var4;
            if(packetType == 51) {
               field1173 = false;

               for(var4 = 0; var4 < 5; ++var4) {
                  field1174[var4] = false;
               }

               packetType = -1;
               return true;
            }

            Widget var5;
            if(packetType == 136) {
               var4 = secretPacketBuffer2.method3190();
               var5 = PacketBuffer.method3403(var4);
               var5.modelType = 3;
               var5.modelId = XItemContainer.localPlayer.composition.method3938();
               class88.method1714(var5);
               packetType = -1;
               return true;
            }

            int var6;
            int var7;
            int var8;
            boolean var9;
            boolean var10;
            if(packetType == 228) {
               var1 = secretPacketBuffer2.readString();
               var2 = secretPacketBuffer2.readUnsignedShort();
               byte var57 = secretPacketBuffer2.readByte();
               var9 = false;
               if(var57 == -128) {
                  var9 = true;
               }

               if(var9) {
                  if(class28.clanChatCount == 0) {
                     packetType = -1;
                     return true;
                  }

                  var10 = false;

                  for(var6 = 0; var6 < class28.clanChatCount && (!class11.clanMembers[var6].username.equals(var1) || var2 != class11.clanMembers[var6].world); ++var6) {
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
                  XClanMember var54 = new XClanMember();
                  var54.username = var1;
                  var54.field919 = Player.method1179(var54.username, field928);
                  var54.world = var2;
                  var54.rank = var57;

                  for(var7 = class28.clanChatCount - 1; var7 >= 0; --var7) {
                     var8 = class11.clanMembers[var7].field919.compareTo(var54.field919);
                     if(var8 == 0) {
                        class11.clanMembers[var7].world = var2;
                        class11.clanMembers[var7].rank = var57;
                        if(var1.equals(XItemContainer.localPlayer.name)) {
                           class35.clanChatRank = var57;
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

                  class11.clanMembers[var7 + 1] = var54;
                  ++class28.clanChatCount;
                  if(var1.equals(XItemContainer.localPlayer.name)) {
                     class35.clanChatRank = var57;
                  }
               }

               field1121 = field1112;
               packetType = -1;
               return true;
            }

            if(packetType == 118) {
               for(var4 = 0; var4 < class211.widgetSettings.length; ++var4) {
                  if(class211.widgetSettings[var4] != class211.settings[var4]) {
                     class211.widgetSettings[var4] = class211.settings[var4];
                     Preferences.method1614(var4);
                     field1113[++field975 - 1 & 31] = var4;
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
                  class60.cameraZ = WorldMapData.getTileHeight(class155.cameraX, class157.cameraY, WallObject.plane) - class95.field1515;
               }

               packetType = -1;
               return true;
            }

            int var11;
            int var12;
            if(packetType == 200) {
               var4 = secretPacketBuffer2.readUnsignedByte();
               var2 = secretPacketBuffer2.readUnsignedByte();
               var11 = secretPacketBuffer2.readUnsignedByte();
               var12 = secretPacketBuffer2.readUnsignedByte();
               field1174[var4] = true;
               field1164[var4] = var2;
               field996[var4] = var11;
               field1177[var4] = var12;
               field1178[var4] = 0;
               packetType = -1;
               return true;
            }

            Widget var13;
            if(packetType == 106) {
               var4 = secretPacketBuffer2.readUnsignedShort();
               var2 = secretPacketBuffer2.readInt();
               var11 = secretPacketBuffer2.readUnsignedShortOb1();
               var12 = secretPacketBuffer2.method3318();
               var13 = PacketBuffer.method3403(var2);
               if(var13.rotationX != var4 || var13.rotationZ != var11 || var13.modelZoom != var12) {
                  var13.rotationX = var4;
                  var13.rotationZ = var11;
                  var13.modelZoom = var12;
                  class88.method1714(var13);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 67) {
               var1 = secretPacketBuffer2.readString();
               Object[] var53 = new Object[var1.length() + 1];

               for(var11 = var1.length() - 1; var11 >= 0; --var11) {
                  if(var1.charAt(var11) == 115) {
                     var53[var11 + 1] = secretPacketBuffer2.readString();
                  } else {
                     var53[var11 + 1] = new Integer(secretPacketBuffer2.readInt());
                  }
               }

               var53[0] = new Integer(secretPacketBuffer2.readInt());
               ScriptEvent var55 = new ScriptEvent();
               var55.field857 = var53;
               class14.method76(var55);
               packetType = -1;
               return true;
            }

            if(packetType == 41) {
               var4 = secretPacketBuffer2.readUnsignedShort();
               var2 = secretPacketBuffer2.readUnsignedByte();
               var11 = secretPacketBuffer2.readUnsignedShort();
               class34.method356(var4, var2, var11);
               packetType = -1;
               return true;
            }

            if(packetType == 245) {
               method1525();

               for(var4 = 0; var4 < 2048; ++var4) {
                  cachedPlayers[var4] = null;
               }

               class17.initializeGPI(secretPacketBuffer2);
               packetType = -1;
               return true;
            }

            if(packetType == 174) {
               var4 = secretPacketBuffer2.readUnsignedByte();
               if(secretPacketBuffer2.readUnsignedByte() == 0) {
                  grandExchangeOffers[var4] = new XGrandExchangeOffer();
                  secretPacketBuffer2.offset += 18;
               } else {
                  --secretPacketBuffer2.offset;
                  grandExchangeOffers[var4] = new XGrandExchangeOffer(secretPacketBuffer2, false);
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
               MilliTimer.field2223 = secretPacketBuffer2.readUnsignedByte();
               if(MilliTimer.field2223 >= 100) {
                  var4 = class66.field832 * 128 + 64;
                  var2 = ISAACCipher.field2438 * 128 + 64;
                  var11 = WorldMapData.getTileHeight(var4, var2, WallObject.plane) - IndexFile.field2289;
                  var12 = var4 - class155.cameraX;
                  var6 = var11 - class60.cameraZ;
                  var7 = var2 - class157.cameraY;
                  var8 = (int)Math.sqrt((double)(var12 * var12 + var7 * var7));
                  Player.cameraPitch = (int)(Math.atan2((double)var6, (double)var8) * 325.949D) & 2047;
                  class22.cameraYaw = (int)(Math.atan2((double)var12, (double)var7) * -325.949D) & 2047;
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

               for(var4 = Player.field900; var4 < Player.field900 + 8; ++var4) {
                  for(var2 = class29.field428; var2 < class29.field428 + 8; ++var2) {
                     if(groundItemDeque[WallObject.plane][var4][var2] != null) {
                        groundItemDeque[WallObject.plane][var4][var2] = null;
                        Occluder.groundItemSpawned(var4, var2);
                     }
                  }
               }

               for(PendingSpawn var52 = (PendingSpawn)pendingSpawns.getFront(); var52 != null; var52 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var52.x >= Player.field900 && var52.x < Player.field900 + 8 && var52.y >= class29.field428 && var52.y < class29.field428 + 8 && var52.level == WallObject.plane) {
                     var52.hitpoints = 0;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 29) {
               ScriptEvent.method1135();
               energy = secretPacketBuffer2.readUnsignedByte();
               field1124 = field1112;
               packetType = -1;
               return true;
            }

            boolean var14;
            if(packetType == 95) {
               var14 = secretPacketBuffer2.readUnsignedByte() == 1;
               if(var14) {
                  class43.field599 = DState.currentTimeMs() - secretPacketBuffer2.readLong();
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
               for(var4 = 0; var4 < cachedPlayers.length; ++var4) {
                  if(cachedPlayers[var4] != null) {
                     cachedPlayers[var4].animation = -1;
                  }
               }

               for(var4 = 0; var4 < cachedNPCs.length; ++var4) {
                  if(cachedNPCs[var4] != null) {
                     cachedNPCs[var4].animation = -1;
                  }
               }

               packetType = -1;
               return true;
            }

            String var15;
            if(packetType == 21) {
               var4 = secretPacketBuffer2.method3173();
               var15 = secretPacketBuffer2.readString();
               var11 = secretPacketBuffer2.readUnsignedByte();
               if(var11 >= 1 && var11 <= 8) {
                  if(var15.equalsIgnoreCase("null")) {
                     var15 = null;
                  }

                  playerOptions[var11 - 1] = var15;
                  playerOptionsPriorities[var11 - 1] = var4 == 0;
               }

               packetType = -1;
               return true;
            }

            Widget var16;
            if(packetType == 201) {
               var4 = secretPacketBuffer2.readIntOb3();
               var2 = secretPacketBuffer2.method3318();
               var16 = PacketBuffer.method3403(var4);
               if(var16.modelType != 2 || var2 != var16.modelId) {
                  var16.modelType = 2;
                  var16.modelId = var2;
                  class88.method1714(var16);
               }

               packetType = -1;
               return true;
            }

            Widget var17;
            if(packetType == 151) {
               var4 = secretPacketBuffer2.readUnsignedShortOb1();
               var2 = secretPacketBuffer2.method3190();
               var11 = secretPacketBuffer2.method3318();
               var17 = PacketBuffer.method3403(var2);
               var17.field2710 = var11 + (var4 << 16);
               packetType = -1;
               return true;
            }

            if(packetType == 141) {
               var4 = secretPacketBuffer2.readShortOb3();
               var2 = secretPacketBuffer2.readShortOb3();
               var11 = secretPacketBuffer2.readInt();
               var17 = PacketBuffer.method3403(var11);
               if(var17.originalX != var4 || var2 != var17.originalY || var17.field2659 != 0 || var17.field2660 != 0) {
                  var17.originalX = var4;
                  var17.originalY = var2;
                  var17.field2659 = 0;
                  var17.field2660 = 0;
                  class88.method1714(var17);
                  this.method1343(var17);
                  if(var17.type == 0) {
                     WorldMapType2.method546(class46.widgets[var11 >> 16], var17, false);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 111) {
               var1 = secretPacketBuffer2.readString();
               var2 = secretPacketBuffer2.method3190();
               var16 = PacketBuffer.method3403(var2);
               if(!var1.equals(var16.text)) {
                  var16.text = var1;
                  class88.method1714(var16);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 195) {
               var4 = secretPacketBuffer2.method3190();
               class20.field339 = GameEngine.taskManager.createHost(var4);
               packetType = -1;
               return true;
            }

            if(packetType == 107) {
               var4 = secretPacketBuffer2.readUnsignedShort();
               XItemContainer var56 = (XItemContainer)XItemContainer.itemContainers.get((long)var4);
               if(var56 != null) {
                  var56.unlink();
               }

               interfaceItemTriggers[++field1116 - 1 & 31] = var4 & 32767;
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

            int var18;
            long var19;
            WidgetNode var21;
            WidgetNode var58;
            if(packetType == 17) {
               var4 = packetLength + secretPacketBuffer2.offset;
               var2 = secretPacketBuffer2.readUnsignedShort();
               var11 = secretPacketBuffer2.readUnsignedShort();
               if(var2 != widgetRoot) {
                  widgetRoot = var2;
                  this.method1201(false);
                  class222.method4070(widgetRoot);
                  Ignore.method1136(widgetRoot);

                  for(var12 = 0; var12 < 100; ++var12) {
                     field1132[var12] = true;
                  }
               }

               for(; var11-- > 0; var58.field845 = true) {
                  var12 = secretPacketBuffer2.readInt();
                  var6 = secretPacketBuffer2.readUnsignedShort();
                  var7 = secretPacketBuffer2.readUnsignedByte();
                  var58 = (WidgetNode)componentTable.get((long)var12);
                  if(var58 != null && var58.id != var6) {
                     class95.method1780(var58, true);
                     var58 = null;
                  }

                  if(var58 == null) {
                     var58 = class29.method233(var12, var6, var7);
                  }
               }

               for(var21 = (WidgetNode)componentTable.method3533(); var21 != null; var21 = (WidgetNode)componentTable.method3538()) {
                  if(var21.field845) {
                     var21.field845 = false;
                  } else {
                     class95.method1780(var21, true);
                  }
               }

               widgetFlags = new XHashTable(512);

               while(secretPacketBuffer2.offset < var4) {
                  var12 = secretPacketBuffer2.readInt();
                  var6 = secretPacketBuffer2.readUnsignedShort();
                  var7 = secretPacketBuffer2.readUnsignedShort();
                  var8 = secretPacketBuffer2.readInt();

                  for(var18 = var6; var18 <= var7; ++var18) {
                     var19 = (long)var18 + ((long)var12 << 32);
                     widgetFlags.put(new WidgetConfig(var8), var19);
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
               var4 = secretPacketBuffer2.method3190();
               var2 = secretPacketBuffer2.method3190();
               var58 = (WidgetNode)componentTable.get((long)var2);
               var21 = (WidgetNode)componentTable.get((long)var4);
               if(var21 != null) {
                  class95.method1780(var21, var58 == null || var21.id != var58.id);
               }

               if(var58 != null) {
                  var58.unlink();
                  componentTable.put(var58, (long)var4);
               }

               var13 = PacketBuffer.method3403(var2);
               if(var13 != null) {
                  class88.method1714(var13);
               }

               var13 = PacketBuffer.method3403(var4);
               if(var13 != null) {
                  class88.method1714(var13);
                  WorldMapType2.method546(class46.widgets[var13.id >>> 16], var13, true);
               }

               if(widgetRoot != -1) {
                  var7 = widgetRoot;
                  if(class66.loadWidget(var7)) {
                     class5.method22(class46.widgets[var7], 1);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 15) {
               secretPacketBuffer2.offset += 28;
               if(secretPacketBuffer2.checkCrc()) {
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

            int var22;
            int var23;
            long var24;
            long var26;
            long var28;
            String var35;
            if(packetType == 163) {
               var1 = secretPacketBuffer2.readString();
               var24 = (long)secretPacketBuffer2.readUnsignedShort();
               var26 = (long)secretPacketBuffer2.read24BitInt();
               Permission var60 = (Permission)class134.forOrdinal(Widget.method4032(), secretPacketBuffer2.readUnsignedByte());
               var28 = (var24 << 32) + var26;
               boolean var31 = false;

               for(var22 = 0; var22 < 100; ++var22) {
                  if(field1146[var22] == var28) {
                     var31 = true;
                     break;
                  }
               }

               if(class1.isIgnored(var1)) {
                  var31 = true;
               }

               if(!var31 && field1045 == 0) {
                  field1146[field1147] = var28;
                  field1147 = (field1147 + 1) % 100;
                  PacketBuffer var63 = secretPacketBuffer2;

                  String var65;
                  try {
                     var23 = var63.getUSmart();
                     if(var23 > 32767) {
                        var23 = 32767;
                     }

                     byte[] var67 = new byte[var23];
                     var63.offset += class265.field3665.decompress(var63.payload, var63.offset, var67, 0, var23);
                     var35 = class48.getString(var67, 0, var23);
                     var65 = var35;
                  } catch (Exception var48) {
                     var65 = "Cabbage";
                  }

                  var65 = FontTypeFace.appendTags(FaceNormal.method2870(var65));
                  byte var68;
                  if(var60.field3184) {
                     var68 = 7;
                  } else {
                     var68 = 3;
                  }

                  if(var60.field3186 != -1) {
                     class152.sendGameMessage(var68, class41.method609(var60.field3186) + var1, var65);
                  } else {
                     class152.sendGameMessage(var68, var1, var65);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 235) {
               byte var59 = secretPacketBuffer2.method3207();
               var2 = secretPacketBuffer2.method3318();
               class211.settings[var2] = var59;
               if(var59 != class211.widgetSettings[var2]) {
                  class211.widgetSettings[var2] = var59;
               }

               Preferences.method1614(var2);
               field1113[++field975 - 1 & 31] = var2;
               packetType = -1;
               return true;
            }

            if(packetType == 105) {
               var4 = secretPacketBuffer2.readUnsignedShortOb1();
               var2 = secretPacketBuffer2.readIntOb3();
               class211.settings[var4] = var2;
               if(var2 != class211.widgetSettings[var4]) {
                  class211.widgetSettings[var4] = var2;
               }

               Preferences.method1614(var4);
               field1113[++field975 - 1 & 31] = var4;
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
               var4 = secretPacketBuffer2.method3175();
               var5 = PacketBuffer.method3403(var4);

               for(var11 = 0; var11 < var5.itemIds.length; ++var11) {
                  var5.itemIds[var11] = -1;
                  var5.itemIds[var11] = 0;
               }

               class88.method1714(var5);
               packetType = -1;
               return true;
            }

            if(packetType == 72) {
               ScriptEvent.method1135();
               var4 = secretPacketBuffer2.readInt();
               var2 = secretPacketBuffer2.readUnsignedByte();
               var11 = secretPacketBuffer2.method3173();
               skillExperiences[var2] = var4;
               boostedSkillLevels[var2] = var11;
               realSkillLevels[var2] = 1;

               for(var12 = 0; var12 < 98; ++var12) {
                  if(var4 >= class222.field2845[var12]) {
                     realSkillLevels[var2] = var12 + 2;
                  }
               }

               field1117[++field1067 - 1 & 31] = var2;
               packetType = -1;
               return true;
            }

            long var30;
            if(packetType == 196) {
               var4 = secretPacketBuffer2.readInt();
               var2 = secretPacketBuffer2.readInt();
               if(class39.field558 == null || !class39.field558.isValid()) {
                  try {
                     Iterator var61 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var61.hasNext()) {
                        GarbageCollectorMXBean var64 = (GarbageCollectorMXBean)var61.next();
                        if(var64.isValid()) {
                           class39.field558 = var64;
                           field1203 = -1L;
                           field1120 = -1L;
                        }
                     }
                  } catch (Throwable var49) {
                     ;
                  }
               }

               long var62 = DState.currentTimeMs();
               var6 = -1;
               if(class39.field558 != null) {
                  var30 = class39.field558.getCollectionTime();
                  if(-1L != field1120) {
                     long var66 = var30 - field1120;
                     long var69 = var62 - field1203;
                     if(0L != var69) {
                        var6 = (int)(100L * var66 / var69);
                     }
                  }

                  field1120 = var30;
                  field1203 = var62;
               }

               secretPacketBuffer1.putOpcode(174);
               secretPacketBuffer1.method3265(var6);
               secretPacketBuffer1.putInt(var4);
               secretPacketBuffer1.method3233(var2);
               secretPacketBuffer1.method3265(GameEngine.FPS);
               packetType = -1;
               return true;
            }

            int var32;
            int var33;
            boolean var34;
            PacketBuffer var36;
            String var37;
            if(packetType == 238) {
               var1 = secretPacketBuffer2.readString();
               var24 = secretPacketBuffer2.readLong();
               var26 = (long)secretPacketBuffer2.readUnsignedShort();
               var30 = (long)secretPacketBuffer2.read24BitInt();
               Permission var71 = (Permission)class134.forOrdinal(Widget.method4032(), secretPacketBuffer2.readUnsignedByte());
               var19 = var30 + (var26 << 32);
               var34 = false;

               for(var32 = 0; var32 < 100; ++var32) {
                  if(field1146[var32] == var19) {
                     var34 = true;
                     break;
                  }
               }

               if(var71.field3188 && class1.isIgnored(var1)) {
                  var34 = true;
               }

               if(!var34 && field1045 == 0) {
                  field1146[field1147] = var19;
                  field1147 = (field1147 + 1) % 100;
                  var36 = secretPacketBuffer2;

                  try {
                     var33 = var36.getUSmart();
                     if(var33 > 32767) {
                        var33 = 32767;
                     }

                     byte[] var73 = new byte[var33];
                     var36.offset += class265.field3665.decompress(var36.payload, var36.offset, var73, 0, var33);
                     String var84 = class48.getString(var73, 0, var33);
                     var37 = var84;
                  } catch (Exception var47) {
                     var37 = "Cabbage";
                  }

                  var37 = FontTypeFace.appendTags(FaceNormal.method2870(var37));
                  if(var71.field3186 != -1) {
                     WorldMapData.addChatMessage(9, class41.method609(var71.field3186) + var1, var37, class56.method850(var24));
                  } else {
                     WorldMapData.addChatMessage(9, var1, var37, class56.method850(var24));
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 119) {
               var4 = secretPacketBuffer2.readInt();
               var2 = secretPacketBuffer2.readByteOb1();
               var11 = var2 >> 10 & 31;
               var12 = var2 >> 5 & 31;
               var6 = var2 & 31;
               var7 = (var12 << 11) + (var11 << 19) + (var6 << 3);
               Widget var70 = PacketBuffer.method3403(var4);
               if(var70.textColor != var7) {
                  var70.textColor = var7;
                  class88.method1714(var70);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 220) {
               var4 = secretPacketBuffer2.readInt();
               var2 = secretPacketBuffer2.readUnsignedShort();
               if(var4 < -70000) {
                  var2 += '耀';
               }

               if(var4 >= 0) {
                  var16 = PacketBuffer.method3403(var4);
               } else {
                  var16 = null;
               }

               for(; secretPacketBuffer2.offset < packetLength; PendingSpawn.setItemTableSlot(var2, var12, var6 - 1, var7)) {
                  var12 = secretPacketBuffer2.getUSmart();
                  var6 = secretPacketBuffer2.readUnsignedShort();
                  var7 = 0;
                  if(var6 != 0) {
                     var7 = secretPacketBuffer2.readUnsignedByte();
                     if(var7 == 255) {
                        var7 = secretPacketBuffer2.readInt();
                     }
                  }

                  if(var16 != null && var12 >= 0 && var12 < var16.itemIds.length) {
                     var16.itemIds[var12] = var6;
                     var16.itemQuantities[var12] = var7;
                  }
               }

               if(var16 != null) {
                  class88.method1714(var16);
               }

               ScriptEvent.method1135();
               interfaceItemTriggers[++field1116 - 1 & 31] = var2 & 32767;
               packetType = -1;
               return true;
            }

            if(packetType == 30) {
               var1 = secretPacketBuffer2.readString();
               var36 = secretPacketBuffer2;

               try {
                  var6 = var36.getUSmart();
                  if(var6 > 32767) {
                     var6 = 32767;
                  }

                  byte[] var74 = new byte[var6];
                  var36.offset += class265.field3665.decompress(var36.payload, var36.offset, var74, 0, var6);
                  String var72 = class48.getString(var74, 0, var6);
                  var35 = var72;
               } catch (Exception var46) {
                  var35 = "Cabbage";
               }

               var35 = FontTypeFace.appendTags(FaceNormal.method2870(var35));
               class152.sendGameMessage(6, var1, var35);
               packetType = -1;
               return true;
            }

            if(packetType == 159) {
               var4 = secretPacketBuffer2.method3318();
               var2 = secretPacketBuffer2.readIntOb3();
               var11 = secretPacketBuffer2.method3173();
               var21 = (WidgetNode)componentTable.get((long)var2);
               if(var21 != null) {
                  class95.method1780(var21, var21.id != var4);
               }

               class29.method233(var2, var4, var11);
               packetType = -1;
               return true;
            }

            if(packetType == 214) {
               class239.decodeClassVerifier(secretPacketBuffer2, packetLength);
               packetType = -1;
               return true;
            }

            if(packetType == 166) {
               class1.xteaChanged(true);
               secretPacketBuffer2.readOpcode();
               var4 = secretPacketBuffer2.readUnsignedShort();
               var36 = secretPacketBuffer2;
               var11 = var36.offset;
               class96.field1525 = 0;
               class90.decodeLocationUpdates(var36);
               Preferences.updatePlayersFlag(var36);
               if(var4 != var36.offset - var11) {
                  throw new RuntimeException(var36.offset - var11 + " " + var4);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 7) {
               if(widgetRoot != -1) {
                  var4 = widgetRoot;
                  if(class66.loadWidget(var4)) {
                     class5.method22(class46.widgets[var4], 0);
                  }
               }

               packetType = -1;
               return true;
            }

            boolean var38;
            if(packetType == 182) {
               while(secretPacketBuffer2.offset < packetLength) {
                  var4 = secretPacketBuffer2.readUnsignedByte();
                  var38 = (var4 & 1) == 1;
                  var37 = secretPacketBuffer2.readString();
                  var35 = secretPacketBuffer2.readString();
                  secretPacketBuffer2.readString();

                  Ignore var80;
                  for(var6 = 0; var6 < ignoreCount; ++var6) {
                     var80 = ignores[var6];
                     if(var38) {
                        if(var35.equals(var80.name)) {
                           var80.name = var37;
                           var80.previousName = var35;
                           var37 = null;
                           break;
                        }
                     } else if(var37.equals(var80.name)) {
                        var80.name = var37;
                        var80.previousName = var35;
                        var37 = null;
                        break;
                     }
                  }

                  if(var37 != null && ignoreCount < 400) {
                     var80 = new Ignore();
                     ignores[ignoreCount] = var80;
                     var80.name = var37;
                     var80.previousName = var35;
                     ++ignoreCount;
                  }
               }

               field1025 = field1112;
               packetType = -1;
               return true;
            }

            if(packetType == 134) {
               var4 = secretPacketBuffer2.readIntOb3();
               var2 = secretPacketBuffer2.readShort();
               var16 = PacketBuffer.method3403(var4);
               if(var2 != var16.field2717 || var2 == -1) {
                  var16.field2717 = var2;
                  var16.field2788 = 0;
                  var16.field2777 = 0;
                  class88.method1714(var16);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 96) {
               PacketBuffer var78 = secretPacketBuffer2;
               var2 = packetLength;
               var11 = var78.offset;
               class96.field1525 = 0;
               class90.decodeLocationUpdates(var78);
               Preferences.updatePlayersFlag(var78);
               if(var2 != var78.offset - var11) {
                  throw new RuntimeException(var78.offset - var11 + " " + var2);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 14) {
               var4 = secretPacketBuffer2.readIntOb3();
               var2 = secretPacketBuffer2.method3190();
               var11 = secretPacketBuffer2.readUnsignedShort();
               if(var11 == '\uffff') {
                  var11 = -1;
               }

               var17 = PacketBuffer.method3403(var4);
               ItemComposition var76;
               if(!var17.hasScript) {
                  if(var11 == -1) {
                     var17.modelType = 0;
                     packetType = -1;
                     return true;
                  }

                  var76 = AbstractByteBuffer.getItemDefinition(var11);
                  var17.modelType = 4;
                  var17.modelId = var11;
                  var17.rotationX = var76.xan2d;
                  var17.rotationZ = var76.yan2d;
                  var17.modelZoom = var76.zoom2d * 100 / var2;
                  class88.method1714(var17);
               } else {
                  var17.itemId = var11;
                  var17.itemQuantity = var2;
                  var76 = AbstractByteBuffer.getItemDefinition(var11);
                  var17.rotationX = var76.xan2d;
                  var17.rotationZ = var76.yan2d;
                  var17.rotationY = var76.zan2d;
                  var17.field2703 = var76.offsetX2d;
                  var17.field2704 = var76.offsetY2d;
                  var17.modelZoom = var76.zoom2d;
                  if(var76.isStackable == 1) {
                     var17.field2784 = 1;
                  } else {
                     var17.field2784 = 2;
                  }

                  if(var17.field2709 > 0) {
                     var17.modelZoom = var17.modelZoom * 32 / var17.field2709;
                  } else if(var17.originalWidth > 0) {
                     var17.modelZoom = var17.modelZoom * 32 / var17.originalWidth;
                  }

                  class88.method1714(var17);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 24) {
               var4 = secretPacketBuffer2.readIntOb3();
               var2 = secretPacketBuffer2.readByteOb1();
               var16 = PacketBuffer.method3403(var4);
               if(var16.modelType != 1 || var2 != var16.modelId) {
                  var16.modelType = 1;
                  var16.modelId = var2;
                  class88.method1714(var16);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 218) {
               World var75 = new World();
               var75.address = secretPacketBuffer2.readString();
               var75.id = secretPacketBuffer2.readUnsignedShort();
               var2 = secretPacketBuffer2.readInt();
               var75.mask = var2;
               TextureProvider.setGameState(45);
               class244.rssocket.close();
               class244.rssocket = null;
               class89.method1719(var75);
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
               var4 = secretPacketBuffer2.method3190();
               var38 = secretPacketBuffer2.method3173() == 1;
               var16 = PacketBuffer.method3403(var4);
               if(var38 != var16.isHidden) {
                  var16.isHidden = var38;
                  class88.method1714(var16);
               }

               packetType = -1;
               return true;
            }

            int var39;
            if(packetType == 52) {
               Friend var95;
               while(secretPacketBuffer2.offset < packetLength) {
                  var14 = secretPacketBuffer2.readUnsignedByte() == 1;
                  var15 = secretPacketBuffer2.readString();
                  var37 = secretPacketBuffer2.readString();
                  var12 = secretPacketBuffer2.readUnsignedShort();
                  var6 = secretPacketBuffer2.readUnsignedByte();
                  var7 = secretPacketBuffer2.readUnsignedByte();
                  boolean var81 = (var7 & 2) != 0;
                  boolean var89 = (var7 & 1) != 0;
                  if(var12 > 0) {
                     secretPacketBuffer2.readString();
                     secretPacketBuffer2.readUnsignedByte();
                     secretPacketBuffer2.readInt();
                  }

                  secretPacketBuffer2.readString();

                  for(var39 = 0; var39 < friendCount; ++var39) {
                     var95 = friends[var39];
                     if(!var14) {
                        if(var15.equals(var95.name)) {
                           if(var95.world != var12) {
                              var34 = true;

                              for(class67 var97 = (class67)field1029.method3612(); var97 != null; var97 = (class67)field1029.method3607()) {
                                 if(var97.field841.equals(var15)) {
                                    if(var12 != 0 && var97.field837 == 0) {
                                       var97.method3615();
                                       var34 = false;
                                    } else if(var12 == 0 && var97.field837 != 0) {
                                       var97.method3615();
                                       var34 = false;
                                    }
                                 }
                              }

                              if(var34) {
                                 field1029.method3608(new class67(var15, var12));
                              }

                              var95.world = var12;
                           }

                           var95.previousName = var37;
                           var95.rank = var6;
                           var95.field824 = var81;
                           var95.field825 = var89;
                           var15 = null;
                           break;
                        }
                     } else if(var37.equals(var95.name)) {
                        var95.name = var15;
                        var95.previousName = var37;
                        var15 = null;
                        break;
                     }
                  }

                  if(var15 != null && friendCount < 400) {
                     var95 = new Friend();
                     friends[friendCount] = var95;
                     var95.name = var15;
                     var95.previousName = var37;
                     var95.world = var12;
                     var95.rank = var6;
                     var95.field824 = var81;
                     var95.field825 = var89;
                     ++friendCount;
                  }
               }

               field1193 = 2;
               field1025 = field1112;
               var14 = false;
               var2 = friendCount;

               while(var2 > 0) {
                  var14 = true;
                  --var2;

                  for(var11 = 0; var11 < var2; ++var11) {
                     var9 = false;
                     Friend var83 = friends[var11];
                     Friend var90 = friends[var11 + 1];
                     if(var83.world != world && var90.world == world) {
                        var9 = true;
                     }

                     if(!var9 && var83.world == 0 && var90.world != 0) {
                        var9 = true;
                     }

                     if(!var9 && !var83.field824 && var90.field824) {
                        var9 = true;
                     }

                     if(!var9 && !var83.field825 && var90.field825) {
                        var9 = true;
                     }

                     if(var9) {
                        var95 = friends[var11];
                        friends[var11] = friends[var11 + 1];
                        friends[var11 + 1] = var95;
                        var14 = false;
                     }
                  }

                  if(var14) {
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
               long var79 = secretPacketBuffer2.readLong();
               clanChatOwner = XClanMember.method1182(var79);
               class12.field271 = secretPacketBuffer2.readByte();
               var11 = secretPacketBuffer2.readUnsignedByte();
               if(var11 == 255) {
                  packetType = -1;
                  return true;
               }

               class28.clanChatCount = var11;
               XClanMember[] var94 = new XClanMember[100];

               for(var6 = 0; var6 < class28.clanChatCount; ++var6) {
                  var94[var6] = new XClanMember();
                  var94[var6].username = secretPacketBuffer2.readString();
                  var94[var6].field919 = Player.method1179(var94[var6].username, field928);
                  var94[var6].world = secretPacketBuffer2.readUnsignedShort();
                  var94[var6].rank = secretPacketBuffer2.readByte();
                  secretPacketBuffer2.readString();
                  if(var94[var6].username.equals(XItemContainer.localPlayer.name)) {
                     class35.clanChatRank = var94[var6].rank;
                  }
               }

               var10 = false;
               var8 = class28.clanChatCount;

               while(var8 > 0) {
                  var10 = true;
                  --var8;

                  for(var18 = 0; var18 < var8; ++var18) {
                     if(var94[var18].field919.compareTo(var94[var18 + 1].field919) > 0) {
                        XClanMember var96 = var94[var18];
                        var94[var18] = var94[var18 + 1];
                        var94[var18 + 1] = var96;
                        var10 = false;
                     }
                  }

                  if(var10) {
                     break;
                  }
               }

               class11.clanMembers = var94;
               packetType = -1;
               return true;
            }

            if(packetType == 129) {
               var4 = secretPacketBuffer2.readInt();
               WidgetNode var77 = (WidgetNode)componentTable.get((long)var4);
               if(var77 != null) {
                  class95.method1780(var77, true);
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

            String var40;
            if(packetType == 36) {
               var4 = secretPacketBuffer2.getUSmart();
               var38 = secretPacketBuffer2.readUnsignedByte() == 1;
               var37 = "";
               var9 = false;
               if(var38) {
                  var37 = secretPacketBuffer2.readString();
                  if(class1.isIgnored(var37)) {
                     var9 = true;
                  }
               }

               var40 = secretPacketBuffer2.readString();
               if(!var9) {
                  class152.sendGameMessage(var4, var37, var40);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 239) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               class276[] var87 = new class276[]{class276.field3739, class276.field3737, class276.field3740};
               class276[] var92 = var87;
               var6 = 0;

               class276 var93;
               while(true) {
                  if(var6 >= var92.length) {
                     var93 = null;
                     break;
                  }

                  class276 var44 = var92[var6];
                  if(var2 == var44.field3738) {
                     var93 = var44;
                     break;
                  }

                  ++var6;
               }

               class61.field787 = var93;
               packetType = -1;
               return true;
            }

            if(packetType == 240) {
               var4 = secretPacketBuffer2.method3318();
               widgetRoot = var4;
               this.method1201(false);
               class222.method4070(var4);
               Ignore.method1136(widgetRoot);

               for(var2 = 0; var2 < 100; ++var2) {
                  field1132[var2] = true;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 243) {
               var4 = secretPacketBuffer2.readInt();
               var2 = secretPacketBuffer2.readUnsignedShort();
               var16 = PacketBuffer.method3403(var4);
               if(var16 != null && var16.type == 0) {
                  if(var2 > var16.scrollHeight - var16.height) {
                     var2 = var16.scrollHeight - var16.height;
                  }

                  if(var2 < 0) {
                     var2 = 0;
                  }

                  if(var2 != var16.scrollY) {
                     var16.scrollY = var2;
                     class88.method1714(var16);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 207) {
               var4 = secretPacketBuffer2.readByteOb1();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               class266.method4842(var4);
               packetType = -1;
               return true;
            }

            if(packetType == 46) {
               var4 = secretPacketBuffer2.readUnsignedShort();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               var2 = secretPacketBuffer2.read24BitInt();
               if(field1162 != 0 && var4 != -1) {
                  class29.method232(XGrandExchangeOffer.indexTrack2, var4, 0, field1162, false);
                  field1014 = true;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 237) {
               for(var4 = 0; var4 < VarPlayerType.field3289; ++var4) {
                  VarPlayerType var85 = (VarPlayerType)VarPlayerType.varplayers.get((long)var4);
                  VarPlayerType var88;
                  if(var85 != null) {
                     var88 = var85;
                  } else {
                     byte[] var91 = VarPlayerType.varplayer_ref.getConfigData(16, var4);
                     var85 = new VarPlayerType();
                     if(var91 != null) {
                        var85.decode(new Buffer(var91));
                     }

                     VarPlayerType.varplayers.put(var85, (long)var4);
                     var88 = var85;
                  }

                  if(var88 != null) {
                     class211.settings[var4] = 0;
                     class211.widgetSettings[var4] = 0;
                  }
               }

               ScriptEvent.method1135();
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
               var1 = secretPacketBuffer2.readString();
               sessionToken = var1;

               try {
                  var15 = class261.clientInstance.getParameter(Parameters.field3719.key);
                  var37 = class261.clientInstance.getParameter(Parameters.field3732.key);
                  var35 = var15 + "settings=" + var1 + "; version=1; path=/; domain=" + var37;
                  String var82;
                  if(var1.length() == 0) {
                     var35 = var35 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var40 = var35 + "; Expires=";
                     var28 = DState.currentTimeMs() + 94608000000L;
                     class182.field2446.setTime(new Date(var28));
                     var39 = class182.field2446.get(7);
                     var22 = class182.field2446.get(5);
                     int var42 = class182.field2446.get(2);
                     var32 = class182.field2446.get(1);
                     var23 = class182.field2446.get(11);
                     int var43 = class182.field2446.get(12);
                     var33 = class182.field2446.get(13);
                     var82 = class182.field2443[var39 - 1] + ", " + var22 / 10 + var22 % 10 + "-" + class182.field2444[0][var42] + "-" + var32 + " " + var23 / 10 + var23 % 10 + ":" + var43 / 10 + var43 % 10 + ":" + var33 / 10 + var33 % 10 + " GMT";
                     var35 = var40 + var82 + "; Max-Age=" + 94608000L;
                  }

                  Client var86 = class261.clientInstance;
                  var82 = "document.cookie=\"" + var35 + "\"";
                  JSObject.getWindow(var86).eval(var82);
               } catch (Throwable var45) {
                  ;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 156) {
               class1.xteaChanged(false);
               secretPacketBuffer2.readOpcode();
               var4 = secretPacketBuffer2.readUnsignedShort();
               var36 = secretPacketBuffer2;
               var11 = var36.offset;
               class96.field1525 = 0;
               class90.decodeLocationUpdates(var36);
               Preferences.updatePlayersFlag(var36);
               if(var4 != var36.offset - var11) {
                  throw new RuntimeException(var36.offset - var11 + " " + var4);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 248) {
               var4 = secretPacketBuffer2.method3318();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               var2 = secretPacketBuffer2.readByteOb1();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var11 = secretPacketBuffer2.method3190();
               var12 = secretPacketBuffer2.readInt();

               for(var6 = var4; var6 <= var2; ++var6) {
                  var30 = ((long)var12 << 32) + (long)var6;
                  Node var41 = widgetFlags.get(var30);
                  if(var41 != null) {
                     var41.unlink();
                  }

                  widgetFlags.put(new WidgetConfig(var11), var30);
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
               ScriptEvent.method1135();
               weight = secretPacketBuffer2.readShort();
               field1124 = field1112;
               packetType = -1;
               return true;
            }

            if(packetType == 124) {
               var4 = secretPacketBuffer2.readInt();
               var2 = secretPacketBuffer2.readUnsignedShort();
               if(var4 < -70000) {
                  var2 += '耀';
               }

               if(var4 >= 0) {
                  var16 = PacketBuffer.method3403(var4);
               } else {
                  var16 = null;
               }

               if(var16 != null) {
                  for(var12 = 0; var12 < var16.itemIds.length; ++var12) {
                     var16.itemIds[var12] = 0;
                     var16.itemQuantities[var12] = 0;
                  }
               }

               class243.resetItemTable(var2);
               var12 = secretPacketBuffer2.readUnsignedShort();

               for(var6 = 0; var6 < var12; ++var6) {
                  var7 = secretPacketBuffer2.method3173();
                  if(var7 == 255) {
                     var7 = secretPacketBuffer2.method3190();
                  }

                  var8 = secretPacketBuffer2.readByteOb1();
                  if(var16 != null && var6 < var16.itemIds.length) {
                     var16.itemIds[var6] = var8;
                     var16.itemQuantities[var6] = var7;
                  }

                  PendingSpawn.setItemTableSlot(var2, var6, var8 - 1, var7);
               }

               if(var16 != null) {
                  class88.method1714(var16);
               }

               ScriptEvent.method1135();
               interfaceItemTriggers[++field1116 - 1 & 31] = var2 & 32767;
               packetType = -1;
               return true;
            }

            MilliTimer.method2912("" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength, (Throwable)null);
            class64.method1116();
         } catch (IOException var50) {
            class13.method60();
         } catch (Exception var51) {
            var1 = "" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength + "," + (XItemContainer.localPlayer.pathX[0] + KeyFocusListener.baseX) + "," + (XItemContainer.localPlayer.pathY[0] + class266.baseY) + ",";

            for(var2 = 0; var2 < packetLength && var2 < 50; ++var2) {
               var1 = var1 + secretPacketBuffer2.payload[var2] + ",";
            }

            MilliTimer.method2912(var1, var51);
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
      int var3;
      while(!var1) {
         var1 = true;

         for(var2 = 0; var2 < menuOptionCount - 1; ++var2) {
            if(menuTypes[var2] < 1000 && menuTypes[var2 + 1] > 1000) {
               String var4 = menuTargets[var2];
               menuTargets[var2] = menuTargets[var2 + 1];
               menuTargets[var2 + 1] = var4;
               String var5 = menuOptions[var2];
               menuOptions[var2] = menuOptions[var2 + 1];
               menuOptions[var2 + 1] = var5;
               var3 = menuTypes[var2];
               menuTypes[var2] = menuTypes[var2 + 1];
               menuTypes[var2 + 1] = var3;
               var3 = menuActionParams0[var2];
               menuActionParams0[var2] = menuActionParams0[var2 + 1];
               menuActionParams0[var2 + 1] = var3;
               var3 = menuActionParams1[var2];
               menuActionParams1[var2] = menuActionParams1[var2 + 1];
               menuActionParams1[var2 + 1] = var3;
               var3 = menuIdentifiers[var2];
               menuIdentifiers[var2] = menuIdentifiers[var2 + 1];
               menuIdentifiers[var2 + 1] = var3;
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

      if(class95.field1513 == null && field1100 == null) {
         int var15 = MouseInput.field742;
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         String var13;
         int var16;
         if(isMenuOpen) {
            if(var15 != 1 && (class34.field499 || var15 != 4)) {
               var2 = MouseInput.field748;
               var9 = MouseInput.field749;
               if(var2 < ScriptState.menuX - 10 || var2 > WorldMapType1.menuWidth + ScriptState.menuX + 10 || var9 < Coordinates.menuY - 10 || var9 > MessageNode.menuHeight + Coordinates.menuY + 10) {
                  isMenuOpen = false;
                  Coordinates.method3911(ScriptState.menuX, Coordinates.menuY, WorldMapType1.menuWidth, MessageNode.menuHeight);
               }
            }

            if(var15 == 1 || !class34.field499 && var15 == 4) {
               var2 = ScriptState.menuX;
               var9 = Coordinates.menuY;
               var10 = WorldMapType1.menuWidth;
               var3 = MouseInput.field747;
               var16 = MouseInput.field756;
               int var21 = -1;

               for(var6 = 0; var6 < menuOptionCount; ++var6) {
                  var7 = (menuOptionCount - 1 - var6) * 15 + var9 + 31;
                  if(var3 > var2 && var3 < var2 + var10 && var16 > var7 - 13 && var16 < var7 + 3) {
                     var21 = var6;
                  }
               }

               if(var21 != -1 && var21 >= 0) {
                  var6 = menuActionParams0[var21];
                  var7 = menuActionParams1[var21];
                  int var20 = menuTypes[var21];
                  var8 = menuIdentifiers[var21];
                  var13 = menuOptions[var21];
                  String var23 = menuTargets[var21];
                  Item.menuAction(var6, var7, var20, var8, var13, var23, MouseInput.field747, MouseInput.field756);
               }

               isMenuOpen = false;
               Coordinates.method3911(ScriptState.menuX, Coordinates.menuY, WorldMapType1.menuWidth, MessageNode.menuHeight);
            }
         } else {
            label272: {
               var2 = class2.method7();
               if((var15 == 1 || !class34.field499 && var15 == 4) && var2 >= 0) {
                  var9 = menuTypes[var2];
                  if(var9 == 39 || var9 == 40 || var9 == 41 || var9 == 42 || var9 == 43 || var9 == 33 || var9 == 34 || var9 == 35 || var9 == 36 || var9 == 37 || var9 == 38 || var9 == 1005) {
                     var10 = menuActionParams0[var2];
                     var3 = menuActionParams1[var2];
                     Widget var11 = PacketBuffer.method3403(var3);
                     var6 = WorldMapType3.getWidgetConfig(var11);
                     boolean var12 = (var6 >> 28 & 1) != 0;
                     if(var12) {
                        break label272;
                     }

                     var13 = null;
                     if(class29.method235(WorldMapType3.getWidgetConfig(var11))) {
                        break label272;
                     }
                  }
               }

               if(var15 == 1 || !class34.field499 && var15 == 4) {
                  label265: {
                     if(field1064 != 1 || menuOptionCount <= 2 || FaceNormal.method2868()) {
                        boolean var17;
                        if(var2 < 0) {
                           var17 = false;
                        } else {
                           var10 = menuTypes[var2];
                           if(var10 >= 2000) {
                              var10 -= 2000;
                           }

                           if(var10 == 1007) {
                              var17 = true;
                           } else {
                              var17 = false;
                           }
                        }

                        if(!var17) {
                           break label265;
                        }
                     }

                     var15 = 2;
                  }
               }

               if((var15 == 1 || !class34.field499 && var15 == 4) && menuOptionCount > 0 && var2 >= 0) {
                  var9 = menuActionParams0[var2];
                  var10 = menuActionParams1[var2];
                  var3 = menuTypes[var2];
                  var16 = menuIdentifiers[var2];
                  String var19 = menuOptions[var2];
                  String var18 = menuTargets[var2];
                  Item.menuAction(var9, var10, var3, var16, var19, var18, MouseInput.field747, MouseInput.field756);
               }

               if(var15 == 2 && menuOptionCount > 0) {
                  this.method1200(MouseInput.field747, MouseInput.field756);
               }

               return;
            }

            if(class95.field1513 != null && !field1043) {
               var7 = class2.method7();
               if(field1064 != 1) {
                  boolean var22;
                  if(var7 < 0) {
                     var22 = false;
                  } else {
                     var8 = menuTypes[var7];
                     if(var8 >= 2000) {
                        var8 -= 2000;
                     }

                     if(var8 == 1007) {
                        var22 = true;
                     } else {
                        var22 = false;
                     }
                  }

                  if(!var22 && menuOptionCount > 0) {
                     var8 = field1040;
                     int var14 = field1041;
                     class67.method1122(class13.field281, var8, var14);
                     class13.field281 = null;
                  }
               }
            }

            field1043 = false;
            field1044 = 0;
            if(class95.field1513 != null) {
               class88.method1714(class95.field1513);
            }

            class95.field1513 = PacketBuffer.method3403(var3);
            field1039 = var10;
            field1040 = MouseInput.field747;
            field1041 = MouseInput.field756;
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
         var3 = MouseInput.method1018(var2, var0);
         var4 = ObjectComposition.method4573(var3, var0);
         return var4 != null?var4:null;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "890021798"
   )
   protected final void vmethod1324() {
      field1140 = DState.currentTimeMs() + 500L;
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
         int var1 = MouseInput.field748;
         int var2 = MouseInput.field749;
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
         ScriptEvent var8;
         if(field1100.field2643 != null && field1111) {
            var8 = new ScriptEvent();
            var8.widget = field1100;
            var8.field850 = var6;
            var8.field853 = var7;
            var8.field857 = field1100.field2643;
            class14.method76(var8);
         }

         if(MouseInput.field754 == 0) {
            int var9;
            int var16;
            if(field1111) {
               if(field1100.field2744 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field1100;
                  var8.field850 = var6;
                  var8.field853 = var7;
                  var8.field859 = field1105;
                  var8.field857 = field1100.field2744;
                  class14.method76(var8);
               }

               if(field1105 != null) {
                  Widget var15 = field1100;
                  var16 = WorldMapType3.getWidgetConfig(var15);
                  var9 = var16 >> 17 & 7;
                  int var12 = var9;
                  Widget var13;
                  if(var9 == 0) {
                     var13 = null;
                  } else {
                     label125: {
                        for(int var14 = 0; var14 < var12; ++var14) {
                           var15 = PacketBuffer.method3403(var15.parentId);
                           if(var15 == null) {
                              var13 = null;
                              break label125;
                           }
                        }

                        var13 = var15;
                     }
                  }

                  if(var13 != null) {
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
               label129: {
                  label95: {
                     int var10 = class2.method7();
                     if(menuOptionCount > 2) {
                        if(field1064 == 1 && !FaceNormal.method2868()) {
                           break label95;
                        }

                        boolean var11;
                        if(var10 < 0) {
                           var11 = false;
                        } else {
                           var9 = menuTypes[var10];
                           if(var9 >= 2000) {
                              var9 -= 2000;
                           }

                           if(var9 == 1007) {
                              var11 = true;
                           } else {
                              var11 = false;
                           }
                        }

                        if(var11) {
                           break label95;
                        }
                     }

                     if(menuOptionCount > 0) {
                        var16 = field1102 + field1109;
                        var9 = field1103 + field960;
                        class67.method1122(class13.field281, var16, var9);
                        class13.field281 = null;
                     }
                     break label129;
                  }

                  this.method1200(field1109 + field1102, field960 + field1103);
               }
            }

            field1100 = null;
         }
      } else if(class220.field2809 > 1) {
         field1100 = null;
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "0"
   )
   @Hook("clientMainLoop")
   protected final void vmethod1455(boolean var1) {
      boolean var2;
      label159: {
         try {
            if(class203.field2508 == 2) {
               if(class222.field2843 == null) {
                  class222.field2843 = Track1.getMusicFile(class61.field785, class203.field2511, class203.field2512);
                  if(class222.field2843 == null) {
                     var2 = false;
                     break label159;
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
                  break label159;
               }
            }
         } catch (Exception var5) {
            var5.printStackTrace();
            class203.field2509.method3740();
            class203.field2508 = 0;
            class222.field2843 = null;
            class20.field335 = null;
            class61.field785 = null;
         }

         var2 = false;
      }

      if(var2 && field1014 && FrameMap.soundSystem0 != null) {
         FrameMap.soundSystem0.method2024();
      }

      int var3;
      if((gameState == 10 || gameState == 20 || gameState == 30) && field1140 != 0L && DState.currentTimeMs() > field1140) {
         var3 = isResized?2:1;
         field1140 = 0L;
         if(var3 >= 2) {
            isResized = true;
         } else {
            isResized = false;
         }

         int var4 = isResized?2:1;
         if(var4 == 1) {
            class261.clientInstance.method869(765, 503);
         } else {
            class261.clientInstance.method869(7680, 2160);
         }

         if(gameState >= 25) {
            class5.method18();
         }
      }

      if(var1) {
         for(var3 = 0; var3 < 100; ++var3) {
            field1132[var3] = true;
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

               var3 = (field982 * 50 - field1083 * 50) / field982;
               class2.drawStatusBox("Loading - please wait.<br> (" + var3 + "%)", false);
            } else if(field1104 == 2) {
               if(field983 > field984) {
                  field984 = field983;
               }

               var3 = (field984 * 50 - field983 * 50) / field984 + 50;
               class2.drawStatusBox("Loading - please wait.<br> (" + var3 + "%)", false);
            } else {
               class2.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1197();
         } else if(gameState == 40) {
            class2.drawStatusBox("Connection lost<br>Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class2.drawStatusBox("Please wait...", false);
         }
      } else {
         class89.drawLoginScreen(World.field1322, class45.field618, class37.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1) {
         for(var3 = 0; var3 < field1061; ++var3) {
            if(field1133[var3]) {
               class43.field602.vmethod5008(widgetPositionX[var3], widgetPositionY[var3], widgetBoundsWidth[var3], widgetBoundsHeight[var3]);
               field1133[var3] = false;
            }
         }
      } else if(gameState > 0) {
         class43.field602.vmethod5007(0, 0);

         for(var3 = 0; var3 < field1061; ++var3) {
            field1133[var3] = false;
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
      this.processJS5Connection();

      while(true) {
         Deque var1 = class236.field3247;
         Deque var3 = class236.field3247;
         FileSystem var2;
         synchronized(class236.field3247) {
            var2 = (FileSystem)class236.field3242.popFront();
         }

         if(var2 == null) {
            int var10;
            try {
               if(class203.field2508 == 1) {
                  var10 = class203.field2509.method3668();
                  if(var10 > 0 && class203.field2509.method3674()) {
                     var10 -= class203.field2517;
                     if(var10 < 0) {
                        var10 = 0;
                     }

                     class203.field2509.method3694(var10);
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
            } catch (Exception var9) {
               var9.printStackTrace();
               class203.field2509.method3740();
               class203.field2508 = 0;
               class222.field2843 = null;
               class20.field335 = null;
               class61.field785 = null;
            }

            class14.method67();
            class33.method346();
            MouseInput var4 = MouseInput.mouse;
            MouseInput var5 = MouseInput.mouse;
            synchronized(MouseInput.mouse) {
               MouseInput.field754 = MouseInput.field744;
               MouseInput.field748 = MouseInput.mouseX;
               MouseInput.field749 = MouseInput.mouseY;
               MouseInput.field742 = MouseInput.field762;
               MouseInput.field747 = MouseInput.field751;
               MouseInput.field756 = MouseInput.field752;
               MouseInput.field757 = MouseInput.field760;
               MouseInput.field762 = 0;
            }

            if(class2.field16 != null) {
               var10 = class2.field16.vmethod2960();
               field1125 = var10;
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

         var2.data.method4220(var2.index, (int)var2.hash, var2.field3215, false);
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

      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var17;
      int var18;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var16 = class61.field771[var2];
         var6 = (int)Math.sqrt(5100.0D);
         var7 = var6 * 768 >> 8;

         for(var8 = 1; var8 < 103; ++var8) {
            for(var9 = 1; var9 < 103; ++var9) {
               var10 = class61.tileHeights[var2][var9 + 1][var8] - class61.tileHeights[var2][var9 - 1][var8];
               var11 = class61.tileHeights[var2][var9][var8 + 1] - class61.tileHeights[var2][var9][var8 - 1];
               var12 = (int)Math.sqrt((double)(var10 * var10 + 65536 + var11 * var11));
               var13 = (var10 << 8) / var12;
               var14 = 65536 / var12;
               var15 = (var11 << 8) / var12;
               var17 = (var15 * -50 + var13 * -50 + var14 * -10) / var7 + 96;
               var18 = (var16[var9][var8] >> 1) + (var16[var9 - 1][var8] >> 2) + (var16[var9 + 1][var8] >> 3) + (var16[var9][var8 - 1] >> 2) + (var16[var9][1 + var8] >> 3);
               class61.field774[var9][var8] = var17 - var18;
            }
         }

         for(var8 = 0; var8 < 104; ++var8) {
            class17.blendedHue[var8] = 0;
            Permission.blendedSaturation[var8] = 0;
            class10.field258[var8] = 0;
            Timer.field2273[var8] = 0;
            Buffer.field2406[var8] = 0;
         }

         for(var8 = -5; var8 < 109; ++var8) {
            for(var9 = 0; var9 < 104; ++var9) {
               var10 = var8 + 5;
               FloorUnderlayDefinition var19;
               if(var10 >= 0 && var10 < 104) {
                  var11 = class61.underlayIds[var2][var10][var9] & 255;
                  if(var11 > 0) {
                     var19 = class220.method4054(var11 - 1);
                     class17.blendedHue[var9] += var19.hue;
                     Permission.blendedSaturation[var9] += var19.saturation;
                     class10.field258[var9] += var19.lightness;
                     Timer.field2273[var9] += var19.hueMultiplier;
                     ++Buffer.field2406[var9];
                  }
               }

               var11 = var8 - 5;
               if(var11 >= 0 && var11 < 104) {
                  var12 = class61.underlayIds[var2][var11][var9] & 255;
                  if(var12 > 0) {
                     var19 = class220.method4054(var12 - 1);
                     class17.blendedHue[var9] -= var19.hue;
                     Permission.blendedSaturation[var9] -= var19.saturation;
                     class10.field258[var9] -= var19.lightness;
                     Timer.field2273[var9] -= var19.hueMultiplier;
                     --Buffer.field2406[var9];
                  }
               }
            }

            if(var8 >= 1 && var8 < 103) {
               var9 = 0;
               var10 = 0;
               var11 = 0;
               var12 = 0;
               var13 = 0;

               for(var14 = -5; var14 < 109; ++var14) {
                  var15 = var14 + 5;
                  if(var15 >= 0 && var15 < 104) {
                     var9 += class17.blendedHue[var15];
                     var10 += Permission.blendedSaturation[var15];
                     var11 += class10.field258[var15];
                     var12 += Timer.field2273[var15];
                     var13 += Buffer.field2406[var15];
                  }

                  var17 = var14 - 5;
                  if(var17 >= 0 && var17 < 104) {
                     var9 -= class17.blendedHue[var17];
                     var10 -= Permission.blendedSaturation[var17];
                     var11 -= class10.field258[var17];
                     var12 -= Timer.field2273[var17];
                     var13 -= Buffer.field2406[var17];
                  }

                  if(var14 >= 1 && var14 < 103 && (!lowMemory || (class61.tileSettings[0][var8][var14] & 2) != 0 || (class61.tileSettings[var2][var8][var14] & 16) == 0)) {
                     if(var2 < class61.field770) {
                        class61.field770 = var2;
                     }

                     var18 = class61.underlayIds[var2][var8][var14] & 255;
                     int var41 = class61.overlayIds[var2][var8][var14] & 255;
                     if(var18 > 0 || var41 > 0) {
                        int var20 = class61.tileHeights[var2][var8][var14];
                        int var21 = class61.tileHeights[var2][var8 + 1][var14];
                        int var22 = class61.tileHeights[var2][var8 + 1][var14 + 1];
                        int var23 = class61.tileHeights[var2][var8][var14 + 1];
                        int var24 = class61.field774[var8][var14];
                        int var25 = class61.field774[var8 + 1][var14];
                        int var26 = class61.field774[var8 + 1][var14 + 1];
                        int var27 = class61.field774[var8][var14 + 1];
                        int var28 = -1;
                        int var29 = -1;
                        int var30;
                        int var31;
                        if(var18 > 0) {
                           var30 = var9 * 256 / var12;
                           var31 = var10 / var13;
                           int var32 = var11 / var13;
                           var28 = class205.hsl24to16(var30, var31, var32);
                           var30 = var30 + class61.field779 & 255;
                           var32 += class61.field782;
                           if(var32 < 0) {
                              var32 = 0;
                           } else if(var32 > 255) {
                              var32 = 255;
                           }

                           var29 = class205.hsl24to16(var30, var31, var32);
                        }

                        if(var2 > 0) {
                           boolean var43 = true;
                           if(var18 == 0 && class36.overlayPaths[var2][var8][var14] != 0) {
                              var43 = false;
                           }

                           if(var41 > 0 && !NPC.method1706(var41 - 1).isHidden) {
                              var43 = false;
                           }

                           if(var43 && var20 == var21 && var22 == var20 && var23 == var20) {
                              class39.field555[var2][var8][var14] |= 2340;
                           }
                        }

                        var30 = 0;
                        if(var29 != -1) {
                           var30 = Graphics3D.colorPalette[class61.method1102(var29, 96)];
                        }

                        if(var41 == 0) {
                           var0.addTile(var2, var8, var14, 0, 0, -1, var20, var21, var22, var23, class61.method1102(var28, var24), class61.method1102(var28, var25), class61.method1102(var28, var26), class61.method1102(var28, var27), 0, 0, 0, 0, var30, 0);
                        } else {
                           var31 = class36.overlayPaths[var2][var8][var14] + 1;
                           byte var44 = class67.overlayRotations[var2][var8][var14];
                           Overlay var33 = NPC.method1706(var41 - 1);
                           int var34 = var33.texture;
                           int var35;
                           int var36;
                           int var37;
                           int var38;
                           if(var34 >= 0) {
                              var36 = Graphics3D.textureLoader.getAverageTextureRGB(var34);
                              var35 = -1;
                           } else if(var33.color == 16711935) {
                              var35 = -2;
                              var34 = -1;
                              var36 = -2;
                           } else {
                              var35 = class205.hsl24to16(var33.hue, var33.saturation, var33.lightness);
                              var37 = var33.hue + class61.field779 & 255;
                              var38 = var33.lightness + class61.field782;
                              if(var38 < 0) {
                                 var38 = 0;
                              } else if(var38 > 255) {
                                 var38 = 255;
                              }

                              var36 = class205.hsl24to16(var37, var33.saturation, var38);
                           }

                           var37 = 0;
                           if(var36 != -2) {
                              var37 = Graphics3D.colorPalette[class39.adjustHSLListness0(var36, 96)];
                           }

                           if(var33.otherRgbColor != -1) {
                              var38 = var33.otherHue + class61.field779 & 255;
                              int var39 = var33.otherLightness + class61.field782;
                              if(var39 < 0) {
                                 var39 = 0;
                              } else if(var39 > 255) {
                                 var39 = 255;
                              }

                              var36 = class205.hsl24to16(var38, var33.otherSaturation, var39);
                              var37 = Graphics3D.colorPalette[class39.adjustHSLListness0(var36, 96)];
                           }

                           var0.addTile(var2, var8, var14, var31, var44, var34, var20, var21, var22, var23, class61.method1102(var28, var24), class61.method1102(var28, var25), class61.method1102(var28, var26), class61.method1102(var28, var27), class39.adjustHSLListness0(var35, var24), class39.adjustHSLListness0(var35, var25), class39.adjustHSLListness0(var35, var26), class39.adjustHSLListness0(var35, var27), var30, var37);
                        }
                     }
                  }
               }
            }
         }

         for(var8 = 1; var8 < 103; ++var8) {
            for(var9 = 1; var9 < 103; ++var9) {
               var0.setPhysicalLevel(var2, var9, var8, Tile.method2485(var2, var9, var8));
            }
         }

         class61.underlayIds[var2] = (byte[][])null;
         class61.overlayIds[var2] = (byte[][])null;
         class36.overlayPaths[var2] = (byte[][])null;
         class67.overlayRotations[var2] = (byte[][])null;
         class61.field771[var2] = (byte[][])null;
      }

      var0.applyLighting(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class61.tileSettings[1][var2][var3] & 2) == 2) {
               var0.setBridge(var2, var3);
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

         for(int var40 = 0; var40 <= var5; ++var40) {
            for(var17 = 0; var17 <= 104; ++var17) {
               for(var18 = 0; var18 <= 104; ++var18) {
                  short var42;
                  if((class39.field555[var40][var18][var17] & var2) != 0) {
                     var6 = var17;
                     var7 = var17;
                     var8 = var40;

                     for(var9 = var40; var6 > 0 && (class39.field555[var40][var18][var6 - 1] & var2) != 0; --var6) {
                        ;
                     }

                     while(var7 < 104 && (class39.field555[var40][var18][var7 + 1] & var2) != 0) {
                        ++var7;
                     }

                     label336:
                     while(var8 > 0) {
                        for(var10 = var6; var10 <= var7; ++var10) {
                           if((class39.field555[var8 - 1][var18][var10] & var2) == 0) {
                              break label336;
                           }
                        }

                        --var8;
                     }

                     label325:
                     while(var9 < var5) {
                        for(var10 = var6; var10 <= var7; ++var10) {
                           if((class39.field555[var9 + 1][var18][var10] & var2) == 0) {
                              break label325;
                           }
                        }

                        ++var9;
                     }

                     var10 = (1 + (var7 - var6)) * (1 + var9 - var8);
                     if(var10 >= 8) {
                        var42 = 240;
                        var12 = class61.tileHeights[var9][var18][var6] - var42;
                        var13 = class61.tileHeights[var8][var18][var6];
                        Region.addOcclude(var5, 1, var18 * 128, var18 * 128, var6 * 128, var7 * 128 + 128, var12, var13);

                        for(var14 = var8; var14 <= var9; ++var14) {
                           for(var15 = var6; var15 <= var7; ++var15) {
                              class39.field555[var14][var18][var15] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class39.field555[var40][var18][var17] & var3) != 0) {
                     var6 = var18;
                     var7 = var18;
                     var8 = var40;

                     for(var9 = var40; var6 > 0 && (class39.field555[var40][var6 - 1][var17] & var3) != 0; --var6) {
                        ;
                     }

                     while(var7 < 104 && (class39.field555[var40][var7 + 1][var17] & var3) != 0) {
                        ++var7;
                     }

                     label389:
                     while(var8 > 0) {
                        for(var10 = var6; var10 <= var7; ++var10) {
                           if((class39.field555[var8 - 1][var10][var17] & var3) == 0) {
                              break label389;
                           }
                        }

                        --var8;
                     }

                     label378:
                     while(var9 < var5) {
                        for(var10 = var6; var10 <= var7; ++var10) {
                           if((class39.field555[var9 + 1][var10][var17] & var3) == 0) {
                              break label378;
                           }
                        }

                        ++var9;
                     }

                     var10 = (var9 + 1 - var8) * (var7 - var6 + 1);
                     if(var10 >= 8) {
                        var42 = 240;
                        var12 = class61.tileHeights[var9][var6][var17] - var42;
                        var13 = class61.tileHeights[var8][var6][var17];
                        Region.addOcclude(var5, 2, var6 * 128, var7 * 128 + 128, var17 * 128, var17 * 128, var12, var13);

                        for(var14 = var8; var14 <= var9; ++var14) {
                           for(var15 = var6; var15 <= var7; ++var15) {
                              class39.field555[var14][var15][var17] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class39.field555[var40][var18][var17] & var4) != 0) {
                     var6 = var18;
                     var7 = var18;
                     var8 = var17;

                     for(var9 = var17; var8 > 0 && (class39.field555[var40][var18][var8 - 1] & var4) != 0; --var8) {
                        ;
                     }

                     while(var9 < 104 && (class39.field555[var40][var18][var9 + 1] & var4) != 0) {
                        ++var9;
                     }

                     label442:
                     while(var6 > 0) {
                        for(var10 = var8; var10 <= var9; ++var10) {
                           if((class39.field555[var40][var6 - 1][var10] & var4) == 0) {
                              break label442;
                           }
                        }

                        --var6;
                     }

                     label431:
                     while(var7 < 104) {
                        for(var10 = var8; var10 <= var9; ++var10) {
                           if((class39.field555[var40][var7 + 1][var10] & var4) == 0) {
                              break label431;
                           }
                        }

                        ++var7;
                     }

                     if((var7 - var6 + 1) * (var9 - var8 + 1) >= 4) {
                        var10 = class61.tileHeights[var40][var6][var8];
                        Region.addOcclude(var5, 4, var6 * 128, var7 * 128 + 128, var8 * 128, var9 * 128 + 128, var10, var10);

                        for(var11 = var6; var11 <= var7; ++var11) {
                           for(var12 = var8; var12 <= var9; ++var12) {
                              class39.field555[var40][var11][var12] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   static {
      field974 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field934 = true;
      gameCycle = 0;
      field936 = -1L;
      field1130 = -1;
      field953 = -1;
      field939 = -1;
      field1090 = true;
      displayFps = false;
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
      js5State = 0;
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
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      secretPacketBuffer1 = new PacketBuffer(5000);
      field969 = new PacketBuffer(5000);
      secretPacketBuffer2 = new PacketBuffer(15000);
      packetLength = 0;
      packetType = 0;
      field973 = 0;
      audioEffectCount = 0;
      lastFrameId = 0;
      secondLastFrameId = 0;
      thridLastFrameId = 0;
      field978 = 0;
      socketError = false;
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
      screenY = -1;
      screenX = -1;
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
      graphicsObjectDeque = new Deque();
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
      spellSelected = false;
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
}
