import java.awt.datatransfer.Clipboard;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class8 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1170107467
   )
   int field136 = 1;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 84272229
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("t")
   boolean field138;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -721031063
   )
   static int field139 = 4;
   @ObfuscatedName("b")
   LinkedHashMap field140 = new LinkedHashMap();
   @ObfuscatedName("bs")
   static ModIcon field142;
   @ObfuscatedName("pu")
   static Clipboard field144;
   @ObfuscatedName("db")
   static byte[][] field148;
   @ObfuscatedName("n")
   boolean field149;
   @ObfuscatedName("eo")
   static ModIcon[] field150;

   class8(Buffer var1) {
      if(null != var1 && null != var1.payload) {
         int var2 = var1.method2656();
         if(var2 >= 0 && var2 <= field139) {
            if(var1.method2656() == 1) {
               this.field149 = true;
            }

            if(var2 > 1) {
               this.field138 = var1.method2656() == 1;
            }

            if(var2 > 3) {
               this.field136 = var1.method2656();
            }

            if(var2 > 2) {
               int var3 = var1.method2656();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2538();
                  int var6 = var1.method2538();
                  this.field140.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method97(true);
         }
      } else {
         this.method97(true);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1275651997"
   )
   void method97(boolean var1) {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "-2073726768"
   )
   Buffer method98() {
      Buffer var1 = new Buffer(100);
      var1.method2518(field139);
      var1.method2518(this.field149?1:0);
      var1.method2518(this.field138?1:0);
      var1.method2518(this.field136);
      var1.method2518(this.field140.size());
      Iterator var2 = this.field140.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2521(((Integer)var3.getKey()).intValue());
         var1.method2521(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ZZS)I",
      garbageValue = "-12368"
   )
   public static int method99(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class174.field2754 + class174.field2748;
      return var3;
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1592687256"
   )
   static boolean method104(String var0) {
      if(null == var0) {
         return false;
      } else {
         String var1 = class47.method967(var0, RSCanvas.field2188);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class47.method967(var3.name, RSCanvas.field2188))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class47.method967(var3.previousName, RSCanvas.field2188))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIBI)V",
      garbageValue = "2090529691"
   )
   static final void method106(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.method40();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.method40();
            class110 var9 = ObjectComposition.method821(var1, var2);
            CollisionData var10 = Client.collisionMaps[var0.field41];
            int[] var11 = Client.field560;
            int[] var12 = Client.field515;

            int var13;
            int var14;
            for(var13 = 0; var13 < 128; ++var13) {
               for(var14 = 0; var14 < 128; ++var14) {
                  class109.field1927[var13][var14] = 0;
                  class109.field1925[var13][var14] = 99999999;
               }
            }

            boolean var32;
            if(var8 == 1) {
               var32 = class126.method2802(var4, var5, var9, var10);
            } else if(var8 == 2) {
               var32 = class222.method4059(var4, var5, var9, var10);
            } else {
               var32 = class112.method2453(var4, var5, var8, var9, var10);
            }

            int var7;
            label247: {
               var14 = var4 - 64;
               int var15 = var5 - 64;
               int var16 = FileOnDisk.field3264;
               int var17 = class109.field1929;
               int var18;
               int var19;
               int var21;
               if(!var32) {
                  var18 = Integer.MAX_VALUE;
                  var19 = Integer.MAX_VALUE;
                  byte var20 = 10;
                  var21 = var9.field1938;
                  int var22 = var9.field1935;
                  int var23 = var9.field1934;
                  int var24 = var9.field1936;

                  for(int var25 = var21 - var20; var25 <= var20 + var21; ++var25) {
                     for(int var26 = var22 - var20; var26 <= var20 + var22; ++var26) {
                        int var27 = var25 - var14;
                        int var28 = var26 - var15;
                        if(var27 >= 0 && var28 >= 0 && var27 < 128 && var28 < 128 && class109.field1925[var27][var28] < 100) {
                           int var29 = 0;
                           if(var25 < var21) {
                              var29 = var21 - var25;
                           } else if(var25 > var23 + var21 - 1) {
                              var29 = var25 - (var23 + var21 - 1);
                           }

                           int var30 = 0;
                           if(var26 < var22) {
                              var30 = var22 - var26;
                           } else if(var26 > var24 + var22 - 1) {
                              var30 = var26 - (var22 + var24 - 1);
                           }

                           int var31 = var30 * var30 + var29 * var29;
                           if(var31 < var18 || var31 == var18 && class109.field1925[var27][var28] < var19) {
                              var18 = var31;
                              var19 = class109.field1925[var27][var28];
                              var16 = var25;
                              var17 = var26;
                           }
                        }
                     }
                  }

                  if(var18 == Integer.MAX_VALUE) {
                     var7 = -1;
                     break label247;
                  }
               }

               if(var4 == var16 && var17 == var5) {
                  var7 = 0;
               } else {
                  byte var34 = 0;
                  class109.field1932[var34] = var16;
                  var18 = var34 + 1;
                  class109.field1933[var34] = var17;

                  int var35;
                  for(var19 = var35 = class109.field1927[var16 - var14][var17 - var15]; var4 != var16 || var17 != var5; var19 = class109.field1927[var16 - var14][var17 - var15]) {
                     if(var35 != var19) {
                        var35 = var19;
                        class109.field1932[var18] = var16;
                        class109.field1933[var18++] = var17;
                     }

                     if((var19 & 2) != 0) {
                        ++var16;
                     } else if((var19 & 8) != 0) {
                        --var16;
                     }

                     if((var19 & 1) != 0) {
                        ++var17;
                     } else if((var19 & 4) != 0) {
                        --var17;
                     }
                  }

                  var21 = 0;

                  while(var18-- > 0) {
                     var11[var21] = class109.field1932[var18];
                     var12[var21++] = class109.field1933[var18];
                     if(var21 >= var11.length) {
                        break;
                     }
                  }

                  var7 = var21;
               }
            }

            var13 = var7;
            if(var7 >= 1) {
               for(var14 = 0; var14 < var13 - 1; ++var14) {
                  var0.method23(Client.field560[var14], Client.field515[var14], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "-2007992551"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field923.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field921.method3304(6, var0);
         var1 = new ObjectComposition();
         var1.field928 = var0;
         if(null != var2) {
            var1.method823(new Buffer(var2));
         }

         var1.method839();
         if(var1.field948) {
            var1.field938 = 0;
            var1.field967 = false;
         }

         ObjectComposition.field923.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-735517915"
   )
   static final void method109(int var0, int var1, int var2, boolean var3) {
      if(class171.method3404(var0)) {
         class28.method654(Widget.widgets[var0], -1, var1, var2, var3);
      }
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "56"
   )
   static final void method110(boolean var0) {
      class49.method1012();
      ++Client.field552;
      if(Client.field552 >= 50 || var0) {
         Client.field552 = 0;
         if(!Client.field336 && null != class23.field604) {
            Client.field397.method2768(204);

            try {
               class23.field604.method3009(Client.field397.payload, 0, Client.field397.offset);
               Client.field397.offset = 0;
            } catch (IOException var2) {
               Client.field336 = true;
            }
         }

      }
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-2035417998"
   )
   static final String[] method111(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   class8() {
      this.method97(true);
   }
}
