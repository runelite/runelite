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
	@ObfuscatedName("mu")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("clickedWidget")
	static Widget clickedWidget;
	@ObfuscatedName("ov")
	@ObfuscatedGetter(
		intValue = -880923057
	)
	static int field832;
	@ObfuscatedName("og")
	@ObfuscatedGetter(
		intValue = -405077157
	)
	@Export("rootWidgetCount")
	static int rootWidgetCount;
	@ObfuscatedName("oa")
	@ObfuscatedGetter(
		longValue = 6996967877064872553L
	)
	static long field841;
	@ObfuscatedName("os")
	static boolean[] field833;
	@ObfuscatedName("ok")
	static boolean[] field834;
	@ObfuscatedName("on")
	static boolean[] field835;
	@ObfuscatedName("ni")
	static boolean field809;
	@ObfuscatedName("nc")
	@ObfuscatedGetter(
		intValue = -1405704491
	)
	@Export("cycleCntr")
	static int cycleCntr;
	@ObfuscatedName("ot")
	@Export("isResizable")
	static boolean isResizable;
	@ObfuscatedName("nt")
	@ObfuscatedGetter(
		intValue = -1225978651
	)
	static int field711;
	@ObfuscatedName("sc")
	@ObfuscatedGetter(
		intValue = -1513063055
	)
	public static int field749;
	@ObfuscatedName("nh")
	static boolean field806;
	@ObfuscatedName("qt")
	static boolean field767;
	@ObfuscatedName("mm")
	@ObfuscatedGetter(
		intValue = -733462179
	)
	@Export("widgetClickX")
	static int widgetClickX;
	@ObfuscatedName("mx")
	@ObfuscatedGetter(
		intValue = 1296654555
	)
	@Export("widgetClickY")
	static int widgetClickY;
	@ObfuscatedName("no")
	@ObfuscatedGetter(
		intValue = 265525087
	)
	static int field807;
	@ObfuscatedName("oo")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("widgetClickMasks")
	static NodeHashTable widgetClickMasks;
	@ObfuscatedName("mo")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("clickedWidgetParent")
	static Widget clickedWidgetParent;
	@ObfuscatedName("oz")
	@Export("rootWidgetWidths")
	static int[] rootWidgetWidths;
	@ObfuscatedName("ma")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("interfaceParents")
	static NodeHashTable interfaceParents;
	@ObfuscatedName("ow")
	@Export("rootWidgetXs")
	static int[] rootWidgetXs;
	@ObfuscatedName("nm")
	@ObfuscatedGetter(
		intValue = 1203464941
	)
	static int field808;
	@ObfuscatedName("mc")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("viewportWidget")
	static Widget viewportWidget;
	@ObfuscatedName("ou")
	@ObfuscatedGetter(
		intValue = -2063650301
	)
	@Export("gameDrawingMode")
	static int gameDrawingMode;
	@ObfuscatedName("oq")
	@Export("rootWidgetHeights")
	static int[] rootWidgetHeights;
	@ObfuscatedName("mt")
	@ObfuscatedGetter(
		intValue = -1570996335
	)
	@Export("staffModLevel")
	public static int staffModLevel;
	@ObfuscatedName("ts")
	@ObfuscatedSignature(
		signature = "Lba;"
	)
	static final class65 field902;
	@ObfuscatedName("oi")
	@Export("rootWidgetYs")
	static int[] rootWidgetYs;
	@ObfuscatedName("ql")
	@ObfuscatedGetter(
		intValue = -731795947
	)
	@Export("currentTrackGroupId")
	static int currentTrackGroupId;
	@ObfuscatedName("op")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("scriptEvents")
	static NodeDeque scriptEvents;
	@ObfuscatedName("pj")
	@ObfuscatedGetter(
		intValue = 1081160319
	)
	@Export("destinationX")
	static int destinationX;
	@ObfuscatedName("ng")
	@ObfuscatedGetter(
		intValue = 1476822695
	)
	static int field882;
	@ObfuscatedName("qc")
	@ObfuscatedGetter(
		intValue = 1145130111
	)
	@Export("musicVolume")
	static int musicVolume;
	@ObfuscatedName("pd")
	@ObfuscatedGetter(
		intValue = 810038281
	)
	@Export("destinationY")
	static int destinationY;
	@ObfuscatedName("nk")
	@ObfuscatedGetter(
		intValue = -1107460421
	)
	static int field811;
	@ObfuscatedName("tr")
	static int[] field903;
	@ObfuscatedName("tb")
	static int[] field730;
	@ObfuscatedName("ne")
	static int[] field814;
	@ObfuscatedName("nv")
	@ObfuscatedGetter(
		intValue = 1654772915
	)
	static int field648;
	@ObfuscatedName("qe")
	@ObfuscatedGetter(
		intValue = -1501062623
	)
	@Export("minimapState")
	static int minimapState;
	@ObfuscatedName("nj")
	@Export("isDraggingWidget")
	static boolean isDraggingWidget;
	@ObfuscatedName("mi")
	@ObfuscatedGetter(
		intValue = -883981411
	)
	@Export("runEnergy")
	static int runEnergy;
	@ObfuscatedName("mq")
	@ObfuscatedGetter(
		intValue = 601999387
	)
	@Export("weight")
	static int weight;
	@ObfuscatedName("sv")
	@ObfuscatedGetter(
		intValue = -1907588415
	)
	static int field893;
	@ObfuscatedName("rh")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	@Export("playerAppearance")
	static PlayerAppearance playerAppearance;
	@ObfuscatedName("qh")
	@ObfuscatedGetter(
		intValue = 1772801815
	)
	@Export("areaSoundEffectVolume")
	static int areaSoundEffectVolume;
	@ObfuscatedName("sm")
	@ObfuscatedGetter(
		intValue = -308750649
	)
	static int field894;
	@ObfuscatedName("mw")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("draggedOnWidget")
	static Widget draggedOnWidget;
	@ObfuscatedName("om")
	@ObfuscatedGetter(
		intValue = -414027891
	)
	@Export("mouseWheelRotation")
	static int mouseWheelRotation;
	@ObfuscatedName("nq")
	@ObfuscatedGetter(
		intValue = -1985880681
	)
	static int field825;
	@ObfuscatedName("qk")
	@ObfuscatedGetter(
		intValue = -1182860481
	)
	@Export("soundEffectVolume")
	static int soundEffectVolume;
	@ObfuscatedName("qp")
	@Export("isCameraLocked")
	static boolean isCameraLocked;
	@ObfuscatedName("sk")
	@Export("archiveLoaders")
	static ArrayList archiveLoaders;
	@ObfuscatedName("qx")
	@ObfuscatedGetter(
		intValue = 413353821
	)
	@Export("soundEffectCount")
	static int soundEffectCount;
	@ObfuscatedName("np")
	@Export("changedSkills")
	static int[] changedSkills;
	@ObfuscatedName("qm")
	@Export("soundEffectIds")
	static int[] soundEffectIds;
	@ObfuscatedName("sx")
	@ObfuscatedGetter(
		intValue = 83394787
	)
	@Export("archiveLoadersDone")
	static int archiveLoadersDone;
	@ObfuscatedName("rj")
	static boolean[] field779;
	@ObfuscatedName("nu")
	@ObfuscatedGetter(
		intValue = 1316268697
	)
	@Export("changedSkillsCount")
	static int changedSkillsCount;
	@ObfuscatedName("pp")
	@ObfuscatedGetter(
		intValue = -1130941139
	)
	static int field853;
	@ObfuscatedName("qj")
	@Export("queuedSoundEffectLoops")
	static int[] queuedSoundEffectLoops;
	@ObfuscatedName("qz")
	@Export("queuedSoundEffectDelays")
	static int[] queuedSoundEffectDelays;
	@ObfuscatedName("mn")
	@ObfuscatedGetter(
		intValue = -1572396161
	)
	@Export("chatEffects")
	static int chatEffects;
	@ObfuscatedName("qf")
	@ObfuscatedSignature(
		signature = "[Lcl;"
	)
	@Export("soundEffects")
	static SoundEffect[] soundEffects;
	@ObfuscatedName("mr")
	@ObfuscatedGetter(
		intValue = 2013132005
	)
	static int field901;
	@ObfuscatedName("ps")
	@ObfuscatedGetter(
		longValue = 5997092609949214729L
	)
	static long field852;
	@ObfuscatedName("qw")
	@Export("soundLocations")
	static int[] soundLocations;
	@ObfuscatedName("mv")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("meslayerContinueWidget")
	static Widget meslayerContinueWidget;
	@ObfuscatedName("si")
	@ObfuscatedSignature(
		signature = "[Ld;"
	)
	@Export("grandExchangeOffers")
	static GrandExchangeOffer[] grandExchangeOffers;
	@ObfuscatedName("na")
	@ObfuscatedGetter(
		intValue = 2032426333
	)
	static int field823;
	@ObfuscatedName("mh")
	@ObfuscatedGetter(
		intValue = 48387723
	)
	@Export("followerIndex")
	static int followerIndex;
	@ObfuscatedName("pz")
	@ObfuscatedGetter(
		intValue = -1325828335
	)
	@Export("mapIconCount")
	static int mapIconCount;
	@ObfuscatedName("ny")
	@ObfuscatedGetter(
		intValue = -2121721263
	)
	static int field862;
	@ObfuscatedName("sq")
	@ObfuscatedSignature(
		signature = "Lly;"
	)
	@Export("platformInfoProvider")
	static PlatformInfoProvider platformInfoProvider;
	@ObfuscatedName("rx")
	static short field879;
	@ObfuscatedName("rt")
	static short field880;
	@ObfuscatedName("rl")
	static short field804;
	@ObfuscatedName("pf")
	@Export("mapIconXs")
	static int[] mapIconXs;
	@ObfuscatedName("ri")
	static short field886;
	@ObfuscatedName("rn")
	static short field884;
	@ObfuscatedName("rk")
	@ObfuscatedGetter(
		intValue = -1174260245
	)
	@Export("viewportZoom")
	static int viewportZoom;
	@ObfuscatedName("rd")
	static short field796;
	@ObfuscatedName("rv")
	@ObfuscatedGetter(
		intValue = -1637393507
	)
	@Export("viewportWidth")
	static int viewportWidth;
	@ObfuscatedName("py")
	@Export("mapIconYs")
	static int[] mapIconYs;
	@ObfuscatedName("px")
	@ObfuscatedSignature(
		signature = "[Lls;"
	)
	@Export("mapIcons")
	static Sprite[] mapIcons;
	@ObfuscatedName("rg")
	@ObfuscatedGetter(
		intValue = 312765867
	)
	@Export("viewportHeight")
	static int viewportHeight;
	@ObfuscatedName("nr")
	@Export("changedItemContainers")
	static int[] changedItemContainers;
	@ObfuscatedName("ns")
	@ObfuscatedGetter(
		intValue = -2138189623
	)
	static int field701;
	@ObfuscatedName("rz")
	@ObfuscatedGetter(
		intValue = 1559591419
	)
	@Export("viewportOffsetX")
	static int viewportOffsetX;
	@ObfuscatedName("ru")
	@ObfuscatedGetter(
		intValue = -1657218597
	)
	@Export("viewportOffsetY")
	static int viewportOffsetY;
	@ObfuscatedName("ra")
	@ObfuscatedGetter(
		intValue = -1958895977
	)
	static int field873;
	@ObfuscatedName("pm")
	@ObfuscatedGetter(
		intValue = -226076741
	)
	@Export("publicChatMode")
	static int publicChatMode;
	@ObfuscatedName("pk")
	@ObfuscatedGetter(
		intValue = 765110439
	)
	@Export("tradeChatMode")
	static int tradeChatMode;
	@ObfuscatedName("pr")
	@ObfuscatedGetter(
		intValue = -255532007
	)
	static int field849;
	@ObfuscatedName("nz")
	@ObfuscatedGetter(
		intValue = -2038569335
	)
	static int field860;
	@ObfuscatedName("sr")
	@ObfuscatedGetter(
		intValue = 135931079
	)
	static int field629;
	@ObfuscatedName("pq")
	static int[] field851;
	@ObfuscatedName("po")
	static long[] field707;
	@ObfuscatedName("oy")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	static NodeDeque field865;
	@ObfuscatedName("pa")
	static int[] field850;
	@ObfuscatedName("of")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	static NodeDeque field883;
	@ObfuscatedName("rc")
	static int[] field876;
	@ObfuscatedName("rw")
	static int[] field875;
	@ObfuscatedName("re")
	static int[] field877;
	@ObfuscatedName("ro")
	@Export("zoomWidth")
	static short zoomWidth;
	@ObfuscatedName("mb")
	@Export("playerMod")
	static boolean playerMod;
	@ObfuscatedName("rb")
	@Export("zoomHeight")
	static short zoomHeight;
	@ObfuscatedName("ry")
	static int[] field878;
	@ObfuscatedName("ms")
	@ObfuscatedGetter(
		intValue = 171617061
	)
	static int field790;
	@ObfuscatedName("ph")
	@ObfuscatedGetter(
		intValue = 1104581319
	)
	static int field682;
	@ObfuscatedName("ml")
	@ObfuscatedGetter(
		intValue = 6075793
	)
	static int field791;
	@ObfuscatedName("nw")
	@ObfuscatedGetter(
		intValue = 1430052583
	)
	@Export("chatCycle")
	static int chatCycle;
	@ObfuscatedName("pc")
	static String field846;
	@ObfuscatedName("sw")
	@ObfuscatedSignature(
		signature = "Lbb;"
	)
	@Export("GrandExchangeEvents_worldComparator")
	static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
	@ObfuscatedName("pe")
	static int[] field864;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "[Lfp;"
	)
	@Export("collisionMaps")
	static CollisionMap[] collisionMaps;
	@ObfuscatedName("ab")
	static boolean field895;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = 860985583
	)
	@Export("worldId")
	public static int worldId;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = 192625081
	)
	@Export("worldProperties")
	static int worldProperties;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = -1621867791
	)
	@Export("gameBuild")
	static int gameBuild;
	@ObfuscatedName("bx")
	@Export("isMembersWorld")
	public static boolean isMembersWorld;
	@ObfuscatedName("bc")
	@Export("isLowDetail")
	static boolean isLowDetail;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = 285214129
	)
	@Export("clientType")
	static int clientType;
	@ObfuscatedName("ba")
	@Export("onMobile")
	static boolean onMobile;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = -1978456723
	)
	@Export("gameState")
	static int gameState;
	@ObfuscatedName("cf")
	@Export("isLoading")
	static boolean isLoading;
	@ObfuscatedName("cs")
	@ObfuscatedGetter(
		intValue = 1942837123
	)
	@Export("cycle")
	static int cycle;
	@ObfuscatedName("ch")
	@ObfuscatedGetter(
		longValue = 9167305382877438331L
	)
	@Export("mouseLastLastPressedTimeMillis")
	static long mouseLastLastPressedTimeMillis;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = 785556091
	)
	static int field642;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = -284349487
	)
	static int field681;
	@ObfuscatedName("ck")
	@ObfuscatedGetter(
		longValue = 2095221084394078139L
	)
	static long field728;
	@ObfuscatedName("ce")
	@Export("hadFocus")
	static boolean hadFocus;
	@ObfuscatedName("cu")
	@Export("displayFps")
	static boolean displayFps;
	@ObfuscatedName("cg")
	@ObfuscatedGetter(
		intValue = -2127828035
	)
	@Export("rebootTimer")
	static int rebootTimer;
	@ObfuscatedName("ct")
	@ObfuscatedGetter(
		intValue = 1251218153
	)
	@Export("hintArrowType")
	static int hintArrowType;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = -643479427
	)
	@Export("hintArrowNpcIndex")
	static int hintArrowNpcIndex;
	@ObfuscatedName("cy")
	@ObfuscatedGetter(
		intValue = -2133905465
	)
	@Export("hintArrowPlayerIndex")
	static int hintArrowPlayerIndex;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = 1969776841
	)
	@Export("hintArrowX")
	static int hintArrowX;
	@ObfuscatedName("cm")
	@ObfuscatedGetter(
		intValue = -206701331
	)
	@Export("hintArrowY")
	static int hintArrowY;
	@ObfuscatedName("cl")
	@ObfuscatedGetter(
		intValue = -959107052
	)
	@Export("hintArrowHeight")
	static int hintArrowHeight;
	@ObfuscatedName("ci")
	@ObfuscatedGetter(
		intValue = 1849140865
	)
	@Export("hintArrowSubX")
	static int hintArrowSubX;
	@ObfuscatedName("cc")
	@ObfuscatedGetter(
		intValue = 1728405841
	)
	@Export("hintArrowSubY")
	static int hintArrowSubY;
	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		signature = "Lcf;"
	)
	@Export("playerAttackOption")
	static AttackOption playerAttackOption;
	@ObfuscatedName("do")
	@ObfuscatedSignature(
		signature = "Lcf;"
	)
	@Export("npcAttackOption")
	static AttackOption npcAttackOption;
	@ObfuscatedName("dx")
	@ObfuscatedGetter(
		intValue = -727124447
	)
	@Export("titleLoadingStage")
	static int titleLoadingStage;
	@ObfuscatedName("di")
	@ObfuscatedGetter(
		intValue = 1173358373
	)
	@Export("js5ConnectState")
	static int js5ConnectState;
	@ObfuscatedName("dr")
	@ObfuscatedGetter(
		intValue = -1353267399
	)
	static int field660;
	@ObfuscatedName("ek")
	@ObfuscatedGetter(
		intValue = -509949081
	)
	@Export("js5Errors")
	static int js5Errors;
	@ObfuscatedName("ew")
	@ObfuscatedGetter(
		intValue = -492792025
	)
	@Export("loginState")
	static int loginState;
	@ObfuscatedName("ep")
	@ObfuscatedGetter(
		intValue = 303516097
	)
	static int field663;
	@ObfuscatedName("er")
	@ObfuscatedGetter(
		intValue = -27008237
	)
	static int field740;
	@ObfuscatedName("es")
	@ObfuscatedGetter(
		intValue = -427416641
	)
	static int field665;
	@ObfuscatedName("eq")
	@ObfuscatedSignature(
		signature = "Lfv;"
	)
	static class160 field743;
	@ObfuscatedName("eg")
	@Export("Login_isUsernameRemembered")
	static boolean Login_isUsernameRemembered;
	@ObfuscatedName("ec")
	@ObfuscatedSignature(
		signature = "Lcn;"
	)
	@Export("secureRandomFuture")
	static SecureRandomFuture secureRandomFuture;
	@ObfuscatedName("ea")
	@Export("randomDatData")
	static byte[] randomDatData;
	@ObfuscatedName("eb")
	@ObfuscatedSignature(
		signature = "[Lcp;"
	)
	@Export("npcs")
	static NPC[] npcs;
	@ObfuscatedName("em")
	@ObfuscatedGetter(
		intValue = -712593235
	)
	@Export("npcCount")
	static int npcCount;
	@ObfuscatedName("fd")
	@Export("npcIndices")
	static int[] npcIndices;
	@ObfuscatedName("ff")
	@ObfuscatedGetter(
		intValue = 278898125
	)
	static int field673;
	@ObfuscatedName("fe")
	static int[] field720;
	@ObfuscatedName("fo")
	@ObfuscatedSignature(
		signature = "Lcr;"
	)
	@Export("packetWriter")
	public static final PacketWriter packetWriter;
	@ObfuscatedName("fn")
	@ObfuscatedGetter(
		intValue = 2048559591
	)
	@Export("logoutTimer")
	static int logoutTimer;
	@ObfuscatedName("fy")
	static boolean field677;
	@ObfuscatedName("fu")
	@Export("useBufferedSocket")
	static boolean useBufferedSocket;
	@ObfuscatedName("fl")
	@ObfuscatedSignature(
		signature = "Ljx;"
	)
	@Export("timer")
	static Timer timer;
	@ObfuscatedName("fp")
	@Export("fontsMap")
	static HashMap fontsMap;
	@ObfuscatedName("fi")
	@ObfuscatedGetter(
		intValue = 1305702889
	)
	static int field824;
	@ObfuscatedName("fj")
	@ObfuscatedGetter(
		intValue = 2025601593
	)
	static int field859;
	@ObfuscatedName("fz")
	@ObfuscatedGetter(
		intValue = -244261703
	)
	static int field683;
	@ObfuscatedName("gw")
	@ObfuscatedGetter(
		intValue = 1006687669
	)
	static int field684;
	@ObfuscatedName("ga")
	@ObfuscatedGetter(
		intValue = -958408065
	)
	static int field734;
	@ObfuscatedName("gd")
	@Export("isInInstance")
	static boolean isInInstance;
	@ObfuscatedName("gb")
	@Export("instanceChunkTemplates")
	static int[][][] instanceChunkTemplates;
	@ObfuscatedName("gi")
	static final int[] field689;
	@ObfuscatedName("gt")
	@ObfuscatedGetter(
		intValue = -480027501
	)
	static int field690;
	@ObfuscatedName("he")
	@ObfuscatedGetter(
		intValue = -43720627
	)
	static int field691;
	@ObfuscatedName("hd")
	@ObfuscatedGetter(
		intValue = -895055541
	)
	static int field692;
	@ObfuscatedName("hj")
	@ObfuscatedGetter(
		intValue = 97511831
	)
	static int field693;
	@ObfuscatedName("hy")
	@ObfuscatedGetter(
		intValue = -1638312043
	)
	static int field694;
	@ObfuscatedName("hu")
	static boolean field695;
	@ObfuscatedName("ht")
	@ObfuscatedGetter(
		intValue = -1245138777
	)
	@Export("alternativeScrollbarWidth")
	static int alternativeScrollbarWidth;
	@ObfuscatedName("hv")
	@ObfuscatedGetter(
		intValue = 161071957
	)
	@Export("camAngleX")
	static int camAngleX;
	@ObfuscatedName("hc")
	@ObfuscatedGetter(
		intValue = 1782454389
	)
	@Export("camAngleY")
	static int camAngleY;
	@ObfuscatedName("hw")
	@ObfuscatedGetter(
		intValue = -1982031919
	)
	@Export("camAngleDY")
	static int camAngleDY;
	@ObfuscatedName("hm")
	@ObfuscatedGetter(
		intValue = 1897616521
	)
	@Export("camAngleDX")
	static int camAngleDX;
	@ObfuscatedName("hf")
	@ObfuscatedGetter(
		intValue = 1783666051
	)
	@Export("mouseCamClickedX")
	static int mouseCamClickedX;
	@ObfuscatedName("hl")
	@ObfuscatedGetter(
		intValue = -346780995
	)
	@Export("mouseCamClickedY")
	static int mouseCamClickedY;
	@ObfuscatedName("hk")
	@ObfuscatedGetter(
		intValue = 1183996551
	)
	@Export("oculusOrbState")
	static int oculusOrbState;
	@ObfuscatedName("hp")
	@ObfuscatedGetter(
		intValue = -1225679861
	)
	@Export("camFollowHeight")
	static int camFollowHeight;
	@ObfuscatedName("ho")
	@ObfuscatedGetter(
		intValue = 354489243
	)
	static int field705;
	@ObfuscatedName("hz")
	@ObfuscatedGetter(
		intValue = -2121988069
	)
	static int field706;
	@ObfuscatedName("ih")
	@ObfuscatedGetter(
		intValue = 693041111
	)
	static int field632;
	@ObfuscatedName("ie")
	@ObfuscatedGetter(
		intValue = 1625985575
	)
	@Export("oculusOrbNormalSpeed")
	static int oculusOrbNormalSpeed;
	@ObfuscatedName("ic")
	@ObfuscatedGetter(
		intValue = -5930147
	)
	@Export("oculusOrbSlowedSpeed")
	static int oculusOrbSlowedSpeed;
	@ObfuscatedName("ia")
	@ObfuscatedGetter(
		intValue = 959698373
	)
	public static int field710;
	@ObfuscatedName("ip")
	static boolean field751;
	@ObfuscatedName("im")
	@ObfuscatedGetter(
		intValue = -1249522927
	)
	static int field712;
	@ObfuscatedName("it")
	@Export("selectedItemName")
	static String selectedItemName;
	@ObfuscatedName("ir")
	static boolean field713;
	@ObfuscatedName("il")
	@ObfuscatedGetter(
		intValue = -2096925203
	)
	static int field714;
	@ObfuscatedName("iy")
	@ObfuscatedGetter(
		intValue = -712265205
	)
	@Export("overheadTextCount")
	static int overheadTextCount;
	@ObfuscatedName("io")
	@ObfuscatedGetter(
		intValue = 1274484349
	)
	@Export("overheadTextLimit")
	static int overheadTextLimit;
	@ObfuscatedName("iu")
	@Export("overheadTextXs")
	static int[] overheadTextXs;
	@ObfuscatedName("iq")
	@Export("overheadTextYs")
	static int[] overheadTextYs;
	@ObfuscatedName("ij")
	@Export("overheadTextAscents")
	static int[] overheadTextAscents;
	@ObfuscatedName("is")
	@Export("overheadTextXOffsets")
	static int[] overheadTextXOffsets;
	@ObfuscatedName("ik")
	@Export("overheadTextColors")
	static int[] overheadTextColors;
	@ObfuscatedName("id")
	@Export("overheadTextEffects")
	static int[] overheadTextEffects;
	@ObfuscatedName("ig")
	@Export("overheadTextCyclesRemaining")
	static int[] overheadTextCyclesRemaining;
	@ObfuscatedName("ii")
	@Export("overheadText")
	static String[] overheadText;
	@ObfuscatedName("iw")
	@Export("tileLastDrawnActor")
	static int[][] tileLastDrawnActor;
	@ObfuscatedName("ib")
	@ObfuscatedGetter(
		intValue = 1082148805
	)
	@Export("viewportDrawCount")
	static int viewportDrawCount;
	@ObfuscatedName("iv")
	@ObfuscatedGetter(
		intValue = 1604718859
	)
	@Export("viewportTempX")
	static int viewportTempX;
	@ObfuscatedName("in")
	@ObfuscatedGetter(
		intValue = 141110117
	)
	@Export("viewportTempY")
	static int viewportTempY;
	@ObfuscatedName("jl")
	@ObfuscatedGetter(
		intValue = 1442681791
	)
	@Export("mouseCrossX")
	static int mouseCrossX;
	@ObfuscatedName("js")
	@ObfuscatedGetter(
		intValue = -267915889
	)
	@Export("mouseCrossY")
	static int mouseCrossY;
	@ObfuscatedName("jw")
	@ObfuscatedGetter(
		intValue = 1233219852
	)
	@Export("mouseCrossState")
	static int mouseCrossState;
	@ObfuscatedName("jo")
	@ObfuscatedGetter(
		intValue = -557514861
	)
	@Export("mouseCrossColor")
	static int mouseCrossColor;
	@ObfuscatedName("ja")
	@Export("showMouseCross")
	static boolean showMouseCross;
	@ObfuscatedName("jn")
	@ObfuscatedGetter(
		intValue = 1412380751
	)
	static int field764;
	@ObfuscatedName("jh")
	@ObfuscatedGetter(
		intValue = -1293433949
	)
	static int field735;
	@ObfuscatedName("jk")
	@ObfuscatedGetter(
		intValue = -958619817
	)
	@Export("dragItemSlotSource")
	static int dragItemSlotSource;
	@ObfuscatedName("jx")
	@ObfuscatedGetter(
		intValue = 1858822219
	)
	static int field863;
	@ObfuscatedName("jd")
	@ObfuscatedGetter(
		intValue = 1449162079
	)
	static int field738;
	@ObfuscatedName("jy")
	@ObfuscatedGetter(
		intValue = -1787846911
	)
	@Export("dragItemSlotDestination")
	static int dragItemSlotDestination;
	@ObfuscatedName("jm")
	static boolean field768;
	@ObfuscatedName("ju")
	@ObfuscatedGetter(
		intValue = -353478655
	)
	@Export("itemDragDuration")
	static int itemDragDuration;
	@ObfuscatedName("jb")
	@ObfuscatedGetter(
		intValue = -1748491077
	)
	static int field678;
	@ObfuscatedName("jt")
	@Export("showLoadingMessages")
	static boolean showLoadingMessages;
	@ObfuscatedName("jf")
	@ObfuscatedSignature(
		signature = "[Lbn;"
	)
	@Export("players")
	static Player[] players;
	@ObfuscatedName("jc")
	@ObfuscatedGetter(
		intValue = -1257096167
	)
	@Export("localPlayerIndex")
	static int localPlayerIndex;
	@ObfuscatedName("jq")
	@ObfuscatedGetter(
		intValue = -1822880047
	)
	static int field746;
	@ObfuscatedName("jj")
	@Export("renderSelf")
	static boolean renderSelf;
	@ObfuscatedName("kf")
	@ObfuscatedGetter(
		intValue = 1400486467
	)
	@Export("drawPlayerNames")
	static int drawPlayerNames;
	@ObfuscatedName("kk")
	@ObfuscatedGetter(
		intValue = -1772541191
	)
	static int field815;
	@ObfuscatedName("ki")
	static int[] field745;
	@ObfuscatedName("kn")
	@Export("playerMenuOpcodes")
	static final int[] playerMenuOpcodes;
	@ObfuscatedName("ka")
	@Export("playerMenuActions")
	static String[] playerMenuActions;
	@ObfuscatedName("km")
	@Export("playerOptionsPriorities")
	static boolean[] playerOptionsPriorities;
	@ObfuscatedName("ks")
	@Export("defaultRotations")
	static int[] defaultRotations;
	@ObfuscatedName("kl")
	@ObfuscatedGetter(
		intValue = -1980827323
	)
	@Export("combatTargetPlayerIndex")
	static int combatTargetPlayerIndex;
	@ObfuscatedName("kq")
	@ObfuscatedSignature(
		signature = "[[[Ljs;"
	)
	@Export("groundItems")
	static NodeDeque[][][] groundItems;
	@ObfuscatedName("kh")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("pendingSpawns")
	static NodeDeque pendingSpawns;
	@ObfuscatedName("kj")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("projectiles")
	static NodeDeque projectiles;
	@ObfuscatedName("kv")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("graphicsObjects")
	static NodeDeque graphicsObjects;
	@ObfuscatedName("kp")
	@Export("currentLevels")
	static int[] currentLevels;
	@ObfuscatedName("ky")
	@Export("levels")
	static int[] levels;
	@ObfuscatedName("kw")
	@Export("experience")
	static int[] experience;
	@ObfuscatedName("kb")
	@ObfuscatedGetter(
		intValue = -1271914129
	)
	@Export("leftClickOpensMenu")
	static int leftClickOpensMenu;
	@ObfuscatedName("kg")
	@Export("isMenuOpen")
	static boolean isMenuOpen;
	@ObfuscatedName("lf")
	@ObfuscatedGetter(
		intValue = -1021045037
	)
	@Export("menuOptionsCount")
	static int menuOptionsCount;
	@ObfuscatedName("lv")
	@Export("menuArguments1")
	static int[] menuArguments1;
	@ObfuscatedName("lc")
	@Export("menuArguments2")
	static int[] menuArguments2;
	@ObfuscatedName("la")
	@Export("menuOpcodes")
	static int[] menuOpcodes;
	@ObfuscatedName("le")
	@Export("menuIdentifiers")
	static int[] menuIdentifiers;
	@ObfuscatedName("lh")
	@Export("menuActions")
	static String[] menuActions;
	@ObfuscatedName("lo")
	@Export("menuTargets")
	static String[] menuTargets;
	@ObfuscatedName("lj")
	@Export("menuShiftClick")
	static boolean[] menuShiftClick;
	@ObfuscatedName("lk")
	@Export("followerOpsLowPriority")
	static boolean followerOpsLowPriority;
	@ObfuscatedName("li")
	@Export("shiftClickDrop")
	static boolean shiftClickDrop;
	@ObfuscatedName("ls")
	@Export("tapToDrop")
	static boolean tapToDrop;
	@ObfuscatedName("lz")
	@Export("showMouseOverText")
	static boolean showMouseOverText;
	@ObfuscatedName("ln")
	@ObfuscatedGetter(
		intValue = 981856147
	)
	@Export("viewportX")
	static int viewportX;
	@ObfuscatedName("lr")
	@ObfuscatedGetter(
		intValue = -1679083747
	)
	@Export("viewportY")
	static int viewportY;
	@ObfuscatedName("lm")
	@ObfuscatedGetter(
		intValue = 1613029861
	)
	static int field798;
	@ObfuscatedName("ld")
	@ObfuscatedGetter(
		intValue = -1066881411
	)
	static int field674;
	@ObfuscatedName("lw")
	@ObfuscatedGetter(
		intValue = -134952871
	)
	@Export("isItemSelected")
	static int isItemSelected;
	@ObfuscatedName("lu")
	@Export("isSpellSelected")
	static boolean isSpellSelected;
	@ObfuscatedName("ll")
	@ObfuscatedGetter(
		intValue = -1987429727
	)
	@Export("selectedSpellChildIndex")
	static int selectedSpellChildIndex;
	@ObfuscatedName("mj")
	@ObfuscatedGetter(
		intValue = -1680716253
	)
	static int field785;
	@ObfuscatedName("mg")
	@Export("selectedSpellActionName")
	static String selectedSpellActionName;
	@ObfuscatedName("my")
	@Export("selectedSpellName")
	static String selectedSpellName;
	@ObfuscatedName("mk")
	@ObfuscatedGetter(
		intValue = -1055224191
	)
	@Export("rootInterface")
	static int rootInterface;

	static {
		field895 = true;
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
		field642 = -1;
		field681 = -1;
		field728 = -1L;
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
		field660 = 0;
		js5Errors = 0;
		loginState = 0;
		field663 = 0;
		field740 = 0;
		field665 = 0;
		field743 = class160.field1985;
		Login_isUsernameRemembered = false;
		secureRandomFuture = new SecureRandomFuture();
		randomDatData = null;
		npcs = new NPC[32768];
		npcCount = 0;
		npcIndices = new int[32768];
		field673 = 0;
		field720 = new int[250];
		packetWriter = new PacketWriter();
		logoutTimer = 0;
		field677 = false;
		useBufferedSocket = true;
		timer = new Timer();
		fontsMap = new HashMap();
		field824 = 0;
		field859 = 1;
		field683 = 0;
		field684 = 1;
		field734 = 0;
		collisionMaps = new CollisionMap[4];
		isInInstance = false;
		instanceChunkTemplates = new int[4][13][13];
		field689 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
		field690 = 0;
		field691 = 2301979;
		field692 = 5063219;
		field693 = 3353893;
		field694 = 7759444;
		field695 = false;
		alternativeScrollbarWidth = 0;
		camAngleX = 128;
		camAngleY = 0;
		camAngleDY = 0;
		camAngleDX = 0;
		mouseCamClickedX = 0;
		mouseCamClickedY = 0;
		oculusOrbState = 0;
		camFollowHeight = 50;
		field705 = 0;
		field706 = 0;
		field632 = 0;
		oculusOrbNormalSpeed = 12;
		oculusOrbSlowedSpeed = 6;
		field710 = 0;
		field751 = false;
		field712 = 0;
		field713 = false;
		field714 = 0;
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
		field764 = 0;
		field735 = 0;
		dragItemSlotSource = 0;
		field863 = 0;
		field738 = 0;
		dragItemSlotDestination = 0;
		field768 = false;
		itemDragDuration = 0;
		field678 = 0;
		showLoadingMessages = true;
		players = new Player[2048];
		localPlayerIndex = -1;
		field746 = 0;
		renderSelf = true;
		drawPlayerNames = 0;
		field815 = 0;
		field745 = new int[1000];
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
		field798 = 0;
		field674 = 50;
		isItemSelected = 0;
		selectedItemName = null;
		isSpellSelected = false;
		selectedSpellChildIndex = -1;
		field785 = -1;
		selectedSpellActionName = null;
		selectedSpellName = null;
		rootInterface = -1;
		interfaceParents = new NodeHashTable(8);
		field790 = 0;
		field791 = -1;
		chatEffects = 0;
		field901 = 0;
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
		field806 = false;
		field807 = -1;
		field808 = -1;
		field809 = false;
		field882 = -1;
		field811 = -1;
		isDraggingWidget = false;
		cycleCntr = 1;
		field814 = new int[32];
		field648 = 0;
		changedItemContainers = new int[32];
		field701 = 0;
		changedSkills = new int[32];
		changedSkillsCount = 0;
		chatCycle = 0;
		field711 = 0;
		field862 = 0;
		field823 = 0;
		field860 = 0;
		field825 = 0;
		mouseWheelRotation = 0;
		scriptEvents = new NodeDeque();
		field865 = new NodeDeque();
		field883 = new NodeDeque();
		widgetClickMasks = new NodeHashTable(512);
		rootWidgetCount = 0;
		field832 = -2;
		field833 = new boolean[100];
		field834 = new boolean[100];
		field835 = new boolean[100];
		rootWidgetXs = new int[100];
		rootWidgetYs = new int[100];
		rootWidgetWidths = new int[100];
		rootWidgetHeights = new int[100];
		gameDrawingMode = 0;
		field841 = 0L;
		isResizable = true;
		field864 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
		publicChatMode = 0;
		tradeChatMode = 0;
		field846 = "";
		field707 = new long[100];
		field682 = 0;
		field849 = 0;
		field850 = new int[128];
		field851 = new int[128];
		field852 = -1L;
		field853 = -1;
		mapIconCount = 0;
		mapIconXs = new int[1000];
		mapIconYs = new int[1000];
		mapIcons = new Sprite[1000];
		destinationX = 0;
		destinationY = 0;
		minimapState = 0;
		musicVolume = 255;
		currentTrackGroupId = -1;
		field767 = false;
		soundEffectVolume = 127;
		areaSoundEffectVolume = 127;
		soundEffectCount = 0;
		soundEffectIds = new int[50];
		queuedSoundEffectLoops = new int[50];
		queuedSoundEffectDelays = new int[50];
		soundLocations = new int[50];
		soundEffects = new SoundEffect[50];
		isCameraLocked = false;
		field779 = new boolean[5];
		field875 = new int[5];
		field876 = new int[5];
		field877 = new int[5];
		field878 = new int[5];
		field879 = 256;
		field880 = 205;
		zoomHeight = 256;
		zoomWidth = 320;
		field796 = 1;
		field884 = 32767;
		field804 = 1;
		field886 = 32767;
		viewportOffsetX = 0;
		viewportOffsetY = 0;
		viewportWidth = 0;
		viewportHeight = 0;
		viewportZoom = 0;
		playerAppearance = new PlayerAppearance();
		field893 = -1;
		field894 = -1;
		platformInfoProvider = new DesktopPlatformInfoProvider();
		grandExchangeOffers = new GrandExchangeOffer[8];
		GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
		field749 = -1;
		archiveLoaders = new ArrayList(10);
		archiveLoadersDone = 0;
		field629 = 0;
		field902 = new class65();
		field903 = new int[50];
		field730 = new int[50];
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1309389764"
	)
	@Export("resizeGame")
	protected final void resizeGame() {
		field841 = WorldMapID.currentTimeMillis() + 500L;
		this.resizeJS();
		if (rootInterface != -1) {
			this.resizeRoot(true);
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "557803519"
	)
	@Export("setUp")
	protected final void setUp() {
		Players.method2161(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
		class197.port1 = gameBuild == 0 ? 43594 : worldId + 40000;
		MouseRecorder.port2 = gameBuild == 0 ? 443 : worldId + 50000;
		WorldMapData_1.port3 = class197.port1;
		PlayerAppearance.field2525 = class215.field2529;
		WorldMapSection1.field269 = class215.field2533;
		IntHashTable.field4010 = class215.field2531;
		CollisionMap.field2066 = class215.field2532;
		BufferedNetSocket.urlRequester = new UrlRequester();
		this.setUpKeyboard();
		this.setUpMouse();
		MusicPatch.mouseWheel = this.mouseWheel();
		WorldMapRectangle.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		AccessFile var2 = null;
		ClientPreferences var3 = new ClientPreferences();

		try {
			var2 = Messages.getPreferencesFile("", AbstractWorldMapIcon.field284.name, false);
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

		Interpreter.clientPreferences = var3;
		this.setUpClipboard();
		class3.method39(this, GameShell.null_string);
		if (gameBuild != 0) {
			displayFps = true;
		}

		class60.setWindowedMode(Interpreter.clientPreferences.windowMode);
		Message.friendSystem = new FriendSystem(class188.loginType);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1971545072"
	)
	@Export("doCycle")
	protected final void doCycle() {
		++cycle;
		this.doCycleJs5();
		class173.method3560();

		int var1;
		try {
			if (class197.field2392 == 1) {
				var1 = GZipDecompressor.midiPcmStream.method3692();
				if (var1 > 0 && GZipDecompressor.midiPcmStream.isReady()) {
					var1 -= ParamDefinition.field3275;
					if (var1 < 0) {
						var1 = 0;
					}

					GZipDecompressor.midiPcmStream.setPcmStreamVolume(var1);
				} else {
					GZipDecompressor.midiPcmStream.clear();
					GZipDecompressor.midiPcmStream.removeAll();
					if (Coord.musicTrackArchive != null) {
						class197.field2392 = 2;
					} else {
						class197.field2392 = 0;
					}

					class197.musicTrack = null;
					class268.soundCache = null;
				}
			}
		} catch (Exception var35) {
			var35.printStackTrace();
			GZipDecompressor.midiPcmStream.clear();
			class197.field2392 = 0;
			class197.musicTrack = null;
			class268.soundCache = null;
			Coord.musicTrackArchive = null;
		}

		WorldMapLabel.playPcmPlayers();
		int var2;
		synchronized(KeyHandler.KeyHandler_instance) {
			++KeyHandler.KeyHandler_idleCycles;
			KeyHandler.field378 = KeyHandler.field380;
			KeyHandler.field377 = 0;
			if (KeyHandler.field373 >= 0) {
				while (KeyHandler.field372 != KeyHandler.field373) {
					var2 = KeyHandler.field371[KeyHandler.field372];
					KeyHandler.field372 = KeyHandler.field372 + 1 & 127;
					if (var2 < 0) {
						KeyHandler.KeyHandler_pressedKeys[~var2] = false;
					} else {
						if (!KeyHandler.KeyHandler_pressedKeys[var2] && KeyHandler.field377 < KeyHandler.field376.length - 1) {
							KeyHandler.field376[++KeyHandler.field377 - 1] = var2;
						}

						KeyHandler.KeyHandler_pressedKeys[var2] = true;
					}
				}
			} else {
				for (var2 = 0; var2 < 112; ++var2) {
					KeyHandler.KeyHandler_pressedKeys[var2] = false;
				}

				KeyHandler.field373 = KeyHandler.field372;
			}

			if (KeyHandler.field377 > 0) {
				KeyHandler.KeyHandler_idleCycles = 0;
			}

			KeyHandler.field380 = KeyHandler.field386;
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

		if (MusicPatch.mouseWheel != null) {
			var1 = MusicPatch.mouseWheel.useRotation();
			mouseWheelRotation = var1;
		}

		if (gameState == 0) {
			WorldMapRegion.load();
			Skeleton.method3088();
		} else if (gameState == 5) {
			UserComparator8.doCycleTitle(this);
			WorldMapRegion.load();
			Skeleton.method3088();
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				UserComparator8.doCycleTitle(this);
				this.doCycleLoggedOut();
			} else if (gameState == 25) {
				CollisionMap.method3557(false);
				field824 = 0;
				boolean var36 = true;

				for (var2 = 0; var2 < Projectile.regionLandArchives.length; ++var2) {
					if (SecureRandomFuture.regionMapArchiveIds[var2] != -1 && Projectile.regionLandArchives[var2] == null) {
						Projectile.regionLandArchives[var2] = AbstractWorldMapData.archive5.takeFile(SecureRandomFuture.regionMapArchiveIds[var2], 0);
						if (Projectile.regionLandArchives[var2] == null) {
							var36 = false;
							++field824;
						}
					}

					if (class222.regionLandArchiveIds[var2] != -1 && GrandExchangeOfferOwnWorldComparator.regionMapArchives[var2] == null) {
						GrandExchangeOfferOwnWorldComparator.regionMapArchives[var2] = AbstractWorldMapData.archive5.takeFileEncrypted(class222.regionLandArchiveIds[var2], 0, Canvas.xteaKeys[var2]);
						if (GrandExchangeOfferOwnWorldComparator.regionMapArchives[var2] == null) {
							var36 = false;
							++field824;
						}
					}
				}

				if (!var36) {
					field734 = 1;
				} else {
					field683 = 0;
					var36 = true;

					int var5;
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
					int var25;
					for (var2 = 0; var2 < Projectile.regionLandArchives.length; ++var2) {
						byte[] var3 = GrandExchangeOfferOwnWorldComparator.regionMapArchives[var2];
						if (var3 != null) {
							var25 = (WorldMapSection2.regions[var2] >> 8) * 64 - MusicPatchPcmStream.baseX * 64;
							var5 = (WorldMapSection2.regions[var2] & 255) * 64 - ScriptEvent.baseY * 64;
							if (isInInstance) {
								var25 = 10;
								var5 = 10;
							}

							boolean var8 = true;
							var9 = new Buffer(var3);
							var10 = -1;

							label694:
							while (true) {
								var11 = var9.method5558();
								if (var11 == 0) {
									var36 &= var8;
									break;
								}

								var10 += var11;
								var12 = 0;
								boolean var13 = false;

								while (true) {
									while (!var13) {
										var14 = var9.readUShortSmart();
										if (var14 == 0) {
											continue label694;
										}

										var12 += var14 - 1;
										var15 = var12 & 63;
										var16 = var12 >> 6 & 63;
										var17 = var9.readUnsignedByte() >> 2;
										var18 = var16 + var25;
										var19 = var15 + var5;
										if (var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
											ObjectDefinition var20 = Coord.getObjectDefinition(var10);
											if (var17 != 22 || !isLowDetail || var20.int1 != 0 || var20.interactType == 1 || var20.boolean2) {
												if (!var20.needsModelFiles()) {
													++field683;
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

					if (!var36) {
						field734 = 2;
					} else {
						if (field734 != 0) {
							class1.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
						}

						WorldMapLabel.playPcmPlayers();
						class14.scene.clear();

						for (var2 = 0; var2 < 4; ++var2) {
							collisionMaps[var2].clear();
						}

						int var26;
						for (var2 = 0; var2 < 4; ++var2) {
							for (var26 = 0; var26 < 104; ++var26) {
								for (var25 = 0; var25 < 104; ++var25) {
									Tiles.Tiles_renderFlags[var2][var26][var25] = 0;
								}
							}
						}

						WorldMapLabel.playPcmPlayers();
						WorldMapIcon_1.method277();
						var2 = Projectile.regionLandArchives.length;
						WorldMapSectionType.method236();
						CollisionMap.method3557(true);
						int var6;
						int var7;
						int var39;
						int var41;
						if (!isInInstance) {
							var26 = 0;

							label632:
							while (true) {
								byte[] var27;
								if (var26 >= var2) {
									for (var26 = 0; var26 < var2; ++var26) {
										var25 = (WorldMapSection2.regions[var26] >> 8) * 64 - MusicPatchPcmStream.baseX * 64;
										var5 = (WorldMapSection2.regions[var26] & 255) * 64 - ScriptEvent.baseY * 64;
										var27 = Projectile.regionLandArchives[var26];
										if (var27 == null && ClanMate.field3567 < 800) {
											WorldMapLabel.playPcmPlayers();
											GrandExchangeOffer.method114(var25, var5, 64, 64);
										}
									}

									CollisionMap.method3557(true);
									var26 = 0;

									while (true) {
										if (var26 >= var2) {
											break label632;
										}

										byte[] var4 = GrandExchangeOfferOwnWorldComparator.regionMapArchives[var26];
										if (var4 != null) {
											var5 = (WorldMapSection2.regions[var26] >> 8) * 64 - MusicPatchPcmStream.baseX * 64;
											var6 = (WorldMapSection2.regions[var26] & 255) * 64 - ScriptEvent.baseY * 64;
											WorldMapLabel.playPcmPlayers();
											Scene var29 = class14.scene;
											CollisionMap[] var30 = collisionMaps;
											var9 = new Buffer(var4);
											var10 = -1;

											while (true) {
												var11 = var9.method5558();
												if (var11 == 0) {
													break;
												}

												var10 += var11;
												var12 = 0;

												while (true) {
													var41 = var9.readUShortSmart();
													if (var41 == 0) {
														break;
													}

													var12 += var41 - 1;
													var14 = var12 & 63;
													var15 = var12 >> 6 & 63;
													var16 = var12 >> 12;
													var17 = var9.readUnsignedByte();
													var18 = var17 >> 2;
													var19 = var17 & 3;
													int var31 = var15 + var5;
													int var21 = var6 + var14;
													if (var31 > 0 && var21 > 0 && var31 < 103 && var21 < 103) {
														int var22 = var16;
														if ((Tiles.Tiles_renderFlags[1][var31][var21] & 2) == 2) {
															var22 = var16 - 1;
														}

														CollisionMap var23 = null;
														if (var22 >= 0) {
															var23 = var30[var22];
														}

														VarbitDefinition.method4500(var16, var31, var21, var10, var19, var18, var29, var23);
													}
												}
											}
										}

										++var26;
									}
								}

								var25 = (WorldMapSection2.regions[var26] >> 8) * 64 - MusicPatchPcmStream.baseX * 64;
								var5 = (WorldMapSection2.regions[var26] & 255) * 64 - ScriptEvent.baseY * 64;
								var27 = Projectile.regionLandArchives[var26];
								if (var27 != null) {
									WorldMapLabel.playPcmPlayers();
									var7 = GrandExchangeOfferTotalQuantityComparator.field47 * 8 - 48;
									var39 = ClanMate.field3567 * 8 - 48;
									CollisionMap[] var40 = collisionMaps;
									var10 = 0;

									label629:
									while (true) {
										if (var10 >= 4) {
											Buffer var28 = new Buffer(var27);
											var11 = 0;

											while (true) {
												if (var11 >= 4) {
													break label629;
												}

												for (var12 = 0; var12 < 64; ++var12) {
													for (var41 = 0; var41 < 64; ++var41) {
														PrivateChatMode.loadTerrain(var28, var11, var25 + var12, var5 + var41, var7, var39, 0);
													}
												}

												++var11;
											}
										}

										for (var11 = 0; var11 < 64; ++var11) {
											for (var12 = 0; var12 < 64; ++var12) {
												if (var25 + var11 > 0 && var11 + var25 < 103 && var5 + var12 > 0 && var5 + var12 < 103) {
													int[] var10000 = var40[var10].flags[var11 + var25];
													var10000[var12 + var5] &= -16777217;
												}
											}
										}

										++var10;
									}
								}

								++var26;
							}
						}

						int var32;
						if (isInInstance) {
							var26 = 0;

							label565:
							while (true) {
								if (var26 >= 4) {
									for (var26 = 0; var26 < 13; ++var26) {
										for (var25 = 0; var25 < 13; ++var25) {
											var5 = instanceChunkTemplates[0][var26][var25];
											if (var5 == -1) {
												GrandExchangeOffer.method114(var26 * 8, var25 * 8, 8, 8);
											}
										}
									}

									CollisionMap.method3557(true);
									var26 = 0;

									while (true) {
										if (var26 >= 4) {
											break label565;
										}

										WorldMapLabel.playPcmPlayers();

										for (var25 = 0; var25 < 13; ++var25) {
											for (var5 = 0; var5 < 13; ++var5) {
												var6 = instanceChunkTemplates[var26][var25][var5];
												if (var6 != -1) {
													var7 = var6 >> 24 & 3;
													var39 = var6 >> 1 & 3;
													var32 = var6 >> 14 & 1023;
													var10 = var6 >> 3 & 2047;
													var11 = (var32 / 8 << 8) + var10 / 8;

													for (var12 = 0; var12 < WorldMapSection2.regions.length; ++var12) {
														if (WorldMapSection2.regions[var12] == var11 && GrandExchangeOfferOwnWorldComparator.regionMapArchives[var12] != null) {
															UserComparator7.method3344(GrandExchangeOfferOwnWorldComparator.regionMapArchives[var12], var26, var25 * 8, var5 * 8, var7, (var32 & 7) * 8, (var10 & 7) * 8, var39, class14.scene, collisionMaps);
															break;
														}
													}
												}
											}
										}

										++var26;
									}
								}

								WorldMapLabel.playPcmPlayers();

								for (var25 = 0; var25 < 13; ++var25) {
									for (var5 = 0; var5 < 13; ++var5) {
										boolean var38 = false;
										var7 = instanceChunkTemplates[var26][var25][var5];
										if (var7 != -1) {
											var39 = var7 >> 24 & 3;
											var32 = var7 >> 1 & 3;
											var10 = var7 >> 14 & 1023;
											var11 = var7 >> 3 & 2047;
											var12 = (var10 / 8 << 8) + var11 / 8;

											for (var41 = 0; var41 < WorldMapSection2.regions.length; ++var41) {
												if (WorldMapSection2.regions[var41] == var12 && Projectile.regionLandArchives[var41] != null) {
													class48.method858(Projectile.regionLandArchives[var41], var26, var25 * 8, var5 * 8, var39, (var10 & 7) * 8, (var11 & 7) * 8, var32, collisionMaps);
													var38 = true;
													break;
												}
											}
										}

										if (!var38) {
											var39 = var26;
											var32 = var25 * 8;
											var10 = var5 * 8;

											for (var11 = 0; var11 < 8; ++var11) {
												for (var12 = 0; var12 < 8; ++var12) {
													Tiles.Tiles_heights[var39][var32 + var11][var10 + var12] = 0;
												}
											}

											if (var32 > 0) {
												for (var11 = 1; var11 < 8; ++var11) {
													Tiles.Tiles_heights[var39][var32][var11 + var10] = Tiles.Tiles_heights[var39][var32 - 1][var10 + var11];
												}
											}

											if (var10 > 0) {
												for (var11 = 1; var11 < 8; ++var11) {
													Tiles.Tiles_heights[var39][var11 + var32][var10] = Tiles.Tiles_heights[var39][var32 + var11][var10 - 1];
												}
											}

											if (var32 > 0 && Tiles.Tiles_heights[var39][var32 - 1][var10] != 0) {
												Tiles.Tiles_heights[var39][var32][var10] = Tiles.Tiles_heights[var39][var32 - 1][var10];
											} else if (var10 > 0 && Tiles.Tiles_heights[var39][var32][var10 - 1] != 0) {
												Tiles.Tiles_heights[var39][var32][var10] = Tiles.Tiles_heights[var39][var32][var10 - 1];
											} else if (var32 > 0 && var10 > 0 && Tiles.Tiles_heights[var39][var32 - 1][var10 - 1] != 0) {
												Tiles.Tiles_heights[var39][var32][var10] = Tiles.Tiles_heights[var39][var32 - 1][var10 - 1];
											}
										}
									}
								}

								++var26;
							}
						}

						CollisionMap.method3557(true);
						WorldMapLabel.playPcmPlayers();
						Language.method3624(class14.scene, collisionMaps);
						CollisionMap.method3557(true);
						var26 = Tiles.Tiles_minPlane;
						if (var26 > UrlRequest.Client_plane) {
							var26 = UrlRequest.Client_plane;
						}

						if (var26 < UrlRequest.Client_plane - 1) {
							var26 = UrlRequest.Client_plane - 1;
						}

						if (isLowDetail) {
							class14.scene.init(Tiles.Tiles_minPlane);
						} else {
							class14.scene.init(0);
						}

						for (var25 = 0; var25 < 104; ++var25) {
							for (var5 = 0; var5 < 104; ++var5) {
								Skills.updateItemPile(var25, var5);
							}
						}

						WorldMapLabel.playPcmPlayers();
						class32.method556();
						ObjectDefinition.ObjectDefinition_cachedModelData.clear();
						PacketBufferNode var37;
						if (class206.client.hasFrame()) {
							var37 = class2.getPacketBufferNode(ClientPacket.field2180, packetWriter.isaacCipher);
							var37.packetBuffer.writeInt(1057001181);
							packetWriter.addNode(var37);
						}

						if (!isInInstance) {
							var25 = (GrandExchangeOfferTotalQuantityComparator.field47 - 6) / 8;
							var5 = (GrandExchangeOfferTotalQuantityComparator.field47 + 6) / 8;
							var6 = (ClanMate.field3567 - 6) / 8;
							var7 = (ClanMate.field3567 + 6) / 8;

							for (var39 = var25 - 1; var39 <= var5 + 1; ++var39) {
								for (var32 = var6 - 1; var32 <= var7 + 1; ++var32) {
									if (var39 < var25 || var39 > var5 || var32 < var6 || var32 > var7) {
										AbstractWorldMapData.archive5.loadRegionFromName("m" + var39 + "_" + var32);
										AbstractWorldMapData.archive5.loadRegionFromName("l" + var39 + "_" + var32);
									}
								}
							}
						}

						class195.updateGameState(30);
						WorldMapLabel.playPcmPlayers();
						MusicPatchNode2.method3669();
						var37 = class2.getPacketBufferNode(ClientPacket.field2176, packetWriter.isaacCipher);
						packetWriter.addNode(var37);
						Skeleton.method3088();
					}
				}
			}
		} else {
			UserComparator8.doCycleTitle(this);
		}

		if (gameState == 30) {
			this.doCycleLoggedIn();
		} else if (gameState == 40 || gameState == 45) {
			this.doCycleLoggedOut();
		}

	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1655647135"
	)
	@Export("draw")
	protected final void draw(boolean var1) {
		boolean var2 = WorldMapCacheName.method619();
		if (var2 && field767 && UserComparator6.pcmPlayer0 != null) {
			UserComparator6.pcmPlayer0.tryDiscard();
		}

		if ((gameState == 10 || gameState == 20 || gameState == 30) && field841 != 0L && WorldMapID.currentTimeMillis() > field841) {
			class60.setWindowedMode(ItemDefinition.getWindowedMode());
		}

		int var3;
		if (var1) {
			for (var3 = 0; var3 < 100; ++var3) {
				field833[var3] = true;
			}
		}

		if (gameState == 0) {
			this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
		} else if (gameState == 5) {
			MidiPcmStream.drawTitle(GrandExchangeOffer.fontBold12, class3.fontPlain11, ScriptFrame.fontPlain12);
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				MidiPcmStream.drawTitle(GrandExchangeOffer.fontBold12, class3.fontPlain11, ScriptFrame.fontPlain12);
			} else if (gameState == 25) {
				if (field734 == 1) {
					if (field824 > field859) {
						field859 = field824;
					}

					var3 = (field859 * 50 - field824 * 50) / field859;
					class1.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
				} else if (field734 == 2) {
					if (field683 > field684) {
						field684 = field683;
					}

					var3 = (field684 * 50 - field683 * 50) / field684 + 50;
					class1.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
				} else {
					class1.drawLoadingMessage("Loading - please wait.", false);
				}
			} else if (gameState == 30) {
				this.drawLoggedIn();
			} else if (gameState == 40) {
				class1.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
			} else if (gameState == 45) {
				class1.drawLoadingMessage("Please wait...", false);
			}
		} else {
			MidiPcmStream.drawTitle(GrandExchangeOffer.fontBold12, class3.fontPlain11, ScriptFrame.fontPlain12);
		}

		if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
			for (var3 = 0; var3 < rootWidgetCount; ++var3) {
				if (field834[var3]) {
					IgnoreList.rasterProvider.draw(rootWidgetXs[var3], rootWidgetYs[var3], rootWidgetWidths[var3], rootWidgetHeights[var3]);
					field834[var3] = false;
				}
			}
		} else if (gameState > 0) {
			IgnoreList.rasterProvider.drawFull(0, 0);

			for (var3 = 0; var3 < rootWidgetCount; ++var3) {
				field834[var3] = false;
			}
		}

	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1818676977"
	)
	@Export("kill0")
	protected final void kill0() {
		if (MilliClock.varcs.hasUnwrittenChanges()) {
			MilliClock.varcs.write();
		}

		if (class173.mouseRecorder != null) {
			class173.mouseRecorder.isRunning = false;
		}

		class173.mouseRecorder = null;
		packetWriter.close();
		class179.method3579();
		if (MouseHandler.MouseHandler_instance != null) {
			synchronized(MouseHandler.MouseHandler_instance) {
				MouseHandler.MouseHandler_instance = null;
			}
		}

		MusicPatch.mouseWheel = null;
		if (UserComparator6.pcmPlayer0 != null) {
			UserComparator6.pcmPlayer0.shutdown();
		}

		if (NetSocket.pcmPlayer1 != null) {
			NetSocket.pcmPlayer1.shutdown();
		}

		ScriptEvent.method1183();
		class192.method3655();
		if (BufferedNetSocket.urlRequester != null) {
			BufferedNetSocket.urlRequester.close();
			BufferedNetSocket.urlRequester = null;
		}

		try {
			JagexCache.JagexCache_dat2File.close();

			for (int var3 = 0; var3 < JagexCache.idxCount; ++var3) {
				AttackOption.JagexCache_idxFiles[var3].close();
			}

			JagexCache.JagexCache_idx255File.close();
			JagexCache.JagexCache_randomDat.close();
		} catch (Exception var5) {
		}

	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1677674321"
	)
	protected final void vmethod1290() {
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
							Language var14;
							if (var4 >= 0 && var4 < Language.Language_valuesOrdered.length) {
								var14 = Language.Language_valuesOrdered[var4];
							} else {
								var14 = null;
							}

							Varps.clientLanguage = var14;
							break;
						case 7:
							var4 = Integer.parseInt(var2);
							ServerBuild[] var5 = new ServerBuild[]{ServerBuild.BUILDLIVE, ServerBuild.WIP, ServerBuild.LIVE, ServerBuild.RC};
							ServerBuild[] var6 = var5;
							int var7 = 0;

							ServerBuild var13;
							while (true) {
								if (var7 >= var6.length) {
									var13 = null;
									break;
								}

								ServerBuild var8 = var6[var7];
								if (var4 == var8.field3081) {
									var13 = var8;
									break;
								}

								++var7;
							}

							class48.field402 = var13;
							break;
						case 8:
							if (var2.equalsIgnoreCase("true")) {
							}
							break;
						case 9:
							UserComparator10.field1943 = var2;
							break;
						case 10:
							StudioGame[] var3 = new StudioGame[]{StudioGame.stellardawn, StudioGame.game3, StudioGame.runescape, StudioGame.game4, StudioGame.oldscape, StudioGame.game5};
							AbstractWorldMapIcon.field284 = (StudioGame)DynamicObject.findEnumerated(var3, Integer.parseInt(var2));
							if (AbstractWorldMapIcon.field284 == StudioGame.oldscape) {
								class188.loginType = LoginType.oldscape;
							} else {
								class188.loginType = LoginType.field4031;
							}
							break;
						case 12:
							worldId = Integer.parseInt(var2);
							break;
						case 14:
							MouseRecorder.field564 = Integer.parseInt(var2);
							break;
						case 15:
							gameBuild = Integer.parseInt(var2);
							break;
						case 17:
							TextureProvider.field1510 = var2;
						}
					}
				}

				AbstractArchive.method4222();
				CollisionMap.worldHost = this.getCodeBase().getHost();
				String var9 = class48.field402.name;
				byte var10 = 0;

				try {
					WorldMapRegion.method504("oldschool", var9, var10, 21);
				} catch (Exception var11) {
					DesktopPlatformInfoProvider.RunException_sendStackTrace((String)null, var11);
				}

				class206.client = this;
				RunException.clientType = clientType;
				this.startThread(765, 503, 187);
			}
		} catch (RuntimeException var12) {
			throw WorldMapAreaData.newRunException(var12, "client.init(" + ')');
		}
	}

	@ObfuscatedName("ff")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-67"
	)
	@Export("doCycleJs5")
	void doCycleJs5() {
		if (gameState != 1000) {
			long var2 = WorldMapID.currentTimeMillis();
			int var4 = (int)(var2 - NetCache.field3138);
			NetCache.field3138 = var2;
			if (var4 > 200) {
				var4 = 200;
			}

			NetCache.NetCache_loadTime += var4;
			boolean var1;
			if (NetCache.NetCache_pendingResponsesCount == 0 && NetCache.NetCache_pendingPriorityResponsesCount == 0 && NetCache.NetCache_pendingWritesCount == 0 && NetCache.NetCache_pendingPriorityWritesCount == 0) {
				var1 = true;
			} else if (class297.NetCache_socket == null) {
				var1 = false;
			} else {
				try {
					label241: {
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
							class297.NetCache_socket.write(var6.array, 0, 4);
							NetCache.NetCache_pendingPriorityResponses.put(var5, var5.key);
							--NetCache.NetCache_pendingPriorityWritesCount;
							++NetCache.NetCache_pendingPriorityResponsesCount;
						}

						while (NetCache.NetCache_pendingResponsesCount < 200 && NetCache.NetCache_pendingWritesCount > 0) {
							var5 = (NetFileRequest)NetCache.NetCache_pendingWritesQueue.removeLast();
							var6 = new Buffer(4);
							var6.writeByte(0);
							var6.writeMedium((int)var5.key);
							class297.NetCache_socket.write(var6.array, 0, 4);
							var5.removeDual();
							NetCache.NetCache_pendingResponses.put(var5, var5.key);
							--NetCache.NetCache_pendingWritesCount;
							++NetCache.NetCache_pendingResponsesCount;
						}

						for (int var17 = 0; var17 < 100; ++var17) {
							int var18 = class297.NetCache_socket.available();
							if (var18 < 0) {
								throw new IOException();
							}

							if (var18 == 0) {
								break;
							}

							NetCache.NetCache_loadTime = 0;
							byte var7 = 0;
							if (PrivateChatMode.NetCache_currentResponse == null) {
								var7 = 8;
							} else if (NetCache.field3150 == 0) {
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

								class297.NetCache_socket.read(NetCache.NetCache_responseHeaderBuffer.array, NetCache.NetCache_responseHeaderBuffer.offset, var8);
								if (NetCache.field3145 != 0) {
									for (var9 = 0; var9 < var8; ++var9) {
										var10000 = NetCache.NetCache_responseHeaderBuffer.array;
										var10001 = var9 + NetCache.NetCache_responseHeaderBuffer.offset;
										var10000[var10001] ^= NetCache.field3145;
									}
								}

								var25 = NetCache.NetCache_responseHeaderBuffer;
								var25.offset += var8;
								if (NetCache.NetCache_responseHeaderBuffer.offset < var7) {
									break;
								}

								if (PrivateChatMode.NetCache_currentResponse == null) {
									NetCache.NetCache_responseHeaderBuffer.offset = 0;
									var9 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
									var10 = NetCache.NetCache_responseHeaderBuffer.readUnsignedShort();
									int var11 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
									var12 = NetCache.NetCache_responseHeaderBuffer.readInt();
									long var13 = (long)(var10 + (var9 << 16));
									NetFileRequest var15 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.get(var13);
									class14.field89 = true;
									if (var15 == null) {
										var15 = (NetFileRequest)NetCache.NetCache_pendingResponses.get(var13);
										class14.field89 = false;
									}

									if (var15 == null) {
										throw new IOException();
									}

									int var16 = var11 == 0 ? 5 : 9;
									PrivateChatMode.NetCache_currentResponse = var15;
									NetCache.NetCache_responseArchiveBuffer = new Buffer(var16 + var12 + PrivateChatMode.NetCache_currentResponse.padding);
									NetCache.NetCache_responseArchiveBuffer.writeByte(var11);
									NetCache.NetCache_responseArchiveBuffer.writeInt(var12);
									NetCache.field3150 = 8;
									NetCache.NetCache_responseHeaderBuffer.offset = 0;
								} else if (NetCache.field3150 == 0) {
									if (NetCache.NetCache_responseHeaderBuffer.array[0] == -1) {
										NetCache.field3150 = 1;
										NetCache.NetCache_responseHeaderBuffer.offset = 0;
									} else {
										PrivateChatMode.NetCache_currentResponse = null;
									}
								}
							} else {
								var8 = NetCache.NetCache_responseArchiveBuffer.array.length - PrivateChatMode.NetCache_currentResponse.padding;
								var9 = 512 - NetCache.field3150;
								if (var9 > var8 - NetCache.NetCache_responseArchiveBuffer.offset) {
									var9 = var8 - NetCache.NetCache_responseArchiveBuffer.offset;
								}

								if (var9 > var18) {
									var9 = var18;
								}

								class297.NetCache_socket.read(NetCache.NetCache_responseArchiveBuffer.array, NetCache.NetCache_responseArchiveBuffer.offset, var9);
								if (NetCache.field3145 != 0) {
									for (var10 = 0; var10 < var9; ++var10) {
										var10000 = NetCache.NetCache_responseArchiveBuffer.array;
										var10001 = NetCache.NetCache_responseArchiveBuffer.offset + var10;
										var10000[var10001] ^= NetCache.field3145;
									}
								}

								var25 = NetCache.NetCache_responseArchiveBuffer;
								var25.offset += var9;
								NetCache.field3150 += var9;
								if (var8 == NetCache.NetCache_responseArchiveBuffer.offset) {
									if (16711935L == PrivateChatMode.NetCache_currentResponse.key) {
										NetCache.NetCache_reference = NetCache.NetCache_responseArchiveBuffer;

										for (var10 = 0; var10 < 256; ++var10) {
											Archive var19 = NetCache.NetCache_archives[var10];
											if (var19 != null) {
												NetCache.NetCache_reference.offset = var10 * 8 + 5;
												var12 = NetCache.NetCache_reference.readInt();
												int var20 = NetCache.NetCache_reference.readInt();
												var19.loadIndex(var12, var20);
											}
										}
									} else {
										NetCache.NetCache_crc.reset();
										NetCache.NetCache_crc.update(NetCache.NetCache_responseArchiveBuffer.array, 0, var8);
										var10 = (int)NetCache.NetCache_crc.getValue();
										if (var10 != PrivateChatMode.NetCache_currentResponse.crc) {
											try {
												class297.NetCache_socket.close();
											} catch (Exception var23) {
											}

											++NetCache.NetCache_crcMismatches;
											class297.NetCache_socket = null;
											NetCache.field3145 = (byte)((int)(Math.random() * 255.0D + 1.0D));
											var1 = false;
											break label241;
										}

										NetCache.NetCache_crcMismatches = 0;
										NetCache.NetCache_ioExceptions = 0;
										PrivateChatMode.NetCache_currentResponse.archive.write((int)(PrivateChatMode.NetCache_currentResponse.key & 65535L), NetCache.NetCache_responseArchiveBuffer.array, (PrivateChatMode.NetCache_currentResponse.key & 16711680L) == 16711680L, class14.field89);
									}

									PrivateChatMode.NetCache_currentResponse.remove();
									if (class14.field89) {
										--NetCache.NetCache_pendingPriorityResponsesCount;
									} else {
										--NetCache.NetCache_pendingResponsesCount;
									}

									NetCache.field3150 = 0;
									PrivateChatMode.NetCache_currentResponse = null;
									NetCache.NetCache_responseArchiveBuffer = null;
								} else {
									if (NetCache.field3150 != 512) {
										break;
									}

									NetCache.field3150 = 0;
								}
							}
						}

						var1 = true;
					}
				} catch (IOException var24) {
					try {
						class297.NetCache_socket.close();
					} catch (Exception var22) {
					}

					++NetCache.NetCache_ioExceptions;
					class297.NetCache_socket = null;
					var1 = false;
				}
			}

			if (!var1) {
				this.doCycleJs5Connect();
			}

		}
	}

	@ObfuscatedName("fe")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "-21988"
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

				field660 = 3000;
				NetCache.NetCache_ioExceptions = 3;
			}

			if (--field660 + 1 <= 0) {
				try {
					if (js5ConnectState == 0) {
						SecureRandomCallable.js5SocketTask = GameShell.taskHandler.newSocketTask(CollisionMap.worldHost, WorldMapData_1.port3);
						++js5ConnectState;
					}

					if (js5ConnectState == 1) {
						if (SecureRandomCallable.js5SocketTask.status == 2) {
							this.js5Error(-1);
							return;
						}

						if (SecureRandomCallable.js5SocketTask.status == 1) {
							++js5ConnectState;
						}
					}

					if (js5ConnectState == 2) {
						if (useBufferedSocket) {
							ModelData0.js5Socket = Buddy.method5215((Socket)SecureRandomCallable.js5SocketTask.result, 40000, 5000);
						} else {
							ModelData0.js5Socket = new NetSocket((Socket)SecureRandomCallable.js5SocketTask.result, GameShell.taskHandler, 5000);
						}

						Buffer var1 = new Buffer(5);
						var1.writeByte(15);
						var1.writeInt(187);
						ModelData0.js5Socket.write(var1.array, 0, 5);
						++js5ConnectState;
						ItemContainer.field519 = WorldMapID.currentTimeMillis();
					}

					if (js5ConnectState == 3) {
						if (ModelData0.js5Socket.available() > 0 || !useBufferedSocket && gameState <= 5) {
							int var2 = ModelData0.js5Socket.readUnsignedByte();
							if (var2 != 0) {
								this.js5Error(var2);
								return;
							}

							++js5ConnectState;
						} else if (WorldMapID.currentTimeMillis() - ItemContainer.field519 > 30000L) {
							this.js5Error(-2);
							return;
						}
					}

					if (js5ConnectState == 4) {
						FriendsList.method5229(ModelData0.js5Socket, gameState > 20);
						SecureRandomCallable.js5SocketTask = null;
						ModelData0.js5Socket = null;
						js5ConnectState = 0;
						js5Errors = 0;
					}
				} catch (IOException var3) {
					this.js5Error(-3);
				}

			}
		}
	}

	@ObfuscatedName("fk")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1925866063"
	)
	@Export("js5Error")
	void js5Error(int var1) {
		SecureRandomCallable.js5SocketTask = null;
		ModelData0.js5Socket = null;
		js5ConnectState = 0;
		if (WorldMapData_1.port3 == class197.port1) {
			WorldMapData_1.port3 = MouseRecorder.port2;
		} else {
			WorldMapData_1.port3 = class197.port1;
		}

		++js5Errors;
		if (js5Errors >= 2 && (var1 == 7 || var1 == 9)) {
			if (gameState <= 5) {
				this.error("js5connect_full");
				gameState = 1000;
			} else {
				field660 = 3000;
			}
		} else if (js5Errors >= 2 && var1 == 6) {
			this.error("js5connect_outofdate");
			gameState = 1000;
		} else if (js5Errors >= 4) {
			if (gameState <= 5) {
				this.error("js5connect");
				gameState = 1000;
			} else {
				field660 = 3000;
			}
		}

	}

	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-443791919"
	)
	@Export("doCycleLoggedOut")
	final void doCycleLoggedOut() {
		Object var1 = packetWriter.getSocket();
		PacketBuffer var2 = packetWriter.packetBuffer;

		try {
			if (loginState == 0) {
				if (Login.secureRandom == null && (secureRandomFuture.isDone() || field663 > 250)) {
					Login.secureRandom = secureRandomFuture.get();
					secureRandomFuture.shutdown();
					secureRandomFuture = null;
				}

				if (Login.secureRandom != null) {
					if (var1 != null) {
						((AbstractSocket)var1).close();
						var1 = null;
					}

					MenuAction.socketTask = null;
					field677 = false;
					field663 = 0;
					loginState = 1;
				}
			}

			if (loginState == 1) {
				if (MenuAction.socketTask == null) {
					MenuAction.socketTask = GameShell.taskHandler.newSocketTask(CollisionMap.worldHost, WorldMapData_1.port3);
				}

				if (MenuAction.socketTask.status == 2) {
					throw new IOException();
				}

				if (MenuAction.socketTask.status == 1) {
					if (useBufferedSocket) {
						var1 = Buddy.method5215((Socket)MenuAction.socketTask.result, 40000, 5000);
					} else {
						var1 = new NetSocket((Socket)MenuAction.socketTask.result, GameShell.taskHandler, 5000);
					}

					packetWriter.setSocket((AbstractSocket)var1);
					MenuAction.socketTask = null;
					loginState = 2;
				}
			}

			if (loginState == 2) {
				packetWriter.clearBuffer();
				PacketBufferNode var4;
				if (PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0) {
					var4 = new PacketBufferNode();
				} else {
					var4 = PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
				}

				var4.clientPacket = null;
				var4.clientPacketLength = 0;
				var4.packetBuffer = new PacketBuffer(5000);
				var4.packetBuffer.writeByte(LoginPacket.field2282.id);
				packetWriter.addNode(var4);
				packetWriter.flush();
				var2.offset = 0;
				loginState = 3;
			}

			boolean var13;
			int var14;
			if (loginState == 3) {
				if (UserComparator6.pcmPlayer0 != null) {
					UserComparator6.pcmPlayer0.method2472();
				}

				if (NetSocket.pcmPlayer1 != null) {
					NetSocket.pcmPlayer1.method2472();
				}

				var13 = true;
				if (useBufferedSocket && !((AbstractSocket)var1).isAvailable(1)) {
					var13 = false;
				}

				if (var13) {
					var14 = ((AbstractSocket)var1).readUnsignedByte();
					if (UserComparator6.pcmPlayer0 != null) {
						UserComparator6.pcmPlayer0.method2472();
					}

					if (NetSocket.pcmPlayer1 != null) {
						NetSocket.pcmPlayer1.method2472();
					}

					if (var14 != 0) {
						ModelData0.getLoginError(var14);
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
					class2.field4 = var2.readLong();
					loginState = 5;
				}
			}

			if (loginState == 5) {
				packetWriter.packetBuffer.offset = 0;
				packetWriter.clearBuffer();
				PacketBuffer var3 = new PacketBuffer(500);
				int[] var22 = new int[]{Login.secureRandom.nextInt(), Login.secureRandom.nextInt(), Login.secureRandom.nextInt(), Login.secureRandom.nextInt()};
				var3.offset = 0;
				var3.writeByte(1);
				var3.writeInt(var22[0]);
				var3.writeInt(var22[1]);
				var3.writeInt(var22[2]);
				var3.writeInt(var22[3]);
				var3.writeLong(class2.field4);
				if (gameState == 40) {
					var3.writeInt(GrandExchangeOfferOwnWorldComparator.field626[0]);
					var3.writeInt(GrandExchangeOfferOwnWorldComparator.field626[1]);
					var3.writeInt(GrandExchangeOfferOwnWorldComparator.field626[2]);
					var3.writeInt(GrandExchangeOfferOwnWorldComparator.field626[3]);
				} else {
					var3.writeByte(field743.rsOrdinal());
					switch(field743.field1987) {
					case 0:
					case 1:
						var3.writeMedium(class266.field3517);
						++var3.offset;
						break;
					case 2:
						var3.writeInt((Integer)Interpreter.clientPreferences.parameters.get(UrlRequester.method3299(Login.Login_username)));
						break;
					case 3:
						var3.offset += 4;
					}

					var3.writeByte(class312.field3813.rsOrdinal());
					var3.writeStringCp1252NullTerminated(Login.Login_password);
				}

				var3.encryptRsa(class83.field1144, class83.field1142);
				GrandExchangeOfferOwnWorldComparator.field626 = var22;
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
					var6.packetBuffer.writeByte(LoginPacket.field2283.id);
				} else {
					var6.packetBuffer.writeByte(LoginPacket.field2285.id);
				}

				var6.packetBuffer.writeShort(0);
				int var15 = var6.packetBuffer.offset;
				var6.packetBuffer.writeInt(187);
				var6.packetBuffer.writeInt(1);
				var6.packetBuffer.writeByte(clientType);
				var6.packetBuffer.writeBytes(var3.array, 0, var3.offset);
				int var8 = var6.packetBuffer.offset;
				var6.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
				var6.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
				var6.packetBuffer.writeShort(GrandExchangeOfferTotalQuantityComparator.canvasWidth);
				var6.packetBuffer.writeShort(AttackOption.canvasHeight);
				PacketBuffer var9 = var6.packetBuffer;
				if (randomDatData != null) {
					var9.writeBytes(randomDatData, 0, randomDatData.length);
				} else {
					byte[] var10 = MenuAction.method2068();
					var9.writeBytes(var10, 0, var10.length);
				}

				var6.packetBuffer.writeStringCp1252NullTerminated(UserComparator10.field1943);
				var6.packetBuffer.writeInt(MouseRecorder.field564);
				Buffer var27 = new Buffer(class42.platformInfo.size());
				class42.platformInfo.write(var27);
				var6.packetBuffer.writeBytes(var27.array, 0, var27.array.length);
				var6.packetBuffer.writeByte(clientType);
				var6.packetBuffer.writeInt(0);
				var6.packetBuffer.writeInt(ClientPacket.archive0.hash);
				var6.packetBuffer.writeInt(ItemDefinition.archive1.hash);
				var6.packetBuffer.writeInt(class2.archive2.hash);
				var6.packetBuffer.writeInt(WorldMapData_1.archive3.hash);
				var6.packetBuffer.writeInt(FloorDecoration.archive4.hash);
				var6.packetBuffer.writeInt(AbstractWorldMapData.archive5.hash);
				var6.packetBuffer.writeInt(GrandExchangeOfferWorldComparator.archive6.hash);
				var6.packetBuffer.writeInt(MouseRecorder.archive7.hash);
				var6.packetBuffer.writeInt(class3.archive8.hash);
				var6.packetBuffer.writeInt(WorldMapManager.archive9.hash);
				var6.packetBuffer.writeInt(ServerBuild.archive10.hash);
				var6.packetBuffer.writeInt(class48.archive11.hash);
				var6.packetBuffer.writeInt(SoundSystem.archive12.hash);
				var6.packetBuffer.writeInt(WorldMapSection1.archive13.hash);
				var6.packetBuffer.writeInt(class117.archive14.hash);
				var6.packetBuffer.writeInt(GrandExchangeOfferTotalQuantityComparator.archive15.hash);
				var6.packetBuffer.writeInt(0);
				var6.packetBuffer.writeInt(GrandExchangeOfferNameComparator.archive17.hash);
				var6.packetBuffer.writeInt(AbstractWorldMapData.archive18.hash);
				var6.packetBuffer.writeInt(MusicPatchNode2.archive19.hash);
				var6.packetBuffer.writeInt(UserComparator9.archive20.hash);
				var6.packetBuffer.xteaEncrypt(var22, var8, var6.packetBuffer.offset);
				var6.packetBuffer.writeLengthShort(var6.packetBuffer.offset - var15);
				packetWriter.addNode(var6);
				packetWriter.flush();
				packetWriter.isaacCipher = new IsaacCipher(var22);
				int[] var11 = new int[4];

				for (int var12 = 0; var12 < 4; ++var12) {
					var11[var12] = var22[var12] + 50;
				}

				var2.newIsaacCipher(var11);
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
				} else if (var28 == 23 && field740 < 1) {
					++field740;
					loginState = 0;
				} else {
					if (var28 != 29) {
						ModelData0.getLoginError(var28);
						return;
					}

					loginState = 14;
				}
			}

			if (loginState == 7 && ((AbstractSocket)var1).available() > 0) {
				ClanMate.field3566 = ((AbstractSocket)var1).readUnsignedByte();
				loginState = 8;
			}

			if (loginState == 8 && ((AbstractSocket)var1).available() >= ClanMate.field3566) {
				((AbstractSocket)var1).read(var2.array, 0, ClanMate.field3566);
				var2.offset = 0;
				loginState = 6;
			}

			if (loginState == 9 && ((AbstractSocket)var1).available() > 0) {
				field665 = (((AbstractSocket)var1).readUnsignedByte() + 3) * 60;
				loginState = 10;
			}

			if (loginState == 10) {
				field663 = 0;
				AbstractWorldMapData.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field665 / 60 + " seconds.");
				if (--field665 <= 0) {
					loginState = 0;
				}

			} else {
				if (loginState == 11 && ((AbstractSocket)var1).available() >= 1) {
					class54.field482 = ((AbstractSocket)var1).readUnsignedByte();
					loginState = 12;
				}

				int var16;
				if (loginState == 12 && ((AbstractSocket)var1).available() >= class54.field482) {
					var13 = ((AbstractSocket)var1).readUnsignedByte() == 1;
					((AbstractSocket)var1).read(var2.array, 0, 4);
					var2.offset = 0;
					boolean var29 = false;
					if (var13) {
						var14 = var2.readByteIsaac() << 24;
						var14 |= var2.readByteIsaac() << 16;
						var14 |= var2.readByteIsaac() << 8;
						var14 |= var2.readByteIsaac();
						var16 = UrlRequester.method3299(Login.Login_username);
						if (Interpreter.clientPreferences.parameters.size() >= 10 && !Interpreter.clientPreferences.parameters.containsKey(var16)) {
							Iterator var26 = Interpreter.clientPreferences.parameters.entrySet().iterator();
							var26.next();
							var26.remove();
						}

						Interpreter.clientPreferences.parameters.put(var16, var14);
					}

					if (Login_isUsernameRemembered) {
						Interpreter.clientPreferences.rememberedUsername = Login.Login_username;
					} else {
						Interpreter.clientPreferences.rememberedUsername = null;
					}

					FriendSystem.savePreferences();
					staffModLevel = ((AbstractSocket)var1).readUnsignedByte();
					playerMod = ((AbstractSocket)var1).readUnsignedByte() == 1;
					localPlayerIndex = ((AbstractSocket)var1).readUnsignedByte();
					localPlayerIndex <<= 8;
					localPlayerIndex += ((AbstractSocket)var1).readUnsignedByte();
					field746 = ((AbstractSocket)var1).readUnsignedByte();
					((AbstractSocket)var1).read(var2.array, 0, 1);
					var2.offset = 0;
					ServerPacket[] var5 = class162.ServerPacket_values();
					int var17 = var2.readSmartByteShortIsaac();
					if (var17 < 0 || var17 >= var5.length) {
						throw new IOException(var17 + " " + var2.offset);
					}

					packetWriter.serverPacket = var5[var17];
					packetWriter.serverPacketLength = packetWriter.serverPacket.length;
					((AbstractSocket)var1).read(var2.array, 0, 2);
					var2.offset = 0;
					packetWriter.serverPacketLength = var2.readUnsignedShort();

					try {
						Client var7 = class206.client;
						JSObject.getWindow(var7).call("zap", (Object[])null);
					} catch (Throwable var18) {
					}

					loginState = 13;
				}

				if (loginState != 13) {
					if (loginState == 14 && ((AbstractSocket)var1).available() >= 2) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, 2);
						var2.offset = 0;
						WorldMapDecoration.field195 = var2.readUnsignedShort();
						loginState = 15;
					}

					if (loginState == 15 && ((AbstractSocket)var1).available() >= WorldMapDecoration.field195) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, WorldMapDecoration.field195);
						var2.offset = 0;
						String var21 = var2.readStringCp1252NullTerminated();
						String var25 = var2.readStringCp1252NullTerminated();
						String var23 = var2.readStringCp1252NullTerminated();
						AbstractWorldMapData.setLoginResponseString(var21, var25, var23);
						class195.updateGameState(10);
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
							timer.method5020();
							Interpreter.method2020();
							GraphicsObject.updatePlayer(var2);
							if (var28 != var2.offset) {
								throw new RuntimeException();
							}
						}
					} else {
						++field663;
						if (field663 > 2000) {
							if (field740 < 1) {
								if (class197.port1 == WorldMapData_1.port3) {
									WorldMapData_1.port3 = MouseRecorder.port2;
								} else {
									WorldMapData_1.port3 = class197.port1;
								}

								++field740;
								loginState = 0;
							} else {
								ModelData0.getLoginError(-3);
							}
						}
					}
				} else {
					if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
						timer.method5037();
						mouseLastLastPressedTimeMillis = 1L;
						class173.mouseRecorder.index = 0;
						GameShell.hasFocus = true;
						hadFocus = true;
						field852 = -1L;
						GrandExchangeOfferAgeComparator.method147();
						packetWriter.clearBuffer();
						packetWriter.packetBuffer.offset = 0;
						packetWriter.serverPacket = null;
						packetWriter.field1300 = null;
						packetWriter.field1301 = null;
						packetWriter.field1299 = null;
						packetWriter.serverPacketLength = 0;
						packetWriter.field1298 = 0;
						rebootTimer = 0;
						logoutTimer = 0;
						hintArrowType = 0;
						WorldMapData_1.method708();
						MouseHandler.MouseHandler_idleCycles = 0;
						class54.method1105();
						isItemSelected = 0;
						isSpellSelected = false;
						soundEffectCount = 0;
						camAngleY = 0;
						oculusOrbState = 0;
						class215.field2534 = null;
						minimapState = 0;
						field853 = -1;
						destinationX = 0;
						destinationY = 0;
						playerAttackOption = AttackOption.AttackOption_hidden;
						npcAttackOption = AttackOption.AttackOption_hidden;
						npcCount = 0;
						LoginScreenAnimation.method1831();

						for (var28 = 0; var28 < 2048; ++var28) {
							players[var28] = null;
						}

						for (var28 = 0; var28 < 32768; ++var28) {
							npcs[var28] = null;
						}

						combatTargetPlayerIndex = -1;
						projectiles.clear();
						graphicsObjects.clear();

						for (var28 = 0; var28 < 4; ++var28) {
							for (var14 = 0; var14 < 104; ++var14) {
								for (var16 = 0; var16 < 104; ++var16) {
									groundItems[var28][var14][var16] = null;
								}
							}
						}

						pendingSpawns = new NodeDeque();
						Message.friendSystem.clear();

						for (var28 = 0; var28 < VarpDefinition.VarpDefinition_fileCount; ++var28) {
							VarpDefinition var24 = UserComparator8.VarpDefinition_get(var28);
							if (var24 != null) {
								Varps.Varps_temp[var28] = 0;
								Varps.Varps_main[var28] = 0;
							}
						}

						MilliClock.varcs.clearTransient();
						followerIndex = -1;
						if (rootInterface != -1) {
							ItemDefinition.method4715(rootInterface);
						}

						for (InterfaceParent var20 = (InterfaceParent)interfaceParents.first(); var20 != null; var20 = (InterfaceParent)interfaceParents.next()) {
							VarpDefinition.closeInterface(var20, true);
						}

						rootInterface = -1;
						interfaceParents = new NodeHashTable(8);
						meslayerContinueWidget = null;
						WorldMapData_1.method708();
						playerAppearance.update((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

						for (var28 = 0; var28 < 8; ++var28) {
							playerMenuActions[var28] = null;
							playerOptionsPriorities[var28] = false;
						}

						ItemContainer.itemContainers = new NodeHashTable(32);
						isLoading = true;

						for (var28 = 0; var28 < 100; ++var28) {
							field833[var28] = true;
						}

						class219.method4076();
						Calendar.clanChat = null;

						for (var28 = 0; var28 < 8; ++var28) {
							grandExchangeOffers[var28] = new GrandExchangeOffer();
						}

						Script.grandExchangeEvents = null;
						GraphicsObject.updatePlayer(var2);
						GrandExchangeOfferTotalQuantityComparator.field47 = -1;
						SecureRandomCallable.loadRegions(false, var2);
						packetWriter.serverPacket = null;
					}

				}
			}
		} catch (IOException var19) {
			if (field740 < 1) {
				if (WorldMapData_1.port3 == class197.port1) {
					WorldMapData_1.port3 = MouseRecorder.port2;
				} else {
					WorldMapData_1.port3 = class197.port1;
				}

				++field740;
				loginState = 0;
			} else {
				ModelData0.getLoginError(-2);
			}
		}
	}

	@ObfuscatedName("ft")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1040465625"
	)
	@Export("doCycleLoggedIn")
	final void doCycleLoggedIn() {
		if (rebootTimer > 1) {
			--rebootTimer;
		}

		if (logoutTimer > 0) {
			--logoutTimer;
		}

		if (field677) {
			field677 = false;
			StudioGame.method4119();
		} else {
			if (!isMenuOpen) {
				Actor.addCancelMenuEntry();
			}

			int var1;
			for (var1 = 0; var1 < 100 && this.method1304(packetWriter); ++var1) {
			}

			if (gameState == 30) {
				int var2;
				PacketBufferNode var14;
				while (class210.method3947()) {
					var14 = class2.getPacketBufferNode(ClientPacket.field2187, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					var2 = var14.packetBuffer.offset;
					class60.performReflectionCheck(var14.packetBuffer);
					var14.packetBuffer.writeLengthByte(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
				}

				if (timer.field3555) {
					var14 = class2.getPacketBufferNode(ClientPacket.field2195, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					var2 = var14.packetBuffer.offset;
					timer.write(var14.packetBuffer);
					var14.packetBuffer.writeLengthByte(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
					timer.method5039();
				}

				int var3;
				int var4;
				int var5;
				int var6;
				int var7;
				int var8;
				int var9;
				int var10;
				int var11;
				int var12;
				synchronized(class173.mouseRecorder.lock) {
					if (!field895) {
						class173.mouseRecorder.index = 0;
					} else if (MouseHandler.MouseHandler_lastButton != 0 || class173.mouseRecorder.index >= 40) {
						PacketBufferNode var15 = null;
						var3 = 0;
						var4 = 0;
						var5 = 0;
						var6 = 0;

						for (var7 = 0; var7 < class173.mouseRecorder.index && (var15 == null || var15.packetBuffer.offset - var3 < 246); ++var7) {
							var4 = var7;
							var8 = class173.mouseRecorder.ys[var7];
							if (var8 < -1) {
								var8 = -1;
							} else if (var8 > 65534) {
								var8 = 65534;
							}

							var9 = class173.mouseRecorder.xs[var7];
							if (var9 < -1) {
								var9 = -1;
							} else if (var9 > 65534) {
								var9 = 65534;
							}

							if (var9 != field642 || var8 != field681) {
								if (var15 == null) {
									var15 = class2.getPacketBufferNode(ClientPacket.field2225, packetWriter.isaacCipher);
									var15.packetBuffer.writeByte(0);
									var3 = var15.packetBuffer.offset;
									PacketBuffer var10000 = var15.packetBuffer;
									var10000.offset += 2;
									var5 = 0;
									var6 = 0;
								}

								if (-1L != field728) {
									var10 = var9 - field642;
									var11 = var8 - field681;
									var12 = (int)((class173.mouseRecorder.millis[var7] - field728) / 20L);
									var5 = (int)((long)var5 + (class173.mouseRecorder.millis[var7] - field728) % 20L);
								} else {
									var10 = var9;
									var11 = var8;
									var12 = Integer.MAX_VALUE;
								}

								field642 = var9;
								field681 = var8;
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
								field728 = class173.mouseRecorder.millis[var7];
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

						if (var4 >= class173.mouseRecorder.index) {
							class173.mouseRecorder.index = 0;
						} else {
							MouseRecorder var46 = class173.mouseRecorder;
							var46.index -= var4;
							System.arraycopy(class173.mouseRecorder.xs, var4, class173.mouseRecorder.xs, 0, class173.mouseRecorder.index);
							System.arraycopy(class173.mouseRecorder.ys, var4, class173.mouseRecorder.ys, 0, class173.mouseRecorder.index);
							System.arraycopy(class173.mouseRecorder.millis, var4, class173.mouseRecorder.millis, 0, class173.mouseRecorder.index);
						}
					}
				}

				PacketBufferNode var18;
				if (MouseHandler.MouseHandler_lastButton == 1 || !NetFileRequest.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
					long var16 = MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis * -1L;
					if (var16 > 32767L) {
						var16 = 32767L;
					}

					mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis * -1L;
					var3 = MouseHandler.MouseHandler_lastPressedY;
					if (var3 < 0) {
						var3 = 0;
					} else if (var3 > AttackOption.canvasHeight) {
						var3 = AttackOption.canvasHeight;
					}

					var4 = MouseHandler.MouseHandler_lastPressedX;
					if (var4 < 0) {
						var4 = 0;
					} else if (var4 > GrandExchangeOfferTotalQuantityComparator.canvasWidth) {
						var4 = GrandExchangeOfferTotalQuantityComparator.canvasWidth;
					}

					var5 = (int)var16;
					var18 = class2.getPacketBufferNode(ClientPacket.field2241, packetWriter.isaacCipher);
					var18.packetBuffer.writeShort((var5 << 1) + (MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0));
					var18.packetBuffer.writeShort(var4);
					var18.packetBuffer.writeShort(var3);
					packetWriter.addNode(var18);
				}

				if (KeyHandler.field377 > 0) {
					var14 = class2.getPacketBufferNode(ClientPacket.field2202, packetWriter.isaacCipher);
					var14.packetBuffer.writeShort(0);
					var2 = var14.packetBuffer.offset;
					long var19 = WorldMapID.currentTimeMillis();

					for (var5 = 0; var5 < KeyHandler.field377; ++var5) {
						long var21 = var19 - field852;
						if (var21 > 16777215L) {
							var21 = 16777215L;
						}

						field852 = var19;
						var14.packetBuffer.method5569(KeyHandler.field376[var5]);
						var14.packetBuffer.method5586((int)var21);
					}

					var14.packetBuffer.writeLengthShort(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
				}

				if (field712 > 0) {
					--field712;
				}

				if (KeyHandler.KeyHandler_pressedKeys[96] || KeyHandler.KeyHandler_pressedKeys[97] || KeyHandler.KeyHandler_pressedKeys[98] || KeyHandler.KeyHandler_pressedKeys[99]) {
					field713 = true;
				}

				if (field713 && field712 <= 0) {
					field712 = 20;
					field713 = false;
					var14 = class2.getPacketBufferNode(ClientPacket.field2193, packetWriter.isaacCipher);
					var14.packetBuffer.method5579(camAngleY);
					var14.packetBuffer.method5579(camAngleX);
					packetWriter.addNode(var14);
				}

				if (GameShell.hasFocus && !hadFocus) {
					hadFocus = true;
					var14 = class2.getPacketBufferNode(ClientPacket.field2229, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(1);
					packetWriter.addNode(var14);
				}

				if (!GameShell.hasFocus && hadFocus) {
					hadFocus = false;
					var14 = class2.getPacketBufferNode(ClientPacket.field2229, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					packetWriter.addNode(var14);
				}

				if (GrandExchangeEvent.worldMap != null) {
					GrandExchangeEvent.worldMap.method6357();
				}

				Script.method2244();
				SoundCache.method2509();
				if (gameState == 30) {
					for (PendingSpawn var36 = (PendingSpawn)pendingSpawns.last(); var36 != null; var36 = (PendingSpawn)pendingSpawns.previous()) {
						if (var36.hitpoints > 0) {
							--var36.hitpoints;
						}

						if (var36.hitpoints == 0) {
							if (var36.objectId < 0 || StructDefinition.method4546(var36.objectId, var36.field912)) {
								VarcInt.addPendingSpawnToScene(var36.plane, var36.type, var36.x, var36.y, var36.objectId, var36.field911, var36.field912);
								var36.remove();
							}
						} else {
							if (var36.delay > 0) {
								--var36.delay;
							}

							if (var36.delay == 0 && var36.x >= 1 && var36.y >= 1 && var36.x <= 102 && var36.y <= 102 && (var36.id < 0 || StructDefinition.method4546(var36.id, var36.field918))) {
								VarcInt.addPendingSpawnToScene(var36.plane, var36.type, var36.x, var36.y, var36.id, var36.orientation, var36.field918);
								var36.delay = -1;
								if (var36.id == var36.objectId && var36.objectId == -1) {
									var36.remove();
								} else if (var36.id == var36.objectId && var36.orientation == var36.field911 && var36.field918 == var36.field912) {
									var36.remove();
								}
							}
						}
					}

					WorldMapID.method546();
					++packetWriter.field1298;
					if (packetWriter.field1298 > 750) {
						StudioGame.method4119();
					} else {
						var1 = Players.Players_count;
						int[] var38 = Players.Players_indices;

						for (var3 = 0; var3 < var1; ++var3) {
							Player var23 = players[var38[var3]];
							if (var23 != null) {
								Message.updateActorSequence(var23, 1);
							}
						}

						for (var1 = 0; var1 < npcCount; ++var1) {
							var2 = npcIndices[var1];
							NPC var24 = npcs[var2];
							if (var24 != null) {
								Message.updateActorSequence(var24, var24.definition.size);
							}
						}

						class269.method5014();
						++field690;
						if (mouseCrossColor != 0) {
							mouseCrossState = mouseCrossState * 400 + 400;
							if (mouseCrossState * 20 >= 400) {
								mouseCrossColor = 0;
							}
						}

						if (class192.field2372 != null) {
							++field764;
							if (field764 >= 15) {
								LoginPacket.invalidateWidget(class192.field2372);
								class192.field2372 = null;
							}
						}

						Widget var37 = class16.mousedOverWidgetIf1;
						Widget var39 = class14.field90;
						class16.mousedOverWidgetIf1 = null;
						class14.field90 = null;
						draggedOnWidget = null;
						field809 = false;
						field806 = false;
						field849 = 0;

						while (KeyHandler.isKeyDown() && field849 < 128) {
							if (staffModLevel >= 2 && KeyHandler.KeyHandler_pressedKeys[82] && VertexNormal.field1732 == 66) {
								String var42 = "";

								Message var40;
								for (Iterator var25 = Messages.Messages_hashTable.iterator(); var25.hasNext(); var42 = var42 + var40.sender + ':' + var40.text + '\n') {
									var40 = (Message)var25.next();
								}

								class206.client.clipboardSetString(var42);
							} else if (oculusOrbState != 1 || TileItemPile.field1521 <= 0) {
								field851[field849] = VertexNormal.field1732;
								field850[field849] = TileItemPile.field1521;
								++field849;
							}
						}

						boolean var31 = staffModLevel >= 2;
						PacketBufferNode var26;
						if (var31 && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81] && mouseWheelRotation != 0) {
							var4 = Message.localPlayer.plane - mouseWheelRotation;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > 3) {
								var4 = 3;
							}

							if (var4 != Message.localPlayer.plane) {
								var5 = Message.localPlayer.pathX[0] + MusicPatchPcmStream.baseX * 64;
								var6 = Message.localPlayer.pathY[0] + ScriptEvent.baseY * 64;
								var26 = class2.getPacketBufferNode(ClientPacket.field2251, packetWriter.isaacCipher);
								var26.packetBuffer.writeIntME(var5);
								var26.packetBuffer.writeShortLE(0);
								var26.packetBuffer.writeIntME(var6);
								var26.packetBuffer.method5569(var4);
								packetWriter.addNode(var26);
							}

							mouseWheelRotation = 0;
						}

						if (rootInterface != -1) {
							Buffer.updateRootInterface(rootInterface, 0, 0, GrandExchangeOfferTotalQuantityComparator.canvasWidth, AttackOption.canvasHeight, 0, 0);
						}

						++cycleCntr;

						while (true) {
							Widget var41;
							ScriptEvent var43;
							Widget var45;
							do {
								var43 = (ScriptEvent)field865.removeLast();
								if (var43 == null) {
									while (true) {
										do {
											var43 = (ScriptEvent)field883.removeLast();
											if (var43 == null) {
												while (true) {
													do {
														var43 = (ScriptEvent)scriptEvents.removeLast();
														if (var43 == null) {
															this.menu();
															WorldMapSection1.method584();
															if (clickedWidget != null) {
																this.method1310();
															}

															if (ClientPreferences.dragInventoryWidget != null) {
																LoginPacket.invalidateWidget(ClientPreferences.dragInventoryWidget);
																++itemDragDuration;
																if (MouseHandler.MouseHandler_currentButton == 0) {
																	if (field768) {
																		if (ClientPreferences.dragInventoryWidget == WorldMapManager.field312 && dragItemSlotDestination != dragItemSlotSource) {
																			Widget var44 = ClientPreferences.dragInventoryWidget;
																			byte var33 = 0;
																			if (field901 == 1 && var44.contentType == 206) {
																				var33 = 1;
																			}

																			if (var44.itemIds[dragItemSlotDestination] <= 0) {
																				var33 = 0;
																			}

																			var7 = WorldMapSection0.getWidgetClickMask(var44);
																			boolean var32 = (var7 >> 29 & 1) != 0;
																			if (var32) {
																				var8 = dragItemSlotSource;
																				var9 = dragItemSlotDestination;
																				var44.itemIds[var9] = var44.itemIds[var8];
																				var44.itemQuantities[var9] = var44.itemQuantities[var8];
																				var44.itemIds[var8] = -1;
																				var44.itemQuantities[var8] = 0;
																			} else if (var33 == 1) {
																				var8 = dragItemSlotSource;
																				var9 = dragItemSlotDestination;

																				while (var8 != var9) {
																					if (var8 > var9) {
																						var44.swapItems(var8 - 1, var8);
																						--var8;
																					} else if (var8 < var9) {
																						var44.swapItems(var8 + 1, var8);
																						++var8;
																					}
																				}
																			} else {
																				var44.swapItems(dragItemSlotDestination, dragItemSlotSource);
																			}

																			PacketBufferNode var27 = class2.getPacketBufferNode(ClientPacket.field2183, packetWriter.isaacCipher);
																			var27.packetBuffer.writeInt(ClientPreferences.dragInventoryWidget.id);
																			var27.packetBuffer.method5720(var33);
																			var27.packetBuffer.writeShort(dragItemSlotSource);
																			var27.packetBuffer.writeIntME(dragItemSlotDestination);
																			packetWriter.addNode(var27);
																		}
																	} else if (this.shouldLeftClickOpenMenu()) {
																		this.openMenu(field863, field738);
																	} else if (menuOptionsCount > 0) {
																		var4 = field863;
																		var5 = field738;
																		Messages.method2231(LoginType.tempMenuAction, var4, var5);
																		LoginType.tempMenuAction = null;
																	}

																	field764 = 10;
																	MouseHandler.MouseHandler_lastButton = 0;
																	ClientPreferences.dragInventoryWidget = null;
																} else if (itemDragDuration >= 5 && (MouseHandler.MouseHandler_x > field863 + 5 || MouseHandler.MouseHandler_x < field863 - 5 || MouseHandler.MouseHandler_y > field738 + 5 || MouseHandler.MouseHandler_y < field738 - 5)) {
																	field768 = true;
																}
															}

															if (Scene.method3092()) {
																var4 = Scene.Scene_selectedX;
																var5 = Scene.Scene_selectedY;
																var18 = class2.getPacketBufferNode(ClientPacket.field2278, packetWriter.isaacCipher);
																var18.packetBuffer.writeByte(5);
																var18.packetBuffer.method5696(KeyHandler.KeyHandler_pressedKeys[82] ? (KeyHandler.KeyHandler_pressedKeys[81] ? 2 : 1) : 0);
																var18.packetBuffer.writeShort(MusicPatchPcmStream.baseX * 64 + var4);
																var18.packetBuffer.writeIntME(ScriptEvent.baseY * 64 + var5);
																packetWriter.addNode(var18);
																Scene.method3150();
																mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
																mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
																mouseCrossColor = 1;
																mouseCrossState = 0;
																destinationX = var4;
																destinationY = var5;
															}

															if (var37 != class16.mousedOverWidgetIf1) {
																if (var37 != null) {
																	LoginPacket.invalidateWidget(var37);
																}

																if (class16.mousedOverWidgetIf1 != null) {
																	LoginPacket.invalidateWidget(class16.mousedOverWidgetIf1);
																}
															}

															if (var39 != class14.field90 && field674 == field798) {
																if (var39 != null) {
																	LoginPacket.invalidateWidget(var39);
																}

																if (class14.field90 != null) {
																	LoginPacket.invalidateWidget(class14.field90);
																}
															}

															if (class14.field90 != null) {
																if (field798 < field674) {
																	++field798;
																	if (field674 == field798) {
																		LoginPacket.invalidateWidget(class14.field90);
																	}
																}
															} else if (field798 > 0) {
																--field798;
															}

															if (oculusOrbState == 0) {
																var4 = Message.localPlayer.x;
																var5 = Message.localPlayer.y;
																if (WorldMapSectionType.oculusOrbFocalPointX - var4 < -500 || WorldMapSectionType.oculusOrbFocalPointX - var4 > 500 || Language.oculusOrbFocalPointY - var5 < -500 || Language.oculusOrbFocalPointY - var5 > 500) {
																	WorldMapSectionType.oculusOrbFocalPointX = var4;
																	Language.oculusOrbFocalPointY = var5;
																}

																if (var4 != WorldMapSectionType.oculusOrbFocalPointX) {
																	WorldMapSectionType.oculusOrbFocalPointX += (var4 - WorldMapSectionType.oculusOrbFocalPointX) / 16;
																}

																if (var5 != Language.oculusOrbFocalPointY) {
																	Language.oculusOrbFocalPointY += (var5 - Language.oculusOrbFocalPointY) / 16;
																}

																var6 = WorldMapSectionType.oculusOrbFocalPointX >> 7;
																var7 = Language.oculusOrbFocalPointY >> 7;
																var8 = ScriptEvent.getTileHeight(WorldMapSectionType.oculusOrbFocalPointX, Language.oculusOrbFocalPointY, UrlRequest.Client_plane);
																var9 = 0;
																if (var6 > 3 && var7 > 3 && var6 < 100 && var7 < 100) {
																	for (var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
																		for (var11 = var7 - 4; var11 <= var7 + 4; ++var11) {
																			var12 = UrlRequest.Client_plane;
																			if (var12 < 3 && (Tiles.Tiles_renderFlags[1][var10][var11] & 2) == 2) {
																				++var12;
																			}

																			int var28 = var8 - Tiles.Tiles_heights[var12][var10][var11];
																			if (var28 > var9) {
																				var9 = var28;
																			}
																		}
																	}
																}

																var10 = var9 * 192;
																if (var10 > 98048) {
																	var10 = 98048;
																}

																if (var10 < 32768) {
																	var10 = 32768;
																}

																if (var10 > field714) {
																	field714 += (var10 - field714) / 24;
																} else if (var10 < field714) {
																	field714 += (var10 - field714) / 80;
																}

																WorldMapManager.field314 = ScriptEvent.getTileHeight(Message.localPlayer.x, Message.localPlayer.y, UrlRequest.Client_plane) - camFollowHeight;
															} else if (oculusOrbState == 1) {
																if (field751 && Message.localPlayer != null) {
																	var4 = Message.localPlayer.pathX[0];
																	var5 = Message.localPlayer.pathY[0];
																	if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
																		WorldMapSectionType.oculusOrbFocalPointX = Message.localPlayer.x;
																		var6 = ScriptEvent.getTileHeight(Message.localPlayer.x, Message.localPlayer.y, UrlRequest.Client_plane) - camFollowHeight;
																		if (var6 < WorldMapManager.field314) {
																			WorldMapManager.field314 = var6;
																		}

																		Language.oculusOrbFocalPointY = Message.localPlayer.y;
																		field751 = false;
																	}
																}

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

																byte var35 = 0;
																if (KeyHandler.KeyHandler_pressedKeys[35]) {
																	var35 = -1;
																} else if (KeyHandler.KeyHandler_pressedKeys[51]) {
																	var35 = 1;
																}

																var6 = 0;
																if (var34 >= 0 || var35 != 0) {
																	var6 = KeyHandler.KeyHandler_pressedKeys[81] ? oculusOrbSlowedSpeed : oculusOrbNormalSpeed;
																	var6 *= 16;
																	field706 = var34;
																	field632 = var35;
																}

																if (field705 < var6) {
																	field705 += var6 / 8;
																	if (field705 > var6) {
																		field705 = var6;
																	}
																} else if (field705 > var6) {
																	field705 = field705 * 9 / 10;
																}

																if (field705 > 0) {
																	var7 = field705 / 16;
																	if (field706 >= 0) {
																		var4 = field706 - WorldMapLabelSize.cameraYaw & 2047;
																		var8 = Rasterizer3D.Rasterizer3D_sine[var4];
																		var9 = Rasterizer3D.Rasterizer3D_cosine[var4];
																		WorldMapSectionType.oculusOrbFocalPointX += var8 * var7 / 65536;
																		Language.oculusOrbFocalPointY += var9 * var7 / 65536;
																	}

																	if (field632 != 0) {
																		WorldMapManager.field314 += var7 * field632;
																		if (WorldMapManager.field314 > 0) {
																			WorldMapManager.field314 = 0;
																		}
																	}
																} else {
																	field706 = -1;
																	field632 = -1;
																}

																if (KeyHandler.KeyHandler_pressedKeys[13]) {
																	class189.method3620();
																}
															}

															if (MouseHandler.MouseHandler_currentButton == 4 && NetFileRequest.mouseCam) {
																var4 = MouseHandler.MouseHandler_y - mouseCamClickedY;
																camAngleDX = var4 * 2;
																mouseCamClickedY = var4 != -1 && var4 != 1 ? (mouseCamClickedY + MouseHandler.MouseHandler_y) / 2 : MouseHandler.MouseHandler_y;
																var5 = mouseCamClickedX - MouseHandler.MouseHandler_x;
																camAngleDY = var5 * 2;
																mouseCamClickedX = var5 != -1 && var5 != 1 ? (MouseHandler.MouseHandler_x + mouseCamClickedX) / 2 : MouseHandler.MouseHandler_x;
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
																StructDefinition.method4529();
															}

															for (var4 = 0; var4 < 5; ++var4) {
																int var10002 = field878[var4]++;
															}

															MilliClock.varcs.tryWrite();
															var4 = ++MouseHandler.MouseHandler_idleCycles - 1;
															var6 = MusicPatchNode.method3814();
															if (var4 > 15000 && var6 > 15000) {
																logoutTimer = 250;
																MouseHandler.MouseHandler_idleCycles = 14500;
																var26 = class2.getPacketBufferNode(ClientPacket.field2268, packetWriter.isaacCipher);
																packetWriter.addNode(var26);
															}

															Message.friendSystem.processFriendUpdates();
															++packetWriter.pendingWrites;
															if (packetWriter.pendingWrites > 50) {
																var26 = class2.getPacketBufferNode(ClientPacket.field2182, packetWriter.isaacCipher);
																packetWriter.addNode(var26);
															}

															try {
																packetWriter.flush();
															} catch (IOException var29) {
																StudioGame.method4119();
															}

															return;
														}

														var45 = var43.widget;
														if (var45.childIndex < 0) {
															break;
														}

														var41 = Tile.getWidget(var45.parentId);
													} while(var41 == null || var41.children == null || var45.childIndex >= var41.children.length || var45 != var41.children[var45.childIndex]);

													runScriptEvent(var43);
												}
											}

											var45 = var43.widget;
											if (var45.childIndex < 0) {
												break;
											}

											var41 = Tile.getWidget(var45.parentId);
										} while(var41 == null || var41.children == null || var45.childIndex >= var41.children.length || var45 != var41.children[var45.childIndex]);

										runScriptEvent(var43);
									}
								}

								var45 = var43.widget;
								if (var45.childIndex < 0) {
									break;
								}

								var41 = Tile.getWidget(var45.parentId);
							} while(var41 == null || var41.children == null || var45.childIndex >= var41.children.length || var45 != var41.children[var45.childIndex]);

							runScriptEvent(var43);
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("ge")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1368439578"
	)
	@Export("resizeJS")
	void resizeJS() {
		int var1 = GrandExchangeOfferTotalQuantityComparator.canvasWidth;
		int var2 = AttackOption.canvasHeight;
		if (super.contentWidth < var1) {
			var1 = super.contentWidth;
		}

		if (super.contentHeight < var2) {
			var2 = super.contentHeight;
		}

		if (Interpreter.clientPreferences != null) {
			try {
				Client var3 = class206.client;
				Object[] var4 = new Object[]{ItemDefinition.getWindowedMode()};
				JSObject.getWindow(var3).call("resize", var4);
			} catch (Throwable var5) {
			}
		}

	}

	@ObfuscatedName("gt")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1903314138"
	)
	@Export("drawLoggedIn")
	final void drawLoggedIn() {
		int var1;
		if (rootInterface != -1) {
			var1 = rootInterface;
			if (MusicPatch.loadInterface(var1)) {
				MouseHandler.drawModelComponents(UserComparator7.Widget_interfaceComponents[var1], -1);
			}
		}

		for (var1 = 0; var1 < rootWidgetCount; ++var1) {
			if (field833[var1]) {
				field834[var1] = true;
			}

			field835[var1] = field833[var1];
			field833[var1] = false;
		}

		field832 = cycle;
		viewportX = -1;
		viewportY = -1;
		WorldMapManager.field312 = null;
		if (rootInterface != -1) {
			rootWidgetCount = 0;
			class13.drawWidgets(rootInterface, 0, 0, GrandExchangeOfferTotalQuantityComparator.canvasWidth, AttackOption.canvasHeight, 0, 0, -1);
		}

		Rasterizer2D.Rasterizer2D_resetClip();
		if (showMouseCross) {
			if (mouseCrossColor == 1) {
				ObjectDefinition.crossSprites[mouseCrossState * 20 / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}

			if (mouseCrossColor == 2) {
				ObjectDefinition.crossSprites[mouseCrossState * 20 / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}
		}

		int var2;
		int var3;
		int var4;
		int var6;
		int var7;
		int var8;
		if (!isMenuOpen) {
			if (viewportX != -1) {
				var1 = viewportX;
				var2 = viewportY;
				if ((menuOptionsCount >= 2 || isItemSelected != 0 || isSpellSelected) && showMouseOverText) {
					var3 = GrandExchangeOfferOwnWorldComparator.method1288();
					String var19;
					if (isItemSelected == 1 && menuOptionsCount < 2) {
						var19 = "Use" + " " + selectedItemName + " " + "->";
					} else if (isSpellSelected && menuOptionsCount < 2) {
						var19 = selectedSpellActionName + " " + selectedSpellName + " " + "->";
					} else {
						String var5;
						if (var3 < 0) {
							var5 = "";
						} else if (menuTargets[var3].length() > 0) {
							var5 = menuActions[var3] + " " + menuTargets[var3];
						} else {
							var5 = menuActions[var3];
						}

						var19 = var5;
					}

					if (menuOptionsCount > 2) {
						var19 = var19 + NPC.colorStartTag(16777215) + " " + '/' + " " + (menuOptionsCount - 2) + " more options";
					}

					GrandExchangeOffer.fontBold12.drawRandomAlphaAndSpacing(var19, var1 + 4, var2 + 15, 16777215, 0, cycle / 1000);
				}
			}
		} else {
			var1 = GrandExchangeEvent.menuX;
			var2 = WorldMapManager.menuY;
			var3 = KeyHandler.menuWidth;
			var4 = class54.menuHeight;
			int var13 = 6116423;
			Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, var13);
			Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
			GrandExchangeOffer.fontBold12.draw("Choose Option", var1 + 3, var2 + 14, var13, -1);
			var6 = MouseHandler.MouseHandler_x;
			var7 = MouseHandler.MouseHandler_y;

			int var9;
			int var10;
			for (var8 = 0; var8 < menuOptionsCount; ++var8) {
				var9 = (menuOptionsCount - 1 - var8) * 15 + var2 + 31;
				var10 = 16777215;
				if (var6 > var1 && var6 < var1 + var3 && var7 > var9 - 13 && var7 < var9 + 3) {
					var10 = 16776960;
				}

				Font var11 = GrandExchangeOffer.fontBold12;
				String var12;
				if (var8 < 0) {
					var12 = "";
				} else if (menuTargets[var8].length() > 0) {
					var12 = menuActions[var8] + " " + menuTargets[var8];
				} else {
					var12 = menuActions[var8];
				}

				var11.draw(var12, var1 + 3, var9, var10, 0);
			}

			var8 = GrandExchangeEvent.menuX;
			var9 = WorldMapManager.menuY;
			var10 = KeyHandler.menuWidth;
			int var14 = class54.menuHeight;

			for (int var15 = 0; var15 < rootWidgetCount; ++var15) {
				if (rootWidgetWidths[var15] + rootWidgetXs[var15] > var8 && rootWidgetXs[var15] < var10 + var8 && rootWidgetHeights[var15] + rootWidgetYs[var15] > var9 && rootWidgetYs[var15] < var9 + var14) {
					field834[var15] = true;
				}
			}
		}

		if (gameDrawingMode == 3) {
			for (var1 = 0; var1 < rootWidgetCount; ++var1) {
				if (field835[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
				} else if (field834[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
				}
			}
		}

		var1 = UrlRequest.Client_plane;
		var2 = Message.localPlayer.x;
		var3 = Message.localPlayer.y;
		var4 = field690;

		for (ObjectSound var20 = (ObjectSound)ObjectSound.objectSounds.last(); var20 != null; var20 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var20.soundEffectId != -1 || var20.soundEffectIds != null) {
				var6 = 0;
				if (var2 > var20.field1064 * 16384) {
					var6 += var2 - var20.field1064 * 16384;
				} else if (var2 < var20.x * 128) {
					var6 += var20.x * 128 - var2;
				}

				if (var3 > var20.field1052 * 16384) {
					var6 += var3 - var20.field1052 * 16384;
				} else if (var3 < var20.y * 16384) {
					var6 += var20.y * 16384 - var3;
				}

				if (var6 - 64 <= var20.field1053 && areaSoundEffectVolume != 0 && var1 == var20.plane) {
					var6 -= 64;
					if (var6 < 0) {
						var6 = 0;
					}

					var7 = (var20.field1053 - var6) * areaSoundEffectVolume / var20.field1053;
					Object var10000;
					if (var20.stream1 == null) {
						if (var20.soundEffectId >= 0) {
							var10000 = null;
							SoundEffect var16 = SoundEffect.readSoundEffect(FloorDecoration.archive4, var20.soundEffectId, 0);
							if (var16 != null) {
								RawSound var17 = var16.toRawSound().resample(ClientPreferences.decimator);
								RawPcmStream var18 = RawPcmStream.createRawPcmStream(var17, 100, var7);
								var18.setNumLoops(-1);
								Tiles.pcmStreamMixer.addSubStream(var18);
								var20.stream1 = var18;
							}
						}
					} else {
						var20.stream1.method2578(var7);
					}

					if (var20.stream2 == null) {
						if (var20.soundEffectIds != null && (var20.field1055 -= var4) <= 0) {
							var8 = (int)(Math.random() * (double)var20.soundEffectIds.length);
							var10000 = null;
							SoundEffect var22 = SoundEffect.readSoundEffect(FloorDecoration.archive4, var20.soundEffectIds[var8], 0);
							if (var22 != null) {
								RawSound var23 = var22.toRawSound().resample(ClientPreferences.decimator);
								RawPcmStream var21 = RawPcmStream.createRawPcmStream(var23, 100, var7);
								var21.setNumLoops(0);
								Tiles.pcmStreamMixer.addSubStream(var21);
								var20.stream2 = var21;
								var20.field1055 = var20.field1060 + (int)(Math.random() * (double)(var20.field1061 - var20.field1060));
							}
						}
					} else {
						var20.stream2.method2578(var7);
						if (!var20.stream2.hasNext()) {
							var20.stream2 = null;
						}
					}
				} else {
					if (var20.stream1 != null) {
						Tiles.pcmStreamMixer.removeSubStream(var20.stream1);
						var20.stream1 = null;
					}

					if (var20.stream2 != null) {
						Tiles.pcmStreamMixer.removeSubStream(var20.stream2);
						var20.stream2 = null;
					}
				}
			}
		}

		field690 = 0;
	}

	@ObfuscatedName("hc")
	@ObfuscatedSignature(
		signature = "(Lcr;I)Z",
		garbageValue = "1049525241"
	)
	final boolean method1304(PacketWriter var1) {
		AbstractSocket var2 = var1.getSocket();
		PacketBuffer var3 = var1.packetBuffer;
		if (var2 == null) {
			return false;
		} else {
			int var6;
			String var18;
			try {
				int var5;
				if (var1.serverPacket == null) {
					if (var1.field1297) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 0, 1);
						var1.field1298 = 0;
						var1.field1297 = false;
					}

					var3.offset = 0;
					if (var3.method5492()) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 1, 1);
						var1.field1298 = 0;
					}

					var1.field1297 = true;
					ServerPacket[] var4 = class162.ServerPacket_values();
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
				var1.field1298 = 0;
				timer.method5016();
				var1.field1299 = var1.field1301;
				var1.field1301 = var1.field1300;
				var1.field1300 = var1.serverPacket;
				int var16;
				if (ServerPacket.field2100 == var1.serverPacket) {
					var16 = var3.method5583();
					var5 = var3.method5591();
					Varps.Varps_temp[var16] = var5;
					if (Varps.Varps_main[var16] != var5) {
						Varps.Varps_main[var16] = var5;
					}

					BufferedSink.changeGameOptions(var16);
					field814[++field648 - 1 & 31] = var16;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2107 == var1.serverPacket) {
					var16 = var3.method5583();
					if (var16 == 65535) {
						var16 = -1;
					}

					WorldMapSprite.playSong(var16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2148 == var1.serverPacket) {
					var16 = var3.method5723();
					if (var16 == 65535) {
						var16 = -1;
					}

					var5 = var3.readMedium();
					ScriptFrame.playSoundJingle(var16, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2157 == var1.serverPacket) {
					var16 = var3.readInt();
					if (var16 != field710) {
						field710 = var16;
						KeyHandler.method835();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2147 == var1.serverPacket) {
					InterfaceParent.logOut();
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2104 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readInt();
					var6 = WorldMapSectionType.getGcDuration();
					PacketBufferNode var42 = class2.getPacketBufferNode(ClientPacket.field2191, packetWriter.isaacCipher);
					var42.packetBuffer.method5569(GameShell.fps);
					var42.packetBuffer.writeShortLE(var16);
					var42.packetBuffer.writeShortLE(var5);
					var42.packetBuffer.method5696(var6);
					packetWriter.addNode(var42);
					var1.serverPacket = null;
					return true;
				}

				Widget var17;
				if (ServerPacket.field2163 == var1.serverPacket) {
					var16 = var3.method5583();
					var5 = var3.method5590();
					var17 = Tile.getWidget(var5);
					if (var17.modelType != 1 || var16 != var17.modelId) {
						var17.modelType = 1;
						var17.modelId = var16;
						LoginPacket.invalidateWidget(var17);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2088 == var1.serverPacket) {
					minimapState = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2142 == var1.serverPacket) {
					AbstractWorldMapIcon.method614(class179.field2297);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2120 == var1.serverPacket) {
					WorldMapRectangle.updateNpcs(true, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2114 == var1.serverPacket) {
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

				Widget var55;
				if (ServerPacket.field2112 == var1.serverPacket) {
					var16 = var3.method5592();
					var55 = Tile.getWidget(var16);

					for (var6 = 0; var6 < var55.itemIds.length; ++var6) {
						var55.itemIds[var6] = -1;
						var55.itemIds[var6] = 0;
					}

					LoginPacket.invalidateWidget(var55);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2160 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.method5565();
					var17 = Tile.getWidget(var16);
					if (var5 != var17.sequenceId || var5 == -1) {
						var17.sequenceId = var5;
						var17.modelFrame = 0;
						var17.modelFrameCycle = 0;
						LoginPacket.invalidateWidget(var17);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2164 == var1.serverPacket) {
					AbstractWorldMapIcon.method614(class179.field2298);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2159 == var1.serverPacket) {
					Message.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
					GameShell.FriendSystem_invalidateIgnoreds();
					field711 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2113 == var1.serverPacket) {
					Buddy.method5211();
					runEnergy = var3.readUnsignedByte();
					field825 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2152 == var1.serverPacket) {
					var16 = var3.method5583();
					var5 = var3.method5590();
					var17 = Tile.getWidget(var5);
					if (var17 != null && var17.type == 0) {
						if (var16 > var17.scrollHeight - var17.height) {
							var16 = var17.scrollHeight - var17.height;
						}

						if (var16 < 0) {
							var16 = 0;
						}

						if (var16 != var17.scrollY) {
							var17.scrollY = var16;
							LoginPacket.invalidateWidget(var17);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2110 == var1.serverPacket) {
					for (var16 = 0; var16 < Varps.Varps_main.length; ++var16) {
						if (Varps.Varps_main[var16] != Varps.Varps_temp[var16]) {
							Varps.Varps_main[var16] = Varps.Varps_temp[var16];
							BufferedSink.changeGameOptions(var16);
							field814[++field648 - 1 & 31] = var16;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2140 == var1.serverPacket) {
					Message.friendSystem.method1845();
					field711 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				int var8;
				int var9;
				long var12;
				int var19;
				int var20;
				InterfaceParent var41;
				if (ServerPacket.field2153 == var1.serverPacket) {
					var16 = var3.offset + var1.serverPacketLength;
					var5 = var3.readUnsignedShort();
					var6 = var3.readUnsignedShort();
					if (var5 != rootInterface) {
						rootInterface = var5;
						this.resizeRoot(false);
						GameShell.Widget_resetModelFrames(rootInterface);
						Players.runWidgetOnLoadListener(rootInterface);

						for (var19 = 0; var19 < 100; ++var19) {
							field833[var19] = true;
						}
					}

					InterfaceParent var43;
					for (; var6-- > 0; var43.field546 = true) {
						var19 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var9 = var3.readUnsignedByte();
						var43 = (InterfaceParent)interfaceParents.get((long)var19);
						if (var43 != null && var8 != var43.group) {
							VarpDefinition.closeInterface(var43, true);
							var43 = null;
						}

						if (var43 == null) {
							var43 = ScriptFrame.method1107(var19, var8, var9);
						}
					}

					for (var41 = (InterfaceParent)interfaceParents.first(); var41 != null; var41 = (InterfaceParent)interfaceParents.next()) {
						if (var41.field546) {
							var41.field546 = false;
						} else {
							VarpDefinition.closeInterface(var41, true);
						}
					}

					widgetClickMasks = new NodeHashTable(512);

					while (var3.offset < var16) {
						var19 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var9 = var3.readUnsignedShort();
						var20 = var3.readInt();

						for (int var11 = var8; var11 <= var9; ++var11) {
							var12 = (long)var11 + ((long)var19 << 32);
							widgetClickMasks.put(new IntegerNode(var20), var12);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2154 == var1.serverPacket) {
					Buddy.method5211();
					var16 = var3.method5628();
					var5 = var3.method5628();
					var6 = var3.method5591();
					experience[var5] = var6;
					currentLevels[var5] = var16;
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

				if (ServerPacket.field2095 == var1.serverPacket) {
					AbstractWorldMapIcon.method614(class179.field2289);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2122 == var1.serverPacket) {
					AbstractWorldMapIcon.method614(class179.field2290);
					var1.serverPacket = null;
					return true;
				}

				Widget var7;
				if (ServerPacket.field2128 == var1.serverPacket) {
					var16 = var3.method5723();
					var5 = var3.method5723();
					var6 = var3.readInt();
					var7 = Tile.getWidget(var6);
					var7.field2607 = var16 + (var5 << 16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2134 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedShort();
					class268.queueSoundEffect(var16, var5, var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2138 == var1.serverPacket) {
					isCameraLocked = false;

					for (var16 = 0; var16 < 5; ++var16) {
						field779[var16] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2155 == var1.serverPacket) {
					SecureRandomCallable.loadRegions(true, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2109 == var1.serverPacket) {
					AbstractWorldMapIcon.method614(class179.field2295);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2135 == var1.serverPacket) {
					var16 = var3.method5582();
					byte var45 = var3.method5575();
					Varps.Varps_temp[var16] = var45;
					if (Varps.Varps_main[var16] != var45) {
						Varps.Varps_main[var16] = var45;
					}

					BufferedSink.changeGameOptions(var16);
					field814[++field648 - 1 & 31] = var16;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2125 == var1.serverPacket) {
					AbstractWorldMapIcon.method614(class179.field2293);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2093 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					if (var3.readUnsignedByte() == 0) {
						grandExchangeOffers[var16] = new GrandExchangeOffer();
						var3.offset += 18;
					} else {
						--var3.offset;
						grandExchangeOffers[var16] = new GrandExchangeOffer(var3, false);
					}

					field823 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2162 == var1.serverPacket) {
					PlayerAppearance.field2520 = var3.method5628();
					class3.field7 = var3.method5675();

					while (var3.offset < var1.serverPacketLength) {
						var16 = var3.readUnsignedByte();
						class179 var57 = LoginScreenAnimation.method1832()[var16];
						AbstractWorldMapIcon.method614(var57);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2115 == var1.serverPacket) {
					rebootTimer = var3.readUnsignedShort() * 30;
					field825 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2102 == var1.serverPacket) {
					var16 = var3.method5590();
					var5 = var3.method5723();
					var6 = var5 >> 10 & 31;
					var19 = var5 >> 5 & 31;
					var8 = var5 & 31;
					var9 = (var19 << 11) + (var6 << 19) + (var8 << 3);
					Widget var10 = Tile.getWidget(var16);
					if (var9 != var10.color) {
						var10.color = var9;
						LoginPacket.invalidateWidget(var10);
					}

					var1.serverPacket = null;
					return true;
				}

				String var52;
				if (ServerPacket.field2168 == var1.serverPacket) {
					byte[] var40 = new byte[var1.serverPacketLength];
					var3.method5494(var40, 0, var40.length);
					Buffer var56 = new Buffer(var40);
					var52 = var56.readStringCp1252NullTerminated();
					class13.openURL(var52, true, false);
					var1.serverPacket = null;
					return true;
				}

				long var21;
				if (ServerPacket.field2170 == var1.serverPacket) {
					var16 = var3.method5592();
					var5 = var3.method5592();
					var6 = var3.method5583();
					if (var6 == 65535) {
						var6 = -1;
					}

					var19 = var3.readUnsignedShort();
					if (var19 == 65535) {
						var19 = -1;
					}

					for (var8 = var19; var8 <= var6; ++var8) {
						var21 = (long)var8 + ((long)var16 << 32);
						Node var58 = widgetClickMasks.get(var21);
						if (var58 != null) {
							var58.remove();
						}

						widgetClickMasks.put(new IntegerNode(var5), var21);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2111 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var16 < -70000) {
						var5 += 32768;
					}

					if (var16 >= 0) {
						var17 = Tile.getWidget(var16);
					} else {
						var17 = null;
					}

					if (var17 != null) {
						for (var19 = 0; var19 < var17.itemIds.length; ++var19) {
							var17.itemIds[var19] = 0;
							var17.itemQuantities[var19] = 0;
						}
					}

					FriendSystem.clearItemContainer(var5);
					var19 = var3.readUnsignedShort();

					for (var8 = 0; var8 < var19; ++var8) {
						var9 = var3.method5572();
						if (var9 == 255) {
							var9 = var3.method5592();
						}

						var20 = var3.readUnsignedShort();
						if (var17 != null && var8 < var17.itemIds.length) {
							var17.itemIds[var8] = var20;
							var17.itemQuantities[var8] = var9;
						}

						Canvas.itemContainerSetItem(var5, var8, var20 - 1, var9);
					}

					if (var17 != null) {
						LoginPacket.invalidateWidget(var17);
					}

					Buddy.method5211();
					changedItemContainers[++field701 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2167 == var1.serverPacket) {
					if (Calendar.clanChat != null) {
						Calendar.clanChat.method5262(var3);
					}

					PlayerAppearance.method4011();
					var1.serverPacket = null;
					return true;
				}

				boolean var47;
				if (ServerPacket.field2156 == var1.serverPacket) {
					var47 = var3.method5675() == 1;
					var5 = var3.readInt();
					var17 = Tile.getWidget(var5);
					if (var47 != var17.isHidden) {
						var17.isHidden = var47;
						LoginPacket.invalidateWidget(var17);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2144 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					FontName.method5376(var16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2086 == var1.serverPacket) {
					hintArrowType = var3.readUnsignedByte();
					if (hintArrowType == 1) {
						hintArrowNpcIndex = var3.readUnsignedShort();
					}

					if (hintArrowType >= 2 && hintArrowType <= 6) {
						if (hintArrowType == 2) {
							hintArrowSubX = 64;
							hintArrowSubY = 64;
						}

						if (hintArrowType == 3) {
							hintArrowSubX = 0;
							hintArrowSubY = 64;
						}

						if (hintArrowType == 4) {
							hintArrowSubX = 128;
							hintArrowSubY = 64;
						}

						if (hintArrowType == 5) {
							hintArrowSubX = 64;
							hintArrowSubY = 0;
						}

						if (hintArrowType == 6) {
							hintArrowSubX = 64;
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

				if (ServerPacket.field2117 == var1.serverPacket) {
					isCameraLocked = true;
					class80.field1111 = var3.readUnsignedByte() * 16384;
					Ignored.field3589 = var3.readUnsignedByte() * 128;
					field873 = var3.readUnsignedShort();
					PacketBufferNode.field2310 = var3.readUnsignedByte();
					GrandExchangeOfferOwnWorldComparator.field623 = var3.readUnsignedByte();
					if (GrandExchangeOfferOwnWorldComparator.field623 >= 100) {
						var16 = class80.field1111 * 128 + 64;
						var5 = Ignored.field3589 * 16384 + 64;
						var6 = ScriptEvent.getTileHeight(var16, var5, UrlRequest.Client_plane) - field873;
						var19 = var16 - MusicPatchNode2.cameraX;
						var8 = var6 - class60.cameraY;
						var9 = var5 - UserComparator9.cameraZ;
						var20 = (int)Math.sqrt((double)(var19 * var19 + var9 * var9));
						ViewportMouse.cameraPitch = (int)(Math.atan2((double)var8, (double)var20) * 325.949D) & 2047;
						WorldMapLabelSize.cameraYaw = (int)(Math.atan2((double)var19, (double)var9) * -325.949D) & 2047;
						if (ViewportMouse.cameraPitch < 128) {
							ViewportMouse.cameraPitch = 128;
						}

						if (ViewportMouse.cameraPitch > 383) {
							ViewportMouse.cameraPitch = 383;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2094 == var1.serverPacket) {
					PlayerAppearance.field2520 = var3.readUnsignedByte();
					class3.field7 = var3.method5675();

					for (var16 = class3.field7; var16 < class3.field7 + 8; ++var16) {
						for (var5 = PlayerAppearance.field2520; var5 < PlayerAppearance.field2520 + 8; ++var5) {
							if (groundItems[UrlRequest.Client_plane][var16][var5] != null) {
								groundItems[UrlRequest.Client_plane][var16][var5] = null;
								Skills.updateItemPile(var16, var5);
							}
						}
					}

					for (PendingSpawn var39 = (PendingSpawn)pendingSpawns.last(); var39 != null; var39 = (PendingSpawn)pendingSpawns.previous()) {
						if (var39.x >= class3.field7 && var39.x < class3.field7 + 8 && var39.y >= PlayerAppearance.field2520 && var39.y < PlayerAppearance.field2520 + 8 && var39.plane == UrlRequest.Client_plane) {
							var39.hitpoints = 0;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2092 == var1.serverPacket) {
					var16 = var3.readUShortSmart();
					boolean var44 = var3.readUnsignedByte() == 1;
					var52 = "";
					boolean var54 = false;
					if (var44) {
						var52 = var3.readStringCp1252NullTerminated();
						if (Message.friendSystem.isIgnored(new Username(var52, class188.loginType))) {
							var54 = true;
						}
					}

					String var60 = var3.readStringCp1252NullTerminated();
					if (!var54) {
						class83.addGameMessage(var16, var52, var60);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2139 == var1.serverPacket) {
					Message.friendSystem.readUpdate(var3, var1.serverPacketLength);
					field711 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2089 == var1.serverPacket) {
					isCameraLocked = true;
					SequenceDefinition.field3477 = var3.readUnsignedByte() * 16384;
					AbstractWorldMapData.field147 = var3.readUnsignedByte() * 16384;
					Canvas.field397 = var3.readUnsignedShort();
					HitSplatDefinition.field3312 = var3.readUnsignedByte();
					WorldMapData_0.field92 = var3.readUnsignedByte();
					if (WorldMapData_0.field92 >= 100) {
						MusicPatchNode2.cameraX = SequenceDefinition.field3477 * 128 + 64;
						UserComparator9.cameraZ = AbstractWorldMapData.field147 * 128 + 64;
						class60.cameraY = ScriptEvent.getTileHeight(MusicPatchNode2.cameraX, UserComparator9.cameraZ, UrlRequest.Client_plane) - Canvas.field397;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2146 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					rootInterface = var16;
					this.resizeRoot(false);
					GameShell.Widget_resetModelFrames(var16);
					Players.runWidgetOnLoadListener(rootInterface);

					for (var5 = 0; var5 < 100; ++var5) {
						field833[var5] = true;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2090 == var1.serverPacket) {
					publicChatMode = var3.method5572();
					tradeChatMode = var3.method5675();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2123 == var1.serverPacket) {
					AbstractWorldMapIcon.method614(class179.field2294);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2166 == var1.serverPacket) {
					Calendar.privateChatMode = class50.method893(var3.readUnsignedByte());
					var1.serverPacket = null;
					return true;
				}

				long var25;
				long var27;
				String var37;
				if (ServerPacket.field2169 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					var25 = var3.readLong();
					var27 = (long)var3.readUnsignedShort();
					var21 = (long)var3.readMedium();
					PlayerType var23 = (PlayerType)DynamicObject.findEnumerated(MusicPatchPcmStream.PlayerType_values(), var3.readUnsignedByte());
					var12 = var21 + (var27 << 32);
					boolean var46 = false;

					for (int var15 = 0; var15 < 100; ++var15) {
						if (field707[var15] == var12) {
							var46 = true;
							break;
						}
					}

					if (var23.isUser && Message.friendSystem.isIgnored(new Username(var37, class188.loginType))) {
						var46 = true;
					}

					if (!var46 && field678 == 0) {
						field707[field682] = var12;
						field682 = (field682 + 1) % 100;
						String var29 = AbstractFont.escapeBrackets(Buddy.method5214(GraphicsObject.method2028(var3)));
						if (var23.modIcon != -1) {
							GameShell.addChatMessage(9, ChatChannel.method2269(var23.modIcon) + var37, var29, CollisionMap.base37DecodeLong(var25));
						} else {
							GameShell.addChatMessage(9, var37, var29, CollisionMap.base37DecodeLong(var25));
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2131 == var1.serverPacket) {
					WorldMapElement.method4381(var3.readStringCp1252NullTerminated());
					var1.serverPacket = null;
					return true;
				}

				Widget var24;
				if (ServerPacket.field2133 == var1.serverPacket) {
					var16 = var3.method5591();
					var5 = var3.method5590();
					InterfaceParent var50 = (InterfaceParent)interfaceParents.get((long)var5);
					var41 = (InterfaceParent)interfaceParents.get((long)var16);
					if (var41 != null) {
						VarpDefinition.closeInterface(var41, var50 == null || var41.group != var50.group);
					}

					if (var50 != null) {
						var50.remove();
						interfaceParents.put(var50, (long)var16);
					}

					var24 = Tile.getWidget(var5);
					if (var24 != null) {
						LoginPacket.invalidateWidget(var24);
					}

					var24 = Tile.getWidget(var16);
					if (var24 != null) {
						LoginPacket.invalidateWidget(var24);
						Messages.revalidateWidgetScroll(UserComparator7.Widget_interfaceComponents[var24.id >>> 16], var24, true);
					}

					if (rootInterface != -1) {
						ItemContainer.runIntfCloseListeners(rootInterface, 1);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2087 == var1.serverPacket) {
					var47 = var3.readUnsignedByte() == 1;
					if (var47) {
						TileItemPile.field1522 = WorldMapID.currentTimeMillis() - var3.readLong();
						Script.grandExchangeEvents = new GrandExchangeEvents(var3, true);
					} else {
						Script.grandExchangeEvents = null;
					}

					field860 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2141 == var1.serverPacket) {
					var16 = var3.readInt();
					var55 = Tile.getWidget(var16);
					var55.modelType = 3;
					var55.modelId = Message.localPlayer.appearance.getChatHeadId();
					LoginPacket.invalidateWidget(var55);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2165 == var1.serverPacket) {
					class65.updatePlayers(var3, var1.serverPacketLength);
					GraphicsObject.method2030();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2116 == var1.serverPacket) {
					SecureRandomCallable.loadRegions(false, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2126 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.method5675();
					var6 = var3.method5590();
					var41 = (InterfaceParent)interfaceParents.get((long)var6);
					if (var41 != null) {
						VarpDefinition.closeInterface(var41, var16 != var41.group);
					}

					ScriptFrame.method1107(var6, var16, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2130 == var1.serverPacket) {
					var16 = var3.method5723();
					if (var16 == 65535) {
						var16 = -1;
					}

					var5 = var3.readInt();
					var6 = var3.method5591();
					var7 = Tile.getWidget(var5);
					ItemDefinition var59;
					if (!var7.isIf3) {
						if (var16 == -1) {
							var7.modelType = 0;
							var1.serverPacket = null;
							return true;
						}

						var59 = PacketBufferNode.ItemDefinition_get(var16);
						var7.modelType = 4;
						var7.modelId = var16;
						var7.modelAngleX = var59.xan2d;
						var7.modelAngleY = var59.yan2d;
						var7.modelZoom = var59.zoom2d * 100 / var6;
						LoginPacket.invalidateWidget(var7);
					} else {
						var7.itemId = var16;
						var7.itemQuantity = var6;
						var59 = PacketBufferNode.ItemDefinition_get(var16);
						var7.modelAngleX = var59.xan2d;
						var7.modelAngleY = var59.yan2d;
						var7.modelAngleZ = var59.zan2d;
						var7.modelOffsetX = var59.offsetX2d;
						var7.modelOffsetY = var59.offsetY2d;
						var7.modelZoom = var59.zoom2d;
						if (var59.isStackable == 1) {
							var7.itemQuantityMode = 1;
						} else {
							var7.itemQuantityMode = 2;
						}

						if (var7.field2645 > 0) {
							var7.modelZoom = var7.modelZoom * 32 / var7.field2645;
						} else if (var7.rawWidth > 0) {
							var7.modelZoom = var7.modelZoom * 32 / var7.rawWidth;
						}

						LoginPacket.invalidateWidget(var7);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2171 == var1.serverPacket) {
					class3.field7 = var3.method5572();
					PlayerAppearance.field2520 = var3.method5628();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2151 == var1.serverPacket) {
					var3.offset += 28;
					if (var3.checkCrc()) {
						class48.method859(var3, var3.offset - 28);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2129 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					var5 = var3.method5675();
					var6 = var3.method5628();
					if (var6 >= 1 && var6 <= 8) {
						if (var37.equalsIgnoreCase("null")) {
							var37 = null;
						}

						playerMenuActions[var6 - 1] = var37;
						playerOptionsPriorities[var6 - 1] = var5 == 0;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2127 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					WorldMapData_0.forceDisconnect(var16);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2101 == var1.serverPacket) {
					AbstractWorldMapIcon.method614(class179.field2292);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2149 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					var18 = AbstractFont.escapeBrackets(Buddy.method5214(GraphicsObject.method2028(var3)));
					class83.addGameMessage(6, var37, var18);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2136 == var1.serverPacket) {
					class117.readReflectionCheck(var3, var1.serverPacketLength);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2097 == var1.serverPacket) {
					var16 = var3.method5723();
					GrandExchangeOfferWorldComparator.method70(var16);
					changedItemContainers[++field701 - 1 & 31] = var16 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2099 == var1.serverPacket) {
					World var38 = new World();
					var38.host = var3.readStringCp1252NullTerminated();
					var38.id = var3.readUnsignedShort();
					var5 = var3.readInt();
					var38.properties = var5;
					class195.updateGameState(45);
					var2.close();
					var2 = null;
					KeyHandler.changeWorld(var38);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2119 == var1.serverPacket) {
					var16 = var3.method5582();
					var5 = var3.method5582();
					var6 = var3.method5723();
					var19 = var3.readInt();
					var24 = Tile.getWidget(var19);
					if (var5 != var24.modelAngleX || var6 != var24.modelAngleY || var16 != var24.modelZoom) {
						var24.modelAngleX = var5;
						var24.modelAngleY = var6;
						var24.modelZoom = var16;
						LoginPacket.invalidateWidget(var24);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2106 == var1.serverPacket) {
					if (var1.serverPacketLength == 0) {
						Calendar.clanChat = null;
					} else {
						if (Calendar.clanChat == null) {
							Calendar.clanChat = new ClanChat(class188.loginType, class206.client);
						}

						Calendar.clanChat.readUpdate(var3);
					}

					PlayerAppearance.method4011();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2145 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					Object[] var53 = new Object[var37.length() + 1];

					for (var6 = var37.length() - 1; var6 >= 0; --var6) {
						if (var37.charAt(var6) == 's') {
							var53[var6 + 1] = var3.readStringCp1252NullTerminated();
						} else {
							var53[var6 + 1] = new Integer(var3.readInt());
						}
					}

					var53[0] = new Integer(var3.readInt());
					ScriptEvent var48 = new ScriptEvent();
					var48.args = var53;
					runScriptEvent(var48);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2091 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedByte();
					var19 = var3.readUnsignedByte();
					field779[var16] = true;
					field875[var16] = var5;
					field876[var16] = var6;
					field877[var16] = var19;
					field878[var16] = 0;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2098 == var1.serverPacket) {
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

				if (ServerPacket.field2121 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.method5723();
					var17 = Tile.getWidget(var16);
					if (var17.modelType != 2 || var5 != var17.modelId) {
						var17.modelType = 2;
						var17.modelId = var5;
						LoginPacket.invalidateWidget(var17);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2124 == var1.serverPacket) {
					var16 = var3.method5584();
					var5 = var3.method5591();
					var6 = var3.method5565();
					var7 = Tile.getWidget(var5);
					if (var6 != var7.rawX || var16 != var7.rawY || var7.xAlignment != 0 || var7.yAlignment != 0) {
						var7.rawX = var6;
						var7.rawY = var16;
						var7.xAlignment = 0;
						var7.yAlignment = 0;
						LoginPacket.invalidateWidget(var7);
						this.alignWidget(var7);
						if (var7.type == 0) {
							Messages.revalidateWidgetScroll(UserComparator7.Widget_interfaceComponents[var5 >> 16], var7, false);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2158 == var1.serverPacket) {
					if (rootInterface != -1) {
						ItemContainer.runIntfCloseListeners(rootInterface, 0);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2150 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					var25 = (long)var3.readUnsignedShort();
					var27 = (long)var3.readMedium();
					PlayerType var30 = (PlayerType)DynamicObject.findEnumerated(MusicPatchPcmStream.PlayerType_values(), var3.readUnsignedByte());
					long var31 = (var25 << 32) + var27;
					boolean var33 = false;

					for (int var13 = 0; var13 < 100; ++var13) {
						if (var31 == field707[var13]) {
							var33 = true;
							break;
						}
					}

					if (Message.friendSystem.isIgnored(new Username(var37, class188.loginType))) {
						var33 = true;
					}

					if (!var33 && field678 == 0) {
						field707[field682] = var31;
						field682 = (field682 + 1) % 100;
						String var34 = AbstractFont.escapeBrackets(Buddy.method5214(GraphicsObject.method2028(var3)));
						byte var14;
						if (var30.isPrivileged) {
							var14 = 7;
						} else {
							var14 = 3;
						}

						if (var30.modIcon != -1) {
							class83.addGameMessage(var14, ChatChannel.method2269(var30.modIcon) + var37, var34);
						} else {
							class83.addGameMessage(var14, var37, var34);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2143 == var1.serverPacket) {
					var16 = var3.readInt();
					InterfaceParent var51 = (InterfaceParent)interfaceParents.get((long)var16);
					if (var51 != null) {
						VarpDefinition.closeInterface(var51, true);
					}

					if (meslayerContinueWidget != null) {
						LoginPacket.invalidateWidget(meslayerContinueWidget);
						meslayerContinueWidget = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2161 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var16 < -70000) {
						var5 += 32768;
					}

					if (var16 >= 0) {
						var17 = Tile.getWidget(var16);
					} else {
						var17 = null;
					}

					for (; var3.offset < var1.serverPacketLength; Canvas.itemContainerSetItem(var5, var19, var8 - 1, var9)) {
						var19 = var3.readUShortSmart();
						var8 = var3.readUnsignedShort();
						var9 = 0;
						if (var8 != 0) {
							var9 = var3.readUnsignedByte();
							if (var9 == 255) {
								var9 = var3.readInt();
							}
						}

						if (var17 != null && var19 >= 0 && var19 < var17.itemIds.length) {
							var17.itemIds[var19] = var8;
							var17.itemQuantities[var19] = var9;
						}
					}

					if (var17 != null) {
						LoginPacket.invalidateWidget(var17);
					}

					Buddy.method5211();
					changedItemContainers[++field701 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2132 == var1.serverPacket) {
					Buddy.method5211();
					weight = var3.readShort();
					field825 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2118 == var1.serverPacket) {
					for (var16 = 0; var16 < VarpDefinition.VarpDefinition_fileCount; ++var16) {
						VarpDefinition var49 = UserComparator8.VarpDefinition_get(var16);
						if (var49 != null) {
							Varps.Varps_temp[var16] = 0;
							Varps.Varps_main[var16] = 0;
						}
					}

					Buddy.method5211();
					field648 += 32;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2137 == var1.serverPacket) {
					AbstractWorldMapIcon.method614(class179.field2296);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2173 == var1.serverPacket) {
					var47 = var3.readBoolean();
					if (var47) {
						if (class215.field2534 == null) {
							class215.field2534 = new class237();
						}
					} else {
						class215.field2534 = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2108 == var1.serverPacket) {
					AbstractWorldMapIcon.method614(class179.field2291);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2105 == var1.serverPacket) {
					WorldMapRectangle.updateNpcs(false, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2096 == var1.serverPacket) {
					var16 = var3.method5592();
					var18 = var3.readStringCp1252NullTerminated();
					var17 = Tile.getWidget(var16);
					if (!var18.equals(var17.text)) {
						var17.text = var18;
						LoginPacket.invalidateWidget(var17);
					}

					var1.serverPacket = null;
					return true;
				}

				DesktopPlatformInfoProvider.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1301 != null ? var1.field1301.id : -1) + "," + (var1.field1299 != null ? var1.field1299.id : -1) + "," + var1.serverPacketLength, (Throwable)null);
				InterfaceParent.logOut();
			} catch (IOException var35) {
				StudioGame.method4119();
			} catch (Exception var36) {
				var18 = "" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1301 != null ? var1.field1301.id : -1) + "," + (var1.field1299 != null ? var1.field1299.id : -1) + "," + var1.serverPacketLength + "," + (Message.localPlayer.pathX[0] + MusicPatchPcmStream.baseX * 64) + "," + (Message.localPlayer.pathY[0] + ScriptEvent.baseY * 64) + ",";

				for (var6 = 0; var6 < var1.serverPacketLength && var6 < 50; ++var6) {
					var18 = var18 + var3.array[var6] + ",";
				}

				DesktopPlatformInfoProvider.RunException_sendStackTrace(var18, var36);
				InterfaceParent.logOut();
			}

			return true;
		}
	}

	@ObfuscatedName("ie")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2088122930"
	)
	@Export("menu")
	final void menu() {
		WorldMapArea.method404();
		if (ClientPreferences.dragInventoryWidget == null) {
			if (clickedWidget == null) {
				int var2;
				int var4;
				int var5;
				int var10;
				int var13;
				label240: {
					int var1 = MouseHandler.MouseHandler_lastButton;
					int var3;
					int var8;
					if (isMenuOpen) {
						if (var1 != 1 && (NetFileRequest.mouseCam || var1 != 4)) {
							var2 = MouseHandler.MouseHandler_x;
							var3 = MouseHandler.MouseHandler_y;
							if (var2 < GrandExchangeEvent.menuX - 10 || var2 > GrandExchangeEvent.menuX + KeyHandler.menuWidth + 10 || var3 < WorldMapManager.menuY - 10 || var3 > class54.menuHeight + WorldMapManager.menuY + 10) {
								isMenuOpen = false;
								GameObject.method3297(GrandExchangeEvent.menuX, WorldMapManager.menuY, KeyHandler.menuWidth, class54.menuHeight);
							}
						}

						if (var1 == 1 || !NetFileRequest.mouseCam && var1 == 4) {
							var2 = GrandExchangeEvent.menuX;
							var3 = WorldMapManager.menuY;
							var4 = KeyHandler.menuWidth;
							var5 = MouseHandler.MouseHandler_lastPressedX;
							int var6 = MouseHandler.MouseHandler_lastPressedY;
							int var12 = -1;

							for (var8 = 0; var8 < menuOptionsCount; ++var8) {
								var13 = (menuOptionsCount - 1 - var8) * 15 + var3 + 31;
								if (var5 > var2 && var5 < var2 + var4 && var6 > var13 - 13 && var6 < var13 + 3) {
									var12 = var8;
								}
							}

							if (var12 != -1) {
								MusicPatchPcmStream.method3898(var12);
							}

							isMenuOpen = false;
							GameObject.method3297(GrandExchangeEvent.menuX, WorldMapManager.menuY, KeyHandler.menuWidth, class54.menuHeight);
						}
					} else {
						var2 = GrandExchangeOfferOwnWorldComparator.method1288();
						if ((var1 == 1 || !NetFileRequest.mouseCam && var1 == 4) && var2 >= 0) {
							var3 = menuOpcodes[var2];
							if (var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
								var4 = menuArguments1[var2];
								var5 = menuArguments2[var2];
								Widget var11 = Tile.getWidget(var5);
								var8 = WorldMapSection0.getWidgetClickMask(var11);
								boolean var7 = (var8 >> 28 & 1) != 0;
								if (var7) {
									break label240;
								}

								var10 = WorldMapSection0.getWidgetClickMask(var11);
								boolean var9 = (var10 >> 29 & 1) != 0;
								if (var9) {
									break label240;
								}
							}
						}

						if ((var1 == 1 || !NetFileRequest.mouseCam && var1 == 4) && this.shouldLeftClickOpenMenu()) {
							var1 = 2;
						}

						if ((var1 == 1 || !NetFileRequest.mouseCam && var1 == 4) && menuOptionsCount > 0) {
							MusicPatchPcmStream.method3898(var2);
						}

						if (var1 == 2 && menuOptionsCount > 0) {
							this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
						}
					}

					return;
				}

				if (ClientPreferences.dragInventoryWidget != null && !field768 && menuOptionsCount > 0 && !this.shouldLeftClickOpenMenu()) {
					var13 = field863;
					var10 = field738;
					Messages.method2231(LoginType.tempMenuAction, var13, var10);
					LoginType.tempMenuAction = null;
				}

				field768 = false;
				itemDragDuration = 0;
				if (ClientPreferences.dragInventoryWidget != null) {
					LoginPacket.invalidateWidget(ClientPreferences.dragInventoryWidget);
				}

				ClientPreferences.dragInventoryWidget = Tile.getWidget(var5);
				dragItemSlotSource = var4;
				field863 = MouseHandler.MouseHandler_lastPressedX;
				field738 = MouseHandler.MouseHandler_lastPressedY;
				if (var2 >= 0) {
					BuddyRankComparator.method3361(var2);
				}

				LoginPacket.invalidateWidget(ClientPreferences.dragInventoryWidget);
			}
		}
	}

	@ObfuscatedName("ic")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1378557318"
	)
	@Export("shouldLeftClickOpenMenu")
	final boolean shouldLeftClickOpenMenu() {
		int var1 = GrandExchangeOfferOwnWorldComparator.method1288();
		return (leftClickOpensMenu == 1 && menuOptionsCount > 2 || MouseHandler.method1074(var1)) && !menuShiftClick[var1];
	}

	@ObfuscatedName("ia")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1132899725"
	)
	@Export("openMenu")
	final void openMenu(int var1, int var2) {
		int var3 = GrandExchangeOffer.fontBold12.stringWidth("Choose Option");

		int var4;
		for (var4 = 0; var4 < menuOptionsCount; ++var4) {
			Font var5 = GrandExchangeOffer.fontBold12;
			String var6;
			if (var4 < 0) {
				var6 = "";
			} else if (menuTargets[var4].length() > 0) {
				var6 = menuActions[var4] + " " + menuTargets[var4];
			} else {
				var6 = menuActions[var4];
			}

			int var7 = var5.stringWidth(var6);
			if (var7 > var3) {
				var3 = var7;
			}
		}

		var3 += 8;
		var4 = menuOptionsCount * 15 + 22;
		int var8 = var1 - var3 / 2;
		if (var8 + var3 > GrandExchangeOfferTotalQuantityComparator.canvasWidth) {
			var8 = GrandExchangeOfferTotalQuantityComparator.canvasWidth - var3;
		}

		if (var8 < 0) {
			var8 = 0;
		}

		int var9 = var2;
		if (var4 + var2 > AttackOption.canvasHeight) {
			var9 = AttackOption.canvasHeight - var4;
		}

		if (var9 < 0) {
			var9 = 0;
		}

		GrandExchangeEvent.menuX = var8;
		WorldMapManager.menuY = var9;
		KeyHandler.menuWidth = var3;
		class54.menuHeight = menuOptionsCount * 15 + 22;
		class14.scene.menuOpen(UrlRequest.Client_plane, var1, var2, false);
		isMenuOpen = true;
	}

	@ObfuscatedName("js")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-2076621933"
	)
	@Export("resizeRoot")
	final void resizeRoot(boolean var1) {
		LoginPacket.method3572(rootInterface, GrandExchangeOfferTotalQuantityComparator.canvasWidth, AttackOption.canvasHeight, var1);
	}

	@ObfuscatedName("jw")
	@ObfuscatedSignature(
		signature = "(Lha;I)V",
		garbageValue = "-654127595"
	)
	@Export("alignWidget")
	void alignWidget(Widget var1) {
		Widget var2 = var1.parentId == -1 ? null : Tile.getWidget(var1.parentId);
		int var3;
		int var4;
		if (var2 == null) {
			var3 = GrandExchangeOfferTotalQuantityComparator.canvasWidth;
			var4 = AttackOption.canvasHeight;
		} else {
			var3 = var2.width;
			var4 = var2.height;
		}

		class32.alignWidgetSize(var1, var3, var4, false);
		class2.alignWidgetPosition(var1, var3, var4);
	}

	@ObfuscatedName("jq")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-642381621"
	)
	final void method1310() {
		LoginPacket.invalidateWidget(clickedWidget);
		++WorldMapSection2.widgetDragDuration;
		if (field809 && field806) {
			int var1 = MouseHandler.MouseHandler_x;
			int var2 = MouseHandler.MouseHandler_y;
			var1 -= widgetClickX;
			var2 -= widgetClickY;
			if (var1 < field807) {
				var1 = field807;
			}

			if (var1 + clickedWidget.width > field807 + clickedWidgetParent.width) {
				var1 = field807 + clickedWidgetParent.width - clickedWidget.width;
			}

			if (var2 < field808) {
				var2 = field808;
			}

			if (var2 + clickedWidget.height > field808 + clickedWidgetParent.height) {
				var2 = field808 + clickedWidgetParent.height - clickedWidget.height;
			}

			int var3 = var1 - field882;
			int var4 = var2 - field811;
			int var5 = clickedWidget.dragZoneSize;
			if (WorldMapSection2.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
				isDraggingWidget = true;
			}

			int var6 = var1 - field807 + clickedWidgetParent.scrollX;
			int var7 = var2 - field808 + clickedWidgetParent.scrollY;
			ScriptEvent var8;
			if (clickedWidget.onDrag != null && isDraggingWidget) {
				var8 = new ScriptEvent();
				var8.widget = clickedWidget;
				var8.mouseX = var6;
				var8.mouseY = var7;
				var8.args = clickedWidget.onDrag;
				runScriptEvent(var8);
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
						runScriptEvent(var8);
					}

					if (draggedOnWidget != null && StudioGame.method4116(clickedWidget) != null) {
						PacketBufferNode var11 = class2.getPacketBufferNode(ClientPacket.field2209, packetWriter.isaacCipher);
						var11.packetBuffer.writeIntME(draggedOnWidget.itemId);
						var11.packetBuffer.method5579(clickedWidget.itemId);
						var11.packetBuffer.writeShort(clickedWidget.childIndex);
						var11.packetBuffer.method5746(draggedOnWidget.childIndex);
						var11.packetBuffer.writeInt(clickedWidget.id);
						var11.packetBuffer.writeInt(draggedOnWidget.id);
						packetWriter.addNode(var11);
					}
				} else if (this.shouldLeftClickOpenMenu()) {
					this.openMenu(field882 + widgetClickX, widgetClickY + field811);
				} else if (menuOptionsCount > 0) {
					int var10 = widgetClickX + field882;
					int var9 = widgetClickY + field811;
					Messages.method2231(LoginType.tempMenuAction, var10, var9);
					LoginType.tempMenuAction = null;
				}

				clickedWidget = null;
			}

		} else {
			if (WorldMapSection2.widgetDragDuration > 1) {
				clickedWidget = null;
			}

		}
	}

	@ObfuscatedName("lv")
	@ObfuscatedSignature(
		signature = "(I)Ljc;",
		garbageValue = "83008429"
	)
	@Export("username")
	public Username username() {
		return Message.localPlayer != null ? Message.localPlayer.username : null;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lbm;I)V",
		garbageValue = "-74737560"
	)
	@Export("runScriptEvent")
	public static void runScriptEvent(ScriptEvent var0) {
		GrandExchangeEvents.runScript(var0, 500000);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "0"
	)
	static int method1740(int var0) {
		return (int)((Math.log((double)var0) / Interpreter.field1083 - 7.0D) * 256.0D);
	}
}
