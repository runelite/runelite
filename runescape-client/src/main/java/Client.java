import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;
import netscape.javascript.JSObject;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameShell implements Usernamed {
	@ObfuscatedName("mk")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	@Export("clickedWidget")
	static Widget clickedWidget;
	@ObfuscatedName("om")
	@ObfuscatedGetter(
		intValue = -556975935
	)
	@Export("rootWidgetCount")
	static int rootWidgetCount;
	@ObfuscatedName("ol")
	@ObfuscatedGetter(
		intValue = -659707133
	)
	static int field638;
	@ObfuscatedName("og")
	@ObfuscatedGetter(
		longValue = -2357868230662320483L
	)
	static long field754;
	@ObfuscatedName("ot")
	static boolean[] field841;
	@ObfuscatedName("oi")
	static boolean[] field847;
	@ObfuscatedName("nj")
	static boolean field817;
	@ObfuscatedName("op")
	static boolean[] field842;
	@ObfuscatedName("nm")
	static boolean field814;
	@ObfuscatedName("ox")
	@Export("isResizable")
	static boolean isResizable;
	@ObfuscatedName("nt")
	@ObfuscatedGetter(
		intValue = 1655703121
	)
	@Export("cycleCntr")
	static int cycleCntr;
	@ObfuscatedName("sj")
	@ObfuscatedGetter(
		intValue = 11492349
	)
	public static int field905;
	@ObfuscatedName("ng")
	@ObfuscatedGetter(
		intValue = -1435027681
	)
	static int field744;
	@ObfuscatedName("mb")
	@ObfuscatedGetter(
		intValue = -1276072491
	)
	@Export("widgetClickX")
	static int widgetClickX;
	@ObfuscatedName("qr")
	static boolean field759;
	@ObfuscatedName("mv")
	@ObfuscatedGetter(
		intValue = 2043143959
	)
	@Export("widgetClickY")
	static int widgetClickY;
	@ObfuscatedName("na")
	@ObfuscatedGetter(
		intValue = -868722211
	)
	static int field695;
	@ObfuscatedName("me")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	@Export("clickedWidgetParent")
	static Widget clickedWidgetParent;
	@ObfuscatedName("md")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("interfaceParents")
	static NodeHashTable interfaceParents;
	@ObfuscatedName("nl")
	@ObfuscatedGetter(
		intValue = 194862223
	)
	static int field816;
	@ObfuscatedName("oy")
	@Export("rootWidgetXs")
	static int[] rootWidgetXs;
	@ObfuscatedName("oq")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("widgetClickMasks")
	static NodeHashTable widgetClickMasks;
	@ObfuscatedName("oe")
	@Export("rootWidgetWidths")
	static int[] rootWidgetWidths;
	@ObfuscatedName("ms")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	@Export("viewportWidget")
	static Widget viewportWidget;
	@ObfuscatedName("oz")
	@ObfuscatedGetter(
		intValue = 1348758997
	)
	@Export("gameDrawingMode")
	static int gameDrawingMode;
	@ObfuscatedName("ow")
	@Export("rootWidgetHeights")
	static int[] rootWidgetHeights;
	@ObfuscatedName("my")
	@ObfuscatedGetter(
		intValue = -2028586371
	)
	@Export("staffModLevel")
	public static int staffModLevel;
	@ObfuscatedName("ov")
	@Export("rootWidgetYs")
	static int[] rootWidgetYs;
	@ObfuscatedName("nk")
	@ObfuscatedGetter(
		intValue = -1019005303
	)
	static int field818;
	@ObfuscatedName("pl")
	@ObfuscatedGetter(
		intValue = 858875897
	)
	@Export("destinationX")
	static int destinationX;
	@ObfuscatedName("tb")
	@ObfuscatedSignature(
		signature = "Lbu;"
	)
	static final class65 field909;
	@ObfuscatedName("np")
	@ObfuscatedGetter(
		intValue = 1046894235
	)
	static int field819;
	@ObfuscatedName("px")
	@ObfuscatedGetter(
		intValue = 242208529
	)
	@Export("destinationY")
	static int destinationY;
	@ObfuscatedName("oh")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("scriptEvents")
	static NodeDeque scriptEvents;
	@ObfuscatedName("nq")
	@ObfuscatedGetter(
		intValue = -861923243
	)
	static int field833;
	@ObfuscatedName("tg")
	static int[] field910;
	@ObfuscatedName("nc")
	@Export("isDraggingWidget")
	static boolean isDraggingWidget;
	@ObfuscatedName("td")
	static int[] field911;
	@ObfuscatedName("nv")
	@ObfuscatedGetter(
		intValue = 826785605
	)
	static int field832;
	@ObfuscatedName("qz")
	@Export("isCameraLocked")
	static boolean isCameraLocked;
	@ObfuscatedName("mx")
	@ObfuscatedGetter(
		intValue = -140222153
	)
	@Export("runEnergy")
	static int runEnergy;
	@ObfuscatedName("qb")
	@ObfuscatedGetter(
		intValue = -910754411
	)
	static int field666;
	@ObfuscatedName("mo")
	@ObfuscatedGetter(
		intValue = -1946560921
	)
	@Export("weight")
	static int weight;
	@ObfuscatedName("qa")
	@ObfuscatedGetter(
		intValue = 892519291
	)
	static int field868;
	@ObfuscatedName("no")
	static int[] field820;
	@ObfuscatedName("nb")
	@ObfuscatedGetter(
		intValue = -1905651311
	)
	static int field830;
	@ObfuscatedName("nw")
	@ObfuscatedGetter(
		intValue = -330072185
	)
	static int field825;
	@ObfuscatedName("mw")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	@Export("draggedOnWidget")
	static Widget draggedOnWidget;
	@ObfuscatedName("sl")
	@ObfuscatedGetter(
		intValue = -897184099
	)
	static int field900;
	@ObfuscatedName("ru")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	@Export("playerAppearance")
	static PlayerAppearance playerAppearance;
	@ObfuscatedName("on")
	@ObfuscatedGetter(
		intValue = -1310890605
	)
	@Export("mouseWheelRotation")
	static int mouseWheelRotation;
	@ObfuscatedName("mj")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	@Export("meslayerContinueWidget")
	static Widget meslayerContinueWidget;
	@ObfuscatedName("qm")
	@ObfuscatedGetter(
		intValue = -1177667309
	)
	@Export("soundEffectCount")
	static int soundEffectCount;
	@ObfuscatedName("sn")
	@ObfuscatedGetter(
		intValue = 2123814989
	)
	static int field901;
	@ObfuscatedName("qh")
	@Export("soundEffectIds")
	static int[] soundEffectIds;
	@ObfuscatedName("qw")
	@Export("queuedSoundEffectLoops")
	static int[] queuedSoundEffectLoops;
	@ObfuscatedName("sa")
	@ObfuscatedSignature(
		signature = "[Li;"
	)
	@Export("grandExchangeOffers")
	static GrandExchangeOffer[] grandExchangeOffers;
	@ObfuscatedName("qx")
	@Export("queuedSoundEffectDelays")
	static int[] queuedSoundEffectDelays;
	@ObfuscatedName("qt")
	@ObfuscatedSignature(
		signature = "[Lcm;"
	)
	@Export("soundEffects")
	static SoundEffect[] soundEffects;
	@ObfuscatedName("ql")
	@Export("soundLocations")
	static int[] soundLocations;
	@ObfuscatedName("nn")
	@ObfuscatedGetter(
		intValue = 1294400327
	)
	static int field831;
	@ObfuscatedName("qf")
	@ObfuscatedGetter(
		intValue = 1977131521
	)
	@Export("minimapState")
	static int minimapState;
	@ObfuscatedName("si")
	@Export("archiveLoaders")
	static ArrayList archiveLoaders;
	@ObfuscatedName("se")
	@ObfuscatedGetter(
		intValue = 426040267
	)
	@Export("archiveLoadersDone")
	static int archiveLoadersDone;
	@ObfuscatedName("rm")
	static boolean[] field835;
	@ObfuscatedName("pz")
	static long[] field889;
	@ObfuscatedName("rk")
	static int[] field882;
	@ObfuscatedName("pi")
	@ObfuscatedGetter(
		longValue = -2403274902957123209L
	)
	static long field860;
	@ObfuscatedName("rl")
	static int[] field883;
	@ObfuscatedName("nu")
	static int[] field782;
	@ObfuscatedName("rh")
	static int[] field884;
	@ObfuscatedName("ne")
	@ObfuscatedGetter(
		intValue = -1128248371
	)
	static int field823;
	@ObfuscatedName("rj")
	static int[] field885;
	@ObfuscatedName("pr")
	@ObfuscatedGetter(
		intValue = -1812154483
	)
	static int field856;
	@ObfuscatedName("su")
	@ObfuscatedSignature(
		signature = "Lly;"
	)
	@Export("platformInfoProvider")
	static PlatformInfoProvider platformInfoProvider;
	@ObfuscatedName("pt")
	@ObfuscatedGetter(
		intValue = -1929025607
	)
	static int field643;
	@ObfuscatedName("pv")
	@ObfuscatedGetter(
		intValue = -1079323191
	)
	@Export("mapIconCount")
	static int mapIconCount;
	@ObfuscatedName("ps")
	@Export("mapIconXs")
	static int[] mapIconXs;
	@ObfuscatedName("qi")
	@ObfuscatedGetter(
		intValue = -114703177
	)
	static int field761;
	@ObfuscatedName("pu")
	@Export("mapIconYs")
	static int[] mapIconYs;
	@ObfuscatedName("rt")
	static short field880;
	@ObfuscatedName("re")
	static short field887;
	@ObfuscatedName("rd")
	static short field892;
	@ObfuscatedName("pg")
	@ObfuscatedSignature(
		signature = "[Llf;"
	)
	@Export("mapIcons")
	static Sprite[] mapIcons;
	@ObfuscatedName("rr")
	static short field893;
	@ObfuscatedName("ra")
	static short field891;
	@ObfuscatedName("rf")
	@ObfuscatedGetter(
		intValue = 720626183
	)
	@Export("viewportZoom")
	static int viewportZoom;
	@ObfuscatedName("ri")
	static short field686;
	@ObfuscatedName("rz")
	@ObfuscatedGetter(
		intValue = 806304417
	)
	@Export("viewportWidth")
	static int viewportWidth;
	@ObfuscatedName("nh")
	@ObfuscatedGetter(
		intValue = 1691099913
	)
	@Export("chatCycle")
	static int chatCycle;
	@ObfuscatedName("pa")
	@ObfuscatedGetter(
		intValue = 168765299
	)
	@Export("tradeChatMode")
	static int tradeChatMode;
	@ObfuscatedName("pw")
	@ObfuscatedGetter(
		intValue = 253399583
	)
	@Export("publicChatMode")
	static int publicChatMode;
	@ObfuscatedName("qj")
	@ObfuscatedGetter(
		intValue = -1492029485
	)
	@Export("soundEffectVolume")
	static int soundEffectVolume;
	@ObfuscatedName("ro")
	@ObfuscatedGetter(
		intValue = -1929841361
	)
	@Export("viewportHeight")
	static int viewportHeight;
	@ObfuscatedName("rc")
	@ObfuscatedGetter(
		intValue = -1154982749
	)
	@Export("viewportOffsetX")
	static int viewportOffsetX;
	@ObfuscatedName("nz")
	@Export("changedSkills")
	static int[] changedSkills;
	@ObfuscatedName("rb")
	@ObfuscatedGetter(
		intValue = -654475437
	)
	@Export("viewportOffsetY")
	static int viewportOffsetY;
	@ObfuscatedName("nd")
	@ObfuscatedGetter(
		intValue = -15935377
	)
	@Export("changedSkillsCount")
	static int changedSkillsCount;
	@ObfuscatedName("rp")
	@Export("zoomWidth")
	static short zoomWidth;
	@ObfuscatedName("ma")
	@ObfuscatedGetter(
		intValue = 42533643
	)
	@Export("chatEffects")
	static int chatEffects;
	@ObfuscatedName("rg")
	@Export("zoomHeight")
	static short zoomHeight;
	@ObfuscatedName("mr")
	@ObfuscatedGetter(
		intValue = -382576035
	)
	static int field873;
	@ObfuscatedName("sr")
	@ObfuscatedGetter(
		intValue = -1773628049
	)
	static int field908;
	@ObfuscatedName("pf")
	@ObfuscatedGetter(
		intValue = -1367796571
	)
	static int field857;
	@ObfuscatedName("mq")
	@ObfuscatedGetter(
		intValue = 494577071
	)
	@Export("followerIndex")
	static int followerIndex;
	@ObfuscatedName("mt")
	@Export("playerMod")
	static boolean playerMod;
	@ObfuscatedName("pm")
	static int[] field859;
	@ObfuscatedName("po")
	static int[] field858;
	@ObfuscatedName("os")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	static NodeDeque field836;
	@ObfuscatedName("ob")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	static NodeDeque field763;
	@ObfuscatedName("mc")
	@ObfuscatedGetter(
		intValue = -1507863629
	)
	static int field798;
	@ObfuscatedName("mz")
	@ObfuscatedGetter(
		intValue = -1296819247
	)
	static int field824;
	@ObfuscatedName("ph")
	static int[] field851;
	@ObfuscatedName("pd")
	static String field907;
	@ObfuscatedName("sx")
	@ObfuscatedSignature(
		signature = "Lbb;"
	)
	@Export("GrandExchangeEvents_worldComparator")
	static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "[Lfa;"
	)
	@Export("collisionMaps")
	static CollisionMap[] collisionMaps;
	@ObfuscatedName("at")
	static boolean field802;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = 1846758827
	)
	@Export("worldId")
	public static int worldId;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = -1282298749
	)
	@Export("worldProperties")
	static int worldProperties;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = -744372313
	)
	@Export("gameBuild")
	static int gameBuild;
	@ObfuscatedName("bs")
	@Export("isMembersWorld")
	public static boolean isMembersWorld;
	@ObfuscatedName("bz")
	@Export("isLowDetail")
	static boolean isLowDetail;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = -1434422805
	)
	@Export("clientType")
	static int clientType;
	@ObfuscatedName("bu")
	@Export("onMobile")
	static boolean onMobile;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = -1513198459
	)
	@Export("gameState")
	static int gameState;
	@ObfuscatedName("cn")
	@Export("isLoading")
	static boolean isLoading;
	@ObfuscatedName("cd")
	@ObfuscatedGetter(
		intValue = 1080568465
	)
	@Export("cycle")
	static int cycle;
	@ObfuscatedName("cy")
	@ObfuscatedGetter(
		longValue = -5290188514648997903L
	)
	@Export("mouseLastLastPressedTimeMillis")
	static long mouseLastLastPressedTimeMillis;
	@ObfuscatedName("cb")
	@ObfuscatedGetter(
		intValue = -445977517
	)
	static int field646;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = -624148243
	)
	static int field647;
	@ObfuscatedName("ct")
	@ObfuscatedGetter(
		longValue = -8037513059658187963L
	)
	static long field648;
	@ObfuscatedName("ci")
	@Export("hadFocus")
	static boolean hadFocus;
	@ObfuscatedName("cu")
	@Export("displayFps")
	static boolean displayFps;
	@ObfuscatedName("ce")
	@ObfuscatedGetter(
		intValue = -1130052375
	)
	@Export("rebootTimer")
	static int rebootTimer;
	@ObfuscatedName("cc")
	@ObfuscatedGetter(
		intValue = 2049608033
	)
	@Export("hintArrowType")
	static int hintArrowType;
	@ObfuscatedName("cl")
	@ObfuscatedGetter(
		intValue = 648504057
	)
	@Export("hintArrowNpcIndex")
	static int hintArrowNpcIndex;
	@ObfuscatedName("cw")
	@ObfuscatedGetter(
		intValue = 275182897
	)
	@Export("hintArrowPlayerIndex")
	static int hintArrowPlayerIndex;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = 1932039353
	)
	@Export("hintArrowX")
	static int hintArrowX;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		intValue = -204101851
	)
	@Export("hintArrowY")
	static int hintArrowY;
	@ObfuscatedName("cf")
	@ObfuscatedGetter(
		intValue = 1548574994
	)
	@Export("hintArrowHeight")
	static int hintArrowHeight;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = -759871936
	)
	@Export("hintArrowSubX")
	static int hintArrowSubX;
	@ObfuscatedName("cm")
	@ObfuscatedGetter(
		intValue = 99349824
	)
	@Export("hintArrowSubY")
	static int hintArrowSubY;
	@ObfuscatedName("ch")
	@ObfuscatedSignature(
		signature = "Lcn;"
	)
	@Export("playerAttackOption")
	static AttackOption playerAttackOption;
	@ObfuscatedName("dt")
	@ObfuscatedSignature(
		signature = "Lcn;"
	)
	@Export("npcAttackOption")
	static AttackOption npcAttackOption;
	@ObfuscatedName("dm")
	@ObfuscatedGetter(
		intValue = 963568873
	)
	@Export("titleLoadingStage")
	static int titleLoadingStage;
	@ObfuscatedName("dy")
	@ObfuscatedGetter(
		intValue = 584801883
	)
	@Export("js5ConnectState")
	static int js5ConnectState;
	@ObfuscatedName("de")
	@ObfuscatedGetter(
		intValue = -900928897
	)
	static int field664;
	@ObfuscatedName("dd")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive10")
	static Archive archive10;
	@ObfuscatedName("ef")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive17")
	static Archive archive17;
	@ObfuscatedName("ew")
	@ObfuscatedGetter(
		intValue = 982456973
	)
	@Export("js5Errors")
	static int js5Errors;
	@ObfuscatedName("eq")
	@ObfuscatedGetter(
		intValue = -14383853
	)
	@Export("loginState")
	static int loginState;
	@ObfuscatedName("er")
	@ObfuscatedGetter(
		intValue = -1286153331
	)
	static int field669;
	@ObfuscatedName("eo")
	@ObfuscatedGetter(
		intValue = 1787272407
	)
	static int field670;
	@ObfuscatedName("ee")
	@ObfuscatedGetter(
		intValue = 460753713
	)
	static int field671;
	@ObfuscatedName("ep")
	@ObfuscatedSignature(
		signature = "Lff;"
	)
	static class160 field672;
	@ObfuscatedName("ev")
	@Export("Login_isUsernameRemembered")
	static boolean Login_isUsernameRemembered;
	@ObfuscatedName("ez")
	@ObfuscatedSignature(
		signature = "Lcb;"
	)
	@Export("secureRandomFuture")
	static SecureRandomFuture secureRandomFuture;
	@ObfuscatedName("ed")
	@Export("randomDatData")
	static byte[] randomDatData;
	@ObfuscatedName("et")
	@ObfuscatedSignature(
		signature = "[Lck;"
	)
	@Export("npcs")
	static NPC[] npcs;
	@ObfuscatedName("eb")
	@ObfuscatedGetter(
		intValue = -347893507
	)
	@Export("npcCount")
	static int npcCount;
	@ObfuscatedName("fb")
	@Export("npcIndices")
	static int[] npcIndices;
	@ObfuscatedName("fe")
	@ObfuscatedGetter(
		intValue = -1928648709
	)
	static int field633;
	@ObfuscatedName("fd")
	static int[] field681;
	@ObfuscatedName("fo")
	@ObfuscatedSignature(
		signature = "Lcl;"
	)
	@Export("packetWriter")
	public static final PacketWriter packetWriter;
	@ObfuscatedName("fq")
	@ObfuscatedGetter(
		intValue = -1810258911
	)
	@Export("logoutTimer")
	static int logoutTimer;
	@ObfuscatedName("fc")
	static boolean field730;
	@ObfuscatedName("fv")
	@Export("useBufferedSocket")
	static boolean useBufferedSocket;
	@ObfuscatedName("fm")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("timer")
	static Timer timer;
	@ObfuscatedName("fh")
	@ObfuscatedSignature(
		signature = "Len;"
	)
	@Export("urlRequester")
	static UrlRequester urlRequester;
	@ObfuscatedName("fa")
	@Export("fontsMap")
	static HashMap fontsMap;
	@ObfuscatedName("fj")
	@ObfuscatedGetter(
		intValue = 543460729
	)
	static int field689;
	@ObfuscatedName("fx")
	@ObfuscatedGetter(
		intValue = -1697289513
	)
	static int field690;
	@ObfuscatedName("fp")
	@ObfuscatedGetter(
		intValue = -355199335
	)
	static int field691;
	@ObfuscatedName("gv")
	@ObfuscatedGetter(
		intValue = 1416543095
	)
	static int field692;
	@ObfuscatedName("gy")
	@ObfuscatedGetter(
		intValue = 1539626603
	)
	static int field693;
	@ObfuscatedName("gl")
	@Export("isInInstance")
	static boolean isInInstance;
	@ObfuscatedName("gs")
	@Export("instanceChunkTemplates")
	static int[][][] instanceChunkTemplates;
	@ObfuscatedName("gm")
	static final int[] field697;
	@ObfuscatedName("gf")
	@ObfuscatedGetter(
		intValue = -2045474947
	)
	static int field698;
	@ObfuscatedName("hh")
	@ObfuscatedGetter(
		intValue = -1078673109
	)
	static int field699;
	@ObfuscatedName("ht")
	@ObfuscatedGetter(
		intValue = 1330821821
	)
	static int field700;
	@ObfuscatedName("hk")
	@ObfuscatedGetter(
		intValue = -1693078415
	)
	static int field701;
	@ObfuscatedName("hz")
	@ObfuscatedGetter(
		intValue = -572241931
	)
	static int field702;
	@ObfuscatedName("hl")
	static boolean field703;
	@ObfuscatedName("hb")
	@ObfuscatedGetter(
		intValue = -1280891227
	)
	@Export("alternativeScrollbarWidth")
	static int alternativeScrollbarWidth;
	@ObfuscatedName("hm")
	@ObfuscatedGetter(
		intValue = -851788043
	)
	@Export("camAngleX")
	static int camAngleX;
	@ObfuscatedName("hu")
	@ObfuscatedGetter(
		intValue = 1157777555
	)
	@Export("camAngleY")
	static int camAngleY;
	@ObfuscatedName("hi")
	@ObfuscatedGetter(
		intValue = 56611529
	)
	@Export("camAngleDY")
	static int camAngleDY;
	@ObfuscatedName("hx")
	@ObfuscatedGetter(
		intValue = 594555395
	)
	@Export("camAngleDX")
	static int camAngleDX;
	@ObfuscatedName("hf")
	@ObfuscatedGetter(
		intValue = 1391902969
	)
	@Export("mouseCamClickedX")
	static int mouseCamClickedX;
	@ObfuscatedName("hd")
	@ObfuscatedGetter(
		intValue = -148858111
	)
	@Export("mouseCamClickedY")
	static int mouseCamClickedY;
	@ObfuscatedName("hw")
	@ObfuscatedGetter(
		intValue = 1963305499
	)
	@Export("oculusOrbState")
	static int oculusOrbState;
	@ObfuscatedName("hj")
	@ObfuscatedGetter(
		intValue = -844153885
	)
	@Export("camFollowHeight")
	static int camFollowHeight;
	@ObfuscatedName("hc")
	@ObfuscatedGetter(
		intValue = -1192657817
	)
	static int field766;
	@ObfuscatedName("hp")
	@ObfuscatedGetter(
		intValue = -1637520021
	)
	static int field714;
	@ObfuscatedName("ih")
	@ObfuscatedGetter(
		intValue = -1473797019
	)
	static int field715;
	@ObfuscatedName("io")
	@ObfuscatedGetter(
		intValue = -925368297
	)
	@Export("oculusOrbNormalSpeed")
	static int oculusOrbNormalSpeed;
	@ObfuscatedName("ib")
	@ObfuscatedGetter(
		intValue = -1611804213
	)
	@Export("oculusOrbSlowedSpeed")
	static int oculusOrbSlowedSpeed;
	@ObfuscatedName("im")
	@ObfuscatedGetter(
		intValue = -1513473005
	)
	static int field718;
	@ObfuscatedName("ig")
	static boolean field879;
	@ObfuscatedName("iq")
	@ObfuscatedGetter(
		intValue = 773031175
	)
	static int field720;
	@ObfuscatedName("ij")
	static boolean field721;
	@ObfuscatedName("is")
	@ObfuscatedGetter(
		intValue = 130801757
	)
	static int field722;
	@ObfuscatedName("ik")
	@ObfuscatedGetter(
		intValue = -1967946355
	)
	@Export("overheadTextCount")
	static int overheadTextCount;
	@ObfuscatedName("iu")
	@ObfuscatedGetter(
		intValue = 2101736993
	)
	@Export("overheadTextLimit")
	static int overheadTextLimit;
	@ObfuscatedName("iy")
	@Export("overheadTextXs")
	static int[] overheadTextXs;
	@ObfuscatedName("ip")
	@Export("overheadTextYs")
	static int[] overheadTextYs;
	@ObfuscatedName("iw")
	@Export("overheadTextAscents")
	static int[] overheadTextAscents;
	@ObfuscatedName("id")
	@Export("overheadTextXOffsets")
	static int[] overheadTextXOffsets;
	@ObfuscatedName("if")
	@Export("overheadTextColors")
	static int[] overheadTextColors;
	@ObfuscatedName("ir")
	@Export("overheadTextEffects")
	static int[] overheadTextEffects;
	@ObfuscatedName("ia")
	@Export("overheadTextCyclesRemaining")
	static int[] overheadTextCyclesRemaining;
	@ObfuscatedName("iv")
	@Export("overheadText")
	static String[] overheadText;
	@ObfuscatedName("it")
	@Export("selectedItemName")
	static String selectedItemName;
	@ObfuscatedName("in")
	@Export("tileLastDrawnActor")
	static int[][] tileLastDrawnActor;
	@ObfuscatedName("il")
	@ObfuscatedGetter(
		intValue = -1976595977
	)
	@Export("viewportDrawCount")
	static int viewportDrawCount;
	@ObfuscatedName("ii")
	@ObfuscatedGetter(
		intValue = -1627292871
	)
	@Export("viewportTempX")
	static int viewportTempX;
	@ObfuscatedName("ic")
	@ObfuscatedGetter(
		intValue = -527920877
	)
	@Export("viewportTempY")
	static int viewportTempY;
	@ObfuscatedName("js")
	@ObfuscatedGetter(
		intValue = 978670267
	)
	@Export("mouseCrossX")
	static int mouseCrossX;
	@ObfuscatedName("jv")
	@ObfuscatedGetter(
		intValue = -1556961545
	)
	@Export("mouseCrossY")
	static int mouseCrossY;
	@ObfuscatedName("je")
	@ObfuscatedGetter(
		intValue = 1573914060
	)
	@Export("mouseCrossState")
	static int mouseCrossState;
	@ObfuscatedName("jt")
	@ObfuscatedGetter(
		intValue = -588599615
	)
	@Export("mouseCrossColor")
	static int mouseCrossColor;
	@ObfuscatedName("jx")
	@Export("showMouseCross")
	static boolean showMouseCross;
	@ObfuscatedName("jf")
	@ObfuscatedGetter(
		intValue = 2052271037
	)
	static int field750;
	@ObfuscatedName("jc")
	@ObfuscatedGetter(
		intValue = 2007699929
	)
	static int field743;
	@ObfuscatedName("jp")
	@ObfuscatedGetter(
		intValue = -1979890787
	)
	@Export("dragItemSlotSource")
	static int dragItemSlotSource;
	@ObfuscatedName("jd")
	@ObfuscatedGetter(
		intValue = -438601773
	)
	static int field745;
	@ObfuscatedName("jo")
	@ObfuscatedGetter(
		intValue = -1643414129
	)
	static int field746;
	@ObfuscatedName("jh")
	@ObfuscatedGetter(
		intValue = 1036462411
	)
	@Export("dragItemSlotDestination")
	static int dragItemSlotDestination;
	@ObfuscatedName("jr")
	static boolean field748;
	@ObfuscatedName("jw")
	@ObfuscatedGetter(
		intValue = -1965230699
	)
	@Export("itemDragDuration")
	static int itemDragDuration;
	@ObfuscatedName("jb")
	@ObfuscatedGetter(
		intValue = 1577400495
	)
	static int field634;
	@ObfuscatedName("jl")
	@Export("showLoadingMessages")
	static boolean showLoadingMessages;
	@ObfuscatedName("jm")
	@ObfuscatedSignature(
		signature = "[Lbi;"
	)
	@Export("players")
	static Player[] players;
	@ObfuscatedName("jq")
	@ObfuscatedGetter(
		intValue = 87159269
	)
	@Export("localPlayerIndex")
	static int localPlayerIndex;
	@ObfuscatedName("jy")
	@ObfuscatedGetter(
		intValue = 1781220751
	)
	static int field636;
	@ObfuscatedName("jj")
	@Export("renderSelf")
	static boolean renderSelf;
	@ObfuscatedName("ki")
	@ObfuscatedGetter(
		intValue = -2014818077
	)
	@Export("drawPlayerNames")
	static int drawPlayerNames;
	@ObfuscatedName("ko")
	@ObfuscatedGetter(
		intValue = 729085131
	)
	static int field640;
	@ObfuscatedName("kr")
	static int[] field758;
	@ObfuscatedName("kn")
	@Export("playerMenuOpcodes")
	static final int[] playerMenuOpcodes;
	@ObfuscatedName("kh")
	@Export("playerMenuActions")
	static String[] playerMenuActions;
	@ObfuscatedName("kb")
	@Export("playerOptionsPriorities")
	static boolean[] playerOptionsPriorities;
	@ObfuscatedName("kz")
	@Export("defaultRotations")
	static int[] defaultRotations;
	@ObfuscatedName("kf")
	@ObfuscatedGetter(
		intValue = 722101389
	)
	@Export("combatTargetPlayerIndex")
	static int combatTargetPlayerIndex;
	@ObfuscatedName("kl")
	@ObfuscatedSignature(
		signature = "[[[Ljv;"
	)
	@Export("groundItems")
	static NodeDeque[][][] groundItems;
	@ObfuscatedName("ka")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("pendingSpawns")
	static NodeDeque pendingSpawns;
	@ObfuscatedName("kt")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("projectiles")
	static NodeDeque projectiles;
	@ObfuscatedName("kj")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("graphicsObjects")
	static NodeDeque graphicsObjects;
	@ObfuscatedName("km")
	@Export("currentLevels")
	static int[] currentLevels;
	@ObfuscatedName("ky")
	@Export("levels")
	static int[] levels;
	@ObfuscatedName("kd")
	@Export("experience")
	static int[] experience;
	@ObfuscatedName("kv")
	@ObfuscatedGetter(
		intValue = 421096745
	)
	@Export("leftClickOpensMenu")
	static int leftClickOpensMenu;
	@ObfuscatedName("kg")
	@Export("isMenuOpen")
	static boolean isMenuOpen;
	@ObfuscatedName("lw")
	@ObfuscatedGetter(
		intValue = 813297127
	)
	@Export("menuOptionsCount")
	static int menuOptionsCount;
	@ObfuscatedName("ld")
	@Export("menuArguments1")
	static int[] menuArguments1;
	@ObfuscatedName("lb")
	@Export("menuArguments2")
	static int[] menuArguments2;
	@ObfuscatedName("ls")
	@Export("menuOpcodes")
	static int[] menuOpcodes;
	@ObfuscatedName("lq")
	@Export("menuIdentifiers")
	static int[] menuIdentifiers;
	@ObfuscatedName("ll")
	@Export("menuActions")
	static String[] menuActions;
	@ObfuscatedName("ln")
	@Export("menuTargets")
	static String[] menuTargets;
	@ObfuscatedName("lx")
	@Export("menuShiftClick")
	static boolean[] menuShiftClick;
	@ObfuscatedName("lm")
	@Export("followerOpsLowPriority")
	static boolean followerOpsLowPriority;
	@ObfuscatedName("lp")
	@Export("shiftClickDrop")
	static boolean shiftClickDrop;
	@ObfuscatedName("lf")
	@Export("tapToDrop")
	static boolean tapToDrop;
	@ObfuscatedName("lo")
	@Export("showMouseOverText")
	static boolean showMouseOverText;
	@ObfuscatedName("lh")
	@ObfuscatedGetter(
		intValue = -1819095265
	)
	@Export("viewportX")
	static int viewportX;
	@ObfuscatedName("lg")
	@ObfuscatedGetter(
		intValue = -546279315
	)
	@Export("viewportY")
	static int viewportY;
	@ObfuscatedName("lj")
	@ObfuscatedGetter(
		intValue = 509497683
	)
	static int field787;
	@ObfuscatedName("la")
	@ObfuscatedGetter(
		intValue = 1721267483
	)
	static int field788;
	@ObfuscatedName("lr")
	@ObfuscatedGetter(
		intValue = 241697491
	)
	@Export("isItemSelected")
	static int isItemSelected;
	@ObfuscatedName("lz")
	@Export("isSpellSelected")
	static boolean isSpellSelected;
	@ObfuscatedName("li")
	@ObfuscatedGetter(
		intValue = -133249451
	)
	@Export("selectedSpellChildIndex")
	static int selectedSpellChildIndex;
	@ObfuscatedName("mp")
	@ObfuscatedGetter(
		intValue = -1549196691
	)
	static int field793;
	@ObfuscatedName("mf")
	@Export("selectedSpellActionName")
	static String selectedSpellActionName;
	@ObfuscatedName("mm")
	@Export("selectedSpellName")
	static String selectedSpellName;
	@ObfuscatedName("mh")
	@ObfuscatedGetter(
		intValue = 1431344687
	)
	@Export("rootInterface")
	static int rootInterface;

	static {
		field802 = true;
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
		mouseLastLastPressedTimeMillis = -1L;
		field646 = -1;
		field647 = -1;
		field648 = -1L;
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
		field664 = 0;
		js5Errors = 0;
		loginState = 0;
		field669 = 0;
		field670 = 0;
		field671 = 0;
		field672 = class160.field1985;
		Login_isUsernameRemembered = false;
		secureRandomFuture = new SecureRandomFuture();
		randomDatData = null;
		npcs = new NPC[32768];
		npcCount = 0;
		npcIndices = new int[32768];
		field633 = 0;
		field681 = new int[250];
		packetWriter = new PacketWriter();
		logoutTimer = 0;
		field730 = false;
		useBufferedSocket = true;
		timer = new Timer();
		fontsMap = new HashMap();
		field689 = 0;
		field690 = 1;
		field691 = 0;
		field692 = 1;
		field693 = 0;
		collisionMaps = new CollisionMap[4];
		isInInstance = false;
		instanceChunkTemplates = new int[4][13][13];
		field697 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
		field698 = 0;
		field699 = 2301979;
		field700 = 5063219;
		field701 = 3353893;
		field702 = 7759444;
		field703 = false;
		alternativeScrollbarWidth = 0;
		camAngleX = 128;
		camAngleY = 0;
		camAngleDY = 0;
		camAngleDX = 0;
		mouseCamClickedX = 0;
		mouseCamClickedY = 0;
		oculusOrbState = 0;
		camFollowHeight = 50;
		field766 = 0;
		field714 = 0;
		field715 = 0;
		oculusOrbNormalSpeed = 12;
		oculusOrbSlowedSpeed = 6;
		field718 = 0;
		field879 = false;
		field720 = 0;
		field721 = false;
		field722 = 0;
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
		field750 = 0;
		field743 = 0;
		dragItemSlotSource = 0;
		field745 = 0;
		field746 = 0;
		dragItemSlotDestination = 0;
		field748 = false;
		itemDragDuration = 0;
		field634 = 0;
		showLoadingMessages = true;
		players = new Player[2048];
		localPlayerIndex = -1;
		field636 = 0;
		renderSelf = true;
		drawPlayerNames = 0;
		field640 = 0;
		field758 = new int[1000];
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
		field787 = 0;
		field788 = 50;
		isItemSelected = 0;
		selectedItemName = null;
		isSpellSelected = false;
		selectedSpellChildIndex = -1;
		field793 = -1;
		selectedSpellActionName = null;
		selectedSpellName = null;
		rootInterface = -1;
		interfaceParents = new NodeHashTable(8);
		field798 = 0;
		field824 = -1;
		chatEffects = 0;
		field873 = 0;
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
		field814 = false;
		field695 = -1;
		field816 = -1;
		field817 = false;
		field818 = -1;
		field819 = -1;
		isDraggingWidget = false;
		cycleCntr = 1;
		field782 = new int[32];
		field823 = 0;
		field820 = new int[32];
		field825 = 0;
		changedSkills = new int[32];
		changedSkillsCount = 0;
		chatCycle = 0;
		field744 = 0;
		field830 = 0;
		field831 = 0;
		field832 = 0;
		field833 = 0;
		mouseWheelRotation = 0;
		scriptEvents = new NodeDeque();
		field836 = new NodeDeque();
		field763 = new NodeDeque();
		widgetClickMasks = new NodeHashTable(512);
		rootWidgetCount = 0;
		field638 = -2;
		field841 = new boolean[100];
		field842 = new boolean[100];
		field847 = new boolean[100];
		rootWidgetXs = new int[100];
		rootWidgetYs = new int[100];
		rootWidgetWidths = new int[100];
		rootWidgetHeights = new int[100];
		gameDrawingMode = 0;
		field754 = 0L;
		isResizable = true;
		field851 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
		publicChatMode = 0;
		tradeChatMode = 0;
		field907 = "";
		field889 = new long[100];
		field856 = 0;
		field857 = 0;
		field858 = new int[128];
		field859 = new int[128];
		field860 = -1L;
		field643 = -1;
		mapIconCount = 0;
		mapIconXs = new int[1000];
		mapIconYs = new int[1000];
		mapIcons = new Sprite[1000];
		destinationX = 0;
		destinationY = 0;
		minimapState = 0;
		field761 = 255;
		field666 = -1;
		field759 = false;
		soundEffectVolume = 127;
		field868 = 127;
		soundEffectCount = 0;
		soundEffectIds = new int[50];
		queuedSoundEffectLoops = new int[50];
		queuedSoundEffectDelays = new int[50];
		soundLocations = new int[50];
		soundEffects = new SoundEffect[50];
		isCameraLocked = false;
		field835 = new boolean[5];
		field882 = new int[5];
		field883 = new int[5];
		field884 = new int[5];
		field885 = new int[5];
		field880 = 256;
		field887 = 205;
		zoomHeight = 256;
		zoomWidth = 320;
		field686 = 1;
		field891 = 32767;
		field892 = 1;
		field893 = 32767;
		viewportOffsetX = 0;
		viewportOffsetY = 0;
		viewportWidth = 0;
		viewportHeight = 0;
		viewportZoom = 0;
		playerAppearance = new PlayerAppearance();
		field900 = -1;
		field901 = -1;
		platformInfoProvider = new DesktopPlatformInfoProvider();
		grandExchangeOffers = new GrandExchangeOffer[8];
		GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
		field905 = -1;
		archiveLoaders = new ArrayList(10);
		archiveLoadersDone = 0;
		field908 = 0;
		field909 = new class65();
		field910 = new int[50];
		field911 = new int[50];
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2027797509"
	)
	@Export("resizeGame")
	protected final void resizeGame() {
		field754 = class30.currentTimeMillis() + 500L;
		this.resizeJS();
		if (rootInterface != -1) {
			this.resizeRoot(true);
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "16"
	)
	@Export("setUp")
	protected final void setUp() {
		int[] var1 = new int[]{20, 260, 10000};
		int[] var2 = new int[]{1000, 100, 500};
		if (var1 != null && var2 != null) {
			ByteArrayPool.ByteArrayPool_alternativeSizes = var1;
			ByteArrayPool.ByteArrayPool_altSizeArrayCounts = new int[var1.length];
			class81.ByteArrayPool_arrays = new byte[var1.length][][];

			for (int var5 = 0; var5 < ByteArrayPool.ByteArrayPool_alternativeSizes.length; ++var5) {
				class81.ByteArrayPool_arrays[var5] = new byte[var2[var5]][];
			}
		} else {
			ByteArrayPool.ByteArrayPool_alternativeSizes = null;
			ByteArrayPool.ByteArrayPool_altSizeArrayCounts = null;
			class81.ByteArrayPool_arrays = null;
		}

		HitSplatDefinition.port1 = gameBuild == 0 ? 43594 : worldId + 40000;
		BZip2State.port2 = gameBuild == 0 ? 443 : worldId + 50000;
		NPC.port3 = HitSplatDefinition.port1;
		HorizontalAlignment.field3447 = class215.field2531;
		PlayerAppearance.field2519 = class215.field2530;
		PlayerAppearance.field2525 = class215.field2532;
		DevicePcmPlayerProvider.field390 = class215.field2529;
		urlRequester = new UrlRequester();
		this.setUpKeyboard();
		this.setUpMouse();
		KeyHandler.mouseWheel = this.mouseWheel();
		WorldMapData_0.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		AbstractArchive.clientPreferences = ItemDefinition.method4667();
		this.setUpClipboard();
		String var4 = WorldMapManager.null_string;
		class51.applet = this;
		if (var4 != null) {
			class51.field406 = var4;
		}

		if (gameBuild != 0) {
			displayFps = true;
		}

		UserComparator8.setWindowedMode(AbstractArchive.clientPreferences.windowMode);
		Tiles.friendSystem = new FriendSystem(WorldMapSection1.loginType);
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-60"
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
				break;
			}

			var1.archive.load(var1.archiveDisk, (int)var1.key, var1.data, false);
		}

		try {
			if (class197.field2386 == 1) {
				int var5 = class49.midiPcmStream.method3745();
				if (var5 > 0 && class49.midiPcmStream.isReady()) {
					var5 -= MusicPatchNode2.field2382;
					if (var5 < 0) {
						var5 = 0;
					}

					class49.midiPcmStream.method3760(var5);
				} else {
					class49.midiPcmStream.clear();
					class49.midiPcmStream.removeAll();
					if (class197.musicTrackArchive != null) {
						class197.field2386 = 2;
					} else {
						class197.field2386 = 0;
					}

					class197.musicTrack = null;
					FriendLoginUpdate.soundCache = null;
				}
			}
		} catch (Exception var9) {
			var9.printStackTrace();
			class49.midiPcmStream.clear();
			class197.field2386 = 0;
			class197.musicTrack = null;
			FriendLoginUpdate.soundCache = null;
			class197.musicTrackArchive = null;
		}

		WorldMapID.playPcmPlayers();
		synchronized(KeyHandler.KeyHandler_instance) {
			++KeyHandler.KeyHandler_idleCycles;
			KeyHandler.field378 = KeyHandler.field380;
			KeyHandler.field361 = 0;
			int var6;
			if (KeyHandler.field373 >= 0) {
				while (KeyHandler.field373 != KeyHandler.field372) {
					var6 = KeyHandler.field365[KeyHandler.field372];
					KeyHandler.field372 = KeyHandler.field372 + 1 & 127;
					if (var6 < 0) {
						KeyHandler.KeyHandler_pressedKeys[~var6] = false;
					} else {
						if (!KeyHandler.KeyHandler_pressedKeys[var6] && KeyHandler.field361 < KeyHandler.field376.length - 1) {
							KeyHandler.field376[++KeyHandler.field361 - 1] = var6;
						}

						KeyHandler.KeyHandler_pressedKeys[var6] = true;
					}
				}
			} else {
				for (var6 = 0; var6 < 112; ++var6) {
					KeyHandler.KeyHandler_pressedKeys[var6] = false;
				}

				KeyHandler.field373 = KeyHandler.field372;
			}

			if (KeyHandler.field361 > 0) {
				KeyHandler.KeyHandler_idleCycles = 0;
			}

			KeyHandler.field380 = KeyHandler.field371;
		}

		VertexNormal.method2959();
		if (KeyHandler.mouseWheel != null) {
			int var5 = KeyHandler.mouseWheel.useRotation();
			mouseWheelRotation = var5;
		}

		if (gameState == 0) {
			class189.load();
			WorldMapDecoration.method343();
		} else if (gameState == 5) {
			LoginPacket.doCycleTitle(this);
			class189.load();
			WorldMapDecoration.method343();
		} else if (gameState == 10 || gameState == 11) {
			LoginPacket.doCycleTitle(this);
		} else if (gameState == 20) {
			LoginPacket.doCycleTitle(this);
			this.doCycleLoggedOut();
		} else if (gameState == 25) {
			KeyHandler.method851();
		}

		if (gameState == 30) {
			this.doCycleLoggedIn();
		} else if (gameState == 40 || gameState == 45) {
			this.doCycleLoggedOut();
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1679134607"
	)
	@Export("draw")
	protected final void draw(boolean var1) {
		boolean var2;
		label168: {
			try {
				if (class197.field2386 == 2) {
					if (class197.musicTrack == null) {
						class197.musicTrack = MusicTrack.readTrack(class197.musicTrackArchive, class188.musicTrackGroupId, class49.musicTrackFileId);
						if (class197.musicTrack == null) {
							var2 = false;
							break label168;
						}
					}

					if (FriendLoginUpdate.soundCache == null) {
						FriendLoginUpdate.soundCache = new SoundCache(class197.soundEffectsArchive, SecureRandomCallable.musicSamplesArchive);
					}

					if (class49.midiPcmStream.loadMusicTrack(class197.musicTrack, class197.musicPatchesArchive, FriendLoginUpdate.soundCache, 22050)) {
						class49.midiPcmStream.clearAll();
						class49.midiPcmStream.method3760(TileItem.field1223);
						class49.midiPcmStream.setMusicTrack(class197.musicTrack, WorldMapSectionType.musicTrackBoolean);
						class197.field2386 = 0;
						class197.musicTrack = null;
						FriendLoginUpdate.soundCache = null;
						class197.musicTrackArchive = null;
						var2 = true;
						break label168;
					}
				}
			} catch (Exception var6) {
				var6.printStackTrace();
				class49.midiPcmStream.clear();
				class197.field2386 = 0;
				class197.musicTrack = null;
				FriendLoginUpdate.soundCache = null;
				class197.musicTrackArchive = null;
			}

			var2 = false;
		}

		if (var2 && field759 && class219.pcmPlayer0 != null) {
			class219.pcmPlayer0.tryDiscard();
		}

		if ((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field754 && class30.currentTimeMillis() > field754) {
			UserComparator8.setWindowedMode(class247.getWindowedMode());
		}

		int var4;
		if (var1) {
			for (var4 = 0; var4 < 100; ++var4) {
				field841[var4] = true;
			}
		}

		if (gameState == 0) {
			this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
		} else if (gameState == 5) {
			VarbitDefinition.drawTitle(class173.fontBold12, GrandExchangeOfferOwnWorldComparator.fontPlain11, GraphicsDefaults.fontPlain12);
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				VarbitDefinition.drawTitle(class173.fontBold12, GrandExchangeOfferOwnWorldComparator.fontPlain11, GraphicsDefaults.fontPlain12);
			} else if (gameState == 25) {
				if (field693 == 1) {
					if (field689 > field690) {
						field690 = field689;
					}

					var4 = (field690 * 50 - field689 * 50) / field690;
					WorldMapSprite.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
				} else if (field693 == 2) {
					if (field691 > field692) {
						field692 = field691;
					}

					var4 = (field692 * 50 - field691 * 50) / field692 + 50;
					WorldMapSprite.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
				} else {
					WorldMapSprite.drawLoadingMessage("Loading - please wait.", false);
				}
			} else if (gameState == 30) {
				this.drawLoggedIn();
			} else if (gameState == 40) {
				WorldMapSprite.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
			} else if (gameState == 45) {
				WorldMapSprite.drawLoadingMessage("Please wait...", false);
			}
		} else {
			VarbitDefinition.drawTitle(class173.fontBold12, GrandExchangeOfferOwnWorldComparator.fontPlain11, GraphicsDefaults.fontPlain12);
		}

		if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
			for (var4 = 0; var4 < rootWidgetCount; ++var4) {
				if (field842[var4]) {
					class42.rasterProvider.draw(rootWidgetXs[var4], rootWidgetYs[var4], rootWidgetWidths[var4], rootWidgetHeights[var4]);
					field842[var4] = false;
				}
			}
		} else if (gameState > 0) {
			class42.rasterProvider.drawFull(0, 0);

			for (var4 = 0; var4 < rootWidgetCount; ++var4) {
				field842[var4] = false;
			}
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "87"
	)
	@Export("kill0")
	protected final void kill0() {
		if (class197.varcs.hasUnwrittenChanges()) {
			class197.varcs.write();
		}

		if (WorldMapLabel.mouseRecorder != null) {
			WorldMapLabel.mouseRecorder.isRunning = false;
		}

		WorldMapLabel.mouseRecorder = null;
		packetWriter.close();
		class191.method3640();
		method1566();
		KeyHandler.mouseWheel = null;
		if (class219.pcmPlayer0 != null) {
			class219.pcmPlayer0.shutdown();
		}

		if (GrandExchangeOfferWorldComparator.pcmPlayer1 != null) {
			GrandExchangeOfferWorldComparator.pcmPlayer1.shutdown();
		}

		class80.method2057();
		UrlRequest.method3269();
		if (urlRequester != null) {
			urlRequester.close();
			urlRequester = null;
		}

		Occluder.method3252();
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2052837160"
	)
	protected final void vmethod1307() {
	}

	public final void init() {
		try {
			if (this.checkHost()) {
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
							WorldMapLabelSize.clientLanguage = Language.method3618(Integer.parseInt(var2));
							break;
						case 7:
							VertexNormal.field1726 = FloorDecoration.method2841(Integer.parseInt(var2));
							break;
						case 8:
							if (var2.equalsIgnoreCase("true")) {
							}
							break;
						case 9:
							class197.field2390 = var2;
							break;
						case 10:
							StudioGame[] var3 = new StudioGame[]{StudioGame.game3, StudioGame.runescape, StudioGame.stellardawn, StudioGame.oldscape, StudioGame.game4, StudioGame.game5};
							class16.field101 = (StudioGame)NetSocket.findEnumerated(var3, Integer.parseInt(var2));
							if (class16.field101 == StudioGame.oldscape) {
								WorldMapSection1.loginType = LoginType.oldscape;
							} else {
								WorldMapSection1.loginType = LoginType.field4032;
							}
							break;
						case 12:
							worldId = Integer.parseInt(var2);
							break;
						case 14:
							WorldMapArea.field218 = Integer.parseInt(var2);
							break;
						case 15:
							gameBuild = Integer.parseInt(var2);
							break;
						case 17:
							WorldMapSectionType.field150 = var2;
						}
					}
				}

				GrandExchangeOfferUnitPriceComparator.method139();
				class160.worldHost = this.getCodeBase().getHost();
				String var11 = VertexNormal.field1726.name;
				byte var12 = 0;

				try {
					JagexCache.idxCount = 21;
					BufferedNetSocket.cacheGamebuild = var12;

					try {
						HealthBarUpdate.field993 = System.getProperty("os.name");
					} catch (Exception var19) {
						HealthBarUpdate.field993 = "Unknown";
					}

					class162.field1990 = HealthBarUpdate.field993.toLowerCase();

					try {
						JagexCache.userHomeDirectory = System.getProperty("user.home");
						if (JagexCache.userHomeDirectory != null) {
							JagexCache.userHomeDirectory = JagexCache.userHomeDirectory + "/";
						}
					} catch (Exception var18) {
					}

					try {
						if (class162.field1990.startsWith("win")) {
							if (JagexCache.userHomeDirectory == null) {
								JagexCache.userHomeDirectory = System.getenv("USERPROFILE");
							}
						} else if (JagexCache.userHomeDirectory == null) {
							JagexCache.userHomeDirectory = System.getenv("HOME");
						}

						if (JagexCache.userHomeDirectory != null) {
							JagexCache.userHomeDirectory = JagexCache.userHomeDirectory + "/";
						}
					} catch (Exception var17) {
					}

					if (JagexCache.userHomeDirectory == null) {
						JagexCache.userHomeDirectory = "~/";
					}

					UserComparator4.field1948 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", JagexCache.userHomeDirectory, "/tmp/", ""};
					class266.field3537 = new String[]{".jagex_cache_" + BufferedNetSocket.cacheGamebuild, ".file_store_" + BufferedNetSocket.cacheGamebuild};

					int var6;
					File var7;
					label176:
					for (int var13 = 0; var13 < 4; ++var13) {
						GrandExchangeOfferOwnWorldComparator.cacheDir = WorldMapRegion.getCacheDir("oldschool", var11, var13);
						if (!GrandExchangeOfferOwnWorldComparator.cacheDir.exists()) {
							GrandExchangeOfferOwnWorldComparator.cacheDir.mkdirs();
						}

						File[] var4 = GrandExchangeOfferOwnWorldComparator.cacheDir.listFiles();
						if (var4 == null) {
							break;
						}

						File[] var5 = var4;
						var6 = 0;

						while (true) {
							if (var6 >= var5.length) {
								break label176;
							}

							var7 = var5[var6];

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

							if (!var8) {
								break;
							}

							++var6;
						}
					}

					File var23 = GrandExchangeOfferOwnWorldComparator.cacheDir;
					FileSystem.FileSystem_cacheDir = var23;
					if (!FileSystem.FileSystem_cacheDir.exists()) {
						throw new RuntimeException("");
					}

					FileSystem.FileSystem_hasPermissions = true;

					try {
						File var24 = new File(JagexCache.userHomeDirectory, "random.dat");
						if (var24.exists()) {
							JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var24, "rw", 25L), 24, 0);
						} else {
							label153:
							for (int var14 = 0; var14 < class266.field3537.length; ++var14) {
								for (var6 = 0; var6 < UserComparator4.field1948.length; ++var6) {
									var7 = new File(UserComparator4.field1948[var6] + class266.field3537[var14] + File.separatorChar + "random.dat");
									if (var7.exists()) {
										JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var7, "rw", 25L), 24, 0);
										break label153;
									}
								}
							}
						}

						if (JagexCache.JagexCache_randomDat == null) {
							RandomAccessFile var25 = new RandomAccessFile(var24, "rw");
							var6 = var25.read();
							var25.seek(0L);
							var25.write(var6);
							var25.seek(0L);
							var25.close();
							JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var24, "rw", 25L), 24, 0);
						}
					} catch (IOException var20) {
					}

					JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(UserComparator8.getFile("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
					JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(UserComparator8.getFile("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
					class189.JagexCache_idxFiles = new BufferedFile[JagexCache.idxCount];

					for (int var15 = 0; var15 < JagexCache.idxCount; ++var15) {
						class189.JagexCache_idxFiles[var15] = new BufferedFile(new AccessFile(UserComparator8.getFile("main_file_cache.idx" + var15), "rw", 1048576L), 6000, 0);
					}
				} catch (Exception var21) {
					class32.RunException_sendStackTrace((String)null, var21);
				}

				ViewportMouse.client = this;
				ClientType.clientType = clientType;
				this.startThread(765, 503, 184);
			}
		} catch (RuntimeException var22) {
			throw class14.newRunException(var22, "client.init(" + ')');
		}
	}

	@ObfuscatedName("en")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "942594737"
	)
	@Export("doCycleJs5")
	void doCycleJs5() {
		if (gameState != 1000) {
			boolean var1 = PlayerAppearance.method4010();
			if (!var1) {
				this.doCycleJs5Connect();
			}

		}
	}

	@ObfuscatedName("eh")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1951808439"
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

				field664 = 3000;
				NetCache.NetCache_ioExceptions = 3;
			}

			if (--field664 + 1 <= 0) {
				try {
					if (js5ConnectState == 0) {
						Login.js5SocketTask = GameShell.taskHandler.newSocketTask(class160.worldHost, NPC.port3);
						++js5ConnectState;
					}

					if (js5ConnectState == 1) {
						if (Login.js5SocketTask.status == 2) {
							this.js5Error(-1);
							return;
						}

						if (Login.js5SocketTask.status == 1) {
							++js5ConnectState;
						}
					}

					if (js5ConnectState == 2) {
						if (useBufferedSocket) {
							Socket var2 = (Socket)Login.js5SocketTask.result;
							BufferedNetSocket var1 = new BufferedNetSocket(var2, 40000, 5000);
							class43.js5Socket = var1;
						} else {
							class43.js5Socket = new NetSocket((Socket)Login.js5SocketTask.result, GameShell.taskHandler, 5000);
						}

						Buffer var5 = new Buffer(5);
						var5.writeByte(15);
						var5.writeInt(184);
						class43.js5Socket.write(var5.array, 0, 5);
						++js5ConnectState;
						VerticalAlignment.field3175 = class30.currentTimeMillis();
					}

					if (js5ConnectState == 3) {
						if (class43.js5Socket.available() > 0 || !useBufferedSocket && gameState <= 5) {
							int var3 = class43.js5Socket.readUnsignedByte();
							if (var3 != 0) {
								this.js5Error(var3);
								return;
							}

							++js5ConnectState;
						} else if (class30.currentTimeMillis() - VerticalAlignment.field3175 > 30000L) {
							this.js5Error(-2);
							return;
						}
					}

					if (js5ConnectState == 4) {
						MenuAction.method2067(class43.js5Socket, gameState > 20);
						Login.js5SocketTask = null;
						class43.js5Socket = null;
						js5ConnectState = 0;
						js5Errors = 0;
					}
				} catch (IOException var4) {
					this.js5Error(-3);
				}

			}
		}
	}

	@ObfuscatedName("em")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "0"
	)
	@Export("js5Error")
	void js5Error(int var1) {
		Login.js5SocketTask = null;
		class43.js5Socket = null;
		js5ConnectState = 0;
		if (NPC.port3 == HitSplatDefinition.port1) {
			NPC.port3 = BZip2State.port2;
		} else {
			NPC.port3 = HitSplatDefinition.port1;
		}

		++js5Errors;
		if (js5Errors >= 2 && (var1 == 7 || var1 == 9)) {
			if (gameState <= 5) {
				this.error("js5connect_full");
				gameState = 1000;
			} else {
				field664 = 3000;
			}
		} else if (js5Errors >= 2 && var1 == 6) {
			this.error("js5connect_outofdate");
			gameState = 1000;
		} else if (js5Errors >= 4) {
			if (gameState <= 5) {
				this.error("js5connect");
				gameState = 1000;
			} else {
				field664 = 3000;
			}
		}

	}

	@ObfuscatedName("ey")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "684778966"
	)
	@Export("doCycleLoggedOut")
	final void doCycleLoggedOut() {
		Object var1 = packetWriter.getSocket();
		PacketBuffer var2 = packetWriter.packetBuffer;

		try {
			if (loginState == 0) {
				if (GraphicsObject.secureRandom == null && (secureRandomFuture.isDone() || field669 > 250)) {
					GraphicsObject.secureRandom = secureRandomFuture.get();
					secureRandomFuture.shutdown();
					secureRandomFuture = null;
				}

				if (GraphicsObject.secureRandom != null) {
					if (var1 != null) {
						((AbstractSocket)var1).close();
						var1 = null;
					}

					LoginPacket.socketTask = null;
					field730 = false;
					field669 = 0;
					loginState = 1;
				}
			}

			if (loginState == 1) {
				if (LoginPacket.socketTask == null) {
					LoginPacket.socketTask = GameShell.taskHandler.newSocketTask(class160.worldHost, NPC.port3);
				}

				if (LoginPacket.socketTask.status == 2) {
					throw new IOException();
				}

				if (LoginPacket.socketTask.status == 1) {
					if (useBufferedSocket) {
						Socket var4 = (Socket)LoginPacket.socketTask.result;
						BufferedNetSocket var3 = new BufferedNetSocket(var4, 40000, 5000);
						var1 = var3;
					} else {
						var1 = new NetSocket((Socket)LoginPacket.socketTask.result, GameShell.taskHandler, 5000);
					}

					packetWriter.setSocket((AbstractSocket)var1);
					LoginPacket.socketTask = null;
					loginState = 2;
				}
			}

			if (loginState == 2) {
				packetWriter.clearBuffer();
				PacketBufferNode var22 = Tile.method2849();
				var22.packetBuffer.writeByte(LoginPacket.field2289.id);
				packetWriter.addNode(var22);
				packetWriter.flush();
				var2.offset = 0;
				loginState = 3;
			}

			boolean var13;
			int var14;
			if (loginState == 3) {
				if (class219.pcmPlayer0 != null) {
					class219.pcmPlayer0.method2397();
				}

				if (GrandExchangeOfferWorldComparator.pcmPlayer1 != null) {
					GrandExchangeOfferWorldComparator.pcmPlayer1.method2397();
				}

				var13 = true;
				if (useBufferedSocket && !((AbstractSocket)var1).isAvailable(1)) {
					var13 = false;
				}

				if (var13) {
					var14 = ((AbstractSocket)var1).readUnsignedByte();
					if (class219.pcmPlayer0 != null) {
						class219.pcmPlayer0.method2397();
					}

					if (GrandExchangeOfferWorldComparator.pcmPlayer1 != null) {
						GrandExchangeOfferWorldComparator.pcmPlayer1.method2397();
					}

					if (var14 != 0) {
						ArchiveDisk.getLoginError(var14);
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
					Tiles.field495 = var2.readLong();
					loginState = 5;
				}
			}

			int var6;
			if (loginState == 5) {
				packetWriter.packetBuffer.offset = 0;
				packetWriter.clearBuffer();
				PacketBuffer var23 = new PacketBuffer(500);
				int[] var25 = new int[]{GraphicsObject.secureRandom.nextInt(), GraphicsObject.secureRandom.nextInt(), GraphicsObject.secureRandom.nextInt(), GraphicsObject.secureRandom.nextInt()};
				var23.offset = 0;
				var23.writeByte(1);
				var23.writeInt(var25[0]);
				var23.writeInt(var25[1]);
				var23.writeInt(var25[2]);
				var23.writeInt(var25[3]);
				var23.writeLong(Tiles.field495);
				if (gameState == 40) {
					var23.writeInt(DirectByteArrayCopier.field2482[0]);
					var23.writeInt(DirectByteArrayCopier.field2482[1]);
					var23.writeInt(DirectByteArrayCopier.field2482[2]);
					var23.writeInt(DirectByteArrayCopier.field2482[3]);
				} else {
					var23.writeByte(field672.rsOrdinal());
					switch(field672.field1984) {
					case 0:
					case 1:
						var23.writeMedium(class185.field2305);
						++var23.offset;
						break;
					case 2:
						var23.offset += 4;
						break;
					case 3:
						var23.writeInt((Integer)AbstractArchive.clientPreferences.parameters.get(class288.method5224(Login.Login_username)));
					}

					var23.writeByte(class312.field3818.rsOrdinal());
					var23.writeStringCp1252NullTerminated(Login.Login_password);
				}

				var23.encryptRsa(class83.field1148, class83.field1149);
				DirectByteArrayCopier.field2482 = var25;
				PacketBufferNode var5 = Tile.method2849();
				var5.packetBuffer.offset = 0;
				if (gameState == 40) {
					var5.packetBuffer.writeByte(LoginPacket.field2290.id);
				} else {
					var5.packetBuffer.writeByte(LoginPacket.field2287.id);
				}

				var5.packetBuffer.writeShort(0);
				var6 = var5.packetBuffer.offset;
				var5.packetBuffer.writeInt(184);
				var5.packetBuffer.writeInt(1);
				var5.packetBuffer.writeByte(clientType);
				var5.packetBuffer.writeBytes(var23.array, 0, var23.offset);
				int var7 = var5.packetBuffer.offset;
				var5.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
				var5.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
				var5.packetBuffer.writeShort(FloorDecoration.canvasWidth);
				var5.packetBuffer.writeShort(WallDecoration.canvasHeight);
				PacketBuffer var8 = var5.packetBuffer;
				int var11;
				if (randomDatData != null) {
					var8.writeBytes(randomDatData, 0, randomDatData.length);
				} else {
					byte[] var10 = new byte[24];

					try {
						JagexCache.JagexCache_randomDat.seek(0L);
						JagexCache.JagexCache_randomDat.readFully(var10);

						for (var11 = 0; var11 < 24 && var10[var11] == 0; ++var11) {
						}

						if (var11 >= 24) {
							throw new IOException();
						}
					} catch (Exception var20) {
						for (int var12 = 0; var12 < 24; ++var12) {
							var10[var12] = -1;
						}
					}

					var8.writeBytes(var10, 0, var10.length);
				}

				var5.packetBuffer.writeStringCp1252NullTerminated(class197.field2390);
				var5.packetBuffer.writeInt(WorldMapArea.field218);
				Buffer var9 = new Buffer(class269.platformInfo.size());
				class269.platformInfo.write(var9);
				var5.packetBuffer.writeBytes(var9.array, 0, var9.array.length);
				var5.packetBuffer.writeByte(clientType);
				var5.packetBuffer.writeInt(0);
				var5.packetBuffer.writeInt(class1.archive0.hash);
				var5.packetBuffer.writeInt(WorldMapLabelSize.archive1.hash);
				var5.packetBuffer.writeInt(FaceNormal.archive2.hash);
				var5.packetBuffer.writeInt(BoundaryObject.archive3.hash);
				var5.packetBuffer.writeInt(GrandExchangeOfferAgeComparator.archive4.hash);
				var5.packetBuffer.writeInt(class3.archive5.hash);
				var5.packetBuffer.writeInt(class225.archive6.hash);
				var5.packetBuffer.writeInt(Language.archive7.hash);
				var5.packetBuffer.writeInt(GrandExchangeOfferAgeComparator.archive8.hash);
				var5.packetBuffer.writeInt(AttackOption.archive9.hash);
				var5.packetBuffer.writeInt(archive10.hash);
				var5.packetBuffer.writeInt(ClanMate.archive11.hash);
				var5.packetBuffer.writeInt(GrandExchangeOfferOwnWorldComparator.archive12.hash);
				var5.packetBuffer.writeInt(Tile.archive13.hash);
				var5.packetBuffer.writeInt(WorldMapData_1.archive14.hash);
				var5.packetBuffer.writeInt(Script.archive15.hash);
				var5.packetBuffer.writeInt(0);
				var5.packetBuffer.writeInt(archive17.hash);
				var5.packetBuffer.writeInt(VarcInt.archive18.hash);
				var5.packetBuffer.writeInt(WorldMapLabel.archive19.hash);
				var5.packetBuffer.writeInt(WorldMapEvent.archive20.hash);
				var5.packetBuffer.xteaEncrypt(var25, var7, var5.packetBuffer.offset);
				var5.packetBuffer.writeLengthShort(var5.packetBuffer.offset - var6);
				packetWriter.addNode(var5);
				packetWriter.flush();
				packetWriter.isaacCipher = new IsaacCipher(var25);
				int[] var32 = new int[4];

				for (var11 = 0; var11 < 4; ++var11) {
					var32[var11] = var25[var11] + 50;
				}

				var2.newIsaacCipher(var32);
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
				} else if (var33 == 23 && field670 < 1) {
					++field670;
					loginState = 0;
				} else {
					if (var33 != 29) {
						ArchiveDisk.getLoginError(var33);
						return;
					}

					loginState = 14;
				}
			}

			if (loginState == 7 && ((AbstractSocket)var1).available() > 0) {
				Message.field592 = ((AbstractSocket)var1).readUnsignedByte();
				loginState = 8;
			}

			if (loginState == 8 && ((AbstractSocket)var1).available() >= Message.field592) {
				((AbstractSocket)var1).read(var2.array, 0, Message.field592);
				var2.offset = 0;
				loginState = 6;
			}

			if (loginState == 9 && ((AbstractSocket)var1).available() > 0) {
				field671 = (((AbstractSocket)var1).readUnsignedByte() + 3) * 60;
				loginState = 10;
			}

			if (loginState == 10) {
				field669 = 0;
				PlayerType.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field671 / 60 + " seconds.");
				if (--field671 <= 0) {
					loginState = 0;
				}

			} else {
				if (loginState == 11 && ((AbstractSocket)var1).available() >= 1) {
					World.field1012 = ((AbstractSocket)var1).readUnsignedByte();
					loginState = 12;
				}

				int var16;
				if (loginState == 12 && ((AbstractSocket)var1).available() >= World.field1012) {
					var13 = ((AbstractSocket)var1).readUnsignedByte() == 1;
					((AbstractSocket)var1).read(var2.array, 0, 4);
					var2.offset = 0;
					boolean var34 = false;
					if (var13) {
						var14 = var2.readByteIsaac() << 24;
						var14 |= var2.readByteIsaac() << 16;
						var14 |= var2.readByteIsaac() << 8;
						var14 |= var2.readByteIsaac();
						var16 = class288.method5224(Login.Login_username);
						if (AbstractArchive.clientPreferences.parameters.size() >= 10 && !AbstractArchive.clientPreferences.parameters.containsKey(var16)) {
							Iterator var17 = AbstractArchive.clientPreferences.parameters.entrySet().iterator();
							var17.next();
							var17.remove();
						}

						AbstractArchive.clientPreferences.parameters.put(var16, var14);
					}

					if (Login_isUsernameRemembered) {
						AbstractArchive.clientPreferences.rememberedUsername = Login.Login_username;
					} else {
						AbstractArchive.clientPreferences.rememberedUsername = null;
					}

					Language.savePreferences();
					staffModLevel = ((AbstractSocket)var1).readUnsignedByte();
					playerMod = ((AbstractSocket)var1).readUnsignedByte() == 1;
					localPlayerIndex = ((AbstractSocket)var1).readUnsignedByte();
					localPlayerIndex <<= 8;
					localPlayerIndex += ((AbstractSocket)var1).readUnsignedByte();
					field636 = ((AbstractSocket)var1).readUnsignedByte();
					((AbstractSocket)var1).read(var2.array, 0, 1);
					var2.offset = 0;
					ServerPacket[] var29 = class96.ServerPacket_values();
					var6 = var2.readSmartByteShortIsaac();
					if (var6 < 0 || var6 >= var29.length) {
						throw new IOException(var6 + " " + var2.offset);
					}

					packetWriter.serverPacket = var29[var6];
					packetWriter.serverPacketLength = packetWriter.serverPacket.length;
					((AbstractSocket)var1).read(var2.array, 0, 2);
					var2.offset = 0;
					packetWriter.serverPacketLength = var2.readUnsignedShort();

					try {
						class47.method881(ViewportMouse.client, "zap");
					} catch (Throwable var19) {
					}

					loginState = 13;
				}

				if (loginState == 13) {
					if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
						timer.method4939();
						mouseLastLastPressedTimeMillis = -1L;
						WorldMapLabel.mouseRecorder.index = 0;
						TaskHandler.hasFocus = true;
						hadFocus = true;
						field860 = -1L;
						class96.reflectionChecks = new IterableNodeDeque();
						packetWriter.clearBuffer();
						packetWriter.packetBuffer.offset = 0;
						packetWriter.serverPacket = null;
						packetWriter.field1300 = null;
						packetWriter.field1291 = null;
						packetWriter.field1301 = null;
						packetWriter.serverPacketLength = 0;
						packetWriter.field1297 = 0;
						rebootTimer = 0;
						logoutTimer = 0;
						hintArrowType = 0;
						ScriptEvent.method1205();
						MouseHandler.MouseHandler_idleCycles = 0;
						WorldMapDecoration.method349();
						isItemSelected = 0;
						isSpellSelected = false;
						soundEffectCount = 0;
						camAngleY = 0;
						oculusOrbState = 0;
						StudioGame.field3086 = null;
						minimapState = 0;
						field643 = -1;
						destinationX = 0;
						destinationY = 0;
						playerAttackOption = AttackOption.AttackOption_hidden;
						npcAttackOption = AttackOption.AttackOption_hidden;
						npcCount = 0;
						ClientPreferences.method1861();

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
							for (var14 = 0; var14 < 104; ++var14) {
								for (var16 = 0; var16 < 104; ++var16) {
									groundItems[var33][var14][var16] = null;
								}
							}
						}

						pendingSpawns = new NodeDeque();
						Tiles.friendSystem.clear();

						for (var33 = 0; var33 < VarpDefinition.VarpDefinition_fileCount; ++var33) {
							VarpDefinition var28 = AbstractWorldMapData.method288(var33);
							if (var28 != null) {
								Varps.Varps_temp[var33] = 0;
								Varps.Varps_main[var33] = 0;
							}
						}

						class197.varcs.clearTransient();
						followerIndex = -1;
						if (rootInterface != -1) {
							InterfaceParent.method1192(rootInterface);
						}

						for (InterfaceParent var26 = (InterfaceParent)interfaceParents.first(); var26 != null; var26 = (InterfaceParent)interfaceParents.next()) {
							FontName.closeInterface(var26, true);
						}

						rootInterface = -1;
						interfaceParents = new NodeHashTable(8);
						meslayerContinueWidget = null;
						ScriptEvent.method1205();
						playerAppearance.update((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

						for (var33 = 0; var33 < 8; ++var33) {
							playerMenuActions[var33] = null;
							playerOptionsPriorities[var33] = false;
						}

						FontName.method5266();
						isLoading = true;

						for (var33 = 0; var33 < 100; ++var33) {
							field841[var33] = true;
						}

						class210.method3948();
						Varps.clanChat = null;

						for (var33 = 0; var33 < 8; ++var33) {
							grandExchangeOffers[var33] = new GrandExchangeOffer();
						}

						TileItem.grandExchangeEvents = null;
						AttackOption.updatePlayer(var2);
						ServerPacket.field2131 = -1;
						PlayerType.loadRegions(false, var2);
						packetWriter.serverPacket = null;
					}

				} else {
					if (loginState == 14 && ((AbstractSocket)var1).available() >= 2) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, 2);
						var2.offset = 0;
						class40.field329 = var2.readUnsignedShort();
						loginState = 15;
					}

					if (loginState == 15 && ((AbstractSocket)var1).available() >= class40.field329) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, class40.field329);
						var2.offset = 0;
						String var24 = var2.readStringCp1252NullTerminated();
						String var27 = var2.readStringCp1252NullTerminated();
						String var30 = var2.readStringCp1252NullTerminated();
						PlayerType.setLoginResponseString(var24, var27, var30);
						MouseRecorder.updateGameState(10);
					}

					if (loginState != 16) {
						++field669;
						if (field669 > 2000) {
							if (field670 < 1) {
								if (HitSplatDefinition.port1 == NPC.port3) {
									NPC.port3 = BZip2State.port2;
								} else {
									NPC.port3 = HitSplatDefinition.port1;
								}

								++field670;
								loginState = 0;
							} else {
								ArchiveDisk.getLoginError(-3);
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
							var33 = packetWriter.serverPacketLength;
							timer.method4941();
							packetWriter.clearBuffer();
							packetWriter.packetBuffer.offset = 0;
							packetWriter.serverPacket = null;
							packetWriter.field1300 = null;
							packetWriter.field1291 = null;
							packetWriter.field1301 = null;
							packetWriter.serverPacketLength = 0;
							packetWriter.field1297 = 0;
							rebootTimer = 0;
							ScriptEvent.method1205();
							minimapState = 0;
							destinationX = 0;

							for (var14 = 0; var14 < 2048; ++var14) {
								players[var14] = null;
							}

							class223.localPlayer = null;

							for (var14 = 0; var14 < npcs.length; ++var14) {
								NPC var31 = npcs[var14];
								if (var31 != null) {
									var31.targetIndex = -1;
									var31.false0 = false;
								}
							}

							FontName.method5266();
							MouseRecorder.updateGameState(30);

							for (var14 = 0; var14 < 100; ++var14) {
								field841[var14] = true;
							}

							class210.method3948();
							AttackOption.updatePlayer(var2);
							if (var33 != var2.offset) {
								throw new RuntimeException();
							}
						}
					}
				}
			}
		} catch (IOException var21) {
			if (field670 < 1) {
				if (NPC.port3 == HitSplatDefinition.port1) {
					NPC.port3 = BZip2State.port2;
				} else {
					NPC.port3 = HitSplatDefinition.port1;
				}

				++field670;
				loginState = 0;
			} else {
				ArchiveDisk.getLoginError(-2);
			}
		}
	}

	@ObfuscatedName("fd")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1173156947"
	)
	@Export("doCycleLoggedIn")
	final void doCycleLoggedIn() {
		if (rebootTimer > 1) {
			--rebootTimer;
		}

		if (logoutTimer > 0) {
			--logoutTimer;
		}

		if (field730) {
			field730 = false;
			MouseRecorder.method1213();
		} else {
			if (!isMenuOpen) {
				KeyHandler.addCancelMenuEntry();
			}

			for (int var1 = 0; var1 < 100 && this.method1607(packetWriter); ++var1) {
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
						if (timer.field3563) {
							var14 = InterfaceParent.getPacketBufferNode(ClientPacket.field2187, packetWriter.isaacCipher);
							var14.packetBuffer.writeByte(0);
							var15 = var14.packetBuffer.offset;
							timer.write(var14.packetBuffer);
							var14.packetBuffer.writeLengthByte(var14.packetBuffer.offset - var15);
							packetWriter.addNode(var14);
							timer.method4940();
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
						synchronized(WorldMapLabel.mouseRecorder.lock) {
							if (!field802) {
								WorldMapLabel.mouseRecorder.index = 0;
							} else if (MouseHandler.MouseHandler_lastButton != 0 || WorldMapLabel.mouseRecorder.index >= 40) {
								var30 = null;
								var3 = 0;
								var4 = 0;
								var5 = 0;
								var6 = 0;

								for (var7 = 0; var7 < WorldMapLabel.mouseRecorder.index && (var30 == null || var30.packetBuffer.offset - var3 < 246); ++var7) {
									var4 = var7;
									var8 = WorldMapLabel.mouseRecorder.ys[var7];
									if (var8 < -1) {
										var8 = -1;
									} else if (var8 > 65534) {
										var8 = 65534;
									}

									var9 = WorldMapLabel.mouseRecorder.xs[var7];
									if (var9 < -1) {
										var9 = -1;
									} else if (var9 > 65534) {
										var9 = 65534;
									}

									if (var9 != field646 || var8 != field647) {
										if (var30 == null) {
											var30 = InterfaceParent.getPacketBufferNode(ClientPacket.field2188, packetWriter.isaacCipher);
											var30.packetBuffer.writeByte(0);
											var3 = var30.packetBuffer.offset;
											PacketBuffer var10000 = var30.packetBuffer;
											var10000.offset += 2;
											var5 = 0;
											var6 = 0;
										}

										if (field648 != -1L) {
											var10 = var9 - field646;
											var11 = var8 - field647;
											var12 = (int)((WorldMapLabel.mouseRecorder.millis[var7] - field648) / 20L);
											var5 = (int)((long)var5 + (WorldMapLabel.mouseRecorder.millis[var7] - field648) % 20L);
										} else {
											var10 = var9;
											var11 = var8;
											var12 = Integer.MAX_VALUE;
										}

										field646 = var9;
										field647 = var8;
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
										field648 = WorldMapLabel.mouseRecorder.millis[var7];
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

								if (var4 >= WorldMapLabel.mouseRecorder.index) {
									WorldMapLabel.mouseRecorder.index = 0;
								} else {
									MouseRecorder var42 = WorldMapLabel.mouseRecorder;
									var42.index -= var4;
									System.arraycopy(WorldMapLabel.mouseRecorder.xs, var4, WorldMapLabel.mouseRecorder.xs, 0, WorldMapLabel.mouseRecorder.index);
									System.arraycopy(WorldMapLabel.mouseRecorder.ys, var4, WorldMapLabel.mouseRecorder.ys, 0, WorldMapLabel.mouseRecorder.index);
									System.arraycopy(WorldMapLabel.mouseRecorder.millis, var4, WorldMapLabel.mouseRecorder.millis, 0, WorldMapLabel.mouseRecorder.index);
								}
							}
						}

						PacketBufferNode var18;
						if (MouseHandler.MouseHandler_lastButton == 1 || !WorldMapIcon_1.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
							long var16 = (MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis) / 50L;
							if (var16 > 4095L) {
								var16 = 4095L;
							}

							mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis;
							var3 = MouseHandler.MouseHandler_lastPressedY;
							if (var3 < 0) {
								var3 = 0;
							} else if (var3 > WallDecoration.canvasHeight) {
								var3 = WallDecoration.canvasHeight;
							}

							var4 = MouseHandler.MouseHandler_lastPressedX;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > FloorDecoration.canvasWidth) {
								var4 = FloorDecoration.canvasWidth;
							}

							var5 = (int)var16;
							var18 = InterfaceParent.getPacketBufferNode(ClientPacket.field2210, packetWriter.isaacCipher);
							var18.packetBuffer.writeShort((MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0) + (var5 << 1));
							var18.packetBuffer.writeShort(var4);
							var18.packetBuffer.writeShort(var3);
							packetWriter.addNode(var18);
						}

						if (KeyHandler.field361 > 0) {
							var14 = InterfaceParent.getPacketBufferNode(ClientPacket.field2224, packetWriter.isaacCipher);
							var14.packetBuffer.writeShort(0);
							var15 = var14.packetBuffer.offset;
							long var19 = class30.currentTimeMillis();

							for (var5 = 0; var5 < KeyHandler.field361; ++var5) {
								long var21 = var19 - field860;
								if (var21 > 16777215L) {
									var21 = 16777215L;
								}

								field860 = var19;
								var14.packetBuffer.method5485((int)var21);
								var14.packetBuffer.method5461(KeyHandler.field376[var5]);
							}

							var14.packetBuffer.writeLengthShort(var14.packetBuffer.offset - var15);
							packetWriter.addNode(var14);
						}

						if (field720 > 0) {
							--field720;
						}

						if (KeyHandler.KeyHandler_pressedKeys[96] || KeyHandler.KeyHandler_pressedKeys[97] || KeyHandler.KeyHandler_pressedKeys[98] || KeyHandler.KeyHandler_pressedKeys[99]) {
							field721 = true;
						}

						if (field721 && field720 <= 0) {
							field720 = 20;
							field721 = false;
							var14 = InterfaceParent.getPacketBufferNode(ClientPacket.field2209, packetWriter.isaacCipher);
							var14.packetBuffer.writeShortLE(camAngleX);
							var14.packetBuffer.method5476(camAngleY);
							packetWriter.addNode(var14);
						}

						if (TaskHandler.hasFocus && !hadFocus) {
							hadFocus = true;
							var14 = InterfaceParent.getPacketBufferNode(ClientPacket.field2186, packetWriter.isaacCipher);
							var14.packetBuffer.writeByte(1);
							packetWriter.addNode(var14);
						}

						if (!TaskHandler.hasFocus && hadFocus) {
							hadFocus = false;
							var14 = InterfaceParent.getPacketBufferNode(ClientPacket.field2186, packetWriter.isaacCipher);
							var14.packetBuffer.writeByte(0);
							packetWriter.addNode(var14);
						}

						if (Tiles.worldMap != null) {
							Tiles.worldMap.method6314();
						}

						if (GrandExchangeOfferAgeComparator.ClanChat_inClanChat) {
							if (Varps.clanChat != null) {
								Varps.clanChat.sort();
							}

							Archive.method4278();
							GrandExchangeOfferAgeComparator.ClanChat_inClanChat = false;
						}

						class60.method1191();
						if (gameState != 30) {
							return;
						}

						class160.method3417();
						HealthBarUpdate.method1769();
						++packetWriter.field1297;
						if (packetWriter.field1297 > 750) {
							MouseRecorder.method1213();
							return;
						}

						class32.method571();
						WallDecoration.method3255();
						int[] var36 = Players.Players_indices;

						for (var15 = 0; var15 < Players.Players_count; ++var15) {
							Player var23 = players[var36[var15]];
							if (var23 != null && var23.overheadTextCyclesRemaining > 0) {
								--var23.overheadTextCyclesRemaining;
								if (var23.overheadTextCyclesRemaining == 0) {
									var23.overheadText = null;
								}
							}
						}

						for (var15 = 0; var15 < npcCount; ++var15) {
							var3 = npcIndices[var15];
							NPC var24 = npcs[var3];
							if (var24 != null && var24.overheadTextCyclesRemaining > 0) {
								--var24.overheadTextCyclesRemaining;
								if (var24.overheadTextCyclesRemaining == 0) {
									var24.overheadText = null;
								}
							}
						}

						++field698;
						if (mouseCrossColor != 0) {
							mouseCrossState = mouseCrossState * 400 + 400;
							if (mouseCrossState * 20 >= 400) {
								mouseCrossColor = 0;
							}
						}

						if (GrandExchangeOfferOwnWorldComparator.field628 != null) {
							++field750;
							if (field750 >= 15) {
								WorldMapSectionType.invalidateWidget(GrandExchangeOfferOwnWorldComparator.field628);
								GrandExchangeOfferOwnWorldComparator.field628 = null;
							}
						}

						Widget var37 = NetSocket.mousedOverWidgetIf1;
						Widget var31 = Strings.field2767;
						NetSocket.mousedOverWidgetIf1 = null;
						Strings.field2767 = null;
						draggedOnWidget = null;
						field817 = false;
						field814 = false;
						field857 = 0;

						while (DynamicObject.isKeyDown() && field857 < 128) {
							if (staffModLevel >= 2 && KeyHandler.KeyHandler_pressedKeys[82] && SecureRandomFuture.field1230 == 66) {
								String var39 = Entity.method3225();
								ViewportMouse.client.clipboardSetString(var39);
							} else if (oculusOrbState != 1 || KeyHandler.field381 <= 0) {
								field859[field857] = SecureRandomFuture.field1230;
								field858[field857] = KeyHandler.field381;
								++field857;
							}
						}

						boolean var32 = staffModLevel >= 2;
						if (var32 && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81] && mouseWheelRotation != 0) {
							var4 = class223.localPlayer.plane - mouseWheelRotation;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > 3) {
								var4 = 3;
							}

							if (var4 != class223.localPlayer.plane) {
								class287.method5220(class223.localPlayer.pathX[0] + class223.baseX * 64, class223.localPlayer.pathY[0] + class286.baseY * 64, var4, false);
							}

							mouseWheelRotation = 0;
						}

						if (rootInterface != -1) {
							AbstractWorldMapData.updateRootInterface(rootInterface, 0, 0, FloorDecoration.canvasWidth, WallDecoration.canvasHeight, 0, 0);
						}

						++cycleCntr;

						while (true) {
							Widget var25;
							Widget var38;
							ScriptEvent var40;
							do {
								var40 = (ScriptEvent)field836.removeLast();
								if (var40 == null) {
									while (true) {
										do {
											var40 = (ScriptEvent)field763.removeLast();
											if (var40 == null) {
												while (true) {
													do {
														var40 = (ScriptEvent)scriptEvents.removeLast();
														if (var40 == null) {
															this.menu();
															if (Tiles.worldMap != null) {
																Tiles.worldMap.method6272(WorldMapRectangle.plane, class223.baseX * 64 + (class223.localPlayer.x >> 7), class286.baseY * 64 + (class223.localPlayer.y >> 7), false);
																Tiles.worldMap.loadCache();
															}

															if (clickedWidget != null) {
																this.method1328();
															}

															if (Frames.dragInventoryWidget != null) {
																WorldMapSectionType.invalidateWidget(Frames.dragInventoryWidget);
																++itemDragDuration;
																if (MouseHandler.MouseHandler_currentButton == 0) {
																	if (field748) {
																		if (Frames.dragInventoryWidget == DevicePcmPlayerProvider.field391 && dragItemSlotDestination != dragItemSlotSource) {
																			Widget var41 = Frames.dragInventoryWidget;
																			byte var33 = 0;
																			if (field873 == 1 && var41.contentType == 206) {
																				var33 = 1;
																			}

																			if (var41.itemIds[dragItemSlotDestination] <= 0) {
																				var33 = 0;
																			}

																			if (WorldMapSection0.method249(class2.getWidgetClickMask(var41))) {
																				var6 = dragItemSlotSource;
																				var7 = dragItemSlotDestination;
																				var41.itemIds[var7] = var41.itemIds[var6];
																				var41.itemQuantities[var7] = var41.itemQuantities[var6];
																				var41.itemIds[var6] = -1;
																				var41.itemQuantities[var6] = 0;
																			} else if (var33 == 1) {
																				var6 = dragItemSlotSource;
																				var7 = dragItemSlotDestination;

																				while (var7 != var6) {
																					if (var6 > var7) {
																						var41.swapItems(var6 - 1, var6);
																						--var6;
																					} else if (var6 < var7) {
																						var41.swapItems(var6 + 1, var6);
																						++var6;
																					}
																				}
																			} else {
																				var41.swapItems(dragItemSlotDestination, dragItemSlotSource);
																			}

																			var18 = InterfaceParent.getPacketBufferNode(ClientPacket.field2222, packetWriter.isaacCipher);
																			var18.packetBuffer.method5630(Frames.dragInventoryWidget.id);
																			var18.packetBuffer.writeShort(dragItemSlotDestination);
																			var18.packetBuffer.writeByte(var33);
																			var18.packetBuffer.method5476(dragItemSlotSource);
																			packetWriter.addNode(var18);
																		}
																	} else if (this.shouldLeftClickOpenMenu()) {
																		this.openMenu(field745, field746);
																	} else if (menuOptionsCount > 0) {
																		class3.method47(field745, field746);
																	}

																	field750 = 10;
																	MouseHandler.MouseHandler_lastButton = 0;
																	Frames.dragInventoryWidget = null;
																} else if (itemDragDuration >= 5 && (MouseHandler.MouseHandler_x > field745 + 5 || MouseHandler.MouseHandler_x < field745 - 5 || MouseHandler.MouseHandler_y > field746 + 5 || MouseHandler.MouseHandler_y < field746 - 5)) {
																	field748 = true;
																}
															}

															if (Scene.method3085()) {
																var4 = Scene.Scene_selectedX;
																var5 = Scene.Scene_selectedY;
																var18 = InterfaceParent.getPacketBufferNode(ClientPacket.field2281, packetWriter.isaacCipher);
																var18.packetBuffer.writeByte(5);
																var18.packetBuffer.writeShortLE(class223.baseX * 64 + var4);
																var18.packetBuffer.method5476(class286.baseY * 64 + var5);
																var18.packetBuffer.method5468(KeyHandler.KeyHandler_pressedKeys[82] ? (KeyHandler.KeyHandler_pressedKeys[81] ? 2 : 1) : 0);
																packetWriter.addNode(var18);
																Scene.method3086();
																mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
																mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
																mouseCrossColor = 1;
																mouseCrossState = 0;
																destinationX = var4;
																destinationY = var5;
															}

															if (var37 != NetSocket.mousedOverWidgetIf1) {
																if (var37 != null) {
																	WorldMapSectionType.invalidateWidget(var37);
																}

																if (NetSocket.mousedOverWidgetIf1 != null) {
																	WorldMapSectionType.invalidateWidget(NetSocket.mousedOverWidgetIf1);
																}
															}

															if (var31 != Strings.field2767 && field788 == field787) {
																if (var31 != null) {
																	WorldMapSectionType.invalidateWidget(var31);
																}

																if (Strings.field2767 != null) {
																	WorldMapSectionType.invalidateWidget(Strings.field2767);
																}
															}

															if (Strings.field2767 != null) {
																if (field787 < field788) {
																	++field787;
																	if (field787 == field788) {
																		WorldMapSectionType.invalidateWidget(Strings.field2767);
																	}
																}
															} else if (field787 > 0) {
																--field787;
															}

															if (oculusOrbState == 0) {
																var4 = class223.localPlayer.x;
																var5 = class223.localPlayer.y;
																if (ObjectSound.oculusOrbFocalPointX - var4 < -500 || ObjectSound.oculusOrbFocalPointX - var4 > 500 || class14.oculusOrbFocalPointY - var5 < -500 || class14.oculusOrbFocalPointY - var5 > 500) {
																	ObjectSound.oculusOrbFocalPointX = var4;
																	class14.oculusOrbFocalPointY = var5;
																}

																if (var4 != ObjectSound.oculusOrbFocalPointX) {
																	ObjectSound.oculusOrbFocalPointX += (var4 - ObjectSound.oculusOrbFocalPointX) / 16;
																}

																if (var5 != class14.oculusOrbFocalPointY) {
																	class14.oculusOrbFocalPointY += (var5 - class14.oculusOrbFocalPointY) / 16;
																}

																var6 = ObjectSound.oculusOrbFocalPointX >> 7;
																var7 = class14.oculusOrbFocalPointY >> 7;
																var8 = MusicPatchPcmStream.getTileHeight(ObjectSound.oculusOrbFocalPointX, class14.oculusOrbFocalPointY, WorldMapRectangle.plane);
																var9 = 0;
																if (var6 > 3 && var7 > 3 && var6 < 100 && var7 < 100) {
																	for (var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
																		for (var11 = var7 - 4; var11 <= var7 + 4; ++var11) {
																			var12 = WorldMapRectangle.plane;
																			if (var12 < 3 && (Tiles.Tiles_renderFlags[1][var10][var11] & 2) == 2) {
																				++var12;
																			}

																			int var26 = var8 - Tiles.Tiles_heights[var12][var10][var11];
																			if (var26 > var9) {
																				var9 = var26;
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

																if (var10 > field722) {
																	field722 += (var10 - field722) / 24;
																} else if (var10 < field722) {
																	field722 += (var10 - field722) / 80;
																}

																ModelData0.field1840 = MusicPatchPcmStream.getTileHeight(class223.localPlayer.x, class223.localPlayer.y, WorldMapRectangle.plane) - camFollowHeight;
															} else if (oculusOrbState == 1) {
																class1.method15();
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
																	field714 = var34;
																	field715 = var35;
																}

																if (field766 < var6) {
																	field766 += var6 / 8;
																	if (field766 > var6) {
																		field766 = var6;
																	}
																} else if (field766 > var6) {
																	field766 = field766 * 9 / 10;
																}

																if (field766 > 0) {
																	var7 = field766 / 16;
																	if (field714 >= 0) {
																		var4 = field714 - WorldMapSection2.cameraYaw & 2047;
																		var8 = Rasterizer3D.Rasterizer3D_sine[var4];
																		var9 = Rasterizer3D.Rasterizer3D_cosine[var4];
																		ObjectSound.oculusOrbFocalPointX += var8 * var7 / 65536;
																		class14.oculusOrbFocalPointY += var7 * var9 / 65536;
																	}

																	if (field715 != 0) {
																		ModelData0.field1840 += var7 * field715;
																		if (ModelData0.field1840 > 0) {
																			ModelData0.field1840 = 0;
																		}
																	}
																} else {
																	field714 = -1;
																	field715 = -1;
																}

																if (KeyHandler.KeyHandler_pressedKeys[13]) {
																	packetWriter.addNode(InterfaceParent.getPacketBufferNode(ClientPacket.field2283, packetWriter.isaacCipher));
																	oculusOrbState = 0;
																}
															}

															if (MouseHandler.MouseHandler_currentButton == 4 && WorldMapIcon_1.mouseCam) {
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
																ChatChannel.method2237();
															}

															for (var4 = 0; var4 < 5; ++var4) {
																int var10002 = field885[var4]++;
															}

															class197.varcs.tryWrite();
															var4 = WorldMapLabelSize.method197();
															var5 = SecureRandomCallable.method1166();
															if (var4 > 15000 && var5 > 15000) {
																logoutTimer = 250;
																MouseHandler.MouseHandler_idleCycles = 14500;
																var18 = InterfaceParent.getPacketBufferNode(ClientPacket.field2225, packetWriter.isaacCipher);
																packetWriter.addNode(var18);
															}

															Tiles.friendSystem.processFriendUpdates();
															++packetWriter.pendingWrites;
															if (packetWriter.pendingWrites > 50) {
																var18 = InterfaceParent.getPacketBufferNode(ClientPacket.field2207, packetWriter.isaacCipher);
																packetWriter.addNode(var18);
															}

															try {
																packetWriter.flush();
															} catch (IOException var27) {
																MouseRecorder.method1213();
															}

															return;
														}

														var25 = var40.widget;
														if (var25.childIndex < 0) {
															break;
														}

														var38 = Canvas.getWidget(var25.parentId);
													} while(var38 == null || var38.children == null || var25.childIndex >= var38.children.length || var25 != var38.children[var25.childIndex]);

													ParamDefinition.runScriptEvent(var40);
												}
											}

											var25 = var40.widget;
											if (var25.childIndex < 0) {
												break;
											}

											var38 = Canvas.getWidget(var25.parentId);
										} while(var38 == null || var38.children == null || var25.childIndex >= var38.children.length || var25 != var38.children[var25.childIndex]);

										ParamDefinition.runScriptEvent(var40);
									}
								}

								var25 = var40.widget;
								if (var25.childIndex < 0) {
									break;
								}

								var38 = Canvas.getWidget(var25.parentId);
							} while(var38 == null || var38.children == null || var25.childIndex >= var38.children.length || var25 != var38.children[var25.childIndex]);

							ParamDefinition.runScriptEvent(var40);
						}
					}

					var30 = InterfaceParent.getPacketBufferNode(ClientPacket.field2196, packetWriter.isaacCipher);
					var30.packetBuffer.writeByte(0);
					var3 = var30.packetBuffer.offset;
					class189.performReflectionCheck(var30.packetBuffer);
					var30.packetBuffer.writeLengthByte(var30.packetBuffer.offset - var3);
					packetWriter.addNode(var30);
				}
			}
		}
	}

	@ObfuscatedName("fs")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-6"
	)
	@Export("resizeJS")
	void resizeJS() {
		int var1 = FloorDecoration.canvasWidth;
		int var2 = WallDecoration.canvasHeight;
		if (super.contentWidth < var1) {
			var1 = super.contentWidth;
		}

		if (super.contentHeight < var2) {
			var2 = super.contentHeight;
		}

		if (AbstractArchive.clientPreferences != null) {
			try {
				Client var3 = ViewportMouse.client;
				Object[] var4 = new Object[]{class247.getWindowedMode()};
				JSObject.getWindow(var3).call("resize", var4);
			} catch (Throwable var5) {
			}
		}

	}

	@ObfuscatedName("fj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1430506238"
	)
	@Export("drawLoggedIn")
	final void drawLoggedIn() {
		int var1;
		if (rootInterface != -1) {
			var1 = rootInterface;
			if (WorldMapData_0.loadInterface(var1)) {
				ChatChannel.drawModelComponents(UserComparator5.Widget_interfaceComponents[var1], -1);
			}
		}

		for (var1 = 0; var1 < rootWidgetCount; ++var1) {
			if (field841[var1]) {
				field842[var1] = true;
			}

			field847[var1] = field841[var1];
			field841[var1] = false;
		}

		field638 = cycle;
		viewportX = -1;
		viewportY = -1;
		DevicePcmPlayerProvider.field391 = null;
		if (rootInterface != -1) {
			rootWidgetCount = 0;
			ItemContainer.drawWidgets(rootInterface, 0, 0, FloorDecoration.canvasWidth, WallDecoration.canvasHeight, 0, 0, -1);
		}

		Rasterizer2D.Rasterizer2D_resetClip();
		if (showMouseCross) {
			if (mouseCrossColor == 1) {
				UrlRequest.crossSprites[mouseCrossState * 20 / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}

			if (mouseCrossColor == 2) {
				UrlRequest.crossSprites[mouseCrossState * 20 / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}
		}

		int var2;
		int var3;
		if (!isMenuOpen) {
			if (viewportX != -1) {
				var1 = viewportX;
				var2 = viewportY;
				if ((menuOptionsCount >= 2 || isItemSelected != 0 || isSpellSelected) && showMouseOverText) {
					var3 = BuddyRankComparator.getNewestMenuIdx();
					String var4;
					if (isItemSelected == 1 && menuOptionsCount < 2) {
						var4 = "Use" + " " + selectedItemName + " " + "->";
					} else if (isSpellSelected && menuOptionsCount < 2) {
						var4 = selectedSpellActionName + " " + selectedSpellName + " " + "->";
					} else {
						var4 = class40.method799(var3);
					}

					if (menuOptionsCount > 2) {
						var4 = var4 + World.colorStartTag(16777215) + " " + '/' + " " + (menuOptionsCount - 2) + " more options";
					}

					class173.fontBold12.drawRandomAlphaAndSpacing(var4, var1 + 4, var2 + 15, 16777215, 0, cycle / 1000);
				}
			}
		} else {
			var1 = UrlRequester.menuX;
			var2 = class51.menuY;
			var3 = FriendSystem.menuWidth;
			int var13 = WorldMapDecoration.menuHeight;
			int var5 = 6116423;
			Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var13, var5);
			Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var1 + 1, var2 + 18, var3 - 2, var13 - 19, 0);
			class173.fontBold12.draw("Choose Option", var1 + 3, var2 + 14, var5, -1);
			int var6 = MouseHandler.MouseHandler_x;
			int var7 = MouseHandler.MouseHandler_y;

			int var8;
			int var9;
			int var10;
			for (var8 = 0; var8 < menuOptionsCount; ++var8) {
				var9 = var2 + (menuOptionsCount - 1 - var8) * 15 + 31;
				var10 = 16777215;
				if (var6 > var1 && var6 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
					var10 = 16776960;
				}

				class173.fontBold12.draw(class40.method799(var8), var1 + 3, var9, var10, 0);
			}

			var8 = UrlRequester.menuX;
			var9 = class51.menuY;
			var10 = FriendSystem.menuWidth;
			int var11 = WorldMapDecoration.menuHeight;

			for (int var12 = 0; var12 < rootWidgetCount; ++var12) {
				if (rootWidgetXs[var12] + rootWidgetWidths[var12] > var8 && rootWidgetXs[var12] < var10 + var8 && rootWidgetHeights[var12] + rootWidgetYs[var12] > var9 && rootWidgetYs[var12] < var9 + var11) {
					field842[var12] = true;
				}
			}
		}

		if (gameDrawingMode == 3) {
			for (var1 = 0; var1 < rootWidgetCount; ++var1) {
				if (field847[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
				} else if (field842[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
				}
			}
		}

		class3.method51(WorldMapRectangle.plane, class223.localPlayer.x, class223.localPlayer.y, field698);
		field698 = 0;
	}

	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		signature = "(Lcl;I)Z",
		garbageValue = "-1809167955"
	)
	final boolean method1607(PacketWriter var1) {
		AbstractSocket var2 = var1.getSocket();
		PacketBuffer var3 = var1.packetBuffer;
		if (var2 == null) {
			return false;
		} else {
			int var6;
			String var31;
			try {
				int var5;
				if (var1.serverPacket == null) {
					if (var1.field1290) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 0, 1);
						var1.field1297 = 0;
						var1.field1290 = false;
					}

					var3.offset = 0;
					if (var3.method5395()) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 1, 1);
						var1.field1297 = 0;
					}

					var1.field1290 = true;
					ServerPacket[] var4 = class96.ServerPacket_values();
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
				var1.field1297 = 0;
				timer.method4936();
				var1.field1301 = var1.field1291;
				var1.field1291 = var1.field1300;
				var1.field1300 = var1.serverPacket;
				if (ServerPacket.field2121 == var1.serverPacket) {
					GrandExchangeOfferTotalQuantityComparator.method105(class185.field2295);
					var1.serverPacket = null;
					return true;
				}

				int var7;
				int var8;
				long var9;
				int var16;
				if (ServerPacket.field2122 == var1.serverPacket) {
					var16 = var3.method5479();
					if (var16 == 65535) {
						var16 = -1;
					}

					var5 = var3.readUnsignedShort();
					if (var5 == 65535) {
						var5 = -1;
					}

					var6 = var3.method5482();
					var7 = var3.method5482();

					for (var8 = var16; var8 <= var5; ++var8) {
						var9 = ((long)var7 << 32) + (long)var8;
						Node var42 = widgetClickMasks.get(var9);
						if (var42 != null) {
							var42.remove();
						}

						widgetClickMasks.put(new IntegerNode(var6), var9);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2167 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					NetCache.method4279(var16);
					var1.serverPacket = null;
					return true;
				}

				Widget var46;
				if (ServerPacket.field2095 == var1.serverPacket) {
					var16 = var3.method5484();
					var5 = var3.method5484();
					var6 = var3.method5482();
					var46 = Canvas.getWidget(var6);
					if (var5 != var46.rawX || var16 != var46.rawY || var46.xAlignment != 0 || var46.yAlignment != 0) {
						var46.rawX = var5;
						var46.rawY = var16;
						var46.xAlignment = 0;
						var46.yAlignment = 0;
						WorldMapSectionType.invalidateWidget(var46);
						this.alignWidget(var46);
						if (var46.type == 0) {
							GameShell.revalidateWidgetScroll(UserComparator5.Widget_interfaceComponents[var6 >> 16], var46, false);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2155 == var1.serverPacket) {
					GrandExchangeOfferTotalQuantityComparator.method105(class185.field2296);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2143 == var1.serverPacket) {
					rebootTimer = var3.method5479() * 30;
					field833 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

			boolean var45;
			if (ServerPacket.field2109 == var1.serverPacket) {
				var45 = var3.readUnsignedByte() == 1;
				if (var45) {
					class81.field1135 = class30.currentTimeMillis() - var3.readLong();
					TileItem.grandExchangeEvents = new GrandExchangeEvents(var3, true);
				} else {
					TileItem.grandExchangeEvents = null;
				}

					field832 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2118 == var1.serverPacket) {
					Occluder.method3251(var3.readStringCp1252NullTerminated());
					var1.serverPacket = null;
					return true;
				}

				int var10;
				Widget var18;
				int var19;
				if (ServerPacket.field2144 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var16 < -70000) {
						var5 += 32768;
					}

					if (var16 >= 0) {
						var18 = Canvas.getWidget(var16);
					} else {
						var18 = null;
					}

					if (var18 != null) {
						for (var7 = 0; var7 < var18.itemIds.length; ++var7) {
							var18.itemIds[var7] = 0;
							var18.itemQuantities[var7] = 0;
						}
					}

					class162.clearItemContainer(var5);
					var7 = var3.readUnsignedShort();

					for (var8 = 0; var8 < var7; ++var8) {
						var19 = var3.method5479();
						var10 = var3.method5470();
						if (var10 == 255) {
							var10 = var3.method5482();
						}

						if (var18 != null && var8 < var18.itemIds.length) {
							var18.itemIds[var8] = var19;
							var18.itemQuantities[var8] = var10;
						}

						class4.itemContainerSetItem(var5, var8, var19 - 1, var10);
					}

					if (var18 != null) {
						WorldMapSectionType.invalidateWidget(var18);
					}

					class325.method6190();
					field820[++field825 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2126 == var1.serverPacket) {
					isCameraLocked = true;
					class225.field3045 = var3.readUnsignedByte() * 16384;
					Clock.field2039 = var3.readUnsignedByte() * 128;
					GrandExchangeOfferOwnWorldComparator.field627 = var3.readUnsignedShort();
					MouseRecorder.field572 = var3.readUnsignedByte();
					Messages.field1262 = var3.readUnsignedByte();
					if (Messages.field1262 >= 100) {
						GrandExchangeOfferOwnWorldComparator.cameraX = class225.field3045 * 128 + 64;
						WorldMapIcon_1.cameraZ = Clock.field2039 * 16384 + 64;
						Varcs.cameraY = MusicPatchPcmStream.getTileHeight(GrandExchangeOfferOwnWorldComparator.cameraX, WorldMapIcon_1.cameraZ, WorldMapRectangle.plane) - GrandExchangeOfferOwnWorldComparator.field627;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2149 == var1.serverPacket) {
					GrandExchangeOfferTotalQuantityComparator.method105(class185.field2302);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2142 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readInt();
					var6 = class4.getGcDuration();
					PacketBufferNode var48 = InterfaceParent.getPacketBufferNode(ClientPacket.field2199, packetWriter.isaacCipher);
					var48.packetBuffer.method5468(var6);
					var48.packetBuffer.writeInt(var16);
					var48.packetBuffer.method5489(var5);
					var48.packetBuffer.method5461(GameShell.fps);
					packetWriter.addNode(var48);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2164 == var1.serverPacket) {
					class325.method6190();
					weight = var3.readShort();
					field833 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2157 == var1.serverPacket) {
					var16 = var3.readInt();
					if (var16 != field718) {
						field718 = var16;
						UserComparator4.method3350();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2115 == var1.serverPacket) {
					if (Varps.clanChat != null) {
						Varps.clanChat.method5166(var3);
					}

					class185.method3593();
					var1.serverPacket = null;
					return true;
				}

				InterfaceParent var17;
				Widget var20;
				if (ServerPacket.field2166 == var1.serverPacket) {
					var16 = var3.method5482();
					var5 = var3.readInt();
					InterfaceParent var52 = (InterfaceParent)interfaceParents.get((long)var5);
					var17 = (InterfaceParent)interfaceParents.get((long)var16);
					if (var17 != null) {
						FontName.closeInterface(var17, var52 == null || var17.group != var52.group);
					}

					if (var52 != null) {
						var52.remove();
						interfaceParents.put(var52, (long)var16);
					}

					var20 = Canvas.getWidget(var5);
					if (var20 != null) {
						WorldMapSectionType.invalidateWidget(var20);
					}

					var20 = Canvas.getWidget(var16);
					if (var20 != null) {
						WorldMapSectionType.invalidateWidget(var20);
						GameShell.revalidateWidgetScroll(UserComparator5.Widget_interfaceComponents[var20.id >>> 16], var20, true);
					}

					if (rootInterface != -1) {
						class40.runIntfCloseListeners(rootInterface, 1);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2156 == var1.serverPacket) {
					Tiles.friendSystem.readUpdate(var3, var1.serverPacketLength);
					field744 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				long var12;
				long var21;
				long var23;
				String var36;
				if (ServerPacket.field2139 == var1.serverPacket) {
					var36 = var3.readStringCp1252NullTerminated();
					var21 = var3.readLong();
					var23 = (long)var3.readUnsignedShort();
					var9 = (long)var3.readMedium();
					PlayerType var11 = (PlayerType)NetSocket.findEnumerated(class226.PlayerType_values(), var3.readUnsignedByte());
					var12 = var9 + (var23 << 32);
					boolean var44 = false;

					for (int var15 = 0; var15 < 100; ++var15) {
						if (field889[var15] == var12) {
							var44 = true;
							break;
						}
					}

					if (var11.isUser && Tiles.friendSystem.isIgnored(new Username(var36, WorldMapSection1.loginType))) {
						var44 = true;
					}

					if (!var44 && field634 == 0) {
						field889[field856] = var12;
						field856 = (field856 + 1) % 100;
						String var25 = AbstractFont.escapeBrackets(NetSocket.method3471(class65.method1250(var3)));
						if (var11.modIcon != -1) {
							WorldMapData_1.addChatMessage(9, class247.method4455(var11.modIcon) + var36, var25, World.base37DecodeLong(var21));
						} else {
							WorldMapData_1.addChatMessage(9, var36, var25, World.base37DecodeLong(var21));
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2165 == var1.serverPacket) {
					var3.offset += 28;
					if (var3.checkCrc()) {
						ArchiveDisk.method5801(var3, var3.offset - 28);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2145 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					if (var3.readUnsignedByte() == 0) {
						grandExchangeOffers[var16] = new GrandExchangeOffer();
						var3.offset += 18;
					} else {
						--var3.offset;
						grandExchangeOffers[var16] = new GrandExchangeOffer(var3, false);
					}

					field831 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2106 == var1.serverPacket) {
					var16 = var3.method5504();
					var5 = var3.method5492();
					var18 = Canvas.getWidget(var5);
					if (var16 != var18.sequenceId || var16 == -1) {
						var18.sequenceId = var16;
						var18.modelFrame = 0;
						var18.modelFrameCycle = 0;
						WorldMapSectionType.invalidateWidget(var18);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2170 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.method5482();
					var6 = var3.method5479();
					if (var6 == 65535) {
						var6 = -1;
					}

					var46 = Canvas.getWidget(var16);
					ItemDefinition var50;
					if (!var46.isIf3) {
						if (var6 == -1) {
							var46.modelType = 0;
							var1.serverPacket = null;
							return true;
						}

						var50 = Occluder.ItemDefinition_get(var6);
						var46.modelType = 4;
						var46.modelId = var6;
						var46.modelAngleX = var50.xan2d;
						var46.modelAngleY = var50.yan2d;
						var46.modelZoom = var50.zoom2d * 100 / var5;
						WorldMapSectionType.invalidateWidget(var46);
					} else {
						var46.itemId = var6;
						var46.itemQuantity = var5;
						var50 = Occluder.ItemDefinition_get(var6);
						var46.modelAngleX = var50.xan2d;
						var46.modelAngleY = var50.yan2d;
						var46.modelAngleZ = var50.zan2d;
						var46.modelOffsetX = var50.offsetX2d;
						var46.modelOffsetY = var50.offsetY2d;
						var46.modelZoom = var50.zoom2d;
						if (var50.isStackable == 1) {
							var46.itemQuantityMode = 1;
						} else {
							var46.itemQuantityMode = 2;
						}

						if (var46.field2667 > 0) {
							var46.modelZoom = var46.modelZoom * 32 / var46.field2667;
						} else if (var46.rawWidth > 0) {
							var46.modelZoom = var46.modelZoom * 32 / var46.rawWidth;
						}

						WorldMapSectionType.invalidateWidget(var46);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2141 == var1.serverPacket) {
					var16 = var3.method5492();
					var5 = var3.method5480();
					var18 = Canvas.getWidget(var16);
					if (var18.modelType != 2 || var5 != var18.modelId) {
						var18.modelType = 2;
						var18.modelId = var5;
						WorldMapSectionType.invalidateWidget(var18);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2114 == var1.serverPacket) {
					GrandExchangeOfferTotalQuantityComparator.method105(class185.field2301);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2129 == var1.serverPacket) {
					var36 = var3.readStringCp1252NullTerminated();
					var21 = (long)var3.readUnsignedShort();
					var23 = (long)var3.readMedium();
					PlayerType var26 = (PlayerType)NetSocket.findEnumerated(class226.PlayerType_values(), var3.readUnsignedByte());
					long var27 = (var21 << 32) + var23;
					boolean var29 = false;

					for (int var13 = 0; var13 < 100; ++var13) {
						if (field889[var13] == var27) {
							var29 = true;
							break;
						}
					}

					if (Tiles.friendSystem.isIgnored(new Username(var36, WorldMapSection1.loginType))) {
						var29 = true;
					}

					if (!var29 && field634 == 0) {
						field889[field856] = var27;
						field856 = (field856 + 1) % 100;
						String var30 = AbstractFont.escapeBrackets(NetSocket.method3471(class65.method1250(var3)));
						byte var14;
						if (var26.isPrivileged) {
							var14 = 7;
						} else {
							var14 = 3;
						}

						if (var26.modIcon != -1) {
							class210.addGameMessage(var14, class247.method4455(var26.modIcon) + var36, var30);
						} else {
							class210.addGameMessage(var14, var36, var30);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				Widget var55;
				if (ServerPacket.field2103 == var1.serverPacket) {
					var16 = var3.method5482();
					var55 = Canvas.getWidget(var16);

					for (var6 = 0; var6 < var55.itemIds.length; ++var6) {
						var55.itemIds[var6] = -1;
						var55.itemIds[var6] = 0;
					}

					WorldMapSectionType.invalidateWidget(var55);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2159 == var1.serverPacket) {
					InterfaceParent.updateNpcs(true, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2137 == var1.serverPacket) {
					var16 = var3.method5561();
					var5 = var3.method5479();
					Varps.Varps_temp[var5] = var16;
					if (Varps.Varps_main[var5] != var16) {
						Varps.Varps_main[var5] = var16;
					}

					NetSocket.method3472(var5);
					field782[++field823 - 1 & 31] = var5;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2124 == var1.serverPacket) {
					class40.field326 = var3.method5471();
					WorldMapSection2.field195 = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2146 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedByte();
					var7 = var3.readUnsignedByte();
					field835[var16] = true;
					field882[var16] = var5;
					field883[var16] = var6;
					field884[var16] = var7;
					field885[var16] = 0;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2175 == var1.serverPacket) {
					var16 = var3.method5511();
					var31 = var3.readStringCp1252NullTerminated();
					var6 = var3.method5470();
					if (var6 >= 1 && var6 <= 8) {
						if (var31.equalsIgnoreCase("null")) {
							var31 = null;
						}

						playerMenuActions[var6 - 1] = var31;
						playerOptionsPriorities[var6 - 1] = var16 == 0;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2177 == var1.serverPacket) {
					World var39 = new World();
					var39.host = var3.readStringCp1252NullTerminated();
					var39.id = var3.readUnsignedShort();
					var5 = var3.readInt();
					var39.properties = var5;
					MouseRecorder.updateGameState(45);
					var2.close();
					var2 = null;
					class4.changeWorld(var39);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2162 == var1.serverPacket) {
					Tiles.friendSystem.method1864();
					field744 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2130 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					SequenceDefinition.forceDisconnect(var16);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2171 == var1.serverPacket) {
					isCameraLocked = false;

					for (var16 = 0; var16 < 5; ++var16) {
						field835[var16] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2173 == var1.serverPacket) {
					GrandExchangeOfferTotalQuantityComparator.method105(class185.field2297);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2168 == var1.serverPacket) {
					if (var1.serverPacketLength == 0) {
						Varps.clanChat = null;
					} else {
						if (Varps.clanChat == null) {
							Varps.clanChat = new ClanChat(WorldMapSection1.loginType, ViewportMouse.client);
						}

						Varps.clanChat.readUpdate(var3);
					}

					class185.method3593();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2174 == var1.serverPacket) {
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
						hintArrowHeight = var3.readUnsignedByte() * 2;
					}

					if (hintArrowType == 10) {
						hintArrowPlayerIndex = var3.readUnsignedShort();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2152 == var1.serverPacket) {
					var16 = var3.method5480();
					WorldMapAreaData.method717(var16);
					field820[++field825 - 1 & 31] = var16 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2183 == var1.serverPacket) {
					var16 = var3.method5480();
					rootInterface = var16;
					this.resizeRoot(false);
					WorldMapManager.Widget_resetModelFrames(var16);
					class186.runWidgetOnLoadListener(rootInterface);

					for (var5 = 0; var5 < 100; ++var5) {
						field841[var5] = true;
					}

					var1.serverPacket = null;
					return true;
				}

				String var51;
				if (ServerPacket.field2097 == var1.serverPacket) {
					var16 = var3.readUShortSmart();
					boolean var43 = var3.readUnsignedByte() == 1;
					var51 = "";
					boolean var41 = false;
					if (var43) {
						var51 = var3.readStringCp1252NullTerminated();
						if (Tiles.friendSystem.isIgnored(new Username(var51, WorldMapSection1.loginType))) {
							var41 = true;
						}
					}

					String var49 = var3.readStringCp1252NullTerminated();
					if (!var41) {
						class210.addGameMessage(var16, var51, var49);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2161 == var1.serverPacket) {
					PlayerType.loadRegions(false, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2098 == var1.serverPacket) {
					byte[] var38 = new byte[var1.serverPacketLength];
					var3.method5400(var38, 0, var38.length);
					Buffer var59 = new Buffer(var38);
					var51 = var59.readStringCp1252NullTerminated();
					ArchiveDiskActionHandler.openURL(var51, true, false);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2132 == var1.serverPacket) {
					var45 = var3.readUnsignedByte() == 1;
					var5 = var3.method5482();
					var18 = Canvas.getWidget(var5);
					if (var45 != var18.isHidden) {
						var18.isHidden = var45;
						WorldMapSectionType.invalidateWidget(var18);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2134 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var16 < -70000) {
						var5 += 32768;
					}

					if (var16 >= 0) {
						var18 = Canvas.getWidget(var16);
					} else {
						var18 = null;
					}

					for (; var3.offset < var1.serverPacketLength; class4.itemContainerSetItem(var5, var7, var8 - 1, var19)) {
						var7 = var3.readUShortSmart();
						var8 = var3.readUnsignedShort();
						var19 = 0;
						if (var8 != 0) {
							var19 = var3.readUnsignedByte();
							if (var19 == 255) {
								var19 = var3.readInt();
							}
						}

						if (var18 != null && var7 >= 0 && var7 < var18.itemIds.length) {
							var18.itemIds[var7] = var8;
							var18.itemQuantities[var7] = var19;
						}
					}

					if (var18 != null) {
						WorldMapSectionType.invalidateWidget(var18);
					}

					class325.method6190();
					field820[++field825 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2158 == var1.serverPacket) {
					var16 = var3.method5561();
					var5 = var3.method5480();
					var18 = Canvas.getWidget(var16);
					if (var18.modelType != 1 || var5 != var18.modelId) {
						var18.modelType = 1;
						var18.modelId = var5;
						WorldMapSectionType.invalidateWidget(var18);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2135 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.method5482();
					var6 = var16 >> 10 & 31;
					var7 = var16 >> 5 & 31;
					var8 = var16 & 31;
					var19 = (var7 << 11) + (var6 << 19) + (var8 << 3);
					Widget var57 = Canvas.getWidget(var5);
					if (var19 != var57.color) {
						var57.color = var19;
						WorldMapSectionType.invalidateWidget(var57);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2102 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.method5480();
					var6 = var3.method5647();
					var7 = var3.readInt();
					var20 = Canvas.getWidget(var7);
					if (var5 != var20.modelAngleX || var6 != var20.modelAngleY || var16 != var20.modelZoom) {
						var20.modelAngleX = var5;
						var20.modelAngleY = var6;
						var20.modelZoom = var16;
						WorldMapSectionType.invalidateWidget(var20);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2101 == var1.serverPacket) {
					tradeChatMode = var3.method5511();
					publicChatMode = var3.method5470();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2140 == var1.serverPacket) {
					class325.method6190();
					var16 = var3.method5561();
					var5 = var3.method5470();
					var6 = var3.method5511();
					experience[var5] = var16;
					currentLevels[var5] = var6;
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

				if (ServerPacket.field2150 == var1.serverPacket) {
					minimapState = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2107 == var1.serverPacket) {
					var16 = var3.method5480();
					var5 = var3.method5492();
					var6 = var3.method5647();
					var46 = Canvas.getWidget(var5);
					var46.field2601 = var16 + (var6 << 16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2151 == var1.serverPacket) {
					var36 = var3.readStringCp1252NullTerminated();
					Object[] var58 = new Object[var36.length() + 1];

					for (var6 = var36.length() - 1; var6 >= 0; --var6) {
						if (var36.charAt(var6) == 's') {
							var58[var6 + 1] = var3.readStringCp1252NullTerminated();
						} else {
							var58[var6 + 1] = new Integer(var3.readInt());
						}
					}

					var58[0] = new Integer(var3.readInt());
					ScriptEvent var47 = new ScriptEvent();
					var47.args = var58;
					ParamDefinition.runScriptEvent(var47);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2163 == var1.serverPacket) {
					isCameraLocked = true;
					GameShell.field455 = var3.readUnsignedByte() * 128;
					SecureRandomFuture.field1228 = var3.readUnsignedByte() * 128;
					class14.field90 = var3.readUnsignedShort();
					class80.field1126 = var3.readUnsignedByte();
					ScriptEvent.field570 = var3.readUnsignedByte();
					if (ScriptEvent.field570 >= 100) {
						var16 = GameShell.field455 * 16384 + 64;
						var5 = SecureRandomFuture.field1228 * 16384 + 64;
						var6 = MusicPatchPcmStream.getTileHeight(var16, var5, WorldMapRectangle.plane) - class14.field90;
						var7 = var16 - GrandExchangeOfferOwnWorldComparator.cameraX;
						var8 = var6 - Varcs.cameraY;
						var19 = var5 - WorldMapIcon_1.cameraZ;
						var10 = (int)Math.sqrt((double)(var19 * var19 + var7 * var7));
						IgnoreList.cameraPitch = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
						WorldMapSection2.cameraYaw = (int)(Math.atan2((double)var7, (double)var19) * -325.949D) & 2047;
						if (IgnoreList.cameraPitch < 128) {
							IgnoreList.cameraPitch = 128;
						}

						if (IgnoreList.cameraPitch > 383) {
							IgnoreList.cameraPitch = 383;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2136 == var1.serverPacket) {
					GrandExchangeOfferTotalQuantityComparator.method105(class185.field2300);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2125 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedShort();
					var17 = (InterfaceParent)interfaceParents.get((long)var16);
					if (var17 != null) {
						FontName.closeInterface(var17, var6 != var17.group);
					}

					WorldMapManager.method679(var16, var6, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2172 == var1.serverPacket) {
					GrandExchangeOfferTotalQuantityComparator.method105(class185.field2299);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2180 == var1.serverPacket) {
					var16 = var3.readInt();
					InterfaceParent var56 = (InterfaceParent)interfaceParents.get((long)var16);
					if (var56 != null) {
						FontName.closeInterface(var56, true);
					}

					if (meslayerContinueWidget != null) {
						WorldMapSectionType.invalidateWidget(meslayerContinueWidget);
						meslayerContinueWidget = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2117 == var1.serverPacket) {
					var16 = var3.method5480();
					byte var40 = var3.readByte();
					Varps.Varps_temp[var16] = var40;
					if (Varps.Varps_main[var16] != var40) {
						Varps.Varps_main[var16] = var40;
					}

					NetSocket.method3472(var16);
					field782[++field823 - 1 & 31] = var16;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2182 == var1.serverPacket) {
					class325.method6190();
					runEnergy = var3.readUnsignedByte();
					field833 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2176 == var1.serverPacket) {
					var16 = var3.method5482();
					var55 = Canvas.getWidget(var16);
					var55.modelType = 3;
					var55.modelId = class223.localPlayer.appearance.getChatHeadId();
					WorldMapSectionType.invalidateWidget(var55);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2160 == var1.serverPacket) {
					WorldMapSection2.field195 = var3.method5511();
					class40.field326 = var3.method5471();

					for (var16 = class40.field326; var16 < class40.field326 + 8; ++var16) {
						for (var5 = WorldMapSection2.field195; var5 < WorldMapSection2.field195 + 8; ++var5) {
							if (groundItems[WorldMapRectangle.plane][var16][var5] != null) {
								groundItems[WorldMapRectangle.plane][var16][var5] = null;
								WorldMapCacheName.updateItemPile(var16, var5);
							}
						}
					}

					for (PendingSpawn var37 = (PendingSpawn)pendingSpawns.last(); var37 != null; var37 = (PendingSpawn)pendingSpawns.previous()) {
						if (var37.x >= class40.field326 && var37.x < class40.field326 + 8 && var37.y >= WorldMapSection2.field195 && var37.y < WorldMapSection2.field195 + 8 && var37.plane == WorldMapRectangle.plane) {
							var37.hitpoints = 0;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2123 == var1.serverPacket) {
					class185.readReflectionCheck(var3, var1.serverPacketLength);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2169 == var1.serverPacket) {
					for (var16 = 0; var16 < Varps.Varps_main.length; ++var16) {
						if (Varps.Varps_temp[var16] != Varps.Varps_main[var16]) {
							Varps.Varps_main[var16] = Varps.Varps_temp[var16];
							NetSocket.method3472(var16);
							field782[++field823 - 1 & 31] = var16;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2154 == var1.serverPacket) {
					Tiles.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
					class195.FriendSystem_invalidateIgnoreds();
					field744 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2148 == var1.serverPacket) {
					InterfaceParent.updateNpcs(false, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2116 == var1.serverPacket) {
					PlayerType.loadRegions(true, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2127 == var1.serverPacket) {
					var16 = var3.method5482();
					var31 = var3.readStringCp1252NullTerminated();
					var18 = Canvas.getWidget(var16);
					if (!var31.equals(var18.text)) {
						var18.text = var31;
						WorldMapSectionType.invalidateWidget(var18);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2100 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					if (var16 == 65535) {
						var16 = -1;
					}

					MusicPatchNode2.playSong(var16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2178 == var1.serverPacket) {
					var16 = var3.method5647();
					if (var16 == 65535) {
						var16 = -1;
					}

					var5 = var3.method5488();
					ClientPacket.playSoundJingle(var16, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2096 == var1.serverPacket) {
					GrandExchangeOfferTotalQuantityComparator.method105(class185.field2298);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2099 == var1.serverPacket) {
					for (var16 = 0; var16 < VarpDefinition.VarpDefinition_fileCount; ++var16) {
						VarpDefinition var54 = AbstractWorldMapData.method288(var16);
						if (var54 != null) {
							Varps.Varps_temp[var16] = 0;
							Varps.Varps_main[var16] = 0;
						}
					}

					class325.method6190();
					field823 += 32;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2104 == var1.serverPacket) {
					GrandExchangeOfferTotalQuantityComparator.method105(class185.field2304);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2133 == var1.serverPacket) {
					var16 = var3.offset + var1.serverPacketLength;
					var5 = var3.readUnsignedShort();
					var6 = var3.readUnsignedShort();
					if (var5 != rootInterface) {
						rootInterface = var5;
						this.resizeRoot(false);
						WorldMapManager.Widget_resetModelFrames(rootInterface);
						class186.runWidgetOnLoadListener(rootInterface);

						for (var7 = 0; var7 < 100; ++var7) {
							field841[var7] = true;
						}
					}

					InterfaceParent var32;
					for (; var6-- > 0; var32.field552 = true) {
						var7 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var19 = var3.readUnsignedByte();
						var32 = (InterfaceParent)interfaceParents.get((long)var7);
						if (var32 != null && var8 != var32.group) {
							FontName.closeInterface(var32, true);
							var32 = null;
						}

						if (var32 == null) {
							var32 = WorldMapManager.method679(var7, var8, var19);
						}
					}

					for (var17 = (InterfaceParent)interfaceParents.first(); var17 != null; var17 = (InterfaceParent)interfaceParents.next()) {
						if (var17.field552) {
							var17.field552 = false;
						} else {
							FontName.closeInterface(var17, true);
						}
					}

					widgetClickMasks = new NodeHashTable(512);

					while (var3.offset < var16) {
						var7 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var19 = var3.readUnsignedShort();
						var10 = var3.readInt();

						for (int var33 = var8; var33 <= var19; ++var33) {
							var12 = (long)var33 + ((long)var7 << 32);
							widgetClickMasks.put(new IntegerNode(var10), var12);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2179 == var1.serverPacket) {
					var36 = var3.readStringCp1252NullTerminated();
					var31 = AbstractFont.escapeBrackets(NetSocket.method3471(class65.method1250(var3)));
					class210.addGameMessage(6, var36, var31);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2111 == var1.serverPacket) {
					DynamicObject.logOut();
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2128 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedShort();
					Message.queueSoundEffect(var16, var5, var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2113 == var1.serverPacket) {
					WorldMapManager.updatePlayers(var3, var1.serverPacketLength);
					Archive.method4250();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2105 == var1.serverPacket) {
					GrandExchangeOfferTotalQuantityComparator.method105(class185.field2303);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2153 == var1.serverPacket) {
					if (rootInterface != -1) {
						class40.runIntfCloseListeners(rootInterface, 0);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2110 == var1.serverPacket) {
					class40.field326 = var3.method5471();
					WorldMapSection2.field195 = var3.readUnsignedByte();

					while (var3.offset < var1.serverPacketLength) {
						var16 = var3.readUnsignedByte();
						class185 var53 = WorldMapDecoration.method348()[var16];
						GrandExchangeOfferTotalQuantityComparator.method105(var53);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2147 == var1.serverPacket) {
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

				if (ServerPacket.field2120 == var1.serverPacket) {
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

				if (ServerPacket.field2112 == var1.serverPacket) {
					class219.privateChatMode = Fonts.method5273(var3.readUnsignedByte());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2138 == var1.serverPacket) {
					var45 = var3.readBoolean();
					if (var45) {
						if (StudioGame.field3086 == null) {
							StudioGame.field3086 = new class237();
						}
					} else {
						StudioGame.field3086 = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2119 == var1.serverPacket) {
					var16 = var3.method5482();
					var5 = var3.method5647();
					var18 = Canvas.getWidget(var16);
					if (var18 != null && var18.type == 0) {
						if (var5 > var18.scrollHeight - var18.height) {
							var5 = var18.scrollHeight - var18.height;
						}

						if (var5 < 0) {
							var5 = 0;
						}

						if (var5 != var18.scrollY) {
							var18.scrollY = var5;
							WorldMapSectionType.invalidateWidget(var18);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				class32.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1291 != null ? var1.field1291.id : -1) + "," + (var1.field1301 != null ? var1.field1301.id : -1) + "," + var1.serverPacketLength, (Throwable)null);
				DynamicObject.logOut();
			} catch (IOException var34) {
				MouseRecorder.method1213();
			} catch (Exception var35) {
				var31 = "" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1291 != null ? var1.field1291.id : -1) + "," + (var1.field1301 != null ? var1.field1301.id : -1) + "," + var1.serverPacketLength + "," + (class223.localPlayer.pathX[0] + class223.baseX * 64) + "," + (class223.localPlayer.pathY[0] + class286.baseY * 64) + ",";

				for (var6 = 0; var6 < var1.serverPacketLength && var6 < 50; ++var6) {
					var31 = var31 + var3.array[var6] + ",";
				}

				class32.RunException_sendStackTrace(var31, var35);
				DynamicObject.logOut();
			}

			return true;
		}
	}

	@ObfuscatedName("he")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "255"
	)
	@Export("menu")
	final void menu() {
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

		if (Frames.dragInventoryWidget == null) {
			if (clickedWidget == null) {
				int var16 = MouseHandler.MouseHandler_lastButton;
				int var13;
				int var14;
				if (isMenuOpen) {
					int var7;
					int var8;
					int var17;
					if (var16 != 1 && (WorldMapIcon_1.mouseCam || var16 != 4)) {
						var2 = MouseHandler.MouseHandler_x;
						var13 = MouseHandler.MouseHandler_y;
						if (var2 < UrlRequester.menuX - 10 || var2 > FriendSystem.menuWidth + UrlRequester.menuX + 10 || var13 < class51.menuY - 10 || var13 > class51.menuY + WorldMapDecoration.menuHeight + 10) {
							isMenuOpen = false;
							var14 = UrlRequester.menuX;
							var5 = class51.menuY;
							var17 = FriendSystem.menuWidth;
							var7 = WorldMapDecoration.menuHeight;

							for (var8 = 0; var8 < rootWidgetCount; ++var8) {
								if (rootWidgetWidths[var8] + rootWidgetXs[var8] > var14 && rootWidgetXs[var8] < var17 + var14 && rootWidgetHeights[var8] + rootWidgetYs[var8] > var5 && rootWidgetYs[var8] < var5 + var7) {
									field841[var8] = true;
								}
							}
						}
					}

					if (var16 == 1 || !WorldMapIcon_1.mouseCam && var16 == 4) {
						var2 = UrlRequester.menuX;
						var13 = class51.menuY;
						var14 = FriendSystem.menuWidth;
						var5 = MouseHandler.MouseHandler_lastPressedX;
						var17 = MouseHandler.MouseHandler_lastPressedY;
						var7 = -1;

						int var9;
						for (var8 = 0; var8 < menuOptionsCount; ++var8) {
							var9 = (menuOptionsCount - 1 - var8) * 15 + var13 + 31;
							if (var5 > var2 && var5 < var14 + var2 && var17 > var9 - 13 && var17 < var9 + 3) {
								var7 = var8;
							}
						}

						if (var7 != -1) {
							ModelData0.clickMenuIndex(var7);
						}

						isMenuOpen = false;
						var8 = UrlRequester.menuX;
						var9 = class51.menuY;
						int var10 = FriendSystem.menuWidth;
						int var11 = WorldMapDecoration.menuHeight;

						for (int var12 = 0; var12 < rootWidgetCount; ++var12) {
							if (rootWidgetXs[var12] + rootWidgetWidths[var12] > var8 && rootWidgetXs[var12] < var8 + var10 && rootWidgetHeights[var12] + rootWidgetYs[var12] > var9 && rootWidgetYs[var12] < var11 + var9) {
								field841[var12] = true;
							}
						}
					}
				} else {
					var2 = BuddyRankComparator.getNewestMenuIdx();
					if ((var16 == 1 || !WorldMapIcon_1.mouseCam && var16 == 4) && var2 >= 0) {
						var13 = menuOpcodes[var2];
						if (var13 == 39 || var13 == 40 || var13 == 41 || var13 == 42 || var13 == 43 || var13 == 33 || var13 == 34 || var13 == 35 || var13 == 36 || var13 == 37 || var13 == 38 || var13 == 1005) {
							var14 = menuArguments1[var2];
							var5 = menuArguments2[var2];
							Widget var15 = Canvas.getWidget(var5);
							if (ModelData0.method3215(class2.getWidgetClickMask(var15)) || WorldMapSection0.method249(class2.getWidgetClickMask(var15))) {
								if (Frames.dragInventoryWidget != null && !field748 && menuOptionsCount > 0 && !this.shouldLeftClickOpenMenu()) {
									class3.method47(field745, field746);
								}

								field748 = false;
								itemDragDuration = 0;
								if (Frames.dragInventoryWidget != null) {
									WorldMapSectionType.invalidateWidget(Frames.dragInventoryWidget);
								}

								Frames.dragInventoryWidget = Canvas.getWidget(var5);
								dragItemSlotSource = var14;
								field745 = MouseHandler.MouseHandler_lastPressedX;
								field746 = MouseHandler.MouseHandler_lastPressedY;
								if (var2 >= 0) {
									ChatChannel.method2229(var2);
								}

								WorldMapSectionType.invalidateWidget(Frames.dragInventoryWidget);
								return;
							}
						}
					}

					if ((var16 == 1 || !WorldMapIcon_1.mouseCam && var16 == 4) && this.shouldLeftClickOpenMenu()) {
						var16 = 2;
					}

					if ((var16 == 1 || !WorldMapIcon_1.mouseCam && var16 == 4) && menuOptionsCount > 0) {
						ModelData0.clickMenuIndex(var2);
					}

					if (var16 == 2 && menuOptionsCount > 0) {
						this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
					}
				}

			}
		}
	}

	@ObfuscatedName("hq")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-5"
	)
	@Export("shouldLeftClickOpenMenu")
	final boolean shouldLeftClickOpenMenu() {
		int var1 = BuddyRankComparator.getNewestMenuIdx();
		return (leftClickOpensMenu == 1 && menuOptionsCount > 2 || ParamDefinition.method4480(var1)) && !menuShiftClick[var1];
	}

	@ObfuscatedName("ho")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1638335073"
	)
	@Export("openMenu")
	final void openMenu(int screenX, int screenY) {
		UserComparator6.calculateMenuBounds(screenX, screenY);
		PacketWriter.scene.menuOpen(WorldMapRectangle.plane, screenX, screenY, false);
		isMenuOpen = true;
	}

	@ObfuscatedName("ij")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "313560965"
	)
	@Export("resizeRoot")
	final void resizeRoot(boolean var1) {
		class247.resizeComponents(rootInterface, FloorDecoration.canvasWidth, WallDecoration.canvasHeight, var1);
	}

	@ObfuscatedName("is")
	@ObfuscatedSignature(
		signature = "(Lho;B)V",
		garbageValue = "1"
	)
	@Export("alignWidget")
	void alignWidget(Widget var1) {
		Widget var2 = var1.parentId == -1 ? null : Canvas.getWidget(var1.parentId);
		int var3;
		int var4;
		if (var2 == null) {
			var3 = FloorDecoration.canvasWidth;
			var4 = WallDecoration.canvasHeight;
		} else {
			var3 = var2.width;
			var4 = var2.height;
		}

		TileItem.alignWidgetSize(var1, var3, var4, false);
		class30.alignWidgetPosition(var1, var3, var4);
	}

	@ObfuscatedName("jt")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-808375331"
	)
	final void method1328() {
		WorldMapSectionType.invalidateWidget(clickedWidget);
		++ViewportMouse.widgetDragDuration;
		if (field817 && field814) {
			int var1 = MouseHandler.MouseHandler_x;
			int var2 = MouseHandler.MouseHandler_y;
			var1 -= widgetClickX;
			var2 -= widgetClickY;
			if (var1 < field695) {
				var1 = field695;
			}

			if (var1 + clickedWidget.width > field695 + clickedWidgetParent.width) {
				var1 = field695 + clickedWidgetParent.width - clickedWidget.width;
			}

			if (var2 < field816) {
				var2 = field816;
			}

			if (var2 + clickedWidget.height > field816 + clickedWidgetParent.height) {
				var2 = field816 + clickedWidgetParent.height - clickedWidget.height;
			}

			int var3 = var1 - field818;
			int var4 = var2 - field819;
			int var5 = clickedWidget.dragZoneSize;
			if (ViewportMouse.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
				isDraggingWidget = true;
			}

			int var6 = var1 - field695 + clickedWidgetParent.scrollX;
			int var7 = var2 - field816 + clickedWidgetParent.scrollY;
			ScriptEvent var8;
			if (clickedWidget.onDrag != null && isDraggingWidget) {
				var8 = new ScriptEvent();
				var8.widget = clickedWidget;
				var8.mouseX = var6;
				var8.mouseY = var7;
				var8.args = clickedWidget.onDrag;
				ParamDefinition.runScriptEvent(var8);
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
						ParamDefinition.runScriptEvent(var8);
					}

					if (draggedOnWidget != null && GrandExchangeEvents.method81(clickedWidget) != null) {
						PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2278, packetWriter.isaacCipher);
						var9.packetBuffer.writeShortLE(draggedOnWidget.childIndex);
						var9.packetBuffer.writeShortLE(draggedOnWidget.itemId);
						var9.packetBuffer.method5476(clickedWidget.childIndex);
						var9.packetBuffer.method5630(draggedOnWidget.id);
						var9.packetBuffer.writeIntME(clickedWidget.itemId);
						var9.packetBuffer.writeInt(clickedWidget.id);
						packetWriter.addNode(var9);
					}
				} else if (this.shouldLeftClickOpenMenu()) {
					this.openMenu(field818 + widgetClickX, widgetClickY + field819);
				} else if (menuOptionsCount > 0) {
					class3.method47(field818 + widgetClickX, field819 + widgetClickY);
				}

				clickedWidget = null;
			}

		} else {
			if (ViewportMouse.widgetDragDuration > 1) {
				clickedWidget = null;
			}

		}
	}

	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		signature = "(S)Ljq;",
		garbageValue = "9955"
	)
	@Export("username")
	public Username username() {
		return class223.localPlayer != null ? class223.localPlayer.username : null;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "431297908"
	)
	public static void method1566() {
		if (MouseHandler.MouseHandler_instance != null) {
			synchronized(MouseHandler.MouseHandler_instance) {
				MouseHandler.MouseHandler_instance = null;
			}
		}

	}

	@ObfuscatedName("q")
	static int method1708(long var0) {
		return (int)(var0 >>> 14 & 3L);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-1109826367"
	)
	static int method1750(int var0, Script var1, boolean var2) {
		Widget var3 = Canvas.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		if (var0 == ScriptOpcodes.IF_GETSCROLLX) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollX;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETSCROLLY) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollY;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETTEXT) {
			Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.text;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETSCROLLWIDTH) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollWidth;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETSCROLLHEIGHT) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollHeight;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETMODELZOOM) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelZoom;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETMODELANGLE_X) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleX;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETMODELANGLE_Z) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleZ;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETMODELANGLE_Y) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleY;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETTRANSTOP) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.transparencyTop;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETTRANSBOT) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.transparencyBot;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETCOLOUR) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.color;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETFILLCOLOUR) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.color2;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETFILLMODE) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETMODELTRANSPARENT) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}
}
