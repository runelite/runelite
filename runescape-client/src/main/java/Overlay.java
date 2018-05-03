import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kk")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("overlay_ref")
   static IndexDataBase overlay_ref;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   @Export("overlays")
   static NodeCache overlays;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 296128499
   )
   @Export("color")
   public int color;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 898544963
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("n")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 106910007
   )
   @Export("otherRgbColor")
   public int otherRgbColor;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1544511045
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1904771251
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1433625771
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 99790759
   )
   @Export("otherHue")
   public int otherHue;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1733563211
   )
   @Export("otherSaturation")
   public int otherSaturation;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 454279179
   )
   @Export("otherLightness")
   public int otherLightness;

   static {
      overlays = new NodeCache(64);
   }

   Overlay() {
      this.color = 0;
      this.texture = -1;
      this.isHidden = true;
      this.otherRgbColor = -1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   @Export("post")
   void post() {
      if(this.otherRgbColor != -1) {
         this.setHSL(this.otherRgbColor);
         this.otherHue = this.hue;
         this.otherSaturation = this.saturation;
         this.otherLightness = this.lightness;
      }

      this.setHSL(this.color);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgg;II)V",
      garbageValue = "-547591725"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.readNext(var1, var3, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgg;III)V",
      garbageValue = "8461062"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.isHidden = false;
      } else if(var2 == 7) {
         this.otherRgbColor = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "402349799"
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
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(256.0D * var12);
      this.saturation = (int)(var14 * 256.0D);
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

   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-44"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      class36.method545();
      ++Client.field911.field1466;
      if(Client.field911.field1466 >= 50 || var0) {
         Client.field911.field1466 = 0;
         if(!Client.socketError && Client.field911.getSocket() != null) {
            PacketNode var1 = AbstractSoundSystem.method2350(ClientPacket.field2383, Client.field911.field1460);
            Client.field911.method2135(var1);

            try {
               Client.field911.method2134();
            } catch (IOException var3) {
               Client.socketError = true;
            }
         }

      }
   }
}
