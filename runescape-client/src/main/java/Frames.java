import java.awt.Canvas;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("qg")
   @Export("canvas")
   public static Canvas canvas;
   @ObfuscatedName("s")
   Frame[] field1814;
   @ObfuscatedName("my")
   @Export("clanMembers")
   static XClanMember[] clanMembers;

   Frames(class170 var1, class170 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3260(var3);
      this.field1814 = new Frame[var6];
      int[] var7 = var1.method3282(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3272(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method3808(); var12 != null; var12 = (FrameMap)var5.method3810()) {
            if(var11 == var12.field1806) {
               var10 = var12;
               break;
            }
         }

         if(null == var10) {
            byte[] var13;
            if(var4) {
               var13 = var2.method3255(0, var11);
            } else {
               var13 = var2.method3255(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.method3801(var10);
         }

         this.field1814[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "64"
   )
   public boolean method2261(int var1) {
      return this.field1814[var1].field1589;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lclass8;",
      garbageValue = "708677721"
   )
   static class8 method2265() {
      FileOnDisk var0 = null;
      class8 var1 = new class8();

      try {
         var0 = class47.method945("", Client.field466.field2330, false);
         byte[] var2 = new byte[(int)var0.method4130()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.method4127(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new class8(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(null != var0) {
            var0.method4128();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIB)I",
      garbageValue = "57"
   )
   public static int method2267(byte[] var0, int var1) {
      return class216.method3942(var0, 0, var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)LModIcon;",
      garbageValue = "-1533581394"
   )
   public static ModIcon method2268() {
      ModIcon var0 = new ModIcon();
      var0.width = class79.field1422;
      var0.originalHeight = class79.field1418;
      var0.offsetX = class79.field1419[0];
      var0.offsetY = XClanMember.field612[0];
      var0.originalWidth = class79.field1420[0];
      var0.height = class8.field129[0];
      var0.palette = class117.field2002;
      var0.pixels = class220.field3211[0];
      class23.method571();
      return var0;
   }
}
