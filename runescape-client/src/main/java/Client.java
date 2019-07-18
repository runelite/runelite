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
	@ObfuscatedName("mz")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("clickedWidget")
	static Widget clickedWidget;
	@ObfuscatedName("ou")
	@ObfuscatedGetter(
		intValue = -2092613105
	)
	@Export("rootWidgetCount")
	static int rootWidgetCount;
	@ObfuscatedName("on")
	@ObfuscatedGetter(
		intValue = -2121832293
	)
	static int field741;
	@ObfuscatedName("oz")
	@ObfuscatedGetter(
		longValue = 3232986536737283167L
	)
	static long field868;
	@ObfuscatedName("qe")
	static boolean field699;
	@ObfuscatedName("os")
	static boolean[] field843;
	@ObfuscatedName("oh")
	static boolean[] field862;
	@ObfuscatedName("ot")
	static boolean[] field861;
	@ObfuscatedName("nt")
	static boolean field745;
	@ObfuscatedName("nh")
	@ObfuscatedGetter(
		intValue = -800135319
	)
	@Export("cycleCntr")
	static int cycleCntr;
	@ObfuscatedName("ob")
	@Export("isResizable")
	static boolean isResizable;
	@ObfuscatedName("sl")
	@ObfuscatedGetter(
		intValue = -441370687
	)
	public static int field924;
	@ObfuscatedName("ny")
	@ObfuscatedGetter(
		intValue = 791405777
	)
	static int field672;
	@ObfuscatedName("nr")
	static boolean field873;
	@ObfuscatedName("mo")
	@ObfuscatedGetter(
		intValue = -1889780377
	)
	@Export("widgetClickX")
	static int widgetClickX;
	@ObfuscatedName("mi")
	@ObfuscatedGetter(
		intValue = -367998477
	)
	@Export("widgetClickY")
	static int widgetClickY;
	@ObfuscatedName("nx")
	@ObfuscatedGetter(
		intValue = -1397532923
	)
	static int field834;
	@ObfuscatedName("of")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	@Export("widgetClickMasks")
	static NodeHashTable widgetClickMasks;
	@ObfuscatedName("mf")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("clickedWidgetParent")
	static Widget clickedWidgetParent;
	@ObfuscatedName("oj")
	@Export("rootWidgetXs")
	static int[] rootWidgetXs;
	@ObfuscatedName("od")
	@Export("rootWidgetWidths")
	static int[] rootWidgetWidths;
	@ObfuscatedName("ni")
	@ObfuscatedGetter(
		intValue = 583654473
	)
	static int field835;
	@ObfuscatedName("mg")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("viewportWidget")
	static Widget viewportWidget;
	@ObfuscatedName("op")
	@ObfuscatedGetter(
		intValue = -1450875753
	)
	@Export("gameDrawingMode")
	static int gameDrawingMode;
	@ObfuscatedName("om")
	@Export("rootWidgetHeights")
	static int[] rootWidgetHeights;
	@ObfuscatedName("md")
	@ObfuscatedGetter(
		intValue = -1872633373
	)
	@Export("staffModLevel")
	public static int staffModLevel;
	@ObfuscatedName("oo")
	@Export("rootWidgetYs")
	static int[] rootWidgetYs;
	@ObfuscatedName("qc")
	@ObfuscatedGetter(
		intValue = -1390257223
	)
	@Export("minimapState")
	static int minimapState;
	@ObfuscatedName("tn")
	@ObfuscatedSignature(
		signature = "Lbl;"
	)
	static final class65 field735;
	@ObfuscatedName("og")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("scriptEvents")
	static NodeDeque scriptEvents;
	@ObfuscatedName("py")
	@ObfuscatedGetter(
		intValue = 1200756083
	)
	@Export("destinationX")
	static int destinationX;
	@ObfuscatedName("ns")
	@ObfuscatedGetter(
		intValue = 1534205153
	)
	static int field837;
	@ObfuscatedName("pe")
	@ObfuscatedGetter(
		intValue = -1422277425
	)
	@Export("destinationY")
	static int destinationY;
	@ObfuscatedName("nq")
	@ObfuscatedGetter(
		intValue = -22489899
	)
	static int field838;
	@ObfuscatedName("tq")
	static int[] field929;
	@ObfuscatedName("nl")
	static int[] field888;
	@ObfuscatedName("tz")
	static int[] field930;
	@ObfuscatedName("nm")
	@ObfuscatedGetter(
		intValue = 1100765031
	)
	static int field671;
	@ObfuscatedName("nn")
	@Export("isDraggingWidget")
	static boolean isDraggingWidget;
	@ObfuscatedName("my")
	@ObfuscatedGetter(
		intValue = 1548302943
	)
	@Export("runEnergy")
	static int runEnergy;
	@ObfuscatedName("nk")
	static int[] field863;
	@ObfuscatedName("nu")
	@ObfuscatedGetter(
		intValue = -1356950915
	)
	static int field844;
	@ObfuscatedName("nf")
	@ObfuscatedGetter(
		intValue = 1622588879
	)
	static int field806;
	@ObfuscatedName("mh")
	@ObfuscatedGetter(
		intValue = 1071213383
	)
	@Export("weight")
	static int weight;
	@ObfuscatedName("qr")
	@ObfuscatedGetter(
		intValue = -582627637
	)
	static int field892;
	@ObfuscatedName("qg")
	@ObfuscatedGetter(
		intValue = -1930874469
	)
	@Export("soundEffectVolume")
	static int soundEffectVolume;
	@ObfuscatedName("sc")
	@ObfuscatedGetter(
		intValue = 1724997489
	)
	static int field919;
	@ObfuscatedName("rg")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	@Export("playerAppearance")
	static PlayerAppearance playerAppearance;
	@ObfuscatedName("qq")
	@ObfuscatedGetter(
		intValue = 1799450873
	)
	@Export("soundEffectCount")
	static int soundEffectCount;
	@ObfuscatedName("rt")
	static boolean[] field886;
	@ObfuscatedName("qd")
	@Export("soundEffectIds")
	static int[] soundEffectIds;
	@ObfuscatedName("qi")
	@Export("isCameraLocked")
	static boolean isCameraLocked;
	@ObfuscatedName("rh")
	static int[] field901;
	@ObfuscatedName("sp")
	@ObfuscatedGetter(
		intValue = 1680257497
	)
	static int field920;
	@ObfuscatedName("oc")
	@ObfuscatedGetter(
		intValue = 328709835
	)
	@Export("mouseWheelRotation")
	static int mouseWheelRotation;
	@ObfuscatedName("me")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("draggedOnWidget")
	static Widget draggedOnWidget;
	@ObfuscatedName("qs")
	@Export("queuedSoundEffectLoops")
	static int[] queuedSoundEffectLoops;
	@ObfuscatedName("rl")
	static int[] field902;
	@ObfuscatedName("rn")
	static int[] field903;
	@ObfuscatedName("qo")
	@Export("queuedSoundEffectDelays")
	static int[] queuedSoundEffectDelays;
	@ObfuscatedName("ri")
	static int[] field904;
	@ObfuscatedName("qx")
	@ObfuscatedSignature(
		signature = "[Lcc;"
	)
	@Export("soundEffects")
	static SoundEffect[] soundEffects;
	@ObfuscatedName("qt")
	@Export("soundLocations")
	static int[] soundLocations;
	@ObfuscatedName("qh")
	@ObfuscatedGetter(
		intValue = 1808140467
	)
	static int field911;
	@ObfuscatedName("qf")
	@ObfuscatedGetter(
		intValue = 374364257
	)
	static int field889;
	@ObfuscatedName("so")
	@Export("archiveLoaders")
	static ArrayList archiveLoaders;
	@ObfuscatedName("sj")
	@ObfuscatedGetter(
		intValue = 510604993
	)
	@Export("archiveLoaderArchive")
	static int archiveLoaderArchive;
	@ObfuscatedName("pb")
	@ObfuscatedGetter(
		intValue = -73161017
	)
	static int field747;
	@ObfuscatedName("mv")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	static Widget field850;
	@ObfuscatedName("mx")
	@ObfuscatedGetter(
		intValue = 176559841
	)
	@Export("chatEffects")
	static int chatEffects;
	@ObfuscatedName("mt")
	@ObfuscatedGetter(
		intValue = -112633937
	)
	static int field809;
	@ObfuscatedName("ms")
	@ObfuscatedGetter(
		intValue = -1088998805
	)
	@Export("followerIndex")
	static int followerIndex;
	@ObfuscatedName("pg")
	@ObfuscatedGetter(
		intValue = -1777296197
	)
	@Export("mapIconCount")
	static int mapIconCount;
	@ObfuscatedName("nv")
	@ObfuscatedGetter(
		intValue = -1637199243
	)
	static int field849;
	@ObfuscatedName("sn")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	@Export("platformInfoProvider")
	static PlatformInfoProvider platformInfoProvider;
	@ObfuscatedName("rf")
	static short field782;
	@ObfuscatedName("pz")
	@Export("mapIconXs")
	static int[] mapIconXs;
	@ObfuscatedName("rs")
	static short field651;
	@ObfuscatedName("rm")
	static short field732;
	@ObfuscatedName("rp")
	static short field659;
	@ObfuscatedName("ry")
	static short field790;
	@ObfuscatedName("ru")
	@ObfuscatedGetter(
		intValue = -1499125381
	)
	@Export("viewportZoom")
	static int viewportZoom;
	@ObfuscatedName("ph")
	@Export("mapIconYs")
	static int[] mapIconYs;
	@ObfuscatedName("re")
	static short field820;
	@ObfuscatedName("rw")
	@ObfuscatedGetter(
		intValue = 1398487807
	)
	@Export("viewportWidth")
	static int viewportWidth;
	@ObfuscatedName("pu")
	@ObfuscatedSignature(
		signature = "[Lly;"
	)
	@Export("mapIcons")
	static Sprite[] mapIcons;
	@ObfuscatedName("pc")
	@ObfuscatedGetter(
		intValue = -1217345061
	)
	static int field754;
	@ObfuscatedName("pa")
	static long[] field922;
	@ObfuscatedName("po")
	@ObfuscatedGetter(
		longValue = -4978726531999304555L
	)
	static long field879;
	@ObfuscatedName("ro")
	@ObfuscatedGetter(
		intValue = 1243224603
	)
	@Export("viewportHeight")
	static int viewportHeight;
	@ObfuscatedName("nj")
	@Export("changedSkills")
	static int[] changedSkills;
	@ObfuscatedName("rd")
	@ObfuscatedGetter(
		intValue = 355845697
	)
	@Export("viewportOffsetX")
	static int viewportOffsetX;
	@ObfuscatedName("no")
	@ObfuscatedGetter(
		intValue = 872784567
	)
	@Export("changedSkillsCount")
	static int changedSkillsCount;
	@ObfuscatedName("rq")
	@ObfuscatedGetter(
		intValue = -1819632499
	)
	@Export("viewportOffsetY")
	static int viewportOffsetY;
	@ObfuscatedName("sf")
	@ObfuscatedSignature(
		signature = "[Lf;"
	)
	@Export("grandExchangeOffers")
	static GrandExchangeOffer[] grandExchangeOffers;
	@ObfuscatedName("ra")
	static short field906;
	@ObfuscatedName("rv")
	static short field908;
	@ObfuscatedName("pw")
	@ObfuscatedGetter(
		intValue = 1092581053
	)
	static int field875;
	@ObfuscatedName("nb")
	@ObfuscatedGetter(
		intValue = 1755198585
	)
	static int field915;
	@ObfuscatedName("pk")
	static int[] field921;
	@ObfuscatedName("ok")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	static NodeDeque field852;
	@ObfuscatedName("pd")
	static int[] field877;
	@ObfuscatedName("ov")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	static NodeDeque field856;
	@ObfuscatedName("st")
	@ObfuscatedGetter(
		intValue = 980120409
	)
	static int field927;
	@ObfuscatedName("nw")
	@ObfuscatedGetter(
		intValue = -382720859
	)
	@Export("chatCycle")
	static int chatCycle;
	@ObfuscatedName("mc")
	@ObfuscatedGetter(
		intValue = 431417087
	)
	static int field817;
	@ObfuscatedName("mm")
	@Export("playerMod")
	static boolean playerMod;
	@ObfuscatedName("mw")
	@ObfuscatedGetter(
		intValue = -49080109
	)
	static int field818;
	@ObfuscatedName("pl")
	@ObfuscatedGetter(
		intValue = -602987385
	)
	static int field872;
	@ObfuscatedName("pv")
	@ObfuscatedGetter(
		intValue = -547874643
	)
	@Export("publicChatMode")
	static int publicChatMode;
	@ObfuscatedName("nz")
	@ObfuscatedGetter(
		intValue = -792356641
	)
	static int field851;
	@ObfuscatedName("pj")
	static String field762;
	@ObfuscatedName("sb")
	@ObfuscatedSignature(
		signature = "Lby;"
	)
	@Export("GrandExchangeEvents_worldComparator")
	static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
	@ObfuscatedName("ps")
	static int[] field870;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "[Lfv;"
	)
	@Export("collisionMaps")
	static CollisionMap[] collisionMaps;
	@ObfuscatedName("ab")
	static boolean field912;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = -1673280657
	)
	@Export("worldId")
	public static int worldId;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = 5468995
	)
	@Export("worldProperties")
	static int worldProperties;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = -1579822855
	)
	@Export("gameBuild")
	static int gameBuild;
	@ObfuscatedName("bn")
	@Export("isMembersWorld")
	public static boolean isMembersWorld;
	@ObfuscatedName("bc")
	@Export("isLowDetail")
	static boolean isLowDetail;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = 483842531
	)
	@Export("clientType")
	static int clientType;
	@ObfuscatedName("bl")
	@Export("onMobile")
	static boolean onMobile;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = -1965849977
	)
	@Export("gameState")
	static int gameState;
	@ObfuscatedName("ct")
	@Export("isLoading")
	static boolean isLoading;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = 594809673
	)
	@Export("cycle")
	static int cycle;
	@ObfuscatedName("cp")
	@ObfuscatedGetter(
		longValue = -8976739109298152429L
	)
	@Export("mouseLastLastPressedTimeMillis")
	static long mouseLastLastPressedTimeMillis;
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = -315292611
	)
	static int field717;
	@ObfuscatedName("cw")
	@ObfuscatedGetter(
		intValue = -1280751431
	)
	static int field665;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		longValue = 4427744799360755687L
	)
	static long field666;
	@ObfuscatedName("cb")
	static boolean field667;
	@ObfuscatedName("cx")
	@Export("displayFps")
	static boolean displayFps;
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		intValue = 1770117359
	)
	@Export("rebootTimer")
	static int rebootTimer;
	@ObfuscatedName("cs")
	@ObfuscatedGetter(
		intValue = -1858899151
	)
	@Export("hintArrowType")
	static int hintArrowType;
	@ObfuscatedName("cg")
	@ObfuscatedGetter(
		intValue = -1235944977
	)
	@Export("hintArrowNpcIndex")
	static int hintArrowNpcIndex;
	@ObfuscatedName("cv")
	@ObfuscatedGetter(
		intValue = -837382687
	)
	@Export("hintArrowPlayerIndex")
	static int hintArrowPlayerIndex;
	@ObfuscatedName("ce")
	@ObfuscatedGetter(
		intValue = 139732677
	)
	@Export("hintArrowX")
	static int hintArrowX;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = -722044991
	)
	@Export("hintArrowY")
	static int hintArrowY;
	@ObfuscatedName("cm")
	@ObfuscatedGetter(
		intValue = -1604787030
	)
	@Export("hintArrowHeight")
	static int hintArrowHeight;
	@ObfuscatedName("ck")
	@ObfuscatedGetter(
		intValue = -317820992
	)
	@Export("hintArrowSubX")
	static int hintArrowSubX;
	@ObfuscatedName("cc")
	@ObfuscatedGetter(
		intValue = -1180209715
	)
	@Export("hintArrowSubY")
	static int hintArrowSubY;
	@ObfuscatedName("cd")
	@ObfuscatedSignature(
		signature = "Lct;"
	)
	@Export("playerAttackOption")
	static AttackOption playerAttackOption;
	@ObfuscatedName("dr")
	@ObfuscatedSignature(
		signature = "Lct;"
	)
	@Export("npcAttackOption")
	static AttackOption npcAttackOption;
	@ObfuscatedName("dw")
	@ObfuscatedGetter(
		intValue = -452542481
	)
	@Export("titleLoadingStage")
	static int titleLoadingStage;
	@ObfuscatedName("dt")
	@ObfuscatedGetter(
		intValue = -371718323
	)
	@Export("js5ConnectState")
	static int js5ConnectState;
	@ObfuscatedName("dj")
	@ObfuscatedGetter(
		intValue = -1459342861
	)
	static int field682;
	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive8")
	static Archive archive8;
	@ObfuscatedName("dd")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive18")
	static Archive archive18;
	@ObfuscatedName("ej")
	@ObfuscatedGetter(
		intValue = -3082483
	)
	@Export("js5Errors")
	static int js5Errors;
	@ObfuscatedName("eu")
	@ObfuscatedGetter(
		intValue = -787005109
	)
	@Export("loginState")
	static int loginState;
	@ObfuscatedName("eo")
	@ObfuscatedGetter(
		intValue = -829514867
	)
	static int field687;
	@ObfuscatedName("em")
	@ObfuscatedGetter(
		intValue = -1325230059
	)
	static int field688;
	@ObfuscatedName("en")
	@ObfuscatedGetter(
		intValue = -2114710821
	)
	static int field836;
	@ObfuscatedName("ek")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	static class160 field690;
	@ObfuscatedName("ep")
	@Export("Login_isUsernameRemembered")
	static boolean Login_isUsernameRemembered;
	@ObfuscatedName("eq")
	@ObfuscatedSignature(
		signature = "Lco;"
	)
	@Export("secureRandomFuture")
	static SecureRandomFuture secureRandomFuture;
	@ObfuscatedName("ee")
	static byte[] field693;
	@ObfuscatedName("ec")
	@ObfuscatedSignature(
		signature = "[Lcf;"
	)
	@Export("npcs")
	static NPC[] npcs;
	@ObfuscatedName("eb")
	@ObfuscatedGetter(
		intValue = 1517220319
	)
	@Export("npcCount")
	static int npcCount;
	@ObfuscatedName("fi")
	@Export("npcIndices")
	static int[] npcIndices;
	@ObfuscatedName("fk")
	@ObfuscatedGetter(
		intValue = -48606641
	)
	static int field697;
	@ObfuscatedName("fg")
	static int[] field859;
	@ObfuscatedName("fr")
	@ObfuscatedSignature(
		signature = "Lcg;"
	)
	@Export("packetWriter")
	public static final PacketWriter packetWriter;
	@ObfuscatedName("ft")
	@ObfuscatedGetter(
		intValue = 722667803
	)
	static int field700;
	@ObfuscatedName("fe")
	static boolean field701;
	@ObfuscatedName("fa")
	@Export("useBufferedSocket")
	static boolean useBufferedSocket;
	@ObfuscatedName("fs")
	@ObfuscatedSignature(
		signature = "Ljr;"
	)
	@Export("timer")
	static Timer timer;
	@ObfuscatedName("fv")
	@Export("fontsMap")
	static HashMap fontsMap;
	@ObfuscatedName("fc")
	@ObfuscatedGetter(
		intValue = -1588873731
	)
	static int field705;
	@ObfuscatedName("fw")
	@ObfuscatedGetter(
		intValue = -793247523
	)
	static int field706;
	@ObfuscatedName("fh")
	@ObfuscatedGetter(
		intValue = 1860321263
	)
	static int field707;
	@ObfuscatedName("gc")
	@ObfuscatedGetter(
		intValue = -665684815
	)
	static int field896;
	@ObfuscatedName("gx")
	@ObfuscatedGetter(
		intValue = -954194667
	)
	static int field709;
	@ObfuscatedName("gj")
	@Export("isInInstance")
	static boolean isInInstance;
	@ObfuscatedName("gd")
	@Export("instanceChunkTemplates")
	static int[][][] instanceChunkTemplates;
	@ObfuscatedName("gt")
	static final int[] field713;
	@ObfuscatedName("gk")
	@ObfuscatedGetter(
		intValue = -540714619
	)
	static int field718;
	@ObfuscatedName("ha")
	@ObfuscatedGetter(
		intValue = 1887719159
	)
	static int field715;
	@ObfuscatedName("hk")
	@ObfuscatedGetter(
		intValue = 1382994973
	)
	static int field716;
	@ObfuscatedName("hu")
	@ObfuscatedGetter(
		intValue = 1317142395
	)
	static int field720;
	@ObfuscatedName("hg")
	@ObfuscatedGetter(
		intValue = -2094416073
	)
	static int field772;
	@ObfuscatedName("he")
	static boolean field719;
	@ObfuscatedName("hv")
	@ObfuscatedGetter(
		intValue = 1590040777
	)
	static int field882;
	@ObfuscatedName("hz")
	@ObfuscatedGetter(
		intValue = -404113937
	)
	@Export("camAngleX")
	static int camAngleX;
	@ObfuscatedName("ho")
	@ObfuscatedGetter(
		intValue = -637746905
	)
	@Export("camAngleY")
	static int camAngleY;
	@ObfuscatedName("hs")
	@ObfuscatedGetter(
		intValue = -719815433
	)
	@Export("camAngleDY")
	static int camAngleDY;
	@ObfuscatedName("hx")
	@ObfuscatedGetter(
		intValue = 1112873513
	)
	@Export("camAngleDX")
	static int camAngleDX;
	@ObfuscatedName("hf")
	@ObfuscatedGetter(
		intValue = 79946767
	)
	@Export("mouseCamClickedX")
	static int mouseCamClickedX;
	@ObfuscatedName("hw")
	@ObfuscatedGetter(
		intValue = 991416029
	)
	@Export("mouseCamClickedY")
	static int mouseCamClickedY;
	@ObfuscatedName("hi")
	@ObfuscatedGetter(
		intValue = 107452813
	)
	@Export("oculusOrbState")
	static int oculusOrbState;
	@ObfuscatedName("hn")
	@ObfuscatedGetter(
		intValue = 1876317847
	)
	@Export("camFollowHeight")
	static int camFollowHeight;
	@ObfuscatedName("hl")
	@ObfuscatedGetter(
		intValue = 803728993
	)
	static int field729;
	@ObfuscatedName("hq")
	@ObfuscatedGetter(
		intValue = -1013143657
	)
	static int field928;
	@ObfuscatedName("hp")
	@ObfuscatedGetter(
		intValue = 1195552185
	)
	static int field731;
	@ObfuscatedName("ir")
	@ObfuscatedGetter(
		intValue = -199932621
	)
	static int field871;
	@ObfuscatedName("ii")
	@ObfuscatedGetter(
		intValue = 424110155
	)
	@Export("oculusOrbNormalSpeed")
	static int oculusOrbNormalSpeed;
	@ObfuscatedName("ih")
	@ObfuscatedGetter(
		intValue = 1830393715
	)
	@Export("oculusOrbSlowedSpeed")
	static int oculusOrbSlowedSpeed;
	@ObfuscatedName("if")
	@ObfuscatedGetter(
		intValue = 1225894931
	)
	static int field855;
	@ObfuscatedName("ig")
	static boolean field736;
	@ObfuscatedName("ik")
	@ObfuscatedGetter(
		intValue = -609136969
	)
	static int field822;
	@ObfuscatedName("iw")
	static boolean field878;
	@ObfuscatedName("id")
	@ObfuscatedGetter(
		intValue = -1173416107
	)
	static int field739;
	@ObfuscatedName("ib")
	@ObfuscatedGetter(
		intValue = -1867488915
	)
	@Export("overheadTextCount")
	static int overheadTextCount;
	@ObfuscatedName("ic")
	@ObfuscatedGetter(
		intValue = -115800179
	)
	@Export("overheadTextLimit")
	static int overheadTextLimit;
	@ObfuscatedName("im")
	@Export("overheadTextXs")
	static int[] overheadTextXs;
	@ObfuscatedName("ip")
	@Export("overheadTextYs")
	static int[] overheadTextYs;
	@ObfuscatedName("il")
	@Export("overheadTextAscents")
	static int[] overheadTextAscents;
	@ObfuscatedName("ia")
	@Export("overheadTextXOffsets")
	static int[] overheadTextXOffsets;
	@ObfuscatedName("ie")
	@Export("overheadTextColors")
	static int[] overheadTextColors;
	@ObfuscatedName("in")
	@Export("overheadTextEffects")
	static int[] overheadTextEffects;
	@ObfuscatedName("iv")
	@Export("overheadTextCyclesRemaining")
	static int[] overheadTextCyclesRemaining;
	@ObfuscatedName("io")
	@Export("overheadText")
	static String[] overheadText;
	@ObfuscatedName("iy")
	@Export("tileLastDrawnActor")
	static int[][] tileLastDrawnActor;
	@ObfuscatedName("iq")
	@ObfuscatedGetter(
		intValue = -448428969
	)
	@Export("viewportDrawCount")
	static int viewportDrawCount;
	@ObfuscatedName("ij")
	@ObfuscatedGetter(
		intValue = -532739551
	)
	@Export("viewportTempX")
	static int viewportTempX;
	@ObfuscatedName("it")
	@Export("selectedItemName")
	static String selectedItemName;
	@ObfuscatedName("is")
	@ObfuscatedGetter(
		intValue = 1355001797
	)
	@Export("viewportTempY")
	static int viewportTempY;
	@ObfuscatedName("ju")
	@ObfuscatedGetter(
		intValue = 410769587
	)
	@Export("mouseCrossX")
	static int mouseCrossX;
	@ObfuscatedName("jh")
	@ObfuscatedGetter(
		intValue = -2093504551
	)
	@Export("mouseCrossY")
	static int mouseCrossY;
	@ObfuscatedName("je")
	@ObfuscatedGetter(
		intValue = -189615988
	)
	@Export("mouseCrossState")
	static int mouseCrossState;
	@ObfuscatedName("jl")
	@ObfuscatedGetter(
		intValue = -183021951
	)
	@Export("mouseCrossColor")
	static int mouseCrossColor;
	@ObfuscatedName("jq")
	@Export("showMouseCross")
	static boolean showMouseCross;
	@ObfuscatedName("jt")
	@ObfuscatedGetter(
		intValue = 600396425
	)
	static int field759;
	@ObfuscatedName("jn")
	@ObfuscatedGetter(
		intValue = 939295689
	)
	static int field698;
	@ObfuscatedName("jm")
	@ObfuscatedGetter(
		intValue = -1095334823
	)
	@Export("dragItemSlotSource")
	static int dragItemSlotSource;
	@ObfuscatedName("jj")
	@ObfuscatedGetter(
		intValue = 697955855
	)
	static int field654;
	@ObfuscatedName("jr")
	@ObfuscatedGetter(
		intValue = 528486729
	)
	static int field763;
	@ObfuscatedName("jw")
	@ObfuscatedGetter(
		intValue = -552088935
	)
	@Export("dragItemSlotDestination")
	static int dragItemSlotDestination;
	@ObfuscatedName("jd")
	static boolean field874;
	@ObfuscatedName("ja")
	@ObfuscatedGetter(
		intValue = -1275196777
	)
	@Export("itemDragDuration")
	static int itemDragDuration;
	@ObfuscatedName("jf")
	@ObfuscatedGetter(
		intValue = 1610586469
	)
	static int field767;
	@ObfuscatedName("jo")
	@Export("showLoadingMessages")
	static boolean showLoadingMessages;
	@ObfuscatedName("jg")
	@ObfuscatedSignature(
		signature = "[Lbd;"
	)
	@Export("players")
	static Player[] players;
	@ObfuscatedName("jc")
	@ObfuscatedGetter(
		intValue = -1642092337
	)
	@Export("localPlayerIndex")
	static int localPlayerIndex;
	@ObfuscatedName("jv")
	@ObfuscatedGetter(
		intValue = -1101635381
	)
	static int field771;
	@ObfuscatedName("js")
	@ObfuscatedSignature(
		signature = "Lbd;"
	)
	@Export("localPlayer")
	static Player localPlayer;
	@ObfuscatedName("jx")
	@Export("renderSelf")
	static boolean renderSelf;
	@ObfuscatedName("kk")
	@ObfuscatedGetter(
		intValue = -36674671
	)
	static int field774;
	@ObfuscatedName("kv")
	@ObfuscatedGetter(
		intValue = -469680529
	)
	static int field775;
	@ObfuscatedName("kd")
	static int[] field776;
	@ObfuscatedName("kz")
	@Export("playerMenuOpcodes")
	static final int[] playerMenuOpcodes;
	@ObfuscatedName("ke")
	@Export("playerMenuActions")
	static String[] playerMenuActions;
	@ObfuscatedName("kn")
	@Export("playerOptionsPriorities")
	static boolean[] playerOptionsPriorities;
	@ObfuscatedName("kh")
	static int[] field780;
	@ObfuscatedName("kq")
	@ObfuscatedGetter(
		intValue = -1939972393
	)
	@Export("combatTargetPlayerIndex")
	static int combatTargetPlayerIndex;
	@ObfuscatedName("kx")
	@ObfuscatedSignature(
		signature = "[[[Ljh;"
	)
	@Export("groundItems")
	static NodeDeque[][][] groundItems;
	@ObfuscatedName("kf")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("pendingSpawns")
	static NodeDeque pendingSpawns;
	@ObfuscatedName("kw")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("projectiles")
	static NodeDeque projectiles;
	@ObfuscatedName("kr")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("graphicsObjects")
	static NodeDeque graphicsObjects;
	@ObfuscatedName("ki")
	@Export("currentLevels")
	static int[] currentLevels;
	@ObfuscatedName("kg")
	@Export("levels")
	static int[] levels;
	@ObfuscatedName("ky")
	@Export("experience")
	static int[] experience;
	@ObfuscatedName("kb")
	@ObfuscatedGetter(
		intValue = 1151779303
	)
	static int field789;
	@ObfuscatedName("kp")
	@Export("isMenuOpen")
	static boolean isMenuOpen;
	@ObfuscatedName("ln")
	@ObfuscatedGetter(
		intValue = 1305438411
	)
	@Export("menuOptionsCount")
	static int menuOptionsCount;
	@ObfuscatedName("lq")
	@Export("menuArguments1")
	static int[] menuArguments1;
	@ObfuscatedName("le")
	@Export("menuArguments2")
	static int[] menuArguments2;
	@ObfuscatedName("la")
	@Export("menuOpcodes")
	static int[] menuOpcodes;
	@ObfuscatedName("lg")
	@Export("menuArguments0")
	static int[] menuArguments0;
	@ObfuscatedName("lc")
	@Export("menuActions")
	static String[] menuActions;
	@ObfuscatedName("ls")
	@Export("menuTargetNames")
	static String[] menuTargetNames;
	@ObfuscatedName("lk")
	@Export("menuShiftClick")
	static boolean[] menuShiftClick;
	@ObfuscatedName("lb")
	@Export("followerOpsLowPriority")
	static boolean followerOpsLowPriority;
	@ObfuscatedName("ll")
	@Export("shiftClickDrop")
	static boolean shiftClickDrop;
	@ObfuscatedName("lx")
	@Export("tapToDrop")
	static boolean tapToDrop;
	@ObfuscatedName("ly")
	@Export("showMouseOverText")
	static boolean showMouseOverText;
	@ObfuscatedName("lm")
	@ObfuscatedGetter(
		intValue = 1100971195
	)
	static int field803;
	@ObfuscatedName("lz")
	@ObfuscatedGetter(
		intValue = 361474091
	)
	static int field804;
	@ObfuscatedName("lv")
	@ObfuscatedSignature(
		signature = "Lcn;"
	)
	@Export("tempMenuAction")
	static MenuAction tempMenuAction;
	@ObfuscatedName("lo")
	@ObfuscatedGetter(
		intValue = 1637922117
	)
	static int field840;
	@ObfuscatedName("lh")
	@ObfuscatedGetter(
		intValue = -1769719033
	)
	static int field833;
	@ObfuscatedName("lw")
	@ObfuscatedGetter(
		intValue = -1049024873
	)
	@Export("isItemSelected")
	static int isItemSelected;
	@ObfuscatedName("lj")
	@Export("isSpellSelected")
	static boolean isSpellSelected;
	@ObfuscatedName("li")
	@ObfuscatedGetter(
		intValue = -822866207
	)
	static int field848;
	@ObfuscatedName("mu")
	@ObfuscatedGetter(
		intValue = -897107203
	)
	static int field812;
	@ObfuscatedName("mq")
	@Export("selectedSpellActionName")
	static String selectedSpellActionName;
	@ObfuscatedName("ml")
	@Export("selectedSpellName")
	static String selectedSpellName;
	@ObfuscatedName("mn")
	@ObfuscatedGetter(
		intValue = 1510354633
	)
	@Export("rootInterface")
	static int rootInterface;
	@ObfuscatedName("ma")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	@Export("interfaceParents")
	static NodeHashTable interfaceParents;

	static {
		field912 = true;
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
		field717 = -1;
		field665 = -1;
		field666 = -1L;
		field667 = true;
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
		field682 = 0;
		js5Errors = 0;
		loginState = 0;
		field687 = 0;
		field688 = 0;
		field836 = 0;
		field690 = class160.field2001;
		Login_isUsernameRemembered = false;
		secureRandomFuture = new SecureRandomFuture();
		field693 = null;
		npcs = new NPC[32768];
		npcCount = 0;
		npcIndices = new int[32768];
		field697 = 0;
		field859 = new int[250];
		packetWriter = new PacketWriter();
		field700 = 0;
		field701 = false;
		useBufferedSocket = true;
		timer = new Timer();
		fontsMap = new HashMap();
		field705 = 0;
		field706 = 1;
		field707 = 0;
		field896 = 1;
		field709 = 0;
		collisionMaps = new CollisionMap[4];
		isInInstance = false;
		instanceChunkTemplates = new int[4][13][13];
		field713 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
		field718 = 0;
		field715 = 2301979;
		field716 = 5063219;
		field720 = 3353893;
		field772 = 7759444;
		field719 = false;
		field882 = 0;
		camAngleX = 128;
		camAngleY = 0;
		camAngleDY = 0;
		camAngleDX = 0;
		mouseCamClickedX = 0;
		mouseCamClickedY = 0;
		oculusOrbState = 0;
		camFollowHeight = 50;
		field928 = 0;
		field731 = 0;
		field871 = 0;
		oculusOrbNormalSpeed = 12;
		oculusOrbSlowedSpeed = 6;
		field855 = 0;
		field736 = false;
		field822 = 0;
		field878 = false;
		field739 = 0;
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
		field759 = 0;
		field698 = 0;
		dragItemSlotSource = 0;
		field654 = 0;
		field763 = 0;
		dragItemSlotDestination = 0;
		field874 = false;
		itemDragDuration = 0;
		field767 = 0;
		showLoadingMessages = true;
		players = new Player[2048];
		localPlayerIndex = -1;
		field771 = 0;
		renderSelf = true;
		field774 = 0;
		field775 = 0;
		field776 = new int[1000];
		playerMenuOpcodes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
		playerMenuActions = new String[8];
		playerOptionsPriorities = new boolean[8];
		field780 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
		combatTargetPlayerIndex = -1;
		groundItems = new NodeDeque[4][104][104];
		pendingSpawns = new NodeDeque();
		projectiles = new NodeDeque();
		graphicsObjects = new NodeDeque();
		currentLevels = new int[25];
		levels = new int[25];
		experience = new int[25];
		field789 = 0;
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
		field803 = -1;
		field804 = -1;
		field840 = 0;
		field833 = 50;
		isItemSelected = 0;
		selectedItemName = null;
		isSpellSelected = false;
		field848 = -1;
		field812 = -1;
		selectedSpellActionName = null;
		selectedSpellName = null;
		rootInterface = -1;
		interfaceParents = new NodeHashTable(8);
		field817 = 0;
		field818 = -1;
		chatEffects = 0;
		field809 = 0;
		field850 = null;
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
		field873 = false;
		field834 = -1;
		field835 = -1;
		field745 = false;
		field837 = -1;
		field838 = -1;
		isDraggingWidget = false;
		cycleCntr = 1;
		field863 = new int[32];
		field806 = 0;
		field888 = new int[32];
		field671 = 0;
		changedSkills = new int[32];
		changedSkillsCount = 0;
		chatCycle = 0;
		field672 = 0;
		field849 = 0;
		field915 = 0;
		field851 = 0;
		field844 = 0;
		mouseWheelRotation = 0;
		scriptEvents = new NodeDeque();
		field852 = new NodeDeque();
		field856 = new NodeDeque();
		widgetClickMasks = new NodeHashTable(512);
		rootWidgetCount = 0;
		field741 = -2;
		field843 = new boolean[100];
		field861 = new boolean[100];
		field862 = new boolean[100];
		rootWidgetXs = new int[100];
		rootWidgetYs = new int[100];
		rootWidgetWidths = new int[100];
		rootWidgetHeights = new int[100];
		gameDrawingMode = 0;
		field868 = 0L;
		isResizable = true;
		field870 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
		publicChatMode = 0;
		field872 = 0;
		field762 = "";
		field922 = new long[100];
		field875 = 0;
		field754 = 0;
		field877 = new int[128];
		field921 = new int[128];
		field879 = -1L;
		field747 = -1;
		mapIconCount = 0;
		mapIconXs = new int[1000];
		mapIconYs = new int[1000];
		mapIcons = new Sprite[1000];
		destinationX = 0;
		destinationY = 0;
		minimapState = 0;
		field911 = 255;
		field889 = -1;
		field699 = false;
		soundEffectVolume = 127;
		field892 = 127;
		soundEffectCount = 0;
		soundEffectIds = new int[50];
		queuedSoundEffectLoops = new int[50];
		queuedSoundEffectDelays = new int[50];
		soundLocations = new int[50];
		soundEffects = new SoundEffect[50];
		isCameraLocked = false;
		field886 = new boolean[5];
		field901 = new int[5];
		field902 = new int[5];
		field903 = new int[5];
		field904 = new int[5];
		field782 = 256;
		field651 = 205;
		field906 = 256;
		field908 = 320;
		field820 = 1;
		field790 = 32767;
		field732 = 1;
		field659 = 32767;
		viewportOffsetX = 0;
		viewportOffsetY = 0;
		viewportWidth = 0;
		viewportHeight = 0;
		viewportZoom = 0;
		playerAppearance = new PlayerAppearance();
		field919 = -1;
		field920 = -1;
		platformInfoProvider = new DesktopPlatformInfoProvider();
		grandExchangeOffers = new GrandExchangeOffer[8];
		GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
		field924 = -1;
		archiveLoaders = new ArrayList(10);
		archiveLoaderArchive = 0;
		field927 = 0;
		field735 = new class65();
		field929 = new int[50];
		field930 = new int[50];
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "869486116"
	)
	@Export("resizeGame")
	protected final void resizeGame() {
		field868 = DirectByteArrayCopier.currentTimeMs() + 500L;
		this.resizeJS();
		if (rootInterface != -1) {
			this.resizeRoot(true);
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2070235141"
	)
	@Export("setUp")
	protected final void setUp() {
		int[] var1 = new int[]{20, 260, 10000};
		int[] var2 = new int[]{1000, 100, 500};
		if (var1 != null && var2 != null) {
			ByteArrayPool.ByteArrayPool_alternativeSizes = var1;
			class43.ByteArrayPool_altSizeArrayCounts = new int[var1.length];
			class189.ByteArrayPool_arrays = new byte[var1.length][][];

			for (int var3 = 0; var3 < ByteArrayPool.ByteArrayPool_alternativeSizes.length; ++var3) {
				class189.ByteArrayPool_arrays[var3] = new byte[var2[var3]][];
			}
		} else {
			ByteArrayPool.ByteArrayPool_alternativeSizes = null;
			class43.ByteArrayPool_altSizeArrayCounts = null;
			class189.ByteArrayPool_arrays = null;
		}

		class190.port1 = gameBuild == 0 ? 43594 : worldId + 40000;
		Skeleton.port2 = gameBuild == 0 ? 443 : worldId + 50000;
		Varcs.port3 = class190.port1;
		ModelData0.field1870 = class215.field2540;
		class247.field3291 = class215.field2541;
		WorldMapCacheName.field309 = class215.field2542;
		Message.field604 = class215.field2546;
		SequenceDefinition.urlRequester = new UrlRequester();
		this.setUpKeyboard();
		this.setUpMouse();
		WorldMapManager.mouseWheel = this.mouseWheel();
		ScriptEvent.masterDisk = new ArchiveDisk(255, class167.dat2File, class167.idx255File, 500000);
		WorldMapLabelSize.clientPreferences = ModelData0.loadClientPreferences();
		this.setUpClipboard();
		class218.method4110(this, class60.null_string);
		if (gameBuild != 0) {
			displayFps = true;
		}

		Clock.setWindowedMode(WorldMapLabelSize.clientPreferences.windowMode);
		ArchiveLoader.friendSystem = new FriendSystem(class40.loginType);
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-3"
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
				int var6;
				try {
					if (class197.field2402 == 1) {
						var6 = Interpreter.midiPcmStream.method3707();
						if (var6 > 0 && Interpreter.midiPcmStream.isReady()) {
							var6 -= class197.field2404;
							if (var6 < 0) {
								var6 = 0;
							}

							Interpreter.midiPcmStream.method3706(var6);
						} else {
							Interpreter.midiPcmStream.clear();
							Interpreter.midiPcmStream.removeAll();
							if (GrandExchangeOfferNameComparator.musicTrackArchive != null) {
								class197.field2402 = 2;
							} else {
								class197.field2402 = 0;
							}

							UserComparator10.musicTrack = null;
							WorldMapLabelSize.soundCache = null;
						}
					}
				} catch (Exception var11) {
					var11.printStackTrace();
					Interpreter.midiPcmStream.clear();
					class197.field2402 = 0;
					UserComparator10.musicTrack = null;
					WorldMapLabelSize.soundCache = null;
					GrandExchangeOfferNameComparator.musicTrackArchive = null;
				}

				class186.playPcmPlayers();
				synchronized(KeyHandler.KeyHandler_instance) {
					++KeyHandler.KeyHandler_idleCycles;
					KeyHandler.field396 = KeyHandler.field385;
					KeyHandler.field386 = 0;
					int var7;
					if (KeyHandler.field398 >= 0) {
						while (KeyHandler.field388 != KeyHandler.field398) {
							var7 = KeyHandler.field391[KeyHandler.field388];
							KeyHandler.field388 = KeyHandler.field388 + 1 & 127;
							if (var7 < 0) {
								KeyHandler.KeyHandler_pressedKeys[~var7] = false;
							} else {
								if (!KeyHandler.KeyHandler_pressedKeys[var7] && KeyHandler.field386 < KeyHandler.field401.length - 1) {
									KeyHandler.field401[++KeyHandler.field386 - 1] = var7;
								}

								KeyHandler.KeyHandler_pressedKeys[var7] = true;
							}
						}
					} else {
						for (var7 = 0; var7 < 112; ++var7) {
							KeyHandler.KeyHandler_pressedKeys[var7] = false;
						}

						KeyHandler.field398 = KeyHandler.field388;
					}

					if (KeyHandler.field386 > 0) {
						KeyHandler.KeyHandler_idleCycles = 0;
					}

					KeyHandler.field385 = KeyHandler.field404;
				}

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

				if (WorldMapManager.mouseWheel != null) {
					var6 = WorldMapManager.mouseWheel.useRotation();
					mouseWheelRotation = var6;
				}

				if (gameState == 0) {
					Timer.load();
					WallDecoration.method3291();
				} else if (gameState == 5) {
					VarbitDefinition.method4484(this);
					Timer.load();
					WallDecoration.method3291();
				} else if (gameState != 10 && gameState != 11) {
					if (gameState == 20) {
						VarbitDefinition.method4484(this);
						this.doCycleLoggedOut();
					} else if (gameState == 25) {
						PacketBufferNode.method3628();
					}
				} else {
					VarbitDefinition.method4484(this);
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

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "-5"
	)
	@Export("draw")
	protected final void draw(boolean var1) {
		boolean var2;
		label168: {
			try {
				if (class197.field2402 == 2) {
					if (UserComparator10.musicTrack == null) {
						UserComparator10.musicTrack = MusicTrack.readTrack(GrandExchangeOfferNameComparator.musicTrackArchive, class197.musicTrackGroupId, class197.musicTrackFileId);
						if (UserComparator10.musicTrack == null) {
							var2 = false;
							break label168;
						}
					}

					if (WorldMapLabelSize.soundCache == null) {
						WorldMapLabelSize.soundCache = new SoundCache(class197.soundEffectsArchive, class197.musicSamplesArchive);
					}

					if (Interpreter.midiPcmStream.loadMusicTrack(UserComparator10.musicTrack, class197.musicPatchesArchive, WorldMapLabelSize.soundCache, 22050)) {
						Interpreter.midiPcmStream.clearAll();
						Interpreter.midiPcmStream.method3706(ScriptFrame.field529);
						Interpreter.midiPcmStream.setMusicTrack(UserComparator10.musicTrack, BuddyRankComparator.musicTrackBoolean);
						class197.field2402 = 0;
						UserComparator10.musicTrack = null;
						WorldMapLabelSize.soundCache = null;
						GrandExchangeOfferNameComparator.musicTrackArchive = null;
						var2 = true;
						break label168;
					}
				}
			} catch (Exception var6) {
				var6.printStackTrace();
				Interpreter.midiPcmStream.clear();
				class197.field2402 = 0;
				UserComparator10.musicTrack = null;
				WorldMapLabelSize.soundCache = null;
				GrandExchangeOfferNameComparator.musicTrackArchive = null;
			}

			var2 = false;
		}

		if (var2 && field699 && class80.pcmPlayer0 != null) {
			class80.pcmPlayer0.tryDiscard();
		}

		if ((gameState == 10 || gameState == 20 || gameState == 30) && field868 != 0L && DirectByteArrayCopier.currentTimeMs() > field868) {
			Clock.setWindowedMode(AbstractWorldMapIcon.getWindowedMode());
		}

		int var4;
		if (var1) {
			for (var4 = 0; var4 < 100; ++var4) {
				field843[var4] = true;
			}
		}

		if (gameState == 0) {
			this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
		} else if (gameState == 5) {
			class189.drawTitle(WorldMapIcon_1.fontBold12, Coord.fontPlain11, class169.fontPlain12);
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				class189.drawTitle(WorldMapIcon_1.fontBold12, Coord.fontPlain11, class169.fontPlain12);
			} else if (gameState == 25) {
				if (field709 == 1) {
					if (field705 > field706) {
						field706 = field705;
					}

					var4 = (field706 * 50 - field705 * 50) / field706;
					TriBool.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
				} else if (field709 == 2) {
					if (field707 > field896) {
						field896 = field707;
					}

					var4 = (field896 * 50 - field707 * 50) / field896 + 50;
					TriBool.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
				} else {
					TriBool.drawLoadingMessage("Loading - please wait.", false);
				}
			} else if (gameState == 30) {
				this.drawLoggedIn();
			} else if (gameState == 40) {
				TriBool.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
			} else if (gameState == 45) {
				TriBool.drawLoadingMessage("Please wait...", false);
			}
		} else {
			class189.drawTitle(WorldMapIcon_1.fontBold12, Coord.fontPlain11, class169.fontPlain12);
		}

		if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
			for (var4 = 0; var4 < rootWidgetCount; ++var4) {
				if (field861[var4]) {
					MusicPatchPcmStream.rasterProvider.draw(rootWidgetXs[var4], rootWidgetYs[var4], rootWidgetWidths[var4], rootWidgetHeights[var4]);
					field861[var4] = false;
				}
			}
		} else if (gameState > 0) {
			MusicPatchPcmStream.rasterProvider.drawFull(0, 0);

			for (var4 = 0; var4 < rootWidgetCount; ++var4) {
				field861[var4] = false;
			}
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1344457794"
	)
	@Export("kill0")
	protected final void kill0() {
		if (Clock.varcs.hasUnwrittenChanges()) {
			Clock.varcs.write();
		}

		if (class40.mouseRecorder != null) {
			class40.mouseRecorder.isRunning = false;
		}

		class40.mouseRecorder = null;
		packetWriter.close();
		FloorDecoration.method2842();
		Widget.method4091();
		WorldMapManager.mouseWheel = null;
		if (class80.pcmPlayer0 != null) {
			class80.pcmPlayer0.shutdown();
		}

		if (class190.pcmPlayer1 != null) {
			class190.pcmPlayer1.shutdown();
		}

		if (NetCache.NetCache_socket != null) {
			NetCache.NetCache_socket.close();
		}

		Players.method2093();
		if (SequenceDefinition.urlRequester != null) {
			SequenceDefinition.urlRequester.close();
			SequenceDefinition.urlRequester = null;
		}

		try {
			class167.dat2File.close();

			for (int var1 = 0; var1 < class40.idxCount; ++var1) {
				class167.idxFiles[var1].close();
			}

			class167.idx255File.close();
			class167.randomDat.close();
		} catch (Exception var3) {
		}

	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-779141254"
	)
	protected final void vmethod1273() {
	}

	public final void init() {
		try {
			if (this.checkHost()) {
				ClientParameter[] var1 = FaceNormal.ClientParameter_values();

				for (int var2 = 0; var2 < var1.length; ++var2) {
					ClientParameter var3 = var1[var2];
					String var4 = this.getParameter(var3.id);
					if (var4 != null) {
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
							if (var4.equalsIgnoreCase("true")) {
								isMembersWorld = true;
							} else {
								isMembersWorld = false;
							}
							break;
						case 4:
							if (clientType == -1) {
								clientType = Integer.parseInt(var4);
							}
							break;
						case 5:
							worldProperties = Integer.parseInt(var4);
							break;
						case 6:
							int var6 = Integer.parseInt(var4);
							class190 var11;
							if (var6 >= 0 && var6 < class190.field2355.length) {
								var11 = class190.field2355[var6];
							} else {
								var11 = null;
							}

							ScriptFrame.field528 = var11;
							break;
						case 7:
							PacketBufferNode.field2337 = ServerBuild.valueOf(Integer.parseInt(var4));
							break;
						case 8:
							if (var4.equalsIgnoreCase("true")) {
							}
							break;
						case 9:
							class294.field3695 = var4;
							break;
						case 10:
							StudioGame[] var5 = new StudioGame[]{StudioGame.field3110, StudioGame.field3107, StudioGame.field3109, StudioGame.field3106, StudioGame.field3108, StudioGame.field3112};
							WorldMapRegion.field248 = (StudioGame)SoundSystem.findEnumerated(var5, Integer.parseInt(var4));
							if (WorldMapRegion.field248 == StudioGame.field3110) {
								class40.loginType = LoginType.field4052;
							} else {
								class40.loginType = LoginType.field4056;
							}
							break;
						case 12:
							worldId = Integer.parseInt(var4);
							break;
						case 14:
							InvDefinition.field3199 = Integer.parseInt(var4);
							break;
						case 15:
							gameBuild = Integer.parseInt(var4);
							break;
						case 17:
							WorldMapArea.field213 = var4;
						}
					}
				}

				class215.method4022();
				ClientPreferences.worldHost = this.getCodeBase().getHost();
				String var9 = PacketBufferNode.field2337.name;
				byte var10 = 0;

				try {
					UserComparator6.method3440("oldschool", var9, var10, 21);
				} catch (Exception var7) {
					HitSplatDefinition.sendStackTrace((String)null, var7);
				}

				WorldMapSprite.client = this;
				RunException.field4066 = clientType;
				this.startThread(765, 503, 181);
			}
		} catch (RuntimeException var8) {
			throw UserComparator9.method3390(var8, "client.init(" + ')');
		}
	}

	@ObfuscatedName("es")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1600104353"
	)
	@Export("doCycleJs5")
	void doCycleJs5() {
		if (gameState != 1000) {
			boolean var1 = WorldMapArea.method365();
			if (!var1) {
				this.doCycleJs5Connect();
			}

		}
	}

	@ObfuscatedName("ez")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1712345498"
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

				field682 = 3000;
				NetCache.NetCache_ioExceptions = 3;
			}

			if (--field682 + 1 <= 0) {
				try {
					if (js5ConnectState == 0) {
						class191.js5SocketTask = GameShell.taskHandler.newSocketTask(ClientPreferences.worldHost, Varcs.port3);
						++js5ConnectState;
					}

					if (js5ConnectState == 1) {
						if (class191.js5SocketTask.status == 2) {
							this.js5Error(-1);
							return;
						}

						if (class191.js5SocketTask.status == 1) {
							++js5ConnectState;
						}
					}

					if (js5ConnectState == 2) {
						if (useBufferedSocket) {
							HealthBarUpdate.js5Socket = BZip2State.newBufferedNetSocket((Socket)class191.js5SocketTask.result, 40000, 5000);
						} else {
							HealthBarUpdate.js5Socket = new NetSocket((Socket)class191.js5SocketTask.result, GameShell.taskHandler, 5000);
						}

						Buffer var1 = new Buffer(5);
						var1.writeByte(15);
						var1.writeInt(181);
						HealthBarUpdate.js5Socket.write(var1.array, 0, 5);
						++js5ConnectState;
						class192.field2382 = DirectByteArrayCopier.currentTimeMs();
					}

					if (js5ConnectState == 3) {
						if (HealthBarUpdate.js5Socket.available() > 0 || !useBufferedSocket && gameState <= 5) {
							int var2 = HealthBarUpdate.js5Socket.readUnsignedByte();
							if (var2 != 0) {
								this.js5Error(var2);
								return;
							}

							++js5ConnectState;
						} else if (DirectByteArrayCopier.currentTimeMs() - class192.field2382 > 30000L) {
							this.js5Error(-2);
							return;
						}
					}

					if (js5ConnectState == 4) {
						DynamicObject.method2193(HealthBarUpdate.js5Socket, gameState > 20);
						class191.js5SocketTask = null;
						HealthBarUpdate.js5Socket = null;
						js5ConnectState = 0;
						js5Errors = 0;
					}
				} catch (IOException var3) {
					this.js5Error(-3);
				}

			}
		}
	}

	@ObfuscatedName("ex")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "3"
	)
	@Export("js5Error")
	void js5Error(int var1) {
		class191.js5SocketTask = null;
		HealthBarUpdate.js5Socket = null;
		js5ConnectState = 0;
		if (class190.port1 == Varcs.port3) {
			Varcs.port3 = Skeleton.port2;
		} else {
			Varcs.port3 = class190.port1;
		}

		++js5Errors;
		if (js5Errors >= 2 && (var1 == 7 || var1 == 9)) {
			if (gameState <= 5) {
				this.error("js5connect_full");
				gameState = 1000;
			} else {
				field682 = 3000;
			}
		} else if (js5Errors >= 2 && var1 == 6) {
			this.error("js5connect_outofdate");
			gameState = 1000;
		} else if (js5Errors >= 4) {
			if (gameState <= 5) {
				this.error("js5connect");
				gameState = 1000;
			} else {
				field682 = 3000;
			}
		}

	}

	@ObfuscatedName("ea")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1078015369"
	)
	@Export("doCycleLoggedOut")
	final void doCycleLoggedOut() {
		Object var1 = packetWriter.getSocket();
		PacketBuffer var2 = packetWriter.packetBuffer;

		try {
			if (loginState == 0) {
				if (WorldMapIcon_1.secureRandom == null && (secureRandomFuture.isDone() || field687 > 250)) {
					WorldMapIcon_1.secureRandom = secureRandomFuture.get();
					secureRandomFuture.shutdown();
					secureRandomFuture = null;
				}

				if (WorldMapIcon_1.secureRandom != null) {
					if (var1 != null) {
						((AbstractSocket)var1).close();
						var1 = null;
					}

					Ignored.socketTask = null;
					field701 = false;
					field687 = 0;
					loginState = 1;
				}
			}

			if (loginState == 1) {
				if (Ignored.socketTask == null) {
					Ignored.socketTask = GameShell.taskHandler.newSocketTask(ClientPreferences.worldHost, Varcs.port3);
				}

				if (Ignored.socketTask.status == 2) {
					throw new IOException();
				}

				if (Ignored.socketTask.status == 1) {
					if (useBufferedSocket) {
						var1 = BZip2State.newBufferedNetSocket((Socket)Ignored.socketTask.result, 40000, 5000);
					} else {
						var1 = new NetSocket((Socket)Ignored.socketTask.result, GameShell.taskHandler, 5000);
					}

					packetWriter.setSocket((AbstractSocket)var1);
					Ignored.socketTask = null;
					loginState = 2;
				}
			}

			if (loginState == 2) {
				packetWriter.method2218();
				PacketBufferNode var4;
				if (PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0) {
					var4 = new PacketBufferNode();
				} else {
					var4 = PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
				}

				var4.clientPacket = null;
				var4.clientPacketLength = 0;
				var4.packetBuffer = new PacketBuffer(5000);
				var4.packetBuffer.writeByte(LoginPacket.field2306.id);
				packetWriter.method2219(var4);
				packetWriter.method2234();
				var2.offset = 0;
				loginState = 3;
			}

			boolean var14;
			int var15;
			if (loginState == 3) {
				if (class80.pcmPlayer0 != null) {
					class80.pcmPlayer0.method2407();
				}

				if (class190.pcmPlayer1 != null) {
					class190.pcmPlayer1.method2407();
				}

				var14 = true;
				if (useBufferedSocket && !((AbstractSocket)var1).isAvailable(1)) {
					var14 = false;
				}

				if (var14) {
					var15 = ((AbstractSocket)var1).readUnsignedByte();
					if (class80.pcmPlayer0 != null) {
						class80.pcmPlayer0.method2407();
					}

					if (class190.pcmPlayer1 != null) {
						class190.pcmPlayer1.method2407();
					}

					if (var15 != 0) {
						WorldMapIcon_1.method296(var15);
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
					Entity.field1872 = var2.readLong();
					loginState = 5;
				}
			}

			if (loginState == 5) {
				packetWriter.packetBuffer.offset = 0;
				packetWriter.method2218();
				PacketBuffer var3 = new PacketBuffer(500);
				int[] var24 = new int[]{WorldMapIcon_1.secureRandom.nextInt(), WorldMapIcon_1.secureRandom.nextInt(), WorldMapIcon_1.secureRandom.nextInt(), WorldMapIcon_1.secureRandom.nextInt()};
				var3.offset = 0;
				var3.writeByte(1);
				var3.writeInt(var24[0]);
				var3.writeInt(var24[1]);
				var3.writeInt(var24[2]);
				var3.writeInt(var24[3]);
				var3.writeLong(Entity.field1872);
				if (gameState == 40) {
					var3.writeInt(FriendSystem.field1074[0]);
					var3.writeInt(FriendSystem.field1074[1]);
					var3.writeInt(FriendSystem.field1074[2]);
					var3.writeInt(FriendSystem.field1074[3]);
				} else {
					var3.writeByte(field690.rsOrdinal());
					switch(field690.field2003) {
					case 0:
						var3.writeInt((Integer)WorldMapLabelSize.clientPreferences.parameters.get(ViewportMouse.method2971(Login.Login_username)));
						break;
					case 1:
					case 2:
						var3.writeMedium(GrandExchangeOffer.field65);
						++var3.offset;
						break;
					case 3:
						var3.offset += 4;
					}

					var3.writeByte(class313.field3837.rsOrdinal());
					var3.writeStringCp1252NullTerminated(Login.Login_password);
				}

				var3.encryptRsa(class83.field1165, class83.field1162);
				FriendSystem.field1074 = var24;
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
					var6.packetBuffer.writeByte(LoginPacket.field2311.id);
				} else {
					var6.packetBuffer.writeByte(LoginPacket.field2308.id);
				}

				var6.packetBuffer.writeShort(0);
				int var16 = var6.packetBuffer.offset;
				var6.packetBuffer.writeInt(181);
				var6.packetBuffer.writeInt(1);
				var6.packetBuffer.writeByte(clientType);
				var6.packetBuffer.writeBytes(var3.array, 0, var3.offset);
				int var8 = var6.packetBuffer.offset;
				var6.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
				var6.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
				var6.packetBuffer.writeShort(GrandExchangeEvent.canvasWidth);
				var6.packetBuffer.writeShort(ParamDefinition.canvasHeight);
				PacketBuffer var9 = var6.packetBuffer;
				int var12;
				if (field693 != null) {
					var9.writeBytes(field693, 0, field693.length);
				} else {
					byte[] var11 = new byte[24];

					try {
						class167.randomDat.seek(0L);
						class167.randomDat.readFully(var11);

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

				var6.packetBuffer.writeStringCp1252NullTerminated(class294.field3695);
				var6.packetBuffer.writeInt(InvDefinition.field3199);
				Buffer var10 = new Buffer(WorldMapRectangle.platformInfo.size());
				WorldMapRectangle.platformInfo.write(var10);
				var6.packetBuffer.writeBytes(var10.array, 0, var10.array.length);
				var6.packetBuffer.writeByte(clientType);
				var6.packetBuffer.writeInt(0);
				var6.packetBuffer.writeInt(class197.archive0.hash);
				var6.packetBuffer.writeInt(class167.archive1.hash);
				var6.packetBuffer.writeInt(class215.archive2.hash);
				var6.packetBuffer.writeInt(class43.archive3.hash);
				var6.packetBuffer.writeInt(class13.archive4.hash);
				var6.packetBuffer.writeInt(WorldMapCacheName.archive5.hash);
				var6.packetBuffer.writeInt(WorldMapRegion.archive6.hash);
				var6.packetBuffer.writeInt(NPCDefinition.archive7.hash);
				var6.packetBuffer.writeInt(archive8.hash);
				var6.packetBuffer.writeInt(class4.archive9.hash);
				var6.packetBuffer.writeInt(WorldMapLabelSize.archive10.hash);
				var6.packetBuffer.writeInt(class32.archive11.hash);
				var6.packetBuffer.writeInt(UserComparator4.archive12.hash);
				var6.packetBuffer.writeInt(class2.archive13.hash);
				var6.packetBuffer.writeInt(Tile.archive14.hash);
				var6.packetBuffer.writeInt(GrandExchangeOfferOwnWorldComparator.archive15.hash);
				var6.packetBuffer.writeInt(0);
				var6.packetBuffer.writeInt(WorldMapSprite.archive17.hash);
				var6.packetBuffer.writeInt(archive18.hash);
				var6.packetBuffer.writeInt(ItemDefinition.archive19.hash);
				var6.packetBuffer.writeInt(Entity.archive20.hash);
				var6.packetBuffer.xteaEncrypt(var24, var8, var6.packetBuffer.offset);
				var6.packetBuffer.writeLengthShort(var6.packetBuffer.offset - var16);
				packetWriter.method2219(var6);
				packetWriter.method2234();
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
				} else if (var30 == 23 && field688 < 1) {
					++field688;
					loginState = 0;
				} else {
					if (var30 != 29) {
						WorldMapIcon_1.method296(var30);
						return;
					}

					loginState = 14;
				}
			}

			if (loginState == 7 && ((AbstractSocket)var1).available() > 0) {
				class323.field3884 = ((AbstractSocket)var1).readUnsignedByte();
				loginState = 8;
			}

			if (loginState == 8 && ((AbstractSocket)var1).available() >= class323.field3884) {
				((AbstractSocket)var1).read(var2.array, 0, class323.field3884);
				var2.offset = 0;
				loginState = 6;
			}

			if (loginState == 9 && ((AbstractSocket)var1).available() > 0) {
				field836 = (((AbstractSocket)var1).readUnsignedByte() + 3) * 60;
				loginState = 10;
			}

			if (loginState == 10) {
				field687 = 0;
				class268.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field836 / 60 + " seconds.");
				if (--field836 <= 0) {
					loginState = 0;
				}

			} else {
				if (loginState == 11 && ((AbstractSocket)var1).available() >= 1) {
					EnumDefinition.field3324 = ((AbstractSocket)var1).readUnsignedByte();
					loginState = 12;
				}

				if (loginState == 12 && ((AbstractSocket)var1).available() >= EnumDefinition.field3324) {
					var14 = ((AbstractSocket)var1).readUnsignedByte() == 1;
					((AbstractSocket)var1).read(var2.array, 0, 4);
					var2.offset = 0;
					boolean var31 = false;
					if (var14) {
						var15 = var2.readByteIsaac() << 24;
						var15 |= var2.readByteIsaac() << 16;
						var15 |= var2.readByteIsaac() << 8;
						var15 |= var2.readByteIsaac();
						int var18 = ViewportMouse.method2971(Login.Login_username);
						if (WorldMapLabelSize.clientPreferences.parameters.size() >= 10 && !WorldMapLabelSize.clientPreferences.parameters.containsKey(var18)) {
							Iterator var28 = WorldMapLabelSize.clientPreferences.parameters.entrySet().iterator();
							var28.next();
							var28.remove();
						}

						WorldMapLabelSize.clientPreferences.parameters.put(var18, var15);
					}

					if (Login_isUsernameRemembered) {
						WorldMapLabelSize.clientPreferences.rememberedUsername = Login.Login_username;
					} else {
						WorldMapLabelSize.clientPreferences.rememberedUsername = null;
					}

					ReflectionCheck.savePreferences();
					staffModLevel = ((AbstractSocket)var1).readUnsignedByte();
					playerMod = ((AbstractSocket)var1).readUnsignedByte() == 1;
					localPlayerIndex = ((AbstractSocket)var1).readUnsignedByte();
					localPlayerIndex <<= 8;
					localPlayerIndex += ((AbstractSocket)var1).readUnsignedByte();
					field771 = ((AbstractSocket)var1).readUnsignedByte();
					((AbstractSocket)var1).read(var2.array, 0, 1);
					var2.offset = 0;
					ServerPacket[] var5 = Interpreter.ServerPacket_values();
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
						Client var7 = WorldMapSprite.client;
						JSObject.getWindow(var7).call("zap", (Object[])null);
					} catch (Throwable var20) {
					}

					loginState = 13;
				}

				if (loginState == 13) {
					if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
						timer.method5014();
						FaceNormal.method3264();
						WorldMapSectionType.updatePlayer(var2);
						Canvas.field418 = -1;
						Tiles.loadRegions(false, var2);
						packetWriter.serverPacket = null;
					}

				} else {
					if (loginState == 14 && ((AbstractSocket)var1).available() >= 2) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, 2);
						var2.offset = 0;
						AbstractWorldMapData.field155 = var2.readUnsignedShort();
						loginState = 15;
					}

					if (loginState == 15 && ((AbstractSocket)var1).available() >= AbstractWorldMapData.field155) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, AbstractWorldMapData.field155);
						var2.offset = 0;
						String var23 = var2.readStringCp1252NullTerminated();
						String var25 = var2.readStringCp1252NullTerminated();
						String var26 = var2.readStringCp1252NullTerminated();
						class268.setLoginResponseString(var23, var25, var26);
						class96.updateGameState(10);
					}

					if (loginState != 16) {
						++field687;
						if (field687 > 2000) {
							if (field688 < 1) {
								if (class190.port1 == Varcs.port3) {
									Varcs.port3 = Skeleton.port2;
								} else {
									Varcs.port3 = class190.port1;
								}

								++field688;
								loginState = 0;
							} else {
								WorldMapIcon_1.method296(-3);
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
							timer.method5000();
							packetWriter.method2218();
							packetWriter.packetBuffer.offset = 0;
							packetWriter.serverPacket = null;
							packetWriter.field1309 = null;
							packetWriter.field1321 = null;
							packetWriter.field1317 = null;
							packetWriter.serverPacketLength = 0;
							packetWriter.field1318 = 0;
							rebootTimer = 0;
							Strings.method4121();
							minimapState = 0;
							destinationX = 0;

							for (var15 = 0; var15 < 2048; ++var15) {
								players[var15] = null;
							}

							localPlayer = null;

							for (var15 = 0; var15 < npcs.length; ++var15) {
								NPC var27 = npcs[var15];
								if (var27 != null) {
									var27.targetIndex = -1;
									var27.false0 = false;
								}
							}

							ItemContainer.itemContainers = new NodeHashTable(32);
							class96.updateGameState(30);

							for (var15 = 0; var15 < 100; ++var15) {
								field843[var15] = true;
							}

							HealthBarUpdate.method1677();
							WorldMapSectionType.updatePlayer(var2);
							if (var30 != var2.offset) {
								throw new RuntimeException();
							}
						}
					}
				}
			}
		} catch (IOException var22) {
			if (field688 < 1) {
				if (Varcs.port3 == class190.port1) {
					Varcs.port3 = Skeleton.port2;
				} else {
					Varcs.port3 = class190.port1;
				}

				++field688;
				loginState = 0;
			} else {
				WorldMapIcon_1.method296(-2);
			}
		}
	}

	@ObfuscatedName("fg")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1319159959"
	)
	@Export("doCycleLoggedIn")
	final void doCycleLoggedIn() {
		if (rebootTimer > 1) {
			--rebootTimer;
		}

		if (field700 > 0) {
			--field700;
		}

		if (field701) {
			field701 = false;
			ScriptFrame.method1090();
		} else {
			if (!isMenuOpen) {
				GraphicsObject.resetMenuEntries();
			}

			int var1;
			for (var1 = 0; var1 < 100 && this.method1451(packetWriter); ++var1) {
			}

			if (gameState == 30) {
				int var2;
				PacketBufferNode var15;
				while (MidiPcmStream.method3811()) {
					var15 = Archive.method4265(ClientPacket.field2252, packetWriter.isaacCipher);
					var15.packetBuffer.writeByte(0);
					var2 = var15.packetBuffer.offset;
					HealthBarUpdate.method1671(var15.packetBuffer);
					var15.packetBuffer.writeLengthByte(var15.packetBuffer.offset - var2);
					packetWriter.method2219(var15);
				}

				if (timer.field3605) {
					var15 = Archive.method4265(ClientPacket.field2217, packetWriter.isaacCipher);
					var15.packetBuffer.writeByte(0);
					var2 = var15.packetBuffer.offset;
					timer.write(var15.packetBuffer);
					var15.packetBuffer.writeLengthByte(var15.packetBuffer.offset - var2);
					packetWriter.method2219(var15);
					timer.method4998();
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
				synchronized(class40.mouseRecorder.lock) {
					if (!field912) {
						class40.mouseRecorder.index = 0;
					} else if (MouseHandler.MouseHandler_lastButton != 0 || class40.mouseRecorder.index >= 40) {
						PacketBufferNode var16 = null;
						var3 = 0;
						var4 = 0;
						var5 = 0;
						var6 = 0;

						for (var7 = 0; var7 < class40.mouseRecorder.index && (var16 == null || var16.packetBuffer.offset - var3 < 246); ++var7) {
							var4 = var7;
							var8 = class40.mouseRecorder.ys[var7];
							if (var8 < -1) {
								var8 = -1;
							} else if (var8 > 65534) {
								var8 = 65534;
							}

							var9 = class40.mouseRecorder.xs[var7];
							if (var9 < -1) {
								var9 = -1;
							} else if (var9 > 65534) {
								var9 = 65534;
							}

							if (var9 != field717 || var8 != field665) {
								if (var16 == null) {
									var16 = Archive.method4265(ClientPacket.field2237, packetWriter.isaacCipher);
									var16.packetBuffer.writeByte(0);
									var3 = var16.packetBuffer.offset;
									PacketBuffer var10000 = var16.packetBuffer;
									var10000.offset += 2;
									var5 = 0;
									var6 = 0;
								}

								if (-1L != field666) {
									var10 = var9 - field717;
									var11 = var8 - field665;
									var12 = (int)((class40.mouseRecorder.millis[var7] - field666) / 20L);
									var5 = (int)((long)var5 + (class40.mouseRecorder.millis[var7] - field666) % 20L);
								} else {
									var10 = var9;
									var11 = var8;
									var12 = Integer.MAX_VALUE;
								}

								field717 = var9;
								field665 = var8;
								if (var12 < 8 && var10 >= -32 && var10 <= 31 && var11 >= -32 && var11 <= 31) {
									var10 += 32;
									var11 += 32;
									var16.packetBuffer.writeShort((var12 << 12) + var11 + (var10 << 6));
								} else if (var12 < 32 && var10 >= -128 && var10 <= 127 && var11 >= -128 && var11 <= 127) {
									var10 += 128;
									var11 += 128;
									var16.packetBuffer.writeByte(var12 + 128);
									var16.packetBuffer.writeShort(var11 + (var10 << 8));
								} else if (var12 < 32) {
									var16.packetBuffer.writeByte(var12 + 192);
									if (var9 != -1 && var8 != -1) {
										var16.packetBuffer.writeInt(var9 | var8 << 16);
									} else {
										var16.packetBuffer.writeInt(Integer.MIN_VALUE);
									}
								} else {
									var16.packetBuffer.writeShort((var12 & 8191) + 57344);
									if (var9 != -1 && var8 != -1) {
										var16.packetBuffer.writeInt(var9 | var8 << 16);
									} else {
										var16.packetBuffer.writeInt(Integer.MIN_VALUE);
									}
								}

								++var6;
								field666 = class40.mouseRecorder.millis[var7];
							}
						}

						if (var16 != null) {
							var16.packetBuffer.writeLengthByte(var16.packetBuffer.offset - var3);
							var7 = var16.packetBuffer.offset;
							var16.packetBuffer.offset = var3;
							var16.packetBuffer.writeByte(var5 / var6);
							var16.packetBuffer.writeByte(var5 % var6);
							var16.packetBuffer.offset = var7;
							packetWriter.method2219(var16);
						}

						if (var4 >= class40.mouseRecorder.index) {
							class40.mouseRecorder.index = 0;
						} else {
							MouseRecorder var43 = class40.mouseRecorder;
							var43.index -= var4;
							System.arraycopy(class40.mouseRecorder.xs, var4, class40.mouseRecorder.xs, 0, class40.mouseRecorder.index);
							System.arraycopy(class40.mouseRecorder.ys, var4, class40.mouseRecorder.ys, 0, class40.mouseRecorder.index);
							System.arraycopy(class40.mouseRecorder.millis, var4, class40.mouseRecorder.millis, 0, class40.mouseRecorder.index);
						}
					}
				}

				PacketBufferNode var19;
				if (MouseHandler.MouseHandler_lastButton == 1 || !DevicePcmPlayerProvider.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
					long var17 = (MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis * -1L) / 50L;
					if (var17 > 4095L) {
						var17 = 4095L;
					}

					mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis * -1L;
					var3 = MouseHandler.MouseHandler_lastPressedY;
					if (var3 < 0) {
						var3 = 0;
					} else if (var3 > ParamDefinition.canvasHeight) {
						var3 = ParamDefinition.canvasHeight;
					}

					var4 = MouseHandler.MouseHandler_lastPressedX;
					if (var4 < 0) {
						var4 = 0;
					} else if (var4 > GrandExchangeEvent.canvasWidth) {
						var4 = GrandExchangeEvent.canvasWidth;
					}

					var5 = (int)var17;
					var19 = Archive.method4265(ClientPacket.field2234, packetWriter.isaacCipher);
					var19.packetBuffer.writeShort((MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0) + (var5 << 1));
					var19.packetBuffer.writeShort(var4);
					var19.packetBuffer.writeShort(var3);
					packetWriter.method2219(var19);
				}

				if (KeyHandler.field386 > 0) {
					var15 = Archive.method4265(ClientPacket.field2270, packetWriter.isaacCipher);
					var15.packetBuffer.writeShort(0);
					var2 = var15.packetBuffer.offset;
					long var20 = DirectByteArrayCopier.currentTimeMs();

					for (var5 = 0; var5 < KeyHandler.field386; ++var5) {
						long var22 = var20 - field879;
						if (var22 > 16777215L) {
							var22 = 16777215L;
						}

						field879 = var20;
						var15.packetBuffer.method5521(KeyHandler.field401[var5]);
						var15.packetBuffer.writeMedium((int)var22);
					}

					var15.packetBuffer.writeLengthShort(var15.packetBuffer.offset - var2);
					packetWriter.method2219(var15);
				}

				if (field822 > 0) {
					--field822;
				}

				if (KeyHandler.KeyHandler_pressedKeys[96] || KeyHandler.KeyHandler_pressedKeys[97] || KeyHandler.KeyHandler_pressedKeys[98] || KeyHandler.KeyHandler_pressedKeys[99]) {
					field878 = true;
				}

				if (field878 && field822 <= 0) {
					field822 = 20;
					field878 = false;
					var15 = Archive.method4265(ClientPacket.field2242, packetWriter.isaacCipher);
					var15.packetBuffer.method5475(camAngleX);
					var15.packetBuffer.writeShortLE(camAngleY);
					packetWriter.method2219(var15);
				}

				if (class267.field3557 && !field667) {
					field667 = true;
					var15 = Archive.method4265(ClientPacket.field2276, packetWriter.isaacCipher);
					var15.packetBuffer.writeByte(1);
					packetWriter.method2219(var15);
				}

				if (!class267.field3557 && field667) {
					field667 = false;
					var15 = Archive.method4265(ClientPacket.field2276, packetWriter.isaacCipher);
					var15.packetBuffer.writeByte(0);
					packetWriter.method2219(var15);
				}

				if (BoundaryObject.worldMap != null) {
					BoundaryObject.worldMap.method6299();
				}

				KeyHandler.method801();
				int[] var37;
				if (field747 != class42.plane) {
					field747 = class42.plane;
					var1 = class42.plane;
					var37 = RouteStrategy.sceneMinimapSprite.pixels;
					var3 = var37.length;

					for (var4 = 0; var4 < var3; ++var4) {
						var37[var4] = 0;
					}

					for (var4 = 1; var4 < 103; ++var4) {
						var5 = (103 - var4) * 2048 + 24628;

						for (var6 = 1; var6 < 103; ++var6) {
							if ((Tiles.Tiles_renderFlags[var1][var6][var4] & 24) == 0) {
								GrandExchangeOfferWorldComparator.scene.drawTileMinimap(var37, var5, 512, var1, var6, var4);
							}

							if (var1 < 3 && (Tiles.Tiles_renderFlags[var1 + 1][var6][var4] & 8) != 0) {
								GrandExchangeOfferWorldComparator.scene.drawTileMinimap(var37, var5, 512, var1 + 1, var6, var4);
							}

							var5 += 4;
						}
					}

					var4 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
					var5 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
					RouteStrategy.sceneMinimapSprite.setRaster();

					for (var6 = 1; var6 < 103; ++var6) {
						for (var7 = 1; var7 < 103; ++var7) {
							if ((Tiles.Tiles_renderFlags[var1][var7][var6] & 24) == 0) {
								class3.drawObject(var1, var7, var6, var4, var5);
							}

							if (var1 < 3 && (Tiles.Tiles_renderFlags[var1 + 1][var7][var6] & 8) != 0) {
								class3.drawObject(var1 + 1, var7, var6, var4, var5);
							}
						}
					}

					mapIconCount = 0;

					for (var6 = 0; var6 < 104; ++var6) {
						for (var7 = 0; var7 < 104; ++var7) {
							long var24 = GrandExchangeOfferWorldComparator.scene.getFloorDecorationTag(class42.plane, var6, var7);
							if (0L != var24) {
								var10 = class43.method770(var24);
								var11 = ViewportMouse.getObjectDefinition(var10).mapIconId;
								if (var11 >= 0) {
									mapIcons[mapIconCount] = class222.getWorldMapElement(var11).getSpriteBool(false);
									mapIconXs[mapIconCount] = var6;
									mapIconYs[mapIconCount] = var7;
									++mapIconCount;
								}
							}
						}
					}

					MusicPatchPcmStream.rasterProvider.apply();
				}

				if (gameState == 30) {
					for (PendingSpawn var35 = (PendingSpawn)pendingSpawns.last(); var35 != null; var35 = (PendingSpawn)pendingSpawns.previous()) {
						if (var35.hitpoints > 0) {
							--var35.hitpoints;
						}

						if (var35.hitpoints == 0) {
							if (var35.field935 < 0 || Players.method2091(var35.field935, var35.field933)) {
								DirectByteArrayCopier.addPendingSpawnToScene(var35.plane, var35.type, var35.x, var35.y, var35.field935, var35.field936, var35.field933);
								var35.remove();
							}
						} else {
							if (var35.delay > 0) {
								--var35.delay;
							}

							if (var35.delay == 0 && var35.x >= 1 && var35.y >= 1 && var35.x <= 102 && var35.y <= 102 && (var35.id < 0 || Players.method2091(var35.id, var35.field940))) {
								DirectByteArrayCopier.addPendingSpawnToScene(var35.plane, var35.type, var35.x, var35.y, var35.id, var35.orientation, var35.field940);
								var35.delay = -1;
								if (var35.id == var35.field935 && var35.field935 == -1) {
									var35.remove();
								} else if (var35.field935 == var35.id && var35.field936 == var35.orientation && var35.field933 == var35.field940) {
									var35.remove();
								}
							}
						}
					}

					KitDefinition.method4461();
					++packetWriter.field1318;
					if (packetWriter.field1318 > 750) {
						ScriptFrame.method1090();
					} else {
						var1 = Players.Players_count;
						var37 = Players.Players_indices;

						for (var3 = 0; var3 < var1; ++var3) {
							Player var26 = players[var37[var3]];
							if (var26 != null) {
								StructDefinition.calculateActorPosition(var26, 1);
							}
						}

						MouseRecorder.method1141();
						Player.processOverheadText();
						++field718;
						if (mouseCrossColor != 0) {
							mouseCrossState = mouseCrossState * 400 + 400;
							if (mouseCrossState * 20 >= 400) {
								mouseCrossColor = 0;
							}
						}

						if (ItemContainer.field549 != null) {
							++field759;
							if (field759 >= 15) {
								Strings.method4120(ItemContainer.field549);
								ItemContainer.field549 = null;
							}
						}

						Widget var36 = LoginScreenAnimation.mousedOverWidgetIf1;
						Widget var38 = class32.field284;
						LoginScreenAnimation.mousedOverWidgetIf1 = null;
						class32.field284 = null;
						draggedOnWidget = null;
						field745 = false;
						field873 = false;
						field754 = 0;

						while (class218.method4109() && field754 < 128) {
							if (staffModLevel >= 2 && KeyHandler.KeyHandler_pressedKeys[82] && ReflectionCheck.field1338 == 66) {
								String var27 = UrlRequester.getChatMessagesAsString();
								WorldMapSprite.client.clipboardSetString(var27);
							} else if (oculusOrbState != 1 || Calendar.field2508 <= 0) {
								field921[field754] = ReflectionCheck.field1338;
								field877[field754] = Calendar.field2508;
								++field754;
							}
						}

						boolean var33 = staffModLevel >= 2;
						if (var33 && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81] && mouseWheelRotation != 0) {
							var4 = localPlayer.plane - mouseWheelRotation;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > 3) {
								var4 = 3;
							}

							if (var4 != localPlayer.plane) {
								WorldMapLabel.method418(localPlayer.pathX[0] + MusicPatchNode2.baseX * 64, localPlayer.pathY[0] + class1.baseY * 64, var4, false);
							}

							mouseWheelRotation = 0;
						}

						if (rootInterface != -1) {
							Skills.updateRootInterface(rootInterface, 0, 0, GrandExchangeEvent.canvasWidth, ParamDefinition.canvasHeight, 0, 0);
						}

						++cycleCntr;

						while (true) {
							Widget var28;
							Widget var39;
							ScriptEvent var41;
							do {
								var41 = (ScriptEvent)field852.removeLast();
								if (var41 == null) {
									while (true) {
										do {
											var41 = (ScriptEvent)field856.removeLast();
											if (var41 == null) {
												while (true) {
													do {
														var41 = (ScriptEvent)scriptEvents.removeLast();
														if (var41 == null) {
															this.method1333();
															SpotAnimationDefinition.method4415();
															if (clickedWidget != null) {
																this.method1641();
															}

															if (WorldMapIcon_0.dragInventoryWidget != null) {
																Strings.method4120(WorldMapIcon_0.dragInventoryWidget);
																++itemDragDuration;
																if (MouseHandler.MouseHandler_currentButton == 0) {
																	if (field874) {
																		if (class294.field3697 == WorldMapIcon_0.dragInventoryWidget && dragItemSlotDestination != dragItemSlotSource) {
																			Widget var42 = WorldMapIcon_0.dragInventoryWidget;
																			byte var34 = 0;
																			if (field809 == 1 && var42.contentType == 206) {
																				var34 = 1;
																			}

																			if (var42.itemIds[dragItemSlotDestination] <= 0) {
																				var34 = 0;
																			}

																			if (UserComparator4.method3382(class268.getWidgetClickMask(var42))) {
																				var6 = dragItemSlotSource;
																				var7 = dragItemSlotDestination;
																				var42.itemIds[var7] = var42.itemIds[var6];
																				var42.itemQuantities[var7] = var42.itemQuantities[var6];
																				var42.itemIds[var6] = -1;
																				var42.itemQuantities[var6] = 0;
																			} else if (var34 == 1) {
																				var6 = dragItemSlotSource;
																				var7 = dragItemSlotDestination;

																				while (var6 != var7) {
																					if (var6 > var7) {
																						var42.swapItems(var6 - 1, var6);
																						--var6;
																					} else if (var6 < var7) {
																						var42.swapItems(var6 + 1, var6);
																						++var6;
																					}
																				}
																			} else {
																				var42.swapItems(dragItemSlotDestination, dragItemSlotSource);
																			}

																			var19 = Archive.method4265(ClientPacket.field2283, packetWriter.isaacCipher);
																			var19.packetBuffer.writeShort(dragItemSlotDestination);
																			var19.packetBuffer.writeShortLE(dragItemSlotSource);
																			var19.packetBuffer.writeInt(WorldMapIcon_0.dragInventoryWidget.id);
																			var19.packetBuffer.method5521(var34);
																			packetWriter.method2219(var19);
																		}
																	} else if (this.shouldLeftClickOpenMenu()) {
																		this.openMenu(field654, field763);
																	} else if (menuOptionsCount > 0) {
																		var4 = field654;
																		var5 = field763;
																		MenuAction var40 = tempMenuAction;
																		Messages.menuAction(var40.argument1, var40.argument2, var40.opcode, var40.argument0, var40.action, var40.action, var4, var5);
																		tempMenuAction = null;
																	}

																	field759 = 10;
																	MouseHandler.MouseHandler_lastButton = 0;
																	WorldMapIcon_0.dragInventoryWidget = null;
																} else if (itemDragDuration >= 5 && (MouseHandler.MouseHandler_x > field654 + 5 || MouseHandler.MouseHandler_x < field654 - 5 || MouseHandler.MouseHandler_y > field763 + 5 || MouseHandler.MouseHandler_y < field763 - 5)) {
																	field874 = true;
																}
															}

															if (Scene.method3105()) {
																var4 = Scene.Scene_selectedX;
																var5 = Scene.Scene_selectedY;
																var19 = Archive.method4265(ClientPacket.field2299, packetWriter.isaacCipher);
																var19.packetBuffer.writeByte(5);
																var19.packetBuffer.method5530(class1.baseY * 64 + var5);
																var19.packetBuffer.method5530(MusicPatchNode2.baseX * 64 + var4);
																var19.packetBuffer.method5520(KeyHandler.KeyHandler_pressedKeys[82] ? (KeyHandler.KeyHandler_pressedKeys[81] ? 2 : 1) : 0);
																packetWriter.method2219(var19);
																Scene.method3222();
																mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
																mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
																mouseCrossColor = 1;
																mouseCrossState = 0;
																destinationX = var4;
																destinationY = var5;
															}

															if (var36 != LoginScreenAnimation.mousedOverWidgetIf1) {
																if (var36 != null) {
																	Strings.method4120(var36);
																}

																if (LoginScreenAnimation.mousedOverWidgetIf1 != null) {
																	Strings.method4120(LoginScreenAnimation.mousedOverWidgetIf1);
																}
															}

															if (var38 != class32.field284 && field840 == field833) {
																if (var38 != null) {
																	Strings.method4120(var38);
																}

																if (class32.field284 != null) {
																	Strings.method4120(class32.field284);
																}
															}

															if (class32.field284 != null) {
																if (field840 < field833) {
																	++field840;
																	if (field840 == field833) {
																		Strings.method4120(class32.field284);
																	}
																}
															} else if (field840 > 0) {
																--field840;
															}

															class80.method1982();
															if (isCameraLocked) {
																var4 = DevicePcmPlayerProvider.field412 * 16384 + 64;
																var5 = class210.field2516 * 16384 + 64;
																var6 = ScriptEvent.getTileHeight(var4, var5, class42.plane) - class190.field2345;
																if (PacketBuffer.cameraX < var4) {
																	PacketBuffer.cameraX = (var4 - PacketBuffer.cameraX) * class96.field1327 / 1000 + PacketBuffer.cameraX + class83.field1166;
																	if (PacketBuffer.cameraX > var4) {
																		PacketBuffer.cameraX = var4;
																	}
																}

																if (PacketBuffer.cameraX > var4) {
																	PacketBuffer.cameraX -= class96.field1327 * (PacketBuffer.cameraX - var4) / 1000 + class83.field1166;
																	if (PacketBuffer.cameraX < var4) {
																		PacketBuffer.cameraX = var4;
																	}
																}

																if (class43.cameraY < var6) {
																	class43.cameraY = (var6 - class43.cameraY) * class96.field1327 / 1000 + class43.cameraY + class83.field1166;
																	if (class43.cameraY > var6) {
																		class43.cameraY = var6;
																	}
																}

																if (class43.cameraY > var6) {
																	class43.cameraY -= class96.field1327 * (class43.cameraY - var6) / 1000 + class83.field1166;
																	if (class43.cameraY < var6) {
																		class43.cameraY = var6;
																	}
																}

																if (class1.cameraZ < var5) {
																	class1.cameraZ = (var5 - class1.cameraZ) * class96.field1327 / 1000 + class1.cameraZ + class83.field1166;
																	if (class1.cameraZ > var5) {
																		class1.cameraZ = var5;
																	}
																}

																if (class1.cameraZ > var5) {
																	class1.cameraZ -= class96.field1327 * (class1.cameraZ - var5) / 1000 + class83.field1166;
																	if (class1.cameraZ < var5) {
																		class1.cameraZ = var5;
																	}
																}

																var4 = HealthBarUpdate.field1017 * 16384 + 64;
																var5 = class30.field259 * 16384 + 64;
																var6 = ScriptEvent.getTileHeight(var4, var5, class42.plane) - WorldMapID.field268;
																var7 = var4 - PacketBuffer.cameraX;
																var8 = var6 - class43.cameraY;
																var9 = var5 - class1.cameraZ;
																var10 = (int)Math.sqrt((double)(var7 * var7 + var9 * var9));
																var11 = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
																var12 = (int)(Math.atan2((double)var7, (double)var9) * -325.949D) & 2047;
																if (var11 < 128) {
																	var11 = 128;
																}

																if (var11 > 383) {
																	var11 = 383;
																}

																if (GrandExchangeOfferNameComparator.cameraPitch < var11) {
																	GrandExchangeOfferNameComparator.cameraPitch = (var11 - GrandExchangeOfferNameComparator.cameraPitch) * Tiles.field501 / 1000 + GrandExchangeOfferNameComparator.cameraPitch + ScriptFrame.field526;
																	if (GrandExchangeOfferNameComparator.cameraPitch > var11) {
																		GrandExchangeOfferNameComparator.cameraPitch = var11;
																	}
																}

																if (GrandExchangeOfferNameComparator.cameraPitch > var11) {
																	GrandExchangeOfferNameComparator.cameraPitch -= Tiles.field501 * (GrandExchangeOfferNameComparator.cameraPitch - var11) / 1000 + ScriptFrame.field526;
																	if (GrandExchangeOfferNameComparator.cameraPitch < var11) {
																		GrandExchangeOfferNameComparator.cameraPitch = var11;
																	}
																}

																int var29 = var12 - Interpreter.cameraYaw;
																if (var29 > 1024) {
																	var29 -= 2048;
																}

																if (var29 < -1024) {
																	var29 += 2048;
																}

																if (var29 > 0) {
																	Interpreter.cameraYaw = var29 * Tiles.field501 / 1000 + Interpreter.cameraYaw + ScriptFrame.field526;
																	Interpreter.cameraYaw &= 2047;
																}

																if (var29 < 0) {
																	Interpreter.cameraYaw -= -var29 * Tiles.field501 / 1000 + ScriptFrame.field526;
																	Interpreter.cameraYaw &= 2047;
																}

																int var14 = var12 - Interpreter.cameraYaw;
																if (var14 > 1024) {
																	var14 -= 2048;
																}

																if (var14 < -1024) {
																	var14 += 2048;
																}

																if (var14 < 0 && var29 > 0 || var14 > 0 && var29 < 0) {
																	Interpreter.cameraYaw = var12;
																}
															}

															for (var4 = 0; var4 < 5; ++var4) {
																int var10002 = field904[var4]++;
															}

															Clock.varcs.tryWrite();
															var4 = ++MouseHandler.MouseHandler_idleCycles - 1;
															var6 = KeyHandler.KeyHandler_idleCycles;
															PacketBufferNode var30;
															if (var4 > 15000 && var6 > 15000) {
																field700 = 250;
																MouseHandler.MouseHandler_idleCycles = 14500;
																var30 = Archive.method4265(ClientPacket.field2300, packetWriter.isaacCipher);
																packetWriter.method2219(var30);
															}

															ArchiveLoader.friendSystem.method1762();
															++packetWriter.field1319;
															if (packetWriter.field1319 > 50) {
																var30 = Archive.method4265(ClientPacket.field2225, packetWriter.isaacCipher);
																packetWriter.method2219(var30);
															}

															try {
																packetWriter.method2234();
															} catch (IOException var31) {
																ScriptFrame.method1090();
															}

															return;
														}

														var28 = var41.widget;
														if (var28.childIndex < 0) {
															break;
														}

														var39 = class80.getWidget(var28.parentId);
													} while(var39 == null || var39.children == null || var28.childIndex >= var39.children.length || var28 != var39.children[var28.childIndex]);

													LoginPacket.runScriptEvent(var41);
												}
											}

											var28 = var41.widget;
											if (var28.childIndex < 0) {
												break;
											}

											var39 = class80.getWidget(var28.parentId);
										} while(var39 == null || var39.children == null || var28.childIndex >= var39.children.length || var28 != var39.children[var28.childIndex]);

										LoginPacket.runScriptEvent(var41);
									}
								}

								var28 = var41.widget;
								if (var28.childIndex < 0) {
									break;
								}

								var39 = class80.getWidget(var28.parentId);
							} while(var39 == null || var39.children == null || var28.childIndex >= var39.children.length || var28 != var39.children[var28.childIndex]);

							LoginPacket.runScriptEvent(var41);
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1617101116"
	)
	@Export("resizeJS")
	void resizeJS() {
		int var1 = GrandExchangeEvent.canvasWidth;
		int var2 = ParamDefinition.canvasHeight;
		if (super.contentWidth < var1) {
			var1 = super.contentWidth;
		}

		if (super.contentHeight < var2) {
			var2 = super.contentHeight;
		}

		if (WorldMapLabelSize.clientPreferences != null) {
			try {
				class47.method806(WorldMapSprite.client, "resize", new Object[]{AbstractWorldMapIcon.getWindowedMode()});
			} catch (Throwable var4) {
			}
		}

	}

	@ObfuscatedName("fc")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2072838249"
	)
	@Export("drawLoggedIn")
	final void drawLoggedIn() {
		if (rootInterface != -1) {
			Archive.method4269(rootInterface);
		}

		int var1;
		for (var1 = 0; var1 < rootWidgetCount; ++var1) {
			if (field843[var1]) {
				field861[var1] = true;
			}

			field862[var1] = field843[var1];
			field843[var1] = false;
		}

		field741 = cycle;
		field803 = -1;
		field804 = -1;
		class294.field3697 = null;
		if (rootInterface != -1) {
			rootWidgetCount = 0;
			class191.drawWidgets(rootInterface, 0, 0, GrandExchangeEvent.canvasWidth, ParamDefinition.canvasHeight, 0, 0, -1);
		}

		Rasterizer2D.Rasterizer2D_resetClip();
		if (showMouseCross) {
			if (mouseCrossColor == 1) {
				Occluder.crossSprites[mouseCrossState * 20 / 100].drawAt2(mouseCrossX - 8, mouseCrossY - 8);
			}

			if (mouseCrossColor == 2) {
				Occluder.crossSprites[mouseCrossState * 20 / 100 + 4].drawAt2(mouseCrossX - 8, mouseCrossY - 8);
			}
		}

		int var2;
		int var3;
		int var4;
		int var6;
		int var7;
		int var13;
		if (!isMenuOpen) {
			if (field803 != -1) {
				WorldMapSprite.drawMenuActionTextAt(field803, field804);
			}
		} else {
			var1 = class247.menuX;
			var2 = class30.menuY;
			var3 = class42.menuWidth;
			var4 = ObjectSound.menuHeight;
			int var14 = 6116423;
			Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, var14);
			Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
			WorldMapIcon_1.fontBold12.draw("Choose Option", var1 + 3, var2 + 14, var14, -1);
			var6 = MouseHandler.MouseHandler_x;
			var7 = MouseHandler.MouseHandler_y;

			int var15;
			int var16;
			for (var13 = 0; var13 < menuOptionsCount; ++var13) {
				var15 = var2 + (menuOptionsCount - 1 - var13) * 15 + 31;
				var16 = 16777215;
				if (var6 > var1 && var6 < var1 + var3 && var7 > var15 - 13 && var7 < var15 + 3) {
					var16 = 16776960;
				}

				WorldMapIcon_1.fontBold12.draw(WorldMapLabel.method417(var13), var1 + 3, var15, var16, 0);
			}

			var13 = class247.menuX;
			var15 = class30.menuY;
			var16 = class42.menuWidth;
			int var17 = ObjectSound.menuHeight;

			for (int var12 = 0; var12 < rootWidgetCount; ++var12) {
				if (rootWidgetXs[var12] + rootWidgetWidths[var12] > var13 && rootWidgetXs[var12] < var13 + var16 && rootWidgetHeights[var12] + rootWidgetYs[var12] > var15 && rootWidgetYs[var12] < var15 + var17) {
					field861[var12] = true;
				}
			}
		}

		if (gameDrawingMode == 3) {
			for (var1 = 0; var1 < rootWidgetCount; ++var1) {
				if (field862[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
				} else if (field861[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
				}
			}
		}

		var1 = class42.plane;
		var2 = localPlayer.x;
		var3 = localPlayer.y;
		var4 = field718;

		for (ObjectSound var5 = (ObjectSound)ObjectSound.objectSounds.last(); var5 != null; var5 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var5.soundEffectId != -1 || var5.soundEffectIds != null) {
				var6 = 0;
				if (var2 > var5.field1077 * 128) {
					var6 += var2 - var5.field1077 * 128;
				} else if (var2 < var5.field1083 * 16384) {
					var6 += var5.field1083 * 16384 - var2;
				}

				if (var3 > var5.field1082 * 128) {
					var6 += var3 - var5.field1082 * 128;
				} else if (var3 < var5.field1090 * 128) {
					var6 += var5.field1090 * 128 - var3;
				}

				if (var6 - 64 <= var5.field1091 && field892 != 0 && var1 == var5.field1078) {
					var6 -= 64;
					if (var6 < 0) {
						var6 = 0;
					}

					var7 = (var5.field1091 - var6) * field892 / var5.field1091;
					Object var10000;
					if (var5.stream1 == null) {
						if (var5.soundEffectId >= 0) {
							var10000 = null;
							SoundEffect var8 = SoundEffect.readSoundEffect(class13.archive4, var5.soundEffectId, 0);
							if (var8 != null) {
								RawSound var9 = var8.toRawSound().resample(AttackOption.decimator);
								RawPcmStream var10 = RawPcmStream.createRawPcmStream(var9, 100, var7);
								var10.setNumLoops(-1);
								SecureRandomCallable.pcmStreamMixer.addSubStream(var10);
								var5.stream1 = var10;
							}
						}
					} else {
						var5.stream1.method2527(var7);
					}

					if (var5.stream2 == null) {
						if (var5.soundEffectIds != null && (var5.field1089 -= var4) <= 0) {
							var13 = (int)(Math.random() * (double)var5.soundEffectIds.length);
							var10000 = null;
							SoundEffect var18 = SoundEffect.readSoundEffect(class13.archive4, var5.soundEffectIds[var13], 0);
							if (var18 != null) {
								RawSound var19 = var18.toRawSound().resample(AttackOption.decimator);
								RawPcmStream var11 = RawPcmStream.createRawPcmStream(var19, 100, var7);
								var11.setNumLoops(0);
								SecureRandomCallable.pcmStreamMixer.addSubStream(var11);
								var5.stream2 = var11;
								var5.field1089 = var5.field1086 + (int)(Math.random() * (double)(var5.field1081 - var5.field1086));
							}
						}
					} else {
						var5.stream2.method2527(var7);
						if (!var5.stream2.hasNext()) {
							var5.stream2 = null;
						}
					}
				} else {
					if (var5.stream1 != null) {
						SecureRandomCallable.pcmStreamMixer.removeSubStream(var5.stream1);
						var5.stream1 = null;
					}

					if (var5.stream2 != null) {
						SecureRandomCallable.pcmStreamMixer.removeSubStream(var5.stream2);
						var5.stream2 = null;
					}
				}
			}
		}

		field718 = 0;
	}

	@ObfuscatedName("gg")
	@ObfuscatedSignature(
		signature = "(Lcg;I)Z",
		garbageValue = "1494391815"
	)
	final boolean method1451(PacketWriter var1) {
		AbstractSocket var2 = var1.getSocket();
		PacketBuffer var3 = var1.packetBuffer;
		if (var2 == null) {
			return false;
		} else {
			int var17;
			String var18;
			try {
				int var5;
				if (var1.serverPacket == null) {
					if (var1.field1322) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 0, 1);
						var1.field1318 = 0;
						var1.field1322 = false;
					}

					var3.offset = 0;
					if (var3.method5441()) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 1, 1);
						var1.field1318 = 0;
					}

					var1.field1322 = true;
					ServerPacket[] var4 = Interpreter.ServerPacket_values();
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
				var1.field1318 = 0;
				timer.method5005();
				var1.field1317 = var1.field1321;
				var1.field1321 = var1.field1309;
				var1.field1309 = var1.serverPacket;
				Widget var6;
				int var16;
				boolean var47;
				if (ServerPacket.field2136 == var1.serverPacket) {
					var16 = var3.readInt();
					var47 = var3.readUnsignedByte() == 1;
					var6 = class80.getWidget(var16);
					if (var47 != var6.isHidden) {
						var6.isHidden = var47;
						Strings.method4120(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2115 == var1.serverPacket) {
					minimapState = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2200 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					SoundCache.method2491(var16);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2128 == var1.serverPacket) {
					class1.method10(class185.field2320);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2168 == var1.serverPacket) {
					byte var60 = var3.method5694();
					var5 = var3.method5518();
					Varps.Varps_temp[var5] = var60;
					if (Varps.Varps_main[var5] != var60) {
						Varps.Varps_main[var5] = var60;
					}

					GrandExchangeOfferUnitPriceComparator.method124(var5);
					field863[++field806 - 1 & 31] = var5;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2179 == var1.serverPacket) {
					DefaultsGroup.field3819 = var3.readUnsignedByteNegate();
					ChatChannel.field1306 = var3.method5525();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2161 == var1.serverPacket) {
					var16 = var3.method5532();
					GroundItemPile.method2764(var16);
					field888[++field671 - 1 & 31] = var16 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2149 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					class192.method3675(var16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2137 == var1.serverPacket) {
					class1.method10(class185.field2315);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2187 == var1.serverPacket) {
					rebootTimer = var3.readUnsignedShort() * 30;
					field844 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				int var7;
				Widget var8;
				if (ServerPacket.field2123 == var1.serverPacket) {
					var16 = var3.method5534();
					var5 = var3.method5534();
					var17 = var3.method5534();
					var7 = var3.method5543();
					var8 = class80.getWidget(var7);
					if (var16 != var8.modelAngleX || var17 != var8.modelAngleY || var5 != var8.modelZoom) {
						var8.modelAngleX = var16;
						var8.modelAngleY = var17;
						var8.modelZoom = var5;
						Strings.method4120(var8);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2120 == var1.serverPacket) {
					ChatChannel.field1306 = var3.method5525();
					DefaultsGroup.field3819 = var3.readUnsignedByteNegate();

					while (var3.offset < var1.serverPacketLength) {
						var16 = var3.readUnsignedByte();
						class185 var58 = GrandExchangeEvents.method70()[var16];
						class1.method10(var58);
					}

					var1.serverPacket = null;
					return true;
				}

				Widget var19;
				if (ServerPacket.field2125 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var5 == 65535) {
						var5 = -1;
					}

					var17 = var3.method5543();
					var19 = class80.getWidget(var16);
					ItemDefinition var43;
					if (!var19.isIf3) {
						if (var5 == -1) {
							var19.modelType = 0;
							var1.serverPacket = null;
							return true;
						}

						var43 = WorldMapArea.getItemDefinition(var5);
						var19.modelType = 4;
						var19.modelId = var5;
						var19.modelAngleX = var43.xan2d;
						var19.modelAngleY = var43.yan2d;
						var19.modelZoom = var43.zoom2d * 100 / var17;
						Strings.method4120(var19);
					} else {
						var19.itemId = var5;
						var19.itemQuantity = var17;
						var43 = WorldMapArea.getItemDefinition(var5);
						var19.modelAngleX = var43.xan2d;
						var19.modelAngleY = var43.yan2d;
						var19.modelAngleZ = var43.zan2d;
						var19.modelOffsetX = var43.offsetX2d;
						var19.modelOffsetY = var43.offsetY2d;
						var19.modelZoom = var43.zoom2d;
						if (var43.isStackable == 1) {
							var19.itemQuantityMode = 1;
						} else {
							var19.itemQuantityMode = 2;
						}

						if (var19.field2619 > 0) {
							var19.modelZoom = var19.modelZoom * 32 / var19.field2619;
						} else if (var19.rawWidth > 0) {
							var19.modelZoom = var19.modelZoom * 32 / var19.rawWidth;
						}

						Strings.method4120(var19);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2158 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var17 = var3.readUnsignedShort();
					class81.queueSoundEffect(var16, var5, var17);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2154 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					var5 = var3.readUnsignedByte();
					var17 = var3.readUnsignedByte();
					var7 = var3.readUnsignedByte();
					field886[var16] = true;
					field901[var16] = var5;
					field902[var16] = var17;
					field903[var16] = var7;
					field904[var16] = 0;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2166 == var1.serverPacket) {
					Tiles.loadRegions(true, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2194 == var1.serverPacket) {
					InterfaceParent.updatePlayers(var3, var1.serverPacketLength);
					ObjectSound.method1827();
					var1.serverPacket = null;
					return true;
				}

				int var9;
				int var10;
				int var20;
				if (ServerPacket.field2198 == var1.serverPacket) {
					isCameraLocked = true;
					HealthBarUpdate.field1017 = var3.readUnsignedByte() * 128;
					class30.field259 = var3.readUnsignedByte() * 128;
					WorldMapID.field268 = var3.readUnsignedShort();
					ScriptFrame.field526 = var3.readUnsignedByte();
					Tiles.field501 = var3.readUnsignedByte();
					if (Tiles.field501 >= 100) {
						var16 = HealthBarUpdate.field1017 * 16384 + 64;
						var5 = class30.field259 * 16384 + 64;
						var17 = ScriptEvent.getTileHeight(var16, var5, class42.plane) - WorldMapID.field268;
						var7 = var16 - PacketBuffer.cameraX;
						var20 = var17 - class43.cameraY;
						var9 = var5 - class1.cameraZ;
						var10 = (int)Math.sqrt((double)(var9 * var9 + var7 * var7));
						GrandExchangeOfferNameComparator.cameraPitch = (int)(Math.atan2((double)var20, (double)var10) * 325.949D) & 2047;
						Interpreter.cameraYaw = (int)(Math.atan2((double)var7, (double)var9) * -325.949D) & 2047;
						if (GrandExchangeOfferNameComparator.cameraPitch < 128) {
							GrandExchangeOfferNameComparator.cameraPitch = 128;
						}

						if (GrandExchangeOfferNameComparator.cameraPitch > 383) {
							GrandExchangeOfferNameComparator.cameraPitch = 383;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2116 == var1.serverPacket) {
					RouteStrategy.method3593();
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2150 == var1.serverPacket) {
					World var40 = new World();
					var40.host = var3.readStringCp1252NullTerminated();
					var40.id = var3.readUnsignedShort();
					var5 = var3.readInt();
					var40.properties = var5;
					class96.updateGameState(45);
					var2.close();
					var2 = null;
					MusicPatchPcmStream.changeWorld(var40);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2157 == var1.serverPacket) {
					class1.method10(class185.field2318);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2164 == var1.serverPacket) {
					class1.method10(class185.field2324);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2145 == var1.serverPacket) {
					var16 = var3.method5543();
					var5 = var3.method5534();
					var6 = class80.getWidget(var16);
					if (var6 != null && var6.type == 0) {
						if (var5 > var6.scrollHeight - var6.height) {
							var5 = var6.scrollHeight - var6.height;
						}

						if (var5 < 0) {
							var5 = 0;
						}

						if (var5 != var6.scrollY) {
							var6.scrollY = var5;
							Strings.method4120(var6);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				long var21;
				if (ServerPacket.field2163 == var1.serverPacket) {
					var16 = var3.method5541();
					var5 = var3.method5518();
					if (var5 == 65535) {
						var5 = -1;
					}

					var17 = var3.method5543();
					var7 = var3.readUnsignedShort();
					if (var7 == 65535) {
						var7 = -1;
					}

					for (var20 = var7; var20 <= var5; ++var20) {
						var21 = (long)var20 + ((long)var17 << 32);
						Node var46 = widgetClickMasks.get(var21);
						if (var46 != null) {
							var46.remove();
						}

						widgetClickMasks.put(new IntegerNode(var16), var21);
					}

					var1.serverPacket = null;
					return true;
				}

				Widget var53;
				if (ServerPacket.field2122 == var1.serverPacket) {
					var16 = var3.method5542();
					var53 = class80.getWidget(var16);

					for (var17 = 0; var17 < var53.itemIds.length; ++var17) {
						var53.itemIds[var17] = -1;
						var53.itemIds[var17] = 0;
					}

					Strings.method4120(var53);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2165 == var1.serverPacket) {
					var16 = var3.readInt();
					if (var16 != field855) {
						field855 = var16;
						Actor.method1670();
					}

					var1.serverPacket = null;
					return true;
				}

				InterfaceParent var52;
				if (ServerPacket.field2192 == var1.serverPacket) {
					var16 = var3.method5722();
					var5 = var3.method5542();
					var17 = var3.method5534();
					var52 = (InterfaceParent)interfaceParents.get((long)var5);
					if (var52 != null) {
						class197.closeInterface(var52, var17 != var52.group);
					}

					PendingSpawn.method1652(var5, var17, var16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2183 == var1.serverPacket) {
					class226.field3072 = NetSocket.method3530(var3.readUnsignedByte());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2138 == var1.serverPacket) {
					var16 = var3.method5534();
					if (var16 == 65535) {
						var16 = -1;
					}

					GrandExchangeOfferTotalQuantityComparator.method93(var16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2155 == var1.serverPacket) {
					var16 = var3.method5591();
					var5 = var3.method5518();
					if (var5 == 65535) {
						var5 = -1;
					}

					WorldMapLabelSize.method188(var5, var16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2124 == var1.serverPacket) {
					var16 = var3.readShort();
					var5 = var3.method5543();
					var6 = class80.getWidget(var5);
					if (var16 != var6.sequenceId || var16 == -1) {
						var6.sequenceId = var16;
						var6.modelFrame = 0;
						var6.modelFrameCycle = 0;
						Strings.method4120(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2147 == var1.serverPacket) {
					ArchiveLoader.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
					class2.method28();
					field672 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2196 == var1.serverPacket) {
					ScriptFrame.updateNpcs(true, var3);
					var1.serverPacket = null;
					return true;
				}

				long var12;
				long var23;
				long var25;
				String var37;
				if (ServerPacket.field2142 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					var23 = var3.readLong();
					var25 = (long)var3.readUnsignedShort();
					var21 = (long)var3.readMedium();
					PlayerType var11 = (PlayerType)SoundSystem.findEnumerated(UserComparator5.PlayerType_values(), var3.readUnsignedByte());
					var12 = (var25 << 32) + var21;
					boolean var49 = false;

					for (int var15 = 0; var15 < 100; ++var15) {
						if (field922[var15] == var12) {
							var49 = true;
							break;
						}
					}

					if (var11.isUser && ArchiveLoader.friendSystem.isIgnored(new Username(var37, class40.loginType))) {
						var49 = true;
					}

					if (!var49 && field767 == 0) {
						field922[field875] = var12;
						field875 = (field875 + 1) % 100;
						String var27 = AbstractFont.escapeBrackets(class1.method17(DefaultsGroup.method5898(var3)));
						if (var11.modIcon != -1) {
							class14.addChatMessage(9, WorldMapSection1.getModIconString(var11.modIcon) + var37, var27, class215.method4023(var23));
						} else {
							class14.addChatMessage(9, var37, var27, class215.method4023(var23));
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2177 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					Object[] var57 = new Object[var37.length() + 1];

					for (var17 = var37.length() - 1; var17 >= 0; --var17) {
						if (var37.charAt(var17) == 's') {
							var57[var17 + 1] = var3.readStringCp1252NullTerminated();
						} else {
							var57[var17 + 1] = new Integer(var3.readInt());
						}
					}

					var57[0] = new Integer(var3.readInt());
					ScriptEvent var48 = new ScriptEvent();
					var48.args = var57;
					LoginPacket.runScriptEvent(var48);
					var1.serverPacket = null;
					return true;
				}

				String var44;
				if (ServerPacket.field2133 == var1.serverPacket) {
					byte[] var39 = new byte[var1.serverPacketLength];
					var3.method5443(var39, 0, var39.length);
					Buffer var55 = new Buffer(var39);
					var44 = var55.readStringCp1252NullTerminated();
					GrandExchangeOfferWorldComparator.openURL(var44, true, false);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2162 == var1.serverPacket) {
					if (var1.serverPacketLength == 0) {
						DevicePcmPlayerProvider.clanChat = null;
					} else {
						if (DevicePcmPlayerProvider.clanChat == null) {
							DevicePcmPlayerProvider.clanChat = new ClanChat(class40.loginType, WorldMapSprite.client);
						}

						DevicePcmPlayerProvider.clanChat.readUpdate(var3);
					}

					class267.method4986();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2143 == var1.serverPacket) {
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

				if (ServerPacket.field2189 == var1.serverPacket) {
					if (DevicePcmPlayerProvider.clanChat != null) {
						DevicePcmPlayerProvider.clanChat.method5234(var3);
					}

					class267.method4986();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2121 == var1.serverPacket) {
					isCameraLocked = true;
					DevicePcmPlayerProvider.field412 = var3.readUnsignedByte() * 128;
					class210.field2516 = var3.readUnsignedByte() * 128;
					class190.field2345 = var3.readUnsignedShort();
					class83.field1166 = var3.readUnsignedByte();
					class96.field1327 = var3.readUnsignedByte();
					if (class96.field1327 >= 100) {
						PacketBuffer.cameraX = DevicePcmPlayerProvider.field412 * 16384 + 64;
						class1.cameraZ = class210.field2516 * 16384 + 64;
						class43.cameraY = ScriptEvent.getTileHeight(PacketBuffer.cameraX, class1.cameraZ, class42.plane) - class190.field2345;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2117 == var1.serverPacket) {
					isCameraLocked = false;

					for (var16 = 0; var16 < 5; ++var16) {
						field886[var16] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2127 == var1.serverPacket) {
					class1.method10(class185.field2319);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2144 == var1.serverPacket) {
					ArchiveLoader.friendSystem.method1760();
					field672 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2191 == var1.serverPacket) {
					class65.method1176();
					var16 = var3.method5541();
					var5 = var3.readUnsignedByteNegate();
					var17 = var3.readUnsignedByte();
					experience[var5] = var16;
					currentLevels[var5] = var17;
					levels[var5] = 1;

					for (var7 = 0; var7 < 98; ++var7) {
						if (var16 >= Skills.Skills_experienceTable[var7]) {
							levels[var5] = var7 + 2;
						}
					}

					changedSkills[++changedSkillsCount - 1 & 31] = var5;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2190 == var1.serverPacket) {
					class1.method10(class185.field2317);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2129 == var1.serverPacket) {
					class1.method10(class185.field2321);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2130 == var1.serverPacket) {
					class1.method10(class185.field2322);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2173 == var1.serverPacket) {
					var16 = var3.method5722();
					var5 = var3.method5722();
					var44 = var3.readStringCp1252NullTerminated();
					if (var5 >= 1 && var5 <= 8) {
						if (var44.equalsIgnoreCase("null")) {
							var44 = null;
						}

						playerMenuActions[var5 - 1] = var44;
						playerOptionsPriorities[var5 - 1] = var16 == 0;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2176 == var1.serverPacket) {
					var16 = var3.readInt();
					InterfaceParent var54 = (InterfaceParent)interfaceParents.get((long)var16);
					if (var54 != null) {
						class197.closeInterface(var54, true);
					}

					if (field850 != null) {
						Strings.method4120(field850);
						field850 = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2170 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					if (var3.readUnsignedByte() == 0) {
						grandExchangeOffers[var16] = new GrandExchangeOffer();
						var3.offset += 18;
					} else {
						--var3.offset;
						grandExchangeOffers[var16] = new GrandExchangeOffer(var3, false);
					}

					field915 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2188 == var1.serverPacket) {
					for (var16 = 0; var16 < Varps.Varps_main.length; ++var16) {
						if (Varps.Varps_temp[var16] != Varps.Varps_main[var16]) {
							Varps.Varps_main[var16] = Varps.Varps_temp[var16];
							GrandExchangeOfferUnitPriceComparator.method124(var16);
							field863[++field806 - 1 & 31] = var16;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2118 == var1.serverPacket) {
					var16 = var3.method5534();
					var5 = var3.method5543();
					var6 = class80.getWidget(var5);
					if (var6.modelType != 2 || var16 != var6.modelId) {
						var6.modelType = 2;
						var6.modelId = var16;
						Strings.method4120(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2174 == var1.serverPacket) {
					var16 = var3.method5542();
					var5 = var3.method5500();
					var17 = var3.method5535();
					var19 = class80.getWidget(var16);
					if (var17 != var19.rawX || var5 != var19.rawY || var19.xAlignment != 0 || var19.yAlignment != 0) {
						var19.rawX = var17;
						var19.rawY = var5;
						var19.xAlignment = 0;
						var19.yAlignment = 0;
						Strings.method4120(var19);
						this.alignWidget(var19);
						if (var19.type == 0) {
							WorldMapSprite.revalidateWidgetScroll(Widget.Widget_interfaceComponents[var16 >> 16], var19, false);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2160 == var1.serverPacket) {
					Tiles.loadRegions(false, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2152 == var1.serverPacket) {
					var16 = var3.readUShortSmart();
					var47 = var3.readUnsignedByte() == 1;
					var44 = "";
					boolean var45 = false;
					if (var47) {
						var44 = var3.readStringCp1252NullTerminated();
						if (ArchiveLoader.friendSystem.isIgnored(new Username(var44, class40.loginType))) {
							var45 = true;
						}
					}

					String var42 = var3.readStringCp1252NullTerminated();
					if (!var45) {
						ScriptEvent.addGameMessage(var16, var44, var42);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2119 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.readInt();
					Varps.Varps_temp[var16] = var5;
					if (Varps.Varps_main[var16] != var5) {
						Varps.Varps_main[var16] = var5;
					}

					GrandExchangeOfferUnitPriceComparator.method124(var16);
					field863[++field806 - 1 & 31] = var16;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2140 == var1.serverPacket) {
					ChatChannel.field1306 = var3.readUnsignedByteNegate();
					DefaultsGroup.field3819 = var3.readUnsignedByte();

					for (var16 = DefaultsGroup.field3819; var16 < DefaultsGroup.field3819 + 8; ++var16) {
						for (var5 = ChatChannel.field1306; var5 < ChatChannel.field1306 + 8; ++var5) {
							if (groundItems[class42.plane][var16][var5] != null) {
								groundItems[class42.plane][var16][var5] = null;
								GrandExchangeOfferWorldComparator.updateItemPile(var16, var5);
							}
						}
					}

					for (PendingSpawn var38 = (PendingSpawn)pendingSpawns.last(); var38 != null; var38 = (PendingSpawn)pendingSpawns.previous()) {
						if (var38.x >= DefaultsGroup.field3819 && var38.x < DefaultsGroup.field3819 + 8 && var38.y >= ChatChannel.field1306 && var38.y < ChatChannel.field1306 + 8 && var38.plane == class42.plane) {
							var38.hitpoints = 0;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2184 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readInt();
					var17 = SoundSystem.method2479();
					PacketBufferNode var56 = Archive.method4265(ClientPacket.field2236, packetWriter.isaacCipher);
					var56.packetBuffer.method5521(var17);
					var56.packetBuffer.writeByte(GameShell.fps);
					var56.packetBuffer.writeIntME(var16);
					var56.packetBuffer.writeIntLE(var5);
					packetWriter.method2219(var56);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2199 == var1.serverPacket) {
					var16 = var3.method5534();
					rootInterface = var16;
					this.resizeRoot(false);
					GrandExchangeOfferAgeComparator.method146(var16);
					Canvas.runWidgetOnLoadListener(rootInterface);

					for (var5 = 0; var5 < 100; ++var5) {
						field843[var5] = true;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2181 == var1.serverPacket) {
					var16 = var3.method5543();
					var53 = class80.getWidget(var16);
					var53.modelType = 3;
					var53.modelId = localPlayer.appearance.getChatHeadId();
					Strings.method4120(var53);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2180 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					var18 = AbstractFont.escapeBrackets(class1.method17(DefaultsGroup.method5898(var3)));
					ScriptEvent.addGameMessage(6, var37, var18);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2153 == var1.serverPacket) {
					ChatChannel.method2213(var3, var1.serverPacketLength);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2151 == var1.serverPacket) {
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
						hintArrowHeight = var3.readUnsignedByte() * 2;
					}

					if (hintArrowType == 10) {
						hintArrowPlayerIndex = var3.readUnsignedShort();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2178 == var1.serverPacket) {
					class1.method10(class185.field2323);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2193 == var1.serverPacket) {
					for (var16 = 0; var16 < VarpDefinition.VarpDefinition_fileCount; ++var16) {
						VarpDefinition var51 = GrandExchangeOfferWorldComparator.method61(var16);
						if (var51 != null) {
							Varps.Varps_temp[var16] = 0;
							Varps.Varps_main[var16] = 0;
						}
					}

					class65.method1176();
					field806 += 32;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2171 == var1.serverPacket) {
					var16 = var3.offset + var1.serverPacketLength;
					var5 = var3.readUnsignedShort();
					var17 = var3.readUnsignedShort();
					if (var5 != rootInterface) {
						rootInterface = var5;
						this.resizeRoot(false);
						GrandExchangeOfferAgeComparator.method146(rootInterface);
						Canvas.runWidgetOnLoadListener(rootInterface);

						for (var7 = 0; var7 < 100; ++var7) {
							field843[var7] = true;
						}
					}

					InterfaceParent var59;
					for (; var17-- > 0; var59.field567 = true) {
						var7 = var3.readInt();
						var20 = var3.readUnsignedShort();
						var9 = var3.readUnsignedByte();
						var59 = (InterfaceParent)interfaceParents.get((long)var7);
						if (var59 != null && var20 != var59.group) {
							class197.closeInterface(var59, true);
							var59 = null;
						}

						if (var59 == null) {
							var59 = PendingSpawn.method1652(var7, var20, var9);
						}
					}

					for (var52 = (InterfaceParent)interfaceParents.first(); var52 != null; var52 = (InterfaceParent)interfaceParents.next()) {
						if (var52.field567) {
							var52.field567 = false;
						} else {
							class197.closeInterface(var52, true);
						}
					}

					widgetClickMasks = new NodeHashTable(512);

					while (var3.offset < var16) {
						var7 = var3.readInt();
						var20 = var3.readUnsignedShort();
						var9 = var3.readUnsignedShort();
						var10 = var3.readInt();

						for (int var29 = var20; var29 <= var9; ++var29) {
							var12 = ((long)var7 << 32) + (long)var29;
							widgetClickMasks.put(new IntegerNode(var10), var12);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2185 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var16 < -70000) {
						var5 += 32768;
					}

					if (var16 >= 0) {
						var6 = class80.getWidget(var16);
					} else {
						var6 = null;
					}

					if (var6 != null) {
						for (var7 = 0; var7 < var6.itemIds.length; ++var7) {
							var6.itemIds[var7] = 0;
							var6.itemQuantities[var7] = 0;
						}
					}

					GrandExchangeOfferAgeComparator.clearItemContainer(var5);
					var7 = var3.readUnsignedShort();

					for (var20 = 0; var20 < var7; ++var20) {
						var9 = var3.readUnsignedShort();
						var10 = var3.readUnsignedByte();
						if (var10 == 255) {
							var10 = var3.method5543();
						}

						if (var6 != null && var20 < var6.itemIds.length) {
							var6.itemIds[var20] = var9;
							var6.itemQuantities[var20] = var10;
						}

						GrandExchangeOfferAgeComparator.itemContainerSetItem(var5, var20, var9 - 1, var10);
					}

					if (var6 != null) {
						Strings.method4120(var6);
					}

					class65.method1176();
					field888[++field671 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2182 == var1.serverPacket) {
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

				if (ServerPacket.field2186 == var1.serverPacket) {
					class65.method1176();
					weight = var3.readShort();
					field844 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2195 == var1.serverPacket) {
					field872 = var3.readUnsignedByteNegate();
					publicChatMode = var3.readUnsignedByteNegate();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2134 == var1.serverPacket) {
					var16 = var3.readInt();
					var18 = var3.readStringCp1252NullTerminated();
					var6 = class80.getWidget(var16);
					if (!var18.equals(var6.text)) {
						var6.text = var18;
						Strings.method4120(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2167 == var1.serverPacket) {
					if (rootInterface != -1) {
						WorldMapLabelSize.method175(rootInterface, 0);
					}

					var1.serverPacket = null;
					return true;
				}

				boolean var50;
				if (ServerPacket.field2131 == var1.serverPacket) {
					var50 = var3.readBoolean();
					if (var50) {
						if (PendingSpawn.field944 == null) {
							PendingSpawn.field944 = new class237();
						}
					} else {
						PendingSpawn.field944 = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2135 == var1.serverPacket) {
					var50 = var3.readUnsignedByte() == 1;
					if (var50) {
						Buddy.field3632 = DirectByteArrayCopier.currentTimeMs() - var3.readLong();
						PendingSpawn.grandExchangeEvents = new GrandExchangeEvents(var3, true);
					} else {
						PendingSpawn.grandExchangeEvents = null;
					}

					field851 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2139 == var1.serverPacket) {
					var16 = var3.method5542();
					var5 = var3.method5518();
					var17 = var5 >> 10 & 31;
					var7 = var5 >> 5 & 31;
					var20 = var5 & 31;
					var9 = (var7 << 11) + (var17 << 19) + (var20 << 3);
					Widget var28 = class80.getWidget(var16);
					if (var9 != var28.color) {
						var28.color = var9;
						Strings.method4120(var28);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2172 == var1.serverPacket) {
					var3.offset += 28;
					if (var3.checkCrc()) {
						WorldMapSprite.method407(var3, var3.offset - 28);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2126 == var1.serverPacket) {
					class1.method10(class185.field2316);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2197 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readInt();
					InterfaceParent var41 = (InterfaceParent)interfaceParents.get((long)var5);
					var52 = (InterfaceParent)interfaceParents.get((long)var16);
					if (var52 != null) {
						class197.closeInterface(var52, var41 == null || var41.group != var52.group);
					}

					if (var41 != null) {
						var41.remove();
						interfaceParents.put(var41, (long)var16);
					}

					var8 = class80.getWidget(var5);
					if (var8 != null) {
						Strings.method4120(var8);
					}

					var8 = class80.getWidget(var16);
					if (var8 != null) {
						Strings.method4120(var8);
						WorldMapSprite.revalidateWidgetScroll(Widget.Widget_interfaceComponents[var8.id >>> 16], var8, true);
					}

					if (rootInterface != -1) {
						WorldMapLabelSize.method175(rootInterface, 1);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2141 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					var23 = (long)var3.readUnsignedShort();
					var25 = (long)var3.readMedium();
					PlayerType var30 = (PlayerType)SoundSystem.findEnumerated(UserComparator5.PlayerType_values(), var3.readUnsignedByte());
					long var31 = (var23 << 32) + var25;
					boolean var33 = false;

					for (int var13 = 0; var13 < 100; ++var13) {
						if (var31 == field922[var13]) {
							var33 = true;
							break;
						}
					}

					if (ArchiveLoader.friendSystem.isIgnored(new Username(var37, class40.loginType))) {
						var33 = true;
					}

					if (!var33 && field767 == 0) {
						field922[field875] = var31;
						field875 = (field875 + 1) % 100;
						String var34 = AbstractFont.escapeBrackets(class1.method17(DefaultsGroup.method5898(var3)));
						byte var14;
						if (var30.isPrivileged) {
							var14 = 7;
						} else {
							var14 = 3;
						}

						if (var30.modIcon != -1) {
							ScriptEvent.addGameMessage(var14, WorldMapSection1.getModIconString(var30.modIcon) + var37, var34);
						} else {
							ScriptEvent.addGameMessage(var14, var37, var34);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2148 == var1.serverPacket) {
					ScriptFrame.updateNpcs(false, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2156 == var1.serverPacket) {
					var16 = var3.method5518();
					var5 = var3.method5532();
					var17 = var3.method5542();
					var19 = class80.getWidget(var17);
					var19.field2575 = var16 + (var5 << 16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2132 == var1.serverPacket) {
					ArchiveLoader.friendSystem.method1805(var3, var1.serverPacketLength);
					field672 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2175 == var1.serverPacket) {
					var16 = var3.method5543();
					var5 = var3.method5534();
					var6 = class80.getWidget(var16);
					if (var6.modelType != 1 || var5 != var6.modelId) {
						var6.modelType = 1;
						var6.modelId = var5;
						Strings.method4120(var6);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2159 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var16 < -70000) {
						var5 += 32768;
					}

					if (var16 >= 0) {
						var6 = class80.getWidget(var16);
					} else {
						var6 = null;
					}

					for (; var3.offset < var1.serverPacketLength; GrandExchangeOfferAgeComparator.itemContainerSetItem(var5, var7, var20 - 1, var9)) {
						var7 = var3.readUShortSmart();
						var20 = var3.readUnsignedShort();
						var9 = 0;
						if (var20 != 0) {
							var9 = var3.readUnsignedByte();
							if (var9 == 255) {
								var9 = var3.readInt();
							}
						}

						if (var6 != null && var7 >= 0 && var7 < var6.itemIds.length) {
							var6.itemIds[var7] = var20;
							var6.itemQuantities[var7] = var9;
						}
					}

					if (var6 != null) {
						Strings.method4120(var6);
					}

					class65.method1176();
					field888[++field671 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2202 == var1.serverPacket) {
					class14.method155(var3.readStringCp1252NullTerminated());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2169 == var1.serverPacket) {
					class65.method1176();
					runEnergy = var3.readUnsignedByte();
					field844 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				HitSplatDefinition.sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1321 != null ? var1.field1321.id : -1) + "," + (var1.field1317 != null ? var1.field1317.id : -1) + "," + var1.serverPacketLength, (Throwable)null);
				RouteStrategy.method3593();
			} catch (IOException var35) {
				ScriptFrame.method1090();
			} catch (Exception var36) {
				var18 = "" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1321 != null ? var1.field1321.id : -1) + "," + (var1.field1317 != null ? var1.field1317.id : -1) + "," + var1.serverPacketLength + "," + (localPlayer.pathX[0] + MusicPatchNode2.baseX * 64) + "," + (localPlayer.pathY[0] + class1.baseY * 64) + ",";

				for (var17 = 0; var17 < var1.serverPacketLength && var17 < 50; ++var17) {
					var18 = var18 + var3.array[var17] + ",";
				}

				HitSplatDefinition.sendStackTrace(var18, var36);
				RouteStrategy.method3593();
			}

			return true;
		}
	}

	@ObfuscatedName("hy")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "116"
	)
	final void method1333() {
		boolean var1 = false;

		int var2;
		int var5;
		while (!var1) {
			var1 = true;

			for (var2 = 0; var2 < menuOptionsCount - 1; ++var2) {
				if (menuOpcodes[var2] < 1000 && menuOpcodes[var2 + 1] > 1000) {
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

		if (WorldMapIcon_0.dragInventoryWidget == null) {
			if (clickedWidget == null) {
				int var20 = MouseHandler.MouseHandler_lastButton;
				int var8;
				int var9;
				int var10;
				int var14;
				int var15;
				int var21;
				if (isMenuOpen) {
					if (var20 != 1 && (DevicePcmPlayerProvider.mouseCam || var20 != 4)) {
						var2 = MouseHandler.MouseHandler_x;
						var14 = MouseHandler.MouseHandler_y;
						if (var2 < class247.menuX - 10 || var2 > class247.menuX + class42.menuWidth + 10 || var14 < class30.menuY - 10 || var14 > class30.menuY + ObjectSound.menuHeight + 10) {
							isMenuOpen = false;
							ChatChannel.method2215(class247.menuX, class30.menuY, class42.menuWidth, ObjectSound.menuHeight);
						}
					}

					if (var20 == 1 || !DevicePcmPlayerProvider.mouseCam && var20 == 4) {
						var2 = class247.menuX;
						var14 = class30.menuY;
						var15 = class42.menuWidth;
						var5 = MouseHandler.MouseHandler_lastPressedX;
						var21 = MouseHandler.MouseHandler_lastPressedY;
						int var22 = -1;

						for (var8 = 0; var8 < menuOptionsCount; ++var8) {
							var9 = (menuOptionsCount - 1 - var8) * 15 + var14 + 31;
							if (var5 > var2 && var5 < var15 + var2 && var21 > var9 - 13 && var21 < var9 + 3) {
								var22 = var8;
							}
						}

						if (var22 != -1 && var22 >= 0) {
							var8 = menuArguments1[var22];
							var9 = menuArguments2[var22];
							var10 = menuOpcodes[var22];
							int var19 = menuArguments0[var22];
							String var12 = menuActions[var22];
							String var13 = menuTargetNames[var22];
							Messages.menuAction(var8, var9, var10, var19, var12, var13, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
						}

						isMenuOpen = false;
						ChatChannel.method2215(class247.menuX, class30.menuY, class42.menuWidth, ObjectSound.menuHeight);
					}
				} else {
					label281: {
						var2 = class13.method151();
						if ((var20 == 1 || !DevicePcmPlayerProvider.mouseCam && var20 == 4) && var2 >= 0) {
							var14 = menuOpcodes[var2];
							if (var14 == 39 || var14 == 40 || var14 == 41 || var14 == 42 || var14 == 43 || var14 == 33 || var14 == 34 || var14 == 35 || var14 == 36 || var14 == 37 || var14 == 38 || var14 == 1005) {
								var15 = menuArguments1[var2];
								var5 = menuArguments2[var2];
								Widget var16 = class80.getWidget(var5);
								var8 = class268.getWidgetClickMask(var16);
								boolean var7 = (var8 >> 28 & 1) != 0;
								if (var7) {
									break label281;
								}

								Object var10000 = null;
								if (UserComparator4.method3382(class268.getWidgetClickMask(var16))) {
									break label281;
								}
							}
						}

						if ((var20 == 1 || !DevicePcmPlayerProvider.mouseCam && var20 == 4) && this.shouldLeftClickOpenMenu()) {
							var20 = 2;
						}

						if ((var20 == 1 || !DevicePcmPlayerProvider.mouseCam && var20 == 4) && menuOptionsCount > 0 && var2 >= 0) {
							var14 = menuArguments1[var2];
							var15 = menuArguments2[var2];
							var5 = menuOpcodes[var2];
							var21 = menuArguments0[var2];
							String var17 = menuActions[var2];
							String var18 = menuTargetNames[var2];
							Messages.menuAction(var14, var15, var5, var21, var17, var18, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
						}

						if (var20 == 2 && menuOptionsCount > 0) {
							this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
						}

						return;
					}

					if (WorldMapIcon_0.dragInventoryWidget != null && !field874 && menuOptionsCount > 0 && !this.shouldLeftClickOpenMenu()) {
						var9 = field654;
						var10 = field763;
						MenuAction var11 = tempMenuAction;
						Messages.menuAction(var11.argument1, var11.argument2, var11.opcode, var11.argument0, var11.action, var11.action, var9, var10);
						tempMenuAction = null;
					}

					field874 = false;
					itemDragDuration = 0;
					if (WorldMapIcon_0.dragInventoryWidget != null) {
						Strings.method4120(WorldMapIcon_0.dragInventoryWidget);
					}

					WorldMapIcon_0.dragInventoryWidget = class80.getWidget(var5);
					dragItemSlotSource = var15;
					field654 = MouseHandler.MouseHandler_lastPressedX;
					field763 = MouseHandler.MouseHandler_lastPressedY;
					if (var2 >= 0) {
						Decimator.method2510(var2);
					}

					Strings.method4120(WorldMapIcon_0.dragInventoryWidget);
					return;
				}

			}
		}
	}

	@ObfuscatedName("hd")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-246080062"
	)
	@Export("shouldLeftClickOpenMenu")
	final boolean shouldLeftClickOpenMenu() {
		int var1 = class13.method151();
		return (field789 == 1 && menuOptionsCount > 2 || Interpreter.method1936(var1)) && !menuShiftClick[var1];
	}

	@ObfuscatedName("hj")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1898435320"
	)
	@Export("openMenu")
	final void openMenu(int var1, int var2) {
		NetCache.method4312(var1, var2);
		GrandExchangeOfferWorldComparator.scene.menuOpen(class42.plane, var1, var2, false);
		isMenuOpen = true;
	}

	@ObfuscatedName("ik")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "831397747"
	)
	@Export("resizeRoot")
	final void resizeRoot(boolean var1) {
		WorldMapSprite.method416(rootInterface, GrandExchangeEvent.canvasWidth, ParamDefinition.canvasHeight, var1);
	}

	@ObfuscatedName("iw")
	@ObfuscatedSignature(
		signature = "(Lhj;I)V",
		garbageValue = "2120964597"
	)
	@Export("alignWidget")
	void alignWidget(Widget var1) {
		Widget var2 = var1.parentId == -1 ? null : class80.getWidget(var1.parentId);
		int var3;
		int var4;
		if (var2 == null) {
			var3 = GrandExchangeEvent.canvasWidth;
			var4 = ParamDefinition.canvasHeight;
		} else {
			var3 = var2.width;
			var4 = var2.height;
		}

		class219.alignWidgetSize(var1, var3, var4, false);
		PcmPlayer.alignWidgetPosition(var1, var3, var4);
	}

	@ObfuscatedName("jh")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "41"
	)
	final void method1641() {
		Strings.method4120(clickedWidget);
		++class80.widgetDragDuration;
		if (field745 && field873) {
			int var1 = MouseHandler.MouseHandler_x;
			int var2 = MouseHandler.MouseHandler_y;
			var1 -= widgetClickX;
			var2 -= widgetClickY;
			if (var1 < field834) {
				var1 = field834;
			}

			if (var1 + clickedWidget.width > field834 + clickedWidgetParent.width) {
				var1 = field834 + clickedWidgetParent.width - clickedWidget.width;
			}

			if (var2 < field835) {
				var2 = field835;
			}

			if (var2 + clickedWidget.height > field835 + clickedWidgetParent.height) {
				var2 = field835 + clickedWidgetParent.height - clickedWidget.height;
			}

			int var3 = var1 - field837;
			int var4 = var2 - field838;
			int var5 = clickedWidget.dragZoneSize;
			if (class80.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
				isDraggingWidget = true;
			}

			int var6 = var1 - field834 + clickedWidgetParent.scrollX;
			int var7 = var2 - field835 + clickedWidgetParent.scrollY;
			ScriptEvent var8;
			if (clickedWidget.onDrag != null && isDraggingWidget) {
				var8 = new ScriptEvent();
				var8.widget = clickedWidget;
				var8.mouseX = var6;
				var8.mouseY = var7;
				var8.args = clickedWidget.onDrag;
				LoginPacket.runScriptEvent(var8);
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
						LoginPacket.runScriptEvent(var8);
					}

					if (draggedOnWidget != null) {
						Widget var9 = clickedWidget;
						int var10 = class32.method545(class268.getWidgetClickMask(var9));
						Widget var15;
						if (var10 == 0) {
							var15 = null;
						} else {
							int var11 = 0;

							while (true) {
								if (var11 >= var10) {
									var15 = var9;
									break;
								}

								var9 = class80.getWidget(var9.parentId);
								if (var9 == null) {
									var15 = null;
									break;
								}

								++var11;
							}
						}

						if (var15 != null) {
							PacketBufferNode var16 = Archive.method4265(ClientPacket.field2260, packetWriter.isaacCipher);
							var16.packetBuffer.method5530(clickedWidget.childIndex);
							var16.packetBuffer.method5530(draggedOnWidget.itemId);
							var16.packetBuffer.writeShort(draggedOnWidget.childIndex);
							var16.packetBuffer.writeIntLE(clickedWidget.id);
							var16.packetBuffer.writeIntME(draggedOnWidget.id);
							var16.packetBuffer.writeShort(clickedWidget.itemId);
							packetWriter.method2219(var16);
						}
					}
				} else if (this.shouldLeftClickOpenMenu()) {
					this.openMenu(widgetClickX + field837, widgetClickY + field838);
				} else if (menuOptionsCount > 0) {
					int var13 = widgetClickX + field837;
					int var14 = field838 + widgetClickY;
					MenuAction var12 = tempMenuAction;
					Messages.menuAction(var12.argument1, var12.argument2, var12.opcode, var12.argument0, var12.action, var12.action, var13, var14);
					tempMenuAction = null;
				}

				clickedWidget = null;
			}

		} else {
			if (class80.widgetDragDuration > 1) {
				clickedWidget = null;
			}

		}
	}

	@ObfuscatedName("ku")
	@ObfuscatedSignature(
		signature = "(B)Ljv;",
		garbageValue = "-19"
	)
	@Export("username")
	public Username username() {
		return localPlayer != null ? localPlayer.username : null;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(III)Lhj;",
		garbageValue = "323433634"
	)
	@Export("getWidgetChild")
	public static Widget getWidgetChild(int var0, int var1) {
		Widget var2 = class80.getWidget(var0);
		if (var1 == -1) {
			return var2;
		} else {
			return var2 != null && var2.children != null && var1 < var2.children.length ? var2.children[var1] : null;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "([Lbw;II[I[IB)V",
		garbageValue = "-109"
	)
	@Export("sortWorlds")
	static void sortWorlds(World[] var0, int var1, int var2, int[] var3, int[] var4) {
		if (var1 < var2) {
			int var5 = var1 - 1;
			int var6 = var2 + 1;
			int var7 = (var2 + var1) / 2;
			World var8 = var0[var7];
			var0[var7] = var0[var1];
			var0[var1] = var8;

			while (var5 < var6) {
				boolean var9 = true;

				int var10;
				int var11;
				int var12;
				do {
					--var6;

					for (var10 = 0; var10 < 4; ++var10) {
						if (var3[var10] == 2) {
							var11 = var0[var6].index;
							var12 = var8.index;
						} else if (var3[var10] == 1) {
							var11 = var0[var6].population;
							var12 = var8.population;
							if (var11 == -1 && var4[var10] == 1) {
								var11 = 2001;
							}

							if (var12 == -1 && var4[var10] == 1) {
								var12 = 2001;
							}
						} else if (var3[var10] == 3) {
							var11 = var0[var6].isMembersOnly() ? 1 : 0;
							var12 = var8.isMembersOnly() ? 1 : 0;
						} else {
							var11 = var0[var6].id;
							var12 = var8.id;
						}

						if (var12 != var11) {
							if ((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
								var9 = false;
							}
							break;
						}

						if (var10 == 3) {
							var9 = false;
						}
					}
				} while(var9);

				var9 = true;

				do {
					++var5;

					for (var10 = 0; var10 < 4; ++var10) {
						if (var3[var10] == 2) {
							var11 = var0[var5].index;
							var12 = var8.index;
						} else if (var3[var10] == 1) {
							var11 = var0[var5].population;
							var12 = var8.population;
							if (var11 == -1 && var4[var10] == 1) {
								var11 = 2001;
							}

							if (var12 == -1 && var4[var10] == 1) {
								var12 = 2001;
							}
						} else if (var3[var10] == 3) {
							var11 = var0[var5].isMembersOnly() ? 1 : 0;
							var12 = var8.isMembersOnly() ? 1 : 0;
						} else {
							var11 = var0[var5].id;
							var12 = var8.id;
						}

						if (var11 != var12) {
							if ((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
								var9 = false;
							}
							break;
						}

						if (var10 == 3) {
							var9 = false;
						}
					}
				} while(var9);

				if (var5 < var6) {
					World var13 = var0[var5];
					var0[var5] = var0[var6];
					var0[var6] = var13;
				}
			}

			sortWorlds(var0, var1, var6, var3, var4);
			sortWorlds(var0, var6 + 1, var2, var3, var4);
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1487250543"
	)
	static final void method1650(String var0) {
		StringBuilder var10000 = (new StringBuilder()).append(var0);
		Object var10001 = null;
		String var1 = var10000.append(" is already on your ignore list").toString();
		ScriptEvent.addGameMessage(30, "", var1);
	}
}
