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
	@ObfuscatedName("ma")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	@Export("clickedWidget")
	static Widget clickedWidget;
	@ObfuscatedName("oq")
	@ObfuscatedGetter(
		intValue = 1669670355
	)
	static int field835;
	@ObfuscatedName("or")
	@ObfuscatedGetter(
		intValue = -1587927699
	)
	@Export("rootWidgetCount")
	static int rootWidgetCount;
	@ObfuscatedName("oe")
	@ObfuscatedGetter(
		longValue = 7809710238956253295L
	)
	static long field736;
	@ObfuscatedName("ot")
	static boolean[] field842;
	@ObfuscatedName("oh")
	static boolean[] field837;
	@ObfuscatedName("ov")
	static boolean[] field631;
	@ObfuscatedName("nw")
	static boolean field695;
	@ObfuscatedName("oz")
	@Export("isResizable")
	static boolean isResizable;
	@ObfuscatedName("nf")
	@ObfuscatedGetter(
		intValue = -447078155
	)
	@Export("cycleCntr")
	static int cycleCntr;
	@ObfuscatedName("sk")
	@ObfuscatedGetter(
		intValue = -711169745
	)
	public static int field900;
	@ObfuscatedName("nz")
	@ObfuscatedGetter(
		intValue = -2050239349
	)
	static int field824;
	@ObfuscatedName("nk")
	static boolean field809;
	@ObfuscatedName("qp")
	static boolean field855;
	@ObfuscatedName("mp")
	@ObfuscatedGetter(
		intValue = -1344541921
	)
	@Export("widgetClickX")
	static int widgetClickX;
	@ObfuscatedName("me")
	@ObfuscatedGetter(
		intValue = -1705214051
	)
	@Export("widgetClickY")
	static int widgetClickY;
	@ObfuscatedName("np")
	@ObfuscatedGetter(
		intValue = -230439773
	)
	static int field748;
	@ObfuscatedName("ms")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	@Export("clickedWidgetParent")
	static Widget clickedWidgetParent;
	@ObfuscatedName("mo")
	@ObfuscatedSignature(
		signature = "Llh;"
	)
	@Export("interfaceParents")
	static NodeHashTable interfaceParents;
	@ObfuscatedName("ox")
	@Export("rootWidgetXs")
	static int[] rootWidgetXs;
	@ObfuscatedName("ob")
	@Export("rootWidgetWidths")
	static int[] rootWidgetWidths;
	@ObfuscatedName("nn")
	@ObfuscatedGetter(
		intValue = 415324941
	)
	static int field751;
	@ObfuscatedName("ml")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	@Export("viewportWidget")
	static Widget viewportWidget;
	@ObfuscatedName("oi")
	@ObfuscatedGetter(
		intValue = 1211489517
	)
	@Export("gameDrawingMode")
	static int gameDrawingMode;
	@ObfuscatedName("og")
	@Export("rootWidgetYs")
	static int[] rootWidgetYs;
	@ObfuscatedName("mn")
	@ObfuscatedGetter(
		intValue = -615155411
	)
	@Export("staffModLevel")
	public static int staffModLevel;
	@ObfuscatedName("os")
	@Export("rootWidgetHeights")
	static int[] rootWidgetHeights;
	@ObfuscatedName("op")
	@ObfuscatedSignature(
		signature = "Llh;"
	)
	@Export("widgetClickMasks")
	static NodeHashTable widgetClickMasks;
	@ObfuscatedName("th")
	static int[] field890;
	@ObfuscatedName("nm")
	@ObfuscatedGetter(
		intValue = 172768801
	)
	static int field834;
	@ObfuscatedName("ta")
	static int[] field906;
	@ObfuscatedName("tg")
	@ObfuscatedSignature(
		signature = "Lbs;"
	)
	static final class65 field904;
	@ObfuscatedName("sr")
	@ObfuscatedSignature(
		signature = "[Ld;"
	)
	@Export("grandExchangeOffers")
	static GrandExchangeOffer[] grandExchangeOffers;
	@ObfuscatedName("oj")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("scriptEvents")
	static NodeDeque scriptEvents;
	@ObfuscatedName("pg")
	@ObfuscatedGetter(
		intValue = 1345286015
	)
	@Export("destinationX")
	static int destinationX;
	@ObfuscatedName("nc")
	@ObfuscatedGetter(
		intValue = 723672855
	)
	static int field846;
	@ObfuscatedName("pd")
	@ObfuscatedGetter(
		intValue = 959702887
	)
	@Export("destinationY")
	static int destinationY;
	@ObfuscatedName("nb")
	@ObfuscatedGetter(
		intValue = -899895459
	)
	static int field814;
	@ObfuscatedName("ng")
	@ObfuscatedGetter(
		intValue = -1812598639
	)
	static int field652;
	@ObfuscatedName("nd")
	@ObfuscatedGetter(
		intValue = -441716439
	)
	static int field826;
	@ObfuscatedName("nr")
	@Export("isDraggingWidget")
	static boolean isDraggingWidget;
	@ObfuscatedName("mr")
	@ObfuscatedGetter(
		intValue = -397177077
	)
	@Export("runEnergy")
	static int runEnergy;
	@ObfuscatedName("mk")
	@ObfuscatedGetter(
		intValue = -887954319
	)
	@Export("weight")
	static int weight;
	@ObfuscatedName("mu")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	@Export("meslayerContinueWidget")
	static Widget meslayerContinueWidget;
	@ObfuscatedName("no")
	static int[] field816;
	@ObfuscatedName("sm")
	@ObfuscatedGetter(
		intValue = 857681821
	)
	static int field818;
	@ObfuscatedName("nu")
	@ObfuscatedGetter(
		intValue = 703633297
	)
	static int field820;
	@ObfuscatedName("rg")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	@Export("playerAppearance")
	static PlayerAppearance playerAppearance;
	@ObfuscatedName("qk")
	@ObfuscatedGetter(
		intValue = -1636781949
	)
	@Export("areaSoundEffectVolume")
	static int areaSoundEffectVolume;
	@ObfuscatedName("sl")
	@ObfuscatedGetter(
		intValue = 1393467707
	)
	static int field896;
	@ObfuscatedName("ol")
	@ObfuscatedGetter(
		intValue = 1068901591
	)
	@Export("mouseWheelRotation")
	static int mouseWheelRotation;
	@ObfuscatedName("mv")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	@Export("draggedOnWidget")
	static Widget draggedOnWidget;
	@ObfuscatedName("ru")
	static boolean[] field641;
	@ObfuscatedName("rz")
	static int[] field877;
	@ObfuscatedName("qx")
	@ObfuscatedGetter(
		intValue = -233646219
	)
	@Export("minimapState")
	static int minimapState;
	@ObfuscatedName("rl")
	static int[] field795;
	@ObfuscatedName("rn")
	static int[] field879;
	@ObfuscatedName("ri")
	static int[] field880;
	@ObfuscatedName("sv")
	@Export("archiveLoaders")
	static ArrayList archiveLoaders;
	@ObfuscatedName("sa")
	@ObfuscatedGetter(
		intValue = 1310325491
	)
	@Export("archiveLoadersDone")
	static int archiveLoadersDone;
	@ObfuscatedName("pl")
	@ObfuscatedGetter(
		intValue = -1292384633
	)
	static int field856;
	@ObfuscatedName("ps")
	@ObfuscatedGetter(
		longValue = 6749730827027050469L
	)
	static long field663;
	@ObfuscatedName("rs")
	@ObfuscatedGetter(
		intValue = -137337439
	)
	@Export("viewportOffsetX")
	static int viewportOffsetX;
	@ObfuscatedName("rm")
	@ObfuscatedGetter(
		intValue = 2111319843
	)
	@Export("viewportOffsetY")
	static int viewportOffsetY;
	@ObfuscatedName("rr")
	@ObfuscatedGetter(
		intValue = 1474521741
	)
	@Export("viewportWidth")
	static int viewportWidth;
	@ObfuscatedName("rf")
	@ObfuscatedGetter(
		intValue = -816916675
	)
	@Export("viewportHeight")
	static int viewportHeight;
	@ObfuscatedName("qm")
	@ObfuscatedGetter(
		intValue = -1444022859
	)
	@Export("soundEffectCount")
	static int soundEffectCount;
	@ObfuscatedName("pi")
	static long[] field852;
	@ObfuscatedName("qd")
	@Export("soundEffectIds")
	static int[] soundEffectIds;
	@ObfuscatedName("rt")
	static short field881;
	@ObfuscatedName("qb")
	@Export("queuedSoundEffectLoops")
	static int[] queuedSoundEffectLoops;
	@ObfuscatedName("qw")
	@Export("isCameraLocked")
	static boolean isCameraLocked;
	@ObfuscatedName("ra")
	static short field882;
	@ObfuscatedName("rc")
	static short field844;
	@ObfuscatedName("qr")
	@Export("queuedSoundEffectDelays")
	static int[] queuedSoundEffectDelays;
	@ObfuscatedName("re")
	static short field888;
	@ObfuscatedName("rx")
	static short field886;
	@ObfuscatedName("qy")
	@ObfuscatedSignature(
		signature = "[Lcg;"
	)
	@Export("soundEffects")
	static SoundEffect[] soundEffects;
	@ObfuscatedName("qv")
	@ObfuscatedGetter(
		intValue = 398456721
	)
	@Export("currentTrackGroupId")
	static int currentTrackGroupId;
	@ObfuscatedName("pq")
	@ObfuscatedGetter(
		intValue = -87647027
	)
	static int field721;
	@ObfuscatedName("rh")
	@ObfuscatedGetter(
		intValue = -1065055441
	)
	@Export("viewportZoom")
	static int viewportZoom;
	@ObfuscatedName("rj")
	static short field885;
	@ObfuscatedName("qf")
	@ObfuscatedGetter(
		intValue = -1999845863
	)
	@Export("musicVolume")
	static int musicVolume;
	@ObfuscatedName("qq")
	@Export("soundLocations")
	static int[] soundLocations;
	@ObfuscatedName("pb")
	@ObfuscatedGetter(
		intValue = 1617941687
	)
	@Export("mapIconCount")
	static int mapIconCount;
	@ObfuscatedName("sq")
	@ObfuscatedSignature(
		signature = "Llb;"
	)
	@Export("platformInfoProvider")
	static PlatformInfoProvider platformInfoProvider;
	@ObfuscatedName("pa")
	@Export("mapIconXs")
	static int[] mapIconXs;
	@ObfuscatedName("pj")
	@Export("mapIconYs")
	static int[] mapIconYs;
	@ObfuscatedName("pt")
	@ObfuscatedSignature(
		signature = "[Llx;"
	)
	@Export("mapIcons")
	static Sprite[] mapIcons;
	@ObfuscatedName("ni")
	@ObfuscatedGetter(
		intValue = -406012573
	)
	static int field679;
	@ObfuscatedName("nj")
	@ObfuscatedGetter(
		intValue = 581751417
	)
	@Export("chatCycle")
	static int chatCycle;
	@ObfuscatedName("rp")
	@Export("zoomHeight")
	static short zoomHeight;
	@ObfuscatedName("rk")
	@Export("zoomWidth")
	static short zoomWidth;
	@ObfuscatedName("qt")
	@ObfuscatedGetter(
		intValue = -1154555301
	)
	@Export("soundEffectVolume")
	static int soundEffectVolume;
	@ObfuscatedName("nx")
	static int[] field817;
	@ObfuscatedName("sw")
	@ObfuscatedGetter(
		intValue = 1025711975
	)
	static int field903;
	@ObfuscatedName("pf")
	static String field849;
	@ObfuscatedName("px")
	@ObfuscatedGetter(
		intValue = -131485607
	)
	static int field866;
	@ObfuscatedName("mt")
	@Export("playerMod")
	static boolean playerMod;
	@ObfuscatedName("pz")
	@ObfuscatedGetter(
		intValue = -1422495067
	)
	@Export("publicChatMode")
	static int publicChatMode;
	@ObfuscatedName("pn")
	@ObfuscatedGetter(
		intValue = -1887689269
	)
	@Export("tradeChatMode")
	static int tradeChatMode;
	@ObfuscatedName("pp")
	static int[] field854;
	@ObfuscatedName("py")
	static int[] field853;
	@ObfuscatedName("oc")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	static NodeDeque field813;
	@ObfuscatedName("mj")
	@ObfuscatedGetter(
		intValue = 381105829
	)
	@Export("chatEffects")
	static int chatEffects;
	@ObfuscatedName("pv")
	static int[] field829;
	@ObfuscatedName("od")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	static NodeDeque field832;
	@ObfuscatedName("nt")
	@Export("changedSkills")
	static int[] changedSkills;
	@ObfuscatedName("my")
	@ObfuscatedGetter(
		intValue = 611257561
	)
	static int field907;
	@ObfuscatedName("ny")
	@ObfuscatedGetter(
		intValue = -1741556813
	)
	@Export("changedSkillsCount")
	static int changedSkillsCount;
	@ObfuscatedName("nh")
	@ObfuscatedGetter(
		intValue = -1179398273
	)
	static int field825;
	@ObfuscatedName("mq")
	@ObfuscatedGetter(
		intValue = 1191445113
	)
	@Export("followerIndex")
	static int followerIndex;
	@ObfuscatedName("md")
	@ObfuscatedGetter(
		intValue = -1252075313
	)
	static int field828;
	@ObfuscatedName("mc")
	@ObfuscatedGetter(
		intValue = 1310053169
	)
	static int field794;
	@ObfuscatedName("sn")
	@ObfuscatedSignature(
		signature = "Lbm;"
	)
	@Export("GrandExchangeEvents_worldComparator")
	static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "[Lfm;"
	)
	@Export("collisionMaps")
	static CollisionMap[] collisionMaps;
	@ObfuscatedName("as")
	static boolean field791;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = -20471151
	)
	@Export("worldId")
	public static int worldId;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = -51989745
	)
	@Export("worldProperties")
	static int worldProperties;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = -179388567
	)
	@Export("gameBuild")
	static int gameBuild;
	@ObfuscatedName("bh")
	@Export("isMembersWorld")
	public static boolean isMembersWorld;
	@ObfuscatedName("bu")
	@Export("isLowDetail")
	static boolean isLowDetail;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = 257125477
	)
	@Export("clientType")
	static int clientType;
	@ObfuscatedName("bs")
	@Export("onMobile")
	static boolean onMobile;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = -275274109
	)
	@Export("gameState")
	static int gameState;
	@ObfuscatedName("cr")
	@Export("isLoading")
	static boolean isLoading;
	@ObfuscatedName("ci")
	@ObfuscatedGetter(
		intValue = 240908191
	)
	@Export("cycle")
	static int cycle;
	@ObfuscatedName("cy")
	@ObfuscatedGetter(
		longValue = -715337301000899145L
	)
	@Export("mouseLastLastPressedTimeMillis")
	static long mouseLastLastPressedTimeMillis;
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = -1508326543
	)
	static int field644;
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		intValue = 309923467
	)
	static int field905;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		longValue = -6250089135032631577L
	)
	static long field646;
	@ObfuscatedName("cq")
	@Export("hadFocus")
	static boolean hadFocus;
	@ObfuscatedName("cj")
	@Export("displayFps")
	static boolean displayFps;
	@ObfuscatedName("cm")
	@ObfuscatedGetter(
		intValue = 568076161
	)
	@Export("rebootTimer")
	static int rebootTimer;
	@ObfuscatedName("cb")
	@ObfuscatedGetter(
		intValue = 1087784609
	)
	@Export("hintArrowType")
	static int hintArrowType;
	@ObfuscatedName("cp")
	@ObfuscatedGetter(
		intValue = 560832713
	)
	@Export("hintArrowNpcIndex")
	static int hintArrowNpcIndex;
	@ObfuscatedName("cs")
	@ObfuscatedGetter(
		intValue = 2097708219
	)
	@Export("hintArrowPlayerIndex")
	static int hintArrowPlayerIndex;
	@ObfuscatedName("ck")
	@ObfuscatedGetter(
		intValue = -614355373
	)
	@Export("hintArrowX")
	static int hintArrowX;
	@ObfuscatedName("ct")
	@ObfuscatedGetter(
		intValue = -1984180121
	)
	@Export("hintArrowY")
	static int hintArrowY;
	@ObfuscatedName("cc")
	@ObfuscatedGetter(
		intValue = -607598836
	)
	@Export("hintArrowHeight")
	static int hintArrowHeight;
	@ObfuscatedName("ch")
	@ObfuscatedGetter(
		intValue = -2044500288
	)
	@Export("hintArrowSubX")
	static int hintArrowSubX;
	@ObfuscatedName("cg")
	@ObfuscatedGetter(
		intValue = -848173760
	)
	@Export("hintArrowSubY")
	static int hintArrowSubY;
	@ObfuscatedName("ca")
	@ObfuscatedSignature(
		signature = "Lcr;"
	)
	@Export("playerAttackOption")
	static AttackOption playerAttackOption;
	@ObfuscatedName("db")
	@ObfuscatedSignature(
		signature = "Lcr;"
	)
	@Export("npcAttackOption")
	static AttackOption npcAttackOption;
	@ObfuscatedName("dd")
	@ObfuscatedGetter(
		intValue = 355773429
	)
	@Export("titleLoadingStage")
	static int titleLoadingStage;
	@ObfuscatedName("dm")
	@ObfuscatedSignature(
		signature = "Lku;"
	)
	@Export("js5Socket")
	static AbstractSocket js5Socket;
	@ObfuscatedName("di")
	@ObfuscatedGetter(
		intValue = -1799860723
	)
	@Export("js5ConnectState")
	static int js5ConnectState;
	@ObfuscatedName("dn")
	@ObfuscatedGetter(
		intValue = -762525009
	)
	static int field819;
	@ObfuscatedName("ee")
	@ObfuscatedGetter(
		intValue = 1297064295
	)
	@Export("js5Errors")
	static int js5Errors;
	@ObfuscatedName("ef")
	@ObfuscatedGetter(
		intValue = -1775311529
	)
	@Export("loginState")
	static int loginState;
	@ObfuscatedName("ep")
	@ObfuscatedGetter(
		intValue = -1375640047
	)
	static int field666;
	@ObfuscatedName("et")
	@ObfuscatedGetter(
		intValue = -589488051
	)
	static int field667;
	@ObfuscatedName("eq")
	@ObfuscatedGetter(
		intValue = -627164889
	)
	static int field668;
	@ObfuscatedName("em")
	@ObfuscatedSignature(
		signature = "Lfp;"
	)
	static class160 field850;
	@ObfuscatedName("es")
	@Export("Login_isUsernameRemembered")
	static boolean Login_isUsernameRemembered;
	@ObfuscatedName("en")
	@ObfuscatedSignature(
		signature = "Lco;"
	)
	@Export("secureRandomFuture")
	static SecureRandomFuture secureRandomFuture;
	@ObfuscatedName("ea")
	@Export("randomDatData")
	static byte[] randomDatData;
	@ObfuscatedName("ej")
	@ObfuscatedSignature(
		signature = "[Lcv;"
	)
	@Export("npcs")
	static NPC[] npcs;
	@ObfuscatedName("el")
	@ObfuscatedGetter(
		intValue = 1003307959
	)
	@Export("npcCount")
	static int npcCount;
	@ObfuscatedName("ft")
	@Export("npcIndices")
	static int[] npcIndices;
	@ObfuscatedName("fe")
	@ObfuscatedGetter(
		intValue = 9572479
	)
	static int field676;
	@ObfuscatedName("fs")
	static int[] field677;
	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		signature = "Lcp;"
	)
	@Export("packetWriter")
	public static final PacketWriter packetWriter;
	@ObfuscatedName("fn")
	@ObfuscatedGetter(
		intValue = -1045918939
	)
	@Export("logoutTimer")
	static int logoutTimer;
	@ObfuscatedName("fg")
	static boolean field680;
	@ObfuscatedName("fw")
	@Export("useBufferedSocket")
	static boolean useBufferedSocket;
	@ObfuscatedName("ff")
	@ObfuscatedSignature(
		signature = "Ljt;"
	)
	@Export("timer")
	static Timer timer;
	@ObfuscatedName("fm")
	@Export("fontsMap")
	static HashMap fontsMap;
	@ObfuscatedName("fb")
	@ObfuscatedGetter(
		intValue = 287183653
	)
	static int field684;
	@ObfuscatedName("fd")
	@ObfuscatedGetter(
		intValue = 887047471
	)
	static int field685;
	@ObfuscatedName("fo")
	@ObfuscatedGetter(
		intValue = 202768591
	)
	static int field686;
	@ObfuscatedName("ga")
	@ObfuscatedGetter(
		intValue = -1491451085
	)
	static int field687;
	@ObfuscatedName("gx")
	@ObfuscatedGetter(
		intValue = -331520367
	)
	static int field688;
	@ObfuscatedName("gt")
	@Export("isInInstance")
	static boolean isInInstance;
	@ObfuscatedName("gm")
	@Export("instanceChunkTemplates")
	static int[][][] instanceChunkTemplates;
	@ObfuscatedName("gj")
	static final int[] field692;
	@ObfuscatedName("gp")
	@ObfuscatedGetter(
		intValue = 1121540223
	)
	static int field693;
	@ObfuscatedName("hg")
	@ObfuscatedGetter(
		intValue = 10829207
	)
	static int field895;
	@ObfuscatedName("hx")
	@ObfuscatedGetter(
		intValue = -1992997175
	)
	static int field661;
	@ObfuscatedName("hw")
	@ObfuscatedGetter(
		intValue = 1623441797
	)
	static int field683;
	@ObfuscatedName("hn")
	@ObfuscatedGetter(
		intValue = 7192417
	)
	static int field790;
	@ObfuscatedName("hj")
	static boolean field698;
	@ObfuscatedName("hf")
	@ObfuscatedGetter(
		intValue = -78158007
	)
	@Export("alternativeScrollbarWidth")
	static int alternativeScrollbarWidth;
	@ObfuscatedName("hd")
	@ObfuscatedGetter(
		intValue = 1116385961
	)
	@Export("camAngleX")
	static int camAngleX;
	@ObfuscatedName("hz")
	@ObfuscatedGetter(
		intValue = -683972071
	)
	@Export("camAngleY")
	static int camAngleY;
	@ObfuscatedName("hu")
	@ObfuscatedGetter(
		intValue = 1986559825
	)
	@Export("camAngleDY")
	static int camAngleDY;
	@ObfuscatedName("hm")
	@ObfuscatedGetter(
		intValue = 1107670461
	)
	@Export("camAngleDX")
	static int camAngleDX;
	@ObfuscatedName("ht")
	@ObfuscatedGetter(
		intValue = 749134913
	)
	@Export("mouseCamClickedX")
	static int mouseCamClickedX;
	@ObfuscatedName("hc")
	@ObfuscatedGetter(
		intValue = -1131712939
	)
	@Export("mouseCamClickedY")
	static int mouseCamClickedY;
	@ObfuscatedName("hl")
	@ObfuscatedGetter(
		intValue = -1055821533
	)
	@Export("oculusOrbState")
	static int oculusOrbState;
	@ObfuscatedName("hy")
	@ObfuscatedGetter(
		intValue = -344634531
	)
	@Export("camFollowHeight")
	static int camFollowHeight;
	@ObfuscatedName("ho")
	@ObfuscatedGetter(
		intValue = 1262882711
	)
	static int field876;
	@ObfuscatedName("hq")
	@ObfuscatedGetter(
		intValue = -1868446673
	)
	static int field709;
	@ObfuscatedName("ig")
	@ObfuscatedGetter(
		intValue = -1777737639
	)
	static int field710;
	@ObfuscatedName("ip")
	@ObfuscatedGetter(
		intValue = -934038365
	)
	@Export("oculusOrbNormalSpeed")
	static int oculusOrbNormalSpeed;
	@ObfuscatedName("if")
	@ObfuscatedGetter(
		intValue = -1149402609
	)
	@Export("oculusOrbSlowedSpeed")
	static int oculusOrbSlowedSpeed;
	@ObfuscatedName("ik")
	@ObfuscatedGetter(
		intValue = -1869232701
	)
	public static int field799;
	@ObfuscatedName("iq")
	static boolean field645;
	@ObfuscatedName("iu")
	@ObfuscatedGetter(
		intValue = -979694055
	)
	static int field715;
	@ObfuscatedName("ie")
	static boolean field733;
	@ObfuscatedName("im")
	@ObfuscatedGetter(
		intValue = -843916833
	)
	static int field717;
	@ObfuscatedName("ir")
	@ObfuscatedGetter(
		intValue = -1954915145
	)
	@Export("overheadTextCount")
	static int overheadTextCount;
	@ObfuscatedName("io")
	@ObfuscatedGetter(
		intValue = -1863882285
	)
	@Export("overheadTextLimit")
	static int overheadTextLimit;
	@ObfuscatedName("il")
	@Export("overheadTextXs")
	static int[] overheadTextXs;
	@ObfuscatedName("ic")
	@Export("overheadTextYs")
	static int[] overheadTextYs;
	@ObfuscatedName("ib")
	@Export("overheadTextAscents")
	static int[] overheadTextAscents;
	@ObfuscatedName("iy")
	@Export("overheadTextXOffsets")
	static int[] overheadTextXOffsets;
	@ObfuscatedName("id")
	@Export("overheadTextColors")
	static int[] overheadTextColors;
	@ObfuscatedName("ih")
	@Export("overheadTextEffects")
	static int[] overheadTextEffects;
	@ObfuscatedName("ii")
	@Export("overheadTextCyclesRemaining")
	static int[] overheadTextCyclesRemaining;
	@ObfuscatedName("iw")
	@Export("overheadText")
	static String[] overheadText;
	@ObfuscatedName("in")
	@Export("tileLastDrawnActor")
	static int[][] tileLastDrawnActor;
	@ObfuscatedName("it")
	@Export("selectedItemName")
	static String selectedItemName;
	@ObfuscatedName("is")
	@ObfuscatedGetter(
		intValue = 1250054919
	)
	@Export("viewportDrawCount")
	static int viewportDrawCount;
	@ObfuscatedName("iv")
	@ObfuscatedGetter(
		intValue = 556959165
	)
	@Export("viewportTempX")
	static int viewportTempX;
	@ObfuscatedName("ia")
	@ObfuscatedGetter(
		intValue = -393888855
	)
	@Export("viewportTempY")
	static int viewportTempY;
	@ObfuscatedName("jm")
	@ObfuscatedGetter(
		intValue = 584317187
	)
	@Export("mouseCrossX")
	static int mouseCrossX;
	@ObfuscatedName("jb")
	@ObfuscatedGetter(
		intValue = 719414467
	)
	@Export("mouseCrossY")
	static int mouseCrossY;
	@ObfuscatedName("ja")
	@ObfuscatedGetter(
		intValue = 1435356244
	)
	@Export("mouseCrossState")
	static int mouseCrossState;
	@ObfuscatedName("jd")
	@ObfuscatedGetter(
		intValue = 339244279
	)
	@Export("mouseCrossColor")
	static int mouseCrossColor;
	@ObfuscatedName("jk")
	@Export("showMouseCross")
	static boolean showMouseCross;
	@ObfuscatedName("jy")
	@ObfuscatedGetter(
		intValue = 1508339329
	)
	static int field753;
	@ObfuscatedName("jl")
	@ObfuscatedGetter(
		intValue = -306605903
	)
	static int field665;
	@ObfuscatedName("jw")
	@ObfuscatedGetter(
		intValue = -577138959
	)
	@Export("dragItemSlotSource")
	static int dragItemSlotSource;
	@ObfuscatedName("jt")
	@ObfuscatedGetter(
		intValue = 1983943063
	)
	static int field729;
	@ObfuscatedName("jn")
	@ObfuscatedGetter(
		intValue = -1896878651
	)
	static int field741;
	@ObfuscatedName("jg")
	@ObfuscatedGetter(
		intValue = -2099734901
	)
	@Export("dragItemSlotDestination")
	static int dragItemSlotDestination;
	@ObfuscatedName("jr")
	static boolean field743;
	@ObfuscatedName("je")
	@ObfuscatedGetter(
		intValue = 2041162413
	)
	@Export("itemDragDuration")
	static int itemDragDuration;
	@ObfuscatedName("jc")
	@ObfuscatedGetter(
		intValue = -1234034497
	)
	static int field745;
	@ObfuscatedName("jx")
	@Export("showLoadingMessages")
	static boolean showLoadingMessages;
	@ObfuscatedName("js")
	@ObfuscatedSignature(
		signature = "[Lbj;"
	)
	@Export("players")
	static Player[] players;
	@ObfuscatedName("ju")
	@ObfuscatedGetter(
		intValue = 1889062631
	)
	@Export("localPlayerIndex")
	static int localPlayerIndex;
	@ObfuscatedName("jf")
	@ObfuscatedGetter(
		intValue = -1181575857
	)
	static int field749;
	@ObfuscatedName("jj")
	@Export("renderSelf")
	static boolean renderSelf;
	@ObfuscatedName("kw")
	@ObfuscatedGetter(
		intValue = 2026004463
	)
	@Export("drawPlayerNames")
	static int drawPlayerNames;
	@ObfuscatedName("kq")
	@ObfuscatedGetter(
		intValue = -299289873
	)
	static int field752;
	@ObfuscatedName("ko")
	static int[] field870;
	@ObfuscatedName("ks")
	@Export("playerMenuOpcodes")
	static final int[] playerMenuOpcodes;
	@ObfuscatedName("kx")
	@Export("playerMenuActions")
	static String[] playerMenuActions;
	@ObfuscatedName("ka")
	@Export("playerOptionsPriorities")
	static boolean[] playerOptionsPriorities;
	@ObfuscatedName("kj")
	@Export("defaultRotations")
	static int[] defaultRotations;
	@ObfuscatedName("kf")
	@ObfuscatedGetter(
		intValue = -201752719
	)
	@Export("combatTargetPlayerIndex")
	static int combatTargetPlayerIndex;
	@ObfuscatedName("kc")
	@ObfuscatedSignature(
		signature = "[[[Ljb;"
	)
	@Export("groundItems")
	static NodeDeque[][][] groundItems;
	@ObfuscatedName("ki")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("pendingSpawns")
	static NodeDeque pendingSpawns;
	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("projectiles")
	static NodeDeque projectiles;
	@ObfuscatedName("ky")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("graphicsObjects")
	static NodeDeque graphicsObjects;
	@ObfuscatedName("kd")
	@Export("currentLevels")
	static int[] currentLevels;
	@ObfuscatedName("ku")
	@Export("levels")
	static int[] levels;
	@ObfuscatedName("kg")
	@Export("experience")
	static int[] experience;
	@ObfuscatedName("kn")
	@ObfuscatedGetter(
		intValue = -629997959
	)
	@Export("leftClickOpensMenu")
	static int leftClickOpensMenu;
	@ObfuscatedName("ke")
	@Export("isMenuOpen")
	static boolean isMenuOpen;
	@ObfuscatedName("la")
	@ObfuscatedGetter(
		intValue = -1431664981
	)
	@Export("menuOptionsCount")
	static int menuOptionsCount;
	@ObfuscatedName("lq")
	@Export("menuArguments1")
	static int[] menuArguments1;
	@ObfuscatedName("lr")
	@Export("menuArguments2")
	static int[] menuArguments2;
	@ObfuscatedName("ll")
	@Export("menuOpcodes")
	static int[] menuOpcodes;
	@ObfuscatedName("lh")
	@Export("menuIdentifiers")
	static int[] menuIdentifiers;
	@ObfuscatedName("ls")
	@Export("menuActions")
	static String[] menuActions;
	@ObfuscatedName("li")
	@Export("menuTargets")
	static String[] menuTargets;
	@ObfuscatedName("lv")
	@Export("menuShiftClick")
	static boolean[] menuShiftClick;
	@ObfuscatedName("lu")
	@Export("followerOpsLowPriority")
	static boolean followerOpsLowPriority;
	@ObfuscatedName("lw")
	@Export("shiftClickDrop")
	static boolean shiftClickDrop;
	@ObfuscatedName("lx")
	@Export("tapToDrop")
	static boolean tapToDrop;
	@ObfuscatedName("ld")
	@Export("showMouseOverText")
	static boolean showMouseOverText;
	@ObfuscatedName("lz")
	@ObfuscatedGetter(
		intValue = 1922593219
	)
	@Export("viewportX")
	static int viewportX;
	@ObfuscatedName("lm")
	@ObfuscatedGetter(
		intValue = 1274966975
	)
	@Export("viewportY")
	static int viewportY;
	@ObfuscatedName("lp")
	@ObfuscatedGetter(
		intValue = -365534183
	)
	static int field782;
	@ObfuscatedName("lo")
	@ObfuscatedGetter(
		intValue = 230985687
	)
	static int field783;
	@ObfuscatedName("lj")
	@ObfuscatedGetter(
		intValue = -27300387
	)
	@Export("isItemSelected")
	static int isItemSelected;
	@ObfuscatedName("lg")
	@Export("isSpellSelected")
	static boolean isSpellSelected;
	@ObfuscatedName("ln")
	@ObfuscatedGetter(
		intValue = 151795301
	)
	@Export("selectedSpellChildIndex")
	static int selectedSpellChildIndex;
	@ObfuscatedName("mg")
	@ObfuscatedGetter(
		intValue = -1039451535
	)
	static int field788;
	@ObfuscatedName("mf")
	@Export("selectedSpellActionName")
	static String selectedSpellActionName;
	@ObfuscatedName("mz")
	@Export("selectedSpellName")
	static String selectedSpellName;
	@ObfuscatedName("mh")
	@ObfuscatedGetter(
		intValue = 1866987545
	)
	@Export("rootInterface")
	static int rootInterface;

	static {
		field791 = true;
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
		field644 = -1;
		field905 = -1;
		field646 = -1L;
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
		field819 = 0;
		js5Errors = 0;
		loginState = 0;
		field666 = 0;
		field667 = 0;
		field668 = 0;
		field850 = class160.field1982;
		Login_isUsernameRemembered = false;
		secureRandomFuture = new SecureRandomFuture();
		randomDatData = null;
		npcs = new NPC[32768];
		npcCount = 0;
		npcIndices = new int[32768];
		field676 = 0;
		field677 = new int[250];
		packetWriter = new PacketWriter();
		logoutTimer = 0;
		field680 = false;
		useBufferedSocket = true;
		timer = new Timer();
		fontsMap = new HashMap();
		field684 = 0;
		field685 = 1;
		field686 = 0;
		field687 = 1;
		field688 = 0;
		collisionMaps = new CollisionMap[4];
		isInInstance = false;
		instanceChunkTemplates = new int[4][13][13];
		field692 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
		field693 = 0;
		field895 = 2301979;
		field661 = 5063219;
		field683 = 3353893;
		field790 = 7759444;
		field698 = false;
		alternativeScrollbarWidth = 0;
		camAngleX = 128;
		camAngleY = 0;
		camAngleDY = 0;
		camAngleDX = 0;
		mouseCamClickedX = 0;
		mouseCamClickedY = 0;
		oculusOrbState = 0;
		camFollowHeight = 50;
		field876 = 0;
		field709 = 0;
		field710 = 0;
		oculusOrbNormalSpeed = 12;
		oculusOrbSlowedSpeed = 6;
		field799 = 0;
		field645 = false;
		field715 = 0;
		field733 = false;
		field717 = 0;
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
		field753 = 0;
		field665 = 0;
		dragItemSlotSource = 0;
		field729 = 0;
		field741 = 0;
		dragItemSlotDestination = 0;
		field743 = false;
		itemDragDuration = 0;
		field745 = 0;
		showLoadingMessages = true;
		players = new Player[2048];
		localPlayerIndex = -1;
		field749 = 0;
		renderSelf = true;
		drawPlayerNames = 0;
		field752 = 0;
		field870 = new int[1000];
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
		field782 = 0;
		field783 = 50;
		isItemSelected = 0;
		selectedItemName = null;
		isSpellSelected = false;
		selectedSpellChildIndex = -1;
		field788 = -1;
		selectedSpellActionName = null;
		selectedSpellName = null;
		rootInterface = -1;
		interfaceParents = new NodeHashTable(8);
		field828 = 0;
		field794 = -1;
		chatEffects = 0;
		field907 = 0;
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
		field809 = false;
		field748 = -1;
		field751 = -1;
		field695 = false;
		field846 = -1;
		field814 = -1;
		isDraggingWidget = false;
		cycleCntr = 1;
		field817 = new int[32];
		field679 = 0;
		field816 = new int[32];
		field820 = 0;
		changedSkills = new int[32];
		changedSkillsCount = 0;
		chatCycle = 0;
		field824 = 0;
		field825 = 0;
		field826 = 0;
		field652 = 0;
		field834 = 0;
		mouseWheelRotation = 0;
		scriptEvents = new NodeDeque();
		field813 = new NodeDeque();
		field832 = new NodeDeque();
		widgetClickMasks = new NodeHashTable(512);
		rootWidgetCount = 0;
		field835 = -2;
		field842 = new boolean[100];
		field837 = new boolean[100];
		field631 = new boolean[100];
		rootWidgetXs = new int[100];
		rootWidgetYs = new int[100];
		rootWidgetWidths = new int[100];
		rootWidgetHeights = new int[100];
		gameDrawingMode = 0;
		field736 = 0L;
		isResizable = true;
		field829 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
		publicChatMode = 0;
		tradeChatMode = 0;
		field849 = "";
		field852 = new long[100];
		field721 = 0;
		field866 = 0;
		field853 = new int[128];
		field854 = new int[128];
		field663 = -1L;
		field856 = -1;
		mapIconCount = 0;
		mapIconXs = new int[1000];
		mapIconYs = new int[1000];
		mapIcons = new Sprite[1000];
		destinationX = 0;
		destinationY = 0;
		minimapState = 0;
		musicVolume = 255;
		currentTrackGroupId = -1;
		field855 = false;
		soundEffectVolume = 127;
		areaSoundEffectVolume = 127;
		soundEffectCount = 0;
		soundEffectIds = new int[50];
		queuedSoundEffectLoops = new int[50];
		queuedSoundEffectDelays = new int[50];
		soundLocations = new int[50];
		soundEffects = new SoundEffect[50];
		isCameraLocked = false;
		field641 = new boolean[5];
		field877 = new int[5];
		field795 = new int[5];
		field879 = new int[5];
		field880 = new int[5];
		field881 = 256;
		field882 = 205;
		zoomHeight = 256;
		zoomWidth = 320;
		field885 = 1;
		field886 = 32767;
		field844 = 1;
		field888 = 32767;
		viewportOffsetX = 0;
		viewportOffsetY = 0;
		viewportWidth = 0;
		viewportHeight = 0;
		viewportZoom = 0;
		playerAppearance = new PlayerAppearance();
		field818 = -1;
		field896 = -1;
		platformInfoProvider = new DesktopPlatformInfoProvider();
		grandExchangeOffers = new GrandExchangeOffer[8];
		GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
		field900 = -1;
		archiveLoaders = new ArrayList(10);
		archiveLoadersDone = 0;
		field903 = 0;
		field904 = new class65();
		field890 = new int[50];
		field906 = new int[50];
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2060332880"
	)
	@Export("resizeGame")
	protected final void resizeGame() {
		field736 = PlayerAppearance.currentTimeMillis() + 500L;
		this.resizeJS();
		if (rootInterface != -1) {
			this.resizeRoot(true);
		}

	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1799342365"
	)
	@Export("setUp")
	protected final void setUp() {
		Huffman.method4104(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
		class222.port1 = gameBuild == 0 ? 43594 : worldId + 40000;
		Decimator.port2 = gameBuild == 0 ? 443 : worldId + 50000;
		GrandExchangeOfferUnitPriceComparator.port3 = class222.port1;
		PlayerAppearance.field2519 = class215.field2524;
		PlayerAppearance.field2520 = class215.field2527;
		class326.field3881 = class215.field2526;
		class195.field2359 = class215.field2525;
		Skills.urlRequester = new UrlRequester();
		this.setUpKeyboard();
		this.setUpMouse();
		KeyHandler.mouseWheel = this.mouseWheel();
		WorldMapSectionType.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		ScriptEvent.clientPreferences = Skeleton.method3201();
		this.setUpClipboard();
		NetCache.method4472(this, MusicPatchPcmStream.null_string);
		if (gameBuild != 0) {
			displayFps = true;
		}

		FontName.setWindowedMode(ScriptEvent.clientPreferences.windowMode);
		PacketWriter.friendSystem = new FriendSystem(class60.loginType);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-127"
	)
	@Export("doCycle")
	protected final void doCycle() {
		++cycle;
		this.doCycleJs5();

		while (true) {
			ArchiveDiskAction var1;
			synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
				var1 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_responseQueue.removeLast();
			}

			if (var1 == null) {
				int var45;
				try {
					if (class197.field2377 == 1) {
						var45 = class197.midiPcmStream.method3848();
						if (var45 > 0 && class197.midiPcmStream.isReady()) {
							var45 -= class197.field2384;
							if (var45 < 0) {
								var45 = 0;
							}

							class197.midiPcmStream.setPcmStreamVolume(var45);
						} else {
							class197.midiPcmStream.clear();
							class197.midiPcmStream.removeAll();
							if (class247.musicTrackArchive != null) {
								class197.field2377 = 2;
							} else {
								class197.field2377 = 0;
							}

							class197.musicTrack = null;
							ByteArrayPool.soundCache = null;
						}
					}
				} catch (Exception var68) {
					var68.printStackTrace();
					class197.midiPcmStream.clear();
					class197.field2377 = 0;
					class197.musicTrack = null;
					ByteArrayPool.soundCache = null;
					class247.musicTrackArchive = null;
				}

				ChatChannel.playPcmPlayers();
				int var46;
				synchronized(KeyHandler.KeyHandler_instance) {
					++KeyHandler.KeyHandler_idleCycles;
					KeyHandler.field385 = KeyHandler.field370;
					KeyHandler.field384 = 0;
					if (KeyHandler.field380 >= 0) {
						while (KeyHandler.field380 != KeyHandler.field379) {
							var46 = KeyHandler.field378[KeyHandler.field379];
							KeyHandler.field379 = KeyHandler.field379 + 1 & 127;
							if (var46 < 0) {
								KeyHandler.KeyHandler_pressedKeys[~var46] = false;
							} else {
								if (!KeyHandler.KeyHandler_pressedKeys[var46] && KeyHandler.field384 < KeyHandler.field383.length - 1) {
									KeyHandler.field383[++KeyHandler.field384 - 1] = var46;
								}

								KeyHandler.KeyHandler_pressedKeys[var46] = true;
							}
						}
					} else {
						for (var46 = 0; var46 < 112; ++var46) {
							KeyHandler.KeyHandler_pressedKeys[var46] = false;
						}

						KeyHandler.field380 = KeyHandler.field379;
					}

					if (KeyHandler.field384 > 0) {
						KeyHandler.KeyHandler_idleCycles = 0;
					}

					KeyHandler.field370 = KeyHandler.field387;
				}

				synchronized(MouseHandler.MouseHandler_instance) {
					MouseHandler.MouseHandler_currentButton = MouseHandler.MouseHandler_currentButtonVolatile;
					MouseHandler.MouseHandler_x = MouseHandler.MouseHandler_xVolatile;
					MouseHandler.MouseHandler_y = MouseHandler.MouseHandler_yVolatile;
					MouseHandler.MouseHandler_millis = MouseHandler.MouseHandler_lastMovedVolatile;
					MouseHandler.MouseHandler_lastButton = MouseHandler.MouseHandler_lastButtonVolatile;
					MouseHandler.MouseHandler_lastPressedX = MouseHandler.MouseHandler_lastPressedXVolatile;
					MouseHandler.MouseHandler_lastPressedY = MouseHandler.MouseHandler_lastPressedYVolatile;
					MouseHandler.MouseHandler_lastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillisVolatile;
					MouseHandler.MouseHandler_lastButtonVolatile = 0;
				}

				if (KeyHandler.mouseWheel != null) {
					var45 = KeyHandler.mouseWheel.useRotation();
					mouseWheelRotation = var45;
				}

				if (gameState == 0) {
					NetCache.load();
					HealthBar.method2161();
				} else if (gameState == 5) {
					class189.doCycleTitle(this);
					NetCache.load();
					HealthBar.method2161();
				} else if (gameState != 10 && gameState != 11) {
					if (gameState == 20) {
						class189.doCycleTitle(this);
						this.doCycleLoggedOut();
					} else if (gameState == 25) {
						GrandExchangeOfferNameComparator.method172(false);
						field684 = 0;
						boolean var79 = true;

						for (var46 = 0; var46 < UrlRequester.regionLandArchives.length; ++var46) {
							if (class338.regionMapArchiveIds[var46] != -1 && UrlRequester.regionLandArchives[var46] == null) {
								UrlRequester.regionLandArchives[var46] = WorldMapRectangle.archive5.takeFile(class338.regionMapArchiveIds[var46], 0);
								if (UrlRequester.regionLandArchives[var46] == null) {
									var79 = false;
									++field684;
								}
							}

							if (WorldMapCacheName.regionLandArchiveIds[var46] != -1 && UserComparator3.regionMapArchives[var46] == null) {
								UserComparator3.regionMapArchives[var46] = WorldMapRectangle.archive5.takeFileEncrypted(WorldMapCacheName.regionLandArchiveIds[var46], 0, ClientPacket.xteaKeys[var46]);
								if (UserComparator3.regionMapArchives[var46] == null) {
									var79 = false;
									++field684;
								}
							}
						}

						if (!var79) {
							field688 = 1;
						} else {
							field686 = 0;
							var79 = true;

							Buffer var9;
							int var10;
							int var11;
							int var12;
							int var14;
							int var15;
							int var16;
							int var17;
							int var18;
							int var19;
							int var47;
							int var48;
							for (var46 = 0; var46 < UrlRequester.regionLandArchives.length; ++var46) {
								byte[] var3 = UserComparator3.regionMapArchives[var46];
								if (var3 != null) {
									var47 = (GrandExchangeOfferOwnWorldComparator.regions[var46] >> 8) * 64 - UserComparator8.baseX * 64;
									var48 = (GrandExchangeOfferOwnWorldComparator.regions[var46] & 255) * 64 - HealthBar.baseY * 64;
									if (isInInstance) {
										var47 = 10;
										var48 = 10;
									}

									boolean var8 = true;
									var9 = new Buffer(var3);
									var10 = -1;

									label1395:
									while (true) {
										var11 = var9.method5623();
										if (var11 == 0) {
											var79 &= var8;
											break;
										}

										var10 += var11;
										var12 = 0;
										boolean var13 = false;

										while (true) {
											while (!var13) {
												var14 = var9.readUShortSmart();
												if (var14 == 0) {
													continue label1395;
												}

												var12 += var14 - 1;
												var15 = var12 & 63;
												var16 = var12 >> 6 & 63;
												var17 = var9.readUnsignedByte() >> 2;
												var18 = var16 + var47;
												var19 = var48 + var15;
												if (var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
													ObjectDefinition var20 = WorldMapDecorationType.getObjectDefinition(var10);
													if (var17 != 22 || !isLowDetail || var20.int1 != 0 || var20.interactType == 1 || var20.boolean2) {
														if (!var20.needsModelFiles()) {
															++field686;
															var8 = false;
														}

														var13 = true;
													}
												}
											}

											var14 = var9.readUShortSmart();
											if (var14 == 0) {
												break;
											}

											var9.readUnsignedByte();
										}
									}
								}
							}

							if (!var79) {
								field688 = 2;
							} else {
								if (field688 != 0) {
									GrandExchangeEvents.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
								}

								ChatChannel.playPcmPlayers();
								WorldMapArea.scene.clear();

								for (var46 = 0; var46 < 4; ++var46) {
									collisionMaps[var46].clear();
								}

								int var49;
								for (var46 = 0; var46 < 4; ++var46) {
									for (var49 = 0; var49 < 104; ++var49) {
										for (var47 = 0; var47 < 104; ++var47) {
											Tiles.Tiles_renderFlags[var46][var49][var47] = 0;
										}
									}
								}

								ChatChannel.playPcmPlayers();
								MusicPatchPcmStream.method4038();
								var46 = UrlRequester.regionLandArchives.length;
								GameShell.method1141();
								GrandExchangeOfferNameComparator.method172(true);
								int var6;
								int var21;
								int var22;
								int var53;
								int var73;
								if (!isInInstance) {
									byte[] var50;
									for (var49 = 0; var49 < var46; ++var49) {
										var47 = (GrandExchangeOfferOwnWorldComparator.regions[var49] >> 8) * 64 - UserComparator8.baseX * 64;
										var48 = (GrandExchangeOfferOwnWorldComparator.regions[var49] & 255) * 64 - HealthBar.baseY * 64;
										var50 = UrlRequester.regionLandArchives[var49];
										if (var50 != null) {
											ChatChannel.playPcmPlayers();
											TilePaint.method3200(var50, var47, var48, WorldMapSectionType.field140 * 8 - 48, ScriptEvent.field563 * 8 - 48, collisionMaps);
										}
									}

									for (var49 = 0; var49 < var46; ++var49) {
										var47 = (GrandExchangeOfferOwnWorldComparator.regions[var49] >> 8) * 64 - UserComparator8.baseX * 64;
										var48 = (GrandExchangeOfferOwnWorldComparator.regions[var49] & 255) * 64 - HealthBar.baseY * 64;
										var50 = UrlRequester.regionLandArchives[var49];
										if (var50 == null && ScriptEvent.field563 < 800) {
											ChatChannel.playPcmPlayers();
											class30.method609(var47, var48, 64, 64);
										}
									}

									GrandExchangeOfferNameComparator.method172(true);

									for (var49 = 0; var49 < var46; ++var49) {
										byte[] var4 = UserComparator3.regionMapArchives[var49];
										if (var4 != null) {
											var48 = (GrandExchangeOfferOwnWorldComparator.regions[var49] >> 8) * 64 - UserComparator8.baseX * 64;
											var6 = (GrandExchangeOfferOwnWorldComparator.regions[var49] & 255) * 64 - HealthBar.baseY * 64;
											ChatChannel.playPcmPlayers();
											Scene var51 = WorldMapArea.scene;
											CollisionMap[] var52 = collisionMaps;
											var9 = new Buffer(var4);
											var10 = -1;

											while (true) {
												var11 = var9.method5623();
												if (var11 == 0) {
													break;
												}

												var10 += var11;
												var12 = 0;

												while (true) {
													var73 = var9.readUShortSmart();
													if (var73 == 0) {
														break;
													}

													var12 += var73 - 1;
													var14 = var12 & 63;
													var15 = var12 >> 6 & 63;
													var16 = var12 >> 12;
													var17 = var9.readUnsignedByte();
													var18 = var17 >> 2;
													var19 = var17 & 3;
													var53 = var15 + var48;
													var21 = var14 + var6;
													if (var53 > 0 && var21 > 0 && var53 < 103 && var21 < 103) {
														var22 = var16;
														if ((Tiles.Tiles_renderFlags[1][var53][var21] & 2) == 2) {
															var22 = var16 - 1;
														}

														CollisionMap var23 = null;
														if (var22 >= 0) {
															var23 = var52[var22];
														}

														class247.method4637(var16, var53, var21, var10, var19, var18, var51, var23);
													}
												}
											}
										}
									}
								}

								int var7;
								int[] var10000;
								int var27;
								int var28;
								int var29;
								int var30;
								int var33;
								int var35;
								int var36;
								int var37;
								int var54;
								int var57;
								int var72;
								if (isInInstance) {
									var49 = 0;

									label1300:
									while (true) {
										if (var49 >= 4) {
											for (var49 = 0; var49 < 13; ++var49) {
												for (var47 = 0; var47 < 13; ++var47) {
													var48 = instanceChunkTemplates[0][var49][var47];
													if (var48 == -1) {
														class30.method609(var49 * 8, var47 * 8, 8, 8);
													}
												}
											}

											GrandExchangeOfferNameComparator.method172(true);
											var49 = 0;

											while (true) {
												if (var49 >= 4) {
													break label1300;
												}

												ChatChannel.playPcmPlayers();

												for (var47 = 0; var47 < 13; ++var47) {
													for (var48 = 0; var48 < 13; ++var48) {
														var6 = instanceChunkTemplates[var49][var47][var48];
														if (var6 != -1) {
															var7 = var6 >> 24 & 3;
															var72 = var6 >> 1 & 3;
															var54 = var6 >> 14 & 1023;
															var10 = var6 >> 3 & 2047;
															var11 = (var54 / 8 << 8) + var10 / 8;

															for (var12 = 0; var12 < GrandExchangeOfferOwnWorldComparator.regions.length; ++var12) {
																if (GrandExchangeOfferOwnWorldComparator.regions[var12] == var11 && UserComparator3.regionMapArchives[var12] != null) {
																	class218.method4263(UserComparator3.regionMapArchives[var12], var49, var47 * 8, var48 * 8, var7, (var54 & 7) * 8, (var10 & 7) * 8, var72, WorldMapArea.scene, collisionMaps);
																	break;
																}
															}
														}
													}
												}

												++var49;
											}
										}

										ChatChannel.playPcmPlayers();

										for (var47 = 0; var47 < 13; ++var47) {
											for (var48 = 0; var48 < 13; ++var48) {
												boolean var71 = false;
												var7 = instanceChunkTemplates[var49][var47][var48];
												if (var7 != -1) {
													var72 = var7 >> 24 & 3;
													var54 = var7 >> 1 & 3;
													var10 = var7 >> 14 & 1023;
													var11 = var7 >> 3 & 2047;
													var12 = (var10 / 8 << 8) + var11 / 8;

													for (var73 = 0; var73 < GrandExchangeOfferOwnWorldComparator.regions.length; ++var73) {
														if (GrandExchangeOfferOwnWorldComparator.regions[var73] == var12 && UrlRequester.regionLandArchives[var73] != null) {
															byte[] var55 = UrlRequester.regionLandArchives[var73];
															var15 = var47 * 8;
															var16 = var48 * 8;
															var17 = (var10 & 7) * 8;
															var18 = (var11 & 7) * 8;
															CollisionMap[] var56 = collisionMaps;

															for (var53 = 0; var53 < 8; ++var53) {
																for (var21 = 0; var21 < 8; ++var21) {
																	if (var53 + var15 > 0 && var53 + var15 < 103 && var16 + var21 > 0 && var16 + var21 < 103) {
																		var10000 = var56[var49].flags[var53 + var15];
																		var10000[var21 + var16] &= -16777217;
																	}
																}
															}

															Buffer var74 = new Buffer(var55);

															for (var21 = 0; var21 < 4; ++var21) {
																for (var22 = 0; var22 < 64; ++var22) {
																	for (var57 = 0; var57 < 64; ++var57) {
																		if (var72 == var21 && var22 >= var17 && var22 < var17 + 8 && var57 >= var18 && var57 < var18 + 8) {
																			var28 = var22 & 7;
																			var29 = var57 & 7;
																			var30 = var54 & 3;
																			if (var30 == 0) {
																				var27 = var28;
																			} else if (var30 == 1) {
																				var27 = var29;
																			} else if (var30 == 2) {
																				var27 = 7 - var28;
																			} else {
																				var27 = 7 - var29;
																			}

																			var33 = var27 + var15;
																			var36 = var22 & 7;
																			var37 = var57 & 7;
																			int var38 = var54 & 3;
																			if (var38 == 0) {
																				var35 = var37;
																			} else if (var38 == 1) {
																				var35 = 7 - var36;
																			} else if (var38 == 2) {
																				var35 = 7 - var37;
																			} else {
																				var35 = var36;
																			}

																			class312.loadTerrain(var74, var49, var33, var35 + var16, 0, 0, var54);
																		} else {
																			class312.loadTerrain(var74, 0, -1, -1, 0, 0, 0);
																		}
																	}
																}
															}

															var71 = true;
															break;
														}
													}
												}

												if (!var71) {
													class160.method3585(var49, var47 * 8, var48 * 8);
												}
											}
										}

										++var49;
									}
								}

								GrandExchangeOfferNameComparator.method172(true);
								ChatChannel.playPcmPlayers();
								Scene var69 = WorldMapArea.scene;
								CollisionMap[] var70 = collisionMaps;

								for (var48 = 0; var48 < 4; ++var48) {
									for (var6 = 0; var6 < 104; ++var6) {
										for (var7 = 0; var7 < 104; ++var7) {
											if ((Tiles.Tiles_renderFlags[var48][var6][var7] & 1) == 1) {
												var72 = var48;
												if ((Tiles.Tiles_renderFlags[1][var6][var7] & 2) == 2) {
													var72 = var48 - 1;
												}

												if (var72 >= 0) {
													var70[var72].setBlockedByFloor(var6, var7);
												}
											}
										}
									}
								}

								Tiles.field495 += (int)(Math.random() * 5.0D) - 2;
								if (Tiles.field495 < -8) {
									Tiles.field495 = -8;
								}

								if (Tiles.field495 > 8) {
									Tiles.field495 = 8;
								}

								Tiles.field496 += (int)(Math.random() * 5.0D) - 2;
								if (Tiles.field496 < -16) {
									Tiles.field496 = -16;
								}

								if (Tiles.field496 > 16) {
									Tiles.field496 = 16;
								}

								for (var48 = 0; var48 < 4; ++var48) {
									byte[][] var80 = class96.field1300[var48];
									var12 = (int)Math.sqrt(5100.0D);
									var73 = var12 * 768 >> 8;

									for (var14 = 1; var14 < 103; ++var14) {
										for (var15 = 1; var15 < 103; ++var15) {
											var16 = Tiles.Tiles_heights[var48][var15 + 1][var14] - Tiles.Tiles_heights[var48][var15 - 1][var14];
											var17 = Tiles.Tiles_heights[var48][var15][var14 + 1] - Tiles.Tiles_heights[var48][var15][var14 - 1];
											var18 = (int)Math.sqrt((double)(var16 * var16 + var17 * var17 + 65536));
											var19 = (var16 << 8) / var18;
											var53 = 65536 / var18;
											var21 = (var17 << 8) / var18;
											var22 = (var19 * -50 + var21 * -50 + var53 * -10) / var73 + 96;
											var57 = (var80[var15][var14 + 1] >> 3) + (var80[var15 - 1][var14] >> 2) + (var80[var15][var14 - 1] >> 2) + (var80[var15 + 1][var14] >> 3) + (var80[var15][var14] >> 1);
											UserComparator10.field1964[var15][var14] = var22 - var57;
										}
									}

									for (var14 = 0; var14 < 104; ++var14) {
										Tiles.Tiles_hue[var14] = 0;
										Tiles.Tiles_saturation[var14] = 0;
										Tiles.Tiles_lightness[var14] = 0;
										Tiles.Tiles_hueMultiplier[var14] = 0;
										PlayerType.field3083[var14] = 0;
									}

									for (var14 = -5; var14 < 109; ++var14) {
										for (var15 = 0; var15 < 104; ++var15) {
											var16 = var14 + 5;
											int var10002;
											if (var16 >= 0 && var16 < 104) {
												var17 = SoundSystem.field1414[var48][var16][var15] & 255;
												if (var17 > 0) {
													var19 = var17 - 1;
													FloorUnderlayDefinition var75 = (FloorUnderlayDefinition)FloorUnderlayDefinition.FloorUnderlayDefinition_cached.get((long)var19);
													FloorUnderlayDefinition var58;
													if (var75 != null) {
														var58 = var75;
													} else {
														byte[] var59 = FloorUnderlayDefinition.FloorUnderlayDefinition_archive.takeFile(1, var19);
														var75 = new FloorUnderlayDefinition();
														if (var59 != null) {
															var75.decode(new Buffer(var59), var19);
														}

														var75.postDecode();
														FloorUnderlayDefinition.FloorUnderlayDefinition_cached.put(var75, (long)var19);
														var58 = var75;
													}

													var10000 = Tiles.Tiles_hue;
													var10000[var15] += var58.hue;
													var10000 = Tiles.Tiles_saturation;
													var10000[var15] += var58.saturation;
													var10000 = Tiles.Tiles_lightness;
													var10000[var15] += var58.lightness;
													var10000 = Tiles.Tiles_hueMultiplier;
													var10000[var15] += var58.hueMultiplier;
													var10002 = PlayerType.field3083[var15]++;
												}
											}

											var17 = var14 - 5;
											if (var17 >= 0 && var17 < 104) {
												var18 = SoundSystem.field1414[var48][var17][var15] & 255;
												if (var18 > 0) {
													var53 = var18 - 1;
													FloorUnderlayDefinition var84 = (FloorUnderlayDefinition)FloorUnderlayDefinition.FloorUnderlayDefinition_cached.get((long)var53);
													FloorUnderlayDefinition var83;
													if (var84 != null) {
														var83 = var84;
													} else {
														byte[] var60 = FloorUnderlayDefinition.FloorUnderlayDefinition_archive.takeFile(1, var53);
														var84 = new FloorUnderlayDefinition();
														if (var60 != null) {
															var84.decode(new Buffer(var60), var53);
														}

														var84.postDecode();
														FloorUnderlayDefinition.FloorUnderlayDefinition_cached.put(var84, (long)var53);
														var83 = var84;
													}

													var10000 = Tiles.Tiles_hue;
													var10000[var15] -= var83.hue;
													var10000 = Tiles.Tiles_saturation;
													var10000[var15] -= var83.saturation;
													var10000 = Tiles.Tiles_lightness;
													var10000[var15] -= var83.lightness;
													var10000 = Tiles.Tiles_hueMultiplier;
													var10000[var15] -= var83.hueMultiplier;
													var10002 = PlayerType.field3083[var15]--;
												}
											}
										}

										if (var14 >= 1 && var14 < 103) {
											var15 = 0;
											var16 = 0;
											var17 = 0;
											var18 = 0;
											var19 = 0;

											for (var53 = -5; var53 < 109; ++var53) {
												var21 = var53 + 5;
												if (var21 >= 0 && var21 < 104) {
													var15 += Tiles.Tiles_hue[var21];
													var16 += Tiles.Tiles_saturation[var21];
													var17 += Tiles.Tiles_lightness[var21];
													var18 += Tiles.Tiles_hueMultiplier[var21];
													var19 += PlayerType.field3083[var21];
												}

												var22 = var53 - 5;
												if (var22 >= 0 && var22 < 104) {
													var15 -= Tiles.Tiles_hue[var22];
													var16 -= Tiles.Tiles_saturation[var22];
													var17 -= Tiles.Tiles_lightness[var22];
													var18 -= Tiles.Tiles_hueMultiplier[var22];
													var19 -= PlayerType.field3083[var22];
												}

												if (var53 >= 1 && var53 < 103 && (!isLowDetail || (Tiles.Tiles_renderFlags[0][var14][var53] & 2) != 0 || (Tiles.Tiles_renderFlags[var48][var14][var53] & 16) == 0)) {
													if (var48 < Tiles.Tiles_minPlane) {
														Tiles.Tiles_minPlane = var48;
													}

													var57 = SoundSystem.field1414[var48][var14][var53] & 255;
													int var61 = Tiles.field485[var48][var14][var53] & 255;
													if (var57 > 0 || var61 > 0) {
														int var25 = Tiles.Tiles_heights[var48][var14][var53];
														int var26 = Tiles.Tiles_heights[var48][var14 + 1][var53];
														var27 = Tiles.Tiles_heights[var48][var14 + 1][var53 + 1];
														var28 = Tiles.Tiles_heights[var48][var14][var53 + 1];
														var29 = UserComparator10.field1964[var14][var53];
														var30 = UserComparator10.field1964[var14 + 1][var53];
														int var62 = UserComparator10.field1964[var14 + 1][var53 + 1];
														int var32 = UserComparator10.field1964[var14][var53 + 1];
														var33 = -1;
														int var34 = -1;
														if (var57 > 0) {
															var35 = var15 * 256 / var18;
															var36 = var16 / var19;
															var37 = var17 / var19;
															var33 = EnumDefinition.hslToRgb(var35, var36, var37);
															var35 = var35 + Tiles.field495 & 255;
															var37 += Tiles.field496;
															if (var37 < 0) {
																var37 = 0;
															} else if (var37 > 255) {
																var37 = 255;
															}

															var34 = EnumDefinition.hslToRgb(var35, var36, var37);
														}

														if (var48 > 0) {
															boolean var77 = true;
															if (var57 == 0 && Tiles.field482[var48][var14][var53] != 0) {
																var77 = false;
															}

															if (var61 > 0 && !WorldMapDecoration.FloorUnderlayDefinition_get(var61 - 1).hideUnderlay) {
																var77 = false;
															}

															if (var77 && var25 == var26 && var25 == var27 && var28 == var25) {
																var10000 = Tiles.field488[var48][var14];
																var10000[var53] |= 2340;
															}
														}

														var35 = 0;
														if (var34 != -1) {
															var35 = Rasterizer3D.Rasterizer3D_colorPalette[WorldMapCacheName.method686(var34, 96)];
														}

														if (var61 == 0) {
															var69.addTile(var48, var14, var53, 0, 0, -1, var25, var26, var27, var28, WorldMapCacheName.method686(var33, var29), WorldMapCacheName.method686(var33, var30), WorldMapCacheName.method686(var33, var62), WorldMapCacheName.method686(var33, var32), 0, 0, 0, 0, var35, 0);
														} else {
															var36 = Tiles.field482[var48][var14][var53] + 1;
															byte var78 = Tiles.field483[var48][var14][var53];
															FloorOverlayDefinition var63 = WorldMapDecoration.FloorUnderlayDefinition_get(var61 - 1);
															int var39 = var63.texture;
															int var40;
															int var41;
															int var42;
															int var43;
															if (var39 >= 0) {
																var41 = Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var39);
																var40 = -1;
															} else if (var63.primaryRgb == 16711935) {
																var40 = -2;
																var39 = -1;
																var41 = -2;
															} else {
																var40 = EnumDefinition.hslToRgb(var63.hue, var63.saturation, var63.lightness);
																var42 = var63.hue + Tiles.field495 & 255;
																var43 = var63.lightness + Tiles.field496;
																if (var43 < 0) {
																	var43 = 0;
																} else if (var43 > 255) {
																	var43 = 255;
																}

																var41 = EnumDefinition.hslToRgb(var42, var63.saturation, var43);
															}

															var42 = 0;
															if (var41 != -2) {
																var42 = Rasterizer3D.Rasterizer3D_colorPalette[HealthBarUpdate.method1880(var41, 96)];
															}

															if (var63.secondaryRgb != -1) {
																var43 = var63.secondaryHue + Tiles.field495 & 255;
																int var44 = var63.secondaryLightness + Tiles.field496;
																if (var44 < 0) {
																	var44 = 0;
																} else if (var44 > 255) {
																	var44 = 255;
																}

																var41 = EnumDefinition.hslToRgb(var43, var63.secondarySaturation, var44);
																var42 = Rasterizer3D.Rasterizer3D_colorPalette[HealthBarUpdate.method1880(var41, 96)];
															}

															var69.addTile(var48, var14, var53, var36, var78, var39, var25, var26, var27, var28, WorldMapCacheName.method686(var33, var29), WorldMapCacheName.method686(var33, var30), WorldMapCacheName.method686(var33, var62), WorldMapCacheName.method686(var33, var32), HealthBarUpdate.method1880(var40, var29), HealthBarUpdate.method1880(var40, var30), HealthBarUpdate.method1880(var40, var62), HealthBarUpdate.method1880(var40, var32), var35, var42);
														}
													}
												}
											}
										}
									}

									for (var14 = 1; var14 < 103; ++var14) {
										for (var15 = 1; var15 < 103; ++var15) {
											if ((Tiles.Tiles_renderFlags[var48][var15][var14] & 8) != 0) {
												var53 = 0;
											} else if (var48 > 0 && (Tiles.Tiles_renderFlags[1][var15][var14] & 2) != 0) {
												var53 = var48 - 1;
											} else {
												var53 = var48;
											}

											var69.setTileMinPlane(var48, var15, var14, var53);
										}
									}

									SoundSystem.field1414[var48] = null;
									Tiles.field485[var48] = null;
									Tiles.field482[var48] = null;
									Tiles.field483[var48] = null;
									class96.field1300[var48] = null;
								}

								var69.method3234(-50, -10, -50);

								for (var48 = 0; var48 < 104; ++var48) {
									for (var6 = 0; var6 < 104; ++var6) {
										if ((Tiles.Tiles_renderFlags[1][var48][var6] & 2) == 2) {
											var69.setLinkBelow(var48, var6);
										}
									}
								}

								var48 = 1;
								var6 = 2;
								var7 = 4;

								for (var72 = 0; var72 < 4; ++var72) {
									if (var72 > 0) {
										var48 <<= 3;
										var6 <<= 3;
										var7 <<= 3;
									}

									for (var54 = 0; var54 <= var72; ++var54) {
										for (var10 = 0; var10 <= 104; ++var10) {
											for (var11 = 0; var11 <= 104; ++var11) {
												short var76;
												if ((Tiles.field488[var54][var11][var10] & var48) != 0) {
													var12 = var10;
													var73 = var10;
													var14 = var54;

													for (var15 = var54; var12 > 0 && (Tiles.field488[var54][var11][var12 - 1] & var48) != 0; --var12) {
													}

													while (var73 < 104 && (Tiles.field488[var54][var11][var73 + 1] & var48) != 0) {
														++var73;
													}

													label951:
													while (var14 > 0) {
														for (var16 = var12; var16 <= var73; ++var16) {
															if ((Tiles.field488[var14 - 1][var11][var16] & var48) == 0) {
																break label951;
															}
														}

														--var14;
													}

													label940:
													while (var15 < var72) {
														for (var16 = var12; var16 <= var73; ++var16) {
															if ((Tiles.field488[var15 + 1][var11][var16] & var48) == 0) {
																break label940;
															}
														}

														++var15;
													}

													var16 = (var73 - var12 + 1) * (var15 + 1 - var14);
													if (var16 >= 8) {
														var76 = 240;
														var18 = Tiles.Tiles_heights[var15][var11][var12] - var76;
														var19 = Tiles.Tiles_heights[var14][var11][var12];
														Scene.Scene_addOccluder(var72, 1, var11 * 128, var11 * 128, var12 * 128, var73 * 128 + 128, var18, var19);

														for (var53 = var14; var53 <= var15; ++var53) {
															for (var21 = var12; var21 <= var73; ++var21) {
																var10000 = Tiles.field488[var53][var11];
																var10000[var21] &= ~var48;
															}
														}
													}
												}

												if ((Tiles.field488[var54][var11][var10] & var6) != 0) {
													var12 = var11;
													var73 = var11;
													var14 = var54;

													for (var15 = var54; var12 > 0 && (Tiles.field488[var54][var12 - 1][var10] & var6) != 0; --var12) {
													}

													while (var73 < 104 && (Tiles.field488[var54][var73 + 1][var10] & var6) != 0) {
														++var73;
													}

													label1004:
													while (var14 > 0) {
														for (var16 = var12; var16 <= var73; ++var16) {
															if ((Tiles.field488[var14 - 1][var16][var10] & var6) == 0) {
																break label1004;
															}
														}

														--var14;
													}

													label993:
													while (var15 < var72) {
														for (var16 = var12; var16 <= var73; ++var16) {
															if ((Tiles.field488[var15 + 1][var16][var10] & var6) == 0) {
																break label993;
															}
														}

														++var15;
													}

													var16 = (var73 - var12 + 1) * (var15 + 1 - var14);
													if (var16 >= 8) {
														var76 = 240;
														var18 = Tiles.Tiles_heights[var15][var12][var10] - var76;
														var19 = Tiles.Tiles_heights[var14][var12][var10];
														Scene.Scene_addOccluder(var72, 2, var12 * 128, var73 * 128 + 128, var10 * 128, var10 * 128, var18, var19);

														for (var53 = var14; var53 <= var15; ++var53) {
															for (var21 = var12; var21 <= var73; ++var21) {
																var10000 = Tiles.field488[var53][var21];
																var10000[var10] &= ~var6;
															}
														}
													}
												}

												if ((Tiles.field488[var54][var11][var10] & var7) != 0) {
													var12 = var11;
													var73 = var11;
													var14 = var10;

													for (var15 = var10; var14 > 0 && (Tiles.field488[var54][var11][var14 - 1] & var7) != 0; --var14) {
													}

													while (var15 < 104 && (Tiles.field488[var54][var11][var15 + 1] & var7) != 0) {
														++var15;
													}

													label1057:
													while (var12 > 0) {
														for (var16 = var14; var16 <= var15; ++var16) {
															if ((Tiles.field488[var54][var12 - 1][var16] & var7) == 0) {
																break label1057;
															}
														}

														--var12;
													}

													label1046:
													while (var73 < 104) {
														for (var16 = var14; var16 <= var15; ++var16) {
															if ((Tiles.field488[var54][var73 + 1][var16] & var7) == 0) {
																break label1046;
															}
														}

														++var73;
													}

													if ((var15 - var14 + 1) * (var73 - var12 + 1) >= 4) {
														var16 = Tiles.Tiles_heights[var54][var12][var14];
														Scene.Scene_addOccluder(var72, 4, var12 * 128, var73 * 128 + 128, var14 * 128, var15 * 128 + 128, var16, var16);

														for (var17 = var12; var17 <= var73; ++var17) {
															for (var18 = var14; var18 <= var15; ++var18) {
																var10000 = Tiles.field488[var54][var17];
																var10000[var18] &= ~var7;
															}
														}
													}
												}
											}
										}
									}
								}

								GrandExchangeOfferNameComparator.method172(true);
								var48 = Tiles.Tiles_minPlane;
								if (var48 > Player.Client_plane) {
									var48 = Player.Client_plane;
								}

								if (var48 < Player.Client_plane - 1) {
									var48 = Player.Client_plane - 1;
								}

								if (isLowDetail) {
									WorldMapArea.scene.init(Tiles.Tiles_minPlane);
								} else {
									WorldMapArea.scene.init(0);
								}

								for (var6 = 0; var6 < 104; ++var6) {
									for (var7 = 0; var7 < 104; ++var7) {
										class4.updateItemPile(var6, var7);
									}
								}

								ChatChannel.playPcmPlayers();

								for (PendingSpawn var81 = (PendingSpawn)pendingSpawns.last(); var81 != null; var81 = (PendingSpawn)pendingSpawns.previous()) {
									if (var81.hitpoints == -1) {
										var81.delay = 0;
										FaceNormal.method3396(var81);
									} else {
										var81.remove();
									}
								}

								ObjectDefinition.ObjectDefinition_cachedModelData.clear();
								PacketBufferNode var82;
								if (WorldMapID.client.hasFrame()) {
									var82 = SoundSystem.getPacketBufferNode(ClientPacket.field2271, packetWriter.isaacCipher);
									var82.packetBuffer.writeInt(1057001181);
									packetWriter.addNode(var82);
								}

								if (!isInInstance) {
									var6 = (WorldMapSectionType.field140 - 6) / 8;
									var7 = (WorldMapSectionType.field140 + 6) / 8;
									var72 = (ScriptEvent.field563 - 6) / 8;
									var54 = (ScriptEvent.field563 + 6) / 8;

									for (var10 = var6 - 1; var10 <= var7 + 1; ++var10) {
										for (var11 = var72 - 1; var11 <= var54 + 1; ++var11) {
											if (var10 < var6 || var10 > var7 || var11 < var72 || var11 > var54) {
												WorldMapRectangle.archive5.loadRegionFromName("m" + var10 + "_" + var11);
												WorldMapRectangle.archive5.loadRegionFromName("l" + var10 + "_" + var11);
											}
										}
									}
								}

								Tile.updateGameState(30);
								ChatChannel.playPcmPlayers();
								SoundSystem.field1414 = null;
								Tiles.field485 = null;
								Tiles.field482 = null;
								Tiles.field483 = null;
								Tiles.field488 = null;
								class96.field1300 = null;
								UserComparator10.field1964 = null;
								Tiles.Tiles_hue = null;
								Tiles.Tiles_saturation = null;
								Tiles.Tiles_lightness = null;
								Tiles.Tiles_hueMultiplier = null;
								PlayerType.field3083 = null;
								var82 = SoundSystem.getPacketBufferNode(ClientPacket.field2280, packetWriter.isaacCipher);
								packetWriter.addNode(var82);
								HealthBar.method2161();
							}
						}
					}
				} else {
					class189.doCycleTitle(this);
				}

				if (gameState == 30) {
					this.doCycleLoggedIn();
				} else if (gameState == 40 || gameState == 45) {
					this.doCycleLoggedOut();
				}

				return;
			}

			var1.archive.load(var1.archiveDisk, (int)var1.key, var1.data, false);
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1361952953"
	)
	@Export("draw")
	protected final void draw(boolean var1) {
		boolean var2;
		label170: {
			try {
				if (class197.field2377 == 2) {
					if (class197.musicTrack == null) {
						class197.musicTrack = MusicTrack.readTrack(class247.musicTrackArchive, class189.musicTrackGroupId, class197.musicTrackFileId);
						if (class197.musicTrack == null) {
							var2 = false;
							break label170;
						}
					}

					if (ByteArrayPool.soundCache == null) {
						ByteArrayPool.soundCache = new SoundCache(class197.soundEffectsArchive, class197.musicSamplesArchive);
					}

					if (class197.midiPcmStream.loadMusicTrack(class197.musicTrack, class197.musicPatchesArchive, ByteArrayPool.soundCache, 22050)) {
						class197.midiPcmStream.clearAll();
						class197.midiPcmStream.setPcmStreamVolume(class197.musicTrackVolume);
						class197.midiPcmStream.setMusicTrack(class197.musicTrack, ScriptFrame.musicTrackBoolean);
						class197.field2377 = 0;
						class197.musicTrack = null;
						ByteArrayPool.soundCache = null;
						class247.musicTrackArchive = null;
						var2 = true;
						break label170;
					}
				}
			} catch (Exception var6) {
				var6.printStackTrace();
				class197.midiPcmStream.clear();
				class197.field2377 = 0;
				class197.musicTrack = null;
				ByteArrayPool.soundCache = null;
				class247.musicTrackArchive = null;
			}

			var2 = false;
		}

		if (var2 && field855 && class80.pcmPlayer0 != null) {
			class80.pcmPlayer0.tryDiscard();
		}

		if ((gameState == 10 || gameState == 20 || gameState == 30) && field736 != 0L && PlayerAppearance.currentTimeMillis() > field736) {
			FontName.setWindowedMode(WallDecoration.getWindowedMode());
		}

		int var4;
		if (var1) {
			for (var4 = 0; var4 < 100; ++var4) {
				field842[var4] = true;
			}
		}

		if (gameState == 0) {
			this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
		} else if (gameState == 5) {
			class1.drawTitle(class43.fontBold12, class51.fontPlain11, ArchiveDiskActionHandler.fontPlain12);
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				class1.drawTitle(class43.fontBold12, class51.fontPlain11, ArchiveDiskActionHandler.fontPlain12);
			} else if (gameState == 25) {
				if (field688 == 1) {
					if (field684 > field685) {
						field685 = field684;
					}

					var4 = (field685 * 50 - field684 * 50) / field685;
					GrandExchangeEvents.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
				} else if (field688 == 2) {
					if (field686 > field687) {
						field687 = field686;
					}

					var4 = (field687 * 50 - field686 * 50) / field687 + 50;
					GrandExchangeEvents.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
				} else {
					GrandExchangeEvents.drawLoadingMessage("Loading - please wait.", false);
				}
			} else if (gameState == 30) {
				this.drawLoggedIn();
			} else if (gameState == 40) {
				GrandExchangeEvents.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
			} else if (gameState == 45) {
				GrandExchangeEvents.drawLoadingMessage("Please wait...", false);
			}
		} else {
			class1.drawTitle(class43.fontBold12, class51.fontPlain11, ArchiveDiskActionHandler.fontPlain12);
		}

		if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
			for (var4 = 0; var4 < rootWidgetCount; ++var4) {
				if (field837[var4]) {
					AbstractWorldMapData.rasterProvider.draw(rootWidgetXs[var4], rootWidgetYs[var4], rootWidgetWidths[var4], rootWidgetHeights[var4]);
					field837[var4] = false;
				}
			}
		} else if (gameState > 0) {
			AbstractWorldMapData.rasterProvider.drawFull(0, 0);

			for (var4 = 0; var4 < rootWidgetCount; ++var4) {
				field837[var4] = false;
			}
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1838623985"
	)
	@Export("kill0")
	protected final void kill0() {
		if (class1.varcs.hasUnwrittenChanges()) {
			class1.varcs.write();
		}

		if (class3.mouseRecorder != null) {
			class3.mouseRecorder.isRunning = false;
		}

		class3.mouseRecorder = null;
		packetWriter.close();
		class43.method880();
		NPCDefinition.method4880();
		KeyHandler.mouseWheel = null;
		if (class80.pcmPlayer0 != null) {
			class80.pcmPlayer0.shutdown();
		}

		if (MenuAction.pcmPlayer1 != null) {
			MenuAction.pcmPlayer1.shutdown();
		}

		class185.method3774();
		class218.method4255();
		if (Skills.urlRequester != null) {
			Skills.urlRequester.close();
			Skills.urlRequester = null;
		}

		Tile.method3023();
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-22"
	)
	protected final void vmethod1393() {
	}

	public final void init() {
		try {
			if (this.checkHost()) {
				for (int var1 = 0; var1 <= 19; ++var1) {
					String var2 = this.getParameter(Integer.toString(var1));
					if (var2 != null) {
						int var4;
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
							var4 = Integer.parseInt(var2);
							Language var13;
							if (var4 >= 0 && var4 < Language.Language_valuesOrdered.length) {
								var13 = Language.Language_valuesOrdered[var4];
							} else {
								var13 = null;
							}

							WorldMapSection1.clientLanguage = var13;
							break;
						case 7:
							var4 = Integer.parseInt(var2);
							ServerBuild[] var5 = new ServerBuild[]{ServerBuild.BUILDLIVE, ServerBuild.WIP, ServerBuild.RC, ServerBuild.LIVE};
							ServerBuild[] var6 = var5;
							int var7 = 0;

							ServerBuild var3;
							while (true) {
								if (var7 >= var6.length) {
									var3 = null;
									break;
								}

								ServerBuild var8 = var6[var7];
								if (var4 == var8.field3088) {
									var3 = var8;
									break;
								}

								++var7;
							}

							class32.field265 = var3;
							break;
						case 8:
							if (var2.equalsIgnoreCase("true")) {
							}
							break;
						case 9:
							MilliClock.field1994 = var2;
							break;
						case 10:
							MouseHandler.field458 = (StudioGame)WorldMapIcon_1.findEnumerated(class60.method1260(), Integer.parseInt(var2));
							if (StudioGame.oldscape == MouseHandler.field458) {
								class60.loginType = LoginType.oldscape;
							} else {
								class60.loginType = LoginType.field4032;
							}
							break;
						case 12:
							worldId = Integer.parseInt(var2);
							break;
						case 14:
							class339.field4041 = Integer.parseInt(var2);
							break;
						case 15:
							gameBuild = Integer.parseInt(var2);
							break;
						case 17:
							class335.field4016 = var2;
						}
					}
				}

				class13.method199();
				WorldMapAreaData.worldHost = this.getCodeBase().getHost();
				String var9 = class32.field265.name;
				byte var10 = 0;

				try {
					class192.method3814("oldschool", var9, var10, 21);
				} catch (Exception var11) {
					User.RunException_sendStackTrace((String)null, var11);
				}

				WorldMapID.client = this;
				TileItem.clientType = clientType;
				this.startThread(765, 503, 185);
			}
		} catch (RuntimeException var12) {
			throw ByteArrayPool.newRunException(var12, "client.init(" + ')');
		}
	}

	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "773781799"
	)
	@Export("doCycleJs5")
	void doCycleJs5() {
		if (gameState != 1000) {
			long var2 = PlayerAppearance.currentTimeMillis();
			int var4 = (int)(var2 - NetCache.field3149);
			NetCache.field3149 = var2;
			if (var4 > 200) {
				var4 = 200;
			}

			NetCache.NetCache_loadTime += var4;
			boolean var1;
			if (NetCache.NetCache_pendingResponsesCount == 0 && NetCache.NetCache_pendingPriorityResponsesCount == 0 && NetCache.NetCache_pendingWritesCount == 0 && NetCache.NetCache_pendingPriorityWritesCount == 0) {
				var1 = true;
			} else if (NetCache.NetCache_socket == null) {
				var1 = false;
			} else {
				try {
					label247: {
						if (NetCache.NetCache_loadTime > 30000) {
							throw new IOException();
						}

						NetFileRequest var5;
						Buffer var6;
						while (NetCache.NetCache_pendingPriorityResponsesCount < 200 && NetCache.NetCache_pendingPriorityWritesCount > 0) {
							var5 = (NetFileRequest)NetCache.NetCache_pendingPriorityWrites.first();
							var6 = new Buffer(4);
							var6.writeByte(1);
							var6.writeMedium((int)var5.key);
							NetCache.NetCache_socket.write(var6.array, 0, 4);
							NetCache.NetCache_pendingPriorityResponses.put(var5, var5.key);
							--NetCache.NetCache_pendingPriorityWritesCount;
							++NetCache.NetCache_pendingPriorityResponsesCount;
						}

						while (NetCache.NetCache_pendingResponsesCount < 200 && NetCache.NetCache_pendingWritesCount > 0) {
							var5 = (NetFileRequest)NetCache.NetCache_pendingWritesQueue.removeLast();
							var6 = new Buffer(4);
							var6.writeByte(0);
							var6.writeMedium((int)var5.key);
							NetCache.NetCache_socket.write(var6.array, 0, 4);
							var5.removeDual();
							NetCache.NetCache_pendingResponses.put(var5, var5.key);
							--NetCache.NetCache_pendingWritesCount;
							++NetCache.NetCache_pendingResponsesCount;
						}

						for (int var17 = 0; var17 < 100; ++var17) {
							int var18 = NetCache.NetCache_socket.available();
							if (var18 < 0) {
								throw new IOException();
							}

							if (var18 == 0) {
								break;
							}

							NetCache.NetCache_loadTime = 0;
							byte var7 = 0;
							if (UserComparator6.NetCache_currentResponse == null) {
								var7 = 8;
							} else if (NetCache.field3161 == 0) {
								var7 = 1;
							}

							int var8;
							int var9;
							int var10;
							int var12;
							byte[] var10000;
							int var10001;
							Buffer var25;
							if (var7 > 0) {
								var8 = var7 - NetCache.NetCache_responseHeaderBuffer.offset;
								if (var8 > var18) {
									var8 = var18;
								}

								NetCache.NetCache_socket.read(NetCache.NetCache_responseHeaderBuffer.array, NetCache.NetCache_responseHeaderBuffer.offset, var8);
								if (NetCache.field3165 != 0) {
									for (var9 = 0; var9 < var8; ++var9) {
										var10000 = NetCache.NetCache_responseHeaderBuffer.array;
										var10001 = var9 + NetCache.NetCache_responseHeaderBuffer.offset;
										var10000[var10001] ^= NetCache.field3165;
									}
								}

								var25 = NetCache.NetCache_responseHeaderBuffer;
								var25.offset += var8;
								if (NetCache.NetCache_responseHeaderBuffer.offset < var7) {
									break;
								}

								if (UserComparator6.NetCache_currentResponse == null) {
									NetCache.NetCache_responseHeaderBuffer.offset = 0;
									var9 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
									var10 = NetCache.NetCache_responseHeaderBuffer.readUnsignedShort();
									int var11 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
									var12 = NetCache.NetCache_responseHeaderBuffer.readInt();
									long var13 = (long)(var10 + (var9 << 16));
									NetFileRequest var15 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.get(var13);
									AttackOption.field1151 = true;
									if (var15 == null) {
										var15 = (NetFileRequest)NetCache.NetCache_pendingResponses.get(var13);
										AttackOption.field1151 = false;
									}

									if (var15 == null) {
										throw new IOException();
									}

									int var16 = var11 == 0 ? 5 : 9;
									UserComparator6.NetCache_currentResponse = var15;
									Frames.NetCache_responseArchiveBuffer = new Buffer(var16 + var12 + UserComparator6.NetCache_currentResponse.padding);
									Frames.NetCache_responseArchiveBuffer.writeByte(var11);
									Frames.NetCache_responseArchiveBuffer.writeInt(var12);
									NetCache.field3161 = 8;
									NetCache.NetCache_responseHeaderBuffer.offset = 0;
								} else if (NetCache.field3161 == 0) {
									if (NetCache.NetCache_responseHeaderBuffer.array[0] == -1) {
										NetCache.field3161 = 1;
										NetCache.NetCache_responseHeaderBuffer.offset = 0;
									} else {
										UserComparator6.NetCache_currentResponse = null;
									}
								}
							} else {
								var8 = Frames.NetCache_responseArchiveBuffer.array.length - UserComparator6.NetCache_currentResponse.padding;
								var9 = 512 - NetCache.field3161;
								if (var9 > var8 - Frames.NetCache_responseArchiveBuffer.offset) {
									var9 = var8 - Frames.NetCache_responseArchiveBuffer.offset;
								}

								if (var9 > var18) {
									var9 = var18;
								}

								NetCache.NetCache_socket.read(Frames.NetCache_responseArchiveBuffer.array, Frames.NetCache_responseArchiveBuffer.offset, var9);
								if (NetCache.field3165 != 0) {
									for (var10 = 0; var10 < var9; ++var10) {
										var10000 = Frames.NetCache_responseArchiveBuffer.array;
										var10001 = Frames.NetCache_responseArchiveBuffer.offset + var10;
										var10000[var10001] ^= NetCache.field3165;
									}
								}

								var25 = Frames.NetCache_responseArchiveBuffer;
								var25.offset += var9;
								NetCache.field3161 += var9;
								if (var8 == Frames.NetCache_responseArchiveBuffer.offset) {
									if (UserComparator6.NetCache_currentResponse.key == 16711935L) {
										Calendar.NetCache_reference = Frames.NetCache_responseArchiveBuffer;

										for (var10 = 0; var10 < 256; ++var10) {
											Archive var19 = NetCache.NetCache_archives[var10];
											if (var19 != null) {
												Calendar.NetCache_reference.offset = var10 * 8 + 5;
												var12 = Calendar.NetCache_reference.readInt();
												int var20 = Calendar.NetCache_reference.readInt();
												var19.loadIndex(var12, var20);
											}
										}
									} else {
										NetCache.NetCache_crc.reset();
										NetCache.NetCache_crc.update(Frames.NetCache_responseArchiveBuffer.array, 0, var8);
										var10 = (int)NetCache.NetCache_crc.getValue();
										if (var10 != UserComparator6.NetCache_currentResponse.crc) {
											try {
												NetCache.NetCache_socket.close();
											} catch (Exception var23) {
											}

											++NetCache.NetCache_crcMismatches;
											NetCache.NetCache_socket = null;
											NetCache.field3165 = (byte)((int)(Math.random() * 255.0D + 1.0D));
											var1 = false;
											break label247;
										}

										NetCache.NetCache_crcMismatches = 0;
										NetCache.NetCache_ioExceptions = 0;
										UserComparator6.NetCache_currentResponse.archive.write((int)(UserComparator6.NetCache_currentResponse.key & 65535L), Frames.NetCache_responseArchiveBuffer.array, 16711680L == (UserComparator6.NetCache_currentResponse.key & 16711680L), AttackOption.field1151);
									}

									UserComparator6.NetCache_currentResponse.remove();
									if (AttackOption.field1151) {
										--NetCache.NetCache_pendingPriorityResponsesCount;
									} else {
										--NetCache.NetCache_pendingResponsesCount;
									}

									NetCache.field3161 = 0;
									UserComparator6.NetCache_currentResponse = null;
									Frames.NetCache_responseArchiveBuffer = null;
								} else {
									if (NetCache.field3161 != 512) {
										break;
									}

									NetCache.field3161 = 0;
								}
							}
						}

						var1 = true;
					}
				} catch (IOException var24) {
					try {
						NetCache.NetCache_socket.close();
					} catch (Exception var22) {
					}

					++NetCache.NetCache_ioExceptions;
					NetCache.NetCache_socket = null;
					var1 = false;
				}
			}

			if (!var1) {
				this.doCycleJs5Connect();
			}

		}
	}

	@ObfuscatedName("fy")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "40"
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

				field819 = 3000;
				NetCache.NetCache_ioExceptions = 3;
			}

			if (--field819 + 1 <= 0) {
				try {
					if (js5ConnectState == 0) {
						Entity.js5SocketTask = GameShell.taskHandler.newSocketTask(WorldMapAreaData.worldHost, GrandExchangeOfferUnitPriceComparator.port3);
						++js5ConnectState;
					}

					if (js5ConnectState == 1) {
						if (Entity.js5SocketTask.status == 2) {
							this.js5Error(-1);
							return;
						}

						if (Entity.js5SocketTask.status == 1) {
							++js5ConnectState;
						}
					}

					if (js5ConnectState == 2) {
						if (useBufferedSocket) {
							js5Socket = class40.method839((Socket)Entity.js5SocketTask.result, 40000, 5000);
						} else {
							js5Socket = new NetSocket((Socket)Entity.js5SocketTask.result, GameShell.taskHandler, 5000);
						}

						Buffer var1 = new Buffer(5);
						var1.writeByte(15);
						var1.writeInt(185);
						js5Socket.write(var1.array, 0, 5);
						++js5ConnectState;
						ArchiveDiskActionHandler.field3130 = PlayerAppearance.currentTimeMillis();
					}

					if (js5ConnectState == 3) {
						if (js5Socket.available() > 0 || !useBufferedSocket && gameState <= 5) {
							int var2 = js5Socket.readUnsignedByte();
							if (var2 != 0) {
								this.js5Error(var2);
								return;
							}

							++js5ConnectState;
						} else if (PlayerAppearance.currentTimeMillis() - ArchiveDiskActionHandler.field3130 > 30000L) {
							this.js5Error(-2);
							return;
						}
					}

					if (js5ConnectState == 4) {
						VerticalAlignment.method4503(js5Socket, gameState > 20);
						Entity.js5SocketTask = null;
						js5Socket = null;
						js5ConnectState = 0;
						js5Errors = 0;
					}
				} catch (IOException var3) {
					this.js5Error(-3);
				}

			}
		}
	}

	@ObfuscatedName("fn")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1648884107"
	)
	@Export("js5Error")
	void js5Error(int var1) {
		Entity.js5SocketTask = null;
		js5Socket = null;
		js5ConnectState = 0;
		if (GrandExchangeOfferUnitPriceComparator.port3 == class222.port1) {
			GrandExchangeOfferUnitPriceComparator.port3 = Decimator.port2;
		} else {
			GrandExchangeOfferUnitPriceComparator.port3 = class222.port1;
		}

		++js5Errors;
		if (js5Errors >= 2 && (var1 == 7 || var1 == 9)) {
			if (gameState <= 5) {
				this.error("js5connect_full");
				gameState = 1000;
			} else {
				field819 = 3000;
			}
		} else if (js5Errors >= 2 && var1 == 6) {
			this.error("js5connect_outofdate");
			gameState = 1000;
		} else if (js5Errors >= 4) {
			if (gameState <= 5) {
				this.error("js5connect");
				gameState = 1000;
			} else {
				field819 = 3000;
			}
		}

	}

	@ObfuscatedName("fk")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2145880760"
	)
	@Export("doCycleLoggedOut")
	final void doCycleLoggedOut() {
		Object var1 = packetWriter.getSocket();
		PacketBuffer var2 = packetWriter.packetBuffer;

		try {
			if (loginState == 0) {
				if (GZipDecompressor.secureRandom == null && (secureRandomFuture.isDone() || field666 > 250)) {
					GZipDecompressor.secureRandom = secureRandomFuture.get();
					secureRandomFuture.shutdown();
					secureRandomFuture = null;
				}

				if (GZipDecompressor.secureRandom != null) {
					if (var1 != null) {
						((AbstractSocket)var1).close();
						var1 = null;
					}

					AttackOption.socketTask = null;
					field680 = false;
					field666 = 0;
					loginState = 1;
				}
			}

			if (loginState == 1) {
				if (AttackOption.socketTask == null) {
					AttackOption.socketTask = GameShell.taskHandler.newSocketTask(WorldMapAreaData.worldHost, GrandExchangeOfferUnitPriceComparator.port3);
				}

				if (AttackOption.socketTask.status == 2) {
					throw new IOException();
				}

				if (AttackOption.socketTask.status == 1) {
					if (useBufferedSocket) {
						var1 = class40.method839((Socket)AttackOption.socketTask.result, 40000, 5000);
					} else {
						var1 = new NetSocket((Socket)AttackOption.socketTask.result, GameShell.taskHandler, 5000);
					}

					packetWriter.setSocket((AbstractSocket)var1);
					AttackOption.socketTask = null;
					loginState = 2;
				}
			}

			PacketBufferNode var4;
			if (loginState == 2) {
				packetWriter.clearBuffer();
				if (PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0) {
					var4 = new PacketBufferNode();
				} else {
					var4 = PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
				}

				var4.clientPacket = null;
				var4.clientPacketLength = 0;
				var4.packetBuffer = new PacketBuffer(5000);
				var4.packetBuffer.writeByte(LoginPacket.field2283.id);
				packetWriter.addNode(var4);
				packetWriter.flush();
				var2.offset = 0;
				loginState = 3;
			}

			boolean var14;
			int var15;
			if (loginState == 3) {
				if (class80.pcmPlayer0 != null) {
					class80.pcmPlayer0.method2581();
				}

				if (MenuAction.pcmPlayer1 != null) {
					MenuAction.pcmPlayer1.method2581();
				}

				var14 = true;
				if (useBufferedSocket && !((AbstractSocket)var1).isAvailable(1)) {
					var14 = false;
				}

				if (var14) {
					var15 = ((AbstractSocket)var1).readUnsignedByte();
					if (class80.pcmPlayer0 != null) {
						class80.pcmPlayer0.method2581();
					}

					if (MenuAction.pcmPlayer1 != null) {
						MenuAction.pcmPlayer1.method2581();
					}

					if (var15 != 0) {
						AbstractArchive.getLoginError(var15);
						return;
					}

					var2.offset = 0;
					loginState = 4;
				}
			}

			int var30;
			if (loginState == 4) {
				if (var2.offset < 8) {
					var30 = ((AbstractSocket)var1).available();
					if (var30 > 8 - var2.offset) {
						var30 = 8 - var2.offset;
					}

					if (var30 > 0) {
						((AbstractSocket)var1).read(var2.array, var2.offset, var30);
						var2.offset += var30;
					}
				}

				if (var2.offset == 8) {
					var2.offset = 0;
					Message.field577 = var2.readLong();
					loginState = 5;
				}
			}

			if (loginState == 5) {
				packetWriter.packetBuffer.offset = 0;
				packetWriter.clearBuffer();
				PacketBuffer var3 = new PacketBuffer(500);
				int[] var24 = new int[]{GZipDecompressor.secureRandom.nextInt(), GZipDecompressor.secureRandom.nextInt(), GZipDecompressor.secureRandom.nextInt(), GZipDecompressor.secureRandom.nextInt()};
				var3.offset = 0;
				var3.writeByte(1);
				var3.writeInt(var24[0]);
				var3.writeInt(var24[1]);
				var3.writeInt(var24[2]);
				var3.writeInt(var24[3]);
				var3.writeLong(Message.field577);
				if (gameState == 40) {
					var3.writeInt(class173.field2074[0]);
					var3.writeInt(class173.field2074[1]);
					var3.writeInt(class173.field2074[2]);
					var3.writeInt(class173.field2074[3]);
				} else {
					var3.writeByte(field850.rsOrdinal());
					switch(field850.field1983) {
					case 0:
					case 1:
						var3.writeMedium(Huffman.field2491);
						++var3.offset;
						break;
					case 2:
						var3.writeInt((Integer)ScriptEvent.clientPreferences.parameters.get(GrandExchangeEvents.method108(Login.Login_username)));
						break;
					case 3:
						var3.offset += 4;
					}

					var3.writeByte(class312.field3799.rsOrdinal());
					var3.writeStringCp1252NullTerminated(Login.Login_password);
				}

				var3.encryptRsa(class83.field1144, class83.field1145);
				class173.field2074 = var24;
				PacketBufferNode var6;
				if (PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0) {
					var6 = new PacketBufferNode();
				} else {
					var6 = PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
				}

				var6.clientPacket = null;
				var6.clientPacketLength = 0;
				var6.packetBuffer = new PacketBuffer(5000);
				var6.packetBuffer.offset = 0;
				if (gameState == 40) {
					var6.packetBuffer.writeByte(LoginPacket.field2286.id);
				} else {
					var6.packetBuffer.writeByte(LoginPacket.field2285.id);
				}

				var6.packetBuffer.writeShort(0);
				int var16 = var6.packetBuffer.offset;
				var6.packetBuffer.writeInt(185);
				var6.packetBuffer.writeInt(1);
				var6.packetBuffer.writeByte(clientType);
				var6.packetBuffer.writeBytes(var3.array, 0, var3.offset);
				int var8 = var6.packetBuffer.offset;
				var6.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
				var6.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
				var6.packetBuffer.writeShort(class286.canvasWidth);
				var6.packetBuffer.writeShort(FloorUnderlayDefinition.canvasHeight);
				PacketBuffer var9 = var6.packetBuffer;
				int var12;
				if (randomDatData != null) {
					var9.writeBytes(randomDatData, 0, randomDatData.length);
				} else {
					byte[] var11 = new byte[24];

					try {
						JagexCache.JagexCache_randomDat.seek(0L);
						JagexCache.JagexCache_randomDat.readFully(var11);

						for (var12 = 0; var12 < 24 && var11[var12] == 0; ++var12) {
						}

						if (var12 >= 24) {
							throw new IOException();
						}
					} catch (Exception var21) {
						for (int var13 = 0; var13 < 24; ++var13) {
							var11[var13] = -1;
						}
					}

					var9.writeBytes(var11, 0, var11.length);
				}

				var6.packetBuffer.writeStringCp1252NullTerminated(MilliClock.field1994);
				var6.packetBuffer.writeInt(class339.field4041);
				Buffer var10 = new Buffer(class216.platformInfo.size());
				class216.platformInfo.write(var10);
				var6.packetBuffer.writeBytes(var10.array, 0, var10.array.length);
				var6.packetBuffer.writeByte(clientType);
				var6.packetBuffer.writeInt(0);
				var6.packetBuffer.writeInt(BuddyRankComparator.archive0.hash);
				var6.packetBuffer.writeInt(LoginPacket.archive1.hash);
				var6.packetBuffer.writeInt(AbstractWorldMapIcon.archive2.hash);
				var6.packetBuffer.writeInt(SpriteMask.archive3.hash);
				var6.packetBuffer.writeInt(NetFileRequest.archive4.hash);
				var6.packetBuffer.writeInt(WorldMapRectangle.archive5.hash);
				var6.packetBuffer.writeInt(class216.archive6.hash);
				var6.packetBuffer.writeInt(Language.archive7.hash);
				var6.packetBuffer.writeInt(GrandExchangeOfferUnitPriceComparator.archive8.hash);
				var6.packetBuffer.writeInt(WorldMapSprite.archive9.hash);
				var6.packetBuffer.writeInt(WorldMapID.archive10.hash);
				var6.packetBuffer.writeInt(Decimator.archive11.hash);
				var6.packetBuffer.writeInt(Occluder.archive12.hash);
				var6.packetBuffer.writeInt(UrlRequest.archive13.hash);
				var6.packetBuffer.writeInt(class192.archive14.hash);
				var6.packetBuffer.writeInt(Coord.archive15.hash);
				var6.packetBuffer.writeInt(0);
				var6.packetBuffer.writeInt(DesktopPlatformInfoProvider.archive17.hash);
				var6.packetBuffer.writeInt(WorldMapDecoration.archive18.hash);
				var6.packetBuffer.writeInt(ReflectionCheck.archive19.hash);
				var6.packetBuffer.writeInt(Actor.archive20.hash);
				var6.packetBuffer.xteaEncrypt(var24, var8, var6.packetBuffer.offset);
				var6.packetBuffer.writeLengthShort(var6.packetBuffer.offset - var16);
				packetWriter.addNode(var6);
				packetWriter.flush();
				packetWriter.isaacCipher = new IsaacCipher(var24);
				int[] var29 = new int[4];

				for (var12 = 0; var12 < 4; ++var12) {
					var29[var12] = var24[var12] + 50;
				}

				var2.newIsaacCipher(var29);
				loginState = 6;
			}

			if (loginState == 6 && ((AbstractSocket)var1).available() > 0) {
				var30 = ((AbstractSocket)var1).readUnsignedByte();
				if (var30 == 21 && gameState == 20) {
					loginState = 9;
				} else if (var30 == 2) {
					loginState = 11;
				} else if (var30 == 15 && gameState == 40) {
					packetWriter.serverPacketLength = -1;
					loginState = 16;
				} else if (var30 == 64) {
					loginState = 7;
				} else if (var30 == 23 && field667 < 1) {
					++field667;
					loginState = 0;
				} else {
					if (var30 != 29) {
						AbstractArchive.getLoginError(var30);
						return;
					}

					loginState = 14;
				}
			}

			if (loginState == 7 && ((AbstractSocket)var1).available() > 0) {
				WorldMapAreaData.field329 = ((AbstractSocket)var1).readUnsignedByte();
				loginState = 8;
			}

			if (loginState == 8 && ((AbstractSocket)var1).available() >= WorldMapAreaData.field329) {
				((AbstractSocket)var1).read(var2.array, 0, WorldMapAreaData.field329);
				var2.offset = 0;
				loginState = 6;
			}

			if (loginState == 9 && ((AbstractSocket)var1).available() > 0) {
				field668 = (((AbstractSocket)var1).readUnsignedByte() + 3) * 60;
				loginState = 10;
			}

			if (loginState == 10) {
				field666 = 0;
				GrandExchangeOffer.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field668 / 60 + " seconds.");
				if (--field668 <= 0) {
					loginState = 0;
				}

			} else {
				if (loginState == 11 && ((AbstractSocket)var1).available() >= 1) {
					class49.field399 = ((AbstractSocket)var1).readUnsignedByte();
					loginState = 12;
				}

				if (loginState == 12 && ((AbstractSocket)var1).available() >= class49.field399) {
					var14 = ((AbstractSocket)var1).readUnsignedByte() == 1;
					((AbstractSocket)var1).read(var2.array, 0, 4);
					var2.offset = 0;
					boolean var31 = false;
					if (var14) {
						var15 = var2.readByteIsaac() << 24;
						var15 |= var2.readByteIsaac() << 16;
						var15 |= var2.readByteIsaac() << 8;
						var15 |= var2.readByteIsaac();
						int var18 = GrandExchangeEvents.method108(Login.Login_username);
						if (ScriptEvent.clientPreferences.parameters.size() >= 10 && !ScriptEvent.clientPreferences.parameters.containsKey(var18)) {
							Iterator var28 = ScriptEvent.clientPreferences.parameters.entrySet().iterator();
							var28.next();
							var28.remove();
						}

						ScriptEvent.clientPreferences.parameters.put(var18, var15);
					}

					if (Login_isUsernameRemembered) {
						ScriptEvent.clientPreferences.rememberedUsername = Login.Login_username;
					} else {
						ScriptEvent.clientPreferences.rememberedUsername = null;
					}

					HitSplatDefinition.savePreferences();
					staffModLevel = ((AbstractSocket)var1).readUnsignedByte();
					playerMod = ((AbstractSocket)var1).readUnsignedByte() == 1;
					localPlayerIndex = ((AbstractSocket)var1).readUnsignedByte();
					localPlayerIndex <<= 8;
					localPlayerIndex += ((AbstractSocket)var1).readUnsignedByte();
					field749 = ((AbstractSocket)var1).readUnsignedByte();
					((AbstractSocket)var1).read(var2.array, 0, 1);
					var2.offset = 0;
					ServerPacket[] var5 = SecureRandomCallable.ServerPacket_values();
					int var19 = var2.readSmartByteShortIsaac();
					if (var19 < 0 || var19 >= var5.length) {
						throw new IOException(var19 + " " + var2.offset);
					}

					packetWriter.serverPacket = var5[var19];
					packetWriter.serverPacketLength = packetWriter.serverPacket.length;
					((AbstractSocket)var1).read(var2.array, 0, 2);
					var2.offset = 0;
					packetWriter.serverPacketLength = var2.readUnsignedShort();

					try {
						class47.method923(WorldMapID.client, "zap");
					} catch (Throwable var20) {
					}

					loginState = 13;
				}

				if (loginState == 13) {
					if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
						timer.method5119();
						GrandExchangeOfferTotalQuantityComparator.method130();
						ArchiveLoader.updatePlayer(var2);
						WorldMapSectionType.field140 = -1;
						Clock.loadRegions(false, var2);
						packetWriter.serverPacket = null;
					}

				} else {
					if (loginState == 14 && ((AbstractSocket)var1).available() >= 2) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, 2);
						var2.offset = 0;
						WorldMapData_0.field92 = var2.readUnsignedShort();
						loginState = 15;
					}

					if (loginState == 15 && ((AbstractSocket)var1).available() >= WorldMapData_0.field92) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, WorldMapData_0.field92);
						var2.offset = 0;
						String var23 = var2.readStringCp1252NullTerminated();
						String var25 = var2.readStringCp1252NullTerminated();
						String var26 = var2.readStringCp1252NullTerminated();
						GrandExchangeOffer.setLoginResponseString(var23, var25, var26);
						Tile.updateGameState(10);
					}

					if (loginState != 16) {
						++field666;
						if (field666 > 2000) {
							if (field667 < 1) {
								if (GrandExchangeOfferUnitPriceComparator.port3 == class222.port1) {
									GrandExchangeOfferUnitPriceComparator.port3 = Decimator.port2;
								} else {
									GrandExchangeOfferUnitPriceComparator.port3 = class222.port1;
								}

								++field667;
								loginState = 0;
							} else {
								AbstractArchive.getLoginError(-3);
							}
						}
					} else {
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
							var30 = packetWriter.serverPacketLength;
							timer.method5121();
							packetWriter.clearBuffer();
							packetWriter.packetBuffer.offset = 0;
							packetWriter.serverPacket = null;
							packetWriter.field1290 = null;
							packetWriter.field1286 = null;
							packetWriter.field1292 = null;
							packetWriter.serverPacketLength = 0;
							packetWriter.field1291 = 0;
							rebootTimer = 0;
							menuOptionsCount = 0;
							isMenuOpen = false;
							minimapState = 0;
							destinationX = 0;

							for (var15 = 0; var15 < 2048; ++var15) {
								players[var15] = null;
							}

							class215.localPlayer = null;

							for (var15 = 0; var15 < npcs.length; ++var15) {
								NPC var27 = npcs[var15];
								if (var27 != null) {
									var27.targetIndex = -1;
									var27.false0 = false;
								}
							}

							ItemContainer.itemContainers = new NodeHashTable(32);
							Tile.updateGameState(30);

							for (var15 = 0; var15 < 100; ++var15) {
								field842[var15] = true;
							}

							var4 = SoundSystem.getPacketBufferNode(ClientPacket.field2257, packetWriter.isaacCipher);
							var4.packetBuffer.writeByte(WallDecoration.getWindowedMode());
							var4.packetBuffer.writeShort(class286.canvasWidth);
							var4.packetBuffer.writeShort(FloorUnderlayDefinition.canvasHeight);
							packetWriter.addNode(var4);
							ArchiveLoader.updatePlayer(var2);
							if (var30 != var2.offset) {
								throw new RuntimeException();
							}
						}
					}
				}
			}
		} catch (IOException var22) {
			if (field667 < 1) {
				if (class222.port1 == GrandExchangeOfferUnitPriceComparator.port3) {
					GrandExchangeOfferUnitPriceComparator.port3 = Decimator.port2;
				} else {
					GrandExchangeOfferUnitPriceComparator.port3 = class222.port1;
				}

				++field667;
				loginState = 0;
			} else {
				AbstractArchive.getLoginError(-2);
			}
		}
	}

	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "80"
	)
	@Export("doCycleLoggedIn")
	final void doCycleLoggedIn() {
		if (rebootTimer > 1) {
			--rebootTimer;
		}

		if (logoutTimer > 0) {
			--logoutTimer;
		}

		if (field680) {
			field680 = false;
			AbstractWorldMapIcon.method652();
		} else {
			if (!isMenuOpen) {
				ClientPacket.addCancelMenuEntry();
			}

			int var1;
			for (var1 = 0; var1 < 100 && this.method1720(packetWriter); ++var1) {
			}

			if (gameState == 30) {
				while (true) {
					ReflectionCheck var2 = (ReflectionCheck)class96.reflectionChecks.last();
					boolean var29;
					if (var2 == null) {
						var29 = false;
					} else {
						var29 = true;
					}

					int var3;
					PacketBufferNode var30;
					if (!var29) {
						PacketBufferNode var14;
						int var15;
						if (timer.field3568) {
							var14 = SoundSystem.getPacketBufferNode(ClientPacket.field2201, packetWriter.isaacCipher);
							var14.packetBuffer.writeByte(0);
							var15 = var14.packetBuffer.offset;
							timer.write(var14.packetBuffer);
							var14.packetBuffer.writeLengthByte(var14.packetBuffer.offset - var15);
							packetWriter.addNode(var14);
							timer.method5120();
						}

						int var4;
						int var5;
						int var6;
						int var7;
						int var8;
						int var9;
						int var10;
						int var11;
						int var12;
						PacketBuffer var10000;
						synchronized(class3.mouseRecorder.lock) {
							if (!field791) {
								class3.mouseRecorder.index = 0;
							} else if (MouseHandler.MouseHandler_lastButton != 0 || class3.mouseRecorder.index >= 40) {
								var30 = null;
								var3 = 0;
								var4 = 0;
								var5 = 0;
								var6 = 0;

								for (var7 = 0; var7 < class3.mouseRecorder.index && (var30 == null || var30.packetBuffer.offset - var3 < 246); ++var7) {
									var4 = var7;
									var8 = class3.mouseRecorder.ys[var7];
									if (var8 < -1) {
										var8 = -1;
									} else if (var8 > 65534) {
										var8 = 65534;
									}

									var9 = class3.mouseRecorder.xs[var7];
									if (var9 < -1) {
										var9 = -1;
									} else if (var9 > 65534) {
										var9 = 65534;
									}

									if (var9 != field644 || var8 != field905) {
										if (var30 == null) {
											var30 = SoundSystem.getPacketBufferNode(ClientPacket.field2183, packetWriter.isaacCipher);
											var30.packetBuffer.writeByte(0);
											var3 = var30.packetBuffer.offset;
											var10000 = var30.packetBuffer;
											var10000.offset += 2;
											var5 = 0;
											var6 = 0;
										}

										if (field646 != -1L) {
											var10 = var9 - field644;
											var11 = var8 - field905;
											var12 = (int)((class3.mouseRecorder.millis[var7] - field646) / 20L);
											var5 = (int)((long)var5 + (class3.mouseRecorder.millis[var7] - field646) % 20L);
										} else {
											var10 = var9;
											var11 = var8;
											var12 = Integer.MAX_VALUE;
										}

										field644 = var9;
										field905 = var8;
										if (var12 < 8 && var10 >= -32 && var10 <= 31 && var11 >= -32 && var11 <= 31) {
											var10 += 32;
											var11 += 32;
											var30.packetBuffer.writeShort((var12 << 12) + var11 + (var10 << 6));
										} else if (var12 < 32 && var10 >= -128 && var10 <= 127 && var11 >= -128 && var11 <= 127) {
											var10 += 128;
											var11 += 128;
											var30.packetBuffer.writeByte(var12 + 128);
											var30.packetBuffer.writeShort(var11 + (var10 << 8));
										} else if (var12 < 32) {
											var30.packetBuffer.writeByte(var12 + 192);
											if (var9 != -1 && var8 != -1) {
												var30.packetBuffer.writeInt(var9 | var8 << 16);
											} else {
												var30.packetBuffer.writeInt(Integer.MIN_VALUE);
											}
										} else {
											var30.packetBuffer.writeShort((var12 & 8191) + 57344);
											if (var9 != -1 && var8 != -1) {
												var30.packetBuffer.writeInt(var9 | var8 << 16);
											} else {
												var30.packetBuffer.writeInt(Integer.MIN_VALUE);
											}
										}

										++var6;
										field646 = class3.mouseRecorder.millis[var7];
									}
								}

								if (var30 != null) {
									var30.packetBuffer.writeLengthByte(var30.packetBuffer.offset - var3);
									var7 = var30.packetBuffer.offset;
									var30.packetBuffer.offset = var3;
									var30.packetBuffer.writeByte(var5 / var6);
									var30.packetBuffer.writeByte(var5 % var6);
									var30.packetBuffer.offset = var7;
									packetWriter.addNode(var30);
								}

								if (var4 >= class3.mouseRecorder.index) {
									class3.mouseRecorder.index = 0;
								} else {
									MouseRecorder var47 = class3.mouseRecorder;
									var47.index -= var4;
									System.arraycopy(class3.mouseRecorder.xs, var4, class3.mouseRecorder.xs, 0, class3.mouseRecorder.index);
									System.arraycopy(class3.mouseRecorder.ys, var4, class3.mouseRecorder.ys, 0, class3.mouseRecorder.index);
									System.arraycopy(class3.mouseRecorder.millis, var4, class3.mouseRecorder.millis, 0, class3.mouseRecorder.index);
								}
							}
						}

						PacketBufferNode var18;
						if (MouseHandler.MouseHandler_lastButton == 1 || !WorldMapLabelSize.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
							long var16 = (MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis * -1L) / 50L;
							if (var16 > 4095L) {
								var16 = 4095L;
							}

							mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis * -1L;
							var3 = MouseHandler.MouseHandler_lastPressedY;
							if (var3 < 0) {
								var3 = 0;
							} else if (var3 > FloorUnderlayDefinition.canvasHeight) {
								var3 = FloorUnderlayDefinition.canvasHeight;
							}

							var4 = MouseHandler.MouseHandler_lastPressedX;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > class286.canvasWidth) {
								var4 = class286.canvasWidth;
							}

							var5 = (int)var16;
							var18 = SoundSystem.getPacketBufferNode(ClientPacket.field2216, packetWriter.isaacCipher);
							var18.packetBuffer.writeShort((MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0) + (var5 << 1));
							var18.packetBuffer.writeShort(var4);
							var18.packetBuffer.writeShort(var3);
							packetWriter.addNode(var18);
						}

						if (KeyHandler.field384 > 0) {
							var14 = SoundSystem.getPacketBufferNode(ClientPacket.field2187, packetWriter.isaacCipher);
							var14.packetBuffer.writeShort(0);
							var15 = var14.packetBuffer.offset;
							long var19 = PlayerAppearance.currentTimeMillis();

							for (var5 = 0; var5 < KeyHandler.field384; ++var5) {
								long var21 = var19 - field663;
								if (var21 > 16777215L) {
									var21 = 16777215L;
								}

								field663 = var19;
								var14.packetBuffer.writeMedium((int)var21);
								var14.packetBuffer.writeByte(KeyHandler.field383[var5]);
							}

							var14.packetBuffer.writeLengthShort(var14.packetBuffer.offset - var15);
							packetWriter.addNode(var14);
						}

						if (field715 > 0) {
							--field715;
						}

						if (KeyHandler.KeyHandler_pressedKeys[96] || KeyHandler.KeyHandler_pressedKeys[97] || KeyHandler.KeyHandler_pressedKeys[98] || KeyHandler.KeyHandler_pressedKeys[99]) {
							field733 = true;
						}

						if (field733 && field715 <= 0) {
							field715 = 20;
							field733 = false;
							var14 = SoundSystem.getPacketBufferNode(ClientPacket.field2220, packetWriter.isaacCipher);
							var14.packetBuffer.method5644(camAngleY);
							var14.packetBuffer.writeShortLE(camAngleX);
							packetWriter.addNode(var14);
						}

						if (class30.hasFocus && !hadFocus) {
							hadFocus = true;
							var14 = SoundSystem.getPacketBufferNode(ClientPacket.field2209, packetWriter.isaacCipher);
							var14.packetBuffer.writeByte(1);
							packetWriter.addNode(var14);
						}

						if (!class30.hasFocus && hadFocus) {
							hadFocus = false;
							var14 = SoundSystem.getPacketBufferNode(ClientPacket.field2209, packetWriter.isaacCipher);
							var14.packetBuffer.writeByte(0);
							packetWriter.addNode(var14);
						}

						if (Login.worldMap != null) {
							Login.worldMap.method6427();
						}

						ModelData0.method3378();
						ScriptFrame.method1219();
						if (gameState != 30) {
							return;
						}

						for (PendingSpawn var37 = (PendingSpawn)pendingSpawns.last(); var37 != null; var37 = (PendingSpawn)pendingSpawns.previous()) {
							if (var37.hitpoints > 0) {
								--var37.hitpoints;
							}

							if (var37.hitpoints == 0) {
								if (var37.objectId < 0 || class296.method5547(var37.objectId, var37.field914)) {
									GrandExchangeOfferUnitPriceComparator.addPendingSpawnToScene(var37.plane, var37.type, var37.x, var37.y, var37.objectId, var37.field913, var37.field914);
									var37.remove();
								}
							} else {
								if (var37.delay > 0) {
									--var37.delay;
								}

								if (var37.delay == 0 && var37.x >= 1 && var37.y >= 1 && var37.x <= 102 && var37.y <= 102 && (var37.id < 0 || class296.method5547(var37.id, var37.field917))) {
									GrandExchangeOfferUnitPriceComparator.addPendingSpawnToScene(var37.plane, var37.type, var37.x, var37.y, var37.id, var37.orientation, var37.field917);
									var37.delay = -1;
									if (var37.id == var37.objectId && var37.objectId == -1) {
										var37.remove();
									} else if (var37.id == var37.objectId && var37.field913 == var37.orientation && var37.field917 == var37.field914) {
										var37.remove();
									}
								}
							}
						}

						int var10002;
						for (var1 = 0; var1 < soundEffectCount; ++var1) {
							var10002 = queuedSoundEffectDelays[var1]--;
							if (queuedSoundEffectDelays[var1] >= -10) {
								SoundEffect var31 = soundEffects[var1];
								if (var31 == null) {
									var10000 = null;
									var31 = SoundEffect.readSoundEffect(NetFileRequest.archive4, soundEffectIds[var1], 0);
									if (var31 == null) {
										continue;
									}

									int[] var48 = queuedSoundEffectDelays;
									var48[var1] += var31.calculateDelay();
									soundEffects[var1] = var31;
								}

								if (queuedSoundEffectDelays[var1] < 0) {
									if (soundLocations[var1] != 0) {
										var4 = (soundLocations[var1] & 255) * 128;
										var5 = soundLocations[var1] >> 16 & 255;
										var6 = var5 * 128 + 64 - class215.localPlayer.x;
										if (var6 < 0) {
											var6 = -var6;
										}

										var7 = soundLocations[var1] >> 8 & 255;
										var8 = var7 * 128 + 64 - class215.localPlayer.y;
										if (var8 < 0) {
											var8 = -var8;
										}

										var9 = var6 + var8 - 128;
										if (var9 > var4) {
											queuedSoundEffectDelays[var1] = -100;
											continue;
										}

										if (var9 < 0) {
											var9 = 0;
										}

										var3 = (var4 - var9) * areaSoundEffectVolume / var4;
									} else {
										var3 = soundEffectVolume;
									}

									if (var3 > 0) {
										RawSound var23 = var31.toRawSound().resample(AbstractWorldMapIcon.decimator);
										RawPcmStream var24 = RawPcmStream.createRawPcmStream(var23, 100, var3);
										var24.setNumLoops(queuedSoundEffectLoops[var1] - 1);
										FloorUnderlayDefinition.pcmStreamMixer.addSubStream(var24);
									}

									queuedSoundEffectDelays[var1] = -100;
								}
							} else {
								--soundEffectCount;

								for (var15 = var1; var15 < soundEffectCount; ++var15) {
									soundEffectIds[var15] = soundEffectIds[var15 + 1];
									soundEffects[var15] = soundEffects[var15 + 1];
									queuedSoundEffectLoops[var15] = queuedSoundEffectLoops[var15 + 1];
									queuedSoundEffectDelays[var15] = queuedSoundEffectDelays[var15 + 1];
									soundLocations[var15] = soundLocations[var15 + 1];
								}

								--var1;
							}
						}

						if (field855 && !Login.method2256()) {
							if (musicVolume != 0 && currentTrackGroupId != -1) {
								MusicPatchNode2.playMusicTrack(class216.archive6, currentTrackGroupId, 0, musicVolume, false);
							}

							field855 = false;
						}

						++packetWriter.field1291;
						if (packetWriter.field1291 > 750) {
							AbstractWorldMapIcon.method652();
							return;
						}

						WorldMapData_1.method767();

						for (var1 = 0; var1 < npcCount; ++var1) {
							var15 = npcIndices[var1];
							NPC var25 = npcs[var15];
							if (var25 != null) {
								HitSplatDefinition.calculateActorPosition(var25, var25.definition.size);
							}
						}

						KeyHandler.method913();
						++field693;
						if (mouseCrossColor != 0) {
							mouseCrossState = mouseCrossState * 400 + 400;
							if (mouseCrossState * 20 >= 400) {
								mouseCrossColor = 0;
							}
						}

						if (Login.field1165 != null) {
							++field753;
							if (field753 >= 15) {
								GrandExchangeOfferAgeComparator.invalidateWidget(Login.field1165);
								Login.field1165 = null;
							}
						}

						Widget var38 = ChatChannel.mousedOverWidgetIf1;
						Widget var32 = GrandExchangeEvents.field39;
						ChatChannel.mousedOverWidgetIf1 = null;
						GrandExchangeEvents.field39 = null;
						draggedOnWidget = null;
						field695 = false;
						field809 = false;
						field866 = 0;

						while (class237.isKeyDown() && field866 < 128) {
							if (staffModLevel >= 2 && KeyHandler.KeyHandler_pressedKeys[82] && WorldMapLabel.field229 == 66) {
								String var40 = "";

								Message var39;
								for (Iterator var42 = Messages.Messages_hashTable.iterator(); var42.hasNext(); var40 = var40 + var39.sender + ':' + var39.text + '\n') {
									var39 = (Message)var42.next();
								}

								WorldMapID.client.clipboardSetString(var40);
							} else if (oculusOrbState != 1 || DevicePcmPlayerProvider.field395 <= 0) {
								field854[field866] = WorldMapLabel.field229;
								field853[field866] = DevicePcmPlayerProvider.field395;
								++field866;
							}
						}

						if (PendingSpawn.method1854() && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81] && mouseWheelRotation != 0) {
							var3 = class215.localPlayer.Client_plane - mouseWheelRotation;
							if (var3 < 0) {
								var3 = 0;
							} else if (var3 > 3) {
								var3 = 3;
							}

							if (var3 != class215.localPlayer.Client_plane) {
								var4 = class215.localPlayer.pathX[0] + UserComparator8.baseX * 64;
								var5 = class215.localPlayer.pathY[0] + HealthBar.baseY * 64;
								var18 = SoundSystem.getPacketBufferNode(ClientPacket.field2228, packetWriter.isaacCipher);
								var18.packetBuffer.writeIntME(0);
								var18.packetBuffer.writeByte(var3);
								var18.packetBuffer.method5644(var5);
								var18.packetBuffer.writeShortLE(var4);
								packetWriter.addNode(var18);
							}

							mouseWheelRotation = 0;
						}

						if (rootInterface != -1) {
							ServerBuild.updateRootInterface(rootInterface, 0, 0, class286.canvasWidth, FloorUnderlayDefinition.canvasHeight, 0, 0);
						}

						++cycleCntr;

						while (true) {
							Widget var41;
							Widget var43;
							ScriptEvent var44;
							do {
								var44 = (ScriptEvent)field813.removeLast();
								if (var44 == null) {
									while (true) {
										do {
											var44 = (ScriptEvent)field832.removeLast();
											if (var44 == null) {
												while (true) {
													do {
														var44 = (ScriptEvent)scriptEvents.removeLast();
														if (var44 == null) {
															this.menu();
															JagexCache.method3624();
															if (clickedWidget != null) {
																this.method1414();
															}

															if (GrandExchangeOffer.dragInventoryWidget != null) {
																GrandExchangeOfferAgeComparator.invalidateWidget(GrandExchangeOffer.dragInventoryWidget);
																++itemDragDuration;
																if (MouseHandler.MouseHandler_currentButton == 0) {
																	if (field743) {
																		if (DirectByteArrayCopier.field2476 == GrandExchangeOffer.dragInventoryWidget && dragItemSlotSource != dragItemSlotDestination) {
																			Widget var46 = GrandExchangeOffer.dragInventoryWidget;
																			byte var33 = 0;
																			if (field907 == 1 && var46.contentType == 206) {
																				var33 = 1;
																			}

																			if (var46.itemIds[dragItemSlotDestination] <= 0) {
																				var33 = 0;
																			}

																			var6 = class195.getWidgetClickMask(var46);
																			boolean var34 = (var6 >> 29 & 1) != 0;
																			if (var34) {
																				var7 = dragItemSlotSource;
																				var8 = dragItemSlotDestination;
																				var46.itemIds[var8] = var46.itemIds[var7];
																				var46.itemQuantities[var8] = var46.itemQuantities[var7];
																				var46.itemIds[var7] = -1;
																				var46.itemQuantities[var7] = 0;
																			} else if (var33 == 1) {
																				var7 = dragItemSlotSource;
																				var8 = dragItemSlotDestination;

																				while (var8 != var7) {
																					if (var7 > var8) {
																						var46.swapItems(var7 - 1, var7);
																						--var7;
																					} else if (var7 < var8) {
																						var46.swapItems(var7 + 1, var7);
																						++var7;
																					}
																				}
																			} else {
																				var46.swapItems(dragItemSlotDestination, dragItemSlotSource);
																			}

																			PacketBufferNode var26 = SoundSystem.getPacketBufferNode(ClientPacket.field2205, packetWriter.isaacCipher);
																			var26.packetBuffer.method5644(dragItemSlotSource);
																			var26.packetBuffer.method5653(GrandExchangeOffer.dragInventoryWidget.id);
																			var26.packetBuffer.method5643(dragItemSlotDestination);
																			var26.packetBuffer.method5636(var33);
																			packetWriter.addNode(var26);
																		}
																	} else if (this.shouldLeftClickOpenMenu()) {
																		this.openMenu(field729, field741);
																	} else if (menuOptionsCount > 0) {
																		AbstractWorldMapData.method325(field729, field741);
																	}

																	field753 = 10;
																	MouseHandler.MouseHandler_lastButton = 0;
																	GrandExchangeOffer.dragInventoryWidget = null;
																} else if (itemDragDuration >= 5 && (MouseHandler.MouseHandler_x > field729 + 5 || MouseHandler.MouseHandler_x < field729 - 5 || MouseHandler.MouseHandler_y > field741 + 5 || MouseHandler.MouseHandler_y < field741 - 5)) {
																	field743 = true;
																}
															}

															PacketBufferNode var45;
															if (Scene.method3252()) {
																var3 = Scene.Scene_selectedX;
																var4 = Scene.Scene_selectedY;
																var45 = SoundSystem.getPacketBufferNode(ClientPacket.field2243, packetWriter.isaacCipher);
																var45.packetBuffer.writeByte(5);
																var45.packetBuffer.writeShort(UserComparator8.baseX * 64 + var3);
																var45.packetBuffer.method5634(KeyHandler.KeyHandler_pressedKeys[82] ? (KeyHandler.KeyHandler_pressedKeys[81] ? 2 : 1) : 0);
																var45.packetBuffer.writeShort(HealthBar.baseY * 64 + var4);
																packetWriter.addNode(var45);
																Scene.method3281();
																mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
																mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
																mouseCrossColor = 1;
																mouseCrossState = 0;
																destinationX = var3;
																destinationY = var4;
															}

															if (var38 != ChatChannel.mousedOverWidgetIf1) {
																if (var38 != null) {
																	GrandExchangeOfferAgeComparator.invalidateWidget(var38);
																}

																if (ChatChannel.mousedOverWidgetIf1 != null) {
																	GrandExchangeOfferAgeComparator.invalidateWidget(ChatChannel.mousedOverWidgetIf1);
																}
															}

															if (var32 != GrandExchangeEvents.field39 && field783 == field782) {
																if (var32 != null) {
																	GrandExchangeOfferAgeComparator.invalidateWidget(var32);
																}

																if (GrandExchangeEvents.field39 != null) {
																	GrandExchangeOfferAgeComparator.invalidateWidget(GrandExchangeEvents.field39);
																}
															}

															if (GrandExchangeEvents.field39 != null) {
																if (field782 < field783) {
																	++field782;
																	if (field782 == field783) {
																		GrandExchangeOfferAgeComparator.invalidateWidget(GrandExchangeEvents.field39);
																	}
																}
															} else if (field782 > 0) {
																--field782;
															}

															if (oculusOrbState == 0) {
																var3 = class215.localPlayer.x;
																var4 = class215.localPlayer.y;
																if (IgnoreList.oculusOrbFocalPointX - var3 < -500 || IgnoreList.oculusOrbFocalPointX - var3 > 500 || AbstractArchive.oculusOrbFocalPointY - var4 < -500 || AbstractArchive.oculusOrbFocalPointY - var4 > 500) {
																	IgnoreList.oculusOrbFocalPointX = var3;
																	AbstractArchive.oculusOrbFocalPointY = var4;
																}

																if (var3 != IgnoreList.oculusOrbFocalPointX) {
																	IgnoreList.oculusOrbFocalPointX += (var3 - IgnoreList.oculusOrbFocalPointX) / 16;
																}

																if (var4 != AbstractArchive.oculusOrbFocalPointY) {
																	AbstractArchive.oculusOrbFocalPointY += (var4 - AbstractArchive.oculusOrbFocalPointY) / 16;
																}

																var5 = IgnoreList.oculusOrbFocalPointX >> 7;
																var6 = AbstractArchive.oculusOrbFocalPointY >> 7;
																var7 = GraphicsObject.getTileHeight(IgnoreList.oculusOrbFocalPointX, AbstractArchive.oculusOrbFocalPointY, Player.Client_plane);
																var8 = 0;
																if (var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
																	for (var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
																		for (var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
																			var11 = Player.Client_plane;
																			if (var11 < 3 && (Tiles.Tiles_renderFlags[1][var9][var10] & 2) == 2) {
																				++var11;
																			}

																			var12 = var7 - Tiles.Tiles_heights[var11][var9][var10];
																			if (var12 > var8) {
																				var8 = var12;
																			}
																		}
																	}
																}

																var9 = var8 * 192;
																if (var9 > 98048) {
																	var9 = 98048;
																}

																if (var9 < 32768) {
																	var9 = 32768;
																}

																if (var9 > field717) {
																	field717 += (var9 - field717) / 24;
																} else if (var9 < field717) {
																	field717 += (var9 - field717) / 80;
																}

																Tiles.field497 = GraphicsObject.getTileHeight(class215.localPlayer.x, class215.localPlayer.y, Player.Client_plane) - camFollowHeight;
															} else if (oculusOrbState == 1) {
																FontName.method5443();
																short var35 = -1;
																if (KeyHandler.KeyHandler_pressedKeys[33]) {
																	var35 = 0;
																} else if (KeyHandler.KeyHandler_pressedKeys[49]) {
																	var35 = 1024;
																}

																if (KeyHandler.KeyHandler_pressedKeys[48]) {
																	if (var35 == 0) {
																		var35 = 1792;
																	} else if (var35 == 1024) {
																		var35 = 1280;
																	} else {
																		var35 = 1536;
																	}
																} else if (KeyHandler.KeyHandler_pressedKeys[50]) {
																	if (var35 == 0) {
																		var35 = 256;
																	} else if (var35 == 1024) {
																		var35 = 768;
																	} else {
																		var35 = 512;
																	}
																}

																byte var36 = 0;
																if (KeyHandler.KeyHandler_pressedKeys[35]) {
																	var36 = -1;
																} else if (KeyHandler.KeyHandler_pressedKeys[51]) {
																	var36 = 1;
																}

																var5 = 0;
																if (var35 >= 0 || var36 != 0) {
																	var5 = KeyHandler.KeyHandler_pressedKeys[81] ? oculusOrbSlowedSpeed : oculusOrbNormalSpeed;
																	var5 *= 16;
																	field709 = var35;
																	field710 = var36;
																}

																if (field876 < var5) {
																	field876 += var5 / 8;
																	if (field876 > var5) {
																		field876 = var5;
																	}
																} else if (field876 > var5) {
																	field876 = field876 * 9 / 10;
																}

																if (field876 > 0) {
																	var6 = field876 / 16;
																	if (field709 >= 0) {
																		var3 = field709 - WorldMapData_1.cameraYaw & 2047;
																		var7 = Rasterizer3D.Rasterizer3D_sine[var3];
																		var8 = Rasterizer3D.Rasterizer3D_cosine[var3];
																		IgnoreList.oculusOrbFocalPointX += var7 * var6 / 65536;
																		AbstractArchive.oculusOrbFocalPointY += var6 * var8 / 65536;
																	}

																	if (field710 != 0) {
																		Tiles.field497 += var6 * field710;
																		if (Tiles.field497 > 0) {
																			Tiles.field497 = 0;
																		}
																	}
																} else {
																	field709 = -1;
																	field710 = -1;
																}

																if (KeyHandler.KeyHandler_pressedKeys[13]) {
																	LoginPacket.method3767();
																}
															}

															if (MouseHandler.MouseHandler_currentButton == 4 && WorldMapLabelSize.mouseCam) {
																var3 = MouseHandler.MouseHandler_y - mouseCamClickedY;
																camAngleDX = var3 * 2;
																mouseCamClickedY = var3 != -1 && var3 != 1 ? (MouseHandler.MouseHandler_y + mouseCamClickedY) / 2 : MouseHandler.MouseHandler_y;
																var4 = mouseCamClickedX - MouseHandler.MouseHandler_x;
																camAngleDY = var4 * 2;
																mouseCamClickedX = var4 != -1 && var4 != 1 ? (MouseHandler.MouseHandler_x + mouseCamClickedX) / 2 : MouseHandler.MouseHandler_x;
															} else {
																if (KeyHandler.KeyHandler_pressedKeys[96]) {
																	camAngleDY += (-24 - camAngleDY) / 2;
																} else if (KeyHandler.KeyHandler_pressedKeys[97]) {
																	camAngleDY += (24 - camAngleDY) / 2;
																} else {
																	camAngleDY /= 2;
																}

																if (KeyHandler.KeyHandler_pressedKeys[98]) {
																	camAngleDX += (12 - camAngleDX) / 2;
																} else if (KeyHandler.KeyHandler_pressedKeys[99]) {
																	camAngleDX += (-12 - camAngleDX) / 2;
																} else {
																	camAngleDX /= 2;
																}

																mouseCamClickedY = MouseHandler.MouseHandler_y;
																mouseCamClickedX = MouseHandler.MouseHandler_x;
															}

															camAngleY = camAngleDY / 2 + camAngleY & 2047;
															camAngleX += camAngleDX / 2;
															if (camAngleX < 128) {
																camAngleX = 128;
															}

															if (camAngleX > 383) {
																camAngleX = 383;
															}

															if (isCameraLocked) {
																Script.method2383();
															}

															for (var3 = 0; var3 < 5; ++var3) {
																var10002 = field880[var3]++;
															}

															class1.varcs.tryWrite();
															var3 = UserComparator4.method3502();
															var4 = class1.method26();
															if (var3 > 15000 && var4 > 15000) {
																logoutTimer = 250;
																MouseHandler.MouseHandler_idleCycles = 14500;
																var45 = SoundSystem.getPacketBufferNode(ClientPacket.field2238, packetWriter.isaacCipher);
																packetWriter.addNode(var45);
															}

															PacketWriter.friendSystem.processFriendUpdates();
															++packetWriter.pendingWrites;
															if (packetWriter.pendingWrites > 50) {
																var45 = SoundSystem.getPacketBufferNode(ClientPacket.field2245, packetWriter.isaacCipher);
																packetWriter.addNode(var45);
															}

															try {
																packetWriter.flush();
															} catch (IOException var27) {
																AbstractWorldMapIcon.method652();
															}

															return;
														}

														var41 = var44.widget;
														if (var41.childIndex < 0) {
															break;
														}

														var43 = PacketBufferNode.getWidget(var41.parentId);
													} while(var43 == null || var43.children == null || var41.childIndex >= var43.children.length || var41 != var43.children[var41.childIndex]);

													GrandExchangeOfferAgeComparator.runScriptEvent(var44);
												}
											}

											var41 = var44.widget;
											if (var41.childIndex < 0) {
												break;
											}

											var43 = PacketBufferNode.getWidget(var41.parentId);
										} while(var43 == null || var43.children == null || var41.childIndex >= var43.children.length || var41 != var43.children[var41.childIndex]);

										GrandExchangeOfferAgeComparator.runScriptEvent(var44);
									}
								}

								var41 = var44.widget;
								if (var41.childIndex < 0) {
									break;
								}

								var43 = PacketBufferNode.getWidget(var41.parentId);
							} while(var43 == null || var43.children == null || var41.childIndex >= var43.children.length || var41 != var43.children[var41.childIndex]);

							GrandExchangeOfferAgeComparator.runScriptEvent(var44);
						}
					}

					var30 = SoundSystem.getPacketBufferNode(ClientPacket.field2275, packetWriter.isaacCipher);
					var30.packetBuffer.writeByte(0);
					var3 = var30.packetBuffer.offset;
					class32.performReflectionCheck(var30.packetBuffer);
					var30.packetBuffer.writeLengthByte(var30.packetBuffer.offset - var3);
					packetWriter.addNode(var30);
				}
			}
		}
	}

	@ObfuscatedName("gg")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "-18793"
	)
	@Export("resizeJS")
	void resizeJS() {
		int var1 = class286.canvasWidth;
		int var2 = FloorUnderlayDefinition.canvasHeight;
		if (super.contentWidth < var1) {
			var1 = super.contentWidth;
		}

		if (super.contentHeight < var2) {
			var2 = super.contentHeight;
		}

		if (ScriptEvent.clientPreferences != null) {
			try {
				Client var3 = WorldMapID.client;
				Object[] var4 = new Object[]{WallDecoration.getWindowedMode()};
				JSObject.getWindow(var3).call("resize", var4);
			} catch (Throwable var5) {
			}
		}

	}

	@ObfuscatedName("gq")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "100"
	)
	@Export("drawLoggedIn")
	final void drawLoggedIn() {
		if (rootInterface != -1) {
			AbstractWorldMapData.method326(rootInterface);
		}

		int var1;
		for (var1 = 0; var1 < rootWidgetCount; ++var1) {
			if (field842[var1]) {
				field837[var1] = true;
			}

			field631[var1] = field842[var1];
			field842[var1] = false;
		}

		field835 = cycle;
		viewportX = -1;
		viewportY = -1;
		DirectByteArrayCopier.field2476 = null;
		if (rootInterface != -1) {
			rootWidgetCount = 0;
			ScriptEvent.drawWidgets(rootInterface, 0, 0, class286.canvasWidth, FloorUnderlayDefinition.canvasHeight, 0, 0, -1);
		}

		Rasterizer2D.Rasterizer2D_resetClip();
		if (showMouseCross) {
			if (mouseCrossColor == 1) {
				TextureProvider.crossSprites[mouseCrossState * 20 / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}

			if (mouseCrossColor == 2) {
				TextureProvider.crossSprites[mouseCrossState * 20 / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}
		}

		int var2;
		int var3;
		if (!isMenuOpen) {
			if (viewportX != -1) {
				var1 = viewportX;
				var2 = viewportY;
				if ((menuOptionsCount >= 2 || isItemSelected != 0 || isSpellSelected) && showMouseOverText) {
					var3 = class16.getNewestMenuIdx();
					String var12;
					if (isItemSelected == 1 && menuOptionsCount < 2) {
						var12 = "Use" + " " + selectedItemName + " " + "->";
					} else if (isSpellSelected && menuOptionsCount < 2) {
						var12 = selectedSpellActionName + " " + selectedSpellName + " " + "->";
					} else {
						var12 = class65.method1316(var3);
					}

					if (menuOptionsCount > 2) {
						var12 = var12 + AbstractArchive.colorStartTag(16777215) + " " + '/' + " " + (menuOptionsCount - 2) + " more options";
					}

					class43.fontBold12.drawRandomAlphaAndSpacing(var12, var1 + 4, var2 + 15, 16777215, 0, cycle / 1000);
				}
			}
		} else {
			WorldMapSection2.method383();
		}

		if (gameDrawingMode == 3) {
			for (var1 = 0; var1 < rootWidgetCount; ++var1) {
				if (field631[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
				} else if (field837[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
				}
			}
		}

		var1 = Player.Client_plane;
		var2 = class215.localPlayer.x;
		var3 = class215.localPlayer.y;
		int var4 = field693;

		for (ObjectSound var5 = (ObjectSound)ObjectSound.objectSounds.last(); var5 != null; var5 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var5.soundEffectId != -1 || var5.soundEffectIds != null) {
				int var6 = 0;
				if (var2 > var5.field1060 * 128) {
					var6 += var2 - var5.field1060 * 128;
				} else if (var2 < var5.x * 16384) {
					var6 += var5.x * 16384 - var2;
				}

				if (var3 > var5.field1053 * 128) {
					var6 += var3 - var5.field1053 * 128;
				} else if (var3 < var5.y * 128) {
					var6 += var5.y * 128 - var3;
				}

				if (var6 - 64 <= var5.field1052 && areaSoundEffectVolume != 0 && var1 == var5.plane) {
					var6 -= 64;
					if (var6 < 0) {
						var6 = 0;
					}

					int var7 = (var5.field1052 - var6) * areaSoundEffectVolume / var5.field1052;
					Object var10000;
					if (var5.stream1 == null) {
						if (var5.soundEffectId >= 0) {
							var10000 = null;
							SoundEffect var8 = SoundEffect.readSoundEffect(NetFileRequest.archive4, var5.soundEffectId, 0);
							if (var8 != null) {
								RawSound var9 = var8.toRawSound().resample(AbstractWorldMapIcon.decimator);
								RawPcmStream var10 = RawPcmStream.createRawPcmStream(var9, 100, var7);
								var10.setNumLoops(-1);
								FloorUnderlayDefinition.pcmStreamMixer.addSubStream(var10);
								var5.stream1 = var10;
							}
						}
					} else {
						var5.stream1.method2702(var7);
					}

					if (var5.stream2 == null) {
						if (var5.soundEffectIds != null && (var5.field1054 -= var4) <= 0) {
							int var13 = (int)(Math.random() * (double)var5.soundEffectIds.length);
							var10000 = null;
							SoundEffect var14 = SoundEffect.readSoundEffect(NetFileRequest.archive4, var5.soundEffectIds[var13], 0);
							if (var14 != null) {
								RawSound var15 = var14.toRawSound().resample(AbstractWorldMapIcon.decimator);
								RawPcmStream var11 = RawPcmStream.createRawPcmStream(var15, 100, var7);
								var11.setNumLoops(0);
								FloorUnderlayDefinition.pcmStreamMixer.addSubStream(var11);
								var5.stream2 = var11;
								var5.field1054 = var5.field1057 + (int)(Math.random() * (double)(var5.field1058 - var5.field1057));
							}
						}
					} else {
						var5.stream2.method2702(var7);
						if (!var5.stream2.hasNext()) {
							var5.stream2 = null;
						}
					}
				} else {
					if (var5.stream1 != null) {
						FloorUnderlayDefinition.pcmStreamMixer.removeSubStream(var5.stream1);
						var5.stream1 = null;
					}

					if (var5.stream2 != null) {
						FloorUnderlayDefinition.pcmStreamMixer.removeSubStream(var5.stream2);
						var5.stream2 = null;
					}
				}
			}
		}

		field693 = 0;
	}

	@ObfuscatedName("hm")
	@ObfuscatedSignature(
		signature = "(Lcp;I)Z",
		garbageValue = "823373866"
	)
	final boolean method1720(PacketWriter var1) {
		AbstractSocket var2 = var1.getSocket();
		PacketBuffer var3 = var1.packetBuffer;
		if (var2 == null) {
			return false;
		} else {
			int var6;
			String var17;
			try {
				int var5;
				if (var1.serverPacket == null) {
					if (var1.field1287) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 0, 1);
						var1.field1291 = 0;
						var1.field1287 = false;
					}

					var3.offset = 0;
					if (var3.method5586()) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 1, 1);
						var1.field1291 = 0;
					}

					var1.field1287 = true;
					ServerPacket[] var4 = SecureRandomCallable.ServerPacket_values();
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
				var1.field1291 = 0;
				timer.method5115();
				var1.field1292 = var1.field1286;
				var1.field1286 = var1.field1290;
				var1.field1290 = var1.serverPacket;
				if (ServerPacket.field2126 == var1.serverPacket) {
					rebootTimer = var3.method5646() * 30;
					field834 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				int var16;
				if (ServerPacket.field2129 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					if (var3.readUnsignedByte() == 0) {
						grandExchangeOffers[var16] = new GrandExchangeOffer();
						var3.offset += 18;
					} else {
						--var3.offset;
						grandExchangeOffers[var16] = new GrandExchangeOffer(var3, false);
					}

					field826 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				int var7;
				int var8;
				long var9;
				if (ServerPacket.field2176 == var1.serverPacket) {
					var16 = var3.method5648();
					if (var16 == 65535) {
						var16 = -1;
					}

					var5 = var3.method5796();
					var6 = var3.readUnsignedShort();
					if (var6 == 65535) {
						var6 = -1;
					}

					var7 = var3.method5656();

					for (var8 = var16; var8 <= var6; ++var8) {
						var9 = ((long)var7 << 32) + (long)var8;
						Node var44 = widgetClickMasks.get(var9);
						if (var44 != null) {
							var44.remove();
						}

						widgetClickMasks.put(new IntegerNode(var5), var9);
					}

					var1.serverPacket = null;
					return true;
				}

				boolean var46;
				if (ServerPacket.field2122 == var1.serverPacket) {
					var46 = var3.readUnsignedByte() == 1;
					if (var46) {
						Message.field584 = PlayerAppearance.currentTimeMillis() - var3.readLong();
						WorldMapData_1.grandExchangeEvents = new GrandExchangeEvents(var3, true);
					} else {
						WorldMapData_1.grandExchangeEvents = null;
					}

					field652 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2140 == var1.serverPacket) {
					hintArrowType = var3.readUnsignedByte();
					if (hintArrowType == 1) {
						hintArrowNpcIndex = var3.readUnsignedShort();
					}

					if (hintArrowType >= 2 && hintArrowType <= 6) {
						if (hintArrowType == 2) {
							hintArrowSubX = 4096;
							hintArrowSubY = 4096;
						}

						if (hintArrowType == 3) {
							hintArrowSubX = 0;
							hintArrowSubY = 4096;
						}

						if (hintArrowType == 4) {
							hintArrowSubX = 8192;
							hintArrowSubY = 4096;
						}

						if (hintArrowType == 5) {
							hintArrowSubX = 4096;
							hintArrowSubY = 0;
						}

						if (hintArrowType == 6) {
							hintArrowSubX = 4096;
							hintArrowSubY = 8192;
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

				String var50;
				if (ServerPacket.field2162 == var1.serverPacket) {
					byte[] var40 = new byte[var1.serverPacketLength];
					var3.method5558(var40, 0, var40.length);
					Buffer var54 = new Buffer(var40);
					var50 = var54.readStringCp1252NullTerminated();
					class2.openURL(var50, true, false);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2111 == var1.serverPacket) {
					AbstractWorldMapData.updateNpcs(true, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2095 == var1.serverPacket) {
					Clock.loadRegions(true, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2127 == var1.serverPacket) {
					var16 = var3.readInt();
					if (var16 != field799) {
						field799 = var16;
						WorldMapSection1.method650();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2135 == var1.serverPacket) {
					class319.updatePlayers(var3, var1.serverPacketLength);
					BoundaryObject.method3394();
					var1.serverPacket = null;
					return true;
				}

				Widget var48;
				if (ServerPacket.field2134 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.method5796();
					var48 = PacketBufferNode.getWidget(var5);
					if (var48.modelType != 1 || var16 != var48.modelId) {
						var48.modelType = 1;
						var48.modelId = var16;
						GrandExchangeOfferAgeComparator.invalidateWidget(var48);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2124 == var1.serverPacket) {
					WorldMapSprite.method474(class185.field2295);
					var1.serverPacket = null;
					return true;
				}

				int var19;
				if (ServerPacket.field2104 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var16 < -70000) {
						var5 += 32768;
					}

					if (var16 >= 0) {
						var48 = PacketBufferNode.getWidget(var16);
					} else {
						var48 = null;
					}

					for (; var3.offset < var1.serverPacketLength; WorldMapCacheName.itemContainerSetItem(var5, var7, var8 - 1, var19)) {
						var7 = var3.readUShortSmart();
						var8 = var3.readUnsignedShort();
						var19 = 0;
						if (var8 != 0) {
							var19 = var3.readUnsignedByte();
							if (var19 == 255) {
								var19 = var3.readInt();
							}
						}

						if (var48 != null && var7 >= 0 && var7 < var48.itemIds.length) {
							var48.itemIds[var7] = var8;
							var48.itemQuantities[var7] = var19;
						}
					}

					if (var48 != null) {
						GrandExchangeOfferAgeComparator.invalidateWidget(var48);
					}

					BoundaryObject.method3393();
					field816[++field820 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2136 == var1.serverPacket) {
					var16 = var3.method5646();
					WorldMapIcon_0.method252(var16);
					field816[++field820 - 1 & 31] = var16 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2167 == var1.serverPacket) {
					var16 = var3.readInt();
					InterfaceParent var53 = (InterfaceParent)interfaceParents.get((long)var16);
					if (var53 != null) {
						GrandExchangeOfferOwnWorldComparator.closeInterface(var53, true);
					}

					if (meslayerContinueWidget != null) {
						GrandExchangeOfferAgeComparator.invalidateWidget(meslayerContinueWidget);
						meslayerContinueWidget = null;
					}

					var1.serverPacket = null;
					return true;
				}

				long var12;
				int var21;
				InterfaceParent var55;
				if (ServerPacket.field2098 == var1.serverPacket) {
					var16 = var3.offset + var1.serverPacketLength;
					var5 = var3.readUnsignedShort();
					var6 = var3.readUnsignedShort();
					if (var5 != rootInterface) {
						rootInterface = var5;
						this.resizeRoot(false);
						WorldMapLabel.Widget_resetModelFrames(rootInterface);
						FaceNormal.runWidgetOnLoadListener(rootInterface);

						for (var7 = 0; var7 < 100; ++var7) {
							field842[var7] = true;
						}
					}

					InterfaceParent var43;
					for (; var6-- > 0; var43.field545 = true) {
						var7 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var19 = var3.readUnsignedByte();
						var43 = (InterfaceParent)interfaceParents.get((long)var7);
						if (var43 != null && var8 != var43.group) {
							GrandExchangeOfferOwnWorldComparator.closeInterface(var43, true);
							var43 = null;
						}

						if (var43 == null) {
							var43 = WorldMapDecoration.method385(var7, var8, var19);
						}
					}

					for (var55 = (InterfaceParent)interfaceParents.first(); var55 != null; var55 = (InterfaceParent)interfaceParents.next()) {
						if (var55.field545) {
							var55.field545 = false;
						} else {
							GrandExchangeOfferOwnWorldComparator.closeInterface(var55, true);
						}
					}

					widgetClickMasks = new NodeHashTable(512);

					while (var3.offset < var16) {
						var7 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var19 = var3.readUnsignedShort();
						var21 = var3.readInt();

						for (int var22 = var8; var22 <= var19; ++var22) {
							var12 = ((long)var7 << 32) + (long)var22;
							widgetClickMasks.put(new IntegerNode(var21), var12);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				Widget var23;
				if (ServerPacket.field2169 == var1.serverPacket) {
					var16 = var3.method5796();
					var5 = var3.readInt();
					InterfaceParent var57 = (InterfaceParent)interfaceParents.get((long)var16);
					var55 = (InterfaceParent)interfaceParents.get((long)var5);
					if (var55 != null) {
						GrandExchangeOfferOwnWorldComparator.closeInterface(var55, var57 == null || var55.group != var57.group);
					}

					if (var57 != null) {
						var57.remove();
						interfaceParents.put(var57, (long)var5);
					}

					var23 = PacketBufferNode.getWidget(var16);
					if (var23 != null) {
						GrandExchangeOfferAgeComparator.invalidateWidget(var23);
					}

					var23 = PacketBufferNode.getWidget(var5);
					if (var23 != null) {
						GrandExchangeOfferAgeComparator.invalidateWidget(var23);
						class43.revalidateWidgetScroll(Widget.Widget_interfaceComponents[var23.id >>> 16], var23, true);
					}

					if (rootInterface != -1) {
						AttackOption.runIntfCloseListeners(rootInterface, 1);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2159 == var1.serverPacket) {
					WorldMapSprite.method474(class185.field2297);
					var1.serverPacket = null;
					return true;
				}

				long var24;
				long var26;
				String var36;
				if (ServerPacket.field2148 == var1.serverPacket) {
					var36 = var3.readStringCp1252NullTerminated();
					var24 = var3.readLong();
					var26 = (long)var3.readUnsignedShort();
					var9 = (long)var3.readMedium();
					PlayerType var11 = (PlayerType)WorldMapIcon_1.findEnumerated(class51.PlayerType_values(), var3.readUnsignedByte());
					var12 = (var26 << 32) + var9;
					boolean var45 = false;

					for (int var15 = 0; var15 < 100; ++var15) {
						if (field852[var15] == var12) {
							var45 = true;
							break;
						}
					}

					if (var11.isUser && PacketWriter.friendSystem.isIgnored(new Username(var36, class60.loginType))) {
						var45 = true;
					}

					if (!var45 && field745 == 0) {
						field852[field721] = var12;
						field721 = (field721 + 1) % 100;
						String var28 = AbstractFont.escapeBrackets(class222.method4274(class4.method90(var3)));
						if (var11.modIcon != -1) {
							WorldMapLabel.addChatMessage(9, GrandExchangeEvent.method122(var11.modIcon) + var36, var28, WorldMapDecoration.base37DecodeLong(var24));
						} else {
							WorldMapLabel.addChatMessage(9, var36, var28, WorldMapDecoration.base37DecodeLong(var24));
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2096 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedByte();
					var7 = var3.readUnsignedByte();
					field641[var16] = true;
					field877[var16] = var5;
					field795[var16] = var6;
					field879[var16] = var7;
					field880[var16] = 0;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2091 == var1.serverPacket) {
					BoundaryObject.method3393();
					weight = var3.readShort();
					field834 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2161 == var1.serverPacket) {
					SpriteMask.field2501 = var3.method5622();
					GrandExchangeOffer.field61 = var3.method5622();

					for (var16 = SpriteMask.field2501; var16 < SpriteMask.field2501 + 8; ++var16) {
						for (var5 = GrandExchangeOffer.field61; var5 < GrandExchangeOffer.field61 + 8; ++var5) {
							if (groundItems[Player.Client_plane][var16][var5] != null) {
								groundItems[Player.Client_plane][var16][var5] = null;
								class4.updateItemPile(var16, var5);
							}
						}
					}

					for (PendingSpawn var38 = (PendingSpawn)pendingSpawns.last(); var38 != null; var38 = (PendingSpawn)pendingSpawns.previous()) {
						if (var38.x >= SpriteMask.field2501 && var38.x < SpriteMask.field2501 + 8 && var38.y >= GrandExchangeOffer.field61 && var38.y < GrandExchangeOffer.field61 + 8 && var38.plane == Player.Client_plane) {
							var38.hitpoints = 0;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2109 == var1.serverPacket) {
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

				Widget var20;
				if (ServerPacket.field2141 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					if (var16 == 65535) {
						var16 = -1;
					}

					var5 = var3.readInt();
					var6 = var3.method5603();
					var20 = PacketBufferNode.getWidget(var6);
					ItemDefinition var59;
					if (!var20.isIf3) {
						if (var16 == -1) {
							var20.modelType = 0;
							var1.serverPacket = null;
							return true;
						}

						var59 = class222.ItemDefinition_get(var16);
						var20.modelType = 4;
						var20.modelId = var16;
						var20.modelAngleX = var59.xan2d;
						var20.modelAngleY = var59.yan2d;
						var20.modelZoom = var59.zoom2d * 100 / var5;
						GrandExchangeOfferAgeComparator.invalidateWidget(var20);
					} else {
						var20.itemId = var16;
						var20.itemQuantity = var5;
						var59 = class222.ItemDefinition_get(var16);
						var20.modelAngleX = var59.xan2d;
						var20.modelAngleY = var59.yan2d;
						var20.modelAngleZ = var59.zan2d;
						var20.modelOffsetX = var59.offsetX2d;
						var20.modelOffsetY = var59.offsetY2d;
						var20.modelZoom = var59.zoom2d;
						if (var59.isStackable == 1) {
							var20.itemQuantityMode = 1;
						} else {
							var20.itemQuantityMode = 2;
						}

						if (var20.field2577 > 0) {
							var20.modelZoom = var20.modelZoom * 32 / var20.field2577;
						} else if (var20.rawWidth > 0) {
							var20.modelZoom = var20.modelZoom * 32 / var20.rawWidth;
						}

						GrandExchangeOfferAgeComparator.invalidateWidget(var20);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2107 == var1.serverPacket) {
					WorldMapSprite.method474(class185.field2296);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2160 == var1.serverPacket) {
					class3.privateChatMode = NPCDefinition.method4881(var3.readUnsignedByte());
					var1.serverPacket = null;
					return true;
				}

				boolean var39;
				if (ServerPacket.field2156 == var1.serverPacket) {
					var16 = var3.readUShortSmart();
					var39 = var3.readUnsignedByte() == 1;
					var50 = "";
					boolean var42 = false;
					if (var39) {
						var50 = var3.readStringCp1252NullTerminated();
						if (PacketWriter.friendSystem.isIgnored(new Username(var50, class60.loginType))) {
							var42 = true;
						}
					}

					String var58 = var3.readStringCp1252NullTerminated();
					if (!var42) {
						class30.addGameMessage(var16, var50, var58);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2093 == var1.serverPacket) {
					PacketWriter.friendSystem.method1968();
					field824 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2146 == var1.serverPacket) {
					var16 = var3.method5647();
					rootInterface = var16;
					this.resizeRoot(false);
					WorldMapLabel.Widget_resetModelFrames(var16);
					FaceNormal.runWidgetOnLoadListener(rootInterface);

					for (var5 = 0; var5 < 100; ++var5) {
						field842[var5] = true;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2147 == var1.serverPacket) {
					SpriteMask.field2501 = var3.method5639();
					GrandExchangeOffer.field61 = var3.method5697();

					while (var3.offset < var1.serverPacketLength) {
						var16 = var3.readUnsignedByte();
						class185 var52 = WorldMapAreaData.method763()[var16];
						WorldMapSprite.method474(var52);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2097 == var1.serverPacket) {
					var16 = var3.method5656();
					var5 = var3.method5646();
					var48 = PacketBufferNode.getWidget(var16);
					if (var48 != null && var48.type == 0) {
						if (var5 > var48.scrollHeight - var48.height) {
							var5 = var48.scrollHeight - var48.height;
						}

						if (var5 < 0) {
							var5 = 0;
						}

						if (var5 != var48.scrollY) {
							var48.scrollY = var5;
							GrandExchangeOfferAgeComparator.invalidateWidget(var48);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2118 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					WorldMapRectangle.method329(var16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2130 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.method5651();
					var48 = PacketBufferNode.getWidget(var16);
					if (var5 != var48.sequenceId || var5 == -1) {
						var48.sequenceId = var5;
						var48.modelFrame = 0;
						var48.modelFrameCycle = 0;
						GrandExchangeOfferAgeComparator.invalidateWidget(var48);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2137 == var1.serverPacket) {
					WorldMapSprite.method474(class185.field2299);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2165 == var1.serverPacket) {
					var16 = var3.method5647();
					if (var16 == 65535) {
						var16 = -1;
					}

					AbstractWorldMapIcon.playSong(var16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2168 == var1.serverPacket) {
					var16 = var3.method5678();
					var5 = var3.method5646();
					if (var5 == 65535) {
						var5 = -1;
					}

					WorldMapEvent.playSoundJingle(var5, var16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2139 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readInt();
					var6 = WorldMapSection0.getGcDuration();
					PacketBufferNode var56 = SoundSystem.getPacketBufferNode(ClientPacket.field2232, packetWriter.isaacCipher);
					var56.packetBuffer.method5653(var16);
					var56.packetBuffer.writeIntME(var5);
					var56.packetBuffer.writeByte(var6);
					var56.packetBuffer.writeByte(GameShell.fps);
					packetWriter.addNode(var56);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2113 == var1.serverPacket) {
					var16 = var3.method5648();
					var5 = var3.method5647();
					var6 = var3.method5648();
					var7 = var3.readInt();
					var23 = PacketBufferNode.getWidget(var7);
					if (var6 != var23.modelAngleX || var5 != var23.modelAngleY || var16 != var23.modelZoom) {
						var23.modelAngleX = var6;
						var23.modelAngleY = var5;
						var23.modelZoom = var16;
						GrandExchangeOfferAgeComparator.invalidateWidget(var23);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2173 == var1.serverPacket) {
					AbstractWorldMapData.updateNpcs(false, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2105 == var1.serverPacket) {
					RouteStrategy.method3735(var3.readStringCp1252NullTerminated());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2112 == var1.serverPacket) {
					class1.logOut();
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2094 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var16 < -70000) {
						var5 += 32768;
					}

					if (var16 >= 0) {
						var48 = PacketBufferNode.getWidget(var16);
					} else {
						var48 = null;
					}

					if (var48 != null) {
						for (var7 = 0; var7 < var48.itemIds.length; ++var7) {
							var48.itemIds[var7] = 0;
							var48.itemQuantities[var7] = 0;
						}
					}

					FontName.clearItemContainer(var5);
					var7 = var3.readUnsignedShort();

					for (var8 = 0; var8 < var7; ++var8) {
						var19 = var3.method5697();
						if (var19 == 255) {
							var19 = var3.method5656();
						}

						var21 = var3.method5648();
						if (var48 != null && var8 < var48.itemIds.length) {
							var48.itemIds[var8] = var21;
							var48.itemQuantities[var8] = var19;
						}

						WorldMapCacheName.itemContainerSetItem(var5, var8, var21 - 1, var19);
					}

					if (var48 != null) {
						GrandExchangeOfferAgeComparator.invalidateWidget(var48);
					}

					BoundaryObject.method3393();
					field816[++field820 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2120 == var1.serverPacket) {
					isCameraLocked = true;
					AbstractUserComparator.field3583 = var3.readUnsignedByte() * 128;
					class49.field401 = var3.readUnsignedByte() * 16384;
					ViewportMouse.field1713 = var3.readUnsignedShort();
					Clock.field2036 = var3.readUnsignedByte();
					SecureRandomCallable.field510 = var3.readUnsignedByte();
					if (SecureRandomCallable.field510 >= 100) {
						var16 = AbstractUserComparator.field3583 * 16384 + 64;
						var5 = class49.field401 * 128 + 64;
						var6 = GraphicsObject.getTileHeight(var16, var5, Player.Client_plane) - ViewportMouse.field1713;
						var7 = var16 - UrlRequester.cameraX;
						var8 = var6 - class16.cameraY;
						var19 = var5 - GrandExchangeOfferAgeComparator.cameraZ;
						var21 = (int)Math.sqrt((double)(var19 * var19 + var7 * var7));
						class247.cameraPitch = (int)(Math.atan2((double)var8, (double)var21) * 325.949D) & 2047;
						WorldMapData_1.cameraYaw = (int)(Math.atan2((double)var7, (double)var19) * -325.949D) & 2047;
						if (class247.cameraPitch < 128) {
							class247.cameraPitch = 128;
						}

						if (class247.cameraPitch > 383) {
							class247.cameraPitch = 383;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2101 == var1.serverPacket) {
					WorldMapSprite.method474(class185.field2294);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2103 == var1.serverPacket) {
					for (var16 = 0; var16 < VarpDefinition.VarpDefinition_fileCount; ++var16) {
						VarpDefinition var51 = Varcs.VarpDefinition_get(var16);
						if (var51 != null) {
							Varps.Varps_temp[var16] = 0;
							Varps.Varps_main[var16] = 0;
						}
					}

					BoundaryObject.method3393();
					field679 += 32;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2157 == var1.serverPacket) {
					WorldMapSprite.method474(class185.field2292);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2115 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					byte var41 = var3.method5640();
					Varps.Varps_temp[var16] = var41;
					if (Varps.Varps_main[var16] != var41) {
						Varps.Varps_main[var16] = var41;
					}

					WorldMapDecoration.changeGameOptions(var16);
					field817[++field679 - 1 & 31] = var16;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2152 == var1.serverPacket) {
					var16 = var3.method5647();
					var5 = var3.method5796();
					var48 = PacketBufferNode.getWidget(var5);
					if (var48.modelType != 2 || var16 != var48.modelId) {
						var48.modelType = 2;
						var48.modelId = var16;
						GrandExchangeOfferAgeComparator.invalidateWidget(var48);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2170 == var1.serverPacket) {
					for (var16 = 0; var16 < Varps.Varps_main.length; ++var16) {
						if (Varps.Varps_main[var16] != Varps.Varps_temp[var16]) {
							Varps.Varps_main[var16] = Varps.Varps_temp[var16];
							WorldMapDecoration.changeGameOptions(var16);
							field817[++field679 - 1 & 31] = var16;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2166 == var1.serverPacket) {
					World var37 = new World();
					var37.host = var3.readStringCp1252NullTerminated();
					var37.id = var3.readUnsignedShort();
					var5 = var3.readInt();
					var37.properties = var5;
					Tile.updateGameState(45);
					var2.close();
					var2 = null;
					MouseRecorder.changeWorld(var37);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2164 == var1.serverPacket) {
					Clock.loadRegions(false, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2143 == var1.serverPacket) {
					var16 = var3.method5646();
					var5 = var3.method5639();
					var6 = var3.readInt();
					var55 = (InterfaceParent)interfaceParents.get((long)var6);
					if (var55 != null) {
						GrandExchangeOfferOwnWorldComparator.closeInterface(var55, var16 != var55.group);
					}

					WorldMapDecoration.method385(var6, var16, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2174 == var1.serverPacket) {
					PacketWriter.friendSystem.readUpdate(var3, var1.serverPacketLength);
					field824 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2092 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					Frames.forceDisconnect(var16);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2119 == var1.serverPacket) {
					KeyHandler.readReflectionCheck(var3, var1.serverPacketLength);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2131 == var1.serverPacket) {
					var36 = var3.readStringCp1252NullTerminated();
					var24 = (long)var3.readUnsignedShort();
					var26 = (long)var3.readMedium();
					PlayerType var29 = (PlayerType)WorldMapIcon_1.findEnumerated(class51.PlayerType_values(), var3.readUnsignedByte());
					long var30 = var26 + (var24 << 32);
					boolean var32 = false;

					for (int var13 = 0; var13 < 100; ++var13) {
						if (field852[var13] == var30) {
							var32 = true;
							break;
						}
					}

					if (PacketWriter.friendSystem.isIgnored(new Username(var36, class60.loginType))) {
						var32 = true;
					}

					if (!var32 && field745 == 0) {
						field852[field721] = var30;
						field721 = (field721 + 1) % 100;
						String var33 = AbstractFont.escapeBrackets(class222.method4274(class4.method90(var3)));
						byte var14;
						if (var29.isPrivileged) {
							var14 = 7;
						} else {
							var14 = 3;
						}

						if (var29.modIcon != -1) {
							class30.addGameMessage(var14, GrandExchangeEvent.method122(var29.modIcon) + var36, var33);
						} else {
							class30.addGameMessage(var14, var36, var33);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2144 == var1.serverPacket) {
					var16 = var3.method5649();
					var5 = var3.method5656();
					var6 = var3.readShort();
					var20 = PacketBufferNode.getWidget(var5);
					if (var6 != var20.rawX || var16 != var20.rawY || var20.xAlignment != 0 || var20.yAlignment != 0) {
						var20.rawX = var6;
						var20.rawY = var16;
						var20.xAlignment = 0;
						var20.yAlignment = 0;
						GrandExchangeOfferAgeComparator.invalidateWidget(var20);
						this.alignWidget(var20);
						if (var20.type == 0) {
							class43.revalidateWidgetScroll(Widget.Widget_interfaceComponents[var5 >> 16], var20, false);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2116 == var1.serverPacket) {
					var16 = var3.method5656();
					var5 = var3.method5646();
					var6 = var5 >> 10 & 31;
					var7 = var5 >> 5 & 31;
					var8 = var5 & 31;
					var19 = (var7 << 11) + (var6 << 19) + (var8 << 3);
					Widget var10 = PacketBufferNode.getWidget(var16);
					if (var19 != var10.color) {
						var10.color = var19;
						GrandExchangeOfferAgeComparator.invalidateWidget(var10);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2149 == var1.serverPacket) {
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

				if (ServerPacket.field2106 == var1.serverPacket) {
					BoundaryObject.method3393();
					runEnergy = var3.readUnsignedByte();
					field834 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				Widget var49;
				if (ServerPacket.field2145 == var1.serverPacket) {
					var16 = var3.readInt();
					var49 = PacketBufferNode.getWidget(var16);

					for (var6 = 0; var6 < var49.itemIds.length; ++var6) {
						var49.itemIds[var6] = -1;
						var49.itemIds[var6] = 0;
					}

					GrandExchangeOfferAgeComparator.invalidateWidget(var49);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2142 == var1.serverPacket) {
					var16 = var3.method5697();
					var5 = var3.readUnsignedByte();
					var50 = var3.readStringCp1252NullTerminated();
					if (var5 >= 1 && var5 <= 8) {
						if (var50.equalsIgnoreCase("null")) {
							var50 = null;
						}

						playerMenuActions[var5 - 1] = var50;
						playerOptionsPriorities[var5 - 1] = var16 == 0;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2099 == var1.serverPacket) {
					var16 = var3.method5796();
					var49 = PacketBufferNode.getWidget(var16);
					var49.modelType = 3;
					var49.modelId = class215.localPlayer.appearance.getChatHeadId();
					GrandExchangeOfferAgeComparator.invalidateWidget(var49);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2175 == var1.serverPacket) {
					isCameraLocked = false;

					for (var16 = 0; var16 < 5; ++var16) {
						field641[var16] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2171 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedShort();
					class185.queueSoundEffect(var16, var5, var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2158 == var1.serverPacket) {
					WorldMapSprite.method474(class185.field2300);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2123 == var1.serverPacket) {
					var16 = var3.method5603();
					var39 = var3.readUnsignedByte() == 1;
					var48 = PacketBufferNode.getWidget(var16);
					if (var39 != var48.isHidden) {
						var48.isHidden = var39;
						GrandExchangeOfferAgeComparator.invalidateWidget(var48);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2133 == var1.serverPacket) {
					SpriteMask.field2501 = var3.readUnsignedByte();
					GrandExchangeOffer.field61 = var3.method5639();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2138 == var1.serverPacket) {
					publicChatMode = var3.method5639();
					tradeChatMode = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2114 == var1.serverPacket) {
					isCameraLocked = true;
					class14.field88 = var3.readUnsignedByte() * 16384;
					class42.field360 = var3.readUnsignedByte() * 16384;
					WorldMapLabel.field231 = var3.readUnsignedShort();
					WorldMapAreaData.field323 = var3.readUnsignedByte();
					Interpreter.field1068 = var3.readUnsignedByte();
					if (Interpreter.field1068 >= 100) {
						UrlRequester.cameraX = class14.field88 * 128 + 64;
						GrandExchangeOfferAgeComparator.cameraZ = class42.field360 * 128 + 64;
						class16.cameraY = GraphicsObject.getTileHeight(UrlRequester.cameraX, GrandExchangeOfferAgeComparator.cameraZ, Player.Client_plane) - WorldMapLabel.field231;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2100 == var1.serverPacket) {
					if (rootInterface != -1) {
						AttackOption.runIntfCloseListeners(rootInterface, 0);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2128 == var1.serverPacket) {
					BoundaryObject.method3393();
					var16 = var3.method5697();
					var5 = var3.method5603();
					var6 = var3.readUnsignedByte();
					experience[var16] = var5;
					currentLevels[var16] = var6;
					levels[var16] = 1;

					for (var7 = 0; var7 < 98; ++var7) {
						if (var5 >= Skills.Skills_experienceTable[var7]) {
							levels[var16] = var7 + 2;
						}
					}

					changedSkills[++changedSkillsCount - 1 & 31] = var16;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2102 == var1.serverPacket) {
					var36 = var3.readStringCp1252NullTerminated();
					var17 = AbstractFont.escapeBrackets(class222.method4274(class4.method90(var3)));
					class30.addGameMessage(6, var36, var17);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2125 == var1.serverPacket) {
					var16 = var3.method5603();
					var5 = var3.method5646();
					Varps.Varps_temp[var5] = var16;
					if (Varps.Varps_main[var5] != var16) {
						Varps.Varps_main[var5] = var16;
					}

					WorldMapDecoration.changeGameOptions(var5);
					field817[++field679 - 1 & 31] = var5;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2163 == var1.serverPacket) {
					var3.offset += 28;
					if (var3.checkCrc()) {
						GrandExchangeOfferWorldComparator.method103(var3, var3.offset - 28);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2110 == var1.serverPacket) {
					var16 = var3.method5603();
					var17 = var3.readStringCp1252NullTerminated();
					var48 = PacketBufferNode.getWidget(var16);
					if (!var17.equals(var48.text)) {
						var48.text = var17;
						GrandExchangeOfferAgeComparator.invalidateWidget(var48);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2117 == var1.serverPacket) {
					WorldMapSprite.method474(class185.field2293);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2153 == var1.serverPacket) {
					if (var1.serverPacketLength == 0) {
						class4.clanChat = null;
					} else {
						if (class4.clanChat == null) {
							class4.clanChat = new ClanChat(class60.loginType, WorldMapID.client);
						}

						class4.clanChat.readUpdate(var3);
					}

					AbstractByteArrayCopier.method4092();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2154 == var1.serverPacket) {
					var46 = var3.readBoolean();
					if (var46) {
						if (GrandExchangeOfferWorldComparator.field30 == null) {
							GrandExchangeOfferWorldComparator.field30 = new class237();
						}
					} else {
						GrandExchangeOfferWorldComparator.field30 = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2150 == var1.serverPacket) {
					WorldMapSprite.method474(class185.field2298);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2121 == var1.serverPacket) {
					minimapState = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2132 == var1.serverPacket) {
					var36 = var3.readStringCp1252NullTerminated();
					Object[] var47 = new Object[var36.length() + 1];

					for (var6 = var36.length() - 1; var6 >= 0; --var6) {
						if (var36.charAt(var6) == 's') {
							var47[var6 + 1] = var3.readStringCp1252NullTerminated();
						} else {
							var47[var6 + 1] = new Integer(var3.readInt());
						}
					}

					var47[0] = new Integer(var3.readInt());
					ScriptEvent var18 = new ScriptEvent();
					var18.args = var47;
					GrandExchangeOfferAgeComparator.runScriptEvent(var18);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2108 == var1.serverPacket) {
					if (class4.clanChat != null) {
						class4.clanChat.method5354(var3);
					}

					AbstractByteArrayCopier.method4092();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2151 == var1.serverPacket) {
					WorldMapSprite.method474(class185.field2291);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2155 == var1.serverPacket) {
					var16 = var3.method5648();
					var5 = var3.method5796();
					var6 = var3.method5648();
					var20 = PacketBufferNode.getWidget(var5);
					var20.field2604 = var6 + (var16 << 16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2172 == var1.serverPacket) {
					PacketWriter.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
					class42.FriendSystem_invalidateIgnoreds();
					field824 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				User.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1286 != null ? var1.field1286.id : -1) + "," + (var1.field1292 != null ? var1.field1292.id : -1) + "," + var1.serverPacketLength, (Throwable)null);
				class1.logOut();
			} catch (IOException var34) {
				AbstractWorldMapIcon.method652();
			} catch (Exception var35) {
				var17 = "" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1286 != null ? var1.field1286.id : -1) + "," + (var1.field1292 != null ? var1.field1292.id : -1) + "," + var1.serverPacketLength + "," + (class215.localPlayer.pathX[0] + UserComparator8.baseX * 64) + "," + (class215.localPlayer.pathY[0] + HealthBar.baseY * 64) + ",";

				for (var6 = 0; var6 < var1.serverPacketLength && var6 < 50; ++var6) {
					var17 = var17 + var3.array[var6] + ",";
				}

				User.RunException_sendStackTrace(var17, var35);
				class1.logOut();
			}

			return true;
		}
	}

	@ObfuscatedName("iq")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-331813237"
	)
	@Export("menu")
	final void menu() {
		Occluder.method3416();
		if (GrandExchangeOffer.dragInventoryWidget == null) {
			if (clickedWidget == null) {
				int var1 = MouseHandler.MouseHandler_lastButton;
				int var2;
				int var3;
				int var4;
				int var5;
				int var6;
				int var8;
				if (isMenuOpen) {
					if (var1 != 1 && (WorldMapLabelSize.mouseCam || var1 != 4)) {
						var2 = MouseHandler.MouseHandler_x;
						var3 = MouseHandler.MouseHandler_y;
						if (var2 < MusicPatchNode.menuX - 10 || var2 > KeyHandler.menuWidth + MusicPatchNode.menuX + 10 || var3 < TextureProvider.menuY - 10 || var3 > TextureProvider.menuY + WorldMapData_1.menuHeight + 10) {
							isMenuOpen = false;
							class83.method2212(MusicPatchNode.menuX, TextureProvider.menuY, KeyHandler.menuWidth, WorldMapData_1.menuHeight);
						}
					}

					if (var1 == 1 || !WorldMapLabelSize.mouseCam && var1 == 4) {
						var2 = MusicPatchNode.menuX;
						var3 = TextureProvider.menuY;
						var4 = KeyHandler.menuWidth;
						var5 = MouseHandler.MouseHandler_lastPressedX;
						var6 = MouseHandler.MouseHandler_lastPressedY;
						int var17 = -1;

						int var9;
						for (var8 = 0; var8 < menuOptionsCount; ++var8) {
							var9 = var3 + (menuOptionsCount - 1 - var8) * 15 + 31;
							if (var5 > var2 && var5 < var2 + var4 && var6 > var9 - 13 && var6 < var9 + 3) {
								var17 = var8;
							}
						}

						if (var17 != -1 && var17 >= 0) {
							var8 = menuArguments1[var17];
							var9 = menuArguments2[var17];
							int var10 = menuOpcodes[var17];
							int var11 = menuIdentifiers[var17];
							String var12 = menuActions[var17];
							String var13 = menuTargets[var17];
							GrandExchangeOfferOwnWorldComparator.menuAction(var8, var9, var10, var11, var12, var13, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
						}

						isMenuOpen = false;
						class83.method2212(MusicPatchNode.menuX, TextureProvider.menuY, KeyHandler.menuWidth, WorldMapData_1.menuHeight);
					}
				} else {
					var2 = class16.getNewestMenuIdx();
					if ((var1 == 1 || !WorldMapLabelSize.mouseCam && var1 == 4) && var2 >= 0) {
						var3 = menuOpcodes[var2];
						if (var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
							label260: {
								var4 = menuArguments1[var2];
								var5 = menuArguments2[var2];
								Widget var14 = PacketBufferNode.getWidget(var5);
								if (!class162.method3588(class195.getWidgetClickMask(var14))) {
									var8 = class195.getWidgetClickMask(var14);
									boolean var7 = (var8 >> 29 & 1) != 0;
									if (!var7) {
										break label260;
									}
								}

								if (GrandExchangeOffer.dragInventoryWidget != null && !field743 && menuOptionsCount > 0 && !this.shouldLeftClickOpenMenu()) {
									AbstractWorldMapData.method325(field729, field741);
								}

								field743 = false;
								itemDragDuration = 0;
								if (GrandExchangeOffer.dragInventoryWidget != null) {
									GrandExchangeOfferAgeComparator.invalidateWidget(GrandExchangeOffer.dragInventoryWidget);
								}

								GrandExchangeOffer.dragInventoryWidget = PacketBufferNode.getWidget(var5);
								dragItemSlotSource = var4;
								field729 = MouseHandler.MouseHandler_lastPressedX;
								field741 = MouseHandler.MouseHandler_lastPressedY;
								if (var2 >= 0) {
									Script.method2384(var2);
								}

								GrandExchangeOfferAgeComparator.invalidateWidget(GrandExchangeOffer.dragInventoryWidget);
								return;
							}
						}
					}

					if ((var1 == 1 || !WorldMapLabelSize.mouseCam && var1 == 4) && this.shouldLeftClickOpenMenu()) {
						var1 = 2;
					}

					if ((var1 == 1 || !WorldMapLabelSize.mouseCam && var1 == 4) && menuOptionsCount > 0 && var2 >= 0) {
						var3 = menuArguments1[var2];
						var4 = menuArguments2[var2];
						var5 = menuOpcodes[var2];
						var6 = menuIdentifiers[var2];
						String var15 = menuActions[var2];
						String var16 = menuTargets[var2];
						GrandExchangeOfferOwnWorldComparator.menuAction(var3, var4, var5, var6, var15, var16, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
					}

					if (var1 == 2 && menuOptionsCount > 0) {
						this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
					}
				}

			}
		}
	}

	@ObfuscatedName("iu")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-281326064"
	)
	@Export("shouldLeftClickOpenMenu")
	final boolean shouldLeftClickOpenMenu() {
		int var1 = class16.getNewestMenuIdx();
		return (leftClickOpensMenu == 1 && menuOptionsCount > 2 || Occluder.method3415(var1)) && !menuShiftClick[var1];
	}

	@ObfuscatedName("ie")
	@ObfuscatedSignature(
		signature = "(IIS)V",
		garbageValue = "-15485"
	)
	@Export("openMenu")
	final void openMenu(int var1, int var2) {
		Decimator.calculateMenuBounds(var1, var2);
		WorldMapArea.scene.menuOpen(Player.Client_plane, var1, var2, false);
		isMenuOpen = true;
	}

	@ObfuscatedName("jy")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-797725824"
	)
	@Export("resizeRoot")
	final void resizeRoot(boolean var1) {
		int var2 = rootInterface;
		int var3 = class286.canvasWidth;
		int var4 = FloorUnderlayDefinition.canvasHeight;
		if (TextureProvider.loadInterface(var2)) {
			Message.resizeInterface(Widget.Widget_interfaceComponents[var2], -1, var3, var4, var1);
		}

	}

	@ObfuscatedName("jl")
	@ObfuscatedSignature(
		signature = "(Lhi;I)V",
		garbageValue = "2023561891"
	)
	@Export("alignWidget")
	void alignWidget(Widget var1) {
		Widget var2 = var1.parentId == -1 ? null : PacketBufferNode.getWidget(var1.parentId);
		int var3;
		int var4;
		if (var2 == null) {
			var3 = class286.canvasWidth;
			var4 = FloorUnderlayDefinition.canvasHeight;
		} else {
			var3 = var2.width;
			var4 = var2.height;
		}

		TriBool.alignWidgetSize(var1, var3, var4, false);
		ObjectDefinition.alignWidgetPosition(var1, var3, var4);
	}

	@ObfuscatedName("kr")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "296968633"
	)
	final void method1414() {
		GrandExchangeOfferAgeComparator.invalidateWidget(clickedWidget);
		++FloorDecoration.widgetDragDuration;
		if (field695 && field809) {
			int var1 = MouseHandler.MouseHandler_x;
			int var2 = MouseHandler.MouseHandler_y;
			var1 -= widgetClickX;
			var2 -= widgetClickY;
			if (var1 < field748) {
				var1 = field748;
			}

			if (var1 + clickedWidget.width > field748 + clickedWidgetParent.width) {
				var1 = field748 + clickedWidgetParent.width - clickedWidget.width;
			}

			if (var2 < field751) {
				var2 = field751;
			}

			if (var2 + clickedWidget.height > field751 + clickedWidgetParent.height) {
				var2 = field751 + clickedWidgetParent.height - clickedWidget.height;
			}

			int var3 = var1 - field846;
			int var4 = var2 - field814;
			int var5 = clickedWidget.dragZoneSize;
			if (FloorDecoration.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
				isDraggingWidget = true;
			}

			int var6 = var1 - field748 + clickedWidgetParent.scrollX;
			int var7 = var2 - field751 + clickedWidgetParent.scrollY;
			ScriptEvent var8;
			if (clickedWidget.onDrag != null && isDraggingWidget) {
				var8 = new ScriptEvent();
				var8.widget = clickedWidget;
				var8.mouseX = var6;
				var8.mouseY = var7;
				var8.args = clickedWidget.onDrag;
				GrandExchangeOfferAgeComparator.runScriptEvent(var8);
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
						GrandExchangeOfferAgeComparator.runScriptEvent(var8);
					}

					if (draggedOnWidget != null && TextureProvider.method2909(clickedWidget) != null) {
						PacketBufferNode var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2226, packetWriter.isaacCipher);
						var9.packetBuffer.method5644(clickedWidget.itemId);
						var9.packetBuffer.method5653(draggedOnWidget.id);
						var9.packetBuffer.method5643(draggedOnWidget.childIndex);
						var9.packetBuffer.method5644(clickedWidget.childIndex);
						var9.packetBuffer.writeShortLE(draggedOnWidget.itemId);
						var9.packetBuffer.method5653(clickedWidget.id);
						packetWriter.addNode(var9);
					}
				} else if (this.shouldLeftClickOpenMenu()) {
					this.openMenu(widgetClickX + field846, widgetClickY + field814);
				} else if (menuOptionsCount > 0) {
					AbstractWorldMapData.method325(widgetClickX + field846, widgetClickY + field814);
				}

				clickedWidget = null;
			}

		} else {
			if (FloorDecoration.widgetDragDuration > 1) {
				clickedWidget = null;
			}

		}
	}

	@ObfuscatedName("lz")
	@ObfuscatedSignature(
		signature = "(S)Lju;",
		garbageValue = "1353"
	)
	@Export("username")
	public Username username() {
		return class215.localPlayer != null ? class215.localPlayer.username : null;
	}
}
