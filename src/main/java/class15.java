import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("XItemContainer")
public class class15 extends class208 {
   @ObfuscatedName("w")
   @Export("itemIds")
   int[] field229 = new int[]{-1};
   @ObfuscatedName("a")
   @Export("itemContainers")
   static class196 field230 = new class196(32);
   @ObfuscatedName("ar")
   static int[] field233;
   @ObfuscatedName("d")
   @Export("stackSizes")
   int[] field234 = new int[]{0};

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   static void method203() {
      class76.field1389 = null;
      class76.field1387 = null;
      class126.field2042 = null;
      class77.field1397 = null;
      class8.field153 = null;
      class76.field1388 = (byte[][])null;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lclass37;I)V",
      garbageValue = "-1750642778"
   )
   static final void method206(class37 var0) {
      if(0 != var0.field869) {
         if(-1 != var0.field842) {
            Object var1 = null;
            if(var0.field842 < '耀') {
               var1 = client.field546[var0.field842];
            } else if(var0.field842 >= '耀') {
               var1 = client.field550[var0.field842 - '耀'];
            }

            if(null != var1) {
               int var2 = var0.field844 - ((class37)var1).field844;
               int var3 = var0.field819 - ((class37)var1).field819;
               if(0 != var2 || 0 != var3) {
                  var0.field853 = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field843) {
               var0.field842 = -1;
               var0.field843 = false;
            }
         }

         if(var0.field827 != -1 && (0 == var0.field821 || var0.field874 > 0)) {
            var0.field853 = var0.field827;
            var0.field827 = -1;
         }

         int var4 = var0.field853 - var0.field863 & 2047;
         if(var4 == 0 && var0.field843) {
            var0.field842 = -1;
            var0.field843 = false;
         }

         if(0 != var4) {
            ++var0.field868;
            boolean var5;
            if(var4 > 1024) {
               var0.field863 -= var0.field869;
               var5 = true;
               if(var4 < var0.field869 || var4 > 2048 - var0.field869) {
                  var0.field863 = var0.field853;
                  var5 = false;
               }

               if(var0.field822 == var0.field845 && (var0.field868 > 25 || var5)) {
                  if(var0.field878 != -1) {
                     var0.field845 = var0.field878;
                  } else {
                     var0.field845 = var0.field825;
                  }
               }
            } else {
               var0.field863 += var0.field869;
               var5 = true;
               if(var4 < var0.field869 || var4 > 2048 - var0.field869) {
                  var0.field863 = var0.field853;
                  var5 = false;
               }

               if(var0.field845 == var0.field822 && (var0.field868 > 25 || var5)) {
                  if(-1 != var0.field824) {
                     var0.field845 = var0.field824;
                  } else {
                     var0.field845 = var0.field825;
                  }
               }
            }

            var0.field863 &= 2047;
         } else {
            var0.field868 = 0;
         }

      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1826647561"
   )
   static final void method210() {
      for(int var0 = 0; var0 < client.field343; ++var0) {
         int var1 = client.field335[var0];
         class34 var2 = client.field546[var1];
         if(var2 != null) {
            class40.method932(var2, var2.field784.field887);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "-82"
   )
   public static void method211(class119 var0, int var1) {
      if(class149.field2234 != null) {
         try {
            class149.field2234.method4222(0L);
            class149.field2234.method4227(var0.field1993, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }
}
