import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("j")
   boolean[] field268;
   @ObfuscatedName("ah")
   static int[] field270;
   @ObfuscatedName("l")
   boolean field271 = false;
   @ObfuscatedName("i")
   int[] field272;
   @ObfuscatedName("z")
   boolean[] field273;
   @ObfuscatedName("b")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 100352209919768469L
   )
   long field275;
   @ObfuscatedName("p")
   static ModIcon[] field276;
   @ObfuscatedName("bh")
   static ModIcon field277;
   @ObfuscatedName("t")
   static String field278;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "60"
   )
   void method202(int var1, int var2) {
      this.field272[var1] = var2;
      if(this.field268[var1]) {
         this.field271 = true;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1728147622"
   )
   int method203(int var1) {
      return this.field272[var1];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "194146389"
   )
   void method204(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field273[var1]) {
         this.field271 = true;
      }

   }

   ChatMessages() {
      this.field272 = new int[World.field644.method3299(19)];
      this.messages = new String[World.field644.method3299(15)];
      this.field268 = new boolean[this.field272.length];

      int var1;
      for(var1 = 0; var1 < this.field272.length; ++var1) {
         class47 var2 = CollisionData.method2475(var1);
         this.field268[var1] = var2.field1047;
      }

      this.field273 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class53 var3 = (class53)class53.field1134.get((long)var1);
         class53 var5;
         if(var3 != null) {
            var5 = var3;
         } else {
            byte[] var4 = class53.field1133.method3290(15, var1);
            var3 = new class53();
            if(var4 != null) {
               var3.method1072(new Buffer(var4));
            }

            class53.field1134.put(var3, (long)var1);
            var5 = var3;
         }

         this.field273[var1] = var5.field1135;
      }

      for(var1 = 0; var1 < this.field272.length; ++var1) {
         this.field272[var1] = -1;
      }

      this.method216();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-25"
   )
   void method205() {
      int var1;
      for(var1 = 0; var1 < this.field272.length; ++var1) {
         if(!this.field268[var1]) {
            this.field272[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field273[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "1464762643"
   )
   FileOnDisk method206(boolean var1) {
      return DecorativeObject.method2222("2", class35.field775.field2339, var1);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1282202207"
   )
   void method207() {
      FileOnDisk var1 = this.method206(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field272.length; ++var4) {
            if(this.field268[var4] && this.field272[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field273[var5] && this.messages[var5] != null) {
               var2 += 2 + class43.method857(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.method2715(1);
         var9.method2542(var3);

         int var6;
         for(var6 = 0; var6 < this.field272.length; ++var6) {
            if(this.field268[var6] && this.field272[var6] != -1) {
               var9.method2542(var6);
               var9.method2544(this.field272[var6]);
            }
         }

         var9.method2542(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field273[var6] && null != this.messages[var6]) {
               var9.method2542(var6);
               var9.method2616(this.messages[var6]);
            }
         }

         var1.method4135(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method4136();
         } catch (Exception var16) {
            ;
         }

      }

      this.field271 = false;
      this.field275 = class34.method713();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-324519767"
   )
   String method208(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "468518770"
   )
   void method209() {
      if(this.field271 && this.field275 < class34.method713() - 60000L) {
         this.method207();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1896202099"
   )
   boolean method210() {
      return this.field271;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2113190040"
   )
   void method216() {
      FileOnDisk var1 = this.method206(false);

      label201: {
         try {
            byte[] var2 = new byte[(int)var1.method4137()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method4154(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var13 = new Buffer(var2);
            if(var13.payload.length - var13.offset < 1) {
               return;
            }

            int var14 = var13.method2556();
            if(var14 >= 0 && var14 <= 1) {
               int var15 = var13.method2551();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var15; ++var7) {
                  var8 = var13.method2551();
                  var9 = var13.method2561();
                  if(this.field268[var8]) {
                     this.field272[var8] = var9;
                  }
               }

               var7 = var13.method2551();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label201;
                  }

                  var9 = var13.method2551();
                  String var10 = var13.method2774();
                  if(this.field273[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label201;
         } finally {
            try {
               var1.method4136();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field271 = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1094754827"
   )
   static final int method217(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & '\uff00') * var3 + (var1 & '\uff00') * var2 & 16711680) + (var3 * (var0 & 16711935) + var2 * (var1 & 16711935) & -16711936) >> 8;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method228() {
      class48.field1053.reset();
      class43.field978.reset();
      KitDefinition.field1035.reset();
      class21.method553();
      NPCComposition.field886.reset();
      NPCComposition.npcModelCache.reset();
      class119.method2507();
      CollisionData.method2457();
      class45.field1015.reset();
      class45.field1029.reset();
      class50.field1089.reset();
      KitDefinition.method948();
      class51.field1097.reset();
      class51.spriteCache.reset();
      class51.field1100.reset();
      class56.method1164();
      class140.method2969();
      World.method629();
      ((TextureProvider)class94.field1636).method2229();
      class23.field592.reset();
      class153.field2300.method3302();
      WallObject.field1585.method3302();
      class35.field779.method3302();
      class51.field1111.method3302();
      class140.field2165.method3302();
      class192.field3108.method3302();
      class114.field2017.method3302();
      class109.field1922.method3302();
      class54.field1145.method3302();
      class33.field753.method3302();
      class129.field2094.method3302();
      class188.field3049.method3302();
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZB)V",
      garbageValue = "-1"
   )
   static void method240(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2810 == 0) {
         var0.width = var0.field2884;
      } else if(var0.field2810 == 1) {
         var0.width = var1 - var0.field2884;
      } else if(var0.field2810 == 2) {
         var0.width = var1 * var0.field2884 >> 14;
      }

      if(var0.field2818 == 0) {
         var0.height = var0.field2822;
      } else if(var0.field2818 == 1) {
         var0.height = var2 - var0.field2822;
      } else if(var0.field2818 == 2) {
         var0.height = var0.field2822 * var2 >> 14;
      }

      if(var0.field2810 == 4) {
         var0.width = var0.field2925 * var0.height / var0.field2828;
      }

      if(var0.field2818 == 4) {
         var0.height = var0.width * var0.field2828 / var0.field2925;
      }

      if(Client.field449 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field463 = var0;
      }

      if(var3 && var0.field2827 != null && (var4 != var0.width || var5 != var0.height)) {
         class0 var6 = new class0();
         var6.field7 = var0;
         var6.field8 = var0.field2827;
         Client.field478.method3844(var6);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIILclass110;LCollisionData;Z[I[IB)I",
      garbageValue = "83"
   )
   public static int method243(int var0, int var1, int var2, class110 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class109.field1923[var8][var9] = 0;
            class109.field1924[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var12;
      byte var13;
      int var14;
      int var15;
      byte var16;
      int var17;
      int[][] var18;
      int var19;
      int var20;
      int var21;
      boolean var28;
      boolean var29;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class109.field1923[var12][var13] = 99;
         class109.field1924[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class109.field1925[var16] = var0;
         var33 = var16 + 1;
         class109.field1926[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var17 == var33) {
               FileOnDisk.field3259 = var10;
               class167.field2722 = var11;
               var29 = false;
               break;
            }

            var10 = class109.field1925[var17];
            var11 = class109.field1926[var17];
            var17 = 1 + var17 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod2439(1, var10, var11, var4)) {
               FileOnDisk.field3259 = var10;
               class167.field2722 = var11;
               var29 = true;
               break;
            }

            var21 = 1 + class109.field1924[var30][var31];
            if(var30 > 0 && class109.field1923[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class109.field1925[var33] = var10 - 1;
               class109.field1926[var33] = var11;
               var33 = var33 + 1 & 4095;
               class109.field1923[var30 - 1][var31] = 2;
               class109.field1924[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class109.field1923[var30 + 1][var31] == 0 && (var18[var19 + 1][var20] & 19136896) == 0) {
               class109.field1925[var33] = 1 + var10;
               class109.field1926[var33] = var11;
               var33 = 1 + var33 & 4095;
               class109.field1923[1 + var30][var31] = 8;
               class109.field1924[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class109.field1923[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class109.field1925[var33] = var10;
               class109.field1926[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class109.field1923[var30][var31 - 1] = 1;
               class109.field1924[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class109.field1923[var30][var31 + 1] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class109.field1925[var33] = var10;
               class109.field1926[var33] = 1 + var11;
               var33 = var33 + 1 & 4095;
               class109.field1923[var30][var31 + 1] = 4;
               class109.field1924[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class109.field1923[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class109.field1925[var33] = var10 - 1;
               class109.field1926[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class109.field1923[var30 - 1][var31 - 1] = 3;
               class109.field1924[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && class109.field1923[1 + var30][var31 - 1] == 0 && (var18[1 + var19][var20 - 1] & 19136899) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class109.field1925[var33] = 1 + var10;
               class109.field1926[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class109.field1923[1 + var30][var31 - 1] = 9;
               class109.field1924[1 + var30][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class109.field1923[var30 - 1][1 + var31] == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][1 + var20] & 19136800) == 0) {
               class109.field1925[var33] = var10 - 1;
               class109.field1926[var33] = var11 + 1;
               var33 = 1 + var33 & 4095;
               class109.field1923[var30 - 1][var31 + 1] = 6;
               class109.field1924[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 127 && var31 < 127 && class109.field1923[1 + var30][1 + var31] == 0 && (var18[1 + var19][var20 + 1] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class109.field1925[var33] = 1 + var10;
               class109.field1926[var33] = 1 + var11;
               var33 = 1 + var33 & 4095;
               class109.field1923[1 + var30][var31 + 1] = 12;
               class109.field1924[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else if(var2 == 2) {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class109.field1923[var12][var13] = 99;
         class109.field1924[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class109.field1925[var16] = var0;
         var33 = var16 + 1;
         class109.field1926[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var33 == var17) {
               FileOnDisk.field3259 = var10;
               class167.field2722 = var11;
               var29 = false;
               break;
            }

            var10 = class109.field1925[var17];
            var11 = class109.field1926[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod2439(2, var10, var11, var4)) {
               FileOnDisk.field3259 = var10;
               class167.field2722 = var11;
               var29 = true;
               break;
            }

            var21 = 1 + class109.field1924[var30][var31];
            if(var30 > 0 && class109.field1923[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][1 + var20] & 19136824) == 0) {
               class109.field1925[var33] = var10 - 1;
               class109.field1926[var33] = var11;
               var33 = var33 + 1 & 4095;
               class109.field1923[var30 - 1][var31] = 2;
               class109.field1924[var30 - 1][var31] = var21;
            }

            if(var30 < 126 && class109.field1923[var30 + 1][var31] == 0 && (var18[2 + var19][var20] & 19136899) == 0 && (var18[var19 + 2][var20 + 1] & 19136992) == 0) {
               class109.field1925[var33] = var10 + 1;
               class109.field1926[var33] = var11;
               var33 = var33 + 1 & 4095;
               class109.field1923[1 + var30][var31] = 8;
               class109.field1924[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class109.field1923[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0) {
               class109.field1925[var33] = var10;
               class109.field1926[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class109.field1923[var30][var31 - 1] = 1;
               class109.field1924[var30][var31 - 1] = var21;
            }

            if(var31 < 126 && class109.field1923[var30][var31 + 1] == 0 && (var18[var19][2 + var20] & 19136824) == 0 && (var18[1 + var19][2 + var20] & 19136992) == 0) {
               class109.field1925[var33] = var10;
               class109.field1926[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class109.field1923[var30][1 + var31] = 4;
               class109.field1924[var30][1 + var31] = var21;
            }

            if(var30 > 0 && var31 > 0 && class109.field1923[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20] & 19136830) == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19][var20 - 1] & 19136911) == 0) {
               class109.field1925[var33] = var10 - 1;
               class109.field1926[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class109.field1923[var30 - 1][var31 - 1] = 3;
               class109.field1924[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 126 && var31 > 0 && class109.field1923[1 + var30][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136911) == 0 && (var18[var19 + 2][var20 - 1] & 19136899) == 0 && (var18[2 + var19][var20] & 19136995) == 0) {
               class109.field1925[var33] = var10 + 1;
               class109.field1926[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class109.field1923[var30 + 1][var31 - 1] = 9;
               class109.field1924[1 + var30][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 126 && class109.field1923[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136830) == 0 && (var18[var19 - 1][2 + var20] & 19136824) == 0 && (var18[var19][var20 + 2] & 19137016) == 0) {
               class109.field1925[var33] = var10 - 1;
               class109.field1926[var33] = 1 + var11;
               var33 = 1 + var33 & 4095;
               class109.field1923[var30 - 1][1 + var31] = 6;
               class109.field1924[var30 - 1][1 + var31] = var21;
            }

            if(var30 < 126 && var31 < 126 && class109.field1923[var30 + 1][1 + var31] == 0 && (var18[var19 + 1][2 + var20] & 19137016) == 0 && (var18[var19 + 2][2 + var20] & 19136992) == 0 && (var18[2 + var19][1 + var20] & 19136995) == 0) {
               class109.field1925[var33] = 1 + var10;
               class109.field1926[var33] = var11 + 1;
               var33 = 1 + var33 & 4095;
               class109.field1923[1 + var30][var31 + 1] = 12;
               class109.field1924[1 + var30][1 + var31] = var21;
            }
         }

         var28 = var29;
      } else {
         var28 = class5.method99(var0, var1, var2, var3, var4);
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = FileOnDisk.field3259;
      var30 = class167.field2722;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field1943;
         var17 = var3.field1940;
         int var27 = var3.field1939;
         var19 = var3.field1945;

         for(var20 = var33 - var32; var20 <= var32 + var33; ++var20) {
            for(var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
               int var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class109.field1924[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var27 + var33 - 1) {
                     var24 = var20 - (var33 + var27 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var19 + var17 - 1) {
                     var25 = var21 - (var19 + var17 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var31 == var26 && class109.field1924[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class109.field1924[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if(var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var30 == var1) {
         return 0;
      } else {
         var13 = 0;
         class109.field1925[var13] = var11;
         var31 = var13 + 1;
         class109.field1926[var13] = var30;

         for(var14 = var15 = class109.field1923[var11 - var9][var30 - var10]; var11 != var0 || var1 != var30; var14 = class109.field1923[var11 - var9][var30 - var10]) {
            if(var15 != var14) {
               var15 = var14;
               class109.field1925[var31] = var11;
               class109.field1926[var31++] = var30;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var30;
            } else if((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class109.field1925[var31];
            var7[var33++] = class109.field1926[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }
}
