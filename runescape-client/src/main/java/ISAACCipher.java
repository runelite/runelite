import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
@Implements("ISAACCipher")
public final class ISAACCipher {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1423426933
   )
   int field2148;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -99773029
   )
   @Export("valuesRemaining")
   int valuesRemaining;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 269153233
   )
   int field2150;
   @ObfuscatedName("o")
   @Export("mm")
   int[] mm = new int[256];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2098241399
   )
   int field2154;
   @ObfuscatedName("r")
   @Export("randResult")
   int[] randResult = new int[256];

   ISAACCipher(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.randResult[var2] = var1[var2];
      }

      this.method3125();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "691252922"
   )
   @Export("nextInt")
   final int nextInt() {
      if(--this.valuesRemaining + 1 == 0) {
         this.generateMoreResults();
         this.valuesRemaining = 255;
      }

      return this.randResult[this.valuesRemaining];
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-1853999680"
   )
   static boolean method3124(Widget var0) {
      if(Client.field473) {
         if(FloorUnderlayDefinition.method3533(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-145574593"
   )
   final void method3125() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.randResult[var1];
         var3 += this.randResult[var1 + 1];
         var4 += this.randResult[2 + var1];
         var5 += this.randResult[var1 + 3];
         var6 += this.randResult[4 + var1];
         var7 += this.randResult[5 + var1];
         var8 += this.randResult[var1 + 6];
         var9 += this.randResult[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.mm[var1] = var2;
         this.mm[var1 + 1] = var3;
         this.mm[2 + var1] = var4;
         this.mm[3 + var1] = var5;
         this.mm[var1 + 4] = var6;
         this.mm[5 + var1] = var7;
         this.mm[6 + var1] = var8;
         this.mm[7 + var1] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.mm[var1];
         var3 += this.mm[1 + var1];
         var4 += this.mm[var1 + 2];
         var5 += this.mm[var1 + 3];
         var6 += this.mm[var1 + 4];
         var7 += this.mm[5 + var1];
         var8 += this.mm[var1 + 6];
         var9 += this.mm[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.mm[var1] = var2;
         this.mm[1 + var1] = var3;
         this.mm[var1 + 2] = var4;
         this.mm[var1 + 3] = var5;
         this.mm[var1 + 4] = var6;
         this.mm[5 + var1] = var7;
         this.mm[6 + var1] = var8;
         this.mm[7 + var1] = var9;
      }

      this.generateMoreResults();
      this.valuesRemaining = 256;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1788072440"
   )
   @Export("generateMoreResults")
   final void generateMoreResults() {
      this.field2148 += ++this.field2154;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.mm[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2150 ^= this.field2150 << 13;
            } else {
               this.field2150 ^= this.field2150 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2150 ^= this.field2150 << 2;
         } else {
            this.field2150 ^= this.field2150 >>> 16;
         }

         this.field2150 += this.mm[128 + var1 & 255];
         int var3;
         this.mm[var1] = var3 = this.field2148 + this.field2150 + this.mm[(var2 & 1020) >> 2];
         this.randResult[var1] = this.field2148 = var2 + this.mm[(var3 >> 8 & 1020) >> 2];
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-4"
   )
   public static void method3132(int var0) {
      if(var0 != -1) {
         if(class6.validInterfaces[var0]) {
            Widget.field2301.method3348(var0);
            if(null != Widget.widgets[var0]) {
               boolean var1 = true;

               for(int var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(Widget.widgets[var0][var2] != null) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  Widget.widgets[var0] = null;
               }

               class6.validInterfaces[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LFloorUnderlayDefinition;",
      garbageValue = "-1418896148"
   )
   public static FloorUnderlayDefinition method3133(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field2821.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.field2822.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.method3544(new Buffer(var2), var0);
         }

         var1.method3532();
         FloorUnderlayDefinition.field2821.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "-1441576506"
   )
   static final void method3134(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class25 var9 = null;

      for(class25 var10 = (class25)Client.field461.method2464(); var10 != null; var10 = (class25)Client.field461.method2472()) {
         if(var10.field601 == var0 && var10.field599 == var1 && var10.field597 == var2 && var10.field588 == var3) {
            var9 = var10;
            break;
         }
      }

      if(null == var9) {
         var9 = new class25();
         var9.field601 = var0;
         var9.field588 = var3;
         var9.field599 = var1;
         var9.field597 = var2;
         Client.method552(var9);
         Client.field461.method2459(var9);
      }

      var9.field594 = var4;
      var9.field596 = var5;
      var9.field587 = var6;
      var9.field589 = var7;
      var9.field598 = var8;
   }
}
