import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public final class class41 {
   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   static class239 field528;
   @ObfuscatedName("m")
   boolean field531;
   @ObfuscatedName("p")
   boolean field519;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   class44 field520;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   SpritePixels field521;
   @ObfuscatedName("v")
   HashMap field529;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[[Lak;"
   )
   class34[][] field523;
   @ObfuscatedName("e")
   HashMap field537;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Lko;"
   )
   IndexedSprite[] field525;
   @ObfuscatedName("b")
   final HashMap field530;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1409094325
   )
   int field527;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 83878245
   )
   int field518;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1433090325
   )
   int field526;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -112345097
   )
   int field532;

   @ObfuscatedSignature(
      signature = "([Lko;Ljava/util/HashMap;)V"
   )
   public class41(IndexedSprite[] var1, HashMap var2) {
      this.field531 = false;
      this.field519 = false;
      this.field537 = new HashMap();
      this.field525 = var1;
      this.field530 = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lik;Ljava/lang/String;ZI)V",
      garbageValue = "-846153522"
   )
   public void method604(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field519) {
         this.field531 = false;
         this.field519 = true;
         System.nanoTime();
         int var4 = var1.getFile(class40.field514.field512);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.method4308(class40.field514.field512, var2));
         Buffer var7 = new Buffer(var1.method4308(class40.field510.field512, var2));
         Buffer var8 = new Buffer(var1.method4308(var2, class40.field515.field512));
         System.nanoTime();
         System.nanoTime();
         this.field520 = new class44();

         try {
            this.field520.method680(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var20) {
            return;
         }

         this.field520.method328();
         this.field520.method317();
         this.field520.method329();
         this.field527 = this.field520.method323() * 64;
         this.field518 = this.field520.method325() * 64;
         this.field526 = (this.field520.method324() - this.field520.method323() + 1) * 64;
         this.field532 = (this.field520.method326() - this.field520.method325() + 1) * 64;
         int var9 = this.field520.method324() - this.field520.method323() + 1;
         int var10 = this.field520.method326() - this.field520.method325() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field523 = new class34[var9][var10];
         Iterator var11 = this.field520.field554.iterator();

         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field399;
            int var14 = var12.field392;
            int var15 = var13 - this.field520.method323();
            int var16 = var14 - this.field520.method325();
            this.field523[var15][var16] = new class34(var13, var14, this.field520.method321(), this.field530);
            this.field523[var15][var16].method400(var12, this.field520.field556);
         }

         for(int var17 = 0; var17 < var9; ++var17) {
            for(int var18 = 0; var18 < var10; ++var18) {
               if(this.field523[var17][var18] == null) {
                  this.field523[var17][var18] = new class34(this.field520.method323() + var17, this.field520.method325() + var18, this.field520.method321(), this.field530);
                  this.field523[var17][var18].method434(this.field520.field558, this.field520.field556);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4297(class40.field509.field512, var2)) {
            byte[] var21 = var1.method4308(class40.field509.field512, var2);
            this.field521 = class230.method4239(var21);
         }

         System.nanoTime();
         this.field531 = true;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "178642707"
   )
   public final void method600() {
      this.field529 = null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "545135221"
   )
   public final void method602(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method606(var1, var2, var3, var4);
      float var14 = this.method610(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field537.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method739();
         this.field537.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field405; var17 < var13.field405 + var13.field404; ++var17) {
         for(var18 = var13.field406; var18 < var13.field406 + var13.field407; ++var18) {
            this.method629(var17, var18, var22);
            this.field523[var17][var18].method404(var15, (class46)this.field537.get(Integer.valueOf(var15)), var22, this.field525);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field527 + var1;
      int var19 = var2 + this.field518;

      for(int var20 = var13.field405; var20 < var13.field404 + var13.field405; ++var20) {
         for(int var21 = var13.field406; var21 < var13.field406 + var13.field407; ++var21) {
            this.field523[var20][var21].method486(var5 + var17 * (this.field523[var20][var21].field452 * 64 - var18) / 64, var8 - var17 * (this.field523[var20][var21].field451 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "2119390289"
   )
   public final void method598(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method606(var1, var2, var3, var4);
      float var15 = this.method610(var7 - var5, var3 - var1);
      int var16 = (int)(64.0F * var15);
      int var17 = this.field527 + var1;
      int var18 = var2 + this.field518;

      int var19;
      int var20;
      for(var19 = var14.field405; var19 < var14.field404 + var14.field405; ++var19) {
         for(var20 = var14.field406; var20 < var14.field406 + var14.field407; ++var20) {
            if(var13) {
               this.field523[var19][var20].method532();
            }

            this.field523[var19][var20].method405(var5 + var16 * (this.field523[var19][var20].field452 * 64 - var17) / 64, var8 - var16 * (this.field523[var19][var20].field451 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field405; var19 < var14.field404 + var14.field405; ++var19) {
            for(var20 = var14.field406; var20 < var14.field406 + var14.field407; ++var20) {
               this.field523[var19][var20].method432(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II[Lak;B)V",
      garbageValue = "110"
   )
   void method629(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field523.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field523[0].length - 1;
      if(var7) {
         var3[class235.field3217.rsOrdinal()] = null;
      } else {
         var3[class235.field3217.rsOrdinal()] = this.field523[var1][var2 + 1];
      }

      var3[class235.field3219.rsOrdinal()] = !var7 && !var5?this.field523[var1 + 1][var2 + 1]:null;
      var3[class235.field3224.rsOrdinal()] = !var7 && !var4?this.field523[var1 - 1][var2 + 1]:null;
      var3[class235.field3225.rsOrdinal()] = var5?null:this.field523[var1 + 1][var2];
      var3[class235.field3223.rsOrdinal()] = var4?null:this.field523[var1 - 1][var2];
      var3[class235.field3221.rsOrdinal()] = var6?null:this.field523[var1][var2 - 1];
      var3[class235.field3220.rsOrdinal()] = !var6 && !var5?this.field523[var1 + 1][var2 - 1]:null;
      var3[class235.field3222.rsOrdinal()] = !var6 && !var4?this.field523[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "-487321888"
   )
   public void method644(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field521 != null) {
         this.field521.method5295(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field529 == null) {
               this.method609();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field529.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field499.worldX - this.field527) / this.field526;
                  int var14 = var4 - (var12.field499.worldY - this.field518) * var4 / this.field532;
                  Rasterizer2D.method5149(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIIB)Ljava/util/List;",
      garbageValue = "1"
   )
   public List method601(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field531) {
         return var11;
      } else {
         class29 var12 = this.method606(var1, var2, var3, var4);
         float var13 = this.method610(var7, var3 - var1);
         int var14 = (int)(64.0F * var13);
         int var15 = this.field527 + var1;
         int var16 = var2 + this.field518;

         for(int var17 = var12.field405; var17 < var12.field404 + var12.field405; ++var17) {
            for(int var18 = var12.field406; var18 < var12.field406 + var12.field407; ++var18) {
               List var19 = this.field523[var17][var18].method435(var5 + var14 * (this.field523[var17][var18].field452 * 64 - var15) / 64, var8 + var6 - var14 * (this.field523[var17][var18].field451 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIII)Lab;",
      garbageValue = "442587842"
   )
   class29 method606(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field527 + var1;
      int var7 = var2 + this.field518;
      int var8 = var3 + this.field527;
      int var9 = var4 + this.field518;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field404 = var12 - var10 + 1;
      var5.field407 = var13 - var11 + 1;
      var5.field405 = var10 - this.field520.method323();
      var5.field406 = var11 - this.field520.method325();
      if(var5.field405 < 0) {
         var5.field404 += var5.field405;
         var5.field405 = 0;
      }

      if(var5.field405 > this.field523.length - var5.field404) {
         var5.field404 = this.field523.length - var5.field405;
      }

      if(var5.field406 < 0) {
         var5.field407 += var5.field406;
         var5.field406 = 0;
      }

      if(var5.field406 > this.field523[0].length - var5.field407) {
         var5.field407 = this.field523[0].length - var5.field406;
      }

      var5.field404 = Math.min(var5.field404, this.field523.length);
      var5.field407 = Math.min(var5.field407, this.field523[0].length);
      return var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1056207249"
   )
   public boolean method607() {
      return this.field531;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "-763397496"
   )
   public HashMap method608() {
      this.method609();
      return this.field529;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-895483852"
   )
   void method609() {
      if(this.field529 == null) {
         this.field529 = new HashMap();
      }

      this.field529.clear();

      for(int var1 = 0; var1 < this.field523.length; ++var1) {
         for(int var2 = 0; var2 < this.field523[var1].length; ++var2) {
            List var3 = this.field523[var1][var2].method466();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field529.containsKey(Integer.valueOf(var5.field508))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field529.put(Integer.valueOf(var5.field508), var6);
               } else {
                  List var7 = (List)this.field529.get(Integer.valueOf(var5.field508));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "-1718703988"
   )
   float method610(int var1, int var2) {
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Len;IIIB)V",
      garbageValue = "8"
   )
   public static final void method642(Model var0, int var1, int var2, int var3) {
      if(class48.method794(var0, var1, var2, var3)) {
         class18.method158(var0, var1, var2, var3, -65281);
      } else if(class7.field229 == class11.field261) {
         class18.method158(var0, var1, var2, var3, -16776961);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILhy;I)Lcw;",
      garbageValue = "981241636"
   )
   static Script method640(int var0, class226 var1) {
      Script var2 = (Script)Script.field1445.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = class43.indexScripts.getFile(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = class43.indexScripts.method4375(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = class156.method3073(var5);
               if(var2 != null) {
                  Script.field1445.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-757449478"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(ZLgi;I)V",
      garbageValue = "261765350"
   )
   static final void method599(boolean var0, PacketBuffer var1) {
      Client.field972 = 0;
      Client.pendingNpcFlagsCount = 0;
      PendingSpawn.method1611();

      int var2;
      NPC var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      while(var1.bitsAvail(Client.field952.packetLength) >= 27) {
         var2 = var1.getBits(15);
         if(var2 == 32767) {
            break;
         }

         boolean var3 = false;
         if(Client.cachedNPCs[var2] == null) {
            Client.cachedNPCs[var2] = new NPC();
            var3 = true;
         }

         var4 = Client.cachedNPCs[var2];
         Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
         var4.field1192 = Client.gameCycle;
         var5 = Client.field977[var1.getBits(3)];
         if(var3) {
            var4.orientation = var4.angle = var5;
         }

         var6 = var1.getBits(1);
         if(var6 == 1) {
            Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
         }

         if(var0) {
            var7 = var1.getBits(8);
            if(var7 > 127) {
               var7 -= 256;
            }
         } else {
            var7 = var1.getBits(5);
            if(var7 > 15) {
               var7 -= 32;
            }
         }

         var4.composition = class94.getNpcDefinition(var1.getBits(14));
         if(var0) {
            var8 = var1.getBits(8);
            if(var8 > 127) {
               var8 -= 256;
            }
         } else {
            var8 = var1.getBits(5);
            if(var8 > 15) {
               var8 -= 32;
            }
         }

         var9 = var1.getBits(1);
         var4.field1201 = var4.composition.field3625;
         var4.field1196 = var4.composition.field3632;
         if(var4.field1196 == 0) {
            var4.angle = 0;
         }

         var4.field1151 = var4.composition.field3607;
         var4.field1152 = var4.composition.field3616;
         var4.field1153 = var4.composition.field3617;
         var4.field1154 = var4.composition.field3608;
         var4.idlePoseAnimation = var4.composition.field3612;
         var4.field1149 = var4.composition.field3635;
         var4.field1150 = var4.composition.field3603;
         var4.method1774(class48.localPlayer.pathX[0] + var7, class48.localPlayer.pathY[0] + var8, var9 == 1);
      }

      var1.byteAccess();

      int var14;
      for(var2 = 0; var2 < Client.pendingNpcFlagsCount; ++var2) {
         var14 = Client.pendingNpcFlagsIndices[var2];
         var4 = Client.cachedNPCs[var14];
         var5 = var1.readUnsignedByte();
         if((var5 & 8) != 0) {
            var4.overhead = var1.readString();
            var4.field1148 = 100;
         }

         if((var5 & 2) != 0) {
            var4.graphic = var1.method3324();
            var6 = var1.method3292();
            var4.field1184 = var6 >> 16;
            var4.graphicsDelay = (var6 & 65535) + Client.gameCycle;
            var4.field1181 = 0;
            var4.field1182 = 0;
            if(var4.graphicsDelay > Client.gameCycle) {
               var4.field1181 = -1;
            }

            if(var4.graphic == 65535) {
               var4.graphic = -1;
            }
         }

         if((var5 & 4) != 0) {
            var6 = var1.method3313();
            int var10;
            int var11;
            int var12;
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var9 = -1;
                  var10 = -1;
                  var11 = -1;
                  var8 = var1.getUSmart();
                  if(var8 == 32767) {
                     var8 = var1.getUSmart();
                     var10 = var1.getUSmart();
                     var9 = var1.getUSmart();
                     var11 = var1.getUSmart();
                  } else if(var8 != 32766) {
                     var10 = var1.getUSmart();
                  } else {
                     var8 = -1;
                  }

                  var12 = var1.getUSmart();
                  var4.method1617(var8, var10, var9, var11, Client.gameCycle, var12);
               }
            }

            var7 = var1.method3407();
            if(var7 > 0) {
               for(var8 = 0; var8 < var7; ++var8) {
                  var9 = var1.getUSmart();
                  var10 = var1.getUSmart();
                  if(var10 != 32767) {
                     var11 = var1.getUSmart();
                     var12 = var1.method3314();
                     int var13 = var10 > 0?var1.method3314():var12;
                     var4.method1618(var9, Client.gameCycle, var10, var11, var12, var13);
                  } else {
                     var4.method1619(var9);
                  }
               }
            }
         }

         if((var5 & 16) != 0) {
            var6 = var1.readUnsignedShortOb1();
            if(var6 == 65535) {
               var6 = -1;
            }

            var7 = var1.method3314();
            if(var6 == var4.animation && var6 != -1) {
               var8 = ItemLayer.getAnimation(var6).replyMode;
               if(var8 == 1) {
                  var4.actionFrame = 0;
                  var4.field1179 = 0;
                  var4.actionAnimationDisable = var7;
                  var4.field1163 = 0;
               }

               if(var8 == 2) {
                  var4.field1163 = 0;
               }
            } else if(var6 == -1 || var4.animation == -1 || ItemLayer.getAnimation(var6).forcedPriority >= ItemLayer.getAnimation(var4.animation).forcedPriority) {
               var4.animation = var6;
               var4.actionFrame = 0;
               var4.field1179 = 0;
               var4.actionAnimationDisable = var7;
               var4.field1163 = 0;
               var4.field1186 = var4.queueSize;
            }
         }

         if((var5 & 64) != 0) {
            var6 = var1.readUnsignedShort();
            var7 = var1.readUnsignedShortOb1();
            var8 = var4.x - (var6 - ItemLayer.baseX - ItemLayer.baseX) * 64;
            var9 = var4.y - (var7 - ItemLayer.baseY - ItemLayer.baseY) * 64;
            if(var8 != 0 || var9 != 0) {
               var4.field1202 = (int)(Math.atan2((double)var8, (double)var9) * 325.949D) & 2047;
            }
         }

         if((var5 & 1) != 0) {
            var4.composition = class94.getNpcDefinition(var1.method3324());
            var4.field1201 = var4.composition.field3625;
            var4.field1196 = var4.composition.field3632;
            var4.field1151 = var4.composition.field3607;
            var4.field1152 = var4.composition.field3616;
            var4.field1153 = var4.composition.field3617;
            var4.field1154 = var4.composition.field3608;
            var4.idlePoseAnimation = var4.composition.field3612;
            var4.field1149 = var4.composition.field3635;
            var4.field1150 = var4.composition.field3603;
         }

         if((var5 & 32) != 0) {
            var4.interacting = var1.readUnsignedShort();
            if(var4.interacting == 65535) {
               var4.interacting = -1;
            }
         }
      }

      for(var2 = 0; var2 < Client.field972; ++var2) {
         var14 = Client.field973[var2];
         if(Client.cachedNPCs[var14].field1192 != Client.gameCycle) {
            Client.cachedNPCs[var14].composition = null;
            Client.cachedNPCs[var14] = null;
         }
      }

      if(var1.offset != Client.field952.packetLength) {
         throw new RuntimeException(var1.offset + "," + Client.field952.packetLength);
      } else {
         for(var2 = 0; var2 < Client.npcIndexesCount; ++var2) {
            if(Client.cachedNPCs[Client.npcIndices[var2]] == null) {
               throw new RuntimeException(var2 + "," + Client.npcIndexesCount);
            }
         }

      }
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(Ljc;IIII)V",
      garbageValue = "-1614266671"
   )
   static final void method641(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3614) {
               if(!var0.field3638 || Client.field878 == var1) {
                  String var4 = var0.name;
                  int var7;
                  int var8;
                  if(var0.combatLevel != 0) {
                     var7 = var0.combatLevel;
                     var8 = class48.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = WallObject.getColTags(16711680);
                     } else if(var9 < -6) {
                        var6 = WallObject.getColTags(16723968);
                     } else if(var9 < -3) {
                        var6 = WallObject.getColTags(16740352);
                     } else if(var9 < 0) {
                        var6 = WallObject.getColTags(16756736);
                     } else if(var9 > 9) {
                        var6 = WallObject.getColTags(65280);
                     } else if(var9 > 6) {
                        var6 = WallObject.getColTags(4259584);
                     } else if(var9 > 3) {
                        var6 = WallObject.getColTags(8453888);
                     } else if(var9 > 0) {
                        var6 = WallObject.getColTags(12648192);
                     } else {
                        var6 = WallObject.getColTags(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3638 && Client.field996) {
                     class60.addMenuEntry("Examine", WallObject.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     class60.addMenuEntry("Use", Client.field1118 + " " + "->" + " " + WallObject.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((class228.field2902 & 2) == 2) {
                        class60.addMenuEntry(Client.field1007, Client.field1008 + " " + "->" + " " + WallObject.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var10 = var0.field3638 && Client.field996?2000:0;
                     String[] var11 = var0.actions;
                     if(Client.field869) {
                        var11 = Friend.method1149(var11);
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && !var11[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var10 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var10 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = var10 + 11;
                              }

                              if(var7 == 3) {
                                 var8 = var10 + 12;
                              }

                              if(var7 == 4) {
                                 var8 = var10 + 13;
                              }

                              class60.addMenuEntry(var11[var7], WallObject.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && var11[var7].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(Client.field941 != class90.field1327) {
                                 if(Client.field941 == class90.field1325 || class90.field1328 == Client.field941 && var0.combatLevel > class48.localPlayer.combatLevel) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var12 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = var12 + 10;
                                 }

                                 if(var7 == 2) {
                                    var8 = var12 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = var12 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = var12 + 13;
                                 }

                                 class60.addMenuEntry(var11[var7], WallObject.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3638 || !Client.field996) {
                        class60.addMenuEntry("Examine", WallObject.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "([Lhk;IIIIIIIII)V",
      garbageValue = "-1336988484"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.method2707();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field1022)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field980] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field980] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field980] = var10.width;
               Client.widgetBoundsHeight[Client.field980] = var10.height;
               var11 = ++Client.field980 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.loopCycle = Client.gameCycle;
            if(!var10.hasScript || !class258.method4629(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field1123 == -1) {
                        Client.field1123 = var10.spriteId;
                        Client.field1124 = var10.field2860;
                     }

                     if(Client.field1122.isFemale) {
                        var10.spriteId = Client.field1123;
                     } else {
                        var10.spriteId = Client.field1124;
                     }
                  } else if(var12 == 325) {
                     if(Client.field1123 == -1) {
                        Client.field1123 = var10.spriteId;
                        Client.field1124 = var10.field2860;
                     }

                     if(Client.field1122.isFemale) {
                        var10.spriteId = Client.field1124;
                     } else {
                        var10.spriteId = Client.field1123;
                     }
                  } else if(var12 == 327) {
                     var10.rotationX = 150;
                     var10.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
                     var10.modelType = 5;
                     var10.modelId = 0;
                  } else if(var12 == 328) {
                     var10.rotationX = 150;
                     var10.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
                     var10.modelType = 5;
                     var10.modelId = 1;
                  }
               }

               var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field1022) {
                  if(var1 != -1412584499 && !var10.field2804) {
                     RSCanvas.field630 = var0;
                     class70.field809 = var6;
                     ItemLayer.field1706 = var7;
                     continue;
                  }

                  if(Client.field1063 && Client.field1027) {
                     var15 = MouseInput.field704;
                     var16 = MouseInput.field708;
                     var15 -= Client.field1024;
                     var16 -= Client.field1087;
                     if(var15 < Client.field1028) {
                        var15 = Client.field1028;
                     }

                     if(var15 + var10.width > Client.field1028 + Client.field1023.width) {
                        var15 = Client.field1028 + Client.field1023.width - var10.width;
                     }

                     if(var16 < Client.field880) {
                        var16 = Client.field880;
                     }

                     if(var16 + var10.height > Client.field880 + Client.field1023.height) {
                        var16 = Client.field880 + Client.field1023.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2804) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var20;
               int var21;
               int var22;
               int var30;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var30 = var12;
                  var20 = var13;
                  var21 = var12 + var10.width;
                  var22 = var13 + var10.height;
                  if(var21 < var12) {
                     var30 = var21;
                     var21 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var21;
                  ++var22;
                  var15 = var30 > var2?var30:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var30 = var12 + var10.width;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var30 < var4?var30:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.hasScript || var15 < var17 && var16 < var18) {
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           class48.font_p12full.method4933("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var38 = Runtime.getRuntime();
                           var20 = (int)((var38.totalMemory() - var38.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > 32768 && Client.lowMemory) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           class48.font_p12full.method4933("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field998 = var12;
                        Client.field999 = var13;
                        Spotanim.method4527(var12, var13, var10.width, var10.height);
                        Client.field1055[var10.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class11.method62(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class44.method692(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        Client.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        Client.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class258.method4629(var10) && var10 != ItemContainer.field751) {
                        continue;
                     }

                     if(!var10.hasScript) {
                        if(var10.scrollY > var10.scrollHeight - var10.height) {
                           var10.scrollY = var10.scrollHeight - var10.height;
                        }

                        if(var10.scrollY < 0) {
                           var10.scrollY = 0;
                        }
                     }

                     gameDraw(var0, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     if(var10.children != null) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var19 = (WidgetNode)Client.componentTable.get((long)var10.id);
                     if(var19 != null) {
                        class13.method83(var19.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.method2707();
                  }

                  if(Client.isResized || Client.field896[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        method643(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        int var23;
                        int var24;
                        int var25;
                        int var26;
                        if(var10.type == 2) {
                           var30 = 0;

                           for(var20 = 0; var20 < var10.field2738; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var12 + var21 * (var10.paddingX + 32);
                                 var23 = var13 + var20 * (var10.paddingY + 32);
                                 if(var30 < 20) {
                                    var22 += var10.xSprites[var30];
                                    var23 += var10.field2795[var30];
                                 }

                                 if(var10.itemIds[var30] <= 0) {
                                    if(var10.field2796 != null && var30 < 20) {
                                       SpritePixels var42 = var10.method4153(var30);
                                       if(var42 != null) {
                                          var42.drawAt(var22, var23);
                                       } else if(Widget.field2724) {
                                          WorldMapData.method394(var10);
                                       }
                                    }
                                 } else {
                                    boolean var39 = false;
                                    boolean var40 = false;
                                    var26 = var10.itemIds[var30] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == ClanMember.field864 && var30 == Client.field894) {
                                       SpritePixels var27;
                                       if(Client.itemSelectionState == 1 && var30 == GameEngine.selectedItemIndex && var10.id == class5.field33) {
                                          var27 = class10.createSprite(var26, var10.itemQuantities[var30], 2, 0, 2, false);
                                       } else {
                                          var27 = class10.createSprite(var26, var10.itemQuantities[var30], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(var10 == ClanMember.field864 && var30 == Client.field894) {
                                             var24 = MouseInput.field704 - Client.field963;
                                             var25 = MouseInput.field708 - Client.field964;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field967 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var27.method5325(var24 + var22, var25 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & 65535];
                                                int var29;
                                                if(var23 + var25 < Rasterizer2D.drawingAreaTop && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field925 / 3;
                                                   if(var29 > Client.field925 * 10) {
                                                      var29 = Client.field925 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field964 += var29;
                                                   WorldMapData.method394(var28);
                                                }

                                                if(var23 + var25 + 32 > Rasterizer2D.drawingAreaRight && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (var23 + var25 + 32 - Rasterizer2D.drawingAreaRight) * Client.field925 / 3;
                                                   if(var29 > Client.field925 * 10) {
                                                      var29 = Client.field925 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field964 -= var29;
                                                   WorldMapData.method394(var28);
                                                }
                                             }
                                          } else if(var10 == class169.field2420 && var30 == Client.field961) {
                                             var27.method5325(var22, var23, 128);
                                          } else {
                                             var27.drawAt(var22, var23);
                                          }
                                       } else {
                                          WorldMapData.method394(var10);
                                       }
                                    }
                                 }

                                 ++var30;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class168.method3183(var10)) {
                              var30 = var10.field2753;
                              if(var10 == ItemContainer.field751 && var10.field2754 != 0) {
                                 var30 = var10.field2754;
                              }
                           } else {
                              var30 = var10.textColor;
                              if(var10 == ItemContainer.field751 && var10.field2809 != 0) {
                                 var30 = var10.field2809;
                              }
                           }

                           if(var10.filled) {
                              switch(var10.field2756.field3827) {
                              case 1:
                                 Rasterizer2D.method5159(var12, var13, var10.width, var10.height, var10.textColor, var10.field2753, 256 - (var10.opacity & 255), 256 - (var10.field2758 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method5152(var12, var13, var10.width, var10.height, var10.textColor, var10.field2753, 256 - (var10.opacity & 255), 256 - (var10.field2758 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method5153(var12, var13, var10.width, var10.height, var10.textColor, var10.field2753, 256 - (var10.opacity & 255), 256 - (var10.field2758 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method5154(var12, var13, var10.width, var10.height, var10.textColor, var10.field2753, 256 - (var10.opacity & 255), 256 - (var10.field2758 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method5151(var12, var13, var10.width, var10.height, var30);
                                 } else {
                                    Rasterizer2D.fillRectangle(var12, var13, var10.width, var10.height, var30, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.drawRectangle(var12, var13, var10.width, var10.height, var30);
                           } else {
                              Rasterizer2D.method5158(var12, var13, var10.width, var10.height, var30, 256 - (var14 & 255));
                           }
                        } else {
                           Font var36;
                           if(var10.type == 4) {
                              var36 = var10.method4160();
                              if(var36 == null) {
                                 if(Widget.field2724) {
                                    WorldMapData.method394(var10);
                                 }
                              } else {
                                 String var45 = var10.text;
                                 if(class168.method3183(var10)) {
                                    var20 = var10.field2753;
                                    if(var10 == ItemContainer.field751 && var10.field2754 != 0) {
                                       var20 = var10.field2754;
                                    }

                                    if(var10.field2787.length() > 0) {
                                       var45 = var10.field2787;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == ItemContainer.field751 && var10.field2809 != 0) {
                                       var20 = var10.field2809;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var46 = class250.getItemDefinition(var10.itemId);
                                    var45 = var46.name;
                                    if(var45 == null) {
                                       var45 = "null";
                                    }

                                    if((var46.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var45 = WallObject.getColTags(16748608) + var45 + "</col>" + " " + 'x' + class226.method4216(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1013) {
                                    Object var10000 = null;
                                    var45 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var45 = class111.method2189(var45, var10);
                                 }

                                 var36.method4935(var45, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2853, var10.field2752, var10.field2788);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var37;
                              if(!var10.hasScript) {
                                 var37 = var10.method4159(class168.method3183(var10));
                                 if(var37 != null) {
                                    var37.drawAt(var12, var13);
                                 } else if(Widget.field2724) {
                                    WorldMapData.method394(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var37 = class10.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2784, false);
                                 } else {
                                    var37 = var10.method4159(false);
                                 }

                                 if(var37 == null) {
                                    if(Widget.field2724) {
                                       WorldMapData.method394(var10);
                                    }
                                 } else {
                                    var20 = var37.maxWidth;
                                    var21 = var37.maxHeight;
                                    if(!var10.spriteTiling) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var37.method5291(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var37.method5358(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var37.drawAt(var12, var13);
                                       } else {
                                          var37.method5295(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var37.method5291(var20 / 2 + var12 + var24 * var20, var21 / 2 + var13 + var21 * var25, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var37.method5325(var12 + var20 * var24, var13 + var25 * var21, 256 - (var14 & 255));
                                             } else {
                                                var37.drawAt(var12 + var24 * var20, var13 + var25 * var21);
                                             }
                                          }
                                       }

                                       Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var34;
                              if(var10.type == 6) {
                                 boolean var43 = class168.method3183(var10);
                                 if(var43) {
                                    var20 = var10.field2806;
                                 } else {
                                    var20 = var10.field2773;
                                 }

                                 Model var41 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var34 = class250.getItemDefinition(var10.itemId);
                                    if(var34 != null) {
                                       var34 = var34.method4756(var10.itemQuantity);
                                       var41 = var34.getModel(1);
                                       if(var41 != null) {
                                          var41.method2616();
                                          var22 = var41.modelHeight / 2;
                                       } else {
                                          WorldMapData.method394(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var41 = Client.field1122.method4114((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var41 = class48.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var41 = var10.method4170((Sequence)null, -1, var43, class48.localPlayer.composition);
                                    if(var41 == null && Widget.field2724) {
                                       WorldMapData.method394(var10);
                                    }
                                 } else {
                                    Sequence var47 = ItemLayer.getAnimation(var20);
                                    var41 = var10.method4170(var47, var10.field2737, var43, class48.localPlayer.composition);
                                    if(var41 == null && Widget.field2724) {
                                       WorldMapData.method394(var10);
                                    }
                                 }

                                 Graphics3D.method2748(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var41 != null) {
                                    if(!var10.hasScript) {
                                       var41.method2629(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var41.method2616();
                                       if(var10.field2783) {
                                          var41.method2641(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2775, var23 + var22 + var10.field2768, var24 + var10.field2768, var10.modelZoom);
                                       } else {
                                          var41.method2629(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2775, var23 + var22 + var10.field2768, var24 + var10.field2768);
                                       }
                                    }
                                 }

                                 Graphics3D.method2706();
                              } else {
                                 if(var10.type == 7) {
                                    var36 = var10.method4160();
                                    if(var36 == null) {
                                       if(Widget.field2724) {
                                          WorldMapData.method394(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2738; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var34 = class250.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var31;
                                             if(var34.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var31 = WallObject.getColTags(16748608) + var34.name + "</col>";
                                             } else {
                                                var31 = WallObject.getColTags(16748608) + var34.name + "</col>" + " " + 'x' + class226.method4216(var10.itemQuantities[var20]);
                                             }

                                             var25 = var22 * (var10.paddingX + 115) + var12;
                                             var26 = var13 + (var10.paddingY + 12) * var21;
                                             if(var10.field2853 == 0) {
                                                var36.method4931(var31, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2853 == 1) {
                                                var36.method4934(var31, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var36.method4933(var31, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == class13.field280 && Client.field1001 == Client.field1000) {
                                    var30 = 0;
                                    var20 = 0;
                                    Font var32 = class48.font_p12full;
                                    String var33 = var10.text;

                                    String var44;
                                    for(var33 = class111.method2189(var33, var10); var33.length() > 0; var20 = var20 + var32.verticalSpace + 1) {
                                       var24 = var33.indexOf("<br>");
                                       if(var24 != -1) {
                                          var44 = var33.substring(0, var24);
                                          var33 = var33.substring(var24 + 4);
                                       } else {
                                          var44 = var33;
                                          var33 = "";
                                       }

                                       var25 = var32.method4926(var44);
                                       if(var25 > var30) {
                                          var30 = var25;
                                       }
                                    }

                                    var30 += 6;
                                    var20 += 7;
                                    var24 = var12 + var10.width - 5 - var30;
                                    var25 = var13 + var10.height + 5;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var30 + var24 > var4) {
                                       var24 = var4 - var30;
                                    }

                                    if(var25 + var20 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.method5151(var24, var25, var30, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var24, var25, var30, var20, 0);
                                    var33 = var10.text;
                                    var26 = var25 + var32.verticalSpace + 2;

                                    for(var33 = class111.method2189(var33, var10); var33.length() > 0; var26 = var26 + var32.verticalSpace + 1) {
                                       int var35 = var33.indexOf("<br>");
                                       if(var35 != -1) {
                                          var44 = var33.substring(0, var35);
                                          var33 = var33.substring(var35 + 4);
                                       } else {
                                          var44 = var33;
                                          var33 = "";
                                       }

                                       var32.method4931(var44, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2760) {
                                       var30 = var12;
                                       var20 = var13 + var10.height;
                                       var21 = var12 + var10.width;
                                       var22 = var13;
                                    } else {
                                       var30 = var12;
                                       var20 = var13;
                                       var21 = var12 + var10.width;
                                       var22 = var13 + var10.height;
                                    }

                                    if(var10.lineWidth == 1) {
                                       Rasterizer2D.drawLine(var30, var20, var21, var22, var10.textColor);
                                    } else {
                                       class20.method174(var30, var20, var21, var22, var10.textColor, var10.lineWidth);
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "-123"
   )
   static final void method643(int var0, int var1, int var2, int var3, int var4) {
      class51.field627[0].method5246(var0, var1);
      class51.field627[1].method5246(var0, var3 + var1 - 16);
      Rasterizer2D.method5151(var0, var1 + 16, 16, var3 - 32, Client.field914);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.method5151(var0, var6 + var1 + 16, 16, var5, Client.field927);
      Rasterizer2D.method5182(var0, var6 + var1 + 16, var5, Client.field929);
      Rasterizer2D.method5182(var0 + 1, var6 + var1 + 16, var5, Client.field929);
      Rasterizer2D.method5230(var0, var6 + var1 + 16, 16, Client.field929);
      Rasterizer2D.method5230(var0, var6 + var1 + 17, 16, Client.field929);
      Rasterizer2D.method5182(var0 + 15, var6 + var1 + 16, var5, Client.field928);
      Rasterizer2D.method5182(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field928);
      Rasterizer2D.method5230(var0, var5 + var6 + var1 + 15, 16, Client.field928);
      Rasterizer2D.method5230(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field928);
   }
}
