import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("GroundObject")
public final class class96 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -265715
   )
   @Export("floor")
   int field1663;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 314188497
   )
   @Export("x")
   int field1664;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1041734195
   )
   @Export("y")
   int field1665;
   @ObfuscatedName("e")
   @Export("renderable")
   public class88 field1666;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 569320307
   )
   @Export("hash")
   public int field1667;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -835877039
   )
   int field1668;
   @ObfuscatedName("qh")
   protected static class136 field1669;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = 1541264873
   )
   @Export("cameraY")
   static int field1670;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass122;IIIIIII)V",
      garbageValue = "-2011661079"
   )
   static final void method2252(class122 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.field80[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2633();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var14 = class5.field85[0][var2];
                  int var11 = var4 + 932731 + var2;
                  int var12 = 556238 + var3 + var5;
                  int var13 = class144.method3126(var11 + '넵', 91923 + var12, 4) - 128 + (class144.method3126(var11 + 10294, '鎽' + var12, 2) - 128 >> 1) + (class144.method3126(var11, var12, 1) - 128 >> 2);
                  var13 = 35 + (int)(0.3D * (double)var13);
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var14[var3] = -var13 * 8;
               } else {
                  class5.field85[var1][var2][var3] = class5.field85[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.method2633();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class5.field85[0][var2][var3] = -var8 * 8;
               } else {
                  class5.field85[var1][var2][var3] = class5.field85[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class75.field1422[var1][var2][var3] = var0.method2634();
               class5.field88[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class5.field86[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class5.field80[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class5.field82[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2633();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.method2633();
               break;
            }

            if(var7 <= 49) {
               var0.method2633();
            }
         }
      }

   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-699890278"
   )
   static final void method2253() {
      boolean var0 = false;

      int var1;
      int var4;
      while(!var0) {
         var0 = true;

         for(var1 = 0; var1 < client.field368 - 1; ++var1) {
            if(client.field438[var1] < 1000 && client.field438[1 + var1] > 1000) {
               String var13 = client.field510[var1];
               client.field510[var1] = client.field510[1 + var1];
               client.field510[1 + var1] = var13;
               String var14 = client.field440[var1];
               client.field440[var1] = client.field440[1 + var1];
               client.field440[1 + var1] = var14;
               var4 = client.field438[var1];
               client.field438[var1] = client.field438[var1 + 1];
               client.field438[var1 + 1] = var4;
               var4 = client.field436[var1];
               client.field436[var1] = client.field436[1 + var1];
               client.field436[var1 + 1] = var4;
               var4 = client.field437[var1];
               client.field437[var1] = client.field437[1 + var1];
               client.field437[var1 + 1] = var4;
               var4 = client.field291[var1];
               client.field291[var1] = client.field291[var1 + 1];
               client.field291[var1 + 1] = var4;
               var0 = false;
            }
         }
      }

      if(null == class23.field614) {
         if(null == client.field466) {
            int var2;
            int var3;
            int var6;
            int var19;
            label318: {
               int var18 = class143.field2217;
               if(client.field434) {
                  if(var18 != 1 && (class214.field3188 || var18 != 4)) {
                     var1 = class143.field2206;
                     var2 = class143.field2209;
                     if(var1 < class13.field202 - 10 || var1 > class13.field202 + class30.field708 + 10 || var2 < class14.field218 - 10 || var2 > class77.field1442 + class14.field218 + 10) {
                        client.field434 = false;
                        class51.method1082(class13.field202, class14.field218, class30.field708, class77.field1442);
                     }
                  }

                  if(var18 == 1 || !class214.field3188 && var18 == 4) {
                     var1 = class13.field202;
                     var2 = class14.field218;
                     var3 = class30.field708;
                     var4 = class143.field2215;
                     var19 = class143.field2216;
                     var6 = -1;

                     int var7;
                     int var8;
                     for(var7 = 0; var7 < client.field368; ++var7) {
                        var8 = (client.field368 - 1 - var7) * 15 + var2 + 31;
                        if(var4 > var1 && var4 < var3 + var1 && var19 > var8 - 13 && var19 < var8 + 3) {
                           var6 = var7;
                        }
                     }

                     if(var6 != -1 && var6 >= 0) {
                        var7 = client.field436[var6];
                        var8 = client.field437[var6];
                        int var9 = client.field438[var6];
                        int var10 = client.field291[var6];
                        String var11 = client.field440[var6];
                        String var12 = client.field510[var6];
                        class51.method1090(var7, var8, var9, var10, var11, var12, class143.field2215, class143.field2216);
                     }

                     client.field434 = false;
                     class51.method1082(class13.field202, class14.field218, class30.field708, class77.field1442);
                  }
               } else {
                  if((var18 == 1 || !class214.field3188 && var18 == 4) && client.field368 > 0) {
                     var1 = client.field438[client.field368 - 1];
                     if(var1 == 39 || var1 == 40 || var1 == 41 || var1 == 42 || var1 == 43 || var1 == 33 || var1 == 34 || var1 == 35 || var1 == 36 || var1 == 37 || var1 == 38 || var1 == 1005) {
                        var2 = client.field436[client.field368 - 1];
                        var3 = client.field437[client.field368 - 1];
                        class176 var15 = class134.method2983(var3);
                        if(class167.method3373(class2.method39(var15))) {
                           break label318;
                        }

                        var6 = class2.method39(var15);
                        boolean var5 = (var6 >> 29 & 1) != 0;
                        if(var5) {
                           break label318;
                        }
                     }
                  }

                  if((var18 == 1 || !class214.field3188 && var18 == 4) && (client.field412 == 1 && client.field368 > 2 || class29.method680(client.field368 - 1))) {
                     var18 = 2;
                  }

                  if((var18 == 1 || !class214.field3188 && var18 == 4) && client.field368 > 0) {
                     var1 = client.field368 - 1;
                     if(var1 >= 0) {
                        var2 = client.field436[var1];
                        var3 = client.field437[var1];
                        var4 = client.field438[var1];
                        var19 = client.field291[var1];
                        String var17 = client.field440[var1];
                        String var16 = client.field510[var1];
                        class51.method1090(var2, var3, var4, var19, var17, var16, class143.field2215, class143.field2216);
                     }
                  }

                  if(var18 == 2 && client.field368 > 0) {
                     class172.method3514(class143.field2215, class143.field2216);
                  }
               }

               return;
            }

            if(class23.field614 != null && !client.field413 && client.field412 != 1 && !class29.method680(client.field368 - 1) && client.field368 > 0) {
               var19 = client.field410;
               var6 = client.field322;
               class132.method2973(class75.field1423, var19, var6);
               class75.field1423 = null;
            }

            client.field413 = false;
            client.field414 = 0;
            if(null != class23.field614) {
               class79.method1777(class23.field614);
            }

            class23.field614 = class134.method2983(var3);
            client.field409 = var2;
            client.field410 = class143.field2215;
            client.field322 = class143.field2216;
            if(client.field368 > 0) {
               var19 = client.field368 - 1;
               class75.field1423 = new class32();
               class75.field1423.field729 = client.field436[var19];
               class75.field1423.field739 = client.field437[var19];
               class75.field1423.field737 = client.field438[var19];
               class75.field1423.field732 = client.field291[var19];
               class75.field1423.field733 = client.field440[var19];
            }

            class79.method1777(class23.field614);
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "1308784348"
   )
   static void method2254(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method2254(var0, var1, var2, var5 - 1);
         method2254(var0, var1, var5 + 1, var3);
      }

   }
}
