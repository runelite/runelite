import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
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

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameShell implements Usernamed {
	@ObfuscatedName("mw")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	@Export("clickedWidget")
	static Widget clickedWidget;
	@ObfuscatedName("oj")
	@ObfuscatedGetter(
		intValue = 228290229
	)
	@Export("rootWidgetCount")
	static int rootWidgetCount;
	@ObfuscatedName("ok")
	@ObfuscatedGetter(
		intValue = 986793503
	)
	static int field690;
	@ObfuscatedName("os")
	@ObfuscatedGetter(
		longValue = -7754540937541537763L
	)
	static long field652;
	@ObfuscatedName("oa")
	static boolean[] field847;
	@ObfuscatedName("ob")
	static boolean[] field849;
	@ObfuscatedName("ov")
	static boolean[] field837;
	@ObfuscatedName("ne")
	static boolean field823;
	@ObfuscatedName("of")
	@Export("isResizable")
	static boolean isResizable;
	@ObfuscatedName("nl")
	@ObfuscatedGetter(
		intValue = 1560570297
	)
	@Export("cycleCntr")
	static int cycleCntr;
	@ObfuscatedName("nc")
	@ObfuscatedGetter(
		intValue = -796800237
	)
	static int field833;
	@ObfuscatedName("si")
	@ObfuscatedGetter(
		intValue = -957842515
	)
	public static int field863;
	@ObfuscatedName("nm")
	static boolean field820;
	@ObfuscatedName("qt")
	static boolean field742;
	@ObfuscatedName("ml")
	@ObfuscatedGetter(
		intValue = -944462791
	)
	@Export("widgetClickX")
	static int widgetClickX;
	@ObfuscatedName("me")
	@ObfuscatedGetter(
		intValue = -1327051591
	)
	@Export("widgetClickY")
	static int widgetClickY;
	@ObfuscatedName("nd")
	@ObfuscatedGetter(
		intValue = -1892868949
	)
	static int field698;
	@ObfuscatedName("oy")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("widgetClickMasks")
	static NodeHashTable widgetClickMasks;
	@ObfuscatedName("mp")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	@Export("clickedWidgetParent")
	static Widget clickedWidgetParent;
	@ObfuscatedName("ow")
	@Export("rootWidgetWidths")
	static int[] rootWidgetWidths;
	@ObfuscatedName("mq")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("interfaceParents")
	static NodeHashTable interfaceParents;
	@ObfuscatedName("on")
	@Export("rootWidgetXs")
	static int[] rootWidgetXs;
	@ObfuscatedName("nh")
	@ObfuscatedGetter(
		intValue = -1392572657
	)
	static int field822;
	@ObfuscatedName("mc")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	@Export("viewportWidget")
	static Widget viewportWidget;
	@ObfuscatedName("oe")
	@ObfuscatedGetter(
		intValue = -311062333
	)
	@Export("gameDrawingMode")
	static int gameDrawingMode;
	@ObfuscatedName("oh")
	@Export("rootWidgetHeights")
	static int[] rootWidgetHeights;
	@ObfuscatedName("ms")
	@ObfuscatedGetter(
		intValue = -1520316987
	)
	@Export("staffModLevel")
	static int staffModLevel;
	@ObfuscatedName("ol")
	@Export("rootWidgetYs")
	static int[] rootWidgetYs;
	@ObfuscatedName("tv")
	static int[] field916;
	@ObfuscatedName("tx")
	static int[] field862;
	@ObfuscatedName("tp")
	@ObfuscatedSignature(
		signature = "Lbb;"
	)
	static final class65 field915;
	@ObfuscatedName("or")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("scriptEvents")
	static NodeDeque scriptEvents;
	@ObfuscatedName("ni")
	@ObfuscatedGetter(
		intValue = -463811251
	)
	static int field808;
	@ObfuscatedName("no")
	@ObfuscatedGetter(
		intValue = 414578091
	)
	static int field825;
	@ObfuscatedName("px")
	@ObfuscatedGetter(
		intValue = -731611885
	)
	@Export("destinationX")
	static int destinationX;
	@ObfuscatedName("pn")
	@ObfuscatedGetter(
		intValue = 16541371
	)
	@Export("destinationY")
	static int destinationY;
	@ObfuscatedName("na")
	static int[] field828;
	@ObfuscatedName("nr")
	@ObfuscatedGetter(
		intValue = -2117192957
	)
	static int field829;
	@ObfuscatedName("nv")
	@Export("isDraggingWidget")
	static boolean isDraggingWidget;
	@ObfuscatedName("nf")
	@Export("changedItemContainers")
	static int[] changedItemContainers;
	@ObfuscatedName("mv")
	@ObfuscatedGetter(
		intValue = -660424691
	)
	@Export("runEnergy")
	static int runEnergy;
	@ObfuscatedName("ng")
	@ObfuscatedGetter(
		intValue = 1845259309
	)
	static int field898;
	@ObfuscatedName("my")
	@ObfuscatedGetter(
		intValue = 557453795
	)
	@Export("weight")
	static int weight;
	@ObfuscatedName("mg")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	@Export("meslayerContinueWidget")
	static Widget meslayerContinueWidget;
	@ObfuscatedName("op")
	@ObfuscatedGetter(
		intValue = -735804001
	)
	@Export("mouseWheelRotation")
	static int mouseWheelRotation;
	@ObfuscatedName("nu")
	@Export("changedSkills")
	static int[] changedSkills;
	@ObfuscatedName("nz")
	@ObfuscatedGetter(
		intValue = -485415327
	)
	@Export("changedSkillsCount")
	static int changedSkillsCount;
	@ObfuscatedName("sf")
	@ObfuscatedGetter(
		intValue = 1362250675
	)
	static int field906;
	@ObfuscatedName("rk")
	@ObfuscatedSignature(
		signature = "Lhd;"
	)
	@Export("playerAppearance")
	static PlayerAppearance playerAppearance;
	@ObfuscatedName("qr")
	@ObfuscatedGetter(
		intValue = -412348325
	)
	@Export("areaSoundEffectVolume")
	static int areaSoundEffectVolume;
	@ObfuscatedName("ql")
	@ObfuscatedGetter(
		intValue = 1577720607
	)
	@Export("soundEffectCount")
	static int soundEffectCount;
	@ObfuscatedName("sm")
	@ObfuscatedGetter(
		intValue = -1100705823
	)
	static int field907;
	@ObfuscatedName("mj")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	@Export("draggedOnWidget")
	static Widget draggedOnWidget;
	@ObfuscatedName("qs")
	@Export("soundEffectIds")
	static int[] soundEffectIds;
	@ObfuscatedName("qa")
	@Export("queuedSoundEffectLoops")
	static int[] queuedSoundEffectLoops;
	@ObfuscatedName("qv")
	@Export("queuedSoundEffectDelays")
	static int[] queuedSoundEffectDelays;
	@ObfuscatedName("qj")
	@ObfuscatedGetter(
		intValue = 350468397
	)
	@Export("musicVolume")
	static int musicVolume;
	@ObfuscatedName("qe")
	@ObfuscatedSignature(
		signature = "[Lcz;"
	)
	@Export("soundEffects")
	static SoundEffect[] soundEffects;
	@ObfuscatedName("sq")
	@Export("archiveLoaders")
	static ArrayList archiveLoaders;
	@ObfuscatedName("qq")
	@ObfuscatedGetter(
		intValue = -857958987
	)
	@Export("currentTrackGroupId")
	static int currentTrackGroupId;
	@ObfuscatedName("qd")
	@Export("soundLocations")
	static int[] soundLocations;
	@ObfuscatedName("sk")
	@ObfuscatedGetter(
		intValue = -1151595097
	)
	@Export("archiveLoadersDone")
	static int archiveLoadersDone;
	@ObfuscatedName("qn")
	@ObfuscatedGetter(
		intValue = 1053015149
	)
	@Export("minimapState")
	static int minimapState;
	@ObfuscatedName("qw")
	@Export("isCameraLocked")
	static boolean isCameraLocked;
	@ObfuscatedName("qb")
	@ObfuscatedGetter(
		intValue = 1255558445
	)
	@Export("soundEffectVolume")
	static int soundEffectVolume;
	@ObfuscatedName("re")
	static boolean[] field835;
	@ObfuscatedName("ra")
	static int[] field736;
	@ObfuscatedName("rs")
	static int[] field901;
	@ObfuscatedName("ri")
	static int[] field890;
	@ObfuscatedName("rx")
	static int[] field891;
	@ObfuscatedName("mm")
	@ObfuscatedGetter(
		intValue = -1297477089
	)
	@Export("chatEffects")
	static int chatEffects;
	@ObfuscatedName("pu")
	static long[] field861;
	@ObfuscatedName("pp")
	@ObfuscatedGetter(
		intValue = -1561057363
	)
	static int field867;
	@ObfuscatedName("mx")
	@ObfuscatedGetter(
		intValue = -1459895255
	)
	static int field807;
	@ObfuscatedName("sl")
	@ObfuscatedSignature(
		signature = "Llh;"
	)
	@Export("platformInfoProvider")
	static PlatformInfoProvider platformInfoProvider;
	@ObfuscatedName("pb")
	@ObfuscatedGetter(
		intValue = 590028811
	)
	static int field855;
	@ObfuscatedName("rw")
	static short field880;
	@ObfuscatedName("rn")
	static short field893;
	@ObfuscatedName("rf")
	static short field785;
	@ObfuscatedName("nb")
	@ObfuscatedGetter(
		intValue = 880355845
	)
	static int field834;
	@ObfuscatedName("ru")
	static short field679;
	@ObfuscatedName("rv")
	static short field897;
	@ObfuscatedName("rr")
	@ObfuscatedGetter(
		intValue = -766521235
	)
	@Export("viewportZoom")
	static int viewportZoom;
	@ObfuscatedName("rz")
	static short field896;
	@ObfuscatedName("mt")
	@ObfuscatedGetter(
		intValue = 1669925739
	)
	@Export("followerIndex")
	static int followerIndex;
	@ObfuscatedName("py")
	@ObfuscatedGetter(
		intValue = -1526497235
	)
	@Export("mapIconCount")
	static int mapIconCount;
	@ObfuscatedName("ro")
	@ObfuscatedGetter(
		intValue = 1417358417
	)
	@Export("viewportWidth")
	static int viewportWidth;
	@ObfuscatedName("pw")
	@Export("mapIconXs")
	static int[] mapIconXs;
	@ObfuscatedName("pq")
	@Export("mapIconYs")
	static int[] mapIconYs;
	@ObfuscatedName("pd")
	@ObfuscatedSignature(
		signature = "[Lln;"
	)
	@Export("mapIcons")
	static Sprite[] mapIcons;
	@ObfuscatedName("rj")
	@ObfuscatedGetter(
		intValue = -1082228789
	)
	@Export("viewportHeight")
	static int viewportHeight;
	@ObfuscatedName("ry")
	@ObfuscatedGetter(
		intValue = -668988237
	)
	@Export("viewportOffsetX")
	static int viewportOffsetX;
	@ObfuscatedName("pv")
	@ObfuscatedGetter(
		longValue = -417631311892860553L
	)
	static long field866;
	@ObfuscatedName("rt")
	@ObfuscatedGetter(
		intValue = 885622525
	)
	@Export("viewportOffsetY")
	static int viewportOffsetY;
	@ObfuscatedName("su")
	@ObfuscatedGetter(
		intValue = -352497469
	)
	static int field914;
	@ObfuscatedName("mu")
	@Export("playerMod")
	static boolean playerMod;
	@ObfuscatedName("pg")
	@ObfuscatedGetter(
		intValue = 1090044339
	)
	static int field889;
	@ObfuscatedName("nt")
	@ObfuscatedGetter(
		intValue = -1961048311
	)
	static int field836;
	@ObfuscatedName("nx")
	@ObfuscatedGetter(
		intValue = -375047505
	)
	@Export("chatCycle")
	static int chatCycle;
	@ObfuscatedName("pl")
	static int[] field865;
	@ObfuscatedName("pt")
	static int[] field864;
	@ObfuscatedName("oo")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	static NodeDeque field900;
	@ObfuscatedName("rb")
	@Export("zoomHeight")
	static short zoomHeight;
	@ObfuscatedName("rd")
	@Export("zoomWidth")
	static short zoomWidth;
	@ObfuscatedName("oq")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	static NodeDeque field843;
	@ObfuscatedName("nq")
	@ObfuscatedGetter(
		intValue = -42064155
	)
	static int field734;
	@ObfuscatedName("mk")
	@ObfuscatedGetter(
		intValue = -404795193
	)
	static int field804;
	@ObfuscatedName("mn")
	@ObfuscatedGetter(
		intValue = -305198765
	)
	static int field805;
	@ObfuscatedName("pj")
	@ObfuscatedGetter(
		intValue = 1916921629
	)
	@Export("publicChatMode")
	static int publicChatMode;
	@ObfuscatedName("pk")
	@ObfuscatedGetter(
		intValue = 205603533
	)
	@Export("tradeChatMode")
	static int tradeChatMode;
	@ObfuscatedName("sv")
	@ObfuscatedSignature(
		signature = "[Li;"
	)
	@Export("grandExchangeOffers")
	static GrandExchangeOffer[] grandExchangeOffers;
	@ObfuscatedName("ny")
	@ObfuscatedGetter(
		intValue = -24326817
	)
	static int field645;
	@ObfuscatedName("pa")
	static int[] field857;
	@ObfuscatedName("ph")
	static String field860;
	@ObfuscatedName("sh")
	@ObfuscatedSignature(
		signature = "Lbw;"
	)
	@Export("GrandExchangeEvents_worldComparator")
	static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "[Lfh;"
	)
	@Export("collisionMaps")
	static CollisionMap[] collisionMaps;
	@ObfuscatedName("ah")
	static boolean field831;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = 664513407
	)
	@Export("worldId")
	public static int worldId;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = -1431286255
	)
	@Export("worldProperties")
	static int worldProperties;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = -979515215
	)
	@Export("gameBuild")
	static int gameBuild;
	@ObfuscatedName("bj")
	@Export("isMembersWorld")
	public static boolean isMembersWorld;
	@ObfuscatedName("bm")
	@Export("isLowDetail")
	static boolean isLowDetail;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = 1709497385
	)
	@Export("clientType")
	static int clientType;
	@ObfuscatedName("bb")
	@Export("onMobile")
	static boolean onMobile;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = 1930753179
	)
	@Export("gameState")
	static int gameState;
	@ObfuscatedName("co")
	@Export("isLoading")
	static boolean isLoading;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = -283063249
	)
	@Export("cycle")
	static int cycle;
	@ObfuscatedName("ck")
	@ObfuscatedGetter(
		longValue = 1346502483774771015L
	)
	@Export("mouseLastLastPressedTimeMillis")
	static long mouseLastLastPressedTimeMillis;
	@ObfuscatedName("cy")
	@ObfuscatedGetter(
		intValue = -1710295131
	)
	static int field877;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = -1896423743
	)
	static int field657;
	@ObfuscatedName("cj")
	@ObfuscatedGetter(
		longValue = 7288307648884652687L
	)
	static long field658;
	@ObfuscatedName("cq")
	@Export("hadFocus")
	static boolean hadFocus;
	@ObfuscatedName("ci")
	@Export("displayFps")
	static boolean displayFps;
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		intValue = -179691599
	)
	@Export("rebootTimer")
	static int rebootTimer;
	@ObfuscatedName("cs")
	@ObfuscatedGetter(
		intValue = 1452336083
	)
	@Export("hintArrowType")
	static int hintArrowType;
	@ObfuscatedName("cc")
	@ObfuscatedGetter(
		intValue = 1408841509
	)
	@Export("hintArrowNpcIndex")
	static int hintArrowNpcIndex;
	@ObfuscatedName("cp")
	@ObfuscatedGetter(
		intValue = -1427936639
	)
	@Export("hintArrowPlayerIndex")
	static int hintArrowPlayerIndex;
	@ObfuscatedName("ce")
	@ObfuscatedGetter(
		intValue = -1905046117
	)
	@Export("hintArrowX")
	static int hintArrowX;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		intValue = 1995090411
	)
	@Export("hintArrowY")
	static int hintArrowY;
	@ObfuscatedName("cf")
	@ObfuscatedGetter(
		intValue = -231665652
	)
	@Export("hintArrowHeight")
	static int hintArrowHeight;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = 280792896
	)
	@Export("hintArrowSubX")
	static int hintArrowSubX;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = 1621938368
	)
	@Export("hintArrowSubY")
	static int hintArrowSubY;
	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		signature = "Lco;"
	)
	@Export("playerAttackOption")
	static AttackOption playerAttackOption;
	@ObfuscatedName("dw")
	@ObfuscatedSignature(
		signature = "Lco;"
	)
	@Export("npcAttackOption")
	static AttackOption npcAttackOption;
	@ObfuscatedName("dx")
	@ObfuscatedGetter(
		intValue = 2117225913
	)
	@Export("titleLoadingStage")
	static int titleLoadingStage;
	@ObfuscatedName("dj")
	@ObfuscatedGetter(
		intValue = -1916189945
	)
	@Export("js5ConnectState")
	static int js5ConnectState;
	@ObfuscatedName("dp")
	@ObfuscatedGetter(
		intValue = 1530929997
	)
	static int field674;
	@ObfuscatedName("ec")
	@ObfuscatedGetter(
		intValue = 12617063
	)
	@Export("js5Errors")
	static int js5Errors;
	@ObfuscatedName("em")
	@ObfuscatedGetter(
		intValue = 499634575
	)
	@Export("loginState")
	static int loginState;
	@ObfuscatedName("ee")
	@ObfuscatedGetter(
		intValue = 221607875
	)
	static int field887;
	@ObfuscatedName("eu")
	@ObfuscatedGetter(
		intValue = 1579409689
	)
	static int field678;
	@ObfuscatedName("ea")
	@ObfuscatedGetter(
		intValue = 310708051
	)
	static int field694;
	@ObfuscatedName("er")
	@ObfuscatedSignature(
		signature = "Lfx;"
	)
	static class160 field680;
	@ObfuscatedName("ex")
	@Export("Login_isUsernameRemembered")
	static boolean Login_isUsernameRemembered;
	@ObfuscatedName("ep")
	@ObfuscatedSignature(
		signature = "Lcy;"
	)
	@Export("secureRandomFuture")
	static SecureRandomFuture secureRandomFuture;
	@ObfuscatedName("ei")
	@Export("randomDatData")
	static byte[] randomDatData;
	@ObfuscatedName("ed")
	@ObfuscatedSignature(
		signature = "[Lcd;"
	)
	@Export("npcs")
	static NPC[] npcs;
	@ObfuscatedName("eq")
	@ObfuscatedGetter(
		intValue = -1981398561
	)
	@Export("npcCount")
	static int npcCount;
	@ObfuscatedName("fe")
	@Export("npcIndices")
	static int[] npcIndices;
	@ObfuscatedName("fl")
	@ObfuscatedGetter(
		intValue = 1827526777
	)
	static int field687;
	@ObfuscatedName("fj")
	static int[] field688;
	@ObfuscatedName("fm")
	@ObfuscatedSignature(
		signature = "Lcc;"
	)
	@Export("packetWriter")
	public static final PacketWriter packetWriter;
	@ObfuscatedName("fz")
	@ObfuscatedGetter(
		intValue = 479164645
	)
	@Export("logoutTimer")
	static int logoutTimer;
	@ObfuscatedName("fi")
	static boolean field691;
	@ObfuscatedName("fo")
	@Export("useBufferedSocket")
	static boolean useBufferedSocket;
	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		signature = "Ljl;"
	)
	@Export("timer")
	static Timer timer;
	@ObfuscatedName("fh")
	@Export("fontsMap")
	static HashMap fontsMap;
	@ObfuscatedName("ft")
	@ObfuscatedGetter(
		intValue = -1155714541
	)
	static int field676;
	@ObfuscatedName("fb")
	@ObfuscatedGetter(
		intValue = -2129248571
	)
	static int field794;
	@ObfuscatedName("fw")
	@ObfuscatedGetter(
		intValue = 1251092849
	)
	static int field850;
	@ObfuscatedName("gm")
	@ObfuscatedGetter(
		intValue = 1774005601
	)
	static int field672;
	@ObfuscatedName("gj")
	@ObfuscatedGetter(
		intValue = 333425851
	)
	static int field699;
	@ObfuscatedName("gw")
	@Export("isInInstance")
	static boolean isInInstance;
	@ObfuscatedName("go")
	@Export("instanceChunkTemplates")
	static int[][][] instanceChunkTemplates;
	@ObfuscatedName("ga")
	static final int[] field703;
	@ObfuscatedName("gl")
	@ObfuscatedGetter(
		intValue = 1238371275
	)
	static int field704;
	@ObfuscatedName("hr")
	@ObfuscatedGetter(
		intValue = 974279119
	)
	static int field705;
	@ObfuscatedName("hg")
	@ObfuscatedGetter(
		intValue = -1114899617
	)
	static int field706;
	@ObfuscatedName("ha")
	@ObfuscatedGetter(
		intValue = 1195340625
	)
	static int field707;
	@ObfuscatedName("hn")
	@ObfuscatedGetter(
		intValue = -870518941
	)
	static int field708;
	@ObfuscatedName("hm")
	static boolean field908;
	@ObfuscatedName("hx")
	@ObfuscatedGetter(
		intValue = 466427237
	)
	@Export("alternativeScrollbarWidth")
	static int alternativeScrollbarWidth;
	@ObfuscatedName("hk")
	@ObfuscatedGetter(
		intValue = -1940558953
	)
	@Export("camAngleX")
	static int camAngleX;
	@ObfuscatedName("ht")
	@ObfuscatedGetter(
		intValue = 2068550151
	)
	@Export("camAngleY")
	static int camAngleY;
	@ObfuscatedName("hw")
	@ObfuscatedGetter(
		intValue = -31256613
	)
	@Export("camAngleDY")
	static int camAngleDY;
	@ObfuscatedName("hy")
	@ObfuscatedGetter(
		intValue = 270383157
	)
	@Export("camAngleDX")
	static int camAngleDX;
	@ObfuscatedName("hu")
	@ObfuscatedGetter(
		intValue = -1361461931
	)
	@Export("mouseCamClickedX")
	static int mouseCamClickedX;
	@ObfuscatedName("hq")
	@ObfuscatedGetter(
		intValue = 30671027
	)
	@Export("mouseCamClickedY")
	static int mouseCamClickedY;
	@ObfuscatedName("hp")
	@ObfuscatedGetter(
		intValue = -1970077779
	)
	@Export("oculusOrbState")
	static int oculusOrbState;
	@ObfuscatedName("hb")
	@ObfuscatedGetter(
		intValue = 467342205
	)
	@Export("camFollowHeight")
	static int camFollowHeight;
	@ObfuscatedName("hi")
	@ObfuscatedGetter(
		intValue = -99029133
	)
	static int field697;
	@ObfuscatedName("hf")
	@ObfuscatedGetter(
		intValue = -1744973303
	)
	static int field720;
	@ObfuscatedName("ic")
	@ObfuscatedGetter(
		intValue = 1224307299
	)
	static int field818;
	@ObfuscatedName("im")
	@ObfuscatedGetter(
		intValue = -2053876137
	)
	@Export("oculusOrbNormalSpeed")
	static int oculusOrbNormalSpeed;
	@ObfuscatedName("if")
	@ObfuscatedGetter(
		intValue = -468814589
	)
	@Export("oculusOrbSlowedSpeed")
	static int oculusOrbSlowedSpeed;
	@ObfuscatedName("ik")
	@ObfuscatedGetter(
		intValue = -1625015947
	)
	static int field748;
	@ObfuscatedName("it")
	@Export("selectedItemName")
	static String selectedItemName;
	@ObfuscatedName("ib")
	static boolean field826;
	@ObfuscatedName("is")
	@ObfuscatedGetter(
		intValue = 965343951
	)
	static int field776;
	@ObfuscatedName("ia")
	static boolean field727;
	@ObfuscatedName("ir")
	@ObfuscatedGetter(
		intValue = -1343425675
	)
	static int field728;
	@ObfuscatedName("ig")
	@ObfuscatedGetter(
		intValue = -277251891
	)
	@Export("overheadTextCount")
	static int overheadTextCount;
	@ObfuscatedName("ie")
	@ObfuscatedGetter(
		intValue = -739487043
	)
	@Export("overheadTextLimit")
	static int overheadTextLimit;
	@ObfuscatedName("iv")
	@Export("overheadTextXs")
	static int[] overheadTextXs;
	@ObfuscatedName("iq")
	@Export("overheadTextYs")
	static int[] overheadTextYs;
	@ObfuscatedName("io")
	@Export("overheadTextAscents")
	static int[] overheadTextAscents;
	@ObfuscatedName("id")
	@Export("overheadTextXOffsets")
	static int[] overheadTextXOffsets;
	@ObfuscatedName("in")
	@Export("overheadTextColors")
	static int[] overheadTextColors;
	@ObfuscatedName("il")
	@Export("overheadTextEffects")
	static int[] overheadTextEffects;
	@ObfuscatedName("iu")
	@Export("overheadTextCyclesRemaining")
	static int[] overheadTextCyclesRemaining;
	@ObfuscatedName("ip")
	@Export("overheadText")
	static String[] overheadText;
	@ObfuscatedName("ih")
	@Export("tileLastDrawnActor")
	static int[][] tileLastDrawnActor;
	@ObfuscatedName("ii")
	@ObfuscatedGetter(
		intValue = 301129667
	)
	@Export("viewportDrawCount")
	static int viewportDrawCount;
	@ObfuscatedName("iy")
	@ObfuscatedGetter(
		intValue = 1117796663
	)
	@Export("viewportTempX")
	static int viewportTempX;
	@ObfuscatedName("iw")
	@ObfuscatedGetter(
		intValue = -1022356229
	)
	@Export("viewportTempY")
	static int viewportTempY;
	@ObfuscatedName("jm")
	@ObfuscatedGetter(
		intValue = 1108408543
	)
	@Export("mouseCrossX")
	static int mouseCrossX;
	@ObfuscatedName("jd")
	@ObfuscatedGetter(
		intValue = 1117092081
	)
	@Export("mouseCrossY")
	static int mouseCrossY;
	@ObfuscatedName("jj")
	@ObfuscatedGetter(
		intValue = 1711302667
	)
	@Export("mouseCrossState")
	static int mouseCrossState;
	@ObfuscatedName("jw")
	@ObfuscatedGetter(
		intValue = -1916688599
	)
	@Export("mouseCrossColor")
	static int mouseCrossColor;
	@ObfuscatedName("jp")
	@Export("showMouseCross")
	static boolean showMouseCross;
	@ObfuscatedName("jy")
	@ObfuscatedGetter(
		intValue = -1524913155
	)
	static int field664;
	@ObfuscatedName("jc")
	@ObfuscatedGetter(
		intValue = 426832895
	)
	static int field749;
	@ObfuscatedName("jo")
	@ObfuscatedGetter(
		intValue = -696084645
	)
	@Export("dragItemSlotSource")
	static int dragItemSlotSource;
	@ObfuscatedName("jl")
	@ObfuscatedGetter(
		intValue = -948734419
	)
	static int field751;
	@ObfuscatedName("js")
	@ObfuscatedGetter(
		intValue = -1639572587
	)
	static int field752;
	@ObfuscatedName("jr")
	@ObfuscatedGetter(
		intValue = 1443949053
	)
	@Export("dragItemSlotDestination")
	static int dragItemSlotDestination;
	@ObfuscatedName("jq")
	static boolean field754;
	@ObfuscatedName("ju")
	@ObfuscatedGetter(
		intValue = -2139000407
	)
	@Export("itemDragDuration")
	static int itemDragDuration;
	@ObfuscatedName("je")
	@ObfuscatedGetter(
		intValue = -832368541
	)
	static int field756;
	@ObfuscatedName("jt")
	@Export("showLoadingMessages")
	static boolean showLoadingMessages;
	@ObfuscatedName("ja")
	@ObfuscatedSignature(
		signature = "[Lbg;"
	)
	@Export("players")
	static Player[] players;
	@ObfuscatedName("jb")
	@ObfuscatedGetter(
		intValue = 241706055
	)
	@Export("localPlayerIndex")
	static int localPlayerIndex;
	@ObfuscatedName("jn")
	@ObfuscatedGetter(
		intValue = 184797301
	)
	static int field789;
	@ObfuscatedName("jf")
	@Export("renderSelf")
	static boolean renderSelf;
	@ObfuscatedName("kw")
	@ObfuscatedGetter(
		intValue = -1334418049
	)
	@Export("drawPlayerNames")
	static int drawPlayerNames;
	@ObfuscatedName("ka")
	@ObfuscatedGetter(
		intValue = -629694105
	)
	static int field814;
	@ObfuscatedName("kf")
	static int[] field764;
	@ObfuscatedName("ky")
	@Export("playerMenuOpcodes")
	static final int[] playerMenuOpcodes;
	@ObfuscatedName("kr")
	@Export("playerMenuActions")
	static String[] playerMenuActions;
	@ObfuscatedName("kk")
	@Export("playerOptionsPriorities")
	static boolean[] playerOptionsPriorities;
	@ObfuscatedName("kp")
	@Export("defaultRotations")
	static int[] defaultRotations;
	@ObfuscatedName("kj")
	@ObfuscatedGetter(
		intValue = -2070989129
	)
	@Export("combatTargetPlayerIndex")
	static int combatTargetPlayerIndex;
	@ObfuscatedName("kg")
	@ObfuscatedSignature(
		signature = "[[[Ljd;"
	)
	@Export("groundItems")
	static NodeDeque[][][] groundItems;
	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("pendingSpawns")
	static NodeDeque pendingSpawns;
	@ObfuscatedName("kv")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("projectiles")
	static NodeDeque projectiles;
	@ObfuscatedName("ko")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("graphicsObjects")
	static NodeDeque graphicsObjects;
	@ObfuscatedName("kq")
	@Export("currentLevels")
	static int[] currentLevels;
	@ObfuscatedName("kn")
	@Export("levels")
	static int[] levels;
	@ObfuscatedName("ki")
	@Export("experience")
	static int[] experience;
	@ObfuscatedName("kb")
	@ObfuscatedGetter(
		intValue = 1619030373
	)
	@Export("leftClickOpensMenu")
	static int leftClickOpensMenu;
	@ObfuscatedName("ke")
	@Export("isMenuOpen")
	static boolean isMenuOpen;
	@ObfuscatedName("lu")
	@ObfuscatedGetter(
		intValue = 1033223389
	)
	@Export("menuOptionsCount")
	static int menuOptionsCount;
	@ObfuscatedName("lq")
	@Export("menuArguments1")
	static int[] menuArguments1;
	@ObfuscatedName("lb")
	@Export("menuArguments2")
	static int[] menuArguments2;
	@ObfuscatedName("ll")
	@Export("menuOpcodes")
	static int[] menuOpcodes;
	@ObfuscatedName("le")
	@Export("menuIdentifiers")
	static int[] menuIdentifiers;
	@ObfuscatedName("lw")
	@Export("menuActions")
	static String[] menuActions;
	@ObfuscatedName("ls")
	@Export("menuTargets")
	static String[] menuTargets;
	@ObfuscatedName("ly")
	@Export("menuShiftClick")
	static boolean[] menuShiftClick;
	@ObfuscatedName("lp")
	@Export("followerOpsLowPriority")
	static boolean followerOpsLowPriority;
	@ObfuscatedName("lm")
	@Export("shiftClickDrop")
	static boolean shiftClickDrop;
	@ObfuscatedName("ln")
	@Export("tapToDrop")
	static boolean tapToDrop;
	@ObfuscatedName("lt")
	@Export("showMouseOverText")
	static boolean showMouseOverText;
	@ObfuscatedName("lf")
	@ObfuscatedGetter(
		intValue = -17398737
	)
	@Export("viewportX")
	static int viewportX;
	@ObfuscatedName("ld")
	@ObfuscatedGetter(
		intValue = 1819623055
	)
	@Export("viewportY")
	static int viewportY;
	@ObfuscatedName("lr")
	@ObfuscatedGetter(
		intValue = -943012111
	)
	static int field643;
	@ObfuscatedName("lo")
	@ObfuscatedGetter(
		intValue = -1168428899
	)
	static int field768;
	@ObfuscatedName("lk")
	@ObfuscatedGetter(
		intValue = 8672977
	)
	@Export("isItemSelected")
	static int isItemSelected;
	@ObfuscatedName("lc")
	@Export("isSpellSelected")
	static boolean isSpellSelected;
	@ObfuscatedName("lg")
	@ObfuscatedGetter(
		intValue = -1752263001
	)
	@Export("selectedSpellChildIndex")
	static int selectedSpellChildIndex;
	@ObfuscatedName("mf")
	@ObfuscatedGetter(
		intValue = -2117287011
	)
	static int field799;
	@ObfuscatedName("mr")
	@Export("selectedSpellActionName")
	static String selectedSpellActionName;
	@ObfuscatedName("mb")
	@Export("selectedSpellName")
	static String selectedSpellName;
	@ObfuscatedName("md")
	@ObfuscatedGetter(
		intValue = 241193399
	)
	@Export("rootInterface")
	static int rootInterface;

	static {
		field831 = true;
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
		field877 = -1;
		field657 = -1;
		field658 = -1L;
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
		field674 = 0;
		js5Errors = 0;
		loginState = 0;
		field887 = 0;
		field678 = 0;
		field694 = 0;
		field680 = class160.field2006;
		Login_isUsernameRemembered = false;
		secureRandomFuture = new SecureRandomFuture();
		randomDatData = null;
		npcs = new NPC[32768];
		npcCount = 0;
		npcIndices = new int[32768];
		field687 = 0;
		field688 = new int[250];
		packetWriter = new PacketWriter();
		logoutTimer = 0;
		field691 = false;
		useBufferedSocket = true;
		timer = new Timer();
		fontsMap = new HashMap();
		field676 = 0;
		field794 = 1;
		field850 = 0;
		field672 = 1;
		field699 = 0;
		collisionMaps = new CollisionMap[4];
		isInInstance = false;
		instanceChunkTemplates = new int[4][13][13];
		field703 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
		field704 = 0;
		field705 = 2301979;
		field706 = 5063219;
		field707 = 3353893;
		field708 = 7759444;
		field908 = false;
		alternativeScrollbarWidth = 0;
		camAngleX = 128;
		camAngleY = 0;
		camAngleDY = 0;
		camAngleDX = 0;
		mouseCamClickedX = 0;
		mouseCamClickedY = 0;
		oculusOrbState = 0;
		camFollowHeight = 50;
		field697 = 0;
		field720 = 0;
		field818 = 0;
		oculusOrbNormalSpeed = 12;
		oculusOrbSlowedSpeed = 6;
		field748 = 0;
		field826 = false;
		field776 = 0;
		field727 = false;
		field728 = 0;
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
		field664 = 0;
		field749 = 0;
		dragItemSlotSource = 0;
		field751 = 0;
		field752 = 0;
		dragItemSlotDestination = 0;
		field754 = false;
		itemDragDuration = 0;
		field756 = 0;
		showLoadingMessages = true;
		players = new Player[2048];
		localPlayerIndex = -1;
		field789 = 0;
		renderSelf = true;
		drawPlayerNames = 0;
		field814 = 0;
		field764 = new int[1000];
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
		field643 = 0;
		field768 = 50;
		isItemSelected = 0;
		selectedItemName = null;
		isSpellSelected = false;
		selectedSpellChildIndex = -1;
		field799 = -1;
		selectedSpellActionName = null;
		selectedSpellName = null;
		rootInterface = -1;
		interfaceParents = new NodeHashTable(8);
		field804 = 0;
		field805 = -1;
		chatEffects = 0;
		field807 = 0;
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
		field820 = false;
		field698 = -1;
		field822 = -1;
		field823 = false;
		field808 = -1;
		field825 = -1;
		isDraggingWidget = false;
		cycleCntr = 1;
		field828 = new int[32];
		field829 = 0;
		changedItemContainers = new int[32];
		field898 = 0;
		changedSkills = new int[32];
		changedSkillsCount = 0;
		chatCycle = 0;
		field833 = 0;
		field836 = 0;
		field645 = 0;
		field734 = 0;
		field834 = 0;
		mouseWheelRotation = 0;
		scriptEvents = new NodeDeque();
		field900 = new NodeDeque();
		field843 = new NodeDeque();
		widgetClickMasks = new NodeHashTable(512);
		rootWidgetCount = 0;
		field690 = -2;
		field847 = new boolean[100];
		field837 = new boolean[100];
		field849 = new boolean[100];
		rootWidgetXs = new int[100];
		rootWidgetYs = new int[100];
		rootWidgetWidths = new int[100];
		rootWidgetHeights = new int[100];
		gameDrawingMode = 0;
		field652 = 0L;
		isResizable = true;
		field857 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
		publicChatMode = 0;
		tradeChatMode = 0;
		field860 = "";
		field861 = new long[100];
		field855 = 0;
		field889 = 0;
		field864 = new int[128];
		field865 = new int[128];
		field866 = -1L;
		field867 = -1;
		mapIconCount = 0;
		mapIconXs = new int[1000];
		mapIconYs = new int[1000];
		mapIcons = new Sprite[1000];
		destinationX = 0;
		destinationY = 0;
		minimapState = 0;
		musicVolume = 255;
		currentTrackGroupId = -1;
		field742 = false;
		soundEffectVolume = 127;
		areaSoundEffectVolume = 127;
		soundEffectCount = 0;
		soundEffectIds = new int[50];
		queuedSoundEffectLoops = new int[50];
		queuedSoundEffectDelays = new int[50];
		soundLocations = new int[50];
		soundEffects = new SoundEffect[50];
		isCameraLocked = false;
		field835 = new boolean[5];
		field736 = new int[5];
		field901 = new int[5];
		field890 = new int[5];
		field891 = new int[5];
		field880 = 256;
		field893 = 205;
		zoomHeight = 256;
		zoomWidth = 320;
		field896 = 1;
		field897 = 32767;
		field785 = 1;
		field679 = 32767;
		viewportOffsetX = 0;
		viewportOffsetY = 0;
		viewportWidth = 0;
		viewportHeight = 0;
		viewportZoom = 0;
		playerAppearance = new PlayerAppearance();
		field906 = -1;
		field907 = -1;
		platformInfoProvider = new DesktopPlatformInfoProvider();
		grandExchangeOffers = new GrandExchangeOffer[8];
		GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
		field863 = -1;
		archiveLoaders = new ArrayList(10);
		archiveLoadersDone = 0;
		field914 = 0;
		field915 = new class65();
		field916 = new int[50];
		field862 = new int[50];
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1452127908"
	)
	@Export("resizeGame")
	protected final void resizeGame() {
		field652 = TaskHandler.currentTimeMillis() + 500L;
		this.resizeJS();
		if (rootInterface != -1) {
			this.resizeRoot(true);
		}

	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "81"
	)
	@Export("setUp")
	protected final void setUp() {
		class286.method5353(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
		SecureRandomCallable.port1 = gameBuild == 0 ? 43594 : worldId + 40000;
		class49.port2 = gameBuild == 0 ? 443 : worldId + 50000;
		WorldMapIcon_0.port3 = SecureRandomCallable.port1;
		PlayerAppearance.field2548 = class215.field2553;
		ArchiveLoader.field533 = class215.field2554;
		PlayerAppearance.field2542 = class215.field2555;
		TileItemPile.field1537 = class215.field2556;
		SpriteMask.urlRequester = new UrlRequester();
		this.setUpKeyboard();
		this.setUpMouse();
		ItemContainer.mouseWheel = this.mouseWheel();
		class30.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		UserComparator10.clientPreferences = WorldMapArea.method422();
		this.setUpClipboard();
		String var2 = Players.null_string;
		class51.applet = this;
		if (var2 != null) {
			class51.field424 = var2;
		}

		if (gameBuild != 0) {
			displayFps = true;
		}

		MouseHandler.setWindowedMode(UserComparator10.clientPreferences.windowMode);
		VertexNormal.friendSystem = new FriendSystem(WorldMapLabelSize.loginType);
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "776219916"
	)
	@Export("doCycle")
	protected final void doCycle() {
		++cycle;
		this.doCycleJs5();
		NetCache.method4399();
		ScriptEvent.method1198();
		Tiles.playPcmPlayers();
		synchronized(KeyHandler.KeyHandler_instance) {
			++KeyHandler.KeyHandler_idleCycles;
			KeyHandler.field399 = KeyHandler.field384;
			KeyHandler.field398 = 0;
			int var2;
			if (KeyHandler.field397 >= 0) {
				while (KeyHandler.field393 != KeyHandler.field397) {
					var2 = KeyHandler.field394[KeyHandler.field393];
					KeyHandler.field393 = KeyHandler.field393 + 1 & 127;
					if (var2 < 0) {
						KeyHandler.KeyHandler_pressedKeys[~var2] = false;
					} else {
						if (!KeyHandler.KeyHandler_pressedKeys[var2] && KeyHandler.field398 < KeyHandler.field378.length - 1) {
							KeyHandler.field378[++KeyHandler.field398 - 1] = var2;
						}

						KeyHandler.KeyHandler_pressedKeys[var2] = true;
					}
				}
			} else {
				for (var2 = 0; var2 < 112; ++var2) {
					KeyHandler.KeyHandler_pressedKeys[var2] = false;
				}

				KeyHandler.field397 = KeyHandler.field393;
			}

			if (KeyHandler.field398 > 0) {
				KeyHandler.KeyHandler_idleCycles = 0;
			}

			KeyHandler.field384 = KeyHandler.field400;
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

		int var5;
		if (ItemContainer.mouseWheel != null) {
			var5 = ItemContainer.mouseWheel.useRotation();
			mouseWheelRotation = var5;
		}

		if (gameState == 0) {
			GrandExchangeOfferOwnWorldComparator.load();
			BuddyRankComparator.clock.mark();

			for (var5 = 0; var5 < 32; ++var5) {
				GameShell.graphicsTickTimes[var5] = 0L;
			}

			for (var5 = 0; var5 < 32; ++var5) {
				GameShell.clientTickTimes[var5] = 0L;
			}

			GameShell.gameCyclesToDo = 0;
		} else if (gameState == 5) {
			ObjectDefinition.doCycleTitle(this);
			GrandExchangeOfferOwnWorldComparator.load();
			BuddyRankComparator.clock.mark();

			for (var5 = 0; var5 < 32; ++var5) {
				GameShell.graphicsTickTimes[var5] = 0L;
			}

			for (var5 = 0; var5 < 32; ++var5) {
				GameShell.clientTickTimes[var5] = 0L;
			}

			GameShell.gameCyclesToDo = 0;
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				ObjectDefinition.doCycleTitle(this);
				this.doCycleLoggedOut();
			} else if (gameState == 25) {
				class267.method5068();
			}
		} else {
			ObjectDefinition.doCycleTitle(this);
		}

		if (gameState == 30) {
			this.doCycleLoggedIn();
		} else if (gameState == 40 || gameState == 45) {
			this.doCycleLoggedOut();
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "-24"
	)
	@Export("draw")
	protected final void draw(boolean var1) {
		boolean var2;
		label171: {
			try {
				if (class197.field2411 == 2) {
					if (WorldMapSprite.musicTrack == null) {
						WorldMapSprite.musicTrack = MusicTrack.readTrack(class197.musicTrackArchive, UrlRequester.musicTrackGroupId, UserComparator7.musicTrackFileId);
						if (WorldMapSprite.musicTrack == null) {
							var2 = false;
							break label171;
						}
					}

					if (NPC.soundCache == null) {
						NPC.soundCache = new SoundCache(class197.soundEffectsArchive, class197.musicSamplesArchive);
					}

					if (FaceNormal.midiPcmStream.loadMusicTrack(WorldMapSprite.musicTrack, class197.musicPatchesArchive, NPC.soundCache, 22050)) {
						FaceNormal.midiPcmStream.clearAll();
						FaceNormal.midiPcmStream.setPcmStreamVolume(class197.musicTrackVolume);
						FaceNormal.midiPcmStream.setMusicTrack(WorldMapSprite.musicTrack, ArchiveLoader.musicTrackBoolean);
						class197.field2411 = 0;
						WorldMapSprite.musicTrack = null;
						NPC.soundCache = null;
						class197.musicTrackArchive = null;
						var2 = true;
						break label171;
					}
				}
			} catch (Exception var6) {
				var6.printStackTrace();
				FaceNormal.midiPcmStream.clear();
				class197.field2411 = 0;
				WorldMapSprite.musicTrack = null;
				NPC.soundCache = null;
				class197.musicTrackArchive = null;
			}

			var2 = false;
		}

		if (var2 && field742 && MenuAction.pcmPlayer0 != null) {
			MenuAction.pcmPlayer0.tryDiscard();
		}

		if ((gameState == 10 || gameState == 20 || gameState == 30) && field652 != 0L && TaskHandler.currentTimeMillis() > field652) {
			MouseHandler.setWindowedMode(class43.getWindowedMode());
		}

		int var4;
		if (var1) {
			for (var4 = 0; var4 < 100; ++var4) {
				field847[var4] = true;
			}
		}

		if (gameState == 0) {
			this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
		} else if (gameState == 5) {
			ClientPacket.drawTitle(JagexCache.fontBold12, AttackOption.fontPlain11, Player.fontPlain12);
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				ClientPacket.drawTitle(JagexCache.fontBold12, AttackOption.fontPlain11, Player.fontPlain12);
			} else if (gameState == 25) {
				if (field699 == 1) {
					if (field676 > field794) {
						field794 = field676;
					}

					var4 = (field794 * 50 - field676 * 50) / field794;
					WorldMapIcon_1.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
				} else if (field699 == 2) {
					if (field850 > field672) {
						field672 = field850;
					}

					var4 = (field672 * 50 - field850 * 50) / field672 + 50;
					WorldMapIcon_1.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
				} else {
					WorldMapIcon_1.drawLoadingMessage("Loading - please wait.", false);
				}
			} else if (gameState == 30) {
				this.drawLoggedIn();
			} else if (gameState == 40) {
				WorldMapIcon_1.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
			} else if (gameState == 45) {
				WorldMapIcon_1.drawLoadingMessage("Please wait...", false);
			}
		} else {
			ClientPacket.drawTitle(JagexCache.fontBold12, AttackOption.fontPlain11, Player.fontPlain12);
		}

		if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
			for (var4 = 0; var4 < rootWidgetCount; ++var4) {
				if (field837[var4]) {
					DirectByteArrayCopier.rasterProvider.draw(rootWidgetXs[var4], rootWidgetYs[var4], rootWidgetWidths[var4], rootWidgetHeights[var4]);
					field837[var4] = false;
				}
			}
		} else if (gameState > 0) {
			DirectByteArrayCopier.rasterProvider.drawFull(0, 0);

			for (var4 = 0; var4 < rootWidgetCount; ++var4) {
				field837[var4] = false;
			}
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-105"
	)
	@Export("kill0")
	protected final void kill0() {
		if (AttackOption.varcs.hasUnwrittenChanges()) {
			AttackOption.varcs.write();
		}

		if (class2.mouseRecorder != null) {
			class2.mouseRecorder.isRunning = false;
		}

		class2.mouseRecorder = null;
		packetWriter.close();
		MusicPatchNode2.method3750();
		SpriteMask.method4040();
		ItemContainer.mouseWheel = null;
		if (MenuAction.pcmPlayer0 != null) {
			MenuAction.pcmPlayer0.shutdown();
		}

		if (class60.pcmPlayer1 != null) {
			class60.pcmPlayer1.shutdown();
		}

		GameShell.method1074();
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3155 != 0) {
				ArchiveDiskActionHandler.field3155 = 1;

				try {
					ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock.wait();
				} catch (InterruptedException var4) {
				}
			}
		}

		if (SpriteMask.urlRequester != null) {
			SpriteMask.urlRequester.close();
			SpriteMask.urlRequester = null;
		}

		Login.method2125();
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1314130629"
	)
	protected final void vmethod1301() {
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
							var4 = Integer.parseInt(var2);
							Language var43;
							if (var4 >= 0 && var4 < Language.Language_valuesOrdered.length) {
								var43 = Language.Language_valuesOrdered[var4];
							} else {
								var43 = null;
							}

							VarbitDefinition.clientLanguage = var43;
							break;
						case 7:
							var4 = Integer.parseInt(var2);
							ServerBuild[] var5 = WorldMapSection0.method245();
							var6 = 0;

							ServerBuild var3;
							while (true) {
								if (var6 >= var5.length) {
									var3 = null;
									break;
								}

								ServerBuild var7 = var5[var6];
								if (var4 == var7.field3109) {
									var3 = var7;
									break;
								}

								++var6;
							}

							class40.field352 = var3;
							break;
						case 8:
							if (var2.equalsIgnoreCase("true")) {
							}
							break;
						case 9:
							WorldMapManager.field327 = var2;
							break;
						case 10:
							UserComparator8.field1973 = (StudioGame)CollisionMap.findEnumerated(WorldMapAreaData.method709(), Integer.parseInt(var2));
							if (UserComparator8.field1973 == StudioGame.oldscape) {
								WorldMapLabelSize.loginType = LoginType.oldscape;
							} else {
								WorldMapLabelSize.loginType = LoginType.field4031;
							}
							break;
						case 12:
							worldId = Integer.parseInt(var2);
							break;
						case 14:
							class13.field91 = Integer.parseInt(var2);
							break;
						case 15:
							gameBuild = Integer.parseInt(var2);
							break;
						case 17:
							WallDecoration.field1914 = var2;
						}
					}
				}

				class1.method15();
				Canvas.worldHost = this.getCodeBase().getHost();
				String var17 = class40.field352.name;
				byte var18 = 0;

				try {
					JagexCache.idxCount = 21;
					PendingSpawn.cacheGamebuild = var18;

					try {
						UrlRequest.field1947 = System.getProperty("os.name");
					} catch (Exception var37) {
						UrlRequest.field1947 = "Unknown";
					}

					WorldMapIcon_0.field131 = UrlRequest.field1947.toLowerCase();

					try {
						JagexCache.userHomeDirectory = System.getProperty("user.home");
						if (JagexCache.userHomeDirectory != null) {
							JagexCache.userHomeDirectory = JagexCache.userHomeDirectory + "/";
						}
					} catch (Exception var36) {
					}

					try {
						if (WorldMapIcon_0.field131.startsWith("win")) {
							if (JagexCache.userHomeDirectory == null) {
								JagexCache.userHomeDirectory = System.getenv("USERPROFILE");
							}
						} else if (JagexCache.userHomeDirectory == null) {
							JagexCache.userHomeDirectory = System.getenv("HOME");
						}

						if (JagexCache.userHomeDirectory != null) {
							JagexCache.userHomeDirectory = JagexCache.userHomeDirectory + "/";
						}
					} catch (Exception var35) {
					}

					if (JagexCache.userHomeDirectory == null) {
						JagexCache.userHomeDirectory = "~/";
					}

					JagexCache.field2046 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", JagexCache.userHomeDirectory, "/tmp/", ""};
					Ignored.field3610 = new String[]{".jagex_cache_" + PendingSpawn.cacheGamebuild, ".file_store_" + PendingSpawn.cacheGamebuild};
					int var19 = 0;

					File var27;
					label338:
					while (var19 < 4) {
						String var45 = var19 == 0 ? "" : "" + var19;
						JagexCache.JagexCache_locationFile = new File(JagexCache.userHomeDirectory, "jagex_cl_oldschool_" + var17 + var45 + ".dat");
						String var20 = null;
						String var48 = null;
						boolean var8 = false;
						Buffer var10;
						int var11;
						int var13;
						File var51;
						if (JagexCache.JagexCache_locationFile.exists()) {
							try {
								AccessFile var9 = new AccessFile(JagexCache.JagexCache_locationFile, "rw", 10000L);

								for (var10 = new Buffer((int)var9.length()); var10.offset < var10.array.length; var10.offset += var11) {
									var11 = var9.read(var10.array, var10.offset, var10.array.length - var10.offset);
									if (var11 == -1) {
										throw new IOException();
									}
								}

								var10.offset = 0;
								var11 = var10.readUnsignedByte();
								if (var11 < 1 || var11 > 3) {
									throw new IOException("" + var11);
								}

								int var12 = 0;
								if (var11 > 1) {
									var12 = var10.readUnsignedByte();
								}

								if (var11 <= 2) {
									var20 = var10.readStringCp1252NullCircumfixed();
									if (var12 == 1) {
										var48 = var10.readStringCp1252NullCircumfixed();
									}
								} else {
									var20 = var10.readCESU8();
									if (var12 == 1) {
										var48 = var10.readCESU8();
									}
								}

								var9.close();
							} catch (IOException var40) {
								var40.printStackTrace();
							}

							if (var20 != null) {
								var51 = new File(var20);
								if (!var51.exists()) {
									var20 = null;
								}
							}

							if (var20 != null) {
								var51 = new File(var20, "test.dat");

								boolean var52;
								try {
									RandomAccessFile var21 = new RandomAccessFile(var51, "rw");
									var13 = var21.read();
									var21.seek(0L);
									var21.write(var13);
									var21.seek(0L);
									var21.close();
									var51.delete();
									var52 = true;
								} catch (Exception var34) {
									var52 = false;
								}

								if (!var52) {
									var20 = null;
								}
							}
						}

						if (var20 == null && var19 == 0) {
							label313:
							for (int var22 = 0; var22 < Ignored.field3610.length; ++var22) {
								for (int var23 = 0; var23 < JagexCache.field2046.length; ++var23) {
									File var24 = new File(JagexCache.field2046[var23] + Ignored.field3610[var22] + File.separatorChar + "oldschool" + File.separatorChar);
									if (var24.exists()) {
										File var25 = new File(var24, "test.dat");

										boolean var54;
										try {
											RandomAccessFile var14 = new RandomAccessFile(var25, "rw");
											int var15 = var14.read();
											var14.seek(0L);
											var14.write(var15);
											var14.seek(0L);
											var14.close();
											var25.delete();
											var54 = true;
										} catch (Exception var33) {
											var54 = false;
										}

										if (var54) {
											var20 = var24.toString();
											var8 = true;
											break label313;
										}
									}
								}
							}
						}

						if (var20 == null) {
							var20 = JagexCache.userHomeDirectory + File.separatorChar + "jagexcache" + var45 + File.separatorChar + "oldschool" + File.separatorChar + var17 + File.separatorChar;
							var8 = true;
						}

						File var50;
						if (var48 != null) {
							var50 = new File(var48);
							var51 = new File(var20);

							try {
								File[] var59 = var50.listFiles();
								File[] var56 = var59;

								for (var13 = 0; var13 < var56.length; ++var13) {
									File var55 = var56[var13];
									File var26 = new File(var51, var55.getName());
									boolean var16 = var55.renameTo(var26);
									if (!var16) {
										throw new IOException();
									}
								}
							} catch (Exception var39) {
								var39.printStackTrace();
							}

							var8 = true;
						}

						if (var8) {
							var50 = new File(var20);
							var10 = null;

							try {
								AccessFile var60 = new AccessFile(JagexCache.JagexCache_locationFile, "rw", 10000L);
								Buffer var57 = new Buffer(500);
								var57.writeByte(3);
								var57.writeByte(var10 != null ? 1 : 0);
								var57.writeCESU8(var50.getPath());
								if (var10 != null) {
									var57.writeCESU8("");
								}

								var60.write(var57.array, 0, var57.offset);
								var60.close();
							} catch (IOException var32) {
								var32.printStackTrace();
							}
						}

						var27 = new File(var20);
						UserComparator2.cacheDir = var27;
						if (!UserComparator2.cacheDir.exists()) {
							UserComparator2.cacheDir.mkdirs();
						}

						File[] var46 = UserComparator2.cacheDir.listFiles();
						if (var46 != null) {
							File[] var61 = var46;

							for (int var28 = 0; var28 < var61.length; ++var28) {
								File var29 = var61[var28];

								boolean var58;
								try {
									RandomAccessFile var53 = new RandomAccessFile(var29, "rw");
									var11 = var53.read();
									var53.seek(0L);
									var53.write(var11);
									var53.seek(0L);
									var53.close();
									var58 = true;
								} catch (Exception var31) {
									var58 = false;
								}

								if (!var58) {
									++var19;
									continue label338;
								}
							}
						}
						break;
					}

					File var44 = UserComparator2.cacheDir;
					FileSystem.FileSystem_cacheDir = var44;
					if (!FileSystem.FileSystem_cacheDir.exists()) {
						throw new RuntimeException("");
					}

					FileSystem.FileSystem_hasPermissions = true;

					try {
						var27 = new File(JagexCache.userHomeDirectory, "random.dat");
						if (var27.exists()) {
							JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var27, "rw", 25L), 24, 0);
						} else {
							label260:
							for (int var30 = 0; var30 < Ignored.field3610.length; ++var30) {
								for (var6 = 0; var6 < JagexCache.field2046.length; ++var6) {
									File var49 = new File(JagexCache.field2046[var6] + Ignored.field3610[var30] + File.separatorChar + "random.dat");
									if (var49.exists()) {
										JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var49, "rw", 25L), 24, 0);
										break label260;
									}
								}
							}
						}

						if (JagexCache.JagexCache_randomDat == null) {
							RandomAccessFile var47 = new RandomAccessFile(var27, "rw");
							var6 = var47.read();
							var47.seek(0L);
							var47.write(var6);
							var47.seek(0L);
							var47.close();
							JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var27, "rw", 25L), 24, 0);
						}
					} catch (IOException var38) {
					}

					JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(ScriptFrame.getFile("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
					JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(ScriptFrame.getFile("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
					WorldMapSection1.JagexCache_idxFiles = new BufferedFile[JagexCache.idxCount];

					for (var4 = 0; var4 < JagexCache.idxCount; ++var4) {
						WorldMapSection1.JagexCache_idxFiles[var4] = new BufferedFile(new AccessFile(ScriptFrame.getFile("main_file_cache.idx" + var4), "rw", 1048576L), 6000, 0);
					}
				} catch (Exception var41) {
					Calendar.RunException_sendStackTrace((String)null, var41);
				}

				AbstractWorldMapIcon.client = this;
				RunException.clientType = clientType;
				this.startThread(765, 503, 186);
			}
		} catch (RuntimeException var42) {
			throw class219.newRunException(var42, "client.init(" + ')');
		}
	}

	@ObfuscatedName("ei")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-104"
	)
	@Export("doCycleJs5")
	void doCycleJs5() {
		if (gameState != 1000) {
			boolean var1 = class30.method565();
			if (!var1) {
				this.doCycleJs5Connect();
			}

		}
	}

	@ObfuscatedName("en")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2127628124"
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

				field674 = 3000;
				NetCache.NetCache_ioExceptions = 3;
			}

			if (--field674 + 1 <= 0) {
				try {
					if (js5ConnectState == 0) {
						KeyHandler.js5SocketTask = GameShell.taskHandler.newSocketTask(Canvas.worldHost, WorldMapIcon_0.port3);
						++js5ConnectState;
					}

					if (js5ConnectState == 1) {
						if (KeyHandler.js5SocketTask.status == 2) {
							this.js5Error(-1);
							return;
						}

						if (KeyHandler.js5SocketTask.status == 1) {
							++js5ConnectState;
						}
					}

					if (js5ConnectState == 2) {
						if (useBufferedSocket) {
							Interpreter.js5Socket = WorldMapEvent.method783((Socket)KeyHandler.js5SocketTask.result, 40000, 5000);
						} else {
							Interpreter.js5Socket = new NetSocket((Socket)KeyHandler.js5SocketTask.result, GameShell.taskHandler, 5000);
						}

						Buffer var1 = new Buffer(5);
						var1.writeByte(15);
						var1.writeInt(186);
						Interpreter.js5Socket.write(var1.array, 0, 5);
						++js5ConnectState;
						Varps.field2533 = TaskHandler.currentTimeMillis();
					}

					if (js5ConnectState == 3) {
						if (Interpreter.js5Socket.available() > 0 || !useBufferedSocket && gameState <= 5) {
							int var2 = Interpreter.js5Socket.readUnsignedByte();
							if (var2 != 0) {
								this.js5Error(var2);
								return;
							}

							++js5ConnectState;
						} else if (TaskHandler.currentTimeMillis() - Varps.field2533 > 30000L) {
							this.js5Error(-2);
							return;
						}
					}

					if (js5ConnectState == 4) {
						UserComparator9.method3436(Interpreter.js5Socket, gameState > 20);
						KeyHandler.js5SocketTask = null;
						Interpreter.js5Socket = null;
						js5ConnectState = 0;
						js5Errors = 0;
					}
				} catch (IOException var3) {
					this.js5Error(-3);
				}

			}
		}
	}

	@ObfuscatedName("eb")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "297233490"
	)
	@Export("js5Error")
	void js5Error(int var1) {
		KeyHandler.js5SocketTask = null;
		Interpreter.js5Socket = null;
		js5ConnectState = 0;
		if (WorldMapIcon_0.port3 == SecureRandomCallable.port1) {
			WorldMapIcon_0.port3 = class49.port2;
		} else {
			WorldMapIcon_0.port3 = SecureRandomCallable.port1;
		}

		++js5Errors;
		if (js5Errors >= 2 && (var1 == 7 || var1 == 9)) {
			if (gameState <= 5) {
				this.error("js5connect_full");
				gameState = 1000;
			} else {
				field674 = 3000;
			}
		} else if (js5Errors >= 2 && var1 == 6) {
			this.error("js5connect_outofdate");
			gameState = 1000;
		} else if (js5Errors >= 4) {
			if (gameState <= 5) {
				this.error("js5connect");
				gameState = 1000;
			} else {
				field674 = 3000;
			}
		}

	}

	@ObfuscatedName("fx")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2112641787"
	)
	@Export("doCycleLoggedOut")
	final void doCycleLoggedOut() {
		Object var1 = packetWriter.getSocket();
		PacketBuffer var2 = packetWriter.packetBuffer;

		try {
			if (loginState == 0) {
				if (class51.secureRandom == null && (secureRandomFuture.isDone() || field887 > 250)) {
					class51.secureRandom = secureRandomFuture.get();
					secureRandomFuture.shutdown();
					secureRandomFuture = null;
				}

				if (class51.secureRandom != null) {
					if (var1 != null) {
						((AbstractSocket)var1).close();
						var1 = null;
					}

					SecureRandomFuture.socketTask = null;
					field691 = false;
					field887 = 0;
					loginState = 1;
				}
			}

			if (loginState == 1) {
				if (SecureRandomFuture.socketTask == null) {
					SecureRandomFuture.socketTask = GameShell.taskHandler.newSocketTask(Canvas.worldHost, WorldMapIcon_0.port3);
				}

				if (SecureRandomFuture.socketTask.status == 2) {
					throw new IOException();
				}

				if (SecureRandomFuture.socketTask.status == 1) {
					if (useBufferedSocket) {
						var1 = WorldMapEvent.method783((Socket)SecureRandomFuture.socketTask.result, 40000, 5000);
					} else {
						var1 = new NetSocket((Socket)SecureRandomFuture.socketTask.result, GameShell.taskHandler, 5000);
					}

					packetWriter.setSocket((AbstractSocket)var1);
					SecureRandomFuture.socketTask = null;
					loginState = 2;
				}
			}

			PacketBufferNode var3;
			if (loginState == 2) {
				packetWriter.clearBuffer();
				var3 = Varcs.method2221();
				var3.packetBuffer.writeByte(LoginPacket.field2324.id);
				packetWriter.addNode(var3);
				packetWriter.flush();
				var2.offset = 0;
				loginState = 3;
			}

			int var4;
			boolean var12;
			if (loginState == 3) {
				if (MenuAction.pcmPlayer0 != null) {
					MenuAction.pcmPlayer0.method2458();
				}

				if (class60.pcmPlayer1 != null) {
					class60.pcmPlayer1.method2458();
				}

				var12 = true;
				if (useBufferedSocket && !((AbstractSocket)var1).isAvailable(1)) {
					var12 = false;
				}

				if (var12) {
					var4 = ((AbstractSocket)var1).readUnsignedByte();
					if (MenuAction.pcmPlayer0 != null) {
						MenuAction.pcmPlayer0.method2458();
					}

					if (class60.pcmPlayer1 != null) {
						class60.pcmPlayer1.method2458();
					}

					if (var4 != 0) {
						class162.getLoginError(var4);
						return;
					}

					var2.offset = 0;
					loginState = 4;
				}
			}

			int var31;
			if (loginState == 4) {
				if (var2.offset < 8) {
					var31 = ((AbstractSocket)var1).available();
					if (var31 > 8 - var2.offset) {
						var31 = 8 - var2.offset;
					}

					if (var31 > 0) {
						((AbstractSocket)var1).read(var2.array, var2.offset, var31);
						var2.offset += var31;
					}
				}

				if (var2.offset == 8) {
					var2.offset = 0;
					RouteStrategy.field2110 = var2.readLong();
					loginState = 5;
				}
			}

			int var7;
			int var9;
			int var14;
			if (loginState == 5) {
				packetWriter.packetBuffer.offset = 0;
				packetWriter.clearBuffer();
				PacketBuffer var21 = new PacketBuffer(500);
				int[] var13 = new int[]{class51.secureRandom.nextInt(), class51.secureRandom.nextInt(), class51.secureRandom.nextInt(), class51.secureRandom.nextInt()};
				var21.offset = 0;
				var21.writeByte(1);
				var21.writeInt(var13[0]);
				var21.writeInt(var13[1]);
				var21.writeInt(var13[2]);
				var21.writeInt(var13[3]);
				var21.writeLong(RouteStrategy.field2110);
				int var10;
				if (gameState == 40) {
					var21.writeInt(PlayerAppearance.field2552[0]);
					var21.writeInt(PlayerAppearance.field2552[1]);
					var21.writeInt(PlayerAppearance.field2552[2]);
					var21.writeInt(PlayerAppearance.field2552[3]);
				} else {
					var21.writeByte(field680.rsOrdinal());
					switch(field680.field2007) {
					case 0:
					case 2:
						var21.writeMedium(class192.field2395);
						++var21.offset;
						break;
					case 1:
						LinkedHashMap var6 = UserComparator10.clientPreferences.parameters;
						String var8 = Login.Login_username;
						var9 = var8.length();
						var10 = 0;

						for (int var11 = 0; var11 < var9; ++var11) {
							var10 = (var10 << 5) - var10 + var8.charAt(var11);
						}

						var21.writeInt((Integer)var6.get(var10));
						break;
					case 3:
						var21.offset += 4;
					}

					var21.writeByte(class312.field3814.rsOrdinal());
					var21.writeStringCp1252NullTerminated(Login.Login_password);
				}

				var21.encryptRsa(class83.field1158, class83.field1160);
				PlayerAppearance.field2552 = var13;
				PacketBufferNode var5 = Varcs.method2221();
				var5.packetBuffer.offset = 0;
				if (gameState == 40) {
					var5.packetBuffer.writeByte(LoginPacket.field2328.id);
				} else {
					var5.packetBuffer.writeByte(LoginPacket.field2326.id);
				}

				var5.packetBuffer.writeShort(0);
				var14 = var5.packetBuffer.offset;
				var5.packetBuffer.writeInt(186);
				var5.packetBuffer.writeInt(1);
				var5.packetBuffer.writeByte(clientType);
				var5.packetBuffer.writeBytes(var21.array, 0, var21.offset);
				var7 = var5.packetBuffer.offset;
				var5.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
				var5.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
				var5.packetBuffer.writeShort(BoundaryObject.canvasWidth);
				var5.packetBuffer.writeShort(WorldMapCacheName.canvasHeight);
				GrandExchangeOfferTotalQuantityComparator.method104(var5.packetBuffer);
				var5.packetBuffer.writeStringCp1252NullTerminated(WorldMapManager.field327);
				var5.packetBuffer.writeInt(class13.field91);
				Buffer var29 = new Buffer(NPC.platformInfo.size());
				NPC.platformInfo.write(var29);
				var5.packetBuffer.writeBytes(var29.array, 0, var29.array.length);
				var5.packetBuffer.writeByte(clientType);
				var5.packetBuffer.writeInt(0);
				var5.packetBuffer.writeInt(GrandExchangeOfferAgeComparator.archive0.hash);
				var5.packetBuffer.writeInt(class43.archive1.hash);
				var5.packetBuffer.writeInt(class288.archive2.hash);
				var5.packetBuffer.writeInt(WorldMapID.archive3.hash);
				var5.packetBuffer.writeInt(SpriteMask.archive4.hash);
				var5.packetBuffer.writeInt(DirectByteArrayCopier.archive5.hash);
				var5.packetBuffer.writeInt(AbstractWorldMapData.archive6.hash);
				var5.packetBuffer.writeInt(ClientPacket.archive7.hash);
				var5.packetBuffer.writeInt(WorldMapRegion.archive8.hash);
				var5.packetBuffer.writeInt(class2.archive9.hash);
				var5.packetBuffer.writeInt(class81.archive10.hash);
				var5.packetBuffer.writeInt(ScriptFrame.archive11.hash);
				var5.packetBuffer.writeInt(class267.archive12.hash);
				var5.packetBuffer.writeInt(class269.archive13.hash);
				var5.packetBuffer.writeInt(class162.archive14.hash);
				var5.packetBuffer.writeInt(class210.archive15.hash);
				var5.packetBuffer.writeInt(0);
				var5.packetBuffer.writeInt(AbstractWorldMapIcon.archive17.hash);
				var5.packetBuffer.writeInt(UserComparator9.archive18.hash);
				var5.packetBuffer.writeInt(class13.archive19.hash);
				var5.packetBuffer.writeInt(class60.archive20.hash);
				var5.packetBuffer.xteaEncrypt(var13, var7, var5.packetBuffer.offset);
				var5.packetBuffer.writeLengthShort(var5.packetBuffer.offset - var14);
				packetWriter.addNode(var5);
				packetWriter.flush();
				packetWriter.isaacCipher = new IsaacCipher(var13);
				int[] var15 = new int[4];

				for (var10 = 0; var10 < 4; ++var10) {
					var15[var10] = var13[var10] + 50;
				}

				var2.newIsaacCipher(var15);
				loginState = 6;
			}

			if (loginState == 6 && ((AbstractSocket)var1).available() > 0) {
				var31 = ((AbstractSocket)var1).readUnsignedByte();
				if (var31 == 21 && gameState == 20) {
					loginState = 9;
				} else if (var31 == 2) {
					loginState = 11;
				} else if (var31 == 15 && gameState == 40) {
					packetWriter.serverPacketLength = -1;
					loginState = 16;
				} else if (var31 == 64) {
					loginState = 7;
				} else if (var31 == 23 && field678 < 1) {
					++field678;
					loginState = 0;
				} else {
					if (var31 != 29) {
						class162.getLoginError(var31);
						return;
					}

					loginState = 14;
				}
			}

			if (loginState == 7 && ((AbstractSocket)var1).available() > 0) {
				UrlRequester.field1940 = ((AbstractSocket)var1).readUnsignedByte();
				loginState = 8;
			}

			if (loginState == 8 && ((AbstractSocket)var1).available() >= UrlRequester.field1940) {
				((AbstractSocket)var1).read(var2.array, 0, UrlRequester.field1940);
				var2.offset = 0;
				loginState = 6;
			}

			if (loginState == 9 && ((AbstractSocket)var1).available() > 0) {
				field694 = (((AbstractSocket)var1).readUnsignedByte() + 3) * 60;
				loginState = 10;
			}

			if (loginState == 10) {
				field887 = 0;
				PacketWriter.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field694 / 60 + " seconds.");
				if (--field694 <= 0) {
					loginState = 0;
				}

			} else {
				if (loginState == 11 && ((AbstractSocket)var1).available() >= 1) {
					GrandExchangeOfferNameComparator.field73 = ((AbstractSocket)var1).readUnsignedByte();
					loginState = 12;
				}

				if (loginState == 12 && ((AbstractSocket)var1).available() >= GrandExchangeOfferNameComparator.field73) {
					var12 = ((AbstractSocket)var1).readUnsignedByte() == 1;
					((AbstractSocket)var1).read(var2.array, 0, 4);
					var2.offset = 0;
					boolean var24 = false;
					if (var12) {
						var4 = var2.readByteIsaac() << 24;
						var4 |= var2.readByteIsaac() << 16;
						var4 |= var2.readByteIsaac() << 8;
						var4 |= var2.readByteIsaac();
						String var28 = Login.Login_username;
						var7 = var28.length();
						int var16 = 0;
						var9 = 0;

						while (true) {
							if (var9 >= var7) {
								if (UserComparator10.clientPreferences.parameters.size() >= 10 && !UserComparator10.clientPreferences.parameters.containsKey(var16)) {
									Iterator var30 = UserComparator10.clientPreferences.parameters.entrySet().iterator();
									var30.next();
									var30.remove();
								}

								UserComparator10.clientPreferences.parameters.put(var16, var4);
								break;
							}

							var16 = (var16 << 5) - var16 + var28.charAt(var9);
							++var9;
						}
					}

					if (Login_isUsernameRemembered) {
						UserComparator10.clientPreferences.rememberedUsername = Login.Login_username;
					} else {
						UserComparator10.clientPreferences.rememberedUsername = null;
					}

					class40.savePreferences();
					staffModLevel = ((AbstractSocket)var1).readUnsignedByte();
					playerMod = ((AbstractSocket)var1).readUnsignedByte() == 1;
					localPlayerIndex = ((AbstractSocket)var1).readUnsignedByte();
					localPlayerIndex <<= 8;
					localPlayerIndex += ((AbstractSocket)var1).readUnsignedByte();
					field789 = ((AbstractSocket)var1).readUnsignedByte();
					((AbstractSocket)var1).read(var2.array, 0, 1);
					var2.offset = 0;
					ServerPacket[] var25 = WorldMapLabelSize.ServerPacket_values();
					var14 = var2.readSmartByteShortIsaac();
					if (var14 < 0 || var14 >= var25.length) {
						throw new IOException(var14 + " " + var2.offset);
					}

					packetWriter.serverPacket = var25[var14];
					packetWriter.serverPacketLength = packetWriter.serverPacket.length;
					((AbstractSocket)var1).read(var2.array, 0, 2);
					var2.offset = 0;
					packetWriter.serverPacketLength = var2.readUnsignedShort();

					try {
						class47.method864(AbstractWorldMapIcon.client, "zap");
					} catch (Throwable var19) {
					}

					loginState = 13;
				}

				if (loginState == 13) {
					if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
						timer.method5079();
						mouseLastLastPressedTimeMillis = 1L;
						class2.mouseRecorder.index = 0;
						TextureProvider.hasFocus = true;
						hadFocus = true;
						field866 = -1L;
						ArchiveLoader.method1178();
						packetWriter.clearBuffer();
						packetWriter.packetBuffer.offset = 0;
						packetWriter.serverPacket = null;
						packetWriter.field1299 = null;
						packetWriter.field1311 = null;
						packetWriter.field1312 = null;
						packetWriter.serverPacketLength = 0;
						packetWriter.field1305 = 0;
						rebootTimer = 0;
						logoutTimer = 0;
						hintArrowType = 0;
						RouteStrategy.method3641();
						class4.method56(0);
						AbstractWorldMapIcon.method623();
						isItemSelected = 0;
						isSpellSelected = false;
						soundEffectCount = 0;
						camAngleY = 0;
						oculusOrbState = 0;
						InvDefinition.field3210 = null;
						minimapState = 0;
						field867 = -1;
						destinationX = 0;
						destinationY = 0;
						playerAttackOption = AttackOption.AttackOption_hidden;
						npcAttackOption = AttackOption.AttackOption_hidden;
						npcCount = 0;
						class42.method809();

						for (var31 = 0; var31 < 2048; ++var31) {
							players[var31] = null;
						}

						for (var31 = 0; var31 < 32768; ++var31) {
							npcs[var31] = null;
						}

						combatTargetPlayerIndex = -1;
						projectiles.clear();
						graphicsObjects.clear();

						for (var31 = 0; var31 < 4; ++var31) {
							for (var4 = 0; var4 < 104; ++var4) {
								for (int var17 = 0; var17 < 104; ++var17) {
									groundItems[var31][var4][var17] = null;
								}
							}
						}

						pendingSpawns = new NodeDeque();
						VertexNormal.friendSystem.clear();

						for (var31 = 0; var31 < VarpDefinition.VarpDefinition_fileCount; ++var31) {
							VarpDefinition var34 = NetCache.VarpDefinition_get(var31);
							if (var34 != null) {
								Varps.Varps_temp[var31] = 0;
								Varps.Varps_main[var31] = 0;
							}
						}

						AttackOption.varcs.clearTransient();
						followerIndex = -1;
						if (rootInterface != -1) {
							DynamicObject.method2263(rootInterface);
						}

						for (InterfaceParent var23 = (InterfaceParent)interfaceParents.first(); var23 != null; var23 = (InterfaceParent)interfaceParents.next()) {
							class43.closeInterface(var23, true);
						}

						rootInterface = -1;
						interfaceParents = new NodeHashTable(8);
						meslayerContinueWidget = null;
						RouteStrategy.method3641();
						playerAppearance.update((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

						for (var31 = 0; var31 < 8; ++var31) {
							playerMenuActions[var31] = null;
							playerOptionsPriorities[var31] = false;
						}

						ItemContainer.itemContainers = new NodeHashTable(32);
						isLoading = true;

						for (var31 = 0; var31 < 100; ++var31) {
							field847[var31] = true;
						}

						var3 = ModelData0.getPacketBufferNode(ClientPacket.field2218, packetWriter.isaacCipher);
						var3.packetBuffer.writeByte(class43.getWindowedMode());
						var3.packetBuffer.writeShort(BoundaryObject.canvasWidth);
						var3.packetBuffer.writeShort(WorldMapCacheName.canvasHeight);
						packetWriter.addNode(var3);
						InterfaceParent.clanChat = null;

						for (var31 = 0; var31 < 8; ++var31) {
							grandExchangeOffers[var31] = new GrandExchangeOffer();
						}

						SoundCache.grandExchangeEvents = null;
						UserComparator6.updatePlayer(var2);
						CollisionMap.field2086 = -1;
						WorldMapRegion.loadRegions(false, var2);
						packetWriter.serverPacket = null;
					}

				} else {
					if (loginState == 14 && ((AbstractSocket)var1).available() >= 2) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, 2);
						var2.offset = 0;
						AbstractWorldMapIcon.field292 = var2.readUnsignedShort();
						loginState = 15;
					}

					if (loginState == 15 && ((AbstractSocket)var1).available() >= AbstractWorldMapIcon.field292) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, AbstractWorldMapIcon.field292);
						var2.offset = 0;
						String var22 = var2.readStringCp1252NullTerminated();
						String var32 = var2.readStringCp1252NullTerminated();
						String var26 = var2.readStringCp1252NullTerminated();
						PacketWriter.setLoginResponseString(var22, var32, var26);
						class81.updateGameState(10);
					}

					if (loginState != 16) {
						++field887;
						if (field887 > 2000) {
							if (field678 < 1) {
								if (WorldMapIcon_0.port3 == SecureRandomCallable.port1) {
									WorldMapIcon_0.port3 = class49.port2;
								} else {
									WorldMapIcon_0.port3 = SecureRandomCallable.port1;
								}

								++field678;
								loginState = 0;
							} else {
								class162.getLoginError(-3);
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
							var31 = packetWriter.serverPacketLength;
							timer.method5076();
							packetWriter.clearBuffer();
							packetWriter.packetBuffer.offset = 0;
							packetWriter.serverPacket = null;
							packetWriter.field1299 = null;
							packetWriter.field1311 = null;
							packetWriter.field1312 = null;
							packetWriter.serverPacketLength = 0;
							packetWriter.field1305 = 0;
							rebootTimer = 0;
							RouteStrategy.method3641();
							minimapState = 0;
							destinationX = 0;

							for (var4 = 0; var4 < 2048; ++var4) {
								players[var4] = null;
							}

							class215.localPlayer = null;

							for (var4 = 0; var4 < npcs.length; ++var4) {
								NPC var27 = npcs[var4];
								if (var27 != null) {
									var27.targetIndex = -1;
									var27.false0 = false;
								}
							}

							ItemContainer.itemContainers = new NodeHashTable(32);
							class81.updateGameState(30);

							for (var4 = 0; var4 < 100; ++var4) {
								field847[var4] = true;
							}

							PacketBufferNode var33 = ModelData0.getPacketBufferNode(ClientPacket.field2218, packetWriter.isaacCipher);
							var33.packetBuffer.writeByte(class43.getWindowedMode());
							var33.packetBuffer.writeShort(BoundaryObject.canvasWidth);
							var33.packetBuffer.writeShort(WorldMapCacheName.canvasHeight);
							packetWriter.addNode(var33);
							UserComparator6.updatePlayer(var2);
							if (var31 != var2.offset) {
								throw new RuntimeException();
							}
						}
					}
				}
			}
		} catch (IOException var20) {
			if (field678 < 1) {
				if (SecureRandomCallable.port1 == WorldMapIcon_0.port3) {
					WorldMapIcon_0.port3 = class49.port2;
				} else {
					WorldMapIcon_0.port3 = SecureRandomCallable.port1;
				}

				++field678;
				loginState = 0;
			} else {
				class162.getLoginError(-2);
			}
		}
	}

	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1256997578"
	)
	@Export("doCycleLoggedIn")
	final void doCycleLoggedIn() {
		if (rebootTimer > 1) {
			--rebootTimer;
		}

		if (logoutTimer > 0) {
			--logoutTimer;
		}

		if (field691) {
			field691 = false;
			Projectile.method2137();
		} else {
			if (!isMenuOpen) {
				class2.addCancelMenuEntry();
			}

			for (int var1 = 0; var1 < 100 && this.method1316(packetWriter); ++var1) {
			}

			if (gameState == 30) {
				int var2;
				PacketBufferNode var14;
				while (class43.method820()) {
					var14 = ModelData0.getPacketBufferNode(ClientPacket.field2283, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					var2 = var14.packetBuffer.offset;
					UserComparator10.performReflectionCheck(var14.packetBuffer);
					var14.packetBuffer.writeLengthByte(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
				}

				if (timer.field3581) {
					var14 = ModelData0.getPacketBufferNode(ClientPacket.field2302, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					var2 = var14.packetBuffer.offset;
					timer.write(var14.packetBuffer);
					var14.packetBuffer.writeLengthByte(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
					timer.method5075();
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
				synchronized(class2.mouseRecorder.lock) {
					if (!field831) {
						class2.mouseRecorder.index = 0;
					} else if (MouseHandler.MouseHandler_lastButton != 0 || class2.mouseRecorder.index >= 40) {
						PacketBufferNode var15 = null;
						var3 = 0;
						var4 = 0;
						var5 = 0;
						var6 = 0;

						for (var7 = 0; var7 < class2.mouseRecorder.index && (var15 == null || var15.packetBuffer.offset - var3 < 246); ++var7) {
							var4 = var7;
							var8 = class2.mouseRecorder.ys[var7];
							if (var8 < -1) {
								var8 = -1;
							} else if (var8 > 65534) {
								var8 = 65534;
							}

							var9 = class2.mouseRecorder.xs[var7];
							if (var9 < -1) {
								var9 = -1;
							} else if (var9 > 65534) {
								var9 = 65534;
							}

							if (var9 != field877 || var8 != field657) {
								if (var15 == null) {
									var15 = ModelData0.getPacketBufferNode(ClientPacket.field2221, packetWriter.isaacCipher);
									var15.packetBuffer.writeByte(0);
									var3 = var15.packetBuffer.offset;
									PacketBuffer var10000 = var15.packetBuffer;
									var10000.offset += 2;
									var5 = 0;
									var6 = 0;
								}

								if (field658 != -1L) {
									var10 = var9 - field877;
									var11 = var8 - field657;
									var12 = (int)((class2.mouseRecorder.millis[var7] - field658) / 20L);
									var5 = (int)((long)var5 + (class2.mouseRecorder.millis[var7] - field658) % 20L);
								} else {
									var10 = var9;
									var11 = var8;
									var12 = Integer.MAX_VALUE;
								}

								field877 = var9;
								field657 = var8;
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
								field658 = class2.mouseRecorder.millis[var7];
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

						if (var4 >= class2.mouseRecorder.index) {
							class2.mouseRecorder.index = 0;
						} else {
							MouseRecorder var47 = class2.mouseRecorder;
							var47.index -= var4;
							System.arraycopy(class2.mouseRecorder.xs, var4, class2.mouseRecorder.xs, 0, class2.mouseRecorder.index);
							System.arraycopy(class2.mouseRecorder.ys, var4, class2.mouseRecorder.ys, 0, class2.mouseRecorder.index);
							System.arraycopy(class2.mouseRecorder.millis, var4, class2.mouseRecorder.millis, 0, class2.mouseRecorder.index);
						}
					}
				}

				if (MouseHandler.MouseHandler_lastButton == 1 || !JagexCache.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
					long var16 = (MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis * -1L) / 50L;
					if (var16 > 4095L) {
						var16 = 4095L;
					}

					mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis * -1L;
					var3 = MouseHandler.MouseHandler_lastPressedY;
					if (var3 < 0) {
						var3 = 0;
					} else if (var3 > WorldMapCacheName.canvasHeight) {
						var3 = WorldMapCacheName.canvasHeight;
					}

					var4 = MouseHandler.MouseHandler_lastPressedX;
					if (var4 < 0) {
						var4 = 0;
					} else if (var4 > BoundaryObject.canvasWidth) {
						var4 = BoundaryObject.canvasWidth;
					}

					var5 = (int)var16;
					PacketBufferNode var18 = ModelData0.getPacketBufferNode(ClientPacket.field2224, packetWriter.isaacCipher);
					var18.packetBuffer.writeShort((MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0) + (var5 << 1));
					var18.packetBuffer.writeShort(var4);
					var18.packetBuffer.writeShort(var3);
					packetWriter.addNode(var18);
				}

				if (KeyHandler.field398 > 0) {
					var14 = ModelData0.getPacketBufferNode(ClientPacket.field2281, packetWriter.isaacCipher);
					var14.packetBuffer.writeShort(0);
					var2 = var14.packetBuffer.offset;
					long var19 = TaskHandler.currentTimeMillis();

					for (var5 = 0; var5 < KeyHandler.field398; ++var5) {
						long var21 = var19 - field866;
						if (var21 > 16777215L) {
							var21 = 16777215L;
						}

						field866 = var19;
						var14.packetBuffer.method5627((int)var21);
						var14.packetBuffer.writeIntME(KeyHandler.field378[var5]);
					}

					var14.packetBuffer.writeLengthShort(var14.packetBuffer.offset - var2);
					packetWriter.addNode(var14);
				}

				if (field776 > 0) {
					--field776;
				}

				if (KeyHandler.KeyHandler_pressedKeys[96] || KeyHandler.KeyHandler_pressedKeys[97] || KeyHandler.KeyHandler_pressedKeys[98] || KeyHandler.KeyHandler_pressedKeys[99]) {
					field727 = true;
				}

				if (field727 && field776 <= 0) {
					field776 = 20;
					field727 = false;
					var14 = ModelData0.getPacketBufferNode(ClientPacket.field2295, packetWriter.isaacCipher);
					var14.packetBuffer.writeShortLE(camAngleX);
					var14.packetBuffer.writeShort(camAngleY);
					packetWriter.addNode(var14);
				}

				if (TextureProvider.hasFocus && !hadFocus) {
					hadFocus = true;
					var14 = ModelData0.getPacketBufferNode(ClientPacket.field2309, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(1);
					packetWriter.addNode(var14);
				}

				if (!TextureProvider.hasFocus && hadFocus) {
					hadFocus = false;
					var14 = ModelData0.getPacketBufferNode(ClientPacket.field2309, packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(0);
					packetWriter.addNode(var14);
				}

				if (WorldMapRegion.worldMap != null) {
					WorldMapRegion.worldMap.method6376();
				}

				class222.method4198();
				GrandExchangeOfferNameComparator.method157();
				if (gameState == 30) {
					for (PendingSpawn var35 = (PendingSpawn)pendingSpawns.last(); var35 != null; var35 = (PendingSpawn)pendingSpawns.previous()) {
						if (var35.hitpoints > 0) {
							--var35.hitpoints;
						}

						ObjectDefinition var23;
						boolean var30;
						if (var35.hitpoints == 0) {
							if (var35.objectId >= 0) {
								var3 = var35.objectId;
								var4 = var35.field924;
								var23 = Occluder.getObjectDefinition(var3);
								if (var4 == 11) {
									var4 = 10;
								}

								if (var4 >= 5 && var4 <= 8) {
									var4 = 4;
								}

								var30 = var23.method4691(var4);
								if (!var30) {
									continue;
								}
							}

							Actor.addPendingSpawnToScene(var35.plane, var35.type, var35.x, var35.y, var35.objectId, var35.field929, var35.field924);
							var35.remove();
						} else {
							if (var35.delay > 0) {
								--var35.delay;
							}

							if (var35.delay == 0 && var35.x >= 1 && var35.y >= 1 && var35.x <= 102 && var35.y <= 102) {
								if (var35.id >= 0) {
									var3 = var35.id;
									var4 = var35.field927;
									var23 = Occluder.getObjectDefinition(var3);
									if (var4 == 11) {
										var4 = 10;
									}

									if (var4 >= 5 && var4 <= 8) {
										var4 = 4;
									}

									var30 = var23.method4691(var4);
									if (!var30) {
										continue;
									}
								}

								Actor.addPendingSpawnToScene(var35.plane, var35.type, var35.x, var35.y, var35.id, var35.orientation, var35.field927);
								var35.delay = -1;
								if (var35.objectId == var35.id && var35.objectId == -1) {
									var35.remove();
								} else if (var35.id == var35.objectId && var35.orientation == var35.field929 && var35.field927 == var35.field924) {
									var35.remove();
								}
							}
						}
					}

					class81.method2084();
					++packetWriter.field1305;
					if (packetWriter.field1305 > 750) {
						Projectile.method2137();
					} else {
						class81.method2085();
						GrandExchangeEvents.method83();
						int[] var36 = Players.Players_indices;

						for (var2 = 0; var2 < Players.Players_count; ++var2) {
							Player var24 = players[var36[var2]];
							if (var24 != null && var24.overheadTextCyclesRemaining > 0) {
								--var24.overheadTextCyclesRemaining;
								if (var24.overheadTextCyclesRemaining == 0) {
									var24.overheadText = null;
								}
							}
						}

						for (var2 = 0; var2 < npcCount; ++var2) {
							var3 = npcIndices[var2];
							NPC var25 = npcs[var3];
							if (var25 != null && var25.overheadTextCyclesRemaining > 0) {
								--var25.overheadTextCyclesRemaining;
								if (var25.overheadTextCyclesRemaining == 0) {
									var25.overheadText = null;
								}
							}
						}

						++field704;
						if (mouseCrossColor != 0) {
							mouseCrossState = mouseCrossState * 400 + 20;
							if (mouseCrossState * 400 >= 400) {
								mouseCrossColor = 0;
							}
						}

						if (class51.field432 != null) {
							++field664;
							if (field664 >= 15) {
								ScriptEvent.invalidateWidget(class51.field432);
								class51.field432 = null;
							}
						}

						Widget var37 = class185.mousedOverWidgetIf1;
						Widget var38 = GrandExchangeOfferWorldComparator.field31;
						class185.mousedOverWidgetIf1 = null;
						GrandExchangeOfferWorldComparator.field31 = null;
						draggedOnWidget = null;
						field823 = false;
						field820 = false;
						field889 = 0;

						while (InvDefinition.isKeyDown() && field889 < 128) {
							if (staffModLevel >= 2 && KeyHandler.KeyHandler_pressedKeys[82] && class49.field418 == 66) {
								String var44 = "";

								Message var39;
								for (Iterator var40 = Messages.Messages_hashTable.iterator(); var40.hasNext(); var44 = var44 + var39.sender + ':' + var39.text + '\n') {
									var39 = (Message)var40.next();
								}

								AbstractWorldMapIcon.client.clipboardSetString(var44);
							} else if (oculusOrbState != 1 || class297.field3699 <= 0) {
								field865[field889] = class49.field418;
								field864[field889] = class297.field3699;
								++field889;
							}
						}

						if (WorldMapSection0.method254() && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81] && mouseWheelRotation != 0) {
							var3 = class215.localPlayer.plane - mouseWheelRotation;
							if (var3 < 0) {
								var3 = 0;
							} else if (var3 > 3) {
								var3 = 3;
							}

							if (var3 != class215.localPlayer.plane) {
								Clock.method3555(class215.localPlayer.pathX[0] + class51.baseX * 64, class215.localPlayer.pathY[0] + VarcInt.baseY * 64, var3, false);
							}

							mouseWheelRotation = 0;
						}

						if (rootInterface != -1) {
							Script.updateRootInterface(rootInterface, 0, 0, BoundaryObject.canvasWidth, WorldMapCacheName.canvasHeight, 0, 0);
						}

						++cycleCntr;

						while (true) {
							Widget var41;
							ScriptEvent var42;
							Widget var46;
							do {
								var42 = (ScriptEvent)field900.removeLast();
								if (var42 == null) {
									while (true) {
										do {
											var42 = (ScriptEvent)field843.removeLast();
											if (var42 == null) {
												while (true) {
													do {
														var42 = (ScriptEvent)scriptEvents.removeLast();
														if (var42 == null) {
															this.menu();
															if (WorldMapRegion.worldMap != null) {
																WorldMapRegion.worldMap.method6381(ClientPacket.Client_plane, class51.baseX * 64 + (class215.localPlayer.x >> 7), VarcInt.baseY * 64 + (class215.localPlayer.y >> 7), false);
																WorldMapRegion.worldMap.loadCache();
															}

															if (clickedWidget != null) {
																this.method1503();
															}

															PacketBufferNode var26;
															if (DevicePcmPlayerProvider.dragInventoryWidget != null) {
																ScriptEvent.invalidateWidget(DevicePcmPlayerProvider.dragInventoryWidget);
																++itemDragDuration;
																if (MouseHandler.MouseHandler_currentButton == 0) {
																	if (field754) {
																		if (DevicePcmPlayerProvider.dragInventoryWidget == FloorOverlayDefinition.field3507 && dragItemSlotSource != dragItemSlotDestination) {
																			Widget var45 = DevicePcmPlayerProvider.dragInventoryWidget;
																			byte var33 = 0;
																			if (field807 == 1 && var45.contentType == 206) {
																				var33 = 1;
																			}

																			if (var45.itemIds[dragItemSlotDestination] <= 0) {
																				var33 = 0;
																			}

																			var6 = MenuAction.getWidgetClickMask(var45);
																			boolean var31 = (var6 >> 29 & 1) != 0;
																			if (var31) {
																				var7 = dragItemSlotSource;
																				var8 = dragItemSlotDestination;
																				var45.itemIds[var8] = var45.itemIds[var7];
																				var45.itemQuantities[var8] = var45.itemQuantities[var7];
																				var45.itemIds[var7] = -1;
																				var45.itemQuantities[var7] = 0;
																			} else if (var33 == 1) {
																				var7 = dragItemSlotSource;
																				var8 = dragItemSlotDestination;

																				while (var7 != var8) {
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

																			var26 = ModelData0.getPacketBufferNode(ClientPacket.field2271, packetWriter.isaacCipher);
																			var26.packetBuffer.method5647(DevicePcmPlayerProvider.dragInventoryWidget.id);
																			var26.packetBuffer.writeByte(var33);
																			var26.packetBuffer.writeShortLE(dragItemSlotDestination);
																			var26.packetBuffer.method5636(dragItemSlotSource);
																			packetWriter.addNode(var26);
																		}
																	} else if (this.shouldLeftClickOpenMenu()) {
																		this.openMenu(field751, field752);
																	} else if (menuOptionsCount > 0) {
																		var3 = field751;
																		var4 = field752;
																		Language.method3705(Tiles.tempMenuAction, var3, var4);
																		Tiles.tempMenuAction = null;
																	}

																	field664 = 10;
																	MouseHandler.MouseHandler_lastButton = 0;
																	DevicePcmPlayerProvider.dragInventoryWidget = null;
																} else if (itemDragDuration >= 5 && (MouseHandler.MouseHandler_x > field751 + 5 || MouseHandler.MouseHandler_x < field751 - 5 || MouseHandler.MouseHandler_y > field752 + 5 || MouseHandler.MouseHandler_y < field752 - 5)) {
																	field754 = true;
																}
															}

															if (Scene.method3146()) {
																var3 = Scene.Scene_selectedX;
																var4 = Scene.Scene_selectedY;
																PacketBufferNode var43 = ModelData0.getPacketBufferNode(ClientPacket.field2266, packetWriter.isaacCipher);
																var43.packetBuffer.writeByte(5);
																var43.packetBuffer.method5636(class51.baseX * 64 + var3);
																var43.packetBuffer.method5628(KeyHandler.KeyHandler_pressedKeys[82] ? (KeyHandler.KeyHandler_pressedKeys[81] ? 2 : 1) : 0);
																var43.packetBuffer.method5636(VarcInt.baseY * 64 + var4);
																packetWriter.addNode(var43);
																Scene.method3147();
																mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
																mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
																mouseCrossColor = 1;
																mouseCrossState = 0;
																destinationX = var3;
																destinationY = var4;
															}

															if (var37 != class185.mousedOverWidgetIf1) {
																if (var37 != null) {
																	ScriptEvent.invalidateWidget(var37);
																}

																if (class185.mousedOverWidgetIf1 != null) {
																	ScriptEvent.invalidateWidget(class185.mousedOverWidgetIf1);
																}
															}

															if (var38 != GrandExchangeOfferWorldComparator.field31 && field643 == field768) {
																if (var38 != null) {
																	ScriptEvent.invalidateWidget(var38);
																}

																if (GrandExchangeOfferWorldComparator.field31 != null) {
																	ScriptEvent.invalidateWidget(GrandExchangeOfferWorldComparator.field31);
																}
															}

															if (GrandExchangeOfferWorldComparator.field31 != null) {
																if (field643 < field768) {
																	++field643;
																	if (field768 == field643) {
																		ScriptEvent.invalidateWidget(GrandExchangeOfferWorldComparator.field31);
																	}
																}
															} else if (field643 > 0) {
																--field643;
															}

															if (oculusOrbState == 0) {
																var3 = class215.localPlayer.x;
																var4 = class215.localPlayer.y;
																if (class80.oculusOrbFocalPointX - var3 < -500 || class80.oculusOrbFocalPointX - var3 > 500 || class81.oculusOrbFocalPointY - var4 < -500 || class81.oculusOrbFocalPointY - var4 > 500) {
																	class80.oculusOrbFocalPointX = var3;
																	class81.oculusOrbFocalPointY = var4;
																}

																if (var3 != class80.oculusOrbFocalPointX) {
																	class80.oculusOrbFocalPointX += (var3 - class80.oculusOrbFocalPointX) / 16;
																}

																if (var4 != class81.oculusOrbFocalPointY) {
																	class81.oculusOrbFocalPointY += (var4 - class81.oculusOrbFocalPointY) / 16;
																}

																var5 = class80.oculusOrbFocalPointX >> 7;
																var6 = class81.oculusOrbFocalPointY >> 7;
																var7 = class195.getTileHeight(class80.oculusOrbFocalPointX, class81.oculusOrbFocalPointY, ClientPacket.Client_plane);
																var8 = 0;
																if (var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
																	for (var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
																		for (var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
																			var11 = ClientPacket.Client_plane;
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

																if (var9 > field728) {
																	field728 += (var9 - field728) / 24;
																} else if (var9 < field728) {
																	field728 += (var9 - field728) / 80;
																}

																GrandExchangeOfferAgeComparator.field78 = class195.getTileHeight(class215.localPlayer.x, class215.localPlayer.y, ClientPacket.Client_plane) - camFollowHeight;
															} else if (oculusOrbState == 1) {
																JagexCache.method3539();
																short var32 = -1;
																if (KeyHandler.KeyHandler_pressedKeys[33]) {
																	var32 = 0;
																} else if (KeyHandler.KeyHandler_pressedKeys[49]) {
																	var32 = 1024;
																}

																if (KeyHandler.KeyHandler_pressedKeys[48]) {
																	if (var32 == 0) {
																		var32 = 1792;
																	} else if (var32 == 1024) {
																		var32 = 1280;
																	} else {
																		var32 = 1536;
																	}
																} else if (KeyHandler.KeyHandler_pressedKeys[50]) {
																	if (var32 == 0) {
																		var32 = 256;
																	} else if (var32 == 1024) {
																		var32 = 768;
																	} else {
																		var32 = 512;
																	}
																}

																byte var34 = 0;
																if (KeyHandler.KeyHandler_pressedKeys[35]) {
																	var34 = -1;
																} else if (KeyHandler.KeyHandler_pressedKeys[51]) {
																	var34 = 1;
																}

																var5 = 0;
																if (var32 >= 0 || var34 != 0) {
																	var5 = KeyHandler.KeyHandler_pressedKeys[81] ? oculusOrbSlowedSpeed : oculusOrbNormalSpeed;
																	var5 *= 16;
																	field720 = var32;
																	field818 = var34;
																}

																if (field697 < var5) {
																	field697 += var5 / 8;
																	if (field697 > var5) {
																		field697 = var5;
																	}
																} else if (field697 > var5) {
																	field697 = field697 * 9 / 10;
																}

																if (field697 > 0) {
																	var6 = field697 / 16;
																	if (field720 >= 0) {
																		var3 = field720 - Decimator.cameraYaw & 2047;
																		var7 = Rasterizer3D.Rasterizer3D_sine[var3];
																		var8 = Rasterizer3D.Rasterizer3D_cosine[var3];
																		class80.oculusOrbFocalPointX += var7 * var6 / 65536;
																		class81.oculusOrbFocalPointY += var6 * var8 / 65536;
																	}

																	if (field818 != 0) {
																		GrandExchangeOfferAgeComparator.field78 += var6 * field818;
																		if (GrandExchangeOfferAgeComparator.field78 > 0) {
																			GrandExchangeOfferAgeComparator.field78 = 0;
																		}
																	}
																} else {
																	field720 = -1;
																	field818 = -1;
																}

																if (KeyHandler.KeyHandler_pressedKeys[13]) {
																	WorldMapLabelSize.method208();
																}
															}

															if (MouseHandler.MouseHandler_currentButton == 4 && JagexCache.mouseCam) {
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
																var3 = PendingSpawn.field925 * 128 + 64;
																var4 = GrandExchangeOfferOwnWorldComparator.field639 * 128 + 64;
																var5 = class195.getTileHeight(var3, var4, ClientPacket.Client_plane) - AbstractWorldMapIcon.field299;
																if (class30.cameraX < var3) {
																	class30.cameraX = (var3 - class30.cameraX) * UserComparator3.field1990 / 1000 + class30.cameraX + GameObject.field1933;
																	if (class30.cameraX > var3) {
																		class30.cameraX = var3;
																	}
																}

																if (class30.cameraX > var3) {
																	class30.cameraX -= UserComparator3.field1990 * (class30.cameraX - var3) / 1000 + GameObject.field1933;
																	if (class30.cameraX < var3) {
																		class30.cameraX = var3;
																	}
																}

																if (GameObject.cameraY < var5) {
																	GameObject.cameraY = (var5 - GameObject.cameraY) * UserComparator3.field1990 / 1000 + GameObject.cameraY + GameObject.field1933;
																	if (GameObject.cameraY > var5) {
																		GameObject.cameraY = var5;
																	}
																}

																if (GameObject.cameraY > var5) {
																	GameObject.cameraY -= UserComparator3.field1990 * (GameObject.cameraY - var5) / 1000 + GameObject.field1933;
																	if (GameObject.cameraY < var5) {
																		GameObject.cameraY = var5;
																	}
																}

																if (FloorDecoration.cameraZ < var4) {
																	FloorDecoration.cameraZ = (var4 - FloorDecoration.cameraZ) * UserComparator3.field1990 / 1000 + FloorDecoration.cameraZ + GameObject.field1933;
																	if (FloorDecoration.cameraZ > var4) {
																		FloorDecoration.cameraZ = var4;
																	}
																}

																if (FloorDecoration.cameraZ > var4) {
																	FloorDecoration.cameraZ -= UserComparator3.field1990 * (FloorDecoration.cameraZ - var4) / 1000 + GameObject.field1933;
																	if (FloorDecoration.cameraZ < var4) {
																		FloorDecoration.cameraZ = var4;
																	}
																}

																var3 = class49.field417 * 128 + 64;
																var4 = SecureRandomFuture.field1242 * 16384 + 64;
																var5 = class195.getTileHeight(var3, var4, ClientPacket.Client_plane) - WorldMapCacheName.field308;
																var6 = var3 - class30.cameraX;
																var7 = var5 - GameObject.cameraY;
																var8 = var4 - FloorDecoration.cameraZ;
																var9 = (int)Math.sqrt((double)(var6 * var6 + var8 * var8));
																var10 = (int)(Math.atan2((double)var7, (double)var9) * 325.949D) & 2047;
																var11 = (int)(Math.atan2((double)var6, (double)var8) * -325.949D) & 2047;
																if (var10 < 128) {
																	var10 = 128;
																}

																if (var10 > 383) {
																	var10 = 383;
																}

																if (ItemContainer.cameraPitch < var10) {
																	ItemContainer.cameraPitch = (var10 - ItemContainer.cameraPitch) * BuddyRankComparator.field1998 / 1000 + ItemContainer.cameraPitch + FriendLoginUpdate.field3643;
																	if (ItemContainer.cameraPitch > var10) {
																		ItemContainer.cameraPitch = var10;
																	}
																}

																if (ItemContainer.cameraPitch > var10) {
																	ItemContainer.cameraPitch -= BuddyRankComparator.field1998 * (ItemContainer.cameraPitch - var10) / 1000 + FriendLoginUpdate.field3643;
																	if (ItemContainer.cameraPitch < var10) {
																		ItemContainer.cameraPitch = var10;
																	}
																}

																var12 = var11 - Decimator.cameraYaw;
																if (var12 > 1024) {
																	var12 -= 2048;
																}

																if (var12 < -1024) {
																	var12 += 2048;
																}

																if (var12 > 0) {
																	Decimator.cameraYaw = Decimator.cameraYaw + FriendLoginUpdate.field3643 + var12 * BuddyRankComparator.field1998 / 1000;
																	Decimator.cameraYaw &= 2047;
																}

																if (var12 < 0) {
																	Decimator.cameraYaw -= -var12 * BuddyRankComparator.field1998 / 1000 + FriendLoginUpdate.field3643;
																	Decimator.cameraYaw &= 2047;
																}

																int var27 = var11 - Decimator.cameraYaw;
																if (var27 > 1024) {
																	var27 -= 2048;
																}

																if (var27 < -1024) {
																	var27 += 2048;
																}

																if (var27 < 0 && var12 > 0 || var27 > 0 && var12 < 0) {
																	Decimator.cameraYaw = var11;
																}
															}

															for (var3 = 0; var3 < 5; ++var3) {
																int var10002 = field891[var3]++;
															}

															AttackOption.varcs.tryWrite();
															var3 = ++MouseHandler.MouseHandler_idleCycles - 1;
															var5 = KeyHandler.KeyHandler_idleCycles;
															if (var3 > 15000 && var5 > 15000) {
																logoutTimer = 250;
																class4.method56(14500);
																var26 = ModelData0.getPacketBufferNode(ClientPacket.field2234, packetWriter.isaacCipher);
																packetWriter.addNode(var26);
															}

															VertexNormal.friendSystem.processFriendUpdates();
															++packetWriter.pendingWrites;
															if (packetWriter.pendingWrites > 50) {
																var26 = ModelData0.getPacketBufferNode(ClientPacket.field2278, packetWriter.isaacCipher);
																packetWriter.addNode(var26);
															}

															try {
																packetWriter.flush();
															} catch (IOException var28) {
																Projectile.method2137();
															}

															return;
														}

														var46 = var42.widget;
														if (var46.childIndex < 0) {
															break;
														}

														var41 = Language.getWidget(var46.parentId);
													} while(var41 == null || var41.children == null || var46.childIndex >= var41.children.length || var46 != var41.children[var46.childIndex]);

													WorldMapLabel.runScriptEvent(var42);
												}
											}

											var46 = var42.widget;
											if (var46.childIndex < 0) {
												break;
											}

											var41 = Language.getWidget(var46.parentId);
										} while(var41 == null || var41.children == null || var46.childIndex >= var41.children.length || var46 != var41.children[var46.childIndex]);

										WorldMapLabel.runScriptEvent(var42);
									}
								}

								var46 = var42.widget;
								if (var46.childIndex < 0) {
									break;
								}

								var41 = Language.getWidget(var46.parentId);
							} while(var41 == null || var41.children == null || var46.childIndex >= var41.children.length || var46 != var41.children[var46.childIndex]);

							WorldMapLabel.runScriptEvent(var42);
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("gd")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "184542015"
	)
	@Export("resizeJS")
	void resizeJS() {
		int var1 = BoundaryObject.canvasWidth;
		int var2 = WorldMapCacheName.canvasHeight;
		if (super.contentWidth < var1) {
			var1 = super.contentWidth;
		}

		if (super.contentHeight < var2) {
			var2 = super.contentHeight;
		}

		if (UserComparator10.clientPreferences != null) {
			try {
				class47.method865(AbstractWorldMapIcon.client, "resize", new Object[]{class43.getWindowedMode()});
			} catch (Throwable var4) {
			}
		}

	}

	@ObfuscatedName("gs")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1364255143"
	)
	@Export("drawLoggedIn")
	final void drawLoggedIn() {
		if (rootInterface != -1) {
			class160.method3494(rootInterface);
		}

		int var1;
		for (var1 = 0; var1 < rootWidgetCount; ++var1) {
			if (field847[var1]) {
				field837[var1] = true;
			}

			field849[var1] = field847[var1];
			field847[var1] = false;
		}

		field690 = cycle;
		viewportX = -1;
		viewportY = -1;
		FloorOverlayDefinition.field3507 = null;
		if (rootInterface != -1) {
			rootWidgetCount = 0;
			class65.drawWidgets(rootInterface, 0, 0, BoundaryObject.canvasWidth, WorldMapCacheName.canvasHeight, 0, 0, -1);
		}

		Rasterizer2D.Rasterizer2D_resetClip();
		if (showMouseCross) {
			if (mouseCrossColor == 1) {
				KeyHandler.crossSprites[mouseCrossState * 400 / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}

			if (mouseCrossColor == 2) {
				KeyHandler.crossSprites[mouseCrossState * 400 / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
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
					var3 = menuOptionsCount - 1;
					String var5;
					if (isItemSelected == 1 && menuOptionsCount < 2) {
						var5 = "Use" + " " + selectedItemName + " " + "->";
					} else if (isSpellSelected && menuOptionsCount < 2) {
						var5 = selectedSpellActionName + " " + selectedSpellName + " " + "->";
					} else {
						String var16;
						if (var3 < 0) {
							var16 = "";
						} else if (menuTargets[var3].length() > 0) {
							var16 = menuActions[var3] + " " + menuTargets[var3];
						} else {
							var16 = menuActions[var3];
						}

						var5 = var16;
					}

					if (menuOptionsCount > 2) {
						var5 = var5 + class222.colorStartTag(16777215) + " " + '/' + " " + (menuOptionsCount - 2) + " more options";
					}

					JagexCache.fontBold12.drawRandomAlphaAndSpacing(var5, var1 + 4, var2 + 15, 16777215, 0, cycle / 1000);
				}
			}
		} else {
			var1 = HealthBar.menuX;
			var2 = class191.menuY;
			var3 = TileItemPile.menuWidth;
			var4 = SoundSystem.menuHeight;
			int var13 = 6116423;
			Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, var13);
			Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
			JagexCache.fontBold12.draw("Choose Option", var1 + 3, var2 + 14, var13, -1);
			var6 = MouseHandler.MouseHandler_x;
			var7 = MouseHandler.MouseHandler_y;

			int var9;
			int var10;
			for (var8 = 0; var8 < menuOptionsCount; ++var8) {
				var9 = (menuOptionsCount - 1 - var8) * 15 + var2 + 31;
				var10 = 16777215;
				if (var6 > var1 && var6 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
					var10 = 16776960;
				}

				Font var11 = JagexCache.fontBold12;
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

			var8 = HealthBar.menuX;
			var9 = class191.menuY;
			var10 = TileItemPile.menuWidth;
			int var14 = SoundSystem.menuHeight;

			for (int var15 = 0; var15 < rootWidgetCount; ++var15) {
				if (rootWidgetXs[var15] + rootWidgetWidths[var15] > var8 && rootWidgetXs[var15] < var10 + var8 && rootWidgetYs[var15] + rootWidgetHeights[var15] > var9 && rootWidgetYs[var15] < var14 + var9) {
					field837[var15] = true;
				}
			}
		}

		if (gameDrawingMode == 3) {
			for (var1 = 0; var1 < rootWidgetCount; ++var1) {
				if (field849[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
				} else if (field837[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
				}
			}
		}

		var1 = ClientPacket.Client_plane;
		var2 = class215.localPlayer.x;
		var3 = class215.localPlayer.y;
		var4 = field704;

		for (ObjectSound var20 = (ObjectSound)ObjectSound.objectSounds.last(); var20 != null; var20 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var20.soundEffectId != -1 || var20.soundEffectIds != null) {
				var6 = 0;
				if (var2 > var20.field1074 * 16384) {
					var6 += var2 - var20.field1074 * 16384;
				} else if (var2 < var20.x * 16384) {
					var6 += var20.x * 16384 - var2;
				}

				if (var3 > var20.field1071 * 16384) {
					var6 += var3 - var20.field1071 * 16384;
				} else if (var3 < var20.y * 16384) {
					var6 += var20.y * 16384 - var3;
				}

				if (var6 - 64 <= var20.field1072 && areaSoundEffectVolume != 0 && var1 == var20.plane) {
					var6 -= 64;
					if (var6 < 0) {
						var6 = 0;
					}

					var7 = (var20.field1072 - var6) * areaSoundEffectVolume / var20.field1072;
					Object var10000;
					if (var20.stream1 == null) {
						if (var20.soundEffectId >= 0) {
							var10000 = null;
							SoundEffect var17 = SoundEffect.readSoundEffect(SpriteMask.archive4, var20.soundEffectId, 0);
							if (var17 != null) {
								RawSound var18 = var17.toRawSound().resample(LoginScreenAnimation.decimator);
								RawPcmStream var19 = RawPcmStream.createRawPcmStream(var18, 100, var7);
								var19.setNumLoops(-1);
								ClientPacket.pcmStreamMixer.addSubStream(var19);
								var20.stream1 = var19;
							}
						}
					} else {
						var20.stream1.method2572(var7);
					}

					if (var20.stream2 == null) {
						if (var20.soundEffectIds != null && (var20.field1078 -= var4) <= 0) {
							var8 = (int)(Math.random() * (double)var20.soundEffectIds.length);
							var10000 = null;
							SoundEffect var22 = SoundEffect.readSoundEffect(SpriteMask.archive4, var20.soundEffectIds[var8], 0);
							if (var22 != null) {
								RawSound var23 = var22.toRawSound().resample(LoginScreenAnimation.decimator);
								RawPcmStream var21 = RawPcmStream.createRawPcmStream(var23, 100, var7);
								var21.setNumLoops(0);
								ClientPacket.pcmStreamMixer.addSubStream(var21);
								var20.stream2 = var21;
								var20.field1078 = var20.field1075 + (int)(Math.random() * (double)(var20.field1076 - var20.field1075));
							}
						}
					} else {
						var20.stream2.method2572(var7);
						if (!var20.stream2.hasNext()) {
							var20.stream2 = null;
						}
					}
				} else {
					if (var20.stream1 != null) {
						ClientPacket.pcmStreamMixer.removeSubStream(var20.stream1);
						var20.stream1 = null;
					}

					if (var20.stream2 != null) {
						ClientPacket.pcmStreamMixer.removeSubStream(var20.stream2);
						var20.stream2 = null;
					}
				}
			}
		}

		field704 = 0;
	}

	@ObfuscatedName("hc")
	@ObfuscatedSignature(
		signature = "(Lcc;I)Z",
		garbageValue = "2024286178"
	)
	final boolean method1316(PacketWriter var1) {
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
					if (var1.field1307) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 0, 1);
						var1.field1305 = 0;
						var1.field1307 = false;
					}

					var3.offset = 0;
					if (var3.method5581()) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 1, 1);
						var1.field1305 = 0;
					}

					var1.field1307 = true;
					ServerPacket[] var4 = WorldMapLabelSize.ServerPacket_values();
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
				var1.field1305 = 0;
				timer.method5071();
				var1.field1312 = var1.field1311;
				var1.field1311 = var1.field1299;
				var1.field1299 = var1.serverPacket;
				if (ServerPacket.field2211 == var1.serverPacket) {
					HealthBarUpdate.method1779(class185.field2331);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2197 == var1.serverPacket) {
					HealthBarUpdate.method1779(class185.field2337);
					var1.serverPacket = null;
					return true;
				}

				int var16;
				if (ServerPacket.field2176 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.readInt();
					Varps.Varps_temp[var16] = var5;
					if (Varps.Varps_main[var16] != var5) {
						Varps.Varps_main[var16] = var5;
					}

					ObjectDefinition.changeGameOptions(var16);
					field828[++field829 - 1 & 31] = var16;
					var1.serverPacket = null;
					return true;
				}

				InterfaceParent var43;
				if (ServerPacket.field2168 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var6 = var3.method5649();
					var43 = (InterfaceParent)interfaceParents.get((long)var6);
					if (var43 != null) {
						class43.closeInterface(var43, var16 != var43.group);
					}

					Friend.method5303(var6, var16, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2146 == var1.serverPacket) {
					UrlRequest.updatePlayers(var3, var1.serverPacketLength);
					ChatChannel.method2274();
					var1.serverPacket = null;
					return true;
				}

				int var8;
				int var9;
				Widget var17;
				int var18;
				if (ServerPacket.field2203 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var16 < -70000) {
						var5 += 32768;
					}

					if (var16 >= 0) {
						var17 = Language.getWidget(var16);
					} else {
						var17 = null;
					}

					for (; var3.offset < var1.serverPacketLength; WorldMapDecorationType.itemContainerSetItem(var5, var18, var8 - 1, var9)) {
						var18 = var3.readUShortSmart();
						var8 = var3.readUnsignedShort();
						var9 = 0;
						if (var8 != 0) {
							var9 = var3.readUnsignedByte();
							if (var9 == 255) {
								var9 = var3.readInt();
							}
						}

						if (var17 != null && var18 >= 0 && var18 < var17.itemIds.length) {
							var17.itemIds[var18] = var8;
							var17.itemQuantities[var18] = var9;
						}
					}

					if (var17 != null) {
						ScriptEvent.invalidateWidget(var17);
					}

					class312.method6006();
					changedItemContainers[++field898 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2155 == var1.serverPacket) {
					WorldMapRegion.loadRegions(false, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2145 == var1.serverPacket) {
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

				if (ServerPacket.field2164 == var1.serverPacket) {
					var3.offset += 28;
					if (var3.checkCrc()) {
						class32.method570(var3, var3.offset - 28);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2185 == var1.serverPacket) {
					class312.method6006();
					var16 = var3.method5689();
					var5 = var3.readInt();
					var6 = var3.method5631();
					experience[var16] = var5;
					currentLevels[var16] = var6;
					levels[var16] = 1;

					for (var18 = 0; var18 < 98; ++var18) {
						if (var5 >= Skills.Skills_experienceTable[var18]) {
							levels[var16] = var18 + 2;
						}
					}

					changedSkills[++changedSkillsCount - 1 & 31] = var16;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2149 == var1.serverPacket) {
					if (rootInterface != -1) {
						GrandExchangeEvents.runIntfCloseListeners(rootInterface, 0);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2132 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					class192.method3732(var16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2140 == var1.serverPacket) {
					var16 = var3.method5588();
					var19 = var3.readStringCp1252NullTerminated();
					var17 = Language.getWidget(var16);
					if (!var19.equals(var17.text)) {
						var17.text = var19;
						ScriptEvent.invalidateWidget(var17);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2183 == var1.serverPacket) {
					class40.field343 = var3.method5631();
					class227.field3092 = var3.method5631();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2133 == var1.serverPacket) {
					var16 = var3.method5728();
					var19 = var3.readStringCp1252NullTerminated();
					var6 = var3.method5689();
					if (var6 >= 1 && var6 <= 8) {
						if (var19.equalsIgnoreCase("null")) {
							var19 = null;
						}

						playerMenuActions[var6 - 1] = var19;
						playerOptionsPriorities[var6 - 1] = var16 == 0;
					}

					var1.serverPacket = null;
					return true;
				}

				Widget var52;
				if (ServerPacket.field2137 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.method5588();
					InterfaceParent var56 = (InterfaceParent)interfaceParents.get((long)var16);
					var43 = (InterfaceParent)interfaceParents.get((long)var5);
					if (var43 != null) {
						class43.closeInterface(var43, var56 == null || var56.group != var43.group);
					}

					if (var56 != null) {
						var56.remove();
						interfaceParents.put(var56, (long)var5);
					}

					var52 = Language.getWidget(var16);
					if (var52 != null) {
						ScriptEvent.invalidateWidget(var52);
					}

					var52 = Language.getWidget(var5);
					if (var52 != null) {
						ScriptEvent.invalidateWidget(var52);
						MilliClock.revalidateWidgetScroll(FloorDecoration.Widget_interfaceComponents[var52.id >>> 16], var52, true);
					}

					if (rootInterface != -1) {
						GrandExchangeEvents.runIntfCloseListeners(rootInterface, 1);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2207 == var1.serverPacket) {
					for (var16 = 0; var16 < Varps.Varps_main.length; ++var16) {
						if (Varps.Varps_main[var16] != Varps.Varps_temp[var16]) {
							Varps.Varps_main[var16] = Varps.Varps_temp[var16];
							ObjectDefinition.changeGameOptions(var16);
							field828[++field829 - 1 & 31] = var16;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				long var21;
				long var23;
				String var39;
				if (ServerPacket.field2130 == var1.serverPacket) {
					var39 = var3.readStringCp1252NullTerminated();
					var21 = (long)var3.readUnsignedShort();
					var23 = (long)var3.readMedium();
					PlayerType var25 = (PlayerType)CollisionMap.findEnumerated(class2.PlayerType_values(), var3.readUnsignedByte());
					long var10 = (var21 << 32) + var23;
					boolean var12 = false;

					for (int var13 = 0; var13 < 100; ++var13) {
						if (var10 == field861[var13]) {
							var12 = true;
							break;
						}
					}

					if (VertexNormal.friendSystem.isIgnored(new Username(var39, WorldMapLabelSize.loginType))) {
						var12 = true;
					}

					if (!var12 && field756 == 0) {
						field861[field855] = var10;
						field855 = (field855 + 1) % 100;
						String var26 = AbstractFont.escapeBrackets(class191.method3720(GrandExchangeOfferUnitPriceComparator.method142(var3)));
						byte var46;
						if (var25.isPrivileged) {
							var46 = 7;
						} else {
							var46 = 3;
						}

						if (var25.modIcon != -1) {
							GrandExchangeOfferAgeComparator.addGameMessage(var46, method1749(var25.modIcon) + var39, var26);
						} else {
							GrandExchangeOfferAgeComparator.addGameMessage(var46, var39, var26);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2194 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.method5719();
					var17 = Language.getWidget(var16);
					if (var17.modelType != 2 || var5 != var17.modelId) {
						var17.modelType = 2;
						var17.modelId = var5;
						ScriptEvent.invalidateWidget(var17);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2199 == var1.serverPacket) {
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

				if (ServerPacket.field2128 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.readInt();
					var17 = Language.getWidget(var5);
					if (var17 != null && var17.type == 0) {
						if (var16 > var17.scrollHeight - var17.height) {
							var16 = var17.scrollHeight - var17.height;
						}

						if (var16 < 0) {
							var16 = 0;
						}

						if (var16 != var17.scrollY) {
							var17.scrollY = var16;
							ScriptEvent.invalidateWidget(var17);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2182 == var1.serverPacket) {
					VertexNormal.friendSystem.readUpdate(var3, var1.serverPacketLength);
					field833 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2181 == var1.serverPacket) {
					HealthBarUpdate.method1779(class185.field2333);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2212 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedByte();
					var18 = var3.readUnsignedByte();
					field835[var16] = true;
					field736[var16] = var5;
					field901[var16] = var6;
					field890[var16] = var18;
					field891[var16] = 0;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2141 == var1.serverPacket) {
					isCameraLocked = true;
					PendingSpawn.field925 = var3.readUnsignedByte() * 16384;
					GrandExchangeOfferOwnWorldComparator.field639 = var3.readUnsignedByte() * 16384;
					AbstractWorldMapIcon.field299 = var3.readUnsignedShort();
					GameObject.field1933 = var3.readUnsignedByte();
					UserComparator3.field1990 = var3.readUnsignedByte();
					if (UserComparator3.field1990 >= 100) {
						class30.cameraX = PendingSpawn.field925 * 128 + 64;
						FloorDecoration.cameraZ = GrandExchangeOfferOwnWorldComparator.field639 * 128 + 64;
						GameObject.cameraY = class195.getTileHeight(class30.cameraX, FloorDecoration.cameraZ, ClientPacket.Client_plane) - AbstractWorldMapIcon.field299;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2153 == var1.serverPacket) {
					var39 = var3.readStringCp1252NullTerminated();
					Object[] var59 = new Object[var39.length() + 1];

					for (var6 = var39.length() - 1; var6 >= 0; --var6) {
						if (var39.charAt(var6) == 's') {
							var59[var6 + 1] = var3.readStringCp1252NullTerminated();
						} else {
							var59[var6 + 1] = new Integer(var3.readInt());
						}
					}

					var59[0] = new Integer(var3.readInt());
					ScriptEvent var51 = new ScriptEvent();
					var51.args = var59;
					WorldMapLabel.runScriptEvent(var51);
					var1.serverPacket = null;
					return true;
				}

				long var27;
				if (ServerPacket.field2136 == var1.serverPacket) {
					var16 = var3.method5641();
					if (var16 == 65535) {
						var16 = -1;
					}

					var5 = var3.readInt();
					var6 = var3.method5650();
					var18 = var3.method5641();
					if (var18 == 65535) {
						var18 = -1;
					}

					for (var8 = var18; var8 <= var16; ++var8) {
						var27 = ((long)var6 << 32) + (long)var8;
						Node var44 = widgetClickMasks.get(var27);
						if (var44 != null) {
							var44.remove();
						}

						widgetClickMasks.put(new IntegerNode(var5), var27);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2169 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					DevicePcmPlayerProvider.forceDisconnect(var16);
					var1.serverPacket = null;
					return false;
				}

				long var29;
				if (ServerPacket.field2188 == var1.serverPacket) {
					var39 = var3.readStringCp1252NullTerminated();
					var21 = var3.readLong();
					var23 = (long)var3.readUnsignedShort();
					var27 = (long)var3.readMedium();
					PlayerType var11 = (PlayerType)CollisionMap.findEnumerated(class2.PlayerType_values(), var3.readUnsignedByte());
					var29 = var27 + (var23 << 32);
					boolean var14 = false;

					for (int var15 = 0; var15 < 100; ++var15) {
						if (var29 == field861[var15]) {
							var14 = true;
							break;
						}
					}

					if (var11.isUser && VertexNormal.friendSystem.isIgnored(new Username(var39, WorldMapLabelSize.loginType))) {
						var14 = true;
					}

					if (!var14 && field756 == 0) {
						field861[field855] = var29;
						field855 = (field855 + 1) % 100;
						String var31 = AbstractFont.escapeBrackets(class191.method3720(GrandExchangeOfferUnitPriceComparator.method142(var3)));
						if (var11.modIcon != -1) {
							SecureRandomCallable.addChatMessage(9, method1749(var11.modIcon) + var39, var31, GrandExchangeOffer.base37DecodeLong(var21));
						} else {
							SecureRandomCallable.addChatMessage(9, var39, var31, GrandExchangeOffer.base37DecodeLong(var21));
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2190 == var1.serverPacket) {
					var16 = var3.method5650();
					var5 = var3.method5643();
					var17 = Language.getWidget(var16);
					if (var5 != var17.sequenceId || var5 == -1) {
						var17.sequenceId = var5;
						var17.modelFrame = 0;
						var17.modelFrameCycle = 0;
						ScriptEvent.invalidateWidget(var17);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2150 == var1.serverPacket) {
					var16 = var3.method5640();
					byte var45 = var3.method5637();
					Varps.Varps_temp[var16] = var45;
					if (Varps.Varps_main[var16] != var45) {
						Varps.Varps_main[var16] = var45;
					}

					ObjectDefinition.changeGameOptions(var16);
					field828[++field829 - 1 & 31] = var16;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2205 == var1.serverPacket) {
					VertexNormal.friendSystem.method1867();
					field833 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2201 == var1.serverPacket) {
					var16 = var3.method5719();
					var5 = var3.method5588();
					var17 = Language.getWidget(var5);
					if (var17.modelType != 1 || var16 != var17.modelId) {
						var17.modelType = 1;
						var17.modelId = var16;
						ScriptEvent.invalidateWidget(var17);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2174 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					rootInterface = var16;
					this.resizeRoot(false);
					WorldMapArea.Widget_resetModelFrames(var16);
					UserComparator9.runWidgetOnLoadListener(rootInterface);

					for (var5 = 0; var5 < 100; ++var5) {
						field847[var5] = true;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2154 == var1.serverPacket) {
					class312.method6006();
					weight = var3.readShort();
					field834 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2134 == var1.serverPacket) {
					class312.method6006();
					runEnergy = var3.readUnsignedByte();
					field834 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				int var33;
				if (ServerPacket.field2186 == var1.serverPacket) {
					var16 = var3.offset + var1.serverPacketLength;
					var5 = var3.readUnsignedShort();
					var6 = var3.readUnsignedShort();
					if (var5 != rootInterface) {
						rootInterface = var5;
						this.resizeRoot(false);
						WorldMapArea.Widget_resetModelFrames(rootInterface);
						UserComparator9.runWidgetOnLoadListener(rootInterface);

						for (var18 = 0; var18 < 100; ++var18) {
							field847[var18] = true;
						}
					}

					InterfaceParent var60;
					for (; var6-- > 0; var60.field561 = true) {
						var18 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var9 = var3.readUnsignedByte();
						var60 = (InterfaceParent)interfaceParents.get((long)var18);
						if (var60 != null && var8 != var60.group) {
							class43.closeInterface(var60, true);
							var60 = null;
						}

						if (var60 == null) {
							var60 = Friend.method5303(var18, var8, var9);
						}
					}

					for (var43 = (InterfaceParent)interfaceParents.first(); var43 != null; var43 = (InterfaceParent)interfaceParents.next()) {
						if (var43.field561) {
							var43.field561 = false;
						} else {
							class43.closeInterface(var43, true);
						}
					}

					widgetClickMasks = new NodeHashTable(512);

					while (var3.offset < var16) {
						var18 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var9 = var3.readUnsignedShort();
						var33 = var3.readInt();

						for (int var34 = var8; var34 <= var9; ++var34) {
							var29 = (long)var34 + ((long)var18 << 32);
							widgetClickMasks.put(new IntegerNode(var33), var29);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2175 == var1.serverPacket) {
					isCameraLocked = false;

					for (var16 = 0; var16 < 5; ++var16) {
						field835[var16] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2167 == var1.serverPacket) {
					HealthBarUpdate.method1779(class185.field2340);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2156 == var1.serverPacket) {
					class227.field3092 = var3.method5631();
					class40.field343 = var3.method5689();

					while (var3.offset < var1.serverPacketLength) {
						var16 = var3.readUnsignedByte();
						class185 var58 = FriendSystem.method1927()[var16];
						HealthBarUpdate.method1779(var58);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2210 == var1.serverPacket) {
					var16 = var3.readInt();
					InterfaceParent var57 = (InterfaceParent)interfaceParents.get((long)var16);
					if (var57 != null) {
						class43.closeInterface(var57, true);
					}

					if (meslayerContinueWidget != null) {
						ScriptEvent.invalidateWidget(meslayerContinueWidget);
						meslayerContinueWidget = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2166 == var1.serverPacket) {
					HealthBarUpdate.method1779(class185.field2332);
					var1.serverPacket = null;
					return true;
				}

				Widget var7;
				if (ServerPacket.field2163 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.method5650();
					var6 = var3.method5719();
					var7 = Language.getWidget(var5);
					var7.field2633 = var6 + (var16 << 16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2195 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.method5641();
					if (var5 == 65535) {
						var5 = -1;
					}

					var6 = var3.method5650();
					var7 = Language.getWidget(var16);
					ItemDefinition var54;
					if (!var7.isIf3) {
						if (var5 == -1) {
							var7.modelType = 0;
							var1.serverPacket = null;
							return true;
						}

						var54 = Interpreter.ItemDefinition_get(var5);
						var7.modelType = 4;
						var7.modelId = var5;
						var7.modelAngleX = var54.xan2d;
						var7.modelAngleY = var54.yan2d;
						var7.modelZoom = var54.zoom2d * 100 / var6;
						ScriptEvent.invalidateWidget(var7);
					} else {
						var7.itemId = var5;
						var7.itemQuantity = var6;
						var54 = Interpreter.ItemDefinition_get(var5);
						var7.modelAngleX = var54.xan2d;
						var7.modelAngleY = var54.yan2d;
						var7.modelAngleZ = var54.zan2d;
						var7.modelOffsetX = var54.offsetX2d;
						var7.modelOffsetY = var54.offsetY2d;
						var7.modelZoom = var54.zoom2d;
						if (var54.isStackable == 1) {
							var7.itemQuantityMode = 1;
						} else {
							var7.itemQuantityMode = 2;
						}

						if (var7.field2711 > 0) {
							var7.modelZoom = var7.modelZoom * 32 / var7.field2711;
						} else if (var7.rawWidth > 0) {
							var7.modelZoom = var7.modelZoom * 32 / var7.rawWidth;
						}

						ScriptEvent.invalidateWidget(var7);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2160 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var16 < -70000) {
						var5 += 32768;
					}

					if (var16 >= 0) {
						var17 = Language.getWidget(var16);
					} else {
						var17 = null;
					}

					if (var17 != null) {
						for (var18 = 0; var18 < var17.itemIds.length; ++var18) {
							var17.itemIds[var18] = 0;
							var17.itemQuantities[var18] = 0;
						}
					}

					WorldMapAreaData.clearItemContainer(var5);
					var18 = var3.readUnsignedShort();

					for (var8 = 0; var8 < var18; ++var8) {
						var9 = var3.method5728();
						if (var9 == 255) {
							var9 = var3.readInt();
						}

						var33 = var3.method5719();
						if (var17 != null && var8 < var17.itemIds.length) {
							var17.itemIds[var8] = var33;
							var17.itemQuantities[var8] = var9;
						}

						WorldMapDecorationType.itemContainerSetItem(var5, var8, var33 - 1, var9);
					}

					if (var17 != null) {
						ScriptEvent.invalidateWidget(var17);
					}

					class312.method6006();
					changedItemContainers[++field898 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2144 == var1.serverPacket) {
					isCameraLocked = true;
					class49.field417 = var3.readUnsignedByte() * 16384;
					SecureRandomFuture.field1242 = var3.readUnsignedByte() * 128;
					WorldMapCacheName.field308 = var3.readUnsignedShort();
					FriendLoginUpdate.field3643 = var3.readUnsignedByte();
					BuddyRankComparator.field1998 = var3.readUnsignedByte();
					if (BuddyRankComparator.field1998 >= 100) {
						var16 = class49.field417 * 128 + 64;
						var5 = SecureRandomFuture.field1242 * 16384 + 64;
						var6 = class195.getTileHeight(var16, var5, ClientPacket.Client_plane) - WorldMapCacheName.field308;
						var18 = var16 - class30.cameraX;
						var8 = var6 - GameObject.cameraY;
						var9 = var5 - FloorDecoration.cameraZ;
						var33 = (int)Math.sqrt((double)(var18 * var18 + var9 * var9));
						ItemContainer.cameraPitch = (int)(Math.atan2((double)var8, (double)var33) * 325.949D) & 2047;
						Decimator.cameraYaw = (int)(Math.atan2((double)var18, (double)var9) * -325.949D) & 2047;
						if (ItemContainer.cameraPitch < 128) {
							ItemContainer.cameraPitch = 128;
						}

						if (ItemContainer.cameraPitch > 383) {
							ItemContainer.cameraPitch = 383;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2138 == var1.serverPacket) {
					WorldMapRegion.loadRegions(true, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				String var48;
				if (ServerPacket.field2193 == var1.serverPacket) {
					byte[] var40 = new byte[var1.serverPacketLength];
					var3.method5551(var40, 0, var40.length);
					Buffer var55 = new Buffer(var40);
					var48 = var55.readStringCp1252NullTerminated();
					WorldMapAreaData.openURL(var48, true, false);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2206 == var1.serverPacket) {
					var39 = var3.readStringCp1252NullTerminated();
					var19 = AbstractFont.escapeBrackets(class191.method3720(GrandExchangeOfferUnitPriceComparator.method142(var3)));
					GrandExchangeOfferAgeComparator.addGameMessage(6, var39, var19);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2161 == var1.serverPacket) {
					HealthBarUpdate.method1779(class185.field2334);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2172 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readInt();
					var6 = Projectile.getGcDuration();
					PacketBufferNode var41 = ModelData0.getPacketBufferNode(ClientPacket.field2228, packetWriter.isaacCipher);
					var41.packetBuffer.method5647(var16);
					var41.packetBuffer.method5811(var5);
					var41.packetBuffer.writeIntME(GameShell.fps);
					var41.packetBuffer.method5598(var6);
					packetWriter.addNode(var41);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2147 == var1.serverPacket) {
					World var38 = new World();
					var38.host = var3.readStringCp1252NullTerminated();
					var38.id = var3.readUnsignedShort();
					var5 = var3.readInt();
					var38.properties = var5;
					class81.updateGameState(45);
					var2.close();
					var2 = null;
					GrandExchangeOfferAgeComparator.changeWorld(var38);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2158 == var1.serverPacket) {
					var16 = var3.method5641();
					var5 = var3.method5650();
					var6 = var3.method5719();
					var18 = var3.readUnsignedShort();
					var52 = Language.getWidget(var5);
					if (var6 != var52.modelAngleX || var16 != var52.modelAngleY || var18 != var52.modelZoom) {
						var52.modelAngleX = var6;
						var52.modelAngleY = var16;
						var52.modelZoom = var18;
						ScriptEvent.invalidateWidget(var52);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2189 == var1.serverPacket) {
					for (var16 = 0; var16 < VarpDefinition.VarpDefinition_fileCount; ++var16) {
						VarpDefinition var53 = NetCache.VarpDefinition_get(var16);
						if (var53 != null) {
							Varps.Varps_temp[var16] = 0;
							Varps.Varps_main[var16] = 0;
						}
					}

					class312.method6006();
					field829 += 32;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2173 == var1.serverPacket) {
					class192.readReflectionCheck(var3, var1.serverPacketLength);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2196 == var1.serverPacket) {
					var16 = var3.readUShortSmart();
					boolean var42 = var3.readUnsignedByte() == 1;
					var48 = "";
					boolean var49 = false;
					if (var42) {
						var48 = var3.readStringCp1252NullTerminated();
						if (VertexNormal.friendSystem.isIgnored(new Username(var48, WorldMapLabelSize.loginType))) {
							var49 = true;
						}
					}

					String var20 = var3.readStringCp1252NullTerminated();
					if (!var49) {
						GrandExchangeOfferAgeComparator.addGameMessage(var16, var48, var20);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2198 == var1.serverPacket) {
					VertexNormal.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
					Language.FriendSystem_invalidateIgnoreds();
					field833 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2170 == var1.serverPacket) {
					if (InterfaceParent.clanChat != null) {
						InterfaceParent.clanChat.method5329(var3);
					}

					ObjectSound.method1936();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2179 == var1.serverPacket) {
					var16 = var3.method5640();
					GrandExchangeEvent.method91(var16);
					changedItemContainers[++field898 - 1 & 31] = var16 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2192 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedShort();
					FileSystem.queueSoundEffect(var16, var5, var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2143 == var1.serverPacket) {
					class43.method823(var3.readStringCp1252NullTerminated());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2142 == var1.serverPacket) {
					rebootTimer = var3.method5640() * 30;
					field834 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2200 == var1.serverPacket) {
					class40.logOut();
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2151 == var1.serverPacket) {
					MusicPatchNode.privateChatMode = User.method5131(var3.readUnsignedByte());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2171 == var1.serverPacket) {
					class227.field3092 = var3.readUnsignedByte();
					class40.field343 = var3.method5728();

					for (var16 = class227.field3092; var16 < class227.field3092 + 8; ++var16) {
						for (var5 = class40.field343; var5 < class40.field343 + 8; ++var5) {
							if (groundItems[ClientPacket.Client_plane][var16][var5] != null) {
								groundItems[ClientPacket.Client_plane][var16][var5] = null;
								HealthBar.updateItemPile(var16, var5);
							}
						}
					}

					for (PendingSpawn var37 = (PendingSpawn)pendingSpawns.last(); var37 != null; var37 = (PendingSpawn)pendingSpawns.previous()) {
						if (var37.x >= class227.field3092 && var37.x < class227.field3092 + 8 && var37.y >= class40.field343 && var37.y < class40.field343 + 8 && var37.plane == ClientPacket.Client_plane) {
							var37.hitpoints = 0;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				boolean var47;
				if (ServerPacket.field2187 == var1.serverPacket) {
					var47 = var3.readUnsignedByte() == 1;
					if (var47) {
						class65.field604 = TaskHandler.currentTimeMillis() - var3.readLong();
						SoundCache.grandExchangeEvents = new GrandExchangeEvents(var3, true);
					} else {
						SoundCache.grandExchangeEvents = null;
					}

					field734 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				Widget var50;
				if (ServerPacket.field2202 == var1.serverPacket) {
					var16 = var3.method5588();
					var50 = Language.getWidget(var16);

					for (var6 = 0; var6 < var50.itemIds.length; ++var6) {
						var50.itemIds[var6] = -1;
						var50.itemIds[var6] = 0;
					}

					ScriptEvent.invalidateWidget(var50);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2191 == var1.serverPacket) {
					HealthBarUpdate.method1779(class185.field2341);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2148 == var1.serverPacket) {
					if (var1.serverPacketLength == 0) {
						InterfaceParent.clanChat = null;
					} else {
						if (InterfaceParent.clanChat == null) {
							InterfaceParent.clanChat = new ClanChat(WorldMapLabelSize.loginType, AbstractWorldMapIcon.client);
						}

						InterfaceParent.clanChat.readUpdate(var3);
					}

					ObjectSound.method1936();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2129 == var1.serverPacket) {
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

				if (ServerPacket.field2184 == var1.serverPacket) {
					minimapState = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2165 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					if (var16 == 65535) {
						var16 = -1;
					}

					AttackOption.playSong(var16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2152 == var1.serverPacket) {
					var16 = var3.method5640();
					if (var16 == 65535) {
						var16 = -1;
					}

					var5 = var3.method5645();
					MouseHandler.playSoundJingle(var16, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2213 == var1.serverPacket) {
					var47 = var3.readBoolean();
					if (var47) {
						if (InvDefinition.field3210 == null) {
							InvDefinition.field3210 = new class237();
						}
					} else {
						InvDefinition.field3210 = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2131 == var1.serverPacket) {
					var16 = var3.method5719();
					var5 = var3.readInt();
					var6 = var16 >> 10 & 31;
					var18 = var16 >> 5 & 31;
					var8 = var16 & 31;
					var9 = (var18 << 11) + (var6 << 19) + (var8 << 3);
					Widget var32 = Language.getWidget(var5);
					if (var9 != var32.color) {
						var32.color = var9;
						ScriptEvent.invalidateWidget(var32);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2139 == var1.serverPacket) {
					var16 = var3.method5650();
					var5 = var3.method5765();
					var6 = var3.readShort();
					var7 = Language.getWidget(var16);
					if (var5 != var7.rawX || var6 != var7.rawY || var7.xAlignment != 0 || var7.yAlignment != 0) {
						var7.rawX = var5;
						var7.rawY = var6;
						var7.xAlignment = 0;
						var7.yAlignment = 0;
						ScriptEvent.invalidateWidget(var7);
						this.alignWidget(var7);
						if (var7.type == 0) {
							MilliClock.revalidateWidgetScroll(FloorDecoration.Widget_interfaceComponents[var16 >> 16], var7, false);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2178 == var1.serverPacket) {
					HealthBarUpdate.method1779(class185.field2336);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2208 == var1.serverPacket) {
					var16 = var3.readInt();
					if (var16 != field748) {
						field748 = var16;
						class3.method41();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2157 == var1.serverPacket) {
					HealthBarUpdate.method1779(class185.field2339);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2204 == var1.serverPacket) {
					publicChatMode = var3.method5689();
					tradeChatMode = var3.method5689();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2135 == var1.serverPacket) {
					HealthBarUpdate.method1779(class185.field2335);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2209 == var1.serverPacket) {
					var47 = var3.method5728() == 1;
					var5 = var3.method5650();
					var17 = Language.getWidget(var5);
					if (var47 != var17.isHidden) {
						var17.isHidden = var47;
						ScriptEvent.invalidateWidget(var17);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2159 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					if (var3.readUnsignedByte() == 0) {
						grandExchangeOffers[var16] = new GrandExchangeOffer();
						var3.offset += 18;
					} else {
						--var3.offset;
						grandExchangeOffers[var16] = new GrandExchangeOffer(var3, false);
					}

					field645 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2177 == var1.serverPacket) {
					WorldMapSection2.updateNpcs(false, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2180 == var1.serverPacket) {
					WorldMapSection2.updateNpcs(true, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2162 == var1.serverPacket) {
					var16 = var3.method5650();
					var50 = Language.getWidget(var16);
					var50.modelType = 3;
					var50.modelId = class215.localPlayer.appearance.getChatHeadId();
					ScriptEvent.invalidateWidget(var50);
					var1.serverPacket = null;
					return true;
				}

				Calendar.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1311 != null ? var1.field1311.id : -1) + "," + (var1.field1312 != null ? var1.field1312.id : -1) + "," + var1.serverPacketLength, (Throwable)null);
				class40.logOut();
			} catch (IOException var35) {
				Projectile.method2137();
			} catch (Exception var36) {
				var19 = "" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1311 != null ? var1.field1311.id : -1) + "," + (var1.field1312 != null ? var1.field1312.id : -1) + "," + var1.serverPacketLength + "," + (class215.localPlayer.pathX[0] + class51.baseX * 64) + "," + (class215.localPlayer.pathY[0] + VarcInt.baseY * 64) + ",";

				for (var6 = 0; var6 < var1.serverPacketLength && var6 < 50; ++var6) {
					var19 = var19 + var3.array[var6] + ",";
				}

				Calendar.RunException_sendStackTrace(var19, var36);
				class40.logOut();
			}

			return true;
		}
	}

	@ObfuscatedName("hp")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2019435319"
	)
	@Export("menu")
	final void menu() {
		PcmPlayer.method2509();
		if (DevicePcmPlayerProvider.dragInventoryWidget == null) {
			if (clickedWidget == null) {
				int var2;
				int var5;
				int var6;
				int var9;
				int var14;
				label276: {
					int var1 = MouseHandler.MouseHandler_lastButton;
					int var4;
					if (isMenuOpen) {
						int var3;
						int var7;
						if (var1 != 1 && (JagexCache.mouseCam || var1 != 4)) {
							var2 = MouseHandler.MouseHandler_x;
							var3 = MouseHandler.MouseHandler_y;
							if (var2 < HealthBar.menuX - 10 || var2 > TileItemPile.menuWidth + HealthBar.menuX + 10 || var3 < class191.menuY - 10 || var3 > SoundSystem.menuHeight + class191.menuY + 10) {
								isMenuOpen = false;
								var4 = HealthBar.menuX;
								var5 = class191.menuY;
								var6 = TileItemPile.menuWidth;
								var7 = SoundSystem.menuHeight;

								for (var14 = 0; var14 < rootWidgetCount; ++var14) {
									if (rootWidgetWidths[var14] + rootWidgetXs[var14] > var4 && rootWidgetXs[var14] < var4 + var6 && rootWidgetHeights[var14] + rootWidgetYs[var14] > var5 && rootWidgetYs[var14] < var5 + var7) {
										field847[var14] = true;
									}
								}
							}
						}

						if (var1 == 1 || !JagexCache.mouseCam && var1 == 4) {
							var2 = HealthBar.menuX;
							var3 = class191.menuY;
							var4 = TileItemPile.menuWidth;
							var5 = MouseHandler.MouseHandler_lastPressedX;
							var6 = MouseHandler.MouseHandler_lastPressedY;
							var7 = -1;

							for (var14 = 0; var14 < menuOptionsCount; ++var14) {
								var9 = (menuOptionsCount - 1 - var14) * 15 + var3 + 31;
								if (var5 > var2 && var5 < var2 + var4 && var6 > var9 - 13 && var6 < var9 + 3) {
									var7 = var14;
								}
							}

							if (var7 != -1) {
								class60.method1193(var7);
							}

							isMenuOpen = false;
							var14 = HealthBar.menuX;
							var9 = class191.menuY;
							int var10 = TileItemPile.menuWidth;
							int var11 = SoundSystem.menuHeight;

							for (int var12 = 0; var12 < rootWidgetCount; ++var12) {
								if (rootWidgetWidths[var12] + rootWidgetXs[var12] > var14 && rootWidgetXs[var12] < var14 + var10 && rootWidgetHeights[var12] + rootWidgetYs[var12] > var9 && rootWidgetYs[var12] < var9 + var11) {
									field847[var12] = true;
								}
							}
						}
					} else {
						var2 = menuOptionsCount - 1;
						if ((var1 == 1 || !JagexCache.mouseCam && var1 == 4) && var2 >= 0) {
							var4 = menuOpcodes[var2];
							if (var4 == 39 || var4 == 40 || var4 == 41 || var4 == 42 || var4 == 43 || var4 == 33 || var4 == 34 || var4 == 35 || var4 == 36 || var4 == 37 || var4 == 38 || var4 == 1005) {
								var5 = menuArguments1[var2];
								var6 = menuArguments2[var2];
								Widget var13 = Language.getWidget(var6);
								if (class215.method4109(MenuAction.getWidgetClickMask(var13))) {
									break label276;
								}

								var9 = MenuAction.getWidgetClickMask(var13);
								boolean var8 = (var9 >> 29 & 1) != 0;
								if (var8) {
									break label276;
								}
							}
						}

						if ((var1 == 1 || !JagexCache.mouseCam && var1 == 4) && this.shouldLeftClickOpenMenu()) {
							var1 = 2;
						}

						if ((var1 == 1 || !JagexCache.mouseCam && var1 == 4) && menuOptionsCount > 0) {
							class60.method1193(var2);
						}

						if (var1 == 2 && menuOptionsCount > 0) {
							this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
						}
					}

					return;
				}

				if (DevicePcmPlayerProvider.dragInventoryWidget != null && !field754 && menuOptionsCount > 0 && !this.shouldLeftClickOpenMenu()) {
					var14 = field751;
					var9 = field752;
					Language.method3705(Tiles.tempMenuAction, var14, var9);
					Tiles.tempMenuAction = null;
				}

				field754 = false;
				itemDragDuration = 0;
				if (DevicePcmPlayerProvider.dragInventoryWidget != null) {
					ScriptEvent.invalidateWidget(DevicePcmPlayerProvider.dragInventoryWidget);
				}

				DevicePcmPlayerProvider.dragInventoryWidget = Language.getWidget(var6);
				dragItemSlotSource = var5;
				field751 = MouseHandler.MouseHandler_lastPressedX;
				field752 = MouseHandler.MouseHandler_lastPressedY;
				if (var2 >= 0) {
					class208.method4017(var2);
				}

				ScriptEvent.invalidateWidget(DevicePcmPlayerProvider.dragInventoryWidget);
			}
		}
	}

	@ObfuscatedName("hb")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1175639323"
	)
	@Export("shouldLeftClickOpenMenu")
	final boolean shouldLeftClickOpenMenu() {
		int var1 = menuOptionsCount - 1;
		boolean var3 = leftClickOpensMenu == 1 && menuOptionsCount > 2;
		if (!var3) {
			boolean var4;
			if (var1 < 0) {
				var4 = false;
			} else {
				int var5 = menuOpcodes[var1];
				if (var5 >= 2000) {
					var5 -= 2000;
				}

				if (var5 == 1007) {
					var4 = true;
				} else {
					var4 = false;
				}
			}

			var3 = var4;
		}

		return var3 && !menuShiftClick[var1];
	}

	@ObfuscatedName("hz")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-913599025"
	)
	@Export("openMenu")
	final void openMenu(int var1, int var2) {
		MouseHandler.calculateMenuBounds(var1, var2);
		class2.scene.menuOpen(ClientPacket.Client_plane, var1, var2, false);
		isMenuOpen = true;
	}

	@ObfuscatedName("il")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "731320954"
	)
	@Export("resizeRoot")
	final void resizeRoot(boolean var1) {
		WorldMapSectionType.method272(rootInterface, BoundaryObject.canvasWidth, WorldMapCacheName.canvasHeight, var1);
	}

	@ObfuscatedName("iu")
	@ObfuscatedSignature(
		signature = "(Lhl;B)V",
		garbageValue = "49"
	)
	@Export("alignWidget")
	void alignWidget(Widget var1) {
		Widget var2 = var1.parentId == -1 ? null : Language.getWidget(var1.parentId);
		int var3;
		int var4;
		if (var2 == null) {
			var3 = BoundaryObject.canvasWidth;
			var4 = WorldMapCacheName.canvasHeight;
		} else {
			var3 = var2.width;
			var4 = var2.height;
		}

		WorldMapSection1.alignWidgetSize(var1, var3, var4, false);
		PendingSpawn.alignWidgetPosition(var1, var3, var4);
	}

	@ObfuscatedName("ju")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2046016880"
	)
	final void method1503() {
		ScriptEvent.invalidateWidget(clickedWidget);
		++class3.widgetDragDuration;
		if (field823 && field820) {
			int var1 = MouseHandler.MouseHandler_x;
			int var2 = MouseHandler.MouseHandler_y;
			var1 -= widgetClickX;
			var2 -= widgetClickY;
			if (var1 < field698) {
				var1 = field698;
			}

			if (var1 + clickedWidget.width > field698 + clickedWidgetParent.width) {
				var1 = field698 + clickedWidgetParent.width - clickedWidget.width;
			}

			if (var2 < field822) {
				var2 = field822;
			}

			if (var2 + clickedWidget.height > field822 + clickedWidgetParent.height) {
				var2 = field822 + clickedWidgetParent.height - clickedWidget.height;
			}

			int var3 = var1 - field808;
			int var4 = var2 - field825;
			int var5 = clickedWidget.dragZoneSize;
			if (class3.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
				isDraggingWidget = true;
			}

			int var6 = var1 - field698 + clickedWidgetParent.scrollX;
			int var7 = var2 - field822 + clickedWidgetParent.scrollY;
			ScriptEvent var8;
			if (clickedWidget.onDrag != null && isDraggingWidget) {
				var8 = new ScriptEvent();
				var8.widget = clickedWidget;
				var8.mouseX = var6;
				var8.mouseY = var7;
				var8.args = clickedWidget.onDrag;
				WorldMapLabel.runScriptEvent(var8);
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
						WorldMapLabel.runScriptEvent(var8);
					}

					if (draggedOnWidget != null) {
						Widget var9 = clickedWidget;
						int var11 = MenuAction.getWidgetClickMask(var9);
						int var10 = var11 >> 17 & 7;
						int var12 = var10;
						Widget var17;
						if (var10 == 0) {
							var17 = null;
						} else {
							int var13 = 0;

							while (true) {
								if (var13 >= var12) {
									var17 = var9;
									break;
								}

								var9 = Language.getWidget(var9.parentId);
								if (var9 == null) {
									var17 = null;
									break;
								}

								++var13;
							}
						}

						if (var17 != null) {
							PacketBufferNode var14 = ModelData0.getPacketBufferNode(ClientPacket.field2301, packetWriter.isaacCipher);
							var14.packetBuffer.writeInt(draggedOnWidget.id);
							var14.packetBuffer.writeShort(draggedOnWidget.itemId);
							var14.packetBuffer.writeShortLE(draggedOnWidget.childIndex);
							var14.packetBuffer.method5811(clickedWidget.id);
							var14.packetBuffer.writeShort(clickedWidget.itemId);
							var14.packetBuffer.method5636(clickedWidget.childIndex);
							packetWriter.addNode(var14);
						}
					}
				} else if (this.shouldLeftClickOpenMenu()) {
					this.openMenu(widgetClickX + field808, widgetClickY + field825);
				} else if (menuOptionsCount > 0) {
					int var15 = field808 + widgetClickX;
					int var16 = field825 + widgetClickY;
					Language.method3705(Tiles.tempMenuAction, var15, var16);
					Tiles.tempMenuAction = null;
				}

				clickedWidget = null;
			}

		} else {
			if (class3.widgetDragDuration > 1) {
				clickedWidget = null;
			}

		}
	}

	@ObfuscatedName("kt")
	@ObfuscatedSignature(
		signature = "(B)Ljb;",
		garbageValue = "70"
	)
	@Export("username")
	public Username username() {
		return class215.localPlayer != null ? class215.localPlayer.username : null;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "1566884695"
	)
	static String method1749(int var0) {
		return "<img=" + var0 + ">";
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1744005886"
	)
	public static int method1655(int var0) {
		return var0 >> 11 & 63;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkj;II)Z",
		garbageValue = "-304415456"
	)
	@Export("updateExternalPlayer")
	static boolean updateExternalPlayer(PacketBuffer var0, int var1) {
		int var2 = var0.readBits(2);
		int var3;
		int var4;
		int var7;
		int var8;
		int var9;
		int var10;
		if (var2 == 0) {
			if (var0.readBits(1) != 0) {
				updateExternalPlayer(var0, var1);
			}

			var3 = var0.readBits(13);
			var4 = var0.readBits(13);
			boolean var12 = var0.readBits(1) == 1;
			if (var12) {
				Players.Players_pendingUpdateIndices[++Players.Players_pendingUpdateCount - 1] = var1;
			}

			if (players[var1] != null) {
				throw new RuntimeException();
			} else {
				Player var6 = players[var1] = new Player();
				var6.index = var1;
				if (Players.field1248[var1] != null) {
					var6.read(Players.field1248[var1]);
				}

				var6.orientation = Players.Players_orientations[var1];
				var6.targetIndex = Players.Players_targetIndices[var1];
				var7 = Players.Players_regions[var1];
				var8 = var7 >> 28;
				var9 = var7 >> 14 & 255;
				var10 = var7 & 255;
				var6.pathTraversed[0] = Players.field1247[var1];
				var6.plane = (byte)var8;
				var6.resetPath((var9 << 13) + var3 - class51.baseX * 64, (var10 << 13) + var4 - VarcInt.baseY * 64);
				var6.field630 = false;
				return true;
			}
		} else if (var2 == 1) {
			var3 = var0.readBits(2);
			var4 = Players.Players_regions[var1];
			Players.Players_regions[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
			return false;
		} else {
			int var5;
			int var11;
			if (var2 == 2) {
				var3 = var0.readBits(5);
				var4 = var3 >> 3;
				var5 = var3 & 7;
				var11 = Players.Players_regions[var1];
				var7 = (var11 >> 28) + var4 & 3;
				var8 = var11 >> 14 & 255;
				var9 = var11 & 255;
				if (var5 == 0) {
					--var8;
					--var9;
				}

				if (var5 == 1) {
					--var9;
				}

				if (var5 == 2) {
					++var8;
					--var9;
				}

				if (var5 == 3) {
					--var8;
				}

				if (var5 == 4) {
					++var8;
				}

				if (var5 == 5) {
					--var8;
					++var9;
				}

				if (var5 == 6) {
					++var9;
				}

				if (var5 == 7) {
					++var8;
					++var9;
				}

				Players.Players_regions[var1] = (var8 << 14) + var9 + (var7 << 28);
				return false;
			} else {
				var3 = var0.readBits(18);
				var4 = var3 >> 16;
				var5 = var3 >> 8 & 255;
				var11 = var3 & 255;
				var7 = Players.Players_regions[var1];
				var8 = (var7 >> 28) + var4 & 3;
				var9 = var5 + (var7 >> 14) & 255;
				var10 = var11 + var7 & 255;
				Players.Players_regions[var1] = (var9 << 14) + var10 + (var8 << 28);
				return false;
			}
		}
	}

	@ObfuscatedName("hx")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-360381512"
	)
	static final void method1746(int var0) {
		int[] var1 = Interpreter.sceneMinimapSprite.pixels;
		int var2 = var1.length;

		int var3;
		for (var3 = 0; var3 < var2; ++var3) {
			var1[var3] = 0;
		}

		int var4;
		int var5;
		for (var3 = 1; var3 < 103; ++var3) {
			var4 = (103 - var3) * 2048 + 24628;

			for (var5 = 1; var5 < 103; ++var5) {
				if ((Tiles.Tiles_renderFlags[var0][var5][var3] & 24) == 0) {
					class2.scene.drawTileMinimap(var1, var4, 512, var0, var5, var3);
				}

				if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var5][var3] & 8) != 0) {
					class2.scene.drawTileMinimap(var1, var4, 512, var0 + 1, var5, var3);
				}

				var4 += 4;
			}
		}

		var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
		var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
		Interpreter.sceneMinimapSprite.setRaster();

		int var6;
		for (var5 = 1; var5 < 103; ++var5) {
			for (var6 = 1; var6 < 103; ++var6) {
				if ((Tiles.Tiles_renderFlags[var0][var6][var5] & 24) == 0) {
					World.drawObject(var0, var6, var5, var3, var4);
				}

				if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var6][var5] & 8) != 0) {
					World.drawObject(var0 + 1, var6, var5, var3, var4);
				}
			}
		}

		mapIconCount = 0;

		for (var5 = 0; var5 < 104; ++var5) {
			for (var6 = 0; var6 < 104; ++var6) {
				long var7 = class2.scene.getFloorDecorationTag(ClientPacket.Client_plane, var5, var6);
				if (var7 != 0L) {
					int var9 = ItemContainer.Entity_unpackID(var7);
					int var10 = Occluder.getObjectDefinition(var9).mapIconId;
					if (var10 >= 0) {
						mapIcons[mapIconCount] = Varcs.WorldMapElement_get(var10).getSpriteBool(false);
						mapIconXs[mapIconCount] = var5;
						mapIconYs[mapIconCount] = var6;
						++mapIconCount;
					}
				}
			}
		}

		DirectByteArrayCopier.rasterProvider.apply();
	}
}
