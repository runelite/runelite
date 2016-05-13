import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("XItemContainer")
public class class15 extends class208 {
   @ObfuscatedName("s")
   @Export("itemContainers")
   static class196 field204 = new class196(32);
   @ObfuscatedName("p")
   @Export("stackSizes")
   int[] field206 = new int[]{0};
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -859553877
   )
   static int field207;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 239798243
   )
   static int field208;
   @ObfuscatedName("j")
   @Export("itemIds")
   int[] field210 = new int[]{-1};
   @ObfuscatedName("c")
   static int[] field211;
   @ObfuscatedName("br")
   static class168 field212;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 1843657849
   )
   public static int field214;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = 398942675
   )
   protected static int field215;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1954210062"
   )
   @Export("setGameState")
   static void method188(int var0) {
      if(client.field286 != var0) {
         if(client.field286 == 0) {
            class44.field1030 = null;
            class99.field1695 = null;
            class123.field2039 = null;
         }

         if(var0 == 20 || 40 == var0 || var0 == 45) {
            client.field311 = 0;
            client.field312 = 0;
            client.field313 = 0;
         }

         if(var0 != 20 && 40 != var0 && client.field562 != null) {
            client.field562.method2960();
            client.field562 = null;
         }

         if(25 == client.field286) {
            client.field338 = 0;
            client.field473 = 0;
            client.field525 = 1;
            client.field561 = 0;
            client.field444 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class123.method2776(class122.field2024, class164.field2663, class127.field2058, true, client.field286 == 11?4:0);
            } else if(var0 == 11) {
               class123.method2776(class122.field2024, class164.field2663, class127.field2058, false, 4);
            } else {
               class14.method173();
            }
         } else {
            class123.method2776(class122.field2024, class164.field2663, class127.field2058, true, 0);
         }

         client.field286 = var0;
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-75"
   )
   static final void method191() {
      int[] var0 = class32.field756;

      int var1;
      for(var1 = 0; var1 < class32.field755; ++var1) {
         class2 var2 = client.field491[var0[var1]];
         if(null != var2 && var2.field828 > 0) {
            --var2.field828;
            if(0 == var2.field828) {
               var2.field819 = null;
            }
         }
      }

      for(var1 = 0; var1 < client.field317; ++var1) {
         int var4 = client.field318[var1];
         class34 var3 = client.field515[var4];
         if(var3 != null && var3.field828 > 0) {
            --var3.field828;
            if(0 == var3.field828) {
               var3.field819 = null;
            }
         }
      }

   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(Lclass173;II)Ljava/lang/String;",
      garbageValue = "978854663"
   )
   static String method192(class173 var0, int var1) {
      return !class6.method97(class48.method962(var0), var1) && null == var0.field2865?null:(var0.field2839 != null && var0.field2839.length > var1 && null != var0.field2839[var1] && var0.field2839[var1].trim().length() != 0?var0.field2839[var1]:null);
   }

   @ObfuscatedName("j")
   static final void method193(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "1350223790"
   )
   static final void method194(class122 var0, int var1) {
      int var2 = var0.field2005;
      class32.field762 = 0;
      class52.method1068(var0);

      for(int var3 = 0; var3 < class32.field762; ++var3) {
         int var4 = class32.field764[var3];
         class2 var5 = client.field491[var4];
         int var6 = var0.method2492();
         if(0 != (var6 & 1)) {
            var6 += var0.method2492() << 8;
         }

         class3.method36(var0, var4, var5, var6);
      }

      if(var1 != var0.field2005 - var2) {
         throw new RuntimeException(var0.field2005 - var2 + " " + var1);
      }
   }
}
