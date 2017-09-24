import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class47 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -862500371
   )
   static int field616;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2144182751
   )
   public int field613;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   public Coordinates field615;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   public Coordinates field614;

   @ObfuscatedSignature(
      signature = "(ILhs;Lhs;)V"
   )
   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field613 = var1;
      this.field615 = var2;
      this.field614 = var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1625156198"
   )
   public static void method739() {
      MouseInput var0 = MouseInput.mouse;
      synchronized(MouseInput.mouse) {
         MouseInput.field745 = MouseInput.field744 * 245838703;
         MouseInput.field752 = MouseInput.mouseX;
         MouseInput.field747 = MouseInput.mouseY;
         MouseInput.field754 = MouseInput.field748;
         MouseInput.field753 = MouseInput.field749;
         MouseInput.field739 = MouseInput.field750;
         MouseInput.field755 = MouseInput.field751;
         MouseInput.field748 = 0;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IILfk;Lfh;I)Z",
      garbageValue = "1807039695"
   )
   static final boolean method742(int var0, int var1, class164 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class163.field2307[var6][var7] = 99;
      class163.field2310[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class163.field2306[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class163.field2312[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class163.field2306[var11];
         var5 = class163.field2312[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3145(1, var4, var5, var3)) {
            class89.field1418 = var4;
            class51.field671 = var5;
            return true;
         }

         int var15 = class163.field2310[var16][var17] + 1;
         if(var16 > 0 && class163.field2307[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class163.field2306[var18] = var4 - 1;
            class163.field2312[var18] = var5;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 - 1][var17] = 2;
            class163.field2310[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class163.field2307[var16 + 1][var17] == 0 && 0 == (var12[var13 + 1][var14] & 19136896)) {
            class163.field2306[var18] = var4 + 1;
            class163.field2312[var18] = var5;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 + 1][var17] = 8;
            class163.field2310[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class163.field2307[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class163.field2306[var18] = var4;
            class163.field2312[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16][var17 - 1] = 1;
            class163.field2310[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class163.field2307[var16][var17 + 1] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class163.field2306[var18] = var4;
            class163.field2312[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16][var17 + 1] = 4;
            class163.field2310[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class163.field2307[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class163.field2306[var18] = var4 - 1;
            class163.field2312[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 - 1][var17 - 1] = 3;
            class163.field2310[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && 0 == class163.field2307[var16 + 1][var17 - 1] && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class163.field2306[var18] = var4 + 1;
            class163.field2312[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 + 1][var17 - 1] = 9;
            class163.field2310[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && 0 == class163.field2307[var16 - 1][var17 + 1] && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class163.field2306[var18] = var4 - 1;
            class163.field2312[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 - 1][var17 + 1] = 6;
            class163.field2310[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class163.field2307[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class163.field2306[var18] = var4 + 1;
            class163.field2312[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2307[var16 + 1][var17 + 1] = 12;
            class163.field2310[var16 + 1][var17 + 1] = var15;
         }
      }

      class89.field1418 = var4;
      class51.field671 = var5;
      return false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfn;B)I",
      garbageValue = "71"
   )
   static int method741(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-2039671858"
   )
   static final int method740(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & 16711935) * var2 + var3 * (var0 & 16711935) & -16711936) + ((var1 & '\uff00') * var2 + (var0 & '\uff00') * var3 & 16711680) >> 8;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "-1715810753"
   )
   static int method743(int var0, Script var1, boolean var2) {
      Widget var3 = GZipDecompressor.method3177(class82.intStack[--Ignore.intStackSize]);
      if(var0 == 2600) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 2601) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 2602) {
         class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 2603) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 2606) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 2607) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 2608) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 2609) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 2610) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.field2690;
         return 1;
      } else if(var0 == 2611) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 2612) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.field2684;
         return 1;
      } else if(var0 == 2613) {
         class82.intStack[++Ignore.intStackSize - 1] = var3.field2688.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }
}
