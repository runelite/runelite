import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("o")
   public static class182 field1592;
   @ObfuscatedName("dw")
   static byte[][] field1593;
   @ObfuscatedName("a")
   static String[] field1594;
   @ObfuscatedName("f")
   Frame[] field1595;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1662589426"
   )
   public boolean method1935(int var1) {
      return this.field1595[var1].field1348;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "99"
   )
   static final void method1937() {
      int var0 = Client.field366 + Projectile.localPlayer.x;
      int var1 = Client.field573 + Projectile.localPlayer.y;
      if(class36.field786 - var0 < -500 || class36.field786 - var0 > 500 || class180.field2720 - var1 < -500 || class180.field2720 - var1 > 500) {
         class36.field786 = var0;
         class180.field2720 = var1;
      }

      if(class36.field786 != var0) {
         class36.field786 += (var0 - class36.field786) / 16;
      }

      if(var1 != class180.field2720) {
         class180.field2720 += (var1 - class180.field2720) / 16;
      }

      int var2;
      int var3;
      if(class115.field1811 == 4 && class177.field2687) {
         var2 = class115.field1818 - Client.field317;
         Client.field388 = var2 * 2;
         Client.field317 = var2 != -1 && var2 != 1?(class115.field1818 + Client.field317) / 2:class115.field1818;
         var3 = Client.field315 - class115.field1817;
         Client.field387 = var3 * 2;
         Client.field315 = var3 != -1 && var3 != 1?(Client.field315 + class115.field1817) / 2:class115.field1817;
      } else {
         if(class105.field1734[96]) {
            Client.field387 += (-24 - Client.field387) / 2;
         } else if(class105.field1734[97]) {
            Client.field387 += (24 - Client.field387) / 2;
         } else {
            Client.field387 /= 2;
         }

         if(class105.field1734[98]) {
            Client.field388 += (12 - Client.field388) / 2;
         } else if(class105.field1734[99]) {
            Client.field388 += (-12 - Client.field388) / 2;
         } else {
            Client.field388 /= 2;
         }

         Client.field317 = class115.field1818;
         Client.field315 = class115.field1817;
      }

      Client.mapAngle = Client.field387 / 2 + Client.mapAngle & 2047;
      Client.field398 += Client.field388 / 2;
      if(Client.field398 < 128) {
         Client.field398 = 128;
      }

      if(Client.field398 > 383) {
         Client.field398 = 383;
      }

      var2 = class36.field786 >> 7;
      var3 = class180.field2720 >> 7;
      int var4 = class103.method2025(class36.field786, class180.field2720, Sequence.plane);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
            for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
               int var8 = Sequence.plane;
               if(var8 < 3 && (class10.tileSettings[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class10.tileHeights[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = 192 * var5;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < '耀') {
         var6 = '耀';
      }

      if(var6 > Client.field394) {
         Client.field394 += (var6 - Client.field394) / 24;
      } else if(var6 < Client.field394) {
         Client.field394 += (var6 - Client.field394) / 80;
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IZ)V",
      garbageValue = "0"
   )
   public Frames(class182 var1, class182 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3346(var3);
      this.field1595 = new Frame[var6];
      int[] var7 = var1.method3345(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method2464(); null != var12; var12 = (FrameMap)var5.method2472()) {
            if(var11 == var12.field1494) {
               var10 = var12;
               break;
            }
         }

         if(null == var10) {
            byte[] var13 = var2.method3371(var11, 0);
            var10 = new FrameMap(var11, var13);
            var5.method2459(var10);
         }

         this.field1595[var7[var8]] = new Frame(var9, var10);
      }

   }
}
