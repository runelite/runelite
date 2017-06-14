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

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine {
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -162661445
   )
   static int field912;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 935592335
   )
   @Export("world")
   static int world;
   @ObfuscatedName("es")
   static HashMap field914;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -601526537
   )
   static int field915;
   @ObfuscatedName("bd")
   static class232 field916;
   @ObfuscatedName("bj")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("bx")
   static boolean field918;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 377275515
   )
   static int field919;
   @ObfuscatedName("hz")
   static boolean field920;
   @ObfuscatedName("bl")
   static boolean field921;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -169126609
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("kb")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = 1112594923
   )
   static int field924;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1368872595
   )
   static int field925;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1698875697
   )
   static int field926;
   @ObfuscatedName("lq")
   static boolean field927;
   @ObfuscatedName("bg")
   static boolean field928;
   @ObfuscatedName("mg")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 735695207
   )
   static int field930;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1720654419
   )
   static int field931;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = -1186264593
   )
   static int field932;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1712901599
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = 472647739
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("mu")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1510354527
   )
   static int field936;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -995256521
   )
   static int field937;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -2010179321
   )
   static int field938;
   @ObfuscatedName("cl")
   static class91 field939;
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = -1285149067
   )
   static int field940;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = 429752239
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -2088722731
   )
   static int field942;
   @ObfuscatedName("cu")
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("cx")
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 762178767
   )
   static int field945;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      longValue = -3597962646888948367L
   )
   static long field946;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = -803926359
   )
   static int field947;
   @ObfuscatedName("jj")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 187390555
   )
   static int field949;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = -569170087
   )
   static int field950;
   @ObfuscatedName("dl")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = -1464055523
   )
   static int field952;
   @ObfuscatedName("dj")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = 1077488399
   )
   static int field954;
   @ObfuscatedName("du")
   static int[] field955;
   @ObfuscatedName("eu")
   @Export("secretPacketBuffer1")
   static PacketBuffer secretPacketBuffer1;
   @ObfuscatedName("ek")
   static PacketBuffer field957;
   @ObfuscatedName("ee")
   @Export("secretPacketBuffer2")
   static PacketBuffer secretPacketBuffer2;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = 1671240099
   )
   @Export("packetLength")
   static int packetLength;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = -769136209
   )
   static int field960;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -297909507
   )
   static int field961;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -1847359867
   )
   @Export("audioEffectCount")
   static int audioEffectCount;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = -2081343243
   )
   static int field963;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = -985298747
   )
   static int field964;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 1243773095
   )
   static int field965;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = 684598907
   )
   static int field966;
   @ObfuscatedName("ej")
   static boolean field967;
   @ObfuscatedName("hp")
   static String[] field968;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 823719763
   )
   @Export("gameState")
   static int gameState;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = 10356617
   )
   static int field970;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = -1472787251
   )
   static int field971;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = -1778837225
   )
   static int field972;
   @ObfuscatedName("lh")
   static Widget field973;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("qd")
   static short field975;
   @ObfuscatedName("fr")
   static int[][][] field976;
   @ObfuscatedName("fd")
   static final int[] field977;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -1976156867
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 2141308069
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 666198775
   )
   static int field980;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 1852887913
   )
   static int field981;
   @ObfuscatedName("hn")
   static int[] field982;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 1778816291
   )
   static int field983;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -1421739873
   )
   static int field984;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -261576991
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -177848149
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("pq")
   static boolean field987;
   @ObfuscatedName("it")
   @Export("selectedItemName")
   static String selectedItemName;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 1574192517
   )
   static int field989;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 802858035
   )
   static int field990;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -1556089491
   )
   static int field991;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 1813275579
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 520470957
   )
   static int field993;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 1080888321
   )
   static int field994;
   @ObfuscatedName("gp")
   static boolean field995;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = -837930965
   )
   static int field996;
   @ObfuscatedName("jf")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("cv")
   static class91 field998;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -2081450043
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -38227237
   )
   static int field1000;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = -1851047661
   )
   static int field1001;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -730670235
   )
   static int field1002;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = -264561419
   )
   static int field1003;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = 1807261729
   )
   static int field1004;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = -2090168565
   )
   static int field1005;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = 1656217547
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = -1091931751
   )
   static int field1007;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 1811826417
   )
   static int field1008;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = -722014253
   )
   static int field1009;
   @ObfuscatedName("hc")
   static int[] field1010;
   @ObfuscatedName("jx")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("hf")
   static int[] field1012;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = -1149147553
   )
   static int field1013;
   @ObfuscatedName("nt")
   static String field1014;
   @ObfuscatedName("ay")
   static boolean field1015;
   @ObfuscatedName("om")
   @ObfuscatedGetter(
      intValue = 494787305
   )
   static int field1016;
   @ObfuscatedName("hs")
   static int[] field1017;
   @ObfuscatedName("ha")
   static int[][] field1018;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = -1663162853
   )
   static int field1019;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -653642503
   )
   static int field1020;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 141307961
   )
   static int field1021;
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = -463022027
   )
   static int field1022;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = -1814279385
   )
   static int field1024;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = 475968361
   )
   static int field1025;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = -881317649
   )
   static int field1026;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = -811239813
   )
   static int field1027;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -1791617239
   )
   static int field1028;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = 1804580763
   )
   static int field1029;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = -1917479821
   )
   static int field1030;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -1598253647
   )
   static int field1031;
   @ObfuscatedName("ip")
   static boolean field1032;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -1359139785
   )
   static int field1033;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = -998724209
   )
   static int field1034;
   @ObfuscatedName("iy")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -1871293773
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("qx")
   static short field1037;
   @ObfuscatedName("hg")
   static int[] field1038;
   @ObfuscatedName("ih")
   static int[] field1039;
   @ObfuscatedName("lv")
   static boolean field1040;
   @ObfuscatedName("jb")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("jz")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("jn")
   static int[] field1043;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -1605834659
   )
   static int field1044;
   @ObfuscatedName("ji")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("jl")
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("jr")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("ja")
   static Deque field1048;
   @ObfuscatedName("pj")
   static int[] field1049;
   @ObfuscatedName("jm")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1012667479
   )
   static int field1051;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = -1706581353
   )
   static int field1052;
   @ObfuscatedName("jq")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = 343331463
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("jh")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 1540461803
   )
   static int field1056;
   @ObfuscatedName("qm")
   static short field1057;
   @ObfuscatedName("je")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = 974602163
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = 1711808745
   )
   static int field1060;
   @ObfuscatedName("kv")
   static boolean field1061;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 67347709
   )
   static int field1062;
   @ObfuscatedName("nd")
   static int[] field1063;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = 1391214393
   )
   static int field1064;
   @ObfuscatedName("od")
   static int[] field1065;
   @ObfuscatedName("nq")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = 259672077
   )
   static int field1067;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 2051818793
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("rr")
   @ObfuscatedGetter(
      longValue = -3428695530886189803L
   )
   static long field1069;
   @ObfuscatedName("ru")
   static int[] field1070;
   @ObfuscatedName("kd")
   static boolean field1071;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 1042510273
   )
   static int field1072;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = -1920705963
   )
   static int field1073;
   @ObfuscatedName("ka")
   static String field1074;
   @ObfuscatedName("kj")
   static String field1075;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 547896545
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = 1301088369
   )
   static int field1077;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -900901345
   )
   static int field1078;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -1424888159
   )
   static int field1079;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -138050443
   )
   static int field1080;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 1111826877
   )
   static int field1081;
   @ObfuscatedName("fv")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      longValue = 5843792750642569927L
   )
   static long field1083;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = -133969279
   )
   static int field1084;
   @ObfuscatedName("ht")
   static int[] field1085;
   @ObfuscatedName("lr")
   static boolean field1086;
   @ObfuscatedName("lx")
   static boolean field1087;
   @ObfuscatedName("la")
   static Widget field1088;
   @ObfuscatedName("lb")
   static Widget field1089;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = -195903075
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = 732736771
   )
   static int field1091;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = 216187795
   )
   static int field1092;
   @ObfuscatedName("lt")
   static Widget field1093;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -1483534973
   )
   static int field1094;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 1364148247
   )
   static int field1095;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = 1715547281
   )
   static int field1096;
   @ObfuscatedName("lz")
   static boolean field1097;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = -414952587
   )
   static int field1098;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = 818636641
   )
   static int field1099;
   @ObfuscatedName("lu")
   static boolean field1100;
   @ObfuscatedName("pe")
   static int[] field1101;
   @ObfuscatedName("mx")
   static int[] field1102;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = 1089496631
   )
   static int field1103;
   @ObfuscatedName("jc")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("hm")
   static int[] field1105;
   @ObfuscatedName("mi")
   static int[] field1106;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -684897461
   )
   static int field1107;
   @ObfuscatedName("dp")
   static byte[] field1108;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = 496193061
   )
   static int field1109;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -1095277769
   )
   static int field1110;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 468094055
   )
   static int field1111;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = 89205827
   )
   static int field1112;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = -1762089741
   )
   static int field1113;
   @ObfuscatedName("oi")
   static int[] field1114;
   @ObfuscatedName("mb")
   static Deque field1115;
   @ObfuscatedName("mh")
   static Deque field1116;
   @ObfuscatedName("ml")
   static Deque field1117;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = -313461509
   )
   static int field1118;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = -2107492715
   )
   static int field1119;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = 1791895905
   )
   static int field1120;
   @ObfuscatedName("mt")
   static boolean[] field1121;
   @ObfuscatedName("ma")
   static boolean[] field1122;
   @ObfuscatedName("ms")
   static boolean[] field1123;
   @ObfuscatedName("na")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = -870370137
   )
   static int field1125;
   @ObfuscatedName("ne")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("nr")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = -1588323417
   )
   static int field1128;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -231789185
   )
   static int field1129;
   @ObfuscatedName("np")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = 44669205
   )
   @Export("mapOffset")
   static int mapOffset;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = -568434561
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 1348053619
   )
   static int field1133;
   @ObfuscatedName("kz")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("nx")
   static long[] field1135;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1119128867
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = -1788667861
   )
   static int field1137;
   @ObfuscatedName("nn")
   static int[] field1138;
   @ObfuscatedName("ns")
   static int[] field1139;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      longValue = -1409512554010948301L
   )
   static long field1140;
   @ObfuscatedName("oy")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("of")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("ov")
   static byte field1143;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = -106932765
   )
   static int field1144;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = -301904381
   )
   static int field1145;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -1049581137
   )
   static int field1146;
   @ObfuscatedName("kx")
   static Widget field1147;
   @ObfuscatedName("og")
   static SpritePixels[] field1148;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = 165092647
   )
   @Export("detinationX")
   static int detinationX;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = 1090312913
   )
   static int field1150;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = 395170155
   )
   static int field1151;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = 286710511
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = -705745341
   )
   static int field1153;
   @ObfuscatedName("op")
   static boolean field1154;
   @ObfuscatedName("ob")
   @ObfuscatedGetter(
      intValue = 1849454233
   )
   static int field1155;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = 924696527
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("jp")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("pm")
   static int[] field1158;
   @ObfuscatedName("pc")
   static int[] field1159;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -260758669
   )
   static int field1160;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 448072209
   )
   static int field1161;
   @ObfuscatedName("pl")
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = -1680316723
   )
   static int field1163;
   @ObfuscatedName("pz")
   static boolean[] field1164;
   @ObfuscatedName("py")
   static int[] field1165;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -264098149
   )
   static int field1166;
   @ObfuscatedName("qj")
   static int[] field1167;
   @ObfuscatedName("qe")
   static int[] field1168;
   @ObfuscatedName("qb")
   static short field1169;
   @ObfuscatedName("js")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = -348136745
   )
   static int field1171;
   @ObfuscatedName("qc")
   static short field1172;
   @ObfuscatedName("qr")
   static short field1173;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = -522190101
   )
   static int field1174;
   @ObfuscatedName("qs")
   static short field1175;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -399146781
   )
   static int field1176;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = -2001280553
   )
   static int field1177;
   @ObfuscatedName("br")
   static boolean field1178;
   @ObfuscatedName("kg")
   static boolean field1179;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = 503115905
   )
   static int field1180;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = 1417186163
   )
   static int field1181;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = -670110787
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = 2140883449
   )
   static int field1183;
   @ObfuscatedName("qo")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("qw")
   static class195 field1185;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = 334127255
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("qi")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("qn")
   static PlayerComposition field1188;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = -1672985431
   )
   static int field1189;
   @ObfuscatedName("ps")
   static int[] field1190;
   @ObfuscatedName("rj")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("qt")
   static short field1192;
   @ObfuscatedName("ry")
   @ObfuscatedGetter(
      longValue = 4123775523662568669L
   )
   static long field1193;
   @ObfuscatedName("rz")
   static final class73 field1194;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = 889751931
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("ro")
   static int[] field1196;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = 1773536771
   )
   @Export("weight")
   static int weight;

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "38"
   )
   protected final void vmethod1129() {
   }

   public final void init() {
      if(this.method843()) {
         class274[] var1 = new class274[]{class274.field3724, class274.field3717, class274.field3726, class274.field3727, class274.field3725, class274.field3718, class274.field3716, class274.field3723, class274.field3721, class274.field3713, class274.field3714, class274.field3715, class274.field3719, class274.field3720, class274.field3722};
         class274[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            class274 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3728);
            if(var5 != null) {
               switch(Integer.parseInt(var4.field3728)) {
               case 1:
                  class95.field1489 = class149.method2909(Integer.parseInt(var5));
               case 2:
               case 12:
               case 13:
               default:
                  break;
               case 3:
                  class47.field598 = var5;
                  break;
               case 4:
                  class204.field2548 = Integer.parseInt(var5);
                  break;
               case 5:
                  field915 = Integer.parseInt(var5);
                  break;
               case 6:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 7:
                  class207.field2592 = Integer.parseInt(var5);
                  break;
               case 8:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 9:
                  class149.field2213 = var5;
                  break;
               case 10:
                  field919 = Integer.parseInt(var5);
                  break;
               case 11:
                  flags = Integer.parseInt(var5);
                  break;
               case 14:
                  world = Integer.parseInt(var5);
                  break;
               case 15:
                  class232[] var6 = new class232[]{class232.field3194, class232.field3198, class232.field3193, class232.field3196, class232.field3195, class232.field3191};
                  field916 = (class232)Projectile.method1737(var6, Integer.parseInt(var5));
                  if(class232.field3196 == field916) {
                     class13.field281 = class289.field3847;
                  } else {
                     class13.field281 = class289.field3855;
                  }
               }
            }
         }

         Region.field2115 = false;
         field918 = false;
         WallObject.host = this.getCodeBase().getHost();
         String var10 = class95.field1489.field3184;
         byte var7 = 0;

         try {
            class12.method74("oldschool", var10, var7, 17);
         } catch (Exception var9) {
            Projectile.method1734((String)null, var9);
         }

         class46.field590 = this;
         this.method841(765, 503, 144);
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "96"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method1135();

      while(true) {
         Deque var2 = class236.field3233;
         FileSystem var1;
         synchronized(class236.field3233) {
            var1 = (FileSystem)class236.field3234.method3604();
         }

         if(var1 == null) {
            VertexNormal.method2591();
            class24.method202();
            class50 var58 = class50.keyboard;
            int var43;
            synchronized(class50.keyboard) {
               ++class50.keyboardIdleTicks;
               class50.field632 = class50.field633;
               class50.field631 = 0;
               if(class50.field627 >= 0) {
                  while(class50.field627 != class50.field630) {
                     var43 = class50.field619[class50.field630];
                     class50.field630 = class50.field630 + 1 & 127;
                     if(var43 < 0) {
                        class50.field624[~var43] = false;
                     } else {
                        if(!class50.field624[var43] && class50.field631 < class50.field629.length - 1) {
                           class50.field629[++class50.field631 - 1] = var43;
                        }

                        class50.field624[var43] = true;
                     }
                  }
               } else {
                  for(var43 = 0; var43 < 112; ++var43) {
                     class50.field624[var43] = false;
                  }

                  class50.field627 = class50.field630;
               }

               if(class50.field631 > 0) {
                  class50.keyboardIdleTicks = 0;
               }

               class50.field633 = class50.field638;
            }

            class172.method3140();
            int var44;
            if(XGrandExchangeOffer.field312 != null) {
               var44 = XGrandExchangeOffer.field312.vmethod2970();
               field940 = var44;
            }

            if(gameState == 0) {
               DecorativeObject.method2903();
               GameEngine.field703.vmethod2979();

               for(var44 = 0; var44 < 32; ++var44) {
                  GameEngine.field687[var44] = 0L;
               }

               for(var44 = 0; var44 < 32; ++var44) {
                  GameEngine.field688[var44] = 0L;
               }

               GameEngine.field709 = 0;
            } else if(gameState == 5) {
               class8.method51(this);
               DecorativeObject.method2903();
               GameEngine.field703.vmethod2979();

               for(var44 = 0; var44 < 32; ++var44) {
                  GameEngine.field687[var44] = 0L;
               }

               for(var44 = 0; var44 < 32; ++var44) {
                  GameEngine.field688[var44] = 0L;
               }

               GameEngine.field709 = 0;
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  class8.method51(this);
                  this.method1138();
               } else if(gameState == 25) {
                  class146.method2900(false);
                  field1080 = 0;
                  boolean var64 = true;

                  for(var43 = 0; var43 < WorldMapType2.field521.length; ++var43) {
                     if(class45.field582[var43] != -1 && WorldMapType2.field521[var43] == null) {
                        WorldMapType2.field521[var43] = class77.indexMaps.getConfigData(class45.field582[var43], 0);
                        if(WorldMapType2.field521[var43] == null) {
                           var64 = false;
                           ++field1080;
                        }
                     }

                     if(class28.field421[var43] != -1 && class9.field248[var43] == null) {
                        class9.field248[var43] = class77.indexMaps.getConfigData(class28.field421[var43], 0, class60.xteaKeys[var43]);
                        if(class9.field248[var43] == null) {
                           var64 = false;
                           ++field1080;
                        }
                     }
                  }

                  if(!var64) {
                     field1180 = 1;
                  } else {
                     field971 = 0;
                     var64 = true;

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
                     int var45;
                     for(var43 = 0; var43 < WorldMapType2.field521.length; ++var43) {
                        byte[] var3 = class9.field248[var43];
                        if(var3 != null) {
                           var45 = (class18.mapRegions[var43] >> 8) * 64 - class61.baseX;
                           var5 = (class18.mapRegions[var43] & 255) * 64 - class23.baseY;
                           if(isDynamicRegion) {
                              var45 = 10;
                              var5 = 10;
                           }

                           boolean var8 = true;
                           var9 = new Buffer(var3);
                           var10 = -1;

                           label742:
                           while(true) {
                              var11 = var9.method3172();
                              if(var11 == 0) {
                                 var64 &= var8;
                                 break;
                              }

                              var10 += var11;
                              var12 = 0;
                              boolean var13 = false;

                              while(true) {
                                 while(!var13) {
                                    var14 = var9.method3172();
                                    if(var14 == 0) {
                                       continue label742;
                                    }

                                    var12 += var14 - 1;
                                    var15 = var12 & 63;
                                    var16 = var12 >> 6 & 63;
                                    var17 = var9.readUnsignedByte() >> 2;
                                    var18 = var45 + var16;
                                    var19 = var15 + var5;
                                    if(var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
                                       ObjectComposition var20 = class61.getObjectDefinition(var10);
                                       if(var17 != 22 || !field918 || var20.field3464 != 0 || var20.field3459 == 1 || var20.field3476) {
                                          if(!var20.method4543()) {
                                             ++field971;
                                             var8 = false;
                                          }

                                          var13 = true;
                                       }
                                    }
                                 }

                                 var14 = var9.method3172();
                                 if(var14 == 0) {
                                    break;
                                 }

                                 var9.readUnsignedByte();
                              }
                           }
                        }
                     }

                     if(!var64) {
                        field1180 = 2;
                     } else {
                        if(field1180 != 0) {
                           class157.method2976("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        class24.method202();
                        DynamicObject.method1838();
                        class24.method202();
                        class61.region.method2675();
                        class24.method202();
                        System.gc();

                        for(var43 = 0; var43 < 4; ++var43) {
                           collisionMaps[var43].method3016();
                        }

                        int var46;
                        for(var43 = 0; var43 < 4; ++var43) {
                           for(var46 = 0; var46 < 104; ++var46) {
                              for(var45 = 0; var45 < 104; ++var45) {
                                 class61.tileSettings[var43][var46][var45] = 0;
                              }
                           }
                        }

                        class24.method202();
                        class20.method168();
                        var43 = WorldMapType2.field521.length;

                        for(class82 var59 = (class82)class82.field1325.method3622(); var59 != null; var59 = (class82)class82.field1325.method3608()) {
                           if(var59.field1330 != null) {
                              WorldMapType0.field613.method1862(var59.field1330);
                              var59.field1330 = null;
                           }

                           if(var59.field1335 != null) {
                              WorldMapType0.field613.method1862(var59.field1335);
                              var59.field1335 = null;
                           }
                        }

                        class82.field1325.method3601();
                        class146.method2900(true);
                        int var6;
                        int var21;
                        int var22;
                        int var62;
                        if(!isDynamicRegion) {
                           byte[] var47;
                           for(var46 = 0; var46 < var43; ++var46) {
                              var45 = (class18.mapRegions[var46] >> 8) * 64 - class61.baseX;
                              var5 = (class18.mapRegions[var46] & 255) * 64 - class23.baseY;
                              var47 = WorldMapType2.field521[var46];
                              if(var47 != null) {
                                 class24.method202();
                                 class5.method14(var47, var45, var5, class33.field476 * 8 - 48, class95.field1491 * 8 - 48, collisionMaps);
                              }
                           }

                           for(var46 = 0; var46 < var43; ++var46) {
                              var45 = (class18.mapRegions[var46] >> 8) * 64 - class61.baseX;
                              var5 = (class18.mapRegions[var46] & 255) * 64 - class23.baseY;
                              var47 = WorldMapType2.field521[var46];
                              if(var47 == null && class95.field1491 < 800) {
                                 class24.method202();
                                 class24.method204(var45, var5, 64, 64);
                              }
                           }

                           class146.method2900(true);

                           for(var46 = 0; var46 < var43; ++var46) {
                              byte[] var4 = class9.field248[var46];
                              if(var4 != null) {
                                 var5 = (class18.mapRegions[var46] >> 8) * 64 - class61.baseX;
                                 var6 = (class18.mapRegions[var46] & 255) * 64 - class23.baseY;
                                 class24.method202();
                                 Region var48 = class61.region;
                                 CollisionData[] var49 = collisionMaps;
                                 var9 = new Buffer(var4);
                                 var10 = -1;

                                 while(true) {
                                    var11 = var9.method3172();
                                    if(var11 == 0) {
                                       break;
                                    }

                                    var10 += var11;
                                    var12 = 0;

                                    while(true) {
                                       var62 = var9.method3172();
                                       if(var62 == 0) {
                                          break;
                                       }

                                       var12 += var62 - 1;
                                       var14 = var12 & 63;
                                       var15 = var12 >> 6 & 63;
                                       var16 = var12 >> 12;
                                       var17 = var9.readUnsignedByte();
                                       var18 = var17 >> 2;
                                       var19 = var17 & 3;
                                       int var50 = var15 + var5;
                                       var21 = var14 + var6;
                                       if(var50 > 0 && var21 > 0 && var50 < 103 && var21 < 103) {
                                          var22 = var16;
                                          if((class61.tileSettings[1][var50][var21] & 2) == 2) {
                                             var22 = var16 - 1;
                                          }

                                          CollisionData var23 = null;
                                          if(var22 >= 0) {
                                             var23 = var49[var22];
                                          }

                                          class23.method194(var16, var50, var21, var10, var19, var18, var48, var23);
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        int var7;
                        int var51;
                        int var61;
                        if(isDynamicRegion) {
                           var46 = 0;

                           label641:
                           while(true) {
                              if(var46 >= 4) {
                                 for(var46 = 0; var46 < 13; ++var46) {
                                    for(var45 = 0; var45 < 13; ++var45) {
                                       var5 = field976[0][var46][var45];
                                       if(var5 == -1) {
                                          class24.method204(var46 * 8, var45 * 8, 8, 8);
                                       }
                                    }
                                 }

                                 class146.method2900(true);
                                 var46 = 0;

                                 while(true) {
                                    if(var46 >= 4) {
                                       break label641;
                                    }

                                    class24.method202();

                                    for(var45 = 0; var45 < 13; ++var45) {
                                       label564:
                                       for(var5 = 0; var5 < 13; ++var5) {
                                          var6 = field976[var46][var45][var5];
                                          if(var6 != -1) {
                                             var7 = var6 >> 24 & 3;
                                             var61 = var6 >> 1 & 3;
                                             var51 = var6 >> 14 & 1023;
                                             var10 = var6 >> 3 & 2047;
                                             var11 = var10 / 8 + (var51 / 8 << 8);

                                             for(var12 = 0; var12 < class18.mapRegions.length; ++var12) {
                                                if(var11 == class18.mapRegions[var12] && class9.field248[var12] != null) {
                                                   byte[] var52 = class9.field248[var12];
                                                   var14 = var45 * 8;
                                                   var15 = var5 * 8;
                                                   var16 = (var51 & 7) * 8;
                                                   var17 = (var10 & 7) * 8;
                                                   Region var53 = class61.region;
                                                   CollisionData[] var54 = collisionMaps;
                                                   Buffer var63 = new Buffer(var52);
                                                   var21 = -1;

                                                   while(true) {
                                                      var22 = var63.method3172();
                                                      if(var22 == 0) {
                                                         continue label564;
                                                      }

                                                      var21 += var22;
                                                      int var55 = 0;

                                                      while(true) {
                                                         int var24 = var63.method3172();
                                                         if(var24 == 0) {
                                                            break;
                                                         }

                                                         var55 += var24 - 1;
                                                         int var25 = var55 & 63;
                                                         int var26 = var55 >> 6 & 63;
                                                         int var27 = var55 >> 12;
                                                         int var28 = var63.readUnsignedByte();
                                                         int var29 = var28 >> 2;
                                                         int var30 = var28 & 3;
                                                         if(var27 == var7 && var26 >= var16 && var26 < var16 + 8 && var25 >= var17 && var25 < var17 + 8) {
                                                            ObjectComposition var31 = class61.getObjectDefinition(var21);
                                                            int var32 = var14 + class172.method3141(var26 & 7, var25 & 7, var61, var31.sizeX, var31.sizeY, var30);
                                                            int var35 = var26 & 7;
                                                            int var36 = var25 & 7;
                                                            int var38 = var31.sizeX;
                                                            int var39 = var31.sizeY;
                                                            int var40;
                                                            if((var30 & 1) == 1) {
                                                               var40 = var38;
                                                               var38 = var39;
                                                               var39 = var40;
                                                            }

                                                            int var37 = var61 & 3;
                                                            int var34;
                                                            if(var37 == 0) {
                                                               var34 = var36;
                                                            } else if(var37 == 1) {
                                                               var34 = 7 - var35 - (var38 - 1);
                                                            } else if(var37 == 2) {
                                                               var34 = 7 - var36 - (var39 - 1);
                                                            } else {
                                                               var34 = var35;
                                                            }

                                                            var40 = var34 + var15;
                                                            if(var32 > 0 && var40 > 0 && var32 < 103 && var40 < 103) {
                                                               int var41 = var46;
                                                               if((class61.tileSettings[1][var32][var40] & 2) == 2) {
                                                                  var41 = var46 - 1;
                                                               }

                                                               CollisionData var42 = null;
                                                               if(var41 >= 0) {
                                                                  var42 = var54[var41];
                                                               }

                                                               class23.method194(var46, var32, var40, var21, var61 + var30 & 3, var29, var53, var42);
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++var46;
                                 }
                              }

                              class24.method202();

                              for(var45 = 0; var45 < 13; ++var45) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    boolean var60 = false;
                                    var7 = field976[var46][var45][var5];
                                    if(var7 != -1) {
                                       var61 = var7 >> 24 & 3;
                                       var51 = var7 >> 1 & 3;
                                       var10 = var7 >> 14 & 1023;
                                       var11 = var7 >> 3 & 2047;
                                       var12 = (var10 / 8 << 8) + var11 / 8;

                                       for(var62 = 0; var62 < class18.mapRegions.length; ++var62) {
                                          if(class18.mapRegions[var62] == var12 && WorldMapType2.field521[var62] != null) {
                                             class46.method685(WorldMapType2.field521[var62], var46, var45 * 8, var5 * 8, var61, (var10 & 7) * 8, (var11 & 7) * 8, var51, collisionMaps);
                                             var60 = true;
                                             break;
                                          }
                                       }
                                    }

                                    if(!var60) {
                                       var61 = var46;
                                       var51 = var45 * 8;
                                       var10 = var5 * 8;

                                       for(var11 = 0; var11 < 8; ++var11) {
                                          for(var12 = 0; var12 < 8; ++var12) {
                                             class61.tileHeights[var61][var11 + var51][var12 + var10] = 0;
                                          }
                                       }

                                       if(var51 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class61.tileHeights[var61][var51][var10 + var11] = class61.tileHeights[var61][var51 - 1][var11 + var10];
                                          }
                                       }

                                       if(var10 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class61.tileHeights[var61][var51 + var11][var10] = class61.tileHeights[var61][var11 + var51][var10 - 1];
                                          }
                                       }

                                       if(var51 > 0 && class61.tileHeights[var61][var51 - 1][var10] != 0) {
                                          class61.tileHeights[var61][var51][var10] = class61.tileHeights[var61][var51 - 1][var10];
                                       } else if(var10 > 0 && class61.tileHeights[var61][var51][var10 - 1] != 0) {
                                          class61.tileHeights[var61][var51][var10] = class61.tileHeights[var61][var51][var10 - 1];
                                       } else if(var51 > 0 && var10 > 0 && class61.tileHeights[var61][var51 - 1][var10 - 1] != 0) {
                                          class61.tileHeights[var61][var51][var10] = class61.tileHeights[var61][var51 - 1][var10 - 1];
                                       }
                                    }
                                 }
                              }

                              ++var46;
                           }
                        }

                        class146.method2900(true);
                        DynamicObject.method1838();
                        class24.method202();
                        class23.method191(class61.region, collisionMaps);
                        class146.method2900(true);
                        var46 = class61.field737;
                        if(var46 > class92.plane) {
                           var46 = class92.plane;
                        }

                        if(var46 < class92.plane - 1) {
                           var46 = class92.plane - 1;
                        }

                        if(field918) {
                           class61.region.method2708(class61.field737);
                        } else {
                           class61.region.method2708(0);
                        }

                        for(var45 = 0; var45 < 104; ++var45) {
                           for(var5 = 0; var5 < 104; ++var5) {
                              class261.groundItemSpawned(var45, var5);
                           }
                        }

                        class24.method202();
                        class50.method743();
                        ObjectComposition.field3467.reset();
                        if(class46.field590.method862()) {
                           secretPacketBuffer1.putOpcode(116);
                           secretPacketBuffer1.putInt(1057001181);
                        }

                        if(!isDynamicRegion) {
                           var45 = (class33.field476 - 6) / 8;
                           var5 = (class33.field476 + 6) / 8;
                           var6 = (class95.field1491 - 6) / 8;
                           var7 = (class95.field1491 + 6) / 8;

                           for(var61 = var45 - 1; var61 <= var5 + 1; ++var61) {
                              for(var51 = var6 - 1; var51 <= var7 + 1; ++var51) {
                                 if(var61 < var45 || var61 > var5 || var51 < var6 || var51 > var7) {
                                    class77.indexMaps.method4147("m" + var61 + "_" + var51);
                                    class77.indexMaps.method4147("l" + var61 + "_" + var51);
                                 }
                              }
                           }
                        }

                        class3.setGameState(30);
                        class24.method202();
                        class234.underlayIds = null;
                        class61.overlayIds = null;
                        class21.overlayPaths = null;
                        class61.overlayRotations = null;
                        class51.field643 = null;
                        class10.field261 = null;
                        class61.field740 = null;
                        class157.field2263 = null;
                        class61.field741 = null;
                        class61.field742 = null;
                        class43.field569 = null;
                        class61.field743 = null;
                        secretPacketBuffer1.putOpcode(174);
                        GameEngine.field703.vmethod2979();

                        for(var45 = 0; var45 < 32; ++var45) {
                           GameEngine.field687[var45] = 0L;
                        }

                        for(var45 = 0; var45 < 32; ++var45) {
                           GameEngine.field688[var45] = 0L;
                        }

                        GameEngine.field709 = 0;
                     }
                  }
               }
            } else {
               class8.method51(this);
            }

            if(gameState == 30) {
               this.method1139();
            } else if(gameState == 40 || gameState == 45) {
               this.method1138();
            }

            return;
         }

         var1.data.method4238(var1.index, (int)var1.hash, var1.field3200, false);
      }
   }

   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-30512"
   )
   void method1135() {
      if(gameState != 1000) {
         long var2 = class134.method2587();
         int var4 = (int)(var2 - class238.field3257);
         class238.field3257 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class238.field3251 += var4;
         boolean var1;
         if(class238.field3261 == 0 && class238.field3256 == 0 && class238.field3259 == 0 && class238.field3254 == 0) {
            var1 = true;
         } else if(class238.field3272 == null) {
            var1 = false;
         } else {
            try {
               label244: {
                  if(class238.field3251 > 30000) {
                     throw new IOException();
                  }

                  class234 var5;
                  Buffer var6;
                  while(class238.field3256 < 20 && class238.field3254 > 0) {
                     var5 = (class234)class238.field3255.method3548();
                     var6 = new Buffer(4);
                     var6.putByte(1);
                     var6.put24bitInt((int)var5.hash);
                     class238.field3272.queueForWrite(var6.payload, 0, 4);
                     class238.field3268.method3546(var5, var5.hash);
                     --class238.field3254;
                     ++class238.field3256;
                  }

                  while(class238.field3261 < 20 && class238.field3259 > 0) {
                     var5 = (class234)class238.field3253.method3485();
                     var6 = new Buffer(4);
                     var6.putByte(0);
                     var6.put24bitInt((int)var5.hash);
                     class238.field3272.queueForWrite(var6.payload, 0, 4);
                     var5.method3641();
                     class238.field3260.method3546(var5, var5.hash);
                     --class238.field3259;
                     ++class238.field3261;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class238.field3272.available();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class238.field3251 = 0;
                     byte var7 = 0;
                     if(class18.field327 == null) {
                        var7 = 8;
                     } else if(class238.field3263 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class238.field3262.offset;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class238.field3272.read(class238.field3262.payload, class238.field3262.offset, var8);
                        if(class238.field3266 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class238.field3262.payload[var9 + class238.field3262.offset] ^= class238.field3266;
                           }
                        }

                        class238.field3262.offset += var8;
                        if(class238.field3262.offset < var7) {
                           break;
                        }

                        if(class18.field327 == null) {
                           class238.field3262.offset = 0;
                           var9 = class238.field3262.readUnsignedByte();
                           var10 = class238.field3262.readUnsignedShort();
                           int var11 = class238.field3262.readUnsignedByte();
                           var12 = class238.field3262.readInt();
                           long var13 = (long)((var9 << 16) + var10);
                           class234 var15 = (class234)class238.field3268.method3545(var13);
                           class83.field1355 = true;
                           if(var15 == null) {
                              var15 = (class234)class238.field3260.method3545(var13);
                              class83.field1355 = false;
                           }

                           if(var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class18.field327 = var15;
                           class223.field2843 = new Buffer(class18.field327.field3210 + var16 + var12);
                           class223.field2843.putByte(var11);
                           class223.field2843.putInt(var12);
                           class238.field3263 = 8;
                           class238.field3262.offset = 0;
                        } else if(class238.field3263 == 0) {
                           if(class238.field3262.payload[0] == -1) {
                              class238.field3263 = 1;
                              class238.field3262.offset = 0;
                           } else {
                              class18.field327 = null;
                           }
                        }
                     } else {
                        var8 = class223.field2843.payload.length - class18.field327.field3210;
                        var9 = 512 - class238.field3263;
                        if(var9 > var8 - class223.field2843.offset) {
                           var9 = var8 - class223.field2843.offset;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class238.field3272.read(class223.field2843.payload, class223.field2843.offset, var9);
                        if(class238.field3266 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class223.field2843.payload[class223.field2843.offset + var10] ^= class238.field3266;
                           }
                        }

                        class223.field2843.offset += var9;
                        class238.field3263 += var9;
                        if(var8 == class223.field2843.offset) {
                           if(class18.field327.hash == 16711935L) {
                              class1.field10 = class223.field2843;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 IndexData var19 = class238.field3265[var10];
                                 if(var19 != null) {
                                    class1.field10.offset = var10 * 8 + 5;
                                    var12 = class1.field10.readInt();
                                    int var20 = class1.field10.readInt();
                                    var19.method4236(var12, var20);
                                 }
                              }
                           } else {
                              class238.field3264.reset();
                              class238.field3264.update(class223.field2843.payload, 0, var8);
                              var10 = (int)class238.field3264.getValue();
                              if(class18.field327.field3212 != var10) {
                                 try {
                                    class238.field3272.method2989();
                                 } catch (Exception var23) {
                                    ;
                                 }

                                 ++class238.field3267;
                                 class238.field3272 = null;
                                 class238.field3266 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label244;
                              }

                              class238.field3267 = 0;
                              class238.field3271 = 0;
                              class18.field327.field3213.method4237((int)(class18.field327.hash & 65535L), class223.field2843.payload, 16711680L == (class18.field327.hash & 16711680L), class83.field1355);
                           }

                           class18.field327.unlink();
                           if(class83.field1355) {
                              --class238.field3256;
                           } else {
                              --class238.field3261;
                           }

                           class238.field3263 = 0;
                           class18.field327 = null;
                           class223.field2843 = null;
                        } else {
                           if(class238.field3263 != 512) {
                              break;
                           }

                           class238.field3263 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var24) {
               try {
                  class238.field3272.method2989();
               } catch (Exception var22) {
                  ;
               }

               ++class238.field3271;
               class238.field3272 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method1136();
         }

      }
   }

   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1746160854"
   )
   void method1136() {
      if(class238.field3267 >= 4) {
         this.method859("js5crc");
         gameState = 1000;
      } else {
         if(class238.field3271 >= 4) {
            if(gameState <= 5) {
               this.method859("js5io");
               gameState = 1000;
               return;
            }

            field942 = 3000;
            class238.field3271 = 3;
         }

         if(--field942 + 1 <= 0) {
            try {
               if(field1051 == 0) {
                  class176.field2420 = GameEngine.field678.method2936(WallObject.host, class66.field803);
                  ++field1051;
               }

               if(field1051 == 1) {
                  if(class176.field2420.field2236 == 2) {
                     this.method1137(-1);
                     return;
                  }

                  if(class176.field2420.field2236 == 1) {
                     ++field1051;
                  }
               }

               if(field1051 == 2) {
                  class18.rssocket = new RSSocket((Socket)class176.field2420.field2240, GameEngine.field678);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(144);
                  class18.rssocket.queueForWrite(var1.payload, 0, 5);
                  ++field1051;
                  class203.field2518 = class134.method2587();
               }

               if(field1051 == 3) {
                  if(gameState > 5 && class18.rssocket.available() <= 0) {
                     if(class134.method2587() - class203.field2518 > 30000L) {
                        this.method1137(-2);
                        return;
                     }
                  } else {
                     int var5 = class18.rssocket.readByte();
                     if(var5 != 0) {
                        this.method1137(var5);
                        return;
                     }

                     ++field1051;
                  }
               }

               if(field1051 == 4) {
                  RSSocket var10 = class18.rssocket;
                  boolean var2 = gameState > 20;
                  if(class238.field3272 != null) {
                     try {
                        class238.field3272.method2989();
                     } catch (Exception var8) {
                        ;
                     }

                     class238.field3272 = null;
                  }

                  class238.field3272 = var10;
                  class222.method4092(var2);
                  class238.field3262.offset = 0;
                  class18.field327 = null;
                  class223.field2843 = null;
                  class238.field3263 = 0;

                  while(true) {
                     class234 var3 = (class234)class238.field3268.method3548();
                     if(var3 == null) {
                        while(true) {
                           var3 = (class234)class238.field3260.method3548();
                           if(var3 == null) {
                              if(class238.field3266 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.putByte(4);
                                    var11.putByte(class238.field3266);
                                    var11.putShort(0);
                                    class238.field3272.queueForWrite(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class238.field3272.method2989();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class238.field3271;
                                    class238.field3272 = null;
                                 }
                              }

                              class238.field3251 = 0;
                              class238.field3257 = class134.method2587();
                              class176.field2420 = null;
                              class18.rssocket = null;
                              field1051 = 0;
                              field945 = 0;
                              return;
                           }

                           class238.field3253.method3474(var3);
                           class238.field3258.method3546(var3, var3.hash);
                           ++class238.field3259;
                           --class238.field3261;
                        }
                     }

                     class238.field3255.method3546(var3, var3.hash);
                     ++class238.field3254;
                     --class238.field3256;
                  }
               }
            } catch (IOException var9) {
               this.method1137(-3);
            }

         }
      }
   }

   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-84562304"
   )
   void method1137(int var1) {
      class176.field2420 = null;
      class18.rssocket = null;
      field1051 = 0;
      if(class36.field506 == class66.field803) {
         class66.field803 = class177.field2423;
      } else {
         class66.field803 = class36.field506;
      }

      ++field945;
      if(field945 < 2 || var1 != 7 && var1 != 9) {
         if(field945 >= 2 && var1 == 6) {
            this.method859("js5connect_outofdate");
            gameState = 1000;
         } else if(field945 >= 4) {
            if(gameState <= 5) {
               this.method859("js5connect");
               gameState = 1000;
            } else {
               field942 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method859("js5connect_full");
         gameState = 1000;
      } else {
         field942 = 3000;
      }

   }

   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1845212679"
   )
   final void method1138() {
      try {
         if(loginState == 0) {
            if(class8.rssocket != null) {
               class8.rssocket.method2989();
               class8.rssocket = null;
            }

            class267.field3679 = null;
            field967 = false;
            field947 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(class267.field3679 == null) {
               class267.field3679 = GameEngine.field678.method2936(WallObject.host, class66.field803);
            }

            if(class267.field3679.field2236 == 2) {
               throw new IOException();
            }

            if(class267.field3679.field2236 == 1) {
               class8.rssocket = new RSSocket((Socket)class267.field3679.field2240, GameEngine.field678);
               class267.field3679 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(14);
            class8.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, 1);
            secretPacketBuffer2.offset = 0;
            loginState = 3;
         }

         int var1;
         if(loginState == 3) {
            if(RSSocket.field2287 != null) {
               RSSocket.field2287.method2055();
            }

            if(class154.field2250 != null) {
               class154.field2250.method2055();
            }

            var1 = class8.rssocket.readByte();
            if(RSSocket.field2287 != null) {
               RSSocket.field2287.method2055();
            }

            if(class154.field2250 != null) {
               class154.field2250.method2055();
            }

            if(var1 != 0) {
               class2.method5(var1);
               return;
            }

            secretPacketBuffer2.offset = 0;
            loginState = 4;
         }

         if(loginState == 4) {
            if(secretPacketBuffer2.offset < 8) {
               var1 = class8.rssocket.available();
               if(var1 > 8 - secretPacketBuffer2.offset) {
                  var1 = 8 - secretPacketBuffer2.offset;
               }

               if(var1 > 0) {
                  class8.rssocket.read(secretPacketBuffer2.payload, secretPacketBuffer2.offset, var1);
                  secretPacketBuffer2.offset += var1;
               }
            }

            if(secretPacketBuffer2.offset == 8) {
               secretPacketBuffer2.offset = 0;
               class25.field375 = secretPacketBuffer2.readLong();
               loginState = 5;
            }
         }

         int var2;
         int var3;
         if(loginState == 5) {
            int[] var9 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class25.field375 >> 32), (int)(class25.field375 & -1L)};
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(1);
            secretPacketBuffer1.putByte(class92.field1441.vmethod5059());
            secretPacketBuffer1.putInt(var9[0]);
            secretPacketBuffer1.putInt(var9[1]);
            secretPacketBuffer1.putInt(var9[2]);
            secretPacketBuffer1.putInt(var9[3]);
            switch(class92.field1441.field2206) {
            case 0:
            case 1:
               secretPacketBuffer1.put24bitInt(class175.authCodeForLogin);
               secretPacketBuffer1.offset += 5;
               break;
            case 2:
               secretPacketBuffer1.offset += 8;
               break;
            case 3:
               secretPacketBuffer1.putInt(((Integer)class66.field801.preferences.get(Integer.valueOf(DynamicObject.method1843(class92.username)))).intValue());
               secretPacketBuffer1.offset += 4;
            }

            secretPacketBuffer1.method3150(class92.password);
            secretPacketBuffer1.method3180(class90.rsaKeyExponent, class90.rsaKeyModulus);
            field957.offset = 0;
            if(gameState == 40) {
               field957.putByte(18);
            } else {
               field957.putByte(16);
            }

            field957.putShort(0);
            var2 = field957.offset;
            field957.putInt(144);
            field957.putBytes(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
            var3 = field957.offset;
            field957.method3150(class92.username);
            field957.putByte((isResized?1:0) << 1 | (field918?1:0));
            field957.putShort(class174.canvasWidth);
            field957.putShort(class2.canvasHeight);
            PacketBuffer var4 = field957;
            if(field1108 != null) {
               var4.putBytes(field1108, 0, field1108.length);
            } else {
               byte[] var6 = new byte[24];

               try {
                  class155.field2257.method2337(0L);
                  class155.field2257.method2347(var6);

                  int var7;
                  for(var7 = 0; var7 < 24 && var6[var7] == 0; ++var7) {
                     ;
                  }

                  if(var7 >= 24) {
                     throw new IOException();
                  }
               } catch (Exception var15) {
                  for(int var8 = 0; var8 < 24; ++var8) {
                     var6[var8] = -1;
                  }
               }

               var4.putBytes(var6, 0, var6.length);
            }

            field957.method3150(class47.field598);
            field957.putInt(class204.field2548);
            Buffer var5 = new Buffer(class230.field3183.method5383());
            class230.field3183.method5382(var5);
            field957.putBytes(var5.payload, 0, var5.payload.length);
            field957.putByte(class207.field2592);
            field957.putInt(0);
            field957.putInt(class69.indexInterfaces.field3228);
            field957.putInt(indexSoundEffects.field3228);
            field957.putInt(NPC.field1374.field3228);
            field957.putInt(XItemContainer.field765.field3228);
            field957.putInt(RSCanvas.field655.field3228);
            field957.putInt(class77.indexMaps.field3228);
            field957.putInt(class54.indexTrack1.field3228);
            field957.putInt(class23.indexModels.field3228);
            field957.putInt(indexSprites.field3228);
            field957.putInt(Player.indexTextures.field3228);
            field957.putInt(class22.field353.field3228);
            field957.putInt(IndexData.indexTrack2.field3228);
            field957.putInt(GroundObject.indexScripts.field3228);
            field957.putInt(FileSystem.field3207.field3228);
            field957.putInt(class61.field753.field3228);
            field957.putInt(class14.field291.field3228);
            field957.putInt(class21.indexWorldMap.field3228);
            field957.encryptXtea(var9, var3, field957.offset);
            field957.method3155(field957.offset - var2);
            class8.rssocket.queueForWrite(field957.payload, 0, field957.offset);
            secretPacketBuffer1.seed(var9);

            for(int var11 = 0; var11 < 4; ++var11) {
               var9[var11] += 50;
            }

            secretPacketBuffer2.seed(var9);
            loginState = 6;
         }

         if(loginState == 6 && class8.rssocket.available() > 0) {
            var1 = class8.rssocket.readByte();
            if(var1 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var1 == 2) {
               loginState = 9;
            } else if(var1 == 15 && gameState == 40) {
               packetLength = -1;
               loginState = 13;
            } else if(var1 == 23 && field1129 < 1) {
               ++field1129;
               loginState = 0;
            } else {
               if(var1 != 29) {
                  class2.method5(var1);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && class8.rssocket.available() > 0) {
            field949 = (class8.rssocket.readByte() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field947 = 0;
            class15.method115("You have only just left another world.", "Your profile will be transferred in:", field949 / 60 + " seconds.");
            if(--field949 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && class8.rssocket.available() >= 13) {
               boolean var18 = class8.rssocket.readByte() == 1;
               class8.rssocket.read(secretPacketBuffer2.payload, 0, 4);
               secretPacketBuffer2.offset = 0;
               boolean var17 = false;
               if(var18) {
                  var2 = secretPacketBuffer2.readOpcode() << 24;
                  var2 |= secretPacketBuffer2.readOpcode() << 16;
                  var2 |= secretPacketBuffer2.readOpcode() << 8;
                  var2 |= secretPacketBuffer2.readOpcode();
                  var3 = DynamicObject.method1843(class92.username);
                  if(class66.field801.preferences.size() >= 10 && !class66.field801.preferences.containsKey(Integer.valueOf(var3))) {
                     Iterator var19 = class66.field801.preferences.entrySet().iterator();
                     var19.next();
                     var19.remove();
                  }

                  class66.field801.preferences.put(Integer.valueOf(var3), Integer.valueOf(var2));
                  WorldMapType3.method232();
               }

               rights = class8.rssocket.readByte();
               field1040 = class8.rssocket.readByte() == 1;
               localInteractingIndex = class8.rssocket.readByte();
               localInteractingIndex <<= 8;
               localInteractingIndex += class8.rssocket.readByte();
               field1146 = class8.rssocket.readByte();
               class8.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               field960 = secretPacketBuffer2.readOpcode();
               class8.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();

               try {
                  class52.method758(class46.field590, "zap");
               } catch (Throwable var14) {
                  ;
               }

               loginState = 10;
            }

            if(loginState != 10) {
               if(loginState == 11 && class8.rssocket.available() >= 2) {
                  secretPacketBuffer2.offset = 0;
                  class8.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                  secretPacketBuffer2.offset = 0;
                  class87.field1386 = secretPacketBuffer2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && class8.rssocket.available() >= class87.field1386) {
                  secretPacketBuffer2.offset = 0;
                  class8.rssocket.read(secretPacketBuffer2.payload, 0, class87.field1386);
                  secretPacketBuffer2.offset = 0;
                  String var21 = secretPacketBuffer2.readString();
                  String var22 = secretPacketBuffer2.readString();
                  String var12 = secretPacketBuffer2.readString();
                  class15.method115(var21, var22, var12);
                  class3.setGameState(10);
               }

               if(loginState == 13) {
                  if(packetLength == -1) {
                     if(class8.rssocket.available() < 2) {
                        return;
                     }

                     class8.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                     secretPacketBuffer2.offset = 0;
                     packetLength = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(class8.rssocket.available() >= packetLength) {
                     class8.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                     secretPacketBuffer2.offset = 0;
                     var1 = packetLength;
                     method1311();
                     class1.method2(secretPacketBuffer2);
                     if(secretPacketBuffer2.offset != var1) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field947;
                  if(field947 > 2000) {
                     if(field1129 < 1) {
                        if(class66.field803 == class36.field506) {
                           class66.field803 = class177.field2423;
                        } else {
                           class66.field803 = class36.field506;
                        }

                        ++field1129;
                        loginState = 0;
                     } else {
                        class2.method5(-3);
                     }
                  }
               }
            } else {
               if(class8.rssocket.available() >= packetLength) {
                  secretPacketBuffer2.offset = 0;
                  class8.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                  field1083 = -1L;
                  field926 = -1;
                  WorldMapType1.field443.field844 = 0;
                  ScriptState.field760 = true;
                  field1178 = true;
                  field1140 = -1L;
                  class280.field3749 = new CombatInfoList();
                  secretPacketBuffer1.offset = 0;
                  secretPacketBuffer2.offset = 0;
                  field960 = -1;
                  field963 = -1;
                  field964 = -1;
                  field965 = -1;
                  field961 = 0;
                  field1081 = 0;
                  field966 = 0;
                  field930 = 0;
                  menuOptionCount = 0;
                  field1062 = -1;
                  isMenuOpen = false;
                  class243.method4332(0);
                  class98.chatLineMap.clear();
                  class98.field1524.method3511();
                  class98.field1525.method3681();
                  class98.field1530 = 0;
                  itemSelectionState = 0;
                  field1071 = false;
                  field1077 = 0;
                  field1171 = (int)(Math.random() * 100.0D) - 50;
                  field980 = (int)(Math.random() * 110.0D) - 55;
                  field1125 = (int)(Math.random() * 80.0D) - 40;
                  mapScale = (int)(Math.random() * 120.0D) - 60;
                  mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
                  mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
                  field1016 = 0;
                  field1144 = -1;
                  detinationX = 0;
                  destinationY = 0;
                  field998 = class91.field1414;
                  field939 = class91.field1414;
                  field952 = 0;
                  class96.field1499 = 0;

                  for(var1 = 0; var1 < 2048; ++var1) {
                     class96.field1497[var1] = null;
                     class96.field1498[var1] = 1;
                  }

                  for(var1 = 0; var1 < 2048; ++var1) {
                     cachedPlayers[var1] = null;
                  }

                  for(var1 = 0; var1 < '耀'; ++var1) {
                     cachedNPCs[var1] = null;
                  }

                  field1044 = -1;
                  projectiles.method3601();
                  field1048.method3601();

                  for(var1 = 0; var1 < 4; ++var1) {
                     for(var2 = 0; var2 < 104; ++var2) {
                        for(var3 = 0; var3 < 104; ++var3) {
                           groundItemDeque[var1][var2][var3] = null;
                        }
                     }
                  }

                  pendingSpawns = new Deque();
                  field1183 = 0;
                  friendCount = 0;
                  ignoreCount = 0;

                  for(var1 = 0; var1 < class241.field3289; ++var1) {
                     class241 var13 = Item.method1741(var1);
                     if(var13 != null) {
                        class211.settings[var1] = 0;
                        class211.widgetSettings[var1] = 0;
                     }
                  }

                  Tile.chatMessages.method1793();
                  field1025 = -1;
                  if(widgetRoot != -1) {
                     ISAACCipher.method3423(widgetRoot);
                  }

                  for(WidgetNode var20 = (WidgetNode)componentTable.method3548(); var20 != null; var20 = (WidgetNode)componentTable.method3556()) {
                     WorldMapType3.method231(var20, true);
                  }

                  widgetRoot = -1;
                  componentTable = new XHashTable(8);
                  field1147 = null;
                  class89.method1695();
                  field1188.method3991((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var1 = 0; var1 < 8; ++var1) {
                     playerOptions[var1] = null;
                     playerOptionsPriorities[var1] = false;
                  }

                  XItemContainer.itemContainers = new XHashTable(32);
                  field921 = true;

                  for(var1 = 0; var1 < 100; ++var1) {
                     field1121[var1] = true;
                  }

                  class77.method1488();
                  clanChatOwner = null;
                  class24.clanChatCount = 0;
                  class2.clanMembers = null;

                  for(var1 = 0; var1 < 8; ++var1) {
                     grandExchangeOffers[var1] = new XGrandExchangeOffer();
                  }

                  class69.field834 = null;
                  class1.method2(secretPacketBuffer2);
                  class33.field476 = -1;
                  class123.xteaChanged(false);
                  field960 = -1;
               }

            }
         }
      } catch (IOException var16) {
         if(field1129 < 1) {
            if(class36.field506 == class66.field803) {
               class66.field803 = class177.field2423;
            } else {
               class66.field803 = class36.field506;
            }

            ++field1129;
            loginState = 0;
         } else {
            class2.method5(-2);
         }
      }
   }

   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "520683754"
   )
   final void method1139() {
      if(field1081 > 1) {
         --field1081;
      }

      if(field966 > 0) {
         --field966;
      }

      if(field967) {
         field967 = false;
         class210.method3941();
      } else {
         if(!isMenuOpen) {
            class89.method1695();
            menuOptions[0] = "Cancel";
            menuTargets[0] = "";
            menuTypes[0] = 1006;
            menuOptionCount = 1;
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method1143(); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(true) {
               ClassInfo var2 = (ClassInfo)class280.field3749.method3571();
               boolean var25;
               if(var2 == null) {
                  var25 = false;
               } else {
                  var25 = true;
               }

               int var11;
               if(!var25) {
                  Object var12 = WorldMapType1.field443.field848;
                  int var3;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  synchronized(WorldMapType1.field443.field848) {
                     if(!field1015) {
                        WorldMapType1.field443.field844 = 0;
                     } else if(class59.field713 != 0 || WorldMapType1.field443.field844 >= 40) {
                        secretPacketBuffer1.putOpcode(236);
                        secretPacketBuffer1.putByte(0);
                        var11 = secretPacketBuffer1.offset;
                        var3 = 0;

                        for(var4 = 0; var4 < WorldMapType1.field443.field844 && secretPacketBuffer1.offset - var11 < 240; ++var4) {
                           ++var3;
                           var5 = WorldMapType1.field443.field846[var4];
                           if(var5 < 0) {
                              var5 = 0;
                           } else if(var5 > 502) {
                              var5 = 502;
                           }

                           var6 = WorldMapType1.field443.field847[var4];
                           if(var6 < 0) {
                              var6 = 0;
                           } else if(var6 > 764) {
                              var6 = 764;
                           }

                           var7 = var5 * 765 + var6;
                           if(WorldMapType1.field443.field846[var4] == -1 && WorldMapType1.field443.field847[var4] == -1) {
                              var6 = -1;
                              var5 = -1;
                              var7 = 524287;
                           }

                           if(field1021 == var6 && var5 == field925) {
                              if(field926 < 2047) {
                                 ++field926;
                              }
                           } else {
                              int var8 = var6 - field1021;
                              field1021 = var6;
                              int var9 = var5 - field925;
                              field925 = var5;
                              if(field926 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                                 var8 += 32;
                                 var9 += 32;
                                 secretPacketBuffer1.putShort(var9 + (var8 << 6) + (field926 << 12));
                                 field926 = 0;
                              } else if(field926 < 8) {
                                 secretPacketBuffer1.put24bitInt(var7 + (field926 << 19) + 8388608);
                                 field926 = 0;
                              } else {
                                 secretPacketBuffer1.putInt((field926 << 19) + -1073741824 + var7);
                                 field926 = 0;
                              }
                           }
                        }

                        secretPacketBuffer1.method3156(secretPacketBuffer1.offset - var11);
                        if(var3 >= WorldMapType1.field443.field844) {
                           WorldMapType1.field443.field844 = 0;
                        } else {
                           WorldMapType1.field443.field844 -= var3;

                           for(var4 = 0; var4 < WorldMapType1.field443.field844; ++var4) {
                              WorldMapType1.field443.field847[var4] = WorldMapType1.field443.field847[var4 + var3];
                              WorldMapType1.field443.field846[var4] = WorldMapType1.field443.field846[var3 + var4];
                           }
                        }
                     }
                  }

                  if(class59.field713 == 1 || !ItemLayer.field1798 && class59.field713 == 4 || class59.field713 == 2) {
                     long var13 = (class59.field725 - field1083) / 50L;
                     if(var13 > 4095L) {
                        var13 = 4095L;
                     }

                     field1083 = class59.field725;
                     var3 = class59.field724;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > class2.canvasHeight) {
                        var3 = class2.canvasHeight;
                     }

                     var4 = class59.field723;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > class174.canvasWidth) {
                        var4 = class174.canvasWidth;
                     }

                     var5 = (int)var13;
                     secretPacketBuffer1.putOpcode(179);
                     secretPacketBuffer1.putShort((var5 << 1) + (class59.field713 == 2?1:0));
                     secretPacketBuffer1.putShort(var4);
                     secretPacketBuffer1.putShort(var3);
                  }

                  if(class50.field631 > 0) {
                     secretPacketBuffer1.putOpcode(49);
                     secretPacketBuffer1.putShort(0);
                     var1 = secretPacketBuffer1.offset;
                     long var15 = class134.method2587();

                     for(var4 = 0; var4 < class50.field631; ++var4) {
                        long var17 = var15 - field1140;
                        if(var17 > 16777215L) {
                           var17 = 16777215L;
                        }

                        field1140 = var15;
                        secretPacketBuffer1.method3199((int)var17);
                        secretPacketBuffer1.putByte(class50.field629[var4]);
                     }

                     secretPacketBuffer1.method3155(secretPacketBuffer1.offset - var1);
                  }

                  if(field1084 > 0) {
                     --field1084;
                  }

                  if(class50.field624[96] || class50.field624[97] || class50.field624[98] || class50.field624[99]) {
                     field920 = true;
                  }

                  if(field920 && field1084 <= 0) {
                     field1084 = 20;
                     field920 = false;
                     secretPacketBuffer1.putOpcode(114);
                     secretPacketBuffer1.putShort(mapAngle);
                     secretPacketBuffer1.putShort(field1107);
                  }

                  if(ScriptState.field760 && !field1178) {
                     field1178 = true;
                     secretPacketBuffer1.putOpcode(158);
                     secretPacketBuffer1.putByte(1);
                  }

                  if(!ScriptState.field760 && field1178) {
                     field1178 = false;
                     secretPacketBuffer1.putOpcode(158);
                     secretPacketBuffer1.putByte(0);
                  }

                  class31.method284();
                  if(gameState != 30) {
                     return;
                  }

                  class224.method4097();
                  class146.method2901();
                  ++field961;
                  if(field961 > 750) {
                     class210.method3941();
                     return;
                  }

                  class19.method165();

                  for(var1 = 0; var1 < field952; ++var1) {
                     var11 = npcIndices[var1];
                     NPC var19 = cachedNPCs[var11];
                     if(var19 != null) {
                        class73.method1089(var19, var19.composition.field3577);
                     }
                  }

                  int[] var28 = class96.field1501;

                  for(var11 = 0; var11 < class96.field1499; ++var11) {
                     Player var30 = cachedPlayers[var28[var11]];
                     if(var30 != null && var30.field1266 > 0) {
                        --var30.field1266;
                        if(var30.field1266 == 0) {
                           var30.overhead = null;
                        }
                     }
                  }

                  for(var11 = 0; var11 < field952; ++var11) {
                     var3 = npcIndices[var11];
                     NPC var20 = cachedNPCs[var3];
                     if(var20 != null && var20.field1266 > 0) {
                        --var20.field1266;
                        if(var20.field1266 == 0) {
                           var20.overhead = null;
                        }
                     }
                  }

                  ++field990;
                  if(cursorState != 0) {
                     field1024 += 20;
                     if(field1024 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class268.field3681 != null) {
                     ++field1026;
                     if(field1026 >= 15) {
                        CombatInfo1.method1515(class268.field3681);
                        class268.field3681 = null;
                     }
                  }

                  Widget var29 = class83.field1354;
                  Widget var26 = Preferences.field1319;
                  class83.field1354 = null;
                  Preferences.field1319 = null;
                  field1093 = null;
                  field1097 = false;
                  field927 = false;
                  field1137 = 0;

                  while(class25.method206() && field1137 < 128) {
                     if(rights >= 2 && class50.field624[82] && class82.field1337 == 66) {
                        String var31 = class69.method1076();
                        class46.field590.method936(var31);
                     } else {
                        field1139[field1137] = class82.field1337;
                        field1138[field1137] = class39.field535;
                        ++field1137;
                     }
                  }

                  if(widgetRoot != -1) {
                     class227.method4102(widgetRoot, 0, 0, class174.canvasWidth, class2.canvasHeight, 0, 0);
                  }

                  ++field1110;

                  while(true) {
                     Widget var21;
                     class69 var32;
                     Widget var33;
                     do {
                        var32 = (class69)field1116.method3604();
                        if(var32 == null) {
                           while(true) {
                              do {
                                 var32 = (class69)field1117.method3604();
                                 if(var32 == null) {
                                    while(true) {
                                       do {
                                          var32 = (class69)field1115.method3604();
                                          if(var32 == null) {
                                             this.method1400();
                                             if(FaceNormal.field2146 != null) {
                                                FaceNormal.field2146.method5226(class92.plane, (class168.localPlayer.x >> 7) + class61.baseX, (class168.localPlayer.y >> 7) + class23.baseY, false);
                                                FaceNormal.field2146.method5240();
                                             }

                                             if(field1089 != null) {
                                                this.method1337();
                                             }

                                             if(class98.field1529 != null) {
                                                CombatInfo1.method1515(class98.field1529);
                                                ++field1033;
                                                if(class59.field716 == 0) {
                                                   if(field1032) {
                                                      if(PendingSpawn.field1204 == class98.field1529 && field1031 != field1028) {
                                                         Widget var34 = class98.field1529;
                                                         byte var27 = 0;
                                                         if(field1079 == 1 && var34.contentType == 206) {
                                                            var27 = 1;
                                                         }

                                                         if(var34.itemIds[field1031] <= 0) {
                                                            var27 = 0;
                                                         }

                                                         if(class261.method4765(class251.method4472(var34))) {
                                                            var5 = field1028;
                                                            var6 = field1031;
                                                            var34.itemIds[var6] = var34.itemIds[var5];
                                                            var34.itemQuantities[var6] = var34.itemQuantities[var5];
                                                            var34.itemIds[var5] = -1;
                                                            var34.itemQuantities[var5] = 0;
                                                         } else if(var27 == 1) {
                                                            var5 = field1028;
                                                            var6 = field1031;

                                                            while(var6 != var5) {
                                                               if(var5 > var6) {
                                                                  var34.method4014(var5 - 1, var5);
                                                                  --var5;
                                                               } else if(var5 < var6) {
                                                                  var34.method4014(var5 + 1, var5);
                                                                  ++var5;
                                                               }
                                                            }
                                                         } else {
                                                            var34.method4014(field1031, field1028);
                                                         }

                                                         secretPacketBuffer1.putOpcode(143);
                                                         secretPacketBuffer1.method3191(field1031);
                                                         secretPacketBuffer1.method3184(var27);
                                                         secretPacketBuffer1.method3193(field1028);
                                                         secretPacketBuffer1.method3203(class98.field1529.id);
                                                      }
                                                   } else {
                                                      var3 = Script.method1824();
                                                      if(menuOptionCount > 2 && (field1052 == 1 && !Widget.method4009() || class28.method244(var3))) {
                                                         this.method1469(field1029, field996);
                                                      } else if(menuOptionCount > 0) {
                                                         class23.method192(field1029, field996);
                                                      }
                                                   }

                                                   field1026 = 10;
                                                   class59.field713 = 0;
                                                   class98.field1529 = null;
                                                } else if(field1033 >= 5 && (class59.field729 > field1029 + 5 || class59.field729 < field1029 - 5 || class59.field715 > field996 + 5 || class59.field715 < field996 - 5)) {
                                                   field1032 = true;
                                                }
                                             }

                                             if(Region.method2714()) {
                                                var3 = Region.selectedRegionTileX;
                                                var4 = Region.selectedRegionTileY;
                                                secretPacketBuffer1.putOpcode(201);
                                                secretPacketBuffer1.putByte(5);
                                                secretPacketBuffer1.method3192(class61.baseX + var3);
                                                secretPacketBuffer1.method3192(var4 + class23.baseY);
                                                secretPacketBuffer1.method3183(class50.field624[82]?(class50.field624[81]?2:1):0);
                                                Region.method2784();
                                                field1022 = class59.field723;
                                                field970 = class59.field724;
                                                cursorState = 1;
                                                field1024 = 0;
                                                detinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(class83.field1354 != var29) {
                                                if(var29 != null) {
                                                   CombatInfo1.method1515(var29);
                                                }

                                                if(class83.field1354 != null) {
                                                   CombatInfo1.method1515(class83.field1354);
                                                }
                                             }

                                             if(var26 != Preferences.field1319 && field1118 == field1094) {
                                                if(var26 != null) {
                                                   CombatInfo1.method1515(var26);
                                                }

                                                if(Preferences.field1319 != null) {
                                                   CombatInfo1.method1515(Preferences.field1319);
                                                }
                                             }

                                             if(Preferences.field1319 != null) {
                                                if(field1118 < field1094) {
                                                   ++field1118;
                                                   if(field1094 == field1118) {
                                                      CombatInfo1.method1515(Preferences.field1319);
                                                   }
                                                }
                                             } else if(field1118 > 0) {
                                                --field1118;
                                             }

                                             class238.method4283();
                                             if(field987) {
                                                class90.method1698();
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field1168[var3];
                                             }

                                             Tile.chatMessages.method1770();
                                             var3 = ++class59.mouseIdleTicks - 1;
                                             var5 = class50.keyboardIdleTicks;
                                             if(var3 > 15000 && var5 > 15000) {
                                                field966 = 250;
                                                class243.method4332(14500);
                                                secretPacketBuffer1.putOpcode(196);
                                             }

                                             ++field984;
                                             if(field984 > 500) {
                                                field984 = 0;
                                                var7 = (int)(Math.random() * 8.0D);
                                                if((var7 & 1) == 1) {
                                                   field1171 += field1160;
                                                }

                                                if((var7 & 2) == 2) {
                                                   field980 += field1161;
                                                }

                                                if((var7 & 4) == 4) {
                                                   field1125 += field983;
                                                }
                                             }

                                             if(field1171 < -50) {
                                                field1160 = 2;
                                             }

                                             if(field1171 > 50) {
                                                field1160 = -2;
                                             }

                                             if(field980 < -55) {
                                                field1161 = 2;
                                             }

                                             if(field980 > 55) {
                                                field1161 = -2;
                                             }

                                             if(field1125 < -40) {
                                                field983 = 1;
                                             }

                                             if(field1125 > 40) {
                                                field983 = -1;
                                             }

                                             ++field989;
                                             if(field989 > 500) {
                                                field989 = 0;
                                                var7 = (int)(Math.random() * 8.0D);
                                                if((var7 & 1) == 1) {
                                                   mapScale += mapOffset;
                                                }

                                                if((var7 & 2) == 2) {
                                                   mapScaleDelta += field1056;
                                                }
                                             }

                                             if(mapScale < -60) {
                                                mapOffset = 2;
                                             }

                                             if(mapScale > 60) {
                                                mapOffset = -2;
                                             }

                                             if(mapScaleDelta < -20) {
                                                field1056 = 1;
                                             }

                                             if(mapScaleDelta > 10) {
                                                field1056 = -1;
                                             }

                                             for(class67 var22 = (class67)field1185.method3646(); var22 != null; var22 = (class67)field1185.method3649()) {
                                                if((long)var22.field814 < class134.method2587() / 1000L - 5L) {
                                                   if(var22.field813 > 0) {
                                                      class98.sendGameMessage(5, "", var22.field809 + " has logged in.");
                                                   }

                                                   if(var22.field813 == 0) {
                                                      class98.sendGameMessage(5, "", var22.field809 + " has logged out.");
                                                   }

                                                   var22.method3655();
                                                }
                                             }

                                             ++audioEffectCount;
                                             if(audioEffectCount > 50) {
                                                secretPacketBuffer1.putOpcode(36);
                                             }

                                             try {
                                                if(class8.rssocket != null && secretPacketBuffer1.offset > 0) {
                                                   class8.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
                                                   secretPacketBuffer1.offset = 0;
                                                   audioEffectCount = 0;
                                                }
                                             } catch (IOException var23) {
                                                class210.method3941();
                                             }

                                             return;
                                          }

                                          var33 = var32.field824;
                                          if(var33.index < 0) {
                                             break;
                                          }

                                          var21 = class177.method3390(var33.parentId);
                                       } while(var21 == null || var21.children == null || var33.index >= var21.children.length || var21.children[var33.index] != var33);

                                       class227.method4101(var32);
                                    }
                                 }

                                 var33 = var32.field824;
                                 if(var33.index < 0) {
                                    break;
                                 }

                                 var21 = class177.method3390(var33.parentId);
                              } while(var21 == null || var21.children == null || var33.index >= var21.children.length || var33 != var21.children[var33.index]);

                              class227.method4101(var32);
                           }
                        }

                        var33 = var32.field824;
                        if(var33.index < 0) {
                           break;
                        }

                        var21 = class177.method3390(var33.parentId);
                     } while(var21 == null || var21.children == null || var33.index >= var21.children.length || var21.children[var33.index] != var33);

                     class227.method4101(var32);
                  }
               }

               secretPacketBuffer1.putOpcode(58);
               secretPacketBuffer1.putByte(0);
               var11 = secretPacketBuffer1.offset;
               Frames.method2885(secretPacketBuffer1);
               secretPacketBuffer1.method3156(secretPacketBuffer1.offset - var11);
            }
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-54"
   )
   protected final void vmethod1140() {
      field946 = class134.method2587() + 500L;
      this.method1377();
      if(widgetRoot != -1) {
         this.method1146(true);
      }

   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "13"
   )
   final void method1142() {
      if(widgetRoot != -1) {
         XClanMember.method1125(widgetRoot);
      }

      int var1;
      for(var1 = 0; var1 < field1119; ++var1) {
         if(field1121[var1]) {
            field1122[var1] = true;
         }

         field1123[var1] = field1121[var1];
         field1121[var1] = false;
      }

      field1067 = gameCycle;
      field1064 = -1;
      field1060 = -1;
      PendingSpawn.field1204 = null;
      if(widgetRoot != -1) {
         field1119 = 0;
         class22.method190(widgetRoot, 0, 0, class174.canvasWidth, class2.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.method4960();
      if(!isMenuOpen) {
         if(field1064 != -1) {
            class13.method87(field1064, field1060);
         }
      } else {
         Actor.method1511();
      }

      if(field1128 == 3) {
         for(var1 = 0; var1 < field1119; ++var1) {
            if(field1123[var1]) {
               Rasterizer2D.method5026(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1122[var1]) {
               Rasterizer2D.method5026(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = class92.plane;
      int var2 = class168.localPlayer.x;
      int var3 = class168.localPlayer.y;
      int var4 = field990;

      for(class82 var5 = (class82)class82.field1325.method3622(); var5 != null; var5 = (class82)class82.field1325.method3608()) {
         if(var5.field1329 != -1 || var5.field1333 != null) {
            int var6 = 0;
            if(var2 > var5.field1327) {
               var6 += var2 - var5.field1327;
            } else if(var2 < var5.field1322) {
               var6 += var5.field1322 - var2;
            }

            if(var3 > var5.field1334) {
               var6 += var3 - var5.field1334;
            } else if(var3 < var5.field1326) {
               var6 += var5.field1326 - var3;
            }

            if(var6 - 64 <= var5.field1328 && field1005 != 0 && var1 == var5.field1323) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               int var7 = (var5.field1328 - var6) * field1005 / var5.field1328;
               Object var10000;
               if(var5.field1330 == null) {
                  if(var5.field1329 >= 0) {
                     var10000 = null;
                     SoundEffect var12 = SoundEffect.method1922(RSCanvas.field655, var5.field1329, 0);
                     if(var12 != null) {
                        class107 var9 = var12.method1920().method1958(class165.field2334);
                        class117 var10 = class117.method2162(var9, 100, var7);
                        var10.method2124(-1);
                        WorldMapType0.field613.method1861(var10);
                        var5.field1330 = var10;
                     }
                  }
               } else {
                  var5.field1330.method2125(var7);
               }

               if(var5.field1335 == null) {
                  if(var5.field1333 != null && (var5.field1324 -= var4) <= 0) {
                     int var8 = (int)(Math.random() * (double)var5.field1333.length);
                     var10000 = null;
                     SoundEffect var13 = SoundEffect.method1922(RSCanvas.field655, var5.field1333[var8], 0);
                     if(var13 != null) {
                        class107 var14 = var13.method1920().method1958(class165.field2334);
                        class117 var11 = class117.method2162(var14, 100, var7);
                        var11.method2124(0);
                        WorldMapType0.field613.method1861(var11);
                        var5.field1335 = var11;
                        var5.field1324 = var5.field1331 + (int)(Math.random() * (double)(var5.field1332 - var5.field1331));
                     }
                  }
               } else {
                  var5.field1335.method2125(var7);
                  if(!var5.field1335.linked()) {
                     var5.field1335 = null;
                  }
               }
            } else {
               if(var5.field1330 != null) {
                  WorldMapType0.field613.method1862(var5.field1330);
                  var5.field1330 = null;
               }

               if(var5.field1335 != null) {
                  WorldMapType0.field613.method1862(var5.field1335);
                  var5.field1335 = null;
               }
            }
         }
      }

      field990 = 0;
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "902156351"
   )
   final boolean method1143() {
      if(class8.rssocket == null) {
         return false;
      } else {
         int var3;
         String var22;
         try {
            int var1 = class8.rssocket.available();
            if(var1 == 0) {
               return false;
            }

            if(field960 == -1) {
               class8.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               field960 = secretPacketBuffer2.readOpcode();
               packetLength = class272.field3705[field960];
               --var1;
            }

            if(packetLength == -1) {
               if(var1 <= 0) {
                  return false;
               }

               class8.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               packetLength = secretPacketBuffer2.payload[0] & 255;
               --var1;
            }

            if(packetLength == -2) {
               if(var1 <= 1) {
                  return false;
               }

               class8.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();
               var1 -= 2;
            }

            if(var1 < packetLength) {
               return false;
            }

            secretPacketBuffer2.offset = 0;
            class8.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
            field961 = 0;
            field965 = field964;
            field964 = field963;
            field963 = field960;
            if(field960 == 208) {
               FloorUnderlayDefinition.method4390(secretPacketBuffer2.readString());
               field960 = -1;
               return true;
            }

            int var2;
            if(field960 == 203) {
               var2 = secretPacketBuffer2.method3204();
               class88.field1387 = GameEngine.field678.method2938(var2);
               field960 = -1;
               return true;
            }

            if(field960 == 17) {
               var2 = secretPacketBuffer2.method3196();
               widgetRoot = var2;
               this.method1146(false);
               class22.method183(var2);
               class270.method4919(widgetRoot);

               for(var3 = 0; var3 < 100; ++var3) {
                  field1121[var3] = true;
               }

               field960 = -1;
               return true;
            }

            if(field960 == 226) {
               class40.method543();
               energy = secretPacketBuffer2.readUnsignedByte();
               field1113 = field1110;
               field960 = -1;
               return true;
            }

            if(field960 == 67) {
               field938 = secretPacketBuffer2.readUnsignedByte();
               field1133 = secretPacketBuffer2.readUnsignedByte();
               field960 = -1;
               return true;
            }

            int var4;
            int var5;
            int var6;
            int var7;
            if(field960 == 35) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.readUnsignedShort();
               var4 = var3 >> 10 & 31;
               var5 = var3 >> 5 & 31;
               var6 = var3 & 31;
               var7 = (var5 << 11) + (var4 << 19) + (var6 << 3);
               Widget var81 = class177.method3390(var2);
               if(var7 != var81.textColor) {
                  var81.textColor = var7;
                  CombatInfo1.method1515(var81);
               }

               field960 = -1;
               return true;
            }

            int var24;
            boolean var76;
            boolean var77;
            if(field960 == 64) {
               var22 = secretPacketBuffer2.readString();
               var3 = secretPacketBuffer2.readUnsignedShort();
               byte var86 = secretPacketBuffer2.readByte();
               var77 = false;
               if(var86 == -128) {
                  var77 = true;
               }

               if(var77) {
                  if(class24.clanChatCount == 0) {
                     field960 = -1;
                     return true;
                  }

                  var76 = false;

                  for(var6 = 0; var6 < class24.clanChatCount && (!class2.clanMembers[var6].username.equals(var22) || class2.clanMembers[var6].world != var3); ++var6) {
                     ;
                  }

                  if(var6 < class24.clanChatCount) {
                     while(var6 < class24.clanChatCount - 1) {
                        class2.clanMembers[var6] = class2.clanMembers[var6 + 1];
                        ++var6;
                     }

                     --class24.clanChatCount;
                     class2.clanMembers[class24.clanChatCount] = null;
                  }
               } else {
                  secretPacketBuffer2.readString();
                  XClanMember var104 = new XClanMember();
                  var104.username = var22;
                  var104.field898 = CollisionData.method3023(var104.username, class13.field281);
                  var104.world = var3;
                  var104.rank = var86;

                  for(var7 = class24.clanChatCount - 1; var7 >= 0; --var7) {
                     var24 = class2.clanMembers[var7].field898.compareTo(var104.field898);
                     if(var24 == 0) {
                        class2.clanMembers[var7].world = var3;
                        class2.clanMembers[var7].rank = var86;
                        if(var22.equals(class168.localPlayer.name)) {
                           class116.clanChatRank = var86;
                        }

                        field1013 = field1110;
                        field960 = -1;
                        return true;
                     }

                     if(var24 < 0) {
                        break;
                     }
                  }

                  if(class24.clanChatCount >= class2.clanMembers.length) {
                     field960 = -1;
                     return true;
                  }

                  for(var24 = class24.clanChatCount - 1; var24 > var7; --var24) {
                     class2.clanMembers[var24 + 1] = class2.clanMembers[var24];
                  }

                  if(class24.clanChatCount == 0) {
                     class2.clanMembers = new XClanMember[100];
                  }

                  class2.clanMembers[var7 + 1] = var104;
                  ++class24.clanChatCount;
                  if(var22.equals(class168.localPlayer.name)) {
                     class116.clanChatRank = var86;
                  }
               }

               field1013 = field1110;
               field960 = -1;
               return true;
            }

            Widget var105;
            if(field960 == 219) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.method3206();
               var105 = class177.method3390(var3);
               if(var105 != null && var105.type == 0) {
                  if(var2 > var105.scrollHeight - var105.height) {
                     var2 = var105.scrollHeight - var105.height;
                  }

                  if(var2 < 0) {
                     var2 = 0;
                  }

                  if(var2 != var105.scrollY) {
                     var105.scrollY = var2;
                     CombatInfo1.method1515(var105);
                  }
               }

               field960 = -1;
               return true;
            }

            if(field960 == 217) {
               class20.method166();
               field960 = -1;
               return false;
            }

            if(field960 == 114) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.readUnsignedShort();
               if(var2 < -70000) {
                  var3 += '耀';
               }

               if(var2 >= 0) {
                  var105 = class177.method3390(var2);
               } else {
                  var105 = null;
               }

               for(; secretPacketBuffer2.offset < packetLength; Actor.method1510(var3, var5, var6 - 1, var7)) {
                  var5 = secretPacketBuffer2.method3172();
                  var6 = secretPacketBuffer2.readUnsignedShort();
                  var7 = 0;
                  if(var6 != 0) {
                     var7 = secretPacketBuffer2.readUnsignedByte();
                     if(var7 == 255) {
                        var7 = secretPacketBuffer2.readInt();
                     }
                  }

                  if(var105 != null && var5 >= 0 && var5 < var105.itemIds.length) {
                     var105.itemIds[var5] = var6;
                     var105.itemQuantities[var5] = var7;
                  }
               }

               if(var105 != null) {
                  CombatInfo1.method1515(var105);
               }

               class40.method543();
               interfaceItemTriggers[++field924 - 1 & 31] = var3 & 32767;
               field960 = -1;
               return true;
            }

            if(field960 == 82) {
               field987 = true;
               class12.field273 = secretPacketBuffer2.readUnsignedByte();
               MessageNode.field856 = secretPacketBuffer2.readUnsignedByte();
               PacketBuffer.field2429 = secretPacketBuffer2.readUnsignedShort();
               class25.field373 = secretPacketBuffer2.readUnsignedByte();
               WallObject.field2136 = secretPacketBuffer2.readUnsignedByte();
               if(WallObject.field2136 >= 100) {
                  class2.cameraX = class12.field273 * 128 + 64;
                  XItemContainer.cameraY = MessageNode.field856 * 128 + 64;
                  class203.cameraZ = class181.method3424(class2.cameraX, XItemContainer.cameraY, class92.plane) - PacketBuffer.field2429;
               }

               field960 = -1;
               return true;
            }

            if(field960 == 63) {
               var2 = secretPacketBuffer2.method3196();
               byte var93 = secretPacketBuffer2.readByte();
               class211.settings[var2] = var93;
               if(class211.widgetSettings[var2] != var93) {
                  class211.widgetSettings[var2] = var93;
               }

               class77.method1483(var2);
               field1102[++field1103 - 1 & 31] = var2;
               field960 = -1;
               return true;
            }

            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var19;
            byte[] var20;
            String var21;
            int var28;
            int var29;
            Buffer var30;
            int var82;
            byte[] var83;
            byte var84;
            class230 var85;
            Buffer var89;
            byte var91;
            boolean var94;
            String var95;
            PacketBuffer var113;
            Player var116;
            boolean var123;
            if(field960 == 157) {
               class123.xteaChanged(false);
               secretPacketBuffer2.readOpcode();
               var2 = secretPacketBuffer2.readUnsignedShort();
               var113 = secretPacketBuffer2;
               var4 = var113.offset;
               class96.field1507 = 0;
               var5 = 0;
               var113.method3399();

               for(var6 = 0; var6 < class96.field1499; ++var6) {
                  var7 = class96.field1501[var6];
                  if((class96.field1503[var7] & 1) == 0) {
                     if(var5 > 0) {
                        --var5;
                        class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                     } else {
                        var24 = var113.method3400(1);
                        if(var24 == 0) {
                           var5 = class66.method1062(var113);
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        } else {
                           class21.method173(var113, var7);
                        }
                     }
                  }
               }

               var113.method3401();
               if(var5 != 0) {
                  throw new RuntimeException();
               }

               var113.method3399();

               for(var6 = 0; var6 < class96.field1499; ++var6) {
                  var7 = class96.field1501[var6];
                  if((class96.field1503[var7] & 1) != 0) {
                     if(var5 > 0) {
                        --var5;
                        class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                     } else {
                        var24 = var113.method3400(1);
                        if(var24 == 0) {
                           var5 = class66.method1062(var113);
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        } else {
                           class21.method173(var113, var7);
                        }
                     }
                  }
               }

               var113.method3401();
               if(var5 != 0) {
                  throw new RuntimeException();
               }

               var113.method3399();

               for(var6 = 0; var6 < class96.field1502; ++var6) {
                  var7 = class96.field1511[var6];
                  if((class96.field1503[var7] & 1) != 0) {
                     if(var5 > 0) {
                        --var5;
                        class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                     } else {
                        var24 = var113.method3400(1);
                        if(var24 == 0) {
                           var5 = class66.method1062(var113);
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        } else if(class87.method1684(var113, var7)) {
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        }
                     }
                  }
               }

               var113.method3401();
               if(var5 != 0) {
                  throw new RuntimeException();
               }

               var113.method3399();

               for(var6 = 0; var6 < class96.field1502; ++var6) {
                  var7 = class96.field1511[var6];
                  if((class96.field1503[var7] & 1) == 0) {
                     if(var5 > 0) {
                        --var5;
                        class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                     } else {
                        var24 = var113.method3400(1);
                        if(var24 == 0) {
                           var5 = class66.method1062(var113);
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        } else if(class87.method1684(var113, var7)) {
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        }
                     }
                  }
               }

               var113.method3401();
               if(var5 != 0) {
                  throw new RuntimeException();
               }

               class96.field1499 = 0;
               class96.field1502 = 0;

               for(var6 = 1; var6 < 2048; ++var6) {
                  class96.field1503[var6] = (byte)(class96.field1503[var6] >> 1);
                  var116 = cachedPlayers[var6];
                  if(var116 != null) {
                     class96.field1501[++class96.field1499 - 1] = var6;
                  } else {
                     class96.field1511[++class96.field1502 - 1] = var6;
                  }
               }

               for(var5 = 0; var5 < class96.field1507; ++var5) {
                  var6 = class96.field1508[var5];
                  var116 = cachedPlayers[var6];
                  var24 = var113.readUnsignedByte();
                  if((var24 & 8) != 0) {
                     var24 += var113.readUnsignedByte() << 8;
                  }

                  var84 = -1;
                  if((var24 & 1) != 0) {
                     var82 = var113.readUnsignedByte();
                     var83 = new byte[var82];
                     var89 = new Buffer(var83);
                     var113.readBytes(var83, 0, var82);
                     class96.field1497[var6] = var89;
                     var116.method1109(var89);
                  }

                  if((var24 & 128) != 0) {
                     var82 = var113.readUnsignedShort();
                     if(var82 == '\uffff') {
                        var82 = -1;
                     }

                     var28 = var113.readUnsignedByte();
                     class37.method499(var116, var82, var28);
                  }

                  if((var24 & 4) != 0) {
                     var116.interacting = var113.readUnsignedShort();
                     if(var116.interacting == '\uffff') {
                        var116.interacting = -1;
                     }
                  }

                  if((var24 & 32) != 0) {
                     var116.overhead = var113.readString();
                     if(var116.overhead.charAt(0) == 126) {
                        var116.overhead = var116.overhead.substring(1);
                        class98.sendGameMessage(2, var116.name, var116.overhead);
                     } else if(class168.localPlayer == var116) {
                        class98.sendGameMessage(2, var116.name, var116.overhead);
                     }

                     var116.field1240 = false;
                     var116.field1243 = 0;
                     var116.field1244 = 0;
                     var116.field1266 = 150;
                  }

                  if((var24 & 16) != 0) {
                     var82 = var113.readUnsignedByte();
                     if(var82 > 0) {
                        for(var28 = 0; var28 < var82; ++var28) {
                           var13 = -1;
                           var14 = -1;
                           var15 = -1;
                           var29 = var113.method3172();
                           if(var29 == 32767) {
                              var29 = var113.method3172();
                              var14 = var113.method3172();
                              var13 = var113.method3172();
                              var15 = var113.method3172();
                           } else if(var29 != 32766) {
                              var14 = var113.method3172();
                           } else {
                              var29 = -1;
                           }

                           var16 = var113.method3172();
                           var116.method1502(var29, var14, var13, var15, gameCycle, var16);
                        }
                     }

                     var28 = var113.readUnsignedByte();
                     if(var28 > 0) {
                        for(var29 = 0; var29 < var28; ++var29) {
                           var13 = var113.method3172();
                           var14 = var113.method3172();
                           if(var14 != 32767) {
                              var15 = var113.method3172();
                              var16 = var113.readUnsignedByte();
                              var17 = var14 > 0?var113.readUnsignedByte():var16;
                              var116.method1495(var13, gameCycle, var14, var15, var16, var17);
                           } else {
                              var116.method1506(var13);
                           }
                        }
                     }
                  }

                  if((var24 & 2) != 0) {
                     var116.field1254 = var113.readUnsignedShort();
                     if(var116.queueSize == 0) {
                        var116.orientation = var116.field1254;
                        var116.field1254 = -1;
                     }
                  }

                  if((var24 & 64) != 0) {
                     var82 = var113.readUnsignedShort();
                     var85 = (class230)Projectile.method1737(class166.method3083(), var113.readUnsignedByte());
                     var123 = var113.readUnsignedByte() == 1;
                     var13 = var113.readUnsignedByte();
                     var14 = var113.offset;
                     if(var116.name != null && var116.composition != null) {
                        var94 = false;
                        if(var85.field3176 && class169.method3124(var116.name)) {
                           var94 = true;
                        }

                        if(!var94 && field1034 == 0 && !var116.hidden) {
                           class96.field1509.offset = 0;
                           var113.readBytes(class96.field1509.payload, 0, var13);
                           class96.field1509.offset = 0;
                           var30 = class96.field1509;

                           try {
                              var19 = var30.method3172();
                              if(var19 > 32767) {
                                 var19 = 32767;
                              }

                              var20 = new byte[var19];
                              var30.offset += class265.field3670.method3079(var30.payload, var30.offset, var20, 0, var19);
                              var21 = WorldMapType2.method528(var20, 0, var19);
                              var95 = var21;
                           } catch (Exception var66) {
                              var95 = "Cabbage";
                           }

                           var95 = FontTypeFace.method4815(IndexDataBase.method4221(var95));
                           var116.overhead = var95.trim();
                           var116.field1243 = var82 >> 8;
                           var116.field1244 = var82 & 255;
                           var116.field1266 = 150;
                           var116.field1240 = var123;
                           var116.inSequence = var116 != class168.localPlayer && var85.field3176 && "" != field1014 && var95.toLowerCase().indexOf(field1014) == -1;
                           if(var85.field3179) {
                              var19 = var123?91:1;
                           } else {
                              var19 = var123?90:2;
                           }

                           if(var85.field3174 != -1) {
                              class98.sendGameMessage(var19, class64.method1058(var85.field3174) + var116.name, var95);
                           } else {
                              class98.sendGameMessage(var19, var116.name, var95);
                           }
                        }
                     }

                     var113.offset = var14 + var13;
                  }

                  if((var24 & 1024) != 0) {
                     var116.graphic = var113.readUnsignedShort();
                     var82 = var113.readInt();
                     var116.field1279 = var82 >> 16;
                     var116.field1256 = (var82 & '\uffff') + gameCycle;
                     var116.field1264 = 0;
                     var116.field1249 = 0;
                     if(var116.field1256 > gameCycle) {
                        var116.field1264 = -1;
                     }

                     if(var116.graphic == '\uffff') {
                        var116.graphic = -1;
                     }
                  }

                  if((var24 & 256) != 0) {
                     var116.field1268 = var113.readByte();
                     var116.field1286 = var113.readByte();
                     var116.field1269 = var113.readByte();
                     var116.field1271 = var113.readByte();
                     var116.field1272 = var113.readUnsignedShort() + gameCycle;
                     var116.field1273 = var113.readUnsignedShort() + gameCycle;
                     var116.field1274 = var113.readUnsignedShort();
                     if(var116.field893) {
                        var116.field1268 += var116.field894;
                        var116.field1286 += var116.field875;
                        var116.field1269 += var116.field894;
                        var116.field1271 += var116.field875;
                        var116.queueSize = 0;
                     } else {
                        var116.field1268 += var116.pathX[0];
                        var116.field1286 += var116.pathY[0];
                        var116.field1269 += var116.pathX[0];
                        var116.field1271 += var116.pathY[0];
                        var116.queueSize = 1;
                     }

                     var116.field1285 = 0;
                  }

                  if((var24 & 4096) != 0) {
                     class96.field1498[var6] = var113.readByte();
                  }

                  if((var24 & 2048) != 0) {
                     var84 = var113.readByte();
                  }

                  if((var24 & 512) != 0) {
                     for(var82 = 0; var82 < 3; ++var82) {
                        var116.actions[var82] = var113.readString();
                     }
                  }

                  if(var116.field893) {
                     if(var84 == 127) {
                        var116.method1123(var116.field894, var116.field875);
                     } else {
                        if(var84 != -1) {
                           var91 = var84;
                        } else {
                           var91 = class96.field1498[var6];
                        }

                        var116.method1096(var116.field894, var116.field875, var91);
                     }
                  }
               }

               if(var2 != var113.offset - var4) {
                  throw new RuntimeException(var113.offset - var4 + " " + var2);
               }

               field960 = -1;
               return true;
            }

            if(field960 == 5 || field960 == 27 || field960 == 31 || field960 == 246 || field960 == 236 || field960 == 77 || field960 == 180 || field960 == 47 || field960 == 90 || field960 == 173) {
               class34.method489();
               field960 = -1;
               return true;
            }

            if(field960 == 68) {
               for(var2 = 0; var2 < class241.field3289; ++var2) {
                  class241 var121 = Item.method1741(var2);
                  if(var121 != null) {
                     class211.settings[var2] = 0;
                     class211.widgetSettings[var2] = 0;
                  }
               }

               class40.method543();
               field1103 += 32;
               field960 = -1;
               return true;
            }

            if(field960 == 4) {
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

               field960 = -1;
               return true;
            }

            Widget var108;
            if(field960 == 169) {
               var2 = secretPacketBuffer2.method3206();
               var108 = class177.method3390(var2);

               for(var4 = 0; var4 < var108.itemIds.length; ++var4) {
                  var108.itemIds[var4] = -1;
                  var108.itemIds[var4] = 0;
               }

               CombatInfo1.method1515(var108);
               field960 = -1;
               return true;
            }

            String var109;
            if(field960 == 11) {
               var2 = secretPacketBuffer2.method3173();
               var109 = secretPacketBuffer2.readString();
               var105 = class177.method3390(var2);
               if(!var109.equals(var105.text)) {
                  var105.text = var109;
                  CombatInfo1.method1515(var105);
               }

               field960 = -1;
               return true;
            }

            if(field960 == 57) {
               var22 = secretPacketBuffer2.readString();
               Object[] var117 = new Object[var22.length() + 1];

               for(var4 = var22.length() - 1; var4 >= 0; --var4) {
                  if(var22.charAt(var4) == 115) {
                     var117[var4 + 1] = secretPacketBuffer2.readString();
                  } else {
                     var117[var4 + 1] = new Integer(secretPacketBuffer2.readInt());
                  }
               }

               var117[0] = new Integer(secretPacketBuffer2.readInt());
               class69 var125 = new class69();
               var125.field833 = var117;
               class227.method4101(var125);
               field960 = -1;
               return true;
            }

            if(field960 == 245) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               if(secretPacketBuffer2.readUnsignedByte() == 0) {
                  grandExchangeOffers[var2] = new XGrandExchangeOffer();
                  secretPacketBuffer2.offset += 18;
               } else {
                  --secretPacketBuffer2.offset;
                  grandExchangeOffers[var2] = new XGrandExchangeOffer(secretPacketBuffer2, false);
               }

               field1111 = field1110;
               field960 = -1;
               return true;
            }

            if(field960 == 207) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.readUnsignedByte();
               var4 = secretPacketBuffer2.readUnsignedShort();
               if(field1155 != 0 && var3 != 0 && field1077 < 50) {
                  field1158[field1077] = var2;
                  field1159[field1077] = var3;
                  field1049[field1077] = var4;
                  audioEffects[field1077] = null;
                  field1101[field1077] = 0;
                  ++field1077;
               }

               field960 = -1;
               return true;
            }

            Widget var129;
            if(field960 == 28) {
               var2 = secretPacketBuffer2.method3194();
               var3 = secretPacketBuffer2.method3196();
               var4 = secretPacketBuffer2.method3206();
               var129 = class177.method3390(var4);
               var129.field2708 = var2 + (var3 << 16);
               field960 = -1;
               return true;
            }

            if(field960 == 108) {
               field987 = false;

               for(var2 = 0; var2 < 5; ++var2) {
                  field1164[var2] = false;
               }

               field960 = -1;
               return true;
            }

            if(field960 == 187) {
               var2 = secretPacketBuffer2.method3194();
               var3 = secretPacketBuffer2.readInt();
               class211.settings[var2] = var3;
               if(var3 != class211.widgetSettings[var2]) {
                  class211.widgetSettings[var2] = var3;
               }

               class77.method1483(var2);
               field1102[++field1103 - 1 & 31] = var2;
               field960 = -1;
               return true;
            }

            if(field960 == 123) {
               class8.method45(false);
               field960 = -1;
               return true;
            }

            if(field960 == 60) {
               class20.field337 = Widget.method4064(secretPacketBuffer2.readUnsignedByte());
               field960 = -1;
               return true;
            }

            Widget var23;
            WidgetNode var127;
            if(field960 == 62) {
               var2 = secretPacketBuffer2.method3173();
               var3 = secretPacketBuffer2.method3204();
               WidgetNode var124 = (WidgetNode)componentTable.method3545((long)var3);
               var127 = (WidgetNode)componentTable.method3545((long)var2);
               if(var127 != null) {
                  WorldMapType3.method231(var127, var124 == null || var127.id != var124.id);
               }

               if(var124 != null) {
                  var124.unlink();
                  componentTable.method3546(var124, (long)var2);
               }

               var23 = class177.method3390(var3);
               if(var23 != null) {
                  CombatInfo1.method1515(var23);
               }

               var23 = class177.method3390(var2);
               if(var23 != null) {
                  CombatInfo1.method1515(var23);
                  class21.method174(Widget.widgets[var23.id >>> 16], var23, true);
               }

               if(widgetRoot != -1) {
                  var7 = widgetRoot;
                  if(class73.method1095(var7)) {
                     class261.method4764(Widget.widgets[var7], 1);
                  }
               }

               field960 = -1;
               return true;
            }

            if(field960 == 250) {
               for(var2 = 0; var2 < class211.widgetSettings.length; ++var2) {
                  if(class211.widgetSettings[var2] != class211.settings[var2]) {
                     class211.widgetSettings[var2] = class211.settings[var2];
                     class77.method1483(var2);
                     field1102[++field1103 - 1 & 31] = var2;
                  }
               }

               field960 = -1;
               return true;
            }

            if(field960 == 39) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               var3 = secretPacketBuffer2.readUnsignedByte();
               var4 = secretPacketBuffer2.readUnsignedByte();
               var5 = secretPacketBuffer2.readUnsignedByte();
               field1164[var2] = true;
               field1165[var2] = var3;
               field1190[var2] = var4;
               field1167[var2] = var5;
               field1168[var2] = 0;
               field960 = -1;
               return true;
            }

            if(field960 == 26) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.method3198();
               var105 = class177.method3390(var2);
               if(var105.field2699 != var3 || var3 == -1) {
                  var105.field2699 = var3;
                  var105.field2774 = 0;
                  var105.field2662 = 0;
                  CombatInfo1.method1515(var105);
               }

               field960 = -1;
               return true;
            }

            if(field960 == 252) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.readShort();
               var4 = secretPacketBuffer2.method3197();
               var129 = class177.method3390(var2);
               if(var129.originalX != var4 || var129.originalY != var3 || var129.field2681 != 0 || var129.field2777 != 0) {
                  var129.originalX = var4;
                  var129.originalY = var3;
                  var129.field2681 = 0;
                  var129.field2777 = 0;
                  CombatInfo1.method1515(var129);
                  this.method1418(var129);
                  if(var129.type == 0) {
                     class21.method174(Widget.widgets[var2 >> 16], var129, false);
                  }
               }

               field960 = -1;
               return true;
            }

            if(field960 == 49) {
               field1081 = secretPacketBuffer2.method3195() * 30;
               field1113 = field1110;
               field960 = -1;
               return true;
            }

            long var34;
            long var36;
            long var38;
            long var41;
            if(field960 == 240) {
               var22 = secretPacketBuffer2.readString();
               var34 = secretPacketBuffer2.readLong();
               var36 = (long)secretPacketBuffer2.readUnsignedShort();
               var38 = (long)secretPacketBuffer2.read24BitInt();
               class230 var131 = (class230)Projectile.method1737(class166.method3083(), secretPacketBuffer2.readUnsignedByte());
               var41 = var38 + (var36 << 32);
               var123 = false;

               for(var13 = 0; var13 < 100; ++var13) {
                  if(field1135[var13] == var41) {
                     var123 = true;
                     break;
                  }
               }

               if(var131.field3176 && class169.method3124(var22)) {
                  var123 = true;
               }

               if(!var123 && field1034 == 0) {
                  field1135[field1174] = var41;
                  field1174 = (field1174 + 1) % 100;
                  PacketBuffer var132 = secretPacketBuffer2;

                  String var134;
                  try {
                     var16 = var132.method3172();
                     if(var16 > 32767) {
                        var16 = 32767;
                     }

                     byte[] var122 = new byte[var16];
                     var132.offset += class265.field3670.method3079(var132.payload, var132.offset, var122, 0, var16);
                     var95 = WorldMapType2.method528(var122, 0, var16);
                     var134 = var95;
                  } catch (Exception var65) {
                     var134 = "Cabbage";
                  }

                  var134 = FontTypeFace.method4815(IndexDataBase.method4221(var134));
                  if(var131.field3174 != -1) {
                     class220.addChatMessage(9, class64.method1058(var131.field3174) + var22, var134, class146.method2902(var34));
                  } else {
                     class220.addChatMessage(9, var22, var134, class146.method2902(var34));
                  }
               }

               field960 = -1;
               return true;
            }

            if(field960 == 38) {
               var2 = secretPacketBuffer2.method3187();
               var3 = secretPacketBuffer2.method3206();
               var4 = secretPacketBuffer2.method3195();
               var127 = (WidgetNode)componentTable.method3545((long)var3);
               if(var127 != null) {
                  WorldMapType3.method231(var127, var4 != var127.id);
               }

               class232.method4120(var3, var4, var2);
               field960 = -1;
               return true;
            }

            if(field960 == 18) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.readUnsignedShort();
               if(var2 < -70000) {
                  var3 += '耀';
               }

               if(var2 >= 0) {
                  var105 = class177.method3390(var2);
               } else {
                  var105 = null;
               }

               if(var105 != null) {
                  for(var5 = 0; var5 < var105.itemIds.length; ++var5) {
                     var105.itemIds[var5] = 0;
                     var105.itemQuantities[var5] = 0;
                  }
               }

               ObjectComposition.method4582(var3);
               var5 = secretPacketBuffer2.readUnsignedShort();

               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = secretPacketBuffer2.method3188();
                  if(var7 == 255) {
                     var7 = secretPacketBuffer2.method3206();
                  }

                  var24 = secretPacketBuffer2.method3196();
                  if(var105 != null && var6 < var105.itemIds.length) {
                     var105.itemIds[var6] = var24;
                     var105.itemQuantities[var6] = var7;
                  }

                  Actor.method1510(var3, var6, var24 - 1, var7);
               }

               if(var105 != null) {
                  CombatInfo1.method1515(var105);
               }

               class40.method543();
               interfaceItemTriggers[++field924 - 1 & 31] = var3 & 32767;
               field960 = -1;
               return true;
            }

            boolean var79;
            String var110;
            String var128;
            if(field960 == 143) {
               while(secretPacketBuffer2.offset < packetLength) {
                  var2 = secretPacketBuffer2.readUnsignedByte();
                  var79 = (var2 & 1) == 1;
                  var110 = secretPacketBuffer2.readString();
                  var128 = secretPacketBuffer2.readString();
                  secretPacketBuffer2.readString();

                  for(var6 = 0; var6 < ignoreCount; ++var6) {
                     Ignore var120 = ignores[var6];
                     if(var79) {
                        if(var128.equals(var120.name)) {
                           var120.name = var110;
                           var120.previousName = var128;
                           var110 = null;
                           break;
                        }
                     } else if(var110.equals(var120.name)) {
                        var120.name = var110;
                        var120.previousName = var128;
                        var110 = null;
                        break;
                     }
                  }

                  if(var110 != null && ignoreCount < 400) {
                     Ignore var102 = new Ignore();
                     ignores[ignoreCount] = var102;
                     var102.name = var110;
                     var102.previousName = var128;
                     ++ignoreCount;
                  }
               }

               field1109 = field1110;
               field960 = -1;
               return true;
            }

            if(field960 == 29) {
               class8.method45(true);
               field960 = -1;
               return true;
            }

            boolean var75;
            if(field960 == 130) {
               while(secretPacketBuffer2.offset < packetLength) {
                  var75 = secretPacketBuffer2.readUnsignedByte() == 1;
                  var109 = secretPacketBuffer2.readString();
                  var110 = secretPacketBuffer2.readString();
                  var5 = secretPacketBuffer2.readUnsignedShort();
                  var6 = secretPacketBuffer2.readUnsignedByte();
                  var7 = secretPacketBuffer2.readUnsignedByte();
                  boolean var118 = (var7 & 2) != 0;
                  boolean var90 = (var7 & 1) != 0;
                  if(var5 > 0) {
                     secretPacketBuffer2.readString();
                     secretPacketBuffer2.readUnsignedByte();
                     secretPacketBuffer2.readInt();
                  }

                  secretPacketBuffer2.readString();

                  for(var82 = 0; var82 < friendCount; ++var82) {
                     Friend var88 = friends[var82];
                     if(!var75) {
                        if(var109.equals(var88.name)) {
                           if(var88.world != var5) {
                              var123 = true;

                              for(class67 var137 = (class67)field1185.method3646(); var137 != null; var137 = (class67)field1185.method3649()) {
                                 if(var137.field809.equals(var109)) {
                                    if(var5 != 0 && var137.field813 == 0) {
                                       var137.method3655();
                                       var123 = false;
                                    } else if(var5 == 0 && var137.field813 != 0) {
                                       var137.method3655();
                                       var123 = false;
                                    }
                                 }
                              }

                              if(var123) {
                                 field1185.method3645(new class67(var109, var5));
                              }

                              var88.world = var5;
                           }

                           var88.previousName = var110;
                           var88.rank = var6;
                           var88.field793 = var118;
                           var88.field794 = var90;
                           var109 = null;
                           break;
                        }
                     } else if(var110.equals(var88.name)) {
                        var88.name = var109;
                        var88.previousName = var110;
                        var109 = null;
                        break;
                     }
                  }

                  if(var109 != null && friendCount < 400) {
                     Friend var135 = new Friend();
                     friends[friendCount] = var135;
                     var135.name = var109;
                     var135.previousName = var110;
                     var135.world = var5;
                     var135.rank = var6;
                     var135.field793 = var118;
                     var135.field794 = var90;
                     ++friendCount;
                  }
               }

               field1183 = 2;
               field1109 = field1110;
               var75 = false;
               var3 = friendCount;

               while(var3 > 0) {
                  var75 = true;
                  --var3;

                  for(var4 = 0; var4 < var3; ++var4) {
                     var77 = false;
                     Friend var101 = friends[var4];
                     Friend var119 = friends[var4 + 1];
                     if(var101.world != world && var119.world == world) {
                        var77 = true;
                     }

                     if(!var77 && var101.world == 0 && var119.world != 0) {
                        var77 = true;
                     }

                     if(!var77 && !var101.field793 && var119.field793) {
                        var77 = true;
                     }

                     if(!var77 && !var101.field794 && var119.field794) {
                        var77 = true;
                     }

                     if(var77) {
                        Friend var80 = friends[var4];
                        friends[var4] = friends[var4 + 1];
                        friends[var4 + 1] = var80;
                        var75 = false;
                     }
                  }

                  if(var75) {
                     break;
                  }
               }

               field960 = -1;
               return true;
            }

            if(field960 == 239) {
               class123.xteaChanged(true);
               secretPacketBuffer2.readOpcode();
               var2 = secretPacketBuffer2.readUnsignedShort();
               var113 = secretPacketBuffer2;
               var4 = var113.offset;
               class96.field1507 = 0;
               var5 = 0;
               var113.method3399();

               for(var6 = 0; var6 < class96.field1499; ++var6) {
                  var7 = class96.field1501[var6];
                  if((class96.field1503[var7] & 1) == 0) {
                     if(var5 > 0) {
                        --var5;
                        class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                     } else {
                        var24 = var113.method3400(1);
                        if(var24 == 0) {
                           var5 = class66.method1062(var113);
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        } else {
                           class21.method173(var113, var7);
                        }
                     }
                  }
               }

               var113.method3401();
               if(var5 != 0) {
                  throw new RuntimeException();
               }

               var113.method3399();

               for(var6 = 0; var6 < class96.field1499; ++var6) {
                  var7 = class96.field1501[var6];
                  if((class96.field1503[var7] & 1) != 0) {
                     if(var5 > 0) {
                        --var5;
                        class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                     } else {
                        var24 = var113.method3400(1);
                        if(var24 == 0) {
                           var5 = class66.method1062(var113);
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        } else {
                           class21.method173(var113, var7);
                        }
                     }
                  }
               }

               var113.method3401();
               if(var5 != 0) {
                  throw new RuntimeException();
               }

               var113.method3399();

               for(var6 = 0; var6 < class96.field1502; ++var6) {
                  var7 = class96.field1511[var6];
                  if((class96.field1503[var7] & 1) != 0) {
                     if(var5 > 0) {
                        --var5;
                        class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                     } else {
                        var24 = var113.method3400(1);
                        if(var24 == 0) {
                           var5 = class66.method1062(var113);
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        } else if(class87.method1684(var113, var7)) {
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        }
                     }
                  }
               }

               var113.method3401();
               if(var5 != 0) {
                  throw new RuntimeException();
               }

               var113.method3399();

               for(var6 = 0; var6 < class96.field1502; ++var6) {
                  var7 = class96.field1511[var6];
                  if((class96.field1503[var7] & 1) == 0) {
                     if(var5 > 0) {
                        --var5;
                        class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                     } else {
                        var24 = var113.method3400(1);
                        if(var24 == 0) {
                           var5 = class66.method1062(var113);
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        } else if(class87.method1684(var113, var7)) {
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        }
                     }
                  }
               }

               var113.method3401();
               if(var5 != 0) {
                  throw new RuntimeException();
               }

               class96.field1499 = 0;
               class96.field1502 = 0;

               for(var6 = 1; var6 < 2048; ++var6) {
                  class96.field1503[var6] = (byte)(class96.field1503[var6] >> 1);
                  var116 = cachedPlayers[var6];
                  if(var116 != null) {
                     class96.field1501[++class96.field1499 - 1] = var6;
                  } else {
                     class96.field1511[++class96.field1502 - 1] = var6;
                  }
               }

               for(var5 = 0; var5 < class96.field1507; ++var5) {
                  var6 = class96.field1508[var5];
                  var116 = cachedPlayers[var6];
                  var24 = var113.readUnsignedByte();
                  if((var24 & 8) != 0) {
                     var24 += var113.readUnsignedByte() << 8;
                  }

                  var84 = -1;
                  if((var24 & 1) != 0) {
                     var82 = var113.readUnsignedByte();
                     var83 = new byte[var82];
                     var89 = new Buffer(var83);
                     var113.readBytes(var83, 0, var82);
                     class96.field1497[var6] = var89;
                     var116.method1109(var89);
                  }

                  if((var24 & 128) != 0) {
                     var82 = var113.readUnsignedShort();
                     if(var82 == '\uffff') {
                        var82 = -1;
                     }

                     var28 = var113.readUnsignedByte();
                     class37.method499(var116, var82, var28);
                  }

                  if((var24 & 4) != 0) {
                     var116.interacting = var113.readUnsignedShort();
                     if(var116.interacting == '\uffff') {
                        var116.interacting = -1;
                     }
                  }

                  if((var24 & 32) != 0) {
                     var116.overhead = var113.readString();
                     if(var116.overhead.charAt(0) == 126) {
                        var116.overhead = var116.overhead.substring(1);
                        class98.sendGameMessage(2, var116.name, var116.overhead);
                     } else if(var116 == class168.localPlayer) {
                        class98.sendGameMessage(2, var116.name, var116.overhead);
                     }

                     var116.field1240 = false;
                     var116.field1243 = 0;
                     var116.field1244 = 0;
                     var116.field1266 = 150;
                  }

                  if((var24 & 16) != 0) {
                     var82 = var113.readUnsignedByte();
                     if(var82 > 0) {
                        for(var28 = 0; var28 < var82; ++var28) {
                           var13 = -1;
                           var14 = -1;
                           var15 = -1;
                           var29 = var113.method3172();
                           if(var29 == 32767) {
                              var29 = var113.method3172();
                              var14 = var113.method3172();
                              var13 = var113.method3172();
                              var15 = var113.method3172();
                           } else if(var29 != 32766) {
                              var14 = var113.method3172();
                           } else {
                              var29 = -1;
                           }

                           var16 = var113.method3172();
                           var116.method1502(var29, var14, var13, var15, gameCycle, var16);
                        }
                     }

                     var28 = var113.readUnsignedByte();
                     if(var28 > 0) {
                        for(var29 = 0; var29 < var28; ++var29) {
                           var13 = var113.method3172();
                           var14 = var113.method3172();
                           if(var14 != 32767) {
                              var15 = var113.method3172();
                              var16 = var113.readUnsignedByte();
                              var17 = var14 > 0?var113.readUnsignedByte():var16;
                              var116.method1495(var13, gameCycle, var14, var15, var16, var17);
                           } else {
                              var116.method1506(var13);
                           }
                        }
                     }
                  }

                  if((var24 & 2) != 0) {
                     var116.field1254 = var113.readUnsignedShort();
                     if(var116.queueSize == 0) {
                        var116.orientation = var116.field1254;
                        var116.field1254 = -1;
                     }
                  }

                  if((var24 & 64) != 0) {
                     var82 = var113.readUnsignedShort();
                     var85 = (class230)Projectile.method1737(class166.method3083(), var113.readUnsignedByte());
                     var123 = var113.readUnsignedByte() == 1;
                     var13 = var113.readUnsignedByte();
                     var14 = var113.offset;
                     if(var116.name != null && var116.composition != null) {
                        var94 = false;
                        if(var85.field3176 && class169.method3124(var116.name)) {
                           var94 = true;
                        }

                        if(!var94 && field1034 == 0 && !var116.hidden) {
                           class96.field1509.offset = 0;
                           var113.readBytes(class96.field1509.payload, 0, var13);
                           class96.field1509.offset = 0;
                           var30 = class96.field1509;

                           try {
                              var19 = var30.method3172();
                              if(var19 > 32767) {
                                 var19 = 32767;
                              }

                              var20 = new byte[var19];
                              var30.offset += class265.field3670.method3079(var30.payload, var30.offset, var20, 0, var19);
                              var21 = WorldMapType2.method528(var20, 0, var19);
                              var95 = var21;
                           } catch (Exception var64) {
                              var95 = "Cabbage";
                           }

                           var95 = FontTypeFace.method4815(IndexDataBase.method4221(var95));
                           var116.overhead = var95.trim();
                           var116.field1243 = var82 >> 8;
                           var116.field1244 = var82 & 255;
                           var116.field1266 = 150;
                           var116.field1240 = var123;
                           var116.inSequence = class168.localPlayer != var116 && var85.field3176 && field1014 != "" && var95.toLowerCase().indexOf(field1014) == -1;
                           if(var85.field3179) {
                              var19 = var123?91:1;
                           } else {
                              var19 = var123?90:2;
                           }

                           if(var85.field3174 != -1) {
                              class98.sendGameMessage(var19, class64.method1058(var85.field3174) + var116.name, var95);
                           } else {
                              class98.sendGameMessage(var19, var116.name, var95);
                           }
                        }
                     }

                     var113.offset = var14 + var13;
                  }

                  if((var24 & 1024) != 0) {
                     var116.graphic = var113.readUnsignedShort();
                     var82 = var113.readInt();
                     var116.field1279 = var82 >> 16;
                     var116.field1256 = (var82 & '\uffff') + gameCycle;
                     var116.field1264 = 0;
                     var116.field1249 = 0;
                     if(var116.field1256 > gameCycle) {
                        var116.field1264 = -1;
                     }

                     if(var116.graphic == '\uffff') {
                        var116.graphic = -1;
                     }
                  }

                  if((var24 & 256) != 0) {
                     var116.field1268 = var113.readByte();
                     var116.field1286 = var113.readByte();
                     var116.field1269 = var113.readByte();
                     var116.field1271 = var113.readByte();
                     var116.field1272 = var113.readUnsignedShort() + gameCycle;
                     var116.field1273 = var113.readUnsignedShort() + gameCycle;
                     var116.field1274 = var113.readUnsignedShort();
                     if(var116.field893) {
                        var116.field1268 += var116.field894;
                        var116.field1286 += var116.field875;
                        var116.field1269 += var116.field894;
                        var116.field1271 += var116.field875;
                        var116.queueSize = 0;
                     } else {
                        var116.field1268 += var116.pathX[0];
                        var116.field1286 += var116.pathY[0];
                        var116.field1269 += var116.pathX[0];
                        var116.field1271 += var116.pathY[0];
                        var116.queueSize = 1;
                     }

                     var116.field1285 = 0;
                  }

                  if((var24 & 4096) != 0) {
                     class96.field1498[var6] = var113.readByte();
                  }

                  if((var24 & 2048) != 0) {
                     var84 = var113.readByte();
                  }

                  if((var24 & 512) != 0) {
                     for(var82 = 0; var82 < 3; ++var82) {
                        var116.actions[var82] = var113.readString();
                     }
                  }

                  if(var116.field893) {
                     if(var84 == 127) {
                        var116.method1123(var116.field894, var116.field875);
                     } else {
                        if(var84 != -1) {
                           var91 = var84;
                        } else {
                           var91 = class96.field1498[var6];
                        }

                        var116.method1096(var116.field894, var116.field875, var91);
                     }
                  }
               }

               if(var113.offset - var4 != var2) {
                  throw new RuntimeException(var113.offset - var4 + " " + var2);
               }

               field960 = -1;
               return true;
            }

            if(field960 == 162) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               var109 = secretPacketBuffer2.readString();
               var4 = secretPacketBuffer2.readUnsignedByte();
               if(var2 >= 1 && var2 <= 8) {
                  if(var109.equalsIgnoreCase("null")) {
                     var109 = null;
                  }

                  playerOptions[var2 - 1] = var109;
                  playerOptionsPriorities[var2 - 1] = var4 == 0;
               }

               field960 = -1;
               return true;
            }

            if(field960 == 96) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.readInt();
               if(class9.field251 == null || !class9.field251.isValid()) {
                  try {
                     Iterator var114 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var114.hasNext()) {
                        GarbageCollectorMXBean var130 = (GarbageCollectorMXBean)var114.next();
                        if(var130.isValid()) {
                           class9.field251 = var130;
                           field1193 = -1L;
                           field1069 = -1L;
                        }
                     }
                  } catch (Throwable var72) {
                     ;
                  }
               }

               long var47 = class134.method2587();
               var6 = -1;
               if(class9.field251 != null) {
                  var38 = class9.field251.getCollectionTime();
                  if(-1L != field1069) {
                     long var49 = var38 - field1069;
                     long var51 = var47 - field1193;
                     if(var51 != 0L) {
                        var6 = (int)(var49 * 100L / var51);
                     }
                  }

                  field1069 = var38;
                  field1193 = var47;
               }

               secretPacketBuffer1.putOpcode(62);
               secretPacketBuffer1.putInt(var2);
               secretPacketBuffer1.putInt(var3);
               secretPacketBuffer1.method3183(var6);
               secretPacketBuffer1.method3185(GameEngine.FPS);
               field960 = -1;
               return true;
            }

            if(field960 == 172) {
               if(widgetRoot != -1) {
                  var2 = widgetRoot;
                  if(class73.method1095(var2)) {
                     class261.method4764(Widget.widgets[var2], 0);
                  }
               }

               field960 = -1;
               return true;
            }

            PacketBuffer var98;
            if(field960 == 148) {
               var98 = secretPacketBuffer2;
               var3 = packetLength;
               var4 = var98.offset;
               class96.field1507 = 0;
               var5 = 0;
               var98.method3399();

               for(var6 = 0; var6 < class96.field1499; ++var6) {
                  var7 = class96.field1501[var6];
                  if((class96.field1503[var7] & 1) == 0) {
                     if(var5 > 0) {
                        --var5;
                        class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                     } else {
                        var24 = var98.method3400(1);
                        if(var24 == 0) {
                           var5 = class66.method1062(var98);
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        } else {
                           class21.method173(var98, var7);
                        }
                     }
                  }
               }

               var98.method3401();
               if(var5 != 0) {
                  throw new RuntimeException();
               }

               var98.method3399();

               for(var6 = 0; var6 < class96.field1499; ++var6) {
                  var7 = class96.field1501[var6];
                  if((class96.field1503[var7] & 1) != 0) {
                     if(var5 > 0) {
                        --var5;
                        class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                     } else {
                        var24 = var98.method3400(1);
                        if(var24 == 0) {
                           var5 = class66.method1062(var98);
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        } else {
                           class21.method173(var98, var7);
                        }
                     }
                  }
               }

               var98.method3401();
               if(var5 != 0) {
                  throw new RuntimeException();
               }

               var98.method3399();

               for(var6 = 0; var6 < class96.field1502; ++var6) {
                  var7 = class96.field1511[var6];
                  if((class96.field1503[var7] & 1) != 0) {
                     if(var5 > 0) {
                        --var5;
                        class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                     } else {
                        var24 = var98.method3400(1);
                        if(var24 == 0) {
                           var5 = class66.method1062(var98);
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        } else if(class87.method1684(var98, var7)) {
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        }
                     }
                  }
               }

               var98.method3401();
               if(var5 != 0) {
                  throw new RuntimeException();
               }

               var98.method3399();

               for(var6 = 0; var6 < class96.field1502; ++var6) {
                  var7 = class96.field1511[var6];
                  if((class96.field1503[var7] & 1) == 0) {
                     if(var5 > 0) {
                        --var5;
                        class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                     } else {
                        var24 = var98.method3400(1);
                        if(var24 == 0) {
                           var5 = class66.method1062(var98);
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        } else if(class87.method1684(var98, var7)) {
                           class96.field1503[var7] = (byte)(class96.field1503[var7] | 2);
                        }
                     }
                  }
               }

               var98.method3401();
               if(var5 != 0) {
                  throw new RuntimeException();
               }

               class96.field1499 = 0;
               class96.field1502 = 0;

               for(var6 = 1; var6 < 2048; ++var6) {
                  class96.field1503[var6] = (byte)(class96.field1503[var6] >> 1);
                  var116 = cachedPlayers[var6];
                  if(var116 != null) {
                     class96.field1501[++class96.field1499 - 1] = var6;
                  } else {
                     class96.field1511[++class96.field1502 - 1] = var6;
                  }
               }

               for(var5 = 0; var5 < class96.field1507; ++var5) {
                  var6 = class96.field1508[var5];
                  var116 = cachedPlayers[var6];
                  var24 = var98.readUnsignedByte();
                  if((var24 & 8) != 0) {
                     var24 += var98.readUnsignedByte() << 8;
                  }

                  var84 = -1;
                  if((var24 & 1) != 0) {
                     var82 = var98.readUnsignedByte();
                     var83 = new byte[var82];
                     var89 = new Buffer(var83);
                     var98.readBytes(var83, 0, var82);
                     class96.field1497[var6] = var89;
                     var116.method1109(var89);
                  }

                  if((var24 & 128) != 0) {
                     var82 = var98.readUnsignedShort();
                     if(var82 == '\uffff') {
                        var82 = -1;
                     }

                     var28 = var98.readUnsignedByte();
                     class37.method499(var116, var82, var28);
                  }

                  if((var24 & 4) != 0) {
                     var116.interacting = var98.readUnsignedShort();
                     if(var116.interacting == '\uffff') {
                        var116.interacting = -1;
                     }
                  }

                  if((var24 & 32) != 0) {
                     var116.overhead = var98.readString();
                     if(var116.overhead.charAt(0) == 126) {
                        var116.overhead = var116.overhead.substring(1);
                        class98.sendGameMessage(2, var116.name, var116.overhead);
                     } else if(class168.localPlayer == var116) {
                        class98.sendGameMessage(2, var116.name, var116.overhead);
                     }

                     var116.field1240 = false;
                     var116.field1243 = 0;
                     var116.field1244 = 0;
                     var116.field1266 = 150;
                  }

                  if((var24 & 16) != 0) {
                     var82 = var98.readUnsignedByte();
                     if(var82 > 0) {
                        for(var28 = 0; var28 < var82; ++var28) {
                           var13 = -1;
                           var14 = -1;
                           var15 = -1;
                           var29 = var98.method3172();
                           if(var29 == 32767) {
                              var29 = var98.method3172();
                              var14 = var98.method3172();
                              var13 = var98.method3172();
                              var15 = var98.method3172();
                           } else if(var29 != 32766) {
                              var14 = var98.method3172();
                           } else {
                              var29 = -1;
                           }

                           var16 = var98.method3172();
                           var116.method1502(var29, var14, var13, var15, gameCycle, var16);
                        }
                     }

                     var28 = var98.readUnsignedByte();
                     if(var28 > 0) {
                        for(var29 = 0; var29 < var28; ++var29) {
                           var13 = var98.method3172();
                           var14 = var98.method3172();
                           if(var14 != 32767) {
                              var15 = var98.method3172();
                              var16 = var98.readUnsignedByte();
                              var17 = var14 > 0?var98.readUnsignedByte():var16;
                              var116.method1495(var13, gameCycle, var14, var15, var16, var17);
                           } else {
                              var116.method1506(var13);
                           }
                        }
                     }
                  }

                  if((var24 & 2) != 0) {
                     var116.field1254 = var98.readUnsignedShort();
                     if(var116.queueSize == 0) {
                        var116.orientation = var116.field1254;
                        var116.field1254 = -1;
                     }
                  }

                  if((var24 & 64) != 0) {
                     var82 = var98.readUnsignedShort();
                     var85 = (class230)Projectile.method1737(class166.method3083(), var98.readUnsignedByte());
                     var123 = var98.readUnsignedByte() == 1;
                     var13 = var98.readUnsignedByte();
                     var14 = var98.offset;
                     if(var116.name != null && var116.composition != null) {
                        var94 = false;
                        if(var85.field3176 && class169.method3124(var116.name)) {
                           var94 = true;
                        }

                        if(!var94 && field1034 == 0 && !var116.hidden) {
                           class96.field1509.offset = 0;
                           var98.readBytes(class96.field1509.payload, 0, var13);
                           class96.field1509.offset = 0;
                           var30 = class96.field1509;

                           try {
                              var19 = var30.method3172();
                              if(var19 > 32767) {
                                 var19 = 32767;
                              }

                              var20 = new byte[var19];
                              var30.offset += class265.field3670.method3079(var30.payload, var30.offset, var20, 0, var19);
                              var21 = WorldMapType2.method528(var20, 0, var19);
                              var95 = var21;
                           } catch (Exception var63) {
                              var95 = "Cabbage";
                           }

                           var95 = FontTypeFace.method4815(IndexDataBase.method4221(var95));
                           var116.overhead = var95.trim();
                           var116.field1243 = var82 >> 8;
                           var116.field1244 = var82 & 255;
                           var116.field1266 = 150;
                           var116.field1240 = var123;
                           var116.inSequence = var116 != class168.localPlayer && var85.field3176 && "" != field1014 && var95.toLowerCase().indexOf(field1014) == -1;
                           if(var85.field3179) {
                              var19 = var123?91:1;
                           } else {
                              var19 = var123?90:2;
                           }

                           if(var85.field3174 != -1) {
                              class98.sendGameMessage(var19, class64.method1058(var85.field3174) + var116.name, var95);
                           } else {
                              class98.sendGameMessage(var19, var116.name, var95);
                           }
                        }
                     }

                     var98.offset = var13 + var14;
                  }

                  if((var24 & 1024) != 0) {
                     var116.graphic = var98.readUnsignedShort();
                     var82 = var98.readInt();
                     var116.field1279 = var82 >> 16;
                     var116.field1256 = gameCycle + (var82 & '\uffff');
                     var116.field1264 = 0;
                     var116.field1249 = 0;
                     if(var116.field1256 > gameCycle) {
                        var116.field1264 = -1;
                     }

                     if(var116.graphic == '\uffff') {
                        var116.graphic = -1;
                     }
                  }

                  if((var24 & 256) != 0) {
                     var116.field1268 = var98.readByte();
                     var116.field1286 = var98.readByte();
                     var116.field1269 = var98.readByte();
                     var116.field1271 = var98.readByte();
                     var116.field1272 = var98.readUnsignedShort() + gameCycle;
                     var116.field1273 = var98.readUnsignedShort() + gameCycle;
                     var116.field1274 = var98.readUnsignedShort();
                     if(var116.field893) {
                        var116.field1268 += var116.field894;
                        var116.field1286 += var116.field875;
                        var116.field1269 += var116.field894;
                        var116.field1271 += var116.field875;
                        var116.queueSize = 0;
                     } else {
                        var116.field1268 += var116.pathX[0];
                        var116.field1286 += var116.pathY[0];
                        var116.field1269 += var116.pathX[0];
                        var116.field1271 += var116.pathY[0];
                        var116.queueSize = 1;
                     }

                     var116.field1285 = 0;
                  }

                  if((var24 & 4096) != 0) {
                     class96.field1498[var6] = var98.readByte();
                  }

                  if((var24 & 2048) != 0) {
                     var84 = var98.readByte();
                  }

                  if((var24 & 512) != 0) {
                     for(var82 = 0; var82 < 3; ++var82) {
                        var116.actions[var82] = var98.readString();
                     }
                  }

                  if(var116.field893) {
                     if(var84 == 127) {
                        var116.method1123(var116.field894, var116.field875);
                     } else {
                        if(var84 != -1) {
                           var91 = var84;
                        } else {
                           var91 = class96.field1498[var6];
                        }

                        var116.method1096(var116.field894, var116.field875, var91);
                     }
                  }
               }

               if(var98.offset - var4 != var3) {
                  throw new RuntimeException(var98.offset - var4 + " " + var3);
               }

               field960 = -1;
               return true;
            }

            if(field960 == 10) {
               var2 = secretPacketBuffer2.method3172();
               var79 = secretPacketBuffer2.readUnsignedByte() == 1;
               var110 = "";
               var77 = false;
               if(var79) {
                  var110 = secretPacketBuffer2.readString();
                  if(class169.method3124(var110)) {
                     var77 = true;
                  }
               }

               String var99 = secretPacketBuffer2.readString();
               if(!var77) {
                  class98.sendGameMessage(var2, var110, var99);
               }

               field960 = -1;
               return true;
            }

            if(field960 == 153) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.method3196();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               var4 = secretPacketBuffer2.method3173();
               var129 = class177.method3390(var4);
               ItemComposition var97;
               if(!var129.hasScript) {
                  if(var3 == -1) {
                     var129.modelType = 0;
                     field960 = -1;
                     return true;
                  }

                  var97 = ItemComposition.getItemDefinition(var3);
                  var129.modelType = 4;
                  var129.modelId = var3;
                  var129.rotationX = var97.xan2d;
                  var129.rotationZ = var97.yan2d;
                  var129.field2706 = var97.zoom2d * 100 / var2;
                  CombatInfo1.method1515(var129);
               } else {
                  var129.itemId = var3;
                  var129.itemQuantity = var2;
                  var97 = ItemComposition.getItemDefinition(var3);
                  var129.rotationX = var97.xan2d;
                  var129.rotationZ = var97.yan2d;
                  var129.rotationY = var97.zan2d;
                  var129.field2680 = var97.offsetX2d;
                  var129.field2702 = var97.offsetY2d;
                  var129.field2706 = var97.zoom2d;
                  if(var97.isStackable == 1) {
                     var129.field2710 = 1;
                  } else {
                     var129.field2710 = 2;
                  }

                  if(var129.field2689 > 0) {
                     var129.field2706 = var129.field2706 * 32 / var129.field2689;
                  } else if(var129.originalWidth > 0) {
                     var129.field2706 = var129.field2706 * 32 / var129.originalWidth;
                  }

                  CombatInfo1.method1515(var129);
               }

               field960 = -1;
               return true;
            }

            if(field960 == 254) {
               field987 = true;
               GameEngine.field708 = secretPacketBuffer2.readUnsignedByte();
               SceneTilePaint.field2052 = secretPacketBuffer2.readUnsignedByte();
               class2.field19 = secretPacketBuffer2.readUnsignedShort();
               class73.field868 = secretPacketBuffer2.readUnsignedByte();
               XGrandExchangeOffer.field313 = secretPacketBuffer2.readUnsignedByte();
               if(XGrandExchangeOffer.field313 >= 100) {
                  var2 = GameEngine.field708 * 128 + 64;
                  var3 = SceneTilePaint.field2052 * 128 + 64;
                  var4 = class181.method3424(var2, var3, class92.plane) - class2.field19;
                  var5 = var2 - class2.cameraX;
                  var6 = var4 - class203.cameraZ;
                  var7 = var3 - XItemContainer.cameraY;
                  var24 = (int)Math.sqrt((double)(var7 * var7 + var5 * var5));
                  cameraPitch = (int)(Math.atan2((double)var6, (double)var24) * 325.949D) & 2047;
                  GraphicsObject.cameraYaw = (int)(Math.atan2((double)var5, (double)var7) * -325.949D) & 2047;
                  if(cameraPitch < 128) {
                     cameraPitch = 128;
                  }

                  if(cameraPitch > 383) {
                     cameraPitch = 383;
                  }
               }

               field960 = -1;
               return true;
            }

            if(field960 == 109) {
               class40.method543();
               weight = secretPacketBuffer2.readShort();
               field1113 = field1110;
               field960 = -1;
               return true;
            }

            if(field960 == 204) {
               var2 = secretPacketBuffer2.method3194();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               if(var2 == -1 && !field1154) {
                  class203.field2517.method3728();
                  class203.field2515 = 1;
                  class203.field2516 = null;
               } else if(var2 != -1 && var2 != field1153 && field1030 != 0 && !field1154) {
                  class54.method775(2, class54.indexTrack1, var2, 0, field1030, false);
               }

               field1153 = var2;
               field960 = -1;
               return true;
            }

            if(field960 == 249) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var3 = secretPacketBuffer2.method3251();
               class11.method73(var2, var3);
               field960 = -1;
               return true;
            }

            if(field960 == 14) {
               field930 = secretPacketBuffer2.readUnsignedByte();
               if(field930 == 1) {
                  field931 = secretPacketBuffer2.readUnsignedShort();
               }

               if(field930 >= 2 && field930 <= 6) {
                  if(field930 == 2) {
                     field936 = 64;
                     field937 = 64;
                  }

                  if(field930 == 3) {
                     field936 = 0;
                     field937 = 64;
                  }

                  if(field930 == 4) {
                     field936 = 128;
                     field937 = 64;
                  }

                  if(field930 == 5) {
                     field936 = 64;
                     field937 = 0;
                  }

                  if(field930 == 6) {
                     field936 = 64;
                     field937 = 128;
                  }

                  field930 = 2;
                  hintArrowX = secretPacketBuffer2.readUnsignedShort();
                  hintArrowY = secretPacketBuffer2.readUnsignedShort();
                  hintArrowType = secretPacketBuffer2.readUnsignedByte();
               }

               if(field930 == 10) {
                  field1166 = secretPacketBuffer2.readUnsignedShort();
               }

               field960 = -1;
               return true;
            }

            if(field960 == 54) {
               class40.method543();
               var2 = secretPacketBuffer2.readUnsignedByte();
               var3 = secretPacketBuffer2.method3188();
               var4 = secretPacketBuffer2.method3206();
               skillExperiences[var3] = var4;
               boostedSkillLevels[var3] = var2;
               realSkillLevels[var3] = 1;

               for(var5 = 0; var5 < 98; ++var5) {
                  if(var4 >= class222.field2839[var5]) {
                     realSkillLevels[var3] = var5 + 2;
                  }
               }

               field1106[++field1120 - 1 & 31] = var3;
               field960 = -1;
               return true;
            }

            int var9;
            String var78;
            if(field960 == 227) {
               var98 = secretPacketBuffer2;
               var3 = packetLength;
               ClassInfo var107 = new ClassInfo();
               var107.field3740 = var98.readUnsignedByte();
               var107.field3741 = var98.readInt();
               var107.field3742 = new int[var107.field3740];
               var107.field3743 = new int[var107.field3740];
               var107.fields = new Field[var107.field3740];
               var107.field3745 = new int[var107.field3740];
               var107.methods = new Method[var107.field3740];
               var107.args = new byte[var107.field3740][][];

               for(var5 = 0; var5 < var107.field3740; ++var5) {
                  try {
                     var6 = var98.readUnsignedByte();
                     String var115;
                     if(var6 != 0 && var6 != 1 && var6 != 2) {
                        if(var6 == 3 || var6 == 4) {
                           var115 = var98.readString();
                           var78 = var98.readString();
                           var9 = var98.readUnsignedByte();
                           String[] var46 = new String[var9];

                           for(var28 = 0; var28 < var9; ++var28) {
                              var46[var28] = var98.readString();
                           }

                           String var11 = var98.readString();
                           byte[][] var87 = new byte[var9][];
                           if(var6 == 3) {
                              for(var13 = 0; var13 < var9; ++var13) {
                                 var14 = var98.readInt();
                                 var87[var13] = new byte[var14];
                                 var98.readBytes(var87[var13], 0, var14);
                              }
                           }

                           var107.field3742[var5] = var6;
                           Class[] var136 = new Class[var9];

                           for(var14 = 0; var14 < var9; ++var14) {
                              var136[var14] = class34.method491(var46[var14]);
                           }

                           Class var43 = class34.method491(var11);
                           if(class34.method491(var115).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var133 = class34.method491(var115).getDeclaredMethods();
                           Method[] var126 = var133;

                           for(var17 = 0; var17 < var126.length; ++var17) {
                              Method var18 = var126[var17];
                              if(Reflection.getMethodName(var18).equals(var78)) {
                                 Class[] var31 = Reflection.getParameterTypes(var18);
                                 if(var136.length == var31.length) {
                                    boolean var53 = true;

                                    for(int var54 = 0; var54 < var136.length; ++var54) {
                                       if(var31[var54] != var136[var54]) {
                                          var53 = false;
                                          break;
                                       }
                                    }

                                    if(var53 && var43 == var18.getReturnType()) {
                                       var107.methods[var5] = var18;
                                    }
                                 }
                              }
                           }

                           var107.args[var5] = var87;
                        }
                     } else {
                        var115 = var98.readString();
                        var78 = var98.readString();
                        var9 = 0;
                        if(var6 == 1) {
                           var9 = var98.readInt();
                        }

                        var107.field3742[var5] = var6;
                        var107.field3745[var5] = var9;
                        if(class34.method491(var115).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var107.fields[var5] = Reflection.findField(class34.method491(var115), var78);
                     }
                  } catch (ClassNotFoundException var67) {
                     var107.field3743[var5] = -1;
                  } catch (SecurityException var68) {
                     var107.field3743[var5] = -2;
                  } catch (NullPointerException var69) {
                     var107.field3743[var5] = -3;
                  } catch (Exception var70) {
                     var107.field3743[var5] = -4;
                  } catch (Throwable var71) {
                     var107.field3743[var5] = -5;
                  }
               }

               class280.field3749.method3574(var107);
               field960 = -1;
               return true;
            }

            if(field960 == 126) {
               class166.field2338 = secretPacketBuffer2.method3187();
               class66.field804 = secretPacketBuffer2.method3188();

               while(secretPacketBuffer2.offset < packetLength) {
                  field960 = secretPacketBuffer2.readUnsignedByte();
                  class34.method489();
               }

               field960 = -1;
               return true;
            }

            if(field960 == 161) {
               field1183 = 1;
               field1109 = field1110;
               field960 = -1;
               return true;
            }

            if(field960 == 91) {
               var2 = secretPacketBuffer2.method3206();
               var108 = class177.method3390(var2);
               var108.modelType = 3;
               var108.modelId = class168.localPlayer.composition.method3980();
               CombatInfo1.method1515(var108);
               field960 = -1;
               return true;
            }

            if(field960 == 191) {
               var75 = secretPacketBuffer2.method3188() == 1;
               var3 = secretPacketBuffer2.readInt();
               var105 = class177.method3390(var3);
               if(var105.isHidden != var75) {
                  var105.isHidden = var75;
                  CombatInfo1.method1515(var105);
               }

               field960 = -1;
               return true;
            }

            if(field960 == 56) {
               class96.field1499 = 0;

               for(var2 = 0; var2 < 2048; ++var2) {
                  class96.field1497[var2] = null;
                  class96.field1498[var2] = 1;
               }

               for(var2 = 0; var2 < 2048; ++var2) {
                  cachedPlayers[var2] = null;
               }

               class1.method2(secretPacketBuffer2);
               field960 = -1;
               return true;
            }

            if(field960 == 141) {
               var75 = secretPacketBuffer2.readUnsignedByte() == 1;
               if(var75) {
                  TextureProvider.field1779 = class134.method2587() - secretPacketBuffer2.readLong();
                  class69.field834 = new class13(secretPacketBuffer2, true);
               } else {
                  class69.field834 = null;
               }

               field1112 = field1110;
               field960 = -1;
               return true;
            }

            if(field960 == 106) {
               var2 = secretPacketBuffer2.method3194();
               XItemContainer var106 = (XItemContainer)XItemContainer.itemContainers.method3545((long)var2);
               if(var106 != null) {
                  var106.unlink();
               }

               interfaceItemTriggers[++field924 - 1 & 31] = var2 & 32767;
               field960 = -1;
               return true;
            }

            if(field960 == 36) {
               class166.field2338 = secretPacketBuffer2.readUnsignedByte();
               class66.field804 = secretPacketBuffer2.readUnsignedByte();
               field960 = -1;
               return true;
            }

            if(field960 == 48) {
               field1016 = secretPacketBuffer2.readUnsignedByte();
               field960 = -1;
               return true;
            }

            if(field960 == 116) {
               detinationX = secretPacketBuffer2.readUnsignedByte();
               if(detinationX == 255) {
                  detinationX = 0;
               }

               destinationY = secretPacketBuffer2.readUnsignedByte();
               if(destinationY == 255) {
                  destinationY = 0;
               }

               field960 = -1;
               return true;
            }

            if(field960 == 202) {
               class166.field2338 = secretPacketBuffer2.method3186();
               class66.field804 = secretPacketBuffer2.method3187();

               for(var2 = class66.field804; var2 < class66.field804 + 8; ++var2) {
                  for(var3 = class166.field2338; var3 < class166.field2338 + 8; ++var3) {
                     if(groundItemDeque[class92.plane][var2][var3] != null) {
                        groundItemDeque[class92.plane][var2][var3] = null;
                        class261.groundItemSpawned(var2, var3);
                     }
                  }
               }

               for(PendingSpawn var100 = (PendingSpawn)pendingSpawns.method3622(); var100 != null; var100 = (PendingSpawn)pendingSpawns.method3608()) {
                  if(var100.x >= class66.field804 && var100.x < class66.field804 + 8 && var100.y >= class166.field2338 && var100.y < class166.field2338 + 8 && var100.level == class92.plane) {
                     var100.hitpoints = 0;
                  }
               }

               field960 = -1;
               return true;
            }

            if(field960 == 55) {
               var2 = secretPacketBuffer2.method3173();
               var3 = secretPacketBuffer2.method3195();
               var105 = class177.method3390(var2);
               if(var105.modelType != 1 || var3 != var105.modelId) {
                  var105.modelType = 1;
                  var105.modelId = var3;
                  CombatInfo1.method1515(var105);
               }

               field960 = -1;
               return true;
            }

            if(field960 == 46) {
               var2 = secretPacketBuffer2.method3204();
               var3 = secretPacketBuffer2.method3195();
               var105 = class177.method3390(var2);
               if(var105.modelType != 2 || var3 != var105.modelId) {
                  var105.modelType = 2;
                  var105.modelId = var3;
                  CombatInfo1.method1515(var105);
               }

               field960 = -1;
               return true;
            }

            if(field960 == 181) {
               secretPacketBuffer2.offset += 28;
               if(secretPacketBuffer2.method3216()) {
                  var98 = secretPacketBuffer2;
                  var3 = secretPacketBuffer2.offset - 28;
                  byte[] var103 = var98.payload;
                  if(field1108 == null) {
                     field1108 = new byte[24];
                  }

                  class183.method3433(var103, var3, field1108, 0, 24);
                  if(class155.field2257 != null) {
                     try {
                        class155.field2257.method2337(0L);
                        class155.field2257.method2341(var98.payload, var3, 24);
                     } catch (Exception var62) {
                        ;
                     }
                  }
               }

               field960 = -1;
               return true;
            }

            if(field960 == 59) {
               var2 = secretPacketBuffer2.readInt();
               WidgetNode var26 = (WidgetNode)componentTable.method3545((long)var2);
               if(var26 != null) {
                  WorldMapType3.method231(var26, true);
               }

               if(field1147 != null) {
                  CombatInfo1.method1515(field1147);
                  field1147 = null;
               }

               field960 = -1;
               return true;
            }

            if(field960 == 15) {
               var22 = secretPacketBuffer2.readString();
               var34 = (long)secretPacketBuffer2.readUnsignedShort();
               var36 = (long)secretPacketBuffer2.read24BitInt();
               class230 var112 = (class230)Projectile.method1737(class166.method3083(), secretPacketBuffer2.readUnsignedByte());
               long var55 = var36 + (var34 << 32);
               boolean var10 = false;

               for(var28 = 0; var28 < 100; ++var28) {
                  if(var55 == field1135[var28]) {
                     var10 = true;
                     break;
                  }
               }

               if(class169.method3124(var22)) {
                  var10 = true;
               }

               if(!var10 && field1034 == 0) {
                  field1135[field1174] = var55;
                  field1174 = (field1174 + 1) % 100;
                  PacketBuffer var12 = secretPacketBuffer2;

                  String var45;
                  try {
                     var14 = var12.method3172();
                     if(var14 > 32767) {
                        var14 = 32767;
                     }

                     byte[] var44 = new byte[var14];
                     var12.offset += class265.field3670.method3079(var12.payload, var12.offset, var44, 0, var14);
                     String var32 = WorldMapType2.method528(var44, 0, var14);
                     var45 = var32;
                  } catch (Exception var61) {
                     var45 = "Cabbage";
                  }

                  var45 = FontTypeFace.method4815(IndexDataBase.method4221(var45));
                  byte var92;
                  if(var112.field3179) {
                     var92 = 7;
                  } else {
                     var92 = 3;
                  }

                  if(var112.field3174 != -1) {
                     class98.sendGameMessage(var92, class64.method1058(var112.field3174) + var22, var45);
                  } else {
                     class98.sendGameMessage(var92, var22, var45);
                  }
               }

               field960 = -1;
               return true;
            }

            if(field960 == 66) {
               var2 = secretPacketBuffer2.method3204();
               var3 = secretPacketBuffer2.method3196();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               var4 = secretPacketBuffer2.method3196();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               var5 = secretPacketBuffer2.method3173();

               for(var6 = var3; var6 <= var4; ++var6) {
                  var38 = ((long)var2 << 32) + (long)var6;
                  Node var40 = widgetFlags.method3545(var38);
                  if(var40 != null) {
                     var40.unlink();
                  }

                  widgetFlags.method3546(new class198(var5), var38);
               }

               field960 = -1;
               return true;
            }

            if(field960 == 224) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.method3194();
               var4 = secretPacketBuffer2.method3173();
               var5 = secretPacketBuffer2.method3194();
               var23 = class177.method3390(var4);
               if(var23.rotationX != var2 || var5 != var23.rotationZ || var3 != var23.field2706) {
                  var23.rotationX = var2;
                  var23.rotationZ = var5;
                  var23.field2706 = var3;
                  CombatInfo1.method1515(var23);
               }

               field960 = -1;
               return true;
            }

            if(field960 == 24) {
               var22 = secretPacketBuffer2.readString();
               PacketBuffer var25 = secretPacketBuffer2;

               try {
                  var6 = var25.method3172();
                  if(var6 > 32767) {
                     var6 = 32767;
                  }

                  byte[] var111 = new byte[var6];
                  var25.offset += class265.field3670.method3079(var25.payload, var25.offset, var111, 0, var6);
                  var78 = WorldMapType2.method528(var111, 0, var6);
                  var128 = var78;
               } catch (Exception var60) {
                  var128 = "Cabbage";
               }

               var128 = FontTypeFace.method4815(IndexDataBase.method4221(var128));
               class98.sendGameMessage(6, var22, var128);
               field960 = -1;
               return true;
            }

            if(field960 == 154) {
               var2 = packetLength + secretPacketBuffer2.offset;
               var3 = secretPacketBuffer2.readUnsignedShort();
               var4 = secretPacketBuffer2.readUnsignedShort();
               if(var3 != widgetRoot) {
                  widgetRoot = var3;
                  this.method1146(false);
                  class22.method183(widgetRoot);
                  class270.method4919(widgetRoot);

                  for(var5 = 0; var5 < 100; ++var5) {
                     field1121[var5] = true;
                  }
               }

               WidgetNode var8;
               for(; var4-- > 0; var8.field815 = true) {
                  var5 = secretPacketBuffer2.readInt();
                  var6 = secretPacketBuffer2.readUnsignedShort();
                  var7 = secretPacketBuffer2.readUnsignedByte();
                  var8 = (WidgetNode)componentTable.method3545((long)var5);
                  if(var8 != null && var6 != var8.id) {
                     WorldMapType3.method231(var8, true);
                     var8 = null;
                  }

                  if(var8 == null) {
                     var8 = class232.method4120(var5, var6, var7);
                  }
               }

               for(var127 = (WidgetNode)componentTable.method3548(); var127 != null; var127 = (WidgetNode)componentTable.method3556()) {
                  if(var127.field815) {
                     var127.field815 = false;
                  } else {
                     WorldMapType3.method231(var127, true);
                  }
               }

               widgetFlags = new XHashTable(512);

               while(secretPacketBuffer2.offset < var2) {
                  var5 = secretPacketBuffer2.readInt();
                  var6 = secretPacketBuffer2.readUnsignedShort();
                  var7 = secretPacketBuffer2.readUnsignedShort();
                  var24 = secretPacketBuffer2.readInt();

                  for(var9 = var6; var9 <= var7; ++var9) {
                     var41 = (long)var9 + ((long)var5 << 32);
                     widgetFlags.method3546(new class198(var24), var41);
                  }
               }

               field960 = -1;
               return true;
            }

            if(field960 == 201) {
               field1013 = field1110;
               if(packetLength == 0) {
                  clanChatOwner = null;
                  clanChatName = null;
                  class24.clanChatCount = 0;
                  class2.clanMembers = null;
                  field960 = -1;
                  return true;
               }

               clanChatName = secretPacketBuffer2.readString();
               long var57 = secretPacketBuffer2.readLong();
               clanChatOwner = class44.method617(var57);
               field1143 = secretPacketBuffer2.readByte();
               var4 = secretPacketBuffer2.readUnsignedByte();
               if(var4 == 255) {
                  field960 = -1;
                  return true;
               }

               class24.clanChatCount = var4;
               XClanMember[] var33 = new XClanMember[100];

               for(var6 = 0; var6 < class24.clanChatCount; ++var6) {
                  var33[var6] = new XClanMember();
                  var33[var6].username = secretPacketBuffer2.readString();
                  var33[var6].field898 = CollisionData.method3023(var33[var6].username, class13.field281);
                  var33[var6].world = secretPacketBuffer2.readUnsignedShort();
                  var33[var6].rank = secretPacketBuffer2.readByte();
                  secretPacketBuffer2.readString();
                  if(var33[var6].username.equals(class168.localPlayer.name)) {
                     class116.clanChatRank = var33[var6].rank;
                  }
               }

               var76 = false;
               var24 = class24.clanChatCount;

               while(var24 > 0) {
                  var76 = true;
                  --var24;

                  for(var9 = 0; var9 < var24; ++var9) {
                     if(var33[var9].field898.compareTo(var33[var9 + 1].field898) > 0) {
                        XClanMember var27 = var33[var9];
                        var33[var9] = var33[var9 + 1];
                        var33[var9 + 1] = var27;
                        var76 = false;
                     }
                  }

                  if(var76) {
                     break;
                  }
               }

               class2.clanMembers = var33;
               field960 = -1;
               return true;
            }

            if(field960 == 86) {
               World var96 = new World();
               var96.address = secretPacketBuffer2.readString();
               var96.id = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.readInt();
               var96.mask = var3;
               class3.setGameState(45);
               class8.rssocket.method2989();
               class8.rssocket = null;
               Ignore.method1080(var96);
               field960 = -1;
               return false;
            }

            Projectile.method1734("" + field960 + "," + field964 + "," + field965 + "," + packetLength, (Throwable)null);
            class20.method166();
         } catch (IOException var73) {
            class210.method3941();
         } catch (Exception var74) {
            var22 = "" + field960 + "," + field964 + "," + field965 + "," + packetLength + "," + (class61.baseX + class168.localPlayer.pathX[0]) + "," + (class23.baseY + class168.localPlayer.pathY[0]) + ",";

            for(var3 = 0; var3 < packetLength && var3 < 50; ++var3) {
               var22 = var22 + secretPacketBuffer2.payload[var3] + ",";
            }

            Projectile.method1734(var22, var74);
            class20.method166();
         }

         return true;
      }
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "88"
   )
   final void method1146(boolean var1) {
      class1.method0(widgetRoot, class174.canvasWidth, class2.canvasHeight, var1);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1018771065"
   )
   protected final void vmethod1169(boolean var1) {
      boolean var2;
      label167: {
         try {
            if(class203.field2515 == 2) {
               if(class210.field2608 == null) {
                  class210.field2608 = Track1.method3934(class203.field2516, class158.field2275, class275.field3730);
                  if(class210.field2608 == null) {
                     var2 = false;
                     break label167;
                  }
               }

               if(class18.field328 == null) {
                  class18.field328 = new class112(class203.field2513, class203.field2512);
               }

               if(class203.field2517.method3776(class210.field2608, class203.field2514, class18.field328, 22050)) {
                  class203.field2517.method3746();
                  class203.field2517.method3773(FileOnDisk.field1774);
                  class203.field2517.method3714(class210.field2608, class271.field3690);
                  class203.field2515 = 0;
                  class210.field2608 = null;
                  class18.field328 = null;
                  class203.field2516 = null;
                  var2 = true;
                  break label167;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class203.field2517.method3728();
            class203.field2515 = 0;
            class210.field2608 = null;
            class18.field328 = null;
            class203.field2516 = null;
         }

         var2 = false;
      }

      if(var2 && field1154 && RSSocket.field2287 != null) {
         RSSocket.field2287.method1996();
      }

      if((gameState == 10 || gameState == 20 || gameState == 30) && field946 != 0L && class134.method2587() > field946) {
         DynamicObject.method1841(class140.method2868());
      }

      int var4;
      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1121[var4] = true;
         }
      }

      if(gameState == 0) {
         this.method857(class92.field1416, class92.field1433, var1);
      } else if(gameState == 5) {
         class3.method9(class241.field3288, class261.field3629, WidgetNode.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class3.method9(class241.field3288, class261.field3629, WidgetNode.font_p12full, var1);
         } else if(gameState == 25) {
            if(field1180 == 1) {
               if(field1080 > field1151) {
                  field1151 = field1080;
               }

               var4 = (field1151 * 50 - field1080 * 50) / field1151;
               class157.method2976("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field1180 == 2) {
               if(field971 > field972) {
                  field972 = field971;
               }

               var4 = (field972 * 50 - field971 * 50) / field972 + 50;
               class157.method2976("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class157.method2976("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1142();
         } else if(gameState == 40) {
            class157.method2976("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class157.method2976("Please wait...", false);
         }
      } else {
         class3.method9(class241.field3288, class261.field3629, WidgetNode.font_p12full, var1);
      }

      if(gameState == 30 && field1128 == 0 && !var1) {
         for(var4 = 0; var4 < field1119; ++var4) {
            if(field1122[var4]) {
               class47.field601.vmethod5053(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field1122[var4] = false;
            }
         }
      } else if(gameState > 0) {
         class47.field601.vmethod5052(0, 0);

         for(var4 = 0; var4 < field1119; ++var4) {
            field1122[var4] = false;
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "72"
   )
   protected final void vmethod1194() {
      if(Tile.chatMessages.method1775()) {
         Tile.chatMessages.method1772();
      }

      if(WorldMapType1.field443 != null) {
         WorldMapType1.field443.field849 = false;
      }

      WorldMapType1.field443 = null;
      if(class8.rssocket != null) {
         class8.rssocket.method2989();
         class8.rssocket = null;
      }

      class17.method145();
      if(class59.mouse != null) {
         class59 var1 = class59.mouse;
         synchronized(class59.mouse) {
            class59.mouse = null;
         }
      }

      XGrandExchangeOffer.field312 = null;
      if(RSSocket.field2287 != null) {
         RSSocket.field2287.method2050();
      }

      if(class154.field2250 != null) {
         class154.field2250.method2050();
      }

      class172.method3142();
      class36.method494();
      class29.method255();
   }

   static {
      field1015 = true;
      world = 1;
      flags = 0;
      field915 = 0;
      isMembers = false;
      field918 = false;
      field919 = 0;
      gameState = 0;
      field921 = true;
      gameCycle = 0;
      field1083 = -1L;
      field1021 = -1;
      field925 = -1;
      field926 = -1;
      field1178 = true;
      field928 = false;
      field1081 = 0;
      field930 = 0;
      field931 = 0;
      field1166 = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowType = 0;
      field936 = 0;
      field937 = 0;
      field998 = class91.field1414;
      field939 = class91.field1414;
      field981 = 0;
      field1051 = 0;
      field942 = 0;
      field945 = 0;
      loginState = 0;
      field947 = 0;
      field1129 = 0;
      field949 = 0;
      field1108 = null;
      cachedNPCs = new NPC['耀'];
      field952 = 0;
      npcIndices = new int['耀'];
      field954 = 0;
      field955 = new int[250];
      secretPacketBuffer1 = new PacketBuffer(5000);
      field957 = new PacketBuffer(5000);
      secretPacketBuffer2 = new PacketBuffer(15000);
      packetLength = 0;
      field960 = 0;
      field961 = 0;
      audioEffectCount = 0;
      field963 = 0;
      field964 = 0;
      field965 = 0;
      field966 = 0;
      field967 = false;
      field914 = new HashMap();
      field1080 = 0;
      field1151 = 1;
      field971 = 0;
      field972 = 1;
      field1180 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field976 = new int[4][13][13];
      field977 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field1171 = 0;
      field1160 = 2;
      field980 = 0;
      field1161 = 2;
      field1125 = 0;
      field983 = 1;
      field984 = 0;
      mapScale = 0;
      mapOffset = 2;
      mapScaleDelta = 0;
      field1056 = 1;
      field989 = 0;
      field990 = 0;
      field991 = 2301979;
      field1176 = 5063219;
      field993 = 3353893;
      field994 = 7759444;
      field995 = false;
      field912 = 0;
      field1107 = 128;
      mapAngle = 0;
      field1000 = 0;
      field1001 = 0;
      field1002 = 0;
      field1003 = 0;
      field1004 = 50;
      field1084 = 0;
      field920 = false;
      field1007 = 0;
      field1008 = 0;
      field1009 = 50;
      field1010 = new int[field1009];
      field1105 = new int[field1009];
      field1012 = new int[field1009];
      field1038 = new int[field1009];
      field982 = new int[field1009];
      field1017 = new int[field1009];
      field1085 = new int[field1009];
      field968 = new String[field1009];
      field1018 = new int[104][104];
      field1019 = 0;
      field1020 = -1;
      field1163 = -1;
      field1022 = 0;
      field970 = 0;
      field1024 = 0;
      cursorState = 0;
      field1026 = 0;
      field1027 = 0;
      field1028 = 0;
      field1029 = 0;
      field996 = 0;
      field1031 = 0;
      field1032 = false;
      field1033 = 0;
      field1034 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field1146 = 0;
      field950 = 0;
      field1039 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field1043 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field1044 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      field1048 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field1052 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field1061 = false;
      field1062 = -1;
      field1179 = false;
      field1064 = -1;
      field1060 = -1;
      field1118 = 0;
      field1094 = 50;
      itemSelectionState = 0;
      selectedItemName = null;
      field1071 = false;
      field1072 = -1;
      field1073 = -1;
      field1074 = null;
      field1075 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field1078 = 0;
      field1079 = 0;
      field1147 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1025 = -1;
      field1040 = false;
      field1086 = false;
      field1087 = false;
      field1088 = null;
      field1089 = null;
      field973 = null;
      field1091 = 0;
      field1092 = 0;
      field1093 = null;
      field927 = false;
      field1095 = -1;
      field1096 = -1;
      field1097 = false;
      field1098 = -1;
      field1099 = -1;
      field1100 = false;
      field1110 = 1;
      field1102 = new int[32];
      field1103 = 0;
      interfaceItemTriggers = new int[32];
      field924 = 0;
      field1106 = new int[32];
      field1120 = 0;
      field932 = 0;
      field1109 = 0;
      field1013 = 0;
      field1111 = 0;
      field1112 = 0;
      field1113 = 0;
      field940 = 0;
      field1115 = new Deque();
      field1116 = new Deque();
      field1117 = new Deque();
      widgetFlags = new XHashTable(512);
      field1119 = 0;
      field1067 = -2;
      field1121 = new boolean[100];
      field1122 = new boolean[100];
      field1123 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field1128 = 0;
      field946 = 0L;
      isResized = true;
      field1063 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field938 = 0;
      field1133 = 0;
      field1014 = "";
      field1135 = new long[100];
      field1174 = 0;
      field1137 = 0;
      field1138 = new int[128];
      field1139 = new int[128];
      field1140 = -1L;
      clanChatOwner = null;
      clanChatName = null;
      field1144 = -1;
      field1145 = 0;
      field1114 = new int[1000];
      field1065 = new int[1000];
      field1148 = new SpritePixels[1000];
      detinationX = 0;
      destinationY = 0;
      field1016 = 0;
      field1030 = 255;
      field1153 = -1;
      field1154 = false;
      field1155 = 127;
      field1005 = 127;
      field1077 = 0;
      field1158 = new int[50];
      field1159 = new int[50];
      field1049 = new int[50];
      field1101 = new int[50];
      audioEffects = new SoundEffect[50];
      field987 = false;
      field1164 = new boolean[5];
      field1165 = new int[5];
      field1190 = new int[5];
      field1167 = new int[5];
      field1168 = new int[5];
      field1169 = 256;
      field1057 = 205;
      field1037 = 256;
      field1172 = 320;
      field1173 = 1;
      field1192 = 32767;
      field1175 = 1;
      field975 = 32767;
      field1177 = 0;
      field1150 = 0;
      viewportHeight = 0;
      viewportWidth = 0;
      scale = 0;
      friendCount = 0;
      field1183 = 0;
      friends = new Friend[400];
      field1185 = new class195();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1188 = new PlayerComposition();
      field1189 = -1;
      field1181 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field1069 = -1L;
      field1193 = -1L;
      field1194 = new class73();
      field1070 = new int[50];
      field1196 = new int[50];
   }

   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "61"
   )
   static void method1311() {
      secretPacketBuffer1.offset = 0;
      secretPacketBuffer2.offset = 0;
      field960 = -1;
      field963 = -1;
      field964 = -1;
      field965 = -1;
      packetLength = 0;
      field961 = 0;
      field1081 = 0;
      class89.method1695();
      field1016 = 0;
      detinationX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         cachedPlayers[var0] = null;
      }

      class168.localPlayer = null;

      for(var0 = 0; var0 < cachedNPCs.length; ++var0) {
         NPC var1 = cachedNPCs[var0];
         if(var1 != null) {
            var1.interacting = -1;
            var1.field1253 = false;
         }
      }

      XItemContainer.itemContainers = new XHashTable(32);
      class3.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         field1121[var0] = true;
      }

      class77.method1488();
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "742846012"
   )
   final void method1337() {
      CombatInfo1.method1515(field1089);
      ++class31.field452;
      if(field1097 && field927) {
         int var1 = class59.field729;
         int var2 = class59.field715;
         var1 -= field1091;
         var2 -= field1092;
         if(var1 < field1095) {
            var1 = field1095;
         }

         if(var1 + field1089.width > field1095 + field973.width) {
            var1 = field973.width + field1095 - field1089.width;
         }

         if(var2 < field1096) {
            var2 = field1096;
         }

         if(field1089.height + var2 > field1096 + field973.height) {
            var2 = field973.height + field1096 - field1089.height;
         }

         int var3 = var1 - field1098;
         int var4 = var2 - field1099;
         int var5 = field1089.field2728;
         if(class31.field452 > field1089.field2729 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1100 = true;
         }

         int var6 = field973.scrollX + (var1 - field1095);
         int var7 = var2 - field1096 + field973.scrollY;
         class69 var8;
         if(field1089.field2785 != null && field1100) {
            var8 = new class69();
            var8.field824 = field1089;
            var8.field822 = var6;
            var8.field826 = var7;
            var8.field833 = field1089.field2785;
            class227.method4101(var8);
         }

         if(class59.field716 == 0) {
            if(field1100) {
               if(field1089.field2742 != null) {
                  var8 = new class69();
                  var8.field824 = field1089;
                  var8.field822 = var6;
                  var8.field826 = var7;
                  var8.field835 = field1093;
                  var8.field833 = field1089.field2742;
                  class227.method4101(var8);
               }

               if(field1093 != null && class168.method3120(field1089) != null) {
                  secretPacketBuffer1.putOpcode(10);
                  secretPacketBuffer1.method3191(field1093.itemId);
                  secretPacketBuffer1.method3192(field1089.index);
                  secretPacketBuffer1.method3203(field1093.id);
                  secretPacketBuffer1.method3342(field1089.id);
                  secretPacketBuffer1.method3192(field1089.itemId);
                  secretPacketBuffer1.putShort(field1093.index);
               }
            } else {
               int var9 = Script.method1824();
               if(menuOptionCount > 2 && (field1052 == 1 && !Widget.method4009() || class28.method244(var9))) {
                  this.method1469(field1091 + field1098, field1092 + field1099);
               } else if(menuOptionCount > 0) {
                  class23.method192(field1091 + field1098, field1092 + field1099);
               }
            }

            field1089 = null;
         }

      } else {
         if(class31.field452 > 1) {
            field1089 = null;
         }

      }
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-60"
   )
   void method1377() {
      int var1 = class174.canvasWidth;
      int var2 = class2.canvasHeight;
      if(super.field689 < var1) {
         var1 = super.field689;
      }

      if(super.field690 < var2) {
         var2 = super.field690;
      }

      if(class66.field801 != null) {
         try {
            class52.method754(class46.field590, "resize", new Object[]{Integer.valueOf(class140.method2868())});
         } catch (Throwable var4) {
            ;
         }
      }

   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1106640500"
   )
   final void method1400() {
      boolean var1 = false;

      int var2;
      int var5;
      while(!var1) {
         var1 = true;

         for(var2 = 0; var2 < menuOptionCount - 1; ++var2) {
            if(menuTypes[var2] < 1000 && menuTypes[var2 + 1] > 1000) {
               String var14 = menuTargets[var2];
               menuTargets[var2] = menuTargets[var2 + 1];
               menuTargets[var2 + 1] = var14;
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
               if(field1062 != -1) {
                  if(var2 == field1062) {
                     field1062 = var2 + 1;
                  } else if(field1062 == var2 + 1) {
                     field1062 = var2;
                  }
               }

               var1 = false;
            }
         }
      }

      if(class98.field1529 == null) {
         if(field1089 == null) {
            int var19 = class59.field713;
            int var3;
            int var8;
            int var9;
            int var15;
            int var16;
            if(isMenuOpen) {
               if(var19 != 1 && (ItemLayer.field1798 || var19 != 4)) {
                  var2 = class59.field729;
                  var3 = class59.field715;
                  if(var2 < class8.menuX - 10 || var2 > class8.menuX + class31.menuWidth + 10 || var3 < class157.menuY - 10 || var3 > class157.menuY + class6.menuHeight + 10) {
                     isMenuOpen = false;
                     class69.method1078(class8.menuX, class157.menuY, class31.menuWidth, class6.menuHeight);
                  }
               }

               if(var19 == 1 || !ItemLayer.field1798 && var19 == 4) {
                  var2 = class8.menuX;
                  var3 = class157.menuY;
                  var16 = class31.menuWidth;
                  var5 = class59.field723;
                  var15 = class59.field724;
                  int var20 = -1;

                  for(var8 = 0; var8 < menuOptionCount; ++var8) {
                     var9 = (menuOptionCount - 1 - var8) * 15 + var3 + 31;
                     if(var5 > var2 && var5 < var2 + var16 && var15 > var9 - 13 && var15 < var9 + 3) {
                        var20 = var8;
                     }
                  }

                  if(var20 != -1 && var20 >= 0) {
                     var8 = menuActionParams0[var20];
                     var9 = menuActionParams1[var20];
                     int var10 = menuTypes[var20];
                     int var11 = menuIdentifiers[var20];
                     String var12 = menuOptions[var20];
                     String var13 = menuTargets[var20];
                     class34.menuAction(var8, var9, var10, var11, var12, var13, class59.field723, class59.field724);
                  }

                  isMenuOpen = false;
                  class69.method1078(class8.menuX, class157.menuY, class31.menuWidth, class6.menuHeight);
               }
            } else {
               var2 = Script.method1824();
               if((var19 == 1 || !ItemLayer.field1798 && var19 == 4) && var2 >= 0) {
                  var3 = menuTypes[var2];
                  if(var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
                     label345: {
                        var16 = menuActionParams0[var2];
                        var5 = menuActionParams1[var2];
                        Widget var6 = class177.method3390(var5);
                        var8 = class251.method4472(var6);
                        boolean var7 = (var8 >> 28 & 1) != 0;
                        if(!var7) {
                           Object var10000 = null;
                           if(!class261.method4765(class251.method4472(var6))) {
                              break label345;
                           }
                        }

                        if(class98.field1529 != null && !field1032) {
                           var9 = Script.method1824();
                           if(field1052 != 1 && !class28.method244(var9) && menuOptionCount > 0) {
                              class23.method192(field1029, field996);
                           }
                        }

                        field1032 = false;
                        field1033 = 0;
                        if(class98.field1529 != null) {
                           CombatInfo1.method1515(class98.field1529);
                        }

                        class98.field1529 = class177.method3390(var5);
                        field1028 = var16;
                        field1029 = class59.field723;
                        field996 = class59.field724;
                        if(var2 >= 0) {
                           class91.field1409 = new class89();
                           class91.field1409.field1402 = menuActionParams0[var2];
                           class91.field1409.field1397 = menuActionParams1[var2];
                           class91.field1409.field1398 = menuTypes[var2];
                           class91.field1409.field1401 = menuIdentifiers[var2];
                           class91.field1409.field1400 = menuOptions[var2];
                        }

                        CombatInfo1.method1515(class98.field1529);
                        return;
                     }
                  }
               }

               if((var19 == 1 || !ItemLayer.field1798 && var19 == 4) && (field1052 == 1 && menuOptionCount > 2 && !Widget.method4009() || class28.method244(var2))) {
                  var19 = 2;
               }

               if((var19 == 1 || !ItemLayer.field1798 && var19 == 4) && menuOptionCount > 0 && var2 >= 0) {
                  var3 = menuActionParams0[var2];
                  var16 = menuActionParams1[var2];
                  var5 = menuTypes[var2];
                  var15 = menuIdentifiers[var2];
                  String var18 = menuOptions[var2];
                  String var17 = menuTargets[var2];
                  class34.menuAction(var3, var16, var5, var15, var18, var17, class59.field723, class59.field724);
               }

               if(var19 == 2 && menuOptionCount > 0) {
                  this.method1469(class59.field723, class59.field724);
               }
            }

         }
      }
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "159034901"
   )
   void method1418(Widget var1) {
      Widget var2 = var1.parentId == -1?null:class177.method3390(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = class174.canvasWidth;
         var4 = class2.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class1.method3(var1, var3, var4, false);
      WidgetNode.method1068(var1, var3, var4);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1294772132"
   )
   protected final void vmethod1467() {
      class36.field506 = field915 == 0?'ꩊ':world + '鱀';
      class177.field2423 = field915 == 0?443:world + '썐';
      class66.field803 = class36.field506;
      PlayerComposition.field2627 = class214.field2634;
      PlayerComposition.field2621 = class214.field2633;
      class211.field2611 = class214.field2636;
      class266.field3671 = class214.field2635;
      this.method871();
      this.method837();
      XGrandExchangeOffer.field312 = this.method833();
      class54.field658 = new IndexFile(255, class155.field2254, class155.field2259, 500000);
      FileOnDisk var2 = null;
      Preferences var3 = new Preferences();

      try {
         var2 = class163.getPreferencesFile("", field916.field3197, false);
         byte[] var4 = new byte[(int)var2.method2370()];

         int var6;
         for(int var5 = 0; var5 < var4.length; var5 += var6) {
            var6 = var2.method2369(var4, var5, var4.length - var5);
            if(var6 == -1) {
               throw new IOException();
            }
         }

         var3 = new Preferences(new Buffer(var4));
      } catch (Exception var8) {
         ;
      }

      try {
         if(var2 != null) {
            var2.method2368();
         }
      } catch (Exception var7) {
         ;
      }

      class66.field801 = var3;
      this.method921();
      class14.method100(this, class87.field1385);
      if(field915 != 0) {
         field928 = true;
      }

      DynamicObject.method1841(class66.field801.field1317);
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2034803317"
   )
   final void method1469(int var1, int var2) {
      int var3 = class241.field3288.method4780("Choose Option");

      int var4;
      int var5;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         var5 = class241.field3288.method4780(class87.method1682(var4));
         if(var5 > var3) {
            var3 = var5;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      var5 = var1 - var3 / 2;
      if(var3 + var5 > class174.canvasWidth) {
         var5 = class174.canvasWidth - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      int var6 = var2;
      if(var4 + var2 > class2.canvasHeight) {
         var6 = class2.canvasHeight - var4;
      }

      if(var6 < 0) {
         var6 = 0;
      }

      class61.region.method2678(class92.plane, var1, var2, false);
      isMenuOpen = true;
      class8.menuX = var5;
      class157.menuY = var6;
      class31.menuWidth = var3;
      class6.menuHeight = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "56"
   )
   static final byte[] method1479(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3229 != 0 && var3 > IndexDataBase.field3229) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 >= 0 && (IndexDataBase.field3229 == 0 || var6 <= IndexDataBase.field3229)) {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class167.method3087(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.field3227.method3080(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }
}
