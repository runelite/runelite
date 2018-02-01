import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("p")
   long[] field2085;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1749605097
   )
   int field2084;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -678664973
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 1162502362326081455L
   )
   @Export("milliTime")
   long milliTime;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -725325727
   )
   int field2086;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 658985141
   )
   int field2089;

   MilliTimer() {
      this.field2085 = new long[10];
      this.field2084 = 256;
      this.sleepTime = 1;
      this.field2086 = 0;
      this.milliTime = ScriptVarType.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2085[var1] = this.milliTime;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "41"
   )
   public void vmethod3175() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2085[var1] = 0L;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-791155116"
   )
   public int vmethod3176(int var1, int var2) {
      int var3 = this.field2084;
      int var4 = this.sleepTime;
      this.field2084 = 300;
      this.sleepTime = 1;
      this.milliTime = ScriptVarType.currentTimeMs();
      if(this.field2085[this.field2089] == 0L) {
         this.field2084 = var3;
         this.sleepTime = var4;
      } else if(this.milliTime > this.field2085[this.field2089]) {
         this.field2084 = (int)((long)(var1 * 2560) / (this.milliTime - this.field2085[this.field2089]));
      }

      if(this.field2084 < 25) {
         this.field2084 = 25;
      }

      if(this.field2084 > 256) {
         this.field2084 = 256;
         this.sleepTime = (int)((long)var1 - (this.milliTime - this.field2085[this.field2089]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2085[this.field2089] = this.milliTime;
      this.field2089 = (this.field2089 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field2085[var5] != 0L) {
               this.field2085[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      class1.method3((long)this.sleepTime);

      for(var5 = 0; this.field2086 < 256; this.field2086 += this.field2084) {
         ++var5;
      }

      this.field2086 &= 255;
      return var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1396953330"
   )
   public static boolean method3053(char var0) {
      return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1518073669"
   )
   @Export("worldToScreen")
   static final void worldToScreen(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = GameCanvas.getTileHeight(var0, var1, MessageNode.plane) - var2;
         var0 -= Actor.cameraX;
         var3 -= class60.cameraZ;
         var1 -= GameCanvas.cameraY;
         int var4 = Graphics3D.SINE[SceneTilePaint.cameraPitch];
         int var5 = Graphics3D.COSINE[SceneTilePaint.cameraPitch];
         int var6 = Graphics3D.SINE[class33.cameraYaw];
         int var7 = Graphics3D.COSINE[class33.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var3 * var4 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.screenX = var0 * Client.scale / var1 + Client.viewportWidth / 2;
            Client.screenY = var8 * Client.scale / var1 + Client.viewportHeight / 2;
         } else {
            Client.screenX = -1;
            Client.screenY = -1;
         }

      } else {
         Client.screenX = -1;
         Client.screenY = -1;
      }
   }
}
