import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class31 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -751503355
   )
   final int field447;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1122759673
   )
   final int field448;
   @ObfuscatedName("h")
   public static byte[][] field449;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1386442013
   )
   final int field450;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = 844242281
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = -1453128433
   )
   static int field452;

   class31(int var1, int var2, int var3) {
      this.field450 = var1;
      this.field448 = var2;
      this.field447 = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "60"
   )
   public static void method282() {
      Sequence.field3625.reset();
      Sequence.field3611.reset();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "32"
   )
   static int method283(int var0) {
      MessageNode var1 = (MessageNode)class98.field1524.method3493((long)var0);
      return var1 == null?-1:(class98.field1525.field2501 == var1.next?-1:((MessageNode)var1.next).id);
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "378519119"
   )
   static final void method284() {
      if(Client.field1144 != class92.plane) {
         Client.field1144 = class92.plane;
         int var0 = class92.plane;
         int[] var1 = TextureProvider.field1787.image;
         int var2 = var1.length;

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            var1[var3] = 0;
         }

         int var4;
         int var5;
         for(var3 = 1; var3 < 103; ++var3) {
            var4 = (103 - var3) * 2048 + 24628;

            for(var5 = 1; var5 < 103; ++var5) {
               if((class61.tileSettings[var0][var5][var3] & 24) == 0) {
                  class61.region.method2793(var1, var4, 512, var0, var5, var3);
               }

               if(var0 < 3 && (class61.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
                  class61.region.method2793(var1, var4, 512, var0 + 1, var5, var3);
               }

               var4 += 4;
            }
         }

         var3 = ((int)(Math.random() * 20.0D) + 238 - 10 << 16) + ((int)(Math.random() * 20.0D) + 238 - 10 << 8) + ((int)(Math.random() * 20.0D) + 238 - 10);
         var4 = (int)(Math.random() * 20.0D) + 238 - 10 << 16;
         TextureProvider.field1787.method5089();

         int var6;
         for(var5 = 1; var5 < 103; ++var5) {
            for(var6 = 1; var6 < 103; ++var6) {
               if((class61.tileSettings[var0][var6][var5] & 24) == 0) {
                  class204.method3788(var0, var6, var5, var3, var4);
               }

               if(var0 < 3 && (class61.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
                  class204.method3788(var0 + 1, var6, var5, var3, var4);
               }
            }
         }

         Client.field1145 = 0;

         for(var5 = 0; var5 < 104; ++var5) {
            for(var6 = 0; var6 < 104; ++var6) {
               int var7 = class61.region.method2704(class92.plane, var5, var6);
               if(var7 != 0) {
                  var7 = var7 >> 14 & 32767;
                  int var8 = class61.getObjectDefinition(var7).mapIconId;
                  if(var8 >= 0) {
                     int var9 = var5;
                     int var10 = var6;
                     if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                        int[][] var13 = Client.collisionMaps[class92.plane].flags;

                        for(int var14 = 0; var14 < 10; ++var14) {
                           int var15 = (int)(Math.random() * 4.0D);
                           if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                              --var9;
                           }

                           if(var15 == 1 && var9 < 103 && var9 < var5 + 3 && (var13[var9 + 1][var10] & 19136896) == 0) {
                              ++var9;
                           }

                           if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var9][var10 - 1] & 19136770) == 0) {
                              --var10;
                           }

                           if(var15 == 3 && var10 < 103 && var10 < var6 + 3 && (var13[var9][var10 + 1] & 19136800) == 0) {
                              ++var10;
                           }
                        }
                     }

                     Client.field1148[Client.field1145] = World.field1300[var8].method4325(false);
                     Client.field1114[Client.field1145] = var9;
                     Client.field1065[Client.field1145] = var10;
                     ++Client.field1145;
                  }
               }
            }
         }

         class47.field601.method5051();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-780047350"
   )
   static int method285(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         class165.intStackSize -= 3;
         var3 = class83.intStack[class165.intStackSize];
         var4 = class83.intStack[class165.intStackSize + 1];
         int var5 = class83.intStack[class165.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = class177.method3390(var3);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class278.field3737 = var12;
               } else {
                  class37.field515 = var12;
               }

               CombatInfo1.method1515(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class278.field3737:class37.field515;
            Widget var10 = class177.method3390(var9.id);
            var10.children[var9.index] = null;
            CombatInfo1.method1515(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = class177.method3390(class83.intStack[--class165.intStackSize]);
            var9.children = null;
            CombatInfo1.method1515(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = class177.method3390(class83.intStack[--class165.intStackSize]);
               if(var9 != null) {
                  class83.intStack[++class165.intStackSize - 1] = 1;
                  if(var2) {
                     class278.field3737 = var9;
                  } else {
                     class37.field515 = var9;
                  }
               } else {
                  class83.intStack[++class165.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class165.intStackSize -= 2;
            var3 = class83.intStack[class165.intStackSize];
            var4 = class83.intStack[class165.intStackSize + 1];
            Widget var11 = class29.method254(var3, var4);
            if(var11 != null && var4 != -1) {
               class83.intStack[++class165.intStackSize - 1] = 1;
               if(var2) {
                  class278.field3737 = var11;
               } else {
                  class37.field515 = var11;
               }
            } else {
               class83.intStack[++class165.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-10"
   )
   static void method286(int var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(70);
      Client.secretPacketBuffer1.putShort(var1);
      Client.secretPacketBuffer1.putInt(var0);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIS)I",
      garbageValue = "24407"
   )
   static int method287(int var0, int var1, int var2) {
      return (class61.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class61.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }
}
