import java.io.File;
import java.io.IOException;
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
   @ObfuscatedName("kv")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   static Widget field1022;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = -1461765423
   )
   static int field980;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = 1624988023
   )
   static int field1010;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      longValue = -5956587029050489397L
   )
   static long field1030;
   @ObfuscatedName("mw")
   static boolean[] field1055;
   @ObfuscatedName("mu")
   static boolean[] field896;
   @ObfuscatedName("my")
   static boolean[] field1056;
   @ObfuscatedName("lh")
   static boolean field1068;
   @ObfuscatedName("mt")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("ke")
   static boolean field1027;
   @ObfuscatedName("ot")
   static boolean field1088;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = 1930755889
   )
   static int field1024;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -406890885
   )
   static int field1087;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = 452614525
   )
   static int field1028;
   @ObfuscatedName("me")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("kx")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   static Widget field1023;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = -1049638101
   )
   @Export(
      value = "gameDrawingMode",
      setter = true
   )
   static int gameDrawingMode;
   @ObfuscatedName("mq")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("ma")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = 664448119
   )
   static int field880;
   @ObfuscatedName("mp")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("mm")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("qm")
   @ObfuscatedSignature(
      signature = "Lby;"
   )
   static final class72 field960;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = -1328714603
   )
   static int field1047;
   @ObfuscatedName("pt")
   static boolean[] field1098;
   @ObfuscatedName("pn")
   static int[] field949;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = -1343871717
   )
   static int field1031;
   @ObfuscatedName("pr")
   static int[] field1071;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = -30557483
   )
   static int field1032;
   @ObfuscatedName("pj")
   static int[] field1101;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = 23012827
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = 442503975
   )
   static int field1046;
   @ObfuscatedName("pl")
   static int[] field946;
   @ObfuscatedName("qw")
   static int[] field1129;
   @ObfuscatedName("qh")
   static int[] field1086;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = 353459521
   )
   static int field1026;
   @ObfuscatedName("ob")
   @ObfuscatedGetter(
      intValue = 1149794667
   )
   static int field1089;
   @ObfuscatedName("mf")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   static Deque field1048;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = -431811385
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = -1419620831
   )
   static int field1067;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = 784745959
   )
   static int field1091;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = -2077063189
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("oq")
   static int[] field910;
   @ObfuscatedName("lo")
   static boolean field1063;
   @ObfuscatedName("ol")
   static int[] field1093;
   @ObfuscatedName("lu")
   static int[] field1035;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -1206961721
   )
   static int field1128;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = -678475471
   )
   static int field1085;
   @ObfuscatedName("oy")
   static int[] field1094;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = 199317899
   )
   static int field1078;
   @ObfuscatedName("ok")
   @ObfuscatedSignature(
      signature = "[Ldh;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("om")
   static int[] field1033;
   @ObfuscatedName("op")
   static boolean field1097;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = -1853885037
   )
   static int field1123;
   @ObfuscatedName("qk")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("qq")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   static PlayerComposition field1122;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = -1568670425
   )
   static int field1021;
   @ObfuscatedName("lm")
   static int[] field1039;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = -1325983923
   )
   static int field1124;
   @ObfuscatedName("kq")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   static Widget field1041;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = 753931547
   )
   static int field1042;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 1837953413
   )
   static int field1034;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = -1789532087
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      longValue = -44710383566660021L
   )
   static long field1052;
   @ObfuscatedName("qa")
   @ObfuscatedSignature(
      signature = "[Lbr;"
   )
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = -37383421
   )
   static int field1079;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = 760800653
   )
   static int field1059;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = 18909113
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("qt")
   @ObfuscatedSignature(
      signature = "[Lbg;"
   )
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("lf")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -178173173
   )
   static int field991;
   @ObfuscatedName("nr")
   @ObfuscatedSignature(
      signature = "[Lkd;"
   )
   @Export("mapIcons")
   static SpritePixels[] mapIcons;
   @ObfuscatedName("nw")
   static int[] field1120;
   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   static class202 field1117;
   @ObfuscatedName("nn")
   static int[] field969;
   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      signature = "[Lh;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = -1410957195
   )
   static int field1044;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = 1985419939
   )
   static int field1111;
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = 442244249
   )
   static int field1109;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = 1384465123
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = -642434445
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = 1684227983
   )
   static int field1057;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = -267736655
   )
   static int field905;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = -325613511
   )
   static int field885;
   @ObfuscatedName("ps")
   static short field1104;
   @ObfuscatedName("ph")
   static short field1103;
   @ObfuscatedName("nx")
   static int[] field1073;
   @ObfuscatedName("pq")
   static short field881;
   @ObfuscatedName("pv")
   static short field1108;
   @ObfuscatedName("nz")
   static int[] field1072;
   @ObfuscatedName("nf")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("pi")
   static short field911;
   @ObfuscatedName("pe")
   static short field1106;
   @ObfuscatedName("mv")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   static Deque field1061;
   @ObfuscatedName("pd")
   static short field1105;
   @ObfuscatedName("pb")
   static short field1107;
   @ObfuscatedName("mg")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   static Deque field959;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = -331777813
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = -177609855
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("nq")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("qu")
   @ObfuscatedSignature(
      signature = "Lbh;"
   )
   static class74 field1126;
   @ObfuscatedName("nj")
   static long[] field1069;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = 2085211657
   )
   static int field1045;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 292539277
   )
   static int field1070;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = -1861162485
   )
   static int field1043;
   @ObfuscatedName("nm")
   static String field1014;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = -1899139977
   )
   @Export(
      value = "chatCycle",
      setter = true
   )
   static int chatCycle;
   @ObfuscatedName("mb")
   static int[] field1038;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfa;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("ar")
   static boolean field1080;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1232844837
   )
   @Export("world")
   static int world;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1050063717
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -1535718325
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("bn")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("bt")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -628632097
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1217371865
   )
   @Export("gameState")
   @Hook("gameStateChanged")
   static int gameState;
   @ObfuscatedName("bc")
   static boolean field877;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 682324831
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      longValue = 3435045014420733095L
   )
   static long field879;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -530745557
   )
   static int field1090;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 27779897
   )
   static int field1054;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 330446653
   )
   static int field882;
   @ObfuscatedName("bq")
   static boolean field883;
   @ObfuscatedName("bh")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 102503419
   )
   static int field1095;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 475729969
   )
   @Export("hintArrowTargetType")
   static int hintArrowTargetType;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -813234613
   )
   @Export("hintArrowNpcTargetIdx")
   static int hintArrowNpcTargetIdx;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -346578963
   )
   @Export("hintArrowPlayerTargetIdx")
   static int hintArrowPlayerTargetIdx;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1384709971
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1293895437
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -221838619
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -381502201
   )
   @Export("hintArrowOffsetX")
   static int hintArrowOffsetX;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -1687339489
   )
   @Export("hintArrowOffsetY")
   static int hintArrowOffsetY;
   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "Lco;"
   )
   static class90 field922;
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Lco;"
   )
   static class90 field941;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 90771349
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 938563389
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -1504163641
   )
   static int field898;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = 927924443
   )
   static int field899;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -1291282203
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 146772913
   )
   static int field900;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 322110867
   )
   static int field902;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = 754121685
   )
   static int field903;
   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   static class150 field904;
   @ObfuscatedName("dj")
   static byte[] field1040;
   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "[Lcp;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = -1725609085
   )
   @Export("npcIndexesCount")
   static int npcIndexesCount;
   @ObfuscatedName("dz")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -2117349159
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("ep")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "Lcx;"
   )
   public static final class100 field952;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 1836951703
   )
   static int field912;
   @ObfuscatedName("ej")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   static class283 field970;
   @ObfuscatedName("ef")
   static HashMap field915;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = 1228493219
   )
   static int field1029;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = -1824129671
   )
   static int field917;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -884519817
   )
   static int field918;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -1582654041
   )
   static int field919;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 634550833
   )
   static int field920;
   @ObfuscatedName("fd")
   static boolean field958;
   @ObfuscatedName("fm")
   static int[][][] field884;
   @ObfuscatedName("fh")
   static final int[] field955;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 1769729293
   )
   static int field925;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -1622240231
   )
   static int field914;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = -1291015479
   )
   static int field927;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -1080971287
   )
   static int field928;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -992918069
   )
   static int field929;
   @ObfuscatedName("ge")
   static boolean field1092;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -575196065
   )
   static int field931;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 77863317
   )
   static int field932;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = 1394560877
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 696801897
   )
   static int field934;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 640381213
   )
   static int field1077;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 1090285185
   )
   static int field936;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 1346863601
   )
   static int field1019;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 1485996227
   )
   static int field950;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 1515952647
   )
   static int field939;
   @ObfuscatedName("gu")
   static boolean field983;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -401421419
   )
   static int field1102;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -1212962093
   )
   static int field942;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 321859867
   )
   static int field943;
   @ObfuscatedName("gy")
   static int[] field1130;
   @ObfuscatedName("gg")
   static int[] field945;
   @ObfuscatedName("gw")
   static int[] field944;
   @ObfuscatedName("ha")
   static int[] field947;
   @ObfuscatedName("ho")
   static int[] field948;
   @ObfuscatedName("hb")
   static int[] field1099;
   @ObfuscatedName("hp")
   static int[] field1065;
   @ObfuscatedName("hg")
   static String[] field951;
   @ObfuscatedName("hi")
   static int[][] field1049;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = -1338833353
   )
   static int field953;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = 1607481073
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = -542281915
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 1022633783
   )
   static int field956;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = 2089343697
   )
   static int field957;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = -196802811
   )
   static int field937;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -968655293
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = 1418139011
   )
   static int field1066;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = 193976387
   )
   static int field961;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 461376179
   )
   static int field894;
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = -2054647981
   )
   static int field963;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = 752722373
   )
   static int field964;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = -792343195
   )
   static int field965;
   @ObfuscatedName("he")
   static boolean field966;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -424206471
   )
   static int field967;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 983873571
   )
   static int field968;
   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "[Lbq;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = 331117243
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = -451396957
   )
   static int field971;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = 689480409
   )
   static int field972;
   @ObfuscatedName("ii")
   static int[] field973;
   @ObfuscatedName("ik")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("ih")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("iy")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("ic")
   static int[] field977;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = 1617446531
   )
   static int field978;
   @ObfuscatedName("it")
   static String field1118;
   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "[[[Lgj;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("iw")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("ir")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("il")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 2121989825
   )
   static int field986;
   @ObfuscatedName("iq")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = -982472671
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("jc")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("jy")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("jf")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("jd")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("jp")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("jt")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("jg")
   static boolean[] field995;
   @ObfuscatedName("ji")
   static boolean field996;
   @ObfuscatedName("jm")
   static boolean field997;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = 1576354453
   )
   static int field998;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = 1450517489
   )
   static int field999;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = 1170941411
   )
   static int field1000;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -1754626811
   )
   static int field1001;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = 75057111
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("jq")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 165171665
   )
   static int field1005;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 1801304223
   )
   static int field1006;
   @ObfuscatedName("kc")
   static String field1007;
   @ObfuscatedName("ky")
   static String field1008;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -1563787695
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 1066119967
   )
   static int field1011;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 1302176613
   )
   static int field1119;
   @ObfuscatedName("ku")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   static Widget field1013;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 2121080715
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 911960287
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 2068095219
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = 1994839209
   )
   static int field878;
   @ObfuscatedName("kh")
   static boolean field1018;
   @ObfuscatedName("kt")
   static boolean field1081;
   @ObfuscatedName("ka")
   static boolean field869;
   @ObfuscatedName("kj")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   static Widget field923;

   static {
      field1080 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field877 = true;
      gameCycle = 0;
      field879 = -1L;
      field1090 = -1;
      field1054 = -1;
      field882 = -1;
      field883 = true;
      displayFps = false;
      field1095 = 0;
      hintArrowTargetType = 0;
      hintArrowNpcTargetIdx = 0;
      hintArrowPlayerTargetIdx = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowType = 0;
      hintArrowOffsetX = 0;
      hintArrowOffsetY = 0;
      field922 = class90.field1327;
      field941 = class90.field1327;
      loadingStage = 0;
      js5State = 0;
      field898 = 0;
      field899 = 0;
      loginState = 0;
      field900 = 0;
      field902 = 0;
      field903 = 0;
      field904 = class150.field2116;
      field1040 = null;
      cachedNPCs = new NPC['耀'];
      npcIndexesCount = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      field952 = new class100();
      field912 = 0;
      socketError = false;
      field970 = new class283();
      field915 = new HashMap();
      field1029 = 0;
      field917 = 1;
      field918 = 0;
      field919 = 1;
      field920 = 0;
      collisionMaps = new CollisionData[4];
      field958 = false;
      field884 = new int[4][13][13];
      field955 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field925 = 0;
      field914 = 2301979;
      field927 = 5063219;
      field928 = 3353893;
      field929 = 7759444;
      field1092 = false;
      field931 = 0;
      field932 = 128;
      mapAngle = 0;
      field934 = 0;
      field1077 = 0;
      field936 = 0;
      field1019 = 0;
      field950 = 50;
      field939 = 0;
      field983 = false;
      field1102 = 0;
      field942 = 0;
      field943 = 50;
      field1130 = new int[field943];
      field945 = new int[field943];
      field944 = new int[field943];
      field947 = new int[field943];
      field948 = new int[field943];
      field1099 = new int[field943];
      field1065 = new int[field943];
      field951 = new String[field943];
      field1049 = new int[104][104];
      field953 = 0;
      screenY = -1;
      screenX = -1;
      field956 = 0;
      field957 = 0;
      field937 = 0;
      cursorState = 0;
      field1066 = 0;
      field961 = 0;
      field894 = 0;
      field963 = 0;
      field964 = 0;
      field965 = 0;
      field966 = false;
      field967 = 0;
      field968 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field971 = 0;
      field972 = 0;
      field973 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field977 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field978 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field986 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field995 = new boolean[500];
      field996 = false;
      field997 = false;
      field998 = -1;
      field999 = -1;
      field1000 = 0;
      field1001 = 50;
      itemSelectionState = 0;
      field1118 = null;
      spellSelected = false;
      field1005 = -1;
      field1006 = -1;
      field1007 = null;
      field1008 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field1011 = 0;
      field1119 = 0;
      field1013 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field878 = -1;
      field1018 = false;
      field1081 = false;
      field869 = false;
      field923 = null;
      field1022 = null;
      field1023 = null;
      field1024 = 0;
      field1087 = 0;
      field1041 = null;
      field1027 = false;
      field1028 = -1;
      field880 = -1;
      field1068 = false;
      field1031 = -1;
      field1032 = -1;
      field1063 = false;
      cycleCntr = 1;
      field1035 = new int[32];
      field1128 = 0;
      interfaceItemTriggers = new int[32];
      field991 = 0;
      field1039 = new int[32];
      field1034 = 0;
      chatCycle = 0;
      field1042 = 0;
      field1043 = 0;
      field1044 = 0;
      field1045 = 0;
      field1046 = 0;
      field1047 = 0;
      field1048 = new Deque();
      field1061 = new Deque();
      field959 = new Deque();
      widgetFlags = new HashTable(512);
      field980 = 0;
      field1010 = -2;
      field1055 = new boolean[100];
      field1056 = new boolean[100];
      field896 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1030 = 0L;
      isResized = true;
      field1038 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      field1057 = 0;
      field905 = 0;
      field1014 = "";
      field1069 = new long[100];
      field1070 = 0;
      field885 = 0;
      field1072 = new int[128];
      field1073 = new int[128];
      field1052 = -1L;
      clanChatOwner = null;
      clanChatName = null;
      field1078 = -1;
      field1079 = 0;
      field1120 = new int[1000];
      field969 = new int[1000];
      mapIcons = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1085 = 0;
      field1059 = 255;
      field1026 = -1;
      field1088 = false;
      field1089 = 127;
      field1067 = 127;
      field1091 = 0;
      field910 = new int[50];
      field1093 = new int[50];
      field1094 = new int[50];
      field1033 = new int[50];
      audioEffects = new SoundEffect[50];
      field1097 = false;
      field1098 = new boolean[5];
      field949 = new int[5];
      field1071 = new int[5];
      field1101 = new int[5];
      field946 = new int[5];
      field1103 = 256;
      field1104 = 205;
      field1105 = 256;
      field1106 = 320;
      field1107 = 1;
      field911 = 32767;
      field881 = 1;
      field1108 = 32767;
      field1111 = 0;
      field1109 = 0;
      viewportHeight = 0;
      viewportWidth = 0;
      scale = 0;
      friendCount = 0;
      field1021 = 0;
      friends = new Friend[400];
      field1117 = new class202();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1122 = new PlayerComposition();
      field1123 = -1;
      field1124 = -1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field1126 = new class74();
      field960 = new class72();
      field1129 = new int[50];
      field1086 = new int[50];
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1245071170"
   )
   protected final void vmethod1241() {
      field1030 = class268.currentTimeMs() + 500L;
      this.method1237();
      if(widgetRoot != -1) {
         this.method1248(true);
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2041847822"
   )
   protected final void vmethod1566() {
      GameObject.method3003(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
      DynamicObject.field1456 = socketType == 0?43594:world + 40000;
      MessageNode.field815 = socketType == 0?443:world + 50000;
      class9.myWorldPort = DynamicObject.field1456;
      PlayerComposition.colorsToFind = class221.field2707;
      PlayerComposition.colorsToReplace = class221.field2709;
      class11.field266 = class221.field2710;
      class279.field3739 = class221.field2708;
      BuildType.field3253 = new class148();
      this.method984();
      this.method914();
      class56.field649 = this.method910();
      MilliTimer.field2125 = new IndexFile(255, class156.field2162, class156.field2159, 500000);
      Buffer.preferences = class14.method85();
      this.method911();
      String var2 = BaseVarType.field27;
      class56.field653 = this;
      class56.field642 = var2;
      if(socketType != 0) {
         displayFps = true;
      }

      class23.method191(Buffer.preferences.screenType);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-140607315"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();

      while(true) {
         Deque var2 = class243.field3297;
         FileSystem var1;
         synchronized(class243.field3297) {
            var1 = (FileSystem)class243.field3295.popFront();
         }

         if(var1 == null) {
            class37.method553();
            class90.method1801();
            class46.method758();
            MouseInput var8 = MouseInput.mouse;
            synchronized(MouseInput.mouse) {
               MouseInput.field706 = MouseInput.field717;
               MouseInput.field704 = MouseInput.mouseX;
               MouseInput.field708 = MouseInput.mouseY;
               MouseInput.field713 = MouseInput.field709;
               MouseInput.field714 = MouseInput.field710;
               MouseInput.field715 = MouseInput.field711;
               MouseInput.field701 = MouseInput.field712;
               MouseInput.field709 = 0;
            }

            int var5;
            if(class56.field649 != null) {
               var5 = class56.field649.vmethod3080();
               field1047 = var5;
            }

            if(gameState == 0) {
               class100.load();
               GameEngine.timer.vmethod3096();

               for(var5 = 0; var5 < 32; ++var5) {
                  GameEngine.field669[var5] = 0L;
               }

               for(var5 = 0; var5 < 32; ++var5) {
                  GameEngine.field671[var5] = 0L;
               }

               class9.field249 = 0;
            } else if(gameState == 5) {
               Frames.method2979(this);
               class100.load();
               GameEngine.timer.vmethod3096();

               for(var5 = 0; var5 < 32; ++var5) {
                  GameEngine.field669[var5] = 0L;
               }

               for(var5 = 0; var5 < 32; ++var5) {
                  GameEngine.field671[var5] = 0L;
               }

               class9.field249 = 0;
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  Frames.method2979(this);
                  this.method1239();
               } else if(gameState == 25) {
                  DynamicObject.method1935();
               }
            } else {
               Frames.method2979(this);
            }

            if(gameState == 30) {
               this.method1240();
            } else if(gameState == 40 || gameState == 45) {
               this.method1239();
            }

            return;
         }

         var1.data.method4389(var1.index, (int)var1.hash, var1.field3265, false);
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "280842206"
   )
   @Hook("clientMainLoop")
   protected final void vmethod1234(boolean var1) {
      boolean var2;
      label175: {
         try {
            if(class210.field2594 == 2) {
               if(class210.field2601 == null) {
                  class210.field2601 = Track1.getMusicFile(class184.field2516, class210.field2598, class210.field2599);
                  if(class210.field2601 == null) {
                     var2 = false;
                     break label175;
                  }
               }

               if(class43.field539 == null) {
                  class43.field539 = new class111(class210.field2597, class289.field3810);
               }

               if(class210.field2596.method3856(class210.field2601, class210.field2600, class43.field539, 22050)) {
                  class210.field2596.method3857();
                  class210.field2596.method3854(class37.field485);
                  class210.field2596.method3860(class210.field2601, class210.field2595);
                  class210.field2594 = 0;
                  class210.field2601 = null;
                  class43.field539 = null;
                  class184.field2516 = null;
                  var2 = true;
                  break label175;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class210.field2596.method3969();
            class210.field2594 = 0;
            class210.field2601 = null;
            class43.field539 = null;
            class184.field2516 = null;
         }

         var2 = false;
      }

      if(var2 && field1088 && class3.soundSystem0 != null) {
         class3.soundSystem0.method2108();
      }

      int var4;
      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field1030 && class268.currentTimeMs() > field1030) {
         var4 = isResized?2:1;
         class23.method191(var4);
      }

      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1055[var4] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class91.loadingBarPercentage, class91.loadingText, var1);
      } else if(gameState == 5) {
         FileOnDisk.drawLoginScreen(class20.field320, class47.field580, class48.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            FileOnDisk.drawLoginScreen(class20.field320, class47.field580, class48.font_p12full, var1);
         } else if(gameState == 25) {
            if(field920 == 1) {
               if(field1029 > field917) {
                  field917 = field1029;
               }

               var4 = (field917 * 50 - field1029 * 50) / field917;
               class66.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field920 == 2) {
               if(field918 > field919) {
                  field919 = field918;
               }

               var4 = (field919 * 50 - field918 * 50) / field919 + 50;
               class66.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class66.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1243();
         } else if(gameState == 40) {
            class66.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class66.drawStatusBox("Please wait...", false);
         }
      } else {
         FileOnDisk.drawLoginScreen(class20.field320, class47.field580, class48.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var4 = 0; var4 < field980; ++var4) {
            if(field1056[var4]) {
               class66.field779.vmethod5233(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field1056[var4] = false;
            }
         }
      } else if(gameState > 0) {
         class66.field779.vmethod5235(0, 0);

         for(var4 = 0; var4 < field980; ++var4) {
            field1056[var4] = false;
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   protected final void vmethod1235() {
      if(class1.chatMessages.changed()) {
         class1.chatMessages.serialize();
      }

      if(class5.field31 != null) {
         class5.field31.field803 = false;
      }

      class5.field31 = null;
      field952.method1970();
      class170.method3194();
      if(MouseInput.mouse != null) {
         MouseInput var1 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

      class56.field649 = null;
      if(class3.soundSystem0 != null) {
         class3.soundSystem0.method2112();
      }

      if(class13.soundSystem1 != null) {
         class13.soundSystem1.method2112();
      }

      class82.method1724();
      Object var9 = class243.field3300;
      synchronized(class243.field3300) {
         if(class243.field3296 != 0) {
            class243.field3296 = 1;

            try {
               class243.field3300.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      if(BuildType.field3253 != null) {
         BuildType.field3253.method3011();
         BuildType.field3253 = null;
      }

      try {
         class156.field2162.method2452();

         for(int var4 = 0; var4 < class156.field2158; ++var4) {
            class156.field2156[var4].method2452();
         }

         class156.field2159.method2452();
         class156.field2160.method2452();
      } catch (Exception var7) {
         ;
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1435498460"
   )
   protected final void vmethod1230() {
   }

   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = new Parameters[]{Parameters.field3771, Parameters.field3763, Parameters.field3760, Parameters.field3768, Parameters.field3761, Parameters.field3765, Parameters.field3759, Parameters.field3770, Parameters.field3769, Parameters.field3772, Parameters.field3762, Parameters.field3767, Parameters.field3764, Parameters.field3766, Parameters.field3758};
         Parameters[] var2 = var1;

         int var3;
         for(var3 = 0; var3 < var2.length; ++var3) {
            Parameters var4 = var2[var3];
            String var5 = this.getParameter(var4.key);
            if(var5 != null) {
               switch(Integer.parseInt(var4.key)) {
               case 1:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 2:
                  socketType = Integer.parseInt(var5);
                  break;
               case 3:
                  class36.field480 = Integer.parseInt(var5);
                  break;
               case 4:
                  class72.field824 = var5;
               case 5:
               case 13:
               case 14:
               default:
                  break;
               case 6:
                  class41.field528 = (class239)class47.forOrdinal(class111.method2182(), Integer.parseInt(var5));
                  if(class239.field3260 == class41.field528) {
                     class60.field718 = class298.field3910;
                  } else {
                     class60.field718 = class298.field3918;
                  }
                  break;
               case 7:
                  class40.sessionToken = var5;
                  break;
               case 8:
                  languageId = Integer.parseInt(var5);
                  break;
               case 9:
                  flags = Integer.parseInt(var5);
                  break;
               case 10:
                  class175.field2443 = Integer.parseInt(var5);
                  break;
               case 11:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 12:
                  world = Integer.parseInt(var5);
                  break;
               case 15:
                  GameEngine.field689 = class221.method4144(Integer.parseInt(var5));
               }
            }
         }

         class72.method1185();
         MilliTimer.host = this.getCodeBase().getHost();
         String var15 = GameEngine.field689.identifier;
         byte var8 = 0;

         try {
            class156.field2158 = 17;
            VarPlayerType.field3342 = var8;

            try {
               class268.osName = System.getProperty("os.name");
            } catch (Exception var13) {
               class268.osName = "Unknown";
            }

            class87.osNameLC = class268.osName.toLowerCase();

            try {
               class115.userHome = System.getProperty("user.home");
               if(class115.userHome != null) {
                  class115.userHome = class115.userHome + "/";
               }
            } catch (Exception var12) {
               ;
            }

            try {
               if(class87.osNameLC.startsWith("win")) {
                  if(class115.userHome == null) {
                     class115.userHome = System.getenv("USERPROFILE");
                  }
               } else if(class115.userHome == null) {
                  class115.userHome = System.getenv("HOME");
               }

               if(class115.userHome != null) {
                  class115.userHome = class115.userHome + "/";
               }
            } catch (Exception var11) {
               ;
            }

            if(class115.userHome == null) {
               class115.userHome = "~/";
            }

            class44.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class115.userHome, "/tmp/", ""};
            class156.field2164 = new String[]{".jagex_cache_" + VarPlayerType.field3342, ".file_store_" + VarPlayerType.field3342};

            label118:
            for(var3 = 0; var3 < 4; ++var3) {
               class20.field328 = class86.method1785("oldschool", var15, var3);
               if(!class20.field328.exists()) {
                  class20.field328.mkdirs();
               }

               File[] var16 = class20.field328.listFiles();
               if(var16 == null) {
                  break;
               }

               File[] var17 = var16;
               int var6 = 0;

               while(true) {
                  if(var6 >= var17.length) {
                     break label118;
                  }

                  File var7 = var17[var6];
                  if(!WorldMapType3.method231(var7, false)) {
                     break;
                  }

                  ++var6;
               }
            }

            File var9 = class20.field328;
            class158.field2167 = var9;
            if(!class158.field2167.exists()) {
               throw new RuntimeException("");
            }

            class158.field2169 = true;
            class44.method679();
            class156.field2162 = new CacheFile(new FileOnDisk(class224.method4202("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class156.field2159 = new CacheFile(new FileOnDisk(class224.method4202("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class156.field2156 = new CacheFile[class156.field2158];

            for(int var10 = 0; var10 < class156.field2158; ++var10) {
               class156.field2156[var10] = new CacheFile(new FileOnDisk(class224.method4202("main_file_cache.idx" + var10), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var14) {
            class33.method396((String)null, var14);
         }

         class9.clientInstance = this;
         this.initialize(765, 503, 157);
      }
   }

   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1597539116"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         boolean var1 = class1.method2();
         if(!var1) {
            this.method1304();
         }

      }
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2031474832"
   )
   void method1304() {
      if(class245.field3330 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class245.field3331 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field898 = 3000;
            class245.field3331 = 3;
         }

         if(--field898 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  class43.socket = GameEngine.taskManager.createSocket(MilliTimer.host, class9.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(class43.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(class43.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  class221.rssocket = new RSSocket((Socket)class43.socket.value, GameEngine.taskManager, 5000);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(157);
                  class221.rssocket.queueForWrite(var1.payload, 0, 5);
                  ++js5State;
                  class15.field295 = class268.currentTimeMs();
               }

               if(js5State == 3) {
                  if(gameState > 5 && class221.rssocket.available() <= 0) {
                     if(class268.currentTimeMs() - class15.field295 > 30000L) {
                        this.error(-2);
                        return;
                     }
                  } else {
                     int var5 = class221.rssocket.readByte();
                     if(var5 != 0) {
                        this.error(var5);
                        return;
                     }

                     ++js5State;
                  }
               }

               if(js5State == 4) {
                  RSSocket var10 = class221.rssocket;
                  boolean var2 = gameState > 20;
                  if(class245.field3316 != null) {
                     try {
                        class245.field3316.close();
                     } catch (Exception var8) {
                        ;
                     }

                     class245.field3316 = null;
                  }

                  class245.field3316 = var10;
                  class29.sendConInfo(var2);
                  class245.field3325.offset = 0;
                  class149.currentRequest = null;
                  DecorativeObject.field2078 = null;
                  class245.field3317 = 0;

                  while(true) {
                     FileRequest var3 = (FileRequest)class245.field3318.method3721();
                     if(var3 == null) {
                        while(true) {
                           var3 = (FileRequest)class245.field3313.method3721();
                           if(var3 == null) {
                              if(class245.field3329 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.putByte(4);
                                    var11.putByte(class245.field3329);
                                    var11.putShort(0);
                                    class245.field3316.queueForWrite(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class245.field3316.close();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class245.field3331;
                                    class245.field3316 = null;
                                 }
                              }

                              class245.field3314 = 0;
                              class245.field3315 = class268.currentTimeMs();
                              class43.socket = null;
                              class221.rssocket = null;
                              js5State = 0;
                              field899 = 0;
                              return;
                           }

                           class245.field3326.setHead(var3);
                           class245.field3321.put(var3, var3.hash);
                           ++class245.field3327;
                           --class245.field3324;
                        }
                     }

                     class245.field3322.put(var3, var3.hash);
                     ++class245.field3320;
                     --class245.field3323;
                  }
               }
            } catch (IOException var9) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   @Export("error")
   void error(int var1) {
      class43.socket = null;
      class221.rssocket = null;
      js5State = 0;
      if(DynamicObject.field1456 == class9.myWorldPort) {
         class9.myWorldPort = MessageNode.field815;
      } else {
         class9.myWorldPort = DynamicObject.field1456;
      }

      ++field899;
      if(field899 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field898 = 3000;
         }
      } else if(field899 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field899 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field898 = 3000;
         }
      }

   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1410735711"
   )
   final void method1239() {
      RSSocket var1 = field952.method1954();
      PacketBuffer var2 = field952.field1469;

      try {
         if(loginState == 0) {
            if(var1 != null) {
               var1.close();
               var1 = null;
            }

            BaseVarType.field28 = null;
            socketError = false;
            field900 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(BaseVarType.field28 == null) {
               BaseVarType.field28 = GameEngine.taskManager.createSocket(MilliTimer.host, class9.myWorldPort);
            }

            if(BaseVarType.field28.status == 2) {
               throw new IOException();
            }

            if(BaseVarType.field28.status == 1) {
               field952.method1952(new RSSocket((Socket)BaseVarType.field28.value, GameEngine.taskManager, 5000));
               var1 = field952.method1954();
               BaseVarType.field28 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            field952.method1949();
            class170 var4 = class11.method60();
            var4.field2424 = null;
            var4.field2427 = 0;
            var4.field2423 = new PacketBuffer(5000);
            var4.field2423.putByte(class168.field2407.field2408);
            field952.method1951(var4);
            field952.method1958();
            var2.offset = 0;
            loginState = 3;
         }

         int var11;
         if(loginState == 3) {
            if(class3.soundSystem0 != null) {
               class3.soundSystem0.method2116();
            }

            if(class13.soundSystem1 != null) {
               class13.soundSystem1.method2116();
            }

            var11 = var1.readByte();
            if(class3.soundSystem0 != null) {
               class3.soundSystem0.method2116();
            }

            if(class13.soundSystem1 != null) {
               class13.soundSystem1.method2116();
            }

            if(var11 != 0) {
               WorldMapType1.method293(var11);
               return;
            }

            var2.offset = 0;
            loginState = 4;
         }

         if(loginState == 4) {
            if(var2.offset < 8) {
               var11 = var1.available();
               if(var11 > 8 - var2.offset) {
                  var11 = 8 - var2.offset;
               }

               if(var11 > 0) {
                  var1.read(var2.payload, var2.offset, var11);
                  var2.offset += var11;
               }
            }

            if(var2.offset == 8) {
               var2.offset = 0;
               ScriptState.field744 = var2.readLong();
               loginState = 5;
            }
         }

         if(loginState == 5) {
            field952.field1469.offset = 0;
            field952.method1949();
            PacketBuffer var3 = new PacketBuffer(500);
            int[] var20 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(ScriptState.field744 >> 32), (int)(ScriptState.field744 & -1L)};
            var3.offset = 0;
            var3.putByte(1);
            var3.putByte(field904.rsOrdinal());
            var3.putInt(var20[0]);
            var3.putInt(var20[1]);
            var3.putInt(var20[2]);
            var3.putInt(var20[3]);
            switch(field904.field2118) {
            case 0:
            case 3:
               var3.put24bitInt(class96.field1429);
               var3.offset += 5;
               break;
            case 1:
               var3.putInt(((Integer)Buffer.preferences.preferences.get(Integer.valueOf(class215.method4071(class91.username)))).intValue());
               var3.offset += 4;
               break;
            case 2:
               var3.offset += 8;
            }

            var3.putString(class91.password);
            var3.encryptRsa(class89.field1321, class89.field1322);
            class170 var6 = class11.method60();
            var6.field2424 = null;
            var6.field2427 = 0;
            var6.field2423 = new PacketBuffer(5000);
            var6.field2423.offset = 0;
            if(gameState == 40) {
               var6.field2423.putByte(class168.field2404.field2408);
            } else {
               var6.field2423.putByte(class168.field2406.field2408);
            }

            var6.field2423.putShort(0);
            int var7 = var6.field2423.offset;
            var6.field2423.putInt(157);
            var6.field2423.putBytes(var3.payload, 0, var3.offset);
            int var8 = var6.field2423.offset;
            var6.field2423.putString(class91.username);
            var6.field2423.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            var6.field2423.putShort(Tile.canvasWidth);
            var6.field2423.putShort(class89.canvasHeight);
            class214.method4045(var6.field2423);
            var6.field2423.putString(class40.sessionToken);
            var6.field2423.putInt(class36.field480);
            Buffer var9 = new Buffer(CombatInfo1.field1203.method5603());
            CombatInfo1.field1203.method5602(var9);
            var6.field2423.putBytes(var9.payload, 0, var9.payload.length);
            var6.field2423.putByte(class175.field2443);
            var6.field2423.putInt(0);
            var6.field2423.putInt(Varcs.indexInterfaces.crc);
            var6.field2423.putInt(class31.indexSoundEffects.crc);
            var6.field2423.putInt(GrandExchangeOffer.configsIndex.crc);
            var6.field2423.putInt(class149.field2115.crc);
            var6.field2423.putInt(Tile.field1838.crc);
            var6.field2423.putInt(class56.indexMaps.crc);
            var6.field2423.putInt(class21.indexTrack1.crc);
            var6.field2423.putInt(class48.indexModels.crc);
            var6.field2423.putInt(class96.indexSprites.crc);
            var6.field2423.putInt(class12.indexTextures.crc);
            var6.field2423.putInt(AbstractSoundSystem.field1563.crc);
            var6.field2423.putInt(class236.indexTrack2.crc);
            var6.field2423.putInt(class43.indexScripts.crc);
            var6.field2423.putInt(class27.field382.crc);
            var6.field2423.putInt(WorldMapType2.vorbisIndex.crc);
            var6.field2423.putInt(class177.field2452.crc);
            var6.field2423.putInt(RSCanvas.indexWorldMap.crc);
            var6.field2423.encryptXtea(var20, var8, var6.field2423.offset);
            var6.field2423.method3410(var6.field2423.offset - var7);
            field952.method1951(var6);
            field952.method1958();
            field952.field1478 = new ISAACCipher(var20);

            for(int var10 = 0; var10 < 4; ++var10) {
               var20[var10] += 50;
            }

            var2.seed(var20);
            loginState = 6;
         }

         if(loginState == 6 && var1.available() > 0) {
            var11 = var1.readByte();
            if(var11 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var11 == 2) {
               loginState = 9;
            } else if(var11 == 15 && gameState == 40) {
               field952.field1471 = -1;
               loginState = 13;
            } else if(var11 == 23 && field902 < 1) {
               ++field902;
               loginState = 0;
            } else {
               if(var11 != 29) {
                  WorldMapType1.method293(var11);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && var1.available() > 0) {
            field903 = (var1.readByte() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field900 = 0;
            class8.method43("You have only just left another world.", "Your profile will be transferred in:", field903 / 60 + " seconds.");
            if(--field903 <= 0) {
               loginState = 0;
            }

         } else {
            boolean var12;
            int var13;
            int var26;
            if(loginState == 9 && var1.available() >= 13) {
               boolean var27 = var1.readByte() == 1;
               var1.read(var2.payload, 0, 4);
               var2.offset = 0;
               var12 = false;
               if(var27) {
                  var26 = var2.readOpcode() << 24;
                  var26 |= var2.readOpcode() << 16;
                  var26 |= var2.readOpcode() << 8;
                  var26 |= var2.readOpcode();
                  var13 = class215.method4071(class91.username);
                  if(Buffer.preferences.preferences.size() >= 10 && !Buffer.preferences.preferences.containsKey(Integer.valueOf(var13))) {
                     Iterator var25 = Buffer.preferences.preferences.entrySet().iterator();
                     var25.next();
                     var25.remove();
                  }

                  Buffer.preferences.preferences.put(Integer.valueOf(var13), Integer.valueOf(var26));
               }

               if(class91.field1357) {
                  Buffer.preferences.field1231 = class91.username;
               } else {
                  Buffer.preferences.field1231 = null;
               }

               class169.method3187();
               rights = var1.readByte();
               field1018 = var1.readByte() == 1;
               localInteractingIndex = var1.readByte();
               localInteractingIndex <<= 8;
               localInteractingIndex += var1.readByte();
               field971 = var1.readByte();
               var1.read(var2.payload, 0, 1);
               var2.offset = 0;
               class166[] var5 = DecorativeObject.method3001();
               int var14 = var2.method3564();
               if(var14 < 0 || var14 >= var5.length) {
                  throw new IOException(var14 + " " + var2.offset);
               }

               field952.field1470 = var5[var14];
               field952.field1471 = field952.field1470.field2304;
               var1.read(var2.payload, 0, 2);
               var2.offset = 0;
               field952.field1471 = var2.readUnsignedShort();

               try {
                  class52.method847(class9.clientInstance, "zap");
               } catch (Throwable var16) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(var1.available() >= field952.field1471) {
                  var2.offset = 0;
                  var1.read(var2.payload, 0, field952.field1471);
                  field970.method5098();
                  field879 = -1L;
                  field882 = -1;
                  class5.field31.field811 = 0;
                  class35.field474 = true;
                  field883 = true;
                  field1052 = -1L;
                  class256.method4598();
                  field952.method1949();
                  field952.field1469.offset = 0;
                  field952.field1470 = null;
                  field952.field1464 = null;
                  field952.field1476 = null;
                  field952.field1477 = null;
                  field952.field1471 = 0;
                  field952.field1475 = 0;
                  field1095 = 0;
                  field912 = 0;
                  hintArrowTargetType = 0;
                  class34.method495();
                  MouseInput.mouseIdleTicks = 0;
                  class96.chatLineMap.clear();
                  class96.field1433.clear();
                  class96.field1427.method3832();
                  class96.field1428 = 0;
                  itemSelectionState = 0;
                  spellSelected = false;
                  field1091 = 0;
                  mapAngle = 0;
                  field1085 = 0;
                  field1078 = -1;
                  destinationX = 0;
                  destinationY = 0;
                  field922 = class90.field1327;
                  field941 = class90.field1327;
                  npcIndexesCount = 0;
                  class94.playerIndexesCount = 0;

                  for(var11 = 0; var11 < 2048; ++var11) {
                     class94.field1404[var11] = null;
                     class94.field1411[var11] = 1;
                  }

                  for(var11 = 0; var11 < 2048; ++var11) {
                     cachedPlayers[var11] = null;
                  }

                  for(var11 = 0; var11 < 32768; ++var11) {
                     cachedNPCs[var11] = null;
                  }

                  field978 = -1;
                  projectiles.clear();
                  graphicsObjectDeque.clear();

                  for(var11 = 0; var11 < 4; ++var11) {
                     for(var26 = 0; var26 < 104; ++var26) {
                        for(var13 = 0; var13 < 104; ++var13) {
                           groundItemDeque[var11][var26][var13] = null;
                        }
                     }
                  }

                  pendingSpawns = new Deque();
                  field1021 = 0;
                  friendCount = 0;
                  ignoreCount = 0;

                  for(var11 = 0; var11 < VarPlayerType.field3344; ++var11) {
                     VarPlayerType var22 = ClanMember.method1228(var11);
                     if(var22 != null) {
                        class218.settings[var11] = 0;
                        class218.widgetSettings[var11] = 0;
                     }
                  }

                  class1.chatMessages.reset();
                  field878 = -1;
                  if(widgetRoot != -1) {
                     var11 = widgetRoot;
                     if(var11 != -1 && class8.validInterfaces[var11]) {
                        class46.widgetIndex.method4292(var11);
                        if(class243.widgets[var11] != null) {
                           var12 = true;

                           for(var13 = 0; var13 < class243.widgets[var11].length; ++var13) {
                              if(class243.widgets[var11][var13] != null) {
                                 if(class243.widgets[var11][var13].type != 2) {
                                    class243.widgets[var11][var13] = null;
                                 } else {
                                    var12 = false;
                                 }
                              }
                           }

                           if(var12) {
                              class243.widgets[var11] = null;
                           }

                           class8.validInterfaces[var11] = false;
                        }
                     }
                  }

                  for(WidgetNode var19 = (WidgetNode)componentTable.method3721(); var19 != null; var19 = (WidgetNode)componentTable.method3728()) {
                     Frames.method2984(var19, true);
                  }

                  widgetRoot = -1;
                  componentTable = new HashTable(8);
                  field1013 = null;
                  class34.method495();
                  field1122.method4110((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var11 = 0; var11 < 8; ++var11) {
                     playerOptions[var11] = null;
                     playerOptionsPriorities[var11] = false;
                  }

                  class54.method861();
                  field877 = true;

                  for(var11 = 0; var11 < 100; ++var11) {
                     field1055[var11] = true;
                  }

                  ScriptVarType.method24();
                  clanChatOwner = null;
                  clanChatCount = 0;
                  DynamicObject.clanMembers = null;

                  for(var11 = 0; var11 < 8; ++var11) {
                     grandExchangeOffers[var11] = new GrandExchangeOffer();
                  }

                  class175.field2446 = null;
                  class229.initializeGPI(var2);
                  class231.field2918 = -1;
                  WallObject.method2975(false, var2);
                  field952.field1470 = null;
               }

            } else {
               if(loginState == 11 && var1.available() >= 2) {
                  var2.offset = 0;
                  var1.read(var2.payload, 0, 2);
                  var2.offset = 0;
                  class48.field595 = var2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && var1.available() >= class48.field595) {
                  var2.offset = 0;
                  var1.read(var2.payload, 0, class48.field595);
                  var2.offset = 0;
                  String var18 = var2.readString();
                  String var21 = var2.readString();
                  String var23 = var2.readString();
                  class8.method43(var18, var21, var23);
                  class287.setGameState(10);
               }

               if(loginState != 13) {
                  ++field900;
                  if(field900 > 2000) {
                     if(field902 < 1) {
                        if(class9.myWorldPort == DynamicObject.field1456) {
                           class9.myWorldPort = MessageNode.field815;
                        } else {
                           class9.myWorldPort = DynamicObject.field1456;
                        }

                        ++field902;
                        loginState = 0;
                     } else {
                        WorldMapType1.method293(-3);
                     }
                  }
               } else {
                  if(field952.field1471 == -1) {
                     if(var1.available() < 2) {
                        return;
                     }

                     var1.read(var2.payload, 0, 2);
                     var2.offset = 0;
                     field952.field1471 = var2.readUnsignedShort();
                  }

                  if(var1.available() >= field952.field1471) {
                     var1.read(var2.payload, 0, field952.field1471);
                     var2.offset = 0;
                     var11 = field952.field1471;
                     field970.method5118();
                     field952.method1949();
                     field952.field1469.offset = 0;
                     field952.field1470 = null;
                     field952.field1464 = null;
                     field952.field1476 = null;
                     field952.field1477 = null;
                     field952.field1471 = 0;
                     field952.field1475 = 0;
                     field1095 = 0;
                     class34.method495();
                     field1085 = 0;
                     destinationX = 0;

                     for(var26 = 0; var26 < 2048; ++var26) {
                        cachedPlayers[var26] = null;
                     }

                     class48.localPlayer = null;

                     for(var26 = 0; var26 < cachedNPCs.length; ++var26) {
                        NPC var24 = cachedNPCs[var26];
                        if(var24 != null) {
                           var24.interacting = -1;
                           var24.field1170 = false;
                        }
                     }

                     class54.method861();
                     class287.setGameState(30);

                     for(var26 = 0; var26 < 100; ++var26) {
                        field1055[var26] = true;
                     }

                     ScriptVarType.method24();
                     class229.initializeGPI(var2);
                     if(var11 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var17) {
         if(field902 < 1) {
            if(class9.myWorldPort == DynamicObject.field1456) {
               class9.myWorldPort = MessageNode.field815;
            } else {
               class9.myWorldPort = DynamicObject.field1456;
            }

            ++field902;
            loginState = 0;
         } else {
            WorldMapType1.method293(-2);
         }
      }
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "64"
   )
   final void method1240() {
      if(field1095 > 1) {
         --field1095;
      }

      if(field912 > 0) {
         --field912;
      }

      if(socketError) {
         socketError = false;
         WidgetNode.method1156();
      } else {
         if(!isMenuOpen) {
            class34.method495();
            menuOptions[0] = "Cancel";
            menuTargets[0] = "";
            menuTypes[0] = 1006;
            field995[0] = false;
            menuOptionCount = 1;
         }

         for(int var1 = 0; var1 < 100 && this.method1498(field952); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(true) {
               ClassInfo var2 = (ClassInfo)class289.field3811.method3741();
               boolean var27;
               if(var2 == null) {
                  var27 = false;
               } else {
                  var27 = true;
               }

               int var3;
               class170 var28;
               if(!var27) {
                  class170 var12;
                  int var13;
                  if(field970.field3776) {
                     var12 = Actor.method1628(class167.field2321, field952.field1478);
                     var12.field2423.putByte(0);
                     var13 = var12.field2423.offset;
                     field970.method5105(var12.field2423);
                     var12.field2423.method3287(var12.field2423.offset - var13);
                     field952.method1951(var12);
                     field970.method5103();
                  }

                  Object var32 = class5.field31.field804;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  synchronized(class5.field31.field804) {
                     if(!field1080) {
                        class5.field31.field811 = 0;
                     } else if(MouseInput.field713 != 0 || class5.field31.field811 >= 40) {
                        var28 = Actor.method1628(class167.field2309, field952.field1478);
                        var28.field2423.putByte(0);
                        var3 = var28.field2423.offset;
                        var4 = 0;

                        for(var5 = 0; var5 < class5.field31.field811 && var28.field2423.offset - var3 < 240; ++var5) {
                           ++var4;
                           var6 = class5.field31.field807[var5];
                           if(var6 < 0) {
                              var6 = 0;
                           } else if(var6 > 502) {
                              var6 = 502;
                           }

                           var7 = class5.field31.field806[var5];
                           if(var7 < 0) {
                              var7 = 0;
                           } else if(var7 > 764) {
                              var7 = 764;
                           }

                           var8 = var6 * 765 + var7;
                           if(class5.field31.field807[var5] == -1 && class5.field31.field806[var5] == -1) {
                              var7 = -1;
                              var6 = -1;
                              var8 = 524287;
                           }

                           if(var7 == field1090 && var6 == field1054) {
                              if(field882 < 2047) {
                                 ++field882;
                              }
                           } else {
                              int var9 = var7 - field1090;
                              field1090 = var7;
                              int var10 = var6 - field1054;
                              field1054 = var6;
                              if(field882 < 8 && var9 >= -32 && var9 <= 31 && var10 >= -32 && var10 <= 31) {
                                 var9 += 32;
                                 var10 += 32;
                                 var28.field2423.putShort(var10 + (field882 << 12) + (var9 << 6));
                                 field882 = 0;
                              } else if(field882 < 8) {
                                 var28.field2423.put24bitInt((field882 << 19) + var8 + 8388608);
                                 field882 = 0;
                              } else {
                                 var28.field2423.putInt((field882 << 19) + var8 + -1073741824);
                                 field882 = 0;
                              }
                           }
                        }

                        var28.field2423.method3287(var28.field2423.offset - var3);
                        field952.method1951(var28);
                        if(var4 >= class5.field31.field811) {
                           class5.field31.field811 = 0;
                        } else {
                           class5.field31.field811 -= var4;

                           for(var5 = 0; var5 < class5.field31.field811; ++var5) {
                              class5.field31.field806[var5] = class5.field31.field806[var4 + var5];
                              class5.field31.field807[var5] = class5.field31.field807[var4 + var5];
                           }
                        }
                     }
                  }

                  class170 var16;
                  if(MouseInput.field713 == 1 || !Item.field1399 && MouseInput.field713 == 4 || MouseInput.field713 == 2) {
                     long var14 = (MouseInput.field701 - field879) / 50L;
                     if(var14 > 4095L) {
                        var14 = 4095L;
                     }

                     field879 = MouseInput.field701;
                     var3 = MouseInput.field715;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > class89.canvasHeight) {
                        var3 = class89.canvasHeight;
                     }

                     var4 = MouseInput.field714;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > Tile.canvasWidth) {
                        var4 = Tile.canvasWidth;
                     }

                     var5 = (int)var14;
                     var16 = Actor.method1628(class167.field2308, field952.field1478);
                     var16.field2423.putShort((MouseInput.field713 == 2?1:0) + (var5 << 1));
                     var16.field2423.putShort(var4);
                     var16.field2423.putShort(var3);
                     field952.method1951(var16);
                  }

                  if(KeyFocusListener.field605 > 0) {
                     var12 = Actor.method1628(class167.field2306, field952.field1478);
                     var12.field2423.putShort(0);
                     var13 = var12.field2423.offset;
                     long var17 = class268.currentTimeMs();

                     for(var5 = 0; var5 < KeyFocusListener.field605; ++var5) {
                        long var19 = var17 - field1052;
                        if(var19 > 16777215L) {
                           var19 = 16777215L;
                        }

                        field1052 = var17;
                        var12.field2423.method3327((int)var19);
                        var12.field2423.method3311(KeyFocusListener.field614[var5]);
                     }

                     var12.field2423.method3410(var12.field2423.offset - var13);
                     field952.method1951(var12);
                  }

                  if(field939 > 0) {
                     --field939;
                  }

                  if(KeyFocusListener.field618[96] || KeyFocusListener.field618[97] || KeyFocusListener.field618[98] || KeyFocusListener.field618[99]) {
                     field983 = true;
                  }

                  if(field983 && field939 <= 0) {
                     field939 = 20;
                     field983 = false;
                     var12 = Actor.method1628(class167.field2311, field952.field1478);
                     var12.field2423.method3319(field932);
                     var12.field2423.method3340(mapAngle);
                     field952.method1951(var12);
                  }

                  if(class35.field474 && !field883) {
                     field883 = true;
                     var12 = Actor.method1628(class167.field2310, field952.field1478);
                     var12.field2423.putByte(1);
                     field952.method1951(var12);
                  }

                  if(!class35.field474 && field883) {
                     field883 = false;
                     var12 = Actor.method1628(class167.field2310, field952.field1478);
                     var12.field2423.putByte(0);
                     field952.method1951(var12);
                  }

                  RSCanvas.method855();
                  if(gameState != 30) {
                     return;
                  }

                  for(PendingSpawn var33 = (PendingSpawn)pendingSpawns.getFront(); var33 != null; var33 = (PendingSpawn)pendingSpawns.getNext()) {
                     if(var33.hitpoints > 0) {
                        --var33.hitpoints;
                     }

                     if(var33.hitpoints == 0) {
                        if(var33.field1135 < 0 || method1606(var33.field1135, var33.field1134)) {
                           class36.method545(var33.level, var33.type, var33.x, var33.y, var33.field1135, var33.field1136, var33.field1134);
                           var33.unlink();
                        }
                     } else {
                        if(var33.delay > 0) {
                           --var33.delay;
                        }

                        if(var33.delay == 0 && var33.x >= 1 && var33.y >= 1 && var33.x <= 102 && var33.y <= 102 && (var33.id < 0 || method1606(var33.id, var33.field1140))) {
                           class36.method545(var33.level, var33.type, var33.x, var33.y, var33.id, var33.orientation, var33.field1140);
                           var33.delay = -1;
                           if(var33.field1135 == var33.id && var33.field1135 == -1) {
                              var33.unlink();
                           } else if(var33.field1135 == var33.id && var33.field1136 == var33.orientation && var33.field1134 == var33.field1140) {
                              var33.unlink();
                           }
                        }
                     }
                  }

                  class60.method1088();
                  ++field952.field1475;
                  if(field952.field1475 > 750) {
                     WidgetNode.method1156();
                     return;
                  }

                  class222.method4145();
                  class211.method3979();
                  int[] var34 = class94.playerIndices;

                  for(var13 = 0; var13 < class94.playerIndexesCount; ++var13) {
                     Player var21 = cachedPlayers[var34[var13]];
                     if(var21 != null && var21.field1148 > 0) {
                        --var21.field1148;
                        if(var21.field1148 == 0) {
                           var21.overhead = null;
                        }
                     }
                  }

                  for(var13 = 0; var13 < npcIndexesCount; ++var13) {
                     var3 = npcIndices[var13];
                     NPC var22 = cachedNPCs[var3];
                     if(var22 != null && var22.field1148 > 0) {
                        --var22.field1148;
                        if(var22.field1148 == 0) {
                           var22.overhead = null;
                        }
                     }
                  }

                  ++field925;
                  if(cursorState != 0) {
                     field937 += 20;
                     if(field937 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class169.field2420 != null) {
                     ++field1066;
                     if(field1066 >= 15) {
                        WorldMapData.method394(class169.field2420);
                        class169.field2420 = null;
                     }
                  }

                  Widget var35 = ItemContainer.field751;
                  Widget var29 = class13.field280;
                  ItemContainer.field751 = null;
                  class13.field280 = null;
                  field1041 = null;
                  field1068 = false;
                  field1027 = false;
                  field885 = 0;

                  while(class51.method839() && field885 < 128) {
                     if(rights >= 2 && KeyFocusListener.field618[82] && CombatInfoListHolder.field1289 == 66) {
                        String var39 = "";

                        MessageNode var36;
                        for(Iterator var23 = class96.field1433.iterator(); var23.hasNext(); var39 = var39 + var36.name + ':' + var36.value + '\n') {
                           var36 = (MessageNode)var23.next();
                        }

                        class9.clientInstance.method959(var39);
                     } else {
                        field1073[field885] = CombatInfoListHolder.field1289;
                        field1072[field885] = class285.field3792;
                        ++field885;
                     }
                  }

                  if(class44.method687() && KeyFocusListener.field618[82] && KeyFocusListener.field618[81] && field1047 != 0) {
                     var3 = class48.localPlayer.field852 - field1047;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > 3) {
                        var3 = 3;
                     }

                     if(var3 != class48.localPlayer.field852) {
                        var4 = class48.localPlayer.pathX[0] + ItemLayer.baseX;
                        var5 = class48.localPlayer.pathY[0] + ItemLayer.baseY;
                        var16 = Actor.method1628(class167.field2386, field952.field1478);
                        var16.field2423.putShort(var5);
                        var16.field2423.method3340(var4);
                        var16.field2423.putByte(var3);
                        field952.method1951(var16);
                     }

                     field1047 = 0;
                  }

                  if(widgetRoot != -1) {
                     GameEngine.method1053(widgetRoot, 0, 0, Tile.canvasWidth, class89.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     ScriptEvent var38;
                     Widget var41;
                     Widget var42;
                     do {
                        var38 = (ScriptEvent)field1061.popFront();
                        if(var38 == null) {
                           while(true) {
                              do {
                                 var38 = (ScriptEvent)field959.popFront();
                                 if(var38 == null) {
                                    while(true) {
                                       do {
                                          var38 = (ScriptEvent)field1048.popFront();
                                          if(var38 == null) {
                                             this.method1245();
                                             if(renderOverview != null) {
                                                renderOverview.method5496(Ignore.plane, (class48.localPlayer.x >> 7) + ItemLayer.baseX, (class48.localPlayer.y >> 7) + ItemLayer.baseY, false);
                                                renderOverview.method5516();
                                             }

                                             if(field1022 != null) {
                                                this.method1250();
                                             }

                                             if(ClanMember.field864 != null) {
                                                WorldMapData.method394(ClanMember.field864);
                                                ++field967;
                                                if(MouseInput.field706 == 0) {
                                                   if(field966) {
                                                      if(ClanMember.field864 == class111.field1586 && field894 != field965) {
                                                         Widget var40 = ClanMember.field864;
                                                         byte var30 = 0;
                                                         if(field1119 == 1 && var40.contentType == 206) {
                                                            var30 = 1;
                                                         }

                                                         if(var40.itemIds[field965] <= 0) {
                                                            var30 = 0;
                                                         }

                                                         var6 = Preferences.getWidgetConfig(var40);
                                                         boolean var31 = (var6 >> 29 & 1) != 0;
                                                         if(var31) {
                                                            var7 = field894;
                                                            var8 = field965;
                                                            var40.itemIds[var8] = var40.itemIds[var7];
                                                            var40.itemQuantities[var8] = var40.itemQuantities[var7];
                                                            var40.itemIds[var7] = -1;
                                                            var40.itemQuantities[var7] = 0;
                                                         } else if(var30 == 1) {
                                                            var7 = field894;
                                                            var8 = field965;

                                                            while(var7 != var8) {
                                                               if(var7 > var8) {
                                                                  var40.method4193(var7 - 1, var7);
                                                                  --var7;
                                                               } else if(var7 < var8) {
                                                                  var40.method4193(var7 + 1, var7);
                                                                  ++var7;
                                                               }
                                                            }
                                                         } else {
                                                            var40.method4193(field965, field894);
                                                         }

                                                         class170 var24 = Actor.method1628(class167.field2390, field952.field1478);
                                                         var24.field2423.method3289(ClanMember.field864.id);
                                                         var24.field2423.method3403(var30);
                                                         var24.field2423.method3319(field965);
                                                         var24.field2423.method3340(field894);
                                                         field952.method1951(var24);
                                                      }
                                                   } else if(this.method1246()) {
                                                      this.method1528(field963, field964);
                                                   } else if(menuOptionCount > 0) {
                                                      var3 = field963;
                                                      var4 = field964;
                                                      ContextMenuRow var43 = class44.topContextMenuRow;
                                                      Ignore.menuAction(var43.param0, var43.param1, var43.type, var43.identifier, var43.option, var43.option, var3, var4);
                                                      class44.topContextMenuRow = null;
                                                   }

                                                   field1066 = 10;
                                                   MouseInput.field713 = 0;
                                                   ClanMember.field864 = null;
                                                } else if(field967 >= 5 && (MouseInput.field704 > field963 + 5 || MouseInput.field704 < field963 - 5 || MouseInput.field708 > field964 + 5 || MouseInput.field708 < field964 - 5)) {
                                                   field966 = true;
                                                }
                                             }

                                             if(Region.method2780()) {
                                                var3 = Region.selectedRegionTileX;
                                                var4 = Region.selectedRegionTileY;
                                                class170 var44 = Actor.method1628(class167.field2400, field952.field1478);
                                                var44.field2423.putByte(5);
                                                var44.field2423.method3340(var4 + ItemLayer.baseY);
                                                var44.field2423.method3340(var3 + ItemLayer.baseX);
                                                var44.field2423.method3374(KeyFocusListener.field618[82]?(KeyFocusListener.field618[81]?2:1):0);
                                                field952.method1951(var44);
                                                Region.method2821();
                                                field956 = MouseInput.field714;
                                                field957 = MouseInput.field715;
                                                cursorState = 1;
                                                field937 = 0;
                                                destinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(var35 != ItemContainer.field751) {
                                                if(var35 != null) {
                                                   WorldMapData.method394(var35);
                                                }

                                                if(ItemContainer.field751 != null) {
                                                   WorldMapData.method394(ItemContainer.field751);
                                                }
                                             }

                                             if(var29 != class13.field280 && field1000 == field1001) {
                                                if(var29 != null) {
                                                   WorldMapData.method394(var29);
                                                }

                                                if(class13.field280 != null) {
                                                   WorldMapData.method394(class13.field280);
                                                }
                                             }

                                             if(class13.field280 != null) {
                                                if(field1000 < field1001) {
                                                   ++field1000;
                                                   if(field1000 == field1001) {
                                                      WorldMapData.method394(class13.field280);
                                                   }
                                                }
                                             } else if(field1000 > 0) {
                                                --field1000;
                                             }

                                             class210.method3852();
                                             if(field1097) {
                                                class22.method188();
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field946[var3];
                                             }

                                             class1.chatMessages.process();
                                             var3 = ++MouseInput.mouseIdleTicks - 1;
                                             var5 = class22.method186();
                                             if(var3 > 15000 && var5 > 15000) {
                                                field912 = 250;
                                                MouseInput.mouseIdleTicks = 14500;
                                                var16 = Actor.method1628(class167.field2353, field952.field1478);
                                                field952.method1951(var16);
                                             }

                                             for(class66 var37 = (class66)field1117.method3806(); var37 != null; var37 = (class66)field1117.method3803()) {
                                                if((long)var37.field778 < class268.currentTimeMs() / 1000L - 5L) {
                                                   if(var37.field777 > 0) {
                                                      class96.sendGameMessage(5, "", var37.field776 + " has logged in.");
                                                   }

                                                   if(var37.field777 == 0) {
                                                      class96.sendGameMessage(5, "", var37.field776 + " has logged out.");
                                                   }

                                                   var37.method3814();
                                                }
                                             }

                                             ++field952.field1466;
                                             if(field952.field1466 > 50) {
                                                var16 = Actor.method1628(class167.field2307, field952.field1478);
                                                field952.method1951(var16);
                                             }

                                             try {
                                                field952.method1958();
                                             } catch (IOException var25) {
                                                WidgetNode.method1156();
                                             }

                                             return;
                                          }

                                          var41 = var38.widget;
                                          if(var41.index < 0) {
                                             break;
                                          }

                                          var42 = PendingSpawn.method1612(var41.parentId);
                                       } while(var42 == null || var42.children == null || var41.index >= var42.children.length || var41 != var42.children[var41.index]);

                                       class111.method2177(var38);
                                    }
                                 }

                                 var41 = var38.widget;
                                 if(var41.index < 0) {
                                    break;
                                 }

                                 var42 = PendingSpawn.method1612(var41.parentId);
                              } while(var42 == null || var42.children == null || var41.index >= var42.children.length || var41 != var42.children[var41.index]);

                              class111.method2177(var38);
                           }
                        }

                        var41 = var38.widget;
                        if(var41.index < 0) {
                           break;
                        }

                        var42 = PendingSpawn.method1612(var41.parentId);
                     } while(var42 == null || var42.children == null || var41.index >= var42.children.length || var41 != var42.children[var41.index]);

                     class111.method2177(var38);
                  }
               }

               var28 = Actor.method1628(class167.field2315, field952.field1478);
               var28.field2423.putByte(0);
               var3 = var28.field2423.offset;
               World.encodeClassVerifier(var28.field2423);
               var28.field2423.method3287(var28.field2423.offset - var3);
               field952.method1951(var28);
            }
         }
      }
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1728146621"
   )
   void method1237() {
      int var1 = Tile.canvasWidth;
      int var2 = class89.canvasHeight;
      if(super.field673 < var1) {
         var1 = super.field673;
      }

      if(super.field674 < var2) {
         var2 = super.field674;
      }

      if(Buffer.preferences != null) {
         try {
            Client var3 = class9.clientInstance;
            int var4 = isResized?2:1;
            Object[] var5 = new Object[]{Integer.valueOf(var4)};
            JSObject.getWindow(var3).call("resize", var5);
         } catch (Throwable var6) {
            ;
         }
      }

   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1157698456"
   )
   final void method1243() {
      int var1;
      if(widgetRoot != -1) {
         var1 = widgetRoot;
         if(CombatInfoListHolder.loadWidget(var1)) {
            class12.method71(class243.widgets[var1], -1);
         }
      }

      for(var1 = 0; var1 < field980; ++var1) {
         if(field1055[var1]) {
            field1056[var1] = true;
         }

         field896[var1] = field1055[var1];
         field1055[var1] = false;
      }

      field1010 = gameCycle;
      field998 = -1;
      field999 = -1;
      class111.field1586 = null;
      if(widgetRoot != -1) {
         field980 = 0;
         class13.method83(widgetRoot, 0, 0, Tile.canvasWidth, class89.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      if(!isMenuOpen) {
         if(field998 != -1) {
            var1 = field998;
            int var2 = field999;
            if(menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) {
               int var3 = menuOptionCount - 1;
               String var5;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var5 = "Use" + " " + field1118 + " " + "->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var5 = field1007 + " " + field1008 + " " + "->";
               } else {
                  var5 = class21.method175(var3);
               }

               if(menuOptionCount > 2) {
                  var5 = var5 + WallObject.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               class20.field320.drawRandomizedMouseoverText(var5, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         class189.method3614();
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < field980; ++var1) {
            if(field896[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1056[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      class94.method1859(Ignore.plane, class48.localPlayer.x, class48.localPlayer.y, field925);
      field925 = 0;
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(Lcx;I)Z",
      garbageValue = "-793880750"
   )
   final boolean method1498(class100 var1) {
      RSSocket var2 = var1.method1954();
      PacketBuffer var3 = var1.field1469;
      if(var2 == null) {
         return false;
      } else {
         int var24;
         String var26;
         try {
            int var5;
            if(var1.field1470 == null) {
               if(var1.field1474) {
                  if(!var2.method3101(1)) {
                     return false;
                  }

                  var2.read(var1.field1469.payload, 0, 1);
                  var1.field1475 = 0;
                  var1.field1474 = false;
               }

               var3.offset = 0;
               if(var3.method3563()) {
                  if(!var2.method3101(1)) {
                     return false;
                  }

                  var2.read(var1.field1469.payload, 1, 1);
                  var1.field1475 = 0;
               }

               var1.field1474 = true;
               class166[] var4 = DecorativeObject.method3001();
               var5 = var3.method3564();
               if(var5 < 0 || var5 >= var4.length) {
                  throw new IOException(var5 + " " + var3.offset);
               }

               var1.field1470 = var4[var5];
               var1.field1471 = var1.field1470.field2304;
            }

            if(var1.field1471 == -1) {
               if(!var2.method3101(1)) {
                  return false;
               }

               var1.method1954().read(var3.payload, 0, 1);
               var1.field1471 = var3.payload[0] & 255;
            }

            if(var1.field1471 == -2) {
               if(!var2.method3101(2)) {
                  return false;
               }

               var1.method1954().read(var3.payload, 0, 2);
               var3.offset = 0;
               var1.field1471 = var3.readUnsignedShort();
            }

            if(!var2.method3101(var1.field1471)) {
               return false;
            }

            var3.offset = 0;
            var2.read(var3.payload, 0, var1.field1471);
            var1.field1475 = 0;
            field970.method5106();
            var1.field1477 = var1.field1476;
            var1.field1476 = var1.field1464;
            var1.field1464 = var1.field1470;
            int var23;
            Widget var63;
            if(class166.field2251 == var1.field1470) {
               var23 = var3.readUnsignedShortOb1();
               var5 = var3.method3331();
               var63 = PendingSpawn.method1612(var5);
               if(var63 != null && var63.type == 0) {
                  if(var23 > var63.scrollHeight - var63.height) {
                     var23 = var63.scrollHeight - var63.height;
                  }

                  if(var23 < 0) {
                     var23 = 0;
                  }

                  if(var23 != var63.scrollY) {
                     var63.scrollY = var23;
                     WorldMapData.method394(var63);
                  }
               }

               var1.field1470 = null;
               return true;
            }

            int var62;
            if(class166.field2281 == var1.field1470) {
               var23 = var3.readUnsignedByte();
               var5 = var3.readUnsignedByte();
               var24 = var3.readUnsignedByte();
               var62 = var3.readUnsignedByte();
               field1098[var23] = true;
               field949[var23] = var5;
               field1071[var23] = var24;
               field1101[var23] = var62;
               field946[var23] = 0;
               var1.field1470 = null;
               return true;
            }

            if(class166.field2289 == var1.field1470) {
               var23 = var3.method3326();
               var5 = var3.readInt();
               var63 = PendingSpawn.method1612(var5);
               if(var23 != var63.field2773 || var23 == -1) {
                  var63.field2773 = var23;
                  var63.field2737 = 0;
                  var63.field2849 = 0;
                  WorldMapData.method394(var63);
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2284 == var1.field1470) {
               class35.method542();
               weight = var3.readShort();
               field1046 = cycleCntr;
               var1.field1470 = null;
               return true;
            }

            if(class166.field2239 == var1.field1470) {
               for(var23 = 0; var23 < class218.widgetSettings.length; ++var23) {
                  if(class218.widgetSettings[var23] != class218.settings[var23]) {
                     class218.widgetSettings[var23] = class218.settings[var23];
                     DynamicObject.method1934(var23);
                     field1035[++field1128 - 1 & 31] = var23;
                  }
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2230 == var1.field1470) {
               ScriptVarType.method18(class169.field2410);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2283 == var1.field1470) {
               var23 = var3.readUnsignedShort();
               var5 = var3.readUnsignedByte();
               var24 = var3.readUnsignedShort();
               if(field1089 != 0 && var5 != 0 && field1091 < 50) {
                  field910[field1091] = var23;
                  field1093[field1091] = var5;
                  field1094[field1091] = var24;
                  audioEffects[field1091] = null;
                  field1033[field1091] = 0;
                  ++field1091;
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2279 == var1.field1470) {
               hintArrowTargetType = var3.readUnsignedByte();
               if(hintArrowTargetType == 1) {
                  hintArrowNpcTargetIdx = var3.readUnsignedShort();
               }

               if(hintArrowTargetType >= 2 && hintArrowTargetType <= 6) {
                  if(hintArrowTargetType == 2) {
                     hintArrowOffsetX = 64;
                     hintArrowOffsetY = 64;
                  }

                  if(hintArrowTargetType == 3) {
                     hintArrowOffsetX = 0;
                     hintArrowOffsetY = 64;
                  }

                  if(hintArrowTargetType == 4) {
                     hintArrowOffsetX = 128;
                     hintArrowOffsetY = 64;
                  }

                  if(hintArrowTargetType == 5) {
                     hintArrowOffsetX = 64;
                     hintArrowOffsetY = 0;
                  }

                  if(hintArrowTargetType == 6) {
                     hintArrowOffsetX = 64;
                     hintArrowOffsetY = 128;
                  }

                  hintArrowTargetType = 2;
                  hintArrowX = var3.readUnsignedShort();
                  hintArrowY = var3.readUnsignedShort();
                  hintArrowType = var3.readUnsignedByte();
               }

               if(hintArrowTargetType == 10) {
                  hintArrowPlayerTargetIdx = var3.readUnsignedShort();
               }

               var1.field1470 = null;
               return true;
            }

            WidgetNode var80;
            if(class166.field2244 == var1.field1470) {
               var23 = var3.method3313();
               var5 = var3.method3322();
               var24 = var3.method3292();
               var80 = (WidgetNode)componentTable.get((long)var24);
               if(var80 != null) {
                  Frames.method2984(var80, var5 != var80.id);
               }

               class2.method3(var24, var5, var23);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2261 == var1.field1470) {
               ScriptVarType.method18(class169.field2415);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2276 == var1.field1470) {
               for(var23 = 0; var23 < VarPlayerType.field3344; ++var23) {
                  VarPlayerType var103 = ClanMember.method1228(var23);
                  if(var103 != null) {
                     class218.settings[var23] = 0;
                     class218.widgetSettings[var23] = 0;
                  }
               }

               class35.method542();
               field1128 += 32;
               var1.field1470 = null;
               return true;
            }

            if(class166.field2277 == var1.field1470) {
               field1085 = var3.readUnsignedByte();
               var1.field1470 = null;
               return true;
            }

            boolean var81;
            if(class166.field2282 == var1.field1470) {
               var81 = var3.method3407() == 1;
               var5 = var3.method3292();
               var63 = PendingSpawn.method1612(var5);
               if(var81 != var63.isHidden) {
                  var63.isHidden = var81;
                  WorldMapData.method394(var63);
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2299 == var1.field1470) {
               class35.method542();
               var23 = var3.method3331();
               var5 = var3.method3314();
               var24 = var3.readUnsignedByte();
               skillExperiences[var5] = var23;
               boostedSkillLevels[var5] = var24;
               realSkillLevels[var5] = 1;

               for(var62 = 0; var62 < 98; ++var62) {
                  if(var23 >= class229.field2909[var62]) {
                     realSkillLevels[var5] = var62 + 2;
                  }
               }

               field1039[++field1034 - 1 & 31] = var5;
               var1.field1470 = null;
               return true;
            }

            if(class166.field2294 == var1.field1470) {
               var23 = var3.method3322();
               byte var77 = var3.method3316();
               class218.settings[var23] = var77;
               if(class218.widgetSettings[var23] != var77) {
                  class218.widgetSettings[var23] = var77;
               }

               DynamicObject.method1934(var23);
               field1035[++field1128 - 1 & 31] = var23;
               var1.field1470 = null;
               return true;
            }

            int var9;
            int var10;
            int var64;
            if(class166.field2266 == var1.field1470) {
               field1097 = true;
               class34.field467 = var3.readUnsignedByte();
               class64.field761 = var3.readUnsignedByte();
               CombatInfo1.field1207 = var3.readUnsignedShort();
               TextureProvider.field1688 = var3.readUnsignedByte();
               class8.field238 = var3.readUnsignedByte();
               if(class8.field238 >= 100) {
                  var23 = class34.field467 * 128 + 64;
                  var5 = class64.field761 * 128 + 64;
                  var24 = class70.getTileHeight(var23, var5, Ignore.plane) - CombatInfo1.field1207;
                  var62 = var23 - class29.cameraX;
                  var64 = var24 - class70.cameraZ;
                  var9 = var5 - Player.cameraY;
                  var10 = (int)Math.sqrt((double)(var62 * var62 + var9 * var9));
                  class28.cameraPitch = (int)(Math.atan2((double)var64, (double)var10) * 325.949D) & 2047;
                  class228.cameraYaw = (int)(Math.atan2((double)var62, (double)var9) * -325.949D) & 2047;
                  if(class28.cameraPitch < 128) {
                     class28.cameraPitch = 128;
                  }

                  if(class28.cameraPitch > 383) {
                     class28.cameraPitch = 383;
                  }
               }

               var1.field1470 = null;
               return true;
            }

            Widget var91;
            if(class166.field2253 == var1.field1470) {
               var23 = var3.readInt();
               var91 = PendingSpawn.method1612(var23);

               for(var24 = 0; var24 < var91.itemIds.length; ++var24) {
                  var91.itemIds[var24] = -1;
                  var91.itemIds[var24] = 0;
               }

               WorldMapData.method394(var91);
               var1.field1470 = null;
               return true;
            }

            String var6;
            boolean var7;
            boolean var67;
            int var68;
            boolean var76;
            if(class166.field2300 == var1.field1470) {
               while(var3.offset < var1.field1471) {
                  var81 = var3.readUnsignedByte() == 1;
                  var26 = var3.readString();
                  var6 = var3.readString();
                  var62 = var3.readUnsignedShort();
                  var64 = var3.readUnsignedByte();
                  var9 = var3.readUnsignedByte();
                  boolean var71 = (var9 & 2) != 0;
                  var67 = (var9 & 1) != 0;
                  if(var62 > 0) {
                     var3.readString();
                     var3.readUnsignedByte();
                     var3.readInt();
                  }

                  var3.readString();

                  for(var68 = 0; var68 < friendCount; ++var68) {
                     Friend var70 = friends[var68];
                     if(!var81) {
                        if(var26.equals(var70.name)) {
                           if(var62 != var70.world) {
                              var76 = true;

                              for(class66 var74 = (class66)field1117.method3806(); var74 != null; var74 = (class66)field1117.method3803()) {
                                 if(var74.field776.equals(var26)) {
                                    if(var62 != 0 && var74.field777 == 0) {
                                       var74.method3814();
                                       var76 = false;
                                    } else if(var62 == 0 && var74.field777 != 0) {
                                       var74.method3814();
                                       var76 = false;
                                    }
                                 }
                              }

                              if(var76) {
                                 field1117.method3804(new class66(var26, var62));
                              }

                              var70.world = var62;
                           }

                           var70.previousName = var6;
                           var70.rank = var64;
                           var70.field770 = var71;
                           var70.field771 = var67;
                           var26 = null;
                           break;
                        }
                     } else if(var6.equals(var70.name)) {
                        var70.name = var26;
                        var70.previousName = var6;
                        var26 = null;
                        break;
                     }
                  }

                  if(var26 != null && friendCount < 400) {
                     Friend var98 = new Friend();
                     friends[friendCount] = var98;
                     var98.name = var26;
                     var98.previousName = var6;
                     var98.world = var62;
                     var98.rank = var64;
                     var98.field770 = var71;
                     var98.field771 = var67;
                     ++friendCount;
                  }
               }

               field1021 = 2;
               field1042 = cycleCntr;
               var81 = false;
               var5 = friendCount;

               while(var5 > 0) {
                  var81 = true;
                  --var5;

                  for(var24 = 0; var24 < var5; ++var24) {
                     var7 = false;
                     Friend var100 = friends[var24];
                     Friend var94 = friends[var24 + 1];
                     if(var100.world != world && var94.world == world) {
                        var7 = true;
                     }

                     if(!var7 && var100.world == 0 && var94.world != 0) {
                        var7 = true;
                     }

                     if(!var7 && !var100.field770 && var94.field770) {
                        var7 = true;
                     }

                     if(!var7 && !var100.field771 && var94.field771) {
                        var7 = true;
                     }

                     if(var7) {
                        Friend var104 = friends[var24];
                        friends[var24] = friends[var24 + 1];
                        friends[var24 + 1] = var104;
                        var81 = false;
                     }
                  }

                  if(var81) {
                     break;
                  }
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2267 == var1.field1470) {
               if(widgetRoot != -1) {
                  var23 = widgetRoot;
                  if(CombatInfoListHolder.loadWidget(var23)) {
                     class158.method3085(class243.widgets[var23], 0);
                  }
               }

               var1.field1470 = null;
               return true;
            }

            String var58;
            if(class166.field2236 == var1.field1470) {
               var58 = var3.readString();
               var26 = FontTypeFace.appendTags(ObjectComposition.method4745(IndexFile.method3133(var3)));
               class96.sendGameMessage(6, var58, var26);
               var1.field1470 = null;
               return true;
            }

            boolean var61;
            if(class166.field2287 == var1.field1470) {
               while(var3.offset < var1.field1471) {
                  var23 = var3.readUnsignedByte();
                  var61 = (var23 & 1) == 1;
                  var6 = var3.readString();
                  String var83 = var3.readString();
                  var3.readString();

                  for(var64 = 0; var64 < ignoreCount; ++var64) {
                     Ignore var92 = ignores[var64];
                     if(var61) {
                        if(var83.equals(var92.name)) {
                           var92.name = var6;
                           var92.previousName = var83;
                           var6 = null;
                           break;
                        }
                     } else if(var6.equals(var92.name)) {
                        var92.name = var6;
                        var92.previousName = var83;
                        var6 = null;
                        break;
                     }
                  }

                  if(var6 != null && ignoreCount < 400) {
                     Ignore var99 = new Ignore();
                     ignores[ignoreCount] = var99;
                     var99.name = var6;
                     var99.previousName = var83;
                     ++ignoreCount;
                  }
               }

               field1042 = cycleCntr;
               var1.field1470 = null;
               return true;
            }

            if(class166.field2302 == var1.field1470) {
               class82.method1744(var3, var1.field1471);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2297 == var1.field1470) {
               var23 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if(var23 < -70000) {
                  var5 += 32768;
               }

               if(var23 >= 0) {
                  var63 = PendingSpawn.method1612(var23);
               } else {
                  var63 = null;
               }

               for(; var3.offset < var1.field1471; class10.setItemTableSlot(var5, var62, var64 - 1, var9)) {
                  var62 = var3.getUSmart();
                  var64 = var3.readUnsignedShort();
                  var9 = 0;
                  if(var64 != 0) {
                     var9 = var3.readUnsignedByte();
                     if(var9 == 255) {
                        var9 = var3.readInt();
                     }
                  }

                  if(var63 != null && var62 >= 0 && var62 < var63.itemIds.length) {
                     var63.itemIds[var62] = var64;
                     var63.itemQuantities[var62] = var9;
                  }
               }

               if(var63 != null) {
                  WorldMapData.method394(var63);
               }

               class35.method542();
               interfaceItemTriggers[++field991 - 1 & 31] = var5 & 32767;
               var1.field1470 = null;
               return true;
            }

            Widget var25;
            if(class166.field2252 == var1.field1470) {
               var23 = var3.method3426();
               var5 = var3.method3326();
               var24 = var3.readInt();
               var25 = PendingSpawn.method1612(var24);
               if(var5 != var25.originalX || var23 != var25.originalY || var25.field2731 != 0 || var25.field2732 != 0) {
                  var25.originalX = var5;
                  var25.originalY = var23;
                  var25.field2731 = 0;
                  var25.field2732 = 0;
                  WorldMapData.method394(var25);
                  this.method1252(var25);
                  if(var25.type == 0) {
                     class22.method179(class243.widgets[var24 >> 16], var25, false);
                  }
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2274 == var1.field1470) {
               var23 = var3.method3324();
               ItemContainer var93 = (ItemContainer)ItemContainer.itemContainers.get((long)var23);
               if(var93 != null) {
                  var93.unlink();
               }

               interfaceItemTriggers[++field991 - 1 & 31] = var23 & 32767;
               var1.field1470 = null;
               return true;
            }

            if(class166.field2248 == var1.field1470) {
               class94.playerIndexesCount = 0;

               for(var23 = 0; var23 < 2048; ++var23) {
                  class94.field1404[var23] = null;
                  class94.field1411[var23] = 1;
               }

               for(var23 = 0; var23 < 2048; ++var23) {
                  cachedPlayers[var23] = null;
               }

               class229.initializeGPI(var3);
               var1.field1470 = null;
               return true;
            }

            int var11;
            long var31;
            if(class166.field2242 == var1.field1470) {
               var23 = var3.offset + var1.field1471;
               var5 = var3.readUnsignedShort();
               var24 = var3.readUnsignedShort();
               if(var5 != widgetRoot) {
                  widgetRoot = var5;
                  this.method1248(false);
                  PlayerComposition.method4115(widgetRoot);
                  class29.method272(widgetRoot);

                  for(var62 = 0; var62 < 100; ++var62) {
                     field1055[var62] = true;
                  }
               }

               WidgetNode var102;
               for(; var24-- > 0; var102.field782 = true) {
                  var62 = var3.readInt();
                  var64 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedByte();
                  var102 = (WidgetNode)componentTable.get((long)var62);
                  if(var102 != null && var64 != var102.id) {
                     Frames.method2984(var102, true);
                     var102 = null;
                  }

                  if(var102 == null) {
                     var102 = class2.method3(var62, var64, var9);
                  }
               }

               for(var80 = (WidgetNode)componentTable.method3721(); var80 != null; var80 = (WidgetNode)componentTable.method3728()) {
                  if(var80.field782) {
                     var80.field782 = false;
                  } else {
                     Frames.method2984(var80, true);
                  }
               }

               widgetFlags = new HashTable(512);

               while(var3.offset < var23) {
                  var62 = var3.readInt();
                  var64 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedShort();
                  var10 = var3.readInt();

                  for(var11 = var64; var11 <= var9; ++var11) {
                     var31 = (long)var11 + ((long)var62 << 32);
                     widgetFlags.put(new IntegerNode(var10), var31);
                  }
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2241 == var1.field1470) {
               ScriptVarType.method18(class169.field2412);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2254 == var1.field1470) {
               var23 = var3.readInt();
               var5 = var3.method3322();
               if(var5 == 65535) {
                  var5 = -1;
               }

               var24 = var3.method3333();
               var25 = PendingSpawn.method1612(var23);
               ItemComposition var95;
               if(!var25.hasScript) {
                  if(var5 == -1) {
                     var25.modelType = 0;
                     var1.field1470 = null;
                     return true;
                  }

                  var95 = class250.getItemDefinition(var5);
                  var25.modelType = 4;
                  var25.modelId = var5;
                  var25.rotationX = var95.xan2d;
                  var25.rotationZ = var95.yan2d;
                  var25.modelZoom = var95.zoom2d * 100 / var24;
                  WorldMapData.method394(var25);
               } else {
                  var25.itemId = var5;
                  var25.itemQuantity = var24;
                  var95 = class250.getItemDefinition(var5);
                  var25.rotationX = var95.xan2d;
                  var25.rotationZ = var95.yan2d;
                  var25.rotationY = var95.zan2d;
                  var25.field2775 = var95.offsetX2d;
                  var25.field2768 = var95.offsetY2d;
                  var25.modelZoom = var95.zoom2d;
                  if(var95.isStackable == 1) {
                     var25.field2784 = 1;
                  } else {
                     var25.field2784 = 2;
                  }

                  if(var25.field2781 > 0) {
                     var25.modelZoom = var25.modelZoom * 32 / var25.field2781;
                  } else if(var25.originalWidth > 0) {
                     var25.modelZoom = var25.modelZoom * 32 / var25.originalWidth;
                  }

                  WorldMapData.method394(var25);
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2280 == var1.field1470) {
               var23 = var3.readUnsignedByte();
               if(var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var23] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var23] = new GrandExchangeOffer(var3, false);
               }

               field1044 = cycleCntr;
               var1.field1470 = null;
               return true;
            }

            if(class166.field2259 == var1.field1470) {
               var23 = var3.method3333();
               var91 = PendingSpawn.method1612(var23);
               var91.modelType = 3;
               var91.modelId = class48.localPlayer.composition.method4111();
               WorldMapData.method394(var91);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2298 == var1.field1470) {
               class41.method599(true, var3);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2296 == var1.field1470) {
               var23 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if(var23 < -70000) {
                  var5 += 32768;
               }

               if(var23 >= 0) {
                  var63 = PendingSpawn.method1612(var23);
               } else {
                  var63 = null;
               }

               if(var63 != null) {
                  for(var62 = 0; var62 < var63.itemIds.length; ++var62) {
                     var63.itemIds[var62] = 0;
                     var63.itemQuantities[var62] = 0;
                  }
               }

               class37.method551(var5);
               var62 = var3.readUnsignedShort();

               for(var64 = 0; var64 < var62; ++var64) {
                  var9 = var3.method3322();
                  var10 = var3.method3407();
                  if(var10 == 255) {
                     var10 = var3.method3292();
                  }

                  if(var63 != null && var64 < var63.itemIds.length) {
                     var63.itemIds[var64] = var9;
                     var63.itemQuantities[var64] = var10;
                  }

                  class10.setItemTableSlot(var5, var64, var9 - 1, var10);
               }

               if(var63 != null) {
                  WorldMapData.method394(var63);
               }

               class35.method542();
               interfaceItemTriggers[++field991 - 1 & 31] = var5 & 32767;
               var1.field1470 = null;
               return true;
            }

            if(class166.field2295 == var1.field1470) {
               class56.field655 = var3.readUnsignedByte();
               GameObject.field2105 = var3.method3407();
               var1.field1470 = null;
               return true;
            }

            if(class166.field2292 == var1.field1470) {
               var23 = var3.readUnsignedShort();
               if(var23 == 65535) {
                  var23 = -1;
               }

               class13.method84(var23);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2291 == var1.field1470) {
               var23 = var3.read24BitInt();
               var5 = var3.readUnsignedShort();
               if(var5 == 65535) {
                  var5 = -1;
               }

               if(field1059 != 0 && var5 != -1) {
                  class182.method3518(class236.indexTrack2, var5, 0, field1059, false);
                  field1088 = true;
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2233 == var1.field1470) {
               ScriptVarType.method18(class169.field2413);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2246 == var1.field1470) {
               var58 = var3.readString();
               Object[] var88 = new Object[var58.length() + 1];

               for(var24 = var58.length() - 1; var24 >= 0; --var24) {
                  if(var58.charAt(var24) == 's') {
                     var88[var24 + 1] = var3.readString();
                  } else {
                     var88[var24 + 1] = new Integer(var3.readInt());
                  }
               }

               var88[0] = new Integer(var3.readInt());
               ScriptEvent var66 = new ScriptEvent();
               var66.field791 = var88;
               class111.method2177(var66);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2257 == var1.field1470) {
               var23 = var3.method3322();
               var5 = var3.method3333();
               var24 = var23 >> 10 & 31;
               var62 = var23 >> 5 & 31;
               var64 = var23 & 31;
               var9 = (var62 << 11) + (var24 << 19) + (var64 << 3);
               Widget var101 = PendingSpawn.method1612(var5);
               if(var9 != var101.textColor) {
                  var101.textColor = var9;
                  WorldMapData.method394(var101);
               }

               var1.field1470 = null;
               return true;
            }

            Widget var89;
            if(class166.field2285 == var1.field1470) {
               var23 = var3.method3292();
               var5 = var3.method3292();
               WidgetNode var65 = (WidgetNode)componentTable.get((long)var5);
               var80 = (WidgetNode)componentTable.get((long)var23);
               if(var80 != null) {
                  Frames.method2984(var80, var65 == null || var65.id != var80.id);
               }

               if(var65 != null) {
                  var65.unlink();
                  componentTable.put(var65, (long)var23);
               }

               var89 = PendingSpawn.method1612(var5);
               if(var89 != null) {
                  WorldMapData.method394(var89);
               }

               var89 = PendingSpawn.method1612(var23);
               if(var89 != null) {
                  WorldMapData.method394(var89);
                  class22.method179(class243.widgets[var89.id >>> 16], var89, true);
               }

               if(widgetRoot != -1) {
                  var9 = widgetRoot;
                  if(CombatInfoListHolder.loadWidget(var9)) {
                     class158.method3085(class243.widgets[var9], 1);
                  }
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2220 == var1.field1470) {
               destinationX = var3.readUnsignedByte();
               if(destinationX == 255) {
                  destinationX = 0;
               }

               destinationY = var3.readUnsignedByte();
               if(destinationY == 255) {
                  destinationY = 0;
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2288 == var1.field1470) {
               field1057 = var3.method3407();
               field905 = var3.method3314();
               var1.field1470 = null;
               return true;
            }

            if(class166.field2243 == var1.field1470) {
               var23 = var3.readInt();
               WidgetNode var87 = (WidgetNode)componentTable.get((long)var23);
               if(var87 != null) {
                  Frames.method2984(var87, true);
               }

               if(field1013 != null) {
                  WorldMapData.method394(field1013);
                  field1013 = null;
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2275 == var1.field1470) {
               WallObject.method2975(false, var1.field1469);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2245 == var1.field1470) {
               var23 = var3.readUnsignedShortOb1();
               widgetRoot = var23;
               this.method1248(false);
               PlayerComposition.method4115(var23);
               class29.method272(widgetRoot);

               for(var5 = 0; var5 < 100; ++var5) {
                  field1055[var5] = true;
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2286 == var1.field1470) {
               class35.method542();
               energy = var3.readUnsignedByte();
               field1046 = cycleCntr;
               var1.field1470 = null;
               return true;
            }

            if(class166.field2293 == var1.field1470) {
               var23 = var3.readUnsignedShortOb1();
               var5 = var3.method3292();
               class218.settings[var23] = var5;
               if(class218.widgetSettings[var23] != var5) {
                  class218.widgetSettings[var23] = var5;
               }

               DynamicObject.method1934(var23);
               field1035[++field1128 - 1 & 31] = var23;
               var1.field1470 = null;
               return true;
            }

            if(class166.field2227 == var1.field1470) {
               ScriptVarType.method18(class169.field2418);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2223 == var1.field1470) {
               class181.method3514();
               var1.field1470 = null;
               return false;
            }

            if(class166.field2225 == var1.field1470) {
               var23 = var3.readInt();
               FileSystem.field3271 = GameEngine.taskManager.createHost(var23);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2269 == var1.field1470) {
               var23 = var3.readInt();
               var5 = var3.readInt();
               var24 = Renderable.method2972();
               class170 var79 = Actor.method1628(class167.field2357, field952.field1478);
               var79.field2423.method3311(GameEngine.FPS);
               var79.field2423.method3403(var24);
               var79.field2423.method3289(var23);
               var79.field2423.method3295(var5);
               field952.method1951(var79);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2250 == var1.field1470) {
               var23 = var3.method3292();
               var5 = var3.method3324();
               var24 = var3.method3322();
               var62 = var3.readUnsignedShortOb1();
               var89 = PendingSpawn.method1612(var23);
               if(var24 != var89.rotationX || var5 != var89.rotationZ || var62 != var89.modelZoom) {
                  var89.rotationX = var24;
                  var89.rotationZ = var5;
                  var89.modelZoom = var62;
                  WorldMapData.method394(var89);
               }

               var1.field1470 = null;
               return true;
            }

            String var16;
            int var17;
            long var33;
            long var35;
            long var37;
            int var40;
            if(class166.field2272 == var1.field1470) {
               var58 = var3.readString();
               var33 = var3.readLong();
               var35 = (long)var3.readUnsignedShort();
               var37 = (long)var3.read24BitInt();
               Permission var106 = (Permission)class47.forOrdinal(class15.method112(), var3.readUnsignedByte());
               var31 = var37 + (var35 << 32);
               var76 = false;

               for(var40 = 0; var40 < 100; ++var40) {
                  if(var31 == field1069[var40]) {
                     var76 = true;
                     break;
                  }
               }

               if(var106.field3235 && Tile.isIgnored(var58)) {
                  var76 = true;
               }

               if(!var76 && field968 == 0) {
                  field1069[field1070] = var31;
                  field1070 = (field1070 + 1) % 100;
                  String var72 = FontTypeFace.appendTags(ObjectComposition.method4745(IndexFile.method3133(var3)));
                  if(var106.field3240 != -1) {
                     var17 = var106.field3240;
                     var16 = "<img=" + var17 + ">";
                     DynamicObject.addChatMessage(9, var16 + var58, var72, Preferences.method1686(var33));
                  } else {
                     DynamicObject.addChatMessage(9, var58, var72, Preferences.method1686(var33));
                  }
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2235 == var1.field1470) {
               class56.field655 = var3.method3407();
               GameObject.field2105 = var3.method3407();

               for(var23 = class56.field655; var23 < class56.field655 + 8; ++var23) {
                  for(var5 = GameObject.field2105; var5 < GameObject.field2105 + 8; ++var5) {
                     if(groundItemDeque[Ignore.plane][var23][var5] != null) {
                        groundItemDeque[Ignore.plane][var23][var5] = null;
                        class27.groundItemSpawned(var23, var5);
                     }
                  }
               }

               for(PendingSpawn var60 = (PendingSpawn)pendingSpawns.getFront(); var60 != null; var60 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var60.x >= class56.field655 && var60.x < class56.field655 + 8 && var60.y >= GameObject.field2105 && var60.y < GameObject.field2105 + 8 && var60.level == Ignore.plane) {
                     var60.hitpoints = 0;
                  }
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2234 == var1.field1470) {
               ScriptVarType.method18(class169.field2414);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2232 == var1.field1470) {
               class13.method81(var3.readString());
               var1.field1470 = null;
               return true;
            }

            if(class166.field2222 == var1.field1470) {
               World var59 = new World();
               var59.address = var3.readString();
               var59.id = var3.readUnsignedShort();
               var5 = var3.readInt();
               var59.mask = var5;
               class287.setGameState(45);
               var2.close();
               var2 = null;
               class74.method1222(var59);
               var1.field1470 = null;
               return false;
            }

            if(class166.field2260 == var1.field1470) {
               var23 = var3.method3322();
               var5 = var3.readUnsignedShortOb1();
               var24 = var3.method3333();
               var25 = PendingSpawn.method1612(var24);
               var25.field2782 = var5 + (var23 << 16);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2255 == var1.field1470) {
               field1097 = true;
               class188.field2532 = var3.readUnsignedByte();
               class18.field309 = var3.readUnsignedByte();
               class11.field265 = var3.readUnsignedShort();
               class25.field358 = var3.readUnsignedByte();
               class20.field325 = var3.readUnsignedByte();
               if(class20.field325 >= 100) {
                  class29.cameraX = class188.field2532 * 128 + 64;
                  Player.cameraY = class18.field309 * 128 + 64;
                  class70.cameraZ = class70.getTileHeight(class29.cameraX, Player.cameraY, Ignore.plane) - class11.field265;
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2247 == var1.field1470) {
               var23 = var3.readUnsignedShortOb1();
               if(var23 == 65535) {
                  var23 = -1;
               }

               var5 = var3.readUnsignedShort();
               if(var5 == 65535) {
                  var5 = -1;
               }

               var24 = var3.method3331();
               var62 = var3.method3333();

               for(var64 = var23; var64 <= var5; ++var64) {
                  var37 = ((long)var24 << 32) + (long)var64;
                  Node var105 = widgetFlags.get(var37);
                  if(var105 != null) {
                     var105.unlink();
                  }

                  widgetFlags.put(new IntegerNode(var62), var37);
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2262 == var1.field1470) {
               var23 = var3.method3324();
               var5 = var3.method3331();
               var63 = PendingSpawn.method1612(var5);
               if(var63.modelType != 1 || var23 != var63.modelId) {
                  var63.modelType = 1;
                  var63.modelId = var23;
                  WorldMapData.method394(var63);
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2249 == var1.field1470) {
               class41.method599(false, var3);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2290 == var1.field1470) {
               ScriptVarType.method18(class169.field2417);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2265 == var1.field1470) {
               field1097 = false;

               for(var23 = 0; var23 < 5; ++var23) {
                  field1098[var23] = false;
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2238 == var1.field1470) {
               class56.field655 = var3.method3407();
               GameObject.field2105 = var3.method3407();

               while(var3.offset < var1.field1471) {
                  var23 = var3.readUnsignedByte();
                  class169 var86 = Script.method1918()[var23];
                  ScriptVarType.method18(var86);
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2240 == var1.field1470) {
               field1021 = 1;
               field1042 = cycleCntr;
               var1.field1470 = null;
               return true;
            }

            if(class166.field2258 == var1.field1470) {
               var81 = var3.readUnsignedByte() == 1;
               if(var81) {
                  class61.field735 = class268.currentTimeMs() - var3.readLong();
                  class175.field2446 = new class13(var3, true);
               } else {
                  class175.field2446 = null;
               }

               field1045 = cycleCntr;
               var1.field1470 = null;
               return true;
            }

            if(class166.field2256 == var1.field1470) {
               for(var23 = 0; var23 < cachedPlayers.length; ++var23) {
                  if(cachedPlayers[var23] != null) {
                     cachedPlayers[var23].animation = -1;
                  }
               }

               for(var23 = 0; var23 < cachedNPCs.length; ++var23) {
                  if(cachedNPCs[var23] != null) {
                     cachedNPCs[var23].animation = -1;
                  }
               }

               var1.field1470 = null;
               return true;
            }

            String var85;
            if(class166.field2301 == var1.field1470) {
               var23 = var3.getUSmart();
               var61 = var3.readUnsignedByte() == 1;
               var6 = "";
               var7 = false;
               if(var61) {
                  var6 = var3.readString();
                  if(Tile.isIgnored(var6)) {
                     var7 = true;
                  }
               }

               var85 = var3.readString();
               if(!var7) {
                  class96.sendGameMessage(var23, var6, var85);
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2264 == var1.field1470) {
               var3.offset += 28;
               if(var3.checkCrc()) {
                  var23 = var3.offset - 28;
                  byte[] var84 = var3.payload;
                  if(field1040 == null) {
                     field1040 = new byte[24];
                  }

                  class190.method3620(var84, var23, field1040, 0, 24);
                  if(class156.field2160 != null) {
                     try {
                        class156.field2160.seek(0L);
                        class156.field2160.write(var3.payload, var23, 24);
                     } catch (Exception var50) {
                        ;
                     }
                  }
               }

               var1.field1470 = null;
               return true;
            }

            int var73;
            if(class166.field2278 == var1.field1470) {
               var23 = var1.field1471;
               ClassInfo var82 = new ClassInfo();
               var82.count = var3.readUnsignedByte();
               var82.field3798 = var3.readInt();
               var82.type = new int[var82.count];
               var82.errorIdentifiers = new int[var82.count];
               var82.fields = new Field[var82.count];
               var82.field3803 = new int[var82.count];
               var82.methods = new Method[var82.count];
               var82.args = new byte[var82.count][][];

               for(var24 = 0; var24 < var82.count; ++var24) {
                  try {
                     var62 = var3.readUnsignedByte();
                     String var90;
                     if(var62 != 0 && var62 != 1 && var62 != 2) {
                        if(var62 == 3 || var62 == 4) {
                           var85 = var3.readString();
                           var90 = var3.readString();
                           var10 = var3.readUnsignedByte();
                           String[] var39 = new String[var10];

                           for(var68 = 0; var68 < var10; ++var68) {
                              var39[var68] = var3.readString();
                           }

                           String var97 = var3.readString();
                           byte[][] var69 = new byte[var10][];
                           if(var62 == 3) {
                              for(var73 = 0; var73 < var10; ++var73) {
                                 var40 = var3.readInt();
                                 var69[var73] = new byte[var40];
                                 var3.readBytes(var69[var73], 0, var40);
                              }
                           }

                           var82.type[var24] = var62;
                           Class[] var41 = new Class[var10];

                           for(var40 = 0; var40 < var10; ++var40) {
                              var41[var40] = WidgetNode.method1157(var39[var40]);
                           }

                           Class var15 = WidgetNode.method1157(var97);
                           if(WidgetNode.method1157(var85).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var75 = WidgetNode.method1157(var85).getDeclaredMethods();
                           Method[] var42 = var75;

                           for(int var18 = 0; var18 < var42.length; ++var18) {
                              Method var19 = var42[var18];
                              if(Reflection.getMethodName(var19).equals(var90)) {
                                 Class[] var20 = Reflection.getParameterTypes(var19);
                                 if(var41.length == var20.length) {
                                    boolean var21 = true;

                                    for(int var22 = 0; var22 < var41.length; ++var22) {
                                       if(var41[var22] != var20[var22]) {
                                          var21 = false;
                                          break;
                                       }
                                    }

                                    if(var21 && var15 == var19.getReturnType()) {
                                       var82.methods[var24] = var19;
                                    }
                                 }
                              }
                           }

                           var82.args[var24] = var69;
                        }
                     } else {
                        var85 = var3.readString();
                        var90 = var3.readString();
                        var10 = 0;
                        if(var62 == 1) {
                           var10 = var3.readInt();
                        }

                        var82.type[var24] = var62;
                        var82.field3803[var24] = var10;
                        if(WidgetNode.method1157(var85).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var82.fields[var24] = Reflection.findField(WidgetNode.method1157(var85), var90);
                     }
                  } catch (ClassNotFoundException var51) {
                     var82.errorIdentifiers[var24] = -1;
                  } catch (SecurityException var52) {
                     var82.errorIdentifiers[var24] = -2;
                  } catch (NullPointerException var53) {
                     var82.errorIdentifiers[var24] = -3;
                  } catch (Exception var54) {
                     var82.errorIdentifiers[var24] = -4;
                  } catch (Throwable var55) {
                     var82.errorIdentifiers[var24] = -5;
                  }
               }

               class289.field3811.method3749(var82);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2228 == var1.field1470) {
               ScriptVarType.method18(class169.field2416);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2263 == var1.field1470) {
               var23 = var3.method3292();
               var26 = var3.readString();
               var63 = PendingSpawn.method1612(var23);
               if(!var26.equals(var63.text)) {
                  var63.text = var26;
                  WorldMapData.method394(var63);
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2226 == var1.field1470) {
               var23 = var3.method3324();
               var5 = var3.method3331();
               var63 = PendingSpawn.method1612(var5);
               if(var63.modelType != 2 || var23 != var63.modelId) {
                  var63.modelType = 2;
                  var63.modelId = var23;
                  WorldMapData.method394(var63);
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2231 == var1.field1470) {
               var23 = var3.method3314();
               var5 = var3.method3314();
               var6 = var3.readString();
               if(var5 >= 1 && var5 <= 8) {
                  if(var6.equalsIgnoreCase("null")) {
                     var6 = null;
                  }

                  playerOptions[var5 - 1] = var6;
                  playerOptionsPriorities[var5 - 1] = var23 == 0;
               }

               var1.field1470 = null;
               return true;
            }

            long var45;
            int var47;
            if(class166.field2271 == var1.field1470) {
               field1043 = cycleCntr;
               if(var1.field1471 == 0) {
                  clanChatOwner = null;
                  clanChatName = null;
                  clanChatCount = 0;
                  DynamicObject.clanMembers = null;
                  var1.field1470 = null;
                  return true;
               }

               clanChatName = var3.readString();
               long var43 = var3.readLong();
               var35 = var43;
               if(var43 > 0L && var43 < 6582952005840035281L) {
                  if(0L == var43 % 37L) {
                     var6 = null;
                  } else {
                     var9 = 0;

                     for(var45 = var43; 0L != var45; var45 /= 37L) {
                        ++var9;
                     }

                     StringBuilder var29 = new StringBuilder(var9);

                     while(var35 != 0L) {
                        long var48 = var35;
                        var35 /= 37L;
                        var29.append(class275.field3727[(int)(var48 - var35 * 37L)]);
                     }

                     var6 = var29.reverse().toString();
                  }
               } else {
                  var6 = null;
               }

               clanChatOwner = var6;
               class70.field805 = var3.readByte();
               var9 = var3.readUnsignedByte();
               if(var9 == 255) {
                  var1.field1470 = null;
                  return true;
               }

               clanChatCount = var9;
               ClanMember[] var30 = new ClanMember[100];

               for(var11 = 0; var11 < clanChatCount; ++var11) {
                  var30[var11] = new ClanMember();
                  var30[var11].username = var3.readString();
                  var30[var11].field862 = PacketBuffer.method3598(var30[var11].username, class60.field718);
                  var30[var11].world = var3.readUnsignedShort();
                  var30[var11].rank = var3.readByte();
                  var3.readString();
                  if(var30[var11].username.equals(class48.localPlayer.name)) {
                     class9.clanChatRank = var30[var11].rank;
                  }
               }

               var67 = false;
               var47 = clanChatCount;

               while(var47 > 0) {
                  var67 = true;
                  --var47;

                  for(var73 = 0; var73 < var47; ++var73) {
                     if(var30[var73].field862.compareTo(var30[var73 + 1].field862) > 0) {
                        ClanMember var96 = var30[var73];
                        var30[var73] = var30[var73 + 1];
                        var30[var73 + 1] = var96;
                        var67 = false;
                     }
                  }

                  if(var67) {
                     break;
                  }
               }

               DynamicObject.clanMembers = var30;
               var1.field1470 = null;
               return true;
            }

            if(class166.field2270 == var1.field1470) {
               var58 = var3.readString();
               var5 = var3.readUnsignedShort();
               byte var78 = var3.readByte();
               var7 = false;
               if(var78 == -128) {
                  var7 = true;
               }

               if(var7) {
                  if(clanChatCount == 0) {
                     var1.field1470 = null;
                     return true;
                  }

                  boolean var8 = false;

                  for(var64 = 0; var64 < clanChatCount && (!DynamicObject.clanMembers[var64].username.equals(var58) || var5 != DynamicObject.clanMembers[var64].world); ++var64) {
                     ;
                  }

                  if(var64 < clanChatCount) {
                     while(var64 < clanChatCount - 1) {
                        DynamicObject.clanMembers[var64] = DynamicObject.clanMembers[var64 + 1];
                        ++var64;
                     }

                     --clanChatCount;
                     DynamicObject.clanMembers[clanChatCount] = null;
                  }
               } else {
                  var3.readString();
                  ClanMember var27 = new ClanMember();
                  var27.username = var58;
                  var27.field862 = PacketBuffer.method3598(var27.username, class60.field718);
                  var27.world = var5;
                  var27.rank = var78;

                  for(var9 = clanChatCount - 1; var9 >= 0; --var9) {
                     var10 = DynamicObject.clanMembers[var9].field862.compareTo(var27.field862);
                     if(var10 == 0) {
                        DynamicObject.clanMembers[var9].world = var5;
                        DynamicObject.clanMembers[var9].rank = var78;
                        if(var58.equals(class48.localPlayer.name)) {
                           class9.clanChatRank = var78;
                        }

                        field1043 = cycleCntr;
                        var1.field1470 = null;
                        return true;
                     }

                     if(var10 < 0) {
                        break;
                     }
                  }

                  if(clanChatCount >= DynamicObject.clanMembers.length) {
                     var1.field1470 = null;
                     return true;
                  }

                  for(var10 = clanChatCount - 1; var10 > var9; --var10) {
                     DynamicObject.clanMembers[var10 + 1] = DynamicObject.clanMembers[var10];
                  }

                  if(clanChatCount == 0) {
                     DynamicObject.clanMembers = new ClanMember[100];
                  }

                  DynamicObject.clanMembers[var9 + 1] = var27;
                  ++clanChatCount;
                  if(var58.equals(class48.localPlayer.name)) {
                     class9.clanChatRank = var78;
                  }
               }

               field1043 = cycleCntr;
               var1.field1470 = null;
               return true;
            }

            if(class166.field2221 == var1.field1470) {
               WallObject.method2975(true, var1.field1469);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2229 == var1.field1470) {
               ScriptVarType.method18(class169.field2411);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2268 == var1.field1470) {
               Huffman.field2432 = VarPlayerType.method4465(var3.readUnsignedByte());
               var1.field1470 = null;
               return true;
            }

            if(class166.field2273 == var1.field1470) {
               var58 = var3.readString();
               var33 = (long)var3.readUnsignedShort();
               var35 = (long)var3.read24BitInt();
               Permission var28 = (Permission)class47.forOrdinal(class15.method112(), var3.readUnsignedByte());
               var45 = (var33 << 32) + var35;
               boolean var12 = false;

               for(var47 = 0; var47 < 100; ++var47) {
                  if(var45 == field1069[var47]) {
                     var12 = true;
                     break;
                  }
               }

               if(Tile.isIgnored(var58)) {
                  var12 = true;
               }

               if(!var12 && field968 == 0) {
                  field1069[field1070] = var45;
                  field1070 = (field1070 + 1) % 100;
                  String var13 = FontTypeFace.appendTags(ObjectComposition.method4745(IndexFile.method3133(var3)));
                  byte var14;
                  if(var28.field3239) {
                     var14 = 7;
                  } else {
                     var14 = 3;
                  }

                  if(var28.field3240 != -1) {
                     var17 = var28.field3240;
                     var16 = "<img=" + var17 + ">";
                     class96.sendGameMessage(var14, var16 + var58, var13);
                  } else {
                     class96.sendGameMessage(var14, var58, var13);
                  }
               }

               var1.field1470 = null;
               return true;
            }

            if(class166.field2237 == var1.field1470) {
               ScriptVarType.method18(class169.field2419);
               var1.field1470 = null;
               return true;
            }

            if(class166.field2224 == var1.field1470) {
               field1095 = var3.readUnsignedShortOb1() * 30;
               field1046 = cycleCntr;
               var1.field1470 = null;
               return true;
            }

            class33.method396("" + (var1.field1470 != null?var1.field1470.field2303:-1) + "," + (var1.field1476 != null?var1.field1476.field2303:-1) + "," + (var1.field1477 != null?var1.field1477.field2303:-1) + "," + var1.field1471, (Throwable)null);
            class181.method3514();
         } catch (IOException var56) {
            WidgetNode.method1156();
         } catch (Exception var57) {
            var26 = "" + (var1.field1470 != null?var1.field1470.field2303:-1) + "," + (var1.field1476 != null?var1.field1476.field2303:-1) + "," + (var1.field1477 != null?var1.field1477.field2303:-1) + "," + var1.field1471 + "," + (class48.localPlayer.pathX[0] + ItemLayer.baseX) + "," + (class48.localPlayer.pathY[0] + ItemLayer.baseY) + ",";

            for(var24 = 0; var24 < var1.field1471 && var24 < 50; ++var24) {
               var26 = var26 + var3.payload[var24] + ",";
            }

            class33.method396(var26, var57);
            class181.method3514();
         }

         return true;
      }
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "81"
   )
   final void method1245() {
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
               boolean var6 = field995[var2];
               field995[var2] = field995[var2 + 1];
               field995[var2 + 1] = var6;
               var1 = false;
            }
         }
      }

      if(ClanMember.field864 == null) {
         if(field1022 == null) {
            int var11;
            int var17;
            label279: {
               int var16 = MouseInput.field713;
               int var9;
               int var14;
               if(isMenuOpen) {
                  int var13;
                  if(var16 != 1 && (Item.field1399 || var16 != 4)) {
                     var2 = MouseInput.field704;
                     var13 = MouseInput.field708;
                     if(var2 < CacheFile.menuX - 10 || var2 > class256.menuWidth + CacheFile.menuX + 10 || var13 < class45.menuY - 10 || var13 > class45.menuY + class18.menuHeight + 10) {
                        isMenuOpen = false;
                        class22.method180(CacheFile.menuX, class45.menuY, class256.menuWidth, class18.menuHeight);
                     }
                  }

                  if(var16 == 1 || !Item.field1399 && var16 == 4) {
                     var2 = CacheFile.menuX;
                     var13 = class45.menuY;
                     var14 = class256.menuWidth;
                     var5 = MouseInput.field714;
                     var17 = MouseInput.field715;
                     int var7 = -1;

                     for(int var18 = 0; var18 < menuOptionCount; ++var18) {
                        var9 = (menuOptionCount - 1 - var18) * 15 + var13 + 31;
                        if(var5 > var2 && var5 < var14 + var2 && var17 > var9 - 13 && var17 < var9 + 3) {
                           var7 = var18;
                        }
                     }

                     if(var7 != -1) {
                        class164.method3174(var7);
                     }

                     isMenuOpen = false;
                     class22.method180(CacheFile.menuX, class45.menuY, class256.menuWidth, class18.menuHeight);
                  }
               } else {
                  var2 = menuOptionCount - 1;
                  if((var16 == 1 || !Item.field1399 && var16 == 4) && var2 >= 0) {
                     var14 = menuTypes[var2];
                     if(var14 == 39 || var14 == 40 || var14 == 41 || var14 == 42 || var14 == 43 || var14 == 33 || var14 == 34 || var14 == 35 || var14 == 36 || var14 == 37 || var14 == 38 || var14 == 1005) {
                        var5 = menuActionParams0[var2];
                        var17 = menuActionParams1[var2];
                        Widget var15 = PendingSpawn.method1612(var17);
                        var9 = Preferences.getWidgetConfig(var15);
                        boolean var8 = (var9 >> 28 & 1) != 0;
                        if(var8) {
                           break label279;
                        }

                        var11 = Preferences.getWidgetConfig(var15);
                        boolean var10 = (var11 >> 29 & 1) != 0;
                        if(var10) {
                           break label279;
                        }
                     }
                  }

                  if((var16 == 1 || !Item.field1399 && var16 == 4) && this.method1246()) {
                     var16 = 2;
                  }

                  if((var16 == 1 || !Item.field1399 && var16 == 4) && menuOptionCount > 0) {
                     class164.method3174(var2);
                  }

                  if(var16 == 2 && menuOptionCount > 0) {
                     this.method1528(MouseInput.field714, MouseInput.field715);
                  }
               }

               return;
            }

            if(ClanMember.field864 != null && !field966 && menuOptionCount > 0 && !this.method1246()) {
               int var19 = field963;
               var11 = field964;
               ContextMenuRow var12 = class44.topContextMenuRow;
               Ignore.menuAction(var12.param0, var12.param1, var12.type, var12.identifier, var12.option, var12.option, var19, var11);
               class44.topContextMenuRow = null;
            }

            field966 = false;
            field967 = 0;
            if(ClanMember.field864 != null) {
               WorldMapData.method394(ClanMember.field864);
            }

            ClanMember.field864 = PendingSpawn.method1612(var17);
            field894 = var5;
            field963 = MouseInput.field714;
            field964 = MouseInput.field715;
            if(var2 >= 0) {
               class54.method862(var2);
            }

            WorldMapData.method394(ClanMember.field864);
         }
      }
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-38"
   )
   final boolean method1246() {
      int var1 = menuOptionCount - 1;
      if(menuOptionCount > 2) {
         if(field986 != 1 || field995[var1]) {
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

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2104378947"
   )
   final void method1528(int var1, int var2) {
      int var3 = class20.field320.method4926("Choose Option");

      int var4;
      int var5;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         var5 = class20.field320.method4926(class21.method175(var4));
         if(var5 > var3) {
            var3 = var5;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      var5 = var1 - var3 / 2;
      if(var3 + var5 > Tile.canvasWidth) {
         var5 = Tile.canvasWidth - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      int var6 = var2;
      if(var4 + var2 > class89.canvasHeight) {
         var6 = class89.canvasHeight - var4;
      }

      if(var6 < 0) {
         var6 = 0;
      }

      class56.region.method2818(Ignore.plane, var1, var2, false);
      isMenuOpen = true;
      CacheFile.menuX = var5;
      class45.menuY = var6;
      class256.menuWidth = var3;
      class18.menuHeight = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-30"
   )
   final void method1248(boolean var1) {
      int var2 = widgetRoot;
      int var3 = Tile.canvasWidth;
      int var4 = class89.canvasHeight;
      if(CombatInfoListHolder.loadWidget(var2)) {
         Timer.method3093(class243.widgets[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(Lhk;I)V",
      garbageValue = "-816995165"
   )
   void method1252(Widget var1) {
      Widget var2 = var1.parentId == -1?null:PendingSpawn.method1612(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = Tile.canvasWidth;
         var4 = class89.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      MilliTimer.method3042(var1, var3, var4, false);
      class15.method106(var1, var3, var4);
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-88"
   )
   final void method1250() {
      WorldMapData.method394(field1022);
      ++ScriptVarType.field225;
      if(field1068 && field1027) {
         int var1 = MouseInput.field704;
         int var2 = MouseInput.field708;
         var1 -= field1024;
         var2 -= field1087;
         if(var1 < field1028) {
            var1 = field1028;
         }

         if(var1 + field1022.width > field1028 + field1023.width) {
            var1 = field1028 + field1023.width - field1022.width;
         }

         if(var2 < field880) {
            var2 = field880;
         }

         if(var2 + field1022.height > field880 + field1023.height) {
            var2 = field880 + field1023.height - field1022.height;
         }

         int var3 = var1 - field1031;
         int var4 = var2 - field1032;
         int var5 = field1022.field2789;
         if(ScriptVarType.field225 > field1022.field2803 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1063 = true;
         }

         int var6 = var1 - field1028 + field1023.scrollX;
         int var7 = var2 - field880 + field1023.scrollY;
         ScriptEvent var8;
         if(field1022.field2816 != null && field1063) {
            var8 = new ScriptEvent();
            var8.widget = field1022;
            var8.field787 = var6;
            var8.field788 = var7;
            var8.field791 = field1022.field2816;
            class111.method2177(var8);
         }

         if(MouseInput.field706 == 0) {
            if(field1063) {
               if(field1022.field2743 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field1022;
                  var8.field787 = var6;
                  var8.field788 = var7;
                  var8.field790 = field1041;
                  var8.field791 = field1022.field2743;
                  class111.method2177(var8);
               }

               if(field1041 != null) {
                  Widget var9 = field1022;
                  int var11 = Preferences.getWidgetConfig(var9);
                  int var10 = var11 >> 17 & 7;
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

                        var9 = PendingSpawn.method1612(var9.parentId);
                        if(var9 == null) {
                           var17 = null;
                           break;
                        }

                        ++var13;
                     }
                  }

                  if(var17 != null) {
                     class170 var18 = Actor.method1628(class167.field2330, field952.field1478);
                     var18.field2423.method3319(field1041.itemId);
                     var18.field2423.method3295(field1041.id);
                     var18.field2423.putShortLE(field1022.itemId);
                     var18.field2423.method3319(field1041.index);
                     var18.field2423.putInt(field1022.id);
                     var18.field2423.putShortLE(field1022.index);
                     field952.method1951(var18);
                  }
               }
            } else if(this.method1246()) {
               this.method1528(field1024 + field1031, field1032 + field1087);
            } else if(menuOptionCount > 0) {
               int var15 = field1024 + field1031;
               int var16 = field1032 + field1087;
               ContextMenuRow var14 = class44.topContextMenuRow;
               Ignore.menuAction(var14.param0, var14.param1, var14.type, var14.identifier, var14.option, var14.option, var15, var16);
               class44.topContextMenuRow = null;
            }

            field1022 = null;
         }

      } else {
         if(ScriptVarType.field225 > 1) {
            field1022 = null;
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[Lfa;B)V",
      garbageValue = "101"
   )
   static final void method1542(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var9 + var2 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var3 + var10 < 103) {
               var8[var1].flags[var9 + var2][var3 + var10] &= -16777217;
            }
         }
      }

      Buffer var21 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var10 == var4 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                  int var15 = var2 + WidgetNode.method1155(var11 & 7, var12 & 7, var7);
                  int var18 = var11 & 7;
                  int var19 = var12 & 7;
                  int var20 = var7 & 3;
                  int var17;
                  if(var20 == 0) {
                     var17 = var19;
                  } else if(var20 == 1) {
                     var17 = 7 - var18;
                  } else if(var20 == 2) {
                     var17 = 7 - var19;
                  } else {
                     var17 = var18;
                  }

                  CombatInfoListHolder.loadTerrain(var21, var1, var15, var3 + var17, 0, 0, var7);
               } else {
                  CombatInfoListHolder.loadTerrain(var21, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1510671493"
   )
   static final boolean method1606(int var0, int var1) {
      ObjectComposition var2 = class24.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method4697(var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "32"
   )
   public static void method1500() {
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Z",
      garbageValue = "5"
   )
   @Export("isFriended")
   static boolean isFriended(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = PacketBuffer.method3598(var0, class60.field718);

         for(int var3 = 0; var3 < friendCount; ++var3) {
            if(var2.equalsIgnoreCase(PacketBuffer.method3598(friends[var3].name, class60.field718)) && (!var1 || friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(PacketBuffer.method3598(class48.localPlayer.name, class60.field718))) {
            return true;
         } else {
            return false;
         }
      }
   }
}
