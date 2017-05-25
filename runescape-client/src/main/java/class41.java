import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public final class class41 {
   @ObfuscatedName("p")
   ModIcon[] field542;
   @ObfuscatedName("t")
   HashMap field543;
   @ObfuscatedName("v")
   class34[][] field544;
   @ObfuscatedName("q")
   SpritePixels field545;
   @ObfuscatedName("u")
   class44 field546;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = 79744471
   )
   static int field547;
   @ObfuscatedName("i")
   boolean field548;
   @ObfuscatedName("g")
   HashMap field549;
   @ObfuscatedName("l")
   final HashMap field550;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1940858581
   )
   int field551;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 540764309
   )
   int field552;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1251385847
   )
   int field553;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1917143991
   )
   int field554;
   @ObfuscatedName("h")
   boolean field558;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-894557524"
   )
   public final void method558() {
      this.field549 = null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "1158181652"
   )
   public final void method560(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method571(var1, var2, var3, var4);
      float var15 = this.method568(var7 - var5, var3 - var1);
      int var16 = (int)(64.0F * var15);
      int var17 = this.field551 + var1;
      int var18 = var2 + this.field552;

      int var19;
      int var20;
      for(var19 = var14.field422; var19 < var14.field422 + var14.field420; ++var19) {
         for(var20 = var14.field414; var20 < var14.field415 + var14.field414; ++var20) {
            if(var13) {
               this.field544[var19][var20].method384();
            }

            this.field544[var19][var20].method362(var5 + var16 * (this.field544[var19][var20].field475 * 64 - var17) / 64, var8 - (this.field544[var19][var20].field476 * 64 - var18 + 64) * var16 / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field422; var19 < var14.field420 + var14.field422; ++var19) {
            for(var20 = var14.field414; var20 < var14.field414 + var14.field415; ++var20) {
               this.field544[var19][var20].method422(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;ZI)V",
      garbageValue = "1530255023"
   )
   public void method561(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field558) {
         this.field548 = false;
         this.field558 = true;
         System.nanoTime();
         int var4 = var1.method4189(class40.field538.field540);
         int var5 = var1.method4190(var4, var2);
         Buffer var6 = new Buffer(var1.method4192(class40.field538.field540, var2));
         Buffer var7 = new Buffer(var1.method4192(class40.field532.field540, var2));
         Buffer var8 = new Buffer(var1.method4192(var2, class40.field534.field540));
         System.nanoTime();
         System.nanoTime();
         this.field546 = new class44();

         try {
            this.field546.method640(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var20) {
            return;
         }

         this.field546.method293();
         this.field546.method289();
         this.field546.method273();
         this.field551 = this.field546.method337() * 64;
         this.field552 = this.field546.method286() * 64;
         this.field553 = (this.field546.method285() - this.field546.method337() + 1) * 64;
         this.field554 = (this.field546.method287() - this.field546.method286() + 1) * 64;
         int var17 = this.field546.method285() - this.field546.method337() + 1;
         int var10 = this.field546.method287() - this.field546.method286() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field544 = new class34[var17][var10];
         Iterator var11 = this.field546.field571.iterator();

         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field409;
            int var14 = var12.field404;
            int var15 = var13 - this.field546.method337();
            int var16 = var14 - this.field546.method286();
            this.field544[var15][var16] = new class34(var13, var14, this.field546.method282(), this.field550);
            this.field544[var15][var16].method397(var12, this.field546.field572);
         }

         for(int var18 = 0; var18 < var17; ++var18) {
            for(int var19 = 0; var19 < var10; ++var19) {
               if(this.field544[var18][var19] == null) {
                  this.field544[var18][var19] = new class34(this.field546.method337() + var18, this.field546.method286() + var19, this.field546.method282(), this.field550);
                  this.field544[var18][var19].method358(this.field546.field578, this.field546.field572);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4191(class40.field533.field540, var2)) {
            byte[] var21 = var1.method4192(class40.field533.field540, var2);
            this.field545 = class154.method2980(var21);
         }

         System.nanoTime();
         this.field548 = true;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;IIB)V",
      garbageValue = "0"
   )
   public void method562(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field545 != null) {
         this.field545.method5134(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field549 == null) {
               this.method567();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field549.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field527.field2600 - this.field551) / this.field553;
                  int var14 = var4 - var4 * (var12.field527.field2601 - this.field552) / this.field554;
                  Rasterizer2D.method5004(var1 + var13, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "1970232593"
   )
   public List method563(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field548) {
         return var11;
      } else {
         class29 var12 = this.method571(var1, var2, var3, var4);
         float var13 = this.method568(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = var1 + this.field551;
         int var16 = this.field552 + var2;

         for(int var17 = var12.field422; var17 < var12.field422 + var12.field420; ++var17) {
            for(int var18 = var12.field414; var18 < var12.field414 + var12.field415; ++var18) {
               List var19 = this.field544[var17][var18].method386(var5 + var14 * (this.field544[var17][var18].field475 * 64 - var15) / 64, var6 + var8 - (this.field544[var17][var18].field476 * 64 - var16 + 64) * var14 / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[Lclass34;I)V",
      garbageValue = "907727229"
   )
   void method564(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field544.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field544[0].length - 1;
      if(var7) {
         var3[class228.field3145.vmethod5090()] = null;
      } else {
         var3[class228.field3145.vmethod5090()] = this.field544[var1][var2 + 1];
      }

      var3[class228.field3137.vmethod5090()] = !var7 && !var5?this.field544[var1 + 1][var2 + 1]:null;
      var3[class228.field3143.vmethod5090()] = !var7 && !var4?this.field544[var1 - 1][var2 + 1]:null;
      var3[class228.field3138.vmethod5090()] = var5?null:this.field544[var1 + 1][var2];
      var3[class228.field3139.vmethod5090()] = var4?null:this.field544[var1 - 1][var2];
      var3[class228.field3140.vmethod5090()] = var6?null:this.field544[var1][var2 - 1];
      var3[class228.field3142.vmethod5090()] = !var6 && !var5?this.field544[var1 + 1][var2 - 1]:null;
      var3[class228.field3141.vmethod5090()] = !var6 && !var4?this.field544[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "2097567655"
   )
   public HashMap method566() {
      this.method567();
      return this.field549;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method567() {
      if(this.field549 == null) {
         this.field549 = new HashMap();
      }

      this.field549.clear();

      for(int var1 = 0; var1 < this.field544.length; ++var1) {
         for(int var2 = 0; var2 < this.field544[var1].length; ++var2) {
            List var3 = this.field544[var1][var2].method392();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field549.containsKey(Integer.valueOf(var5.field526))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field549.put(Integer.valueOf(var5.field526), var6);
               } else {
                  List var7 = (List)this.field549.get(Integer.valueOf(var5.field526));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)F",
      garbageValue = "101"
   )
   float method568(int var1, int var2) {
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIB)Lclass29;",
      garbageValue = "-34"
   )
   class29 method571(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field551 + var1;
      int var7 = this.field552 + var2;
      int var8 = this.field551 + var3;
      int var9 = this.field552 + var4;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field420 = var12 - var10 + 1;
      var5.field415 = var13 - var11 + 1;
      var5.field422 = var10 - this.field546.method337();
      var5.field414 = var11 - this.field546.method286();
      if(var5.field422 < 0) {
         var5.field420 += var5.field422;
         var5.field422 = 0;
      }

      if(var5.field422 > this.field544.length - var5.field420) {
         var5.field420 = this.field544.length - var5.field422;
      }

      if(var5.field414 < 0) {
         var5.field415 += var5.field414;
         var5.field414 = 0;
      }

      if(var5.field414 > this.field544[0].length - var5.field415) {
         var5.field415 = this.field544[0].length - var5.field414;
      }

      var5.field420 = Math.min(var5.field420, this.field544.length);
      var5.field415 = Math.min(var5.field415, this.field544[0].length);
      return var5;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-29268332"
   )
   public final void method572(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.method5000(var12);
      class29 var13 = this.method571(var1, var2, var3, var4);
      float var14 = this.method568(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field543.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method681();
         this.field543.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field422; var17 < var13.field420 + var13.field422; ++var17) {
         for(var18 = var13.field414; var18 < var13.field415 + var13.field414; ++var18) {
            this.method564(var17, var18, var22);
            this.field544[var17][var18].method436(var15, (class46)this.field543.get(Integer.valueOf(var15)), var22, this.field542);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.method5001(var12);
      var17 = (int)(64.0F * var14);
      var18 = var1 + this.field551;
      int var19 = var2 + this.field552;

      for(int var20 = var13.field422; var20 < var13.field422 + var13.field420; ++var20) {
         for(int var21 = var13.field414; var21 < var13.field414 + var13.field415; ++var21) {
            this.field544[var20][var21].method356(var17 * (this.field544[var20][var21].field475 * 64 - var18) / 64 + var5, var8 - (this.field544[var20][var21].field476 * 64 - var19 + 64) * var17 / 64, var17);
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1425776180"
   )
   public boolean method586() {
      return this.field548;
   }

   public class41(ModIcon[] var1, HashMap var2) {
      this.field548 = false;
      this.field558 = false;
      this.field543 = new HashMap();
      this.field542 = var1;
      this.field550 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-19"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(World.worldServersDownload == null) {
            World.worldServersDownload = new class77(GameEngine.field682, new URL(class4.field20));
         } else {
            byte[] var0 = World.worldServersDownload.method1517();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.field1267 = var1.readUnsignedShort();
               World.worldList = new World[World.field1267];

               World var3;
               for(int var2 = 0; var2 < World.field1267; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.readInt();
                  var3.address = var1.readString();
                  var3.activity = var1.readString();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.readShort();
               }

               class238.method4327(World.worldList, 0, World.worldList.length - 1, World.field1270, World.field1269);
               World.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         World.worldServersDownload = null;
      }

      return false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1624075395"
   )
   public static void method604() {
      class59 var0 = class59.mouse;
      synchronized(class59.mouse) {
         class59.field732 = class59.field720;
         class59.field721 = class59.mouseX;
         class59.field722 = class59.mouseY;
         class59.field727 = class59.field723;
         class59.field717 = class59.field724;
         class59.field729 = class59.field725;
         class59.field715 = class59.field726;
         class59.field723 = 0;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "643202828"
   )
   public static int method605(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }
}
