import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public final class class5 {
   @ObfuscatedName("l")
   static int[] field79;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1075049927
   )
   static int field80 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1707859621
   )
   static int field81 = 99;
   @ObfuscatedName("k")
   static int[][] field82;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1419555739
   )
   static int field83 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("b")
   static byte[][][] field84;
   @ObfuscatedName("y")
   static final int[] field85 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("d")
   static byte[][][] field86;
   @ObfuscatedName("a")
   static final int[] field87 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("w")
   static final int[] field88 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("g")
   static final int[] field89 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("j")
   @Export("tileSettings")
   static byte[][][] field90 = new byte[4][104][104];
   @ObfuscatedName("f")
   static final int[] field91 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("q")
   static final int[] field92 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("s")
   @Export("tileHeights")
   static int[][][] field93 = new int[4][105][105];
   @ObfuscatedName("x")
   static byte[][][] field94;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      intValue = -597939009
   )
   static int field95;

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1889984763"
   )
   static void method55(int var0, int var1) {
      client.field322.method2737(99);
      client.field322.method2661(var1);
      client.field322.method2531(var0);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-643507728"
   )
   static final void method87() {
      for(class29 var0 = (class29)client.field413.method3812(); null != var0; var0 = (class29)client.field413.method3817()) {
         if(class21.field581 == var0.field689 && !var0.field696) {
            if(client.field335 >= var0.field691) {
               var0.method638(client.field356);
               if(var0.field696) {
                  var0.method3898();
               } else {
                  client.field339.method1906(var0.field689, var0.field688, var0.field687, var0.field692, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.method3898();
         }
      }

   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "([Lclass173;II)V",
      garbageValue = "-691196399"
   )
   static final void method88(class173[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class173 var3 = var0[var2];
         if(null != var3) {
            if(var3.field2767 == 0) {
               if(null != var3.field2847) {
                  method88(var3.field2847, var1);
               }

               class3 var4 = (class3)client.field308.method3777((long)var3.field2826);
               if(var4 != null) {
                  class87.method2065(var4.field69, var1);
               }
            }

            class0 var5;
            if(var1 == 0 && var3.field2763 != null) {
               var5 = new class0();
               var5.field8 = var3;
               var5.field12 = var3.field2763;
               class16.method197(var5);
            }

            if(1 == var1 && var3.field2873 != null) {
               if(var3.field2766 >= 0) {
                  class173 var6 = class29.method645(var3.field2826);
                  if(var6 == null || null == var6.field2847 || var3.field2766 >= var6.field2847.length || var6.field2847[var3.field2766] != var3) {
                     continue;
                  }
               }

               var5 = new class0();
               var5.field8 = var3;
               var5.field12 = var3.field2873;
               class16.method197(var5);
            }
         }
      }

   }
}
