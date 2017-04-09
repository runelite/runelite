import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class177 implements class158 {
   @ObfuscatedName("i")
   static final class177 field2680 = new class177(1, 0, true, true, true);
   @ObfuscatedName("u")
   static final class177 field2681 = new class177(2, 1, true, true, false);
   @ObfuscatedName("r")
   static final class177 field2683 = new class177(4, 3, false, false, true);
   @ObfuscatedName("o")
   static final class177 field2684 = new class177(5, 10, false, false, true);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1750093059
   )
   final int field2685;
   @ObfuscatedName("aj")
   static boolean field2687;
   @ObfuscatedName("w")
   public final boolean field2688;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 1304235983
   )
   static int field2689;
   @ObfuscatedName("m")
   public final boolean field2690;
   @ObfuscatedName("f")
   static final class177 field2692 = new class177(0, -1, true, false, true);
   @ObfuscatedName("h")
   static final class177 field2694 = new class177(3, 2, false, false, true);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1848779419
   )
   public final int field2695;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "452569220"
   )
   static void method3315(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var10 = World.worldList[var9];
            int var11 = CombatInfo1.method594(var10, var8, var2, var3);
            int var12;
            if(var11 != 0) {
               if(var3) {
                  var12 = -var11;
               } else {
                  var12 = var11;
               }
            } else if(var4 == -1) {
               var12 = 0;
            } else {
               int var13 = CombatInfo1.method594(var10, var8, var4, var5);
               if(var5) {
                  var12 = -var13;
               } else {
                  var12 = var13;
               }
            }

            if(var12 <= 0) {
               World var14 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var14;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method3315(var0, var7 - 1, var2, var3, var4, var5);
         method3315(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1935391427"
   )
   public int vmethod4085() {
      return this.field2685;
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class177(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2685 = var1;
      this.field2695 = var2;
      this.field2690 = var4;
      this.field2688 = var5;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1785561502"
   )
   static final boolean method3324(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }
}
