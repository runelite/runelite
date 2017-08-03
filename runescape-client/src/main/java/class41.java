import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public final class class41 {
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1256402875
   )
   @Export("authCodeForLogin")
   static int authCodeForLogin;
   @ObfuscatedName("fb")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   static class47 field519;
   @ObfuscatedName("q")
   boolean field520;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   SpritePixels field522;
   @ObfuscatedName("d")
   boolean field529;
   @ObfuscatedName("e")
   HashMap field524;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "[[Lau;"
   )
   class34[][] field523;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -248603041
   )
   int field528;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1842120947
   )
   int field527;
   @ObfuscatedName("v")
   HashMap field525;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "[Ljw;"
   )
   IndexedSprite[] field526;
   @ObfuscatedName("i")
   final HashMap field535;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   class44 field521;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -840439295
   )
   int field531;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 227390095
   )
   int field530;

   @ObfuscatedSignature(
      signature = "([Ljw;Ljava/util/HashMap;)V"
   )
   public class41(IndexedSprite[] var1, HashMap var2) {
      this.field529 = false;
      this.field520 = false;
      this.field525 = new HashMap();
      this.field526 = var1;
      this.field535 = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-295074425"
   )
   void method570() {
      if(this.field524 == null) {
         this.field524 = new HashMap();
      }

      this.field524.clear();

      for(int var1 = 0; var1 < this.field523.length; ++var1) {
         for(int var2 = 0; var2 < this.field523[var1].length; ++var2) {
            List var3 = this.field523[var1][var2].method395();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field524.containsKey(Integer.valueOf(var5.field505))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field524.put(Integer.valueOf(var5.field505), var6);
               } else {
                  List var7 = (List)this.field524.get(Integer.valueOf(var5.field505));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIII)Lat;",
      garbageValue = "-102545164"
   )
   class29 method560(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field528 + var1;
      int var7 = var2 + this.field527;
      int var8 = var3 + this.field528;
      int var9 = var4 + this.field527;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field395 = var12 - var10 + 1;
      var5.field398 = var13 - var11 + 1;
      var5.field396 = var10 - this.field521.method289();
      var5.field394 = var11 - this.field521.method319();
      if(var5.field396 < 0) {
         var5.field395 += var5.field396;
         var5.field396 = 0;
      }

      if(var5.field396 > this.field523.length - var5.field395) {
         var5.field395 = this.field523.length - var5.field396;
      }

      if(var5.field394 < 0) {
         var5.field398 += var5.field394;
         var5.field394 = 0;
      }

      if(var5.field394 > this.field523[0].length - var5.field398) {
         var5.field398 = this.field523[0].length - var5.field394;
      }

      var5.field395 = Math.min(var5.field395, this.field523.length);
      var5.field398 = Math.min(var5.field398, this.field523[0].length);
      return var5;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)F",
      garbageValue = "-9"
   )
   float method597(int var1, int var2) {
      float var3 = (float)var1 / (float)var2;
      if(var3 > 8.0F) {
         return 8.0F;
      } else if(var3 < 1.0F) {
         return 1.0F;
      } else {
         int var4 = Math.round(var3);
         return Math.abs((float)var4 - var3) < 0.05F?(float)var4:var3;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1702495768"
   )
   public boolean method568() {
      return this.field529;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "1116502106"
   )
   public HashMap method569() {
      this.method570();
      return this.field524;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "-460244239"
   )
   public void method579(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field522 != null) {
         this.field522.method5071(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field524 == null) {
               this.method570();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field524.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field504.worldX - this.field528) / this.field531;
                  int var14 = var4 - (var12.field504.worldY - this.field527) * var4 / this.field530;
                  Rasterizer2D.method4935(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lim;Ljava/lang/String;ZI)V",
      garbageValue = "-2108591385"
   )
   public void method575(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field520) {
         this.field529 = false;
         this.field520 = true;
         System.nanoTime();
         int var4 = var1.getFile(class40.field515.field510);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.method4132(class40.field515.field510, var2));
         Buffer var7 = new Buffer(var1.method4132(class40.field516.field510, var2));
         Buffer var8 = new Buffer(var1.method4132(var2, class40.field512.field510));
         System.nanoTime();
         System.nanoTime();
         this.field521 = new class44();

         try {
            this.field521.method637(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var20) {
            return;
         }

         this.field521.method292();
         this.field521.method296();
         this.field521.method294();
         this.field528 = this.field521.method289() * 64;
         this.field527 = this.field521.method319() * 64;
         this.field531 = (this.field521.method290() - this.field521.method289() + 1) * 64;
         this.field530 = (this.field521.method276() - this.field521.method319() + 1) * 64;
         int var9 = this.field521.method290() - this.field521.method289() + 1;
         int var10 = this.field521.method276() - this.field521.method319() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field523 = new class34[var9][var10];
         Iterator var11 = this.field521.field546.iterator();

         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field384;
            int var14 = var12.field380;
            int var15 = var13 - this.field521.method289();
            int var16 = var14 - this.field521.method319();
            this.field523[var15][var16] = new class34(var13, var14, this.field521.method287(), this.field535);
            this.field523[var15][var16].method359(var12, this.field521.field550);
         }

         for(int var17 = 0; var17 < var9; ++var17) {
            for(int var18 = 0; var18 < var10; ++var18) {
               if(this.field523[var17][var18] == null) {
                  this.field523[var17][var18] = new class34(this.field521.method289() + var17, this.field521.method319() + var18, this.field521.method287(), this.field535);
                  this.field523[var17][var18].method421(this.field521.field547, this.field521.field550);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4150(class40.field511.field510, var2)) {
            byte[] var21 = var1.method4132(class40.field511.field510, var2);
            this.field522 = class64.method1103(var21);
         }

         System.nanoTime();
         this.field529 = true;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "-1518735289"
   )
   public List method566(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field529) {
         return var11;
      } else {
         class29 var12 = this.method560(var1, var2, var3, var4);
         float var13 = this.method597(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.field528 + var1;
         int var16 = var2 + this.field527;

         for(int var17 = var12.field396; var17 < var12.field396 + var12.field395; ++var17) {
            for(int var18 = var12.field394; var18 < var12.field398 + var12.field394; ++var18) {
               List var19 = this.field523[var17][var18].method394((this.field523[var17][var18].field455 * 64 - var15) * var14 / 64 + var5, var8 + var6 - (64 + (this.field523[var17][var18].field465 * 64 - var16)) * var14 / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-228174473"
   )
   public final void method561() {
      this.field524 = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II[Lau;I)V",
      garbageValue = "-1318077885"
   )
   void method564(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field523.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field523[0].length - 1;
      if(var7) {
         var3[class228.field3137.rsOrdinal()] = null;
      } else {
         var3[class228.field3137.rsOrdinal()] = this.field523[var1][var2 + 1];
      }

      var3[class228.field3128.rsOrdinal()] = !var7 && !var5?this.field523[var1 + 1][var2 + 1]:null;
      var3[class228.field3132.rsOrdinal()] = !var7 && !var4?this.field523[var1 - 1][var2 + 1]:null;
      var3[class228.field3134.rsOrdinal()] = var5?null:this.field523[var1 + 1][var2];
      var3[class228.field3133.rsOrdinal()] = var4?null:this.field523[var1 - 1][var2];
      var3[class228.field3131.rsOrdinal()] = var6?null:this.field523[var1][var2 - 1];
      var3[class228.field3130.rsOrdinal()] = !var6 && !var5?this.field523[var1 + 1][var2 - 1]:null;
      var3[class228.field3139.rsOrdinal()] = !var6 && !var4?this.field523[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1736239473"
   )
   public final void method565(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method560(var1, var2, var3, var4);
      float var14 = this.method597(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field525.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method690();
         this.field525.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field396; var17 < var13.field396 + var13.field395; ++var17) {
         for(var18 = var13.field394; var18 < var13.field394 + var13.field398; ++var18) {
            this.method564(var17, var18, var22);
            this.field523[var17][var18].method433(var15, (class46)this.field525.get(Integer.valueOf(var15)), var22, this.field526);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(64.0F * var14);
      var18 = this.field528 + var1;
      int var19 = var2 + this.field527;

      for(int var20 = var13.field396; var20 < var13.field396 + var13.field395; ++var20) {
         for(int var21 = var13.field394; var21 < var13.field394 + var13.field398; ++var21) {
            this.field523[var20][var21].method358(var5 + (this.field523[var20][var21].field455 * 64 - var18) * var17 / 64, var8 - var17 * (64 + (this.field523[var20][var21].field465 * 64 - var19)) / 64, var17);
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "-2116798754"
   )
   public final void method563(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method560(var1, var2, var3, var4);
      float var15 = this.method597(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.field528 + var1;
      int var18 = var2 + this.field527;

      int var19;
      int var20;
      for(var19 = var14.field396; var19 < var14.field396 + var14.field395; ++var19) {
         for(var20 = var14.field394; var20 < var14.field394 + var14.field398; ++var20) {
            if(var13) {
               this.field523[var19][var20].method445();
            }

            this.field523[var19][var20].method364(var16 * (this.field523[var19][var20].field455 * 64 - var17) / 64 + var5, var8 - var16 * (this.field523[var19][var20].field465 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field396; var19 < var14.field396 + var14.field395; ++var19) {
            for(var20 = var14.field394; var20 < var14.field394 + var14.field398; ++var20) {
               this.field523[var19][var20].method365(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Lcn;",
      garbageValue = "-1520238049"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class155.field2217, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class155.field2227 == 33) {
         var4 = "_rc";
      } else if(class155.field2227 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class60.userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(Lbt;B)V",
      garbageValue = "1"
   )
   static final void method577(class66 var0) {
      if(class224.localPlayer.x >> 7 == Client.destinationX && class224.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

      int var1 = class96.field1470;
      int[] var2 = class96.field1468;
      int var3 = var1;
      if(class66.field784 == var0 || class66.field785 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class66.field784 == var0) {
            var5 = class224.localPlayer;
            var6 = class224.localPlayer.field865 << 14;
         } else if(class66.field785 == var0) {
            var5 = Client.cachedPlayers[Client.field927];
            var6 = Client.field927 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class66.field787 == var0 && var2[var4] == Client.field927) {
               continue;
            }
         }

         if(var5 != null && var5.hasConfig() && !var5.hidden) {
            var5.field875 = false;
            if((Client.lowMemory && var1 > 50 || var1 > 200) && class66.field784 != var0 && var5.poseAnimation == var5.idlePoseAnimation) {
               var5.field875 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.field878 && Client.gameCycle < var5.field860) {
                  var5.field875 = false;
                  var5.field864 = class18.getTileHeight(var5.x, var5.y, class8.plane);
                  class51.region.method2728(class8.plane, var5.x, var5.y, var5.field864, 60, var5, var5.angle, var6, var5.field871, var5.field872, var5.field873, var5.field880);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field986[var7][var8] == Client.field1038) {
                        continue;
                     }

                     Client.field986[var7][var8] = Client.field1038;
                  }

                  var5.field864 = class18.getTileHeight(var5.x, var5.y, class8.plane);
                  class51.region.method2711(class8.plane, var5.x, var5.y, var5.field864, 60, var5, var5.angle, var6, var5.field1192);
               }
            }
         }
      }

   }
}
