import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class43 extends CacheableNode {
   @ObfuscatedName("e")
   static NodeCache field975 = new NodeCache(64);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1612145143
   )
   int field976 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1706277679
   )
   public int field977;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1786987943
   )
   public int field978;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -343436063
   )
   public int field980;
   @ObfuscatedName("f")
   public static class170 field981;
   @ObfuscatedName("o")
   static String[] field982;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 939217687
   )
   public int field983;
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = 1571195421
   )
   static int field985;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1285240690"
   )
   void method861() {
      this.method864(this.field976);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2142758539"
   )
   void method862(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.method2656();
         if(var3 == 0) {
            return;
         }

         this.method863(var1, var3, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIB)V",
      garbageValue = "0"
   )
   void method863(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field976 = var1.method2537();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-508196447"
   )
   void method864(int var1) {
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
      double var16 = (var10 + var8) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field978 = (int)(256.0D * var14);
      this.field983 = (int)(256.0D * var16);
      if(this.field978 < 0) {
         this.field978 = 0;
      } else if(this.field978 > 255) {
         this.field978 = 255;
      }

      if(this.field983 < 0) {
         this.field983 = 0;
      } else if(this.field983 > 255) {
         this.field983 = 255;
      }

      if(var16 > 0.5D) {
         this.field980 = (int)(512.0D * (1.0D - var16) * var14);
      } else {
         this.field980 = (int)(512.0D * var14 * var16);
      }

      if(this.field980 < 1) {
         this.field980 = 1;
      }

      this.field977 = (int)(var12 * (double)this.field980);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1391421874"
   )
   static final void method866(boolean var0) {
      while(true) {
         if(Client.field327.method2787(Client.field328) >= 27) {
            int var1 = Client.field327.method2771(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(null == Client.cachedNPCs[var1]) {
                  Client.cachedNPCs[var1] = new NPC();
                  var2 = true;
               }

               NPC var3 = Client.cachedNPCs[var1];
               Client.field405[++Client.field321 - 1] = var1;
               var3.field865 = Client.gameCycle;
               int var4;
               if(var0) {
                  var4 = Client.field327.method2771(8);
                  if(var4 > 127) {
                     var4 -= 256;
                  }
               } else {
                  var4 = Client.field327.method2771(5);
                  if(var4 > 15) {
                     var4 -= 32;
                  }
               }

               int var5;
               if(var0) {
                  var5 = Client.field327.method2771(8);
                  if(var5 > 127) {
                     var5 -= 256;
                  }
               } else {
                  var5 = Client.field327.method2771(5);
                  if(var5 > 15) {
                     var5 -= 32;
                  }
               }

               int var6 = Client.field352[Client.field327.method2771(3)];
               if(var2) {
                  var3.field873 = var3.angle = var6;
               }

               var3.composition = World.getNpcDefinition(Client.field327.method2771(14));
               int var7 = Client.field327.method2771(1);
               int var8 = Client.field327.method2771(1);
               if(var8 == 1) {
                  Client.field456[++Client.field323 - 1] = var1;
               }

               var3.field842 = var3.composition.field894;
               var3.field869 = var3.composition.field888;
               if(var3.field869 == 0) {
                  var3.angle = 0;
               }

               var3.field824 = var3.composition.field895;
               var3.field825 = var3.composition.field893;
               var3.field826 = var3.composition.field897;
               var3.field827 = var3.composition.field892;
               var3.idlePoseAnimation = var3.composition.field889;
               var3.field847 = var3.composition.field912;
               var3.field823 = var3.composition.field919;
               var3.method741(var5 + class34.localPlayer.pathX[0], var4 + class34.localPlayer.pathY[0], var7 == 1);
               continue;
            }
         }

         Client.field327.method2778();
         return;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1900149154"
   )
   static byte[] method877(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }
}
