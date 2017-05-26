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
   @ObfuscatedName("hv")
   static int[][] field890;
   @ObfuscatedName("qi")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 734539795
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1244864217
   )
   static int field893;
   @ObfuscatedName("jk")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("bb")
   static boolean field895;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1195681825
   )
   static int field896;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1852125649
   )
   @Export("gameState")
   static int gameState;
   @ObfuscatedName("bg")
   static boolean field898;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 709865467
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("ql")
   static short field900;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = 222213251
   )
   static int field901;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = 1629352855
   )
   static int field902;
   @ObfuscatedName("lr")
   static Widget field903;
   @ObfuscatedName("bx")
   static boolean field904;
   @ObfuscatedName("be")
   static boolean field905;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1437985703
   )
   static int field906;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -422828609
   )
   static int field907;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 316401777
   )
   static int field908;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -825835181
   )
   static int field909;
   @ObfuscatedName("he")
   static int[] field910;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1182088639
   )
   static int field911;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = -1844323017
   )
   static int field912;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 2036160747
   )
   static int field913;
   @ObfuscatedName("qx")
   static short field914;
   @ObfuscatedName("cg")
   static class91 field915;
   @ObfuscatedName("ca")
   static class91 field916;
   @ObfuscatedName("mj")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("ob")
   static int[] field918;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -42770285
   )
   static int field919;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      longValue = 3764909399054080685L
   )
   static long field920;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = -1887633113
   )
   static int field921;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 698812341
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -181946463
   )
   static int field923;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -854383265
   )
   static int field924;
   @ObfuscatedName("hi")
   static int[] field925;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 501361651
   )
   static int field926;
   @ObfuscatedName("dj")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -164602047
   )
   static int field928;
   @ObfuscatedName("pv")
   static boolean field929;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 1450323353
   )
   static int field930;
   @ObfuscatedName("df")
   static int[] field931;
   @ObfuscatedName("em")
   @Export("secretPacketBuffer1")
   static PacketBuffer secretPacketBuffer1;
   @ObfuscatedName("ew")
   static PacketBuffer field933;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 1831966569
   )
   @Export("packetLength")
   static int packetLength;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -1969014235
   )
   static int field936;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -1958577
   )
   static int field937;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = 64636021
   )
   static int field938;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 19274341
   )
   static int field939;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1959732443
   )
   static int field940;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = -1691607071
   )
   static int field941;
   @ObfuscatedName("qg")
   static short field942;
   @ObfuscatedName("ez")
   static boolean field943;
   @ObfuscatedName("ey")
   static HashMap field944;
   @ObfuscatedName("re")
   @ObfuscatedGetter(
      longValue = 306957670287706627L
   )
   static long field945;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 1969712939
   )
   static int field946;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -1983117709
   )
   static int field947;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      longValue = 2978533168838315727L
   )
   static long field948;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 203795019
   )
   static int field949;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("fu")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("hl")
   static int[] field952;
   @ObfuscatedName("fq")
   static final int[] field953;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1531038021
   )
   static int field954;
   @ObfuscatedName("ml")
   static int[] field955;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = -852964815
   )
   static int field956;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = -2115356311
   )
   static int field957;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -1144513975
   )
   static int field958;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = -1071724555
   )
   static int field959;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = 1503685727
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("lv")
   static Widget field961;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = -633012243
   )
   @Export("mapOffset")
   static int mapOffset;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -477984119
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 725445287
   )
   static int field964;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 468400609
   )
   static int field965;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 598209925
   )
   static int field966;
   @ObfuscatedName("dw")
   static byte[] field967;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -983201831
   )
   static int field968;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -1397629531
   )
   static int field969;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = 53338085
   )
   static int field970;
   @ObfuscatedName("go")
   static boolean field971;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -291388245
   )
   static int field972;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 1346967619
   )
   static int field973;
   @ObfuscatedName("mv")
   static Deque field974;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -1976291901
   )
   static int field975;
   @ObfuscatedName("js")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = 2065117441
   )
   static int field977;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -771932917
   )
   static int field978;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 1591199391
   )
   static int field979;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = -1695713893
   )
   static int field980;
   @ObfuscatedName("ht")
   static boolean field981;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = 1494681515
   )
   static int field982;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = 1506974401
   )
   static int field983;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = 648215725
   )
   static int field984;
   @ObfuscatedName("hk")
   static int[] field985;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = -1793752087
   )
   static int field986;
   @ObfuscatedName("hm")
   static int[] field987;
   @ObfuscatedName("hg")
   static int[] field988;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = 648043667
   )
   static int field989;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = -641204291
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("ne")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("hh")
   static String[] field992;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = 973003051
   )
   static int field993;
   @ObfuscatedName("lt")
   static boolean field994;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = 1036836291
   )
   static int field995;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -573899647
   )
   static int field996;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = 699465139
   )
   static int field997;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 1623856197
   )
   static int field998;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = -826049055
   )
   static int field999;
   @ObfuscatedName("ea")
   @Export("secretPacketBuffer2")
   static PacketBuffer secretPacketBuffer2;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = -1992294857
   )
   static int field1001;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = -1557141385
   )
   static int field1002;
   @ObfuscatedName("aa")
   static boolean field1003;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = 1246055307
   )
   static int field1004;
   @ObfuscatedName("kg")
   static boolean field1005;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -2100345395
   )
   static int field1006;
   @ObfuscatedName("iq")
   static boolean field1007;
   @ObfuscatedName("ln")
   static boolean field1008;
   @ObfuscatedName("pz")
   static int[] field1009;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = -2004264753
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -1621399727
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = -334881273
   )
   static int field1012;
   @ObfuscatedName("dd")
   static int[] field1013;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 601588251
   )
   static int field1014;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -652178699
   )
   static int field1015;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = 1615155271
   )
   static int field1016;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = 1621348101
   )
   static int field1017;
   @ObfuscatedName("jr")
   static int[] field1018;
   @ObfuscatedName("kl")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("jf")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("ji")
   static Deque field1021;
   @ObfuscatedName("jj")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("jm")
   static Deque field1023;
   @ObfuscatedName("jn")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("jl")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -534172319
   )
   static int field1026;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = 1510800035
   )
   static int field1027;
   @ObfuscatedName("jo")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = 618688305
   )
   static int field1029;
   @ObfuscatedName("jq")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("ie")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("jx")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("jp")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -1087148937
   )
   static int field1034;
   @ObfuscatedName("kn")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("kr")
   static boolean field1036;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = 56746445
   )
   static int field1037;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -966985851
   )
   static int field1038;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = -1555732897
   )
   static int field1039;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = 1265360729
   )
   static int field1040;
   @ObfuscatedName("jh")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = -1392548401
   )
   static int field1042;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -681632591
   )
   static int field1043;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -2087594151
   )
   static int field1044;
   @ObfuscatedName("kv")
   static boolean field1045;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = -151449905
   )
   static int field1046;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = 1420642189
   )
   static int field1047;
   @ObfuscatedName("kx")
   static String field1048;
   @ObfuscatedName("kt")
   static String field1049;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -327392715
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("mk")
   static int[] field1051;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = -340207221
   )
   static int field1052;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = 953900553
   )
   static int field1053;
   @ObfuscatedName("ko")
   static Widget field1054;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 176162535
   )
   static int field1055;
   @ObfuscatedName("hc")
   static int[] field1056;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -1887020521
   )
   static int field1057;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 1693538113
   )
   static int field1058;
   @ObfuscatedName("lg")
   static boolean field1059;
   @ObfuscatedName("li")
   static boolean field1060;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = 736014167
   )
   static int field1061;
   @ObfuscatedName("jb")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = 554853127
   )
   static int field1063;
   @ObfuscatedName("od")
   static int[] field1064;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = -1369775159
   )
   static int field1065;
   @ObfuscatedName("nb")
   static int[] field1066;
   @ObfuscatedName("lo")
   static Widget field1067;
   @ObfuscatedName("lk")
   static boolean field1068;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -753906509
   )
   static int field1069;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 1619396171
   )
   static int field1070;
   @ObfuscatedName("le")
   static boolean field1071;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 455701011
   )
   static int field1072;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = 1768717863
   )
   static int field1073;
   @ObfuscatedName("jz")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = -1201086251
   )
   static int field1075;
   @ObfuscatedName("fy")
   static int[][][] field1076;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = -1534352879
   )
   static int field1077;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1646496385
   )
   @Export("world")
   static int world;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = -659738463
   )
   static int field1079;
   @ObfuscatedName("mt")
   static int[] field1080;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = -371639365
   )
   static int field1081;
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = -1347177619
   )
   static int field1082;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = 887185175
   )
   static int field1083;
   @ObfuscatedName("lq")
   static Widget field1084;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = -238313879
   )
   static int field1085;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = -1262086475
   )
   static int field1086;
   @ObfuscatedName("ip")
   static int[] field1087;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = 1887513259
   )
   static int field1088;
   @ObfuscatedName("ms")
   static Deque field1089;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = -1877032715
   )
   static int field1090;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = 326710725
   )
   static int field1091;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = 2024881889
   )
   static int field1092;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = 1550432941
   )
   static int field1093;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = -1857773345
   )
   static int field1094;
   @ObfuscatedName("mz")
   static boolean[] field1095;
   @ObfuscatedName("mr")
   static boolean[] field1096;
   @ObfuscatedName("mg")
   static boolean[] field1097;
   @ObfuscatedName("nf")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = -972899765
   )
   static int field1099;
   @ObfuscatedName("nc")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("nn")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = -1047269319
   )
   static int field1102;
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      longValue = -3489382288348757685L
   )
   static long field1103;
   @ObfuscatedName("na")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -1091888671
   )
   static int field1105;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = -264871451
   )
   static int field1106;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = -714387809
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("nw")
   static String field1108;
   @ObfuscatedName("oh")
   static boolean field1109;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 366862047
   )
   static int field1110;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = 1513167559
   )
   static int field1111;
   @ObfuscatedName("ny")
   static int[] field1112;
   @ObfuscatedName("nu")
   static int[] field1113;
   @ObfuscatedName("my")
   static Deque field1114;
   @ObfuscatedName("ov")
   static String field1115;
   @ObfuscatedName("oo")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = 668463835
   )
   static int field1117;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = -1498963057
   )
   static int field1118;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -930718561
   )
   static int field1119;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -1311422071
   )
   static int field1120;
   @ObfuscatedName("qn")
   static short field1121;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = -362631927
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = -807462255
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("oe")
   static SpritePixels[] field1124;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      longValue = 6347301695152739047L
   )
   static long field1125;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = 288175379
   )
   static int field1126;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = -477788957
   )
   static int field1127;
   @ObfuscatedName("qk")
   static class195 field1128;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = -767091303
   )
   static int field1129;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = -446837391
   )
   static int field1130;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = -1648548675
   )
   static int field1131;
   @ObfuscatedName("pi")
   static int[] field1132;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 137474793
   )
   static int field1133;
   @ObfuscatedName("pl")
   static int[] field1134;
   @ObfuscatedName("po")
   static int[] field1135;
   @ObfuscatedName("pm")
   static SoundEffect[] field1136;
   @ObfuscatedName("nh")
   static long[] field1137;
   @ObfuscatedName("py")
   static boolean[] field1138;
   @ObfuscatedName("pj")
   static int[] field1139;
   @ObfuscatedName("pt")
   static int[] field1140;
   @ObfuscatedName("qw")
   static int[] field1141;
   @ObfuscatedName("it")
   static String field1142;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = -1780687297
   )
   static int field1143;
   @ObfuscatedName("qq")
   static short field1144;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = 590503321
   )
   static int field1145;
   @ObfuscatedName("bf")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("qy")
   static short field1147;
   @ObfuscatedName("qa")
   static short field1148;
   @ObfuscatedName("qb")
   static short field1149;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 329352341
   )
   static int field1150;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = 888109199
   )
   static int field1151;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -569636075
   )
   static int field1152;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = -1560192239
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = -21045549
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = -1748336395
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = -72552299
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = -759921275
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = 41076433
   )
   static int field1158;
   @ObfuscatedName("jy")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = -577808003
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("qu")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("qp")
   static PlayerComposition field1162;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = -118396971
   )
   static int field1163;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = -905023929
   )
   static int field1164;
   @ObfuscatedName("rs")
   static XGrandExchangeOffer[] field1165;
   @ObfuscatedName("qz")
   static int[] field1166;
   @ObfuscatedName("rh")
   @ObfuscatedGetter(
      longValue = 4510587348087225513L
   )
   static long field1167;
   @ObfuscatedName("rn")
   static final class73 field1168;
   @ObfuscatedName("rk")
   static int[] field1169;
   @ObfuscatedName("rf")
   static int[] field1170;
   @ObfuscatedName("dx")
   static IndexData field1171;
   @ObfuscatedName("mq")
   @Export("chatMessages")
   static ChatMessages chatMessages;

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "78"
   )
   protected final void vmethod1169() {
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1414886705"
   )
   final void method1170(boolean var1) {
      int var2 = widgetRoot;
      int var3 = class261.field3626;
      int var4 = class19.field320;
      if(class14.method75(var2)) {
         class123.method2366(class90.widgets[var2], -1, var3, var4, var1);
      }

   }

   public final void init() {
      if(this.method853()) {
         class274[] var1 = new class274[]{class274.field3720, class274.field3718, class274.field3716, class274.field3717, class274.field3712, class274.field3708, class274.field3715, class274.field3705, class274.field3710, class274.field3713, class274.field3709, class274.field3714, class274.field3707, class274.field3719, class274.field3706};
         class274[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            class274 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3711);
            if(var5 != null) {
               switch(Integer.parseInt(var4.field3711)) {
               case 2:
                  class224.field2839 = var5;
                  break;
               case 3:
                  world = Integer.parseInt(var5);
                  break;
               case 4:
                  Spotanim.field3313 = Integer.parseInt(var5);
                  break;
               case 5:
                  field926 = Integer.parseInt(var5);
                  break;
               case 6:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 7:
                  class4.field20 = var5;
                  break;
               case 8:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
               case 9:
               case 13:
               default:
                  break;
               case 10:
                  class45.field583 = ItemLayer.method2440(Integer.parseInt(var5));
                  break;
               case 11:
                  Game[] var6 = new Game[]{Game.field3181, Game.field3182, Game.field3183, Game.field3189, Game.field3184, Game.field3186};
                  class4.field25 = (Game)method1381(var6, Integer.parseInt(var5));
                  if(class4.field25 == Game.field3189) {
                     class30.field423 = class289.field3850;
                  } else {
                     class30.field423 = class289.field3847;
                  }
                  break;
               case 12:
                  flags = Integer.parseInt(var5);
                  break;
               case 14:
                  field896 = Integer.parseInt(var5);
                  break;
               case 15:
                  class59.field731 = Integer.parseInt(var5);
               }
            }
         }

         Region.field2087 = false;
         field895 = false;
         Item.host = this.getCodeBase().getHost();
         String var10 = class45.field583.field3176;
         byte var7 = 0;

         try {
            class2.method2("oldschool", var10, var7, 17);
         } catch (Exception var9) {
            Game.method4169((String)null, var9);
         }

         class24.field356 = this;
         this.method851(765, 503, 142);
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1281079806"
   )
   protected final void vmethod1171() {
      class22.field340 = field926 == 0?'ꩊ':world + '鱀';
      class149.field2183 = field926 == 0?443:world + '썐';
      ChatMessages.field1510 = class22.field340;
      PlayerComposition.field2615 = class214.field2621;
      PlayerComposition.field2611 = class214.field2618;
      class87.field1363 = class214.field2620;
      class98.field1521 = class214.field2619;
      this.method854();
      this.method846();
      class20.field331 = this.method843();
      class61.field759 = new IndexFile(255, class155.field2231, class155.field2229, 500000);
      class134.field1989 = class39.method552();
      this.method870();
      IndexDataBase.method4270(this, class230.field3168);
      if(field926 != 0) {
         field905 = true;
      }

      int var1 = class134.field1989.field1286;
      field1103 = 0L;
      if(var1 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      int var2 = isResized?2:1;
      if(var2 == 1) {
         class24.field356.method841(765, 503);
      } else {
         class24.field356.method841(7680, 2160);
      }

      if(gameState >= 25) {
         secretPacketBuffer1.putOpcode(149);
         PacketBuffer var3 = secretPacketBuffer1;
         int var4 = isResized?2:1;
         var3.putByte(var4);
         secretPacketBuffer1.putShort(class261.field3626);
         secretPacketBuffer1.putShort(class19.field320);
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1770292631"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method1175();
      class30.method264();
      class17.method125();
      Ignore.method1118();
      FaceNormal.method2912();
      class41.method604();
      int var1;
      if(class20.field331 != null) {
         var1 = class20.field331.vmethod3012();
         field1088 = var1;
      }

      if(gameState == 0) {
         method1205();
         class234.field3197.vmethod3024();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field690[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field691[var1] = 0L;
         }

         class64.field786 = 0;
      } else if(gameState == 5) {
         ItemLayer.method2439(this);
         method1205();
         class234.field3197.vmethod3024();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field690[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field691[var1] = 0L;
         }

         class64.field786 = 0;
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            ItemLayer.method2439(this);
            this.method1178();
         } else if(gameState == 25) {
            class33.method352();
         }
      } else {
         ItemLayer.method2439(this);
      }

      if(gameState == 30) {
         this.method1179();
      } else if(gameState == 40 || gameState == 45) {
         this.method1178();
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1750808323"
   )
   protected final void vmethod1173(boolean var1) {
      boolean var2 = class89.method1744();
      if(var2 && field1109 && class48.field611 != null) {
         class48.field611.method2093();
      }

      int var3;
      if((gameState == 10 || gameState == 20 || gameState == 30) && field1103 != 0L && class226.method4147() > field1103) {
         var3 = class4.method8();
         field1103 = 0L;
         if(var3 >= 2) {
            isResized = true;
         } else {
            isResized = false;
         }

         int var4 = isResized?2:1;
         if(var4 == 1) {
            class24.field356.method841(765, 503);
         } else {
            class24.field356.method841(7680, 2160);
         }

         if(gameState >= 25) {
            secretPacketBuffer1.putOpcode(149);
            PacketBuffer var5 = secretPacketBuffer1;
            int var6 = isResized?2:1;
            var5.putByte(var6);
            secretPacketBuffer1.putShort(class261.field3626);
            secretPacketBuffer1.putShort(class19.field320);
         }
      }

      if(var1) {
         for(var3 = 0; var3 < 100; ++var3) {
            field1095[var3] = true;
         }
      }

      if(gameState == 0) {
         this.method842(class92.field1430, class92.field1431, var1);
      } else if(gameState == 5) {
         Ignore.method1121(class40.field531, class3.field15, MessageNode.field845, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            Ignore.method1121(class40.field531, class3.field15, MessageNode.field845, var1);
         } else if(gameState == 25) {
            if(field949 == 1) {
               if(field1044 > field1119) {
                  field1119 = field1044;
               }

               var3 = (field1119 * 50 - field1044 * 50) / field1119;
               class32.method349("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else if(field949 == 2) {
               if(field947 > field923) {
                  field923 = field947;
               }

               var3 = (field923 * 50 - field947 * 50) / field923 + 50;
               class32.method349("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else {
               class32.method349("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1182();
         } else if(gameState == 40) {
            class32.method349("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class32.method349("Please wait...", false);
         }
      } else {
         Ignore.method1121(class40.field531, class3.field15, MessageNode.field845, var1);
      }

      if(gameState == 30 && field1102 == 0 && !var1) {
         for(var3 = 0; var3 < field1093; ++var3) {
            if(field1096[var3]) {
               class40.field541.vmethod5084(widgetPositionX[var3], widgetPositionY[var3], widgetBoundsWidth[var3], widgetBoundsHeight[var3]);
               field1096[var3] = false;
            }
         }
      } else if(gameState > 0) {
         class40.field541.vmethod5083(0, 0);

         for(var3 = 0; var3 < field1093; ++var3) {
            field1096[var3] = false;
         }
      }

   }

   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   void method1175() {
      if(gameState != 1000) {
         boolean var1 = class50.method763();
         if(!var1) {
            this.method1176();
         }

      }
   }

   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1319828433"
   )
   void method1176() {
      if(class238.field3258 >= 4) {
         this.method973("js5crc");
         gameState = 1000;
      } else {
         if(class238.field3241 >= 4) {
            if(gameState <= 5) {
               this.method973("js5io");
               gameState = 1000;
               return;
            }

            field919 = 3000;
            class238.field3241 = 3;
         }

         if(--field919 + 1 <= 0) {
            try {
               if(field1150 == 0) {
                  RSCanvas.field659 = GameEngine.field682.method2968(Item.host, ChatMessages.field1510);
                  ++field1150;
               }

               if(field1150 == 1) {
                  if(RSCanvas.field659.field2209 == 2) {
                     this.method1177(-1);
                     return;
                  }

                  if(RSCanvas.field659.field2209 == 1) {
                     ++field1150;
                  }
               }

               if(field1150 == 2) {
                  class290.rssocket = new RSSocket((Socket)RSCanvas.field659.field2211, GameEngine.field682);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(142);
                  class290.rssocket.queueForWrite(var1.payload, 0, 5);
                  ++field1150;
                  field920 = class226.method4147();
               }

               if(field1150 == 3) {
                  if(gameState > 5 && class290.rssocket.available() <= 0) {
                     if(class226.method4147() - field920 > 30000L) {
                        this.method1177(-2);
                        return;
                     }
                  } else {
                     int var2 = class290.rssocket.readByte();
                     if(var2 != 0) {
                        this.method1177(var2);
                        return;
                     }

                     ++field1150;
                  }
               }

               if(field1150 == 4) {
                  Actor.method1545(class290.rssocket, gameState > 20);
                  RSCanvas.field659 = null;
                  class290.rssocket = null;
                  field1150 = 0;
                  field921 = 0;
               }
            } catch (IOException var3) {
               this.method1177(-3);
            }

         }
      }
   }

   @ObfuscatedName("ed")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1970363979"
   )
   void method1177(int var1) {
      RSCanvas.field659 = null;
      class290.rssocket = null;
      field1150 = 0;
      if(class22.field340 == ChatMessages.field1510) {
         ChatMessages.field1510 = class149.field2183;
      } else {
         ChatMessages.field1510 = class22.field340;
      }

      ++field921;
      if(field921 < 2 || var1 != 7 && var1 != 9) {
         if(field921 >= 2 && var1 == 6) {
            this.method973("js5connect_outofdate");
            gameState = 1000;
         } else if(field921 >= 4) {
            if(gameState <= 5) {
               this.method973("js5connect");
               gameState = 1000;
            } else {
               field919 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method973("js5connect_full");
         gameState = 1000;
      } else {
         field919 = 3000;
      }

   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-37"
   )
   final void method1178() {
      try {
         if(loginState == 0) {
            if(XGrandExchangeOffer.rssocket != null) {
               XGrandExchangeOffer.rssocket.method3048();
               XGrandExchangeOffer.rssocket = null;
            }

            class51.field654 = null;
            field943 = false;
            field901 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(class51.field654 == null) {
               class51.field654 = GameEngine.field682.method2968(Item.host, ChatMessages.field1510);
            }

            if(class51.field654.field2209 == 2) {
               throw new IOException();
            }

            if(class51.field654.field2209 == 1) {
               XGrandExchangeOffer.rssocket = new RSSocket((Socket)class51.field654.field2211, GameEngine.field682);
               class51.field654 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(14);
            XGrandExchangeOffer.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, 1);
            secretPacketBuffer2.offset = 0;
            loginState = 3;
         }

         int var1;
         if(loginState == 3) {
            if(class48.field611 != null) {
               class48.field611.method2047();
            }

            if(WidgetNode.field812 != null) {
               WidgetNode.field812.method2047();
            }

            var1 = XGrandExchangeOffer.rssocket.readByte();
            if(class48.field611 != null) {
               class48.field611.method2047();
            }

            if(WidgetNode.field812 != null) {
               WidgetNode.field812.method2047();
            }

            if(var1 != 0) {
               class44.method646(var1);
               return;
            }

            secretPacketBuffer2.offset = 0;
            loginState = 4;
         }

         if(loginState == 4) {
            if(secretPacketBuffer2.offset < 8) {
               var1 = XGrandExchangeOffer.rssocket.available();
               if(var1 > 8 - secretPacketBuffer2.offset) {
                  var1 = 8 - secretPacketBuffer2.offset;
               }

               if(var1 > 0) {
                  XGrandExchangeOffer.rssocket.read(secretPacketBuffer2.payload, secretPacketBuffer2.offset, var1);
                  secretPacketBuffer2.offset += var1;
               }
            }

            if(secretPacketBuffer2.offset == 8) {
               secretPacketBuffer2.offset = 0;
               class20.field329 = secretPacketBuffer2.readLong();
               loginState = 5;
            }
         }

         int var2;
         int var3;
         if(loginState == 5) {
            int[] var6 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class20.field329 >> 32), (int)(class20.field329 & -1L)};
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(1);
            secretPacketBuffer1.putByte(class92.field1436.vmethod5090());
            secretPacketBuffer1.putInt(var6[0]);
            secretPacketBuffer1.putInt(var6[1]);
            secretPacketBuffer1.putInt(var6[2]);
            secretPacketBuffer1.putInt(var6[3]);
            switch(class92.field1436.field2177) {
            case 0:
               secretPacketBuffer1.offset += 8;
               break;
            case 1:
            case 2:
               secretPacketBuffer1.put24bitInt(class175.authCodeForLogin);
               secretPacketBuffer1.offset += 5;
               break;
            case 3:
               secretPacketBuffer1.putInt(((Integer)class134.field1989.preferences.get(Integer.valueOf(class228.method4154(class92.username)))).intValue());
               secretPacketBuffer1.offset += 4;
            }

            secretPacketBuffer1.method3191(class92.password);
            secretPacketBuffer1.method3353(class90.field1396, class90.field1397);
            field933.offset = 0;
            if(gameState == 40) {
               field933.putByte(18);
            } else {
               field933.putByte(16);
            }

            field933.putShort(0);
            var2 = field933.offset;
            field933.putInt(142);
            field933.putBytes(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
            var3 = field933.offset;
            field933.method3191(class92.username);
            field933.putByte((isResized?1:0) << 1 | (field895?1:0));
            field933.putShort(class261.field3626);
            field933.putShort(class19.field320);
            MessageNode.method1129(field933);
            field933.method3191(class224.field2839);
            field933.putInt(class59.field731);
            Buffer var4 = new Buffer(class242.field3290.method5442());
            class242.field3290.method5443(var4);
            field933.putBytes(var4.payload, 0, var4.payload.length);
            field933.putByte(Spotanim.field3313);
            field933.putInt(0);
            field933.putInt(class1.indexInterfaces.field3216);
            field933.putInt(class170.indexSoundEffects.field3216);
            field933.putInt(class17.field311.field3216);
            field933.putInt(class38.field513.field3216);
            field933.putInt(class43.field559.field3216);
            field933.putInt(class34.indexMaps.field3216);
            field933.putInt(class44.indexTrack1.field3216);
            field933.putInt(ChatMessages.indexModels.field3216);
            field933.putInt(class77.indexSprites.field3216);
            field933.putInt(class20.indexTextures.field3216);
            field933.putInt(class64.field785.field3216);
            field933.putInt(class33.indexTrack2.field3216);
            field933.putInt(class66.indexScripts.field3216);
            field933.putInt(class91.field1411.field3216);
            field933.putInt(class15.field294.field3216);
            field933.putInt(field1171.field3216);
            field933.putInt(class22.field336.field3216);
            field933.encryptXtea(var6, var3, field933.offset);
            field933.method3195(field933.offset - var2);
            XGrandExchangeOffer.rssocket.queueForWrite(field933.payload, 0, field933.offset);
            secretPacketBuffer1.seed(var6);

            for(int var5 = 0; var5 < 4; ++var5) {
               var6[var5] += 50;
            }

            secretPacketBuffer2.seed(var6);
            loginState = 6;
         }

         if(loginState == 6 && XGrandExchangeOffer.rssocket.available() > 0) {
            var1 = XGrandExchangeOffer.rssocket.readByte();
            if(var1 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var1 == 2) {
               loginState = 9;
            } else if(var1 == 15 && gameState == 40) {
               packetLength = -1;
               loginState = 13;
            } else if(var1 == 23 && field912 < 1) {
               ++field912;
               loginState = 0;
            } else {
               if(var1 != 29) {
                  class44.method646(var1);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && XGrandExchangeOffer.rssocket.available() > 0) {
            field941 = (XGrandExchangeOffer.rssocket.readByte() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field901 = 0;
            Buffer.method3383("You have only just left another world.", "Your profile will be transferred in:", field941 / 60 + " seconds.");
            if(--field941 <= 0) {
               loginState = 0;
            }

         } else {
            boolean var11;
            if(loginState == 9 && XGrandExchangeOffer.rssocket.available() >= 13) {
               boolean var12 = XGrandExchangeOffer.rssocket.readByte() == 1;
               XGrandExchangeOffer.rssocket.read(secretPacketBuffer2.payload, 0, 4);
               secretPacketBuffer2.offset = 0;
               var11 = false;
               if(var12) {
                  var2 = secretPacketBuffer2.readOpcode() << 24;
                  var2 |= secretPacketBuffer2.readOpcode() << 16;
                  var2 |= secretPacketBuffer2.readOpcode() << 8;
                  var2 |= secretPacketBuffer2.readOpcode();
                  var3 = class228.method4154(class92.username);
                  if(class134.field1989.preferences.size() >= 10 && !class134.field1989.preferences.containsKey(Integer.valueOf(var3))) {
                     Iterator var13 = class134.field1989.preferences.entrySet().iterator();
                     var13.next();
                     var13.remove();
                  }

                  class134.field1989.preferences.put(Integer.valueOf(var3), Integer.valueOf(var2));
                  GroundObject.method2523();
               }

               field1057 = XGrandExchangeOffer.rssocket.readByte();
               field1059 = XGrandExchangeOffer.rssocket.readByte() == 1;
               localInteractingIndex = XGrandExchangeOffer.rssocket.readByte();
               localInteractingIndex <<= 8;
               localInteractingIndex += XGrandExchangeOffer.rssocket.readByte();
               field1012 = XGrandExchangeOffer.rssocket.readByte();
               XGrandExchangeOffer.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               field936 = secretPacketBuffer2.readOpcode();
               XGrandExchangeOffer.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();

               try {
                  Client var7 = class24.field356;
                  JSObject.getWindow(var7).call("zap", (Object[])null);
               } catch (Throwable var9) {
                  ;
               }

               loginState = 10;
            }

            if(loginState != 10) {
               if(loginState == 11 && XGrandExchangeOffer.rssocket.available() >= 2) {
                  secretPacketBuffer2.offset = 0;
                  XGrandExchangeOffer.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                  secretPacketBuffer2.offset = 0;
                  class51.field647 = secretPacketBuffer2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && XGrandExchangeOffer.rssocket.available() >= class51.field647) {
                  secretPacketBuffer2.offset = 0;
                  XGrandExchangeOffer.rssocket.read(secretPacketBuffer2.payload, 0, class51.field647);
                  secretPacketBuffer2.offset = 0;
                  String var16 = secretPacketBuffer2.readString();
                  String var18 = secretPacketBuffer2.readString();
                  String var17 = secretPacketBuffer2.readString();
                  Buffer.method3383(var16, var18, var17);
                  class12.setGameState(10);
               }

               if(loginState == 13) {
                  if(packetLength == -1) {
                     if(XGrandExchangeOffer.rssocket.available() < 2) {
                        return;
                     }

                     XGrandExchangeOffer.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                     secretPacketBuffer2.offset = 0;
                     packetLength = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(XGrandExchangeOffer.rssocket.available() >= packetLength) {
                     XGrandExchangeOffer.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                     secretPacketBuffer2.offset = 0;
                     var1 = packetLength;
                     class60.method1036();
                     class71.method1125(secretPacketBuffer2);
                     if(secretPacketBuffer2.offset != var1) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field901;
                  if(field901 > 2000) {
                     if(field912 < 1) {
                        if(class22.field340 == ChatMessages.field1510) {
                           ChatMessages.field1510 = class149.field2183;
                        } else {
                           ChatMessages.field1510 = class22.field340;
                        }

                        ++field912;
                        loginState = 0;
                     } else {
                        class44.method646(-3);
                     }
                  }
               }
            } else {
               if(XGrandExchangeOffer.rssocket.available() >= packetLength) {
                  secretPacketBuffer2.offset = 0;
                  XGrandExchangeOffer.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                  field1125 = -1L;
                  field1038 = -1;
                  PacketBuffer.field2414.field833 = 0;
                  class219.field2794 = true;
                  field904 = true;
                  field948 = -1L;
                  class7.method29();
                  secretPacketBuffer1.offset = 0;
                  secretPacketBuffer2.offset = 0;
                  field936 = -1;
                  field1164 = -1;
                  field1070 = -1;
                  field978 = -1;
                  field937 = 0;
                  field906 = 0;
                  field986 = 0;
                  field907 = 0;
                  RSCanvas.method776();
                  class261.method4789(0);
                  Tile.method2531();
                  field1043 = 0;
                  field1045 = false;
                  field1131 = 0;
                  field1061 = (int)(Math.random() * 100.0D) - 50;
                  field956 = (int)(Math.random() * 110.0D) - 55;
                  field958 = (int)(Math.random() * 80.0D) - 40;
                  mapScale = (int)(Math.random() * 120.0D) - 60;
                  mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
                  mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
                  field1017 = 0;
                  field1117 = -1;
                  flagX = 0;
                  flagY = 0;
                  field915 = class91.field1407;
                  field916 = class91.field1407;
                  field928 = 0;
                  NPC.method1726();

                  for(var1 = 0; var1 < 2048; ++var1) {
                     cachedPlayers[var1] = null;
                  }

                  for(var1 = 0; var1 < '耀'; ++var1) {
                     cachedNPCs[var1] = null;
                  }

                  field1106 = -1;
                  projectiles.method3656();
                  field1023.method3656();

                  for(var1 = 0; var1 < 4; ++var1) {
                     for(var2 = 0; var2 < 104; ++var2) {
                        for(var3 = 0; var3 < 104; ++var3) {
                           groundItemDeque[var1][var2][var3] = null;
                        }
                     }
                  }

                  field1021 = new Deque();
                  field939 = 0;
                  friendCount = 0;
                  ignoreCount = 0;

                  for(var1 = 0; var1 < class168.field2316; ++var1) {
                     class241 var8 = XItemContainer.method1091(var1);
                     if(var8 != null) {
                        class211.settings[var1] = 0;
                        class211.widgetSettings[var1] = 0;
                     }
                  }

                  chatMessages.method1826();
                  field1058 = -1;
                  if(widgetRoot != -1) {
                     var1 = widgetRoot;
                     if(var1 != -1 && Widget.validInterfaces[var1]) {
                        Widget.field2682.method4186(var1);
                        if(class90.widgets[var1] != null) {
                           var11 = true;

                           for(var3 = 0; var3 < class90.widgets[var1].length; ++var3) {
                              if(class90.widgets[var1][var3] != null) {
                                 if(class90.widgets[var1][var3].type != 2) {
                                    class90.widgets[var1][var3] = null;
                                 } else {
                                    var11 = false;
                                 }
                              }
                           }

                           if(var11) {
                              class90.widgets[var1] = null;
                           }

                           Widget.validInterfaces[var1] = false;
                        }
                     }
                  }

                  for(WidgetNode var14 = (WidgetNode)componentTable.method3606(); var14 != null; var14 = (WidgetNode)componentTable.method3607()) {
                     class276.method4969(var14, true);
                  }

                  widgetRoot = -1;
                  componentTable = new XHashTable(8);
                  field1054 = null;
                  RSCanvas.method776();
                  field1162.method4020((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var1 = 0; var1 < 8; ++var1) {
                     playerOptions[var1] = null;
                     playerOptionsPriorities[var1] = false;
                  }

                  class208.method3967();
                  field898 = true;

                  for(var1 = 0; var1 < 100; ++var1) {
                     field1095[var1] = true;
                  }

                  secretPacketBuffer1.putOpcode(149);
                  PacketBuffer var15 = secretPacketBuffer1;
                  var2 = isResized?2:1;
                  var15.putByte(var2);
                  secretPacketBuffer1.putShort(class261.field3626);
                  secretPacketBuffer1.putShort(class19.field320);
                  field1115 = null;
                  class48.clanChatCount = 0;
                  ClassInfo.clanMembers = null;

                  for(var1 = 0; var1 < 8; ++var1) {
                     field1165[var1] = new XGrandExchangeOffer();
                  }

                  class176.field2402 = null;
                  class71.method1125(secretPacketBuffer2);
                  class51.field646 = -1;
                  class60.xteaChanged(false);
                  field936 = -1;
               }

            }
         }
      } catch (IOException var10) {
         if(field912 < 1) {
            if(ChatMessages.field1510 == class22.field340) {
               ChatMessages.field1510 = class149.field2183;
            } else {
               ChatMessages.field1510 = class22.field340;
            }

            ++field912;
            loginState = 0;
         } else {
            class44.method646(-2);
         }
      }
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1177013186"
   )
   final void method1179() {
      if(field906 > 1) {
         --field906;
      }

      if(field986 > 0) {
         --field986;
      }

      if(field943) {
         field943 = false;
         if(field986 > 0) {
            class84.method1695();
         } else {
            class12.setGameState(40);
            class98.field1523 = XGrandExchangeOffer.rssocket;
            XGrandExchangeOffer.rssocket = null;
         }

      } else {
         if(!isMenuOpen) {
            IndexDataBase.method4272();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method1188(); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(class212.method3993()) {
               secretPacketBuffer1.putOpcode(148);
               secretPacketBuffer1.putByte(0);
               var1 = secretPacketBuffer1.offset;
               class227.method4148(secretPacketBuffer1);
               secretPacketBuffer1.method3364(secretPacketBuffer1.offset - var1);
            }

            Object var11 = PacketBuffer.field2414.field834;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            synchronized(PacketBuffer.field2414.field834) {
               if(!field1003) {
                  PacketBuffer.field2414.field833 = 0;
               } else if(class59.field727 != 0 || PacketBuffer.field2414.field833 >= 40) {
                  secretPacketBuffer1.putOpcode(70);
                  secretPacketBuffer1.putByte(0);
                  var2 = secretPacketBuffer1.offset;
                  var3 = 0;

                  for(var4 = 0; var4 < PacketBuffer.field2414.field833 && secretPacketBuffer1.offset - var2 < 240; ++var4) {
                     ++var3;
                     var5 = PacketBuffer.field2414.field837[var4];
                     if(var5 < 0) {
                        var5 = 0;
                     } else if(var5 > 502) {
                        var5 = 502;
                     }

                     var6 = PacketBuffer.field2414.field836[var4];
                     if(var6 < 0) {
                        var6 = 0;
                     } else if(var6 > 764) {
                        var6 = 764;
                     }

                     var7 = var5 * 765 + var6;
                     if(PacketBuffer.field2414.field837[var4] == -1 && PacketBuffer.field2414.field836[var4] == -1) {
                        var6 = -1;
                        var5 = -1;
                        var7 = 524287;
                     }

                     if(var6 == field954 && var5 == field893) {
                        if(field1038 < 2047) {
                           ++field1038;
                        }
                     } else {
                        var8 = var6 - field954;
                        field954 = var6;
                        var9 = var5 - field893;
                        field893 = var5;
                        if(field1038 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                           var8 += 32;
                           var9 += 32;
                           secretPacketBuffer1.putShort(var9 + (var8 << 6) + (field1038 << 12));
                           field1038 = 0;
                        } else if(field1038 < 8) {
                           secretPacketBuffer1.put24bitInt(var7 + (field1038 << 19) + 8388608);
                           field1038 = 0;
                        } else {
                           secretPacketBuffer1.putInt(var7 + (field1038 << 19) + -1073741824);
                           field1038 = 0;
                        }
                     }
                  }

                  secretPacketBuffer1.method3364(secretPacketBuffer1.offset - var2);
                  if(var3 >= PacketBuffer.field2414.field833) {
                     PacketBuffer.field2414.field833 = 0;
                  } else {
                     PacketBuffer.field2414.field833 -= var3;

                     for(var4 = 0; var4 < PacketBuffer.field2414.field833; ++var4) {
                        PacketBuffer.field2414.field836[var4] = PacketBuffer.field2414.field836[var4 + var3];
                        PacketBuffer.field2414.field837[var4] = PacketBuffer.field2414.field837[var4 + var3];
                     }
                  }
               }
            }

            if(class59.field727 == 1 || !class149.field2178 && class59.field727 == 4 || class59.field727 == 2) {
               long var12 = (class59.field715 - field1125) / 50L;
               if(var12 > 4095L) {
                  var12 = 4095L;
               }

               field1125 = class59.field715;
               var3 = class59.field729;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > class19.field320) {
                  var3 = class19.field320;
               }

               var4 = class59.field717;
               if(var4 < 0) {
                  var4 = 0;
               } else if(var4 > class261.field3626) {
                  var4 = class261.field3626;
               }

               var5 = (int)var12;
               secretPacketBuffer1.putOpcode(160);
               secretPacketBuffer1.putShort((class59.field727 == 2?1:0) + (var5 << 1));
               secretPacketBuffer1.putShort(var4);
               secretPacketBuffer1.putShort(var3);
            }

            if(class50.field641 > 0) {
               secretPacketBuffer1.putOpcode(154);
               secretPacketBuffer1.putShort(0);
               var1 = secretPacketBuffer1.offset;
               long var14 = class226.method4147();

               for(var4 = 0; var4 < class50.field641; ++var4) {
                  long var16 = var14 - field948;
                  if(var16 > 16777215L) {
                     var16 = 16777215L;
                  }

                  field948 = var14;
                  secretPacketBuffer1.put24bitInt((int)var16);
                  secretPacketBuffer1.putByte(class50.field629[var4]);
               }

               secretPacketBuffer1.method3195(secretPacketBuffer1.offset - var1);
            }

            if(field980 > 0) {
               --field980;
            }

            if(class50.field624[96] || class50.field624[97] || class50.field624[98] || class50.field624[99]) {
               field981 = true;
            }

            if(field981 && field980 <= 0) {
               field980 = 20;
               field981 = false;
               secretPacketBuffer1.putOpcode(231);
               secretPacketBuffer1.method3382(mapAngle);
               secretPacketBuffer1.method3382(field973);
            }

            if(class219.field2794 && !field904) {
               field904 = true;
               secretPacketBuffer1.putOpcode(33);
               secretPacketBuffer1.putByte(1);
            }

            if(!class219.field2794 && field904) {
               field904 = false;
               secretPacketBuffer1.putOpcode(33);
               secretPacketBuffer1.putByte(0);
            }

            class8.method34();
            if(gameState == 30) {
               ScriptState.method1082();

               for(var1 = 0; var1 < field1131; ++var1) {
                  --field1134[var1];
                  if(field1134[var1] >= -10) {
                     SoundEffect var18 = field1136[var1];
                     if(var18 == null) {
                        Object var10000 = null;
                        var18 = SoundEffect.method1970(class43.field559, field1132[var1], 0);
                        if(var18 == null) {
                           continue;
                        }

                        field1134[var1] += var18.method1963();
                        field1136[var1] = var18;
                     }

                     if(field1134[var1] < 0) {
                        if(field1135[var1] != 0) {
                           var4 = (field1135[var1] & 255) * 128;
                           var5 = field1135[var1] >> 16 & 255;
                           var6 = var5 * 128 + 64 - XGrandExchangeOffer.localPlayer.x;
                           if(var6 < 0) {
                              var6 = -var6;
                           }

                           var7 = field1135[var1] >> 8 & 255;
                           var8 = var7 * 128 + 64 - XGrandExchangeOffer.localPlayer.y;
                           if(var8 < 0) {
                              var8 = -var8;
                           }

                           var9 = var8 + var6 - 128;
                           if(var9 > var4) {
                              field1134[var1] = -100;
                              continue;
                           }

                           if(var9 < 0) {
                              var9 = 0;
                           }

                           var3 = (var4 - var9) * field1130 / var4;
                        } else {
                           var3 = field1129;
                        }

                        if(var3 > 0) {
                           class107 var19 = var18.method1966().method2017(class154.field2216);
                           class117 var20 = class117.method2249(var19, 100, var3);
                           var20.method2160(field1009[var1] - 1);
                           class164.field2291.method1936(var20);
                        }

                        field1134[var1] = -100;
                     }
                  } else {
                     --field1131;

                     for(var2 = var1; var2 < field1131; ++var2) {
                        field1132[var2] = field1132[var2 + 1];
                        field1136[var2] = field1136[var2 + 1];
                        field1009[var2] = field1009[var2 + 1];
                        field1134[var2] = field1134[var2 + 1];
                        field1135[var2] = field1135[var2 + 1];
                     }

                     --var1;
                  }
               }

               if(field1109 && !class20.method148()) {
                  if(field1077 != 0 && field1127 != -1) {
                     class32.method322(class44.indexTrack1, field1127, 0, field1077, false);
                  }

                  field1109 = false;
               }

               ++field937;
               if(field937 > 750) {
                  if(field986 > 0) {
                     class84.method1695();
                  } else {
                     class12.setGameState(40);
                     class98.field1523 = XGrandExchangeOffer.rssocket;
                     XGrandExchangeOffer.rssocket = null;
                  }

               } else {
                  class20.method147();
                  class46.method712();
                  int[] var27 = class96.field1496;

                  for(var2 = 0; var2 < class96.field1489; ++var2) {
                     Player var21 = cachedPlayers[var27[var2]];
                     if(var21 != null && var21.field1214 > 0) {
                        --var21.field1214;
                        if(var21.field1214 == 0) {
                           var21.overhead = null;
                        }
                     }
                  }

                  for(var2 = 0; var2 < field928; ++var2) {
                     var3 = field1013[var2];
                     NPC var30 = cachedNPCs[var3];
                     if(var30 != null && var30.field1214 > 0) {
                        --var30.field1214;
                        if(var30.field1214 == 0) {
                           var30.overhead = null;
                        }
                     }
                  }

                  ++field966;
                  if(field1016 != 0) {
                     field999 += 20;
                     if(field999 >= 400) {
                        field1016 = 0;
                     }
                  }

                  if(class37.field507 != null) {
                     ++field1001;
                     if(field1001 >= 15) {
                        class219.method4130(class37.field507);
                        class37.field507 = null;
                     }
                  }

                  Widget var28 = Player.field868;
                  Widget var29 = NPCComposition.field3579;
                  Player.field868 = null;
                  NPCComposition.field3579 = null;
                  field1067 = null;
                  field1071 = false;
                  field1068 = false;
                  field1111 = 0;

                  while(class14.method69() && field1111 < 128) {
                     if(field1057 >= 2 && class50.field624[82] && class50.field625 == 66) {
                        String var31 = "";

                        MessageNode var22;
                        for(Iterator var32 = class98.field1519.iterator(); var32.hasNext(); var31 = var31 + var22.name + ':' + var22.value + '\n') {
                           var22 = (MessageNode)var32.next();
                        }

                        class24.field356.method844(var31);
                     } else {
                        field1113[field1111] = class50.field625;
                        field1112[field1111] = class22.field341;
                        ++field1111;
                     }
                  }

                  if(widgetRoot != -1) {
                     RSSocket.method3039(widgetRoot, 0, 0, class261.field3626, class19.field320, 0, 0);
                  }

                  ++field1075;

                  while(true) {
                     Widget var33;
                     Widget var34;
                     class69 var35;
                     do {
                        var35 = (class69)field1114.method3658();
                        if(var35 == null) {
                           while(true) {
                              do {
                                 var35 = (class69)field974.method3658();
                                 if(var35 == null) {
                                    while(true) {
                                       do {
                                          var35 = (class69)field1089.method3658();
                                          if(var35 == null) {
                                             this.method1465();
                                             class48.method737();
                                             if(field961 != null) {
                                                this.method1453();
                                             }

                                             if(class20.field323 != null) {
                                                class219.method4130(class20.field323);
                                                ++field1090;
                                                if(class59.field732 == 0) {
                                                   if(field1007) {
                                                      if(class20.field323 == class61.field747 && field1006 != field1105) {
                                                         Widget var36 = class20.field323;
                                                         byte var26 = 0;
                                                         if(field1069 == 1 && var36.contentType == 206) {
                                                            var26 = 1;
                                                         }

                                                         if(var36.itemIds[field1006] <= 0) {
                                                            var26 = 0;
                                                         }

                                                         if(class60.method1035(class43.method626(var36))) {
                                                            var5 = field1105;
                                                            var6 = field1006;
                                                            var36.itemIds[var6] = var36.itemIds[var5];
                                                            var36.itemQuantities[var6] = var36.itemQuantities[var5];
                                                            var36.itemIds[var5] = -1;
                                                            var36.itemQuantities[var5] = 0;
                                                         } else if(var26 == 1) {
                                                            var5 = field1105;
                                                            var6 = field1006;

                                                            while(var5 != var6) {
                                                               if(var5 > var6) {
                                                                  var36.method4051(var5 - 1, var5);
                                                                  --var5;
                                                               } else if(var5 < var6) {
                                                                  var36.method4051(var5 + 1, var5);
                                                                  ++var5;
                                                               }
                                                            }
                                                         } else {
                                                            var36.method4051(field1006, field1105);
                                                         }

                                                         secretPacketBuffer1.putOpcode(222);
                                                         secretPacketBuffer1.putShort(field1006);
                                                         secretPacketBuffer1.method3234(field1105);
                                                         secretPacketBuffer1.method3225(var26);
                                                         secretPacketBuffer1.method3242(class20.field323.id);
                                                      }
                                                   } else {
                                                      label924: {
                                                         label942: {
                                                            var3 = class84.method1694();
                                                            if(menuOptionCount > 2) {
                                                               boolean var25;
                                                               if(field1027 == 1) {
                                                                  if(menuOptionCount <= 0) {
                                                                     var25 = false;
                                                                  } else if(field1005 && class50.field624[81] && field1037 != -1) {
                                                                     var25 = true;
                                                                  } else {
                                                                     var25 = false;
                                                                  }

                                                                  if(!var25) {
                                                                     break label942;
                                                                  }
                                                               }

                                                               if(var3 < 0) {
                                                                  var25 = false;
                                                               } else {
                                                                  var5 = menuTypes[var3];
                                                                  if(var5 >= 2000) {
                                                                     var5 -= 2000;
                                                                  }

                                                                  if(var5 == 1007) {
                                                                     var25 = true;
                                                                  } else {
                                                                     var25 = false;
                                                                  }
                                                               }

                                                               if(var25) {
                                                                  break label942;
                                                               }
                                                            }

                                                            if(menuOptionCount > 0) {
                                                               XGrandExchangeOffer.method109(field993, field970);
                                                            }
                                                            break label924;
                                                         }

                                                         this.method1242(field993, field970);
                                                      }
                                                   }

                                                   field1001 = 10;
                                                   class59.field727 = 0;
                                                   class20.field323 = null;
                                                } else if(field1090 >= 5 && (class59.field721 > field993 + 5 || class59.field721 < field993 - 5 || class59.field722 > field970 + 5 || class59.field722 < field970 - 5)) {
                                                   field1007 = true;
                                                }
                                             }

                                             if(Region.method2786()) {
                                                var3 = Region.field2072;
                                                var4 = Region.field2053;
                                                secretPacketBuffer1.putOpcode(106);
                                                secretPacketBuffer1.putByte(5);
                                                secretPacketBuffer1.putShort(class166.baseX + var3);
                                                secretPacketBuffer1.method3225(class50.field624[82]?(class50.field624[81]?2:1):0);
                                                secretPacketBuffer1.putShort(var4 + class146.baseY);
                                                Region.method2747();
                                                field997 = class59.field717;
                                                field998 = class59.field729;
                                                field1016 = 1;
                                                field999 = 0;
                                                flagX = var3;
                                                flagY = var4;
                                             }

                                             if(var28 != Player.field868) {
                                                if(var28 != null) {
                                                   class219.method4130(var28);
                                                }

                                                if(Player.field868 != null) {
                                                   class219.method4130(Player.field868);
                                                }
                                             }

                                             if(var29 != NPCComposition.field3579 && field1120 == field1042) {
                                                if(var29 != null) {
                                                   class219.method4130(var29);
                                                }

                                                if(NPCComposition.field3579 != null) {
                                                   class219.method4130(NPCComposition.field3579);
                                                }
                                             }

                                             if(NPCComposition.field3579 != null) {
                                                if(field1120 < field1042) {
                                                   ++field1120;
                                                   if(field1042 == field1120) {
                                                      class219.method4130(NPCComposition.field3579);
                                                   }
                                                }
                                             } else if(field1120 > 0) {
                                                --field1120;
                                             }

                                             class60.method1034();
                                             if(field929) {
                                                class36.method501();
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field1166[var3];
                                             }

                                             chatMessages.method1830();
                                             var3 = class10.method45();
                                             var4 = class50.keyboardIdleTicks;
                                             if(var3 > 15000 && var4 > 15000) {
                                                field986 = 250;
                                                class261.method4789(14500);
                                                secretPacketBuffer1.putOpcode(133);
                                             }

                                             ++field902;
                                             if(field902 > 500) {
                                                field902 = 0;
                                                var6 = (int)(Math.random() * 8.0D);
                                                if((var6 & 1) == 1) {
                                                   field1061 += field1063;
                                                }

                                                if((var6 & 2) == 2) {
                                                   field956 += field957;
                                                }

                                                if((var6 & 4) == 4) {
                                                   field958 += field959;
                                                }
                                             }

                                             if(field1061 < -50) {
                                                field1063 = 2;
                                             }

                                             if(field1061 > 50) {
                                                field1063 = -2;
                                             }

                                             if(field956 < -55) {
                                                field957 = 2;
                                             }

                                             if(field956 > 55) {
                                                field957 = -2;
                                             }

                                             if(field958 < -40) {
                                                field959 = 1;
                                             }

                                             if(field958 > 40) {
                                                field959 = -1;
                                             }

                                             ++field965;
                                             if(field965 > 500) {
                                                field965 = 0;
                                                var6 = (int)(Math.random() * 8.0D);
                                                if((var6 & 1) == 1) {
                                                   mapScale += mapOffset;
                                                }

                                                if((var6 & 2) == 2) {
                                                   mapScaleDelta += field964;
                                                }
                                             }

                                             if(mapScale < -60) {
                                                mapOffset = 2;
                                             }

                                             if(mapScale > 60) {
                                                mapOffset = -2;
                                             }

                                             if(mapScaleDelta < -20) {
                                                field964 = 1;
                                             }

                                             if(mapScaleDelta > 10) {
                                                field964 = -1;
                                             }

                                             for(class67 var37 = (class67)field1128.method3690(); var37 != null; var37 = (class67)field1128.method3691()) {
                                                if((long)var37.field808 < class226.method4147() / 1000L - 5L) {
                                                   if(var37.field806 > 0) {
                                                      GameObject.sendGameMessage(5, "", var37.field807 + " has logged in.");
                                                   }

                                                   if(var37.field806 == 0) {
                                                      GameObject.sendGameMessage(5, "", var37.field807 + " has logged out.");
                                                   }

                                                   var37.method3699();
                                                }
                                             }

                                             ++field938;
                                             if(field938 > 50) {
                                                secretPacketBuffer1.putOpcode(103);
                                             }

                                             try {
                                                if(XGrandExchangeOffer.rssocket != null && secretPacketBuffer1.offset > 0) {
                                                   XGrandExchangeOffer.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
                                                   secretPacketBuffer1.offset = 0;
                                                   field938 = 0;
                                                }
                                             } catch (IOException var23) {
                                                if(field986 > 0) {
                                                   class84.method1695();
                                                } else {
                                                   class12.setGameState(40);
                                                   class98.field1523 = XGrandExchangeOffer.rssocket;
                                                   XGrandExchangeOffer.rssocket = null;
                                                }
                                             }

                                             return;
                                          }

                                          var33 = var35.field816;
                                          if(var33.index < 0) {
                                             break;
                                          }

                                          var34 = class261.method4792(var33.parentId);
                                       } while(var34 == null || var34.children == null || var33.index >= var34.children.length || var34.children[var33.index] != var33);

                                       GroundObject.method2522(var35);
                                    }
                                 }

                                 var33 = var35.field816;
                                 if(var33.index < 0) {
                                    break;
                                 }

                                 var34 = class261.method4792(var33.parentId);
                              } while(var34 == null || var34.children == null || var33.index >= var34.children.length || var33 != var34.children[var33.index]);

                              GroundObject.method2522(var35);
                           }
                        }

                        var33 = var35.field816;
                        if(var33.index < 0) {
                           break;
                        }

                        var34 = class261.method4792(var33.parentId);
                     } while(var34 == null || var34.children == null || var33.index >= var34.children.length || var34.children[var33.index] != var33);

                     GroundObject.method2522(var35);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1799907327"
   )
   void method1181() {
      int var1 = class261.field3626;
      int var2 = class19.field320;
      if(super.field692 < var1) {
         var1 = super.field692;
      }

      if(super.field686 < var2) {
         var2 = super.field686;
      }

      if(class134.field1989 != null) {
         try {
            Client var3 = class24.field356;
            Object[] var4 = new Object[]{Integer.valueOf(class4.method8())};
            JSObject.getWindow(var3).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1026351327"
   )
   final void method1182() {
      if(widgetRoot != -1) {
         class252.method4506(widgetRoot);
      }

      int var1;
      for(var1 = 0; var1 < field1093; ++var1) {
         if(field1095[var1]) {
            field1096[var1] = true;
         }

         field1097[var1] = field1095[var1];
         field1095[var1] = false;
      }

      field1094 = gameCycle;
      field1143 = -1;
      field1040 = -1;
      class61.field747 = null;
      if(widgetRoot != -1) {
         field1093 = 0;
         class13.method66(widgetRoot, 0, 0, class261.field3626, class19.field320, 0, 0, -1);
      }

      Rasterizer2D.method5009();
      int var2;
      int var3;
      if(!isMenuOpen) {
         if(field1143 != -1) {
            var1 = field1143;
            var2 = field1040;
            if(menuOptionCount >= 2 || field1043 != 0 || field1045) {
               var3 = class84.method1694();
               String var4;
               if(field1043 == 1 && menuOptionCount < 2) {
                  var4 = "Use" + " " + field1142 + " " + "->";
               } else if(field1045 && menuOptionCount < 2) {
                  var4 = field1048 + " " + field1049 + " " + "->";
               } else {
                  var4 = class46.method677(var3);
               }

               if(menuOptionCount > 2) {
                  var4 = var4 + class82.method1610(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               class40.field531.method4822(var4, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         var1 = class152.menuX;
         var2 = class287.menuY;
         var3 = Varbit.menuHeight;
         int var11 = FileOnDisk.field1751;
         int var5 = 6116423;
         Rasterizer2D.method5042(var1, var2, var3, var11, var5);
         Rasterizer2D.method5042(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.method5012(var1 + 1, var2 + 18, var3 - 2, var11 - 19, 0);
         class40.field531.method4889("Choose Option", var1 + 3, var2 + 14, var5, -1);
         int var6 = class59.field721;
         int var7 = class59.field722;

         for(int var8 = 0; var8 < menuOptionCount; ++var8) {
            int var9 = var2 + 31 + (menuOptionCount - 1 - var8) * 15;
            int var10 = 16777215;
            if(var6 > var1 && var6 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
               var10 = 16776960;
            }

            class40.field531.method4889(class46.method677(var8), var1 + 3, var9, var10, 0);
         }

         ChatLineBuffer.method1903(class152.menuX, class287.menuY, Varbit.menuHeight, FileOnDisk.field1751);
      }

      if(field1102 == 3) {
         for(var1 = 0; var1 < field1093; ++var1) {
            if(field1097[var1]) {
               Rasterizer2D.method5048(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1096[var1]) {
               Rasterizer2D.method5048(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      class166.method3131(Sequence.plane, XGrandExchangeOffer.localPlayer.x, XGrandExchangeOffer.localPlayer.y, field966);
      field966 = 0;
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "651451389"
   )
   final boolean method1188() {
      if(XGrandExchangeOffer.rssocket == null) {
         return false;
      } else {
         String var2;
         int var3;
         try {
            int var1 = XGrandExchangeOffer.rssocket.available();
            if(var1 == 0) {
               return false;
            }

            if(field936 == -1) {
               XGrandExchangeOffer.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               field936 = secretPacketBuffer2.readOpcode();
               packetLength = class272.field3685[field936];
               --var1;
            }

            if(packetLength == -1) {
               if(var1 <= 0) {
                  return false;
               }

               XGrandExchangeOffer.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               packetLength = secretPacketBuffer2.payload[0] & 255;
               --var1;
            }

            if(packetLength == -2) {
               if(var1 <= 1) {
                  return false;
               }

               XGrandExchangeOffer.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();
               var1 -= 2;
            }

            if(var1 < packetLength) {
               return false;
            }

            secretPacketBuffer2.offset = 0;
            XGrandExchangeOffer.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
            field937 = 0;
            field978 = field1070;
            field1070 = field1164;
            field1164 = field936;
            int var4;
            int var5;
            int var6;
            Player var7;
            int var8;
            byte var9;
            int var10;
            byte[] var11;
            Buffer var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            String var20;
            PacketBuffer var56;
            class230 var68;
            byte var71;
            boolean var73;
            boolean var75;
            if(field936 == 58) {
               var56 = secretPacketBuffer2;
               var3 = packetLength;
               var4 = var56.offset;
               class96.field1487 = 0;
               ScriptState.method1079(var56);

               for(var5 = 0; var5 < class96.field1487; ++var5) {
                  var6 = class96.field1495[var5];
                  var7 = cachedPlayers[var6];
                  var8 = var56.readUnsignedByte();
                  if((var8 & 4) != 0) {
                     var8 += var56.readUnsignedByte() << 8;
                  }

                  var9 = -1;
                  if((var8 & 32) != 0) {
                     var10 = var56.readUnsignedByte();
                     var11 = new byte[var10];
                     var12 = new Buffer(var11);
                     var56.readBytes(var11, 0, var10);
                     class96.field1486[var6] = var12;
                     var7.method1142(var12);
                  }

                  if((var8 & 64) != 0) {
                     var10 = var56.readUnsignedShort();
                     if(var10 == '\uffff') {
                        var10 = -1;
                     }

                     var18 = var56.readUnsignedByte();
                     class44.method644(var7, var10, var18);
                  }

                  if((var8 & 16) != 0) {
                     var7.interacting = var56.readUnsignedShort();
                     if(var7.interacting == '\uffff') {
                        var7.interacting = -1;
                     }
                  }

                  if((var8 & 8) != 0) {
                     var7.overhead = var56.readString();
                     if(var7.overhead.charAt(0) == 126) {
                        var7.overhead = var7.overhead.substring(1);
                        GameObject.sendGameMessage(2, var7.name, var7.overhead);
                     } else if(var7 == XGrandExchangeOffer.localPlayer) {
                        GameObject.sendGameMessage(2, var7.name, var7.overhead);
                     }

                     var7.field1212 = false;
                     var7.field1215 = 0;
                     var7.field1216 = 0;
                     var7.field1214 = 150;
                  }

                  if((var8 & 2) != 0) {
                     var10 = var56.readUnsignedByte();
                     if(var10 > 0) {
                        for(var18 = 0; var18 < var10; ++var18) {
                           var13 = -1;
                           var14 = -1;
                           var15 = -1;
                           var19 = var56.method3212();
                           if(var19 == 32767) {
                              var19 = var56.method3212();
                              var14 = var56.method3212();
                              var13 = var56.method3212();
                              var15 = var56.method3212();
                           } else if(var19 != 32766) {
                              var14 = var56.method3212();
                           } else {
                              var19 = -1;
                           }

                           var16 = var56.method3212();
                           var7.method1525(var19, var14, var13, var15, gameCycle, var16);
                        }
                     }

                     var18 = var56.readUnsignedByte();
                     if(var18 > 0) {
                        for(var19 = 0; var19 < var18; ++var19) {
                           var13 = var56.method3212();
                           var14 = var56.method3212();
                           if(var14 != 32767) {
                              var15 = var56.method3212();
                              var16 = var56.readUnsignedByte();
                              var17 = var14 > 0?var56.readUnsignedByte():var16;
                              var7.method1526(var13, gameCycle, var14, var15, var16, var17);
                           } else {
                              var7.method1527(var13);
                           }
                        }
                     }
                  }

                  if((var8 & 1) != 0) {
                     var7.field1230 = var56.readUnsignedShort();
                     if(var7.field1252 == 0) {
                        var7.field1247 = var7.field1230;
                        var7.field1230 = -1;
                     }
                  }

                  if((var8 & 128) != 0) {
                     var10 = var56.readUnsignedShort();
                     var68 = (class230)method1381(WidgetNode.method1106(), var56.readUnsignedByte());
                     var75 = var56.readUnsignedByte() == 1;
                     var13 = var56.readUnsignedByte();
                     var14 = var56.offset;
                     if(var7.name != null && var7.composition != null) {
                        var73 = false;
                        if(var68.field3158 && class22.method153(var7.name)) {
                           var73 = true;
                        }

                        if(!var73 && field1014 == 0 && !var7.field867) {
                           class96.field1483.offset = 0;
                           var56.readBytes(class96.field1483.payload, 0, var13);
                           class96.field1483.offset = 0;
                           var20 = FontTypeFace.method4813(class219.method4131(ItemLayer.method2441(class96.field1483)));
                           var7.overhead = var20.trim();
                           var7.field1215 = var10 >> 8;
                           var7.field1216 = var10 & 255;
                           var7.field1214 = 150;
                           var7.field1212 = var75;
                           var7.inSequence = XGrandExchangeOffer.localPlayer != var7 && var68.field3158 && "" != field1108 && var20.toLowerCase().indexOf(field1108) == -1;
                           if(var68.field3161) {
                              var17 = var75?91:1;
                           } else {
                              var17 = var75?90:2;
                           }

                           if(var68.field3166 != -1) {
                              GameObject.sendGameMessage(var17, WidgetNode.method1104(var68.field3166) + var7.name, var20);
                           } else {
                              GameObject.sendGameMessage(var17, var7.name, var20);
                           }
                        }
                     }

                     var56.offset = var13 + var14;
                  }

                  if((var8 & 4096) != 0) {
                     var7.graphic = var56.readUnsignedShort();
                     var10 = var56.readInt();
                     var7.field1239 = var10 >> 16;
                     var7.field1206 = gameCycle + (var10 & '\uffff');
                     var7.field1228 = 0;
                     var7.field1237 = 0;
                     if(var7.field1206 > gameCycle) {
                        var7.field1228 = -1;
                     }

                     if(var7.graphic == '\uffff') {
                        var7.graphic = -1;
                     }
                  }

                  if((var8 & 1024) != 0) {
                     var7.field1198 = var56.readByte();
                     var7.field1242 = var56.readByte();
                     var7.field1225 = var56.readByte();
                     var7.field1243 = var56.readByte();
                     var7.field1244 = var56.readUnsignedShort() + gameCycle;
                     var7.field1224 = var56.readUnsignedShort() + gameCycle;
                     var7.field1201 = var56.readUnsignedShort();
                     if(var7.field876) {
                        var7.field1198 += var7.field877;
                        var7.field1242 += var7.field861;
                        var7.field1225 += var7.field877;
                        var7.field1243 += var7.field861;
                        var7.field1252 = 0;
                     } else {
                        var7.field1198 += var7.pathX[0];
                        var7.field1242 += var7.pathY[0];
                        var7.field1225 += var7.pathX[0];
                        var7.field1243 += var7.pathY[0];
                        var7.field1252 = 1;
                     }

                     var7.field1236 = 0;
                  }

                  if((var8 & 2048) != 0) {
                     class96.field1485[var6] = var56.readByte();
                  }

                  if((var8 & 256) != 0) {
                     var9 = var56.readByte();
                  }

                  if((var8 & 512) != 0) {
                     for(var10 = 0; var10 < 3; ++var10) {
                        var7.actions[var10] = var56.readString();
                     }
                  }

                  if(var7.field876) {
                     if(var9 == 127) {
                        var7.method1146(var7.field877, var7.field861);
                     } else {
                        if(var9 != -1) {
                           var71 = var9;
                        } else {
                           var71 = class96.field1485[var6];
                        }

                        var7.method1145(var7.field877, var7.field861, var71);
                     }
                  }
               }

               if(var3 != var56.offset - var4) {
                  throw new RuntimeException(var56.offset - var4 + " " + var3);
               }

               field936 = -1;
               return true;
            }

            int var21;
            if(field936 == 231) {
               var21 = secretPacketBuffer2.readUnsignedByte();
               var3 = secretPacketBuffer2.readUnsignedByte();
               var4 = secretPacketBuffer2.readUnsignedByte();
               var5 = secretPacketBuffer2.readUnsignedByte();
               field1138[var21] = true;
               field1139[var21] = var3;
               field1140[var21] = var4;
               field1141[var21] = var5;
               field1166[var21] = 0;
               field936 = -1;
               return true;
            }

            long var22;
            if(field936 == 152) {
               var21 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.method3245();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               var4 = secretPacketBuffer2.method3246();
               var5 = secretPacketBuffer2.method3236();
               if(var5 == '\uffff') {
                  var5 = -1;
               }

               for(var6 = var3; var6 <= var5; ++var6) {
                  var22 = (long)var6 + ((long)var4 << 32);
                  Node var76 = widgetFlags.method3615(var22);
                  if(var76 != null) {
                     var76.unlink();
                  }

                  widgetFlags.method3617(new class198(var21), var22);
               }

               field936 = -1;
               return true;
            }

            if(field936 == 188) {
               field1017 = secretPacketBuffer2.readUnsignedByte();
               field936 = -1;
               return true;
            }

            if(field936 == 16) {
               field929 = true;
               class90.field1399 = secretPacketBuffer2.readUnsignedByte();
               class73.field852 = secretPacketBuffer2.readUnsignedByte();
               Item.field1477 = secretPacketBuffer2.readUnsignedShort();
               class41.field547 = secretPacketBuffer2.readUnsignedByte();
               class27.field391 = secretPacketBuffer2.readUnsignedByte();
               if(class27.field391 >= 100) {
                  class12.cameraX = class90.field1399 * 128 + 64;
                  class12.cameraY = class73.field852 * 128 + 64;
                  class40.cameraZ = Ignore.method1119(class12.cameraX, class12.cameraY, Sequence.plane) - Item.field1477;
               }

               field936 = -1;
               return true;
            }

            if(field936 == 122) {
               field906 = secretPacketBuffer2.method3189() * 30;
               field1053 = field1075;
               field936 = -1;
               return true;
            }

            if(field936 == 124) {
               class18.method132();
               weight = secretPacketBuffer2.readShort();
               field1053 = field1075;
               field936 = -1;
               return true;
            }

            boolean var72;
            String var84;
            if(field936 == 43) {
               while(secretPacketBuffer2.offset < packetLength) {
                  var21 = secretPacketBuffer2.readUnsignedByte();
                  var72 = (var21 & 1) == 1;
                  var84 = secretPacketBuffer2.readString();
                  String var88 = secretPacketBuffer2.readString();
                  secretPacketBuffer2.readString();

                  for(var6 = 0; var6 < ignoreCount; ++var6) {
                     Ignore var61 = ignores[var6];
                     if(var72) {
                        if(var88.equals(var61.name)) {
                           var61.name = var84;
                           var61.previousName = var88;
                           var84 = null;
                           break;
                        }
                     } else if(var84.equals(var61.name)) {
                        var61.name = var84;
                        var61.previousName = var88;
                        var84 = null;
                        break;
                     }
                  }

                  if(var84 != null && ignoreCount < 400) {
                     Ignore var89 = new Ignore();
                     ignores[ignoreCount] = var89;
                     var89.name = var84;
                     var89.previousName = var88;
                     ++ignoreCount;
                  }
               }

               field1083 = field1075;
               field936 = -1;
               return true;
            }

            if(field936 == 243) {
               for(var21 = 0; var21 < cachedPlayers.length; ++var21) {
                  if(cachedPlayers[var21] != null) {
                     cachedPlayers[var21].animation = -1;
                  }
               }

               for(var21 = 0; var21 < cachedNPCs.length; ++var21) {
                  if(cachedNPCs[var21] != null) {
                     cachedNPCs[var21].animation = -1;
                  }
               }

               field936 = -1;
               return true;
            }

            if(field936 == 191 || field936 == 178 || field936 == 193 || field936 == 239 || field936 == 130 || field936 == 94 || field936 == 103 || field936 == 19 || field936 == 74 || field936 == 143) {
               class96.method1809();
               field936 = -1;
               return true;
            }

            if(field936 == 61) {
               secretPacketBuffer2.offset += 28;
               if(secretPacketBuffer2.method3233()) {
                  var56 = secretPacketBuffer2;
                  var3 = secretPacketBuffer2.offset - 28;
                  class84.method1696(var56.payload, var3);
                  class98.method1866(var56, var3);
               }

               field936 = -1;
               return true;
            }

            if(field936 == 250) {
               PlayerComposition.method4039(secretPacketBuffer2.readString());
               field936 = -1;
               return true;
            }

            if(field936 == 23) {
               var21 = secretPacketBuffer2.readUnsignedShort();
               XItemContainer var98 = (XItemContainer)XItemContainer.itemContainers.method3615((long)var21);
               if(var98 != null) {
                  var98.unlink();
               }

               field1051[++field1079 - 1 & 31] = var21 & 32767;
               field936 = -1;
               return true;
            }

            WidgetNode var26;
            int var29;
            Widget var81;
            if(field936 == 179) {
               var21 = secretPacketBuffer2.method3246();
               var3 = secretPacketBuffer2.method3246();
               WidgetNode var96 = (WidgetNode)componentTable.method3615((long)var21);
               var26 = (WidgetNode)componentTable.method3615((long)var3);
               if(var26 != null) {
                  class276.method4969(var26, var96 == null || var96.id != var26.id);
               }

               if(var96 != null) {
                  var96.unlink();
                  componentTable.method3617(var96, (long)var3);
               }

               var81 = class261.method4792(var21);
               if(var81 != null) {
                  class219.method4130(var81);
               }

               var81 = class261.method4792(var3);
               if(var81 != null) {
                  class219.method4130(var81);
                  class24.method176(class90.widgets[var81.id >>> 16], var81, true);
               }

               if(widgetRoot != -1) {
                  var29 = widgetRoot;
                  if(class14.method75(var29)) {
                     ChatLineBuffer.method1907(class90.widgets[var29], 1);
                  }
               }

               field936 = -1;
               return true;
            }

            if(field936 == 251) {
               flagX = secretPacketBuffer2.readUnsignedByte();
               if(flagX == 255) {
                  flagX = 0;
               }

               flagY = secretPacketBuffer2.readUnsignedByte();
               if(flagY == 255) {
                  flagY = 0;
               }

               field936 = -1;
               return true;
            }

            Widget var78;
            if(field936 == 73) {
               var21 = secretPacketBuffer2.method3245();
               var3 = secretPacketBuffer2.method3189();
               var4 = secretPacketBuffer2.method3246();
               var78 = class261.method4792(var4);
               var78.field2698 = var21 + (var3 << 16);
               field936 = -1;
               return true;
            }

            Widget var25;
            if(field936 == 207) {
               var21 = secretPacketBuffer2.method3236();
               var3 = secretPacketBuffer2.method3310();
               var25 = class261.method4792(var3);
               if(var25.modelType != 2 || var21 != var25.modelId) {
                  var25.modelType = 2;
                  var25.modelId = var21;
                  class219.method4130(var25);
               }

               field936 = -1;
               return true;
            }

            if(field936 == 209) {
               for(var21 = 0; var21 < class168.field2316; ++var21) {
                  class241 var97 = XItemContainer.method1091(var21);
                  if(var97 != null) {
                     class211.settings[var21] = 0;
                     class211.widgetSettings[var21] = 0;
                  }
               }

               class18.method132();
               field1145 += 32;
               field936 = -1;
               return true;
            }

            if(field936 == 156) {
               class242.field3277 = secretPacketBuffer2.method3227();
               GroundObject.field1858 = secretPacketBuffer2.method3260();

               for(var21 = GroundObject.field1858; var21 < GroundObject.field1858 + 8; ++var21) {
                  for(var3 = class242.field3277; var3 < class242.field3277 + 8; ++var3) {
                     if(groundItemDeque[Sequence.plane][var21][var3] != null) {
                        groundItemDeque[Sequence.plane][var21][var3] = null;
                        class37.groundItemSpawned(var21, var3);
                     }
                  }
               }

               for(class76 var55 = (class76)field1021.method3660(); var55 != null; var55 = (class76)field1021.method3661()) {
                  if(var55.field1176 >= GroundObject.field1858 && var55.field1176 < GroundObject.field1858 + 8 && var55.field1177 >= class242.field3277 && var55.field1177 < class242.field3277 + 8 && var55.field1174 == Sequence.plane) {
                     var55.field1185 = 0;
                  }
               }

               field936 = -1;
               return true;
            }

            if(field936 == 128) {
               class18.method132();
               var21 = secretPacketBuffer2.method3310();
               var3 = secretPacketBuffer2.method3227();
               var4 = secretPacketBuffer2.readUnsignedByte();
               skillExperiences[var4] = var21;
               boostedSkillLevels[var4] = var3;
               realSkillLevels[var4] = 1;

               for(var5 = 0; var5 < 98; ++var5) {
                  if(var21 >= class222.field2832[var5]) {
                     realSkillLevels[var4] = var5 + 2;
                  }
               }

               field1080[++field1081 - 1 & 31] = var4;
               field936 = -1;
               return true;
            }

            if(field936 == 135) {
               var21 = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.readUnsignedByte();
               var4 = secretPacketBuffer2.readUnsignedShort();
               if(field1129 != 0 && var3 != 0 && field1131 < 50) {
                  field1132[field1131] = var21;
                  field1009[field1131] = var3;
                  field1134[field1131] = var4;
                  field1136[field1131] = null;
                  field1135[field1131] = 0;
                  ++field1131;
               }

               field936 = -1;
               return true;
            }

            if(field936 == 14) {
               var21 = secretPacketBuffer2.method3239();
               var3 = secretPacketBuffer2.method3240();
               var4 = secretPacketBuffer2.readInt();
               var78 = class261.method4792(var4);
               if(var21 != var78.originalX || var3 != var78.originalY || var78.field2647 != 0 || var78.field2648 != 0) {
                  var78.originalX = var21;
                  var78.originalY = var3;
                  var78.field2647 = 0;
                  var78.field2648 = 0;
                  class219.method4130(var78);
                  this.method1192(var78);
                  if(var78.type == 0) {
                     class24.method176(class90.widgets[var4 >> 16], var78, false);
                  }
               }

               field936 = -1;
               return true;
            }

            if(field936 == 22) {
               var3 = secretPacketBuffer2.readUnsignedByte();
               class276[] var95 = new class276[]{class276.field3724, class276.field3725, class276.field3726};
               class276[] var80 = var95;
               var6 = 0;

               class276 var54;
               while(true) {
                  if(var6 >= var80.length) {
                     var54 = null;
                     break;
                  }

                  class276 var60 = var80[var6];
                  if(var60.field3727 == var3) {
                     var54 = var60;
                     break;
                  }

                  ++var6;
               }

               MessageNode.field844 = var54;
               field936 = -1;
               return true;
            }

            if(field936 == 18) {
               class18.method132();
               energy = secretPacketBuffer2.readUnsignedByte();
               field1053 = field1075;
               field936 = -1;
               return true;
            }

            if(field936 == 160) {
               if(widgetRoot != -1) {
                  var21 = widgetRoot;
                  if(class14.method75(var21)) {
                     ChatLineBuffer.method1907(class90.widgets[var21], 0);
                  }
               }

               field936 = -1;
               return true;
            }

            String var28;
            if(field936 == 218) {
               var21 = secretPacketBuffer2.method3227();
               var28 = secretPacketBuffer2.readString();
               var4 = secretPacketBuffer2.method3227();
               if(var21 >= 1 && var21 <= 8) {
                  if(var28.equalsIgnoreCase("null")) {
                     var28 = null;
                  }

                  playerOptions[var21 - 1] = var28;
                  playerOptionsPriorities[var21 - 1] = var4 == 0;
               }

               field936 = -1;
               return true;
            }

            if(field936 == 113) {
               var21 = secretPacketBuffer2.readUnsignedByte();
               if(secretPacketBuffer2.readUnsignedByte() == 0) {
                  field1165[var21] = new XGrandExchangeOffer();
                  secretPacketBuffer2.offset += 18;
               } else {
                  --secretPacketBuffer2.offset;
                  field1165[var21] = new XGrandExchangeOffer(secretPacketBuffer2, false);
               }

               field1085 = field1075;
               field936 = -1;
               return true;
            }

            long var34;
            if(field936 == 235) {
               var21 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.readInt();
               if(class23.field355 == null || !class23.field355.isValid()) {
                  try {
                     Iterator var94 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var94.hasNext()) {
                        GarbageCollectorMXBean var79 = (GarbageCollectorMXBean)var94.next();
                        if(var79.isValid()) {
                           class23.field355 = var79;
                           field1167 = -1L;
                           field945 = -1L;
                        }
                     }
                  } catch (Throwable var50) {
                     ;
                  }
               }

               long var30 = class226.method4147();
               var6 = -1;
               if(class23.field355 != null) {
                  var22 = class23.field355.getCollectionTime();
                  if(field945 != -1L) {
                     long var32 = var22 - field945;
                     var34 = var30 - field1167;
                     if(0L != var34) {
                        var6 = (int)(100L * var32 / var34);
                     }
                  }

                  field945 = var22;
                  field1167 = var30;
               }

               secretPacketBuffer1.putOpcode(24);
               secretPacketBuffer1.putByte(var6);
               secretPacketBuffer1.method3223(GameEngine.FPS);
               secretPacketBuffer1.method3242(var21);
               secretPacketBuffer1.putInt(var3);
               field936 = -1;
               return true;
            }

            boolean var90;
            if(field936 == 237) {
               var90 = secretPacketBuffer2.readUnsignedByte() == 1;
               var3 = secretPacketBuffer2.method3222();
               var25 = class261.method4792(var3);
               if(var90 != var25.isHidden) {
                  var25.isHidden = var90;
                  class219.method4130(var25);
               }

               field936 = -1;
               return true;
            }

            if(field936 == 248) {
               var21 = secretPacketBuffer2.readInt();
               WidgetNode var93 = (WidgetNode)componentTable.method3615((long)var21);
               if(var93 != null) {
                  class276.method4969(var93, true);
               }

               if(field1054 != null) {
                  class219.method4130(field1054);
                  field1054 = null;
               }

               field936 = -1;
               return true;
            }

            long var38;
            long var40;
            int var64;
            boolean var66;
            if(field936 == 234) {
               field1126 = field1075;
               if(packetLength == 0) {
                  field1115 = null;
                  clanChatOwner = null;
                  class48.clanChatCount = 0;
                  ClassInfo.clanMembers = null;
                  field936 = -1;
                  return true;
               }

               clanChatOwner = secretPacketBuffer2.readString();
               long var36 = secretPacketBuffer2.readLong();
               var38 = var36;
               if(var36 > 0L && var36 < 6582952005840035281L) {
                  if(var36 % 37L == 0L) {
                     var84 = null;
                  } else {
                     var29 = 0;

                     for(var40 = var36; var40 != 0L; var40 /= 37L) {
                        ++var29;
                     }

                     StringBuilder var99 = new StringBuilder(var29);

                     while(var38 != 0L) {
                        var34 = var38;
                        var38 /= 37L;
                        var99.append(class268.field3669[(int)(var34 - 37L * var38)]);
                     }

                     var84 = var99.reverse().toString();
                  }
               } else {
                  var84 = null;
               }

               field1115 = var84;
               class27.field401 = secretPacketBuffer2.readByte();
               var29 = secretPacketBuffer2.readUnsignedByte();
               if(var29 == 255) {
                  field936 = -1;
                  return true;
               }

               class48.clanChatCount = var29;
               XClanMember[] var103 = new XClanMember[100];

               for(var64 = 0; var64 < class48.clanChatCount; ++var64) {
                  var103[var64] = new XClanMember();
                  var103[var64].username = secretPacketBuffer2.readString();
                  var103[var64].field887 = class27.method214(var103[var64].username, class30.field423);
                  var103[var64].world = secretPacketBuffer2.readUnsignedShort();
                  var103[var64].rank = secretPacketBuffer2.readByte();
                  secretPacketBuffer2.readString();
                  if(var103[var64].username.equals(XGrandExchangeOffer.localPlayer.name)) {
                     class29.field418 = var103[var64].rank;
                  }
               }

               var66 = false;
               var18 = class48.clanChatCount;

               while(var18 > 0) {
                  var66 = true;
                  --var18;

                  for(var19 = 0; var19 < var18; ++var19) {
                     if(var103[var19].field887.compareTo(var103[var19 + 1].field887) > 0) {
                        XClanMember var100 = var103[var19];
                        var103[var19] = var103[var19 + 1];
                        var103[var19 + 1] = var100;
                        var66 = false;
                     }
                  }

                  if(var66) {
                     break;
                  }
               }

               ClassInfo.clanMembers = var103;
               field936 = -1;
               return true;
            }

            if(field936 == 225) {
               class242.field3277 = secretPacketBuffer2.method3227();
               GroundObject.field1858 = secretPacketBuffer2.readUnsignedByte();

               while(secretPacketBuffer2.offset < packetLength) {
                  field936 = secretPacketBuffer2.readUnsignedByte();
                  class96.method1809();
               }

               field936 = -1;
               return true;
            }

            if(field936 == 177) {
               class162.method3106(false);
               field936 = -1;
               return true;
            }

            long var44;
            if(field936 == 166) {
               var2 = secretPacketBuffer2.readString();
               var44 = (long)secretPacketBuffer2.readUnsignedShort();
               var38 = (long)secretPacketBuffer2.read24BitInt();
               class230 var58 = (class230)method1381(WidgetNode.method1106(), secretPacketBuffer2.readUnsignedByte());
               var40 = var38 + (var44 << 32);
               boolean var74 = false;

               for(var18 = 0; var18 < 100; ++var18) {
                  if(var40 == field1137[var18]) {
                     var74 = true;
                     break;
                  }
               }

               if(class22.method153(var2)) {
                  var74 = true;
               }

               if(!var74 && field1014 == 0) {
                  field1137[field1110] = var40;
                  field1110 = (field1110 + 1) % 100;
                  String var70 = FontTypeFace.method4813(class219.method4131(ItemLayer.method2441(secretPacketBuffer2)));
                  byte var77;
                  if(var58.field3161) {
                     var77 = 7;
                  } else {
                     var77 = 3;
                  }

                  if(var58.field3166 != -1) {
                     GameObject.sendGameMessage(var77, WidgetNode.method1104(var58.field3166) + var2, var70);
                  } else {
                     GameObject.sendGameMessage(var77, var2, var70);
                  }
               }

               field936 = -1;
               return true;
            }

            if(field936 == 26) {
               var2 = secretPacketBuffer2.readString();
               Object[] var92 = new Object[var2.length() + 1];

               for(var4 = var2.length() - 1; var4 >= 0; --var4) {
                  if(var2.charAt(var4) == 115) {
                     var92[var4 + 1] = secretPacketBuffer2.readString();
                  } else {
                     var92[var4 + 1] = new Integer(secretPacketBuffer2.readInt());
                  }
               }

               var92[0] = new Integer(secretPacketBuffer2.readInt());
               class69 var91 = new class69();
               var91.field826 = var92;
               GroundObject.method2522(var91);
               field936 = -1;
               return true;
            }

            if(field936 == 141) {
               field929 = false;

               for(var21 = 0; var21 < 5; ++var21) {
                  field1138[var21] = false;
               }

               field936 = -1;
               return true;
            }

            if(field936 == 36) {
               var90 = secretPacketBuffer2.readUnsignedByte() == 1;
               if(var90) {
                  class6.field227 = class226.method4147() - secretPacketBuffer2.readLong();
                  class176.field2402 = new class13(secretPacketBuffer2, true);
               } else {
                  class176.field2402 = null;
               }

               field1086 = field1075;
               field936 = -1;
               return true;
            }

            if(field936 == 202) {
               class84.method1695();
               field936 = -1;
               return false;
            }

            if(field936 == 13) {
               var21 = secretPacketBuffer2.method3245();
               var3 = secretPacketBuffer2.method3246();
               var25 = class261.method4792(var3);
               if(var25.modelType != 1 || var25.modelId != var21) {
                  var25.modelType = 1;
                  var25.modelId = var21;
                  class219.method4130(var25);
               }

               field936 = -1;
               return true;
            }

            if(field936 == 38) {
               GroundObject.field1858 = secretPacketBuffer2.method3227();
               class242.field3277 = secretPacketBuffer2.method3260();
               field936 = -1;
               return true;
            }

            PacketBuffer var85;
            if(field936 == 20) {
               class60.xteaChanged(true);
               secretPacketBuffer2.readOpcode();
               var21 = secretPacketBuffer2.readUnsignedShort();
               var85 = secretPacketBuffer2;
               var4 = var85.offset;
               class96.field1487 = 0;
               ScriptState.method1079(var85);

               for(var5 = 0; var5 < class96.field1487; ++var5) {
                  var6 = class96.field1495[var5];
                  var7 = cachedPlayers[var6];
                  var8 = var85.readUnsignedByte();
                  if((var8 & 4) != 0) {
                     var8 += var85.readUnsignedByte() << 8;
                  }

                  var9 = -1;
                  if((var8 & 32) != 0) {
                     var10 = var85.readUnsignedByte();
                     var11 = new byte[var10];
                     var12 = new Buffer(var11);
                     var85.readBytes(var11, 0, var10);
                     class96.field1486[var6] = var12;
                     var7.method1142(var12);
                  }

                  if((var8 & 64) != 0) {
                     var10 = var85.readUnsignedShort();
                     if(var10 == '\uffff') {
                        var10 = -1;
                     }

                     var18 = var85.readUnsignedByte();
                     class44.method644(var7, var10, var18);
                  }

                  if((var8 & 16) != 0) {
                     var7.interacting = var85.readUnsignedShort();
                     if(var7.interacting == '\uffff') {
                        var7.interacting = -1;
                     }
                  }

                  if((var8 & 8) != 0) {
                     var7.overhead = var85.readString();
                     if(var7.overhead.charAt(0) == 126) {
                        var7.overhead = var7.overhead.substring(1);
                        GameObject.sendGameMessage(2, var7.name, var7.overhead);
                     } else if(XGrandExchangeOffer.localPlayer == var7) {
                        GameObject.sendGameMessage(2, var7.name, var7.overhead);
                     }

                     var7.field1212 = false;
                     var7.field1215 = 0;
                     var7.field1216 = 0;
                     var7.field1214 = 150;
                  }

                  if((var8 & 2) != 0) {
                     var10 = var85.readUnsignedByte();
                     if(var10 > 0) {
                        for(var18 = 0; var18 < var10; ++var18) {
                           var13 = -1;
                           var14 = -1;
                           var15 = -1;
                           var19 = var85.method3212();
                           if(var19 == 32767) {
                              var19 = var85.method3212();
                              var14 = var85.method3212();
                              var13 = var85.method3212();
                              var15 = var85.method3212();
                           } else if(var19 != 32766) {
                              var14 = var85.method3212();
                           } else {
                              var19 = -1;
                           }

                           var16 = var85.method3212();
                           var7.method1525(var19, var14, var13, var15, gameCycle, var16);
                        }
                     }

                     var18 = var85.readUnsignedByte();
                     if(var18 > 0) {
                        for(var19 = 0; var19 < var18; ++var19) {
                           var13 = var85.method3212();
                           var14 = var85.method3212();
                           if(var14 != 32767) {
                              var15 = var85.method3212();
                              var16 = var85.readUnsignedByte();
                              var17 = var14 > 0?var85.readUnsignedByte():var16;
                              var7.method1526(var13, gameCycle, var14, var15, var16, var17);
                           } else {
                              var7.method1527(var13);
                           }
                        }
                     }
                  }

                  if((var8 & 1) != 0) {
                     var7.field1230 = var85.readUnsignedShort();
                     if(var7.field1252 == 0) {
                        var7.field1247 = var7.field1230;
                        var7.field1230 = -1;
                     }
                  }

                  if((var8 & 128) != 0) {
                     var10 = var85.readUnsignedShort();
                     var68 = (class230)method1381(WidgetNode.method1106(), var85.readUnsignedByte());
                     var75 = var85.readUnsignedByte() == 1;
                     var13 = var85.readUnsignedByte();
                     var14 = var85.offset;
                     if(var7.name != null && var7.composition != null) {
                        var73 = false;
                        if(var68.field3158 && class22.method153(var7.name)) {
                           var73 = true;
                        }

                        if(!var73 && field1014 == 0 && !var7.field867) {
                           class96.field1483.offset = 0;
                           var85.readBytes(class96.field1483.payload, 0, var13);
                           class96.field1483.offset = 0;
                           var20 = FontTypeFace.method4813(class219.method4131(ItemLayer.method2441(class96.field1483)));
                           var7.overhead = var20.trim();
                           var7.field1215 = var10 >> 8;
                           var7.field1216 = var10 & 255;
                           var7.field1214 = 150;
                           var7.field1212 = var75;
                           var7.inSequence = var7 != XGrandExchangeOffer.localPlayer && var68.field3158 && field1108 != "" && var20.toLowerCase().indexOf(field1108) == -1;
                           if(var68.field3161) {
                              var17 = var75?91:1;
                           } else {
                              var17 = var75?90:2;
                           }

                           if(var68.field3166 != -1) {
                              GameObject.sendGameMessage(var17, WidgetNode.method1104(var68.field3166) + var7.name, var20);
                           } else {
                              GameObject.sendGameMessage(var17, var7.name, var20);
                           }
                        }
                     }

                     var85.offset = var14 + var13;
                  }

                  if((var8 & 4096) != 0) {
                     var7.graphic = var85.readUnsignedShort();
                     var10 = var85.readInt();
                     var7.field1239 = var10 >> 16;
                     var7.field1206 = gameCycle + (var10 & '\uffff');
                     var7.field1228 = 0;
                     var7.field1237 = 0;
                     if(var7.field1206 > gameCycle) {
                        var7.field1228 = -1;
                     }

                     if(var7.graphic == '\uffff') {
                        var7.graphic = -1;
                     }
                  }

                  if((var8 & 1024) != 0) {
                     var7.field1198 = var85.readByte();
                     var7.field1242 = var85.readByte();
                     var7.field1225 = var85.readByte();
                     var7.field1243 = var85.readByte();
                     var7.field1244 = var85.readUnsignedShort() + gameCycle;
                     var7.field1224 = var85.readUnsignedShort() + gameCycle;
                     var7.field1201 = var85.readUnsignedShort();
                     if(var7.field876) {
                        var7.field1198 += var7.field877;
                        var7.field1242 += var7.field861;
                        var7.field1225 += var7.field877;
                        var7.field1243 += var7.field861;
                        var7.field1252 = 0;
                     } else {
                        var7.field1198 += var7.pathX[0];
                        var7.field1242 += var7.pathY[0];
                        var7.field1225 += var7.pathX[0];
                        var7.field1243 += var7.pathY[0];
                        var7.field1252 = 1;
                     }

                     var7.field1236 = 0;
                  }

                  if((var8 & 2048) != 0) {
                     class96.field1485[var6] = var85.readByte();
                  }

                  if((var8 & 256) != 0) {
                     var9 = var85.readByte();
                  }

                  if((var8 & 512) != 0) {
                     for(var10 = 0; var10 < 3; ++var10) {
                        var7.actions[var10] = var85.readString();
                     }
                  }

                  if(var7.field876) {
                     if(var9 == 127) {
                        var7.method1146(var7.field877, var7.field861);
                     } else {
                        if(var9 != -1) {
                           var71 = var9;
                        } else {
                           var71 = class96.field1485[var6];
                        }

                        var7.method1145(var7.field877, var7.field861, var71);
                     }
                  }
               }

               if(var21 != var85.offset - var4) {
                  throw new RuntimeException(var85.offset - var4 + " " + var21);
               }

               field936 = -1;
               return true;
            }

            boolean var63;
            if(field936 == 106) {
               var2 = secretPacketBuffer2.readString();
               var3 = secretPacketBuffer2.readUnsignedShort();
               byte var59 = secretPacketBuffer2.readByte();
               var63 = false;
               if(var59 == -128) {
                  var63 = true;
               }

               if(var63) {
                  if(class48.clanChatCount == 0) {
                     field936 = -1;
                     return true;
                  }

                  boolean var62 = false;

                  for(var6 = 0; var6 < class48.clanChatCount && (!ClassInfo.clanMembers[var6].username.equals(var2) || ClassInfo.clanMembers[var6].world != var3); ++var6) {
                     ;
                  }

                  if(var6 < class48.clanChatCount) {
                     while(var6 < class48.clanChatCount - 1) {
                        ClassInfo.clanMembers[var6] = ClassInfo.clanMembers[var6 + 1];
                        ++var6;
                     }

                     --class48.clanChatCount;
                     ClassInfo.clanMembers[class48.clanChatCount] = null;
                  }
               } else {
                  secretPacketBuffer2.readString();
                  XClanMember var86 = new XClanMember();
                  var86.username = var2;
                  var86.field887 = class27.method214(var86.username, class30.field423);
                  var86.world = var3;
                  var86.rank = var59;

                  for(var29 = class48.clanChatCount - 1; var29 >= 0; --var29) {
                     var8 = ClassInfo.clanMembers[var29].field887.compareTo(var86.field887);
                     if(var8 == 0) {
                        ClassInfo.clanMembers[var29].world = var3;
                        ClassInfo.clanMembers[var29].rank = var59;
                        if(var2.equals(XGrandExchangeOffer.localPlayer.name)) {
                           class29.field418 = var59;
                        }

                        field1126 = field1075;
                        field936 = -1;
                        return true;
                     }

                     if(var8 < 0) {
                        break;
                     }
                  }

                  if(class48.clanChatCount >= ClassInfo.clanMembers.length) {
                     field936 = -1;
                     return true;
                  }

                  for(var8 = class48.clanChatCount - 1; var8 > var29; --var8) {
                     ClassInfo.clanMembers[var8 + 1] = ClassInfo.clanMembers[var8];
                  }

                  if(class48.clanChatCount == 0) {
                     ClassInfo.clanMembers = new XClanMember[100];
                  }

                  ClassInfo.clanMembers[var29 + 1] = var86;
                  ++class48.clanChatCount;
                  if(var2.equals(XGrandExchangeOffer.localPlayer.name)) {
                     class29.field418 = var59;
                  }
               }

               field1126 = field1075;
               field936 = -1;
               return true;
            }

            if(field936 == 32) {
               var21 = secretPacketBuffer2.method3212();
               var72 = secretPacketBuffer2.readUnsignedByte() == 1;
               var84 = "";
               var63 = false;
               if(var72) {
                  var84 = secretPacketBuffer2.readString();
                  if(class22.method153(var84)) {
                     var63 = true;
                  }
               }

               String var83 = secretPacketBuffer2.readString();
               if(!var63) {
                  GameObject.sendGameMessage(var21, var84, var83);
               }

               field936 = -1;
               return true;
            }

            if(field936 == 119) {
               field929 = true;
               class15.field296 = secretPacketBuffer2.readUnsignedByte();
               class172.field2353 = secretPacketBuffer2.readUnsignedByte();
               class257.field3542 = secretPacketBuffer2.readUnsignedShort();
               class164.field2292 = secretPacketBuffer2.readUnsignedByte();
               ChatMessages.field1500 = secretPacketBuffer2.readUnsignedByte();
               if(ChatMessages.field1500 >= 100) {
                  var21 = class15.field296 * 128 + 64;
                  var3 = class172.field2353 * 128 + 64;
                  var4 = Ignore.method1119(var21, var3, Sequence.plane) - class257.field3542;
                  var5 = var21 - class12.cameraX;
                  var6 = var4 - class40.cameraZ;
                  var29 = var3 - class12.cameraY;
                  var8 = (int)Math.sqrt((double)(var29 * var29 + var5 * var5));
                  class36.cameraPitch = (int)(Math.atan2((double)var6, (double)var8) * 325.949D) & 2047;
                  class244.cameraYaw = (int)(Math.atan2((double)var5, (double)var29) * -325.949D) & 2047;
                  if(class36.cameraPitch < 128) {
                     class36.cameraPitch = 128;
                  }

                  if(class36.cameraPitch > 383) {
                     class36.cameraPitch = 383;
                  }
               }

               field936 = -1;
               return true;
            }

            Widget var87;
            if(field936 == 64) {
               var21 = secretPacketBuffer2.method3222();
               var87 = class261.method4792(var21);

               for(var4 = 0; var4 < var87.itemIds.length; ++var4) {
                  var87.itemIds[var4] = -1;
                  var87.itemIds[var4] = 0;
               }

               class219.method4130(var87);
               field936 = -1;
               return true;
            }

            if(field936 == 222) {
               var2 = secretPacketBuffer2.readString();
               var28 = FontTypeFace.method4813(class219.method4131(ItemLayer.method2441(secretPacketBuffer2)));
               GameObject.sendGameMessage(6, var2, var28);
               field936 = -1;
               return true;
            }

            if(field936 == 59) {
               while(secretPacketBuffer2.offset < packetLength) {
                  var90 = secretPacketBuffer2.readUnsignedByte() == 1;
                  var28 = secretPacketBuffer2.readString();
                  var84 = secretPacketBuffer2.readString();
                  var5 = secretPacketBuffer2.readUnsignedShort();
                  var6 = secretPacketBuffer2.readUnsignedByte();
                  var29 = secretPacketBuffer2.readUnsignedByte();
                  boolean var65 = (var29 & 2) != 0;
                  var66 = (var29 & 1) != 0;
                  if(var5 > 0) {
                     secretPacketBuffer2.readString();
                     secretPacketBuffer2.readUnsignedByte();
                     secretPacketBuffer2.readInt();
                  }

                  secretPacketBuffer2.readString();

                  for(var10 = 0; var10 < friendCount; ++var10) {
                     Friend var69 = friends[var10];
                     if(!var90) {
                        if(var28.equals(var69.name)) {
                           if(var69.world != var5) {
                              var75 = true;

                              for(class67 var104 = (class67)field1128.method3690(); var104 != null; var104 = (class67)field1128.method3691()) {
                                 if(var104.field807.equals(var28)) {
                                    if(var5 != 0 && var104.field806 == 0) {
                                       var104.method3699();
                                       var75 = false;
                                    } else if(var5 == 0 && var104.field806 != 0) {
                                       var104.method3699();
                                       var75 = false;
                                    }
                                 }
                              }

                              if(var75) {
                                 field1128.method3689(new class67(var28, var5));
                              }

                              var69.world = var5;
                           }

                           var69.previousName = var84;
                           var69.rank = var6;
                           var69.field797 = var65;
                           var69.field796 = var66;
                           var28 = null;
                           break;
                        }
                     } else if(var84.equals(var69.name)) {
                        var69.name = var28;
                        var69.previousName = var84;
                        var28 = null;
                        break;
                     }
                  }

                  if(var28 != null && friendCount < 400) {
                     Friend var42 = new Friend();
                     friends[friendCount] = var42;
                     var42.name = var28;
                     var42.previousName = var84;
                     var42.world = var5;
                     var42.rank = var6;
                     var42.field797 = var65;
                     var42.field796 = var66;
                     ++friendCount;
                  }
               }

               field939 = 2;
               field1083 = field1075;
               var90 = false;
               var3 = friendCount;

               while(var3 > 0) {
                  var90 = true;
                  --var3;

                  for(var4 = 0; var4 < var3; ++var4) {
                     var63 = false;
                     Friend var82 = friends[var4];
                     Friend var57 = friends[var4 + 1];
                     if(world != var82.world && world == var57.world) {
                        var63 = true;
                     }

                     if(!var63 && var82.world == 0 && var57.world != 0) {
                        var63 = true;
                     }

                     if(!var63 && !var82.field797 && var57.field797) {
                        var63 = true;
                     }

                     if(!var63 && !var82.field796 && var57.field796) {
                        var63 = true;
                     }

                     if(var63) {
                        Friend var102 = friends[var4];
                        friends[var4] = friends[var4 + 1];
                        friends[var4 + 1] = var102;
                        var90 = false;
                     }
                  }

                  if(var90) {
                     break;
                  }
               }

               field936 = -1;
               return true;
            }

            if(field936 == 229) {
               var21 = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.readUnsignedShort();
               var4 = secretPacketBuffer2.method3236();
               var5 = secretPacketBuffer2.readInt();
               var81 = class261.method4792(var5);
               if(var81.rotationX != var4 || var81.rotationZ != var21 || var81.field2696 != var3) {
                  var81.rotationX = var4;
                  var81.rotationZ = var21;
                  var81.field2696 = var3;
                  class219.method4130(var81);
               }

               field936 = -1;
               return true;
            }

            if(field936 == 167) {
               field907 = secretPacketBuffer2.readUnsignedByte();
               if(field907 == 1) {
                  field908 = secretPacketBuffer2.readUnsignedShort();
               }

               if(field907 >= 2 && field907 <= 6) {
                  if(field907 == 2) {
                     field913 = 64;
                     field1026 = 64;
                  }

                  if(field907 == 3) {
                     field913 = 0;
                     field1026 = 64;
                  }

                  if(field907 == 4) {
                     field913 = 128;
                     field1026 = 64;
                  }

                  if(field907 == 5) {
                     field913 = 64;
                     field1026 = 0;
                  }

                  if(field907 == 6) {
                     field913 = 64;
                     field1026 = 128;
                  }

                  field907 = 2;
                  field924 = secretPacketBuffer2.readUnsignedShort();
                  field911 = secretPacketBuffer2.readUnsignedShort();
                  field1133 = secretPacketBuffer2.readUnsignedByte();
               }

               if(field907 == 10) {
                  field909 = secretPacketBuffer2.readUnsignedShort();
               }

               field936 = -1;
               return true;
            }

            if(field936 == 15) {
               var21 = secretPacketBuffer2.method3222();
               var87 = class261.method4792(var21);
               var87.modelType = 3;
               var87.modelId = XGrandExchangeOffer.localPlayer.composition.method4032();
               class219.method4130(var87);
               field936 = -1;
               return true;
            }

            if(field936 == 107) {
               var21 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.readUnsignedShort();
               if(var21 < -70000) {
                  var3 += '耀';
               }

               if(var21 >= 0) {
                  var25 = class261.method4792(var21);
               } else {
                  var25 = null;
               }

               if(var25 != null) {
                  for(var5 = 0; var5 < var25.itemIds.length; ++var5) {
                     var25.itemIds[var5] = 0;
                     var25.itemQuantities[var5] = 0;
                  }
               }

               class34.method492(var3);
               var5 = secretPacketBuffer2.readUnsignedShort();

               for(var6 = 0; var6 < var5; ++var6) {
                  var29 = secretPacketBuffer2.method3245();
                  var8 = secretPacketBuffer2.method3305();
                  if(var8 == 255) {
                     var8 = secretPacketBuffer2.readInt();
                  }

                  if(var25 != null && var6 < var25.itemIds.length) {
                     var25.itemIds[var6] = var29;
                     var25.itemQuantities[var6] = var8;
                  }

                  class23.method160(var3, var6, var29 - 1, var8);
               }

               if(var25 != null) {
                  class219.method4130(var25);
               }

               class18.method132();
               field1051[++field1079 - 1 & 31] = var3 & 32767;
               field936 = -1;
               return true;
            }

            if(field936 == 42) {
               class240.method4347(secretPacketBuffer2, packetLength);
               field936 = -1;
               return true;
            }

            if(field936 == 217) {
               var21 = secretPacketBuffer2.method3189();
               byte var67 = secretPacketBuffer2.method3231();
               class211.settings[var21] = var67;
               if(class211.widgetSettings[var21] != var67) {
                  class211.widgetSettings[var21] = var67;
               }

               class45.method676(var21);
               field955[++field1145 - 1 & 31] = var21;
               field936 = -1;
               return true;
            }

            if(field936 == 147) {
               var21 = secretPacketBuffer2.method3310();
               class204.field2533 = GameEngine.field682.method2970(var21);
               field936 = -1;
               return true;
            }

            if(field936 == 63) {
               var21 = secretPacketBuffer2.method3310();
               var3 = secretPacketBuffer2.method3189();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               var4 = secretPacketBuffer2.method3310();
               var78 = class261.method4792(var4);
               ItemComposition var27;
               if(!var78.hasScript) {
                  if(var3 == -1) {
                     var78.modelType = 0;
                     field936 = -1;
                     return true;
                  }

                  var27 = class51.getItemDefinition(var3);
                  var78.modelType = 4;
                  var78.modelId = var3;
                  var78.rotationX = var27.xan2d;
                  var78.rotationZ = var27.yan2d;
                  var78.field2696 = var27.zoom2d * 100 / var21;
                  class219.method4130(var78);
               } else {
                  var78.itemId = var3;
                  var78.itemQuantity = var21;
                  var27 = class51.getItemDefinition(var3);
                  var78.rotationX = var27.xan2d;
                  var78.rotationZ = var27.yan2d;
                  var78.rotationY = var27.zan2d;
                  var78.field2752 = var27.offsetX2d;
                  var78.field2692 = var27.offsetY2d;
                  var78.field2696 = var27.zoom2d;
                  if(var27.isStackable == 1) {
                     var78.field2770 = 1;
                  } else {
                     var78.field2770 = 2;
                  }

                  if(var78.field2697 > 0) {
                     var78.field2696 = var78.field2696 * 32 / var78.field2697;
                  } else if(var78.originalWidth > 0) {
                     var78.field2696 = var78.field2696 * 32 / var78.originalWidth;
                  }

                  class219.method4130(var78);
               }

               field936 = -1;
               return true;
            }

            if(field936 == 2) {
               var21 = secretPacketBuffer2.method3310();
               var3 = secretPacketBuffer2.readUnsignedShort();
               class211.settings[var3] = var21;
               if(var21 != class211.widgetSettings[var3]) {
                  class211.widgetSettings[var3] = var21;
               }

               class45.method676(var3);
               field955[++field1145 - 1 & 31] = var3;
               field936 = -1;
               return true;
            }

            if(field936 == 149) {
               field939 = 1;
               field1083 = field1075;
               field936 = -1;
               return true;
            }

            if(field936 == 137) {
               field1099 = secretPacketBuffer2.readUnsignedByte();
               field1092 = secretPacketBuffer2.readUnsignedByte();
               field936 = -1;
               return true;
            }

            if(field936 == 185) {
               for(var21 = 0; var21 < class211.widgetSettings.length; ++var21) {
                  if(class211.widgetSettings[var21] != class211.settings[var21]) {
                     class211.widgetSettings[var21] = class211.settings[var21];
                     class45.method676(var21);
                     field955[++field1145 - 1 & 31] = var21;
                  }
               }

               field936 = -1;
               return true;
            }

            if(field936 == 252) {
               var21 = secretPacketBuffer2.method3189();
               if(var21 == '\uffff') {
                  var21 = -1;
               }

               if(var21 == -1 && !field1109) {
                  class36.field501.method3801();
                  class203.field2498 = 1;
                  Varbit.field3380 = null;
               } else if(var21 != -1 && field1127 != var21 && field1077 != 0 && !field1109) {
                  class13.method62(2, class44.indexTrack1, var21, 0, field1077, false);
               }

               field1127 = var21;
               field936 = -1;
               return true;
            }

            if(field936 == 96) {
               var21 = secretPacketBuffer2.method3236();
               if(var21 == '\uffff') {
                  var21 = -1;
               }

               var3 = secretPacketBuffer2.read24BitInt();
               if(field1077 != 0 && var21 != -1) {
                  class32.method322(class33.indexTrack2, var21, 0, field1077, false);
                  field1109 = true;
               }

               field936 = -1;
               return true;
            }

            if(field936 == 70) {
               var21 = secretPacketBuffer2.readUnsignedShort();
               widgetRoot = var21;
               this.method1170(false);
               class54.method789(var21);
               class17.method119(widgetRoot);

               for(var3 = 0; var3 < 100; ++var3) {
                  field1095[var3] = true;
               }

               field936 = -1;
               return true;
            }

            long var47;
            if(field936 == 56) {
               var2 = secretPacketBuffer2.readString();
               var44 = secretPacketBuffer2.readLong();
               var38 = (long)secretPacketBuffer2.readUnsignedShort();
               var22 = (long)secretPacketBuffer2.read24BitInt();
               class230 var24 = (class230)method1381(WidgetNode.method1106(), secretPacketBuffer2.readUnsignedByte());
               var47 = (var38 << 32) + var22;
               var75 = false;

               for(var13 = 0; var13 < 100; ++var13) {
                  if(var47 == field1137[var13]) {
                     var75 = true;
                     break;
                  }
               }

               if(var24.field3158 && class22.method153(var2)) {
                  var75 = true;
               }

               if(!var75 && field1014 == 0) {
                  field1137[field1110] = var47;
                  field1110 = (field1110 + 1) % 100;
                  String var46 = FontTypeFace.method4813(class219.method4131(ItemLayer.method2441(secretPacketBuffer2)));
                  if(var24.field3166 != -1) {
                     CombatInfoListHolder.addChatMessage(9, WidgetNode.method1104(var24.field3166) + var2, var46, class96.method1813(var44));
                  } else {
                     CombatInfoListHolder.addChatMessage(9, var2, var46, class96.method1813(var44));
                  }
               }

               field936 = -1;
               return true;
            }

            if(field936 == 44) {
               NPC.method1726();

               for(var21 = 0; var21 < 2048; ++var21) {
                  cachedPlayers[var21] = null;
               }

               class71.method1125(secretPacketBuffer2);
               field936 = -1;
               return true;
            }

            if(field936 == 123) {
               var21 = secretPacketBuffer2.method3222();
               var3 = secretPacketBuffer2.method3189();
               var25 = class261.method4792(var21);
               if(var25 != null && var25.type == 0) {
                  if(var3 > var25.scrollHeight - var25.height) {
                     var3 = var25.scrollHeight - var25.height;
                  }

                  if(var3 < 0) {
                     var3 = 0;
                  }

                  if(var3 != var25.scrollY) {
                     var25.scrollY = var3;
                     class219.method4130(var25);
                  }
               }

               field936 = -1;
               return true;
            }

            if(field936 == 87) {
               class162.method3106(true);
               field936 = -1;
               return true;
            }

            if(field936 == 198) {
               var21 = packetLength + secretPacketBuffer2.offset;
               var3 = secretPacketBuffer2.readUnsignedShort();
               var4 = secretPacketBuffer2.readUnsignedShort();
               if(widgetRoot != var3) {
                  widgetRoot = var3;
                  this.method1170(false);
                  class54.method789(widgetRoot);
                  class17.method119(widgetRoot);

                  for(var5 = 0; var5 < 100; ++var5) {
                     field1095[var5] = true;
                  }
               }

               WidgetNode var101;
               for(; var4-- > 0; var101.field811 = true) {
                  var5 = secretPacketBuffer2.readInt();
                  var6 = secretPacketBuffer2.readUnsignedShort();
                  var29 = secretPacketBuffer2.readUnsignedByte();
                  var101 = (WidgetNode)componentTable.method3615((long)var5);
                  if(var101 != null && var101.id != var6) {
                     class276.method4969(var101, true);
                     var101 = null;
                  }

                  if(var101 == null) {
                     var101 = class44.method649(var5, var6, var29);
                  }
               }

               for(var26 = (WidgetNode)componentTable.method3606(); var26 != null; var26 = (WidgetNode)componentTable.method3607()) {
                  if(var26.field811) {
                     var26.field811 = false;
                  } else {
                     class276.method4969(var26, true);
                  }
               }

               widgetFlags = new XHashTable(512);

               while(secretPacketBuffer2.offset < var21) {
                  var5 = secretPacketBuffer2.readInt();
                  var6 = secretPacketBuffer2.readUnsignedShort();
                  var29 = secretPacketBuffer2.readUnsignedShort();
                  var8 = secretPacketBuffer2.readInt();

                  for(var64 = var6; var64 <= var29; ++var64) {
                     var47 = (long)var64 + ((long)var5 << 32);
                     widgetFlags.method3617(new class198(var8), var47);
                  }
               }

               field936 = -1;
               return true;
            }

            if(field936 == 164) {
               World var53 = new World();
               var53.address = secretPacketBuffer2.readString();
               var53.id = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.readInt();
               var53.mask = var3;
               class12.setGameState(45);
               XGrandExchangeOffer.rssocket.method3048();
               XGrandExchangeOffer.rssocket = null;
               class87.method1738(var53);
               field936 = -1;
               return false;
            }

            if(field936 == 24) {
               var21 = secretPacketBuffer2.method3310();
               var3 = secretPacketBuffer2.method3238();
               var25 = class261.method4792(var21);
               if(var25.field2689 != var3 || var3 == -1) {
                  var25.field2689 = var3;
                  var25.field2773 = 0;
                  var25.field2765 = 0;
                  class219.method4130(var25);
               }

               field936 = -1;
               return true;
            }

            if(field936 == 17) {
               var21 = secretPacketBuffer2.method3227();
               var3 = secretPacketBuffer2.method3189();
               var4 = secretPacketBuffer2.readInt();
               var26 = (WidgetNode)componentTable.method3615((long)var4);
               if(var26 != null) {
                  class276.method4969(var26, var3 != var26.id);
               }

               class44.method649(var4, var3, var21);
               field936 = -1;
               return true;
            }

            if(field936 == 253) {
               class60.xteaChanged(false);
               secretPacketBuffer2.readOpcode();
               var21 = secretPacketBuffer2.readUnsignedShort();
               var85 = secretPacketBuffer2;
               var4 = var85.offset;
               class96.field1487 = 0;
               ScriptState.method1079(var85);

               for(var5 = 0; var5 < class96.field1487; ++var5) {
                  var6 = class96.field1495[var5];
                  var7 = cachedPlayers[var6];
                  var8 = var85.readUnsignedByte();
                  if((var8 & 4) != 0) {
                     var8 += var85.readUnsignedByte() << 8;
                  }

                  var9 = -1;
                  if((var8 & 32) != 0) {
                     var10 = var85.readUnsignedByte();
                     var11 = new byte[var10];
                     var12 = new Buffer(var11);
                     var85.readBytes(var11, 0, var10);
                     class96.field1486[var6] = var12;
                     var7.method1142(var12);
                  }

                  if((var8 & 64) != 0) {
                     var10 = var85.readUnsignedShort();
                     if(var10 == '\uffff') {
                        var10 = -1;
                     }

                     var18 = var85.readUnsignedByte();
                     class44.method644(var7, var10, var18);
                  }

                  if((var8 & 16) != 0) {
                     var7.interacting = var85.readUnsignedShort();
                     if(var7.interacting == '\uffff') {
                        var7.interacting = -1;
                     }
                  }

                  if((var8 & 8) != 0) {
                     var7.overhead = var85.readString();
                     if(var7.overhead.charAt(0) == 126) {
                        var7.overhead = var7.overhead.substring(1);
                        GameObject.sendGameMessage(2, var7.name, var7.overhead);
                     } else if(XGrandExchangeOffer.localPlayer == var7) {
                        GameObject.sendGameMessage(2, var7.name, var7.overhead);
                     }

                     var7.field1212 = false;
                     var7.field1215 = 0;
                     var7.field1216 = 0;
                     var7.field1214 = 150;
                  }

                  if((var8 & 2) != 0) {
                     var10 = var85.readUnsignedByte();
                     if(var10 > 0) {
                        for(var18 = 0; var18 < var10; ++var18) {
                           var13 = -1;
                           var14 = -1;
                           var15 = -1;
                           var19 = var85.method3212();
                           if(var19 == 32767) {
                              var19 = var85.method3212();
                              var14 = var85.method3212();
                              var13 = var85.method3212();
                              var15 = var85.method3212();
                           } else if(var19 != 32766) {
                              var14 = var85.method3212();
                           } else {
                              var19 = -1;
                           }

                           var16 = var85.method3212();
                           var7.method1525(var19, var14, var13, var15, gameCycle, var16);
                        }
                     }

                     var18 = var85.readUnsignedByte();
                     if(var18 > 0) {
                        for(var19 = 0; var19 < var18; ++var19) {
                           var13 = var85.method3212();
                           var14 = var85.method3212();
                           if(var14 != 32767) {
                              var15 = var85.method3212();
                              var16 = var85.readUnsignedByte();
                              var17 = var14 > 0?var85.readUnsignedByte():var16;
                              var7.method1526(var13, gameCycle, var14, var15, var16, var17);
                           } else {
                              var7.method1527(var13);
                           }
                        }
                     }
                  }

                  if((var8 & 1) != 0) {
                     var7.field1230 = var85.readUnsignedShort();
                     if(var7.field1252 == 0) {
                        var7.field1247 = var7.field1230;
                        var7.field1230 = -1;
                     }
                  }

                  if((var8 & 128) != 0) {
                     var10 = var85.readUnsignedShort();
                     var68 = (class230)method1381(WidgetNode.method1106(), var85.readUnsignedByte());
                     var75 = var85.readUnsignedByte() == 1;
                     var13 = var85.readUnsignedByte();
                     var14 = var85.offset;
                     if(var7.name != null && var7.composition != null) {
                        var73 = false;
                        if(var68.field3158 && class22.method153(var7.name)) {
                           var73 = true;
                        }

                        if(!var73 && field1014 == 0 && !var7.field867) {
                           class96.field1483.offset = 0;
                           var85.readBytes(class96.field1483.payload, 0, var13);
                           class96.field1483.offset = 0;
                           var20 = FontTypeFace.method4813(class219.method4131(ItemLayer.method2441(class96.field1483)));
                           var7.overhead = var20.trim();
                           var7.field1215 = var10 >> 8;
                           var7.field1216 = var10 & 255;
                           var7.field1214 = 150;
                           var7.field1212 = var75;
                           var7.inSequence = XGrandExchangeOffer.localPlayer != var7 && var68.field3158 && "" != field1108 && var20.toLowerCase().indexOf(field1108) == -1;
                           if(var68.field3161) {
                              var17 = var75?91:1;
                           } else {
                              var17 = var75?90:2;
                           }

                           if(var68.field3166 != -1) {
                              GameObject.sendGameMessage(var17, WidgetNode.method1104(var68.field3166) + var7.name, var20);
                           } else {
                              GameObject.sendGameMessage(var17, var7.name, var20);
                           }
                        }
                     }

                     var85.offset = var14 + var13;
                  }

                  if((var8 & 4096) != 0) {
                     var7.graphic = var85.readUnsignedShort();
                     var10 = var85.readInt();
                     var7.field1239 = var10 >> 16;
                     var7.field1206 = (var10 & '\uffff') + gameCycle;
                     var7.field1228 = 0;
                     var7.field1237 = 0;
                     if(var7.field1206 > gameCycle) {
                        var7.field1228 = -1;
                     }

                     if(var7.graphic == '\uffff') {
                        var7.graphic = -1;
                     }
                  }

                  if((var8 & 1024) != 0) {
                     var7.field1198 = var85.readByte();
                     var7.field1242 = var85.readByte();
                     var7.field1225 = var85.readByte();
                     var7.field1243 = var85.readByte();
                     var7.field1244 = var85.readUnsignedShort() + gameCycle;
                     var7.field1224 = var85.readUnsignedShort() + gameCycle;
                     var7.field1201 = var85.readUnsignedShort();
                     if(var7.field876) {
                        var7.field1198 += var7.field877;
                        var7.field1242 += var7.field861;
                        var7.field1225 += var7.field877;
                        var7.field1243 += var7.field861;
                        var7.field1252 = 0;
                     } else {
                        var7.field1198 += var7.pathX[0];
                        var7.field1242 += var7.pathY[0];
                        var7.field1225 += var7.pathX[0];
                        var7.field1243 += var7.pathY[0];
                        var7.field1252 = 1;
                     }

                     var7.field1236 = 0;
                  }

                  if((var8 & 2048) != 0) {
                     class96.field1485[var6] = var85.readByte();
                  }

                  if((var8 & 256) != 0) {
                     var9 = var85.readByte();
                  }

                  if((var8 & 512) != 0) {
                     for(var10 = 0; var10 < 3; ++var10) {
                        var7.actions[var10] = var85.readString();
                     }
                  }

                  if(var7.field876) {
                     if(var9 == 127) {
                        var7.method1146(var7.field877, var7.field861);
                     } else {
                        if(var9 != -1) {
                           var71 = var9;
                        } else {
                           var71 = class96.field1485[var6];
                        }

                        var7.method1145(var7.field877, var7.field861, var71);
                     }
                  }
               }

               if(var21 != var85.offset - var4) {
                  throw new RuntimeException(var85.offset - var4 + " " + var21);
               }

               field936 = -1;
               return true;
            }

            if(field936 == 228) {
               var21 = secretPacketBuffer2.method3236();
               var3 = secretPacketBuffer2.method3222();
               var4 = var21 >> 10 & 31;
               var5 = var21 >> 5 & 31;
               var6 = var21 & 31;
               var29 = (var5 << 11) + (var4 << 19) + (var6 << 3);
               Widget var43 = class261.method4792(var3);
               if(var29 != var43.textColor) {
                  var43.textColor = var29;
                  class219.method4130(var43);
               }

               field936 = -1;
               return true;
            }

            if(field936 == 46) {
               var21 = secretPacketBuffer2.method3246();
               var28 = secretPacketBuffer2.readString();
               var25 = class261.method4792(var21);
               if(!var28.equals(var25.text)) {
                  var25.text = var28;
                  class219.method4130(var25);
               }

               field936 = -1;
               return true;
            }

            if(field936 == 84) {
               var21 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.readUnsignedShort();
               if(var21 < -70000) {
                  var3 += '耀';
               }

               if(var21 >= 0) {
                  var25 = class261.method4792(var21);
               } else {
                  var25 = null;
               }

               for(; secretPacketBuffer2.offset < packetLength; class23.method160(var3, var5, var6 - 1, var29)) {
                  var5 = secretPacketBuffer2.method3212();
                  var6 = secretPacketBuffer2.readUnsignedShort();
                  var29 = 0;
                  if(var6 != 0) {
                     var29 = secretPacketBuffer2.readUnsignedByte();
                     if(var29 == 255) {
                        var29 = secretPacketBuffer2.readInt();
                     }
                  }

                  if(var25 != null && var5 >= 0 && var5 < var25.itemIds.length) {
                     var25.itemIds[var5] = var6;
                     var25.itemQuantities[var5] = var29;
                  }
               }

               if(var25 != null) {
                  class219.method4130(var25);
               }

               class18.method132();
               field1051[++field1079 - 1 & 31] = var3 & 32767;
               field936 = -1;
               return true;
            }

            Game.method4169("" + field936 + "," + field1070 + "," + field978 + "," + packetLength, (Throwable)null);
            class84.method1695();
         } catch (IOException var51) {
            if(field986 > 0) {
               class84.method1695();
            } else {
               class12.setGameState(40);
               class98.field1523 = XGrandExchangeOffer.rssocket;
               XGrandExchangeOffer.rssocket = null;
            }
         } catch (Exception var52) {
            var2 = "" + field936 + "," + field1070 + "," + field978 + "," + packetLength + "," + (class166.baseX + XGrandExchangeOffer.localPlayer.pathX[0]) + "," + (class146.baseY + XGrandExchangeOffer.localPlayer.pathY[0]) + ",";

            for(var3 = 0; var3 < packetLength && var3 < 50; ++var3) {
               var2 = var2 + secretPacketBuffer2.payload[var3] + ",";
            }

            Game.method4169(var2, var52);
            class84.method1695();
         }

         return true;
      }
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-2055105555"
   )
   void method1192(Widget var1) {
      Widget var2 = var1.parentId == -1?null:class261.method4792(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = class261.field3626;
         var4 = class19.field320;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class36.method497(var1, var3, var4, false);
      class23.method161(var1, var3, var4);
   }

   static {
      field1003 = true;
      world = 1;
      flags = 0;
      field926 = 0;
      isMembers = false;
      field895 = false;
      field896 = 0;
      gameState = 0;
      field898 = true;
      gameCycle = 0;
      field1125 = -1L;
      field954 = -1;
      field893 = -1;
      field1038 = -1;
      field904 = true;
      field905 = false;
      field906 = 0;
      field907 = 0;
      field908 = 0;
      field909 = 0;
      field924 = 0;
      field911 = 0;
      field1133 = 0;
      field913 = 0;
      field1026 = 0;
      field915 = class91.field1407;
      field916 = class91.field1407;
      field968 = 0;
      field1150 = 0;
      field919 = 0;
      field921 = 0;
      loginState = 0;
      field901 = 0;
      field912 = 0;
      field941 = 0;
      field967 = null;
      cachedNPCs = new NPC['耀'];
      field928 = 0;
      field1013 = new int['耀'];
      field930 = 0;
      field931 = new int[250];
      secretPacketBuffer1 = new PacketBuffer(5000);
      field933 = new PacketBuffer(5000);
      secretPacketBuffer2 = new PacketBuffer(15000);
      packetLength = 0;
      field936 = 0;
      field937 = 0;
      field938 = 0;
      field1164 = 0;
      field1070 = 0;
      field978 = 0;
      field986 = 0;
      field943 = false;
      field944 = new HashMap();
      field1044 = 0;
      field1119 = 1;
      field947 = 0;
      field923 = 1;
      field949 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field1076 = new int[4][13][13];
      field953 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field1061 = 0;
      field1063 = 2;
      field956 = 0;
      field957 = 2;
      field958 = 0;
      field959 = 1;
      field902 = 0;
      mapScale = 0;
      mapOffset = 2;
      mapScaleDelta = 0;
      field964 = 1;
      field965 = 0;
      field966 = 0;
      field940 = 2301979;
      field1015 = 5063219;
      field946 = 3353893;
      field969 = 7759444;
      field971 = false;
      field972 = 0;
      field973 = 128;
      mapAngle = 0;
      field975 = 0;
      field1029 = 0;
      field977 = 0;
      field1004 = 0;
      field979 = 50;
      field980 = 0;
      field981 = false;
      field982 = 0;
      field983 = 0;
      field984 = 50;
      field985 = new int[field984];
      field910 = new int[field984];
      field987 = new int[field984];
      field988 = new int[field984];
      field1056 = new int[field984];
      field925 = new int[field984];
      field952 = new int[field984];
      field992 = new String[field984];
      field890 = new int[104][104];
      field1152 = 0;
      field995 = -1;
      field996 = -1;
      field997 = 0;
      field998 = 0;
      field999 = 0;
      field1016 = 0;
      field1001 = 0;
      field1002 = 0;
      field1105 = 0;
      field993 = 0;
      field970 = 0;
      field1006 = 0;
      field1007 = false;
      field1090 = 0;
      field1014 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field1012 = 0;
      field1158 = 0;
      field1087 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field1018 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field1106 = -1;
      groundItemDeque = new Deque[4][104][104];
      field1021 = new Deque();
      projectiles = new Deque();
      field1023 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field1027 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field1036 = false;
      field1037 = -1;
      field1005 = false;
      field1143 = -1;
      field1040 = -1;
      field1120 = 0;
      field1042 = 50;
      field1043 = 0;
      field1142 = null;
      field1045 = false;
      field1046 = -1;
      field1047 = -1;
      field1048 = null;
      field1049 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field1052 = 0;
      field1069 = 0;
      field1054 = null;
      energy = 0;
      weight = 0;
      field1057 = 0;
      field1058 = -1;
      field1059 = false;
      field1060 = false;
      field994 = false;
      field903 = null;
      field961 = null;
      field1084 = null;
      field1065 = 0;
      field1039 = 0;
      field1067 = null;
      field1068 = false;
      field1034 = -1;
      field989 = -1;
      field1071 = false;
      field1072 = -1;
      field1073 = -1;
      field1008 = false;
      field1075 = 1;
      field955 = new int[32];
      field1145 = 0;
      field1051 = new int[32];
      field1079 = 0;
      field1080 = new int[32];
      field1081 = 0;
      field1082 = 0;
      field1083 = 0;
      field1126 = 0;
      field1085 = 0;
      field1086 = 0;
      field1053 = 0;
      field1088 = 0;
      field1089 = new Deque();
      field1114 = new Deque();
      field974 = new Deque();
      widgetFlags = new XHashTable(512);
      field1093 = 0;
      field1094 = -2;
      field1095 = new boolean[100];
      field1096 = new boolean[100];
      field1097 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field1102 = 0;
      field1103 = 0L;
      isResized = true;
      field1066 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field1099 = 0;
      field1092 = 0;
      field1108 = "";
      field1137 = new long[100];
      field1110 = 0;
      field1111 = 0;
      field1112 = new int[128];
      field1113 = new int[128];
      field948 = -1L;
      field1115 = null;
      clanChatOwner = null;
      field1117 = -1;
      field1118 = 0;
      field918 = new int[1000];
      field1064 = new int[1000];
      field1124 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field1017 = 0;
      field1077 = 255;
      field1127 = -1;
      field1109 = false;
      field1129 = 127;
      field1130 = 127;
      field1131 = 0;
      field1132 = new int[50];
      field1009 = new int[50];
      field1134 = new int[50];
      field1135 = new int[50];
      field1136 = new SoundEffect[50];
      field929 = false;
      field1138 = new boolean[5];
      field1139 = new int[5];
      field1140 = new int[5];
      field1141 = new int[5];
      field1166 = new int[5];
      field900 = 256;
      field1144 = 205;
      field942 = 256;
      field1121 = 320;
      field1147 = 1;
      field1148 = 32767;
      field1149 = 1;
      field914 = 32767;
      field1151 = 0;
      field1091 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field939 = 0;
      friends = new Friend[400];
      field1128 = new class195();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1162 = new PlayerComposition();
      field1163 = -1;
      field1055 = -1;
      field1165 = new XGrandExchangeOffer[8];
      field945 = -1L;
      field1167 = -1L;
      field1168 = new class73();
      field1169 = new int[50];
      field1170 = new int[50];
   }

   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "760287643"
   )
   static void method1205() {
      int var0;
      if(field968 == 0) {
         class46.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            collisionMaps[var0] = new CollisionData(104, 104);
         }

         class172.field2368 = new SpritePixels(512, 512);
         class92.field1431 = "Starting game engine...";
         class92.field1430 = 5;
         field968 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(field968 != 20) {
            if(field968 == 30) {
               class1.indexInterfaces = class13.method68(0, false, true, true);
               class170.indexSoundEffects = class13.method68(1, false, true, true);
               class17.field311 = class13.method68(2, true, false, true);
               class38.field513 = class13.method68(3, false, true, true);
               class43.field559 = class13.method68(4, false, true, true);
               class34.indexMaps = class13.method68(5, true, true, true);
               class44.indexTrack1 = class13.method68(6, true, true, false);
               ChatMessages.indexModels = class13.method68(7, false, true, true);
               class77.indexSprites = class13.method68(8, false, true, true);
               class20.indexTextures = class13.method68(9, false, true, true);
               class64.field785 = class13.method68(10, false, true, true);
               class33.indexTrack2 = class13.method68(11, false, true, true);
               class66.indexScripts = class13.method68(12, false, true, true);
               class91.field1411 = class13.method68(13, true, false, true);
               class15.field294 = class13.method68(14, false, true, false);
               field1171 = class13.method68(15, false, true, true);
               class22.field336 = class13.method68(16, false, true, false);
               class92.field1431 = "Connecting to update server";
               class92.field1430 = 20;
               field968 = 40;
            } else if(field968 == 40) {
               byte var27 = 0;
               var0 = var27 + class1.indexInterfaces.method4320() * 4 / 100;
               var0 += class170.indexSoundEffects.method4320() * 4 / 100;
               var0 += class17.field311.method4320() * 2 / 100;
               var0 += class38.field513.method4320() * 2 / 100;
               var0 += class43.field559.method4320() * 6 / 100;
               var0 += class34.indexMaps.method4320() * 4 / 100;
               var0 += class44.indexTrack1.method4320() * 2 / 100;
               var0 += ChatMessages.indexModels.method4320() * 58 / 100;
               var0 += class77.indexSprites.method4320() * 2 / 100;
               var0 += class20.indexTextures.method4320() * 2 / 100;
               var0 += class64.field785.method4320() * 2 / 100;
               var0 += class33.indexTrack2.method4320() * 2 / 100;
               var0 += class66.indexScripts.method4320() * 2 / 100;
               var0 += class91.field1411.method4320() * 2 / 100;
               var0 += class15.field294.method4320() * 2 / 100;
               var0 += field1171.method4320() * 2 / 100;
               var0 += class22.field336.method4320() * 2 / 100;
               if(var0 != 100) {
                  if(var0 != 0) {
                     class92.field1431 = "Checking for updates - " + var0 + "%";
                  }

                  class92.field1430 = 30;
               } else {
                  class92.field1431 = "Loaded update list";
                  class92.field1430 = 30;
                  field968 = 45;
               }
            } else if(field968 == 45) {
               boolean var26 = !field895;
               class109.field1628 = 22050;
               class168.field2315 = var26;
               class243.field3305 = 2;
               class204 var33 = new class204();
               var33.method3762(9, 128);
               class48.field611 = class95.method1798(GameEngine.field682, 0, 22050);
               class48.field611.method2064(var33);
               class10.method42(field1171, class15.field294, class43.field559, var33);
               WidgetNode.field812 = class95.method1798(GameEngine.field682, 1, 2048);
               class164.field2291 = new class102();
               WidgetNode.field812.method2064(class164.field2291);
               class154.field2216 = new class116(22050, class109.field1628);
               class92.field1431 = "Prepared sound engine";
               class92.field1430 = 35;
               field968 = 50;
               class12.field272 = new class262(class77.indexSprites, class91.field1411);
            } else if(field968 == 50) {
               class261[] var31 = new class261[]{class261.field3615, class261.field3622, class261.field3618, class261.field3624, class261.field3616, class261.field3619};
               var1 = var31.length;
               class262 var34 = class12.field272;
               class261[] var35 = new class261[]{class261.field3615, class261.field3622, class261.field3618, class261.field3624, class261.field3616, class261.field3619};
               field944 = var34.method4796(var35);
               if(field944.size() < var1) {
                  class92.field1431 = "Loading fonts - " + field944.size() * 100 / var1 + "%";
                  class92.field1430 = 40;
               } else {
                  class3.field15 = (Font)field944.get(class261.field3624);
                  MessageNode.field845 = (Font)field944.get(class261.field3615);
                  class40.field531 = (Font)field944.get(class261.field3616);
                  class242.field3290 = new class291(true);
                  class92.field1431 = "Loaded fonts";
                  class92.field1430 = 40;
                  field968 = 60;
               }
            } else if(field968 == 60) {
               var0 = class67.method1101(class64.field785, class77.indexSprites);
               byte var25 = 9;
               if(var0 < var25) {
                  class92.field1431 = "Loading title screen - " + var0 * 100 / var25 + "%";
                  class92.field1430 = 50;
               } else {
                  class92.field1431 = "Loaded title screen";
                  class92.field1430 = 50;
                  class12.setGameState(5);
                  field968 = 70;
               }
            } else {
               IndexData var22;
               if(field968 == 70) {
                  if(!class17.field311.method4178()) {
                     class92.field1431 = "Loading config - " + class17.field311.method4296() + "%";
                     class92.field1430 = 60;
                  } else {
                     class205.method3885(class17.field311);
                     Script.method1886(class17.field311);
                     IndexData var30 = class17.field311;
                     IndexData var32 = ChatMessages.indexModels;
                     KitDefinition.field3339 = var30;
                     KitDefinition.field3341 = var32;
                     KitDefinition.field3338 = KitDefinition.field3339.method4184(3);
                     method1514(class17.field311, ChatMessages.indexModels, field895);
                     var22 = class17.field311;
                     IndexData var23 = ChatMessages.indexModels;
                     class60.field738 = var22;
                     NPCComposition.field3551 = var23;
                     class109.method2098(class17.field311);
                     IndexData var24 = class17.field311;
                     IndexData var5 = ChatMessages.indexModels;
                     boolean var6 = isMembers;
                     Font var7 = class3.field15;
                     ItemComposition.field3516 = var24;
                     class165.field2302 = var5;
                     class231.isMembersWorld = var6;
                     ItemComposition.field3484 = ItemComposition.field3516.method4184(10);
                     ItemComposition.field3524 = var7;
                     class100.method1891(class17.field311, class1.indexInterfaces, class170.indexSoundEffects);
                     IndexData var8 = class17.field311;
                     IndexData var9 = ChatMessages.indexModels;
                     Spotanim.field3323 = var8;
                     Spotanim.field3311 = var9;
                     IndexData var10 = class17.field311;
                     class5.field28 = var10;
                     class154.method2989(class17.field311);
                     IndexData var11 = class38.field513;
                     IndexData var12 = ChatMessages.indexModels;
                     IndexData var13 = class77.indexSprites;
                     IndexData var14 = class91.field1411;
                     Widget.field2682 = var11;
                     class269.field3677 = var12;
                     class56.field677 = var13;
                     Widget.field2635 = var14;
                     class90.widgets = new Widget[Widget.field2682.method4223()][];
                     Widget.validInterfaces = new boolean[Widget.field2682.method4223()];
                     IndexData var15 = class17.field311;
                     class240.field3268 = var15;
                     class23.method165(class17.field311);
                     IndexData var16 = class17.field311;
                     class243.field3302 = var16;
                     class111.method2113(class17.field311);
                     IndexData var17 = class17.field311;
                     class251.field3386 = var17;
                     chatMessages = new ChatMessages();
                     class64.method1093(class17.field311, class77.indexSprites, class91.field1411);
                     IndexData var18 = class17.field311;
                     IndexData var19 = class77.indexSprites;
                     CombatInfo2.field3353 = var18;
                     class265.field3654 = var19;
                     class25.method178(class17.field311, class77.indexSprites);
                     class92.field1431 = "Loaded config";
                     class92.field1430 = 60;
                     field968 = 80;
                  }
               } else if(field968 == 80) {
                  var0 = 0;
                  SpritePixels var21;
                  if(class166.field2304 == null) {
                     var22 = class77.indexSprites;
                     var3 = var22.method4189("compass");
                     var4 = var22.method4190(var3, "");
                     var21 = class123.method2381(var22, var3, var4);
                     class166.field2304 = var21;
                  } else {
                     ++var0;
                  }

                  if(class158.field2238 == null) {
                     var22 = class77.indexSprites;
                     var3 = var22.method4189("mapedge");
                     var4 = var22.method4190(var3, "");
                     var21 = class123.method2381(var22, var3, var4);
                     class158.field2238 = var21;
                  } else {
                     ++var0;
                  }

                  if(class112.field1658 == null) {
                     class112.field1658 = class56.method826(class77.indexSprites, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(class89.field1383 == null) {
                     class89.field1383 = XItemContainer.method1083(class77.indexSprites, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(class23.field347 == null) {
                     class23.field347 = XItemContainer.method1083(class77.indexSprites, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(class10.field261 == null) {
                     class10.field261 = XItemContainer.method1083(class77.indexSprites, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(CombatInfoListHolder.field1347 == null) {
                     CombatInfoListHolder.field1347 = XItemContainer.method1083(class77.indexSprites, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(class228.field3148 == null) {
                     class228.field3148 = XItemContainer.method1083(class77.indexSprites, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(Preferences.field1282 == null) {
                     Preferences.field1282 = XItemContainer.method1083(class77.indexSprites, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class50.field642 == null) {
                     class50.field642 = class56.method826(class77.indexSprites, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(class32.field460 == null) {
                     class32.field460 = class56.method826(class77.indexSprites, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 11) {
                     class92.field1431 = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class92.field1430 = 70;
                  } else {
                     FontTypeFace.modIcons = class32.field460;
                     class158.field2238.method5145();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;
                     class112.field1658[0].method5100(var4 + var1, var4 + var2, var4 + var3);
                     class92.field1431 = "Loaded sprites";
                     class92.field1430 = 70;
                     field968 = 90;
                  }
               } else if(field968 == 90) {
                  if(!class20.indexTextures.method4178()) {
                     class92.field1431 = "Loading textures - " + class20.indexTextures.method4296() + "%";
                     class92.field1430 = 90;
                  } else {
                     TextureProvider var29 = new TextureProvider(class20.indexTextures, class77.indexSprites, 20, 0.8D, field895?64:128);
                     class136.method2626(var29);
                     class136.method2627(0.8D);
                     class92.field1431 = "Loaded textures";
                     class92.field1430 = 90;
                     field968 = 110;
                  }
               } else if(field968 == 110) {
                  PacketBuffer.field2414 = new class71();
                  GameEngine.field682.method2969(PacketBuffer.field2414, 10);
                  class92.field1431 = "Loaded input handler";
                  class92.field1430 = 94;
                  field968 = 120;
               } else if(field968 == 120) {
                  if(!class64.field785.method4193("huffman", "")) {
                     class92.field1431 = "Loading wordpack - " + 0 + "%";
                     class92.field1430 = 96;
                  } else {
                     class165 var28 = new class165(class64.field785.method4192("huffman", ""));
                     FloorUnderlayDefinition.method4441(var28);
                     class92.field1431 = "Loaded wordpack";
                     class92.field1430 = 96;
                     field968 = 130;
                  }
               } else if(field968 == 130) {
                  if(!class38.field513.method4178()) {
                     class92.field1431 = "Loading interfaces - " + class38.field513.method4296() * 4 / 5 + "%";
                     class92.field1430 = 100;
                  } else if(!class66.indexScripts.method4178()) {
                     class92.field1431 = "Loading interfaces - " + (class66.indexScripts.method4296() / 6 + 80) + "%";
                     class92.field1430 = 100;
                  } else if(!class91.field1411.method4178()) {
                     class92.field1431 = "Loading interfaces - " + (class91.field1411.method4296() / 50 + 96) + "%";
                     class92.field1430 = 100;
                  } else {
                     class92.field1431 = "Loaded interfaces";
                     class92.field1430 = 98;
                     field968 = 140;
                  }
               } else if(field968 == 140) {
                  if(!class22.field336.method4225(class40.field538.field540)) {
                     class92.field1431 = "Loading world map - " + class22.field336.method4196(class40.field538.field540) / 10 + "%";
                  } else {
                     if(class83.field1325 == null) {
                        class83.field1325 = new class288();
                        class83.field1325.method5253(class22.field336, class40.field531, field944, class112.field1658);
                     }

                     var0 = class83.field1325.method5255();
                     if(var0 < 100) {
                        class92.field1431 = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                     } else {
                        class92.field1431 = "Loaded world map";
                        class92.field1430 = 100;
                        field968 = 150;
                     }
                  }
               } else if(field968 == 150) {
                  class12.setGameState(10);
               }
            }
         } else {
            int[] var20 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 128 + 15;
               var3 = var2 * 3 + 600;
               var4 = class136.SINE[var2];
               var20[var1] = var4 * var3 >> 16;
            }

            Region.method2788(var20, 500, 800, 512, 334);
            class92.field1431 = "Prepared visibility map";
            class92.field1430 = 10;
            field968 = 30;
         }
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2062961080"
   )
   protected final void vmethod1234() {
      if(chatMessages.method1843()) {
         chatMessages.method1828();
      }

      if(PacketBuffer.field2414 != null) {
         PacketBuffer.field2414.field835 = false;
      }

      PacketBuffer.field2414 = null;
      if(XGrandExchangeOffer.rssocket != null) {
         XGrandExchangeOffer.rssocket.method3048();
         XGrandExchangeOffer.rssocket = null;
      }

      Tile.method2530();
      class166.method3132();
      class20.field331 = null;
      if(class48.field611 != null) {
         class48.field611.method2049();
      }

      if(WidgetNode.field812 != null) {
         WidgetNode.field812.method2049();
      }

      class24.method175();
      class207.method3942();

      try {
         class155.field2231.method2357();

         for(int var1 = 0; var1 < class155.field2223; ++var1) {
            VertexNormal.field1994[var1].method2357();
         }

         class155.field2229.method2357();
         class155.field2221.method2357();
      } catch (Exception var3) {
         ;
      }

   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1575175308"
   )
   final void method1242(int var1, int var2) {
      int var3 = class40.field531.method4809("Choose Option");

      int var4;
      int var5;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         var5 = class40.field531.method4809(class46.method677(var4));
         if(var5 > var3) {
            var3 = var5;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      var5 = var1 - var3 / 2;
      if(var3 + var5 > class261.field3626) {
         var5 = class261.field3626 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      int var6 = var2;
      if(var2 + var4 > class19.field320) {
         var6 = class19.field320 - var4;
      }

      if(var6 < 0) {
         var6 = 0;
      }

      class46.region.method2744(Sequence.plane, var1, var2, false);
      isMenuOpen = true;
      class152.menuX = var5;
      class287.menuY = var6;
      Varbit.menuHeight = var3;
      FileOnDisk.field1751 = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1021554301"
   )
   public static final void method1275() {
      while(true) {
         class9 var0 = (class9)class7.field232.method3622();
         if(var0 == null) {
            return;
         }

         var0.vmethod43();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Lclass178;IS)Lclass178;",
      garbageValue = "-7004"
   )
   public static class178 method1381(class178[] var0, int var1) {
      class178[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class178 var4 = var2[var3];
         if(var1 == var4.vmethod5090()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   protected final void vmethod1402() {
      field1103 = class226.method4147() + 500L;
      this.method1181();
      if(widgetRoot != -1) {
         this.method1170(true);
      }

   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-11605038"
   )
   final void method1453() {
      class219.method4130(field961);
      ++FaceNormal.field2120;
      if(field1071 && field1068) {
         int var1 = class59.field721;
         int var2 = class59.field722;
         var1 -= field1065;
         var2 -= field1039;
         if(var1 < field1034) {
            var1 = field1034;
         }

         if(field961.width + var1 > field1084.width + field1034) {
            var1 = field1084.width + field1034 - field961.width;
         }

         if(var2 < field989) {
            var2 = field989;
         }

         if(field961.height + var2 > field989 + field1084.height) {
            var2 = field1084.height + field989 - field961.height;
         }

         int var3 = var1 - field1072;
         int var4 = var2 - field1073;
         int var5 = field961.field2718;
         if(FaceNormal.field2120 > field961.field2687 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1008 = true;
         }

         int var6 = field1084.scrollX + (var1 - field1034);
         int var7 = field1084.scrollY + (var2 - field989);
         class69 var8;
         if(field961.field2731 != null && field1008) {
            var8 = new class69();
            var8.field816 = field961;
            var8.field817 = var6;
            var8.field819 = var7;
            var8.field826 = field961.field2731;
            GroundObject.method2522(var8);
         }

         if(class59.field732 == 0) {
            if(field1008) {
               if(field961.field2732 != null) {
                  var8 = new class69();
                  var8.field816 = field961;
                  var8.field817 = var6;
                  var8.field819 = var7;
                  var8.field820 = field1067;
                  var8.field826 = field961.field2732;
                  GroundObject.method2522(var8);
               }

               if(field1067 != null && class59.method1028(field961) != null) {
                  secretPacketBuffer1.putOpcode(128);
                  secretPacketBuffer1.putInt(field961.id);
                  secretPacketBuffer1.putShort(field961.index);
                  secretPacketBuffer1.putInt(field1067.id);
                  secretPacketBuffer1.method3382(field961.itemId);
                  secretPacketBuffer1.method3232(field1067.index);
                  secretPacketBuffer1.method3382(field1067.itemId);
               }
            } else {
               label170: {
                  label174: {
                     int var11 = class84.method1694();
                     if(menuOptionCount > 2) {
                        boolean var9;
                        if(field1027 == 1) {
                           if(menuOptionCount <= 0) {
                              var9 = false;
                           } else if(field1005 && class50.field624[81] && field1037 != -1) {
                              var9 = true;
                           } else {
                              var9 = false;
                           }

                           if(!var9) {
                              break label174;
                           }
                        }

                        if(var11 < 0) {
                           var9 = false;
                        } else {
                           int var10 = menuTypes[var11];
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
                           break label174;
                        }
                     }

                     if(menuOptionCount > 0) {
                        XGrandExchangeOffer.method109(field1072 + field1065, field1073 + field1039);
                     }
                     break label170;
                  }

                  this.method1242(field1072 + field1065, field1073 + field1039);
               }
            }

            field961 = null;
         }

      } else {
         if(FaceNormal.field2120 > 1) {
            field961 = null;
         }

      }
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1528304040"
   )
   final void method1465() {
      VertexNormal.method2620();
      if(class20.field323 == null) {
         if(field961 == null) {
            int var1 = class59.field727;
            int var2;
            int var3;
            int var4;
            int var5;
            int var7;
            int var9;
            if(isMenuOpen) {
               if(var1 != 1 && (class149.field2178 || var1 != 4)) {
                  var2 = class59.field721;
                  var3 = class59.field722;
                  if(var2 < class152.menuX - 10 || var2 > Varbit.menuHeight + class152.menuX + 10 || var3 < class287.menuY - 10 || var3 > FileOnDisk.field1751 + class287.menuY + 10) {
                     isMenuOpen = false;
                     class44.method645(class152.menuX, class287.menuY, Varbit.menuHeight, FileOnDisk.field1751);
                  }
               }

               if(var1 == 1 || !class149.field2178 && var1 == 4) {
                  var2 = class152.menuX;
                  var3 = class287.menuY;
                  var4 = Varbit.menuHeight;
                  var5 = class59.field717;
                  int var10 = class59.field729;
                  var7 = -1;

                  for(int var12 = 0; var12 < menuOptionCount; ++var12) {
                     var9 = var3 + 31 + (menuOptionCount - 1 - var12) * 15;
                     if(var5 > var2 && var5 < var2 + var4 && var10 > var9 - 13 && var10 < var9 + 3) {
                        var7 = var12;
                     }
                  }

                  if(var7 != -1) {
                     DecorativeObject.method2937(var7);
                  }

                  isMenuOpen = false;
                  class44.method645(class152.menuX, class287.menuY, Varbit.menuHeight, FileOnDisk.field1751);
               }
            } else {
               var2 = class84.method1694();
               if((var1 == 1 || !class149.field2178 && var1 == 4) && var2 >= 0) {
                  var3 = menuTypes[var2];
                  if(var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
                     var4 = menuActionParams0[var2];
                     var5 = menuActionParams1[var2];
                     Widget var6 = class261.method4792(var5);
                     if(FrameMap.method2707(class43.method626(var6)) || class60.method1035(class43.method626(var6))) {
                        if(class20.field323 != null && !field1007) {
                           var7 = class84.method1694();
                           if(field1027 != 1) {
                              boolean var8;
                              if(var7 < 0) {
                                 var8 = false;
                              } else {
                                 var9 = menuTypes[var7];
                                 if(var9 >= 2000) {
                                    var9 -= 2000;
                                 }

                                 if(var9 == 1007) {
                                    var8 = true;
                                 } else {
                                    var8 = false;
                                 }
                              }

                              if(!var8 && menuOptionCount > 0) {
                                 XGrandExchangeOffer.method109(field993, field970);
                              }
                           }
                        }

                        field1007 = false;
                        field1090 = 0;
                        if(class20.field323 != null) {
                           class219.method4130(class20.field323);
                        }

                        class20.field323 = class261.method4792(var5);
                        field1105 = var4;
                        field993 = class59.field717;
                        field970 = class59.field729;
                        if(var2 >= 0) {
                           class7.field235 = new class89();
                           class7.field235.field1381 = menuActionParams0[var2];
                           class7.field235.field1394 = menuActionParams1[var2];
                           class7.field235.field1382 = menuTypes[var2];
                           class7.field235.field1391 = menuIdentifiers[var2];
                           class7.field235.field1384 = menuOptions[var2];
                        }

                        class219.method4130(class20.field323);
                        return;
                     }
                  }
               }

               if(var1 == 1 || !class149.field2178 && var1 == 4) {
                  label327: {
                     label314: {
                        boolean var11;
                        if(field1027 == 1 && menuOptionCount > 2) {
                           if(menuOptionCount <= 0) {
                              var11 = false;
                           } else if(field1005 && class50.field624[81] && field1037 != -1) {
                              var11 = true;
                           } else {
                              var11 = false;
                           }

                           if(!var11) {
                              break label314;
                           }
                        }

                        if(var2 < 0) {
                           var11 = false;
                        } else {
                           var4 = menuTypes[var2];
                           if(var4 >= 2000) {
                              var4 -= 2000;
                           }

                           if(var4 == 1007) {
                              var11 = true;
                           } else {
                              var11 = false;
                           }
                        }

                        if(!var11) {
                           break label327;
                        }
                     }

                     var1 = 2;
                  }
               }

               if((var1 == 1 || !class149.field2178 && var1 == 4) && menuOptionCount > 0) {
                  DecorativeObject.method2937(var2);
               }

               if(var1 == 2 && menuOptionCount > 0) {
                  this.method1242(class59.field717, class59.field729);
               }
            }

         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "436910607"
   )
   static int method1510(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class261.method4792(class83.intStack[--class83.intStackSize]);
      } else {
         var3 = var2?class83.field1311:Buffer.field2384;
      }

      String var4 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var6 = class83.intStack[--class83.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class83.intStack[--class83.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var8[var7] = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class83.intStack[--class83.intStackSize]);
         }
      }

      var7 = class83.intStack[--class83.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2724 = var8;
      } else if(var0 == 1401) {
         var3.field2727 = var8;
      } else if(var0 == 1402) {
         var3.field2726 = var8;
      } else if(var0 == 1403) {
         var3.field2683 = var8;
      } else if(var0 == 1404) {
         var3.field2730 = var8;
      } else if(var0 == 1405) {
         var3.field2731 = var8;
      } else if(var0 == 1406) {
         var3.field2736 = var8;
      } else if(var0 == 1407) {
         var3.field2708 = var8;
         var3.field2766 = var5;
      } else if(var0 == 1408) {
         var3.field2741 = var8;
      } else if(var0 == 1409) {
         var3.field2634 = var8;
      } else if(var0 == 1410) {
         var3.field2732 = var8;
      } else if(var0 == 1411) {
         var3.field2725 = var8;
      } else if(var0 == 1412) {
         var3.field2768 = var8;
      } else if(var0 == 1414) {
         var3.field2764 = var8;
         var3.field2738 = var5;
      } else if(var0 == 1415) {
         var3.field2632 = var8;
         var3.field2740 = var5;
      } else if(var0 == 1416) {
         var3.field2733 = var8;
      } else if(var0 == 1417) {
         var3.field2743 = var8;
      } else if(var0 == 1418) {
         var3.field2650 = var8;
      } else if(var0 == 1419) {
         var3.field2745 = var8;
      } else if(var0 == 1420) {
         var3.field2680 = var8;
      } else if(var0 == 1421) {
         var3.field2747 = var8;
      } else if(var0 == 1422) {
         var3.field2748 = var8;
      } else if(var0 == 1423) {
         var3.field2749 = var8;
      } else if(var0 == 1424) {
         var3.field2735 = var8;
      } else if(var0 == 1425) {
         var3.field2717 = var8;
      } else if(var0 == 1426) {
         var3.field2753 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2751 = var8;
      }

      var3.field2722 = true;
      return 1;
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1783784972"
   )
   static final void method1512(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (field1144 - field900) * var5 / 100 + field900;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < field1149) {
         var15 = field1149;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > field1148) {
            var6 = field1148;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.method5009();
               Rasterizer2D.method5042(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method5042(var2 + var0 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > field914) {
         var15 = field914;
         var6 = var2 * var15 * 334 / (var3 * 512);
         if(var6 < field1147) {
            var6 = field1147;
            var8 = var2 * var15 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.method5009();
               Rasterizer2D.method5042(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method5042(var0, var1 + var3 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = field942 + var5 * (field1121 - field942) / 100;
      scale = var8 * var3 * var6 / 85504 << 1;
      if(camera2 != var2 || camera3 != var3) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 128 + 15;
            int var12 = var11 * 3 + 600;
            int var13 = class136.SINE[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.method2788(var14, 500, 800, var2, var3);
      }

      field1151 = var0;
      field1091 = var1;
      camera2 = var2;
      camera3 = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;ZB)V",
      garbageValue = "1"
   )
   public static void method1514(IndexDataBase var0, IndexDataBase var1, boolean var2) {
      ObjectComposition.field3429 = var0;
      ObjectComposition.field3441 = var1;
      ObjectComposition.field3428 = var2;
   }
}
