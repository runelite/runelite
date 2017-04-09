import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1629402503
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2005549679
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1744251775
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 329587197
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1369922143
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -138161305
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("n")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("m")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 684256359
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1801639019
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked = 0;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = 1593397603
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -732384697
   )
   @Export("floor")
   int floor;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "-2129532996"
   )
   public static byte method1955(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(LWidget;I)LWidget;",
      garbageValue = "119936294"
   )
   static Widget method1956(Widget var0) {
      int var1 = FloorUnderlayDefinition.method3533(var0);
      int var2 = var1 >> 17 & 7;
      int var3 = var2;
      if(var2 == 0) {
         return null;
      } else {
         for(int var4 = 0; var4 < var3; ++var4) {
            var0 = FaceNormal.method1932(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }
}
