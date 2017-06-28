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
   @ObfuscatedName("oo")
   static int[] field900;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -2093332117
   )
   @Export("world")
   static int world;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1085264649
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("hb")
   static String[] field903;
   @ObfuscatedName("qw")
   static short field904;
   @ObfuscatedName("bv")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = 1665059607
   )
   static int field906;
   @ObfuscatedName("es")
   static PacketBuffer field907;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 1775775503
   )
   static int field908;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 201737365
   )
   @Export("gameState")
   @Hook("gameStateChanged")
   static int gameState;
   @ObfuscatedName("cz")
   static class91 field910;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = -636125477
   )
   static int field911;
   @ObfuscatedName("nb")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("bo")
   static class71 field913;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1713252585
   )
   static int field914;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -2094010839
   )
   static int field915;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -1616327405
   )
   static int field916;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = 1138518061
   )
   static int field917;
   @ObfuscatedName("bl")
   static boolean field918;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 1234329833
   )
   static int field919;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 454456761
   )
   static int field920;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -1805146139
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 1499692395
   )
   static int field922;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -675283521
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 1130181021
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("gd")
   static ModIcon[] field925;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -516880341
   )
   static int field926;
   @ObfuscatedName("jg")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("co")
   static class91 field928;
   @ObfuscatedName("nt")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = -771392617
   )
   static int field930;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = 187615115
   )
   static int field931;
   @ObfuscatedName("je")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      longValue = -726078457420887077L
   )
   static long field933;
   @ObfuscatedName("qt")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("cy")
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 117633149
   )
   static int field936;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = -1120696945
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = -151718853
   )
   static int field938;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = 510740237
   )
   static int field939;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 1665194461
   )
   static int field940;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -1280428995
   )
   static int field941;
   @ObfuscatedName("nl")
   static long[] field942;
   @ObfuscatedName("db")
   static byte[] field943;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = -849507475
   )
   static int field944;
   @ObfuscatedName("rf")
   static int[] field945;
   @ObfuscatedName("do")
   static int[] field946;
   @ObfuscatedName("eo")
   @Export("secretPacketBuffer1")
   static PacketBuffer secretPacketBuffer1;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = -24530739
   )
   static int field948;
   @ObfuscatedName("er")
   @Export("secretPacketBuffer2")
   static PacketBuffer secretPacketBuffer2;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 1086683151
   )
   @Export("packetLength")
   static int packetLength;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -395620443
   )
   @Export("packetType")
   static int packetType;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = -24505051
   )
   static int field952;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = 488523859
   )
   @Export("audioEffectCount")
   static int audioEffectCount;
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = -781175041
   )
   static int field954;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = -1957974073
   )
   static int field955;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 1992168655
   )
   static int field956;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = 574171801
   )
   static int field957;
   @ObfuscatedName("eg")
   static boolean field958;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 2040614563
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bx")
   static boolean field960;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = 940326087
   )
   static int field961;
   @ObfuscatedName("hv")
   static int[] field962;
   @ObfuscatedName("lk")
   static Widget field963;
   @ObfuscatedName("ok")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 1813813363
   )
   static int field965;
   @ObfuscatedName("fe")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("fo")
   static int[][][] field967;
   @ObfuscatedName("fq")
   static final int[] field968;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -1773336241
   )
   static int field969;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = -709626733
   )
   static int field970;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = -555390849
   )
   static int field971;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 405453693
   )
   static int field972;
   @ObfuscatedName("qm")
   static class195 field973;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = -2033615019
   )
   static int field974;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = 885100555
   )
   static int field975;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = 993150051
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = 2031326363
   )
   @Export("mapOffset")
   static int mapOffset;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 1276571323
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = -1926442089
   )
   static int field979;
   @ObfuscatedName("lh")
   static boolean field980;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = -657809385
   )
   static int field981;
   @ObfuscatedName("qp")
   static int[] field982;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -1117266331
   )
   static int field983;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 205238777
   )
   static int field984;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = 534815755
   )
   static int field985;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -1448906179
   )
   static int field986;
   @ObfuscatedName("gv")
   static boolean field987;
   @ObfuscatedName("qd")
   static short field988;
   @ObfuscatedName("ks")
   static boolean field989;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = 1851884607
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("ct")
   @Export("indexInterfaces")
   static IndexData indexInterfaces;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 1746120833
   )
   static int field992;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = -439589081
   )
   static int field993;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = 248459911
   )
   static int field994;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = -1691848631
   )
   static int field995;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = -315639063
   )
   static int field996;
   @ObfuscatedName("rq")
   static final class73 field997;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = 1845032419
   )
   static int field998;
   @ObfuscatedName("nh")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = 503619661
   )
   static int field1000;
   @ObfuscatedName("dh")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("hj")
   static int[] field1002;
   @ObfuscatedName("hr")
   static int[] field1003;
   @ObfuscatedName("hc")
   static int[] field1004;
   @ObfuscatedName("hp")
   static int[] field1005;
   @ObfuscatedName("hd")
   static int[] field1006;
   @ObfuscatedName("he")
   static int[] field1007;
   @ObfuscatedName("bk")
   static boolean field1008;
   @ObfuscatedName("hh")
   static int[][] field1009;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = 184001751
   )
   static int field1010;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = 737535581
   )
   static int field1011;
   @ObfuscatedName("jf")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = 579937939
   )
   static int field1013;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = 1320934151
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("pu")
   static int[] field1015;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = -248468253
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -792796391
   )
   static int field1017;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -1514850097
   )
   static int field1018;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -656717723
   )
   static int field1019;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 1435706291
   )
   static int field1021;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = -745702849
   )
   static int field1022;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 1549905021
   )
   static int field1023;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = 280469567
   )
   static int field1024;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = 1944705329
   )
   static int field1025;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = 1957985137
   )
   static int field1026;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = 130481083
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      longValue = 5691474878952601905L
   )
   static long field1028;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -1024185179
   )
   static int field1029;
   @ObfuscatedName("ik")
   static int[] field1030;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 33454353
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("jl")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("jc")
   static Deque field1033;
   @ObfuscatedName("ru")
   static int[] field1034;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = 953587047
   )
   static int field1035;
   @ObfuscatedName("pf")
   static int[] field1036;
   @ObfuscatedName("jp")
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("ny")
   static int[] field1038;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -109976235
   )
   static int field1039;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = 1389910691
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("om")
   @ObfuscatedGetter(
      intValue = -1542077855
   )
   static int field1041;
   @ObfuscatedName("jk")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -1517872481
   )
   static int field1043;
   @ObfuscatedName("jv")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = -1259232549
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("jx")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("jz")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("im")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -1623385645
   )
   static int field1049;
   @ObfuscatedName("jy")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("ky")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("eh")
   static HashMap field1052;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 1136787851
   )
   static int field1053;
   @ObfuscatedName("nc")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("bz")
   static boolean field1055;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = -421808997
   )
   static int field1056;
   @ObfuscatedName("jq")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = -768310475
   )
   static int field1058;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 1608159083
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("it")
   @Export("selectedItemName")
   static String selectedItemName;
   @ObfuscatedName("ki")
   static boolean field1061;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = -1434831251
   )
   static int field1062;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = 909456089
   )
   static int field1063;
   @ObfuscatedName("kk")
   static String field1064;
   @ObfuscatedName("kc")
   static String field1065;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 2106361501
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = 1783108115
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = 888288027
   )
   static int field1068;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = 122450383
   )
   static int field1069;
   @ObfuscatedName("kr")
   static Widget field1070;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = -1522489289
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = 2028864071
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 733530305
   )
   static int field1073;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = 8509195
   )
   static int field1074;
   @ObfuscatedName("ld")
   static boolean field1075;
   @ObfuscatedName("le")
   static boolean field1076;
   @ObfuscatedName("lt")
   static boolean field1077;
   @ObfuscatedName("lg")
   static Widget field1078;
   @ObfuscatedName("lq")
   static Widget field1079;
   @ObfuscatedName("lz")
   static Widget field1080;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 2128183941
   )
   static int field1081;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -54653739
   )
   static int field1082;
   @ObfuscatedName("hl")
   static boolean field1083;
   @ObfuscatedName("lr")
   static boolean field1084;
   @ObfuscatedName("ja")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = 1589299183
   )
   static int field1086;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      intValue = -425990945
   )
   static int field1087;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = -1609190135
   )
   static int field1088;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = 2107349727
   )
   static int field1089;
   @ObfuscatedName("lb")
   static boolean field1090;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = 1750896467
   )
   static int field1091;
   @ObfuscatedName("mp")
   static int[] field1092;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = -2113513883
   )
   static int field1093;
   @ObfuscatedName("mt")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = -1633993147
   )
   static int field1095;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -36725629
   )
   static int field1096;
   @ObfuscatedName("ml")
   @ObfuscatedGetter(
      intValue = -1433774217
   )
   static int field1097;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = 509074557
   )
   static int field1098;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = 1658324831
   )
   static int field1099;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -1083664559
   )
   static int field1100;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = 1768970009
   )
   static int field1101;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = -1763511119
   )
   static int field1102;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = -1386529469
   )
   static int field1103;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = 356643195
   )
   static int field1104;
   @ObfuscatedName("mk")
   static Deque field1105;
   @ObfuscatedName("mz")
   static Deque field1106;
   @ObfuscatedName("ia")
   static boolean field1107;
   @ObfuscatedName("mn")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = 263974687
   )
   static int field1109;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = 1367720947
   )
   static int field1110;
   @ObfuscatedName("md")
   static boolean[] field1111;
   @ObfuscatedName("my")
   static boolean[] field1112;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = 756669035
   )
   static int field1113;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 1985972323
   )
   static int field1114;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = -1157240125
   )
   static int field1115;
   @ObfuscatedName("ne")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 1600981987
   )
   static int field1117;
   @ObfuscatedName("kb")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      longValue = 6487226289667277269L
   )
   static long field1119;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -579010573
   )
   static int field1120;
   @ObfuscatedName("no")
   static int[] field1121;
   @ObfuscatedName("au")
   static boolean field1122;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = 293483359
   )
   static int field1123;
   @ObfuscatedName("nf")
   static String field1124;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 727627473
   )
   static int field1125;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = -711213855
   )
   static int field1126;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = -773577229
   )
   static int field1127;
   @ObfuscatedName("mo")
   static boolean[] field1128;
   @ObfuscatedName("pe")
   static int[] field1129;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      longValue = -2344032427121122023L
   )
   static long field1130;
   @ObfuscatedName("oh")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = -191469219
   )
   static int field1132;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -625912039
   )
   static int field1133;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = -1460966553
   )
   static int field1134;
   @ObfuscatedName("nq")
   static int[] field1135;
   @ObfuscatedName("ms")
   static Deque field1136;
   @ObfuscatedName("ov")
   static SpritePixels[] field1137;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = 840472499
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = 1151264889
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("kx")
   static boolean field1140;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = -1998792811
   )
   static int field1141;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = -1211340491
   )
   static int field1142;
   @ObfuscatedName("ox")
   static boolean field1143;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = -654023051
   )
   static int field1144;
   @ObfuscatedName("jb")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = -1628683499
   )
   @Export(
      value = "gameDrawingMode",
      setter = true
   )
   static int gameDrawingMode;
   @ObfuscatedName("qk")
   static short field1147;
   @ObfuscatedName("qn")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("jj")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("pl")
   static int[] field1150;
   @ObfuscatedName("pi")
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("pg")
   static boolean field1152;
   @ObfuscatedName("ps")
   static boolean[] field1153;
   @ObfuscatedName("jh")
   static int[] field1154;
   @ObfuscatedName("pm")
   static int[] field1155;
   @ObfuscatedName("qc")
   static int[] field1156;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 1531837
   )
   static int field1157;
   @ObfuscatedName("ds")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -1848839795
   )
   static int field1159;
   @ObfuscatedName("qe")
   static short field1160;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -873287611
   )
   static int field1161;
   @ObfuscatedName("qq")
   static short field1162;
   @ObfuscatedName("qx")
   static short field1163;
   @ObfuscatedName("qr")
   static short field1164;
   @ObfuscatedName("qz")
   static short field1165;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = -572986831
   )
   static int field1166;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = -1896694801
   )
   static int field1167;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = 1651958147
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("bf")
   static class232 field1169;
   @ObfuscatedName("pw")
   static int[] field1170;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = 1768853345
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = -259467793
   )
   static int field1172;
   @ObfuscatedName("jm")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("mi")
   static int[] field1174;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = 785858585
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 477878161
   )
   static int field1176;
   @ObfuscatedName("qy")
   static PlayerComposition field1177;
   @ObfuscatedName("rv")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = 574845901
   )
   static int field1179;
   @ObfuscatedName("oj")
   static int[] field1180;
   @ObfuscatedName("rk")
   static class13 field1181;
   @ObfuscatedName("rm")
   @ObfuscatedGetter(
      longValue = -4454281784484847599L
   )
   static long field1182;
   @ObfuscatedName("rp")
   @ObfuscatedGetter(
      longValue = -2236954108240907681L
   )
   static long field1183;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -2038081315
   )
   static int field1184;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 38289451
   )
   static int field1185;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = -84351041
   )
   static int field1186;

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2126031886"
   )
   protected final void vmethod1100() {
   }

   public final void init() {
      if(this.method807()) {
         class274[] var1 = new class274[]{class274.field3728, class274.field3715, class274.field3720, class274.field3724, class274.field3712, class274.field3717, class274.field3721, class274.field3719, class274.field3714, class274.field3722, class274.field3716, class274.field3727, class274.field3713, class274.field3718, class274.field3723};
         class274[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            class274 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3725);
            if(var5 != null) {
               switch(Integer.parseInt(var4.field3725)) {
               case 1:
                  world = Integer.parseInt(var5);
                  break;
               case 2:
                  field1161 = Integer.parseInt(var5);
                  break;
               case 3:
                  class219.field2810 = var5;
                  break;
               case 4:
                  class20.field347 = Integer.parseInt(var5);
               case 5:
               case 8:
               default:
                  break;
               case 6:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 7:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 9:
                  field1169 = (class232)RSCanvas.method735(class6.method22(), Integer.parseInt(var5));
                  if(class232.field3207 == field1169) {
                     class33.field482 = class289.field3853;
                  } else {
                     class33.field482 = class289.field3857;
                  }
                  break;
               case 10:
                  field1120 = Integer.parseInt(var5);
                  break;
               case 11:
                  flags = Integer.parseInt(var5);
                  break;
               case 12:
                  class151.field2219 = var5;
                  break;
               case 13:
                  int var6 = Integer.parseInt(var5);
                  class231[] var7 = class15.method107();
                  int var8 = 0;

                  class231 var9;
                  while(true) {
                     if(var8 >= var7.length) {
                        var9 = null;
                        break;
                     }

                     class231 var10 = var7[var8];
                     if(var6 == var10.field3195) {
                        var9 = var10;
                        break;
                     }

                     ++var8;
                  }

                  class12.field275 = var9;
                  break;
               case 14:
                  field908 = Integer.parseInt(var5);
               }
            }
         }

         Region.field2072 = false;
         field1055 = false;
         class40.host = this.getCodeBase().getHost();
         String var12 = class12.field275.field3194;
         byte var13 = 0;

         try {
            class59.method960("oldschool", var12, var13, 17);
         } catch (Exception var11) {
            class8.method43((String)null, var11);
         }

         class220.field2817 = this;
         this.method815(765, 503, 145);
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "128918498"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method1106();

      while(true) {
         Deque var1 = class236.field3245;
         Deque var2 = class236.field3245;
         Deque var4 = class236.field3245;
         FileSystem var3;
         synchronized(class236.field3245) {
            var3 = (FileSystem)class236.field3240.method3485();
         }

         if(var3 == null) {
            class7.method36();
            class69.method1035();
            class50 var14 = class50.keyboard;
            class50 var5 = class50.keyboard;
            class50 var7 = class50.keyboard;
            int var6;
            synchronized(class50.keyboard) {
               ++class50.keyboardIdleTicks;
               class50.field658 = class50.field665;
               class50.field657 = 0;
               if(class50.field653 >= 0) {
                  while(class50.field652 != class50.field653) {
                     var6 = class50.field634[class50.field652];
                     class50.field652 = class50.field652 + 1 & 127;
                     if(var6 < 0) {
                        class50.field660[~var6] = false;
                     } else {
                        if(!class50.field660[var6] && class50.field657 < class50.field656.length - 1) {
                           class50.field656[++class50.field657 - 1] = var6;
                        }

                        class50.field660[var6] = true;
                     }
                  }
               } else {
                  for(var6 = 0; var6 < 112; ++var6) {
                     class50.field660[var6] = false;
                  }

                  class50.field653 = class50.field652;
               }

               if(class50.field657 > 0) {
                  class50.keyboardIdleTicks = 0;
               }

               class50.field665 = class50.field659;
            }

            class59 var15 = class59.mouse;
            class59 var8 = class59.mouse;
            class59 var9 = class59.mouse;
            synchronized(class59.mouse) {
               class59.field729 = class59.field743;
               class59.field730 = class59.mouseX;
               class59.field731 = class59.mouseY;
               class59.field736 = class59.field744;
               class59.field737 = class59.field733;
               class59.field732 = class59.field734;
               class59.field739 = class59.field728;
               class59.field744 = 0;
            }

            if(class36.field517 != null) {
               var6 = class36.field517.vmethod2858();
               field1186 = var6;
            }

            if(gameState == 0) {
               class24.load();
               GameEngine.field707.vmethod2872();

               for(var6 = 0; var6 < 32; ++var6) {
                  GameEngine.field702[var6] = 0L;
               }

               for(var6 = 0; var6 < 32; ++var6) {
                  GameEngine.field703[var6] = 0L;
               }

               GameEngine.field697 = 0;
            } else if(gameState == 5) {
               class7.method35(this);
               class24.load();
               GameEngine.field707.vmethod2872();

               for(var6 = 0; var6 < 32; ++var6) {
                  GameEngine.field702[var6] = 0L;
               }

               for(var6 = 0; var6 < 32; ++var6) {
                  GameEngine.field703[var6] = 0L;
               }

               GameEngine.field697 = 0;
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  class7.method35(this);
                  this.method1109();
               } else if(gameState == 25) {
                  class165.method2968();
               }
            } else {
               class7.method35(this);
            }

            if(gameState == 30) {
               this.method1234();
            } else if(gameState == 40 || gameState == 45) {
               this.method1109();
            }

            return;
         }

         var3.data.method4100(var3.index, (int)var3.hash, var3.field3210, false);
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-112"
   )
   protected final void vmethod1104(boolean var1) {
      boolean var2;
      label137: {
         try {
            if(class203.field2517 == 2) {
               if(class98.field1522 == null) {
                  class98.field1522 = Track1.method3800(class203.field2518, class203.field2519, class29.field438);
                  if(class98.field1522 == null) {
                     var2 = false;
                     break label137;
                  }
               }

               if(class46.field604 == null) {
                  class46.field604 = new class112(class203.field2515, class203.field2514);
               }

               if(class203.field2516.method3575(class98.field1522, class203.field2513, class46.field604, 22050)) {
                  class203.field2516.method3576();
                  class203.field2516.method3592(class182.field2455);
                  class203.field2516.method3578(class98.field1522, class88.field1384);
                  class203.field2517 = 0;
                  class98.field1522 = null;
                  class46.field604 = null;
                  class203.field2518 = null;
                  var2 = true;
                  break label137;
               }
            }
         } catch (Exception var4) {
            var4.printStackTrace();
            class203.field2516.method3579();
            class203.field2517 = 0;
            class98.field1522 = null;
            class46.field604 = null;
            class203.field2518 = null;
         }

         var2 = false;
      }

      if(var2 && field1143 && class134.field2003 != null) {
         class134.field2003.method1961();
      }

      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field1119 && class166.method2970() > field1119) {
         WorldMapType2.method508(class241.getResizableValue());
      }

      int var3;
      if(var1) {
         for(var3 = 0; var3 < 100; ++var3) {
            field1111[var3] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class92.loadingBarPercentage, class92.loadingText, var1);
      } else if(gameState == 5) {
         class33.drawLoginScreen(class64.field788, class5.field39, WallObject.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class33.drawLoginScreen(class64.field788, class5.field39, WallObject.font_p12full, var1);
         } else if(gameState == 25) {
            if(field1113 == 1) {
               if(field1117 > field961) {
                  field961 = field1117;
               }

               var3 = (field961 * 50 - field1117 * 50) / field961;
               class158.drawStatusBox("Loading - please wait.<br> (" + var3 + "%)", false);
            } else if(field1113 == 2) {
               if(field1127 > field1023) {
                  field1023 = field1127;
               }

               var3 = (field1023 * 50 - field1127 * 50) / field1023 + 50;
               class158.drawStatusBox("Loading - please wait.<br> (" + var3 + "%)", false);
            } else {
               class158.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1334();
         } else if(gameState == 40) {
            class158.drawStatusBox("Connection lost<br>Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class158.drawStatusBox("Please wait...", false);
         }
      } else {
         class33.drawLoginScreen(class64.field788, class5.field39, WallObject.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1) {
         for(var3 = 0; var3 < field1109; ++var3) {
            if(field1112[var3]) {
               World.field1296.vmethod4896(widgetPositionX[var3], widgetPositionY[var3], widgetBoundsWidth[var3], widgetBoundsHeight[var3]);
               field1112[var3] = false;
            }
         }
      } else if(gameState > 0) {
         World.field1296.vmethod4897(0, 0);

         for(var3 = 0; var3 < field1109; ++var3) {
            field1112[var3] = false;
         }
      }

   }

   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "12954743"
   )
   void method1106() {
      if(gameState != 1000) {
         boolean var1 = SceneTilePaint.method2574();
         if(!var1) {
            this.method1107();
         }
      }

   }

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-950782092"
   )
   void method1107() {
      if(class238.field3275 >= 4) {
         this.method816("js5crc");
         gameState = 1000;
      } else {
         if(class238.field3276 >= 4) {
            if(gameState <= 5) {
               this.method816("js5io");
               gameState = 1000;
               return;
            }

            field1021 = 3000;
            class238.field3276 = 3;
         }

         if(--field1021 + 1 <= 0) {
            try {
               if(field1185 == 0) {
                  class59.field726 = GameEngine.field691.method2842(class40.host, Buffer.field2411);
                  ++field1185;
               }

               if(field1185 == 1) {
                  if(class59.field726.status == 2) {
                     this.method1158(-1);
                     return;
                  }

                  if(class59.field726.status == 1) {
                     ++field1185;
                  }
               }

               if(field1185 == 2) {
                  class2.rssocket = new RSSocket((Socket)class59.field726.field2241, GameEngine.field691);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(145);
                  class2.rssocket.queueForWrite(var1.payload, 0, 5);
                  ++field1185;
                  field933 = class166.method2970();
               }

               if(field1185 == 3) {
                  if(gameState > 5 && class2.rssocket.available() <= 0) {
                     if(class166.method2970() - field933 > 30000L) {
                        this.method1158(-2);
                        return;
                     }
                  } else {
                     int var3 = class2.rssocket.readByte();
                     if(var3 != 0) {
                        this.method1158(var3);
                        return;
                     }

                     ++field1185;
                  }
               }

               if(field1185 == 4) {
                  class134.method2489(class2.rssocket, gameState > 20);
                  class59.field726 = null;
                  class2.rssocket = null;
                  field1185 = 0;
                  field936 = 0;
               }
            } catch (IOException var2) {
               this.method1158(-3);
            }
         }
      }

   }

   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-527516913"
   )
   final void method1109() {
      try {
         if(loginState == 0) {
            if(WidgetNode.rssocket != null) {
               WidgetNode.rssocket.close();
               WidgetNode.rssocket = null;
            }

            class5.field38 = null;
            field958 = false;
            field938 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(class5.field38 == null) {
               class5.field38 = GameEngine.field691.method2842(class40.host, Buffer.field2411);
            }

            if(class5.field38.status == 2) {
               throw new IOException();
            }

            if(class5.field38.status == 1) {
               WidgetNode.rssocket = new RSSocket((Socket)class5.field38.field2241, GameEngine.field691);
               class5.field38 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(14);
            WidgetNode.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, 1);
            secretPacketBuffer2.offset = 0;
            loginState = 3;
         }

         int var1;
         if(loginState == 3) {
            if(class134.field2003 != null) {
               class134.field2003.method1913();
            }

            if(Player.field862 != null) {
               Player.field862.method1913();
            }

            var1 = WidgetNode.rssocket.readByte();
            if(class134.field2003 != null) {
               class134.field2003.method1913();
            }

            if(Player.field862 != null) {
               Player.field862.method1913();
            }

            if(var1 != 0) {
               MessageNode.method1058(var1);
               return;
            }

            secretPacketBuffer2.offset = 0;
            loginState = 4;
         }

         if(loginState == 4) {
            if(secretPacketBuffer2.offset < 8) {
               var1 = WidgetNode.rssocket.available();
               if(var1 > 8 - secretPacketBuffer2.offset) {
                  var1 = 8 - secretPacketBuffer2.offset;
               }

               if(var1 > 0) {
                  WidgetNode.rssocket.read(secretPacketBuffer2.payload, secretPacketBuffer2.offset, var1);
                  secretPacketBuffer2.offset += var1;
               }
            }

            if(secretPacketBuffer2.offset == 8) {
               secretPacketBuffer2.offset = 0;
               class11.field272 = secretPacketBuffer2.readLong();
               loginState = 5;
            }
         }

         int var2;
         int var3;
         if(loginState == 5) {
            int[] var4 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class11.field272 >> 32), (int)(class11.field272 & -1L)};
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(1);
            secretPacketBuffer1.putByte(class92.field1438.rsOrdinal());
            secretPacketBuffer1.putInt(var4[0]);
            secretPacketBuffer1.putInt(var4[1]);
            secretPacketBuffer1.putInt(var4[2]);
            secretPacketBuffer1.putInt(var4[3]);
            switch(class92.field1438.field2210) {
            case 0:
            case 2:
               secretPacketBuffer1.put24bitInt(World.authCodeForLogin);
               secretPacketBuffer1.offset += 5;
               break;
            case 1:
               secretPacketBuffer1.offset += 8;
               break;
            case 3:
               secretPacketBuffer1.putInt(((Integer)Item.field1481.preferences.get(Integer.valueOf(class96.method1689(class92.username)))).intValue());
               secretPacketBuffer1.offset += 4;
            }

            secretPacketBuffer1.method3125(class92.password);
            secretPacketBuffer1.encryptRsa(class90.rsaKeyExponent, class90.rsaKeyModulus);
            field907.offset = 0;
            if(gameState == 40) {
               field907.putByte(18);
            } else {
               field907.putByte(16);
            }

            field907.putShort(0);
            var2 = field907.offset;
            field907.putInt(145);
            field907.putBytes(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
            var3 = field907.offset;
            field907.method3125(class92.username);
            field907.putByte((isResized?1:0) << 1 | (field1055?1:0));
            field907.putShort(class10.canvasWidth);
            field907.putShort(class1.canvasHeight);
            class268.method4754(field907);
            field907.method3125(class219.field2810);
            field907.putInt(field908);
            Buffer var5 = new Buffer(class19.field337.method5228());
            class19.field337.method5233(var5);
            field907.putBytes(var5.payload, 0, var5.payload.length);
            field907.putByte(class20.field347);
            field907.putInt(0);
            field907.putInt(indexInterfaces.field3233);
            field907.putInt(indexSoundEffects.field3233);
            field907.putInt(class3.field24.field3233);
            field907.putInt(class9.field255.field3233);
            field907.putInt(class66.field799.field3233);
            field907.putInt(class177.indexMaps.field3233);
            field907.putInt(FaceNormal.indexTrack1.field3233);
            field907.putInt(class4.indexModels.field3233);
            field907.putInt(WorldMapType3.indexSprites.field3233);
            field907.putInt(class17.indexTextures.field3233);
            field907.putInt(FileOnDisk.field1763.field3233);
            field907.putInt(class11.indexTrack2.field3233);
            field907.putInt(class69.indexScripts.field3233);
            field907.putInt(class33.field476.field3233);
            field907.putInt(class219.field2807.field3233);
            field907.putInt(class164.field2329.field3233);
            field907.putInt(class3.indexWorldMap.field3233);
            field907.encryptXtea(var4, var3, field907.offset);
            field907.putShortLength(field907.offset - var2);
            WidgetNode.rssocket.queueForWrite(field907.payload, 0, field907.offset);
            secretPacketBuffer1.seed(var4);

            for(int var6 = 0; var6 < 4; ++var6) {
               var4[var6] += 50;
            }

            secretPacketBuffer2.seed(var4);
            loginState = 6;
         }

         if(loginState == 6 && WidgetNode.rssocket.available() > 0) {
            var1 = WidgetNode.rssocket.readByte();
            if(var1 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var1 == 2) {
               loginState = 9;
            } else if(var1 == 15 && gameState == 40) {
               packetLength = -1;
               loginState = 13;
            } else if(var1 == 23 && field939 < 1) {
               ++field939;
               loginState = 0;
            } else {
               if(var1 != 29) {
                  MessageNode.method1058(var1);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && WidgetNode.rssocket.available() > 0) {
            field940 = (WidgetNode.rssocket.readByte() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field938 = 0;
            class47.method674("You have only just left another world.", "Your profile will be transferred in:", field940 / 60 + " seconds.");
            if(--field940 <= 0) {
               loginState = 0;
            }
         } else {
            boolean var10;
            if(loginState == 9 && WidgetNode.rssocket.available() >= 13) {
               boolean var11 = WidgetNode.rssocket.readByte() == 1;
               WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, 4);
               secretPacketBuffer2.offset = 0;
               var10 = false;
               if(var11) {
                  var2 = secretPacketBuffer2.readOpcode() << 24;
                  var2 |= secretPacketBuffer2.readOpcode() << 16;
                  var2 |= secretPacketBuffer2.readOpcode() << 8;
                  var2 |= secretPacketBuffer2.readOpcode();
                  var3 = class96.method1689(class92.username);
                  if(Item.field1481.preferences.size() >= 10 && !Item.field1481.preferences.containsKey(Integer.valueOf(var3))) {
                     Iterator var15 = Item.field1481.preferences.entrySet().iterator();
                     var15.next();
                     var15.remove();
                  }

                  Item.field1481.preferences.put(Integer.valueOf(var3), Integer.valueOf(var2));
                  class5.method16();
               }

               rights = WidgetNode.rssocket.readByte();
               field1075 = WidgetNode.rssocket.readByte() == 1;
               localInteractingIndex = WidgetNode.rssocket.readByte();
               localInteractingIndex <<= 8;
               localInteractingIndex += WidgetNode.rssocket.readByte();
               field1176 = WidgetNode.rssocket.readByte();
               WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();

               try {
                  Client var16 = class220.field2817;
                  JSObject.getWindow(var16).call("zap", (Object[])null);
               } catch (Throwable var8) {
                  ;
               }

               loginState = 10;
            }

            if(loginState != 10) {
               if(loginState == 11 && WidgetNode.rssocket.available() >= 2) {
                  secretPacketBuffer2.offset = 0;
                  WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                  secretPacketBuffer2.offset = 0;
                  class47.field614 = secretPacketBuffer2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && WidgetNode.rssocket.available() >= class47.field614) {
                  secretPacketBuffer2.offset = 0;
                  WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, class47.field614);
                  secretPacketBuffer2.offset = 0;
                  String var12 = secretPacketBuffer2.readString();
                  String var17 = secretPacketBuffer2.readString();
                  String var7 = secretPacketBuffer2.readString();
                  class47.method674(var12, var17, var7);
                  class23.setGameState(10);
               }

               if(loginState == 13) {
                  if(packetLength == -1) {
                     if(WidgetNode.rssocket.available() < 2) {
                        return;
                     }

                     WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                     secretPacketBuffer2.offset = 0;
                     packetLength = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(WidgetNode.rssocket.available() >= packetLength) {
                     WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                     secretPacketBuffer2.offset = 0;
                     var1 = packetLength;
                     Tile.method2390();
                     class60.method965(secretPacketBuffer2);
                     if(var1 != secretPacketBuffer2.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field938;
                  if(field938 > 2000) {
                     if(field939 < 1) {
                        if(class47.field610 == Buffer.field2411) {
                           Buffer.field2411 = class87.field1373;
                        } else {
                           Buffer.field2411 = class47.field610;
                        }

                        ++field939;
                        loginState = 0;
                     } else {
                        MessageNode.method1058(-3);
                     }
                  }
               }
            } else if(WidgetNode.rssocket.available() >= packetLength) {
               secretPacketBuffer2.offset = 0;
               WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
               field1028 = -1L;
               field916 = -1;
               field913.field843 = 0;
               class89.field1390 = true;
               field1008 = true;
               field1130 = -1L;
               class280.field3749 = new CombatInfoList();
               secretPacketBuffer1.offset = 0;
               secretPacketBuffer2.offset = 0;
               packetType = -1;
               field1100 = 1;
               field955 = -1;
               field956 = -1;
               field952 = 0;
               field919 = 0;
               field957 = 0;
               field920 = 0;
               menuOptionCount = 0;
               field1053 = -1;
               isMenuOpen = false;
               class35.method481(0);
               class98.chatLineMap.clear();
               class98.field1517.method3391();
               class98.field1523.method3555();
               class98.field1518 = 0;
               itemSelectionState = 0;
               field1061 = false;
               field931 = 0;
               field969 = (int)(Math.random() * 100.0D) - 50;
               field971 = (int)(Math.random() * 110.0D) - 55;
               field1114 = (int)(Math.random() * 80.0D) - 40;
               mapScale = (int)(Math.random() * 120.0D) - 60;
               mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
               mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
               field1087 = 0;
               field944 = -1;
               destinationX = 0;
               destinationY = 0;
               field928 = class91.field1410;
               field910 = class91.field1410;
               field930 = 0;
               ChatLineBuffer.method1770();

               for(var1 = 0; var1 < 2048; ++var1) {
                  cachedPlayers[var1] = null;
               }

               for(var1 = 0; var1 < '耀'; ++var1) {
                  cachedNPCs[var1] = null;
               }

               field1035 = -1;
               projectiles.method3481();
               field1033.method3481();

               for(var1 = 0; var1 < 4; ++var1) {
                  for(var2 = 0; var2 < 104; ++var2) {
                     for(var3 = 0; var3 < 104; ++var3) {
                        groundItemDeque[var1][var2][var3] = null;
                     }
                  }
               }

               pendingSpawns = new Deque();
               field1172 = 0;
               friendCount = 0;
               ignoreCount = 0;

               for(var1 = 0; var1 < class241.field3292; ++var1) {
                  class241 var13 = class25.method203(var1);
                  if(var13 != null) {
                     class211.settings[var1] = 0;
                     class211.widgetSettings[var1] = 0;
                  }
               }

               class66.chatMessages.method1705();
               field948 = -1;
               if(widgetRoot != -1) {
                  var1 = widgetRoot;
                  if(var1 != -1 && class18.validInterfaces[var1]) {
                     class2.field15.method4043(var1);
                     if(Widget.widgets[var1] != null) {
                        var10 = true;

                        for(var3 = 0; var3 < Widget.widgets[var1].length; ++var3) {
                           if(Widget.widgets[var1][var3] != null) {
                              if(Widget.widgets[var1][var3].type != 2) {
                                 Widget.widgets[var1][var3] = null;
                              } else {
                                 var10 = false;
                              }
                           }
                        }

                        if(var10) {
                           Widget.widgets[var1] = null;
                        }

                        class18.validInterfaces[var1] = false;
                     }
                  }
               }

               for(WidgetNode var14 = (WidgetNode)componentTable.method3435(); var14 != null; var14 = (WidgetNode)componentTable.method3429()) {
                  class67.method1027(var14, true);
               }

               widgetRoot = -1;
               componentTable = new XHashTable(8);
               field1070 = null;
               menuOptionCount = 0;
               field1053 = -1;
               isMenuOpen = false;
               field1177.method3840((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

               for(var1 = 0; var1 < 8; ++var1) {
                  playerOptions[var1] = null;
                  playerOptionsPriorities[var1] = false;
               }

               XItemContainer.itemContainers = new XHashTable(32);
               field960 = true;

               for(var1 = 0; var1 < 100; ++var1) {
                  field1111[var1] = true;
               }

               class66.method1024();
               clanChatOwner = null;
               XGrandExchangeOffer.clanChatCount = 0;
               class177.clanMembers = null;

               for(var1 = 0; var1 < 8; ++var1) {
                  grandExchangeOffers[var1] = new XGrandExchangeOffer();
               }

               field1181 = null;
               class60.method965(secretPacketBuffer2);
               class34.field501 = -1;
               class23.xteaChanged(false);
               packetType = -1;
            }
         }
      } catch (IOException var9) {
         if(field939 < 1) {
            if(class47.field610 == Buffer.field2411) {
               Buffer.field2411 = class87.field1373;
            } else {
               Buffer.field2411 = class47.field610;
            }

            ++field939;
            loginState = 0;
         } else {
            MessageNode.method1058(-2);
         }
      }

   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-6"
   )
   void method1112() {
      int var1 = class10.canvasWidth;
      int var2 = class1.canvasHeight;
      if(super.field704 < var1) {
         var1 = super.field704;
      }

      if(super.field705 < var2) {
         var2 = super.field705;
      }

      if(Item.field1481 != null) {
         try {
            class52.method733(class220.field2817, "resize", new Object[]{Integer.valueOf(class241.getResizableValue())});
         } catch (Throwable var4) {
            ;
         }
      }

   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-657973975"
   )
   final void method1115() {
      WorldMapType3.method221();
      if(class165.field2335 == null && field1079 == null) {
         int var1;
         int var2;
         int var3;
         int var4;
         label231: {
            int var5 = class59.field736;
            int var6;
            int var7;
            int var8;
            int var9;
            if(isMenuOpen) {
               if(var5 != 1 && (class221.field2845 || var5 != 4)) {
                  var1 = class59.field730;
                  var6 = class59.field731;
                  if(var1 < class109.menuX - 10 || var1 > Signlink.menuWidth + class109.menuX + 10 || var6 < class24.menuY - 10 || var6 > class37.menuHeight + class24.menuY + 10) {
                     isMenuOpen = false;
                     ChatLineBuffer.method1777(class109.menuX, class24.menuY, Signlink.menuWidth, class37.menuHeight);
                  }
               }

               if(var5 == 1 || !class221.field2845 && var5 == 4) {
                  var1 = class109.menuX;
                  var6 = class24.menuY;
                  var2 = Signlink.menuWidth;
                  var3 = class59.field737;
                  var7 = class59.field732;
                  int var18 = -1;

                  for(var8 = 0; var8 < menuOptionCount; ++var8) {
                     var4 = var6 + 31 + (menuOptionCount - 1 - var8) * 15;
                     if(var3 > var1 && var3 < var2 + var1 && var7 > var4 - 13 && var7 < var4 + 3) {
                        var18 = var8;
                     }
                  }

                  if(var18 != -1 && var18 >= 0) {
                     var8 = menuActionParams0[var18];
                     var4 = menuActionParams1[var18];
                     var9 = menuTypes[var18];
                     int var17 = menuIdentifiers[var18];
                     String var19 = menuOptions[var18];
                     String var13 = menuTargets[var18];
                     class116.menuAction(var8, var4, var9, var17, var19, var13, class59.field737, class59.field732);
                  }

                  isMenuOpen = false;
                  ChatLineBuffer.method1777(class109.menuX, class24.menuY, Signlink.menuWidth, class37.menuHeight);
               }
            } else {
               var1 = class230.method3976();
               if((var5 == 1 || !class221.field2845 && var5 == 4) && var1 >= 0) {
                  var6 = menuTypes[var1];
                  if(var6 == 39 || var6 == 40 || var6 == 41 || var6 == 42 || var6 == 43 || var6 == 33 || var6 == 34 || var6 == 35 || var6 == 36 || var6 == 37 || var6 == 38 || var6 == 1005) {
                     var2 = menuActionParams0[var1];
                     var3 = menuActionParams1[var1];
                     Widget var10 = class223.method3959(var3);
                     var8 = class15.method92(var10);
                     boolean var11 = (var8 >> 28 & 1) != 0;
                     if(var11) {
                        break label231;
                     }

                     var9 = class15.method92(var10);
                     boolean var12 = (var9 >> 29 & 1) != 0;
                     if(var12) {
                        break label231;
                     }
                  }
               }

               if(var5 == 1 || !class221.field2845 && var5 == 4) {
                  label237: {
                     label150: {
                        if(field1043 == 1 && menuOptionCount > 2) {
                           boolean var14;
                           if(menuOptionCount <= 0) {
                              var14 = false;
                           } else if(field989 && class50.field660[81] && field1053 != -1) {
                              var14 = true;
                           } else {
                              var14 = false;
                           }

                           if(!var14) {
                              break label150;
                           }
                        }

                        if(!WorldMapData.method351(var1)) {
                           break label237;
                        }
                     }

                     var5 = 2;
                  }
               }

               if((var5 == 1 || !class221.field2845 && var5 == 4) && menuOptionCount > 0 && var1 >= 0) {
                  var6 = menuActionParams0[var1];
                  var2 = menuActionParams1[var1];
                  var3 = menuTypes[var1];
                  var7 = menuIdentifiers[var1];
                  String var16 = menuOptions[var1];
                  String var15 = menuTargets[var1];
                  class116.menuAction(var6, var2, var3, var7, var16, var15, class59.field737, class59.field732);
               }

               if(var5 == 2 && menuOptionCount > 0) {
                  this.method1116(class59.field737, class59.field732);
               }
            }

            return;
         }

         if(class165.field2335 != null && !field1107) {
            var4 = class230.method3976();
            if(field1043 != 1 && !WorldMapData.method351(var4) && menuOptionCount > 0) {
               MessageNode.method1057(field911, field985);
            }
         }

         field1107 = false;
         field1024 = 0;
         if(class165.field2335 != null) {
            XItemContainer.method1020(class165.field2335);
         }

         class165.field2335 = class223.method3959(var3);
         field1019 = var2;
         field911 = class59.field737;
         field985 = class59.field732;
         if(var1 >= 0) {
            class10.method58(var1);
         }

         XItemContainer.method1020(class165.field2335);
      }

   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1207835891"
   )
   final void method1116(int var1, int var2) {
      int var3 = class64.field788.method4696("Choose Option");

      int var4;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         Font var5 = class64.field788;
         String var6;
         if(var4 < 0) {
            var6 = "";
         } else if(menuTargets[var4].length() > 0) {
            var6 = menuOptions[var4] + " " + menuTargets[var4];
         } else {
            var6 = menuOptions[var4];
         }

         int var7 = var5.method4696(var6);
         if(var7 > var3) {
            var3 = var7;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      int var8 = var1 - var3 / 2;
      if(var3 + var8 > class10.canvasWidth) {
         var8 = class10.canvasWidth - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var9 = var2;
      if(var2 + var4 > class1.canvasHeight) {
         var9 = class1.canvasHeight - var4;
      }

      if(var9 < 0) {
         var9 = 0;
      }

      class17.region.method2615(Player.plane, var1, var2, false);
      isMenuOpen = true;
      class109.menuX = var8;
      class24.menuY = var9;
      Signlink.menuWidth = var3;
      class37.menuHeight = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "472629888"
   )
   void method1118(Widget var1) {
      Widget var2 = var1.parentId == -1?null:class223.method3959(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = class10.canvasWidth;
         var4 = class1.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      Spotanim.method4223(var1, var3, var4, false);
      class152.method2814(var1, var3, var4);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1614382627"
   )
   protected final void vmethod1123() {
      class47.field610 = field1161 == 0?'ꩊ':world + '鱀';
      class87.field1373 = field1161 == 0?443:world + '썐';
      Buffer.field2411 = class47.field610;
      PlayerComposition.field2629 = class214.field2640;
      class8.field249 = class214.field2639;
      PlayerComposition.field2630 = class214.field2637;
      class7.field240 = class214.field2638;
      this.method800();
      this.method835();
      class36.field517 = this.method810();
      class9.field254 = new IndexFile(255, class155.field2262, class155.field2263, 500000);
      FileOnDisk var1 = null;
      Preferences var2 = new Preferences();

      try {
         var1 = TextureProvider.getPreferencesFile("", field1169.field3200, false);
         byte[] var3 = new byte[(int)var1.method2266()];

         int var4;
         for(int var5 = 0; var5 < var3.length; var5 += var4) {
            var4 = var1.method2267(var3, var5, var3.length - var5);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var2 = new Preferences(new Buffer(var3));
      } catch (Exception var7) {
         ;
      }

      try {
         if(var1 != null) {
            var1.method2274();
         }
      } catch (Exception var6) {
         ;
      }

      Item.field1481 = var2;
      this.method798();
      class95.method1681(this, class71.field845);
      if(field1161 != 0) {
         field918 = true;
      }

      WorldMapType2.method508(Item.field1481.field1303);
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2037461536"
   )
   final void method1138() {
      XItemContainer.method1020(field1079);
      ++class33.field478;
      if(field980 && field1084) {
         int var1 = class59.field730;
         int var2 = class59.field731;
         var1 -= field1081;
         var2 -= field1082;
         if(var1 < field1093) {
            var1 = field1093;
         }

         if(var1 + field1079.width > field1093 + field1080.width) {
            var1 = field1093 + field1080.width - field1079.width;
         }

         if(var2 < field1086) {
            var2 = field1086;
         }

         if(var2 + field1079.height > field1086 + field1080.height) {
            var2 = field1086 + field1080.height - field1079.height;
         }

         int var3 = var1 - field981;
         int var4 = var2 - field1089;
         int var5 = field1079.field2730;
         if(class33.field478 > field1079.field2717 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1090 = true;
         }

         int var6 = var1 - field1093 + field1080.scrollX;
         int var7 = var2 - field1086 + field1080.scrollY;
         class69 var8;
         if(field1079.field2743 != null && field1090) {
            var8 = new class69();
            var8.field822 = field1079;
            var8.field823 = var6;
            var8.field835 = var7;
            var8.field821 = field1079.field2743;
            class77.method1440(var8);
         }

         if(class59.field729 == 0) {
            if(field1090) {
               if(field1079.field2744 != null) {
                  var8 = new class69();
                  var8.field822 = field1079;
                  var8.field823 = var6;
                  var8.field835 = var7;
                  var8.field829 = field963;
                  var8.field821 = field1079.field2744;
                  class77.method1440(var8);
               }

               if(field963 != null && class60.method969(field1079) != null) {
                  secretPacketBuffer1.putOpcode(97);
                  secretPacketBuffer1.putIntOb1(field963.id);
                  secretPacketBuffer1.putShortLE(field963.index);
                  secretPacketBuffer1.putShortOb2(field1079.index);
                  secretPacketBuffer1.putIntOb1(field1079.id);
                  secretPacketBuffer1.putShort(field963.itemId);
                  secretPacketBuffer1.putShortOb2(field1079.itemId);
               }
            } else {
               label117: {
                  int var9 = class230.method3976();
                  if(menuOptionCount > 2) {
                     label113: {
                        label78: {
                           if(field1043 == 1) {
                              boolean var10;
                              if(menuOptionCount <= 0) {
                                 var10 = false;
                              } else if(field989 && class50.field660[81] && field1053 != -1) {
                                 var10 = true;
                              } else {
                                 var10 = false;
                              }

                              if(!var10) {
                                 break label78;
                              }
                           }

                           if(!WorldMapData.method351(var9)) {
                              break label113;
                           }
                        }

                        this.method1116(field1081 + field981, field1082 + field1089);
                        break label117;
                     }
                  }

                  if(menuOptionCount > 0) {
                     MessageNode.method1057(field1081 + field981, field1082 + field1089);
                  }
               }
            }

            field1079 = null;
         }
      } else if(class33.field478 > 1) {
         field1079 = null;
      }

   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-34"
   )
   final void method1151(boolean var1) {
      int var2 = widgetRoot;
      int var3 = class10.canvasWidth;
      int var4 = class1.canvasHeight;
      if(class59.method961(var2)) {
         XClanMember.method1097(Widget.widgets[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "62"
   )
   void method1158(int var1) {
      class59.field726 = null;
      class2.rssocket = null;
      field1185 = 0;
      if(class47.field610 == Buffer.field2411) {
         Buffer.field2411 = class87.field1373;
      } else {
         Buffer.field2411 = class47.field610;
      }

      ++field936;
      if(field936 < 2 || var1 != 7 && var1 != 9) {
         if(field936 >= 2 && var1 == 6) {
            this.method816("js5connect_outofdate");
            gameState = 1000;
         } else if(field936 >= 4) {
            if(gameState <= 5) {
               this.method816("js5connect");
               gameState = 1000;
            } else {
               field1021 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method816("js5connect_full");
         gameState = 1000;
      } else {
         field1021 = 3000;
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2137821127"
   )
   protected final void vmethod1221() {
      if(class66.chatMessages.method1710()) {
         class66.chatMessages.method1707();
      }

      if(field913 != null) {
         field913.field840 = false;
      }

      field913 = null;
      if(WidgetNode.rssocket != null) {
         WidgetNode.rssocket.close();
         WidgetNode.rssocket = null;
      }

      class116.method2024();
      if(class59.mouse != null) {
         class59 var1 = class59.mouse;
         class59 var2 = class59.mouse;
         class59 var3 = class59.mouse;
         synchronized(class59.mouse) {
            class59.mouse = null;
         }
      }

      class36.field517 = null;
      if(class134.field2003 != null) {
         class134.field2003.method1950();
      }

      if(Player.field862 != null) {
         Player.field862.method1950();
      }

      if(class238.field3258 != null) {
         class238.field3258.close();
      }

      NPCComposition.method4541();
      class87.method1605();
   }

   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "398519192"
   )
   final void method1234() {
      if(field919 > 1) {
         --field919;
      }

      if(field957 > 0) {
         --field957;
      }

      if(field958) {
         field958 = false;
         if(field957 > 0) {
            TextureProvider.method2306();
         } else {
            class23.setGameState(40);
            class222.field2846 = WidgetNode.rssocket;
            WidgetNode.rssocket = null;
         }
      } else {
         if(!isMenuOpen) {
            menuOptionCount = 0;
            field1053 = -1;
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
            while(class18.method149()) {
               secretPacketBuffer1.putOpcode(160);
               secretPacketBuffer1.putByte(0);
               var1 = secretPacketBuffer1.offset;
               class241.method4168(secretPacketBuffer1);
               secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var1);
            }

            Object var2 = field913.field841;
            Object var3 = field913.field841;
            Object var12 = field913.field841;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            synchronized(field913.field841) {
               if(!field1122) {
                  field913.field843 = 0;
               } else if(class59.field736 != 0 || field913.field843 >= 40) {
                  secretPacketBuffer1.putOpcode(168);
                  secretPacketBuffer1.putByte(0);
                  var4 = secretPacketBuffer1.offset;
                  var5 = 0;

                  for(var6 = 0; var6 < field913.field843 && secretPacketBuffer1.offset - var4 < 240; ++var6) {
                     ++var5;
                     var7 = field913.field844[var6];
                     if(var7 < 0) {
                        var7 = 0;
                     } else if(var7 > 502) {
                        var7 = 502;
                     }

                     var8 = field913.field842[var6];
                     if(var8 < 0) {
                        var8 = 0;
                     } else if(var8 > 764) {
                        var8 = 764;
                     }

                     var9 = var8 + var7 * 765;
                     if(field913.field844[var6] == -1 && field913.field842[var6] == -1) {
                        var8 = -1;
                        var7 = -1;
                        var9 = 524287;
                     }

                     if(var8 == field914 && var7 == field915) {
                        if(field916 < 2047) {
                           ++field916;
                        }
                     } else {
                        var10 = var8 - field914;
                        field914 = var8;
                        var11 = var7 - field915;
                        field915 = var7;
                        if(field916 < 8 && var10 >= -32 && var10 <= 31 && var11 >= -32 && var11 <= 31) {
                           var10 += 32;
                           var11 += 32;
                           secretPacketBuffer1.putShort(var11 + (field916 << 12) + (var10 << 6));
                           field916 = 0;
                        } else if(field916 < 8) {
                           secretPacketBuffer1.put24bitInt((field916 << 19) + 8388608 + var9);
                           field916 = 0;
                        } else {
                           secretPacketBuffer1.putInt((field916 << 19) + -1073741824 + var9);
                           field916 = 0;
                        }
                     }
                  }

                  secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var4);
                  if(var5 >= field913.field843) {
                     field913.field843 = 0;
                  } else {
                     field913.field843 -= var5;

                     for(var6 = 0; var6 < field913.field843; ++var6) {
                        field913.field842[var6] = field913.field842[var5 + var6];
                        field913.field844[var6] = field913.field844[var5 + var6];
                     }
                  }
               }
            }

            long var26;
            if(class59.field736 == 1 || !class221.field2845 && class59.field736 == 4 || class59.field736 == 2) {
               var26 = (class59.field739 - field1028) / 50L;
               if(var26 > 4095L) {
                  var26 = 4095L;
               }

               field1028 = class59.field739;
               var5 = class59.field732;
               if(var5 < 0) {
                  var5 = 0;
               } else if(var5 > class1.canvasHeight) {
                  var5 = class1.canvasHeight;
               }

               var6 = class59.field737;
               if(var6 < 0) {
                  var6 = 0;
               } else if(var6 > class10.canvasWidth) {
                  var6 = class10.canvasWidth;
               }

               var7 = (int)var26;
               secretPacketBuffer1.putOpcode(101);
               secretPacketBuffer1.putShort((class59.field736 == 2?1:0) + (var7 << 1));
               secretPacketBuffer1.putShort(var6);
               secretPacketBuffer1.putShort(var5);
            }

            if(class50.field657 > 0) {
               secretPacketBuffer1.putOpcode(172);
               secretPacketBuffer1.putShort(0);
               var1 = secretPacketBuffer1.offset;
               var26 = class166.method2970();

               for(var6 = 0; var6 < class50.field657; ++var6) {
                  long var14 = var26 - field1130;
                  if(var14 > 16777215L) {
                     var14 = 16777215L;
                  }

                  field1130 = var26;
                  secretPacketBuffer1.putMedOb1((int)var14);
                  secretPacketBuffer1.putByteNegated(class50.field656[var6]);
               }

               secretPacketBuffer1.putShortLength(secretPacketBuffer1.offset - var1);
            }

            if(field996 > 0) {
               --field996;
            }

            if(class50.field660[96] || class50.field660[97] || class50.field660[98] || class50.field660[99]) {
               field1083 = true;
            }

            if(field1083 && field996 <= 0) {
               field996 = 20;
               field1083 = false;
               secretPacketBuffer1.putOpcode(51);
               secretPacketBuffer1.putShort(mapAngle);
               secretPacketBuffer1.putShortLE(field1159);
            }

            if(class89.field1390 && !field1008) {
               field1008 = true;
               secretPacketBuffer1.putOpcode(241);
               secretPacketBuffer1.putByte(1);
            }

            if(!class89.field1390 && field1008) {
               field1008 = false;
               secretPacketBuffer1.putOpcode(241);
               secretPacketBuffer1.putByte(0);
            }

            class92.method1652();
            if(gameState == 30) {
               SceneTilePaint.method2573();

               for(var1 = 0; var1 < field931; ++var1) {
                  --field1150[var1];
                  if(field1150[var1] >= -10) {
                     SoundEffect var27 = audioEffects[var1];
                     class107 var15;
                     if(var27 == null) {
                        var15 = null;
                        var27 = SoundEffect.method1843(class66.field799, field1036[var1], 0);
                        if(var27 == null) {
                           continue;
                        }

                        field1150[var1] += var27.method1838();
                        audioEffects[var1] = var27;
                     }

                     if(field1150[var1] < 0) {
                        if(field1170[var1] != 0) {
                           var6 = (field1170[var1] & 255) * 128;
                           var7 = field1170[var1] >> 16 & 255;
                           var8 = var7 * 128 + 64 - class20.localPlayer.x;
                           if(var8 < 0) {
                              var8 = -var8;
                           }

                           var9 = field1170[var1] >> 8 & 255;
                           var10 = var9 * 128 + 64 - class20.localPlayer.y;
                           if(var10 < 0) {
                              var10 = -var10;
                           }

                           var11 = var10 + var8 - 128;
                           if(var11 > var6) {
                              field1150[var1] = -100;
                              continue;
                           }

                           if(var11 < 0) {
                              var11 = 0;
                           }

                           var5 = (var6 - var11) * field1041 / var6;
                        } else {
                           var5 = field1144;
                        }

                        if(var5 > 0) {
                           var15 = var27.method1839().method1881(class59.field724);
                           class117 var16 = class117.method2038(var15, 100, var5);
                           var16.method2149(field1155[var1] - 1);
                           WorldMapType1.field442.method1806(var16);
                        }

                        field1150[var1] = -100;
                     }
                  } else {
                     --field931;

                     for(var4 = var1; var4 < field931; ++var4) {
                        field1036[var4] = field1036[var4 + 1];
                        audioEffects[var4] = audioEffects[var4 + 1];
                        field1155[var4] = field1155[var4 + 1];
                        field1150[var4] = field1150[var4 + 1];
                        field1170[var4] = field1170[var4 + 1];
                     }

                     --var1;
                  }
               }

               if(field1143) {
                  boolean var29;
                  if(class203.field2517 != 0) {
                     var29 = true;
                  } else {
                     var29 = class203.field2516.method3675();
                  }

                  if(!var29) {
                     if(field1141 != 0 && field1142 != -1) {
                        class13.method75(FaceNormal.indexTrack1, field1142, 0, field1141, false);
                     }

                     field1143 = false;
                  }
               }

               ++field952;
               if(field952 <= 750) {
                  var1 = class96.field1487;
                  int[] var33 = class96.field1491;

                  for(var5 = 0; var5 < var1; ++var5) {
                     Player var28 = cachedPlayers[var33[var5]];
                     if(var28 != null) {
                        WorldMapType1.method272(var28, 1);
                     }
                  }

                  class14.method88();
                  int[] var30 = class96.field1491;

                  for(var4 = 0; var4 < class96.field1487; ++var4) {
                     Player var31 = cachedPlayers[var30[var4]];
                     if(var31 != null && var31.field1234 > 0) {
                        --var31.field1234;
                        if(var31.field1234 == 0) {
                           var31.overhead = null;
                        }
                     }
                  }

                  for(var4 = 0; var4 < field930; ++var4) {
                     var5 = npcIndices[var4];
                     NPC var32 = cachedNPCs[var5];
                     if(var32 != null && var32.field1234 > 0) {
                        --var32.field1234;
                        if(var32.field1234 == 0) {
                           var32.overhead = null;
                        }
                     }
                  }

                  ++field1125;
                  if(cursorState != 0) {
                     field906 += 20;
                     if(field906 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class59.field735 != null) {
                     ++field1017;
                     if(field1017 >= 15) {
                        XItemContainer.method1020(class59.field735);
                        class59.field735 = null;
                     }
                  }

                  Widget var34 = Item.field1476;
                  Widget var17 = class12.field280;
                  Item.field1476 = null;
                  class12.field280 = null;
                  field963 = null;
                  field980 = false;
                  field1084 = false;
                  field1132 = 0;

                  while(class7.method34() && field1132 < 128) {
                     if(rights >= 2 && class50.field660[82] && class146.field2171 == 66) {
                        String var18 = class71.method1050();
                        class220.field2817.method813(var18);
                     } else {
                        field1038[field1132] = class146.field2171;
                        field1135[field1132] = class24.field376;
                        ++field1132;
                     }
                  }

                  if(widgetRoot != -1) {
                     class182.method3330(widgetRoot, 0, 0, class10.canvasWidth, class1.canvasHeight, 0, 0);
                  }

                  ++field1091;

                  while(true) {
                     class69 var19;
                     Widget var20;
                     Widget var35;
                     do {
                        var19 = (class69)field1106.method3485();
                        if(var19 == null) {
                           while(true) {
                              do {
                                 var19 = (class69)field1136.method3485();
                                 if(var19 == null) {
                                    while(true) {
                                       do {
                                          var19 = (class69)field1105.method3485();
                                          if(var19 == null) {
                                             this.method1115();
                                             class211.method3817();
                                             if(field1079 != null) {
                                                this.method1138();
                                             }

                                             if(class165.field2335 != null) {
                                                XItemContainer.method1020(class165.field2335);
                                                ++field1024;
                                                if(class59.field729 == 0) {
                                                   if(field1107) {
                                                      if(Projectile.field1475 == class165.field2335 && field1019 != field1022) {
                                                         Widget var36 = class165.field2335;
                                                         byte var22 = 0;
                                                         if(field1069 == 1 && var36.contentType == 206) {
                                                            var22 = 1;
                                                         }

                                                         if(var36.itemIds[field1022] <= 0) {
                                                            var22 = 0;
                                                         }

                                                         var8 = class15.method92(var36);
                                                         boolean var23 = (var8 >> 29 & 1) != 0;
                                                         if(var23) {
                                                            var9 = field1019;
                                                            var10 = field1022;
                                                            var36.itemIds[var10] = var36.itemIds[var9];
                                                            var36.itemQuantities[var10] = var36.itemQuantities[var9];
                                                            var36.itemIds[var9] = -1;
                                                            var36.itemQuantities[var9] = 0;
                                                         } else if(var22 == 1) {
                                                            var9 = field1019;
                                                            var10 = field1022;

                                                            while(var10 != var9) {
                                                               if(var9 > var10) {
                                                                  var36.method3929(var9 - 1, var9);
                                                                  --var9;
                                                               } else if(var9 < var10) {
                                                                  var36.method3929(var9 + 1, var9);
                                                                  ++var9;
                                                               }
                                                            }
                                                         } else {
                                                            var36.method3929(field1022, field1019);
                                                         }

                                                         secretPacketBuffer1.putOpcode(237);
                                                         secretPacketBuffer1.putShortOb1(field1022);
                                                         secretPacketBuffer1.putInt(class165.field2335.id);
                                                         secretPacketBuffer1.putShortOb2(field1019);
                                                         secretPacketBuffer1.putByteOb1(var22);
                                                      }
                                                   } else {
                                                      label928: {
                                                         var5 = class230.method3976();
                                                         if(menuOptionCount > 2) {
                                                            label914: {
                                                               label659: {
                                                                  if(field1043 == 1) {
                                                                     boolean var21;
                                                                     if(menuOptionCount <= 0) {
                                                                        var21 = false;
                                                                     } else if(field989 && class50.field660[81] && field1053 != -1) {
                                                                        var21 = true;
                                                                     } else {
                                                                        var21 = false;
                                                                     }

                                                                     if(!var21) {
                                                                        break label659;
                                                                     }
                                                                  }

                                                                  if(!WorldMapData.method351(var5)) {
                                                                     break label914;
                                                                  }
                                                               }

                                                               this.method1116(field911, field985);
                                                               break label928;
                                                            }
                                                         }

                                                         if(menuOptionCount > 0) {
                                                            MessageNode.method1057(field911, field985);
                                                         }
                                                      }
                                                   }

                                                   field1017 = 10;
                                                   class59.field736 = 0;
                                                   class165.field2335 = null;
                                                } else if(field1024 >= 5 && (class59.field730 > field911 + 5 || class59.field730 < field911 - 5 || class59.field731 > field985 + 5 || class59.field731 < field985 - 5)) {
                                                   field1107 = true;
                                                }
                                             }

                                             if(Region.method2617()) {
                                                var5 = Region.selectedRegionTileX;
                                                var6 = Region.selectedRegionTileY;
                                                secretPacketBuffer1.putOpcode(203);
                                                secretPacketBuffer1.putByte(5);
                                                secretPacketBuffer1.putShortOb1(var5 + class19.baseX);
                                                secretPacketBuffer1.putShortOb1(class21.baseY + var6);
                                                secretPacketBuffer1.putByteNegated(class50.field660[82]?(class50.field660[81]?2:1):0);
                                                Region.method2618();
                                                field1013 = class59.field737;
                                                field1115 = class59.field732;
                                                cursorState = 1;
                                                field906 = 0;
                                                destinationX = var5;
                                                destinationY = var6;
                                             }

                                             if(var34 != Item.field1476) {
                                                if(var34 != null) {
                                                   XItemContainer.method1020(var34);
                                                }

                                                if(Item.field1476 != null) {
                                                   XItemContainer.method1020(Item.field1476);
                                                }
                                             }

                                             if(var17 != class12.field280 && field917 == field1058) {
                                                if(var17 != null) {
                                                   XItemContainer.method1020(var17);
                                                }

                                                if(class12.field280 != null) {
                                                   XItemContainer.method1020(class12.field280);
                                                }
                                             }

                                             if(class12.field280 != null) {
                                                if(field917 < field1058) {
                                                   ++field917;
                                                   if(field917 == field1058) {
                                                      XItemContainer.method1020(class12.field280);
                                                   }
                                                }
                                             } else if(field917 > 0) {
                                                --field917;
                                             }

                                             var5 = field969 + class20.localPlayer.x;
                                             var6 = field971 + class20.localPlayer.y;
                                             if(class23.field367 - var5 < -500 || class23.field367 - var5 > 500 || DecorativeObject.field2178 - var6 < -500 || DecorativeObject.field2178 - var6 > 500) {
                                                class23.field367 = var5;
                                                DecorativeObject.field2178 = var6;
                                             }

                                             if(var5 != class23.field367) {
                                                class23.field367 += (var5 - class23.field367) / 16;
                                             }

                                             if(DecorativeObject.field2178 != var6) {
                                                DecorativeObject.field2178 += (var6 - DecorativeObject.field2178) / 16;
                                             }

                                             if(class59.field729 == 4 && class221.field2845) {
                                                var7 = class59.field731 - field994;
                                                field992 = var7 * 2;
                                                field994 = var7 != -1 && var7 != 1?(field994 + class59.field731) / 2:class59.field731;
                                                var8 = field1104 - class59.field730;
                                                field1088 = var8 * 2;
                                                field1104 = var8 != -1 && var8 != 1?(field1104 + class59.field730) / 2:class59.field730;
                                             } else {
                                                if(class50.field660[96]) {
                                                   field1088 += (-24 - field1088) / 2;
                                                } else if(class50.field660[97]) {
                                                   field1088 += (24 - field1088) / 2;
                                                } else {
                                                   field1088 /= 2;
                                                }

                                                if(class50.field660[98]) {
                                                   field992 += (12 - field992) / 2;
                                                } else if(class50.field660[99]) {
                                                   field992 += (-12 - field992) / 2;
                                                } else {
                                                   field992 /= 2;
                                                }

                                                field994 = class59.field731;
                                                field1104 = class59.field730;
                                             }

                                             mapAngle = field1088 / 2 + mapAngle & 2047;
                                             field1159 += field992 / 2;
                                             if(field1159 < 128) {
                                                field1159 = 128;
                                             }

                                             if(field1159 > 383) {
                                                field1159 = 383;
                                             }

                                             var7 = class23.field367 >> 7;
                                             var8 = DecorativeObject.field2178 >> 7;
                                             var9 = class77.method1438(class23.field367, DecorativeObject.field2178, Player.plane);
                                             var10 = 0;
                                             if(var7 > 3 && var8 > 3 && var7 < 100 && var8 < 100) {
                                                for(var11 = var7 - 4; var11 <= var7 + 4; ++var11) {
                                                   for(int var37 = var8 - 4; var37 <= var8 + 4; ++var37) {
                                                      int var40 = Player.plane;
                                                      if(var40 < 3 && (class61.tileSettings[1][var11][var37] & 2) == 2) {
                                                         ++var40;
                                                      }

                                                      int var38 = var9 - class61.tileHeights[var40][var11][var37];
                                                      if(var38 > var10) {
                                                         var10 = var38;
                                                      }
                                                   }
                                                }
                                             }

                                             var11 = var10 * 192;
                                             if(var11 > 98048) {
                                                var11 = 98048;
                                             }

                                             if(var11 < '耀') {
                                                var11 = '耀';
                                             }

                                             if(var11 > field998) {
                                                field998 += (var11 - field998) / 24;
                                             } else if(var11 < field998) {
                                                field998 += (var11 - field998) / 80;
                                             }

                                             if(field1152) {
                                                class219.method3949();
                                             }

                                             for(var5 = 0; var5 < 5; ++var5) {
                                                ++field982[var5];
                                             }

                                             class66.chatMessages.method1709();
                                             var5 = ++class59.mouseIdleTicks - 1;
                                             var7 = class50.keyboardIdleTicks;
                                             if(var5 > 15000 && var7 > 15000) {
                                                field957 = 250;
                                                class35.method481(14500);
                                                secretPacketBuffer1.putOpcode(45);
                                             }

                                             ++field975;
                                             if(field975 > 500) {
                                                field975 = 0;
                                                var9 = (int)(Math.random() * 8.0D);
                                                if((var9 & 1) == 1) {
                                                   field969 += field970;
                                                }

                                                if((var9 & 2) == 2) {
                                                   field971 += field972;
                                                }

                                                if((var9 & 4) == 4) {
                                                   field1114 += field974;
                                                }
                                             }

                                             if(field969 < -50) {
                                                field970 = 2;
                                             }

                                             if(field969 > 50) {
                                                field970 = -2;
                                             }

                                             if(field971 < -55) {
                                                field972 = 2;
                                             }

                                             if(field971 > 55) {
                                                field972 = -2;
                                             }

                                             if(field1114 < -40) {
                                                field974 = 1;
                                             }

                                             if(field1114 > 40) {
                                                field974 = -1;
                                             }

                                             ++field965;
                                             if(field965 > 500) {
                                                field965 = 0;
                                                var9 = (int)(Math.random() * 8.0D);
                                                if((var9 & 1) == 1) {
                                                   mapScale += mapOffset;
                                                }

                                                if((var9 & 2) == 2) {
                                                   mapScaleDelta += field979;
                                                }
                                             }

                                             if(mapScale < -60) {
                                                mapOffset = 2;
                                             }

                                             if(mapScale > 60) {
                                                mapOffset = -2;
                                             }

                                             if(mapScaleDelta < -20) {
                                                field979 = 1;
                                             }

                                             if(mapScaleDelta > 10) {
                                                field979 = -1;
                                             }

                                             for(class67 var39 = (class67)field973.method3524(); var39 != null; var39 = (class67)field973.method3523()) {
                                                if((long)var39.field809 < class166.method2970() / 1000L - 5L) {
                                                   if(var39.field807 > 0) {
                                                      class5.sendGameMessage(5, "", var39.field805 + " has logged in.");
                                                   }

                                                   if(var39.field807 == 0) {
                                                      class5.sendGameMessage(5, "", var39.field805 + " has logged out.");
                                                   }

                                                   var39.method3529();
                                                }
                                             }

                                             ++audioEffectCount;
                                             if(audioEffectCount > 50) {
                                                secretPacketBuffer1.putOpcode(71);
                                             }

                                             try {
                                                if(WidgetNode.rssocket != null && secretPacketBuffer1.offset > 0) {
                                                   WidgetNode.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
                                                   secretPacketBuffer1.offset = 0;
                                                   audioEffectCount = 0;
                                                }
                                             } catch (IOException var24) {
                                                if(field957 > 0) {
                                                   TextureProvider.method2306();
                                                } else {
                                                   class23.setGameState(40);
                                                   class222.field2846 = WidgetNode.rssocket;
                                                   WidgetNode.rssocket = null;
                                                }
                                             }

                                             return;
                                          }

                                          var20 = var19.field822;
                                          if(var20.index < 0) {
                                             break;
                                          }

                                          var35 = class223.method3959(var20.parentId);
                                       } while(var35 == null || var35.children == null || var20.index >= var35.children.length || var20 != var35.children[var20.index]);

                                       class77.method1440(var19);
                                    }
                                 }

                                 var20 = var19.field822;
                                 if(var20.index < 0) {
                                    break;
                                 }

                                 var35 = class223.method3959(var20.parentId);
                              } while(var35 == null || var35.children == null || var20.index >= var35.children.length || var20 != var35.children[var20.index]);

                              class77.method1440(var19);
                           }
                        }

                        var20 = var19.field822;
                        if(var20.index < 0) {
                           break;
                        }

                        var35 = class223.method3959(var20.parentId);
                     } while(var35 == null || var35.children == null || var20.index >= var35.children.length || var20 != var35.children[var20.index]);

                     class77.method1440(var19);
                  }
               }

               if(field957 > 0) {
                  TextureProvider.method2306();
               } else {
                  class23.setGameState(40);
                  class222.field2846 = WidgetNode.rssocket;
                  WidgetNode.rssocket = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-575158540"
   )
   @Export("processServerPacket")
   final boolean processServerPacket() {
      if(WidgetNode.rssocket == null) {
         return false;
      } else {
         int var1;
         String var2;
         try {
            int var3 = WidgetNode.rssocket.available();
            if(var3 == 0) {
               return false;
            }

            if(packetType == -1) {
               WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               packetLength = class272.field3700[packetType];
               --var3;
            }

            if(packetLength == -1) {
               if(var3 <= 0) {
                  return false;
               }

               WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               packetLength = secretPacketBuffer2.payload[0] & 255;
               --var3;
            }

            if(packetLength == -2) {
               if(var3 <= 1) {
                  return false;
               }

               WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();
               var3 -= 2;
            }

            if(var3 < packetLength) {
               return false;
            }

            secretPacketBuffer2.offset = 0;
            WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
            field952 = 0;
            field956 = field955;
            field955 = field1100 * -1;
            field1100 = packetType * -1;
            int var4;
            int var5;
            int var6;
            if(packetType == 206) {
               var4 = secretPacketBuffer2.readUnsignedByte();
               var1 = secretPacketBuffer2.readUnsignedByte();
               var5 = secretPacketBuffer2.readUnsignedByte();
               var6 = secretPacketBuffer2.readUnsignedByte();
               field1153[var4] = true;
               field1129[var4] = var1;
               field1015[var4] = var5;
               field1156[var4] = var6;
               field982[var4] = 0;
               packetType = -1;
               return true;
            }

            if(packetType == 78) {
               if(widgetRoot != -1) {
                  class4.method13(widgetRoot, 0);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 146) {
               for(var4 = 0; var4 < class211.widgetSettings.length; ++var4) {
                  if(class211.settings[var4] != class211.widgetSettings[var4]) {
                     class211.widgetSettings[var4] = class211.settings[var4];
                     class36.method483(var4);
                     field1092[++field1026 - 1 & 31] = var4;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 71) {
               Item.field1480 = Player.method1095(secretPacketBuffer2.readUnsignedByte());
               packetType = -1;
               return true;
            }

            boolean var7;
            if(packetType == 101) {
               var7 = secretPacketBuffer2.readUnsignedByte() == 1;
               if(var7) {
                  Tile.field1921 = class166.method2970() - secretPacketBuffer2.readLong();
                  field1181 = new class13(secretPacketBuffer2, true);
               } else {
                  field1181 = null;
               }

               field1102 = field1091;
               packetType = -1;
               return true;
            }

            if(packetType == 24) {
               class29.field437 = secretPacketBuffer2.readUnsignedByteNegated();
               class27.field414 = secretPacketBuffer2.readUnsignedByteOb1();

               while(secretPacketBuffer2.offset < packetLength) {
                  packetType = secretPacketBuffer2.readUnsignedByte();
                  class34.method479();
               }

               packetType = -1;
               return true;
            }

            int var8;
            Widget var9;
            int var10;
            if(packetType == 33) {
               var4 = secretPacketBuffer2.readInt();
               var1 = secretPacketBuffer2.readUnsignedShort();
               if(var4 < -70000) {
                  var1 += '耀';
               }

               if(var4 >= 0) {
                  var9 = class223.method3959(var4);
               } else {
                  var9 = null;
               }

               for(; secretPacketBuffer2.offset < packetLength; class92.method1649(var1, var6, var10 - 1, var8)) {
                  var6 = secretPacketBuffer2.method3046();
                  var10 = secretPacketBuffer2.readUnsignedShort();
                  var8 = 0;
                  if(var10 != 0) {
                     var8 = secretPacketBuffer2.readUnsignedByte();
                     if(var8 == 255) {
                        var8 = secretPacketBuffer2.readInt();
                     }
                  }

                  if(var9 != null && var6 >= 0 && var6 < var9.itemIds.length) {
                     var9.itemIds[var6] = var10;
                     var9.itemQuantities[var6] = var8;
                  }
               }

               if(var9 != null) {
                  XItemContainer.method1020(var9);
               }

               GameEngine.method864();
               interfaceItemTriggers[++field1095 - 1 & 31] = var1 & 32767;
               packetType = -1;
               return true;
            }

            if(packetType == 42) {
               field1172 = 1;
               field1099 = field1091;
               packetType = -1;
               return true;
            }

            Widget var11;
            if(packetType == 72) {
               var4 = secretPacketBuffer2.readUnsignedShort();
               var1 = secretPacketBuffer2.readShortLE();
               var5 = secretPacketBuffer2.readUnsignedShortOb2();
               var6 = secretPacketBuffer2.readIntOb1();
               var11 = class223.method3959(var6);
               if(var11.rotationX != var1 || var11.rotationZ != var4 || var11.field2737 != var5) {
                  var11.rotationX = var1;
                  var11.rotationZ = var4;
                  var11.field2737 = var5;
                  XItemContainer.method1020(var11);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 136) {
               field1087 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == 150) {
               class1.method0(true);
               packetType = -1;
               return true;
            }

            if(packetType == 55) {
               var4 = secretPacketBuffer2.readIntOb1();
               class69.field834 = GameEngine.field691.method2838(var4);
               packetType = -1;
               return true;
            }

            Player var12;
            int var13;
            PacketBuffer var14;
            if(packetType == 82) {
               class23.xteaChanged(true);
               secretPacketBuffer2.readOpcode();
               var4 = secretPacketBuffer2.readUnsignedShort();
               var14 = secretPacketBuffer2;
               var5 = var14.offset;
               class96.field1493 = 0;
               var6 = 0;
               var14.method3291();

               for(var10 = 0; var10 < class96.field1487; ++var10) {
                  var8 = class96.field1491[var10];
                  if((class96.field1489[var8] & 1) == 0) {
                     if(var6 > 0) {
                        --var6;
                        class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                     } else {
                        var13 = var14.method3290(1);
                        if(var13 == 0) {
                           var6 = World.method1475(var14);
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        } else {
                           class2.method4(var14, var8);
                        }
                     }
                  }
               }

               var14.method3292();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var14.method3291();

               for(var10 = 0; var10 < class96.field1487; ++var10) {
                  var8 = class96.field1491[var10];
                  if((class96.field1489[var8] & 1) != 0) {
                     if(var6 > 0) {
                        --var6;
                        class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                     } else {
                        var13 = var14.method3290(1);
                        if(var13 == 0) {
                           var6 = World.method1475(var14);
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        } else {
                           class2.method4(var14, var8);
                        }
                     }
                  }
               }

               var14.method3292();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var14.method3291();

               for(var10 = 0; var10 < class96.field1499; ++var10) {
                  var8 = class96.field1495[var10];
                  if((class96.field1489[var8] & 1) != 0) {
                     if(var6 > 0) {
                        --var6;
                        class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                     } else {
                        var13 = var14.method3290(1);
                        if(var13 == 0) {
                           var6 = World.method1475(var14);
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        } else if(class29.method253(var14, var8)) {
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        }
                     }
                  }
               }

               var14.method3292();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var14.method3291();

               for(var10 = 0; var10 < class96.field1499; ++var10) {
                  var8 = class96.field1495[var10];
                  if((class96.field1489[var8] & 1) == 0) {
                     if(var6 > 0) {
                        --var6;
                        class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                     } else {
                        var13 = var14.method3290(1);
                        if(var13 == 0) {
                           var6 = World.method1475(var14);
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        } else if(class29.method253(var14, var8)) {
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        }
                     }
                  }
               }

               var14.method3292();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               class96.field1487 = 0;
               class96.field1499 = 0;

               for(var10 = 1; var10 < 2048; ++var10) {
                  class96.field1489[var10] = (byte)(class96.field1489[var10] >> 1);
                  var12 = cachedPlayers[var10];
                  if(var12 != null) {
                     class96.field1491[++class96.field1487 - 1] = var10;
                  } else {
                     class96.field1495[++class96.field1499 - 1] = var10;
                  }
               }

               Item.updatePlayersFlag(var14);
               if(var14.offset - var5 != var4) {
                  throw new RuntimeException(var14.offset - var5 + " " + var4);
               }

               packetType = -1;
               return true;
            }

            int var15;
            int var16;
            PacketBuffer var17;
            String var18;
            String var19;
            if(packetType == 109) {
               var17 = secretPacketBuffer2;
               var1 = packetLength;
               ClassInfo var56 = new ClassInfo();
               var56.field3743 = var17.readUnsignedByte();
               var56.field3741 = var17.readInt();
               var56.field3748 = new int[var56.field3743];
               var56.field3744 = new int[var56.field3743];
               var56.fields = new Field[var56.field3743];
               var56.field3746 = new int[var56.field3743];
               var56.methods = new Method[var56.field3743];
               var56.args = new byte[var56.field3743][][];

               for(var6 = 0; var6 < var56.field3743; ++var6) {
                  try {
                     var10 = var17.readUnsignedByte();
                     String var57;
                     if(var10 != 0 && var10 != 1 && var10 != 2) {
                        if(var10 == 3 || var10 == 4) {
                           var18 = var17.readString();
                           var57 = var17.readString();
                           var15 = var17.readUnsignedByte();
                           String[] var63 = new String[var15];

                           for(int var60 = 0; var60 < var15; ++var60) {
                              var63[var60] = var17.readString();
                           }

                           var19 = var17.readString();
                           byte[][] var62 = new byte[var15][];
                           if(var10 == 3) {
                              for(int var59 = 0; var59 < var15; ++var59) {
                                 var16 = var17.readInt();
                                 var62[var59] = new byte[var16];
                                 var17.readBytes(var62[var59], 0, var16);
                              }
                           }

                           var56.field3748[var6] = var10;
                           Class[] var61 = new Class[var15];

                           for(var16 = 0; var16 < var15; ++var16) {
                              var61[var16] = class83.method1560(var63[var16]);
                           }

                           Class var69 = class83.method1560(var19);
                           if(class83.method1560(var18).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var72 = class83.method1560(var18).getDeclaredMethods();
                           Method[] var70 = var72;

                           for(int var74 = 0; var74 < var70.length; ++var74) {
                              Method var75 = var70[var74];
                              if(Reflection.getMethodName(var75).equals(var57)) {
                                 Class[] var77 = Reflection.getParameterTypes(var75);
                                 if(var61.length == var77.length) {
                                    boolean var31 = true;

                                    for(int var81 = 0; var81 < var61.length; ++var81) {
                                       if(var77[var81] != var61[var81]) {
                                          var31 = false;
                                          break;
                                       }
                                    }

                                    if(var31 && var69 == var75.getReturnType()) {
                                       var56.methods[var6] = var75;
                                    }
                                 }
                              }
                           }

                           var56.args[var6] = var62;
                        }
                     } else {
                        var18 = var17.readString();
                        var57 = var17.readString();
                        var15 = 0;
                        if(var10 == 1) {
                           var15 = var17.readInt();
                        }

                        var56.field3748[var6] = var10;
                        var56.field3746[var6] = var15;
                        if(class83.method1560(var18).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var56.fields[var6] = Reflection.findField(class83.method1560(var18), var57);
                     }
                  } catch (ClassNotFoundException var49) {
                     var56.field3744[var6] = -1;
                  } catch (SecurityException var50) {
                     var56.field3744[var6] = -2;
                  } catch (NullPointerException var51) {
                     var56.field3744[var6] = -3;
                  } catch (Exception var52) {
                     var56.field3744[var6] = -4;
                  } catch (Throwable var53) {
                     var56.field3744[var6] = -5;
                  }
               }

               class280.field3749.method3441(var56);
               packetType = -1;
               return true;
            }

            if(packetType == 236) {
               GameEngine.method864();
               weight = secretPacketBuffer2.readShort();
               field1103 = field1091;
               packetType = -1;
               return true;
            }

            WidgetNode var20;
            if(packetType == 134) {
               var4 = secretPacketBuffer2.readIntOb1();
               var1 = secretPacketBuffer2.readShortLE();
               var5 = secretPacketBuffer2.readByteOb1();
               var20 = (WidgetNode)componentTable.method3425((long)var4);
               if(var20 != null) {
                  class67.method1027(var20, var20.id != var1);
               }

               class67.method1028(var4, var1, var5);
               packetType = -1;
               return true;
            }

            Widget var21;
            if(packetType == 32) {
               var4 = secretPacketBuffer2.readUnsignedShort();
               var1 = secretPacketBuffer2.readIntOb3();
               var5 = secretPacketBuffer2.readUnsignedShortOb1();
               var21 = class223.method3959(var1);
               var21.field2710 = (var4 << 16) + var5;
               packetType = -1;
               return true;
            }

            boolean var22;
            String var23;
            if(packetType == 17) {
               Friend var58;
               while(secretPacketBuffer2.offset < packetLength) {
                  var7 = secretPacketBuffer2.readUnsignedByte() == 1;
                  var23 = secretPacketBuffer2.readString();
                  var19 = secretPacketBuffer2.readString();
                  var6 = secretPacketBuffer2.readUnsignedShort();
                  var10 = secretPacketBuffer2.readUnsignedByte();
                  var8 = secretPacketBuffer2.readUnsignedByte();
                  boolean var64 = (var8 & 2) != 0;
                  boolean var68 = (var8 & 1) != 0;
                  if(var6 > 0) {
                     secretPacketBuffer2.readString();
                     secretPacketBuffer2.readUnsignedByte();
                     secretPacketBuffer2.readInt();
                  }

                  secretPacketBuffer2.readString();

                  for(int var27 = 0; var27 < friendCount; ++var27) {
                     Friend var73 = friends[var27];
                     if(!var7) {
                        if(var23.equals(var73.name)) {
                           if(var73.world != var6) {
                              boolean var29 = true;

                              for(class67 var76 = (class67)field973.method3524(); var76 != null; var76 = (class67)field973.method3523()) {
                                 if(var76.field805.equals(var23)) {
                                    if(var6 != 0 && var76.field807 == 0) {
                                       var76.method3529();
                                       var29 = false;
                                    } else if(var6 == 0 && var76.field807 != 0) {
                                       var76.method3529();
                                       var29 = false;
                                    }
                                 }
                              }

                              if(var29) {
                                 field973.method3525(new class67(var23, var6));
                              }

                              var73.world = var6;
                           }

                           var73.previousName = var19;
                           var73.rank = var10;
                           var73.field795 = var64;
                           var73.field792 = var68;
                           var23 = null;
                           break;
                        }
                     } else if(var19.equals(var73.name)) {
                        var73.name = var23;
                        var73.previousName = var19;
                        var23 = null;
                        break;
                     }
                  }

                  if(var23 != null && friendCount < 400) {
                     var58 = new Friend();
                     friends[friendCount] = var58;
                     var58.name = var23;
                     var58.previousName = var19;
                     var58.world = var6;
                     var58.rank = var10;
                     var58.field795 = var64;
                     var58.field792 = var68;
                     ++friendCount;
                  }
               }

               field1172 = 2;
               field1099 = field1091;
               var7 = false;
               var1 = friendCount;

               while(var1 > 0) {
                  var7 = true;
                  --var1;

                  for(var5 = 0; var5 < var1; ++var5) {
                     var22 = false;
                     Friend var66 = friends[var5];
                     Friend var71 = friends[var5 + 1];
                     if(var66.world != world && var71.world == world) {
                        var22 = true;
                     }

                     if(!var22 && var66.world == 0 && var71.world != 0) {
                        var22 = true;
                     }

                     if(!var22 && !var66.field795 && var71.field795) {
                        var22 = true;
                     }

                     if(!var22 && !var66.field792 && var71.field792) {
                        var22 = true;
                     }

                     if(var22) {
                        var58 = friends[var5];
                        friends[var5] = friends[var5 + 1];
                        friends[var5 + 1] = var58;
                        var7 = false;
                     }
                  }

                  if(var7) {
                     break;
                  }
               }

               packetType = -1;
               return true;
            }

            Widget var24;
            if(packetType == 127) {
               var4 = secretPacketBuffer2.readIntOb2();
               var24 = class223.method3959(var4);
               var24.modelType = 3;
               var24.modelId = class20.localPlayer.composition.method3868();
               XItemContainer.method1020(var24);
               packetType = -1;
               return true;
            }

            if(packetType == 31) {
               var2 = secretPacketBuffer2.readString();
               var1 = secretPacketBuffer2.readIntOb1();
               var9 = class223.method3959(var1);
               if(!var2.equals(var9.text)) {
                  var9.text = var2;
                  XItemContainer.method1020(var9);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 224) {
               var4 = secretPacketBuffer2.readIntOb1();
               var1 = secretPacketBuffer2.readUnsignedShortOb2();
               class211.settings[var1] = var4;
               if(class211.widgetSettings[var1] != var4) {
                  class211.widgetSettings[var1] = var4;
               }

               class36.method483(var1);
               field1092[++field1026 - 1 & 31] = var1;
               packetType = -1;
               return true;
            }

            if(packetType == 2) {
               field954 = secretPacketBuffer2.readUnsignedByte();
               field1123 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == 98 || packetType == 66 || packetType == 173 || packetType == 137 || packetType == 165 || packetType == 111 || packetType == 4 || packetType == 209 || packetType == 37 || packetType == 190) {
               class34.method479();
               packetType = -1;
               return true;
            }

            if(packetType == 113) {
               field919 = secretPacketBuffer2.readUnsignedShortOb1() * 30;
               field1103 = field1091;
               packetType = -1;
               return true;
            }

            String var25;
            if(packetType == 13) {
               var2 = secretPacketBuffer2.readString();
               class219.field2810 = var2;

               try {
                  var23 = class220.field2817.getParameter(class274.field3716.field3725);
                  var19 = class220.field2817.getParameter(class274.field3723.field3725);
                  var25 = var23 + "settings=" + var2 + "; version=1; path=/; domain=" + var19;
                  if(var2.length() == 0) {
                     var25 = var25 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var25 = var25 + "; Expires=" + class116.method2031(class166.method2970() + 94608000000L) + "; Max-Age=" + 94608000L;
                  }

                  Client var67 = class220.field2817;
                  var18 = "document.cookie=\"" + var25 + "\"";
                  JSObject.getWindow(var67).eval(var18);
               } catch (Throwable var47) {
                  ;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 158) {
               var4 = secretPacketBuffer2.readUnsignedShort();
               var1 = secretPacketBuffer2.readInt();
               var5 = var4 >> 10 & 31;
               var6 = var4 >> 5 & 31;
               var10 = var4 & 31;
               var8 = (var10 << 3) + (var6 << 11) + (var5 << 19);
               Widget var65 = class223.method3959(var1);
               if(var8 != var65.textColor) {
                  var65.textColor = var8;
                  XItemContainer.method1020(var65);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 15) {
               var4 = secretPacketBuffer2.readUnsignedShortOb1();
               var1 = secretPacketBuffer2.readIntOb3();
               var9 = class223.method3959(var1);
               if(var9 != null && var9.type == 0) {
                  if(var4 > var9.scrollHeight - var9.height) {
                     var4 = var9.scrollHeight - var9.height;
                  }

                  if(var4 < 0) {
                     var4 = 0;
                  }

                  if(var9.scrollY != var4) {
                     var9.scrollY = var4;
                     XItemContainer.method1020(var9);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 141) {
               var4 = secretPacketBuffer2.readInt();
               var1 = secretPacketBuffer2.readUnsignedShort();
               if(var4 < -70000) {
                  var1 += '耀';
               }

               if(var4 >= 0) {
                  var9 = class223.method3959(var4);
               } else {
                  var9 = null;
               }

               if(var9 != null) {
                  for(var6 = 0; var6 < var9.itemIds.length; ++var6) {
                     var9.itemIds[var6] = 0;
                     var9.itemQuantities[var6] = 0;
                  }
               }

               class54.method748(var1);
               var6 = secretPacketBuffer2.readUnsignedShort();

               for(var10 = 0; var10 < var6; ++var10) {
                  var8 = secretPacketBuffer2.readUnsignedShortOb2();
                  var13 = secretPacketBuffer2.readUnsignedByteNegated();
                  if(var13 == 255) {
                     var13 = secretPacketBuffer2.readIntOb2();
                  }

                  if(var9 != null && var10 < var9.itemIds.length) {
                     var9.itemIds[var10] = var8;
                     var9.itemQuantities[var10] = var13;
                  }

                  class92.method1649(var1, var10, var8 - 1, var13);
               }

               if(var9 != null) {
                  XItemContainer.method1020(var9);
               }

               GameEngine.method864();
               interfaceItemTriggers[++field1095 - 1 & 31] = var1 & 32767;
               packetType = -1;
               return true;
            }

            if(packetType == 167) {
               var4 = secretPacketBuffer2.readByteOb1();
               var23 = secretPacketBuffer2.readString();
               var5 = secretPacketBuffer2.readByteOb1();
               if(var4 >= 1 && var4 <= 8) {
                  if(var23.equalsIgnoreCase("null")) {
                     var23 = null;
                  }

                  playerOptions[var4 - 1] = var23;
                  playerOptionsPriorities[var4 - 1] = var5 == 0;
               }

               packetType = -1;
               return true;
            }

            long var26;
            long var28;
            long var30;
            if(packetType == 1) {
               var4 = secretPacketBuffer2.readInt();
               var1 = secretPacketBuffer2.readInt();
               if(class17.field321 == null || !class17.field321.isValid()) {
                  try {
                     Iterator var79 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var79.hasNext()) {
                        GarbageCollectorMXBean var83 = (GarbageCollectorMXBean)var79.next();
                        if(var83.isValid()) {
                           class17.field321 = var83;
                           field1183 = -1L;
                           field1182 = -1L;
                        }
                     }
                  } catch (Throwable var48) {
                     ;
                  }
               }

               long var80 = class166.method2970();
               var10 = -1;
               if(class17.field321 != null) {
                  var26 = class17.field321.getCollectionTime();
                  if(-1L != field1182) {
                     var28 = var26 - field1182;
                     var30 = var80 - field1183;
                     if(0L != var30) {
                        var10 = (int)(var28 * 100L / var30);
                     }
                  }

                  field1182 = var26;
                  field1183 = var80;
               }

               secretPacketBuffer1.putOpcode(126);
               secretPacketBuffer1.putIntOb2(var4);
               secretPacketBuffer1.putInt(var1);
               secretPacketBuffer1.readByteOb1(GameEngine.FPS);
               secretPacketBuffer1.putByte(var10);
               packetType = -1;
               return true;
            }

            if(packetType == 238) {
               var2 = secretPacketBuffer2.readString();
               PacketBuffer var78 = secretPacketBuffer2;
               var23 = class162.method2947(var78, 32767);
               var25 = FontTypeFace.method4631(class210.method3816(var23));
               class5.sendGameMessage(6, var2, var25);
               packetType = -1;
               return true;
            }

            boolean var32;
            if(packetType == 63) {
               while(secretPacketBuffer2.offset < packetLength) {
                  var4 = secretPacketBuffer2.readUnsignedByte();
                  var32 = (var4 & 1) == 1;
                  var19 = secretPacketBuffer2.readString();
                  var25 = secretPacketBuffer2.readString();
                  secretPacketBuffer2.readString();

                  Ignore var82;
                  for(var10 = 0; var10 < ignoreCount; ++var10) {
                     var82 = ignores[var10];
                     if(var32) {
                        if(var25.equals(var82.name)) {
                           var82.name = var19;
                           var82.previousName = var25;
                           var19 = null;
                           break;
                        }
                     } else if(var19.equals(var82.name)) {
                        var82.name = var19;
                        var82.previousName = var25;
                        var19 = null;
                        break;
                     }
                  }

                  if(var19 != null && ignoreCount < 400) {
                     var82 = new Ignore();
                     ignores[ignoreCount] = var82;
                     var82.name = var19;
                     var82.previousName = var25;
                     ++ignoreCount;
                  }
               }

               field1099 = field1091;
               packetType = -1;
               return true;
            }

            if(packetType == 155) {
               var4 = secretPacketBuffer2.readUnsignedShort();
               class211.method3822(var4);
               interfaceItemTriggers[++field1095 - 1 & 31] = var4 & 32767;
               packetType = -1;
               return true;
            }

            if(packetType == 218) {
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

            if(packetType == 114) {
               field1152 = false;

               for(var4 = 0; var4 < 5; ++var4) {
                  field1153[var4] = false;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 139) {
               var4 = secretPacketBuffer2.readUnsignedShortOb2();
               widgetRoot = var4;
               this.method1151(false);
               WorldMapType3.method219(var4);
               class64.method1022(widgetRoot);

               for(var1 = 0; var1 < 100; ++var1) {
                  field1111[var1] = true;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 103) {
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

            boolean var33;
            if(packetType == 140) {
               field1063 = field1091;
               if(packetLength == 0) {
                  clanChatOwner = null;
                  clanChatName = null;
                  XGrandExchangeOffer.clanChatCount = 0;
                  class177.clanMembers = null;
                  packetType = -1;
                  return true;
               }

               clanChatName = secretPacketBuffer2.readString();
               long var89 = secretPacketBuffer2.readLong();
               clanChatOwner = class174.method3252(var89);
               class22.field359 = secretPacketBuffer2.readByte();
               var5 = secretPacketBuffer2.readUnsignedByte();
               if(var5 == 255) {
                  packetType = -1;
                  return true;
               }

               XGrandExchangeOffer.clanChatCount = var5;
               XClanMember[] var36 = new XClanMember[100];

               for(var10 = 0; var10 < XGrandExchangeOffer.clanChatCount; ++var10) {
                  var36[var10] = new XClanMember();
                  var36[var10].username = secretPacketBuffer2.readString();
                  var36[var10].field892 = class109.method1965(var36[var10].username, class33.field482);
                  var36[var10].world = secretPacketBuffer2.readUnsignedShort();
                  var36[var10].rank = secretPacketBuffer2.readByte();
                  secretPacketBuffer2.readString();
                  if(var36[var10].username.equals(class20.localPlayer.name)) {
                     class226.clanChatRank = var36[var10].rank;
                  }
               }

               var33 = false;
               var13 = XGrandExchangeOffer.clanChatCount;

               while(var13 > 0) {
                  var33 = true;
                  --var13;

                  for(var15 = 0; var15 < var13; ++var15) {
                     if(var36[var15].field892.compareTo(var36[var15 + 1].field892) > 0) {
                        XClanMember var90 = var36[var15];
                        var36[var15] = var36[var15 + 1];
                        var36[var15 + 1] = var90;
                        var33 = false;
                     }
                  }

                  if(var33) {
                     break;
                  }
               }

               class177.clanMembers = var36;
               packetType = -1;
               return true;
            }

            if(packetType == 207) {
               var4 = secretPacketBuffer2.readInt();
               WidgetNode var88 = (WidgetNode)componentTable.method3425((long)var4);
               if(var88 != null) {
                  class67.method1027(var88, true);
               }

               if(field1070 != null) {
                  XItemContainer.method1020(field1070);
                  field1070 = null;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 64) {
               var4 = secretPacketBuffer2.readShortLE();
               var1 = secretPacketBuffer2.readIntOb3();
               var9 = class223.method3959(var1);
               if(var9.modelType != 1 || var9.modelId != var4) {
                  var9.modelType = 1;
                  var9.modelId = var4;
                  XItemContainer.method1020(var9);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 93) {
               ChatLineBuffer.method1770();

               for(var4 = 0; var4 < 2048; ++var4) {
                  cachedPlayers[var4] = null;
               }

               class60.method965(secretPacketBuffer2);
               packetType = -1;
               return true;
            }

            if(packetType == 107) {
               field1152 = true;
               class29.field436 = secretPacketBuffer2.readUnsignedByte();
               class2.field19 = secretPacketBuffer2.readUnsignedByte();
               class27.field415 = secretPacketBuffer2.readUnsignedShort();
               XGrandExchangeOffer.field317 = secretPacketBuffer2.readUnsignedByte();
               GroundObject.field1870 = secretPacketBuffer2.readUnsignedByte();
               if(GroundObject.field1870 >= 100) {
                  class14.cameraX = class29.field436 * 128 + 64;
                  class66.cameraY = class2.field19 * 128 + 64;
                  class112.cameraZ = class77.method1438(class14.cameraX, class66.cameraY, Player.plane) - class27.field415;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 247) {
               GameEngine.method864();
               var4 = secretPacketBuffer2.readUnsignedByteNegated();
               var1 = secretPacketBuffer2.readIntOb1();
               var5 = secretPacketBuffer2.readUnsignedByteNegated();
               skillExperiences[var5] = var1;
               boostedSkillLevels[var5] = var4;
               realSkillLevels[var5] = 1;

               for(var6 = 0; var6 < 98; ++var6) {
                  if(var1 >= class222.field2851[var6]) {
                     realSkillLevels[var5] = var6 + 2;
                  }
               }

               field1174[++field1097 - 1 & 31] = var5;
               packetType = -1;
               return true;
            }

            if(packetType == 240) {
               secretPacketBuffer2.offset += 28;
               if(secretPacketBuffer2.method3056()) {
                  class61.method979(secretPacketBuffer2, secretPacketBuffer2.offset - 28);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 164) {
               var4 = secretPacketBuffer2.readUnsignedShort();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               if(var4 == -1 && !field1143) {
                  class203.field2516.method3579();
                  class203.field2517 = 1;
                  class203.field2518 = null;
               } else if(var4 != -1 && var4 != field1142 && field1141 != 0 && !field1143) {
                  IndexData var87 = FaceNormal.indexTrack1;
                  var5 = field1141;
                  class203.field2517 = 1;
                  class203.field2518 = var87;
                  class203.field2519 = var4;
                  class29.field438 = 0;
                  class182.field2455 = var5;
                  class88.field1384 = false;
                  CollisionData.field2304 = 2;
               }

               field1142 = var4;
               packetType = -1;
               return true;
            }

            if(packetType == 80) {
               var4 = secretPacketBuffer2.readUnsignedShortOb1();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               var1 = secretPacketBuffer2.read24BitInt();
               GameEngine.method931(var4, var1);
               packetType = -1;
               return true;
            }

            if(packetType == 210) {
               var4 = secretPacketBuffer2.readInt();
               var32 = secretPacketBuffer2.readByteOb1() == 1;
               var9 = class223.method3959(var4);
               if(var9.isHidden != var32) {
                  var9.isHidden = var32;
                  XItemContainer.method1020(var9);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 239) {
               TextureProvider.method2306();
               packetType = -1;
               return false;
            }

            if(packetType == 120) {
               var4 = secretPacketBuffer2.readUnsignedShort();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               var1 = secretPacketBuffer2.readInt();
               var5 = secretPacketBuffer2.readIntOb1();
               var21 = class223.method3959(var1);
               ItemComposition var86;
               if(!var21.hasScript) {
                  if(var4 == -1) {
                     var21.modelType = 0;
                     packetType = -1;
                     return true;
                  }

                  var86 = class224.getItemDefinition(var4);
                  var21.modelType = 4;
                  var21.modelId = var4;
                  var21.rotationX = var86.xan2d;
                  var21.rotationZ = var86.yan2d;
                  var21.field2737 = var86.zoom2d * 100 / var5;
                  XItemContainer.method1020(var21);
               } else {
                  var21.itemId = var4;
                  var21.itemQuantity = var5;
                  var86 = class224.getItemDefinition(var4);
                  var21.rotationX = var86.xan2d;
                  var21.rotationZ = var86.yan2d;
                  var21.rotationY = var86.zan2d;
                  var21.field2750 = var86.offsetX2d;
                  var21.field2731 = var86.offsetY2d;
                  var21.field2737 = var86.zoom2d;
                  if(var86.isStackable == 1) {
                     var21.field2712 = 1;
                  } else {
                     var21.field2712 = 2;
                  }

                  if(var21.field2709 > 0) {
                     var21.field2737 = var21.field2737 * 32 / var21.field2709;
                  } else if(var21.originalWidth > 0) {
                     var21.field2737 = var21.field2737 * 32 / var21.originalWidth;
                  }

                  XItemContainer.method1020(var21);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 225) {
               var4 = secretPacketBuffer2.readUnsignedShort();
               byte var85 = secretPacketBuffer2.readByteOb2();
               class211.settings[var4] = var85;
               if(var85 != class211.widgetSettings[var4]) {
                  class211.widgetSettings[var4] = var85;
               }

               class36.method483(var4);
               field1092[++field1026 - 1 & 31] = var4;
               packetType = -1;
               return true;
            }

            if(packetType == 157) {
               class29.field437 = secretPacketBuffer2.readUnsignedByteOb1();
               class27.field414 = secretPacketBuffer2.readUnsignedByte();

               for(var4 = class27.field414; var4 < class27.field414 + 8; ++var4) {
                  for(var1 = class29.field437; var1 < class29.field437 + 8; ++var1) {
                     if(groundItemDeque[Player.plane][var4][var1] != null) {
                        groundItemDeque[Player.plane][var4][var1] = null;
                        class47.groundItemSpawned(var4, var1);
                     }
                  }
               }

               for(PendingSpawn var84 = (PendingSpawn)pendingSpawns.method3487(); var84 != null; var84 = (PendingSpawn)pendingSpawns.method3512()) {
                  if(var84.x >= class27.field414 && var84.x < class27.field414 + 8 && var84.y >= class29.field437 && var84.y < class29.field437 + 8 && var84.level == Player.plane) {
                     var84.hitpoints = 0;
                  }
               }

               packetType = -1;
               return true;
            }

            String var34;
            if(packetType == 119) {
               var4 = secretPacketBuffer2.method3046();
               var32 = secretPacketBuffer2.readUnsignedByte() == 1;
               var19 = "";
               var22 = false;
               if(var32) {
                  var19 = secretPacketBuffer2.readString();
                  if(class87.method1604(var19)) {
                     var22 = true;
                  }
               }

               var34 = secretPacketBuffer2.readString();
               if(!var22) {
                  class5.sendGameMessage(var4, var19, var34);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 59) {
               var4 = secretPacketBuffer2.readIntOb2();
               var24 = class223.method3959(var4);

               for(var5 = 0; var5 < var24.itemIds.length; ++var5) {
                  var24.itemIds[var5] = -1;
                  var24.itemIds[var5] = 0;
               }

               XItemContainer.method1020(var24);
               packetType = -1;
               return true;
            }

            if(packetType == 204) {
               field920 = secretPacketBuffer2.readUnsignedByte();
               if(field920 == 1) {
                  field1133 = secretPacketBuffer2.readUnsignedShort();
               }

               if(field920 >= 2 && field920 <= 6) {
                  if(field920 == 2) {
                     field926 = 64;
                     field1039 = 64;
                  }

                  if(field920 == 3) {
                     field926 = 0;
                     field1039 = 64;
                  }

                  if(field920 == 4) {
                     field926 = 128;
                     field1039 = 64;
                  }

                  if(field920 == 5) {
                     field926 = 64;
                     field1039 = 0;
                  }

                  if(field920 == 6) {
                     field926 = 64;
                     field1039 = 128;
                  }

                  field920 = 2;
                  hintArrowX = secretPacketBuffer2.readUnsignedShort();
                  hintArrowY = secretPacketBuffer2.readUnsignedShort();
                  hintArrowType = secretPacketBuffer2.readUnsignedByte();
               }

               if(field920 == 10) {
                  field922 = secretPacketBuffer2.readUnsignedShort();
               }

               packetType = -1;
               return true;
            }

            if(packetType == 249) {
               field1152 = true;
               Item.field1479 = secretPacketBuffer2.readUnsignedByte();
               class18.field335 = secretPacketBuffer2.readUnsignedByte();
               class152.field2231 = secretPacketBuffer2.readUnsignedShort();
               MessageNode.field856 = secretPacketBuffer2.readUnsignedByte();
               class24.field372 = secretPacketBuffer2.readUnsignedByte();
               if(class24.field372 >= 100) {
                  var4 = Item.field1479 * 128 + 64;
                  var1 = class18.field335 * 128 + 64;
                  var5 = class77.method1438(var4, var1, Player.plane) - class152.field2231;
                  var6 = var4 - class14.cameraX;
                  var10 = var5 - class112.cameraZ;
                  var8 = var1 - class66.cameraY;
                  var13 = (int)Math.sqrt((double)(var8 * var8 + var6 * var6));
                  class203.cameraPitch = (int)(Math.atan2((double)var10, (double)var13) * 325.949D) & 2047;
                  class13.cameraYaw = (int)(Math.atan2((double)var6, (double)var8) * -325.949D) & 2047;
                  if(class203.cameraPitch < 128) {
                     class203.cameraPitch = 128;
                  }

                  if(class203.cameraPitch > 383) {
                     class203.cameraPitch = 383;
                  }
               }

               packetType = -1;
               return true;
            }

            long var35;
            long var37;
            boolean var39;
            String var40;
            class230 var41;
            class230[] var42;
            PacketBuffer var43;
            if(packetType == 122) {
               var2 = secretPacketBuffer2.readString();
               var35 = secretPacketBuffer2.readLong();
               var37 = (long)secretPacketBuffer2.readUnsignedShort();
               var26 = (long)secretPacketBuffer2.read24BitInt();
               var42 = new class230[]{class230.field3180, class230.field3178, class230.field3187, class230.field3182, class230.field3179, class230.field3181};
               var41 = (class230)RSCanvas.method735(var42, secretPacketBuffer2.readUnsignedByte());
               var30 = var26 + (var37 << 32);
               var39 = false;

               for(var16 = 0; var16 < 100; ++var16) {
                  if(field942[var16] == var30) {
                     var39 = true;
                     break;
                  }
               }

               if(var41.field3186 && class87.method1604(var2)) {
                  var39 = true;
               }

               if(!var39 && field1025 == 0) {
                  field942[field1126] = var30;
                  field1126 = (field1126 + 1) % 100;
                  var43 = secretPacketBuffer2;
                  var34 = class162.method2947(var43, 32767);
                  var40 = FontTypeFace.method4631(class210.method3816(var34));
                  if(var41.field3184 != -1) {
                     class15.addChatMessage(9, RSCanvas.method741(var41.field3184) + var2, var40, class239.method4141(var35));
                  } else {
                     class15.addChatMessage(9, var2, var40, class239.method4141(var35));
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 188) {
               var2 = secretPacketBuffer2.readString();
               var35 = (long)secretPacketBuffer2.readUnsignedShort();
               var37 = (long)secretPacketBuffer2.read24BitInt();
               var42 = new class230[]{class230.field3180, class230.field3178, class230.field3187, class230.field3182, class230.field3179, class230.field3181};
               var41 = (class230)RSCanvas.method735(var42, secretPacketBuffer2.readUnsignedByte());
               var28 = var37 + (var35 << 32);
               var39 = false;

               for(int var93 = 0; var93 < 100; ++var93) {
                  if(field942[var93] == var28) {
                     var39 = true;
                     break;
                  }
               }

               if(class87.method1604(var2)) {
                  var39 = true;
               }

               if(!var39 && field1025 == 0) {
                  field942[field1126] = var28;
                  field1126 = (field1126 + 1) % 100;
                  var43 = secretPacketBuffer2;
                  var40 = class162.method2947(var43, 32767);
                  var34 = FontTypeFace.method4631(class210.method3816(var40));
                  byte var97;
                  if(var41.field3185) {
                     var97 = 7;
                  } else {
                     var97 = 3;
                  }

                  if(var41.field3184 != -1) {
                     class5.sendGameMessage(var97, RSCanvas.method741(var41.field3184) + var2, var34);
                  } else {
                     class5.sendGameMessage(var97, var2, var34);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 35) {
               class23.xteaChanged(false);
               secretPacketBuffer2.readOpcode();
               var4 = secretPacketBuffer2.readUnsignedShort();
               var14 = secretPacketBuffer2;
               var5 = var14.offset;
               class96.field1493 = 0;
               var6 = 0;
               var14.method3291();

               for(var10 = 0; var10 < class96.field1487; ++var10) {
                  var8 = class96.field1491[var10];
                  if((class96.field1489[var8] & 1) == 0) {
                     if(var6 > 0) {
                        --var6;
                        class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                     } else {
                        var13 = var14.method3290(1);
                        if(var13 == 0) {
                           var6 = World.method1475(var14);
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        } else {
                           class2.method4(var14, var8);
                        }
                     }
                  }
               }

               var14.method3292();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var14.method3291();

               for(var10 = 0; var10 < class96.field1487; ++var10) {
                  var8 = class96.field1491[var10];
                  if((class96.field1489[var8] & 1) != 0) {
                     if(var6 > 0) {
                        --var6;
                        class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                     } else {
                        var13 = var14.method3290(1);
                        if(var13 == 0) {
                           var6 = World.method1475(var14);
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        } else {
                           class2.method4(var14, var8);
                        }
                     }
                  }
               }

               var14.method3292();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var14.method3291();

               for(var10 = 0; var10 < class96.field1499; ++var10) {
                  var8 = class96.field1495[var10];
                  if((class96.field1489[var8] & 1) != 0) {
                     if(var6 > 0) {
                        --var6;
                        class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                     } else {
                        var13 = var14.method3290(1);
                        if(var13 == 0) {
                           var6 = World.method1475(var14);
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        } else if(class29.method253(var14, var8)) {
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        }
                     }
                  }
               }

               var14.method3292();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var14.method3291();

               for(var10 = 0; var10 < class96.field1499; ++var10) {
                  var8 = class96.field1495[var10];
                  if((class96.field1489[var8] & 1) == 0) {
                     if(var6 > 0) {
                        --var6;
                        class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                     } else {
                        var13 = var14.method3290(1);
                        if(var13 == 0) {
                           var6 = World.method1475(var14);
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        } else if(class29.method253(var14, var8)) {
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        }
                     }
                  }
               }

               var14.method3292();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               class96.field1487 = 0;
               class96.field1499 = 0;

               for(var10 = 1; var10 < 2048; ++var10) {
                  class96.field1489[var10] = (byte)(class96.field1489[var10] >> 1);
                  var12 = cachedPlayers[var10];
                  if(var12 != null) {
                     class96.field1491[++class96.field1487 - 1] = var10;
                  } else {
                     class96.field1495[++class96.field1499 - 1] = var10;
                  }
               }

               Item.updatePlayersFlag(var14);
               if(var14.offset - var5 != var4) {
                  throw new RuntimeException(var14.offset - var5 + " " + var4);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 84) {
               class1.method0(false);
               packetType = -1;
               return true;
            }

            WidgetNode var44;
            if(packetType == 219) {
               var4 = packetLength + secretPacketBuffer2.offset;
               var1 = secretPacketBuffer2.readUnsignedShort();
               var5 = secretPacketBuffer2.readUnsignedShort();
               if(widgetRoot != var1) {
                  widgetRoot = var1;
                  this.method1151(false);
                  WorldMapType3.method219(widgetRoot);
                  class64.method1022(widgetRoot);

                  for(var6 = 0; var6 < 100; ++var6) {
                     field1111[var6] = true;
                  }
               }

               for(; var5-- > 0; var44.field815 = true) {
                  var6 = secretPacketBuffer2.readInt();
                  var10 = secretPacketBuffer2.readUnsignedShort();
                  var8 = secretPacketBuffer2.readUnsignedByte();
                  var44 = (WidgetNode)componentTable.method3425((long)var6);
                  if(var44 != null && var10 != var44.id) {
                     class67.method1027(var44, true);
                     var44 = null;
                  }

                  if(var44 == null) {
                     var44 = class67.method1028(var6, var10, var8);
                  }
               }

               for(var20 = (WidgetNode)componentTable.method3435(); var20 != null; var20 = (WidgetNode)componentTable.method3429()) {
                  if(var20.field815) {
                     var20.field815 = false;
                  } else {
                     class67.method1027(var20, true);
                  }
               }

               widgetFlags = new XHashTable(512);

               while(secretPacketBuffer2.offset < var4) {
                  var6 = secretPacketBuffer2.readInt();
                  var10 = secretPacketBuffer2.readUnsignedShort();
                  var8 = secretPacketBuffer2.readUnsignedShort();
                  var13 = secretPacketBuffer2.readInt();

                  for(var15 = var10; var15 <= var8; ++var15) {
                     long var98 = (long)var15 + ((long)var6 << 32);
                     widgetFlags.method3426(new class198(var13), var98);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 148) {
               var17 = secretPacketBuffer2;
               var1 = packetLength;
               var5 = var17.offset;
               class96.field1493 = 0;
               var6 = 0;
               var17.method3291();

               for(var10 = 0; var10 < class96.field1487; ++var10) {
                  var8 = class96.field1491[var10];
                  if((class96.field1489[var8] & 1) == 0) {
                     if(var6 > 0) {
                        --var6;
                        class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                     } else {
                        var13 = var17.method3290(1);
                        if(var13 == 0) {
                           var6 = World.method1475(var17);
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        } else {
                           class2.method4(var17, var8);
                        }
                     }
                  }
               }

               var17.method3292();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var17.method3291();

               for(var10 = 0; var10 < class96.field1487; ++var10) {
                  var8 = class96.field1491[var10];
                  if((class96.field1489[var8] & 1) != 0) {
                     if(var6 > 0) {
                        --var6;
                        class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                     } else {
                        var13 = var17.method3290(1);
                        if(var13 == 0) {
                           var6 = World.method1475(var17);
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        } else {
                           class2.method4(var17, var8);
                        }
                     }
                  }
               }

               var17.method3292();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var17.method3291();

               for(var10 = 0; var10 < class96.field1499; ++var10) {
                  var8 = class96.field1495[var10];
                  if((class96.field1489[var8] & 1) != 0) {
                     if(var6 > 0) {
                        --var6;
                        class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                     } else {
                        var13 = var17.method3290(1);
                        if(var13 == 0) {
                           var6 = World.method1475(var17);
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        } else if(class29.method253(var17, var8)) {
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        }
                     }
                  }
               }

               var17.method3292();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var17.method3291();

               for(var10 = 0; var10 < class96.field1499; ++var10) {
                  var8 = class96.field1495[var10];
                  if((class96.field1489[var8] & 1) == 0) {
                     if(var6 > 0) {
                        --var6;
                        class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                     } else {
                        var13 = var17.method3290(1);
                        if(var13 == 0) {
                           var6 = World.method1475(var17);
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        } else if(class29.method253(var17, var8)) {
                           class96.field1489[var8] = (byte)(class96.field1489[var8] | 2);
                        }
                     }
                  }
               }

               var17.method3292();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               class96.field1487 = 0;
               class96.field1499 = 0;

               for(var10 = 1; var10 < 2048; ++var10) {
                  class96.field1489[var10] = (byte)(class96.field1489[var10] >> 1);
                  var12 = cachedPlayers[var10];
                  if(var12 != null) {
                     class96.field1491[++class96.field1487 - 1] = var10;
                  } else {
                     class96.field1495[++class96.field1499 - 1] = var10;
                  }
               }

               Item.updatePlayersFlag(var17);
               if(var17.offset - var5 != var1) {
                  throw new RuntimeException(var17.offset - var5 + " " + var1);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 244) {
               var2 = secretPacketBuffer2.readString();
               Object[] var95 = new Object[var2.length() + 1];

               for(var5 = var2.length() - 1; var5 >= 0; --var5) {
                  if(var2.charAt(var5) == 115) {
                     var95[var5 + 1] = secretPacketBuffer2.readString();
                  } else {
                     var95[var5 + 1] = new Integer(secretPacketBuffer2.readInt());
                  }
               }

               var95[0] = new Integer(secretPacketBuffer2.readInt());
               class69 var96 = new class69();
               var96.field821 = var95;
               class77.method1440(var96);
               packetType = -1;
               return true;
            }

            if(packetType == 172) {
               GameEngine.method864();
               energy = secretPacketBuffer2.readUnsignedByte();
               field1103 = field1091;
               packetType = -1;
               return true;
            }

            if(packetType == 160) {
               for(var4 = 0; var4 < class241.field3292; ++var4) {
                  class241 var94 = class25.method203(var4);
                  if(var94 != null) {
                     class211.settings[var4] = 0;
                     class211.widgetSettings[var4] = 0;
                  }
               }

               GameEngine.method864();
               field1026 += 32;
               packetType = -1;
               return true;
            }

            if(packetType == 121) {
               var4 = secretPacketBuffer2.readInt();
               var1 = secretPacketBuffer2.readIntOb3();
               var44 = (WidgetNode)componentTable.method3425((long)var1);
               var20 = (WidgetNode)componentTable.method3425((long)var4);
               if(var20 != null) {
                  class67.method1027(var20, var44 == null || var44.id != var20.id);
               }

               if(var44 != null) {
                  var44.unlink();
                  componentTable.method3426(var44, (long)var4);
               }

               var11 = class223.method3959(var1);
               if(var11 != null) {
                  XItemContainer.method1020(var11);
               }

               var11 = class223.method3959(var4);
               if(var11 != null) {
                  XItemContainer.method1020(var11);
                  class95.method1670(Widget.widgets[var11.id >>> 16], var11, true);
               }

               if(widgetRoot != -1) {
                  class4.method13(widgetRoot, 1);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 208) {
               var4 = secretPacketBuffer2.readIntOb1();
               var1 = secretPacketBuffer2.readIntOb2();
               var5 = secretPacketBuffer2.readShortLE();
               if(var5 == '\uffff') {
                  var5 = -1;
               }

               var6 = secretPacketBuffer2.readUnsignedShort();
               if(var6 == '\uffff') {
                  var6 = -1;
               }

               for(var10 = var5; var10 <= var6; ++var10) {
                  var26 = (long)var10 + ((long)var4 << 32);
                  Node var92 = widgetFlags.method3425(var26);
                  if(var92 != null) {
                     var92.unlink();
                  }

                  widgetFlags.method3426(new class198(var1), var26);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 86) {
               var4 = secretPacketBuffer2.readIntOb2();
               var1 = secretPacketBuffer2.readUnsignedShortOb1();
               var9 = class223.method3959(var4);
               if(var9.modelType != 2 || var9.modelId != var1) {
                  var9.modelType = 2;
                  var9.modelId = var1;
                  XItemContainer.method1020(var9);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 76) {
               World var91 = new World();
               var91.address = secretPacketBuffer2.readString();
               var91.id = secretPacketBuffer2.readUnsignedShort();
               var1 = secretPacketBuffer2.readInt();
               var91.mask = var1;
               class23.setGameState(45);
               WidgetNode.rssocket.close();
               WidgetNode.rssocket = null;
               class2.method6(var91);
               packetType = -1;
               return false;
            }

            if(packetType == 62) {
               var4 = secretPacketBuffer2.readShortOb1();
               var1 = secretPacketBuffer2.readInt();
               var9 = class223.method3959(var1);
               if(var9.field2777 != var4 || var4 == -1) {
                  var9.field2777 = var4;
                  var9.field2776 = 0;
                  var9.field2758 = 0;
                  XItemContainer.method1020(var9);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 151) {
               var4 = secretPacketBuffer2.readShortOb3();
               var1 = secretPacketBuffer2.readIntOb3();
               var5 = secretPacketBuffer2.readShortOb2();
               var21 = class223.method3959(var1);
               if(var5 != var21.originalX || var21.originalY != var4 || var21.field2659 != 0 || var21.field2660 != 0) {
                  var21.originalX = var5;
                  var21.originalY = var4;
                  var21.field2659 = 0;
                  var21.field2660 = 0;
                  XItemContainer.method1020(var21);
                  this.method1118(var21);
                  if(var21.type == 0) {
                     class95.method1670(Widget.widgets[var1 >> 16], var21, false);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 179) {
               var4 = secretPacketBuffer2.readUnsignedShort();
               var1 = secretPacketBuffer2.readUnsignedByte();
               var5 = secretPacketBuffer2.readUnsignedShort();
               if(field1144 != 0 && var1 != 0 && field931 < 50) {
                  field1036[field931] = var4;
                  field1155[field931] = var1;
                  field1150[field931] = var5;
                  audioEffects[field931] = null;
                  field1170[field931] = 0;
                  ++field931;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 36) {
               var4 = secretPacketBuffer2.readUnsignedByte();
               if(secretPacketBuffer2.readUnsignedByte() == 0) {
                  grandExchangeOffers[var4] = new XGrandExchangeOffer();
                  secretPacketBuffer2.offset += 18;
               } else {
                  --secretPacketBuffer2.offset;
                  grandExchangeOffers[var4] = new XGrandExchangeOffer(secretPacketBuffer2, false);
               }

               field1101 = field1091;
               packetType = -1;
               return true;
            }

            if(packetType == 161) {
               var2 = secretPacketBuffer2.readString();
               var1 = secretPacketBuffer2.readUnsignedShort();
               byte var45 = secretPacketBuffer2.readByte();
               var22 = false;
               if(var45 == -128) {
                  var22 = true;
               }

               if(var22) {
                  if(XGrandExchangeOffer.clanChatCount == 0) {
                     packetType = -1;
                     return true;
                  }

                  var33 = false;

                  for(var10 = 0; var10 < XGrandExchangeOffer.clanChatCount && (!class177.clanMembers[var10].username.equals(var2) || class177.clanMembers[var10].world != var1); ++var10) {
                     ;
                  }

                  if(var10 < XGrandExchangeOffer.clanChatCount) {
                     while(var10 < XGrandExchangeOffer.clanChatCount - 1) {
                        class177.clanMembers[var10] = class177.clanMembers[var10 + 1];
                        ++var10;
                     }

                     --XGrandExchangeOffer.clanChatCount;
                     class177.clanMembers[XGrandExchangeOffer.clanChatCount] = null;
                  }
               } else {
                  secretPacketBuffer2.readString();
                  XClanMember var46 = new XClanMember();
                  var46.username = var2;
                  var46.field892 = class109.method1965(var46.username, class33.field482);
                  var46.world = var1;
                  var46.rank = var45;

                  for(var8 = XGrandExchangeOffer.clanChatCount - 1; var8 >= 0; --var8) {
                     var13 = class177.clanMembers[var8].field892.compareTo(var46.field892);
                     if(var13 == 0) {
                        class177.clanMembers[var8].world = var1;
                        class177.clanMembers[var8].rank = var45;
                        if(var2.equals(class20.localPlayer.name)) {
                           class226.clanChatRank = var45;
                        }

                        field1063 = field1091;
                        packetType = -1;
                        return true;
                     }

                     if(var13 < 0) {
                        break;
                     }
                  }

                  if(XGrandExchangeOffer.clanChatCount >= class177.clanMembers.length) {
                     packetType = -1;
                     return true;
                  }

                  for(var13 = XGrandExchangeOffer.clanChatCount - 1; var13 > var8; --var13) {
                     class177.clanMembers[var13 + 1] = class177.clanMembers[var13];
                  }

                  if(XGrandExchangeOffer.clanChatCount == 0) {
                     class177.clanMembers = new XClanMember[100];
                  }

                  class177.clanMembers[var8 + 1] = var46;
                  ++XGrandExchangeOffer.clanChatCount;
                  if(var2.equals(class20.localPlayer.name)) {
                     class226.clanChatRank = var45;
                  }
               }

               field1063 = field1091;
               packetType = -1;
               return true;
            }

            if(packetType == 70) {
               class29.field437 = secretPacketBuffer2.readByteOb1();
               class27.field414 = secretPacketBuffer2.readUnsignedByteNegated();
               packetType = -1;
               return true;
            }

            class8.method43("" + packetType + "," + field955 + "," + field956 + "," + packetLength, (Throwable)null);
            TextureProvider.method2306();
         } catch (IOException var54) {
            if(field957 > 0) {
               TextureProvider.method2306();
            } else {
               class23.setGameState(40);
               class222.field2846 = WidgetNode.rssocket;
               WidgetNode.rssocket = null;
            }
         } catch (Exception var55) {
            var2 = "" + packetType + "," + field955 + "," + field956 + "," + packetLength + "," + (class20.localPlayer.pathX[0] + class19.baseX) + "," + (class20.localPlayer.pathY[0] + class21.baseY) + ",";

            for(var1 = 0; var1 < packetLength && var1 < 50; ++var1) {
               var2 = var2 + secretPacketBuffer2.payload[var1] + ",";
            }

            class8.method43(var2, var55);
            TextureProvider.method2306();
         }

         return true;
      }
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1386965970"
   )
   final void method1334() {
      int var1;
      if(widgetRoot != -1) {
         var1 = widgetRoot;
         if(class59.method961(var1)) {
            class140.method2751(Widget.widgets[var1], -1);
         }
      }

      for(var1 = 0; var1 < field1109; ++var1) {
         if(field1111[var1]) {
            field1112[var1] = true;
         }

         field1128[var1] = field1111[var1];
         field1111[var1] = false;
      }

      field1110 = gameCycle;
      field941 = -1;
      field1056 = -1;
      Projectile.field1475 = null;
      if(widgetRoot != -1) {
         field1109 = 0;
         class158.drawWidget(widgetRoot, 0, 0, class10.canvasWidth, class1.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.method4880();
      int var2;
      int var3;
      if(!isMenuOpen) {
         if(field941 != -1) {
            var1 = field941;
            var2 = field1056;
            if(menuOptionCount >= 2 || itemSelectionState != 0 || field1061) {
               var3 = class230.method3976();
               String var4;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var4 = "Use " + selectedItemName + " ->";
               } else if(field1061 && menuOptionCount < 2) {
                  var4 = field1064 + " " + field1065 + " ->";
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
                  var4 = var4 + class15.method105(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               class64.field788.drawRandomizedMouseoverText(var4, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         class77.method1439();
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < field1109; ++var1) {
            if(field1128[var1]) {
               Rasterizer2D.method4825(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1112[var1]) {
               Rasterizer2D.method4825(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = Player.plane;
      var2 = class20.localPlayer.x;
      var3 = class20.localPlayer.y;
      int var13 = field1125;

      for(class82 var14 = (class82)class82.field1314.method3487(); var14 != null; var14 = (class82)class82.field1314.method3512()) {
         if(var14.field1308 != -1 || var14.field1316 != null) {
            int var6 = 0;
            if(var2 > var14.field1309) {
               var6 += var2 - var14.field1309;
            } else if(var2 < var14.field1322) {
               var6 += var14.field1322 - var2;
            }

            if(var3 > var14.field1320) {
               var6 += var3 - var14.field1320;
            } else if(var3 < var14.field1310) {
               var6 += var14.field1310 - var3;
            }

            if(var6 - 64 <= var14.field1311 && field1041 != 0 && var14.field1306 == var1) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               int var7 = (var14.field1311 - var6) * field1041 / var14.field1311;
               Object var8;
               if(var14.field1313 == null) {
                  if(var14.field1308 >= 0) {
                     var8 = null;
                     SoundEffect var9 = SoundEffect.method1843(class66.field799, var14.field1308, 0);
                     if(var9 != null) {
                        class107 var10 = var9.method1839().method1881(class59.field724);
                        class117 var11 = class117.method2038(var10, 100, var7);
                        var11.method2149(-1);
                        WorldMapType1.field442.method1806(var11);
                        var14.field1313 = var11;
                     }
                  }
               } else {
                  var14.field1313.method2042(var7);
               }

               if(var14.field1318 == null) {
                  if(var14.field1316 != null && (var14.field1317 -= var13) <= 0) {
                     int var15 = (int)(Math.random() * (double)var14.field1316.length);
                     var8 = null;
                     SoundEffect var16 = SoundEffect.method1843(class66.field799, var14.field1316[var15], 0);
                     if(var16 != null) {
                        class107 var17 = var16.method1839().method1881(class59.field724);
                        class117 var12 = class117.method2038(var17, 100, var7);
                        var12.method2149(0);
                        WorldMapType1.field442.method1806(var12);
                        var14.field1318 = var12;
                        var14.field1317 = var14.field1307 + (int)(Math.random() * (double)(var14.field1315 - var14.field1307));
                     }
                  }
               } else {
                  var14.field1318.method2042(var7);
                  if(!var14.field1318.linked()) {
                     var14.field1318 = null;
                  }
               }
            } else {
               if(var14.field1313 != null) {
                  WorldMapType1.field442.method1780(var14.field1313);
                  var14.field1313 = null;
               }

               if(var14.field1318 != null) {
                  WorldMapType1.field442.method1780(var14.field1318);
                  var14.field1318 = null;
               }
            }
         }
      }

      field1125 = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1326549533"
   )
   protected final void vmethod1336() {
      field1119 = class166.method2970() + 500L;
      this.method1112();
      if(widgetRoot != -1) {
         this.method1151(true);
      }

   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "1"
   )
   static final void method1358(String var0) {
      if(class177.clanMembers != null) {
         secretPacketBuffer1.putOpcode(127);
         secretPacketBuffer1.putByte(Friend.method1023(var0));
         secretPacketBuffer1.method3125(var0);
      }

   }

   static {
      field1122 = true;
      world = 1;
      flags = 0;
      field1161 = 0;
      isMembers = false;
      field1055 = false;
      field1120 = 0;
      gameState = 0;
      field960 = true;
      gameCycle = 0;
      field1028 = -1L;
      field914 = -1;
      field915 = -1;
      field916 = -1;
      field1008 = true;
      field918 = false;
      field919 = 0;
      field920 = 0;
      field1133 = 0;
      field922 = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowType = 0;
      field926 = 0;
      field1039 = 0;
      field928 = class91.field1410;
      field910 = class91.field1410;
      loadingStage = 0;
      field1185 = 0;
      field1021 = 0;
      field936 = 0;
      loginState = 0;
      field938 = 0;
      field939 = 0;
      field940 = 0;
      field943 = null;
      cachedNPCs = new NPC['耀'];
      field930 = 0;
      npcIndices = new int['耀'];
      field1096 = 0;
      field946 = new int[250];
      secretPacketBuffer1 = new PacketBuffer(5000);
      field907 = new PacketBuffer(5000);
      secretPacketBuffer2 = new PacketBuffer(15000);
      packetLength = 0;
      packetType = 0;
      field952 = 0;
      audioEffectCount = 0;
      field1100 = 0;
      field955 = 0;
      field956 = 0;
      field957 = 0;
      field958 = false;
      field1052 = new HashMap();
      field1117 = 0;
      field961 = 1;
      field1127 = 0;
      field1023 = 1;
      field1113 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field967 = new int[4][13][13];
      field968 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field969 = 0;
      field970 = 2;
      field971 = 0;
      field972 = 2;
      field1114 = 0;
      field974 = 1;
      field975 = 0;
      mapScale = 0;
      mapOffset = 2;
      mapScaleDelta = 0;
      field979 = 1;
      field965 = 0;
      field1125 = 0;
      field983 = 2301979;
      field984 = 5063219;
      field1184 = 3353893;
      field986 = 7759444;
      field987 = false;
      field1073 = 0;
      field1159 = 128;
      mapAngle = 0;
      field1088 = 0;
      field992 = 0;
      field1104 = 0;
      field994 = 0;
      field995 = 50;
      field996 = 0;
      field1083 = false;
      field998 = 0;
      field1074 = 0;
      field1000 = 50;
      field962 = new int[field1000];
      field1002 = new int[field1000];
      field1003 = new int[field1000];
      field1004 = new int[field1000];
      field1005 = new int[field1000];
      field1006 = new int[field1000];
      field1007 = new int[field1000];
      field903 = new String[field1000];
      field1009 = new int[104][104];
      field1010 = 0;
      field1011 = -1;
      field1049 = -1;
      field1013 = 0;
      field1115 = 0;
      field906 = 0;
      cursorState = 0;
      field1017 = 0;
      field1018 = 0;
      field1019 = 0;
      field911 = 0;
      field985 = 0;
      field1022 = 0;
      field1107 = false;
      field1024 = 0;
      field1025 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field1176 = 0;
      field1029 = 0;
      field1030 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field1154 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field1035 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      field1033 = new Deque();
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
      field1140 = false;
      field1053 = -1;
      field989 = false;
      field941 = -1;
      field1056 = -1;
      field917 = 0;
      field1058 = 50;
      itemSelectionState = 0;
      selectedItemName = null;
      field1061 = false;
      field1062 = -1;
      field1157 = -1;
      field1064 = null;
      field1065 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field1068 = 0;
      field1069 = 0;
      field1070 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field948 = -1;
      field1075 = false;
      field1076 = false;
      field1077 = false;
      field1078 = null;
      field1079 = null;
      field1080 = null;
      field1081 = 0;
      field1082 = 0;
      field963 = null;
      field1084 = false;
      field1093 = -1;
      field1086 = -1;
      field980 = false;
      field981 = -1;
      field1089 = -1;
      field1090 = false;
      field1091 = 1;
      field1092 = new int[32];
      field1026 = 0;
      interfaceItemTriggers = new int[32];
      field1095 = 0;
      field1174 = new int[32];
      field1097 = 0;
      field1098 = 0;
      field1099 = 0;
      field1063 = 0;
      field1101 = 0;
      field1102 = 0;
      field1103 = 0;
      field1186 = 0;
      field1105 = new Deque();
      field1106 = new Deque();
      field1136 = new Deque();
      widgetFlags = new XHashTable(512);
      field1109 = 0;
      field1110 = -2;
      field1111 = new boolean[100];
      field1112 = new boolean[100];
      field1128 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1119 = 0L;
      isResized = true;
      field1121 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field954 = 0;
      field1123 = 0;
      field1124 = "";
      field942 = new long[100];
      field1126 = 0;
      field1132 = 0;
      field1135 = new int[128];
      field1038 = new int[128];
      field1130 = -1L;
      clanChatOwner = null;
      clanChatName = null;
      field944 = -1;
      field1134 = 0;
      field1180 = new int[1000];
      field900 = new int[1000];
      field1137 = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1087 = 0;
      field1141 = 255;
      field1142 = -1;
      field1143 = false;
      field1144 = 127;
      field1041 = 127;
      field931 = 0;
      field1036 = new int[50];
      field1155 = new int[50];
      field1150 = new int[50];
      field1170 = new int[50];
      audioEffects = new SoundEffect[50];
      field1152 = false;
      field1153 = new boolean[5];
      field1129 = new int[5];
      field1015 = new int[5];
      field1156 = new int[5];
      field982 = new int[5];
      field988 = 256;
      field1147 = 205;
      field1160 = 256;
      field904 = 320;
      field1162 = 1;
      field1163 = 32767;
      field1164 = 1;
      field1165 = 32767;
      field1166 = 0;
      field1167 = 0;
      viewportHeight = 0;
      viewportWidth = 0;
      scale = 0;
      friendCount = 0;
      field1172 = 0;
      friends = new Friend[400];
      field973 = new class195();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1177 = new PlayerComposition();
      field993 = -1;
      field1179 = 1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field1182 = -1L;
      field1183 = -1L;
      field997 = new class73();
      field945 = new int[50];
      field1034 = new int[50];
   }
}
