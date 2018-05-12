import java.io.File;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;
import netscape.javascript.JSObject;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine implements class288 {
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = 1138307549
   )
   static int field794;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = 407114703
   )
   @Export("widgetCount")
   static int widgetCount;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      longValue = -3613177442534620995L
   )
   static long field803;
   @ObfuscatedName("ng")
   static boolean[] field795;
   @ObfuscatedName("no")
   static boolean[] field796;
   @ObfuscatedName("lo")
   static boolean field860;
   @ObfuscatedName("nt")
   static boolean[] field797;
   @ObfuscatedName("lx")
   static boolean field594;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = 1972730241
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("nh")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("rq")
   @ObfuscatedGetter(
      intValue = -2002454031
   )
   public static int field859;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 262646585
   )
   static int field742;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -1540398517
   )
   static int field685;
   @ObfuscatedName("ob")
   static boolean field825;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = 1707398523
   )
   static int field766;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = -1507973779
   )
   static int field769;
   @ObfuscatedName("li")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   static Widget field639;
   @ObfuscatedName("mg")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = -1824637655
   )
   static int field770;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = -1600961027
   )
   @Export("gameDrawingMode")
   static int gameDrawingMode;
   @ObfuscatedName("nk")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("ny")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("nj")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("ni")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 643992545
   )
   static int field772;
   @ObfuscatedName("rh")
   @ObfuscatedSignature(
      signature = "Lbp;"
   )
   static final class59 field862;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = -2077809937
   )
   static int field773;
   @ObfuscatedName("mv")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   static Deque field755;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = 984149875
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = -435908989
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = -959354801
   )
   static int field827;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = -325961783
   )
   static int field824;
   @ObfuscatedName("ld")
   @Export("draggingWidget")
   static boolean draggingWidget;
   @ObfuscatedName("rw")
   static int[] field680;
   @ObfuscatedName("rr")
   static int[] field864;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = 1982191767
   )
   static int field787;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = -515631991
   )
   @Export("mouseWheelRotation")
   static int mouseWheelRotation;
   @ObfuscatedName("qf")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   static PlayerComposition field853;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = -203632127
   )
   static int field815;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = -339483745
   )
   static int field783;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = 677998663
   )
   @Export("queuedSoundEffectCount")
   static int queuedSoundEffectCount;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      longValue = 946796608594445303L
   )
   static long field782;
   @ObfuscatedName("pg")
   @Export("unknownSoundValues2")
   static int[] unknownSoundValues2;
   @ObfuscatedName("lm")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   @Export("draggedOnWidget")
   static Widget draggedOnWidget;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = -886071063
   )
   static int field854;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = 295871775
   )
   static int field693;
   @ObfuscatedName("px")
   @Export("queuedSoundEffectIDs")
   static int[] queuedSoundEffectIDs;
   @ObfuscatedName("ps")
   @ObfuscatedSignature(
      signature = "[Lcm;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("pc")
   @Export("unknownSoundValues1")
   static int[] unknownSoundValues1;
   @ObfuscatedName("rm")
   static ArrayList field786;
   @ObfuscatedName("pj")
   @Export("soundLocations")
   static int[] soundLocations;
   @ObfuscatedName("ri")
   @ObfuscatedGetter(
      intValue = 1969421345
   )
   static int field861;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = -40748619
   )
   static int field768;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = -965218169
   )
   static int field651;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = 1511918615
   )
   static int field822;
   @ObfuscatedName("pu")
   static boolean field746;
   @ObfuscatedName("ou")
   @ObfuscatedSignature(
      signature = "[Llc;"
   )
   @Export("mapIcons")
   static SpritePixels[] mapIcons;
   @ObfuscatedName("pm")
   static boolean[] field835;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = 1793551831
   )
   static int field845;
   @ObfuscatedName("ol")
   static int[] field817;
   @ObfuscatedName("ox")
   static int[] field818;
   @ObfuscatedName("ne")
   static long[] field809;
   @ObfuscatedName("mu")
   @Export("pendingVarbitChanges")
   static int[] pendingVarbitChanges;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = -1145521621
   )
   @Export("pendingVarbitCount")
   static int pendingVarbitCount;
   @ObfuscatedName("mj")
   @Export("changedSkills")
   static int[] changedSkills;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = -803677707
   )
   @Export("changedSkillsCount")
   static int changedSkillsCount;
   @ObfuscatedName("qk")
   @ObfuscatedSignature(
      signature = "[Lf;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("op")
   static int[] field865;
   @ObfuscatedName("oa")
   static int[] field812;
   @ObfuscatedName("mk")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   static Deque field790;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = 1313846965
   )
   static int field785;
   @ObfuscatedName("mo")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   static Deque field791;
   @ObfuscatedName("qx")
   static short field745;
   @ObfuscatedName("qo")
   static short field841;
   @ObfuscatedName("qs")
   static short field707;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = -1739119885
   )
   static int field830;
   @ObfuscatedName("qu")
   static short field847;
   @ObfuscatedName("qh")
   static short field863;
   @ObfuscatedName("qn")
   static short field842;
   @ObfuscatedName("qg")
   static short field615;
   @ObfuscatedName("qw")
   static short field844;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = -1908896211
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = 497477697
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = 2021298749
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("mw")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = -323698453
   )
   static int field779;
   @ObfuscatedName("qd")
   static int[] field836;
   @ObfuscatedName("qe")
   static int[] field837;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 49894369
   )
   @Export("Viewport_xOffset")
   static int Viewport_xOffset;
   @ObfuscatedName("qb")
   static int[] field855;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -988965039
   )
   @Export("Viewport_yOffset")
   static int Viewport_yOffset;
   @ObfuscatedName("qq")
   static int[] field765;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = 2107658287
   )
   static int field789;
   @ObfuscatedName("ml")
   @ObfuscatedGetter(
      intValue = -697326019
   )
   static int field784;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      longValue = -3347505195473162029L
   )
   static long field629;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = -1207459131
   )
   @Export("chatCycle")
   static int chatCycle;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = 1083573095
   )
   @Export("publicChatMode")
   static int publicChatMode;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = -1430428523
   )
   static int field694;
   @ObfuscatedName("nr")
   static String field808;
   @ObfuscatedName("ro")
   @ObfuscatedSignature(
      signature = "Lby;"
   )
   static OwnWorldComparator field738;
   @ObfuscatedName("nx")
   static int[] field805;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfm;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("ak")
   static boolean field780;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -710150299
   )
   @Export("world")
   public static int world;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1608100377
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -115045799
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("bn")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("bp")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 754340933
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1885967903
   )
   static int field600;
   @ObfuscatedName("bb")
   static boolean field601;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -484975941
   )
   @Export("gameState")
   static int gameState;
   @ObfuscatedName("bm")
   static boolean field603;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1918380857
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      longValue = 3560253004301321173L
   )
   @Export("mouseLastLastPressedTimeMillis")
   static long mouseLastLastPressedTimeMillis;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 1779935029
   )
   static int field606;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1359116679
   )
   static int field607;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -2132488129
   )
   static int field608;
   @ObfuscatedName("bh")
   static boolean field609;
   @ObfuscatedName("bd")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 1327371833
   )
   static int field643;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 203988051
   )
   @Export("hintArrowTargetType")
   static int hintArrowTargetType;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1508240615
   )
   @Export("hintArrowNpcTargetIdx")
   static int hintArrowNpcTargetIdx;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -399373815
   )
   @Export("hintArrowPlayerTargetIdx")
   static int hintArrowPlayerTargetIdx;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 1804776069
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 889927571
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 712082861
   )
   @Export("hintArrowOffsetZ")
   static int hintArrowOffsetZ;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1269048349
   )
   @Export("hintArrowOffsetX")
   static int hintArrowOffsetX;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 953423233
   )
   @Export("hintArrowOffsetY")
   static int hintArrowOffsetY;
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Lbq;"
   )
   @Export("playerAttackOption")
   static AttackOption playerAttackOption;
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Lbq;"
   )
   @Export("npcAttackOption")
   static AttackOption npcAttackOption;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 243111015
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "Lft;"
   )
   @Export("rssocket")
   static class157 rssocket;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 2051008151
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 104390289
   )
   static int field625;
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = 1331640199
   )
   static int field595;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = 1491451481
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = -915676447
   )
   static int field645;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -1837898575
   )
   static int field630;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 821087251
   )
   static int field631;
   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   static class146 field716;
   @ObfuscatedName("di")
   static byte[] field718;
   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "[Lba;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = 1773144939
   )
   @Export("npcIndexesCount")
   static int npcIndexesCount;
   @ObfuscatedName("dy")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -1982880171
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("ey")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   public static final NetWriter field739;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 2130447299
   )
   static int field688;
   @ObfuscatedName("ej")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("ek")
   static boolean field642;
   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "Ljg;"
   )
   static class280 field840;
   @ObfuscatedName("eq")
   @Export("fontsMap")
   static HashMap fontsMap;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = 1228257375
   )
   static int field792;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -503470903
   )
   static int field697;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 2077564129
   )
   static int field647;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -1517576733
   )
   static int field648;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -1232805537
   )
   static int field649;
   @ObfuscatedName("fm")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("fs")
   @Export("instanceTemplateChunks")
   static int[][][] instanceTemplateChunks;
   @ObfuscatedName("fu")
   static final int[] field653;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -986662313
   )
   static int field654;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 320333465
   )
   static int field655;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -246881979
   )
   static int field656;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -1775701985
   )
   static int field731;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -1671328597
   )
   static int field658;
   @ObfuscatedName("go")
   static boolean field659;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -1614406899
   )
   static int field736;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -1719678355
   )
   @Export("cameraPitchTarget")
   static int cameraPitchTarget;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -1296134745
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 793553735
   )
   static int field663;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -965597961
   )
   static int field767;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1124685859
   )
   static int field717;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -1416610753
   )
   static int field627;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 180462143
   )
   static int field678;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -1261710225
   )
   static int field668;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 1990466531
   )
   static int field857;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 1922379337
   )
   static int field602;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 402885239
   )
   static int field804;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 765440817
   )
   static int field671;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = -1491520915
   )
   static int field672;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = -742284777
   )
   static int field673;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = -656834559
   )
   static int field674;
   @ObfuscatedName("hd")
   static boolean field622;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 669004171
   )
   static int field801;
   @ObfuscatedName("hx")
   static boolean field677;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = 1641588965
   )
   static int field723;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -1356328419
   )
   @Export("overheadTextCount")
   static int overheadTextCount;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = -572241541
   )
   static int field634;
   @ObfuscatedName("ho")
   @Export("overheadTextsX")
   static int[] overheadTextsX;
   @ObfuscatedName("hy")
   @Export("overheadTextsY")
   static int[] overheadTextsY;
   @ObfuscatedName("hk")
   @Export("overheadTextsOffsetY")
   static int[] overheadTextsOffsetY;
   @ObfuscatedName("ht")
   @Export("overheadTextsOffsetX")
   static int[] overheadTextsOffsetX;
   @ObfuscatedName("hg")
   static int[] field811;
   @ObfuscatedName("hc")
   static int[] field686;
   @ObfuscatedName("hr")
   @Export("overheadTextsCyclesRemaining")
   static int[] overheadTextsCyclesRemaining;
   @ObfuscatedName("ha")
   @Export("overheadTexts")
   static String[] overheadTexts;
   @ObfuscatedName("hh")
   static int[][] field689;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -1565760405
   )
   static int field690;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = -1677083163
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = 1627957251
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = -226851279
   )
   @Export("lastLeftClickX")
   static int lastLeftClickX;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = 1284462679
   )
   @Export("lastLeftClickY")
   static int lastLeftClickY;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 1347177379
   )
   static int field843;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = 671072709
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("ii")
   static boolean field664;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -1396378137
   )
   @Export("mouseCrosshair")
   static int mouseCrosshair;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = -1957595085
   )
   @Export("pressedItemIndex")
   static int pressedItemIndex;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = 647517325
   )
   static int field597;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = -46582737
   )
   static int field701;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 1417109621
   )
   static int field640;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = -244588269
   )
   static int field703;
   @ObfuscatedName("iu")
   static boolean field704;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = 1496315097
   )
   @Export("itemPressedDuration")
   static int itemPressedDuration;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = 636102247
   )
   @Export("myPlayerIndex")
   static int myPlayerIndex;
   @ObfuscatedName("ic")
   static boolean field715;
   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "[Lbu;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("it")
   @Export("lastSelectedItemName")
   static String lastSelectedItemName;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = -1539952365
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = 965633939
   )
   static int field710;
   @ObfuscatedName("ie")
   static boolean field711;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = -997447881
   )
   @Export("playerNameMask")
   static int playerNameMask;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 1728578221
   )
   static int field713;
   @ObfuscatedName("je")
   static int[] field714;
   @ObfuscatedName("jq")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("jp")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("jm")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("ja")
   static int[] field665;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = -1425437183
   )
   static int field719;
   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "[[[Lgz;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("jt")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("jo")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("jd")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = -451068837
   )
   static int field727;
   @ObfuscatedName("jg")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -183492423
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("kd")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("ki")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("ke")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("kn")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("km")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("kf")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("kb")
   @Export("menuBooleanArray")
   static boolean[] menuBooleanArray;
   @ObfuscatedName("ks")
   static boolean field753;
   @ObfuscatedName("kl")
   static boolean field733;
   @ObfuscatedName("kg")
   static boolean field669;
   @ObfuscatedName("kr")
   static boolean field740;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = -1178031123
   )
   static int field741;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = -1506962549
   )
   static int field667;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -2006294019
   )
   static int field747;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -1041050541
   )
   static int field744;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 2138266691
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("kz")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = -679563285
   )
   static int field748;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = -1328628203
   )
   static int field749;
   @ObfuscatedName("lg")
   static String field750;
   @ObfuscatedName("lw")
   static String field751;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = -707126749
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("ly")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -1826783613
   )
   static int field754;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 1960487621
   )
   static int field814;
   @ObfuscatedName("lr")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   static Widget field756;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = 233674625
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = -1417367467
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = 611657069
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = 71333287
   )
   static int field760;
   @ObfuscatedName("ll")
   static boolean field761;
   @ObfuscatedName("lp")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   static Widget field776;
   @ObfuscatedName("lk")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   @Export("draggedWidget")
   static Widget draggedWidget;

   static {
      field780 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      field600 = -1;
      field601 = false;
      gameState = 0;
      field603 = true;
      gameCycle = 0;
      mouseLastLastPressedTimeMillis = 1L;
      field606 = -1;
      field607 = -1;
      field608 = -1;
      field609 = true;
      displayFps = false;
      field643 = 0;
      hintArrowTargetType = 0;
      hintArrowNpcTargetIdx = 0;
      hintArrowPlayerTargetIdx = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowOffsetZ = 0;
      hintArrowOffsetX = 0;
      hintArrowOffsetY = 0;
      playerAttackOption = AttackOption.AttackOption_hidden;
      npcAttackOption = AttackOption.AttackOption_hidden;
      loadingStage = 0;
      js5State = 0;
      field625 = 0;
      field595 = 0;
      loginState = 0;
      field645 = 0;
      field630 = 0;
      field631 = 0;
      field716 = class146.field1929;
      field718 = null;
      cachedNPCs = new NPC['耀'];
      npcIndexesCount = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      field739 = new NetWriter();
      field688 = 0;
      socketError = false;
      field642 = true;
      field840 = new class280();
      fontsMap = new HashMap();
      field792 = 0;
      field697 = 1;
      field647 = 0;
      field648 = 1;
      field649 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      instanceTemplateChunks = new int[4][13][13];
      field653 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field654 = 0;
      field655 = 2301979;
      field656 = 5063219;
      field731 = 3353893;
      field658 = 7759444;
      field659 = false;
      field736 = 0;
      cameraPitchTarget = 128;
      mapAngle = 0;
      field663 = 0;
      field767 = 0;
      field717 = 0;
      field627 = 0;
      field678 = 0;
      field668 = 50;
      field602 = 0;
      field804 = 0;
      field671 = 0;
      field672 = 12;
      field673 = 6;
      field674 = 0;
      field622 = false;
      field801 = 0;
      field677 = false;
      field723 = 0;
      overheadTextCount = 0;
      field634 = 50;
      overheadTextsX = new int[field634];
      overheadTextsY = new int[field634];
      overheadTextsOffsetY = new int[field634];
      overheadTextsOffsetX = new int[field634];
      field811 = new int[field634];
      field686 = new int[field634];
      overheadTextsCyclesRemaining = new int[field634];
      overheadTexts = new String[field634];
      field689 = new int[104][104];
      field690 = 0;
      screenX = -1;
      screenY = -1;
      lastLeftClickX = 0;
      lastLeftClickY = 0;
      field843 = 0;
      cursorState = 0;
      field664 = true;
      mouseCrosshair = 0;
      pressedItemIndex = 0;
      field597 = 0;
      field701 = 0;
      field640 = 0;
      field703 = 0;
      field704 = false;
      itemPressedDuration = 0;
      myPlayerIndex = 0;
      field715 = true;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field710 = 0;
      field711 = true;
      playerNameMask = 0;
      field713 = 0;
      field714 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field665 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field719 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field727 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      menuBooleanArray = new boolean[500];
      field753 = false;
      field733 = false;
      field669 = false;
      field740 = true;
      field741 = -1;
      field667 = -1;
      field747 = 0;
      field744 = 50;
      itemSelectionState = 0;
      lastSelectedItemName = null;
      spellSelected = false;
      field748 = -1;
      field749 = -1;
      field750 = null;
      field751 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field754 = 0;
      field814 = 0;
      field756 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field760 = -1;
      field761 = false;
      field776 = null;
      draggedWidget = null;
      field639 = null;
      field685 = 0;
      field766 = 0;
      draggedOnWidget = null;
      field594 = false;
      field769 = -1;
      field770 = -1;
      field860 = false;
      field772 = -1;
      field773 = -1;
      draggingWidget = false;
      cycleCntr = 1;
      pendingVarbitChanges = new int[32];
      pendingVarbitCount = 0;
      interfaceItemTriggers = new int[32];
      field779 = 0;
      changedSkills = new int[32];
      changedSkillsCount = 0;
      chatCycle = 0;
      field742 = 0;
      field784 = 0;
      field785 = 0;
      field789 = 0;
      field787 = 0;
      mouseWheelRotation = 0;
      field755 = new Deque();
      field790 = new Deque();
      field791 = new Deque();
      widgetFlags = new HashTable(512);
      widgetCount = 0;
      field794 = -2;
      field795 = new boolean[100];
      field796 = new boolean[100];
      field797 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field803 = 0L;
      isResized = true;
      field805 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      publicChatMode = 0;
      field694 = 0;
      field808 = "";
      field809 = new long[100];
      field830 = 0;
      field845 = 0;
      field812 = new int[128];
      field865 = new int[128];
      field782 = -1L;
      field815 = -1;
      field651 = 0;
      field817 = new int[1000];
      field818 = new int[1000];
      mapIcons = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field822 = 0;
      field693 = 255;
      field824 = -1;
      field825 = false;
      field768 = 127;
      field827 = 127;
      queuedSoundEffectCount = 0;
      queuedSoundEffectIDs = new int[50];
      unknownSoundValues1 = new int[50];
      unknownSoundValues2 = new int[50];
      soundLocations = new int[50];
      audioEffects = new SoundEffect[50];
      field746 = false;
      field835 = new boolean[5];
      field836 = new int[5];
      field837 = new int[5];
      field855 = new int[5];
      field765 = new int[5];
      field745 = 256;
      field841 = 205;
      field842 = 256;
      field615 = 320;
      field844 = 1;
      field863 = 32767;
      field707 = 1;
      field847 = 32767;
      Viewport_xOffset = 0;
      Viewport_yOffset = 0;
      viewportWidth = 0;
      viewportHeight = 0;
      scale = 0;
      field853 = new PlayerComposition();
      field783 = -1;
      field854 = -1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field738 = new OwnWorldComparator();
      field859 = -1;
      field786 = new ArrayList(10);
      field861 = 0;
      field862 = new class59();
      field680 = new int[50];
      field864 = new int[50];
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected final void vmethod1203() {
      field803 = class166.method3456() + 500L;
      this.method1465();
      if(widgetRoot != -1) {
         this.method1210(true);
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-81564058"
   )
   @Export("setUp")
   protected final void setUp() {
      SceneTilePaint.method2897(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
      ServerPacket.port1 = socketType == 0?43594:world + 40000;
      class13.port2 = socketType == 0?443:world + 50000;
      Size.myWorldPort = ServerPacket.port1;
      MapIconReference.colorsToFind = class228.field2602;
      class185.colorsToReplace = class228.field2599;
      MilliTimer.field1947 = class228.field2600;
      class76.field1091 = class228.field2601;
      class59.urlRequester = new UrlRequester();
      this.setUpKeyboard();
      this.setUpMouse();
      class173.mouseWheel = this.mouseWheel();
      World.indexStore255 = new IndexFile(255, class155.dat2File, class155.idx255File, 500000);
      FileOnDisk var2 = null;
      Preferences var3 = new Preferences();

      try {
         var2 = class240.getPreferencesFile("", LoginPacket.field2265.name, false);
         byte[] var4 = new byte[(int)var2.length()];

         int var6;
         for(int var5 = 0; var5 < var4.length; var5 += var6) {
            var6 = var2.read(var4, var5, var4.length - var5);
            if(var6 == -1) {
               throw new IOException();
            }
         }

         var3 = new Preferences(new Buffer(var4));
      } catch (Exception var8) {
         ;
      }

      try {
         if(var2 != null) {
            var2.close();
         }
      } catch (Exception var7) {
         ;
      }

      ScriptState.preferences = var3;
      this.setUpClipboard();
      String var9 = GroundObject.field1555;
      class45.field374 = this;
      if(var9 != null) {
         class45.field368 = var9;
      }

      if(socketType != 0) {
         displayFps = true;
      }

      class171.method3470(ScriptState.preferences.screenType);
      CacheFile.friendManager = new FriendManager(WorldMapDecoration.loginType);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1245920510"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();

      while(true) {
         Deque var2 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         FileSystem var1;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            var1 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_responseQueue.popFront();
         }

         if(var1 == null) {
            class177.method3530();
            Varbit.method4951();
            KeyFocusListener var64 = KeyFocusListener.keyboard;
            int var43;
            synchronized(KeyFocusListener.keyboard) {
               ++KeyFocusListener.keyboardIdleTicks;
               KeyFocusListener.field342 = KeyFocusListener.field348;
               KeyFocusListener.field347 = 0;
               if(KeyFocusListener.field349 >= 0) {
                  while(KeyFocusListener.field343 != KeyFocusListener.field349) {
                     var43 = KeyFocusListener.field341[KeyFocusListener.field343];
                     KeyFocusListener.field343 = KeyFocusListener.field343 + 1 & 127;
                     if(var43 < 0) {
                        KeyFocusListener.keyPressed[~var43] = false;
                     } else {
                        if(!KeyFocusListener.keyPressed[var43] && KeyFocusListener.field347 < KeyFocusListener.field346.length - 1) {
                           KeyFocusListener.field346[++KeyFocusListener.field347 - 1] = var43;
                        }

                        KeyFocusListener.keyPressed[var43] = true;
                     }
                  }
               } else {
                  for(var43 = 0; var43 < 112; ++var43) {
                     KeyFocusListener.keyPressed[var43] = false;
                  }

                  KeyFocusListener.field349 = KeyFocusListener.field343;
               }

               if(KeyFocusListener.field347 > 0) {
                  KeyFocusListener.keyboardIdleTicks = 0;
               }

               KeyFocusListener.field348 = KeyFocusListener.field355;
            }

            MouseInput var65 = MouseInput.mouse;
            synchronized(MouseInput.mouse) {
               MouseInput.mouseCurrentButton = MouseInput.MouseHandler_currentButton;
               MouseInput.mouseLastX = MouseInput.mouseX;
               MouseInput.mouseLastY = MouseInput.mouseY;
               MouseInput.mouseLastButton = MouseInput.MouseHandler_lastButton;
               MouseInput.mouseLastPressedX = MouseInput.MouseHandler_lastPressedX;
               MouseInput.mouseLastPressedY = MouseInput.MouseHandler_lastPressedY;
               MouseInput.mouseLastPressedTimeMillis = MouseInput.MouseHandler_lastPressedTimeMillis;
               MouseInput.MouseHandler_lastButton = 0;
            }

            if(class173.mouseWheel != null) {
               int var44 = class173.mouseWheel.useRotation();
               mouseWheelRotation = var44;
            }

            if(gameState == 0) {
               GameCanvas.load();
               FileOnDisk.method2579();
            } else if(gameState == 5) {
               class45.method819(this);
               GameCanvas.load();
               FileOnDisk.method2579();
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  class45.method819(this);
                  this.method1201();
               } else if(gameState == 25) {
                  ItemContainer.flush(false);
                  field792 = 0;
                  boolean var68 = true;

                  for(var43 = 0; var43 < class8.field58.length; ++var43) {
                     if(class140.landMapFileIds[var43] != -1 && class8.field58[var43] == null) {
                        class8.field58[var43] = class234.indexMaps.getConfigData(class140.landMapFileIds[var43], 0);
                        if(class8.field58[var43] == null) {
                           var68 = false;
                           ++field792;
                        }
                     }

                     if(ItemContainer.landRegionFileIds[var43] != -1 && ItemLayer.field1475[var43] == null) {
                        ItemLayer.field1475[var43] = class234.indexMaps.getConfigDataKeys(ItemContainer.landRegionFileIds[var43], 0, GameEngine.xteaKeys[var43]);
                        if(ItemLayer.field1475[var43] == null) {
                           var68 = false;
                           ++field792;
                        }
                     }
                  }

                  if(!var68) {
                     field649 = 1;
                  } else {
                     field647 = 0;
                     var68 = true;

                     int var45;
                     int var46;
                     for(var43 = 0; var43 < class8.field58.length; ++var43) {
                        byte[] var3 = ItemLayer.field1475[var43];
                        if(var3 != null) {
                           var45 = (OwnWorldComparator.mapRegions[var43] >> 8) * 64 - class178.baseX;
                           var46 = (OwnWorldComparator.mapRegions[var43] & 255) * 64 - CombatInfoListHolder.baseY;
                           if(isDynamicRegion) {
                              var45 = 10;
                              var46 = 10;
                           }

                           var68 &= class32.method599(var3, var45, var46);
                        }
                     }

                     if(!var68) {
                        field649 = 2;
                     } else {
                        if(field649 != 0) {
                           class16.method187("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        Varbit.method4951();
                        ScriptEvent.region.reset();

                        for(var43 = 0; var43 < 4; ++var43) {
                           collisionMaps[var43].reset();
                        }

                        int var47;
                        for(var43 = 0; var43 < 4; ++var43) {
                           for(var47 = 0; var47 < 104; ++var47) {
                              for(var45 = 0; var45 < 104; ++var45) {
                                 class50.tileSettings[var43][var47][var45] = 0;
                              }
                           }
                        }

                        Varbit.method4951();
                        class173.method3490();
                        var43 = class8.field58.length;
                        class59.method1126();
                        ItemContainer.flush(true);
                        int var7;
                        int var8;
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
                        int var49;
                        if(!isDynamicRegion) {
                           var47 = 0;

                           label753:
                           while(true) {
                              byte[] var6;
                              if(var47 >= var43) {
                                 for(var47 = 0; var47 < var43; ++var47) {
                                    var45 = (OwnWorldComparator.mapRegions[var47] >> 8) * 64 - class178.baseX;
                                    var46 = (OwnWorldComparator.mapRegions[var47] & 255) * 64 - CombatInfoListHolder.baseY;
                                    var6 = class8.field58[var47];
                                    if(var6 == null && class54.field495 < 800) {
                                       Varbit.method4951();
                                       CombatInfo1.method1601(var45, var46, 64, 64);
                                    }
                                 }

                                 ItemContainer.flush(true);
                                 var47 = 0;

                                 while(true) {
                                    if(var47 >= var43) {
                                       break label753;
                                    }

                                    byte[] var4 = ItemLayer.field1475[var47];
                                    if(var4 != null) {
                                       var46 = (OwnWorldComparator.mapRegions[var47] >> 8) * 64 - class178.baseX;
                                       var49 = (OwnWorldComparator.mapRegions[var47] & 255) * 64 - CombatInfoListHolder.baseY;
                                       Varbit.method4951();
                                       Region var50 = ScriptEvent.region;
                                       CollisionData[] var51 = collisionMaps;
                                       Buffer var67 = new Buffer(var4);
                                       var10 = -1;

                                       while(true) {
                                          var11 = var67.method3583();
                                          if(var11 == 0) {
                                             break;
                                          }

                                          var10 += var11;
                                          var12 = 0;

                                          while(true) {
                                             var13 = var67.getUSmart();
                                             if(var13 == 0) {
                                                break;
                                             }

                                             var12 += var13 - 1;
                                             var14 = var12 & 63;
                                             var15 = var12 >> 6 & 63;
                                             var16 = var12 >> 12;
                                             var17 = var67.readUnsignedByte();
                                             var18 = var17 >> 2;
                                             int var19 = var17 & 3;
                                             var20 = var15 + var46;
                                             var21 = var14 + var49;
                                             if(var20 > 0 && var21 > 0 && var20 < 103 && var21 < 103) {
                                                var22 = var16;
                                                if((class50.tileSettings[1][var20][var21] & 2) == 2) {
                                                   var22 = var16 - 1;
                                                }

                                                CollisionData var23 = null;
                                                if(var22 >= 0) {
                                                   var23 = var51[var22];
                                                }

                                                PacketBuffer.addObject(var16, var20, var21, var10, var19, var18, var50, var23);
                                             }
                                          }
                                       }
                                    }

                                    ++var47;
                                 }
                              }

                              var45 = (OwnWorldComparator.mapRegions[var47] >> 8) * 64 - class178.baseX;
                              var46 = (OwnWorldComparator.mapRegions[var47] & 255) * 64 - CombatInfoListHolder.baseY;
                              var6 = class8.field58[var47];
                              if(var6 != null) {
                                 Varbit.method4951();
                                 var7 = class11.field82 * 8 - 48;
                                 var8 = class54.field495 * 8 - 48;
                                 CollisionData[] var9 = collisionMaps;
                                 var10 = 0;

                                 label750:
                                 while(true) {
                                    if(var10 >= 4) {
                                       Buffer var48 = new Buffer(var6);
                                       var11 = 0;

                                       while(true) {
                                          if(var11 >= 4) {
                                             break label750;
                                          }

                                          for(var12 = 0; var12 < 64; ++var12) {
                                             for(var13 = 0; var13 < 64; ++var13) {
                                                SoundTaskDataProvider.loadTerrain(var48, var11, var45 + var12, var46 + var13, var7, var8, 0);
                                             }
                                          }

                                          ++var11;
                                       }
                                    }

                                    for(var11 = 0; var11 < 64; ++var11) {
                                       for(var12 = 0; var12 < 64; ++var12) {
                                          if(var11 + var45 > 0 && var11 + var45 < 103 && var12 + var46 > 0 && var12 + var46 < 103) {
                                             var9[var10].flags[var45 + var11][var12 + var46] &= -16777217;
                                          }
                                       }
                                    }

                                    ++var10;
                                 }
                              }

                              ++var47;
                           }
                        }

                        int var52;
                        if(isDynamicRegion) {
                           var47 = 0;

                           label686:
                           while(true) {
                              int var26;
                              int var28;
                              int var29;
                              int var30;
                              CollisionData[] var54;
                              Buffer var55;
                              int var56;
                              if(var47 >= 4) {
                                 for(var47 = 0; var47 < 13; ++var47) {
                                    for(var45 = 0; var45 < 13; ++var45) {
                                       var46 = instanceTemplateChunks[0][var47][var45];
                                       if(var46 == -1) {
                                          CombatInfo1.method1601(var47 * 8, var45 * 8, 8, 8);
                                       }
                                    }
                                 }

                                 ItemContainer.flush(true);
                                 var47 = 0;

                                 while(true) {
                                    if(var47 >= 4) {
                                       break label686;
                                    }

                                    Varbit.method4951();

                                    for(var45 = 0; var45 < 13; ++var45) {
                                       label575:
                                       for(var46 = 0; var46 < 13; ++var46) {
                                          var49 = instanceTemplateChunks[var47][var45][var46];
                                          if(var49 != -1) {
                                             var7 = var49 >> 24 & 3;
                                             var8 = var49 >> 1 & 3;
                                             var52 = var49 >> 14 & 1023;
                                             var10 = var49 >> 3 & 2047;
                                             var11 = (var52 / 8 << 8) + var10 / 8;

                                             for(var12 = 0; var12 < OwnWorldComparator.mapRegions.length; ++var12) {
                                                if(OwnWorldComparator.mapRegions[var12] == var11 && ItemLayer.field1475[var12] != null) {
                                                   byte[] var57 = ItemLayer.field1475[var12];
                                                   var14 = var45 * 8;
                                                   var15 = var46 * 8;
                                                   var16 = (var52 & 7) * 8;
                                                   var17 = (var10 & 7) * 8;
                                                   Region var58 = ScriptEvent.region;
                                                   var54 = collisionMaps;
                                                   var55 = new Buffer(var57);
                                                   var21 = -1;

                                                   while(true) {
                                                      var22 = var55.method3583();
                                                      if(var22 == 0) {
                                                         continue label575;
                                                      }

                                                      var21 += var22;
                                                      var56 = 0;

                                                      while(true) {
                                                         int var59 = var55.getUSmart();
                                                         if(var59 == 0) {
                                                            break;
                                                         }

                                                         var56 += var59 - 1;
                                                         int var25 = var56 & 63;
                                                         var26 = var56 >> 6 & 63;
                                                         int var27 = var56 >> 12;
                                                         var28 = var55.readUnsignedByte();
                                                         var29 = var28 >> 2;
                                                         var30 = var28 & 3;
                                                         if(var7 == var27 && var26 >= var16 && var26 < var16 + 8 && var25 >= var17 && var25 < var17 + 8) {
                                                            ObjectComposition var60 = SoundTaskDataProvider.getObjectDefinition(var21);
                                                            int var34 = var26 & 7;
                                                            int var35 = var25 & 7;
                                                            int var37 = var60.width;
                                                            int var38 = var60.length;
                                                            int var39;
                                                            if((var30 & 1) == 1) {
                                                               var39 = var37;
                                                               var37 = var38;
                                                               var38 = var39;
                                                            }

                                                            int var36 = var8 & 3;
                                                            int var33;
                                                            if(var36 == 0) {
                                                               var33 = var34;
                                                            } else if(var36 == 1) {
                                                               var33 = var35;
                                                            } else if(var36 == 2) {
                                                               var33 = 7 - var34 - (var37 - 1);
                                                            } else {
                                                               var33 = 7 - var35 - (var38 - 1);
                                                            }

                                                            var39 = var33 + var14;
                                                            int var40 = var15 + GrandExchangeOffer.method56(var26 & 7, var25 & 7, var8, var60.width, var60.length, var30);
                                                            if(var39 > 0 && var40 > 0 && var39 < 103 && var40 < 103) {
                                                               int var41 = var47;
                                                               if((class50.tileSettings[1][var39][var40] & 2) == 2) {
                                                                  var41 = var47 - 1;
                                                               }

                                                               CollisionData var42 = null;
                                                               if(var41 >= 0) {
                                                                  var42 = var54[var41];
                                                               }

                                                               PacketBuffer.addObject(var47, var39, var40, var21, var30 + var8 & 3, var29, var58, var42);
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++var47;
                                 }
                              }

                              Varbit.method4951();

                              for(var45 = 0; var45 < 13; ++var45) {
                                 for(var46 = 0; var46 < 13; ++var46) {
                                    boolean var69 = false;
                                    var7 = instanceTemplateChunks[var47][var45][var46];
                                    if(var7 != -1) {
                                       var8 = var7 >> 24 & 3;
                                       var52 = var7 >> 1 & 3;
                                       var10 = var7 >> 14 & 1023;
                                       var11 = var7 >> 3 & 2047;
                                       var12 = (var10 / 8 << 8) + var11 / 8;

                                       for(var13 = 0; var13 < OwnWorldComparator.mapRegions.length; ++var13) {
                                          if(OwnWorldComparator.mapRegions[var13] == var12 && class8.field58[var13] != null) {
                                             byte[] var53 = class8.field58[var13];
                                             var15 = var45 * 8;
                                             var16 = var46 * 8;
                                             var17 = (var10 & 7) * 8;
                                             var18 = (var11 & 7) * 8;
                                             var54 = collisionMaps;

                                             for(var20 = 0; var20 < 8; ++var20) {
                                                for(var21 = 0; var21 < 8; ++var21) {
                                                   if(var20 + var15 > 0 && var15 + var20 < 103 && var21 + var16 > 0 && var16 + var21 < 103) {
                                                      var54[var47].flags[var15 + var20][var16 + var21] &= -16777217;
                                                   }
                                                }
                                             }

                                             var55 = new Buffer(var53);

                                             for(var21 = 0; var21 < 4; ++var21) {
                                                for(var22 = 0; var22 < 64; ++var22) {
                                                   for(var56 = 0; var56 < 64; ++var56) {
                                                      if(var21 == var8 && var22 >= var17 && var22 < var17 + 8 && var56 >= var18 && var56 < var18 + 8) {
                                                         var26 = var15 + CacheFile.method2553(var22 & 7, var56 & 7, var52);
                                                         var29 = var22 & 7;
                                                         var30 = var56 & 7;
                                                         int var31 = var52 & 3;
                                                         if(var31 == 0) {
                                                            var28 = var30;
                                                         } else if(var31 == 1) {
                                                            var28 = 7 - var29;
                                                         } else if(var31 == 2) {
                                                            var28 = 7 - var30;
                                                         } else {
                                                            var28 = var29;
                                                         }

                                                         SoundTaskDataProvider.loadTerrain(var55, var47, var26, var28 + var16, 0, 0, var52);
                                                      } else {
                                                         SoundTaskDataProvider.loadTerrain(var55, 0, -1, -1, 0, 0, 0);
                                                      }
                                                   }
                                                }
                                             }

                                             var69 = true;
                                             break;
                                          }
                                       }
                                    }

                                    if(!var69) {
                                       var8 = var47;
                                       var52 = var45 * 8;
                                       var10 = var46 * 8;

                                       for(var11 = 0; var11 < 8; ++var11) {
                                          for(var12 = 0; var12 < 8; ++var12) {
                                             class50.tileHeights[var8][var11 + var52][var10 + var12] = 0;
                                          }
                                       }

                                       if(var52 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class50.tileHeights[var8][var52][var11 + var10] = class50.tileHeights[var8][var52 - 1][var10 + var11];
                                          }
                                       }

                                       if(var10 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class50.tileHeights[var8][var11 + var52][var10] = class50.tileHeights[var8][var52 + var11][var10 - 1];
                                          }
                                       }

                                       if(var52 > 0 && class50.tileHeights[var8][var52 - 1][var10] != 0) {
                                          class50.tileHeights[var8][var52][var10] = class50.tileHeights[var8][var52 - 1][var10];
                                       } else if(var10 > 0 && class50.tileHeights[var8][var52][var10 - 1] != 0) {
                                          class50.tileHeights[var8][var52][var10] = class50.tileHeights[var8][var52][var10 - 1];
                                       } else if(var52 > 0 && var10 > 0 && class50.tileHeights[var8][var52 - 1][var10 - 1] != 0) {
                                          class50.tileHeights[var8][var52][var10] = class50.tileHeights[var8][var52 - 1][var10 - 1];
                                       }
                                    }
                                 }
                              }

                              ++var47;
                           }
                        }

                        ItemContainer.flush(true);
                        Varbit.method4951();
                        class24.method457(ScriptEvent.region, collisionMaps);
                        ItemContainer.flush(true);
                        var47 = class50.field446;
                        if(var47 > class192.plane) {
                           var47 = class192.plane;
                        }

                        if(var47 < class192.plane - 1) {
                           var47 = class192.plane - 1;
                        }

                        if(lowMemory) {
                           ScriptEvent.region.setup(class50.field446);
                        } else {
                           ScriptEvent.region.setup(0);
                        }

                        for(var45 = 0; var45 < 104; ++var45) {
                           for(var46 = 0; var46 < 104; ++var46) {
                              class171.groundItemSpawned(var45, var46);
                           }
                        }

                        Varbit.method4951();
                        MapIconReference.method688();
                        ObjectComposition.field3426.reset();
                        PacketNode var66;
                        if(class37.clientInstance.method979()) {
                           var66 = DecorativeObject.method3115(ClientPacket.field2165, field739.field1250);
                           var66.packetBuffer.putInt(1057001181);
                           field739.method2019(var66);
                        }

                        if(!isDynamicRegion) {
                           var45 = (class11.field82 - 6) / 8;
                           var46 = (class11.field82 + 6) / 8;
                           var49 = (class54.field495 - 6) / 8;
                           var7 = (class54.field495 + 6) / 8;

                           for(var8 = var45 - 1; var8 <= var46 + 1; ++var8) {
                              for(var52 = var49 - 1; var52 <= var7 + 1; ++var52) {
                                 if(var8 < var45 || var8 > var46 || var52 < var49 || var52 > var7) {
                                    class234.indexMaps.method4650("m" + var8 + "_" + var52);
                                    class234.indexMaps.method4650("l" + var8 + "_" + var52);
                                 }
                              }
                           }
                        }

                        Resampler.setGameState(30);
                        Varbit.method4951();
                        class171.method3474();
                        var66 = DecorativeObject.method3115(ClientPacket.field2240, field739.field1250);
                        field739.method2019(var66);
                        FileOnDisk.method2579();
                     }
                  }
               }
            } else {
               class45.method819(this);
            }

            if(gameState == 30) {
               this.method1202();
            } else if(gameState == 40 || gameState == 45) {
               this.method1201();
            }

            return;
         }

         var1.data.load(var1.index, (int)var1.hash, var1.field3165, false);
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2135258546"
   )
   @Hook("clientMainLoop")
   @Export("methodDraw")
   protected final void methodDraw(boolean var1) {
      boolean var2 = WorldComparator.method0();
      if(var2 && field825 && GrandExchangeEvent.soundSystem0 != null) {
         GrandExchangeEvent.soundSystem0.tryFlush();
      }

      int var3;
      if((gameState == 10 || gameState == 20 || gameState == 30) && field803 != 0L && class166.method3456() > field803) {
         var3 = isResized?2:1;
         field803 = 0L;
         if(var3 >= 2) {
            isResized = true;
         } else {
            isResized = false;
         }

         int var4 = isResized?2:1;
         if(var4 == 1) {
            class37.clientInstance.method896(765, 503);
         } else {
            class37.clientInstance.method896(7680, 2160);
         }

         if(gameState >= 25) {
            PacketNode var5 = DecorativeObject.method3115(ClientPacket.field2206, field739.field1250);
            PacketBuffer var6 = var5.packetBuffer;
            int var7 = isResized?2:1;
            var6.putByte(var7);
            var5.packetBuffer.putShort(class9.canvasWidth);
            var5.packetBuffer.putShort(class37.canvasHeight);
            field739.method2019(var5);
         }
      }

      if(var1) {
         for(var3 = 0; var3 < 100; ++var3) {
            field795[var3] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class78.loadingBarPercentage, class78.loadingText, var1);
      } else if(gameState == 5) {
         class32.drawLoginScreen(WidgetNode.fontBold12, LoginPacket.fontPlain11, ScriptEvent.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class32.drawLoginScreen(WidgetNode.fontBold12, LoginPacket.fontPlain11, ScriptEvent.font_p12full, var1);
         } else if(gameState == 25) {
            if(field649 == 1) {
               if(field792 > field697) {
                  field697 = field792;
               }

               var3 = (field697 * 50 - field792 * 50) / field697;
               class16.method187("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else if(field649 == 2) {
               if(field647 > field648) {
                  field648 = field647;
               }

               var3 = (field648 * 50 - field647 * 50) / field648 + 50;
               class16.method187("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else {
               class16.method187("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1268();
         } else if(gameState == 40) {
            class16.method187("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class16.method187("Please wait...", false);
         }
      } else {
         class32.drawLoginScreen(WidgetNode.fontBold12, LoginPacket.fontPlain11, ScriptEvent.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var3 = 0; var3 < widgetCount; ++var3) {
            if(field796[var3]) {
               class50.rasterProvider.draw(widgetPositionX[var3], widgetPositionY[var3], widgetBoundsWidth[var3], widgetBoundsHeight[var3]);
               field796[var3] = false;
            }
         }
      } else if(gameState > 0) {
         class50.rasterProvider.drawFull(0, 0);

         for(var3 = 0; var3 < widgetCount; ++var3) {
            field796[var3] = false;
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "949470738"
   )
   protected final void vmethod1197() {
      if(Permission.varcs.changed()) {
         Permission.varcs.serialize();
      }

      if(VarCString.mouseRecorder != null) {
         VarCString.mouseRecorder.isRunning = false;
      }

      VarCString.mouseRecorder = null;
      field739.close();
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

      class173.mouseWheel = null;
      if(GrandExchangeEvent.soundSystem0 != null) {
         GrandExchangeEvent.soundSystem0.shutdown();
      }

      if(class191.soundSystem1 != null) {
         class191.soundSystem1.shutdown();
      }

      if(class250.NetCache_socket != null) {
         class250.NetCache_socket.vmethod3368();
      }

      Object var10 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3191 != 0) {
            IndexStoreActionHandler.field3191 = 1;

            try {
               IndexStoreActionHandler.IndexStoreActionHandler_lock.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      if(class59.urlRequester != null) {
         class59.urlRequester.close();
         class59.urlRequester = null;
      }

      class76.method1851();
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1726845378"
   )
   protected final void vmethod1192() {
   }

   @Export("init")
   @ObfuscatedName("init")
   public final void init() {
      try {
         if(this.isValidHost()) {
            Parameters[] var1 = new Parameters[]{Parameters.field3604, Parameters.field3605, Parameters.field3608, Parameters.field3610, Parameters.field3599, Parameters.field3607, Parameters.field3612, Parameters.field3606, Parameters.field3611, Parameters.field3600, Parameters.field3597, Parameters.field3609, Parameters.field3603, Parameters.field3598, Parameters.field3601, Parameters.field3602};
            Parameters[] var2 = var1;

            int var3;
            String var5;
            int var7;
            int var9;
            for(var3 = 0; var3 < var2.length; ++var3) {
               Parameters var4 = var2[var3];
               var5 = this.getParameter(var4.key);
               if(var5 != null) {
                  switch(Integer.parseInt(var4.key)) {
                  case 1:
                     if(var5.equalsIgnoreCase("true")) {
                        isMembers = true;
                     } else {
                        isMembers = false;
                     }
                  case 2:
                  case 3:
                  case 7:
                  default:
                     break;
                  case 4:
                     ScriptEvent.field521 = var5;
                     break;
                  case 5:
                     socketType = Integer.parseInt(var5);
                     break;
                  case 6:
                     LoginPacket.field2265 = (JagexGame)class7.forOrdinal(Occluder.method3112(), Integer.parseInt(var5));
                     if(LoginPacket.field2265 == JagexGame.field3158) {
                        WorldMapDecoration.loginType = JagexLoginType.field3878;
                     } else {
                        WorldMapDecoration.loginType = JagexLoginType.field3883;
                     }
                     break;
                  case 8:
                     field642 = Integer.parseInt(var5) != 0;
                     break;
                  case 9:
                     var7 = Integer.parseInt(var5);
                     BuildType[] var8 = class137.method3149();
                     var9 = 0;

                     BuildType var6;
                     while(true) {
                        if(var9 >= var8.length) {
                           var6 = null;
                           break;
                        }

                        BuildType var10 = var8[var9];
                        if(var7 == var10.field3149) {
                           var6 = var10;
                           break;
                        }

                        ++var9;
                     }

                     GraphicsObject.field1042 = var6;
                     break;
                  case 10:
                     if(field600 == -1) {
                        field600 = Integer.parseInt(var5);
                     }
                     break;
                  case 11:
                     class25.field231 = Integer.parseInt(var5);
                     break;
                  case 12:
                     if(var5.equalsIgnoreCase("true")) {
                        ;
                     }
                     break;
                  case 13:
                     flags = Integer.parseInt(var5);
                     break;
                  case 14:
                     languageId = Integer.parseInt(var5);
                     break;
                  case 15:
                     world = Integer.parseInt(var5);
                     break;
                  case 16:
                     SoundTaskDataProvider.sessionToken = var5;
                  }
               }
            }

            AbstractSoundSystem.method2253();
            WorldComparator.host = this.getCodeBase().getHost();
            String var33 = GraphicsObject.field1042.identifier;
            byte var17 = 0;

            try {
               class155.idxCount = 17;
               class313.field3765 = var17;

               try {
                  UrlRequester.osName = System.getProperty("os.name");
               } catch (Exception var28) {
                  UrlRequester.osName = "Unknown";
               }

               FaceNormal.osNameLC = UrlRequester.osName.toLowerCase();

               try {
                  FaceNormal.userHome = System.getProperty("user.home");
                  if(FaceNormal.userHome != null) {
                     FaceNormal.userHome = FaceNormal.userHome + "/";
                  }
               } catch (Exception var27) {
                  ;
               }

               try {
                  if(FaceNormal.osNameLC.startsWith("win")) {
                     if(FaceNormal.userHome == null) {
                        FaceNormal.userHome = System.getenv("USERPROFILE");
                     }
                  } else if(FaceNormal.userHome == null) {
                     FaceNormal.userHome = System.getenv("HOME");
                  }

                  if(FaceNormal.userHome != null) {
                     FaceNormal.userHome = FaceNormal.userHome + "/";
                  }
               } catch (Exception var26) {
                  ;
               }

               if(FaceNormal.userHome == null) {
                  FaceNormal.userHome = "~/";
               }

               class155.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", FaceNormal.userHome, "/tmp/", ""};
               class155.field1995 = new String[]{".jagex_cache_" + class313.field3765, ".file_store_" + class313.field3765};
               var3 = 0;

               label259:
               while(var3 < 4) {
                  var5 = var3 == 0?"":"" + var3;
                  class155.jagexClDat = new File(FaceNormal.userHome, "jagex_cl_oldschool_" + var33 + var5 + ".dat");
                  String var36 = null;
                  String var19 = null;
                  boolean var20 = false;
                  File var39;
                  if(class155.jagexClDat.exists()) {
                     try {
                        FileOnDisk var21 = new FileOnDisk(class155.jagexClDat, "rw", 10000L);

                        int var11;
                        Buffer var38;
                        for(var38 = new Buffer((int)var21.length()); var38.offset < var38.payload.length; var38.offset += var11) {
                           var11 = var21.read(var38.payload, var38.offset, var38.payload.length - var38.offset);
                           if(var11 == -1) {
                              throw new IOException();
                           }
                        }

                        var38.offset = 0;
                        var11 = var38.readUnsignedByte();
                        if(var11 < 1 || var11 > 3) {
                           throw new IOException("" + var11);
                        }

                        int var12 = 0;
                        if(var11 > 1) {
                           var12 = var38.readUnsignedByte();
                        }

                        if(var11 <= 2) {
                           var36 = var38.getJagString();
                           if(var12 == 1) {
                              var19 = var38.getJagString();
                           }
                        } else {
                           var36 = var38.getCESU8();
                           if(var12 == 1) {
                              var19 = var38.getCESU8();
                           }
                        }

                        var21.close();
                     } catch (IOException var30) {
                        var30.printStackTrace();
                     }

                     if(var36 != null) {
                        var39 = new File(var36);
                        if(!var39.exists()) {
                           var36 = null;
                        }
                     }

                     if(var36 != null) {
                        var39 = new File(var36, "test.dat");
                        if(!WorldMapData.method294(var39, true)) {
                           var36 = null;
                        }
                     }
                  }

                  if(var36 == null && var3 == 0) {
                     label234:
                     for(var9 = 0; var9 < class155.field1995.length; ++var9) {
                        for(int var22 = 0; var22 < class155.cacheLocations.length; ++var22) {
                           File var23 = new File(class155.cacheLocations[var22] + class155.field1995[var9] + File.separatorChar + "oldschool" + File.separatorChar);
                           if(var23.exists() && WorldMapData.method294(new File(var23, "test.dat"), true)) {
                              var36 = var23.toString();
                              var20 = true;
                              break label234;
                           }
                        }
                     }
                  }

                  if(var36 == null) {
                     var36 = FaceNormal.userHome + File.separatorChar + "jagexcache" + var5 + File.separatorChar + "oldschool" + File.separatorChar + var33 + File.separatorChar;
                     var20 = true;
                  }

                  if(var19 != null) {
                     File var41 = new File(var19);
                     var39 = new File(var36);

                     try {
                        File[] var42 = var41.listFiles();
                        File[] var24 = var42;

                        for(int var13 = 0; var13 < var24.length; ++var13) {
                           File var14 = var24[var13];
                           File var15 = new File(var39, var14.getName());
                           boolean var16 = var14.renameTo(var15);
                           if(!var16) {
                              throw new IOException();
                           }
                        }
                     } catch (Exception var29) {
                        var29.printStackTrace();
                     }

                     var20 = true;
                  }

                  if(var20) {
                     class81.method1921(new File(var36), (File)null);
                  }

                  File var34 = new File(var36);
                  class155.field1985 = var34;
                  if(!class155.field1985.exists()) {
                     class155.field1985.mkdirs();
                  }

                  File[] var35 = class155.field1985.listFiles();
                  if(var35 != null) {
                     File[] var40 = var35;

                     for(var7 = 0; var7 < var40.length; ++var7) {
                        File var37 = var40[var7];
                        if(!WorldMapData.method294(var37, false)) {
                           ++var3;
                           continue label259;
                        }
                     }
                  }
                  break;
               }

               File var18 = class155.field1985;
               class158.field2000 = var18;
               if(!class158.field2000.exists()) {
                  throw new RuntimeException("");
               }

               class158.field2001 = true;
               Ignore.method5431();
               class155.dat2File = new CacheFile(new FileOnDisk(class224.method4458("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
               class155.idx255File = new CacheFile(new FileOnDisk(class224.method4458("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
               class155.idxFiles = new CacheFile[class155.idxCount];

               for(int var25 = 0; var25 < class155.idxCount; ++var25) {
                  class155.idxFiles[var25] = new CacheFile(new FileOnDisk(class224.method4458("main_file_cache.idx" + var25), "rw", 1048576L), 6000, 0);
               }
            } catch (Exception var31) {
               class43.processClientError((String)null, var31);
            }

            class37.clientInstance = this;
            RunException.field1959 = field600;
            this.initialize(765, 503, 170);
         }
      } catch (RuntimeException var32) {
         throw GrandExchangeEvents.method12(var32, "client.init(" + ')');
      }
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1674862603"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         boolean var1 = class137.method3141();
         if(!var1) {
            this.method1199();
         }

      }
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "380536168"
   )
   void method1199() {
      if(class250.field3226 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class250.field3227 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field625 = 3000;
            class250.field3227 = 3;
         }

         if(--field625 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  Size.socket = GameEngine.taskManager.createSocket(WorldComparator.host, Size.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(Size.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(Size.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  if(field642) {
                     rssocket = WorldMapType3.method154((Socket)Size.socket.value, 40000, 5000);
                  } else {
                     rssocket = new class161((Socket)Size.socket.value, GameEngine.taskManager, 5000);
                  }

                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(170);
                  rssocket.vmethod3385(var1.payload, 0, 5);
                  ++js5State;
                  class43.field362 = class166.method3456();
               }

               if(js5State == 3) {
                  if(rssocket.vmethod3354() > 0 || !field642 && gameState <= 5) {
                     int var5 = rssocket.vmethod3353();
                     if(var5 != 0) {
                        this.error(var5);
                        return;
                     }

                     ++js5State;
                  } else if(class166.method3456() - class43.field362 > 30000L) {
                     this.error(-2);
                     return;
                  }
               }

               if(js5State == 4) {
                  class157 var10 = rssocket;
                  boolean var2 = gameState > 20;
                  if(class250.NetCache_socket != null) {
                     try {
                        class250.NetCache_socket.vmethod3368();
                     } catch (Exception var8) {
                        ;
                     }

                     class250.NetCache_socket = null;
                  }

                  class250.NetCache_socket = var10;
                  WorldMapType3.sendConInfo(var2);
                  class250.NetCache_responseHeaderBuffer.offset = 0;
                  class320.currentRequest = null;
                  class232.NetCache_responseArchiveBuffer = null;
                  class250.field3221 = 0;

                  while(true) {
                     FileRequest var3 = (FileRequest)class250.NetCache_pendingPriorityResponses.first();
                     if(var3 == null) {
                        while(true) {
                           var3 = (FileRequest)class250.NetCache_pendingResponses.first();
                           if(var3 == null) {
                              if(class250.field3225 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.putByte(4);
                                    var11.putByte(class250.field3225);
                                    var11.putShort(0);
                                    class250.NetCache_socket.vmethod3385(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class250.NetCache_socket.vmethod3368();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class250.field3227;
                                    class250.NetCache_socket = null;
                                 }
                              }

                              class250.field3209 = 0;
                              class250.field3223 = class166.method3456();
                              Size.socket = null;
                              rssocket = null;
                              js5State = 0;
                              field595 = 0;
                              return;
                           }

                           class250.NetCache_pendingWritesQueue.setHead(var3);
                           class250.NetCache_pendingWrites.put(var3, var3.hash);
                           ++class250.NetCache_pendingWritesCount;
                           --class250.NetCache_pendingResponsesCount;
                        }
                     }

                     class250.NetCache_pendingPriorityWrites.put(var3, var3.hash);
                     ++class250.NetCache_pendingPriorityWritesCount;
                     --class250.NetCache_pendingPriorityResponsesCount;
                  }
               }
            } catch (IOException var9) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1109811529"
   )
   @Export("error")
   void error(int var1) {
      Size.socket = null;
      rssocket = null;
      js5State = 0;
      if(Size.myWorldPort == ServerPacket.port1) {
         Size.myWorldPort = class13.port2;
      } else {
         Size.myWorldPort = ServerPacket.port1;
      }

      ++field595;
      if(field595 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field625 = 3000;
         }
      } else if(field595 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field595 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field625 = 3000;
         }
      }

   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "991472139"
   )
   final void method1201() {
      Object var1 = field739.getSocket();
      PacketBuffer var2 = field739.packetBuffer;

      try {
         if(loginState == 0) {
            if(var1 != null) {
               ((class157)var1).vmethod3368();
               var1 = null;
            }

            Tile.field1584 = null;
            socketError = false;
            field645 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(Tile.field1584 == null) {
               Tile.field1584 = GameEngine.taskManager.createSocket(WorldComparator.host, Size.myWorldPort);
            }

            if(Tile.field1584.status == 2) {
               throw new IOException();
            }

            if(Tile.field1584.status == 1) {
               if(field642) {
                  var1 = WorldMapType3.method154((Socket)Tile.field1584.value, 40000, 5000);
               } else {
                  var1 = new class161((Socket)Tile.field1584.value, GameEngine.taskManager, 5000);
               }

               field739.setSocket((class157)var1);
               Tile.field1584 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            field739.method2020();
            PacketNode var3 = ServerPacket.method3458();
            var3.packetBuffer.putByte(LoginPacket.field2261.id);
            field739.method2019(var3);
            field739.method2034();
            var2.offset = 0;
            loginState = 3;
         }

         int var4;
         boolean var11;
         if(loginState == 3) {
            if(GrandExchangeEvent.soundSystem0 != null) {
               GrandExchangeEvent.soundSystem0.method2193();
            }

            if(class191.soundSystem1 != null) {
               class191.soundSystem1.method2193();
            }

            var11 = true;
            if(field642 && !((class157)var1).vmethod3355(1)) {
               var11 = false;
            }

            if(var11) {
               var4 = ((class157)var1).vmethod3353();
               if(GrandExchangeEvent.soundSystem0 != null) {
                  GrandExchangeEvent.soundSystem0.method2193();
               }

               if(class191.soundSystem1 != null) {
                  class191.soundSystem1.method2193();
               }

               if(var4 != 0) {
                  WorldMapDecoration.method221(var4);
                  return;
               }

               var2.offset = 0;
               loginState = 4;
            }
         }

         int var23;
         if(loginState == 4) {
            if(var2.offset < 8) {
               var23 = ((class157)var1).vmethod3354();
               if(var23 > 8 - var2.offset) {
                  var23 = 8 - var2.offset;
               }

               if(var23 > 0) {
                  ((class157)var1).vmethod3356(var2.payload, var2.offset, var23);
                  var2.offset += var23;
               }
            }

            if(var2.offset == 8) {
               var2.offset = 0;
               class165.field2065 = var2.readLong();
               loginState = 5;
            }
         }

         int var7;
         if(loginState == 5) {
            field739.packetBuffer.offset = 0;
            field739.method2020();
            PacketBuffer var17 = new PacketBuffer(500);
            int[] var12 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class165.field2065 >> 32), (int)(class165.field2065 & -1L)};
            var17.offset = 0;
            var17.putByte(1);
            var17.putByte(field716.rsOrdinal());
            var17.putInt(var12[0]);
            var17.putInt(var12[1]);
            var17.putInt(var12[2]);
            var17.putInt(var12[3]);
            switch(field716.field1928) {
            case 0:
            case 2:
               var17.put24bitInt(MessageNode.field549);
               var17.offset += 5;
               break;
            case 1:
               var17.putInt(((Integer)ScriptState.preferences.preferences.get(Integer.valueOf(method1577(class78.username)))).intValue());
               var17.offset += 4;
               break;
            case 3:
               var17.offset += 8;
            }

            var17.putString(class78.password);
            var17.encryptRsa(class76.field1093, class76.field1087);
            PacketNode var5 = ServerPacket.method3458();
            var5.packetBuffer.offset = 0;
            if(gameState == 40) {
               var5.packetBuffer.putByte(LoginPacket.field2258.id);
            } else {
               var5.packetBuffer.putByte(LoginPacket.field2260.id);
            }

            var5.packetBuffer.putShort(0);
            int var6 = var5.packetBuffer.offset;
            var5.packetBuffer.putInt(170);
            var5.packetBuffer.putBytes(var17.payload, 0, var17.offset);
            var7 = var5.packetBuffer.offset;
            var5.packetBuffer.putString(class78.username);
            var5.packetBuffer.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            var5.packetBuffer.putShort(class9.canvasWidth);
            var5.packetBuffer.putShort(class37.canvasHeight);
            PacketBuffer var8 = var5.packetBuffer;
            if(field718 != null) {
               var8.putBytes(field718, 0, field718.length);
            } else {
               byte[] var9 = PlayerComposition.method4515();
               var8.putBytes(var9, 0, var9.length);
            }

            var5.packetBuffer.putString(SoundTaskDataProvider.sessionToken);
            var5.packetBuffer.putInt(class25.field231);
            Buffer var22 = new Buffer(AttackOption.platformInfo.method6250());
            AttackOption.platformInfo.method6249(var22);
            var5.packetBuffer.putBytes(var22.payload, 0, var22.payload.length);
            var5.packetBuffer.putByte(field600);
            var5.packetBuffer.putInt(0);
            var5.packetBuffer.putInt(FileSystem.indexInterfaces.crc);
            var5.packetBuffer.putInt(indexSoundEffects.crc);
            var5.packetBuffer.putInt(class9.configsIndex.crc);
            var5.packetBuffer.putInt(WorldMapDecoration.indexCache3.crc);
            var5.packetBuffer.putInt(FileOnDisk.indexCache4.crc);
            var5.packetBuffer.putInt(class234.indexMaps.crc);
            var5.packetBuffer.putInt(MouseInput.indexTrack1.crc);
            var5.packetBuffer.putInt(class216.indexModels.crc);
            var5.packetBuffer.putInt(class59.indexSprites.crc);
            var5.packetBuffer.putInt(class183.indexTextures.crc);
            var5.packetBuffer.putInt(MapLabel.indexCache10.crc);
            var5.packetBuffer.putInt(WidgetNode.indexTrack2.crc);
            var5.packetBuffer.putInt(TotalQuantityComparator.indexScripts.crc);
            var5.packetBuffer.putInt(TotalQuantityComparator.indexCache13.crc);
            var5.packetBuffer.putInt(class10.vorbisIndex.crc);
            var5.packetBuffer.putInt(class6.indexCache15.crc);
            var5.packetBuffer.putInt(MouseInput.indexWorldMap.crc);
            var5.packetBuffer.encryptXtea(var12, var7, var5.packetBuffer.offset);
            var5.packetBuffer.method3734(var5.packetBuffer.offset - var6);
            field739.method2019(var5);
            field739.method2034();
            field739.field1250 = new ISAACCipher(var12);

            for(int var10 = 0; var10 < 4; ++var10) {
               var12[var10] += 50;
            }

            var2.seed(var12);
            loginState = 6;
         }

         if(loginState == 6 && ((class157)var1).vmethod3354() > 0) {
            var23 = ((class157)var1).vmethod3353();
            if(var23 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var23 == 2) {
               loginState = 9;
            } else if(var23 == 15 && gameState == 40) {
               field739.packetLength = -1;
               loginState = 13;
            } else if(var23 == 23 && field630 < 1) {
               ++field630;
               loginState = 0;
            } else {
               if(var23 != 29) {
                  WorldMapDecoration.method221(var23);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && ((class157)var1).vmethod3354() > 0) {
            field631 = (((class157)var1).vmethod3353() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field645 = 0;
            Resampler.method2307("You have only just left another world.", "Your profile will be transferred in:", field631 / 60 + " seconds.");
            if(--field631 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && ((class157)var1).vmethod3354() >= 13) {
               var11 = ((class157)var1).vmethod3353() == 1;
               ((class157)var1).vmethod3356(var2.payload, 0, 4);
               var2.offset = 0;
               boolean var19 = false;
               if(var11) {
                  var4 = var2.readOpcode() << 24;
                  var4 |= var2.readOpcode() << 16;
                  var4 |= var2.readOpcode() << 8;
                  var4 |= var2.readOpcode();
                  int var13 = method1577(class78.username);
                  if(ScriptState.preferences.preferences.size() >= 10 && !ScriptState.preferences.preferences.containsKey(Integer.valueOf(var13))) {
                     Iterator var14 = ScriptState.preferences.preferences.entrySet().iterator();
                     var14.next();
                     var14.remove();
                  }

                  ScriptState.preferences.preferences.put(Integer.valueOf(var13), Integer.valueOf(var4));
               }

               if(class78.Login_isUsernameRemembered) {
                  ScriptState.preferences.rememberedUsername = class78.username;
               } else {
                  ScriptState.preferences.rememberedUsername = null;
               }

               Enum.method5008();
               rights = ((class157)var1).vmethod3353();
               field761 = ((class157)var1).vmethod3353() == 1;
               localInteractingIndex = ((class157)var1).vmethod3353();
               localInteractingIndex <<= 8;
               localInteractingIndex += ((class157)var1).vmethod3353();
               field710 = ((class157)var1).vmethod3353();
               ((class157)var1).vmethod3356(var2.payload, 0, 1);
               var2.offset = 0;
               ServerPacket[] var20 = new ServerPacket[]{ServerPacket.field2092, ServerPacket.field2127, ServerPacket.field2082, ServerPacket.field2149, ServerPacket.field2079, ServerPacket.field2076, ServerPacket.field2077, ServerPacket.field2119, ServerPacket.field2074, ServerPacket.field2080, ServerPacket.field2134, ServerPacket.field2071, ServerPacket.field2083, ServerPacket.field2084, ServerPacket.field2085, ServerPacket.field2086, ServerPacket.field2122, ServerPacket.field2088, ServerPacket.field2089, ServerPacket.field2099, ServerPacket.field2091, ServerPacket.field2096, ServerPacket.field2093, ServerPacket.field2094, ServerPacket.field2081, ServerPacket.field2087, ServerPacket.field2097, ServerPacket.field2098, ServerPacket.field2128, ServerPacket.field2100, ServerPacket.field2101, ServerPacket.field2102, ServerPacket.field2103, ServerPacket.field2104, ServerPacket.field2105, ServerPacket.field2106, ServerPacket.field2107, ServerPacket.field2108, ServerPacket.field2109, ServerPacket.field2110, ServerPacket.field2072, ServerPacket.field2112, ServerPacket.field2113, ServerPacket.field2114, ServerPacket.field2115, ServerPacket.field2116, ServerPacket.field2117, ServerPacket.field2118, ServerPacket.field2095, ServerPacket.field2120, ServerPacket.field2151, ServerPacket.field2090, ServerPacket.field2123, ServerPacket.field2124, ServerPacket.field2125, ServerPacket.field2126, ServerPacket.field2073, ServerPacket.field2156, ServerPacket.field2157, ServerPacket.field2130, ServerPacket.field2131, ServerPacket.field2132, ServerPacket.field2133, ServerPacket.field2138, ServerPacket.field2135, ServerPacket.field2136, ServerPacket.field2137, ServerPacket.field2152, ServerPacket.field2139, ServerPacket.field2140, ServerPacket.field2121, ServerPacket.field2142, ServerPacket.field2143, ServerPacket.field2129, ServerPacket.field2145, ServerPacket.field2146, ServerPacket.field2144, ServerPacket.field2078, ServerPacket.field2154, ServerPacket.field2150, ServerPacket.field2075, ServerPacket.field2147, ServerPacket.field2153, ServerPacket.field2148};
               var7 = var2.method3883();
               if(var7 < 0 || var7 >= var20.length) {
                  throw new IOException(var7 + " " + var2.offset);
               }

               field739.serverPacket = var20[var7];
               field739.packetLength = field739.serverPacket.packetLength;
               ((class157)var1).vmethod3356(var2.payload, 0, 2);
               var2.offset = 0;
               field739.packetLength = var2.readUnsignedShort();

               try {
                  class41.method769(class37.clientInstance, "zap");
               } catch (Throwable var15) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(((class157)var1).vmethod3354() >= field739.packetLength) {
                  var2.offset = 0;
                  ((class157)var1).vmethod3356(var2.payload, 0, field739.packetLength);
                  field840.method5259();
                  class16.method186();
                  class83.initializeGPI(var2);
                  class11.field82 = -1;
                  ScriptEvent.xteaChanged(false, var2);
                  field739.serverPacket = null;
               }

            } else {
               if(loginState == 11 && ((class157)var1).vmethod3354() >= 2) {
                  var2.offset = 0;
                  ((class157)var1).vmethod3356(var2.payload, 0, 2);
                  var2.offset = 0;
                  class81.field1192 = var2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && ((class157)var1).vmethod3354() >= class81.field1192) {
                  var2.offset = 0;
                  ((class157)var1).vmethod3356(var2.payload, 0, class81.field1192);
                  var2.offset = 0;
                  String var18 = var2.readString();
                  String var24 = var2.readString();
                  String var21 = var2.readString();
                  Resampler.method2307(var18, var24, var21);
                  Resampler.setGameState(10);
               }

               if(loginState == 13) {
                  if(field739.packetLength == -1) {
                     if(((class157)var1).vmethod3354() < 2) {
                        return;
                     }

                     ((class157)var1).vmethod3356(var2.payload, 0, 2);
                     var2.offset = 0;
                     field739.packetLength = var2.readUnsignedShort();
                  }

                  if(((class157)var1).vmethod3354() >= field739.packetLength) {
                     ((class157)var1).vmethod3356(var2.payload, 0, field739.packetLength);
                     var2.offset = 0;
                     var23 = field739.packetLength;
                     field840.method5260();
                     CacheFile.method2549();
                     class83.initializeGPI(var2);
                     if(var23 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field645;
                  if(field645 > 2000) {
                     if(field630 < 1) {
                        if(ServerPacket.port1 == Size.myWorldPort) {
                           Size.myWorldPort = class13.port2;
                        } else {
                           Size.myWorldPort = ServerPacket.port1;
                        }

                        ++field630;
                        loginState = 0;
                     } else {
                        WorldMapDecoration.method221(-3);
                     }
                  }
               }
            }
         }
      } catch (IOException var16) {
         if(field630 < 1) {
            if(Size.myWorldPort == ServerPacket.port1) {
               Size.myWorldPort = class13.port2;
            } else {
               Size.myWorldPort = ServerPacket.port1;
            }

            ++field630;
            loginState = 0;
         } else {
            WorldMapDecoration.method221(-2);
         }
      }
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2042781731"
   )
   final void method1202() {
      if(field643 > 1) {
         --field643;
      }

      if(field688 > 0) {
         --field688;
      }

      if(socketError) {
         socketError = false;
         ChatLineBuffer.method2018();
      } else {
         if(!isMenuOpen) {
            Actor.method1597();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method1572(field739); ++var1) {
            ;
         }

         if(gameState == 30) {
            int var2;
            PacketNode var14;
            while(WorldMapManager.method562()) {
               var14 = DecorativeObject.method3115(ClientPacket.field2182, field739.field1250);
               var14.packetBuffer.putByte(0);
               var2 = var14.packetBuffer.offset;
               class21.encodeClassVerifier(var14.packetBuffer);
               var14.packetBuffer.method3565(var14.packetBuffer.offset - var2);
               field739.method2019(var14);
            }

            if(field840.field3616) {
               var14 = DecorativeObject.method3115(ClientPacket.field2190, field739.field1250);
               var14.packetBuffer.putByte(0);
               var2 = var14.packetBuffer.offset;
               field840.method5261(var14.packetBuffer);
               var14.packetBuffer.method3565(var14.packetBuffer.offset - var2);
               field739.method2019(var14);
               field840.method5254();
            }

            Object var32 = VarCString.mouseRecorder.lock;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            synchronized(VarCString.mouseRecorder.lock) {
               if(!field780) {
                  VarCString.mouseRecorder.index = 0;
               } else if(MouseInput.mouseLastButton != 0 || VarCString.mouseRecorder.index >= 40) {
                  PacketNode var15 = DecorativeObject.method3115(ClientPacket.field2251, field739.field1250);
                  var15.packetBuffer.putByte(0);
                  var3 = var15.packetBuffer.offset;
                  var4 = 0;

                  for(var5 = 0; var5 < VarCString.mouseRecorder.index && var15.packetBuffer.offset - var3 < 240; ++var5) {
                     ++var4;
                     var6 = VarCString.mouseRecorder.ys[var5];
                     if(var6 < 0) {
                        var6 = 0;
                     } else if(var6 > 502) {
                        var6 = 502;
                     }

                     var7 = VarCString.mouseRecorder.xs[var5];
                     if(var7 < 0) {
                        var7 = 0;
                     } else if(var7 > 764) {
                        var7 = 764;
                     }

                     var8 = var6 * 765 + var7;
                     if(VarCString.mouseRecorder.ys[var5] == -1 && VarCString.mouseRecorder.xs[var5] == -1) {
                        var7 = -1;
                        var6 = -1;
                        var8 = 524287;
                     }

                     if(var7 == field606 && var6 == field607) {
                        if(field608 < 2047) {
                           ++field608;
                        }
                     } else {
                        var9 = var7 - field606;
                        field606 = var7;
                        var10 = var6 - field607;
                        field607 = var6;
                        if(field608 < 8 && var9 >= -32 && var9 <= 31 && var10 >= -32 && var10 <= 31) {
                           var9 += 32;
                           var10 += 32;
                           var15.packetBuffer.putShort(var10 + (field608 << 12) + (var9 << 6));
                           field608 = 0;
                        } else if(field608 < 8) {
                           var15.packetBuffer.put24bitInt((field608 << 19) + var8 + 8388608);
                           field608 = 0;
                        } else {
                           var15.packetBuffer.putInt((field608 << 19) + var8 + -1073741824);
                           field608 = 0;
                        }
                     }
                  }

                  var15.packetBuffer.method3565(var15.packetBuffer.offset - var3);
                  field739.method2019(var15);
                  if(var4 >= VarCString.mouseRecorder.index) {
                     VarCString.mouseRecorder.index = 0;
                  } else {
                     VarCString.mouseRecorder.index -= var4;

                     for(var5 = 0; var5 < VarCString.mouseRecorder.index; ++var5) {
                        VarCString.mouseRecorder.xs[var5] = VarCString.mouseRecorder.xs[var4 + var5];
                        VarCString.mouseRecorder.ys[var5] = VarCString.mouseRecorder.ys[var4 + var5];
                     }
                  }
               }
            }

            if(MouseInput.mouseLastButton == 1 || !class8.middleMouseMovesCamera && MouseInput.mouseLastButton == 4 || MouseInput.mouseLastButton == 2) {
               long var16 = (MouseInput.mouseLastPressedTimeMillis - mouseLastLastPressedTimeMillis * -1L) / 50L;
               if(var16 > 4095L) {
                  var16 = 4095L;
               }

               mouseLastLastPressedTimeMillis = MouseInput.mouseLastPressedTimeMillis * -1L;
               var3 = MouseInput.mouseLastPressedY;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > class37.canvasHeight) {
                  var3 = class37.canvasHeight;
               }

               var4 = MouseInput.mouseLastPressedX;
               if(var4 < 0) {
                  var4 = 0;
               } else if(var4 > class9.canvasWidth) {
                  var4 = class9.canvasWidth;
               }

               var5 = (int)var16;
               PacketNode var18 = DecorativeObject.method3115(ClientPacket.field2193, field739.field1250);
               var18.packetBuffer.putShort((var5 << 1) + (MouseInput.mouseLastButton == 2?1:0));
               var18.packetBuffer.putShort(var4);
               var18.packetBuffer.putShort(var3);
               field739.method2019(var18);
            }

            if(KeyFocusListener.field347 > 0) {
               var14 = DecorativeObject.method3115(ClientPacket.field2208, field739.field1250);
               var14.packetBuffer.putShort(0);
               var2 = var14.packetBuffer.offset;
               long var19 = class166.method3456();

               for(var5 = 0; var5 < KeyFocusListener.field347; ++var5) {
                  long var21 = var19 - field782;
                  if(var21 > 16777215L) {
                     var21 = 16777215L;
                  }

                  field782 = var19;
                  var14.packetBuffer.method3633((int)var21);
                  var14.packetBuffer.putByte(KeyFocusListener.field346[var5]);
               }

               var14.packetBuffer.method3734(var14.packetBuffer.offset - var2);
               field739.method2019(var14);
            }

            if(field801 > 0) {
               --field801;
            }

            if(KeyFocusListener.keyPressed[96] || KeyFocusListener.keyPressed[97] || KeyFocusListener.keyPressed[98] || KeyFocusListener.keyPressed[99]) {
               field677 = true;
            }

            if(field677 && field801 <= 0) {
               field801 = 20;
               field677 = false;
               var14 = DecorativeObject.method3115(ClientPacket.field2162, field739.field1250);
               var14.packetBuffer.method3605(cameraPitchTarget);
               var14.packetBuffer.method3707(mapAngle);
               field739.method2019(var14);
            }

            if(Preferences.field978 && !field609) {
               field609 = true;
               var14 = DecorativeObject.method3115(ClientPacket.field2246, field739.field1250);
               var14.packetBuffer.putByte(1);
               field739.method2019(var14);
            }

            if(!Preferences.field978 && field609) {
               field609 = false;
               var14 = DecorativeObject.method3115(ClientPacket.field2246, field739.field1250);
               var14.packetBuffer.putByte(0);
               field739.method2019(var14);
            }

            if(Preferences.renderOverview != null) {
               Preferences.renderOverview.method6049();
            }

            Frames.method3091();
            WidgetNode.method1075();
            if(gameState == 30) {
               for(PendingSpawn var34 = (PendingSpawn)pendingSpawns.getFront(); var34 != null; var34 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var34.hitpoints > 0) {
                     --var34.hitpoints;
                  }

                  if(var34.hitpoints == 0) {
                     if(var34.field870 < 0 || class26.method470(var34.field870, var34.field872)) {
                        class24.method459(var34.level, var34.type, var34.x, var34.y, var34.field870, var34.field871, var34.field872);
                        var34.unlink();
                     }
                  } else {
                     if(var34.delay > 0) {
                        --var34.delay;
                     }

                     if(var34.delay == 0 && var34.x >= 1 && var34.y >= 1 && var34.x <= 102 && var34.y <= 102 && (var34.id < 0 || class26.method470(var34.id, var34.field875))) {
                        class24.method459(var34.level, var34.type, var34.x, var34.y, var34.id, var34.orientation, var34.field875);
                        var34.delay = -1;
                        if(var34.field870 == var34.id && var34.field870 == -1) {
                           var34.unlink();
                        } else if(var34.id == var34.field870 && var34.field871 == var34.orientation && var34.field875 == var34.field872) {
                           var34.unlink();
                        }
                     }
                  }
               }

               GameCanvas.method774();
               ++field739.field1249;
               if(field739.field1249 > 750) {
                  ChatLineBuffer.method2018();
               } else {
                  class24.method458();

                  for(var1 = 0; var1 < npcIndexesCount; ++var1) {
                     var2 = npcIndices[var1];
                     NPC var23 = cachedNPCs[var2];
                     if(var23 != null) {
                        class68.method1747(var23, var23.composition.size);
                     }
                  }

                  class68.method1746();
                  ++field654;
                  if(cursorState != 0) {
                     field843 += 20;
                     if(field843 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class144.field1921 != null) {
                     ++mouseCrosshair;
                     if(mouseCrosshair >= 15) {
                        DState.method3548(class144.field1921);
                        class144.field1921 = null;
                     }
                  }

                  Widget var35 = class37.field329;
                  Widget var33 = class7.field42;
                  class37.field329 = null;
                  class7.field42 = null;
                  draggedOnWidget = null;
                  field860 = false;
                  field594 = false;
                  field845 = 0;

                  while(AbstractSoundSystem.method2208() && field845 < 128) {
                     if(rights >= 2 && KeyFocusListener.keyPressed[82] && WallObject.currentPressedKey == 66) {
                        String var36 = class10.method101();
                        class37.clientInstance.method929(var36);
                     } else if(field678 != 1 || Occluder.currentTypedKey <= 0) {
                        field865[field845] = WallObject.currentPressedKey;
                        field812[field845] = Occluder.currentTypedKey;
                        ++field845;
                     }
                  }

                  if(class139.method3161() && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81] && mouseWheelRotation != 0) {
                     var3 = MilliTimer.localPlayer.field581 - mouseWheelRotation;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > 3) {
                        var3 = 3;
                     }

                     if(var3 != MilliTimer.localPlayer.field581) {
                        class145.method3194(MilliTimer.localPlayer.pathX[0] + class178.baseX, MilliTimer.localPlayer.pathY[0] + CombatInfoListHolder.baseY, var3, false);
                     }

                     mouseWheelRotation = 0;
                  }

                  if(widgetRoot != -1) {
                     var3 = widgetRoot;
                     var4 = class9.canvasWidth;
                     var5 = class37.canvasHeight;
                     if(GameCanvas.loadWidget(var3)) {
                        GrandExchangeEvent.method25(Widget.widgets[var3], -1, 0, 0, var4, var5, 0, 0);
                     }
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var24;
                     Widget var25;
                     ScriptEvent var37;
                     do {
                        var37 = (ScriptEvent)field790.popFront();
                        if(var37 == null) {
                           while(true) {
                              do {
                                 var37 = (ScriptEvent)field791.popFront();
                                 if(var37 == null) {
                                    while(true) {
                                       do {
                                          var37 = (ScriptEvent)field755.popFront();
                                          if(var37 == null) {
                                             this.method1207();
                                             if(Preferences.renderOverview != null) {
                                                Preferences.renderOverview.method6222(class192.plane, (MilliTimer.localPlayer.x >> 7) + class178.baseX, (MilliTimer.localPlayer.y >> 7) + CombatInfoListHolder.baseY, false);
                                                Preferences.renderOverview.method6074();
                                             }

                                             if(draggedWidget != null) {
                                                this.method1238();
                                             }

                                             if(class49.field442 != null) {
                                                DState.method3548(class49.field442);
                                                ++itemPressedDuration;
                                                if(MouseInput.mouseCurrentButton == 0) {
                                                   if(field704) {
                                                      if(FontName.field3688 == class49.field442 && field597 != field703) {
                                                         Widget var38 = class49.field442;
                                                         byte var30 = 0;
                                                         if(field814 == 1 && var38.contentType == 206) {
                                                            var30 = 1;
                                                         }

                                                         if(var38.itemIds[field703] <= 0) {
                                                            var30 = 0;
                                                         }

                                                         var6 = AbstractSoundSystem.getWidgetClickMask(var38);
                                                         boolean var31 = (var6 >> 29 & 1) != 0;
                                                         if(var31) {
                                                            var7 = field597;
                                                            var8 = field703;
                                                            var38.itemIds[var8] = var38.itemIds[var7];
                                                            var38.itemQuantities[var8] = var38.itemQuantities[var7];
                                                            var38.itemIds[var7] = -1;
                                                            var38.itemQuantities[var7] = 0;
                                                         } else if(var30 == 1) {
                                                            var7 = field597;
                                                            var8 = field703;

                                                            while(var8 != var7) {
                                                               if(var7 > var8) {
                                                                  var38.method4525(var7 - 1, var7);
                                                                  --var7;
                                                               } else if(var7 < var8) {
                                                                  var38.method4525(var7 + 1, var7);
                                                                  ++var7;
                                                               }
                                                            }
                                                         } else {
                                                            var38.method4525(field703, field597);
                                                         }

                                                         PacketNode var26 = DecorativeObject.method3115(ClientPacket.field2244, field739.field1250);
                                                         var26.packetBuffer.method3605(field703);
                                                         var26.packetBuffer.method3670(class49.field442.id);
                                                         var26.packetBuffer.method3707(field597);
                                                         var26.packetBuffer.method3596(var30);
                                                         field739.method2019(var26);
                                                      }
                                                   } else if(this.method1208()) {
                                                      this.openMenu(field701, field640);
                                                   } else if(menuOptionCount > 0) {
                                                      var3 = field701;
                                                      var4 = field640;
                                                      WorldMapRegion.method455(class184.topContextMenuRow, var3, var4);
                                                      class184.topContextMenuRow = null;
                                                   }

                                                   mouseCrosshair = 10;
                                                   MouseInput.mouseLastButton = 0;
                                                   class49.field442 = null;
                                                } else if(itemPressedDuration >= 5 && (MouseInput.mouseLastX > field701 + 5 || MouseInput.mouseLastX < field701 - 5 || MouseInput.mouseLastY > field640 + 5 || MouseInput.mouseLastY < field640 - 5)) {
                                                   field704 = true;
                                                }
                                             }

                                             PacketNode var39;
                                             if(Region.method2940()) {
                                                var3 = Region.selectedRegionTileX;
                                                var4 = Region.selectedRegionTileY;
                                                var39 = DecorativeObject.method3115(ClientPacket.field2210, field739.field1250);
                                                var39.packetBuffer.putByte(5);
                                                var39.packetBuffer.method3605(var3 + class178.baseX);
                                                var39.packetBuffer.method3707(var4 + CombatInfoListHolder.baseY);
                                                var39.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
                                                field739.method2019(var39);
                                                Region.method2941();
                                                lastLeftClickX = MouseInput.mouseLastPressedX;
                                                lastLeftClickY = MouseInput.mouseLastPressedY;
                                                cursorState = 1;
                                                field843 = 0;
                                                destinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(var35 != class37.field329) {
                                                if(var35 != null) {
                                                   DState.method3548(var35);
                                                }

                                                if(class37.field329 != null) {
                                                   DState.method3548(class37.field329);
                                                }
                                             }

                                             if(var33 != class7.field42 && field747 == field744) {
                                                if(var33 != null) {
                                                   DState.method3548(var33);
                                                }

                                                if(class7.field42 != null) {
                                                   DState.method3548(class7.field42);
                                                }
                                             }

                                             if(class7.field42 != null) {
                                                if(field747 < field744) {
                                                   ++field747;
                                                   if(field747 == field744) {
                                                      DState.method3548(class7.field42);
                                                   }
                                                }
                                             } else if(field747 > 0) {
                                                --field747;
                                             }

                                             NetWriter.method2030();
                                             if(field746) {
                                                var3 = class13.field99 * 128 + 64;
                                                var4 = class35.field305 * 128 + 64;
                                                var5 = class264.getTileHeight(var3, var4, class192.plane) - class166.field2068;
                                                if(WorldMapType3.cameraX < var3) {
                                                   WorldMapType3.cameraX = (var3 - WorldMapType3.cameraX) * class234.field2801 / 1000 + WorldMapType3.cameraX + class157.field1999;
                                                   if(WorldMapType3.cameraX > var3) {
                                                      WorldMapType3.cameraX = var3;
                                                   }
                                                }

                                                if(WorldMapType3.cameraX > var3) {
                                                   WorldMapType3.cameraX -= class234.field2801 * (WorldMapType3.cameraX - var3) / 1000 + class157.field1999;
                                                   if(WorldMapType3.cameraX < var3) {
                                                      WorldMapType3.cameraX = var3;
                                                   }
                                                }

                                                if(Size.cameraZ < var5) {
                                                   Size.cameraZ = (var5 - Size.cameraZ) * class234.field2801 / 1000 + Size.cameraZ + class157.field1999;
                                                   if(Size.cameraZ > var5) {
                                                      Size.cameraZ = var5;
                                                   }
                                                }

                                                if(Size.cameraZ > var5) {
                                                   Size.cameraZ -= class234.field2801 * (Size.cameraZ - var5) / 1000 + class157.field1999;
                                                   if(Size.cameraZ < var5) {
                                                      Size.cameraZ = var5;
                                                   }
                                                }

                                                if(class13.cameraY < var4) {
                                                   class13.cameraY = (var4 - class13.cameraY) * class234.field2801 / 1000 + class13.cameraY + class157.field1999;
                                                   if(class13.cameraY > var4) {
                                                      class13.cameraY = var4;
                                                   }
                                                }

                                                if(class13.cameraY > var4) {
                                                   class13.cameraY -= class234.field2801 * (class13.cameraY - var4) / 1000 + class157.field1999;
                                                   if(class13.cameraY < var4) {
                                                      class13.cameraY = var4;
                                                   }
                                                }

                                                var3 = class68.field1014 * 128 + 64;
                                                var4 = GrandExchangeEvent.field19 * 128 + 64;
                                                var5 = class264.getTileHeight(var3, var4, class192.plane) - class52.field476;
                                                var6 = var3 - WorldMapType3.cameraX;
                                                var7 = var5 - Size.cameraZ;
                                                var8 = var4 - class13.cameraY;
                                                var9 = (int)Math.sqrt((double)(var6 * var6 + var8 * var8));
                                                var10 = (int)(Math.atan2((double)var7, (double)var9) * 325.949D) & 2047;
                                                int var27 = (int)(Math.atan2((double)var6, (double)var8) * -325.949D) & 2047;
                                                if(var10 < 128) {
                                                   var10 = 128;
                                                }

                                                if(var10 > 383) {
                                                   var10 = 383;
                                                }

                                                if(class146.cameraPitch < var10) {
                                                   class146.cameraPitch = (var10 - class146.cameraPitch) * Tile.field1589 / 1000 + class146.cameraPitch + class98.field1360;
                                                   if(class146.cameraPitch > var10) {
                                                      class146.cameraPitch = var10;
                                                   }
                                                }

                                                if(class146.cameraPitch > var10) {
                                                   class146.cameraPitch -= Tile.field1589 * (class146.cameraPitch - var10) / 1000 + class98.field1360;
                                                   if(class146.cameraPitch < var10) {
                                                      class146.cameraPitch = var10;
                                                   }
                                                }

                                                int var12 = var27 - WidgetNode.cameraYaw;
                                                if(var12 > 1024) {
                                                   var12 -= 2048;
                                                }

                                                if(var12 < -1024) {
                                                   var12 += 2048;
                                                }

                                                if(var12 > 0) {
                                                   WidgetNode.cameraYaw = var12 * Tile.field1589 / 1000 + WidgetNode.cameraYaw + class98.field1360;
                                                   WidgetNode.cameraYaw &= 2047;
                                                }

                                                if(var12 < 0) {
                                                   WidgetNode.cameraYaw -= -var12 * Tile.field1589 / 1000 + class98.field1360;
                                                   WidgetNode.cameraYaw &= 2047;
                                                }

                                                int var13 = var27 - WidgetNode.cameraYaw;
                                                if(var13 > 1024) {
                                                   var13 -= 2048;
                                                }

                                                if(var13 < -1024) {
                                                   var13 += 2048;
                                                }

                                                if(var13 < 0 && var12 > 0 || var13 > 0 && var12 < 0) {
                                                   WidgetNode.cameraYaw = var27;
                                                }
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field765[var3];
                                             }

                                             Permission.varcs.process();
                                             var3 = UrlRequester.method3116();
                                             var4 = WidgetNode.method1076();
                                             if(var3 > 15000 && var4 > 15000) {
                                                field688 = 250;
                                                class59.method1120(14500);
                                                var39 = DecorativeObject.method3115(ClientPacket.field2159, field739.field1250);
                                                field739.method2019(var39);
                                             }

                                             CacheFile.friendManager.method1698();
                                             ++field739.field1252;
                                             if(field739.field1252 > 50) {
                                                var39 = DecorativeObject.method3115(ClientPacket.field2217, field739.field1250);
                                                field739.method2019(var39);
                                             }

                                             try {
                                                field739.method2034();
                                             } catch (IOException var28) {
                                                ChatLineBuffer.method2018();
                                             }

                                             return;
                                          }

                                          var24 = var37.source;
                                          if(var24.index < 0) {
                                             break;
                                          }

                                          var25 = OwnWorldComparator.getWidget(var24.parentId);
                                       } while(var25 == null || var25.children == null || var24.index >= var25.children.length || var24 != var25.children[var24.index]);

                                       FriendManager.method1728(var37);
                                    }
                                 }

                                 var24 = var37.source;
                                 if(var24.index < 0) {
                                    break;
                                 }

                                 var25 = OwnWorldComparator.getWidget(var24.parentId);
                              } while(var25 == null || var25.children == null || var24.index >= var25.children.length || var24 != var25.children[var24.index]);

                              FriendManager.method1728(var37);
                           }
                        }

                        var24 = var37.source;
                        if(var24.index < 0) {
                           break;
                        }

                        var25 = OwnWorldComparator.getWidget(var24.parentId);
                     } while(var25 == null || var25.children == null || var24.index >= var25.children.length || var24 != var25.children[var24.index]);

                     FriendManager.method1728(var37);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-48"
   )
   void method1465() {
      int var1 = class9.canvasWidth;
      int var2 = class37.canvasHeight;
      if(super.field393 < var1) {
         var1 = super.field393;
      }

      if(super.field415 < var2) {
         var2 = super.field415;
      }

      if(ScriptState.preferences != null) {
         try {
            Client var3 = class37.clientInstance;
            int var4 = isResized?2:1;
            Object[] var5 = new Object[]{Integer.valueOf(var4)};
            JSObject.getWindow(var3).call("resize", var5);
         } catch (Throwable var6) {
            ;
         }
      }

   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "251446403"
   )
   final void method1268() {
      if(widgetRoot != -1) {
         WorldMapType2.method498(widgetRoot);
      }

      int var1;
      for(var1 = 0; var1 < widgetCount; ++var1) {
         if(field795[var1]) {
            field796[var1] = true;
         }

         field797[var1] = field795[var1];
         field795[var1] = false;
      }

      field794 = gameCycle;
      field741 = -1;
      field667 = -1;
      FontName.field3688 = null;
      if(widgetRoot != -1) {
         widgetCount = 0;
         class218.method4359(widgetRoot, 0, 0, class9.canvasWidth, class37.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      int var2;
      int var3;
      int var4;
      int var6;
      int var7;
      int var13;
      if(!isMenuOpen) {
         if(field741 != -1) {
            Player.method1178(field741, field667);
         }
      } else {
         var1 = class35.menuX;
         var2 = class59.menuY;
         var3 = class139.field1897;
         var4 = class137.field1888;
         int var14 = 6116423;
         Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, var14);
         Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
         WidgetNode.fontBold12.method5541("Choose Option", var1 + 3, var2 + 14, var14, -1);
         var6 = MouseInput.mouseLastX;
         var7 = MouseInput.mouseLastY;

         int var15;
         int var16;
         for(var13 = 0; var13 < menuOptionCount; ++var13) {
            var15 = var2 + (menuOptionCount - 1 - var13) * 15 + 31;
            var16 = 16777215;
            if(var6 > var1 && var6 < var1 + var3 && var7 > var15 - 13 && var7 < var15 + 3) {
               var16 = 16776960;
            }

            WidgetNode.fontBold12.method5541(class234.method4595(var13), var1 + 3, var15, var16, 0);
         }

         var13 = class35.menuX;
         var15 = class59.menuY;
         var16 = class139.field1897;
         int var17 = class137.field1888;

         for(int var12 = 0; var12 < widgetCount; ++var12) {
            if(widgetPositionX[var12] + widgetBoundsWidth[var12] > var13 && widgetPositionX[var12] < var13 + var16 && widgetPositionY[var12] + widgetBoundsHeight[var12] > var15 && widgetPositionY[var12] < var15 + var17) {
               field796[var12] = true;
            }
         }
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < widgetCount; ++var1) {
            if(field797[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field796[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = class192.plane;
      var2 = MilliTimer.localPlayer.x;
      var3 = MilliTimer.localPlayer.y;
      var4 = field654;

      for(class68 var5 = (class68)class68.field1002.getFront(); var5 != null; var5 = (class68)class68.field1002.getNext()) {
         if(var5.field1004 != -1 || var5.field1008 != null) {
            var6 = 0;
            if(var2 > var5.field1001) {
               var6 += var2 - var5.field1001;
            } else if(var2 < var5.field1000) {
               var6 += var5.field1000 - var2;
            }

            if(var3 > var5.field1005) {
               var6 += var3 - var5.field1005;
            } else if(var3 < var5.field1007) {
               var6 += var5.field1007 - var3;
            }

            if(var6 - 64 <= var5.field1011 && field827 != 0 && var1 == var5.field998) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = (var5.field1011 - var6) * field827 / var5.field1011;
               Object var10000;
               if(var5.field1006 == null) {
                  if(var5.field1004 >= 0) {
                     var10000 = null;
                     SoundEffect var8 = SoundEffect.getTrack(FileOnDisk.indexCache4, var5.field1004, 0);
                     if(var8 != null) {
                        RawAudioNode var9 = var8.method2110().applyResampler(FileSystem.field3166);
                        class103 var10 = class103.method2370(var9, 100, var7);
                        var10.method2318(-1);
                        class141.field1906.method2049(var10);
                        var5.field1006 = var10;
                     }
                  }
               } else {
                  var5.field1006.method2319(var7);
               }

               if(var5.field1010 == null) {
                  if(var5.field1008 != null && (var5.field1009 -= var4) <= 0) {
                     var13 = (int)(Math.random() * (double)var5.field1008.length);
                     var10000 = null;
                     SoundEffect var18 = SoundEffect.getTrack(FileOnDisk.indexCache4, var5.field1008[var13], 0);
                     if(var18 != null) {
                        RawAudioNode var19 = var18.method2110().applyResampler(FileSystem.field3166);
                        class103 var11 = class103.method2370(var19, 100, var7);
                        var11.method2318(0);
                        class141.field1906.method2049(var11);
                        var5.field1010 = var11;
                        var5.field1009 = var5.field997 + (int)(Math.random() * (double)(var5.field1003 - var5.field997));
                     }
                  }
               } else {
                  var5.field1010.method2319(var7);
                  if(!var5.field1010.linked()) {
                     var5.field1010 = null;
                  }
               }
            } else {
               if(var5.field1006 != null) {
                  class141.field1906.method2050(var5.field1006);
                  var5.field1006 = null;
               }

               if(var5.field1010 != null) {
                  class141.field1906.method2050(var5.field1010);
                  var5.field1010 = null;
               }
            }
         }
      }

      field654 = 0;
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(Lcj;I)Z",
      garbageValue = "1530035667"
   )
   final boolean method1572(NetWriter var1) {
      class157 var2 = var1.getSocket();
      PacketBuffer var3 = var1.packetBuffer;
      if(var2 == null) {
         return false;
      } else {
         String var5;
         int var6;
         try {
            if(var1.serverPacket == null) {
               if(var1.field1248) {
                  if(!var2.vmethod3355(1)) {
                     return false;
                  }

                  var2.vmethod3356(var1.packetBuffer.payload, 0, 1);
                  var1.field1249 = 0;
                  var1.field1248 = false;
               }

               var3.offset = 0;
               if(var3.method3869()) {
                  if(!var2.vmethod3355(1)) {
                     return false;
                  }

                  var2.vmethod3356(var1.packetBuffer.payload, 1, 1);
                  var1.field1249 = 0;
               }

               var1.field1248 = true;
               ServerPacket[] var4 = new ServerPacket[]{ServerPacket.field2092, ServerPacket.field2127, ServerPacket.field2082, ServerPacket.field2149, ServerPacket.field2079, ServerPacket.field2076, ServerPacket.field2077, ServerPacket.field2119, ServerPacket.field2074, ServerPacket.field2080, ServerPacket.field2134, ServerPacket.field2071, ServerPacket.field2083, ServerPacket.field2084, ServerPacket.field2085, ServerPacket.field2086, ServerPacket.field2122, ServerPacket.field2088, ServerPacket.field2089, ServerPacket.field2099, ServerPacket.field2091, ServerPacket.field2096, ServerPacket.field2093, ServerPacket.field2094, ServerPacket.field2081, ServerPacket.field2087, ServerPacket.field2097, ServerPacket.field2098, ServerPacket.field2128, ServerPacket.field2100, ServerPacket.field2101, ServerPacket.field2102, ServerPacket.field2103, ServerPacket.field2104, ServerPacket.field2105, ServerPacket.field2106, ServerPacket.field2107, ServerPacket.field2108, ServerPacket.field2109, ServerPacket.field2110, ServerPacket.field2072, ServerPacket.field2112, ServerPacket.field2113, ServerPacket.field2114, ServerPacket.field2115, ServerPacket.field2116, ServerPacket.field2117, ServerPacket.field2118, ServerPacket.field2095, ServerPacket.field2120, ServerPacket.field2151, ServerPacket.field2090, ServerPacket.field2123, ServerPacket.field2124, ServerPacket.field2125, ServerPacket.field2126, ServerPacket.field2073, ServerPacket.field2156, ServerPacket.field2157, ServerPacket.field2130, ServerPacket.field2131, ServerPacket.field2132, ServerPacket.field2133, ServerPacket.field2138, ServerPacket.field2135, ServerPacket.field2136, ServerPacket.field2137, ServerPacket.field2152, ServerPacket.field2139, ServerPacket.field2140, ServerPacket.field2121, ServerPacket.field2142, ServerPacket.field2143, ServerPacket.field2129, ServerPacket.field2145, ServerPacket.field2146, ServerPacket.field2144, ServerPacket.field2078, ServerPacket.field2154, ServerPacket.field2150, ServerPacket.field2075, ServerPacket.field2147, ServerPacket.field2153, ServerPacket.field2148};
               var6 = var3.method3883();
               if(var6 < 0 || var6 >= var4.length) {
                  throw new IOException(var6 + " " + var3.offset);
               }

               var1.serverPacket = var4[var6];
               var1.packetLength = var1.serverPacket.packetLength;
            }

            if(var1.packetLength == -1) {
               if(!var2.vmethod3355(1)) {
                  return false;
               }

               var1.getSocket().vmethod3356(var3.payload, 0, 1);
               var1.packetLength = var3.payload[0] & 255;
            }

            if(var1.packetLength == -2) {
               if(!var2.vmethod3355(2)) {
                  return false;
               }

               var1.getSocket().vmethod3356(var3.payload, 0, 2);
               var3.offset = 0;
               var1.packetLength = var3.readUnsignedShort();
            }

            if(!var2.vmethod3355(var1.packetLength)) {
               return false;
            }

            var3.offset = 0;
            var2.vmethod3356(var3.payload, 0, var1.packetLength);
            var1.field1249 = 0;
            field840.method5255();
            var1.field1253 = var1.field1245;
            var1.field1245 = var1.field1251;
            var1.field1251 = var1.serverPacket;
            if(ServerPacket.field2119 == var1.serverPacket) {
               MessageNode.method1117(class171.field2273);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2117 == var1.serverPacket) {
               MessageNode.method1117(class171.field2267);
               var1.serverPacket = null;
               return true;
            }

            int var7;
            int var8;
            long var9;
            int var23;
            int var24;
            if(ServerPacket.field2157 == var1.serverPacket) {
               var23 = var3.method3613();
               var24 = var3.method3562();
               if(var24 == 65535) {
                  var24 = -1;
               }

               var6 = var3.method3784();
               if(var6 == 65535) {
                  var6 = -1;
               }

               var7 = var3.method3618();

               for(var8 = var6; var8 <= var24; ++var8) {
                  var9 = ((long)var7 << 32) + (long)var8;
                  Node var71 = widgetFlags.get(var9);
                  if(var71 != null) {
                     var71.unlink();
                  }

                  widgetFlags.put(new IntegerNode(var23), var9);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2121 == var1.serverPacket) {
               if(widgetRoot != -1) {
                  class76.method1849(widgetRoot, 0);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2146 == var1.serverPacket) {
               var23 = var3.readUnsignedByte();
               FileRequest.method4623(var23);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2082 == var1.serverPacket) {
               World var66 = new World();
               var66.address = var3.readString();
               var66.id = var3.readUnsignedShort();
               var24 = var3.readInt();
               var66.mask = var24;
               Resampler.setGameState(45);
               var2.vmethod3368();
               var2 = null;
               Friend.changeWorld(var66);
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2136 == var1.serverPacket) {
               MessageNode.method1117(class171.field2269);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2100 == var1.serverPacket) {
               CacheFile.friendManager.ignoreContainer.method5333(var3, var1.packetLength);
               ClientPacket.method3460();
               if(WorldComparator.clanMemberManager != null) {
                  WorldComparator.clanMemberManager.method5498();
               }

               field742 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2103 == var1.serverPacket) {
               MessageNode.method1117(class171.field2272);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2147 == var1.serverPacket) {
               field643 = var3.method3784() * 30;
               field787 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            String var59;
            if(ServerPacket.field2072 == var1.serverPacket) {
               var59 = var3.readString();
               Object[] var68 = new Object[var59.length() + 1];

               for(var6 = var59.length() - 1; var6 >= 0; --var6) {
                  if(var59.charAt(var6) == 's') {
                     var68[var6 + 1] = var3.readString();
                  } else {
                     var68[var6 + 1] = new Integer(var3.readInt());
                  }
               }

               var68[0] = new Integer(var3.readInt());
               ScriptEvent var93 = new ScriptEvent();
               var93.params = var68;
               FriendManager.method1728(var93);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2109 == var1.serverPacket) {
               CacheFile.friendManager.method1665(var3, var1.packetLength);
               field742 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2090 == var1.serverPacket) {
               ScriptEvent.xteaChanged(false, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2114 == var1.serverPacket) {
               GrandExchangeEvent.updateNpcs(false, var3);
               var1.serverPacket = null;
               return true;
            }

            int var10;
            int var12;
            int var14;
            int var15;
            int var18;
            String var27;
            String var76;
            if(ServerPacket.field2080 == var1.serverPacket) {
               var23 = var1.packetLength;
               ClassInfo var67 = new ClassInfo();
               var67.count = var3.readUnsignedByte();
               var67.field3758 = var3.readInt();
               var67.type = new int[var67.count];
               var67.errorIdentifiers = new int[var67.count];
               var67.fields = new Field[var67.count];
               var67.field3757 = new int[var67.count];
               var67.methods = new Method[var67.count];
               var67.args = new byte[var67.count][][];

               for(var6 = 0; var6 < var67.count; ++var6) {
                  try {
                     var7 = var3.readUnsignedByte();
                     if(var7 != 0 && var7 != 1 && var7 != 2) {
                        if(var7 == 3 || var7 == 4) {
                           var76 = var3.readString();
                           var27 = var3.readString();
                           var10 = var3.readUnsignedByte();
                           String[] var70 = new String[var10];

                           for(var12 = 0; var12 < var10; ++var12) {
                              var70[var12] = var3.readString();
                           }

                           String var28 = var3.readString();
                           byte[][] var73 = new byte[var10][];
                           if(var7 == 3) {
                              for(var14 = 0; var14 < var10; ++var14) {
                                 var15 = var3.readInt();
                                 var73[var14] = new byte[var15];
                                 var3.readBytes(var73[var14], 0, var15);
                              }
                           }

                           var67.type[var6] = var7;
                           Class[] var29 = new Class[var10];

                           for(var15 = 0; var15 < var10; ++var15) {
                              var29[var15] = class76.loadClassFromDescriptor(var70[var15]);
                           }

                           Class var89 = class76.loadClassFromDescriptor(var28);
                           if(class76.loadClassFromDescriptor(var76).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var16 = class76.loadClassFromDescriptor(var76).getDeclaredMethods();
                           Method[] var17 = var16;

                           for(var18 = 0; var18 < var17.length; ++var18) {
                              Method var19 = var17[var18];
                              if(Reflection.getMethodName(var19).equals(var27)) {
                                 Class[] var20 = Reflection.getParameterTypes(var19);
                                 if(var29.length == var20.length) {
                                    boolean var21 = true;

                                    for(int var22 = 0; var22 < var29.length; ++var22) {
                                       if(var20[var22] != var29[var22]) {
                                          var21 = false;
                                          break;
                                       }
                                    }

                                    if(var21 && var89 == var19.getReturnType()) {
                                       var67.methods[var6] = var19;
                                    }
                                 }
                              }
                           }

                           var67.args[var6] = var73;
                        }
                     } else {
                        var76 = var3.readString();
                        var27 = var3.readString();
                        var10 = 0;
                        if(var7 == 1) {
                           var10 = var3.readInt();
                        }

                        var67.type[var6] = var7;
                        var67.field3757[var6] = var10;
                        if(class76.loadClassFromDescriptor(var76).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var67.fields[var6] = Reflection.findField(class76.loadClassFromDescriptor(var76), var27);
                     }
                  } catch (ClassNotFoundException var52) {
                     var67.errorIdentifiers[var6] = -1;
                  } catch (SecurityException var53) {
                     var67.errorIdentifiers[var6] = -2;
                  } catch (NullPointerException var54) {
                     var67.errorIdentifiers[var6] = -3;
                  } catch (Exception var55) {
                     var67.errorIdentifiers[var6] = -4;
                  } catch (Throwable var56) {
                     var67.errorIdentifiers[var6] = -5;
                  }
               }

               class313.classInfos.addFirst(var67);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2081 == var1.serverPacket) {
               ScriptEvent.xteaChanged(true, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2079 == var1.serverPacket) {
               var59 = var3.readString();
               var5 = FontTypeFace.appendTags(MouseRecorder.method1089(class59.method1128(var3)));
               OwnWorldComparator.sendGameMessage(6, var59, var5);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2129 == var1.serverPacket) {
               MessageNode.method1117(class171.field2275);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2083 == var1.serverPacket) {
               MessageNode.method1117(class171.field2270);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2143 == var1.serverPacket) {
               MessageNode.field545 = var3.method3597();
               Script.field1219 = var3.method3597();

               while(var3.offset < var1.packetLength) {
                  var23 = var3.readUnsignedByte();
                  class171 var65 = class8.method90()[var23];
                  MessageNode.method1117(var65);
               }

               var1.serverPacket = null;
               return true;
            }

            int var32;
            long var35;
            WidgetNode var97;
            if(ServerPacket.field2133 == var1.serverPacket) {
               var23 = var3.offset + var1.packetLength;
               var24 = var3.readUnsignedShort();
               var6 = var3.readUnsignedShort();
               if(var24 != widgetRoot) {
                  widgetRoot = var24;
                  this.method1210(false);
                  class25.method465(widgetRoot);
                  GrandExchangeOffer.runWidgetOnLoadListener(widgetRoot);

                  for(var7 = 0; var7 < 100; ++var7) {
                     field795[var7] = true;
                  }
               }

               WidgetNode var95;
               for(; var6-- > 0; var95.field500 = true) {
                  var7 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var32 = var3.readUnsignedByte();
                  var95 = (WidgetNode)componentTable.get((long)var7);
                  if(var95 != null && var8 != var95.id) {
                     class21.closeWidget(var95, true);
                     var95 = null;
                  }

                  if(var95 == null) {
                     var95 = class265.method4994(var7, var8, var32);
                  }
               }

               for(var97 = (WidgetNode)componentTable.first(); var97 != null; var97 = (WidgetNode)componentTable.next()) {
                  if(var97.field500) {
                     var97.field500 = false;
                  } else {
                     class21.closeWidget(var97, true);
                  }
               }

               widgetFlags = new HashTable(512);

               while(var3.offset < var23) {
                  var7 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var32 = var3.readUnsignedShort();
                  var10 = var3.readInt();

                  for(int var34 = var8; var34 <= var32; ++var34) {
                     var35 = ((long)var7 << 32) + (long)var34;
                     widgetFlags.put(new IntegerNode(var10), var35);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2110 == var1.serverPacket) {
               Varcs.method1959();
               var1.serverPacket = null;
               return false;
            }

            long var39;
            if(ServerPacket.field2076 == var1.serverPacket) {
               var23 = var3.readInt();
               var24 = var3.readInt();
               var7 = 0;
               if(class76.field1092 == null || !class76.field1092.isValid()) {
                  try {
                     Iterator var85 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var85.hasNext()) {
                        GarbageCollectorMXBean var82 = (GarbageCollectorMXBean)var85.next();
                        if(var82.isValid()) {
                           class76.field1092 = var82;
                           GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                           GameEngine.garbageCollectorLastCollectionTime = -1L;
                        }
                     }
                  } catch (Throwable var51) {
                     ;
                  }
               }

               if(class76.field1092 != null) {
                  long var37 = class166.method3456();
                  var39 = class76.field1092.getCollectionTime();
                  if(GameEngine.garbageCollectorLastCollectionTime != -1L) {
                     var35 = var39 - GameEngine.garbageCollectorLastCollectionTime;
                     long var41 = var37 - GameEngine.garbageCollectorLastCheckTimeMs;
                     if(var41 != 0L) {
                        var7 = (int)(var35 * 100L / var41);
                     }
                  }

                  GameEngine.garbageCollectorLastCollectionTime = var39;
                  GameEngine.garbageCollectorLastCheckTimeMs = var37;
               }

               PacketNode var86 = DecorativeObject.method3115(ClientPacket.field2169, field739.field1250);
               var86.packetBuffer.method3596(var7);
               var86.packetBuffer.method3641(var23);
               var86.packetBuffer.method3750(var24);
               var86.packetBuffer.method3595(GameEngine.FPS);
               field739.method2019(var86);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2098 == var1.serverPacket) {
               var23 = var3.readInt();
               if(var23 != field674) {
                  field674 = var23;
                  if(field678 == 1) {
                     field622 = true;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2130 == var1.serverPacket) {
               var24 = var3.readUnsignedByte();
               class307[] var91 = class151.method3235();
               var7 = 0;

               class307 var62;
               while(true) {
                  if(var7 >= var91.length) {
                     var62 = null;
                     break;
                  }

                  class307 var84 = var91[var7];
                  if(var24 == var84.field3741) {
                     var62 = var84;
                     break;
                  }

                  ++var7;
               }

               WorldMapData.field170 = var62;
               var1.serverPacket = null;
               return true;
            }

            Widget var63;
            if(ServerPacket.field2091 == var1.serverPacket) {
               var23 = var3.readInt();
               var63 = OwnWorldComparator.getWidget(var23);

               for(var6 = 0; var6 < var63.itemIds.length; ++var6) {
                  var63.itemIds[var6] = -1;
                  var63.itemIds[var6] = 0;
               }

               DState.method3548(var63);
               var1.serverPacket = null;
               return true;
            }

            Widget var25;
            boolean var88;
            if(ServerPacket.field2150 == var1.serverPacket) {
               var88 = var3.readUnsignedShortOb1() == 1;
               var24 = var3.method3616();
               var25 = OwnWorldComparator.getWidget(var24);
               if(var88 != var25.isHidden) {
                  var25.isHidden = var88;
                  DState.method3548(var25);
               }

               var1.serverPacket = null;
               return true;
            }

            long var43;
            long var45;
            if(ServerPacket.field2120 == var1.serverPacket) {
               var59 = var3.readString();
               var43 = var3.readLong();
               var45 = (long)var3.readUnsignedShort();
               var9 = (long)var3.read24BitInt();
               Permission var11 = (Permission)class7.forOrdinal(class274.method5249(), var3.readUnsignedByte());
               var35 = (var45 << 32) + var9;
               boolean var75 = false;

               for(var15 = 0; var15 < 100; ++var15) {
                  if(field809[var15] == var35) {
                     var75 = true;
                     break;
                  }
               }

               if(var11.field3136 && CacheFile.friendManager.isIgnored(new Name(var59, WorldMapDecoration.loginType))) {
                  var75 = true;
               }

               if(!var75 && myPlayerIndex == 0) {
                  field809[field830] = var35;
                  field830 = (field830 + 1) % 100;
                  String var30 = FontTypeFace.appendTags(MouseRecorder.method1089(class59.method1128(var3)));
                  if(var11.field3142 != -1) {
                     Signlink.addChatMessage(9, MapIconReference.method687(var11.field3142) + var59, var30, class302.method5659(var43));
                  } else {
                     Signlink.addChatMessage(9, var59, var30, class302.method5659(var43));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2122 == var1.serverPacket) {
               Script.field1219 = var3.method3597();
               MessageNode.field545 = var3.method3597();

               for(var23 = MessageNode.field545; var23 < MessageNode.field545 + 8; ++var23) {
                  for(var24 = Script.field1219; var24 < Script.field1219 + 8; ++var24) {
                     if(groundItemDeque[class192.plane][var23][var24] != null) {
                        groundItemDeque[class192.plane][var23][var24] = null;
                        class171.groundItemSpawned(var23, var24);
                     }
                  }
               }

               for(PendingSpawn var61 = (PendingSpawn)pendingSpawns.getFront(); var61 != null; var61 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var61.x >= MessageNode.field545 && var61.x < MessageNode.field545 + 8 && var61.y >= Script.field1219 && var61.y < Script.field1219 + 8 && var61.level == class192.plane) {
                     var61.hitpoints = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2086 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               var24 = var3.readUnsignedByte();
               var6 = var3.readUnsignedShort();
               if(field768 != 0 && var24 != 0 && queuedSoundEffectCount < 50) {
                  queuedSoundEffectIDs[queuedSoundEffectCount] = var23;
                  unknownSoundValues1[queuedSoundEffectCount] = var24;
                  unknownSoundValues2[queuedSoundEffectCount] = var6;
                  audioEffects[queuedSoundEffectCount] = null;
                  soundLocations[queuedSoundEffectCount] = 0;
                  ++queuedSoundEffectCount;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2127 == var1.serverPacket) {
               var23 = var3.method3676();
               var24 = var3.readInt();
               class225.serverVarps[var23] = var24;
               if(class225.clientVarps[var23] != var24) {
                  class225.clientVarps[var23] = var24;
               }

               Widget.method4537(var23);
               pendingVarbitChanges[++pendingVarbitCount - 1 & 31] = var23;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2135 == var1.serverPacket) {
               field746 = false;

               for(var23 = 0; var23 < 5; ++var23) {
                  field835[var23] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            String var83;
            if(ServerPacket.field2116 == var1.serverPacket) {
               var23 = var3.getUSmart();
               boolean var96 = var3.readUnsignedByte() == 1;
               var83 = "";
               boolean var69 = false;
               if(var96) {
                  var83 = var3.readString();
                  if(CacheFile.friendManager.isIgnored(new Name(var83, WorldMapDecoration.loginType))) {
                     var69 = true;
                  }
               }

               var76 = var3.readString();
               if(!var69) {
                  OwnWorldComparator.sendGameMessage(var23, var83, var76);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2124 == var1.serverPacket) {
               class69.method1749();
               var23 = var3.readUnsignedShortOb1();
               var24 = var3.readUnsignedByte();
               var6 = var3.method3613();
               skillExperiences[var23] = var6;
               boostedSkillLevels[var23] = var24;
               realSkillLevels[var23] = 1;

               for(var7 = 0; var7 < 98; ++var7) {
                  if(var6 >= class234.field2798[var7]) {
                     realSkillLevels[var23] = var7 + 2;
                  }
               }

               changedSkills[++changedSkillsCount - 1 & 31] = var23;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2089 == var1.serverPacket) {
               class13.method125(var3, var1.packetLength);
               if(class8.field53 != null) {
                  field859 = gameCycle;
                  class8.field53.method4793();

                  for(var23 = 0; var23 < cachedPlayers.length; ++var23) {
                     if(cachedPlayers[var23] != null) {
                        class8.field53.method4796((cachedPlayers[var23].x >> 7) + class178.baseX, (cachedPlayers[var23].y >> 7) + CombatInfoListHolder.baseY);
                     }
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2128 == var1.serverPacket) {
               var88 = var3.method3656();
               if(var88) {
                  if(class8.field53 == null) {
                     class8.field53 = new class251();
                  }
               } else {
                  class8.field53 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2085 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               if(var23 == 65535) {
                  var23 = -1;
               }

               if(var23 == -1 && !field825) {
                  class37.method721();
               } else if(var23 != -1 && var23 != field824 && field693 != 0 && !field825) {
                  ClientPacket.method3459(2, MouseInput.indexTrack1, var23, 0, field693, false);
               }

               field824 = var23;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2145 == var1.serverPacket) {
               var23 = var3.method3612();
               var24 = var3.method3784();
               if(var24 == 65535) {
                  var24 = -1;
               }

               FloorUnderlayDefinition.method4879(var24, var23);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2095 == var1.serverPacket) {
               var23 = var3.readUnsignedByte();
               if(var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var23] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var23] = new GrandExchangeOffer(var3, false);
               }

               field785 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2138 == var1.serverPacket) {
               var3.offset += 28;
               if(var3.checkCrc()) {
                  class76.method1852(var3, var3.offset - 28);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2104 == var1.serverPacket) {
               field746 = true;
               class68.field1014 = var3.readUnsignedByte();
               GrandExchangeEvent.field19 = var3.readUnsignedByte();
               class52.field476 = var3.readUnsignedShort();
               class98.field1360 = var3.readUnsignedByte();
               Tile.field1589 = var3.readUnsignedByte();
               if(Tile.field1589 >= 100) {
                  var23 = class68.field1014 * 128 + 64;
                  var24 = GrandExchangeEvent.field19 * 128 + 64;
                  var6 = class264.getTileHeight(var23, var24, class192.plane) - class52.field476;
                  var7 = var23 - WorldMapType3.cameraX;
                  var8 = var6 - Size.cameraZ;
                  var32 = var24 - class13.cameraY;
                  var10 = (int)Math.sqrt((double)(var7 * var7 + var32 * var32));
                  class146.cameraPitch = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
                  WidgetNode.cameraYaw = (int)(Math.atan2((double)var7, (double)var32) * -325.949D) & 2047;
                  if(class146.cameraPitch < 128) {
                     class146.cameraPitch = 128;
                  }

                  if(class146.cameraPitch > 383) {
                     class146.cameraPitch = 383;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2093 == var1.serverPacket) {
               CacheFile.friendManager.method1664();
               field742 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2077 == var1.serverPacket) {
               MessageNode.method1117(class171.field2271);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2112 == var1.serverPacket) {
               MessageNode.method1117(class171.field2268);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2115 == var1.serverPacket) {
               var23 = var3.method3616();
               var24 = var3.method3604();
               var25 = OwnWorldComparator.getWidget(var23);
               if(var24 != var25.field2670 || var24 == -1) {
                  var25.field2670 = var24;
                  var25.field2746 = 0;
                  var25.field2718 = 0;
                  DState.method3548(var25);
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var31;
            if(ServerPacket.field2132 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               var24 = var3.method3618();
               var6 = var3.readUnsignedShort();
               var31 = OwnWorldComparator.getWidget(var24);
               var31.field2661 = var6 + (var23 << 16);
               var1.serverPacket = null;
               return true;
            }

            Widget var79;
            if(ServerPacket.field2149 == var1.serverPacket) {
               var23 = var3.method3613();
               var24 = var3.readInt();
               WidgetNode var87 = (WidgetNode)componentTable.get((long)var23);
               var97 = (WidgetNode)componentTable.get((long)var24);
               if(var97 != null) {
                  class21.closeWidget(var97, var87 == null || var97.id != var87.id);
               }

               if(var87 != null) {
                  var87.unlink();
                  componentTable.put(var87, (long)var24);
               }

               var79 = OwnWorldComparator.getWidget(var23);
               if(var79 != null) {
                  DState.method3548(var79);
               }

               var79 = OwnWorldComparator.getWidget(var24);
               if(var79 != null) {
                  DState.method3548(var79);
                  class45.method818(Widget.widgets[var79.id >>> 16], var79, true);
               }

               if(widgetRoot != -1) {
                  class76.method1849(widgetRoot, 1);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2105 == var1.serverPacket) {
               Script.field1219 = var3.readUnsignedByte();
               MessageNode.field545 = var3.readUnsignedShortOb1();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2152 == var1.serverPacket) {
               for(var23 = 0; var23 < class225.clientVarps.length; ++var23) {
                  if(class225.clientVarps[var23] != class225.serverVarps[var23]) {
                     class225.clientVarps[var23] = class225.serverVarps[var23];
                     Widget.method4537(var23);
                     pendingVarbitChanges[++pendingVarbitCount - 1 & 31] = var23;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2071 == var1.serverPacket) {
               field746 = true;
               class13.field99 = var3.readUnsignedByte();
               class35.field305 = var3.readUnsignedByte();
               class166.field2068 = var3.readUnsignedShort();
               class157.field1999 = var3.readUnsignedByte();
               class234.field2801 = var3.readUnsignedByte();
               if(class234.field2801 >= 100) {
                  WorldMapType3.cameraX = class13.field99 * 128 + 64;
                  class13.cameraY = class35.field305 * 128 + 64;
                  Size.cameraZ = class264.getTileHeight(WorldMapType3.cameraX, class13.cameraY, class192.plane) - class166.field2068;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2118 == var1.serverPacket) {
               var23 = var3.method3676();
               widgetRoot = var23;
               this.method1210(false);
               class25.method465(var23);
               GrandExchangeOffer.runWidgetOnLoadListener(widgetRoot);

               for(var24 = 0; var24 < 100; ++var24) {
                  field795[var24] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2156 == var1.serverPacket) {
               var23 = var3.method3613();
               var24 = var3.method3784();
               var6 = var24 >> 10 & 31;
               var7 = var24 >> 5 & 31;
               var8 = var24 & 31;
               var32 = (var7 << 11) + (var6 << 19) + (var8 << 3);
               Widget var33 = OwnWorldComparator.getWidget(var23);
               if(var32 != var33.textColor) {
                  var33.textColor = var32;
                  DState.method3548(var33);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2142 == var1.serverPacket) {
               var23 = var3.method3784();
               class137.method3148(var23);
               interfaceItemTriggers[++field779 - 1 & 31] = var23 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2084 == var1.serverPacket) {
               var23 = var3.readUnsignedByte();
               var24 = var3.readUnsignedByte();
               var6 = var3.readUnsignedByte();
               var7 = var3.readUnsignedByte();
               field835[var23] = true;
               field836[var23] = var24;
               field837[var23] = var6;
               field855[var23] = var7;
               field765[var23] = 0;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2108 == var1.serverPacket) {
               var23 = var3.method3676();
               var24 = var3.method3616();
               var6 = var3.method3676();
               var7 = var3.method3784();
               var79 = OwnWorldComparator.getWidget(var24);
               if(var7 != var79.rotationX || var23 != var79.rotationZ || var6 != var79.modelZoom) {
                  var79.rotationX = var7;
                  var79.rotationZ = var23;
                  var79.modelZoom = var6;
                  DState.method3548(var79);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2101 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               var24 = var3.method3618();
               var25 = OwnWorldComparator.getWidget(var24);
               if(var25.modelType != 1 || var23 != var25.modelId) {
                  var25.modelType = 1;
                  var25.modelId = var23;
                  DState.method3548(var25);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2099 == var1.serverPacket) {
               var88 = var3.readUnsignedByte() == 1;
               if(var88) {
                  field629 = class166.method3456() - var3.readLong();
                  class173.grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  class173.grandExchangeEvents = null;
               }

               field789 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2125 == var1.serverPacket) {
               GrandExchangeEvent.updateNpcs(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2107 == var1.serverPacket) {
               if(var1.packetLength == 0) {
                  WorldComparator.clanMemberManager = null;
               } else {
                  if(WorldComparator.clanMemberManager == null) {
                     WorldComparator.clanMemberManager = new ClanMemberManager(WorldMapDecoration.loginType, class37.clientInstance);
                  }

                  WorldComparator.clanMemberManager.method5507(var3);
               }

               field784 = cycleCntr;
               WorldMapType2.field245 = true;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2088 == var1.serverPacket) {
               class69.method1749();
               weight = var3.readShort();
               field787 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2092 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               var24 = var3.method3618();
               var25 = OwnWorldComparator.getWidget(var24);
               if(var25 != null && var25.type == 0) {
                  if(var23 > var25.scrollHeight - var25.height) {
                     var23 = var25.scrollHeight - var25.height;
                  }

                  if(var23 < 0) {
                     var23 = 0;
                  }

                  if(var23 != var25.scrollY) {
                     var25.scrollY = var23;
                     DState.method3548(var25);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2154 == var1.serverPacket) {
               class69.method1749();
               energy = var3.readUnsignedByte();
               field787 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2106 == var1.serverPacket) {
               MessageNode.method1117(class171.field2276);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2134 == var1.serverPacket) {
               var23 = var3.readInt();
               WidgetNode var64 = (WidgetNode)componentTable.get((long)var23);
               if(var64 != null) {
                  class21.closeWidget(var64, true);
               }

               if(field756 != null) {
                  DState.method3548(field756);
                  field756 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2102 == var1.serverPacket) {
               var23 = var3.method3618();
               var5 = var3.readString();
               var25 = OwnWorldComparator.getWidget(var23);
               if(!var5.equals(var25.text)) {
                  var25.text = var5;
                  DState.method3548(var25);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2075 == var1.serverPacket) {
               var23 = var3.method3613();
               var63 = OwnWorldComparator.getWidget(var23);
               var63.modelType = 3;
               var63.modelId = MilliTimer.localPlayer.composition.method4493();
               DState.method3548(var63);
               var1.serverPacket = null;
               return true;
            }

            int var47;
            if(ServerPacket.field2151 == var1.serverPacket) {
               var59 = var3.readString();
               var43 = (long)var3.readUnsignedShort();
               var45 = (long)var3.read24BitInt();
               Permission var81 = (Permission)class7.forOrdinal(class274.method5249(), var3.readUnsignedByte());
               var39 = var45 + (var43 << 32);
               boolean var72 = false;

               for(var47 = 0; var47 < 100; ++var47) {
                  if(var39 == field809[var47]) {
                     var72 = true;
                     break;
                  }
               }

               if(CacheFile.friendManager.isIgnored(new Name(var59, WorldMapDecoration.loginType))) {
                  var72 = true;
               }

               if(!var72 && myPlayerIndex == 0) {
                  field809[field830] = var39;
                  field830 = (field830 + 1) % 100;
                  String var13 = FontTypeFace.appendTags(MouseRecorder.method1089(class59.method1128(var3)));
                  byte var74;
                  if(var81.field3143) {
                     var74 = 7;
                  } else {
                     var74 = 3;
                  }

                  if(var81.field3142 != -1) {
                     OwnWorldComparator.sendGameMessage(var74, MapIconReference.method687(var81.field3142) + var59, var13);
                  } else {
                     OwnWorldComparator.sendGameMessage(var74, var59, var13);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2144 == var1.serverPacket) {
               var59 = var3.readString();
               var24 = var3.method3597();
               var6 = var3.method3597();
               if(var24 >= 1 && var24 <= 8) {
                  if(var59.equalsIgnoreCase("null")) {
                     var59 = null;
                  }

                  playerOptions[var24 - 1] = var59;
                  playerOptionsPriorities[var24 - 1] = var6 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2153 == var1.serverPacket) {
               destinationX = var3.readUnsignedByte();
               if(destinationX == 255) {
                  destinationX = 0;
               }

               destinationY = var3.readUnsignedByte();
               if(destinationY == 255) {
                  destinationY = 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2140 == var1.serverPacket) {
               byte var77 = var3.readByte();
               var24 = var3.readUnsignedShort();
               class225.serverVarps[var24] = var77;
               if(class225.clientVarps[var24] != var77) {
                  class225.clientVarps[var24] = var77;
               }

               Widget.method4537(var24);
               pendingVarbitChanges[++pendingVarbitCount - 1 & 31] = var24;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2113 == var1.serverPacket) {
               for(var23 = 0; var23 < cachedPlayers.length; ++var23) {
                  if(cachedPlayers[var23] != null) {
                     cachedPlayers[var23].animation = -1;
                  }
               }

               for(var23 = 0; var23 < cachedNPCs.length; ++var23) {
                  if(cachedNPCs[var23] != null) {
                     cachedNPCs[var23].animation = -1;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2074 == var1.serverPacket) {
               var23 = var3.method3616();
               var24 = var3.method3562();
               var6 = var3.method3553();
               var97 = (WidgetNode)componentTable.get((long)var23);
               if(var97 != null) {
                  class21.closeWidget(var97, var24 != var97.id);
               }

               class265.method4994(var23, var24, var6);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2097 == var1.serverPacket) {
               hintArrowTargetType = var3.readUnsignedByte();
               if(hintArrowTargetType == 1) {
                  hintArrowNpcTargetIdx = var3.readUnsignedShort();
               }

               if(hintArrowTargetType >= 2 && hintArrowTargetType <= 6) {
                  if(hintArrowTargetType == 2) {
                     hintArrowOffsetX = 64;
                     hintArrowOffsetY = 64;
                  }

                  if(hintArrowTargetType == 3) {
                     hintArrowOffsetX = 0;
                     hintArrowOffsetY = 64;
                  }

                  if(hintArrowTargetType == 4) {
                     hintArrowOffsetX = 128;
                     hintArrowOffsetY = 64;
                  }

                  if(hintArrowTargetType == 5) {
                     hintArrowOffsetX = 64;
                     hintArrowOffsetY = 0;
                  }

                  if(hintArrowTargetType == 6) {
                     hintArrowOffsetX = 64;
                     hintArrowOffsetY = 128;
                  }

                  hintArrowTargetType = 2;
                  hintArrowX = var3.readUnsignedShort();
                  hintArrowY = var3.readUnsignedShort();
                  hintArrowOffsetZ = var3.readUnsignedByte();
               }

               if(hintArrowTargetType == 10) {
                  hintArrowPlayerTargetIdx = var3.readUnsignedShort();
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2096 == var1.serverPacket) {
               var23 = var3.readInt();
               var24 = var3.readShort();
               var6 = var3.method3609();
               var31 = OwnWorldComparator.getWidget(var23);
               if(var6 != var31.originalX || var24 != var31.originalY || var31.dynamicX != 0 || var31.dynamicY != 0) {
                  var31.originalX = var6;
                  var31.originalY = var24;
                  var31.dynamicX = 0;
                  var31.dynamicY = 0;
                  DState.method3548(var31);
                  this.widgetMethod0(var31);
                  if(var31.type == 0) {
                     class45.method818(Widget.widgets[var23 >> 16], var31, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2131 == var1.serverPacket) {
               var59 = var3.readString();
               SoundTaskDataProvider.sessionToken = var59;

               try {
                  var5 = class37.clientInstance.getParameter(Parameters.field3609.key);
                  var83 = class37.clientInstance.getParameter(Parameters.field3610.key);
                  String var94 = var5 + "settings=" + var59 + "; version=1; path=/; domain=" + var83;
                  if(var59.length() == 0) {
                     var94 = var94 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var76 = var94 + "; Expires=";
                     var39 = class166.method3456() + 94608000000L;
                     class192.field2418.setTime(new Date(var39));
                     var12 = class192.field2418.get(7);
                     var47 = class192.field2418.get(5);
                     var14 = class192.field2418.get(2);
                     var15 = class192.field2418.get(1);
                     int var48 = class192.field2418.get(11);
                     int var49 = class192.field2418.get(12);
                     var18 = class192.field2418.get(13);
                     var27 = class192.field2414[var12 - 1] + ", " + var47 / 10 + var47 % 10 + "-" + class192.field2417[0][var14] + "-" + var15 + " " + var48 / 10 + var48 % 10 + ":" + var49 / 10 + var49 % 10 + ":" + var18 / 10 + var18 % 10 + " GMT";
                     var94 = var76 + var27 + "; Max-Age=" + 94608000L;
                  }

                  Client var78 = class37.clientInstance;
                  var27 = "document.cookie=\"" + var94 + "\"";
                  JSObject.getWindow(var78).eval(var27);
               } catch (Throwable var50) {
                  ;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2123 == var1.serverPacket) {
               MessageNode.method1117(class171.field2274);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2087 == var1.serverPacket) {
               var23 = var3.method3618();
               var24 = var3.method3562();
               var25 = OwnWorldComparator.getWidget(var23);
               if(var25.modelType != 2 || var24 != var25.modelId) {
                  var25.modelType = 2;
                  var25.modelId = var24;
                  DState.method3548(var25);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2094 == var1.serverPacket) {
               for(var23 = 0; var23 < VarPlayerType.field3251; ++var23) {
                  VarPlayerType var80 = (VarPlayerType)VarPlayerType.varplayers.get((long)var23);
                  VarPlayerType var60;
                  if(var80 != null) {
                     var60 = var80;
                  } else {
                     byte[] var92 = VarPlayerType.varplayer_ref.getConfigData(16, var23);
                     var80 = new VarPlayerType();
                     if(var92 != null) {
                        var80.decode(new Buffer(var92));
                     }

                     VarPlayerType.varplayers.put(var80, (long)var23);
                     var60 = var80;
                  }

                  if(var60 != null) {
                     class225.serverVarps[var23] = 0;
                     class225.clientVarps[var23] = 0;
                  }
               }

               class69.method1749();
               pendingVarbitCount += 32;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2126 == var1.serverPacket) {
               if(WorldComparator.clanMemberManager != null) {
                  WorldComparator.clanMemberManager.method5496(var3);
               }

               field784 = cycleCntr;
               WorldMapType2.field245 = true;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2137 == var1.serverPacket) {
               field822 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2073 == var1.serverPacket) {
               var23 = var3.readInt();
               var24 = var3.readUnsignedShort();
               if(var23 < -70000) {
                  var24 += 32768;
               }

               if(var23 >= 0) {
                  var25 = OwnWorldComparator.getWidget(var23);
               } else {
                  var25 = null;
               }

               if(var25 != null) {
                  for(var7 = 0; var7 < var25.itemIds.length; ++var7) {
                     var25.itemIds[var7] = 0;
                     var25.itemQuantities[var7] = 0;
                  }
               }

               ItemContainer var90 = (ItemContainer)ItemContainer.itemContainers.get((long)var24);
               if(var90 != null) {
                  for(var8 = 0; var8 < var90.itemIds.length; ++var8) {
                     var90.itemIds[var8] = -1;
                     var90.stackSizes[var8] = 0;
                  }
               }

               var7 = var3.readUnsignedShort();

               for(var8 = 0; var8 < var7; ++var8) {
                  var32 = var3.method3553();
                  if(var32 == 255) {
                     var32 = var3.readInt();
                  }

                  var10 = var3.method3784();
                  if(var25 != null && var8 < var25.itemIds.length) {
                     var25.itemIds[var8] = var10;
                     var25.itemQuantities[var8] = var32;
                  }

                  class159.setItemTableSlot(var24, var8, var10 - 1, var32);
               }

               if(var25 != null) {
                  DState.method3548(var25);
               }

               class69.method1749();
               interfaceItemTriggers[++field779 - 1 & 31] = var24 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2078 == var1.serverPacket) {
               publicChatMode = var3.readUnsignedByte();
               field694 = var3.method3553();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2139 == var1.serverPacket) {
               var23 = var3.readInt();
               var24 = var3.readUnsignedShort();
               if(var23 < -70000) {
                  var24 += 32768;
               }

               if(var23 >= 0) {
                  var25 = OwnWorldComparator.getWidget(var23);
               } else {
                  var25 = null;
               }

               for(; var3.offset < var1.packetLength; class159.setItemTableSlot(var24, var7, var8 - 1, var32)) {
                  var7 = var3.getUSmart();
                  var8 = var3.readUnsignedShort();
                  var32 = 0;
                  if(var8 != 0) {
                     var32 = var3.readUnsignedByte();
                     if(var32 == 255) {
                        var32 = var3.readInt();
                     }
                  }

                  if(var25 != null && var7 >= 0 && var7 < var25.itemIds.length) {
                     var25.itemIds[var7] = var8;
                     var25.itemQuantities[var7] = var32;
                  }
               }

               if(var25 != null) {
                  DState.method3548(var25);
               }

               class69.method1749();
               interfaceItemTriggers[++field779 - 1 & 31] = var24 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2148 == var1.serverPacket) {
               var23 = var3.method3618();
               var24 = var3.method3613();
               var6 = var3.method3562();
               if(var6 == 65535) {
                  var6 = -1;
               }

               var31 = OwnWorldComparator.getWidget(var24);
               ItemComposition var26;
               if(!var31.hasScript) {
                  if(var6 == -1) {
                     var31.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var26 = class120.getItemDefinition(var6);
                  var31.modelType = 4;
                  var31.modelId = var6;
                  var31.rotationX = var26.xan2d;
                  var31.rotationZ = var26.yan2d;
                  var31.modelZoom = var26.zoom2d * 100 / var23;
                  DState.method3548(var31);
               } else {
                  var31.itemId = var6;
                  var31.itemQuantity = var23;
                  var26 = class120.getItemDefinition(var6);
                  var31.rotationX = var26.xan2d;
                  var31.rotationZ = var26.yan2d;
                  var31.rotationY = var26.zan2d;
                  var31.offsetX2d = var26.offsetX2d;
                  var31.offsetY2d = var26.offsetY2d;
                  var31.modelZoom = var26.zoom2d;
                  if(var26.isStackable == 1) {
                     var31.field2645 = 1;
                  } else {
                     var31.field2645 = 2;
                  }

                  if(var31.field2678 > 0) {
                     var31.modelZoom = var31.modelZoom * 32 / var31.field2678;
                  } else if(var31.originalWidth > 0) {
                     var31.modelZoom = var31.modelZoom * 32 / var31.originalWidth;
                  }

                  DState.method3548(var31);
               }

               var1.serverPacket = null;
               return true;
            }

            class43.processClientError("" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1245 != null?var1.field1245.packetId:-1) + "," + (var1.field1253 != null?var1.field1253.packetId:-1) + "," + var1.packetLength, (Throwable)null);
            Varcs.method1959();
         } catch (IOException var57) {
            ChatLineBuffer.method2018();
         } catch (Exception var58) {
            var5 = "" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1245 != null?var1.field1245.packetId:-1) + "," + (var1.field1253 != null?var1.field1253.packetId:-1) + "," + var1.packetLength + "," + (MilliTimer.localPlayer.pathX[0] + class178.baseX) + "," + (MilliTimer.localPlayer.pathY[0] + CombatInfoListHolder.baseY) + ",";

            for(var6 = 0; var6 < var1.packetLength && var6 < 50; ++var6) {
               var5 = var5 + var3.payload[var6] + ",";
            }

            class43.processClientError(var5, var58);
            Varcs.method1959();
         }

         return true;
      }
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "199992128"
   )
   final void method1207() {
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
               boolean var6 = menuBooleanArray[var2];
               menuBooleanArray[var2] = menuBooleanArray[var2 + 1];
               menuBooleanArray[var2 + 1] = var6;
               var1 = false;
            }
         }
      }

      if(class49.field442 == null) {
         if(draggedWidget == null) {
            int var9;
            int var20;
            int var21;
            label275: {
               int var19 = MouseInput.mouseLastButton;
               int var7;
               int var15;
               if(isMenuOpen) {
                  int var14;
                  if(var19 != 1 && (class8.middleMouseMovesCamera || var19 != 4)) {
                     var2 = MouseInput.mouseLastX;
                     var14 = MouseInput.mouseLastY;
                     if(var2 < class35.menuX - 10 || var2 > class139.field1897 + class35.menuX + 10 || var14 < class59.menuY - 10 || var14 > class59.menuY + class137.field1888 + 10) {
                        isMenuOpen = false;
                        class34.method626(class35.menuX, class59.menuY, class139.field1897, class137.field1888);
                     }
                  }

                  if(var19 == 1 || !class8.middleMouseMovesCamera && var19 == 4) {
                     var2 = class35.menuX;
                     var14 = class59.menuY;
                     var15 = class139.field1897;
                     var5 = MouseInput.mouseLastPressedX;
                     var20 = MouseInput.mouseLastPressedY;
                     var7 = -1;

                     for(var21 = 0; var21 < menuOptionCount; ++var21) {
                        var9 = var14 + (menuOptionCount - 1 - var21) * 15 + 31;
                        if(var5 > var2 && var5 < var2 + var15 && var20 > var9 - 13 && var20 < var9 + 3) {
                           var7 = var21;
                        }
                     }

                     if(var7 != -1 && var7 >= 0) {
                        var21 = menuActionParams0[var7];
                        var9 = menuActionParams1[var7];
                        int var10 = menuTypes[var7];
                        int var11 = menuIdentifiers[var7];
                        String var12 = menuOptions[var7];
                        String var13 = menuTargets[var7];
                        FileOnDisk.menuAction(var21, var9, var10, var11, var12, var13, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                     }

                     isMenuOpen = false;
                     class34.method626(class35.menuX, class59.menuY, class139.field1897, class137.field1888);
                  }
               } else {
                  var2 = menuOptionCount - 1;
                  if((var19 == 1 || !class8.middleMouseMovesCamera && var19 == 4) && var2 >= 0) {
                     var15 = menuTypes[var2];
                     if(var15 == 39 || var15 == 40 || var15 == 41 || var15 == 42 || var15 == 43 || var15 == 33 || var15 == 34 || var15 == 35 || var15 == 36 || var15 == 37 || var15 == 38 || var15 == 1005) {
                        var5 = menuActionParams0[var2];
                        var20 = menuActionParams1[var2];
                        Widget var16 = OwnWorldComparator.getWidget(var20);
                        if(Coordinates.method4482(AbstractSoundSystem.getWidgetClickMask(var16))) {
                           break label275;
                        }

                        var9 = AbstractSoundSystem.getWidgetClickMask(var16);
                        boolean var8 = (var9 >> 29 & 1) != 0;
                        if(var8) {
                           break label275;
                        }
                     }
                  }

                  if((var19 == 1 || !class8.middleMouseMovesCamera && var19 == 4) && this.method1208()) {
                     var19 = 2;
                  }

                  if((var19 == 1 || !class8.middleMouseMovesCamera && var19 == 4) && menuOptionCount > 0 && var2 >= 0) {
                     var15 = menuActionParams0[var2];
                     var5 = menuActionParams1[var2];
                     var20 = menuTypes[var2];
                     var7 = menuIdentifiers[var2];
                     String var17 = menuOptions[var2];
                     String var18 = menuTargets[var2];
                     FileOnDisk.menuAction(var15, var5, var20, var7, var17, var18, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                  }

                  if(var19 == 2 && menuOptionCount > 0) {
                     this.openMenu(MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                  }
               }

               return;
            }

            if(class49.field442 != null && !field704 && menuOptionCount > 0 && !this.method1208()) {
               var21 = field701;
               var9 = field640;
               WorldMapRegion.method455(class184.topContextMenuRow, var21, var9);
               class184.topContextMenuRow = null;
            }

            field704 = false;
            itemPressedDuration = 0;
            if(class49.field442 != null) {
               DState.method3548(class49.field442);
            }

            class49.field442 = OwnWorldComparator.getWidget(var20);
            field597 = var5;
            field701 = MouseInput.mouseLastPressedX;
            field640 = MouseInput.mouseLastPressedY;
            if(var2 >= 0) {
               class184.topContextMenuRow = new ContextMenuRow();
               class184.topContextMenuRow.param0 = menuActionParams0[var2];
               class184.topContextMenuRow.param1 = menuActionParams1[var2];
               class184.topContextMenuRow.type = menuTypes[var2];
               class184.topContextMenuRow.identifier = menuIdentifiers[var2];
               class184.topContextMenuRow.option = menuOptions[var2];
            }

            DState.method3548(class49.field442);
         }
      }
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "16776960"
   )
   final boolean method1208() {
      int var1 = menuOptionCount - 1;
      boolean var3 = field727 == 1 && menuOptionCount > 2;
      if(!var3) {
         boolean var4;
         if(var1 < 0) {
            var4 = false;
         } else {
            int var5 = menuTypes[var1];
            if(var5 >= 2000) {
               var5 -= 2000;
            }

            if(var5 == 1007) {
               var4 = true;
            } else {
               var4 = false;
            }
         }

         var3 = var4;
      }

      return var3 && !menuBooleanArray[var1];
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-624694385"
   )
   @Export("openMenu")
   @Hook("menuOpened")
   final void openMenu(int var1, int var2) {
      class24.method463(var1, var2);
      ScriptEvent.region.method2938(class192.plane, var1, var2, false);
      isMenuOpen = true;
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-73"
   )
   final void method1210(boolean var1) {
      MapIcon.method515(widgetRoot, class9.canvasWidth, class37.canvasHeight, var1);
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(Lhl;I)V",
      garbageValue = "-46250492"
   )
   @Export("widgetMethod0")
   void widgetMethod0(Widget var1) {
      Widget var2 = var1.parentId == -1?null:OwnWorldComparator.getWidget(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = class9.canvasWidth;
         var4 = class37.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class138.method3155(var1, var3, var4, false);
      class45.method820(var1, var3, var4);
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   final void method1238() {
      DState.method3548(draggedWidget);
      ++DecorativeObject.field1860;
      if(field860 && field594) {
         int var1 = MouseInput.mouseLastX;
         int var2 = MouseInput.mouseLastY;
         var1 -= field685;
         var2 -= field766;
         if(var1 < field769) {
            var1 = field769;
         }

         if(var1 + draggedWidget.width > field769 + field639.width) {
            var1 = field769 + field639.width - draggedWidget.width;
         }

         if(var2 < field770) {
            var2 = field770;
         }

         if(var2 + draggedWidget.height > field770 + field639.height) {
            var2 = field770 + field639.height - draggedWidget.height;
         }

         int var3 = var1 - field772;
         int var4 = var2 - field773;
         int var5 = draggedWidget.dragDeadZone;
         if(DecorativeObject.field1860 > draggedWidget.dragDeadTime && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            draggingWidget = true;
         }

         int var6 = var1 - field769 + field639.scrollX;
         int var7 = var2 - field770 + field639.scrollY;
         ScriptEvent var8;
         if(draggedWidget.onDragListener != null && draggingWidget) {
            var8 = new ScriptEvent();
            var8.source = draggedWidget;
            var8.mouseX = var6;
            var8.mouseY = var7;
            var8.params = draggedWidget.onDragListener;
            FriendManager.method1728(var8);
         }

         if(MouseInput.mouseCurrentButton == 0) {
            if(draggingWidget) {
               if(draggedWidget.onDragCompleteListener != null) {
                  var8 = new ScriptEvent();
                  var8.source = draggedWidget;
                  var8.mouseX = var6;
                  var8.mouseY = var7;
                  var8.target = draggedOnWidget;
                  var8.params = draggedWidget.onDragCompleteListener;
                  FriendManager.method1728(var8);
               }

               if(draggedOnWidget != null) {
                  Widget var9 = draggedWidget;
                  int var10 = PlayerComposition.method4514(AbstractSoundSystem.getWidgetClickMask(var9));
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

                        var9 = OwnWorldComparator.getWidget(var9.parentId);
                        if(var9 == null) {
                           var15 = null;
                           break;
                        }

                        ++var11;
                     }
                  }

                  if(var15 != null) {
                     PacketNode var12 = DecorativeObject.method3115(ClientPacket.field2227, field739.field1250);
                     var12.packetBuffer.method3707(draggedWidget.itemId);
                     var12.packetBuffer.method3605(draggedOnWidget.itemId);
                     var12.packetBuffer.method3641(draggedWidget.id);
                     var12.packetBuffer.method3670(draggedOnWidget.id);
                     var12.packetBuffer.putShort(draggedOnWidget.index);
                     var12.packetBuffer.method3725(draggedWidget.index);
                     field739.method2019(var12);
                  }
               }
            } else if(this.method1208()) {
               this.openMenu(field772 + field685, field766 + field773);
            } else if(menuOptionCount > 0) {
               int var13 = field685 + field772;
               int var14 = field766 + field773;
               WorldMapRegion.method455(class184.topContextMenuRow, var13, var14);
               class184.topContextMenuRow = null;
            }

            draggedWidget = null;
         }

      } else {
         if(DecorativeObject.field1860 > 1) {
            draggedWidget = null;
         }

      }
   }

   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      signature = "(I)Lkm;",
      garbageValue = "-554888244"
   )
   public Name vmethod5443() {
      return MilliTimer.localPlayer != null?MilliTimer.localPlayer.name:null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Liv;Liv;I)V",
      garbageValue = "38640891"
   )
   public static void method1576(IndexDataBase var0, IndexDataBase var1) {
      Spotanim.SpotAnimationDefinition_indexCache = var0;
      Varcs.SpotAnimationDefinition_modelIndexCache = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "107"
   )
   public static int method1577(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-491722597"
   )
   static void method1525() {
      class81.playerIndexesCount = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class81.field1179[var0] = null;
         class81.field1177[var0] = 1;
      }

   }
}
