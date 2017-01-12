import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
public final class class94 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1681736807
   )
   int field1563;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 856068657
   )
   int field1564;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2086549277
   )
   int field1565;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 720963715
   )
   int field1566;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -280248943
   )
   int field1567;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1069920129
   )
   int field1568;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1988125335
   )
   int field1569;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1798695785
   )
   int field1570;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -464720619
   )
   int field1571;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -912427229
   )
   int field1572;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -958765635
   )
   int field1574;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -863350461
   )
   int field1575;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1826469597
   )
   int field1576;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1284861243
   )
   int field1577;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -822378987
   )
   int field1578;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1081214025
   )
   int field1579;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -146346737
   )
   int field1580;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = -272505085
   )
   static int field1581;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 926020657
   )
   int field1582;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = 1804733095
   )
   @Export("menuHeight")
   static int menuHeight;

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2070304425"
   )
   static void method1867(int var0, int var1) {
      if(Client.field517 != 0 && var0 != -1) {
         class107.method2001(class162.field2136, var0, 0, Client.field517, false);
         Client.field519 = true;
      }

   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "4"
   )
   static final boolean method1868(Widget var0) {
      if(null == var0.field2298) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2298.length; ++var1) {
            int var2 = class22.method210(var0, var1);
            int var3 = var0.field2207[var1];
            if(var0.field2298[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2298[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2298[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-13"
   )
   static final void method1869() {
      class5.method76();
      if(null == class31.field715) {
         if(Client.field453 == null) {
            int var0 = class115.field1794;
            int var1;
            int var2;
            int var3;
            int var6;
            int var8;
            if(Client.isMenuOpen) {
               if(var0 != 1 && (GroundObject.field1297 || var0 != 4)) {
                  var1 = class115.field1788;
                  var2 = class115.field1789;
                  if(var1 < class118.menuX - 10 || var1 > 10 + class118.menuX + class20.menuWidth || var2 < Buffer.menuY - 10 || var2 > 10 + menuHeight + Buffer.menuY) {
                     Client.isMenuOpen = false;
                     Client.method312(class118.menuX, Buffer.menuY, class20.menuWidth, menuHeight);
                  }
               }

               if(var0 == 1 || !GroundObject.field1297 && var0 == 4) {
                  var1 = class118.menuX;
                  var2 = Buffer.menuY;
                  var3 = class20.menuWidth;
                  int var9 = class115.field1791;
                  int var10 = class115.field1796;
                  var6 = -1;

                  for(int var11 = 0; var11 < Client.menuOptionCount; ++var11) {
                     var8 = (Client.menuOptionCount - 1 - var11) * 15 + 31 + var2;
                     if(var9 > var1 && var9 < var1 + var3 && var10 > var8 - 13 && var10 < var8 + 3) {
                        var6 = var11;
                     }
                  }

                  if(var6 != -1) {
                     MessageNode.method198(var6);
                  }

                  Client.isMenuOpen = false;
                  Client.method312(class118.menuX, Buffer.menuY, class20.menuWidth, menuHeight);
               }
            } else {
               if((var0 == 1 || !GroundObject.field1297 && var0 == 4) && Client.menuOptionCount > 0) {
                  var1 = Client.menuTypes[Client.menuOptionCount - 1];
                  if(var1 == 39 || var1 == 40 || var1 == 41 || var1 == 42 || var1 == 43 || var1 == 33 || var1 == 34 || var1 == 35 || var1 == 36 || var1 == 37 || var1 == 38 || var1 == 1005) {
                     label272: {
                        var2 = Client.menuActionParams0[Client.menuOptionCount - 1];
                        var3 = Client.menuActionParams1[Client.menuOptionCount - 1];
                        Widget var4 = class44.method799(var3);
                        var6 = GameObject.method1872(var4);
                        boolean var5 = (var6 >> 28 & 1) != 0;
                        if(!var5) {
                           var8 = GameObject.method1872(var4);
                           boolean var7 = (var8 >> 29 & 1) != 0;
                           if(!var7) {
                              break label272;
                           }
                        }

                        if(null != class31.field715 && !Client.field400 && Client.field303 != 1 && !class5.method78(Client.menuOptionCount - 1) && Client.menuOptionCount > 0) {
                           class114.method2162(Client.field397, Client.field398);
                        }

                        Client.field400 = false;
                        Client.field401 = 0;
                        if(null != class31.field715) {
                           class6.method87(class31.field715);
                        }

                        class31.field715 = class44.method799(var3);
                        Client.field396 = var2;
                        Client.field397 = class115.field1791;
                        Client.field398 = class115.field1796;
                        if(Client.menuOptionCount > 0) {
                           class72.method1363(Client.menuOptionCount - 1);
                        }

                        class6.method87(class31.field715);
                        return;
                     }
                  }
               }

               if((var0 == 1 || !GroundObject.field1297 && var0 == 4) && (Client.field303 == 1 && Client.menuOptionCount > 2 || class5.method78(Client.menuOptionCount - 1))) {
                  var0 = 2;
               }

               if((var0 == 1 || !GroundObject.field1297 && var0 == 4) && Client.menuOptionCount > 0) {
                  MessageNode.method198(Client.menuOptionCount - 1);
               }

               if(var0 == 2 && Client.menuOptionCount > 0) {
                  ChatLineBuffer.method874(class115.field1791, class115.field1796);
               }
            }

         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-522337335"
   )
   public static boolean method1870(int var0) {
      if(class6.validInterfaces[var0]) {
         return true;
      } else if(!Widget.field2245.method3290(var0)) {
         return false;
      } else {
         int var1 = Widget.field2245.method3323(var0);
         if(var1 == 0) {
            class6.validInterfaces[var0] = true;
            return true;
         } else {
            if(null == Widget.widgets[var0]) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = Widget.field2245.method3272(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = (var0 << 16) + var2;
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method3210(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method3164(new Buffer(var3));
                     }
                  }
               }
            }

            class6.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "793300381"
   )
   public static void method1871() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         ++class105.keyboardIdleTicks;
         class105.field1709 = class105.field1683;
         class105.field1710 = 0;
         int var1;
         if(class105.field1703 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class105.field1700[var1] = false;
            }

            class105.field1703 = class105.field1702;
         } else {
            while(class105.field1702 != class105.field1703) {
               var1 = class105.field1701[class105.field1702];
               class105.field1702 = 1 + class105.field1702 & 127;
               if(var1 < 0) {
                  class105.field1700[~var1] = false;
               } else {
                  if(!class105.field1700[var1] && class105.field1710 < class105.field1706.length - 1) {
                     class105.field1706[++class105.field1710 - 1] = var1;
                  }

                  class105.field1700[var1] = true;
               }
            }
         }

         class105.field1683 = class105.field1713;
      }
   }
}
