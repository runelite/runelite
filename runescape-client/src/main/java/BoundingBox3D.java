import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("BoundingBox3D")
public final class BoundingBox3D extends BoundingBox {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1255245205
   )
   static int field249;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -388491899
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 779362501
   )
   @Export("int1")
   final int int1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1582837273
   )
   @Export("int2")
   final int int2;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1228743201
   )
   @Export("int3")
   final int int3;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 514739853
   )
   @Export("int4")
   final int int4;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1489241905
   )
   @Export("int5")
   final int int5;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1999716913
   )
   @Export("int6")
   final int int6;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1168317273
   )
   @Export("color")
   final int color;

   @ObfuscatedSignature(
      signature = "(Led;IIII)V"
   )
   BoundingBox3D(Model var1, int var2, int var3, int var4, int var5) {
      this.int1 = var2 + var1.centerX - var1.extremeX;
      this.int2 = var3 + var1.centerY - var1.extremeY;
      this.int3 = var4 + var1.centerZ - var1.extremeZ;
      this.int4 = var2 + var1.extremeX + var1.centerX;
      this.int5 = var3 + var1.extremeY + var1.centerY;
      this.int6 = var4 + var1.extremeZ + var1.centerZ;
      this.color = var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-254890889"
   )
   final void vmethod63() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.int1:this.int4;
         int var2 = (var4 & 2) == 0?this.int2:this.int5;
         int var3 = (var4 & 4) == 0?this.int3:this.int6;
         if((var4 & 1) == 0) {
            class167.method3256(var1, var2, var3, this.int4, var2, var3, this.color);
         }

         if((var4 & 2) == 0) {
            class167.method3256(var1, var2, var3, var1, this.int5, var3, this.color);
         }

         if((var4 & 4) == 0) {
            class167.method3256(var1, var2, var3, var1, var2, this.int6, this.color);
         }
      }

   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "90"
   )
   static void method62() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(VertexNormal.method2790(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
                  Client.menuBooleanArray[var1] = Client.menuBooleanArray[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
