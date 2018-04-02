import java.net.URL;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
public class class265 {
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      longValue = -2053045313397401527L
   )
   static long field3431;
   @ObfuscatedName("c")
   final HashMap field3426;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Llg;"
   )
   Bounds field3430;
   @ObfuscatedName("o")
   int[] field3425;
   @ObfuscatedName("j")
   int[] field3427;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -513569311
   )
   int field3428;

   public class265() {
      this.field3426 = new HashMap();
      this.field3430 = new Bounds(0, 0);
      this.field3425 = new int[2048];
      this.field3427 = new int[2048];
      this.field3428 = 0;
      WallObject.method3074();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-71"
   )
   void method4707(int var1) {
      int var2 = var1 * 2 + 1;
      double var4 = (double)((float)var1 / 3.0F);
      int var6 = var1 * 2 + 1;
      double[] var7 = new double[var6];
      int var8 = -var1;

      for(int var9 = 0; var8 <= var1; ++var9) {
         double var12 = IndexData.method4664((double)(var8 - 0) / var4) / var4;
         var7[var9] = var12;
         ++var8;
      }

      double[] var14 = var7;
      double var15 = var7[var1] * var7[var1];
      int[] var17 = new int[var2 * var2];
      boolean var18 = false;

      for(int var11 = 0; var11 < var2; ++var11) {
         for(int var19 = 0; var19 < var2; ++var19) {
            int var13 = var17[var19 + var2 * var11] = (int)(256.0D * (var14[var19] * var14[var11] / var15));
            if(!var18 && var13 > 0) {
               var18 = true;
            }
         }
      }

      SpritePixels var20 = new SpritePixels(var17, var2, var2);
      this.field3426.put(Integer.valueOf(var1), var20);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Lla;",
      garbageValue = "8"
   )
   SpritePixels method4706(int var1) {
      if(!this.field3426.containsKey(Integer.valueOf(var1))) {
         this.method4707(var1);
      }

      return (SpritePixels)this.field3426.get(Integer.valueOf(var1));
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-510260419"
   )
   public final void method4709(int var1, int var2) {
      if(this.field3428 < this.field3425.length) {
         this.field3425[this.field3428] = var1;
         this.field3427[this.field3428] = var2;
         ++this.field3428;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1720417176"
   )
   public final void method4710() {
      this.field3428 = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILla;FI)V",
      garbageValue = "-2130305339"
   )
   public final void method4711(int var1, int var2, SpritePixels var3, float var4) {
      int var5 = (int)(18.0F * var4);
      SpritePixels var6 = this.method4706(var5);
      int var7 = var5 * 2 + 1;
      Bounds var8 = new Bounds(0, 0, var3.width, var3.height);
      Bounds var9 = new Bounds(0, 0);
      this.field3430.method5694(var7, var7);
      System.nanoTime();

      int var10;
      int var11;
      int var12;
      for(var10 = 0; var10 < this.field3428; ++var10) {
         var11 = this.field3425[var10];
         var12 = this.field3427[var10];
         int var13 = (int)(var4 * (float)(var11 - var1)) - var5;
         int var14 = (int)((float)var3.height - var4 * (float)(var12 - var2)) - var5;
         this.field3430.method5716(var13, var14);
         this.field3430.method5693(var8, var9);
         this.method4712(var6, var3, var9);
      }

      System.nanoTime();
      System.nanoTime();

      for(var10 = 0; var10 < var3.pixels.length; ++var10) {
         if(var3.pixels[var10] == 0) {
            var3.pixels[var10] = -16777216;
         } else {
            var11 = (var3.pixels[var10] + 64 - 1) / 256;
            if(var11 <= 0) {
               var3.pixels[var10] = -16777216;
            } else {
               if(var11 > class157.field2146.length) {
                  var11 = class157.field2146.length;
               }

               var12 = class157.field2146[var11 - 1];
               var3.pixels[var10] = -16777216 | var12;
            }
         }
      }

      System.nanoTime();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lla;Lla;Llg;I)V",
      garbageValue = "1668310923"
   )
   void method4712(SpritePixels var1, SpritePixels var2, Bounds var3) {
      if(var3.field3936 != 0 && var3.field3937 != 0) {
         int var4 = 0;
         int var5 = 0;
         if(var3.field3939 == 0) {
            var4 = var1.width - var3.field3936;
         }

         if(var3.field3938 == 0) {
            var5 = var1.height - var3.field3937;
         }

         int var6 = var4 + var5 * var1.width;
         int var7 = var3.field3939 + var2.width * var3.field3938;

         for(int var8 = 0; var8 < var3.field3937; ++var8) {
            for(int var9 = 0; var9 < var3.field3936; ++var9) {
               int var10001 = var7++;
               var2.pixels[var10001] += var1.pixels[var6++];
            }

            var6 += var1.width - var3.field3936;
            var7 += var2.width - var3.field3936;
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "811295531"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class21.listFetcher == null) {
            class21.listFetcher = MapIconReference.urlRequester.request(new URL(GameCanvas.field627));
         } else if(class21.listFetcher.isDone()) {
            byte[] var0 = class21.listFetcher.getResponse();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            FaceNormal.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = FaceNormal.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            MapIcon.method574(FaceNormal.worldList, 0, FaceNormal.worldList.length - 1, World.field1220, World.field1224);
            class21.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class21.listFetcher = null;
      }

      return false;
   }
}
