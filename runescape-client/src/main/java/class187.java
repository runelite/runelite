import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public class class187 extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1320716947
   )
   public int field2772 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -970240349
   )
   public static int field2773;
   @ObfuscatedName("m")
   public static NodeCache field2774 = new NodeCache(64);
   @ObfuscatedName("n")
   static class182 field2775;
   @ObfuscatedName("x")
   static int[][][] field2778;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-24"
   )
   void method3477(Buffer var1) {
      while(true) {
         int var2 = var1.method3033();
         if(var2 == 0) {
            return;
         }

         this.method3478(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-38"
   )
   void method3478(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field2772 = var1.method3097();
      }

   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIS)V",
      garbageValue = "13281"
   )
   static final void method3484(Widget var0, int var1, int var2, int var3) {
      class145 var4 = var0.method2846(false);
      if(null != var4) {
         if(Client.field521 < 3) {
            class20.field213.method4216(var1, var2, var4.field2028, var4.field2020, 25, 25, Client.mapAngle, 256, var4.field2023, var4.field2022);
         } else {
            class219.method4060(var1, var2, 0, var4.field2023, var4.field2022);
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1108765047"
   )
   static final boolean method3485(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else if(class57.method1054(var0)) {
         return true;
      } else {
         char[] var1 = class204.field3070;

         int var2;
         char var3;
         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var3 == var0) {
               return true;
            }
         }

         var1 = class204.field3068;

         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         return false;
      }
   }
}
