import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class45 {
   @ObfuscatedName("o")
   static byte[] field898 = new byte[2048];
   @ObfuscatedName("r")
   static byte[] field899 = new byte[2048];
   @ObfuscatedName("w")
   static Buffer[] field900 = new Buffer[2048];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 781868831
   )
   static int field901 = 0;
   @ObfuscatedName("q")
   static int[] field902 = new int[2048];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 192930215
   )
   static int field903 = 0;
   @ObfuscatedName("y")
   static String field904;
   @ObfuscatedName("n")
   static int[] field905 = new int[2048];
   @ObfuscatedName("s")
   static int[] field906 = new int[2048];
   @ObfuscatedName("g")
   static int[] field907 = new int[2048];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1550895529
   )
   static int field908 = 0;
   @ObfuscatedName("v")
   static int[] field909 = new int[2048];
   @ObfuscatedName("c")
   static int[] field911 = new int[2048];
   @ObfuscatedName("a")
   static Buffer field912 = new Buffer(new byte[5000]);
   @ObfuscatedName("kw")
   @Export("chatMessages")
   static ChatMessages chatMessages;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "641126073"
   )
   static final void method826() {
      Region.field1523 = false;
      Client.field278 = false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-86228843"
   )
   static final void method827() {
      Widget.method2832();
      FloorUnderlayDefinition.field2794.reset();
      KitDefinition.field2808.reset();
      class0.method0();
      class162.method3141();
      class30.method698();
      Sequence.field3049.reset();
      Sequence.field3036.reset();
      class145.method2727();
      Varbit.field2830.reset();
      class187.field2756.reset();
      class196.field2857.reset();
      class196.spriteCache.reset();
      class196.field2854.reset();
      class30.method693();
      PlayerComposition.field2022.reset();
      class151.method2849();
      ((TextureProvider)class84.field1448).method1445();
      class48.field944.reset();
      class152.field2191.method3288();
      class0.field2.method3288();
      class166.field2297.method3288();
      Friend.field152.method3288();
      class37.field786.method3288();
      ChatMessages.field923.method3288();
      class171.field2330.method3288();
      Friend.field147.method3288();
      class171.field2324.method3288();
      class174.field2628.method3288();
      class11.field109.method3288();
      class112.field1763.method3288();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "9945011"
   )
   static final int method832(int var0, int var1) {
      int var2 = class172.method3251(var0 - 1, var1 - 1) + class172.method3251(var0 + 1, var1 - 1) + class172.method3251(var0 - 1, 1 + var1) + class172.method3251(1 + var0, 1 + var1);
      int var3 = class172.method3251(var0 - 1, var1) + class172.method3251(var0 + 1, var1) + class172.method3251(var0, var1 - 1) + class172.method3251(var0, 1 + var1);
      int var4 = class172.method3251(var0, var1);
      return var3 / 8 + var2 / 16 + var4 / 4;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "66"
   )
   static final void method837(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field288; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field482[var4] = true;
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1667551346"
   )
   public static boolean method838() {
      long var0 = class22.method224();
      int var2 = (int)(var0 - class185.field2730);
      class185.field2730 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class185.field2738 += var2;
      if(class185.field2739 == 0 && class185.field2734 == 0 && class185.field2731 == 0 && class185.field2732 == 0) {
         return true;
      } else if(class185.field2748 == null) {
         return false;
      } else {
         try {
            if(class185.field2738 > 30000) {
               throw new IOException();
            } else {
               class181 var3;
               Buffer var4;
               while(class185.field2734 < 20 && class185.field2732 > 0) {
                  var3 = (class181)class185.field2736.method2334();
                  var4 = new Buffer(4);
                  var4.method2912(1);
                  var4.method2914((int)var3.hash);
                  class185.field2748.method2054(var4.payload, 0, 4);
                  class185.field2733.method2333(var3, var3.hash);
                  --class185.field2732;
                  ++class185.field2734;
               }

               while(class185.field2739 < 20 && class185.field2731 > 0) {
                  var3 = (class181)class185.field2729.method2283();
                  var4 = new Buffer(4);
                  var4.method2912(0);
                  var4.method2914((int)var3.hash);
                  class185.field2748.method2054(var4.payload, 0, 4);
                  var3.method2411();
                  class185.field2740.method2333(var3, var3.hash);
                  --class185.field2731;
                  ++class185.field2739;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class185.field2748.method2052();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class185.field2738 = 0;
                  byte var5 = 0;
                  if(class112.field1762 == null) {
                     var5 = 8;
                  } else if(class185.field2735 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class185.field2744.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class185.field2748.method2053(class185.field2744.payload, class185.field2744.offset, var6);
                     if(class185.field2728 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class185.field2744.payload[class185.field2744.offset + var7] ^= class185.field2728;
                        }
                     }

                     class185.field2744.offset += var6;
                     if(class185.field2744.offset < var5) {
                        break;
                     }

                     if(null == class112.field1762) {
                        class185.field2744.offset = 0;
                        var7 = class185.field2744.readUnsignedByte();
                        var8 = class185.field2744.readUnsignedShort();
                        int var9 = class185.field2744.readUnsignedByte();
                        var10 = class185.field2744.method3062();
                        long var11 = (long)((var7 << 16) + var8);
                        class181 var13 = (class181)class185.field2733.method2331(var11);
                        class11.field106 = true;
                        if(var13 == null) {
                           var13 = (class181)class185.field2740.method2331(var11);
                           class11.field106 = false;
                        }

                        if(null == var13) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class112.field1762 = var13;
                        CombatInfoListHolder.field749 = new Buffer(class112.field1762.field2686 + var10 + var14);
                        CombatInfoListHolder.field749.method2912(var9);
                        CombatInfoListHolder.field749.method3057(var10);
                        class185.field2735 = 8;
                        class185.field2744.offset = 0;
                     } else if(class185.field2735 == 0) {
                        if(class185.field2744.payload[0] == -1) {
                           class185.field2735 = 1;
                           class185.field2744.offset = 0;
                        } else {
                           class112.field1762 = null;
                        }
                     }
                  } else {
                     var6 = CombatInfoListHolder.field749.payload.length - class112.field1762.field2686;
                     var7 = 512 - class185.field2735;
                     if(var7 > var6 - CombatInfoListHolder.field749.offset) {
                        var7 = var6 - CombatInfoListHolder.field749.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class185.field2748.method2053(CombatInfoListHolder.field749.payload, CombatInfoListHolder.field749.offset, var7);
                     if(class185.field2728 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           CombatInfoListHolder.field749.payload[var8 + CombatInfoListHolder.field749.offset] ^= class185.field2728;
                        }
                     }

                     CombatInfoListHolder.field749.offset += var7;
                     class185.field2735 += var7;
                     if(var6 == CombatInfoListHolder.field749.offset) {
                        if(16711935L == class112.field1762.hash) {
                           CombatInfoListHolder.field754 = CombatInfoListHolder.field749;

                           for(var8 = 0; var8 < 256; ++var8) {
                              class184 var17 = class185.field2743[var8];
                              if(null != var17) {
                                 CombatInfoListHolder.field754.offset = 5 + var8 * 8;
                                 var10 = CombatInfoListHolder.field754.method3062();
                                 int var18 = CombatInfoListHolder.field754.method3062();
                                 var17.method3367(var10, var18);
                              }
                           }
                        } else {
                           class185.field2742.reset();
                           class185.field2742.update(CombatInfoListHolder.field749.payload, 0, var6);
                           var8 = (int)class185.field2742.getValue();
                           if(var8 != class112.field1762.field2687) {
                              try {
                                 class185.field2748.method2064();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class185.field2745;
                              class185.field2748 = null;
                              class185.field2728 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class185.field2745 = 0;
                           class185.field2746 = 0;
                           class112.field1762.field2692.method3368((int)(class112.field1762.hash & 65535L), CombatInfoListHolder.field749.payload, (class112.field1762.hash & 16711680L) == 16711680L, class11.field106);
                        }

                        class112.field1762.unlink();
                        if(class11.field106) {
                           --class185.field2734;
                        } else {
                           --class185.field2739;
                        }

                        class185.field2735 = 0;
                        class112.field1762 = null;
                        CombatInfoListHolder.field749 = null;
                     } else {
                        if(class185.field2735 != 512) {
                           break;
                        }

                        class185.field2735 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class185.field2748.method2064();
            } catch (Exception var19) {
               ;
            }

            ++class185.field2746;
            class185.field2748 = null;
            return false;
         }
      }
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method839() {
      class2.method28(Client.field450);
      ++MessageNode.field230;
      if(Client.field458 && Client.field388) {
         int var0 = class115.field1799;
         int var1 = class115.field1794;
         var0 -= Client.field452;
         var1 -= Client.field360;
         if(var0 < Client.field456) {
            var0 = Client.field456;
         }

         if(var0 + Client.field450.width > Client.field456 + Client.field420.width) {
            var0 = Client.field420.width + Client.field456 - Client.field450.width;
         }

         if(var1 < Client.field457) {
            var1 = Client.field457;
         }

         if(var1 + Client.field450.height > Client.field457 + Client.field420.height) {
            var1 = Client.field457 + Client.field420.height - Client.field450.height;
         }

         int var2 = var0 - Client.field375;
         int var3 = var1 - Client.field555;
         int var4 = Client.field450.field2125;
         if(MessageNode.field230 > Client.field450.field2097 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            Client.field460 = true;
         }

         int var5 = var0 - Client.field456 + Client.field420.scrollX;
         int var6 = Client.field420.scrollY + (var1 - Client.field457);
         class18 var7;
         if(null != Client.field450.field2138 && Client.field460) {
            var7 = new class18();
            var7.field190 = Client.field450;
            var7.field191 = var5;
            var7.field188 = var6;
            var7.field198 = Client.field450.field2138;
            class9.method118(var7);
         }

         if(class115.field1805 == 0) {
            if(Client.field460) {
               if(null != Client.field450.field2139) {
                  var7 = new class18();
                  var7.field190 = Client.field450;
                  var7.field191 = var5;
                  var7.field188 = var6;
                  var7.field194 = Client.field454;
                  var7.field198 = Client.field450.field2139;
                  class9.method118(var7);
               }

               if(Client.field454 != null) {
                  Widget var8 = Client.field450;
                  int var9 = class32.method713(class88.method1872(var8));
                  Widget var14;
                  if(var9 == 0) {
                     var14 = null;
                  } else {
                     int var10 = 0;

                     while(true) {
                        if(var10 >= var9) {
                           var14 = var8;
                           break;
                        }

                        var8 = class37.method759(var8.parentId);
                        if(var8 == null) {
                           var14 = null;
                           break;
                        }

                        ++var10;
                     }
                  }

                  if(var14 != null) {
                     Client.field321.method3195(46);
                     Client.field321.method3094(Client.field450.index);
                     Client.field321.method2960(Client.field454.item);
                     Client.field321.method3094(Client.field454.index);
                     Client.field321.method3057(Client.field454.id);
                     Client.field321.method3057(Client.field450.id);
                     Client.field321.method2960(Client.field450.item);
                  }
               }
            } else if((Client.field543 == 1 || class16.method198(Client.menuOptionCount - 1)) && Client.menuOptionCount > 2) {
               Actor.method643(Client.field452 + Client.field375, Client.field555 + Client.field360);
            } else if(Client.menuOptionCount > 0) {
               int var13 = Client.field452 + Client.field375;
               int var11 = Client.field555 + Client.field360;
               class38 var12 = Friend.field158;
               class0.menuAction(var12.field796, var12.field791, var12.field792, var12.field793, var12.field790, var12.field790, var13, var11);
               Friend.field158 = null;
            }

            Client.field450 = null;
         }

      } else {
         if(MessageNode.field230 > 1) {
            Client.field450 = null;
         }

      }
   }

   class45() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)LNPCComposition;",
      garbageValue = "54"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field2986.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3008.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.method3701(new Buffer(var2));
         }

         var1.method3700();
         NPCComposition.field2986.put(var1, (long)var0);
         return var1;
      }
   }
}
