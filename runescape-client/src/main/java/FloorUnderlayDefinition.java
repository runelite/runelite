import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("underlay_ref")
   public static IndexDataBase underlay_ref;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("underlays")
   public static NodeCache underlays;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1482197087
   )
   @Export("rgbColor")
   int rgbColor;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1109097029
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 271575671
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 214799491
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1748763439
   )
   @Export("hueMultiplier")
   public int hueMultiplier;

   static {
      underlays = new NodeCache(64);
   }

   FloorUnderlayDefinition() {
      this.rgbColor = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1592433139"
   )
   @Export("post")
   void post() {
      this.setHSL(this.rgbColor);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgn;IB)V",
      garbageValue = "1"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.decode(var1, var3, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgn;III)V",
      garbageValue = "109639650"
   )
   @Export("decode")
   void decode(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.rgbColor = var1.read24BitInt();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1525947137"
   )
   @Export("setHSL")
   void setHSL(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.saturation = (int)(256.0D * var14);
      this.lightness = (int)(var16 * 256.0D);
      if(this.saturation < 0) {
         this.saturation = 0;
      } else if(this.saturation > 255) {
         this.saturation = 255;
      }

      if(this.lightness < 0) {
         this.lightness = 0;
      } else if(this.lightness > 255) {
         this.lightness = 255;
      }

      if(var16 > 0.5D) {
         this.hueMultiplier = (int)(512.0D * var14 * (1.0D - var16));
      } else {
         this.hueMultiplier = (int)(var14 * var16 * 512.0D);
      }

      if(this.hueMultiplier < 1) {
         this.hueMultiplier = 1;
      }

      this.hue = (int)(var12 * (double)this.hueMultiplier);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-6"
   )
   static void method4809() {
      class61.field687 = null;
      class235.field2764 = null;
      ContextMenuRow.field1282 = null;
      BaseVarType.field27 = null;
      class56.field619 = null;
      class188.field2488 = null;
      PacketNode.field2469 = null;
      class231.field2738 = null;
      Size.field334 = null;
      class61.field684 = null;
      class61.field692 = null;
      ScriptState.field700 = null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1591771634"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class323.field3916 = var1.readUnsignedShort();
      TotalQuantityComparator.field281 = new int[class323.field3916];
      FileSystem.offsetsY = new int[class323.field3916];
      BaseVarType.field28 = new int[class323.field3916];
      GroundObject.field1751 = new int[class323.field3916];
      class323.spritePixels = new byte[class323.field3916][];
      var1.offset = var0.length - 7 - class323.field3916 * 8;
      class323.field3913 = var1.readUnsignedShort();
      class323.field3915 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class323.field3916; ++var3) {
         TotalQuantityComparator.field281[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class323.field3916; ++var3) {
         FileSystem.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class323.field3916; ++var3) {
         BaseVarType.field28[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class323.field3916; ++var3) {
         GroundObject.field1751[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class323.field3916 * 8 - (var2 - 1) * 3;
      class323.field3912 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class323.field3912[var3] = var1.read24BitInt();
         if(class323.field3912[var3] == 0) {
            class323.field3912[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class323.field3916; ++var3) {
         int var4 = BaseVarType.field28[var3];
         int var5 = GroundObject.field1751[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class323.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.readByte();
               }
            }
         }
      }

   }
}
