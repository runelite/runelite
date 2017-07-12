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
   @ObfuscatedName("ag")
   static boolean field974;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -1717334073
   )
   static int field942;
   @ObfuscatedName("bc")
   static class232 field1207;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 2103267763
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 666429679
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("la")
   static Widget field1100;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -1200562601
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -134168631
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -65787909
   )
   @Export("gameState")
   @Hook("gameStateChanged")
   static int gameState;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = 160813165
   )
   static int field959;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -1173019241
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1816222573
   )
   @Export("world")
   static int world;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -835851787
   )
   static int field978;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = -251951651
   )
   static int field1061;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = 1834022629
   )
   static int field1131;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      longValue = 5292899068453965093L
   )
   static long field1140;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -1909317803
   )
   static int field955;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1145797937
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("dj")
   static Task field1157;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -567562277
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("jl")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("mv")
   static boolean[] field1132;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -690092307
   )
   @Export("packetType")
   static int packetType;
   @ObfuscatedName("ml")
   static boolean[] field1030;
   @ObfuscatedName("ma")
   static boolean[] field1133;
   @ObfuscatedName("jh")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 1738349315
   )
   static int field1076;
   @ObfuscatedName("ke")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("lh")
   static boolean field1176;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = -1590766769
   )
   @Export("secondLastFrameId")
   static int secondLastFrameId;
   @ObfuscatedName("bv")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("en")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = -374488129
   )
   @Export("packetLength")
   static int packetLength;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -1978901237
   )
   static int field1003;
   @ObfuscatedName("ex")
   @Export("secretPacketBuffer2")
   static PacketBuffer secretPacketBuffer2;
   @ObfuscatedName("lf")
   static boolean field1069;
   @ObfuscatedName("kj")
   static boolean field1075;
   @ObfuscatedName("bt")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("ng")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("jk")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 1739316727
   )
   @Export("thridLastFrameId")
   static int thridLastFrameId;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -2017794749
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 1430816639
   )
   static int field956;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = -587991875
   )
   static int field958;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = 1062808217
   )
   static int field1074;
   @ObfuscatedName("oj")
   static boolean field1014;
   @ObfuscatedName("lw")
   static boolean field1097;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = 552196973
   )
   static int field1064;
   @ObfuscatedName("bm")
   static boolean field934;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = 1406142281
   )
   static int field1102;
   @ObfuscatedName("jb")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -2116005485
   )
   static int field1103;
   @ObfuscatedName("jj")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      longValue = 167538832964274053L
   )
   static long field936;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = -1133397171
   )
   static int field1175;
   @ObfuscatedName("ef")
   @Export("secretPacketBuffer1")
   static PacketBuffer secretPacketBuffer1;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -347494989
   )
   static int field1130;
   @ObfuscatedName("mx")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 2121802623
   )
   static int field953;
   @ObfuscatedName("jz")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 700114361
   )
   static int field1104;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1908360401
   )
   static int field939;
   @ObfuscatedName("lo")
   static Widget field1101;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = -1349577323
   )
   static int field1083;
   @ObfuscatedName("bn")
   static boolean field1090;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 2133800363
   )
   static int field1002;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = -2103423627
   )
   @Export(
      value = "gameDrawingMode",
      setter = true
   )
   static int gameDrawingMode;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = -1454127981
   )
   static int field982;
   @ObfuscatedName("bf")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("nl")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("kn")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("na")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 228207307
   )
   static int field983;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = 389946335
   )
   static int field1107;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = -1636667767
   )
   static int field1190;
   @ObfuscatedName("ji")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -2047564953
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 590999603
   )
   static int field984;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -802317489
   )
   static int field943;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = -1152753709
   )
   static int field1034;
   @ObfuscatedName("ik")
   static boolean field1043;
   @ObfuscatedName("jc")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("rk")
   static final class73 field1204;
   @ObfuscatedName("kz")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -753932491
   )
   static int field944;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -991456099
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("je")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("lb")
   static Widget field1099;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = -1361753897
   )
   static int field1044;
   @ObfuscatedName("ny")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -741980333
   )
   static int field1183;
   @ObfuscatedName("nq")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -271962153
   )
   static int field967;
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
   @ObfuscatedName("br")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -739869949
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = 523061993
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("it")
   @Export("selectedItemName")
   static String selectedItemName;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("kd")
   static String field1078;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -1461405183
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1751580747
   )
   static int field980;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -113772529
   )
   static int field1040;
   @ObfuscatedName("ku")
   static String field1159;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = -106733151
   )
   static int field1041;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 601194655
   )
   static int field950;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = -1678707641
   )
   static int field1039;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -67336079
   )
   static int field1109;
   @ObfuscatedName("rw")
   static int[] field1205;
   @ObfuscatedName("rx")
   static int[] field1053;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = 107096801
   )
   static int field1163;
   @ObfuscatedName("ck")
   static class91 field1012;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 1611601913
   )
   static int field960;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = -1477020681
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("ch")
   static class91 field952;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = 1507969511
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 1431572451
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("mg")
   static Deque field1035;
   @ObfuscatedName("be")
   static class289 field928;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -1441305797
   )
   static int field973;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = -906210597
   )
   static int field1098;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = 1855739033
   )
   static int field1125;
   @ObfuscatedName("ll")
   static boolean field1111;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -55907845
   )
   @Export("lastFrameId")
   static int lastFrameId;
   @ObfuscatedName("dh")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 3163697
   )
   static int field1093;
   @ObfuscatedName("dq")
   static byte[] field961;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = 128619517
   )
   static int field937;
   @ObfuscatedName("py")
   static boolean field1173;
   @ObfuscatedName("du")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("pb")
   static boolean[] field1174;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -2094388453
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("do")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = -503828801
   )
   static int field1038;
   @ObfuscatedName("qs")
   static PlayerComposition field1198;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -1121258119
   )
   @Export("audioEffectCount")
   static int audioEffectCount;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = 581412713
   )
   static int field1208;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = -182413147
   )
   static int field1200;
   @ObfuscatedName("et")
   static PacketBuffer field969;
   @ObfuscatedName("lq")
   static Widget field1105;
   @ObfuscatedName("mq")
   static int[] field1113;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 1875929111
   )
   static int field975;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 1221457903
   )
   static int field1158;
   @ObfuscatedName("il")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = 1865936115
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("px")
   static int[] field1164;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = -784300341
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = -1680149971
   )
   static int field1016;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = -470184995
   )
   static int field1165;
   @ObfuscatedName("pk")
   static int[] field996;
   @ObfuscatedName("ri")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("qd")
   static int[] field1177;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -837516649
   )
   static int field957;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = 1663757081
   )
   static int field1112;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = -2002045201
   )
   static int field1181;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = 1517115953
   )
   static int field1121;
   @ObfuscatedName("ob")
   @ObfuscatedGetter(
      intValue = 1581907207
   )
   static int field1161;
   @ObfuscatedName("qc")
   static int[] field1178;
   @ObfuscatedName("pl")
   static int[] field1168;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = -92104077
   )
   static int field1193;
   @ObfuscatedName("ey")
   static HashMap field1134;
   @ObfuscatedName("hj")
   static boolean field1017;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 431894117
   )
   static int field1025;
   @ObfuscatedName("pp")
   static int[] field1169;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = 2121660935
   )
   static int field1124;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -1692805001
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = -933404277
   )
   static int field1004;
   @ObfuscatedName("ps")
   static int[] field1170;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = -678992705
   )
   static int field1110;
   @ObfuscatedName("fu")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("jp")
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("pu")
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 684176081
   )
   static int field1054;
   @ObfuscatedName("pt")
   static int[] field1171;
   @ObfuscatedName("ja")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = 1445870979
   )
   static int field1079;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 888152433
   )
   static int field1108;
   @ObfuscatedName("jo")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 1659439725
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      longValue = 7248468098182346983L
   )
   static long field925;
   @ObfuscatedName("jf")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -1013741015
   )
   static int field1056;
   @ObfuscatedName("kg")
   static Widget field1091;
   @ObfuscatedName("mk")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -1046211743
   )
   static int field1052;
   @ObfuscatedName("fy")
   static int[][][] field988;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = -1838856649
   )
   static int field1116;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = -13882777
   )
   static int field1162;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 1083794937
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("lg")
   static boolean field1096;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      intValue = -765737529
   )
   static int field1155;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 1464103407
   )
   static int field990;
   @ObfuscatedName("oe")
   static int[] field1156;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -830373883
   )
   static int field1114;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = 394066429
   )
   static int field1143;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = 1851423691
   )
   static int field1154;
   @ObfuscatedName("oo")
   static int[] field1011;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = -210047501
   )
   static int field1032;
   @ObfuscatedName("fd")
   static final int[] field989;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = 2108181969
   )
   static int field1072;
   @ObfuscatedName("or")
   static SpritePixels[] field927;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -574486665
   )
   static int field1135;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = 1573780963
   )
   static int field1049;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -311294849
   )
   static int field1033;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 48036581
   )
   static int field1006;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -2074568913
   )
   static int field993;
   @ObfuscatedName("hy")
   static int[][] field1058;
   @ObfuscatedName("nb")
   static long[] field1146;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = -182291421
   )
   static int field951;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -644956321
   )
   static int field995;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = -1332381313
   )
   static int field991;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = -945264169
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = -747449965
   )
   static int field1089;
   @ObfuscatedName("qh")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -1976237821
   )
   static int field1045;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 944782635
   )
   @Export("mapOffset")
   static int mapOffset;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = 1397302557
   )
   static int field1141;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = 46582019
   )
   static int field1147;
   @ObfuscatedName("jm")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -2102716331
   )
   static int field1000;
   @ObfuscatedName("jy")
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 1655412211
   )
   static int field1001;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = -340921381
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("qv")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("mj")
   static int[] field1117;
   @ObfuscatedName("rl")
   @ObfuscatedGetter(
      longValue = -2583683208705519181L
   )
   static long field1120;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -1077365635
   )
   static int field1005;
   @ObfuscatedName("qr")
   static short field1180;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = 299742685
   )
   static int field1067;
   @ObfuscatedName("qq")
   static short field1179;
   @ObfuscatedName("rp")
   @ObfuscatedGetter(
      longValue = -5809422450451253103L
   )
   static long field1203;
   @ObfuscatedName("gd")
   static boolean field1007;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = -1114668847
   )
   static int field1065;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -957114541
   )
   static int field1008;
   @ObfuscatedName("qp")
   static short field1185;
   @ObfuscatedName("qm")
   static short field1186;
   @ObfuscatedName("qn")
   static short field1184;
   @ObfuscatedName("qa")
   static short field1182;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = -1444692491
   )
   static int field1148;
   @ObfuscatedName("qk")
   static short field1126;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 853519289
   )
   static int field1050;
   @ObfuscatedName("qo")
   static short field1166;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -370053621
   )
   static int field1195;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = -1566749653
   )
   static int field1013;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -1213693803
   )
   static int field1055;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = -34843465
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -665921397
   )
   static int field997;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 404124949
   )
   static int field1015;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 564929087
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = -901419675
   )
   static int field1018;
   @ObfuscatedName("os")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("in")
   static int[] field1051;
   @ObfuscatedName("ov")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = -1656497923
   )
   static int field1046;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = -466278327
   )
   static int field1020;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = 992573133
   )
   static int field1037;
   @ObfuscatedName("hc")
   static int[] field1021;
   @ObfuscatedName("hv")
   static int[] field1022;
   @ObfuscatedName("hq")
   static int[] field1009;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = 1785808227
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = -269667163
   )
   static int field1187;
   @ObfuscatedName("hr")
   static int[] field1024;
   @ObfuscatedName("nx")
   static int[] field1150;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 650182341
   )
   static int field1188;
   @ObfuscatedName("mi")
   static Deque field1127;
   @ObfuscatedName("ha")
   static int[] field938;
   @ObfuscatedName("nj")
   static int[] field1149;
   @ObfuscatedName("mw")
   static Deque field1128;
   @ObfuscatedName("hl")
   static int[] field1151;
   @ObfuscatedName("hp")
   static int[] field1027;
   @ObfuscatedName("ju")
   static int[] field1123;
   @ObfuscatedName("hw")
   static String[] field1028;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 402388475
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = 855301949
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("qb")
   static class195 field1029;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = 2072301701
   )
   static int field1119;
   @ObfuscatedName("ka")
   static boolean field1073;
   @ObfuscatedName("nc")
   static String field1145;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -2077409537
   )
   static int field1042;
   @ObfuscatedName("jr")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("li")
   static boolean field1199;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -709374917
   )
   static int field1084;
   @ObfuscatedName("nz")
   static int[] field1142;

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

      class2.field16 = null;
      if(FrameMap.soundSystem0 != null) {
         FrameMap.soundSystem0.method2025();
      }

      if(MouseInput.soundSystem1 != null) {
         MouseInput.soundSystem1.method2025();
      }

      BuildType.method4105();
      Object var10 = class236.field3244;
      synchronized(class236.field3244) {
         if(class236.field3243 != 0) {
            class236.field3243 = 1;

            try {
               class236.field3244.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      class217.method4045();
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
      FileOnDisk var2 = null;
      Preferences var3 = new Preferences();

      int var5;
      try {
         var2 = class22.getPreferencesFile("", field1207.field3203, false);
         byte[] var4 = new byte[(int)var2.length()];

         int var6;
         for(var5 = 0; var5 < var4.length; var5 += var6) {
            var6 = var2.read(var4, var5, var4.length - var5);
            if(var6 == -1) {
               throw new IOException();
            }
         }

         var3 = new Preferences(new Buffer(var4));
      } catch (Exception var9) {
         ;
      }

      try {
         if(var2 != null) {
            var2.close();
         }
      } catch (Exception var8) {
         ;
      }

      class8.settings = var3;
      this.method909();
      String var10 = GameEngine.field735;
      class56.field699 = this;
      class56.field705 = var10;
      if(socketType != 0) {
         displayFps = true;
      }

      int var7 = class8.settings.screenType;
      field1140 = 0L;
      if(var7 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      var5 = isResized?2:1;
      if(var5 == 1) {
         class261.clientInstance.method869(765, 503);
      } else {
         class261.clientInstance.method869(7680, 2160);
      }

      if(gameState >= 25) {
         class5.method18();
      }

   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "2"
   )
   final void method1201(boolean var1) {
      WorldMapType3.method202(widgetRoot, class45.canvasWidth, CollisionData.canvasHeight, var1);
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

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1781341341"
   )
   protected final void vmethod1184() {
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
         String var19;
         int var20;
         try {
            int var1 = class244.rssocket.available();
            if(var1 == 0) {
               return false;
            }

            if(packetType == -1) {
               class244.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               packetLength = class272.field3709[packetType];
               --var1;
            }

            if(packetLength == -1) {
               if(var1 <= 0) {
                  return false;
               }

               class244.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               packetLength = secretPacketBuffer2.payload[0] & 255;
               --var1;
            }

            if(packetLength == -2) {
               if(var1 <= 1) {
                  return false;
               }

               class244.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();
               var1 -= 2;
            }

            if(var1 < packetLength) {
               return false;
            }

            secretPacketBuffer2.offset = 0;
            class244.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
            field973 = 0;
            thridLastFrameId = secondLastFrameId;
            secondLastFrameId = lastFrameId * -1;
            lastFrameId = packetType * -1;
            int var2;
            if(packetType == 51) {
               field1173 = false;

               for(var2 = 0; var2 < 5; ++var2) {
                  field1174[var2] = false;
               }

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

            if(packetType == 237) {
               for(var2 = 0; var2 < VarPlayerType.field3289; ++var2) {
                  VarPlayerType var106 = (VarPlayerType)VarPlayerType.varplayers.get((long)var2);
                  VarPlayerType var67;
                  if(var106 != null) {
                     var67 = var106;
                  } else {
                     byte[] var98 = VarPlayerType.varplayer_ref.getConfigData(16, var2);
                     var106 = new VarPlayerType();
                     if(var98 != null) {
                        var106.decode(new Buffer(var98));
                     }

                     VarPlayerType.varplayers.put(var106, (long)var2);
                     var67 = var106;
                  }

                  if(var67 != null) {
                     class211.settings[var2] = 0;
                     class211.widgetSettings[var2] = 0;
                  }
               }

               ScriptEvent.method1135();
               field975 += 32;
               packetType = -1;
               return true;
            }

            if(packetType == 118) {
               for(var2 = 0; var2 < class211.widgetSettings.length; ++var2) {
                  if(class211.widgetSettings[var2] != class211.settings[var2]) {
                     class211.widgetSettings[var2] = class211.settings[var2];
                     Preferences.method1614(var2);
                     field1113[++field975 - 1 & 31] = var2;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 247) {
               field1161 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == 75) {
               field942 = secretPacketBuffer2.readUnsignedShort() * 30;
               field1124 = field1112;
               packetType = -1;
               return true;
            }

            int var6;
            if(packetType == 239) {
               var20 = secretPacketBuffer2.readUnsignedByte();
               class276[] var104 = new class276[]{class276.field3739, class276.field3737, class276.field3740};
               class276[] var97 = var104;
               var6 = 0;

               class276 var85;
               while(true) {
                  if(var6 >= var97.length) {
                     var85 = null;
                     break;
                  }

                  class276 var107 = var97[var6];
                  if(var20 == var107.field3738) {
                     var85 = var107;
                     break;
                  }

                  ++var6;
               }

               class61.field787 = var85;
               packetType = -1;
               return true;
            }

            int var11;
            int var14;
            long var30;
            int var38;
            int var44;
            String var61;
            String var79;
            String var82;
            String var91;
            int var108;
            if(packetType == 155) {
               var19 = secretPacketBuffer2.readString();
               sessionToken = var19;

               try {
                  var61 = class261.clientInstance.getParameter(Parameters.field3719.key);
                  var82 = class261.clientInstance.getParameter(Parameters.field3732.key);
                  var91 = var61 + "settings=" + var19 + "; version=1; path=/; domain=" + var82;
                  String var105;
                  if(var19.length() == 0) {
                     var91 = var91 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var79 = var91 + "; Expires=";
                     var30 = DState.currentTimeMs() + 94608000000L;
                     class182.field2446.setTime(new Date(var30));
                     var108 = class182.field2446.get(7);
                     var11 = class182.field2446.get(5);
                     int var110 = class182.field2446.get(2);
                     var38 = class182.field2446.get(1);
                     var14 = class182.field2446.get(11);
                     int var50 = class182.field2446.get(12);
                     var44 = class182.field2446.get(13);
                     var105 = class182.field2443[var108 - 1] + ", " + var11 / 10 + var11 % 10 + "-" + class182.field2444[0][var110] + "-" + var38 + " " + var14 / 10 + var14 % 10 + ":" + var50 / 10 + var50 % 10 + ":" + var44 / 10 + var44 % 10 + " GMT";
                     var91 = var79 + var105 + "; Max-Age=" + 94608000L;
                  }

                  Client var88 = class261.clientInstance;
                  var105 = "document.cookie=\"" + var91 + "\"";
                  JSObject.getWindow(var88).eval(var105);
               } catch (Throwable var52) {
                  ;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 195) {
               var2 = secretPacketBuffer2.method3190();
               class20.field339 = GameEngine.taskManager.createHost(var2);
               packetType = -1;
               return true;
            }

            if(packetType == 207) {
               var2 = secretPacketBuffer2.readByteOb1();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               class266.method4842(var2);
               packetType = -1;
               return true;
            }

            if(packetType == 107) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               XItemContainer var65 = (XItemContainer)XItemContainer.itemContainers.get((long)var2);
               if(var65 != null) {
                  var65.unlink();
               }

               interfaceItemTriggers[++field1116 - 1 & 31] = var2 & 32767;
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

            int var4;
            Widget var63;
            if(packetType == 28) {
               var2 = secretPacketBuffer2.method3175();
               var63 = PacketBuffer.method3403(var2);

               for(var4 = 0; var4 < var63.itemIds.length; ++var4) {
                  var63.itemIds[var4] = -1;
                  var63.itemIds[var4] = 0;
               }

               class88.method1714(var63);
               packetType = -1;
               return true;
            }

            if(packetType == 136) {
               var2 = secretPacketBuffer2.method3190();
               var63 = PacketBuffer.method3403(var2);
               var63.modelType = 3;
               var63.modelId = XItemContainer.localPlayer.composition.method3938();
               class88.method1714(var63);
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

            if(packetType == 122) {
               ScriptEvent.method1135();
               weight = secretPacketBuffer2.readShort();
               field1124 = field1112;
               packetType = -1;
               return true;
            }

            if(packetType == 251) {
               Player.field900 = secretPacketBuffer2.readUnsignedByte();
               class29.field428 = secretPacketBuffer2.method3173();
               packetType = -1;
               return true;
            }

            if(packetType == 98) {
               field1143 = secretPacketBuffer2.readUnsignedByte();
               field1032 = secretPacketBuffer2.readUnsignedByte();
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

            if(packetType == 46) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var20 = secretPacketBuffer2.read24BitInt();
               if(field1162 != 0 && var2 != -1) {
                  class29.method232(XGrandExchangeOffer.indexTrack2, var2, 0, field1162, false);
                  field1014 = true;
               }

               packetType = -1;
               return true;
            }

            boolean var62;
            if(packetType == 95) {
               var62 = secretPacketBuffer2.readUnsignedByte() == 1;
               if(var62) {
                  class43.field599 = DState.currentTimeMs() - secretPacketBuffer2.readLong();
                  class66.field833 = new class13(secretPacketBuffer2, true);
               } else {
                  class66.field833 = null;
               }

               field1004 = field1112;
               packetType = -1;
               return true;
            }

            if(packetType == 174) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               if(secretPacketBuffer2.readUnsignedByte() == 0) {
                  grandExchangeOffers[var2] = new XGrandExchangeOffer();
                  secretPacketBuffer2.offset += 18;
               } else {
                  --secretPacketBuffer2.offset;
                  grandExchangeOffers[var2] = new XGrandExchangeOffer(secretPacketBuffer2, false);
               }

               field1110 = field1112;
               packetType = -1;
               return true;
            }

            if(packetType == 30) {
               var19 = secretPacketBuffer2.readString();
               PacketBuffer var101 = secretPacketBuffer2;

               try {
                  var6 = var101.getUSmart();
                  if(var6 > 32767) {
                     var6 = 32767;
                  }

                  byte[] var103 = new byte[var6];
                  var101.offset += class265.field3665.decompress(var101.payload, var101.offset, var103, 0, var6);
                  String var95 = class48.getString(var103, 0, var6);
                  var91 = var95;
               } catch (Exception var53) {
                  var91 = "Cabbage";
               }

               var91 = FontTypeFace.appendTags(FaceNormal.method2870(var91));
               class152.sendGameMessage(6, var19, var91);
               packetType = -1;
               return true;
            }

            Widget var87;
            if(packetType == 111) {
               var19 = secretPacketBuffer2.readString();
               var20 = secretPacketBuffer2.method3190();
               var87 = PacketBuffer.method3403(var20);
               if(!var19.equals(var87.text)) {
                  var87.text = var19;
                  class88.method1714(var87);
               }

               packetType = -1;
               return true;
            }

            int var5;
            int var7;
            if(packetType == 119) {
               var2 = secretPacketBuffer2.readInt();
               var20 = secretPacketBuffer2.readByteOb1();
               var4 = var20 >> 10 & 31;
               var5 = var20 >> 5 & 31;
               var6 = var20 & 31;
               var7 = (var5 << 11) + (var4 << 19) + (var6 << 3);
               Widget var94 = PacketBuffer.method3403(var2);
               if(var7 != var94.textColor) {
                  var94.textColor = var7;
                  class88.method1714(var94);
               }

               packetType = -1;
               return true;
            }

            boolean var96;
            if(packetType == 225) {
               var2 = secretPacketBuffer2.method3190();
               var96 = secretPacketBuffer2.method3173() == 1;
               var87 = PacketBuffer.method3403(var2);
               if(var96 != var87.isHidden) {
                  var87.isHidden = var96;
                  class88.method1714(var87);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 134) {
               var2 = secretPacketBuffer2.readIntOb3();
               var20 = secretPacketBuffer2.readShort();
               var87 = PacketBuffer.method3403(var2);
               if(var20 != var87.field2717 || var20 == -1) {
                  var87.field2717 = var20;
                  var87.field2788 = 0;
                  var87.field2777 = 0;
                  class88.method1714(var87);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 201) {
               var2 = secretPacketBuffer2.readIntOb3();
               var20 = secretPacketBuffer2.method3318();
               var87 = PacketBuffer.method3403(var2);
               if(var87.modelType != 2 || var20 != var87.modelId) {
                  var87.modelType = 2;
                  var87.modelId = var20;
                  class88.method1714(var87);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 24) {
               var2 = secretPacketBuffer2.readIntOb3();
               var20 = secretPacketBuffer2.readByteOb1();
               var87 = PacketBuffer.method3403(var2);
               if(var87.modelType != 1 || var20 != var87.modelId) {
                  var87.modelType = 1;
                  var87.modelId = var20;
                  class88.method1714(var87);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 243) {
               var2 = secretPacketBuffer2.readInt();
               var20 = secretPacketBuffer2.readUnsignedShort();
               var87 = PacketBuffer.method3403(var2);
               if(var87 != null && var87.type == 0) {
                  if(var20 > var87.scrollHeight - var87.height) {
                     var20 = var87.scrollHeight - var87.height;
                  }

                  if(var20 < 0) {
                     var20 = 0;
                  }

                  if(var20 != var87.scrollY) {
                     var87.scrollY = var20;
                     class88.method1714(var87);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 145) {
               class29.field428 = secretPacketBuffer2.method3324();
               Player.field900 = secretPacketBuffer2.readUnsignedByte();

               for(var2 = Player.field900; var2 < Player.field900 + 8; ++var2) {
                  for(var20 = class29.field428; var20 < class29.field428 + 8; ++var20) {
                     if(groundItemDeque[WallObject.plane][var2][var20] != null) {
                        groundItemDeque[WallObject.plane][var2][var20] = null;
                        Occluder.groundItemSpawned(var2, var20);
                     }
                  }
               }

               for(PendingSpawn var77 = (PendingSpawn)pendingSpawns.getFront(); var77 != null; var77 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var77.x >= Player.field900 && var77.x < Player.field900 + 8 && var77.y >= class29.field428 && var77.y < class29.field428 + 8 && var77.level == WallObject.plane) {
                     var77.hitpoints = 0;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 235) {
               byte var71 = secretPacketBuffer2.method3207();
               var20 = secretPacketBuffer2.method3318();
               class211.settings[var20] = var71;
               if(class211.widgetSettings[var20] != var71) {
                  class211.widgetSettings[var20] = var71;
               }

               Preferences.method1614(var20);
               field1113[++field975 - 1 & 31] = var20;
               packetType = -1;
               return true;
            }

            if(packetType == 105) {
               var2 = secretPacketBuffer2.readUnsignedShortOb1();
               var20 = secretPacketBuffer2.readIntOb3();
               class211.settings[var2] = var20;
               if(class211.widgetSettings[var2] != var20) {
                  class211.widgetSettings[var2] = var20;
               }

               Preferences.method1614(var2);
               field1113[++field975 - 1 & 31] = var2;
               packetType = -1;
               return true;
            }

            if(packetType == 21) {
               var2 = secretPacketBuffer2.method3173();
               var61 = secretPacketBuffer2.readString();
               var4 = secretPacketBuffer2.readUnsignedByte();
               if(var4 >= 1 && var4 <= 8) {
                  if(var61.equalsIgnoreCase("null")) {
                     var61 = null;
                  }

                  playerOptions[var4 - 1] = var61;
                  playerOptionsPriorities[var4 - 1] = var2 == 0;
               }

               packetType = -1;
               return true;
            }

            if(packetType != 56 && packetType != 58 && packetType != 202 && packetType != 82 && packetType != 63 && packetType != 92 && packetType != 97 && packetType != 44 && packetType != 194) {
               if(packetType == 41) {
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  var20 = secretPacketBuffer2.readUnsignedByte();
                  var4 = secretPacketBuffer2.readUnsignedShort();
                  class34.method356(var2, var20, var4);
                  packetType = -1;
                  return true;
               }

               Widget var92;
               if(packetType == 151) {
                  var2 = secretPacketBuffer2.readUnsignedShortOb1();
                  var20 = secretPacketBuffer2.method3190();
                  var4 = secretPacketBuffer2.method3318();
                  var92 = PacketBuffer.method3403(var20);
                  var92.field2710 = var4 + (var2 << 16);
                  packetType = -1;
                  return true;
               }

               if(packetType == 72) {
                  ScriptEvent.method1135();
                  var2 = secretPacketBuffer2.readInt();
                  var20 = secretPacketBuffer2.readUnsignedByte();
                  var4 = secretPacketBuffer2.method3173();
                  skillExperiences[var20] = var2;
                  boostedSkillLevels[var20] = var4;
                  realSkillLevels[var20] = 1;

                  for(var5 = 0; var5 < 98; ++var5) {
                     if(var2 >= class222.field2845[var5]) {
                        realSkillLevels[var20] = var5 + 2;
                     }
                  }

                  field1117[++field1067 - 1 & 31] = var20;
                  packetType = -1;
                  return true;
               }

               if(packetType == 141) {
                  var2 = secretPacketBuffer2.method3188();
                  var20 = secretPacketBuffer2.method3188();
                  var4 = secretPacketBuffer2.readInt();
                  var92 = PacketBuffer.method3403(var4);
                  if(var2 != var92.originalX || var20 != var92.originalY || var92.field2659 != 0 || var92.field2660 != 0) {
                     var92.originalX = var2;
                     var92.originalY = var20;
                     var92.field2659 = 0;
                     var92.field2660 = 0;
                     class88.method1714(var92);
                     this.method1343(var92);
                     if(var92.type == 0) {
                        WorldMapType2.method546(class46.widgets[var4 >> 16], var92, false);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 14) {
                  var2 = secretPacketBuffer2.readIntOb3();
                  var20 = secretPacketBuffer2.method3190();
                  var4 = secretPacketBuffer2.readUnsignedShort();
                  if(var4 == '\uffff') {
                     var4 = -1;
                  }

                  var92 = PacketBuffer.method3403(var2);
                  ItemComposition var86;
                  if(!var92.hasScript) {
                     if(var4 == -1) {
                        var92.modelType = 0;
                        packetType = -1;
                        return true;
                     }

                     var86 = AbstractByteBuffer.getItemDefinition(var4);
                     var92.modelType = 4;
                     var92.modelId = var4;
                     var92.rotationX = var86.xan2d;
                     var92.rotationZ = var86.yan2d;
                     var92.modelZoom = var86.zoom2d * 100 / var20;
                     class88.method1714(var92);
                  } else {
                     var92.itemId = var4;
                     var92.itemQuantity = var20;
                     var86 = AbstractByteBuffer.getItemDefinition(var4);
                     var92.rotationX = var86.xan2d;
                     var92.rotationZ = var86.yan2d;
                     var92.rotationY = var86.zan2d;
                     var92.field2703 = var86.offsetX2d;
                     var92.field2704 = var86.offsetY2d;
                     var92.modelZoom = var86.zoom2d;
                     if(var86.isStackable == 1) {
                        var92.field2784 = 1;
                     } else {
                        var92.field2784 = 2;
                     }

                     if(var92.field2709 > 0) {
                        var92.modelZoom = var92.modelZoom * 32 / var92.field2709;
                     } else if(var92.originalWidth > 0) {
                        var92.modelZoom = var92.modelZoom * 32 / var92.originalWidth;
                     }

                     class88.method1714(var92);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 200) {
                  var2 = secretPacketBuffer2.readUnsignedByte();
                  var20 = secretPacketBuffer2.readUnsignedByte();
                  var4 = secretPacketBuffer2.readUnsignedByte();
                  var5 = secretPacketBuffer2.readUnsignedByte();
                  field1174[var2] = true;
                  field1164[var2] = var20;
                  field996[var2] = var4;
                  field1177[var2] = var5;
                  field1178[var2] = 0;
                  packetType = -1;
                  return true;
               }

               if(packetType == 182) {
                  while(secretPacketBuffer2.offset < packetLength) {
                     var2 = secretPacketBuffer2.readUnsignedByte();
                     var96 = (var2 & 1) == 1;
                     var82 = secretPacketBuffer2.readString();
                     var91 = secretPacketBuffer2.readString();
                     secretPacketBuffer2.readString();

                     for(var6 = 0; var6 < ignoreCount; ++var6) {
                        Ignore var102 = ignores[var6];
                        if(var96) {
                           if(var91.equals(var102.name)) {
                              var102.name = var82;
                              var102.previousName = var91;
                              var82 = null;
                              break;
                           }
                        } else if(var82.equals(var102.name)) {
                           var102.name = var82;
                           var102.previousName = var91;
                           var82 = null;
                           break;
                        }
                     }

                     if(var82 != null && ignoreCount < 400) {
                        Ignore var83 = new Ignore();
                        ignores[ignoreCount] = var83;
                        var83.name = var82;
                        var83.previousName = var91;
                        ++ignoreCount;
                     }
                  }

                  field1025 = field1112;
                  packetType = -1;
                  return true;
               }

               int var8;
               boolean var64;
               boolean var66;
               if(packetType == 228) {
                  var19 = secretPacketBuffer2.readString();
                  var20 = secretPacketBuffer2.readUnsignedShort();
                  byte var69 = secretPacketBuffer2.readByte();
                  var64 = false;
                  if(var69 == -128) {
                     var64 = true;
                  }

                  if(var64) {
                     if(class28.clanChatCount == 0) {
                        packetType = -1;
                        return true;
                     }

                     var66 = false;

                     for(var6 = 0; var6 < class28.clanChatCount && (!class11.clanMembers[var6].username.equals(var19) || var20 != class11.clanMembers[var6].world); ++var6) {
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
                     XClanMember var81 = new XClanMember();
                     var81.username = var19;
                     var81.field919 = Player.method1179(var81.username, field928);
                     var81.world = var20;
                     var81.rank = var69;

                     for(var7 = class28.clanChatCount - 1; var7 >= 0; --var7) {
                        var8 = class11.clanMembers[var7].field919.compareTo(var81.field919);
                        if(var8 == 0) {
                           class11.clanMembers[var7].world = var20;
                           class11.clanMembers[var7].rank = var69;
                           if(var19.equals(XItemContainer.localPlayer.name)) {
                              class35.clanChatRank = var69;
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

                     class11.clanMembers[var7 + 1] = var81;
                     ++class28.clanChatCount;
                     if(var19.equals(XItemContainer.localPlayer.name)) {
                        class35.clanChatRank = var69;
                     }
                  }

                  field1121 = field1112;
                  packetType = -1;
                  return true;
               }

               if(packetType == 245) {
                  method1525();

                  for(var2 = 0; var2 < 2048; ++var2) {
                     cachedPlayers[var2] = null;
                  }

                  class17.initializeGPI(secretPacketBuffer2);
                  packetType = -1;
                  return true;
               }

               long var34;
               if(packetType == 248) {
                  var2 = secretPacketBuffer2.method3318();
                  if(var2 == '\uffff') {
                     var2 = -1;
                  }

                  var20 = secretPacketBuffer2.readByteOb1();
                  if(var20 == '\uffff') {
                     var20 = -1;
                  }

                  var4 = secretPacketBuffer2.method3190();
                  var5 = secretPacketBuffer2.readInt();

                  for(var6 = var2; var6 <= var20; ++var6) {
                     var34 = ((long)var5 << 32) + (long)var6;
                     Node var109 = widgetFlags.get(var34);
                     if(var109 != null) {
                        var109.unlink();
                     }

                     widgetFlags.put(new WidgetConfig(var4), var34);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 36) {
                  var2 = secretPacketBuffer2.getUSmart();
                  var96 = secretPacketBuffer2.readUnsignedByte() == 1;
                  var82 = "";
                  var64 = false;
                  if(var96) {
                     var82 = secretPacketBuffer2.readString();
                     if(class1.isIgnored(var82)) {
                        var64 = true;
                     }
                  }

                  var79 = secretPacketBuffer2.readString();
                  if(!var64) {
                     class152.sendGameMessage(var2, var82, var79);
                  }

                  packetType = -1;
                  return true;
               }

               Widget var21;
               if(packetType == 106) {
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  var20 = secretPacketBuffer2.readInt();
                  var4 = secretPacketBuffer2.readUnsignedShortOb1();
                  var5 = secretPacketBuffer2.method3318();
                  var21 = PacketBuffer.method3403(var20);
                  if(var2 != var21.rotationX || var4 != var21.rotationZ || var5 != var21.modelZoom) {
                     var21.rotationX = var2;
                     var21.rotationZ = var4;
                     var21.modelZoom = var5;
                     class88.method1714(var21);
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

               if(packetType == 229) {
                  field1173 = true;
                  class66.field832 = secretPacketBuffer2.readUnsignedByte();
                  ISAACCipher.field2438 = secretPacketBuffer2.readUnsignedByte();
                  IndexFile.field2289 = secretPacketBuffer2.readUnsignedShort();
                  class174.field2414 = secretPacketBuffer2.readUnsignedByte();
                  MilliTimer.field2223 = secretPacketBuffer2.readUnsignedByte();
                  if(MilliTimer.field2223 >= 100) {
                     var2 = class66.field832 * 128 + 64;
                     var20 = ISAACCipher.field2438 * 128 + 64;
                     var4 = WorldMapData.getTileHeight(var2, var20, WallObject.plane) - IndexFile.field2289;
                     var5 = var2 - class155.cameraX;
                     var6 = var4 - class60.cameraZ;
                     var7 = var20 - class157.cameraY;
                     var8 = (int)Math.sqrt((double)(var7 * var7 + var5 * var5));
                     Player.cameraPitch = (int)(Math.atan2((double)var6, (double)var8) * 325.949D) & 2047;
                     class22.cameraYaw = (int)(Math.atan2((double)var5, (double)var7) * -325.949D) & 2047;
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

               if(packetType == 124) {
                  var2 = secretPacketBuffer2.readInt();
                  var20 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 < -70000) {
                     var20 += '耀';
                  }

                  if(var2 >= 0) {
                     var87 = PacketBuffer.method3403(var2);
                  } else {
                     var87 = null;
                  }

                  if(var87 != null) {
                     for(var5 = 0; var5 < var87.itemIds.length; ++var5) {
                        var87.itemIds[var5] = 0;
                        var87.itemQuantities[var5] = 0;
                     }
                  }

                  class243.resetItemTable(var20);
                  var5 = secretPacketBuffer2.readUnsignedShort();

                  for(var6 = 0; var6 < var5; ++var6) {
                     var7 = secretPacketBuffer2.method3173();
                     if(var7 == 255) {
                        var7 = secretPacketBuffer2.method3190();
                     }

                     var8 = secretPacketBuffer2.readByteOb1();
                     if(var87 != null && var6 < var87.itemIds.length) {
                        var87.itemIds[var6] = var8;
                        var87.itemQuantities[var6] = var7;
                     }

                     PendingSpawn.setItemTableSlot(var20, var6, var8 - 1, var7);
                  }

                  if(var87 != null) {
                     class88.method1714(var87);
                  }

                  ScriptEvent.method1135();
                  interfaceItemTriggers[++field1116 - 1 & 31] = var20 & 32767;
                  packetType = -1;
                  return true;
               }

               if(packetType == 220) {
                  var2 = secretPacketBuffer2.readInt();
                  var20 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 < -70000) {
                     var20 += '耀';
                  }

                  if(var2 >= 0) {
                     var87 = PacketBuffer.method3403(var2);
                  } else {
                     var87 = null;
                  }

                  for(; secretPacketBuffer2.offset < packetLength; PendingSpawn.setItemTableSlot(var20, var5, var6 - 1, var7)) {
                     var5 = secretPacketBuffer2.getUSmart();
                     var6 = secretPacketBuffer2.readUnsignedShort();
                     var7 = 0;
                     if(var6 != 0) {
                        var7 = secretPacketBuffer2.readUnsignedByte();
                        if(var7 == 255) {
                           var7 = secretPacketBuffer2.readInt();
                        }
                     }

                     if(var87 != null && var5 >= 0 && var5 < var87.itemIds.length) {
                        var87.itemIds[var5] = var6;
                        var87.itemQuantities[var5] = var7;
                     }
                  }

                  if(var87 != null) {
                     class88.method1714(var87);
                  }

                  ScriptEvent.method1135();
                  interfaceItemTriggers[++field1116 - 1 & 31] = var20 & 32767;
                  packetType = -1;
                  return true;
               }

               long var10;
               long var25;
               long var27;
               boolean var37;
               if(packetType == 238) {
                  var19 = secretPacketBuffer2.readString();
                  var25 = secretPacketBuffer2.readLong();
                  var27 = (long)secretPacketBuffer2.readUnsignedShort();
                  var34 = (long)secretPacketBuffer2.read24BitInt();
                  Permission var36 = (Permission)class134.forOrdinal(Widget.method4032(), secretPacketBuffer2.readUnsignedByte());
                  var10 = var34 + (var27 << 32);
                  var37 = false;

                  for(var38 = 0; var38 < 100; ++var38) {
                     if(field1146[var38] == var10) {
                        var37 = true;
                        break;
                     }
                  }

                  if(var36.field3188 && class1.isIgnored(var19)) {
                     var37 = true;
                  }

                  if(!var37 && field1045 == 0) {
                     field1146[field1147] = var10;
                     field1147 = (field1147 + 1) % 100;
                     PacketBuffer var43 = secretPacketBuffer2;

                     String var74;
                     try {
                        var44 = var43.getUSmart();
                        if(var44 > 32767) {
                           var44 = 32767;
                        }

                        byte[] var17 = new byte[var44];
                        var43.offset += class265.field3665.decompress(var43.payload, var43.offset, var17, 0, var44);
                        String var18 = class48.getString(var17, 0, var44);
                        var74 = var18;
                     } catch (Exception var54) {
                        var74 = "Cabbage";
                     }

                     var74 = FontTypeFace.appendTags(FaceNormal.method2870(var74));
                     if(var36.field3186 != -1) {
                        WorldMapData.addChatMessage(9, class41.method609(var36.field3186) + var19, var74, class56.method850(var25));
                     } else {
                        WorldMapData.addChatMessage(9, var19, var74, class56.method850(var25));
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 196) {
                  var2 = secretPacketBuffer2.readInt();
                  var20 = secretPacketBuffer2.readInt();
                  if(class39.field558 == null || !class39.field558.isValid()) {
                     try {
                        Iterator var84 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                        while(var84.hasNext()) {
                           GarbageCollectorMXBean var90 = (GarbageCollectorMXBean)var84.next();
                           if(var90.isValid()) {
                              class39.field558 = var90;
                              field1203 = -1L;
                              field1120 = -1L;
                           }
                        }
                     } catch (Throwable var56) {
                        ;
                     }
                  }

                  long var39 = DState.currentTimeMs();
                  var6 = -1;
                  if(class39.field558 != null) {
                     var34 = class39.field558.getCollectionTime();
                     if(-1L != field1120) {
                        long var41 = var34 - field1120;
                        long var45 = var39 - field1203;
                        if(0L != var45) {
                           var6 = (int)(100L * var41 / var45);
                        }
                     }

                     field1120 = var34;
                     field1203 = var39;
                  }

                  secretPacketBuffer1.putOpcode(174);
                  secretPacketBuffer1.method3265(var6);
                  secretPacketBuffer1.putInt(var2);
                  secretPacketBuffer1.method3233(var20);
                  secretPacketBuffer1.method3265(GameEngine.FPS);
                  packetType = -1;
                  return true;
               }

               int var9;
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
                  long var48 = secretPacketBuffer2.readLong();
                  clanChatOwner = XClanMember.method1182(var48);
                  class12.field271 = secretPacketBuffer2.readByte();
                  var4 = secretPacketBuffer2.readUnsignedByte();
                  if(var4 == 255) {
                     packetType = -1;
                     return true;
                  }

                  class28.clanChatCount = var4;
                  XClanMember[] var89 = new XClanMember[100];

                  for(var6 = 0; var6 < class28.clanChatCount; ++var6) {
                     var89[var6] = new XClanMember();
                     var89[var6].username = secretPacketBuffer2.readString();
                     var89[var6].field919 = Player.method1179(var89[var6].username, field928);
                     var89[var6].world = secretPacketBuffer2.readUnsignedShort();
                     var89[var6].rank = secretPacketBuffer2.readByte();
                     secretPacketBuffer2.readString();
                     if(var89[var6].username.equals(XItemContainer.localPlayer.name)) {
                        class35.clanChatRank = var89[var6].rank;
                     }
                  }

                  var66 = false;
                  var8 = class28.clanChatCount;

                  while(var8 > 0) {
                     var66 = true;
                     --var8;

                     for(var9 = 0; var9 < var8; ++var9) {
                        if(var89[var9].field919.compareTo(var89[var9 + 1].field919) > 0) {
                           XClanMember var100 = var89[var9];
                           var89[var9] = var89[var9 + 1];
                           var89[var9 + 1] = var100;
                           var66 = false;
                        }
                     }

                     if(var66) {
                        break;
                     }
                  }

                  class11.clanMembers = var89;
                  packetType = -1;
                  return true;
               }

               if(packetType == 52) {
                  while(secretPacketBuffer2.offset < packetLength) {
                     var62 = secretPacketBuffer2.readUnsignedByte() == 1;
                     var61 = secretPacketBuffer2.readString();
                     var82 = secretPacketBuffer2.readString();
                     var5 = secretPacketBuffer2.readUnsignedShort();
                     var6 = secretPacketBuffer2.readUnsignedByte();
                     var7 = secretPacketBuffer2.readUnsignedByte();
                     boolean var68 = (var7 & 2) != 0;
                     boolean var70 = (var7 & 1) != 0;
                     if(var5 > 0) {
                        secretPacketBuffer2.readString();
                        secretPacketBuffer2.readUnsignedByte();
                        secretPacketBuffer2.readInt();
                     }

                     secretPacketBuffer2.readString();

                     for(var108 = 0; var108 < friendCount; ++var108) {
                        Friend var33 = friends[var108];
                        if(!var62) {
                           if(var61.equals(var33.name)) {
                              if(var5 != var33.world) {
                                 var37 = true;

                                 for(class67 var72 = (class67)field1029.method3612(); var72 != null; var72 = (class67)field1029.method3607()) {
                                    if(var72.field841.equals(var61)) {
                                       if(var5 != 0 && var72.field837 == 0) {
                                          var72.method3615();
                                          var37 = false;
                                       } else if(var5 == 0 && var72.field837 != 0) {
                                          var72.method3615();
                                          var37 = false;
                                       }
                                    }
                                 }

                                 if(var37) {
                                    field1029.method3608(new class67(var61, var5));
                                 }

                                 var33.world = var5;
                              }

                              var33.previousName = var82;
                              var33.rank = var6;
                              var33.field824 = var68;
                              var33.field825 = var70;
                              var61 = null;
                              break;
                           }
                        } else if(var82.equals(var33.name)) {
                           var33.name = var61;
                           var33.previousName = var82;
                           var61 = null;
                           break;
                        }
                     }

                     if(var61 != null && friendCount < 400) {
                        Friend var47 = new Friend();
                        friends[friendCount] = var47;
                        var47.name = var61;
                        var47.previousName = var82;
                        var47.world = var5;
                        var47.rank = var6;
                        var47.field824 = var68;
                        var47.field825 = var70;
                        ++friendCount;
                     }
                  }

                  field1193 = 2;
                  field1025 = field1112;
                  var62 = false;
                  var20 = friendCount;

                  while(var20 > 0) {
                     var62 = true;
                     --var20;

                     for(var4 = 0; var4 < var20; ++var4) {
                        var64 = false;
                        Friend var78 = friends[var4];
                        Friend var99 = friends[var4 + 1];
                        if(var78.world != world && var99.world == world) {
                           var64 = true;
                        }

                        if(!var64 && var78.world == 0 && var99.world != 0) {
                           var64 = true;
                        }

                        if(!var64 && !var78.field824 && var99.field824) {
                           var64 = true;
                        }

                        if(!var64 && !var78.field825 && var99.field825) {
                           var64 = true;
                        }

                        if(var64) {
                           Friend var93 = friends[var4];
                           friends[var4] = friends[var4 + 1];
                           friends[var4 + 1] = var93;
                           var62 = false;
                        }
                     }

                     if(var62) {
                        break;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 214) {
                  class239.decodeClassVerifier(secretPacketBuffer2, packetLength);
                  packetType = -1;
                  return true;
               }

               if(packetType == 177) {
                  class64.method1116();
                  packetType = -1;
                  return false;
               }

               if(packetType == 218) {
                  World var76 = new World();
                  var76.address = secretPacketBuffer2.readString();
                  var76.id = secretPacketBuffer2.readUnsignedShort();
                  var20 = secretPacketBuffer2.readInt();
                  var76.mask = var20;
                  TextureProvider.setGameState(45);
                  class244.rssocket.close();
                  class244.rssocket = null;
                  class89.method1719(var76);
                  packetType = -1;
                  return false;
               }

               if(packetType == 163) {
                  var19 = secretPacketBuffer2.readString();
                  var25 = (long)secretPacketBuffer2.readUnsignedShort();
                  var27 = (long)secretPacketBuffer2.read24BitInt();
                  Permission var29 = (Permission)class134.forOrdinal(Widget.method4032(), secretPacketBuffer2.readUnsignedByte());
                  var30 = (var25 << 32) + var27;
                  boolean var32 = false;

                  for(var11 = 0; var11 < 100; ++var11) {
                     if(field1146[var11] == var30) {
                        var32 = true;
                        break;
                     }
                  }

                  if(class1.isIgnored(var19)) {
                     var32 = true;
                  }

                  if(!var32 && field1045 == 0) {
                     field1146[field1147] = var30;
                     field1147 = (field1147 + 1) % 100;
                     PacketBuffer var12 = secretPacketBuffer2;

                     String var13;
                     try {
                        var14 = var12.getUSmart();
                        if(var14 > 32767) {
                           var14 = 32767;
                        }

                        byte[] var15 = new byte[var14];
                        var12.offset += class265.field3665.decompress(var12.payload, var12.offset, var15, 0, var14);
                        String var16 = class48.getString(var15, 0, var14);
                        var13 = var16;
                     } catch (Exception var55) {
                        var13 = "Cabbage";
                     }

                     var13 = FontTypeFace.appendTags(FaceNormal.method2870(var13));
                     byte var73;
                     if(var29.field3184) {
                        var73 = 7;
                     } else {
                        var73 = 3;
                     }

                     if(var29.field3186 != -1) {
                        class152.sendGameMessage(var73, class41.method609(var29.field3186) + var19, var13);
                     } else {
                        class152.sendGameMessage(var73, var19, var13);
                     }
                  }

                  packetType = -1;
                  return true;
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

               if(packetType != 215) {
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

                  if(packetType == 96) {
                     PacketBuffer var75 = secretPacketBuffer2;
                     var20 = packetLength;
                     var4 = var75.offset;
                     class96.field1525 = 0;
                     class90.decodeLocationUpdates(var75);
                     Preferences.updatePlayersFlag(var75);
                     if(var20 != var75.offset - var4) {
                        throw new RuntimeException(var75.offset - var4 + " " + var20);
                     }

                     packetType = -1;
                     return true;
                  }

                  PacketBuffer var60;
                  if(packetType == 166) {
                     class1.xteaChanged(true);
                     secretPacketBuffer2.readOpcode();
                     var2 = secretPacketBuffer2.readUnsignedShort();
                     var60 = secretPacketBuffer2;
                     var4 = var60.offset;
                     class96.field1525 = 0;
                     class90.decodeLocationUpdates(var60);
                     Preferences.updatePlayersFlag(var60);
                     if(var2 != var60.offset - var4) {
                        throw new RuntimeException(var60.offset - var4 + " " + var2);
                     }

                     packetType = -1;
                     return true;
                  }

                  if(packetType == 156) {
                     class1.xteaChanged(false);
                     secretPacketBuffer2.readOpcode();
                     var2 = secretPacketBuffer2.readUnsignedShort();
                     var60 = secretPacketBuffer2;
                     var4 = var60.offset;
                     class96.field1525 = 0;
                     class90.decodeLocationUpdates(var60);
                     Preferences.updatePlayersFlag(var60);
                     if(var2 != var60.offset - var4) {
                        throw new RuntimeException(var60.offset - var4 + " " + var2);
                     }

                     packetType = -1;
                     return true;
                  }

                  if(packetType == 7) {
                     if(widgetRoot != -1) {
                        var2 = widgetRoot;
                        if(class66.loadWidget(var2)) {
                           class5.method22(class46.widgets[var2], 0);
                        }
                     }

                     packetType = -1;
                     return true;
                  }

                  if(packetType == 129) {
                     var2 = secretPacketBuffer2.readInt();
                     WidgetNode var59 = (WidgetNode)componentTable.get((long)var2);
                     if(var59 != null) {
                        class95.method1780(var59, true);
                     }

                     if(field1091 != null) {
                        class88.method1714(field1091);
                        field1091 = null;
                     }

                     packetType = -1;
                     return true;
                  }

                  if(packetType == 240) {
                     var2 = secretPacketBuffer2.method3318();
                     widgetRoot = var2;
                     this.method1201(false);
                     class222.method4070(var2);
                     Ignore.method1136(widgetRoot);

                     for(var20 = 0; var20 < 100; ++var20) {
                        field1132[var20] = true;
                     }

                     packetType = -1;
                     return true;
                  }

                  WidgetNode var23;
                  if(packetType == 40) {
                     var2 = secretPacketBuffer2.method3190();
                     var20 = secretPacketBuffer2.method3190();
                     WidgetNode var80 = (WidgetNode)componentTable.get((long)var20);
                     var23 = (WidgetNode)componentTable.get((long)var2);
                     if(var23 != null) {
                        class95.method1780(var23, var80 == null || var23.id != var80.id);
                     }

                     if(var80 != null) {
                        var80.unlink();
                        componentTable.put(var80, (long)var2);
                     }

                     var21 = PacketBuffer.method3403(var20);
                     if(var21 != null) {
                        class88.method1714(var21);
                     }

                     var21 = PacketBuffer.method3403(var2);
                     if(var21 != null) {
                        class88.method1714(var21);
                        WorldMapType2.method546(class46.widgets[var21.id >>> 16], var21, true);
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

                  if(packetType == 159) {
                     var2 = secretPacketBuffer2.method3318();
                     var20 = secretPacketBuffer2.readIntOb3();
                     var4 = secretPacketBuffer2.method3173();
                     var23 = (WidgetNode)componentTable.get((long)var20);
                     if(var23 != null) {
                        class95.method1780(var23, var2 != var23.id);
                     }

                     class29.method233(var20, var2, var4);
                     packetType = -1;
                     return true;
                  }

                  if(packetType == 67) {
                     var19 = secretPacketBuffer2.readString();
                     Object[] var3 = new Object[var19.length() + 1];

                     for(var4 = var19.length() - 1; var4 >= 0; --var4) {
                        if(var19.charAt(var4) == 115) {
                           var3[var4 + 1] = secretPacketBuffer2.readString();
                        } else {
                           var3[var4 + 1] = new Integer(secretPacketBuffer2.readInt());
                        }
                     }

                     var3[0] = new Integer(secretPacketBuffer2.readInt());
                     ScriptEvent var22 = new ScriptEvent();
                     var22.field857 = var3;
                     class14.method76(var22);
                     packetType = -1;
                     return true;
                  }

                  if(packetType == 17) {
                     var2 = packetLength + secretPacketBuffer2.offset;
                     var20 = secretPacketBuffer2.readUnsignedShort();
                     var4 = secretPacketBuffer2.readUnsignedShort();
                     if(var20 != widgetRoot) {
                        widgetRoot = var20;
                        this.method1201(false);
                        class222.method4070(widgetRoot);
                        Ignore.method1136(widgetRoot);

                        for(var5 = 0; var5 < 100; ++var5) {
                           field1132[var5] = true;
                        }
                     }

                     WidgetNode var24;
                     for(; var4-- > 0; var24.field845 = true) {
                        var5 = secretPacketBuffer2.readInt();
                        var6 = secretPacketBuffer2.readUnsignedShort();
                        var7 = secretPacketBuffer2.readUnsignedByte();
                        var24 = (WidgetNode)componentTable.get((long)var5);
                        if(var24 != null && var6 != var24.id) {
                           class95.method1780(var24, true);
                           var24 = null;
                        }

                        if(var24 == null) {
                           var24 = class29.method233(var5, var6, var7);
                        }
                     }

                     for(var23 = (WidgetNode)componentTable.method3533(); var23 != null; var23 = (WidgetNode)componentTable.method3538()) {
                        if(var23.field845) {
                           var23.field845 = false;
                        } else {
                           class95.method1780(var23, true);
                        }
                     }

                     widgetFlags = new XHashTable(512);

                     while(secretPacketBuffer2.offset < var2) {
                        var5 = secretPacketBuffer2.readInt();
                        var6 = secretPacketBuffer2.readUnsignedShort();
                        var7 = secretPacketBuffer2.readUnsignedShort();
                        var8 = secretPacketBuffer2.readInt();

                        for(var9 = var6; var9 <= var7; ++var9) {
                           var10 = (long)var9 + ((long)var5 << 32);
                           widgetFlags.put(new WidgetConfig(var8), var10);
                        }
                     }

                     packetType = -1;
                     return true;
                  }

                  MilliTimer.method2912("" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength, (Throwable)null);
                  class64.method1116();
                  return true;
               }
            }

            Actor.method1557();
            packetType = -1;
            return true;
         } catch (IOException var57) {
            class13.method60();
         } catch (Exception var58) {
            var19 = "" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength + "," + (XItemContainer.localPlayer.pathX[0] + KeyFocusListener.baseX) + "," + (XItemContainer.localPlayer.pathY[0] + class266.baseY) + ",";

            for(var20 = 0; var20 < packetLength && var20 < 50; ++var20) {
               var19 = var19 + secretPacketBuffer2.payload[var20] + ",";
            }

            MilliTimer.method2912(var19, var58);
            class64.method1116();
         }

         return true;
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
         Deque var2 = class236.field3247;
         FileSystem var1;
         synchronized(class236.field3247) {
            var1 = (FileSystem)class236.field3242.popFront();
         }

         if(var1 == null) {
            int var5;
            try {
               if(class203.field2508 == 1) {
                  var5 = class203.field2509.method3668();
                  if(var5 > 0 && class203.field2509.method3674()) {
                     var5 -= class203.field2517;
                     if(var5 < 0) {
                        var5 = 0;
                     }

                     class203.field2509.method3694(var5);
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
            } catch (Exception var8) {
               var8.printStackTrace();
               class203.field2509.method3740();
               class203.field2508 = 0;
               class222.field2843 = null;
               class20.field335 = null;
               class61.field785 = null;
            }

            class14.method67();
            class33.method346();
            MouseInput var9 = MouseInput.mouse;
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
               var5 = class2.field16.vmethod2960();
               field1125 = var5;
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

         var1.data.method4220(var1.index, (int)var1.hash, var1.field3215, false);
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
                     int var5 = FileOnDisk.rssocket.readByte();
                     if(var5 != 0) {
                        this.error(var5);
                        return;
                     }

                     ++js5State;
                  }
               }

               if(js5State == 4) {
                  RSSocket var10 = FileOnDisk.rssocket;
                  boolean var2 = gameState > 20;
                  if(class238.field3272 != null) {
                     try {
                        class238.field3272.close();
                     } catch (Exception var8) {
                        ;
                     }

                     class238.field3272 = null;
                  }

                  class238.field3272 = var10;
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
                                    Buffer var11 = new Buffer(4);
                                    var11.putByte(4);
                                    var11.putByte(class238.field3276);
                                    var11.putShort(0);
                                    class238.field3272.queueForWrite(var11.payload, 0, 4);
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
                  var4 = "Use" + " " + selectedItemName + " " + "->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var4 = field1078 + " " + field1159 + " " + "->";
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

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "0"
   )
   @Hook("clientMainLoop")
   protected final void vmethod1455(boolean var1) {
      boolean var2;
      label193: {
         try {
            if(class203.field2508 == 2) {
               if(class222.field2843 == null) {
                  class222.field2843 = Track1.getMusicFile(class61.field785, class203.field2511, class203.field2512);
                  if(class222.field2843 == null) {
                     var2 = false;
                     break label193;
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
                  break label193;
               }
            }
         } catch (Exception var7) {
            var7.printStackTrace();
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

      int var4;
      if((gameState == 10 || gameState == 20 || gameState == 30) && field1140 != 0L && DState.currentTimeMs() > field1140) {
         var4 = isResized?2:1;
         field1140 = 0L;
         if(var4 >= 2) {
            isResized = true;
         } else {
            isResized = false;
         }

         int var5 = isResized?2:1;
         if(var5 == 1) {
            class261.clientInstance.method869(765, 503);
         } else {
            class261.clientInstance.method869(7680, 2160);
         }

         if(gameState >= 25) {
            class5.method18();
         }
      }

      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1132[var4] = true;
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

               var4 = (field982 * 50 - field1083 * 50) / field982;
               class2.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field1104 == 2) {
               if(field983 > field984) {
                  field984 = field983;
               }

               var4 = (field984 * 50 - field983 * 50) / field984 + 50;
               class2.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class2.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1197();
         } else if(gameState == 40) {
            class2.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class2.drawStatusBox("Please wait...", false);
         }
      } else {
         class89.drawLoginScreen(World.field1322, class45.field618, class37.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1) {
         for(var4 = 0; var4 < field1061; ++var4) {
            if(field1133[var4]) {
               class43.field602.vmethod5008(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field1133[var4] = false;
            }
         }
      } else if(gameState > 0) {
         class43.field602.vmethod5007(0, 0);

         for(var4 = 0; var4 < field1061; ++var4) {
            field1133[var4] = false;
         }
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
            int[] var6 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class24.field368 >> 32), (int)(class24.field368 & -1L)};
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(1);
            secretPacketBuffer1.putByte(class92.field1472.rsOrdinal());
            secretPacketBuffer1.putInt(var6[0]);
            secretPacketBuffer1.putInt(var6[1]);
            secretPacketBuffer1.putInt(var6[2]);
            secretPacketBuffer1.putInt(var6[3]);
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
            Buffer var4 = new Buffer(Ignore.field866.method5370());
            Ignore.field866.method5372(var4);
            field969.putBytes(var4.payload, 0, var4.payload.length);
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
            field969.encryptXtea(var6, var3, field969.offset);
            field969.putShortLength(field969.offset - var2);
            class244.rssocket.queueForWrite(field969.payload, 0, field969.offset);
            secretPacketBuffer1.seed(var6);

            for(int var5 = 0; var5 < 4; ++var5) {
               var6[var5] += 50;
            }

            secretPacketBuffer2.seed(var6);
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
               boolean var12 = class244.rssocket.readByte() == 1;
               class244.rssocket.read(secretPacketBuffer2.payload, 0, 4);
               secretPacketBuffer2.offset = 0;
               boolean var11 = false;
               if(var12) {
                  var2 = secretPacketBuffer2.readOpcode() << 24;
                  var2 |= secretPacketBuffer2.readOpcode() << 16;
                  var2 |= secretPacketBuffer2.readOpcode() << 8;
                  var2 |= secretPacketBuffer2.readOpcode();
                  var3 = ScriptVarType.method30(class92.username);
                  if(class8.settings.preferences.size() >= 10 && !class8.settings.preferences.containsKey(Integer.valueOf(var3))) {
                     Iterator var13 = class8.settings.preferences.entrySet().iterator();
                     var13.next();
                     var13.remove();
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
                  Client var7 = class261.clientInstance;
                  JSObject.getWindow(var7).call("zap", (Object[])null);
               } catch (Throwable var9) {
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
                  String var17 = secretPacketBuffer2.readString();
                  String var20 = secretPacketBuffer2.readString();
                  String var19 = secretPacketBuffer2.readString();
                  class13.method64(var17, var20, var19);
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
            } else {
               if(class244.rssocket.available() >= packetLength) {
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
                     VarPlayerType var18 = (VarPlayerType)VarPlayerType.varplayers.get((long)var1);
                     VarPlayerType var8;
                     if(var18 != null) {
                        var8 = var18;
                     } else {
                        byte[] var14 = VarPlayerType.varplayer_ref.getConfigData(16, var1);
                        var18 = new VarPlayerType();
                        if(var14 != null) {
                           var18.decode(new Buffer(var14));
                        }

                        VarPlayerType.varplayers.put(var18, (long)var1);
                        var8 = var18;
                     }

                     if(var8 != null) {
                        class211.settings[var1] = 0;
                        class211.widgetSettings[var1] = 0;
                     }
                  }

                  class71.chatMessages.reset();
                  field1065 = -1;
                  if(widgetRoot != -1) {
                     PacketBuffer.method3411(widgetRoot);
                  }

                  for(WidgetNode var15 = (WidgetNode)componentTable.method3533(); var15 != null; var15 = (WidgetNode)componentTable.method3538()) {
                     class95.method1780(var15, true);
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
         }
      } catch (IOException var10) {
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

            Object var13 = WorldMapType3.field393.field869;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            synchronized(WorldMapType3.field393.field869) {
               if(!field974) {
                  WorldMapType3.field393.field878 = 0;
               } else if(MouseInput.field742 != 0 || WorldMapType3.field393.field878 >= 40) {
                  secretPacketBuffer1.putOpcode(54);
                  secretPacketBuffer1.putByte(0);
                  var2 = secretPacketBuffer1.offset;
                  var3 = 0;

                  for(var4 = 0; var4 < WorldMapType3.field393.field878 && secretPacketBuffer1.offset - var2 < 240; ++var4) {
                     ++var3;
                     var5 = WorldMapType3.field393.field872[var4];
                     if(var5 < 0) {
                        var5 = 0;
                     } else if(var5 > 502) {
                        var5 = 502;
                     }

                     var6 = WorldMapType3.field393.field871[var4];
                     if(var6 < 0) {
                        var6 = 0;
                     } else if(var6 > 764) {
                        var6 = 764;
                     }

                     var7 = var5 * 765 + var6;
                     if(WorldMapType3.field393.field872[var4] == -1 && WorldMapType3.field393.field871[var4] == -1) {
                        var6 = -1;
                        var5 = -1;
                        var7 = 524287;
                     }

                     if(var6 == field1130 && var5 == field953) {
                        if(field939 < 2047) {
                           ++field939;
                        }
                     } else {
                        var8 = var6 - field1130;
                        field1130 = var6;
                        var9 = var5 - field953;
                        field953 = var5;
                        if(field939 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                           var8 += 32;
                           var9 += 32;
                           secretPacketBuffer1.putShort((field939 << 12) + (var8 << 6) + var9);
                           field939 = 0;
                        } else if(field939 < 8) {
                           secretPacketBuffer1.put24bitInt((field939 << 19) + 8388608 + var7);
                           field939 = 0;
                        } else {
                           secretPacketBuffer1.putInt(var7 + (field939 << 19) + -1073741824);
                           field939 = 0;
                        }
                     }
                  }

                  secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var2);
                  if(var3 >= WorldMapType3.field393.field878) {
                     WorldMapType3.field393.field878 = 0;
                  } else {
                     WorldMapType3.field393.field878 -= var3;

                     for(var4 = 0; var4 < WorldMapType3.field393.field878; ++var4) {
                        WorldMapType3.field393.field871[var4] = WorldMapType3.field393.field871[var4 + var3];
                        WorldMapType3.field393.field872[var4] = WorldMapType3.field393.field872[var4 + var3];
                     }
                  }
               }
            }

            if(MouseInput.field742 == 1 || !class34.field499 && MouseInput.field742 == 4 || MouseInput.field742 == 2) {
               long var14 = (MouseInput.field757 - field936) / 50L;
               if(var14 > 4095L) {
                  var14 = 4095L;
               }

               field936 = MouseInput.field757;
               var3 = MouseInput.field756;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > CollisionData.canvasHeight) {
                  var3 = CollisionData.canvasHeight;
               }

               var4 = MouseInput.field747;
               if(var4 < 0) {
                  var4 = 0;
               } else if(var4 > class45.canvasWidth) {
                  var4 = class45.canvasWidth;
               }

               var5 = (int)var14;
               secretPacketBuffer1.putOpcode(171);
               secretPacketBuffer1.putShort((var5 << 1) + (MouseInput.field742 == 2?1:0));
               secretPacketBuffer1.putShort(var4);
               secretPacketBuffer1.putShort(var3);
            }

            if(KeyFocusListener.field671 > 0) {
               secretPacketBuffer1.putOpcode(3);
               secretPacketBuffer1.putShort(0);
               var1 = secretPacketBuffer1.offset;
               long var16 = DState.currentTimeMs();

               for(var4 = 0; var4 < KeyFocusListener.field671; ++var4) {
                  long var18 = var16 - field925;
                  if(var18 > 16777215L) {
                     var18 = 16777215L;
                  }

                  field925 = var16;
                  secretPacketBuffer1.method3184((int)var18);
                  secretPacketBuffer1.putShortLE(KeyFocusListener.field670[var4]);
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
               for(PendingSpawn var30 = (PendingSpawn)pendingSpawns.getFront(); var30 != null; var30 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var30.hitpoints > 0) {
                     --var30.hitpoints;
                  }

                  ObjectComposition var20;
                  boolean var27;
                  if(var30.hitpoints == 0) {
                     if(var30.field1209 >= 0) {
                        var3 = var30.field1209;
                        var4 = var30.field1222;
                        var20 = class251.getObjectDefinition(var3);
                        if(var4 == 11) {
                           var4 = 10;
                        }

                        if(var4 >= 5 && var4 <= 8) {
                           var4 = 4;
                        }

                        var27 = var20.method4515(var4);
                        if(!var27) {
                           continue;
                        }
                     }

                     Friend.method1119(var30.level, var30.type, var30.x, var30.y, var30.field1209, var30.field1214, var30.field1222);
                     var30.unlink();
                  } else {
                     if(var30.delay > 0) {
                        --var30.delay;
                     }

                     if(var30.delay == 0 && var30.x >= 1 && var30.y >= 1 && var30.x <= 102 && var30.y <= 102) {
                        if(var30.id >= 0) {
                           var3 = var30.id;
                           var4 = var30.field1223;
                           var20 = class251.getObjectDefinition(var3);
                           if(var4 == 11) {
                              var4 = 10;
                           }

                           if(var4 >= 5 && var4 <= 8) {
                              var4 = 4;
                           }

                           var27 = var20.method4515(var4);
                           if(!var27) {
                              continue;
                           }
                        }

                        Friend.method1119(var30.level, var30.type, var30.x, var30.y, var30.id, var30.orientation, var30.field1223);
                        var30.delay = -1;
                        if(var30.field1209 == var30.id && var30.field1209 == -1) {
                           var30.unlink();
                        } else if(var30.field1209 == var30.id && var30.field1214 == var30.orientation && var30.field1223 == var30.field1222) {
                           var30.unlink();
                        }
                     }
                  }
               }

               for(var1 = 0; var1 < field1181; ++var1) {
                  --field1170[var1];
                  if(field1170[var1] >= -10) {
                     SoundEffect var22 = audioEffects[var1];
                     if(var22 == null) {
                        Object var10000 = null;
                        var22 = SoundEffect.getTrack(class98.field1545, field1168[var1], 0);
                        if(var22 == null) {
                           continue;
                        }

                        field1170[var1] += var22.calculateDelay();
                        audioEffects[var1] = var22;
                     }

                     if(field1170[var1] < 0) {
                        if(field1171[var1] != 0) {
                           var4 = (field1171[var1] & 255) * 128;
                           var5 = field1171[var1] >> 16 & 255;
                           var6 = var5 * 128 + 64 - XItemContainer.localPlayer.x;
                           if(var6 < 0) {
                              var6 = -var6;
                           }

                           var7 = field1171[var1] >> 8 & 255;
                           var8 = var7 * 128 + 64 - XItemContainer.localPlayer.y;
                           if(var8 < 0) {
                              var8 = -var8;
                           }

                           var9 = var8 + var6 - 128;
                           if(var9 > var4) {
                              field1170[var1] = -100;
                              continue;
                           }

                           if(var9 < 0) {
                              var9 = 0;
                           }

                           var3 = (var4 - var9) * field1098 / var4;
                        } else {
                           var3 = field1165;
                        }

                        if(var3 > 0) {
                           class107 var23 = var22.method1942().method1989(class225.field2896);
                           class117 var32 = class117.method2229(var23, 100, var3);
                           var32.method2126(field1169[var1] - 1);
                           class19.field328.method1890(var32);
                        }

                        field1170[var1] = -100;
                     }
                  } else {
                     --field1181;

                     for(var2 = var1; var2 < field1181; ++var2) {
                        field1168[var2] = field1168[var2 + 1];
                        audioEffects[var2] = audioEffects[var2 + 1];
                        field1169[var2] = field1169[var2 + 1];
                        field1170[var2] = field1170[var2 + 1];
                        field1171[var2] = field1171[var2 + 1];
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
               if(field973 > 750) {
                  class13.method60();
               } else {
                  class29.method234();

                  for(var1 = 0; var1 < field937; ++var1) {
                     var2 = npcIndices[var1];
                     NPC var21 = cachedNPCs[var2];
                     if(var21 != null) {
                        RSCanvas.method809(var21, var21.composition.field3561);
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

                  Widget var31 = KitDefinition.field3371;
                  Widget var38 = PendingSpawn.field1211;
                  KitDefinition.field3371 = null;
                  PendingSpawn.field1211 = null;
                  field1105 = null;
                  field1176 = false;
                  field1069 = false;
                  field1037 = 0;

                  while(class14.method77() && field1037 < 128) {
                     if(rights >= 2 && KeyFocusListener.field659[82] && class168.field2346 == 66) {
                        String var34 = WallObject.method2865();
                        class261.clientInstance.method972(var34);
                     } else {
                        field1150[field1037] = class168.field2346;
                        field1149[field1037] = IndexDataBase.field3238;
                        ++field1037;
                     }
                  }

                  if(widgetRoot != -1) {
                     var3 = widgetRoot;
                     var4 = class45.canvasWidth;
                     var5 = CollisionData.canvasHeight;
                     if(class66.loadWidget(var3)) {
                        WorldMapType1.method262(class46.widgets[var3], -1, 0, 0, var4, var5, 0, 0);
                     }
                  }

                  ++field1112;

                  while(true) {
                     Widget var33;
                     ScriptEvent var35;
                     Widget var39;
                     do {
                        var35 = (ScriptEvent)field1127.popFront();
                        if(var35 == null) {
                           while(true) {
                              do {
                                 var35 = (ScriptEvent)field1128.popFront();
                                 if(var35 == null) {
                                    while(true) {
                                       do {
                                          var35 = (ScriptEvent)field1035.popFront();
                                          if(var35 == null) {
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
                                                         Widget var37 = class95.field1513;
                                                         byte var29 = 0;
                                                         if(field1141 == 1 && var37.contentType == 206) {
                                                            var29 = 1;
                                                         }

                                                         if(var37.itemIds[field1042] <= 0) {
                                                            var29 = 0;
                                                         }

                                                         if(class29.method235(WorldMapType3.getWidgetConfig(var37))) {
                                                            var5 = field1039;
                                                            var6 = field1042;
                                                            var37.itemIds[var6] = var37.itemIds[var5];
                                                            var37.itemQuantities[var6] = var37.itemQuantities[var5];
                                                            var37.itemIds[var5] = -1;
                                                            var37.itemQuantities[var5] = 0;
                                                         } else if(var29 == 1) {
                                                            var5 = field1039;
                                                            var6 = field1042;

                                                            while(var5 != var6) {
                                                               if(var5 > var6) {
                                                                  var37.method4006(var5 - 1, var5);
                                                                  --var5;
                                                               } else if(var5 < var6) {
                                                                  var37.method4006(var5 + 1, var5);
                                                                  ++var5;
                                                               }
                                                            }
                                                         } else {
                                                            var37.method4006(field1042, field1039);
                                                         }

                                                         secretPacketBuffer1.putOpcode(19);
                                                         secretPacketBuffer1.method3257(class95.field1513.id);
                                                         secretPacketBuffer1.putIntOb1(field1039);
                                                         secretPacketBuffer1.method3265(var29);
                                                         secretPacketBuffer1.putShortOb2(field1042);
                                                      }
                                                   } else {
                                                      label1204: {
                                                         label953: {
                                                            var3 = class2.method7();
                                                            if(menuOptionCount > 2) {
                                                               if(field1064 == 1 && !FaceNormal.method2868()) {
                                                                  break label953;
                                                               }

                                                               boolean var28;
                                                               if(var3 < 0) {
                                                                  var28 = false;
                                                               } else {
                                                                  var5 = menuTypes[var3];
                                                                  if(var5 >= 2000) {
                                                                     var5 -= 2000;
                                                                  }

                                                                  if(var5 == 1007) {
                                                                     var28 = true;
                                                                  } else {
                                                                     var28 = false;
                                                                  }
                                                               }

                                                               if(var28) {
                                                                  break label953;
                                                               }
                                                            }

                                                            if(menuOptionCount > 0) {
                                                               var4 = field1040;
                                                               var5 = field1041;
                                                               class67.method1122(class13.field281, var4, var5);
                                                               class13.field281 = null;
                                                            }
                                                            break label1204;
                                                         }

                                                         this.method1200(field1040, field1041);
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
                                                var3 = Region.selectedRegionTileX;
                                                var4 = Region.selectedRegionTileY;
                                                secretPacketBuffer1.putOpcode(96);
                                                secretPacketBuffer1.putByte(5);
                                                secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?(KeyFocusListener.field659[81]?2:1):0);
                                                secretPacketBuffer1.putShort(var4 + class266.baseY);
                                                secretPacketBuffer1.putShort(var3 + KeyFocusListener.baseX);
                                                Region.method2832();
                                                field1190 = MouseInput.field747;
                                                field1034 = MouseInput.field756;
                                                cursorState = 1;
                                                field967 = 0;
                                                destinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(var31 != KitDefinition.field3371) {
                                                if(var31 != null) {
                                                   class88.method1714(var31);
                                                }

                                                if(KitDefinition.field3371 != null) {
                                                   class88.method1714(KitDefinition.field3371);
                                                }
                                             }

                                             if(var38 != PendingSpawn.field1211 && field1079 == field1054) {
                                                if(var38 != null) {
                                                   class88.method1714(var38);
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

                                             var3 = field1072 + XItemContainer.localPlayer.x;
                                             var4 = field1033 + XItemContainer.localPlayer.y;
                                             if(Ignore.field860 - var3 < -500 || Ignore.field860 - var3 > 500 || class31.field456 - var4 < -500 || class31.field456 - var4 > 500) {
                                                Ignore.field860 = var3;
                                                class31.field456 = var4;
                                             }

                                             if(var3 != Ignore.field860) {
                                                Ignore.field860 += (var3 - Ignore.field860) / 16;
                                             }

                                             if(var4 != class31.field456) {
                                                class31.field456 += (var4 - class31.field456) / 16;
                                             }

                                             if(MouseInput.field754 == 4 && class34.field499) {
                                                var5 = MouseInput.field749 - field1055;
                                                field1195 = var5 * 2;
                                                field1055 = var5 != -1 && var5 != 1?(MouseInput.field749 + field1055) / 2:MouseInput.field749;
                                                var6 = field1013 - MouseInput.field748;
                                                field1148 = var6 * 2;
                                                field1013 = var6 != -1 && var6 != 1?(field1013 + MouseInput.field748) / 2:MouseInput.field748;
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

                                             var5 = Ignore.field860 >> 7;
                                             var6 = class31.field456 >> 7;
                                             var7 = WorldMapData.getTileHeight(Ignore.field860, class31.field456, WallObject.plane);
                                             var8 = 0;
                                             if(var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
                                                for(var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
                                                   for(int var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                      int var11 = WallObject.plane;
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

                                             if(var9 > field1018) {
                                                field1018 += (var9 - field1018) / 24;
                                             } else if(var9 < field1018) {
                                                field1018 += (var9 - field1018) / 80;
                                             }

                                             if(field1173) {
                                                class66.method1120();
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field1178[var3];
                                             }

                                             class71.chatMessages.process();
                                             var3 = FrameMap.method2662();
                                             var4 = class60.method1047();
                                             if(var3 > 15000 && var4 > 15000) {
                                                field978 = 250;
                                                class83.method1674(14500);
                                                secretPacketBuffer1.putOpcode(224);
                                             }

                                             ++field991;
                                             if(field991 > 500) {
                                                field991 = 0;
                                                var5 = (int)(Math.random() * 8.0D);
                                                if((var5 & 1) == 1) {
                                                   field1072 += field1135;
                                                }

                                                if((var5 & 2) == 2) {
                                                   field1033 += field993;
                                                }

                                                if((var5 & 4) == 4) {
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
                                                var5 = (int)(Math.random() * 8.0D);
                                                if((var5 & 1) == 1) {
                                                   mapScale += mapOffset;
                                                }

                                                if((var5 & 2) == 2) {
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

                                             for(class67 var36 = (class67)field1029.method3612(); var36 != null; var36 = (class67)field1029.method3607()) {
                                                if((long)var36.field836 < DState.currentTimeMs() / 1000L - 5L) {
                                                   if(var36.field837 > 0) {
                                                      class152.sendGameMessage(5, "", var36.field841 + " has logged in.");
                                                   }

                                                   if(var36.field837 == 0) {
                                                      class152.sendGameMessage(5, "", var36.field841 + " has logged out.");
                                                   }

                                                   var36.method3615();
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
                                             } catch (IOException var25) {
                                                class13.method60();
                                             }

                                             return;
                                          }

                                          var39 = var35.widget;
                                          if(var39.index < 0) {
                                             break;
                                          }

                                          var33 = PacketBuffer.method3403(var39.parentId);
                                       } while(var33 == null || var33.children == null || var39.index >= var33.children.length || var39 != var33.children[var39.index]);

                                       class14.method76(var35);
                                    }
                                 }

                                 var39 = var35.widget;
                                 if(var39.index < 0) {
                                    break;
                                 }

                                 var33 = PacketBuffer.method3403(var39.parentId);
                              } while(var33 == null || var33.children == null || var39.index >= var33.children.length || var39 != var33.children[var39.index]);

                              class14.method76(var35);
                           }
                        }

                        var39 = var35.widget;
                        if(var39.index < 0) {
                           break;
                        }

                        var33 = PacketBuffer.method3403(var39.parentId);
                     } while(var33 == null || var33.children == null || var39.index >= var33.children.length || var39 != var33.children[var39.index]);

                     class14.method76(var35);
                  }
               }
            }
         }
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

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2075714416"
   )
   final void method1199() {
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

      if(class95.field1513 == null) {
         if(field1100 == null) {
            int var20 = MouseInput.field742;
            int var6;
            int var8;
            int var9;
            int var11;
            int var14;
            int var15;
            if(isMenuOpen) {
               if(var20 != 1 && (class34.field499 || var20 != 4)) {
                  var2 = MouseInput.field748;
                  var14 = MouseInput.field749;
                  if(var2 < ScriptState.menuX - 10 || var2 > WorldMapType1.menuWidth + ScriptState.menuX + 10 || var14 < Coordinates.menuY - 10 || var14 > MessageNode.menuHeight + Coordinates.menuY + 10) {
                     isMenuOpen = false;
                     Coordinates.method3911(ScriptState.menuX, Coordinates.menuY, WorldMapType1.menuWidth, MessageNode.menuHeight);
                  }
               }

               if(var20 == 1 || !class34.field499 && var20 == 4) {
                  var2 = ScriptState.menuX;
                  var14 = Coordinates.menuY;
                  var15 = WorldMapType1.menuWidth;
                  var5 = MouseInput.field747;
                  var6 = MouseInput.field756;
                  int var21 = -1;

                  for(var8 = 0; var8 < menuOptionCount; ++var8) {
                     var9 = var14 + 31 + (menuOptionCount - 1 - var8) * 15;
                     if(var5 > var2 && var5 < var15 + var2 && var6 > var9 - 13 && var6 < var9 + 3) {
                        var21 = var8;
                     }
                  }

                  if(var21 != -1 && var21 >= 0) {
                     var8 = menuActionParams0[var21];
                     var9 = menuActionParams1[var21];
                     int var22 = menuTypes[var21];
                     var11 = menuIdentifiers[var21];
                     String var19 = menuOptions[var21];
                     String var13 = menuTargets[var21];
                     Item.menuAction(var8, var9, var22, var11, var19, var13, MouseInput.field747, MouseInput.field756);
                  }

                  isMenuOpen = false;
                  Coordinates.method3911(ScriptState.menuX, Coordinates.menuY, WorldMapType1.menuWidth, MessageNode.menuHeight);
               }
            } else {
               var2 = class2.method7();
               if((var20 == 1 || !class34.field499 && var20 == 4) && var2 >= 0) {
                  var14 = menuTypes[var2];
                  if(var14 == 39 || var14 == 40 || var14 == 41 || var14 == 42 || var14 == 43 || var14 == 33 || var14 == 34 || var14 == 35 || var14 == 36 || var14 == 37 || var14 == 38 || var14 == 1005) {
                     label341: {
                        var15 = menuActionParams0[var2];
                        var5 = menuActionParams1[var2];
                        Widget var16 = PacketBuffer.method3403(var5);
                        var8 = WorldMapType3.getWidgetConfig(var16);
                        boolean var7 = (var8 >> 28 & 1) != 0;
                        if(!var7) {
                           Object var10000 = null;
                           if(!class29.method235(WorldMapType3.getWidgetConfig(var16))) {
                              break label341;
                           }
                        }

                        if(class95.field1513 != null && !field1043) {
                           var9 = class2.method7();
                           if(field1064 != 1) {
                              boolean var10;
                              if(var9 < 0) {
                                 var10 = false;
                              } else {
                                 var11 = menuTypes[var9];
                                 if(var11 >= 2000) {
                                    var11 -= 2000;
                                 }

                                 if(var11 == 1007) {
                                    var10 = true;
                                 } else {
                                    var10 = false;
                                 }
                              }

                              if(!var10 && menuOptionCount > 0) {
                                 var11 = field1040;
                                 int var12 = field1041;
                                 class67.method1122(class13.field281, var11, var12);
                                 class13.field281 = null;
                              }
                           }
                        }

                        field1043 = false;
                        field1044 = 0;
                        if(class95.field1513 != null) {
                           class88.method1714(class95.field1513);
                        }

                        class95.field1513 = PacketBuffer.method3403(var5);
                        field1039 = var15;
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

               if(var20 == 1 || !class34.field499 && var20 == 4) {
                  label345: {
                     if(field1064 != 1 || menuOptionCount <= 2 || FaceNormal.method2868()) {
                        boolean var23;
                        if(var2 < 0) {
                           var23 = false;
                        } else {
                           var15 = menuTypes[var2];
                           if(var15 >= 2000) {
                              var15 -= 2000;
                           }

                           if(var15 == 1007) {
                              var23 = true;
                           } else {
                              var23 = false;
                           }
                        }

                        if(!var23) {
                           break label345;
                        }
                     }

                     var20 = 2;
                  }
               }

               if((var20 == 1 || !class34.field499 && var20 == 4) && menuOptionCount > 0 && var2 >= 0) {
                  var14 = menuActionParams0[var2];
                  var15 = menuActionParams1[var2];
                  var5 = menuTypes[var2];
                  var6 = menuIdentifiers[var2];
                  String var17 = menuOptions[var2];
                  String var18 = menuTargets[var2];
                  Item.menuAction(var14, var15, var5, var6, var17, var18, MouseInput.field747, MouseInput.field756);
               }

               if(var20 == 2 && menuOptionCount > 0) {
                  this.method1200(MouseInput.field747, MouseInput.field756);
               }
            }

         }
      }
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
            int var10;
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
                  Widget var9 = field1100;
                  int var11 = WorldMapType3.getWidgetConfig(var9);
                  var10 = var11 >> 17 & 7;
                  int var12 = var10;
                  Widget var16;
                  if(var10 == 0) {
                     var16 = null;
                  } else {
                     int var13 = 0;

                     while(true) {
                        if(var13 >= var12) {
                           var16 = var9;
                           break;
                        }

                        var9 = PacketBuffer.method3403(var9.parentId);
                        if(var9 == null) {
                           var16 = null;
                           break;
                        }

                        ++var13;
                     }
                  }

                  if(var16 != null) {
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
               label158: {
                  int var14 = class2.method7();
                  if(menuOptionCount > 2) {
                     label161: {
                        if(field1064 != 1 || FaceNormal.method2868()) {
                           boolean var15;
                           if(var14 < 0) {
                              var15 = false;
                           } else {
                              var10 = menuTypes[var14];
                              if(var10 >= 2000) {
                                 var10 -= 2000;
                              }

                              if(var10 == 1007) {
                                 var15 = true;
                              } else {
                                 var15 = false;
                              }
                           }

                           if(!var15) {
                              break label161;
                           }
                        }

                        this.method1200(field1109 + field1102, field960 + field1103);
                        break label158;
                     }
                  }

                  if(menuOptionCount > 0) {
                     int var17 = field1102 + field1109;
                     var10 = field1103 + field960;
                     class67.method1122(class13.field281, var17, var10);
                     class13.field281 = null;
                  }
               }
            }

            field1100 = null;
         }

      } else {
         if(class220.field2809 > 1) {
            field1100 = null;
         }

      }
   }

   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = Widget.method3999();

         for(int var2 = 0; var2 < var1.length; ++var2) {
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
                  int var25 = Integer.parseInt(var4);
                  BuildType[] var7 = class35.method507();
                  int var8 = 0;

                  BuildType var36;
                  while(true) {
                     if(var8 >= var7.length) {
                        var36 = null;
                        break;
                     }

                     BuildType var9 = var7[var8];
                     if(var25 == var9.ordinal) {
                        var36 = var9;
                        break;
                     }

                     ++var8;
                  }

                  Huffman.field2332 = var36;
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
                  class232[] var5 = new class232[]{class232.field3199, class232.field3201, class232.field3204, class232.field3202, class232.field3198, class232.field3200};
                  field1207 = (class232)class134.forOrdinal(var5, Integer.parseInt(var4));
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
         }

         Region.lowMemory = false;
         lowMemory = false;
         DState.host = this.getCodeBase().getHost();
         String var32 = Huffman.field2332.identifier;
         byte var33 = 0;

         try {
            class182.field2445 = 17;
            class35.field514 = var33;

            try {
               class155.osName = System.getProperty("os.name");
            } catch (Exception var28) {
               class155.osName = "Unknown";
            }

            class155.osNameLC = class155.osName.toLowerCase();

            try {
               GraphicsObject.userHome = System.getProperty("user.home");
               if(GraphicsObject.userHome != null) {
                  GraphicsObject.userHome = GraphicsObject.userHome + "/";
               }
            } catch (Exception var27) {
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
            } catch (Exception var26) {
               ;
            }

            if(GraphicsObject.userHome == null) {
               GraphicsObject.userHome = "~/";
            }

            class37.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", GraphicsObject.userHome, "/tmp/", ""};
            FaceNormal.field2153 = new String[]{".jagex_cache_" + class35.field514, ".file_store_" + class35.field514};
            int var17 = 0;

            label264:
            while(var17 < 4) {
               String var37 = var17 == 0?"":"" + var17;
               class155.field2257 = new File(GraphicsObject.userHome, "jagex_cl_oldschool_" + var32 + var37 + ".dat");
               String var6 = null;
               String var39 = null;
               boolean var40 = false;
               File var43;
               if(class155.field2257.exists()) {
                  try {
                     FileOnDisk var41 = new FileOnDisk(class155.field2257, "rw", 10000L);

                     Buffer var10;
                     int var11;
                     for(var10 = new Buffer((int)var41.length()); var10.offset < var10.payload.length; var10.offset += var11) {
                        var11 = var41.read(var10.payload, var10.offset, var10.payload.length - var10.offset);
                        if(var11 == -1) {
                           throw new IOException();
                        }
                     }

                     var10.offset = 0;
                     var11 = var10.readUnsignedByte();
                     if(var11 < 1 || var11 > 3) {
                        throw new IOException("" + var11);
                     }

                     int var12 = 0;
                     if(var11 > 1) {
                        var12 = var10.readUnsignedByte();
                     }

                     if(var11 <= 2) {
                        var6 = var10.getJagString();
                        if(var12 == 1) {
                           var39 = var10.getJagString();
                        }
                     } else {
                        var6 = var10.getCESU8();
                        if(var12 == 1) {
                           var39 = var10.getCESU8();
                        }
                     }

                     var41.close();
                  } catch (IOException var30) {
                     var30.printStackTrace();
                  }

                  if(var6 != null) {
                     var43 = new File(var6);
                     if(!var43.exists()) {
                        var6 = null;
                     }
                  }

                  if(var6 != null) {
                     var43 = new File(var6, "test.dat");
                     if(!class61.method1100(var43, true)) {
                        var6 = null;
                     }
                  }
               }

               if(var6 == null && var17 == 0) {
                  label240:
                  for(int var18 = 0; var18 < FaceNormal.field2153.length; ++var18) {
                     for(int var19 = 0; var19 < class37.cacheLocations.length; ++var19) {
                        File var20 = new File(class37.cacheLocations[var19] + FaceNormal.field2153[var18] + File.separatorChar + "oldschool" + File.separatorChar);
                        if(var20.exists() && class61.method1100(new File(var20, "test.dat"), true)) {
                           var6 = var20.toString();
                           var40 = true;
                           break label240;
                        }
                     }
                  }
               }

               if(var6 == null) {
                  var6 = GraphicsObject.userHome + File.separatorChar + "jagexcache" + var37 + File.separatorChar + "oldschool" + File.separatorChar + var32 + File.separatorChar;
                  var40 = true;
               }

               if(var39 != null) {
                  File var42 = new File(var39);
                  var43 = new File(var6);

                  try {
                     File[] var45 = var42.listFiles();
                     File[] var22 = var45;

                     for(int var13 = 0; var13 < var22.length; ++var13) {
                        File var14 = var22[var13];
                        File var15 = new File(var43, var14.getName());
                        boolean var16 = var14.renameTo(var15);
                        if(!var16) {
                           throw new IOException();
                        }
                     }
                  } catch (Exception var29) {
                     var29.printStackTrace();
                  }

                  var40 = true;
               }

               if(var40) {
                  Friend.method1118(new File(var6), (File)null);
               }

               File var35 = new File(var6);
               Frames.field2158 = var35;
               if(!Frames.field2158.exists()) {
                  Frames.field2158.mkdirs();
               }

               File[] var38 = Frames.field2158.listFiles();
               if(var38 == null) {
                  break;
               }

               File[] var44 = var38;
               int var23 = 0;

               while(true) {
                  if(var23 >= var44.length) {
                     break label264;
                  }

                  File var24 = var44[var23];
                  if(!class61.method1100(var24, false)) {
                     ++var17;
                     break;
                  }

                  ++var23;
               }
            }

            File var34 = Frames.field2158;
            class157.field2268 = var34;
            if(!class157.field2268.exists()) {
               throw new RuntimeException("");
            }

            class157.field2271 = true;
            Player.method1177();
            class155.field2259 = new CacheFile(new FileOnDisk(class40.method561("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class155.field2262 = new CacheFile(new FileOnDisk(class40.method561("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            BaseVarType.field32 = new CacheFile[class182.field2445];

            for(int var21 = 0; var21 < class182.field2445; ++var21) {
               BaseVarType.field32[var21] = new CacheFile(new FileOnDisk(class40.method561("main_file_cache.idx" + var21), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var31) {
            MilliTimer.method2912((String)null, var31);
         }

         class261.clientInstance = this;
         this.initialize(765, 503, 148);
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

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var42 = class61.field771[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class61.tileHeights[var2][var12 + 1][var11] - class61.tileHeights[var2][var12 - 1][var11];
               var14 = class61.tileHeights[var2][var12][var11 + 1] - class61.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var14 * var14 + var13 * var13 + 65536));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var16 * -50 + var17 * -10 + var18 * -50) / var10 + 96;
               var20 = (var42[var12][var11] >> 1) + (var42[var12 - 1][var11] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11 - 1] >> 2) + (var42[var12][1 + var11] >> 3);
               class61.field774[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class17.blendedHue[var11] = 0;
            Permission.blendedSaturation[var11] = 0;
            class10.field258[var11] = 0;
            Timer.field2273[var11] = 0;
            Buffer.field2406[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class61.underlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = class220.method4054(var14 - 1);
                     class17.blendedHue[var12] += var43.hue;
                     Permission.blendedSaturation[var12] += var43.saturation;
                     class10.field258[var12] += var43.lightness;
                     Timer.field2273[var12] += var43.hueMultiplier;
                     ++Buffer.field2406[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class61.underlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = class220.method4054(var15 - 1);
                     class17.blendedHue[var12] -= var44.hue;
                     Permission.blendedSaturation[var12] -= var44.saturation;
                     class10.field258[var12] -= var44.lightness;
                     Timer.field2273[var12] -= var44.hueMultiplier;
                     --Buffer.field2406[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = var17 + 5;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class17.blendedHue[var18];
                     var13 += Permission.blendedSaturation[var18];
                     var14 += class10.field258[var18];
                     var15 += Timer.field2273[var18];
                     var16 += Buffer.field2406[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class17.blendedHue[var19];
                     var13 -= Permission.blendedSaturation[var19];
                     var14 -= class10.field258[var19];
                     var15 -= Timer.field2273[var19];
                     var16 -= Buffer.field2406[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!lowMemory || (class61.tileSettings[0][var11][var17] & 2) != 0 || (class61.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class61.field770) {
                        class61.field770 = var2;
                     }

                     var20 = class61.underlayIds[var2][var11][var17] & 255;
                     int var21 = class61.overlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class61.tileHeights[var2][var11][var17];
                        int var23 = class61.tileHeights[var2][var11 + 1][var17];
                        int var24 = class61.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class61.tileHeights[var2][var11][var17 + 1];
                        int var26 = class61.field774[var11][var17];
                        int var27 = class61.field774[var11 + 1][var17];
                        int var28 = class61.field774[var11 + 1][var17 + 1];
                        int var29 = class61.field774[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class205.hsl24to16(var32, var33, var34);
                           var32 = var32 + class61.field779 & 255;
                           var34 += class61.field782;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class205.hsl24to16(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var46 = true;
                           if(var20 == 0 && class36.overlayPaths[var2][var11][var17] != 0) {
                              var46 = false;
                           }

                           if(var21 > 0 && !NPC.method1706(var21 - 1).isHidden) {
                              var46 = false;
                           }

                           if(var46 && var23 == var22 && var24 == var22 && var22 == var25) {
                              class39.field555[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = Graphics3D.colorPalette[class61.method1102(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class61.method1102(var30, var26), class61.method1102(var30, var27), class61.method1102(var30, var28), class61.method1102(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class36.overlayPaths[var2][var11][var17] + 1;
                           byte var47 = class67.overlayRotations[var2][var11][var17];
                           Overlay var35 = NPC.method1706(var21 - 1);
                           int var36 = var35.texture;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = Graphics3D.textureLoader.getAverageTextureRGB(var36);
                              var37 = -1;
                           } else if(var35.color == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class205.hsl24to16(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class61.field779 & 255;
                              var40 = var35.lightness + class61.field782;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class205.hsl24to16(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = Graphics3D.colorPalette[class39.adjustHSLListness0(var38, 96)];
                           }

                           if(var35.otherRgbColor != -1) {
                              var40 = var35.otherHue + class61.field779 & 255;
                              int var41 = var35.otherLightness + class61.field782;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class205.hsl24to16(var40, var35.otherSaturation, var41);
                              var39 = Graphics3D.colorPalette[class39.adjustHSLListness0(var38, 96)];
                           }

                           var0.addTile(var2, var11, var17, var33, var47, var36, var22, var23, var24, var25, class61.method1102(var30, var26), class61.method1102(var30, var27), class61.method1102(var30, var28), class61.method1102(var30, var29), class39.adjustHSLListness0(var37, var26), class39.adjustHSLListness0(var37, var27), class39.adjustHSLListness0(var37, var28), class39.adjustHSLListness0(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.setPhysicalLevel(var2, var12, var11, Tile.method2485(var2, var12, var11));
            }
         }

         class61.underlayIds[var2] = null;
         class61.overlayIds[var2] = null;
         class36.overlayPaths[var2] = null;
         class67.overlayRotations[var2] = null;
         class61.field771[var2] = null;
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

         for(int var6 = 0; var6 <= var5; ++var6) {
            for(int var7 = 0; var7 <= 104; ++var7) {
               for(int var8 = 0; var8 <= 104; ++var8) {
                  short var45;
                  if((class39.field555[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class39.field555[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class39.field555[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label471:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class39.field555[var11 - 1][var8][var13] & var2) == 0) {
                              break label471;
                           }
                        }

                        --var11;
                     }

                     label460:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class39.field555[var12 + 1][var8][var13] & var2) == 0) {
                              break label460;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class61.tileHeights[var12][var8][var9] - var45;
                        var16 = class61.tileHeights[var11][var8][var9];
                        Region.addOcclude(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class39.field555[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class39.field555[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class39.field555[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class39.field555[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label524:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class39.field555[var11 - 1][var13][var7] & var3) == 0) {
                              break label524;
                           }
                        }

                        --var11;
                     }

                     label513:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class39.field555[var12 + 1][var13][var7] & var3) == 0) {
                              break label513;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + (var10 - var9)) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class61.tileHeights[var12][var9][var7] - var45;
                        var16 = class61.tileHeights[var11][var9][var7];
                        Region.addOcclude(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class39.field555[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class39.field555[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class39.field555[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class39.field555[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label577:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class39.field555[var6][var9 - 1][var13] & var4) == 0) {
                              break label577;
                           }
                        }

                        --var9;
                     }

                     label566:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class39.field555[var6][var10 + 1][var13] & var4) == 0) {
                              break label566;
                           }
                        }

                        ++var10;
                     }

                     if((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
                        var13 = class61.tileHeights[var6][var9][var11];
                        Region.addOcclude(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class39.field555[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }
}
