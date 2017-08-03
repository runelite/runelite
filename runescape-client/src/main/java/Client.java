import java.io.IOException;
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
   @ObfuscatedName("aj")
   static boolean field958;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 190561963
   )
   static int field908;
   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   static class232 field1110;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 112731177
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = -1486487997
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("ko")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static Widget field912;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = 1844002095
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 1894964643
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 1133028023
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1794673927
   )
   @Export("gameState")
   @Hook("gameStateChanged")
   static int gameState;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = -705160223
   )
   static int field928;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -1422527129
   )
   @Export("world")
   static int world;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -1061370715
   )
   static int field946;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = -857502527
   )
   static int field1086;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = -1298735499
   )
   static int field906;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      longValue = -7100539420996014161L
   )
   static long field955;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -1835849147
   )
   static int field922;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 733356261
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = -154424497
   )
   static int field1020;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1184395807
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("jm")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("mv")
   static boolean[] field1088;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -1530182521
   )
   @Export("packetType")
   static int packetType;
   @ObfuscatedName("mh")
   static boolean[] field1090;
   @ObfuscatedName("mo")
   static boolean[] field971;
   @ObfuscatedName("jg")
   static boolean[] field1013;
   @ObfuscatedName("jp")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = 974966329
   )
   static int field1032;
   @ObfuscatedName("jc")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = -1356546867
   )
   @Export("secondLastFrameId")
   static int secondLastFrameId;
   @ObfuscatedName("lb")
   static boolean field1064;
   @ObfuscatedName("bh")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("eo")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = 1037442929
   )
   @Export("packetLength")
   static int packetLength;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -110804859
   )
   static int field966;
   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   @Export("secretPacketBuffer2")
   static PacketBuffer secretPacketBuffer2;
   @ObfuscatedName("bx")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("jl")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -1916665435
   )
   @Export("thridLastFrameId")
   static int thridLastFrameId;
   @ObfuscatedName("mw")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 157606163
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = -1566855429
   )
   static int field925;
   @ObfuscatedName("lp")
   static boolean field1061;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -1423640093
   )
   static int field1058;
   @ObfuscatedName("kv")
   static boolean field1120;
   @ObfuscatedName("on")
   static boolean field1121;
   @ObfuscatedName("bt")
   static boolean field900;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = -915481793
   )
   static int field1073;
   @ObfuscatedName("jd")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfl;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = 1852761819
   )
   static int field1063;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      longValue = -3887413835218269891L
   )
   static long field1024;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = 1661362451
   )
   static int field1062;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      intValue = -872526253
   )
   static int field1069;
   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   @Export("secretPacketBuffer1")
   static PacketBuffer secretPacketBuffer1;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -709959091
   )
   static int field967;
   @ObfuscatedName("jn")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -79238775
   )
   static int field987;
   @ObfuscatedName("jo")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -161231163
   )
   static int field905;
   @ObfuscatedName("lx")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static Widget field1057;
   @ObfuscatedName("bk")
   static boolean field916;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -1414075701
   )
   static int field1078;
   @ObfuscatedName("md")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = 200979443
   )
   @Export(
      value = "gameDrawingMode",
      setter = true
   )
   static int gameDrawingMode;
   @ObfuscatedName("bg")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("mz")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("kq")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -1579456171
   )
   static int field943;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 1199147201
   )
   static int field953;
   @ObfuscatedName("jf")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -403613079
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -542000453
   )
   static int field1115;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = 1468049819
   )
   static int field949;
   @ObfuscatedName("jy")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("kb")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("mj")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -13227063
   )
   static int field910;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = 566330107
   )
   static int field950;
   @ObfuscatedName("jt")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("mt")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = -226008693
   )
   static int field1056;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -760461615
   )
   static int field911;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -1002045899
   )
   static int field951;
   @ObfuscatedName("mn")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = 835595513
   )
   static int field1084;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 272362275
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 272658495
   )
   static int field952;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -713158031
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("re")
   @ObfuscatedSignature(
      signature = "Lbk;"
   )
   static final class73 field1159;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -1036641899
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("kf")
   static String field972;
   @ObfuscatedName("it")
   static String field1037;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = -181356183
   )
   static int field1134;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 1324615365
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("ki")
   static String field1042;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = 1972373051
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1634386379
   )
   static int field915;
   @ObfuscatedName("ky")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static Widget field1055;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = -1124908677
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 450507039
   )
   static int field1009;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = 1963740641
   )
   static int field1065;
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   static class91 field1117;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = -583816437
   )
   static int field942;
   @ObfuscatedName("ib")
   static boolean field923;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = 1408012935
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -760669859
   )
   static int field1047;
   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   static class91 field918;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = 1877233
   )
   static int field1081;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = -630580261
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1553056959
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("rj")
   static int[] field919;
   @ObfuscatedName("rl")
   static int[] field1161;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = 1226062855
   )
   static int field997;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = 1590810765
   )
   static int field998;
   @ObfuscatedName("mk")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static Deque field1082;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = -1078669783
   )
   static int field1123;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -1229935065
   )
   static int field941;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = -1226636897
   )
   static int field996;
   @ObfuscatedName("lf")
   static boolean field1067;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -27247311
   )
   @Export("lastFrameId")
   static int lastFrameId;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 691627667
   )
   static int field929;
   @ObfuscatedName("dc")
   static byte[] field930;
   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "[Lcf;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = 135670723
   )
   @Export("audioEffectCount")
   static int audioEffectCount;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -641392011
   )
   static int field932;
   @ObfuscatedName("po")
   static boolean field1130;
   @ObfuscatedName("dj")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 681843249
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("ed")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = 1645009847
   )
   static int field1156;
   @ObfuscatedName("el")
   static HashMap field948;
   @ObfuscatedName("qa")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   static PlayerComposition field1155;
   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = 1425241669
   )
   static int field1157;
   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   static PacketBuffer field937;
   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("lw")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static Widget field1060;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = -1841534993
   )
   static int field994;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -381308569
   )
   static int field1100;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -1213411029
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = 1116454753
   )
   static int field1044;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = -1289574649
   )
   static int field995;
   @ObfuscatedName("fe")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("ls")
   static int[] field1079;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = -293341391
   )
   static int field1038;
   @ObfuscatedName("ob")
   @ObfuscatedGetter(
      intValue = 1020011811
   )
   static int field1118;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = 188863173
   )
   static int field990;
   @ObfuscatedName("lk")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("pn")
   static boolean[] field1005;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = -840617907
   )
   static int field1160;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -206012461
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "[Lbg;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("py")
   static int[] field1132;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -419037915
   )
   static int field973;
   @ObfuscatedName("pb")
   static int[] field1048;
   @ObfuscatedName("pd")
   static int[] field1053;
   @ObfuscatedName("pv")
   static int[] field1093;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 90539393
   )
   static int field1035;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = 2127828749
   )
   static int field1087;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = 98838137
   )
   static int field959;
   @ObfuscatedName("qs")
   @ObfuscatedSignature(
      signature = "[Lw;"
   )
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("hd")
   static boolean field1139;
   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = -225444349
   )
   static int field927;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 218413045
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = -1403023273
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 2123031869
   )
   static int field1119;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = 1608235981
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "[[[Lgs;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("ml")
   @ObfuscatedGetter(
      intValue = -1944498309
   )
   static int field1077;
   @ObfuscatedName("km")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static Widget field895;
   @ObfuscatedName("ft")
   static int[][][] field956;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = 1547330345
   )
   static int field1133;
   @ObfuscatedName("nw")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("nl")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("fj")
   static final int[] field957;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      longValue = 956988060883692911L
   )
   static long field1108;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = 1876867167
   )
   static int field1112;
   @ObfuscatedName("ks")
   static boolean field1052;
   @ObfuscatedName("nz")
   static int[] field1113;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -66830347
   )
   static int field909;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 318942659
   )
   static int field977;
   @ObfuscatedName("ox")
   static int[] field1114;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 91209861
   )
   static int field962;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = -1228980109
   )
   static int field1144;
   @ObfuscatedName("oe")
   @ObfuscatedSignature(
      signature = "[Lji;"
   )
   static SpritePixels[] field1127;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = 2071428125
   )
   static int field1125;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -847518673
   )
   static int field1076;
   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = 813895431
   )
   static int field1101;
   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("hg")
   static int[][] field986;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = 1944294055
   )
   static int field1111;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -1816226251
   )
   static int field961;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -1865259829
   )
   static int field1006;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = -889605979
   )
   static int field1072;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = -937910575
   )
   static int field1145;
   @ObfuscatedName("gt")
   static boolean field963;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = -517193227
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = -1152174927
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 216650203
   )
   static int field964;
   @ObfuscatedName("pi")
   static short field1000;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = -1826816867
   )
   static int field1045;
   @ObfuscatedName("ps")
   static short field1070;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -831380951
   )
   static int field1046;
   @ObfuscatedName("mg")
   @ObfuscatedGetter(
      intValue = -1680029033
   )
   static int field893;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = -1579518583
   )
   static int field992;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = -760450907
   )
   static int field1124;
   @ObfuscatedName("nm")
   static long[] field1103;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 1682536221
   )
   static int field968;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = 1447809669
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("lc")
   static int[] field1142;
   @ObfuscatedName("od")
   static int[] field1089;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -243706975
   )
   static int field1080;
   @ObfuscatedName("ph")
   static short field1137;
   @ObfuscatedName("qr")
   @ObfuscatedSignature(
      signature = "[Lbr;"
   )
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = -532056321
   )
   static int field1074;
   @ObfuscatedName("il")
   static int[] field1007;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -146341883
   )
   static int field1051;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 1865121297
   )
   static int field970;
   @ObfuscatedName("qh")
   static short field1143;
   @ObfuscatedName("og")
   static int[] field917;
   @ObfuscatedName("ok")
   static int[] field1105;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = 172215695
   )
   static int field991;
   @ObfuscatedName("pg")
   static short field1141;
   @ObfuscatedName("pe")
   static short field1138;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = -130503839
   )
   static int field1002;
   @ObfuscatedName("pu")
   static short field1017;
   @ObfuscatedName("pt")
   static short field1140;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 908409215
   )
   static int field907;
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = -773045897
   )
   static int field1104;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = 2115749563
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("pw")
   @ObfuscatedSignature(
      signature = "[Ldi;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("qq")
   @ObfuscatedSignature(
      signature = "[Lbm;"
   )
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -1759008719
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("or")
   static int[] field1128;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = 699126907
   )
   static int field975;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = -1506831701
   )
   static int field976;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = -922758383
   )
   static int field934;
   @ObfuscatedName("iw")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("hy")
   static int[] field978;
   @ObfuscatedName("iq")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("hf")
   static int[] field979;
   @ObfuscatedName("ho")
   static int[] field903;
   @ObfuscatedName("hx")
   static int[] field981;
   @ObfuscatedName("hn")
   static int[] field982;
   @ObfuscatedName("hi")
   static int[] field983;
   @ObfuscatedName("hq")
   static int[] field984;
   @ObfuscatedName("hh")
   static String[] field985;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = 1207844499
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 1505859055
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = 2109875043
   )
   static int field1033;
   @ObfuscatedName("ic")
   static int[] field1135;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -325908289
   )
   @Export(
      value = "chatCycle",
      setter = true
   )
   static int chatCycle;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = 808533905
   )
   static int field999;
   @ObfuscatedName("ns")
   static int[] field1107;
   @ObfuscatedName("me")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static Deque field974;
   @ObfuscatedName("nd")
   static String field1102;
   @ObfuscatedName("nu")
   static int[] field1106;
   @ObfuscatedName("mr")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static Deque field926;
   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   static class195 field1152;
   @ObfuscatedName("ia")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("nh")
   static int[] field1099;
   @ObfuscatedName("kc")
   static boolean field969;
   @ObfuscatedName("je")
   static boolean field1030;
   @ObfuscatedName("jr")
   static boolean field1031;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = -206202779
   )
   static int field1039;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -246941433
   )
   static int field1040;
   public static boolean RUNELITE_PACKET;

   static {
      field958 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field900 = true;
      gameCycle = 0;
      field1024 = -1L;
      field967 = -1;
      field987 = -1;
      field905 = -1;
      field916 = true;
      displayFps = false;
      field908 = 0;
      field1115 = 0;
      field910 = 0;
      field911 = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowType = 0;
      field915 = 0;
      field1009 = 0;
      field1117 = class91.field1393;
      field918 = class91.field1393;
      loadingStage = 0;
      js5State = 0;
      field922 = 0;
      field925 = 0;
      loginState = 0;
      field1058 = 0;
      field928 = 0;
      field929 = 0;
      field930 = null;
      cachedNPCs = new NPC['耀'];
      field932 = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      secretPacketBuffer1 = new PacketBuffer(5000);
      field937 = new PacketBuffer(5000);
      secretPacketBuffer2 = new PacketBuffer(15000);
      packetLength = 0;
      packetType = 0;
      field941 = 0;
      audioEffectCount = 0;
      lastFrameId = 0;
      secondLastFrameId = 0;
      thridLastFrameId = 0;
      field946 = 0;
      socketError = false;
      field948 = new HashMap();
      field949 = 0;
      field950 = 1;
      field951 = 0;
      field952 = 1;
      field953 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field956 = new int[4][13][13];
      field957 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field1078 = 0;
      field959 = 2301979;
      field909 = 5063219;
      field961 = 3353893;
      field962 = 7759444;
      field963 = false;
      field964 = 0;
      field977 = 128;
      mapAngle = 0;
      field968 = 0;
      field1080 = 0;
      field970 = 0;
      field991 = 0;
      field907 = 50;
      field973 = 0;
      field1139 = false;
      field975 = 0;
      field976 = 0;
      field934 = 50;
      field978 = new int[field934];
      field979 = new int[field934];
      field903 = new int[field934];
      field981 = new int[field934];
      field982 = new int[field934];
      field983 = new int[field934];
      field984 = new int[field934];
      field985 = new String[field934];
      field986 = new int[104][104];
      field1038 = 0;
      screenY = -1;
      screenX = -1;
      field1056 = 0;
      field1084 = 0;
      field1134 = 0;
      cursorState = 0;
      field994 = 0;
      field995 = 0;
      field996 = 0;
      field997 = 0;
      field998 = 0;
      field999 = 0;
      field923 = false;
      field1047 = 0;
      field1002 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field1101 = 0;
      field1006 = 0;
      field1007 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field1135 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field927 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field1020 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field1013 = new boolean[500];
      field1030 = false;
      field1031 = false;
      field1032 = -1;
      field966 = -1;
      field1087 = 0;
      field1035 = 50;
      itemSelectionState = 0;
      field1037 = null;
      spellSelected = false;
      field1039 = -1;
      field1040 = -1;
      field972 = null;
      field1042 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field1045 = 0;
      field1046 = 0;
      field895 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1051 = -1;
      field1052 = false;
      field1120 = false;
      field969 = false;
      field1055 = null;
      field912 = null;
      field1057 = null;
      field1073 = 0;
      field1063 = 0;
      field1060 = null;
      field1061 = false;
      field1062 = -1;
      field943 = -1;
      field1064 = false;
      field1065 = -1;
      field942 = -1;
      field1067 = false;
      cycleCntr = 1;
      field1079 = new int[32];
      field990 = 0;
      interfaceItemTriggers = new int[32];
      field1160 = 0;
      field1142 = new int[32];
      field1074 = 0;
      chatCycle = 0;
      field1076 = 0;
      field1077 = 0;
      field1133 = 0;
      field992 = 0;
      field893 = 0;
      field1081 = 0;
      field1082 = new Deque();
      field974 = new Deque();
      field926 = new Deque();
      widgetFlags = new XHashTable(512);
      field1086 = 0;
      field906 = -2;
      field1088 = new boolean[100];
      field971 = new boolean[100];
      field1090 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field955 = 0L;
      isResized = true;
      field1099 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field1100 = 0;
      field1044 = 0;
      field1102 = "";
      field1103 = new long[100];
      field1104 = 0;
      field1033 = 0;
      field1106 = new int[128];
      field1107 = new int[128];
      field1108 = -1L;
      clanChatOwner = null;
      clanChatName = null;
      field1111 = -1;
      field1112 = 0;
      field1113 = new int[1000];
      field1114 = new int[1000];
      field1127 = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1118 = 0;
      field1119 = 255;
      field1069 = -1;
      field1121 = false;
      field1125 = 127;
      field1123 = 127;
      field1124 = 0;
      field1089 = new int[50];
      field917 = new int[50];
      field1105 = new int[50];
      field1128 = new int[50];
      audioEffects = new SoundEffect[50];
      field1130 = false;
      field1005 = new boolean[5];
      field1132 = new int[5];
      field1048 = new int[5];
      field1053 = new int[5];
      field1093 = new int[5];
      field1070 = 256;
      field1000 = 205;
      field1138 = 256;
      field1017 = 320;
      field1140 = 1;
      field1141 = 32767;
      field1137 = 1;
      field1143 = 32767;
      field1072 = 0;
      field1145 = 0;
      viewportHeight = 0;
      viewportWidth = 0;
      scale = 0;
      friendCount = 0;
      field1144 = 0;
      friends = new Friend[400];
      field1152 = new class195();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1155 = new PlayerComposition();
      field1156 = -1;
      field1157 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field1159 = new class73();
      field919 = new int[50];
      field1161 = new int[50];
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1934166363"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         boolean var1 = class95.method1777();
         if(!var1) {
            this.method1433();
         }

      }
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1795472539"
   )
   void method1485() {
      int var1 = class31.canvasWidth;
      int var2 = class67.canvasHeight;
      if(super.field674 < var1) {
         var1 = super.field674;
      }

      if(super.field675 < var2) {
         var2 = super.field675;
      }

      if(class170.preferences != null) {
         try {
            Client var3 = Projectile.clientInstance;
            Object[] var4 = new Object[]{Integer.valueOf(class10.method52())};
            JSObject.getWindow(var3).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1937508617"
   )
   protected final void vmethod1179() {
      if(class51.chatMessages.changed()) {
         class51.chatMessages.serialize();
      }

      if(class88.field1364 != null) {
         class88.field1364.field836 = false;
      }

      class88.field1364 = null;
      if(CacheFile.rssocket != null) {
         CacheFile.rssocket.close();
         CacheFile.rssocket = null;
      }

      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var1 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

      if(MouseInput.mouse != null) {
         MouseInput var8 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

      class205.field2536 = null;
      if(class13.soundSystem0 != null) {
         class13.soundSystem0.method2080();
      }

      if(Renderable.soundSystem1 != null) {
         Renderable.soundSystem1.method2080();
      }

      BuildType.method4101();
      class229.method4094();

      try {
         class155.field2224.method1893();

         for(int var4 = 0; var4 < class155.field2218; ++var4) {
            class155.field2226[var4].method1893();
         }

         class155.field2228.method1893();
         class155.field2223.method1893();
      } catch (Exception var7) {
         ;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2088527207"
   )
   protected final void vmethod1176() {
      class229.field3149 = socketType == 0?'ꩊ':world + '鱀';
      class11.field254 = socketType == 0?443:world + '썐';
      class56.myWorldPort = class229.field3149;
      NPC.colorsToFind = class214.field2609;
      SceneTilePaint.colorsToReplace = class214.field2610;
      PlayerComposition.field2602 = class214.field2611;
      class5.field33 = class214.field2613;
      this.method859();
      this.method996();
      class205.field2536 = this.method986();
      WorldMapType1.field406 = new IndexFile(255, class155.field2224, class155.field2228, 500000);
      class170.preferences = class21.method148();
      this.method899();
      String var2 = class47.field567;
      class56.field653 = this;
      class56.field651 = var2;
      if(socketType != 0) {
         displayFps = true;
      }

      class15.method93(class170.preferences.screenType);
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-451624377"
   )
   final void method1190(boolean var1) {
      int var2 = widgetRoot;
      int var3 = class31.canvasWidth;
      int var4 = class67.canvasHeight;
      if(class7.loadWidget(var2)) {
         class46.method686(class170.widgets[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "1998"
   )
   @Export("error")
   void error(int var1) {
      class48.socket = null;
      class2.rssocket = null;
      js5State = 0;
      if(class229.field3149 == class56.myWorldPort) {
         class56.myWorldPort = class11.field254;
      } else {
         class56.myWorldPort = class229.field3149;
      }

      ++field925;
      if(field925 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field922 = 3000;
         }
      } else if(field925 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field925 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field922 = 3000;
         }
      }

   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-785518795"
   )
   final boolean method1415() {
      int var1 = menuOptionCount - 1;
      return menuOptionCount > 2 && (field1020 == 1 && !field1013[var1] || XGrandExchangeOffer.method111(var1));
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "26"
   )
   protected final void vmethod1174() {
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2024349359"
   )
   final void method1315(int var1, int var2) {
      int var3 = class43.field544.method4820("Choose Option");

      int var4;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         Font var5 = class43.field544;
         String var6;
         if(var4 < 0) {
            var6 = "";
         } else if(menuTargets[var4].length() > 0) {
            var6 = menuOptions[var4] + " " + menuTargets[var4];
         } else {
            var6 = menuOptions[var4];
         }

         int var7 = var5.method4820(var6);
         if(var7 > var3) {
            var3 = var7;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      int var8 = var1 - var3 / 2;
      if(var8 + var3 > class31.canvasWidth) {
         var8 = class31.canvasWidth - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var9 = var2;
      if(var2 + var4 > class67.canvasHeight) {
         var9 = class67.canvasHeight - var4;
      }

      if(var9 < 0) {
         var9 = 0;
      }

      class51.region.method2723(class8.plane, var1, var2, false);
      isMenuOpen = true;
      class14.menuX = var8;
      DynamicObject.menuY = var9;
      class12.menuWidth = var3;
      class14.menuHeight = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-905267502"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();

      while(true) {
         Deque var2 = class236.field3220;
         FileSystem var1;
         synchronized(class236.field3220) {
            var1 = (FileSystem)class236.field3214.popFront();
         }

         if(var1 == null) {
            class22.method162();
            class134.method2601();
            KeyFocusListener var61 = KeyFocusListener.keyboard;
            int var45;
            synchronized(KeyFocusListener.keyboard) {
               ++KeyFocusListener.keyboardIdleTicks;
               KeyFocusListener.field612 = KeyFocusListener.field614;
               KeyFocusListener.field611 = 0;
               if(KeyFocusListener.field607 >= 0) {
                  while(KeyFocusListener.field607 != KeyFocusListener.field606) {
                     var45 = KeyFocusListener.field605[KeyFocusListener.field606];
                     KeyFocusListener.field606 = KeyFocusListener.field606 + 1 & 127;
                     if(var45 < 0) {
                        KeyFocusListener.field604[~var45] = false;
                     } else {
                        if(!KeyFocusListener.field604[var45] && KeyFocusListener.field611 < KeyFocusListener.field617.length - 1) {
                           KeyFocusListener.field617[++KeyFocusListener.field611 - 1] = var45;
                        }

                        KeyFocusListener.field604[var45] = true;
                     }
                  }
               } else {
                  for(var45 = 0; var45 < 112; ++var45) {
                     KeyFocusListener.field604[var45] = false;
                  }

                  KeyFocusListener.field607 = KeyFocusListener.field606;
               }

               if(KeyFocusListener.field611 > 0) {
                  KeyFocusListener.keyboardIdleTicks = 0;
               }

               KeyFocusListener.field614 = KeyFocusListener.field597;
            }

            NPCComposition.method4657();
            if(class205.field2536 != null) {
               int var46 = class205.field2536.vmethod2993();
               field1081 = var46;
            }

            if(gameState == 0) {
               class182.load();
               class203.method3705();
            } else if(gameState == 5) {
               WorldMapType2.method542(this);
               class182.load();
               class203.method3705();
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  WorldMapType2.method542(this);
                  this.method1516();
               } else if(gameState == 25) {
                  WallObject.flush(false);
                  field949 = 0;
                  boolean var70 = true;

                  for(var45 = 0; var45 < SoundTask.field1651.length; ++var45) {
                     if(class27.field373[var45] != -1 && SoundTask.field1651[var45] == null) {
                        SoundTask.field1651[var45] = indexMaps.getConfigData(class27.field373[var45], 0);
                        if(SoundTask.field1651[var45] == null) {
                           var70 = false;
                           ++field949;
                        }
                     }

                     if(class12.landRegionFielIds[var45] != -1 && CombatInfo1.field1250[var45] == null) {
                        CombatInfo1.field1250[var45] = indexMaps.getConfigData(class12.landRegionFielIds[var45], 0, class41.xteaKeys[var45]);
                        if(CombatInfo1.field1250[var45] == null) {
                           var70 = false;
                           ++field949;
                        }
                     }
                  }

                  if(!var70) {
                     field953 = 1;
                  } else {
                     field951 = 0;
                     var70 = true;

                     int var4;
                     int var5;
                     for(var45 = 0; var45 < SoundTask.field1651.length; ++var45) {
                        byte[] var3 = CombatInfo1.field1250[var45];
                        if(var3 != null) {
                           var4 = (Buffer.mapRegions[var45] >> 8) * 64 - class33.baseX;
                           var5 = (Buffer.mapRegions[var45] & 255) * 64 - class17.baseY;
                           if(isDynamicRegion) {
                              var4 = 10;
                              var5 = 10;
                           }

                           var70 &= class215.method3999(var3, var4, var5);
                        }
                     }

                     if(!var70) {
                        field953 = 2;
                     } else {
                        if(field953 != 0) {
                           ScriptVarType.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        class134.method2601();
                        class92.method1760();
                        class134.method2601();
                        class51.region.reset();
                        class134.method2601();
                        System.gc();

                        for(var45 = 0; var45 < 4; ++var45) {
                           collisionMaps[var45].reset();
                        }

                        int var47;
                        for(var45 = 0; var45 < 4; ++var45) {
                           for(var47 = 0; var47 < 104; ++var47) {
                              for(var4 = 0; var4 < 104; ++var4) {
                                 class62.tileSettings[var45][var47][var4] = 0;
                              }
                           }
                        }

                        class134.method2601();
                        GameEngine.method1007();
                        var45 = SoundTask.field1651.length;

                        for(class82 var62 = (class82)class82.field1286.getFront(); var62 != null; var62 = (class82)class82.field1286.getNext()) {
                           if(var62.field1291 != null) {
                              class2.field18.method1938(var62.field1291);
                              var62.field1291 = null;
                           }

                           if(var62.field1296 != null) {
                              class2.field18.method1938(var62.field1296);
                              var62.field1296 = null;
                           }
                        }

                        class82.field1286.clear();
                        WallObject.flush(true);
                        int var7;
                        int var8;
                        int var10;
                        int var11;
                        int var12;
                        int var13;
                        int var15;
                        int var16;
                        int var17;
                        int var18;
                        int var20;
                        int var21;
                        int var22;
                        int var49;
                        int var54;
                        int var55;
                        if(!isDynamicRegion) {
                           var47 = 0;

                           label1333:
                           while(true) {
                              byte[] var6;
                              if(var47 >= var45) {
                                 for(var47 = 0; var47 < var45; ++var47) {
                                    var4 = (Buffer.mapRegions[var47] >> 8) * 64 - class33.baseX;
                                    var5 = (Buffer.mapRegions[var47] & 255) * 64 - class17.baseY;
                                    var6 = SoundTask.field1651[var47];
                                    if(var6 == null && class73.field854 < 800) {
                                       class134.method2601();
                                       class12.method67(var4, var5, 64, 64);
                                    }
                                 }

                                 WallObject.flush(true);
                                 var47 = 0;

                                 while(true) {
                                    if(var47 >= var45) {
                                       break label1333;
                                    }

                                    byte[] var48 = CombatInfo1.field1250[var47];
                                    if(var48 != null) {
                                       var5 = (Buffer.mapRegions[var47] >> 8) * 64 - class33.baseX;
                                       var49 = (Buffer.mapRegions[var47] & 255) * 64 - class17.baseY;
                                       class134.method2601();
                                       Region var50 = class51.region;
                                       CollisionData[] var51 = collisionMaps;
                                       Buffer var65 = new Buffer(var48);
                                       var10 = -1;

                                       while(true) {
                                          var11 = var65.getUSmart();
                                          if(var11 == 0) {
                                             break;
                                          }

                                          var10 += var11;
                                          var12 = 0;

                                          while(true) {
                                             var13 = var65.getUSmart();
                                             if(var13 == 0) {
                                                break;
                                             }

                                             var12 += var13 - 1;
                                             var54 = var12 & 63;
                                             var15 = var12 >> 6 & 63;
                                             var16 = var12 >> 12;
                                             var17 = var65.readUnsignedByte();
                                             var18 = var17 >> 2;
                                             var55 = var17 & 3;
                                             var20 = var5 + var15;
                                             var21 = var49 + var54;
                                             if(var20 > 0 && var21 > 0 && var20 < 103 && var21 < 103) {
                                                var22 = var16;
                                                if((class62.tileSettings[1][var20][var21] & 2) == 2) {
                                                   var22 = var16 - 1;
                                                }

                                                CollisionData var23 = null;
                                                if(var22 >= 0) {
                                                   var23 = var51[var22];
                                                }

                                                class56.addObject(var16, var20, var21, var10, var55, var18, var50, var23);
                                             }
                                          }
                                       }
                                    }

                                    ++var47;
                                 }
                              }

                              var4 = (Buffer.mapRegions[var47] >> 8) * 64 - class33.baseX;
                              var5 = (Buffer.mapRegions[var47] & 255) * 64 - class17.baseY;
                              var6 = SoundTask.field1651[var47];
                              if(var6 != null) {
                                 class134.method2601();
                                 var7 = class35.field474 * 8 - 48;
                                 var8 = class73.field854 * 8 - 48;
                                 CollisionData[] var9 = collisionMaps;
                                 var10 = 0;

                                 label1330:
                                 while(true) {
                                    if(var10 >= 4) {
                                       Buffer var52 = new Buffer(var6);
                                       var11 = 0;

                                       while(true) {
                                          if(var11 >= 4) {
                                             break label1330;
                                          }

                                          for(var12 = 0; var12 < 64; ++var12) {
                                             for(var13 = 0; var13 < 64; ++var13) {
                                                class35.loadTerrain(var52, var11, var4 + var12, var5 + var13, var7, var8, 0);
                                             }
                                          }

                                          ++var11;
                                       }
                                    }

                                    for(var11 = 0; var11 < 64; ++var11) {
                                       for(var12 = 0; var12 < 64; ++var12) {
                                          if(var4 + var11 > 0 && var11 + var4 < 103 && var12 + var5 > 0 && var12 + var5 < 103) {
                                             var9[var10].flags[var11 + var4][var12 + var5] &= -16777217;
                                          }
                                       }
                                    }

                                    ++var10;
                                 }
                              }

                              ++var47;
                           }
                        }

                        int var53;
                        int var57;
                        if(isDynamicRegion) {
                           var47 = 0;

                           label1266:
                           while(true) {
                              if(var47 >= 4) {
                                 for(var47 = 0; var47 < 13; ++var47) {
                                    for(var4 = 0; var4 < 13; ++var4) {
                                       var5 = field956[0][var47][var4];
                                       if(var5 == -1) {
                                          class12.method67(var47 * 8, var4 * 8, 8, 8);
                                       }
                                    }
                                 }

                                 WallObject.flush(true);
                                 var47 = 0;

                                 while(true) {
                                    if(var47 >= 4) {
                                       break label1266;
                                    }

                                    class134.method2601();

                                    for(var4 = 0; var4 < 13; ++var4) {
                                       for(var5 = 0; var5 < 13; ++var5) {
                                          var49 = field956[var47][var4][var5];
                                          if(var49 != -1) {
                                             var7 = var49 >> 24 & 3;
                                             var8 = var49 >> 1 & 3;
                                             var53 = var49 >> 14 & 1023;
                                             var10 = var49 >> 3 & 2047;
                                             var11 = (var53 / 8 << 8) + var10 / 8;

                                             for(var12 = 0; var12 < Buffer.mapRegions.length; ++var12) {
                                                if(Buffer.mapRegions[var12] == var11 && CombatInfo1.field1250[var12] != null) {
                                                   class169.method3164(CombatInfo1.field1250[var12], var47, var4 * 8, var5 * 8, var7, (var53 & 7) * 8, (var10 & 7) * 8, var8, class51.region, collisionMaps);
                                                   break;
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++var47;
                                 }
                              }

                              class134.method2601();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    boolean var72 = false;
                                    var7 = field956[var47][var4][var5];
                                    if(var7 != -1) {
                                       var8 = var7 >> 24 & 3;
                                       var53 = var7 >> 1 & 3;
                                       var10 = var7 >> 14 & 1023;
                                       var11 = var7 >> 3 & 2047;
                                       var12 = (var10 / 8 << 8) + var11 / 8;

                                       for(var13 = 0; var13 < Buffer.mapRegions.length; ++var13) {
                                          if(Buffer.mapRegions[var13] == var12 && SoundTask.field1651[var13] != null) {
                                             byte[] var14 = SoundTask.field1651[var13];
                                             var15 = var4 * 8;
                                             var16 = var5 * 8;
                                             var17 = (var10 & 7) * 8;
                                             var18 = (var11 & 7) * 8;
                                             CollisionData[] var19 = collisionMaps;

                                             for(var20 = 0; var20 < 8; ++var20) {
                                                for(var21 = 0; var21 < 8; ++var21) {
                                                   if(var20 + var15 > 0 && var15 + var20 < 103 && var21 + var16 > 0 && var16 + var21 < 103) {
                                                      var19[var47].flags[var15 + var20][var16 + var21] &= -16777217;
                                                   }
                                                }
                                             }

                                             Buffer var56 = new Buffer(var14);

                                             for(var21 = 0; var21 < 4; ++var21) {
                                                for(var22 = 0; var22 < 64; ++var22) {
                                                   for(var57 = 0; var57 < 64; ++var57) {
                                                      if(var8 == var21 && var22 >= var17 && var22 < var17 + 8 && var57 >= var18 && var57 < var18 + 8) {
                                                         class35.loadTerrain(var56, var47, var15 + PacketBuffer.method3457(var22 & 7, var57 & 7, var53), var16 + ISAACCipher.method3473(var22 & 7, var57 & 7, var53), 0, 0, var53);
                                                      } else {
                                                         class35.loadTerrain(var56, 0, -1, -1, 0, 0, 0);
                                                      }
                                                   }
                                                }
                                             }

                                             var72 = true;
                                             break;
                                          }
                                       }
                                    }

                                    if(!var72) {
                                       class46.method704(var47, var4 * 8, var5 * 8);
                                    }
                                 }
                              }

                              ++var47;
                           }
                        }

                        WallObject.flush(true);
                        class92.method1760();
                        class134.method2601();
                        Region var63 = class51.region;
                        CollisionData[] var71 = collisionMaps;

                        for(var5 = 0; var5 < 4; ++var5) {
                           for(var49 = 0; var49 < 104; ++var49) {
                              for(var7 = 0; var7 < 104; ++var7) {
                                 if((class62.tileSettings[var5][var49][var7] & 1) == 1) {
                                    var8 = var5;
                                    if((class62.tileSettings[1][var49][var7] & 2) == 2) {
                                       var8 = var5 - 1;
                                    }

                                    if(var8 >= 0) {
                                       var71[var8].method3060(var49, var7);
                                    }
                                 }
                              }
                           }
                        }

                        class62.field744 += (int)(Math.random() * 5.0D) - 2;
                        if(class62.field744 < -8) {
                           class62.field744 = -8;
                        }

                        if(class62.field744 > 8) {
                           class62.field744 = 8;
                        }

                        class62.field750 += (int)(Math.random() * 5.0D) - 2;
                        if(class62.field750 < -16) {
                           class62.field750 = -16;
                        }

                        if(class62.field750 > 16) {
                           class62.field750 = 16;
                        }

                        for(var5 = 0; var5 < 4; ++var5) {
                           byte[][] var64 = class62.field739[var5];
                           var12 = (int)Math.sqrt(5100.0D);
                           var13 = var12 * 768 >> 8;

                           for(var54 = 1; var54 < 103; ++var54) {
                              for(var15 = 1; var15 < 103; ++var15) {
                                 var16 = class62.tileHeights[var5][var15 + 1][var54] - class62.tileHeights[var5][var15 - 1][var54];
                                 var17 = class62.tileHeights[var5][var15][var54 + 1] - class62.tileHeights[var5][var15][var54 - 1];
                                 var18 = (int)Math.sqrt((double)(var16 * var16 + var17 * var17 + 65536));
                                 var55 = (var16 << 8) / var18;
                                 var20 = 65536 / var18;
                                 var21 = (var17 << 8) / var18;
                                 var22 = (var55 * -50 + var21 * -50 + var20 * -10) / var13 + 96;
                                 var57 = (var64[var15][var54] >> 1) + (var64[var15][var54 - 1] >> 2) + (var64[var15 - 1][var54] >> 2) + (var64[var15 + 1][var54] >> 3) + (var64[var15][var54 + 1] >> 3);
                                 class62.field740[var15][var54] = var22 - var57;
                              }
                           }

                           for(var54 = 0; var54 < 104; ++var54) {
                              class62.blendedHue[var54] = 0;
                              class48.blendedSaturation[var54] = 0;
                              Friend.field779[var54] = 0;
                              class118.field1673[var54] = 0;
                              class54.field641[var54] = 0;
                           }

                           for(var54 = -5; var54 < 109; ++var54) {
                              for(var15 = 0; var15 < 104; ++var15) {
                                 var16 = var54 + 5;
                                 if(var16 >= 0 && var16 < 104) {
                                    var17 = class62.underlayIds[var5][var16][var15] & 255;
                                    if(var17 > 0) {
                                       FloorUnderlayDefinition var58 = class169.method3168(var17 - 1);
                                       class62.blendedHue[var15] += var58.hue;
                                       class48.blendedSaturation[var15] += var58.saturation;
                                       Friend.field779[var15] += var58.lightness;
                                       class118.field1673[var15] += var58.hueMultiplier;
                                       ++class54.field641[var15];
                                    }
                                 }

                                 var17 = var54 - 5;
                                 if(var17 >= 0 && var17 < 104) {
                                    var18 = class62.underlayIds[var5][var17][var15] & 255;
                                    if(var18 > 0) {
                                       FloorUnderlayDefinition var66 = class169.method3168(var18 - 1);
                                       class62.blendedHue[var15] -= var66.hue;
                                       class48.blendedSaturation[var15] -= var66.saturation;
                                       Friend.field779[var15] -= var66.lightness;
                                       class118.field1673[var15] -= var66.hueMultiplier;
                                       --class54.field641[var15];
                                    }
                                 }
                              }

                              if(var54 >= 1 && var54 < 103) {
                                 var15 = 0;
                                 var16 = 0;
                                 var17 = 0;
                                 var18 = 0;
                                 var55 = 0;

                                 for(var20 = -5; var20 < 109; ++var20) {
                                    var21 = var20 + 5;
                                    if(var21 >= 0 && var21 < 104) {
                                       var15 += class62.blendedHue[var21];
                                       var16 += class48.blendedSaturation[var21];
                                       var17 += Friend.field779[var21];
                                       var18 += class118.field1673[var21];
                                       var55 += class54.field641[var21];
                                    }

                                    var22 = var20 - 5;
                                    if(var22 >= 0 && var22 < 104) {
                                       var15 -= class62.blendedHue[var22];
                                       var16 -= class48.blendedSaturation[var22];
                                       var17 -= Friend.field779[var22];
                                       var18 -= class118.field1673[var22];
                                       var55 -= class54.field641[var22];
                                    }

                                    if(var20 >= 1 && var20 < 103 && (!lowMemory || (class62.tileSettings[0][var54][var20] & 2) != 0 || (class62.tileSettings[var5][var54][var20] & 16) == 0)) {
                                       if(var5 < class62.field735) {
                                          class62.field735 = var5;
                                       }

                                       var57 = class62.underlayIds[var5][var54][var20] & 255;
                                       int var24 = class62.overlayIds[var5][var54][var20] & 255;
                                       if(var57 > 0 || var24 > 0) {
                                          int var25 = class62.tileHeights[var5][var54][var20];
                                          int var26 = class62.tileHeights[var5][var54 + 1][var20];
                                          int var27 = class62.tileHeights[var5][var54 + 1][var20 + 1];
                                          int var28 = class62.tileHeights[var5][var54][var20 + 1];
                                          int var29 = class62.field740[var54][var20];
                                          int var30 = class62.field740[var54 + 1][var20];
                                          int var31 = class62.field740[var54 + 1][var20 + 1];
                                          int var32 = class62.field740[var54][var20 + 1];
                                          int var33 = -1;
                                          int var34 = -1;
                                          int var35;
                                          int var36;
                                          if(var57 > 0) {
                                             var35 = var15 * 256 / var18;
                                             var36 = var16 / var55;
                                             int var37 = var17 / var55;
                                             var33 = class244.method4299(var35, var36, var37);
                                             var35 = var35 + class62.field744 & 255;
                                             var37 += class62.field750;
                                             if(var37 < 0) {
                                                var37 = 0;
                                             } else if(var37 > 255) {
                                                var37 = 255;
                                             }

                                             var34 = class244.method4299(var35, var36, var37);
                                          }

                                          if(var5 > 0) {
                                             boolean var68 = true;
                                             if(var57 == 0 && FileSystem.overlayPaths[var5][var54][var20] != 0) {
                                                var68 = false;
                                             }

                                             if(var24 > 0 && !class219.method4073(var24 - 1).isHidden) {
                                                var68 = false;
                                             }

                                             if(var68 && var26 == var25 && var27 == var25 && var28 == var25) {
                                                class62.field742[var5][var54][var20] |= 2340;
                                             }
                                          }

                                          var35 = 0;
                                          if(var34 != -1) {
                                             var35 = Graphics3D.colorPalette[class155.method2990(var34, 96)];
                                          }

                                          if(var24 == 0) {
                                             var63.addTile(var5, var54, var20, 0, 0, -1, var25, var26, var27, var28, class155.method2990(var33, var29), class155.method2990(var33, var30), class155.method2990(var33, var31), class155.method2990(var33, var32), 0, 0, 0, 0, var35, 0);
                                          } else {
                                             var36 = FileSystem.overlayPaths[var5][var54][var20] + 1;
                                             byte var69 = class62.overlayRotations[var5][var54][var20];
                                             Overlay var38 = class219.method4073(var24 - 1);
                                             int var39 = var38.texture;
                                             int var40;
                                             int var41;
                                             int var42;
                                             int var43;
                                             if(var39 >= 0) {
                                                var41 = Graphics3D.textureLoader.getAverageTextureRGB(var39);
                                                var40 = -1;
                                             } else if(var38.color == 16711935) {
                                                var40 = -2;
                                                var39 = -1;
                                                var41 = -2;
                                             } else {
                                                var40 = class244.method4299(var38.hue, var38.saturation, var38.lightness);
                                                var42 = var38.hue + class62.field744 & 255;
                                                var43 = var38.lightness + class62.field750;
                                                if(var43 < 0) {
                                                   var43 = 0;
                                                } else if(var43 > 255) {
                                                   var43 = 255;
                                                }

                                                var41 = class244.method4299(var42, var38.saturation, var43);
                                             }

                                             var42 = 0;
                                             if(var41 != -2) {
                                                var42 = Graphics3D.colorPalette[Ignore.adjustHSLListness0(var41, 96)];
                                             }

                                             if(var38.otherRgbColor != -1) {
                                                var43 = var38.otherHue + class62.field744 & 255;
                                                int var44 = var38.otherLightness + class62.field750;
                                                if(var44 < 0) {
                                                   var44 = 0;
                                                } else if(var44 > 255) {
                                                   var44 = 255;
                                                }

                                                var41 = class244.method4299(var43, var38.otherSaturation, var44);
                                                var42 = Graphics3D.colorPalette[Ignore.adjustHSLListness0(var41, 96)];
                                             }

                                             var63.addTile(var5, var54, var20, var36, var69, var39, var25, var26, var27, var28, class155.method2990(var33, var29), class155.method2990(var33, var30), class155.method2990(var33, var31), class155.method2990(var33, var32), Ignore.adjustHSLListness0(var40, var29), Ignore.adjustHSLListness0(var40, var30), Ignore.adjustHSLListness0(var40, var31), Ignore.adjustHSLListness0(var40, var32), var35, var42);
                                          }
                                       }
                                    }
                                 }
                              }
                           }

                           for(var54 = 1; var54 < 103; ++var54) {
                              for(var15 = 1; var15 < 103; ++var15) {
                                 var63.setPhysicalLevel(var5, var15, var54, class203.method3707(var5, var15, var54));
                              }
                           }

                           class62.underlayIds[var5] = null;
                           class62.overlayIds[var5] = null;
                           FileSystem.overlayPaths[var5] = null;
                           class62.overlayRotations[var5] = null;
                           class62.field739[var5] = null;
                        }

                        var63.applyLighting(-50, -10, -50);

                        for(var5 = 0; var5 < 104; ++var5) {
                           for(var49 = 0; var49 < 104; ++var49) {
                              if((class62.tileSettings[1][var5][var49] & 2) == 2) {
                                 var63.setBridge(var5, var49);
                              }
                           }
                        }

                        var5 = 1;
                        var49 = 2;
                        var7 = 4;

                        for(var8 = 0; var8 < 4; ++var8) {
                           if(var8 > 0) {
                              var5 <<= 3;
                              var49 <<= 3;
                              var7 <<= 3;
                           }

                           for(var53 = 0; var53 <= var8; ++var53) {
                              for(var10 = 0; var10 <= 104; ++var10) {
                                 for(var11 = 0; var11 <= 104; ++var11) {
                                    short var67;
                                    if((class62.field742[var53][var11][var10] & var5) != 0) {
                                       var12 = var10;
                                       var13 = var10;
                                       var54 = var53;

                                       for(var15 = var53; var12 > 0 && (class62.field742[var53][var11][var12 - 1] & var5) != 0; --var12) {
                                          ;
                                       }

                                       while(var13 < 104 && (class62.field742[var53][var11][var13 + 1] & var5) != 0) {
                                          ++var13;
                                       }

                                       label924:
                                       while(var54 > 0) {
                                          for(var16 = var12; var16 <= var13; ++var16) {
                                             if((class62.field742[var54 - 1][var11][var16] & var5) == 0) {
                                                break label924;
                                             }
                                          }

                                          --var54;
                                       }

                                       label913:
                                       while(var15 < var8) {
                                          for(var16 = var12; var16 <= var13; ++var16) {
                                             if((class62.field742[var15 + 1][var11][var16] & var5) == 0) {
                                                break label913;
                                             }
                                          }

                                          ++var15;
                                       }

                                       var16 = (var15 + 1 - var54) * (var13 - var12 + 1);
                                       if(var16 >= 8) {
                                          var67 = 240;
                                          var18 = class62.tileHeights[var15][var11][var12] - var67;
                                          var55 = class62.tileHeights[var54][var11][var12];
                                          Region.addOcclude(var8, 1, var11 * 128, var11 * 128, var12 * 128, var13 * 128 + 128, var18, var55);

                                          for(var20 = var54; var20 <= var15; ++var20) {
                                             for(var21 = var12; var21 <= var13; ++var21) {
                                                class62.field742[var20][var11][var21] &= ~var5;
                                             }
                                          }
                                       }
                                    }

                                    if((class62.field742[var53][var11][var10] & var49) != 0) {
                                       var12 = var11;
                                       var13 = var11;
                                       var54 = var53;

                                       for(var15 = var53; var12 > 0 && (class62.field742[var53][var12 - 1][var10] & var49) != 0; --var12) {
                                          ;
                                       }

                                       while(var13 < 104 && (class62.field742[var53][var13 + 1][var10] & var49) != 0) {
                                          ++var13;
                                       }

                                       label977:
                                       while(var54 > 0) {
                                          for(var16 = var12; var16 <= var13; ++var16) {
                                             if((class62.field742[var54 - 1][var16][var10] & var49) == 0) {
                                                break label977;
                                             }
                                          }

                                          --var54;
                                       }

                                       label966:
                                       while(var15 < var8) {
                                          for(var16 = var12; var16 <= var13; ++var16) {
                                             if((class62.field742[var15 + 1][var16][var10] & var49) == 0) {
                                                break label966;
                                             }
                                          }

                                          ++var15;
                                       }

                                       var16 = (var15 + 1 - var54) * (var13 - var12 + 1);
                                       if(var16 >= 8) {
                                          var67 = 240;
                                          var18 = class62.tileHeights[var15][var12][var10] - var67;
                                          var55 = class62.tileHeights[var54][var12][var10];
                                          Region.addOcclude(var8, 2, var12 * 128, var13 * 128 + 128, var10 * 128, var10 * 128, var18, var55);

                                          for(var20 = var54; var20 <= var15; ++var20) {
                                             for(var21 = var12; var21 <= var13; ++var21) {
                                                class62.field742[var20][var21][var10] &= ~var49;
                                             }
                                          }
                                       }
                                    }

                                    if((class62.field742[var53][var11][var10] & var7) != 0) {
                                       var12 = var11;
                                       var13 = var11;
                                       var54 = var10;

                                       for(var15 = var10; var54 > 0 && (class62.field742[var53][var11][var54 - 1] & var7) != 0; --var54) {
                                          ;
                                       }

                                       while(var15 < 104 && (class62.field742[var53][var11][var15 + 1] & var7) != 0) {
                                          ++var15;
                                       }

                                       label1030:
                                       while(var12 > 0) {
                                          for(var16 = var54; var16 <= var15; ++var16) {
                                             if((class62.field742[var53][var12 - 1][var16] & var7) == 0) {
                                                break label1030;
                                             }
                                          }

                                          --var12;
                                       }

                                       label1019:
                                       while(var13 < 104) {
                                          for(var16 = var54; var16 <= var15; ++var16) {
                                             if((class62.field742[var53][var13 + 1][var16] & var7) == 0) {
                                                break label1019;
                                             }
                                          }

                                          ++var13;
                                       }

                                       if((var13 - var12 + 1) * (var15 - var54 + 1) >= 4) {
                                          var16 = class62.tileHeights[var53][var12][var54];
                                          Region.addOcclude(var8, 4, var12 * 128, 128 + var13 * 128, var54 * 128, var15 * 128 + 128, var16, var16);

                                          for(var17 = var12; var17 <= var13; ++var17) {
                                             for(var18 = var54; var18 <= var15; ++var18) {
                                                class62.field742[var53][var17][var18] &= ~var7;
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        WallObject.flush(true);
                        var5 = class62.field735;
                        if(var5 > class8.plane) {
                           var5 = class8.plane;
                        }

                        if(var5 < class8.plane - 1) {
                           var5 = class8.plane - 1;
                        }

                        if(lowMemory) {
                           class51.region.setup(class62.field735);
                        } else {
                           class51.region.setup(0);
                        }

                        for(var49 = 0; var49 < 104; ++var49) {
                           for(var7 = 0; var7 < 104; ++var7) {
                              class34.groundItemSpawned(var49, var7);
                           }
                        }

                        class134.method2601();
                        class149.method2927();
                        ObjectComposition.field3447.reset();
                        if(Projectile.clientInstance.method888()) {
                           secretPacketBuffer1.putOpcode(52);
                           secretPacketBuffer1.putInt(1057001181);
                        }

                        if(!isDynamicRegion) {
                           var49 = (class35.field474 - 6) / 8;
                           var7 = (class35.field474 + 6) / 8;
                           var8 = (class73.field854 - 6) / 8;
                           var53 = (class73.field854 + 6) / 8;

                           for(var10 = var49 - 1; var10 <= var7 + 1; ++var10) {
                              for(var11 = var8 - 1; var11 <= var53 + 1; ++var11) {
                                 if(var10 < var49 || var10 > var7 || var11 < var8 || var11 > var53) {
                                    indexMaps.method4188("m" + var10 + "_" + var11);
                                    indexMaps.method4188("l" + var10 + "_" + var11);
                                 }
                              }
                           }
                        }

                        class2.setGameState(30);
                        class134.method2601();
                        class62.underlayIds = null;
                        class62.overlayIds = null;
                        FileSystem.overlayPaths = null;
                        class62.overlayRotations = null;
                        class62.field742 = null;
                        class62.field739 = null;
                        class62.field740 = null;
                        class62.blendedHue = null;
                        class48.blendedSaturation = null;
                        Friend.field779 = null;
                        class118.field1673 = null;
                        class54.field641 = null;
                        secretPacketBuffer1.putOpcode(73);
                        class203.method3705();
                     }
                  }
               }
            } else {
               WorldMapType2.method542(this);
            }

            if(gameState == 30) {
               this.method1181();
            } else if(gameState == 40 || gameState == 45) {
               this.method1516();
            }

            return;
         }

         var1.data.method4235(var1.index, (int)var1.hash, var1.field3181, false);
      }
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1844585894"
   )
   @Export("processServerPacket")
   final boolean processServerPacket() {
      if(CacheFile.rssocket == null) {
         return false;
      } else {
         int var3;
         String var20;
         try {
            int var1 = CacheFile.rssocket.available();
            if(var1 == 0) {
               return false;
            }

            if(packetType == -1) {
               CacheFile.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               packetLength = RUNELITE_PACKET?-2:class272.field3688[packetType];
               --var1;
            }

            if(packetLength == -1) {
               if(var1 <= 0) {
                  return false;
               }

               CacheFile.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               packetLength = secretPacketBuffer2.payload[0] & 255;
               --var1;
            }

            if(packetLength == -2) {
               if(var1 <= 1) {
                  return false;
               }

               CacheFile.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();
               var1 -= 2;
            }

            if(var1 < packetLength) {
               return false;
            }

            secretPacketBuffer2.offset = 0;
            CacheFile.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
            field941 = 0;
            thridLastFrameId = secondLastFrameId;
            secondLastFrameId = lastFrameId;
            lastFrameId = packetType;
            int var2;
            if(packetType == (RUNELITE_PACKET?0:166)) {
               field1130 = false;

               for(var2 = 0; var2 < 5; ++var2) {
                  field1005[var2] = false;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?1:118)) {
               field1144 = 1;
               field1076 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?2:141)) {
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

            if(packetType == (RUNELITE_PACKET?3:13)) {
               class261.decodeClassVerifier(secretPacketBuffer2, packetLength);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?4:97)) {
               class40.method554();

               for(var2 = 0; var2 < 2048; ++var2) {
                  cachedPlayers[var2] = null;
               }

               class95.initializeGPI(secretPacketBuffer2);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?5:2)) {
               for(var2 = 0; var2 < class3.field22; ++var2) {
                  VarPlayerType var76 = WorldMapType3.method181(var2);
                  if(var76 != null) {
                     class211.settings[var2] = 0;
                     class211.widgetSettings[var2] = 0;
                  }
               }

               class83.method1680();
               field990 += 32;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?6:179)) {
               class51.method792();
               packetType = -1;
               return false;
            }

            if(packetType == (RUNELITE_PACKET?7:217)) {
               for(var2 = 0; var2 < class211.widgetSettings.length; ++var2) {
                  if(class211.settings[var2] != class211.widgetSettings[var2]) {
                     class211.widgetSettings[var2] = class211.settings[var2];
                     WidgetNode.method1114(var2);
                     field1079[++field990 - 1 & 31] = var2;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?8:211)) {
               KeyFocusListener.method784(secretPacketBuffer2, packetLength);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?9:53)) {
               if(widgetRoot != -1) {
                  class14.method86(widgetRoot, 0);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?10:7)) {
               field1118 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?11:55)) {
               field908 = secretPacketBuffer2.readUnsignedShort() * 30;
               field893 = cycleCntr;
               packetType = -1;
               return true;
            }

            int var5;
            if(packetType == (RUNELITE_PACKET?12:42)) {
               if(RUNELITE_PACKET) {
                  var3 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var3 = secretPacketBuffer2.readUnsignedByte();
               }

               class276[] var93 = class140.method2890();
               var5 = 0;

               class276 var84;
               while(true) {
                  if(var5 >= var93.length) {
                     var84 = null;
                     break;
                  }

                  class276 var88 = var93[var5];
                  if(var3 == var88.field3722) {
                     var84 = var88;
                     break;
                  }

                  ++var5;
               }

               class276.field3721 = var84;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?13:207)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3244();
               }

               XGrandExchangeOffer.field295 = GameEngine.taskManager.createHost(var2);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?14:130)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3236();
               }

               if(var2 == '\uffff') {
                  var2 = -1;
               }

               if(var2 == -1 && !field1121) {
                  class48.method729();
               } else if(var2 != -1 && var2 != field1069 && field1119 != 0 && !field1121) {
                  class40.method556(2, class2.indexTrack1, var2, 0, field1119, false);
               }

               field1069 = var2;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?15:21)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3236();
               }

               XItemContainer var73 = (XItemContainer)XItemContainer.itemContainers.get((long)var2);
               if(var73 != null) {
                  var73.unlink();
               }

               interfaceItemTriggers[++field1160 - 1 & 31] = var2 & 32767;
               packetType = -1;
               return true;
            }

            int var4;
            Widget var71;
            if(packetType == (RUNELITE_PACKET?16:212)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3244();
               }

               var71 = WallObject.method2901(var2);

               for(var4 = 0; var4 < var71.itemIds.length; ++var4) {
                  var71.itemIds[var4] = -1;
                  var71.itemIds[var4] = 0;
               }

               class48.method732(var71);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?17:249)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3244();
               }

               var71 = WallObject.method2901(var2);
               var71.modelType = 3;
               var71.modelId = class224.localPlayer.composition.method3968();
               class48.method732(var71);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?18:27)) {
               class83.method1680();
               weight = secretPacketBuffer2.readShort();
               field893 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?19:71)) {
               class83.method1680();
               energy = secretPacketBuffer2.readUnsignedByte();
               field893 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?20:198)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readInt();
               }

               WidgetNode var69 = (WidgetNode)componentTable.get((long)var2);
               if(var69 != null) {
                  class169.method3163(var69, true);
               }

               if(field895 != null) {
                  class48.method732(field895);
                  field895 = null;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?21:200)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3236();
               }

               widgetRoot = var2;
               this.method1190(false);
               class207.method3891(var2);
               class15.method95(widgetRoot);

               for(var3 = 0; var3 < 100; ++var3) {
                  field1088[var3] = true;
               }

               packetType = -1;
               return true;
            }

            String var19;
            String var83;
            if(packetType == (RUNELITE_PACKET?22:205)) {
               if(RUNELITE_PACKET) {
                  var20 = secretPacketBuffer2.runeliteReadString();
               } else {
                  var20 = secretPacketBuffer2.readString();
               }

               PacketBuffer var92 = secretPacketBuffer2;
               var19 = SceneTilePaint.method2695(var92, 32767);
               var83 = FontTypeFace.appendTags(Sequence.method4712(var19));
               class202.sendGameMessage(6, var20, var83);
               packetType = -1;
               return true;
            }

            int var14;
            String var22;
            long var33;
            int var36;
            int var39;
            int var64;
            String var78;
            if(packetType == (RUNELITE_PACKET?23:92)) {
               if(RUNELITE_PACKET) {
                  var20 = secretPacketBuffer2.runeliteReadString();
               } else {
                  var20 = secretPacketBuffer2.readString();
               }

               WorldMapType3.sessionToken = var20;

               try {
                  var19 = Projectile.clientInstance.getParameter(Parameters.field3711.key);
                  var22 = Projectile.clientInstance.getParameter(Parameters.field3712.key);
                  var83 = var19 + "settings=" + var20 + "; version=1; path=/; domain=" + var22;
                  String var99;
                  if(var20.length() == 0) {
                     var83 = var83 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var78 = var83 + "; Expires=";
                     var33 = BuildType.currentTimeMs() + 94608000000L;
                     class182.field2410.setTime(new Date(var33));
                     var39 = class182.field2410.get(7);
                     var36 = class182.field2410.get(5);
                     var64 = class182.field2410.get(2);
                     int var65 = class182.field2410.get(1);
                     var14 = class182.field2410.get(11);
                     int var102 = class182.field2410.get(12);
                     int var43 = class182.field2410.get(13);
                     var99 = class182.field2409[var39 - 1] + ", " + var36 / 10 + var36 % 10 + "-" + class182.field2414[0][var64] + "-" + var65 + " " + var14 / 10 + var14 % 10 + ":" + var102 / 10 + var102 % 10 + ":" + var43 / 10 + var43 % 10 + " GMT";
                     var83 = var78 + var99 + "; Max-Age=" + 94608000L;
                  }

                  Client var87 = Projectile.clientInstance;
                  var99 = "document.cookie=\"" + var83 + "\"";
                  JSObject.getWindow(var87).eval(var99);
               } catch (Throwable var50) {
                  ;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?24:91)) {
               secretPacketBuffer2.offset += 28;
               if(secretPacketBuffer2.checkCrc()) {
                  class40.method558(secretPacketBuffer2, secretPacketBuffer2.offset - 28);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?25:77)) {
               byte var90;
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var90 = secretPacketBuffer2.runeliteReadByte();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  var90 = secretPacketBuffer2.method3231();
               }

               class211.settings[var2] = var90;
               if(class211.widgetSettings[var2] != var90) {
                  class211.widgetSettings[var2] = var90;
               }

               WidgetNode.method1114(var2);
               field1079[++field990 - 1 & 31] = var2;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?26:105)) {
               field1100 = secretPacketBuffer2.readUnsignedByte();
               field1044 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?27:16)) {
               class24.field343 = secretPacketBuffer2.method3228();
               DecorativeObject.field2152 = secretPacketBuffer2.method3228();
               packetType = -1;
               return true;
            }

            if(packetType != 134 && packetType != 182 && packetType != 3 && packetType != 164 && packetType != 138 && packetType != 170 && packetType != 31 && packetType != 172 && packetType != 132) {
               if(packetType == (RUNELITE_PACKET?28:84)) {
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

               if(packetType == (RUNELITE_PACKET?29:29)) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.read24BitInt();
                     var3 = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(var3 == '\uffff') {
                     var3 = -1;
                  }

                  CombatInfoListHolder.method1687(var3, var2);
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?30:178)) {
                  var2 = secretPacketBuffer2.readUnsignedByte();
                  if(secretPacketBuffer2.readUnsignedByte() == 0) {
                     grandExchangeOffers[var2] = new XGrandExchangeOffer();
                     secretPacketBuffer2.offset += 18;
                  } else {
                     --secretPacketBuffer2.offset;
                     grandExchangeOffers[var2] = new XGrandExchangeOffer(secretPacketBuffer2, false);
                  }

                  field1133 = cycleCntr;
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?31:156)) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readInt();
                     var3 = secretPacketBuffer2.readInt();
                  }

                  var4 = BaseVarType.method11();
                  secretPacketBuffer1.putOpcode(236);
                  secretPacketBuffer1.method3225(var4);
                  secretPacketBuffer1.method3227(GameEngine.FPS);
                  secretPacketBuffer1.putInt(var2);
                  secretPacketBuffer1.putInt(var3);
                  packetType = -1;
                  return true;
               }

               boolean var53;
               Widget var79;
               if(packetType == (RUNELITE_PACKET?32:185)) {
                  var53 = secretPacketBuffer2.readUnsignedByte() == 1;
                  var3 = secretPacketBuffer2.method3243();
                  var79 = WallObject.method2901(var3);
                  if(var53 != var79.isHidden) {
                     var79.isHidden = var53;
                     class48.method732(var79);
                  }

                  packetType = -1;
                  return true;
               }

               int var6;
               int var7;
               if(packetType == (RUNELITE_PACKET?33:52)) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readInt();
                     var3 = secretPacketBuffer2.readUnsignedShort();
                  }

                  var4 = var3 >> 10 & 31;
                  var5 = var3 >> 5 & 31;
                  var6 = var3 & 31;
                  var7 = (var5 << 11) + (var4 << 19) + (var6 << 3);
                  Widget var77 = WallObject.method2901(var2);
                  if(var7 != var77.textColor) {
                     var77.textColor = var7;
                     class48.method732(var77);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?34:126)) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3238();
                     var3 = secretPacketBuffer2.method3244();
                  }

                  var79 = WallObject.method2901(var3);
                  if(var2 != var79.field2676 || var2 == -1) {
                     var79.field2676 = var2;
                     var79.field2751 = 0;
                     var79.field2699 = 0;
                     class48.method732(var79);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?35:107)) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readByteOb1();
                     var3 = secretPacketBuffer2.method3244();
                  }

                  var79 = WallObject.method2901(var3);
                  if(var79.modelType != 2 || var2 != var79.modelId) {
                     var79.modelType = 2;
                     var79.modelId = var2;
                     class48.method732(var79);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?36:67)) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3236();
                     var3 = secretPacketBuffer2.method3244();
                  }

                  var79 = WallObject.method2901(var3);
                  if(var79.modelType != 1 || var2 != var79.modelId) {
                     var79.modelType = 1;
                     var79.modelId = var2;
                     class48.method732(var79);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?37:33)) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3243();
                     var3 = secretPacketBuffer2.readUnsignedShortOb1();
                  }

                  var79 = WallObject.method2901(var2);
                  if(var79 != null && var79.type == 0) {
                     if(var3 > var79.scrollHeight - var79.height) {
                        var3 = var79.scrollHeight - var79.height;
                     }

                     if(var3 < 0) {
                        var3 = 0;
                     }

                     if(var3 != var79.scrollY) {
                        var79.scrollY = var3;
                        class48.method732(var79);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?40:147)) {
                  DecorativeObject.field2152 = secretPacketBuffer2.method3228();
                  class24.field343 = secretPacketBuffer2.method3228();

                  for(var2 = DecorativeObject.field2152; var2 < DecorativeObject.field2152 + 8; ++var2) {
                     for(var3 = class24.field343; var3 < class24.field343 + 8; ++var3) {
                        if(groundItemDeque[class8.plane][var2][var3] != null) {
                           groundItemDeque[class8.plane][var2][var3] = null;
                           class34.groundItemSpawned(var2, var3);
                        }
                     }
                  }

                  for(PendingSpawn var70 = (PendingSpawn)pendingSpawns.getFront(); var70 != null; var70 = (PendingSpawn)pendingSpawns.getNext()) {
                     if(var70.x >= DecorativeObject.field2152 && var70.x < DecorativeObject.field2152 + 8 && var70.y >= class24.field343 && var70.y < class24.field343 + 8 && var70.level == class8.plane) {
                        var70.hitpoints = 0;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?41:208)) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3229();
                     var3 = secretPacketBuffer2.readByteOb1();
                  }

                  class211.settings[var3] = var2;
                  if(class211.widgetSettings[var3] != var2) {
                     class211.widgetSettings[var3] = var2;
                  }

                  WidgetNode.method1114(var3);
                  field1079[++field990 - 1 & 31] = var3;
                  packetType = -1;
                  return true;
               }

               WidgetNode var24;
               Widget var80;
               if(packetType == (RUNELITE_PACKET?42:165)) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3243();
                     var3 = secretPacketBuffer2.method3229();
                  }

                  WidgetNode var91 = (WidgetNode)componentTable.get((long)var3);
                  var24 = (WidgetNode)componentTable.get((long)var2);
                  if(var24 != null) {
                     class169.method3163(var24, var91 == null || var24.id != var91.id);
                  }

                  if(var91 != null) {
                     var91.unlink();
                     componentTable.put(var91, (long)var2);
                  }

                  var80 = WallObject.method2901(var3);
                  if(var80 != null) {
                     class48.method732(var80);
                  }

                  var80 = WallObject.method2901(var2);
                  if(var80 != null) {
                     class48.method732(var80);
                     WorldListFetcher.method1530(class170.widgets[var80.id >>> 16], var80, true);
                  }

                  if(widgetRoot != -1) {
                     class14.method86(widgetRoot, 1);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?43:167)) {
                  var53 = secretPacketBuffer2.readUnsignedByte() == 1;
                  if(var53) {
                     class51.field622 = BuildType.currentTimeMs() - secretPacketBuffer2.readLong();
                     CombatInfo2.field3350 = new class13(secretPacketBuffer2, true);
                  } else {
                     CombatInfo2.field3350 = null;
                  }

                  field992 = cycleCntr;
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?44:74)) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var19 = secretPacketBuffer2.runeliteReadString();
                  } else {
                     var2 = secretPacketBuffer2.readInt();
                     var19 = secretPacketBuffer2.readString();
                  }

                  var79 = WallObject.method2901(var2);
                  if(!var19.equals(var79.text)) {
                     var79.text = var19;
                     class48.method732(var79);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?45:66)) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var4 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readUnsignedShort();
                     var3 = secretPacketBuffer2.readUnsignedByte();
                     var4 = secretPacketBuffer2.readUnsignedShort();
                  }

                  class71.method1130(var2, var3, var4);
                  packetType = -1;
                  return true;
               }

               Widget var86;
               if(packetType == (RUNELITE_PACKET?47:87)) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var4 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3236();
                     var3 = secretPacketBuffer2.method3244();
                     var4 = secretPacketBuffer2.readUnsignedShort();
                  }

                  var86 = WallObject.method2901(var3);
                  var86.field2618 = var2 + (var4 << 16);
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?49:157)) {
                  if(RUNELITE_PACKET) {
                     var4 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     class83.method1680();
                  } else {
                     class83.method1680();
                     var2 = secretPacketBuffer2.readUnsignedByte();
                     var3 = secretPacketBuffer2.method3230();
                     var4 = secretPacketBuffer2.readInt();
                  }

                  skillExperiences[var3] = var4;
                  boostedSkillLevels[var3] = var2;
                  realSkillLevels[var3] = 1;

                  for(var5 = 0; var5 < 98; ++var5) {
                     if(var4 >= class222.field2817[var5]) {
                        realSkillLevels[var3] = var5 + 2;
                     }
                  }

                  field1142[++field1074 - 1 & 31] = var3;
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?50:79)) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var4 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3243();
                     var3 = secretPacketBuffer2.readShort();
                     var4 = secretPacketBuffer2.method3238();
                  }

                  var86 = WallObject.method2901(var2);
                  if(var3 != var86.originalX || var4 != var86.originalY || var86.field2634 != 0 || var86.field2696 != 0) {
                     var86.originalX = var3;
                     var86.originalY = var4;
                     var86.field2634 = 0;
                     var86.field2696 = 0;
                     class48.method732(var86);
                     this.method1393(var86);
                     if(var86.type == 0) {
                        WorldListFetcher.method1530(class170.widgets[var2 >> 16], var86, false);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?51:0)) {
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 == '\uffff') {
                     var2 = -1;
                  }

                  var3 = secretPacketBuffer2.readInt();
                  var4 = secretPacketBuffer2.readInt();
                  var86 = WallObject.method2901(var3);
                  ItemComposition var85;
                  if(!var86.hasScript) {
                     if(var2 == -1) {
                        var86.modelType = 0;
                        packetType = -1;
                        return true;
                     }

                     var85 = Friend.getItemDefinition(var2);
                     var86.modelType = 4;
                     var86.modelId = var2;
                     var86.rotationX = var85.xan2d;
                     var86.rotationZ = var85.yan2d;
                     var86.modelZoom = var85.zoom2d * 100 / var4;
                     class48.method732(var86);
                  } else {
                     var86.itemId = var2;
                     var86.itemQuantity = var4;
                     var85 = Friend.getItemDefinition(var2);
                     var86.rotationX = var85.xan2d;
                     var86.rotationZ = var85.yan2d;
                     var86.rotationY = var85.zan2d;
                     var86.field2678 = var85.offsetX2d;
                     var86.field2693 = var85.offsetY2d;
                     var86.modelZoom = var85.zoom2d;
                     if(var85.isStackable == 1) {
                        var86.field2744 = 1;
                     } else {
                        var86.field2744 = 2;
                     }

                     if(var86.field2684 > 0) {
                        var86.modelZoom = var86.modelZoom * 32 / var86.field2684;
                     } else if(var86.originalWidth > 0) {
                        var86.modelZoom = var86.modelZoom * 32 / var86.originalWidth;
                     }

                     class48.method732(var86);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?53:11)) {
                  if(RUNELITE_PACKET) {
                     var4 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3228();
                     var3 = secretPacketBuffer2.readByteOb1();
                     var4 = secretPacketBuffer2.method3229();
                  }

                  var24 = (WidgetNode)componentTable.get((long)var4);
                  if(var24 != null) {
                     class169.method3163(var24, var3 != var24.id);
                  }

                  WidgetNode var82 = new WidgetNode();
                  var82.id = var3;
                  var82.owner = var2;
                  componentTable.put(var82, (long)var4);
                  class207.method3891(var3);
                  Widget var98 = WallObject.method2901(var4);
                  class48.method732(var98);
                  if(field895 != null) {
                     class48.method732(field895);
                     field895 = null;
                  }

                  PacketBuffer.method3448();
                  WorldListFetcher.method1530(class170.widgets[var4 >> 16], var98, false);
                  class15.method95(var3);
                  if(widgetRoot != -1) {
                     class14.method86(widgetRoot, 1);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?54:82)) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var22 = secretPacketBuffer2.runeliteReadString();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3230();
                     var3 = secretPacketBuffer2.method3295();
                     var22 = secretPacketBuffer2.readString();
                  }

                  if(var3 >= 1 && var3 <= 8) {
                     if(var22.equalsIgnoreCase("null")) {
                        var22 = null;
                     }

                     playerOptions[var3 - 1] = var22;
                     playerOptionsPriorities[var3 - 1] = var2 == 0;
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?55:125)) {
                  World var68 = new World();
                  var68.address = secretPacketBuffer2.readString();
                  var68.id = secretPacketBuffer2.readUnsignedShort();
                  var3 = secretPacketBuffer2.readInt();
                  var68.mask = var3;
                  class2.setGameState(45);
                  CacheFile.rssocket.close();
                  CacheFile.rssocket = null;
                  WorldMapType3.method203(var68);
                  packetType = -1;
                  return false;
               }

               boolean var54;
               int var56;
               if(packetType == (RUNELITE_PACKET?56:175)) {
                  var20 = secretPacketBuffer2.readString();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  byte var57 = secretPacketBuffer2.readByte();
                  var54 = false;
                  if(var57 == -128) {
                     var54 = true;
                  }

                  if(var54) {
                     if(class21.clanChatCount == 0) {
                        packetType = -1;
                        return true;
                     }

                     boolean var59 = false;

                     for(var6 = 0; var6 < class21.clanChatCount && (!class37.clanMembers[var6].username.equals(var20) || var3 != class37.clanMembers[var6].world); ++var6) {
                        ;
                     }

                     if(var6 < class21.clanChatCount) {
                        while(var6 < class21.clanChatCount - 1) {
                           class37.clanMembers[var6] = class37.clanMembers[var6 + 1];
                           ++var6;
                        }

                        --class21.clanChatCount;
                        class37.clanMembers[class21.clanChatCount] = null;
                     }
                  } else {
                     secretPacketBuffer2.readString();
                     XClanMember var81 = new XClanMember();
                     var81.username = var20;
                     var81.field884 = class9.method48(var81.username, MouseInput.field715);
                     var81.world = var3;
                     var81.rank = var57;

                     for(var7 = class21.clanChatCount - 1; var7 >= 0; --var7) {
                        var56 = class37.clanMembers[var7].field884.compareTo(var81.field884);
                        if(var56 == 0) {
                           class37.clanMembers[var7].world = var3;
                           class37.clanMembers[var7].rank = var57;
                           if(var20.equals(class224.localPlayer.name)) {
                              class67.clanChatRank = var57;
                           }

                           field1077 = cycleCntr;
                           packetType = -1;
                           return true;
                        }

                        if(var56 < 0) {
                           break;
                        }
                     }

                     if(class21.clanChatCount >= class37.clanMembers.length) {
                        packetType = -1;
                        return true;
                     }

                     for(var56 = class21.clanChatCount - 1; var56 > var7; --var56) {
                        class37.clanMembers[var56 + 1] = class37.clanMembers[var56];
                     }

                     if(class21.clanChatCount == 0) {
                        class37.clanMembers = new XClanMember[100];
                     }

                     class37.clanMembers[var7 + 1] = var81;
                     ++class21.clanChatCount;
                     if(var20.equals(class224.localPlayer.name)) {
                        class67.clanChatRank = var57;
                     }
                  }

                  field1077 = cycleCntr;
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?57:153)) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var4 = secretPacketBuffer2.runeliteReadInt();
                     var5 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readUnsignedByte();
                     var3 = secretPacketBuffer2.readUnsignedByte();
                     var4 = secretPacketBuffer2.readUnsignedByte();
                     var5 = secretPacketBuffer2.readUnsignedByte();
                  }

                  field1005[var2] = true;
                  field1132[var2] = var3;
                  field1048[var2] = var4;
                  field1053[var2] = var5;
                  field1093[var2] = 0;
                  packetType = -1;
                  return true;
               }

               long var29;
               if(packetType == (RUNELITE_PACKET?60:99)) {
                  var2 = secretPacketBuffer2.method3244();
                  var3 = secretPacketBuffer2.method3243();
                  var4 = secretPacketBuffer2.method3236();
                  if(var4 == '\uffff') {
                     var4 = -1;
                  }

                  var5 = secretPacketBuffer2.readUnsignedShortOb1();
                  if(var5 == '\uffff') {
                     var5 = -1;
                  }

                  for(var6 = var4; var6 <= var5; ++var6) {
                     var29 = ((long)var2 << 32) + (long)var6;
                     Node var58 = widgetFlags.get(var29);
                     if(var58 != null) {
                        var58.unlink();
                     }

                     widgetFlags.put(new IntegerNode(var3), var29);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?61:86)) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var5 = secretPacketBuffer2.runeliteReadInt();
                     var4 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readUnsignedShortOb1();
                     var3 = secretPacketBuffer2.method3244();
                     var4 = secretPacketBuffer2.method3236();
                     var5 = secretPacketBuffer2.method3236();
                  }

                  var80 = WallObject.method2901(var3);
                  if(var2 != var80.rotationX || var5 != var80.rotationZ || var4 != var80.modelZoom) {
                     var80.rotationX = var2;
                     var80.rotationZ = var5;
                     var80.modelZoom = var4;
                     class48.method732(var80);
                  }

                  packetType = -1;
                  return true;
               }

               String var17;
               int var18;
               long var25;
               long var27;
               String var37;
               if(packetType == (RUNELITE_PACKET?63:235)) {
                  var20 = secretPacketBuffer2.readString();
                  var25 = (long)secretPacketBuffer2.readUnsignedShort();
                  var27 = (long)secretPacketBuffer2.read24BitInt();
                  Permission[] var97 = new Permission[]{Permission.field3156, Permission.field3154, Permission.field3157, Permission.field3153, Permission.field3155, Permission.field3152};
                  Permission var74 = (Permission)CollisionData.forOrdinal(var97, secretPacketBuffer2.readUnsignedByte());
                  long var44 = (var25 << 32) + var27;
                  boolean var95 = false;

                  for(var64 = 0; var64 < 100; ++var64) {
                     if(var44 == field1103[var64]) {
                        var95 = true;
                        break;
                     }
                  }

                  if(class64.isIgnored(var20)) {
                     var95 = true;
                  }

                  if(!var95 && field1002 == 0) {
                     field1103[field1104] = var44;
                     field1104 = (field1104 + 1) % 100;
                     PacketBuffer var101 = secretPacketBuffer2;
                     String var46 = SceneTilePaint.method2695(var101, 32767);
                     var37 = FontTypeFace.appendTags(Sequence.method4712(var46));
                     byte var42;
                     if(var74.field3160) {
                        var42 = 7;
                     } else {
                        var42 = 3;
                     }

                     if(var74.field3159 != -1) {
                        var18 = var74.field3159;
                        var17 = "<img=" + var18 + ">";
                        class202.sendGameMessage(var42, var17 + var20, var37);
                     } else {
                        class202.sendGameMessage(var42, var20, var37);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               boolean var55;
               if(packetType == (RUNELITE_PACKET?64:244)) {
                  var2 = secretPacketBuffer2.getUSmart();
                  var55 = secretPacketBuffer2.readUnsignedByte() == 1;
                  var22 = "";
                  var54 = false;
                  if(var55) {
                     var22 = secretPacketBuffer2.readString();
                     if(class64.isIgnored(var22)) {
                        var54 = true;
                     }
                  }

                  var78 = secretPacketBuffer2.readString();
                  if(!var54) {
                     class202.sendGameMessage(var2, var22, var78);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?65:123)) {
                  var20 = secretPacketBuffer2.readString();
                  Object[] var66 = new Object[var20.length() + 1];

                  for(var4 = var20.length() - 1; var4 >= 0; --var4) {
                     if(var20.charAt(var4) == 115) {
                        var66[var4 + 1] = secretPacketBuffer2.readString();
                     } else {
                        var66[var4 + 1] = new Integer(secretPacketBuffer2.readInt());
                     }
                  }

                  var66[0] = new Integer(secretPacketBuffer2.readInt());
                  ScriptEvent var89 = new ScriptEvent();
                  var89.field818 = var66;
                  Ignore.method1126(var89);
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?66:245)) {
                  while(secretPacketBuffer2.offset < packetLength) {
                     var2 = secretPacketBuffer2.readUnsignedByte();
                     var55 = (var2 & 1) == 1;
                     var22 = secretPacketBuffer2.readString();
                     var83 = secretPacketBuffer2.readString();
                     secretPacketBuffer2.readString();

                     for(var6 = 0; var6 < ignoreCount; ++var6) {
                        Ignore var96 = ignores[var6];
                        if(var55) {
                           if(var83.equals(var96.name)) {
                              var96.name = var22;
                              var96.previousName = var83;
                              var22 = null;
                              break;
                           }
                        } else if(var22.equals(var96.name)) {
                           var96.name = var22;
                           var96.previousName = var83;
                           var22 = null;
                           break;
                        }
                     }

                     if(var22 != null && ignoreCount < 400) {
                        Ignore var75 = new Ignore();
                        ignores[ignoreCount] = var75;
                        var75.name = var22;
                        var75.previousName = var83;
                        ++ignoreCount;
                     }
                  }

                  field1076 = cycleCntr;
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?67:57)) {
                  field1130 = true;
                  PlayerComposition.field2605 = secretPacketBuffer2.readUnsignedByte();
                  Actor.field1198 = secretPacketBuffer2.readUnsignedByte();
                  class155.field2230 = secretPacketBuffer2.readUnsignedShort();
                  class265.field3638 = secretPacketBuffer2.readUnsignedByte();
                  ISAACCipher.field2402 = secretPacketBuffer2.readUnsignedByte();
                  if(ISAACCipher.field2402 >= 100) {
                     class89.cameraX = PlayerComposition.field2605 * 128 + 64;
                     KeyFocusListener.cameraY = Actor.field1198 * 128 + 64;
                     WallObject.cameraZ = class18.getTileHeight(class89.cameraX, KeyFocusListener.cameraY, class8.plane) - class155.field2230;
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?68:75)) {
                  field1130 = true;
                  Varcs.field1491 = secretPacketBuffer2.readUnsignedByte();
                  class48.field577 = secretPacketBuffer2.readUnsignedByte();
                  class21.field326 = secretPacketBuffer2.readUnsignedShort();
                  class34.field466 = secretPacketBuffer2.readUnsignedByte();
                  class46.field559 = secretPacketBuffer2.readUnsignedByte();
                  if(class46.field559 >= 100) {
                     var2 = 64 + Varcs.field1491 * 128;
                     var3 = class48.field577 * 128 + 64;
                     var4 = class18.getTileHeight(var2, var3, class8.plane) - class21.field326;
                     var5 = var2 - class89.cameraX;
                     var6 = var4 - WallObject.cameraZ;
                     var7 = var3 - KeyFocusListener.cameraY;
                     var56 = (int)Math.sqrt((double)(var7 * var7 + var5 * var5));
                     cameraPitch = (int)(Math.atan2((double)var6, (double)var56) * 325.949D) & 2047;
                     ScriptState.cameraYaw = (int)(Math.atan2((double)var5, (double)var7) * -325.949D) & 2047;
                     if(cameraPitch < 128) {
                        cameraPitch = 128;
                     }

                     if(cameraPitch > 383) {
                        cameraPitch = 383;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               long var11;
               if(packetType == (RUNELITE_PACKET?69:64)) {
                  var20 = secretPacketBuffer2.readString();
                  var25 = secretPacketBuffer2.readLong();
                  var27 = (long)secretPacketBuffer2.readUnsignedShort();
                  var29 = (long)secretPacketBuffer2.read24BitInt();
                  Permission[] var9 = new Permission[]{Permission.field3156, Permission.field3154, Permission.field3157, Permission.field3153, Permission.field3155, Permission.field3152};
                  Permission var63 = (Permission)CollisionData.forOrdinal(var9, secretPacketBuffer2.readUnsignedByte());
                  var11 = var29 + (var27 << 32);
                  boolean var13 = false;

                  for(var14 = 0; var14 < 100; ++var14) {
                     if(field1103[var14] == var11) {
                        var13 = true;
                        break;
                     }
                  }

                  if(var63.field3161 && class64.isIgnored(var20)) {
                     var13 = true;
                  }

                  if(!var13 && field1002 == 0) {
                     field1103[field1104] = var11;
                     field1104 = (field1104 + 1) % 100;
                     PacketBuffer var15 = secretPacketBuffer2;
                     var37 = SceneTilePaint.method2695(var15, 32767);
                     String var16 = FontTypeFace.appendTags(Sequence.method4712(var37));
                     if(var63.field3159 != -1) {
                        var18 = var63.field3159;
                        var17 = "<img=" + var18 + ">";
                        Projectile.addChatMessage(9, var17 + var20, var16, GraphicsObject.method1686(var25));
                     } else {
                        Projectile.addChatMessage(9, var20, var16, GraphicsObject.method1686(var25));
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?70:216)) {
                  field1115 = secretPacketBuffer2.readUnsignedByte();
                  if(field1115 == 1) {
                     field910 = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(field1115 >= 2 && field1115 <= 6) {
                     if(field1115 == 2) {
                        field915 = 64;
                        field1009 = 64;
                     }

                     if(field1115 == 3) {
                        field915 = 0;
                        field1009 = 64;
                     }

                     if(field1115 == 4) {
                        field915 = 128;
                        field1009 = 64;
                     }

                     if(field1115 == 5) {
                        field915 = 64;
                        field1009 = 0;
                     }

                     if(field1115 == 6) {
                        field915 = 64;
                        field1009 = 128;
                     }

                     field1115 = 2;
                     hintArrowX = secretPacketBuffer2.readUnsignedShort();
                     hintArrowY = secretPacketBuffer2.readUnsignedShort();
                     hintArrowType = secretPacketBuffer2.readUnsignedByte();
                  }

                  if(field1115 == 10) {
                     field911 = secretPacketBuffer2.readUnsignedShort();
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?71:121)) {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 < -70000) {
                     var3 += '耀';
                  }

                  if(var2 >= 0) {
                     var79 = WallObject.method2901(var2);
                  } else {
                     var79 = null;
                  }

                  if(var79 != null) {
                     for(var5 = 0; var5 < var79.itemIds.length; ++var5) {
                        var79.itemIds[var5] = 0;
                        var79.itemQuantities[var5] = 0;
                     }
                  }

                  CacheFile.method1884(var3);
                  var5 = secretPacketBuffer2.readUnsignedShort();

                  for(var6 = 0; var6 < var5; ++var6) {
                     var7 = secretPacketBuffer2.readByteOb1();
                     var56 = secretPacketBuffer2.method3230();
                     if(var56 == 255) {
                        var56 = secretPacketBuffer2.method3229();
                     }

                     if(var79 != null && var6 < var79.itemIds.length) {
                        var79.itemIds[var6] = var7;
                        var79.itemQuantities[var6] = var56;
                     }

                     WorldMapType1.setItemTableSlot(var3, var6, var7 - 1, var56);
                  }

                  if(var79 != null) {
                     class48.method732(var79);
                  }

                  class83.method1680();
                  interfaceItemTriggers[++field1160 - 1 & 31] = var3 & 32767;
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?72:154)) {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 < -70000) {
                     var3 += '耀';
                  }

                  if(var2 >= 0) {
                     var79 = WallObject.method2901(var2);
                  } else {
                     var79 = null;
                  }

                  for(; secretPacketBuffer2.offset < packetLength; WorldMapType1.setItemTableSlot(var3, var5, var6 - 1, var7)) {
                     var5 = secretPacketBuffer2.getUSmart();
                     var6 = secretPacketBuffer2.readUnsignedShort();
                     var7 = 0;
                     if(var6 != 0) {
                        var7 = secretPacketBuffer2.readUnsignedByte();
                        if(var7 == 255) {
                           var7 = secretPacketBuffer2.readInt();
                        }
                     }

                     if(var79 != null && var5 >= 0 && var5 < var79.itemIds.length) {
                        var79.itemIds[var5] = var6;
                        var79.itemQuantities[var5] = var7;
                     }
                  }

                  if(var79 != null) {
                     class48.method732(var79);
                  }

                  class83.method1680();
                  interfaceItemTriggers[++field1160 - 1 & 31] = var3 & 32767;
                  packetType = -1;
                  return true;
               }

               boolean var35;
               int var94;
               if(packetType == (RUNELITE_PACKET?73:181)) {
                  field1077 = cycleCntr;
                  if(packetLength == 0) {
                     clanChatOwner = null;
                     clanChatName = null;
                     class21.clanChatCount = 0;
                     class37.clanMembers = null;
                     packetType = -1;
                     return true;
                  }

                  clanChatName = secretPacketBuffer2.readString();
                  long var31 = secretPacketBuffer2.readLong();
                  var27 = var31;
                  if(var31 > 0L && var31 < 6582952005840035281L) {
                     if(var31 % 37L == 0L) {
                        var22 = null;
                     } else {
                        var7 = 0;

                        for(var33 = var31; 0L != var33; var33 /= 37L) {
                           ++var7;
                        }

                        StringBuilder var61 = new StringBuilder(var7);

                        while(0L != var27) {
                           var11 = var27;
                           var27 /= 37L;
                           var61.append(class268.field3656[(int)(var11 - 37L * var27)]);
                        }

                        var22 = var61.reverse().toString();
                     }
                  } else {
                     var22 = null;
                  }

                  clanChatOwner = var22;
                  IndexData.field3231 = secretPacketBuffer2.readByte();
                  var7 = secretPacketBuffer2.readUnsignedByte();
                  if(var7 == 255) {
                     packetType = -1;
                     return true;
                  }

                  class21.clanChatCount = var7;
                  XClanMember[] var72 = new XClanMember[100];

                  for(var94 = 0; var94 < class21.clanChatCount; ++var94) {
                     var72[var94] = new XClanMember();
                     var72[var94].username = secretPacketBuffer2.readString();
                     var72[var94].field884 = class9.method48(var72[var94].username, MouseInput.field715);
                     var72[var94].world = secretPacketBuffer2.readUnsignedShort();
                     var72[var94].rank = secretPacketBuffer2.readByte();
                     secretPacketBuffer2.readString();
                     if(var72[var94].username.equals(class224.localPlayer.name)) {
                        class67.clanChatRank = var72[var94].rank;
                     }
                  }

                  var35 = false;
                  var36 = class21.clanChatCount;

                  while(var36 > 0) {
                     var35 = true;
                     --var36;

                     for(var64 = 0; var64 < var36; ++var64) {
                        if(var72[var64].field884.compareTo(var72[var64 + 1].field884) > 0) {
                           XClanMember var62 = var72[var64];
                           var72[var64] = var72[var64 + 1];
                           var72[var64 + 1] = var62;
                           var35 = false;
                        }
                     }

                     if(var35) {
                        break;
                     }
                  }

                  class37.clanMembers = var72;
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?74:20)) {
                  var2 = packetLength + secretPacketBuffer2.offset;
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  var4 = secretPacketBuffer2.readUnsignedShort();
                  if(var3 != widgetRoot) {
                     widgetRoot = var3;
                     this.method1190(false);
                     class207.method3891(widgetRoot);
                     class15.method95(widgetRoot);

                     for(var5 = 0; var5 < 100; ++var5) {
                        field1088[var5] = true;
                     }
                  }

                  WidgetNode var67;
                  for(; var4-- > 0; var67.field805 = true) {
                     var5 = secretPacketBuffer2.readInt();
                     var6 = secretPacketBuffer2.readUnsignedShort();
                     var7 = secretPacketBuffer2.readUnsignedByte();
                     var67 = (WidgetNode)componentTable.get((long)var5);
                     if(var67 != null && var6 != var67.id) {
                        class169.method3163(var67, true);
                        var67 = null;
                     }

                     if(var67 == null) {
                        WidgetNode var60 = new WidgetNode();
                        var60.id = var6;
                        var60.owner = var7;
                        componentTable.put(var60, (long)var5);
                        class207.method3891(var6);
                        Widget var100 = WallObject.method2901(var5);
                        class48.method732(var100);
                        if(field895 != null) {
                           class48.method732(field895);
                           field895 = null;
                        }

                        PacketBuffer.method3448();
                        WorldListFetcher.method1530(class170.widgets[var5 >> 16], var100, false);
                        class15.method95(var6);
                        if(widgetRoot != -1) {
                           class14.method86(widgetRoot, 1);
                        }

                        var67 = var60;
                     }
                  }

                  for(var24 = (WidgetNode)componentTable.method3564(); var24 != null; var24 = (WidgetNode)componentTable.method3565()) {
                     if(var24.field805) {
                        var24.field805 = false;
                     } else {
                        class169.method3163(var24, true);
                     }
                  }

                  widgetFlags = new XHashTable(512);

                  while(secretPacketBuffer2.offset < var2) {
                     var5 = secretPacketBuffer2.readInt();
                     var6 = secretPacketBuffer2.readUnsignedShort();
                     var7 = secretPacketBuffer2.readUnsignedShort();
                     var56 = secretPacketBuffer2.readInt();

                     for(var94 = var6; var94 <= var7; ++var94) {
                        long var47 = (long)var94 + ((long)var5 << 32);
                        widgetFlags.put(new IntegerNode(var56), var47);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?76:159)) {
                  while(secretPacketBuffer2.offset < packetLength) {
                     var53 = secretPacketBuffer2.readUnsignedByte() == 1;
                     var19 = secretPacketBuffer2.readString();
                     var22 = secretPacketBuffer2.readString();
                     var5 = secretPacketBuffer2.readUnsignedShort();
                     var6 = secretPacketBuffer2.readUnsignedByte();
                     var7 = secretPacketBuffer2.readUnsignedByte();
                     boolean var8 = (var7 & 2) != 0;
                     var35 = (var7 & 1) != 0;
                     if(var5 > 0) {
                        secretPacketBuffer2.readString();
                        secretPacketBuffer2.readUnsignedByte();
                        secretPacketBuffer2.readInt();
                     }

                     secretPacketBuffer2.readString();

                     for(var39 = 0; var39 < friendCount; ++var39) {
                        Friend var40 = friends[var39];
                        if(!var53) {
                           if(var19.equals(var40.name)) {
                              if(var5 != var40.world) {
                                 boolean var12 = true;

                                 for(class67 var41 = (class67)field1152.method3652(); var41 != null; var41 = (class67)field1152.method3657()) {
                                    if(var41.field800.equals(var19)) {
                                       if(var5 != 0 && var41.field793 == 0) {
                                          var41.method3661();
                                          var12 = false;
                                       } else if(var5 == 0 && var41.field793 != 0) {
                                          var41.method3661();
                                          var12 = false;
                                       }
                                    }
                                 }

                                 if(var12) {
                                    field1152.method3651(new class67(var19, var5));
                                 }

                                 var40.world = var5;
                              }

                              var40.previousName = var22;
                              var40.rank = var6;
                              var40.field782 = var8;
                              var40.field780 = var35;
                              var19 = null;
                              break;
                           }
                        } else if(var22.equals(var40.name)) {
                           var40.name = var19;
                           var40.previousName = var22;
                           var19 = null;
                           break;
                        }
                     }

                     if(var19 != null && friendCount < 400) {
                        Friend var10 = new Friend();
                        friends[friendCount] = var10;
                        var10.name = var19;
                        var10.previousName = var22;
                        var10.world = var5;
                        var10.rank = var6;
                        var10.field782 = var8;
                        var10.field780 = var35;
                        ++friendCount;
                     }
                  }

                  field1144 = 2;
                  field1076 = cycleCntr;
                  var53 = false;
                  var3 = friendCount;

                  while(var3 > 0) {
                     var53 = true;
                     --var3;

                     for(var4 = 0; var4 < var3; ++var4) {
                        var54 = false;
                        Friend var23 = friends[var4];
                        Friend var38 = friends[var4 + 1];
                        if(var23.world != world && var38.world == world) {
                           var54 = true;
                        }

                        if(!var54 && var23.world == 0 && var38.world != 0) {
                           var54 = true;
                        }

                        if(!var54 && !var23.field782 && var38.field782) {
                           var54 = true;
                        }

                        if(!var54 && !var23.field780 && var38.field780) {
                           var54 = true;
                        }

                        if(var54) {
                           Friend var21 = friends[var4];
                           friends[var4] = friends[var4 + 1];
                           friends[var4 + 1] = var21;
                           var53 = false;
                        }
                     }

                     if(var53) {
                        break;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?78:229)) {
                  class37.xteaChanged(false);
                  secretPacketBuffer2.readOpcode();
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  KeyFocusListener.method784(secretPacketBuffer2, var2);
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?79:135)) {
                  class37.xteaChanged(true);
                  secretPacketBuffer2.readOpcode();
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  KeyFocusListener.method784(secretPacketBuffer2, var2);
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?80:68)) {
                  class36.method501(true);
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?81:194)) {
                  class36.method501(false);
                  packetType = -1;
                  return true;
               }

               if(packetType != (RUNELITE_PACKET?82:214)) {
                  if(packetType == (RUNELITE_PACKET?83:119)) {
                     class24.field343 = secretPacketBuffer2.method3295();
                     DecorativeObject.field2152 = secretPacketBuffer2.method3228();

                     while(secretPacketBuffer2.offset < packetLength) {
                        packetType = secretPacketBuffer2.readUnsignedByte();
                        class34.method449();
                     }

                     packetType = -1;
                     return true;
                  }

                  class23.method165("" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength, (Throwable)null);
                  class51.method792();
                  return true;
               }
            }

            class34.method449();
            packetType = -1;
            return true;
         } catch (IOException var51) {
            if(field946 > 0) {
               class51.method792();
            } else {
               class2.setGameState(40);
               NPC.field1339 = CacheFile.rssocket;
               CacheFile.rssocket = null;
            }
         } catch (Exception var52) {
            var20 = "" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength + "," + (class224.localPlayer.pathX[0] + class33.baseX) + "," + (class224.localPlayer.pathY[0] + class17.baseY) + ",";

            for(var3 = 0; var3 < packetLength && var3 < 50; ++var3) {
               var20 = var20 + secretPacketBuffer2.payload[var3] + ",";
            }

            class23.method165(var20, var52);
            class51.method792();
         }

         return true;
      }
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "202934702"
   )
   void method1433() {
      if(class238.field3251 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class238.field3252 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field922 = 3000;
            class238.field3252 = 3;
         }

         if(--field922 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  class48.socket = GameEngine.taskManager.createSocket(class1.host, class56.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(class48.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(class48.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  class2.rssocket = new RSSocket((Socket)class48.socket.value, GameEngine.taskManager);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(151);
                  class2.rssocket.queueForWrite(var1.payload, 0, 5);
                  ++js5State;
                  class269.field3665 = BuildType.currentTimeMs();
               }

               if(js5State == 3) {
                  if(gameState > 5 && class2.rssocket.available() <= 0) {
                     if(BuildType.currentTimeMs() - class269.field3665 > 30000L) {
                        this.error(-2);
                        return;
                     }
                  } else {
                     int var5 = class2.rssocket.readByte();
                     if(var5 != 0) {
                        this.error(var5);
                        return;
                     }

                     ++js5State;
                  }
               }

               if(js5State == 4) {
                  RSSocket var10 = class2.rssocket;
                  boolean var2 = gameState > 20;
                  if(class238.field3235 != null) {
                     try {
                        class238.field3235.close();
                     } catch (Exception var8) {
                        ;
                     }

                     class238.field3235 = null;
                  }

                  class238.field3235 = var10;
                  GroundObject.sendConInfo(var2);
                  class238.field3239.offset = 0;
                  Buffer.currentRequest = null;
                  Ignore.field833 = null;
                  class238.field3247 = 0;

                  while(true) {
                     FileRequest var3 = (FileRequest)class238.field3246.method3564();
                     if(var3 == null) {
                        while(true) {
                           var3 = (FileRequest)class238.field3233.method3564();
                           if(var3 == null) {
                              if(class238.field3250 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.putByte(4);
                                    var11.putByte(class238.field3250);
                                    var11.putShort(0);
                                    class238.field3235.queueForWrite(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class238.field3235.close();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class238.field3252;
                                    class238.field3235 = null;
                                 }
                              }

                              class238.field3237 = 0;
                              class238.field3242 = BuildType.currentTimeMs();
                              class48.socket = null;
                              class2.rssocket = null;
                              js5State = 0;
                              field925 = 0;
                              return;
                           }

                           class238.field3240.setHead(var3);
                           class238.field3241.put(var3, var3.hash);
                           ++class238.field3243;
                           --class238.field3244;
                        }
                     }

                     class238.field3236.put(var3, var3.hash);
                     ++class238.field3234;
                     --class238.field3238;
                  }
               }
            } catch (IOException var9) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1952112573"
   )
   final void method1286() {
      if(widgetRoot != -1) {
         class54.method804(widgetRoot);
      }

      int var1;
      for(var1 = 0; var1 < field1086; ++var1) {
         if(field1088[var1]) {
            field971[var1] = true;
         }

         field1090[var1] = field1088[var1];
         field1088[var1] = false;
      }

      field906 = gameCycle;
      field1032 = -1;
      field966 = -1;
      class47.field564 = null;
      if(widgetRoot != -1) {
         field1086 = 0;
         class2.drawWidget(widgetRoot, 0, 0, class31.canvasWidth, class67.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      int var2;
      int var3;
      if(!isMenuOpen) {
         if(field1032 != -1) {
            var1 = field1032;
            var2 = field966;
            if(menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) {
               var3 = menuOptionCount - 1;
               String var5;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var5 = "Use" + " " + field1037 + " " + "->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var5 = field972 + " " + field1042 + " " + "->";
               } else {
                  String var14;
                  if(var3 < 0) {
                     var14 = "";
                  } else if(menuTargets[var3].length() > 0) {
                     var14 = menuOptions[var3] + " " + menuTargets[var3];
                  } else {
                     var14 = menuOptions[var3];
                  }

                  var5 = var14;
               }

               if(menuOptionCount > 2) {
                  var5 = var5 + CacheFile.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               class43.field544.drawRandomizedMouseoverText(var5, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         var1 = class14.menuX;
         var2 = DynamicObject.menuY;
         var3 = class12.menuWidth;
         int var4 = class14.menuHeight;
         int var13 = 6116423;
         Rasterizer2D.method4937(var1, var2, var3, var4, var13);
         Rasterizer2D.method4937(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
         class43.field544.method4751("Choose Option", var1 + 3, var2 + 14, var13, -1);
         int var6 = MouseInput.field696;
         int var7 = MouseInput.field705;

         for(int var8 = 0; var8 < menuOptionCount; ++var8) {
            int var9 = (menuOptionCount - 1 - var8) * 15 + var2 + 31;
            int var10 = 16777215;
            if(var6 > var1 && var6 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
               var10 = 16776960;
            }

            Font var11 = class43.field544;
            String var12;
            if(var8 < 0) {
               var12 = "";
            } else if(menuTargets[var8].length() > 0) {
               var12 = menuOptions[var8] + " " + menuTargets[var8];
            } else {
               var12 = menuOptions[var8];
            }

            var11.method4751(var12, var1 + 3, var9, var10, 0);
         }

         class23.method164(class14.menuX, DynamicObject.menuY, class12.menuWidth, class14.menuHeight);
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < field1086; ++var1) {
            if(field1090[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field971[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      WorldMapType2.method544(class8.plane, class224.localPlayer.x, class224.localPlayer.y, field1078);
      field1078 = 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1865712798"
   )
   protected final void vmethod1402() {
      field955 = BuildType.currentTimeMs() + 500L;
      this.method1485();
      if(widgetRoot != -1) {
         this.method1190(true);
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "4"
   )
   @Hook("clientMainLoop")
   protected final void vmethod1178(boolean var1) {
      boolean var2;
      label165: {
         try {
            if(class203.field2475 == 2) {
               if(class203.field2477 == null) {
                  class203.field2477 = Track1.getMusicFile(class262.field3614, class11.field253, class203.field2482);
                  if(class203.field2477 == null) {
                     var2 = false;
                     break label165;
                  }
               }

               if(Buffer.field2368 == null) {
                  Buffer.field2368 = new class114(class203.field2476, class203.field2472);
               }

               if(class203.field2473.method3715(class203.field2477, class21.field325, Buffer.field2368, 22050)) {
                  class203.field2473.method3712();
                  class203.field2473.method3709(class203.field2474);
                  class203.field2473.method3776(class203.field2477, class182.field2413);
                  class203.field2475 = 0;
                  class203.field2477 = null;
                  Buffer.field2368 = null;
                  class262.field3614 = null;
                  var2 = true;
                  break label165;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class203.field2473.method3819();
            class203.field2475 = 0;
            class203.field2477 = null;
            Buffer.field2368 = null;
            class262.field3614 = null;
         }

         var2 = false;
      }

      if(var2 && field1121 && class13.soundSystem0 != null) {
         class13.soundSystem0.method2079();
      }

      if((gameState == 10 || gameState == 20 || gameState == 30) && field955 != 0L && BuildType.currentTimeMs() > field955) {
         class15.method93(class10.method52());
      }

      int var4;
      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1088[var4] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class92.loadingBarPercentage, class92.loadingText, var1);
      } else if(gameState == 5) {
         class22.drawLoginScreen(class43.field544, NPC.field1340, class18.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class22.drawLoginScreen(class43.field544, NPC.field1340, class18.font_p12full, var1);
         } else if(gameState == 25) {
            if(field953 == 1) {
               if(field949 > field950) {
                  field950 = field949;
               }

               var4 = (field950 * 50 - field949 * 50) / field950;
               ScriptVarType.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field953 == 2) {
               if(field951 > field952) {
                  field952 = field951;
               }

               var4 = 50 + (field952 * 50 - field951 * 50) / field952;
               ScriptVarType.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               ScriptVarType.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1286();
         } else if(gameState == 40) {
            ScriptVarType.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            ScriptVarType.drawStatusBox("Please wait...", false);
         }
      } else {
         class22.drawLoginScreen(class43.field544, NPC.field1340, class18.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var4 = 0; var4 < field1086; ++var4) {
            if(field971[var4]) {
               class48.field582.vmethod5018(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field971[var4] = false;
            }
         }
      } else if(gameState > 0) {
         class48.field582.vmethod5019(0, 0);

         for(var4 = 0; var4 < field1086; ++var4) {
            field971[var4] = false;
         }
      }

   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1821495426"
   )
   final void method1516() {
      try {
         if(loginState == 0) {
            if(CacheFile.rssocket != null) {
               CacheFile.rssocket.close();
               CacheFile.rssocket = null;
            }

            Spotanim.field3320 = null;
            socketError = false;
            field1058 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(Spotanim.field3320 == null) {
               Spotanim.field3320 = GameEngine.taskManager.createSocket(class1.host, class56.myWorldPort);
            }

            if(Spotanim.field3320.status == 2) {
               throw new IOException();
            }

            if(Spotanim.field3320.status == 1) {
               CacheFile.rssocket = new RSSocket((Socket)Spotanim.field3320.value, GameEngine.taskManager);
               Spotanim.field3320 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(14);
            CacheFile.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, 1);
            secretPacketBuffer2.offset = 0;
            loginState = 3;
         }

         int var1;
         if(loginState == 3) {
            if(class13.soundSystem0 != null) {
               class13.soundSystem0.method2130();
            }

            if(Renderable.soundSystem1 != null) {
               Renderable.soundSystem1.method2130();
            }

            var1 = CacheFile.rssocket.readByte();
            if(class13.soundSystem0 != null) {
               class13.soundSystem0.method2130();
            }

            if(Renderable.soundSystem1 != null) {
               Renderable.soundSystem1.method2130();
            }

            if(var1 != 0) {
               WorldMapType1.method269(var1);
               return;
            }

            secretPacketBuffer2.offset = 0;
            loginState = 4;
         }

         if(loginState == 4) {
            if(secretPacketBuffer2.offset < 8) {
               var1 = CacheFile.rssocket.available();
               if(var1 > 8 - secretPacketBuffer2.offset) {
                  var1 = 8 - secretPacketBuffer2.offset;
               }

               if(var1 > 0) {
                  CacheFile.rssocket.read(secretPacketBuffer2.payload, secretPacketBuffer2.offset, var1);
                  secretPacketBuffer2.offset += var1;
               }
            }

            if(secretPacketBuffer2.offset == 8) {
               secretPacketBuffer2.offset = 0;
               class257.field3528 = secretPacketBuffer2.readLong();
               loginState = 5;
            }
         }

         int var2;
         int var3;
         if(loginState == 5) {
            int[] var6 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class257.field3528 >> 32), (int)(class257.field3528 & -1L)};
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(1);
            secretPacketBuffer1.putByte(class92.field1418.rsOrdinal());
            secretPacketBuffer1.putInt(var6[0]);
            secretPacketBuffer1.putInt(var6[1]);
            secretPacketBuffer1.putInt(var6[2]);
            secretPacketBuffer1.putInt(var6[3]);
            switch(class92.field1418.field2172) {
            case 0:
               secretPacketBuffer1.putInt(((Integer)class170.preferences.preferences.get(Integer.valueOf(ChatLineBuffer.method1878(class92.username)))).intValue());
               secretPacketBuffer1.offset += 4;
               break;
            case 1:
            case 3:
               secretPacketBuffer1.put24bitInt(class41.authCodeForLogin);
               secretPacketBuffer1.offset += 5;
               break;
            case 2:
               secretPacketBuffer1.offset += 8;
            }

            secretPacketBuffer1.putString(class92.password);
            secretPacketBuffer1.encryptRsa(class90.rsaKeyExponent, class90.rsaKeyModulus);
            field937.offset = 0;
            if(gameState == 40) {
               field937.putByte(18);
            } else {
               field937.putByte(16);
            }

            field937.putShort(0);
            var2 = field937.offset;
            field937.putInt(151);
            field937.putBytes(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
            var3 = field937.offset;
            field937.putString(class92.username);
            field937.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            field937.putShort(class31.canvasWidth);
            field937.putShort(class67.canvasHeight);
            WidgetNode.method1111(field937);
            field937.putString(WorldMapType3.sessionToken);
            field937.putInt(class5.field34);
            Buffer var4 = new Buffer(class34.field467.method5376());
            class34.field467.method5379(var4);
            field937.putBytes(var4.payload, 0, var4.payload.length);
            field937.putByte(class67.field794);
            field937.putInt(0);
            field937.putInt(class67.indexInterfaces.crc);
            field937.putInt(class64.indexSoundEffects.crc);
            field937.putInt(Occluder.configsIndex.crc);
            field937.putInt(class44.field551.crc);
            field937.putInt(class207.field2555.crc);
            field937.putInt(indexMaps.crc);
            field937.putInt(class2.indexTrack1.crc);
            field937.putInt(class54.indexModels.crc);
            field937.putInt(CombatInfo1.indexSprites.crc);
            field937.putInt(SoundTask.indexTextures.crc);
            field937.putInt(class221.field2806.crc);
            field937.putInt(class3.indexTrack2.crc);
            field937.putInt(indexScripts.crc);
            field937.putInt(IndexFile.field2256.crc);
            field937.putInt(class91.vorbisIndex.crc);
            field937.putInt(class21.field323.crc);
            field937.putInt(Script.indexWorldMap.crc);
            field937.encryptXtea(var6, var3, field937.offset);
            field937.putShortLength(field937.offset - var2);
            CacheFile.rssocket.queueForWrite(field937.payload, 0, field937.offset);
            secretPacketBuffer1.seed(var6);

            for(int var5 = 0; var5 < 4; ++var5) {
               var6[var5] += 50;
            }

            secretPacketBuffer2.seed(var6);
            loginState = 6;
         }

         if(loginState == 6 && CacheFile.rssocket.available() > 0) {
            var1 = CacheFile.rssocket.readByte();
            if(var1 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var1 == 2) {
               loginState = 9;
            } else if(var1 == 15 && gameState == 40) {
               packetLength = -1;
               loginState = 13;
            } else if(var1 == 23 && field928 < 1) {
               ++field928;
               loginState = 0;
            } else {
               if(var1 != 29) {
                  WorldMapType1.method269(var1);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && CacheFile.rssocket.available() > 0) {
            field929 = (CacheFile.rssocket.readByte() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field1058 = 0;
            PendingSpawn.method1526("You have only just left another world.", "Your profile will be transferred in:", field929 / 60 + " seconds.");
            if(--field929 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && CacheFile.rssocket.available() >= 13) {
               boolean var12 = CacheFile.rssocket.readByte() == 1;
               CacheFile.rssocket.read(secretPacketBuffer2.payload, 0, 4);
               secretPacketBuffer2.offset = 0;
               boolean var11 = false;
               if(var12) {
                  var2 = secretPacketBuffer2.readOpcode() << 24;
                  var2 |= secretPacketBuffer2.readOpcode() << 16;
                  var2 |= secretPacketBuffer2.readOpcode() << 8;
                  var2 |= secretPacketBuffer2.readOpcode();
                  var3 = ChatLineBuffer.method1878(class92.username);
                  if(class170.preferences.preferences.size() >= 10 && !class170.preferences.preferences.containsKey(Integer.valueOf(var3))) {
                     Iterator var13 = class170.preferences.preferences.entrySet().iterator();
                     var13.next();
                     var13.remove();
                  }

                  class170.preferences.preferences.put(Integer.valueOf(var3), Integer.valueOf(var2));
                  Projectile.method1762();
               }

               rights = CacheFile.rssocket.readByte();
               field1052 = CacheFile.rssocket.readByte() == 1;
               localInteractingIndex = CacheFile.rssocket.readByte();
               localInteractingIndex <<= 8;
               localInteractingIndex += CacheFile.rssocket.readByte();
               field1101 = CacheFile.rssocket.readByte();
               CacheFile.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               CacheFile.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();

               try {
                  class52.method794(Projectile.clientInstance, "zap");
               } catch (Throwable var9) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(CacheFile.rssocket.available() >= packetLength) {
                  secretPacketBuffer2.offset = 0;
                  CacheFile.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                  class268.method4868();
                  class95.initializeGPI(secretPacketBuffer2);
                  class35.field474 = -1;
                  class37.xteaChanged(false);
                  packetType = -1;
               }

            } else {
               if(loginState == 11 && CacheFile.rssocket.available() >= 2) {
                  secretPacketBuffer2.offset = 0;
                  CacheFile.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                  secretPacketBuffer2.offset = 0;
                  class163.field2292 = secretPacketBuffer2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && CacheFile.rssocket.available() >= class163.field2292) {
                  secretPacketBuffer2.offset = 0;
                  CacheFile.rssocket.read(secretPacketBuffer2.payload, 0, class163.field2292);
                  secretPacketBuffer2.offset = 0;
                  String var14 = secretPacketBuffer2.readString();
                  String var7 = secretPacketBuffer2.readString();
                  String var8 = secretPacketBuffer2.readString();
                  PendingSpawn.method1526(var14, var7, var8);
                  class2.setGameState(10);
               }

               if(loginState != 13) {
                  ++field1058;
                  if(field1058 > 2000) {
                     if(field928 < 1) {
                        if(class229.field3149 == class56.myWorldPort) {
                           class56.myWorldPort = class11.field254;
                        } else {
                           class56.myWorldPort = class229.field3149;
                        }

                        ++field928;
                        loginState = 0;
                     } else {
                        WorldMapType1.method269(-3);
                     }
                  }
               } else {
                  if(packetLength == -1) {
                     if(CacheFile.rssocket.available() < 2) {
                        return;
                     }

                     CacheFile.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                     secretPacketBuffer2.offset = 0;
                     packetLength = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(CacheFile.rssocket.available() >= packetLength) {
                     CacheFile.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                     secretPacketBuffer2.offset = 0;
                     var1 = packetLength;
                     secretPacketBuffer1.offset = 0;
                     secretPacketBuffer2.offset = 0;
                     packetType = -1;
                     lastFrameId = -1;
                     secondLastFrameId = -1;
                     thridLastFrameId = -1;
                     packetLength = 0;
                     field941 = 0;
                     field908 = 0;
                     menuOptionCount = 0;
                     isMenuOpen = false;
                     field1118 = 0;
                     destinationX = 0;

                     for(var2 = 0; var2 < 2048; ++var2) {
                        cachedPlayers[var2] = null;
                     }

                     class224.localPlayer = null;

                     for(var2 = 0; var2 < cachedNPCs.length; ++var2) {
                        NPC var15 = cachedNPCs[var2];
                        if(var15 != null) {
                           var15.interacting = -1;
                           var15.field1219 = false;
                        }
                     }

                     XItemContainer.itemContainers = new XHashTable(32);
                     class2.setGameState(30);

                     for(var2 = 0; var2 < 100; ++var2) {
                        field1088[var2] = true;
                     }

                     secretPacketBuffer1.putOpcode(197);
                     secretPacketBuffer1.putByte(class10.method52());
                     secretPacketBuffer1.putShort(class31.canvasWidth);
                     secretPacketBuffer1.putShort(class67.canvasHeight);
                     class95.initializeGPI(secretPacketBuffer2);
                     if(var1 != secretPacketBuffer2.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var10) {
         if(field928 < 1) {
            if(class229.field3149 == class56.myWorldPort) {
               class56.myWorldPort = class11.field254;
            } else {
               class56.myWorldPort = class229.field3149;
            }

            ++field928;
            loginState = 0;
         } else {
            WorldMapType1.method269(-2);
         }
      }
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1121544107"
   )
   final void method1181() {
      if(field908 > 1) {
         --field908;
      }

      if(field946 > 0) {
         --field946;
      }

      if(socketError) {
         socketError = false;
         if(field946 > 0) {
            class51.method792();
         } else {
            class2.setGameState(40);
            NPC.field1339 = CacheFile.rssocket;
            CacheFile.rssocket = null;
         }

      } else {
         if(!isMenuOpen) {
            menuOptionCount = 0;
            isMenuOpen = false;
            menuOptions[0] = "Cancel";
            menuTargets[0] = "";
            menuTypes[0] = 1006;
            field1013[0] = false;
            menuOptionCount = 1;
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.processServerPacket(); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(true) {
               ClassInfo var2 = (ClassInfo)class280.field3735.method3581();
               boolean var29;
               if(var2 == null) {
                  var29 = false;
               } else {
                  var29 = true;
               }

               int var15;
               if(!var29) {
                  Object var14 = class88.field1364.field839;
                  int var3;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  synchronized(class88.field1364.field839) {
                     if(!field958) {
                        class88.field1364.field837 = 0;
                     } else if(MouseInput.field697 != 0 || class88.field1364.field837 >= 40) {
                        secretPacketBuffer1.putOpcode(143);
                        secretPacketBuffer1.putByte(0);
                        var15 = secretPacketBuffer1.offset;
                        var3 = 0;

                        for(var4 = 0; var4 < class88.field1364.field837 && secretPacketBuffer1.offset - var15 < 240; ++var4) {
                           ++var3;
                           var5 = class88.field1364.field841[var4];
                           if(var5 < 0) {
                              var5 = 0;
                           } else if(var5 > 502) {
                              var5 = 502;
                           }

                           var6 = class88.field1364.field838[var4];
                           if(var6 < 0) {
                              var6 = 0;
                           } else if(var6 > 764) {
                              var6 = 764;
                           }

                           var7 = var5 * 765 + var6;
                           if(class88.field1364.field841[var4] == -1 && class88.field1364.field838[var4] == -1) {
                              var6 = -1;
                              var5 = -1;
                              var7 = 524287;
                           }

                           if(var6 == field967 && var5 == field987) {
                              if(field905 < 2047) {
                                 ++field905;
                              }
                           } else {
                              var8 = var6 - field967;
                              field967 = var6;
                              var9 = var5 - field987;
                              field987 = var5;
                              if(field905 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                                 var8 += 32;
                                 var9 += 32;
                                 secretPacketBuffer1.putShort(var9 + (field905 << 12) + (var8 << 6));
                                 field905 = 0;
                              } else if(field905 < 8) {
                                 secretPacketBuffer1.put24bitInt((field905 << 19) + var7 + 8388608);
                                 field905 = 0;
                              } else {
                                 secretPacketBuffer1.putInt((field905 << 19) + var7 + -1073741824);
                                 field905 = 0;
                              }
                           }
                        }

                        secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var15);
                        if(var3 >= class88.field1364.field837) {
                           class88.field1364.field837 = 0;
                        } else {
                           class88.field1364.field837 -= var3;

                           for(var4 = 0; var4 < class88.field1364.field837; ++var4) {
                              class88.field1364.field838[var4] = class88.field1364.field838[var4 + var3];
                              class88.field1364.field841[var4] = class88.field1364.field841[var3 + var4];
                           }
                        }
                     }
                  }

                  if(MouseInput.field697 == 1 || !class67.field792 && MouseInput.field697 == 4 || MouseInput.field697 == 2) {
                     long var16 = (MouseInput.field714 - field1024) / 50L;
                     if(var16 > 4095L) {
                        var16 = 4095L;
                     }

                     field1024 = MouseInput.field714;
                     var3 = MouseInput.field713;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > class67.canvasHeight) {
                        var3 = class67.canvasHeight;
                     }

                     var4 = MouseInput.field709;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > class31.canvasWidth) {
                        var4 = class31.canvasWidth;
                     }

                     var5 = (int)var16;
                     secretPacketBuffer1.putOpcode(208);
                     secretPacketBuffer1.putShort((MouseInput.field697 == 2?1:0) + (var5 << 1));
                     secretPacketBuffer1.putShort(var4);
                     secretPacketBuffer1.putShort(var3);
                  }

                  if(KeyFocusListener.field611 > 0) {
                     secretPacketBuffer1.putOpcode(246);
                     secretPacketBuffer1.putShort(0);
                     var1 = secretPacketBuffer1.offset;
                     long var18 = BuildType.currentTimeMs();

                     for(var4 = 0; var4 < KeyFocusListener.field611; ++var4) {
                        long var20 = var18 - field1108;
                        if(var20 > 16777215L) {
                           var20 = 16777215L;
                        }

                        field1108 = var18;
                        secretPacketBuffer1.method3296((int)var20);
                        secretPacketBuffer1.method3226(KeyFocusListener.field617[var4]);
                     }

                     secretPacketBuffer1.putShortLength(secretPacketBuffer1.offset - var1);
                  }

                  if(field973 > 0) {
                     --field973;
                  }

                  if(KeyFocusListener.field604[96] || KeyFocusListener.field604[97] || KeyFocusListener.field604[98] || KeyFocusListener.field604[99]) {
                     field1139 = true;
                  }

                  if(field1139 && field973 <= 0) {
                     field973 = 20;
                     field1139 = false;
                     secretPacketBuffer1.putOpcode(11);
                     secretPacketBuffer1.putShortLE(mapAngle);
                     secretPacketBuffer1.putShortLE(field977);
                  }

                  if(class175.field2380 && !field916) {
                     field916 = true;
                     secretPacketBuffer1.putOpcode(112);
                     secretPacketBuffer1.putByte(1);
                  }

                  if(!class175.field2380 && field916) {
                     field916 = false;
                     secretPacketBuffer1.putOpcode(112);
                     secretPacketBuffer1.putByte(0);
                  }

                  CombatInfo1.method1554();
                  if(gameState != 30) {
                     return;
                  }

                  for(PendingSpawn var34 = (PendingSpawn)pendingSpawns.getFront(); var34 != null; var34 = (PendingSpawn)pendingSpawns.getNext()) {
                     if(var34.hitpoints > 0) {
                        --var34.hitpoints;
                     }

                     ObjectComposition var22;
                     boolean var37;
                     if(var34.hitpoints == 0) {
                        if(var34.field1177 >= 0) {
                           var3 = var34.field1177;
                           var4 = var34.field1166;
                           var22 = WidgetNode.getObjectDefinition(var3);
                           if(var4 == 11) {
                              var4 = 10;
                           }

                           if(var4 >= 5 && var4 <= 8) {
                              var4 = 4;
                           }

                           var37 = var22.method4496(var4);
                           if(!var37) {
                              continue;
                           }
                        }

                        XItemContainer.method1100(var34.level, var34.type, var34.x, var34.y, var34.field1177, var34.field1168, var34.field1166);
                        var34.unlink();
                     } else {
                        if(var34.delay > 0) {
                           --var34.delay;
                        }

                        if(var34.delay == 0 && var34.x >= 1 && var34.y >= 1 && var34.x <= 102 && var34.y <= 102) {
                           if(var34.id >= 0) {
                              var3 = var34.id;
                              var4 = var34.field1163;
                              var22 = WidgetNode.getObjectDefinition(var3);
                              if(var4 == 11) {
                                 var4 = 10;
                              }

                              if(var4 >= 5 && var4 <= 8) {
                                 var4 = 4;
                              }

                              var37 = var22.method4496(var4);
                              if(!var37) {
                                 continue;
                              }
                           }

                           XItemContainer.method1100(var34.level, var34.type, var34.x, var34.y, var34.id, var34.orientation, var34.field1163);
                           var34.delay = -1;
                           if(var34.field1177 == var34.id && var34.field1177 == -1) {
                              var34.unlink();
                           } else if(var34.id == var34.field1177 && var34.field1168 == var34.orientation && var34.field1163 == var34.field1166) {
                              var34.unlink();
                           }
                        }
                     }
                  }

                  for(var1 = 0; var1 < field1124; ++var1) {
                     --field1105[var1];
                     if(field1105[var1] >= -10) {
                        SoundEffect var30 = audioEffects[var1];
                        if(var30 == null) {
                           Object var10000 = null;
                           var30 = SoundEffect.getTrack(class207.field2555, field1089[var1], 0);
                           if(var30 == null) {
                              continue;
                           }

                           field1105[var1] += var30.calculateDelay();
                           audioEffects[var1] = var30;
                        }

                        if(field1105[var1] < 0) {
                           if(field1128[var1] != 0) {
                              var4 = (field1128[var1] & 255) * 128;
                              var5 = field1128[var1] >> 16 & 255;
                              var6 = 64 + var5 * 128 - class224.localPlayer.x;
                              if(var6 < 0) {
                                 var6 = -var6;
                              }

                              var7 = field1128[var1] >> 8 & 255;
                              var8 = var7 * 128 + 64 - class224.localPlayer.y;
                              if(var8 < 0) {
                                 var8 = -var8;
                              }

                              var9 = var8 + var6 - 128;
                              if(var9 > var4) {
                                 field1105[var1] = -100;
                                 continue;
                              }

                              if(var9 < 0) {
                                 var9 = 0;
                              }

                              var3 = (var4 - var9) * field1123 / var4;
                           } else {
                              var3 = field1125;
                           }

                           if(var3 > 0) {
                              class109 var23 = var30.method2001().method2049(CacheFile.field1539);
                              class119 var38 = class119.method2195(var23, 100, var3);
                              var38.method2198(field917[var1] - 1);
                              class2.field18.method1937(var38);
                           }

                           field1105[var1] = -100;
                        }
                     } else {
                        --field1124;

                        for(var15 = var1; var15 < field1124; ++var15) {
                           field1089[var15] = field1089[var15 + 1];
                           audioEffects[var15] = audioEffects[var15 + 1];
                           field917[var15] = field917[var15 + 1];
                           field1105[var15] = field1105[var15 + 1];
                           field1128[var15] = field1128[var15 + 1];
                        }

                        --var1;
                     }
                  }

                  if(field1121 && !class46.method699()) {
                     if(field1119 != 0 && field1069 != -1) {
                        class177.method3419(class2.indexTrack1, field1069, 0, field1119, false);
                     }

                     field1121 = false;
                  }

                  ++field941;
                  if(field941 > 750) {
                     if(field946 > 0) {
                        class51.method792();
                     } else {
                        class2.setGameState(40);
                        NPC.field1339 = CacheFile.rssocket;
                        CacheFile.rssocket = null;
                     }

                     return;
                  }

                  var1 = class96.field1470;
                  int[] var31 = class96.field1468;

                  for(var3 = 0; var3 < var1; ++var3) {
                     Player var40 = cachedPlayers[var31[var3]];
                     if(var40 != null) {
                        ChatLineBuffer.method1879(var40, 1);
                     }
                  }

                  KitDefinition.method4363();
                  int[] var35 = class96.field1468;

                  for(var15 = 0; var15 < class96.field1470; ++var15) {
                     Player var24 = cachedPlayers[var35[var15]];
                     if(var24 != null && var24.field1213 > 0) {
                        --var24.field1213;
                        if(var24.field1213 == 0) {
                           var24.overhead = null;
                        }
                     }
                  }

                  for(var15 = 0; var15 < field932; ++var15) {
                     var3 = npcIndices[var15];
                     NPC var42 = cachedNPCs[var3];
                     if(var42 != null && var42.field1213 > 0) {
                        --var42.field1213;
                        if(var42.field1213 == 0) {
                           var42.overhead = null;
                        }
                     }
                  }

                  ++field1078;
                  if(cursorState != 0) {
                     field1134 += 20;
                     if(field1134 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class27.field374 != null) {
                     ++field994;
                     if(field994 >= 15) {
                        class48.method732(class27.field374);
                        class27.field374 = null;
                     }
                  }

                  Widget var36 = class244.field3302;
                  Widget var32 = class89.field1372;
                  class244.field3302 = null;
                  class89.field1372 = null;
                  field1060 = null;
                  field1064 = false;
                  field1061 = false;
                  field1033 = 0;

                  while(class12.method71() && field1033 < 128) {
                     if(rights >= 2 && KeyFocusListener.field604[82] && DState.field2348 == 66) {
                        String var43 = "";

                        MessageNode var25;
                        for(Iterator var39 = class98.field1494.iterator(); var39.hasNext(); var43 = var43 + var25.name + ':' + var25.value + '\n') {
                           var25 = (MessageNode)var39.next();
                        }

                        Projectile.clientInstance.method858(var43);
                     } else {
                        field1107[field1033] = DState.field2348;
                        field1106[field1033] = class1.field8;
                        ++field1033;
                     }
                  }

                  if(widgetRoot != -1) {
                     class46.method665(widgetRoot, 0, 0, class31.canvasWidth, class67.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var41;
                     ScriptEvent var44;
                     Widget var45;
                     do {
                        var44 = (ScriptEvent)field974.popFront();
                        if(var44 == null) {
                           while(true) {
                              do {
                                 var44 = (ScriptEvent)field926.popFront();
                                 if(var44 == null) {
                                    while(true) {
                                       do {
                                          var44 = (ScriptEvent)field1082.popFront();
                                          if(var44 == null) {
                                             this.method1188();
                                             if(class7.renderOverview != null) {
                                                class7.renderOverview.method5202(class8.plane, (class224.localPlayer.x >> 7) + class33.baseX, (class224.localPlayer.y >> 7) + class17.baseY, false);
                                                class7.renderOverview.method5216();
                                             }

                                             if(field912 != null) {
                                                this.method1191();
                                             }

                                             if(class18.field307 != null) {
                                                class48.method732(class18.field307);
                                                ++field1047;
                                                if(MouseInput.field704 == 0) {
                                                   if(field923) {
                                                      if(class47.field564 == class18.field307 && field999 != field996) {
                                                         Widget var46 = class18.field307;
                                                         byte var33 = 0;
                                                         if(field1046 == 1 && var46.contentType == 206) {
                                                            var33 = 1;
                                                         }

                                                         if(var46.itemIds[field999] <= 0) {
                                                            var33 = 0;
                                                         }

                                                         if(Player.method1145(class169.getWidgetConfig(var46))) {
                                                            var5 = field996;
                                                            var6 = field999;
                                                            var46.itemIds[var6] = var46.itemIds[var5];
                                                            var46.itemQuantities[var6] = var46.itemQuantities[var5];
                                                            var46.itemIds[var5] = -1;
                                                            var46.itemQuantities[var5] = 0;
                                                         } else if(var33 == 1) {
                                                            var5 = field996;
                                                            var6 = field999;

                                                            while(var5 != var6) {
                                                               if(var5 > var6) {
                                                                  var46.method4007(var5 - 1, var5);
                                                                  --var5;
                                                               } else if(var5 < var6) {
                                                                  var46.method4007(var5 + 1, var5);
                                                                  ++var5;
                                                               }
                                                            }
                                                         } else {
                                                            var46.method4007(field999, field996);
                                                         }

                                                         secretPacketBuffer1.putOpcode(76);
                                                         secretPacketBuffer1.putShortLE(field996);
                                                         secretPacketBuffer1.method3227(var33);
                                                         secretPacketBuffer1.putInt(class18.field307.id);
                                                         secretPacketBuffer1.method3331(field999);
                                                      }
                                                   } else if(this.method1415()) {
                                                      this.method1315(field997, field998);
                                                   } else if(menuOptionCount > 0) {
                                                      var3 = field997;
                                                      var4 = field998;
                                                      class14.method78(class20.field317, var3, var4);
                                                      class20.field317 = null;
                                                   }

                                                   field994 = 10;
                                                   MouseInput.field697 = 0;
                                                   class18.field307 = null;
                                                } else if(field1047 >= 5 && (MouseInput.field696 > field997 + 5 || MouseInput.field696 < field997 - 5 || MouseInput.field705 > field998 + 5 || MouseInput.field705 < field998 - 5)) {
                                                   field923 = true;
                                                }
                                             }

                                             if(Region.method2739()) {
                                                var3 = Region.selectedRegionTileX;
                                                var4 = Region.selectedRegionTileY;
                                                secretPacketBuffer1.putOpcode(229);
                                                secretPacketBuffer1.putByte(5);
                                                secretPacketBuffer1.putLEInt(var4 + class17.baseY);
                                                secretPacketBuffer1.putShortLE(var3 + class33.baseX);
                                                secretPacketBuffer1.method3227(KeyFocusListener.field604[82]?(KeyFocusListener.field604[81]?2:1):0);
                                                Region.method2803();
                                                field1056 = MouseInput.field709;
                                                field1084 = MouseInput.field713;
                                                cursorState = 1;
                                                field1134 = 0;
                                                destinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(var36 != class244.field3302) {
                                                if(var36 != null) {
                                                   class48.method732(var36);
                                                }

                                                if(class244.field3302 != null) {
                                                   class48.method732(class244.field3302);
                                                }
                                             }

                                             if(var32 != class89.field1372 && field1087 == field1035) {
                                                if(var32 != null) {
                                                   class48.method732(var32);
                                                }

                                                if(class89.field1372 != null) {
                                                   class48.method732(class89.field1372);
                                                }
                                             }

                                             if(class89.field1372 != null) {
                                                if(field1087 < field1035) {
                                                   ++field1087;
                                                   if(field1035 == field1087) {
                                                      class48.method732(class89.field1372);
                                                   }
                                                }
                                             } else if(field1087 > 0) {
                                                --field1087;
                                             }

                                             var3 = class224.localPlayer.x;
                                             var4 = class224.localPlayer.y;
                                             if(class169.field2313 - var3 < -500 || class169.field2313 - var3 > 500 || CacheFile.field1535 - var4 < -500 || CacheFile.field1535 - var4 > 500) {
                                                class169.field2313 = var3;
                                                CacheFile.field1535 = var4;
                                             }

                                             if(var3 != class169.field2313) {
                                                class169.field2313 += (var3 - class169.field2313) / 16;
                                             }

                                             if(var4 != CacheFile.field1535) {
                                                CacheFile.field1535 += (var4 - CacheFile.field1535) / 16;
                                             }

                                             if(MouseInput.field704 == 4 && class67.field792) {
                                                var5 = MouseInput.field705 - field991;
                                                field1080 = var5 * 2;
                                                field991 = var5 != -1 && var5 != 1?(field991 + MouseInput.field705) / 2:MouseInput.field705;
                                                var6 = field970 - MouseInput.field696;
                                                field968 = var6 * 2;
                                                field970 = var6 != -1 && var6 != 1?(field970 + MouseInput.field696) / 2:MouseInput.field696;
                                             } else {
                                                if(KeyFocusListener.field604[96]) {
                                                   field968 += (-24 - field968) / 2;
                                                } else if(KeyFocusListener.field604[97]) {
                                                   field968 += (24 - field968) / 2;
                                                } else {
                                                   field968 /= 2;
                                                }

                                                if(KeyFocusListener.field604[98]) {
                                                   field1080 += (12 - field1080) / 2;
                                                } else if(KeyFocusListener.field604[99]) {
                                                   field1080 += (-12 - field1080) / 2;
                                                } else {
                                                   field1080 /= 2;
                                                }

                                                field991 = MouseInput.field705;
                                                field970 = MouseInput.field696;
                                             }

                                             mapAngle = field968 / 2 + mapAngle & 2047;
                                             field977 += field1080 / 2;
                                             if(field977 < 128) {
                                                field977 = 128;
                                             }

                                             if(field977 > 383) {
                                                field977 = 383;
                                             }

                                             var5 = class169.field2313 >> 7;
                                             var6 = CacheFile.field1535 >> 7;
                                             var7 = class18.getTileHeight(class169.field2313, CacheFile.field1535, class8.plane);
                                             var8 = 0;
                                             int var10;
                                             int var11;
                                             int var12;
                                             if(var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
                                                for(var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
                                                   for(var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                      var11 = class8.plane;
                                                      if(var11 < 3 && (class62.tileSettings[1][var9][var10] & 2) == 2) {
                                                         ++var11;
                                                      }

                                                      var12 = var7 - class62.tileHeights[var11][var9][var10];
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

                                             if(var9 > field975) {
                                                field975 += (var9 - field975) / 24;
                                             } else if(var9 < field975) {
                                                field975 += (var9 - field975) / 80;
                                             }

                                             if(field1130) {
                                                var3 = PlayerComposition.field2605 * 128 + 64;
                                                var4 = Actor.field1198 * 128 + 64;
                                                var5 = class18.getTileHeight(var3, var4, class8.plane) - class155.field2230;
                                                if(class89.cameraX < var3) {
                                                   class89.cameraX += class265.field3638 + (var3 - class89.cameraX) * ISAACCipher.field2402 / 1000;
                                                   if(class89.cameraX > var3) {
                                                      class89.cameraX = var3;
                                                   }
                                                }

                                                if(class89.cameraX > var3) {
                                                   class89.cameraX -= ISAACCipher.field2402 * (class89.cameraX - var3) / 1000 + class265.field3638;
                                                   if(class89.cameraX < var3) {
                                                      class89.cameraX = var3;
                                                   }
                                                }

                                                if(WallObject.cameraZ < var5) {
                                                   WallObject.cameraZ += (var5 - WallObject.cameraZ) * ISAACCipher.field2402 / 1000 + class265.field3638;
                                                   if(WallObject.cameraZ > var5) {
                                                      WallObject.cameraZ = var5;
                                                   }
                                                }

                                                if(WallObject.cameraZ > var5) {
                                                   WallObject.cameraZ -= ISAACCipher.field2402 * (WallObject.cameraZ - var5) / 1000 + class265.field3638;
                                                   if(WallObject.cameraZ < var5) {
                                                      WallObject.cameraZ = var5;
                                                   }
                                                }

                                                if(KeyFocusListener.cameraY < var4) {
                                                   KeyFocusListener.cameraY += (var4 - KeyFocusListener.cameraY) * ISAACCipher.field2402 / 1000 + class265.field3638;
                                                   if(KeyFocusListener.cameraY > var4) {
                                                      KeyFocusListener.cameraY = var4;
                                                   }
                                                }

                                                if(KeyFocusListener.cameraY > var4) {
                                                   KeyFocusListener.cameraY -= class265.field3638 + ISAACCipher.field2402 * (KeyFocusListener.cameraY - var4) / 1000;
                                                   if(KeyFocusListener.cameraY < var4) {
                                                      KeyFocusListener.cameraY = var4;
                                                   }
                                                }

                                                var3 = 64 + Varcs.field1491 * 128;
                                                var4 = 64 + class48.field577 * 128;
                                                var5 = class18.getTileHeight(var3, var4, class8.plane) - class21.field326;
                                                var6 = var3 - class89.cameraX;
                                                var7 = var5 - WallObject.cameraZ;
                                                var8 = var4 - KeyFocusListener.cameraY;
                                                var9 = (int)Math.sqrt((double)(var8 * var8 + var6 * var6));
                                                var10 = (int)(Math.atan2((double)var7, (double)var9) * 325.949D) & 2047;
                                                var11 = (int)(Math.atan2((double)var6, (double)var8) * -325.949D) & 2047;
                                                if(var10 < 128) {
                                                   var10 = 128;
                                                }

                                                if(var10 > 383) {
                                                   var10 = 383;
                                                }

                                                if(cameraPitch < var10) {
                                                   cameraPitch += class34.field466 + (var10 - cameraPitch) * class46.field559 / 1000;
                                                   if(cameraPitch > var10) {
                                                      cameraPitch = var10;
                                                   }
                                                }

                                                if(cameraPitch > var10) {
                                                   cameraPitch -= class46.field559 * (cameraPitch - var10) / 1000 + class34.field466;
                                                   if(cameraPitch < var10) {
                                                      cameraPitch = var10;
                                                   }
                                                }

                                                var12 = var11 - ScriptState.cameraYaw;
                                                if(var12 > 1024) {
                                                   var12 -= 2048;
                                                }

                                                if(var12 < -1024) {
                                                   var12 += 2048;
                                                }

                                                if(var12 > 0) {
                                                   ScriptState.cameraYaw = var12 * class46.field559 / 1000 + ScriptState.cameraYaw + class34.field466;
                                                   ScriptState.cameraYaw &= 2047;
                                                }

                                                if(var12 < 0) {
                                                   ScriptState.cameraYaw -= -var12 * class46.field559 / 1000 + class34.field466;
                                                   ScriptState.cameraYaw &= 2047;
                                                }

                                                int var13 = var11 - ScriptState.cameraYaw;
                                                if(var13 > 1024) {
                                                   var13 -= 2048;
                                                }

                                                if(var13 < -1024) {
                                                   var13 += 2048;
                                                }

                                                if(var13 < 0 && var12 > 0 || var13 > 0 && var12 < 0) {
                                                   ScriptState.cameraYaw = var11;
                                                }
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field1093[var3];
                                             }

                                             class51.chatMessages.process();
                                             var3 = class10.method53();
                                             var4 = KeyFocusListener.keyboardIdleTicks;
                                             if(var3 > 15000 && var4 > 15000) {
                                                field946 = 250;
                                                ScriptVarType.method18(14500);
                                                secretPacketBuffer1.putOpcode(98);
                                             }

                                             for(class67 var47 = (class67)field1152.method3652(); var47 != null; var47 = (class67)field1152.method3657()) {
                                                if((long)var47.field798 < BuildType.currentTimeMs() / 1000L - 5L) {
                                                   if(var47.field793 > 0) {
                                                      class202.sendGameMessage(5, "", var47.field800 + " has logged in.");
                                                   }

                                                   if(var47.field793 == 0) {
                                                      class202.sendGameMessage(5, "", var47.field800 + " has logged out.");
                                                   }

                                                   var47.method3661();
                                                }
                                             }

                                             ++audioEffectCount;
                                             if(audioEffectCount > 50) {
                                                secretPacketBuffer1.putOpcode(181);
                                             }

                                             try {
                                                if(CacheFile.rssocket != null && secretPacketBuffer1.offset > 0) {
                                                   CacheFile.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
                                                   secretPacketBuffer1.offset = 0;
                                                   audioEffectCount = 0;
                                                }
                                             } catch (IOException var27) {
                                                if(field946 > 0) {
                                                   class51.method792();
                                                } else {
                                                   class2.setGameState(40);
                                                   NPC.field1339 = CacheFile.rssocket;
                                                   CacheFile.rssocket = null;
                                                }
                                             }

                                             return;
                                          }

                                          var45 = var44.widget;
                                          if(var45.index < 0) {
                                             break;
                                          }

                                          var41 = WallObject.method2901(var45.parentId);
                                       } while(var41 == null || var41.children == null || var45.index >= var41.children.length || var45 != var41.children[var45.index]);

                                       Ignore.method1126(var44);
                                    }
                                 }

                                 var45 = var44.widget;
                                 if(var45.index < 0) {
                                    break;
                                 }

                                 var41 = WallObject.method2901(var45.parentId);
                              } while(var41 == null || var41.children == null || var45.index >= var41.children.length || var45 != var41.children[var45.index]);

                              Ignore.method1126(var44);
                           }
                        }

                        var45 = var44.widget;
                        if(var45.index < 0) {
                           break;
                        }

                        var41 = WallObject.method2901(var45.parentId);
                     } while(var41 == null || var41.children == null || var45.index >= var41.children.length || var45 != var41.children[var45.index]);

                     Ignore.method1126(var44);
                  }
               }

               secretPacketBuffer1.putOpcode(172);
               secretPacketBuffer1.putByte(0);
               var15 = secretPacketBuffer1.offset;
               XClanMember.encodeClassVerifier(secretPacketBuffer1);
               secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var15);
            }
         }
      }
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(Lhn;I)V",
      garbageValue = "-274837000"
   )
   void method1393(Widget var1) {
      Widget var2 = var1.parentId == -1?null:WallObject.method2901(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = class31.canvasWidth;
         var4 = class67.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class152.method2947(var1, var3, var4, false);
      class134.method2600(var1, var3, var4);
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   final void method1188() {
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
               boolean var6 = field1013[var2];
               field1013[var2] = field1013[var2 + 1];
               field1013[var2 + 1] = var6;
               var1 = false;
            }
         }
      }

      if(class18.field307 == null) {
         if(field912 == null) {
            int var13 = MouseInput.field697;
            int var8;
            int var9;
            int var11;
            int var14;
            if(isMenuOpen) {
               int var10;
               if(var13 != 1 && (class67.field792 || var13 != 4)) {
                  var2 = MouseInput.field696;
                  var10 = MouseInput.field705;
                  if(var2 < class14.menuX - 10 || var2 > class14.menuX + class12.menuWidth + 10 || var10 < DynamicObject.menuY - 10 || var10 > DynamicObject.menuY + class14.menuHeight + 10) {
                     isMenuOpen = false;
                     class15.method89(class14.menuX, DynamicObject.menuY, class12.menuWidth, class14.menuHeight);
                  }
               }

               if(var13 == 1 || !class67.field792 && var13 == 4) {
                  var2 = class14.menuX;
                  var10 = DynamicObject.menuY;
                  var11 = class12.menuWidth;
                  var5 = MouseInput.field709;
                  var14 = MouseInput.field713;
                  int var7 = -1;

                  for(var8 = 0; var8 < menuOptionCount; ++var8) {
                     var9 = (menuOptionCount - 1 - var8) * 15 + var10 + 31;
                     if(var5 > var2 && var5 < var11 + var2 && var14 > var9 - 13 && var14 < var9 + 3) {
                        var7 = var8;
                     }
                  }

                  if(var7 != -1) {
                     class5.method13(var7);
                  }

                  isMenuOpen = false;
                  class15.method89(class14.menuX, DynamicObject.menuY, class12.menuWidth, class14.menuHeight);
               }
            } else {
               var2 = menuOptionCount - 1;
               if((var13 == 1 || !class67.field792 && var13 == 4) && var2 >= 0) {
                  var11 = menuTypes[var2];
                  if(var11 == 39 || var11 == 40 || var11 == 41 || var11 == 42 || var11 == 43 || var11 == 33 || var11 == 34 || var11 == 35 || var11 == 36 || var11 == 37 || var11 == 38 || var11 == 1005) {
                     var5 = menuActionParams0[var2];
                     var14 = menuActionParams1[var2];
                     Widget var12 = WallObject.method2901(var14);
                     if(class155.method2983(class169.getWidgetConfig(var12)) || Player.method1145(class169.getWidgetConfig(var12))) {
                        if(class18.field307 != null && !field923 && menuOptionCount > 0 && !this.method1415()) {
                           var8 = field997;
                           var9 = field998;
                           class14.method78(class20.field317, var8, var9);
                           class20.field317 = null;
                        }

                        field923 = false;
                        field1047 = 0;
                        if(class18.field307 != null) {
                           class48.method732(class18.field307);
                        }

                        class18.field307 = WallObject.method2901(var14);
                        field996 = var5;
                        field997 = MouseInput.field709;
                        field998 = MouseInput.field713;
                        if(var2 >= 0) {
                           class20.field317 = new class89();
                           class20.field317.field1373 = menuActionParams0[var2];
                           class20.field317.field1366 = menuActionParams1[var2];
                           class20.field317.field1367 = menuTypes[var2];
                           class20.field317.field1371 = menuIdentifiers[var2];
                           class20.field317.field1369 = menuOptions[var2];
                        }

                        class48.method732(class18.field307);
                        return;
                     }
                  }
               }

               if((var13 == 1 || !class67.field792 && var13 == 4) && this.method1415()) {
                  var13 = 2;
               }

               if((var13 == 1 || !class67.field792 && var13 == 4) && menuOptionCount > 0) {
                  class5.method13(var2);
               }

               if(var13 == 2 && menuOptionCount > 0) {
                  this.method1315(MouseInput.field709, MouseInput.field713);
               }
            }

         }
      }
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-353918882"
   )
   final void method1191() {
      class48.method732(field912);
      ++Enum.field3384;
      if(field1064 && field1061) {
         int var1 = MouseInput.field696;
         int var2 = MouseInput.field705;
         var1 -= field1073;
         var2 -= field1063;
         if(var1 < field1062) {
            var1 = field1062;
         }

         if(var1 + field912.width > field1062 + field1057.width) {
            var1 = field1062 + field1057.width - field912.width;
         }

         if(var2 < field943) {
            var2 = field943;
         }

         if(var2 + field912.height > field943 + field1057.height) {
            var2 = field943 + field1057.height - field912.height;
         }

         int var3 = var1 - field1065;
         int var4 = var2 - field942;
         int var5 = field912.field2709;
         if(Enum.field3384 > field912.field2706 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1067 = true;
         }

         int var6 = var1 - field1062 + field1057.scrollX;
         int var7 = var2 - field943 + field1057.scrollY;
         ScriptEvent var8;
         if(field912.field2718 != null && field1067) {
            var8 = new ScriptEvent();
            var8.widget = field912;
            var8.field813 = var6;
            var8.field814 = var7;
            var8.field818 = field912.field2718;
            Ignore.method1126(var8);
         }

         if(MouseInput.field704 == 0) {
            if(field1067) {
               if(field912.field2719 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field912;
                  var8.field813 = var6;
                  var8.field814 = var7;
                  var8.field821 = field1060;
                  var8.field818 = field912.field2719;
                  Ignore.method1126(var8);
               }

               if(field1060 != null && class3.method6(field912) != null) {
                  secretPacketBuffer1.putOpcode(148);
                  secretPacketBuffer1.putShortLE(field912.itemId);
                  secretPacketBuffer1.putShort(field1060.itemId);
                  secretPacketBuffer1.putLEInt(field1060.index);
                  secretPacketBuffer1.method3241(field1060.id);
                  secretPacketBuffer1.method3241(field912.id);
                  secretPacketBuffer1.method3331(field912.index);
               }
            } else if(this.method1415()) {
               this.method1315(field1073 + field1065, field1063 + field942);
            } else if(menuOptionCount > 0) {
               int var10 = field1065 + field1073;
               int var9 = field942 + field1063;
               class14.method78(class20.field317, var10, var9);
               class20.field317 = null;
            }

            field912 = null;
         }

      } else {
         if(Enum.field3384 > 1) {
            field912 = null;
         }

      }
   }

   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = new Parameters[]{Parameters.field3700, Parameters.field3705, Parameters.field3702, Parameters.field3708, Parameters.field3707, Parameters.field3703, Parameters.field3709, Parameters.field3713, Parameters.field3699, Parameters.field3704, Parameters.field3706, Parameters.field3710, Parameters.field3712, Parameters.field3701, Parameters.field3711};
         Parameters[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            Parameters var4 = var2[var3];
            String var5 = this.getParameter(var4.key);
            if(var5 != null) {
               switch(Integer.parseInt(var4.key)) {
               case 1:
                  class251.field3368 = var5;
                  break;
               case 2:
                  class232[] var15 = new class232[]{class232.field3172, class232.field3176, class232.field3178, class232.field3179, class232.field3175, class232.field3173};
                  field1110 = (class232)CollisionData.forOrdinal(var15, Integer.parseInt(var5));
                  if(field1110 == class232.field3176) {
                     MouseInput.field715 = class289.field3844;
                  } else {
                     MouseInput.field715 = class289.field3843;
                  }
                  break;
               case 3:
                  socketType = Integer.parseInt(var5);
               case 4:
               case 9:
               default:
                  break;
               case 5:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 6:
                  flags = Integer.parseInt(var5);
                  break;
               case 7:
                  class67.field794 = Integer.parseInt(var5);
                  break;
               case 8:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 10:
                  class5.field34 = Integer.parseInt(var5);
                  break;
               case 11:
                  int var7 = Integer.parseInt(var5);
                  BuildType[] var8 = class17.method120();
                  int var9 = 0;

                  BuildType var6;
                  while(true) {
                     if(var9 >= var8.length) {
                        var6 = null;
                        break;
                     }

                     BuildType var10 = var8[var9];
                     if(var7 == var10.ordinal) {
                        var6 = var10;
                        break;
                     }

                     ++var9;
                  }

                  WorldMapType1.field415 = var6;
                  break;
               case 12:
                  world = Integer.parseInt(var5);
                  break;
               case 13:
                  WorldMapType3.sessionToken = var5;
                  break;
               case 14:
                  languageId = Integer.parseInt(var5);
               }
            }
         }

         Region.lowMemory = false;
         lowMemory = false;
         class1.host = this.getCodeBase().getHost();
         String var14 = WorldMapType1.field415.identifier;
         byte var11 = 0;

         try {
            class8.method40("oldschool", var14, var11, 17);
         } catch (Exception var13) {
            class23.method165((String)null, var13);
         }

         Projectile.clientInstance = this;
         this.initialize(765, 503, 151);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "1600421345"
   )
   static int method1272(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class83.intStack[--class83.intStackSize];
         var4 = WallObject.method2901(var3);
      } else {
         var4 = var2?class214.field2615:class73.field851;
      }

      if(var0 == 1000) {
         class83.intStackSize -= 4;
         var4.originalX = class83.intStack[class83.intStackSize];
         var4.originalY = class83.intStack[class83.intStackSize + 1];
         var4.field2634 = class83.intStack[class83.intStackSize + 2];
         var4.field2696 = class83.intStack[class83.intStackSize + 3];
         class48.method732(var4);
         Projectile.clientInstance.method1393(var4);
         if(var3 != -1 && var4.type == 0) {
            WorldListFetcher.method1530(class170.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class83.intStackSize -= 4;
         var4.originalWidth = class83.intStack[class83.intStackSize];
         var4.field2641 = class83.intStack[class83.intStackSize + 1];
         var4.field2737 = class83.intStack[class83.intStackSize + 2];
         var4.buttonType = class83.intStack[class83.intStackSize + 3];
         class48.method732(var4);
         Projectile.clientInstance.method1393(var4);
         if(var3 != -1 && var4.type == 0) {
            WorldListFetcher.method1530(class170.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class83.intStack[--class83.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class48.method732(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2681 = class83.intStack[--class83.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2763 = class83.intStack[--class83.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }
}
