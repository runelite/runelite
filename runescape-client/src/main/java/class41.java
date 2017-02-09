import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class41 {
   @ObfuscatedName("am")
   static String field819;
   @ObfuscatedName("r")
   static ModIcon field820;
   @ObfuscatedName("o")
   static ModIcon field821;
   @ObfuscatedName("av")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("w")
   static ModIcon[] field823;
   @ObfuscatedName("n")
   static ModIcon[] field824;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1911383999
   )
   static int field825;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 804168219
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("t")
   static int[] field827;
   @ObfuscatedName("f")
   static int[] field828;
   @ObfuscatedName("b")
   static int[] field829;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1325889707
   )
   static int field830;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 658871157
   )
   static int field831;
   @ObfuscatedName("ay")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("aq")
   static int[] field833;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1477391647
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1005305901
   )
   static int field835;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1490448823
   )
   static int field836;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1793062491
   )
   static int field837;
   @ObfuscatedName("af")
   static String field839;
   @ObfuscatedName("ao")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 2067547347
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("ar")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("ad")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("ac")
   static String field844;
   @ObfuscatedName("k")
   static boolean field845;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1987440869
   )
   static int field846 = 0;
   @ObfuscatedName("ap")
   static int[] field847;
   @ObfuscatedName("ax")
   static boolean field848;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 798350095
   )
   static int field849;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -1457154467
   )
   static int field853;
   @ObfuscatedName("ag")
   static class97 field854;
   @ObfuscatedName("ce")
   static Font field855;

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-529896670"
   )
   static final void method777(int var0, int var1) {
      if(Client.field296 == 2) {
         class18.method203((Client.field348 - class114.baseX << 7) + Client.field302, (Client.field428 - CombatInfo1.baseY << 7) + Client.field303, Client.field301 * 2);
         if(Client.field383 > -1 && Client.gameCycle % 20 < 10) {
            class49.field963[0].method4121(var0 + Client.field383 - 12, var1 + Client.field384 - 28);
         }

      }
   }

   static {
      loginWindowX = field846 + 202;
      field827 = new int[256];
      field830 = 0;
      field831 = 0;
      field825 = 0;
      field835 = 0;
      field836 = 0;
      field837 = 0;
      field849 = 10;
      field839 = "";
      loginIndex = 0;
      field819 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      field844 = "";
      field854 = class97.field1624;
      field848 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field853 = -1;
   }

   class41() throws Throwable {
      throw new Error();
   }
}
