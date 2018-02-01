import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
public class class254 extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   static IndexDataBase field3376;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   static NodeCache field3375;
   @ObfuscatedName("w")
   public boolean field3377;

   static {
      field3375 = new NodeCache(64);
   }

   class254() {
      this.field3377 = false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "665359791"
   )
   void method4579(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4577(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgj;IB)V",
      garbageValue = "-29"
   )
   void method4577(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3377 = true;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1880596928"
   )
   static final void method4588(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class29.field392[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 - 1];
               }

               if(var3 + var1 == var4 && var4 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "996880025"
   )
   static final void method4589(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class213.loadWidget(var0)) {
         Script.field1417 = null;
         class39.gameDraw(FileRequest.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(Script.field1417 != null) {
            class39.gameDraw(Script.field1417, -1412584499, var1, var2, var3, var4, class7.field227, class218.field2667, var7);
            Script.field1417 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1012[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1012[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("kb")
   @ObfuscatedSignature(
      signature = "(IIIILko;Lhu;B)V",
      garbageValue = "1"
   )
   @Export("worldToMinimap")
   static final void worldToMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, class221 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.field2686 / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         class92.mapedge.method5548(var15 + (var0 + var5.field2686 / 2 - var17 / 2), var5.field2684 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         RunException.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }
}
