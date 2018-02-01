import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("BoundingBox3D")
public final class BoundingBox3D extends BoundingBox {
   @ObfuscatedName("m")
   public static short[] field245;
   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = -1085147203
   )
   @Export("port2")
   static int port2;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1707291951
   )
   @Export("int1")
   final int int1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1435582857
   )
   @Export("int2")
   final int int2;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1970181629
   )
   @Export("int3")
   final int int3;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -798401765
   )
   @Export("int4")
   final int int4;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -219815873
   )
   @Export("int5")
   final int int5;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -759647677
   )
   @Export("int6")
   final int int6;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -714548463
   )
   @Export("color")
   final int color;

   @ObfuscatedSignature(
      signature = "(Len;IIII)V"
   )
   public BoundingBox3D(Model var1, int var2, int var3, int var4, int var5) {
      this.int1 = var2 + var1.centerX - var1.extremeX;
      this.int2 = var3 + var1.centerY - var1.extremeY;
      this.int3 = var4 + var1.centerZ - var1.extremeZ;
      this.int4 = var2 + var1.extremeX + var1.centerX;
      this.int5 = var3 + var1.extremeY + var1.centerY;
      this.int6 = var4 + var1.extremeZ + var1.centerZ;
      this.color = var5;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "160"
   )
   final void draw() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.int1:this.int4;
         int var2 = (var4 & 2) == 0?this.int2:this.int5;
         int var3 = (var4 & 4) == 0?this.int3:this.int6;
         if((var4 & 1) == 0) {
            class173.method3299(var1, var2, var3, this.int4, var2, var3, this.color);
         }

         if((var4 & 2) == 0) {
            class173.method3299(var1, var2, var3, var1, this.int5, var3, this.color);
         }

         if((var4 & 4) == 0) {
            class173.method3299(var1, var2, var3, var1, var2, this.int6, this.color);
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "8237"
   )
   static final int method69() {
      return class131.Viewport_mouseY;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1797637217"
   )
   static void method70() {
      if(class89.loadWorlds()) {
         class89.worldSelectShown = true;
      }

   }
}
