import java.awt.Container;
import java.awt.Insets;
import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public class class88 {
   @ObfuscatedName("pe")
   static class230 field1524;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)Lclass109;",
      garbageValue = "255"
   )
   static class109 method1934() {
      try {
         return new class98();
      } catch (Throwable var1) {
         return new class99();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-510119174"
   )
   public static File method1935(String var0) {
      if(!class107.field1722) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class107.field1725.get(var0);
         if(null != var1) {
            return var1;
         } else {
            File var2 = new File(class107.field1723, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class107.field1725.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(null != var3) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-63"
   )
   static final void method1936(int var0, int var1) {
      if(class159.method3142(var0)) {
         DecorativeObject.method1979(Widget.widgets[var0], var1);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1595991271"
   )
   static int method1937(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class32.field729[--class101.field1648];
         class32.field729[++class101.field1648 - 1] = Client.grandExchangeOffers[var3].method47();
         return 1;
      } else if(var0 == 3904) {
         var3 = class32.field729[--class101.field1648];
         class32.field729[++class101.field1648 - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class32.field729[--class101.field1648];
         class32.field729[++class101.field1648 - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class32.field729[--class101.field1648];
         class32.field729[++class101.field1648 - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class32.field729[--class101.field1648];
         class32.field729[++class101.field1648 - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class32.field729[--class101.field1648];
         class32.field729[++class101.field1648 - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var13;
         if(var0 == 3910) {
            var3 = class32.field729[--class101.field1648];
            var13 = Client.grandExchangeOffers[var3].method46();
            class32.field729[++class101.field1648 - 1] = var13 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class32.field729[--class101.field1648];
            var13 = Client.grandExchangeOffers[var3].method46();
            class32.field729[++class101.field1648 - 1] = var13 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class32.field729[--class101.field1648];
            var13 = Client.grandExchangeOffers[var3].method46();
            class32.field729[++class101.field1648 - 1] = var13 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class32.field729[--class101.field1648];
            var13 = Client.grandExchangeOffers[var3].method46();
            class32.field729[++class101.field1648 - 1] = var13 == 1?1:0;
            return 1;
         } else {
            boolean var12;
            if(var0 == 3914) {
               var12 = class32.field729[--class101.field1648] == 1;
               if(null != class143.field2002) {
                  class143.field2002.method18(class1.field8, var12);
               }

               return 1;
            } else if(var0 == 3915) {
               var12 = class32.field729[--class101.field1648] == 1;
               if(class143.field2002 != null) {
                  class143.field2002.method18(class1.field7, var12);
               }

               return 1;
            } else if(var0 == 3916) {
               class101.field1648 -= 2;
               var12 = class32.field729[class101.field1648] == 1;
               boolean var11 = class32.field729[class101.field1648 + 1] == 1;
               if(class143.field2002 != null) {
                  class143.field2002.method18(new class44(var11), var12);
               }

               return 1;
            } else if(var0 == 3917) {
               var12 = class32.field729[--class101.field1648] == 1;
               if(null != class143.field2002) {
                  class143.field2002.method18(class1.field6, var12);
               }

               return 1;
            } else if(var0 == 3918) {
               var12 = class32.field729[--class101.field1648] == 1;
               if(null != class143.field2002) {
                  class143.field2002.method18(class1.field14, var12);
               }

               return 1;
            } else if(var0 == 3919) {
               class32.field729[++class101.field1648 - 1] = null == class143.field2002?0:class143.field2002.field12.size();
               return 1;
            } else {
               class2 var4;
               if(var0 == 3920) {
                  var3 = class32.field729[--class101.field1648];
                  var4 = (class2)class143.field2002.field12.get(var3);
                  class32.field729[++class101.field1648 - 1] = var4.field24;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class32.field729[--class101.field1648];
                  var4 = (class2)class143.field2002.field12.get(var3);
                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = var4.method22();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class32.field729[--class101.field1648];
                  var4 = (class2)class143.field2002.field12.get(var3);
                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = var4.method29();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class32.field729[--class101.field1648];
                  var4 = (class2)class143.field2002.field12.get(var3);
                  long var5 = ChatMessages.method935() - class36.field766 - var4.field27;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(3600000 * var7)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * '\uea60')) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class32.field729[--class101.field1648];
                  var4 = (class2)class143.field2002.field12.get(var3);
                  class32.field729[++class101.field1648 - 1] = var4.field17.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class32.field729[--class101.field1648];
                  var4 = (class2)class143.field2002.field12.get(var3);
                  class32.field729[++class101.field1648 - 1] = var4.field17.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class32.field729[--class101.field1648];
                  var4 = (class2)class143.field2002.field12.get(var3);
                  class32.field729[++class101.field1648 - 1] = var4.field17.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-608823672"
   )
   static void method1938() {
      Client var0 = Client.field279;
      synchronized(Client.field279) {
         Container var1 = Client.field279.method2220();
         if(null != var1) {
            FaceNormal.field1553 = Math.max(var1.getSize().width, class177.field2666);
            class85.field1445 = Math.max(var1.getSize().height, class94.field1583);
            Insets var2;
            if(Item.field881 == var1) {
               var2 = Item.field881.getInsets();
               FaceNormal.field1553 -= var2.left + var2.right;
               class85.field1445 -= var2.bottom + var2.top;
            }

            if(FaceNormal.field1553 <= 0) {
               FaceNormal.field1553 = 1;
            }

            if(class85.field1445 <= 0) {
               class85.field1445 = 1;
            }

            if(Actor.method632() == 1) {
               class2.field21 = Client.field500;
               class20.field216 = Client.field501 * 503;
            } else {
               class2.field21 = Math.min(FaceNormal.field1553, 7680);
               class20.field216 = Math.min(class85.field1445, 2160);
            }

            GameEngine.field1761 = (FaceNormal.field1553 - class2.field21) / 2;
            GameEngine.field1780 = 0;
            class0.canvas.setSize(class2.field21, class20.field216);
            class22.bufferProvider = class22.method223(class2.field21, class20.field216, class0.canvas);
            if(var1 == Item.field881) {
               var2 = Item.field881.getInsets();
               class0.canvas.setLocation(var2.left + GameEngine.field1761, GameEngine.field1780 + var2.top);
            } else {
               class0.canvas.setLocation(GameEngine.field1761, GameEngine.field1780);
            }

            Actor.method637();
            if(Client.widgetRoot != -1) {
               class39.method814(true);
            }

            XGrandExchangeOffer.method67();
         }
      }
   }
}
