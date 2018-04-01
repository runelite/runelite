import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
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
public final class Client extends GameEngine implements class302 {
   @ObfuscatedName("rm")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   public static class265 field1132;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = -1589669209
   )
   static int field1059;
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = -645554481
   )
   @Export("widgetCount")
   static int widgetCount;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      longValue = 4246074618980988583L
   )
   static long field1068;
   @ObfuscatedName("nm")
   static boolean[] field1060;
   @ObfuscatedName("nz")
   static boolean[] field1062;
   @ObfuscatedName("ng")
   static boolean[] field1061;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = 2122024019
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("nj")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("mg")
   @ObfuscatedGetter(
      intValue = 1332082195
   )
   static int field1048;
   @ObfuscatedName("rh")
   @ObfuscatedGetter(
      intValue = -1744865959
   )
   public static int field972;
   @ObfuscatedName("ow")
   static boolean field1090;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = 1677151361
   )
   @Export("gameDrawingMode")
   static int gameDrawingMode;
   @ObfuscatedName("md")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("nd")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("nf")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("nl")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("nq")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("rw")
   static int[] field1128;
   @ObfuscatedName("rr")
   static int[] field966;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = 984816653
   )
   @Export("mouseWheelRotation")
   static int mouseWheelRotation;
   @ObfuscatedName("ro")
   @ObfuscatedSignature(
      signature = "Lbm;"
   )
   static final class71 field1127;
   @ObfuscatedName("mq")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   static Deque field1054;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = -1701431247
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = -1321669407
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      intValue = -979304451
   )
   static int field1034;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = 1426301261
   )
   static int field1089;
   @ObfuscatedName("rp")
   static ArrayList field1125;
   @ObfuscatedName("rx")
   @ObfuscatedGetter(
      intValue = -1514882563
   )
   static int field1126;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = -1768869205
   )
   static int field1052;
   @ObfuscatedName("pz")
   static boolean field1099;
   @ObfuscatedName("nc")
   static long[] field989;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      longValue = -6469124750445221143L
   )
   static long field1079;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 1621670469
   )
   static int field1087;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = -672342335
   )
   static int field1072;
   @ObfuscatedName("qn")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static PlayerComposition field1118;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = -264616407
   )
   @Export("queuedSoundEffectCount")
   static int queuedSoundEffectCount;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = -2125085371
   )
   static int field924;
   @ObfuscatedName("pc")
   @Export("queuedSoundEffectIDs")
   static int[] queuedSoundEffectIDs;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = -430253983
   )
   static int field1100;
   @ObfuscatedName("pd")
   @Export("unknownSoundValues1")
   static int[] unknownSoundValues1;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = 1155255277
   )
   static int field1091;
   @ObfuscatedName("pf")
   @Export("unknownSoundValues2")
   static int[] unknownSoundValues2;
   @ObfuscatedName("pq")
   @ObfuscatedSignature(
      signature = "[Lcl;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("pe")
   @Export("soundLocations")
   static int[] soundLocations;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = -79396357
   )
   static int field1044;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = -619123211
   )
   static int field1075;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = -2041790423
   )
   static int field1049;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = 1951892759
   )
   static int field1081;
   @ObfuscatedName("pj")
   static boolean[] field901;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = -1390949823
   )
   static int field1042;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = -1169232249
   )
   @Export("Viewport_xOffset")
   static int Viewport_xOffset;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = 1622222017
   )
   @Export("Viewport_yOffset")
   static int Viewport_yOffset;
   @ObfuscatedName("ol")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   @Export("mapIcons")
   static SpritePixels[] mapIcons;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = -1212678583
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = 1963341667
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("ot")
   static int[] field1082;
   @ObfuscatedName("oq")
   static int[] field1083;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = -603649185
   )
   static int field1076;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = -1082097987
   )
   @Export("chatCycle")
   static int chatCycle;
   @ObfuscatedName("qw")
   static short field1105;
   @ObfuscatedName("qz")
   static short field1106;
   @ObfuscatedName("qo")
   static int[] field861;
   @ObfuscatedName("qu")
   static short field1111;
   @ObfuscatedName("qx")
   static short field1112;
   @ObfuscatedName("ob")
   static int[] field949;
   @ObfuscatedName("qf")
   static short field881;
   @ObfuscatedName("qr")
   static short field876;
   @ObfuscatedName("qg")
   static short field1108;
   @ObfuscatedName("qy")
   static short field926;
   @ObfuscatedName("ok")
   static int[] field1077;
   @ObfuscatedName("mv")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   static Deque field970;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 97263787
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("mf")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   static Deque field1129;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -1592912231
   )
   @Export("publicChatMode")
   static int publicChatMode;
   @ObfuscatedName("ml")
   static int[] field988;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = 874591741
   )
   static int field1035;
   @ObfuscatedName("qk")
   @ObfuscatedSignature(
      signature = "Lf;"
   )
   @Export("grandExchangeEvents")
   static GrandExchangeEvents grandExchangeEvents;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = -1182338929
   )
   static int field879;
   @ObfuscatedName("qe")
   @ObfuscatedSignature(
      signature = "[Lb;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("mw")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = -1284091177
   )
   static int field1119;
   @ObfuscatedName("pl")
   static int[] field1101;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = 663342959
   )
   static int field1008;
   @ObfuscatedName("qc")
   static int[] field1103;
   @ObfuscatedName("qq")
   static int[] field1104;
   @ObfuscatedName("mt")
   static int[] field1045;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = -1620983153
   )
   static int field1046;
   @ObfuscatedName("na")
   static String field869;
   @ObfuscatedName("qm")
   @ObfuscatedSignature(
      signature = "Lbo;"
   )
   static OwnWorldComparator field1057;
   @ObfuscatedName("nk")
   static int[] field1070;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfk;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("an")
   static boolean field856;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -2001318921
   )
   @Export("world")
   public static int world;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1227222983
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1499887071
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   @Export("loginType")
   static JagexLoginType loginType;
   @ObfuscatedName("bh")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("bf")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1212184821
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 139136151
   )
   @Export("gameState")
   static int gameState;
   @ObfuscatedName("be")
   static boolean field865;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -349791995
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      longValue = -56477317167389187L
   )
   @Export("mouseLastLastPressedTimeMillis")
   static long mouseLastLastPressedTimeMillis;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1075871663
   )
   static int field990;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 842171145
   )
   static int field948;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 532436453
   )
   static int field870;
   @ObfuscatedName("bo")
   static boolean field1117;
   @ObfuscatedName("bi")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1136182703
   )
   static int field873;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 458134011
   )
   @Export("hintArrowTargetType")
   static int hintArrowTargetType;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -1830190711
   )
   @Export("hintArrowNpcTargetIdx")
   static int hintArrowNpcTargetIdx;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1420606467
   )
   @Export("hintArrowPlayerTargetIdx")
   static int hintArrowPlayerTargetIdx;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 908221549
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -1094636543
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 846382949
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1749205737
   )
   @Export("hintArrowOffsetX")
   static int hintArrowOffsetX;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -2096404159
   )
   @Export("hintArrowOffsetY")
   static int hintArrowOffsetY;
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Lcv;"
   )
   @Export("playerAttackOption")
   static AttackOption playerAttackOption;
   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "Lcv;"
   )
   @Export("npcAttackOption")
   static AttackOption npcAttackOption;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 532795071
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 446382285
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 754900315
   )
   static int field886;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      longValue = -6568477629224409221L
   )
   static long field887;
   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexCache10")
   static IndexData indexCache10;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -1892215287
   )
   static int field889;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 969268293
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = 615413087
   )
   static int field891;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = -1705683547
   )
   static int field1110;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = -974586155
   )
   static int field894;
   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   static class158 field1041;
   @ObfuscatedName("dd")
   @Export("host")
   static String host;
   @ObfuscatedName("dp")
   static byte[] field896;
   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "[Lcq;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = -1307083879
   )
   @Export("npcIndexesCount")
   static int npcIndexesCount;
   @ObfuscatedName("dc")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = 407650311
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("eg")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "Lco;"
   )
   public static final NetWriter field902;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -1368286137
   )
   static int field903;
   @ObfuscatedName("ev")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("ez")
   static boolean field905;
   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   static class294 field1050;
   @ObfuscatedName("ew")
   @Export("fontsMap")
   static HashMap fontsMap;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -2056609551
   )
   static int field908;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -848386221
   )
   static int field859;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = -364674041
   )
   static int field910;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = -1828725411
   )
   static int field911;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 1229938193
   )
   static int field978;
   @ObfuscatedName("fs")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("ff")
   @Export("instanceTemplateChunks")
   static int[][][] instanceTemplateChunks;
   @ObfuscatedName("fy")
   static final int[] field1058;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = -941928203
   )
   static int field893;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = 1185120615
   )
   static int field918;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = 875225677
   )
   static int field895;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 2038821501
   )
   static int field920;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 1682376703
   )
   static int field921;
   @ObfuscatedName("gg")
   static boolean field927;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 397195761
   )
   static int field1064;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = 1513004305
   )
   @Export("cameraPitchTarget")
   static int cameraPitchTarget;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -1305799137
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 925090017
   )
   static int field913;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = -349075471
   )
   static int field1116;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -1536921327
   )
   static int field928;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 401027777
   )
   static int field929;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -51841621
   )
   static int field930;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 1614995897
   )
   static int field931;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -1545862061
   )
   static int field932;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 1269019027
   )
   static int field933;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -2058047033
   )
   static int field934;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = -999170589
   )
   static int field935;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = -1219616707
   )
   static int field936;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -65450771
   )
   static int field1009;
   @ObfuscatedName("hw")
   static boolean field938;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = -23614665
   )
   static int field939;
   @ObfuscatedName("hm")
   static boolean field940;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = -802475715
   )
   static int field941;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -658715783
   )
   @Export("overheadTextCount")
   static int overheadTextCount;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = -877018619
   )
   static int field962;
   @ObfuscatedName("hl")
   @Export("overheadTextsX")
   static int[] overheadTextsX;
   @ObfuscatedName("hv")
   @Export("overheadTextsY")
   static int[] overheadTextsY;
   @ObfuscatedName("ha")
   @Export("overheadTextsOffsetY")
   static int[] overheadTextsOffsetY;
   @ObfuscatedName("hd")
   @Export("overheadTextsOffsetX")
   static int[] overheadTextsOffsetX;
   @ObfuscatedName("hn")
   static int[] field1073;
   @ObfuscatedName("hh")
   static int[] field984;
   @ObfuscatedName("hq")
   @Export("overheadTextsCyclesRemaining")
   static int[] overheadTextsCyclesRemaining;
   @ObfuscatedName("hs")
   @Export("overheadTexts")
   static String[] overheadTexts;
   @ObfuscatedName("hk")
   static int[][] field952;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = 499861169
   )
   static int field953;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -1666033635
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = -2054555869
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 971070527
   )
   @Export("lastLeftClickX")
   static int lastLeftClickX;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = -60699937
   )
   @Export("lastLeftClickY")
   static int lastLeftClickY;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -1845879255
   )
   static int field958;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = -678051619
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("hp")
   static boolean field937;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = -1171071495
   )
   @Export("mouseCrosshair")
   static int mouseCrosshair;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -931788621
   )
   @Export("pressedItemIndex")
   static int pressedItemIndex;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = -187979791
   )
   static int field1080;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -476449013
   )
   static int field964;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = 1095448979
   )
   static int field1056;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 365485265
   )
   static int field1086;
   @ObfuscatedName("iq")
   static boolean field1109;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = -642182991
   )
   @Export("itemPressedDuration")
   static int itemPressedDuration;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -149980665
   )
   @Export("myPlayerIndex")
   static int myPlayerIndex;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -328602005
   )
   static int field900;
   @ObfuscatedName("id")
   static boolean field960;
   @ObfuscatedName("it")
   @Export("lastSelectedItemName")
   static String lastSelectedItemName;
   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "[Lbx;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = 227169641
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = 1466466705
   )
   static int field973;
   @ObfuscatedName("iv")
   static boolean field974;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = -1162998275
   )
   @Export("playerNameMask")
   static int playerNameMask;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = -764738135
   )
   static int field976;
   @ObfuscatedName("je")
   static int[] field995;
   @ObfuscatedName("jd")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("jc")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("jb")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("ja")
   static int[] field981;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -299840649
   )
   static int field982;
   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "[[[Lhl;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("jo")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("jw")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("jz")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = -1982255601
   )
   static int field884;
   @ObfuscatedName("ji")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = -1898598759
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -111817867
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("kv")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("kn")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("kl")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("kk")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("km")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("kh")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("kf")
   @Export("menuBooleanArray")
   static boolean[] menuBooleanArray;
   @ObfuscatedName("ky")
   static boolean field1094;
   @ObfuscatedName("kg")
   static boolean field1001;
   @ObfuscatedName("ku")
   static boolean field1002;
   @ObfuscatedName("ks")
   static boolean field912;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -31320791
   )
   static int field1004;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 2052976153
   )
   static int field1088;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = 1389803937
   )
   static int field1006;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -1888674719
   )
   static int field1007;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 2018350599
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("ki")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = -279366369
   )
   static int field1012;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 911999699
   )
   static int field1013;
   @ObfuscatedName("lh")
   static String field956;
   @ObfuscatedName("ly")
   static String field1015;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = 177467167
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("lb")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 1363961511
   )
   static int field1018;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = -1707062361
   )
   static int field1019;
   @ObfuscatedName("lz")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static Widget field1102;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = -2109457609
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = 1903921219
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -1611342179
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = 896562403
   )
   static int field1055;
   @ObfuscatedName("lg")
   static boolean field1025;
   @ObfuscatedName("lm")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static Widget field1026;
   @ObfuscatedName("lp")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("draggedWidget")
   static Widget draggedWidget;
   @ObfuscatedName("lc")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static Widget field1028;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = -677827919
   )
   static int field1029;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = 1440584679
   )
   static int field1030;
   @ObfuscatedName("lt")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("draggedOnWidget")
   static Widget draggedOnWidget;
   @ObfuscatedName("lq")
   static boolean field1032;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = -144492221
   )
   static int field1033;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = -2013384965
   )
   static int field980;
   @ObfuscatedName("lw")
   static boolean field877;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = -1799745633
   )
   static int field1124;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -566212587
   )
   static int field1037;
   @ObfuscatedName("ls")
   @Export("draggingWidget")
   static boolean draggingWidget;
   @ObfuscatedName("mh")
   @ObfuscatedSignature(
      signature = "[Lib;"
   )
   static Widget[] field1095;

   static {
      field856 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field865 = true;
      gameCycle = 0;
      mouseLastLastPressedTimeMillis = -1L;
      field990 = -1;
      field948 = -1;
      field870 = -1;
      field1117 = true;
      displayFps = false;
      field873 = 0;
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
      field889 = 0;
      loginState = 0;
      field891 = 0;
      field1110 = 0;
      field894 = 0;
      field1041 = class158.field2153;
      field896 = null;
      cachedNPCs = new NPC['耀'];
      npcIndexesCount = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      field902 = new NetWriter();
      field903 = 0;
      socketError = false;
      field905 = true;
      field1050 = new class294();
      fontsMap = new HashMap();
      field908 = 0;
      field859 = 1;
      field910 = 0;
      field911 = 1;
      field978 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      instanceTemplateChunks = new int[4][13][13];
      field1058 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field893 = 0;
      field918 = 2301979;
      field895 = 5063219;
      field920 = 3353893;
      field921 = 7759444;
      field927 = false;
      field1064 = 0;
      cameraPitchTarget = 128;
      mapAngle = 0;
      field913 = 0;
      field1116 = 0;
      field928 = 0;
      field929 = 0;
      field930 = 0;
      field931 = 50;
      field932 = 0;
      field933 = 0;
      field934 = 0;
      field935 = 12;
      field936 = 6;
      field1009 = 0;
      field938 = false;
      field939 = 0;
      field940 = false;
      field941 = 0;
      overheadTextCount = 0;
      field962 = 50;
      overheadTextsX = new int[field962];
      overheadTextsY = new int[field962];
      overheadTextsOffsetY = new int[field962];
      overheadTextsOffsetX = new int[field962];
      field1073 = new int[field962];
      field984 = new int[field962];
      overheadTextsCyclesRemaining = new int[field962];
      overheadTexts = new String[field962];
      field952 = new int[104][104];
      field953 = 0;
      screenX = -1;
      screenY = -1;
      lastLeftClickX = 0;
      lastLeftClickY = 0;
      field958 = 0;
      cursorState = 0;
      field937 = true;
      mouseCrosshair = 0;
      pressedItemIndex = 0;
      field1080 = 0;
      field964 = 0;
      field1056 = 0;
      field1086 = 0;
      field1109 = false;
      itemPressedDuration = 0;
      myPlayerIndex = 0;
      field960 = true;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field973 = 0;
      field974 = true;
      playerNameMask = 0;
      field976 = 0;
      field995 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field981 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field982 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field884 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      menuBooleanArray = new boolean[500];
      field1094 = false;
      field1001 = false;
      field1002 = false;
      field912 = true;
      field1004 = -1;
      field1088 = -1;
      field1006 = 0;
      field1007 = 50;
      itemSelectionState = 0;
      lastSelectedItemName = null;
      spellSelected = false;
      field1012 = -1;
      field1013 = -1;
      field956 = null;
      field1015 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field1018 = 0;
      field1019 = 0;
      field1102 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1055 = -1;
      field1025 = false;
      field1026 = null;
      draggedWidget = null;
      field1028 = null;
      field1029 = 0;
      field1030 = 0;
      draggedOnWidget = null;
      field1032 = false;
      field1033 = -1;
      field980 = -1;
      field877 = false;
      field1124 = -1;
      field1037 = -1;
      draggingWidget = false;
      cycleCntr = 1;
      field988 = new int[32];
      field1042 = 0;
      interfaceItemTriggers = new int[32];
      field1119 = 0;
      field1045 = new int[32];
      field1046 = 0;
      chatCycle = 0;
      field1048 = 0;
      field1049 = 0;
      field1008 = 0;
      field879 = 0;
      field1052 = 0;
      mouseWheelRotation = 0;
      field1054 = new Deque();
      field970 = new Deque();
      field1129 = new Deque();
      widgetFlags = new HashTable(512);
      widgetCount = 0;
      field1059 = -2;
      field1060 = new boolean[100];
      field1061 = new boolean[100];
      field1062 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1068 = 0L;
      isResized = true;
      field1070 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      publicChatMode = 0;
      field1035 = 0;
      field869 = "";
      field989 = new long[100];
      field1075 = 0;
      field1076 = 0;
      field1077 = new int[128];
      field949 = new int[128];
      field1079 = -1L;
      field1100 = -1;
      field1081 = 0;
      field1082 = new int[1000];
      field1083 = new int[1000];
      mapIcons = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1087 = 0;
      field1044 = 255;
      field1089 = -1;
      field1090 = false;
      field1091 = 127;
      field1034 = 127;
      queuedSoundEffectCount = 0;
      queuedSoundEffectIDs = new int[50];
      unknownSoundValues1 = new int[50];
      unknownSoundValues2 = new int[50];
      soundLocations = new int[50];
      audioEffects = new SoundEffect[50];
      field1099 = false;
      field901 = new boolean[5];
      field1101 = new int[5];
      field861 = new int[5];
      field1103 = new int[5];
      field1104 = new int[5];
      field1105 = 256;
      field1106 = 205;
      field876 = 256;
      field1108 = 320;
      field926 = 1;
      field881 = 32767;
      field1111 = 1;
      field1112 = 32767;
      Viewport_xOffset = 0;
      Viewport_yOffset = 0;
      viewportWidth = 0;
      viewportHeight = 0;
      scale = 0;
      field1118 = new PlayerComposition();
      field1072 = -1;
      field924 = -1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field1057 = new OwnWorldComparator();
      field972 = -1;
      field1125 = new ArrayList(10);
      field1126 = 0;
      field1127 = new class71();
      field1128 = new int[50];
      field966 = new int[50];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "779213061"
   )
   protected final void vmethod1266() {
      field1068 = ScriptVarType.method28() + 500L;
      this.method1312();
      if(widgetRoot != -1) {
         this.method1347(true);
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1009107514"
   )
   @Export("setUp")
   protected final void setUp() {
      int[] var1 = new int[]{20, 260, 10000};
      int[] var2 = new int[]{1000, 100, 500};
      if(var1 != null && var2 != null) {
         PacketNode.field2491 = var1;
         GrandExchangeEvents.field265 = new int[var1.length];
         class195.field2578 = new byte[var1.length][][];

         for(int var3 = 0; var3 < PacketNode.field2491.length; ++var3) {
            class195.field2578[var3] = new byte[var2[var3]][];
         }
      } else {
         PacketNode.field2491 = null;
         GrandExchangeEvents.field265 = null;
         class195.field2578 = null;
      }

      WorldMapRegion.port1 = socketType == 0?43594:world + 40000;
      FontName.port2 = socketType == 0?443:world + 50000;
      Player.myWorldPort = WorldMapRegion.port1;
      PlayerComposition.colorsToFind = class240.field2793;
      GameCanvas.colorsToReplace = class240.field2795;
      PlayerComposition.field2787 = class240.field2794;
      PlayerComposition.field2780 = class240.field2792;
      MapIconReference.urlRequester = new UrlRequester();
      this.setUpKeyboard();
      this.setUpMouse();
      class49.mouseWheel = this.mouseWheel();
      GameCanvas.indexStore255 = new IndexFile(255, class167.dat2File, class167.idx255File, 500000);
      FileOnDisk var4 = null;
      Preferences var5 = new Preferences();

      try {
         var4 = Renderable.getPreferencesFile("", class71.field816.name, false);
         byte[] var6 = new byte[(int)var4.length()];

         int var8;
         for(int var7 = 0; var7 < var6.length; var7 += var8) {
            var8 = var4.read(var6, var7, var6.length - var7);
            if(var8 == -1) {
               throw new IOException();
            }
         }

         var5 = new Preferences(new Buffer(var6));
      } catch (Exception var11) {
         ;
      }

      try {
         if(var4 != null) {
            var4.close();
         }
      } catch (Exception var10) {
         ;
      }

      class46.preferences = var5;
      this.setUpClipboard();
      Buffer.method3581(this, class95.field1439);
      if(socketType != 0) {
         displayFps = true;
      }

      AttackOption.method1859(class46.preferences.screenType);
      RunException.friendManager = new FriendManager(loginType);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-299387202"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();

      while(true) {
         Deque var2 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         FileSystem var1;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            var1 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_responseQueue.popFront();
         }

         if(var1 == null) {
            UrlRequest.method3108();
            class33.method384();
            class190.method3486();
            MouseInput var64 = MouseInput.mouse;
            synchronized(MouseInput.mouse) {
               MouseInput.mouseCurrentButton = MouseInput.MouseHandler_currentButton;
               MouseInput.mouseLastX = MouseInput.mouseX;
               MouseInput.mouseLastY = MouseInput.mouseY;
               MouseInput.mouseLastButton = MouseInput.MouseHandler_lastButton;
               MouseInput.mouseLastPressedX = MouseInput.MouseHandler_lastPressedX;
               MouseInput.mouseLastPressedY = MouseInput.MouseHandler_lastPressedY;
               MouseInput.mouseLastPressedTimeMillis = MouseInput.MouseHandler_lastPressedTimeMillis;
               MouseInput.MouseHandler_lastButton = 0;
            }

            if(class49.mouseWheel != null) {
               int var45 = class49.mouseWheel.useRotation();
               mouseWheelRotation = var45;
            }

            if(gameState == 0) {
               GrandExchangeEvent.load();
               MapIcon.method576();
            } else if(gameState == 5) {
               TotalQuantityComparator.method108(this);
               GrandExchangeEvent.load();
               MapIcon.method576();
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  TotalQuantityComparator.method108(this);
                  this.method1204();
               } else if(gameState == 25) {
                  class173.flush(false);
                  field908 = 0;
                  boolean var73 = true;

                  int var46;
                  for(var46 = 0; var46 < FrameMap.field1970.length; ++var46) {
                     if(FontName.landMapFileIds[var46] != -1 && FrameMap.field1970[var46] == null) {
                        FrameMap.field1970[var46] = class1.indexMaps.getConfigData(FontName.landMapFileIds[var46], 0);
                        if(FrameMap.field1970[var46] == null) {
                           var73 = false;
                           ++field908;
                        }
                     }

                     if(class185.landRegionFileIds[var46] != -1 && class245.field2960[var46] == null) {
                        class245.field2960[var46] = class1.indexMaps.getConfigDataKeys(class185.landRegionFileIds[var46], 0, Size.xteaKeys[var46]);
                        if(class245.field2960[var46] == null) {
                           var73 = false;
                           ++field908;
                        }
                     }
                  }

                  if(!var73) {
                     field978 = 1;
                  } else {
                     field910 = 0;
                     var73 = true;

                     int var5;
                     int var47;
                     for(var46 = 0; var46 < FrameMap.field1970.length; ++var46) {
                        byte[] var3 = class245.field2960[var46];
                        if(var3 != null) {
                           var47 = (Size.mapRegions[var46] >> 8) * 64 - PacketNode.baseX;
                           var5 = (Size.mapRegions[var46] & 255) * 64 - BaseVarType.baseY;
                           if(isDynamicRegion) {
                              var47 = 10;
                              var5 = 10;
                           }

                           var73 &= GrandExchangeEvents.method84(var3, var47, var5);
                        }
                     }

                     if(!var73) {
                        field978 = 2;
                     } else {
                        if(field978 != 0) {
                           VertexNormal.method2787("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        class33.method384();
                        class308.region.reset();

                        for(var46 = 0; var46 < 4; ++var46) {
                           collisionMaps[var46].reset();
                        }

                        int var48;
                        for(var46 = 0; var46 < 4; ++var46) {
                           for(var48 = 0; var48 < 104; ++var48) {
                              for(var47 = 0; var47 < 104; ++var47) {
                                 class62.tileSettings[var46][var48][var47] = 0;
                              }
                           }
                        }

                        class33.method384();
                        MapIcon.method570();
                        var46 = FrameMap.field1970.length;
                        class231.method4261();
                        class173.flush(true);
                        int var7;
                        int var8;
                        int var10;
                        int var11;
                        int var12;
                        int var13;
                        int var50;
                        if(!isDynamicRegion) {
                           var48 = 0;

                           label1367:
                           while(true) {
                              byte[] var6;
                              if(var48 >= var46) {
                                 for(var48 = 0; var48 < var46; ++var48) {
                                    var47 = (Size.mapRegions[var48] >> 8) * 64 - PacketNode.baseX;
                                    var5 = (Size.mapRegions[var48] & 255) * 64 - BaseVarType.baseY;
                                    var6 = FrameMap.field1970[var48];
                                    if(var6 == null && ItemContainer.field756 < 800) {
                                       class33.method384();
                                       NPC.method1839(var47, var5, 64, 64);
                                    }
                                 }

                                 class173.flush(true);
                                 var48 = 0;

                                 while(true) {
                                    if(var48 >= var46) {
                                       break label1367;
                                    }

                                    byte[] var4 = class245.field2960[var48];
                                    if(var4 != null) {
                                       var5 = (Size.mapRegions[var48] >> 8) * 64 - PacketNode.baseX;
                                       var50 = (Size.mapRegions[var48] & 255) * 64 - BaseVarType.baseY;
                                       class33.method384();
                                       Actor.method1587(var4, var5, var50, class308.region, collisionMaps);
                                    }

                                    ++var48;
                                 }
                              }

                              var47 = (Size.mapRegions[var48] >> 8) * 64 - PacketNode.baseX;
                              var5 = (Size.mapRegions[var48] & 255) * 64 - BaseVarType.baseY;
                              var6 = FrameMap.field1970[var48];
                              if(var6 != null) {
                                 class33.method384();
                                 var7 = class171.field2225 * 8 - 48;
                                 var8 = ItemContainer.field756 * 8 - 48;
                                 CollisionData[] var9 = collisionMaps;
                                 var10 = 0;

                                 label1364:
                                 while(true) {
                                    if(var10 >= 4) {
                                       Buffer var49 = new Buffer(var6);
                                       var11 = 0;

                                       while(true) {
                                          if(var11 >= 4) {
                                             break label1364;
                                          }

                                          for(var12 = 0; var12 < 64; ++var12) {
                                             for(var13 = 0; var13 < 64; ++var13) {
                                                ItemLayer.loadTerrain(var49, var11, var12 + var47, var5 + var13, var7, var8, 0);
                                             }
                                          }

                                          ++var11;
                                       }
                                    }

                                    for(var11 = 0; var11 < 64; ++var11) {
                                       for(var12 = 0; var12 < 64; ++var12) {
                                          if(var11 + var47 > 0 && var47 + var11 < 103 && var12 + var5 > 0 && var12 + var5 < 103) {
                                             var9[var10].flags[var11 + var47][var5 + var12] &= -16777217;
                                          }
                                       }
                                    }

                                    ++var10;
                                 }
                              }

                              ++var48;
                           }
                        }

                        int var15;
                        int var16;
                        int var17;
                        int var18;
                        int var20;
                        int var21;
                        int var22;
                        int var23;
                        int var25;
                        int var26;
                        int var27;
                        int var28;
                        int var29;
                        int var30;
                        int var32;
                        int var34;
                        int var35;
                        int var36;
                        int var37;
                        int var39;
                        int var40;
                        int var41;
                        int var51;
                        int var54;
                        int var56;
                        if(isDynamicRegion) {
                           var48 = 0;

                           label1313:
                           while(true) {
                              CollisionData[] var19;
                              Buffer var52;
                              if(var48 >= 4) {
                                 for(var48 = 0; var48 < 13; ++var48) {
                                    for(var47 = 0; var47 < 13; ++var47) {
                                       var5 = instanceTemplateChunks[0][var48][var47];
                                       if(var5 == -1) {
                                          NPC.method1839(var48 * 8, var47 * 8, 8, 8);
                                       }
                                    }
                                 }

                                 class173.flush(true);
                                 var48 = 0;

                                 while(true) {
                                    if(var48 >= 4) {
                                       break label1313;
                                    }

                                    class33.method384();

                                    for(var47 = 0; var47 < 13; ++var47) {
                                       label1202:
                                       for(var5 = 0; var5 < 13; ++var5) {
                                          var50 = instanceTemplateChunks[var48][var47][var5];
                                          if(var50 != -1) {
                                             var7 = var50 >> 24 & 3;
                                             var8 = var50 >> 1 & 3;
                                             var51 = var50 >> 14 & 1023;
                                             var10 = var50 >> 3 & 2047;
                                             var11 = (var51 / 8 << 8) + var10 / 8;

                                             for(var12 = 0; var12 < Size.mapRegions.length; ++var12) {
                                                if(Size.mapRegions[var12] == var11 && class245.field2960[var12] != null) {
                                                   byte[] var53 = class245.field2960[var12];
                                                   var54 = var47 * 8;
                                                   var15 = var5 * 8;
                                                   var16 = (var51 & 7) * 8;
                                                   var17 = (var10 & 7) * 8;
                                                   Region var55 = class308.region;
                                                   var19 = collisionMaps;
                                                   var52 = new Buffer(var53);
                                                   var21 = -1;

                                                   while(true) {
                                                      var22 = var52.getUSmart();
                                                      if(var22 == 0) {
                                                         continue label1202;
                                                      }

                                                      var21 += var22;
                                                      var23 = 0;

                                                      while(true) {
                                                         var56 = var52.getUSmart();
                                                         if(var56 == 0) {
                                                            break;
                                                         }

                                                         var23 += var56 - 1;
                                                         var25 = var23 & 63;
                                                         var26 = var23 >> 6 & 63;
                                                         var27 = var23 >> 12;
                                                         var28 = var52.readUnsignedByte();
                                                         var29 = var28 >> 2;
                                                         var30 = var28 & 3;
                                                         if(var7 == var27 && var26 >= var16 && var26 < var16 + 8 && var25 >= var17 && var25 < var17 + 8) {
                                                            ObjectComposition var31 = FileRequest.getObjectDefinition(var21);
                                                            var32 = var54 + InvType.method4738(var26 & 7, var25 & 7, var8, var31.width, var31.length, var30);
                                                            var35 = var26 & 7;
                                                            var36 = var25 & 7;
                                                            int var38 = var31.width;
                                                            var39 = var31.length;
                                                            if((var30 & 1) == 1) {
                                                               var40 = var38;
                                                               var38 = var39;
                                                               var39 = var40;
                                                            }

                                                            var37 = var8 & 3;
                                                            if(var37 == 0) {
                                                               var34 = var36;
                                                            } else if(var37 == 1) {
                                                               var34 = 7 - var35 - (var38 - 1);
                                                            } else if(var37 == 2) {
                                                               var34 = 7 - var36 - (var39 - 1);
                                                            } else {
                                                               var34 = var35;
                                                            }

                                                            var40 = var15 + var34;
                                                            if(var32 > 0 && var40 > 0 && var32 < 103 && var40 < 103) {
                                                               var41 = var48;
                                                               if((class62.tileSettings[1][var32][var40] & 2) == 2) {
                                                                  var41 = var48 - 1;
                                                               }

                                                               CollisionData var42 = null;
                                                               if(var41 >= 0) {
                                                                  var42 = var19[var41];
                                                               }

                                                               class234.addObject(var48, var32, var40, var21, var30 + var8 & 3, var29, var55, var42);
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++var48;
                                 }
                              }

                              class33.method384();

                              for(var47 = 0; var47 < 13; ++var47) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    boolean var74 = false;
                                    var7 = instanceTemplateChunks[var48][var47][var5];
                                    if(var7 != -1) {
                                       var8 = var7 >> 24 & 3;
                                       var51 = var7 >> 1 & 3;
                                       var10 = var7 >> 14 & 1023;
                                       var11 = var7 >> 3 & 2047;
                                       var12 = (var10 / 8 << 8) + var11 / 8;

                                       for(var13 = 0; var13 < Size.mapRegions.length; ++var13) {
                                          if(Size.mapRegions[var13] == var12 && FrameMap.field1970[var13] != null) {
                                             byte[] var14 = FrameMap.field1970[var13];
                                             var15 = var47 * 8;
                                             var16 = var5 * 8;
                                             var17 = (var10 & 7) * 8;
                                             var18 = (var11 & 7) * 8;
                                             var19 = collisionMaps;

                                             for(var20 = 0; var20 < 8; ++var20) {
                                                for(var21 = 0; var21 < 8; ++var21) {
                                                   if(var15 + var20 > 0 && var15 + var20 < 103 && var21 + var16 > 0 && var21 + var16 < 103) {
                                                      var19[var48].flags[var15 + var20][var16 + var21] &= -16777217;
                                                   }
                                                }
                                             }

                                             var52 = new Buffer(var14);

                                             for(var21 = 0; var21 < 4; ++var21) {
                                                for(var22 = 0; var22 < 64; ++var22) {
                                                   for(var23 = 0; var23 < 64; ++var23) {
                                                      if(var8 == var21 && var22 >= var17 && var22 < var17 + 8 && var23 >= var18 && var23 < var18 + 8) {
                                                         var28 = var22 & 7;
                                                         var29 = var23 & 7;
                                                         var30 = var51 & 3;
                                                         if(var30 == 0) {
                                                            var27 = var28;
                                                         } else if(var30 == 1) {
                                                            var27 = var29;
                                                         } else if(var30 == 2) {
                                                            var27 = 7 - var28;
                                                         } else {
                                                            var27 = 7 - var29;
                                                         }

                                                         ItemLayer.loadTerrain(var52, var48, var27 + var15, var16 + IndexDataBase.method4648(var22 & 7, var23 & 7, var51), 0, 0, var51);
                                                      } else {
                                                         ItemLayer.loadTerrain(var52, 0, -1, -1, 0, 0, 0);
                                                      }
                                                   }
                                                }
                                             }

                                             var74 = true;
                                             break;
                                          }
                                       }
                                    }

                                    if(!var74) {
                                       var8 = var48;
                                       var51 = var47 * 8;
                                       var10 = var5 * 8;

                                       for(var11 = 0; var11 < 8; ++var11) {
                                          for(var12 = 0; var12 < 8; ++var12) {
                                             class62.tileHeights[var8][var51 + var11][var12 + var10] = 0;
                                          }
                                       }

                                       if(var51 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class62.tileHeights[var8][var51][var11 + var10] = class62.tileHeights[var8][var51 - 1][var11 + var10];
                                          }
                                       }

                                       if(var10 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class62.tileHeights[var8][var51 + var11][var10] = class62.tileHeights[var8][var51 + var11][var10 - 1];
                                          }
                                       }

                                       if(var51 > 0 && class62.tileHeights[var8][var51 - 1][var10] != 0) {
                                          class62.tileHeights[var8][var51][var10] = class62.tileHeights[var8][var51 - 1][var10];
                                       } else if(var10 > 0 && class62.tileHeights[var8][var51][var10 - 1] != 0) {
                                          class62.tileHeights[var8][var51][var10] = class62.tileHeights[var8][var51][var10 - 1];
                                       } else if(var51 > 0 && var10 > 0 && class62.tileHeights[var8][var51 - 1][var10 - 1] != 0) {
                                          class62.tileHeights[var8][var51][var10] = class62.tileHeights[var8][var51 - 1][var10 - 1];
                                       }
                                    }
                                 }
                              }

                              ++var48;
                           }
                        }

                        class173.flush(true);
                        class33.method384();
                        Region var65 = class308.region;
                        CollisionData[] var66 = collisionMaps;

                        for(var5 = 0; var5 < 4; ++var5) {
                           for(var50 = 0; var50 < 104; ++var50) {
                              for(var7 = 0; var7 < 104; ++var7) {
                                 if((class62.tileSettings[var5][var50][var7] & 1) == 1) {
                                    var8 = var5;
                                    if((class62.tileSettings[1][var50][var7] & 2) == 2) {
                                       var8 = var5 - 1;
                                    }

                                    if(var8 >= 0) {
                                       var66[var8].method3371(var50, var7);
                                    }
                                 }
                              }
                           }
                        }

                        class62.field734 += (int)(Math.random() * 5.0D) - 2;
                        if(class62.field734 < -8) {
                           class62.field734 = -8;
                        }

                        if(class62.field734 > 8) {
                           class62.field734 = 8;
                        }

                        class62.field735 += (int)(Math.random() * 5.0D) - 2;
                        if(class62.field735 < -16) {
                           class62.field735 = -16;
                        }

                        if(class62.field735 > 16) {
                           class62.field735 = 16;
                        }

                        int var57;
                        for(var5 = 0; var5 < 4; ++var5) {
                           byte[][] var67 = class62.field725[var5];
                           var12 = (int)Math.sqrt(5100.0D);
                           var13 = var12 * 768 >> 8;

                           for(var54 = 1; var54 < 103; ++var54) {
                              for(var15 = 1; var15 < 103; ++var15) {
                                 var16 = class62.tileHeights[var5][var15 + 1][var54] - class62.tileHeights[var5][var15 - 1][var54];
                                 var17 = class62.tileHeights[var5][var15][var54 + 1] - class62.tileHeights[var5][var15][var54 - 1];
                                 var18 = (int)Math.sqrt((double)(var16 * var16 + var17 * var17 + 65536));
                                 var57 = (var16 << 8) / var18;
                                 var20 = 65536 / var18;
                                 var21 = (var17 << 8) / var18;
                                 var22 = (var21 * -50 + var57 * -50 + var20 * -10) / var13 + 96;
                                 var23 = (var67[var15 - 1][var54] >> 2) + (var67[var15][var54 - 1] >> 2) + (var67[var15 + 1][var54] >> 3) + (var67[var15][var54 + 1] >> 3) + (var67[var15][var54] >> 1);
                                 class62.field719[var15][var54] = var22 - var23;
                              }
                           }

                           for(var54 = 0; var54 < 104; ++var54) {
                              AttackOption.floorHues[var54] = 0;
                              class1.floorSaturations[var54] = 0;
                              class204.field2613[var54] = 0;
                              class57.floorMultiplier[var54] = 0;
                              FrameMap.field1973[var54] = 0;
                           }

                           for(var54 = -5; var54 < 109; ++var54) {
                              for(var15 = 0; var15 < 104; ++var15) {
                                 var16 = var54 + 5;
                                 if(var16 >= 0 && var16 < 104) {
                                    var17 = class62.tileUnderlayIds[var5][var16][var15] & 255;
                                    if(var17 > 0) {
                                       FloorUnderlayDefinition var75 = WidgetNode.getUnderlayDefinition(var17 - 1);
                                       AttackOption.floorHues[var15] += var75.hue;
                                       class1.floorSaturations[var15] += var75.saturation;
                                       class204.field2613[var15] += var75.lightness;
                                       class57.floorMultiplier[var15] += var75.hueMultiplier;
                                       ++FrameMap.field1973[var15];
                                    }
                                 }

                                 var17 = var54 - 5;
                                 if(var17 >= 0 && var17 < 104) {
                                    var18 = class62.tileUnderlayIds[var5][var17][var15] & 255;
                                    if(var18 > 0) {
                                       FloorUnderlayDefinition var69 = WidgetNode.getUnderlayDefinition(var18 - 1);
                                       AttackOption.floorHues[var15] -= var69.hue;
                                       class1.floorSaturations[var15] -= var69.saturation;
                                       class204.field2613[var15] -= var69.lightness;
                                       class57.floorMultiplier[var15] -= var69.hueMultiplier;
                                       --FrameMap.field1973[var15];
                                    }
                                 }
                              }

                              if(var54 >= 1 && var54 < 103) {
                                 var15 = 0;
                                 var16 = 0;
                                 var17 = 0;
                                 var18 = 0;
                                 var57 = 0;

                                 for(var20 = -5; var20 < 109; ++var20) {
                                    var21 = var20 + 5;
                                    if(var21 >= 0 && var21 < 104) {
                                       var15 += AttackOption.floorHues[var21];
                                       var16 += class1.floorSaturations[var21];
                                       var17 += class204.field2613[var21];
                                       var18 += class57.floorMultiplier[var21];
                                       var57 += FrameMap.field1973[var21];
                                    }

                                    var22 = var20 - 5;
                                    if(var22 >= 0 && var22 < 104) {
                                       var15 -= AttackOption.floorHues[var22];
                                       var16 -= class1.floorSaturations[var22];
                                       var17 -= class204.field2613[var22];
                                       var18 -= class57.floorMultiplier[var22];
                                       var57 -= FrameMap.field1973[var22];
                                    }

                                    if(var20 >= 1 && var20 < 103 && (!lowMemory || (class62.tileSettings[0][var54][var20] & 2) != 0 || (class62.tileSettings[var5][var54][var20] & 16) == 0)) {
                                       if(var5 < class62.field722) {
                                          class62.field722 = var5;
                                       }

                                       var23 = class62.tileUnderlayIds[var5][var54][var20] & 255;
                                       var56 = class62.tileOverlayIds[var5][var54][var20] & 255;
                                       if(var23 > 0 || var56 > 0) {
                                          var25 = class62.tileHeights[var5][var54][var20];
                                          var26 = class62.tileHeights[var5][var54 + 1][var20];
                                          var27 = class62.tileHeights[var5][var54 + 1][var20 + 1];
                                          var28 = class62.tileHeights[var5][var54][var20 + 1];
                                          var29 = class62.field719[var54][var20];
                                          var30 = class62.field719[var54 + 1][var20];
                                          int var58 = class62.field719[var54 + 1][var20 + 1];
                                          var32 = class62.field719[var54][var20 + 1];
                                          int var33 = -1;
                                          var34 = -1;
                                          if(var23 > 0) {
                                             var35 = var15 * 256 / var18;
                                             var36 = var16 / var57;
                                             var37 = var17 / var57;
                                             var33 = class189.method3482(var35, var36, var37);
                                             var35 = var35 + class62.field734 & 255;
                                             var37 += class62.field735;
                                             if(var37 < 0) {
                                                var37 = 0;
                                             } else if(var37 > 255) {
                                                var37 = 255;
                                             }

                                             var34 = class189.method3482(var35, var36, var37);
                                          }

                                          if(var5 > 0) {
                                             boolean var71 = true;
                                             if(var23 == 0 && class62.tileOverlayPath[var5][var54][var20] != 0) {
                                                var71 = false;
                                             }

                                             if(var56 > 0 && !VarPlayerType.getOverlayDefinition(var56 - 1).isHidden) {
                                                var71 = false;
                                             }

                                             if(var71 && var25 == var26 && var25 == var27 && var28 == var25) {
                                                class62.field721[var5][var54][var20] |= 2340;
                                             }
                                          }

                                          var35 = 0;
                                          if(var34 != -1) {
                                             var35 = Graphics3D.colorPalette[BaseVarType.method12(var34, 96)];
                                          }

                                          if(var56 == 0) {
                                             var65.addTile(var5, var54, var20, 0, 0, -1, var25, var26, var27, var28, BaseVarType.method12(var33, var29), BaseVarType.method12(var33, var30), BaseVarType.method12(var33, var58), BaseVarType.method12(var33, var32), 0, 0, 0, 0, var35, 0);
                                          } else {
                                             var36 = class62.tileOverlayPath[var5][var54][var20] + 1;
                                             byte var72 = RunException.overlayRotations[var5][var54][var20];
                                             Overlay var59 = VarPlayerType.getOverlayDefinition(var56 - 1);
                                             var39 = var59.texture;
                                             int var43;
                                             int var60;
                                             if(var39 >= 0) {
                                                var41 = Graphics3D.textureLoader.getAverageTextureRGB(var39);
                                                var40 = -1;
                                             } else if(var59.color == 16711935) {
                                                var40 = -2;
                                                var39 = -1;
                                                var41 = -2;
                                             } else {
                                                var40 = class189.method3482(var59.hue, var59.saturation, var59.lightness);
                                                var60 = var59.hue + class62.field734 & 255;
                                                var43 = var59.lightness + class62.field735;
                                                if(var43 < 0) {
                                                   var43 = 0;
                                                } else if(var43 > 255) {
                                                   var43 = 255;
                                                }

                                                var41 = class189.method3482(var60, var59.saturation, var43);
                                             }

                                             var60 = 0;
                                             if(var41 != -2) {
                                                var60 = Graphics3D.colorPalette[class153.adjustHSLListness0(var41, 96)];
                                             }

                                             if(var59.otherRgbColor != -1) {
                                                var43 = var59.otherHue + class62.field734 & 255;
                                                int var44 = var59.otherLightness + class62.field735;
                                                if(var44 < 0) {
                                                   var44 = 0;
                                                } else if(var44 > 255) {
                                                   var44 = 255;
                                                }

                                                var41 = class189.method3482(var43, var59.otherSaturation, var44);
                                                var60 = Graphics3D.colorPalette[class153.adjustHSLListness0(var41, 96)];
                                             }

                                             var65.addTile(var5, var54, var20, var36, var72, var39, var25, var26, var27, var28, BaseVarType.method12(var33, var29), BaseVarType.method12(var33, var30), BaseVarType.method12(var33, var58), BaseVarType.method12(var33, var32), class153.adjustHSLListness0(var40, var29), class153.adjustHSLListness0(var40, var30), class153.adjustHSLListness0(var40, var58), class153.adjustHSLListness0(var40, var32), var35, var60);
                                          }
                                       }
                                    }
                                 }
                              }
                           }

                           for(var54 = 1; var54 < 103; ++var54) {
                              for(var15 = 1; var15 < 103; ++var15) {
                                 if((class62.tileSettings[var5][var15][var54] & 8) != 0) {
                                    var20 = 0;
                                 } else if(var5 > 0 && (class62.tileSettings[1][var15][var54] & 2) != 0) {
                                    var20 = var5 - 1;
                                 } else {
                                    var20 = var5;
                                 }

                                 var65.setPhysicalLevel(var5, var15, var54, var20);
                              }
                           }

                           class62.tileUnderlayIds[var5] = null;
                           class62.tileOverlayIds[var5] = null;
                           class62.tileOverlayPath[var5] = null;
                           RunException.overlayRotations[var5] = null;
                           class62.field725[var5] = null;
                        }

                        var65.applyLighting(-50, -10, -50);

                        for(var5 = 0; var5 < 104; ++var5) {
                           for(var50 = 0; var50 < 104; ++var50) {
                              if((class62.tileSettings[1][var5][var50] & 2) == 2) {
                                 var65.setBridge(var5, var50);
                              }
                           }
                        }

                        var5 = 1;
                        var50 = 2;
                        var7 = 4;

                        for(var8 = 0; var8 < 4; ++var8) {
                           if(var8 > 0) {
                              var5 <<= 3;
                              var50 <<= 3;
                              var7 <<= 3;
                           }

                           for(var51 = 0; var51 <= var8; ++var51) {
                              for(var10 = 0; var10 <= 104; ++var10) {
                                 for(var11 = 0; var11 <= 104; ++var11) {
                                    short var70;
                                    if((class62.field721[var51][var11][var10] & var5) != 0) {
                                       var12 = var10;
                                       var13 = var10;
                                       var54 = var51;

                                       for(var15 = var51; var12 > 0 && (class62.field721[var51][var11][var12 - 1] & var5) != 0; --var12) {
                                          ;
                                       }

                                       while(var13 < 104 && (class62.field721[var51][var11][var13 + 1] & var5) != 0) {
                                          ++var13;
                                       }

                                       label921:
                                       while(var54 > 0) {
                                          for(var16 = var12; var16 <= var13; ++var16) {
                                             if((class62.field721[var54 - 1][var11][var16] & var5) == 0) {
                                                break label921;
                                             }
                                          }

                                          --var54;
                                       }

                                       label910:
                                       while(var15 < var8) {
                                          for(var16 = var12; var16 <= var13; ++var16) {
                                             if((class62.field721[var15 + 1][var11][var16] & var5) == 0) {
                                                break label910;
                                             }
                                          }

                                          ++var15;
                                       }

                                       var16 = (var15 + 1 - var54) * (var13 - var12 + 1);
                                       if(var16 >= 8) {
                                          var70 = 240;
                                          var18 = class62.tileHeights[var15][var11][var12] - var70;
                                          var57 = class62.tileHeights[var54][var11][var12];
                                          Region.addOcclude(var8, 1, var11 * 128, var11 * 128, var12 * 128, var13 * 128 + 128, var18, var57);

                                          for(var20 = var54; var20 <= var15; ++var20) {
                                             for(var21 = var12; var21 <= var13; ++var21) {
                                                class62.field721[var20][var11][var21] &= ~var5;
                                             }
                                          }
                                       }
                                    }

                                    if((class62.field721[var51][var11][var10] & var50) != 0) {
                                       var12 = var11;
                                       var13 = var11;
                                       var54 = var51;

                                       for(var15 = var51; var12 > 0 && (class62.field721[var51][var12 - 1][var10] & var50) != 0; --var12) {
                                          ;
                                       }

                                       while(var13 < 104 && (class62.field721[var51][var13 + 1][var10] & var50) != 0) {
                                          ++var13;
                                       }

                                       label974:
                                       while(var54 > 0) {
                                          for(var16 = var12; var16 <= var13; ++var16) {
                                             if((class62.field721[var54 - 1][var16][var10] & var50) == 0) {
                                                break label974;
                                             }
                                          }

                                          --var54;
                                       }

                                       label963:
                                       while(var15 < var8) {
                                          for(var16 = var12; var16 <= var13; ++var16) {
                                             if((class62.field721[var15 + 1][var16][var10] & var50) == 0) {
                                                break label963;
                                             }
                                          }

                                          ++var15;
                                       }

                                       var16 = (var13 - var12 + 1) * (var15 + 1 - var54);
                                       if(var16 >= 8) {
                                          var70 = 240;
                                          var18 = class62.tileHeights[var15][var12][var10] - var70;
                                          var57 = class62.tileHeights[var54][var12][var10];
                                          Region.addOcclude(var8, 2, var12 * 128, var13 * 128 + 128, var10 * 128, var10 * 128, var18, var57);

                                          for(var20 = var54; var20 <= var15; ++var20) {
                                             for(var21 = var12; var21 <= var13; ++var21) {
                                                class62.field721[var20][var21][var10] &= ~var50;
                                             }
                                          }
                                       }
                                    }

                                    if((class62.field721[var51][var11][var10] & var7) != 0) {
                                       var12 = var11;
                                       var13 = var11;
                                       var54 = var10;

                                       for(var15 = var10; var54 > 0 && (class62.field721[var51][var11][var54 - 1] & var7) != 0; --var54) {
                                          ;
                                       }

                                       while(var15 < 104 && (class62.field721[var51][var11][var15 + 1] & var7) != 0) {
                                          ++var15;
                                       }

                                       label1027:
                                       while(var12 > 0) {
                                          for(var16 = var54; var16 <= var15; ++var16) {
                                             if((class62.field721[var51][var12 - 1][var16] & var7) == 0) {
                                                break label1027;
                                             }
                                          }

                                          --var12;
                                       }

                                       label1016:
                                       while(var13 < 104) {
                                          for(var16 = var54; var16 <= var15; ++var16) {
                                             if((class62.field721[var51][var13 + 1][var16] & var7) == 0) {
                                                break label1016;
                                             }
                                          }

                                          ++var13;
                                       }

                                       if((var15 - var54 + 1) * (var13 - var12 + 1) >= 4) {
                                          var16 = class62.tileHeights[var51][var12][var54];
                                          Region.addOcclude(var8, 4, var12 * 128, var13 * 128 + 128, var54 * 128, var15 * 128 + 128, var16, var16);

                                          for(var17 = var12; var17 <= var13; ++var17) {
                                             for(var18 = var54; var18 <= var15; ++var18) {
                                                class62.field721[var51][var17][var18] &= ~var7;
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        class173.flush(true);
                        var5 = class62.field722;
                        if(var5 > class237.plane) {
                           var5 = class237.plane;
                        }

                        if(var5 < class237.plane - 1) {
                           var5 = class237.plane - 1;
                        }

                        if(lowMemory) {
                           class308.region.setup(class62.field722);
                        } else {
                           class308.region.setup(0);
                        }

                        for(var50 = 0; var50 < 104; ++var50) {
                           for(var7 = 0; var7 < 104; ++var7) {
                              WorldComparator.groundItemSpawned(var50, var7);
                           }
                        }

                        class33.method384();
                        class3.method5();
                        ObjectComposition.field3609.reset();
                        PacketNode var68;
                        if(BoundingBox.clientInstance.method988()) {
                           var68 = FaceNormal.method3078(ClientPacket.field2398, field902.field1475);
                           var68.packetBuffer.putInt(1057001181);
                           field902.method2036(var68);
                        }

                        if(!isDynamicRegion) {
                           var50 = (class171.field2225 - 6) / 8;
                           var7 = (class171.field2225 + 6) / 8;
                           var8 = (ItemContainer.field756 - 6) / 8;
                           var51 = (ItemContainer.field756 + 6) / 8;

                           for(var10 = var50 - 1; var10 <= var7 + 1; ++var10) {
                              for(var11 = var8 - 1; var11 <= var51 + 1; ++var11) {
                                 if(var10 < var50 || var10 > var7 || var11 < var8 || var11 > var51) {
                                    class1.indexMaps.method4585("m" + var10 + "_" + var11);
                                    class1.indexMaps.method4585("l" + var10 + "_" + var11);
                                 }
                              }
                           }
                        }

                        MapIconReference.setGameState(30);
                        class33.method384();
                        class80.method1735();
                        var68 = FaceNormal.method3078(ClientPacket.field2408, field902.field1475);
                        field902.method2036(var68);
                        MapIcon.method576();
                     }
                  }
               }
            } else {
               TotalQuantityComparator.method108(this);
            }

            if(gameState == 30) {
               this.method1342();
            } else if(gameState == 40 || gameState == 45) {
               this.method1204();
            }

            return;
         }

         var1.data.load(var1.index, (int)var1.hash, var1.field3356, false);
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1270270830"
   )
   @Hook("clientMainLoop")
   @Export("methodDraw")
   protected final void methodDraw(boolean var1) {
      boolean var2;
      label175: {
         try {
            if(class229.field2680 == 2) {
               if(GrandExchangeOffer.field292 == null) {
                  GrandExchangeOffer.field292 = Track1.getMusicFile(class61.field714, class229.field2682, class152.field2129);
                  if(GrandExchangeOffer.field292 == null) {
                     var2 = false;
                     break label175;
                  }
               }

               if(WorldComparator.field260 == null) {
                  WorldComparator.field260 = new class110(class154.field2136, class229.field2678);
               }

               if(class229.field2679.method4146(GrandExchangeOffer.field292, class229.field2684, WorldComparator.field260, 22050)) {
                  class229.field2679.method4172();
                  class229.field2679.method4144(Varcs.field1431);
                  class229.field2679.method4174(GrandExchangeOffer.field292, class313.field3910);
                  class229.field2680 = 0;
                  GrandExchangeOffer.field292 = null;
                  WorldComparator.field260 = null;
                  class61.field714 = null;
                  var2 = true;
                  break label175;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class229.field2679.method4150();
            class229.field2680 = 0;
            GrandExchangeOffer.field292 = null;
            WorldComparator.field260 = null;
            class61.field714 = null;
         }

         var2 = false;
      }

      if(var2 && field1090 && OwnWorldComparator.soundSystem0 != null) {
         OwnWorldComparator.soundSystem0.tryFlush();
      }

      int var4;
      if((gameState == 10 || gameState == 20 || gameState == 30) && field1068 != 0L && ScriptVarType.method28() > field1068) {
         var4 = isResized?2:1;
         AttackOption.method1859(var4);
      }

      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1060[var4] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class90.loadingBarPercentage, class90.loadingText, var1);
      } else if(gameState == 5) {
         class21.drawLoginScreen(class228.fontBold12, class2.fontPlain11, Huffman.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class21.drawLoginScreen(class228.fontBold12, class2.fontPlain11, Huffman.font_p12full, var1);
         } else if(gameState == 25) {
            if(field978 == 1) {
               if(field908 > field859) {
                  field859 = field908;
               }

               var4 = (field859 * 50 - field908 * 50) / field859;
               VertexNormal.method2787("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field978 == 2) {
               if(field910 > field911) {
                  field911 = field910;
               }

               var4 = (field911 * 50 - field910 * 50) / field911 + 50;
               VertexNormal.method2787("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               VertexNormal.method2787("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1208();
         } else if(gameState == 40) {
            VertexNormal.method2787("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            VertexNormal.method2787("Please wait...", false);
         }
      } else {
         class21.drawLoginScreen(class228.fontBold12, class2.fontPlain11, Huffman.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var4 = 0; var4 < widgetCount; ++var4) {
            if(field1061[var4]) {
               class324.rasterProvider.draw(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field1061[var4] = false;
            }
         }
      } else if(gameState > 0) {
         class324.rasterProvider.drawFull(0, 0);

         for(var4 = 0; var4 < widgetCount; ++var4) {
            field1061[var4] = false;
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1577184348"
   )
   protected final void vmethod1200() {
      if(class158.varcs.changed()) {
         class158.varcs.serialize();
      }

      if(class38.mouseRecorder != null) {
         class38.mouseRecorder.isRunning = false;
      }

      class38.mouseRecorder = null;
      field902.close();
      class7.method31();
      if(MouseInput.mouse != null) {
         MouseInput var1 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

      class49.mouseWheel = null;
      if(OwnWorldComparator.soundSystem0 != null) {
         OwnWorldComparator.soundSystem0.shutdown();
      }

      if(Tile.soundSystem1 != null) {
         Tile.soundSystem1.shutdown();
      }

      if(class264.NetCache_socket != null) {
         class264.NetCache_socket.vmethod3325();
      }

      Object var9 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3389 != 0) {
            IndexStoreActionHandler.field3389 = 1;

            try {
               IndexStoreActionHandler.IndexStoreActionHandler_lock.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      if(MapIconReference.urlRequester != null) {
         MapIconReference.urlRequester.close();
         MapIconReference.urlRequester = null;
      }

      try {
         class167.dat2File.close();

         for(int var4 = 0; var4 < class316.idxCount; ++var4) {
            class167.idxFiles[var4].close();
         }

         class167.idx255File.close();
         class167.randomDat.close();
      } catch (Exception var7) {
         ;
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   protected final void vmethod1332() {
   }

   @Export("init")
   @ObfuscatedName("init")
   public final void init() {
      try {
         if(this.isValidHost()) {
            Parameters[] var1 = new Parameters[]{Parameters.field3804, Parameters.field3805, Parameters.field3806, Parameters.field3797, Parameters.field3794, Parameters.field3802, Parameters.field3796, Parameters.field3801, Parameters.field3795, Parameters.field3807, Parameters.field3803, Parameters.field3800, Parameters.field3792, Parameters.field3793, Parameters.field3798, Parameters.field3799};
            Parameters[] var2 = var1;

            int var3;
            for(var3 = 0; var3 < var2.length; ++var3) {
               Parameters var4 = var2[var3];
               String var5 = this.getParameter(var4.key);
               if(var5 != null) {
                  switch(Integer.parseInt(var4.key)) {
                  case 1:
                     GameCanvas.field627 = var5;
                     break;
                  case 2:
                     PlayerComposition.field2791 = Integer.parseInt(var5);
                     break;
                  case 3:
                     GraphicsObject.sessionToken = var5;
                     break;
                  case 4:
                     JagexGame[] var6 = new JagexGame[]{JagexGame.field3350, JagexGame.field3354, JagexGame.field3349, JagexGame.field3348, JagexGame.field3351, JagexGame.field3352};
                     class71.field816 = (JagexGame)class44.forOrdinal(var6, Integer.parseInt(var5));
                     if(class71.field816 == JagexGame.field3352) {
                        loginType = JagexLoginType.field4071;
                     } else {
                        loginType = JagexLoginType.field4068;
                     }
                  case 5:
                  case 13:
                  default:
                     break;
                  case 6:
                     flags = Integer.parseInt(var5);
                     break;
                  case 7:
                     class315.field3918 = Integer.parseInt(var5);
                     break;
                  case 8:
                     field905 = Integer.parseInt(var5) != 0;
                     break;
                  case 9:
                     if(var5.equalsIgnoreCase("true")) {
                        ;
                     }
                     break;
                  case 10:
                     JagexGame.field3355 = HorizontalAlignment.method5117(Integer.parseInt(var5));
                     break;
                  case 11:
                     socketType = Integer.parseInt(var5);
                     break;
                  case 12:
                     if(var5.equalsIgnoreCase("true")) {
                        isMembers = true;
                     } else {
                        isMembers = false;
                     }
                     break;
                  case 14:
                     world = Integer.parseInt(var5);
                     break;
                  case 15:
                     languageId = Integer.parseInt(var5);
                  }
               }
            }

            class297.method5286();
            host = this.getCodeBase().getHost();
            String var23 = JagexGame.field3355.identifier;
            byte var11 = 0;

            try {
               class316.idxCount = 17;
               PendingSpawn.field1146 = var11;

               try {
                  class190.osName = System.getProperty("os.name");
               } catch (Exception var19) {
                  class190.osName = "Unknown";
               }

               class185.osNameLC = class190.osName.toLowerCase();

               try {
                  class22.userHome = System.getProperty("user.home");
                  if(class22.userHome != null) {
                     class22.userHome = class22.userHome + "/";
                  }
               } catch (Exception var18) {
                  ;
               }

               try {
                  if(class185.osNameLC.startsWith("win")) {
                     if(class22.userHome == null) {
                        class22.userHome = System.getenv("USERPROFILE");
                     }
                  } else if(class22.userHome == null) {
                     class22.userHome = System.getenv("HOME");
                  }

                  if(class22.userHome != null) {
                     class22.userHome = class22.userHome + "/";
                  }
               } catch (Exception var17) {
                  ;
               }

               if(class22.userHome == null) {
                  class22.userHome = "~/";
               }

               class27.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class22.userHome, "/tmp/", ""};
               class167.field2214 = new String[]{".jagex_cache_" + PendingSpawn.field1146, ".file_store_" + PendingSpawn.field1146};

               label170:
               for(var3 = 0; var3 < 4; ++var3) {
                  class167.field2206 = InvType.method4737("oldschool", var23, var3);
                  if(!class167.field2206.exists()) {
                     class167.field2206.mkdirs();
                  }

                  File[] var24 = class167.field2206.listFiles();
                  if(var24 == null) {
                     break;
                  }

                  File[] var26 = var24;
                  int var13 = 0;

                  while(true) {
                     if(var13 >= var26.length) {
                        break label170;
                     }

                     File var7 = var26[var13];

                     boolean var8;
                     try {
                        RandomAccessFile var9 = new RandomAccessFile(var7, "rw");
                        int var10 = var9.read();
                        var9.seek(0L);
                        var9.write(var10);
                        var9.seek(0L);
                        var9.close();
                        var8 = true;
                     } catch (Exception var16) {
                        var8 = false;
                     }

                     if(!var8) {
                        break;
                     }

                     ++var13;
                  }
               }

               class7.method41(class167.field2206);

               try {
                  File var12 = new File(class22.userHome, "random.dat");
                  int var15;
                  if(var12.exists()) {
                     class167.randomDat = new CacheFile(new FileOnDisk(var12, "rw", 25L), 24, 0);
                  } else {
                     label149:
                     for(int var14 = 0; var14 < class167.field2214.length; ++var14) {
                        for(var15 = 0; var15 < class27.cacheLocations.length; ++var15) {
                           File var27 = new File(class27.cacheLocations[var15] + class167.field2214[var14] + File.separatorChar + "random.dat");
                           if(var27.exists()) {
                              class167.randomDat = new CacheFile(new FileOnDisk(var27, "rw", 25L), 24, 0);
                              break label149;
                           }
                        }
                     }
                  }

                  if(class167.randomDat == null) {
                     RandomAccessFile var25 = new RandomAccessFile(var12, "rw");
                     var15 = var25.read();
                     var25.seek(0L);
                     var25.write(var15);
                     var25.seek(0L);
                     var25.close();
                     class167.randomDat = new CacheFile(new FileOnDisk(var12, "rw", 25L), 24, 0);
                  }
               } catch (IOException var20) {
                  ;
               }

               class167.dat2File = new CacheFile(new FileOnDisk(class27.method229("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
               class167.idx255File = new CacheFile(new FileOnDisk(class27.method229("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
               class167.idxFiles = new CacheFile[class316.idxCount];

               for(var3 = 0; var3 < class316.idxCount; ++var3) {
                  class167.idxFiles[var3] = new CacheFile(new FileOnDisk(class27.method229("main_file_cache.idx" + var3), "rw", 1048576L), 6000, 0);
               }
            } catch (Exception var21) {
               UrlRequest.processClientError((String)null, var21);
            }

            BoundingBox.clientInstance = this;
            this.initialize(765, 503, 167);
         }
      } catch (RuntimeException var22) {
         throw KeyFocusListener.method808(var22, "client.init(" + ')');
      }
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1742585961"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         boolean var1 = MapIconReference.method749();
         if(!var1) {
            this.method1202();
         }

      }
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-17236112"
   )
   void method1202() {
      if(class264.field3423 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class264.field3422 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field886 = 3000;
            class264.field3422 = 3;
         }

         if(--field886 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  WorldMapDecoration.socket = GameEngine.taskManager.createSocket(host, Player.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(WorldMapDecoration.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(WorldMapDecoration.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  if(field905) {
                     class57.rssocket = UrlRequester.method3107((Socket)WorldMapDecoration.socket.value, 40000, 5000);
                  } else {
                     class57.rssocket = new class173((Socket)WorldMapDecoration.socket.value, GameEngine.taskManager, 5000);
                  }

                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(167);
                  class57.rssocket.vmethod3320(var1.payload, 0, 5);
                  ++js5State;
                  field887 = ScriptVarType.method28();
               }

               if(js5State == 3) {
                  if(class57.rssocket.vmethod3316() > 0 || !field905 && gameState <= 5) {
                     int var2 = class57.rssocket.vmethod3315();
                     if(var2 != 0) {
                        this.error(var2);
                        return;
                     }

                     ++js5State;
                  } else if(ScriptVarType.method28() - field887 > 30000L) {
                     this.error(-2);
                     return;
                  }
               }

               if(js5State == 4) {
                  class163.method3224(class57.rssocket, gameState > 20);
                  WorldMapDecoration.socket = null;
                  class57.rssocket = null;
                  js5State = 0;
                  field889 = 0;
               }
            } catch (IOException var3) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1824870945"
   )
   @Export("error")
   void error(int var1) {
      WorldMapDecoration.socket = null;
      class57.rssocket = null;
      js5State = 0;
      if(WorldMapRegion.port1 == Player.myWorldPort) {
         Player.myWorldPort = FontName.port2;
      } else {
         Player.myWorldPort = WorldMapRegion.port1;
      }

      ++field889;
      if(field889 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field886 = 3000;
         }
      } else if(field889 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field889 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field886 = 3000;
         }
      }

   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-10"
   )
   final void method1204() {
      Object var1 = field902.getSocket();
      PacketBuffer var2 = field902.packetBuffer;

      try {
         if(loginState == 0) {
            if(var1 != null) {
               ((class169)var1).vmethod3325();
               var1 = null;
            }

            Projectile.field1402 = null;
            socketError = false;
            field891 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(Projectile.field1402 == null) {
               Projectile.field1402 = GameEngine.taskManager.createSocket(host, Player.myWorldPort);
            }

            if(Projectile.field1402.status == 2) {
               throw new IOException();
            }

            if(Projectile.field1402.status == 1) {
               if(field905) {
                  var1 = UrlRequester.method3107((Socket)Projectile.field1402.value, 40000, 5000);
               } else {
                  var1 = new class173((Socket)Projectile.field1402.value, GameEngine.taskManager, 5000);
               }

               field902.setSocket((class169)var1);
               Projectile.field1402 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            field902.method2033();
            PacketNode var3 = BoundingBox2D.method44();
            var3.packetBuffer.putByte(LoginPacket.field2477.id);
            field902.method2036(var3);
            field902.method2035();
            var2.offset = 0;
            loginState = 3;
         }

         int var4;
         boolean var10;
         if(loginState == 3) {
            if(OwnWorldComparator.soundSystem0 != null) {
               OwnWorldComparator.soundSystem0.method2191();
            }

            if(Tile.soundSystem1 != null) {
               Tile.soundSystem1.method2191();
            }

            var10 = true;
            if(field905 && !((class169)var1).vmethod3338(1)) {
               var10 = false;
            }

            if(var10) {
               var4 = ((class169)var1).vmethod3315();
               if(OwnWorldComparator.soundSystem0 != null) {
                  OwnWorldComparator.soundSystem0.method2191();
               }

               if(Tile.soundSystem1 != null) {
                  Tile.soundSystem1.method2191();
               }

               if(var4 != 0) {
                  class19.method168(var4);
                  return;
               }

               var2.offset = 0;
               loginState = 4;
            }
         }

         int var23;
         if(loginState == 4) {
            if(var2.offset < 8) {
               var23 = ((class169)var1).vmethod3316();
               if(var23 > 8 - var2.offset) {
                  var23 = 8 - var2.offset;
               }

               if(var23 > 0) {
                  ((class169)var1).vmethod3318(var2.payload, var2.offset, var23);
                  var2.offset += var23;
               }
            }

            if(var2.offset == 8) {
               var2.offset = 0;
               class5.field35 = var2.readLong();
               loginState = 5;
            }
         }

         int var6;
         if(loginState == 5) {
            field902.packetBuffer.offset = 0;
            field902.method2033();
            PacketBuffer var17 = new PacketBuffer(500);
            int[] var11 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class5.field35 >> 32), (int)(class5.field35 & -1L)};
            var17.offset = 0;
            var17.putByte(1);
            var17.putByte(field1041.rsOrdinal());
            var17.putInt(var11[0]);
            var17.putInt(var11[1]);
            var17.putInt(var11[2]);
            var17.putInt(var11[3]);
            switch(field1041.field2154) {
            case 0:
            case 2:
               var17.put24bitInt(PendingSpawn.field1145);
               var17.offset += 5;
               break;
            case 1:
               var17.putInt(((Integer)class46.preferences.preferences.get(Integer.valueOf(SceneTilePaint.method2873(class90.username)))).intValue());
               var17.offset += 4;
               break;
            case 3:
               var17.offset += 8;
            }

            var17.putString(class90.password);
            var17.encryptRsa(class88.field1330, class88.field1326);
            PacketNode var5 = BoundingBox2D.method44();
            var5.packetBuffer.offset = 0;
            if(gameState == 40) {
               var5.packetBuffer.putByte(LoginPacket.field2473.id);
            } else {
               var5.packetBuffer.putByte(LoginPacket.field2475.id);
            }

            var5.packetBuffer.putShort(0);
            var6 = var5.packetBuffer.offset;
            var5.packetBuffer.putInt(167);
            var5.packetBuffer.putBytes(var17.payload, 0, var17.offset);
            int var7 = var5.packetBuffer.offset;
            var5.packetBuffer.putString(class90.username);
            var5.packetBuffer.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            var5.packetBuffer.putShort(Sequence.canvasWidth);
            var5.packetBuffer.putShort(class45.canvasHeight);
            Buffer.method3727(var5.packetBuffer);
            var5.packetBuffer.putString(GraphicsObject.sessionToken);
            var5.packetBuffer.putInt(class315.field3918);
            Buffer var8 = new Buffer(JagexLoginType.platformInfo.method6238());
            JagexLoginType.platformInfo.method6228(var8);
            var5.packetBuffer.putBytes(var8.payload, 0, var8.payload.length);
            var5.packetBuffer.putByte(PlayerComposition.field2791);
            var5.packetBuffer.putInt(0);
            var5.packetBuffer.putInt(class169.indexInterfaces.crc);
            var5.packetBuffer.putInt(class19.indexSoundEffects.crc);
            var5.packetBuffer.putInt(WorldMapType2.configsIndex.crc);
            var5.packetBuffer.putInt(class55.indexCache3.crc);
            var5.packetBuffer.putInt(class44.indexCache4.crc);
            var5.packetBuffer.putInt(class1.indexMaps.crc);
            var5.packetBuffer.putInt(class1.indexTrack1.crc);
            var5.packetBuffer.putInt(class44.indexModels.crc);
            var5.packetBuffer.putInt(class44.indexSprites.crc);
            var5.packetBuffer.putInt(PendingSpawn.indexTextures.crc);
            var5.packetBuffer.putInt(indexCache10.crc);
            var5.packetBuffer.putInt(class157.indexTrack2.crc);
            var5.packetBuffer.putInt(MapLabel.indexScripts.crc);
            var5.packetBuffer.putInt(class18.indexCache13.crc);
            var5.packetBuffer.putInt(ScriptEvent.vorbisIndex.crc);
            var5.packetBuffer.putInt(Renderable.indexCache15.crc);
            var5.packetBuffer.putInt(class151.indexWorldMap.crc);
            var5.packetBuffer.encryptXtea(var11, var7, var5.packetBuffer.offset);
            var5.packetBuffer.method3515(var5.packetBuffer.offset - var6);
            field902.method2036(var5);
            field902.method2035();
            field902.field1475 = new ISAACCipher(var11);

            for(int var9 = 0; var9 < 4; ++var9) {
               var11[var9] += 50;
            }

            var2.seed(var11);
            loginState = 6;
         }

         if(loginState == 6 && ((class169)var1).vmethod3316() > 0) {
            var23 = ((class169)var1).vmethod3315();
            if(var23 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var23 == 2) {
               loginState = 9;
            } else if(var23 == 15 && gameState == 40) {
               field902.packetLength = -1;
               loginState = 13;
            } else if(var23 == 23 && field1110 < 1) {
               ++field1110;
               loginState = 0;
            } else {
               if(var23 != 29) {
                  class19.method168(var23);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && ((class169)var1).vmethod3316() > 0) {
            field894 = (((class169)var1).vmethod3315() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field891 = 0;
            class33.method385("You have only just left another world.", "Your profile will be transferred in:", field894 / 60 + " seconds.");
            if(--field894 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && ((class169)var1).vmethod3316() >= 13) {
               var10 = ((class169)var1).vmethod3315() == 1;
               ((class169)var1).vmethod3318(var2.payload, 0, 4);
               var2.offset = 0;
               boolean var19 = false;
               if(var10) {
                  var4 = var2.readOpcode() << 24;
                  var4 |= var2.readOpcode() << 16;
                  var4 |= var2.readOpcode() << 8;
                  var4 |= var2.readOpcode();
                  int var12 = SceneTilePaint.method2873(class90.username);
                  if(class46.preferences.preferences.size() >= 10 && !class46.preferences.preferences.containsKey(Integer.valueOf(var12))) {
                     Iterator var13 = class46.preferences.preferences.entrySet().iterator();
                     var13.next();
                     var13.remove();
                  }

                  class46.preferences.preferences.put(Integer.valueOf(var12), Integer.valueOf(var4));
               }

               if(class90.Login_isUsernameRemembered) {
                  class46.preferences.rememberedUsername = class90.username;
               } else {
                  class46.preferences.rememberedUsername = null;
               }

               class46.method694();
               rights = ((class169)var1).vmethod3315();
               field1025 = ((class169)var1).vmethod3315() == 1;
               localInteractingIndex = ((class169)var1).vmethod3315();
               localInteractingIndex <<= 8;
               localInteractingIndex += ((class169)var1).vmethod3315();
               field973 = ((class169)var1).vmethod3315();
               ((class169)var1).vmethod3318(var2.payload, 0, 1);
               var2.offset = 0;
               ServerPacket[] var20 = GameSocket.method3366();
               var6 = var2.method3792();
               if(var6 < 0 || var6 >= var20.length) {
                  throw new IOException(var6 + " " + var2.offset);
               }

               field902.serverPacket = var20[var6];
               field902.packetLength = field902.serverPacket.packetLength;
               ((class169)var1).vmethod3318(var2.payload, 0, 2);
               var2.offset = 0;
               field902.packetLength = var2.readUnsignedShort();

               try {
                  Client var14 = BoundingBox.clientInstance;
                  JSObject.getWindow(var14).call("zap", (Object[])null);
               } catch (Throwable var15) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(((class169)var1).vmethod3316() >= field902.packetLength) {
                  var2.offset = 0;
                  ((class169)var1).vmethod3318(var2.payload, 0, field902.packetLength);
                  field1050.method5213();
                  class245.method4505();
                  class5.initializeGPI(var2);
                  class171.field2225 = -1;
                  MouseRecorder.xteaChanged(false, var2);
                  field902.serverPacket = null;
               }

            } else {
               if(loginState == 11 && ((class169)var1).vmethod3316() >= 2) {
                  var2.offset = 0;
                  ((class169)var1).vmethod3318(var2.payload, 0, 2);
                  var2.offset = 0;
                  GroundObject.field1786 = var2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && ((class169)var1).vmethod3316() >= GroundObject.field1786) {
                  var2.offset = 0;
                  ((class169)var1).vmethod3318(var2.payload, 0, GroundObject.field1786);
                  var2.offset = 0;
                  String var18 = var2.readString();
                  String var24 = var2.readString();
                  String var21 = var2.readString();
                  class33.method385(var18, var24, var21);
                  MapIconReference.setGameState(10);
               }

               if(loginState != 13) {
                  ++field891;
                  if(field891 > 2000) {
                     if(field1110 < 1) {
                        if(Player.myWorldPort == WorldMapRegion.port1) {
                           Player.myWorldPort = FontName.port2;
                        } else {
                           Player.myWorldPort = WorldMapRegion.port1;
                        }

                        ++field1110;
                        loginState = 0;
                     } else {
                        class19.method168(-3);
                     }
                  }
               } else {
                  if(field902.packetLength == -1) {
                     if(((class169)var1).vmethod3316() < 2) {
                        return;
                     }

                     ((class169)var1).vmethod3318(var2.payload, 0, 2);
                     var2.offset = 0;
                     field902.packetLength = var2.readUnsignedShort();
                  }

                  if(((class169)var1).vmethod3316() >= field902.packetLength) {
                     ((class169)var1).vmethod3318(var2.payload, 0, field902.packetLength);
                     var2.offset = 0;
                     var23 = field902.packetLength;
                     field1050.method5229();
                     field902.method2033();
                     field902.packetBuffer.offset = 0;
                     field902.serverPacket = null;
                     field902.field1485 = null;
                     field902.field1473 = null;
                     field902.field1471 = null;
                     field902.packetLength = 0;
                     field902.field1480 = 0;
                     field873 = 0;
                     class45.method670();
                     field1087 = 0;
                     destinationX = 0;

                     for(var4 = 0; var4 < 2048; ++var4) {
                        cachedPlayers[var4] = null;
                     }

                     WorldComparator.localPlayer = null;

                     for(var4 = 0; var4 < cachedNPCs.length; ++var4) {
                        NPC var22 = cachedNPCs[var4];
                        if(var22 != null) {
                           var22.interacting = -1;
                           var22.field1177 = false;
                        }
                     }

                     class229.method4142();
                     MapIconReference.setGameState(30);

                     for(var4 = 0; var4 < 100; ++var4) {
                        field1060[var4] = true;
                     }

                     Permission.method4535();
                     class5.initializeGPI(var2);
                     if(var23 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var16) {
         if(field1110 < 1) {
            if(WorldMapRegion.port1 == Player.myWorldPort) {
               Player.myWorldPort = FontName.port2;
            } else {
               Player.myWorldPort = WorldMapRegion.port1;
            }

            ++field1110;
            loginState = 0;
         } else {
            class19.method168(-2);
         }
      }
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1590266613"
   )
   final void method1342() {
      if(field873 > 1) {
         --field873;
      }

      if(field903 > 0) {
         --field903;
      }

      if(socketError) {
         socketError = false;
         class150.method3132();
      } else {
         if(!isMenuOpen) {
            GrandExchangeOffer.method124();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method1209(field902); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(true) {
               ClassInfo var2 = (ClassInfo)class326.classInfos.last();
               boolean var30;
               if(var2 == null) {
                  var30 = false;
               } else {
                  var30 = true;
               }

               int var3;
               PacketNode var31;
               if(!var30) {
                  PacketNode var14;
                  int var15;
                  if(field1050.field3816) {
                     var14 = FaceNormal.method3078(ClientPacket.field2427, field902.field1475);
                     var14.packetBuffer.putByte(0);
                     var15 = var14.packetBuffer.offset;
                     field1050.method5216(var14.packetBuffer);
                     var14.packetBuffer.method3516(var14.packetBuffer.offset - var15);
                     field902.method2036(var14);
                     field1050.method5214();
                  }

                  Object var36 = class38.mouseRecorder.lock;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  int var10;
                  synchronized(class38.mouseRecorder.lock) {
                     if(!field856) {
                        class38.mouseRecorder.index = 0;
                     } else if(MouseInput.mouseLastButton != 0 || class38.mouseRecorder.index >= 40) {
                        var31 = FaceNormal.method3078(ClientPacket.field2454, field902.field1475);
                        var31.packetBuffer.putByte(0);
                        var3 = var31.packetBuffer.offset;
                        var4 = 0;

                        for(var5 = 0; var5 < class38.mouseRecorder.index && var31.packetBuffer.offset - var3 < 240; ++var5) {
                           ++var4;
                           var6 = class38.mouseRecorder.ys[var5];
                           if(var6 < 0) {
                              var6 = 0;
                           } else if(var6 > 502) {
                              var6 = 502;
                           }

                           var7 = class38.mouseRecorder.xs[var5];
                           if(var7 < 0) {
                              var7 = 0;
                           } else if(var7 > 764) {
                              var7 = 764;
                           }

                           var8 = var7 + var6 * 765;
                           if(class38.mouseRecorder.ys[var5] == -1 && class38.mouseRecorder.xs[var5] == -1) {
                              var7 = -1;
                              var6 = -1;
                              var8 = 524287;
                           }

                           if(var7 == field990 && var6 == field948) {
                              if(field870 < 2047) {
                                 ++field870;
                              }
                           } else {
                              var9 = var7 - field990;
                              field990 = var7;
                              var10 = var6 - field948;
                              field948 = var6;
                              if(field870 < 8 && var9 >= -32 && var9 <= 31 && var10 >= -32 && var10 <= 31) {
                                 var9 += 32;
                                 var10 += 32;
                                 var31.packetBuffer.putShort(var10 + (field870 << 12) + (var9 << 6));
                                 field870 = 0;
                              } else if(field870 < 8) {
                                 var31.packetBuffer.put24bitInt((field870 << 19) + var8 + 8388608);
                                 field870 = 0;
                              } else {
                                 var31.packetBuffer.putInt((field870 << 19) + var8 + -1073741824);
                                 field870 = 0;
                              }
                           }
                        }

                        var31.packetBuffer.method3516(var31.packetBuffer.offset - var3);
                        field902.method2036(var31);
                        if(var4 >= class38.mouseRecorder.index) {
                           class38.mouseRecorder.index = 0;
                        } else {
                           class38.mouseRecorder.index -= var4;

                           for(var5 = 0; var5 < class38.mouseRecorder.index; ++var5) {
                              class38.mouseRecorder.xs[var5] = class38.mouseRecorder.xs[var5 + var4];
                              class38.mouseRecorder.ys[var5] = class38.mouseRecorder.ys[var5 + var4];
                           }
                        }
                     }
                  }

                  if(MouseInput.mouseLastButton == 1 || !WorldMapData.middleMouseMovesCamera && MouseInput.mouseLastButton == 4 || MouseInput.mouseLastButton == 2) {
                     long var16 = (MouseInput.mouseLastPressedTimeMillis - mouseLastLastPressedTimeMillis) / 50L;
                     if(var16 > 4095L) {
                        var16 = 4095L;
                     }

                     mouseLastLastPressedTimeMillis = MouseInput.mouseLastPressedTimeMillis;
                     var3 = MouseInput.mouseLastPressedY;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > class45.canvasHeight) {
                        var3 = class45.canvasHeight;
                     }

                     var4 = MouseInput.mouseLastPressedX;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > Sequence.canvasWidth) {
                        var4 = Sequence.canvasWidth;
                     }

                     var5 = (int)var16;
                     PacketNode var18 = FaceNormal.method3078(ClientPacket.field2396, field902.field1475);
                     var18.packetBuffer.putShort((var5 << 1) + (MouseInput.mouseLastButton == 2?1:0));
                     var18.packetBuffer.putShort(var4);
                     var18.packetBuffer.putShort(var3);
                     field902.method2036(var18);
                  }

                  if(KeyFocusListener.field593 > 0) {
                     var14 = FaceNormal.method3078(ClientPacket.field2390, field902.field1475);
                     var14.packetBuffer.putShort(0);
                     var15 = var14.packetBuffer.offset;
                     long var19 = ScriptVarType.method28();

                     for(var5 = 0; var5 < KeyFocusListener.field593; ++var5) {
                        long var21 = var19 - field1079;
                        if(var21 > 16777215L) {
                           var21 = 16777215L;
                        }

                        field1079 = var19;
                        var14.packetBuffer.putByte(KeyFocusListener.field613[var5]);
                        var14.packetBuffer.put24bitInt((int)var21);
                     }

                     var14.packetBuffer.method3515(var14.packetBuffer.offset - var15);
                     field902.method2036(var14);
                  }

                  if(field939 > 0) {
                     --field939;
                  }

                  if(KeyFocusListener.keyPressed[96] || KeyFocusListener.keyPressed[97] || KeyFocusListener.keyPressed[98] || KeyFocusListener.keyPressed[99]) {
                     field940 = true;
                  }

                  if(field940 && field939 <= 0) {
                     field939 = 20;
                     field940 = false;
                     var14 = FaceNormal.method3078(ClientPacket.field2459, field902.field1475);
                     var14.packetBuffer.putShort(cameraPitchTarget);
                     var14.packetBuffer.method3554(mapAngle);
                     field902.method2036(var14);
                  }

                  if(MapIcon.field508 && !field1117) {
                     field1117 = true;
                     var14 = FaceNormal.method3078(ClientPacket.field2445, field902.field1475);
                     var14.packetBuffer.putByte(1);
                     field902.method2036(var14);
                  }

                  if(!MapIcon.field508 && field1117) {
                     field1117 = false;
                     var14 = FaceNormal.method3078(ClientPacket.field2445, field902.field1475);
                     var14.packetBuffer.putByte(0);
                     field902.method2036(var14);
                  }

                  if(ScriptState.renderOverview != null) {
                     ScriptState.renderOverview.method6011();
                  }

                  if(IndexStoreActionHandler.field3392) {
                     if(class33.clanMemberManager != null) {
                        class33.clanMemberManager.method5333();
                     }

                     WorldMapDecoration.method303();
                     IndexStoreActionHandler.field3392 = false;
                  }

                  if(class237.plane != field1100) {
                     field1100 = class237.plane;
                     var1 = class237.plane;
                     int[] var32 = ServerPacket.minimapSprite.pixels;
                     var3 = var32.length;

                     for(var4 = 0; var4 < var3; ++var4) {
                        var32[var4] = 0;
                     }

                     for(var4 = 1; var4 < 103; ++var4) {
                        var5 = (103 - var4) * 2048 + 24628;

                        for(var6 = 1; var6 < 103; ++var6) {
                           if((class62.tileSettings[var1][var6][var4] & 24) == 0) {
                              class308.region.drawTile(var32, var5, 512, var1, var6, var4);
                           }

                           if(var1 < 3 && (class62.tileSettings[var1 + 1][var6][var4] & 8) != 0) {
                              class308.region.drawTile(var32, var5, 512, var1 + 1, var6, var4);
                           }

                           var5 += 4;
                        }
                     }

                     var4 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
                     var5 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
                     ServerPacket.minimapSprite.setRaster();

                     for(var6 = 1; var6 < 103; ++var6) {
                        for(var7 = 1; var7 < 103; ++var7) {
                           if((class62.tileSettings[var1][var7][var6] & 24) == 0) {
                              Preferences.drawObject(var1, var7, var6, var4, var5);
                           }

                           if(var1 < 3 && (class62.tileSettings[var1 + 1][var7][var6] & 8) != 0) {
                              Preferences.drawObject(var1 + 1, var7, var6, var4, var5);
                           }
                        }
                     }

                     field1081 = 0;

                     for(var6 = 0; var6 < 104; ++var6) {
                        for(var7 = 0; var7 < 104; ++var7) {
                           var8 = class308.region.getGroundObjectHash(class237.plane, var6, var7);
                           if(var8 != 0) {
                              var8 = var8 >> 14 & 32767;
                              var9 = FileRequest.getObjectDefinition(var8).mapIconId;
                              if(var9 >= 0) {
                                 mapIcons[field1081] = Area.mapAreaType[var9].getMapIcon(false);
                                 field1082[field1081] = var6;
                                 field1083[field1081] = var7;
                                 ++field1081;
                              }
                           }
                        }
                     }

                     class324.rasterProvider.setRaster();
                  }

                  if(gameState != 30) {
                     return;
                  }

                  for(PendingSpawn var38 = (PendingSpawn)pendingSpawns.getFront(); var38 != null; var38 = (PendingSpawn)pendingSpawns.getNext()) {
                     if(var38.hitpoints > 0) {
                        --var38.hitpoints;
                     }

                     ObjectComposition var23;
                     boolean var37;
                     if(var38.hitpoints == 0) {
                        if(var38.field1137 >= 0) {
                           var3 = var38.field1137;
                           var4 = var38.field1134;
                           var23 = FileRequest.getObjectDefinition(var3);
                           if(var4 == 11) {
                              var4 = 10;
                           }

                           if(var4 >= 5 && var4 <= 8) {
                              var4 = 4;
                           }

                           var37 = var23.method5002(var4);
                           if(!var37) {
                              continue;
                           }
                        }

                        GameCanvas.method826(var38.level, var38.type, var38.x, var38.y, var38.field1137, var38.field1138, var38.field1134);
                        var38.unlink();
                     } else {
                        if(var38.delay > 0) {
                           --var38.delay;
                        }

                        if(var38.delay == 0 && var38.x >= 1 && var38.y >= 1 && var38.x <= 102 && var38.y <= 102) {
                           if(var38.id >= 0) {
                              var3 = var38.id;
                              var4 = var38.field1142;
                              var23 = FileRequest.getObjectDefinition(var3);
                              if(var4 == 11) {
                                 var4 = 10;
                              }

                              if(var4 >= 5 && var4 <= 8) {
                                 var4 = 4;
                              }

                              var37 = var23.method5002(var4);
                              if(!var37) {
                                 continue;
                              }
                           }

                           GameCanvas.method826(var38.level, var38.type, var38.x, var38.y, var38.id, var38.orientation, var38.field1142);
                           var38.delay = -1;
                           if(var38.id == var38.field1137 && var38.field1137 == -1) {
                              var38.unlink();
                           } else if(var38.id == var38.field1137 && var38.orientation == var38.field1138 && var38.field1142 == var38.field1134) {
                              var38.unlink();
                           }
                        }
                     }
                  }

                  GZipDecompressor.method3458();
                  ++field902.field1480;
                  if(field902.field1480 > 750) {
                     class150.method3132();
                     return;
                  }

                  class62.method1086();
                  World.method1643();
                  int[] var39 = class93.playerIndices;

                  for(var15 = 0; var15 < class93.playerIndexesCount; ++var15) {
                     Player var24 = cachedPlayers[var39[var15]];
                     if(var24 != null && var24.overheadTextCyclesRemaining > 0) {
                        --var24.overheadTextCyclesRemaining;
                        if(var24.overheadTextCyclesRemaining == 0) {
                           var24.overhead = null;
                        }
                     }
                  }

                  for(var15 = 0; var15 < npcIndexesCount; ++var15) {
                     var3 = npcIndices[var15];
                     NPC var25 = cachedNPCs[var3];
                     if(var25 != null && var25.overheadTextCyclesRemaining > 0) {
                        --var25.overheadTextCyclesRemaining;
                        if(var25.overheadTextCyclesRemaining == 0) {
                           var25.overhead = null;
                        }
                     }
                  }

                  ++field893;
                  if(cursorState != 0) {
                     field958 += 20;
                     if(field958 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class64.field750 != null) {
                     ++mouseCrosshair;
                     if(mouseCrosshair >= 15) {
                        WorldMapType1.method274(class64.field750);
                        class64.field750 = null;
                     }
                  }

                  Widget var40 = Coordinates.field2775;
                  Widget var33 = class23.field331;
                  Coordinates.field2775 = null;
                  class23.field331 = null;
                  draggedOnWidget = null;
                  field877 = false;
                  field1032 = false;
                  field1076 = 0;

                  while(WorldMapRegion.method519() && field1076 < 128) {
                     if(rights >= 2 && KeyFocusListener.keyPressed[82] && Tile.currentPressedKey == 66) {
                        String var46 = "";

                        MessageNode var41;
                        for(Iterator var42 = class95.messages.iterator(); var42.hasNext(); var46 = var46 + var41.name + ':' + var41.value + '\n') {
                           var41 = (MessageNode)var42.next();
                        }

                        BoundingBox.clientInstance.method902(var46);
                     } else if(field930 != 1 || BuildType.currentTypedKey <= 0) {
                        field949[field1076] = Tile.currentPressedKey;
                        field1077[field1076] = BuildType.currentTypedKey;
                        ++field1076;
                     }
                  }

                  if(class237.method4377() && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81] && mouseWheelRotation != 0) {
                     var3 = WorldComparator.localPlayer.field842 - mouseWheelRotation;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > 3) {
                        var3 = 3;
                     }

                     if(var3 != WorldComparator.localPlayer.field842) {
                        GrandExchangeOffer.method125(WorldComparator.localPlayer.pathX[0] + PacketNode.baseX, WorldComparator.localPlayer.pathY[0] + BaseVarType.baseY, var3, false);
                     }

                     mouseWheelRotation = 0;
                  }

                  if(widgetRoot != -1) {
                     WorldMapType2.method548(widgetRoot, 0, 0, Sequence.canvasWidth, class45.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var43;
                     ScriptEvent var44;
                     Widget var49;
                     do {
                        var44 = (ScriptEvent)field970.popFront();
                        if(var44 == null) {
                           while(true) {
                              do {
                                 var44 = (ScriptEvent)field1129.popFront();
                                 if(var44 == null) {
                                    while(true) {
                                       do {
                                          var44 = (ScriptEvent)field1054.popFront();
                                          if(var44 == null) {
                                             this.method1399();
                                             class7.method39();
                                             if(draggedWidget != null) {
                                                this.method1354();
                                             }

                                             PacketNode var26;
                                             if(class157.field2149 != null) {
                                                WorldMapType1.method274(class157.field2149);
                                                ++itemPressedDuration;
                                                if(MouseInput.mouseCurrentButton == 0) {
                                                   if(field1109) {
                                                      if(TextureProvider.field1701 == class157.field2149 && field1080 != field1086) {
                                                         Widget var48 = class157.field2149;
                                                         byte var35 = 0;
                                                         if(field1019 == 1 && var48.contentType == 206) {
                                                            var35 = 1;
                                                         }

                                                         if(var48.itemIds[field1086] <= 0) {
                                                            var35 = 0;
                                                         }

                                                         var6 = class45.getWidgetClickMask(var48);
                                                         boolean var34 = (var6 >> 29 & 1) != 0;
                                                         if(var34) {
                                                            var7 = field1080;
                                                            var8 = field1086;
                                                            var48.itemIds[var8] = var48.itemIds[var7];
                                                            var48.itemQuantities[var8] = var48.itemQuantities[var7];
                                                            var48.itemIds[var7] = -1;
                                                            var48.itemQuantities[var7] = 0;
                                                         } else if(var35 == 1) {
                                                            var7 = field1080;
                                                            var8 = field1086;

                                                            while(var8 != var7) {
                                                               if(var7 > var8) {
                                                                  var48.method4451(var7 - 1, var7);
                                                                  --var7;
                                                               } else if(var7 < var8) {
                                                                  var48.method4451(var7 + 1, var7);
                                                                  ++var7;
                                                               }
                                                            }
                                                         } else {
                                                            var48.method4451(field1086, field1080);
                                                         }

                                                         var26 = FaceNormal.method3078(ClientPacket.field2425, field902.field1475);
                                                         var26.packetBuffer.method3648(field1086);
                                                         var26.packetBuffer.method3619(field1080);
                                                         var26.packetBuffer.method3677(class157.field2149.id);
                                                         var26.packetBuffer.putByte(var35);
                                                         field902.method2036(var26);
                                                      }
                                                   } else if(this.method1211()) {
                                                      this.openMenu(field964, field1056);
                                                   } else if(menuOptionCount > 0) {
                                                      var3 = field964;
                                                      var4 = field1056;
                                                      ContextMenuRow var45 = ChatLineBuffer.topContextMenuRow;
                                                      class177.menuAction(var45.param0, var45.param1, var45.type, var45.identifier, var45.option, var45.option, var3, var4);
                                                      ChatLineBuffer.topContextMenuRow = null;
                                                   }

                                                   mouseCrosshair = 10;
                                                   MouseInput.mouseLastButton = 0;
                                                   class157.field2149 = null;
                                                } else if(itemPressedDuration >= 5 && (MouseInput.mouseLastX > field964 + 5 || MouseInput.mouseLastX < field964 - 5 || MouseInput.mouseLastY > field1056 + 5 || MouseInput.mouseLastY < field1056 - 5)) {
                                                   field1109 = true;
                                                }
                                             }

                                             if(Region.method2915()) {
                                                var3 = Region.selectedRegionTileX;
                                                var4 = Region.selectedRegionTileY;
                                                PacketNode var47 = FaceNormal.method3078(ClientPacket.field2397, field902.field1475);
                                                var47.packetBuffer.putByte(5);
                                                var47.packetBuffer.method3690(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
                                                var47.packetBuffer.putShort(var4 + BaseVarType.baseY);
                                                var47.packetBuffer.method3648(var3 + PacketNode.baseX);
                                                field902.method2036(var47);
                                                Region.method3048();
                                                lastLeftClickX = MouseInput.mouseLastPressedX;
                                                lastLeftClickY = MouseInput.mouseLastPressedY;
                                                cursorState = 1;
                                                field958 = 0;
                                                destinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(var40 != Coordinates.field2775) {
                                                if(var40 != null) {
                                                   WorldMapType1.method274(var40);
                                                }

                                                if(Coordinates.field2775 != null) {
                                                   WorldMapType1.method274(Coordinates.field2775);
                                                }
                                             }

                                             if(var33 != class23.field331 && field1007 == field1006) {
                                                if(var33 != null) {
                                                   WorldMapType1.method274(var33);
                                                }

                                                if(class23.field331 != null) {
                                                   WorldMapType1.method274(class23.field331);
                                                }
                                             }

                                             if(class23.field331 != null) {
                                                if(field1006 < field1007) {
                                                   ++field1006;
                                                   if(field1006 == field1007) {
                                                      WorldMapType1.method274(class23.field331);
                                                   }
                                                }
                                             } else if(field1006 > 0) {
                                                --field1006;
                                             }

                                             class203.method3842();
                                             if(field1099) {
                                                var3 = MapLabel.field451 * 128 + 64;
                                                var4 = WorldComparator.field261 * 128 + 64;
                                                var5 = class5.getTileHeight(var3, var4, class237.plane) - CombatInfo2.field3523;
                                                if(Sequence.cameraX < var3) {
                                                   Sequence.cameraX = (var3 - Sequence.cameraX) * class49.field578 / 1000 + Sequence.cameraX + class110.field1590;
                                                   if(Sequence.cameraX > var3) {
                                                      Sequence.cameraX = var3;
                                                   }
                                                }

                                                if(Sequence.cameraX > var3) {
                                                   Sequence.cameraX -= class49.field578 * (Sequence.cameraX - var3) / 1000 + class110.field1590;
                                                   if(Sequence.cameraX < var3) {
                                                      Sequence.cameraX = var3;
                                                   }
                                                }

                                                if(Area.cameraZ < var5) {
                                                   Area.cameraZ = (var5 - Area.cameraZ) * class49.field578 / 1000 + Area.cameraZ + class110.field1590;
                                                   if(Area.cameraZ > var5) {
                                                      Area.cameraZ = var5;
                                                   }
                                                }

                                                if(Area.cameraZ > var5) {
                                                   Area.cameraZ -= class49.field578 * (Area.cameraZ - var5) / 1000 + class110.field1590;
                                                   if(Area.cameraZ < var5) {
                                                      Area.cameraZ = var5;
                                                   }
                                                }

                                                if(ChatLineBuffer.cameraY < var4) {
                                                   ChatLineBuffer.cameraY = (var4 - ChatLineBuffer.cameraY) * class49.field578 / 1000 + ChatLineBuffer.cameraY + class110.field1590;
                                                   if(ChatLineBuffer.cameraY > var4) {
                                                      ChatLineBuffer.cameraY = var4;
                                                   }
                                                }

                                                if(ChatLineBuffer.cameraY > var4) {
                                                   ChatLineBuffer.cameraY -= class49.field578 * (ChatLineBuffer.cameraY - var4) / 1000 + class110.field1590;
                                                   if(ChatLineBuffer.cameraY < var4) {
                                                      ChatLineBuffer.cameraY = var4;
                                                   }
                                                }

                                                var3 = VarPlayerType.field3441 * 128 + 64;
                                                var4 = class149.field2123 * 128 + 64;
                                                var5 = class5.getTileHeight(var3, var4, class237.plane) - class86.field1317;
                                                var6 = var3 - Sequence.cameraX;
                                                var7 = var5 - Area.cameraZ;
                                                var8 = var4 - ChatLineBuffer.cameraY;
                                                var9 = (int)Math.sqrt((double)(var6 * var6 + var8 * var8));
                                                var10 = (int)(Math.atan2((double)var7, (double)var9) * 325.949D) & 2047;
                                                int var27 = (int)(Math.atan2((double)var6, (double)var8) * -325.949D) & 2047;
                                                if(var10 < 128) {
                                                   var10 = 128;
                                                }

                                                if(var10 > 383) {
                                                   var10 = 383;
                                                }

                                                if(BoundingBox3D.cameraPitch < var10) {
                                                   BoundingBox3D.cameraPitch = (var10 - BoundingBox3D.cameraPitch) * class37.field485 / 1000 + BoundingBox3D.cameraPitch + UnitPriceComparator.field294;
                                                   if(BoundingBox3D.cameraPitch > var10) {
                                                      BoundingBox3D.cameraPitch = var10;
                                                   }
                                                }

                                                if(BoundingBox3D.cameraPitch > var10) {
                                                   BoundingBox3D.cameraPitch -= class37.field485 * (BoundingBox3D.cameraPitch - var10) / 1000 + UnitPriceComparator.field294;
                                                   if(BoundingBox3D.cameraPitch < var10) {
                                                      BoundingBox3D.cameraPitch = var10;
                                                   }
                                                }

                                                int var12 = var27 - ClientPacket.cameraYaw;
                                                if(var12 > 1024) {
                                                   var12 -= 2048;
                                                }

                                                if(var12 < -1024) {
                                                   var12 += 2048;
                                                }

                                                if(var12 > 0) {
                                                   ClientPacket.cameraYaw = var12 * class37.field485 / 1000 + ClientPacket.cameraYaw + UnitPriceComparator.field294;
                                                   ClientPacket.cameraYaw &= 2047;
                                                }

                                                if(var12 < 0) {
                                                   ClientPacket.cameraYaw -= -var12 * class37.field485 / 1000 + UnitPriceComparator.field294;
                                                   ClientPacket.cameraYaw &= 2047;
                                                }

                                                int var13 = var27 - ClientPacket.cameraYaw;
                                                if(var13 > 1024) {
                                                   var13 -= 2048;
                                                }

                                                if(var13 < -1024) {
                                                   var13 += 2048;
                                                }

                                                if(var13 < 0 && var12 > 0 || var13 > 0 && var12 < 0) {
                                                   ClientPacket.cameraYaw = var27;
                                                }
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field1104[var3];
                                             }

                                             class158.varcs.process();
                                             var3 = ++MouseInput.mouseIdleTicks - 1;
                                             var5 = KeyFocusListener.keyboardIdleTicks;
                                             if(var3 > 15000 && var5 > 15000) {
                                                field903 = 250;
                                                MouseInput.mouseIdleTicks = 14500;
                                                var26 = FaceNormal.method3078(ClientPacket.field2441, field902.field1475);
                                                field902.method2036(var26);
                                             }

                                             RunException.friendManager.method1660();
                                             ++field902.field1481;
                                             if(field902.field1481 > 50) {
                                                var26 = FaceNormal.method3078(ClientPacket.field2412, field902.field1475);
                                                field902.method2036(var26);
                                             }

                                             try {
                                                field902.method2035();
                                             } catch (IOException var28) {
                                                class150.method3132();
                                             }

                                             return;
                                          }

                                          var49 = var44.widget;
                                          if(var49.index < 0) {
                                             break;
                                          }

                                          var43 = class3.getWidget(var49.parentId);
                                       } while(var43 == null || var43.children == null || var49.index >= var43.children.length || var49 != var43.children[var49.index]);

                                       AbstractByteBuffer.method3757(var44);
                                    }
                                 }

                                 var49 = var44.widget;
                                 if(var49.index < 0) {
                                    break;
                                 }

                                 var43 = class3.getWidget(var49.parentId);
                              } while(var43 == null || var43.children == null || var49.index >= var43.children.length || var49 != var43.children[var49.index]);

                              AbstractByteBuffer.method3757(var44);
                           }
                        }

                        var49 = var44.widget;
                        if(var49.index < 0) {
                           break;
                        }

                        var43 = class3.getWidget(var49.parentId);
                     } while(var43 == null || var43.children == null || var49.index >= var43.children.length || var49 != var43.children[var49.index]);

                     AbstractByteBuffer.method3757(var44);
                  }
               }

               var31 = FaceNormal.method3078(ClientPacket.field2465, field902.field1475);
               var31.packetBuffer.putByte(0);
               var3 = var31.packetBuffer.offset;
               Fonts.encodeClassVerifier(var31.packetBuffer);
               var31.packetBuffer.method3516(var31.packetBuffer.offset - var3);
               field902.method2036(var31);
            }
         }
      }
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1050240891"
   )
   void method1312() {
      int var1 = Sequence.canvasWidth;
      int var2 = class45.canvasHeight;
      if(super.field669 < var1) {
         var1 = super.field669;
      }

      if(super.field670 < var2) {
         var2 = super.field670;
      }

      if(class46.preferences != null) {
         try {
            Client var3 = BoundingBox.clientInstance;
            int var4 = isResized?2:1;
            class53.method815(var3, "resize", new Object[]{Integer.valueOf(var4)});
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2144478746"
   )
   final void method1208() {
      if(widgetRoot != -1) {
         ClientPacket.method3422(widgetRoot);
      }

      int var1;
      for(var1 = 0; var1 < widgetCount; ++var1) {
         if(field1060[var1]) {
            field1061[var1] = true;
         }

         field1062[var1] = field1060[var1];
         field1060[var1] = false;
      }

      field1059 = gameCycle;
      field1004 = -1;
      field1088 = -1;
      TextureProvider.field1701 = null;
      if(widgetRoot != -1) {
         widgetCount = 0;
         UnitPriceComparator.method138(widgetRoot, 0, 0, Sequence.canvasWidth, class45.canvasHeight, 0, 0, -1);
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
            var1 = field1004;
            var2 = field1088;
            if((menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) && field912) {
               var3 = class36.method520();
               String var12;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var12 = "Use" + " " + lastSelectedItemName + " " + "->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var12 = field956 + " " + field1015 + " " + "->";
               } else {
                  var12 = PacketNode.method3438(var3);
               }

               if(menuOptionCount > 2) {
                  var12 = var12 + class173.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               class228.fontBold12.drawRandomizedMouseoverText(var12, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         var1 = menuX;
         var2 = Frames.menuY;
         var3 = GrandExchangeEvents.field266;
         var4 = ItemContainer.field754;
         int var13 = 6116423;
         Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, var13);
         Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
         class228.fontBold12.method5521("Choose Option", var1 + 3, var2 + 14, var13, -1);
         var6 = MouseInput.mouseLastX;
         var7 = MouseInput.mouseLastY;

         for(var8 = 0; var8 < menuOptionCount; ++var8) {
            int var9 = var2 + (menuOptionCount - 1 - var8) * 15 + 31;
            int var10 = 16777215;
            if(var6 > var1 && var6 < var1 + var3 && var7 > var9 - 13 && var7 < var9 + 3) {
               var10 = 16776960;
            }

            class228.fontBold12.method5521(PacketNode.method3438(var8), var1 + 3, var9, var10, 0);
         }

         FileSystem.method4541(menuX, Frames.menuY, GrandExchangeEvents.field266, ItemContainer.field754);
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < widgetCount; ++var1) {
            if(field1062[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1061[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = class237.plane;
      var2 = WorldComparator.localPlayer.x;
      var3 = WorldComparator.localPlayer.y;
      var4 = field893;

      for(class80 var5 = (class80)class80.field1261.getFront(); var5 != null; var5 = (class80)class80.field1261.getNext()) {
         if(var5.field1259 != -1 || var5.field1263 != null) {
            var6 = 0;
            if(var2 > var5.field1256) {
               var6 += var2 - var5.field1256;
            } else if(var2 < var5.field1264) {
               var6 += var5.field1264 - var2;
            }

            if(var3 > var5.field1257) {
               var6 += var3 - var5.field1257;
            } else if(var3 < var5.field1255) {
               var6 += var5.field1255 - var3;
            }

            if(var6 - 64 <= var5.field1258 && field1034 != 0 && var1 == var5.field1265) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = (var5.field1258 - var6) * field1034 / var5.field1258;
               Object var10000;
               if(var5.field1260 == null) {
                  if(var5.field1259 >= 0) {
                     var10000 = null;
                     SoundEffect var14 = SoundEffect.getTrack(class44.indexCache4, var5.field1259, 0);
                     if(var14 != null) {
                        RawAudioNode var15 = var14.method2115().applyResampler(Buffer.field2571);
                        class115 var16 = class115.method2300(var15, 100, var7);
                        var16.method2303(-1);
                        GameCanvas.field632.method2085(var16);
                        var5.field1260 = var16;
                     }
                  }
               } else {
                  var5.field1260.method2304(var7);
               }

               if(var5.field1254 == null) {
                  if(var5.field1263 != null && (var5.field1253 -= var4) <= 0) {
                     var8 = (int)(Math.random() * (double)var5.field1263.length);
                     var10000 = null;
                     SoundEffect var17 = SoundEffect.getTrack(class44.indexCache4, var5.field1263[var8], 0);
                     if(var17 != null) {
                        RawAudioNode var18 = var17.method2115().applyResampler(Buffer.field2571);
                        class115 var11 = class115.method2300(var18, 100, var7);
                        var11.method2303(0);
                        GameCanvas.field632.method2085(var11);
                        var5.field1254 = var11;
                        var5.field1253 = var5.field1266 + (int)(Math.random() * (double)(var5.field1262 - var5.field1266));
                     }
                  }
               } else {
                  var5.field1254.method2304(var7);
                  if(!var5.field1254.linked()) {
                     var5.field1254 = null;
                  }
               }
            } else {
               if(var5.field1260 != null) {
                  GameCanvas.field632.method2062(var5.field1260);
                  var5.field1260 = null;
               }

               if(var5.field1254 != null) {
                  GameCanvas.field632.method2062(var5.field1254);
                  var5.field1254 = null;
               }
            }
         }
      }

      field893 = 0;
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(Lco;B)Z",
      garbageValue = "67"
   )
   final boolean method1209(NetWriter var1) {
      class169 var2 = var1.getSocket();
      PacketBuffer var3 = var1.packetBuffer;
      if(var2 == null) {
         return false;
      } else {
         String var24;
         int var25;
         try {
            int var5;
            if(var1.serverPacket == null) {
               if(var1.field1479) {
                  if(!var2.vmethod3338(1)) {
                     return false;
                  }

                  var2.vmethod3318(var1.packetBuffer.payload, 0, 1);
                  var1.field1480 = 0;
                  var1.field1479 = false;
               }

               var3.offset = 0;
               if(var3.method3813()) {
                  if(!var2.vmethod3338(1)) {
                     return false;
                  }

                  var2.vmethod3318(var1.packetBuffer.payload, 1, 1);
                  var1.field1480 = 0;
               }

               var1.field1479 = true;
               ServerPacket[] var4 = GameSocket.method3366();
               var5 = var3.method3792();
               if(var5 < 0 || var5 >= var4.length) {
                  throw new IOException(var5 + " " + var3.offset);
               }

               var1.serverPacket = var4[var5];
               var1.packetLength = var1.serverPacket.packetLength;
            }

            if(var1.packetLength == -1) {
               if(!var2.vmethod3338(1)) {
                  return false;
               }

               var1.getSocket().vmethod3318(var3.payload, 0, 1);
               var1.packetLength = var3.payload[0] & 255;
            }

            if(var1.packetLength == -2) {
               if(!var2.vmethod3338(2)) {
                  return false;
               }

               var1.getSocket().vmethod3318(var3.payload, 0, 2);
               var3.offset = 0;
               var1.packetLength = var3.readUnsignedShort();
            }

            if(!var2.vmethod3338(var1.packetLength)) {
               return false;
            }

            var3.offset = 0;
            var2.vmethod3318(var3.payload, 0, var1.packetLength);
            var1.field1480 = 0;
            field1050.method5210();
            var1.field1471 = var1.field1473;
            var1.field1473 = var1.field1485;
            var1.field1485 = var1.serverPacket;
            if(ServerPacket.field2288 == var1.serverPacket) {
               BoundingBox.method58(class183.field2486);
               var1.serverPacket = null;
               return true;
            }

            Widget var6;
            int var23;
            if(ServerPacket.field2309 == var1.serverPacket) {
               var23 = var3.method3566();
               var5 = var3.method3716();
               var6 = class3.getWidget(var23);
               if(var6.modelType != 1 || var5 != var6.modelId) {
                  var6.modelType = 1;
                  var6.modelId = var5;
                  WorldMapType1.method274(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            boolean var60;
            if(ServerPacket.field2333 == var1.serverPacket) {
               var23 = var3.readInt();
               var60 = var3.method3549() == 1;
               var6 = class3.getWidget(var23);
               if(var60 != var6.isHidden) {
                  var6.isHidden = var60;
                  WorldMapType1.method274(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2320 == var1.serverPacket) {
               WorldMapManager.field533 = var3.method3549();
               GameEngine.field673 = var3.method3549();
               var1.serverPacket = null;
               return true;
            }

            Widget var77;
            if(ServerPacket.field2313 == var1.serverPacket) {
               var23 = var3.readInt();
               var77 = class3.getWidget(var23);

               for(var25 = 0; var25 < var77.itemIds.length; ++var25) {
                  var77.itemIds[var25] = -1;
                  var77.itemIds[var25] = 0;
               }

               WorldMapType1.method274(var77);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2350 == var1.serverPacket) {
               var23 = var3.readInt();
               var5 = var3.readInt();
               var25 = VertexNormal.method2789();
               PacketNode var65 = FaceNormal.method3078(ClientPacket.field2411, field902.field1475);
               var65.packetBuffer.putShortLE(GameEngine.FPS);
               var65.packetBuffer.putShortLE(var25);
               var65.packetBuffer.method3670(var23);
               var65.packetBuffer.method3677(var5);
               field902.method2036(var65);
               var1.serverPacket = null;
               return true;
            }

            long var9;
            long var12;
            int var15;
            long var26;
            long var28;
            String var54;
            if(ServerPacket.field2364 == var1.serverPacket) {
               var54 = var3.readString();
               var26 = var3.readLong();
               var28 = (long)var3.readUnsignedShort();
               var9 = (long)var3.read24BitInt();
               Permission var68 = (Permission)class44.forOrdinal(class3.method6(), var3.readUnsignedByte());
               var12 = var9 + (var28 << 32);
               boolean var72 = false;

               for(var15 = 0; var15 < 100; ++var15) {
                  if(var12 == field989[var15]) {
                     var72 = true;
                     break;
                  }
               }

               if(var68.field3327 && RunException.friendManager.method1695(new Name(var54, loginType))) {
                  var72 = true;
               }

               if(!var72 && myPlayerIndex == 0) {
                  field989[field1075] = var12;
                  field1075 = (field1075 + 1) % 100;
                  String var85 = BaseVarType.method13(var3, 32767);
                  String var74 = FontTypeFace.appendTags(Item.method1925(var85));
                  if(var68.field3334 != -1) {
                     class251.addChatMessage(9, class22.method186(var68.field3334) + var54, var74, GraphicsObject.method1798(var26));
                  } else {
                     class251.addChatMessage(9, var54, var74, GraphicsObject.method1798(var26));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2314 == var1.serverPacket) {
               var23 = var3.readUnsignedByte();
               BoundingBox3DDrawMode.method67(var23);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2341 == var1.serverPacket) {
               BoundingBox.method58(class183.field2488);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2361 == var1.serverPacket) {
               WorldMapType1.method298();
               energy = var3.readUnsignedByte();
               field1052 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2332 == var1.serverPacket) {
               FriendManager.method1722();
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2292 == var1.serverPacket) {
               BoundingBox.method58(class183.field2481);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2355 == var1.serverPacket) {
               if(widgetRoot != -1) {
                  DState.method3500(widgetRoot, 0);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2344 == var1.serverPacket) {
               var23 = var3.readInt();
               WidgetNode var82 = (WidgetNode)componentTable.get((long)var23);
               if(var82 != null) {
                  class44.closeWidget(var82, true);
               }

               if(field1102 != null) {
                  WorldMapType1.method274(field1102);
                  field1102 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2339 == var1.serverPacket) {
               field1099 = true;
               MapLabel.field451 = var3.readUnsignedByte();
               WorldComparator.field261 = var3.readUnsignedByte();
               CombatInfo2.field3523 = var3.readUnsignedShort();
               class110.field1590 = var3.readUnsignedByte();
               class49.field578 = var3.readUnsignedByte();
               if(class49.field578 >= 100) {
                  Sequence.cameraX = MapLabel.field451 * 128 + 64;
                  ChatLineBuffer.cameraY = WorldComparator.field261 * 128 + 64;
                  Area.cameraZ = class5.getTileHeight(Sequence.cameraX, ChatLineBuffer.cameraY, class237.plane) - CombatInfo2.field3523;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2290 == var1.serverPacket) {
               field1087 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2345 == var1.serverPacket) {
               BoundingBox.method58(class183.field2485);
               var1.serverPacket = null;
               return true;
            }

            int var8;
            int var31;
            if(ServerPacket.field2335 == var1.serverPacket) {
               var23 = var3.method3716();
               if(var23 == 65535) {
                  var23 = -1;
               }

               var5 = var3.readUnsignedShort();
               if(var5 == 65535) {
                  var5 = -1;
               }

               var25 = var3.method3566();
               var31 = var3.method3565();

               for(var8 = var5; var8 <= var23; ++var8) {
                  var9 = (long)var8 + ((long)var31 << 32);
                  Node var66 = widgetFlags.get(var9);
                  if(var66 != null) {
                     var66.unlink();
                  }

                  widgetFlags.put(new IntegerNode(var25), var9);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2294 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               var5 = var3.readUnsignedByte();
               var25 = var3.readUnsignedShort();
               Permission.method4531(var23, var5, var25);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2331 == var1.serverPacket) {
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

            if(ServerPacket.field2316 == var1.serverPacket) {
               WorldMapType1.method298();
               weight = var3.readShort();
               field1052 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2303 == var1.serverPacket) {
               RunException.friendManager.field1249.method5310(var3, var1.packetLength);
               Iterator var57 = class95.messages.iterator();

               while(var57.hasNext()) {
                  MessageNode var81 = (MessageNode)var57.next();
                  var81.method1107();
               }

               if(class33.clanMemberManager != null) {
                  class33.clanMemberManager.method5469();
               }

               field1048 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            Widget var87;
            if(ServerPacket.field2300 == var1.serverPacket) {
               var23 = var3.method3716();
               var5 = var3.method3566();
               var25 = var3.method3513();
               var31 = var3.readUnsignedShortOb1();
               var87 = class3.getWidget(var5);
               if(var25 != var87.rotationX || var23 != var87.rotationZ || var31 != var87.modelZoom) {
                  var87.rotationX = var25;
                  var87.rotationZ = var23;
                  var87.modelZoom = var31;
                  WorldMapType1.method274(var87);
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var62;
            if(ServerPacket.field2352 == var1.serverPacket) {
               var23 = var3.method3716();
               if(var23 == 65535) {
                  var23 = -1;
               }

               var5 = var3.readInt();
               var25 = var3.readInt();
               var62 = class3.getWidget(var25);
               ItemComposition var91;
               if(!var62.hasScript) {
                  if(var23 == -1) {
                     var62.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var91 = GameObject.getItemDefinition(var23);
                  var62.modelType = 4;
                  var62.modelId = var23;
                  var62.rotationX = var91.xan2d;
                  var62.rotationZ = var91.yan2d;
                  var62.modelZoom = var91.zoom2d * 100 / var5;
                  WorldMapType1.method274(var62);
               } else {
                  var62.itemId = var23;
                  var62.itemQuantity = var5;
                  var91 = GameObject.getItemDefinition(var23);
                  var62.rotationX = var91.xan2d;
                  var62.rotationZ = var91.yan2d;
                  var62.rotationY = var91.zan2d;
                  var62.offsetX2d = var91.offsetX2d;
                  var62.offsetY2d = var91.offsetY2d;
                  var62.modelZoom = var91.zoom2d;
                  if(var91.isStackable == 1) {
                     var62.field2872 = 1;
                  } else {
                     var62.field2872 = 2;
                  }

                  if(var62.field2869 > 0) {
                     var62.modelZoom = var62.modelZoom * 32 / var62.field2869;
                  } else if(var62.originalWidth > 0) {
                     var62.modelZoom = var62.modelZoom * 32 / var62.originalWidth;
                  }

                  WorldMapType1.method274(var62);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2327 == var1.serverPacket) {
               var23 = var3.readUnsignedShortOb1();
               widgetRoot = var23;
               this.method1347(false);
               class251.method4520(var23);
               FriendManager.runWidgetOnLoadListener(widgetRoot);

               for(var5 = 0; var5 < 100; ++var5) {
                  field1060[var5] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2285 == var1.serverPacket) {
               var54 = var3.readString();
               Object[] var80 = new Object[var54.length() + 1];

               for(var25 = var54.length() - 1; var25 >= 0; --var25) {
                  if(var54.charAt(var25) == 's') {
                     var80[var25 + 1] = var3.readString();
                  } else {
                     var80[var25 + 1] = new Integer(var3.readInt());
                  }
               }

               var80[0] = new Integer(var3.readInt());
               ScriptEvent var69 = new ScriptEvent();
               var69.objs = var80;
               AbstractByteBuffer.method3757(var69);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2349 == var1.serverPacket) {
               var23 = var3.method3566();
               var5 = var3.readUnsignedShort();
               var6 = class3.getWidget(var23);
               if(var6 != null && var6.type == 0) {
                  if(var5 > var6.scrollHeight - var6.height) {
                     var5 = var6.scrollHeight - var6.height;
                  }

                  if(var5 < 0) {
                     var5 = 0;
                  }

                  if(var5 != var6.scrollY) {
                     var6.scrollY = var5;
                     WorldMapType1.method274(var6);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2307 == var1.serverPacket) {
               if(class33.clanMemberManager != null) {
                  class33.clanMemberManager.method5490(var3);
               }

               field1049 = cycleCntr;
               IndexStoreActionHandler.field3392 = true;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2342 == var1.serverPacket) {
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

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2366 == var1.serverPacket) {
               field1099 = false;

               for(var23 = 0; var23 < 5; ++var23) {
                  field901[var23] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            int var10;
            int var14;
            int var18;
            int var34;
            String var86;
            String var89;
            if(ServerPacket.field2367 == var1.serverPacket) {
               var23 = var1.packetLength;
               ClassInfo var79 = new ClassInfo();
               var79.count = var3.readUnsignedByte();
               var79.field3948 = var3.readInt();
               var79.type = new int[var79.count];
               var79.errorIdentifiers = new int[var79.count];
               var79.fields = new Field[var79.count];
               var79.field3947 = new int[var79.count];
               var79.methods = new Method[var79.count];
               var79.args = new byte[var79.count][][];

               for(var25 = 0; var25 < var79.count; ++var25) {
                  try {
                     var31 = var3.readUnsignedByte();
                     if(var31 != 0 && var31 != 1 && var31 != 2) {
                        if(var31 == 3 || var31 == 4) {
                           var86 = var3.readString();
                           var89 = var3.readString();
                           var10 = var3.readUnsignedByte();
                           String[] var11 = new String[var10];

                           for(var34 = 0; var34 < var10; ++var34) {
                              var11[var34] = var3.readString();
                           }

                           String var93 = var3.readString();
                           byte[][] var71 = new byte[var10][];
                           if(var31 == 3) {
                              for(var14 = 0; var14 < var10; ++var14) {
                                 var15 = var3.readInt();
                                 var71[var14] = new byte[var15];
                                 var3.readBytes(var71[var14], 0, var15);
                              }
                           }

                           var79.type[var25] = var31;
                           Class[] var94 = new Class[var10];

                           for(var15 = 0; var15 < var10; ++var15) {
                              var94[var15] = WorldMapRectangle.loadClassFromDescriptor(var11[var15]);
                           }

                           Class var30 = WorldMapRectangle.loadClassFromDescriptor(var93);
                           if(WorldMapRectangle.loadClassFromDescriptor(var86).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var16 = WorldMapRectangle.loadClassFromDescriptor(var86).getDeclaredMethods();
                           Method[] var17 = var16;

                           for(var18 = 0; var18 < var17.length; ++var18) {
                              Method var19 = var17[var18];
                              if(Reflection.getMethodName(var19).equals(var89)) {
                                 Class[] var20 = Reflection.getParameterTypes(var19);
                                 if(var20.length == var94.length) {
                                    boolean var21 = true;

                                    for(int var22 = 0; var22 < var94.length; ++var22) {
                                       if(var20[var22] != var94[var22]) {
                                          var21 = false;
                                          break;
                                       }
                                    }

                                    if(var21 && var30 == var19.getReturnType()) {
                                       var79.methods[var25] = var19;
                                    }
                                 }
                              }
                           }

                           var79.args[var25] = var71;
                        }
                     } else {
                        var86 = var3.readString();
                        var89 = var3.readString();
                        var10 = 0;
                        if(var31 == 1) {
                           var10 = var3.readInt();
                        }

                        var79.type[var25] = var31;
                        var79.field3947[var25] = var10;
                        if(WorldMapRectangle.loadClassFromDescriptor(var86).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var79.fields[var25] = Reflection.findField(WorldMapRectangle.loadClassFromDescriptor(var86), var89);
                     }
                  } catch (ClassNotFoundException var47) {
                     var79.errorIdentifiers[var25] = -1;
                  } catch (SecurityException var48) {
                     var79.errorIdentifiers[var25] = -2;
                  } catch (NullPointerException var49) {
                     var79.errorIdentifiers[var25] = -3;
                  } catch (Exception var50) {
                     var79.errorIdentifiers[var25] = -4;
                  } catch (Throwable var51) {
                     var79.errorIdentifiers[var25] = -5;
                  }
               }

               class326.classInfos.addFirst(var79);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2343 == var1.serverPacket) {
               for(var23 = 0; var23 < VarPlayerType.field3445; ++var23) {
                  VarPlayerType var67 = (VarPlayerType)VarPlayerType.varplayers.get((long)var23);
                  VarPlayerType var78;
                  if(var67 != null) {
                     var78 = var67;
                  } else {
                     byte[] var64 = VarPlayerType.varplayer_ref.getConfigData(16, var23);
                     var67 = new VarPlayerType();
                     if(var64 != null) {
                        var67.decode(new Buffer(var64));
                     }

                     VarPlayerType.varplayers.put(var67, (long)var23);
                     var78 = var67;
                  }

                  if(var78 != null) {
                     class237.serverVarps[var23] = 0;
                     class237.clientVarps[var23] = 0;
                  }
               }

               WorldMapType1.method298();
               field1042 += 32;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2324 == var1.serverPacket) {
               var23 = var3.method3566();
               var77 = class3.getWidget(var23);
               var77.modelType = 3;
               var77.modelId = WorldComparator.localPlayer.composition.method4416();
               WorldMapType1.method274(var77);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2322 == var1.serverPacket) {
               ServerPacket.updateNpcs(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2299 == var1.serverPacket) {
               BoundingBox.method58(class183.field2490);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2329 == var1.serverPacket) {
               BoundingBox.method58(class183.field2487);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2321 == var1.serverPacket) {
               var23 = var3.readInt();
               var5 = var3.readShort();
               var6 = class3.getWidget(var23);
               if(var5 != var6.field2831 || var5 == -1) {
                  var6.field2831 = var5;
                  var6.field2837 = 0;
                  var6.field2806 = 0;
                  WorldMapType1.method274(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            boolean var83;
            if(ServerPacket.field2362 == var1.serverPacket) {
               var83 = var3.method3526();
               if(var83) {
                  if(field1132 == null) {
                     field1132 = new class265();
                  }
               } else {
                  field1132 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2286 == var1.serverPacket) {
               BoundingBox.method58(class183.field2482);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2353 == var1.serverPacket) {
               class251.field3296 = ScriptEvent.method1103(var3.readUnsignedByte());
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2289 == var1.serverPacket) {
               var23 = var3.method3560();
               var5 = var3.readInt();
               var25 = var3.method3626();
               var62 = class3.getWidget(var5);
               if(var25 != var62.originalX || var23 != var62.originalY || var62.dynamicX != 0 || var62.dynamicY != 0) {
                  var62.originalX = var25;
                  var62.originalY = var23;
                  var62.dynamicX = 0;
                  var62.dynamicY = 0;
                  WorldMapType1.method274(var62);
                  this.widgetMethod0(var62);
                  if(var62.type == 0) {
                     MapIcon.method578(class189.widgets[var5 >> 16], var62, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2356 == var1.serverPacket) {
               ServerPacket.updateNpcs(true, var3);
               var1.serverPacket = null;
               return true;
            }

            int var37;
            if(ServerPacket.field2368 == var1.serverPacket) {
               var23 = var3.method3564();
               var5 = var3.method3513();
               var25 = var5 >> 10 & 31;
               var31 = var5 >> 5 & 31;
               var8 = var5 & 31;
               var37 = (var31 << 11) + (var25 << 19) + (var8 << 3);
               Widget var95 = class3.getWidget(var23);
               if(var37 != var95.textColor) {
                  var95.textColor = var37;
                  WorldMapType1.method274(var95);
               }

               var1.serverPacket = null;
               return true;
            }

            WidgetNode var58;
            if(ServerPacket.field2291 == var1.serverPacket) {
               var23 = var3.offset + var1.packetLength;
               var5 = var3.readUnsignedShort();
               var25 = var3.readUnsignedShort();
               if(var5 != widgetRoot) {
                  widgetRoot = var5;
                  this.method1347(false);
                  class251.method4520(widgetRoot);
                  FriendManager.runWidgetOnLoadListener(widgetRoot);

                  for(var31 = 0; var31 < 100; ++var31) {
                     field1060[var31] = true;
                  }
               }

               WidgetNode var38;
               for(; var25-- > 0; var38.field775 = true) {
                  var31 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var37 = var3.readUnsignedByte();
                  var38 = (WidgetNode)componentTable.get((long)var31);
                  if(var38 != null && var8 != var38.id) {
                     class44.closeWidget(var38, true);
                     var38 = null;
                  }

                  if(var38 == null) {
                     WidgetNode var35 = new WidgetNode();
                     var35.id = var8;
                     var35.owner = var37;
                     componentTable.put(var35, (long)var31);
                     class251.method4520(var8);
                     Widget var70 = class3.getWidget(var31);
                     WorldMapType1.method274(var70);
                     if(field1102 != null) {
                        WorldMapType1.method274(field1102);
                        field1102 = null;
                     }

                     BoundingBox3D.method62();
                     MapIcon.method578(class189.widgets[var31 >> 16], var70, false);
                     FriendManager.runWidgetOnLoadListener(var8);
                     if(widgetRoot != -1) {
                        DState.method3500(widgetRoot, 1);
                     }

                     var38 = var35;
                  }
               }

               for(var58 = (WidgetNode)componentTable.first(); var58 != null; var58 = (WidgetNode)componentTable.next()) {
                  if(var58.field775) {
                     var58.field775 = false;
                  } else {
                     class44.closeWidget(var58, true);
                  }
               }

               widgetFlags = new HashTable(512);

               while(var3.offset < var23) {
                  var31 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var37 = var3.readUnsignedShort();
                  var10 = var3.readInt();

                  for(int var39 = var8; var39 <= var37; ++var39) {
                     var12 = ((long)var31 << 32) + (long)var39;
                     widgetFlags.put(new IntegerNode(var10), var12);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2304 == var1.serverPacket) {
               if(var1.packetLength == 0) {
                  class33.clanMemberManager = null;
               } else {
                  if(class33.clanMemberManager == null) {
                     class33.clanMemberManager = new ClanMemberManager(loginType, BoundingBox.clientInstance);
                  }

                  class33.clanMemberManager.method5492(var3);
               }

               field1049 = cycleCntr;
               IndexStoreActionHandler.field3392 = true;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2305 == var1.serverPacket) {
               field1099 = true;
               VarPlayerType.field3441 = var3.readUnsignedByte();
               class149.field2123 = var3.readUnsignedByte();
               class86.field1317 = var3.readUnsignedShort();
               UnitPriceComparator.field294 = var3.readUnsignedByte();
               class37.field485 = var3.readUnsignedByte();
               if(class37.field485 >= 100) {
                  var23 = VarPlayerType.field3441 * 128 + 64;
                  var5 = class149.field2123 * 128 + 64;
                  var25 = class5.getTileHeight(var23, var5, class237.plane) - class86.field1317;
                  var31 = var23 - Sequence.cameraX;
                  var8 = var25 - Area.cameraZ;
                  var37 = var5 - ChatLineBuffer.cameraY;
                  var10 = (int)Math.sqrt((double)(var31 * var31 + var37 * var37));
                  BoundingBox3D.cameraPitch = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
                  ClientPacket.cameraYaw = (int)(Math.atan2((double)var31, (double)var37) * -325.949D) & 2047;
                  if(BoundingBox3D.cameraPitch < 128) {
                     BoundingBox3D.cameraPitch = 128;
                  }

                  if(BoundingBox3D.cameraPitch > 383) {
                     BoundingBox3D.cameraPitch = 383;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2334 == var1.serverPacket) {
               World var56 = new World();
               var56.address = var3.readString();
               var56.id = var3.readUnsignedShort();
               var5 = var3.readInt();
               var56.mask = var5;
               MapIconReference.setGameState(45);
               var2.vmethod3325();
               var2 = null;
               class80.changeWorld(var56);
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2348 == var1.serverPacket) {
               var3.offset += 28;
               if(var3.checkCrc()) {
                  var23 = var3.offset - 28;
                  class167.method3253(var3.payload, var23);
                  if(class167.randomDat != null) {
                     try {
                        class167.randomDat.seek(0L);
                        class167.randomDat.write(var3.payload, var23, 24);
                     } catch (Exception var46) {
                        ;
                     }
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2306 == var1.serverPacket) {
               var23 = var3.readUnsignedShortOb1();
               var5 = var3.method3566();
               var25 = var3.method3716();
               var62 = class3.getWidget(var5);
               var62.field2906 = var25 + (var23 << 16);
               var1.serverPacket = null;
               return true;
            }

            String var61;
            if(ServerPacket.field2315 == var1.serverPacket) {
               var54 = var3.readString();
               var24 = BaseVarType.method13(var3, 32767);
               var61 = FontTypeFace.appendTags(Item.method1925(var24));
               class189.sendGameMessage(6, var54, var61);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2360 == var1.serverPacket) {
               var23 = var3.method3564();
               var5 = var3.method3513();
               class237.serverVarps[var5] = var23;
               if(class237.clientVarps[var5] != var23) {
                  class237.clientVarps[var5] = var23;
               }

               class93.method1950(var5);
               field988[++field1042 - 1 & 31] = var5;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2330 == var1.serverPacket) {
               MouseRecorder.xteaChanged(true, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2323 == var1.serverPacket) {
               RunException.friendManager.method1659(var3, var1.packetLength);
               field1048 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2301 == var1.serverPacket) {
               var23 = var3.method3716();
               var5 = var3.readInt();
               var6 = class3.getWidget(var5);
               if(var6.modelType != 2 || var23 != var6.modelId) {
                  var6.modelType = 2;
                  var6.modelId = var23;
                  WorldMapType1.method274(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2318 == var1.serverPacket) {
               publicChatMode = var3.method3548();
               field1035 = var3.method3548();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2311 == var1.serverPacket) {
               var23 = var3.method3565();
               var5 = var3.method3564();
               WidgetNode var63 = (WidgetNode)componentTable.get((long)var5);
               var58 = (WidgetNode)componentTable.get((long)var23);
               if(var58 != null) {
                  class44.closeWidget(var58, var63 == null || var58.id != var63.id);
               }

               if(var63 != null) {
                  var63.unlink();
                  componentTable.put(var63, (long)var23);
               }

               var87 = class3.getWidget(var5);
               if(var87 != null) {
                  WorldMapType1.method274(var87);
               }

               var87 = class3.getWidget(var23);
               if(var87 != null) {
                  WorldMapType1.method274(var87);
                  MapIcon.method578(class189.widgets[var87.id >>> 16], var87, true);
               }

               if(widgetRoot != -1) {
                  DState.method3500(widgetRoot, 1);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2338 == var1.serverPacket) {
               byte var84 = var3.readByte();
               var5 = var3.method3513();
               class237.serverVarps[var5] = var84;
               if(class237.clientVarps[var5] != var84) {
                  class237.clientVarps[var5] = var84;
               }

               class93.method1950(var5);
               field988[++field1042 - 1 & 31] = var5;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2302 == var1.serverPacket) {
               MouseRecorder.xteaChanged(false, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2357 == var1.serverPacket) {
               var83 = var3.readUnsignedByte() == 1;
               if(var83) {
                  class265.field3431 = ScriptVarType.method28() - var3.readLong();
                  grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  grandExchangeEvents = null;
               }

               field879 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2295 == var1.serverPacket) {
               BoundingBox.method58(class183.field2483);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2347 == var1.serverPacket) {
               RunException.friendManager.method1658();
               field1048 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2340 == var1.serverPacket) {
               var23 = var3.readUnsignedByte();
               if(var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var23] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var23] = new GrandExchangeOffer(var3, false);
               }

               field1008 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2308 == var1.serverPacket) {
               var23 = var3.readUnsignedShortOb1();
               ItemContainer var76 = (ItemContainer)ItemContainer.itemContainers.get((long)var23);
               if(var76 != null) {
                  var76.unlink();
               }

               interfaceItemTriggers[++field1119 - 1 & 31] = var23 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2365 == var1.serverPacket) {
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

            if(ServerPacket.field2351 == var1.serverPacket) {
               var23 = var3.readInt();
               if(var23 != field1009) {
                  field1009 = var23;
                  if(field930 == 1) {
                     field938 = true;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2312 == var1.serverPacket) {
               WorldMapManager.field533 = var3.method3673();
               GameEngine.field673 = var3.readUnsignedByte();

               for(var23 = WorldMapManager.field533; var23 < WorldMapManager.field533 + 8; ++var23) {
                  for(var5 = GameEngine.field673; var5 < GameEngine.field673 + 8; ++var5) {
                     if(groundItemDeque[class237.plane][var23][var5] != null) {
                        groundItemDeque[class237.plane][var23][var5] = null;
                        WorldComparator.groundItemSpawned(var23, var5);
                     }
                  }
               }

               for(PendingSpawn var55 = (PendingSpawn)pendingSpawns.getFront(); var55 != null; var55 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var55.x >= WorldMapManager.field533 && var55.x < WorldMapManager.field533 + 8 && var55.y >= GameEngine.field673 && var55.y < GameEngine.field673 + 8 && var55.level == class237.plane) {
                     var55.hitpoints = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            long var40;
            int var42;
            if(ServerPacket.field2354 == var1.serverPacket) {
               var54 = var3.readString();
               var26 = (long)var3.readUnsignedShort();
               var28 = (long)var3.read24BitInt();
               Permission var90 = (Permission)class44.forOrdinal(class3.method6(), var3.readUnsignedByte());
               var40 = var28 + (var26 << 32);
               boolean var92 = false;

               for(var42 = 0; var42 < 100; ++var42) {
                  if(var40 == field989[var42]) {
                     var92 = true;
                     break;
                  }
               }

               if(RunException.friendManager.method1695(new Name(var54, loginType))) {
                  var92 = true;
               }

               if(!var92 && myPlayerIndex == 0) {
                  field989[field1075] = var40;
                  field1075 = (field1075 + 1) % 100;
                  String var13 = BaseVarType.method13(var3, 32767);
                  String var36 = FontTypeFace.appendTags(Item.method1925(var13));
                  byte var73;
                  if(var90.field3335) {
                     var73 = 7;
                  } else {
                     var73 = 3;
                  }

                  if(var90.field3334 != -1) {
                     class189.sendGameMessage(var73, class22.method186(var90.field3334) + var54, var36);
                  } else {
                     class189.sendGameMessage(var73, var54, var36);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2298 == var1.serverPacket) {
               var23 = var3.readUnsignedByte();
               var5 = var3.readUnsignedByte();
               var25 = var3.readUnsignedByte();
               var31 = var3.readUnsignedByte();
               field901[var23] = true;
               field1101[var23] = var5;
               field861[var23] = var25;
               field1103[var23] = var31;
               field1104[var23] = 0;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2325 == var1.serverPacket) {
               var54 = var3.readString();
               GraphicsObject.sessionToken = var54;

               try {
                  var24 = BoundingBox.clientInstance.getParameter(Parameters.field3804.key);
                  var61 = BoundingBox.clientInstance.getParameter(Parameters.field3805.key);
                  String var59 = var24 + "settings=" + var54 + "; version=1; path=/; domain=" + var61;
                  if(var54.length() == 0) {
                     var59 = var59 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var86 = var59 + "; Expires=";
                     var40 = ScriptVarType.method28() + 94608000000L;
                     class204.field2609.setTime(new Date(var40));
                     var34 = class204.field2609.get(7);
                     var42 = class204.field2609.get(5);
                     var14 = class204.field2609.get(2);
                     var15 = class204.field2609.get(1);
                     int var43 = class204.field2609.get(11);
                     int var44 = class204.field2609.get(12);
                     var18 = class204.field2609.get(13);
                     var89 = class204.field2607[var34 - 1] + ", " + var42 / 10 + var42 % 10 + "-" + class204.field2608[0][var14] + "-" + var15 + " " + var43 / 10 + var43 % 10 + ":" + var44 / 10 + var44 % 10 + ":" + var18 / 10 + var18 % 10 + " GMT";
                     var59 = var86 + var89 + "; Max-Age=" + 94608000L;
                  }

                  class53.method813(BoundingBox.clientInstance, "document.cookie=\"" + var59 + "\"");
               } catch (Throwable var45) {
                  ;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2358 == var1.serverPacket) {
               var23 = var3.method3549();
               var24 = var3.readString();
               var25 = var3.method3548();
               if(var23 >= 1 && var23 <= 8) {
                  if(var24.equalsIgnoreCase("null")) {
                     var24 = null;
                  }

                  playerOptions[var23 - 1] = var24;
                  playerOptionsPriorities[var23 - 1] = var25 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2328 == var1.serverPacket) {
               var23 = var3.method3513();
               if(var23 == 65535) {
                  var23 = -1;
               }

               if(var23 == -1 && !field1090) {
                  class229.field2679.method4150();
                  class229.field2680 = 1;
                  class61.field714 = null;
               } else if(var23 != -1 && var23 != field1089 && field1044 != 0 && !field1090) {
                  CacheFile.method2509(2, class1.indexTrack1, var23, 0, field1044, false);
               }

               field1089 = var23;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2293 == var1.serverPacket) {
               var23 = var3.read24BitInt();
               var5 = var3.method3513();
               if(var5 == 65535) {
                  var5 = -1;
               }

               class95.method2006(var5, var23);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2297 == var1.serverPacket) {
               var23 = var3.getUSmart();
               var60 = var3.readUnsignedByte() == 1;
               var61 = "";
               boolean var88 = false;
               if(var60) {
                  var61 = var3.readString();
                  if(RunException.friendManager.method1695(new Name(var61, loginType))) {
                     var88 = true;
                  }
               }

               var86 = var3.readString();
               if(!var88) {
                  class189.sendGameMessage(var23, var61, var86);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2363 == var1.serverPacket) {
               BoundingBox.method58(class183.field2484);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2359 == var1.serverPacket) {
               for(var23 = 0; var23 < class237.clientVarps.length; ++var23) {
                  if(class237.clientVarps[var23] != class237.serverVarps[var23]) {
                     class237.clientVarps[var23] = class237.serverVarps[var23];
                     class93.method1950(var23);
                     field988[++field1042 - 1 & 31] = var23;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2296 == var1.serverPacket) {
               var23 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if(var23 < -70000) {
                  var5 += 32768;
               }

               if(var23 >= 0) {
                  var6 = class3.getWidget(var23);
               } else {
                  var6 = null;
               }

               for(; var3.offset < var1.packetLength; GrandExchangeEvent.setItemTableSlot(var5, var31, var8 - 1, var37)) {
                  var31 = var3.getUSmart();
                  var8 = var3.readUnsignedShort();
                  var37 = 0;
                  if(var8 != 0) {
                     var37 = var3.readUnsignedByte();
                     if(var37 == 255) {
                        var37 = var3.readInt();
                     }
                  }

                  if(var6 != null && var31 >= 0 && var31 < var6.itemIds.length) {
                     var6.itemIds[var31] = var8;
                     var6.itemQuantities[var31] = var37;
                  }
               }

               if(var6 != null) {
                  WorldMapType1.method274(var6);
               }

               WorldMapType1.method298();
               interfaceItemTriggers[++field1119 - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2317 == var1.serverPacket) {
               var23 = var3.readInt();
               var5 = var3.method3716();
               var25 = var3.method3548();
               var58 = (WidgetNode)componentTable.get((long)var23);
               if(var58 != null) {
                  class44.closeWidget(var58, var5 != var58.id);
               }

               WidgetNode var32 = new WidgetNode();
               var32.id = var5;
               var32.owner = var25;
               componentTable.put(var32, (long)var23);
               class251.method4520(var5);
               Widget var33 = class3.getWidget(var23);
               WorldMapType1.method274(var33);
               if(field1102 != null) {
                  WorldMapType1.method274(field1102);
                  field1102 = null;
               }

               BoundingBox3D.method62();
               MapIcon.method578(class189.widgets[var23 >> 16], var33, false);
               FriendManager.runWidgetOnLoadListener(var5);
               if(widgetRoot != -1) {
                  DState.method3500(widgetRoot, 1);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2336 == var1.serverPacket) {
               BoundingBox.method58(class183.field2489);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2326 == var1.serverPacket) {
               var54 = var3.readString();
               var5 = var3.method3564();
               var6 = class3.getWidget(var5);
               if(!var54.equals(var6.text)) {
                  var6.text = var54;
                  WorldMapType1.method274(var6);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2310 == var1.serverPacket) {
               field873 = var3.readUnsignedShort() * 30;
               field1052 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2346 == var1.serverPacket) {
               WorldMapType1.method298();
               var23 = var3.readUnsignedByte();
               var5 = var3.method3564();
               var25 = var3.method3548();
               skillExperiences[var23] = var5;
               boostedSkillLevels[var23] = var25;
               realSkillLevels[var23] = 1;

               for(var31 = 0; var31 < 98; ++var31) {
                  if(var5 >= class248.field2998[var31]) {
                     realSkillLevels[var23] = var31 + 2;
                  }
               }

               field1045[++field1046 - 1 & 31] = var23;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2337 == var1.serverPacket) {
               method1578(var3, var1.packetLength);
               WorldMapRegion.method516();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2287 == var1.serverPacket) {
               GameEngine.field673 = var3.readUnsignedByte();
               WorldMapManager.field533 = var3.method3549();

               while(var3.offset < var1.packetLength) {
                  var23 = var3.readUnsignedByte();
                  class183 var75 = class81.method1786()[var23];
                  BoundingBox.method58(var75);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2319 == var1.serverPacket) {
               var23 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if(var23 < -70000) {
                  var5 += 32768;
               }

               if(var23 >= 0) {
                  var6 = class3.getWidget(var23);
               } else {
                  var6 = null;
               }

               if(var6 != null) {
                  for(var31 = 0; var31 < var6.itemIds.length; ++var31) {
                     var6.itemIds[var31] = 0;
                     var6.itemQuantities[var31] = 0;
                  }
               }

               ItemContainer var7 = (ItemContainer)ItemContainer.itemContainers.get((long)var5);
               if(var7 != null) {
                  for(var8 = 0; var8 < var7.itemIds.length; ++var8) {
                     var7.itemIds[var8] = -1;
                     var7.stackSizes[var8] = 0;
                  }
               }

               var31 = var3.readUnsignedShort();

               for(var8 = 0; var8 < var31; ++var8) {
                  var37 = var3.method3549();
                  if(var37 == 255) {
                     var37 = var3.method3564();
                  }

                  var10 = var3.readUnsignedShortOb1();
                  if(var6 != null && var8 < var6.itemIds.length) {
                     var6.itemIds[var8] = var10;
                     var6.itemQuantities[var8] = var37;
                  }

                  GrandExchangeEvent.setItemTableSlot(var5, var8, var10 - 1, var37);
               }

               if(var6 != null) {
                  WorldMapType1.method274(var6);
               }

               WorldMapType1.method298();
               interfaceItemTriggers[++field1119 - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            UrlRequest.processClientError("" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1473 != null?var1.field1473.packetId:-1) + "," + (var1.field1471 != null?var1.field1471.packetId:-1) + "," + var1.packetLength, (Throwable)null);
            FriendManager.method1722();
         } catch (IOException var52) {
            class150.method3132();
         } catch (Exception var53) {
            var24 = "" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1473 != null?var1.field1473.packetId:-1) + "," + (var1.field1471 != null?var1.field1471.packetId:-1) + "," + var1.packetLength + "," + (WorldComparator.localPlayer.pathX[0] + PacketNode.baseX) + "," + (WorldComparator.localPlayer.pathY[0] + BaseVarType.baseY) + ",";

            for(var25 = 0; var25 < var1.packetLength && var25 < 50; ++var25) {
               var24 = var24 + var3.payload[var25] + ",";
            }

            UrlRequest.processClientError(var24, var53);
            FriendManager.method1722();
         }

         return true;
      }
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "94952024"
   )
   final void method1399() {
      GZipDecompressor.method3453();
      if(class157.field2149 == null) {
         if(draggedWidget == null) {
            int var2;
            int var4;
            int var5;
            int var10;
            int var14;
            label254: {
               int var1 = MouseInput.mouseLastButton;
               int var3;
               int var8;
               if(isMenuOpen) {
                  if(var1 != 1 && (WorldMapData.middleMouseMovesCamera || var1 != 4)) {
                     var2 = MouseInput.mouseLastX;
                     var3 = MouseInput.mouseLastY;
                     if(var2 < menuX - 10 || var2 > menuX + GrandExchangeEvents.field266 + 10 || var3 < Frames.menuY - 10 || var3 > Frames.menuY + ItemContainer.field754 + 10) {
                        isMenuOpen = false;
                        class61.method1055(menuX, Frames.menuY, GrandExchangeEvents.field266, ItemContainer.field754);
                     }
                  }

                  if(var1 == 1 || !WorldMapData.middleMouseMovesCamera && var1 == 4) {
                     var2 = menuX;
                     var3 = Frames.menuY;
                     var4 = GrandExchangeEvents.field266;
                     var5 = MouseInput.mouseLastPressedX;
                     int var6 = MouseInput.mouseLastPressedY;
                     int var13 = -1;

                     for(var8 = 0; var8 < menuOptionCount; ++var8) {
                        var14 = var3 + (menuOptionCount - 1 - var8) * 15 + 31;
                        if(var5 > var2 && var5 < var4 + var2 && var6 > var14 - 13 && var6 < var14 + 3) {
                           var13 = var8;
                        }
                     }

                     if(var13 != -1) {
                        class33.method379(var13);
                     }

                     isMenuOpen = false;
                     class61.method1055(menuX, Frames.menuY, GrandExchangeEvents.field266, ItemContainer.field754);
                  }
               } else {
                  var2 = class36.method520();
                  if((var1 == 1 || !WorldMapData.middleMouseMovesCamera && var1 == 4) && var2 >= 0) {
                     var3 = menuTypes[var2];
                     if(var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
                        var4 = menuActionParams0[var2];
                        var5 = menuActionParams1[var2];
                        Widget var12 = class3.getWidget(var5);
                        var8 = class45.getWidgetClickMask(var12);
                        boolean var7 = (var8 >> 28 & 1) != 0;
                        if(var7) {
                           break label254;
                        }

                        var10 = class45.getWidgetClickMask(var12);
                        boolean var9 = (var10 >> 29 & 1) != 0;
                        if(var9) {
                           break label254;
                        }
                     }
                  }

                  if((var1 == 1 || !WorldMapData.middleMouseMovesCamera && var1 == 4) && this.method1211()) {
                     var1 = 2;
                  }

                  if((var1 == 1 || !WorldMapData.middleMouseMovesCamera && var1 == 4) && menuOptionCount > 0) {
                     class33.method379(var2);
                  }

                  if(var1 == 2 && menuOptionCount > 0) {
                     this.openMenu(MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                  }
               }

               return;
            }

            if(class157.field2149 != null && !field1109 && menuOptionCount > 0 && !this.method1211()) {
               var14 = field964;
               var10 = field1056;
               ContextMenuRow var11 = ChatLineBuffer.topContextMenuRow;
               class177.menuAction(var11.param0, var11.param1, var11.type, var11.identifier, var11.option, var11.option, var14, var10);
               ChatLineBuffer.topContextMenuRow = null;
            }

            field1109 = false;
            itemPressedDuration = 0;
            if(class157.field2149 != null) {
               WorldMapType1.method274(class157.field2149);
            }

            class157.field2149 = class3.getWidget(var5);
            field1080 = var4;
            field964 = MouseInput.mouseLastPressedX;
            field1056 = MouseInput.mouseLastPressedY;
            if(var2 >= 0) {
               BoundingBox3DDrawMode.method68(var2);
            }

            WorldMapType1.method274(class157.field2149);
         }
      }
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-76"
   )
   final boolean method1211() {
      int var1 = class36.method520();
      boolean var2 = field884 == 1 && menuOptionCount > 2;
      if(!var2) {
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

         var2 = var3;
      }

      return var2 && !menuBooleanArray[var1];
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "13"
   )
   @Export("openMenu")
   final void openMenu(int var1, int var2) {
      int var3 = class228.fontBold12.getTextWidth("Choose Option");

      int var4;
      int var5;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         var5 = class228.fontBold12.getTextWidth(PacketNode.method3438(var4));
         if(var5 > var3) {
            var3 = var5;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      var5 = var1 - var3 / 2;
      if(var3 + var5 > Sequence.canvasWidth) {
         var5 = Sequence.canvasWidth - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      int var6 = var2;
      if(var2 + var4 > class45.canvasHeight) {
         var6 = class45.canvasHeight - var4;
      }

      if(var6 < 0) {
         var6 = 0;
      }

      class308.region.method3046(class237.plane, var1, var2, false);
      isMenuOpen = true;
      menuX = var5;
      Frames.menuY = var6;
      GrandExchangeEvents.field266 = var3;
      ItemContainer.field754 = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1743220630"
   )
   final void method1347(boolean var1) {
      BoundingBox.method61(widgetRoot, Sequence.canvasWidth, class45.canvasHeight, var1);
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(Lib;I)V",
      garbageValue = "2067546783"
   )
   @Export("widgetMethod0")
   void widgetMethod0(Widget var1) {
      Widget var2 = var1.parentId == -1?null:class3.getWidget(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = Sequence.canvasWidth;
         var4 = class45.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      Size.method191(var1, var3, var4, false);
      class292.method5207(var1, var3, var4);
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1206594617"
   )
   final void method1354() {
      WorldMapType1.method274(draggedWidget);
      ++WorldMapRegion.field453;
      if(field877 && field1032) {
         int var1 = MouseInput.mouseLastX;
         int var2 = MouseInput.mouseLastY;
         var1 -= field1029;
         var2 -= field1030;
         if(var1 < field1033) {
            var1 = field1033;
         }

         if(var1 + draggedWidget.width > field1033 + field1028.width) {
            var1 = field1033 + field1028.width - draggedWidget.width;
         }

         if(var2 < field980) {
            var2 = field980;
         }

         if(var2 + draggedWidget.height > field980 + field1028.height) {
            var2 = field980 + field1028.height - draggedWidget.height;
         }

         int var3 = var1 - field1124;
         int var4 = var2 - field1037;
         int var5 = draggedWidget.dragDeadZone;
         if(WorldMapRegion.field453 > draggedWidget.dragDeadTime && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            draggingWidget = true;
         }

         int var6 = var1 - field1033 + field1028.scrollX;
         int var7 = var2 - field980 + field1028.scrollY;
         ScriptEvent var8;
         if(draggedWidget.onDragListener != null && draggingWidget) {
            var8 = new ScriptEvent();
            var8.widget = draggedWidget;
            var8.field783 = var6;
            var8.field778 = var7;
            var8.objs = draggedWidget.onDragListener;
            AbstractByteBuffer.method3757(var8);
         }

         if(MouseInput.mouseCurrentButton == 0) {
            if(draggingWidget) {
               if(draggedWidget.onDragCompleteListener != null) {
                  var8 = new ScriptEvent();
                  var8.widget = draggedWidget;
                  var8.field783 = var6;
                  var8.field778 = var7;
                  var8.field784 = draggedOnWidget;
                  var8.objs = draggedWidget.onDragCompleteListener;
                  AbstractByteBuffer.method3757(var8);
               }

               if(draggedOnWidget != null && NetWriter.method2045(draggedWidget) != null) {
                  PacketNode var12 = FaceNormal.method3078(ClientPacket.field2444, field902.field1475);
                  var12.packetBuffer.putInt(draggedWidget.id);
                  var12.packetBuffer.putShort(draggedWidget.index);
                  var12.packetBuffer.putShort(draggedOnWidget.index);
                  var12.packetBuffer.method3563(draggedOnWidget.id);
                  var12.packetBuffer.putShort(draggedOnWidget.itemId);
                  var12.packetBuffer.method3648(draggedWidget.itemId);
                  field902.method2036(var12);
               }
            } else if(this.method1211()) {
               this.openMenu(field1124 + field1029, field1030 + field1037);
            } else if(menuOptionCount > 0) {
               int var11 = field1124 + field1029;
               int var9 = field1037 + field1030;
               ContextMenuRow var10 = ChatLineBuffer.topContextMenuRow;
               class177.menuAction(var10.param0, var10.param1, var10.type, var10.identifier, var10.option, var10.option, var11, var9);
               ChatLineBuffer.topContextMenuRow = null;
            }

            draggedWidget = null;
         }

      } else {
         if(WorldMapRegion.field453 > 1) {
            draggedWidget = null;
         }

      }
   }

   @ObfuscatedName("kc")
   @ObfuscatedSignature(
      signature = "(B)Lko;",
      garbageValue = "24"
   )
   public Name vmethod5410() {
      return WorldComparator.localPlayer != null?WorldComparator.localPlayer.name:null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Ljy;",
      garbageValue = "-37"
   )
   public static class278 method1577(int var0) {
      class278 var1 = (class278)class278.field3545.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class278.field3542.getConfigData(11, var0);
         var1 = new class278();
         if(var2 != null) {
            var1.method4905(new Buffer(var2));
         }

         var1.method4903();
         class278.field3545.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgf;II)V",
      garbageValue = "-1838773943"
   )
   static final void method1578(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class93.field1421 = 0;
      KeyFocusListener.method794(var0);
      AttackOption.method1860(var0);
      if(var0.offset - var2 != var1) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1695511311"
   )
   static final void method1579(String var0) {
      PacketNode var1 = FaceNormal.method3078(ClientPacket.field2413, field902.field1475);
      var1.packetBuffer.putByte(Projectile.getLength(var0));
      var1.packetBuffer.putString(var0);
      field902.method2036(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-1705583030"
   )
   public static String method1580(CharSequence var0) {
      return class294.method5232('*', var0.length());
   }
}
