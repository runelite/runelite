import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kn")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = 551566355
   )
   static int field3814;
   @ObfuscatedName("r")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1739870851
   )
   @Export("width")
   public int width;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -859237123
   )
   @Export("height")
   public int height;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "10"
   )
   public abstract void vmethod5065(int var1, int var2);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-959174772"
   )
   public abstract void vmethod5068(int var1, int var2, int var3, int var4);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "69"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1843200781"
   )
   static final void method5078() {
      int[] var0 = class94.playerIndices;

      int var1;
      for(var1 = 0; var1 < class94.playerIndexesCount; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(var2 != null && var2.field1201 > 0) {
            --var2.field1201;
            if(var2.field1201 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         int var4 = Client.npcIndices[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(var3 != null && var3.field1201 > 0) {
            --var3.field1201;
            if(var3.field1201 == 0) {
               var3.overhead = null;
            }
         }
      }

   }
}
