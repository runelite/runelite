import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class2 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 5454372682510458401L
   )
   public final long field15;
   @ObfuscatedName("h")
   String field17;
   @ObfuscatedName("w")
   String field18;
   @ObfuscatedName("im")
   static class38 field19;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      longValue = 1546679712991195193L
   )
   static long field21;
   @ObfuscatedName("m")
   public final XGrandExchangeOffer field23;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -844320975
   )
   public final int field24;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -122293013
   )
   public static int field25;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-37881389"
   )
   public String method24() {
      return this.field17;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-536629877"
   )
   public String method25() {
      return this.field18;
   }

   class2(Buffer var1, byte var2, int var3) {
      this.field17 = var1.method3057();
      this.field18 = var1.method3057();
      this.field24 = var1.readUnsignedShort();
      this.field15 = var1.method3118();
      int var4 = var1.method2995();
      int var5 = var1.method2995();
      this.field23 = new XGrandExchangeOffer();
      this.field23.method59(2);
      this.field23.method67(var2);
      this.field23.price = var4;
      this.field23.totalQuantity = var5;
      this.field23.quantitySold = 0;
      this.field23.spent = 0;
      this.field23.itemId = var3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1306394094"
   )
   static final int method31() {
      if(Tile.field1343.field691) {
         return class166.plane;
      } else {
         int var0 = 3;
         if(class40.cameraPitch < 310) {
            int var1 = XGrandExchangeOffer.cameraX >> 7;
            int var2 = Client.cameraY >> 7;
            int var3 = class40.localPlayer.x >> 7;
            int var4 = class40.localPlayer.y >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class166.plane;
            }

            if((class11.tileSettings[class166.plane][var1][var2] & 4) != 0) {
               var0 = class166.plane;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = 65536 * var6 / var5;
               var8 = '耀';

               while(var3 != var1) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class11.tileSettings[class166.plane][var1][var2] & 4) != 0) {
                     var0 = class166.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class11.tileSettings[class166.plane][var1][var2] & 4) != 0) {
                        var0 = class166.plane;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = '耀';

               while(var2 != var4) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class11.tileSettings[class166.plane][var1][var2] & 4) != 0) {
                     var0 = class166.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class11.tileSettings[class166.plane][var1][var2] & 4) != 0) {
                        var0 = class166.plane;
                     }
                  }
               }
            }
         }

         if(class40.localPlayer.x >= 0 && class40.localPlayer.y >= 0 && class40.localPlayer.x < 13312 && class40.localPlayer.y < 13312) {
            if((class11.tileSettings[class166.plane][class40.localPlayer.x >> 7][class40.localPlayer.y >> 7] & 4) != 0) {
               var0 = class166.plane;
            }

            return var0;
         } else {
            return class166.plane;
         }
      }
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "80"
   )
   static void method32(Widget var0) {
      Widget var1 = var0.parentId == -1?null:class5.method79(var0.parentId);
      int var2;
      int var3;
      if(var1 == null) {
         var2 = class16.field169;
         var3 = class65.field1103;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      class103.method2018(var0, var2, var3, false);
      class37.method766(var0, var2, var3);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "1418107433"
   )
   public static int method33(CharSequence var0, int var1) {
      return class178.method3312(var0, var1, true);
   }
}
