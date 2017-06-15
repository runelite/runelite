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
   static int field921;
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
   static int field951;
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
   @Export("detinationX")
   static int detinationX;
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
                  int var7 = Integer.parseInt(var5);
                  class231[] var8 = class15.method107();
                  int var9 = 0;

                  class231 var6;
                  while(true) {
                     if(var9 >= var8.length) {
                        var6 = null;
                        break;
                     }

                     class231 var10 = var8[var9];
                     if(var10.field3195 == var7) {
                        var6 = var10;
                        break;
                     }

                     ++var9;
                  }

                  class12.field275 = var6;
                  break;
               case 14:
                  field908 = Integer.parseInt(var5);
               }
            }
         }

         Region.field2072 = false;
         field1055 = false;
         class40.host = this.getCodeBase().getHost();
         String var14 = class12.field275.field3194;
         byte var11 = 0;

         try {
            class59.method960("oldschool", var14, var11, 17);
         } catch (Exception var13) {
            class8.method43((String)null, var13);
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
         Deque var2 = class236.field3245;
         FileSystem var1;
         synchronized(class236.field3245) {
            var1 = (FileSystem)class236.field3240.method3485();
         }

         if(var1 == null) {
            class7.method36();
            class69.method1035();
            class50 var11 = class50.keyboard;
            synchronized(class50.keyboard) {
               ++class50.keyboardIdleTicks;
               class50.field658 = class50.field665;
               class50.field657 = 0;
               int var6;
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

            class59 var12 = class59.mouse;
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

            int var7;
            if(class36.field517 != null) {
               var7 = class36.field517.vmethod2858();
               field1186 = var7;
            }

            if(gameState == 0) {
               class24.method198();
               GameEngine.field707.vmethod2872();

               for(var7 = 0; var7 < 32; ++var7) {
                  GameEngine.field702[var7] = 0L;
               }

               for(var7 = 0; var7 < 32; ++var7) {
                  GameEngine.field703[var7] = 0L;
               }

               GameEngine.field697 = 0;
            } else if(gameState == 5) {
               class7.method35(this);
               class24.method198();
               GameEngine.field707.vmethod2872();

               for(var7 = 0; var7 < 32; ++var7) {
                  GameEngine.field702[var7] = 0L;
               }

               for(var7 = 0; var7 < 32; ++var7) {
                  GameEngine.field703[var7] = 0L;
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

         var1.data.method4100(var1.index, (int)var1.hash, var1.field3210, false);
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-112"
   )
   protected final void vmethod1104(boolean var1) {
      boolean var2;
      label165: {
         try {
            if(class203.field2517 == 2) {
               if(class98.field1522 == null) {
                  class98.field1522 = Track1.method3800(class203.field2518, class203.field2519, class29.field438);
                  if(class98.field1522 == null) {
                     var2 = false;
                     break label165;
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
                  break label165;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
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
         WorldMapType2.method508(class241.method4167());
      }

      int var4;
      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1111[var4] = true;
         }
      }

      if(gameState == 0) {
         this.method823(class92.field1429, class92.field1446, var1);
      } else if(gameState == 5) {
         class33.method352(class64.field788, class5.field39, WallObject.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class33.method352(class64.field788, class5.field39, WallObject.font_p12full, var1);
         } else if(gameState == 25) {
            if(field1113 == 1) {
               if(field1117 > field961) {
                  field961 = field1117;
               }

               var4 = (field961 * 50 - field1117 * 50) / field961;
               class158.method2877("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field1113 == 2) {
               if(field1127 > field1023) {
                  field1023 = field1127;
               }

               var4 = (field1023 * 50 - field1127 * 50) / field1023 + 50;
               class158.method2877("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class158.method2877("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1334();
         } else if(gameState == 40) {
            class158.method2877("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class158.method2877("Please wait...", false);
         }
      } else {
         class33.method352(class64.field788, class5.field39, WallObject.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1) {
         for(var4 = 0; var4 < field1109; ++var4) {
            if(field1112[var4]) {
               World.field1296.vmethod4896(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field1112[var4] = false;
            }
         }
      } else if(gameState > 0) {
         World.field1296.vmethod4897(0, 0);

         for(var4 = 0; var4 < field1109; ++var4) {
            field1112[var4] = false;
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
                  if(class59.field726.field2237 == 2) {
                     this.method1158(-1);
                     return;
                  }

                  if(class59.field726.field2237 == 1) {
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
                     int var2 = class2.rssocket.readByte();
                     if(var2 != 0) {
                        this.method1158(var2);
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
            } catch (IOException var3) {
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
               WidgetNode.rssocket.method2879();
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

            if(class5.field38.field2237 == 2) {
               throw new IOException();
            }

            if(class5.field38.field2237 == 1) {
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
            int[] var6 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class11.field272 >> 32), (int)(class11.field272 & -1L)};
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(1);
            secretPacketBuffer1.putByte(class92.field1438.vmethod4906());
            secretPacketBuffer1.putInt(var6[0]);
            secretPacketBuffer1.putInt(var6[1]);
            secretPacketBuffer1.putInt(var6[2]);
            secretPacketBuffer1.putInt(var6[3]);
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
            secretPacketBuffer1.method3054(class90.rsaKeyExponent, class90.rsaKeyModulus);
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
            Buffer var4 = new Buffer(class19.field337.method5228());
            class19.field337.method5233(var4);
            field907.putBytes(var4.payload, 0, var4.payload.length);
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
            field907.encryptXtea(var6, var3, field907.offset);
            field907.method3156(field907.offset - var2);
            WidgetNode.rssocket.queueForWrite(field907.payload, 0, field907.offset);
            secretPacketBuffer1.seed(var6);

            for(int var5 = 0; var5 < 4; ++var5) {
               var6[var5] += 50;
            }

            secretPacketBuffer2.seed(var6);
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
            boolean var11;
            if(loginState == 9 && WidgetNode.rssocket.available() >= 13) {
               boolean var12 = WidgetNode.rssocket.readByte() == 1;
               WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, 4);
               secretPacketBuffer2.offset = 0;
               var11 = false;
               if(var12) {
                  var2 = secretPacketBuffer2.readOpcode() << 24;
                  var2 |= secretPacketBuffer2.readOpcode() << 16;
                  var2 |= secretPacketBuffer2.readOpcode() << 8;
                  var2 |= secretPacketBuffer2.readOpcode();
                  var3 = class96.method1689(class92.username);
                  if(Item.field1481.preferences.size() >= 10 && !Item.field1481.preferences.containsKey(Integer.valueOf(var3))) {
                     Iterator var13 = Item.field1481.preferences.entrySet().iterator();
                     var13.next();
                     var13.remove();
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
               field951 = secretPacketBuffer2.readOpcode();
               WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();

               try {
                  Client var7 = class220.field2817;
                  JSObject.getWindow(var7).call("zap", (Object[])null);
               } catch (Throwable var9) {
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
                  String var15 = secretPacketBuffer2.readString();
                  String var17 = secretPacketBuffer2.readString();
                  String var16 = secretPacketBuffer2.readString();
                  class47.method674(var15, var17, var16);
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
                     if(secretPacketBuffer2.offset != var1) {
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
            } else {
               if(WidgetNode.rssocket.available() >= packetLength) {
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
                  field951 = -1;
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
                  detinationX = 0;
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
                     class241 var8 = class25.method203(var1);
                     if(var8 != null) {
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
                           var11 = true;

                           for(var3 = 0; var3 < Widget.widgets[var1].length; ++var3) {
                              if(Widget.widgets[var1][var3] != null) {
                                 if(Widget.widgets[var1][var3].type != 2) {
                                    Widget.widgets[var1][var3] = null;
                                 } else {
                                    var11 = false;
                                 }
                              }
                           }

                           if(var11) {
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
                  field951 = -1;
               }

            }
         }
      } catch (IOException var10) {
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
            class52.method733(class220.field2817, "resize", new Object[]{Integer.valueOf(class241.method4167())});
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
      if(class165.field2335 == null) {
         if(field1079 == null) {
            int var2;
            int var4;
            int var5;
            int var19;
            label287: {
               int var1 = class59.field736;
               int var3;
               int var6;
               int var8;
               int var10;
               if(isMenuOpen) {
                  if(var1 != 1 && (class221.field2845 || var1 != 4)) {
                     var2 = class59.field730;
                     var3 = class59.field731;
                     if(var2 < class109.menuX - 10 || var2 > class154.menuWidth + class109.menuX + 10 || var3 < class24.menuY - 10 || var3 > class37.menuHeight + class24.menuY + 10) {
                        isMenuOpen = false;
                        ChatLineBuffer.method1777(class109.menuX, class24.menuY, class154.menuWidth, class37.menuHeight);
                     }
                  }

                  if(var1 == 1 || !class221.field2845 && var1 == 4) {
                     var2 = class109.menuX;
                     var3 = class24.menuY;
                     var4 = class154.menuWidth;
                     var5 = class59.field737;
                     var6 = class59.field732;
                     int var18 = -1;

                     for(var8 = 0; var8 < menuOptionCount; ++var8) {
                        var19 = var3 + 31 + (menuOptionCount - 1 - var8) * 15;
                        if(var5 > var2 && var5 < var4 + var2 && var6 > var19 - 13 && var6 < var19 + 3) {
                           var18 = var8;
                        }
                     }

                     if(var18 != -1 && var18 >= 0) {
                        var8 = menuActionParams0[var18];
                        var19 = menuActionParams1[var18];
                        var10 = menuTypes[var18];
                        int var11 = menuIdentifiers[var18];
                        String var12 = menuOptions[var18];
                        String var13 = menuTargets[var18];
                        class116.menuAction(var8, var19, var10, var11, var12, var13, class59.field737, class59.field732);
                     }

                     isMenuOpen = false;
                     ChatLineBuffer.method1777(class109.menuX, class24.menuY, class154.menuWidth, class37.menuHeight);
                  }
               } else {
                  var2 = class230.method3976();
                  if((var1 == 1 || !class221.field2845 && var1 == 4) && var2 >= 0) {
                     var3 = menuTypes[var2];
                     if(var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
                        var4 = menuActionParams0[var2];
                        var5 = menuActionParams1[var2];
                        Widget var14 = class223.method3959(var5);
                        var8 = class15.method92(var14);
                        boolean var7 = (var8 >> 28 & 1) != 0;
                        if(var7) {
                           break label287;
                        }

                        var10 = class15.method92(var14);
                        boolean var9 = (var10 >> 29 & 1) != 0;
                        if(var9) {
                           break label287;
                        }
                     }
                  }

                  if(var1 == 1 || !class221.field2845 && var1 == 4) {
                     label293: {
                        label210: {
                           if(field1043 == 1 && menuOptionCount > 2) {
                              boolean var17;
                              if(menuOptionCount <= 0) {
                                 var17 = false;
                              } else if(field989 && class50.field660[81] && field1053 != -1) {
                                 var17 = true;
                              } else {
                                 var17 = false;
                              }

                              if(!var17) {
                                 break label210;
                              }
                           }

                           if(!WorldMapData.method351(var2)) {
                              break label293;
                           }
                        }

                        var1 = 2;
                     }
                  }

                  if((var1 == 1 || !class221.field2845 && var1 == 4) && menuOptionCount > 0 && var2 >= 0) {
                     var3 = menuActionParams0[var2];
                     var4 = menuActionParams1[var2];
                     var5 = menuTypes[var2];
                     var6 = menuIdentifiers[var2];
                     String var15 = menuOptions[var2];
                     String var16 = menuTargets[var2];
                     class116.menuAction(var3, var4, var5, var6, var15, var16, class59.field737, class59.field732);
                  }

                  if(var1 == 2 && menuOptionCount > 0) {
                     this.method1116(class59.field737, class59.field732);
                  }
               }

               return;
            }

            if(class165.field2335 != null && !field1107) {
               var19 = class230.method3976();
               if(field1043 != 1 && !WorldMapData.method351(var19) && menuOptionCount > 0) {
                  MessageNode.method1057(field911, field985);
               }
            }

            field1107 = false;
            field1024 = 0;
            if(class165.field2335 != null) {
               XItemContainer.method1020(class165.field2335);
            }

            class165.field2335 = class223.method3959(var5);
            field1019 = var4;
            field911 = class59.field737;
            field985 = class59.field732;
            if(var2 >= 0) {
               class10.method58(var2);
            }

            XItemContainer.method1020(class165.field2335);
         }
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
      class154.menuWidth = var3;
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
      field921 = 0;
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
      field951 = 0;
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
      detinationX = 0;
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
      FileOnDisk var2 = null;
      Preferences var3 = new Preferences();

      try {
         var2 = TextureProvider.getPreferencesFile("", field1169.field3200, false);
         byte[] var4 = new byte[(int)var2.method2266()];

         int var6;
         for(int var5 = 0; var5 < var4.length; var5 += var6) {
            var6 = var2.method2267(var4, var5, var4.length - var5);
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
            var2.method2274();
         }
      } catch (Exception var7) {
         ;
      }

      Item.field1481 = var3;
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

         if(field1079.width + var1 > field1093 + field1080.width) {
            var1 = field1080.width + field1093 - field1079.width;
         }

         if(var2 < field1086) {
            var2 = field1086;
         }

         if(var2 + field1079.height > field1086 + field1080.height) {
            var2 = field1080.height + field1086 - field1079.height;
         }

         int var3 = var1 - field981;
         int var4 = var2 - field1089;
         int var5 = field1079.field2730;
         if(class33.field478 > field1079.field2717 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1090 = true;
         }

         int var6 = field1080.scrollX + (var1 - field1093);
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
                  secretPacketBuffer1.method3077(field963.id);
                  secretPacketBuffer1.method3065(field963.index);
                  secretPacketBuffer1.method3067(field1079.index);
                  secretPacketBuffer1.method3077(field1079.id);
                  secretPacketBuffer1.putShort(field963.itemId);
                  secretPacketBuffer1.method3067(field1079.itemId);
               }
            } else {
               label132: {
                  int var10 = class230.method3976();
                  if(menuOptionCount > 2) {
                     label129: {
                        label97: {
                           if(field1043 == 1) {
                              boolean var9;
                              if(menuOptionCount <= 0) {
                                 var9 = false;
                              } else if(field989 && class50.field660[81] && field1053 != -1) {
                                 var9 = true;
                              } else {
                                 var9 = false;
                              }

                              if(!var9) {
                                 break label97;
                              }
                           }

                           if(!WorldMapData.method351(var10)) {
                              break label129;
                           }
                        }

                        this.method1116(field1081 + field981, field1082 + field1089);
                        break label132;
                     }
                  }

                  if(menuOptionCount > 0) {
                     MessageNode.method1057(field1081 + field981, field1082 + field1089);
                  }
               }
            }

            field1079 = null;
         }

      } else {
         if(class33.field478 > 1) {
            field1079 = null;
         }

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
      if(field936 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.method816("js5connect_full");
            gameState = 1000;
         } else {
            field1021 = 3000;
         }
      } else if(field936 >= 2 && var1 == 6) {
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
         WidgetNode.rssocket.method2879();
         WidgetNode.rssocket = null;
      }

      class116.method2024();
      if(class59.mouse != null) {
         class59 var1 = class59.mouse;
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
         class238.field3258.method2879();
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
         for(var1 = 0; var1 < 100 && this.method1278(); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(class18.method149()) {
               secretPacketBuffer1.putOpcode(160);
               secretPacketBuffer1.putByte(0);
               var1 = secretPacketBuffer1.offset;
               class241.method4168(secretPacketBuffer1);
               secretPacketBuffer1.method3030(secretPacketBuffer1.offset - var1);
            }

            Object var13 = field913.field841;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            synchronized(field913.field841) {
               if(!field1122) {
                  field913.field843 = 0;
               } else if(class59.field736 != 0 || field913.field843 >= 40) {
                  secretPacketBuffer1.putOpcode(168);
                  secretPacketBuffer1.putByte(0);
                  var2 = secretPacketBuffer1.offset;
                  var3 = 0;

                  for(var4 = 0; var4 < field913.field843 && secretPacketBuffer1.offset - var2 < 240; ++var4) {
                     ++var3;
                     var5 = field913.field844[var4];
                     if(var5 < 0) {
                        var5 = 0;
                     } else if(var5 > 502) {
                        var5 = 502;
                     }

                     var6 = field913.field842[var4];
                     if(var6 < 0) {
                        var6 = 0;
                     } else if(var6 > 764) {
                        var6 = 764;
                     }

                     var7 = var5 * 765 + var6;
                     if(field913.field844[var4] == -1 && field913.field842[var4] == -1) {
                        var6 = -1;
                        var5 = -1;
                        var7 = 524287;
                     }

                     if(var6 == field914 && field915 == var5) {
                        if(field916 < 2047) {
                           ++field916;
                        }
                     } else {
                        var8 = var6 - field914;
                        field914 = var6;
                        var9 = var5 - field915;
                        field915 = var5;
                        if(field916 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                           var8 += 32;
                           var9 += 32;
                           secretPacketBuffer1.putShort((var8 << 6) + (field916 << 12) + var9);
                           field916 = 0;
                        } else if(field916 < 8) {
                           secretPacketBuffer1.put24bitInt((field916 << 19) + 8388608 + var7);
                           field916 = 0;
                        } else {
                           secretPacketBuffer1.putInt((field916 << 19) + -1073741824 + var7);
                           field916 = 0;
                        }
                     }
                  }

                  secretPacketBuffer1.method3030(secretPacketBuffer1.offset - var2);
                  if(var3 >= field913.field843) {
                     field913.field843 = 0;
                  } else {
                     field913.field843 -= var3;

                     for(var4 = 0; var4 < field913.field843; ++var4) {
                        field913.field842[var4] = field913.field842[var4 + var3];
                        field913.field844[var4] = field913.field844[var3 + var4];
                     }
                  }
               }
            }

            if(class59.field736 == 1 || !class221.field2845 && class59.field736 == 4 || class59.field736 == 2) {
               long var14 = (class59.field739 - field1028) / 50L;
               if(var14 > 4095L) {
                  var14 = 4095L;
               }

               field1028 = class59.field739;
               var3 = class59.field732;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > class1.canvasHeight) {
                  var3 = class1.canvasHeight;
               }

               var4 = class59.field737;
               if(var4 < 0) {
                  var4 = 0;
               } else if(var4 > class10.canvasWidth) {
                  var4 = class10.canvasWidth;
               }

               var5 = (int)var14;
               secretPacketBuffer1.putOpcode(101);
               secretPacketBuffer1.putShort((class59.field736 == 2?1:0) + (var5 << 1));
               secretPacketBuffer1.putShort(var4);
               secretPacketBuffer1.putShort(var3);
            }

            if(class50.field657 > 0) {
               secretPacketBuffer1.putOpcode(172);
               secretPacketBuffer1.putShort(0);
               var1 = secretPacketBuffer1.offset;
               long var16 = class166.method2970();

               for(var4 = 0; var4 < class50.field657; ++var4) {
                  long var18 = var16 - field1130;
                  if(var18 > 16777215L) {
                     var18 = 16777215L;
                  }

                  field1130 = var16;
                  secretPacketBuffer1.method3135((int)var18);
                  secretPacketBuffer1.method3196(class50.field656[var4]);
               }

               secretPacketBuffer1.method3156(secretPacketBuffer1.offset - var1);
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
               secretPacketBuffer1.method3065(field1159);
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
                     SoundEffect var20 = audioEffects[var1];
                     if(var20 == null) {
                        Object var10000 = null;
                        var20 = SoundEffect.method1843(class66.field799, field1036[var1], 0);
                        if(var20 == null) {
                           continue;
                        }

                        field1150[var1] += var20.method1838();
                        audioEffects[var1] = var20;
                     }

                     if(field1150[var1] < 0) {
                        if(field1170[var1] != 0) {
                           var4 = (field1170[var1] & 255) * 128;
                           var5 = field1170[var1] >> 16 & 255;
                           var6 = var5 * 128 + 64 - class20.localPlayer.x;
                           if(var6 < 0) {
                              var6 = -var6;
                           }

                           var7 = field1170[var1] >> 8 & 255;
                           var8 = var7 * 128 + 64 - class20.localPlayer.y;
                           if(var8 < 0) {
                              var8 = -var8;
                           }

                           var9 = var6 + var8 - 128;
                           if(var9 > var4) {
                              field1150[var1] = -100;
                              continue;
                           }

                           if(var9 < 0) {
                              var9 = 0;
                           }

                           var3 = field1041 * (var4 - var9) / var4;
                        } else {
                           var3 = field1144;
                        }

                        if(var3 > 0) {
                           class107 var21 = var20.method1839().method1881(class59.field724);
                           class117 var22 = class117.method2038(var21, 100, var3);
                           var22.method2149(field1155[var1] - 1);
                           WorldMapType1.field442.method1806(var22);
                        }

                        field1150[var1] = -100;
                     }
                  } else {
                     --field931;

                     for(var2 = var1; var2 < field931; ++var2) {
                        field1036[var2] = field1036[var2 + 1];
                        audioEffects[var2] = audioEffects[var2 + 1];
                        field1155[var2] = field1155[var2 + 1];
                        field1150[var2] = field1150[var2 + 1];
                        field1170[var2] = field1170[var2 + 1];
                     }

                     --var1;
                  }
               }

               if(field1143) {
                  boolean var28;
                  if(class203.field2517 != 0) {
                     var28 = true;
                  } else {
                     var28 = class203.field2516.method3675();
                  }

                  if(!var28) {
                     if(field1141 != 0 && field1142 != -1) {
                        class13.method75(FaceNormal.indexTrack1, field1142, 0, field1141, false);
                     }

                     field1143 = false;
                  }
               }

               ++field952;
               if(field952 > 750) {
                  if(field957 > 0) {
                     TextureProvider.method2306();
                  } else {
                     class23.setGameState(40);
                     class222.field2846 = WidgetNode.rssocket;
                     WidgetNode.rssocket = null;
                  }

               } else {
                  var1 = class96.field1487;
                  int[] var34 = class96.field1491;

                  for(var3 = 0; var3 < var1; ++var3) {
                     Player var35 = cachedPlayers[var34[var3]];
                     if(var35 != null) {
                        WorldMapType1.method272(var35, 1);
                     }
                  }

                  class14.method88();
                  int[] var32 = class96.field1491;

                  for(var2 = 0; var2 < class96.field1487; ++var2) {
                     Player var23 = cachedPlayers[var32[var2]];
                     if(var23 != null && var23.field1234 > 0) {
                        --var23.field1234;
                        if(var23.field1234 == 0) {
                           var23.overhead = null;
                        }
                     }
                  }

                  for(var2 = 0; var2 < field930; ++var2) {
                     var3 = npcIndices[var2];
                     NPC var37 = cachedNPCs[var3];
                     if(var37 != null && var37.field1234 > 0) {
                        --var37.field1234;
                        if(var37.field1234 == 0) {
                           var37.overhead = null;
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

                  Widget var33 = Item.field1476;
                  Widget var36 = class12.field280;
                  Item.field1476 = null;
                  class12.field280 = null;
                  field963 = null;
                  field980 = false;
                  field1084 = false;
                  field1132 = 0;

                  while(class7.method34() && field1132 < 128) {
                     if(rights >= 2 && class50.field660[82] && class146.field2171 == 66) {
                        String var40 = class71.method1050();
                        class220.field2817.method813(var40);
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
                     Widget var38;
                     Widget var39;
                     class69 var41;
                     do {
                        var41 = (class69)field1106.method3485();
                        if(var41 == null) {
                           while(true) {
                              do {
                                 var41 = (class69)field1136.method3485();
                                 if(var41 == null) {
                                    while(true) {
                                       do {
                                          var41 = (class69)field1105.method3485();
                                          if(var41 == null) {
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
                                                         Widget var42 = class165.field2335;
                                                         byte var31 = 0;
                                                         if(field1069 == 1 && var42.contentType == 206) {
                                                            var31 = 1;
                                                         }

                                                         if(var42.itemIds[field1022] <= 0) {
                                                            var31 = 0;
                                                         }

                                                         var6 = class15.method92(var42);
                                                         boolean var30 = (var6 >> 29 & 1) != 0;
                                                         if(var30) {
                                                            var7 = field1019;
                                                            var8 = field1022;
                                                            var42.itemIds[var8] = var42.itemIds[var7];
                                                            var42.itemQuantities[var8] = var42.itemQuantities[var7];
                                                            var42.itemIds[var7] = -1;
                                                            var42.itemQuantities[var7] = 0;
                                                         } else if(var31 == 1) {
                                                            var7 = field1019;
                                                            var8 = field1022;

                                                            while(var7 != var8) {
                                                               if(var7 > var8) {
                                                                  var42.method3929(var7 - 1, var7);
                                                                  --var7;
                                                               } else if(var7 < var8) {
                                                                  var42.method3929(var7 + 1, var7);
                                                                  ++var7;
                                                               }
                                                            }
                                                         } else {
                                                            var42.method3929(field1022, field1019);
                                                         }

                                                         secretPacketBuffer1.putOpcode(237);
                                                         secretPacketBuffer1.method3066(field1022);
                                                         secretPacketBuffer1.putInt(class165.field2335.id);
                                                         secretPacketBuffer1.method3067(field1019);
                                                         secretPacketBuffer1.method3059(var31);
                                                      }
                                                   } else {
                                                      label1131: {
                                                         label1149: {
                                                            var3 = class230.method3976();
                                                            if(menuOptionCount > 2) {
                                                               if(field1043 == 1) {
                                                                  boolean var29;
                                                                  if(menuOptionCount <= 0) {
                                                                     var29 = false;
                                                                  } else if(field989 && class50.field660[81] && field1053 != -1) {
                                                                     var29 = true;
                                                                  } else {
                                                                     var29 = false;
                                                                  }

                                                                  if(!var29) {
                                                                     break label1149;
                                                                  }
                                                               }

                                                               if(WorldMapData.method351(var3)) {
                                                                  break label1149;
                                                               }
                                                            }

                                                            if(menuOptionCount > 0) {
                                                               MessageNode.method1057(field911, field985);
                                                            }
                                                            break label1131;
                                                         }

                                                         this.method1116(field911, field985);
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
                                                var3 = Region.selectedRegionTileX;
                                                var4 = Region.selectedRegionTileY;
                                                secretPacketBuffer1.putOpcode(203);
                                                secretPacketBuffer1.putByte(5);
                                                secretPacketBuffer1.method3066(class19.baseX + var3);
                                                secretPacketBuffer1.method3066(var4 + class21.baseY);
                                                secretPacketBuffer1.method3196(class50.field660[82]?(class50.field660[81]?2:1):0);
                                                Region.method2618();
                                                field1013 = class59.field737;
                                                field1115 = class59.field732;
                                                cursorState = 1;
                                                field906 = 0;
                                                detinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(Item.field1476 != var33) {
                                                if(var33 != null) {
                                                   XItemContainer.method1020(var33);
                                                }

                                                if(Item.field1476 != null) {
                                                   XItemContainer.method1020(Item.field1476);
                                                }
                                             }

                                             if(var36 != class12.field280 && field917 == field1058) {
                                                if(var36 != null) {
                                                   XItemContainer.method1020(var36);
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

                                             var3 = field969 + class20.localPlayer.x;
                                             var4 = class20.localPlayer.y + field971;
                                             if(class23.field367 - var3 < -500 || class23.field367 - var3 > 500 || DecorativeObject.field2178 - var4 < -500 || DecorativeObject.field2178 - var4 > 500) {
                                                class23.field367 = var3;
                                                DecorativeObject.field2178 = var4;
                                             }

                                             if(var3 != class23.field367) {
                                                class23.field367 += (var3 - class23.field367) / 16;
                                             }

                                             if(DecorativeObject.field2178 != var4) {
                                                DecorativeObject.field2178 += (var4 - DecorativeObject.field2178) / 16;
                                             }

                                             if(class59.field729 == 4 && class221.field2845) {
                                                var5 = class59.field731 - field994;
                                                field992 = var5 * 2;
                                                field994 = var5 != -1 && var5 != 1?(field994 + class59.field731) / 2:class59.field731;
                                                var6 = field1104 - class59.field730;
                                                field1088 = var6 * 2;
                                                field1104 = var6 != -1 && var6 != 1?(field1104 + class59.field730) / 2:class59.field730;
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

                                             var5 = class23.field367 >> 7;
                                             var6 = DecorativeObject.field2178 >> 7;
                                             var7 = class77.method1438(class23.field367, DecorativeObject.field2178, Player.plane);
                                             var8 = 0;
                                             if(var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
                                                for(var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
                                                   for(int var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                      int var11 = Player.plane;
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

                                             if(var9 > field998) {
                                                field998 += (var9 - field998) / 24;
                                             } else if(var9 < field998) {
                                                field998 += (var9 - field998) / 80;
                                             }

                                             if(field1152) {
                                                class219.method3949();
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field982[var3];
                                             }

                                             class66.chatMessages.method1709();
                                             var3 = ++class59.mouseIdleTicks - 1;
                                             var5 = class50.keyboardIdleTicks;
                                             if(var3 > 15000 && var5 > 15000) {
                                                field957 = 250;
                                                class35.method481(14500);
                                                secretPacketBuffer1.putOpcode(45);
                                             }

                                             ++field975;
                                             if(field975 > 500) {
                                                field975 = 0;
                                                var7 = (int)(Math.random() * 8.0D);
                                                if((var7 & 1) == 1) {
                                                   field969 += field970;
                                                }

                                                if((var7 & 2) == 2) {
                                                   field971 += field972;
                                                }

                                                if((var7 & 4) == 4) {
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
                                                var7 = (int)(Math.random() * 8.0D);
                                                if((var7 & 1) == 1) {
                                                   mapScale += mapOffset;
                                                }

                                                if((var7 & 2) == 2) {
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

                                             for(class67 var24 = (class67)field973.method3524(); var24 != null; var24 = (class67)field973.method3523()) {
                                                if((long)var24.field809 < class166.method2970() / 1000L - 5L) {
                                                   if(var24.field807 > 0) {
                                                      class5.sendGameMessage(5, "", var24.field805 + " has logged in.");
                                                   }

                                                   if(var24.field807 == 0) {
                                                      class5.sendGameMessage(5, "", var24.field805 + " has logged out.");
                                                   }

                                                   var24.method3529();
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
                                             } catch (IOException var26) {
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

                                          var38 = var41.field822;
                                          if(var38.index < 0) {
                                             break;
                                          }

                                          var39 = class223.method3959(var38.parentId);
                                       } while(var39 == null || var39.children == null || var38.index >= var39.children.length || var39.children[var38.index] != var38);

                                       class77.method1440(var41);
                                    }
                                 }

                                 var38 = var41.field822;
                                 if(var38.index < 0) {
                                    break;
                                 }

                                 var39 = class223.method3959(var38.parentId);
                              } while(var39 == null || var39.children == null || var38.index >= var39.children.length || var38 != var39.children[var38.index]);

                              class77.method1440(var41);
                           }
                        }

                        var38 = var41.field822;
                        if(var38.index < 0) {
                           break;
                        }

                        var39 = class223.method3959(var38.parentId);
                     } while(var39 == null || var39.children == null || var38.index >= var39.children.length || var39.children[var38.index] != var38);

                     class77.method1440(var41);
                  }
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
   final boolean method1278() {
      if(WidgetNode.rssocket == null) {
         return false;
      } else {
         int var3;
         String var25;
         try {
            int var1 = WidgetNode.rssocket.available();
            if(var1 == 0) {
               return false;
            }

            if(field951 == -1) {
               WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               field951 = secretPacketBuffer2.readOpcode();
               packetLength = class272.field3700[field951];
               --var1;
            }

            if(packetLength == -1) {
               if(var1 <= 0) {
                  return false;
               }

               WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               packetLength = secretPacketBuffer2.payload[0] & 255;
               --var1;
            }

            if(packetLength == -2) {
               if(var1 <= 1) {
                  return false;
               }

               WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();
               var1 -= 2;
            }

            if(var1 < packetLength) {
               return false;
            }

            secretPacketBuffer2.offset = 0;
            WidgetNode.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
            field952 = 0;
            field956 = field955;
            field955 = field1100 * -1;
            field1100 = field951 * -1;
            int var2;
            int var62;
            int var63;
            if(field951 == 206) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               var3 = secretPacketBuffer2.readUnsignedByte();
               var62 = secretPacketBuffer2.readUnsignedByte();
               var63 = secretPacketBuffer2.readUnsignedByte();
               field1153[var2] = true;
               field1129[var2] = var3;
               field1015[var2] = var62;
               field1156[var2] = var63;
               field982[var2] = 0;
               field951 = -1;
               return true;
            }

            if(field951 == 78) {
               if(widgetRoot != -1) {
                  class4.method13(widgetRoot, 0);
               }

               field951 = -1;
               return true;
            }

            if(field951 == 146) {
               for(var2 = 0; var2 < class211.widgetSettings.length; ++var2) {
                  if(class211.settings[var2] != class211.widgetSettings[var2]) {
                     class211.widgetSettings[var2] = class211.settings[var2];
                     class36.method483(var2);
                     field1092[++field1026 - 1 & 31] = var2;
                  }
               }

               field951 = -1;
               return true;
            }

            if(field951 == 71) {
               Item.field1480 = Player.method1095(secretPacketBuffer2.readUnsignedByte());
               field951 = -1;
               return true;
            }

            boolean var79;
            if(field951 == 101) {
               var79 = secretPacketBuffer2.readUnsignedByte() == 1;
               if(var79) {
                  Tile.field1921 = class166.method2970() - secretPacketBuffer2.readLong();
                  field1181 = new class13(secretPacketBuffer2, true);
               } else {
                  field1181 = null;
               }

               field1102 = field1091;
               field951 = -1;
               return true;
            }

            if(field951 == 24) {
               class29.field437 = secretPacketBuffer2.method3201();
               class27.field414 = secretPacketBuffer2.method3062();

               while(secretPacketBuffer2.offset < packetLength) {
                  field951 = secretPacketBuffer2.readUnsignedByte();
                  class34.method479();
               }

               field951 = -1;
               return true;
            }

            int var7;
            Widget var22;
            int var64;
            if(field951 == 33) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.readUnsignedShort();
               if(var2 < -70000) {
                  var3 += '耀';
               }

               if(var2 >= 0) {
                  var22 = class223.method3959(var2);
               } else {
                  var22 = null;
               }

               for(; secretPacketBuffer2.offset < packetLength; class92.method1649(var3, var63, var64 - 1, var7)) {
                  var63 = secretPacketBuffer2.method3046();
                  var64 = secretPacketBuffer2.readUnsignedShort();
                  var7 = 0;
                  if(var64 != 0) {
                     var7 = secretPacketBuffer2.readUnsignedByte();
                     if(var7 == 255) {
                        var7 = secretPacketBuffer2.readInt();
                     }
                  }

                  if(var22 != null && var63 >= 0 && var63 < var22.itemIds.length) {
                     var22.itemIds[var63] = var64;
                     var22.itemQuantities[var63] = var7;
                  }
               }

               if(var22 != null) {
                  XItemContainer.method1020(var22);
               }

               GameEngine.method864();
               interfaceItemTriggers[++field1095 - 1 & 31] = var3 & 32767;
               field951 = -1;
               return true;
            }

            if(field951 == 42) {
               field1172 = 1;
               field1099 = field1091;
               field951 = -1;
               return true;
            }

            Widget var83;
            if(field951 == 72) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.method3068();
               var62 = secretPacketBuffer2.method3070();
               var63 = secretPacketBuffer2.method3078();
               var83 = class223.method3959(var63);
               if(var3 != var83.rotationX || var2 != var83.rotationZ || var62 != var83.field2737) {
                  var83.rotationX = var3;
                  var83.rotationZ = var2;
                  var83.field2737 = var62;
                  XItemContainer.method1020(var83);
               }

               field951 = -1;
               return true;
            }

            if(field951 == 136) {
               field1087 = secretPacketBuffer2.readUnsignedByte();
               field951 = -1;
               return true;
            }

            if(field951 == 150) {
               class1.method0(true);
               field951 = -1;
               return true;
            }

            if(field951 == 55) {
               var2 = secretPacketBuffer2.method3078();
               class69.field834 = GameEngine.field691.method2838(var2);
               field951 = -1;
               return true;
            }

            Player var26;
            int var30;
            PacketBuffer var87;
            if(field951 == 82) {
               class23.xteaChanged(true);
               secretPacketBuffer2.readOpcode();
               var2 = secretPacketBuffer2.readUnsignedShort();
               var87 = secretPacketBuffer2;
               var62 = var87.offset;
               class96.field1493 = 0;
               var63 = 0;
               var87.method3291();

               for(var64 = 0; var64 < class96.field1487; ++var64) {
                  var7 = class96.field1491[var64];
                  if((class96.field1489[var7] & 1) == 0) {
                     if(var63 > 0) {
                        --var63;
                        class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                     } else {
                        var30 = var87.method3290(1);
                        if(var30 == 0) {
                           var63 = World.method1475(var87);
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        } else {
                           class2.method4(var87, var7);
                        }
                     }
                  }
               }

               var87.method3292();
               if(var63 != 0) {
                  throw new RuntimeException();
               }

               var87.method3291();

               for(var64 = 0; var64 < class96.field1487; ++var64) {
                  var7 = class96.field1491[var64];
                  if((class96.field1489[var7] & 1) != 0) {
                     if(var63 > 0) {
                        --var63;
                        class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                     } else {
                        var30 = var87.method3290(1);
                        if(var30 == 0) {
                           var63 = World.method1475(var87);
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        } else {
                           class2.method4(var87, var7);
                        }
                     }
                  }
               }

               var87.method3292();
               if(var63 != 0) {
                  throw new RuntimeException();
               }

               var87.method3291();

               for(var64 = 0; var64 < class96.field1499; ++var64) {
                  var7 = class96.field1495[var64];
                  if((class96.field1489[var7] & 1) != 0) {
                     if(var63 > 0) {
                        --var63;
                        class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                     } else {
                        var30 = var87.method3290(1);
                        if(var30 == 0) {
                           var63 = World.method1475(var87);
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        } else if(class29.method253(var87, var7)) {
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        }
                     }
                  }
               }

               var87.method3292();
               if(var63 != 0) {
                  throw new RuntimeException();
               }

               var87.method3291();

               for(var64 = 0; var64 < class96.field1499; ++var64) {
                  var7 = class96.field1495[var64];
                  if((class96.field1489[var7] & 1) == 0) {
                     if(var63 > 0) {
                        --var63;
                        class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                     } else {
                        var30 = var87.method3290(1);
                        if(var30 == 0) {
                           var63 = World.method1475(var87);
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        } else if(class29.method253(var87, var7)) {
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        }
                     }
                  }
               }

               var87.method3292();
               if(var63 != 0) {
                  throw new RuntimeException();
               }

               class96.field1487 = 0;
               class96.field1499 = 0;

               for(var64 = 1; var64 < 2048; ++var64) {
                  class96.field1489[var64] = (byte)(class96.field1489[var64] >> 1);
                  var26 = cachedPlayers[var64];
                  if(var26 != null) {
                     class96.field1491[++class96.field1487 - 1] = var64;
                  } else {
                     class96.field1495[++class96.field1499 - 1] = var64;
                  }
               }

               Item.method1665(var87);
               if(var87.offset - var62 != var2) {
                  throw new RuntimeException(var87.offset - var62 + " " + var2);
               }

               field951 = -1;
               return true;
            }

            int var9;
            int var14;
            PacketBuffer var99;
            String var103;
            if(field951 == 109) {
               var99 = secretPacketBuffer2;
               var3 = packetLength;
               ClassInfo var108 = new ClassInfo();
               var108.field3743 = var99.readUnsignedByte();
               var108.field3741 = var99.readInt();
               var108.field3748 = new int[var108.field3743];
               var108.field3744 = new int[var108.field3743];
               var108.fields = new Field[var108.field3743];
               var108.field3746 = new int[var108.field3743];
               var108.methods = new Method[var108.field3743];
               var108.args = new byte[var108.field3743][][];

               for(var63 = 0; var63 < var108.field3743; ++var63) {
                  try {
                     var64 = var99.readUnsignedByte();
                     String var72;
                     if(var64 != 0 && var64 != 1 && var64 != 2) {
                        if(var64 == 3 || var64 == 4) {
                           var103 = var99.readString();
                           var72 = var99.readString();
                           var9 = var99.readUnsignedByte();
                           String[] var73 = new String[var9];

                           for(int var74 = 0; var74 < var9; ++var74) {
                              var73[var74] = var99.readString();
                           }

                           String var101 = var99.readString();
                           byte[][] var75 = new byte[var9][];
                           if(var64 == 3) {
                              for(int var76 = 0; var76 < var9; ++var76) {
                                 var14 = var99.readInt();
                                 var75[var76] = new byte[var14];
                                 var99.readBytes(var75[var76], 0, var14);
                              }
                           }

                           var108.field3748[var63] = var64;
                           Class[] var107 = new Class[var9];

                           for(var14 = 0; var14 < var9; ++var14) {
                              var107[var14] = class83.method1560(var73[var14]);
                           }

                           Class var109 = class83.method1560(var101);
                           if(class83.method1560(var103).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var77 = class83.method1560(var103).getDeclaredMethods();
                           Method[] var78 = var77;

                           for(int var17 = 0; var17 < var78.length; ++var17) {
                              Method var18 = var78[var17];
                              if(Reflection.getMethodName(var18).equals(var72)) {
                                 Class[] var19 = Reflection.getParameterTypes(var18);
                                 if(var107.length == var19.length) {
                                    boolean var20 = true;

                                    for(int var21 = 0; var21 < var107.length; ++var21) {
                                       if(var107[var21] != var19[var21]) {
                                          var20 = false;
                                          break;
                                       }
                                    }

                                    if(var20 && var109 == var18.getReturnType()) {
                                       var108.methods[var63] = var18;
                                    }
                                 }
                              }
                           }

                           var108.args[var63] = var75;
                        }
                     } else {
                        var103 = var99.readString();
                        var72 = var99.readString();
                        var9 = 0;
                        if(var64 == 1) {
                           var9 = var99.readInt();
                        }

                        var108.field3748[var63] = var64;
                        var108.field3746[var63] = var9;
                        if(class83.method1560(var103).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var108.fields[var63] = Reflection.findField(class83.method1560(var103), var72);
                     }
                  } catch (ClassNotFoundException var55) {
                     var108.field3744[var63] = -1;
                  } catch (SecurityException var56) {
                     var108.field3744[var63] = -2;
                  } catch (NullPointerException var57) {
                     var108.field3744[var63] = -3;
                  } catch (Exception var58) {
                     var108.field3744[var63] = -4;
                  } catch (Throwable var59) {
                     var108.field3744[var63] = -5;
                  }
               }

               class280.field3749.method3441(var108);
               field951 = -1;
               return true;
            }

            if(field951 == 236) {
               GameEngine.method864();
               weight = secretPacketBuffer2.readShort();
               field1103 = field1091;
               field951 = -1;
               return true;
            }

            WidgetNode var110;
            if(field951 == 134) {
               var2 = secretPacketBuffer2.method3078();
               var3 = secretPacketBuffer2.method3068();
               var62 = secretPacketBuffer2.method3060();
               var110 = (WidgetNode)componentTable.method3425((long)var2);
               if(var110 != null) {
                  class67.method1027(var110, var3 != var110.id);
               }

               class67.method1028(var2, var3, var62);
               field951 = -1;
               return true;
            }

            Widget var31;
            if(field951 == 32) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.method3160();
               var62 = secretPacketBuffer2.method3023();
               var31 = class223.method3959(var3);
               var31.field2710 = var62 + (var2 << 16);
               field951 = -1;
               return true;
            }

            boolean var5;
            String var82;
            String var94;
            if(field951 == 17) {
               while(secretPacketBuffer2.offset < packetLength) {
                  var79 = secretPacketBuffer2.readUnsignedByte() == 1;
                  var94 = secretPacketBuffer2.readString();
                  var82 = secretPacketBuffer2.readString();
                  var63 = secretPacketBuffer2.readUnsignedShort();
                  var64 = secretPacketBuffer2.readUnsignedByte();
                  var7 = secretPacketBuffer2.readUnsignedByte();
                  boolean var115 = (var7 & 2) != 0;
                  boolean var69 = (var7 & 1) != 0;
                  if(var63 > 0) {
                     secretPacketBuffer2.readString();
                     secretPacketBuffer2.readUnsignedByte();
                     secretPacketBuffer2.readInt();
                  }

                  secretPacketBuffer2.readString();

                  for(int var32 = 0; var32 < friendCount; ++var32) {
                     Friend var27 = friends[var32];
                     if(!var79) {
                        if(var94.equals(var27.name)) {
                           if(var27.world != var63) {
                              boolean var113 = true;

                              for(class67 var106 = (class67)field973.method3524(); var106 != null; var106 = (class67)field973.method3523()) {
                                 if(var106.field805.equals(var94)) {
                                    if(var63 != 0 && var106.field807 == 0) {
                                       var106.method3529();
                                       var113 = false;
                                    } else if(var63 == 0 && var106.field807 != 0) {
                                       var106.method3529();
                                       var113 = false;
                                    }
                                 }
                              }

                              if(var113) {
                                 field973.method3525(new class67(var94, var63));
                              }

                              var27.world = var63;
                           }

                           var27.previousName = var82;
                           var27.rank = var64;
                           var27.field795 = var115;
                           var27.field792 = var69;
                           var94 = null;
                           break;
                        }
                     } else if(var82.equals(var27.name)) {
                        var27.name = var94;
                        var27.previousName = var82;
                        var94 = null;
                        break;
                     }
                  }

                  if(var94 != null && friendCount < 400) {
                     Friend var70 = new Friend();
                     friends[friendCount] = var70;
                     var70.name = var94;
                     var70.previousName = var82;
                     var70.world = var63;
                     var70.rank = var64;
                     var70.field795 = var115;
                     var70.field792 = var69;
                     ++friendCount;
                  }
               }

               field1172 = 2;
               field1099 = field1091;
               var79 = false;
               var3 = friendCount;

               while(var3 > 0) {
                  var79 = true;
                  --var3;

                  for(var62 = 0; var62 < var3; ++var62) {
                     var5 = false;
                     Friend var92 = friends[var62];
                     Friend var105 = friends[var62 + 1];
                     if(var92.world != world && world == var105.world) {
                        var5 = true;
                     }

                     if(!var5 && var92.world == 0 && var105.world != 0) {
                        var5 = true;
                     }

                     if(!var5 && !var92.field795 && var105.field795) {
                        var5 = true;
                     }

                     if(!var5 && !var92.field792 && var105.field792) {
                        var5 = true;
                     }

                     if(var5) {
                        Friend var71 = friends[var62];
                        friends[var62] = friends[var62 + 1];
                        friends[var62 + 1] = var71;
                        var79 = false;
                     }
                  }

                  if(var79) {
                     break;
                  }
               }

               field951 = -1;
               return true;
            }

            Widget var89;
            if(field951 == 127) {
               var2 = secretPacketBuffer2.method3116();
               var89 = class223.method3959(var2);
               var89.modelType = 3;
               var89.modelId = class20.localPlayer.composition.method3868();
               XItemContainer.method1020(var89);
               field951 = -1;
               return true;
            }

            if(field951 == 31) {
               var25 = secretPacketBuffer2.readString();
               var3 = secretPacketBuffer2.method3078();
               var22 = class223.method3959(var3);
               if(!var25.equals(var22.text)) {
                  var22.text = var25;
                  XItemContainer.method1020(var22);
               }

               field951 = -1;
               return true;
            }

            if(field951 == 224) {
               var2 = secretPacketBuffer2.method3078();
               var3 = secretPacketBuffer2.method3070();
               class211.settings[var3] = var2;
               if(class211.widgetSettings[var3] != var2) {
                  class211.widgetSettings[var3] = var2;
               }

               class36.method483(var3);
               field1092[++field1026 - 1 & 31] = var3;
               field951 = -1;
               return true;
            }

            if(field951 == 2) {
               field954 = secretPacketBuffer2.readUnsignedByte();
               field1123 = secretPacketBuffer2.readUnsignedByte();
               field951 = -1;
               return true;
            }

            if(field951 == 98 || field951 == 66 || field951 == 173 || field951 == 137 || field951 == 165 || field951 == 111 || field951 == 4 || field951 == 209 || field951 == 37 || field951 == 190) {
               class34.method479();
               field951 = -1;
               return true;
            }

            if(field951 == 113) {
               field919 = secretPacketBuffer2.method3023() * 30;
               field1103 = field1091;
               field951 = -1;
               return true;
            }

            String var112;
            if(field951 == 13) {
               var25 = secretPacketBuffer2.readString();
               class219.field2810 = var25;

               try {
                  var94 = class220.field2817.getParameter(class274.field3716.field3725);
                  var82 = class220.field2817.getParameter(class274.field3723.field3725);
                  var112 = var94 + "settings=" + var25 + "; version=1; path=/; domain=" + var82;
                  if(var25.length() == 0) {
                     var112 = var112 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var112 = var112 + "; Expires=" + class116.method2031(class166.method2970() + 94608000000L) + "; Max-Age=" + 94608000L;
                  }

                  Client var90 = class220.field2817;
                  var103 = "document.cookie=\"" + var112 + "\"";
                  JSObject.getWindow(var90).eval(var103);
               } catch (Throwable var53) {
                  ;
               }

               field951 = -1;
               return true;
            }

            if(field951 == 158) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.readInt();
               var62 = var2 >> 10 & 31;
               var63 = var2 >> 5 & 31;
               var64 = var2 & 31;
               var7 = (var62 << 19) + (var63 << 11) + (var64 << 3);
               Widget var68 = class223.method3959(var3);
               if(var68.textColor != var7) {
                  var68.textColor = var7;
                  XItemContainer.method1020(var68);
               }

               field951 = -1;
               return true;
            }

            if(field951 == 15) {
               var2 = secretPacketBuffer2.method3023();
               var3 = secretPacketBuffer2.method3160();
               var22 = class223.method3959(var3);
               if(var22 != null && var22.type == 0) {
                  if(var2 > var22.scrollHeight - var22.height) {
                     var2 = var22.scrollHeight - var22.height;
                  }

                  if(var2 < 0) {
                     var2 = 0;
                  }

                  if(var22.scrollY != var2) {
                     var22.scrollY = var2;
                     XItemContainer.method1020(var22);
                  }
               }

               field951 = -1;
               return true;
            }

            if(field951 == 141) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.readUnsignedShort();
               if(var2 < -70000) {
                  var3 += '耀';
               }

               if(var2 >= 0) {
                  var22 = class223.method3959(var2);
               } else {
                  var22 = null;
               }

               if(var22 != null) {
                  for(var63 = 0; var63 < var22.itemIds.length; ++var63) {
                     var22.itemIds[var63] = 0;
                     var22.itemQuantities[var63] = 0;
                  }
               }

               class54.method748(var3);
               var63 = secretPacketBuffer2.readUnsignedShort();

               for(var64 = 0; var64 < var63; ++var64) {
                  var7 = secretPacketBuffer2.method3070();
                  var30 = secretPacketBuffer2.method3201();
                  if(var30 == 255) {
                     var30 = secretPacketBuffer2.method3116();
                  }

                  if(var22 != null && var64 < var22.itemIds.length) {
                     var22.itemIds[var64] = var7;
                     var22.itemQuantities[var64] = var30;
                  }

                  class92.method1649(var3, var64, var7 - 1, var30);
               }

               if(var22 != null) {
                  XItemContainer.method1020(var22);
               }

               GameEngine.method864();
               interfaceItemTriggers[++field1095 - 1 & 31] = var3 & 32767;
               field951 = -1;
               return true;
            }

            if(field951 == 167) {
               var2 = secretPacketBuffer2.method3060();
               var94 = secretPacketBuffer2.readString();
               var62 = secretPacketBuffer2.method3060();
               if(var2 >= 1 && var2 <= 8) {
                  if(var94.equalsIgnoreCase("null")) {
                     var94 = null;
                  }

                  playerOptions[var2 - 1] = var94;
                  playerOptionsPriorities[var2 - 1] = var62 == 0;
               }

               field951 = -1;
               return true;
            }

            long var36;
            long var38;
            long var40;
            if(field951 == 1) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.readInt();
               if(class17.field321 == null || !class17.field321.isValid()) {
                  try {
                     Iterator var97 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var97.hasNext()) {
                        GarbageCollectorMXBean var114 = (GarbageCollectorMXBean)var97.next();
                        if(var114.isValid()) {
                           class17.field321 = var114;
                           field1183 = -1L;
                           field1182 = -1L;
                        }
                     }
                  } catch (Throwable var54) {
                     ;
                  }
               }

               long var34 = class166.method2970();
               var64 = -1;
               if(class17.field321 != null) {
                  var36 = class17.field321.getCollectionTime();
                  if(-1L != field1182) {
                     var38 = var36 - field1182;
                     var40 = var34 - field1183;
                     if(0L != var40) {
                        var64 = (int)(var38 * 100L / var40);
                     }
                  }

                  field1182 = var36;
                  field1183 = var34;
               }

               secretPacketBuffer1.putOpcode(126);
               secretPacketBuffer1.method3114(var2);
               secretPacketBuffer1.putInt(var3);
               secretPacketBuffer1.method3069(GameEngine.FPS);
               secretPacketBuffer1.putByte(var64);
               field951 = -1;
               return true;
            }

            if(field951 == 238) {
               var25 = secretPacketBuffer2.readString();
               PacketBuffer var96 = secretPacketBuffer2;
               var94 = class162.method2947(var96, 32767);
               var112 = FontTypeFace.method4631(class210.method3816(var94));
               class5.sendGameMessage(6, var25, var112);
               field951 = -1;
               return true;
            }

            boolean var65;
            if(field951 == 63) {
               while(secretPacketBuffer2.offset < packetLength) {
                  var2 = secretPacketBuffer2.readUnsignedByte();
                  var65 = (var2 & 1) == 1;
                  var82 = secretPacketBuffer2.readString();
                  var112 = secretPacketBuffer2.readString();
                  secretPacketBuffer2.readString();

                  for(var64 = 0; var64 < ignoreCount; ++var64) {
                     Ignore var102 = ignores[var64];
                     if(var65) {
                        if(var112.equals(var102.name)) {
                           var102.name = var82;
                           var102.previousName = var112;
                           var82 = null;
                           break;
                        }
                     } else if(var82.equals(var102.name)) {
                        var102.name = var82;
                        var102.previousName = var112;
                        var82 = null;
                        break;
                     }
                  }

                  if(var82 != null && ignoreCount < 400) {
                     Ignore var88 = new Ignore();
                     ignores[ignoreCount] = var88;
                     var88.name = var82;
                     var88.previousName = var112;
                     ++ignoreCount;
                  }
               }

               field1099 = field1091;
               field951 = -1;
               return true;
            }

            if(field951 == 155) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               class211.method3822(var2);
               interfaceItemTriggers[++field1095 - 1 & 31] = var2 & 32767;
               field951 = -1;
               return true;
            }

            if(field951 == 218) {
               detinationX = secretPacketBuffer2.readUnsignedByte();
               if(detinationX == 255) {
                  detinationX = 0;
               }

               destinationY = secretPacketBuffer2.readUnsignedByte();
               if(destinationY == 255) {
                  destinationY = 0;
               }

               field951 = -1;
               return true;
            }

            if(field951 == 114) {
               field1152 = false;

               for(var2 = 0; var2 < 5; ++var2) {
                  field1153[var2] = false;
               }

               field951 = -1;
               return true;
            }

            if(field951 == 139) {
               var2 = secretPacketBuffer2.method3070();
               widgetRoot = var2;
               this.method1151(false);
               WorldMapType3.method219(var2);
               class64.method1022(widgetRoot);

               for(var3 = 0; var3 < 100; ++var3) {
                  field1111[var3] = true;
               }

               field951 = -1;
               return true;
            }

            if(field951 == 103) {
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

               field951 = -1;
               return true;
            }

            boolean var6;
            if(field951 == 140) {
               field1063 = field1091;
               if(packetLength == 0) {
                  clanChatOwner = null;
                  clanChatName = null;
                  XGrandExchangeOffer.clanChatCount = 0;
                  class177.clanMembers = null;
                  field951 = -1;
                  return true;
               }

               clanChatName = secretPacketBuffer2.readString();
               long var42 = secretPacketBuffer2.readLong();
               clanChatOwner = class174.method3252(var42);
               class22.field359 = secretPacketBuffer2.readByte();
               var62 = secretPacketBuffer2.readUnsignedByte();
               if(var62 == 255) {
                  field951 = -1;
                  return true;
               }

               XGrandExchangeOffer.clanChatCount = var62;
               XClanMember[] var111 = new XClanMember[100];

               for(var64 = 0; var64 < XGrandExchangeOffer.clanChatCount; ++var64) {
                  var111[var64] = new XClanMember();
                  var111[var64].username = secretPacketBuffer2.readString();
                  var111[var64].field892 = class109.method1965(var111[var64].username, class33.field482);
                  var111[var64].world = secretPacketBuffer2.readUnsignedShort();
                  var111[var64].rank = secretPacketBuffer2.readByte();
                  secretPacketBuffer2.readString();
                  if(var111[var64].username.equals(class20.localPlayer.name)) {
                     class226.clanChatRank = var111[var64].rank;
                  }
               }

               var6 = false;
               var30 = XGrandExchangeOffer.clanChatCount;

               while(var30 > 0) {
                  var6 = true;
                  --var30;

                  for(var9 = 0; var9 < var30; ++var9) {
                     if(var111[var9].field892.compareTo(var111[var9 + 1].field892) > 0) {
                        XClanMember var100 = var111[var9];
                        var111[var9] = var111[var9 + 1];
                        var111[var9 + 1] = var100;
                        var6 = false;
                     }
                  }

                  if(var6) {
                     break;
                  }
               }

               class177.clanMembers = var111;
               field951 = -1;
               return true;
            }

            if(field951 == 207) {
               var2 = secretPacketBuffer2.readInt();
               WidgetNode var93 = (WidgetNode)componentTable.method3425((long)var2);
               if(var93 != null) {
                  class67.method1027(var93, true);
               }

               if(field1070 != null) {
                  XItemContainer.method1020(field1070);
                  field1070 = null;
               }

               field951 = -1;
               return true;
            }

            if(field951 == 64) {
               var2 = secretPacketBuffer2.method3068();
               var3 = secretPacketBuffer2.method3160();
               var22 = class223.method3959(var3);
               if(var22.modelType != 1 || var22.modelId != var2) {
                  var22.modelType = 1;
                  var22.modelId = var2;
                  XItemContainer.method1020(var22);
               }

               field951 = -1;
               return true;
            }

            if(field951 == 93) {
               ChatLineBuffer.method1770();

               for(var2 = 0; var2 < 2048; ++var2) {
                  cachedPlayers[var2] = null;
               }

               class60.method965(secretPacketBuffer2);
               field951 = -1;
               return true;
            }

            if(field951 == 107) {
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

               field951 = -1;
               return true;
            }

            if(field951 == 247) {
               GameEngine.method864();
               var2 = secretPacketBuffer2.method3201();
               var3 = secretPacketBuffer2.method3078();
               var62 = secretPacketBuffer2.method3201();
               skillExperiences[var62] = var3;
               boostedSkillLevels[var62] = var2;
               realSkillLevels[var62] = 1;

               for(var63 = 0; var63 < 98; ++var63) {
                  if(var3 >= class222.field2851[var63]) {
                     realSkillLevels[var62] = var63 + 2;
                  }
               }

               field1174[++field1097 - 1 & 31] = var62;
               field951 = -1;
               return true;
            }

            if(field951 == 240) {
               secretPacketBuffer2.offset += 28;
               if(secretPacketBuffer2.method3056()) {
                  class61.method979(secretPacketBuffer2, secretPacketBuffer2.offset - 28);
               }

               field951 = -1;
               return true;
            }

            if(field951 == 164) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               if(var2 == -1 && !field1143) {
                  class203.field2516.method3579();
                  class203.field2517 = 1;
                  class203.field2518 = null;
               } else if(var2 != -1 && var2 != field1142 && field1141 != 0 && !field1143) {
                  IndexData var91 = FaceNormal.indexTrack1;
                  var62 = field1141;
                  class203.field2517 = 1;
                  class203.field2518 = var91;
                  class203.field2519 = var2;
                  class29.field438 = 0;
                  class182.field2455 = var62;
                  class88.field1384 = false;
                  CollisionData.field2304 = 2;
               }

               field1142 = var2;
               field951 = -1;
               return true;
            }

            if(field951 == 80) {
               var2 = secretPacketBuffer2.method3023();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var3 = secretPacketBuffer2.read24BitInt();
               GameEngine.method931(var2, var3);
               field951 = -1;
               return true;
            }

            if(field951 == 210) {
               var2 = secretPacketBuffer2.readInt();
               var65 = secretPacketBuffer2.method3060() == 1;
               var22 = class223.method3959(var2);
               if(var22.isHidden != var65) {
                  var22.isHidden = var65;
                  XItemContainer.method1020(var22);
               }

               field951 = -1;
               return true;
            }

            if(field951 == 239) {
               TextureProvider.method2306();
               field951 = -1;
               return false;
            }

            if(field951 == 120) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var3 = secretPacketBuffer2.readInt();
               var62 = secretPacketBuffer2.method3078();
               var31 = class223.method3959(var3);
               ItemComposition var85;
               if(!var31.hasScript) {
                  if(var2 == -1) {
                     var31.modelType = 0;
                     field951 = -1;
                     return true;
                  }

                  var85 = class224.getItemDefinition(var2);
                  var31.modelType = 4;
                  var31.modelId = var2;
                  var31.rotationX = var85.xan2d;
                  var31.rotationZ = var85.yan2d;
                  var31.field2737 = var85.zoom2d * 100 / var62;
                  XItemContainer.method1020(var31);
               } else {
                  var31.itemId = var2;
                  var31.itemQuantity = var62;
                  var85 = class224.getItemDefinition(var2);
                  var31.rotationX = var85.xan2d;
                  var31.rotationZ = var85.yan2d;
                  var31.rotationY = var85.zan2d;
                  var31.field2750 = var85.offsetX2d;
                  var31.field2731 = var85.offsetY2d;
                  var31.field2737 = var85.zoom2d;
                  if(var85.isStackable == 1) {
                     var31.field2712 = 1;
                  } else {
                     var31.field2712 = 2;
                  }

                  if(var31.field2709 > 0) {
                     var31.field2737 = var31.field2737 * 32 / var31.field2709;
                  } else if(var31.originalWidth > 0) {
                     var31.field2737 = var31.field2737 * 32 / var31.originalWidth;
                  }

                  XItemContainer.method1020(var31);
               }

               field951 = -1;
               return true;
            }

            if(field951 == 225) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               byte var66 = secretPacketBuffer2.method3063();
               class211.settings[var2] = var66;
               if(var66 != class211.widgetSettings[var2]) {
                  class211.widgetSettings[var2] = var66;
               }

               class36.method483(var2);
               field1092[++field1026 - 1 & 31] = var2;
               field951 = -1;
               return true;
            }

            if(field951 == 157) {
               class29.field437 = secretPacketBuffer2.method3062();
               class27.field414 = secretPacketBuffer2.readUnsignedByte();

               for(var2 = class27.field414; var2 < class27.field414 + 8; ++var2) {
                  for(var3 = class29.field437; var3 < class29.field437 + 8; ++var3) {
                     if(groundItemDeque[Player.plane][var2][var3] != null) {
                        groundItemDeque[Player.plane][var2][var3] = null;
                        class47.groundItemSpawned(var2, var3);
                     }
                  }
               }

               for(PendingSpawn var104 = (PendingSpawn)pendingSpawns.method3487(); var104 != null; var104 = (PendingSpawn)pendingSpawns.method3512()) {
                  if(var104.x >= class27.field414 && var104.x < class27.field414 + 8 && var104.y >= class29.field437 && var104.y < class29.field437 + 8 && var104.level == Player.plane) {
                     var104.hitpoints = 0;
                  }
               }

               field951 = -1;
               return true;
            }

            if(field951 == 119) {
               var2 = secretPacketBuffer2.method3046();
               var65 = secretPacketBuffer2.readUnsignedByte() == 1;
               var82 = "";
               var5 = false;
               if(var65) {
                  var82 = secretPacketBuffer2.readString();
                  if(class87.method1604(var82)) {
                     var5 = true;
                  }
               }

               String var84 = secretPacketBuffer2.readString();
               if(!var5) {
                  class5.sendGameMessage(var2, var82, var84);
               }

               field951 = -1;
               return true;
            }

            if(field951 == 59) {
               var2 = secretPacketBuffer2.method3116();
               var89 = class223.method3959(var2);

               for(var62 = 0; var62 < var89.itemIds.length; ++var62) {
                  var89.itemIds[var62] = -1;
                  var89.itemIds[var62] = 0;
               }

               XItemContainer.method1020(var89);
               field951 = -1;
               return true;
            }

            if(field951 == 204) {
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

               field951 = -1;
               return true;
            }

            if(field951 == 249) {
               field1152 = true;
               Item.field1479 = secretPacketBuffer2.readUnsignedByte();
               class18.field335 = secretPacketBuffer2.readUnsignedByte();
               class152.field2231 = secretPacketBuffer2.readUnsignedShort();
               MessageNode.field856 = secretPacketBuffer2.readUnsignedByte();
               class24.field372 = secretPacketBuffer2.readUnsignedByte();
               if(class24.field372 >= 100) {
                  var2 = Item.field1479 * 128 + 64;
                  var3 = class18.field335 * 128 + 64;
                  var62 = class77.method1438(var2, var3, Player.plane) - class152.field2231;
                  var63 = var2 - class14.cameraX;
                  var64 = var62 - class112.cameraZ;
                  var7 = var3 - class66.cameraY;
                  var30 = (int)Math.sqrt((double)(var7 * var7 + var63 * var63));
                  class203.cameraPitch = (int)(Math.atan2((double)var64, (double)var30) * 325.949D) & 2047;
                  class13.cameraYaw = (int)(Math.atan2((double)var63, (double)var7) * -325.949D) & 2047;
                  if(class203.cameraPitch < 128) {
                     class203.cameraPitch = 128;
                  }

                  if(class203.cameraPitch > 383) {
                     class203.cameraPitch = 383;
                  }
               }

               field951 = -1;
               return true;
            }

            String var29;
            long var44;
            long var46;
            if(field951 == 122) {
               var25 = secretPacketBuffer2.readString();
               var44 = secretPacketBuffer2.readLong();
               var46 = (long)secretPacketBuffer2.readUnsignedShort();
               var36 = (long)secretPacketBuffer2.read24BitInt();
               class230[] var116 = new class230[]{class230.field3180, class230.field3178, class230.field3187, class230.field3182, class230.field3179, class230.field3181};
               class230 var10 = (class230)RSCanvas.method735(var116, secretPacketBuffer2.readUnsignedByte());
               var40 = var36 + (var46 << 32);
               boolean var13 = false;

               for(var14 = 0; var14 < 100; ++var14) {
                  if(field942[var14] == var40) {
                     var13 = true;
                     break;
                  }
               }

               if(var10.field3186 && class87.method1604(var25)) {
                  var13 = true;
               }

               if(!var13 && field1025 == 0) {
                  field942[field1126] = var40;
                  field1126 = (field1126 + 1) % 100;
                  PacketBuffer var15 = secretPacketBuffer2;
                  var29 = class162.method2947(var15, 32767);
                  String var16 = FontTypeFace.method4631(class210.method3816(var29));
                  if(var10.field3184 != -1) {
                     class15.addChatMessage(9, RSCanvas.method741(var10.field3184) + var25, var16, class239.method4141(var44));
                  } else {
                     class15.addChatMessage(9, var25, var16, class239.method4141(var44));
                  }
               }

               field951 = -1;
               return true;
            }

            if(field951 == 188) {
               var25 = secretPacketBuffer2.readString();
               var44 = (long)secretPacketBuffer2.readUnsignedShort();
               var46 = (long)secretPacketBuffer2.read24BitInt();
               class230[] var98 = new class230[]{class230.field3180, class230.field3178, class230.field3187, class230.field3182, class230.field3179, class230.field3181};
               class230 var67 = (class230)RSCanvas.method735(var98, secretPacketBuffer2.readUnsignedByte());
               var38 = var46 + (var44 << 32);
               boolean var11 = false;

               for(int var33 = 0; var33 < 100; ++var33) {
                  if(field942[var33] == var38) {
                     var11 = true;
                     break;
                  }
               }

               if(class87.method1604(var25)) {
                  var11 = true;
               }

               if(!var11 && field1025 == 0) {
                  field942[field1126] = var38;
                  field1126 = (field1126 + 1) % 100;
                  PacketBuffer var28 = secretPacketBuffer2;
                  String var12 = class162.method2947(var28, 32767);
                  var29 = FontTypeFace.method4631(class210.method3816(var12));
                  byte var49;
                  if(var67.field3185) {
                     var49 = 7;
                  } else {
                     var49 = 3;
                  }

                  if(var67.field3184 != -1) {
                     class5.sendGameMessage(var49, RSCanvas.method741(var67.field3184) + var25, var29);
                  } else {
                     class5.sendGameMessage(var49, var25, var29);
                  }
               }

               field951 = -1;
               return true;
            }

            if(field951 == 35) {
               class23.xteaChanged(false);
               secretPacketBuffer2.readOpcode();
               var2 = secretPacketBuffer2.readUnsignedShort();
               var87 = secretPacketBuffer2;
               var62 = var87.offset;
               class96.field1493 = 0;
               var63 = 0;
               var87.method3291();

               for(var64 = 0; var64 < class96.field1487; ++var64) {
                  var7 = class96.field1491[var64];
                  if((class96.field1489[var7] & 1) == 0) {
                     if(var63 > 0) {
                        --var63;
                        class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                     } else {
                        var30 = var87.method3290(1);
                        if(var30 == 0) {
                           var63 = World.method1475(var87);
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        } else {
                           class2.method4(var87, var7);
                        }
                     }
                  }
               }

               var87.method3292();
               if(var63 != 0) {
                  throw new RuntimeException();
               }

               var87.method3291();

               for(var64 = 0; var64 < class96.field1487; ++var64) {
                  var7 = class96.field1491[var64];
                  if((class96.field1489[var7] & 1) != 0) {
                     if(var63 > 0) {
                        --var63;
                        class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                     } else {
                        var30 = var87.method3290(1);
                        if(var30 == 0) {
                           var63 = World.method1475(var87);
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        } else {
                           class2.method4(var87, var7);
                        }
                     }
                  }
               }

               var87.method3292();
               if(var63 != 0) {
                  throw new RuntimeException();
               }

               var87.method3291();

               for(var64 = 0; var64 < class96.field1499; ++var64) {
                  var7 = class96.field1495[var64];
                  if((class96.field1489[var7] & 1) != 0) {
                     if(var63 > 0) {
                        --var63;
                        class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                     } else {
                        var30 = var87.method3290(1);
                        if(var30 == 0) {
                           var63 = World.method1475(var87);
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        } else if(class29.method253(var87, var7)) {
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        }
                     }
                  }
               }

               var87.method3292();
               if(var63 != 0) {
                  throw new RuntimeException();
               }

               var87.method3291();

               for(var64 = 0; var64 < class96.field1499; ++var64) {
                  var7 = class96.field1495[var64];
                  if((class96.field1489[var7] & 1) == 0) {
                     if(var63 > 0) {
                        --var63;
                        class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                     } else {
                        var30 = var87.method3290(1);
                        if(var30 == 0) {
                           var63 = World.method1475(var87);
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        } else if(class29.method253(var87, var7)) {
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        }
                     }
                  }
               }

               var87.method3292();
               if(var63 != 0) {
                  throw new RuntimeException();
               }

               class96.field1487 = 0;
               class96.field1499 = 0;

               for(var64 = 1; var64 < 2048; ++var64) {
                  class96.field1489[var64] = (byte)(class96.field1489[var64] >> 1);
                  var26 = cachedPlayers[var64];
                  if(var26 != null) {
                     class96.field1491[++class96.field1487 - 1] = var64;
                  } else {
                     class96.field1495[++class96.field1499 - 1] = var64;
                  }
               }

               Item.method1665(var87);
               if(var2 != var87.offset - var62) {
                  throw new RuntimeException(var87.offset - var62 + " " + var2);
               }

               field951 = -1;
               return true;
            }

            if(field951 == 84) {
               class1.method0(false);
               field951 = -1;
               return true;
            }

            if(field951 == 219) {
               var2 = secretPacketBuffer2.offset + packetLength;
               var3 = secretPacketBuffer2.readUnsignedShort();
               var62 = secretPacketBuffer2.readUnsignedShort();
               if(var3 != widgetRoot) {
                  widgetRoot = var3;
                  this.method1151(false);
                  WorldMapType3.method219(widgetRoot);
                  class64.method1022(widgetRoot);

                  for(var63 = 0; var63 < 100; ++var63) {
                     field1111[var63] = true;
                  }
               }

               WidgetNode var8;
               for(; var62-- > 0; var8.field815 = true) {
                  var63 = secretPacketBuffer2.readInt();
                  var64 = secretPacketBuffer2.readUnsignedShort();
                  var7 = secretPacketBuffer2.readUnsignedByte();
                  var8 = (WidgetNode)componentTable.method3425((long)var63);
                  if(var8 != null && var8.id != var64) {
                     class67.method1027(var8, true);
                     var8 = null;
                  }

                  if(var8 == null) {
                     var8 = class67.method1028(var63, var64, var7);
                  }
               }

               for(var110 = (WidgetNode)componentTable.method3435(); var110 != null; var110 = (WidgetNode)componentTable.method3429()) {
                  if(var110.field815) {
                     var110.field815 = false;
                  } else {
                     class67.method1027(var110, true);
                  }
               }

               widgetFlags = new XHashTable(512);

               while(secretPacketBuffer2.offset < var2) {
                  var63 = secretPacketBuffer2.readInt();
                  var64 = secretPacketBuffer2.readUnsignedShort();
                  var7 = secretPacketBuffer2.readUnsignedShort();
                  var30 = secretPacketBuffer2.readInt();

                  for(var9 = var64; var9 <= var7; ++var9) {
                     long var50 = (long)var9 + ((long)var63 << 32);
                     widgetFlags.method3426(new class198(var30), var50);
                  }
               }

               field951 = -1;
               return true;
            }

            if(field951 == 148) {
               var99 = secretPacketBuffer2;
               var3 = packetLength;
               var62 = var99.offset;
               class96.field1493 = 0;
               var63 = 0;
               var99.method3291();

               for(var64 = 0; var64 < class96.field1487; ++var64) {
                  var7 = class96.field1491[var64];
                  if((class96.field1489[var7] & 1) == 0) {
                     if(var63 > 0) {
                        --var63;
                        class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                     } else {
                        var30 = var99.method3290(1);
                        if(var30 == 0) {
                           var63 = World.method1475(var99);
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        } else {
                           class2.method4(var99, var7);
                        }
                     }
                  }
               }

               var99.method3292();
               if(var63 != 0) {
                  throw new RuntimeException();
               }

               var99.method3291();

               for(var64 = 0; var64 < class96.field1487; ++var64) {
                  var7 = class96.field1491[var64];
                  if((class96.field1489[var7] & 1) != 0) {
                     if(var63 > 0) {
                        --var63;
                        class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                     } else {
                        var30 = var99.method3290(1);
                        if(var30 == 0) {
                           var63 = World.method1475(var99);
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        } else {
                           class2.method4(var99, var7);
                        }
                     }
                  }
               }

               var99.method3292();
               if(var63 != 0) {
                  throw new RuntimeException();
               }

               var99.method3291();

               for(var64 = 0; var64 < class96.field1499; ++var64) {
                  var7 = class96.field1495[var64];
                  if((class96.field1489[var7] & 1) != 0) {
                     if(var63 > 0) {
                        --var63;
                        class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                     } else {
                        var30 = var99.method3290(1);
                        if(var30 == 0) {
                           var63 = World.method1475(var99);
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        } else if(class29.method253(var99, var7)) {
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        }
                     }
                  }
               }

               var99.method3292();
               if(var63 != 0) {
                  throw new RuntimeException();
               }

               var99.method3291();

               for(var64 = 0; var64 < class96.field1499; ++var64) {
                  var7 = class96.field1495[var64];
                  if((class96.field1489[var7] & 1) == 0) {
                     if(var63 > 0) {
                        --var63;
                        class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                     } else {
                        var30 = var99.method3290(1);
                        if(var30 == 0) {
                           var63 = World.method1475(var99);
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        } else if(class29.method253(var99, var7)) {
                           class96.field1489[var7] = (byte)(class96.field1489[var7] | 2);
                        }
                     }
                  }
               }

               var99.method3292();
               if(var63 != 0) {
                  throw new RuntimeException();
               }

               class96.field1487 = 0;
               class96.field1499 = 0;

               for(var64 = 1; var64 < 2048; ++var64) {
                  class96.field1489[var64] = (byte)(class96.field1489[var64] >> 1);
                  var26 = cachedPlayers[var64];
                  if(var26 != null) {
                     class96.field1491[++class96.field1487 - 1] = var64;
                  } else {
                     class96.field1495[++class96.field1499 - 1] = var64;
                  }
               }

               Item.method1665(var99);
               if(var3 != var99.offset - var62) {
                  throw new RuntimeException(var99.offset - var62 + " " + var3);
               }

               field951 = -1;
               return true;
            }

            if(field951 == 244) {
               var25 = secretPacketBuffer2.readString();
               Object[] var86 = new Object[var25.length() + 1];

               for(var62 = var25.length() - 1; var62 >= 0; --var62) {
                  if(var25.charAt(var62) == 115) {
                     var86[var62 + 1] = secretPacketBuffer2.readString();
                  } else {
                     var86[var62 + 1] = new Integer(secretPacketBuffer2.readInt());
                  }
               }

               var86[0] = new Integer(secretPacketBuffer2.readInt());
               class69 var81 = new class69();
               var81.field821 = var86;
               class77.method1440(var81);
               field951 = -1;
               return true;
            }

            if(field951 == 172) {
               GameEngine.method864();
               energy = secretPacketBuffer2.readUnsignedByte();
               field1103 = field1091;
               field951 = -1;
               return true;
            }

            if(field951 == 160) {
               for(var2 = 0; var2 < class241.field3292; ++var2) {
                  class241 var24 = class25.method203(var2);
                  if(var24 != null) {
                     class211.settings[var2] = 0;
                     class211.widgetSettings[var2] = 0;
                  }
               }

               GameEngine.method864();
               field1026 += 32;
               field951 = -1;
               return true;
            }

            if(field951 == 121) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.method3160();
               WidgetNode var80 = (WidgetNode)componentTable.method3425((long)var3);
               var110 = (WidgetNode)componentTable.method3425((long)var2);
               if(var110 != null) {
                  class67.method1027(var110, var80 == null || var80.id != var110.id);
               }

               if(var80 != null) {
                  var80.unlink();
                  componentTable.method3426(var80, (long)var2);
               }

               var83 = class223.method3959(var3);
               if(var83 != null) {
                  XItemContainer.method1020(var83);
               }

               var83 = class223.method3959(var2);
               if(var83 != null) {
                  XItemContainer.method1020(var83);
                  class95.method1670(Widget.widgets[var83.id >>> 16], var83, true);
               }

               if(widgetRoot != -1) {
                  class4.method13(widgetRoot, 1);
               }

               field951 = -1;
               return true;
            }

            if(field951 == 208) {
               var2 = secretPacketBuffer2.method3078();
               var3 = secretPacketBuffer2.method3116();
               var62 = secretPacketBuffer2.method3068();
               if(var62 == '\uffff') {
                  var62 = -1;
               }

               var63 = secretPacketBuffer2.readUnsignedShort();
               if(var63 == '\uffff') {
                  var63 = -1;
               }

               for(var64 = var62; var64 <= var63; ++var64) {
                  var36 = (long)var64 + ((long)var2 << 32);
                  Node var48 = widgetFlags.method3425(var36);
                  if(var48 != null) {
                     var48.unlink();
                  }

                  widgetFlags.method3426(new class198(var3), var36);
               }

               field951 = -1;
               return true;
            }

            if(field951 == 86) {
               var2 = secretPacketBuffer2.method3116();
               var3 = secretPacketBuffer2.method3023();
               var22 = class223.method3959(var2);
               if(var22.modelType != 2 || var3 != var22.modelId) {
                  var22.modelType = 2;
                  var22.modelId = var3;
                  XItemContainer.method1020(var22);
               }

               field951 = -1;
               return true;
            }

            if(field951 == 76) {
               World var95 = new World();
               var95.address = secretPacketBuffer2.readString();
               var95.id = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.readInt();
               var95.mask = var3;
               class23.setGameState(45);
               WidgetNode.rssocket.method2879();
               WidgetNode.rssocket = null;
               class2.method6(var95);
               field951 = -1;
               return false;
            }

            if(field951 == 62) {
               var2 = secretPacketBuffer2.method3017();
               var3 = secretPacketBuffer2.readInt();
               var22 = class223.method3959(var3);
               if(var2 != var22.field2777 || var2 == -1) {
                  var22.field2777 = var2;
                  var22.field2776 = 0;
                  var22.field2758 = 0;
                  XItemContainer.method1020(var22);
               }

               field951 = -1;
               return true;
            }

            if(field951 == 151) {
               var2 = secretPacketBuffer2.method3197();
               var3 = secretPacketBuffer2.method3160();
               var62 = secretPacketBuffer2.method3071();
               var31 = class223.method3959(var3);
               if(var31.originalX != var62 || var31.originalY != var2 || var31.field2659 != 0 || var31.field2660 != 0) {
                  var31.originalX = var62;
                  var31.originalY = var2;
                  var31.field2659 = 0;
                  var31.field2660 = 0;
                  XItemContainer.method1020(var31);
                  this.method1118(var31);
                  if(var31.type == 0) {
                     class95.method1670(Widget.widgets[var3 >> 16], var31, false);
                  }
               }

               field951 = -1;
               return true;
            }

            if(field951 == 179) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.readUnsignedByte();
               var62 = secretPacketBuffer2.readUnsignedShort();
               if(field1144 != 0 && var3 != 0 && field931 < 50) {
                  field1036[field931] = var2;
                  field1155[field931] = var3;
                  field1150[field931] = var62;
                  audioEffects[field931] = null;
                  field1170[field931] = 0;
                  ++field931;
               }

               field951 = -1;
               return true;
            }

            if(field951 == 36) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               if(secretPacketBuffer2.readUnsignedByte() == 0) {
                  grandExchangeOffers[var2] = new XGrandExchangeOffer();
                  secretPacketBuffer2.offset += 18;
               } else {
                  --secretPacketBuffer2.offset;
                  grandExchangeOffers[var2] = new XGrandExchangeOffer(secretPacketBuffer2, false);
               }

               field1101 = field1091;
               field951 = -1;
               return true;
            }

            if(field951 == 161) {
               var25 = secretPacketBuffer2.readString();
               var3 = secretPacketBuffer2.readUnsignedShort();
               byte var4 = secretPacketBuffer2.readByte();
               var5 = false;
               if(var4 == -128) {
                  var5 = true;
               }

               if(var5) {
                  if(XGrandExchangeOffer.clanChatCount == 0) {
                     field951 = -1;
                     return true;
                  }

                  var6 = false;

                  for(var64 = 0; var64 < XGrandExchangeOffer.clanChatCount && (!class177.clanMembers[var64].username.equals(var25) || var3 != class177.clanMembers[var64].world); ++var64) {
                     ;
                  }

                  if(var64 < XGrandExchangeOffer.clanChatCount) {
                     while(var64 < XGrandExchangeOffer.clanChatCount - 1) {
                        class177.clanMembers[var64] = class177.clanMembers[var64 + 1];
                        ++var64;
                     }

                     --XGrandExchangeOffer.clanChatCount;
                     class177.clanMembers[XGrandExchangeOffer.clanChatCount] = null;
                  }
               } else {
                  secretPacketBuffer2.readString();
                  XClanMember var23 = new XClanMember();
                  var23.username = var25;
                  var23.field892 = class109.method1965(var23.username, class33.field482);
                  var23.world = var3;
                  var23.rank = var4;

                  for(var7 = XGrandExchangeOffer.clanChatCount - 1; var7 >= 0; --var7) {
                     var30 = class177.clanMembers[var7].field892.compareTo(var23.field892);
                     if(var30 == 0) {
                        class177.clanMembers[var7].world = var3;
                        class177.clanMembers[var7].rank = var4;
                        if(var25.equals(class20.localPlayer.name)) {
                           class226.clanChatRank = var4;
                        }

                        field1063 = field1091;
                        field951 = -1;
                        return true;
                     }

                     if(var30 < 0) {
                        break;
                     }
                  }

                  if(XGrandExchangeOffer.clanChatCount >= class177.clanMembers.length) {
                     field951 = -1;
                     return true;
                  }

                  for(var30 = XGrandExchangeOffer.clanChatCount - 1; var30 > var7; --var30) {
                     class177.clanMembers[var30 + 1] = class177.clanMembers[var30];
                  }

                  if(XGrandExchangeOffer.clanChatCount == 0) {
                     class177.clanMembers = new XClanMember[100];
                  }

                  class177.clanMembers[var7 + 1] = var23;
                  ++XGrandExchangeOffer.clanChatCount;
                  if(var25.equals(class20.localPlayer.name)) {
                     class226.clanChatRank = var4;
                  }
               }

               field1063 = field1091;
               field951 = -1;
               return true;
            }

            if(field951 == 70) {
               class29.field437 = secretPacketBuffer2.method3060();
               class27.field414 = secretPacketBuffer2.method3201();
               field951 = -1;
               return true;
            }

            class8.method43("" + field951 + "," + field955 + "," + field956 + "," + packetLength, (Throwable)null);
            TextureProvider.method2306();
         } catch (IOException var60) {
            if(field957 > 0) {
               TextureProvider.method2306();
            } else {
               class23.setGameState(40);
               class222.field2846 = WidgetNode.rssocket;
               WidgetNode.rssocket = null;
            }
         } catch (Exception var61) {
            var25 = "" + field951 + "," + field955 + "," + field956 + "," + packetLength + "," + (class20.localPlayer.pathX[0] + class19.baseX) + "," + (class21.baseY + class20.localPlayer.pathY[0]) + ",";

            for(var3 = 0; var3 < packetLength && var3 < 50; ++var3) {
               var25 = var25 + secretPacketBuffer2.payload[var3] + ",";
            }

            class8.method43(var25, var61);
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
         class158.method2866(widgetRoot, 0, 0, class10.canvasWidth, class1.canvasHeight, 0, 0, -1);
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
                  var4 = "Use" + " " + selectedItemName + " " + "->";
               } else if(field1061 && menuOptionCount < 2) {
                  var4 = field1064 + " " + field1065 + " " + "->";
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

               class64.field788.method4709(var4, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
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
      int var12 = field1125;

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
               Object var10000;
               if(var14.field1313 == null) {
                  if(var14.field1308 >= 0) {
                     var10000 = null;
                     SoundEffect var8 = SoundEffect.method1843(class66.field799, var14.field1308, 0);
                     if(var8 != null) {
                        class107 var9 = var8.method1839().method1881(class59.field724);
                        class117 var10 = class117.method2038(var9, 100, var7);
                        var10.method2149(-1);
                        WorldMapType1.field442.method1806(var10);
                        var14.field1313 = var10;
                     }
                  }
               } else {
                  var14.field1313.method2042(var7);
               }

               if(var14.field1318 == null) {
                  if(var14.field1316 != null && (var14.field1317 -= var12) <= 0) {
                     int var13 = (int)(Math.random() * (double)var14.field1316.length);
                     var10000 = null;
                     SoundEffect var15 = SoundEffect.method1843(class66.field799, var14.field1316[var13], 0);
                     if(var15 != null) {
                        class107 var16 = var15.method1839().method1881(class59.field724);
                        class117 var11 = class117.method2038(var16, 100, var7);
                        var11.method2149(0);
                        WorldMapType1.field442.method1806(var11);
                        var14.field1318 = var11;
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
}
