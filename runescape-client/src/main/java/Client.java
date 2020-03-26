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
import netscape.javascript.JSObject;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameShell implements Usernamed {
	@ObfuscatedName("nc")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	@Export("clickedWidget")
	static Widget clickedWidget;
	@ObfuscatedName("oq")
	@ObfuscatedGetter(
		intValue = -1534976767
	)
	@Export("rootWidgetCount")
	static int rootWidgetCount;
	@ObfuscatedName("oo")
	@ObfuscatedGetter(
		intValue = -1032308699
	)
	static int field884;
	@ObfuscatedName("od")
	@ObfuscatedGetter(
		longValue = 7541257458804320211L
	)
	static long field893;
	@ObfuscatedName("oa")
	static boolean[] field679;
	@ObfuscatedName("ok")
	static boolean[] field813;
	@ObfuscatedName("ou")
	static boolean[] field886;
	@ObfuscatedName("na")
	static boolean field861;
	@ObfuscatedName("ov")
	@Export("isResizable")
	static boolean isResizable;
	@ObfuscatedName("nv")
	@ObfuscatedGetter(
		intValue = 777988173
	)
	@Export("cycleCntr")
	static int cycleCntr;
	@ObfuscatedName("su")
	@ObfuscatedGetter(
		intValue = 2073816179
	)
	public static int field891;
	@ObfuscatedName("oe")
	@ObfuscatedGetter(
		intValue = -2140267163
	)
	static int field873;
	@ObfuscatedName("ns")
	static boolean field732;
	@ObfuscatedName("qn")
	static boolean field915;
	@ObfuscatedName("np")
	@ObfuscatedGetter(
		intValue = 1891755493
	)
	@Export("widgetClickX")
	static int widgetClickX;
	@ObfuscatedName("nd")
	@ObfuscatedGetter(
		intValue = -1161612029
	)
	@Export("widgetClickY")
	static int widgetClickY;
	@ObfuscatedName("nx")
	@ObfuscatedGetter(
		intValue = 1561528451
	)
	static int field859;
	@ObfuscatedName("og")
	@ObfuscatedSignature(
		signature = "Llv;"
	)
	@Export("widgetClickMasks")
	static NodeHashTable widgetClickMasks;
	@ObfuscatedName("ng")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	@Export("clickedWidgetParent")
	static Widget clickedWidgetParent;
	@ObfuscatedName("oz")
	@Export("rootWidgetWidths")
	static int[] rootWidgetWidths;
	@ObfuscatedName("op")
	@Export("rootWidgetXs")
	static int[] rootWidgetXs;
	@ObfuscatedName("nk")
	@ObfuscatedGetter(
		intValue = -2134546849
	)
	static int field881;
	@ObfuscatedName("ne")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	@Export("viewportWidget")
	static Widget viewportWidget;
	@ObfuscatedName("oy")
	@ObfuscatedGetter(
		intValue = 881881039
	)
	@Export("gameDrawingMode")
	static int gameDrawingMode;
	@ObfuscatedName("oc")
	@Export("rootWidgetHeights")
	static int[] rootWidgetHeights;
	@ObfuscatedName("mt")
	@ObfuscatedGetter(
		intValue = 1604597695
	)
	@Export("staffModLevel")
	static int staffModLevel;
	@ObfuscatedName("ob")
	@Export("rootWidgetYs")
	static int[] rootWidgetYs;
	@ObfuscatedName("tp")
	@ObfuscatedSignature(
		signature = "Lbj;"
	)
	static final class74 field954;
	@ObfuscatedName("ow")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("scriptEvents")
	static NodeDeque scriptEvents;
	@ObfuscatedName("nt")
	@ObfuscatedGetter(
		intValue = 1322546357
	)
	static int field834;
	@ObfuscatedName("ri")
	@Export("isCameraLocked")
	static boolean isCameraLocked;
	@ObfuscatedName("rq")
	static boolean[] field926;
	@ObfuscatedName("nu")
	@ObfuscatedGetter(
		intValue = -206540409
	)
	static int field863;
	@ObfuscatedName("ru")
	static int[] field788;
	@ObfuscatedName("pu")
	@ObfuscatedGetter(
		intValue = 636733525
	)
	@Export("tradeChatMode")
	static int tradeChatMode;
	@ObfuscatedName("rp")
	static int[] field730;
	@ObfuscatedName("rs")
	static int[] field929;
	@ObfuscatedName("pr")
	@ObfuscatedGetter(
		intValue = 336519687
	)
	@Export("publicChatMode")
	static int publicChatMode;
	@ObfuscatedName("rz")
	static int[] field930;
	@ObfuscatedName("nr")
	static int[] field866;
	@ObfuscatedName("nj")
	@ObfuscatedGetter(
		intValue = -1815085637
	)
	static int field772;
	@ObfuscatedName("tj")
	static int[] field955;
	@ObfuscatedName("tk")
	static int[] field956;
	@ObfuscatedName("nf")
	@Export("isDraggingWidget")
	static boolean isDraggingWidget;
	@ObfuscatedName("qc")
	@ObfuscatedGetter(
		intValue = 1328358885
	)
	@Export("currentTrackGroupId")
	static int currentTrackGroupId;
	@ObfuscatedName("mo")
	@ObfuscatedGetter(
		intValue = 1227039409
	)
	@Export("runEnergy")
	static int runEnergy;
	@ObfuscatedName("mz")
	@ObfuscatedGetter(
		intValue = 1509251187
	)
	@Export("weight")
	static int weight;
	@ObfuscatedName("qa")
	@ObfuscatedGetter(
		intValue = -1279257455
	)
	@Export("destinationX")
	static int destinationX;
	@ObfuscatedName("qk")
	@ObfuscatedGetter(
		intValue = 1618575593
	)
	@Export("destinationY")
	static int destinationY;
	@ObfuscatedName("sv")
	@ObfuscatedGetter(
		intValue = 1159687403
	)
	static int field945;
	@ObfuscatedName("so")
	@ObfuscatedSignature(
		signature = "Lhk;"
	)
	@Export("playerAppearance")
	static PlayerAppearance playerAppearance;
	@ObfuscatedName("qy")
	@ObfuscatedGetter(
		intValue = 1461372687
	)
	@Export("areaSoundEffectVolume")
	static int areaSoundEffectVolume;
	@ObfuscatedName("se")
	@ObfuscatedGetter(
		intValue = -276070485
	)
	static int field946;
	@ObfuscatedName("on")
	@ObfuscatedGetter(
		intValue = -929260201
	)
	@Export("mouseWheelRotation")
	static int mouseWheelRotation;
	@ObfuscatedName("ni")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	@Export("draggedOnWidget")
	static Widget draggedOnWidget;
	@ObfuscatedName("om")
	@ObfuscatedGetter(
		intValue = -649542909
	)
	static int field877;
	@ObfuscatedName("qv")
	@ObfuscatedGetter(
		intValue = 702335711
	)
	@Export("musicVolume")
	static int musicVolume;
	@ObfuscatedName("qr")
	@ObfuscatedGetter(
		intValue = 2086274421
	)
	@Export("soundEffectCount")
	static int soundEffectCount;
	@ObfuscatedName("qw")
	@Export("soundEffectIds")
	static int[] soundEffectIds;
	@ObfuscatedName("qf")
	@Export("queuedSoundEffectLoops")
	static int[] queuedSoundEffectLoops;
	@ObfuscatedName("qx")
	@ObfuscatedGetter(
		intValue = -1155655175
	)
	@Export("minimapState")
	static int minimapState;
	@ObfuscatedName("qm")
	@Export("queuedSoundEffectDelays")
	static int[] queuedSoundEffectDelays;
	@ObfuscatedName("qz")
	@ObfuscatedGetter(
		intValue = 1919940513
	)
	@Export("soundEffectVolume")
	static int soundEffectVolume;
	@ObfuscatedName("qu")
	@ObfuscatedSignature(
		signature = "[Ldj;"
	)
	@Export("soundEffects")
	static SoundEffect[] soundEffects;
	@ObfuscatedName("qp")
	@Export("soundLocations")
	static int[] soundLocations;
	@ObfuscatedName("sf")
	@Export("archiveLoaders")
	static ArrayList archiveLoaders;
	@ObfuscatedName("oh")
	@ObfuscatedGetter(
		intValue = 1453786377
	)
	static int field726;
	@ObfuscatedName("sz")
	@ObfuscatedGetter(
		intValue = 1144280751
	)
	@Export("archiveLoadersDone")
	static int archiveLoadersDone;
	@ObfuscatedName("nm")
	@Export("changedItemContainers")
	static int[] changedItemContainers;
	@ObfuscatedName("ny")
	@ObfuscatedGetter(
		intValue = 387310397
	)
	static int field869;
	@ObfuscatedName("pe")
	@ObfuscatedGetter(
		longValue = 1482293430841042491L
	)
	static long field904;
	@ObfuscatedName("mu")
	@ObfuscatedGetter(
		intValue = -1182225561
	)
	@Export("chatEffects")
	static int chatEffects;
	@ObfuscatedName("md")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	@Export("meslayerContinueWidget")
	static Widget meslayerContinueWidget;
	@ObfuscatedName("me")
	@ObfuscatedGetter(
		intValue = -1652911979
	)
	static int field845;
	@ObfuscatedName("pz")
	@ObfuscatedGetter(
		intValue = -720502757
	)
	static int field695;
	@ObfuscatedName("or")
	@ObfuscatedGetter(
		intValue = -29948065
	)
	static int field874;
	@ObfuscatedName("sp")
	@ObfuscatedSignature(
		signature = "Lmm;"
	)
	@Export("platformInfoProvider")
	static PlatformInfoProvider platformInfoProvider;
	@ObfuscatedName("rg")
	static short field931;
	@ObfuscatedName("ma")
	@ObfuscatedGetter(
		intValue = 1416910623
	)
	@Export("followerIndex")
	static int followerIndex;
	@ObfuscatedName("rk")
	static short field932;
	@ObfuscatedName("rm")
	static short field937;
	@ObfuscatedName("ra")
	static short field938;
	@ObfuscatedName("pm")
	@ObfuscatedGetter(
		intValue = 2023934429
	)
	@Export("mapIconCount")
	static int mapIconCount;
	@ObfuscatedName("pp")
	static long[] field846;
	@ObfuscatedName("rw")
	static short field748;
	@ObfuscatedName("px")
	@Export("mapIconXs")
	static int[] mapIconXs;
	@ObfuscatedName("st")
	@ObfuscatedGetter(
		intValue = 1508238603
	)
	@Export("viewportZoom")
	static int viewportZoom;
	@ObfuscatedName("rr")
	static short field935;
	@ObfuscatedName("sc")
	@ObfuscatedGetter(
		intValue = 1112173289
	)
	@Export("viewportWidth")
	static int viewportWidth;
	@ObfuscatedName("nb")
	@Export("changedSkills")
	static int[] changedSkills;
	@ObfuscatedName("nh")
	@ObfuscatedGetter(
		intValue = 19610687
	)
	@Export("changedSkillsCount")
	static int changedSkillsCount;
	@ObfuscatedName("pg")
	@Export("mapIconYs")
	static int[] mapIconYs;
	@ObfuscatedName("ps")
	@ObfuscatedSignature(
		signature = "[Lla;"
	)
	@Export("mapIcons")
	static Sprite[] mapIcons;
	@ObfuscatedName("ph")
	@ObfuscatedGetter(
		intValue = 180652911
	)
	static int field900;
	@ObfuscatedName("si")
	@ObfuscatedGetter(
		intValue = 2055926497
	)
	@Export("viewportHeight")
	static int viewportHeight;
	@ObfuscatedName("ro")
	@ObfuscatedGetter(
		intValue = -367442815
	)
	@Export("viewportOffsetX")
	static int viewportOffsetX;
	@ObfuscatedName("sh")
	@ObfuscatedGetter(
		intValue = -1701342831
	)
	@Export("viewportOffsetY")
	static int viewportOffsetY;
	@ObfuscatedName("rj")
	@ObfuscatedGetter(
		intValue = -527659011
	)
	static int field925;
	@ObfuscatedName("pa")
	@ObfuscatedGetter(
		intValue = -2121206743
	)
	static int field901;
	@ObfuscatedName("os")
	@ObfuscatedGetter(
		intValue = -1525951485
	)
	@Export("chatCycle")
	static int chatCycle;
	@ObfuscatedName("sn")
	@ObfuscatedGetter(
		intValue = -453519891
	)
	static int field898;
	@ObfuscatedName("pw")
	static int[] field872;
	@ObfuscatedName("of")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	static NodeDeque field727;
	@ObfuscatedName("pk")
	static int[] field902;
	@ObfuscatedName("mh")
	@Export("playerMod")
	static boolean playerMod;
	@ObfuscatedName("ox")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	static NodeDeque field919;
	@ObfuscatedName("rn")
	@Export("zoomHeight")
	static short zoomHeight;
	@ObfuscatedName("rd")
	@Export("zoomWidth")
	static short zoomWidth;
	@ObfuscatedName("mv")
	@ObfuscatedGetter(
		intValue = -651344111
	)
	static int field842;
	@ObfuscatedName("mk")
	@ObfuscatedGetter(
		intValue = -1472818425
	)
	static int field843;
	@ObfuscatedName("sd")
	@ObfuscatedSignature(
		signature = "[Lb;"
	)
	@Export("grandExchangeOffers")
	static GrandExchangeOffer[] grandExchangeOffers;
	@ObfuscatedName("oi")
	@ObfuscatedGetter(
		intValue = -681527765
	)
	static int field774;
	@ObfuscatedName("pi")
	static int[] field895;
	@ObfuscatedName("pt")
	static String field814;
	@ObfuscatedName("sk")
	@ObfuscatedSignature(
		signature = "Lbl;"
	)
	@Export("GrandExchangeEvents_worldComparator")
	static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "[Lfm;"
	)
	@Export("collisionMaps")
	static CollisionMap[] collisionMaps;
	@ObfuscatedName("aw")
	static boolean field749;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = 67970213
	)
	@Export("worldId")
	public static int worldId;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = -454237971
	)
	@Export("worldProperties")
	static int worldProperties;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = 50872335
	)
	@Export("gameBuild")
	static int gameBuild;
	@ObfuscatedName("be")
	@Export("isMembersWorld")
	public static boolean isMembersWorld;
	@ObfuscatedName("bg")
	@Export("isLowDetail")
	static boolean isLowDetail;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = -1948298563
	)
	@Export("clientType")
	static int clientType;
	@ObfuscatedName("bv")
	@Export("onMobile")
	static boolean onMobile;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = -734659311
	)
	@Export("gameState")
	static int gameState;
	@ObfuscatedName("cg")
	@Export("isLoading")
	static boolean isLoading;
	@ObfuscatedName("cd")
	@ObfuscatedGetter(
		intValue = -2024138363
	)
	@Export("cycle")
	static int cycle;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		longValue = -2067581052141850097L
	)
	@Export("mouseLastLastPressedTimeMillis")
	static long mouseLastLastPressedTimeMillis;
	@ObfuscatedName("ci")
	@ObfuscatedGetter(
		intValue = -1167045491
	)
	static int field691;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = 736381377
	)
	static int field692;
	@ObfuscatedName("cb")
	@ObfuscatedGetter(
		longValue = -9018780370059554257L
	)
	static long field875;
	@ObfuscatedName("cy")
	@Export("hadFocus")
	static boolean hadFocus;
	@ObfuscatedName("ct")
	@Export("displayFps")
	static boolean displayFps;
	@ObfuscatedName("cf")
	@ObfuscatedGetter(
		intValue = -475175391
	)
	@Export("rebootTimer")
	static int rebootTimer;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		intValue = -1953007669
	)
	@Export("hintArrowType")
	static int hintArrowType;
	@ObfuscatedName("cj")
	@ObfuscatedGetter(
		intValue = 538709907
	)
	@Export("hintArrowNpcIndex")
	static int hintArrowNpcIndex;
	@ObfuscatedName("cp")
	@ObfuscatedGetter(
		intValue = 1820154893
	)
	@Export("hintArrowPlayerIndex")
	static int hintArrowPlayerIndex;
	@ObfuscatedName("ck")
	@ObfuscatedGetter(
		intValue = -528461793
	)
	@Export("hintArrowX")
	static int hintArrowX;
	@ObfuscatedName("ce")
	@ObfuscatedGetter(
		intValue = -89638729
	)
	@Export("hintArrowY")
	static int hintArrowY;
	@ObfuscatedName("cv")
	@ObfuscatedGetter(
		intValue = 806134121
	)
	@Export("hintArrowHeight")
	static int hintArrowHeight;
	@ObfuscatedName("cl")
	@ObfuscatedGetter(
		intValue = 1105349969
	)
	@Export("hintArrowSubX")
	static int hintArrowSubX;
	@ObfuscatedName("dv")
	@ObfuscatedGetter(
		intValue = 634022549
	)
	@Export("hintArrowSubY")
	static int hintArrowSubY;
	@ObfuscatedName("du")
	@ObfuscatedSignature(
		signature = "Lcb;"
	)
	@Export("playerAttackOption")
	static AttackOption playerAttackOption;
	@ObfuscatedName("dz")
	@ObfuscatedSignature(
		signature = "Lcb;"
	)
	@Export("npcAttackOption")
	static AttackOption npcAttackOption;
	@ObfuscatedName("dq")
	@ObfuscatedGetter(
		intValue = 1329734549
	)
	@Export("titleLoadingStage")
	static int titleLoadingStage;
	@ObfuscatedName("dm")
	@ObfuscatedGetter(
		intValue = 887284589
	)
	@Export("js5ConnectState")
	static int js5ConnectState;
	@ObfuscatedName("db")
	@ObfuscatedGetter(
		intValue = -1245813257
	)
	static int field709;
	@ObfuscatedName("eq")
	@ObfuscatedGetter(
		intValue = -303941171
	)
	@Export("js5Errors")
	static int js5Errors;
	@ObfuscatedName("ei")
	@ObfuscatedGetter(
		intValue = 1964000781
	)
	@Export("loginState")
	static int loginState;
	@ObfuscatedName("en")
	@ObfuscatedGetter(
		intValue = -1937308451
	)
	static int field712;
	@ObfuscatedName("ec")
	@ObfuscatedGetter(
		intValue = -1595212999
	)
	static int field713;
	@ObfuscatedName("ev")
	@ObfuscatedGetter(
		intValue = -1280111513
	)
	static int field714;
	@ObfuscatedName("eb")
	@ObfuscatedSignature(
		signature = "Lfu;"
	)
	static class169 field715;
	@ObfuscatedName("ez")
	@Export("Login_isUsernameRemembered")
	static boolean Login_isUsernameRemembered;
	@ObfuscatedName("ek")
	@ObfuscatedSignature(
		signature = "Lca;"
	)
	@Export("secureRandomFuture")
	static SecureRandomFuture secureRandomFuture;
	@ObfuscatedName("fk")
	@Export("randomDatData")
	static byte[] randomDatData;
	@ObfuscatedName("ff")
	@ObfuscatedSignature(
		signature = "[Lcd;"
	)
	@Export("npcs")
	static NPC[] npcs;
	@ObfuscatedName("fd")
	@ObfuscatedGetter(
		intValue = -13803859
	)
	@Export("npcCount")
	static int npcCount;
	@ObfuscatedName("fo")
	@Export("npcIndices")
	static int[] npcIndices;
	@ObfuscatedName("fi")
	@ObfuscatedGetter(
		intValue = 1186510191
	)
	static int field851;
	@ObfuscatedName("fv")
	static int[] field725;
	@ObfuscatedName("fg")
	@ObfuscatedSignature(
		signature = "Ldv;"
	)
	@Export("packetWriter")
	public static final PacketWriter packetWriter;
	@ObfuscatedName("fu")
	@ObfuscatedGetter(
		intValue = -842980155
	)
	@Export("logoutTimer")
	static int logoutTimer;
	@ObfuscatedName("ft")
	static boolean field728;
	@ObfuscatedName("fj")
	@Export("useBufferedSocket")
	static boolean useBufferedSocket;
	@ObfuscatedName("fn")
	@ObfuscatedSignature(
		signature = "Ljr;"
	)
	@Export("timer")
	static Timer timer;
	@ObfuscatedName("fe")
	@Export("fontsMap")
	static HashMap fontsMap;
	@ObfuscatedName("gw")
	@ObfuscatedGetter(
		intValue = 1736766239
	)
	static int field818;
	@ObfuscatedName("gu")
	@ObfuscatedGetter(
		intValue = 237208089
	)
	static int field921;
	@ObfuscatedName("gt")
	@ObfuscatedGetter(
		intValue = -1880791937
	)
	static int field734;
	@ObfuscatedName("gz")
	@ObfuscatedGetter(
		intValue = 313478257
	)
	static int field735;
	@ObfuscatedName("ga")
	@ObfuscatedGetter(
		intValue = -965509961
	)
	static int field899;
	@ObfuscatedName("gs")
	@Export("isInInstance")
	static boolean isInInstance;
	@ObfuscatedName("gk")
	@Export("instanceChunkTemplates")
	static int[][][] instanceChunkTemplates;
	@ObfuscatedName("gl")
	static final int[] field699;
	@ObfuscatedName("gj")
	@ObfuscatedGetter(
		intValue = -352208827
	)
	static int field741;
	@ObfuscatedName("hi")
	@ObfuscatedGetter(
		intValue = 952516679
	)
	static int field742;
	@ObfuscatedName("hl")
	@ObfuscatedGetter(
		intValue = -499490457
	)
	static int field747;
	@ObfuscatedName("hq")
	@ObfuscatedGetter(
		intValue = 1112772085
	)
	static int field744;
	@ObfuscatedName("hw")
	@ObfuscatedGetter(
		intValue = 59309843
	)
	static int field745;
	@ObfuscatedName("hb")
	static boolean field746;
	@ObfuscatedName("hd")
	@ObfuscatedGetter(
		intValue = -71090641
	)
	@Export("alternativeScrollbarWidth")
	static int alternativeScrollbarWidth;
	@ObfuscatedName("hn")
	@ObfuscatedGetter(
		intValue = -1566395531
	)
	@Export("camAngleX")
	static int camAngleX;
	@ObfuscatedName("hu")
	@ObfuscatedGetter(
		intValue = 442725255
	)
	@Export("camAngleY")
	static int camAngleY;
	@ObfuscatedName("ha")
	@ObfuscatedGetter(
		intValue = 139375317
	)
	@Export("camAngleDY")
	static int camAngleDY;
	@ObfuscatedName("ho")
	@ObfuscatedGetter(
		intValue = -2038484537
	)
	@Export("camAngleDX")
	static int camAngleDX;
	@ObfuscatedName("hr")
	@ObfuscatedGetter(
		intValue = 702140089
	)
	@Export("mouseCamClickedX")
	static int mouseCamClickedX;
	@ObfuscatedName("hv")
	@ObfuscatedGetter(
		intValue = 1980402249
	)
	@Export("mouseCamClickedY")
	static int mouseCamClickedY;
	@ObfuscatedName("hx")
	@ObfuscatedGetter(
		intValue = -167717143
	)
	@Export("oculusOrbState")
	static int oculusOrbState;
	@ObfuscatedName("im")
	@ObfuscatedGetter(
		intValue = 1280381451
	)
	@Export("camFollowHeight")
	static int camFollowHeight;
	@ObfuscatedName("ig")
	@ObfuscatedGetter(
		intValue = -586245253
	)
	static int field756;
	@ObfuscatedName("ii")
	@ObfuscatedGetter(
		intValue = 1464169135
	)
	static int field757;
	@ObfuscatedName("iv")
	@ObfuscatedGetter(
		intValue = -660367395
	)
	static int field724;
	@ObfuscatedName("ir")
	@ObfuscatedGetter(
		intValue = -949088515
	)
	static int field759;
	@ObfuscatedName("ip")
	@ObfuscatedGetter(
		intValue = -412319227
	)
	@Export("oculusOrbNormalSpeed")
	static int oculusOrbNormalSpeed;
	@ObfuscatedName("ih")
	@ObfuscatedGetter(
		intValue = -493333163
	)
	@Export("oculusOrbSlowedSpeed")
	static int oculusOrbSlowedSpeed;
	@ObfuscatedName("ia")
	@ObfuscatedGetter(
		intValue = 1356416223
	)
	static int field762;
	@ObfuscatedName("in")
	static boolean field770;
	@ObfuscatedName("ie")
	@ObfuscatedGetter(
		intValue = -472895563
	)
	static int field764;
	@ObfuscatedName("iq")
	static boolean field765;
	@ObfuscatedName("ik")
	@ObfuscatedGetter(
		intValue = 575633547
	)
	static int field941;
	@ObfuscatedName("io")
	@ObfuscatedGetter(
		intValue = -39115273
	)
	@Export("overheadTextCount")
	static int overheadTextCount;
	@ObfuscatedName("it")
	@Export("selectedItemName")
	static String selectedItemName;
	@ObfuscatedName("iw")
	@ObfuscatedGetter(
		intValue = 975397305
	)
	@Export("overheadTextLimit")
	static int overheadTextLimit;
	@ObfuscatedName("if")
	@Export("overheadTextXs")
	static int[] overheadTextXs;
	@ObfuscatedName("ib")
	@Export("overheadTextYs")
	static int[] overheadTextYs;
	@ObfuscatedName("id")
	@Export("overheadTextAscents")
	static int[] overheadTextAscents;
	@ObfuscatedName("il")
	@Export("overheadTextXOffsets")
	static int[] overheadTextXOffsets;
	@ObfuscatedName("iu")
	@Export("overheadTextColors")
	static int[] overheadTextColors;
	@ObfuscatedName("is")
	@Export("overheadTextEffects")
	static int[] overheadTextEffects;
	@ObfuscatedName("jq")
	@Export("overheadTextCyclesRemaining")
	static int[] overheadTextCyclesRemaining;
	@ObfuscatedName("ji")
	@Export("overheadText")
	static String[] overheadText;
	@ObfuscatedName("jv")
	@Export("tileLastDrawnActor")
	static int[][] tileLastDrawnActor;
	@ObfuscatedName("jw")
	@ObfuscatedGetter(
		intValue = -2121599307
	)
	@Export("viewportDrawCount")
	static int viewportDrawCount;
	@ObfuscatedName("jx")
	@ObfuscatedGetter(
		intValue = 367239901
	)
	@Export("viewportTempX")
	static int viewportTempX;
	@ObfuscatedName("je")
	@ObfuscatedGetter(
		intValue = 315568117
	)
	@Export("viewportTempY")
	static int viewportTempY;
	@ObfuscatedName("jj")
	@ObfuscatedGetter(
		intValue = 1079427097
	)
	@Export("mouseCrossX")
	static int mouseCrossX;
	@ObfuscatedName("jn")
	@ObfuscatedGetter(
		intValue = 2092751039
	)
	@Export("mouseCrossY")
	static int mouseCrossY;
	@ObfuscatedName("jc")
	@ObfuscatedGetter(
		intValue = -518761301
	)
	@Export("mouseCrossState")
	static int mouseCrossState;
	@ObfuscatedName("jl")
	@ObfuscatedGetter(
		intValue = -806793857
	)
	@Export("mouseCrossColor")
	static int mouseCrossColor;
	@ObfuscatedName("jm")
	@Export("showMouseCross")
	static boolean showMouseCross;
	@ObfuscatedName("jk")
	@ObfuscatedGetter(
		intValue = 2013290137
	)
	static int field786;
	@ObfuscatedName("jg")
	@ObfuscatedGetter(
		intValue = -1764977003
	)
	static int field880;
	@ObfuscatedName("jo")
	@ObfuscatedGetter(
		intValue = -540153301
	)
	@Export("dragItemSlotSource")
	static int dragItemSlotSource;
	@ObfuscatedName("ja")
	@ObfuscatedGetter(
		intValue = -1956792499
	)
	@Export("draggedWidgetX")
	static int draggedWidgetX;
	@ObfuscatedName("jp")
	@ObfuscatedGetter(
		intValue = -1891050173
	)
	@Export("draggedWidgetY")
	static int draggedWidgetY;
	@ObfuscatedName("jy")
	@ObfuscatedGetter(
		intValue = -1965076329
	)
	@Export("dragItemSlotDestination")
	static int dragItemSlotDestination;
	@ObfuscatedName("jf")
	static boolean field887;
	@ObfuscatedName("jr")
	@ObfuscatedGetter(
		intValue = -1524629153
	)
	@Export("itemDragDuration")
	static int itemDragDuration;
	@ObfuscatedName("jt")
	@ObfuscatedGetter(
		intValue = -1322333605
	)
	static int field794;
	@ObfuscatedName("js")
	@Export("showLoadingMessages")
	static boolean showLoadingMessages;
	@ObfuscatedName("kw")
	@ObfuscatedSignature(
		signature = "[Lbi;"
	)
	@Export("players")
	static Player[] players;
	@ObfuscatedName("ke")
	@ObfuscatedGetter(
		intValue = -767774261
	)
	@Export("localPlayerIndex")
	static int localPlayerIndex;
	@ObfuscatedName("kt")
	@ObfuscatedGetter(
		intValue = -1853665647
	)
	static int field798;
	@ObfuscatedName("kr")
	@Export("renderSelf")
	static boolean renderSelf;
	@ObfuscatedName("kk")
	@ObfuscatedGetter(
		intValue = -931711387
	)
	@Export("drawPlayerNames")
	static int drawPlayerNames;
	@ObfuscatedName("kn")
	@ObfuscatedGetter(
		intValue = 2084987415
	)
	static int field801;
	@ObfuscatedName("kq")
	static int[] field918;
	@ObfuscatedName("kc")
	@Export("playerMenuOpcodes")
	static final int[] playerMenuOpcodes;
	@ObfuscatedName("ka")
	@Export("playerMenuActions")
	static String[] playerMenuActions;
	@ObfuscatedName("kf")
	@Export("playerOptionsPriorities")
	static boolean[] playerOptionsPriorities;
	@ObfuscatedName("kg")
	@Export("defaultRotations")
	static int[] defaultRotations;
	@ObfuscatedName("kx")
	@ObfuscatedGetter(
		intValue = -246802771
	)
	@Export("combatTargetPlayerIndex")
	static int combatTargetPlayerIndex;
	@ObfuscatedName("kh")
	@ObfuscatedSignature(
		signature = "[[[Ljh;"
	)
	@Export("groundItems")
	static NodeDeque[][][] groundItems;
	@ObfuscatedName("kp")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("pendingSpawns")
	static NodeDeque pendingSpawns;
	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("projectiles")
	static NodeDeque projectiles;
	@ObfuscatedName("kj")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("graphicsObjects")
	static NodeDeque graphicsObjects;
	@ObfuscatedName("kb")
	@Export("currentLevels")
	static int[] currentLevels;
	@ObfuscatedName("kd")
	@Export("levels")
	static int[] levels;
	@ObfuscatedName("kl")
	@Export("experience")
	static int[] experience;
	@ObfuscatedName("lk")
	@ObfuscatedGetter(
		intValue = 1453030713
	)
	@Export("leftClickOpensMenu")
	static int leftClickOpensMenu;
	@ObfuscatedName("lb")
	@Export("isMenuOpen")
	static boolean isMenuOpen;
	@ObfuscatedName("lg")
	@ObfuscatedGetter(
		intValue = -637671939
	)
	@Export("menuOptionsCount")
	static int menuOptionsCount;
	@ObfuscatedName("lf")
	@Export("menuArguments1")
	static int[] menuArguments1;
	@ObfuscatedName("lx")
	@Export("menuArguments2")
	static int[] menuArguments2;
	@ObfuscatedName("ly")
	@Export("menuOpcodes")
	static int[] menuOpcodes;
	@ObfuscatedName("ll")
	@Export("menuIdentifiers")
	static int[] menuIdentifiers;
	@ObfuscatedName("lh")
	@Export("menuActions")
	static String[] menuActions;
	@ObfuscatedName("ln")
	@Export("menuTargets")
	static String[] menuTargets;
	@ObfuscatedName("lw")
	@Export("menuShiftClick")
	static boolean[] menuShiftClick;
	@ObfuscatedName("lv")
	@Export("followerOpsLowPriority")
	static boolean followerOpsLowPriority;
	@ObfuscatedName("lz")
	@Export("shiftClickDrop")
	static boolean shiftClickDrop;
	@ObfuscatedName("li")
	@Export("tapToDrop")
	static boolean tapToDrop;
	@ObfuscatedName("lj")
	@Export("showMouseOverText")
	static boolean showMouseOverText;
	@ObfuscatedName("lu")
	@ObfuscatedGetter(
		intValue = -79678249
	)
	@Export("viewportX")
	static int viewportX;
	@ObfuscatedName("le")
	@ObfuscatedGetter(
		intValue = 521048769
	)
	@Export("viewportY")
	static int viewportY;
	@ObfuscatedName("lp")
	@ObfuscatedGetter(
		intValue = -1517512791
	)
	static int field871;
	@ObfuscatedName("mp")
	@ObfuscatedGetter(
		intValue = 668929195
	)
	static int field832;
	@ObfuscatedName("mm")
	@ObfuscatedGetter(
		intValue = -19686459
	)
	@Export("isItemSelected")
	static int isItemSelected;
	@ObfuscatedName("mq")
	@ObfuscatedGetter(
		intValue = 630410191
	)
	@Export("selectedItemSlot")
	static int selectedItemSlot;
	@ObfuscatedName("mi")
	@Export("isSpellSelected")
	static boolean isSpellSelected;
	@ObfuscatedName("mw")
	@ObfuscatedGetter(
		intValue = -335979293
	)
	@Export("selectedSpellChildIndex")
	static int selectedSpellChildIndex;
	@ObfuscatedName("mj")
	@ObfuscatedGetter(
		intValue = -167301685
	)
	static int field837;
	@ObfuscatedName("mc")
	@Export("selectedSpellActionName")
	static String selectedSpellActionName;
	@ObfuscatedName("mx")
	@Export("selectedSpellName")
	static String selectedSpellName;
	@ObfuscatedName("mr")
	@ObfuscatedGetter(
		intValue = -1504817189
	)
	@Export("rootInterface")
	static int rootInterface;
	@ObfuscatedName("mn")
	@ObfuscatedSignature(
		signature = "Llv;"
	)
	@Export("interfaceParents")
	static NodeHashTable interfaceParents;
	@ObfuscatedName("eg")
	@ObfuscatedSignature(
		signature = "Lkb;"
	)
	Buffer field718;
	@ObfuscatedName("es")
	@ObfuscatedSignature(
		signature = "Le;"
	)
	class9 field719;

	static {
		field749 = true;
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
		field691 = -1;
		field692 = -1;
		field875 = -1L;
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
		field709 = 0;
		js5Errors = 0;
		loginState = 0;
		field712 = 0;
		field713 = 0;
		field714 = 0;
		field715 = class169.field2008;
		Login_isUsernameRemembered = false;
		secureRandomFuture = new SecureRandomFuture();
		randomDatData = null;
		npcs = new NPC[32768];
		npcCount = 0;
		npcIndices = new int[32768];
		field851 = 0;
		field725 = new int[250];
		packetWriter = new PacketWriter();
		logoutTimer = 0;
		field728 = false;
		useBufferedSocket = true;
		timer = new Timer();
		fontsMap = new HashMap();
		field818 = 0;
		field921 = 1;
		field734 = 0;
		field735 = 1;
		field899 = 0;
		collisionMaps = new CollisionMap[4];
		isInInstance = false;
		instanceChunkTemplates = new int[4][13][13];
		field699 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
		field741 = 0;
		field742 = 2301979;
		field747 = 5063219;
		field744 = 3353893;
		field745 = 7759444;
		field746 = false;
		alternativeScrollbarWidth = 0;
		camAngleX = 128;
		camAngleY = 0;
		camAngleDY = 0;
		camAngleDX = 0;
		mouseCamClickedX = 0;
		mouseCamClickedY = 0;
		oculusOrbState = 0;
		camFollowHeight = 50;
		field757 = 0;
		field724 = 0;
		field759 = 0;
		oculusOrbNormalSpeed = 12;
		oculusOrbSlowedSpeed = 6;
		field762 = 0;
		field770 = false;
		field764 = 0;
		field765 = false;
		field941 = 0;
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
		field786 = 0;
		field880 = 0;
		dragItemSlotSource = 0;
		draggedWidgetX = 0;
		draggedWidgetY = 0;
		dragItemSlotDestination = 0;
		field887 = false;
		itemDragDuration = 0;
		field794 = 0;
		showLoadingMessages = true;
		players = new Player[2048];
		localPlayerIndex = -1;
		field798 = 0;
		renderSelf = true;
		drawPlayerNames = 0;
		field801 = 0;
		field918 = new int[1000];
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
		field871 = 0;
		field832 = 50;
		isItemSelected = 0;
		selectedItemName = null;
		isSpellSelected = false;
		selectedSpellChildIndex = -1;
		field837 = -1;
		selectedSpellActionName = null;
		selectedSpellName = null;
		rootInterface = -1;
		interfaceParents = new NodeHashTable(8);
		field842 = 0;
		field843 = -1;
		chatEffects = 0;
		field845 = 0;
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
		field732 = false;
		field859 = -1;
		field881 = -1;
		field861 = false;
		field834 = -1;
		field863 = -1;
		isDraggingWidget = false;
		cycleCntr = 1;
		field866 = new int[32];
		field772 = 0;
		changedItemContainers = new int[32];
		field869 = 0;
		changedSkills = new int[32];
		changedSkillsCount = 0;
		chatCycle = 0;
		field873 = 0;
		field874 = 0;
		field774 = 0;
		field726 = 0;
		field877 = 0;
		mouseWheelRotation = 0;
		scriptEvents = new NodeDeque();
		field727 = new NodeDeque();
		field919 = new NodeDeque();
		widgetClickMasks = new NodeHashTable(512);
		rootWidgetCount = 0;
		field884 = -2;
		field679 = new boolean[100];
		field886 = new boolean[100];
		field813 = new boolean[100];
		rootWidgetXs = new int[100];
		rootWidgetYs = new int[100];
		rootWidgetWidths = new int[100];
		rootWidgetHeights = new int[100];
		gameDrawingMode = 0;
		field893 = 0L;
		isResizable = true;
		field895 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
		publicChatMode = 0;
		tradeChatMode = 0;
		field814 = "";
		field846 = new long[100];
		field900 = 0;
		field901 = 0;
		field902 = new int[128];
		field872 = new int[128];
		field904 = -1L;
		field695 = -1;
		mapIconCount = 0;
		mapIconXs = new int[1000];
		mapIconYs = new int[1000];
		mapIcons = new Sprite[1000];
		destinationX = 0;
		destinationY = 0;
		minimapState = 0;
		musicVolume = 255;
		currentTrackGroupId = -1;
		field915 = false;
		soundEffectVolume = 127;
		areaSoundEffectVolume = 127;
		soundEffectCount = 0;
		soundEffectIds = new int[50];
		queuedSoundEffectLoops = new int[50];
		queuedSoundEffectDelays = new int[50];
		soundLocations = new int[50];
		soundEffects = new SoundEffect[50];
		isCameraLocked = false;
		field926 = new boolean[5];
		field788 = new int[5];
		field730 = new int[5];
		field929 = new int[5];
		field930 = new int[5];
		field931 = 256;
		field932 = 205;
		zoomHeight = 256;
		zoomWidth = 320;
		field935 = 1;
		field748 = 32767;
		field937 = 1;
		field938 = 32767;
		viewportOffsetX = 0;
		viewportOffsetY = 0;
		viewportWidth = 0;
		viewportHeight = 0;
		viewportZoom = 0;
		playerAppearance = new PlayerAppearance();
		field945 = -1;
		field946 = -1;
		platformInfoProvider = new DesktopPlatformInfoProvider();
		grandExchangeOffers = new GrandExchangeOffer[8];
		GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
		field891 = -1;
		archiveLoaders = new ArrayList(10);
		archiveLoadersDone = 0;
		field898 = 0;
		field954 = new class74();
		field955 = new int[50];
		field956 = new int[50];
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "108"
	)
	@Export("resizeGame")
	protected final void resizeGame() {
		field893 = class217.currentTimeMillis() + 500L;
		this.resizeJS();
		if (rootInterface != -1) {
			this.resizeRoot(true);
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-678556074"
	)
	@Export("setUp")
	protected final void setUp() {
		int[] var1 = new int[]{20, 260, 10000};
		int[] var2 = new int[]{1000, 100, 500};
		if (var1 != null && var2 != null) {
			RunException.ByteArrayPool_alternativeSizes = var1;
			ByteArrayPool.ByteArrayPool_altSizeArrayCounts = new int[var1.length];
			ByteArrayPool.ByteArrayPool_arrays = new byte[var1.length][][];

			for (int var5 = 0; var5 < RunException.ByteArrayPool_alternativeSizes.length; ++var5) {
				ByteArrayPool.ByteArrayPool_arrays[var5] = new byte[var2[var5]][];
			}
		} else {
			RunException.ByteArrayPool_alternativeSizes = null;
			ByteArrayPool.ByteArrayPool_altSizeArrayCounts = null;
			ByteArrayPool.ByteArrayPool_arrays = null;
		}

		WorldMapLabelSize.port1 = gameBuild == 0 ? 43594 : worldId + 40000;
		GrandExchangeOfferAgeComparator.port2 = gameBuild == 0 ? 443 : worldId + 50000;
		class280.port3 = WorldMapLabelSize.port1;
		WorldMapLabel.field278 = class224.field2544;
		VertexNormal.field1764 = class224.field2547;
		PlayerAppearance.field2539 = class224.field2546;
		PlayerAppearance.field2535 = class224.field2545;
		WorldMapLabel.urlRequester = new UrlRequester();
		this.setUpKeyboard();
		this.setUpMouse();
		SecureRandomFuture.mouseWheel = this.mouseWheel();
		WorldMapRegion.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		GrandExchangeOfferOwnWorldComparator.clientPreferences = WorldMapData_1.method813();
		this.setUpClipboard();
		String var4 = WorldMapCacheName.null_string;
		class60.applet = this;
		if (var4 != null) {
			class60.field462 = var4;
		}

		if (gameBuild != 0) {
			displayFps = true;
		}

		WorldMapIcon_1.setWindowedMode(GrandExchangeOfferOwnWorldComparator.clientPreferences.windowMode);
		Projectile.friendSystem = new FriendSystem(WorldMapIcon_0.loginType);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-113"
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
				int var5;
				try {
					if (class206.field2406 == 1) {
						var5 = class206.midiPcmStream.method3793();
						if (var5 > 0 && class206.midiPcmStream.isReady()) {
							var5 -= AttackOption.field1187;
							if (var5 < 0) {
								var5 = 0;
							}

							class206.midiPcmStream.setPcmStreamVolume(var5);
						} else {
							class206.midiPcmStream.clear();
							class206.midiPcmStream.removeAll();
							if (class206.musicTrackArchive != null) {
								class206.field2406 = 2;
							} else {
								class206.field2406 = 0;
							}

							class206.musicTrack = null;
							UrlRequest.soundCache = null;
						}
					}
				} catch (Exception var9) {
					var9.printStackTrace();
					class206.midiPcmStream.clear();
					class206.field2406 = 0;
					class206.musicTrack = null;
					UrlRequest.soundCache = null;
					class206.musicTrackArchive = null;
				}

				ChatChannel.playPcmPlayers();
				synchronized(KeyHandler.KeyHandler_instance) {
					++KeyHandler.KeyHandler_idleCycles;
					KeyHandler.field434 = KeyHandler.field436;
					KeyHandler.field417 = 0;
					int var6;
					if (KeyHandler.field429 >= 0) {
						while (KeyHandler.field439 != KeyHandler.field429) {
							var6 = KeyHandler.field427[KeyHandler.field439];
							KeyHandler.field439 = KeyHandler.field439 + 1 & 127;
							if (var6 < 0) {
								KeyHandler.KeyHandler_pressedKeys[~var6] = false;
							} else {
								if (!KeyHandler.KeyHandler_pressedKeys[var6] && KeyHandler.field417 < KeyHandler.field432.length - 1) {
									KeyHandler.field432[++KeyHandler.field417 - 1] = var6;
								}

								KeyHandler.KeyHandler_pressedKeys[var6] = true;
							}
						}
					} else {
						for (var6 = 0; var6 < 112; ++var6) {
							KeyHandler.KeyHandler_pressedKeys[var6] = false;
						}

						KeyHandler.field429 = KeyHandler.field439;
					}

					if (KeyHandler.field417 > 0) {
						KeyHandler.KeyHandler_idleCycles = 0;
					}

					KeyHandler.field436 = KeyHandler.field433;
				}

				class52.method900();
				if (SecureRandomFuture.mouseWheel != null) {
					var5 = SecureRandomFuture.mouseWheel.useRotation();
					mouseWheelRotation = var5;
				}

				if (gameState == 0) {
					class237.load();
					GameShell.clock.mark();

					for (var5 = 0; var5 < 32; ++var5) {
						GameShell.graphicsTickTimes[var5] = 0L;
					}

					for (var5 = 0; var5 < 32; ++var5) {
						GameShell.clientTickTimes[var5] = 0L;
					}

					ModelData0.gameCyclesToDo = 0;
				} else if (gameState == 5) {
					GrandExchangeOfferAgeComparator.doCycleTitle(this);
					class237.load();
					GameShell.clock.mark();

					for (var5 = 0; var5 < 32; ++var5) {
						GameShell.graphicsTickTimes[var5] = 0L;
					}

					for (var5 = 0; var5 < 32; ++var5) {
						GameShell.clientTickTimes[var5] = 0L;
					}

					ModelData0.gameCyclesToDo = 0;
				} else if (gameState != 10 && gameState != 11) {
					if (gameState == 20) {
						GrandExchangeOfferAgeComparator.doCycleTitle(this);
						this.doCycleLoggedOut();
					} else if (gameState == 25) {
						GrandExchangeEvent.method161();
					}
				} else {
					GrandExchangeOfferAgeComparator.doCycleTitle(this);
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

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "1"
	)
	@Export("draw")
	protected final void draw(boolean var1) {
		boolean var2;
		label173: {
			try {
				if (class206.field2406 == 2) {
					if (class206.musicTrack == null) {
						class206.musicTrack = MusicTrack.readTrack(class206.musicTrackArchive, class206.musicTrackGroupId, class206.musicTrackFileId);
						if (class206.musicTrack == null) {
							var2 = false;
							break label173;
						}
					}

					if (UrlRequest.soundCache == null) {
						UrlRequest.soundCache = new SoundCache(class206.soundEffectsArchive, class206.musicSamplesArchive);
					}

					if (class206.midiPcmStream.loadMusicTrack(class206.musicTrack, class58.musicPatchesArchive, UrlRequest.soundCache, 22050)) {
						class206.midiPcmStream.clearAll();
						class206.midiPcmStream.setPcmStreamVolume(class219.musicTrackVolume);
						class206.midiPcmStream.setMusicTrack(class206.musicTrack, GrandExchangeOfferUnitPriceComparator.musicTrackBoolean);
						class206.field2406 = 0;
						class206.musicTrack = null;
						UrlRequest.soundCache = null;
						class206.musicTrackArchive = null;
						var2 = true;
						break label173;
					}
				}
			} catch (Exception var6) {
				var6.printStackTrace();
				class206.midiPcmStream.clear();
				class206.field2406 = 0;
				class206.musicTrack = null;
				UrlRequest.soundCache = null;
				class206.musicTrackArchive = null;
			}

			var2 = false;
		}

		if (var2 && field915 && WorldMapManager.pcmPlayer0 != null) {
			WorldMapManager.pcmPlayer0.tryDiscard();
		}

		if ((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field893 && class217.currentTimeMillis() > field893) {
			WorldMapIcon_1.setWindowedMode(class74.getWindowedMode());
		}

		int var4;
		if (var1) {
			for (var4 = 0; var4 < 100; ++var4) {
				field679[var4] = true;
			}
		}

		if (gameState == 0) {
			this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
		} else if (gameState == 5) {
			MouseRecorder.drawTitle(TaskHandler.fontBold12, Script.fontPlain11, WorldMapData_0.fontPlain12);
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				MouseRecorder.drawTitle(TaskHandler.fontBold12, Script.fontPlain11, WorldMapData_0.fontPlain12);
			} else if (gameState == 25) {
				if (field899 == 1) {
					if (field818 > field921) {
						field921 = field818;
					}

					var4 = (field921 * 50 - field818 * 50) / field921;
					AbstractByteArrayCopier.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
				} else if (field899 == 2) {
					if (field734 > field735) {
						field735 = field734;
					}

					var4 = (field735 * 50 - field734 * 50) / field735 + 50;
					AbstractByteArrayCopier.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
				} else {
					AbstractByteArrayCopier.drawLoadingMessage("Loading - please wait.", false);
				}
			} else if (gameState == 30) {
				this.drawLoggedIn();
			} else if (gameState == 40) {
				AbstractByteArrayCopier.drawLoadingMessage("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
			} else if (gameState == 45) {
				AbstractByteArrayCopier.drawLoadingMessage("Please wait...", false);
			}
		} else {
			MouseRecorder.drawTitle(TaskHandler.fontBold12, Script.fontPlain11, WorldMapData_0.fontPlain12);
		}

		if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
			for (var4 = 0; var4 < rootWidgetCount; ++var4) {
				if (field886[var4]) {
					class206.rasterProvider.draw(rootWidgetXs[var4], rootWidgetYs[var4], rootWidgetWidths[var4], rootWidgetHeights[var4]);
					field886[var4] = false;
				}
			}
		} else if (gameState > 0) {
			class206.rasterProvider.drawFull(0, 0);

			for (var4 = 0; var4 < rootWidgetCount; ++var4) {
				field886[var4] = false;
			}
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "8226"
	)
	@Export("kill0")
	protected final void kill0() {
		if (UserComparator4.varcs.hasUnwrittenChanges()) {
			UserComparator4.varcs.write();
		}

		if (MidiPcmStream.mouseRecorder != null) {
			MidiPcmStream.mouseRecorder.isRunning = false;
		}

		MidiPcmStream.mouseRecorder = null;
		packetWriter.close();
		if (KeyHandler.KeyHandler_instance != null) {
			synchronized(KeyHandler.KeyHandler_instance) {
				KeyHandler.KeyHandler_instance = null;
			}
		}

		GraphicsObject.method2121();
		SecureRandomFuture.mouseWheel = null;
		if (WorldMapManager.pcmPlayer0 != null) {
			WorldMapManager.pcmPlayer0.shutdown();
		}

		if (AbstractWorldMapData.pcmPlayer1 != null) {
			AbstractWorldMapData.pcmPlayer1.shutdown();
		}

		class7.method104();
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3151 != 0) {
				ArchiveDiskActionHandler.field3151 = 1;

				try {
					ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock.wait();
				} catch (InterruptedException var5) {
				}
			}
		}

		if (WorldMapLabel.urlRequester != null) {
			WorldMapLabel.urlRequester.close();
			WorldMapLabel.urlRequester = null;
		}

		try {
			JagexCache.JagexCache_dat2File.close();

			for (int var4 = 0; var4 < InterfaceParent.idxCount; ++var4) {
				PacketBufferNode.JagexCache_idxFiles[var4].close();
			}

			JagexCache.JagexCache_idx255File.close();
			JagexCache.JagexCache_randomDat.close();
		} catch (Exception var7) {
		}

	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-277226112"
	)
	protected final void vmethod1400() {
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
							IgnoreList.clientLanguage = Language.method3736(Integer.parseInt(var2));
							break;
						case 7:
							class198.field2353 = Strings.method4219(Integer.parseInt(var2));
							break;
						case 8:
							if (var2.equalsIgnoreCase("true")) {
							}
							break;
						case 9:
							WorldMapData_0.field137 = var2;
							break;
						case 10:
							StudioGame[] var3 = new StudioGame[]{StudioGame.runescape, StudioGame.stellardawn, StudioGame.oldscape, StudioGame.game5, StudioGame.game3, StudioGame.game4};
							WorldMapArchiveLoader.field3965 = (StudioGame)GrandExchangeEvent.findEnumerated(var3, Integer.parseInt(var2));
							if (WorldMapArchiveLoader.field3965 == StudioGame.oldscape) {
								WorldMapIcon_0.loginType = LoginType.oldscape;
							} else {
								WorldMapIcon_0.loginType = LoginType.field4054;
							}
							break;
						case 12:
							worldId = Integer.parseInt(var2);
							break;
						case 14:
							KitDefinition.field3271 = Integer.parseInt(var2);
							break;
						case 15:
							gameBuild = Integer.parseInt(var2);
							break;
						case 17:
							class201.field2390 = var2;
						}
					}
				}

				Scene.Scene_isLowDetail = false;
				isLowDetail = false;
				Script.worldHost = this.getCodeBase().getHost();
				String var17 = class198.field2353.name;
				byte var18 = 0;

				try {
					InterfaceParent.idxCount = 21;
					class8.cacheGamebuild = var18;

					try {
						SequenceDefinition.field3527 = System.getProperty("os.name");
					} catch (Exception var34) {
						SequenceDefinition.field3527 = "Unknown";
					}

					class171.field2016 = SequenceDefinition.field3527.toLowerCase();

					try {
						AbstractWorldMapData.userHomeDirectory = System.getProperty("user.home");
						if (AbstractWorldMapData.userHomeDirectory != null) {
							AbstractWorldMapData.userHomeDirectory = AbstractWorldMapData.userHomeDirectory + "/";
						}
					} catch (Exception var33) {
					}

					try {
						if (class171.field2016.startsWith("win")) {
							if (AbstractWorldMapData.userHomeDirectory == null) {
								AbstractWorldMapData.userHomeDirectory = System.getenv("USERPROFILE");
							}
						} else if (AbstractWorldMapData.userHomeDirectory == null) {
							AbstractWorldMapData.userHomeDirectory = System.getenv("HOME");
						}

						if (AbstractWorldMapData.userHomeDirectory != null) {
							AbstractWorldMapData.userHomeDirectory = AbstractWorldMapData.userHomeDirectory + "/";
						}
					} catch (Exception var32) {
					}

					if (AbstractWorldMapData.userHomeDirectory == null) {
						AbstractWorldMapData.userHomeDirectory = "~/";
					}

					Varps.field2522 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", AbstractWorldMapData.userHomeDirectory, "/tmp/", ""};
					AbstractRasterProvider.field3871 = new String[]{".jagex_cache_" + class8.cacheGamebuild, ".file_store_" + class8.cacheGamebuild};
					int var19 = 0;

					label276:
					while (var19 < 4) {
						String var5 = var19 == 0 ? "" : "" + var19;
						JagexCache.JagexCache_locationFile = new File(AbstractWorldMapData.userHomeDirectory, "jagex_cl_oldschool_" + var17 + var5 + ".dat");
						String var6 = null;
						String var7 = null;
						boolean var8 = false;
						int var11;
						int var13;
						File var42;
						if (JagexCache.JagexCache_locationFile.exists()) {
							try {
								AccessFile var9 = new AccessFile(JagexCache.JagexCache_locationFile, "rw", 10000L);

								Buffer var10;
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
									var6 = var10.readStringCp1252NullCircumfixed();
									if (var12 == 1) {
										var7 = var10.readStringCp1252NullCircumfixed();
									}
								} else {
									var6 = var10.readCESU8();
									if (var12 == 1) {
										var7 = var10.readCESU8();
									}
								}

								var9.close();
							} catch (IOException var36) {
								var36.printStackTrace();
							}

							if (var6 != null) {
								var42 = new File(var6);
								if (!var42.exists()) {
									var6 = null;
								}
							}

							if (var6 != null) {
								var42 = new File(var6, "test.dat");

								boolean var45;
								try {
									RandomAccessFile var20 = new RandomAccessFile(var42, "rw");
									var13 = var20.read();
									var20.seek(0L);
									var20.write(var13);
									var20.seek(0L);
									var20.close();
									var42.delete();
									var45 = true;
								} catch (Exception var31) {
									var45 = false;
								}

								if (!var45) {
									var6 = null;
								}
							}
						}

						if (var6 == null && var19 == 0) {
							label252:
							for (int var21 = 0; var21 < AbstractRasterProvider.field3871.length; ++var21) {
								for (int var22 = 0; var22 < Varps.field2522.length; ++var22) {
									File var23 = new File(Varps.field2522[var22] + AbstractRasterProvider.field3871[var21] + File.separatorChar + "oldschool" + File.separatorChar);
									if (var23.exists()) {
										File var24 = new File(var23, "test.dat");

										boolean var46;
										try {
											RandomAccessFile var14 = new RandomAccessFile(var24, "rw");
											int var15 = var14.read();
											var14.seek(0L);
											var14.write(var15);
											var14.seek(0L);
											var14.close();
											var24.delete();
											var46 = true;
										} catch (Exception var30) {
											var46 = false;
										}

										if (var46) {
											var6 = var23.toString();
											var8 = true;
											break label252;
										}
									}
								}
							}
						}

						if (var6 == null) {
							var6 = AbstractWorldMapData.userHomeDirectory + File.separatorChar + "jagexcache" + var5 + File.separatorChar + "oldschool" + File.separatorChar + var17 + File.separatorChar;
							var8 = true;
						}

						if (var7 != null) {
							File var41 = new File(var7);
							var42 = new File(var6);

							try {
								File[] var50 = var41.listFiles();
								File[] var48 = var50;

								for (var13 = 0; var13 < var48.length; ++var13) {
									File var47 = var48[var13];
									File var25 = new File(var42, var47.getName());
									boolean var16 = var47.renameTo(var25);
									if (!var16) {
										throw new IOException();
									}
								}
							} catch (Exception var35) {
								var35.printStackTrace();
							}

							var8 = true;
						}

						if (var8) {
							GameObject.method3408(new File(var6), (File)null);
						}

						File var4 = new File(var6);
						class92.cacheDir = var4;
						if (!class92.cacheDir.exists()) {
							class92.cacheDir.mkdirs();
						}

						File[] var40 = class92.cacheDir.listFiles();
						if (var40 == null) {
							break;
						}

						File[] var43 = var40;
						int var26 = 0;

						while (true) {
							if (var26 >= var43.length) {
								break label276;
							}

							File var27 = var43[var26];

							boolean var49;
							try {
								RandomAccessFile var44 = new RandomAccessFile(var27, "rw");
								var11 = var44.read();
								var44.seek(0L);
								var44.write(var11);
								var44.seek(0L);
								var44.close();
								var49 = true;
							} catch (Exception var29) {
								var49 = false;
							}

							if (!var49) {
								++var19;
								break;
							}

							++var26;
						}
					}

					File var39 = class92.cacheDir;
					FileSystem.FileSystem_cacheDir = var39;
					if (!FileSystem.FileSystem_cacheDir.exists()) {
						throw new RuntimeException("");
					}

					FileSystem.FileSystem_hasPermissions = true;
					Huffman.method4045();
					JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(ViewportMouse.getFile("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
					JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(ViewportMouse.getFile("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
					PacketBufferNode.JagexCache_idxFiles = new BufferedFile[InterfaceParent.idxCount];

					for (int var28 = 0; var28 < InterfaceParent.idxCount; ++var28) {
						PacketBufferNode.JagexCache_idxFiles[var28] = new BufferedFile(new AccessFile(ViewportMouse.getFile("main_file_cache.idx" + var28), "rw", 1048576L), 6000, 0);
					}
				} catch (Exception var37) {
					WorldMapDecorationType.RunException_sendStackTrace((String)null, var37);
				}

				WorldMapSection1.client = this;
				RunException.clientType = clientType;
				this.startThread(765, 503, 189);
			}
		} catch (RuntimeException var38) {
			throw class51.newRunException(var38, "client.init(" + ')');
		}
	}

	@ObfuscatedName("eg")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	@Export("doCycleJs5")
	void doCycleJs5() {
		if (gameState != 1000) {
			long var2 = class217.currentTimeMillis();
			int var4 = (int)(var2 - NetCache.field3165);
			NetCache.field3165 = var2;
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
					label243: {
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
							if (NetCache.NetCache_currentResponse == null) {
								var7 = 8;
							} else if (NetCache.field3178 == 0) {
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
								if (NetCache.field3163 != 0) {
									for (var9 = 0; var9 < var8; ++var9) {
										var10000 = NetCache.NetCache_responseHeaderBuffer.array;
										var10001 = NetCache.NetCache_responseHeaderBuffer.offset + var9;
										var10000[var10001] ^= NetCache.field3163;
									}
								}

								var25 = NetCache.NetCache_responseHeaderBuffer;
								var25.offset += var8;
								if (NetCache.NetCache_responseHeaderBuffer.offset < var7) {
									break;
								}

								if (NetCache.NetCache_currentResponse == null) {
									NetCache.NetCache_responseHeaderBuffer.offset = 0;
									var9 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
									var10 = NetCache.NetCache_responseHeaderBuffer.readUnsignedShort();
									int var11 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
									var12 = NetCache.NetCache_responseHeaderBuffer.readInt();
									long var13 = (long)(var10 + (var9 << 16));
									NetFileRequest var15 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.get(var13);
									GrandExchangeOfferOwnWorldComparator.field677 = true;
									if (var15 == null) {
										var15 = (NetFileRequest)NetCache.NetCache_pendingResponses.get(var13);
										GrandExchangeOfferOwnWorldComparator.field677 = false;
									}

									if (var15 == null) {
										throw new IOException();
									}

									int var16 = var11 == 0 ? 5 : 9;
									NetCache.NetCache_currentResponse = var15;
									NetCache.NetCache_responseArchiveBuffer = new Buffer(var12 + var16 + NetCache.NetCache_currentResponse.padding);
									NetCache.NetCache_responseArchiveBuffer.writeByte(var11);
									NetCache.NetCache_responseArchiveBuffer.writeInt(var12);
									NetCache.field3178 = 8;
									NetCache.NetCache_responseHeaderBuffer.offset = 0;
								} else if (NetCache.field3178 == 0) {
									if (NetCache.NetCache_responseHeaderBuffer.array[0] == -1) {
										NetCache.field3178 = 1;
										NetCache.NetCache_responseHeaderBuffer.offset = 0;
									} else {
										NetCache.NetCache_currentResponse = null;
									}
								}
							} else {
								var8 = NetCache.NetCache_responseArchiveBuffer.array.length - NetCache.NetCache_currentResponse.padding;
								var9 = 512 - NetCache.field3178;
								if (var9 > var8 - NetCache.NetCache_responseArchiveBuffer.offset) {
									var9 = var8 - NetCache.NetCache_responseArchiveBuffer.offset;
								}

								if (var9 > var18) {
									var9 = var18;
								}

								NetCache.NetCache_socket.read(NetCache.NetCache_responseArchiveBuffer.array, NetCache.NetCache_responseArchiveBuffer.offset, var9);
								if (NetCache.field3163 != 0) {
									for (var10 = 0; var10 < var9; ++var10) {
										var10000 = NetCache.NetCache_responseArchiveBuffer.array;
										var10001 = var10 + NetCache.NetCache_responseArchiveBuffer.offset;
										var10000[var10001] ^= NetCache.field3163;
									}
								}

								var25 = NetCache.NetCache_responseArchiveBuffer;
								var25.offset += var9;
								NetCache.field3178 += var9;
								if (var8 == NetCache.NetCache_responseArchiveBuffer.offset) {
									if (NetCache.NetCache_currentResponse.key == 16711935L) {
										class13.NetCache_reference = NetCache.NetCache_responseArchiveBuffer;

										for (var10 = 0; var10 < 256; ++var10) {
											Archive var19 = NetCache.NetCache_archives[var10];
											if (var19 != null) {
												class13.NetCache_reference.offset = var10 * 8 + 5;
												var12 = class13.NetCache_reference.readInt();
												int var20 = class13.NetCache_reference.readInt();
												var19.loadIndex(var12, var20);
											}
										}
									} else {
										NetCache.NetCache_crc.reset();
										NetCache.NetCache_crc.update(NetCache.NetCache_responseArchiveBuffer.array, 0, var8);
										var10 = (int)NetCache.NetCache_crc.getValue();
										if (var10 != NetCache.NetCache_currentResponse.crc) {
											try {
												NetCache.NetCache_socket.close();
											} catch (Exception var23) {
											}

											++NetCache.NetCache_crcMismatches;
											NetCache.NetCache_socket = null;
											NetCache.field3163 = (byte)((int)(Math.random() * 255.0D + 1.0D));
											var1 = false;
											break label243;
										}

										NetCache.NetCache_crcMismatches = 0;
										NetCache.NetCache_ioExceptions = 0;
										NetCache.NetCache_currentResponse.archive.write((int)(NetCache.NetCache_currentResponse.key & 65535L), NetCache.NetCache_responseArchiveBuffer.array, (NetCache.NetCache_currentResponse.key & 16711680L) == 16711680L, GrandExchangeOfferOwnWorldComparator.field677);
									}

									NetCache.NetCache_currentResponse.remove();
									if (GrandExchangeOfferOwnWorldComparator.field677) {
										--NetCache.NetCache_pendingPriorityResponsesCount;
									} else {
										--NetCache.NetCache_pendingResponsesCount;
									}

									NetCache.field3178 = 0;
									NetCache.NetCache_currentResponse = null;
									NetCache.NetCache_responseArchiveBuffer = null;
								} else {
									if (NetCache.field3178 != 512) {
										break;
									}

									NetCache.field3178 = 0;
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

	@ObfuscatedName("es")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1183665566"
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

				field709 = 3000;
				NetCache.NetCache_ioExceptions = 3;
			}

			if (--field709 + 1 <= 0) {
				try {
					if (js5ConnectState == 0) {
						WorldMapManager.js5SocketTask = class227.taskHandler.newSocketTask(Script.worldHost, class280.port3);
						++js5ConnectState;
					}

					if (js5ConnectState == 1) {
						if (WorldMapManager.js5SocketTask.status == 2) {
							this.js5Error(-1);
							return;
						}

						if (WorldMapManager.js5SocketTask.status == 1) {
							++js5ConnectState;
						}
					}

					if (js5ConnectState == 2) {
						if (useBufferedSocket) {
							MusicPatchNode.js5Socket = Buffer.method5794((Socket)WorldMapManager.js5SocketTask.result, 40000, 5000);
						} else {
							MusicPatchNode.js5Socket = new NetSocket((Socket)WorldMapManager.js5SocketTask.result, class227.taskHandler, 5000);
						}

						Buffer var1 = new Buffer(5);
						var1.writeByte(15);
						var1.writeInt(189);
						MusicPatchNode.js5Socket.write(var1.array, 0, 5);
						++js5ConnectState;
						class58.field455 = class217.currentTimeMillis();
					}

					if (js5ConnectState == 3) {
						if (MusicPatchNode.js5Socket.available() > 0 || !useBufferedSocket && gameState <= 5) {
							int var2 = MusicPatchNode.js5Socket.readUnsignedByte();
							if (var2 != 0) {
								this.js5Error(var2);
								return;
							}

							++js5ConnectState;
						} else if (class217.currentTimeMillis() - class58.field455 > 30000L) {
							this.js5Error(-2);
							return;
						}
					}

					if (js5ConnectState == 4) {
						GrandExchangeOfferUnitPriceComparator.method222(MusicPatchNode.js5Socket, gameState > 20);
						WorldMapManager.js5SocketTask = null;
						MusicPatchNode.js5Socket = null;
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
		garbageValue = "-2003740384"
	)
	@Export("js5Error")
	void js5Error(int var1) {
		WorldMapManager.js5SocketTask = null;
		MusicPatchNode.js5Socket = null;
		js5ConnectState = 0;
		if (WorldMapLabelSize.port1 == class280.port3) {
			class280.port3 = GrandExchangeOfferAgeComparator.port2;
		} else {
			class280.port3 = WorldMapLabelSize.port1;
		}

		++js5Errors;
		if (js5Errors >= 2 && (var1 == 7 || var1 == 9)) {
			if (gameState <= 5) {
				this.error("js5connect_full");
				gameState = 1000;
			} else {
				field709 = 3000;
			}
		} else if (js5Errors >= 2 && var1 == 6) {
			this.error("js5connect_outofdate");
			gameState = 1000;
		} else if (js5Errors >= 4) {
			if (gameState <= 5) {
				this.error("js5connect");
				gameState = 1000;
			} else {
				field709 = 3000;
			}
		}

	}

	@ObfuscatedName("fi")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "931463513"
	)
	@Export("doCycleLoggedOut")
	final void doCycleLoggedOut() {
		Object var1 = packetWriter.getSocket();
		PacketBuffer var2 = packetWriter.packetBuffer;

		try {
			if (loginState == 0) {
				if (MouseHandler.secureRandom == null && (secureRandomFuture.isDone() || field712 > 250)) {
					MouseHandler.secureRandom = secureRandomFuture.get();
					secureRandomFuture.shutdown();
					secureRandomFuture = null;
				}

				if (MouseHandler.secureRandom != null) {
					if (var1 != null) {
						((AbstractSocket)var1).close();
						var1 = null;
					}

					AbstractWorldMapIcon.socketTask = null;
					field728 = false;
					field712 = 0;
					loginState = 1;
				}
			}

			if (loginState == 1) {
				if (AbstractWorldMapIcon.socketTask == null) {
					AbstractWorldMapIcon.socketTask = class227.taskHandler.newSocketTask(Script.worldHost, class280.port3);
				}

				if (AbstractWorldMapIcon.socketTask.status == 2) {
					throw new IOException();
				}

				if (AbstractWorldMapIcon.socketTask.status == 1) {
					if (useBufferedSocket) {
						var1 = Buffer.method5794((Socket)AbstractWorldMapIcon.socketTask.result, 40000, 5000);
					} else {
						var1 = new NetSocket((Socket)AbstractWorldMapIcon.socketTask.result, class227.taskHandler, 5000);
					}

					packetWriter.setSocket((AbstractSocket)var1);
					AbstractWorldMapIcon.socketTask = null;
					loginState = 2;
				}
			}

			PacketBufferNode var4;
			if (loginState == 2) {
				packetWriter.clearBuffer();
				var4 = UserComparator9.method3496();
				var4.clientPacket = null;
				var4.clientPacketLength = 0;
				var4.packetBuffer = new PacketBuffer(5000);
				var4.packetBuffer.writeByte(LoginPacket.field2315.id);
				packetWriter.addNode(var4);
				packetWriter.flush();
				var2.offset = 0;
				loginState = 3;
			}

			boolean var13;
			int var14;
			if (loginState == 3) {
				if (WorldMapManager.pcmPlayer0 != null) {
					WorldMapManager.pcmPlayer0.method2537();
				}

				if (AbstractWorldMapData.pcmPlayer1 != null) {
					AbstractWorldMapData.pcmPlayer1.method2537();
				}

				var13 = true;
				if (useBufferedSocket && !((AbstractSocket)var1).isAvailable(1)) {
					var13 = false;
				}

				if (var13) {
					var14 = ((AbstractSocket)var1).readUnsignedByte();
					if (WorldMapManager.pcmPlayer0 != null) {
						WorldMapManager.pcmPlayer0.method2537();
					}

					if (AbstractWorldMapData.pcmPlayer1 != null) {
						AbstractWorldMapData.pcmPlayer1.method2537();
					}

					if (var14 != 0) {
						PlayerAppearance.getLoginError(var14);
						return;
					}

					var2.offset = 0;
					loginState = 4;
				}
			}

			int var36;
			if (loginState == 4) {
				if (var2.offset < 8) {
					var36 = ((AbstractSocket)var1).available();
					if (var36 > 8 - var2.offset) {
						var36 = 8 - var2.offset;
					}

					if (var36 > 0) {
						((AbstractSocket)var1).read(var2.array, var2.offset, var36);
						var2.offset += var36;
					}
				}

				if (var2.offset == 8) {
					var2.offset = 0;
					ChatChannel.field1319 = var2.readLong();
					loginState = 5;
				}
			}

			int var7;
			int var9;
			int var15;
			if (loginState == 5) {
				packetWriter.packetBuffer.offset = 0;
				packetWriter.clearBuffer();
				PacketBuffer var3 = new PacketBuffer(500);
				int[] var27 = new int[]{MouseHandler.secureRandom.nextInt(), MouseHandler.secureRandom.nextInt(), MouseHandler.secureRandom.nextInt(), MouseHandler.secureRandom.nextInt()};
				var3.offset = 0;
				var3.writeByte(1);
				var3.writeInt(var27[0]);
				var3.writeInt(var27[1]);
				var3.writeInt(var27[2]);
				var3.writeInt(var27[3]);
				var3.writeLong(ChatChannel.field1319);
				if (gameState == 40) {
					var3.writeInt(class105.field1345[0]);
					var3.writeInt(class105.field1345[1]);
					var3.writeInt(class105.field1345[2]);
					var3.writeInt(class105.field1345[3]);
				} else {
					var3.writeByte(field715.rsOrdinal());
					switch(field715.field2014) {
					case 0:
						LinkedHashMap var6 = GrandExchangeOfferOwnWorldComparator.clientPreferences.parameters;
						String var8 = Login.Login_username;
						var9 = var8.length();
						int var10 = 0;

						for (int var11 = 0; var11 < var9; ++var11) {
							var10 = (var10 << 5) - var10 + var8.charAt(var11);
						}

						var3.writeInt((Integer)var6.get(var10));
						break;
					case 1:
					case 2:
						var3.writeMedium(GraphicsObject.field1141);
						++var3.offset;
						break;
					case 3:
						var3.offset += 4;
					}

					var3.writeByte(class322.field3825.rsOrdinal());
					var3.writeStringCp1252NullTerminated(Login.Login_password);
				}

				var3.encryptRsa(class92.field1181, class92.field1178);
				class105.field1345 = var27;
				PacketBufferNode var33 = UserComparator9.method3496();
				var33.clientPacket = null;
				var33.clientPacketLength = 0;
				var33.packetBuffer = new PacketBuffer(5000);
				var33.packetBuffer.offset = 0;
				if (gameState == 40) {
					var33.packetBuffer.writeByte(LoginPacket.field2313.id);
				} else {
					var33.packetBuffer.writeByte(LoginPacket.field2317.id);
				}

				var33.packetBuffer.writeShort(0);
				var7 = var33.packetBuffer.offset;
				var33.packetBuffer.writeInt(189);
				var33.packetBuffer.writeInt(1);
				var33.packetBuffer.writeByte(clientType);
				var33.packetBuffer.writeBytes(var3.array, 0, var3.offset);
				var15 = var33.packetBuffer.offset;
				var33.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
				var33.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
				var33.packetBuffer.writeShort(WorldMapLabel.canvasWidth);
				var33.packetBuffer.writeShort(Varps.canvasHeight);
				PacketBuffer var16 = var33.packetBuffer;
				if (randomDatData != null) {
					var16.writeBytes(randomDatData, 0, randomDatData.length);
				} else {
					byte[] var17 = GraphicsObject.method2120();
					var16.writeBytes(var17, 0, var17.length);
				}

				var33.packetBuffer.writeStringCp1252NullTerminated(WorldMapData_0.field137);
				var33.packetBuffer.writeInt(KitDefinition.field3271);
				Buffer var38 = new Buffer(Varcs.platformInfo.size());
				Varcs.platformInfo.write(var38);
				var33.packetBuffer.writeBytes(var38.array, 0, var38.array.length);
				var33.packetBuffer.writeByte(clientType);
				var33.packetBuffer.writeInt(0);
				var33.packetBuffer.writeInt(ArchiveDiskAction.archive0.hash);
				var33.packetBuffer.writeInt(DirectByteArrayCopier.archive1.hash);
				var33.packetBuffer.writeInt(GrandExchangeOffer.archive2.hash);
				var33.packetBuffer.writeInt(WorldMapSprite.archive3.hash);
				var33.packetBuffer.writeInt(FontName.archive4.hash);
				var33.packetBuffer.writeInt(WorldMapIcon_0.archive5.hash);
				var33.packetBuffer.writeInt(AbstractWorldMapIcon.archive6.hash);
				var33.packetBuffer.writeInt(AbstractWorldMapIcon.archive7.hash);
				var33.packetBuffer.writeInt(class228.archive8.hash);
				var33.packetBuffer.writeInt(SecureRandomFuture.archive9.hash);
				var33.packetBuffer.writeInt(PlayerAppearance.archive10.hash);
				var33.packetBuffer.writeInt(WorldMapRegion.archive11.hash);
				var33.packetBuffer.writeInt(class41.archive12.hash);
				var33.packetBuffer.writeInt(NPC.archive13.hash);
				var33.packetBuffer.writeInt(class224.archive14.hash);
				var33.packetBuffer.writeInt(GrandExchangeOfferNameComparator.archive15.hash);
				var33.packetBuffer.writeInt(0);
				var33.packetBuffer.writeInt(MenuAction.archive17.hash);
				var33.packetBuffer.writeInt(UserComparator9.archive18.hash);
				var33.packetBuffer.writeInt(class278.archive19.hash);
				var33.packetBuffer.writeInt(class25.archive20.hash);
				var33.packetBuffer.xteaEncrypt(var27, var15, var33.packetBuffer.offset);
				var33.packetBuffer.writeLengthShort(var33.packetBuffer.offset - var7);
				packetWriter.addNode(var33);
				packetWriter.flush();
				packetWriter.isaacCipher = new IsaacCipher(var27);
				int[] var18 = new int[4];

				for (int var12 = 0; var12 < 4; ++var12) {
					var18[var12] = var27[var12] + 50;
				}

				var2.newIsaacCipher(var18);
				loginState = 6;
			}

			if (loginState == 6 && ((AbstractSocket)var1).available() > 0) {
				var36 = ((AbstractSocket)var1).readUnsignedByte();
				if (var36 == 21 && gameState == 20) {
					loginState = 12;
				} else if (var36 == 2) {
					loginState = 14;
				} else if (var36 == 15 && gameState == 40) {
					packetWriter.serverPacketLength = -1;
					loginState = 19;
				} else if (var36 == 64) {
					loginState = 10;
				} else if (var36 == 23 && field713 < 1) {
					++field713;
					loginState = 0;
				} else if (var36 == 29) {
					loginState = 17;
				} else {
					if (var36 != 69) {
						PlayerAppearance.getLoginError(var36);
						return;
					}

					loginState = 7;
				}
			}

			if (loginState == 7 && ((AbstractSocket)var1).available() >= 2) {
				((AbstractSocket)var1).read(var2.array, 0, 2);
				var2.offset = 0;
				MilliClock.field2026 = var2.readUnsignedShort();
				loginState = 8;
			}

			if (loginState == 8 && ((AbstractSocket)var1).available() >= MilliClock.field2026) {
				var2.offset = 0;
				((AbstractSocket)var1).read(var2.array, var2.offset, MilliClock.field2026);
				class7[] var25 = new class7[]{class7.field34};
				class7 var28 = var25[var2.readUnsignedByte()];

				try {
					switch(var28.field30) {
					case 0:
						class5 var5 = new class5();
						this.field719 = new class9(var2, var5);
						loginState = 9;
						break;
					default:
						throw new IllegalArgumentException();
					}
				} catch (Exception var23) {
					PlayerAppearance.getLoginError(22);
					return;
				}
			}

			if (loginState == 9 && this.field719.method111()) {
				this.field718 = this.field719.method113();
				this.field719.method110();
				this.field719 = null;
				if (this.field718 == null) {
					PlayerAppearance.getLoginError(22);
					return;
				}

				packetWriter.clearBuffer();
				var4 = UserComparator9.method3496();
				var4.clientPacket = null;
				var4.clientPacketLength = 0;
				var4.packetBuffer = new PacketBuffer(5000);
				var4.packetBuffer.writeByte(LoginPacket.field2314.id);
				var4.packetBuffer.writeShort(this.field718.offset);
				var4.packetBuffer.method5789(this.field718);
				packetWriter.addNode(var4);
				packetWriter.flush();
				this.field718 = null;
				loginState = 6;
			}

			if (loginState == 10 && ((AbstractSocket)var1).available() > 0) {
				class52.field407 = ((AbstractSocket)var1).readUnsignedByte();
				loginState = 11;
			}

			if (loginState == 11 && ((AbstractSocket)var1).available() >= class52.field407) {
				((AbstractSocket)var1).read(var2.array, 0, class52.field407);
				var2.offset = 0;
				loginState = 6;
			}

			if (loginState == 12 && ((AbstractSocket)var1).available() > 0) {
				field714 = (((AbstractSocket)var1).readUnsignedByte() + 3) * 60;
				loginState = 13;
			}

			if (loginState == 13) {
				field712 = 0;
				HealthBarUpdate.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field714 / 60 + " seconds.");
				if (--field714 <= 0) {
					loginState = 0;
				}

			} else {
				if (loginState == 14 && ((AbstractSocket)var1).available() >= 1) {
					GrandExchangeEvents.field71 = ((AbstractSocket)var1).readUnsignedByte();
					loginState = 15;
				}

				if (loginState == 15 && ((AbstractSocket)var1).available() >= GrandExchangeEvents.field71) {
					var13 = ((AbstractSocket)var1).readUnsignedByte() == 1;
					((AbstractSocket)var1).read(var2.array, 0, 4);
					var2.offset = 0;
					boolean var37 = false;
					if (var13) {
						var14 = var2.readByteIsaac() << 24;
						var14 |= var2.readByteIsaac() << 16;
						var14 |= var2.readByteIsaac() << 8;
						var14 |= var2.readByteIsaac();
						String var34 = Login.Login_username;
						var7 = var34.length();
						var15 = 0;
						var9 = 0;

						while (true) {
							if (var9 >= var7) {
								if (GrandExchangeOfferOwnWorldComparator.clientPreferences.parameters.size() >= 10 && !GrandExchangeOfferOwnWorldComparator.clientPreferences.parameters.containsKey(var15)) {
									Iterator var35 = GrandExchangeOfferOwnWorldComparator.clientPreferences.parameters.entrySet().iterator();
									var35.next();
									var35.remove();
								}

								GrandExchangeOfferOwnWorldComparator.clientPreferences.parameters.put(var15, var14);
								break;
							}

							var15 = (var15 << 5) - var15 + var34.charAt(var9);
							++var9;
						}
					}

					if (Login_isUsernameRemembered) {
						GrandExchangeOfferOwnWorldComparator.clientPreferences.rememberedUsername = Login.Login_username;
					} else {
						GrandExchangeOfferOwnWorldComparator.clientPreferences.rememberedUsername = null;
					}

					WorldMapArea.savePreferences();
					staffModLevel = ((AbstractSocket)var1).readUnsignedByte();
					playerMod = ((AbstractSocket)var1).readUnsignedByte() == 1;
					localPlayerIndex = ((AbstractSocket)var1).readUnsignedByte();
					localPlayerIndex <<= 8;
					localPlayerIndex += ((AbstractSocket)var1).readUnsignedByte();
					field798 = ((AbstractSocket)var1).readUnsignedByte();
					((AbstractSocket)var1).read(var2.array, 0, 1);
					var2.offset = 0;
					ServerPacket[] var29 = KeyHandler.ServerPacket_values();
					int var20 = var2.readSmartByteShortIsaac();
					if (var20 < 0 || var20 >= var29.length) {
						throw new IOException(var20 + " " + var2.offset);
					}

					packetWriter.serverPacket = var29[var20];
					packetWriter.serverPacketLength = packetWriter.serverPacket.length;
					((AbstractSocket)var1).read(var2.array, 0, 2);
					var2.offset = 0;
					packetWriter.serverPacketLength = var2.readUnsignedShort();

					try {
						class56.method950(WorldMapSection1.client, "zap");
					} catch (Throwable var22) {
					}

					loginState = 16;
				}

				if (loginState == 16) {
					if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
						timer.method5045();
						MusicPatchPcmStream.method4004();
						TriBool.updatePlayer(var2);
						class69.field585 = -1;
						GameObject.loadRegions(false, var2);
						packetWriter.serverPacket = null;
					}

				} else {
					if (loginState == 17 && ((AbstractSocket)var1).available() >= 2) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, 2);
						var2.offset = 0;
						class7.field33 = var2.readUnsignedShort();
						loginState = 18;
					}

					if (loginState == 18 && ((AbstractSocket)var1).available() >= class7.field33) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, class7.field33);
						var2.offset = 0;
						String var26 = var2.readStringCp1252NullTerminated();
						String var30 = var2.readStringCp1252NullTerminated();
						String var31 = var2.readStringCp1252NullTerminated();
						HealthBarUpdate.setLoginResponseString(var26, var30, var31);
						MouseRecorder.updateGameState(10);
					}

					if (loginState != 19) {
						++field712;
						if (field712 > 2000) {
							if (field713 < 1) {
								if (class280.port3 == WorldMapLabelSize.port1) {
									class280.port3 = GrandExchangeOfferAgeComparator.port2;
								} else {
									class280.port3 = WorldMapLabelSize.port1;
								}

								++field713;
								loginState = 0;
							} else {
								PlayerAppearance.getLoginError(-3);
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
							var36 = packetWriter.serverPacketLength;
							timer.method5047();
							packetWriter.clearBuffer();
							packetWriter.packetBuffer.offset = 0;
							packetWriter.serverPacket = null;
							packetWriter.field1334 = null;
							packetWriter.field1329 = null;
							packetWriter.field1339 = null;
							packetWriter.serverPacketLength = 0;
							packetWriter.field1338 = 0;
							rebootTimer = 0;
							AbstractByteArrayCopier.method4023();
							minimapState = 0;
							destinationX = 0;

							for (var14 = 0; var14 < 2048; ++var14) {
								players[var14] = null;
							}

							ByteArrayPool.localPlayer = null;

							for (var14 = 0; var14 < npcs.length; ++var14) {
								NPC var32 = npcs[var14];
								if (var32 != null) {
									var32.targetIndex = -1;
									var32.false0 = false;
								}
							}

							ItemContainer.itemContainers = new NodeHashTable(32);
							MouseRecorder.updateGameState(30);

							for (var14 = 0; var14 < 100; ++var14) {
								field679[var14] = true;
							}

							var4 = FaceNormal.getPacketBufferNode(ClientPacket.field2257, packetWriter.isaacCipher);
							var4.packetBuffer.writeByte(class74.getWindowedMode());
							var4.packetBuffer.writeShort(WorldMapLabel.canvasWidth);
							var4.packetBuffer.writeShort(Varps.canvasHeight);
							packetWriter.addNode(var4);
							TriBool.updatePlayer(var2);
							if (var36 != var2.offset) {
								throw new RuntimeException();
							}
						}
					}
				}
			}
		} catch (IOException var24) {
			if (field713 < 1) {
				if (class280.port3 == WorldMapLabelSize.port1) {
					class280.port3 = GrandExchangeOfferAgeComparator.port2;
				} else {
					class280.port3 = WorldMapLabelSize.port1;
				}

				++field713;
				loginState = 0;
			} else {
				PlayerAppearance.getLoginError(-2);
			}
		}
	}

	@ObfuscatedName("fj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1428106045"
	)
	@Export("doCycleLoggedIn")
	final void doCycleLoggedIn() {
		if (rebootTimer > 1) {
			--rebootTimer;
		}

		if (logoutTimer > 0) {
			--logoutTimer;
		}

		if (field728) {
			field728 = false;
			VertexNormal.method3093();
		} else {
			if (!isMenuOpen) {
				Tile.addCancelMenuEntry();
			}

			int var1;
			for (var1 = 0; var1 < 100 && this.method1524(packetWriter); ++var1) {
			}

			if (gameState == 30) {
				while (true) {
					ReflectionCheck var2 = (ReflectionCheck)class105.reflectionChecks.last();
					boolean var31;
					if (var2 == null) {
						var31 = false;
					} else {
						var31 = true;
					}

					int var3;
					PacketBufferNode var32;
					if (!var31) {
						PacketBufferNode var15;
						int var16;
						if (timer.field3581) {
							var15 = FaceNormal.getPacketBufferNode(ClientPacket.field2270, packetWriter.isaacCipher);
							var15.packetBuffer.writeByte(0);
							var16 = var15.packetBuffer.offset;
							timer.write(var15.packetBuffer);
							var15.packetBuffer.writeLengthByte(var15.packetBuffer.offset - var16);
							packetWriter.addNode(var15);
							timer.method5046();
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
						synchronized(MidiPcmStream.mouseRecorder.lock) {
							if (!field749) {
								MidiPcmStream.mouseRecorder.index = 0;
							} else if (MouseHandler.MouseHandler_lastButton != 0 || MidiPcmStream.mouseRecorder.index >= 40) {
								var32 = null;
								var3 = 0;
								var4 = 0;
								var5 = 0;
								var6 = 0;

								for (var7 = 0; var7 < MidiPcmStream.mouseRecorder.index && (var32 == null || var32.packetBuffer.offset - var3 < 246); ++var7) {
									var4 = var7;
									var8 = MidiPcmStream.mouseRecorder.ys[var7];
									if (var8 < -1) {
										var8 = -1;
									} else if (var8 > 65534) {
										var8 = 65534;
									}

									var9 = MidiPcmStream.mouseRecorder.xs[var7];
									if (var9 < -1) {
										var9 = -1;
									} else if (var9 > 65534) {
										var9 = 65534;
									}

									if (var9 != field691 || var8 != field692) {
										if (var32 == null) {
											var32 = FaceNormal.getPacketBufferNode(ClientPacket.field2281, packetWriter.isaacCipher);
											var32.packetBuffer.writeByte(0);
											var3 = var32.packetBuffer.offset;
											PacketBuffer var10000 = var32.packetBuffer;
											var10000.offset += 2;
											var5 = 0;
											var6 = 0;
										}

										if (field875 != -1L) {
											var10 = var9 - field691;
											var11 = var8 - field692;
											var12 = (int)((MidiPcmStream.mouseRecorder.millis[var7] - field875) / 20L);
											var5 = (int)((long)var5 + (MidiPcmStream.mouseRecorder.millis[var7] - field875) % 20L);
										} else {
											var10 = var9;
											var11 = var8;
											var12 = Integer.MAX_VALUE;
										}

										field691 = var9;
										field692 = var8;
										if (var12 < 8 && var10 >= -32 && var10 <= 31 && var11 >= -32 && var11 <= 31) {
											var10 += 32;
											var11 += 32;
											var32.packetBuffer.writeShort((var12 << 12) + var11 + (var10 << 6));
										} else if (var12 < 32 && var10 >= -128 && var10 <= 127 && var11 >= -128 && var11 <= 127) {
											var10 += 128;
											var11 += 128;
											var32.packetBuffer.writeByte(var12 + 128);
											var32.packetBuffer.writeShort(var11 + (var10 << 8));
										} else if (var12 < 32) {
											var32.packetBuffer.writeByte(var12 + 192);
											if (var9 != -1 && var8 != -1) {
												var32.packetBuffer.writeInt(var9 | var8 << 16);
											} else {
												var32.packetBuffer.writeInt(Integer.MIN_VALUE);
											}
										} else {
											var32.packetBuffer.writeShort((var12 & 8191) + 57344);
											if (var9 != -1 && var8 != -1) {
												var32.packetBuffer.writeInt(var9 | var8 << 16);
											} else {
												var32.packetBuffer.writeInt(Integer.MIN_VALUE);
											}
										}

										++var6;
										field875 = MidiPcmStream.mouseRecorder.millis[var7];
									}
								}

								if (var32 != null) {
									var32.packetBuffer.writeLengthByte(var32.packetBuffer.offset - var3);
									var7 = var32.packetBuffer.offset;
									var32.packetBuffer.offset = var3;
									var32.packetBuffer.writeByte(var5 / var6);
									var32.packetBuffer.writeByte(var5 % var6);
									var32.packetBuffer.offset = var7;
									packetWriter.addNode(var32);
								}

								if (var4 >= MidiPcmStream.mouseRecorder.index) {
									MidiPcmStream.mouseRecorder.index = 0;
								} else {
									MouseRecorder var46 = MidiPcmStream.mouseRecorder;
									var46.index -= var4;
									System.arraycopy(MidiPcmStream.mouseRecorder.xs, var4, MidiPcmStream.mouseRecorder.xs, 0, MidiPcmStream.mouseRecorder.index);
									System.arraycopy(MidiPcmStream.mouseRecorder.ys, var4, MidiPcmStream.mouseRecorder.ys, 0, MidiPcmStream.mouseRecorder.index);
									System.arraycopy(MidiPcmStream.mouseRecorder.millis, var4, MidiPcmStream.mouseRecorder.millis, 0, MidiPcmStream.mouseRecorder.index);
								}
							}
						}

						PacketBufferNode var19;
						if (MouseHandler.MouseHandler_lastButton == 1 || !class217.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
							long var17 = MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis;
							if (var17 > 32767L) {
								var17 = 32767L;
							}

							mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis;
							var3 = MouseHandler.MouseHandler_lastPressedY;
							if (var3 < 0) {
								var3 = 0;
							} else if (var3 > Varps.canvasHeight) {
								var3 = Varps.canvasHeight;
							}

							var4 = MouseHandler.MouseHandler_lastPressedX;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > WorldMapLabel.canvasWidth) {
								var4 = WorldMapLabel.canvasWidth;
							}

							var5 = (int)var17;
							var19 = FaceNormal.getPacketBufferNode(ClientPacket.field2209, packetWriter.isaacCipher);
							var19.packetBuffer.writeShort((var5 << 1) + (MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0));
							var19.packetBuffer.writeShort(var4);
							var19.packetBuffer.writeShort(var3);
							packetWriter.addNode(var19);
						}

						if (KeyHandler.field417 > 0) {
							var15 = FaceNormal.getPacketBufferNode(ClientPacket.field2210, packetWriter.isaacCipher);
							var15.packetBuffer.writeShort(0);
							var16 = var15.packetBuffer.offset;
							long var20 = class217.currentTimeMillis();

							for (var5 = 0; var5 < KeyHandler.field417; ++var5) {
								long var22 = var20 - field904;
								if (var22 > 16777215L) {
									var22 = 16777215L;
								}

								field904 = var20;
								var15.packetBuffer.method5616((int)var22);
								var15.packetBuffer.writeByte(KeyHandler.field432[var5]);
							}

							var15.packetBuffer.writeLengthShort(var15.packetBuffer.offset - var16);
							packetWriter.addNode(var15);
						}

						if (field764 > 0) {
							--field764;
						}

						if (KeyHandler.KeyHandler_pressedKeys[96] || KeyHandler.KeyHandler_pressedKeys[97] || KeyHandler.KeyHandler_pressedKeys[98] || KeyHandler.KeyHandler_pressedKeys[99]) {
							field765 = true;
						}

						if (field765 && field764 <= 0) {
							field764 = 20;
							field765 = false;
							var15 = FaceNormal.getPacketBufferNode(ClientPacket.field2220, packetWriter.isaacCipher);
							var15.packetBuffer.writeIntME(camAngleY);
							var15.packetBuffer.writeIntME(camAngleX);
							packetWriter.addNode(var15);
						}

						if (GameShell.hasFocus && !hadFocus) {
							hadFocus = true;
							var15 = FaceNormal.getPacketBufferNode(ClientPacket.field2261, packetWriter.isaacCipher);
							var15.packetBuffer.writeByte(1);
							packetWriter.addNode(var15);
						}

						if (!GameShell.hasFocus && hadFocus) {
							hadFocus = false;
							var15 = FaceNormal.getPacketBufferNode(ClientPacket.field2261, packetWriter.isaacCipher);
							var15.packetBuffer.writeByte(0);
							packetWriter.addNode(var15);
						}

						if (GrandExchangeOfferAgeComparator.worldMap != null) {
							GrandExchangeOfferAgeComparator.worldMap.method6509();
						}

						if (Timer.ClanChat_inClanChat) {
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.sort();
							}

							WorldMapRegion.method537();
							Timer.ClanChat_inClanChat = false;
						}

						InvDefinition.method4443();
						if (gameState != 30) {
							return;
						}

						for (PendingSpawn var37 = (PendingSpawn)pendingSpawns.last(); var37 != null; var37 = (PendingSpawn)pendingSpawns.previous()) {
							if (var37.hitpoints > 0) {
								--var37.hitpoints;
							}

							if (var37.hitpoints == 0) {
								if (var37.objectId < 0 || FileSystem.method3588(var37.objectId, var37.field963)) {
									SoundCache.addPendingSpawnToScene(var37.plane, var37.type, var37.x, var37.y, var37.objectId, var37.field968, var37.field963);
									var37.remove();
								}
							} else {
								if (var37.delay > 0) {
									--var37.delay;
								}

								if (var37.delay == 0 && var37.x >= 1 && var37.y >= 1 && var37.x <= 102 && var37.y <= 102 && (var37.id < 0 || FileSystem.method3588(var37.id, var37.field967))) {
									SoundCache.addPendingSpawnToScene(var37.plane, var37.type, var37.x, var37.y, var37.id, var37.orientation, var37.field967);
									var37.delay = -1;
									if (var37.id == var37.objectId && var37.objectId == -1) {
										var37.remove();
									} else if (var37.objectId == var37.id && var37.field968 == var37.orientation && var37.field967 == var37.field963) {
										var37.remove();
									}
								}
							}
						}

						class22.method252();
						++packetWriter.field1338;
						if (packetWriter.field1338 > 750) {
							VertexNormal.method3093();
							return;
						}

						var1 = Players.Players_count;
						int[] var33 = Players.Players_indices;

						for (var3 = 0; var3 < var1; ++var3) {
							Player var24 = players[var33[var3]];
							if (var24 != null) {
								class41.updateActorSequence(var24, 1);
							}
						}

						for (var1 = 0; var1 < npcCount; ++var1) {
							var16 = npcIndices[var1];
							NPC var25 = npcs[var16];
							if (var25 != null) {
								class41.updateActorSequence(var25, var25.definition.size);
							}
						}

						WorldMapRegion.method630();
						++field741;
						if (mouseCrossColor != 0) {
							mouseCrossState += 20;
							if (mouseCrossState >= 400) {
								mouseCrossColor = 0;
							}
						}

						if (WorldMapID.field307 != null) {
							++field786;
							if (field786 >= 15) {
								ItemContainer.invalidateWidget(WorldMapID.field307);
								WorldMapID.field307 = null;
							}
						}

						Widget var38 = class9.mousedOverWidgetIf1;
						Widget var34 = Language.field2368;
						class9.mousedOverWidgetIf1 = null;
						Language.field2368 = null;
						draggedOnWidget = null;
						field861 = false;
						field732 = false;
						field901 = 0;

						while (class22.isKeyDown() && field901 < 128) {
							if (staffModLevel >= 2 && KeyHandler.KeyHandler_pressedKeys[82] && class3.field16 == 66) {
								String var42 = "";

								Message var39;
								for (Iterator var26 = Messages.Messages_hashTable.iterator(); var26.hasNext(); var42 = var42 + var39.sender + ':' + var39.text + '\n') {
									var39 = (Message)var26.next();
								}

								WorldMapSection1.client.clipboardSetString(var42);
							} else if (oculusOrbState != 1 || Coord.field2531 <= 0) {
								field872[field901] = class3.field16;
								field902[field901] = Coord.field2531;
								++field901;
							}
						}

						boolean var35 = staffModLevel >= 2;
						if (var35 && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81] && mouseWheelRotation != 0) {
							var4 = ByteArrayPool.localPlayer.plane - mouseWheelRotation;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > 3) {
								var4 = 3;
							}

							if (var4 != ByteArrayPool.localPlayer.plane) {
								GrandExchangeOfferWorldComparator.method148(ByteArrayPool.localPlayer.pathX[0] + class69.baseX, ByteArrayPool.localPlayer.pathY[0] + class89.baseY, var4, false);
							}

							mouseWheelRotation = 0;
						}

						if (rootInterface != -1) {
							class2.updateRootInterface(rootInterface, 0, 0, WorldMapLabel.canvasWidth, Varps.canvasHeight, 0, 0);
						}

						++cycleCntr;

						while (true) {
							Widget var40;
							ScriptEvent var43;
							Widget var45;
							do {
								var43 = (ScriptEvent)field727.removeLast();
								if (var43 == null) {
									while (true) {
										do {
											var43 = (ScriptEvent)field919.removeLast();
											if (var43 == null) {
												while (true) {
													do {
														var43 = (ScriptEvent)scriptEvents.removeLast();
														if (var43 == null) {
															this.menu();
															WorldMapArea.method508();
															if (clickedWidget != null) {
																this.method1420();
															}

															if (class236.dragInventoryWidget != null) {
																ItemContainer.invalidateWidget(class236.dragInventoryWidget);
																++itemDragDuration;
																if (MouseHandler.MouseHandler_currentButton == 0) {
																	if (field887) {
																		if (class236.dragInventoryWidget == RouteStrategy.field2106 && dragItemSlotSource != dragItemSlotDestination) {
																			Widget var44 = class236.dragInventoryWidget;
																			byte var36 = 0;
																			if (field845 == 1 && var44.contentType == 206) {
																				var36 = 1;
																			}

																			if (var44.itemIds[dragItemSlotDestination] <= 0) {
																				var36 = 0;
																			}

																			if (MilliClock.method3560(ScriptEvent.getWidgetClickMask(var44))) {
																				var6 = dragItemSlotSource;
																				var7 = dragItemSlotDestination;
																				var44.itemIds[var7] = var44.itemIds[var6];
																				var44.itemQuantities[var7] = var44.itemQuantities[var6];
																				var44.itemIds[var6] = -1;
																				var44.itemQuantities[var6] = 0;
																			} else if (var36 == 1) {
																				var6 = dragItemSlotSource;
																				var7 = dragItemSlotDestination;

																				while (var6 != var7) {
																					if (var6 > var7) {
																						var44.swapItems(var6 - 1, var6);
																						--var6;
																					} else if (var6 < var7) {
																						var44.swapItems(var6 + 1, var6);
																						++var6;
																					}
																				}
																			} else {
																				var44.swapItems(dragItemSlotDestination, dragItemSlotSource);
																			}

																			var19 = FaceNormal.getPacketBufferNode(ClientPacket.field2298, packetWriter.isaacCipher);
																			var19.packetBuffer.writeIntME(dragItemSlotDestination);
																			var19.packetBuffer.method5610(dragItemSlotSource);
																			var19.packetBuffer.writeByte(var36);
																			var19.packetBuffer.writeShortLE(class236.dragInventoryWidget.id);
																			packetWriter.addNode(var19);
																		}
																	} else if (this.shouldLeftClickOpenMenu()) {
																		this.openMenu(draggedWidgetX, draggedWidgetY);
																	} else if (menuOptionsCount > 0) {
																		var4 = draggedWidgetX;
																		var5 = draggedWidgetY;
																		MenuAction var41 = AbstractWorldMapIcon.tempMenuAction;
																		AbstractByteArrayCopier.menuAction(var41.param0, var41.param1, var41.opcode, var41.identifier, var41.action, var41.action, var4, var5);
																		AbstractWorldMapIcon.tempMenuAction = null;
																	}

																	field786 = 10;
																	MouseHandler.MouseHandler_lastButton = 0;
																	class236.dragInventoryWidget = null;
																} else if (itemDragDuration >= 5 && (MouseHandler.MouseHandler_x > draggedWidgetX + 5 || MouseHandler.MouseHandler_x < draggedWidgetX - 5 || MouseHandler.MouseHandler_y > draggedWidgetY + 5 || MouseHandler.MouseHandler_y < draggedWidgetY - 5)) {
																	field887 = true;
																}
															}

															if (Scene.method3215()) {
																var4 = Scene.Scene_selectedX;
																var5 = Scene.Scene_selectedY;
																var19 = FaceNormal.getPacketBufferNode(ClientPacket.field2248, packetWriter.isaacCipher);
																var19.packetBuffer.writeByte(5);
																var19.packetBuffer.writeShort(var4 + class69.baseX);
																var19.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? (KeyHandler.KeyHandler_pressedKeys[81] ? 2 : 1) : 0);
																var19.packetBuffer.writeShort(var5 + class89.baseY);
																packetWriter.addNode(var19);
																Scene.method3347();
																mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
																mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
																mouseCrossColor = 1;
																mouseCrossState = 0;
																destinationX = var4;
																destinationY = var5;
															}

															if (var38 != class9.mousedOverWidgetIf1) {
																if (var38 != null) {
																	ItemContainer.invalidateWidget(var38);
																}

																if (class9.mousedOverWidgetIf1 != null) {
																	ItemContainer.invalidateWidget(class9.mousedOverWidgetIf1);
																}
															}

															if (var34 != Language.field2368 && field871 == field832) {
																if (var34 != null) {
																	ItemContainer.invalidateWidget(var34);
																}

																if (Language.field2368 != null) {
																	ItemContainer.invalidateWidget(Language.field2368);
																}
															}

															if (Language.field2368 != null) {
																if (field871 < field832) {
																	++field871;
																	if (field832 == field871) {
																		ItemContainer.invalidateWidget(Language.field2368);
																	}
																}
															} else if (field871 > 0) {
																--field871;
															}

															Tile.method2961();
															if (isCameraLocked) {
																var4 = HealthBar.field1145 * 128 + 64;
																var5 = WorldMapRectangle.field217 * 128 + 64;
																var6 = class277.getTileHeight(var4, var5, ScriptEvent.Client_plane) - class4.field20;
																if (WorldMapRectangle.cameraX < var4) {
																	WorldMapRectangle.cameraX = (var4 - WorldMapRectangle.cameraX) * NetFileRequest.field3126 / 1000 + WorldMapRectangle.cameraX + GrandExchangeOfferWorldComparator.field64;
																	if (WorldMapRectangle.cameraX > var4) {
																		WorldMapRectangle.cameraX = var4;
																	}
																}

																if (WorldMapRectangle.cameraX > var4) {
																	WorldMapRectangle.cameraX -= NetFileRequest.field3126 * (WorldMapRectangle.cameraX - var4) / 1000 + GrandExchangeOfferWorldComparator.field64;
																	if (WorldMapRectangle.cameraX < var4) {
																		WorldMapRectangle.cameraX = var4;
																	}
																}

																if (GrandExchangeOfferWorldComparator.cameraY < var6) {
																	GrandExchangeOfferWorldComparator.cameraY = (var6 - GrandExchangeOfferWorldComparator.cameraY) * NetFileRequest.field3126 / 1000 + GrandExchangeOfferWorldComparator.cameraY + GrandExchangeOfferWorldComparator.field64;
																	if (GrandExchangeOfferWorldComparator.cameraY > var6) {
																		GrandExchangeOfferWorldComparator.cameraY = var6;
																	}
																}

																if (GrandExchangeOfferWorldComparator.cameraY > var6) {
																	GrandExchangeOfferWorldComparator.cameraY -= NetFileRequest.field3126 * (GrandExchangeOfferWorldComparator.cameraY - var6) / 1000 + GrandExchangeOfferWorldComparator.field64;
																	if (GrandExchangeOfferWorldComparator.cameraY < var6) {
																		GrandExchangeOfferWorldComparator.cameraY = var6;
																	}
																}

																if (class200.cameraZ < var5) {
																	class200.cameraZ = (var5 - class200.cameraZ) * NetFileRequest.field3126 / 1000 + class200.cameraZ + GrandExchangeOfferWorldComparator.field64;
																	if (class200.cameraZ > var5) {
																		class200.cameraZ = var5;
																	}
																}

																if (class200.cameraZ > var5) {
																	class200.cameraZ -= NetFileRequest.field3126 * (class200.cameraZ - var5) / 1000 + GrandExchangeOfferWorldComparator.field64;
																	if (class200.cameraZ < var5) {
																		class200.cameraZ = var5;
																	}
																}

																var4 = field925 * 128 + 64;
																var5 = Strings.field2759 * 128 + 64;
																var6 = class277.getTileHeight(var4, var5, ScriptEvent.Client_plane) - TextureProvider.field1549;
																var7 = var4 - WorldMapRectangle.cameraX;
																var8 = var6 - GrandExchangeOfferWorldComparator.cameraY;
																var9 = var5 - class200.cameraZ;
																var10 = (int)Math.sqrt((double)(var7 * var7 + var9 * var9));
																var11 = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
																var12 = (int)(Math.atan2((double)var7, (double)var9) * -325.949D) & 2047;
																if (var11 < 128) {
																	var11 = 128;
																}

																if (var11 > 383) {
																	var11 = 383;
																}

																if (class74.cameraPitch < var11) {
																	class74.cameraPitch = (var11 - class74.cameraPitch) * Players.field1280 / 1000 + class74.cameraPitch + Friend.field3626;
																	if (class74.cameraPitch > var11) {
																		class74.cameraPitch = var11;
																	}
																}

																if (class74.cameraPitch > var11) {
																	class74.cameraPitch -= Players.field1280 * (class74.cameraPitch - var11) / 1000 + Friend.field3626;
																	if (class74.cameraPitch < var11) {
																		class74.cameraPitch = var11;
																	}
																}

																int var27 = var12 - WorldMapIcon_1.cameraYaw;
																if (var27 > 1024) {
																	var27 -= 2048;
																}

																if (var27 < -1024) {
																	var27 += 2048;
																}

																if (var27 > 0) {
																	WorldMapIcon_1.cameraYaw = var27 * Players.field1280 / 1000 + WorldMapIcon_1.cameraYaw + Friend.field3626;
																	WorldMapIcon_1.cameraYaw &= 2047;
																}

																if (var27 < 0) {
																	WorldMapIcon_1.cameraYaw -= Friend.field3626 + -var27 * Players.field1280 / 1000;
																	WorldMapIcon_1.cameraYaw &= 2047;
																}

																int var14 = var12 - WorldMapIcon_1.cameraYaw;
																if (var14 > 1024) {
																	var14 -= 2048;
																}

																if (var14 < -1024) {
																	var14 += 2048;
																}

																if (var14 < 0 && var27 > 0 || var14 > 0 && var27 < 0) {
																	WorldMapIcon_1.cameraYaw = var12;
																}
															}

															for (var4 = 0; var4 < 5; ++var4) {
																int var10002 = field930[var4]++;
															}

															UserComparator4.varcs.tryWrite();
															var4 = ++MouseHandler.MouseHandler_idleCycles - 1;
															var6 = KeyHandler.KeyHandler_idleCycles;
															PacketBufferNode var28;
															if (var4 > 15000 && var6 > 15000) {
																logoutTimer = 250;
																ServerPacket.method3684(14500);
																var28 = FaceNormal.getPacketBufferNode(ClientPacket.field2251, packetWriter.isaacCipher);
																packetWriter.addNode(var28);
															}

															Projectile.friendSystem.processFriendUpdates();
															++packetWriter.pendingWrites;
															if (packetWriter.pendingWrites > 50) {
																var28 = FaceNormal.getPacketBufferNode(ClientPacket.field2295, packetWriter.isaacCipher);
																packetWriter.addNode(var28);
															}

															try {
																packetWriter.flush();
															} catch (IOException var29) {
																VertexNormal.method3093();
															}

															return;
														}

														var45 = var43.widget;
														if (var45.childIndex < 0) {
															break;
														}

														var40 = MusicPatchNode.getWidget(var45.parentId);
													} while(var40 == null || var40.children == null || var45.childIndex >= var40.children.length || var45 != var40.children[var45.childIndex]);

													GrandExchangeOfferOwnWorldComparator.runScriptEvent(var43);
												}
											}

											var45 = var43.widget;
											if (var45.childIndex < 0) {
												break;
											}

											var40 = MusicPatchNode.getWidget(var45.parentId);
										} while(var40 == null || var40.children == null || var45.childIndex >= var40.children.length || var45 != var40.children[var45.childIndex]);

										GrandExchangeOfferOwnWorldComparator.runScriptEvent(var43);
									}
								}

								var45 = var43.widget;
								if (var45.childIndex < 0) {
									break;
								}

								var40 = MusicPatchNode.getWidget(var45.parentId);
							} while(var40 == null || var40.children == null || var45.childIndex >= var40.children.length || var45 != var40.children[var45.childIndex]);

							GrandExchangeOfferOwnWorldComparator.runScriptEvent(var43);
						}
					}

					var32 = FaceNormal.getPacketBufferNode(ClientPacket.field2304, packetWriter.isaacCipher);
					var32.packetBuffer.writeByte(0);
					var3 = var32.packetBuffer.offset;
					GameObject.performReflectionCheck(var32.packetBuffer);
					var32.packetBuffer.writeLengthByte(var32.packetBuffer.offset - var3);
					packetWriter.addNode(var32);
				}
			}
		}
	}

	@ObfuscatedName("ga")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-61779781"
	)
	@Export("resizeJS")
	void resizeJS() {
		int var1 = WorldMapLabel.canvasWidth;
		int var2 = Varps.canvasHeight;
		if (super.contentWidth < var1) {
			var1 = super.contentWidth;
		}

		if (super.contentHeight < var2) {
			var2 = super.contentHeight;
		}

		if (GrandExchangeOfferOwnWorldComparator.clientPreferences != null) {
			try {
				Client var3 = WorldMapSection1.client;
				Object[] var4 = new Object[]{class74.getWindowedMode()};
				JSObject.getWindow(var3).call("resize", var4);
			} catch (Throwable var5) {
			}
		}

	}

	@ObfuscatedName("gc")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "38"
	)
	@Export("drawLoggedIn")
	final void drawLoggedIn() {
		int var1;
		if (rootInterface != -1) {
			var1 = rootInterface;
			if (LoginScreenAnimation.loadInterface(var1)) {
				MilliClock.drawModelComponents(Widget.Widget_interfaceComponents[var1], -1);
			}
		}

		for (var1 = 0; var1 < rootWidgetCount; ++var1) {
			if (field679[var1]) {
				field886[var1] = true;
			}

			field813[var1] = field679[var1];
			field679[var1] = false;
		}

		field884 = cycle;
		viewportX = -1;
		viewportY = -1;
		RouteStrategy.field2106 = null;
		if (rootInterface != -1) {
			rootWidgetCount = 0;
			MusicPatch.drawWidgets(rootInterface, 0, 0, WorldMapLabel.canvasWidth, Varps.canvasHeight, 0, 0, -1);
		}

		Rasterizer2D.Rasterizer2D_resetClip();
		if (showMouseCross) {
			if (mouseCrossColor == 1) {
				class299.crossSprites[mouseCrossState / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}

			if (mouseCrossColor == 2) {
				class299.crossSprites[mouseCrossState / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}
		}

		int var2;
		int var3;
		if (!isMenuOpen) {
			if (viewportX != -1) {
				var1 = viewportX;
				var2 = viewportY;
				if ((menuOptionsCount >= 2 || isItemSelected != 0 || isSpellSelected) && showMouseOverText) {
					var3 = AbstractWorldMapData.method381();
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
						var4 = var4 + class297.colorStartTag(16777215) + " " + '/' + " " + (menuOptionsCount - 2) + " more options";
					}

					TaskHandler.fontBold12.drawRandomAlphaAndSpacing(var4, var1 + 4, var2 + 15, 16777215, 0, cycle / 1000);
				}
			}
		} else {
			var1 = WorldMapDecoration.menuX;
			var2 = PacketBufferNode.menuY;
			var3 = class49.menuWidth;
			int var13 = WorldMapData_1.menuHeight;
			int var14 = 6116423;
			Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var13, var14);
			Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var1 + 1, var2 + 18, var3 - 2, var13 - 19, 0);
			TaskHandler.fontBold12.draw("Choose Option", var1 + 3, var2 + 14, var14, -1);
			int var6 = MouseHandler.MouseHandler_x;
			int var7 = MouseHandler.MouseHandler_y;

			for (int var8 = 0; var8 < menuOptionsCount; ++var8) {
				int var9 = var2 + (menuOptionsCount - 1 - var8) * 15 + 31;
				int var10 = 16777215;
				if (var6 > var1 && var6 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
					var10 = 16776960;
				}

				Font var11 = TaskHandler.fontBold12;
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

			class49.method848(WorldMapDecoration.menuX, PacketBufferNode.menuY, class49.menuWidth, WorldMapData_1.menuHeight);
		}

		if (gameDrawingMode == 3) {
			for (var1 = 0; var1 < rootWidgetCount; ++var1) {
				if (field813[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
				} else if (field886[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
				}
			}
		}

		Message.method1300(ScriptEvent.Client_plane, ByteArrayPool.localPlayer.x, ByteArrayPool.localPlayer.y, field741);
		field741 = 0;
	}

	@ObfuscatedName("hl")
	@ObfuscatedSignature(
		signature = "(Ldv;I)Z",
		garbageValue = "-124055306"
	)
	final boolean method1524(PacketWriter var1) {
		AbstractSocket var2 = var1.getSocket();
		PacketBuffer var3 = var1.packetBuffer;
		if (var2 == null) {
			return false;
		} else {
			int var6;
			String var27;
			try {
				int var5;
				if (var1.serverPacket == null) {
					if (var1.field1335) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 0, 1);
						var1.field1338 = 0;
						var1.field1335 = false;
					}

					var3.offset = 0;
					if (var3.method5524()) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 1, 1);
						var1.field1338 = 0;
					}

					var1.field1335 = true;
					ServerPacket[] var4 = KeyHandler.ServerPacket_values();
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
				var1.field1338 = 0;
				timer.method5051();
				var1.field1339 = var1.field1329;
				var1.field1329 = var1.field1334;
				var1.field1334 = var1.serverPacket;
				int var16;
				if (ServerPacket.field2204 == var1.serverPacket) {
					var16 = var3.method5614();
					var5 = var3.method5638();
					Varps.Varps_temp[var16] = var5;
					if (Varps.Varps_main[var16] != var5) {
						Varps.Varps_main[var16] = var5;
					}

					class22.changeGameOptions(var16);
					field866[++field772 - 1 & 31] = var16;
					var1.serverPacket = null;
					return true;
				}

				int var42;
				if (ServerPacket.field2129 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedByte();
					var42 = var3.readUnsignedByte();
					field926[var16] = true;
					field788[var16] = var5;
					field730[var16] = var6;
					field929[var16] = var42;
					field930[var16] = 0;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2160 == var1.serverPacket) {
					WorldMapData_1.method816(class194.field2325);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2187 == var1.serverPacket) {
					isCameraLocked = true;
					HealthBar.field1145 = var3.readUnsignedByte();
					WorldMapRectangle.field217 = var3.readUnsignedByte();
					class4.field20 = var3.readUnsignedShort();
					GrandExchangeOfferWorldComparator.field64 = var3.readUnsignedByte();
					NetFileRequest.field3126 = var3.readUnsignedByte();
					if (NetFileRequest.field3126 >= 100) {
						WorldMapRectangle.cameraX = HealthBar.field1145 * 128 + 64;
						class200.cameraZ = WorldMapRectangle.field217 * 128 + 64;
						GrandExchangeOfferWorldComparator.cameraY = class277.getTileHeight(WorldMapRectangle.cameraX, class200.cameraZ, ScriptEvent.Client_plane) - class4.field20;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2199 == var1.serverPacket) {
					tradeChatMode = var3.method5604();
					publicChatMode = var3.method5604();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2144 == var1.serverPacket) {
					Projectile.friendSystem.readUpdate(var3, var1.serverPacketLength);
					field873 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				Widget var47;
				if (ServerPacket.field2186 == var1.serverPacket) {
					var16 = var3.method5564();
					var5 = var3.method5564();
					var6 = var3.method5621();
					var47 = MusicPatchNode.getWidget(var6);
					var47.field2623 = var5 + (var16 << 16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2145 == var1.serverPacket) {
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
						hintArrowHeight = var3.readUnsignedByte();
					}

					if (hintArrowType == 10) {
						hintArrowPlayerIndex = var3.readUnsignedShort();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2119 == var1.serverPacket) {
					var16 = var3.method5564();
					byte var45 = var3.method5608();
					Varps.Varps_temp[var16] = var45;
					if (Varps.Varps_main[var16] != var45) {
						Varps.Varps_main[var16] = var45;
					}

					class22.changeGameOptions(var16);
					field866[++field772 - 1 & 31] = var16;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2125 == var1.serverPacket) {
					WorldMapData_1.method816(class194.field2328);
					var1.serverPacket = null;
					return true;
				}

				boolean var60;
				if (ServerPacket.field2164 == var1.serverPacket) {
					var60 = var3.readBoolean();
					if (var60) {
						if (WorldMapRectangle.field222 == null) {
							WorldMapRectangle.field222 = new class247();
						}
					} else {
						WorldMapRectangle.field222 = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2146 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					rootInterface = var16;
					this.resizeRoot(false);
					class4.Widget_resetModelFrames(var16);
					WorldMapSectionType.runWidgetOnLoadListener(rootInterface);

					for (var5 = 0; var5 < 100; ++var5) {
						field679[var5] = true;
					}

					var1.serverPacket = null;
					return true;
				}

				Widget var50;
				if (ServerPacket.field2179 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.method5613();
					var50 = MusicPatchNode.getWidget(var16);
					if (var50.modelType != 1 || var5 != var50.modelId) {
						var50.modelType = 1;
						var50.modelId = var5;
						ItemContainer.invalidateWidget(var50);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2121 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					Player.forceDisconnect(var16);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2197 == var1.serverPacket) {
					WorldMapData_1.method816(class194.field2331);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2200 == var1.serverPacket) {
					Huffman.logOut();
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2202 == var1.serverPacket) {
					rebootTimer = var3.readUnsignedShort() * 30;
					field877 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2161 == var1.serverPacket) {
					WorldMapData_1.method816(class194.field2329);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2195 == var1.serverPacket) {
					class58.method966();
					weight = var3.readShort();
					field877 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2183 == var1.serverPacket) {
					WorldMapData_1.method816(class194.field2323);
					var1.serverPacket = null;
					return true;
				}

				int var8;
				int var9;
				int var10;
				if (ServerPacket.field2177 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var16 < -70000) {
						var5 += 32768;
					}

					if (var16 >= 0) {
						var50 = MusicPatchNode.getWidget(var16);
					} else {
						var50 = null;
					}

					if (var50 != null) {
						for (var42 = 0; var42 < var50.itemIds.length; ++var42) {
							var50.itemIds[var42] = 0;
							var50.itemQuantities[var42] = 0;
						}
					}

					GrandExchangeOfferOwnWorldComparator.clearItemContainer(var5);
					var42 = var3.readUnsignedShort();

					for (var8 = 0; var8 < var42; ++var8) {
						var9 = var3.method5614();
						var10 = var3.method5604();
						if (var10 == 255) {
							var10 = var3.method5621();
						}

						if (var50 != null && var8 < var50.itemIds.length) {
							var50.itemIds[var8] = var9;
							var50.itemQuantities[var8] = var10;
						}

						Messages.itemContainerSetItem(var5, var8, var9 - 1, var10);
					}

					if (var50 != null) {
						ItemContainer.invalidateWidget(var50);
					}

					class58.method966();
					changedItemContainers[++field869 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2147 == var1.serverPacket) {
					Projectile.friendSystem.method1953();
					field873 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2185 == var1.serverPacket) {
					var16 = var3.method5619();
					var5 = var3.method5743();
					var6 = var3.method5743();
					var47 = MusicPatchNode.getWidget(var16);
					if (var5 != var47.rawX || var6 != var47.rawY || var47.xAlignment != 0 || var47.yAlignment != 0) {
						var47.rawX = var5;
						var47.rawY = var6;
						var47.xAlignment = 0;
						var47.yAlignment = 0;
						ItemContainer.invalidateWidget(var47);
						this.alignWidget(var47);
						if (var47.type == 0) {
							MouseHandler.revalidateWidgetScroll(Widget.Widget_interfaceComponents[var16 >> 16], var47, false);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2162 == var1.serverPacket) {
					var60 = var3.readUnsignedByte() == 1;
					if (var60) {
						TilePaint.field1802 = class217.currentTimeMillis() - var3.readLong();
						GrandExchangeEvent.grandExchangeEvents = new GrandExchangeEvents(var3, true);
					} else {
						GrandExchangeEvent.grandExchangeEvents = null;
					}

					field726 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				long var12;
				long var19;
				long var21;
				long var23;
				String var37;
				if (ServerPacket.field2193 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					var19 = var3.readLong();
					var21 = (long)var3.readUnsignedShort();
					var23 = (long)var3.readMedium();
					PlayerType var43 = (PlayerType)GrandExchangeEvent.findEnumerated(InterfaceParent.PlayerType_values(), var3.readUnsignedByte());
					var12 = var23 + (var21 << 32);
					boolean var44 = false;

					for (int var15 = 0; var15 < 100; ++var15) {
						if (var12 == field846[var15]) {
							var44 = true;
							break;
						}
					}

					if (var43.isUser && Projectile.friendSystem.isIgnored(new Username(var37, WorldMapIcon_0.loginType))) {
						var44 = true;
					}

					if (!var44 && field794 == 0) {
						field846[field900] = var12;
						field900 = (field900 + 1) % 100;
						String var25 = AbstractFont.escapeBrackets(Decimator.method2636(JagexCache.method3577(var3)));
						if (var43.modIcon != -1) {
							ChatChannel.addChatMessage(9, class1.method21(var43.modIcon) + var37, var25, Buffer.base37DecodeLong(var19));
						} else {
							ChatChannel.addChatMessage(9, var37, var25, Buffer.base37DecodeLong(var19));
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2176 == var1.serverPacket) {
					var16 = var3.method5564();
					var5 = var3.readInt();
					var6 = var16 >> 10 & 31;
					var42 = var16 >> 5 & 31;
					var8 = var16 & 31;
					var9 = (var42 << 11) + (var6 << 19) + (var8 << 3);
					Widget var51 = MusicPatchNode.getWidget(var5);
					if (var9 != var51.color) {
						var51.color = var9;
						ItemContainer.invalidateWidget(var51);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2137 == var1.serverPacket) {
					var16 = var3.readInt();
					if (var16 != field762) {
						field762 = var16;
						class3.method48();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2184 == var1.serverPacket) {
					isCameraLocked = false;

					for (var16 = 0; var16 < 5; ++var16) {
						field926[var16] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2143 == var1.serverPacket) {
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

				if (ServerPacket.field2153 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readUnsignedShort();
					if (var16 < -70000) {
						var5 += 32768;
					}

					if (var16 >= 0) {
						var50 = MusicPatchNode.getWidget(var16);
					} else {
						var50 = null;
					}

					for (; var3.offset < var1.serverPacketLength; Messages.itemContainerSetItem(var5, var42, var8 - 1, var9)) {
						var42 = var3.readUShortSmart();
						var8 = var3.readUnsignedShort();
						var9 = 0;
						if (var8 != 0) {
							var9 = var3.readUnsignedByte();
							if (var9 == 255) {
								var9 = var3.readInt();
							}
						}

						if (var50 != null && var42 >= 0 && var42 < var50.itemIds.length) {
							var50.itemIds[var42] = var8;
							var50.itemQuantities[var42] = var9;
						}
					}

					if (var50 != null) {
						ItemContainer.invalidateWidget(var50);
					}

					class58.method966();
					changedItemContainers[++field869 - 1 & 31] = var5 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2133 == var1.serverPacket) {
					var16 = var3.readInt();
					var27 = var3.readStringCp1252NullTerminated();
					var50 = MusicPatchNode.getWidget(var16);
					if (!var27.equals(var50.text)) {
						var50.text = var27;
						ItemContainer.invalidateWidget(var50);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2171 == var1.serverPacket) {
					var16 = var3.method5614();
					if (var16 == 65535) {
						var16 = -1;
					}

					StudioGame.playSong(var16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2173 == var1.serverPacket) {
					var16 = var3.readMedium();
					var5 = var3.readUnsignedShort();
					if (var5 == 65535) {
						var5 = -1;
					}

					VerticalAlignment.playSoundJingle(var5, var16);
					var1.serverPacket = null;
					return true;
				}

				Widget var28;
				if (ServerPacket.field2168 == var1.serverPacket) {
					var16 = var3.method5613();
					var5 = var3.method5619();
					var6 = var3.method5614();
					var42 = var3.readUnsignedShort();
					var28 = MusicPatchNode.getWidget(var5);
					if (var42 != var28.modelAngleX || var16 != var28.modelAngleY || var6 != var28.modelZoom) {
						var28.modelAngleX = var42;
						var28.modelAngleY = var16;
						var28.modelZoom = var6;
						ItemContainer.invalidateWidget(var28);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2203 == var1.serverPacket) {
					if (InterfaceParent.clanChat != null) {
						InterfaceParent.clanChat.method5301(var3);
					}

					WorldMapData_0.method263();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2155 == var1.serverPacket) {
					class58.method966();
					var16 = var3.method5604();
					var5 = var3.method5603();
					var6 = var3.method5619();
					experience[var5] = var6;
					currentLevels[var5] = var16;
					levels[var5] = 1;

					for (var42 = 0; var42 < 98; ++var42) {
						if (var6 >= Skills.Skills_experienceTable[var42]) {
							levels[var5] = var42 + 2;
						}
					}

					changedSkills[++changedSkillsCount - 1 & 31] = var5;
					var1.serverPacket = null;
					return true;
				}

				InterfaceParent var17;
				if (ServerPacket.field2182 == var1.serverPacket) {
					var16 = var3.method5604();
					var5 = var3.method5613();
					var6 = var3.method5638();
					var17 = (InterfaceParent)interfaceParents.get((long)var6);
					if (var17 != null) {
						class41.closeInterface(var17, var5 != var17.group);
					}

					AbstractWorldMapData.method382(var6, var5, var16);
					var1.serverPacket = null;
					return true;
				}

				String var48;
				if (ServerPacket.field2175 == var1.serverPacket) {
					byte[] var41 = new byte[var1.serverPacketLength];
					var3.method5516(var41, 0, var41.length);
					Buffer var59 = new Buffer(var41);
					var48 = var59.readStringCp1252NullTerminated();
					Script.openURL(var48, true, false);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2150 == var1.serverPacket) {
					WorldMapData_1.method816(class194.field2330);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2154 == var1.serverPacket) {
					if (rootInterface != -1) {
						class198.runIntfCloseListeners(rootInterface, 0);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2172 == var1.serverPacket) {
					var3.offset += 28;
					if (var3.checkCrc()) {
						ModelData0.method3362(var3, var3.offset - 28);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2152 == var1.serverPacket) {
					class74.method1328(var3.readStringCp1252NullTerminated());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2141 == var1.serverPacket) {
					WorldMapData_1.method816(class194.field2324);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2198 == var1.serverPacket) {
					WorldMapData_1.method816(class194.field2326);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2159 == var1.serverPacket) {
					World var40 = new World();
					var40.host = var3.readStringCp1252NullTerminated();
					var40.id = var3.readUnsignedShort();
					var5 = var3.readInt();
					var40.properties = var5;
					MouseRecorder.updateGameState(45);
					var2.close();
					var2 = null;
					UserComparator3.changeWorld(var40);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2126 == var1.serverPacket) {
					var16 = var3.method5743();
					var5 = var3.method5621();
					var50 = MusicPatchNode.getWidget(var5);
					if (var16 != var50.sequenceId || var16 == -1) {
						var50.sequenceId = var16;
						var50.modelFrame = 0;
						var50.modelFrameCycle = 0;
						ItemContainer.invalidateWidget(var50);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2132 == var1.serverPacket) {
					var16 = var3.readUnsignedShort();
					var5 = var3.readUnsignedByte();
					var6 = var3.readUnsignedShort();
					ModelData0.queueSoundEffect(var16, var5, var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2158 == var1.serverPacket) {
					PlatformInfo.field3959 = var3.method5605();
					GrandExchangeOfferTotalQuantityComparator.field91 = var3.method5605();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2166 == var1.serverPacket) {
					isCameraLocked = true;
					field925 = var3.readUnsignedByte();
					Strings.field2759 = var3.readUnsignedByte();
					TextureProvider.field1549 = var3.readUnsignedShort();
					Friend.field3626 = var3.readUnsignedByte();
					Players.field1280 = var3.readUnsignedByte();
					if (Players.field1280 >= 100) {
						var16 = field925 * 128 + 64;
						var5 = Strings.field2759 * 128 + 64;
						var6 = class277.getTileHeight(var16, var5, ScriptEvent.Client_plane) - TextureProvider.field1549;
						var42 = var16 - WorldMapRectangle.cameraX;
						var8 = var6 - GrandExchangeOfferWorldComparator.cameraY;
						var9 = var5 - class200.cameraZ;
						var10 = (int)Math.sqrt((double)(var42 * var42 + var9 * var9));
						class74.cameraPitch = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
						WorldMapIcon_1.cameraYaw = (int)(Math.atan2((double)var42, (double)var9) * -325.949D) & 2047;
						if (class74.cameraPitch < 128) {
							class74.cameraPitch = 128;
						}

						if (class74.cameraPitch > 383) {
							class74.cameraPitch = 383;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2139 == var1.serverPacket) {
					GameObject.loadRegions(false, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2140 == var1.serverPacket) {
					var16 = var3.method5638();
					var5 = var3.method5613();
					var50 = MusicPatchNode.getWidget(var16);
					if (var50.modelType != 2 || var5 != var50.modelId) {
						var50.modelType = 2;
						var50.modelId = var5;
						ItemContainer.invalidateWidget(var50);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2128 == var1.serverPacket) {
					for (var16 = 0; var16 < Varps.Varps_main.length; ++var16) {
						if (Varps.Varps_temp[var16] != Varps.Varps_main[var16]) {
							Varps.Varps_main[var16] = Varps.Varps_temp[var16];
							class22.changeGameOptions(var16);
							field866[++field772 - 1 & 31] = var16;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2130 == var1.serverPacket) {
					GameObject.loadRegions(true, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				boolean var39;
				if (ServerPacket.field2196 == var1.serverPacket) {
					var16 = var3.method5638();
					var39 = var3.readUnsignedByte() == 1;
					var50 = MusicPatchNode.getWidget(var16);
					if (var39 != var50.isHidden) {
						var50.isHidden = var39;
						ItemContainer.invalidateWidget(var50);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2142 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					var27 = AbstractFont.escapeBrackets(Decimator.method2636(JagexCache.method3577(var3)));
					Skeleton.addGameMessage(6, var37, var27);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2194 == var1.serverPacket) {
					PlatformInfo.field3959 = var3.method5605();
					GrandExchangeOfferTotalQuantityComparator.field91 = var3.readUnsignedByte();

					while (var3.offset < var1.serverPacketLength) {
						var16 = var3.readUnsignedByte();
						class194 var58 = WorldMapSection2.method434()[var16];
						WorldMapData_1.method816(var58);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2131 == var1.serverPacket) {
					if (var1.serverPacketLength == 0) {
						InterfaceParent.clanChat = null;
					} else {
						if (InterfaceParent.clanChat == null) {
							InterfaceParent.clanChat = new ClanChat(WorldMapIcon_0.loginType, WorldMapSection1.client);
						}

						InterfaceParent.clanChat.readUpdate(var3);
					}

					WorldMapData_0.method263();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2148 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					var19 = (long)var3.readUnsignedShort();
					var21 = (long)var3.readMedium();
					PlayerType var29 = (PlayerType)GrandExchangeEvent.findEnumerated(InterfaceParent.PlayerType_values(), var3.readUnsignedByte());
					long var30 = (var19 << 32) + var21;
					boolean var32 = false;

					for (int var13 = 0; var13 < 100; ++var13) {
						if (field846[var13] == var30) {
							var32 = true;
							break;
						}
					}

					if (Projectile.friendSystem.isIgnored(new Username(var37, WorldMapIcon_0.loginType))) {
						var32 = true;
					}

					if (!var32 && field794 == 0) {
						field846[field900] = var30;
						field900 = (field900 + 1) % 100;
						String var33 = AbstractFont.escapeBrackets(Decimator.method2636(JagexCache.method3577(var3)));
						byte var14;
						if (var29.isPrivileged) {
							var14 = 7;
						} else {
							var14 = 3;
						}

						if (var29.modIcon != -1) {
							Skeleton.addGameMessage(var14, class1.method21(var29.modIcon) + var37, var33);
						} else {
							Skeleton.addGameMessage(var14, var37, var33);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2189 == var1.serverPacket) {
					var16 = var3.method5614();
					if (var16 == 65535) {
						var16 = -1;
					}

					var5 = var3.method5619();
					var6 = var3.method5621();
					var47 = MusicPatchNode.getWidget(var6);
					ItemDefinition var56;
					if (!var47.isIf3) {
						if (var16 == -1) {
							var47.modelType = 0;
							var1.serverPacket = null;
							return true;
						}

						var56 = AbstractWorldMapData.ItemDefinition_get(var16);
						var47.modelType = 4;
						var47.modelId = var16;
						var47.modelAngleX = var56.xan2d;
						var47.modelAngleY = var56.yan2d;
						var47.modelZoom = var56.zoom2d * 100 / var5;
						ItemContainer.invalidateWidget(var47);
					} else {
						var47.itemId = var16;
						var47.itemQuantity = var5;
						var56 = AbstractWorldMapData.ItemDefinition_get(var16);
						var47.modelAngleX = var56.xan2d;
						var47.modelAngleY = var56.yan2d;
						var47.modelAngleZ = var56.zan2d;
						var47.modelOffsetX = var56.offsetX2d;
						var47.modelOffsetY = var56.offsetY2d;
						var47.modelZoom = var56.zoom2d;
						if (var56.isStackable == 1) {
							var47.itemQuantityMode = 1;
						} else {
							var47.itemQuantityMode = 2;
						}

						if (var47.field2622 > 0) {
							var47.modelZoom = var47.modelZoom * 32 / var47.field2622;
						} else if (var47.rawWidth > 0) {
							var47.modelZoom = var47.modelZoom * 32 / var47.rawWidth;
						}

						ItemContainer.invalidateWidget(var47);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2180 == var1.serverPacket) {
					GrandExchangeOffer.updateNpcs(false, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2165 == var1.serverPacket) {
					class58.method966();
					runEnergy = var3.readUnsignedByte();
					field877 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2192 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					var5 = var3.method5604();
					var6 = var3.method5603();
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

				if (ServerPacket.field2163 == var1.serverPacket) {
					UserComparator3.privateChatMode = class219.method4052(var3.readUnsignedByte());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2149 == var1.serverPacket) {
					WorldMapData_1.method816(class194.field2332);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2156 == var1.serverPacket) {
					WorldMapData_1.method816(class194.field2327);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2127 == var1.serverPacket) {
					minimapState = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2191 == var1.serverPacket) {
					var16 = var3.offset + var1.serverPacketLength;
					var5 = var3.readUnsignedShort();
					var6 = var3.readUnsignedShort();
					if (var5 != rootInterface) {
						rootInterface = var5;
						this.resizeRoot(false);
						class4.Widget_resetModelFrames(rootInterface);
						WorldMapSectionType.runWidgetOnLoadListener(rootInterface);

						for (var42 = 0; var42 < 100; ++var42) {
							field679[var42] = true;
						}
					}

					InterfaceParent var26;
					for (; var6-- > 0; var26.field594 = true) {
						var42 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var9 = var3.readUnsignedByte();
						var26 = (InterfaceParent)interfaceParents.get((long)var42);
						if (var26 != null && var8 != var26.group) {
							class41.closeInterface(var26, true);
							var26 = null;
						}

						if (var26 == null) {
							var26 = AbstractWorldMapData.method382(var42, var8, var9);
						}
					}

					for (var17 = (InterfaceParent)interfaceParents.first(); var17 != null; var17 = (InterfaceParent)interfaceParents.next()) {
						if (var17.field594) {
							var17.field594 = false;
						} else {
							class41.closeInterface(var17, true);
						}
					}

					widgetClickMasks = new NodeHashTable(512);

					while (var3.offset < var16) {
						var42 = var3.readInt();
						var8 = var3.readUnsignedShort();
						var9 = var3.readUnsignedShort();
						var10 = var3.readInt();

						for (int var34 = var8; var34 <= var9; ++var34) {
							var12 = (long)var34 + ((long)var42 << 32);
							widgetClickMasks.put(new IntegerNode(var10), var12);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2188 == var1.serverPacket) {
					var16 = var3.readInt();
					InterfaceParent var57 = (InterfaceParent)interfaceParents.get((long)var16);
					if (var57 != null) {
						class41.closeInterface(var57, true);
					}

					if (meslayerContinueWidget != null) {
						ItemContainer.invalidateWidget(meslayerContinueWidget);
						meslayerContinueWidget = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2134 == var1.serverPacket) {
					GrandExchangeOfferTotalQuantityComparator.field91 = var3.readUnsignedByte();
					PlatformInfo.field3959 = var3.method5605();

					for (var16 = GrandExchangeOfferTotalQuantityComparator.field91; var16 < GrandExchangeOfferTotalQuantityComparator.field91 + 8; ++var16) {
						for (var5 = PlatformInfo.field3959; var5 < PlatformInfo.field3959 + 8; ++var5) {
							if (groundItems[ScriptEvent.Client_plane][var16][var5] != null) {
								groundItems[ScriptEvent.Client_plane][var16][var5] = null;
								World.updateItemPile(var16, var5);
							}
						}
					}

					for (PendingSpawn var38 = (PendingSpawn)pendingSpawns.last(); var38 != null; var38 = (PendingSpawn)pendingSpawns.previous()) {
						if (var38.x >= GrandExchangeOfferTotalQuantityComparator.field91 && var38.x < GrandExchangeOfferTotalQuantityComparator.field91 + 8 && var38.y >= PlatformInfo.field3959 && var38.y < PlatformInfo.field3959 + 8 && var38.plane == ScriptEvent.Client_plane) {
							var38.hitpoints = 0;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2169 == var1.serverPacket) {
					for (var16 = 0; var16 < VarpDefinition.VarpDefinition_fileCount; ++var16) {
						VarpDefinition var54 = class228.VarpDefinition_get(var16);
						if (var54 != null) {
							Varps.Varps_temp[var16] = 0;
							Varps.Varps_main[var16] = 0;
						}
					}

					class58.method966();
					field772 += 32;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2136 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					class22.method256(var16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2178 == var1.serverPacket) {
					var16 = var3.method5564();
					var5 = var3.method5619();
					var50 = MusicPatchNode.getWidget(var5);
					if (var50 != null && var50.type == 0) {
						if (var16 > var50.scrollHeight - var50.height) {
							var16 = var50.scrollHeight - var50.height;
						}

						if (var16 < 0) {
							var16 = 0;
						}

						if (var16 != var50.scrollY) {
							var50.scrollY = var16;
							ItemContainer.invalidateWidget(var50);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2190 == var1.serverPacket) {
					GrandExchangeOfferTotalQuantityComparator.readReflectionCheck(var3, var1.serverPacketLength);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2118 == var1.serverPacket) {
					var16 = var3.method5564();
					ScriptFrame.method1242(var16);
					changedItemContainers[++field869 - 1 & 31] = var16 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2120 == var1.serverPacket) {
					GrandExchangeOffer.updateNpcs(true, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2122 == var1.serverPacket) {
					var16 = var3.readInt();
					var5 = var3.readInt();
					var6 = RouteStrategy.getGcDuration();
					PacketBufferNode var46 = FaceNormal.getPacketBufferNode(ClientPacket.field2218, packetWriter.isaacCipher);
					var46.packetBuffer.writeShortLE(var16);
					var46.packetBuffer.method5617(var5);
					var46.packetBuffer.method5727(GameShell.fps);
					var46.packetBuffer.method5727(var6);
					packetWriter.addNode(var46);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2138 == var1.serverPacket) {
					Projectile.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
					FontName.FriendSystem_invalidateIgnoreds();
					field873 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2174 == var1.serverPacket) {
					class4.updatePlayers(var3, var1.serverPacketLength);
					Login.method2177();
					var1.serverPacket = null;
					return true;
				}

				Widget var53;
				if (ServerPacket.field2181 == var1.serverPacket) {
					var16 = var3.method5619();
					var53 = MusicPatchNode.getWidget(var16);

					for (var6 = 0; var6 < var53.itemIds.length; ++var6) {
						var53.itemIds[var6] = -1;
						var53.itemIds[var6] = 0;
					}

					ItemContainer.invalidateWidget(var53);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2201 == var1.serverPacket) {
					var16 = var3.method5564();
					if (var16 == 65535) {
						var16 = -1;
					}

					var5 = var3.method5638();
					var6 = var3.readInt();
					var42 = var3.method5614();
					if (var42 == 65535) {
						var42 = -1;
					}

					for (var8 = var16; var8 <= var42; ++var8) {
						var23 = (long)var8 + ((long)var5 << 32);
						Node var11 = widgetClickMasks.get(var23);
						if (var11 != null) {
							var11.remove();
						}

						widgetClickMasks.put(new IntegerNode(var6), var23);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2123 == var1.serverPacket) {
					var16 = var3.method5621();
					var53 = MusicPatchNode.getWidget(var16);
					var53.modelType = 3;
					var53.modelId = ByteArrayPool.localPlayer.appearance.getChatHeadId();
					ItemContainer.invalidateWidget(var53);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2167 == var1.serverPacket) {
					var37 = var3.readStringCp1252NullTerminated();
					Object[] var52 = new Object[var37.length() + 1];

					for (var6 = var37.length() - 1; var6 >= 0; --var6) {
						if (var37.charAt(var6) == 's') {
							var52[var6 + 1] = var3.readStringCp1252NullTerminated();
						} else {
							var52[var6 + 1] = new Integer(var3.readInt());
						}
					}

					var52[0] = new Integer(var3.readInt());
					ScriptEvent var49 = new ScriptEvent();
					var49.args = var52;
					GrandExchangeOfferOwnWorldComparator.runScriptEvent(var49);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2157 == var1.serverPacket) {
					var16 = var3.readUShortSmart();
					var39 = var3.readUnsignedByte() == 1;
					var48 = "";
					boolean var7 = false;
					if (var39) {
						var48 = var3.readStringCp1252NullTerminated();
						if (Projectile.friendSystem.isIgnored(new Username(var48, WorldMapIcon_0.loginType))) {
							var7 = true;
						}
					}

					String var55 = var3.readStringCp1252NullTerminated();
					if (!var7) {
						Skeleton.addGameMessage(var16, var48, var55);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2151 == var1.serverPacket) {
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

				if (ServerPacket.field2170 == var1.serverPacket) {
					var16 = var3.readUnsignedByte();
					if (var3.readUnsignedByte() == 0) {
						grandExchangeOffers[var16] = new GrandExchangeOffer();
						var3.offset += 18;
					} else {
						--var3.offset;
						grandExchangeOffers[var16] = new GrandExchangeOffer(var3, false);
					}

					field774 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2124 == var1.serverPacket) {
					var16 = var3.method5638();
					var5 = var3.readInt();
					InterfaceParent var18 = (InterfaceParent)interfaceParents.get((long)var5);
					var17 = (InterfaceParent)interfaceParents.get((long)var16);
					if (var17 != null) {
						class41.closeInterface(var17, var18 == null || var18.group != var17.group);
					}

					if (var18 != null) {
						var18.remove();
						interfaceParents.put(var18, (long)var16);
					}

					var28 = MusicPatchNode.getWidget(var5);
					if (var28 != null) {
						ItemContainer.invalidateWidget(var28);
					}

					var28 = MusicPatchNode.getWidget(var16);
					if (var28 != null) {
						ItemContainer.invalidateWidget(var28);
						MouseHandler.revalidateWidgetScroll(Widget.Widget_interfaceComponents[var28.id >>> 16], var28, true);
					}

					if (rootInterface != -1) {
						class198.runIntfCloseListeners(rootInterface, 1);
					}

					var1.serverPacket = null;
					return true;
				}

				WorldMapDecorationType.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id * -1540694469 * 706104051 : -1) + "," + (var1.field1329 != null ? var1.field1329.id * -1540694469 * 706104051 : -1) + "," + (var1.field1339 != null ? var1.field1339.id * -1540694469 * 706104051 : -1) + "," + var1.serverPacketLength, (Throwable)null);
				Huffman.logOut();
			} catch (IOException var35) {
				VertexNormal.method3093();
			} catch (Exception var36) {
				var27 = "" + (var1.serverPacket != null ? var1.serverPacket.id * -1540694469 * 706104051 : -1) + "," + (var1.field1329 != null ? var1.field1329.id * -1540694469 * 706104051 : -1) + "," + (var1.field1339 != null ? var1.field1339.id * -1540694469 * 706104051 : -1) + "," + var1.serverPacketLength + "," + (ByteArrayPool.localPlayer.pathX[0] + class69.baseX) + "," + (ByteArrayPool.localPlayer.pathY[0] + class89.baseY) + ",";

				for (var6 = 0; var6 < var1.serverPacketLength && var6 < 50; ++var6) {
					var27 = var27 + var3.array[var6] + ",";
				}

				WorldMapDecorationType.RunException_sendStackTrace(var27, var36);
				Huffman.logOut();
			}

			return true;
		}
	}

	@ObfuscatedName("ho")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "93"
	)
	@Export("menu")
	final void menu() {
		class69.method1275();
		if (class236.dragInventoryWidget == null) {
			if (clickedWidget == null) {
				int var2;
				int var4;
				int var5;
				int var9;
				int var10;
				label303: {
					int var1 = MouseHandler.MouseHandler_lastButton;
					int var3;
					int var6;
					int var8;
					if (isMenuOpen) {
						int var19;
						if (var1 != 1 && (class217.mouseCam || var1 != 4)) {
							var2 = MouseHandler.MouseHandler_x;
							var3 = MouseHandler.MouseHandler_y;
							if (var2 < WorldMapDecoration.menuX - 10 || var2 > class49.menuWidth + WorldMapDecoration.menuX + 10 || var3 < PacketBufferNode.menuY - 10 || var3 > WorldMapData_1.menuHeight + PacketBufferNode.menuY + 10) {
								isMenuOpen = false;
								var4 = WorldMapDecoration.menuX;
								var5 = PacketBufferNode.menuY;
								var6 = class49.menuWidth;
								var19 = WorldMapData_1.menuHeight;

								for (var8 = 0; var8 < rootWidgetCount; ++var8) {
									if (rootWidgetWidths[var8] + rootWidgetXs[var8] > var4 && rootWidgetXs[var8] < var6 + var4 && rootWidgetHeights[var8] + rootWidgetYs[var8] > var5 && rootWidgetYs[var8] < var19 + var5) {
										field679[var8] = true;
									}
								}
							}
						}

						if (var1 == 1 || !class217.mouseCam && var1 == 4) {
							var2 = WorldMapDecoration.menuX;
							var3 = PacketBufferNode.menuY;
							var4 = class49.menuWidth;
							var5 = MouseHandler.MouseHandler_lastPressedX;
							var6 = MouseHandler.MouseHandler_lastPressedY;
							var19 = -1;

							for (var8 = 0; var8 < menuOptionsCount; ++var8) {
								var9 = var3 + (menuOptionsCount - 1 - var8) * 15 + 31;
								if (var5 > var2 && var5 < var4 + var2 && var6 > var9 - 13 && var6 < var9 + 3) {
									var19 = var8;
								}
							}

							int var11;
							if (var19 != -1 && var19 >= 0) {
								var8 = menuArguments1[var19];
								var9 = menuArguments2[var19];
								var10 = menuOpcodes[var19];
								var11 = menuIdentifiers[var19];
								String var18 = menuActions[var19];
								String var13 = menuTargets[var19];
								AbstractByteArrayCopier.menuAction(var8, var9, var10, var11, var18, var13, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
							}

							isMenuOpen = false;
							var8 = WorldMapDecoration.menuX;
							var9 = PacketBufferNode.menuY;
							var10 = class49.menuWidth;
							var11 = WorldMapData_1.menuHeight;

							for (int var12 = 0; var12 < rootWidgetCount; ++var12) {
								if (rootWidgetWidths[var12] + rootWidgetXs[var12] > var8 && rootWidgetXs[var12] < var8 + var10 && rootWidgetHeights[var12] + rootWidgetYs[var12] > var9 && rootWidgetYs[var12] < var11 + var9) {
									field679[var12] = true;
								}
							}
						}
					} else {
						var2 = AbstractWorldMapData.method381();
						if ((var1 == 1 || !class217.mouseCam && var1 == 4) && var2 >= 0) {
							var3 = menuOpcodes[var2];
							if (var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
								var4 = menuArguments1[var2];
								var5 = menuArguments2[var2];
								Widget var14 = MusicPatchNode.getWidget(var5);
								var8 = ScriptEvent.getWidgetClickMask(var14);
								boolean var7 = (var8 >> 28 & 1) != 0;
								if (var7) {
									break label303;
								}

								Object var10000 = null;
								if (MilliClock.method3560(ScriptEvent.getWidgetClickMask(var14))) {
									break label303;
								}
							}
						}

						if ((var1 == 1 || !class217.mouseCam && var1 == 4) && this.shouldLeftClickOpenMenu()) {
							var1 = 2;
						}

						if ((var1 == 1 || !class217.mouseCam && var1 == 4) && menuOptionsCount > 0 && var2 >= 0) {
							var3 = menuArguments1[var2];
							var4 = menuArguments2[var2];
							var5 = menuOpcodes[var2];
							var6 = menuIdentifiers[var2];
							String var16 = menuActions[var2];
							String var17 = menuTargets[var2];
							AbstractByteArrayCopier.menuAction(var3, var4, var5, var6, var16, var17, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
						}

						if (var1 == 2 && menuOptionsCount > 0) {
							this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
						}
					}

					return;
				}

				if (class236.dragInventoryWidget != null && !field887 && menuOptionsCount > 0 && !this.shouldLeftClickOpenMenu()) {
					var9 = draggedWidgetX;
					var10 = draggedWidgetY;
					MenuAction var15 = AbstractWorldMapIcon.tempMenuAction;
					AbstractByteArrayCopier.menuAction(var15.param0, var15.param1, var15.opcode, var15.identifier, var15.action, var15.action, var9, var10);
					AbstractWorldMapIcon.tempMenuAction = null;
				}

				field887 = false;
				itemDragDuration = 0;
				if (class236.dragInventoryWidget != null) {
					ItemContainer.invalidateWidget(class236.dragInventoryWidget);
				}

				class236.dragInventoryWidget = MusicPatchNode.getWidget(var5);
				dragItemSlotSource = var4;
				draggedWidgetX = MouseHandler.MouseHandler_lastPressedX;
				draggedWidgetY = MouseHandler.MouseHandler_lastPressedY;
				if (var2 >= 0) {
					AbstractWorldMapIcon.tempMenuAction = new MenuAction();
					AbstractWorldMapIcon.tempMenuAction.param0 = menuArguments1[var2];
					AbstractWorldMapIcon.tempMenuAction.param1 = menuArguments2[var2];
					AbstractWorldMapIcon.tempMenuAction.opcode = menuOpcodes[var2];
					AbstractWorldMapIcon.tempMenuAction.identifier = menuIdentifiers[var2];
					AbstractWorldMapIcon.tempMenuAction.action = menuActions[var2];
				}

				ItemContainer.invalidateWidget(class236.dragInventoryWidget);
			}
		}
	}

	@ObfuscatedName("hr")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1329547181"
	)
	@Export("shouldLeftClickOpenMenu")
	final boolean shouldLeftClickOpenMenu() {
		int var1 = AbstractWorldMapData.method381();
		return (leftClickOpensMenu == 1 && menuOptionsCount > 2 || class9.method121(var1)) && !menuShiftClick[var1];
	}

	@ObfuscatedName("hv")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1654431956"
	)
	@Export("openMenu")
	final void openMenu(int var1, int var2) {
		MusicPatchNode.method3922(var1, var2);
		GrandExchangeOfferWorldComparator.scene.menuOpen(ScriptEvent.Client_plane, var1, var2, false);
		isMenuOpen = true;
	}

	@ObfuscatedName("ib")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "0"
	)
	@Export("resizeRoot")
	final void resizeRoot(boolean var1) {
		int var2 = rootInterface;
		int var3 = WorldMapLabel.canvasWidth;
		int var4 = Varps.canvasHeight;
		if (LoginScreenAnimation.loadInterface(var2)) {
			InterfaceParent.resizeInterface(Widget.Widget_interfaceComponents[var2], -1, var3, var4, var1);
		}

	}

	@ObfuscatedName("id")
	@ObfuscatedSignature(
		signature = "(Lhe;I)V",
		garbageValue = "-159825150"
	)
	@Export("alignWidget")
	void alignWidget(Widget var1) {
		Widget var2 = var1.parentId == -1 ? null : MusicPatchNode.getWidget(var1.parentId);
		int var3;
		int var4;
		if (var2 == null) {
			var3 = WorldMapLabel.canvasWidth;
			var4 = Varps.canvasHeight;
		} else {
			var3 = var2.width;
			var4 = var2.height;
		}

		WorldMapAreaData.alignWidgetSize(var1, var3, var4, false);
		WorldMapLabelSize.alignWidgetPosition(var1, var3, var4);
	}

	@ObfuscatedName("jz")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "22074"
	)
	final void method1420() {
		ItemContainer.invalidateWidget(clickedWidget);
		++MilliClock.widgetDragDuration;
		if (field861 && field732) {
			int var1 = MouseHandler.MouseHandler_x;
			int var2 = MouseHandler.MouseHandler_y;
			var1 -= widgetClickX;
			var2 -= widgetClickY;
			if (var1 < field859) {
				var1 = field859;
			}

			if (var1 + clickedWidget.width > field859 + clickedWidgetParent.width) {
				var1 = field859 + clickedWidgetParent.width - clickedWidget.width;
			}

			if (var2 < field881) {
				var2 = field881;
			}

			if (var2 + clickedWidget.height > field881 + clickedWidgetParent.height) {
				var2 = field881 + clickedWidgetParent.height - clickedWidget.height;
			}

			int var3 = var1 - field834;
			int var4 = var2 - field863;
			int var5 = clickedWidget.dragZoneSize;
			if (MilliClock.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
				isDraggingWidget = true;
			}

			int var6 = var1 - field859 + clickedWidgetParent.scrollX;
			int var7 = var2 - field881 + clickedWidgetParent.scrollY;
			ScriptEvent var8;
			if (clickedWidget.onDrag != null && isDraggingWidget) {
				var8 = new ScriptEvent();
				var8.widget = clickedWidget;
				var8.mouseX = var6;
				var8.mouseY = var7;
				var8.args = clickedWidget.onDrag;
				GrandExchangeOfferOwnWorldComparator.runScriptEvent(var8);
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
						GrandExchangeOfferOwnWorldComparator.runScriptEvent(var8);
					}

					if (draggedOnWidget != null && GrandExchangeOfferTotalQuantityComparator.method181(clickedWidget) != null) {
						PacketBufferNode var12 = FaceNormal.getPacketBufferNode(ClientPacket.field2234, packetWriter.isaacCipher);
						var12.packetBuffer.method5617(draggedOnWidget.id);
						var12.packetBuffer.method5610(draggedOnWidget.childIndex);
						var12.packetBuffer.writeShortLE(clickedWidget.id);
						var12.packetBuffer.method5609(draggedOnWidget.itemId);
						var12.packetBuffer.method5609(clickedWidget.childIndex);
						var12.packetBuffer.method5609(clickedWidget.itemId);
						packetWriter.addNode(var12);
					}
				} else if (this.shouldLeftClickOpenMenu()) {
					this.openMenu(field834 + widgetClickX, widgetClickY + field863);
				} else if (menuOptionsCount > 0) {
					int var11 = field834 + widgetClickX;
					int var9 = widgetClickY + field863;
					MenuAction var10 = AbstractWorldMapIcon.tempMenuAction;
					AbstractByteArrayCopier.menuAction(var10.param0, var10.param1, var10.opcode, var10.identifier, var10.action, var10.action, var11, var9);
					AbstractWorldMapIcon.tempMenuAction = null;
				}

				clickedWidget = null;
			}

		} else {
			if (MilliClock.widgetDragDuration > 1) {
				clickedWidget = null;
			}

		}
	}

	@ObfuscatedName("kd")
	@ObfuscatedSignature(
		signature = "(I)Lku;",
		garbageValue = "-1860083598"
	)
	@Export("username")
	public Username username() {
		return ByteArrayPool.localPlayer != null ? ByteArrayPool.localPlayer.username : null;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "11"
	)
	public static void method1496() {
		class206.midiPcmStream.clear();
		class206.field2406 = 1;
		class206.musicTrackArchive = null;
	}
}
