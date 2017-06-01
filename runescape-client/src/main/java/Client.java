import java.io.File;
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
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1006259239
   )
   @Export("world")
   static int world;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 578310885
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 1625842323
   )
   static int field931;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -1852132687
   )
   static int field932;
   @ObfuscatedName("rb")
   static final class73 field933;
   @ObfuscatedName("eu")
   static HashMap field934;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1118243273
   )
   @Export("gameState")
   static int gameState;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -1589228809
   )
   static int field936;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -415953499
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("jc")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1987213651
   )
   static int field939;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -17246385
   )
   static int field940;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1650881593
   )
   static int field941;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = 354678331
   )
   @Export("packetLength")
   static int packetLength;
   @ObfuscatedName("bd")
   static boolean field943;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = -1487119839
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -1765365247
   )
   static int field945;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 2077112349
   )
   static int field946;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -446593239
   )
   static int field947;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1062582627
   )
   static int field948;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -733246285
   )
   static int field949;
   @ObfuscatedName("df")
   static int[] field950;
   @ObfuscatedName("qb")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 396247577
   )
   static int field952;
   @ObfuscatedName("ca")
   static class91 field953;
   @ObfuscatedName("mg")
   @ObfuscatedGetter(
      intValue = 2046854027
   )
   static int field954;
   @ObfuscatedName("mm")
   static Deque field955;
   @ObfuscatedName("pv")
   static int[] field956;
   @ObfuscatedName("cp")
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("iy")
   static boolean field958;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -252714307
   )
   static int field959;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 1223769881
   )
   static int field960;
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = -743194309
   )
   static int field961;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = 1542073529
   )
   static int field962;
   @ObfuscatedName("kc")
   static Widget field963;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = -986467327
   )
   static int field964;
   @ObfuscatedName("db")
   @Export("host")
   static String host;
   @ObfuscatedName("dy")
   static byte[] field966;
   @ObfuscatedName("dv")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = 536829441
   )
   static int field968;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = -173521211
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = 313004387
   )
   static int field970;
   @ObfuscatedName("dw")
   static int[] field971;
   @ObfuscatedName("er")
   @Export("secretPacketBuffer1")
   static PacketBuffer secretPacketBuffer1;
   @ObfuscatedName("ed")
   static PacketBuffer field973;
   @ObfuscatedName("ez")
   @Export("secretPacketBuffer2")
   static PacketBuffer secretPacketBuffer2;
   @ObfuscatedName("qm")
   static short field975;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = 1690413071
   )
   static int field976;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = -1576747423
   )
   static int field977;
   @ObfuscatedName("bt")
   static boolean field978;
   @ObfuscatedName("jx")
   static Deque field979;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -1418338505
   )
   static int field980;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -514575423
   )
   static int field981;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 1205353133
   )
   static int field982;
   @ObfuscatedName("ef")
   static boolean field983;
   @ObfuscatedName("cj")
   static class91 field984;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = -969721333
   )
   static int field985;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = -487277675
   )
   static int field986;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = 1240236289
   )
   static int field987;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 578460725
   )
   static int field988;
   @ObfuscatedName("pq")
   static boolean field989;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -997233617
   )
   static int field991;
   @ObfuscatedName("fv")
   static int[][][] field992;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -523888051
   )
   static int field993;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = -191922617
   )
   static int field994;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = -544006301
   )
   static int field995;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = -760183783
   )
   static int field996;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -802999771
   )
   static int field997;
   @ObfuscatedName("hv")
   static int[] field998;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -2034098177
   )
   static int field999;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = -644336597
   )
   static int field1000;
   @ObfuscatedName("bo")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = 845843045
   )
   @Export("mapOffset")
   static int mapOffset;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = 2035949285
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -1740109383
   )
   static int field1004;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -425870659
   )
   static int field1005;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 101942005
   )
   static int field1006;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 1129059547
   )
   static int field1007;
   @ObfuscatedName("ph")
   static SoundEffect[] field1008;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1034281737
   )
   static int field1009;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = 448785779
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("gh")
   static boolean field1011;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1214449873
   )
   static int field1012;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -2086974513
   )
   static int field1013;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = -1693382461
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = 770966543
   )
   static int field1015;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = -738351805
   )
   static int field1016;
   @ObfuscatedName("hb")
   static int[] field1017;
   @ObfuscatedName("pk")
   static int[] field1018;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = -378693673
   )
   static int field1019;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = 423673405
   )
   static int field1020;
   @ObfuscatedName("ht")
   static boolean field1021;
   @ObfuscatedName("fs")
   static final int[] field1022;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = 148468815
   )
   static int field1023;
   @ObfuscatedName("hl")
   static int[] field1024;
   @ObfuscatedName("ho")
   static int[] field1025;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = 223347323
   )
   static int field1026;
   @ObfuscatedName("hy")
   static int[] field1027;
   @ObfuscatedName("pm")
   static int[] field1028;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 658972917
   )
   static int field1029;
   @ObfuscatedName("hr")
   static int[] field1030;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = -1351753809
   )
   static int field1031;
   @ObfuscatedName("hu")
   static String[] field1032;
   @ObfuscatedName("hs")
   static int[][] field1033;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = -1255786925
   )
   static int field1034;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 2079956077
   )
   static int field1035;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = 179182543
   )
   static int field1036;
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = 523321273
   )
   static int field1037;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 2070451025
   )
   static int field1038;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 1327761289
   )
   static int field1039;
   @ObfuscatedName("mt")
   static boolean[] field1040;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 1224040587
   )
   static int field1041;
   @ObfuscatedName("br")
   static boolean field1042;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = 1957235509
   )
   static int field1043;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = 2074172987
   )
   static int field1044;
   @ObfuscatedName("qd")
   static short field1045;
   @ObfuscatedName("bj")
   static boolean field1046;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = -1425372629
   )
   static int field1047;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = 641278371
   )
   static int field1048;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = 706942223
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("ig")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = -633149099
   )
   static int field1051;
   @ObfuscatedName("np")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = 889369907
   )
   static int field1053;
   @ObfuscatedName("od")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("jk")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("ju")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("ji")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("jn")
   static int[] field1058;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = -1962595479
   )
   static int field1059;
   @ObfuscatedName("qi")
   static class195 field1060;
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = 798640917
   )
   static int field1061;
   @ObfuscatedName("jb")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -653184447
   )
   static int field1063;
   @ObfuscatedName("jo")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("jj")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = -190662161
   )
   static int field1066;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = 2076257643
   )
   static int field1067;
   @ObfuscatedName("jl")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = 1848701333
   )
   static int field1069;
   @ObfuscatedName("jw")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("jr")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("rg")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("jd")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("js")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("oa")
   static int[] field1075;
   @ObfuscatedName("ir")
   static int[] field1076;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1434324971
   )
   static int field1077;
   @ObfuscatedName("kp")
   static boolean field1078;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -1672199461
   )
   static int field1079;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 546573685
   )
   static int field1080;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = -624330157
   )
   static int field1081;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = 593224973
   )
   static int field1082;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 627119879
   )
   static int field1083;
   @ObfuscatedName("it")
   static String field1084;
   @ObfuscatedName("kz")
   static boolean field1085;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = -1395482459
   )
   static int field1086;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -1563679387
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("kx")
   static String field1088;
   @ObfuscatedName("kv")
   static String field1089;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 893033991
   )
   static int field1090;
   @ObfuscatedName("ka")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 1919768247
   )
   static int field1092;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -1086578155
   )
   static int field1093;
   @ObfuscatedName("qr")
   static short field1094;
   @ObfuscatedName("hp")
   static int[] field1095;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = 1597142241
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 1261059245
   )
   static int field1097;
   @ObfuscatedName("ru")
   @ObfuscatedGetter(
      longValue = -7059185915533827665L
   )
   static long field1098;
   @ObfuscatedName("lw")
   static boolean field1099;
   @ObfuscatedName("lk")
   static boolean field1100;
   @ObfuscatedName("lb")
   static boolean field1101;
   @ObfuscatedName("lz")
   static Widget field1102;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 973104469
   )
   static int field1103;
   @ObfuscatedName("ld")
   static Widget field1104;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = 1749055399
   )
   static int field1105;
   @ObfuscatedName("fa")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("li")
   static Widget field1107;
   @ObfuscatedName("la")
   static boolean field1108;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 1076247115
   )
   static int field1109;
   @ObfuscatedName("ol")
   static SpritePixels[] field1110;
   @ObfuscatedName("lq")
   static boolean field1111;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = 1949405081
   )
   static int field1112;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = 881139597
   )
   static int field1113;
   @ObfuscatedName("lg")
   static boolean field1114;
   @ObfuscatedName("mh")
   static int[] field1116;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = 1886842475
   )
   static int field1117;
   @ObfuscatedName("mf")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -1362857545
   )
   static int field1119;
   @ObfuscatedName("mi")
   static int[] field1120;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 189677701
   )
   static int field1121;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      longValue = 5423863287538540741L
   )
   static long field1122;
   @ObfuscatedName("oi")
   static boolean field1123;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = 1401305193
   )
   static int field1124;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 370440727
   )
   static int field1125;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = 1325010879
   )
   static int field1126;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 297206917
   )
   static int field1127;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = -1175210271
   )
   static int field1128;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 1985374801
   )
   static int field1129;
   @ObfuscatedName("mv")
   static Deque field1130;
   @ObfuscatedName("mq")
   static Deque field1131;
   @ObfuscatedName("mp")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = 1889413529
   )
   static int field1133;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = 270076103
   )
   static int field1134;
   @ObfuscatedName("mb")
   static boolean[] field1135;
   @ObfuscatedName("mc")
   static boolean[] field1136;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = 658315629
   )
   static int field1137;
   @ObfuscatedName("nh")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("na")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("nt")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = -866006435
   )
   static int field1141;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 1569336745
   )
   static int field1142;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      longValue = 4445991475573507637L
   )
   static long field1143;
   @ObfuscatedName("nm")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("nu")
   static int[] field1145;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -141536967
   )
   static int field1146;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = -1389121463
   )
   static int field1147;
   @ObfuscatedName("ny")
   static String field1148;
   @ObfuscatedName("nn")
   static long[] field1149;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = -511789287
   )
   static int field1150;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = -1843339191
   )
   static int field1151;
   @ObfuscatedName("nj")
   static int[] field1152;
   @ObfuscatedName("nk")
   static int[] field1153;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      longValue = -5511378637146347665L
   )
   static long field1154;
   @ObfuscatedName("or")
   static String field1155;
   @ObfuscatedName("kd")
   static boolean field1156;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = 1754389165
   )
   static int field1157;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = -993372887
   )
   static int field1158;
   @ObfuscatedName("qy")
   static short field1159;
   @ObfuscatedName("og")
   static int[] field1160;
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = -1411904595
   )
   static int field1161;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = -791337037
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -459290703
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("lf")
   static Widget field1164;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = 1047652811
   )
   static int field1165;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = 2126385967
   )
   static int field1166;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -849052287
   )
   static int field1167;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = -388259759
   )
   static int field1168;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = 1015463361
   )
   static int field1169;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = -947164571
   )
   static int field1170;
   @ObfuscatedName("pl")
   static int[] field1171;
   @ObfuscatedName("jf")
   static Deque field1172;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 953477155
   )
   static int field1173;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = 493781461
   )
   static int field1174;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = 1631201647
   )
   static int field1175;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -993192273
   )
   static int field1176;
   @ObfuscatedName("ja")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("pt")
   static int[] field1178;
   @ObfuscatedName("pj")
   static int[] field1179;
   @ObfuscatedName("qx")
   static int[] field1180;
   @ObfuscatedName("qt")
   static int[] field1181;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = -1798838791
   )
   static int field1182;
   @ObfuscatedName("ps")
   static boolean[] field1183;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 1598638761
   )
   static int field1184;
   @ObfuscatedName("ql")
   static short field1185;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = -808030619
   )
   static int field1186;
   @ObfuscatedName("qk")
   static short field1187;
   @ObfuscatedName("qn")
   static short field1188;
   @ObfuscatedName("qz")
   static short field1189;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = -2093061937
   )
   static int field1190;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -1994793999
   )
   static int field1191;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = 1924919777
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = 2084195175
   )
   static int field1193;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = -586709891
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = 315477343
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = 1208336943
   )
   static int field1196;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = 1641725265
   )
   static int field1197;
   @ObfuscatedName("kl")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 472275897
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("qu")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("qg")
   static PlayerComposition field1201;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = -36123921
   )
   static int field1202;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = 415744065
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("jv")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -1871605021
   )
   static int field1205;
   @ObfuscatedName("ri")
   @ObfuscatedGetter(
      longValue = -7449845185991068765L
   )
   static long field1206;
   @ObfuscatedName("dn")
   static IndexData field1207;
   @ObfuscatedName("rc")
   static int[] field1208;
   @ObfuscatedName("rh")
   static int[] field1209;
   @ObfuscatedName("dq")
   static class153 field1210;
   @ObfuscatedName("ay")
   static boolean field1211;
   @ObfuscatedName("gs")
   static SpritePixels[] field1212;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = 1230783021
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("aq")
   static Client field1214;

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected final void vmethod1143() {
   }

   public final void init() {
      if(this.method841()) {
         class274[] var1 = new class274[]{class274.field3721, class274.field3724, class274.field3727, class274.field3718, class274.field3725, class274.field3723, class274.field3729, class274.field3720, class274.field3717, class274.field3728, class274.field3719, class274.field3726, class274.field3716, class274.field3730, class274.field3722};
         class274[] var2 = var1;

         int var3;
         String var5;
         int var7;
         int var9;
         class231 var10;
         for(var3 = 0; var3 < var2.length; ++var3) {
            class274 var4 = var2[var3];
            var5 = this.getParameter(var4.field3731);
            if(var5 != null) {
               switch(Integer.parseInt(var4.field3731)) {
               case 1:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 2:
                  flags = Integer.parseInt(var5);
                  break;
               case 3:
                  class66.field824 = var5;
               case 4:
               case 7:
               default:
                  break;
               case 5:
                  field1077 = Integer.parseInt(var5);
                  break;
               case 6:
                  class17.field307 = Integer.parseInt(var5);
                  break;
               case 8:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 9:
                  class67.field833 = var5;
                  break;
               case 10:
                  field931 = Integer.parseInt(var5);
                  break;
               case 11:
                  world = Integer.parseInt(var5);
                  break;
               case 12:
                  class232[] var36 = new class232[]{class232.field3196, class232.field3191, class232.field3188, class232.field3190, class232.field3189, class232.field3186};
                  class27.field400 = (class232)Item.method1751(var36, Integer.parseInt(var5));
                  if(class27.field400 == class232.field3191) {
                     World.field1331 = class289.field3850;
                  } else {
                     World.field1331 = class289.field3845;
                  }
                  break;
               case 13:
                  var7 = Integer.parseInt(var5);
                  class231[] var8 = class219.method4055();
                  var9 = 0;

                  class231 var6;
                  while(true) {
                     if(var9 >= var8.length) {
                        var6 = null;
                        break;
                     }

                     var10 = var8[var9];
                     if(var7 == var10.field3181) {
                        var6 = var10;
                        break;
                     }

                     ++var9;
                  }

                  class22.field339 = var6;
                  break;
               case 14:
                  class18.field312 = Integer.parseInt(var5);
               }
            }
         }

         Region.field2100 = false;
         field1046 = false;
         host = this.getCodeBase().getHost();
         String var33 = class22.field339.field3180;
         byte var17 = 0;

         try {
            class155.field2265 = 17;
            class155.field2271 = var17;

            try {
               class283.field3762 = System.getProperty("os.name");
            } catch (Exception var29) {
               class283.field3762 = "Unknown";
            }

            class155.field2273 = class283.field3762.toLowerCase();

            try {
               class76.field1218 = System.getProperty("user.home");
               if(class76.field1218 != null) {
                  class76.field1218 = class76.field1218 + "/";
               }
            } catch (Exception var28) {
               ;
            }

            try {
               if(class155.field2273.startsWith("win")) {
                  if(class76.field1218 == null) {
                     class76.field1218 = System.getenv("USERPROFILE");
                  }
               } else if(class76.field1218 == null) {
                  class76.field1218 = System.getenv("HOME");
               }

               if(class76.field1218 != null) {
                  class76.field1218 = class76.field1218 + "/";
               }
            } catch (Exception var27) {
               ;
            }

            if(class76.field1218 == null) {
               class76.field1218 = "~/";
            }

            class88.field1408 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class76.field1218, "/tmp/", ""};
            Script.field1538 = new String[]{".jagex_cache_" + class155.field2271, ".file_store_" + class155.field2271};
            var3 = 0;

            label259:
            while(var3 < 4) {
               var5 = var3 == 0?"":"" + var3;
               class271.field3687 = new File(class76.field1218, "jagex_cl_oldschool_" + var33 + var5 + ".dat");
               String var37 = null;
               String var19 = null;
               boolean var20 = false;
               File var40;
               if(class271.field3687.exists()) {
                  try {
                     FileOnDisk var21 = new FileOnDisk(class271.field3687, "rw", 10000L);

                     int var11;
                     Buffer var39;
                     for(var39 = new Buffer((int)var21.method2344()); var39.offset < var39.payload.length; var39.offset += var11) {
                        var11 = var21.method2343(var39.payload, var39.offset, var39.payload.length - var39.offset);
                        if(var11 == -1) {
                           throw new IOException();
                        }
                     }

                     var39.offset = 0;
                     var11 = var39.readUnsignedByte();
                     if(var11 < 1 || var11 > 3) {
                        throw new IOException("" + var11);
                     }

                     int var12 = 0;
                     if(var11 > 1) {
                        var12 = var39.readUnsignedByte();
                     }

                     if(var11 <= 2) {
                        var37 = var39.method3167();
                        if(var12 == 1) {
                           var19 = var39.method3167();
                        }
                     } else {
                        var37 = var39.method3194();
                        if(var12 == 1) {
                           var19 = var39.method3194();
                        }
                     }

                     var21.method2348();
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
                     if(!class33.method339(var40, true)) {
                        var37 = null;
                     }
                  }
               }

               if(var37 == null && var3 == 0) {
                  label235:
                  for(var9 = 0; var9 < Script.field1538.length; ++var9) {
                     for(int var22 = 0; var22 < class88.field1408.length; ++var22) {
                        File var23 = new File(class88.field1408[var22] + Script.field1538[var9] + File.separatorChar + "oldschool" + File.separatorChar);
                        if(var23.exists() && class33.method339(new File(var23, "test.dat"), true)) {
                           var37 = var23.toString();
                           var20 = true;
                           break label235;
                        }
                     }
                  }
               }

               if(var37 == null) {
                  var37 = class76.field1218 + File.separatorChar + "jagexcache" + var5 + File.separatorChar + "oldschool" + File.separatorChar + var33 + File.separatorChar;
                  var20 = true;
               }

               File var42;
               if(var19 != null) {
                  var42 = new File(var19);
                  var40 = new File(var37);

                  try {
                     File[] var43 = var42.listFiles();
                     File[] var24 = var43;

                     for(int var13 = 0; var13 < var24.length; ++var13) {
                        File var14 = var24[var13];
                        File var15 = new File(var40, var14.getName());
                        boolean var16 = var14.renameTo(var15);
                        if(!var16) {
                           throw new IOException();
                        }
                     }
                  } catch (Exception var30) {
                     var30.printStackTrace();
                  }

                  var20 = true;
               }

               if(var20) {
                  var42 = new File(var37);
                  var10 = null;

                  try {
                     FileOnDisk var44 = new FileOnDisk(class271.field3687, "rw", 10000L);
                     Buffer var45 = new Buffer(500);
                     var45.putByte(3);
                     var45.putByte(var10 != null?1:0);
                     var45.method3134(var42.getPath());
                     if(var10 != null) {
                        var45.method3134("");
                     }

                     var44.method2364(var45.payload, 0, var45.offset);
                     var44.method2348();
                  } catch (IOException var26) {
                     var26.printStackTrace();
                  }
               }

               File var34 = new File(var37);
               class155.field2264 = var34;
               if(!class155.field2264.exists()) {
                  class155.field2264.mkdirs();
               }

               File[] var35 = class155.field2264.listFiles();
               if(var35 == null) {
                  break;
               }

               File[] var41 = var35;
               var7 = 0;

               while(true) {
                  if(var7 >= var41.length) {
                     break label259;
                  }

                  File var38 = var41[var7];
                  if(!class33.method339(var38, false)) {
                     ++var3;
                     break;
                  }

                  ++var7;
               }
            }

            File var18 = class155.field2264;
            class157.field2278 = var18;
            if(!class157.field2278.exists()) {
               throw new RuntimeException("");
            }

            class157.field2281 = true;
            class89.method1702();
            class155.field2269 = new class123(new FileOnDisk(WorldMapData.method265("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class155.field2270 = new class123(new FileOnDisk(WorldMapData.method265("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class211.field2610 = new class123[class155.field2265];

            for(int var25 = 0; var25 < class155.field2265; ++var25) {
               class211.field2610[var25] = new class123(new FileOnDisk(WorldMapData.method265("main_file_cache.idx" + var25), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var32) {
            class21.method138((String)null, var32);
         }

         field1214 = this;
         this.method872(765, 503, 143);
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1378668389"
   )
   protected final void vmethod1147(boolean var1) {
      boolean var2;
      label173: {
         try {
            if(class203.field2514 == 2) {
               if(ChatLineBuffer.field1565 == null) {
                  ChatLineBuffer.field1565 = Track1.method3894(class203.field2513, class203.field2515, class157.field2280);
                  if(ChatLineBuffer.field1565 == null) {
                     var2 = false;
                     break label173;
                  }
               }

               if(class203.field2509 == null) {
                  class203.field2509 = new class112(class19.field315, class203.field2510);
               }

               if(class203.field2511.method3670(ChatLineBuffer.field1565, class203.field2512, class203.field2509, 22050)) {
                  class203.field2511.method3707();
                  class203.field2511.method3668(class151.field2229);
                  class203.field2511.method3673(ChatLineBuffer.field1565, class87.field1404);
                  class203.field2514 = 0;
                  ChatLineBuffer.field1565 = null;
                  class203.field2509 = null;
                  class203.field2513 = null;
                  var2 = true;
                  break label173;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class203.field2511.method3674();
            class203.field2514 = 0;
            ChatLineBuffer.field1565 = null;
            class203.field2509 = null;
            class203.field2513 = null;
         }

         var2 = false;
      }

      if(var2 && field1123 && class11.field267 != null) {
         class11.field267.method2014();
      }

      int var4;
      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field1143 && XGrandExchangeOffer.method96() > field1143) {
         var4 = isResized?2:1;
         class232.method4103(var4);
      }

      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1135[var4] = true;
         }
      }

      if(gameState == 0) {
         this.method856(class92.field1448, class92.field1455, var1);
      } else if(gameState == 5) {
         class89.method1703(XClanMember.field922, class166.field2344, class33.field473, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class89.method1703(XClanMember.field922, class166.field2344, class33.field473, var1);
         } else if(gameState == 25) {
            if(field1142 == 1) {
               if(field1026 > field986) {
                  field986 = field1026;
               }

               var4 = (field986 * 50 - field1026 * 50) / field986;
               KitDefinition.method4378("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field1142 == 2) {
               if(field987 > field988) {
                  field988 = field987;
               }

               var4 = (field988 * 50 - field987 * 50) / field988 + 50;
               KitDefinition.method4378("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               KitDefinition.method4378("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1156();
         } else if(gameState == 40) {
            KitDefinition.method4378("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            KitDefinition.method4378("Please wait...", false);
         }
      } else {
         class89.method1703(XClanMember.field922, class166.field2344, class33.field473, var1);
      }

      if(gameState == 30 && field1161 == 0 && !var1) {
         for(var4 = 0; var4 < field1133; ++var4) {
            if(field1136[var4]) {
               class166.field2343.vmethod5000(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field1136[var4] = false;
            }
         }
      } else if(gameState > 0) {
         class166.field2343.vmethod5008(0, 0);

         for(var4 = 0; var4 < field1133; ++var4) {
            field1136[var4] = false;
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1150257272"
   )
   protected final void vmethod1148() {
      if(Player.chatMessages.method1808()) {
         Player.chatMessages.method1790();
      }

      if(class64.field807 != null) {
         class64.field807.field870 = false;
      }

      class64.field807 = null;
      if(ScriptState.rssocket != null) {
         ScriptState.rssocket.method2981();
         ScriptState.rssocket = null;
      }

      if(class50.keyboard != null) {
         class50 var1 = class50.keyboard;
         synchronized(class50.keyboard) {
            class50.keyboard = null;
         }
      }

      class90.method1705();
      WorldMapType0.field619 = null;
      if(class11.field267 != null) {
         class11.field267.method2036();
      }

      if(FaceNormal.field2155 != null) {
         FaceNormal.field2155.method2036();
      }

      Buffer.method3344();
      Object var9 = class236.field3234;
      synchronized(class236.field3234) {
         if(class236.field3236 != 0) {
            class236.field3236 = 1;

            try {
               class236.field3234.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      try {
         class155.field2269.method2315();

         for(int var4 = 0; var4 < class155.field2265; ++var4) {
            class211.field2610[var4].method2315();
         }

         class155.field2270.method2315();
         class155.field2268.method2315();
      } catch (Exception var7) {
         ;
      }

   }

   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1071957600"
   )
   void method1149() {
      if(gameState != 1000) {
         boolean var1 = class234.method4105();
         if(!var1) {
            this.method1150();
         }

      }
   }

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "23243"
   )
   void method1150() {
      if(class238.field3267 >= 4) {
         this.method858("js5crc");
         gameState = 1000;
      } else {
         if(class238.field3263 >= 4) {
            if(gameState <= 5) {
               this.method858("js5io");
               gameState = 1000;
               return;
            }

            field959 = 3000;
            class238.field3263 = 3;
         }

         if(--field959 + 1 <= 0) {
            try {
               if(field1173 == 0) {
                  class11.field265 = GameEngine.field721.method2935(host, RSSocket.field2290);
                  ++field1173;
               }

               if(field1173 == 1) {
                  if(class11.field265.field2244 == 2) {
                     this.method1151(-1);
                     return;
                  }

                  if(class11.field265.field2244 == 1) {
                     ++field1173;
                  }
               }

               if(field1173 == 2) {
                  rssocket = new RSSocket((Socket)class11.field265.field2248, GameEngine.field721);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(143);
                  rssocket.queueForWrite(var1.payload, 0, 5);
                  ++field1173;
                  class17.field306 = XGrandExchangeOffer.method96();
               }

               if(field1173 == 3) {
                  if(gameState > 5 && rssocket.available() <= 0) {
                     if(XGrandExchangeOffer.method96() - class17.field306 > 30000L) {
                        this.method1151(-2);
                        return;
                     }
                  } else {
                     int var2 = rssocket.readByte();
                     if(var2 != 0) {
                        this.method1151(var2);
                        return;
                     }

                     ++field1173;
                  }
               }

               if(field1173 == 4) {
                  WorldMapType2.method519(rssocket, gameState > 20);
                  class11.field265 = null;
                  rssocket = null;
                  field1173 = 0;
                  field960 = 0;
               }
            } catch (IOException var3) {
               this.method1151(-3);
            }

         }
      }
   }

   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "295772360"
   )
   void method1151(int var1) {
      class11.field265 = null;
      rssocket = null;
      field1173 = 0;
      if(class13.field279 == RSSocket.field2290) {
         RSSocket.field2290 = XItemContainer.field790;
      } else {
         RSSocket.field2290 = class13.field279;
      }

      ++field960;
      if(field960 < 2 || var1 != 7 && var1 != 9) {
         if(field960 >= 2 && var1 == 6) {
            this.method858("js5connect_outofdate");
            gameState = 1000;
         } else if(field960 >= 4) {
            if(gameState <= 5) {
               this.method858("js5connect");
               gameState = 1000;
            } else {
               field959 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method858("js5connect_full");
         gameState = 1000;
      } else {
         field959 = 3000;
      }

   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-786701899"
   )
   final void method1152() {
      class25.method169(field1164);
      ++class64.field799;
      if(field1111 && field1108) {
         int var1 = class59.field737;
         int var2 = class59.field738;
         var1 -= field1105;
         var2 -= field1141;
         if(var1 < field1063) {
            var1 = field1063;
         }

         if(field1164.width + var1 > field1104.width + field1063) {
            var1 = field1063 + field1104.width - field1164.width;
         }

         if(var2 < field1146) {
            var2 = field1146;
         }

         if(field1164.height + var2 > field1146 + field1104.height) {
            var2 = field1146 + field1104.height - field1164.height;
         }

         int var3 = var1 - field1112;
         int var4 = var2 - field1113;
         int var5 = field1164.field2727;
         if(class64.field799 > field1164.field2728 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1114 = true;
         }

         int var6 = var1 - field1063 + field1104.scrollX;
         int var7 = var2 - field1146 + field1104.scrollY;
         class69 var8;
         if(field1164.field2740 != null && field1114) {
            var8 = new class69();
            var8.field852 = field1164;
            var8.field850 = var6;
            var8.field848 = var7;
            var8.field849 = field1164.field2740;
            Friend.method1075(var8);
         }

         if(class59.field736 == 0) {
            int var10;
            if(field1114) {
               if(field1164.field2741 != null) {
                  var8 = new class69();
                  var8.field852 = field1164;
                  var8.field850 = var6;
                  var8.field848 = var7;
                  var8.field854 = field1107;
                  var8.field849 = field1164.field2741;
                  Friend.method1075(var8);
               }

               if(field1107 != null) {
                  Widget var9 = field1164;
                  int var11 = class210.method3903(var9);
                  var10 = var11 >> 17 & 7;
                  int var12 = var10;
                  Widget var17;
                  if(var10 == 0) {
                     var17 = null;
                  } else {
                     int var13 = 0;

                     while(true) {
                        if(var13 >= var12) {
                           var17 = var9;
                           break;
                        }

                        var9 = WorldMapType3.method199(var9.parentId);
                        if(var9 == null) {
                           var17 = null;
                           break;
                        }

                        ++var13;
                     }
                  }

                  if(var17 != null) {
                     secretPacketBuffer1.putOpcode(26);
                     secretPacketBuffer1.putShort(field1164.index);
                     secretPacketBuffer1.method3175(field1164.itemId);
                     secretPacketBuffer1.method3227(field1107.itemId);
                     secretPacketBuffer1.method3227(field1107.index);
                     secretPacketBuffer1.method3153(field1107.id);
                     secretPacketBuffer1.method3153(field1164.id);
                  }
               }
            } else {
               label188: {
                  int var14 = class67.method1080();
                  if(menuOptionCount > 2) {
                     label185: {
                        label150: {
                           if(field1067 == 1) {
                              boolean var15;
                              if(menuOptionCount <= 0) {
                                 var15 = false;
                              } else if(field1078 && class50.field645[81] && field1090 != -1) {
                                 var15 = true;
                              } else {
                                 var15 = false;
                              }

                              if(!var15) {
                                 break label150;
                              }
                           }

                           if(!class51.method755(var14)) {
                              break label185;
                           }
                        }

                        this.method1335(field1105 + field1112, field1113 + field1141);
                        break label188;
                     }
                  }

                  if(menuOptionCount > 0) {
                     int var18 = field1112 + field1105;
                     var10 = field1141 + field1113;
                     class89 var16 = class20.field319;
                     class46.menuAction(var16.field1428, var16.field1421, var16.field1420, var16.field1423, var16.field1422, var16.field1422, var18, var10);
                     class20.field319 = null;
                  }
               }
            }

            field1164 = null;
         }

      } else {
         if(class64.field799 > 1) {
            field1164 = null;
         }

      }
   }

   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   final void method1153() {
      if(field981 > 1) {
         --field981;
      }

      if(field982 > 0) {
         --field982;
      }

      if(field983) {
         field983 = false;
         class84.method1669();
      } else {
         if(!isMenuOpen) {
            menuOptionCount = 0;
            field1090 = -1;
            isMenuOpen = false;
            menuOptions[0] = "Cancel";
            menuTargets[0] = "";
            menuTypes[0] = 1006;
            menuOptionCount = 1;
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method1157(); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(true) {
               ClassInfo var2 = (ClassInfo)class280.field3751.method3530();
               boolean var29;
               if(var2 == null) {
                  var29 = false;
               } else {
                  var29 = true;
               }

               int var14;
               if(!var29) {
                  Object var15 = class64.field807.field869;
                  int var3;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  synchronized(class64.field807.field869) {
                     if(!field1211) {
                        class64.field807.field872 = 0;
                     } else if(class59.field732 != 0 || class64.field807.field872 >= 40) {
                        secretPacketBuffer1.putOpcode(68);
                        secretPacketBuffer1.putByte(0);
                        var14 = secretPacketBuffer1.offset;
                        var3 = 0;

                        for(var4 = 0; var4 < class64.field807.field872 && secretPacketBuffer1.offset - var14 < 240; ++var4) {
                           ++var3;
                           var5 = class64.field807.field868[var4];
                           if(var5 < 0) {
                              var5 = 0;
                           } else if(var5 > 502) {
                              var5 = 502;
                           }

                           var6 = class64.field807.field871[var4];
                           if(var6 < 0) {
                              var6 = 0;
                           } else if(var6 > 764) {
                              var6 = 764;
                           }

                           var7 = var5 * 765 + var6;
                           if(class64.field807.field868[var4] == -1 && class64.field807.field871[var4] == -1) {
                              var6 = -1;
                              var5 = -1;
                              var7 = 524287;
                           }

                           if(var6 == field939 && var5 == field1006) {
                              if(field941 < 2047) {
                                 ++field941;
                              }
                           } else {
                              var8 = var6 - field939;
                              field939 = var6;
                              var9 = var5 - field1006;
                              field1006 = var5;
                              if(field941 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                                 var8 += 32;
                                 var9 += 32;
                                 secretPacketBuffer1.putShort((field941 << 12) + (var8 << 6) + var9);
                                 field941 = 0;
                              } else if(field941 < 8) {
                                 secretPacketBuffer1.put24bitInt(var7 + (field941 << 19) + 8388608);
                                 field941 = 0;
                              } else {
                                 secretPacketBuffer1.putInt(var7 + (field941 << 19) + -1073741824);
                                 field941 = 0;
                              }
                           }
                        }

                        secretPacketBuffer1.method3138(secretPacketBuffer1.offset - var14);
                        if(var3 >= class64.field807.field872) {
                           class64.field807.field872 = 0;
                        } else {
                           class64.field807.field872 -= var3;

                           for(var4 = 0; var4 < class64.field807.field872; ++var4) {
                              class64.field807.field871[var4] = class64.field807.field871[var4 + var3];
                              class64.field807.field868[var4] = class64.field807.field868[var4 + var3];
                           }
                        }
                     }
                  }

                  if(class59.field732 == 1 || !class233.field3202 && class59.field732 == 4 || class59.field732 == 2) {
                     long var16 = (class59.field746 - field1122) / 50L;
                     if(var16 > 4095L) {
                        var16 = 4095L;
                     }

                     field1122 = class59.field746;
                     var3 = class59.field750;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > class18.field311) {
                        var3 = class18.field311;
                     }

                     var4 = class59.field745;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > VertexNormal.field2020) {
                        var4 = VertexNormal.field2020;
                     }

                     var5 = (int)var16;
                     secretPacketBuffer1.putOpcode(201);
                     secretPacketBuffer1.putShort((class59.field732 == 2?1:0) + (var5 << 1));
                     secretPacketBuffer1.putShort(var4);
                     secretPacketBuffer1.putShort(var3);
                  }

                  if(class50.field653 > 0) {
                     secretPacketBuffer1.putOpcode(23);
                     secretPacketBuffer1.putShort(0);
                     var1 = secretPacketBuffer1.offset;
                     long var18 = XGrandExchangeOffer.method96();

                     for(var4 = 0; var4 < class50.field653; ++var4) {
                        long var20 = var18 - field1154;
                        if(var20 > 16777215L) {
                           var20 = 16777215L;
                        }

                        field1154 = var18;
                        secretPacketBuffer1.method3308((int)var20);
                        secretPacketBuffer1.putByte(class50.field652[var4]);
                     }

                     secretPacketBuffer1.method3192(secretPacketBuffer1.offset - var1);
                  }

                  if(field1020 > 0) {
                     --field1020;
                  }

                  if(class50.field645[96] || class50.field645[97] || class50.field645[98] || class50.field645[99]) {
                     field1021 = true;
                  }

                  if(field1021 && field1020 <= 0) {
                     field1020 = 20;
                     field1021 = false;
                     secretPacketBuffer1.putOpcode(127);
                     secretPacketBuffer1.method3227(field1013);
                     secretPacketBuffer1.method3175(mapAngle);
                  }

                  if(class44.field582 && !field1042) {
                     field1042 = true;
                     secretPacketBuffer1.putOpcode(93);
                     secretPacketBuffer1.putByte(1);
                  }

                  if(!class44.field582 && field1042) {
                     field1042 = false;
                     secretPacketBuffer1.putOpcode(93);
                     secretPacketBuffer1.putByte(0);
                  }

                  class19.method129();
                  if(gameState != 30) {
                     return;
                  }

                  class226.method4076();
                  class9.method33();
                  ++field977;
                  if(field977 > 750) {
                     class84.method1669();
                     return;
                  }

                  var1 = class96.field1507;
                  int[] var30 = class96.field1508;

                  for(var3 = 0; var3 < var1; ++var3) {
                     Player var22 = cachedPlayers[var30[var3]];
                     if(var22 != null) {
                        class61.method1050(var22, 1);
                     }
                  }

                  class9.method41();
                  int[] var34 = class96.field1508;

                  for(var14 = 0; var14 < class96.field1507; ++var14) {
                     Player var23 = cachedPlayers[var34[var14]];
                     if(var23 != null && var23.field1258 > 0) {
                        --var23.field1258;
                        if(var23.field1258 == 0) {
                           var23.overhead = null;
                        }
                     }
                  }

                  for(var14 = 0; var14 < field968; ++var14) {
                     var3 = field950[var14];
                     NPC var36 = cachedNPCs[var3];
                     if(var36 != null && var36.field1258 > 0) {
                        --var36.field1258;
                        if(var36.field1258 == 0) {
                           var36.overhead = null;
                        }
                     }
                  }

                  ++field1119;
                  if(field1186 != 0) {
                     field1000 += 20;
                     if(field1000 >= 400) {
                        field1186 = 0;
                     }
                  }

                  if(class47.field614 != null) {
                     ++field932;
                     if(field932 >= 15) {
                        class25.method169(class47.field614);
                        class47.field614 = null;
                     }
                  }

                  Widget var35 = WorldMapType1.field434;
                  Widget var31 = XItemContainer.field791;
                  WorldMapType1.field434 = null;
                  XItemContainer.field791 = null;
                  field1107 = null;
                  field1111 = false;
                  field1108 = false;
                  field1151 = 0;

                  while(World.method1546() && field1151 < 128) {
                     if(field1097 >= 2 && class50.field645[82] && class3.field27 == 66) {
                        String var37 = "";

                        MessageNode var25;
                        for(Iterator var24 = class98.field1532.iterator(); var24.hasNext(); var37 = var37 + var25.name + ':' + var25.value + '\n') {
                           var25 = (MessageNode)var24.next();
                        }

                        field1214.method832(var37);
                     } else {
                        field1153[field1151] = class3.field27;
                        field1152[field1151] = class50.field642;
                        ++field1151;
                     }
                  }

                  if(widgetRoot != -1) {
                     XClanMember.method1139(widgetRoot, 0, 0, VertexNormal.field2020, class18.field311, 0, 0);
                  }

                  ++field1121;

                  while(true) {
                     class69 var38;
                     Widget var39;
                     Widget var40;
                     do {
                        var38 = (class69)field1130.method3595();
                        if(var38 == null) {
                           while(true) {
                              do {
                                 var38 = (class69)field1131.method3595();
                                 if(var38 == null) {
                                    while(true) {
                                       do {
                                          var38 = (class69)field955.method3595();
                                          if(var38 == null) {
                                             this.method1289();
                                             class83.method1656();
                                             if(field1164 != null) {
                                                this.method1152();
                                             }

                                             if(GroundObject.field1885 != null) {
                                                class25.method169(GroundObject.field1885);
                                                ++field1205;
                                                if(class59.field736 == 0) {
                                                   if(field958) {
                                                      if(GroundObject.field1885 == Ignore.field866 && field1043 != field940) {
                                                         Widget var41 = GroundObject.field1885;
                                                         byte var33 = 0;
                                                         if(field1005 == 1 && var41.contentType == 206) {
                                                            var33 = 1;
                                                         }

                                                         if(var41.itemIds[field940] <= 0) {
                                                            var33 = 0;
                                                         }

                                                         if(class47.method693(class210.method3903(var41))) {
                                                            var5 = field1043;
                                                            var6 = field940;
                                                            var41.itemIds[var6] = var41.itemIds[var5];
                                                            var41.itemQuantities[var6] = var41.itemQuantities[var5];
                                                            var41.itemIds[var5] = -1;
                                                            var41.itemQuantities[var5] = 0;
                                                         } else if(var33 == 1) {
                                                            var5 = field1043;
                                                            var6 = field940;

                                                            while(var5 != var6) {
                                                               if(var5 > var6) {
                                                                  var41.method3982(var5 - 1, var5);
                                                                  --var5;
                                                               } else if(var5 < var6) {
                                                                  var41.method3982(var5 + 1, var5);
                                                                  ++var5;
                                                               }
                                                            }
                                                         } else {
                                                            var41.method3982(field940, field1043);
                                                         }

                                                         secretPacketBuffer1.putOpcode(183);
                                                         secretPacketBuffer1.putShort(field940);
                                                         secretPacketBuffer1.method3183(GroundObject.field1885.id);
                                                         secretPacketBuffer1.method3227(field1043);
                                                         secretPacketBuffer1.method3166(var33);
                                                      }
                                                   } else {
                                                      label1116: {
                                                         var3 = class67.method1080();
                                                         if(menuOptionCount > 2) {
                                                            label1104: {
                                                               label895: {
                                                                  if(field1067 == 1) {
                                                                     boolean var32;
                                                                     if(menuOptionCount <= 0) {
                                                                        var32 = false;
                                                                     } else if(field1078 && class50.field645[81] && field1090 != -1) {
                                                                        var32 = true;
                                                                     } else {
                                                                        var32 = false;
                                                                     }

                                                                     if(!var32) {
                                                                        break label895;
                                                                     }
                                                                  }

                                                                  if(!class51.method755(var3)) {
                                                                     break label1104;
                                                                  }
                                                               }

                                                               this.method1335(field1044, field1081);
                                                               break label1116;
                                                            }
                                                         }

                                                         if(menuOptionCount > 0) {
                                                            var4 = field1044;
                                                            var5 = field1081;
                                                            class89 var42 = class20.field319;
                                                            class46.menuAction(var42.field1428, var42.field1421, var42.field1420, var42.field1423, var42.field1422, var42.field1422, var4, var5);
                                                            class20.field319 = null;
                                                         }
                                                      }
                                                   }

                                                   field932 = 10;
                                                   class59.field732 = 0;
                                                   GroundObject.field1885 = null;
                                                } else if(field1205 >= 5 && (class59.field737 > field1044 + 5 || class59.field737 < field1044 - 5 || class59.field738 > field1081 + 5 || class59.field738 < field1081 - 5)) {
                                                   field958 = true;
                                                }
                                             }

                                             if(Region.method2821()) {
                                                var3 = Region.field2109;
                                                var4 = Region.field2101;
                                                secretPacketBuffer1.putOpcode(38);
                                                secretPacketBuffer1.putByte(5);
                                                secretPacketBuffer1.method3175(WorldMapType3.baseY + var4);
                                                secretPacketBuffer1.method3175(var3 + class41.baseX);
                                                secretPacketBuffer1.method3170(class50.field645[82]?(class50.field645[81]?2:1):0);
                                                Region.method2714();
                                                field1175 = class59.field745;
                                                field1038 = class59.field750;
                                                field1186 = 1;
                                                field1000 = 0;
                                                flagX = var3;
                                                flagY = var4;
                                             }

                                             if(var35 != WorldMapType1.field434) {
                                                if(var35 != null) {
                                                   class25.method169(var35);
                                                }

                                                if(WorldMapType1.field434 != null) {
                                                   class25.method169(WorldMapType1.field434);
                                                }
                                             }

                                             if(var31 != XItemContainer.field791 && field1082 == field991) {
                                                if(var31 != null) {
                                                   class25.method169(var31);
                                                }

                                                if(XItemContainer.field791 != null) {
                                                   class25.method169(XItemContainer.field791);
                                                }
                                             }

                                             if(XItemContainer.field791 != null) {
                                                if(field991 < field1082) {
                                                   ++field991;
                                                   if(field1082 == field991) {
                                                      class25.method169(XItemContainer.field791);
                                                   }
                                                }
                                             } else if(field991 > 0) {
                                                --field991;
                                             }

                                             var3 = World.localPlayer.x + field994;
                                             var4 = field996 + World.localPlayer.y;
                                             if(class2.field16 - var3 < -500 || class2.field16 - var3 > 500 || WorldMapType2.field515 - var4 < -500 || WorldMapType2.field515 - var4 > 500) {
                                                class2.field16 = var3;
                                                WorldMapType2.field515 = var4;
                                             }

                                             if(class2.field16 != var3) {
                                                class2.field16 += (var3 - class2.field16) / 16;
                                             }

                                             if(WorldMapType2.field515 != var4) {
                                                WorldMapType2.field515 += (var4 - WorldMapType2.field515) / 16;
                                             }

                                             if(class59.field736 == 4 && class233.field3202) {
                                                var5 = class59.field738 - field961;
                                                field1016 = var5 * 2;
                                                field961 = var5 != -1 && var5 != 1?(class59.field738 + field961) / 2:class59.field738;
                                                var6 = field1069 - class59.field737;
                                                field1015 = var6 * 2;
                                                field1069 = var6 != -1 && var6 != 1?(field1069 + class59.field737) / 2:class59.field737;
                                             } else {
                                                if(class50.field645[96]) {
                                                   field1015 += (-24 - field1015) / 2;
                                                } else if(class50.field645[97]) {
                                                   field1015 += (24 - field1015) / 2;
                                                } else {
                                                   field1015 /= 2;
                                                }

                                                if(class50.field645[98]) {
                                                   field1016 += (12 - field1016) / 2;
                                                } else if(class50.field645[99]) {
                                                   field1016 += (-12 - field1016) / 2;
                                                } else {
                                                   field1016 /= 2;
                                                }

                                                field961 = class59.field738;
                                                field1069 = class59.field737;
                                             }

                                             mapAngle = mapAngle + field1015 / 2 & 2047;
                                             field1013 += field1016 / 2;
                                             if(field1013 < 128) {
                                                field1013 = 128;
                                             }

                                             if(field1013 > 383) {
                                                field1013 = 383;
                                             }

                                             var5 = class2.field16 >> 7;
                                             var6 = WorldMapType2.field515 >> 7;
                                             var7 = class21.method139(class2.field16, WorldMapType2.field515, FaceNormal.plane);
                                             var8 = 0;
                                             int var11;
                                             int var12;
                                             int var26;
                                             if(var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
                                                for(var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
                                                   for(var26 = var6 - 4; var26 <= var6 + 4; ++var26) {
                                                      var11 = FaceNormal.plane;
                                                      if(var11 < 3 && (class61.tileSettings[1][var9][var26] & 2) == 2) {
                                                         ++var11;
                                                      }

                                                      var12 = var7 - class61.tileHeights[var11][var9][var26];
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

                                             if(var9 > field1047) {
                                                field1047 += (var9 - field1047) / 24;
                                             } else if(var9 < field1047) {
                                                field1047 += (var9 - field1047) / 80;
                                             }

                                             if(field989) {
                                                var3 = class92.field1463 * 128 + 64;
                                                var4 = WorldMapType2.field521 * 128 + 64;
                                                var5 = class21.method139(var3, var4, FaceNormal.plane) - class69.field860;
                                                if(TextureProvider.cameraX < var3) {
                                                   TextureProvider.cameraX += TextureProvider.field1795 + class211.field2607 * (var3 - TextureProvider.cameraX) / 1000;
                                                   if(TextureProvider.cameraX > var3) {
                                                      TextureProvider.cameraX = var3;
                                                   }
                                                }

                                                if(TextureProvider.cameraX > var3) {
                                                   TextureProvider.cameraX -= TextureProvider.field1795 + class211.field2607 * (TextureProvider.cameraX - var3) / 1000;
                                                   if(TextureProvider.cameraX < var3) {
                                                      TextureProvider.cameraX = var3;
                                                   }
                                                }

                                                if(class19.cameraZ < var5) {
                                                   class19.cameraZ += class211.field2607 * (var5 - class19.cameraZ) / 1000 + TextureProvider.field1795;
                                                   if(class19.cameraZ > var5) {
                                                      class19.cameraZ = var5;
                                                   }
                                                }

                                                if(class19.cameraZ > var5) {
                                                   class19.cameraZ -= class211.field2607 * (class19.cameraZ - var5) / 1000 + TextureProvider.field1795;
                                                   if(class19.cameraZ < var5) {
                                                      class19.cameraZ = var5;
                                                   }
                                                }

                                                if(class67.cameraY < var4) {
                                                   class67.cameraY += TextureProvider.field1795 + class211.field2607 * (var4 - class67.cameraY) / 1000;
                                                   if(class67.cameraY > var4) {
                                                      class67.cameraY = var4;
                                                   }
                                                }

                                                if(class67.cameraY > var4) {
                                                   class67.cameraY -= TextureProvider.field1795 + class211.field2607 * (class67.cameraY - var4) / 1000;
                                                   if(class67.cameraY < var4) {
                                                      class67.cameraY = var4;
                                                   }
                                                }

                                                var3 = class73.field883 * 128 + 64;
                                                var4 = class8.field246 * 128 + 64;
                                                var5 = class21.method139(var3, var4, FaceNormal.plane) - ISAACCipher.field2438;
                                                var6 = var3 - TextureProvider.cameraX;
                                                var7 = var5 - class19.cameraZ;
                                                var8 = var4 - class67.cameraY;
                                                var9 = (int)Math.sqrt((double)(var6 * var6 + var8 * var8));
                                                var26 = (int)(Math.atan2((double)var7, (double)var9) * 325.949D) & 2047;
                                                var11 = (int)(Math.atan2((double)var6, (double)var8) * -325.949D) & 2047;
                                                if(var26 < 128) {
                                                   var26 = 128;
                                                }

                                                if(var26 > 383) {
                                                   var26 = 383;
                                                }

                                                if(Preferences.cameraPitch < var26) {
                                                   Preferences.cameraPitch += class64.field810 * (var26 - Preferences.cameraPitch) / 1000 + class261.field3626;
                                                   if(Preferences.cameraPitch > var26) {
                                                      Preferences.cameraPitch = var26;
                                                   }
                                                }

                                                if(Preferences.cameraPitch > var26) {
                                                   Preferences.cameraPitch -= class261.field3626 + class64.field810 * (Preferences.cameraPitch - var26) / 1000;
                                                   if(Preferences.cameraPitch < var26) {
                                                      Preferences.cameraPitch = var26;
                                                   }
                                                }

                                                var12 = var11 - class13.cameraYaw;
                                                if(var12 > 1024) {
                                                   var12 -= 2048;
                                                }

                                                if(var12 < -1024) {
                                                   var12 += 2048;
                                                }

                                                if(var12 > 0) {
                                                   class13.cameraYaw += class64.field810 * var12 / 1000 + class261.field3626;
                                                   class13.cameraYaw &= 2047;
                                                }

                                                if(var12 < 0) {
                                                   class13.cameraYaw -= class64.field810 * -var12 / 1000 + class261.field3626;
                                                   class13.cameraYaw &= 2047;
                                                }

                                                int var13 = var11 - class13.cameraYaw;
                                                if(var13 > 1024) {
                                                   var13 -= 2048;
                                                }

                                                if(var13 < -1024) {
                                                   var13 += 2048;
                                                }

                                                if(var13 < 0 && var12 > 0 || var13 > 0 && var12 < 0) {
                                                   class13.cameraYaw = var11;
                                                }
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field1181[var3];
                                             }

                                             Player.chatMessages.method1792();
                                             var3 = ++class59.mouseIdleTicks - 1;
                                             var5 = WorldMapData.method268();
                                             if(var3 > 15000 && var5 > 15000) {
                                                field982 = 250;
                                                WorldMapType0.method722(14500);
                                                secretPacketBuffer1.putOpcode(88);
                                             }

                                             ++field936;
                                             if(field936 > 500) {
                                                field936 = 0;
                                                var6 = (int)(Math.random() * 8.0D);
                                                if((var6 & 1) == 1) {
                                                   field994 += field1048;
                                                }

                                                if((var6 & 2) == 2) {
                                                   field996 += field1129;
                                                }

                                                if((var6 & 4) == 4) {
                                                   field1041 += field999;
                                                }
                                             }

                                             if(field994 < -50) {
                                                field1048 = 2;
                                             }

                                             if(field994 > 50) {
                                                field1048 = -2;
                                             }

                                             if(field996 < -55) {
                                                field1129 = 2;
                                             }

                                             if(field996 > 55) {
                                                field1129 = -2;
                                             }

                                             if(field1041 < -40) {
                                                field999 = 1;
                                             }

                                             if(field1041 > 40) {
                                                field999 = -1;
                                             }

                                             ++field1039;
                                             if(field1039 > 500) {
                                                field1039 = 0;
                                                var6 = (int)(Math.random() * 8.0D);
                                                if((var6 & 1) == 1) {
                                                   mapScale += mapOffset;
                                                }

                                                if((var6 & 2) == 2) {
                                                   mapScaleDelta += field1004;
                                                }
                                             }

                                             if(mapScale < -60) {
                                                mapOffset = 2;
                                             }

                                             if(mapScale > 60) {
                                                mapOffset = -2;
                                             }

                                             if(mapScaleDelta < -20) {
                                                field1004 = 1;
                                             }

                                             if(mapScaleDelta > 10) {
                                                field1004 = -1;
                                             }

                                             for(class67 var43 = (class67)field1060.method3603(); var43 != null; var43 = (class67)field1060.method3605()) {
                                                if((long)var43.field830 < XGrandExchangeOffer.method96() / 1000L - 5L) {
                                                   if(var43.field835 > 0) {
                                                      class18.sendGameMessage(5, "", var43.field831 + " has logged in.");
                                                   }

                                                   if(var43.field835 == 0) {
                                                      class18.sendGameMessage(5, "", var43.field831 + " has logged out.");
                                                   }

                                                   var43.method3615();
                                                }
                                             }

                                             ++field1109;
                                             if(field1109 > 50) {
                                                secretPacketBuffer1.putOpcode(235);
                                             }

                                             try {
                                                if(ScriptState.rssocket != null && secretPacketBuffer1.offset > 0) {
                                                   ScriptState.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
                                                   secretPacketBuffer1.offset = 0;
                                                   field1109 = 0;
                                                }
                                             } catch (IOException var27) {
                                                class84.method1669();
                                             }

                                             return;
                                          }

                                          var39 = var38.field852;
                                          if(var39.index < 0) {
                                             break;
                                          }

                                          var40 = WorldMapType3.method199(var39.parentId);
                                       } while(var40 == null || var40.children == null || var39.index >= var40.children.length || var39 != var40.children[var39.index]);

                                       Friend.method1075(var38);
                                    }
                                 }

                                 var39 = var38.field852;
                                 if(var39.index < 0) {
                                    break;
                                 }

                                 var40 = WorldMapType3.method199(var39.parentId);
                              } while(var40 == null || var40.children == null || var39.index >= var40.children.length || var40.children[var39.index] != var39);

                              Friend.method1075(var38);
                           }
                        }

                        var39 = var38.field852;
                        if(var39.index < 0) {
                           break;
                        }

                        var40 = WorldMapType3.method199(var39.parentId);
                     } while(var40 == null || var40.children == null || var39.index >= var40.children.length || var39 != var40.children[var39.index]);

                     Friend.method1075(var38);
                  }
               }

               secretPacketBuffer1.putOpcode(83);
               secretPacketBuffer1.putByte(0);
               var14 = secretPacketBuffer1.offset;
               class257.method4641(secretPacketBuffer1);
               secretPacketBuffer1.method3138(secretPacketBuffer1.offset - var14);
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-84"
   )
   protected final void vmethod1154() {
      field1143 = XGrandExchangeOffer.method96() + 500L;
      this.method1155();
      if(widgetRoot != -1) {
         this.method1176(true);
      }

   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   void method1155() {
      int var1 = VertexNormal.field2020;
      int var2 = class18.field311;
      if(super.field706 < var1) {
         var1 = super.field706;
      }

      if(super.field712 < var2) {
         var2 = super.field712;
      }

      if(XGrandExchangeOffer.field303 != null) {
         try {
            Client var3 = field1214;
            int var4 = isResized?2:1;
            Object[] var5 = new Object[]{Integer.valueOf(var4)};
            JSObject.getWindow(var3).call("resize", var5);
         } catch (Throwable var6) {
            ;
         }
      }

   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2090894898"
   )
   final void method1156() {
      if(widgetRoot != -1) {
         FaceNormal.method2867(widgetRoot);
      }

      int var1;
      for(var1 = 0; var1 < field1133; ++var1) {
         if(field1135[var1]) {
            field1136[var1] = true;
         }

         field1040[var1] = field1135[var1];
         field1135[var1] = false;
      }

      field1134 = gameCycle;
      field1079 = -1;
      field1080 = -1;
      Ignore.field866 = null;
      if(widgetRoot != -1) {
         field1133 = 0;
         class36.method481(widgetRoot, 0, 0, VertexNormal.field2020, class18.field311, 0, 0, -1);
      }

      Rasterizer2D.method4914();
      int var2;
      int var3;
      if(!isMenuOpen) {
         if(field1079 != -1) {
            var1 = field1079;
            var2 = field1080;
            if(menuOptionCount >= 2 || field1083 != 0 || field1085) {
               var3 = class67.method1080();
               String var4;
               if(field1083 == 1 && menuOptionCount < 2) {
                  var4 = "Use" + " " + field1084 + " " + "->";
               } else if(field1085 && menuOptionCount < 2) {
                  var4 = field1088 + " " + field1089 + " " + "->";
               } else {
                  var4 = class61.method1022(var3);
               }

               if(menuOptionCount > 2) {
                  var4 = var4 + WorldMapData.method337(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               XClanMember.field922.method4753(var4, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         class164.method3069();
      }

      if(field1161 == 3) {
         for(var1 = 0; var1 < field1133; ++var1) {
            if(field1040[var1]) {
               Rasterizer2D.method4922(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1136[var1]) {
               Rasterizer2D.method4922(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = FaceNormal.plane;
      var2 = World.localPlayer.x;
      var3 = World.localPlayer.y;
      int var12 = field1119;

      for(class82 var5 = (class82)class82.field1348.method3576(); var5 != null; var5 = (class82)class82.field1348.method3578()) {
         if(var5.field1347 != -1 || var5.field1343 != null) {
            int var6 = 0;
            if(var2 > var5.field1344) {
               var6 += var2 - var5.field1344;
            } else if(var2 < var5.field1349) {
               var6 += var5.field1349 - var2;
            }

            if(var3 > var5.field1351) {
               var6 += var3 - var5.field1351;
            } else if(var3 < var5.field1342) {
               var6 += var5.field1342 - var3;
            }

            if(var6 - 64 <= var5.field1346 && field1169 != 0 && var1 == var5.field1345) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               int var7 = field1169 * (var5.field1346 - var6) / var5.field1346;
               Object var10000;
               if(var5.field1341 == null) {
                  if(var5.field1347 >= 0) {
                     var10000 = null;
                     SoundEffect var8 = SoundEffect.method1944(ChatLineBuffer.field1567, var5.field1347, 0);
                     if(var8 != null) {
                        class107 var9 = var8.method1933().method1982(class137.field2055);
                        class117 var10 = class117.method2106(var9, 100, var7);
                        var10.method2224(-1);
                        class158.field2288.method1884(var10);
                        var5.field1341 = var10;
                     }
                  }
               } else {
                  var5.field1341.method2110(var7);
               }

               if(var5.field1353 == null) {
                  if(var5.field1343 != null && (var5.field1352 -= var12) <= 0) {
                     int var13 = (int)(Math.random() * (double)var5.field1343.length);
                     var10000 = null;
                     SoundEffect var14 = SoundEffect.method1944(ChatLineBuffer.field1567, var5.field1343[var13], 0);
                     if(var14 != null) {
                        class107 var15 = var14.method1933().method1982(class137.field2055);
                        class117 var11 = class117.method2106(var15, 100, var7);
                        var11.method2224(0);
                        class158.field2288.method1884(var11);
                        var5.field1353 = var11;
                        var5.field1352 = var5.field1340 + (int)(Math.random() * (double)(var5.field1350 - var5.field1340));
                     }
                  }
               } else {
                  var5.field1353.method2110(var7);
                  if(!var5.field1353.linked()) {
                     var5.field1353 = null;
                  }
               }
            } else {
               if(var5.field1341 != null) {
                  class158.field2288.method1871(var5.field1341);
                  var5.field1341 = null;
               }

               if(var5.field1353 != null) {
                  class158.field2288.method1871(var5.field1353);
                  var5.field1353 = null;
               }
            }
         }
      }

      field1119 = 0;
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "4"
   )
   final boolean method1157() {
      if(ScriptState.rssocket == null) {
         return false;
      } else {
         int var3;
         String var19;
         try {
            int var1 = ScriptState.rssocket.available();
            if(var1 == 0) {
               return false;
            }

            if(field976 == -1) {
               ScriptState.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               field976 = secretPacketBuffer2.readOpcode();
               packetLength = class272.field3708[field976];
               --var1;
            }

            if(packetLength == -1) {
               if(var1 <= 0) {
                  return false;
               }

               ScriptState.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               packetLength = secretPacketBuffer2.payload[0] & 255;
               --var1;
            }

            if(packetLength == -2) {
               if(var1 <= 1) {
                  return false;
               }

               ScriptState.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();
               var1 -= 2;
            }

            if(var1 < packetLength) {
               return false;
            }

            secretPacketBuffer2.offset = 0;
            ScriptState.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
            field977 = 0;
            field1167 = field980;
            field980 = field995;
            field995 = field976;
            int var2;
            if(field976 == 208) {
               class45.xteaChanged(false);
               secretPacketBuffer2.readOpcode();
               var2 = secretPacketBuffer2.readUnsignedShort();
               class39.method532(secretPacketBuffer2, var2);
               field976 = -1;
               return true;
            }

            int var6;
            int var7;
            int var8;
            boolean var59;
            if(field976 == 252) {
               var19 = secretPacketBuffer2.readString();
               var3 = secretPacketBuffer2.readUnsignedShort();
               byte var61 = secretPacketBuffer2.readByte();
               var59 = false;
               if(var61 == -128) {
                  var59 = true;
               }

               if(var59) {
                  if(class4.clanChatCount == 0) {
                     field976 = -1;
                     return true;
                  }

                  boolean var64 = false;

                  for(var6 = 0; var6 < class4.clanChatCount && (!class77.clanMembers[var6].username.equals(var19) || class77.clanMembers[var6].world != var3); ++var6) {
                     ;
                  }

                  if(var6 < class4.clanChatCount) {
                     while(var6 < class4.clanChatCount - 1) {
                        class77.clanMembers[var6] = class77.clanMembers[var6 + 1];
                        ++var6;
                     }

                     --class4.clanChatCount;
                     class77.clanMembers[class4.clanChatCount] = null;
                  }
               } else {
                  secretPacketBuffer2.readString();
                  XClanMember var81 = new XClanMember();
                  var81.username = var19;
                  var81.field919 = class154.method2955(var81.username, World.field1331);
                  var81.world = var3;
                  var81.rank = var61;

                  for(var7 = class4.clanChatCount - 1; var7 >= 0; --var7) {
                     var8 = class77.clanMembers[var7].field919.compareTo(var81.field919);
                     if(var8 == 0) {
                        class77.clanMembers[var7].world = var3;
                        class77.clanMembers[var7].rank = var61;
                        if(var19.equals(World.localPlayer.name)) {
                           class29.field429 = var61;
                        }

                        field1036 = field1121;
                        field976 = -1;
                        return true;
                     }

                     if(var8 < 0) {
                        break;
                     }
                  }

                  if(class4.clanChatCount >= class77.clanMembers.length) {
                     field976 = -1;
                     return true;
                  }

                  for(var8 = class4.clanChatCount - 1; var8 > var7; --var8) {
                     class77.clanMembers[var8 + 1] = class77.clanMembers[var8];
                  }

                  if(class4.clanChatCount == 0) {
                     class77.clanMembers = new XClanMember[100];
                  }

                  class77.clanMembers[var7 + 1] = var81;
                  ++class4.clanChatCount;
                  if(var19.equals(World.localPlayer.name)) {
                     class29.field429 = var61;
                  }
               }

               field1036 = field1121;
               field976 = -1;
               return true;
            }

            if(field976 == 227) {
               class28.method215(true);
               field976 = -1;
               return true;
            }

            Widget var83;
            if(field976 == 209) {
               var2 = secretPacketBuffer2.method3187();
               var83 = WorldMapType3.method199(var2);
               var83.modelType = 3;
               var83.modelId = World.localPlayer.composition.method3944();
               class25.method169(var83);
               field976 = -1;
               return true;
            }

            int var5;
            if(field976 == 190) {
               var3 = secretPacketBuffer2.readUnsignedByte();
               class276[] var96 = class208.method3865();
               var5 = 0;

               class276 var78;
               while(true) {
                  if(var5 >= var96.length) {
                     var78 = null;
                     break;
                  }

                  class276 var80 = var96[var5];
                  if(var3 == var80.field3737) {
                     var78 = var80;
                     break;
                  }

                  ++var5;
               }

               class56.field695 = var78;
               field976 = -1;
               return true;
            }

            if(field976 == 249) {
               secretPacketBuffer2.offset += 28;
               if(secretPacketBuffer2.method3164()) {
                  class25.method170(secretPacketBuffer2, secretPacketBuffer2.offset - 28);
               }

               field976 = -1;
               return true;
            }

            Widget var22;
            if(field976 == 91) {
               var2 = secretPacketBuffer2.method3219();
               var3 = secretPacketBuffer2.readInt();
               var22 = WorldMapType3.method199(var3);
               if(var22.field2698 != var2 || var2 == -1) {
                  var22.field2698 = var2;
                  var22.field2675 = 0;
                  var22.field2774 = 0;
                  class25.method169(var22);
               }

               field976 = -1;
               return true;
            }

            long var11;
            long var26;
            if(field976 == 28) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.readInt();
               if(class169.field2359 == null || !class169.field2359.isValid()) {
                  try {
                     Iterator var94 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var94.hasNext()) {
                        GarbageCollectorMXBean var88 = (GarbageCollectorMXBean)var94.next();
                        if(var88.isValid()) {
                           class169.field2359 = var88;
                           field1206 = -1L;
                           field1098 = -1L;
                        }
                     }
                  } catch (Throwable var55) {
                     ;
                  }
               }

               long var24 = XGrandExchangeOffer.method96();
               var6 = -1;
               if(class169.field2359 != null) {
                  var26 = class169.field2359.getCollectionTime();
                  if(field1098 != -1L) {
                     long var9 = var26 - field1098;
                     var11 = var24 - field1206;
                     if(var11 != 0L) {
                        var6 = (int)(100L * var9 / var11);
                     }
                  }

                  field1098 = var26;
                  field1206 = var24;
               }

               secretPacketBuffer1.putOpcode(97);
               secretPacketBuffer1.method3165(GameEngine.FPS);
               secretPacketBuffer1.method3166(var6);
               secretPacketBuffer1.method3283(var2);
               secretPacketBuffer1.method3183(var3);
               field976 = -1;
               return true;
            }

            int var4;
            Widget var85;
            if(field976 == 106) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.method3176();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               var4 = secretPacketBuffer2.method3187();
               var85 = WorldMapType3.method199(var2);
               ItemComposition var75;
               if(!var85.hasScript) {
                  if(var3 == -1) {
                     var85.modelType = 0;
                     field976 = -1;
                     return true;
                  }

                  var75 = Buffer.getItemDefinition(var3);
                  var85.modelType = 4;
                  var85.modelId = var3;
                  var85.rotationX = var75.xan2d;
                  var85.rotationZ = var75.yan2d;
                  var85.field2705 = var75.zoom2d * 100 / var4;
                  class25.method169(var85);
               } else {
                  var85.itemId = var3;
                  var85.itemQuantity = var4;
                  var75 = Buffer.getItemDefinition(var3);
                  var85.rotationX = var75.xan2d;
                  var85.rotationZ = var75.yan2d;
                  var85.rotationY = var75.zan2d;
                  var85.field2700 = var75.offsetX2d;
                  var85.field2701 = var75.offsetY2d;
                  var85.field2705 = var75.zoom2d;
                  if(var75.isStackable == 1) {
                     var85.field2709 = 1;
                  } else {
                     var85.field2709 = 2;
                  }

                  if(var85.field2743 > 0) {
                     var85.field2705 = var85.field2705 * 32 / var85.field2743;
                  } else if(var85.originalWidth > 0) {
                     var85.field2705 = var85.field2705 * 32 / var85.originalWidth;
                  }

                  class25.method169(var85);
               }

               field976 = -1;
               return true;
            }

            boolean var68;
            if(field976 == 107) {
               var68 = secretPacketBuffer2.readUnsignedByte() == 1;
               if(var68) {
                  class28.field414 = XGrandExchangeOffer.method96() - secretPacketBuffer2.readLong();
                  class214.field2633 = new class13(secretPacketBuffer2, true);
               } else {
                  class214.field2633 = null;
               }

               field1126 = field1121;
               field976 = -1;
               return true;
            }

            if(field976 == 147) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.readUnsignedShort();
               if(var2 < -70000) {
                  var3 += '耀';
               }

               if(var2 >= 0) {
                  var22 = WorldMapType3.method199(var2);
               } else {
                  var22 = null;
               }

               if(var22 != null) {
                  for(var5 = 0; var5 < var22.itemIds.length; ++var5) {
                     var22.itemIds[var5] = 0;
                     var22.itemQuantities[var5] = 0;
                  }
               }

               XItemContainer var87 = (XItemContainer)XItemContainer.itemContainers.method3520((long)var3);
               if(var87 != null) {
                  for(var6 = 0; var6 < var87.itemIds.length; ++var6) {
                     var87.itemIds[var6] = -1;
                     var87.stackSizes[var6] = 0;
                  }
               }

               var5 = secretPacketBuffer2.readUnsignedShort();

               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = secretPacketBuffer2.readUnsignedByte();
                  if(var7 == 255) {
                     var7 = secretPacketBuffer2.method3187();
                  }

                  var8 = secretPacketBuffer2.method3178();
                  if(var22 != null && var6 < var22.itemIds.length) {
                     var22.itemIds[var6] = var8;
                     var22.itemQuantities[var6] = var7;
                  }

                  class51.method756(var3, var6, var8 - 1, var7);
               }

               if(var22 != null) {
                  class25.method169(var22);
               }

               class2.method0();
               interfaceItemTriggers[++field1137 - 1 & 31] = var3 & 32767;
               field976 = -1;
               return true;
            }

            String var77;
            if(field976 == 144) {
               var2 = secretPacketBuffer2.method3169();
               var77 = secretPacketBuffer2.readString();
               var4 = secretPacketBuffer2.readUnsignedByte();
               if(var4 >= 1 && var4 <= 8) {
                  if(var77.equalsIgnoreCase("null")) {
                     var77 = null;
                  }

                  playerOptions[var4 - 1] = var77;
                  playerOptionsPriorities[var4 - 1] = var2 == 0;
               }

               field976 = -1;
               return true;
            }

            if(field976 == 224) {
               var2 = secretPacketBuffer2.method3186();
               var83 = WorldMapType3.method199(var2);

               for(var4 = 0; var4 < var83.itemIds.length; ++var4) {
                  var83.itemIds[var4] = -1;
                  var83.itemIds[var4] = 0;
               }

               class25.method169(var83);
               field976 = -1;
               return true;
            }

            if(field976 == 27) {
               var2 = secretPacketBuffer2.method3178();
               var3 = secretPacketBuffer2.method3176();
               var4 = secretPacketBuffer2.readInt();
               var85 = WorldMapType3.method199(var4);
               var85.field2707 = (var2 << 16) + var3;
               field976 = -1;
               return true;
            }

            if(field976 == 206) {
               for(var2 = 0; var2 < class211.widgetSettings.length; ++var2) {
                  if(class211.widgetSettings[var2] != class211.settings[var2]) {
                     class211.widgetSettings[var2] = class211.settings[var2];
                     class10.method47(var2);
                     field1116[++field1117 - 1 & 31] = var2;
                  }
               }

               field976 = -1;
               return true;
            }

            if(field976 == 89) {
               var2 = secretPacketBuffer2.method3176();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               class205.method3791(var2);
               field976 = -1;
               return true;
            }

            if(field976 == 152) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var3 = secretPacketBuffer2.method3131();
               MessageNode.method1107(var2, var3);
               field976 = -1;
               return true;
            }

            if(field976 == 26) {
               class66.method1077();
               field976 = -1;
               return false;
            }

            if(field976 == 155) {
               flagX = secretPacketBuffer2.readUnsignedByte();
               if(flagX == 255) {
                  flagX = 0;
               }

               flagY = secretPacketBuffer2.readUnsignedByte();
               if(flagY == 255) {
                  flagY = 0;
               }

               field976 = -1;
               return true;
            }

            if(field976 == 207) {
               World var76 = new World();
               var76.address = secretPacketBuffer2.readString();
               var76.id = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.readInt();
               var76.mask = var3;
               class249.setGameState(45);
               ScriptState.rssocket.method2981();
               ScriptState.rssocket = null;
               class22.method153(var76);
               field976 = -1;
               return false;
            }

            if(field976 == 228) {
               var2 = secretPacketBuffer2.readInt();
               WidgetNode var82 = (WidgetNode)componentTable.method3520((long)var2);
               if(var82 != null) {
                  ScriptState.method1054(var82, true);
               }

               if(field963 != null) {
                  class25.method169(field963);
                  field963 = null;
               }

               field976 = -1;
               return true;
            }

            if(field976 == 43) {
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

               field976 = -1;
               return true;
            }

            if(field976 == 181) {
               field945 = secretPacketBuffer2.readUnsignedByte();
               if(field945 == 1) {
                  field946 = secretPacketBuffer2.readUnsignedShort();
               }

               if(field945 >= 2 && field945 <= 6) {
                  if(field945 == 2) {
                     field1127 = 64;
                     field952 = 64;
                  }

                  if(field945 == 3) {
                     field1127 = 0;
                     field952 = 64;
                  }

                  if(field945 == 4) {
                     field1127 = 128;
                     field952 = 64;
                  }

                  if(field945 == 5) {
                     field1127 = 64;
                     field952 = 0;
                  }

                  if(field945 == 6) {
                     field1127 = 64;
                     field952 = 128;
                  }

                  field945 = 2;
                  field948 = secretPacketBuffer2.readUnsignedShort();
                  field949 = secretPacketBuffer2.readUnsignedShort();
                  field1176 = secretPacketBuffer2.readUnsignedByte();
               }

               if(field945 == 10) {
                  field947 = secretPacketBuffer2.readUnsignedShort();
               }

               field976 = -1;
               return true;
            }

            boolean var65;
            String var79;
            boolean var91;
            if(field976 == 201) {
               while(secretPacketBuffer2.offset < packetLength) {
                  var68 = secretPacketBuffer2.readUnsignedByte() == 1;
                  var77 = secretPacketBuffer2.readString();
                  var79 = secretPacketBuffer2.readString();
                  var5 = secretPacketBuffer2.readUnsignedShort();
                  var6 = secretPacketBuffer2.readUnsignedByte();
                  var7 = secretPacketBuffer2.readUnsignedByte();
                  boolean var60 = (var7 & 2) != 0;
                  var91 = (var7 & 1) != 0;
                  if(var5 > 0) {
                     secretPacketBuffer2.readString();
                     secretPacketBuffer2.readUnsignedByte();
                     secretPacketBuffer2.readInt();
                  }

                  secretPacketBuffer2.readString();

                  for(int var62 = 0; var62 < friendCount; ++var62) {
                     Friend var29 = friends[var62];
                     if(!var68) {
                        if(var77.equals(var29.name)) {
                           if(var29.world != var5) {
                              var65 = true;

                              for(class67 var66 = (class67)field1060.method3603(); var66 != null; var66 = (class67)field1060.method3605()) {
                                 if(var66.field831.equals(var77)) {
                                    if(var5 != 0 && var66.field835 == 0) {
                                       var66.method3615();
                                       var65 = false;
                                    } else if(var5 == 0 && var66.field835 != 0) {
                                       var66.method3615();
                                       var65 = false;
                                    }
                                 }
                              }

                              if(var65) {
                                 field1060.method3608(new class67(var77, var5));
                              }

                              var29.world = var5;
                           }

                           var29.previousName = var79;
                           var29.rank = var6;
                           var29.field822 = var60;
                           var29.field818 = var91;
                           var77 = null;
                           break;
                        }
                     } else if(var79.equals(var29.name)) {
                        var29.name = var77;
                        var29.previousName = var79;
                        var77 = null;
                        break;
                     }
                  }

                  if(var77 != null && friendCount < 400) {
                     Friend var93 = new Friend();
                     friends[friendCount] = var93;
                     var93.name = var77;
                     var93.previousName = var79;
                     var93.world = var5;
                     var93.rank = var6;
                     var93.field822 = var60;
                     var93.field818 = var91;
                     ++friendCount;
                  }
               }

               field1196 = 2;
               field1066 = field1121;
               var68 = false;
               var3 = friendCount;

               while(var3 > 0) {
                  var68 = true;
                  --var3;

                  for(var4 = 0; var4 < var3; ++var4) {
                     var59 = false;
                     Friend var74 = friends[var4];
                     Friend var98 = friends[var4 + 1];
                     if(var74.world != world && world == var98.world) {
                        var59 = true;
                     }

                     if(!var59 && var74.world == 0 && var98.world != 0) {
                        var59 = true;
                     }

                     if(!var59 && !var74.field822 && var98.field822) {
                        var59 = true;
                     }

                     if(!var59 && !var74.field818 && var98.field818) {
                        var59 = true;
                     }

                     if(var59) {
                        Friend var102 = friends[var4];
                        friends[var4] = friends[var4 + 1];
                        friends[var4 + 1] = var102;
                        var68 = false;
                     }
                  }

                  if(var68) {
                     break;
                  }
               }

               field976 = -1;
               return true;
            }

            if(field976 == 18) {
               var2 = secretPacketBuffer2.method3178();
               XItemContainer var73 = (XItemContainer)XItemContainer.itemContainers.method3520((long)var2);
               if(var73 != null) {
                  var73.unlink();
               }

               interfaceItemTriggers[++field1137 - 1 & 31] = var2 & 32767;
               field976 = -1;
               return true;
            }

            if(field976 == 15) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               var3 = secretPacketBuffer2.readUnsignedByte();
               var4 = secretPacketBuffer2.readUnsignedByte();
               var5 = secretPacketBuffer2.readUnsignedByte();
               field1183[var2] = true;
               field1178[var2] = var3;
               field1179[var2] = var4;
               field1180[var2] = var5;
               field1181[var2] = 0;
               field976 = -1;
               return true;
            }

            if(field976 == 82) {
               class88.field1418 = secretPacketBuffer2.readUnsignedByte();
               class207.field2593 = secretPacketBuffer2.readUnsignedByte();

               for(var2 = class88.field1418; var2 < class88.field1418 + 8; ++var2) {
                  for(var3 = class207.field2593; var3 < class207.field2593 + 8; ++var3) {
                     if(groundItemDeque[FaceNormal.plane][var2][var3] != null) {
                        groundItemDeque[FaceNormal.plane][var2][var3] = null;
                        World.groundItemSpawned(var2, var3);
                     }
                  }
               }

               for(class76 var71 = (class76)field979.method3576(); var71 != null; var71 = (class76)field979.method3578()) {
                  if(var71.field1217 >= class88.field1418 && var71.field1217 < class88.field1418 + 8 && var71.field1224 >= class207.field2593 && var71.field1224 < class207.field2593 + 8 && var71.field1225 == FaceNormal.plane) {
                     var71.field1226 = 0;
                  }
               }

               field976 = -1;
               return true;
            }

            WidgetNode var23;
            Widget var69;
            if(field976 == 143) {
               var2 = secretPacketBuffer2.method3186();
               var3 = secretPacketBuffer2.method3191();
               WidgetNode var90 = (WidgetNode)componentTable.method3520((long)var3);
               var23 = (WidgetNode)componentTable.method3520((long)var2);
               if(var23 != null) {
                  ScriptState.method1054(var23, var90 == null || var23.id != var90.id);
               }

               if(var90 != null) {
                  var90.unlink();
                  componentTable.method3516(var90, (long)var2);
               }

               var69 = WorldMapType3.method199(var3);
               if(var69 != null) {
                  class25.method169(var69);
               }

               var69 = WorldMapType3.method199(var2);
               if(var69 != null) {
                  class25.method169(var69);
                  class236.method4216(CombatInfo1.widgets[var69.id >>> 16], var69, true);
               }

               if(widgetRoot != -1) {
                  class158.method2978(widgetRoot, 1);
               }

               field976 = -1;
               return true;
            }

            if(field976 == 115) {
               var2 = secretPacketBuffer2.method3187();
               var3 = secretPacketBuffer2.method3176();
               var4 = var3 >> 10 & 31;
               var5 = var3 >> 5 & 31;
               var6 = var3 & 31;
               var7 = (var5 << 11) + (var4 << 19) + (var6 << 3);
               Widget var101 = WorldMapType3.method199(var2);
               if(var7 != var101.textColor) {
                  var101.textColor = var7;
                  class25.method169(var101);
               }

               field976 = -1;
               return true;
            }

            if(field976 == 250) {
               class45.xteaChanged(true);
               secretPacketBuffer2.readOpcode();
               var2 = secretPacketBuffer2.readUnsignedShort();
               class39.method532(secretPacketBuffer2, var2);
               field976 = -1;
               return true;
            }

            if(field976 == 120) {
               var2 = secretPacketBuffer2.method3191();
               Projectile.field1472 = GameEngine.field721.method2937(var2);
               field976 = -1;
               return true;
            }

            if(field976 == 145) {
               field1170 = secretPacketBuffer2.readUnsignedByte();
               field976 = -1;
               return true;
            }

            if(field976 == 129) {
               class211.method3912(secretPacketBuffer2, packetLength);
               field976 = -1;
               return true;
            }

            if(field976 == 191 || field976 == 73 || field976 == 95 || field976 == 132 || field976 == 219 || field976 == 52 || field976 == 24 || field976 == 77 || field976 == 97 || field976 == 99) {
               Projectile.method1747();
               field976 = -1;
               return true;
            }

            if(field976 == 199) {
               class168.method3111(secretPacketBuffer2.readString());
               field976 = -1;
               return true;
            }

            if(field976 == 94) {
               var19 = secretPacketBuffer2.readString();
               var3 = secretPacketBuffer2.readInt();
               var22 = WorldMapType3.method199(var3);
               if(!var19.equals(var22.text)) {
                  var22.text = var19;
                  class25.method169(var22);
               }

               field976 = -1;
               return true;
            }

            if(field976 == 22) {
               var2 = secretPacketBuffer2.method3177();
               var3 = secretPacketBuffer2.method3186();
               var22 = WorldMapType3.method199(var3);
               if(var22.modelType != 1 || var22.modelId != var2) {
                  var22.modelType = 1;
                  var22.modelId = var2;
                  class25.method169(var22);
               }

               field976 = -1;
               return true;
            }

            if(field976 == 160) {
               if(widgetRoot != -1) {
                  class158.method2978(widgetRoot, 0);
               }

               field976 = -1;
               return true;
            }

            if(field976 == 248) {
               class2.method0();
               var2 = secretPacketBuffer2.method3169();
               var3 = secretPacketBuffer2.method3314();
               var4 = secretPacketBuffer2.readInt();
               skillExperiences[var2] = var4;
               boostedSkillLevels[var2] = var3;
               realSkillLevels[var2] = 1;

               for(var5 = 0; var5 < 98; ++var5) {
                  if(var4 >= class222.field2835[var5]) {
                     realSkillLevels[var2] = var5 + 2;
                  }
               }

               field1120[++field1051 - 1 & 31] = var2;
               field976 = -1;
               return true;
            }

            String var84;
            if(field976 == 100) {
               var19 = secretPacketBuffer2.readString();
               PacketBuffer var89 = secretPacketBuffer2;

               try {
                  var6 = var89.method3154();
                  if(var6 > 32767) {
                     var6 = 32767;
                  }

                  byte[] var97 = new byte[var6];
                  var89.offset += class265.field3654.method3077(var89.payload, var89.offset, var97, 0, var6);
                  String var100 = class243.method4326(var97, 0, var6);
                  var84 = var100;
               } catch (Exception var54) {
                  var84 = "Cabbage";
               }

               var84 = FontTypeFace.method4776(class116.method2098(var84));
               class18.sendGameMessage(6, var19, var84);
               field976 = -1;
               return true;
            }

            if(field976 == 146) {
               for(var2 = 0; var2 < class241.field3288; ++var2) {
                  class241 var72 = class23.method159(var2);
                  if(var72 != null) {
                     class211.settings[var2] = 0;
                     class211.widgetSettings[var2] = 0;
                  }
               }

               class2.method0();
               field1117 += 32;
               field976 = -1;
               return true;
            }

            if(field976 == 127) {
               byte var63 = secretPacketBuffer2.method3172();
               var3 = secretPacketBuffer2.method3176();
               class211.settings[var3] = var63;
               if(var63 != class211.widgetSettings[var3]) {
                  class211.widgetSettings[var3] = var63;
               }

               class10.method47(var3);
               field1116[++field1117 - 1 & 31] = var3;
               field976 = -1;
               return true;
            }

            if(field976 == 41) {
               var2 = secretPacketBuffer2.method3187();
               var3 = secretPacketBuffer2.method3178();
               class211.settings[var3] = var2;
               if(class211.widgetSettings[var3] != var2) {
                  class211.widgetSettings[var3] = var2;
               }

               class10.method47(var3);
               field1116[++field1117 - 1 & 31] = var3;
               field976 = -1;
               return true;
            }

            if(field976 == 163) {
               var2 = secretPacketBuffer2.method3179();
               var3 = secretPacketBuffer2.method3179();
               var4 = secretPacketBuffer2.method3186();
               var85 = WorldMapType3.method199(var4);
               if(var2 != var85.originalX || var85.originalY != var3 || var85.field2656 != 0 || var85.field2643 != 0) {
                  var85.originalX = var2;
                  var85.originalY = var3;
                  var85.field2656 = 0;
                  var85.field2643 = 0;
                  class25.method169(var85);
                  this.method1370(var85);
                  if(var85.type == 0) {
                     class236.method4216(CombatInfo1.widgets[var4 >> 16], var85, false);
                  }
               }

               field976 = -1;
               return true;
            }

            long var33;
            long var35;
            long var38;
            String var41;
            int var42;
            if(field976 == 125) {
               var19 = secretPacketBuffer2.readString();
               var33 = secretPacketBuffer2.readLong();
               var35 = (long)secretPacketBuffer2.readUnsignedShort();
               var26 = (long)secretPacketBuffer2.read24BitInt();
               class230 var103 = (class230)Item.method1751(class100.method1857(), secretPacketBuffer2.readUnsignedByte());
               var38 = (var35 << 32) + var26;
               var65 = false;

               for(int var40 = 0; var40 < 100; ++var40) {
                  if(field1149[var40] == var38) {
                     var65 = true;
                     break;
                  }
               }

               if(var103.field3171 && class211.method3910(var19)) {
                  var65 = true;
               }

               if(!var65 && field985 == 0) {
                  field1149[field1150] = var38;
                  field1150 = (field1150 + 1) % 100;
                  PacketBuffer var14 = secretPacketBuffer2;

                  String var67;
                  try {
                     int var16 = var14.method3154();
                     if(var16 > 32767) {
                        var16 = 32767;
                     }

                     byte[] var17 = new byte[var16];
                     var14.offset += class265.field3654.method3077(var14.payload, var14.offset, var17, 0, var16);
                     String var18 = class243.method4326(var17, 0, var16);
                     var67 = var18;
                  } catch (Exception var53) {
                     var67 = "Cabbage";
                  }

                  var67 = FontTypeFace.method4776(class116.method2098(var67));
                  if(var103.field3174 != -1) {
                     var42 = var103.field3174;
                     var41 = "<img=" + var42 + ">";
                     class151.addChatMessage(9, var41 + var19, var67, Overlay.method4684(var33));
                  } else {
                     class151.addChatMessage(9, var19, var67, Overlay.method4684(var33));
                  }
               }

               field976 = -1;
               return true;
            }

            if(field976 == 153) {
               field989 = true;
               class92.field1463 = secretPacketBuffer2.readUnsignedByte();
               WorldMapType2.field521 = secretPacketBuffer2.readUnsignedByte();
               class69.field860 = secretPacketBuffer2.readUnsignedShort();
               TextureProvider.field1795 = secretPacketBuffer2.readUnsignedByte();
               class211.field2607 = secretPacketBuffer2.readUnsignedByte();
               if(class211.field2607 >= 100) {
                  TextureProvider.cameraX = class92.field1463 * 128 + 64;
                  class67.cameraY = WorldMapType2.field521 * 128 + 64;
                  class19.cameraZ = class21.method139(TextureProvider.cameraX, class67.cameraY, FaceNormal.plane) - class69.field860;
               }

               field976 = -1;
               return true;
            }

            if(field976 == 236) {
               class39.method532(secretPacketBuffer2, packetLength);
               field976 = -1;
               return true;
            }

            boolean var58;
            if(field976 == 175) {
               while(secretPacketBuffer2.offset < packetLength) {
                  var2 = secretPacketBuffer2.readUnsignedByte();
                  var58 = (var2 & 1) == 1;
                  var79 = secretPacketBuffer2.readString();
                  var84 = secretPacketBuffer2.readString();
                  secretPacketBuffer2.readString();

                  for(var6 = 0; var6 < ignoreCount; ++var6) {
                     Ignore var95 = ignores[var6];
                     if(var58) {
                        if(var84.equals(var95.name)) {
                           var95.name = var79;
                           var95.previousName = var84;
                           var79 = null;
                           break;
                        }
                     } else if(var79.equals(var95.name)) {
                        var95.name = var79;
                        var95.previousName = var84;
                        var79 = null;
                        break;
                     }
                  }

                  if(var79 != null && ignoreCount < 400) {
                     Ignore var70 = new Ignore();
                     ignores[ignoreCount] = var70;
                     var70.name = var79;
                     var70.previousName = var84;
                     ++ignoreCount;
                  }
               }

               field1066 = field1121;
               field976 = -1;
               return true;
            }

            if(field976 == 168) {
               var2 = secretPacketBuffer2.method3176();
               var3 = secretPacketBuffer2.method3176();
               var4 = secretPacketBuffer2.method3187();
               var5 = secretPacketBuffer2.method3178();
               var69 = WorldMapType3.method199(var4);
               if(var5 != var69.rotationX || var69.rotationZ != var3 || var69.field2705 != var2) {
                  var69.rotationX = var5;
                  var69.rotationZ = var3;
                  var69.field2705 = var2;
                  class25.method169(var69);
               }

               field976 = -1;
               return true;
            }

            if(field976 == 189) {
               class2.method0();
               weight = secretPacketBuffer2.readShort();
               field1128 = field1121;
               field976 = -1;
               return true;
            }

            if(field976 == 2) {
               field989 = false;

               for(var2 = 0; var2 < 5; ++var2) {
                  field1183[var2] = false;
               }

               field976 = -1;
               return true;
            }

            if(field976 == 42) {
               var2 = secretPacketBuffer2.method3169();
               var3 = secretPacketBuffer2.method3191();
               var4 = secretPacketBuffer2.method3176();
               var23 = (WidgetNode)componentTable.method3520((long)var3);
               if(var23 != null) {
                  ScriptState.method1054(var23, var23.id != var4);
               }

               class41.method572(var3, var4, var2);
               field976 = -1;
               return true;
            }

            if(field976 == 108) {
               field1031 = secretPacketBuffer2.readUnsignedByte();
               field1147 = secretPacketBuffer2.readUnsignedByte();
               field976 = -1;
               return true;
            }

            if(field976 == 241) {
               field989 = true;
               class73.field883 = secretPacketBuffer2.readUnsignedByte();
               class8.field246 = secretPacketBuffer2.readUnsignedByte();
               ISAACCipher.field2438 = secretPacketBuffer2.readUnsignedShort();
               class261.field3626 = secretPacketBuffer2.readUnsignedByte();
               class64.field810 = secretPacketBuffer2.readUnsignedByte();
               if(class64.field810 >= 100) {
                  var2 = class73.field883 * 128 + 64;
                  var3 = class8.field246 * 128 + 64;
                  var4 = class21.method139(var2, var3, FaceNormal.plane) - ISAACCipher.field2438;
                  var5 = var2 - TextureProvider.cameraX;
                  var6 = var4 - class19.cameraZ;
                  var7 = var3 - class67.cameraY;
                  var8 = (int)Math.sqrt((double)(var5 * var5 + var7 * var7));
                  Preferences.cameraPitch = (int)(Math.atan2((double)var6, (double)var8) * 325.949D) & 2047;
                  class13.cameraYaw = (int)(Math.atan2((double)var5, (double)var7) * -325.949D) & 2047;
                  if(Preferences.cameraPitch < 128) {
                     Preferences.cameraPitch = 128;
                  }

                  if(Preferences.cameraPitch > 383) {
                     Preferences.cameraPitch = 383;
                  }
               }

               field976 = -1;
               return true;
            }

            if(field976 == 178) {
               var2 = secretPacketBuffer2.method3176();
               var3 = secretPacketBuffer2.method3191();
               var22 = WorldMapType3.method199(var3);
               if(var22.modelType != 2 || var22.modelId != var2) {
                  var22.modelType = 2;
                  var22.modelId = var2;
                  class25.method169(var22);
               }

               field976 = -1;
               return true;
            }

            if(field976 == 0) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               if(secretPacketBuffer2.readUnsignedByte() == 0) {
                  grandExchangeOffers[var2] = new XGrandExchangeOffer();
                  secretPacketBuffer2.offset += 18;
               } else {
                  --secretPacketBuffer2.offset;
                  grandExchangeOffers[var2] = new XGrandExchangeOffer(secretPacketBuffer2, false);
               }

               field1125 = field1121;
               field976 = -1;
               return true;
            }

            if(field976 == 138) {
               var2 = secretPacketBuffer2.readInt();
               var3 = secretPacketBuffer2.readUnsignedShort();
               if(var2 < -70000) {
                  var3 += '耀';
               }

               if(var2 >= 0) {
                  var22 = WorldMapType3.method199(var2);
               } else {
                  var22 = null;
               }

               for(; secretPacketBuffer2.offset < packetLength; class51.method756(var3, var5, var6 - 1, var7)) {
                  var5 = secretPacketBuffer2.method3154();
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
                  class25.method169(var22);
               }

               class2.method0();
               interfaceItemTriggers[++field1137 - 1 & 31] = var3 & 32767;
               field976 = -1;
               return true;
            }

            if(field976 == 9) {
               var19 = secretPacketBuffer2.readString();
               Object[] var21 = new Object[var19.length() + 1];

               for(var4 = var19.length() - 1; var4 >= 0; --var4) {
                  if(var19.charAt(var4) == 115) {
                     var21[var4 + 1] = secretPacketBuffer2.readString();
                  } else {
                     var21[var4 + 1] = new Integer(secretPacketBuffer2.readInt());
                  }
               }

               var21[0] = new Integer(secretPacketBuffer2.readInt());
               class69 var86 = new class69();
               var86.field849 = var21;
               Friend.method1075(var86);
               field976 = -1;
               return true;
            }

            if(field976 == 213) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.readUnsignedByte();
               var4 = secretPacketBuffer2.readUnsignedShort();
               class43.method602(var2, var3, var4);
               field976 = -1;
               return true;
            }

            if(field976 == 90) {
               class207.field2593 = secretPacketBuffer2.method3169();
               class88.field1418 = secretPacketBuffer2.method3314();

               while(secretPacketBuffer2.offset < packetLength) {
                  field976 = secretPacketBuffer2.readUnsignedByte();
                  Projectile.method1747();
               }

               field976 = -1;
               return true;
            }

            long var43;
            int var45;
            if(field976 == 14) {
               var19 = secretPacketBuffer2.readString();
               var33 = (long)secretPacketBuffer2.readUnsignedShort();
               var35 = (long)secretPacketBuffer2.read24BitInt();
               class230 var31 = (class230)Item.method1751(class100.method1857(), secretPacketBuffer2.readUnsignedByte());
               var43 = (var33 << 32) + var35;
               boolean var10 = false;

               for(var45 = 0; var45 < 100; ++var45) {
                  if(field1149[var45] == var43) {
                     var10 = true;
                     break;
                  }
               }

               if(class211.method3910(var19)) {
                  var10 = true;
               }

               if(!var10 && field985 == 0) {
                  field1149[field1150] = var43;
                  field1150 = (field1150 + 1) % 100;
                  PacketBuffer var46 = secretPacketBuffer2;

                  String var13;
                  try {
                     int var47 = var46.method3154();
                     if(var47 > 32767) {
                        var47 = 32767;
                     }

                     byte[] var15 = new byte[var47];
                     var46.offset += class265.field3654.method3077(var46.payload, var46.offset, var15, 0, var47);
                     var41 = class243.method4326(var15, 0, var47);
                     var13 = var41;
                  } catch (Exception var52) {
                     var13 = "Cabbage";
                  }

                  var13 = FontTypeFace.method4776(class116.method2098(var13));
                  byte var104;
                  if(var31.field3173) {
                     var104 = 7;
                  } else {
                     var104 = 3;
                  }

                  if(var31.field3174 != -1) {
                     var42 = var31.field3174;
                     var41 = "<img=" + var42 + ">";
                     class18.sendGameMessage(var104, var41 + var19, var13);
                  } else {
                     class18.sendGameMessage(var104, var19, var13);
                  }
               }

               field976 = -1;
               return true;
            }

            int var28;
            if(field976 == 105) {
               field1036 = field1121;
               if(packetLength == 0) {
                  field1155 = null;
                  clanChatOwner = null;
                  class4.clanChatCount = 0;
                  class77.clanMembers = null;
                  field976 = -1;
                  return true;
               }

               clanChatOwner = secretPacketBuffer2.readString();
               long var49 = secretPacketBuffer2.readLong();
               var35 = var49;
               if(var49 > 0L && var49 < 6582952005840035281L) {
                  if(0L == var49 % 37L) {
                     var79 = null;
                  } else {
                     var7 = 0;

                     for(var43 = var49; 0L != var43; var43 /= 37L) {
                        ++var7;
                     }

                     StringBuilder var30 = new StringBuilder(var7);

                     while(0L != var35) {
                        var11 = var35;
                        var35 /= 37L;
                        var30.append(class268.field3670[(int)(var11 - 37L * var35)]);
                     }

                     var79 = var30.reverse().toString();
                  }
               } else {
                  var79 = null;
               }

               field1155 = var79;
               class251.field3390 = secretPacketBuffer2.readByte();
               var7 = secretPacketBuffer2.readUnsignedByte();
               if(var7 == 255) {
                  field976 = -1;
                  return true;
               }

               class4.clanChatCount = var7;
               XClanMember[] var99 = new XClanMember[100];

               for(var28 = 0; var28 < class4.clanChatCount; ++var28) {
                  var99[var28] = new XClanMember();
                  var99[var28].username = secretPacketBuffer2.readString();
                  var99[var28].field919 = class154.method2955(var99[var28].username, World.field1331);
                  var99[var28].world = secretPacketBuffer2.readUnsignedShort();
                  var99[var28].rank = secretPacketBuffer2.readByte();
                  secretPacketBuffer2.readString();
                  if(var99[var28].username.equals(World.localPlayer.name)) {
                     class29.field429 = var99[var28].rank;
                  }
               }

               var91 = false;
               var45 = class4.clanChatCount;

               while(var45 > 0) {
                  var91 = true;
                  --var45;

                  for(int var12 = 0; var12 < var45; ++var12) {
                     if(var99[var12].field919.compareTo(var99[var12 + 1].field919) > 0) {
                        XClanMember var92 = var99[var12];
                        var99[var12] = var99[var12 + 1];
                        var99[var12 + 1] = var92;
                        var91 = false;
                     }
                  }

                  if(var91) {
                     break;
                  }
               }

               class77.clanMembers = var99;
               field976 = -1;
               return true;
            }

            if(field976 == 242) {
               class2.method0();
               energy = secretPacketBuffer2.readUnsignedByte();
               field1128 = field1121;
               field976 = -1;
               return true;
            }

            if(field976 == 98) {
               var2 = secretPacketBuffer2.offset + packetLength;
               var3 = secretPacketBuffer2.readUnsignedShort();
               var4 = secretPacketBuffer2.readUnsignedShort();
               if(var3 != widgetRoot) {
                  widgetRoot = var3;
                  this.method1176(false);
                  IndexDataBase.method4203(widgetRoot);
                  class91.method1711(widgetRoot);

                  for(var5 = 0; var5 < 100; ++var5) {
                     field1135[var5] = true;
                  }
               }

               WidgetNode var32;
               for(; var4-- > 0; var32.field845 = true) {
                  var5 = secretPacketBuffer2.readInt();
                  var6 = secretPacketBuffer2.readUnsignedShort();
                  var7 = secretPacketBuffer2.readUnsignedByte();
                  var32 = (WidgetNode)componentTable.method3520((long)var5);
                  if(var32 != null && var6 != var32.id) {
                     ScriptState.method1054(var32, true);
                     var32 = null;
                  }

                  if(var32 == null) {
                     var32 = class41.method572(var5, var6, var7);
                  }
               }

               for(var23 = (WidgetNode)componentTable.method3518(); var23 != null; var23 = (WidgetNode)componentTable.method3524()) {
                  if(var23.field845) {
                     var23.field845 = false;
                  } else {
                     ScriptState.method1054(var23, true);
                  }
               }

               widgetFlags = new XHashTable(512);

               while(secretPacketBuffer2.offset < var2) {
                  var5 = secretPacketBuffer2.readInt();
                  var6 = secretPacketBuffer2.readUnsignedShort();
                  var7 = secretPacketBuffer2.readUnsignedShort();
                  var8 = secretPacketBuffer2.readInt();

                  for(var28 = var6; var28 <= var7; ++var28) {
                     var38 = (long)var28 + ((long)var5 << 32);
                     widgetFlags.method3516(new class198(var8), var38);
                  }
               }

               field976 = -1;
               return true;
            }

            if(field976 == 159) {
               var2 = secretPacketBuffer2.method3177();
               widgetRoot = var2;
               this.method1176(false);
               IndexDataBase.method4203(var2);
               class91.method1711(widgetRoot);

               for(var3 = 0; var3 < 100; ++var3) {
                  field1135[var3] = true;
               }

               field976 = -1;
               return true;
            }

            if(field976 == 44) {
               field1196 = 1;
               field1066 = field1121;
               field976 = -1;
               return true;
            }

            if(field976 == 154) {
               var2 = secretPacketBuffer2.method3186();
               var58 = secretPacketBuffer2.method3314() == 1;
               var22 = WorldMapType3.method199(var2);
               if(var58 != var22.isHidden) {
                  var22.isHidden = var58;
                  class25.method169(var22);
               }

               field976 = -1;
               return true;
            }

            if(field976 == 220) {
               var2 = secretPacketBuffer2.method3154();
               var58 = secretPacketBuffer2.readUnsignedByte() == 1;
               var79 = "";
               var59 = false;
               if(var58) {
                  var79 = secretPacketBuffer2.readString();
                  if(class211.method3910(var79)) {
                     var59 = true;
                  }
               }

               String var20 = secretPacketBuffer2.readString();
               if(!var59) {
                  class18.sendGameMessage(var2, var79, var20);
               }

               field976 = -1;
               return true;
            }

            if(field976 == 32) {
               var2 = secretPacketBuffer2.method3178();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var3 = secretPacketBuffer2.method3187();
               var4 = secretPacketBuffer2.readUnsignedShort();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               var5 = secretPacketBuffer2.method3191();

               for(var6 = var4; var6 <= var2; ++var6) {
                  var26 = ((long)var5 << 32) + (long)var6;
                  Node var37 = widgetFlags.method3520(var26);
                  if(var37 != null) {
                     var37.unlink();
                  }

                  widgetFlags.method3516(new class198(var3), var26);
               }

               field976 = -1;
               return true;
            }

            if(field976 == 50) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.method3186();
               var22 = WorldMapType3.method199(var3);
               if(var22 != null && var22.type == 0) {
                  if(var2 > var22.scrollHeight - var22.height) {
                     var2 = var22.scrollHeight - var22.height;
                  }

                  if(var2 < 0) {
                     var2 = 0;
                  }

                  if(var2 != var22.scrollY) {
                     var22.scrollY = var2;
                     class25.method169(var22);
                  }
               }

               field976 = -1;
               return true;
            }

            if(field976 == 216) {
               class96.field1507 = 0;

               for(var2 = 0; var2 < 2048; ++var2) {
                  class96.field1506[var2] = null;
                  class96.field1503[var2] = 1;
               }

               for(var2 = 0; var2 < 2048; ++var2) {
                  cachedPlayers[var2] = null;
               }

               class23.method157(secretPacketBuffer2);
               field976 = -1;
               return true;
            }

            if(field976 == 113) {
               class88.field1418 = secretPacketBuffer2.method3314();
               class207.field2593 = secretPacketBuffer2.method3169();
               field976 = -1;
               return true;
            }

            if(field976 == 54) {
               class28.method215(false);
               field976 = -1;
               return true;
            }

            if(field976 == 232) {
               field981 = secretPacketBuffer2.method3176() * 30;
               field1128 = field1121;
               field976 = -1;
               return true;
            }

            class21.method138("" + field976 + "," + field980 + "," + field1167 + "," + packetLength, (Throwable)null);
            class66.method1077();
         } catch (IOException var56) {
            class84.method1669();
         } catch (Exception var57) {
            var19 = "" + field976 + "," + field980 + "," + field1167 + "," + packetLength + "," + (class41.baseX + World.localPlayer.pathX[0]) + "," + (World.localPlayer.pathY[0] + WorldMapType3.baseY) + ",";

            for(var3 = 0; var3 < packetLength && var3 < 50; ++var3) {
               var19 = var19 + secretPacketBuffer2.payload[var3] + ",";
            }

            class21.method138(var19, var57);
            class66.method1077();
         }

         return true;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method1149();
      class231.method4099();
      ItemLayer.method2392();
      WidgetNode.method1084();
      class166.method3082();
      class59 var1 = class59.mouse;
      synchronized(class59.mouse) {
         class59.field736 = class59.field733;
         class59.field737 = class59.mouseX;
         class59.field738 = class59.mouseY;
         class59.field732 = class59.field735;
         class59.field745 = class59.field740;
         class59.field750 = class59.field741;
         class59.field746 = class59.field742;
         class59.field735 = 0;
      }

      if(WorldMapType0.field619 != null) {
         int var3 = WorldMapType0.field619.vmethod2965();
         field954 = var3;
      }

      if(gameState == 0) {
         ChatLineBuffer.method1867();
         class64.method1071();
      } else if(gameState == 5) {
         class35.method479(this);
         ChatLineBuffer.method1867();
         class64.method1071();
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class35.method479(this);
            this.method1377();
         } else if(gameState == 25) {
            class64.method1070();
         }
      } else {
         class35.method479(this);
      }

      if(gameState == 30) {
         this.method1153();
      } else if(gameState == 40 || gameState == 45) {
         this.method1377();
      }

   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-111"
   )
   final void method1176(boolean var1) {
      int var2 = widgetRoot;
      int var3 = VertexNormal.field2020;
      int var4 = class18.field311;
      if(RSSocket.method2986(var2)) {
         class174.method3351(CombatInfo1.widgets[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "6605"
   )
   final void method1289() {
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
               if(field1090 != -1) {
                  if(var2 == field1090) {
                     field1090 = var2 + 1;
                  } else if(var2 + 1 == field1090) {
                     field1090 = var2;
                  }
               }

               var1 = false;
            }
         }
      }

      if(GroundObject.field1885 == null) {
         if(field1164 == null) {
            int var20 = class59.field732;
            int var6;
            int var7;
            int var8;
            int var9;
            int var14;
            int var15;
            if(isMenuOpen) {
               if(var20 != 1 && (class233.field3202 || var20 != 4)) {
                  var2 = class59.field737;
                  var14 = class59.field738;
                  if(var2 < class67.menuX - 10 || var2 > class98.menuWidth + class67.menuX + 10 || var14 < WorldMapType3.menuY - 10 || var14 > class4.menuHeight + WorldMapType3.menuY + 10) {
                     isMenuOpen = false;
                     class46.method689(class67.menuX, WorldMapType3.menuY, class98.menuWidth, class4.menuHeight);
                  }
               }

               if(var20 == 1 || !class233.field3202 && var20 == 4) {
                  var2 = class67.menuX;
                  var14 = WorldMapType3.menuY;
                  var15 = class98.menuWidth;
                  var5 = class59.field745;
                  var6 = class59.field750;
                  var7 = -1;

                  for(var8 = 0; var8 < menuOptionCount; ++var8) {
                     var9 = var14 + 31 + (menuOptionCount - 1 - var8) * 15;
                     if(var5 > var2 && var5 < var2 + var15 && var6 > var9 - 13 && var6 < var9 + 3) {
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
                     class46.menuAction(var8, var9, var10, var11, var12, var13, class59.field745, class59.field750);
                  }

                  isMenuOpen = false;
                  class46.method689(class67.menuX, WorldMapType3.menuY, class98.menuWidth, class4.menuHeight);
               }
            } else {
               var2 = class67.method1080();
               if((var20 == 1 || !class233.field3202 && var20 == 4) && var2 >= 0) {
                  var14 = menuTypes[var2];
                  if(var14 == 39 || var14 == 40 || var14 == 41 || var14 == 42 || var14 == 43 || var14 == 33 || var14 == 34 || var14 == 35 || var14 == 36 || var14 == 37 || var14 == 38 || var14 == 1005) {
                     var15 = menuActionParams0[var2];
                     var5 = menuActionParams1[var2];
                     Widget var16 = WorldMapType3.method199(var5);
                     if(GameObject.method2900(class210.method3903(var16)) || class47.method693(class210.method3903(var16))) {
                        if(GroundObject.field1885 != null && !field958) {
                           var7 = class67.method1080();
                           if(field1067 != 1 && !class51.method755(var7) && menuOptionCount > 0) {
                              var8 = field1044;
                              var9 = field1081;
                              class89 var18 = class20.field319;
                              class46.menuAction(var18.field1428, var18.field1421, var18.field1420, var18.field1423, var18.field1422, var18.field1422, var8, var9);
                              class20.field319 = null;
                           }
                        }

                        field958 = false;
                        field1205 = 0;
                        if(GroundObject.field1885 != null) {
                           class25.method169(GroundObject.field1885);
                        }

                        GroundObject.field1885 = WorldMapType3.method199(var5);
                        field1043 = var15;
                        field1044 = class59.field745;
                        field1081 = class59.field750;
                        if(var2 >= 0) {
                           class20.field319 = new class89();
                           class20.field319.field1428 = menuActionParams0[var2];
                           class20.field319.field1421 = menuActionParams1[var2];
                           class20.field319.field1420 = menuTypes[var2];
                           class20.field319.field1423 = menuIdentifiers[var2];
                           class20.field319.field1422 = menuOptions[var2];
                        }

                        class25.method169(GroundObject.field1885);
                        return;
                     }
                  }
               }

               if(var20 == 1 || !class233.field3202 && var20 == 4) {
                  label355: {
                     label269: {
                        if(field1067 == 1 && menuOptionCount > 2) {
                           boolean var21;
                           if(menuOptionCount <= 0) {
                              var21 = false;
                           } else if(field1078 && class50.field645[81] && field1090 != -1) {
                              var21 = true;
                           } else {
                              var21 = false;
                           }

                           if(!var21) {
                              break label269;
                           }
                        }

                        if(!class51.method755(var2)) {
                           break label355;
                        }
                     }

                     var20 = 2;
                  }
               }

               if((var20 == 1 || !class233.field3202 && var20 == 4) && menuOptionCount > 0 && var2 >= 0) {
                  var14 = menuActionParams0[var2];
                  var15 = menuActionParams1[var2];
                  var5 = menuTypes[var2];
                  var6 = menuIdentifiers[var2];
                  String var17 = menuOptions[var2];
                  String var19 = menuTargets[var2];
                  class46.menuAction(var14, var15, var5, var6, var17, var19, class59.field745, class59.field750);
               }

               if(var20 == 2 && menuOptionCount > 0) {
                  this.method1335(class59.field745, class59.field750);
               }
            }

         }
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-8413241"
   )
   protected final void vmethod1297() {
      class13.field279 = field931 == 0?'ꩊ':world + '鱀';
      XItemContainer.field790 = field931 == 0?443:world + '썐';
      RSSocket.field2290 = class13.field279;
      class269.field3676 = class214.field2630;
      PlayerComposition.field2627 = class214.field2631;
      PlayerComposition.field2623 = class214.field2632;
      class116.field1703 = class214.field2635;
      this.method833();
      this.method851();
      WorldMapType0.field619 = this.method944();
      NPC.field1398 = new IndexFile(255, class155.field2269, class155.field2270, 500000);
      FileOnDisk var2 = null;
      Preferences var3 = new Preferences();

      try {
         var2 = class151.getPreferencesFile("", class27.field400.field3192, false);
         byte[] var4 = new byte[(int)var2.method2344()];

         int var6;
         for(int var5 = 0; var5 < var4.length; var5 += var6) {
            var6 = var2.method2343(var4, var5, var4.length - var5);
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
            var2.method2348();
         }
      } catch (Exception var7) {
         ;
      }

      XGrandExchangeOffer.field303 = var3;
      this.method831();
      class39.method531(this, class109.field1659);
      if(field931 != 0) {
         field943 = true;
      }

      class232.method4103(XGrandExchangeOffer.field303.field1336);
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-472682604"
   )
   final void method1335(int var1, int var2) {
      int var3 = XClanMember.field922.method4728("Choose Option");

      int var4;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         Font var5 = XClanMember.field922;
         String var8;
         if(var4 < 0) {
            var8 = "";
         } else if(menuTargets[var4].length() > 0) {
            var8 = menuOptions[var4] + " " + menuTargets[var4];
         } else {
            var8 = menuOptions[var4];
         }

         int var7 = var5.method4728(var8);
         if(var7 > var3) {
            var3 = var7;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      int var9 = var1 - var3 / 2;
      if(var3 + var9 > VertexNormal.field2020) {
         var9 = VertexNormal.field2020 - var3;
      }

      if(var9 < 0) {
         var9 = 0;
      }

      int var6 = var2;
      if(var2 + var4 > class18.field311) {
         var6 = class18.field311 - var4;
      }

      if(var6 < 0) {
         var6 = 0;
      }

      class1.region.method2746(FaceNormal.plane, var1, var2, false);
      isMenuOpen = true;
      class67.menuX = var9;
      WorldMapType3.menuY = var6;
      class98.menuWidth = var3;
      class4.menuHeight = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-1168089901"
   )
   void method1370(Widget var1) {
      Widget var2 = var1.parentId == -1?null:WorldMapType3.method199(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = VertexNormal.field2020;
         var4 = class18.field311;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class251.method4435(var1, var3, var4, false);
      RSSocket.method3006(var1, var3, var4);
   }

   @ObfuscatedName("eo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "492303028"
   )
   final void method1377() {
      try {
         if(loginState == 0) {
            if(ScriptState.rssocket != null) {
               ScriptState.rssocket.method2981();
               ScriptState.rssocket = null;
            }

            field1210 = null;
            field983 = false;
            field1197 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(field1210 == null) {
               field1210 = GameEngine.field721.method2935(host, RSSocket.field2290);
            }

            if(field1210.field2244 == 2) {
               throw new IOException();
            }

            if(field1210.field2244 == 1) {
               ScriptState.rssocket = new RSSocket((Socket)field1210.field2248, GameEngine.field721);
               field1210 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(14);
            ScriptState.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, 1);
            secretPacketBuffer2.offset = 0;
            loginState = 3;
         }

         int var1;
         if(loginState == 3) {
            if(class11.field267 != null) {
               class11.field267.method2057();
            }

            if(FaceNormal.field2155 != null) {
               FaceNormal.field2155.method2057();
            }

            var1 = ScriptState.rssocket.readByte();
            if(class11.field267 != null) {
               class11.field267.method2057();
            }

            if(FaceNormal.field2155 != null) {
               FaceNormal.field2155.method2057();
            }

            if(var1 != 0) {
               class10.method43(var1);
               return;
            }

            secretPacketBuffer2.offset = 0;
            loginState = 4;
         }

         if(loginState == 4) {
            if(secretPacketBuffer2.offset < 8) {
               var1 = ScriptState.rssocket.available();
               if(var1 > 8 - secretPacketBuffer2.offset) {
                  var1 = 8 - secretPacketBuffer2.offset;
               }

               if(var1 > 0) {
                  ScriptState.rssocket.read(secretPacketBuffer2.payload, secretPacketBuffer2.offset, var1);
                  secretPacketBuffer2.offset += var1;
               }
            }

            if(secretPacketBuffer2.offset == 8) {
               secretPacketBuffer2.offset = 0;
               class27.field401 = secretPacketBuffer2.readLong();
               loginState = 5;
            }
         }

         int var2;
         int var3;
         if(loginState == 5) {
            int[] var6 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class27.field401 >> 32), (int)(class27.field401 & -1L)};
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(1);
            secretPacketBuffer1.putByte(class92.field1454.vmethod5009());
            secretPacketBuffer1.putInt(var6[0]);
            secretPacketBuffer1.putInt(var6[1]);
            secretPacketBuffer1.putInt(var6[2]);
            secretPacketBuffer1.putInt(var6[3]);
            switch(class92.field1454.field2215) {
            case 0:
               secretPacketBuffer1.putInt(((Integer)XGrandExchangeOffer.field303.preferences.get(Integer.valueOf(class4.method4(class92.username)))).intValue());
               secretPacketBuffer1.offset += 4;
               break;
            case 1:
            case 3:
               secretPacketBuffer1.put24bitInt(class134.authCodeForLogin);
               secretPacketBuffer1.offset += 5;
               break;
            case 2:
               secretPacketBuffer1.offset += 8;
            }

            secretPacketBuffer1.method3150(class92.password);
            secretPacketBuffer1.method3244(class90.rsaKeyExponent, class90.rsaKeyModulus);
            field973.offset = 0;
            if(gameState == 40) {
               field973.putByte(18);
            } else {
               field973.putByte(16);
            }

            field973.putShort(0);
            var2 = field973.offset;
            field973.putInt(143);
            field973.putBytes(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
            var3 = field973.offset;
            field973.method3150(class92.username);
            field973.putByte((isResized?1:0) << 1 | (field1046?1:0));
            field973.putShort(VertexNormal.field2020);
            field973.putShort(class18.field311);
            class28.method223(field973);
            field973.method3150(class67.field833);
            field973.putInt(class18.field312);
            Buffer var4 = new Buffer(class155.field2275.method5360());
            class155.field2275.method5359(var4);
            field973.putBytes(var4.payload, 0, var4.payload.length);
            field973.putByte(class17.field307);
            field973.putInt(0);
            field973.putInt(class46.indexInterfaces.field3228);
            field973.putInt(class31.indexSoundEffects.field3228);
            field973.putInt(Overlay.field3594.field3228);
            field973.putInt(class25.field365.field3228);
            field973.putInt(ChatLineBuffer.field1567.field3228);
            field973.putInt(XClanMember.indexMaps.field3228);
            field973.putInt(class22.indexTrack1.field3228);
            field973.putInt(class36.indexModels.field3228);
            field973.putInt(class261.indexSprites.field3228);
            field973.putInt(WorldMapType3.indexTextures.field3228);
            field973.putInt(WidgetNode.field841.field3228);
            field973.putInt(class4.indexTrack2.field3228);
            field973.putInt(class23.indexScripts.field3228);
            field973.putInt(class20.field324.field3228);
            field973.putInt(field1207.field3228);
            field973.putInt(Coordinates.field2613.field3228);
            field973.putInt(class50.indexWorldMap.field3228);
            field973.encryptXtea(var6, var3, field973.offset);
            field973.method3192(field973.offset - var2);
            ScriptState.rssocket.queueForWrite(field973.payload, 0, field973.offset);
            secretPacketBuffer1.seed(var6);

            for(int var5 = 0; var5 < 4; ++var5) {
               var6[var5] += 50;
            }

            secretPacketBuffer2.seed(var6);
            loginState = 6;
         }

         if(loginState == 6 && ScriptState.rssocket.available() > 0) {
            var1 = ScriptState.rssocket.readByte();
            if(var1 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var1 == 2) {
               loginState = 9;
            } else if(var1 == 15 && gameState == 40) {
               packetLength = -1;
               loginState = 13;
            } else if(var1 == 23 && field1029 < 1) {
               ++field1029;
               loginState = 0;
            } else {
               if(var1 != 29) {
                  class10.method43(var1);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && ScriptState.rssocket.available() > 0) {
            field964 = (ScriptState.rssocket.readByte() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field1197 = 0;
            WorldMapType2.method496("You have only just left another world.", "Your profile will be transferred in:", field964 / 60 + " seconds.");
            if(--field964 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && ScriptState.rssocket.available() >= 13) {
               boolean var12 = ScriptState.rssocket.readByte() == 1;
               ScriptState.rssocket.read(secretPacketBuffer2.payload, 0, 4);
               secretPacketBuffer2.offset = 0;
               boolean var11 = false;
               if(var12) {
                  var2 = secretPacketBuffer2.readOpcode() << 24;
                  var2 |= secretPacketBuffer2.readOpcode() << 16;
                  var2 |= secretPacketBuffer2.readOpcode() << 8;
                  var2 |= secretPacketBuffer2.readOpcode();
                  var3 = class4.method4(class92.username);
                  if(XGrandExchangeOffer.field303.preferences.size() >= 10 && !XGrandExchangeOffer.field303.preferences.containsKey(Integer.valueOf(var3))) {
                     Iterator var13 = XGrandExchangeOffer.field303.preferences.entrySet().iterator();
                     var13.next();
                     var13.remove();
                  }

                  XGrandExchangeOffer.field303.preferences.put(Integer.valueOf(var3), Integer.valueOf(var2));
                  ScriptState.method1052();
               }

               field1097 = ScriptState.rssocket.readByte();
               field1099 = ScriptState.rssocket.readByte() == 1;
               localInteractingIndex = ScriptState.rssocket.readByte();
               localInteractingIndex <<= 8;
               localInteractingIndex += ScriptState.rssocket.readByte();
               field997 = ScriptState.rssocket.readByte();
               ScriptState.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               field976 = secretPacketBuffer2.readOpcode();
               ScriptState.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();

               try {
                  class52.method763(field1214, "zap");
               } catch (Throwable var9) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(ScriptState.rssocket.available() >= packetLength) {
                  secretPacketBuffer2.offset = 0;
                  ScriptState.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                  Frames.method2876();
                  class23.method157(secretPacketBuffer2);
                  class59.field748 = -1;
                  class45.xteaChanged(false);
                  field976 = -1;
               }

            } else {
               if(loginState == 11 && ScriptState.rssocket.available() >= 2) {
                  secretPacketBuffer2.offset = 0;
                  ScriptState.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                  secretPacketBuffer2.offset = 0;
                  class215.field2638 = secretPacketBuffer2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && ScriptState.rssocket.available() >= class215.field2638) {
                  secretPacketBuffer2.offset = 0;
                  ScriptState.rssocket.read(secretPacketBuffer2.payload, 0, class215.field2638);
                  secretPacketBuffer2.offset = 0;
                  String var14 = secretPacketBuffer2.readString();
                  String var8 = secretPacketBuffer2.readString();
                  String var7 = secretPacketBuffer2.readString();
                  WorldMapType2.method496(var14, var8, var7);
                  class249.setGameState(10);
               }

               if(loginState != 13) {
                  ++field1197;
                  if(field1197 > 2000) {
                     if(field1029 < 1) {
                        if(class13.field279 == RSSocket.field2290) {
                           RSSocket.field2290 = XItemContainer.field790;
                        } else {
                           RSSocket.field2290 = class13.field279;
                        }

                        ++field1029;
                        loginState = 0;
                     } else {
                        class10.method43(-3);
                     }
                  }
               } else {
                  if(packetLength == -1) {
                     if(ScriptState.rssocket.available() < 2) {
                        return;
                     }

                     ScriptState.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                     secretPacketBuffer2.offset = 0;
                     packetLength = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(ScriptState.rssocket.available() >= packetLength) {
                     ScriptState.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                     secretPacketBuffer2.offset = 0;
                     var1 = packetLength;
                     secretPacketBuffer1.offset = 0;
                     secretPacketBuffer2.offset = 0;
                     field976 = -1;
                     field995 = -1;
                     field980 = -1;
                     field1167 = -1;
                     packetLength = 0;
                     field977 = 0;
                     field981 = 0;
                     menuOptionCount = 0;
                     field1090 = -1;
                     isMenuOpen = false;
                     field1170 = 0;
                     flagX = 0;

                     for(var2 = 0; var2 < 2048; ++var2) {
                        cachedPlayers[var2] = null;
                     }

                     World.localPlayer = null;

                     for(var2 = 0; var2 < cachedNPCs.length; ++var2) {
                        NPC var15 = cachedNPCs[var2];
                        if(var15 != null) {
                           var15.interacting = -1;
                           var15.field1269 = false;
                        }
                     }

                     class34.method471();
                     class249.setGameState(30);

                     for(var2 = 0; var2 < 100; ++var2) {
                        field1135[var2] = true;
                     }

                     class51.method757();
                     class23.method157(secretPacketBuffer2);
                     if(secretPacketBuffer2.offset != var1) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var10) {
         if(field1029 < 1) {
            if(RSSocket.field2290 == class13.field279) {
               RSSocket.field2290 = XItemContainer.field790;
            } else {
               RSSocket.field2290 = class13.field279;
            }

            ++field1029;
            loginState = 0;
         } else {
            class10.method43(-2);
         }
      }
   }

   static {
      field1211 = true;
      world = 1;
      flags = 0;
      field931 = 0;
      isMembers = false;
      field1046 = false;
      field1077 = 0;
      gameState = 0;
      field978 = true;
      gameCycle = 0;
      field1122 = -1L;
      field939 = -1;
      field1006 = -1;
      field941 = -1;
      field1042 = true;
      field943 = false;
      field981 = 0;
      field945 = 0;
      field946 = 0;
      field947 = 0;
      field948 = 0;
      field949 = 0;
      field1176 = 0;
      field1127 = 0;
      field952 = 0;
      field953 = class91.field1439;
      field984 = class91.field1439;
      field1184 = 0;
      field1173 = 0;
      field959 = 0;
      field960 = 0;
      loginState = 0;
      field1197 = 0;
      field1029 = 0;
      field964 = 0;
      field966 = null;
      cachedNPCs = new NPC['耀'];
      field968 = 0;
      field950 = new int['耀'];
      field970 = 0;
      field971 = new int[250];
      secretPacketBuffer1 = new PacketBuffer(5000);
      field973 = new PacketBuffer(5000);
      secretPacketBuffer2 = new PacketBuffer(15000);
      packetLength = 0;
      field976 = 0;
      field977 = 0;
      field1109 = 0;
      field995 = 0;
      field980 = 0;
      field1167 = 0;
      field982 = 0;
      field983 = false;
      field934 = new HashMap();
      field1026 = 0;
      field986 = 1;
      field987 = 0;
      field988 = 1;
      field1142 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field992 = new int[4][13][13];
      field1022 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field994 = 0;
      field1048 = 2;
      field996 = 0;
      field1129 = 2;
      field1041 = 0;
      field999 = 1;
      field936 = 0;
      mapScale = 0;
      mapOffset = 2;
      mapScaleDelta = 0;
      field1004 = 1;
      field1039 = 0;
      field1119 = 0;
      field1007 = 2301979;
      field1103 = 5063219;
      field1009 = 3353893;
      field993 = 7759444;
      field1011 = false;
      field1012 = 0;
      field1013 = 128;
      mapAngle = 0;
      field1015 = 0;
      field1016 = 0;
      field1069 = 0;
      field961 = 0;
      field1019 = 50;
      field1020 = 0;
      field1021 = false;
      field1047 = 0;
      field1023 = 0;
      field1182 = 50;
      field1025 = new int[field1182];
      field1095 = new int[field1182];
      field1027 = new int[field1182];
      field998 = new int[field1182];
      field1017 = new int[field1182];
      field1030 = new int[field1182];
      field1024 = new int[field1182];
      field1032 = new String[field1182];
      field1033 = new int[104][104];
      field1034 = 0;
      field1124 = -1;
      field1093 = -1;
      field1175 = 0;
      field1038 = 0;
      field1000 = 0;
      field1186 = 0;
      field932 = 0;
      field1035 = 0;
      field1043 = 0;
      field1044 = 0;
      field1081 = 0;
      field940 = 0;
      field958 = false;
      field1205 = 0;
      field985 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field997 = 0;
      field1053 = 0;
      field1076 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field1058 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field1059 = -1;
      groundItemDeque = new Deque[4][104][104];
      field979 = new Deque();
      projectiles = new Deque();
      field1172 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field1067 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field1156 = false;
      field1090 = -1;
      field1078 = false;
      field1079 = -1;
      field1080 = -1;
      field991 = 0;
      field1082 = 50;
      field1083 = 0;
      field1084 = null;
      field1085 = false;
      field1086 = -1;
      field1174 = -1;
      field1088 = null;
      field1089 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field1092 = 0;
      field1005 = 0;
      field963 = null;
      energy = 0;
      weight = 0;
      field1097 = 0;
      field1193 = -1;
      field1099 = false;
      field1100 = false;
      field1101 = false;
      field1102 = null;
      field1164 = null;
      field1104 = null;
      field1105 = 0;
      field1141 = 0;
      field1107 = null;
      field1108 = false;
      field1063 = -1;
      field1146 = -1;
      field1111 = false;
      field1112 = -1;
      field1113 = -1;
      field1114 = false;
      field1121 = 1;
      field1116 = new int[32];
      field1117 = 0;
      interfaceItemTriggers = new int[32];
      field1137 = 0;
      field1120 = new int[32];
      field1051 = 0;
      field1037 = 0;
      field1066 = 0;
      field1036 = 0;
      field1125 = 0;
      field1126 = 0;
      field1128 = 0;
      field954 = 0;
      field955 = new Deque();
      field1130 = new Deque();
      field1131 = new Deque();
      widgetFlags = new XHashTable(512);
      field1133 = 0;
      field1134 = -2;
      field1135 = new boolean[100];
      field1136 = new boolean[100];
      field1040 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field1161 = 0;
      field1143 = 0L;
      isResized = true;
      field1145 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field1031 = 0;
      field1147 = 0;
      field1148 = "";
      field1149 = new long[100];
      field1150 = 0;
      field1151 = 0;
      field1152 = new int[128];
      field1153 = new int[128];
      field1154 = -1L;
      field1155 = null;
      clanChatOwner = null;
      field1157 = -1;
      field1158 = 0;
      field1075 = new int[1000];
      field1160 = new int[1000];
      field1110 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field1170 = 0;
      field1165 = 255;
      field1166 = -1;
      field1123 = false;
      field1168 = 127;
      field1169 = 127;
      field1061 = 0;
      field1171 = new int[50];
      field1018 = new int[50];
      field1028 = new int[50];
      field956 = new int[50];
      field1008 = new SoundEffect[50];
      field989 = false;
      field1183 = new boolean[5];
      field1178 = new int[5];
      field1179 = new int[5];
      field1180 = new int[5];
      field1181 = new int[5];
      field1045 = 256;
      field975 = 205;
      field1094 = 256;
      field1185 = 320;
      field1159 = 1;
      field1187 = 32767;
      field1188 = 1;
      field1189 = 32767;
      field1190 = 0;
      field1191 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field1196 = 0;
      friends = new Friend[400];
      field1060 = new class195();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1201 = new PlayerComposition();
      field1202 = -1;
      field962 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field1098 = -1L;
      field1206 = -1L;
      field933 = new class73();
      field1208 = new int[50];
      field1209 = new int[50];
   }
}
