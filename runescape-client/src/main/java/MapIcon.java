import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("MapIcon")
public class MapIcon {
   @ObfuscatedName("rt")
   @ObfuscatedGetter(
      intValue = -746124839
   )
   static int field256;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1483125627
   )
   @Export("areaId")
   public final int areaId;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public final Coordinates field247;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public final Coordinates field253;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 858502729
   )
   final int field249;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2026664191
   )
   final int field250;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   final MapLabel field255;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -394071001
   )
   @Export("screenX")
   int screenX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1383282331
   )
   @Export("screenY")
   int screenY;

   @ObfuscatedSignature(
      signature = "(ILhh;Lhh;Lk;)V"
   )
   MapIcon(int var1, Coordinates var2, Coordinates var3, MapLabel var4) {
      this.areaId = var1;
      this.field253 = var2;
      this.field247 = var3;
      this.field255 = var4;
      Area var5 = Area.mapAreaType[this.areaId];
      SpritePixels var6 = var5.getMapIcon(false);
      if(var6 != null) {
         this.field249 = var6.width;
         this.field250 = var6.height;
      } else {
         this.field249 = 0;
         this.field250 = 0;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1416629849"
   )
   boolean method504(int var1, int var2) {
      return this.method514(var1, var2)?true:this.method513(var1, var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1576406958"
   )
   boolean method514(int var1, int var2) {
      Area var3 = Area.mapAreaType[this.areaId];
      switch(var3.horizontalAlignment.value) {
      case 0:
         if(var1 >= this.screenX - this.field249 / 2 && var1 <= this.field249 / 2 + this.screenX) {
            break;
         }

         return false;
      case 1:
         if(var1 >= this.screenX && var1 < this.field249 + this.screenX) {
            break;
         }

         return false;
      case 2:
         if(var1 <= this.screenX - this.field249 || var1 > this.screenX) {
            return false;
         }
      }

      switch(var3.verticalAlignment.value) {
      case 0:
         if(var2 >= this.screenY && var2 < this.screenY + this.field250) {
            break;
         }

         return false;
      case 1:
         if(var2 < this.screenY - this.field250 / 2 || var2 > this.field250 / 2 + this.screenY) {
            return false;
         }
         break;
      case 2:
         if(var2 <= this.screenY - this.field250 || var2 > this.screenY) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1116017209"
   )
   boolean method513(int var1, int var2) {
      return this.field255 == null?false:(var1 >= this.screenX - this.field255.field192 / 2 && var1 <= this.field255.field192 / 2 + this.screenX?var2 >= this.screenY && var2 <= this.field255.field193 + this.screenY:false);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IZB)Ljava/lang/String;",
      garbageValue = "-51"
   )
   public static String method517(int var0, boolean var1) {
      if(var1 && var0 >= 0) {
         int var3 = var0;
         String var2;
         if(var1 && var0 >= 0) {
            int var4 = 2;

            for(int var5 = var0 / 10; var5 != 0; ++var4) {
               var5 /= 10;
            }

            char[] var6 = new char[var4];
            var6[0] = '+';

            for(int var7 = var4 - 1; var7 > 0; --var7) {
               int var8 = var3;
               var3 /= 10;
               int var9 = var8 - var3 * 10;
               if(var9 >= 10) {
                  var6[var7] = (char)(var9 + 87);
               } else {
                  var6[var7] = (char)(var9 + 48);
               }
            }

            var2 = new String(var6);
         } else {
            var2 = Integer.toString(var0, 10);
         }

         return var2;
      } else {
         return Integer.toString(var0);
      }
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "1207880527"
   )
   static final void method515(int var0, int var1, int var2, boolean var3) {
      if(GameCanvas.loadWidget(var0)) {
         class9.method100(Widget.widgets[var0], -1, var1, var2, var3);
      }
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(IIIILlc;Lhr;S)V",
      garbageValue = "15771"
   )
   @Export("worldToMinimap")
   static final void worldToMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, class224 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.field2570 / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         Renderable.mapedge.method5913(var15 + (var0 + var5.field2570 / 2 - var17 / 2), var5.field2575 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         InvType.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }
}
