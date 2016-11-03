import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class33 {
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 291227069
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1446969619
   )
   static int field729 = 0;
   @ObfuscatedName("f")
   static ModIcon field730;
   @ObfuscatedName("m")
   static SpritePixels field732;
   @ObfuscatedName("y")
   static ModIcon field733;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -83132341
   )
   static int field734;
   @ObfuscatedName("aa")
   static String field736;
   @ObfuscatedName("i")
   static int[] field737;
   @ObfuscatedName("n")
   static int[] field738;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1716726929
   )
   static int field739;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 589849787
   )
   static int field740;
   @ObfuscatedName("al")
   static int[] field741;
   @ObfuscatedName("ay")
   static String field742;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 279782703
   )
   static int field743;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1325877469
   )
   static int field744;
   @ObfuscatedName("k")
   static boolean field745;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -307837157
   )
   static int field747;
   @ObfuscatedName("j")
   static SpritePixels field748;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 2058752007
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 352733315
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("ar")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("ax")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ap")
   @Export("username")
   static String username;
   @ObfuscatedName("ao")
   static String field754;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1797711335
   )
   static int field755;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 875820799
   )
   static int field756;
   @ObfuscatedName("an")
   static boolean field757;
   @ObfuscatedName("aw")
   static class162 field758;
   @ObfuscatedName("ak")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("ah")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 718456169
   )
   static int field762;
   @ObfuscatedName("dr")
   static byte[][] field764;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "17"
   )
   public static boolean method692(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   static {
      loginWindowX = field729 + 202;
      field737 = new int[256];
      field739 = 0;
      field740 = 0;
      field734 = 0;
      field743 = 0;
      field755 = 0;
      field747 = 0;
      field744 = 10;
      field742 = "";
      loginIndex = 0;
      field736 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      field754 = "";
      field758 = class162.field2642;
      field757 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field762 = -1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1208528876"
   )
   public static void method718() {
      if(class174.field2769 != null) {
         class174.field2769.method3020();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Lclass23;",
      garbageValue = "-55"
   )
   static class23 method719(int var0) {
      class23 var1 = (class23)class23.field595.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Client.field311.method3305(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new class23();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.method2576();
            var1.field593 = var3.method2691();
            var1.field589 = var3.method2691();
            var1.field600 = var3.method2691();
            var1.field596 = var3.method2691();
            var3.offset = 0;
            var3.method2637();
            var1.field597 = new int[var4];
            var1.field591 = new int[var4];
            var1.field592 = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.field597[var5++] = var6) {
               var6 = var3.method2691();
               if(var6 == 3) {
                  var1.field592[var5] = var3.method2579();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field591[var5] = var3.method2576();
               } else {
                  var1.field591[var5] = var3.method2571();
               }
            }

            class23.field595.put(var1, (long)var0);
            return var1;
         }
      }
   }
}
