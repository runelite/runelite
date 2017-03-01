import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 764719801
   )
   @Export("y")
   int y;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2124304017
   )
   @Export("magnitude")
   int magnitude;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1303214845
   )
   @Export("z")
   int z;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 283684211
   )
   @Export("x")
   int x;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "4"
   )
   static int method1722(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 4000) {
         class32.field735 -= 2;
         var3 = class32.field726[class32.field735];
         var4 = class32.field726[1 + class32.field735];
         class32.field726[++class32.field735 - 1] = var3 + var4;
         return 1;
      } else if(var0 == 4001) {
         class32.field735 -= 2;
         var3 = class32.field726[class32.field735];
         var4 = class32.field726[class32.field735 + 1];
         class32.field726[++class32.field735 - 1] = var3 - var4;
         return 1;
      } else if(var0 == 4002) {
         class32.field735 -= 2;
         var3 = class32.field726[class32.field735];
         var4 = class32.field726[1 + class32.field735];
         class32.field726[++class32.field735 - 1] = var3 * var4;
         return 1;
      } else if(var0 == 4003) {
         class32.field735 -= 2;
         var3 = class32.field726[class32.field735];
         var4 = class32.field726[class32.field735 + 1];
         class32.field726[++class32.field735 - 1] = var3 / var4;
         return 1;
      } else if(var0 == 4004) {
         var3 = class32.field726[--class32.field735];
         class32.field726[++class32.field735 - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if(var0 == 4005) {
         var3 = class32.field726[--class32.field735];
         class32.field726[++class32.field735 - 1] = (int)(Math.random() * (double)(1 + var3));
         return 1;
      } else if(var0 == 4006) {
         class32.field735 -= 5;
         var3 = class32.field726[class32.field735];
         var4 = class32.field726[1 + class32.field735];
         int var5 = class32.field726[class32.field735 + 2];
         int var6 = class32.field726[class32.field735 + 3];
         int var7 = class32.field726[4 + class32.field735];
         class32.field726[++class32.field735 - 1] = (var4 - var3) * (var7 - var5) / (var6 - var5) + var3;
         return 1;
      } else if(var0 == 4007) {
         class32.field735 -= 2;
         var3 = class32.field726[class32.field735];
         var4 = class32.field726[1 + class32.field735];
         class32.field726[++class32.field735 - 1] = var3 + var3 * var4 / 100;
         return 1;
      } else if(var0 == 4008) {
         class32.field735 -= 2;
         var3 = class32.field726[class32.field735];
         var4 = class32.field726[class32.field735 + 1];
         class32.field726[++class32.field735 - 1] = var3 | 1 << var4;
         return 1;
      } else if(var0 == 4009) {
         class32.field735 -= 2;
         var3 = class32.field726[class32.field735];
         var4 = class32.field726[class32.field735 + 1];
         class32.field726[++class32.field735 - 1] = var3 & -1 - (1 << var4);
         return 1;
      } else if(var0 == 4010) {
         class32.field735 -= 2;
         var3 = class32.field726[class32.field735];
         var4 = class32.field726[class32.field735 + 1];
         class32.field726[++class32.field735 - 1] = (var3 & 1 << var4) != 0?1:0;
         return 1;
      } else if(var0 == 4011) {
         class32.field735 -= 2;
         var3 = class32.field726[class32.field735];
         var4 = class32.field726[1 + class32.field735];
         class32.field726[++class32.field735 - 1] = var3 % var4;
         return 1;
      } else if(var0 == 4012) {
         class32.field735 -= 2;
         var3 = class32.field726[class32.field735];
         var4 = class32.field726[1 + class32.field735];
         if(var3 == 0) {
            class32.field726[++class32.field735 - 1] = 0;
         } else {
            class32.field726[++class32.field735 - 1] = (int)Math.pow((double)var3, (double)var4);
         }

         return 1;
      } else if(var0 == 4013) {
         class32.field735 -= 2;
         var3 = class32.field726[class32.field735];
         var4 = class32.field726[class32.field735 + 1];
         if(var3 == 0) {
            class32.field726[++class32.field735 - 1] = 0;
         } else if(var4 == 0) {
            class32.field726[++class32.field735 - 1] = Integer.MAX_VALUE;
         } else {
            class32.field726[++class32.field735 - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
         }

         return 1;
      } else if(var0 == 4014) {
         class32.field735 -= 2;
         var3 = class32.field726[class32.field735];
         var4 = class32.field726[class32.field735 + 1];
         class32.field726[++class32.field735 - 1] = var3 & var4;
         return 1;
      } else if(var0 == 4015) {
         class32.field735 -= 2;
         var3 = class32.field726[class32.field735];
         var4 = class32.field726[class32.field735 + 1];
         class32.field726[++class32.field735 - 1] = var3 | var4;
         return 1;
      } else if(var0 == 4018) {
         class32.field735 -= 3;
         long var9 = (long)class32.field726[class32.field735];
         long var11 = (long)class32.field726[1 + class32.field735];
         long var13 = (long)class32.field726[class32.field735 + 2];
         class32.field726[++class32.field735 - 1] = (int)(var9 * var13 / var11);
         return 1;
      } else {
         return 2;
      }
   }

   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   VertexNormal() {
   }
}
