import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class22 extends class119 {
   @ObfuscatedName("bf")
   protected static FontMetrics field253;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = -734185937
   )
   static int field254;

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-1433042663"
   )
   static void method197(Widget var0) {
      if(Client.field507 == var0.field2254) {
         Client.field508[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;B)Z",
      garbageValue = "-1"
   )
   protected boolean vmethod2355(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field1874 && var3 == super.field1882;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)LVarbit;",
      garbageValue = "1751887674"
   )
   public static Varbit method201(int var0) {
      Varbit var1 = (Varbit)Varbit.field2856.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Varbit.field2857.getConfigData(14, var0);
         var1 = new Varbit();
         if(var2 != null) {
            var1.method3596(new Buffer(var2));
         }

         Varbit.field2856.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-11"
   )
   static void method202() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var1 = Client.menuTypes[var0];
         boolean var2 = var1 == 57 || var1 == 58 || var1 == 1007 || var1 == 25 || var1 == 30;
         if(var2) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-124799298"
   )
   static final void method203(int var0) {
      int[] var1 = CombatInfo1.field686.image;
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
            if((class10.tileSettings[var0][var5][var3] & 24) == 0) {
               CombatInfo1.region.method1770(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class10.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               CombatInfo1.region.method1770(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = ((int)(Math.random() * 20.0D) + 238 - 10 << 16) + ((int)(Math.random() * 20.0D) + 238 - 10 << 8) + ((int)(Math.random() * 20.0D) + 238 - 10);
      var4 = (int)(Math.random() * 20.0D) + 238 - 10 << 16;
      CombatInfo1.field686.method4133();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class10.tileSettings[var0][var6][var5] & 24) == 0) {
               MessageNode.method195(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class10.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               MessageNode.method195(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field533 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = CombatInfo1.region.method1845(Sequence.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class140.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var11 = Client.collisionMaps[Sequence.plane].flags;

                     for(int var12 = 0; var12 < 10; ++var12) {
                        int var13 = (int)(Math.random() * 4.0D);
                        if(var13 == 0 && var9 > 0 && var9 > var5 - 3 && (var11[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var13 == 1 && var9 < 103 && var9 < var5 + 3 && (var11[var9 + 1][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var13 == 2 && var10 > 0 && var10 > var6 - 3 && (var11[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(var13 == 3 && var10 < 103 && var10 < var6 + 3 && (var11[var9][var10 + 1] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  Client.field536[Client.field533] = class15.field171[var8];
                  Client.field534[Client.field533] = var9;
                  Client.field435[Client.field533] = var10;
                  ++Client.field533;
               }
            }
         }
      }

      class115.bufferProvider.method4072();
   }
}
