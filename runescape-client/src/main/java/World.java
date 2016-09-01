import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("World")
public class World {
   @ObfuscatedName("ae")
   static class171 field644;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -632902871
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -806940349
   )
   static int field646 = 0;
   @ObfuscatedName("g")
   @Export("activity")
   String activity;
   @ObfuscatedName("p")
   static int[] field649 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 305447555
   )
   @Export("index")
   int index;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 582368915
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("m")
   static int[] field652 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("t")
   @Export("address")
   String address;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -588414053
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1543313471
   )
   @Export("location")
   int location;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1668270105
   )
   static int field656 = 0;
   @ObfuscatedName("o")
   static int[] field659;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "1"
   )
   static final int method592(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class143.method3026(var3, var5);
      int var8 = class143.method3026(var3 + 1, var5);
      int var9 = class143.method3026(var3, var5 + 1);
      int var10 = class143.method3026(var3 + 1, 1 + var5);
      int var12 = 65536 - class94.field1640[1024 * var4 / var2] >> 1;
      int var11 = (var7 * (65536 - var12) >> 16) + (var12 * var8 >> 16);
      int var14 = 65536 - class94.field1640[1024 * var4 / var2] >> 1;
      int var13 = (var9 * (65536 - var14) >> 16) + (var10 * var14 >> 16);
      int var16 = 65536 - class94.field1640[var6 * 1024 / var2] >> 1;
      int var15 = (var11 * (65536 - var16) >> 16) + (var13 * var16 >> 16);
      return var15;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-3501582"
   )
   boolean method593() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1447809110"
   )
   boolean method594() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "112706337"
   )
   boolean method595() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-13879716"
   )
   boolean method597() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[Lclass155;",
      garbageValue = "27"
   )
   public static class155[] method611() {
      return new class155[]{class155.field2312, class155.field2314, class155.field2313, class155.field2311, class155.field2320};
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1142287985"
   )
   boolean method617() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-40"
   )
   boolean method619() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-643376935"
   )
   public static String method620(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class31.method663(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(48 + var6));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "30"
   )
   static void method626() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3821(); null != var0; var0 = (WidgetNode)Client.componentTable.method3822()) {
         int var1 = var0.id;
         if(class175.method3419(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].field2809;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = method628(var4);
               if(null != var5) {
                  class75.method1606(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIIB)V",
      garbageValue = "-31"
   )
   static final void method627(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(null != var0.field914) {
            var0 = var0.method779();
         }

         if(null != var0) {
            if(var0.field917) {
               if(!var0.field887 || Client.field447 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + Buffer.method2675(var0.combatLevel, class48.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(Client.field432 == 1) {
                     XItemContainer.addMenuEntry("Use", Client.field433 + " " + "->" + " " + class154.method3185(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field404) {
                     if((class171.field2749 & 2) == 2) {
                        XItemContainer.addMenuEntry(Client.field437, Client.field438 + " " + "->" + " " + class154.method3185(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.actions;
                     if(Client.field293) {
                        var5 = class75.method1607(var5);
                     }

                     int var6;
                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && !var5[var6].equalsIgnoreCase("Attack")) {
                              byte var7 = 0;
                              if(var6 == 0) {
                                 var7 = 9;
                              }

                              if(var6 == 1) {
                                 var7 = 10;
                              }

                              if(var6 == 2) {
                                 var7 = 11;
                              }

                              if(var6 == 3) {
                                 var7 = 12;
                              }

                              if(var6 == 4) {
                                 var7 = 13;
                              }

                              XItemContainer.addMenuEntry(var5[var6], class154.method3185(16776960) + var4, var7, var1, var2, var3);
                           }
                        }
                     }

                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && var5[var6].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(class21.field577 != Client.field307) {
                                 if(Client.field307 == class21.field575 || class21.field574 == Client.field307 && var0.combatLevel > class48.localPlayer.combatLevel) {
                                    var9 = 2000;
                                 }

                                 int var8 = 0;
                                 if(var6 == 0) {
                                    var8 = 9 + var9;
                                 }

                                 if(var6 == 1) {
                                    var8 = var9 + 10;
                                 }

                                 if(var6 == 2) {
                                    var8 = 11 + var9;
                                 }

                                 if(var6 == 3) {
                                    var8 = var9 + 12;
                                 }

                                 if(var6 == 4) {
                                    var8 = 13 + var9;
                                 }

                                 XItemContainer.addMenuEntry(var5[var6], class154.method3185(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     XItemContainer.addMenuEntry("Examine", class154.method3185(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "-2003546545"
   )
   public static Widget method628(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(null == Widget.widgets[var1] || null == Widget.widgets[var1][var2]) {
         boolean var3 = class175.method3419(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1347968564"
   )
   public static void method629() {
      Widget.field2872.reset();
      Widget.field2805.reset();
      Widget.field2806.reset();
      Widget.field2807.reset();
   }
}
