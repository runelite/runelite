import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class30 {
   @ObfuscatedName("h")
   LinkedHashMap field688 = new LinkedHashMap();
   @ObfuscatedName("i")
   boolean field689;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -70188781
   )
   static int field690 = 4;
   @ObfuscatedName("t")
   boolean field692;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 922553287
   )
   int field693 = 1;

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZB)V",
      garbageValue = "21"
   )
   static final void method683(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         class108.method2097(var2);
      }

      for(class133 var4 = (class133)Client.widgetFlags.method2423(); var4 != null; var4 = (class133)Client.widgetFlags.method2424()) {
         if((var4.hash >> 48 & 65535L) == (long)var2) {
            var4.unlink();
         }
      }

      Widget var5 = class140.method2681(var3);
      if(var5 != null) {
         Frames.method1960(var5);
      }

      Item.method871();
      if(Client.widgetRoot != -1) {
         class88.method1936(Client.widgetRoot, 1);
      }

   }

   class30(Buffer var1) {
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field690) {
            if(var1.readUnsignedByte() == 1) {
               this.field689 = true;
            }

            if(var2 > 1) {
               this.field692 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field693 = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.field688.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method684(true);
         }
      } else {
         this.method684(true);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1147275198"
   )
   void method684(boolean var1) {
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)LBuffer;",
      garbageValue = "120"
   )
   Buffer method685() {
      Buffer var1 = new Buffer(100);
      var1.method3010(field690);
      var1.method3010(this.field689?1:0);
      var1.method3010(this.field692?1:0);
      var1.method3010(this.field693);
      var1.method3010(this.field688.size());
      Iterator var2 = this.field688.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2844(((Integer)var3.getKey()).intValue());
         var1.method2844(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   class30() {
      this.method684(true);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "0"
   )
   public static void method695(boolean var0) {
      if(class185.field2741 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method3010(var0?2:3);
            var1.method2862(0);
            class185.field2741.method2114(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class185.field2741.method2109();
            } catch (Exception var3) {
               ;
            }

            ++class185.field2759;
            class185.field2741 = null;
         }

      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "28934"
   )
   static final void method696() {
      if(Client.widgetRoot != -1) {
         class180.method3343(Client.widgetRoot);
      }

      int var0;
      for(var0 = 0; var0 < Client.field544; ++var0) {
         if(Client.field490[var0]) {
            Client.field386[var0] = true;
         }

         Client.field492[var0] = Client.field490[var0];
         Client.field490[var0] = false;
      }

      Client.field489 = Client.gameCycle;
      Client.field434 = -1;
      Client.field487 = -1;
      WallObject.field1534 = null;
      if(Client.widgetRoot != -1) {
         Client.field544 = 0;
         class172.method3325(Client.widgetRoot, 0, 0, class2.field21, class20.field216, 0, 0, -1);
      }

      Rasterizer2D.method4140();
      if(!Client.isMenuOpen) {
         if(Client.field434 != -1) {
            class142.method2742(Client.field434, Client.field487);
         }
      } else {
         XGrandExchangeOffer.method66();
      }

      if(Client.field497 == 3) {
         for(var0 = 0; var0 < Client.field544; ++var0) {
            if(Client.field492[var0]) {
               Rasterizer2D.method4107(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711935, 128);
            } else if(Client.field386[var0]) {
               Rasterizer2D.method4107(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711680, 128);
            }
         }
      }

      var0 = class156.plane;
      int var1 = class9.localPlayer.x;
      int var2 = class9.localPlayer.y;
      int var3 = Client.field477;

      for(class31 var4 = (class31)class31.field700.method2472(); null != var4; var4 = (class31)class31.field700.method2479()) {
         if(var4.field703 != -1 || var4.field698 != null) {
            int var5 = 0;
            if(var1 > var4.field704) {
               var5 += var1 - var4.field704;
            } else if(var1 < var4.field710) {
               var5 += var4.field710 - var1;
            }

            if(var2 > var4.field701) {
               var5 += var2 - var4.field701;
            } else if(var2 < var4.field699) {
               var5 += var4.field699 - var2;
            }

            if(var5 - 64 <= var4.field702 && Client.field526 != 0 && var0 == var4.field697) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field702 - var5) * Client.field526 / var4.field702;
               Object var10000;
               if(var4.field696 == null) {
                  if(var4.field703 >= 0) {
                     var10000 = null;
                     class53 var11 = class53.method1046(class1.field13, var4.field703, 0);
                     if(null != var11) {
                        class55 var8 = var11.method1052().method1087(class119.field1853);
                        class66 var9 = class66.method1236(var8, 100, var6);
                        var9.method1239(-1);
                        class16.field168.method993(var9);
                        var4.field696 = var9;
                     }
                  }
               } else {
                  var4.field696.method1259(var6);
               }

               if(var4.field709 == null) {
                  if(null != var4.field698 && (var4.field708 -= var3) <= 0) {
                     int var7 = (int)(Math.random() * (double)var4.field698.length);
                     var10000 = null;
                     class53 var12 = class53.method1046(class1.field13, var4.field698[var7], 0);
                     if(null != var12) {
                        class55 var13 = var12.method1052().method1087(class119.field1853);
                        class66 var10 = class66.method1236(var13, 100, var6);
                        var10.method1239(0);
                        class16.field168.method993(var10);
                        var4.field709 = var10;
                        var4.field708 = var4.field705 + (int)(Math.random() * (double)(var4.field706 - var4.field705));
                     }
                  }
               } else {
                  var4.field709.method1259(var6);
                  if(!var4.field709.linked()) {
                     var4.field709 = null;
                  }
               }
            } else {
               if(var4.field696 != null) {
                  class16.field168.method994(var4.field696);
                  var4.field696 = null;
               }

               if(null != var4.field709) {
                  class16.field168.method994(var4.field709);
                  var4.field709 = null;
               }
            }
         }
      }

      Client.field477 = 0;
   }
}
