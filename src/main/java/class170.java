import java.awt.Canvas;
import java.awt.Color;
import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class170 {
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = -1023724865
   )
   static int field2703;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -1668725402691876061L
   )
   public static long field2704;
   @ObfuscatedName("s")
   public static class195 field2705 = new class195(4096);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -375958645
   )
   public static int field2706 = 0;
   @ObfuscatedName("e")
   public static class195 field2707 = new class195(32);
   @ObfuscatedName("d")
   static class167[] field2708 = new class167[256];
   @ObfuscatedName("m")
   public static class202 field2709 = new class202();
   @ObfuscatedName("x")
   static class118 field2710;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1903242165
   )
   public static int field2711 = 0;
   @ObfuscatedName("l")
   public static class195 field2712 = new class195(4096);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -666100145
   )
   public static int field2713 = 0;
   @ObfuscatedName("z")
   public static class118 field2714 = new class118(8);
   @ObfuscatedName("c")
   static CRC32 field2715 = new CRC32();
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1627957783
   )
   public static int field2716 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1859727169
   )
   public static int field2717 = 0;
   @ObfuscatedName("j")
   public static class195 field2718 = new class195(4096);
   @ObfuscatedName("p")
   public static byte field2719 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -311899145
   )
   public static int field2720 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -745720389
   )
   public static int field2721 = 0;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = -2122610257
   )
   static int field2724;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -54412965
   )
   public static int field2725 = 0;

   @ObfuscatedName("as")
   static void method3412() {
      class41.method868(class45.field1042);
      class122.method2783(class45.field1042);
      if(class107.field1894 != null) {
         class107.field1894.vmethod3114(class45.field1042);
      }

      client.field540.method3063();
      class45.field1042.setBackground(Color.black);
      Canvas var0 = class45.field1042;
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class136.field2108);
      var0.addFocusListener(class136.field2108);
      class98.method2217(class45.field1042);
      if(class107.field1894 != null) {
         class107.field1894.vmethod3115(class45.field1042);
      }

      if(client.field453 != -1) {
         int var1 = client.field453;
         int var2 = class6.field107;
         int var3 = class31.field749;
         if(class103.method2303(var1)) {
            class1.method11(class172.field2850[var1], -1, var2, var3, false);
         }
      }

      class143.field2187 = true;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIILclass85;[Lclass107;I)V",
      garbageValue = "-465606255"
   )
   static final void method3413(byte[] var0, int var1, int var2, class85 var3, class107[] var4) {
      class118 var5 = new class118(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.method2659();
         if(0 == var7) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.method2659();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.method2579();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var1 + var11;
            int var17 = var10 + var2;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class5.field90[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               class107 var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               class32.method712(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }
}
