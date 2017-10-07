import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;
import net.runelite.rs.Reflection;

@ObfuscatedName("aj")
public final class class41 {
   @ObfuscatedName("z")
   static int[] field577;
   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("k")
   boolean field571;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   SpritePixels field581;
   @ObfuscatedName("d")
   boolean field588;
   @ObfuscatedName("q")
   HashMap field574;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[[Laq;"
   )
   class34[][] field575;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 83715241
   )
   int field579;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 834799041
   )
   int field580;
   @ObfuscatedName("r")
   HashMap field573;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Ljz;"
   )
   IndexedSprite[] field587;
   @ObfuscatedName("v")
   final HashMap field578;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   class44 field572;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 439154181
   )
   int field586;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 674539093
   )
   int field582;

   @ObfuscatedSignature(
      signature = "([Ljz;Ljava/util/HashMap;)V"
   )
   public class41(IndexedSprite[] var1, HashMap var2) {
      this.field588 = false;
      this.field571 = false;
      this.field573 = new HashMap();
      this.field587 = var1;
      this.field578 = var2;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-111"
   )
   void method550() {
      if(this.field574 == null) {
         this.field574 = new HashMap();
      }

      this.field574.clear();

      for(int var1 = 0; var1 < this.field575.length; ++var1) {
         for(int var2 = 0; var2 < this.field575[var1].length; ++var2) {
            List var3 = this.field575[var1][var2].method377();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field574.containsKey(Integer.valueOf(var5.field552))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field574.put(Integer.valueOf(var5.field552), var6);
               } else {
                  List var7 = (List)this.field574.get(Integer.valueOf(var5.field552));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIII)Lab;",
      garbageValue = "-1687714659"
   )
   class29 method542(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field579 + var1;
      int var7 = var2 + this.field580;
      int var8 = var3 + this.field579;
      int var9 = var4 + this.field580;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field434 = var12 - var10 + 1;
      var5.field430 = var13 - var11 + 1;
      var5.field436 = var10 - this.field572.method316();
      var5.field429 = var11 - this.field572.method333();
      if(var5.field436 < 0) {
         var5.field434 += var5.field436;
         var5.field436 = 0;
      }

      if(var5.field436 > this.field575.length - var5.field434) {
         var5.field434 = this.field575.length - var5.field436;
      }

      if(var5.field429 < 0) {
         var5.field430 += var5.field429;
         var5.field429 = 0;
      }

      if(var5.field429 > this.field575[0].length - var5.field430) {
         var5.field430 = this.field575[0].length - var5.field429;
      }

      var5.field434 = Math.min(var5.field434, this.field575.length);
      var5.field430 = Math.min(var5.field430, this.field575[0].length);
      return var5;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)F",
      garbageValue = "-2"
   )
   float method567(int var1, int var2) {
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "962530939"
   )
   public boolean method585() {
      return this.field588;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "-7918538"
   )
   public HashMap method549() {
      this.method550();
      return this.field574;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "1176210552"
   )
   public void method580(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field581 != null) {
         this.field581.method5194(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field574 == null) {
               this.method550();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field574.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field547.worldX - this.field579) / this.field586;
                  int var14 = var4 - (var12.field547.worldY - this.field580) * var4 / this.field582;
                  Rasterizer2D.method5054(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lit;Ljava/lang/String;ZI)V",
      garbageValue = "-50904554"
   )
   public void method541(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field571) {
         this.field588 = false;
         this.field571 = true;
         System.nanoTime();
         int var4 = var1.getFile(class40.field561.field559);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.method4305(class40.field561.field559, var2));
         Buffer var7 = new Buffer(var1.method4305(class40.field560.field559, var2));
         Buffer var8 = new Buffer(var1.method4305(var2, class40.field562.field559));
         System.nanoTime();
         System.nanoTime();
         this.field572 = new class44();

         try {
            this.field572.method636(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var20) {
            return;
         }

         this.field572.method287();
         this.field572.method288();
         this.field572.method289();
         this.field579 = this.field572.method316() * 64;
         this.field580 = this.field572.method333() * 64;
         this.field586 = (this.field572.method290() - this.field572.method316() + 1) * 64;
         this.field582 = (this.field572.method323() - this.field572.method333() + 1) * 64;
         int var9 = this.field572.method290() - this.field572.method316() + 1;
         int var10 = this.field572.method323() - this.field572.method333() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field575 = new class34[var9][var10];
         Iterator var11 = this.field572.field601.iterator();

         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field418;
            int var14 = var12.field426;
            int var15 = var13 - this.field572.method316();
            int var16 = var14 - this.field572.method333();
            this.field575[var15][var16] = new class34(var13, var14, this.field572.method274(), this.field578);
            this.field575[var15][var16].method341(var12, this.field572.field602);
         }

         for(int var17 = 0; var17 < var9; ++var17) {
            for(int var18 = 0; var18 < var10; ++var18) {
               if(this.field575[var17][var18] == null) {
                  this.field575[var17][var18] = new class34(this.field572.method316() + var17, this.field572.method333() + var18, this.field572.method274(), this.field578);
                  this.field575[var17][var18].method342(this.field572.field600, this.field572.field602);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4276(class40.field568.field559, var2)) {
            byte[] var21 = var1.method4305(class40.field568.field559, var2);
            this.field581 = Widget.method4157(var21);
         }

         System.nanoTime();
         this.field588 = true;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "-1121536175"
   )
   public List method546(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field588) {
         return var11;
      } else {
         class29 var12 = this.method542(var1, var2, var3, var4);
         float var13 = this.method567(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.field579 + var1;
         int var16 = var2 + this.field580;

         for(int var17 = var12.field436; var17 < var12.field434 + var12.field436; ++var17) {
            for(int var18 = var12.field429; var18 < var12.field429 + var12.field430; ++var18) {
               List var19 = this.field575[var17][var18].method376(var5 + var14 * (this.field575[var17][var18].field497 * 64 - var15) / 64, var8 + var6 - var14 * (this.field575[var17][var18].field498 * 64 - var16 + 64) / 64, var14, var9, var10);
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
      signature = "(II[Laq;I)V",
      garbageValue = "672949803"
   )
   void method545(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field575.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field575[0].length - 1;
      if(var7) {
         var3[class228.field3160.rsOrdinal()] = null;
      } else {
         var3[class228.field3160.rsOrdinal()] = this.field575[var1][var2 + 1];
      }

      var3[class228.field3154.rsOrdinal()] = !var7 && !var5?this.field575[var1 + 1][var2 + 1]:null;
      var3[class228.field3158.rsOrdinal()] = !var7 && !var4?this.field575[var1 - 1][var2 + 1]:null;
      var3[class228.field3155.rsOrdinal()] = var5?null:this.field575[var1 + 1][var2];
      var3[class228.field3159.rsOrdinal()] = var4?null:this.field575[var1 - 1][var2];
      var3[class228.field3162.rsOrdinal()] = var6?null:this.field575[var1][var2 - 1];
      var3[class228.field3156.rsOrdinal()] = !var6 && !var5?this.field575[var1 + 1][var2 - 1]:null;
      var3[class228.field3157.rsOrdinal()] = !var6 && !var4?this.field575[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1214647298"
   )
   public final void method547() {
      this.field574 = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIS)V",
      garbageValue = "153"
   )
   public final void method543(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method542(var1, var2, var3, var4);
      float var14 = this.method567(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field573.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method706();
         this.field573.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field436; var17 < var13.field434 + var13.field436; ++var17) {
         for(var18 = var13.field429; var18 < var13.field430 + var13.field429; ++var18) {
            this.method545(var17, var18, var22);
            this.field575[var17][var18].method345(var15, (class46)this.field573.get(Integer.valueOf(var15)), var22, this.field587);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(64.0F * var14);
      var18 = this.field579 + var1;
      int var19 = var2 + this.field580;

      for(int var20 = var13.field436; var20 < var13.field434 + var13.field436; ++var20) {
         for(int var21 = var13.field429; var21 < var13.field430 + var13.field429; ++var21) {
            this.field575[var20][var21].method340(var5 + (this.field575[var20][var21].field497 * 64 - var18) * var17 / 64, var8 - var17 * (this.field575[var20][var21].field498 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "391319404"
   )
   public final void method540(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method542(var1, var2, var3, var4);
      float var15 = this.method567(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.field579 + var1;
      int var18 = var2 + this.field580;

      int var19;
      int var20;
      for(var19 = var14.field436; var19 < var14.field434 + var14.field436; ++var19) {
         for(var20 = var14.field429; var20 < var14.field429 + var14.field430; ++var20) {
            if(var13) {
               this.field575[var19][var20].method366();
            }

            this.field575[var19][var20].method346((this.field575[var19][var20].field497 * 64 - var17) * var16 / 64 + var5, var8 - (this.field575[var19][var20].field498 * 64 - var18 + 64) * var16 / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field436; var19 < var14.field436 + var14.field434; ++var19) {
            for(var20 = var14.field429; var20 < var14.field429 + var14.field430; ++var20) {
               this.field575[var19][var20].method410(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfg;Lgc;I)Lgc;",
      garbageValue = "1109114144"
   )
   static final IterableHashTable method590(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class88.method1780(var2);
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "-1816694384"
   )
   @Export("parseInt")
   public static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "57"
   )
   static final void method587(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field1167 - Client.field1166) * var5 / 100 + Client.field1166;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1172) {
         var15 = Client.field1172;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1059) {
            var6 = Client.field1059;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method5129(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method5129(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1062) {
         var15 = Client.field1062;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1001) {
            var6 = Client.field1001;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method5129(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method5129(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = Client.field1168 + (Client.field1169 - Client.field1168) * var5 / 100;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(var2 != Client.viewportHeight || var3 != Client.viewportWidth) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 15 + var10 * 32 + 128;
            int var12 = 600 + var11 * 3;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var12 * var13 >> 16;
         }

         Region.method2792(var14, 500, 800, var2, var3);
      }

      Client.field931 = var0;
      Client.field956 = var1;
      Client.viewportHeight = var2;
      Client.viewportWidth = var3;
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1108994780"
   )
   static final void method592() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var29;
      int var30;
      int var31;
      if(Client.packetType == Opcodes.PACKET_SERVER_19) {
         if(Client.RUNELITE_PACKET) {
            var0 = Client.secretPacketBuffer2.runeliteReadInt();
            var29 = Client.secretPacketBuffer2.runeliteReadInt();
            var1 = var0 >> 2;
            var2 = var0 & 3;
            var3 = Client.field987[var1];
         } else {
            var0 = Client.secretPacketBuffer2.readUnsignedShortOb1();
            var1 = var0 >> 2;
            var2 = var0 & 3;
            var3 = Client.field987[var1];
            var29 = Client.secretPacketBuffer2.method3418();
         }

         var30 = (var29 >> 4 & 7) + class31.field453;
         var31 = (var29 & 7) + Actor.field1270;
         if(var30 >= 0 && var31 >= 0 && var30 < 104 && var31 < 104) {
            class205.method3930(class5.plane, var30, var31, var3, -1, var1, var2, 0, -1);
         }

      } else {
         Item var5;
         if(Client.packetType == Opcodes.PACKET_SERVER_195) {
            if(Client.RUNELITE_PACKET) {
               var0 = Client.secretPacketBuffer2.runeliteReadInt();
               var3 = Client.secretPacketBuffer2.runeliteReadInt();
               var1 = (var0 >> 4 & 7) + class31.field453;
               var2 = (var0 & 7) + Actor.field1270;
            } else {
               var0 = Client.secretPacketBuffer2.readUnsignedShortOb1();
               var1 = (var0 >> 4 & 7) + class31.field453;
               var2 = (var0 & 7) + Actor.field1270;
               var3 = Client.secretPacketBuffer2.readUnsignedShort();
            }

            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               Deque var4 = Client.groundItemDeque[class5.plane][var1][var2];
               if(var4 != null) {
                  for(var5 = (Item)var4.getFront(); var5 != null; var5 = (Item)var4.getNext()) {
                     if((var3 & 32767) == var5.id) {
                        var5.unlink();
                        break;
                     }
                  }

                  if(var4.getFront() == null) {
                     Client.groundItemDeque[class5.plane][var1][var2] = null;
                  }

                  class47.groundItemSpawned(var1, var2);
               }
            }

         } else {
            int var9;
            int var32;
            if(Client.packetType == Opcodes.PACKET_SERVER_23) {
               if(Client.RUNELITE_PACKET) {
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var29 = Client.secretPacketBuffer2.runeliteReadInt();
                  var3 = Client.secretPacketBuffer2.runeliteReadInt();
                  var1 = (var0 >> 4 & 7) + class31.field453;
                  var2 = (var0 & 7) + Actor.field1270;
               } else {
                  var0 = Client.secretPacketBuffer2.readUnsignedShortOb1();
                  var1 = (var0 >> 4 & 7) + class31.field453;
                  var2 = (var0 & 7) + Actor.field1270;
                  var3 = Client.secretPacketBuffer2.method3272();
                  var29 = Client.secretPacketBuffer2.method3265();
               }

               var30 = var29 >> 2;
               var31 = var29 & 3;
               var32 = Client.field987[var30];
               if(var1 >= 0 && var2 >= 0 && var1 < 103 && var2 < 103) {
                  if(var32 == 0) {
                     WallObject var34 = class8.region.method2865(class5.plane, var1, var2);
                     if(var34 != null) {
                        var9 = var34.hash >> 14 & 32767;
                        if(var30 == 2) {
                           var34.renderable1 = new DynamicObject(var9, 2, var31 + 4, class5.plane, var1, var2, var3, false, var34.renderable1);
                           var34.renderable2 = new DynamicObject(var9, 2, var31 + 1 & 3, class5.plane, var1, var2, var3, false, var34.renderable2);
                        } else {
                           var34.renderable1 = new DynamicObject(var9, var30, var31, class5.plane, var1, var2, var3, false, var34.renderable1);
                        }
                     }
                  }

                  if(var32 == 1) {
                     DecorativeObject var40 = class8.region.method2780(class5.plane, var1, var2);
                     if(var40 != null) {
                        var9 = var40.hash >> 14 & 32767;
                        if(var30 != 4 && var30 != 5) {
                           if(var30 == 6) {
                              var40.renderable1 = new DynamicObject(var9, 4, var31 + 4, class5.plane, var1, var2, var3, false, var40.renderable1);
                           } else if(var30 == 7) {
                              var40.renderable1 = new DynamicObject(var9, 4, (var31 + 2 & 3) + 4, class5.plane, var1, var2, var3, false, var40.renderable1);
                           } else if(var30 == 8) {
                              var40.renderable1 = new DynamicObject(var9, 4, var31 + 4, class5.plane, var1, var2, var3, false, var40.renderable1);
                              var40.renderable2 = new DynamicObject(var9, 4, (var31 + 2 & 3) + 4, class5.plane, var1, var2, var3, false, var40.renderable2);
                           }
                        } else {
                           var40.renderable1 = new DynamicObject(var9, 4, var31, class5.plane, var1, var2, var3, false, var40.renderable1);
                        }
                     }
                  }

                  if(var32 == 2) {
                     GameObject var41 = class8.region.method2781(class5.plane, var1, var2);
                     if(var30 == 11) {
                        var30 = 10;
                     }

                     if(var41 != null) {
                        var41.renderable = new DynamicObject(var41.hash >> 14 & 32767, var30, var31, class5.plane, var1, var2, var3, false, var41.renderable);
                     }
                  }

                  if(var32 == 3) {
                     GroundObject var42 = class8.region.method2782(class5.plane, var1, var2);
                     if(var42 != null) {
                        var42.renderable = new DynamicObject(var42.hash >> 14 & 32767, 22, var31, class5.plane, var1, var2, var3, false, var42.renderable);
                     }
                  }
               }

            } else if(Client.packetType == Opcodes.PACKET_SERVER_178) {
               if(Client.RUNELITE_PACKET) {
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var29 = Client.secretPacketBuffer2.runeliteReadInt();
                  var3 = Client.secretPacketBuffer2.runeliteReadInt();
                  var1 = (var0 >> 4 & 7) + class31.field453;
                  var2 = (var0 & 7) + Actor.field1270;
               } else {
                  var0 = Client.secretPacketBuffer2.method3265();
                  var1 = (var0 >> 4 & 7) + class31.field453;
                  var2 = (var0 & 7) + Actor.field1270;
                  var3 = Client.secretPacketBuffer2.method3274();
                  var29 = Client.secretPacketBuffer2.method3418();
               }

               var30 = var29 >> 2;
               var31 = var29 & 3;
               var32 = Client.field987[var30];
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  class205.method3930(class5.plane, var1, var2, var32, var3, var30, var31, 0, -1);
               }

            } else if(Client.packetType == Opcodes.PACKET_SERVER_187) {
               if(Client.RUNELITE_PACKET) {
                  var2 = Client.secretPacketBuffer2.runeliteReadInt();
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var1 = Client.secretPacketBuffer2.runeliteReadInt();
               } else {
                  var0 = Client.secretPacketBuffer2.method3299();
                  var1 = Client.secretPacketBuffer2.readUnsignedShort();
                  var2 = Client.secretPacketBuffer2.readUnsignedShortOb1();
               }

               var3 = (var2 >> 4 & 7) + class31.field453;
               var29 = (var2 & 7) + Actor.field1270;
               if(var3 >= 0 && var29 >= 0 && var3 < 104 && var29 < 104) {
                  var5 = new Item();
                  var5.id = var0;
                  var5.quantity = var1;
                  if(Client.groundItemDeque[class5.plane][var3][var29] == null) {
                     Client.groundItemDeque[class5.plane][var3][var29] = new Deque();
                  }

                  Client.groundItemDeque[class5.plane][var3][var29].addFront(var5);
                  class47.groundItemSpawned(var3, var29);
               }

            } else {
               int var8;
               if(Client.packetType == Opcodes.PACKET_SERVER_57) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var29 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var32 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + class31.field453;
                     var2 = (var0 & 7) + Actor.field1270;
                     var30 = var29 >> 4 & 15;
                     var31 = var29 & 7;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + class31.field453;
                     var2 = (var0 & 7) + Actor.field1270;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var29 = Client.secretPacketBuffer2.readUnsignedByte();
                     var30 = var29 >> 4 & 15;
                     var31 = var29 & 7;
                     var32 = Client.secretPacketBuffer2.readUnsignedByte();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var8 = var30 + 1;
                     if(AbstractByteBuffer.localPlayer.pathX[0] >= var1 - var8 && AbstractByteBuffer.localPlayer.pathX[0] <= var1 + var8 && AbstractByteBuffer.localPlayer.pathY[0] >= var2 - var8 && AbstractByteBuffer.localPlayer.pathY[0] <= var8 + var2 && Client.field1114 != 0 && var31 > 0 && Client.field1154 < 50) {
                        Client.field1155[Client.field1154] = var3;
                        Client.field1156[Client.field1154] = var31;
                        Client.field1157[Client.field1154] = var32;
                        Client.audioEffects[Client.field1154] = null;
                        Client.field1158[Client.field1154] = var30 + (var2 << 8) + (var1 << 16);
                        ++Client.field1154;
                     }
                  }

               } else if(Client.packetType == Opcodes.PACKET_SERVER_143) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var29 = Client.secretPacketBuffer2.runeliteReadInt();
                     var30 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + class31.field453;
                     var2 = (var0 & 7) + Actor.field1270;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + class31.field453;
                     var2 = (var0 & 7) + Actor.field1270;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var29 = Client.secretPacketBuffer2.readUnsignedByte();
                     var30 = Client.secretPacketBuffer2.readUnsignedShort();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = var1 * 128 + 64;
                     var2 = var2 * 128 + 64;
                     GraphicsObject var38 = new GraphicsObject(var3, class5.plane, var1, var2, CacheFile.getTileHeight(var1, var2, class5.plane) - var29, var30, Client.gameCycle);
                     Client.graphicsObjectDeque.addFront(var38);
                  }

               } else if(Client.packetType == Opcodes.PACKET_SERVER_40) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var29 = Client.secretPacketBuffer2.runeliteReadInt();
                     var30 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + class31.field453;
                     var2 = (var0 & 7) + Actor.field1270;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + class31.field453;
                     var2 = (var0 & 7) + Actor.field1270;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var29 = Client.secretPacketBuffer2.readUnsignedShort();
                     var30 = Client.secretPacketBuffer2.readUnsignedShort();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     Deque var6 = Client.groundItemDeque[class5.plane][var1][var2];
                     if(var6 != null) {
                        for(Item var7 = (Item)var6.getFront(); var7 != null; var7 = (Item)var6.getNext()) {
                           if((var3 & 32767) == var7.id && var29 == var7.quantity) {
                              var7.quantity = var30;
                              break;
                           }
                        }

                        class47.groundItemSpawned(var1, var2);
                     }
                  }

               } else {
                  int var10;
                  int var11;
                  int var12;
                  if(Client.packetType == Opcodes.PACKET_SERVER_163) {
                     byte var35;
                     byte var36;
                     byte var37;
                     byte var39;
                     if(Client.RUNELITE_PACKET) {
                        var31 = Client.secretPacketBuffer2.runeliteReadInt();
                        var11 = Client.secretPacketBuffer2.runeliteReadInt();
                        var9 = Client.secretPacketBuffer2.runeliteReadInt();
                        var1 = Client.secretPacketBuffer2.runeliteReadInt();
                        var35 = Client.secretPacketBuffer2.runeliteReadByte();
                        var36 = Client.secretPacketBuffer2.runeliteReadByte();
                        var29 = Client.secretPacketBuffer2.runeliteReadInt();
                        var10 = Client.secretPacketBuffer2.runeliteReadInt();
                        var37 = Client.secretPacketBuffer2.runeliteReadByte();
                        var39 = Client.secretPacketBuffer2.runeliteReadByte();
                        var32 = (var31 >> 4 & 7) + class31.field453;
                        var8 = (var31 & 7) + Actor.field1270;
                     } else {
                        var35 = Client.secretPacketBuffer2.method3267();
                        var1 = Client.secretPacketBuffer2.method3274();
                        var36 = Client.secretPacketBuffer2.method3267();
                        var37 = Client.secretPacketBuffer2.method3267();
                        var29 = Client.secretPacketBuffer2.method3299();
                        var39 = Client.secretPacketBuffer2.readByte();
                        var31 = Client.secretPacketBuffer2.method3265();
                        var32 = (var31 >> 4 & 7) + class31.field453;
                        var8 = (var31 & 7) + Actor.field1270;
                        var9 = Client.secretPacketBuffer2.method3299();
                        var10 = Client.secretPacketBuffer2.method3299();
                        var11 = Client.secretPacketBuffer2.method3418();
                     }

                     var12 = var11 >> 2;
                     int var33 = var11 & 3;
                     int var14 = Client.field987[var12];
                     Player var15;
                     if(var9 == Client.localInteractingIndex) {
                        var15 = AbstractByteBuffer.localPlayer;
                     } else {
                        var15 = Client.cachedPlayers[var9];
                     }

                     if(var15 != null) {
                        ObjectComposition var16 = Occluder.getObjectDefinition(var1);
                        int var17;
                        int var18;
                        if(var33 != 1 && var33 != 3) {
                           var17 = var16.sizeX;
                           var18 = var16.sizeY;
                        } else {
                           var17 = var16.sizeY;
                           var18 = var16.sizeX;
                        }

                        int var19 = var32 + (var17 >> 1);
                        int var20 = var32 + (var17 + 1 >> 1);
                        int var21 = var8 + (var18 >> 1);
                        int var22 = var8 + (var18 + 1 >> 1);
                        int[][] var23 = class61.tileHeights[class5.plane];
                        int var24 = var23[var20][var21] + var23[var19][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
                        int var25 = (var32 << 7) + (var17 << 6);
                        int var26 = (var8 << 7) + (var18 << 6);
                        Model var27 = var16.method4614(var12, var33, var23, var25, var24, var26);
                        if(var27 != null) {
                           class205.method3930(class5.plane, var32, var8, var14, -1, 0, 0, var29 + 1, var10 + 1);
                           var15.field891 = var29 + Client.gameCycle;
                           var15.field892 = var10 + Client.gameCycle;
                           var15.model = var27;
                           var15.field906 = var32 * 128 + var17 * 64;
                           var15.field884 = var8 * 128 + var18 * 64;
                           var15.field897 = var24;
                           byte var28;
                           if(var35 > var37) {
                              var28 = var35;
                              var35 = var37;
                              var37 = var28;
                           }

                           if(var36 > var39) {
                              var28 = var36;
                              var36 = var39;
                              var39 = var28;
                           }

                           var15.field904 = var32 + var35;
                           var15.field883 = var32 + var37;
                           var15.field898 = var36 + var8;
                           var15.field900 = var8 + var39;
                        }
                     }

                  } else if(Client.packetType == Opcodes.PACKET_SERVER_44) {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + class31.field453;
                     var2 = (var0 & 7) + Actor.field1270;
                     var3 = var1 + Client.secretPacketBuffer2.readByte();
                     var29 = var2 + Client.secretPacketBuffer2.readByte();
                     var30 = Client.secretPacketBuffer2.readShort();
                     var31 = Client.secretPacketBuffer2.readUnsignedShort();
                     var32 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var8 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var9 = Client.secretPacketBuffer2.readUnsignedShort();
                     var10 = Client.secretPacketBuffer2.readUnsignedShort();
                     var11 = Client.secretPacketBuffer2.readUnsignedByte();
                     var12 = Client.secretPacketBuffer2.readUnsignedByte();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var29 >= 0 && var3 < 104 && var29 < 104 && var31 != '\uffff') {
                        var1 = var1 * 128 + 64;
                        var2 = 64 + var2 * 128;
                        var3 = 64 + var3 * 128;
                        var29 = var29 * 128 + 64;
                        Projectile var13 = new Projectile(var31, class5.plane, var1, var2, CacheFile.getTileHeight(var1, var2, class5.plane) - var32, var9 + Client.gameCycle, var10 + Client.gameCycle, var11, var12, var30, var8);
                        var13.method1817(var3, var29, CacheFile.getTileHeight(var3, var29, class5.plane) - var8, var9 + Client.gameCycle);
                        Client.projectiles.addFront(var13);
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "1445521572"
   )
   public static Class method594(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "1755043102"
   )
   static int method588(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 3400) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         Enum var6 = (Enum)Enum.field3400.get((long)var3);
         Enum var5;
         if(var6 != null) {
            var5 = var6;
         } else {
            byte[] var14 = Enum.field3405.getConfigData(8, var3);
            var6 = new Enum();
            if(var14 != null) {
               var6.decode(new Buffer(var14));
            }

            Enum.field3400.put(var6, (long)var3);
            var5 = var6;
         }

         var6 = var5;
         if(var5.valType != 115) {
            ;
         }

         for(int var7 = 0; var7 < var6.size; ++var7) {
            if(var4 == var6.keys[var7]) {
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var6.stringVals[var7];
               var6 = null;
               break;
            }
         }

         if(var6 != null) {
            class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var6.defaultString;
         }

         return 1;
      } else if(var0 == 3408) {
         class81.intStackSize -= 4;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         int var11 = class81.intStack[class81.intStackSize + 2];
         int var12 = class81.intStack[class81.intStackSize + 3];
         Enum var8 = (Enum)Enum.field3400.get((long)var11);
         Enum var10;
         if(var8 != null) {
            var10 = var8;
         } else {
            byte[] var13 = Enum.field3405.getConfigData(8, var11);
            var8 = new Enum();
            if(var13 != null) {
               var8.decode(new Buffer(var13));
            }

            Enum.field3400.put(var8, (long)var11);
            var10 = var8;
         }

         var8 = var10;
         if(var3 == var10.keyType && var4 == var10.valType) {
            for(int var9 = 0; var9 < var8.size; ++var9) {
               if(var12 == var8.keys[var9]) {
                  if(var4 == 115) {
                     class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var8.stringVals[var9];
                  } else {
                     class81.intStack[++class81.intStackSize - 1] = var8.intVals[var9];
                  }

                  var8 = null;
                  break;
               }
            }

            if(var8 != null) {
               if(var4 == 115) {
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var8.defaultString;
               } else {
                  class81.intStack[++class81.intStackSize - 1] = var8.defaultInt;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "null";
            } else {
               class81.intStack[++class81.intStackSize - 1] = 0;
            }

            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1650474107"
   )
   static int method589(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-825336646"
   )
   static final void method593() {
      Client.field1175 = 0;
      int var0 = (AbstractByteBuffer.localPlayer.x >> 7) + WallObject.baseX;
      int var1 = (AbstractByteBuffer.localPlayer.y >> 7) + Varcs.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field1175 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field1175 = 1;
      }

      if(Client.field1175 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field1175 = 0;
      }

   }
}
