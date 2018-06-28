import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("Size")
public class Size {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   public static final Size field93;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   public static final Size field87;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   public static final Size field89;
   @ObfuscatedName("l")
   @Export("floorSaturations")
   static int[] floorSaturations;
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("socket")
   static Task socket;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -23097341
   )
   @Export("myWorldPort")
   static int myWorldPort;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -1690305633
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("b")
   final String field90;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -46781563
   )
   final int field88;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 355855233
   )
   final int field92;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1178525389
   )
   final int field98;

   static {
      field93 = new Size("SMALL", 1, 0, 4);
      field87 = new Size("MEDIUM", 2, 1, 2);
      field89 = new Size("LARGE", 0, 2, 0);
   }

   Size(String var1, int var2, int var3, int var4) {
      this.field90 = var1;
      this.field88 = var2;
      this.field92 = var3;
      this.field98 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "843081340"
   )
   boolean method121(float var1) {
      return var1 >= (float)this.field98;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "85"
   )
   static int method122(int var0, int var1) {
      Overlay var2 = class148.getOverlayDefinition(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else if(var2.texture >= 0) {
         int var3 = class7.method87(Graphics3D.textureLoader.getAverageTextureRGB(var2.texture), 96);
         return Graphics3D.colorPalette[var3] | -16777216;
      } else if(var2.color == 16711935) {
         return var1;
      } else {
         int var4 = var2.hue;
         int var5 = var2.saturation;
         int var6 = var2.lightness;
         if(var6 > 179) {
            var5 /= 2;
         }

         if(var6 > 192) {
            var5 /= 2;
         }

         if(var6 > 217) {
            var5 /= 2;
         }

         if(var6 > 243) {
            var5 /= 2;
         }

         int var7 = (var5 / 32 << 7) + var6 / 2 + (var4 / 4 << 10);
         int var8 = class7.method87(var7, 96);
         return Graphics3D.colorPalette[var8] | -16777216;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Liv;B)V",
      garbageValue = "-116"
   )
   public static void method124(IndexDataBase var0) {
      class311.EnumDefinition_indexCache = var0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Ls;",
      garbageValue = "-1696635948"
   )
   static Size method117(int var0) {
      Size[] var1 = new Size[]{field87, field89, field93};
      Size[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Size var4 = var2[var3];
         if(var0 == var4.field92) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1717836676"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }
}
