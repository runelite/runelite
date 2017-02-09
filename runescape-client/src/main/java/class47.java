import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class47 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 671517875
   )
   public static int field924;
   @ObfuscatedName("y")
   static final class121 field925 = new class121(1024);
   @ObfuscatedName("o")
   static final class136 field926 = new class136();
   @ObfuscatedName("k")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -934062433
   )
   static int field928 = 0;
   @ObfuscatedName("v")
   static int[] field929;
   @ObfuscatedName("j")
   static int[] field932;

   class47() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-341198468"
   )
   static final void method889(Widget var0, int var1, int var2) {
      if(var0.field2052 == 1) {
         class20.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var18;
      if(var0.field2052 == 2 && !Client.field432) {
         var18 = TextureProvider.method1461(var0);
         if(null != var18) {
            class20.addMenuEntry(var18, class163.method3157('\uff00') + var0.field2165, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2052 == 3) {
         class20.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2052 == 4) {
         class20.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2052 == 5) {
         class20.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2052 == 6 && Client.field309 == null) {
         class20.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var3;
      int var6;
      int var19;
      if(var0.type == 2) {
         var3 = 0;

         for(var19 = 0; var19 < var0.height; ++var19) {
            for(int var5 = 0; var5 < var0.width; ++var5) {
               var6 = (var0.field2118 + 32) * var5;
               int var7 = (var0.field2116 + 32) * var19;
               if(var3 < 20) {
                  var6 += var0.field2117[var3];
                  var7 += var0.field2109[var3];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < 32 + var6 && var2 < var7 + 32) {
                  Client.field381 = var3;
                  class212.field3114 = var0;
                  if(var0.itemIds[var3] > 0) {
                     label400: {
                        ItemComposition var8 = PlayerComposition.getItemDefinition(var0.itemIds[var3] - 1);
                        boolean var9;
                        int var10;
                        if(Client.field525 == 1) {
                           var10 = class88.method1872(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if(var0.id != class169.field2313 || Client.field429 != var3) {
                                 class20.addMenuEntry("Use", Client.field431 + " " + "->" + " " + class163.method3157(16748608) + var8.name, 31, var8.id, var3, var0.id);
                              }
                              break label400;
                           }
                        }

                        if(Client.field432) {
                           var10 = class88.method1872(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if((ItemComposition.field2939 & 16) == 16) {
                                 class20.addMenuEntry(Client.field435, Client.field436 + " " + "->" + " " + class163.method3157(16748608) + var8.name, 32, var8.id, var3, var0.id);
                              }
                              break label400;
                           }
                        }

                        String[] var20 = var8.inventoryActions;
                        if(Client.field394) {
                           var20 = XItemContainer.method170(var20);
                        }

                        int var11 = class88.method1872(var0);
                        boolean var24 = (var11 >> 30 & 1) != 0;
                        if(var24) {
                           for(int var12 = 4; var12 >= 3; --var12) {
                              if(var20 != null && var20[var12] != null) {
                                 byte var13;
                                 if(var12 == 3) {
                                    var13 = 36;
                                 } else {
                                    var13 = 37;
                                 }

                                 class20.addMenuEntry(var20[var12], class163.method3157(16748608) + var8.name, var13, var8.id, var3, var0.id);
                              } else if(var12 == 4) {
                                 class20.addMenuEntry("Drop", class163.method3157(16748608) + var8.name, 37, var8.id, var3, var0.id);
                              }
                           }
                        }

                        int var26 = class88.method1872(var0);
                        boolean var25 = (var26 >> 31 & 1) != 0;
                        if(var25) {
                           class20.addMenuEntry("Use", class163.method3157(16748608) + var8.name, 38, var8.id, var3, var0.id);
                        }

                        int var15 = class88.method1872(var0);
                        boolean var14 = (var15 >> 30 & 1) != 0;
                        int var16;
                        byte var17;
                        if(var14 && var20 != null) {
                           for(var16 = 2; var16 >= 0; --var16) {
                              if(var20[var16] != null) {
                                 var17 = 0;
                                 if(var16 == 0) {
                                    var17 = 33;
                                 }

                                 if(var16 == 1) {
                                    var17 = 34;
                                 }

                                 if(var16 == 2) {
                                    var17 = 35;
                                 }

                                 class20.addMenuEntry(var20[var16], class163.method3157(16748608) + var8.name, var17, var8.id, var3, var0.id);
                              }
                           }
                        }

                        var20 = var0.field2120;
                        if(Client.field394) {
                           var20 = XItemContainer.method170(var20);
                        }

                        if(var20 != null) {
                           for(var16 = 4; var16 >= 0; --var16) {
                              if(var20[var16] != null) {
                                 var17 = 0;
                                 if(var16 == 0) {
                                    var17 = 39;
                                 }

                                 if(var16 == 1) {
                                    var17 = 40;
                                 }

                                 if(var16 == 2) {
                                    var17 = 41;
                                 }

                                 if(var16 == 3) {
                                    var17 = 42;
                                 }

                                 if(var16 == 4) {
                                    var17 = 43;
                                 }

                                 class20.addMenuEntry(var20[var16], class163.method3157(16748608) + var8.name, var17, var8.id, var3, var0.id);
                              }
                           }
                        }

                        class20.addMenuEntry("Examine", class163.method3157(16748608) + var8.name, 1005, var8.id, var3, var0.id);
                     }
                  }
               }

               ++var3;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.field432) {
            var19 = class88.method1872(var0);
            boolean var22 = (var19 >> 21 & 1) != 0;
            if(var22 && (ItemComposition.field2939 & 32) == 32) {
               class20.addMenuEntry(Client.field435, Client.field436 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var3 = 9; var3 >= 5; --var3) {
               var6 = class88.method1872(var0);
               boolean var23 = (var6 >> 1 + var3 & 1) != 0;
               String var4;
               if(!var23 && var0.field2064 == null) {
                  var4 = null;
               } else if(null != var0.actions && var0.actions.length > var3 && var0.actions[var3] != null && var0.actions[var3].trim().length() != 0) {
                  var4 = var0.actions[var3];
               } else {
                  var4 = null;
               }

               if(var4 != null) {
                  class20.addMenuEntry(var4, var0.name, 1007, var3 + 1, var0.index, var0.id);
               }
            }

            var18 = TextureProvider.method1461(var0);
            if(var18 != null) {
               class20.addMenuEntry(var18, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var19 = 4; var19 >= 0; --var19) {
               String var21 = class20.method212(var0, var19);
               if(var21 != null) {
                  class20.addMenuEntry(var21, var0.name, 57, var19 + 1, var0.index, var0.id);
               }
            }

            if(class48.method896(class88.method1872(var0))) {
               class20.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "1"
   )
   static void method890(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class225.field3216 = var1.readUnsignedShort();
      class163.field2287 = new int[class225.field3216];
      class225.field3214 = new int[class225.field3216];
      field932 = new int[class225.field3216];
      class225.field3211 = new int[class225.field3216];
      class225.field3218 = new byte[class225.field3216][];
      var1.offset = var0.length - 7 - class225.field3216 * 8;
      class225.field3212 = var1.readUnsignedShort();
      class225.field3213 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class225.field3216; ++var3) {
         class163.field2287[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3216; ++var3) {
         class225.field3214[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3216; ++var3) {
         field932[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3216; ++var3) {
         class225.field3211[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class225.field3216 * 8 - (var2 - 1) * 3;
      class225.field3215 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class225.field3215[var3] = var1.read24BitInt();
         if(class225.field3215[var3] == 0) {
            class225.field3215[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class225.field3216; ++var3) {
         int var4 = field932[var3];
         int var5 = class225.field3211[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class225.field3218[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var4 * var10] = var1.readByte();
               }
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LWorld;I)V",
      garbageValue = "-833120057"
   )
   static void method891(World var0) {
      if(var0.method652() != Client.isMembers) {
         Client.isMembers = var0.method652();
         boolean var1 = var0.method652();
         if(ItemComposition.isMembersWorld != var1) {
            class30.method698();
            ItemComposition.isMembersWorld = var1;
         }
      }

      class10.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class157.field2216 = Client.field281 == 0?'ꩊ':'鱀' + var0.id;
      class6.field54 = Client.field281 == 0?443:'썐' + var0.id;
      Client.field492 = class157.field2216;
   }
}
