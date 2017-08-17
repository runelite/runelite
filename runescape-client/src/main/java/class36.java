import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class36 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   static final class36 field510;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   static final class36 field514;
   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -17442263
   )
   static int field513;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -164720647
   )
   final int field509;

   static {
      field514 = new class36(0);
      field510 = new class36(1);
   }

   class36(int var1) {
      this.field509 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Liv;",
      garbageValue = "1073773909"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field3312.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "84"
   )
   static void method508() {
      class97.field1510 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class97.field1519[var0] = null;
         class97.field1508[var0] = 1;
      }

   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(IIIILkp;Lhf;S)V",
      garbageValue = "-24100"
   )
   static final void method510(int var0, int var1, int var2, int var3, SpritePixels var4, class211 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class141.mapedge.method5103(var0 + var14 + 94 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class44.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "-1625906026"
   )
   static int method509(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class84.method1670(class84.intStack[--class84.intStackSize]);
      } else {
         var3 = var2?class43.field582:class208.field2580;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class84.intStack[--class84.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method4013(var4, class84.scriptStringStack[--class91.scriptStringStackSize]);
            return 1;
         } else {
            --class91.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class84.intStackSize -= 2;
         var4 = class84.intStack[class84.intStackSize];
         int var5 = class84.intStack[class84.intStackSize + 1];
         var3.dragParent = class205.method3812(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2727 = class84.intStack[--class84.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2725 = class84.intStack[--class84.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2648 = class84.intStack[--class84.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class84.scriptStringStack[--class91.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class84.scriptStringStack[--class91.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lch;Lch;IZI)I",
      garbageValue = "-318167206"
   )
   static int method511(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1558()?(var1.method1558()?0:1):(var1.method1558()?-1:0)):(var2 == 5?(var0.method1556()?(var1.method1556()?0:1):(var1.method1556()?-1:0)):(var2 == 6?(var0.method1557()?(var1.method1557()?0:1):(var1.method1557()?-1:0)):(var2 == 7?(var0.method1579()?(var1.method1579()?0:1):(var1.method1579()?-1:0)):var0.id - var1.id)))));
      }
   }
}
