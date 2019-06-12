import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameShell implements Usernamed {
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = -783816509
   )
   @Export("rootWidgetGroup")
   static int rootWidgetGroup;
   @ObfuscatedName("mc")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("clickedWidget")
   static Widget clickedWidget;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = 1348053843
   )
   @Export("__client_oo")
   static int __client_oo;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = -546798303
   )
   @Export("rootWidgetCount")
   static int rootWidgetCount;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      longValue = 8818983958751331899L
   )
   @Export("__client_oa")
   static long __client_oa;
   @ObfuscatedName("od")
   @Export("__client_od")
   static boolean[] __client_od;
   @ObfuscatedName("oq")
   @Export("__client_oq")
   static boolean[] __client_oq;
   @ObfuscatedName("ot")
   @Export("__client_ot")
   static boolean[] __client_ot;
   @ObfuscatedName("nt")
   @Export("__client_nt")
   static boolean __client_nt;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = -1379876433
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("or")
   @Export("isResizable")
   static boolean isResizable;
   @ObfuscatedName("ss")
   @ObfuscatedGetter(
      intValue = -451622431
   )
   @Export("__client_ss")
   public static int __client_ss;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = -934082817
   )
   @Export("__client_na")
   static int __client_na;
   @ObfuscatedName("nn")
   @Export("__client_nn")
   static boolean __client_nn;
   @ObfuscatedName("qq")
   @Export("__client_qq")
   static boolean __client_qq;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = -1972775883
   )
   @Export("widgetClickX")
   static int widgetClickX;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 1052276727
   )
   @Export("widgetClickY")
   static int widgetClickY;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = -843739713
   )
   @Export("__client_nw")
   static int __client_nw;
   @ObfuscatedName("mr")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("clickedWidgetParent")
   static Widget clickedWidgetParent;
   @ObfuscatedName("oj")
   @Export("rootWidgetWidths")
   static int[] rootWidgetWidths;
   @ObfuscatedName("mj")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   @Export("widgetGroupParents")
   static NodeHashTable widgetGroupParents;
   @ObfuscatedName("oy")
   @Export("rootWidgetXs")
   static int[] rootWidgetXs;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = 1939745821
   )
   @Export("__client_nl")
   static int __client_nl;
   @ObfuscatedName("mx")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("viewportWidget")
   static Widget viewportWidget;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = -12672775
   )
   @Export("gameDrawingMode")
   static int gameDrawingMode;
   @ObfuscatedName("ox")
   @Export("rootWidgetHeights")
   static int[] rootWidgetHeights;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = 821563709
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("oi")
   @Export("rootWidgetYs")
   static int[] rootWidgetYs;
   @ObfuscatedName("qz")
   @Export("isCameraLocked")
   static boolean isCameraLocked;
   @ObfuscatedName("on")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   @Export("widgetClickMasks")
   static NodeHashTable widgetClickMasks;
   @ObfuscatedName("tb")
   @ObfuscatedSignature(
      signature = "Lbl;"
   )
   static final class65 field895;
   @ObfuscatedName("og")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("scriptEvents")
   static NodeDeque scriptEvents;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = 1019025247
   )
   @Export("__client_nk")
   static int __client_nk;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = 1881890525
   )
   @Export("__client_np")
   static int __client_np;
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      intValue = -362336323
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("pk")
   @ObfuscatedGetter(
      intValue = 1298845031
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = -34294211
   )
   @Export("__client_qy")
   static int __client_qy;
   @ObfuscatedName("tp")
   @Export("__client_tp")
   static int[] __client_tp;
   @ObfuscatedName("th")
   @Export("__client_th")
   static int[] __client_th;
   @ObfuscatedName("ny")
   @Export("isDraggingWidget")
   static boolean isDraggingWidget;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = -1628183831
   )
   @Export("mouseWheelRotation")
   static int mouseWheelRotation;
   @ObfuscatedName("mk")
   @Export("selectedSpellActionName")
   static String selectedSpellActionName;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = 933910819
   )
   @Export("runEnergy")
   static int runEnergy;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = 36001423
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("mu")
   @Export("selectedSpellName")
   static String selectedSpellName;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = -818676431
   )
   @Export("__client_qc")
   static int __client_qc;
   @ObfuscatedName("nz")
   @Export("__client_nz")
   static int[] __client_nz;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = 743073293
   )
   @Export("__client_ns")
   static int __client_ns;
   @ObfuscatedName("sd")
   @ObfuscatedGetter(
      intValue = 944933439
   )
   @Export("__client_sd")
   static int __client_sd;
   @ObfuscatedName("ru")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   @Export("__client_ru")
   static PlayerAppearance __client_ru;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -1481002083
   )
   @Export("soundEffectCount")
   static int soundEffectCount;
   @ObfuscatedName("sb")
   @ObfuscatedSignature(
      signature = "[Lx;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("qv")
   @Export("soundEffectIds")
   static int[] soundEffectIds;
   @ObfuscatedName("sy")
   @Export("indexCacheLoaders")
   static ArrayList indexCacheLoaders;
   @ObfuscatedName("sl")
   @ObfuscatedGetter(
      intValue = -1605855913
   )
   @Export("__client_sl")
   static int __client_sl;
   @ObfuscatedName("md")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("draggedOnWidget")
   static Widget draggedOnWidget;
   @ObfuscatedName("sq")
   @ObfuscatedGetter(
      intValue = -1546210597
   )
   @Export("indexCacheLoaderIndex")
   static int indexCacheLoaderIndex;
   @ObfuscatedName("qn")
   @Export("unknownSoundValues1")
   static int[] unknownSoundValues1;
   @ObfuscatedName("qd")
   @Export("queuedSoundEffectDelays")
   static int[] queuedSoundEffectDelays;
   @ObfuscatedName("nr")
   @Export("__client_nr")
   static int[] __client_nr;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = -758575207
   )
   @Export("__client_nv")
   static int __client_nv;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = 760022015
   )
   @Export("__client_nd")
   static int __client_nd;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = 1990512261
   )
   @Export("__client_ni")
   static int __client_ni;
   @ObfuscatedName("qe")
   @ObfuscatedSignature(
      signature = "[Lci;"
   )
   @Export("soundEffects")
   static SoundEffect[] soundEffects;
   @ObfuscatedName("qk")
   @Export("soundLocations")
   static int[] soundLocations;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = -137788125
   )
   @Export("minimapState")
   static int minimapState;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = 587773171
   )
   @Export("__client_ph")
   static int __client_ph;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      longValue = -1704358328771670975L
   )
   @Export("__client_pp")
   static long __client_pp;
   @ObfuscatedName("sk")
   @ObfuscatedSignature(
      signature = "Llm;"
   )
   @Export("platformInfoProvider")
   static PlatformInfoProvider platformInfoProvider;
   @ObfuscatedName("mo")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("__client_mo")
   static Widget __client_mo;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 1365951359
   )
   @Export("__client_qf")
   static int __client_qf;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -278874973
   )
   @Export("__client_nh")
   static int __client_nh;
   @ObfuscatedName("rw")
   @Export("__client_rw")
   static short __client_rw;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = -1352723865
   )
   @Export("__client_qp")
   static int __client_qp;
   @ObfuscatedName("rm")
   @Export("__client_rm")
   static short __client_rm;
   @ObfuscatedName("rs")
   @Export("__client_rs")
   static short __client_rs;
   @ObfuscatedName("rp")
   @Export("__client_rp")
   static short __client_rp;
   @ObfuscatedName("ri")
   @Export("__client_ri")
   static short __client_ri;
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = 864673321
   )
   @Export("mapIconCount")
   static int mapIconCount;
   @ObfuscatedName("rz")
   @ObfuscatedGetter(
      intValue = 541065633
   )
   @Export("viewportZoom")
   static int viewportZoom;
   @ObfuscatedName("rv")
   @Export("__client_rv")
   static short __client_rv;
   @ObfuscatedName("ry")
   @ObfuscatedGetter(
      intValue = 2035623995
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("rx")
   @ObfuscatedGetter(
      intValue = -629885193
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("ps")
   @Export("mapIconXs")
   static int[] mapIconXs;
   @ObfuscatedName("pw")
   @Export("mapIconYs")
   static int[] mapIconYs;
   @ObfuscatedName("mg")
   @ObfuscatedGetter(
      intValue = 247245677
   )
   @Export("chatEffects")
   static int chatEffects;
   @ObfuscatedName("po")
   @ObfuscatedSignature(
      signature = "[Lln;"
   )
   @Export("mapIcons")
   static Sprite[] mapIcons;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = 1694810089
   )
   @Export("__client_mb")
   static int __client_mb;
   @ObfuscatedName("rr")
   @ObfuscatedGetter(
      intValue = 386331251
   )
   @Export("viewportOffsetX")
   static int viewportOffsetX;
   @ObfuscatedName("rn")
   @ObfuscatedGetter(
      intValue = 992721193
   )
   @Export("viewportOffsetY")
   static int viewportOffsetY;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = -460406997
   )
   @Export("__client_pm")
   static int __client_pm;
   @ObfuscatedName("pl")
   @ObfuscatedGetter(
      intValue = -1362734353
   )
   @Export("__client_pl")
   static int __client_pl;
   @ObfuscatedName("rh")
   @Export("__client_rh")
   static boolean[] __client_rh;
   @ObfuscatedName("ml")
   @ObfuscatedGetter(
      intValue = 1602665191
   )
   @Export("followerIndex")
   static int followerIndex;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      intValue = -1802494233
   )
   @Export("publicChatMode")
   static int publicChatMode;
   @ObfuscatedName("sx")
   @ObfuscatedGetter(
      intValue = 206275573
   )
   @Export("__client_sx")
   static int __client_sx;
   @ObfuscatedName("rd")
   @Export("__client_rd")
   static int[] __client_rd;
   @ObfuscatedName("rl")
   @Export("__client_rl")
   static int[] __client_rl;
   @ObfuscatedName("rj")
   @Export("__client_rj")
   static int[] __client_rj;
   @ObfuscatedName("rk")
   @Export("__client_rk")
   static int[] __client_rk;
   @ObfuscatedName("pn")
   @Export("__client_pn")
   static int[] __client_pn;
   @ObfuscatedName("pq")
   @Export("__client_pq")
   static int[] __client_pq;
   @ObfuscatedName("oh")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("__client_oh")
   static NodeDeque __client_oh;
   @ObfuscatedName("oc")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("__client_oc")
   static NodeDeque __client_oc;
   @ObfuscatedName("rb")
   @Export("__client_rb")
   static short __client_rb;
   @ObfuscatedName("re")
   @Export("__client_re")
   static short __client_re;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = -1715020411
   )
   @Export("__client_mf")
   static int __client_mf;
   @ObfuscatedName("pu")
   @Export("__client_pu")
   static long[] __client_pu;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = 2128395635
   )
   @Export("__client_ms")
   static int __client_ms;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = 344308849
   )
   @Export("__client_nc")
   static int __client_nc;
   @ObfuscatedName("nf")
   @Export("changedSkills")
   static int[] changedSkills;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = 1132932607
   )
   @Export("changedSkillsCount")
   static int changedSkillsCount;
   @ObfuscatedName("mn")
   @Export("__client_mn")
   static boolean __client_mn;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = 1230692157
   )
   @Export("__client_pb")
   static int __client_pb;
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = 1467519791
   )
   @Export("chatCycle")
   static int chatCycle;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = 535219347
   )
   @Export("__client_mh")
   static int __client_mh;
   @ObfuscatedName("pz")
   @Export("__client_pz")
   static String __client_pz;
   @ObfuscatedName("sj")
   @ObfuscatedSignature(
      signature = "Lbj;"
   )
   @Export("__client_sj")
   static OwnWorldComparator __client_sj;
   @ObfuscatedName("pv")
   @Export("__client_pv")
   static int[] __client_pv;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfy;"
   )
   @Export("collisionMaps")
   static CollisionMap[] collisionMaps;
   @ObfuscatedName("ai")
   @Export("__client_ai")
   static boolean __client_ai;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1412639841
   )
   @Export("worldId")
   public static int worldId;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 352819683
   )
   @Export("worldProperties")
   static int worldProperties;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1186004739
   )
   @Export("gameBuild")
   static int gameBuild;
   @ObfuscatedName("bd")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("bc")
   @Export("isLowDetail")
   static boolean isLowDetail;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 2068355509
   )
   @Export("language")
   static int language;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 1678472241
   )
   @Export("clientType")
   static int clientType;
   @ObfuscatedName("bl")
   @Export("__client_bl")
   static boolean __client_bl;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 244995961
   )
   @Export("gameState")
   static int gameState;
   @ObfuscatedName("cj")
   @Export("isLoading")
   static boolean isLoading;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 1909006131
   )
   @Export("cycle")
   static int cycle;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      longValue = 8445874050676184263L
   )
   @Export("mouseLastLastPressedTimeMillis")
   static long mouseLastLastPressedTimeMillis;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -1731573291
   )
   @Export("__client_cn")
   static int __client_cn;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1313705721
   )
   @Export("__client_cq")
   static int __client_cq;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      longValue = -6574384275386813769L
   )
   @Export("__client_ch")
   static long __client_ch;
   @ObfuscatedName("cw")
   @Export("__client_cw")
   static boolean __client_cw;
   @ObfuscatedName("cg")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -1792536059
   )
   @Export("rebootTimer")
   static int rebootTimer;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -871534943
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 1485594821
   )
   @Export("hintArrowNpcIndex")
   static int hintArrowNpcIndex;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -1036874153
   )
   @Export("hintArrowPlayerIndex")
   static int hintArrowPlayerIndex;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -1757834373
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -123748133
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -627650567
   )
   @Export("hintArrowHeight")
   static int hintArrowHeight;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 749254081
   )
   @Export("hintArrowSubX")
   static int hintArrowSubX;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 1393270633
   )
   @Export("hintArrowSubY")
   static int hintArrowSubY;
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   @Export("playerAttackOption")
   static AttackOption playerAttackOption;
   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   @Export("npcAttackOption")
   static AttackOption npcAttackOption;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = -1520594673
   )
   @Export("titleLoadingStage")
   static int titleLoadingStage;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = -1431050759
   )
   @Export("js5ConnectState")
   static int js5ConnectState;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = 1154760205
   )
   @Export("__client_dp")
   static int __client_dp;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = 1791955261
   )
   @Export("js5Errors")
   static int js5Errors;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -163579343
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = 755300107
   )
   @Export("__client_ex")
   static int __client_ex;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -964416527
   )
   @Export("__client_ej")
   static int __client_ej;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 689094231
   )
   @Export("__client_el")
   static int __client_el;
   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "Lfc;"
   )
   static class159 field658;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = -447055355
   )
   @Export("__client_eo")
   static int __client_eo;
   @ObfuscatedName("ew")
   @Export("Login_isUsernameRemembered")
   static boolean Login_isUsernameRemembered;
   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "Lcn;"
   )
   @Export("secureRandomFuture")
   static SecureRandomFuture secureRandomFuture;
   @ObfuscatedName("ev")
   @Export("__client_ev")
   static byte[] __client_ev;
   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "[Lcv;"
   )
   @Export("npcs")
   static Npc[] npcs;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -1569269731
   )
   @Export("npcCount")
   static int npcCount;
   @ObfuscatedName("fq")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 516059665
   )
   @Export("__client_fw")
   static int __client_fw;
   @ObfuscatedName("fg")
   @Export("__client_fg")
   static int[] __client_fg;
   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   @Export("packetWriter")
   public static final PacketWriter packetWriter;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -1050480853
   )
   @Export("__client_fd")
   static int __client_fd;
   @ObfuscatedName("fh")
   @Export("__client_fh")
   static boolean __client_fh;
   @ObfuscatedName("fx")
   @Export("useBufferedSocket")
   static boolean useBufferedSocket;
   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   @Export("timer")
   static Timer timer;
   @ObfuscatedName("ft")
   @Export("fontsMap")
   static HashMap fontsMap;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = 829228151
   )
   @Export("__client_fe")
   static int __client_fe;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = -597100741
   )
   @Export("__client_fn")
   static int __client_fn;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 8470625
   )
   @Export("__client_fk")
   static int __client_fk;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 685418907
   )
   @Export("__client_gp")
   static int __client_gp;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -1456975367
   )
   @Export("__client_gh")
   static int __client_gh;
   @ObfuscatedName("gg")
   @Export("isInInstance")
   static boolean isInInstance;
   @ObfuscatedName("gq")
   @Export("instanceChunkTemplates")
   static int[][][] instanceChunkTemplates;
   @ObfuscatedName("gd")
   @Export("__client_gd")
   static final int[] __client_gd;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -134014371
   )
   @Export("__client_gy")
   static int __client_gy;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = -1406125895
   )
   @Export("__client_hx")
   static int __client_hx;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = -516933613
   )
   @Export("__client_hn")
   static int __client_hn;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = 1664350313
   )
   @Export("__client_hr")
   static int __client_hr;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = 1658018867
   )
   @Export("__client_hg")
   static int __client_hg;
   @ObfuscatedName("hh")
   @Export("__client_hh")
   static boolean __client_hh;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = 438998245
   )
   @Export("__client_hd")
   static int __client_hd;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 410614005
   )
   @Export("cameraPitchTarget")
   static int cameraPitchTarget;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = -1163038981
   )
   @Export("minimapOrientation")
   static int minimapOrientation;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 218086227
   )
   @Export("__client_hv")
   static int __client_hv;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -480633777
   )
   @Export("__client_hu")
   static int __client_hu;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 402871301
   )
   @Export("__client_hi")
   static int __client_hi;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = 1502058429
   )
   @Export("__client_ht")
   static int __client_ht;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = -1420078475
   )
   @Export("oculusOrbState")
   static int oculusOrbState;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = 1005832199
   )
   @Export("cameraFollowHeight")
   static int cameraFollowHeight;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = -441913785
   )
   @Export("__client_hc")
   static int __client_hc;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = -1149138989
   )
   @Export("__client_hk")
   static int __client_hk;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -952172003
   )
   @Export("__client_if")
   static int __client_if;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = 236939601
   )
   @Export("oculusOrbNormalSpeed")
   static int oculusOrbNormalSpeed;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = 351193663
   )
   @Export("__client_in")
   static int __client_in;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = -1063713523
   )
   @Export("__client_il")
   public static int __client_il;
   @ObfuscatedName("ij")
   @Export("__client_ij")
   static boolean __client_ij;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -1213062413
   )
   @Export("__client_iy")
   static int __client_iy;
   @ObfuscatedName("is")
   @Export("__client_is")
   static boolean __client_is;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 910983131
   )
   @Export("__client_ik")
   static int __client_ik;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = 616180377
   )
   @Export("overheadTextCount")
   static int overheadTextCount;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = 1889277277
   )
   @Export("overheadTextLimit")
   static int overheadTextLimit;
   @ObfuscatedName("it")
   @Export("selectedItemName")
   static String selectedItemName;
   @ObfuscatedName("iq")
   @Export("overheadTextXs")
   static int[] overheadTextXs;
   @ObfuscatedName("iu")
   @Export("overheadTextYs")
   static int[] overheadTextYs;
   @ObfuscatedName("ip")
   @Export("overheadTextAscents")
   static int[] overheadTextAscents;
   @ObfuscatedName("ib")
   @Export("overheadTextXOffsets")
   static int[] overheadTextXOffsets;
   @ObfuscatedName("ic")
   @Export("overheadTextColors")
   static int[] overheadTextColors;
   @ObfuscatedName("iw")
   @Export("overheadTextEffects")
   static int[] overheadTextEffects;
   @ObfuscatedName("io")
   @Export("overheadTextCyclesRemaining")
   static int[] overheadTextCyclesRemaining;
   @ObfuscatedName("ih")
   @Export("overheadText")
   static String[] overheadText;
   @ObfuscatedName("im")
   @Export("tileLastDrawnActor")
   static int[][] tileLastDrawnActor;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = 289477221
   )
   @Export("viewportDrawCount")
   static int viewportDrawCount;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = 424442889
   )
   @Export("viewportTempX")
   static int viewportTempX;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = -81902865
   )
   @Export("viewportTempY")
   static int viewportTempY;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 202604997
   )
   @Export("mouseCrossX")
   static int mouseCrossX;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -1984048653
   )
   @Export("mouseCrossY")
   static int mouseCrossY;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -1302827103
   )
   @Export("mouseCrossState")
   static int mouseCrossState;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = 233318639
   )
   @Export("mouseCrossColor")
   static int mouseCrossColor;
   @ObfuscatedName("jr")
   @Export("showMouseCross")
   static boolean showMouseCross;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = 1691923909
   )
   @Export("__client_ju")
   static int __client_ju;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = -1267243587
   )
   @Export("__client_jz")
   static int __client_jz;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = 485534011
   )
   @Export("dragItemSlotSource")
   static int dragItemSlotSource;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = 813973829
   )
   @Export("__client_ja")
   static int __client_ja;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = 1959822241
   )
   @Export("__client_je")
   static int __client_je;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = -836653679
   )
   @Export("dragItemSlotDestination")
   static int dragItemSlotDestination;
   @ObfuscatedName("jl")
   @Export("__client_jl")
   static boolean __client_jl;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 1486366835
   )
   @Export("itemDragDuration")
   static int itemDragDuration;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = 1084498299
   )
   @Export("__client_jc")
   static int __client_jc;
   @ObfuscatedName("jj")
   @Export("showLoadingMessages")
   static boolean showLoadingMessages;
   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "[Lbr;"
   )
   @Export("players")
   static Player[] players;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = -1869532553
   )
   @Export("localPlayerIndex")
   static int localPlayerIndex;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -836962805
   )
   @Export("__client_jo")
   static int __client_jo;
   @ObfuscatedName("js")
   @Export("renderSelf")
   static boolean renderSelf;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -1208823721
   )
   @Export("__client_ke")
   static int __client_ke;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -64320473
   )
   @Export("__client_ky")
   static int __client_ky;
   @ObfuscatedName("kd")
   @Export("__client_kd")
   static int[] __client_kd;
   @ObfuscatedName("kp")
   @Export("playerMenuOpcodes")
   static final int[] playerMenuOpcodes;
   @ObfuscatedName("kq")
   @Export("playerMenuActions")
   static String[] playerMenuActions;
   @ObfuscatedName("kv")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("kn")
   @Export("__client_kn")
   static int[] __client_kn;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -1309758309
   )
   @Export("combatTargetPlayerIndex")
   static int combatTargetPlayerIndex;
   @ObfuscatedName("kz")
   @ObfuscatedSignature(
      signature = "[[[Lje;"
   )
   @Export("groundItems")
   static NodeDeque[][][] groundItems;
   @ObfuscatedName("kh")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("__client_kh")
   static NodeDeque __client_kh;
   @ObfuscatedName("kk")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("projectiles")
   static NodeDeque projectiles;
   @ObfuscatedName("kt")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("graphicsObjects")
   static NodeDeque graphicsObjects;
   @ObfuscatedName("ki")
   @Export("currentLevels")
   static int[] currentLevels;
   @ObfuscatedName("kr")
   @Export("levels")
   static int[] levels;
   @ObfuscatedName("kb")
   @Export("experience")
   static int[] experience;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = -898263359
   )
   @Export("__client_ku")
   static int __client_ku;
   @ObfuscatedName("kc")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = -1749538901
   )
   @Export("menuOptionsCount")
   static int menuOptionsCount;
   @ObfuscatedName("ly")
   @Export("menuArguments1")
   static int[] menuArguments1;
   @ObfuscatedName("li")
   @Export("menuArguments2")
   static int[] menuArguments2;
   @ObfuscatedName("lh")
   @Export("menuOpcodes")
   static int[] menuOpcodes;
   @ObfuscatedName("lk")
   @Export("menuArguments0")
   static int[] menuArguments0;
   @ObfuscatedName("ld")
   @Export("menuActions")
   static String[] menuActions;
   @ObfuscatedName("la")
   @Export("menuTargetNames")
   static String[] menuTargetNames;
   @ObfuscatedName("lt")
   @Export("menuShiftClick")
   static boolean[] menuShiftClick;
   @ObfuscatedName("lw")
   @Export("followerOpsLowPriority")
   static boolean followerOpsLowPriority;
   @ObfuscatedName("lf")
   @Export("shiftClickDrop")
   static boolean shiftClickDrop;
   @ObfuscatedName("lp")
   @Export("tapToDrop")
   static boolean tapToDrop;
   @ObfuscatedName("lj")
   @Export("showMouseOverText")
   static boolean showMouseOverText;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = 26099827
   )
   @Export("__client_lq")
   static int __client_lq;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = 885052255
   )
   @Export("__client_ln")
   static int __client_ln;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = 699084605
   )
   @Export("__client_lb")
   static int __client_lb;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = -274968037
   )
   @Export("__client_ls")
   static int __client_ls;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = 1630772923
   )
   @Export("isItemSelected")
   static int isItemSelected;
   @ObfuscatedName("lv")
   @Export("isSpellSelected")
   static boolean isSpellSelected;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 196309625
   )
   @Export("__client_lc")
   static int __client_lc;

   static {
      __client_ai = true;
      worldId = 1;
      worldProperties = 0;
      gameBuild = 0;
      isMembersWorld = false;
      isLowDetail = false;
      language = 0;
      clientType = -1;
      __client_bl = false;
      gameState = 0;
      isLoading = true;
      cycle = 0;
      mouseLastLastPressedTimeMillis = 1L;
      __client_cn = -1;
      __client_cq = -1;
      __client_ch = -1L;
      __client_cw = true;
      displayFps = false;
      rebootTimer = 0;
      hintArrowType = 0;
      hintArrowNpcIndex = 0;
      hintArrowPlayerIndex = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowHeight = 0;
      hintArrowSubX = 0;
      hintArrowSubY = 0;
      playerAttackOption = AttackOption.AttackOption_hidden;
      npcAttackOption = AttackOption.AttackOption_hidden;
      titleLoadingStage = 0;
      js5ConnectState = 0;
      __client_dp = 0;
      js5Errors = 0;
      loginState = 0;
      __client_ex = 0;
      __client_ej = 0;
      __client_el = 0;
      field658 = class159.field1985;
      Login_isUsernameRemembered = false;
      secureRandomFuture = new SecureRandomFuture();
      __client_ev = null;
      npcs = new Npc['耀'];
      npcCount = 0;
      npcIndices = new int['耀'];
      __client_fw = 0;
      __client_fg = new int[250];
      packetWriter = new PacketWriter();
      __client_fd = 0;
      __client_fh = false;
      useBufferedSocket = true;
      timer = new Timer();
      fontsMap = new HashMap();
      __client_fe = 0;
      __client_fn = 1;
      __client_fk = 0;
      __client_gp = 1;
      __client_gh = 0;
      collisionMaps = new CollisionMap[4];
      isInInstance = false;
      instanceChunkTemplates = new int[4][13][13];
      __client_gd = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      __client_gy = 0;
      __client_hx = 2301979;
      __client_hn = 5063219;
      __client_hr = 3353893;
      __client_hg = 7759444;
      __client_hh = false;
      __client_hd = 0;
      cameraPitchTarget = 128;
      minimapOrientation = 0;
      __client_hv = 0;
      __client_hu = 0;
      __client_hi = 0;
      __client_ht = 0;
      oculusOrbState = 0;
      cameraFollowHeight = 50;
      __client_hc = 0;
      __client_hk = 0;
      __client_if = 0;
      oculusOrbNormalSpeed = 12;
      __client_in = 6;
      __client_il = 0;
      __client_ij = false;
      __client_iy = 0;
      __client_is = false;
      __client_ik = 0;
      overheadTextCount = 0;
      overheadTextLimit = 50;
      overheadTextXs = new int[overheadTextLimit];
      overheadTextYs = new int[overheadTextLimit];
      overheadTextAscents = new int[overheadTextLimit];
      overheadTextXOffsets = new int[overheadTextLimit];
      overheadTextColors = new int[overheadTextLimit];
      overheadTextEffects = new int[overheadTextLimit];
      overheadTextCyclesRemaining = new int[overheadTextLimit];
      overheadText = new String[overheadTextLimit];
      tileLastDrawnActor = new int[104][104];
      viewportDrawCount = 0;
      viewportTempX = -1;
      viewportTempY = -1;
      mouseCrossX = 0;
      mouseCrossY = 0;
      mouseCrossState = 0;
      mouseCrossColor = 0;
      showMouseCross = true;
      __client_ju = 0;
      __client_jz = 0;
      dragItemSlotSource = 0;
      __client_ja = 0;
      __client_je = 0;
      dragItemSlotDestination = 0;
      __client_jl = false;
      itemDragDuration = 0;
      __client_jc = 0;
      showLoadingMessages = true;
      players = new Player[2048];
      localPlayerIndex = -1;
      __client_jo = 0;
      renderSelf = true;
      __client_ke = 0;
      __client_ky = 0;
      __client_kd = new int[1000];
      playerMenuOpcodes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerMenuActions = new String[8];
      playerOptionsPriorities = new boolean[8];
      __client_kn = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      combatTargetPlayerIndex = -1;
      groundItems = new NodeDeque[4][104][104];
      __client_kh = new NodeDeque();
      projectiles = new NodeDeque();
      graphicsObjects = new NodeDeque();
      currentLevels = new int[25];
      levels = new int[25];
      experience = new int[25];
      __client_ku = 0;
      isMenuOpen = false;
      menuOptionsCount = 0;
      menuArguments1 = new int[500];
      menuArguments2 = new int[500];
      menuOpcodes = new int[500];
      menuArguments0 = new int[500];
      menuActions = new String[500];
      menuTargetNames = new String[500];
      menuShiftClick = new boolean[500];
      followerOpsLowPriority = false;
      shiftClickDrop = false;
      tapToDrop = false;
      showMouseOverText = true;
      __client_lq = -1;
      __client_ln = -1;
      __client_lb = 0;
      __client_ls = 50;
      isItemSelected = 0;
      selectedItemName = null;
      isSpellSelected = false;
      __client_lc = -1;
      __client_mh = -1;
      selectedSpellActionName = null;
      selectedSpellName = null;
      rootWidgetGroup = -1;
      widgetGroupParents = new NodeHashTable(8);
      __client_mf = 0;
      __client_ms = -1;
      chatEffects = 0;
      __client_mb = 0;
      __client_mo = null;
      runEnergy = 0;
      weight = 0;
      rights = 0;
      followerIndex = -1;
      __client_mn = false;
      viewportWidget = null;
      clickedWidget = null;
      clickedWidgetParent = null;
      widgetClickX = 0;
      widgetClickY = 0;
      draggedOnWidget = null;
      __client_nn = false;
      __client_nw = -1;
      __client_nl = -1;
      __client_nt = false;
      __client_nk = -1;
      __client_np = -1;
      isDraggingWidget = false;
      cycleCntr = 1;
      __client_nr = new int[32];
      __client_nd = 0;
      __client_nz = new int[32];
      __client_ns = 0;
      changedSkills = new int[32];
      changedSkillsCount = 0;
      chatCycle = 0;
      __client_na = 0;
      __client_nh = 0;
      __client_nv = 0;
      __client_nc = 0;
      __client_ni = 0;
      mouseWheelRotation = 0;
      scriptEvents = new NodeDeque();
      __client_oh = new NodeDeque();
      __client_oc = new NodeDeque();
      widgetClickMasks = new NodeHashTable(512);
      rootWidgetCount = 0;
      __client_oo = -2;
      __client_od = new boolean[100];
      __client_ot = new boolean[100];
      __client_oq = new boolean[100];
      rootWidgetXs = new int[100];
      rootWidgetYs = new int[100];
      rootWidgetWidths = new int[100];
      rootWidgetHeights = new int[100];
      gameDrawingMode = 0;
      __client_oa = 0L;
      isResizable = true;
      __client_pv = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      publicChatMode = 0;
      __client_pl = 0;
      __client_pz = "";
      __client_pu = new long[100];
      __client_pb = 0;
      __client_pm = 0;
      __client_pq = new int[128];
      __client_pn = new int[128];
      __client_pp = -1L;
      __client_ph = -1;
      mapIconCount = 0;
      mapIconXs = new int[1000];
      mapIconYs = new int[1000];
      mapIcons = new Sprite[1000];
      destinationX = 0;
      destinationY = 0;
      minimapState = 0;
      __client_qf = 255;
      __client_qy = -1;
      __client_qq = false;
      __client_qp = 127;
      __client_qc = 127;
      soundEffectCount = 0;
      soundEffectIds = new int[50];
      unknownSoundValues1 = new int[50];
	  queuedSoundEffectDelays = new int[50];
      soundLocations = new int[50];
      soundEffects = new SoundEffect[50];
      isCameraLocked = false;
      __client_rh = new boolean[5];
      __client_rd = new int[5];
      __client_rl = new int[5];
      __client_rj = new int[5];
      __client_rk = new int[5];
      __client_rw = 256;
      __client_rm = 205;
      __client_re = 256;
      __client_rb = 320;
      __client_rv = 1;
      __client_ri = 32767;
      __client_rs = 1;
      __client_rp = 32767;
      viewportOffsetX = 0;
      viewportOffsetY = 0;
      viewportWidth = 0;
      viewportHeight = 0;
      viewportZoom = 0;
      __client_ru = new PlayerAppearance();
      __client_sd = -1;
      __client_sl = -1;
      platformInfoProvider = new DesktopPlatformInfoProvider();
      grandExchangeOffers = new GrandExchangeOffer[8];
      __client_sj = new OwnWorldComparator();
      __client_ss = -1;
      indexCacheLoaders = new ArrayList(10);
      indexCacheLoaderIndex = 0;
      __client_sx = 0;
      field895 = new class65();
      __client_tp = new int[50];
      __client_th = new int[50];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1773624745"
   )
   protected final void __j_113() {
      __client_oa = class203.currentTimeMs() + 500L;
      this.__ge_137();
      if(rootWidgetGroup != -1) {
         this.__iu_141(true);
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1297880469"
   )
   protected final void setUp() {
      WorldMapCacheName.method633(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
      class2.port1 = gameBuild == 0?43594:worldId + 40000;
      WorldMapArea.port2 = gameBuild == 0?443:worldId + 50000;
      class203.port3 = class2.port1;
      PlayerAppearance.__hi_g = class226.__ht_m;
      class229.__hz_l = class226.__ht_f;
      class227.__hj_e = class226.__ht_q;
      IndexCacheLoader.__bd_x = class226.__ht_w;
      TriBool.urlRequester = new UrlRequester();
      this.setUpKeyboard();
      this.setUpMouse();
      class16.mouseWheel = this.mouseWheel();
      Fonts.indexStore255 = new IndexStore(255, class168.dat2File, class168.idx255File, 500000);
      ReflectionCheck.clientPreferences = class306.method5780();
      this.setUpClipboard();
      String var2 = Ignored.__ks_at;
      class50.__af_m = this;
      if(var2 != null) {
         class50.__af_f = var2;
      }

      if(gameBuild != 0) {
         displayFps = true;
      }

      GroundItem.method2095(ReflectionCheck.clientPreferences.windowMode);
      WorldMapArea.friendSystem = new FriendSystem(KeyHandler.loginType);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1445885427"
   )
   protected final void __al_111() {
      ++cycle;
      this.doCycleJs5();
      class3.method41();

      int var1;
      try {
         if(class214.__hf_o == 1) {
            var1 = class214.midiPcmStream.__f_341();
            if(var1 > 0 && class214.midiPcmStream.isReady()) {
               var1 -= FaceNormal.__el_x;
               if(var1 < 0) {
                  var1 = 0;
               }

               class214.midiPcmStream.__m_340(var1);
            } else {
               class214.midiPcmStream.clear();
               class214.midiPcmStream.removeAll();
               if(class214.__hf_u != null) {
                  class214.__hf_o = 2;
               } else {
                  class214.__hf_o = 0;
               }

               class13.musicTrack = null;
               class307.soundCache = null;
            }
         }
      } catch (Exception var63) {
         var63.printStackTrace();
         class214.midiPcmStream.clear();
         class214.__hf_o = 0;
         class13.musicTrack = null;
         class307.soundCache = null;
         class214.__hf_u = null;
      }

      class13.playPcmPlayers();
      class171.method3498();
      MouseHandler var47 = MouseHandler.MouseHandler_instance;
      synchronized(MouseHandler.MouseHandler_instance) {
         MouseHandler.MouseHandler_currentButton = MouseHandler.MouseHandler_currentButton0;
         MouseHandler.MouseHandler_x = MouseHandler.MouseHandler_x0;
         MouseHandler.MouseHandler_y = MouseHandler.MouseHandler_y0;
         MouseHandler.MouseHandler_millis = MouseHandler.MouseHandler_millis0;
         MouseHandler.MouseHandler_lastButton = MouseHandler.MouseHandler_lastButton0;
         MouseHandler.MouseHandler_lastPressedX = MouseHandler.MouseHandler_lastPressedX0;
         MouseHandler.MouseHandler_lastPressedY = MouseHandler.MouseHandler_lastPressedY0;
         MouseHandler.MouseHandler_lastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis0;
         MouseHandler.MouseHandler_lastButton0 = 0;
      }

      if(class16.mouseWheel != null) {
         var1 = class16.mouseWheel.useRotation();
         mouseWheelRotation = var1;
      }

      if(gameState == 0) {
         class171.method3497();
         class11.method145();
      } else if(gameState == 5) {
         class54.method1092(this);
         class171.method3497();
         class11.method145();
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class54.method1092(this);
            this.doCycleLoggedOut();
         } else if(gameState == 25) {
            UserComparator10.method3352(false);
            __client_fe = 0;
            boolean var64 = true;

            int var48;
            for(var48 = 0; var48 < class40.regionLandArchives.length; ++var48) {
               if(IndexCacheLoader.regionMapArchiveIds[var48] != -1 && class40.regionLandArchives[var48] == null) {
                  class40.regionLandArchives[var48] = SecureRandomFuture.indexCache5.takeRecord(IndexCacheLoader.regionMapArchiveIds[var48], 0);
                  if(class40.regionLandArchives[var48] == null) {
                     var64 = false;
                     ++__client_fe;
                  }
               }

               if(MouseHandler.regionLandArchiveIds[var48] != -1 && HealthBarUpdate.regionMapArchives[var48] == null) {
                  HealthBarUpdate.regionMapArchives[var48] = SecureRandomFuture.indexCache5.takeRecordEncrypted(MouseHandler.regionLandArchiveIds[var48], 0, class190.xteaKeys[var48]);
                  if(HealthBarUpdate.regionMapArchives[var48] == null) {
                     var64 = false;
                     ++__client_fe;
                  }
               }
            }

            if(!var64) {
               __client_gh = 1;
            } else {
               __client_fk = 0;
               var64 = true;

               int var4;
               int var5;
               for(var48 = 0; var48 < class40.regionLandArchives.length; ++var48) {
                  byte[] var3 = HealthBarUpdate.regionMapArchives[var48];
                  if(var3 != null) {
                     var4 = (class308.regions[var48] >> 8) * 64 - class50.baseX;
                     var5 = (class308.regions[var48] & 255) * 64 - GraphicsObject.baseY;
                     if(isInInstance) {
                        var4 = 10;
                        var5 = 10;
                     }

                     var64 &= TextureProvider.method2774(var3, var4, var5);
                  }
               }

               if(!var64) {
                  __client_gh = 2;
               } else {
                  if(__client_gh != 0) {
                     class68.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                  }

                  class13.playPcmPlayers();
                  class65.scene.clear();

                  for(var48 = 0; var48 < 4; ++var48) {
                     collisionMaps[var48].clear();
                  }

                  int var49;
                  for(var48 = 0; var48 < 4; ++var48) {
                     for(var49 = 0; var49 < 104; ++var49) {
                        for(var4 = 0; var4 < 104; ++var4) {
                           Tiles.Tiles_renderFlags[var48][var49][var4] = 0;
                        }
                     }
                  }

                  class13.playPcmPlayers();
                  Tiles.Tiles_minPlane = 99;
                  Tiles.__bq_w = new byte[4][104][104];
                  Fonts.__kz_o = new byte[4][104][104];
                  class32.__ay_u = new byte[4][104][104];
                  class307.__kc_g = new byte[4][104][104];
                  Tiles.__bq_a = new int[4][105][105];
                  Tiles.__bq_l = new byte[4][105][105];
                  Huffman.__gd_e = new int[105][105];
                  class13.__i_x = new int[104];
                  Formatting.__cy_d = new int[104];
                  class214.__hf_k = new int[104];
                  WorldMapSectionType.__h_n = new int[104];
                  Message.__bm_i = new int[104];
                  var48 = class40.regionLandArchives.length;
                  SpriteMask.method4390();
                  UserComparator10.method3352(true);
                  int var10;
                  int var11;
                  int var12;
                  int var13;
                  int var14;
                  int var15;
                  int var16;
                  int var17;
                  int var18;
                  int var19;
                  int var20;
                  int var21;
                  int var22;
                  int var51;
                  if(!isInInstance) {
                     byte[] var6;
                     for(var49 = 0; var49 < var48; ++var49) {
                        var4 = (class308.regions[var49] >> 8) * 64 - class50.baseX;
                        var5 = (class308.regions[var49] & 255) * 64 - GraphicsObject.baseY;
                        var6 = class40.regionLandArchives[var49];
                        if(var6 != null) {
                           class13.playPcmPlayers();
                           Varcs.method2166(var6, var4, var5, GameObject.__eh_fy * 8 - 48, WorldMapLabelSize.__s_fi * 8 - 48, collisionMaps);
                        }
                     }

                     for(var49 = 0; var49 < var48; ++var49) {
                        var4 = (class308.regions[var49] >> 8) * 64 - class50.baseX;
                        var5 = (class308.regions[var49] & 255) * 64 - GraphicsObject.baseY;
                        var6 = class40.regionLandArchives[var49];
                        if(var6 == null && WorldMapLabelSize.__s_fi < 800) {
                           class13.playPcmPlayers();
                           UserComparator6.method3390(var4, var5, 64, 64);
                        }
                     }

                     UserComparator10.method3352(true);

                     for(var49 = 0; var49 < var48; ++var49) {
                        byte[] var50 = HealthBarUpdate.regionMapArchives[var49];
                        if(var50 != null) {
                           var5 = (class308.regions[var49] >> 8) * 64 - class50.baseX;
                           var51 = (class308.regions[var49] & 255) * 64 - GraphicsObject.baseY;
                           class13.playPcmPlayers();
                           Scene var7 = class65.scene;
                           CollisionMap[] var8 = collisionMaps;
                           Buffer var9 = new Buffer(var50);
                           var10 = -1;

                           while(true) {
                              var11 = var9.__at_308();
                              if(var11 == 0) {
                                 break;
                              }

                              var10 += var11;
                              var12 = 0;

                              while(true) {
                                 var13 = var9.__ae_307();
                                 if(var13 == 0) {
                                    break;
                                 }

                                 var12 += var13 - 1;
                                 var14 = var12 & 63;
                                 var15 = var12 >> 6 & 63;
                                 var16 = var12 >> 12;
                                 var17 = var9.readUnsignedByte();
                                 var18 = var17 >> 2;
                                 var19 = var17 & 3;
                                 var20 = var5 + var15;
                                 var21 = var14 + var51;
                                 if(var20 > 0 && var21 > 0 && var20 < 103 && var21 < 103) {
                                    var22 = var16;
                                    if((Tiles.Tiles_renderFlags[1][var20][var21] & 2) == 2) {
                                       var22 = var16 - 1;
                                    }

                                    CollisionMap var23 = null;
                                    if(var22 >= 0) {
                                       var23 = var8[var22];
                                    }

                                    class227.method4446(var16, var20, var21, var10, var19, var18, var7, var23);
                                 }
                              }
                           }
                        }
                     }
                  }

                  int var52;
                  int var53;
                  int var54;
                  if(isInInstance) {
                     var49 = 0;

                     label1186:
                     while(true) {
                        if(var49 >= 4) {
                           for(var49 = 0; var49 < 13; ++var49) {
                              for(var4 = 0; var4 < 13; ++var4) {
                                 var5 = instanceChunkTemplates[0][var49][var4];
                                 if(var5 == -1) {
                                    UserComparator6.method3390(var49 * 8, var4 * 8, 8, 8);
                                 }
                              }
                           }

                           UserComparator10.method3352(true);
                           var49 = 0;

                           while(true) {
                              if(var49 >= 4) {
                                 break label1186;
                              }

                              class13.playPcmPlayers();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    var51 = instanceChunkTemplates[var49][var4][var5];
                                    if(var51 != -1) {
                                       var52 = var51 >> 24 & 3;
                                       var53 = var51 >> 1 & 3;
                                       var54 = var51 >> 14 & 1023;
                                       var10 = var51 >> 3 & 2047;
                                       var11 = (var54 / 8 << 8) + var10 / 8;

                                       for(var12 = 0; var12 < class308.regions.length; ++var12) {
                                          if(class308.regions[var12] == var11 && HealthBarUpdate.regionMapArchives[var12] != null) {
                                             ServerPacket.method3662(HealthBarUpdate.regionMapArchives[var12], var49, var4 * 8, var5 * 8, var52, (var54 & 7) * 8, (var10 & 7) * 8, var53, class65.scene, collisionMaps);
                                             break;
                                          }
                                       }
                                    }
                                 }
                              }

                              ++var49;
                           }
                        }

                        class13.playPcmPlayers();

                        for(var4 = 0; var4 < 13; ++var4) {
                           for(var5 = 0; var5 < 13; ++var5) {
                              boolean var72 = false;
                              var52 = instanceChunkTemplates[var49][var4][var5];
                              if(var52 != -1) {
                                 var53 = var52 >> 24 & 3;
                                 var54 = var52 >> 1 & 3;
                                 var10 = var52 >> 14 & 1023;
                                 var11 = var52 >> 3 & 2047;
                                 var12 = (var10 / 8 << 8) + var11 / 8;

                                 for(var13 = 0; var13 < class308.regions.length; ++var13) {
                                    if(class308.regions[var13] == var12 && class40.regionLandArchives[var13] != null) {
                                       class204.method4013(class40.regionLandArchives[var13], var49, var4 * 8, var5 * 8, var53, (var10 & 7) * 8, (var11 & 7) * 8, var54, collisionMaps);
                                       var72 = true;
                                       break;
                                    }
                                 }
                              }

                              if(!var72) {
                                 var53 = var49;
                                 var54 = var4 * 8;
                                 var10 = var5 * 8;

                                 for(var11 = 0; var11 < 8; ++var11) {
                                    for(var12 = 0; var12 < 8; ++var12) {
                                       Tiles.Tiles_heights[var53][var11 + var54][var12 + var10] = 0;
                                    }
                                 }

                                 if(var54 > 0) {
                                    for(var11 = 1; var11 < 8; ++var11) {
                                       Tiles.Tiles_heights[var53][var54][var10 + var11] = Tiles.Tiles_heights[var53][var54 - 1][var10 + var11];
                                    }
                                 }

                                 if(var10 > 0) {
                                    for(var11 = 1; var11 < 8; ++var11) {
                                       Tiles.Tiles_heights[var53][var54 + var11][var10] = Tiles.Tiles_heights[var53][var54 + var11][var10 - 1];
                                    }
                                 }

                                 if(var54 > 0 && Tiles.Tiles_heights[var53][var54 - 1][var10] != 0) {
                                    Tiles.Tiles_heights[var53][var54][var10] = Tiles.Tiles_heights[var53][var54 - 1][var10];
                                 } else if(var10 > 0 && Tiles.Tiles_heights[var53][var54][var10 - 1] != 0) {
                                    Tiles.Tiles_heights[var53][var54][var10] = Tiles.Tiles_heights[var53][var54][var10 - 1];
                                 } else if(var54 > 0 && var10 > 0 && Tiles.Tiles_heights[var53][var54 - 1][var10 - 1] != 0) {
                                    Tiles.Tiles_heights[var53][var54][var10] = Tiles.Tiles_heights[var53][var54 - 1][var10 - 1];
                                 }
                              }
                           }
                        }

                        ++var49;
                     }
                  }

                  UserComparator10.method3352(true);
                  class13.playPcmPlayers();
                  Scene var65 = class65.scene;
                  CollisionMap[] var71 = collisionMaps;

                  for(var5 = 0; var5 < 4; ++var5) {
                     for(var51 = 0; var51 < 104; ++var51) {
                        for(var52 = 0; var52 < 104; ++var52) {
                           if((Tiles.Tiles_renderFlags[var5][var51][var52] & 1) == 1) {
                              var53 = var5;
                              if((Tiles.Tiles_renderFlags[1][var51][var52] & 2) == 2) {
                                 var53 = var5 - 1;
                              }

                              if(var53 >= 0) {
                                 var71[var53].__w_285(var51, var52);
                              }
                           }
                        }
                     }
                  }

                  Tiles.__bq_p += (int)(Math.random() * 5.0D) - 2;
                  if(Tiles.__bq_p < -8) {
                     Tiles.__bq_p = -8;
                  }

                  if(Tiles.__bq_p > 8) {
                     Tiles.__bq_p = 8;
                  }

                  Tiles.__bq_v += (int)(Math.random() * 5.0D) - 2;
                  if(Tiles.__bq_v < -16) {
                     Tiles.__bq_v = -16;
                  }

                  if(Tiles.__bq_v > 16) {
                     Tiles.__bq_v = 16;
                  }

                  for(var5 = 0; var5 < 4; ++var5) {
                     byte[][] var66 = Tiles.__bq_l[var5];
                     var12 = (int)Math.sqrt(5100.0D);
                     var13 = var12 * 768 >> 8;

                     int var55;
                     for(var14 = 1; var14 < 103; ++var14) {
                        for(var15 = 1; var15 < 103; ++var15) {
                           var16 = Tiles.Tiles_heights[var5][var15 + 1][var14] - Tiles.Tiles_heights[var5][var15 - 1][var14];
                           var17 = Tiles.Tiles_heights[var5][var15][var14 + 1] - Tiles.Tiles_heights[var5][var15][var14 - 1];
                           var18 = (int)Math.sqrt((double)(var17 * var17 + var16 * var16 + 65536));
                           var19 = (var16 << 8) / var18;
                           var20 = 65536 / var18;
                           var21 = (var17 << 8) / var18;
                           var22 = (var21 * -50 + var19 * -50 + var20 * -10) / var13 + 96;
                           var55 = (var66[var15 - 1][var14] >> 2) + (var66[var15][var14 - 1] >> 2) + (var66[var15 + 1][var14] >> 3) + (var66[var15][var14 + 1] >> 3) + (var66[var15][var14] >> 1);
                           Huffman.__gd_e[var15][var14] = var22 - var55;
                        }
                     }

                     for(var14 = 0; var14 < 104; ++var14) {
                        class13.__i_x[var14] = 0;
                        Formatting.__cy_d[var14] = 0;
                        class214.__hf_k[var14] = 0;
                        WorldMapSectionType.__h_n[var14] = 0;
                        Message.__bm_i[var14] = 0;
                     }

                     for(var14 = -5; var14 < 109; ++var14) {
                        for(var15 = 0; var15 < 104; ++var15) {
                           var16 = var14 + 5;
                           if(var16 >= 0 && var16 < 104) {
                              var17 = Tiles.__bq_w[var5][var16][var15] & 255;
                              if(var17 > 0) {
                                 UnderlayDefinition var56 = StudioGame.method4550(var17 - 1);
                                 class13.__i_x[var15] += var56.hue;
                                 Formatting.__cy_d[var15] += var56.saturation;
                                 class214.__hf_k[var15] += var56.lightness;
                                 WorldMapSectionType.__h_n[var15] += var56.hueMultiplier;
                                 ++Message.__bm_i[var15];
                              }
                           }

                           var17 = var14 - 5;
                           if(var17 >= 0 && var17 < 104) {
                              var18 = Tiles.__bq_w[var5][var17][var15] & 255;
                              if(var18 > 0) {
                                 UnderlayDefinition var57 = StudioGame.method4550(var18 - 1);
                                 class13.__i_x[var15] -= var57.hue;
                                 Formatting.__cy_d[var15] -= var57.saturation;
                                 class214.__hf_k[var15] -= var57.lightness;
                                 WorldMapSectionType.__h_n[var15] -= var57.hueMultiplier;
                                 --Message.__bm_i[var15];
                              }
                           }
                        }

                        if(var14 >= 1 && var14 < 103) {
                           var15 = 0;
                           var16 = 0;
                           var17 = 0;
                           var18 = 0;
                           var19 = 0;

                           for(var20 = -5; var20 < 109; ++var20) {
                              var21 = var20 + 5;
                              if(var21 >= 0 && var21 < 104) {
                                 var15 += class13.__i_x[var21];
                                 var16 += Formatting.__cy_d[var21];
                                 var17 += class214.__hf_k[var21];
                                 var18 += WorldMapSectionType.__h_n[var21];
                                 var19 += Message.__bm_i[var21];
                              }

                              var22 = var20 - 5;
                              if(var22 >= 0 && var22 < 104) {
                                 var15 -= class13.__i_x[var22];
                                 var16 -= Formatting.__cy_d[var22];
                                 var17 -= class214.__hf_k[var22];
                                 var18 -= WorldMapSectionType.__h_n[var22];
                                 var19 -= Message.__bm_i[var22];
                              }

                              if(var20 >= 1 && var20 < 103 && (!isLowDetail || (Tiles.Tiles_renderFlags[0][var14][var20] & 2) != 0 || (Tiles.Tiles_renderFlags[var5][var14][var20] & 16) == 0)) {
                                 if(var5 < Tiles.Tiles_minPlane) {
                                    Tiles.Tiles_minPlane = var5;
                                 }

                                 var55 = Tiles.__bq_w[var5][var14][var20] & 255;
                                 int var24 = Fonts.__kz_o[var5][var14][var20] & 255;
                                 if(var55 > 0 || var24 > 0) {
                                    int var25 = Tiles.Tiles_heights[var5][var14][var20];
                                    int var26 = Tiles.Tiles_heights[var5][var14 + 1][var20];
                                    int var27 = Tiles.Tiles_heights[var5][var14 + 1][var20 + 1];
                                    int var28 = Tiles.Tiles_heights[var5][var14][var20 + 1];
                                    int var29 = Huffman.__gd_e[var14][var20];
                                    int var30 = Huffman.__gd_e[var14 + 1][var20];
                                    int var31 = Huffman.__gd_e[var14 + 1][var20 + 1];
                                    int var32 = Huffman.__gd_e[var14][var20 + 1];
                                    int var33 = -1;
                                    int var34 = -1;
                                    int var35;
                                    int var36;
                                    int var37;
                                    if(var55 > 0) {
                                       var35 = var15 * 256 / var18;
                                       var36 = var16 / var19;
                                       var37 = var17 / var19;
                                       var33 = WorldMapAreaData.method712(var35, var36, var37);
                                       var35 = var35 + Tiles.__bq_p & 255;
                                       var37 += Tiles.__bq_v;
                                       if(var37 < 0) {
                                          var37 = 0;
                                       } else if(var37 > 255) {
                                          var37 = 255;
                                       }

                                       var34 = WorldMapAreaData.method712(var35, var36, var37);
                                    }

                                    OverlayDefinition var38;
                                    if(var5 > 0) {
                                       boolean var69 = true;
                                       if(var55 == 0 && class32.__ay_u[var5][var14][var20] != 0) {
                                          var69 = false;
                                       }

                                       if(var24 > 0) {
                                          var37 = var24 - 1;
                                          var38 = (OverlayDefinition)OverlayDefinition.__jf_f.get((long)var37);
                                          OverlayDefinition var58;
                                          if(var38 != null) {
                                             var58 = var38;
                                          } else {
                                             byte[] var39 = OverlayDefinition.__jf_m.takeRecord(4, var37);
                                             var38 = new OverlayDefinition();
                                             if(var39 != null) {
                                                var38.read(new Buffer(var39), var37);
                                             }

                                             var38.init();
                                             OverlayDefinition.__jf_f.put(var38, (long)var37);
                                             var58 = var38;
                                          }

                                          if(!var58.__o) {
                                             var69 = false;
                                          }
                                       }

                                       if(var69 && var25 == var26 && var25 == var27 && var28 == var25) {
                                          Tiles.__bq_a[var5][var14][var20] |= 2340;
                                       }
                                    }

                                    var35 = 0;
                                    if(var34 != -1) {
                                       var35 = Rasterizer3D.Rasterizer3D_colorPalette[class15.method183(var34, 96)];
                                    }

                                    if(var24 == 0) {
                                       var65.addTile(var5, var14, var20, 0, 0, -1, var25, var26, var27, var28, class15.method183(var33, var29), class15.method183(var33, var30), class15.method183(var33, var31), class15.method183(var33, var32), 0, 0, 0, 0, var35, 0);
                                    } else {
                                       var36 = class32.__ay_u[var5][var14][var20] + 1;
                                       byte var70 = class307.__kc_g[var5][var14][var20];
                                       int var59 = var24 - 1;
                                       OverlayDefinition var40 = (OverlayDefinition)OverlayDefinition.__jf_f.get((long)var59);
                                       if(var40 != null) {
                                          var38 = var40;
                                       } else {
                                          byte[] var41 = OverlayDefinition.__jf_m.takeRecord(4, var59);
                                          var40 = new OverlayDefinition();
                                          if(var41 != null) {
                                             var40.read(new Buffer(var41), var59);
                                          }

                                          var40.init();
                                          OverlayDefinition.__jf_f.put(var40, (long)var59);
                                          var38 = var40;
                                       }

                                       int var60 = var38.texture;
                                       int var42;
                                       int var43;
                                       int var44;
                                       int var45;
                                       if(var60 >= 0) {
                                          var43 = Rasterizer3D.Rasterizer3D_textureLoader.__w_213(var60);
                                          var42 = -1;
                                       } else if(var38.rgb == 16711935) {
                                          var42 = -2;
                                          var60 = -1;
                                          var43 = -2;
                                       } else {
                                          var42 = WorldMapAreaData.method712(var38.hue, var38.saturation, var38.lightness);
                                          var44 = var38.hue + Tiles.__bq_p & 255;
                                          var45 = var38.lightness + Tiles.__bq_v;
                                          if(var45 < 0) {
                                             var45 = 0;
                                          } else if(var45 > 255) {
                                             var45 = 255;
                                          }

                                          var43 = WorldMapAreaData.method712(var44, var38.saturation, var45);
                                       }

                                       var44 = 0;
                                       if(var43 != -2) {
                                          var44 = Rasterizer3D.Rasterizer3D_colorPalette[class25.method348(var43, 96)];
                                       }

                                       if(var38.rgb2 != -1) {
                                          var45 = var38.hue2 + Tiles.__bq_p & 255;
                                          int var46 = var38.lightness2 + Tiles.__bq_v;
                                          if(var46 < 0) {
                                             var46 = 0;
                                          } else if(var46 > 255) {
                                             var46 = 255;
                                          }

                                          var43 = WorldMapAreaData.method712(var45, var38.saturation2, var46);
                                          var44 = Rasterizer3D.Rasterizer3D_colorPalette[class25.method348(var43, 96)];
                                       }

                                       var65.addTile(var5, var14, var20, var36, var70, var60, var25, var26, var27, var28, class15.method183(var33, var29), class15.method183(var33, var30), class15.method183(var33, var31), class15.method183(var33, var32), class25.method348(var42, var29), class25.method348(var42, var30), class25.method348(var42, var31), class25.method348(var42, var32), var35, var44);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     for(var14 = 1; var14 < 103; ++var14) {
                        for(var15 = 1; var15 < 103; ++var15) {
                           if((Tiles.Tiles_renderFlags[var5][var15][var14] & 8) != 0) {
                              var20 = 0;
                           } else if(var5 > 0 && (Tiles.Tiles_renderFlags[1][var15][var14] & 2) != 0) {
                              var20 = var5 - 1;
                           } else {
                              var20 = var5;
                           }

                           var65.setTileMinPlane(var5, var15, var14, var20);
                        }
                     }

                     Tiles.__bq_w[var5] = null;
                     Fonts.__kz_o[var5] = null;
                     class32.__ay_u[var5] = null;
                     class307.__kc_g[var5] = null;
                     Tiles.__bq_l[var5] = null;
                  }

                  var65.__aw_247(-50, -10, -50);

                  for(var5 = 0; var5 < 104; ++var5) {
                     for(var51 = 0; var51 < 104; ++var51) {
                        if((Tiles.Tiles_renderFlags[1][var5][var51] & 2) == 2) {
                           var65.setLinkBelow(var5, var51);
                        }
                     }
                  }

                  var5 = 1;
                  var51 = 2;
                  var52 = 4;

                  for(var53 = 0; var53 < 4; ++var53) {
                     if(var53 > 0) {
                        var5 <<= 3;
                        var51 <<= 3;
                        var52 <<= 3;
                     }

                     for(var54 = 0; var54 <= var53; ++var54) {
                        for(var10 = 0; var10 <= 104; ++var10) {
                           for(var11 = 0; var11 <= 104; ++var11) {
                              short var68;
                              if((Tiles.__bq_a[var54][var11][var10] & var5) != 0) {
                                 var12 = var10;
                                 var13 = var10;
                                 var14 = var54;

                                 for(var15 = var54; var12 > 0 && (Tiles.__bq_a[var54][var11][var12 - 1] & var5) != 0; --var12) {
                                    ;
                                 }

                                 while(var13 < 104 && (Tiles.__bq_a[var54][var11][var13 + 1] & var5) != 0) {
                                    ++var13;
                                 }

                                 label837:
                                 while(var14 > 0) {
                                    for(var16 = var12; var16 <= var13; ++var16) {
                                       if((Tiles.__bq_a[var14 - 1][var11][var16] & var5) == 0) {
                                          break label837;
                                       }
                                    }

                                    --var14;
                                 }

                                 label826:
                                 while(var15 < var53) {
                                    for(var16 = var12; var16 <= var13; ++var16) {
                                       if((Tiles.__bq_a[var15 + 1][var11][var16] & var5) == 0) {
                                          break label826;
                                       }
                                    }

                                    ++var15;
                                 }

                                 var16 = (var13 - var12 + 1) * (var15 + 1 - var14);
                                 if(var16 >= 8) {
                                    var68 = 240;
                                    var18 = Tiles.Tiles_heights[var15][var11][var12] - var68;
                                    var19 = Tiles.Tiles_heights[var14][var11][var12];
                                    Scene.Scene_addOccluder(var53, 1, var11 * 128, var11 * 128, var12 * 128, var13 * 128 + 128, var18, var19);

                                    for(var20 = var14; var20 <= var15; ++var20) {
                                       for(var21 = var12; var21 <= var13; ++var21) {
                                          Tiles.__bq_a[var20][var11][var21] &= ~var5;
                                       }
                                    }
                                 }
                              }

                              if((Tiles.__bq_a[var54][var11][var10] & var51) != 0) {
                                 var12 = var11;
                                 var13 = var11;
                                 var14 = var54;

                                 for(var15 = var54; var12 > 0 && (Tiles.__bq_a[var54][var12 - 1][var10] & var51) != 0; --var12) {
                                    ;
                                 }

                                 while(var13 < 104 && (Tiles.__bq_a[var54][var13 + 1][var10] & var51) != 0) {
                                    ++var13;
                                 }

                                 label890:
                                 while(var14 > 0) {
                                    for(var16 = var12; var16 <= var13; ++var16) {
                                       if((Tiles.__bq_a[var14 - 1][var16][var10] & var51) == 0) {
                                          break label890;
                                       }
                                    }

                                    --var14;
                                 }

                                 label879:
                                 while(var15 < var53) {
                                    for(var16 = var12; var16 <= var13; ++var16) {
                                       if((Tiles.__bq_a[var15 + 1][var16][var10] & var51) == 0) {
                                          break label879;
                                       }
                                    }

                                    ++var15;
                                 }

                                 var16 = (var13 - var12 + 1) * (var15 + 1 - var14);
                                 if(var16 >= 8) {
                                    var68 = 240;
                                    var18 = Tiles.Tiles_heights[var15][var12][var10] - var68;
                                    var19 = Tiles.Tiles_heights[var14][var12][var10];
                                    Scene.Scene_addOccluder(var53, 2, var12 * 128, var13 * 128 + 128, var10 * 128, var10 * 128, var18, var19);

                                    for(var20 = var14; var20 <= var15; ++var20) {
                                       for(var21 = var12; var21 <= var13; ++var21) {
                                          Tiles.__bq_a[var20][var21][var10] &= ~var51;
                                       }
                                    }
                                 }
                              }

                              if((Tiles.__bq_a[var54][var11][var10] & var52) != 0) {
                                 var12 = var11;
                                 var13 = var11;
                                 var14 = var10;

                                 for(var15 = var10; var14 > 0 && (Tiles.__bq_a[var54][var11][var14 - 1] & var52) != 0; --var14) {
                                    ;
                                 }

                                 while(var15 < 104 && (Tiles.__bq_a[var54][var11][var15 + 1] & var52) != 0) {
                                    ++var15;
                                 }

                                 label943:
                                 while(var12 > 0) {
                                    for(var16 = var14; var16 <= var15; ++var16) {
                                       if((Tiles.__bq_a[var54][var12 - 1][var16] & var52) == 0) {
                                          break label943;
                                       }
                                    }

                                    --var12;
                                 }

                                 label932:
                                 while(var13 < 104) {
                                    for(var16 = var14; var16 <= var15; ++var16) {
                                       if((Tiles.__bq_a[var54][var13 + 1][var16] & var52) == 0) {
                                          break label932;
                                       }
                                    }

                                    ++var13;
                                 }

                                 if((var15 - var14 + 1) * (var13 - var12 + 1) >= 4) {
                                    var16 = Tiles.Tiles_heights[var54][var12][var14];
                                    Scene.Scene_addOccluder(var53, 4, var12 * 128, var13 * 128 + 128, var14 * 128, var15 * 128 + 128, var16, var16);

                                    for(var17 = var12; var17 <= var13; ++var17) {
                                       for(var18 = var14; var18 <= var15; ++var18) {
                                          Tiles.__bq_a[var54][var17][var18] &= ~var52;
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  UserComparator10.method3352(true);
                  var5 = Tiles.Tiles_minPlane;
                  if(var5 > SoundSystem.plane) {
                     var5 = SoundSystem.plane;
                  }

                  if(var5 < SoundSystem.plane - 1) {
                     var5 = SoundSystem.plane - 1;
                  }

                  if(isLowDetail) {
                     class65.scene.init(Tiles.Tiles_minPlane);
                  } else {
                     class65.scene.init(0);
                  }

                  for(var51 = 0; var51 < 104; ++var51) {
                     for(var52 = 0; var52 < 104; ++var52) {
                        TilePaint.method3061(var51, var52);
                     }
                  }

                  class13.playPcmPlayers();
                  ScriptEvent.method1179();
                  ObjectDefinition.__jr_o.clear();
                  PacketBufferNode var67;
                  if(TextureProvider.client.hasFrame()) {
                     var67 = Interpreter.method1915(ClientPacket.__gs_x, packetWriter.isaacCipher);
                     var67.packetBuffer.writeInt(1057001181);
                     packetWriter.__q_167(var67);
                  }

                  if(!isInInstance) {
                     var51 = (GameObject.__eh_fy - 6) / 8;
                     var52 = (GameObject.__eh_fy + 6) / 8;
                     var53 = (WorldMapLabelSize.__s_fi - 6) / 8;
                     var54 = (WorldMapLabelSize.__s_fi + 6) / 8;

                     for(var10 = var51 - 1; var10 <= var52 + 1; ++var10) {
                        for(var11 = var53 - 1; var11 <= var54 + 1; ++var11) {
                           if(var10 < var51 || var10 > var52 || var11 < var53 || var11 > var54) {
                              SecureRandomFuture.indexCache5.__ar_402("m" + var10 + "_" + var11);
                              SecureRandomFuture.indexCache5.__ar_402("l" + var10 + "_" + var11);
                           }
                        }
                     }
                  }

                  GameShell.updateGameState(30);
                  class13.playPcmPlayers();
                  BufferedSink.method3603();
                  var67 = Interpreter.method1915(ClientPacket.__gs_bv, packetWriter.isaacCipher);
                  packetWriter.__q_167(var67);
                  class11.method145();
               }
            }
         }
      } else {
         class54.method1092(this);
      }

      if(gameState == 30) {
         this.doCycleLoggedIn();
      } else if(gameState == 40 || gameState == 45) {
         this.doCycleLoggedOut();
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "106302203"
   )
   @Export("methodDraw")
   protected final void methodDraw(boolean var1) {
      boolean var2;
      label166: {
         try {
            if(class214.__hf_o == 2) {
               if(class13.musicTrack == null) {
                  class13.musicTrack = MusicTrack.readTrack(class214.__hf_u, class30.musicTrackArchiveId, GrandExchangeOffer.musicTrackFileId);
                  if(class13.musicTrack == null) {
                     var2 = false;
                     break label166;
                  }
               }

               if(class307.soundCache == null) {
                  class307.soundCache = new SoundCache(class214.__hf_q, class214.__hf_f);
               }

               if(class214.midiPcmStream.loadMusicTrack(class13.musicTrack, class1.__f_m, class307.soundCache, 22050)) {
                  class214.midiPcmStream.clearAll();
                  class214.midiPcmStream.__m_340(WorldMapLabel.__aj_e);
                  class214.midiPcmStream.setMusicTrack(class13.musicTrack, RectangleMode.musicTrackBoolean);
                  class214.__hf_o = 0;
                  class13.musicTrack = null;
                  class307.soundCache = null;
                  class214.__hf_u = null;
                  var2 = true;
                  break label166;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class214.midiPcmStream.clear();
            class214.__hf_o = 0;
            class13.musicTrack = null;
            class307.soundCache = null;
            class214.__hf_u = null;
         }

         var2 = false;
      }

      if(var2 && __client_qq && WorldMapCacheName.pcmPlayer0 != null) {
         WorldMapCacheName.pcmPlayer0.tryDiscard();
      }

      if((gameState == 10 || gameState == 20 || gameState == 30) && __client_oa != 0L && class203.currentTimeMs() > __client_oa) {
         GroundItem.method2095(SpotAnimationDefinition.method4822());
      }

      int var4;
      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            __client_od[var4] = true;
         }
      }

      if(gameState == 0) {
         this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
      } else if(gameState == 5) {
         IndexCacheLoader.drawTitle(class2.fontBold12, ScriptEvent.fontPlain11, DevicePcmPlayerProvider.fontPlain12);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            IndexCacheLoader.drawTitle(class2.fontBold12, ScriptEvent.fontPlain11, DevicePcmPlayerProvider.fontPlain12);
         } else if(gameState == 25) {
            if(__client_gh == 1) {
               if(__client_fe > __client_fn) {
                  __client_fn = __client_fe;
               }

               var4 = (__client_fn * 50 - __client_fe * 50) / __client_fn;
               class68.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(__client_gh == 2) {
               if(__client_fk > __client_gp) {
                  __client_gp = __client_fk;
               }

               var4 = (__client_gp * 50 - __client_fk * 50) / __client_gp + 50;
               class68.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class68.drawLoadingMessage("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.drawLoggedIn();
         } else if(gameState == 40) {
            class68.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class68.drawLoadingMessage("Please wait...", false);
         }
      } else {
         IndexCacheLoader.drawTitle(class2.fontBold12, ScriptEvent.fontPlain11, DevicePcmPlayerProvider.fontPlain12);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
         for(var4 = 0; var4 < rootWidgetCount; ++var4) {
            if(__client_ot[var4]) {
               class197.rasterProvider.draw(rootWidgetXs[var4], rootWidgetYs[var4], rootWidgetWidths[var4], rootWidgetHeights[var4]);
               __client_ot[var4] = false;
            }
         }
      } else if(gameState > 0) {
         class197.rasterProvider.drawFull(0, 0);

         for(var4 = 0; var4 < rootWidgetCount; ++var4) {
            __client_ot[var4] = false;
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1879956387"
   )
   protected final void kill0() {
      if(class196.varcs.hasUnwrittenChanges()) {
         class196.varcs.write();
      }

      if(Projectile.mouseRecorder != null) {
         Projectile.mouseRecorder.isRunning = false;
      }

      Projectile.mouseRecorder = null;
      packetWriter.close();
      if(KeyHandler.KeyHandler_instance != null) {
         KeyHandler var1 = KeyHandler.KeyHandler_instance;
         synchronized(KeyHandler.KeyHandler_instance) {
            KeyHandler.KeyHandler_instance = null;
         }
      }

      if(MouseHandler.MouseHandler_instance != null) {
         MouseHandler var8 = MouseHandler.MouseHandler_instance;
         synchronized(MouseHandler.MouseHandler_instance) {
            MouseHandler.MouseHandler_instance = null;
         }
      }

      class16.mouseWheel = null;
      if(WorldMapCacheName.pcmPlayer0 != null) {
         WorldMapCacheName.pcmPlayer0.shutdown();
      }

      if(AbstractIndexCache.pcmPlayer1 != null) {
         AbstractIndexCache.pcmPlayer1.shutdown();
      }

      if(NetCache.NetCache_socket != null) {
         NetCache.NetCache_socket.close();
      }

      RunException.method3431();
      if(TriBool.urlRequester != null) {
         TriBool.urlRequester.close();
         TriBool.urlRequester = null;
      }

      try {
         class168.dat2File.close();

         for(int var4 = 0; var4 < class168.idxCount; ++var4) {
            IndexStoreAction.idxFiles[var4].close();
         }

         class168.idx255File.close();
         class168.randomDat.close();
      } catch (Exception var7) {
         ;
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1860808291"
   )
   protected final void __au_110() {
   }

   @ObfuscatedName("init")
   public final void __init_109() {
      try {
         if(this.checkHost()) {
            ClientParameter[] var1 = class4.method47();

            int var9;
            for(int var2 = 0; var2 < var1.length; ++var2) {
               ClientParameter var3 = var1[var2];
               String var4 = this.getParameter(var3.id);
               if(var4 != null) {
                  switch(Integer.parseInt(var3.id)) {
                  case 1:
                     useBufferedSocket = Integer.parseInt(var4) != 0;
                  case 2:
                  case 11:
                  case 13:
                  case 16:
                  default:
                     break;
                  case 3:
                     if(var4.equalsIgnoreCase("true")) {
                        isMembersWorld = true;
                     } else {
                        isMembersWorld = false;
                     }
                     break;
                  case 4:
                     if(clientType == -1) {
                        clientType = Integer.parseInt(var4);
                     }
                     break;
                  case 5:
                     worldProperties = Integer.parseInt(var4);
                     break;
                  case 6:
                     language = Integer.parseInt(var4);
                     break;
                  case 7:
                     int var6 = Integer.parseInt(var4);
                     ServerBuild[] var7 = new ServerBuild[]{ServerBuild.__iy_q, ServerBuild.__iy_w, ServerBuild.__iy_m, ServerBuild.__iy_f};
                     ServerBuild[] var8 = var7;
                     var9 = 0;

                     ServerBuild var5;
                     while(true) {
                        if(var9 >= var8.length) {
                           var5 = null;
                           break;
                        }

                        ServerBuild var10 = var8[var9];
                        if(var6 == var10.id) {
                           var5 = var10;
                           break;
                        }

                        ++var9;
                     }

                     class15.serverBuild = var5;
                     break;
                  case 8:
                     if(var4.equalsIgnoreCase("true")) {
                        ;
                     }
                     break;
                  case 9:
                     class21.__b_by = var4;
                     break;
                  case 10:
                     class22.studioGame = (StudioGame)ScriptFrame.findEnumerated(ClientPacket.method3664(), Integer.parseInt(var4));
                     if(class22.studioGame == StudioGame.__is_u) {
                        KeyHandler.loginType = LoginType.__lx_m;
                     } else {
                        KeyHandler.loginType = LoginType.__lx_e;
                     }
                     break;
                  case 12:
                     worldId = Integer.parseInt(var4);
                     break;
                  case 14:
                     AbstractIndexCache.__ir_bu = Integer.parseInt(var4);
                     break;
                  case 15:
                     gameBuild = Integer.parseInt(var4);
                     break;
                  case 17:
                     ServerBuild.worldsUrl = var4;
                  }
               }
            }

            class237.method4539();
            class50.worldHost = this.getCodeBase().getHost();
            String var33 = class15.serverBuild.name;
            byte var34 = 0;

            try {
               class168.idxCount = 21;
               PacketBuffer.__hx_z = var34;

               try {
                  class266.osName = System.getProperty("os.name");
               } catch (Exception var28) {
                  class266.osName = "Unknown";
               }

               WorldMapSection3.osNameLowerCase = class266.osName.toLowerCase();

               try {
                  WorldMapSection1.userHomeDirectory = System.getProperty("user.home");
                  if(WorldMapSection1.userHomeDirectory != null) {
                     WorldMapSection1.userHomeDirectory = WorldMapSection1.userHomeDirectory + "/";
                  }
               } catch (Exception var27) {
                  ;
               }

               try {
                  if(WorldMapSection3.osNameLowerCase.startsWith("win")) {
                     if(WorldMapSection1.userHomeDirectory == null) {
                        WorldMapSection1.userHomeDirectory = System.getenv("USERPROFILE");
                     }
                  } else if(WorldMapSection1.userHomeDirectory == null) {
                     WorldMapSection1.userHomeDirectory = System.getenv("HOME");
                  }

                  if(WorldMapSection1.userHomeDirectory != null) {
                     WorldMapSection1.userHomeDirectory = WorldMapSection1.userHomeDirectory + "/";
                  }
               } catch (Exception var26) {
                  ;
               }

               if(WorldMapSection1.userHomeDirectory == null) {
                  WorldMapSection1.userHomeDirectory = "~/";
               }

               WorldMapSection2.cacheDirectoryLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", WorldMapSection1.userHomeDirectory, "/tmp/", ""};
               Canvas.__ao_s = new String[]{".jagex_cache_" + PacketBuffer.__hx_z, ".file_store_" + PacketBuffer.__hx_z};
               int var17 = 0;

               label259:
               while(var17 < 4) {
                  String var37 = var17 == 0?"":"" + var17;
                  class337.clDat = new File(WorldMapSection1.userHomeDirectory, "jagex_cl_oldschool_" + var33 + var37 + ".dat");
                  String var18 = null;
                  String var39 = null;
                  boolean var19 = false;
                  File var42;
                  if(class337.clDat.exists()) {
                     try {
                        AccessFile var20 = new AccessFile(class337.clDat, "rw", 10000L);

                        int var11;
                        Buffer var41;
                        for(var41 = new Buffer((int)var20.length()); var41.index < var41.array.length; var41.index += var11) {
                           var11 = var20.read(var41.array, var41.index, var41.array.length - var41.index);
                           if(var11 == -1) {
                              throw new IOException();
                           }
                        }

                        var41.index = 0;
                        var11 = var41.readUnsignedByte();
                        if(var11 < 1 || var11 > 3) {
                           throw new IOException("" + var11);
                        }

                        int var12 = 0;
                        if(var11 > 1) {
                           var12 = var41.readUnsignedByte();
                        }

                        if(var11 <= 2) {
                           var18 = var41.readStringCp1252NullCircumfixed();
                           if(var12 == 1) {
                              var39 = var41.readStringCp1252NullCircumfixed();
                           }
                        } else {
                           var18 = var41.__aw_304();
                           if(var12 == 1) {
                              var39 = var41.__aw_304();
                           }
                        }

                        var20.close();
                     } catch (IOException var30) {
                        var30.printStackTrace();
                     }

                     if(var18 != null) {
                        var42 = new File(var18);
                        if(!var42.exists()) {
                           var18 = null;
                        }
                     }

                     if(var18 != null) {
                        var42 = new File(var18, "test.dat");
                        if(!DevicePcmPlayerProvider.method847(var42, true)) {
                           var18 = null;
                        }
                     }
                  }

                  if(var18 == null && var17 == 0) {
                     label234:
                     for(var9 = 0; var9 < Canvas.__ao_s.length; ++var9) {
                        for(int var21 = 0; var21 < WorldMapSection2.cacheDirectoryLocations.length; ++var21) {
                           File var22 = new File(WorldMapSection2.cacheDirectoryLocations[var21] + Canvas.__ao_s[var9] + File.separatorChar + "oldschool" + File.separatorChar);
                           if(var22.exists() && DevicePcmPlayerProvider.method847(new File(var22, "test.dat"), true)) {
                              var18 = var22.toString();
                              var19 = true;
                              break label234;
                           }
                        }
                     }
                  }

                  if(var18 == null) {
                     var18 = WorldMapSection1.userHomeDirectory + File.separatorChar + "jagexcache" + var37 + File.separatorChar + "oldschool" + File.separatorChar + var33 + File.separatorChar;
                     var19 = true;
                  }

                  if(var39 != null) {
                     File var43 = new File(var39);
                     var42 = new File(var18);

                     try {
                        File[] var44 = var43.listFiles();
                        File[] var23 = var44;

                        for(int var13 = 0; var13 < var23.length; ++var13) {
                           File var14 = var23[var13];
                           File var15 = new File(var42, var14.getName());
                           boolean var16 = var14.renameTo(var15);
                           if(!var16) {
                              throw new IOException();
                           }
                        }
                     } catch (Exception var29) {
                        var29.printStackTrace();
                     }

                     var19 = true;
                  }

                  if(var19) {
                     class14.method167(new File(var18), (File)null);
                  }

                  File var36 = new File(var18);
                  class168.__fs_o = var36;
                  if(!class168.__fs_o.exists()) {
                     class168.__fs_o.mkdirs();
                  }

                  File[] var38 = class168.__fs_o.listFiles();
                  if(var38 != null) {
                     File[] var45 = var38;

                     for(int var24 = 0; var24 < var45.length; ++var24) {
                        File var40 = var45[var24];
                        if(!DevicePcmPlayerProvider.method847(var40, false)) {
                           ++var17;
                           continue label259;
                        }
                     }
                  }
                  break;
               }

               File var35 = class168.__fs_o;
               class171.__fo_f = var35;
               if(!class171.__fo_f.exists()) {
                  throw new RuntimeException("");
               }

               class171.__fo_m = true;
               Interpreter.method1976();
               class168.dat2File = new BufferedFile(new AccessFile(WorldMapIcon2.method315("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
               class168.idx255File = new BufferedFile(new AccessFile(WorldMapIcon2.method315("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
               IndexStoreAction.idxFiles = new BufferedFile[class168.idxCount];

               for(int var25 = 0; var25 < class168.idxCount; ++var25) {
                  IndexStoreAction.idxFiles[var25] = new BufferedFile(new AccessFile(WorldMapIcon2.method315("main_file_cache.idx" + var25), "rw", 1048576L), 6000, 0);
               }
            } catch (Exception var31) {
               NpcDefinition.sendStackTrace((String)null, var31);
            }

            TextureProvider.client = this;
            RunException.__fx_w = clientType;
            this.startThread(765, 503, 180);
         }
      } catch (RuntimeException var32) {
         throw Players.method2120(var32, "client.init(" + ')');
      }
   }

   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-78"
   )
   @Export("doCycleJs5")
   void doCycleJs5() {
      if(gameState != 1000) {
         long var2 = class203.currentTimeMs();
         int var4 = (int)(var2 - NetCache.__iq_q);
         NetCache.__iq_q = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         NetCache.__iq_f += var4;
         boolean var1;
         if(NetCache.NetCache_pendingResponsesCount == 0 && NetCache.NetCache_pendingPriorityResponsesCount == 0 && NetCache.NetCache_pendingWritesCount == 0 && NetCache.NetCache_pendingPriorityWritesCount == 0) {
            var1 = true;
         } else if(NetCache.NetCache_socket == null) {
            var1 = false;
         } else {
            try {
               label242: {
                  if(NetCache.__iq_f > 30000) {
                     throw new IOException();
                  }

                  NetFileRequest var5;
                  Buffer var6;
                  while(NetCache.NetCache_pendingPriorityResponsesCount < 200 && NetCache.NetCache_pendingPriorityWritesCount > 0) {
                     var5 = (NetFileRequest)NetCache.NetCache_pendingPriorityWrites.first();
                     var6 = new Buffer(4);
                     var6.writeByte(1);
                     var6.writeMedium((int)var5.key);
                     NetCache.NetCache_socket.write(var6.array, 0, 4);
                     NetCache.NetCache_pendingPriorityResponses.put(var5, var5.key);
                     --NetCache.NetCache_pendingPriorityWritesCount;
                     ++NetCache.NetCache_pendingPriorityResponsesCount;
                  }

                  while(NetCache.NetCache_pendingResponsesCount < 200 && NetCache.NetCache_pendingWritesCount > 0) {
                     var5 = (NetFileRequest)NetCache.NetCache_pendingWritesQueue.last();
                     var6 = new Buffer(4);
                     var6.writeByte(0);
                     var6.writeMedium((int)var5.key);
                     NetCache.NetCache_socket.write(var6.array, 0, 4);
                     var5.removeDual();
                     NetCache.NetCache_pendingResponses.put(var5, var5.key);
                     --NetCache.NetCache_pendingWritesCount;
                     ++NetCache.NetCache_pendingResponsesCount;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = NetCache.NetCache_socket.available();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     NetCache.__iq_f = 0;
                     byte var7 = 0;
                     if(ModelData0.NetCache_currentResponse == null) {
                        var7 = 8;
                     } else if(NetCache.__iq_j == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - NetCache.NetCache_responseHeaderBuffer.index;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        NetCache.NetCache_socket.read(NetCache.NetCache_responseHeaderBuffer.array, NetCache.NetCache_responseHeaderBuffer.index, var8);
                        if(NetCache.__iq_b != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              NetCache.NetCache_responseHeaderBuffer.array[NetCache.NetCache_responseHeaderBuffer.index + var9] ^= NetCache.__iq_b;
                           }
                        }

                        NetCache.NetCache_responseHeaderBuffer.index += var8;
                        if(NetCache.NetCache_responseHeaderBuffer.index < var7) {
                           break;
                        }

                        if(ModelData0.NetCache_currentResponse == null) {
                           NetCache.NetCache_responseHeaderBuffer.index = 0;
                           var9 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
                           var10 = NetCache.NetCache_responseHeaderBuffer.__ag_302();
                           int var11 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
                           var12 = NetCache.NetCache_responseHeaderBuffer.readInt();
                           long var13 = (long)(var10 + (var9 << 16));
                           NetFileRequest var15 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.get(var13);
                           WorldComparator.__u_n = true;
                           if(var15 == null) {
                              var15 = (NetFileRequest)NetCache.NetCache_pendingResponses.get(var13);
                              WorldComparator.__u_n = false;
                           }

                           if(var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           ModelData0.NetCache_currentResponse = var15;
                           class22.NetCache_responseArchiveBuffer = new Buffer(var12 + var16 + ModelData0.NetCache_currentResponse.padding);
                           class22.NetCache_responseArchiveBuffer.writeByte(var11);
                           class22.NetCache_responseArchiveBuffer.writeInt(var12);
                           NetCache.__iq_j = 8;
                           NetCache.NetCache_responseHeaderBuffer.index = 0;
                        } else if(NetCache.__iq_j == 0) {
                           if(NetCache.NetCache_responseHeaderBuffer.array[0] == -1) {
                              NetCache.__iq_j = 1;
                              NetCache.NetCache_responseHeaderBuffer.index = 0;
                           } else {
                              ModelData0.NetCache_currentResponse = null;
                           }
                        }
                     } else {
                        var8 = class22.NetCache_responseArchiveBuffer.array.length - ModelData0.NetCache_currentResponse.padding;
                        var9 = 512 - NetCache.__iq_j;
                        if(var9 > var8 - class22.NetCache_responseArchiveBuffer.index) {
                           var9 = var8 - class22.NetCache_responseArchiveBuffer.index;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        NetCache.NetCache_socket.read(class22.NetCache_responseArchiveBuffer.array, class22.NetCache_responseArchiveBuffer.index, var9);
                        if(NetCache.__iq_b != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class22.NetCache_responseArchiveBuffer.array[class22.NetCache_responseArchiveBuffer.index + var10] ^= NetCache.__iq_b;
                           }
                        }

                        class22.NetCache_responseArchiveBuffer.index += var9;
                        NetCache.__iq_j += var9;
                        if(var8 == class22.NetCache_responseArchiveBuffer.index) {
                           if(16711935L == ModelData0.NetCache_currentResponse.key) {
                              Players.NetCache_reference = class22.NetCache_responseArchiveBuffer;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 IndexCache var19 = NetCache.NetCache_indexCaches[var10];
                                 if(var19 != null) {
                                    Players.NetCache_reference.index = var10 * 8 + 5;
                                    var12 = Players.NetCache_reference.readInt();
                                    int var20 = Players.NetCache_reference.readInt();
                                    var19.loadIndexReference(var12, var20);
                                 }
                              }
                           } else {
                              NetCache.NetCache_crc.reset();
                              NetCache.NetCache_crc.update(class22.NetCache_responseArchiveBuffer.array, 0, var8);
                              var10 = (int)NetCache.NetCache_crc.getValue();
                              if(var10 != ModelData0.NetCache_currentResponse.crc) {
                                 try {
                                    NetCache.NetCache_socket.close();
                                 } catch (Exception var23) {
                                    ;
                                 }

                                 ++NetCache.NetCache_crcMismatches;
                                 NetCache.NetCache_socket = null;
                                 NetCache.__iq_b = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label242;
                              }

                              NetCache.NetCache_crcMismatches = 0;
                              NetCache.NetCache_ioExceptions = 0;
                              ModelData0.NetCache_currentResponse.indexCache.write((int)(ModelData0.NetCache_currentResponse.key & 65535L), class22.NetCache_responseArchiveBuffer.array, 16711680L == (ModelData0.NetCache_currentResponse.key & 16711680L), WorldComparator.__u_n);
                           }

                           ModelData0.NetCache_currentResponse.remove();
                           if(WorldComparator.__u_n) {
                              --NetCache.NetCache_pendingPriorityResponsesCount;
                           } else {
                              --NetCache.NetCache_pendingResponsesCount;
                           }

                           NetCache.__iq_j = 0;
                           ModelData0.NetCache_currentResponse = null;
                           class22.NetCache_responseArchiveBuffer = null;
                        } else {
                           if(NetCache.__iq_j != 512) {
                              break;
                           }

                           NetCache.__iq_j = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var24) {
               try {
                  NetCache.NetCache_socket.close();
               } catch (Exception var22) {
                  ;
               }

               ++NetCache.NetCache_ioExceptions;
               NetCache.NetCache_socket = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.doCycleJs5Connect();
         }

      }
   }

   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "111"
   )
   @Export("doCycleJs5Connect")
   void doCycleJs5Connect() {
      if(NetCache.NetCache_crcMismatches >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(NetCache.NetCache_ioExceptions >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            __client_dp = 3000;
            NetCache.NetCache_ioExceptions = 3;
         }

         if(--__client_dp + 1 <= 0) {
            try {
               if(js5ConnectState == 0) {
                  class210.js5SocketTask = GameShell.taskHandler.newSocketTask(class50.worldHost, class203.port3);
                  ++js5ConnectState;
               }

               if(js5ConnectState == 1) {
                  if(class210.js5SocketTask.status == 2) {
                     this.js5Error(-1);
                     return;
                  }

                  if(class210.js5SocketTask.status == 1) {
                     ++js5ConnectState;
                  }
               }

               if(js5ConnectState == 2) {
                  if(useBufferedSocket) {
                     DynamicObject.js5Socket = BufferedFile.method2719((Socket)class210.js5SocketTask.result, 40000, 5000);
                  } else {
                     DynamicObject.js5Socket = new NetSocket((Socket)class210.js5SocketTask.result, GameShell.taskHandler, 5000);
                  }

                  Buffer var1 = new Buffer(5);
                  var1.writeByte(15);
                  var1.writeInt(180);
                  DynamicObject.js5Socket.write(var1.array, 0, 5);
                  ++js5ConnectState;
                  GameObject.js5StartTimeMs = class203.currentTimeMs();
               }

               if(js5ConnectState == 3) {
                  if(DynamicObject.js5Socket.available() > 0 || !useBufferedSocket && gameState <= 5) {
                     int var5 = DynamicObject.js5Socket.readUnsignedByte();
                     if(var5 != 0) {
                        this.js5Error(var5);
                        return;
                     }

                     ++js5ConnectState;
                  } else if(class203.currentTimeMs() - GameObject.js5StartTimeMs > 30000L) {
                     this.js5Error(-2);
                     return;
                  }
               }

               if(js5ConnectState == 4) {
                  AbstractSocket var10 = DynamicObject.js5Socket;
                  boolean var2 = gameState > 20;
                  if(NetCache.NetCache_socket != null) {
                     try {
                        NetCache.NetCache_socket.close();
                     } catch (Exception var8) {
                        ;
                     }

                     NetCache.NetCache_socket = null;
                  }

                  NetCache.NetCache_socket = var10;
                  UserComparator9.method3343(var2);
                  NetCache.NetCache_responseHeaderBuffer.index = 0;
                  ModelData0.NetCache_currentResponse = null;
                  class22.NetCache_responseArchiveBuffer = null;
                  NetCache.__iq_j = 0;

                  while(true) {
                     NetFileRequest var3 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.first();
                     if(var3 == null) {
                        while(true) {
                           var3 = (NetFileRequest)NetCache.NetCache_pendingResponses.first();
                           if(var3 == null) {
                              if(NetCache.__iq_b != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.writeByte(4);
                                    var11.writeByte(NetCache.__iq_b);
                                    var11.writeShort(0);
                                    NetCache.NetCache_socket.write(var11.array, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       NetCache.NetCache_socket.close();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++NetCache.NetCache_ioExceptions;
                                    NetCache.NetCache_socket = null;
                                 }
                              }

                              NetCache.__iq_f = 0;
                              NetCache.__iq_q = class203.currentTimeMs();
                              class210.js5SocketTask = null;
                              DynamicObject.js5Socket = null;
                              js5ConnectState = 0;
                              js5Errors = 0;
                              return;
                           }

                           NetCache.NetCache_pendingWritesQueue.addLast(var3);
                           NetCache.NetCache_pendingWrites.put(var3, var3.key);
                           ++NetCache.NetCache_pendingWritesCount;
                           --NetCache.NetCache_pendingResponsesCount;
                        }
                     }

                     NetCache.NetCache_pendingPriorityWrites.put(var3, var3.key);
                     ++NetCache.NetCache_pendingPriorityWritesCount;
                     --NetCache.NetCache_pendingPriorityResponsesCount;
                  }
               }
            } catch (IOException var9) {
               this.js5Error(-3);
            }

         }
      }
   }

   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "2348"
   )
   @Export("js5Error")
   void js5Error(int var1) {
      class210.js5SocketTask = null;
      DynamicObject.js5Socket = null;
      js5ConnectState = 0;
      if(class2.port1 == class203.port3) {
         class203.port3 = WorldMapArea.port2;
      } else {
         class203.port3 = class2.port1;
      }

      ++js5Errors;
      if(js5Errors >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            __client_dp = 3000;
         }
      } else if(js5Errors >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(js5Errors >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            __client_dp = 3000;
         }
      }

   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-110"
   )
   @Export("doCycleLoggedOut")
   final void doCycleLoggedOut() {
      Object var1 = packetWriter.getSocket();
      PacketBuffer var2 = packetWriter.packetBuffer;

      try {
         if(loginState == 0) {
            if(WorldMapIcon1.secureRandom == null && (secureRandomFuture.isDone() || __client_ex > 250)) {
               WorldMapIcon1.secureRandom = secureRandomFuture.get();
               secureRandomFuture.shutdown();
               secureRandomFuture = null;
            }

            if(WorldMapIcon1.secureRandom != null) {
               if(var1 != null) {
                  ((AbstractSocket)var1).close();
                  var1 = null;
               }

               UserComparator3.socketTask = null;
               __client_fh = false;
               __client_ex = 0;
               loginState = 1;
            }
         }

         if(loginState == 1) {
            if(UserComparator3.socketTask == null) {
               UserComparator3.socketTask = GameShell.taskHandler.newSocketTask(class50.worldHost, class203.port3);
            }

            if(UserComparator3.socketTask.status == 2) {
               throw new IOException();
            }

            if(UserComparator3.socketTask.status == 1) {
               if(useBufferedSocket) {
                  var1 = BufferedFile.method2719((Socket)UserComparator3.socketTask.result, 40000, 5000);
               } else {
                  var1 = new NetSocket((Socket)UserComparator3.socketTask.result, GameShell.taskHandler, 5000);
               }

               packetWriter.setSocket((AbstractSocket)var1);
               UserComparator3.socketTask = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            packetWriter.__m_165();
            PacketBufferNode var4;
            if(PacketBufferNode.__gg_u == 0) {
               var4 = new PacketBufferNode();
            } else {
               var4 = PacketBufferNode.packetBufferNodes[--PacketBufferNode.__gg_u];
            }

            var4.__m = null;
            var4.__f = 0;
            var4.packetBuffer = new PacketBuffer(5000);
            var4.packetBuffer.writeByte(LoginPacket.__gl_m.id);
            packetWriter.__q_167(var4);
            packetWriter.__f_166();
            var2.index = 0;
            loginState = 3;
         }

         boolean var12;
         int var13;
         if(loginState == 3) {
            if(WorldMapCacheName.pcmPlayer0 != null) {
               WorldMapCacheName.pcmPlayer0.__ac_176();
            }

            if(AbstractIndexCache.pcmPlayer1 != null) {
               AbstractIndexCache.pcmPlayer1.__ac_176();
            }

            var12 = true;
            if(useBufferedSocket && !((AbstractSocket)var1).isAvailable(1)) {
               var12 = false;
            }

            if(var12) {
               var13 = ((AbstractSocket)var1).readUnsignedByte();
               if(WorldMapCacheName.pcmPlayer0 != null) {
                  WorldMapCacheName.pcmPlayer0.__ac_176();
               }

               if(AbstractIndexCache.pcmPlayer1 != null) {
                  AbstractIndexCache.pcmPlayer1.__ac_176();
               }

               if(var13 != 0) {
                  IsaacCipher.method4093(var13);
                  return;
               }

               var2.index = 0;
               loginState = 4;
            }
         }

         int var25;
         if(loginState == 4) {
            if(var2.index < 8) {
               var25 = ((AbstractSocket)var1).available();
               if(var25 > 8 - var2.index) {
                  var25 = 8 - var2.index;
               }

               if(var25 > 0) {
                  ((AbstractSocket)var1).read(var2.array, var2.index, var25);
                  var2.index += var25;
               }
            }

            if(var2.index == 8) {
               var2.index = 0;
               MusicPatchNode2.__hd_fc = var2.readLong();
               loginState = 5;
            }
         }

         if(loginState == 5) {
            packetWriter.packetBuffer.index = 0;
            packetWriter.__m_165();
            PacketBuffer var3 = new PacketBuffer(500);
            int[] var20 = new int[]{WorldMapIcon1.secureRandom.nextInt(), WorldMapIcon1.secureRandom.nextInt(), WorldMapIcon1.secureRandom.nextInt(), WorldMapIcon1.secureRandom.nextInt()};
            var3.index = 0;
            var3.writeByte(1);
            var3.writeInt(var20[0]);
            var3.writeInt(var20[1]);
            var3.writeInt(var20[2]);
            var3.writeInt(var20[3]);
            var3.writeLong(MusicPatchNode2.__hd_fc);
            if(gameState == 40) {
               var3.writeInt(Skills.__hc_ef[0]);
               var3.writeInt(Skills.__hc_ef[1]);
               var3.writeInt(Skills.__hc_ef[2]);
               var3.writeInt(Skills.__hc_ef[3]);
            } else {
               var3.writeByte(field658.rsOrdinal());
               switch(field658.field1984) {
               case 0:
               case 3:
                  var3.writeMedium(class13.__i_af);
                  ++var3.index;
                  break;
               case 1:
                  var3.index += 4;
                  break;
               case 2:
                  var3.writeInt(((Integer)ReflectionCheck.clientPreferences.parameters.get(Integer.valueOf(class279.method5357(Login.Login_username)))).intValue());
               }

               var3.writeByte(class313.field3834.rsOrdinal());
               var3.writeStringCp1252NullTerminated(Login.Login_password);
            }

            var3.encryptRsa(class83.__cm_m, class83.__cm_f);
            Skills.__hc_ef = var20;
            PacketBufferNode var6;
            if(PacketBufferNode.__gg_u == 0) {
               var6 = new PacketBufferNode();
            } else {
               var6 = PacketBufferNode.packetBufferNodes[--PacketBufferNode.__gg_u];
            }

            var6.__m = null;
            var6.__f = 0;
            var6.packetBuffer = new PacketBuffer(5000);
            var6.packetBuffer.index = 0;
            if(gameState == 40) {
               var6.packetBuffer.writeByte(LoginPacket.__gl_w.id);
            } else {
               var6.packetBuffer.writeByte(LoginPacket.__gl_q.id);
            }

            var6.packetBuffer.writeShort(0);
            int var14 = var6.packetBuffer.index;
            var6.packetBuffer.writeInt(180);
            var6.packetBuffer.writeInt(1);
            var6.packetBuffer.writeByte(clientType);
            var6.packetBuffer.__s_297(var3.array, 0, var3.index);
            int var8 = var6.packetBuffer.index;
            var6.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
            var6.packetBuffer.writeByte((isResizable?1:0) << 1 | (isLowDetail?1:0));
            var6.packetBuffer.writeShort(SoundCache.canvasWidth);
            var6.packetBuffer.writeShort(Huffman.canvasHeight);
            Varps.method4400(var6.packetBuffer);
            var6.packetBuffer.writeStringCp1252NullTerminated(class21.__b_by);
            var6.packetBuffer.writeInt(AbstractIndexCache.__ir_bu);
            Buffer var9 = new Buffer(WorldMapLabelSize.platformInfo.size());
            WorldMapLabelSize.platformInfo.write(var9);
            var6.packetBuffer.__s_297(var9.array, 0, var9.array.length);
            var6.packetBuffer.writeByte(clientType);
            var6.packetBuffer.writeInt(0);
            var6.packetBuffer.writeInt(AbstractIndexCache.indexCache0.hash);
            var6.packetBuffer.writeInt(Skeleton.indexCache1.hash);
            var6.packetBuffer.writeInt(ObjectSound.indexCache2.hash);
            var6.packetBuffer.writeInt(WorldMapIcon1.indexCache3.hash);
            var6.packetBuffer.writeInt(class25.indexCache4.hash);
            var6.packetBuffer.writeInt(SecureRandomFuture.indexCache5.hash);
            var6.packetBuffer.writeInt(UserComparator3.indexCache6.hash);
            var6.packetBuffer.writeInt(class40.indexCache7.hash);
            var6.packetBuffer.writeInt(WorldMapSection3.indexCache8.hash);
            var6.packetBuffer.writeInt(class238.indexCache9.hash);
            var6.packetBuffer.writeInt(class16.indexCache10.hash);
            var6.packetBuffer.writeInt(Login.indexCache11.hash);
            var6.packetBuffer.writeInt(Formatting.indexCache12.hash);
            var6.packetBuffer.writeInt(ByteArrayPool.indexCache13.hash);
            var6.packetBuffer.writeInt(class2.indexCache14.hash);
            var6.packetBuffer.writeInt(WorldMapSection1.indexCache15.hash);
            var6.packetBuffer.writeInt(0);
            var6.packetBuffer.writeInt(class22.indexCache16.hash);
            var6.packetBuffer.writeInt(WorldMapLabelSize.__s_dq.hash);
            var6.packetBuffer.writeInt(ItemContainer.__bc_dm.hash);
            var6.packetBuffer.writeInt(AbstractByteArrayCopier.__gu_et.hash);
            var6.packetBuffer.xteaEncrypt(var20, var8, var6.packetBuffer.index);
            var6.packetBuffer.__y_299(var6.packetBuffer.index - var14);
            packetWriter.__q_167(var6);
            packetWriter.__f_166();
            packetWriter.isaacCipher = new IsaacCipher(var20);
            int[] var10 = new int[4];

            for(int var11 = 0; var11 < 4; ++var11) {
               var10[var11] = var20[var11] + 50;
            }

            var2.newIsaacCipher(var10);
            loginState = 6;
         }

         if(loginState == 6 && ((AbstractSocket)var1).available() > 0) {
            var25 = ((AbstractSocket)var1).readUnsignedByte();
            if(var25 == 21 && gameState == 20) {
               loginState = 9;
            } else if(var25 == 2) {
               loginState = 11;
            } else if(var25 == 15 && gameState == 40) {
               packetWriter.serverPacket0Length = -1;
               loginState = 16;
            } else if(var25 == 64) {
               loginState = 7;
            } else if(var25 == 23 && __client_ej < 1) {
               ++__client_ej;
               loginState = 0;
            } else {
               if(var25 != 29) {
                  IsaacCipher.method4093(var25);
                  return;
               }

               loginState = 14;
            }
         }

         if(loginState == 7 && ((AbstractSocket)var1).available() > 0) {
            WorldMapSection1.__as_ey = ((AbstractSocket)var1).readUnsignedByte();
            loginState = 8;
         }

         if(loginState == 8 && ((AbstractSocket)var1).available() >= WorldMapSection1.__as_ey) {
            ((AbstractSocket)var1).read(var2.array, 0, WorldMapSection1.__as_ey);
            var2.index = 0;
            loginState = 6;
         }

         if(loginState == 9 && ((AbstractSocket)var1).available() > 0) {
            __client_el = (((AbstractSocket)var1).readUnsignedByte() + 3) * 60;
            loginState = 10;
         }

         if(loginState == 10) {
            __client_ex = 0;
            class54.method1089("You have only just left another world.", "Your profile will be transferred in:", __client_el / 60 + " seconds.");
            if(--__client_el <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 11 && ((AbstractSocket)var1).available() >= 1) {
               __client_eo = ((AbstractSocket)var1).readUnsignedByte();
               loginState = 12;
            }

            if(loginState == 12 && ((AbstractSocket)var1).available() >= __client_eo) {
               var12 = ((AbstractSocket)var1).readUnsignedByte() == 1;
               ((AbstractSocket)var1).read(var2.array, 0, 4);
               var2.index = 0;
               boolean var26 = false;
               if(var12) {
                  var13 = var2.readByteIsaac() << 24;
                  var13 |= var2.readByteIsaac() << 16;
                  var13 |= var2.readByteIsaac() << 8;
                  var13 |= var2.readByteIsaac();
                  int var15 = class279.method5357(Login.Login_username);
                  if(ReflectionCheck.clientPreferences.parameters.size() >= 10 && !ReflectionCheck.clientPreferences.parameters.containsKey(Integer.valueOf(var15))) {
                     Iterator var24 = ReflectionCheck.clientPreferences.parameters.entrySet().iterator();
                     var24.next();
                     var24.remove();
                  }

                  ReflectionCheck.clientPreferences.parameters.put(Integer.valueOf(var15), Integer.valueOf(var13));
               }

               if(Login_isUsernameRemembered) {
                  ReflectionCheck.clientPreferences.rememberedUsername = Login.Login_username;
               } else {
                  ReflectionCheck.clientPreferences.rememberedUsername = null;
               }

               WorldMapSection0.method247();
               rights = ((AbstractSocket)var1).readUnsignedByte();
               __client_mn = ((AbstractSocket)var1).readUnsignedByte() == 1;
               localPlayerIndex = ((AbstractSocket)var1).readUnsignedByte();
               localPlayerIndex <<= 8;
               localPlayerIndex += ((AbstractSocket)var1).readUnsignedByte();
               __client_jo = ((AbstractSocket)var1).readUnsignedByte();
               ((AbstractSocket)var1).read(var2.array, 0, 1);
               var2.index = 0;
               ServerPacket[] var5 = class27.method429();
               int var16 = var2.readSmartByteShortIsaac();
               if(var16 < 0 || var16 >= var5.length) {
                  throw new IOException(var16 + " " + var2.index);
               }

               packetWriter.serverPacket0 = var5[var16];
               packetWriter.serverPacket0Length = packetWriter.serverPacket0.length;
               ((AbstractSocket)var1).read(var2.array, 0, 2);
               var2.index = 0;
               packetWriter.serverPacket0Length = var2.__ag_302();

               try {
                  Client var7 = TextureProvider.client;
                  JSObject.getWindow(var7).call("zap", (Object[])null);
               } catch (Throwable var17) {
                  ;
               }

               loginState = 13;
            }

            if(loginState == 13) {
               if(((AbstractSocket)var1).available() >= packetWriter.serverPacket0Length) {
                  var2.index = 0;
                  ((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacket0Length);
                  timer.__w_456();
                  WorldMapSection1.method808();
                  class11.updatePlayer(var2);
                  GameObject.__eh_fy = -1;
                  class50.loadRegions(false, var2);
                  packetWriter.serverPacket0 = null;
               }

            } else {
               if(loginState == 14 && ((AbstractSocket)var1).available() >= 2) {
                  var2.index = 0;
                  ((AbstractSocket)var1).read(var2.array, 0, 2);
                  var2.index = 0;
                  IndexCacheLoader.__bd_er = var2.__ag_302();
                  loginState = 15;
               }

               if(loginState == 15 && ((AbstractSocket)var1).available() >= IndexCacheLoader.__bd_er) {
                  var2.index = 0;
                  ((AbstractSocket)var1).read(var2.array, 0, IndexCacheLoader.__bd_er);
                  var2.index = 0;
                  String var19 = var2.readStringCp1252NullTerminated();
                  String var21 = var2.readStringCp1252NullTerminated();
                  String var22 = var2.readStringCp1252NullTerminated();
                  class54.method1089(var19, var21, var22);
                  GameShell.updateGameState(10);
               }

               if(loginState != 16) {
                  ++__client_ex;
                  if(__client_ex > 2000) {
                     if(__client_ej < 1) {
                        if(class203.port3 == class2.port1) {
                           class203.port3 = WorldMapArea.port2;
                        } else {
                           class203.port3 = class2.port1;
                        }

                        ++__client_ej;
                        loginState = 0;
                     } else {
                        IsaacCipher.method4093(-3);
                     }
                  }
               } else {
                  if(packetWriter.serverPacket0Length == -1) {
                     if(((AbstractSocket)var1).available() < 2) {
                        return;
                     }

                     ((AbstractSocket)var1).read(var2.array, 0, 2);
                     var2.index = 0;
                     packetWriter.serverPacket0Length = var2.__ag_302();
                  }

                  if(((AbstractSocket)var1).available() >= packetWriter.serverPacket0Length) {
                     ((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacket0Length);
                     var2.index = 0;
                     var25 = packetWriter.serverPacket0Length;
                     timer.__u_458();
                     packetWriter.__m_165();
                     packetWriter.packetBuffer.index = 0;
                     packetWriter.serverPacket0 = null;
                     packetWriter.__k = null;
                     packetWriter.__n = null;
                     packetWriter.__i = null;
                     packetWriter.serverPacket0Length = 0;
                     packetWriter.__x = 0;
                     rebootTimer = 0;
                     menuOptionsCount = 0;
                     isMenuOpen = false;
                     minimapState = 0;
                     destinationX = 0;

                     for(var13 = 0; var13 < 2048; ++var13) {
                        players[var13] = null;
                     }

                     Canvas.localPlayer = null;

                     for(var13 = 0; var13 < npcs.length; ++var13) {
                        Npc var23 = npcs[var13];
                        if(var23 != null) {
                           var23.targetIndex = -1;
                           var23.false0 = false;
                        }
                     }

                     SpriteMask.method4389();
                     GameShell.updateGameState(30);

                     for(var13 = 0; var13 < 100; ++var13) {
                        __client_od[var13] = true;
                     }

                     AbstractByteArrayCopier.method4024();
                     class11.updatePlayer(var2);
                     if(var25 != var2.index) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var18) {
         if(__client_ej < 1) {
            if(class2.port1 == class203.port3) {
               class203.port3 = WorldMapArea.port2;
            } else {
               class203.port3 = class2.port1;
            }

            ++__client_ej;
            loginState = 0;
         } else {
            IsaacCipher.method4093(-2);
         }
      }
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1646308927"
   )
   @Export("doCycleLoggedIn")
   final void doCycleLoggedIn() {
      if(rebootTimer > 1) {
         --rebootTimer;
      }

      if(__client_fd > 0) {
         --__client_fd;
      }

      if(__client_fh) {
         __client_fh = false;
         class48.method868();
      } else {
         if(!isMenuOpen) {
            class30.method569();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.__hg_138(packetWriter); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(true) {
               ReflectionCheck var2 = (ReflectionCheck)class322.reflectionChecks.last();
               boolean var29;
               if(var2 == null) {
                  var29 = false;
               } else {
                  var29 = true;
               }

               int var3;
               PacketBufferNode var30;
               if(!var29) {
                  PacketBufferNode var14;
                  int var15;
                  if(timer.__q) {
                     var14 = Interpreter.method1915(ClientPacket.__gs_o, packetWriter.isaacCipher);
                     var14.packetBuffer.writeByte(0);
                     var15 = var14.packetBuffer.index;
                     timer.write(var14.packetBuffer);
                     var14.packetBuffer.__h_300(var14.packetBuffer.index - var15);
                     packetWriter.__q_167(var14);
                     timer.__o_457();
                  }

                  Object var34 = Projectile.mouseRecorder.lock;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  int var10;
                  int var11;
                  int var12;
                  synchronized(Projectile.mouseRecorder.lock) {
                     if(!__client_ai) {
                        Projectile.mouseRecorder.index = 0;
                     } else if(MouseHandler.MouseHandler_lastButton != 0 || Projectile.mouseRecorder.index >= 40) {
                        var30 = null;
                        var3 = 0;
                        var4 = 0;
                        var5 = 0;
                        var6 = 0;

                        for(var7 = 0; var7 < Projectile.mouseRecorder.index && (var30 == null || var30.packetBuffer.index - var3 < 246); ++var7) {
                           var4 = var7;
                           var8 = Projectile.mouseRecorder.ys[var7];
                           if(var8 < -1) {
                              var8 = -1;
                           } else if(var8 > 65534) {
                              var8 = 65534;
                           }

                           var9 = Projectile.mouseRecorder.xs[var7];
                           if(var9 < -1) {
                              var9 = -1;
                           } else if(var9 > 65534) {
                              var9 = 65534;
                           }

                           if(var9 != __client_cn || var8 != __client_cq) {
                              if(var30 == null) {
                                 var30 = Interpreter.method1915(ClientPacket.__gs_ak, packetWriter.isaacCipher);
                                 var30.packetBuffer.writeByte(0);
                                 var3 = var30.packetBuffer.index;
                                 var30.packetBuffer.index += 2;
                                 var5 = 0;
                                 var6 = 0;
                              }

                              if(-1L != __client_ch) {
                                 var10 = var9 - __client_cn;
                                 var11 = var8 - __client_cq;
                                 var12 = (int)((Projectile.mouseRecorder.millis[var7] - __client_ch) / 20L);
                                 var5 = (int)((long)var5 + (Projectile.mouseRecorder.millis[var7] - __client_ch) % 20L);
                              } else {
                                 var10 = var9;
                                 var11 = var8;
                                 var12 = Integer.MAX_VALUE;
                              }

                              __client_cn = var9;
                              __client_cq = var8;
                              if(var12 < 8 && var10 >= -32 && var10 <= 31 && var11 >= -32 && var11 <= 31) {
                                 var10 += 32;
                                 var11 += 32;
                                 var30.packetBuffer.writeShort((var12 << 12) + var11 + (var10 << 6));
                              } else if(var12 < 32 && var10 >= -128 && var10 <= 127 && var11 >= -128 && var11 <= 127) {
                                 var10 += 128;
                                 var11 += 128;
                                 var30.packetBuffer.writeByte(var12 + 128);
                                 var30.packetBuffer.writeShort(var11 + (var10 << 8));
                              } else if(var12 < 32) {
                                 var30.packetBuffer.writeByte(var12 + 192);
                                 if(var9 != -1 && var8 != -1) {
                                    var30.packetBuffer.writeInt(var9 | var8 << 16);
                                 } else {
                                    var30.packetBuffer.writeInt(Integer.MIN_VALUE);
                                 }
                              } else {
                                 var30.packetBuffer.writeShort((var12 & 8191) + 57344);
                                 if(var9 != -1 && var8 != -1) {
                                    var30.packetBuffer.writeInt(var9 | var8 << 16);
                                 } else {
                                    var30.packetBuffer.writeInt(Integer.MIN_VALUE);
                                 }
                              }

                              ++var6;
                              __client_ch = Projectile.mouseRecorder.millis[var7];
                           }
                        }

                        if(var30 != null) {
                           var30.packetBuffer.__h_300(var30.packetBuffer.index - var3);
                           var7 = var30.packetBuffer.index;
                           var30.packetBuffer.index = var3;
                           var30.packetBuffer.writeByte(var5 / var6);
                           var30.packetBuffer.writeByte(var5 % var6);
                           var30.packetBuffer.index = var7;
                           packetWriter.__q_167(var30);
                        }

                        if(var4 >= Projectile.mouseRecorder.index) {
                           Projectile.mouseRecorder.index = 0;
                        } else {
                           Projectile.mouseRecorder.index -= var4;
                           System.arraycopy(Projectile.mouseRecorder.xs, var4, Projectile.mouseRecorder.xs, 0, Projectile.mouseRecorder.index);
                           System.arraycopy(Projectile.mouseRecorder.ys, var4, Projectile.mouseRecorder.ys, 0, Projectile.mouseRecorder.index);
                           System.arraycopy(Projectile.mouseRecorder.millis, var4, Projectile.mouseRecorder.millis, 0, Projectile.mouseRecorder.index);
                        }
                     }
                  }

                  PacketBufferNode var18;
                  if(MouseHandler.MouseHandler_lastButton == 1 || !AbstractRasterProvider.__lp_ca && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
                     long var16 = (MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis * -1L) / 50L;
                     if(var16 > 4095L) {
                        var16 = 4095L;
                     }

                     mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis * -1L;
                     var3 = MouseHandler.MouseHandler_lastPressedY;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > Huffman.canvasHeight) {
                        var3 = Huffman.canvasHeight;
                     }

                     var4 = MouseHandler.MouseHandler_lastPressedX;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > SoundCache.canvasWidth) {
                        var4 = SoundCache.canvasWidth;
                     }

                     var5 = (int)var16;
                     var18 = Interpreter.method1915(ClientPacket.__gs_ap, packetWriter.isaacCipher);
                     var18.packetBuffer.writeShort((var5 << 1) + (MouseHandler.MouseHandler_lastButton == 2?1:0));
                     var18.packetBuffer.writeShort(var4);
                     var18.packetBuffer.writeShort(var3);
                     packetWriter.__q_167(var18);
                  }

                  if(KeyHandler.__an_cl > 0) {
                     var14 = Interpreter.method1915(ClientPacket.__gs_bj, packetWriter.isaacCipher);
                     var14.packetBuffer.writeShort(0);
                     var15 = var14.packetBuffer.index;
                     long var19 = class203.currentTimeMs();

                     for(var5 = 0; var5 < KeyHandler.__an_cl; ++var5) {
                        long var21 = var19 - __client_pp;
                        if(var21 > 16777215L) {
                           var21 = 16777215L;
                        }

                        __client_pp = var19;
                        var14.packetBuffer.__ai_315(KeyHandler.__an_cp[var5]);
                        var14.packetBuffer.writeMedium((int)var21);
                     }

                     var14.packetBuffer.__y_299(var14.packetBuffer.index - var15);
                     packetWriter.__q_167(var14);
                  }

                  if(__client_iy > 0) {
                     --__client_iy;
                  }

                  if(KeyHandler.KeyHandler_pressedKeys[96] || KeyHandler.KeyHandler_pressedKeys[97] || KeyHandler.KeyHandler_pressedKeys[98] || KeyHandler.KeyHandler_pressedKeys[99]) {
                     __client_is = true;
                  }

                  if(__client_is && __client_iy <= 0) {
                     __client_iy = 20;
                     __client_is = false;
                     var14 = Interpreter.method1915(ClientPacket.__gs_at, packetWriter.isaacCipher);
                     var14.packetBuffer.__bx_323(cameraPitchTarget);
                     var14.packetBuffer.writeShortLE(minimapOrientation);
                     packetWriter.__q_167(var14);
                  }

                  if(class230.__hy_az && !__client_cw) {
                     __client_cw = true;
                     var14 = Interpreter.method1915(ClientPacket.__gs_bf, packetWriter.isaacCipher);
                     var14.packetBuffer.writeByte(1);
                     packetWriter.__q_167(var14);
                  }

                  if(!class230.__hy_az && __client_cw) {
                     __client_cw = false;
                     var14 = Interpreter.method1915(ClientPacket.__gs_bf, packetWriter.isaacCipher);
                     var14.packetBuffer.writeByte(0);
                     packetWriter.__q_167(var14);
                  }

                  if(class60.worldMap0 != null) {
                     class60.worldMap0.__f_518();
                  }

                  class266.method5120();
                  Message.method1228();
                  if(gameState != 30) {
                     return;
                  }

                  Canvas.method855();
                  WorldMapIcon1.method212();
                  ++packetWriter.__x;
                  if(packetWriter.__x > 750) {
                     class48.method868();
                     return;
                  }

                  var1 = Players.Players_count;
                  int[] var31 = Players.Players_indices;

                  for(var3 = 0; var3 < var1; ++var3) {
                     Player var23 = players[var31[var3]];
                     if(var23 != null) {
                        class65.method1232(var23, 1);
                     }
                  }

                  for(var1 = 0; var1 < npcCount; ++var1) {
                     var15 = npcIndices[var1];
                     Npc var24 = npcs[var15];
                     if(var24 != null) {
                        class65.method1232(var24, var24.definition.size);
                     }
                  }

                  Buddy.method5554();
                  ++__client_gy;
                  if(mouseCrossColor != 0) {
                     mouseCrossState += 20;
                     if(mouseCrossState >= 400) {
                        mouseCrossColor = 0;
                     }
                  }

                  if(BoundaryObject.__ej_jv != null) {
                     ++__client_ju;
                     if(__client_ju >= 15) {
                        class22.method295(BoundaryObject.__ej_jv);
                        BoundaryObject.__ej_jv = null;
                     }
                  }

                  Widget var35 = Clock.mousedOverWidgetIf1;
                  Widget var32 = AccessFile.__dk_lm;
                  Clock.mousedOverWidgetIf1 = null;
                  AccessFile.__dk_lm = null;
                  draggedOnWidget = null;
                  __client_nt = false;
                  __client_nn = false;
                  __client_pm = 0;

                  while(Decimator.method2490() && __client_pm < 128) {
                     if(rights >= 2 && KeyHandler.KeyHandler_pressedKeys[82] && IndexStoreAction.__ik_cn == 66) {
                        String var37 = KeyHandler.method839();
                        TextureProvider.client.clipboardSetString(var37);
                     } else if(oculusOrbState != 1 || GzipDecompressor.__go_ck <= 0) {
                        __client_pn[__client_pm] = IndexStoreAction.__ik_cn;
                        __client_pq[__client_pm] = GzipDecompressor.__go_ck;
                        ++__client_pm;
                     }
                  }

                  if(FriendSystem.jmodCheck() && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81] && mouseWheelRotation != 0) {
                     var3 = Canvas.localPlayer.plane - mouseWheelRotation;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > 3) {
                        var3 = 3;
                     }

                     if(var3 != Canvas.localPlayer.plane) {
                        var4 = Canvas.localPlayer.pathX[0] + class50.baseX;
                        var5 = Canvas.localPlayer.pathY[0] + GraphicsObject.baseY;
                        var18 = Interpreter.method1915(ClientPacket.__gs_bx, packetWriter.isaacCipher);
                        var18.packetBuffer.writeIntME(0);
                        var18.packetBuffer.writeShortLE(var5);
                        var18.packetBuffer.__ai_315(var3);
                        var18.packetBuffer.writeShort(var4);
                        packetWriter.__q_167(var18);
                     }

                     mouseWheelRotation = 0;
                  }

                  if(rootWidgetGroup != -1) {
                     class231.method4517(rootWidgetGroup, 0, 0, SoundCache.canvasWidth, Huffman.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var25;
                     Widget var36;
                     ScriptEvent var38;
                     do {
                        var38 = (ScriptEvent)__client_oh.removeLast();
                        if(var38 == null) {
                           while(true) {
                              do {
                                 var38 = (ScriptEvent)__client_oc.removeLast();
                                 if(var38 == null) {
                                    while(true) {
                                       do {
                                          var38 = (ScriptEvent)scriptEvents.removeLast();
                                          if(var38 == null) {
                                             this.__hi_139();
                                             WorldMapSectionType.method254();
                                             if(clickedWidget != null) {
                                                this.__jh_142();
                                             }

                                             PacketBufferNode var40;
                                             if(DevicePcmPlayerProvider.dragInventoryWidget != null) {
                                                class22.method295(DevicePcmPlayerProvider.dragInventoryWidget);
                                                ++itemDragDuration;
                                                if(MouseHandler.MouseHandler_currentButton == 0) {
                                                   if(__client_jl) {
                                                      if(UserComparator6.__fg_jh == DevicePcmPlayerProvider.dragInventoryWidget && dragItemSlotSource != dragItemSlotDestination) {
                                                         Widget var39 = DevicePcmPlayerProvider.dragInventoryWidget;
                                                         byte var33 = 0;
                                                         if(__client_mb == 1 && var39.contentType == 206) {
                                                            var33 = 1;
                                                         }

                                                         if(var39.itemIds[dragItemSlotDestination] <= 0) {
                                                            var33 = 0;
                                                         }

                                                         if(class168.method3461(class1.getWidgetClickMask(var39))) {
                                                            var5 = dragItemSlotSource;
                                                            var6 = dragItemSlotDestination;
                                                            var39.itemIds[var6] = var39.itemIds[var5];
                                                            var39.itemQuantities[var6] = var39.itemQuantities[var5];
                                                            var39.itemIds[var5] = -1;
                                                            var39.itemQuantities[var5] = 0;
                                                         } else if(var33 == 1) {
                                                            var5 = dragItemSlotSource;
                                                            var6 = dragItemSlotDestination;

                                                            while(var5 != var6) {
                                                               if(var5 > var6) {
                                                                  var39.swapItems(var5 - 1, var5);
                                                                  --var5;
                                                               } else if(var5 < var6) {
                                                                  var39.swapItems(var5 + 1, var5);
                                                                  ++var5;
                                                               }
                                                            }
                                                         } else {
                                                            var39.swapItems(dragItemSlotDestination, dragItemSlotSource);
                                                         }

                                                         var40 = Interpreter.method1915(ClientPacket.__gs_ce, packetWriter.isaacCipher);
                                                         var40.packetBuffer.writeShort(dragItemSlotDestination);
                                                         var40.packetBuffer.writeShortLE(dragItemSlotSource);
                                                         var40.packetBuffer.writeInt(DevicePcmPlayerProvider.dragInventoryWidget.id);
                                                         var40.packetBuffer.__ai_315(var33);
                                                         packetWriter.__q_167(var40);
                                                      }
                                                   } else if(this.shouldLeftClickOpenMenu()) {
                                                      this.openMenu(__client_ja, __client_je);
                                                   } else if(menuOptionsCount > 0) {
                                                      var3 = __client_ja;
                                                      var4 = __client_je;
                                                      class231.method4520(UnitPriceComparator.tempMenuAction, var3, var4);
                                                      UnitPriceComparator.tempMenuAction = null;
                                                   }

                                                   __client_ju = 10;
                                                   MouseHandler.MouseHandler_lastButton = 0;
                                                   DevicePcmPlayerProvider.dragInventoryWidget = null;
                                                } else if(itemDragDuration >= 5 && (MouseHandler.MouseHandler_x > __client_ja + 5 || MouseHandler.MouseHandler_x < __client_ja - 5 || MouseHandler.MouseHandler_y > __client_je + 5 || MouseHandler.MouseHandler_y < __client_je - 5)) {
                                                   __client_jl = true;
                                                }
                                             }

                                             if(Scene.method3187()) {
                                                var3 = Scene.Scene_selectedX;
                                                var4 = Scene.Scene_selectedY;
                                                var40 = Interpreter.method1915(ClientPacket.__gs_ct, packetWriter.isaacCipher);
                                                var40.packetBuffer.writeByte(5);
                                                var40.packetBuffer.__bo_322(var4 + GraphicsObject.baseY);
                                                var40.packetBuffer.__bo_322(var3 + class50.baseX);
                                                var40.packetBuffer.__af_314(KeyHandler.KeyHandler_pressedKeys[82]?(KeyHandler.KeyHandler_pressedKeys[81]?2:1):0);
                                                packetWriter.__q_167(var40);
                                                Scene.method3103();
                                                mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                                mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                                mouseCrossColor = 1;
                                                mouseCrossState = 0;
                                                destinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(var35 != Clock.mousedOverWidgetIf1) {
                                                if(var35 != null) {
                                                   class22.method295(var35);
                                                }

                                                if(Clock.mousedOverWidgetIf1 != null) {
                                                   class22.method295(Clock.mousedOverWidgetIf1);
                                                }
                                             }

                                             if(var32 != AccessFile.__dk_lm && __client_lb == __client_ls) {
                                                if(var32 != null) {
                                                   class22.method295(var32);
                                                }

                                                if(AccessFile.__dk_lm != null) {
                                                   class22.method295(AccessFile.__dk_lm);
                                                }
                                             }

                                             if(AccessFile.__dk_lm != null) {
                                                if(__client_lb < __client_ls) {
                                                   ++__client_lb;
                                                   if(__client_ls == __client_lb) {
                                                      class22.method295(AccessFile.__dk_lm);
                                                   }
                                                }
                                             } else if(__client_lb > 0) {
                                                --__client_lb;
                                             }

                                             class54.method1091();
                                             if(isCameraLocked) {
                                                var3 = class3.__w_qs * 128 + 64;
                                                var4 = MusicPatchPcmStream.__hq_qg * 128 + 64;
                                                var5 = class32.getTileHeight(var3, var4, SoundSystem.plane) - AbstractWorldMapIcon.__ak_qj;
                                                if(WorldMapSection1.cameraX < var3) {
                                                   WorldMapSection1.cameraX = (var3 - WorldMapSection1.cameraX) * class30.__ar_qw / 1000 + WorldMapSection1.cameraX + ClientPacket.__gs_qh;
                                                   if(WorldMapSection1.cameraX > var3) {
                                                      WorldMapSection1.cameraX = var3;
                                                   }
                                                }

                                                if(WorldMapSection1.cameraX > var3) {
                                                   WorldMapSection1.cameraX -= class30.__ar_qw * (WorldMapSection1.cameraX - var3) / 1000 + ClientPacket.__gs_qh;
                                                   if(WorldMapSection1.cameraX < var3) {
                                                      WorldMapSection1.cameraX = var3;
                                                   }
                                                }

                                                if(GrandExchangeEvents.cameraY < var5) {
                                                   GrandExchangeEvents.cameraY = (var5 - GrandExchangeEvents.cameraY) * class30.__ar_qw / 1000 + GrandExchangeEvents.cameraY + ClientPacket.__gs_qh;
                                                   if(GrandExchangeEvents.cameraY > var5) {
                                                      GrandExchangeEvents.cameraY = var5;
                                                   }
                                                }

                                                if(GrandExchangeEvents.cameraY > var5) {
                                                   GrandExchangeEvents.cameraY -= class30.__ar_qw * (GrandExchangeEvents.cameraY - var5) / 1000 + ClientPacket.__gs_qh;
                                                   if(GrandExchangeEvents.cameraY < var5) {
                                                      GrandExchangeEvents.cameraY = var5;
                                                   }
                                                }

                                                if(class11.cameraZ < var4) {
                                                   class11.cameraZ = (var4 - class11.cameraZ) * class30.__ar_qw / 1000 + class11.cameraZ + ClientPacket.__gs_qh;
                                                   if(class11.cameraZ > var4) {
                                                      class11.cameraZ = var4;
                                                   }
                                                }

                                                if(class11.cameraZ > var4) {
                                                   class11.cameraZ -= class30.__ar_qw * (class11.cameraZ - var4) / 1000 + ClientPacket.__gs_qh;
                                                   if(class11.cameraZ < var4) {
                                                      class11.cameraZ = var4;
                                                   }
                                                }

                                                var3 = GrandExchangeOffer.__x_rg * 128 + 64;
                                                var4 = KeyHandler.__an_ra * 128 + 64;
                                                var5 = class32.getTileHeight(var3, var4, SoundSystem.plane) - IndexStoreAction.__ik_rt;
                                                var6 = var3 - WorldMapSection1.cameraX;
                                                var7 = var5 - GrandExchangeEvents.cameraY;
                                                var8 = var4 - class11.cameraZ;
                                                var9 = (int)Math.sqrt((double)(var8 * var8 + var6 * var6));
                                                var10 = (int)(Math.atan2((double)var7, (double)var9) * 325.949D) & 2047;
                                                var11 = (int)(Math.atan2((double)var6, (double)var8) * -325.949D) & 2047;
                                                if(var10 < 128) {
                                                   var10 = 128;
                                                }

                                                if(var10 > 383) {
                                                   var10 = 383;
                                                }

                                                if(WorldMapIcon1.cameraPitch < var10) {
                                                   WorldMapIcon1.cameraPitch = (var10 - WorldMapIcon1.cameraPitch) * class171.__fo_ro / 1000 + WorldMapIcon1.cameraPitch + VertexNormal.__dq_rq;
                                                   if(WorldMapIcon1.cameraPitch > var10) {
                                                      WorldMapIcon1.cameraPitch = var10;
                                                   }
                                                }

                                                if(WorldMapIcon1.cameraPitch > var10) {
                                                   WorldMapIcon1.cameraPitch -= class171.__fo_ro * (WorldMapIcon1.cameraPitch - var10) / 1000 + VertexNormal.__dq_rq;
                                                   if(WorldMapIcon1.cameraPitch < var10) {
                                                      WorldMapIcon1.cameraPitch = var10;
                                                   }
                                                }

                                                var12 = var11 - MusicPatchNode.cameraYaw;
                                                if(var12 > 1024) {
                                                   var12 -= 2048;
                                                }

                                                if(var12 < -1024) {
                                                   var12 += 2048;
                                                }

                                                if(var12 > 0) {
                                                   MusicPatchNode.cameraYaw = MusicPatchNode.cameraYaw + VertexNormal.__dq_rq + var12 * class171.__fo_ro / 1000;
                                                   MusicPatchNode.cameraYaw &= 2047;
                                                }

                                                if(var12 < 0) {
                                                   MusicPatchNode.cameraYaw -= VertexNormal.__dq_rq + -var12 * class171.__fo_ro / 1000;
                                                   MusicPatchNode.cameraYaw &= 2047;
                                                }

                                                int var26 = var11 - MusicPatchNode.cameraYaw;
                                                if(var26 > 1024) {
                                                   var26 -= 2048;
                                                }

                                                if(var26 < -1024) {
                                                   var26 += 2048;
                                                }

                                                if(var26 < 0 && var12 > 0 || var26 > 0 && var12 < 0) {
                                                   MusicPatchNode.cameraYaw = var11;
                                                }
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++__client_rk[var3];
                                             }

                                             class196.varcs.tryWrite();
                                             var3 = class22.method297();
                                             var4 = KeyHandler.KeyHandler_idleCycles;
                                             if(var3 > 15000 && var4 > 15000) {
                                                __client_fd = 250;
                                                MouseHandler.MouseHandler_idleCycles = 14500;
                                                var18 = Interpreter.method1915(ClientPacket.__gs_ax, packetWriter.isaacCipher);
                                                packetWriter.__q_167(var18);
                                             }

                                             WorldMapArea.friendSystem.__w_154();
                                             ++packetWriter.__d;
                                             if(packetWriter.__d > 50) {
                                                var18 = Interpreter.method1915(ClientPacket.__gs_c, packetWriter.isaacCipher);
                                                packetWriter.__q_167(var18);
                                             }

                                             try {
                                                packetWriter.__f_166();
                                             } catch (IOException var27) {
                                                class48.method868();
                                             }

                                             return;
                                          }

                                          var36 = var38.widget;
                                          if(var36.childIndex < 0) {
                                             break;
                                          }

                                          var25 = Huffman.getWidget(var36.parentId);
                                       } while(var25 == null || var25.children == null || var36.childIndex >= var25.children.length || var36 != var25.children[var36.childIndex]);

                                       AbstractIndexCache.runScript(var38);
                                    }
                                 }

                                 var36 = var38.widget;
                                 if(var36.childIndex < 0) {
                                    break;
                                 }

                                 var25 = Huffman.getWidget(var36.parentId);
                              } while(var25 == null || var25.children == null || var36.childIndex >= var25.children.length || var36 != var25.children[var36.childIndex]);

                              AbstractIndexCache.runScript(var38);
                           }
                        }

                        var36 = var38.widget;
                        if(var36.childIndex < 0) {
                           break;
                        }

                        var25 = Huffman.getWidget(var36.parentId);
                     } while(var25 == null || var25.children == null || var36.childIndex >= var25.children.length || var36 != var25.children[var36.childIndex]);

                     AbstractIndexCache.runScript(var38);
                  }
               }

               var30 = Interpreter.method1915(ClientPacket.__gs_cw, packetWriter.isaacCipher);
               var30.packetBuffer.writeByte(0);
               var3 = var30.packetBuffer.index;
               WorldMapLabel.method443(var30.packetBuffer);
               var30.packetBuffer.__h_300(var30.packetBuffer.index - var3);
               packetWriter.__q_167(var30);
            }
         }
      }
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1792846917"
   )
   @Export("__ge_137")
   void __ge_137() {
      int var1 = SoundCache.canvasWidth;
      int var2 = Huffman.canvasHeight;
      if(super.contentWidth < var1) {
         var1 = super.contentWidth;
      }

      if(super.contentHeight < var2) {
         var2 = super.contentHeight;
      }

      if(ReflectionCheck.clientPreferences != null) {
         try {
            Client var3 = TextureProvider.client;
            Object[] var4 = new Object[]{Integer.valueOf(SpotAnimationDefinition.method4822())};
            JSObject.getWindow(var3).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1433182492"
   )
   @Export("drawLoggedIn")
   final void drawLoggedIn() {
      if(rootWidgetGroup != -1) {
         ClientPreferences.method1809(rootWidgetGroup);
      }

      int var1;
      for(var1 = 0; var1 < rootWidgetCount; ++var1) {
         if(__client_od[var1]) {
            __client_ot[var1] = true;
         }

         __client_oq[var1] = __client_od[var1];
         __client_od[var1] = false;
      }

      __client_oo = cycle;
      __client_lq = -1;
      __client_ln = -1;
      UserComparator6.__fg_jh = null;
      if(rootWidgetGroup != -1) {
         rootWidgetCount = 0;
         Interpreter.drawWidgets(rootWidgetGroup, 0, 0, SoundCache.canvasWidth, Huffman.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.Rasterizer2D_resetClip();
      if(showMouseCross) {
         if(mouseCrossColor == 1) {
            KeyHandler.crossSprites[mouseCrossState / 100].drawAt2(mouseCrossX - 8, mouseCrossY - 8);
         }

         if(mouseCrossColor == 2) {
            KeyHandler.crossSprites[mouseCrossState / 100 + 4].drawAt2(mouseCrossX - 8, mouseCrossY - 8);
         }
      }

      int var2;
      int var3;
      int var4;
      int var6;
      int var7;
      int var8;
      if(!isMenuOpen) {
         if(__client_lq != -1) {
            class39.drawMenuActionTextAt(__client_lq, __client_ln);
         }
      } else {
         var1 = class25.menuX;
         var2 = GameShell.menuY;
         var3 = class214.menuWidth;
         var4 = AbstractWorldMapIcon.menuHeight;
         int var5 = 0x5d5447;
         Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, var5);
         Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.Rasterizer2D_drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
         class2.fontBold12.draw("Choose Option", var1 + 3, var2 + 14, var5, -1);
         var6 = MouseHandler.MouseHandler_x;
         var7 = MouseHandler.MouseHandler_y;

         int var9;
         int var10;
         for(var8 = 0; var8 < menuOptionsCount; ++var8) {
            var9 = var2 + (menuOptionsCount - 1 - var8) * 15 + 31;
            var10 = 0xffffff;
            if(var6 > var1 && var6 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
               var10 = 0xffff00;
            }

            Font var11 = class2.fontBold12;
            String var12;
            if(var8 < 0) {
               var12 = "";
            } else if(menuTargetNames[var8].length() > 0) {
               var12 = menuActions[var8] + " " + menuTargetNames[var8];
            } else {
               var12 = menuActions[var8];
            }

            var11.draw(var12, var1 + 3, var9, var10, 0);
         }

         var8 = class25.menuX;
         var9 = GameShell.menuY;
         var10 = class214.menuWidth;
         int var13 = AbstractWorldMapIcon.menuHeight;

         for(int var14 = 0; var14 < rootWidgetCount; ++var14) {
            if(rootWidgetXs[var14] + rootWidgetWidths[var14] > var8 && rootWidgetXs[var14] < var8 + var10 && rootWidgetYs[var14] + rootWidgetHeights[var14] > var9 && rootWidgetYs[var14] < var9 + var13) {
               __client_ot[var14] = true;
            }
         }
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < rootWidgetCount; ++var1) {
            if(__client_oq[var1]) {
               Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 0xff00ff, 128);
            } else if(__client_ot[var1]) {
               Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 0xff0000, 128);
            }
         }
      }

      var1 = SoundSystem.plane;
      var2 = Canvas.localPlayer.x;
      var3 = Canvas.localPlayer.y;
      var4 = __client_gy;

      for(ObjectSound var15 = (ObjectSound)ObjectSound.objectSounds.last(); var15 != null; var15 = (ObjectSound)ObjectSound.objectSounds.previous()) {
         if(var15.soundEffectId != -1 || var15.soundEffectIds != null) {
            var6 = 0;
            if(var2 > var15.__o) {
               var6 += var2 - var15.__o;
            } else if(var2 < var15.__q) {
               var6 += var15.__q - var2;
            }

            if(var3 > var15.__u) {
               var6 += var3 - var15.__u;
            } else if(var3 < var15.__w) {
               var6 += var15.__w - var3;
            }

            if(var6 - 64 <= var15.__g && __client_qc != 0 && var1 == var15.__f) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = (var15.__g - var6) * __client_qc / var15.__g;
               Object var10000;
               if(var15.stream1 == null) {
                  if(var15.soundEffectId >= 0) {
                     var10000 = null;
                     SoundEffect var16 = SoundEffect.readSoundEffect(class25.indexCache4, var15.soundEffectId, 0);
                     if(var16 != null) {
                        RawSound var17 = var16.toRawSound().resample(MilliClock.decimator);
                        RawPcmStream var18 = RawPcmStream.method2497(var17, 100, var7);
                        var18.__x_181(-1);
                        TaskHandler.pcmStreamMixer.addSubStream(var18);
                        var15.stream1 = var18;
                     }
                  }
               } else {
                  var15.stream1.__a_182(var7);
               }

               if(var15.stream2 == null) {
                  if(var15.soundEffectIds != null && (var15.__n -= var4) <= 0) {
                     var8 = (int)(Math.random() * (double)var15.soundEffectIds.length);
                     var10000 = null;
                     SoundEffect var20 = SoundEffect.readSoundEffect(class25.indexCache4, var15.soundEffectIds[var8], 0);
                     if(var20 != null) {
                        RawSound var21 = var20.toRawSound().resample(MilliClock.decimator);
                        RawPcmStream var19 = RawPcmStream.method2497(var21, 100, var7);
                        var19.__x_181(0);
                        TaskHandler.pcmStreamMixer.addSubStream(var19);
                        var15.stream2 = var19;
                        var15.__n = var15.__x + (int)(Math.random() * (double)(var15.__d - var15.__x));
                     }
                  }
               } else {
                  var15.stream2.__a_182(var7);
                  if(!var15.stream2.hasNext()) {
                     var15.stream2 = null;
                  }
               }
            } else {
               if(var15.stream1 != null) {
                  TaskHandler.pcmStreamMixer.removeSubStream(var15.stream1);
                  var15.stream1 = null;
               }

               if(var15.stream2 != null) {
                  TaskHandler.pcmStreamMixer.removeSubStream(var15.stream2);
                  var15.stream2 = null;
               }
            }
         }
      }

      __client_gy = 0;
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(Lcl;I)Z",
      garbageValue = "1488446149"
   )
   @Export("__hg_138")
   final boolean __hg_138(PacketWriter var1) {
      AbstractSocket var2 = var1.getSocket();
      PacketBuffer var3 = var1.packetBuffer;
      if(var2 == null) {
         return false;
      } else {
         String var17;
         int var18;
         try {
            int var5;
            if(var1.serverPacket0 == null) {
               if(var1.__e) {
                  if(!var2.isAvailable(1)) {
                     return false;
                  }

                  var2.read(var1.packetBuffer.array, 0, 1);
                  var1.__x = 0;
                  var1.__e = false;
               }

               var3.index = 0;
               if(var3.__ig_334()) {
                  if(!var2.isAvailable(1)) {
                     return false;
                  }

                  var2.read(var1.packetBuffer.array, 1, 1);
                  var1.__x = 0;
               }

               var1.__e = true;
               ServerPacket[] var4 = class27.method429();
               var5 = var3.readSmartByteShortIsaac();
               if(var5 < 0 || var5 >= var4.length) {
                  throw new IOException(var5 + " " + var3.index);
               }

               var1.serverPacket0 = var4[var5];
               var1.serverPacket0Length = var1.serverPacket0.length;
            }

            if(var1.serverPacket0Length == -1) {
               if(!var2.isAvailable(1)) {
                  return false;
               }

               var1.getSocket().read(var3.array, 0, 1);
               var1.serverPacket0Length = var3.array[0] & 255;
            }

            if(var1.serverPacket0Length == -2) {
               if(!var2.isAvailable(2)) {
                  return false;
               }

               var1.getSocket().read(var3.array, 0, 2);
               var3.index = 0;
               var1.serverPacket0Length = var3.__ag_302();
            }

            if(!var2.isAvailable(var1.serverPacket0Length)) {
               return false;
            }

            var3.index = 0;
            var2.read(var3.array, 0, var1.serverPacket0Length);
            var1.__x = 0;
            timer.__m_453();
            var1.__i = var1.__n;
            var1.__n = var1.__k;
            var1.__k = var1.serverPacket0;
            if(ServerPacket.__ge_ax == var1.serverPacket0) {
               class16.method189(class190.field2344);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_be == var1.serverPacket0) {
               isCameraLocked = true;
               class3.__w_qs = var3.readUnsignedByte();
               MusicPatchPcmStream.__hq_qg = var3.readUnsignedByte();
               AbstractWorldMapIcon.__ak_qj = var3.__ag_302();
               ClientPacket.__gs_qh = var3.readUnsignedByte();
               class30.__ar_qw = var3.readUnsignedByte();
               if(class30.__ar_qw >= 100) {
                  WorldMapSection1.cameraX = class3.__w_qs * 128 + 64;
                  class11.cameraZ = MusicPatchPcmStream.__hq_qg * 128 + 64;
                  GrandExchangeEvents.cameraY = class32.getTileHeight(WorldMapSection1.cameraX, class11.cameraZ, SoundSystem.plane) - AbstractWorldMapIcon.__ak_qj;
               }

               var1.serverPacket0 = null;
               return true;
            }

            int var16;
            if(ServerPacket.__ge_aj == var1.serverPacket0) {
               for(var16 = 0; var16 < players.length; ++var16) {
                  if(players[var16] != null) {
                     players[var16].sequence = -1;
                  }
               }

               for(var16 = 0; var16 < npcs.length; ++var16) {
                  if(npcs[var16] != null) {
                     npcs[var16].sequence = -1;
                  }
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_s == var1.serverPacket0) {
               Canvas.__ao_gk = var3.__bq_318();
               WorldMapSection3.__p_go = var3.readUnsignedByteNegate();

               while(var3.index < var1.serverPacket0Length) {
                  var16 = var3.readUnsignedByte();
                  class190 var56 = RunException.method3430()[var16];
                  class16.method189(var56);
               }

               var1.serverPacket0 = null;
               return true;
            }

            Widget var41;
            if(ServerPacket.__ge_bx == var1.serverPacket0) {
               var16 = var3.__aq_303();
               var5 = var3.__bf_332();
               var41 = Huffman.getWidget(var5);
               if(var16 != var41.sequenceId || var16 == -1) {
                  var41.sequenceId = var16;
                  var41.modelFrame = 0;
                  var41.modelFrameCycle = 0;
                  class22.method295(var41);
               }

               var1.serverPacket0 = null;
               return true;
            }

            Widget var52;
            if(ServerPacket.__ge_ar == var1.serverPacket0) {
               var16 = var3.__bf_332();
               var52 = Huffman.getWidget(var16);
               var52.modelType = 3;
               var52.modelId = Canvas.localPlayer.appearance.getChatHeadId();
               class22.method295(var52);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_f == var1.serverPacket0) {
               TextureProvider.method2773();
               var1.serverPacket0 = null;
               return false;
            }

            if(ServerPacket.__ge_l == var1.serverPacket0) {
               var16 = var3.__bp_331();
               var52 = Huffman.getWidget(var16);

               for(var18 = 0; var18 < var52.itemIds.length; ++var18) {
                  var52.itemIds[var18] = -1;
                  var52.itemIds[var18] = 0;
               }

               class22.method295(var52);
               var1.serverPacket0 = null;
               return true;
            }

            int var7;
            int var8;
            int var9;
            int var10;
            if(ServerPacket.__ge_bg == var1.serverPacket0) {
               var16 = var3.readInt();
               var5 = var3.__ag_302();
               if(var16 < -70000) {
                  var5 += 32768;
               }

               if(var16 >= 0) {
                  var41 = Huffman.getWidget(var16);
               } else {
                  var41 = null;
               }

               if(var41 != null) {
                  for(var7 = 0; var7 < var41.itemIds.length; ++var7) {
                     var41.itemIds[var7] = 0;
                     var41.itemQuantities[var7] = 0;
                  }
               }

               PlayerType.method4547(var5);
               var7 = var3.__ag_302();

               for(var8 = 0; var8 < var7; ++var8) {
                  var9 = var3.__ag_302();
                  var10 = var3.readUnsignedByte();
                  if(var10 == 255) {
                     var10 = var3.__bf_332();
                  }

                  if(var41 != null && var8 < var41.itemIds.length) {
                     var41.itemIds[var8] = var9;
                     var41.itemQuantities[var8] = var10;
                  }

                  WorldMapManager.itemContainerSetItem(var5, var8, var9 - 1, var10);
               }

               if(var41 != null) {
                  class22.method295(var41);
               }

               class12.method159();
               __client_nz[++__client_ns - 1 & 31] = var5 & 32767;
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_e == var1.serverPacket0) {
               class16.method189(class190.field2341);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bb == var1.serverPacket0) {
               UserComparator7.method3360(var3, var1.serverPacket0Length);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bm == var1.serverPacket0) {
               WorldMapSection3.__p_go = var3.readUnsignedByteNegate();
               Canvas.__ao_gk = var3.__bq_318();
               var1.serverPacket0 = null;
               return true;
            }

            boolean var47;
            if(ServerPacket.__ge_b == var1.serverPacket0) {
               var16 = var3.readInt();
               var47 = var3.readUnsignedByte() == 1;
               var41 = Huffman.getWidget(var16);
               if(var47 != var41.isHidden) {
                  var41.isHidden = var47;
                  class22.method295(var41);
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bu == var1.serverPacket0) {
               byte var60 = var3.__bn_319();
               var5 = var3.__bu_325();
               Varps.Varps_temp[var5] = var60;
               if(Varps.Varps_main[var5] != var60) {
                  Varps.Varps_main[var5] = var60;
               }

               IndexCache.method4703(var5);
               __client_nr[++__client_nd - 1 & 31] = var5;
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_a == var1.serverPacket0) {
               class16.method189(class190.field2347);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bq == var1.serverPacket0) {
               var16 = var3.readUnsignedByte();
               if(var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var16] = new GrandExchangeOffer();
                  var3.index += 18;
               } else {
                  --var3.index;
                  grandExchangeOffers[var16] = new GrandExchangeOffer(var3, false);
               }

               __client_nv = cycleCntr;
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_cj == var1.serverPacket0) {
               var16 = var3.__bm_326();
               rootWidgetGroup = var16;
               this.__iu_141(false);
               DevicePcmPlayerProvider.method845(var16);
               WorldMapSection3.runWidgetOnLoadListener(rootWidgetGroup);

               for(var5 = 0; var5 < 100; ++var5) {
                  __client_od[var5] = true;
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bo == var1.serverPacket0) {
               class12.method159();
               runEnergy = var3.readUnsignedByte();
               __client_ni = cycleCntr;
               var1.serverPacket0 = null;
               return true;
            }

            Widget var19;
            if(ServerPacket.__ge_af == var1.serverPacket0) {
               var16 = var3.__bm_326();
               var5 = var3.__bm_326();
               var18 = var3.__bm_326();
               var7 = var3.__bf_332();
               var19 = Huffman.getWidget(var7);
               if(var16 != var19.modelAngleX || var18 != var19.modelAngleY || var5 != var19.modelZoom) {
                  var19.modelAngleX = var16;
                  var19.modelAngleY = var18;
                  var19.modelZoom = var5;
                  class22.method295(var19);
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_al == var1.serverPacket0) {
               hintArrowType = var3.readUnsignedByte();
               if(hintArrowType == 1) {
                  hintArrowNpcIndex = var3.__ag_302();
               }

               if(hintArrowType >= 2 && hintArrowType <= 6) {
                  if(hintArrowType == 2) {
                     hintArrowSubX = 64;
                     hintArrowSubY = 64;
                  }

                  if(hintArrowType == 3) {
                     hintArrowSubX = 0;
                     hintArrowSubY = 64;
                  }

                  if(hintArrowType == 4) {
                     hintArrowSubX = 128;
                     hintArrowSubY = 64;
                  }

                  if(hintArrowType == 5) {
                     hintArrowSubX = 64;
                     hintArrowSubY = 0;
                  }

                  if(hintArrowType == 6) {
                     hintArrowSubX = 64;
                     hintArrowSubY = 128;
                  }

                  hintArrowType = 2;
                  hintArrowX = var3.__ag_302();
                  hintArrowY = var3.__ag_302();
                  hintArrowHeight = var3.readUnsignedByte();
               }

               if(hintArrowType == 10) {
                  hintArrowPlayerIndex = var3.__ag_302();
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_cv == var1.serverPacket0) {
               Skeleton.method3062(var3, var1.serverPacket0Length);
               ScriptFrame.method1138();
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_m == var1.serverPacket0) {
               class50.loadRegions(false, var1.packetBuffer);
               var1.serverPacket0 = null;
               return true;
            }

            Widget var58;
            if(ServerPacket.__ge_ap == var1.serverPacket0) {
               var16 = var3.__bu_325();
               var5 = var3.__by_324();
               var18 = var3.__bp_331();
               var58 = Huffman.getWidget(var18);
               var58.__bh = var16 + (var5 << 16);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_ba == var1.serverPacket0) {
               if(rootWidgetGroup != -1) {
                  GrandExchangeEvents.method74(rootWidgetGroup, 0);
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_h == var1.serverPacket0) {
               var16 = var3.readInt();
               var5 = var3.__ag_302();
               if(var5 == 65535) {
                  var5 = -1;
               }

               var18 = var3.__bf_332();
               var58 = Huffman.getWidget(var16);
               ItemDefinition var54;
               if(!var58.isIf3) {
                  if(var5 == -1) {
                     var58.modelType = 0;
                     var1.serverPacket0 = null;
                     return true;
                  }

                  var54 = Skills.getItemDefinition(var5);
                  var58.modelType = 4;
                  var58.modelId = var5;
                  var58.modelAngleX = var54.xan2d;
                  var58.modelAngleY = var54.yan2d;
                  var58.modelZoom = var54.zoom2d * 100 / var18;
                  class22.method295(var58);
               } else {
                  var58.itemId = var5;
                  var58.itemQuantity = var18;
                  var54 = Skills.getItemDefinition(var5);
                  var58.modelAngleX = var54.xan2d;
                  var58.modelAngleY = var54.yan2d;
                  var58.modelAngleZ = var54.zan2d;
                  var58.modelOffsetX = var54.offsetX2d;
                  var58.modelOffsetY = var54.offsetY2d;
                  var58.modelZoom = var54.zoom2d;
                  if(var54.isStackable == 1) {
                     var58.itemQuantityMode = 1;
                  } else {
                     var58.itemQuantityMode = 2;
                  }

                  if(var58.__bf > 0) {
                     var58.modelZoom = var58.modelZoom * 32 / var58.__bf;
                  } else if(var58.rawWidth > 0) {
                     var58.modelZoom = var58.modelZoom * 32 / var58.rawWidth;
                  }

                  class22.method295(var58);
               }

               var1.serverPacket0 = null;
               return true;
            }

            String var6;
            if(ServerPacket.__ge_w == var1.serverPacket0) {
               var16 = var3.__ae_307();
               var47 = var3.readUnsignedByte() == 1;
               var6 = "";
               boolean var44 = false;
               if(var47) {
                  var6 = var3.readStringCp1252NullTerminated();
                  if(WorldMapArea.friendSystem.isIgnored(new Username(var6, KeyHandler.loginType))) {
                     var44 = true;
                  }
               }

               String var53 = var3.readStringCp1252NullTerminated();
               if(!var44) {
                  WorldMapIcon1.method219(var16, var6, var53);
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bi == var1.serverPacket0) {
               IndexCacheLoader.field512 = WorldMapElement.method4783(var3.readUnsignedByte());
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_n == var1.serverPacket0) {
               class16.method189(class190.field2345);
               var1.serverPacket0 = null;
               return true;
            }

            boolean var55;
            if(ServerPacket.__ge_j == var1.serverPacket0) {
               var55 = var3.readBoolean();
               if(var55) {
                  if(ClientParameter.field3645 == null) {
                     ClientParameter.field3645 = new class248();
                  }
               } else {
                  ClientParameter.field3645 = null;
               }

               var1.serverPacket0 = null;
               return true;
            }

            long var21;
            if(ServerPacket.__ge_aa == var1.serverPacket0) {
               var16 = var3.__bt_330();
               var5 = var3.__bu_325();
               if(var5 == 65535) {
                  var5 = -1;
               }

               var18 = var3.__bf_332();
               var7 = var3.__ag_302();
               if(var7 == 65535) {
                  var7 = -1;
               }

               for(var8 = var7; var8 <= var5; ++var8) {
                  var21 = (long)var8 + ((long)var18 << 32);
                  Node var45 = widgetClickMasks.get(var21);
                  if(var45 != null) {
                     var45.remove();
                  }

                  widgetClickMasks.put(new IntegerNode(var16), var21);
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_cy == var1.serverPacket0) {
               class3.updateNpcs(true, var3);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_az == var1.serverPacket0) {
               if(PacketWriter.clanChat != null) {
                  PacketWriter.clanChat.__a_474(var3);
               }

               UserComparator8.method3349();
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_z == var1.serverPacket0) {
               class16.method189(class190.field2346);
               var1.serverPacket0 = null;
               return true;
            }

            String var37;
            if(ServerPacket.__ge_by == var1.serverPacket0) {
               var37 = var3.readStringCp1252NullTerminated();
               Object[] var51 = new Object[var37.length() + 1];

               for(var18 = var37.length() - 1; var18 >= 0; --var18) {
                  if(var37.charAt(var18) == 's') {
                     var51[var18 + 1] = var3.readStringCp1252NullTerminated();
                  } else {
                     var51[var18 + 1] = new Integer(var3.readInt());
                  }
               }

               var51[0] = new Integer(var3.readInt());
               ScriptEvent var43 = new ScriptEvent();
               var43.args0 = var51;
               AbstractIndexCache.runScript(var43);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_ag == var1.serverPacket0) {
               class16.method189(class190.field2343);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_i == var1.serverPacket0) {
               class16.method189(class190.field2350);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bj == var1.serverPacket0) {
               destinationX = var3.readUnsignedByte();
               if(destinationX == 255) {
                  destinationX = 0;
               }

               destinationY = var3.readUnsignedByte();
               if(destinationY == 255) {
                  destinationY = 0;
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_cr == var1.serverPacket0) {
               for(var16 = 0; var16 < VarpDefinition.__ix_f; ++var16) {
                  VarpDefinition var50 = SecureRandomCallable.method1140(var16);
                  if(var50 != null) {
                     Varps.Varps_temp[var16] = 0;
                     Varps.Varps_main[var16] = 0;
                  }
               }

               class12.method159();
               __client_nd += 32;
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_an == var1.serverPacket0) {
               var16 = var3.readInt();
               var5 = var3.__ag_302();
               if(var16 < -70000) {
                  var5 += 32768;
               }

               if(var16 >= 0) {
                  var41 = Huffman.getWidget(var16);
               } else {
                  var41 = null;
               }

               for(; var3.index < var1.serverPacket0Length; WorldMapManager.itemContainerSetItem(var5, var7, var8 - 1, var9)) {
                  var7 = var3.__ae_307();
                  var8 = var3.__ag_302();
                  var9 = 0;
                  if(var8 != 0) {
                     var9 = var3.readUnsignedByte();
                     if(var9 == 255) {
                        var9 = var3.readInt();
                     }
                  }

                  if(var41 != null && var7 >= 0 && var7 < var41.itemIds.length) {
                     var41.itemIds[var7] = var8;
                     var41.itemQuantities[var7] = var9;
                  }
               }

               if(var41 != null) {
                  class22.method295(var41);
               }

               class12.method159();
               __client_nz[++__client_ns - 1 & 31] = var5 & 32767;
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bl == var1.serverPacket0) {
               var16 = var3.__ag_302();
               var5 = var3.readUnsignedByte();
               var18 = var3.__ag_302();
               Ignored.queueSoundEffect(var16, var5, var18);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bc == var1.serverPacket0) {
               var16 = var3.__bp_331();
               var5 = var3.__br_328();
               var18 = var3.__bl_327();
               var58 = Huffman.getWidget(var16);
               if(var18 != var58.rawX || var5 != var58.rawY || var58.xAlignment != 0 || var58.yAlignment != 0) {
                  var58.rawX = var18;
                  var58.rawY = var5;
                  var58.xAlignment = 0;
                  var58.yAlignment = 0;
                  class22.method295(var58);
                  this.alignWidget(var58);
                  if(var58.type == 0) {
                     class39.revalidateWidgetScroll(Widget.widgets[var16 >> 16], var58, false);
                  }
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_aw == var1.serverPacket0) {
               var16 = var3.__bm_326();
               var5 = var3.__bf_332();
               var41 = Huffman.getWidget(var5);
               if(var41.modelType != 2 || var16 != var41.modelId) {
                  var41.modelType = 2;
                  var41.modelId = var16;
                  class22.method295(var41);
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_ao == var1.serverPacket0) {
               World var40 = new World();
               var40.host = var3.readStringCp1252NullTerminated();
               var40.id = var3.__ag_302();
               var5 = var3.readInt();
               var40.properties = var5;
               GameShell.updateGameState(45);
               var2.close();
               var2 = null;
               class31.changeWorld(var40);
               var1.serverPacket0 = null;
               return false;
            }

            if(ServerPacket.__ge_ay == var1.serverPacket0) {
               WorldMapArea.friendSystem.ignoreList.read(var3, var1.serverPacket0Length);
               class229.method4512();
               __client_na = cycleCntr;
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_ah == var1.serverPacket0) {
               class3.updateNpcs(false, var3);
               var1.serverPacket0 = null;
               return true;
            }

            WidgetGroupParent var20;
            if(ServerPacket.__ge_cs == var1.serverPacket0) {
               var16 = var3.readInt();
               var5 = var3.readInt();
               WidgetGroupParent var42 = (WidgetGroupParent)widgetGroupParents.get((long)var5);
               var20 = (WidgetGroupParent)widgetGroupParents.get((long)var16);
               if(var20 != null) {
                  MenuAction.closeWidgetGroup(var20, var42 == null || var42.group != var20.group);
               }

               if(var42 != null) {
                  var42.remove();
                  widgetGroupParents.put(var42, (long)var16);
               }

               var19 = Huffman.getWidget(var5);
               if(var19 != null) {
                  class22.method295(var19);
               }

               var19 = Huffman.getWidget(var16);
               if(var19 != null) {
                  class22.method295(var19);
                  class39.revalidateWidgetScroll(Widget.widgets[var19.id >>> 16], var19, true);
               }

               if(rootWidgetGroup != -1) {
                  GrandExchangeEvents.method74(rootWidgetGroup, 1);
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_p == var1.serverPacket0) {
               var16 = var3.__bp_331();
               var5 = var3.__bu_325();
               var18 = var5 >> 10 & 31;
               var7 = var5 >> 5 & 31;
               var8 = var5 & 31;
               var9 = (var7 << 11) + (var18 << 19) + (var8 << 3);
               Widget var59 = Huffman.getWidget(var16);
               if(var9 != var59.color) {
                  var59.color = var9;
                  class22.method295(var59);
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_at == var1.serverPacket0) {
               var16 = var3.readUnsignedByte();
               var5 = var3.readUnsignedByte();
               var18 = var3.readUnsignedByte();
               var7 = var3.readUnsignedByte();
               __client_rh[var16] = true;
               __client_rd[var16] = var5;
               __client_rl[var16] = var18;
               __client_rj[var16] = var7;
               __client_rk[var16] = 0;
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_ce == var1.serverPacket0) {
               __client_pl = var3.readUnsignedByteNegate();
               publicChatMode = var3.readUnsignedByteNegate();
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bp == var1.serverPacket0) {
               rebootTimer = var3.__ag_302() * 30;
               __client_ni = cycleCntr;
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_v == var1.serverPacket0) {
               Canvas.__ao_gk = var3.readUnsignedByteNegate();
               WorldMapSection3.__p_go = var3.readUnsignedByte();

               for(var16 = WorldMapSection3.__p_go; var16 < WorldMapSection3.__p_go + 8; ++var16) {
                  for(var5 = Canvas.__ao_gk; var5 < Canvas.__ao_gk + 8; ++var5) {
                     if(groundItems[SoundSystem.plane][var16][var5] != null) {
                        groundItems[SoundSystem.plane][var16][var5] = null;
                        TilePaint.method3061(var16, var5);
                     }
                  }
               }

               for(class68 var39 = (class68)__client_kh.last(); var39 != null; var39 = (class68)__client_kh.previous()) {
                  if(var39.field913 >= WorldMapSection3.__p_go && var39.field913 < WorldMapSection3.__p_go + 8 && var39.field901 >= Canvas.__ao_gk && var39.field901 < Canvas.__ao_gk + 8 && var39.field911 == SoundSystem.plane) {
                     var39.field910 = 0;
                  }
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_ac == var1.serverPacket0) {
               var16 = var3.__bf_332();
               var5 = var3.__bm_326();
               var41 = Huffman.getWidget(var16);
               if(var41.modelType != 1 || var5 != var41.modelId) {
                  var41.modelType = 1;
                  var41.modelId = var5;
                  class22.method295(var41);
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_ak == var1.serverPacket0) {
               var16 = var3.readUnsignedByte();
               BufferedNetSocket.method3500(var16);
               var1.serverPacket0 = null;
               return true;
            }

            long var12;
            long var24;
            long var26;
            if(ServerPacket.__ge_bs == var1.serverPacket0) {
               var37 = var3.readStringCp1252NullTerminated();
               var24 = var3.readLong();
               var26 = (long)var3.__ag_302();
               var21 = (long)var3.readMedium();
               PlayerType var11 = (PlayerType)ScriptFrame.findEnumerated(class48.method865(), var3.readUnsignedByte());
               var12 = (var26 << 32) + var21;
               boolean var46 = false;

               for(int var15 = 0; var15 < 100; ++var15) {
                  if(__client_pu[var15] == var12) {
                     var46 = true;
                     break;
                  }
               }

               if(var11.isUser && WorldMapArea.friendSystem.isIgnored(new Username(var37, KeyHandler.loginType))) {
                  var46 = true;
               }

               if(!var46 && __client_jc == 0) {
                  __client_pu[__client_pb] = var12;
                  __client_pb = (__client_pb + 1) % 100;
                  String var28 = AbstractFont.escapeBrackets(class233.method4527(KitDefinition.method4866(var3)));
                  if(var11.modIcon != -1) {
                     GrandExchangeEvents.addChatMessage(9, ItemContainer.method1170(var11.modIcon) + var37, var28, Clock.method3534(var24));
                  } else {
                     GrandExchangeEvents.addChatMessage(9, var37, var28, Clock.method3534(var24));
                  }
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_as == var1.serverPacket0) {
               class16.method189(class190.field2342);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_y == var1.serverPacket0) {
               var16 = var3.readInt();
               var17 = var3.readStringCp1252NullTerminated();
               var41 = Huffman.getWidget(var16);
               if(!var17.equals(var41.text)) {
                  var41.text = var17;
                  class22.method295(var41);
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_ai == var1.serverPacket0) {
               class50.loadRegions(true, var1.packetBuffer);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_q == var1.serverPacket0) {
               isCameraLocked = false;

               for(var16 = 0; var16 < 5; ++var16) {
                  __client_rh[var16] = false;
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_cm == var1.serverPacket0) {
               isCameraLocked = true;
               GrandExchangeOffer.__x_rg = var3.readUnsignedByte();
               KeyHandler.__an_ra = var3.readUnsignedByte();
               IndexStoreAction.__ik_rt = var3.__ag_302();
               VertexNormal.__dq_rq = var3.readUnsignedByte();
               class171.__fo_ro = var3.readUnsignedByte();
               if(class171.__fo_ro >= 100) {
                  var16 = GrandExchangeOffer.__x_rg * 128 + 64;
                  var5 = KeyHandler.__an_ra * 128 + 64;
                  var18 = class32.getTileHeight(var16, var5, SoundSystem.plane) - IndexStoreAction.__ik_rt;
                  var7 = var16 - WorldMapSection1.cameraX;
                  var8 = var18 - GrandExchangeEvents.cameraY;
                  var9 = var5 - class11.cameraZ;
                  var10 = (int)Math.sqrt((double)(var9 * var9 + var7 * var7));
                  WorldMapIcon1.cameraPitch = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
                  MusicPatchNode.cameraYaw = (int)(Math.atan2((double)var7, (double)var9) * -325.949D) & 2047;
                  if(WorldMapIcon1.cameraPitch < 128) {
                     WorldMapIcon1.cameraPitch = 128;
                  }

                  if(WorldMapIcon1.cameraPitch > 383) {
                     WorldMapIcon1.cameraPitch = 383;
                  }
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bv == var1.serverPacket0) {
               var16 = var3.__bf_332();
               var5 = var3.__bm_326();
               var41 = Huffman.getWidget(var16);
               if(var41 != null && var41.type == 0) {
                  if(var5 > var41.scrollHeight - var41.height) {
                     var5 = var41.scrollHeight - var41.height;
                  }

                  if(var5 < 0) {
                     var5 = 0;
                  }

                  if(var5 != var41.scrollY) {
                     var41.scrollY = var5;
                     class22.method295(var41);
                  }
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_au == var1.serverPacket0) {
               var16 = var3.__by_324();
               Script.method2216(var16);
               __client_nz[++__client_ns - 1 & 31] = var16 & 32767;
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bk == var1.serverPacket0) {
               var3.index += 28;
               if(var3.__ax_313()) {
                  class234.method4535(var3, var3.index - 28);
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_c == var1.serverPacket0) {
               class12.method159();
               var16 = var3.__bt_330();
               var5 = var3.readUnsignedByteNegate();
               var18 = var3.readUnsignedByte();
               experience[var5] = var16;
               currentLevels[var5] = var18;
               levels[var5] = 1;

               for(var7 = 0; var7 < 98; ++var7) {
                  if(var16 >= Skills.Skills_experienceTable[var7]) {
                     levels[var5] = var7 + 2;
                  }
               }

               changedSkills[++changedSkillsCount - 1 & 31] = var5;
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bz == var1.serverPacket0) {
               var16 = var3.readInt();
               var5 = var3.readInt();
               var18 = DynamicObject.method2222();
               PacketBufferNode var57 = Interpreter.method1915(ClientPacket.__gs_k, packetWriter.isaacCipher);
               var57.packetBuffer.__ai_315(var18);
               var57.packetBuffer.writeByte(GameShell.fps);
               var57.packetBuffer.writeIntME(var16);
               var57.packetBuffer.writeIntLE(var5);
               packetWriter.__q_167(var57);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bt == var1.serverPacket0) {
               class12.method159();
               weight = var3.__aq_303();
               __client_ni = cycleCntr;
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_aq == var1.serverPacket0) {
               var55 = var3.readUnsignedByte() == 1;
               if(var55) {
                  class15.__z_si = class203.currentTimeMs() - var3.readLong();
                  FloorDecoration.grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  FloorDecoration.grandExchangeEvents = null;
               }

               __client_nc = cycleCntr;
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_av == var1.serverPacket0) {
               WorldMapArea.friendSystem.__f_152();
               __client_na = cycleCntr;
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_t == var1.serverPacket0) {
               byte[] var38 = new byte[var1.serverPacket0Length];
               var3.__jb_335(var38, 0, var38.length);
               Buffer var49 = new Buffer(var38);
               var6 = var49.readStringCp1252NullTerminated();
               WorldMapCacheName.method635(var6, true, false);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_k == var1.serverPacket0) {
               class16.method189(class190.field2352);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bn == var1.serverPacket0) {
               var16 = var3.index + var1.serverPacket0Length;
               var5 = var3.__ag_302();
               var18 = var3.__ag_302();
               if(var5 != rootWidgetGroup) {
                  rootWidgetGroup = var5;
                  this.__iu_141(false);
                  DevicePcmPlayerProvider.method845(rootWidgetGroup);
                  WorldMapSection3.runWidgetOnLoadListener(rootWidgetGroup);

                  for(var7 = 0; var7 < 100; ++var7) {
                     __client_od[var7] = true;
                  }
               }

               WidgetGroupParent var23;
               for(; var18-- > 0; var23.keep = true) {
                  var7 = var3.readInt();
                  var8 = var3.__ag_302();
                  var9 = var3.readUnsignedByte();
                  var23 = (WidgetGroupParent)widgetGroupParents.get((long)var7);
                  if(var23 != null && var8 != var23.group) {
                     MenuAction.closeWidgetGroup(var23, true);
                     var23 = null;
                  }

                  if(var23 == null) {
                     var23 = SecureRandomCallable.method1143(var7, var8, var9);
                  }
               }

               for(var20 = (WidgetGroupParent)widgetGroupParents.first(); var20 != null; var20 = (WidgetGroupParent)widgetGroupParents.next()) {
                  if(var20.keep) {
                     var20.keep = false;
                  } else {
                     MenuAction.closeWidgetGroup(var20, true);
                  }
               }

               widgetClickMasks = new NodeHashTable(512);

               while(var3.index < var16) {
                  var7 = var3.readInt();
                  var8 = var3.__ag_302();
                  var9 = var3.__ag_302();
                  var10 = var3.readInt();

                  for(int var29 = var8; var29 <= var9; ++var29) {
                     var12 = (long)var29 + ((long)var7 << 32);
                     widgetClickMasks.put(new IntegerNode(var10), var12);
                  }
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_br == var1.serverPacket0) {
               var16 = var3.__bb_317();
               var5 = var3.__bb_317();
               var6 = var3.readStringCp1252NullTerminated();
               if(var5 >= 1 && var5 <= 8) {
                  if(var6.equalsIgnoreCase("null")) {
                     var6 = null;
                  }

                  playerMenuActions[var5 - 1] = var6;
                  playerOptionsPriorities[var5 - 1] = var16 == 0;
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_ab == var1.serverPacket0) {
               Clock.method3533(var3.readStringCp1252NullTerminated());
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_am == var1.serverPacket0) {
               if(var1.serverPacket0Length == 0) {
                  PacketWriter.clanChat = null;
               } else {
                  if(PacketWriter.clanChat == null) {
                     PacketWriter.clanChat = new ClanChat(KeyHandler.loginType, TextureProvider.client);
                  }

                  PacketWriter.clanChat.readUpdate(var3);
               }

               UserComparator8.method3349();
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_o == var1.serverPacket0) {
               var16 = var3.__ag_302();
               var5 = var3.readInt();
               Varps.Varps_temp[var16] = var5;
               if(Varps.Varps_main[var16] != var5) {
                  Varps.Varps_main[var16] = var5;
               }

               IndexCache.method4703(var16);
               __client_nr[++__client_nd - 1 & 31] = var16;
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_g == var1.serverPacket0) {
               class16.method189(class190.field2349);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_x == var1.serverPacket0) {
               var16 = var3.readInt();
               WidgetGroupParent var48 = (WidgetGroupParent)widgetGroupParents.get((long)var16);
               if(var48 != null) {
                  MenuAction.closeWidgetGroup(var48, true);
               }

               if(__client_mo != null) {
                  class22.method295(__client_mo);
                  __client_mo = null;
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bf == var1.serverPacket0) {
               for(var16 = 0; var16 < Varps.Varps_main.length; ++var16) {
                  if(Varps.Varps_temp[var16] != Varps.Varps_main[var16]) {
                     Varps.Varps_main[var16] = Varps.Varps_temp[var16];
                     IndexCache.method4703(var16);
                     __client_nr[++__client_nd - 1 & 31] = var16;
                  }
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bd == var1.serverPacket0) {
               WorldMapArea.friendSystem.__q_153(var3, var1.serverPacket0Length);
               __client_na = cycleCntr;
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_r == var1.serverPacket0) {
               var16 = var3.__bm_326();
               if(var16 == 65535) {
                  var16 = -1;
               }

               AbstractUserComparator.method5437(var16);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_ad == var1.serverPacket0) {
               var16 = var3.__bj_329();
               var5 = var3.__bu_325();
               if(var5 == 65535) {
                  var5 = -1;
               }

               HealthBar.method1994(var5, var16);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bw == var1.serverPacket0) {
               var16 = var3.__bb_317();
               var5 = var3.__bp_331();
               var18 = var3.__bm_326();
               var20 = (WidgetGroupParent)widgetGroupParents.get((long)var5);
               if(var20 != null) {
                  MenuAction.closeWidgetGroup(var20, var18 != var20.group);
               }

               SecureRandomCallable.method1143(var5, var18, var16);
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_d == var1.serverPacket0) {
               var37 = var3.readStringCp1252NullTerminated();
               var24 = (long)var3.__ag_302();
               var26 = (long)var3.readMedium();
               PlayerType var30 = (PlayerType)ScriptFrame.findEnumerated(class48.method865(), var3.readUnsignedByte());
               long var31 = (var24 << 32) + var26;
               boolean var33 = false;

               for(int var13 = 0; var13 < 100; ++var13) {
                  if(var31 == __client_pu[var13]) {
                     var33 = true;
                     break;
                  }
               }

               if(WorldMapArea.friendSystem.isIgnored(new Username(var37, KeyHandler.loginType))) {
                  var33 = true;
               }

               if(!var33 && __client_jc == 0) {
                  __client_pu[__client_pb] = var31;
                  __client_pb = (__client_pb + 1) % 100;
                  String var34 = AbstractFont.escapeBrackets(class233.method4527(KitDefinition.method4866(var3)));
                  byte var14;
                  if(var30.isPrivileged) {
                     var14 = 7;
                  } else {
                     var14 = 3;
                  }

                  if(var30.modIcon != -1) {
                     WorldMapIcon1.method219(var14, ItemContainer.method1170(var30.modIcon) + var37, var34);
                  } else {
                     WorldMapIcon1.method219(var14, var37, var34);
                  }
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_u == var1.serverPacket0) {
               var16 = var3.readInt();
               if(var16 != __client_il) {
                  __client_il = var16;
                  WorldMapArea.method428();
               }

               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_bh == var1.serverPacket0) {
               minimapState = var3.readUnsignedByte();
               var1.serverPacket0 = null;
               return true;
            }

            if(ServerPacket.__ge_ae == var1.serverPacket0) {
               var37 = var3.readStringCp1252NullTerminated();
               var17 = AbstractFont.escapeBrackets(class233.method4527(KitDefinition.method4866(var3)));
               WorldMapIcon1.method219(6, var37, var17);
               var1.serverPacket0 = null;
               return true;
            }

            NpcDefinition.sendStackTrace("" + (var1.serverPacket0 != null?var1.serverPacket0.id:-1) + "," + (var1.__n != null?var1.__n.id:-1) + "," + (var1.__i != null?var1.__i.id:-1) + "," + var1.serverPacket0Length, (Throwable)null);
            TextureProvider.method2773();
         } catch (IOException var35) {
            class48.method868();
         } catch (Exception var36) {
            var17 = "" + (var1.serverPacket0 != null?var1.serverPacket0.id:-1) + "," + (var1.__n != null?var1.__n.id:-1) + "," + (var1.__i != null?var1.__i.id:-1) + "," + var1.serverPacket0Length + "," + (Canvas.localPlayer.pathX[0] + class50.baseX) + "," + (Canvas.localPlayer.pathY[0] + GraphicsObject.baseY) + ",";

            for(var18 = 0; var18 < var1.serverPacket0Length && var18 < 50; ++var18) {
               var17 = var17 + var3.array[var18] + ",";
            }

            NpcDefinition.sendStackTrace(var17, var36);
            TextureProvider.method2773();
         }

         return true;
      }
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-387903382"
   )
   @Export("__hi_139")
   final void __hi_139() {
      boolean var1 = false;

      int var2;
      int var5;
      while(!var1) {
         var1 = true;

         for(var2 = 0; var2 < menuOptionsCount - 1; ++var2) {
            if(menuOpcodes[var2] < 1000 && menuOpcodes[var2 + 1] > 1000) {
               String var3 = menuTargetNames[var2];
               menuTargetNames[var2] = menuTargetNames[var2 + 1];
               menuTargetNames[var2 + 1] = var3;
               String var4 = menuActions[var2];
               menuActions[var2] = menuActions[var2 + 1];
               menuActions[var2 + 1] = var4;
               var5 = menuOpcodes[var2];
               menuOpcodes[var2] = menuOpcodes[var2 + 1];
               menuOpcodes[var2 + 1] = var5;
               var5 = menuArguments1[var2];
               menuArguments1[var2] = menuArguments1[var2 + 1];
               menuArguments1[var2 + 1] = var5;
               var5 = menuArguments2[var2];
               menuArguments2[var2] = menuArguments2[var2 + 1];
               menuArguments2[var2 + 1] = var5;
               var5 = menuArguments0[var2];
               menuArguments0[var2] = menuArguments0[var2 + 1];
               menuArguments0[var2 + 1] = var5;
               boolean var6 = menuShiftClick[var2];
               menuShiftClick[var2] = menuShiftClick[var2 + 1];
               menuShiftClick[var2 + 1] = var6;
               var1 = false;
            }
         }
      }

      if(DevicePcmPlayerProvider.dragInventoryWidget == null) {
         if(clickedWidget == null) {
            int var16;
            label279: {
               int var15 = MouseHandler.MouseHandler_lastButton;
               int var9;
               int var13;
               if(isMenuOpen) {
                  int var12;
                  if(var15 != 1 && (AbstractRasterProvider.__lp_ca || var15 != 4)) {
                     var2 = MouseHandler.MouseHandler_x;
                     var12 = MouseHandler.MouseHandler_y;
                     if(var2 < class25.menuX - 10 || var2 > class25.menuX + class214.menuWidth + 10 || var12 < GameShell.menuY - 10 || var12 > AbstractWorldMapIcon.menuHeight + GameShell.menuY + 10) {
                        isMenuOpen = false;
                        Players.method2112(class25.menuX, GameShell.menuY, class214.menuWidth, AbstractWorldMapIcon.menuHeight);
                     }
                  }

                  if(var15 == 1 || !AbstractRasterProvider.__lp_ca && var15 == 4) {
                     var2 = class25.menuX;
                     var12 = GameShell.menuY;
                     var13 = class214.menuWidth;
                     var5 = MouseHandler.MouseHandler_lastPressedX;
                     var16 = MouseHandler.MouseHandler_lastPressedY;
                     int var7 = -1;

                     for(int var17 = 0; var17 < menuOptionsCount; ++var17) {
                        var9 = (menuOptionsCount - 1 - var17) * 15 + var12 + 31;
                        if(var5 > var2 && var5 < var13 + var2 && var16 > var9 - 13 && var16 < var9 + 3) {
                           var7 = var17;
                        }
                     }

                     if(var7 != -1) {
                        WorldMapSection0.method245(var7);
                     }

                     isMenuOpen = false;
                     Players.method2112(class25.menuX, GameShell.menuY, class214.menuWidth, AbstractWorldMapIcon.menuHeight);
                  }
               } else {
                  var2 = menuOptionsCount - 1;
                  if((var15 == 1 || !AbstractRasterProvider.__lp_ca && var15 == 4) && var2 >= 0) {
                     var13 = menuOpcodes[var2];
                     if(var13 == 39 || var13 == 40 || var13 == 41 || var13 == 42 || var13 == 43 || var13 == 33 || var13 == 34 || var13 == 35 || var13 == 36 || var13 == 37 || var13 == 38 || var13 == 1005) {
                        var5 = menuArguments1[var2];
                        var16 = menuArguments2[var2];
                        Widget var14 = Huffman.getWidget(var16);
                        var9 = class1.getWidgetClickMask(var14);
                        boolean var8 = (var9 >> 28 & 1) != 0;
                        if(var8) {
                           break label279;
                        }

                        Object var10000 = null;
                        if(class168.method3461(class1.getWidgetClickMask(var14))) {
                           break label279;
                        }
                     }
                  }

                  if((var15 == 1 || !AbstractRasterProvider.__lp_ca && var15 == 4) && this.shouldLeftClickOpenMenu()) {
                     var15 = 2;
                  }

                  if((var15 == 1 || !AbstractRasterProvider.__lp_ca && var15 == 4) && menuOptionsCount > 0) {
                     WorldMapSection0.method245(var2);
                  }

                  if(var15 == 2 && menuOptionsCount > 0) {
                     this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
                  }
               }

               return;
            }

            if(DevicePcmPlayerProvider.dragInventoryWidget != null && !__client_jl && menuOptionsCount > 0 && !this.shouldLeftClickOpenMenu()) {
               int var10 = __client_ja;
               int var11 = __client_je;
               class231.method4520(UnitPriceComparator.tempMenuAction, var10, var11);
               UnitPriceComparator.tempMenuAction = null;
            }

            __client_jl = false;
            itemDragDuration = 0;
            if(DevicePcmPlayerProvider.dragInventoryWidget != null) {
               class22.method295(DevicePcmPlayerProvider.dragInventoryWidget);
            }

            DevicePcmPlayerProvider.dragInventoryWidget = Huffman.getWidget(var16);
            dragItemSlotSource = var5;
            __client_ja = MouseHandler.MouseHandler_lastPressedX;
            __client_je = MouseHandler.MouseHandler_lastPressedY;
            if(var2 >= 0) {
               UnitPriceComparator.tempMenuAction = new MenuAction();
               UnitPriceComparator.tempMenuAction.argument1 = menuArguments1[var2];
               UnitPriceComparator.tempMenuAction.argument2 = menuArguments2[var2];
               UnitPriceComparator.tempMenuAction.opcode = menuOpcodes[var2];
               UnitPriceComparator.tempMenuAction.argument0 = menuArguments0[var2];
               UnitPriceComparator.tempMenuAction.action = menuActions[var2];
            }

            class22.method295(DevicePcmPlayerProvider.dragInventoryWidget);
         }
      }
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "109"
   )
   @Export("shouldLeftClickOpenMenu")
   final boolean shouldLeftClickOpenMenu() {
      int var1 = menuOptionsCount - 1;
      return (__client_ku == 1 && menuOptionsCount > 2 || UserComparator7.method3364(var1)) && !menuShiftClick[var1];
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   @Export("openMenu")
   final void openMenu(int var1, int var2) {
      int var3 = class2.fontBold12.stringWidth("Choose Option");

      int var4;
      for(var4 = 0; var4 < menuOptionsCount; ++var4) {
         Font var5 = class2.fontBold12;
         String var6;
         if(var4 < 0) {
            var6 = "";
         } else if(menuTargetNames[var4].length() > 0) {
            var6 = menuActions[var4] + " " + menuTargetNames[var4];
         } else {
            var6 = menuActions[var4];
         }

         int var7 = var5.stringWidth(var6);
         if(var7 > var3) {
            var3 = var7;
         }
      }

      var3 += 8;
      var4 = menuOptionsCount * 15 + 22;
      int var8 = var1 - var3 / 2;
      if(var3 + var8 > SoundCache.canvasWidth) {
         var8 = SoundCache.canvasWidth - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var9 = var2;
      if(var4 + var2 > Huffman.canvasHeight) {
         var9 = Huffman.canvasHeight - var4;
      }

      if(var9 < 0) {
         var9 = 0;
      }

      class25.menuX = var8;
      GameShell.menuY = var9;
      class214.menuWidth = var3;
      AbstractWorldMapIcon.menuHeight = menuOptionsCount * 15 + 22;
      class65.scene.menuOpen(SoundSystem.plane, var1, var2, false);
      isMenuOpen = true;
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-271438207"
   )
   @Export("__iu_141")
   final void __iu_141(boolean var1) {
      int var2 = rootWidgetGroup;
      int var3 = SoundCache.canvasWidth;
      int var4 = Huffman.canvasHeight;
      if(GroundItemPile.loadWidgetGroup(var2)) {
         WorldMapRegion.notRevalidateWidgetScroll(Widget.widgets[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(Lho;B)V",
      garbageValue = "0"
   )
   @Export("alignWidget")
   void alignWidget(Widget var1) {
      Widget var2 = var1.parentId == -1?null:Huffman.getWidget(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = SoundCache.canvasWidth;
         var4 = Huffman.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      WorldMapSection3.alignWidgetSize(var1, var3, var4, false);
      OverlayDefinition.alignWidgetPosition(var1, var3, var4);
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "715978124"
   )
   @Export("__jh_142")
   final void __jh_142() {
      class22.method295(clickedWidget);
      ++MouseRecorder.widgetDragDuration;
      if(__client_nt && __client_nn) {
         int var1 = MouseHandler.MouseHandler_x;
         int var2 = MouseHandler.MouseHandler_y;
         var1 -= widgetClickX;
         var2 -= widgetClickY;
         if(var1 < __client_nw) {
            var1 = __client_nw;
         }

         if(var1 + clickedWidget.width > __client_nw + clickedWidgetParent.width) {
            var1 = __client_nw + clickedWidgetParent.width - clickedWidget.width;
         }

         if(var2 < __client_nl) {
            var2 = __client_nl;
         }

         if(var2 + clickedWidget.height > __client_nl + clickedWidgetParent.height) {
            var2 = __client_nl + clickedWidgetParent.height - clickedWidget.height;
         }

         int var3 = var1 - __client_nk;
         int var4 = var2 - __client_np;
         int var5 = clickedWidget.dragZoneSize;
         if(MouseRecorder.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            isDraggingWidget = true;
         }

         int var6 = var1 - __client_nw + clickedWidgetParent.scrollX;
         int var7 = var2 - __client_nl + clickedWidgetParent.scrollY;
         ScriptEvent var8;
         if(clickedWidget.onDrag != null && isDraggingWidget) {
            var8 = new ScriptEvent();
            var8.widget = clickedWidget;
            var8.mouseX = var6;
            var8.mouseY = var7;
            var8.args0 = clickedWidget.onDrag;
            AbstractIndexCache.runScript(var8);
         }

         if(MouseHandler.MouseHandler_currentButton == 0) {
            if(isDraggingWidget) {
               if(clickedWidget.onDragComplete != null) {
                  var8 = new ScriptEvent();
                  var8.widget = clickedWidget;
                  var8.mouseX = var6;
                  var8.mouseY = var7;
                  var8.dragTarget = draggedOnWidget;
                  var8.args0 = clickedWidget.onDragComplete;
                  AbstractIndexCache.runScript(var8);
               }

               if(draggedOnWidget != null) {
                  Widget var9 = clickedWidget;
                  int var10 = WorldMapRegion.method568(class1.getWidgetClickMask(var9));
                  Widget var15;
                  if(var10 == 0) {
                     var15 = null;
                  } else {
                     int var11 = 0;

                     while(true) {
                        if(var11 >= var10) {
                           var15 = var9;
                           break;
                        }

                        var9 = Huffman.getWidget(var9.parentId);
                        if(var9 == null) {
                           var15 = null;
                           break;
                        }

                        ++var11;
                     }
                  }

                  if(var15 != null) {
                     PacketBufferNode var12 = Interpreter.method1915(ClientPacket.__gs_bk, packetWriter.isaacCipher);
                     var12.packetBuffer.__bo_322(clickedWidget.childIndex);
                     var12.packetBuffer.__bo_322(draggedOnWidget.itemId);
                     var12.packetBuffer.writeShort(draggedOnWidget.childIndex);
                     var12.packetBuffer.writeIntLE(clickedWidget.id);
                     var12.packetBuffer.writeIntME(draggedOnWidget.id);
                     var12.packetBuffer.writeShort(clickedWidget.itemId);
                     packetWriter.__q_167(var12);
                  }
               }
            } else if(this.shouldLeftClickOpenMenu()) {
               this.openMenu(__client_nk + widgetClickX, __client_np + widgetClickY);
            } else if(menuOptionsCount > 0) {
               int var13 = widgetClickX + __client_nk;
               int var14 = widgetClickY + __client_np;
               class231.method4520(UnitPriceComparator.tempMenuAction, var13, var14);
               UnitPriceComparator.tempMenuAction = null;
            }

            clickedWidget = null;
         }

      } else {
         if(MouseRecorder.widgetDragDuration > 1) {
            clickedWidget = null;
         }

      }
   }

   @ObfuscatedName("kr")
   @ObfuscatedSignature(
      signature = "(B)Lkp;",
      garbageValue = "-87"
   )
   public Username username() {
      return Canvas.localPlayer != null?Canvas.localPlayer.username:null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1464358697"
   )
   @Export("hashString")
   public static int hashString(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + HealthBar.charToByteCp1252(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "0"
   )
   public static int method1692(String var0) {
      return var0.length() + 2;
   }
}
