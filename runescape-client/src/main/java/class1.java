import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class1 {
   @ObfuscatedName("d")
   public static Comparator field4 = new class7();
   @ObfuscatedName("m")
   public static Comparator field6;
   @ObfuscatedName("w")
   public static Comparator field8;
   @ObfuscatedName("n")
   public final List field10;
   @ObfuscatedName("h")
   public static Comparator field11;
   @ObfuscatedName("r")
   public static class182 field12;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "2080219633"
   )
   public void method13(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field10, var1);
      } else {
         Collections.sort(this.field10, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass166;IB)V",
      garbageValue = "-52"
   )
   static void method14(class166 var0, int var1) {
      boolean var2 = var0.method3237(1) == 1;
      if(var2) {
         class45.field909[++class45.field908 - 1] = var1;
      }

      int var3 = var0.method3237(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field264 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class45.field905[var1] = (var4.field267 << 28) + (var4.pathX[0] + class16.baseX >> 6 << 14) + (Client.baseY + var4.pathY[0] >> 6);
            if(var4.field623 != -1) {
               class45.field906[var1] = var4.field623;
            } else {
               class45.field906[var1] = var4.field646;
            }

            class45.field896[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method3237(1) != 0) {
               Item.method824(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method3237(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field264 = true;
                  var4.field247 = var6;
                  var4.field268 = var7;
               } else {
                  var4.field264 = false;
                  var4.method233(var6, var7, class45.field901[var1]);
               }
            } else {
               var4.method234(var6, var7);
               var4.field264 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method3237(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field264 = true;
                  var4.field247 = var6;
                  var4.field268 = var7;
               } else {
                  var4.field264 = false;
                  var4.method233(var6, var7, class45.field901[var1]);
               }
            } else {
               var4.method234(var6, var7);
               var4.field264 = false;
            }

         } else {
            var5 = var0.method3237(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method3237(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var4.pathY[0] + var9;
               if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method234(var10, var11);
                  var4.field264 = false;
               } else if(var2) {
                  var4.field264 = true;
                  var4.field247 = var10;
                  var4.field268 = var11;
               } else {
                  var4.field264 = false;
                  var4.method233(var10, var11, class45.field901[var1]);
               }

               var4.field267 = (byte)(var4.field267 + var7 & 3);
               if(var1 == Client.localInteractingIndex) {
                  class166.plane = var4.field267;
               }

            } else {
               var6 = var0.method3237(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (class16.baseX + var4.pathX[0] + var8 & 16383) - class16.baseX;
               var11 = (var9 + Client.baseY + var4.pathY[0] & 16383) - Client.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field264 = true;
                     var4.field247 = var10;
                     var4.field268 = var11;
                  } else {
                     var4.field264 = false;
                     var4.method233(var10, var11, class45.field901[var1]);
                  }
               } else {
                  var4.method234(var10, var11);
                  var4.field264 = false;
               }

               var4.field267 = (byte)(var4.field267 + var7 & 3);
               if(var1 == Client.localInteractingIndex) {
                  class166.plane = var4.field267;
               }

            }
         }
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-125"
   )
   static final void method15(boolean var0) {
      for(int var1 = 0; var1 < Client.field326; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field559[var1]];
         int var3 = (Client.field559[var1] << 14) + 536870912;
         if(null != var2 && var2.vmethod746() && var2.composition.isVisible == var0 && var2.composition.method3750()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field599 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field391[var4][var5] == Client.field548) {
                     continue;
                  }

                  Client.field391[var4][var5] = Client.field548;
               }

               if(!var2.composition.field3024) {
                  var3 -= Integer.MIN_VALUE;
               }

               class157.region.method1751(class166.plane, var2.x, var2.y, class11.method161(var2.field599 * 64 - 64 + var2.x, var2.y + (var2.field599 * 64 - 64), class166.plane), 60 + (var2.field599 * 64 - 64), var2, var2.angle, var3, var2.field598);
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-124"
   )
   static void method19(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method2405((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method2406(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   static {
      new class0();
      field6 = new class5();
      field11 = new class6();
      field8 = new class3();
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "-106"
   )
   static final void method20(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class60.method1127(var0)) {
         ChatLineBuffer.field963 = null;
         class179.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(null != ChatLineBuffer.field963) {
            class179.gameDraw(ChatLineBuffer.field963, -1412584499, var1, var2, var3, var4, class178.field2685, class25.field576, var7);
            ChatLineBuffer.field963 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field490[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field490[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(Lclass25;I)V",
      garbageValue = "407581736"
   )
   static final void method21(class25 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field577 == 0) {
         var1 = class157.region.method1766(var0.field573, var0.field578, var0.field574);
      }

      if(var0.field577 == 1) {
         var1 = class157.region.method1767(var0.field573, var0.field578, var0.field574);
      }

      if(var0.field577 == 2) {
         var1 = class157.region.method1768(var0.field573, var0.field578, var0.field574);
      }

      if(var0.field577 == 3) {
         var1 = class157.region.method1744(var0.field573, var0.field578, var0.field574);
      }

      if(var1 != 0) {
         int var5 = class157.region.method1881(var0.field573, var0.field578, var0.field574, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field575 = var2;
      var0.field584 = var3;
      var0.field572 = var4;
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class1(Buffer var1, boolean var2) {
      int var3 = var1.method3097();
      boolean var4 = var1.method3033() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method3097();
      this.field10 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field10.add(new class2(var1, var5, var3));
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
      garbageValue = "-195026207"
   )
   public static String method22(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var3 = var0[var1];
         return var3 == null?"null":var3.toString();
      } else {
         int var8 = var2 + var1;
         int var4 = 0;

         for(int var9 = var1; var9 < var8; ++var9) {
            CharSequence var6 = var0[var9];
            if(var6 == null) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var5 = new StringBuilder(var4);

         for(int var10 = var1; var10 < var8; ++var10) {
            CharSequence var7 = var0[var10];
            if(var7 == null) {
               var5.append("null");
            } else {
               var5.append(var7);
            }
         }

         return var5.toString();
      }
   }
}
