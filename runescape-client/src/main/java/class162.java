import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class162 implements class115 {
   @ObfuscatedName("g")
   public static final class162 field2644 = new class162(1, 3);
   @ObfuscatedName("h")
   public static final class162 field2645 = new class162(2, 1);
   @ObfuscatedName("e")
   public static final class162 field2646 = new class162(0, 2);
   @ObfuscatedName("i")
   public static final class162 field2648 = new class162(3, 0);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2037038305
   )
   final int field2649;
   @ObfuscatedName("pt")
   static class163 field2650;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1124388549
   )
   public final int field2651;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class162(int var1, int var2) {
      this.field2651 = var1;
      this.field2649 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-970198235"
   )
   public int vmethod3197() {
      return this.field2649;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1721201702"
   )
   static final void method3198() {
      if(Client.widgetRoot != -1) {
         Player.method35(Client.widgetRoot);
      }

      int var0;
      for(var0 = 0; var0 < Client.field425; ++var0) {
         if(Client.field494[var0]) {
            Client.field506[var0] = true;
         }

         Client.field507[var0] = Client.field494[var0];
         Client.field494[var0] = false;
      }

      Client.field451 = Client.gameCycle;
      Client.field449 = -1;
      Client.field495 = -1;
      WidgetNode.field69 = null;
      if(Client.widgetRoot != -1) {
         Client.field425 = 0;
         class225.method4056(Client.widgetRoot, 0, 0, class62.field1267, class77.field1428, 0, 0, -1);
      }

      class82.method1830();
      if(!Client.isMenuOpen) {
         if(Client.field449 != -1) {
            Sequence.method932(Client.field449, Client.field495);
         }
      } else {
         class141.method2973();
      }

      if(Client.field402 == 3) {
         for(var0 = 0; var0 < Client.field425; ++var0) {
            if(Client.field507[var0]) {
               class82.method1836(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711935, 128);
            } else if(Client.field506[var0]) {
               class82.method1836(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711680, 128);
            }
         }
      }

      var0 = class173.plane;
      int var1 = class138.localPlayer.x;
      int var2 = class138.localPlayer.y;
      int var3 = Client.field420;

      for(class24 var4 = (class24)class24.field634.method3845(); null != var4; var4 = (class24)class24.field634.method3847()) {
         if(var4.field637 != -1 || null != var4.field624) {
            int var5 = 0;
            if(var1 > var4.field628) {
               var5 += var1 - var4.field628;
            } else if(var1 < var4.field626) {
               var5 += var4.field626 - var1;
            }

            if(var2 > var4.field636) {
               var5 += var2 - var4.field636;
            } else if(var2 < var4.field627) {
               var5 += var4.field627 - var2;
            }

            if(var5 - 64 <= var4.field629 && Client.field408 != 0 && var0 == var4.field625) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = Client.field408 * (var4.field629 - var5) / var4.field629;
               Object var10000;
               if(var4.field632 == null) {
                  if(var4.field637 >= 0) {
                     var10000 = null;
                     class61 var7 = class61.method1293(class109.field1929, var4.field637, 0);
                     if(null != var7) {
                        class65 var8 = var7.method1284().method1325(class127.field2079);
                        class67 var9 = class67.method1347(var8, 100, var6);
                        var9.method1376(-1);
                        class0.field11.method1177(var9);
                        var4.field632 = var9;
                     }
                  }
               } else {
                  var4.field632.method1351(var6);
               }

               if(null == var4.field635) {
                  if(null != var4.field624 && (var4.field631 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field624.length);
                     var10000 = null;
                     class61 var12 = class61.method1293(class109.field1929, var4.field624[var11], 0);
                     if(null != var12) {
                        class65 var13 = var12.method1284().method1325(class127.field2079);
                        class67 var10 = class67.method1347(var13, 100, var6);
                        var10.method1376(0);
                        class0.field11.method1177(var10);
                        var4.field635 = var10;
                        var4.field631 = var4.field633 + (int)(Math.random() * (double)(var4.field630 - var4.field633));
                     }
                  }
               } else {
                  var4.field635.method1351(var6);
                  if(!var4.field635.linked()) {
                     var4.field635 = null;
                  }
               }
            } else {
               if(var4.field632 != null) {
                  class0.field11.method1178(var4.field632);
                  var4.field632 = null;
               }

               if(null != var4.field635) {
                  class0.field11.method1178(var4.field635);
                  var4.field635 = null;
               }
            }
         }
      }

      Client.field420 = 0;
   }
}
