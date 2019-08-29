import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameShell implements Usernamed {
	@ObfuscatedName("oj")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("widgetClickMasks")
	static NodeHashTable widgetClickMasks;
	@ObfuscatedName("ps")
	@ObfuscatedSignature(
		signature = "Ljl;"
	)
	@Export("clanChat")
	static ClanChat clanChat;
	@ObfuscatedName("mh")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("clickedWidget")
	static Widget clickedWidget;
	@ObfuscatedName("ol")
	@ObfuscatedGetter(
		intValue = 1199265875
	)
	@Export("rootWidgetCount")
	static int rootWidgetCount;
	@ObfuscatedName("oo")
	@ObfuscatedGetter(
		intValue = -1904808037
	)
	static int field752;
	@ObfuscatedName("oq")
	@ObfuscatedGetter(
		longValue = 3836241446737313129L
	)
	static long field836;
	@ObfuscatedName("sk")
	@ObfuscatedGetter(
		intValue = 2060318015
	)
	public static int field892;
	@ObfuscatedName("ow")
	static boolean[] field703;
	@ObfuscatedName("oa")
	static boolean[] field830;
	@ObfuscatedName("oy")
	static boolean[] field829;
	@ObfuscatedName("nd")
	static boolean field804;
	@ObfuscatedName("nc")
	static boolean field641;
	@ObfuscatedName("oc")
	@Export("isResizable")
	static boolean isResizable;
	@ObfuscatedName("ns")
	@ObfuscatedGetter(
		intValue = 612002381
	)
	@Export("cycleCntr")
	static int cycleCntr;
	@ObfuscatedName("no")
	@ObfuscatedGetter(
		intValue = 686779073
	)
	static int field629;
	@ObfuscatedName("qb")
	static boolean field858;
	@ObfuscatedName("mp")
	@ObfuscatedGetter(
		intValue = -772624841
	)
	@Export("widgetClickX")
	static int widgetClickX;
	@ObfuscatedName("mx")
	@ObfuscatedGetter(
		intValue = 324303259
	)
	@Export("widgetClickY")
	static int widgetClickY;
	@ObfuscatedName("nm")
	@ObfuscatedGetter(
		intValue = 1015270749
	)
	static int field802;
	@ObfuscatedName("ms")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("clickedWidgetParent")
	static Widget clickedWidgetParent;
	@ObfuscatedName("mi")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("interfaceParents")
	static NodeHashTable interfaceParents;
	@ObfuscatedName("on")
	@Export("rootWidgetXs")
	static int[] rootWidgetXs;
	@ObfuscatedName("ou")
	@Export("rootWidgetWidths")
	static int[] rootWidgetWidths;
	@ObfuscatedName("nf")
	@ObfuscatedGetter(
		intValue = -958579239
	)
	static int field803;
	@ObfuscatedName("mo")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("viewportWidget")
	static Widget viewportWidget;
	@ObfuscatedName("ox")
	@ObfuscatedGetter(
		intValue = 1767414743
	)
	@Export("gameDrawingMode")
	static int gameDrawingMode;
	@ObfuscatedName("ov")
	@Export("rootWidgetHeights")
	static int[] rootWidgetHeights;
	@ObfuscatedName("my")
	@ObfuscatedGetter(
		intValue = 2067641259
	)
	@Export("staffModLevel")
	public static int staffModLevel;
	@ObfuscatedName("ot")
	@Export("rootWidgetYs")
	static int[] rootWidgetYs;
	@ObfuscatedName("tz")
	static int[] field697;
	@ObfuscatedName("tk")
	static int[] field898;
	@ObfuscatedName("tr")
	@ObfuscatedSignature(
		signature = "Lbf;"
	)
	static final class65 field684;
	@ObfuscatedName("og")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	@Export("scriptEvents")
	static NodeDeque scriptEvents;
	@ObfuscatedName("nl")
	@ObfuscatedGetter(
		intValue = 438883805
	)
	static int field805;
	@ObfuscatedName("nr")
	@ObfuscatedGetter(
		intValue = -179501637
	)
	static int field806;
	@ObfuscatedName("qi")
	@ObfuscatedGetter(
		intValue = -290458443
	)
	static int field857;
	@ObfuscatedName("ne")
	@Export("isDraggingWidget")
	static boolean isDraggingWidget;
	@ObfuscatedName("pt")
	@ObfuscatedGetter(
		intValue = -216729541
	)
	@Export("tradeChatMode")
	static int tradeChatMode;
	@ObfuscatedName("mk")
	@ObfuscatedGetter(
		intValue = 904442413
	)
	@Export("runEnergy")
	static int runEnergy;
	@ObfuscatedName("mb")
	@ObfuscatedGetter(
		intValue = -1945437307
	)
	@Export("weight")
	static int weight;
	@ObfuscatedName("pz")
	@ObfuscatedGetter(
		intValue = 1231685339
	)
	@Export("publicChatMode")
	static int publicChatMode;
	@ObfuscatedName("py")
	@ObfuscatedGetter(
		intValue = -1551675657
	)
	@Export("destinationX")
	static int destinationX;
	@ObfuscatedName("pp")
	@ObfuscatedGetter(
		intValue = 799266575
	)
	@Export("destinationY")
	static int destinationY;
	@ObfuscatedName("na")
	@ObfuscatedGetter(
		intValue = 109681511
	)
	static int field819;
	@ObfuscatedName("mc")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("meslayerContinueWidget")
	static Widget meslayerContinueWidget;
	@ObfuscatedName("so")
	@ObfuscatedGetter(
		intValue = 410840719
	)
	static int field733;
	@ObfuscatedName("qa")
	@ObfuscatedGetter(
		intValue = -1271857437
	)
	static int field856;
	@ObfuscatedName("rs")
	@ObfuscatedSignature(
		signature = "Lhy;"
	)
	@Export("playerAppearance")
	static PlayerAppearance playerAppearance;
	@ObfuscatedName("qj")
	@ObfuscatedGetter(
		intValue = 300836983
	)
	static int field860;
	@ObfuscatedName("sv")
	@ObfuscatedGetter(
		intValue = -1054213827
	)
	static int field888;
	@ObfuscatedName("om")
	@ObfuscatedGetter(
		intValue = 963636473
	)
	@Export("mouseWheelRotation")
	static int mouseWheelRotation;
	@ObfuscatedName("mt")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("draggedOnWidget")
	static Widget draggedOnWidget;
	@ObfuscatedName("qr")
	@ObfuscatedGetter(
		intValue = -1057223309
	)
	@Export("soundEffectCount")
	static int soundEffectCount;
	@ObfuscatedName("qn")
	@Export("soundEffectIds")
	static int[] soundEffectIds;
	@ObfuscatedName("qq")
	@Export("queuedSoundEffectLoops")
	static int[] queuedSoundEffectLoops;
	@ObfuscatedName("qx")
	@ObfuscatedGetter(
		intValue = 1818057855
	)
	@Export("minimapState")
	static int minimapState;
	@ObfuscatedName("qm")
	@Export("queuedSoundEffectDelays")
	static int[] queuedSoundEffectDelays;
	@ObfuscatedName("qg")
	@ObfuscatedSignature(
		signature = "[Lca;"
	)
	@Export("soundEffects")
	static SoundEffect[] soundEffects;
	@ObfuscatedName("nh")
	@ObfuscatedGetter(
		intValue = -28645539
	)
	static int field820;
	@ObfuscatedName("qh")
	@Export("soundLocations")
	static int[] soundLocations;
	@ObfuscatedName("si")
	@Export("archiveLoaders")
	static ArrayList archiveLoaders;
	@ObfuscatedName("sp")
	@ObfuscatedGetter(
		intValue = -234202221
	)
	@Export("archiveLoaderArchive")
	static int archiveLoaderArchive;
	@ObfuscatedName("ni")
	static int[] field811;
	@ObfuscatedName("ny")
	@ObfuscatedGetter(
		intValue = 1453639439
	)
	static int field812;
	@ObfuscatedName("pq")
	@ObfuscatedGetter(
		longValue = -7134048785617706275L
	)
	static long field847;
	@ObfuscatedName("rv")
	@ObfuscatedGetter(
		intValue = -1113546575
	)
	@Export("viewportOffsetX")
	static int viewportOffsetX;
	@ObfuscatedName("rt")
	@ObfuscatedGetter(
		intValue = -413974869
	)
	@Export("viewportOffsetY")
	static int viewportOffsetY;
	@ObfuscatedName("rw")
	@ObfuscatedGetter(
		intValue = -784086909
	)
	@Export("viewportWidth")
	static int viewportWidth;
	@ObfuscatedName("rq")
	@ObfuscatedGetter(
		intValue = -1159342953
	)
	@Export("viewportHeight")
	static int viewportHeight;
	@ObfuscatedName("pl")
	@ObfuscatedGetter(
		intValue = -657852683
	)
	static int field651;
	@ObfuscatedName("rl")
	static boolean[] field897;
	@ObfuscatedName("sb")
	@ObfuscatedSignature(
		signature = "[Ld;"
	)
	@Export("grandExchangeOffers")
	static GrandExchangeOffer[] grandExchangeOffers;
	@ObfuscatedName("rk")
	static int[] field869;
	@ObfuscatedName("qu")
	@Export("isCameraLocked")
	static boolean isCameraLocked;
	@ObfuscatedName("rd")
	static int[] field694;
	@ObfuscatedName("rc")
	static int[] field758;
	@ObfuscatedName("ro")
	static int[] field872;
	@ObfuscatedName("nx")
	@ObfuscatedGetter(
		intValue = -1845844437
	)
	static int field818;
	@ObfuscatedName("sa")
	@ObfuscatedSignature(
		signature = "Llw;"
	)
	@Export("platformInfoProvider")
	static PlatformInfoProvider platformInfoProvider;
	@ObfuscatedName("pb")
	@ObfuscatedGetter(
		intValue = 116545085
	)
	@Export("mapIconCount")
	static int mapIconCount;
	@ObfuscatedName("pu")
	@Export("mapIconXs")
	static int[] mapIconXs;
	@ObfuscatedName("px")
	@Export("mapIconYs")
	static int[] mapIconYs;
	@ObfuscatedName("rf")
	static short field873;
	@ObfuscatedName("rx")
	static short field822;
	@ObfuscatedName("ru")
	static short field652;
	@ObfuscatedName("ri")
	static short field791;
	@ObfuscatedName("pc")
	@ObfuscatedSignature(
		signature = "[Lls;"
	)
	@Export("mapIcons")
	static Sprite[] mapIcons;
	@ObfuscatedName("rz")
	static short field661;
	@ObfuscatedName("ry")
	@ObfuscatedGetter(
		intValue = -769323395
	)
	@Export("viewportZoom")
	static int viewportZoom;
	@ObfuscatedName("re")
	static short field795;
	@ObfuscatedName("qd")
	@ObfuscatedGetter(
		intValue = 45254171
	)
	@Export("soundEffectVolume")
	static int soundEffectVolume;
	@ObfuscatedName("np")
	static int[] field809;
	@ObfuscatedName("rg")
	@Export("zoomHeight")
	static short zoomHeight;
	@ObfuscatedName("nt")
	@ObfuscatedGetter(
		intValue = -1478120285
	)
	static int field800;
	@ObfuscatedName("rn")
	@Export("zoomWidth")
	static short zoomWidth;
	@ObfuscatedName("mf")
	@Export("playerMod")
	static boolean playerMod;
	@ObfuscatedName("pg")
	@ObfuscatedGetter(
		intValue = 1836754959
	)
	static int field677;
	@ObfuscatedName("sw")
	@ObfuscatedGetter(
		intValue = -1082381649
	)
	static int field895;
	@ObfuscatedName("nv")
	@ObfuscatedGetter(
		intValue = -884673245
	)
	static int field817;
	@ObfuscatedName("pr")
	static int[] field815;
	@ObfuscatedName("ok")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	static NodeDeque field633;
	@ObfuscatedName("pi")
	static int[] field845;
	@ObfuscatedName("nq")
	@Export("changedSkills")
	static int[] changedSkills;
	@ObfuscatedName("nu")
	@ObfuscatedGetter(
		intValue = -1859324819
	)
	@Export("changedSkillsCount")
	static int changedSkillsCount;
	@ObfuscatedName("od")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	static NodeDeque field824;
	@ObfuscatedName("mr")
	@ObfuscatedGetter(
		intValue = -2146322835
	)
	@Export("chatEffects")
	static int chatEffects;
	@ObfuscatedName("mu")
	@ObfuscatedGetter(
		intValue = 1488851157
	)
	static int field788;
	@ObfuscatedName("ml")
	@ObfuscatedGetter(
		intValue = -764637271
	)
	static int field638;
	@ObfuscatedName("mn")
	@ObfuscatedGetter(
		intValue = 471173501
	)
	static int field786;
	@ObfuscatedName("mg")
	@ObfuscatedGetter(
		intValue = 1069095505
	)
	@Export("followerIndex")
	static int followerIndex;
	@ObfuscatedName("pv")
	static long[] field842;
	@ObfuscatedName("pj")
	static int[] field643;
	@ObfuscatedName("pm")
	@ObfuscatedGetter(
		intValue = 1799961229
	)
	static int field843;
	@ObfuscatedName("pd")
	static String field668;
	@ObfuscatedName("sh")
	@ObfuscatedSignature(
		signature = "Lbr;"
	)
	@Export("GrandExchangeEvents_worldComparator")
	static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
	@ObfuscatedName("nb")
	@ObfuscatedGetter(
		intValue = 887611573
	)
	@Export("chatCycle")
	static int chatCycle;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "[Lfm;"
	)
	@Export("collisionMaps")
	static CollisionMap[] collisionMaps;
	@ObfuscatedName("ae")
	static boolean field783;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = -99475413
	)
	@Export("worldId")
	public static int worldId;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = -196512875
	)
	@Export("worldProperties")
	static int worldProperties;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = -507352025
	)
	@Export("gameBuild")
	static int gameBuild;
	@ObfuscatedName("bh")
	@Export("isMembersWorld")
	public static boolean isMembersWorld;
	@ObfuscatedName("bv")
	@Export("isLowDetail")
	static boolean isLowDetail;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = 580705437
	)
	@Export("clientType")
	static int clientType;
	@ObfuscatedName("bf")
	@Export("onMobile")
	static boolean onMobile;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = 600567601
	)
	@Export("gameState")
	static int gameState;
	@ObfuscatedName("cw")
	@Export("isLoading")
	static boolean isLoading;
	@ObfuscatedName("cj")
	@ObfuscatedGetter(
		intValue = -462561221
	)
	@Export("cycle")
	static int cycle;
	@ObfuscatedName("cp")
	@ObfuscatedGetter(
		longValue = -3264456649992457541L
	)
	@Export("mouseLastLastPressedTimeMillis")
	static long mouseLastLastPressedTimeMillis;
	@ObfuscatedName("cm")
	@ObfuscatedGetter(
		intValue = 1567709733
	)
	static int field838;
	@ObfuscatedName("cb")
	@ObfuscatedGetter(
		intValue = 519692055
	)
	static int field637;
	@ObfuscatedName("ch")
	@ObfuscatedGetter(
		longValue = -2755527832911265383L
	)
	static long field889;
	@ObfuscatedName("cn")
	@Export("hadFocus")
	static boolean hadFocus;
	@ObfuscatedName("cr")
	@Export("displayFps")
	static boolean displayFps;
	@ObfuscatedName("cl")
	@ObfuscatedGetter(
		intValue = 275974395
	)
	@Export("rebootTimer")
	static int rebootTimer;
	@ObfuscatedName("cg")
	@ObfuscatedGetter(
		intValue = -271547777
	)
	@Export("hintArrowType")
	static int hintArrowType;
	@ObfuscatedName("cy")
	@ObfuscatedGetter(
		intValue = -262489269
	)
	@Export("hintArrowNpcIndex")
	static int hintArrowNpcIndex;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = 1310447751
	)
	@Export("hintArrowPlayerIndex")
	static int hintArrowPlayerIndex;
	@ObfuscatedName("cv")
	@ObfuscatedGetter(
		intValue = -1091650667
	)
	@Export("hintArrowX")
	static int hintArrowX;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = -133934205
	)
	@Export("hintArrowY")
	static int hintArrowY;
	@ObfuscatedName("ct")
	@ObfuscatedGetter(
		intValue = -709011140
	)
	@Export("hintArrowHeight")
	static int hintArrowHeight;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = 154264000
	)
	@Export("hintArrowSubX")
	static int hintArrowSubX;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		intValue = -2027343753
	)
	@Export("hintArrowSubY")
	static int hintArrowSubY;
	@ObfuscatedName("co")
	@ObfuscatedSignature(
		signature = "Lcw;"
	)
	@Export("playerAttackOption")
	static AttackOption playerAttackOption;
	@ObfuscatedName("dr")
	@ObfuscatedSignature(
		signature = "Lcw;"
	)
	@Export("npcAttackOption")
	static AttackOption npcAttackOption;
	@ObfuscatedName("dv")
	@ObfuscatedGetter(
		intValue = -2076451089
	)
	@Export("titleLoadingStage")
	static int titleLoadingStage;
	@ObfuscatedName("dh")
	@ObfuscatedSignature(
		signature = "Lkg;"
	)
	@Export("js5Socket")
	static AbstractSocket js5Socket;
	@ObfuscatedName("dm")
	@ObfuscatedGetter(
		intValue = 80587017
	)
	@Export("js5ConnectState")
	static int js5ConnectState;
	@ObfuscatedName("dj")
	@ObfuscatedGetter(
		intValue = -1829390107
	)
	static int field681;
	@ObfuscatedName("db")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive0")
	static Archive archive0;
	@ObfuscatedName("ex")
	@ObfuscatedGetter(
		intValue = -353333359
	)
	@Export("js5Errors")
	static int js5Errors;
	@ObfuscatedName("em")
	@ObfuscatedGetter(
		intValue = 1287215825
	)
	@Export("loginState")
	static int loginState;
	@ObfuscatedName("en")
	@ObfuscatedGetter(
		intValue = -611023551
	)
	static int field658;
	@ObfuscatedName("ey")
	@ObfuscatedGetter(
		intValue = 1589887601
	)
	static int field659;
	@ObfuscatedName("ei")
	@ObfuscatedGetter(
		intValue = -95830179
	)
	static int field660;
	@ObfuscatedName("ee")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	static class160 field870;
	@ObfuscatedName("ek")
	@Export("Login_isUsernameRemembered")
	static boolean Login_isUsernameRemembered;
	@ObfuscatedName("et")
	@ObfuscatedSignature(
		signature = "Lcm;"
	)
	@Export("secureRandomFuture")
	static SecureRandomFuture secureRandomFuture;
	@ObfuscatedName("ez")
	@Export("randomDatData")
	static byte[] randomDatData;
	@ObfuscatedName("ew")
	@ObfuscatedSignature(
		signature = "[Lci;"
	)
	@Export("npcs")
	static NPC[] npcs;
	@ObfuscatedName("ev")
	@ObfuscatedGetter(
		intValue = 134647317
	)
	@Export("npcCount")
	static int npcCount;
	@ObfuscatedName("fz")
	@Export("npcIndices")
	static int[] npcIndices;
	@ObfuscatedName("fd")
	@ObfuscatedGetter(
		intValue = 1857623211
	)
	static int field861;
	@ObfuscatedName("fi")
	static int[] field669;
	@ObfuscatedName("fc")
	@ObfuscatedSignature(
		signature = "Lcy;"
	)
	@Export("packetWriter")
	public static final PacketWriter packetWriter;
	@ObfuscatedName("fy")
	@ObfuscatedGetter(
		intValue = 664871625
	)
	@Export("logoutTimer")
	static int logoutTimer;
	@ObfuscatedName("fg")
	static boolean field672;
	@ObfuscatedName("ft")
	@Export("useBufferedSocket")
	static boolean useBufferedSocket;
	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("timer")
	static Timer timer;
	@ObfuscatedName("fm")
	@Export("fontsMap")
	static HashMap fontsMap;
	@ObfuscatedName("fr")
	@ObfuscatedGetter(
		intValue = -899956101
	)
	static int field676;
	@ObfuscatedName("fb")
	@ObfuscatedGetter(
		intValue = -736504201
	)
	static int field886;
	@ObfuscatedName("fw")
	@ObfuscatedGetter(
		intValue = -1345680285
	)
	static int field678;
	@ObfuscatedName("gj")
	@ObfuscatedGetter(
		intValue = 2003337393
	)
	static int field718;
	@ObfuscatedName("gv")
	@ObfuscatedGetter(
		intValue = 417524189
	)
	static int field719;
	@ObfuscatedName("gr")
	@Export("isInInstance")
	static boolean isInInstance;
	@ObfuscatedName("gm")
	@Export("instanceChunkTemplates")
	static int[][][] instanceChunkTemplates;
	@ObfuscatedName("gu")
	static final int[] field665;
	@ObfuscatedName("gf")
	@ObfuscatedGetter(
		intValue = -1005084219
	)
	static int field879;
	@ObfuscatedName("hc")
	@ObfuscatedGetter(
		intValue = 676975455
	)
	static int field702;
	@ObfuscatedName("hr")
	@ObfuscatedGetter(
		intValue = 1917879357
	)
	static int field687;
	@ObfuscatedName("he")
	@ObfuscatedGetter(
		intValue = 1550854211
	)
	static int field688;
	@ObfuscatedName("hg")
	@ObfuscatedGetter(
		intValue = -1131531425
	)
	static int field689;
	@ObfuscatedName("hi")
	static boolean field725;
	@ObfuscatedName("hd")
	@ObfuscatedGetter(
		intValue = -240458459
	)
	@Export("alternativeScrollbarWidth")
	static int alternativeScrollbarWidth;
	@ObfuscatedName("hx")
	@ObfuscatedGetter(
		intValue = 933386243
	)
	@Export("camAngleX")
	static int camAngleX;
	@ObfuscatedName("hm")
	@ObfuscatedGetter(
		intValue = -1970714441
	)
	@Export("camAngleY")
	static int camAngleY;
	@ObfuscatedName("hq")
	@ObfuscatedGetter(
		intValue = -1869718523
	)
	@Export("camAngleDY")
	static int camAngleDY;
	@ObfuscatedName("ht")
	@ObfuscatedGetter(
		intValue = 1514258351
	)
	@Export("camAngleDX")
	static int camAngleDX;
	@ObfuscatedName("ho")
	@ObfuscatedGetter(
		intValue = -515756443
	)
	@Export("mouseCamClickedX")
	static int mouseCamClickedX;
	@ObfuscatedName("hf")
	@ObfuscatedGetter(
		intValue = 1600800987
	)
	@Export("mouseCamClickedY")
	static int mouseCamClickedY;
	@ObfuscatedName("hu")
	@ObfuscatedGetter(
		intValue = -123122863
	)
	@Export("oculusOrbState")
	static int oculusOrbState;
	@ObfuscatedName("hh")
	@ObfuscatedGetter(
		intValue = 1491883569
	)
	@Export("camFollowHeight")
	static int camFollowHeight;
	@ObfuscatedName("hl")
	@ObfuscatedGetter(
		intValue = 189377225
	)
	static int field700;
	@ObfuscatedName("hz")
	@ObfuscatedGetter(
		intValue = -407641659
	)
	static int field701;
	@ObfuscatedName("iw")
	@ObfuscatedGetter(
		intValue = 1308112361
	)
	static int field680;
	@ObfuscatedName("iy")
	@ObfuscatedGetter(
		intValue = -259522237
	)
	@Export("oculusOrbNormalSpeed")
	static int oculusOrbNormalSpeed;
	@ObfuscatedName("ic")
	@ObfuscatedGetter(
		intValue = -117213855
	)
	@Export("oculusOrbSlowedSpeed")
	static int oculusOrbSlowedSpeed;
	@ObfuscatedName("ia")
	@ObfuscatedGetter(
		intValue = 1865864529
	)
	static int field705;
	@ObfuscatedName("in")
	static boolean field706;
	@ObfuscatedName("iq")
	@ObfuscatedGetter(
		intValue = 1190550561
	)
	static int field712;
	@ObfuscatedName("ip")
	static boolean field708;
	@ObfuscatedName("il")
	@ObfuscatedGetter(
		intValue = -1101305947
	)
	static int field635;
	@ObfuscatedName("ie")
	@ObfuscatedGetter(
		intValue = -589346943
	)
	@Export("overheadTextCount")
	static int overheadTextCount;
	@ObfuscatedName("if")
	@ObfuscatedGetter(
		intValue = -1255115843
	)
	@Export("overheadTextLimit")
	static int overheadTextLimit;
	@ObfuscatedName("ig")
	@Export("overheadTextXs")
	static int[] overheadTextXs;
	@ObfuscatedName("it")
	@Export("selectedItemName")
	static String selectedItemName;
	@ObfuscatedName("im")
	@Export("overheadTextYs")
	static int[] overheadTextYs;
	@ObfuscatedName("is")
	@Export("overheadTextAscents")
	static int[] overheadTextAscents;
	@ObfuscatedName("ir")
	@Export("overheadTextXOffsets")
	static int[] overheadTextXOffsets;
	@ObfuscatedName("io")
	@Export("overheadTextColors")
	static int[] overheadTextColors;
	@ObfuscatedName("ik")
	@Export("overheadTextEffects")
	static int[] overheadTextEffects;
	@ObfuscatedName("iu")
	@Export("overheadTextCyclesRemaining")
	static int[] overheadTextCyclesRemaining;
	@ObfuscatedName("ib")
	@Export("overheadText")
	static String[] overheadText;
	@ObfuscatedName("ii")
	@Export("tileLastDrawnActor")
	static int[][] tileLastDrawnActor;
	@ObfuscatedName("iv")
	@ObfuscatedGetter(
		intValue = -573447391
	)
	@Export("viewportDrawCount")
	static int viewportDrawCount;
	@ObfuscatedName("ij")
	@ObfuscatedGetter(
		intValue = 257969471
	)
	@Export("viewportTempX")
	static int viewportTempX;
	@ObfuscatedName("ih")
	@ObfuscatedGetter(
		intValue = -983509355
	)
	@Export("viewportTempY")
	static int viewportTempY;
	@ObfuscatedName("jp")
	@ObfuscatedGetter(
		intValue = 2019424665
	)
	@Export("mouseCrossX")
	static int mouseCrossX;
	@ObfuscatedName("jc")
	@ObfuscatedGetter(
		intValue = -1900152601
	)
	@Export("mouseCrossY")
	static int mouseCrossY;
	@ObfuscatedName("jf")
	@ObfuscatedGetter(
		intValue = -579281601
	)
	@Export("mouseCrossState")
	static int mouseCrossState;
	@ObfuscatedName("jz")
	@ObfuscatedGetter(
		intValue = 1535156455
	)
	@Export("mouseCrossColor")
	static int mouseCrossColor;
	@ObfuscatedName("jn")
	@Export("showMouseCross")
	static boolean showMouseCross;
	@ObfuscatedName("jh")
	@ObfuscatedGetter(
		intValue = 121716981
	)
	static int field729;
	@ObfuscatedName("jq")
	@ObfuscatedGetter(
		intValue = -236430235
	)
	static int field730;
	@ObfuscatedName("ji")
	@ObfuscatedGetter(
		intValue = 2086457457
	)
	@Export("dragItemSlotSource")
	static int dragItemSlotSource;
	@ObfuscatedName("jd")
	@ObfuscatedGetter(
		intValue = 1027711881
	)
	static int field732;
	@ObfuscatedName("jr")
	@ObfuscatedGetter(
		intValue = 879520429
	)
	static int field744;
	@ObfuscatedName("ju")
	@ObfuscatedGetter(
		intValue = 505726403
	)
	@Export("dragItemSlotDestination")
	static int dragItemSlotDestination;
	@ObfuscatedName("je")
	static boolean field867;
	@ObfuscatedName("jk")
	@ObfuscatedGetter(
		intValue = 952757877
	)
	@Export("itemDragDuration")
	static int itemDragDuration;
	@ObfuscatedName("jw")
	@ObfuscatedGetter(
		intValue = 1710791043
	)
	static int field737;
	@ObfuscatedName("jt")
	@Export("showLoadingMessages")
	static boolean showLoadingMessages;
	@ObfuscatedName("jj")
	@ObfuscatedSignature(
		signature = "[Lbd;"
	)
	@Export("players")
	static Player[] players;
	@ObfuscatedName("jx")
	@ObfuscatedGetter(
		intValue = 108652351
	)
	@Export("localPlayerIndex")
	static int localPlayerIndex;
	@ObfuscatedName("ja")
	@ObfuscatedGetter(
		intValue = -534802235
	)
	static int field741;
	@ObfuscatedName("jv")
	@Export("renderSelf")
	static boolean renderSelf;
	@ObfuscatedName("kq")
	@ObfuscatedGetter(
		intValue = -1853655733
	)
	@Export("drawPlayerNames")
	static int drawPlayerNames;
	@ObfuscatedName("kz")
	@ObfuscatedGetter(
		intValue = 935391775
	)
	static int field899;
	@ObfuscatedName("kr")
	static int[] field655;
	@ObfuscatedName("kb")
	@Export("playerMenuOpcodes")
	static final int[] playerMenuOpcodes;
	@ObfuscatedName("kl")
	@Export("playerMenuActions")
	static String[] playerMenuActions;
	@ObfuscatedName("kn")
	@Export("playerOptionsPriorities")
	static boolean[] playerOptionsPriorities;
	@ObfuscatedName("ke")
	@Export("defaultRotations")
	static int[] defaultRotations;
	@ObfuscatedName("kx")
	@ObfuscatedGetter(
		intValue = -1785392333
	)
	@Export("combatTargetPlayerIndex")
	static int combatTargetPlayerIndex;
	@ObfuscatedName("ky")
	@ObfuscatedSignature(
		signature = "[[[Ljc;"
	)
	@Export("groundItems")
	static NodeDeque[][][] groundItems;
	@ObfuscatedName("kd")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	@Export("pendingSpawns")
	static NodeDeque pendingSpawns;
	@ObfuscatedName("km")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	@Export("projectiles")
	static NodeDeque projectiles;
	@ObfuscatedName("kw")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	@Export("graphicsObjects")
	static NodeDeque graphicsObjects;
	@ObfuscatedName("ku")
	@Export("currentLevels")
	static int[] currentLevels;
	@ObfuscatedName("kg")
	@Export("levels")
	static int[] levels;
	@ObfuscatedName("ko")
	@Export("experience")
	static int[] experience;
	@ObfuscatedName("ki")
	@ObfuscatedGetter(
		intValue = 280970801
	)
	@Export("leftClickOpensMenu")
	static int leftClickOpensMenu;
	@ObfuscatedName("kv")
	@Export("isMenuOpen")
	static boolean isMenuOpen;
	@ObfuscatedName("lf")
	@ObfuscatedGetter(
		intValue = 670271749
	)
	@Export("menuOptionsCount")
	static int menuOptionsCount;
	@ObfuscatedName("li")
	@Export("menuArguments1")
	static int[] menuArguments1;
	@ObfuscatedName("ln")
	@Export("menuArguments2")
	static int[] menuArguments2;
	@ObfuscatedName("lo")
	@Export("menuOpcodes")
	static int[] menuOpcodes;
	@ObfuscatedName("lm")
	@Export("menuIdentifiers")
	static int[] menuIdentifiers;
	@ObfuscatedName("lh")
	@Export("menuActions")
	static String[] menuActions;
	@ObfuscatedName("lp")
	@Export("menuTargets")
	static String[] menuTargets;
	@ObfuscatedName("lj")
	@Export("menuShiftClick")
	static boolean[] menuShiftClick;
	@ObfuscatedName("lg")
	@Export("followerOpsLowPriority")
	static boolean followerOpsLowPriority;
	@ObfuscatedName("lq")
	@Export("shiftClickDrop")
	static boolean shiftClickDrop;
	@ObfuscatedName("ls")
	@Export("tapToDrop")
	static boolean tapToDrop;
	@ObfuscatedName("ld")
	@Export("showMouseOverText")
	static boolean showMouseOverText;
	@ObfuscatedName("lt")
	@ObfuscatedGetter(
		intValue = -519368399
	)
	@Export("viewportX")
	static int viewportX;
	@ObfuscatedName("le")
	@ObfuscatedGetter(
		intValue = 731762713
	)
	@Export("viewportY")
	static int viewportY;
	@ObfuscatedName("la")
	@ObfuscatedGetter(
		intValue = -296280915
	)
	static int field774;
	@ObfuscatedName("lv")
	@ObfuscatedGetter(
		intValue = 904105341
	)
	static int field848;
	@ObfuscatedName("lc")
	@ObfuscatedGetter(
		intValue = 474967141
	)
	@Export("isItemSelected")
	static int isItemSelected;
	@ObfuscatedName("ll")
	@Export("isSpellSelected")
	static boolean isSpellSelected;
	@ObfuscatedName("lu")
	@ObfuscatedGetter(
		intValue = -636405785
	)
	static int field816;
	@ObfuscatedName("mj")
	@ObfuscatedGetter(
		intValue = 1298304865
	)
	static int field736;
	@ObfuscatedName("mv")
	@Export("selectedSpellActionName")
	static String selectedSpellActionName;
	@ObfuscatedName("mw")
	@Export("selectedSpellName")
	static String selectedSpellName;
	@ObfuscatedName("mm")
	@ObfuscatedGetter(
		intValue = 452430417
	)
	@Export("rootInterface")
	static int rootInterface;

	static {
		field783 = true;
		worldId = 1;
		worldProperties = 0;
		gameBuild = 0;
		isMembersWorld = false;
		isLowDetail = false;
		clientType = -1;
		onMobile = false;
		gameState = 0;
		isLoading = true;
		cycle = 0;
		mouseLastLastPressedTimeMillis = 1L;
		field838 = -1;
		field637 = -1;
		field889 = -1L;
		hadFocus = true;
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
		field681 = 0;
		js5Errors = 0;
		loginState = 0;
		field658 = 0;
		field659 = 0;
		field660 = 0;
		field870 = class160.field1984;
		Login_isUsernameRemembered = false;
		secureRandomFuture = new SecureRandomFuture();
		randomDatData = null;
		npcs = new NPC[32768];
		npcCount = 0;
		npcIndices = new int[32768];
		field861 = 0;
		field669 = new int[250];
		packetWriter = new PacketWriter();
		logoutTimer = 0;
		field672 = false;
		useBufferedSocket = true;
		timer = new Timer();
		fontsMap = new HashMap();
		field676 = 0;
		field886 = 1;
		field678 = 0;
		field718 = 1;
		field719 = 0;
		collisionMaps = new CollisionMap[4];
		isInInstance = false;
		instanceChunkTemplates = new int[4][13][13];
		field665 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
		field879 = 0;
		field702 = 2301979;
		field687 = 5063219;
		field688 = 3353893;
		field689 = 7759444;
		field725 = false;
		alternativeScrollbarWidth = 0;
		camAngleX = 128;
		camAngleY = 0;
		camAngleDY = 0;
		camAngleDX = 0;
		mouseCamClickedX = 0;
		mouseCamClickedY = 0;
		oculusOrbState = 0;
		camFollowHeight = 50;
		field700 = 0;
		field701 = 0;
		field680 = 0;
		oculusOrbNormalSpeed = 12;
		oculusOrbSlowedSpeed = 6;
		field705 = 0;
		field706 = false;
		field712 = 0;
		field708 = false;
		field635 = 0;
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
		field729 = 0;
		field730 = 0;
		dragItemSlotSource = 0;
		field732 = 0;
		field744 = 0;
		dragItemSlotDestination = 0;
		field867 = false;
		itemDragDuration = 0;
		field737 = 0;
		showLoadingMessages = true;
		players = new Player[2048];
		localPlayerIndex = -1;
		field741 = 0;
		renderSelf = true;
		drawPlayerNames = 0;
		field899 = 0;
		field655 = new int[1000];
		playerMenuOpcodes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
		playerMenuActions = new String[8];
		playerOptionsPriorities = new boolean[8];
		defaultRotations = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
		combatTargetPlayerIndex = -1;
		groundItems = new NodeDeque[4][104][104];
		pendingSpawns = new NodeDeque();
		projectiles = new NodeDeque();
		graphicsObjects = new NodeDeque();
		currentLevels = new int[25];
		levels = new int[25];
		experience = new int[25];
		leftClickOpensMenu = 0;
		isMenuOpen = false;
		menuOptionsCount = 0;
		menuArguments1 = new int[500];
		menuArguments2 = new int[500];
		menuOpcodes = new int[500];
		menuIdentifiers = new int[500];
		menuActions = new String[500];
		menuTargets = new String[500];
		menuShiftClick = new boolean[500];
		followerOpsLowPriority = false;
		shiftClickDrop = false;
		tapToDrop = false;
		showMouseOverText = true;
		viewportX = -1;
		viewportY = -1;
		field774 = 0;
		field848 = 50;
		isItemSelected = 0;
		selectedItemName = null;
		isSpellSelected = false;
		field816 = -1;
		field736 = -1;
		selectedSpellActionName = null;
		selectedSpellName = null;
		rootInterface = -1;
		interfaceParents = new NodeHashTable(8);
		field638 = 0;
		field786 = -1;
		chatEffects = 0;
		field788 = 0;
		meslayerContinueWidget = null;
		runEnergy = 0;
		weight = 0;
		staffModLevel = 0;
		followerIndex = -1;
		playerMod = false;
		viewportWidget = null;
		clickedWidget = null;
		clickedWidgetParent = null;
		widgetClickX = 0;
		widgetClickY = 0;
		draggedOnWidget = null;
		field641 = false;
		field802 = -1;
		field803 = -1;
		field804 = false;
		field805 = -1;
		field806 = -1;
		isDraggingWidget = false;
		cycleCntr = 1;
		field809 = new int[32];
		field800 = 0;
		field811 = new int[32];
		field812 = 0;
		changedSkills = new int[32];
		changedSkillsCount = 0;
		chatCycle = 0;
		field629 = 0;
		field817 = 0;
		field818 = 0;
		field819 = 0;
		field820 = 0;
		mouseWheelRotation = 0;
		scriptEvents = new NodeDeque();
		field633 = new NodeDeque();
		field824 = new NodeDeque();
		widgetClickMasks = new NodeHashTable(512);
		rootWidgetCount = 0;
		field752 = -2;
		field703 = new boolean[100];
		field829 = new boolean[100];
		field830 = new boolean[100];
		rootWidgetXs = new int[100];
		rootWidgetYs = new int[100];
		rootWidgetWidths = new int[100];
		rootWidgetHeights = new int[100];
		gameDrawingMode = 0;
		field836 = 0L;
		isResizable = true;
		field643 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
		publicChatMode = 0;
		tradeChatMode = 0;
		field668 = "";
		field842 = new long[100];
		field843 = 0;
		field677 = 0;
		field845 = new int[128];
		field815 = new int[128];
		field847 = -1L;
		field651 = -1;
		mapIconCount = 0;
		mapIconXs = new int[1000];
		mapIconYs = new int[1000];
		mapIcons = new Sprite[1000];
		destinationX = 0;
		destinationY = 0;
		minimapState = 0;
		field856 = 255;
		field857 = -1;
		field858 = false;
		soundEffectVolume = 127;
		field860 = 127;
		soundEffectCount = 0;
		soundEffectIds = new int[50];
		queuedSoundEffectLoops = new int[50];
		queuedSoundEffectDelays = new int[50];
		soundLocations = new int[50];
		soundEffects = new SoundEffect[50];
		isCameraLocked = false;
		field897 = new boolean[5];
		field869 = new int[5];
		field694 = new int[5];
		field758 = new int[5];
		field872 = new int[5];
		field873 = 256;
		field822 = 205;
		zoomHeight = 256;
		zoomWidth = 320;
		field795 = 1;
		field661 = 32767;
		field652 = 1;
		field791 = 32767;
		viewportOffsetX = 0;
		viewportOffsetY = 0;
		viewportWidth = 0;
		viewportHeight = 0;
		viewportZoom = 0;
		playerAppearance = new PlayerAppearance();
		field733 = -1;
		field888 = -1;
		platformInfoProvider = new DesktopPlatformInfoProvider();
		grandExchangeOffers = new GrandExchangeOffer[8];
		GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
		field892 = -1;
		archiveLoaders = new ArrayList(10);
		archiveLoaderArchive = 0;
		field895 = 0;
		field684 = new class65();
		field697 = new int[50];
		field898 = new int[50];
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1917236425"
	)
	@Export("resizeGame")
	protected final void resizeGame() {
		field836 = SequenceDefinition.method4686() + 500L;
		this.resizeJS();
		if (rootInterface != -1) {
			this.resizeRoot(true);
		}

	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1264140224"
	)
	@Export("setUp")
	protected final void setUp() {
		int[] var1 = new int[]{20, 260, 10000};
		int[] var2 = new int[]{1000, 100, 500};
		if (var1 != null && var2 != null) {
			UserComparator4.ByteArrayPool_alternativeSizes = var1;
			ByteArrayPool.ByteArrayPool_altSizeArrayCounts = new int[var1.length];
			FaceNormal.ByteArrayPool_arrays = new byte[var1.length][][];

			for (int var3 = 0; var3 < UserComparator4.ByteArrayPool_alternativeSizes.length; ++var3) {
				FaceNormal.ByteArrayPool_arrays[var3] = new byte[var2[var3]][];
			}
		} else {
			UserComparator4.ByteArrayPool_alternativeSizes = null;
			ByteArrayPool.ByteArrayPool_altSizeArrayCounts = null;
			FaceNormal.ByteArrayPool_arrays = null;
		}

		WorldMapRectangle.port1 = gameBuild == 0 ? 43594 : worldId + 40000;
		FloorDecoration.port2 = gameBuild == 0 ? 443 : worldId + 50000;
		SecureRandomCallable.port3 = WorldMapRectangle.port1;
		KeyHandler.field387 = class215.field2529;
		FontName.field3651 = class215.field2531;
		PlayerAppearance.field2523 = class215.field2528;
		SoundCache.field1418 = class215.field2527;
		ScriptEvent.urlRequester = new UrlRequester();
		this.setUpKeyboard();
		this.setUpMouse();
		Canvas.mouseWheel = this.mouseWheel();
		class293.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		AccessFile var4 = null;
		ClientPreferences var5 = new ClientPreferences();

		try {
			var4 = TaskHandler.getPreferencesFile("", WorldMapRectangle.field166.name, false);
			byte[] var6 = new byte[(int)var4.length()];

			int var8;
			for (int var7 = 0; var7 < var6.length; var7 += var8) {
				var8 = var4.read(var6, var7, var6.length - var7);
				if (var8 == -1) {
					throw new IOException();
				}
			}

			var5 = new ClientPreferences(new Buffer(var6));
		} catch (Exception var11) {
		}

		try {
			if (var4 != null) {
				var4.close();
			}
		} catch (Exception var10) {
		}

		GrandExchangeOffer.clientPreferences = var5;
		this.setUpClipboard();
		Player.method1223(this, class4.null_string);
		if (gameBuild != 0) {
			displayFps = true;
		}

		StudioGame.setWindowedMode(GrandExchangeOffer.clientPreferences.windowMode);
		class32.friendSystem = new FriendSystem(FontName.loginType);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "712398470"
	)
	@Export("doCycle")
	protected final void doCycle() {
		++cycle;
		this.doCycleJs5();
		class32.method543();

		int var1;
		try {
			if (class197.field2378 == 1) {
				var1 = class197.midiPcmStream.method3648();
				if (var1 > 0 && class197.midiPcmStream.isReady()) {
					var1 -= class16.field98;
					if (var1 < 0) {
						var1 = 0;
					}

					class197.midiPcmStream.method3670(var1);
				} else {
					class197.midiPcmStream.clear();
					class197.midiPcmStream.removeAll();
					if (WorldMapDecoration.musicTrackArchive != null) {
						class197.field2378 = 2;
					} else {
						class197.field2378 = 0;
					}

					FontName.musicTrack = null;
					class189.soundCache = null;
				}
			}
		} catch (Exception var44) {
			var44.printStackTrace();
			class197.midiPcmStream.clear();
			class197.field2378 = 0;
			FontName.musicTrack = null;
			class189.soundCache = null;
			WorldMapDecoration.musicTrackArchive = null;
		}

		WorldMapSectionType.playPcmPlayers();
		int var2;
		synchronized(KeyHandler.KeyHandler_instance) {
			++KeyHandler.KeyHandler_idleCycles;
			KeyHandler.field385 = KeyHandler.field383;
			KeyHandler.field380 = 0;
			if (KeyHandler.field378 >= 0) {
				while (KeyHandler.field378 != KeyHandler.field375) {
					var2 = KeyHandler.field374[KeyHandler.field375];
					KeyHandler.field375 = KeyHandler.field375 + 1 & 127;
					if (var2 < 0) {
						KeyHandler.KeyHandler_pressedKeys[~var2] = false;
					} else {
						if (!KeyHandler.KeyHandler_pressedKeys[var2] && KeyHandler.field380 < KeyHandler.field379.length - 1) {
							KeyHandler.field379[++KeyHandler.field380 - 1] = var2;
						}

						KeyHandler.KeyHandler_pressedKeys[var2] = true;
					}
				}
			} else {
				for (var2 = 0; var2 < 112; ++var2) {
					KeyHandler.KeyHandler_pressedKeys[var2] = false;
				}

				KeyHandler.field378 = KeyHandler.field375;
			}

			if (KeyHandler.field380 > 0) {
				KeyHandler.KeyHandler_idleCycles = 0;
			}

			KeyHandler.field383 = KeyHandler.field382;
		}

		class192.method3617();
		if (Canvas.mouseWheel != null) {
			var1 = Canvas.mouseWheel.useRotation();
			mouseWheelRotation = var1;
		}

		if (gameState == 0) {
			ItemContainer.load();
			GameShell.clock.mark();

			for (var1 = 0; var1 < 32; ++var1) {
				GameShell.field423[var1] = 0L;
			}

			for (var1 = 0; var1 < 32; ++var1) {
				GameShell.field417[var1] = 0L;
			}

			GameShell.field413 = 0;
		} else if (gameState == 5) {
			WorldMapDecoration.method326(this);
			ItemContainer.load();
			GameShell.clock.mark();

			for (var1 = 0; var1 < 32; ++var1) {
				GameShell.field423[var1] = 0L;
			}

			for (var1 = 0; var1 < 32; ++var1) {
				GameShell.field417[var1] = 0L;
			}

			GameShell.field413 = 0;
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				WorldMapDecoration.method326(this);
				this.doCycleLoggedOut();
			} else if (gameState == 25) {
				KeyHandler.method787(false);
				field676 = 0;
				boolean var46 = true;

				for (var2 = 0; var2 < GraphicsObject.regionLandArchives.length; ++var2) {
					if (MouseHandler.regionMapArchiveIds[var2] != -1 && GraphicsObject.regionLandArchives[var2] == null) {
						GraphicsObject.regionLandArchives[var2] = WorldMapDecoration.archive5.takeFile(MouseHandler.regionMapArchiveIds[var2], 0);
						if (GraphicsObject.regionLandArchives[var2] == null) {
							var46 = false;
							++field676;
						}
					}

					if (ClanChat.regionLandArchiveIds[var2] != -1 && Messages.regionMapArchives[var2] == null) {
						Messages.regionMapArchives[var2] = WorldMapDecoration.archive5.takeFileEncrypted(ClanChat.regionLandArchiveIds[var2], 0, ModelData0.xteaKeys[var2]);
						if (Messages.regionMapArchives[var2] == null) {
							var46 = false;
							++field676;
						}
					}
				}

				if (!var46) {
					field719 = 1;
				} else {
					field678 = 0;
					var46 = true;

					int var4;
					int var5;
					for (var2 = 0; var2 < GraphicsObject.regionLandArchives.length; ++var2) {
						byte[] var3 = Messages.regionMapArchives[var2];
						if (var3 != null) {
							var4 = (class186.regions[var2] >> 8) * 64 - PacketWriter.baseX * 64;
							var5 = (class186.regions[var2] & 255) * 64 - RouteStrategy.baseY * 64;
							if (isInInstance) {
								var4 = 10;
								var5 = 10;
							}

							var46 &= WorldMapSection2.method325(var3, var4, var5);
						}
					}

					if (!var46) {
						field719 = 2;
					} else {
						if (field719 != 0) {
							MusicPatch.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
						}

						WorldMapSectionType.playPcmPlayers();
						Player.scene.clear();

						for (var2 = 0; var2 < 4; ++var2) {
							collisionMaps[var2].clear();
						}

						int var37;
						for (var2 = 0; var2 < 4; ++var2) {
							for (var37 = 0; var37 < 104; ++var37) {
								for (var4 = 0; var4 < 104; ++var4) {
									Tiles.Tiles_renderFlags[var2][var37][var4] = 0;
								}
							}
						}

						WorldMapSectionType.playPcmPlayers();
						Tiles.Tiles_minPlane = 99;
						Tiles.field485 = new byte[4][104][104];
						AccessFile.field4061 = new byte[4][104][104];
						class210.field2492 = new byte[4][104][104];
						Tiles.field475 = new byte[4][104][104];
						Tiles.field483 = new int[4][105][105];
						class188.field2321 = new byte[4][105][105];
						class4.field31 = new int[105][105];
						Tiles.Tiles_hue = new int[104];
						class3.Tiles_saturation = new int[104];
						Buddy.Tiles_lightness = new int[104];
						class49.Tiles_hueMultiplier = new int[104];
						MenuAction.field1129 = new int[104];
						var2 = GraphicsObject.regionLandArchives.length;

						for (ObjectSound var45 = (ObjectSound)ObjectSound.objectSounds.last(); var45 != null; var45 = (ObjectSound)ObjectSound.objectSounds.previous()) {
							if (var45.stream1 != null) {
								IgnoreList.pcmStreamMixer.removeSubStream(var45.stream1);
								var45.stream1 = null;
							}

							if (var45.stream2 != null) {
								IgnoreList.pcmStreamMixer.removeSubStream(var45.stream2);
								var45.stream2 = null;
							}
						}

						ObjectSound.objectSounds.clear();
						KeyHandler.method787(true);
						int var7;
						int var8;
						int var10;
						int var11;
						int var12;
						int var13;
						int var40;
						if (!isInInstance) {
							var37 = 0;

							label587:
							while (true) {
								byte[] var6;
								if (var37 >= var2) {
									for (var37 = 0; var37 < var2; ++var37) {
										var4 = (class186.regions[var37] >> 8) * 64 - PacketWriter.baseX * 64;
										var5 = (class186.regions[var37] & 255) * 64 - RouteStrategy.baseY * 64;
										var6 = GraphicsObject.regionLandArchives[var37];
										if (var6 == null && class16.field101 < 800) {
											WorldMapSectionType.playPcmPlayers();
											class195.method3627(var4, var5, 64, 64);
										}
									}

									KeyHandler.method787(true);
									var37 = 0;

									while (true) {
										if (var37 >= var2) {
											break label587;
										}

										byte[] var39 = Messages.regionMapArchives[var37];
										if (var39 != null) {
											var5 = (class186.regions[var37] >> 8) * 64 - PacketWriter.baseX * 64;
											var40 = (class186.regions[var37] & 255) * 64 - RouteStrategy.baseY * 64;
											WorldMapSectionType.playPcmPlayers();
											WorldMapIcon_0.method203(var39, var5, var40, Player.scene, collisionMaps);
										}

										++var37;
									}
								}

								var4 = (class186.regions[var37] >> 8) * 64 - PacketWriter.baseX * 64;
								var5 = (class186.regions[var37] & 255) * 64 - RouteStrategy.baseY * 64;
								var6 = GraphicsObject.regionLandArchives[var37];
								if (var6 != null) {
									WorldMapSectionType.playPcmPlayers();
									var7 = class13.field86 * 8 - 48;
									var8 = class16.field101 * 8 - 48;
									CollisionMap[] var9 = collisionMaps;
									var10 = 0;

									label584:
									while (true) {
										if (var10 >= 4) {
											Buffer var38 = new Buffer(var6);
											var11 = 0;

											while (true) {
												if (var11 >= 4) {
													break label584;
												}

												for (var12 = 0; var12 < 64; ++var12) {
													for (var13 = 0; var13 < 64; ++var13) {
														class30.loadTerrain(var38, var11, var4 + var12, var5 + var13, var7, var8, 0);
													}
												}

												++var11;
											}
										}

										for (var11 = 0; var11 < 64; ++var11) {
											for (var12 = 0; var12 < 64; ++var12) {
												if (var4 + var11 > 0 && var4 + var11 < 103 && var5 + var12 > 0 && var12 + var5 < 103) {
													int[] var10000 = var9[var10].flags[var4 + var11];
													var10000[var12 + var5] &= -16777217;
												}
											}
										}

										++var10;
									}
								}

								++var37;
							}
						}

						int var41;
						if (isInInstance) {
							var37 = 0;

							label533:
							while (true) {
								if (var37 >= 4) {
									for (var37 = 0; var37 < 13; ++var37) {
										for (var4 = 0; var4 < 13; ++var4) {
											var5 = instanceChunkTemplates[0][var37][var4];
											if (var5 == -1) {
												class195.method3627(var37 * 8, var4 * 8, 8, 8);
											}
										}
									}

									KeyHandler.method787(true);
									var37 = 0;

									while (true) {
										if (var37 >= 4) {
											break label533;
										}

										WorldMapSectionType.playPcmPlayers();

										for (var4 = 0; var4 < 13; ++var4) {
											label490:
											for (var5 = 0; var5 < 13; ++var5) {
												var40 = instanceChunkTemplates[var37][var4][var5];
												if (var40 != -1) {
													var7 = var40 >> 24 & 3;
													var8 = var40 >> 1 & 3;
													var41 = var40 >> 14 & 1023;
													var10 = var40 >> 3 & 2047;
													var11 = (var41 / 8 << 8) + var10 / 8;

													for (var12 = 0; var12 < class186.regions.length; ++var12) {
														if (class186.regions[var12] == var11 && Messages.regionMapArchives[var12] != null) {
															byte[] var42 = Messages.regionMapArchives[var12];
															int var14 = var4 * 8;
															int var15 = var5 * 8;
															int var16 = (var41 & 7) * 8;
															int var17 = (var10 & 7) * 8;
															Scene var18 = Player.scene;
															CollisionMap[] var19 = collisionMaps;
															Buffer var20 = new Buffer(var42);
															int var21 = -1;

															while (true) {
																int var22 = var20.method5565();
																if (var22 == 0) {
																	continue label490;
																}

																var21 += var22;
																int var23 = 0;

																while (true) {
																	int var24 = var20.readUShortSmart();
																	if (var24 == 0) {
																		break;
																	}

																	var23 += var24 - 1;
																	int var25 = var23 & 63;
																	int var26 = var23 >> 6 & 63;
																	int var27 = var23 >> 12;
																	int var28 = var20.readUnsignedByte();
																	int var29 = var28 >> 2;
																	int var30 = var28 & 3;
																	if (var27 == var7 && var26 >= var16 && var26 < var16 + 8 && var25 >= var17 && var25 < var17 + 8) {
																		ObjectDefinition var31 = class215.getObjectDefinition(var21);
																		int var32 = var14 + UserComparator5.method3366(var26 & 7, var25 & 7, var8, var31.sizeX, var31.sizeY, var30);
																		int var33 = var15 + PlayerAppearance.method3944(var26 & 7, var25 & 7, var8, var31.sizeX, var31.sizeY, var30);
																		if (var32 > 0 && var33 > 0 && var32 < 103 && var33 < 103) {
																			int var34 = var37;
																			if ((Tiles.Tiles_renderFlags[1][var32][var33] & 2) == 2) {
																				var34 = var37 - 1;
																			}

																			CollisionMap var35 = null;
																			if (var34 >= 0) {
																				var35 = var19[var34];
																			}

																			class32.method544(var37, var32, var33, var21, var8 + var30 & 3, var29, var18, var35);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}

										++var37;
									}
								}

								WorldMapSectionType.playPcmPlayers();

								for (var4 = 0; var4 < 13; ++var4) {
									for (var5 = 0; var5 < 13; ++var5) {
										boolean var48 = false;
										var7 = instanceChunkTemplates[var37][var4][var5];
										if (var7 != -1) {
											var8 = var7 >> 24 & 3;
											var41 = var7 >> 1 & 3;
											var10 = var7 >> 14 & 1023;
											var11 = var7 >> 3 & 2047;
											var12 = (var10 / 8 << 8) + var11 / 8;

											for (var13 = 0; var13 < class186.regions.length; ++var13) {
												if (class186.regions[var13] == var12 && GraphicsObject.regionLandArchives[var13] != null) {
													class269.method4894(GraphicsObject.regionLandArchives[var13], var37, var4 * 8, var5 * 8, var8, (var10 & 7) * 8, (var11 & 7) * 8, var41, collisionMaps);
													var48 = true;
													break;
												}
											}
										}

										if (!var48) {
											class312.method5787(var37, var4 * 8, var5 * 8);
										}
									}
								}

								++var37;
							}
						}

						KeyHandler.method787(true);
						WorldMapSectionType.playPcmPlayers();
						GrandExchangeOfferTotalQuantityComparator.method98(Player.scene, collisionMaps);
						KeyHandler.method787(true);
						var37 = Tiles.Tiles_minPlane;
						if (var37 > ItemContainer.plane) {
							var37 = ItemContainer.plane;
						}

						if (var37 < ItemContainer.plane - 1) {
							var37 = ItemContainer.plane - 1;
						}

						if (isLowDetail) {
							Player.scene.init(Tiles.Tiles_minPlane);
						} else {
							Player.scene.init(0);
						}

						for (var4 = 0; var4 < 104; ++var4) {
							for (var5 = 0; var5 < 104; ++var5) {
								class189.updateItemPile(var4, var5);
							}
						}

						WorldMapSectionType.playPcmPlayers();
						ChatChannel.method2161();
						ObjectDefinition.ObjectDefinition_cachedModelData.clear();
						PacketBufferNode var47;
						if (WorldMapID.client.hasFrame()) {
							var47 = MenuAction.getPacketBufferNode(ClientPacket.field2189, packetWriter.isaacCipher);
							var47.packetBuffer.writeInt(1057001181);
							packetWriter.addNode(var47);
						}

						if (!isInInstance) {
							var4 = (class13.field86 - 6) / 8;
							var5 = (class13.field86 + 6) / 8;
							var40 = (class16.field101 - 6) / 8;
							var7 = (class16.field101 + 6) / 8;

							for (var8 = var4 - 1; var8 <= var5 + 1; ++var8) {
								for (var41 = var40 - 1; var41 <= var7 + 1; ++var41) {
									if (var8 < var4 || var8 > var5 || var41 < var40 || var41 > var7) {
										WorldMapDecoration.archive5.loadRegionFromName("m" + var8 + "_" + var41);
										WorldMapDecoration.archive5.loadRegionFromName("l" + var8 + "_" + var41);
									}
								}
							}
						}

						FloorDecoration.updateGameState(30);
						WorldMapSectionType.playPcmPlayers();
						Tiles.field485 = null;
						AccessFile.field4061 = null;
						class210.field2492 = null;
						Tiles.field475 = null;
						Tiles.field483 = null;
						class188.field2321 = null;
						class4.field31 = null;
						Tiles.Tiles_hue = null;
						class3.Tiles_saturation = null;
						Buddy.Tiles_lightness = null;
						class49.Tiles_hueMultiplier = null;
						MenuAction.field1129 = null;
						var47 = MenuAction.getPacketBufferNode(ClientPacket.field2261, packetWriter.isaacCipher);
						packetWriter.addNode(var47);
						GameShell.clock.mark();

						for (var5 = 0; var5 < 32; ++var5) {
							GameShell.field423[var5] = 0L;
						}

						for (var5 = 0; var5 < 32; ++var5) {
							GameShell.field417[var5] = 0L;
						}

						GameShell.field413 = 0;
					}
				}
			}
		} else {
			WorldMapDecoration.method326(this);
		}

		if (gameState == 30) {
			this.doCycleLoggedIn();
		} else if (gameState == 40 || gameState == 45) {
			this.doCycleLoggedOut();
		}

	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "2115085971"
	)
	@Export("draw")
	protected final void draw(boolean var1) {
		boolean var2;
		label173: {
			try {
				if (class197.field2378 == 2) {
					if (FontName.musicTrack == null) {
						FontName.musicTrack = MusicTrack.readTrack(WorldMapDecoration.musicTrackArchive, class197.musicTrackGroupId, class197.musicTrackFileId);
						if (FontName.musicTrack == null) {
							var2 = false;
							break label173;
						}
					}

					if (class189.soundCache == null) {
						class189.soundCache = new SoundCache(class197.soundEffectsArchive, class197.musicSamplesArchive);
					}

					if (class197.midiPcmStream.loadMusicTrack(FontName.musicTrack, class197.musicPatchesArchive, class189.soundCache, 22050)) {
						class197.midiPcmStream.clearAll();
						class197.midiPcmStream.method3670(WorldMapSprite.field222);
						class197.midiPcmStream.setMusicTrack(FontName.musicTrack, Varcs.musicTrackBoolean);
						class197.field2378 = 0;
						FontName.musicTrack = null;
						class189.soundCache = null;
						WorldMapDecoration.musicTrackArchive = null;
						var2 = true;
						break label173;
					}
				}
			} catch (Exception var6) {
				var6.printStackTrace();
				class197.midiPcmStream.clear();
				class197.field2378 = 0;
				FontName.musicTrack = null;
				class189.soundCache = null;
				WorldMapDecoration.musicTrackArchive = null;
			}

			var2 = false;
		}

		if (var2 && field858 && MouseRecorder.pcmPlayer0 != null) {
			MouseRecorder.pcmPlayer0.tryDiscard();
		}

		if ((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field836 && SequenceDefinition.method4686() > field836) {
			StudioGame.setWindowedMode(UserComparator7.getWindowedMode());
		}

		int var4;
		if (var1) {
			for (var4 = 0; var4 < 100; ++var4) {
				field703[var4] = true;
			}
		}

		if (gameState == 0) {
			this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
		} else if (gameState == 5) {
			GrandExchangeEvent.drawTitle(class43.fontBold12, class30.fontPlain11, ClientPacket.fontPlain12);
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				GrandExchangeEvent.drawTitle(class43.fontBold12, class30.fontPlain11, ClientPacket.fontPlain12);
			} else if (gameState == 25) {
				if (field719 == 1) {
					if (field676 > field886) {
						field886 = field676;
					}

					var4 = (field886 * 50 - field676 * 50) / field886;
					MusicPatch.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
				} else if (field719 == 2) {
					if (field678 > field718) {
						field718 = field678;
					}

					var4 = (field718 * 50 - field678 * 50) / field718 + 50;
					MusicPatch.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
				} else {
					MusicPatch.drawLoadingMessage("Loading - please wait.", false);
				}
			} else if (gameState == 30) {
				this.drawLoggedIn();
			} else if (gameState == 40) {
				MusicPatch.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
			} else if (gameState == 45) {
				MusicPatch.drawLoadingMessage("Please wait...", false);
			}
		} else {
			GrandExchangeEvent.drawTitle(class43.fontBold12, class30.fontPlain11, ClientPacket.fontPlain12);
		}

		if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
			for (var4 = 0; var4 < rootWidgetCount; ++var4) {
				if (field829[var4]) {
					SpotAnimationDefinition.rasterProvider.draw(rootWidgetXs[var4], rootWidgetYs[var4], rootWidgetWidths[var4], rootWidgetHeights[var4]);
					field829[var4] = false;
				}
			}
		} else if (gameState > 0) {
			SpotAnimationDefinition.rasterProvider.drawFull(0, 0);

			for (var4 = 0; var4 < rootWidgetCount; ++var4) {
				field829[var4] = false;
			}
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1993845226"
	)
	@Export("kill0")
	protected final void kill0() {
		if (KeyHandler.varcs.hasUnwrittenChanges()) {
			KeyHandler.varcs.write();
		}

		if (Language.mouseRecorder != null) {
			Language.mouseRecorder.isRunning = false;
		}

		Language.mouseRecorder = null;
		packetWriter.close();
		if (KeyHandler.KeyHandler_instance != null) {
			synchronized(KeyHandler.KeyHandler_instance) {
				KeyHandler.KeyHandler_instance = null;
			}
		}

		if (MouseHandler.MouseHandler_instance != null) {
			synchronized(MouseHandler.MouseHandler_instance) {
				MouseHandler.MouseHandler_instance = null;
			}
		}

		Canvas.mouseWheel = null;
		if (MouseRecorder.pcmPlayer0 != null) {
			MouseRecorder.pcmPlayer0.shutdown();
		}

		if (SoundCache.pcmPlayer1 != null) {
			SoundCache.pcmPlayer1.shutdown();
		}

		if (NetCache.NetCache_socket != null) {
			NetCache.NetCache_socket.close();
		}

		class60.method1122();
		if (ScriptEvent.urlRequester != null) {
			ScriptEvent.urlRequester.close();
			ScriptEvent.urlRequester = null;
		}

		try {
			JagexCache.JagexCache_dat2File.close();

			for (int var4 = 0; var4 < JagexCache.idxCount; ++var4) {
				WorldMapSection1.JagexCache_idxFiles[var4].close();
			}

			JagexCache.JagexCache_idx255File.close();
			JagexCache.JagexCache_randomDat.close();
		} catch (Exception var7) {
		}

	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1142845100"
	)
	protected final void vmethod1655() {
	}

	@ObfuscatedSignature(
		signature = "()Ljx;"
	)
	public Username aaj() {
		return WorldMapIcon_1.localPlayer != null ? WorldMapIcon_1.localPlayer.username : null;
	}

	public final void init() {
		try {
			if (this.checkHost()) {
				int var4;
				int var6;
				for (int var1 = 0; var1 <= 19; ++var1) {
					String var2 = this.getParameter(Integer.toString(var1));
					if (var2 != null) {
						switch(var1) {
						case 1:
							useBufferedSocket = Integer.parseInt(var2) != 0;
						case 2:
						case 11:
						case 13:
						case 16:
						default:
							break;
						case 3:
							if (var2.equalsIgnoreCase("true")) {
								isMembersWorld = true;
							} else {
								isMembersWorld = false;
							}
							break;
						case 4:
							if (clientType == -1) {
								clientType = Integer.parseInt(var2);
							}
							break;
						case 5:
							worldProperties = Integer.parseInt(var2);
							break;
						case 6:
							class60.clientLanguage = Language.method3602(Integer.parseInt(var2));
							break;
						case 7:
							var4 = Integer.parseInt(var2);
							ServerBuild[] var5 = Fonts.method5240();
							var6 = 0;

							ServerBuild var3;
							while (true) {
								if (var6 >= var5.length) {
									var3 = null;
									break;
								}

								ServerBuild var7 = var5[var6];
								if (var4 == var7.field3080) {
									var3 = var7;
									break;
								}

								++var6;
							}

							SequenceDefinition.field3507 = var3;
							break;
						case 8:
							if (var2.equalsIgnoreCase("true")) {
							}
							break;
						case 9:
							Clock.field2037 = var2;
							break;
						case 10:
							WorldMapRectangle.field166 = (StudioGame)FriendSystem.findEnumerated(WorldMapSprite.method402(), Integer.parseInt(var2));
							if (StudioGame.oldscape == WorldMapRectangle.field166) {
								FontName.loginType = LoginType.oldscape;
							} else {
								FontName.loginType = LoginType.field4032;
							}
							break;
						case 12:
							worldId = Integer.parseInt(var2);
							break;
						case 14:
							SoundSystem.field1414 = Integer.parseInt(var2);
							break;
						case 15:
							gameBuild = Integer.parseInt(var2);
							break;
						case 17:
							class1.field6 = var2;
						}
					}
				}

				Scene.Scene_isLowDetail = false;
				isLowDetail = false;
				NetFileRequest.worldHost = this.getCodeBase().getHost();
				String var8 = SequenceDefinition.field3507.name;
				byte var9 = 0;

				try {
					JagexCache.idxCount = 21;
					InterfaceParent.cacheGamebuild = var9;

					try {
						Decimator.field1439 = System.getProperty("os.name");
					} catch (Exception var14) {
						Decimator.field1439 = "Unknown";
					}

					ByteArrayPool.field3708 = Decimator.field1439.toLowerCase();

					try {
						FontName.userHomeDirectory = System.getProperty("user.home");
						if (FontName.userHomeDirectory != null) {
							FontName.userHomeDirectory = FontName.userHomeDirectory + "/";
						}
					} catch (Exception var13) {
					}

					try {
						if (ByteArrayPool.field3708.startsWith("win")) {
							if (FontName.userHomeDirectory == null) {
								FontName.userHomeDirectory = System.getenv("USERPROFILE");
							}
						} else if (FontName.userHomeDirectory == null) {
							FontName.userHomeDirectory = System.getenv("HOME");
						}

						if (FontName.userHomeDirectory != null) {
							FontName.userHomeDirectory = FontName.userHomeDirectory + "/";
						}
					} catch (Exception var12) {
					}

					if (FontName.userHomeDirectory == null) {
						FontName.userHomeDirectory = "~/";
					}

					GrandExchangeEvent.field47 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", FontName.userHomeDirectory, "/tmp/", ""};
					Login.field1181 = new String[]{".jagex_cache_" + InterfaceParent.cacheGamebuild, ".file_store_" + InterfaceParent.cacheGamebuild};

					label133:
					for (int var10 = 0; var10 < 4; ++var10) {
						JagexCache.cacheDir = class4.getCacheDir("oldschool", var8, var10);
						if (!JagexCache.cacheDir.exists()) {
							JagexCache.cacheDir.mkdirs();
						}

						File[] var11 = JagexCache.cacheDir.listFiles();
						if (var11 == null) {
							break;
						}

						File[] var18 = var11;
						var6 = 0;

						while (true) {
							if (var6 >= var18.length) {
								break label133;
							}

							File var19 = var18[var6];
							if (!GameShell.testReadWritePermissions(var19, false)) {
								break;
							}

							++var6;
						}
					}

					File var17 = JagexCache.cacheDir;
					FileSystem.FileSystem_cacheDir = var17;
					if (!FileSystem.FileSystem_cacheDir.exists()) {
						throw new RuntimeException("");
					}

					FileSystem.FileSystem_hasPermissions = true;
					SoundSystem.method2417();
					JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(class42.getFile("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
					JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(class42.getFile("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
					WorldMapSection1.JagexCache_idxFiles = new BufferedFile[JagexCache.idxCount];

					for (var4 = 0; var4 < JagexCache.idxCount; ++var4) {
						WorldMapSection1.JagexCache_idxFiles[var4] = new BufferedFile(new AccessFile(class42.getFile("main_file_cache.idx" + var4), "rw", 1048576L), 6000, 0);
					}
				} catch (Exception var15) {
					class3.RunException_sendStackTrace((String)null, var15);
				}

				WorldMapID.client = this;
				GZipDecompressor.field4007 = clientType;
				this.startThread(765, 503, 182);
			}
		} catch (RuntimeException var16) {
			throw class195.newRunException(var16, "client.init(" + ')');
		}
	}

	@ObfuscatedSignature(
		signature = "()Ljx;"
	)
	public Username aag() {
		return WorldMapIcon_1.localPlayer != null ? WorldMapIcon_1.localPlayer.username : null;
	}

	@ObfuscatedSignature(
		signature = "()Ljx;"
	)
	public Username abc() {
		return WorldMapIcon_1.localPlayer != null ? WorldMapIcon_1.localPlayer.username : null;
	}

	@ObfuscatedSignature(
		signature = "()Ljx;"
	)
	public Username aba() {
		return WorldMapIcon_1.localPlayer != null ? WorldMapIcon_1.localPlayer.username : null;
	}

	@ObfuscatedName("ep")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1547089502"
	)
	@Export("doCycleJs5")
	void doCycleJs5() {
		if (gameState != 1000) {
			boolean var1 = TilePaint.method3007();
			if (!var1) {
				this.doCycleJs5Connect();
			}

		}
	}

	@ObfuscatedName("ek")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "529231386"
	)
	@Export("doCycleJs5Connect")
	void doCycleJs5Connect() {
		if (NetCache.NetCache_crcMismatches >= 4) {
			this.error("js5crc");
			gameState = 1000;
		} else {
			if (NetCache.NetCache_ioExceptions >= 4) {
				if (gameState <= 5) {
					this.error("js5io");
					gameState = 1000;
					return;
				}

				field681 = 3000;
				NetCache.NetCache_ioExceptions = 3;
			}

			if (--field681 + 1 <= 0) {
				try {
					if (js5ConnectState == 0) {
						RouteStrategy.js5SocketTask = GameShell.taskHandler.newSocketTask(NetFileRequest.worldHost, SecureRandomCallable.port3);
						++js5ConnectState;
					}

					if (js5ConnectState == 1) {
						if (RouteStrategy.js5SocketTask.status == 2) {
							this.js5Error(-1);
							return;
						}

						if (RouteStrategy.js5SocketTask.status == 1) {
							++js5ConnectState;
						}
					}

					if (js5ConnectState == 2) {
						if (useBufferedSocket) {
							Socket var2 = (Socket)RouteStrategy.js5SocketTask.result;
							BufferedNetSocket var1 = new BufferedNetSocket(var2, 40000, 5000);
							js5Socket = var1;
						} else {
							js5Socket = new NetSocket((Socket)RouteStrategy.js5SocketTask.result, GameShell.taskHandler, 5000);
						}

						Buffer var5 = new Buffer(5);
						var5.writeByte(15);
						var5.writeInt(182);
						js5Socket.write(var5.array, 0, 5);
						++js5ConnectState;
						Coord.field2511 = SequenceDefinition.method4686();
					}

					if (js5ConnectState == 3) {
						if (js5Socket.available() > 0 || !useBufferedSocket && gameState <= 5) {
							int var3 = js5Socket.readUnsignedByte();
							if (var3 != 0) {
								this.js5Error(var3);
								return;
							}

							++js5ConnectState;
						} else if (SequenceDefinition.method4686() - Coord.field2511 > 30000L) {
							this.js5Error(-2);
							return;
						}
					}

					if (js5ConnectState == 4) {
						class83.NetCache_connect(js5Socket, gameState > 20);
						RouteStrategy.js5SocketTask = null;
						js5Socket = null;
						js5ConnectState = 0;
						js5Errors = 0;
					}
				} catch (IOException var4) {
					this.js5Error(-3);
				}

			}
		}
	}

	@ObfuscatedName("et")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1888640319"
	)
	@Export("js5Error")
	void js5Error(int var1) {
		RouteStrategy.js5SocketTask = null;
		js5Socket = null;
		js5ConnectState = 0;
		if (WorldMapRectangle.port1 == SecureRandomCallable.port3) {
			SecureRandomCallable.port3 = FloorDecoration.port2;
		} else {
			SecureRandomCallable.port3 = WorldMapRectangle.port1;
		}

		++js5Errors;
		if (js5Errors >= 2 && (var1 == 7 || var1 == 9)) {
			if (gameState <= 5) {
				this.error("js5connect_full");
				gameState = 1000;
			} else {
				field681 = 3000;
			}
		} else if (js5Errors >= 2 && var1 == 6) {
			this.error("js5connect_outofdate");
			gameState = 1000;
		} else if (js5Errors >= 4) {
			if (gameState <= 5) {
				this.error("js5connect");
				gameState = 1000;
			} else {
				field681 = 3000;
			}
		}

	}

	@ObfuscatedName("el")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1767576334"
	)
	@Export("doCycleLoggedOut")
	final void doCycleLoggedOut() {
		Object var1 = packetWriter.getSocket();
		PacketBuffer var2 = packetWriter.packetBuffer;

		try {
			if (loginState == 0) {
				if (class2.secureRandom == null && (secureRandomFuture.isDone() || field658 > 250)) {
					class2.secureRandom = secureRandomFuture.get();
					secureRandomFuture.shutdown();
					secureRandomFuture = null;
				}

				if (class2.secureRandom != null) {
					if (var1 != null) {
						((AbstractSocket)var1).close();
						var1 = null;
					}

					WorldMapIcon_0.socketTask = null;
					field672 = false;
					field658 = 0;
					loginState = 1;
				}
			}

			if (loginState == 1) {
				if (WorldMapIcon_0.socketTask == null) {
					WorldMapIcon_0.socketTask = GameShell.taskHandler.newSocketTask(NetFileRequest.worldHost, SecureRandomCallable.port3);
				}

				if (WorldMapIcon_0.socketTask.status == 2) {
					throw new IOException();
				}

				if (WorldMapIcon_0.socketTask.status == 1) {
					if (useBufferedSocket) {
						Socket var4 = (Socket)WorldMapIcon_0.socketTask.result;
						BufferedNetSocket var3 = new BufferedNetSocket(var4, 40000, 5000);
						var1 = var3;
					} else {
						var1 = new NetSocket((Socket)WorldMapIcon_0.socketTask.result, GameShell.taskHandler, 5000);
					}

					packetWriter.setSocket((AbstractSocket)var1);
					WorldMapIcon_0.socketTask = null;
					loginState = 2;
				}
			}

			if (loginState == 2) {
				packetWriter.clearBuffer();
				PacketBufferNode var21 = class2.method29();
				var21.packetBuffer.writeByte(LoginPacket.field2291.id);
				packetWriter.addNode(var21);
				packetWriter.flush();
				var2.offset = 0;
				loginState = 3;
			}

			boolean var12;
			int var13;
			if (loginState == 3) {
				if (MouseRecorder.pcmPlayer0 != null) {
					MouseRecorder.pcmPlayer0.method2397();
				}

				if (SoundCache.pcmPlayer1 != null) {
					SoundCache.pcmPlayer1.method2397();
				}

				var12 = true;
				if (useBufferedSocket && !((AbstractSocket)var1).isAvailable(1)) {
					var12 = false;
				}

				if (var12) {
					var13 = ((AbstractSocket)var1).readUnsignedByte();
					if (MouseRecorder.pcmPlayer0 != null) {
						MouseRecorder.pcmPlayer0.method2397();
					}

					if (SoundCache.pcmPlayer1 != null) {
						SoundCache.pcmPlayer1.method2397();
					}

					if (var13 != 0) {
						GrandExchangeOfferOwnWorldComparator.getLoginError(var13);
						return;
					}

					var2.offset = 0;
					loginState = 4;
				}
			}

			int var33;
			if (loginState == 4) {
				if (var2.offset < 8) {
					var33 = ((AbstractSocket)var1).available();
					if (var33 > 8 - var2.offset) {
						var33 = 8 - var2.offset;
					}

					if (var33 > 0) {
						((AbstractSocket)var1).read(var2.array, var2.offset, var33);
						var2.offset += var33;
					}
				}

				if (var2.offset == 8) {
					var2.offset = 0;
					class65.field586 = var2.readLong();
					loginState = 5;
				}
			}

			int var7;
			int var9;
			int var14;
			if (loginState == 5) {
				packetWriter.packetBuffer.offset = 0;
				packetWriter.clearBuffer();
				PacketBuffer var22 = new PacketBuffer(500);
				int[] var24 = new int[]{class2.secureRandom.nextInt(), class2.secureRandom.nextInt(), class2.secureRandom.nextInt(), class2.secureRandom.nextInt()};
				var22.offset = 0;
				var22.writeByte(1);
				var22.writeInt(var24[0]);
				var22.writeInt(var24[1]);
				var22.writeInt(var24[2]);
				var22.writeInt(var24[3]);
				var22.writeLong(class65.field586);
				int var10;
				if (gameState == 40) {
					var22.writeInt(class192.field2365[0]);
					var22.writeInt(class192.field2365[1]);
					var22.writeInt(class192.field2365[2]);
					var22.writeInt(class192.field2365[3]);
				} else {
					var22.writeByte(field870.rsOrdinal());
					switch(field870.field1986) {
					case 0:
					case 1:
						var22.writeMedium(SecureRandomCallable.field500);
						++var22.offset;
						break;
					case 2:
						LinkedHashMap var6 = GrandExchangeOffer.clientPreferences.parameters;
						String var8 = Login.Login_username;
						var9 = var8.length();
						var10 = 0;

						for (int var11 = 0; var11 < var9; ++var11) {
							var10 = (var10 << 5) - var10 + var8.charAt(var11);
						}

						var22.writeInt((Integer)var6.get(var10));
						break;
					case 3:
						var22.offset += 4;
					}

					var22.writeByte(class312.field3810.rsOrdinal());
					var22.writeStringCp1252NullTerminated(Login.Login_password);
				}

				var22.encryptRsa(class83.field1138, class83.field1137);
				class192.field2365 = var24;
				PacketBufferNode var5 = class2.method29();
				var5.packetBuffer.offset = 0;
				if (gameState == 40) {
					var5.packetBuffer.writeByte(LoginPacket.field2292.id);
				} else {
					var5.packetBuffer.writeByte(LoginPacket.field2295.id);
				}

				var5.packetBuffer.writeShort(0);
				var14 = var5.packetBuffer.offset;
				var5.packetBuffer.writeInt(182);
				var5.packetBuffer.writeInt(1);
				var5.packetBuffer.writeByte(clientType);
				var5.packetBuffer.writeBytes(var22.array, 0, var22.offset);
				var7 = var5.packetBuffer.offset;
				var5.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
				var5.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
				var5.packetBuffer.writeShort(KitDefinition.canvasWidth);
				var5.packetBuffer.writeShort(class30.canvasHeight);
				FloorDecoration.method2787(var5.packetBuffer);
				var5.packetBuffer.writeStringCp1252NullTerminated(Clock.field2037);
				var5.packetBuffer.writeInt(SoundSystem.field1414);
				Buffer var31 = new Buffer(World.platformInfo.size());
				World.platformInfo.write(var31);
				var5.packetBuffer.writeBytes(var31.array, 0, var31.array.length);
				var5.packetBuffer.writeByte(clientType);
				var5.packetBuffer.writeInt(0);
				var5.packetBuffer.writeInt(archive0.hash);
				var5.packetBuffer.writeInt(class269.archive1.hash);
				var5.packetBuffer.writeInt(HealthBarUpdate.archive2.hash);
				var5.packetBuffer.writeInt(UserComparator8.archive3.hash);
				var5.packetBuffer.writeInt(WorldMapSprite.archive4.hash);
				var5.packetBuffer.writeInt(WorldMapDecoration.archive5.hash);
				var5.packetBuffer.writeInt(GrandExchangeEvent.archive6.hash);
				var5.packetBuffer.writeInt(class51.archive7.hash);
				var5.packetBuffer.writeInt(class2.archive8.hash);
				var5.packetBuffer.writeInt(WorldMapDecoration.archive9.hash);
				var5.packetBuffer.writeInt(GameObject.archive10.hash);
				var5.packetBuffer.writeInt(WorldMapRectangle.archive11.hash);
				var5.packetBuffer.writeInt(GameShell.archive12.hash);
				var5.packetBuffer.writeInt(WorldMapID.archive13.hash);
				var5.packetBuffer.writeInt(WorldMapSection1.archive14.hash);
				var5.packetBuffer.writeInt(GrandExchangeOfferWorldComparator.archive15.hash);
				var5.packetBuffer.writeInt(0);
				var5.packetBuffer.writeInt(WorldMapIcon_1.archive17.hash);
				var5.packetBuffer.writeInt(class40.archive18.hash);
				var5.packetBuffer.writeInt(SoundCache.archive19.hash);
				var5.packetBuffer.writeInt(Script.archive20.hash);
				var5.packetBuffer.xteaEncrypt(var24, var7, var5.packetBuffer.offset);
				var5.packetBuffer.writeLengthShort(var5.packetBuffer.offset - var14);
				packetWriter.addNode(var5);
				packetWriter.flush();
				packetWriter.isaacCipher = new IsaacCipher(var24);
				int[] var15 = new int[4];

				for (var10 = 0; var10 < 4; ++var10) {
					var15[var10] = var24[var10] + 50;
				}

				var2.newIsaacCipher(var15);
				loginState = 6;
			}

			if (loginState == 6 && ((AbstractSocket)var1).available() > 0) {
				var33 = ((AbstractSocket)var1).readUnsignedByte();
				if (var33 == 21 && gameState == 20) {
					loginState = 9;
				} else if (var33 == 2) {
					loginState = 11;
				} else if (var33 == 15 && gameState == 40) {
					packetWriter.serverPacketLength = -1;
					loginState = 16;
				} else if (var33 == 64) {
					loginState = 7;
				} else if (var33 == 23 && field659 < 1) {
					++field659;
					loginState = 0;
				} else {
					if (var33 != 29) {
						GrandExchangeOfferOwnWorldComparator.getLoginError(var33);
						return;
					}

					loginState = 14;
				}
			}

			if (loginState == 7 && ((AbstractSocket)var1).available() > 0) {
				WorldMapSection2.field183 = ((AbstractSocket)var1).readUnsignedByte();
				loginState = 8;
			}

			if (loginState == 8 && ((AbstractSocket)var1).available() >= WorldMapSection2.field183) {
				((AbstractSocket)var1).read(var2.array, 0, WorldMapSection2.field183);
				var2.offset = 0;
				loginState = 6;
			}

			if (loginState == 9 && ((AbstractSocket)var1).available() > 0) {
				field660 = (((AbstractSocket)var1).readUnsignedByte() + 3) * 60;
				loginState = 10;
			}

			if (loginState == 10) {
				field658 = 0;
				GrandExchangeOfferOwnWorldComparator.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field660 / 60 + " seconds.");
				if (--field660 <= 0) {
					loginState = 0;
				}

			} else {
				if (loginState == 11 && ((AbstractSocket)var1).available() >= 1) {
					GameShell.field425 = ((AbstractSocket)var1).readUnsignedByte();
					loginState = 12;
				}

				if (loginState == 12 && ((AbstractSocket)var1).available() >= GameShell.field425) {
					var12 = ((AbstractSocket)var1).readUnsignedByte() == 1;
					((AbstractSocket)var1).read(var2.array, 0, 4);
					var2.offset = 0;
					boolean var34 = false;
					if (var12) {
						var13 = var2.readByteIsaac() << 24;
						var13 |= var2.readByteIsaac() << 16;
						var13 |= var2.readByteIsaac() << 8;
						var13 |= var2.readByteIsaac();
						String var30 = Login.Login_username;
						var7 = var30.length();
						int var16 = 0;
						var9 = 0;

						while (true) {
							if (var9 >= var7) {
								if (GrandExchangeOffer.clientPreferences.parameters.size() >= 10 && !GrandExchangeOffer.clientPreferences.parameters.containsKey(var16)) {
									Iterator var32 = GrandExchangeOffer.clientPreferences.parameters.entrySet().iterator();
									var32.next();
									var32.remove();
								}

								GrandExchangeOffer.clientPreferences.parameters.put(var16, var13);
								break;
							}

							var16 = (var16 << 5) - var16 + var30.charAt(var9);
							++var9;
						}
					}

					if (Login_isUsernameRemembered) {
						GrandExchangeOffer.clientPreferences.rememberedUsername = Login.Login_username;
					} else {
						GrandExchangeOffer.clientPreferences.rememberedUsername = null;
					}

					GrandExchangeOfferAgeComparator.savePreferences();
					staffModLevel = ((AbstractSocket)var1).readUnsignedByte();
					playerMod = ((AbstractSocket)var1).readUnsignedByte() == 1;
					localPlayerIndex = ((AbstractSocket)var1).readUnsignedByte();
					localPlayerIndex <<= 8;
					localPlayerIndex += ((AbstractSocket)var1).readUnsignedByte();
					field741 = ((AbstractSocket)var1).readUnsignedByte();
					((AbstractSocket)var1).read(var2.array, 0, 1);
					var2.offset = 0;
					ServerPacket[] var28 = MouseRecorder.ServerPacket_values();
					var14 = var2.readSmartByteShortIsaac();
					if (var14 < 0 || var14 >= var28.length) {
						throw new IOException(var14 + " " + var2.offset);
					}

					packetWriter.serverPacket = var28[var14];
					packetWriter.serverPacketLength = packetWriter.serverPacket.length;
					((AbstractSocket)var1).read(var2.array, 0, 2);
					var2.offset = 0;
					packetWriter.serverPacketLength = var2.readUnsignedShort();

					try {
						Client var18 = WorldMapID.client;
						JSObject.getWindow(var18).call("zap", (Object[])null);
					} catch (Throwable var19) {
					}

					loginState = 13;
				}

				if (loginState != 13) {
					if (loginState == 14 && ((AbstractSocket)var1).available() >= 2) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, 2);
						var2.offset = 0;
						GrandExchangeOfferTotalQuantityComparator.field59 = var2.readUnsignedShort();
						loginState = 15;
					}

					if (loginState == 15 && ((AbstractSocket)var1).available() >= GrandExchangeOfferTotalQuantityComparator.field59) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, GrandExchangeOfferTotalQuantityComparator.field59);
						var2.offset = 0;
						String var25 = var2.readStringCp1252NullTerminated();
						String var27 = var2.readStringCp1252NullTerminated();
						String var29 = var2.readStringCp1252NullTerminated();
						GrandExchangeOfferOwnWorldComparator.setLoginResponseString(var25, var27, var29);
						FloorDecoration.updateGameState(10);
					}

					if (loginState == 16) {
						if (packetWriter.serverPacketLength == -1) {
							if (((AbstractSocket)var1).available() < 2) {
								return;
							}

							((AbstractSocket)var1).read(var2.array, 0, 2);
							var2.offset = 0;
							packetWriter.serverPacketLength = var2.readUnsignedShort();
						}

						if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
							((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
							var2.offset = 0;
							var33 = packetWriter.serverPacketLength;
							timer.method4901();
							WorldMapAreaData.method654();
							ScriptFrame.updatePlayer(var2);
							if (var33 != var2.offset) {
								throw new RuntimeException();
							}
						}
					} else {
						++field658;
						if (field658 > 2000) {
							if (field659 < 1) {
								if (SecureRandomCallable.port3 == WorldMapRectangle.port1) {
									SecureRandomCallable.port3 = FloorDecoration.port2;
								} else {
									SecureRandomCallable.port3 = WorldMapRectangle.port1;
								}

								++field659;
								loginState = 0;
							} else {
								GrandExchangeOfferOwnWorldComparator.getLoginError(-3);
							}
						}
					}
				} else {
					if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
						timer.method4900();
						mouseLastLastPressedTimeMillis = 1L;
						Language.mouseRecorder.index = 0;
						class3.hasFocus = true;
						hadFocus = true;
						field847 = -1L;
						class96.reflectionChecks = new IterableNodeDeque();
						packetWriter.clearBuffer();
						packetWriter.packetBuffer.offset = 0;
						packetWriter.serverPacket = null;
						packetWriter.field1295 = null;
						packetWriter.field1296 = null;
						packetWriter.field1291 = null;
						packetWriter.serverPacketLength = 0;
						packetWriter.field1293 = 0;
						rebootTimer = 0;
						logoutTimer = 0;
						hintArrowType = 0;
						menuOptionsCount = 0;
						isMenuOpen = false;
						MouseHandler.MouseHandler_idleCycles = 0;
						class219.method4021();
						isItemSelected = 0;
						isSpellSelected = false;
						soundEffectCount = 0;
						camAngleY = 0;
						oculusOrbState = 0;
						GameObject.field1921 = null;
						minimapState = 0;
						field651 = -1;
						destinationX = 0;
						destinationY = 0;
						playerAttackOption = AttackOption.AttackOption_hidden;
						npcAttackOption = AttackOption.AttackOption_hidden;
						npcCount = 0;
						MenuAction.method1993();

						for (var33 = 0; var33 < 2048; ++var33) {
							players[var33] = null;
						}

						for (var33 = 0; var33 < 32768; ++var33) {
							npcs[var33] = null;
						}

						combatTargetPlayerIndex = -1;
						projectiles.clear();
						graphicsObjects.clear();

						for (var33 = 0; var33 < 4; ++var33) {
							for (var13 = 0; var13 < 104; ++var13) {
								for (int var17 = 0; var17 < 104; ++var17) {
									groundItems[var33][var13][var17] = null;
								}
							}
						}

						pendingSpawns = new NodeDeque();
						class32.friendSystem.clear();

						for (var33 = 0; var33 < VarpDefinition.VarpDefinition_fileCount; ++var33) {
							VarpDefinition var26 = class16.method180(var33);
							if (var26 != null) {
								Varps.Varps_temp[var33] = 0;
								Varps.Varps_main[var33] = 0;
							}
						}

						KeyHandler.varcs.clearTransient();
						followerIndex = -1;
						if (rootInterface != -1) {
							UrlRequester.method3250(rootInterface);
						}

						for (InterfaceParent var23 = (InterfaceParent)interfaceParents.first(); var23 != null; var23 = (InterfaceParent)interfaceParents.next()) {
							VarpDefinition.closeInterface(var23, true);
						}

						rootInterface = -1;
						interfaceParents = new NodeHashTable(8);
						meslayerContinueWidget = null;
						menuOptionsCount = 0;
						isMenuOpen = false;
						playerAppearance.update((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

						for (var33 = 0; var33 < 8; ++var33) {
							playerMenuActions[var33] = null;
							playerOptionsPriorities[var33] = false;
						}

						ItemContainer.itemContainers = new NodeHashTable(32);
						isLoading = true;

						for (var33 = 0; var33 < 100; ++var33) {
							field703[var33] = true;
						}

						WorldMapCacheName.method593();
						clanChat = null;

						for (var33 = 0; var33 < 8; ++var33) {
							grandExchangeOffers[var33] = new GrandExchangeOffer();
						}

						class2.grandExchangeEvents = null;
						ScriptFrame.updatePlayer(var2);
						class13.field86 = -1;
						PendingSpawn.loadRegions(false, var2);
						packetWriter.serverPacket = null;
					}

				}
			}
		} catch (IOException var20) {
			if (field659 < 1) {
				if (WorldMapRectangle.port1 == SecureRandomCallable.port3) {
					SecureRandomCallable.port3 = FloorDecoration.port2;
				} else {
					SecureRandomCallable.port3 = WorldMapRectangle.port1;
				}

				++field659;
				loginState = 0;
			} else {
				GrandExchangeOfferOwnWorldComparator.getLoginError(-2);
			}
		}
	}

	@ObfuscatedName("fc")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "784775140"
	)
	@Export("doCycleLoggedIn")
	final void doCycleLoggedIn() {
		if (rebootTimer > 1) {
			--rebootTimer;
		}

		if (logoutTimer > 0) {
			--logoutTimer;
		}

		if (field672) {
			field672 = false;
			class2.method31();
		} else {
			if (!isMenuOpen) {
				LoginScreenAnimation.addCancelMenuEntry();
			}

			int var1;
			for (var1 = 0; var1 < 100 && this.method1467(packetWriter); ++var1) {
			}

			if (gameState == 30) {
				int var2;
				PacketBufferNode var14;
				while (GraphicsObject.hasReflectionCheck()) {
					var14 = MenuAction.getPacketBufferNode(ClientPacket.field2285, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					var2 = var14.packetBuffer.offset;
					InterfaceParent.performReflectionCheck(var14.packetBuffer);
					var14.packetBuffer.writeLengthByte(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
				}

				if (timer.field3560) {
					var14 = MenuAction.getPacketBufferNode(ClientPacket.field2195, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					var2 = var14.packetBuffer.offset;
					timer.write(var14.packetBuffer);
					var14.packetBuffer.writeLengthByte(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
					timer.method4925();
				}

				int var3;
				int var4;
				int var5;
				int var6;
				int var7;
				int var8;
				int var9;
				PacketBuffer var10000;
				synchronized(Language.mouseRecorder.lock) {
					if (!field783) {
						Language.mouseRecorder.index = 0;
					} else if (MouseHandler.MouseHandler_lastButton != 0 || Language.mouseRecorder.index >= 40) {
						PacketBufferNode var15 = null;
						var3 = 0;
						var4 = 0;
						var5 = 0;
						var6 = 0;

						for (var7 = 0; var7 < Language.mouseRecorder.index && (var15 == null || var15.packetBuffer.offset - var3 < 246); ++var7) {
							var4 = var7;
							var8 = Language.mouseRecorder.ys[var7];
							if (var8 < -1) {
								var8 = -1;
							} else if (var8 > 65534) {
								var8 = 65534;
							}

							var9 = Language.mouseRecorder.xs[var7];
							if (var9 < -1) {
								var9 = -1;
							} else if (var9 > 65534) {
								var9 = 65534;
							}

							if (var9 != field838 || var8 != field637) {
								if (var15 == null) {
									var15 = MenuAction.getPacketBufferNode(ClientPacket.field2219, packetWriter.isaacCipher);
									var15.packetBuffer.writeByte(0);
									var3 = var15.packetBuffer.offset;
									var10000 = var15.packetBuffer;
									var10000.offset += 2;
									var5 = 0;
									var6 = 0;
								}

								int var10;
								int var11;
								int var12;
								if (field889 != -1L) {
									var10 = var9 - field838;
									var11 = var8 - field637;
									var12 = (int)((Language.mouseRecorder.millis[var7] - field889) / 20L);
									var5 = (int)((long)var5 + (Language.mouseRecorder.millis[var7] - field889) % 20L);
								} else {
									var10 = var9;
									var11 = var8;
									var12 = Integer.MAX_VALUE;
								}

								field838 = var9;
								field637 = var8;
								if (var12 < 8 && var10 >= -32 && var10 <= 31 && var11 >= -32 && var11 <= 31) {
									var10 += 32;
									var11 += 32;
									var15.packetBuffer.writeShort((var12 << 12) + var11 + (var10 << 6));
								} else if (var12 < 32 && var10 >= -128 && var10 <= 127 && var11 >= -128 && var11 <= 127) {
									var10 += 128;
									var11 += 128;
									var15.packetBuffer.writeByte(var12 + 128);
									var15.packetBuffer.writeShort(var11 + (var10 << 8));
								} else if (var12 < 32) {
									var15.packetBuffer.writeByte(var12 + 192);
									if (var9 != -1 && var8 != -1) {
										var15.packetBuffer.writeInt(var9 | var8 << 16);
									} else {
										var15.packetBuffer.writeInt(Integer.MIN_VALUE);
									}
								} else {
									var15.packetBuffer.writeShort((var12 & 8191) + 57344);
									if (var9 != -1 && var8 != -1) {
										var15.packetBuffer.writeInt(var9 | var8 << 16);
									} else {
										var15.packetBuffer.writeInt(Integer.MIN_VALUE);
									}
								}

								++var6;
								field889 = Language.mouseRecorder.millis[var7];
							}
						}

						if (var15 != null) {
							var15.packetBuffer.writeLengthByte(var15.packetBuffer.offset - var3);
							var7 = var15.packetBuffer.offset;
							var15.packetBuffer.offset = var3;
							var15.packetBuffer.writeByte(var5 / var6);
							var15.packetBuffer.writeByte(var5 % var6);
							var15.packetBuffer.offset = var7;
							packetWriter.addNode(var15);
						}

						if (var4 >= Language.mouseRecorder.index) {
							Language.mouseRecorder.index = 0;
						} else {
							MouseRecorder var47 = Language.mouseRecorder;
							var47.index -= var4;
							System.arraycopy(Language.mouseRecorder.xs, var4, Language.mouseRecorder.xs, 0, Language.mouseRecorder.index);
							System.arraycopy(Language.mouseRecorder.ys, var4, Language.mouseRecorder.ys, 0, Language.mouseRecorder.index);
							System.arraycopy(Language.mouseRecorder.millis, var4, Language.mouseRecorder.millis, 0, Language.mouseRecorder.index);
						}
					}
				}

				PacketBufferNode var18;
				if (MouseHandler.MouseHandler_lastButton == 1 || !FriendSystem.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
					long var16 = (MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis * -1L) / 50L;
					if (var16 > 4095L) {
						var16 = 4095L;
					}

					mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis * -1L;
					var3 = MouseHandler.MouseHandler_lastPressedY;
					if (var3 < 0) {
						var3 = 0;
					} else if (var3 > class30.canvasHeight) {
						var3 = class30.canvasHeight;
					}

					var4 = MouseHandler.MouseHandler_lastPressedX;
					if (var4 < 0) {
						var4 = 0;
					} else if (var4 > KitDefinition.canvasWidth) {
						var4 = KitDefinition.canvasWidth;
					}

					var5 = (int)var16;
					var18 = MenuAction.getPacketBufferNode(ClientPacket.field2226, packetWriter.isaacCipher);
					var18.packetBuffer.writeShort((var5 << 1) + (MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0));
					var18.packetBuffer.writeShort(var4);
					var18.packetBuffer.writeShort(var3);
					packetWriter.addNode(var18);
				}

				if (KeyHandler.field380 > 0) {
					var14 = MenuAction.getPacketBufferNode(ClientPacket.field2252, packetWriter.isaacCipher);
					var14.packetBuffer.writeShort(0);
					var2 = var14.packetBuffer.offset;
					long var19 = SequenceDefinition.method4686();

					for (var5 = 0; var5 < KeyHandler.field380; ++var5) {
						long var21 = var19 - field847;
						if (var21 > 16777215L) {
							var21 = 16777215L;
						}

						field847 = var19;
						var14.packetBuffer.method5545(KeyHandler.field379[var5]);
						var14.packetBuffer.writeMedium((int)var21);
					}

					var14.packetBuffer.writeLengthShort(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
				}

				if (field712 > 0) {
					--field712;
				}

				if (KeyHandler.KeyHandler_pressedKeys[96] || KeyHandler.KeyHandler_pressedKeys[97] || KeyHandler.KeyHandler_pressedKeys[98] || KeyHandler.KeyHandler_pressedKeys[99]) {
					field708 = true;
				}

				if (field708 && field712 <= 0) {
					field712 = 20;
					field708 = false;
					var14 = MenuAction.getPacketBufferNode(ClientPacket.field2224, packetWriter.isaacCipher);
					var14.packetBuffer.method5432(camAngleX);
					var14.packetBuffer.writeShortLE(camAngleY);
					packetWriter.addNode(var14);
				}

				if (class3.hasFocus && !hadFocus) {
					hadFocus = true;
					var14 = MenuAction.getPacketBufferNode(ClientPacket.field2258, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(1);
					packetWriter.addNode(var14);
				}

				if (!class3.hasFocus && hadFocus) {
					hadFocus = false;
					var14 = MenuAction.getPacketBufferNode(ClientPacket.field2258, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					packetWriter.addNode(var14);
				}

				if (WorldMapCacheName.worldMap != null) {
					WorldMapCacheName.worldMap.method6187();
				}

				if (class13.ClanChat_inClanChat) {
					if (clanChat != null) {
						clanChat.sort();
					}

					for (var1 = 0; var1 < Players.Players_count; ++var1) {
						Player var34 = players[Players.Players_indices[var1]];
						var34.clearIsInClanChat();
					}

					class13.ClanChat_inClanChat = false;
				}

				GrandExchangeOfferUnitPriceComparator.method133();
				if (gameState == 30) {
					FloorDecoration.method2788();

					int var10002;
					for (var1 = 0; var1 < soundEffectCount; ++var1) {
						var10002 = queuedSoundEffectDelays[var1]--;
						if (queuedSoundEffectDelays[var1] >= -10) {
							SoundEffect var35 = soundEffects[var1];
							if (var35 == null) {
								var10000 = null;
								var35 = SoundEffect.readSoundEffect(WorldMapSprite.archive4, soundEffectIds[var1], 0);
								if (var35 == null) {
									continue;
								}

								int[] var48 = queuedSoundEffectDelays;
								var48[var1] += var35.calculateDelay();
								soundEffects[var1] = var35;
							}

							if (queuedSoundEffectDelays[var1] < 0) {
								if (soundLocations[var1] != 0) {
									var4 = (soundLocations[var1] & 255) * 128;
									var5 = soundLocations[var1] >> 16 & 255;
									var6 = var5 * 128 + 64 - WorldMapIcon_1.localPlayer.x;
									if (var6 < 0) {
										var6 = -var6;
									}

									var7 = soundLocations[var1] >> 8 & 255;
									var8 = var7 * 128 + 64 - WorldMapIcon_1.localPlayer.y;
									if (var8 < 0) {
										var8 = -var8;
									}

									var9 = var8 + var6 - 128;
									if (var9 > var4) {
										queuedSoundEffectDelays[var1] = -100;
										continue;
									}

									if (var9 < 0) {
										var9 = 0;
									}

									var3 = (var4 - var9) * field860 / var4;
								} else {
									var3 = soundEffectVolume;
								}

								if (var3 > 0) {
									RawSound var23 = var35.toRawSound().resample(class247.decimator);
									RawPcmStream var24 = RawPcmStream.createRawPcmStream(var23, 100, var3);
									var24.setNumLoops(queuedSoundEffectLoops[var1] - 1);
									IgnoreList.pcmStreamMixer.addSubStream(var24);
								}

								queuedSoundEffectDelays[var1] = -100;
							}
						} else {
							--soundEffectCount;

							for (var2 = var1; var2 < soundEffectCount; ++var2) {
								soundEffectIds[var2] = soundEffectIds[var2 + 1];
								soundEffects[var2] = soundEffects[var2 + 1];
								queuedSoundEffectLoops[var2] = queuedSoundEffectLoops[var2 + 1];
								queuedSoundEffectDelays[var2] = queuedSoundEffectDelays[var2 + 1];
								soundLocations[var2] = soundLocations[var2 + 1];
							}

							--var1;
						}
					}

					if (field858) {
						boolean var29;
						if (class197.field2378 != 0) {
							var29 = true;
						} else {
							var29 = class197.midiPcmStream.isReady();
						}

						if (!var29) {
							if (field856 != 0 && field857 != -1) {
								PacketBufferNode.method3574(GrandExchangeEvent.archive6, field857, 0, field856, false);
							}

							field858 = false;
						}
					}

					++packetWriter.field1293;
					if (packetWriter.field1293 > 750) {
						class2.method31();
					} else {
						var1 = Players.Players_count;
						int[] var36 = Players.Players_indices;

						for (var3 = 0; var3 < var1; ++var3) {
							Player var41 = players[var36[var3]];
							if (var41 != null) {
								class1.calculateActorPosition(var41, 1);
							}
						}

						WorldMapRectangle.method280();
						UserComparator3.processOverheadText();
						++field879;
						if (mouseCrossColor != 0) {
							mouseCrossState = mouseCrossState * 400 + 20;
							if (mouseCrossState * 400 >= 400) {
								mouseCrossColor = 0;
							}
						}

						if (Actor.field978 != null) {
							++field729;
							if (field729 >= 15) {
								FriendSystem.invalidateWidget(Actor.field978);
								Actor.field978 = null;
							}
						}

						Widget var33 = class65.mousedOverWidgetIf1;
						Widget var38 = WorldMapDecoration.field198;
						class65.mousedOverWidgetIf1 = null;
						WorldMapDecoration.field198 = null;
						draggedOnWidget = null;
						field804 = false;
						field641 = false;
						field677 = 0;

						while (FontName.isKeyDown() && field677 < 128) {
							if (staffModLevel >= 2 && KeyHandler.KeyHandler_pressedKeys[82] && ReflectionCheck.field1307 == 66) {
								String var42 = "";

								Message var37;
								for (Iterator var43 = Messages.Messages_hashTable.iterator(); var43.hasNext(); var42 = var42 + var37.sender + ':' + var37.text + '\n') {
									var37 = (Message)var43.next();
								}

								WorldMapID.client.clipboardSetString(var42);
							} else if (oculusOrbState != 1 || SpriteMask.field2499 <= 0) {
								field815[field677] = ReflectionCheck.field1307;
								field845[field677] = SpriteMask.field2499;
								++field677;
							}
						}

						boolean var30 = staffModLevel >= 2;
						if (var30 && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81] && mouseWheelRotation != 0) {
							var4 = WorldMapIcon_1.localPlayer.plane - mouseWheelRotation;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > 3) {
								var4 = 3;
							}

							if (var4 != WorldMapIcon_1.localPlayer.plane) {
								BoundaryObject.method3215(WorldMapIcon_1.localPlayer.pathX[0] + PacketWriter.baseX * 64, WorldMapIcon_1.localPlayer.pathY[0] + RouteStrategy.baseY * 64, var4, false);
							}

							mouseWheelRotation = 0;
						}

						if (rootInterface != -1) {
							MouseRecorder.updateRootInterface(rootInterface, 0, 0, KitDefinition.canvasWidth, class30.canvasHeight, 0, 0);
						}

						++cycleCntr;

						while (true) {
							Widget var39;
							ScriptEvent var44;
							Widget var45;
							do {
								var44 = (ScriptEvent)field633.removeLast();
								if (var44 == null) {
									while (true) {
										do {
											var44 = (ScriptEvent)field824.removeLast();
											if (var44 == null) {
												while (true) {
													do {
														var44 = (ScriptEvent)scriptEvents.removeLast();
														if (var44 == null) {
															this.method1293();
															if (WorldMapCacheName.worldMap != null) {
																WorldMapCacheName.worldMap.method6193(ItemContainer.plane, PacketWriter.baseX * 64 + (WorldMapIcon_1.localPlayer.x >> 7), RouteStrategy.baseY * 64 + (WorldMapIcon_1.localPlayer.y >> 7), false);
																WorldMapCacheName.worldMap.loadCache();
															}

															if (clickedWidget != null) {
																this.method1615();
															}

															if (class188.dragInventoryWidget != null) {
																FriendSystem.invalidateWidget(class188.dragInventoryWidget);
																++itemDragDuration;
																if (MouseHandler.MouseHandler_currentButton == 0) {
																	if (field867) {
																		if (class188.dragInventoryWidget == class222.field2730 && dragItemSlotSource != dragItemSlotDestination) {
																			Widget var46 = class188.dragInventoryWidget;
																			byte var31 = 0;
																			if (field788 == 1 && var46.contentType == 206) {
																				var31 = 1;
																			}

																			if (var46.itemIds[dragItemSlotDestination] <= 0) {
																				var31 = 0;
																			}

																			var7 = ParamDefinition.getWidgetClickMask(var46);
																			boolean var32 = (var7 >> 29 & 1) != 0;
																			if (var32) {
																				var8 = dragItemSlotSource;
																				var9 = dragItemSlotDestination;
																				var46.itemIds[var9] = var46.itemIds[var8];
																				var46.itemQuantities[var9] = var46.itemQuantities[var8];
																				var46.itemIds[var8] = -1;
																				var46.itemQuantities[var8] = 0;
																			} else if (var31 == 1) {
																				var8 = dragItemSlotSource;
																				var9 = dragItemSlotDestination;

																				while (var8 != var9) {
																					if (var8 > var9) {
																						var46.swapItems(var8 - 1, var8);
																						--var8;
																					} else if (var8 < var9) {
																						var46.swapItems(var8 + 1, var8);
																						++var8;
																					}
																				}
																			} else {
																				var46.swapItems(dragItemSlotDestination, dragItemSlotSource);
																			}

																			PacketBufferNode var26 = MenuAction.getPacketBufferNode(ClientPacket.field2265, packetWriter.isaacCipher);
																			var26.packetBuffer.writeShort(dragItemSlotDestination);
																			var26.packetBuffer.writeShortLE(dragItemSlotSource);
																			var26.packetBuffer.writeInt(class188.dragInventoryWidget.id);
																			var26.packetBuffer.method5545(var31);
																			packetWriter.addNode(var26);
																		}
																	} else if (this.shouldLeftClickOpenMenu()) {
																		this.openMenu(field732, field744);
																	} else if (menuOptionsCount > 0) {
																		var4 = field732;
																		var5 = field744;
																		MenuAction var40 = class1.tempMenuAction;
																		SecureRandomFuture.menuAction(var40.argument1, var40.argument2, var40.opcode, var40.argument0, var40.action, var40.action, var4, var5);
																		class1.tempMenuAction = null;
																	}

																	field729 = 10;
																	MouseHandler.MouseHandler_lastButton = 0;
																	class188.dragInventoryWidget = null;
																} else if (itemDragDuration >= 5 && (MouseHandler.MouseHandler_x > field732 + 5 || MouseHandler.MouseHandler_x < field732 - 5 || MouseHandler.MouseHandler_y > field744 + 5 || MouseHandler.MouseHandler_y < field744 - 5)) {
																	field867 = true;
																}
															}

															if (Scene.method3049()) {
																var4 = Scene.Scene_selectedX;
																var5 = Scene.Scene_selectedY;
																var18 = MenuAction.getPacketBufferNode(ClientPacket.field2281, packetWriter.isaacCipher);
																var18.packetBuffer.writeByte(5);
																var18.packetBuffer.method5443(RouteStrategy.baseY * 64 + var5);
																var18.packetBuffer.method5443(PacketWriter.baseX * 64 + var4);
																var18.packetBuffer.method5433(KeyHandler.KeyHandler_pressedKeys[82] ? (KeyHandler.KeyHandler_pressedKeys[81] ? 2 : 1) : 0);
																packetWriter.addNode(var18);
																Scene.method3050();
																mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
																mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
																mouseCrossColor = 1;
																mouseCrossState = 0;
																destinationX = var4;
																destinationY = var5;
															}

															if (var33 != class65.mousedOverWidgetIf1) {
																if (var33 != null) {
																	FriendSystem.invalidateWidget(var33);
																}

																if (class65.mousedOverWidgetIf1 != null) {
																	FriendSystem.invalidateWidget(class65.mousedOverWidgetIf1);
																}
															}

															if (var38 != WorldMapDecoration.field198 && field774 == field848) {
																if (var38 != null) {
																	FriendSystem.invalidateWidget(var38);
																}

																if (WorldMapDecoration.field198 != null) {
																	FriendSystem.invalidateWidget(WorldMapDecoration.field198);
																}
															}

															if (WorldMapDecoration.field198 != null) {
																if (field774 < field848) {
																	++field774;
																	if (field774 == field848) {
																		FriendSystem.invalidateWidget(WorldMapDecoration.field198);
																	}
																}
															} else if (field774 > 0) {
																--field774;
															}

															MilliClock.method3405();
															if (isCameraLocked) {
																WorldMapIcon_1.method294();
															}

															for (var4 = 0; var4 < 5; ++var4) {
																var10002 = field872[var4]++;
															}

															KeyHandler.varcs.tryWrite();
															var4 = UserComparator3.method3371();
															var5 = Skeleton.method3008();
															if (var4 > 15000 && var5 > 15000) {
																logoutTimer = 250;
																MouseHandler.MouseHandler_idleCycles = 14500;
																var18 = MenuAction.getPacketBufferNode(ClientPacket.field2234, packetWriter.isaacCipher);
																packetWriter.addNode(var18);
															}

															class32.friendSystem.processFriendUpdates();
															++packetWriter.pendingWrites;
															if (packetWriter.pendingWrites > 50) {
																var18 = MenuAction.getPacketBufferNode(ClientPacket.field2207, packetWriter.isaacCipher);
																packetWriter.addNode(var18);
															}

															try {
																packetWriter.flush();
															} catch (IOException var27) {
																class2.method31();
															}

															return;
														}

														var45 = var44.widget;
														if (var45.childIndex < 0) {
															break;
														}

														var39 = WorldMapElement.getWidget(var45.parentId);
													} while(var39 == null || var39.children == null || var45.childIndex >= var39.children.length || var45 != var39.children[var45.childIndex]);

													class81.runScriptEvent(var44);
												}
											}

											var45 = var44.widget;
											if (var45.childIndex < 0) {
												break;
											}

											var39 = WorldMapElement.getWidget(var45.parentId);
										} while(var39 == null || var39.children == null || var45.childIndex >= var39.children.length || var45 != var39.children[var45.childIndex]);

										class81.runScriptEvent(var44);
									}
								}

								var45 = var44.widget;
								if (var45.childIndex < 0) {
									break;
								}

								var39 = WorldMapElement.getWidget(var45.parentId);
							} while(var39 == null || var39.children == null || var45.childIndex >= var39.children.length || var45 != var39.children[var45.childIndex]);

							class81.runScriptEvent(var44);
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("gj")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "48"
	)
	@Export("resizeJS")
	void resizeJS() {
		int var1 = KitDefinition.canvasWidth;
		int var2 = class30.canvasHeight;
		if (super.contentWidth < var1) {
			var1 = super.contentWidth;
		}

		if (super.contentHeight < var2) {
			var2 = super.contentHeight;
		}

		if (GrandExchangeOffer.clientPreferences != null) {
			try {
				class47.method795(WorldMapID.client, "resize", new Object[]{UserComparator7.getWindowedMode()});
			} catch (Throwable var4) {
			}
		}

	}

	@ObfuscatedName("gv")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1443286014"
	)
	@Export("drawLoggedIn")
	final void drawLoggedIn() {
		if (rootInterface != -1) {
			CollisionMap.drawInterfaceModelComponents(rootInterface);
		}

		int var1;
		for (var1 = 0; var1 < rootWidgetCount; ++var1) {
			if (field703[var1]) {
				field829[var1] = true;
			}

			field830[var1] = field703[var1];
			field703[var1] = false;
		}

		field752 = cycle;
		viewportX = -1;
		viewportY = -1;
		class222.field2730 = null;
		if (rootInterface != -1) {
			rootWidgetCount = 0;
			class2.drawWidgets(rootInterface, 0, 0, KitDefinition.canvasWidth, class30.canvasHeight, 0, 0, -1);
		}

		Rasterizer2D.Rasterizer2D_resetClip();
		if (showMouseCross) {
			if (mouseCrossColor == 1) {
				DefaultsGroup.crossSprites[mouseCrossState * 400 / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}

			if (mouseCrossColor == 2) {
				DefaultsGroup.crossSprites[mouseCrossState * 400 / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}
		}

		if (!isMenuOpen) {
			if (viewportX != -1) {
				var1 = viewportX;
				int var2 = viewportY;
				if ((menuOptionsCount >= 2 || isItemSelected != 0 || isSpellSelected) && showMouseOverText) {
					int var3 = Player.getNewestMenuIdx();
					String var4;
					if (isItemSelected == 1 && menuOptionsCount < 2) {
						var4 = "Use" + " " + selectedItemName + " " + "->";
					} else if (isSpellSelected && menuOptionsCount < 2) {
						var4 = selectedSpellActionName + " " + selectedSpellName + " " + "->";
					} else {
						String var5;
						if (var3 < 0) {
							var5 = "";
						} else if (menuTargets[var3].length() > 0) {
							var5 = menuActions[var3] + " " + menuTargets[var3];
						} else {
							var5 = menuActions[var3];
						}

						var4 = var5;
					}

					if (menuOptionsCount > 2) {
						var4 = var4 + class16.colorStartTag(16777215) + " " + '/' + " " + (menuOptionsCount - 2) + " more options";
					}

					class43.fontBold12.drawRandomAlphaAndSpacing(var4, var1 + 4, var2 + 15, 16777215, 0, cycle / 1000);
				}
			}
		} else {
			WorldMapData_0.method176();
		}

		if (gameDrawingMode == 3) {
			for (var1 = 0; var1 < rootWidgetCount; ++var1) {
				if (field830[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
				} else if (field829[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
				}
			}
		}

		GrandExchangeOfferAgeComparator.method156(ItemContainer.plane, WorldMapIcon_1.localPlayer.x, WorldMapIcon_1.localPlayer.y, field879);
		field879 = 0;
	}

	@ObfuscatedName("hc")
	@ObfuscatedSignature(
		signature = "(Lcy;B)Z",
		garbageValue = "104"
	)
	final boolean method1467(PacketWriter var1) {
		AbstractSocket var2 = var1.getSocket();
		PacketBuffer var3 = var1.packetBuffer;
		if (var2 == null) {
			return false;
		} else {
			int var6;
			String var19;
			try {
				int var5;
				if (var1.serverPacket == null) {
					if (var1.field1284) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 0, 1);
						var1.field1293 = 0;
						var1.field1284 = false;
					}

					var3.offset = 0;
					if (var3.method5353()) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 1, 1);
						var1.field1293 = 0;
					}

					var1.field1284 = true;
					ServerPacket[] var4 = MouseRecorder.ServerPacket_values();
					var5 = var3.readSmartByteShortIsaac();
					if (var5 < 0 || var5 >= var4.length) {
						throw new IOException(var5 + " " + var3.offset);
					}

					var1.serverPacket = var4[var5];
					var1.serverPacketLength = var1.serverPacket.length;
				}

				if (var1.serverPacketLength == -1) {
					if (!var2.isAvailable(1)) {
						return false;
					}

					var1.getSocket().read(var3.array, 0, 1);
					var1.serverPacketLength = var3.array[0] & 255;
				}

				if (var1.serverPacketLength == -2) {
					if (!var2.isAvailable(2)) {
						return false;
					}

					var1.getSocket().read(var3.array, 0, 2);
					var3.offset = 0;
					var1.serverPacketLength = var3.readUnsignedShort();
				}

				if (!var2.isAvailable(var1.serverPacketLength)) {
					return false;
				}

				var3.offset = 0;
				var2.read(var3.array, 0, var1.serverPacketLength);
				var1.field1293 = 0;
				timer.method4897();
				var1.field1291 = var1.field1296;
				var1.field1296 = var1.field1295;
				var1.field1295 = var1.serverPacket;
				if (ServerPacket.field2150 == var1.serverPacket) {
					SoundSystem.readReflectionCheck(var3, var1.serverPacketLength);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2139 == var1.serverPacket) {
					JagexCache.method3438(class185.field2298);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2125 == var1.serverPacket) {
					PendingSpawn.loadRegions(true, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2155 == var1.serverPacket) {
					class32.friendSystem.readUpdate(var3, var1.serverPacketLength);
					field629 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				InterfaceParent var7;
				int var16;
				if (ServerPacket.field2174 == var1.serverPacket) {
					var16 = var3.method5436();
					var5 = var3.method5455();
					var6 = var3.method5447();
					var7 = (InterfaceParent)interfaceParents.get((long)var5);
					if (var7 != null) {
						VarpDefinition.closeInterface(var7, var6 != var7.group);
					}

					NPC.method1967(var5, var6, var16);
					var1.serverPacket = null;
					return true;
				}

				boolean var46;
				String var49;
				if (ServerPacket.field2183 == var1.serverPacket) {
					var16 = var3.readUShortSmart();
					var46 = var3.readUnsignedByte() == 1;
					var49 = "";
					boolean var59 = false;
					if (var46) {
						var49 = var3.readStringCp1252NullTerminated();
						if (class32.friendSystem.isIgnored(new Username(var49, FontName.loginType))) {
							var59 = true;
						}
					}

					String var44 = var3.readStringCp1252NullTerminated();
					if (!var59) {
						DirectByteArrayCopier.addGameMessage(var16, var49, var44);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2165 == var1.serverPacket) {
					WorldMapIcon_0.privateChatMode = class270.method4895(var3.readUnsignedByte());
					var1.serverPacket = null;
					return true;
				}

				Widget var17;
				if (ServerPacket.field2173 == var1.serverPacket) {
					var16 = var3.method5414();
					var5 = var3.method5447();
					var17 = WorldMapElement.getWidget(var16);
					if (var17 != null && var17.type == 0) {
						if (var5 > var17.scrollHeight - var17.height) {
							var5 = var17.scrollHeight - var17.height;
						}

						if (var5 < 0) {
							var5 = 0;
						}

						if (var5 != var17.scrollY) {
							var17.scrollY = var5;
							FriendSystem.invalidateWidget(var17);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2108 == var1.serverPacket) {
					JagexCache.method3438(class185.field2306);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2177 == var1.serverPacket) {
					tradeChatMode = var3.readUnsignedByteNegate();
					publicChatMode = var3.readUnsignedByteNegate();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2098 == var1.serverPacket) {
					class65.method1182();
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2164 == var1.serverPacket) {
					destinationX = var3.readUnsignedByte();
					if (destinationX == 255) {
						destinationX = 0;
					}

					destinationY = var3.readUnsignedByte();
					if (destinationY == 255) {
						destinationY = 0;
					}

					var1.serverPacket = null;
					return true;
				}

				boolean var48;
				if (ServerPacket.field2124 == var1.serverPacket) {
					var48 = var3.readUnsignedByte() == 1;
					if (var48) {
						Occluder.field1890 = SequenceDefinition.method4686() - var3.readLong();
						class2.grandExchangeEvents = new GrandExchangeEvents(var3, true);
					} else {
						class2.grandExchangeEvents = null;
					}

					field819 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2120 == var1.serverPacket) {
					var16 = var3.method5447();
					if (var16 == 65535) {
						var16 = -1;
					}

					SoundCache.playSong(var16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2175 == var1.serverPacket) {
					var16 = var3.method5449();
					var5 = var3.method5446();
					if (var5 == 65535) {
						var5 = -1;
					}

					MouseRecorder.playSoundJingle(var5, var16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2133 == var1.serverPacket) {
					hintArrowType = var3.readUnsignedByte();
					if (hintArrowType == 1) {
						hintArrowNpcIndex = var3.readUnsignedShort();
					}

					if (hintArrowType >= 2 && hintArrowType <= 6) {
						if (hintArrowType == 2) {
							hintArrowSubX = 4096;
							hintArrowSubY = 64;
						}

						if (hintArrowType == 3) {
							hintArrowSubX = 0;
							hintArrowSubY = 64;
						}

						if (hintArrowType == 4) {
							hintArrowSubX = 8192;
							hintArrowSubY = 64;
						}

						if (hintArrowType == 5) {
							hintArrowSubX = 4096;
							hintArrowSubY = 0;
						}

						if (hintArrowType == 6) {
							hintArrowSubX = 4096;
							hintArrowSubY = 128;
						}

						hintArrowType = 2;
						hintArrowX = var3.readUnsignedShort();
						hintArrowY = var3.readUnsignedShort();
						hintArrowHeight = var3.readUnsignedByte() * 4;
					}

					if (hintArrowType == 10) {
						hintArrowPlayerIndex = var3.readUnsignedShort();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2179 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readInt();
					var6 = class225.getGcDuration();
					PacketBufferNode var43 = MenuAction.getPacketBufferNode(ClientPacket.field2203, packetWriter.isaacCipher);
					var43.packetBuffer.method5545(var6);
					var43.packetBuffer.writeByte(GameShell.fps);
					var43.packetBuffer.writeIntME(var16);
					var43.packetBuffer.writeIntLE(var5);
					packetWriter.addNode(var43);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2126 == var1.serverPacket) {
					class32.friendSystem.method1774();
					field629 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2181 == var1.serverPacket) {
					var16 = var3.method5447();
					rootInterface = var16;
					this.resizeRoot(false);
					WorldMapSectionType.Widget_resetModelFrames(var16);
					class51.runWidgetOnLoadListener(rootInterface);

					for (var5 = 0; var5 < 100; ++var5) {
						field703[var5] = true;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2134 == var1.serverPacket) {
					var16 = var3.readInt();
					var46 = var3.readUnsignedByte() == 1;
					var17 = WorldMapElement.getWidget(var16);
					if (var46 != var17.isHidden) {
						var17.isHidden = var46;
						FriendSystem.invalidateWidget(var17);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2129 == var1.serverPacket) {
					UrlRequest.method3258(var3.readStringCp1252NullTerminated());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2118 == var1.serverPacket) {
					WorldMapIcon_0.method207();
					runEnergy = var3.readUnsignedByte();
					field820 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2113 == var1.serverPacket) {
					GrandExchangeOffer.updateNpcs(true, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2184 == var1.serverPacket) {
					JagexCache.method3438(class185.field2302);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2143 == var1.serverPacket) {
					var16 = var3.method5445();
					class1.method21(var16);
					field811[++field812 - 1 & 31] = var16 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2122 == var1.serverPacket) {
					Varps.field2507 = var3.readUnsignedByteNegate();
					WorldMapSection1.field283 = var3.readUnsignedByte();

					for (var16 = WorldMapSection1.field283; var16 < WorldMapSection1.field283 + 8; ++var16) {
						for (var5 = Varps.field2507; var5 < Varps.field2507 + 8; ++var5) {
							if (groundItems[ItemContainer.plane][var16][var5] != null) {
								groundItems[ItemContainer.plane][var16][var5] = null;
								class189.updateItemPile(var16, var5);
							}
						}
					}

					for (PendingSpawn var40 = (PendingSpawn)pendingSpawns.last(); var40 != null; var40 = (PendingSpawn)pendingSpawns.previous()) {
						if (var40.x >= WorldMapSection1.field283 && var40.x < WorldMapSection1.field283 + 8 && var40.y >= Varps.field2507 && var40.y < Varps.field2507 + 8 && var40.plane == ItemContainer.plane) {
							var40.hitpoints = 0;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2182 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					class83.method1997(var16);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2128 == var1.serverPacket) {
					var16 = var3.method5414();
					var5 = var3.method5447();
					var17 = WorldMapElement.getWidget(var16);
					if (var17.modelType != 1 || var5 != var17.modelId) {
						var17.modelType = 1;
						var17.modelId = var5;
						FriendSystem.invalidateWidget(var17);
					}

					var1.serverPacket = null;
					return true;
				}

				String var38;
				if (ServerPacket.field2135 == var1.serverPacket) {
					var38 = var3.readStringCp1252NullTerminated();
					var19 = AbstractFont.escapeBrackets(class189.method3596(class51.method845(var3)));
					DirectByteArrayCopier.addGameMessage(6, var38, var19);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2170 == var1.serverPacket) {
					var16 = var3.readInt();
					if (var16 != field705) {
						field705 = var16;
						ItemContainer.method1111();
					}

					var1.serverPacket = null;
					return true;
				}

				int var9;
				int var18;
				int var20;
				if (ServerPacket.field2141 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var16 < -70000) {
						var5 += 32768;
					}

					if (var16 >= 0) {
						var17 = WorldMapElement.getWidget(var16);
					} else {
						var17 = null;
					}

					for (; var3.offset < var1.serverPacketLength; Canvas.itemContainerSetItem(var5, var18, var20 - 1, var9)) {
						var18 = var3.readUShortSmart();
						var20 = var3.readUnsignedShort();
						var9 = 0;
						if (var20 != 0) {
							var9 = var3.readUnsignedByte();
							if (var9 == 255) {
								var9 = var3.readInt();
							}
						}

						if (var17 != null && var18 >= 0 && var18 < var17.itemIds.length) {
							var17.itemIds[var18] = var20;
							var17.itemQuantities[var18] = var9;
						}
					}

					if (var17 != null) {
						FriendSystem.invalidateWidget(var17);
					}

					WorldMapIcon_0.method207();
					field811[++field812 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2148 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedByte();
					var18 = var3.readUnsignedByte();
					field897[var16] = true;
					field869[var16] = var5;
					field694[var16] = var6;
					field758[var16] = var18;
					field872[var16] = 0;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2152 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					if (var3.readUnsignedByte() == 0) {
						grandExchangeOffers[var16] = new GrandExchangeOffer();
						var3.offset += 18;
					} else {
						--var3.offset;
						grandExchangeOffers[var16] = new GrandExchangeOffer(var3, false);
					}

					field818 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2159 == var1.serverPacket) {
					for (var16 = 0; var16 < players.length; ++var16) {
						if (players[var16] != null) {
							players[var16].sequence = -1;
						}
					}

					for (var16 = 0; var16 < npcs.length; ++var16) {
						if (npcs[var16] != null) {
							npcs[var16].sequence = -1;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2154 == var1.serverPacket) {
					var16 = var3.method5436();
					var5 = var3.method5436();
					var49 = var3.readStringCp1252NullTerminated();
					if (var5 >= 1 && var5 <= 8) {
						if (var49.equalsIgnoreCase("null")) {
							var49 = null;
						}

						playerMenuActions[var5 - 1] = var49;
						playerOptionsPriorities[var5 - 1] = var16 == 0;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2106 == var1.serverPacket) {
					var16 = var3.readInt();
					InterfaceParent var57 = (InterfaceParent)interfaceParents.get((long)var16);
					if (var57 != null) {
						VarpDefinition.closeInterface(var57, true);
					}

					if (meslayerContinueWidget != null) {
						FriendSystem.invalidateWidget(meslayerContinueWidget);
						meslayerContinueWidget = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2102 == var1.serverPacket) {
					PendingSpawn.loadRegions(false, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				Widget var8;
				if (ServerPacket.field2147 == var1.serverPacket) {
					var16 = var3.method5447();
					var5 = var3.method5447();
					var6 = var3.method5447();
					var18 = var3.method5414();
					var8 = WorldMapElement.getWidget(var18);
					if (var16 != var8.modelAngleX || var6 != var8.modelAngleY || var5 != var8.modelZoom) {
						var8.modelAngleX = var16;
						var8.modelAngleY = var6;
						var8.modelZoom = var5;
						FriendSystem.invalidateWidget(var8);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2114 == var1.serverPacket) {
					Varps.field2507 = var3.method5438();
					WorldMapSection1.field283 = var3.readUnsignedByteNegate();

					while (var3.offset < var1.serverPacketLength) {
						var16 = var3.readUnsignedByte();
						class185 var55 = WorldMapDecoration.method327()[var16];
						JagexCache.method3438(var55);
					}

					var1.serverPacket = null;
					return true;
				}

				Widget var52;
				if (ServerPacket.field2136 == var1.serverPacket) {
					var16 = var3.method5414();
					var52 = WorldMapElement.getWidget(var16);
					var52.modelType = 3;
					var52.modelId = WorldMapIcon_1.localPlayer.appearance.getChatHeadId();
					FriendSystem.invalidateWidget(var52);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2112 == var1.serverPacket) {
					JagexCache.method3438(class185.field2301);
					var1.serverPacket = null;
					return true;
				}

				int var10;
				if (ServerPacket.field2180 == var1.serverPacket) {
					isCameraLocked = true;
					WorldMapSection2.field190 = var3.readUnsignedByte() * 128;
					UrlRequest.field1932 = var3.readUnsignedByte() * 16384;
					GameShell.field446 = var3.readUnsignedShort();
					GrandExchangeOfferWorldComparator.field34 = var3.readUnsignedByte();
					Player.field605 = var3.readUnsignedByte();
					if (Player.field605 >= 100) {
						var16 = WorldMapSection2.field190 * 16384 + 64;
						var5 = UrlRequest.field1932 * 128 + 64;
						var6 = GrandExchangeOfferTotalQuantityComparator.getTileHeight(var16, var5, ItemContainer.plane) - GameShell.field446;
						var18 = var16 - WallDecoration.cameraX;
						var20 = var6 - Coord.cameraY;
						var9 = var5 - UserComparator7.cameraZ;
						var10 = (int)Math.sqrt((double)(var18 * var18 + var9 * var9));
						class43.cameraPitch = (int)(Math.atan2((double)var20, (double)var10) * 325.949D) & 2047;
						class40.cameraYaw = (int)(Math.atan2((double)var18, (double)var9) * -325.949D) & 2047;
						if (class43.cameraPitch < 128) {
							class43.cameraPitch = 128;
						}

						if (class43.cameraPitch > 383) {
							class43.cameraPitch = 383;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2121 == var1.serverPacket) {
					var16 = var3.method5455();
					var5 = var3.method5446();
					var6 = var5 >> 10 & 31;
					var18 = var5 >> 5 & 31;
					var20 = var5 & 31;
					var9 = (var18 << 11) + (var6 << 19) + (var20 << 3);
					Widget var58 = WorldMapElement.getWidget(var16);
					if (var9 != var58.color) {
						var58.color = var9;
						FriendSystem.invalidateWidget(var58);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2171 == var1.serverPacket) {
					minimapState = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2178 == var1.serverPacket) {
					JagexCache.method3438(class185.field2297);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2166 == var1.serverPacket) {
					for (var16 = 0; var16 < Varps.Varps_main.length; ++var16) {
						if (Varps.Varps_main[var16] != Varps.Varps_temp[var16]) {
							Varps.Varps_main[var16] = Varps.Varps_temp[var16];
							ObjectSound.method1837(var16);
							field809[++field800 - 1 & 31] = var16;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2110 == var1.serverPacket) {
					var38 = var3.readStringCp1252NullTerminated();
					Object[] var54 = new Object[var38.length() + 1];

					for (var6 = var38.length() - 1; var6 >= 0; --var6) {
						if (var38.charAt(var6) == 's') {
							var54[var6 + 1] = var3.readStringCp1252NullTerminated();
						} else {
							var54[var6 + 1] = new Integer(var3.readInt());
						}
					}

					var54[0] = new Integer(var3.readInt());
					ScriptEvent var50 = new ScriptEvent();
					var50.args = var54;
					class81.runScriptEvent(var50);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2163 == var1.serverPacket) {
					class32.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
					InterfaceParent.FriendSystem_invalidateIgnoreds();
					field629 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				Widget var41;
				if (ServerPacket.field2115 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var5 == 65535) {
						var5 = -1;
					}

					var6 = var3.method5414();
					var41 = WorldMapElement.getWidget(var16);
					ItemDefinition var42;
					if (!var41.isIf3) {
						if (var5 == -1) {
							var41.modelType = 0;
							var1.serverPacket = null;
							return true;
						}

						var42 = WorldMapData_0.ItemDefinition_get(var5);
						var41.modelType = 4;
						var41.modelId = var5;
						var41.modelAngleX = var42.xan2d;
						var41.modelAngleY = var42.yan2d;
						var41.modelZoom = var42.zoom2d * 100 / var6;
						FriendSystem.invalidateWidget(var41);
					} else {
						var41.itemId = var5;
						var41.itemQuantity = var6;
						var42 = WorldMapData_0.ItemDefinition_get(var5);
						var41.modelAngleX = var42.xan2d;
						var41.modelAngleY = var42.yan2d;
						var41.modelAngleZ = var42.zan2d;
						var41.modelOffsetX = var42.offsetX2d;
						var41.modelOffsetY = var42.offsetY2d;
						var41.modelZoom = var42.zoom2d;
						if (var42.isStackable == 1) {
							var41.itemQuantityMode = 1;
						} else {
							var41.itemQuantityMode = 2;
						}

						if (var41.field2638 > 0) {
							var41.modelZoom = var41.modelZoom * 32 / var41.field2638;
						} else if (var41.rawWidth > 0) {
							var41.modelZoom = var41.modelZoom * 32 / var41.rawWidth;
						}

						FriendSystem.invalidateWidget(var41);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2132 == var1.serverPacket) {
					var16 = var3.readShort();
					var5 = var3.method5414();
					var17 = WorldMapElement.getWidget(var5);
					if (var16 != var17.sequenceId || var16 == -1) {
						var17.sequenceId = var16;
						var17.modelFrame = 0;
						var17.modelFrameCycle = 0;
						FriendSystem.invalidateWidget(var17);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2146 == var1.serverPacket) {
					JagexCache.method3438(class185.field2300);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2161 == var1.serverPacket) {
					JagexCache.method3438(class185.field2304);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2117 == var1.serverPacket) {
					GrandExchangeOffer.updateNpcs(false, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2104 == var1.serverPacket) {
					byte[] var39 = new byte[var1.serverPacketLength];
					var3.method5384(var39, 0, var39.length);
					Buffer var53 = new Buffer(var39);
					var49 = var53.readStringCp1252NullTerminated();
					GameObject.openURL(var49, true, false);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2168 == var1.serverPacket) {
					WorldMapIcon_0.method207();
					weight = var3.readShort();
					field820 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2097 == var1.serverPacket) {
					var3.offset += 28;
					if (var3.checkCrc()) {
						Login.method2031(var3, var3.offset - 28);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2172 == var1.serverPacket) {
					isCameraLocked = true;
					GraphicsObject.field1079 = var3.readUnsignedByte() * 16384;
					class3.field24 = var3.readUnsignedByte() * 16384;
					WorldMapSection0.field129 = var3.readUnsignedShort();
					WorldMapSectionType.field142 = var3.readUnsignedByte();
					WorldMapSection2.field191 = var3.readUnsignedByte();
					if (WorldMapSection2.field191 >= 100) {
						WallDecoration.cameraX = GraphicsObject.field1079 * 128 + 64;
						UserComparator7.cameraZ = class3.field24 * 128 + 64;
						Coord.cameraY = GrandExchangeOfferTotalQuantityComparator.getTileHeight(WallDecoration.cameraX, UserComparator7.cameraZ, ItemContainer.plane) - WorldMapSection0.field129;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2101 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.readInt();
					Varps.Varps_temp[var16] = var5;
					if (Varps.Varps_main[var16] != var5) {
						Varps.Varps_main[var16] = var5;
					}

					ObjectSound.method1837(var16);
					field809[++field800 - 1 & 31] = var16;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2160 == var1.serverPacket) {
					byte var56 = var3.method5616();
					var5 = var3.method5446();
					Varps.Varps_temp[var5] = var56;
					if (Varps.Varps_main[var5] != var56) {
						Varps.Varps_main[var5] = var56;
					}

					ObjectSound.method1837(var5);
					field809[++field800 - 1 & 31] = var5;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2142 == var1.serverPacket) {
					if (clanChat != null) {
						clanChat.method5135(var3);
					}

					FaceNormal.method3221();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2123 == var1.serverPacket) {
					JagexCache.method3438(class185.field2303);
					var1.serverPacket = null;
					return true;
				}

				long var12;
				if (ServerPacket.field2162 == var1.serverPacket) {
					var16 = var3.offset + var1.serverPacketLength;
					var5 = var3.readUnsignedShort();
					var6 = var3.readUnsignedShort();
					if (var5 != rootInterface) {
						rootInterface = var5;
						this.resizeRoot(false);
						WorldMapSectionType.Widget_resetModelFrames(rootInterface);
						class51.runWidgetOnLoadListener(rootInterface);

						for (var18 = 0; var18 < 100; ++var18) {
							field703[var18] = true;
						}
					}

					InterfaceParent var21;
					for (; var6-- > 0; var21.field540 = true) {
						var18 = var3.readInt();
						var20 = var3.readUnsignedShort();
						var9 = var3.readUnsignedByte();
						var21 = (InterfaceParent)interfaceParents.get((long)var18);
						if (var21 != null && var20 != var21.group) {
							VarpDefinition.closeInterface(var21, true);
							var21 = null;
						}

						if (var21 == null) {
							var21 = NPC.method1967(var18, var20, var9);
						}
					}

					for (var7 = (InterfaceParent)interfaceParents.first(); var7 != null; var7 = (InterfaceParent)interfaceParents.next()) {
						if (var7.field540) {
							var7.field540 = false;
						} else {
							VarpDefinition.closeInterface(var7, true);
						}
					}

					widgetClickMasks = new NodeHashTable(512);

					while (var3.offset < var16) {
						var18 = var3.readInt();
						var20 = var3.readUnsignedShort();
						var9 = var3.readUnsignedShort();
						var10 = var3.readInt();

						for (int var11 = var20; var11 <= var9; ++var11) {
							var12 = (long)var11 + ((long)var18 << 32);
							widgetClickMasks.put(new IntegerNode(var10), var12);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2156 == var1.serverPacket) {
					var16 = var3.method5455();
					var5 = var3.method5434();
					var6 = var3.method5448();
					var41 = WorldMapElement.getWidget(var16);
					if (var6 != var41.rawX || var5 != var41.rawY || var41.xAlignment != 0 || var41.yAlignment != 0) {
						var41.rawX = var6;
						var41.rawY = var5;
						var41.xAlignment = 0;
						var41.yAlignment = 0;
						FriendSystem.invalidateWidget(var41);
						this.alignWidget(var41);
						if (var41.type == 0) {
							WorldMapAreaData.revalidateWidgetScroll(Widget.Widget_interfaceComponents[var16 >> 16], var41, false);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2119 == var1.serverPacket) {
					WorldMapIcon_0.method207();
					var16 = var3.method5505();
					var5 = var3.readUnsignedByteNegate();
					var6 = var3.readUnsignedByte();
					experience[var5] = var16;
					currentLevels[var5] = var6;
					levels[var5] = 1;

					for (var18 = 0; var18 < 98; ++var18) {
						if (var16 >= Skills.Skills_experienceTable[var18]) {
							levels[var5] = var18 + 2;
						}
					}

					changedSkills[++changedSkillsCount - 1 & 31] = var5;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2176 == var1.serverPacket) {
					class30.updatePlayers(var3, var1.serverPacketLength);
					WorldMapSection0.method230();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2131 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					AbstractWorldMapData.method272(var16);
					var1.serverPacket = null;
					return true;
				}

				long var22;
				if (ServerPacket.field2145 == var1.serverPacket) {
					var16 = var3.method5505();
					var5 = var3.method5446();
					if (var5 == 65535) {
						var5 = -1;
					}

					var6 = var3.method5414();
					var18 = var3.readUnsignedShort();
					if (var18 == 65535) {
						var18 = -1;
					}

					for (var20 = var18; var20 <= var5; ++var20) {
						var22 = (long)var20 + ((long)var6 << 32);
						Node var60 = widgetClickMasks.get(var22);
						if (var60 != null) {
							var60.remove();
						}

						widgetClickMasks.put(new IntegerNode(var16), var22);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2138 == var1.serverPacket) {
					var16 = var3.method5446();
					var5 = var3.method5445();
					var6 = var3.method5455();
					var41 = WorldMapElement.getWidget(var6);
					var41.field2602 = var16 + (var5 << 16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2157 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readInt();
					InterfaceParent var47 = (InterfaceParent)interfaceParents.get((long)var5);
					var7 = (InterfaceParent)interfaceParents.get((long)var16);
					if (var7 != null) {
						VarpDefinition.closeInterface(var7, var47 == null || var7.group != var47.group);
					}

					if (var47 != null) {
						var47.remove();
						interfaceParents.put(var47, (long)var16);
					}

					var8 = WorldMapElement.getWidget(var5);
					if (var8 != null) {
						FriendSystem.invalidateWidget(var8);
					}

					var8 = WorldMapElement.getWidget(var16);
					if (var8 != null) {
						FriendSystem.invalidateWidget(var8);
						WorldMapAreaData.revalidateWidgetScroll(Widget.Widget_interfaceComponents[var8.id >>> 16], var8, true);
					}

					if (rootInterface != -1) {
						UserComparator6.runIntfCloseListeners(rootInterface, 1);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2167 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var16 < -70000) {
						var5 += 32768;
					}

					if (var16 >= 0) {
						var17 = WorldMapElement.getWidget(var16);
					} else {
						var17 = null;
					}

					if (var17 != null) {
						for (var18 = 0; var18 < var17.itemIds.length; ++var18) {
							var17.itemIds[var18] = 0;
							var17.itemQuantities[var18] = 0;
						}
					}

					class13.clearItemContainer(var5);
					var18 = var3.readUnsignedShort();

					for (var20 = 0; var20 < var18; ++var20) {
						var9 = var3.readUnsignedShort();
						var10 = var3.readUnsignedByte();
						if (var10 == 255) {
							var10 = var3.method5414();
						}

						if (var17 != null && var20 < var17.itemIds.length) {
							var17.itemIds[var20] = var9;
							var17.itemQuantities[var20] = var10;
						}

						Canvas.itemContainerSetItem(var5, var20, var9 - 1, var10);
					}

					if (var17 != null) {
						FriendSystem.invalidateWidget(var17);
					}

					WorldMapIcon_0.method207();
					field811[++field812 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2103 == var1.serverPacket) {
					WorldMapSection1.field283 = var3.readUnsignedByteNegate();
					Varps.field2507 = var3.method5438();
					var1.serverPacket = null;
					return true;
				}

				long var25;
				long var27;
				if (ServerPacket.field2107 == var1.serverPacket) {
					var38 = var3.readStringCp1252NullTerminated();
					var25 = (long)var3.readUnsignedShort();
					var27 = (long)var3.readMedium();
					PlayerType var29 = (PlayerType)FriendSystem.findEnumerated(class191.PlayerType_values(), var3.readUnsignedByte());
					long var30 = (var25 << 32) + var27;
					boolean var32 = false;

					for (int var13 = 0; var13 < 100; ++var13) {
						if (field842[var13] == var30) {
							var32 = true;
							break;
						}
					}

					if (class32.friendSystem.isIgnored(new Username(var38, FontName.loginType))) {
						var32 = true;
					}

					if (!var32 && field737 == 0) {
						field842[field843] = var30;
						field843 = (field843 + 1) % 100;
						String var33 = AbstractFont.escapeBrackets(class189.method3596(class51.method845(var3)));
						byte var45;
						if (var29.isPrivileged) {
							var45 = 7;
						} else {
							var45 = 3;
						}

						if (var29.modIcon * 714577229 != -1) {
							DirectByteArrayCopier.addGameMessage(var45, AbstractWorldMapData.method278(var29.modIcon * 714577229) + var38, var33);
						} else {
							DirectByteArrayCopier.addGameMessage(var45, var38, var33);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2149 == var1.serverPacket) {
					if (rootInterface != -1) {
						UserComparator6.runIntfCloseListeners(rootInterface, 0);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2137 == var1.serverPacket) {
					var48 = var3.readBoolean();
					if (var48) {
						if (GameObject.field1921 == null) {
							GameObject.field1921 = new class237();
						}
					} else {
						GameObject.field1921 = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2169 == var1.serverPacket) {
					rebootTimer = var3.readUnsignedShort() * 30;
					field820 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2127 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedShort();
					GrandExchangeOfferUnitPriceComparator.queueSoundEffect(var16, var5, var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2130 == var1.serverPacket) {
					var16 = var3.method5447();
					var5 = var3.method5414();
					var17 = WorldMapElement.getWidget(var5);
					if (var17.modelType != 2 || var16 != var17.modelId) {
						var17.modelType = 2;
						var17.modelId = var16;
						FriendSystem.invalidateWidget(var17);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2158 == var1.serverPacket) {
					var16 = var3.method5455();
					var52 = WorldMapElement.getWidget(var16);

					for (var6 = 0; var6 < var52.itemIds.length; ++var6) {
						var52.itemIds[var6] = -1;
						var52.itemIds[var6] = 0;
					}

					FriendSystem.invalidateWidget(var52);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2140 == var1.serverPacket) {
					if (var1.serverPacketLength == 0) {
						clanChat = null;
					} else {
						if (clanChat == null) {
							clanChat = new ClanChat(FontName.loginType, WorldMapID.client);
						}

						clanChat.readUpdate(var3);
					}

					FaceNormal.method3221();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2151 == var1.serverPacket) {
					var38 = var3.readStringCp1252NullTerminated();
					var25 = var3.readLong();
					var27 = (long)var3.readUnsignedShort();
					var22 = (long)var3.readMedium();
					PlayerType var24 = (PlayerType)FriendSystem.findEnumerated(class191.PlayerType_values(), var3.readUnsignedByte());
					var12 = var22 + (var27 << 32);
					boolean var14 = false;

					for (int var15 = 0; var15 < 100; ++var15) {
						if (field842[var15] == var12) {
							var14 = true;
							break;
						}
					}

					if (var24.isUser && class32.friendSystem.isIgnored(new Username(var38, FontName.loginType))) {
						var14 = true;
					}

					if (!var14 && field737 == 0) {
						field842[field843] = var12;
						field843 = (field843 + 1) % 100;
						String var34 = AbstractFont.escapeBrackets(class189.method3596(class51.method845(var3)));
						if (var24.modIcon * 714577229 != -1) {
							MilliClock.addChatMessage(9, AbstractWorldMapData.method278(var24.modIcon * 714577229) + var38, var34, class266.base37DecodeLong(var25));
						} else {
							MilliClock.addChatMessage(9, var38, var34, class266.base37DecodeLong(var25));
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2100 == var1.serverPacket) {
					JagexCache.method3438(class185.field2305);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2099 == var1.serverPacket) {
					isCameraLocked = false;

					for (var16 = 0; var16 < 5; ++var16) {
						field897[var16] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2153 == var1.serverPacket) {
					for (var16 = 0; var16 < VarpDefinition.VarpDefinition_fileCount; ++var16) {
						VarpDefinition var51 = class16.method180(var16);
						if (var51 != null) {
							Varps.Varps_temp[var16] = 0;
							Varps.Varps_main[var16] = 0;
						}
					}

					WorldMapIcon_0.method207();
					field800 += 32;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2144 == var1.serverPacket) {
					World var37 = new World();
					var37.host = var3.readStringCp1252NullTerminated();
					var37.id = var3.readUnsignedShort();
					var5 = var3.readInt();
					var37.properties = var5;
					FloorDecoration.updateGameState(45);
					var2.close();
					var2 = null;
					class65.changeWorld(var37);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2116 == var1.serverPacket) {
					var16 = var3.readInt();
					var19 = var3.readStringCp1252NullTerminated();
					var17 = WorldMapElement.getWidget(var16);
					if (!var19.equals(var17.text)) {
						var17.text = var19;
						FriendSystem.invalidateWidget(var17);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2105 == var1.serverPacket) {
					JagexCache.method3438(class185.field2299);
					var1.serverPacket = null;
					return true;
				}

				class3.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1296 != null ? var1.field1296.id : -1) + "," + (var1.field1291 != null ? var1.field1291.id : -1) + "," + var1.serverPacketLength, (Throwable)null);
				class65.method1182();
			} catch (IOException var35) {
				class2.method31();
			} catch (Exception var36) {
				var19 = "" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1296 != null ? var1.field1296.id : -1) + "," + (var1.field1291 != null ? var1.field1291.id : -1) + "," + var1.serverPacketLength + "," + (WorldMapIcon_1.localPlayer.pathX[0] + PacketWriter.baseX * 64) + "," + (WorldMapIcon_1.localPlayer.pathY[0] + RouteStrategy.baseY * 64) + ",";

				for (var6 = 0; var6 < var1.serverPacketLength && var6 < 50; ++var6) {
					var19 = var19 + var3.array[var6] + ",";
				}

				class3.RunException_sendStackTrace(var19, var36);
				class65.method1182();
			}

			return true;
		}
	}

	@ObfuscatedName("ho")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	final void method1293() {
		WorldMapID.method537();
		if (class188.dragInventoryWidget == null) {
			if (clickedWidget == null) {
				int var2;
				int var4;
				int var5;
				int var10;
				int var19;
				label274: {
					int var1 = MouseHandler.MouseHandler_lastButton;
					int var3;
					int var6;
					int var8;
					if (isMenuOpen) {
						if (var1 != 1 && (FriendSystem.mouseCam || var1 != 4)) {
							var2 = MouseHandler.MouseHandler_x;
							var3 = MouseHandler.MouseHandler_y;
							if (var2 < MilliClock.menuX - 10 || var2 > World.menuWidth + MilliClock.menuX + 10 || var3 < class96.menuY - 10 || var3 > class1.menuHeight + class96.menuY + 10) {
								isMenuOpen = false;
								FloorDecoration.method2786(MilliClock.menuX, class96.menuY, World.menuWidth, class1.menuHeight);
							}
						}

						if (var1 == 1 || !FriendSystem.mouseCam && var1 == 4) {
							var2 = MilliClock.menuX;
							var3 = class96.menuY;
							var4 = World.menuWidth;
							var5 = MouseHandler.MouseHandler_lastPressedX;
							var6 = MouseHandler.MouseHandler_lastPressedY;
							int var18 = -1;

							for (var8 = 0; var8 < menuOptionsCount; ++var8) {
								var19 = var3 + (menuOptionsCount - 1 - var8) * 15 + 31;
								if (var5 > var2 && var5 < var4 + var2 && var6 > var19 - 13 && var6 < var19 + 3) {
									var18 = var8;
								}
							}

							if (var18 != -1 && var18 >= 0) {
								var8 = menuArguments1[var18];
								var19 = menuArguments2[var18];
								var10 = menuOpcodes[var18];
								int var17 = menuIdentifiers[var18];
								String var12 = menuActions[var18];
								String var13 = menuTargets[var18];
								SecureRandomFuture.menuAction(var8, var19, var10, var17, var12, var13, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
							}

							isMenuOpen = false;
							FloorDecoration.method2786(MilliClock.menuX, class96.menuY, World.menuWidth, class1.menuHeight);
						}
					} else {
						var2 = Player.getNewestMenuIdx();
						if ((var1 == 1 || !FriendSystem.mouseCam && var1 == 4) && var2 >= 0) {
							var3 = menuOpcodes[var2];
							if (var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
								var4 = menuArguments1[var2];
								var5 = menuArguments2[var2];
								Widget var14 = WorldMapElement.getWidget(var5);
								var8 = ParamDefinition.getWidgetClickMask(var14);
								boolean var7 = (var8 >> 28 & 1) != 0;
								if (var7) {
									break label274;
								}

								var10 = ParamDefinition.getWidgetClickMask(var14);
								boolean var9 = (var10 >> 29 & 1) != 0;
								if (var9) {
									break label274;
								}
							}
						}

						if ((var1 == 1 || !FriendSystem.mouseCam && var1 == 4) && this.shouldLeftClickOpenMenu()) {
							var1 = 2;
						}

						if ((var1 == 1 || !FriendSystem.mouseCam && var1 == 4) && menuOptionsCount > 0 && var2 >= 0) {
							var3 = menuArguments1[var2];
							var4 = menuArguments2[var2];
							var5 = menuOpcodes[var2];
							var6 = menuIdentifiers[var2];
							String var15 = menuActions[var2];
							String var16 = menuTargets[var2];
							SecureRandomFuture.menuAction(var3, var4, var5, var6, var15, var16, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
						}

						if (var1 == 2 && menuOptionsCount > 0) {
							this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
						}
					}

					return;
				}

				if (class188.dragInventoryWidget != null && !field867 && menuOptionsCount > 0 && !this.shouldLeftClickOpenMenu()) {
					var19 = field732;
					var10 = field744;
					MenuAction var11 = class1.tempMenuAction;
					SecureRandomFuture.menuAction(var11.argument1, var11.argument2, var11.opcode, var11.argument0, var11.action, var11.action, var19, var10);
					class1.tempMenuAction = null;
				}

				field867 = false;
				itemDragDuration = 0;
				if (class188.dragInventoryWidget != null) {
					FriendSystem.invalidateWidget(class188.dragInventoryWidget);
				}

				class188.dragInventoryWidget = WorldMapElement.getWidget(var5);
				dragItemSlotSource = var4;
				field732 = MouseHandler.MouseHandler_lastPressedX;
				field744 = MouseHandler.MouseHandler_lastPressedY;
				if (var2 >= 0) {
					class1.tempMenuAction = new MenuAction();
					class1.tempMenuAction.argument1 = menuArguments1[var2];
					class1.tempMenuAction.argument2 = menuArguments2[var2];
					class1.tempMenuAction.opcode = menuOpcodes[var2];
					class1.tempMenuAction.argument0 = menuIdentifiers[var2];
					class1.tempMenuAction.action = menuActions[var2];
				}

				FriendSystem.invalidateWidget(class188.dragInventoryWidget);
			}
		}
	}

	@ObfuscatedName("hf")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1478367843"
	)
	@Export("shouldLeftClickOpenMenu")
	final boolean shouldLeftClickOpenMenu() {
		int var1 = Player.getNewestMenuIdx();
		return (leftClickOpensMenu == 1 && menuOptionsCount > 2 || ClientPacket.isRightClickOnlyMenu(var1)) && !menuShiftClick[var1];
	}

	@ObfuscatedName("hu")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "7"
	)
	@Export("openMenu")
	final void openMenu(int var1, int var2) {
		WorldMapData_1.calculateMenuBounds(var1, var2);
		Player.scene.menuOpen(ItemContainer.plane, var1, var2, false);
		isMenuOpen = true;
	}

	@ObfuscatedName("ir")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "1310115319"
	)
	@Export("resizeRoot")
	final void resizeRoot(boolean var1) {
		GrandExchangeOfferNameComparator.resizeComponents(rootInterface, KitDefinition.canvasWidth, class30.canvasHeight, var1);
	}

	@ObfuscatedName("io")
	@ObfuscatedSignature(
		signature = "(Lhp;B)V",
		garbageValue = "53"
	)
	@Export("alignWidget")
	void alignWidget(Widget var1) {
		Widget var2 = var1.parentId == -1 ? null : WorldMapElement.getWidget(var1.parentId);
		int var3;
		int var4;
		if (var2 == null) {
			var3 = KitDefinition.canvasWidth;
			var4 = class30.canvasHeight;
		} else {
			var3 = var2.width;
			var4 = var2.height;
		}

		NetSocket.alignWidgetSize(var1, var3, var4, false);
		Message.alignWidgetPosition(var1, var3, var4);
	}

	@ObfuscatedName("ju")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1084041497"
	)
	final void method1615() {
		FriendSystem.invalidateWidget(clickedWidget);
		++class60.widgetDragDuration;
		if (field804 && field641) {
			int var1 = MouseHandler.MouseHandler_x;
			int var2 = MouseHandler.MouseHandler_y;
			var1 -= widgetClickX;
			var2 -= widgetClickY;
			if (var1 < field802) {
				var1 = field802;
			}

			if (var1 + clickedWidget.width > field802 + clickedWidgetParent.width) {
				var1 = field802 + clickedWidgetParent.width - clickedWidget.width;
			}

			if (var2 < field803) {
				var2 = field803;
			}

			if (var2 + clickedWidget.height > field803 + clickedWidgetParent.height) {
				var2 = field803 + clickedWidgetParent.height - clickedWidget.height;
			}

			int var3 = var1 - field805;
			int var4 = var2 - field806;
			int var5 = clickedWidget.dragZoneSize;
			if (class60.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
				isDraggingWidget = true;
			}

			int var6 = var1 - field802 + clickedWidgetParent.scrollX;
			int var7 = var2 - field803 + clickedWidgetParent.scrollY;
			ScriptEvent var8;
			if (clickedWidget.onDrag != null && isDraggingWidget) {
				var8 = new ScriptEvent();
				var8.widget = clickedWidget;
				var8.mouseX = var6;
				var8.mouseY = var7;
				var8.args = clickedWidget.onDrag;
				class81.runScriptEvent(var8);
			}

			if (MouseHandler.MouseHandler_currentButton == 0) {
				if (isDraggingWidget) {
					if (clickedWidget.onDragComplete != null) {
						var8 = new ScriptEvent();
						var8.widget = clickedWidget;
						var8.mouseX = var6;
						var8.mouseY = var7;
						var8.dragTarget = draggedOnWidget;
						var8.args = clickedWidget.onDragComplete;
						class81.runScriptEvent(var8);
					}

					if (draggedOnWidget != null && AbstractByteArrayCopier.method3871(clickedWidget) != null) {
						PacketBufferNode var9 = MenuAction.getPacketBufferNode(ClientPacket.field2213, packetWriter.isaacCipher);
						var9.packetBuffer.method5443(clickedWidget.childIndex);
						var9.packetBuffer.method5443(draggedOnWidget.itemId);
						var9.packetBuffer.writeShort(draggedOnWidget.childIndex);
						var9.packetBuffer.writeIntLE(clickedWidget.id);
						var9.packetBuffer.writeIntME(draggedOnWidget.id);
						var9.packetBuffer.writeShort(clickedWidget.itemId);
						packetWriter.addNode(var9);
					}
				} else if (this.shouldLeftClickOpenMenu()) {
					this.openMenu(field805 + widgetClickX, field806 + widgetClickY);
				} else if (menuOptionsCount > 0) {
					ScriptFrame.method1092(field805 + widgetClickX, field806 + widgetClickY);
				}

				clickedWidget = null;
			}

		} else {
			if (class60.widgetDragDuration > 1) {
				clickedWidget = null;
			}

		}
	}

	@ObfuscatedName("kk")
	@ObfuscatedSignature(
		signature = "(I)Ljx;",
		garbageValue = "962934553"
	)
	@Export("username")
	public Username username() {
		return WorldMapIcon_1.localPlayer != null ? WorldMapIcon_1.localPlayer.username : null;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIIIIIILea;Lfm;I)V",
		garbageValue = "1851683520"
	)
	@Export("addPendingGameObject")
	static final void addPendingGameObject(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Scene var7, CollisionMap var8) {
		ObjectDefinition var9 = class215.getObjectDefinition(var4);
		int var10;
		int var11;
		if (var5 != 1 && var5 != 3) {
			var10 = var9.sizeX;
			var11 = var9.sizeY;
		} else {
			var10 = var9.sizeY;
			var11 = var9.sizeX;
		}

		int var12;
		int var13;
		if (var10 + var2 <= 104) {
			var12 = (var10 >> 1) + var2;
			var13 = var2 + (var10 + 1 >> 1);
		} else {
			var12 = var2;
			var13 = var2 + 1;
		}

		int var14;
		int var15;
		if (var3 + var11 <= 104) {
			var14 = var3 + (var11 >> 1);
			var15 = var3 + (var11 + 1 >> 1);
		} else {
			var14 = var3;
			var15 = var3 + 1;
		}

		int[][] var16 = Tiles.Tiles_heights[var1];
		int var17 = var16[var13][var15] + var16[var12][var15] + var16[var13][var14] + var16[var12][var14] >> 2;
		int var18 = (var2 << 7) + (var10 << 6);
		int var19 = (var3 << 7) + (var11 << 6);
		long var20 = WorldMapSprite.calculateTag(var2, var3, 2, var9.int1 == 0, var4);
		int var22 = (var5 << 6) + var6;
		if (var9.int3 == 1) {
			var22 += 256;
		}

		Object var23;
		if (var6 == 22) {
			if (var9.animationId == -1 && var9.transforms == null) {
				var23 = var9.getModel(22, var5, var16, var18, var17, var19);
			} else {
				var23 = new DynamicObject(var4, 22, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
			}

			var7.newFloorDecoration(var0, var2, var3, var17, (Entity)var23, var20, var22);
			if (var9.interactType == 1) {
				var8.setBlockedByFloorDec(var2, var3);
			}

		} else if (var6 != 10 && var6 != 11) {
			if (var6 >= 12) {
				if (var9.animationId == -1 && var9.transforms == null) {
					var23 = var9.getModel(var6, var5, var16, var18, var17, var19);
				} else {
					var23 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
				}

				var7.method3013(var0, var2, var3, var17, 1, 1, (Entity)var23, 0, var20, var22);
				if (var9.interactType != 0) {
					var8.addGameObject(var2, var3, var10, var11, var9.boolean1);
				}

			} else if (var6 == 0) {
				if (var9.animationId == -1 && var9.transforms == null) {
					var23 = var9.getModel(0, var5, var16, var18, var17, var19);
				} else {
					var23 = new DynamicObject(var4, 0, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
				}

				var7.newBoundaryObject(var0, var2, var3, var17, (Entity)var23, (Entity)null, Tiles.field479[var5], 0, var20, var22);
				if (var9.interactType != 0) {
					var8.method3495(var2, var3, var6, var5, var9.boolean1);
				}

			} else if (var6 == 1) {
				if (var9.animationId == -1 && var9.transforms == null) {
					var23 = var9.getModel(1, var5, var16, var18, var17, var19);
				} else {
					var23 = new DynamicObject(var4, 1, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
				}

				var7.newBoundaryObject(var0, var2, var3, var17, (Entity)var23, (Entity)null, Tiles.field480[var5], 0, var20, var22);
				if (var9.interactType != 0) {
					var8.method3495(var2, var3, var6, var5, var9.boolean1);
				}

			} else {
				int var29;
				if (var6 == 2) {
					var29 = var5 + 1 & 3;
					Object var24;
					Object var25;
					if (var9.animationId == -1 && var9.transforms == null) {
						var24 = var9.getModel(2, var5 + 4, var16, var18, var17, var19);
						var25 = var9.getModel(2, var29, var16, var18, var17, var19);
					} else {
						var24 = new DynamicObject(var4, 2, var5 + 4, var1, var2, var3, var9.animationId, true, (Entity)null);
						var25 = new DynamicObject(var4, 2, var29, var1, var2, var3, var9.animationId, true, (Entity)null);
					}

					var7.newBoundaryObject(var0, var2, var3, var17, (Entity)var24, (Entity)var25, Tiles.field479[var5], Tiles.field479[var29], var20, var22);
					if (var9.interactType != 0) {
						var8.method3495(var2, var3, var6, var5, var9.boolean1);
					}

				} else if (var6 == 3) {
					if (var9.animationId == -1 && var9.transforms == null) {
						var23 = var9.getModel(3, var5, var16, var18, var17, var19);
					} else {
						var23 = new DynamicObject(var4, 3, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
					}

					var7.newBoundaryObject(var0, var2, var3, var17, (Entity)var23, (Entity)null, Tiles.field480[var5], 0, var20, var22);
					if (var9.interactType != 0) {
						var8.method3495(var2, var3, var6, var5, var9.boolean1);
					}

				} else if (var6 == 9) {
					if (var9.animationId == -1 && var9.transforms == null) {
						var23 = var9.getModel(var6, var5, var16, var18, var17, var19);
					} else {
						var23 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
					}

					var7.method3013(var0, var2, var3, var17, 1, 1, (Entity)var23, 0, var20, var22);
					if (var9.interactType != 0) {
						var8.addGameObject(var2, var3, var10, var11, var9.boolean1);
					}

				} else if (var6 == 4) {
					if (var9.animationId == -1 && var9.transforms == null) {
						var23 = var9.getModel(4, var5, var16, var18, var17, var19);
					} else {
						var23 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
					}

					var7.newWallDecoration(var0, var2, var3, var17, (Entity)var23, (Entity)null, Tiles.field479[var5], 0, 0, 0, var20, var22);
				} else {
					Object var26;
					long var30;
					if (var6 == 5) {
						var29 = 16;
						var30 = var7.getBoundaryObjectTag(var0, var2, var3);
						if (0L != var30) {
							var29 = class215.getObjectDefinition(BoundaryObject.Entity_unpackID(var30)).int2;
						}

						if (var9.animationId == -1 && var9.transforms == null) {
							var26 = var9.getModel(4, var5, var16, var18, var17, var19);
						} else {
							var26 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
						}

						var7.newWallDecoration(var0, var2, var3, var17, (Entity)var26, (Entity)null, Tiles.field479[var5], 0, var29 * Tiles.field481[var5], var29 * Tiles.field482[var5], var20, var22);
					} else if (var6 == 6) {
						var29 = 8;
						var30 = var7.getBoundaryObjectTag(var0, var2, var3);
						if (var30 != 0L) {
							var29 = class215.getObjectDefinition(BoundaryObject.Entity_unpackID(var30)).int2 / 2;
						}

						if (var9.animationId == -1 && var9.transforms == null) {
							var26 = var9.getModel(4, var5 + 4, var16, var18, var17, var19);
						} else {
							var26 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Entity)null);
						}

						var7.newWallDecoration(var0, var2, var3, var17, (Entity)var26, (Entity)null, 256, var5, var29 * Tiles.field478[var5], var29 * Tiles.field484[var5], var20, var22);
					} else if (var6 == 7) {
						int var32 = var5 + 2 & 3;
						if (var9.animationId == -1 && var9.transforms == null) {
							var23 = var9.getModel(4, var32 + 4, var16, var18, var17, var19);
						} else {
							var23 = new DynamicObject(var4, 4, var32 + 4, var1, var2, var3, var9.animationId, true, (Entity)null);
						}

						var7.newWallDecoration(var0, var2, var3, var17, (Entity)var23, (Entity)null, 256, var32, 0, 0, var20, var22);
					} else if (var6 == 8) {
						var29 = 8;
						var30 = var7.getBoundaryObjectTag(var0, var2, var3);
						if (var30 != 0L) {
							var29 = class215.getObjectDefinition(BoundaryObject.Entity_unpackID(var30)).int2 / 2;
						}

						int var28 = var5 + 2 & 3;
						Object var27;
						if (var9.animationId == -1 && var9.transforms == null) {
							var26 = var9.getModel(4, var5 + 4, var16, var18, var17, var19);
							var27 = var9.getModel(4, var28 + 4, var16, var18, var17, var19);
						} else {
							var26 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Entity)null);
							var27 = new DynamicObject(var4, 4, var28 + 4, var1, var2, var3, var9.animationId, true, (Entity)null);
						}

						var7.newWallDecoration(var0, var2, var3, var17, (Entity)var26, (Entity)var27, 256, var5, var29 * Tiles.field478[var5], var29 * Tiles.field484[var5], var20, var22);
					}
				}
			}
		} else {
			if (var9.animationId == -1 && var9.transforms == null) {
				var23 = var9.getModel(10, var5, var16, var18, var17, var19);
			} else {
				var23 = new DynamicObject(var4, 10, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
			}

			if (var23 != null) {
				var7.method3013(var0, var2, var3, var17, var10, var11, (Entity)var23, var6 == 11 ? 256 : 0, var20, var22);
			}

			if (var9.interactType != 0) {
				var8.addGameObject(var2, var3, var10, var11, var9.boolean1);
			}

		}
	}

	static void abv(int var0) {
		oculusOrbState = var0 * 1185562872;
	}

	static void aar(byte[] var0, int var1) {
		if (randomDatData == null) {
			randomDatData = new byte[24];
		}

		class300.writeRandomDat(var0, var1, randomDatData, 0, 24);
	}

	@ObfuscatedSignature(
		signature = "(Lhp;I)Ljava/lang/String;"
	)
	static String aas(Widget var0, int var1) {
		int var3 = ParamDefinition.getWidgetClickMask(var0);
		boolean var2 = (var3 >> var1 + 1 & 1) != 0;
		if (!var2 && var0.onOp == null) {
			return null;
		} else {
			return var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0 ? var0.actions[var1] : null;
		}
	}

	@ObfuscatedSignature(
		signature = "(Lhp;)Z"
	)
	static boolean aaa(Widget var0) {
		return var0.isHidden;
	}

	static String abr(String var0) {
		PlayerType[] var1 = class191.PlayerType_values();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			PlayerType var3 = var1[var2];
			if (var3.modIcon * 714577229 != -1 && var0.startsWith(AbstractWorldMapData.method278(var3.modIcon * 714577229))) {
				var0 = var0.substring(6 + Integer.toString(var3.modIcon * -474347898).length());
				break;
			}
		}

		return var0;
	}

	static void aaq(String var0) {
		Clock.field2037 = var0;

		try {
			String var1 = WorldMapID.client.getParameter(Integer.toString(18));
			String var2 = WorldMapID.client.getParameter(Integer.toString(13));
			String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
			if (var0.length() == 0) {
				var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
			} else {
				var3 = var3 + "; Expires=" + MusicPatchPcmStream.method3831(SequenceDefinition.method4686() + 94608000000L) + "; Max-Age=" + 94608000L;
			}

			class47.method796(WorldMapID.client, "document.cookie=\"" + var3 + "\"");
		} catch (Throwable var4) {
		}

	}

	@ObfuscatedSignature(
		signature = "(Lky;I)V"
	)
	static void aap(Buffer var0, int var1) {
		Tiles.method1088(var0.array, var1);
		WorldMapIcon_1.method295(var0, var1);
	}

	@ObfuscatedSignature(
		signature = "(Lhp;)Z"
	)
	static boolean aaw(Widget var0) {
		return var0.isHidden;
	}

	static void abz(int var0) {
		oculusOrbState = var0;
	}

	static void aay(String var0, boolean var1) {
		var0 = var0.toLowerCase();
		short[] var2 = new short[16];
		int var3 = 0;

		for (int var4 = 0; var4 < MouseRecorder.ItemDefinition_fileCount; ++var4) {
			ItemDefinition var5 = WorldMapData_0.ItemDefinition_get(var4);
			if ((!var1 || var5.isTradable) && var5.noteTemplate * -600977204 == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
				if (var3 >= 250) {
					Language.foundItemIdCount = -1;
					SecureRandomCallable.foundItemIds = null;
					return;
				}

				if (var3 >= var2.length) {
					short[] var6 = new short[var2.length * 2];

					for (int var7 = 0; var7 < var3; ++var7) {
						var6[var7] = var2[var7];
					}

					var2 = var6;
				}

				var2[var3++] = (short)var4;
			}
		}

		SecureRandomCallable.foundItemIds = var2;
		GrandExchangeOffer.foundItemIndex = 0;
		Language.foundItemIdCount = var3;
		String[] var8 = new String[Language.foundItemIdCount * 1188384709];

		for (int var9 = 0; var9 < Language.foundItemIdCount * -269707746; ++var9) {
			var8[var9] = WorldMapData_0.ItemDefinition_get(var2[var9]).name;
		}

		short[] var10 = SecureRandomCallable.foundItemIds;
		ModelData0.sortItemsByName(var8, var10, 0, var8.length - 1);
	}

	static void abs() {
		packetWriter.addNode(MenuAction.getPacketBufferNode(ClientPacket.field2222, packetWriter.isaacCipher));
		oculusOrbState = 0;
	}

	@ObfuscatedSignature(
		signature = "(Lky;)V"
	)
	static void aad(Buffer var0) {
		if (randomDatData != null) {
			var0.writeBytes(randomDatData, 0, randomDatData.length);
		} else {
			byte[] var2 = new byte[24];

			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.readFully(var2);

				int var3;
				for (var3 = 0; var3 < 24 && var2[var3] == 0; ++var3) {
				}

				if (var3 >= 24) {
					throw new IOException();
				}
			} catch (Exception var6) {
				for (int var4 = 0; var4 < 24; ++var4) {
					var2[var4] = -1;
				}
			}

			var0.writeBytes(var2, 0, var2.length);
		}
	}

	@ObfuscatedSignature(
		signature = "(Lky;I)V"
	)
	static void aav(Buffer var0, int var1) {
		Tiles.method1088(var0.array, var1);
		WorldMapIcon_1.method295(var0, var1);
	}

	public static void abp(int var0, int var1, int var2, boolean var3) {
		PacketBufferNode var4 = MenuAction.getPacketBufferNode(ClientPacket.field2255, packetWriter.isaacCipher);
		var4.packetBuffer.writeIntME(var3 ? field705 * -412206939 : 0);
		var4.packetBuffer.writeShortLE(var1);
		var4.packetBuffer.method5545(var2);
		var4.packetBuffer.writeShort(var0);
		packetWriter.addNode(var4);
	}

	@ObfuscatedSignature(
		signature = "(Lhp;)Ljava/lang/String;"
	)
	static String aak(Widget var0) {
		if (WorldMapRegion.method530(ParamDefinition.getWidgetClickMask(var0)) == 0) {
			return null;
		} else {
			return var0.spellActionName != null && var0.spellActionName.trim().length() != 0 ? var0.spellActionName : null;
		}
	}

	@ObfuscatedSignature(
		signature = "(Lky;)V"
	)
	static void aaf(Buffer var0) {
		if (randomDatData != null) {
			var0.writeBytes(randomDatData, 0, randomDatData.length);
		} else {
			byte[] var2 = new byte[24];

			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.readFully(var2);

				int var3;
				for (var3 = 0; var3 < 24 && var2[var3] == 0; ++var3) {
				}

				if (var3 >= 24) {
					throw new IOException();
				}
			} catch (Exception var6) {
				for (int var4 = 0; var4 < 24; ++var4) {
					var2[var4] = -1;
				}
			}

			var0.writeBytes(var2, 0, var2.length);
		}
	}

	@ObfuscatedSignature(
		signature = "(Lhp;)Z"
	)
	static boolean aax(Widget var0) {
		return var0.isHidden;
	}

	@ObfuscatedSignature(
		signature = "(Lhp;)Z"
	)
	static boolean aah(Widget var0) {
		return var0.isHidden;
	}

	@ObfuscatedSignature(
		signature = "(Lhp;I)Ljava/lang/String;"
	)
	static String aat(Widget var0, int var1) {
		int var3 = ParamDefinition.getWidgetClickMask(var0);
		boolean var2 = (var3 >> var1 + 1 & 1) != 0;
		if (!var2 && var0.onOp == null) {
			return null;
		} else {
			return var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0 ? var0.actions[var1] : null;
		}
	}

	@ObfuscatedSignature(
		signature = "(Lhp;)Ljava/lang/String;"
	)
	static String aai(Widget var0) {
		if (WorldMapRegion.method530(ParamDefinition.getWidgetClickMask(var0)) == 0) {
			return null;
		} else {
			return var0.spellActionName != null && var0.spellActionName.trim().length() != 0 ? var0.spellActionName : null;
		}
	}

	@ObfuscatedSignature(
		signature = "(Lhp;)Ljava/lang/String;"
	)
	static String aan(Widget var0) {
		if (WorldMapRegion.method530(ParamDefinition.getWidgetClickMask(var0)) == 0) {
			return null;
		} else {
			return var0.spellActionName != null && var0.spellActionName.trim().length() != 0 ? var0.spellActionName : null;
		}
	}

	static String aae(String var0, boolean var1) {
		String var2 = var1 ? "https://" : "http://";
		if (gameBuild == 1) {
			var0 = var0 + "-wtrc";
		} else if (gameBuild == 2) {
			var0 = var0 + "-wtqa";
		} else if (gameBuild == 3) {
			var0 = var0 + "-wtwip";
		} else if (gameBuild == 5) {
			var0 = var0 + "-wti";
		} else if (gameBuild == 4) {
			var0 = "local";
		}

		String var3 = "";
		if (Clock.field2037 != null) {
			var3 = "/p=" + Clock.field2037;
		}

		String var4 = "runescape.com";
		return var2 + var0 + "." + var4 + "/l=" + class60.clientLanguage + "/a=" + SoundSystem.field1414 + var3 + "/";
	}

	static String aao(String var0, boolean var1) {
		String var2 = var1 ? "https://" : "http://";
		if (gameBuild == 1) {
			var0 = var0 + "-wtrc";
		} else if (gameBuild == 2) {
			var0 = var0 + "-wtqa";
		} else if (gameBuild == 3) {
			var0 = var0 + "-wtwip";
		} else if (gameBuild == 5) {
			var0 = var0 + "-wti";
		} else if (gameBuild == 4) {
			var0 = "local";
		}

		String var3 = "";
		if (Clock.field2037 != null) {
			var3 = "/p=" + Clock.field2037;
		}

		String var4 = "runescape.com";
		return var2 + var0 + "." + var4 + "/l=" + class60.clientLanguage + "/a=" + SoundSystem.field1414 + var3 + "/";
	}

	static String aac(String var0, boolean var1) {
		String var2 = var1 ? "https://" : "http://";
		if (gameBuild == 1) {
			var0 = var0 + "-wtrc";
		} else if (gameBuild == 2) {
			var0 = var0 + "-wtqa";
		} else if (gameBuild == 3) {
			var0 = var0 + "-wtwip";
		} else if (gameBuild == 5) {
			var0 = var0 + "-wti";
		} else if (gameBuild * 281503877 == 4) {
			var0 = "local";
		}

		String var3 = "";
		if (Clock.field2037 != null) {
			var3 = "/p=" + Clock.field2037;
		}

		String var4 = "runescape.com";
		return var2 + var0 + "." + var4 + "/l=" + class60.clientLanguage + "/a=" + SoundSystem.field1414 * -1347342514 + var3 + "/";
	}

	static void aal(byte[] var0, int var1) {
		if (randomDatData == null) {
			randomDatData = new byte[24];
		}

		class300.writeRandomDat(var0, var1, randomDatData, 0, 24);
	}

	@ObfuscatedSignature(
		signature = "(Lky;I)V"
	)
	static void aaz(Buffer var0, int var1) {
		Tiles.method1088(var0.array, var1);
		WorldMapIcon_1.method295(var0, var1);
	}

	@ObfuscatedSignature(
		signature = "(Lky;I)V"
	)
	static void aab(Buffer var0, int var1) {
		Tiles.method1088(var0.array, var1);
		WorldMapIcon_1.method295(var0, var1);
	}

	@ObfuscatedSignature(
		signature = "(Lky;)V"
	)
	static void aam(Buffer var0) {
		if (randomDatData != null) {
			var0.writeBytes(randomDatData, 0, randomDatData.length);
		} else {
			byte[] var2 = new byte[24];

			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.readFully(var2);

				int var3;
				for (var3 = 0; var3 < 24 && var2[var3] == 0; ++var3) {
				}

				if (var3 >= 24) {
					throw new IOException();
				}
			} catch (Exception var6) {
				for (int var4 = 0; var4 < 24; ++var4) {
					var2[var4] = -1;
				}
			}

			var0.writeBytes(var2, 0, var2.length);
		}
	}

	public static void abm(int var0, int var1, int var2, boolean var3) {
		PacketBufferNode var4 = MenuAction.getPacketBufferNode(ClientPacket.field2255, packetWriter.isaacCipher);
		var4.packetBuffer.writeIntME(var3 ? field705 : 0);
		var4.packetBuffer.writeShortLE(var1);
		var4.packetBuffer.method5545(var2);
		var4.packetBuffer.writeShort(var0);
		packetWriter.addNode(var4);
	}

	static void abf(int var0) {
		oculusOrbState = var0;
	}

	static void abh(int var0) {
		oculusOrbState = var0;
	}

	static void aau(String var0) {
		Clock.field2037 = var0;

		try {
			String var1 = WorldMapID.client.getParameter(Integer.toString(18));
			String var2 = WorldMapID.client.getParameter(Integer.toString(13));
			String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
			if (var0.length() == 0) {
				var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
			} else {
				var3 = var3 + "; Expires=" + MusicPatchPcmStream.method3831(SequenceDefinition.method4686() + 94608000000L) + "; Max-Age=" + 94608000L;
			}

			class47.method796(WorldMapID.client, "document.cookie=\"" + var3 + "\"");
		} catch (Throwable var4) {
		}

	}

	static void abj() {
		packetWriter.addNode(MenuAction.getPacketBufferNode(ClientPacket.field2222, packetWriter.isaacCipher));
		oculusOrbState = 0;
	}

	static void aby() {
		packetWriter.addNode(MenuAction.getPacketBufferNode(ClientPacket.field2222, packetWriter.isaacCipher));
		oculusOrbState = 0;
	}

	static void abx() {
		if (field706 && WorldMapIcon_1.localPlayer != null) {
			int var0 = WorldMapIcon_1.localPlayer.pathX[0];
			int var1 = WorldMapIcon_1.localPlayer.pathY[0];
			if (var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
				return;
			}

			DynamicObject.oculusOrbFocalPointX = WorldMapIcon_1.localPlayer.x;
			int var2 = GrandExchangeOfferTotalQuantityComparator.getTileHeight(WorldMapIcon_1.localPlayer.x, WorldMapIcon_1.localPlayer.y, ItemContainer.plane) - camFollowHeight;
			if (var2 < ScriptEvent.field559) {
				ScriptEvent.field559 = var2;
			}

			FriendSystem.oculusOrbFocalPointY = WorldMapIcon_1.localPlayer.y;
			field706 = false;
		}

	}

	static String abq(String var0) {
		PlayerType[] var1 = class191.PlayerType_values();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			PlayerType var3 = var1[var2];
			if (var3.modIcon * 714577229 != -1 && var0.startsWith(AbstractWorldMapData.method278(var3.modIcon * 714577229))) {
				var0 = var0.substring(6 + Integer.toString(var3.modIcon * 714577229).length());
				break;
			}
		}

		return var0;
	}

	static String abl(String var0) {
		PlayerType[] var1 = class191.PlayerType_values();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			PlayerType var3 = var1[var2];
			if (var3.modIcon * -474359768 != -1 && var0.startsWith(AbstractWorldMapData.method278(var3.modIcon * 714577229))) {
				var0 = var0.substring(6 + Integer.toString(var3.modIcon * 64500931).length());
				break;
			}
		}

		return var0;
	}

	static String abu(String var0) {
		PlayerType[] var1 = class191.PlayerType_values();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			PlayerType var3 = var1[var2];
			if (var3.modIcon * 1421818761 != -1 && var0.startsWith(AbstractWorldMapData.method278(var3.modIcon * 714577229))) {
				var0 = var0.substring(6 + Integer.toString(var3.modIcon * -1744443394).length());
				break;
			}
		}

		return var0;
	}

	static String abw(String var0) {
		PlayerType[] var1 = class191.PlayerType_values();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			PlayerType var3 = var1[var2];
			if (var3.modIcon * 869307039 != -1 && var0.startsWith(AbstractWorldMapData.method278(var3.modIcon * 714577229))) {
				var0 = var0.substring(6 + Integer.toString(var3.modIcon * 714577229).length());
				break;
			}
		}

		return var0;
	}

	static void abk() {
		if (GameObject.field1921 != null) {
			field892 = cycle;
			GameObject.field1921.method4241();

			for (int var0 = 0; var0 < players.length; ++var0) {
				if (players[var0] != null) {
					GameObject.field1921.method4237(PacketWriter.baseX * 64 + (players[var0].x >> 7), RouteStrategy.baseY * 64 + (players[var0].y >> 7));
				}
			}
		}

	}

	static void abg() {
		if (GameObject.field1921 != null) {
			field892 = cycle;
			GameObject.field1921.method4241();

			for (int var0 = 0; var0 < players.length; ++var0) {
				if (players[var0] != null) {
					GameObject.field1921.method4237(PacketWriter.baseX * -1245657920 + (players[var0].x >> 7), RouteStrategy.baseY * 64 + (players[var0].y >> 7));
				}
			}
		}

	}
}
