import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class2 {
   @ObfuscatedName("k")
   String field15;
   @ObfuscatedName("i")
   public final XGrandExchangeOffer field17;
   @ObfuscatedName("t")
   String field18;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = 976701097
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = -622851951
   )
   public static int field21;
   @ObfuscatedName("ez")
   static ModIcon[] field22;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 973792813
   )
   public final int field24;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -6068981753588461519L
   )
   public final long field27;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "517323884"
   )
   public String method22() {
      return this.field18;
   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIIIII)V",
      garbageValue = "-1117528402"
   )
   static final void method23(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field429) {
         Client.field367 = 32;
      } else {
         Client.field367 = 0;
      }

      Client.field429 = false;
      int var7;
      if(class115.field1809 == 1 || !class36.field769 && class115.field1809 == 4) {
         if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 && var6 < 16 + var2) {
            var0.scrollY -= 4;
            Frames.method1960(var0);
         } else if(var5 >= var1 && var5 < 16 + var1 && var6 >= var3 + var2 - 16 && var6 < var2 + var3) {
            var0.scrollY += 4;
            Frames.method1960(var0);
         } else if(var5 >= var1 - Client.field367 && var5 < Client.field367 + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = var8 * (var4 - var3) / var9;
            Frames.method1960(var0);
            Client.field429 = true;
         }
      }

      if(Client.field483 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var2 + var3) {
            var0.scrollY += Client.field483 * 45;
            Frames.method1960(var0);
         }
      }

   }

   class2(Buffer var1, byte var2, int var3) {
      this.field18 = var1.readString();
      this.field15 = var1.readString();
      this.field24 = var1.readUnsignedShort();
      this.field27 = var1.method2947();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field17 = new XGrandExchangeOffer();
      this.field17.method48(2);
      this.field17.method69(var2);
      this.field17.price = var4;
      this.field17.totalQuantity = var5;
      this.field17.quantitySold = 0;
      this.field17.spent = 0;
      this.field17.itemId = var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1327142379"
   )
   static void method26() {
      class45.field907 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class45.field899[var0] = null;
         class45.field897[var0] = 1;
      }

   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "338921476"
   )
   static final void method28(int var0) {
      int[] var1 = class148.field2025.image;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = 24628 + 2048 * (103 - var3);

         for(var5 = 1; var5 < 103; ++var5) {
            if((class10.tileSettings[var0][var5][var3] & 24) == 0) {
               Varbit.region.method1789(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class10.tileSettings[1 + var0][var5][var3] & 8) != 0) {
               Varbit.region.method1789(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class148.field2025.method4291();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class10.tileSettings[var0][var6][var5] & 24) == 0) {
               ChatMessages.method936(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class10.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               ChatMessages.method936(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field515 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = Varbit.region.method1785(class156.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class196.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var13 = Client.collisionMaps[class156.plane].flags;

                     for(int var14 = 0; var14 < 10; ++var14) {
                        int var15 = (int)(Math.random() * 4.0D);
                        if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var15 == 1 && var9 < 103 && var9 < var5 + 3 && (var13[var9 + 1][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(var15 == 3 && var10 < 103 && var10 < var6 + 3 && (var13[var9][var10 + 1] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  Client.field518[Client.field515] = class16.field177[var8];
                  Client.field516[Client.field515] = var9;
                  Client.field517[Client.field515] = var10;
                  ++Client.field515;
               }
            }
         }
      }

      class22.bufferProvider.method4171();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1433705217"
   )
   public String method29() {
      return this.field15;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-54"
   )
   static int method31(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2428((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }
}
