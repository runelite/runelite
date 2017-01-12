import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1971445653
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2136393253
   )
   @Export("z")
   int z;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -201352049
   )
   @Export("magnitude")
   int magnitude;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1669778065
   )
   @Export("y")
   int y;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[IB)V",
      garbageValue = "30"
   )
   static void method1597(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method636()?1:0;
                     var12 = var8.method636()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method636()?1:0;
                     var12 = var8.method636()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method1597(var0, var1, var6, var3, var4);
         method1597(var0, 1 + var6, var2, var3, var4);
      }

   }

   @ObfuscatedName("u")
   public static final void method1598(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            CombatInfoListHolder.method709(var0 - 1L);
            CombatInfoListHolder.method709(1L);
         } else {
            CombatInfoListHolder.method709(var0);
         }

      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "24"
   )
   static final void method1599(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = var2 + 6;
      int var5 = class22.field235.method3864(var0, 250);
      int var6 = class22.field235.method3865(var0, 250) * 13;
      class219.method3993(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 0);
      class219.method3977(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6, 16777215);
      class22.field235.method3871(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      Client.method312(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = class165.canvas.getGraphics();
            GameEngine.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var8) {
            class165.canvas.repaint();
         }
      } else {
         class152.method2757(var3, var4, var5, var6);
      }

   }

   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   VertexNormal() {
   }
}
