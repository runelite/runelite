import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class175 extends class204 {
   @ObfuscatedName("d")
   public final int[] field2899;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -426692345
   )
   public final int field2900;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 145466399
   )
   public final int field2901;
   @ObfuscatedName("c")
   public final int[] field2902;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = -1589876523
   )
   static int field2903;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 551266399
   )
   static int field2904;

   class175(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2901 = var1;
      this.field2900 = var2;
      this.field2899 = var3;
      this.field2902 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1061857248"
   )
   public boolean method3524(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2902.length) {
         int var3 = this.field2902[var2];
         if(var1 >= var3 && var1 <= this.field2899[var2] + var3) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "430547036"
   )
   static final void method3525(class122 var0) {
      var0.method2866();
      int var1 = client.field457;
      class2 var2 = class5.field93 = client.field550[var1] = new class2();
      var2.field49 = var1;
      int var3 = var0.method2863(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.field871[0] = var5 - class144.field2204;
      var2.field844 = (var2.field871[0] << 7) + (var2.method17() << 6);
      var2.field835[0] = var6 - class3.field67;
      var2.field819 = (var2.field835[0] << 7) + (var2.method17() << 6);
      class42.field1002 = var2.field54 = var4;
      if(class32.field761[var1] != null) {
         var2.method16(class32.field761[var1]);
      }

      class32.field771 = 0;
      class32.field762[++class32.field771 - 1] = var1;
      class32.field768[var1] = 0;
      class32.field764 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2863(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class32.field766[var7] = var11 + (var10 << 14) + (var9 << 28);
            class32.field767[var7] = 0;
            class32.field759[var7] = -1;
            class32.field765[++class32.field764 - 1] = var7;
            class32.field768[var7] = 0;
         }
      }

      var0.method2868();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)Z",
      garbageValue = "-2140575049"
   )
   static boolean method3529(class122 var0, int var1) {
      int var2 = var0.method2863(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(0 == var2) {
         if(var0.method2863(1) != 0) {
            method3529(var0, var1);
         }

         var3 = var0.method2863(6);
         var4 = var0.method2863(6);
         boolean var11 = var0.method2863(1) == 1;
         if(var11) {
            class32.field770[++class32.field769 - 1] = var1;
         }

         if(client.field550[var1] != null) {
            throw new RuntimeException();
         } else {
            class2 var12 = client.field550[var1] = new class2();
            var12.field49 = var1;
            if(class32.field761[var1] != null) {
               var12.method16(class32.field761[var1]);
            }

            var12.field853 = class32.field767[var1];
            var12.field842 = class32.field759[var1];
            var7 = class32.field766[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var12.field826[0] = class32.field772[var1];
            var12.field54 = (byte)var8;
            var12.method20(var3 + (var9 << 6) - class144.field2204, (var10 << 6) + var4 - class3.field67);
            var12.field56 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2863(2);
         var4 = class32.field766[var1];
         class32.field766[var1] = (var4 & 268435455) + ((var3 + (var4 >> 28) & 3) << 28);
         return false;
      } else {
         int var5;
         int var6;
         if(2 == var2) {
            var3 = var0.method2863(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class32.field766[var1];
            var7 = (var6 >> 28) + var4 & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
            if(0 == var5) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(3 == var5) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class32.field766[var1] = var9 + (var7 << 28) + (var8 << 14);
            return false;
         } else {
            var3 = var0.method2863(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class32.field766[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var6 + var7 & 255;
            class32.field766[var1] = var10 + (var8 << 28) + (var9 << 14);
            return false;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "98252799"
   )
   static void method3530() {
      class5.field87 = 99;
      class45.field1053 = new byte[4][104][104];
      class5.field84 = new byte[4][104][104];
      class5.field85 = new byte[4][104][104];
      class84.field1463 = new byte[4][104][104];
      class4.field77 = new int[4][105][105];
      class41.field985 = new byte[4][105][105];
      class209.field3126 = new int[105][105];
      class5.field86 = new int[104];
      class134.field2077 = new int[104];
      class142.field2170 = new int[104];
      class5.field95 = new int[104];
      class125.field2035 = new int[104];
   }
}
