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
	@ObfuscatedName("mk")
	@ObfuscatedGetter(
		intValue = 1799877643
	)
	@Export("staffModLevel")
	static int staffModLevel;
	@ObfuscatedName("mn")
	@ObfuscatedSignature(
		signature = "Lhy;"
	)
	@Export("clickedWidget")
	static Widget clickedWidget;
	@ObfuscatedName("of")
	@ObfuscatedGetter(
		intValue = 2143275649
	)
	static int field826;
	@ObfuscatedName("oh")
	@ObfuscatedGetter(
		intValue = -1410459607
	)
	@Export("rootWidgetCount")
	static int rootWidgetCount;
	@ObfuscatedName("oo")
	@ObfuscatedGetter(
		longValue = -3812106139059310753L
	)
	static long field835;
	@ObfuscatedName("so")
	@ObfuscatedGetter(
		intValue = -777339019
	)
	public static int field892;
	@ObfuscatedName("og")
	static boolean[] field827;
	@ObfuscatedName("oj")
	static boolean[] field647;
	@ObfuscatedName("ov")
	static boolean[] field828;
	@ObfuscatedName("nt")
	static boolean field803;
	@ObfuscatedName("ox")
	@Export("isResizable")
	static boolean isResizable;
	@ObfuscatedName("nj")
	@ObfuscatedGetter(
		intValue = 2118102189
	)
	@Export("cycleCntr")
	static int cycleCntr;
	@ObfuscatedName("nc")
	@ObfuscatedGetter(
		intValue = 514283597
	)
	static int field815;
	@ObfuscatedName("na")
	static boolean field800;
	@ObfuscatedName("qn")
	static boolean field746;
	@ObfuscatedName("mj")
	@ObfuscatedGetter(
		intValue = -1352520531
	)
	@Export("widgetClickX")
	static int widgetClickX;
	@ObfuscatedName("mm")
	@ObfuscatedGetter(
		intValue = 1096027871
	)
	@Export("widgetClickY")
	static int widgetClickY;
	@ObfuscatedName("ny")
	@ObfuscatedGetter(
		intValue = 1655580139
	)
	static int field801;
	@ObfuscatedName("ob")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("widgetClickMasks")
	static NodeHashTable widgetClickMasks;
	@ObfuscatedName("mo")
	@ObfuscatedSignature(
		signature = "Lhy;"
	)
	@Export("clickedWidgetParent")
	static Widget clickedWidgetParent;
	@ObfuscatedName("ot")
	@Export("rootWidgetXs")
	static int[] rootWidgetXs;
	@ObfuscatedName("ms")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("interfaceParents")
	static NodeHashTable interfaceParents;
	@ObfuscatedName("ow")
	@Export("rootWidgetWidths")
	static int[] rootWidgetWidths;
	@ObfuscatedName("nu")
	@ObfuscatedGetter(
		intValue = 738583497
	)
	static int field706;
	@ObfuscatedName("mi")
	@ObfuscatedSignature(
		signature = "Lhy;"
	)
	@Export("viewportWidget")
	static Widget viewportWidget;
	@ObfuscatedName("oi")
	@ObfuscatedGetter(
		intValue = 589790743
	)
	@Export("gameDrawingMode")
	static int gameDrawingMode;
	@ObfuscatedName("ou")
	@Export("rootWidgetYs")
	static int[] rootWidgetYs;
	@ObfuscatedName("oq")
	@Export("rootWidgetHeights")
	static int[] rootWidgetHeights;
	@ObfuscatedName("th")
	@ObfuscatedSignature(
		signature = "Lbd;"
	)
	static final class65 field896;
	@ObfuscatedName("pi")
	@ObfuscatedGetter(
		intValue = 1219958761
	)
	@Export("destinationX")
	static int destinationX;
	@ObfuscatedName("oc")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("scriptEvents")
	static NodeDeque scriptEvents;
	@ObfuscatedName("pm")
	@ObfuscatedGetter(
		intValue = 134057745
	)
	@Export("destinationY")
	static int destinationY;
	@ObfuscatedName("nh")
	@ObfuscatedGetter(
		intValue = -1671536207
	)
	static int field804;
	@ObfuscatedName("ns")
	@ObfuscatedGetter(
		intValue = -2015110765
	)
	static int field699;
	@ObfuscatedName("np")
	@ObfuscatedGetter(
		intValue = -144627573
	)
	static int field670;
	@ObfuscatedName("tc")
	static int[] field897;
	@ObfuscatedName("tu")
	static int[] field622;
	@ObfuscatedName("sd")
	@ObfuscatedSignature(
		signature = "[Lz;"
	)
	@Export("grandExchangeOffers")
	static GrandExchangeOffer[] grandExchangeOffers;
	@ObfuscatedName("nl")
	@Export("isDraggingWidget")
	static boolean isDraggingWidget;
	@ObfuscatedName("oy")
	@ObfuscatedGetter(
		intValue = 751171339
	)
	@Export("mouseWheelRotation")
	static int mouseWheelRotation;
	@ObfuscatedName("mh")
	@ObfuscatedGetter(
		intValue = 577539247
	)
	@Export("runEnergy")
	static int runEnergy;
	@ObfuscatedName("nr")
	@ObfuscatedGetter(
		intValue = -482003575
	)
	static int field866;
	@ObfuscatedName("mx")
	@ObfuscatedGetter(
		intValue = 1475119709
	)
	@Export("weight")
	static int weight;
	@ObfuscatedName("rt")
	static boolean[] field749;
	@ObfuscatedName("qr")
	@ObfuscatedGetter(
		intValue = 1115728247
	)
	static int field860;
	@ObfuscatedName("ry")
	static int[] field779;
	@ObfuscatedName("ri")
	static int[] field887;
	@ObfuscatedName("se")
	@ObfuscatedGetter(
		intValue = -129549365
	)
	static int field703;
	@ObfuscatedName("rw")
	static int[] field871;
	@ObfuscatedName("rf")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	@Export("playerAppearance")
	static PlayerAppearance playerAppearance;
	@ObfuscatedName("ro")
	static int[] field799;
	@ObfuscatedName("sq")
	@Export("archiveLoaders")
	static ArrayList archiveLoaders;
	@ObfuscatedName("si")
	@ObfuscatedGetter(
		intValue = 1522732833
	)
	static int field888;
	@ObfuscatedName("mp")
	@ObfuscatedSignature(
		signature = "Lhy;"
	)
	@Export("draggedOnWidget")
	static Widget draggedOnWidget;
	@ObfuscatedName("sw")
	@ObfuscatedGetter(
		intValue = -503876483
	)
	@Export("archiveLoaderArchive")
	static int archiveLoaderArchive;
	@ObfuscatedName("mq")
	@ObfuscatedSignature(
		signature = "Lhy;"
	)
	@Export("meslayerContinueWidget")
	static Widget meslayerContinueWidget;
	@ObfuscatedName("qy")
	@ObfuscatedGetter(
		intValue = 448315021
	)
	@Export("soundEffectVolume")
	static int soundEffectVolume;
	@ObfuscatedName("pt")
	@ObfuscatedGetter(
		intValue = 1563403409
	)
	@Export("publicChatMode")
	static int publicChatMode;
	@ObfuscatedName("qs")
	@ObfuscatedGetter(
		intValue = -1332887045
	)
	@Export("soundEffectCount")
	static int soundEffectCount;
	@ObfuscatedName("qx")
	@Export("soundEffectIds")
	static int[] soundEffectIds;
	@ObfuscatedName("pj")
	@ObfuscatedGetter(
		intValue = 1654974071
	)
	@Export("tradeChatMode")
	static int tradeChatMode;
	@ObfuscatedName("qo")
	@Export("queuedSoundEffectLoops")
	static int[] queuedSoundEffectLoops;
	@ObfuscatedName("qm")
	@ObfuscatedGetter(
		intValue = -617256985
	)
	@Export("minimapState")
	static int minimapState;
	@ObfuscatedName("qk")
	@Export("queuedSoundEffectDelays")
	static int[] queuedSoundEffectDelays;
	@ObfuscatedName("qw")
	@ObfuscatedSignature(
		signature = "[Lcp;"
	)
	@Export("soundEffects")
	static SoundEffect[] soundEffects;
	@ObfuscatedName("qi")
	@Export("soundLocations")
	static int[] soundLocations;
	@ObfuscatedName("pp")
	@ObfuscatedGetter(
		intValue = 1213166395
	)
	static int field848;
	@ObfuscatedName("sj")
	@ObfuscatedSignature(
		signature = "Llb;"
	)
	@Export("platformInfoProvider")
	static PlatformInfoProvider platformInfoProvider;
	@ObfuscatedName("pb")
	@ObfuscatedGetter(
		longValue = 4732015069802034625L
	)
	static long field750;
	@ObfuscatedName("qj")
	@ObfuscatedGetter(
		intValue = -310868887
	)
	static int field857;
	@ObfuscatedName("qe")
	@ObfuscatedGetter(
		intValue = -105655659
	)
	static int field638;
	@ObfuscatedName("nm")
	static int[] field808;
	@ObfuscatedName("nw")
	@ObfuscatedGetter(
		intValue = 1990399739
	)
	static int field809;
	@ObfuscatedName("ps")
	@ObfuscatedGetter(
		intValue = -284240639
	)
	@Export("mapIconCount")
	static int mapIconCount;
	@ObfuscatedName("rj")
	static short field873;
	@ObfuscatedName("rz")
	static short field752;
	@ObfuscatedName("rh")
	static short field879;
	@ObfuscatedName("qt")
	@Export("isCameraLocked")
	static boolean isCameraLocked;
	@ObfuscatedName("pc")
	@Export("mapIconXs")
	static int[] mapIconXs;
	@ObfuscatedName("rg")
	static short field717;
	@ObfuscatedName("rd")
	static short field878;
	@ObfuscatedName("rx")
	@ObfuscatedGetter(
		intValue = 800808315
	)
	@Export("viewportZoom")
	static int viewportZoom;
	@ObfuscatedName("rs")
	static short field877;
	@ObfuscatedName("ru")
	@ObfuscatedGetter(
		intValue = 2115221335
	)
	@Export("viewportWidth")
	static int viewportWidth;
	@ObfuscatedName("pu")
	@Export("mapIconYs")
	static int[] mapIconYs;
	@ObfuscatedName("rq")
	@ObfuscatedGetter(
		intValue = -1883093259
	)
	@Export("viewportHeight")
	static int viewportHeight;
	@ObfuscatedName("ph")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("mapIcons")
	static Sprite[] mapIcons;
	@ObfuscatedName("nz")
	@ObfuscatedGetter(
		intValue = -43756245
	)
	static int field816;
	@ObfuscatedName("rv")
	@Export("zoomWidth")
	static short zoomWidth;
	@ObfuscatedName("rk")
	@Export("zoomHeight")
	static short zoomHeight;
	@ObfuscatedName("pk")
	@ObfuscatedGetter(
		intValue = -145873327
	)
	static int field844;
	@ObfuscatedName("rp")
	@ObfuscatedGetter(
		intValue = -2105667825
	)
	@Export("viewportOffsetX")
	static int viewportOffsetX;
	@ObfuscatedName("rb")
	@ObfuscatedGetter(
		intValue = -1006224971
	)
	@Export("viewportOffsetY")
	static int viewportOffsetY;
	@ObfuscatedName("sr")
	@ObfuscatedGetter(
		intValue = -508225451
	)
	static int field895;
	@ObfuscatedName("mz")
	@ObfuscatedGetter(
		intValue = -929837777
	)
	@Export("chatEffects")
	static int chatEffects;
	@ObfuscatedName("pf")
	static int[] field846;
	@ObfuscatedName("nf")
	@Export("changedSkills")
	static int[] changedSkills;
	@ObfuscatedName("md")
	@ObfuscatedGetter(
		intValue = -599630459
	)
	static int field787;
	@ObfuscatedName("nn")
	@ObfuscatedGetter(
		intValue = 1578967305
	)
	@Export("changedSkillsCount")
	static int changedSkillsCount;
	@ObfuscatedName("pl")
	static int[] field845;
	@ObfuscatedName("om")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	static NodeDeque field822;
	@ObfuscatedName("oa")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	static NodeDeque field823;
	@ObfuscatedName("mc")
	@ObfuscatedGetter(
		intValue = -1532518557
	)
	@Export("followerIndex")
	static int followerIndex;
	@ObfuscatedName("me")
	@Export("playerMod")
	static boolean playerMod;
	@ObfuscatedName("pw")
	static long[] field842;
	@ObfuscatedName("mf")
	@ObfuscatedGetter(
		intValue = 291908247
	)
	static int field784;
	@ObfuscatedName("mu")
	@ObfuscatedGetter(
		intValue = 1692346051
	)
	static int field785;
	@ObfuscatedName("nq")
	static int[] field810;
	@ObfuscatedName("nx")
	@ObfuscatedGetter(
		intValue = -417024903
	)
	static int field811;
	@ObfuscatedName("py")
	@ObfuscatedGetter(
		intValue = -357817807
	)
	static int field843;
	@ObfuscatedName("nb")
	@ObfuscatedGetter(
		intValue = 1490528893
	)
	static int field818;
	@ObfuscatedName("nv")
	@ObfuscatedGetter(
		intValue = -969012153
	)
	@Export("chatCycle")
	static int chatCycle;
	@ObfuscatedName("pr")
	static int[] field838;
	@ObfuscatedName("pv")
	static String field778;
	@ObfuscatedName("su")
	@ObfuscatedSignature(
		signature = "Lbh;"
	)
	@Export("GrandExchangeEvents_worldComparator")
	static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "[Lfj;"
	)
	@Export("collisionMaps")
	static CollisionMap[] collisionMaps;
	@ObfuscatedName("au")
	static boolean field859;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = -1601715751
	)
	@Export("worldId")
	public static int worldId;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = -336941817
	)
	@Export("worldProperties")
	static int worldProperties;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = -21053855
	)
	@Export("gameBuild")
	static int gameBuild;
	@ObfuscatedName("bv")
	@Export("isMembersWorld")
	public static boolean isMembersWorld;
	@ObfuscatedName("bf")
	@Export("isLowDetail")
	static boolean isLowDetail;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = -619085493
	)
	@Export("clientType")
	static int clientType;
	@ObfuscatedName("bd")
	@Export("onMobile")
	static boolean onMobile;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = 979578981
	)
	@Export("gameState")
	static int gameState;
	@ObfuscatedName("cl")
	@Export("isLoading")
	static boolean isLoading;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		intValue = -421753635
	)
	@Export("cycle")
	static int cycle;
	@ObfuscatedName("ck")
	@ObfuscatedGetter(
		longValue = -2177862012232032419L
	)
	@Export("mouseLastLastPressedTimeMillis")
	static long mouseLastLastPressedTimeMillis;
	@ObfuscatedName("ce")
	@ObfuscatedGetter(
		intValue = -885585199
	)
	static int field635;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = -777137731
	)
	static int field667;
	@ObfuscatedName("cj")
	@ObfuscatedGetter(
		longValue = 7724193620298551405L
	)
	static long field637;
	@ObfuscatedName("cw")
	@Export("hadFocus")
	static boolean hadFocus;
	@ObfuscatedName("cu")
	@Export("displayFps")
	static boolean displayFps;
	@ObfuscatedName("cd")
	@ObfuscatedGetter(
		intValue = 1698015517
	)
	@Export("rebootTimer")
	static int rebootTimer;
	@ObfuscatedName("cs")
	@ObfuscatedGetter(
		intValue = -1598349441
	)
	@Export("hintArrowType")
	static int hintArrowType;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = -472115629
	)
	@Export("hintArrowNpcIndex")
	static int hintArrowNpcIndex;
	@ObfuscatedName("ci")
	@ObfuscatedGetter(
		intValue = -1186478901
	)
	@Export("hintArrowPlayerIndex")
	static int hintArrowPlayerIndex;
	@ObfuscatedName("cf")
	@ObfuscatedGetter(
		intValue = -2024539797
	)
	@Export("hintArrowX")
	static int hintArrowX;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = -441319329
	)
	@Export("hintArrowY")
	static int hintArrowY;
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = 2122782524
	)
	@Export("hintArrowHeight")
	static int hintArrowHeight;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = -762662848
	)
	@Export("hintArrowSubX")
	static int hintArrowSubX;
	@ObfuscatedName("cp")
	@ObfuscatedGetter(
		intValue = 2006872512
	)
	@Export("hintArrowSubY")
	static int hintArrowSubY;
	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		signature = "Lcl;"
	)
	@Export("playerAttackOption")
	static AttackOption playerAttackOption;
	@ObfuscatedName("dj")
	@ObfuscatedSignature(
		signature = "Lcl;"
	)
	@Export("npcAttackOption")
	static AttackOption npcAttackOption;
	@ObfuscatedName("do")
	@ObfuscatedGetter(
		intValue = -1724817993
	)
	@Export("titleLoadingStage")
	static int titleLoadingStage;
	@ObfuscatedName("dd")
	@ObfuscatedGetter(
		intValue = -1719889523
	)
	@Export("js5ConnectState")
	static int js5ConnectState;
	@ObfuscatedName("dp")
	@ObfuscatedGetter(
		intValue = 1027381769
	)
	static int field653;
	@ObfuscatedName("en")
	@ObfuscatedGetter(
		intValue = -196326053
	)
	@Export("js5Errors")
	static int js5Errors;
	@ObfuscatedName("eo")
	@ObfuscatedGetter(
		intValue = 626628081
	)
	@Export("loginState")
	static int loginState;
	@ObfuscatedName("el")
	@ObfuscatedGetter(
		intValue = 6099821
	)
	static int field656;
	@ObfuscatedName("ea")
	@ObfuscatedGetter(
		intValue = 2105698063
	)
	static int field841;
	@ObfuscatedName("em")
	@ObfuscatedGetter(
		intValue = -1207133761
	)
	static int field821;
	@ObfuscatedName("ev")
	@ObfuscatedSignature(
		signature = "Lfr;"
	)
	static class160 field659;
	@ObfuscatedName("eb")
	@Export("Login_isUsernameRemembered")
	static boolean Login_isUsernameRemembered;
	@ObfuscatedName("ei")
	@ObfuscatedSignature(
		signature = "Lce;"
	)
	@Export("secureRandomFuture")
	static SecureRandomFuture secureRandomFuture;
	@ObfuscatedName("ee")
	@Export("randomDatData")
	static byte[] randomDatData;
	@ObfuscatedName("ew")
	@ObfuscatedSignature(
		signature = "[Lct;"
	)
	@Export("npcs")
	static NPC[] npcs;
	@ObfuscatedName("ex")
	@ObfuscatedGetter(
		intValue = 2015808657
	)
	@Export("npcCount")
	static int npcCount;
	@ObfuscatedName("ft")
	@Export("npcIndices")
	static int[] npcIndices;
	@ObfuscatedName("ff")
	@ObfuscatedGetter(
		intValue = -2130035923
	)
	static int field666;
	@ObfuscatedName("fh")
	static int[] field881;
	@ObfuscatedName("fd")
	@ObfuscatedSignature(
		signature = "Lcx;"
	)
	@Export("packetWriter")
	public static final PacketWriter packetWriter;
	@ObfuscatedName("fz")
	@ObfuscatedGetter(
		intValue = 857108449
	)
	@Export("logoutTimer")
	static int logoutTimer;
	@ObfuscatedName("fs")
	static boolean field772;
	@ObfuscatedName("fc")
	@Export("useBufferedSocket")
	static boolean useBufferedSocket;
	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		signature = "Ljg;"
	)
	@Export("timer")
	static Timer timer;
	@ObfuscatedName("fj")
	@Export("fontsMap")
	static HashMap fontsMap;
	@ObfuscatedName("fb")
	@ObfuscatedGetter(
		intValue = -435264727
	)
	static int field674;
	@ObfuscatedName("fn")
	@ObfuscatedGetter(
		intValue = -999239425
	)
	static int field851;
	@ObfuscatedName("fo")
	@ObfuscatedGetter(
		intValue = 966695411
	)
	static int field676;
	@ObfuscatedName("ga")
	@ObfuscatedGetter(
		intValue = -315742403
	)
	static int field872;
	@ObfuscatedName("gw")
	@ObfuscatedGetter(
		intValue = 917555973
	)
	static int field678;
	@ObfuscatedName("gr")
	@Export("regionMapArchives")
	static byte[][] regionMapArchives;
	@ObfuscatedName("ge")
	@Export("isInInstance")
	static boolean isInInstance;
	@ObfuscatedName("gh")
	@Export("instanceChunkTemplates")
	static int[][][] instanceChunkTemplates;
	@ObfuscatedName("gq")
	static final int[] field682;
	@ObfuscatedName("gg")
	@ObfuscatedGetter(
		intValue = -827918895
	)
	static int field683;
	@ObfuscatedName("hh")
	@ObfuscatedGetter(
		intValue = 2087511617
	)
	static int field684;
	@ObfuscatedName("hq")
	@ObfuscatedGetter(
		intValue = 1637234425
	)
	static int field745;
	@ObfuscatedName("hd")
	@ObfuscatedGetter(
		intValue = -1929516521
	)
	static int field686;
	@ObfuscatedName("hi")
	@ObfuscatedGetter(
		intValue = 669795741
	)
	static int field817;
	@ObfuscatedName("hc")
	static boolean field712;
	@ObfuscatedName("hj")
	@ObfuscatedGetter(
		intValue = -267408535
	)
	@Export("alternativeScrollbarWidth")
	static int alternativeScrollbarWidth;
	@ObfuscatedName("hu")
	@ObfuscatedGetter(
		intValue = -950947723
	)
	@Export("camAngleX")
	static int camAngleX;
	@ObfuscatedName("hk")
	@ObfuscatedGetter(
		intValue = -1326038309
	)
	@Export("camAngleY")
	static int camAngleY;
	@ObfuscatedName("hr")
	@ObfuscatedGetter(
		intValue = -872269345
	)
	@Export("camAngleDY")
	static int camAngleDY;
	@ObfuscatedName("he")
	@ObfuscatedGetter(
		intValue = -164832567
	)
	@Export("camAngleDX")
	static int camAngleDX;
	@ObfuscatedName("hb")
	@ObfuscatedGetter(
		intValue = 2064310305
	)
	@Export("mouseCamClickedX")
	static int mouseCamClickedX;
	@ObfuscatedName("hv")
	@ObfuscatedGetter(
		intValue = -2006290321
	)
	@Export("mouseCamClickedY")
	static int mouseCamClickedY;
	@ObfuscatedName("hn")
	@ObfuscatedGetter(
		intValue = 1652098085
	)
	@Export("oculusOrbState")
	static int oculusOrbState;
	@ObfuscatedName("hx")
	@Export("camFollowHeight")
	static int camFollowHeight;
	@ObfuscatedName("hg")
	@ObfuscatedGetter(
		intValue = 2081108025
	)
	static int field698;
	@ObfuscatedName("hz")
	@ObfuscatedGetter(
		intValue = 1839311001
	)
	static int field802;
	@ObfuscatedName("ib")
	@ObfuscatedGetter(
		intValue = 273401701
	)
	static int field700;
	@ObfuscatedName("in")
	@ObfuscatedGetter(
		intValue = 102668235
	)
	@Export("oculusOrbNormalSpeed")
	static int oculusOrbNormalSpeed;
	@ObfuscatedName("ir")
	@ObfuscatedGetter(
		intValue = -647084875
	)
	@Export("oculusOrbSlowedSpeed")
	static int oculusOrbSlowedSpeed;
	@ObfuscatedName("ii")
	@ObfuscatedGetter(
		intValue = 765307009
	)
	public static int field688;
	@ObfuscatedName("ik")
	static boolean field824;
	@ObfuscatedName("is")
	@ObfuscatedGetter(
		intValue = -480860359
	)
	static int field883;
	@ObfuscatedName("iu")
	static boolean field858;
	@ObfuscatedName("ih")
	@ObfuscatedGetter(
		intValue = 483214157
	)
	static int field707;
	@ObfuscatedName("im")
	@ObfuscatedGetter(
		intValue = -907822963
	)
	@Export("overheadTextCount")
	static int overheadTextCount;
	@ObfuscatedName("il")
	@ObfuscatedGetter(
		intValue = -955046711
	)
	@Export("overheadTextLimit")
	static int overheadTextLimit;
	@ObfuscatedName("iq")
	@Export("overheadTextXs")
	static int[] overheadTextXs;
	@ObfuscatedName("if")
	@Export("overheadTextYs")
	static int[] overheadTextYs;
	@ObfuscatedName("it")
	@Export("selectedItemName")
	static String selectedItemName;
	@ObfuscatedName("ij")
	@Export("overheadTextAscents")
	static int[] overheadTextAscents;
	@ObfuscatedName("iv")
	@Export("overheadTextXOffsets")
	static int[] overheadTextXOffsets;
	@ObfuscatedName("ic")
	@Export("overheadTextColors")
	static int[] overheadTextColors;
	@ObfuscatedName("iy")
	@Export("overheadTextEffects")
	static int[] overheadTextEffects;
	@ObfuscatedName("id")
	@Export("overheadTextCyclesRemaining")
	static int[] overheadTextCyclesRemaining;
	@ObfuscatedName("ie")
	@Export("overheadText")
	static String[] overheadText;
	@ObfuscatedName("ia")
	@Export("tileLastDrawnActor")
	static int[][] tileLastDrawnActor;
	@ObfuscatedName("ip")
	@ObfuscatedGetter(
		intValue = -455282343
	)
	@Export("viewportDrawCount")
	static int viewportDrawCount;
	@ObfuscatedName("iw")
	@ObfuscatedGetter(
		intValue = -1484250283
	)
	@Export("viewportTempX")
	static int viewportTempX;
	@ObfuscatedName("ig")
	@ObfuscatedGetter(
		intValue = 1892863881
	)
	@Export("viewportTempY")
	static int viewportTempY;
	@ObfuscatedName("jd")
	@ObfuscatedGetter(
		intValue = -710610133
	)
	@Export("mouseCrossX")
	static int mouseCrossX;
	@ObfuscatedName("jv")
	@ObfuscatedGetter(
		intValue = -784793429
	)
	@Export("mouseCrossY")
	static int mouseCrossY;
	@ObfuscatedName("jo")
	@ObfuscatedGetter(
		intValue = 1934089213
	)
	@Export("mouseCrossState")
	static int mouseCrossState;
	@ObfuscatedName("jf")
	@ObfuscatedGetter(
		intValue = -1311379791
	)
	@Export("mouseCrossColor")
	static int mouseCrossColor;
	@ObfuscatedName("jh")
	@Export("showMouseCross")
	static boolean showMouseCross;
	@ObfuscatedName("jk")
	@ObfuscatedGetter(
		intValue = -366431001
	)
	static int field727;
	@ObfuscatedName("js")
	@ObfuscatedGetter(
		intValue = -1998265721
	)
	static int field728;
	@ObfuscatedName("jc")
	@ObfuscatedGetter(
		intValue = 982214939
	)
	@Export("dragItemSlotSource")
	static int dragItemSlotSource;
	@ObfuscatedName("jg")
	@ObfuscatedGetter(
		intValue = 510687779
	)
	static int field730;
	@ObfuscatedName("jl")
	@ObfuscatedGetter(
		intValue = 1673443473
	)
	static int field870;
	@ObfuscatedName("jw")
	@ObfuscatedGetter(
		intValue = 1696900929
	)
	@Export("dragItemSlotDestination")
	static int dragItemSlotDestination;
	@ObfuscatedName("jq")
	static boolean field733;
	@ObfuscatedName("ji")
	@ObfuscatedGetter(
		intValue = -1288025075
	)
	@Export("itemDragDuration")
	static int itemDragDuration;
	@ObfuscatedName("jm")
	@ObfuscatedGetter(
		intValue = 1089693987
	)
	static int field735;
	@ObfuscatedName("je")
	@Export("showLoadingMessages")
	static boolean showLoadingMessages;
	@ObfuscatedName("jb")
	@ObfuscatedSignature(
		signature = "[Lby;"
	)
	@Export("players")
	static Player[] players;
	@ObfuscatedName("jt")
	@ObfuscatedGetter(
		intValue = 946713101
	)
	@Export("localPlayerIndex")
	static int localPlayerIndex;
	@ObfuscatedName("jy")
	@ObfuscatedGetter(
		intValue = -2053869901
	)
	static int field739;
	@ObfuscatedName("jp")
	@Export("renderSelf")
	static boolean renderSelf;
	@ObfuscatedName("kb")
	@ObfuscatedGetter(
		intValue = 1018003901
	)
	@Export("drawPlayerNames")
	static int drawPlayerNames;
	@ObfuscatedName("kn")
	@ObfuscatedGetter(
		intValue = -1864645893
	)
	static int field742;
	@ObfuscatedName("ku")
	static int[] field731;
	@ObfuscatedName("kf")
	@Export("playerMenuOpcodes")
	static final int[] playerMenuOpcodes;
	@ObfuscatedName("ko")
	@Export("playerMenuActions")
	static String[] playerMenuActions;
	@ObfuscatedName("km")
	@Export("playerOptionsPriorities")
	static boolean[] playerOptionsPriorities;
	@ObfuscatedName("kv")
	@Export("defaultRotations")
	static int[] defaultRotations;
	@ObfuscatedName("kt")
	@ObfuscatedGetter(
		intValue = 14237999
	)
	@Export("combatTargetPlayerIndex")
	static int combatTargetPlayerIndex;
	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		signature = "[[[Ljv;"
	)
	@Export("groundItems")
	static NodeDeque[][][] groundItems;
	@ObfuscatedName("kp")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("pendingSpawns")
	static NodeDeque pendingSpawns;
	@ObfuscatedName("ky")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("projectiles")
	static NodeDeque projectiles;
	@ObfuscatedName("ki")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("graphicsObjects")
	static NodeDeque graphicsObjects;
	@ObfuscatedName("kw")
	@Export("currentLevels")
	static int[] currentLevels;
	@ObfuscatedName("ks")
	@Export("levels")
	static int[] levels;
	@ObfuscatedName("ka")
	@Export("experience")
	static int[] experience;
	@ObfuscatedName("kq")
	@ObfuscatedGetter(
		intValue = -1919852667
	)
	@Export("leftClickOpensMenu")
	static int leftClickOpensMenu;
	@ObfuscatedName("kx")
	@Export("isMenuOpen")
	static boolean isMenuOpen;
	@ObfuscatedName("lx")
	@ObfuscatedGetter(
		intValue = -1574159447
	)
	@Export("menuOptionsCount")
	static int menuOptionsCount;
	@ObfuscatedName("le")
	@Export("menuArguments1")
	static int[] menuArguments1;
	@ObfuscatedName("lj")
	@Export("menuArguments2")
	static int[] menuArguments2;
	@ObfuscatedName("ls")
	@Export("menuOpcodes")
	static int[] menuOpcodes;
	@ObfuscatedName("lm")
	@Export("menuIdentifiers")
	static int[] menuIdentifiers;
	@ObfuscatedName("lr")
	@Export("menuActions")
	static String[] menuActions;
	@ObfuscatedName("lp")
	@Export("menuTargets")
	static String[] menuTargets;
	@ObfuscatedName("lw")
	@Export("menuShiftClick")
	static boolean[] menuShiftClick;
	@ObfuscatedName("lf")
	@Export("followerOpsLowPriority")
	static boolean followerOpsLowPriority;
	@ObfuscatedName("lt")
	@Export("shiftClickDrop")
	static boolean shiftClickDrop;
	@ObfuscatedName("li")
	@Export("tapToDrop")
	static boolean tapToDrop;
	@ObfuscatedName("lg")
	@Export("showMouseOverText")
	static boolean showMouseOverText;
	@ObfuscatedName("lz")
	@ObfuscatedGetter(
		intValue = -702365679
	)
	@Export("viewportX")
	static int viewportX;
	@ObfuscatedName("ld")
	@ObfuscatedGetter(
		intValue = 1651328511
	)
	@Export("viewportY")
	static int viewportY;
	@ObfuscatedName("ly")
	@ObfuscatedGetter(
		intValue = -1857574121
	)
	static int field773;
	@ObfuscatedName("ln")
	@ObfuscatedGetter(
		intValue = 1950322865
	)
	static int field738;
	@ObfuscatedName("lu")
	@ObfuscatedGetter(
		intValue = 159235159
	)
	@Export("isItemSelected")
	static int isItemSelected;
	@ObfuscatedName("lh")
	@Export("isSpellSelected")
	static boolean isSpellSelected;
	@ObfuscatedName("ll")
	@ObfuscatedGetter(
		intValue = -465859219
	)
	static int field687;
	@ObfuscatedName("ml")
	@ObfuscatedGetter(
		intValue = -1436921851
	)
	static int field648;
	@ObfuscatedName("ma")
	@Export("selectedSpellActionName")
	static String selectedSpellActionName;
	@ObfuscatedName("mw")
	@Export("selectedSpellName")
	static String selectedSpellName;
	@ObfuscatedName("mr")
	@ObfuscatedGetter(
		intValue = 173733075
	)
	@Export("rootInterface")
	static int rootInterface;

	static {
		field859 = true;
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
		field635 = -1;
		field667 = -1;
		field637 = -1L;
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
		field653 = 0;
		js5Errors = 0;
		loginState = 0;
		field656 = 0;
		field841 = 0;
		field821 = 0;
		field659 = class160.field1973;
		Login_isUsernameRemembered = false;
		secureRandomFuture = new SecureRandomFuture();
		randomDatData = null;
		npcs = new NPC[32768];
		npcCount = 0;
		npcIndices = new int[32768];
		field666 = 0;
		field881 = new int[250];
		packetWriter = new PacketWriter();
		logoutTimer = 0;
		field772 = false;
		useBufferedSocket = true;
		timer = new Timer();
		fontsMap = new HashMap();
		field674 = 0;
		field851 = 1;
		field676 = 0;
		field872 = 1;
		field678 = 0;
		collisionMaps = new CollisionMap[4];
		isInInstance = false;
		instanceChunkTemplates = new int[4][13][13];
		field682 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
		field683 = 0;
		field684 = 2301979;
		field745 = 5063219;
		field686 = 3353893;
		field817 = 7759444;
		field712 = false;
		alternativeScrollbarWidth = 0;
		camAngleX = 128;
		camAngleY = 0;
		camAngleDY = 0;
		camAngleDX = 0;
		mouseCamClickedX = 0;
		mouseCamClickedY = 0;
		oculusOrbState = 0;
		camFollowHeight = -1937934274;
		field698 = 0;
		field802 = 0;
		field700 = 0;
		oculusOrbNormalSpeed = 12;
		oculusOrbSlowedSpeed = 6;
		field688 = 0;
		field824 = false;
		field883 = 0;
		field858 = false;
		field707 = 0;
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
		field727 = 0;
		field728 = 0;
		dragItemSlotSource = 0;
		field730 = 0;
		field870 = 0;
		dragItemSlotDestination = 0;
		field733 = false;
		itemDragDuration = 0;
		field735 = 0;
		showLoadingMessages = true;
		players = new Player[2048];
		localPlayerIndex = -1;
		field739 = 0;
		renderSelf = true;
		drawPlayerNames = 0;
		field742 = 0;
		field731 = new int[1000];
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
		field773 = 0;
		field738 = 50;
		isItemSelected = 0;
		selectedItemName = null;
		isSpellSelected = false;
		field687 = -1;
		field648 = -1;
		selectedSpellActionName = null;
		selectedSpellName = null;
		rootInterface = -1;
		interfaceParents = new NodeHashTable(8);
		field784 = 0;
		field785 = -1;
		chatEffects = 0;
		field787 = 0;
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
		field800 = false;
		field801 = -1;
		field706 = -1;
		field803 = false;
		field804 = -1;
		field699 = -1;
		isDraggingWidget = false;
		cycleCntr = 1;
		field808 = new int[32];
		field809 = 0;
		field810 = new int[32];
		field811 = 0;
		changedSkills = new int[32];
		changedSkillsCount = 0;
		chatCycle = 0;
		field815 = 0;
		field816 = 0;
		field866 = 0;
		field818 = 0;
		field670 = 0;
		mouseWheelRotation = 0;
		scriptEvents = new NodeDeque();
		field822 = new NodeDeque();
		field823 = new NodeDeque();
		widgetClickMasks = new NodeHashTable(512);
		rootWidgetCount = 0;
		field826 = -2;
		field827 = new boolean[100];
		field828 = new boolean[100];
		field647 = new boolean[100];
		rootWidgetXs = new int[100];
		rootWidgetYs = new int[100];
		rootWidgetWidths = new int[100];
		rootWidgetHeights = new int[100];
		gameDrawingMode = 0;
		field835 = 0L;
		isResizable = true;
		field838 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
		publicChatMode = 0;
		tradeChatMode = 0;
		field778 = "";
		field842 = new long[100];
		field843 = 0;
		field844 = 0;
		field845 = new int[128];
		field846 = new int[128];
		field750 = -1L;
		field848 = -1;
		mapIconCount = 0;
		mapIconXs = new int[1000];
		mapIconYs = new int[1000];
		mapIcons = new Sprite[1000];
		destinationX = 0;
		destinationY = 0;
		minimapState = 0;
		field638 = 255;
		field857 = -1;
		field746 = false;
		soundEffectVolume = 127;
		field860 = 127;
		soundEffectCount = 0;
		soundEffectIds = new int[50];
		queuedSoundEffectLoops = new int[50];
		queuedSoundEffectDelays = new int[50];
		soundLocations = new int[50];
		soundEffects = new SoundEffect[50];
		isCameraLocked = false;
		field749 = new boolean[5];
		field779 = new int[5];
		field887 = new int[5];
		field871 = new int[5];
		field799 = new int[5];
		field873 = 256;
		field752 = 205;
		zoomHeight = 256;
		zoomWidth = 320;
		field877 = 1;
		field878 = 32767;
		field879 = 1;
		field717 = 32767;
		viewportOffsetX = 0;
		viewportOffsetY = 0;
		viewportWidth = 0;
		viewportHeight = 0;
		viewportZoom = 0;
		playerAppearance = new PlayerAppearance();
		field703 = -1;
		field888 = -1;
		platformInfoProvider = new DesktopPlatformInfoProvider();
		grandExchangeOffers = new GrandExchangeOffer[8];
		GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
		field892 = -1;
		archiveLoaders = new ArrayList(10);
		archiveLoaderArchive = 0;
		field895 = 0;
		field896 = new class65();
		field897 = new int[50];
		field622 = new int[50];
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1419567103"
	)
	@Export("resizeGame")
	protected final void resizeGame() {
		field835 = SoundCache.method2480() + 500L;
		this.resizeJS();
		if (rootInterface != -1) {
			this.resizeRoot(true);
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "77"
	)
	@Export("setUp")
	protected final void setUp() {
		LoginScreenAnimation.method1802(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
		WorldMapSection1.port1 = gameBuild == 0 ? 43594 : worldId + 40000;
		IsaacCipher.port2 = gameBuild == 0 ? 443 : worldId + 50000;
		LoginPacket.port3 = WorldMapSection1.port1;
		UserComparator8.field1944 = class215.field2518;
		PlayerAppearance.field2508 = class215.field2519;
		PlayerAppearance.field2513 = class215.field2520;
		PlayerAppearance.field2511 = class215.field2521;
		RouteStrategy.urlRequester = new UrlRequester();
		this.setUpKeyboard();
		this.setUpMouse();
		class80.mouseWheel = this.mouseWheel();
		RouteStrategy.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		AccessFile var2 = null;
		ClientPreferences var3 = new ClientPreferences();

		try {
			var2 = GrandExchangeOfferUnitPriceComparator.getPreferencesFile("", class43.field359.name, false);
			byte[] var4 = new byte[(int)var2.length()];

			int var6;
			for (int var5 = 0; var5 < var4.length; var5 += var6) {
				var6 = var2.read(var4, var5, var4.length - var5);
				if (var6 == -1) {
					throw new IOException();
				}
			}

			var3 = new ClientPreferences(new Buffer(var4));
		} catch (Exception var8) {
		}

		try {
			if (var2 != null) {
				var2.close();
			}
		} catch (Exception var7) {
		}

		Actor.clientPreferences = var3;
		this.setUpClipboard();
		String var9 = class195.null_string;
		class51.applet = this;
		if (var9 != null) {
			class51.field406 = var9;
		}

		if (gameBuild != 0) {
			displayFps = true;
		}

		MusicPatchNode.setWindowedMode(Actor.clientPreferences.windowMode);
		class218.friendSystem = new FriendSystem(class4.loginType);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2117082118"
	)
	@Export("doCycle")
	protected final void doCycle() {
		++cycle;
		this.doCycleJs5();
		Login.method2051();

		int var1;
		try {
			if (class197.field2376 == 1) {
				var1 = class197.midiPcmStream.method3687();
				if (var1 > 0 && class197.midiPcmStream.isReady()) {
					var1 -= ModelData0.field1833;
					if (var1 < 0) {
						var1 = 0;
					}

					class197.midiPcmStream.method3686(var1);
				} else {
					class197.midiPcmStream.clear();
					class197.midiPcmStream.removeAll();
					if (class197.musicTrackArchive != null) {
						class197.field2376 = 2;
					} else {
						class197.field2376 = 0;
					}

					ReflectionCheck.musicTrack = null;
					Language.soundCache = null;
				}
			}
		} catch (Exception var60) {
			var60.printStackTrace();
			class197.midiPcmStream.clear();
			class197.field2376 = 0;
			ReflectionCheck.musicTrack = null;
			Language.soundCache = null;
			class197.musicTrackArchive = null;
		}

		ModelData0.playPcmPlayers();
		WorldMapSectionType.method220();
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

		if (class80.mouseWheel != null) {
			var1 = class80.mouseWheel.useRotation();
			mouseWheelRotation = var1;
		}

		if (gameState == 0) {
			Decimator.load();
			WallDecoration.method3259();
		} else if (gameState == 5) {
			FontName.method5284(this);
			Decimator.load();
			WallDecoration.method3259();
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				FontName.method5284(this);
				this.doCycleLoggedOut();
			} else if (gameState == 25) {
				StudioGame.method4131(false);
				field674 = 0;
				boolean var61 = true;

				int var44;
				for (var44 = 0; var44 < MusicPatchPcmStream.regionLandArchives.length; ++var44) {
					if (WorldMapEvent.regionMapArchiveIds[var44] != -1 && MusicPatchPcmStream.regionLandArchives[var44] == null) {
						MusicPatchPcmStream.regionLandArchives[var44] = Timer.archive5.takeFile(WorldMapEvent.regionMapArchiveIds[var44], 0);
						if (MusicPatchPcmStream.regionLandArchives[var44] == null) {
							var61 = false;
							++field674;
						}
					}

					if (SequenceDefinition.regionLandArchiveIds[var44] != -1 && regionMapArchives[var44] == null) {
						regionMapArchives[var44] = Timer.archive5.takeFileEncrypted(SequenceDefinition.regionLandArchiveIds[var44], 0, GrandExchangeOfferAgeComparator.xteaKeys[var44]);
						if (regionMapArchives[var44] == null) {
							var61 = false;
							++field674;
						}
					}
				}

				if (!var61) {
					field678 = 1;
				} else {
					field676 = 0;
					var61 = true;

					int var4;
					int var5;
					for (var44 = 0; var44 < MusicPatchPcmStream.regionLandArchives.length; ++var44) {
						byte[] var3 = regionMapArchives[var44];
						if (var3 != null) {
							var4 = (class197.regions[var44] >> 8) * 64 - class4.baseX * 64;
							var5 = (class197.regions[var44] & 255) * 64 - ScriptEvent.baseY;
							if (isInInstance) {
								var4 = 10;
								var5 = 10;
							}

							var61 &= HitSplatDefinition.method4589(var3, var4, var5);
						}
					}

					if (!var61) {
						field678 = 2;
					} else {
						if (field678 != 0) {
							GZipDecompressor.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
						}

						ModelData0.playPcmPlayers();
						WorldMapIcon_1.scene.clear();

						for (var44 = 0; var44 < 4; ++var44) {
							collisionMaps[var44].clear();
						}

						int var45;
						for (var44 = 0; var44 < 4; ++var44) {
							for (var45 = 0; var45 < 104; ++var45) {
								for (var4 = 0; var4 < 104; ++var4) {
									Tiles.Tiles_renderFlags[var44][var45][var4] = 0;
								}
							}
						}

						ModelData0.playPcmPlayers();
						AbstractWorldMapData.method254();
						var44 = MusicPatchPcmStream.regionLandArchives.length;
						Widget.method4074();
						StudioGame.method4131(true);
						int var10;
						int var11;
						int var12;
						int var13;
						int var14;
						int var15;
						int var16;
						int var17;
						int var18;
						int var20;
						int var21;
						int var22;
						int var47;
						if (!isInInstance) {
							byte[] var6;
							for (var45 = 0; var45 < var44; ++var45) {
								var4 = (class197.regions[var45] >> 8) * 64 - class4.baseX * 64;
								var5 = (class197.regions[var45] & 255) * 64 - ScriptEvent.baseY;
								var6 = MusicPatchPcmStream.regionLandArchives[var45];
								if (var6 != null) {
									ModelData0.playPcmPlayers();
									GrandExchangeOfferOwnWorldComparator.method1244(var6, var4, var5, FloorDecoration.field1585 * 8 - 48, ReflectionCheck.field1303 * 8 - 48, collisionMaps);
								}
							}

							for (var45 = 0; var45 < var44; ++var45) {
								var4 = (class197.regions[var45] >> 8) * 64 - class4.baseX * 64;
								var5 = (class197.regions[var45] & 255) * 64 - ScriptEvent.baseY;
								var6 = MusicPatchPcmStream.regionLandArchives[var45];
								if (var6 == null && ReflectionCheck.field1303 < 800) {
									ModelData0.playPcmPlayers();
									FloorDecoration.method2813(var4, var5, 64, 64);
								}
							}

							StudioGame.method4131(true);

							for (var45 = 0; var45 < var44; ++var45) {
								byte[] var46 = regionMapArchives[var45];
								if (var46 != null) {
									var5 = (class197.regions[var45] >> 8) * 64 - class4.baseX * 64;
									var47 = (class197.regions[var45] & 255) * 64 - ScriptEvent.baseY;
									ModelData0.playPcmPlayers();
									Scene var7 = WorldMapIcon_1.scene;
									CollisionMap[] var8 = collisionMaps;
									Buffer var9 = new Buffer(var46);
									var10 = -1;

									while (true) {
										var11 = var9.method5480();
										if (var11 == 0) {
											break;
										}

										var10 += var11;
										var12 = 0;

										while (true) {
											var13 = var9.readUShortSmart();
											if (var13 == 0) {
												break;
											}

											var12 += var13 - 1;
											var14 = var12 & 63;
											var15 = var12 >> 6 & 63;
											var16 = var12 >> 12;
											var17 = var9.readUnsignedByte();
											var18 = var17 >> 2;
											int var19 = var17 & 3;
											var20 = var5 + var15;
											var21 = var14 + var47;
											if (var20 > 0 && var21 > 0 && var20 < 103 && var21 < 103) {
												var22 = var16;
												if ((Tiles.Tiles_renderFlags[1][var20][var21] & 2) == 2) {
													var22 = var16 - 1;
												}

												CollisionMap var23 = null;
												if (var22 >= 0) {
													var23 = var8[var22];
												}

												class185.method3602(var16, var20, var21, var10, var19, var18, var7, var23);
											}
										}
									}
								}
							}
						}

						int var48;
						int var49;
						int var50;
						if (isInInstance) {
							var45 = 0;

							label558:
							while (true) {
								int var26;
								int var28;
								int var29;
								int var30;
								CollisionMap[] var52;
								Buffer var53;
								int var54;
								if (var45 >= 4) {
									for (var45 = 0; var45 < 13; ++var45) {
										for (var4 = 0; var4 < 13; ++var4) {
											var5 = instanceChunkTemplates[0][var45][var4];
											if (var5 == -1) {
												FloorDecoration.method2813(var45 * 8, var4 * 8, 8, 8);
											}
										}
									}

									StudioGame.method4131(true);
									var45 = 0;

									while (true) {
										if (var45 >= 4) {
											break label558;
										}

										ModelData0.playPcmPlayers();

										for (var4 = 0; var4 < 13; ++var4) {
											label481:
											for (var5 = 0; var5 < 13; ++var5) {
												var47 = instanceChunkTemplates[var45][var4][var5];
												if (var47 != -1) {
													var48 = var47 >> 24 & 3;
													var49 = var47 >> 1 & 3;
													var50 = var47 >> 14 & 1023;
													var10 = var47 >> 3 & 2047;
													var11 = (var50 / 8 << 8) + var10 / 8;

													for (var12 = 0; var12 < class197.regions.length; ++var12) {
														if (class197.regions[var12] == var11 && regionMapArchives[var12] != null) {
															byte[] var55 = regionMapArchives[var12];
															var14 = var4 * 8;
															var15 = var5 * 8;
															var16 = (var50 & 7) * 8;
															var17 = (var10 & 7) * 8;
															Scene var56 = WorldMapIcon_1.scene;
															var52 = collisionMaps;
															var53 = new Buffer(var55);
															var21 = -1;

															while (true) {
																var22 = var53.method5480();
																if (var22 == 0) {
																	continue label481;
																}

																var21 += var22;
																var54 = 0;

																while (true) {
																	int var57 = var53.readUShortSmart();
																	if (var57 == 0) {
																		break;
																	}

																	var54 += var57 - 1;
																	int var25 = var54 & 63;
																	var26 = var54 >> 6 & 63;
																	int var27 = var54 >> 12;
																	var28 = var53.readUnsignedByte();
																	var29 = var28 >> 2;
																	var30 = var28 & 3;
																	if (var48 == var27 && var26 >= var16 && var26 < var16 + 8 && var25 >= var17 && var25 < var17 + 8) {
																		ObjectDefinition var58 = WallDecoration.getObjectDefinition(var21);
																		int var32 = var14 + WorldMapAreaData.method673(var26 & 7, var25 & 7, var49, var58.sizeX, var58.sizeY, var30);
																		int var35 = var26 & 7;
																		int var36 = var25 & 7;
																		int var38 = var58.sizeX;
																		int var39 = var58.sizeY;
																		int var40;
																		if ((var30 & 1) == 1) {
																			var40 = var38;
																			var38 = var39;
																			var39 = var40;
																		}

																		int var37 = var49 & 3;
																		int var34;
																		if (var37 == 0) {
																			var34 = var36;
																		} else if (var37 == 1) {
																			var34 = 7 - var35 - (var38 - 1);
																		} else if (var37 == 2) {
																			var34 = 7 - var36 - (var39 - 1);
																		} else {
																			var34 = var35;
																		}

																		var40 = var15 + var34;
																		if (var32 > 0 && var40 > 0 && var32 < 103 && var40 < 103) {
																			int var41 = var45;
																			if ((Tiles.Tiles_renderFlags[1][var32][var40] & 2) == 2) {
																				var41 = var45 - 1;
																			}

																			CollisionMap var42 = null;
																			if (var41 >= 0) {
																				var42 = var52[var41];
																			}

																			class185.method3602(var45, var32, var40, var21, var30 + var49 & 3, var29, var56, var42);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}

										++var45;
									}
								}

								ModelData0.playPcmPlayers();

								for (var4 = 0; var4 < 13; ++var4) {
									for (var5 = 0; var5 < 13; ++var5) {
										boolean var63 = false;
										var48 = instanceChunkTemplates[var45][var4][var5];
										if (var48 != -1) {
											var49 = var48 >> 24 & 3;
											var50 = var48 >> 1 & 3;
											var10 = var48 >> 14 & 1023;
											var11 = var48 >> 3 & 2047;
											var12 = (var10 / 8 << 8) + var11 / 8;

											for (var13 = 0; var13 < class197.regions.length; ++var13) {
												if (class197.regions[var13] == var12 && MusicPatchPcmStream.regionLandArchives[var13] != null) {
													byte[] var51 = MusicPatchPcmStream.regionLandArchives[var13];
													var15 = var4 * 8;
													var16 = var5 * 8;
													var17 = (var10 & 7) * 8;
													var18 = (var11 & 7) * 8;
													var52 = collisionMaps;

													for (var20 = 0; var20 < 8; ++var20) {
														for (var21 = 0; var21 < 8; ++var21) {
															if (var15 + var20 > 0 && var15 + var20 < 103 && var21 + var16 > 0 && var16 + var21 < 103) {
																int[] var10000 = var52[var45].flags[var15 + var20];
																var10000[var16 + var21] &= -16777217;
															}
														}
													}

													var53 = new Buffer(var51);

													for (var21 = 0; var21 < 4; ++var21) {
														for (var22 = 0; var22 < 64; ++var22) {
															for (var54 = 0; var54 < 64; ++var54) {
																if (var49 == var21 && var22 >= var17 && var22 < var17 + 8 && var54 >= var18 && var54 < var18 + 8) {
																	var26 = var15 + class40.method735(var22 & 7, var54 & 7, var50);
																	var29 = var22 & 7;
																	var30 = var54 & 7;
																	int var31 = var50 & 3;
																	if (var31 == 0) {
																		var28 = var30;
																	} else if (var31 == 1) {
																		var28 = 7 - var29;
																	} else if (var31 == 2) {
																		var28 = 7 - var30;
																	} else {
																		var28 = var29;
																	}

																	class32.loadTerrain(var53, var45, var26, var16 + var28, 0, 0, var50);
																} else {
																	class32.loadTerrain(var53, 0, -1, -1, 0, 0, 0);
																}
															}
														}
													}

													var63 = true;
													break;
												}
											}
										}

										if (!var63) {
											VarbitDefinition.method4499(var45, var4 * 8, var5 * 8);
										}
									}
								}

								++var45;
							}
						}

						StudioGame.method4131(true);
						ModelData0.playPcmPlayers();
						WallDecoration.method3257(WorldMapIcon_1.scene, collisionMaps);
						StudioGame.method4131(true);
						var45 = Tiles.Tiles_minPlane;
						if (var45 > MouseRecorder.plane) {
							var45 = MouseRecorder.plane;
						}

						if (var45 < MouseRecorder.plane - 1) {
							var45 = MouseRecorder.plane - 1;
						}

						if (isLowDetail) {
							WorldMapIcon_1.scene.init(Tiles.Tiles_minPlane);
						} else {
							WorldMapIcon_1.scene.init(0);
						}

						for (var4 = 0; var4 < 104; ++var4) {
							for (var5 = 0; var5 < 104; ++var5) {
								WorldMapCacheName.updateItemPile(var4, var5);
							}
						}

						ModelData0.playPcmPlayers();
						class247.method4484();
						ObjectDefinition.ObjectDefinition_cachedModelData.clear();
						PacketBufferNode var62;
						if (Coord.client.hasFrame()) {
							var62 = MenuAction.getPacketBufferNode(ClientPacket.field2235, packetWriter.isaacCipher);
							var62.packetBuffer.writeInt(1057001181);
							packetWriter.addNode(var62);
						}

						if (!isInInstance) {
							var4 = (FloorDecoration.field1585 - 6) / 8;
							var5 = (FloorDecoration.field1585 + 6) / 8;
							var47 = (ReflectionCheck.field1303 - 6) / 8;
							var48 = (ReflectionCheck.field1303 + 6) / 8;

							for (var49 = var4 - 1; var49 <= var5 + 1; ++var49) {
								for (var50 = var47 - 1; var50 <= var48 + 1; ++var50) {
									if (var49 < var4 || var49 > var5 || var50 < var47 || var50 > var48) {
										Timer.archive5.loadRegionFromName("m" + var49 + "_" + var50);
										Timer.archive5.loadRegionFromName("l" + var49 + "_" + var50);
									}
								}
							}
						}

						WorldMapIcon_0.updateGameState(30);
						ModelData0.playPcmPlayers();
						Tiles.field476 = null;
						class30.field257 = null;
						Tiles.field477 = null;
						HealthBar.field1089 = null;
						UserComparator3.field1961 = null;
						Tiles.field473 = null;
						class160.field1977 = null;
						UserComparator7.Tiles_hue = null;
						TileItem.Tiles_saturation = null;
						class1.Tiles_lightness = null;
						class42.Tiles_hueMultiplier = null;
						Tiles.field488 = null;
						var62 = MenuAction.getPacketBufferNode(ClientPacket.field2216, packetWriter.isaacCipher);
						packetWriter.addNode(var62);
						WallDecoration.method3259();
					}
				}
			}
		} else {
			FontName.method5284(this);
		}

		if (gameState == 30) {
			this.doCycleLoggedIn();
		} else if (gameState == 40 || gameState == 45) {
			this.doCycleLoggedOut();
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-2055189627"
	)
	@Export("draw")
	protected final void draw(boolean var1) {
		boolean var2;
		label167: {
			try {
				if (class197.field2376 == 2) {
					if (ReflectionCheck.musicTrack == null) {
						ReflectionCheck.musicTrack = MusicTrack.readTrack(class197.musicTrackArchive, class197.musicTrackGroupId, class197.musicTrackFileId);
						if (ReflectionCheck.musicTrack == null) {
							var2 = false;
							break label167;
						}
					}

					if (Language.soundCache == null) {
						Language.soundCache = new SoundCache(class197.soundEffectsArchive, class197.musicSamplesArchive);
					}

					if (class197.midiPcmStream.loadMusicTrack(ReflectionCheck.musicTrack, class197.musicPatchesArchive, Language.soundCache, 22050)) {
						class197.midiPcmStream.clearAll();
						class197.midiPcmStream.method3686(Canvas.field395);
						class197.midiPcmStream.setMusicTrack(ReflectionCheck.musicTrack, MouseRecorder.musicTrackBoolean);
						class197.field2376 = 0;
						ReflectionCheck.musicTrack = null;
						Language.soundCache = null;
						class197.musicTrackArchive = null;
						var2 = true;
						break label167;
					}
				}
			} catch (Exception var6) {
				var6.printStackTrace();
				class197.midiPcmStream.clear();
				class197.field2376 = 0;
				ReflectionCheck.musicTrack = null;
				Language.soundCache = null;
				class197.musicTrackArchive = null;
			}

			var2 = false;
		}

		if (var2 && field746 && WorldMapIcon_1.pcmPlayer0 != null) {
			WorldMapIcon_1.pcmPlayer0.tryDiscard();
		}

		if ((gameState == 10 || gameState == 20 || gameState == 30) && field835 != 0L && SoundCache.method2480() > field835) {
			MusicPatchNode.setWindowedMode(class43.getWindowedMode());
		}

		int var4;
		if (var1) {
			for (var4 = 0; var4 < 100; ++var4) {
				field827[var4] = true;
			}
		}

		if (gameState == 0) {
			this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
		} else if (gameState == 5) {
			GameShell.drawTitle(HealthBar.fontBold12, GrandExchangeEvent.fontPlain11, class197.fontPlain12);
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				GameShell.drawTitle(HealthBar.fontBold12, GrandExchangeEvent.fontPlain11, class197.fontPlain12);
			} else if (gameState == 25) {
				if (field678 == 1) {
					if (field674 > field851) {
						field851 = field674;
					}

					var4 = (field851 * 50 - field674 * 50) / field851;
					GZipDecompressor.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
				} else if (field678 == 2) {
					if (field676 > field872) {
						field872 = field676;
					}

					var4 = (field872 * 50 - field676 * 50) / field872 + 50;
					GZipDecompressor.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
				} else {
					GZipDecompressor.drawLoadingMessage("Loading - please wait.", false);
				}
			} else if (gameState == 30) {
				this.drawLoggedIn();
			} else if (gameState == 40) {
				GZipDecompressor.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
			} else if (gameState == 45) {
				GZipDecompressor.drawLoadingMessage("Please wait...", false);
			}
		} else {
			GameShell.drawTitle(HealthBar.fontBold12, GrandExchangeEvent.fontPlain11, class197.fontPlain12);
		}

		if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
			for (var4 = 0; var4 < rootWidgetCount; ++var4) {
				if (field828[var4]) {
					DevicePcmPlayerProvider.rasterProvider.draw(rootWidgetXs[var4], rootWidgetYs[var4], rootWidgetWidths[var4], rootWidgetHeights[var4]);
					field828[var4] = false;
				}
			}
		} else if (gameState > 0) {
			DevicePcmPlayerProvider.rasterProvider.drawFull(0, 0);

			for (var4 = 0; var4 < rootWidgetCount; ++var4) {
				field828[var4] = false;
			}
		}

	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "890859408"
	)
	@Export("kill0")
	protected final void kill0() {
		if (BoundaryObject.varcs.hasUnwrittenChanges()) {
			BoundaryObject.varcs.write();
		}

		if (ParamDefinition.mouseRecorder != null) {
			ParamDefinition.mouseRecorder.isRunning = false;
		}

		ParamDefinition.mouseRecorder = null;
		packetWriter.close();
		FriendSystem.method1871();
		if (MouseHandler.MouseHandler_instance != null) {
			synchronized(MouseHandler.MouseHandler_instance) {
				MouseHandler.MouseHandler_instance = null;
			}
		}

		class80.mouseWheel = null;
		if (WorldMapIcon_1.pcmPlayer0 != null) {
			WorldMapIcon_1.pcmPlayer0.shutdown();
		}

		if (ClientPreferences.pcmPlayer1 != null) {
			ClientPreferences.pcmPlayer1.shutdown();
		}

		if (NetCache.NetCache_socket != null) {
			NetCache.NetCache_socket.close();
		}

		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3126 != 0) {
				ArchiveDiskActionHandler.field3126 = 1;

				try {
					ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock.wait();
				} catch (InterruptedException var4) {
				}
			}
		}

		if (RouteStrategy.urlRequester != null) {
			RouteStrategy.urlRequester.close();
			RouteStrategy.urlRequester = null;
		}

		FloorDecoration.method2811();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "792262956"
	)
	protected final void vmethod1248() {
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
							Language var12;
							if (var4 >= 0 && var4 < Language.Language_valuesOrdered.length) {
								var12 = Language.Language_valuesOrdered[var4];
							} else {
								var12 = null;
							}

							class43.clientLanguage = var12;
							break;
						case 7:
							var4 = Integer.parseInt(var2);
							ServerBuild[] var5 = Tile.method2830();
							int var6 = 0;

							ServerBuild var3;
							while (true) {
								if (var6 >= var5.length) {
									var3 = null;
									break;
								}

								ServerBuild var7 = var5[var6];
								if (var4 == var7.field3077) {
									var3 = var7;
									break;
								}

								++var6;
							}

							WorldMapSprite.field226 = var3;
							break;
						case 8:
							if (var2.equalsIgnoreCase("true")) {
							}
							break;
						case 9:
							WorldMapArea.field217 = var2;
							break;
						case 10:
							class43.field359 = (StudioGame)ServerPacket.findEnumerated(Tile.method2831(), Integer.parseInt(var2));
							if (class43.field359 == StudioGame.oldscape) {
								class4.loginType = LoginType.oldscape;
							} else {
								class4.loginType = LoginType.field4024;
							}
							break;
						case 12:
							worldId = Integer.parseInt(var2);
							break;
						case 14:
							MouseRecorder.field565 = Integer.parseInt(var2);
							break;
						case 15:
							gameBuild = Integer.parseInt(var2);
							break;
						case 17:
							MouseHandler.field464 = var2;
						}
					}
				}

				Scene.Scene_isLowDetail = false;
				isLowDetail = false;
				ArchiveLoader.worldHost = this.getCodeBase().getHost();
				String var8 = WorldMapSprite.field226.name;
				byte var9 = 0;

				try {
					class192.method3650("oldschool", var8, var9, 21);
				} catch (Exception var10) {
					class188.RunException_sendStackTrace((String)null, var10);
				}

				Coord.client = this;
				Skills.field2723 = clientType;
				this.startThread(765, 503, 183);
			}
		} catch (RuntimeException var11) {
			throw ArchiveDiskActionHandler.newRunException(var11, "client.init(" + ')');
		}
	}

	@ObfuscatedSignature(
		signature = "()Ljt;"
	)
	public Username aac() {
		return Varps.localPlayer != null ? Varps.localPlayer.username : null;
	}

	@ObfuscatedSignature(
		signature = "()Ljt;"
	)
	public Username aak() {
		return Varps.localPlayer != null ? Varps.localPlayer.username : null;
	}

	@ObfuscatedSignature(
		signature = "()Ljt;"
	)
	public Username aap() {
		return Varps.localPlayer != null ? Varps.localPlayer.username : null;
	}

	@ObfuscatedSignature(
		signature = "()Ljt;"
	)
	public Username aaa() {
		return Varps.localPlayer != null ? Varps.localPlayer.username : null;
	}

	@ObfuscatedName("ef")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-465749667"
	)
	@Export("doCycleJs5")
	void doCycleJs5() {
		if (gameState != 1000) {
			boolean var1 = ViewportMouse.method2957();
			if (!var1) {
				this.doCycleJs5Connect();
			}

		}
	}

	@ObfuscatedName("ed")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
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

				field653 = 3000;
				NetCache.NetCache_ioExceptions = 3;
			}

			if (--field653 + 1 <= 0) {
				try {
					if (js5ConnectState == 0) {
						GrandExchangeOfferOwnWorldComparator.js5SocketTask = GameShell.taskHandler.newSocketTask(ArchiveLoader.worldHost, LoginPacket.port3);
						++js5ConnectState;
					}

					if (js5ConnectState == 1) {
						if (GrandExchangeOfferOwnWorldComparator.js5SocketTask.status == 2) {
							this.js5Error(-1);
							return;
						}

						if (GrandExchangeOfferOwnWorldComparator.js5SocketTask.status == 1) {
							++js5ConnectState;
						}
					}

					if (js5ConnectState == 2) {
						if (useBufferedSocket) {
							class219.js5Socket = Fonts.method5293((Socket)GrandExchangeOfferOwnWorldComparator.js5SocketTask.result, 40000, 5000);
						} else {
							class219.js5Socket = new NetSocket((Socket)GrandExchangeOfferOwnWorldComparator.js5SocketTask.result, GameShell.taskHandler, 5000);
						}

						Buffer var1 = new Buffer(5);
						var1.writeByte(15);
						var1.writeInt(183);
						class219.js5Socket.write(var1.array, 0, 5);
						++js5ConnectState;
						UserComparator10.field1946 = SoundCache.method2480();
					}

					if (js5ConnectState == 3) {
						if (class219.js5Socket.available() > 0 || !useBufferedSocket && gameState <= 5) {
							int var5 = class219.js5Socket.readUnsignedByte();
							if (var5 != 0) {
								this.js5Error(var5);
								return;
							}

							++js5ConnectState;
						} else if (SoundCache.method2480() - UserComparator10.field1946 > 30000L) {
							this.js5Error(-2);
							return;
						}
					}

					if (js5ConnectState == 4) {
						AbstractSocket var10 = class219.js5Socket;
						boolean var2 = gameState > 20;
						if (NetCache.NetCache_socket != null) {
							try {
								NetCache.NetCache_socket.close();
							} catch (Exception var8) {
							}

							NetCache.NetCache_socket = null;
						}

						NetCache.NetCache_socket = var10;
						class173.method3575(var2);
						NetCache.NetCache_responseHeaderBuffer.offset = 0;
						NetCache.NetCache_currentResponse = null;
						class336.NetCache_responseArchiveBuffer = null;
						NetCache.field3154 = 0;

						while (true) {
							NetFileRequest var3 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.first();
							if (var3 == null) {
								while (true) {
									var3 = (NetFileRequest)NetCache.NetCache_pendingResponses.first();
									if (var3 == null) {
										if (NetCache.field3158 != 0) {
											try {
												Buffer var11 = new Buffer(4);
												var11.writeByte(4);
												var11.writeByte(NetCache.field3158);
												var11.writeShort(0);
												NetCache.NetCache_socket.write(var11.array, 0, 4);
											} catch (IOException var7) {
												try {
													NetCache.NetCache_socket.close();
												} catch (Exception var6) {
												}

												++NetCache.NetCache_ioExceptions;
												NetCache.NetCache_socket = null;
											}
										}

										NetCache.NetCache_loadTime = 0;
										NetCache.field3145 = SoundCache.method2480();
										GrandExchangeOfferOwnWorldComparator.js5SocketTask = null;
										class219.js5Socket = null;
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

	@ObfuscatedName("eq")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-972474352"
	)
	@Export("js5Error")
	void js5Error(int var1) {
		GrandExchangeOfferOwnWorldComparator.js5SocketTask = null;
		class219.js5Socket = null;
		js5ConnectState = 0;
		if (LoginPacket.port3 == WorldMapSection1.port1) {
			LoginPacket.port3 = IsaacCipher.port2;
		} else {
			LoginPacket.port3 = WorldMapSection1.port1;
		}

		++js5Errors;
		if (js5Errors >= 2 && (var1 == 7 || var1 == 9)) {
			if (gameState <= 5) {
				this.error("js5connect_full");
				gameState = 1000;
			} else {
				field653 = 3000;
			}
		} else if (js5Errors >= 2 && var1 == 6) {
			this.error("js5connect_outofdate");
			gameState = 1000;
		} else if (js5Errors >= 4) {
			if (gameState <= 5) {
				this.error("js5connect");
				gameState = 1000;
			} else {
				field653 = 3000;
			}
		}

	}

	@ObfuscatedName("ez")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1821013754"
	)
	@Export("doCycleLoggedOut")
	final void doCycleLoggedOut() {
		Object var1 = packetWriter.getSocket();
		PacketBuffer var2 = packetWriter.packetBuffer;

		try {
			if (loginState == 0) {
				if (WorldMapEvent.secureRandom == null && (secureRandomFuture.isDone() || field656 > 250)) {
					WorldMapEvent.secureRandom = secureRandomFuture.get();
					secureRandomFuture.shutdown();
					secureRandomFuture = null;
				}

				if (WorldMapEvent.secureRandom != null) {
					if (var1 != null) {
						((AbstractSocket)var1).close();
						var1 = null;
					}

					PlayerType.socketTask = null;
					field772 = false;
					field656 = 0;
					loginState = 1;
				}
			}

			if (loginState == 1) {
				if (PlayerType.socketTask == null) {
					PlayerType.socketTask = GameShell.taskHandler.newSocketTask(ArchiveLoader.worldHost, LoginPacket.port3);
				}

				if (PlayerType.socketTask.status == 2) {
					throw new IOException();
				}

				if (PlayerType.socketTask.status == 1) {
					if (useBufferedSocket) {
						var1 = Fonts.method5293((Socket)PlayerType.socketTask.result, 40000, 5000);
					} else {
						var1 = new NetSocket((Socket)PlayerType.socketTask.result, GameShell.taskHandler, 5000);
					}

					packetWriter.setSocket((AbstractSocket)var1);
					PlayerType.socketTask = null;
					loginState = 2;
				}
			}

			if (loginState == 2) {
				packetWriter.clearBuffer();
				PacketBufferNode var4 = Skills.method4100();
				var4.clientPacket = null;
				var4.clientPacketLength = 0;
				var4.packetBuffer = new PacketBuffer(5000);
				var4.packetBuffer.writeByte(LoginPacket.field2291.id);
				packetWriter.addNode(var4);
				packetWriter.flush();
				var2.offset = 0;
				loginState = 3;
			}

			boolean var12;
			int var13;
			if (loginState == 3) {
				if (WorldMapIcon_1.pcmPlayer0 != null) {
					WorldMapIcon_1.pcmPlayer0.method2389();
				}

				if (ClientPreferences.pcmPlayer1 != null) {
					ClientPreferences.pcmPlayer1.method2389();
				}

				var12 = true;
				if (useBufferedSocket && !((AbstractSocket)var1).isAvailable(1)) {
					var12 = false;
				}

				if (var12) {
					var13 = ((AbstractSocket)var1).readUnsignedByte();
					if (WorldMapIcon_1.pcmPlayer0 != null) {
						WorldMapIcon_1.pcmPlayer0.method2389();
					}

					if (ClientPreferences.pcmPlayer1 != null) {
						ClientPreferences.pcmPlayer1.method2389();
					}

					if (var13 != 0) {
						WorldMapSprite.getLoginError(var13);
						return;
					}

					var2.offset = 0;
					loginState = 4;
				}
			}

			int var28;
			if (loginState == 4) {
				if (var2.offset < 8) {
					var28 = ((AbstractSocket)var1).available();
					if (var28 > 8 - var2.offset) {
						var28 = 8 - var2.offset;
					}

					if (var28 > 0) {
						((AbstractSocket)var1).read(var2.array, var2.offset, var28);
						var2.offset += var28;
					}
				}

				if (var2.offset == 8) {
					var2.offset = 0;
					ObjectSound.field1055 = var2.readLong();
					loginState = 5;
				}
			}

			if (loginState == 5) {
				packetWriter.packetBuffer.offset = 0;
				packetWriter.clearBuffer();
				PacketBuffer var3 = new PacketBuffer(500);
				int[] var23 = new int[]{WorldMapEvent.secureRandom.nextInt(), WorldMapEvent.secureRandom.nextInt(), WorldMapEvent.secureRandom.nextInt(), WorldMapEvent.secureRandom.nextInt()};
				var3.offset = 0;
				var3.writeByte(1);
				var3.writeInt(var23[0]);
				var3.writeInt(var23[1]);
				var3.writeInt(var23[2]);
				var3.writeInt(var23[3]);
				var3.writeLong(ObjectSound.field1055);
				int var11;
				if (gameState == 40) {
					var3.writeInt(UserComparator5.field1958[0]);
					var3.writeInt(UserComparator5.field1958[1]);
					var3.writeInt(UserComparator5.field1958[2]);
					var3.writeInt(UserComparator5.field1958[3]);
				} else {
					var3.writeByte(field659.rsOrdinal());
					switch(field659.field1978) {
					case 0:
					case 2:
						var3.writeMedium(class222.field2729);
						++var3.offset;
						break;
					case 1:
						LinkedHashMap var6 = Actor.clientPreferences.parameters;
						String var8 = Login.Login_username;
						int var9 = var8.length();
						int var10 = 0;

						for (var11 = 0; var11 < var9; ++var11) {
							var10 = (var10 << 5) - var10 + var8.charAt(var11);
						}

						var3.writeInt((Integer)var6.get(var10));
						break;
					case 3:
						var3.offset += 4;
					}

					var3.writeByte(class312.field3805.rsOrdinal());
					var3.writeStringCp1252NullTerminated(Login.Login_password);
				}

				var3.encryptRsa(class83.field1142, class83.field1139);
				UserComparator5.field1958 = var23;
				PacketBufferNode var26 = Skills.method4100();
				var26.clientPacket = null;
				var26.clientPacketLength = 0;
				var26.packetBuffer = new PacketBuffer(5000);
				var26.packetBuffer.offset = 0;
				if (gameState == 40) {
					var26.packetBuffer.writeByte(LoginPacket.field2290.id);
				} else {
					var26.packetBuffer.writeByte(LoginPacket.field2289.id);
				}

				var26.packetBuffer.writeShort(0);
				int var7 = var26.packetBuffer.offset;
				var26.packetBuffer.writeInt(183);
				var26.packetBuffer.writeInt(1);
				var26.packetBuffer.writeByte(clientType);
				var26.packetBuffer.writeBytes(var3.array, 0, var3.offset);
				int var14 = var26.packetBuffer.offset;
				var26.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
				var26.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
				var26.packetBuffer.writeShort(GraphicsDefaults.canvasWidth);
				var26.packetBuffer.writeShort(GameShell.canvasHeight);
				SequenceDefinition.method4770(var26.packetBuffer);
				var26.packetBuffer.writeStringCp1252NullTerminated(WorldMapArea.field217);
				var26.packetBuffer.writeInt(MouseRecorder.field565);
				Buffer var15 = new Buffer(class32.platformInfo.size());
				class32.platformInfo.write(var15);
				var26.packetBuffer.writeBytes(var15.array, 0, var15.array.length);
				var26.packetBuffer.writeByte(clientType);
				var26.packetBuffer.writeInt(0);
				var26.packetBuffer.writeInt(ScriptEvent.archive0.hash);
				var26.packetBuffer.writeInt(GrandExchangeOffer.archive1.hash);
				var26.packetBuffer.writeInt(class173.archive2.hash);
				var26.packetBuffer.writeInt(WorldMapData_0.archive3.hash);
				var26.packetBuffer.writeInt(class13.archive4.hash);
				var26.packetBuffer.writeInt(Timer.archive5.hash);
				var26.packetBuffer.writeInt(WorldMapDecoration.archive6.hash);
				var26.packetBuffer.writeInt(class49.archive7.hash);
				var26.packetBuffer.writeInt(WorldMapDecoration.archive8.hash);
				var26.packetBuffer.writeInt(WorldMapData_0.archive9.hash);
				var26.packetBuffer.writeInt(FontName.archive10.hash);
				var26.packetBuffer.writeInt(ArchiveDisk.archive11.hash);
				var26.packetBuffer.writeInt(Message.archive12.hash);
				var26.packetBuffer.writeInt(TextureProvider.archive13.hash);
				var26.packetBuffer.writeInt(WorldMapLabel.archive14.hash);
				var26.packetBuffer.writeInt(BufferedSource.archive15.hash);
				var26.packetBuffer.writeInt(0);
				var26.packetBuffer.writeInt(class49.archive17.hash);
				var26.packetBuffer.writeInt(WorldMapArea.archive18.hash);
				var26.packetBuffer.writeInt(UrlRequest.archive19.hash);
				var26.packetBuffer.writeInt(WorldMapSection1.archive20.hash);
				var26.packetBuffer.xteaEncrypt(var23, var14, var26.packetBuffer.offset);
				var26.packetBuffer.writeLengthShort(var26.packetBuffer.offset - var7);
				packetWriter.addNode(var26);
				packetWriter.flush();
				packetWriter.isaacCipher = new IsaacCipher(var23);
				int[] var16 = new int[4];

				for (var11 = 0; var11 < 4; ++var11) {
					var16[var11] = var23[var11] + 50;
				}

				var2.newIsaacCipher(var16);
				loginState = 6;
			}

			if (loginState == 6 && ((AbstractSocket)var1).available() > 0) {
				var28 = ((AbstractSocket)var1).readUnsignedByte();
				if (var28 == 21 && gameState == 20) {
					loginState = 9;
				} else if (var28 == 2) {
					loginState = 11;
				} else if (var28 == 15 && gameState == 40) {
					packetWriter.serverPacketLength = -1;
					loginState = 16;
				} else if (var28 == 64) {
					loginState = 7;
				} else if (var28 == 23 && field841 < 1) {
					++field841;
					loginState = 0;
				} else {
					if (var28 != 29) {
						WorldMapSprite.getLoginError(var28);
						return;
					}

					loginState = 14;
				}
			}

			if (loginState == 7 && ((AbstractSocket)var1).available() > 0) {
				class208.field2475 = ((AbstractSocket)var1).readUnsignedByte();
				loginState = 8;
			}

			if (loginState == 8 && ((AbstractSocket)var1).available() >= class208.field2475) {
				((AbstractSocket)var1).read(var2.array, 0, class208.field2475);
				var2.offset = 0;
				loginState = 6;
			}

			if (loginState == 9 && ((AbstractSocket)var1).available() > 0) {
				field821 = (((AbstractSocket)var1).readUnsignedByte() + 3) * 60;
				loginState = 10;
			}

			if (loginState == 10) {
				field656 = 0;
				Canvas.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field821 / 60 + " seconds.");
				if (--field821 <= 0) {
					loginState = 0;
				}

			} else {
				if (loginState == 11 && ((AbstractSocket)var1).available() >= 1) {
					class173.field2069 = ((AbstractSocket)var1).readUnsignedByte();
					loginState = 12;
				}

				if (loginState == 12 && ((AbstractSocket)var1).available() >= class173.field2069) {
					var12 = ((AbstractSocket)var1).readUnsignedByte() == 1;
					((AbstractSocket)var1).read(var2.array, 0, 4);
					var2.offset = 0;
					boolean var29 = false;
					if (var12) {
						var13 = var2.readByteIsaac() << 24;
						var13 |= var2.readByteIsaac() << 16;
						var13 |= var2.readByteIsaac() << 8;
						var13 |= var2.readByteIsaac();
						int var17 = WorldMapIcon_0.method195(Login.Login_username);
						if (Actor.clientPreferences.parameters.size() >= 10 && !Actor.clientPreferences.parameters.containsKey(var17)) {
							Iterator var27 = Actor.clientPreferences.parameters.entrySet().iterator();
							var27.next();
							var27.remove();
						}

						Actor.clientPreferences.parameters.put(var17, var13);
					}

					if (Login_isUsernameRemembered) {
						Actor.clientPreferences.rememberedUsername = Login.Login_username;
					} else {
						Actor.clientPreferences.rememberedUsername = null;
					}

					class296.savePreferences();
					staffModLevel = ((AbstractSocket)var1).readUnsignedByte();
					playerMod = ((AbstractSocket)var1).readUnsignedByte() == 1;
					localPlayerIndex = ((AbstractSocket)var1).readUnsignedByte();
					localPlayerIndex <<= 8;
					localPlayerIndex += ((AbstractSocket)var1).readUnsignedByte();
					field739 = ((AbstractSocket)var1).readUnsignedByte();
					((AbstractSocket)var1).read(var2.array, 0, 1);
					var2.offset = 0;
					ServerPacket[] var5 = class195.ServerPacket_values();
					int var18 = var2.readSmartByteShortIsaac();
					if (var18 < 0 || var18 >= var5.length) {
						throw new IOException(var18 + " " + var2.offset);
					}

					packetWriter.serverPacket = var5[var18];
					packetWriter.serverPacketLength = packetWriter.serverPacket.length;
					((AbstractSocket)var1).read(var2.array, 0, 2);
					var2.offset = 0;
					packetWriter.serverPacketLength = var2.readUnsignedShort();

					try {
						class47.method812(Coord.client, "zap");
					} catch (Throwable var20) {
					}

					loginState = 13;
				}

				if (loginState == 13) {
					if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
						timer.method4972();
						TilePaint.method3037();
						GraphicsObject.updatePlayer(var2);
						FloorDecoration.field1585 = -1;
						Canvas.loadRegions(false, var2);
						packetWriter.serverPacket = null;
					}

				} else {
					if (loginState == 14 && ((AbstractSocket)var1).available() >= 2) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, 2);
						var2.offset = 0;
						Decimator.field1431 = var2.readUnsignedShort();
						loginState = 15;
					}

					if (loginState == 15 && ((AbstractSocket)var1).available() >= Decimator.field1431) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, Decimator.field1431);
						var2.offset = 0;
						String var22 = var2.readStringCp1252NullTerminated();
						String var24 = var2.readStringCp1252NullTerminated();
						String var25 = var2.readStringCp1252NullTerminated();
						Canvas.setLoginResponseString(var22, var24, var25);
						WorldMapIcon_0.updateGameState(10);
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
							var28 = packetWriter.serverPacketLength;
							timer.method4982();
							Entity.method3228();
							GraphicsObject.updatePlayer(var2);
							if (var28 != var2.offset) {
								throw new RuntimeException();
							}
						}
					} else {
						++field656;
						if (field656 > 2000) {
							if (field841 < 1) {
								if (LoginPacket.port3 == WorldMapSection1.port1) {
									LoginPacket.port3 = IsaacCipher.port2;
								} else {
									LoginPacket.port3 = WorldMapSection1.port1;
								}

								++field841;
								loginState = 0;
							} else {
								WorldMapSprite.getLoginError(-3);
							}
						}
					}
				}
			}
		} catch (IOException var21) {
			if (field841 < 1) {
				if (WorldMapSection1.port1 == LoginPacket.port3) {
					LoginPacket.port3 = IsaacCipher.port2;
				} else {
					LoginPacket.port3 = WorldMapSection1.port1;
				}

				++field841;
				loginState = 0;
			} else {
				WorldMapSprite.getLoginError(-2);
			}
		}
	}

	@ObfuscatedName("ff")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	@Export("doCycleLoggedIn")
	final void doCycleLoggedIn() {
		if (rebootTimer > 1) {
			--rebootTimer;
		}

		if (logoutTimer > 0) {
			--logoutTimer;
		}

		if (field772) {
			field772 = false;
			class185.method3607();
		} else {
			if (!isMenuOpen) {
				GraphicsObject.addCancelMenuEntry();
			}

			int var1;
			for (var1 = 0; var1 < 100 && this.method1262(packetWriter); ++var1) {
			}

			if (gameState == 30) {
				while (true) {
					ReflectionCheck var2 = (ReflectionCheck)class96.reflectionChecks.last();
					boolean var30;
					if (var2 == null) {
						var30 = false;
					} else {
						var30 = true;
					}

					int var3;
					PacketBufferNode var31;
					if (!var30) {
						PacketBufferNode var14;
						int var15;
						if (timer.field3549) {
							var14 = MenuAction.getPacketBufferNode(ClientPacket.field2191, packetWriter.isaacCipher);
							var14.packetBuffer.writeByte(0);
							var15 = var14.packetBuffer.offset;
							timer.write(var14.packetBuffer);
							var14.packetBuffer.writeLengthByte(var14.packetBuffer.offset - var15);
							packetWriter.addNode(var14);
							timer.method4973();
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
						synchronized(ParamDefinition.mouseRecorder.lock) {
							if (!field859) {
								ParamDefinition.mouseRecorder.index = 0;
							} else if (MouseHandler.MouseHandler_lastButton != 0 || ParamDefinition.mouseRecorder.index >= 40) {
								var31 = null;
								var3 = 0;
								var4 = 0;
								var5 = 0;
								var6 = 0;

								for (var7 = 0; var7 < ParamDefinition.mouseRecorder.index && (var31 == null || var31.packetBuffer.offset - var3 < 246); ++var7) {
									var4 = var7;
									var8 = ParamDefinition.mouseRecorder.ys[var7];
									if (var8 < -1) {
										var8 = -1;
									} else if (var8 > 65534) {
										var8 = 65534;
									}

									var9 = ParamDefinition.mouseRecorder.xs[var7];
									if (var9 < -1) {
										var9 = -1;
									} else if (var9 > 65534) {
										var9 = 65534;
									}

									if (var9 != field635 || var8 != field667) {
										if (var31 == null) {
											var31 = MenuAction.getPacketBufferNode(ClientPacket.field2246, packetWriter.isaacCipher);
											var31.packetBuffer.writeByte(0);
											var3 = var31.packetBuffer.offset;
											PacketBuffer var10000 = var31.packetBuffer;
											var10000.offset += 2;
											var5 = 0;
											var6 = 0;
										}

										if (field637 != -1L) {
											var10 = var9 - field635;
											var11 = var8 - field667;
											var12 = (int)((ParamDefinition.mouseRecorder.millis[var7] - field637) / 20L);
											var5 = (int)((long)var5 + (ParamDefinition.mouseRecorder.millis[var7] - field637) % 20L);
										} else {
											var10 = var9;
											var11 = var8;
											var12 = Integer.MAX_VALUE;
										}

										field635 = var9;
										field667 = var8;
										if (var12 < 8 && var10 >= -32 && var10 <= 31 && var11 >= -32 && var11 <= 31) {
											var10 += 32;
											var11 += 32;
											var31.packetBuffer.writeShort((var12 << 12) + var11 + (var10 << 6));
										} else if (var12 < 32 && var10 >= -128 && var10 <= 127 && var11 >= -128 && var11 <= 127) {
											var10 += 128;
											var11 += 128;
											var31.packetBuffer.writeByte(var12 + 128);
											var31.packetBuffer.writeShort(var11 + (var10 << 8));
										} else if (var12 < 32) {
											var31.packetBuffer.writeByte(var12 + 192);
											if (var9 != -1 && var8 != -1) {
												var31.packetBuffer.writeInt(var9 | var8 << 16);
											} else {
												var31.packetBuffer.writeInt(Integer.MIN_VALUE);
											}
										} else {
											var31.packetBuffer.writeShort((var12 & 8191) + 57344);
											if (var9 != -1 && var8 != -1) {
												var31.packetBuffer.writeInt(var9 | var8 << 16);
											} else {
												var31.packetBuffer.writeInt(Integer.MIN_VALUE);
											}
										}

										++var6;
										field637 = ParamDefinition.mouseRecorder.millis[var7];
									}
								}

								if (var31 != null) {
									var31.packetBuffer.writeLengthByte(var31.packetBuffer.offset - var3);
									var7 = var31.packetBuffer.offset;
									var31.packetBuffer.offset = var3;
									var31.packetBuffer.writeByte(var5 / var6);
									var31.packetBuffer.writeByte(var5 % var6);
									var31.packetBuffer.offset = var7;
									packetWriter.addNode(var31);
								}

								if (var4 >= ParamDefinition.mouseRecorder.index) {
									ParamDefinition.mouseRecorder.index = 0;
								} else {
									MouseRecorder var46 = ParamDefinition.mouseRecorder;
									var46.index -= var4;
									System.arraycopy(ParamDefinition.mouseRecorder.xs, var4, ParamDefinition.mouseRecorder.xs, 0, ParamDefinition.mouseRecorder.index);
									System.arraycopy(ParamDefinition.mouseRecorder.ys, var4, ParamDefinition.mouseRecorder.ys, 0, ParamDefinition.mouseRecorder.index);
									System.arraycopy(ParamDefinition.mouseRecorder.millis, var4, ParamDefinition.mouseRecorder.millis, 0, ParamDefinition.mouseRecorder.index);
								}
							}
						}

						PacketBufferNode var18;
						if (MouseHandler.MouseHandler_lastButton == 1 || !WorldMapSection1.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
							long var16 = (MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis * -1L) / 50L;
							if (var16 > 4095L) {
								var16 = 4095L;
							}

							mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis * -1L;
							var3 = MouseHandler.MouseHandler_lastPressedY;
							if (var3 < 0) {
								var3 = 0;
							} else if (var3 > GameShell.canvasHeight) {
								var3 = GameShell.canvasHeight;
							}

							var4 = MouseHandler.MouseHandler_lastPressedX;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > GraphicsDefaults.canvasWidth) {
								var4 = GraphicsDefaults.canvasWidth;
							}

							var5 = (int)var16;
							var18 = MenuAction.getPacketBufferNode(ClientPacket.field2213, packetWriter.isaacCipher);
							var18.packetBuffer.writeShort((MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0) + (var5 << 1));
							var18.packetBuffer.writeShort(var4);
							var18.packetBuffer.writeShort(var3);
							packetWriter.addNode(var18);
						}

						if (KeyHandler.field380 > 0) {
							var14 = MenuAction.getPacketBufferNode(ClientPacket.field2224, packetWriter.isaacCipher);
							var14.packetBuffer.writeShort(0);
							var15 = var14.packetBuffer.offset;
							long var19 = SoundCache.method2480();

							for (var5 = 0; var5 < KeyHandler.field380; ++var5) {
								long var21 = var19 - field750;
								if (var21 > 16777215L) {
									var21 = 16777215L;
								}

								field750 = var19;
								var14.packetBuffer.writeByte(KeyHandler.field379[var5]);
								var14.packetBuffer.method5466((int)var21);
							}

							var14.packetBuffer.writeLengthShort(var14.packetBuffer.offset - var15);
							packetWriter.addNode(var14);
						}

						if (field883 > 0) {
							--field883;
						}

						if (KeyHandler.KeyHandler_pressedKeys[96] || KeyHandler.KeyHandler_pressedKeys[97] || KeyHandler.KeyHandler_pressedKeys[98] || KeyHandler.KeyHandler_pressedKeys[99]) {
							field858 = true;
						}

						if (field858 && field883 <= 0) {
							field883 = 20;
							field858 = false;
							var14 = MenuAction.getPacketBufferNode(ClientPacket.field2271, packetWriter.isaacCipher);
							var14.packetBuffer.writeIntME(camAngleY);
							var14.packetBuffer.writeShort(camAngleX);
							packetWriter.addNode(var14);
						}

						if (PendingSpawn.hasFocus && !hadFocus) {
							hadFocus = true;
							var14 = MenuAction.getPacketBufferNode(ClientPacket.field2200, packetWriter.isaacCipher);
							var14.packetBuffer.writeByte(1);
							packetWriter.addNode(var14);
						}

						if (!PendingSpawn.hasFocus && hadFocus) {
							hadFocus = false;
							var14 = MenuAction.getPacketBufferNode(ClientPacket.field2200, packetWriter.isaacCipher);
							var14.packetBuffer.writeByte(0);
							packetWriter.addNode(var14);
						}

						if (GrandExchangeOfferUnitPriceComparator.worldMap != null) {
							GrandExchangeOfferUnitPriceComparator.worldMap.method6291();
						}

						if (InterfaceParent.ClanChat_inClanChat) {
							if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
								GrandExchangeOfferUnitPriceComparator.clanChat.sort();
							}

							WorldMapCacheName.method592();
							InterfaceParent.ClanChat_inClanChat = false;
						}

						if (MouseRecorder.plane != field848) {
							field848 = MouseRecorder.plane;
							class4.method48(MouseRecorder.plane);
						}

						if (gameState != 30) {
							return;
						}

						for (PendingSpawn var37 = (PendingSpawn)pendingSpawns.last(); var37 != null; var37 = (PendingSpawn)pendingSpawns.previous()) {
							if (var37.hitpoints > 0) {
								--var37.hitpoints;
							}

							ObjectDefinition var23;
							boolean var38;
							if (var37.hitpoints == 0) {
								if (var37.objectId >= 0) {
									var3 = var37.objectId;
									var4 = var37.field903;
									var23 = WallDecoration.getObjectDefinition(var3);
									if (var4 == 11) {
										var4 = 10;
									}

									if (var4 >= 5 && var4 <= 8) {
										var4 = 4;
									}

									var38 = var23.method4599(var4);
									if (!var38) {
										continue;
									}
								}

								Message.addPendingSpawnToScene(var37.plane, var37.type, var37.x, var37.y, var37.objectId, var37.field900, var37.field903);
								var37.remove();
							} else {
								if (var37.delay > 0) {
									--var37.delay;
								}

								if (var37.delay == 0 && var37.x >= 1 && var37.y >= 1 && var37.x <= 102 && var37.y <= 102) {
									if (var37.id >= 0) {
										var3 = var37.id;
										var4 = var37.field911;
										var23 = WallDecoration.getObjectDefinition(var3);
										if (var4 == 11) {
											var4 = 10;
										}

										if (var4 >= 5 && var4 <= 8) {
											var4 = 4;
										}

										var38 = var23.method4599(var4);
										if (!var38) {
											continue;
										}
									}

									Message.addPendingSpawnToScene(var37.plane, var37.type, var37.x, var37.y, var37.id, var37.orientation, var37.field911);
									var37.delay = -1;
									if (var37.id == var37.objectId && var37.objectId == -1) {
										var37.remove();
									} else if (var37.objectId == var37.id && var37.orientation == var37.field900 && var37.field911 == var37.field903) {
										var37.remove();
									}
								}
							}
						}

						VerticalAlignment.method4329();
						++packetWriter.field1283;
						if (packetWriter.field1283 > 750) {
							class185.method3607();
							return;
						}

						class1.method14();

						for (var1 = 0; var1 < npcCount; ++var1) {
							var15 = npcIndices[var1];
							NPC var24 = npcs[var15];
							if (var24 != null) {
								Tile.calculateActorPosition(var24, var24.definition.size);
							}
						}

						ServerPacket.processOverheadText();
						++field683;
						if (mouseCrossColor != 0) {
							mouseCrossState = mouseCrossState * 400 + 20;
							if (mouseCrossState * 400 >= 400) {
								mouseCrossColor = 0;
							}
						}

						if (Entity.field1835 != null) {
							++field727;
							if (field727 >= 15) {
								WorldMapID.invalidateWidget(Entity.field1835);
								Entity.field1835 = null;
							}
						}

						Widget var39 = class32.mousedOverWidgetIf1;
						Widget var32 = AbstractWorldMapIcon.field292;
						class32.mousedOverWidgetIf1 = null;
						AbstractWorldMapIcon.field292 = null;
						draggedOnWidget = null;
						field803 = false;
						field800 = false;
						field844 = 0;

						while (AbstractUserComparator.isKeyDown() && field844 < 128) {
							if (staffModLevel >= 2 && KeyHandler.KeyHandler_pressedKeys[82] && class43.field361 == 66) {
								String var41 = class14.method145();
								Coord.client.clipboardSetString(var41);
							} else if (oculusOrbState != 1 || WorldMapIcon_0.field126 <= 0) {
								field846[field844] = class43.field361;
								field845[field844] = WorldMapIcon_0.field126;
								++field844;
							}
						}

						if (SecureRandomCallable.method1092() && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81] && mouseWheelRotation != 0) {
							var3 = Varps.localPlayer.plane - mouseWheelRotation;
							if (var3 < 0) {
								var3 = 0;
							} else if (var3 > 3) {
								var3 = 3;
							}

							if (var3 != Varps.localPlayer.plane) {
								var4 = Varps.localPlayer.pathX[0] + class4.baseX * 64;
								var5 = Varps.localPlayer.pathY[0] + ScriptEvent.baseY;
								var18 = MenuAction.getPacketBufferNode(ClientPacket.field2187, packetWriter.isaacCipher);
								var18.packetBuffer.method5500(var4);
								var18.packetBuffer.writeShort(var5);
								var18.packetBuffer.method5491(var3);
								var18.packetBuffer.writeIntLE16(0);
								packetWriter.addNode(var18);
							}

							mouseWheelRotation = 0;
						}

						if (rootInterface != -1) {
							TextureProvider.updateRootInterface(rootInterface, 0, 0, GraphicsDefaults.canvasWidth, GameShell.canvasHeight, 0, 0);
						}

						++cycleCntr;

						while (true) {
							Widget var25;
							Widget var40;
							ScriptEvent var42;
							do {
								var42 = (ScriptEvent)field822.removeLast();
								if (var42 == null) {
									while (true) {
										do {
											var42 = (ScriptEvent)field823.removeLast();
											if (var42 == null) {
												while (true) {
													do {
														var42 = (ScriptEvent)scriptEvents.removeLast();
														if (var42 == null) {
															this.method1263();
															AbstractByteArrayCopier.method3922();
															if (clickedWidget != null) {
																this.method1268();
															}

															PacketBufferNode var26;
															if (class4.dragInventoryWidget != null) {
																WorldMapID.invalidateWidget(class4.dragInventoryWidget);
																++itemDragDuration;
																if (MouseHandler.MouseHandler_currentButton == 0) {
																	if (field733) {
																		if (class4.dragInventoryWidget == World.field996 && dragItemSlotDestination != dragItemSlotSource) {
																			Widget var45 = class4.dragInventoryWidget;
																			byte var35 = 0;
																			if (field787 == 1 && var45.contentType == 206) {
																				var35 = 1;
																			}

																			if (var45.itemIds[dragItemSlotDestination] <= 0) {
																				var35 = 0;
																			}

																			var6 = class60.getWidgetClickMask(var45);
																			boolean var33 = (var6 >> 29 & 1) != 0;
																			if (var33) {
																				var7 = dragItemSlotSource;
																				var8 = dragItemSlotDestination;
																				var45.itemIds[var8] = var45.itemIds[var7];
																				var45.itemQuantities[var8] = var45.itemQuantities[var7];
																				var45.itemIds[var7] = -1;
																				var45.itemQuantities[var7] = 0;
																			} else if (var35 == 1) {
																				var7 = dragItemSlotSource;
																				var8 = dragItemSlotDestination;

																				while (var8 != var7) {
																					if (var7 > var8) {
																						var45.swapItems(var7 - 1, var7);
																						--var7;
																					} else if (var7 < var8) {
																						var45.swapItems(var7 + 1, var7);
																						++var7;
																					}
																				}
																			} else {
																				var45.swapItems(dragItemSlotDestination, dragItemSlotSource);
																			}

																			var26 = MenuAction.getPacketBufferNode(ClientPacket.field2267, packetWriter.isaacCipher);
																			var26.packetBuffer.writeIntLE16(class4.dragInventoryWidget.id);
																			var26.packetBuffer.writeIntME(dragItemSlotDestination);
																			var26.packetBuffer.method5493(var35);
																			var26.packetBuffer.writeIntME(dragItemSlotSource);
																			packetWriter.addNode(var26);
																		}
																	} else if (this.shouldLeftClickOpenMenu()) {
																		this.openMenu(field730, field870);
																	} else if (menuOptionsCount > 0) {
																		var3 = field730;
																		var4 = field870;
																		MenuAction var43 = SoundCache.tempMenuAction;
																		EnumDefinition.menuAction(var43.argument1, var43.argument2, var43.opcode, var43.argument0, var43.action, var43.action, var3, var4);
																		SoundCache.tempMenuAction = null;
																	}

																	field727 = 10;
																	MouseHandler.MouseHandler_lastButton = 0;
																	class4.dragInventoryWidget = null;
																} else if (itemDragDuration >= 5 && (MouseHandler.MouseHandler_x > field730 + 5 || MouseHandler.MouseHandler_x < field730 - 5 || MouseHandler.MouseHandler_y > field870 + 5 || MouseHandler.MouseHandler_y < field870 - 5)) {
																	field733 = true;
																}
															}

															if (Scene.method3080()) {
																var3 = Scene.Scene_selectedX;
																var4 = Scene.Scene_selectedY;
																PacketBufferNode var44 = MenuAction.getPacketBufferNode(ClientPacket.field2184, packetWriter.isaacCipher);
																var44.packetBuffer.writeByte(5);
																var44.packetBuffer.method5491(KeyHandler.KeyHandler_pressedKeys[82] ? (KeyHandler.KeyHandler_pressedKeys[81] ? 2 : 1) : 0);
																var44.packetBuffer.writeShort(var4 + ScriptEvent.baseY);
																var44.packetBuffer.writeShort(class4.baseX * 64 + var3);
																packetWriter.addNode(var44);
																Scene.method3117();
																mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
																mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
																mouseCrossColor = 1;
																mouseCrossState = 0;
																destinationX = var3;
																destinationY = var4;
															}

															if (var39 != class32.mousedOverWidgetIf1) {
																if (var39 != null) {
																	WorldMapID.invalidateWidget(var39);
																}

																if (class32.mousedOverWidgetIf1 != null) {
																	WorldMapID.invalidateWidget(class32.mousedOverWidgetIf1);
																}
															}

															if (var32 != AbstractWorldMapIcon.field292 && field738 == field773) {
																if (var32 != null) {
																	WorldMapID.invalidateWidget(var32);
																}

																if (AbstractWorldMapIcon.field292 != null) {
																	WorldMapID.invalidateWidget(AbstractWorldMapIcon.field292);
																}
															}

															if (AbstractWorldMapIcon.field292 != null) {
																if (field773 < field738) {
																	++field773;
																	if (field773 == field738) {
																		WorldMapID.invalidateWidget(AbstractWorldMapIcon.field292);
																	}
																}
															} else if (field773 > 0) {
																--field773;
															}

															if (oculusOrbState == 0) {
																var3 = Varps.localPlayer.x * -78439701;
																var4 = Varps.localPlayer.y;
																if (SecureRandomFuture.oculusOrbFocalPointX - var3 < -500 || SecureRandomFuture.oculusOrbFocalPointX - var3 > 500 || AbstractByteArrayCopier.oculusOrbFocalPointY - var4 < -500 || AbstractByteArrayCopier.oculusOrbFocalPointY - var4 > 500) {
																	SecureRandomFuture.oculusOrbFocalPointX = var3;
																	AbstractByteArrayCopier.oculusOrbFocalPointY = var4;
																}

																if (var3 != SecureRandomFuture.oculusOrbFocalPointX) {
																	SecureRandomFuture.oculusOrbFocalPointX += (var3 - SecureRandomFuture.oculusOrbFocalPointX) / 16;
																}

																if (var4 != AbstractByteArrayCopier.oculusOrbFocalPointY) {
																	AbstractByteArrayCopier.oculusOrbFocalPointY += (var4 - AbstractByteArrayCopier.oculusOrbFocalPointY) / 16;
																}

																var5 = SecureRandomFuture.oculusOrbFocalPointX >> 7;
																var6 = AbstractByteArrayCopier.oculusOrbFocalPointY >> 7;
																var7 = WorldMapAreaData.getTileHeight(SecureRandomFuture.oculusOrbFocalPointX, AbstractByteArrayCopier.oculusOrbFocalPointY, MouseRecorder.plane);
																var8 = 0;
																if (var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
																	for (var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
																		for (var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
																			var11 = MouseRecorder.plane;
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

																if (var9 > field707) {
																	field707 += (var9 - field707) / 24;
																} else if (var9 < field707) {
																	field707 += (var9 - field707) / 80;
																}

																class65.field580 = (WorldMapAreaData.getTileHeight(Varps.localPlayer.x * -78439701, Varps.localPlayer.y, MouseRecorder.plane) - 172735687 * camFollowHeight) * -59362433;
															} else if (oculusOrbState == 1) {
																class268.method4967();
																short var34 = -1;
																if (KeyHandler.KeyHandler_pressedKeys[33]) {
																	var34 = 0;
																} else if (KeyHandler.KeyHandler_pressedKeys[49]) {
																	var34 = 1024;
																}

																if (KeyHandler.KeyHandler_pressedKeys[48]) {
																	if (var34 == 0) {
																		var34 = 1792;
																	} else if (var34 == 1024) {
																		var34 = 1280;
																	} else {
																		var34 = 1536;
																	}
																} else if (KeyHandler.KeyHandler_pressedKeys[50]) {
																	if (var34 == 0) {
																		var34 = 256;
																	} else if (var34 == 1024) {
																		var34 = 768;
																	} else {
																		var34 = 512;
																	}
																}

																byte var36 = 0;
																if (KeyHandler.KeyHandler_pressedKeys[35]) {
																	var36 = -1;
																} else if (KeyHandler.KeyHandler_pressedKeys[51]) {
																	var36 = 1;
																}

																var5 = 0;
																if (var34 >= 0 || var36 != 0) {
																	var5 = KeyHandler.KeyHandler_pressedKeys[81] ? oculusOrbSlowedSpeed : oculusOrbNormalSpeed;
																	var5 *= 16;
																	field802 = var34;
																	field700 = var36;
																}

																if (field698 < var5) {
																	field698 += var5 / 8;
																	if (field698 > var5) {
																		field698 = var5;
																	}
																} else if (field698 > var5) {
																	field698 = field698 * 9 / 10;
																}

																if (field698 > 0) {
																	var6 = field698 / 16;
																	if (field802 >= 0) {
																		var3 = field802 - Tile.cameraYaw & 2047;
																		var7 = Rasterizer3D.Rasterizer3D_sine[var3];
																		var8 = Rasterizer3D.Rasterizer3D_cosine[var3];
																		SecureRandomFuture.oculusOrbFocalPointX += var6 * var7 / 65536;
																		AbstractByteArrayCopier.oculusOrbFocalPointY += var6 * var8 / 65536;
																	}

																	if (field700 != 0) {
																		class65.field580 += var6 * field700 * -59362433;
																		if (class65.field580 * 1615694975 > 0) {
																			class65.field580 = 0;
																		}
																	}
																} else {
																	field802 = -1;
																	field700 = -1;
																}

																if (KeyHandler.KeyHandler_pressedKeys[13]) {
																	UserComparator6.method3417();
																}
															}

															if (MouseHandler.MouseHandler_currentButton == 4 && WorldMapSection1.mouseCam) {
																var3 = MouseHandler.MouseHandler_y - mouseCamClickedY;
																camAngleDX = var3 * 2;
																mouseCamClickedY = var3 != -1 && var3 != 1 ? (MouseHandler.MouseHandler_y + mouseCamClickedY) / 2 : MouseHandler.MouseHandler_y;
																var4 = mouseCamClickedX - MouseHandler.MouseHandler_x;
																camAngleDY = var4 * 2;
																mouseCamClickedX = var4 != -1 && var4 != 1 ? (mouseCamClickedX + MouseHandler.MouseHandler_x) / 2 : MouseHandler.MouseHandler_x;
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
																var3 = MilliClock.field1990 * 128 + 64;
																var4 = FriendSystem.field1037 * 16384 + 64;
																var5 = WorldMapAreaData.getTileHeight(var3, var4, MouseRecorder.plane) - FileSystem.field2027;
																if (ScriptFrame.cameraX < var3) {
																	ScriptFrame.cameraX = (var3 - ScriptFrame.cameraX) * WorldMapArea.field211 / 1000 + ScriptFrame.cameraX + WorldMapCacheName.field301;
																	if (ScriptFrame.cameraX > var3) {
																		ScriptFrame.cameraX = var3;
																	}
																}

																if (ScriptFrame.cameraX > var3) {
																	ScriptFrame.cameraX -= WorldMapArea.field211 * (ScriptFrame.cameraX - var3) / 1000 + WorldMapCacheName.field301;
																	if (ScriptFrame.cameraX < var3) {
																		ScriptFrame.cameraX = var3;
																	}
																}

																if (GrandExchangeOfferTotalQuantityComparator.cameraY < var5) {
																	GrandExchangeOfferTotalQuantityComparator.cameraY = (var5 - GrandExchangeOfferTotalQuantityComparator.cameraY) * WorldMapArea.field211 / 1000 + GrandExchangeOfferTotalQuantityComparator.cameraY + WorldMapCacheName.field301;
																	if (GrandExchangeOfferTotalQuantityComparator.cameraY > var5) {
																		GrandExchangeOfferTotalQuantityComparator.cameraY = var5;
																	}
																}

																if (GrandExchangeOfferTotalQuantityComparator.cameraY > var5) {
																	GrandExchangeOfferTotalQuantityComparator.cameraY -= WorldMapArea.field211 * (GrandExchangeOfferTotalQuantityComparator.cameraY - var5) / 1000 + WorldMapCacheName.field301;
																	if (GrandExchangeOfferTotalQuantityComparator.cameraY < var5) {
																		GrandExchangeOfferTotalQuantityComparator.cameraY = var5;
																	}
																}

																if (class14.cameraZ < var4) {
																	class14.cameraZ = (var4 - class14.cameraZ) * WorldMapArea.field211 / 1000 + class14.cameraZ + WorldMapCacheName.field301;
																	if (class14.cameraZ > var4) {
																		class14.cameraZ = var4;
																	}
																}

																if (class14.cameraZ > var4) {
																	class14.cameraZ -= WorldMapArea.field211 * (class14.cameraZ - var4) / 1000 + WorldMapCacheName.field301;
																	if (class14.cameraZ < var4) {
																		class14.cameraZ = var4;
																	}
																}

																var3 = class40.field334 * 16384 + 64;
																var4 = SecureRandomCallable.field499 * 16384 + 64;
																var5 = WorldMapAreaData.getTileHeight(var3, var4, MouseRecorder.plane) - Varcs.field1242;
																var6 = var3 - ScriptFrame.cameraX;
																var7 = var5 - GrandExchangeOfferTotalQuantityComparator.cameraY;
																var8 = var4 - class14.cameraZ;
																var9 = (int)Math.sqrt((double)(var8 * var8 + var6 * var6));
																var10 = (int)(Math.atan2((double)var7, (double)var9) * 325.949D) & 2047;
																var11 = (int)(Math.atan2((double)var6, (double)var8) * -325.949D) & 2047;
																if (var10 < 128) {
																	var10 = 128;
																}

																if (var10 > 383) {
																	var10 = 383;
																}

																if (class319.cameraPitch < var10) {
																	class319.cameraPitch = (var10 - class319.cameraPitch) * WorldMapSection1.field285 / 1000 + class319.cameraPitch + class65.field581;
																	if (class319.cameraPitch > var10) {
																		class319.cameraPitch = var10;
																	}
																}

																if (class319.cameraPitch > var10) {
																	class319.cameraPitch -= WorldMapSection1.field285 * (class319.cameraPitch - var10) / 1000 + class65.field581;
																	if (class319.cameraPitch < var10) {
																		class319.cameraPitch = var10;
																	}
																}

																var12 = var11 - Tile.cameraYaw;
																if (var12 > 1024) {
																	var12 -= 2048;
																}

																if (var12 < -1024) {
																	var12 += 2048;
																}

																if (var12 > 0) {
																	Tile.cameraYaw = var12 * WorldMapSection1.field285 / 1000 + Tile.cameraYaw + class65.field581;
																	Tile.cameraYaw &= 2047;
																}

																if (var12 < 0) {
																	Tile.cameraYaw -= class65.field581 + -var12 * WorldMapSection1.field285 / 1000;
																	Tile.cameraYaw &= 2047;
																}

																int var27 = var11 - Tile.cameraYaw;
																if (var27 > 1024) {
																	var27 -= 2048;
																}

																if (var27 < -1024) {
																	var27 += 2048;
																}

																if (var27 < 0 && var12 > 0 || var27 > 0 && var12 < 0) {
																	Tile.cameraYaw = var11;
																}
															}

															for (var3 = 0; var3 < 5; ++var3) {
																int var10002 = field799[var3]++;
															}

															BoundaryObject.varcs.tryWrite();
															var3 = ++MouseHandler.MouseHandler_idleCycles - 1;
															var5 = KeyHandler.KeyHandler_idleCycles;
															if (var3 > 15000 && var5 > 15000) {
																logoutTimer = 250;
																MouseHandler.MouseHandler_idleCycles = 14500;
																var26 = MenuAction.getPacketBufferNode(ClientPacket.field2265, packetWriter.isaacCipher);
																packetWriter.addNode(var26);
															}

															class218.friendSystem.processFriendUpdates();
															++packetWriter.pendingWrites;
															if (packetWriter.pendingWrites > 50) {
																var26 = MenuAction.getPacketBufferNode(ClientPacket.field2185, packetWriter.isaacCipher);
																packetWriter.addNode(var26);
															}

															try {
																packetWriter.flush();
															} catch (IOException var28) {
																class185.method3607();
															}

															return;
														}

														var25 = var42.widget;
														if (var25.childIndex < 0) {
															break;
														}

														var40 = Player.getWidget(var25.parentId);
													} while(var40 == null || var40.children == null || var25.childIndex >= var40.children.length || var25 != var40.children[var25.childIndex]);

													SecureRandomFuture.runScriptEvent(var42);
												}
											}

											var25 = var42.widget;
											if (var25.childIndex < 0) {
												break;
											}

											var40 = Player.getWidget(var25.parentId);
										} while(var40 == null || var40.children == null || var25.childIndex >= var40.children.length || var25 != var40.children[var25.childIndex]);

										SecureRandomFuture.runScriptEvent(var42);
									}
								}

								var25 = var42.widget;
								if (var25.childIndex < 0) {
									break;
								}

								var40 = Player.getWidget(var25.parentId);
							} while(var40 == null || var40.children == null || var25.childIndex >= var40.children.length || var25 != var40.children[var25.childIndex]);

							SecureRandomFuture.runScriptEvent(var42);
						}
					}

					var31 = MenuAction.getPacketBufferNode(ClientPacket.field2272, packetWriter.isaacCipher);
					var31.packetBuffer.writeByte(0);
					var3 = var31.packetBuffer.offset;
					WorldMapSection0.performReflectionCheck(var31.packetBuffer);
					var31.packetBuffer.writeLengthByte(var31.packetBuffer.offset - var3);
					packetWriter.addNode(var31);
				}
			}
		}
	}

	@ObfuscatedName("fg")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-99"
	)
	@Export("resizeJS")
	void resizeJS() {
		int var1 = GraphicsDefaults.canvasWidth;
		int var2 = GameShell.canvasHeight;
		if (super.contentWidth < var1) {
			var1 = super.contentWidth;
		}

		if (super.contentHeight < var2) {
			var2 = super.contentHeight;
		}

		if (Actor.clientPreferences != null) {
			try {
				Client var3 = Coord.client;
				Object[] var4 = new Object[]{class43.getWindowedMode()};
				JSObject.getWindow(var3).call("resize", var4);
			} catch (Throwable var5) {
			}
		}

	}

	@ObfuscatedName("fx")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1715199182"
	)
	@Export("drawLoggedIn")
	final void drawLoggedIn() {
		int var1;
		if (rootInterface != -1) {
			var1 = rootInterface;
			if (TaskHandler.loadInterface(var1)) {
				WorldMapDecoration.drawModelComponents(class289.Widget_interfaceComponents[var1], -1);
			}
		}

		for (var1 = 0; var1 < rootWidgetCount; ++var1) {
			if (field827[var1]) {
				field828[var1] = true;
			}

			field647[var1] = field827[var1];
			field827[var1] = false;
		}

		field826 = cycle;
		viewportX = -1;
		viewportY = -1;
		World.field996 = null;
		if (rootInterface != -1) {
			rootWidgetCount = 0;
			AbstractWorldMapIcon.drawWidgets(rootInterface, 0, 0, GraphicsDefaults.canvasWidth, GameShell.canvasHeight, 0, 0, -1);
		}

		Rasterizer2D.Rasterizer2D_resetClip();
		if (showMouseCross) {
			if (mouseCrossColor == 1) {
				class270.crossSprites[mouseCrossState * 400 / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}

			if (mouseCrossColor == 2) {
				class270.crossSprites[mouseCrossState * 400 / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}
		}

		if (!isMenuOpen) {
			if (viewportX != -1) {
				WorldMapData_0.method160(viewportX, viewportY);
			}
		} else {
			WorldMapLabelSize.method173();
		}

		if (gameDrawingMode == 3) {
			for (var1 = 0; var1 < rootWidgetCount; ++var1) {
				if (field647[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
				} else if (field828[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
				}
			}
		}

		WorldMapID.method521(MouseRecorder.plane, Varps.localPlayer.x * -78439701, Varps.localPlayer.y, field683);
		field683 = 0;
	}

	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		signature = "(Lcx;I)Z",
		garbageValue = "1403409540"
	)
	final boolean method1262(PacketWriter var1) {
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
					if (var1.field1281) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 0, 1);
						var1.field1283 = 0;
						var1.field1281 = false;
					}

					var3.offset = 0;
					if (var3.method5417()) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 1, 1);
						var1.field1283 = 0;
					}

					var1.field1281 = true;
					ServerPacket[] var4 = class195.ServerPacket_values();
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
				var1.field1283 = 0;
				timer.method4969();
				var1.field1287 = var1.field1286;
				var1.field1286 = var1.field1274;
				var1.field1274 = var1.serverPacket;
				if (ServerPacket.field2172 == var1.serverPacket) {
					class192.privateChatMode = GameObject.method3263(var3.readUnsignedByte());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2104 == var1.serverPacket) {
					Canvas.method815(class185.field2297);
					var1.serverPacket = null;
					return true;
				}

				int var48;
				if (ServerPacket.field2100 == var1.serverPacket) {
					WorldMapSection1.field286 = var3.method5547();
					ArchiveLoader.field508 = var3.readUnsignedByteNegate();

					for (var48 = WorldMapSection1.field286; var48 < WorldMapSection1.field286 + 8; ++var48) {
						for (var5 = ArchiveLoader.field508; var5 < ArchiveLoader.field508 + 8; ++var5) {
							if (groundItems[MouseRecorder.plane][var48][var5] != null) {
								groundItems[MouseRecorder.plane][var48][var5] = null;
								WorldMapCacheName.updateItemPile(var48, var5);
							}
						}
					}

					for (PendingSpawn var40 = (PendingSpawn)pendingSpawns.last(); var40 != null; var40 = (PendingSpawn)pendingSpawns.previous()) {
						if (var40.x >= WorldMapSection1.field286 && var40.x < WorldMapSection1.field286 + 8 && var40.y >= ArchiveLoader.field508 && var40.y < ArchiveLoader.field508 + 8 && var40.plane == MouseRecorder.plane) {
							var40.hitpoints = 0;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2113 == var1.serverPacket) {
					rebootTimer = var3.method5514() * 30;
					field670 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2109 == var1.serverPacket) {
					var48 = var3.method5494();
					var17 = var3.readStringCp1252NullTerminated();
					var6 = var3.readUnsignedByteNegate();
					if (var48 >= 1 && var48 <= 8) {
						if (var17.equalsIgnoreCase("null")) {
							var17 = null;
						}

						playerMenuActions[var48 - 1] = var17;
						playerOptionsPriorities[var48 - 1] = var6 == 0;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2168 == var1.serverPacket) {
					Canvas.method815(class185.field2303);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2150 == var1.serverPacket) {
					var48 = var3.readUnsignedByte();
					if (var3.readUnsignedByte() == 0) {
						grandExchangeOffers[var48] = new GrandExchangeOffer();
						var3.offset += 18;
					} else {
						--var3.offset;
						grandExchangeOffers[var48] = new GrandExchangeOffer(var3, false);
					}

					field866 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				Widget var49;
				if (ServerPacket.field2162 == var1.serverPacket) {
					var48 = var3.method5515();
					var49 = Player.getWidget(var48);
					var49.modelType = 3;
					var49.modelId = Varps.localPlayer.appearance.getChatHeadId();
					WorldMapID.invalidateWidget(var49);
					var1.serverPacket = null;
					return true;
				}

				InterfaceParent var42;
				if (ServerPacket.field2106 == var1.serverPacket) {
					var48 = var3.readUnsignedByte();
					var5 = var3.method5503();
					var6 = var3.method5587();
					var42 = (InterfaceParent)interfaceParents.get((long)var6);
					if (var42 != null) {
						StructDefinition.closeInterface(var42, var5 != var42.group);
					}

					GraphicsDefaults.method5875(var6, var5, var48);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2134 == var1.serverPacket) {
					Canvas.method815(class185.field2301);
					var1.serverPacket = null;
					return true;
				}

				String var57;
				if (ServerPacket.field2163 == var1.serverPacket) {
					var48 = var3.readUShortSmart();
					boolean var47 = var3.readUnsignedByte() == 1;
					var57 = "";
					boolean var58 = false;
					if (var47) {
						var57 = var3.readStringCp1252NullTerminated();
						if (class218.friendSystem.isIgnored(new Username(var57, class4.loginType))) {
							var58 = true;
						}
					}

					String var44 = var3.readStringCp1252NullTerminated();
					if (!var58) {
						WorldMapCacheName.addGameMessage(var48, var57, var44);
					}

					var1.serverPacket = null;
					return true;
				}

				int var19;
				if (ServerPacket.field2130 == var1.serverPacket) {
					var48 = var3.readUnsignedByte();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedByte();
					var19 = var3.readUnsignedByte();
					field749[var48] = true;
					field779[var48] = var5;
					field887[var48] = var6;
					field871[var48] = var19;
					field799[var48] = 0;
					var1.serverPacket = null;
					return true;
				}

				Widget var18;
				if (ServerPacket.field2122 == var1.serverPacket) {
					var48 = var3.readInt();
					var17 = var3.readStringCp1252NullTerminated();
					var18 = Player.getWidget(var48);
					if (!var17.equals(var18.text)) {
						var18.text = var17;
						WorldMapID.invalidateWidget(var18);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2178 == var1.serverPacket) {
					WorldMapRectangle.method257();
					weight = var3.readShort();
					field670 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2153 == var1.serverPacket) {
					World var39 = new World();
					var39.host = var3.readStringCp1252NullTerminated();
					var39.id = var3.readUnsignedShort();
					var5 = var3.readInt();
					var39.properties = var5;
					WorldMapIcon_0.updateGameState(45);
					var2.close();
					var2 = null;
					ReflectionCheck.changeWorld(var39);
					var1.serverPacket = null;
					return false;
				}

				int var9;
				int var20;
				if (ServerPacket.field2180 == var1.serverPacket) {
					var48 = var3.method5515();
					var5 = var3.readUnsignedShort();
					var6 = var5 >> 10 & 31;
					var19 = var5 >> 5 & 31;
					var20 = var5 & 31;
					var9 = (var19 << 11) + (var6 << 19) + (var20 << 3);
					Widget var45 = Player.getWidget(var48);
					if (var9 != var45.color) {
						var45.color = var9;
						WorldMapID.invalidateWidget(var45);
					}

					var1.serverPacket = null;
					return true;
				}

				boolean var16;
				if (ServerPacket.field2179 == var1.serverPacket) {
					var16 = var3.method5547() == 1;
					var5 = var3.method5580();
					var18 = Player.getWidget(var5);
					if (var16 != var18.isHidden) {
						var18.isHidden = var16;
						WorldMapID.invalidateWidget(var18);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2152 == var1.serverPacket) {
					var48 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedShort();
					class192.queueSoundEffect(var48, var5, var6);
					var1.serverPacket = null;
					return true;
				}

				long var12;
				int var21;
				if (ServerPacket.field2099 == var1.serverPacket) {
					var48 = var3.offset + var1.serverPacketLength;
					var5 = var3.readUnsignedShort();
					var6 = var3.readUnsignedShort();
					if (var5 != rootInterface) {
						rootInterface = var5;
						this.resizeRoot(false);
						DevicePcmPlayerProvider.Widget_resetModelFrames(rootInterface);
						Tile.runWidgetOnLoadListener(rootInterface);

						for (var19 = 0; var19 < 100; ++var19) {
							field827[var19] = true;
						}
					}

					InterfaceParent var10;
					for (; var6-- > 0; var10.field538 = true) {
						var19 = var3.readInt();
						var20 = var3.readUnsignedShort();
						var9 = var3.readUnsignedByte();
						var10 = (InterfaceParent)interfaceParents.get((long)var19);
						if (var10 != null && var20 != var10.group) {
							StructDefinition.closeInterface(var10, true);
							var10 = null;
						}

						if (var10 == null) {
							var10 = GraphicsDefaults.method5875(var19, var20, var9);
						}
					}

					for (var42 = (InterfaceParent)interfaceParents.first(); var42 != null; var42 = (InterfaceParent)interfaceParents.next()) {
						if (var42.field538) {
							var42.field538 = false;
						} else {
							StructDefinition.closeInterface(var42, true);
						}
					}

					widgetClickMasks = new NodeHashTable(512);

					while (var3.offset < var48) {
						var19 = var3.readInt();
						var20 = var3.readUnsignedShort();
						var9 = var3.readUnsignedShort();
						var21 = var3.readInt();

						for (int var11 = var20; var11 <= var9; ++var11) {
							var12 = ((long)var19 << 32) + (long)var11;
							widgetClickMasks.put(new IntegerNode(var21), var12);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2160 == var1.serverPacket) {
					publicChatMode = var3.readUnsignedByte();
					tradeChatMode = var3.method5494();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2123 == var1.serverPacket) {
					WorldMapElement.updateNpcs(false, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2096 == var1.serverPacket) {
					Canvas.method815(class185.field2299);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2171 == var1.serverPacket) {
					minimapState = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2120 == var1.serverPacket) {
					ArchiveLoader.field508 = var3.method5494();
					WorldMapSection1.field286 = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2121 == var1.serverPacket) {
					Canvas.method815(class185.field2298);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2129 == var1.serverPacket) {
					var48 = var3.readInt();
					InterfaceParent var54 = (InterfaceParent)interfaceParents.get((long)var48);
					if (var54 != null) {
						StructDefinition.closeInterface(var54, true);
					}

					if (meslayerContinueWidget != null) {
						WorldMapID.invalidateWidget(meslayerContinueWidget);
						meslayerContinueWidget = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2127 == var1.serverPacket) {
					var48 = var3.method5459();
					var5 = var3.method5580();
					Varps.Varps_temp[var48] = var5;
					if (Varps.Varps_main[var48] != var5) {
						Varps.Varps_main[var48] = var5;
					}

					Players.method2123(var48);
					field808[++field809 - 1 & 31] = var48;
					var1.serverPacket = null;
					return true;
				}

				Widget var7;
				if (ServerPacket.field2158 == var1.serverPacket) {
					var48 = var3.method5515();
					var5 = var3.readShort();
					var6 = var3.method5506();
					var7 = Player.getWidget(var48);
					if (var5 != var7.rawX || var6 != var7.rawY || var7.xAlignment != 0 || var7.yAlignment != 0) {
						var7.rawX = var5;
						var7.rawY = var6;
						var7.xAlignment = 0;
						var7.yAlignment = 0;
						WorldMapID.invalidateWidget(var7);
						this.alignWidget(var7);
						if (var7.type == 0) {
							class197.revalidateWidgetScroll(class289.Widget_interfaceComponents[var48 >> 16], var7, false);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2155 == var1.serverPacket) {
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

				if (ServerPacket.field2157 == var1.serverPacket) {
					var48 = var3.method5503();
					if (var48 == 65535) {
						var48 = -1;
					}

					WorldMapData_1.playSong(var48);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2169 == var1.serverPacket) {
					var48 = var3.method5459();
					if (var48 == 65535) {
						var48 = -1;
					}

					var5 = var3.method5508();
					SecureRandomCallable.playSoundJingle(var48, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2118 == var1.serverPacket) {
					var48 = var3.readInt();
					var5 = var3.method5580();
					var6 = var3.method5503();
					if (var6 == 65535) {
						var6 = -1;
					}

					var7 = Player.getWidget(var48);
					ItemDefinition var43;
					if (!var7.isIf3) {
						if (var6 == -1) {
							var7.modelType = 0;
							var1.serverPacket = null;
							return true;
						}

						var43 = Player.ItemDefinition_get(var6);
						var7.modelType = 4;
						var7.modelId = var6;
						var7.modelAngleX = var43.xan2d;
						var7.modelAngleY = var43.yan2d;
						var7.modelZoom = var43.zoom2d * 100 / var5;
						WorldMapID.invalidateWidget(var7);
					} else {
						var7.itemId = var6;
						var7.itemQuantity = var5;
						var43 = Player.ItemDefinition_get(var6);
						var7.modelAngleX = var43.xan2d;
						var7.modelAngleY = var43.yan2d;
						var7.modelAngleZ = var43.zan2d;
						var7.modelOffsetX = var43.offsetX2d;
						var7.modelOffsetY = var43.offsetY2d;
						var7.modelZoom = var43.zoom2d;
						if (var43.isStackable == 1) {
							var7.itemQuantityMode = 1;
						} else {
							var7.itemQuantityMode = 2;
						}

						if (var7.field2582 > 0) {
							var7.modelZoom = var7.modelZoom * 32 / var7.field2582;
						} else if (var7.rawWidth > 0) {
							var7.modelZoom = var7.modelZoom * 32 / var7.rawWidth;
						}

						WorldMapID.invalidateWidget(var7);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2161 == var1.serverPacket) {
					var3.offset += 28;
					if (var3.checkCrc()) {
						class195.method3664(var3, var3.offset - 28);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2140 == var1.serverPacket) {
					var48 = var3.method5515();
					var5 = var3.method5584();
					var18 = Player.getWidget(var48);
					if (var5 != var18.sequenceId || var5 == -1) {
						var18.sequenceId = var5;
						var18.modelFrame = 0;
						var18.modelFrameCycle = 0;
						WorldMapID.invalidateWidget(var18);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2132 == var1.serverPacket) {
					WorldMapData_1.readReflectionCheck(var3, var1.serverPacketLength);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2156 == var1.serverPacket) {
					byte[] var38 = new byte[var1.serverPacketLength];
					var3.method5419(var38, 0, var38.length);
					Buffer var53 = new Buffer(var38);
					var57 = var53.readStringCp1252NullTerminated();
					WorldMapIcon_0.openURL(var57, true, false);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2126 == var1.serverPacket) {
					Canvas.method815(class185.field2304);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2115 == var1.serverPacket) {
					class40.method736();
					var1.serverPacket = null;
					return false;
				}

				Widget var8;
				if (ServerPacket.field2119 == var1.serverPacket) {
					var48 = var3.readInt();
					var5 = var3.method5587();
					InterfaceParent var56 = (InterfaceParent)interfaceParents.get((long)var5);
					var42 = (InterfaceParent)interfaceParents.get((long)var48);
					if (var42 != null) {
						StructDefinition.closeInterface(var42, var56 == null || var56.group != var42.group);
					}

					if (var56 != null) {
						var56.remove();
						interfaceParents.put(var56, (long)var48);
					}

					var8 = Player.getWidget(var5);
					if (var8 != null) {
						WorldMapID.invalidateWidget(var8);
					}

					var8 = Player.getWidget(var48);
					if (var8 != null) {
						WorldMapID.invalidateWidget(var8);
						class197.revalidateWidgetScroll(class289.Widget_interfaceComponents[var8.id >>> 16], var8, true);
					}

					if (rootInterface != -1) {
						WorldMapRectangle.runIntfCloseListeners(rootInterface, 1);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2112 == var1.serverPacket) {
					isCameraLocked = true;
					MilliClock.field1990 = var3.readUnsignedByte() * 16384;
					FriendSystem.field1037 = var3.readUnsignedByte() * 128;
					FileSystem.field2027 = var3.readUnsignedShort();
					WorldMapCacheName.field301 = var3.readUnsignedByte();
					WorldMapArea.field211 = var3.readUnsignedByte();
					if (WorldMapArea.field211 >= 100) {
						ScriptFrame.cameraX = MilliClock.field1990 * 128 + 64;
						class14.cameraZ = FriendSystem.field1037 * 16384 + 64;
						GrandExchangeOfferTotalQuantityComparator.cameraY = WorldMapAreaData.getTileHeight(ScriptFrame.cameraX, class14.cameraZ, MouseRecorder.plane) - FileSystem.field2027;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2159 == var1.serverPacket) {
					WorldMapSection1.field286 = var3.method5547();
					ArchiveLoader.field508 = var3.readUnsignedByte();

					while (var3.offset < var1.serverPacketLength) {
						var48 = var3.readUnsignedByte();
						class185 var52 = GrandExchangeOfferUnitPriceComparator.method116()[var48];
						Canvas.method815(var52);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2154 == var1.serverPacket) {
					class218.friendSystem.method1856();
					field815 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2117 == var1.serverPacket) {
					if (var1.serverPacketLength == 0) {
						GrandExchangeOfferUnitPriceComparator.clanChat = null;
					} else {
						if (GrandExchangeOfferUnitPriceComparator.clanChat == null) {
							GrandExchangeOfferUnitPriceComparator.clanChat = new ClanChat(class4.loginType, Coord.client);
						}

						GrandExchangeOfferUnitPriceComparator.clanChat.readUpdate(var3);
					}

					class65.method1176();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2097 == var1.serverPacket) {
					Canvas.method815(class185.field2300);
					var1.serverPacket = null;
					return true;
				}

				String var37;
				if (ServerPacket.field2105 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					Object[] var51 = new Object[var37.length() + 1];

					for (var6 = var37.length() - 1; var6 >= 0; --var6) {
						if (var37.charAt(var6) == 's') {
							var51[var6 + 1] = var3.readStringCp1252NullTerminated();
						} else {
							var51[var6 + 1] = new Integer(var3.readInt());
						}
					}

					var51[0] = new Integer(var3.readInt());
					ScriptEvent var55 = new ScriptEvent();
					var55.args = var51;
					SecureRandomFuture.runScriptEvent(var55);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2181 == var1.serverPacket) {
					var48 = var3.readUnsignedShort();
					var5 = var3.readInt();
					var18 = Player.getWidget(var5);
					if (var18 != null && var18.type == 0) {
						if (var48 > var18.scrollHeight - var18.height) {
							var48 = var18.scrollHeight - var18.height;
						}

						if (var48 < 0) {
							var48 = 0;
						}

						if (var48 != var18.scrollY) {
							var18.scrollY = var48;
							WorldMapID.invalidateWidget(var18);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2107 == var1.serverPacket) {
					Canvas.method815(class185.field2302);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2146 == var1.serverPacket) {
					for (var48 = 0; var48 < Varps.Varps_main.length; ++var48) {
						if (Varps.Varps_temp[var48] != Varps.Varps_main[var48]) {
							Varps.Varps_main[var48] = Varps.Varps_temp[var48];
							Players.method2123(var48);
							field808[++field809 - 1 & 31] = var48;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2165 == var1.serverPacket) {
					var48 = var3.method5459();
					rootInterface = var48;
					this.resizeRoot(false);
					DevicePcmPlayerProvider.Widget_resetModelFrames(var48);
					Tile.runWidgetOnLoadListener(rootInterface);

					for (var5 = 0; var5 < 100; ++var5) {
						field827[var5] = true;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2133 == var1.serverPacket) {
					WorldMapElement.updateNpcs(true, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2103 == var1.serverPacket) {
					WorldMapRectangle.method257();
					var48 = var3.readUnsignedByte();
					var5 = var3.readUnsignedByte();
					var6 = var3.method5587();
					experience[var5] = var6;
					currentLevels[var5] = var48;
					levels[var5] = 1;

					for (var19 = 0; var19 < 98; ++var19) {
						if (var6 >= Skills.Skills_experienceTable[var19]) {
							levels[var5] = var19 + 2;
						}
					}

					changedSkills[++changedSkillsCount - 1 & 31] = var5;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2164 == var1.serverPacket) {
					class218.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
					HealthBarUpdate.FriendSystem_invalidateIgnoreds();
					field815 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2176 == var1.serverPacket) {
					isCameraLocked = true;
					class40.field334 = var3.readUnsignedByte() * 128;
					SecureRandomCallable.field499 = var3.readUnsignedByte() * 128;
					Varcs.field1242 = var3.readUnsignedShort();
					class65.field581 = var3.readUnsignedByte();
					WorldMapSection1.field285 = var3.readUnsignedByte();
					if (WorldMapSection1.field285 >= 100) {
						var48 = class40.field334 * 16384 + 64;
						var5 = SecureRandomCallable.field499 * 16384 + 64;
						var6 = WorldMapAreaData.getTileHeight(var48, var5, MouseRecorder.plane) - Varcs.field1242;
						var19 = var48 - ScriptFrame.cameraX;
						var20 = var6 - GrandExchangeOfferTotalQuantityComparator.cameraY;
						var9 = var5 - class14.cameraZ;
						var21 = (int)Math.sqrt((double)(var9 * var9 + var19 * var19));
						class319.cameraPitch = (int)(Math.atan2((double)var20, (double)var21) * 325.949D) & 2047;
						Tile.cameraYaw = (int)(Math.atan2((double)var19, (double)var9) * -325.949D) & 2047;
						if (class319.cameraPitch < 128) {
							class319.cameraPitch = 128;
						}

						if (class319.cameraPitch > 383) {
							class319.cameraPitch = 383;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2175 == var1.serverPacket) {
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

				if (ServerPacket.field2102 == var1.serverPacket) {
					WorldMapRectangle.method257();
					runEnergy = var3.readUnsignedByte();
					field670 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2135 == var1.serverPacket) {
					ClientPacket.method3599(var3.readStringCp1252NullTerminated());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2177 == var1.serverPacket) {
					Canvas.loadRegions(true, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				long var22;
				long var24;
				if (ServerPacket.field2182 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					var22 = (long)var3.readUnsignedShort();
					var24 = (long)var3.readMedium();
					PlayerType var26 = (PlayerType)ServerPacket.findEnumerated(PlayerAppearance.PlayerType_values(), var3.readUnsignedByte());
					long var27 = var24 + (var22 << 32);
					boolean var29 = false;

					for (int var13 = 0; var13 < 100; ++var13) {
						if (field842[var13] == var27) {
							var29 = true;
							break;
						}
					}

					if (class218.friendSystem.isIgnored(new Username(var37, class4.loginType))) {
						var29 = true;
					}

					if (!var29 && field735 == 0) {
						field842[field843] = var27;
						field843 = (field843 + 1) % 100;
						String var30 = AbstractFont.escapeBrackets(PacketBufferNode.method3616(GrandExchangeOfferWorldComparator.method60(var3)));
						byte var46;
						if (var26.isPrivileged) {
							var46 = 7;
						} else {
							var46 = 3;
						}

						if (var26.modIcon != -1) {
							WorldMapCacheName.addGameMessage(var46, ArchiveDiskAction.method4133(var26.modIcon) + var37, var30);
						} else {
							WorldMapCacheName.addGameMessage(var46, var37, var30);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2149 == var1.serverPacket) {
					Canvas.method815(class185.field2296);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2166 == var1.serverPacket) {
					var48 = var3.readUnsignedByte();
					class96.method2258(var48);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2142 == var1.serverPacket) {
					byte var59 = var3.method5634();
					var5 = var3.method5459();
					Varps.Varps_temp[var5] = var59;
					if (Varps.Varps_main[var5] != var59) {
						Varps.Varps_main[var5] = var59;
					}

					Players.method2123(var5);
					field808[++field809 - 1 & 31] = var5;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2147 == var1.serverPacket) {
					var48 = var3.readInt();
					if (var48 != field688) {
						field688 = var48;
						class14.method144();
					}

					var1.serverPacket = null;
					return true;
				}

				long var31;
				if (ServerPacket.field2108 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					var22 = var3.readLong();
					var24 = (long)var3.readUnsignedShort();
					var31 = (long)var3.readMedium();
					PlayerType var60 = (PlayerType)ServerPacket.findEnumerated(PlayerAppearance.PlayerType_values(), var3.readUnsignedByte());
					var12 = (var24 << 32) + var31;
					boolean var14 = false;

					for (int var15 = 0; var15 < 100; ++var15) {
						if (var12 == field842[var15]) {
							var14 = true;
							break;
						}
					}

					if (var60.isUser && class218.friendSystem.isIgnored(new Username(var37, class4.loginType))) {
						var14 = true;
					}

					if (!var14 && field735 == 0) {
						field842[field843] = var12;
						field843 = (field843 + 1) % 100;
						String var34 = AbstractFont.escapeBrackets(PacketBufferNode.method3616(GrandExchangeOfferWorldComparator.method60(var3)));
						if (var60.modIcon != -1) {
							UserComparator9.addChatMessage(9, ArchiveDiskAction.method4133(var60.modIcon) + var37, var34, StudioGame.base37DecodeLong(var22));
						} else {
							UserComparator9.addChatMessage(9, var37, var34, StudioGame.base37DecodeLong(var22));
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2145 == var1.serverPacket) {
					for (var48 = 0; var48 < CollisionMap.VarpDefinition_fileCount; ++var48) {
						VarpDefinition var50 = class30.method518(var48);
						if (var50 != null) {
							Varps.Varps_temp[var48] = 0;
							Varps.Varps_main[var48] = 0;
						}
					}

					WorldMapRectangle.method257();
					field809 += 32;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2139 == var1.serverPacket) {
					if (rootInterface != -1) {
						WorldMapRectangle.runIntfCloseListeners(rootInterface, 0);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2125 == var1.serverPacket) {
					class192.updatePlayers(var3, var1.serverPacketLength);
					class3.method30();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2124 == var1.serverPacket) {
					isCameraLocked = false;

					for (var48 = 0; var48 < 5; ++var48) {
						field749[var48] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2137 == var1.serverPacket) {
					var48 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var48 < -70000) {
						var5 += 32768;
					}

					if (var48 >= 0) {
						var18 = Player.getWidget(var48);
					} else {
						var18 = null;
					}

					if (var18 != null) {
						for (var19 = 0; var19 < var18.itemIds.length; ++var19) {
							var18.itemIds[var19] = 0;
							var18.itemQuantities[var19] = 0;
						}
					}

					class226.clearItemContainer(var5);
					var19 = var3.readUnsignedShort();

					for (var20 = 0; var20 < var19; ++var20) {
						var9 = var3.method5459();
						var21 = var3.readUnsignedByteNegate();
						if (var21 == 255) {
							var21 = var3.method5515();
						}

						if (var18 != null && var20 < var18.itemIds.length) {
							var18.itemIds[var20] = var9;
							var18.itemQuantities[var20] = var21;
						}

						WorldMapArea.itemContainerSetItem(var5, var20, var9 - 1, var21);
					}

					if (var18 != null) {
						WorldMapID.invalidateWidget(var18);
					}

					WorldMapRectangle.method257();
					field810[++field811 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2141 == var1.serverPacket) {
					Canvas.loadRegions(false, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2174 == var1.serverPacket) {
					var48 = var3.readUnsignedByte();
					WorldMapIcon_0.method196(var48);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2144 == var1.serverPacket) {
					var48 = var3.method5503();
					var5 = var3.method5515();
					var18 = Player.getWidget(var5);
					if (var18.modelType != 2 || var48 != var18.modelId) {
						var18.modelType = 2;
						var18.modelId = var48;
						WorldMapID.invalidateWidget(var18);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2170 == var1.serverPacket) {
					var48 = var3.method5459();
					var5 = var3.method5459();
					var6 = var3.readUnsignedShort();
					var19 = var3.method5587();
					var8 = Player.getWidget(var19);
					if (var48 != var8.modelAngleX || var6 != var8.modelAngleY || var5 != var8.modelZoom) {
						var8.modelAngleX = var48;
						var8.modelAngleY = var6;
						var8.modelZoom = var5;
						WorldMapID.invalidateWidget(var8);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2148 == var1.serverPacket) {
					var48 = var3.readInt();
					var5 = var3.readInt();
					var6 = Canvas.getGcDuration();
					PacketBufferNode var41 = MenuAction.getPacketBufferNode(ClientPacket.field2266, packetWriter.isaacCipher);
					var41.packetBuffer.method5491(GameShell.fps);
					var41.packetBuffer.method5491(var6);
					var41.packetBuffer.writeIntLE(var48);
					var41.packetBuffer.writeIntLE16(var5);
					packetWriter.addNode(var41);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2131 == var1.serverPacket) {
					var48 = var3.method5503();
					var5 = var3.readInt();
					var6 = var3.method5503();
					var7 = Player.getWidget(var5);
					var7.field2594 = var48 + (var6 << 16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2128 == var1.serverPacket) {
					var48 = var3.method5503();
					if (var48 == 65535) {
						var48 = -1;
					}

					var5 = var3.method5587();
					var6 = var3.method5514();
					if (var6 == 65535) {
						var6 = -1;
					}

					var19 = var3.method5515();

					for (var20 = var6; var20 <= var48; ++var20) {
						var31 = (long)var20 + ((long)var19 << 32);
						Node var33 = widgetClickMasks.get(var31);
						if (var33 != null) {
							var33.remove();
						}

						widgetClickMasks.put(new IntegerNode(var5), var31);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2138 == var1.serverPacket) {
					Canvas.method815(class185.field2305);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2101 == var1.serverPacket) {
					var48 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var48 < -70000) {
						var5 += 32768;
					}

					if (var48 >= 0) {
						var18 = Player.getWidget(var48);
					} else {
						var18 = null;
					}

					for (; var3.offset < var1.serverPacketLength; WorldMapArea.itemContainerSetItem(var5, var19, var20 - 1, var9)) {
						var19 = var3.readUShortSmart();
						var20 = var3.readUnsignedShort();
						var9 = 0;
						if (var20 != 0) {
							var9 = var3.readUnsignedByte();
							if (var9 == 255) {
								var9 = var3.readInt();
							}
						}

						if (var18 != null && var19 >= 0 && var19 < var18.itemIds.length) {
							var18.itemIds[var19] = var20;
							var18.itemQuantities[var19] = var9;
						}
					}

					if (var18 != null) {
						WorldMapID.invalidateWidget(var18);
					}

					WorldMapRectangle.method257();
					field810[++field811 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2110 == var1.serverPacket) {
					if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
						GrandExchangeOfferUnitPriceComparator.clanChat.method5217(var3);
					}

					class65.method1176();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2136 == var1.serverPacket) {
					var16 = var3.readBoolean();
					if (var16) {
						if (MenuAction.field1133 == null) {
							MenuAction.field1133 = new class237();
						}
					} else {
						MenuAction.field1133 = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2098 == var1.serverPacket) {
					var48 = var3.method5503();
					UrlRequest.method3276(var48);
					field810[++field811 - 1 & 31] = var48 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2143 == var1.serverPacket) {
					var48 = var3.method5515();
					var5 = var3.method5514();
					var18 = Player.getWidget(var48);
					if (var18.modelType != 1 || var5 != var18.modelId) {
						var18.modelType = 1;
						var18.modelId = var5;
						WorldMapID.invalidateWidget(var18);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2151 == var1.serverPacket) {
					class218.friendSystem.readUpdate(var3, var1.serverPacketLength);
					field815 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2167 == var1.serverPacket) {
					var48 = var3.method5580();
					var49 = Player.getWidget(var48);

					for (var6 = 0; var6 < var49.itemIds.length; ++var6) {
						var49.itemIds[var6] = -1;
						var49.itemIds[var6] = 0;
					}

					WorldMapID.invalidateWidget(var49);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2116 == var1.serverPacket) {
					for (var48 = 0; var48 < players.length; ++var48) {
						if (players[var48] != null) {
							players[var48].sequence = -1;
						}
					}

					for (var48 = 0; var48 < npcs.length; ++var48) {
						if (npcs[var48] != null) {
							npcs[var48].sequence = -1;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2111 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					var17 = AbstractFont.escapeBrackets(PacketBufferNode.method3616(GrandExchangeOfferWorldComparator.method60(var3)));
					WorldMapCacheName.addGameMessage(6, var37, var17);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2173 == var1.serverPacket) {
					var16 = var3.readUnsignedByte() == 1;
					if (var16) {
						GrandExchangeOfferWorldComparator.field25 = SoundCache.method2480() - var3.readLong();
						PacketWriter.grandExchangeEvents = new GrandExchangeEvents(var3, true);
					} else {
						PacketWriter.grandExchangeEvents = null;
					}

					field818 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				class188.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1286 != null ? var1.field1286.id : -1) + "," + (var1.field1287 != null ? var1.field1287.id : -1) + "," + var1.serverPacketLength, (Throwable)null);
				class40.method736();
			} catch (IOException var35) {
				class185.method3607();
			} catch (Exception var36) {
				var17 = "" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1286 != null ? var1.field1286.id : -1) + "," + (var1.field1287 != null ? var1.field1287.id : -1) + "," + var1.serverPacketLength + "," + (Varps.localPlayer.pathX[0] + class4.baseX * 64) + "," + (Varps.localPlayer.pathY[0] + ScriptEvent.baseY) + ",";

				for (var6 = 0; var6 < var1.serverPacketLength && var6 < 50; ++var6) {
					var17 = var17 + var3.array[var6] + ",";
				}

				class188.RunException_sendStackTrace(var17, var36);
				class40.method736();
			}

			return true;
		}
	}

	@ObfuscatedName("hf")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "28"
	)
	final void method1263() {
		boolean var1 = false;

		int var2;
		int var5;
		while (!var1) {
			var1 = true;

			for (var2 = 0; var2 < menuOptionsCount - 1; ++var2) {
				if (menuOpcodes[var2] < 1000 && menuOpcodes[var2 + 1] > 1000) {
					String var3 = menuTargets[var2];
					menuTargets[var2] = menuTargets[var2 + 1];
					menuTargets[var2 + 1] = var3;
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
					var5 = menuIdentifiers[var2];
					menuIdentifiers[var2] = menuIdentifiers[var2 + 1];
					menuIdentifiers[var2 + 1] = var5;
					boolean var6 = menuShiftClick[var2];
					menuShiftClick[var2] = menuShiftClick[var2 + 1];
					menuShiftClick[var2 + 1] = var6;
					var1 = false;
				}
			}
		}

		if (class4.dragInventoryWidget == null) {
			if (clickedWidget == null) {
				int var15 = MouseHandler.MouseHandler_lastButton;
				int var8;
				int var12;
				int var13;
				int var18;
				if (isMenuOpen) {
					if (var15 != 1 && (WorldMapSection1.mouseCam || var15 != 4)) {
						var2 = MouseHandler.MouseHandler_x;
						var12 = MouseHandler.MouseHandler_y;
						if (var2 < FileSystem.menuX - 10 || var2 > FileSystem.menuX + class173.menuWidth + 10 || var12 < class83.menuY - 10 || var12 > class83.menuY + FaceNormal.menuHeight + 10) {
							isMenuOpen = false;
							HealthBar.method2007(FileSystem.menuX, class83.menuY, class173.menuWidth, FaceNormal.menuHeight);
						}
					}

					if (var15 == 1 || !WorldMapSection1.mouseCam && var15 == 4) {
						var2 = FileSystem.menuX;
						var12 = class83.menuY;
						var13 = class173.menuWidth;
						var5 = MouseHandler.MouseHandler_lastPressedX;
						int var16 = MouseHandler.MouseHandler_lastPressedY;
						int var17 = -1;

						for (var8 = 0; var8 < menuOptionsCount; ++var8) {
							var18 = var12 + (menuOptionsCount - 1 - var8) * 15 + 31;
							if (var5 > var2 && var5 < var13 + var2 && var16 > var18 - 13 && var16 < var18 + 3) {
								var17 = var8;
							}
						}

						if (var17 != -1) {
							AbstractWorldMapIcon.method572(var17);
						}

						isMenuOpen = false;
						HealthBar.method2007(FileSystem.menuX, class83.menuY, class173.menuWidth, FaceNormal.menuHeight);
					}
				} else {
					var2 = WorldMapCacheName.getNewestMenuIdx();
					if ((var15 == 1 || !WorldMapSection1.mouseCam && var15 == 4) && var2 >= 0) {
						var12 = menuOpcodes[var2];
						if (var12 == 39 || var12 == 40 || var12 == 41 || var12 == 42 || var12 == 43 || var12 == 33 || var12 == 34 || var12 == 35 || var12 == 36 || var12 == 37 || var12 == 38 || var12 == 1005) {
							label274: {
								var13 = menuArguments1[var2];
								var5 = menuArguments2[var2];
								Widget var14 = Player.getWidget(var5);
								var8 = class60.getWidgetClickMask(var14);
								boolean var7 = (var8 >> 28 & 1) != 0;
								int var10;
								if (!var7) {
									var10 = class60.getWidgetClickMask(var14);
									boolean var9 = (var10 >> 29 & 1) != 0;
									if (!var9) {
										break label274;
									}
								}

								if (class4.dragInventoryWidget != null && !field733 && menuOptionsCount > 0 && !this.shouldLeftClickOpenMenu()) {
									var18 = field730;
									var10 = field870;
									MenuAction var11 = SoundCache.tempMenuAction;
									EnumDefinition.menuAction(var11.argument1, var11.argument2, var11.opcode, var11.argument0, var11.action, var11.action, var18, var10);
									SoundCache.tempMenuAction = null;
								}

								field733 = false;
								itemDragDuration = 0;
								if (class4.dragInventoryWidget != null) {
									WorldMapID.invalidateWidget(class4.dragInventoryWidget);
								}

								class4.dragInventoryWidget = Player.getWidget(var5);
								dragItemSlotSource = var13;
								field730 = MouseHandler.MouseHandler_lastPressedX;
								field870 = MouseHandler.MouseHandler_lastPressedY;
								if (var2 >= 0) {
									SoundCache.tempMenuAction = new MenuAction();
									SoundCache.tempMenuAction.argument1 = menuArguments1[var2];
									SoundCache.tempMenuAction.argument2 = menuArguments2[var2];
									SoundCache.tempMenuAction.opcode = menuOpcodes[var2];
									SoundCache.tempMenuAction.argument0 = menuIdentifiers[var2];
									SoundCache.tempMenuAction.action = menuActions[var2];
								}

								WorldMapID.invalidateWidget(class4.dragInventoryWidget);
								return;
							}
						}
					}

					if ((var15 == 1 || !WorldMapSection1.mouseCam && var15 == 4) && this.shouldLeftClickOpenMenu()) {
						var15 = 2;
					}

					if ((var15 == 1 || !WorldMapSection1.mouseCam && var15 == 4) && menuOptionsCount > 0) {
						AbstractWorldMapIcon.method572(var2);
					}

					if (var15 == 2 && menuOptionsCount > 0) {
						this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
					}
				}

			}
		}
	}

	@ObfuscatedName("ha")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "0"
	)
	@Export("shouldLeftClickOpenMenu")
	final boolean shouldLeftClickOpenMenu() {
		int var1 = WorldMapCacheName.getNewestMenuIdx();
		boolean var2 = leftClickOpensMenu == 1 && menuOptionsCount > 2;
		if (!var2) {
			boolean var3;
			if (var1 < 0) {
				var3 = false;
			} else {
				int var4 = menuOpcodes[var1];
				if (var4 >= 2000) {
					var4 -= 2000;
				}

				if (var4 == 1007) {
					var3 = true;
				} else {
					var3 = false;
				}
			}

			var2 = var3;
		}

		return var2 && !menuShiftClick[var1];
	}

	@ObfuscatedName("hu")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1915079329"
	)
	@Export("openMenu")
	final void openMenu(int var1, int var2) {
		ScriptEvent.calculateMenuBounds(var1, var2);
		WorldMapIcon_1.scene.menuOpen(MouseRecorder.plane, var1, var2, false);
		isMenuOpen = true;
	}

	@ObfuscatedName("im")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-475129533"
	)
	@Export("resizeRoot")
	final void resizeRoot(boolean var1) {
		Occluder.resizeComponents(rootInterface, GraphicsDefaults.canvasWidth, GameShell.canvasHeight, var1);
	}

	@ObfuscatedName("il")
	@ObfuscatedSignature(
		signature = "(Lhy;B)V",
		garbageValue = "4"
	)
	@Export("alignWidget")
	void alignWidget(Widget var1) {
		Widget var2 = var1.parentId == -1 ? null : Player.getWidget(var1.parentId);
		int var3;
		int var4;
		if (var2 == null) {
			var3 = GraphicsDefaults.canvasWidth;
			var4 = GameShell.canvasHeight;
		} else {
			var3 = var2.width;
			var4 = var2.height;
		}

		class192.alignWidgetSize(var1, var3, var4, false);
		WorldMapEvent.alignWidgetPosition(var1, var3, var4);
	}

	@ObfuscatedName("jn")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1922845127"
	)
	final void method1268() {
		WorldMapID.invalidateWidget(clickedWidget);
		++ArchiveLoader.widgetDragDuration;
		if (field803 && field800) {
			int var1 = MouseHandler.MouseHandler_x;
			int var2 = MouseHandler.MouseHandler_y;
			var1 -= widgetClickX;
			var2 -= widgetClickY;
			if (var1 < field801) {
				var1 = field801;
			}

			if (var1 + clickedWidget.width > field801 + clickedWidgetParent.width) {
				var1 = field801 + clickedWidgetParent.width - clickedWidget.width;
			}

			if (var2 < field706) {
				var2 = field706;
			}

			if (var2 + clickedWidget.height > field706 + clickedWidgetParent.height) {
				var2 = field706 + clickedWidgetParent.height - clickedWidget.height;
			}

			int var3 = var1 - field804;
			int var4 = var2 - field699;
			int var5 = clickedWidget.dragZoneSize;
			if (ArchiveLoader.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
				isDraggingWidget = true;
			}

			int var6 = var1 - field801 + clickedWidgetParent.scrollX;
			int var7 = var2 - field706 + clickedWidgetParent.scrollY;
			ScriptEvent var8;
			if (clickedWidget.onDrag != null && isDraggingWidget) {
				var8 = new ScriptEvent();
				var8.widget = clickedWidget;
				var8.mouseX = var6;
				var8.mouseY = var7;
				var8.args = clickedWidget.onDrag;
				SecureRandomFuture.runScriptEvent(var8);
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
						SecureRandomFuture.runScriptEvent(var8);
					}

					if (draggedOnWidget != null && FontName.method5290(clickedWidget) != null) {
						PacketBufferNode var12 = MenuAction.getPacketBufferNode(ClientPacket.field2242, packetWriter.isaacCipher);
						var12.packetBuffer.writeShortLE(draggedOnWidget.id);
						var12.packetBuffer.method5500(clickedWidget.itemId);
						var12.packetBuffer.method5502(draggedOnWidget.itemId);
						var12.packetBuffer.writeIntME(draggedOnWidget.childIndex);
						var12.packetBuffer.writeIntME(clickedWidget.childIndex);
						var12.packetBuffer.writeIntLE(clickedWidget.id);
						packetWriter.addNode(var12);
					}
				} else if (this.shouldLeftClickOpenMenu()) {
					this.openMenu(widgetClickX + field804, field699 + widgetClickY);
				} else if (menuOptionsCount > 0) {
					int var11 = widgetClickX + field804;
					int var9 = field699 + widgetClickY;
					MenuAction var10 = SoundCache.tempMenuAction;
					EnumDefinition.menuAction(var10.argument1, var10.argument2, var10.opcode, var10.argument0, var10.action, var10.action, var11, var9);
					SoundCache.tempMenuAction = null;
				}

				clickedWidget = null;
			}

		} else {
			if (ArchiveLoader.widgetDragDuration > 1) {
				clickedWidget = null;
			}

		}
	}

	@ObfuscatedName("kp")
	@ObfuscatedSignature(
		signature = "(B)Ljt;",
		garbageValue = "1"
	)
	@Export("username")
	public Username username() {
		return Varps.localPlayer != null ? Varps.localPlayer.username : null;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "1135918061"
	)
	@Export("isCharAlphabetic")
	public static boolean isCharAlphabetic(char var0) {
		return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}

	static void aab() {
		if (field824 && Varps.localPlayer != null) {
			int var0 = Varps.localPlayer.pathX[0];
			int var1 = Varps.localPlayer.pathY[0];
			if (var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
				return;
			}

			SecureRandomFuture.oculusOrbFocalPointX = Varps.localPlayer.x * -78439701;
			int var2 = WorldMapAreaData.getTileHeight(Varps.localPlayer.x * -78439701, Varps.localPlayer.y, MouseRecorder.plane) - camFollowHeight * 172735687;
			if (var2 < class65.field580 * 1615694975) {
				class65.field580 = var2 * -59362433;
			}

			AbstractByteArrayCopier.oculusOrbFocalPointY = Varps.localPlayer.y;
			field824 = false;
		}

	}

	@ObfuscatedSignature(
		signature = "(Lkz;)V"
	)
	static void aao(Buffer var0) {
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
		signature = "(Lkz;I)V"
	)
	static void aav(Buffer var0, int var1) {
		byte[] var2 = var0.array;
		if (randomDatData == null) {
			randomDatData = new byte[24];
		}

		class300.writeRandomDat(var2, var1, randomDatData, 0, 24);
		class49.method828(var0, var1);
	}

	static void aax() {
		if (MenuAction.field1133 != null) {
			field892 = cycle;
			MenuAction.field1133.method4295();

			for (int var0 = 0; var0 < players.length; ++var0) {
				if (players[var0] != null) {
					MenuAction.field1133.method4319(class4.baseX * 64 + (players[var0].x * -78439701 >> 7), ScriptEvent.baseY + (players[var0].y >> 7));
				}
			}
		}

	}

	static void aaq() {
		if (field824 && Varps.localPlayer != null) {
			int var0 = Varps.localPlayer.pathX[0];
			int var1 = Varps.localPlayer.pathY[0];
			if (var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
				return;
			}

			SecureRandomFuture.oculusOrbFocalPointX = Varps.localPlayer.x * -78439701;
			int var2 = WorldMapAreaData.getTileHeight(Varps.localPlayer.x * -78439701, Varps.localPlayer.y, MouseRecorder.plane) - camFollowHeight * 172735687;
			if (var2 < class65.field580 * 1615694975) {
				class65.field580 = var2 * -59362433;
			}

			AbstractByteArrayCopier.oculusOrbFocalPointY = Varps.localPlayer.y;
			field824 = false;
		}

	}

	@ObfuscatedSignature(
		signature = "(Lkz;)V"
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
		signature = "(Lkz;)V"
	)
	static void aal(Buffer var0) {
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

	public static boolean aaw() {
		return staffModLevel >= 2;
	}

	public static boolean aam() {
		return staffModLevel >= 2;
	}

	static void aat(int var0) {
		oculusOrbState = var0;
	}

	static void aah() {
		packetWriter.addNode(MenuAction.getPacketBufferNode(ClientPacket.field2254, packetWriter.isaacCipher));
		oculusOrbState = 0;
	}

	static void aae() {
		packetWriter.addNode(MenuAction.getPacketBufferNode(ClientPacket.field2254, packetWriter.isaacCipher));
		oculusOrbState = 0;
	}

	@Export("sortMenuEntries")
	@ObfuscatedName("aaz")
	static void sortMenuEntries() {
		if (oculusOrbState * 1131557898 == 1) {
			field824 = true;
		}

	}

	static void aau() {
		if (field824 && Varps.localPlayer != null) {
			int var0 = Varps.localPlayer.pathX[0];
			int var1 = Varps.localPlayer.pathY[0];
			if (var0 < 0 || var1 < 0 || var0 >= -1349199817 || var1 >= 104) {
				return;
			}

			SecureRandomFuture.oculusOrbFocalPointX = Varps.localPlayer.x * 1039058795;
			int var2 = WorldMapAreaData.getTileHeight(Varps.localPlayer.x * -78439701, Varps.localPlayer.y, MouseRecorder.plane) - camFollowHeight * 536343645;
			if (var2 < class65.field580 * 1615694975) {
				class65.field580 = var2 * -59362433;
			}

			AbstractByteArrayCopier.oculusOrbFocalPointY = Varps.localPlayer.y;
			field824 = false;
		}

	}

	static void aas() {
		if (field824 && Varps.localPlayer != null) {
			int var0 = Varps.localPlayer.pathX[0];
			int var1 = Varps.localPlayer.pathY[0];
			if (var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
				return;
			}

			SecureRandomFuture.oculusOrbFocalPointX = Varps.localPlayer.x * -78439701;
			int var2 = WorldMapAreaData.getTileHeight(Varps.localPlayer.x * -78439701, Varps.localPlayer.y, MouseRecorder.plane) - camFollowHeight * 172735687;
			if (var2 < class65.field580 * 1615694975) {
				class65.field580 = var2 * -59362433;
			}

			AbstractByteArrayCopier.oculusOrbFocalPointY = Varps.localPlayer.y;
			field824 = false;
		}

	}

	static void aay() {
		if (field824 && Varps.localPlayer != null) {
			int var0 = Varps.localPlayer.pathX[0];
			int var1 = Varps.localPlayer.pathY[0];
			if (var0 < 0 || var1 < 0 || var0 >= 2074219828 || var1 >= 104) {
				return;
			}

			SecureRandomFuture.oculusOrbFocalPointX = Varps.localPlayer.x * 79454524;
			int var2 = WorldMapAreaData.getTileHeight(Varps.localPlayer.x * -78439701, Varps.localPlayer.y * -224354688, MouseRecorder.plane) - camFollowHeight * -808569797;
			if (var2 < class65.field580 * 228658747) {
				class65.field580 = var2 * 545155251;
			}

			AbstractByteArrayCopier.oculusOrbFocalPointY = Varps.localPlayer.y * 1124445248;
			field824 = false;
		}

	}

	static String aaf(String var0) {
		PlayerType[] var1 = PlayerAppearance.PlayerType_values();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			PlayerType var3 = var1[var2];
			if (var3.modIcon * 2069934243 != -1 && var0.startsWith(ArchiveDiskAction.method4133(var3.modIcon * 250778590))) {
				var0 = var0.substring(6 + Integer.toString(var3.modIcon * 1831934627).length());
				break;
			}
		}

		return var0;
	}

	static void aag() {
		if (MenuAction.field1133 != null) {
			field892 = cycle * -1425026086;
			MenuAction.field1133.method4295();

			for (int var0 = 0; var0 < players.length; ++var0) {
				if (players[var0] != null) {
					MenuAction.field1133.method4319((players[var0].x * 107503986 >> 7) + class4.baseX * 1793092736, ScriptEvent.baseY * 90968450 + (players[var0].y >> 7));
				}
			}
		}

	}

	@ObfuscatedName("gj")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "219285186"
	)
	static final int method1679() {
		if (Actor.clientPreferences.roofsHidden) {
			return MouseRecorder.plane;
		} else {
			int var0 = 3;
			if (class319.cameraPitch < 310) {
				int var1;
				int var2;
				if (oculusOrbState == 1) {
					var1 = SecureRandomFuture.oculusOrbFocalPointX >> 7;
					var2 = AbstractByteArrayCopier.oculusOrbFocalPointY >> 7;
				} else {
					var1 = Varps.localPlayer.x * -78439701 >> 7;
					var2 = Varps.localPlayer.y >> 7;
				}

				int var3 = ScriptFrame.cameraX >> 7;
				int var4 = class14.cameraZ >> 7;
				if (var3 < 0 || var4 < 0 || var3 >= 104 || var4 >= 104) {
					return MouseRecorder.plane;
				}

				if (var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
					return MouseRecorder.plane;
				}

				if ((Tiles.Tiles_renderFlags[MouseRecorder.plane][var3][var4] & 4) != 0) {
					var0 = MouseRecorder.plane;
				}

				int var5;
				if (var1 > var3) {
					var5 = var1 - var3;
				} else {
					var5 = var3 - var1;
				}

				int var6;
				if (var2 > var4) {
					var6 = var2 - var4;
				} else {
					var6 = var4 - var2;
				}

				int var7;
				int var8;
				if (var5 > var6) {
					var7 = var6 * 65536 / var5;
					var8 = 32768;

					while (var1 != var3) {
						if (var3 < var1) {
							++var3;
						} else if (var3 > var1) {
							--var3;
						}

						if ((Tiles.Tiles_renderFlags[MouseRecorder.plane][var3][var4] & 4) != 0) {
							var0 = MouseRecorder.plane;
						}

						var8 += var7;
						if (var8 >= 65536) {
							var8 -= 65536;
							if (var4 < var2) {
								++var4;
							} else if (var4 > var2) {
								--var4;
							}

							if ((Tiles.Tiles_renderFlags[MouseRecorder.plane][var3][var4] & 4) != 0) {
								var0 = MouseRecorder.plane;
							}
						}
					}
				} else if (var6 > 0) {
					var7 = var5 * 65536 / var6;
					var8 = 32768;

					while (var4 != var2) {
						if (var4 < var2) {
							++var4;
						} else if (var4 > var2) {
							--var4;
						}

						if ((Tiles.Tiles_renderFlags[MouseRecorder.plane][var3][var4] & 4) != 0) {
							var0 = MouseRecorder.plane;
						}

						var8 += var7;
						if (var8 >= 65536) {
							var8 -= 65536;
							if (var3 < var1) {
								++var3;
							} else if (var3 > var1) {
								--var3;
							}

							if ((Tiles.Tiles_renderFlags[MouseRecorder.plane][var3][var4] & 4) != 0) {
								var0 = MouseRecorder.plane;
							}
						}
					}
				}
			}

			if (Varps.localPlayer.x * -78439701 >= 0 && Varps.localPlayer.y >= 0 && Varps.localPlayer.x * -78439701 < 13312 && Varps.localPlayer.y < 13312) {
				if ((Tiles.Tiles_renderFlags[MouseRecorder.plane][Varps.localPlayer.x * -78439701 >> 7][Varps.localPlayer.y >> 7] & 4) != 0) {
					var0 = MouseRecorder.plane;
				}

				return var0;
			} else {
				return MouseRecorder.plane;
			}
		}
	}
}
