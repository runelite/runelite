import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class33 {
   @ObfuscatedName("g")
   static ModIcon field743;
   @ObfuscatedName("n")
   static ModIcon[] field744;
   @ObfuscatedName("u")
   static SpritePixels field745;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -653651481
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1496051571
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 247163179
   )
   static int field748;
   @ObfuscatedName("av")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 142084663
   )
   static int field750;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 895096893
   )
   static int field751;
   @ObfuscatedName("au")
   static String field752;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1346291909
   )
   static int field753;
   @ObfuscatedName("o")
   static int[] field754;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1967419903
   )
   static int field755 = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1359994285
   )
   static int field756;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -394429903
   )
   static int field757;
   @ObfuscatedName("i")
   static boolean field758;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1511298149
   )
   static int field759;
   @ObfuscatedName("ar")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("aw")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("ah")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ao")
   @Export("username")
   static String username;
   @ObfuscatedName("ax")
   static String field764;
   @ObfuscatedName("ac")
   static class162 field765;
   @ObfuscatedName("aa")
   static boolean field766;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1399458301
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("x")
   static int[] field768;
   @ObfuscatedName("ag")
   static String field769;
   @ObfuscatedName("m")
   static ModIcon[] field770;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1759532283
   )
   static int field771;

   static {
      loginWindowX = field755 + 202;
      field768 = new int[256];
      field750 = 0;
      field751 = 0;
      field757 = 0;
      field753 = 0;
      field748 = 0;
      field759 = 0;
      field756 = 10;
      field769 = "";
      loginIndex = 0;
      field752 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      field764 = "";
      field765 = class162.field2646;
      field766 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field771 = -1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "49975394"
   )
   static boolean method712(String var0, int var1) {
      return Projectile.method101(var0, var1, "openjs");
   }
}
