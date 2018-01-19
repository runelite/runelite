import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = -1020780361
   )
   static int field1059;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = -662280701
   )
   @Export("widgetCount")
   static int widgetCount;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      longValue = -7555626607255118471L
   )
   static long field1068;
   @ObfuscatedName("ob")
   static boolean field991;
   @ObfuscatedName("mm")
   static boolean[] field1041;
   @ObfuscatedName("mo")
   static boolean[] field975;
   @ObfuscatedName("me")
   static boolean[] field1061;
   @ObfuscatedName("lv")
   static boolean field1036;
   @ObfuscatedName("mu")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("ki")
   static boolean field1033;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 2094935797
   )
   static int field1001;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = 1736166469
   )
   static int field1034;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = -138420577
   )
   @Export("gameDrawingMode")
   static int gameDrawingMode;
   @ObfuscatedName("mr")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("mp")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("mg")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = 1685118667
   )
   static int field1035;
   @ObfuscatedName("mb")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("ms")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = -2133546643
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("qf")
   @ObfuscatedSignature(
      signature = "Lbh;"
   )
   static final class72 field1131;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = 1224512003
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 883753577
   )
   static int field1095;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = -1628126911
   )
   static int field1134;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -1157166897
   )
   static int field1038;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = 1841418609
   )
   static int field1094;
   @ObfuscatedName("mf")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   static Deque field1054;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = -2137145405
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("qh")
   static int[] field1132;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = 1746227031
   )
   static int field951;
   @ObfuscatedName("qm")
   static int[] field1133;
   @ObfuscatedName("qj")
   @ObfuscatedSignature(
      signature = "[La;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("lb")
   static boolean field1039;
   @ObfuscatedName("lh")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = 996323643
   )
   static int field1091;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = 1618232873
   )
   static int field1044;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = 905271357
   )
   static int field1082;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = 116288671
   )
   static int field1050;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = 1584753023
   )
   @Export("mouseWheelRotation")
   static int mouseWheelRotation;
   @ObfuscatedName("oz")
   static boolean field1101;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = 991818583
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("qg")
   @ObfuscatedSignature(
      signature = "[Lbl;"
   )
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("pr")
   static boolean[] field1097;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = 2065103517
   )
   static int field1060;
   @ObfuscatedName("lx")
   static int[] field1093;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      longValue = 8619611566944694477L
   )
   static long field897;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = -831295015
   )
   static int field1049;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = 70415029
   )
   static int field1045;
   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   static PlayerComposition field1126;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = 978291701
   )
   @Export("publicChatMode")
   static int publicChatMode;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = -1987554163
   )
   static int field1128;
   @ObfuscatedName("kt")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   static Widget field1032;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = -1018719411
   )
   static int field1072;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = 1275780377
   )
   static int field1083;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = 1020512921
   )
   static int field1025;
   @ObfuscatedName("or")
   static int[] field1096;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = -1346122679
   )
   static int field1089;
   @ObfuscatedName("oh")
   static int[] field1027;
   @ObfuscatedName("ox")
   static int[] field1098;
   @ObfuscatedName("oc")
   @ObfuscatedSignature(
      signature = "[Ldq;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("oa")
   static int[] field1099;
   @ObfuscatedName("ni")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   @Export("mapIcons")
   static SpritePixels[] mapIcons;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 516889205
   )
   static int field1077;
   @ObfuscatedName("nv")
   static int[] field1088;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -1023544471
   )
   static int field880;
   @ObfuscatedName("ns")
   static int[] field1085;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = -1297131337
   )
   static int field1090;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = -1530339663
   )
   static int field903;
   @ObfuscatedName("ps")
   static short field1107;
   @ObfuscatedName("pk")
   static short field1108;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = -255663933
   )
   @Export("Viewport_xOffset")
   static int Viewport_xOffset;
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      intValue = -1188903315
   )
   @Export("Viewport_yOffset")
   static int Viewport_yOffset;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = 81711465
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = -1291048227
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("pq")
   static short field1113;
   @ObfuscatedName("pf")
   static short field948;
   @ObfuscatedName("pt")
   static short field1112;
   @ObfuscatedName("pp")
   static short field1046;
   @ObfuscatedName("pv")
   static short field1110;
   @ObfuscatedName("po")
   static short field1111;
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = 1787694991
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("ng")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("nj")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("pj")
   static int[] field929;
   @ObfuscatedName("pg")
   static int[] field1104;
   @ObfuscatedName("pb")
   static int[] field1105;
   @ObfuscatedName("py")
   static int[] field1043;
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = -1700370769
   )
   static int field1076;
   @ObfuscatedName("nt")
   static long[] field1074;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = 1023528589
   )
   static int field1042;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = -1300966355
   )
   static int field959;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = 912644233
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("qy")
   @ObfuscatedSignature(
      signature = "[Lba;"
   )
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("nm")
   static int[] field1078;
   @ObfuscatedName("nk")
   static int[] field876;
   @ObfuscatedName("mj")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   static Deque field1055;
   @ObfuscatedName("ma")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   static Deque field1056;
   @ObfuscatedName("lm")
   static int[] field984;
   @ObfuscatedName("nl")
   static String field885;
   @ObfuscatedName("ql")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   static class206 field1123;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = 839596057
   )
   static int field1051;
   @ObfuscatedName("mk")
   static int[] field1070;
   @ObfuscatedName("qs")
   @ObfuscatedSignature(
      signature = "Lbb;"
   )
   static OwnWorldComparator field1130;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = -895666125
   )
   @Export("chatCycle")
   static int chatCycle;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfi;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("ar")
   static boolean field902;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1835726469
   )
   @Export("world")
   static int world;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1691573407
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   static BuildType field875;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1757056939
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("bd")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("bi")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1967870591
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -868842927
   )
   @Export("gameState")
   static int gameState;
   @ObfuscatedName("bw")
   static boolean field881;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 113203175
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      longValue = -6367548367601784955L
   )
   @Export("mouseLastLastPressedTimeMillis")
   static long mouseLastLastPressedTimeMillis;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -472141241
   )
   static int field884;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1132418477
   )
   static int field1021;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -1919302141
   )
   static int field1030;
   @ObfuscatedName("bf")
   static boolean field887;
   @ObfuscatedName("bb")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -471198225
   )
   static int field889;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1189566717
   )
   @Export("hintArrowTargetType")
   static int hintArrowTargetType;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 1724246889
   )
   @Export("hintArrowNpcTargetIdx")
   static int hintArrowNpcTargetIdx;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -1467513383
   )
   @Export("hintArrowPlayerTargetIdx")
   static int hintArrowPlayerTargetIdx;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 411866839
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -2120232679
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -875535609
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -23243813
   )
   @Export("hintArrowOffsetX")
   static int hintArrowOffsetX;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 1261280625
   )
   @Export("hintArrowOffsetY")
   static int hintArrowOffsetY;
   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   @Export("playerAttackOption")
   static AttackOption playerAttackOption;
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   @Export("npcAttackOption")
   static AttackOption npcAttackOption;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1742859319
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 1385943177
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -2047648695
   )
   static int field886;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = 484301917
   )
   static int field1075;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 83298173
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = -408237333
   )
   static int field905;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 776386083
   )
   static int field906;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = 179516753
   )
   static int field907;
   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   static class150 field908;
   @ObfuscatedName("dm")
   static byte[] field1121;
   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "[Lcq;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 122497139
   )
   @Export("npcIndexesCount")
   static int npcIndexesCount;
   @ObfuscatedName("ds")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = -508095559
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("eu")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "Lcg;"
   )
   static final NetWriter field915;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -668226887
   )
   static int field1084;
   @ObfuscatedName("eg")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("ei")
   static boolean field918;
   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   static class287 field894;
   @ObfuscatedName("eq")
   @Export("fontsMap")
   static HashMap fontsMap;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = 358009765
   )
   static int field921;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = 448898781
   )
   static int field922;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = 1592800913
   )
   static int field923;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -709557225
   )
   static int field924;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -691228589
   )
   static int field1052;
   @ObfuscatedName("fs")
   static byte[][] field926;
   @ObfuscatedName("fu")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("fv")
   static int[][][] field1118;
   @ObfuscatedName("fp")
   static final int[] field930;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -101641949
   )
   static int field944;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 776133327
   )
   static int field1087;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = 148001903
   )
   static int field933;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 41153913
   )
   static int field1008;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -1307892251
   )
   static int field935;
   @ObfuscatedName("gv")
   static boolean field936;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 845831109
   )
   static int field937;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 923577155
   )
   static int field1092;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 1587296187
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 1495057937
   )
   static int field1079;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -1115168877
   )
   static int field941;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 1807357579
   )
   static int field891;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 218394897
   )
   static int field996;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 1254201791
   )
   static int field1023;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -1490728045
   )
   static int field1119;
   @ObfuscatedName("gl")
   static boolean field1102;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = 1967555225
   )
   static int field947;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 340017173
   )
   @Export("overheadTextCount")
   static int overheadTextCount;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -633805299
   )
   @Export("maxOverheadTexts")
   static int maxOverheadTexts;
   @ObfuscatedName("gd")
   @Export("overheadTextsX")
   static int[] overheadTextsX;
   @ObfuscatedName("gt")
   @Export("overheadTextsY")
   static int[] overheadTextsY;
   @ObfuscatedName("gf")
   @Export("overheadTextsOffsetY")
   static int[] overheadTextsOffsetY;
   @ObfuscatedName("hy")
   @Export("overheadTextsOffsetX")
   static int[] overheadTextsOffsetX;
   @ObfuscatedName("hc")
   static int[] field1114;
   @ObfuscatedName("hk")
   static int[] field955;
   @ObfuscatedName("hx")
   @Export("overheadTextsCyclesRemaining")
   static int[] overheadTextsCyclesRemaining;
   @ObfuscatedName("he")
   @Export("overheadTexts")
   static String[] overheadTexts;
   @ObfuscatedName("hj")
   static int[][] field958;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = 1490332271
   )
   static int field919;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -893222211
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -960663689
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 702512097
   )
   @Export("lastLeftClickX")
   static int lastLeftClickX;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = -1105692417
   )
   @Export("lastLeftClickY")
   static int lastLeftClickY;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = -1180805707
   )
   static int field964;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -1516290627
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = -1381261537
   )
   @Export("mouseCrosshair")
   static int mouseCrosshair;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = -1935973039
   )
   @Export("pressedItemIndex")
   static int pressedItemIndex;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 1986695919
   )
   static int field968;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = -481644009
   )
   static int field969;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = 1947812533
   )
   static int field970;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = 1157139925
   )
   static int field1020;
   @ObfuscatedName("hg")
   @Export("itemBeingDragged")
   static boolean itemBeingDragged;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = 1333347473
   )
   @Export("itemPressedDuration")
   static int itemPressedDuration;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = 1128084399
   )
   @Export("myPlayerIndex")
   static int myPlayerIndex;
   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "[Lbf;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = 1365865307
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = 463542109
   )
   static int field977;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 1122370439
   )
   static int field978;
   @ObfuscatedName("in")
   static int[] field979;
   @ObfuscatedName("id")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("iq")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("it")
   @Export("lastSelectedItemName")
   static String lastSelectedItemName;
   @ObfuscatedName("il")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("ij")
   static int[] field943;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = 307640711
   )
   static int field974;
   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "[[[Lgi;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("ic")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("iy")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("ip")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = 1278869755
   )
   static int field992;
   @ObfuscatedName("iu")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = 1503412963
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("ji")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("jl")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("jt")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("jh")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("jy")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("js")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("jf")
   @Export("menuBooleanArray")
   static boolean[] menuBooleanArray;
   @ObfuscatedName("jk")
   static boolean field1002;
   @ObfuscatedName("jj")
   static boolean field1003;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -1818511817
   )
   static int field1004;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = -593124851
   )
   static int field1005;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = 1830881459
   )
   static int field1006;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = -1185469115
   )
   static int field1007;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = -2058582069
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("jo")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -1442838295
   )
   static int field917;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -1364027555
   )
   static int field909;
   @ObfuscatedName("ku")
   static String field1013;
   @ObfuscatedName("kk")
   static String field1014;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = -284529701
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("kx")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 660671609
   )
   static int field1017;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = 569353845
   )
   static int field1018;
   @ObfuscatedName("kw")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   static Widget field1019;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = 1868459047
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = 1853183719
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 1182272611
   )
   @Export("rights")
   public static int rights;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 1403755989
   )
   static int field1047;
   @ObfuscatedName("kl")
   static boolean field983;
   @ObfuscatedName("kh")
   static boolean field911;
   @ObfuscatedName("kq")
   @Export("numberMenuOptions")
   static boolean numberMenuOptions;
   @ObfuscatedName("ky")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   static Widget field980;
   @ObfuscatedName("kv")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   static Widget field1028;
   @ObfuscatedName("kf")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   static Widget field1029;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -2041582453
   )
   static int field925;

   static {
      field902 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field881 = true;
      gameCycle = 0;
      mouseLastLastPressedTimeMillis = 1L;
      field884 = -1;
      field1021 = -1;
      field1030 = -1;
      field887 = true;
      displayFps = false;
      field889 = 0;
      hintArrowTargetType = 0;
      hintArrowNpcTargetIdx = 0;
      hintArrowPlayerTargetIdx = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowType = 0;
      hintArrowOffsetX = 0;
      hintArrowOffsetY = 0;
      playerAttackOption = AttackOption.AttackOption_hidden;
      npcAttackOption = AttackOption.AttackOption_hidden;
      loadingStage = 0;
      js5State = 0;
      field886 = 0;
      field1075 = 0;
      loginState = 0;
      field905 = 0;
      field906 = 0;
      field907 = 0;
      field908 = class150.field2107;
      field1121 = null;
      cachedNPCs = new NPC['耀'];
      npcIndexesCount = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      field915 = new NetWriter();
      field1084 = 0;
      socketError = false;
      field918 = true;
      field894 = new class287();
      fontsMap = new HashMap();
      field921 = 0;
      field922 = 1;
      field923 = 0;
      field924 = 1;
      field1052 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field1118 = new int[4][13][13];
      field930 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field944 = 0;
      field1087 = 2301979;
      field933 = 5063219;
      field1008 = 3353893;
      field935 = 7759444;
      field936 = false;
      field937 = 0;
      field1092 = 128;
      mapAngle = 0;
      field1079 = 0;
      field941 = 0;
      field891 = 0;
      field996 = 0;
      field1023 = 50;
      field1119 = 0;
      field1102 = false;
      field947 = 0;
      overheadTextCount = 0;
      maxOverheadTexts = 50;
      overheadTextsX = new int[maxOverheadTexts];
      overheadTextsY = new int[maxOverheadTexts];
      overheadTextsOffsetY = new int[maxOverheadTexts];
      overheadTextsOffsetX = new int[maxOverheadTexts];
      field1114 = new int[maxOverheadTexts];
      field955 = new int[maxOverheadTexts];
      overheadTextsCyclesRemaining = new int[maxOverheadTexts];
      overheadTexts = new String[maxOverheadTexts];
      field958 = new int[104][104];
      field919 = 0;
      screenX = -1;
      screenY = -1;
      lastLeftClickX = 0;
      lastLeftClickY = 0;
      field964 = 0;
      cursorState = 0;
      mouseCrosshair = 0;
      pressedItemIndex = 0;
      field968 = 0;
      field969 = 0;
      field970 = 0;
      field1020 = 0;
      itemBeingDragged = false;
      itemPressedDuration = 0;
      myPlayerIndex = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field977 = 0;
      field978 = 0;
      field979 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field943 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field974 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field992 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      menuBooleanArray = new boolean[500];
      field1002 = false;
      field1003 = false;
      field1004 = -1;
      field1005 = -1;
      field1006 = 0;
      field1007 = 50;
      itemSelectionState = 0;
      lastSelectedItemName = null;
      spellSelected = false;
      field917 = -1;
      field909 = -1;
      field1013 = null;
      field1014 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field1017 = 0;
      field1018 = 0;
      field1019 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1047 = -1;
      field983 = false;
      field911 = false;
      numberMenuOptions = false;
      field980 = null;
      field1028 = null;
      field1029 = null;
      field925 = 0;
      field1001 = 0;
      field1032 = null;
      field1033 = false;
      field1034 = -1;
      field1035 = -1;
      field1036 = false;
      field1095 = -1;
      field1038 = -1;
      field1039 = false;
      cycleCntr = 1;
      field984 = new int[32];
      field1042 = 0;
      interfaceItemTriggers = new int[32];
      field1044 = 0;
      field1093 = new int[32];
      field1045 = 0;
      chatCycle = 0;
      field880 = 0;
      field1049 = 0;
      field1050 = 0;
      field1051 = 0;
      field951 = 0;
      mouseWheelRotation = 0;
      field1054 = new Deque();
      field1055 = new Deque();
      field1056 = new Deque();
      widgetFlags = new HashTable(512);
      widgetCount = 0;
      field1059 = -2;
      field1041 = new boolean[100];
      field1061 = new boolean[100];
      field975 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1068 = 0L;
      isResized = true;
      field1070 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      publicChatMode = 0;
      field1072 = 0;
      field885 = "";
      field1074 = new long[100];
      field959 = 0;
      field1076 = 0;
      field876 = new int[128];
      field1078 = new int[128];
      field897 = -1L;
      clanChatOwner = null;
      clanChatName = null;
      field1082 = -1;
      field1083 = 0;
      field1088 = new int[1000];
      field1085 = new int[1000];
      mapIcons = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1089 = 0;
      field1090 = 255;
      field1091 = -1;
      field991 = false;
      field903 = 127;
      field1094 = 127;
      field1025 = 0;
      field1096 = new int[50];
      field1027 = new int[50];
      field1098 = new int[50];
      field1099 = new int[50];
      audioEffects = new SoundEffect[50];
      field1101 = false;
      field1097 = new boolean[5];
      field929 = new int[5];
      field1104 = new int[5];
      field1105 = new int[5];
      field1043 = new int[5];
      field1107 = 256;
      field1108 = 205;
      field1046 = 256;
      field1110 = 320;
      field1111 = 1;
      field1112 = 32767;
      field1113 = 1;
      field948 = 32767;
      Viewport_xOffset = 0;
      Viewport_yOffset = 0;
      viewportHeight = 0;
      viewportWidth = 0;
      scale = 0;
      friendCount = 0;
      field1077 = 0;
      friends = new Friend[400];
      field1123 = new class206();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1126 = new PlayerComposition();
      field1060 = -1;
      field1128 = -1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field1130 = new OwnWorldComparator();
      field1131 = new class72();
      field1132 = new int[50];
      field1133 = new int[50];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "41"
   )
   protected final void vmethod1214() {
      field1068 = class60.currentTimeMs() + 500L;
      this.method1186();
      if(widgetRoot != -1) {
         this.method1377(true);
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-987954535"
   )
   @Export("setUp")
   protected final void setUp() {
      int[] var1 = new int[]{20, 260, 10000};
      int[] var2 = new int[]{1000, 100, 500};
      int var3;
      if(var1 != null && var2 != null) {
         Frames.field2042 = var1;
         class185.field2541 = new int[var1.length];
         class254.field3404 = new byte[var1.length][][];

         for(var3 = 0; var3 < Frames.field2042.length; ++var3) {
            class254.field3404[var3] = new byte[var2[var3]][];
         }
      } else {
         Frames.field2042 = null;
         class185.field2541 = null;
         class254.field3404 = null;
      }

      Frames.port1 = socketType == 0?43594:world + 40000;
      class150.port2 = socketType == 0?443:world + 50000;
      class179.myWorldPort = Frames.port1;
      MilliTimer.colorsToFind = class225.field2745;
      Huffman.colorsToReplace = class225.field2741;
      Frames.field2043 = class225.field2742;
      Item.field1399 = class225.field2743;
      Signlink.urlRequester = new UrlRequester();
      this.setUpKeyboard();
      this.setUpMouse();
      ScriptEvent.mouseWheel = this.mouseWheel();
      class44.indexStore255 = new IndexFile(255, class157.dat2File, class157.idx255File, 500000);
      class222.preferences = class173.method3248();
      this.setUpClipboard();
      ClanMember.method1172(this, Occluder.field2048);
      if(socketType != 0) {
         displayFps = true;
      }

      var3 = class222.preferences.screenType;
      field1068 = 0L;
      if(var3 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      if(class43.method612() == 1) {
         class160.clientInstance.method832(765, 503);
      } else {
         class160.clientInstance.method832(7680, 2160);
      }

      if(gameState >= 25) {
         ISAACCipher.method3638();
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1066705400"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();
      WallObject.method2930();
      NPCComposition.method4826();
      FontName.method4928();
      KeyFocusListener var1 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field600 = KeyFocusListener.field618;
         KeyFocusListener.field615 = 0;
         int var2;
         if(KeyFocusListener.field611 >= 0) {
            while(KeyFocusListener.field610 != KeyFocusListener.field611) {
               var2 = KeyFocusListener.field604[KeyFocusListener.field610];
               KeyFocusListener.field610 = KeyFocusListener.field610 + 1 & 127;
               if(var2 < 0) {
                  KeyFocusListener.keyPressed[~var2] = false;
               } else {
                  if(!KeyFocusListener.keyPressed[var2] && KeyFocusListener.field615 < KeyFocusListener.field614.length - 1) {
                     KeyFocusListener.field614[++KeyFocusListener.field615 - 1] = var2;
                  }

                  KeyFocusListener.keyPressed[var2] = true;
               }
            }
         } else {
            for(var2 = 0; var2 < 112; ++var2) {
               KeyFocusListener.keyPressed[var2] = false;
            }

            KeyFocusListener.field611 = KeyFocusListener.field610;
         }

         if(KeyFocusListener.field615 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field618 = KeyFocusListener.field595;
      }

      Size.processMouseInput();
      if(ScriptEvent.mouseWheel != null) {
         int var4 = ScriptEvent.mouseWheel.useRotation();
         mouseWheelRotation = var4;
      }

      if(gameState == 0) {
         class46.load();
         IndexDataBase.method4323();
      } else if(gameState == 5) {
         class81.method1640(this);
         class46.load();
         IndexDataBase.method4323();
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class81.method1640(this);
            this.method1183();
         } else if(gameState == 25) {
            CombatInfoListHolder.method1707();
         }
      } else {
         class81.method1640(this);
      }

      if(gameState == 30) {
         this.method1184();
      } else if(gameState == 40 || gameState == 45) {
         this.method1183();
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1982006370"
   )
   @Hook("clientMainLoop")
   @Export("methodDraw")
   protected final void methodDraw(boolean var1) {
      boolean var2 = GroundObject.method2559();
      if(var2 && field991 && Renderable.soundSystem0 != null) {
         Renderable.soundSystem0.tryFlush();
      }

      int var3;
      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field1068 && class60.currentTimeMs() > field1068) {
         var3 = class43.method612();
         field1068 = 0L;
         if(var3 >= 2) {
            isResized = true;
         } else {
            isResized = false;
         }

         if(class43.method612() == 1) {
            class160.clientInstance.method832(765, 503);
         } else {
            class160.clientInstance.method832(7680, 2160);
         }

         if(gameState >= 25) {
            ISAACCipher.method3638();
         }
      }

      if(var1) {
         for(var3 = 0; var3 < 100; ++var3) {
            field1041[var3] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class91.loadingBarPercentage, class91.loadingText, var1);
      } else if(gameState == 5) {
         class188.drawLoginScreen(class36.fontBold12, FileRequest.fontPlain11, CombatInfo1.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class188.drawLoginScreen(class36.fontBold12, FileRequest.fontPlain11, CombatInfo1.font_p12full, var1);
         } else if(gameState == 25) {
            if(field1052 == 1) {
               if(field921 > field922) {
                  field922 = field921;
               }

               var3 = (field922 * 50 - field921 * 50) / field922;
               GrandExchangeEvents.drawStatusBox("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else if(field1052 == 2) {
               if(field923 > field924) {
                  field924 = field923;
               }

               var3 = (field924 * 50 - field923 * 50) / field924 + 50;
               GrandExchangeEvents.drawStatusBox("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else {
               GrandExchangeEvents.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1187();
         } else if(gameState == 40) {
            GrandExchangeEvents.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            GrandExchangeEvents.drawStatusBox("Please wait...", false);
         }
      } else {
         class188.drawLoginScreen(class36.fontBold12, FileRequest.fontPlain11, CombatInfo1.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var3 = 0; var3 < widgetCount; ++var3) {
            if(field1061[var3]) {
               class35.rasterProvider.draw(widgetPositionX[var3], widgetPositionY[var3], widgetBoundsWidth[var3], widgetBoundsHeight[var3]);
               field1061[var3] = false;
            }
         }
      } else if(gameState > 0) {
         class35.rasterProvider.drawFull(0, 0);

         for(var3 = 0; var3 < widgetCount; ++var3) {
            field1061[var3] = false;
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected final void vmethod1179() {
      if(class159.chatMessages.changed()) {
         class159.chatMessages.serialize();
      }

      if(UrlRequester.mouseRecorder != null) {
         UrlRequester.mouseRecorder.isRunning = false;
      }

      UrlRequester.mouseRecorder = null;
      field915.close();
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var1 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

      if(MouseInput.mouse != null) {
         MouseInput var9 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

      ScriptEvent.mouseWheel = null;
      if(Renderable.soundSystem0 != null) {
         Renderable.soundSystem0.shutdown();
      }

      if(UrlRequester.soundSystem1 != null) {
         UrlRequester.soundSystem1.shutdown();
      }

      PacketNode.method3249();
      Object var10 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3328 != 0) {
            IndexStoreActionHandler.field3328 = 1;

            try {
               IndexStoreActionHandler.IndexStoreActionHandler_lock.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      if(Signlink.urlRequester != null) {
         Signlink.urlRequester.close();
         Signlink.urlRequester = null;
      }

      NPCComposition.method4863();
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "116"
   )
   protected final void vmethod1174() {
   }

   @Export("init")
   @ObfuscatedName("init")
   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = Buffer.method3527();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Parameters var3 = var1[var2];
            String var4 = this.getParameter(var3.key);
            if(var4 != null) {
               switch(Integer.parseInt(var3.key)) {
               case 2:
                  MessageNode.sessionToken = var4;
                  break;
               case 3:
                  socketType = Integer.parseInt(var4);
                  break;
               case 4:
                  world = Integer.parseInt(var4);
                  break;
               case 5:
                  class3.field18 = (JagexGame)class34.forOrdinal(class150.method2990(), Integer.parseInt(var4));
                  if(class3.field18 == JagexGame.field3290) {
                     GrandExchangeOffer.jagexLoginType = JagexLoginType.field3935;
                  } else {
                     GrandExchangeOffer.jagexLoginType = JagexLoginType.field3933;
                  }
                  break;
               case 6:
                  int var6 = Integer.parseInt(var4);
                  BuildType[] var7 = DecorativeObject.method2963();
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

                  field875 = var5;
                  break;
               case 7:
                  class19.field312 = Integer.parseInt(var4);
                  break;
               case 8:
                  class192.field2566 = Integer.parseInt(var4);
               case 9:
               case 10:
               default:
                  break;
               case 11:
                  languageId = Integer.parseInt(var4);
                  break;
               case 12:
                  flags = Integer.parseInt(var4);
                  break;
               case 13:
                  field918 = Integer.parseInt(var4) != 0;
                  break;
               case 14:
                  UnitPriceComparator.field303 = var4;
                  break;
               case 15:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 16:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
               }
            }
         }

         Region.lowMemory = false;
         lowMemory = false;
         class161.host = this.getCodeBase().getHost();
         String var11 = field875.identifier;
         byte var12 = 0;

         try {
            WorldMapType2.method520("oldschool", var11, var12, 17);
         } catch (Exception var10) {
            Bounds.method5132((String)null, var10);
         }

         class160.clientInstance = this;
         this.initialize(765, 503, 161);
      }
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1577755025"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         long var2 = class60.currentTimeMs();
         int var4 = (int)(var2 - class249.field3346);
         class249.field3346 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class249.field3359 += var4;
         boolean var1;
         if(class249.NetCache_pendingResponsesCount == 0 && class249.NetCache_pendingPriorityResponsesCount == 0 && class249.NetCache_pendingWritesCount == 0 && class249.NetCache_pendingPriorityWritesCount == 0) {
            var1 = true;
         } else if(class249.NetCache_socket == null) {
            var1 = false;
         } else {
            try {
               label240: {
                  if(class249.field3359 > 30000) {
                     throw new IOException();
                  }

                  FileRequest var5;
                  Buffer var6;
                  while(class249.NetCache_pendingPriorityResponsesCount < 20 && class249.NetCache_pendingPriorityWritesCount > 0) {
                     var5 = (FileRequest)class249.NetCache_pendingPriorityWrites.first();
                     var6 = new Buffer(4);
                     var6.putByte(1);
                     var6.put24bitInt((int)var5.hash);
                     class249.NetCache_socket.vmethod3166(var6.payload, 0, 4);
                     class249.NetCache_pendingPriorityResponses.put(var5, var5.hash);
                     --class249.NetCache_pendingPriorityWritesCount;
                     ++class249.NetCache_pendingPriorityResponsesCount;
                  }

                  while(class249.NetCache_pendingResponsesCount < 20 && class249.NetCache_pendingWritesCount > 0) {
                     var5 = (FileRequest)class249.NetCache_pendingWritesQueue.peek();
                     var6 = new Buffer(4);
                     var6.putByte(0);
                     var6.put24bitInt((int)var5.hash);
                     class249.NetCache_socket.vmethod3166(var6.payload, 0, 4);
                     var5.unlinkDual();
                     class249.NetCache_pendingResponses.put(var5, var5.hash);
                     --class249.NetCache_pendingWritesCount;
                     ++class249.NetCache_pendingResponsesCount;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class249.NetCache_socket.vmethod3138();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class249.field3359 = 0;
                     byte var7 = 0;
                     if(class29.currentRequest == null) {
                        var7 = 8;
                     } else if(class249.field3360 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class249.NetCache_responseHeaderBuffer.offset;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class249.NetCache_socket.vmethod3148(class249.NetCache_responseHeaderBuffer.payload, class249.NetCache_responseHeaderBuffer.offset, var8);
                        if(class249.field3364 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class249.NetCache_responseHeaderBuffer.payload[class249.NetCache_responseHeaderBuffer.offset + var9] ^= class249.field3364;
                           }
                        }

                        class249.NetCache_responseHeaderBuffer.offset += var8;
                        if(class249.NetCache_responseHeaderBuffer.offset < var7) {
                           break;
                        }

                        if(class29.currentRequest == null) {
                           class249.NetCache_responseHeaderBuffer.offset = 0;
                           var9 = class249.NetCache_responseHeaderBuffer.readUnsignedByte();
                           var10 = class249.NetCache_responseHeaderBuffer.readUnsignedShort();
                           int var11 = class249.NetCache_responseHeaderBuffer.readUnsignedByte();
                           var12 = class249.NetCache_responseHeaderBuffer.readInt();
                           long var13 = (long)(var10 + (var9 << 16));
                           FileRequest var15 = (FileRequest)class249.NetCache_pendingPriorityResponses.get(var13);
                           TotalQuantityComparator.field286 = true;
                           if(var15 == null) {
                              var15 = (FileRequest)class249.NetCache_pendingResponses.get(var13);
                              TotalQuantityComparator.field286 = false;
                           }

                           if(var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class29.currentRequest = var15;
                           class231.NetCache_responseArchiveBuffer = new Buffer(var16 + var12 + class29.currentRequest.padding);
                           class231.NetCache_responseArchiveBuffer.putByte(var11);
                           class231.NetCache_responseArchiveBuffer.putInt(var12);
                           class249.field3360 = 8;
                           class249.NetCache_responseHeaderBuffer.offset = 0;
                        } else if(class249.field3360 == 0) {
                           if(class249.NetCache_responseHeaderBuffer.payload[0] == -1) {
                              class249.field3360 = 1;
                              class249.NetCache_responseHeaderBuffer.offset = 0;
                           } else {
                              class29.currentRequest = null;
                           }
                        }
                     } else {
                        var8 = class231.NetCache_responseArchiveBuffer.payload.length - class29.currentRequest.padding;
                        var9 = 512 - class249.field3360;
                        if(var9 > var8 - class231.NetCache_responseArchiveBuffer.offset) {
                           var9 = var8 - class231.NetCache_responseArchiveBuffer.offset;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class249.NetCache_socket.vmethod3148(class231.NetCache_responseArchiveBuffer.payload, class231.NetCache_responseArchiveBuffer.offset, var9);
                        if(class249.field3364 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class231.NetCache_responseArchiveBuffer.payload[var10 + class231.NetCache_responseArchiveBuffer.offset] ^= class249.field3364;
                           }
                        }

                        class231.NetCache_responseArchiveBuffer.offset += var9;
                        class249.field3360 += var9;
                        if(var8 == class231.NetCache_responseArchiveBuffer.offset) {
                           if(class29.currentRequest.hash == 16711935L) {
                              CombatInfoListHolder.NetCache_reference = class231.NetCache_responseArchiveBuffer;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 IndexData var19 = class249.NetCache_indexCaches[var10];
                                 if(var19 != null) {
                                    CombatInfoListHolder.NetCache_reference.offset = var10 * 8 + 5;
                                    var12 = CombatInfoListHolder.NetCache_reference.readInt();
                                    int var20 = CombatInfoListHolder.NetCache_reference.readInt();
                                    var19.setInformation(var12, var20);
                                 }
                              }
                           } else {
                              class249.NetCache_crc.reset();
                              class249.NetCache_crc.update(class231.NetCache_responseArchiveBuffer.payload, 0, var8);
                              var10 = (int)class249.NetCache_crc.getValue();
                              if(var10 != class29.currentRequest.crc) {
                                 try {
                                    class249.NetCache_socket.vmethod3136();
                                 } catch (Exception var23) {
                                    ;
                                 }

                                 ++class249.field3361;
                                 class249.NetCache_socket = null;
                                 class249.field3364 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label240;
                              }

                              class249.field3361 = 0;
                              class249.field3362 = 0;
                              class29.currentRequest.index.write((int)(class29.currentRequest.hash & 65535L), class231.NetCache_responseArchiveBuffer.payload, 16711680L == (class29.currentRequest.hash & 16711680L), TotalQuantityComparator.field286);
                           }

                           class29.currentRequest.unlink();
                           if(TotalQuantityComparator.field286) {
                              --class249.NetCache_pendingPriorityResponsesCount;
                           } else {
                              --class249.NetCache_pendingResponsesCount;
                           }

                           class249.field3360 = 0;
                           class29.currentRequest = null;
                           class231.NetCache_responseArchiveBuffer = null;
                        } else {
                           if(class249.field3360 != 512) {
                              break;
                           }

                           class249.field3360 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var24) {
               try {
                  class249.NetCache_socket.vmethod3136();
               } catch (Exception var22) {
                  ;
               }

               ++class249.field3362;
               class249.NetCache_socket = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method1181();
         }

      }
   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "346958247"
   )
   void method1181() {
      if(class249.field3361 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class249.field3362 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field886 = 3000;
            class249.field3362 = 3;
         }

         if(--field886 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  class153.socket = class179.taskManager.createSocket(class161.host, class179.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(class153.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(class153.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  if(field918) {
                     class25.rssocket = TextureProvider.method2448((Socket)class153.socket.value, 40000, 5000);
                  } else {
                     class25.rssocket = new class163((Socket)class153.socket.value, class179.taskManager, 5000);
                  }

                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(161);
                  class25.rssocket.vmethod3166(var1.payload, 0, 5);
                  ++js5State;
                  class33.field452 = class60.currentTimeMs();
               }

               if(js5State == 3) {
                  if(class25.rssocket.vmethod3138() > 0 || !field918 && gameState <= 5) {
                     int var2 = class25.rssocket.vmethod3167();
                     if(var2 != 0) {
                        this.error(var2);
                        return;
                     }

                     ++js5State;
                  } else if(class60.currentTimeMs() - class33.field452 > 30000L) {
                     this.error(-2);
                     return;
                  }
               }

               if(js5State == 4) {
                  WorldMapData.method340(class25.rssocket, gameState > 20);
                  class153.socket = null;
                  class25.rssocket = null;
                  js5State = 0;
                  field1075 = 0;
               }
            } catch (IOException var3) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-17"
   )
   @Export("error")
   void error(int var1) {
      class153.socket = null;
      class25.rssocket = null;
      js5State = 0;
      if(Frames.port1 == class179.myWorldPort) {
         class179.myWorldPort = class150.port2;
      } else {
         class179.myWorldPort = Frames.port1;
      }

      ++field1075;
      if(field1075 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field886 = 3000;
         }
      } else if(field1075 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field1075 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field886 = 3000;
         }
      }

   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1231789495"
   )
   final void method1183() {
      Object var1 = field915.getSocket();
      PacketBuffer var2 = field915.packetBuffer;

      try {
         if(loginState == 0) {
            if(var1 != null) {
               ((class159)var1).vmethod3136();
               var1 = null;
            }

            WorldMapType2.field501 = null;
            socketError = false;
            field905 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(WorldMapType2.field501 == null) {
               WorldMapType2.field501 = class179.taskManager.createSocket(class161.host, class179.myWorldPort);
            }

            if(WorldMapType2.field501.status == 2) {
               throw new IOException();
            }

            if(WorldMapType2.field501.status == 1) {
               if(field918) {
                  var1 = TextureProvider.method2448((Socket)WorldMapType2.field501.value, 40000, 5000);
               } else {
                  var1 = new class163((Socket)WorldMapType2.field501.value, class179.taskManager, 5000);
               }

               field915.setSocket((class159)var1);
               WorldMapType2.field501 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            field915.method1911();
            PacketNode var4;
            if(PacketNode.field2453 == 0) {
               var4 = new PacketNode();
            } else {
               var4 = PacketNode.packetBufferNodes[--PacketNode.field2453];
            }

            var4.clientPacket = null;
            var4.field2448 = 0;
            var4.packetBuffer = new PacketBuffer(5000);
            var4.packetBuffer.putByte(LoginPacket.field2432.id);
            field915.method1898(var4);
            field915.method1900();
            var2.offset = 0;
            loginState = 3;
         }

         boolean var12;
         int var13;
         if(loginState == 3) {
            if(Renderable.soundSystem0 != null) {
               Renderable.soundSystem0.method2065();
            }

            if(UrlRequester.soundSystem1 != null) {
               UrlRequester.soundSystem1.method2065();
            }

            var12 = true;
            if(field918 && !((class159)var1).vmethod3153(1)) {
               var12 = false;
            }

            if(var12) {
               var13 = ((class159)var1).vmethod3167();
               if(Renderable.soundSystem0 != null) {
                  Renderable.soundSystem0.method2065();
               }

               if(UrlRequester.soundSystem1 != null) {
                  UrlRequester.soundSystem1.method2065();
               }

               if(var13 != 0) {
                  BoundingBox3D.method52(var13);
                  return;
               }

               var2.offset = 0;
               loginState = 4;
            }
         }

         int var31;
         if(loginState == 4) {
            if(var2.offset < 8) {
               var31 = ((class159)var1).vmethod3138();
               if(var31 > 8 - var2.offset) {
                  var31 = 8 - var2.offset;
               }

               if(var31 > 0) {
                  ((class159)var1).vmethod3148(var2.payload, var2.offset, var31);
                  var2.offset += var31;
               }
            }

            if(var2.offset == 8) {
               var2.offset = 0;
               SceneTilePaint.field1945 = var2.readLong();
               loginState = 5;
            }
         }

         int var7;
         int var9;
         int var15;
         if(loginState == 5) {
            field915.packetBuffer.offset = 0;
            field915.method1911();
            PacketBuffer var3 = new PacketBuffer(500);
            int[] var23 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(SceneTilePaint.field1945 >> 32), (int)(SceneTilePaint.field1945 & -1L)};
            var3.offset = 0;
            var3.putByte(1);
            var3.putByte(field908.rsOrdinal());
            var3.putInt(var23[0]);
            var3.putInt(var23[1]);
            var3.putInt(var23[2]);
            var3.putInt(var23[3]);
            int var11;
            switch(field908.field2109) {
            case 0:
               LinkedHashMap var6 = class222.preferences.preferences;
               String var8 = class91.username;
               var9 = var8.length();
               int var10 = 0;

               for(var11 = 0; var11 < var9; ++var11) {
                  var10 = (var10 << 5) - var10 + var8.charAt(var11);
               }

               var3.putInt(((Integer)var6.get(Integer.valueOf(var10))).intValue());
               var3.offset += 4;
               break;
            case 1:
               var3.offset += 8;
               break;
            case 2:
            case 3:
               var3.put24bitInt(class249.field3363);
               var3.offset += 5;
            }

            var3.putString(class91.password);
            var3.encryptRsa(class89.field1326, class89.field1325);
            PacketNode var28;
            if(PacketNode.field2453 == 0) {
               var28 = new PacketNode();
            } else {
               var28 = PacketNode.packetBufferNodes[--PacketNode.field2453];
            }

            var28.clientPacket = null;
            var28.field2448 = 0;
            var28.packetBuffer = new PacketBuffer(5000);
            var28.packetBuffer.offset = 0;
            if(gameState == 40) {
               var28.packetBuffer.putByte(LoginPacket.field2428.id);
            } else {
               var28.packetBuffer.putByte(LoginPacket.field2430.id);
            }

            var28.packetBuffer.putShort(0);
            var7 = var28.packetBuffer.offset;
            var28.packetBuffer.putInt(161);
            var28.packetBuffer.putBytes(var3.payload, 0, var3.offset);
            var15 = var28.packetBuffer.offset;
            var28.packetBuffer.putString(class91.username);
            var28.packetBuffer.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            var28.packetBuffer.putShort(class87.canvasWidth);
            var28.packetBuffer.putShort(class25.canvasHeight);
            PacketBuffer var16 = var28.packetBuffer;
            if(field1121 != null) {
               var16.putBytes(field1121, 0, field1121.length);
            } else {
               byte[] var17 = BoundingBox.method46();
               var16.putBytes(var17, 0, var17.length);
            }

            var28.packetBuffer.putString(MessageNode.sessionToken);
            var28.packetBuffer.putInt(class19.field312);
            Buffer var33 = new Buffer(GameSocket.platformInfo.method5610());
            GameSocket.platformInfo.method5612(var33);
            var28.packetBuffer.putBytes(var33.payload, 0, var33.payload.length);
            var28.packetBuffer.putByte(class192.field2566);
            var28.packetBuffer.putInt(0);
            var28.packetBuffer.putInt(CombatInfoListHolder.indexInterfaces.crc);
            var28.packetBuffer.putInt(class139.indexSoundEffects.crc);
            var28.packetBuffer.putInt(class215.configsIndex.crc);
            var28.packetBuffer.putInt(class46.indexCache3.crc);
            var28.packetBuffer.putInt(class19.indexCache4.crc);
            var28.packetBuffer.putInt(ScriptState.indexMaps.crc);
            var28.packetBuffer.putInt(Size.indexTrack1.crc);
            var28.packetBuffer.putInt(MouseInput.indexModels.crc);
            var28.packetBuffer.putInt(Renderable.indexSprites.crc);
            var28.packetBuffer.putInt(class3.indexTextures.crc);
            var28.packetBuffer.putInt(MouseInput.indexCache10.crc);
            var28.packetBuffer.putInt(RunException.indexTrack2.crc);
            var28.packetBuffer.putInt(Timer.indexScripts.crc);
            var28.packetBuffer.putInt(class64.indexCache13.crc);
            var28.packetBuffer.putInt(class44.vorbisIndex.crc);
            var28.packetBuffer.putInt(class31.indexCache15.crc);
            var28.packetBuffer.putInt(GameCanvas.indexWorldMap.crc);
            var28.packetBuffer.encryptXtea(var23, var15, var28.packetBuffer.offset);
            var28.packetBuffer.method3331(var28.packetBuffer.offset - var7);
            field915.method1898(var28);
            field915.method1900();
            field915.field1462 = new ISAACCipher(var23);

            for(var11 = 0; var11 < 4; ++var11) {
               var23[var11] += 50;
            }

            var2.seed(var23);
            loginState = 6;
         }

         if(loginState == 6 && ((class159)var1).vmethod3138() > 0) {
            var31 = ((class159)var1).vmethod3167();
            if(var31 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var31 == 2) {
               loginState = 9;
            } else if(var31 == 15 && gameState == 40) {
               field915.packetLength = -1;
               loginState = 13;
            } else if(var31 == 23 && field906 < 1) {
               ++field906;
               loginState = 0;
            } else {
               if(var31 != 29) {
                  BoundingBox3D.method52(var31);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && ((class159)var1).vmethod3138() > 0) {
            field907 = (((class159)var1).vmethod3167() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field905 = 0;
            ClanMember.method1170("You have only just left another world.", "Your profile will be transferred in:", field907 / 60 + " seconds.");
            if(--field907 <= 0) {
               loginState = 0;
            }

         } else {
            boolean var32;
            if(loginState == 9 && ((class159)var1).vmethod3138() >= 13) {
               var12 = ((class159)var1).vmethod3167() == 1;
               ((class159)var1).vmethod3148(var2.payload, 0, 4);
               var2.offset = 0;
               var32 = false;
               if(var12) {
                  var13 = var2.readOpcode() << 24;
                  var13 |= var2.readOpcode() << 16;
                  var13 |= var2.readOpcode() << 8;
                  var13 |= var2.readOpcode();
                  String var29 = class91.username;
                  var7 = var29.length();
                  var15 = 0;
                  var9 = 0;

                  while(true) {
                     if(var9 >= var7) {
                        if(class222.preferences.preferences.size() >= 10 && !class222.preferences.preferences.containsKey(Integer.valueOf(var15))) {
                           Iterator var30 = class222.preferences.preferences.entrySet().iterator();
                           var30.next();
                           var30.remove();
                        }

                        class222.preferences.preferences.put(Integer.valueOf(var15), Integer.valueOf(var13));
                        break;
                     }

                     var15 = (var15 << 5) - var15 + var29.charAt(var9);
                     ++var9;
                  }
               }

               if(class91.Login_isUsernameRemembered) {
                  class222.preferences.rememberedUsername = class91.username;
               } else {
                  class222.preferences.rememberedUsername = null;
               }

               World.method1616();
               rights = ((class159)var1).vmethod3167();
               field983 = ((class159)var1).vmethod3167() == 1;
               localInteractingIndex = ((class159)var1).vmethod3167();
               localInteractingIndex <<= 8;
               localInteractingIndex += ((class159)var1).vmethod3167();
               field977 = ((class159)var1).vmethod3167();
               ((class159)var1).vmethod3148(var2.payload, 0, 1);
               var2.offset = 0;
               ServerPacket[] var5 = new ServerPacket[]{ServerPacket.field2306, ServerPacket.field2301, ServerPacket.field2258, ServerPacket.field2250, ServerPacket.field2247, ServerPacket.field2252, ServerPacket.field2251, ServerPacket.field2326, ServerPacket.field2255, ServerPacket.field2256, ServerPacket.field2257, ServerPacket.field2254, ServerPacket.field2259, ServerPacket.field2260, ServerPacket.field2311, ServerPacket.field2262, ServerPacket.field2294, ServerPacket.field2264, ServerPacket.field2273, ServerPacket.field2266, ServerPacket.field2267, ServerPacket.field2268, ServerPacket.field2269, ServerPacket.field2270, ServerPacket.field2271, ServerPacket.field2272, ServerPacket.field2286, ServerPacket.field2274, ServerPacket.field2275, ServerPacket.field2296, ServerPacket.field2277, ServerPacket.field2278, ServerPacket.field2279, ServerPacket.field2280, ServerPacket.field2281, ServerPacket.field2282, ServerPacket.field2283, ServerPacket.field2303, ServerPacket.field2285, ServerPacket.field2317, ServerPacket.field2287, ServerPacket.field2288, ServerPacket.field2289, ServerPacket.field2290, ServerPacket.field2304, ServerPacket.field2292, ServerPacket.field2276, ServerPacket.field2253, ServerPacket.field2295, ServerPacket.field2307, ServerPacket.field2297, ServerPacket.field2298, ServerPacket.field2299, ServerPacket.field2263, ServerPacket.field2293, ServerPacket.field2302, ServerPacket.field2248, ServerPacket.field2249, ServerPacket.field2305, ServerPacket.field2320, ServerPacket.field2265, ServerPacket.field2308, ServerPacket.field2309, ServerPacket.field2310, ServerPacket.field2318, ServerPacket.field2312, ServerPacket.field2313, ServerPacket.field2314, ServerPacket.field2315, ServerPacket.field2316, ServerPacket.field2300, ServerPacket.field2291, ServerPacket.field2319, ServerPacket.field2261, ServerPacket.field2321, ServerPacket.field2322, ServerPacket.field2323, ServerPacket.field2324, ServerPacket.field2325, ServerPacket.field2284, ServerPacket.field2327};
               var7 = var2.method3610();
               if(var7 < 0 || var7 >= var5.length) {
                  throw new IOException(var7 + " " + var2.offset);
               }

               field915.serverPacket = var5[var7];
               field915.packetLength = field915.serverPacket.packetLength;
               ((class159)var1).vmethod3148(var2.payload, 0, 2);
               var2.offset = 0;
               field915.packetLength = var2.readUnsignedShort();

               try {
                  class52.method766(class160.clientInstance, "zap");
               } catch (Throwable var19) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(((class159)var1).vmethod3138() >= field915.packetLength) {
                  var2.offset = 0;
                  ((class159)var1).vmethod3148(var2.payload, 0, field915.packetLength);
                  field894.method5099();
                  mouseLastLastPressedTimeMillis = 1L;
                  field1030 = -1;
                  UrlRequester.mouseRecorder.index = 0;
                  Buffer.field2533 = true;
                  field887 = true;
                  field897 = -1L;
                  class277.method5058();
                  field915.method1911();
                  field915.packetBuffer.offset = 0;
                  field915.serverPacket = null;
                  field915.field1459 = null;
                  field915.field1470 = null;
                  field915.field1467 = null;
                  field915.packetLength = 0;
                  field915.field1465 = 0;
                  field889 = 0;
                  field1084 = 0;
                  hintArrowTargetType = 0;
                  NPCComposition.method4864();
                  FileRequest.method4301(0);
                  class96.chatLineMap.clear();
                  class96.messages.clear();
                  class96.field1424.clear();
                  class96.field1427 = 0;
                  itemSelectionState = 0;
                  spellSelected = false;
                  field1025 = 0;
                  mapAngle = 0;
                  field1089 = 0;
                  field1082 = -1;
                  destinationX = 0;
                  destinationY = 0;
                  playerAttackOption = AttackOption.AttackOption_hidden;
                  npcAttackOption = AttackOption.AttackOption_hidden;
                  npcIndexesCount = 0;
                  class94.playerIndexesCount = 0;

                  for(var31 = 0; var31 < 2048; ++var31) {
                     class94.field1404[var31] = null;
                     class94.field1401[var31] = 1;
                  }

                  for(var31 = 0; var31 < 2048; ++var31) {
                     cachedPlayers[var31] = null;
                  }

                  for(var31 = 0; var31 < 32768; ++var31) {
                     cachedNPCs[var31] = null;
                  }

                  field974 = -1;
                  projectiles.clear();
                  graphicsObjectDeque.clear();

                  int var18;
                  for(var31 = 0; var31 < 4; ++var31) {
                     for(var13 = 0; var13 < 104; ++var13) {
                        for(var18 = 0; var18 < 104; ++var18) {
                           groundItemDeque[var31][var13][var18] = null;
                        }
                     }
                  }

                  pendingSpawns = new Deque();
                  field1077 = 0;
                  friendCount = 0;
                  ignoreCount = 0;

                  for(var31 = 0; var31 < VarPlayerType.field3378; ++var31) {
                     VarPlayerType var27 = ContextMenuRow.method1742(var31);
                     if(var27 != null) {
                        class222.settings[var31] = 0;
                        class222.widgetSettings[var31] = 0;
                     }
                  }

                  class159.chatMessages.reset();
                  field1047 = -1;
                  if(widgetRoot != -1) {
                     var31 = widgetRoot;
                     if(var31 != -1 && class254.validInterfaces[var31]) {
                        Widget.widgetIndex.method4319(var31);
                        if(Widget.widgets[var31] != null) {
                           var32 = true;

                           for(var18 = 0; var18 < Widget.widgets[var31].length; ++var18) {
                              if(Widget.widgets[var31][var18] != null) {
                                 if(Widget.widgets[var31][var18].type != 2) {
                                    Widget.widgets[var31][var18] = null;
                                 } else {
                                    var32 = false;
                                 }
                              }
                           }

                           if(var32) {
                              Widget.widgets[var31] = null;
                           }

                           class254.validInterfaces[var31] = false;
                        }
                     }
                  }

                  for(WidgetNode var22 = (WidgetNode)componentTable.first(); var22 != null; var22 = (WidgetNode)componentTable.next()) {
                     class19.method138(var22, true);
                  }

                  widgetRoot = -1;
                  componentTable = new HashTable(8);
                  field1019 = null;
                  NPCComposition.method4864();
                  field1126.method4167((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var31 = 0; var31 < 8; ++var31) {
                     playerOptions[var31] = null;
                     playerOptionsPriorities[var31] = false;
                  }

                  ItemContainer.itemContainers = new HashTable(32);
                  field881 = true;

                  for(var31 = 0; var31 < 100; ++var31) {
                     field1041[var31] = true;
                  }

                  ISAACCipher.method3638();
                  clanChatOwner = null;
                  FileSystem.clanChatCount = 0;
                  AbstractSoundSystem.clanMembers = null;

                  for(var31 = 0; var31 < 8; ++var31) {
                     grandExchangeOffers[var31] = new GrandExchangeOffer();
                  }

                  class18.grandExchangeEvents = null;
                  FontName.initializeGPI(var2);
                  class60.field724 = -1;
                  class61.xteaChanged(false, var2);
                  field915.serverPacket = null;
               }

            } else {
               if(loginState == 11 && ((class159)var1).vmethod3138() >= 2) {
                  var2.offset = 0;
                  ((class159)var1).vmethod3148(var2.payload, 0, 2);
                  var2.offset = 0;
                  MessageNode.field826 = var2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && ((class159)var1).vmethod3138() >= MessageNode.field826) {
                  var2.offset = 0;
                  ((class159)var1).vmethod3148(var2.payload, 0, MessageNode.field826);
                  var2.offset = 0;
                  String var21 = var2.readString();
                  String var24 = var2.readString();
                  String var25 = var2.readString();
                  ClanMember.method1170(var21, var24, var25);
                  ClanMember.setGameState(10);
               }

               if(loginState != 13) {
                  ++field905;
                  if(field905 > 2000) {
                     if(field906 < 1) {
                        if(Frames.port1 == class179.myWorldPort) {
                           class179.myWorldPort = class150.port2;
                        } else {
                           class179.myWorldPort = Frames.port1;
                        }

                        ++field906;
                        loginState = 0;
                     } else {
                        BoundingBox3D.method52(-3);
                     }
                  }
               } else {
                  if(field915.packetLength == -1) {
                     if(((class159)var1).vmethod3138() < 2) {
                        return;
                     }

                     ((class159)var1).vmethod3148(var2.payload, 0, 2);
                     var2.offset = 0;
                     field915.packetLength = var2.readUnsignedShort();
                  }

                  if(((class159)var1).vmethod3138() >= field915.packetLength) {
                     ((class159)var1).vmethod3148(var2.payload, 0, field915.packetLength);
                     var2.offset = 0;
                     var31 = field915.packetLength;
                     field894.method5101();
                     field915.method1911();
                     field915.packetBuffer.offset = 0;
                     field915.serverPacket = null;
                     field915.field1459 = null;
                     field915.field1470 = null;
                     field915.field1467 = null;
                     field915.packetLength = 0;
                     field915.field1465 = 0;
                     field889 = 0;
                     NPCComposition.method4864();
                     field1089 = 0;
                     destinationX = 0;

                     for(var13 = 0; var13 < 2048; ++var13) {
                        cachedPlayers[var13] = null;
                     }

                     GrandExchangeOffer.localPlayer = null;

                     for(var13 = 0; var13 < cachedNPCs.length; ++var13) {
                        NPC var26 = cachedNPCs[var13];
                        if(var26 != null) {
                           var26.interacting = -1;
                           var26.field1176 = false;
                        }
                     }

                     ItemContainer.itemContainers = new HashTable(32);
                     ClanMember.setGameState(30);

                     for(var13 = 0; var13 < 100; ++var13) {
                        field1041[var13] = true;
                     }

                     ISAACCipher.method3638();
                     FontName.initializeGPI(var2);
                     if(var31 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var20) {
         if(field906 < 1) {
            if(Frames.port1 == class179.myWorldPort) {
               class179.myWorldPort = class150.port2;
            } else {
               class179.myWorldPort = Frames.port1;
            }

            ++field906;
            loginState = 0;
         } else {
            BoundingBox3D.method52(-2);
         }
      }
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "77"
   )
   final void method1184() {
      if(field889 > 1) {
         --field889;
      }

      if(field1084 > 0) {
         --field1084;
      }

      if(socketError) {
         socketError = false;
         MouseInput.method1025();
      } else {
         if(!isMenuOpen) {
            NPCComposition.method4864();
            menuOptions[0] = "Cancel";
            menuTargets[0] = "";
            menuTypes[0] = 1006;
            menuBooleanArray[0] = false;
            menuOptionCount = 1;
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method1188(field915); ++var1) {
            ;
         }

         if(gameState == 30) {
            int var2;
            PacketNode var12;
            while(GrandExchangeEvents.method75()) {
               var12 = class235.method4272(ClientPacket.field2330, field915.field1462);
               var12.packetBuffer.putByte(0);
               var2 = var12.packetBuffer.offset;
               Signlink.encodeClassVerifier(var12.packetBuffer);
               var12.packetBuffer.method3332(var12.packetBuffer.offset - var2);
               field915.method1898(var12);
            }

            if(field894.field3802) {
               var12 = class235.method4272(ClientPacket.field2386, field915.field1462);
               var12.packetBuffer.putByte(0);
               var2 = var12.packetBuffer.offset;
               field894.method5095(var12.packetBuffer);
               var12.packetBuffer.method3332(var12.packetBuffer.offset - var2);
               field915.method1898(var12);
               field894.method5100();
            }

            Object var31 = UrlRequester.mouseRecorder.lock;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            synchronized(UrlRequester.mouseRecorder.lock) {
               if(!field902) {
                  UrlRequester.mouseRecorder.index = 0;
               } else if(MouseInput.mouseLastButton != 0 || UrlRequester.mouseRecorder.index >= 40) {
                  PacketNode var13 = class235.method4272(ClientPacket.field2407, field915.field1462);
                  var13.packetBuffer.putByte(0);
                  var3 = var13.packetBuffer.offset;
                  var4 = 0;

                  for(var5 = 0; var5 < UrlRequester.mouseRecorder.index && var13.packetBuffer.offset - var3 < 240; ++var5) {
                     ++var4;
                     var6 = UrlRequester.mouseRecorder.ys[var5];
                     if(var6 < 0) {
                        var6 = 0;
                     } else if(var6 > 502) {
                        var6 = 502;
                     }

                     var7 = UrlRequester.mouseRecorder.xs[var5];
                     if(var7 < 0) {
                        var7 = 0;
                     } else if(var7 > 764) {
                        var7 = 764;
                     }

                     var8 = var7 + var6 * 765;
                     if(UrlRequester.mouseRecorder.ys[var5] == -1 && UrlRequester.mouseRecorder.xs[var5] == -1) {
                        var7 = -1;
                        var6 = -1;
                        var8 = 524287;
                     }

                     if(var7 == field884 && var6 == field1021) {
                        if(field1030 < 2047) {
                           ++field1030;
                        }
                     } else {
                        var9 = var7 - field884;
                        field884 = var7;
                        int var10 = var6 - field1021;
                        field1021 = var6;
                        if(field1030 < 8 && var9 >= -32 && var9 <= 31 && var10 >= -32 && var10 <= 31) {
                           var9 += 32;
                           var10 += 32;
                           var13.packetBuffer.putShort(var10 + (field1030 << 12) + (var9 << 6));
                           field1030 = 0;
                        } else if(field1030 < 8) {
                           var13.packetBuffer.put24bitInt((field1030 << 19) + var8 + 8388608);
                           field1030 = 0;
                        } else {
                           var13.packetBuffer.putInt((field1030 << 19) + var8 + -1073741824);
                           field1030 = 0;
                        }
                     }
                  }

                  var13.packetBuffer.method3332(var13.packetBuffer.offset - var3);
                  field915.method1898(var13);
                  if(var4 >= UrlRequester.mouseRecorder.index) {
                     UrlRequester.mouseRecorder.index = 0;
                  } else {
                     UrlRequester.mouseRecorder.index -= var4;

                     for(var5 = 0; var5 < UrlRequester.mouseRecorder.index; ++var5) {
                        UrlRequester.mouseRecorder.xs[var5] = UrlRequester.mouseRecorder.xs[var4 + var5];
                        UrlRequester.mouseRecorder.ys[var5] = UrlRequester.mouseRecorder.ys[var5 + var4];
                     }
                  }
               }
            }

            PacketNode var16;
            if(MouseInput.mouseLastButton == 1 || !class45.middleMouseMovesCamera && MouseInput.mouseLastButton == 4 || MouseInput.mouseLastButton == 2) {
               long var14 = (MouseInput.mouseLastPressedTimeMillis - mouseLastLastPressedTimeMillis * -1L) / 50L;
               if(var14 > 4095L) {
                  var14 = 4095L;
               }

               mouseLastLastPressedTimeMillis = MouseInput.mouseLastPressedTimeMillis * -1L;
               var3 = MouseInput.mouseLastPressedY;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > class25.canvasHeight) {
                  var3 = class25.canvasHeight;
               }

               var4 = MouseInput.mouseLastPressedX;
               if(var4 < 0) {
                  var4 = 0;
               } else if(var4 > class87.canvasWidth) {
                  var4 = class87.canvasWidth;
               }

               var5 = (int)var14;
               var16 = class235.method4272(ClientPacket.field2333, field915.field1462);
               var16.packetBuffer.putShort((MouseInput.mouseLastButton == 2?1:0) + (var5 << 1));
               var16.packetBuffer.putShort(var4);
               var16.packetBuffer.putShort(var3);
               field915.method1898(var16);
            }

            if(KeyFocusListener.field615 > 0) {
               var12 = class235.method4272(ClientPacket.field2385, field915.field1462);
               var12.packetBuffer.putShort(0);
               var2 = var12.packetBuffer.offset;
               long var17 = class60.currentTimeMs();

               for(var5 = 0; var5 < KeyFocusListener.field615; ++var5) {
                  long var19 = var17 - field897;
                  if(var19 > 16777215L) {
                     var19 = 16777215L;
                  }

                  field897 = var17;
                  var12.packetBuffer.method3362(KeyFocusListener.field614[var5]);
                  var12.packetBuffer.method3377((int)var19);
               }

               var12.packetBuffer.method3331(var12.packetBuffer.offset - var2);
               field915.method1898(var12);
            }

            if(field1119 > 0) {
               --field1119;
            }

            if(KeyFocusListener.keyPressed[96] || KeyFocusListener.keyPressed[97] || KeyFocusListener.keyPressed[98] || KeyFocusListener.keyPressed[99]) {
               field1102 = true;
            }

            if(field1102 && field1119 <= 0) {
               field1119 = 20;
               field1102 = false;
               var12 = class235.method4272(ClientPacket.field2404, field915.field1462);
               var12.packetBuffer.putShort(mapAngle);
               var12.packetBuffer.putShort(field1092);
               field915.method1898(var12);
            }

            if(Buffer.field2533 && !field887) {
               field887 = true;
               var12 = class235.method4272(ClientPacket.field2371, field915.field1462);
               var12.packetBuffer.putByte(1);
               field915.method1898(var12);
            }

            if(!Buffer.field2533 && field887) {
               field887 = false;
               var12 = class235.method4272(ClientPacket.field2371, field915.field1462);
               var12.packetBuffer.putByte(0);
               field915.method1898(var12);
            }

            class1.method1();
            if(gameState == 30) {
               AbstractByteBuffer.method3583();

               for(var1 = 0; var1 < field1025; ++var1) {
                  --field1098[var1];
                  if(field1098[var1] >= -10) {
                     SoundEffect var32 = audioEffects[var1];
                     if(var32 == null) {
                        Object var10000 = null;
                        var32 = SoundEffect.getTrack(class19.indexCache4, field1096[var1], 0);
                        if(var32 == null) {
                           continue;
                        }

                        field1098[var1] += var32.calculateDelay();
                        audioEffects[var1] = var32;
                     }

                     if(field1098[var1] < 0) {
                        if(field1099[var1] != 0) {
                           var4 = (field1099[var1] & 255) * 128;
                           var5 = field1099[var1] >> 16 & 255;
                           var6 = var5 * 128 + 64 - GrandExchangeOffer.localPlayer.x;
                           if(var6 < 0) {
                              var6 = -var6;
                           }

                           var7 = field1099[var1] >> 8 & 255;
                           var8 = var7 * 128 + 64 - GrandExchangeOffer.localPlayer.y;
                           if(var8 < 0) {
                              var8 = -var8;
                           }

                           var9 = var6 + var8 - 128;
                           if(var9 > var4) {
                              field1098[var1] = -100;
                              continue;
                           }

                           if(var9 < 0) {
                              var9 = 0;
                           }

                           var3 = (var4 - var9) * field1094 / var4;
                        } else {
                           var3 = field903;
                        }

                        if(var3 > 0) {
                           class106 var21 = var32.method1986().method2030(class23.field343);
                           class116 var22 = class116.method2286(var21, 100, var3);
                           var22.method2177(field1027[var1] - 1);
                           class89.field1328.method1938(var22);
                        }

                        field1098[var1] = -100;
                     }
                  } else {
                     --field1025;

                     for(var2 = var1; var2 < field1025; ++var2) {
                        field1096[var2] = field1096[var2 + 1];
                        audioEffects[var2] = audioEffects[var2 + 1];
                        field1027[var2] = field1027[var2 + 1];
                        field1098[var2] = field1098[var2 + 1];
                        field1099[var2] = field1099[var2 + 1];
                     }

                     --var1;
                  }
               }

               if(field991) {
                  boolean var27;
                  if(class214.field2631 != 0) {
                     var27 = true;
                  } else {
                     var27 = class214.field2630.method3905();
                  }

                  if(!var27) {
                     if(field1090 != 0 && field1091 != -1) {
                        World.method1618(Size.indexTrack1, field1091, 0, field1090, false);
                     }

                     field991 = false;
                  }
               }

               ++field915.field1465;
               if(field915.field1465 > 750) {
                  MouseInput.method1025();
               } else {
                  WorldMapType1.method254();
                  CombatInfo1.method1576();
                  int[] var33 = class94.playerIndices;

                  for(var2 = 0; var2 < class94.playerIndexesCount; ++var2) {
                     Player var23 = cachedPlayers[var33[var2]];
                     if(var23 != null && var23.overheadTextCyclesRemaining > 0) {
                        --var23.overheadTextCyclesRemaining;
                        if(var23.overheadTextCyclesRemaining == 0) {
                           var23.overhead = null;
                        }
                     }
                  }

                  for(var2 = 0; var2 < npcIndexesCount; ++var2) {
                     var3 = npcIndices[var2];
                     NPC var39 = cachedNPCs[var3];
                     if(var39 != null && var39.overheadTextCyclesRemaining > 0) {
                        --var39.overheadTextCyclesRemaining;
                        if(var39.overheadTextCyclesRemaining == 0) {
                           var39.overhead = null;
                        }
                     }
                  }

                  ++field944;
                  if(cursorState != 0) {
                     field964 += 20;
                     if(field964 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(WorldMapData.field438 != null) {
                     ++mouseCrosshair;
                     if(mouseCrosshair >= 15) {
                        class28.method220(WorldMapData.field438);
                        WorldMapData.field438 = null;
                     }
                  }

                  Widget var35 = BoundingBox.field239;
                  Widget var34 = CacheFile.field1665;
                  BoundingBox.field239 = null;
                  CacheFile.field1665 = null;
                  field1032 = null;
                  field1036 = false;
                  field1033 = false;
                  field1076 = 0;

                  while(WorldMapData.method343() && field1076 < 128) {
                     if(rights >= 2 && KeyFocusListener.keyPressed[82] && TextureProvider.field1683 == 66) {
                        String var40 = "";

                        MessageNode var36;
                        for(Iterator var41 = class96.messages.iterator(); var41.hasNext(); var40 = var40 + var36.name + ':' + var36.value + '\n') {
                           var36 = (MessageNode)var41.next();
                        }

                        class160.clientInstance.method835(var40);
                     } else {
                        field1078[field1076] = TextureProvider.field1683;
                        field876[field1076] = class37.field491;
                        ++field1076;
                     }
                  }

                  boolean var28 = rights >= 2;
                  if(var28 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81] && mouseWheelRotation != 0) {
                     var4 = GrandExchangeOffer.localPlayer.field856 - mouseWheelRotation;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 3) {
                        var4 = 3;
                     }

                     if(var4 != GrandExchangeOffer.localPlayer.field856) {
                        class5.method12(GrandExchangeOffer.localPlayer.pathX[0] + class175.baseX, GrandExchangeOffer.localPlayer.pathY[0] + GraphicsObject.baseY, var4);
                     }

                     mouseWheelRotation = 0;
                  }

                  if(widgetRoot != -1) {
                     class39.method534(widgetRoot, 0, 0, class87.canvasWidth, class25.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var37;
                     ScriptEvent var42;
                     Widget var43;
                     do {
                        var42 = (ScriptEvent)field1055.popFront();
                        if(var42 == null) {
                           while(true) {
                              do {
                                 var42 = (ScriptEvent)field1056.popFront();
                                 if(var42 == null) {
                                    while(true) {
                                       do {
                                          var42 = (ScriptEvent)field1054.popFront();
                                          if(var42 == null) {
                                             this.method1455();
                                             class215.method4022();
                                             if(field1028 != null) {
                                                this.method1348();
                                             }

                                             if(Frames.field2040 != null) {
                                                class28.method220(Frames.field2040);
                                                ++itemPressedDuration;
                                                if(MouseInput.mouseCurrentButton == 0) {
                                                   if(itemBeingDragged) {
                                                      if(class185.field2540 == Frames.field2040 && field968 != field1020) {
                                                         Widget var44 = Frames.field2040;
                                                         byte var29 = 0;
                                                         if(field1018 == 1 && var44.contentType == 206) {
                                                            var29 = 1;
                                                         }

                                                         if(var44.itemIds[field1020] <= 0) {
                                                            var29 = 0;
                                                         }

                                                         var7 = GraphicsObject.getWidgetConfig(var44);
                                                         boolean var30 = (var7 >> 29 & 1) != 0;
                                                         if(var30) {
                                                            var8 = field968;
                                                            var9 = field1020;
                                                            var44.itemIds[var9] = var44.itemIds[var8];
                                                            var44.itemQuantities[var9] = var44.itemQuantities[var8];
                                                            var44.itemIds[var8] = -1;
                                                            var44.itemQuantities[var8] = 0;
                                                         } else if(var29 == 1) {
                                                            var8 = field968;
                                                            var9 = field1020;

                                                            while(var8 != var9) {
                                                               if(var8 > var9) {
                                                                  var44.method4204(var8 - 1, var8);
                                                                  --var8;
                                                               } else if(var8 < var9) {
                                                                  var44.method4204(var8 + 1, var8);
                                                                  ++var8;
                                                               }
                                                            }
                                                         } else {
                                                            var44.method4204(field1020, field968);
                                                         }

                                                         PacketNode var24 = class235.method4272(ClientPacket.field2348, field915.field1462);
                                                         var24.packetBuffer.putShort(field1020);
                                                         var24.packetBuffer.method3361(var29);
                                                         var24.packetBuffer.method3381(Frames.field2040.id);
                                                         var24.packetBuffer.putShort(field968);
                                                         field915.method1898(var24);
                                                      }
                                                   } else if(this.method1508()) {
                                                      this.openMenu(field969, field970);
                                                   } else if(menuOptionCount > 0) {
                                                      var4 = field969;
                                                      var5 = field970;
                                                      class45.method651(ChatLineBuffer.topContextMenuRow, var4, var5);
                                                      ChatLineBuffer.topContextMenuRow = null;
                                                   }

                                                   mouseCrosshair = 10;
                                                   MouseInput.mouseLastButton = 0;
                                                   Frames.field2040 = null;
                                                } else if(itemPressedDuration >= 5 && (MouseInput.mouseLastX > field969 + 5 || MouseInput.mouseLastX < field969 - 5 || MouseInput.mouseLastY > field970 + 5 || MouseInput.mouseLastY < field970 - 5)) {
                                                   itemBeingDragged = true;
                                                }
                                             }

                                             if(Region.method2785()) {
                                                var4 = Region.selectedRegionTileX;
                                                var5 = Region.selectedRegionTileY;
                                                var16 = class235.method4272(ClientPacket.field2395, field915.field1462);
                                                var16.packetBuffer.putByte(5);
                                                var16.packetBuffer.writeIntLE(var4 + class175.baseX);
                                                var16.packetBuffer.method3361(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
                                                var16.packetBuffer.putShortLE(var5 + GraphicsObject.baseY);
                                                field915.method1898(var16);
                                                Region.method2786();
                                                lastLeftClickX = MouseInput.mouseLastPressedX;
                                                lastLeftClickY = MouseInput.mouseLastPressedY;
                                                cursorState = 1;
                                                field964 = 0;
                                                destinationX = var4;
                                                destinationY = var5;
                                             }

                                             if(var35 != BoundingBox.field239) {
                                                if(var35 != null) {
                                                   class28.method220(var35);
                                                }

                                                if(BoundingBox.field239 != null) {
                                                   class28.method220(BoundingBox.field239);
                                                }
                                             }

                                             if(var34 != CacheFile.field1665 && field1007 == field1006) {
                                                if(var34 != null) {
                                                   class28.method220(var34);
                                                }

                                                if(CacheFile.field1665 != null) {
                                                   class28.method220(CacheFile.field1665);
                                                }
                                             }

                                             if(CacheFile.field1665 != null) {
                                                if(field1006 < field1007) {
                                                   ++field1006;
                                                   if(field1006 == field1007) {
                                                      class28.method220(CacheFile.field1665);
                                                   }
                                                }
                                             } else if(field1006 > 0) {
                                                --field1006;
                                             }

                                             ItemContainer.method1095();
                                             if(field1101) {
                                                GameCanvas.method778();
                                             }

                                             for(var4 = 0; var4 < 5; ++var4) {
                                                ++field1043[var4];
                                             }

                                             class159.chatMessages.process();
                                             var4 = class61.method1069();
                                             var5 = class133.method2649();
                                             if(var4 > 15000 && var5 > 15000) {
                                                field1084 = 250;
                                                FileRequest.method4301(14500);
                                                var16 = class235.method4272(ClientPacket.field2363, field915.field1462);
                                                field915.method1898(var16);
                                             }

                                             for(FriendLoginUpdate var38 = (FriendLoginUpdate)field1123.method3845(); var38 != null; var38 = (FriendLoginUpdate)field1123.method3846()) {
                                                if((long)var38.field787 < class60.currentTimeMs() / 1000L - 5L) {
                                                   if(var38.field785 > 0) {
                                                      Preferences.sendGameMessage(5, "", var38.field783 + " has logged in.");
                                                   }

                                                   if(var38.field785 == 0) {
                                                      Preferences.sendGameMessage(5, "", var38.field783 + " has logged out.");
                                                   }

                                                   var38.method3855();
                                                }
                                             }

                                             ++field915.field1468;
                                             if(field915.field1468 > 50) {
                                                var16 = class235.method4272(ClientPacket.field2347, field915.field1462);
                                                field915.method1898(var16);
                                             }

                                             try {
                                                field915.method1900();
                                             } catch (IOException var25) {
                                                MouseInput.method1025();
                                             }

                                             return;
                                          }

                                          var43 = var42.widget;
                                          if(var43.index < 0) {
                                             break;
                                          }

                                          var37 = UrlRequester.getWidget(var43.parentId);
                                       } while(var37 == null || var37.children == null || var43.index >= var37.children.length || var43 != var37.children[var43.index]);

                                       Preferences.method1633(var42);
                                    }
                                 }

                                 var43 = var42.widget;
                                 if(var43.index < 0) {
                                    break;
                                 }

                                 var37 = UrlRequester.getWidget(var43.parentId);
                              } while(var37 == null || var37.children == null || var43.index >= var37.children.length || var43 != var37.children[var43.index]);

                              Preferences.method1633(var42);
                           }
                        }

                        var43 = var42.widget;
                        if(var43.index < 0) {
                           break;
                        }

                        var37 = UrlRequester.getWidget(var43.parentId);
                     } while(var37 == null || var37.children == null || var43.index >= var37.children.length || var43 != var37.children[var43.index]);

                     Preferences.method1633(var42);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "62"
   )
   void method1186() {
      int var1 = class87.canvasWidth;
      int var2 = class25.canvasHeight;
      if(super.field668 < var1) {
         var1 = super.field668;
      }

      if(super.field669 < var2) {
         var2 = super.field669;
      }

      if(class222.preferences != null) {
         try {
            class52.method770(class160.clientInstance, "resize", new Object[]{Integer.valueOf(class43.method612())});
         } catch (Throwable var4) {
            ;
         }
      }

   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-60"
   )
   final void method1187() {
      int var1;
      if(widgetRoot != -1) {
         var1 = widgetRoot;
         if(FontName.loadWidget(var1)) {
            BuildType.method4291(Widget.widgets[var1], -1);
         }
      }

      for(var1 = 0; var1 < widgetCount; ++var1) {
         if(field1041[var1]) {
            field1061[var1] = true;
         }

         field975[var1] = field1041[var1];
         field1041[var1] = false;
      }

      field1059 = gameCycle;
      field1004 = -1;
      field1005 = -1;
      class185.field2540 = null;
      if(widgetRoot != -1) {
         widgetCount = 0;
         class40.method538(widgetRoot, 0, 0, class87.canvasWidth, class25.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      int var2;
      int var3;
      int var4;
      int var6;
      int var7;
      int var8;
      if(!isMenuOpen) {
         if(field1004 != -1) {
            WorldMapType1.method265(field1004, field1005);
         }
      } else {
         var1 = Friend.menuX;
         var2 = class163.menuY;
         var3 = BoundingBox2D.menuWidth;
         var4 = class34.menuHeight;
         int var13 = 6116423;
         Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, var13);
         Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
         class36.fontBold12.method4950("Choose Option", var1 + 3, var2 + 14, var13, -1);
         var6 = MouseInput.mouseLastX;
         var7 = MouseInput.mouseLastY;

         int var9;
         int var10;
         for(var8 = 0; var8 < menuOptionCount; ++var8) {
            var9 = var2 + (menuOptionCount - 1 - var8) * 15 + 31;
            var10 = 16777215;
            if(var6 > var1 && var6 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
               var10 = 16776960;
            }

            class36.fontBold12.method4950(class22.method162(var8), var1 + 3, var9, var10, 0);
         }

         var8 = Friend.menuX;
         var9 = class163.menuY;
         var10 = BoundingBox2D.menuWidth;
         int var17 = class34.menuHeight;

         for(int var12 = 0; var12 < widgetCount; ++var12) {
            if(widgetPositionX[var12] + widgetBoundsWidth[var12] > var8 && widgetPositionX[var12] < var8 + var10 && widgetPositionY[var12] + widgetBoundsHeight[var12] > var9 && widgetPositionY[var12] < var17 + var9) {
               field1061[var12] = true;
            }
         }
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < widgetCount; ++var1) {
            if(field975[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1061[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = class7.plane;
      var2 = GrandExchangeOffer.localPlayer.x;
      var3 = GrandExchangeOffer.localPlayer.y;
      var4 = field944;

      for(class81 var5 = (class81)class81.field1247.getFront(); var5 != null; var5 = (class81)class81.field1247.getNext()) {
         if(var5.field1248 != -1 || var5.field1245 != null) {
            var6 = 0;
            if(var2 > var5.field1241) {
               var6 += var2 - var5.field1241;
            } else if(var2 < var5.field1252) {
               var6 += var5.field1252 - var2;
            }

            if(var3 > var5.field1246) {
               var6 += var3 - var5.field1246;
            } else if(var3 < var5.field1243) {
               var6 += var5.field1243 - var3;
            }

            if(var6 - 64 <= var5.field1244 && field1094 != 0 && var1 == var5.field1242) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = (var5.field1244 - var6) * field1094 / var5.field1244;
               Object var10000;
               if(var5.field1249 == null) {
                  if(var5.field1248 >= 0) {
                     var10000 = null;
                     SoundEffect var14 = SoundEffect.getTrack(class19.indexCache4, var5.field1248, 0);
                     if(var14 != null) {
                        class106 var15 = var14.method1986().method2030(class23.field343);
                        class116 var16 = class116.method2286(var15, 100, var7);
                        var16.method2177(-1);
                        class89.field1328.method1938(var16);
                        var5.field1249 = var16;
                     }
                  }
               } else {
                  var5.field1249.method2178(var7);
               }

               if(var5.field1250 == null) {
                  if(var5.field1245 != null && (var5.field1253 -= var4) <= 0) {
                     var8 = (int)(Math.random() * (double)var5.field1245.length);
                     var10000 = null;
                     SoundEffect var18 = SoundEffect.getTrack(class19.indexCache4, var5.field1245[var8], 0);
                     if(var18 != null) {
                        class106 var19 = var18.method1986().method2030(class23.field343);
                        class116 var11 = class116.method2286(var19, 100, var7);
                        var11.method2177(0);
                        class89.field1328.method1938(var11);
                        var5.field1250 = var11;
                        var5.field1253 = var5.field1254 + (int)(Math.random() * (double)(var5.field1251 - var5.field1254));
                     }
                  }
               } else {
                  var5.field1250.method2178(var7);
                  if(!var5.field1250.linked()) {
                     var5.field1250 = null;
                  }
               }
            } else {
               if(var5.field1249 != null) {
                  class89.field1328.method1924(var5.field1249);
                  var5.field1249 = null;
               }

               if(var5.field1250 != null) {
                  class89.field1328.method1924(var5.field1250);
                  var5.field1250 = null;
               }
            }
         }
      }

      field944 = 0;
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(Lcg;B)Z",
      garbageValue = "52"
   )
   final boolean method1188(NetWriter var1) {
      class159 var2 = var1.getSocket();
      PacketBuffer var3 = var1.packetBuffer;
      if(var2 == null) {
         return false;
      } else {
         String var5;
         int var6;
         try {
            if(var1.serverPacket == null) {
               if(var1.field1458) {
                  if(!var2.vmethod3153(1)) {
                     return false;
                  }

                  var2.vmethod3148(var1.packetBuffer.payload, 0, 1);
                  var1.field1465 = 0;
                  var1.field1458 = false;
               }

               var3.offset = 0;
               if(var3.method3614()) {
                  if(!var2.vmethod3153(1)) {
                     return false;
                  }

                  var2.vmethod3148(var1.packetBuffer.payload, 1, 1);
                  var1.field1465 = 0;
               }

               var1.field1458 = true;
               ServerPacket[] var4 = new ServerPacket[]{ServerPacket.field2306, ServerPacket.field2301, ServerPacket.field2258, ServerPacket.field2250, ServerPacket.field2247, ServerPacket.field2252, ServerPacket.field2251, ServerPacket.field2326, ServerPacket.field2255, ServerPacket.field2256, ServerPacket.field2257, ServerPacket.field2254, ServerPacket.field2259, ServerPacket.field2260, ServerPacket.field2311, ServerPacket.field2262, ServerPacket.field2294, ServerPacket.field2264, ServerPacket.field2273, ServerPacket.field2266, ServerPacket.field2267, ServerPacket.field2268, ServerPacket.field2269, ServerPacket.field2270, ServerPacket.field2271, ServerPacket.field2272, ServerPacket.field2286, ServerPacket.field2274, ServerPacket.field2275, ServerPacket.field2296, ServerPacket.field2277, ServerPacket.field2278, ServerPacket.field2279, ServerPacket.field2280, ServerPacket.field2281, ServerPacket.field2282, ServerPacket.field2283, ServerPacket.field2303, ServerPacket.field2285, ServerPacket.field2317, ServerPacket.field2287, ServerPacket.field2288, ServerPacket.field2289, ServerPacket.field2290, ServerPacket.field2304, ServerPacket.field2292, ServerPacket.field2276, ServerPacket.field2253, ServerPacket.field2295, ServerPacket.field2307, ServerPacket.field2297, ServerPacket.field2298, ServerPacket.field2299, ServerPacket.field2263, ServerPacket.field2293, ServerPacket.field2302, ServerPacket.field2248, ServerPacket.field2249, ServerPacket.field2305, ServerPacket.field2320, ServerPacket.field2265, ServerPacket.field2308, ServerPacket.field2309, ServerPacket.field2310, ServerPacket.field2318, ServerPacket.field2312, ServerPacket.field2313, ServerPacket.field2314, ServerPacket.field2315, ServerPacket.field2316, ServerPacket.field2300, ServerPacket.field2291, ServerPacket.field2319, ServerPacket.field2261, ServerPacket.field2321, ServerPacket.field2322, ServerPacket.field2323, ServerPacket.field2324, ServerPacket.field2325, ServerPacket.field2284, ServerPacket.field2327};
               var6 = var3.method3610();
               if(var6 < 0 || var6 >= var4.length) {
                  throw new IOException(var6 + " " + var3.offset);
               }

               var1.serverPacket = var4[var6];
               var1.packetLength = var1.serverPacket.packetLength;
            }

            if(var1.packetLength == -1) {
               if(!var2.vmethod3153(1)) {
                  return false;
               }

               var1.getSocket().vmethod3148(var3.payload, 0, 1);
               var1.packetLength = var3.payload[0] & 255;
            }

            if(var1.packetLength == -2) {
               if(!var2.vmethod3153(2)) {
                  return false;
               }

               var1.getSocket().vmethod3148(var3.payload, 0, 2);
               var3.offset = 0;
               var1.packetLength = var3.readUnsignedShort();
            }

            if(!var2.vmethod3153(var1.packetLength)) {
               return false;
            }

            var3.offset = 0;
            var2.vmethod3148(var3.payload, 0, var1.packetLength);
            var1.field1465 = 0;
            field894.method5119();
            var1.field1467 = var1.field1470;
            var1.field1470 = var1.field1459;
            var1.field1459 = var1.serverPacket;
            if(ServerPacket.field2267 == var1.serverPacket) {
               WidgetNode.method1103(class173.field2438);
               var1.serverPacket = null;
               return true;
            }

            int var24;
            int var77;
            Widget var90;
            if(ServerPacket.field2302 == var1.serverPacket) {
               var77 = var3.method3383();
               var24 = var3.readUnsignedShortOb1();
               var90 = UrlRequester.getWidget(var77);
               if(var90 != null && var90.type == 0) {
                  if(var24 > var90.scrollHeight - var90.height) {
                     var24 = var90.scrollHeight - var90.height;
                  }

                  if(var24 < 0) {
                     var24 = 0;
                  }

                  if(var24 != var90.scrollY) {
                     var90.scrollY = var24;
                     class28.method220(var90);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2276 == var1.serverPacket) {
               var77 = var3.method3376();
               var24 = var3.method3383();
               var90 = UrlRequester.getWidget(var24);
               if(var77 != var90.field2749 || var77 == -1) {
                  var90.field2749 = var77;
                  var90.field2884 = 0;
                  var90.field2885 = 0;
                  class28.method220(var90);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2277 == var1.serverPacket) {
               var77 = var3.readInt();
               WidgetNode var69 = (WidgetNode)componentTable.get((long)var77);
               if(var69 != null) {
                  class19.method138(var69, true);
               }

               if(field1019 != null) {
                  class28.method220(field1019);
                  field1019 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            String var58;
            if(ServerPacket.field2292 == var1.serverPacket) {
               var58 = var3.readString();
               var5 = FontTypeFace.appendTags(class159.method3093(UrlRequester.method2972(var3)));
               Preferences.sendGameMessage(6, var58, var5);
               var1.serverPacket = null;
               return true;
            }

            int var7;
            int var8;
            int var9;
            if(ServerPacket.field2271 == var1.serverPacket) {
               var77 = var3.readInt();
               var24 = var3.readUnsignedShort();
               if(var77 < -70000) {
                  var24 += 32768;
               }

               if(var77 >= 0) {
                  var90 = UrlRequester.getWidget(var77);
               } else {
                  var90 = null;
               }

               for(; var3.offset < var1.packetLength; BoundingBox2D.setItemTableSlot(var24, var7, var8 - 1, var9)) {
                  var7 = var3.getUSmart();
                  var8 = var3.readUnsignedShort();
                  var9 = 0;
                  if(var8 != 0) {
                     var9 = var3.readUnsignedByte();
                     if(var9 == 255) {
                        var9 = var3.readInt();
                     }
                  }

                  if(var90 != null && var7 >= 0 && var7 < var90.itemIds.length) {
                     var90.itemIds[var7] = var8;
                     var90.itemQuantities[var7] = var9;
                  }
               }

               if(var90 != null) {
                  class28.method220(var90);
               }

               class160.method3100();
               interfaceItemTriggers[++field1044 - 1 & 31] = var24 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2257 == var1.serverPacket) {
               field889 = var3.method3337() * 30;
               field951 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2275 == var1.serverPacket) {
               var77 = var3.readUnsignedByte();
               if(var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var77] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var77] = new GrandExchangeOffer(var3, false);
               }

               field1050 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            boolean var66;
            int var70;
            boolean var71;
            if(ServerPacket.field2289 == var1.serverPacket) {
               var58 = var3.readString();
               var24 = var3.readUnsignedShort();
               byte var73 = var3.readByte();
               var66 = false;
               if(var73 == -128) {
                  var66 = true;
               }

               if(var66) {
                  if(FileSystem.clanChatCount == 0) {
                     var1.serverPacket = null;
                     return true;
                  }

                  var71 = false;

                  for(var8 = 0; var8 < FileSystem.clanChatCount && (!AbstractSoundSystem.clanMembers[var8].username.equals(var58) || var24 != AbstractSoundSystem.clanMembers[var8].world); ++var8) {
                     ;
                  }

                  if(var8 < FileSystem.clanChatCount) {
                     while(var8 < FileSystem.clanChatCount - 1) {
                        AbstractSoundSystem.clanMembers[var8] = AbstractSoundSystem.clanMembers[var8 + 1];
                        ++var8;
                     }

                     --FileSystem.clanChatCount;
                     AbstractSoundSystem.clanMembers[FileSystem.clanChatCount] = null;
                  }
               } else {
                  var3.readString();
                  ClanMember var91 = new ClanMember();
                  var91.username = var58;
                  var91.field870 = WorldMapData.cleanUsername(var91.username, GrandExchangeOffer.jagexLoginType);
                  var91.world = var24;
                  var91.rank = var73;

                  for(var9 = FileSystem.clanChatCount - 1; var9 >= 0; --var9) {
                     var70 = AbstractSoundSystem.clanMembers[var9].field870.compareTo(var91.field870);
                     if(var70 == 0) {
                        AbstractSoundSystem.clanMembers[var9].world = var24;
                        AbstractSoundSystem.clanMembers[var9].rank = var73;
                        if(var58.equals(GrandExchangeOffer.localPlayer.name)) {
                           WorldMapType3.clanChatRank = var73;
                        }

                        field1049 = cycleCntr;
                        var1.serverPacket = null;
                        return true;
                     }

                     if(var70 < 0) {
                        break;
                     }
                  }

                  if(FileSystem.clanChatCount >= AbstractSoundSystem.clanMembers.length) {
                     var1.serverPacket = null;
                     return true;
                  }

                  for(var70 = FileSystem.clanChatCount - 1; var70 > var9; --var70) {
                     AbstractSoundSystem.clanMembers[var70 + 1] = AbstractSoundSystem.clanMembers[var70];
                  }

                  if(FileSystem.clanChatCount == 0) {
                     AbstractSoundSystem.clanMembers = new ClanMember[100];
                  }

                  AbstractSoundSystem.clanMembers[var9 + 1] = var91;
                  ++FileSystem.clanChatCount;
                  if(var58.equals(GrandExchangeOffer.localPlayer.name)) {
                     WorldMapType3.clanChatRank = var73;
                  }
               }

               field1049 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            boolean var78;
            String var80;
            String var83;
            if(ServerPacket.field2304 == var1.serverPacket) {
               var77 = var3.getUSmart();
               var78 = var3.readUnsignedByte() == 1;
               var80 = "";
               var66 = false;
               if(var78) {
                  var80 = var3.readString();
                  if(class33.isIgnored(var80)) {
                     var66 = true;
                  }
               }

               var83 = var3.readString();
               if(!var66) {
                  Preferences.sendGameMessage(var77, var80, var83);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2306 == var1.serverPacket) {
               class160.method3100();
               var77 = var3.method3374();
               var24 = var3.method3384();
               var6 = var3.method3374();
               skillExperiences[var77] = var24;
               boostedSkillLevels[var77] = var6;
               realSkillLevels[var77] = 1;

               for(var7 = 0; var7 < 98; ++var7) {
                  if(var24 >= class233.field2948[var7]) {
                     realSkillLevels[var77] = var7 + 2;
                  }
               }

               field1093[++field1045 - 1 & 31] = var77;
               var1.serverPacket = null;
               return true;
            }

            Widget var82;
            if(ServerPacket.field2297 == var1.serverPacket) {
               var77 = var3.readUnsignedShortOb1();
               var24 = var3.method3383();
               var6 = var3.method3518();
               var7 = var3.method3518();
               var82 = UrlRequester.getWidget(var24);
               if(var6 != var82.rotationX || var7 != var82.rotationZ || var77 != var82.modelZoom) {
                  var82.rotationX = var6;
                  var82.rotationZ = var7;
                  var82.modelZoom = var77;
                  class28.method220(var82);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2287 == var1.serverPacket) {
               var77 = var3.readUnsignedShort();
               var24 = var3.method3383();
               var90 = UrlRequester.getWidget(var24);
               if(var90.modelType != 2 || var77 != var90.modelId) {
                  var90.modelType = 2;
                  var90.modelId = var77;
                  class28.method220(var90);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2307 == var1.serverPacket) {
               field1101 = false;

               for(var77 = 0; var77 < 5; ++var77) {
                  field1097[var77] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2259 == var1.serverPacket) {
               var77 = var3.readInt();
               var24 = var3.readInt();
               var6 = WorldMapType1.method264();
               PacketNode var98 = class235.method4272(ClientPacket.field2339, field915.field1462);
               var98.packetBuffer.method3361(var6);
               var98.packetBuffer.putInt(var77);
               var98.packetBuffer.putInt(var24);
               var98.packetBuffer.method3361(GameEngine.FPS);
               field915.method1898(var98);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2258 == var1.serverPacket) {
               var77 = var3.readUnsignedShortOb1();
               widgetRoot = var77;
               this.method1377(false);
               class18.method129(var77);
               BoundingBox.method45(widgetRoot);

               for(var24 = 0; var24 < 100; ++var24) {
                  field1041[var24] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2309 == var1.serverPacket) {
               publicChatMode = var3.readUnsignedByte();
               field1072 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2308 == var1.serverPacket) {
               WidgetNode.method1103(class173.field2445);
               var1.serverPacket = null;
               return true;
            }

            Widget var65;
            if(ServerPacket.field2320 == var1.serverPacket) {
               var77 = var3.method3384();
               var65 = UrlRequester.getWidget(var77);
               var65.modelType = 3;
               var65.modelId = GrandExchangeOffer.localPlayer.composition.method4186();
               class28.method220(var65);
               var1.serverPacket = null;
               return true;
            }

            Widget var92;
            if(ServerPacket.field2293 == var1.serverPacket) {
               var77 = var3.method3382();
               var24 = var3.method3383();
               var6 = var3.method3337();
               if(var6 == 65535) {
                  var6 = -1;
               }

               var92 = UrlRequester.getWidget(var24);
               ItemComposition var86;
               if(!var92.hasScript) {
                  if(var6 == -1) {
                     var92.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var86 = class115.getItemDefinition(var6);
                  var92.modelType = 4;
                  var92.modelId = var6;
                  var92.rotationX = var86.xan2d;
                  var92.rotationZ = var86.yan2d;
                  var92.modelZoom = var86.zoom2d * 100 / var77;
                  class28.method220(var92);
               } else {
                  var92.itemId = var6;
                  var92.itemQuantity = var77;
                  var86 = class115.getItemDefinition(var6);
                  var92.rotationX = var86.xan2d;
                  var92.rotationZ = var86.yan2d;
                  var92.rotationY = var86.zan2d;
                  var92.field2868 = var86.offsetX2d;
                  var92.field2812 = var86.offsetY2d;
                  var92.modelZoom = var86.zoom2d;
                  if(var86.isStackable == 1) {
                     var92.field2784 = 1;
                  } else {
                     var92.field2784 = 2;
                  }

                  if(var92.field2817 > 0) {
                     var92.modelZoom = var92.modelZoom * 32 / var92.field2817;
                  } else if(var92.originalWidth > 0) {
                     var92.modelZoom = var92.modelZoom * 32 / var92.originalWidth;
                  }

                  class28.method220(var92);
               }

               var1.serverPacket = null;
               return true;
            }

            String var84;
            if(ServerPacket.field2316 == var1.serverPacket) {
               var58 = var3.readString();
               MessageNode.sessionToken = var58;

               try {
                  var5 = class160.clientInstance.getParameter(Parameters.field3796.key);
                  var80 = class160.clientInstance.getParameter(Parameters.field3786.key);
                  var84 = var5 + "settings=" + var58 + "; version=1; path=/; domain=" + var80;
                  if(var58.length() == 0) {
                     var84 = var84 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var84 = var84 + "; Expires=" + ScriptEvent.method1112(class60.currentTimeMs() + 94608000000L) + "; Max-Age=" + 94608000L;
                  }

                  class52.method765(class160.clientInstance, "document.cookie=\"" + var84 + "\"");
               } catch (Throwable var49) {
                  ;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2266 == var1.serverPacket) {
               var58 = var3.readString();
               var24 = var3.readInt();
               var90 = UrlRequester.getWidget(var24);
               if(!var58.equals(var90.text)) {
                  var90.text = var58;
                  class28.method220(var90);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2323 == var1.serverPacket) {
               var58 = var3.readString();
               Object[] var68 = new Object[var58.length() + 1];

               for(var6 = var58.length() - 1; var6 >= 0; --var6) {
                  if(var58.charAt(var6) == 's') {
                     var68[var6 + 1] = var3.readString();
                  } else {
                     var68[var6 + 1] = new Integer(var3.readInt());
                  }
               }

               var68[0] = new Integer(var3.readInt());
               ScriptEvent var96 = new ScriptEvent();
               var96.objs = var68;
               Preferences.method1633(var96);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2263 == var1.serverPacket) {
               CombatInfo1.field1215 = var3.method3363();
               WorldMapType2.field505 = var3.method3363();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2326 == var1.serverPacket) {
               WidgetNode.method1103(class173.field2440);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2268 == var1.serverPacket) {
               World var60 = new World();
               var60.address = var3.readString();
               var60.id = var3.readUnsignedShort();
               var24 = var3.readInt();
               var60.mask = var24;
               ClanMember.setGameState(45);
               var2.vmethod3136();
               var2 = null;
               AttackOption.method1747(var60);
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2314 == var1.serverPacket) {
               var77 = var3.readShort();
               var24 = var3.method3317();
               var6 = var3.readInt();
               var92 = UrlRequester.getWidget(var6);
               if(var77 != var92.originalX || var24 != var92.originalY || var92.dynamicX != 0 || var92.dynamicY != 0) {
                  var92.originalX = var77;
                  var92.originalY = var24;
                  var92.dynamicX = 0;
                  var92.dynamicY = 0;
                  class28.method220(var92);
                  this.widgetMethod0(var92);
                  if(var92.type == 0) {
                     class160.method3094(Widget.widgets[var6 >> 16], var92, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2251 == var1.serverPacket) {
               class160.method3100();
               energy = var3.readUnsignedByte();
               field951 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2303 == var1.serverPacket) {
               field1077 = 1;
               field880 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2310 == var1.serverPacket) {
               var3.offset += 28;
               if(var3.checkCrc()) {
                  var77 = var3.offset - 28;
                  byte[] var67 = var3.payload;
                  if(field1121 == null) {
                     field1121 = new byte[24];
                  }

                  class194.method3670(var67, var77, field1121, 0, 24);
                  if(class157.randomDat != null) {
                     try {
                        class157.randomDat.seek(0L);
                        class157.randomDat.write(var3.payload, var77, 24);
                     } catch (Exception var48) {
                        ;
                     }
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2256 == var1.serverPacket) {
               CombatInfo1.field1215 = var3.method3363();
               WorldMapType2.field505 = var3.method3374();

               for(var77 = WorldMapType2.field505; var77 < WorldMapType2.field505 + 8; ++var77) {
                  for(var24 = CombatInfo1.field1215; var24 < CombatInfo1.field1215 + 8; ++var24) {
                     if(groundItemDeque[class7.plane][var77][var24] != null) {
                        groundItemDeque[class7.plane][var77][var24] = null;
                        MessageNode.groundItemSpawned(var77, var24);
                     }
                  }
               }

               for(PendingSpawn var59 = (PendingSpawn)pendingSpawns.getFront(); var59 != null; var59 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var59.x >= WorldMapType2.field505 && var59.x < WorldMapType2.field505 + 8 && var59.y >= CombatInfo1.field1215 && var59.y < CombatInfo1.field1215 + 8 && var59.level == class7.plane) {
                     var59.hitpoints = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2278 == var1.serverPacket) {
               field1101 = true;
               SoundTaskDataProvider.field624 = var3.readUnsignedByte();
               ChatLineBuffer.field1456 = var3.readUnsignedByte();
               Friend.field782 = var3.readUnsignedShort();
               class82.field1272 = var3.readUnsignedByte();
               class20.field327 = var3.readUnsignedByte();
               if(class20.field327 >= 100) {
                  GameEngine.cameraX = SoundTaskDataProvider.field624 * 128 + 64;
                  MouseInput.cameraY = ChatLineBuffer.field1456 * 128 + 64;
                  ScriptEvent.cameraZ = MouseInput.getTileHeight(GameEngine.cameraX, MouseInput.cameraY, class7.plane) - Friend.field782;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2279 == var1.serverPacket) {
               var77 = var3.method3382();
               var24 = var3.method3518();
               var6 = var24 >> 10 & 31;
               var7 = var24 >> 5 & 31;
               var8 = var24 & 31;
               var9 = (var7 << 11) + (var6 << 19) + (var8 << 3);
               Widget var97 = UrlRequester.getWidget(var77);
               if(var9 != var97.textColor) {
                  var97.textColor = var9;
                  class28.method220(var97);
               }

               var1.serverPacket = null;
               return true;
            }

            long var29;
            long var31;
            int var72;
            if(ServerPacket.field2315 == var1.serverPacket) {
               var58 = var3.readString();
               var29 = (long)var3.readUnsignedShort();
               var31 = (long)var3.read24BitInt();
               Permission[] var104 = new Permission[]{Permission.field3273, Permission.field3275, Permission.field3282, Permission.field3278, Permission.field3272, Permission.field3276};
               Permission var95 = (Permission)class34.forOrdinal(var104, var3.readUnsignedByte());
               long var11 = (var29 << 32) + var31;
               boolean var13 = false;

               for(var72 = 0; var72 < 100; ++var72) {
                  if(field1074[var72] == var11) {
                     var13 = true;
                     break;
                  }
               }

               if(class33.isIgnored(var58)) {
                  var13 = true;
               }

               if(!var13 && myPlayerIndex == 0) {
                  field1074[field959] = var11;
                  field959 = (field959 + 1) % 100;
                  String var102 = FontTypeFace.appendTags(class159.method3093(UrlRequester.method2972(var3)));
                  byte var76;
                  if(var95.field3280) {
                     var76 = 7;
                  } else {
                     var76 = 3;
                  }

                  if(var95.field3279 != -1) {
                     Preferences.sendGameMessage(var76, CombatInfoListHolder.method1706(var95.field3279) + var58, var102);
                  } else {
                     Preferences.sendGameMessage(var76, var58, var102);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2248 == var1.serverPacket) {
               field1101 = true;
               WorldMapType3.field377 = var3.readUnsignedByte();
               ClanMember.field871 = var3.readUnsignedByte();
               FriendLoginUpdate.field786 = var3.readUnsignedShort();
               Timer.field2191 = var3.readUnsignedByte();
               GameCanvas.field628 = var3.readUnsignedByte();
               if(GameCanvas.field628 >= 100) {
                  var77 = WorldMapType3.field377 * 128 + 64;
                  var24 = ClanMember.field871 * 128 + 64;
                  var6 = MouseInput.getTileHeight(var77, var24, class7.plane) - FriendLoginUpdate.field786;
                  var7 = var77 - GameEngine.cameraX;
                  var8 = var6 - ScriptEvent.cameraZ;
                  var9 = var24 - MouseInput.cameraY;
                  var70 = (int)Math.sqrt((double)(var9 * var9 + var7 * var7));
                  SoundTask.cameraPitch = (int)(Math.atan2((double)var8, (double)var70) * 325.949D) & 2047;
                  class2.cameraYaw = (int)(Math.atan2((double)var7, (double)var9) * -325.949D) & 2047;
                  if(SoundTask.cameraPitch < 128) {
                     SoundTask.cameraPitch = 128;
                  }

                  if(SoundTask.cameraPitch > 383) {
                     SoundTask.cameraPitch = 383;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2264 == var1.serverPacket) {
               var77 = var3.method3518();
               if(var77 == 65535) {
                  var77 = -1;
               }

               class45.method655(var77);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2321 == var1.serverPacket) {
               var77 = var3.method3337();
               if(var77 == 65535) {
                  var77 = -1;
               }

               var24 = var3.method3349();
               class35.method488(var77, var24);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2317 == var1.serverPacket) {
               var77 = var3.readUnsignedShort();
               var24 = var3.readUnsignedByte();
               var6 = var3.readUnsignedShort();
               if(field903 != 0 && var24 != 0 && field1025 < 50) {
                  field1096[field1025] = var77;
                  field1027[field1025] = var24;
                  field1098[field1025] = var6;
                  audioEffects[field1025] = null;
                  field1099[field1025] = 0;
                  ++field1025;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2311 == var1.serverPacket) {
               class28.method233(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2283 == var1.serverPacket) {
               var77 = var3.readUnsignedByte();
               var24 = var3.readUnsignedByte();
               var6 = var3.readUnsignedByte();
               var7 = var3.readUnsignedByte();
               field1097[var77] = true;
               field929[var77] = var24;
               field1104[var77] = var6;
               field1105[var77] = var7;
               field1043[var77] = 0;
               var1.serverPacket = null;
               return true;
            }

            int var105;
            if(ServerPacket.field2288 == var1.serverPacket) {
               field1049 = cycleCntr;
               if(var1.packetLength == 0) {
                  clanChatOwner = null;
                  clanChatName = null;
                  FileSystem.clanChatCount = 0;
                  AbstractSoundSystem.clanMembers = null;
                  var1.serverPacket = null;
                  return true;
               }

               clanChatName = var3.readString();
               long var35 = var3.readLong();
               clanChatOwner = CollisionData.method3217(var35);
               class40.field526 = var3.readByte();
               var6 = var3.readUnsignedByte();
               if(var6 == 255) {
                  var1.serverPacket = null;
                  return true;
               }

               FileSystem.clanChatCount = var6;
               ClanMember[] var94 = new ClanMember[100];

               for(var8 = 0; var8 < FileSystem.clanChatCount; ++var8) {
                  var94[var8] = new ClanMember();
                  var94[var8].username = var3.readString();
                  var94[var8].field870 = WorldMapData.cleanUsername(var94[var8].username, GrandExchangeOffer.jagexLoginType);
                  var94[var8].world = var3.readUnsignedShort();
                  var94[var8].rank = var3.readByte();
                  var3.readString();
                  if(var94[var8].username.equals(GrandExchangeOffer.localPlayer.name)) {
                     WorldMapType3.clanChatRank = var94[var8].rank;
                  }
               }

               var71 = false;
               var70 = FileSystem.clanChatCount;

               while(var70 > 0) {
                  var71 = true;
                  --var70;

                  for(var105 = 0; var105 < var70; ++var105) {
                     if(var94[var105].field870.compareTo(var94[var105 + 1].field870) > 0) {
                        ClanMember var103 = var94[var105];
                        var94[var105] = var94[var105 + 1];
                        var94[var105 + 1] = var103;
                        var71 = false;
                     }
                  }

                  if(var71) {
                     break;
                  }
               }

               AbstractSoundSystem.clanMembers = var94;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2254 == var1.serverPacket) {
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

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2291 == var1.serverPacket) {
               var77 = var3.readInt();
               var65 = UrlRequester.getWidget(var77);

               for(var6 = 0; var6 < var65.itemIds.length; ++var6) {
                  var65.itemIds[var6] = -1;
                  var65.itemIds[var6] = 0;
               }

               class28.method220(var65);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2253 == var1.serverPacket) {
               WidgetNode.method1103(class173.field2442);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2290 == var1.serverPacket) {
               WidgetNode.method1103(class173.field2437);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2282 == var1.serverPacket) {
               for(var77 = 0; var77 < VarPlayerType.field3378; ++var77) {
                  VarPlayerType var64 = ContextMenuRow.method1742(var77);
                  if(var64 != null) {
                     class222.settings[var77] = 0;
                     class222.widgetSettings[var77] = 0;
                  }
               }

               class160.method3100();
               field1042 += 32;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2273 == var1.serverPacket) {
               var77 = var3.method3383();
               var24 = var3.method3337();
               var90 = UrlRequester.getWidget(var77);
               if(var90.modelType != 1 || var24 != var90.modelId) {
                  var90.modelType = 1;
                  var90.modelId = var24;
                  class28.method220(var90);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2285 == var1.serverPacket) {
               class28.method233(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2301 == var1.serverPacket) {
               var77 = var3.method3337();
               var24 = var3.readUnsignedShortOb1();
               var6 = var3.method3382();
               var92 = UrlRequester.getWidget(var6);
               var92.field2818 = var24 + (var77 << 16);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2324 == var1.serverPacket) {
               var77 = var3.readInt();
               var24 = var3.readUnsignedShortOb1();
               class222.settings[var24] = var77;
               if(class222.widgetSettings[var24] != var77) {
                  class222.widgetSettings[var24] = var77;
               }

               class7.method34(var24);
               field984[++field1042 - 1 & 31] = var24;
               var1.serverPacket = null;
               return true;
            }

            WidgetNode var85;
            if(ServerPacket.field2313 == var1.serverPacket) {
               var77 = var3.offset + var1.packetLength;
               var24 = var3.readUnsignedShort();
               var6 = var3.readUnsignedShort();
               if(var24 != widgetRoot) {
                  widgetRoot = var24;
                  this.method1377(false);
                  class18.method129(widgetRoot);
                  BoundingBox.method45(widgetRoot);

                  for(var7 = 0; var7 < 100; ++var7) {
                     field1041[var7] = true;
                  }
               }

               WidgetNode var89;
               for(; var6-- > 0; var89.field792 = true) {
                  var7 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedByte();
                  var89 = (WidgetNode)componentTable.get((long)var7);
                  if(var89 != null && var8 != var89.id) {
                     class19.method138(var89, true);
                     var89 = null;
                  }

                  if(var89 == null) {
                     var89 = class60.method1032(var7, var8, var9);
                  }
               }

               for(var85 = (WidgetNode)componentTable.first(); var85 != null; var85 = (WidgetNode)componentTable.next()) {
                  if(var85.field792) {
                     var85.field792 = false;
                  } else {
                     class19.method138(var85, true);
                  }
               }

               widgetFlags = new HashTable(512);

               while(var3.offset < var77) {
                  var7 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedShort();
                  var70 = var3.readInt();

                  for(var105 = var8; var105 <= var9; ++var105) {
                     long var12 = ((long)var7 << 32) + (long)var105;
                     widgetFlags.put(new IntegerNode(var70), var12);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2260 == var1.serverPacket) {
               WidgetNode.method1103(class173.field2443);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2322 == var1.serverPacket) {
               for(var77 = 0; var77 < class222.widgetSettings.length; ++var77) {
                  if(class222.settings[var77] != class222.widgetSettings[var77]) {
                     class222.widgetSettings[var77] = class222.settings[var77];
                     class7.method34(var77);
                     field984[++field1042 - 1 & 31] = var77;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            boolean var23;
            if(ServerPacket.field2252 == var1.serverPacket) {
               var23 = var3.readUnsignedByteNegate() == 1;
               var24 = var3.method3383();
               var90 = UrlRequester.getWidget(var24);
               if(var23 != var90.isHidden) {
                  var90.isHidden = var23;
                  class28.method220(var90);
               }

               var1.serverPacket = null;
               return true;
            }

            int var39;
            if(ServerPacket.field2294 == var1.serverPacket) {
               var77 = var1.packetLength;
               ClassInfo var63 = new ClassInfo();
               var63.count = var3.readUnsignedByte();
               var63.field3821 = var3.readInt();
               var63.type = new int[var63.count];
               var63.errorIdentifiers = new int[var63.count];
               var63.fields = new Field[var63.count];
               var63.field3825 = new int[var63.count];
               var63.methods = new Method[var63.count];
               var63.args = new byte[var63.count][][];

               for(var6 = 0; var6 < var63.count; ++var6) {
                  try {
                     var7 = var3.readUnsignedByte();
                     String var101;
                     if(var7 != 0 && var7 != 1 && var7 != 2) {
                        if(var7 == 3 || var7 == 4) {
                           var83 = var3.readString();
                           var101 = var3.readString();
                           var70 = var3.readUnsignedByte();
                           String[] var107 = new String[var70];

                           for(var39 = 0; var39 < var70; ++var39) {
                              var107[var39] = var3.readString();
                           }

                           String var109 = var3.readString();
                           byte[][] var110 = new byte[var70][];
                           int var74;
                           if(var7 == 3) {
                              for(var72 = 0; var72 < var70; ++var72) {
                                 var74 = var3.readInt();
                                 var110[var72] = new byte[var74];
                                 var3.readBytes(var110[var72], 0, var74);
                              }
                           }

                           var63.type[var6] = var7;
                           Class[] var34 = new Class[var70];

                           for(var74 = 0; var74 < var70; ++var74) {
                              var34[var74] = AbstractByteBuffer.loadClassFromDescriptor(var107[var74]);
                           }

                           Class var111 = AbstractByteBuffer.loadClassFromDescriptor(var109);
                           if(AbstractByteBuffer.loadClassFromDescriptor(var83).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var75 = AbstractByteBuffer.loadClassFromDescriptor(var83).getDeclaredMethods();
                           Method[] var17 = var75;

                           for(int var18 = 0; var18 < var17.length; ++var18) {
                              Method var19 = var17[var18];
                              if(Reflection.getMethodName(var19).equals(var101)) {
                                 Class[] var20 = Reflection.getParameterTypes(var19);
                                 if(var34.length == var20.length) {
                                    boolean var21 = true;

                                    for(int var22 = 0; var22 < var34.length; ++var22) {
                                       if(var20[var22] != var34[var22]) {
                                          var21 = false;
                                          break;
                                       }
                                    }

                                    if(var21 && var111 == var19.getReturnType()) {
                                       var63.methods[var6] = var19;
                                    }
                                 }
                              }
                           }

                           var63.args[var6] = var110;
                        }
                     } else {
                        var83 = var3.readString();
                        var101 = var3.readString();
                        var70 = 0;
                        if(var7 == 1) {
                           var70 = var3.readInt();
                        }

                        var63.type[var6] = var7;
                        var63.field3825[var6] = var70;
                        if(AbstractByteBuffer.loadClassFromDescriptor(var83).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var63.fields[var6] = Reflection.findField(AbstractByteBuffer.loadClassFromDescriptor(var83), var101);
                     }
                  } catch (ClassNotFoundException var50) {
                     var63.errorIdentifiers[var6] = -1;
                  } catch (SecurityException var51) {
                     var63.errorIdentifiers[var6] = -2;
                  } catch (NullPointerException var52) {
                     var63.errorIdentifiers[var6] = -3;
                  } catch (Exception var53) {
                     var63.errorIdentifiers[var6] = -4;
                  } catch (Throwable var54) {
                     var63.errorIdentifiers[var6] = -5;
                  }
               }

               class293.classInfos.addFirst(var63);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2280 == var1.serverPacket) {
               var77 = var3.readUnsignedShortOb1();
               ItemContainer var62 = (ItemContainer)ItemContainer.itemContainers.get((long)var77);
               if(var62 != null) {
                  var62.unlink();
               }

               interfaceItemTriggers[++field1044 - 1 & 31] = var77 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2265 == var1.serverPacket) {
               class160.method3100();
               weight = var3.readShort();
               field951 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2269 == var1.serverPacket) {
               var77 = var3.method3383();
               var24 = var3.method3383();
               WidgetNode var93 = (WidgetNode)componentTable.get((long)var24);
               var85 = (WidgetNode)componentTable.get((long)var77);
               if(var85 != null) {
                  class19.method138(var85, var93 == null || var85.id != var93.id);
               }

               if(var93 != null) {
                  var93.unlink();
                  componentTable.put(var93, (long)var77);
               }

               var82 = UrlRequester.getWidget(var24);
               if(var82 != null) {
                  class28.method220(var82);
               }

               var82 = UrlRequester.getWidget(var77);
               if(var82 != null) {
                  class28.method220(var82);
                  class160.method3094(Widget.widgets[var82.id >>> 16], var82, true);
               }

               if(widgetRoot != -1) {
                  var9 = widgetRoot;
                  if(FontName.loadWidget(var9)) {
                     SoundTaskDataProvider.method762(Widget.widgets[var9], 1);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2299 == var1.serverPacket) {
               var77 = var3.readInt();
               var24 = var3.readUnsignedShort();
               if(var77 < -70000) {
                  var24 += 32768;
               }

               if(var77 >= 0) {
                  var90 = UrlRequester.getWidget(var77);
               } else {
                  var90 = null;
               }

               if(var90 != null) {
                  for(var7 = 0; var7 < var90.itemIds.length; ++var7) {
                     var90.itemIds[var7] = 0;
                     var90.itemQuantities[var7] = 0;
                  }
               }

               ItemContainer var88 = (ItemContainer)ItemContainer.itemContainers.get((long)var24);
               if(var88 != null) {
                  for(var8 = 0; var8 < var88.itemIds.length; ++var8) {
                     var88.itemIds[var8] = -1;
                     var88.stackSizes[var8] = 0;
                  }
               }

               var7 = var3.readUnsignedShort();

               for(var8 = 0; var8 < var7; ++var8) {
                  var9 = var3.readUnsignedByteNegate();
                  if(var9 == 255) {
                     var9 = var3.readInt();
                  }

                  var70 = var3.method3518();
                  if(var90 != null && var8 < var90.itemIds.length) {
                     var90.itemIds[var8] = var70;
                     var90.itemQuantities[var8] = var9;
                  }

                  BoundingBox2D.setItemTableSlot(var24, var8, var70 - 1, var9);
               }

               if(var90 != null) {
                  class28.method220(var90);
               }

               class160.method3100();
               interfaceItemTriggers[++field1044 - 1 & 31] = var24 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2262 == var1.serverPacket) {
               CombatInfo1.field1215 = var3.readUnsignedByteNegate();
               WorldMapType2.field505 = var3.method3374();

               while(var3.offset < var1.packetLength) {
                  var77 = var3.readUnsignedByte();
                  class173[] var61 = new class173[]{class173.field2445, class173.field2437, class173.field2438, class173.field2436, class173.field2440, class173.field2442, class173.field2447, class173.field2443, class173.field2444, class173.field2439};
                  class173 var87 = var61[var77];
                  WidgetNode.method1103(var87);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2281 == var1.serverPacket) {
               var77 = var3.method3382();
               var24 = var3.readUnsignedByteNegate();
               var6 = var3.method3518();
               var85 = (WidgetNode)componentTable.get((long)var77);
               if(var85 != null) {
                  class19.method138(var85, var6 != var85.id);
               }

               class60.method1032(var77, var6, var24);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2261 == var1.serverPacket) {
               var77 = var3.readUnsignedByte();
               var24 = var3.method3363();
               var80 = var3.readString();
               if(var24 >= 1 && var24 <= 8) {
                  if(var80.equalsIgnoreCase("null")) {
                     var80 = null;
                  }

                  playerOptions[var24 - 1] = var80;
                  playerOptionsPriorities[var24 - 1] = var77 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2284 == var1.serverPacket) {
               while(var3.offset < var1.packetLength) {
                  var23 = var3.readUnsignedByte() == 1;
                  var5 = var3.readString();
                  var80 = var3.readString();
                  var7 = var3.readUnsignedShort();
                  var8 = var3.readUnsignedByte();
                  var9 = var3.readUnsignedByte();
                  boolean var10 = (var9 & 2) != 0;
                  boolean var37 = (var9 & 1) != 0;
                  if(var7 > 0) {
                     var3.readString();
                     var3.readUnsignedByte();
                     var3.readInt();
                  }

                  var3.readString();

                  for(var39 = 0; var39 < friendCount; ++var39) {
                     Friend var41 = friends[var39];
                     if(!var23) {
                        if(var5.equals(var41.name)) {
                           if(var7 != var41.world) {
                              boolean var14 = true;

                              for(FriendLoginUpdate var42 = (FriendLoginUpdate)field1123.method3845(); var42 != null; var42 = (FriendLoginUpdate)field1123.method3846()) {
                                 if(var42.field783.equals(var5)) {
                                    if(var7 != 0 && var42.field785 == 0) {
                                       var42.method3855();
                                       var14 = false;
                                    } else if(var7 == 0 && var42.field785 != 0) {
                                       var42.method3855();
                                       var14 = false;
                                    }
                                 }
                              }

                              if(var14) {
                                 field1123.method3844(new FriendLoginUpdate(var5, var7));
                              }

                              var41.world = var7;
                           }

                           var41.previousName = var80;
                           var41.rank = var8;
                           var41.field776 = var10;
                           var41.field779 = var37;
                           var5 = null;
                           break;
                        }
                     } else if(var80.equals(var41.name)) {
                        var41.name = var5;
                        var41.previousName = var80;
                        var5 = null;
                        break;
                     }
                  }

                  if(var5 != null && friendCount < 400) {
                     Friend var108 = new Friend();
                     friends[friendCount] = var108;
                     var108.name = var5;
                     var108.previousName = var80;
                     var108.world = var7;
                     var108.rank = var8;
                     var108.field776 = var10;
                     var108.field779 = var37;
                     ++friendCount;
                  }
               }

               field1077 = 2;
               field880 = cycleCntr;
               var23 = false;
               var24 = friendCount;

               while(var24 > 0) {
                  var23 = true;
                  --var24;

                  for(var6 = 0; var6 < var24; ++var6) {
                     var66 = false;
                     Friend var81 = friends[var6];
                     Friend var100 = friends[var6 + 1];
                     if(var81.world != world && var100.world == world) {
                        var66 = true;
                     }

                     if(!var66 && var81.world == 0 && var100.world != 0) {
                        var66 = true;
                     }

                     if(!var66 && !var81.field776 && var100.field776) {
                        var66 = true;
                     }

                     if(!var66 && !var81.field779 && var100.field779) {
                        var66 = true;
                     }

                     if(var66) {
                        Friend var28 = friends[var6];
                        friends[var6] = friends[var6 + 1];
                        friends[var6 + 1] = var28;
                        var23 = false;
                     }
                  }

                  if(var23) {
                     break;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            long var43;
            if(ServerPacket.field2270 == var1.serverPacket) {
               var77 = var3.method3384();
               var24 = var3.method3384();
               var6 = var3.method3518();
               if(var6 == 65535) {
                  var6 = -1;
               }

               var7 = var3.method3518();
               if(var7 == 65535) {
                  var7 = -1;
               }

               for(var8 = var7; var8 <= var6; ++var8) {
                  var43 = ((long)var24 << 32) + (long)var8;
                  Node var106 = widgetFlags.get(var43);
                  if(var106 != null) {
                     var106.unlink();
                  }

                  widgetFlags.put(new IntegerNode(var77), var43);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2305 == var1.serverPacket) {
               while(var3.offset < var1.packetLength) {
                  var77 = var3.readUnsignedByte();
                  var78 = (var77 & 1) == 1;
                  var80 = var3.readString();
                  var84 = var3.readString();
                  var3.readString();

                  for(var8 = 0; var8 < ignoreCount; ++var8) {
                     Ignore var99 = ignores[var8];
                     if(var78) {
                        if(var84.equals(var99.name)) {
                           var99.name = var80;
                           var99.previousName = var84;
                           var80 = null;
                           break;
                        }
                     } else if(var80.equals(var99.name)) {
                        var99.name = var80;
                        var99.previousName = var84;
                        var80 = null;
                        break;
                     }
                  }

                  if(var80 != null && ignoreCount < 400) {
                     Ignore var26 = new Ignore();
                     ignores[ignoreCount] = var26;
                     var26.name = var80;
                     var26.previousName = var84;
                     ++ignoreCount;
                  }
               }

               field880 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2312 == var1.serverPacket) {
               class61.xteaChanged(true, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2300 == var1.serverPacket) {
               if(widgetRoot != -1) {
                  var77 = widgetRoot;
                  if(FontName.loadWidget(var77)) {
                     SoundTaskDataProvider.method762(Widget.widgets[var77], 0);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2250 == var1.serverPacket) {
               byte var79 = var3.method3367();
               var24 = var3.method3518();
               class222.settings[var24] = var79;
               if(class222.widgetSettings[var24] != var79) {
                  class222.widgetSettings[var24] = var79;
               }

               class7.method34(var24);
               field984[++field1042 - 1 & 31] = var24;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2286 == var1.serverPacket) {
               WidgetNode.method1103(class173.field2436);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2295 == var1.serverPacket) {
               class28.method230(var3, var1.packetLength);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2249 == var1.serverPacket) {
               class1.method0();
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2272 == var1.serverPacket) {
               destinationX = var3.readUnsignedByte();
               if(destinationX == 255) {
                  destinationX = 0;
               }

               destinationY = var3.readUnsignedByte();
               if(destinationY == 255) {
                  destinationY = 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2325 == var1.serverPacket) {
               class61.xteaChanged(false, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2319 == var1.serverPacket) {
               field1089 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2327 == var1.serverPacket) {
               for(var77 = 0; var77 < cachedPlayers.length; ++var77) {
                  if(cachedPlayers[var77] != null) {
                     cachedPlayers[var77].animation = -1;
                  }
               }

               for(var77 = 0; var77 < cachedNPCs.length; ++var77) {
                  if(cachedNPCs[var77] != null) {
                     cachedNPCs[var77].animation = -1;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2318 == var1.serverPacket) {
               WidgetNode.method1103(class173.field2447);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2298 == var1.serverPacket) {
               var58 = var3.readString();
               var29 = var3.readLong();
               var31 = (long)var3.readUnsignedShort();
               var43 = (long)var3.read24BitInt();
               Permission[] var38 = new Permission[]{Permission.field3273, Permission.field3275, Permission.field3282, Permission.field3278, Permission.field3272, Permission.field3276};
               Permission var40 = (Permission)class34.forOrdinal(var38, var3.readUnsignedByte());
               long var45 = var43 + (var31 << 32);
               boolean var15 = false;

               for(int var47 = 0; var47 < 100; ++var47) {
                  if(var45 == field1074[var47]) {
                     var15 = true;
                     break;
                  }
               }

               if(var40.field3281 && class33.isIgnored(var58)) {
                  var15 = true;
               }

               if(!var15 && myPlayerIndex == 0) {
                  field1074[field959] = var45;
                  field959 = (field959 + 1) % 100;
                  String var16 = FontTypeFace.appendTags(class159.method3093(UrlRequester.method2972(var3)));
                  if(var40.field3279 != -1) {
                     ScriptVarType.addChatMessage(9, CombatInfoListHolder.method1706(var40.field3279) + var58, var16, UnitPriceComparator.method126(var29));
                  } else {
                     ScriptVarType.addChatMessage(9, var58, var16, UnitPriceComparator.method126(var29));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2296 == var1.serverPacket) {
               var23 = var3.readUnsignedByte() == 1;
               if(var23) {
                  Fonts.field3716 = class60.currentTimeMs() - var3.readLong();
                  class18.grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  class18.grandExchangeEvents = null;
               }

               field1051 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2255 == var1.serverPacket) {
               WidgetNode.method1103(class173.field2444);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2274 == var1.serverPacket) {
               WidgetNode.method1103(class173.field2439);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2247 == var1.serverPacket) {
               var24 = var3.readUnsignedByte();
               class289[] var25 = new class289[]{class289.field3813, class289.field3812, class289.field3814};
               class289[] var27 = var25;
               var8 = 0;

               class289 var57;
               while(true) {
                  if(var8 >= var27.length) {
                     var57 = null;
                     break;
                  }

                  class289 var33 = var27[var8];
                  if(var24 == var33.field3815) {
                     var57 = var33;
                     break;
                  }

                  ++var8;
               }

               class48.field580 = var57;
               var1.serverPacket = null;
               return true;
            }

            Bounds.method5132("" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1470 != null?var1.field1470.packetId:-1) + "," + (var1.field1467 != null?var1.field1467.packetId:-1) + "," + var1.packetLength, (Throwable)null);
            class1.method0();
         } catch (IOException var55) {
            MouseInput.method1025();
         } catch (Exception var56) {
            var5 = "" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1470 != null?var1.field1470.packetId:-1) + "," + (var1.field1467 != null?var1.field1467.packetId:-1) + "," + var1.packetLength + "," + (GrandExchangeOffer.localPlayer.pathX[0] + class175.baseX) + "," + (GrandExchangeOffer.localPlayer.pathY[0] + GraphicsObject.baseY) + ",";

            for(var6 = 0; var6 < var1.packetLength && var6 < 50; ++var6) {
               var5 = var5 + var3.payload[var6] + ",";
            }

            Bounds.method5132(var5, var56);
            class1.method0();
         }

         return true;
      }
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "110"
   )
   final void method1455() {
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
               boolean var6 = menuBooleanArray[var2];
               menuBooleanArray[var2] = menuBooleanArray[var2 + 1];
               menuBooleanArray[var2 + 1] = var6;
               var1 = false;
            }
         }
      }

      if(Frames.field2040 == null) {
         if(field1028 == null) {
            int var8;
            int var11;
            int var15;
            label273: {
               int var13 = MouseInput.mouseLastButton;
               int var10;
               if(isMenuOpen) {
                  if(var13 != 1 && (class45.middleMouseMovesCamera || var13 != 4)) {
                     var2 = MouseInput.mouseLastX;
                     var10 = MouseInput.mouseLastY;
                     if(var2 < Friend.menuX - 10 || var2 > BoundingBox2D.menuWidth + Friend.menuX + 10 || var10 < class163.menuY - 10 || var10 > class34.menuHeight + class163.menuY + 10) {
                        isMenuOpen = false;
                        class23.method167(Friend.menuX, class163.menuY, BoundingBox2D.menuWidth, class34.menuHeight);
                     }
                  }

                  if(var13 == 1 || !class45.middleMouseMovesCamera && var13 == 4) {
                     var2 = Friend.menuX;
                     var10 = class163.menuY;
                     var11 = BoundingBox2D.menuWidth;
                     var5 = MouseInput.mouseLastPressedX;
                     int var14 = MouseInput.mouseLastPressedY;
                     var15 = -1;

                     for(var8 = 0; var8 < menuOptionCount; ++var8) {
                        int var9 = var10 + (menuOptionCount - 1 - var8) * 15 + 31;
                        if(var5 > var2 && var5 < var2 + var11 && var14 > var9 - 13 && var14 < var9 + 3) {
                           var15 = var8;
                        }
                     }

                     if(var15 != -1) {
                        WorldComparator.method60(var15);
                     }

                     isMenuOpen = false;
                     class23.method167(Friend.menuX, class163.menuY, BoundingBox2D.menuWidth, class34.menuHeight);
                  }
               } else {
                  var2 = class240.method4281();
                  if((var13 == 1 || !class45.middleMouseMovesCamera && var13 == 4) && var2 >= 0) {
                     var10 = menuTypes[var2];
                     if(var10 == 39 || var10 == 40 || var10 == 41 || var10 == 42 || var10 == 43 || var10 == 33 || var10 == 34 || var10 == 35 || var10 == 36 || var10 == 37 || var10 == 38 || var10 == 1005) {
                        var11 = menuActionParams0[var2];
                        var5 = menuActionParams1[var2];
                        Widget var12 = UrlRequester.getWidget(var5);
                        if(class29.method236(GraphicsObject.getWidgetConfig(var12))) {
                           break label273;
                        }

                        var8 = GraphicsObject.getWidgetConfig(var12);
                        boolean var7 = (var8 >> 29 & 1) != 0;
                        if(var7) {
                           break label273;
                        }
                     }
                  }

                  if((var13 == 1 || !class45.middleMouseMovesCamera && var13 == 4) && this.method1508()) {
                     var13 = 2;
                  }

                  if((var13 == 1 || !class45.middleMouseMovesCamera && var13 == 4) && menuOptionCount > 0) {
                     WorldComparator.method60(var2);
                  }

                  if(var13 == 2 && menuOptionCount > 0) {
                     this.openMenu(MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                  }
               }

               return;
            }

            if(Frames.field2040 != null && !itemBeingDragged && menuOptionCount > 0 && !this.method1508()) {
               var15 = field969;
               var8 = field970;
               class45.method651(ChatLineBuffer.topContextMenuRow, var15, var8);
               ChatLineBuffer.topContextMenuRow = null;
            }

            itemBeingDragged = false;
            itemPressedDuration = 0;
            if(Frames.field2040 != null) {
               class28.method220(Frames.field2040);
            }

            Frames.field2040 = UrlRequester.getWidget(var5);
            field968 = var11;
            field969 = MouseInput.mouseLastPressedX;
            field970 = MouseInput.mouseLastPressedY;
            if(var2 >= 0) {
               ChatLineBuffer.topContextMenuRow = new ContextMenuRow();
               ChatLineBuffer.topContextMenuRow.param0 = menuActionParams0[var2];
               ChatLineBuffer.topContextMenuRow.param1 = menuActionParams1[var2];
               ChatLineBuffer.topContextMenuRow.type = menuTypes[var2];
               ChatLineBuffer.topContextMenuRow.identifier = menuIdentifiers[var2];
               ChatLineBuffer.topContextMenuRow.option = menuOptions[var2];
            }

            class28.method220(Frames.field2040);
         }
      }
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1831944870"
   )
   final boolean method1508() {
      int var1 = class240.method4281();
      if(menuOptionCount > 2) {
         if(field992 == 1 && !menuBooleanArray[var1]) {
            return true;
         }

         boolean var2;
         if(var1 < 0) {
            var2 = false;
         } else {
            int var3 = menuTypes[var1];
            if(var3 >= 2000) {
               var3 -= 2000;
            }

            if(var3 == 1007) {
               var2 = true;
            } else {
               var2 = false;
            }
         }

         if(var2) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "30"
   )
   @Export("openMenu")
   final void openMenu(int var1, int var2) {
      int var3 = class36.fontBold12.getTextWidth("Choose Option");

      int var4;
      int var5;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         var5 = class36.fontBold12.getTextWidth(class22.method162(var4));
         if(var5 > var3) {
            var3 = var5;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      var5 = var1 - var3 / 2;
      if(var5 + var3 > class87.canvasWidth) {
         var5 = class87.canvasWidth - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      int var6 = var2;
      if(var2 + var4 > class25.canvasHeight) {
         var6 = class25.canvasHeight - var4;
      }

      if(var6 < 0) {
         var6 = 0;
      }

      class45.region.method2772(class7.plane, var1, var2, false);
      isMenuOpen = true;
      Friend.menuX = var5;
      class163.menuY = var6;
      BoundingBox2D.menuWidth = var3;
      class34.menuHeight = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "30"
   )
   final void method1377(boolean var1) {
      int var2 = widgetRoot;
      int var3 = class87.canvasWidth;
      int var4 = class25.canvasHeight;
      if(FontName.loadWidget(var2)) {
         class23.method168(Widget.widgets[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(Lhq;I)V",
      garbageValue = "1679923691"
   )
   @Export("widgetMethod0")
   void widgetMethod0(Widget var1) {
      Widget var2 = var1.parentId == -1?null:UrlRequester.getWidget(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = class87.canvasWidth;
         var4 = class25.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      method1513(var1, var3, var4, false);
      class218.method4083(var1, var3, var4);
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2126466250"
   )
   final void method1348() {
      class28.method220(field1028);
      ++class44.field555;
      if(field1036 && field1033) {
         int var1 = MouseInput.mouseLastX;
         int var2 = MouseInput.mouseLastY;
         var1 -= field925;
         var2 -= field1001;
         if(var1 < field1034) {
            var1 = field1034;
         }

         if(var1 + field1028.width > field1034 + field1029.width) {
            var1 = field1034 + field1029.width - field1028.width;
         }

         if(var2 < field1035) {
            var2 = field1035;
         }

         if(var2 + field1028.height > field1035 + field1029.height) {
            var2 = field1035 + field1029.height - field1028.height;
         }

         int var3 = var1 - field1095;
         int var4 = var2 - field1038;
         int var5 = field1028.field2838;
         if(class44.field555 > field1028.field2821 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1039 = true;
         }

         int var6 = var1 - field1034 + field1029.scrollX;
         int var7 = var2 - field1035 + field1029.scrollY;
         ScriptEvent var8;
         if(field1028.field2820 != null && field1039) {
            var8 = new ScriptEvent();
            var8.widget = field1028;
            var8.field795 = var6;
            var8.field793 = var7;
            var8.objs = field1028.field2820;
            Preferences.method1633(var8);
         }

         if(MouseInput.mouseCurrentButton == 0) {
            if(field1039) {
               if(field1028.field2852 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field1028;
                  var8.field795 = var6;
                  var8.field793 = var7;
                  var8.field797 = field1032;
                  var8.objs = field1028.field2852;
                  Preferences.method1633(var8);
               }

               if(field1032 != null && class153.method3030(field1028) != null) {
                  PacketNode var11 = class235.method4272(ClientPacket.field2340, field915.field1462);
                  var11.packetBuffer.writeShortLE(field1032.id);
                  var11.packetBuffer.writeIntLE16(field1028.index);
                  var11.packetBuffer.putShortLE(field1032.itemId);
                  var11.packetBuffer.putShortLE(field1032.index);
                  var11.packetBuffer.writeIntLE16(field1028.itemId);
                  var11.packetBuffer.method3379(field1028.id);
                  field915.method1898(var11);
               }
            } else if(this.method1508()) {
               this.openMenu(field1095 + field925, field1038 + field1001);
            } else if(menuOptionCount > 0) {
               int var10 = field1095 + field925;
               int var9 = field1038 + field1001;
               class45.method651(ChatLineBuffer.topContextMenuRow, var10, var9);
               ChatLineBuffer.topContextMenuRow = null;
            }

            field1028 = null;
         }

      } else {
         if(class44.field555 > 1) {
            field1028 = null;
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "-2094644513"
   )
   static int method1546(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = UrlRequester.getWidget(class82.intStack[--class82.intStackSize]);
      } else {
         var3 = var2?class82.field1267:CombatInfo1.field1216;
      }

      if(var0 == 1927) {
         if(class82.field1271 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2871 == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.objs = var3.field2871;
            var4.field803 = class82.field1271 + 1;
            field1054.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "9"
   )
   @Export("getItemStackAmountText")
   static final String getItemStackAmountText(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1407889097"
   )
   static void method1548(int var0, String var1) {
      int var2 = class94.playerIndexesCount;
      int[] var3 = class94.playerIndices;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = cachedPlayers[var3[var5]];
         if(var6 != null && var6 != GrandExchangeOffer.localPlayer && var6.name != null && var6.name.equalsIgnoreCase(var1)) {
            PacketNode var7;
            if(var0 == 1) {
               var7 = class235.method4272(ClientPacket.field2357, field915.field1462);
               var7.packetBuffer.method3361(0);
               var7.packetBuffer.putShort(var3[var5]);
               field915.method1898(var7);
            } else if(var0 == 4) {
               var7 = class235.method4272(ClientPacket.field2349, field915.field1462);
               var7.packetBuffer.writeIntLE(var3[var5]);
               var7.packetBuffer.method3362(0);
               field915.method1898(var7);
            } else if(var0 == 6) {
               var7 = class235.method4272(ClientPacket.field2393, field915.field1462);
               var7.packetBuffer.method3360(0);
               var7.packetBuffer.putShort(var3[var5]);
               field915.method1898(var7);
            } else if(var0 == 7) {
               var7 = class235.method4272(ClientPacket.field2376, field915.field1462);
               var7.packetBuffer.method3360(0);
               var7.packetBuffer.writeIntLE(var3[var5]);
               field915.method1898(var7);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         Preferences.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(Lhq;IIZB)V",
      garbageValue = "29"
   )
   static void method1513(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.dynamicWidth == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.dynamicWidth == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.dynamicWidth == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.originalHeight;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.originalHeight;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.originalHeight >> 14;
      }

      if(var0.dynamicWidth == 4) {
         var0.width = var0.field2804 * var0.height / var0.field2780;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.width * var0.field2780 / var0.field2804;
      }

      if(field911 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         field980 = var0;
      }

      if(var3 && var0.field2871 != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.objs = var0.field2871;
         field1054.addFront(var6);
      }

   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Lhq;S)Z",
      garbageValue = "25863"
   )
   static final boolean method1223(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = ClanMember.method1169(var0, var1);
            int var3 = var0.field2841[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }
}
