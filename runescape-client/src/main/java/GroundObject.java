import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 750491121
   )
   @Export("x")
   int x;
   @ObfuscatedName("z")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 420405005
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1903753005
   )
   int field1646;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1099178583
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -499672593
   )
   @Export("floor")
   int floor;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)LNPCComposition;",
      garbageValue = "8"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field886.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field894.method3290(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(null != var2) {
            var1.method790(new Buffer(var2));
         }

         var1.method796();
         NPCComposition.field886.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "1919825857"
   )
   static MessageNode method2218(int var0) {
      return (MessageNode)class11.field164.method3839((long)var0);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "-1463109248"
   )
   static final void method2219(class125 var0) {
      for(int var1 = 0; var1 < class34.field762; ++var1) {
         int var2 = class34.field771[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.method2556();
         if((var4 & 16) != 0) {
            var4 += var0.method2556() << 8;
         }

         byte var5 = -1;
         int var6;
         if((var4 & 2) != 0) {
            var6 = var0.method2556();
            byte[] var7 = new byte[var6];
            Buffer var8 = new Buffer(var7);
            var0.method2567(var7, 0, var6);
            class34.field759[var2] = var8;
            var3.method19(var8);
         }

         int var20;
         if((var4 & 32) != 0) {
            var6 = var0.method2551();
            if(var6 == '\uffff') {
               var6 = -1;
            }

            var20 = var0.method2556();
            Renderable.method1945(var3, var6, var20);
         }

         if((var4 & 8) != 0) {
            var3.interacting = var0.method2551();
            if(var3.interacting == '\uffff') {
               var3.interacting = -1;
            }
         }

         if((var4 & 1) != 0) {
            var3.overhead = var0.method2774();
            if(var3.overhead.charAt(0) == 126) {
               var3.overhead = var3.overhead.substring(1);
               class23.sendGameMessage(2, var3.name, var3.overhead);
            } else if(var3 == class48.localPlayer) {
               class23.sendGameMessage(2, var3.name, var3.overhead);
            }

            var3.field828 = false;
            var3.field834 = 0;
            var3.field862 = 0;
            var3.field838 = 150;
         }

         int var10;
         int var11;
         if((var4 & 128) != 0) {
            var6 = var0.method2556();
            int var9;
            int var12;
            int var21;
            if(var6 > 0) {
               for(var20 = 0; var20 < var6; ++var20) {
                  var9 = -1;
                  var10 = -1;
                  var11 = -1;
                  var21 = var0.method2569();
                  if(var21 == 32767) {
                     var21 = var0.method2569();
                     var10 = var0.method2569();
                     var9 = var0.method2569();
                     var11 = var0.method2569();
                  } else if(var21 != 32766) {
                     var10 = var0.method2569();
                  } else {
                     var21 = -1;
                  }

                  var12 = var0.method2569();
                  var3.method751(var21, var10, var9, var11, Client.gameCycle, var12);
               }
            }

            var20 = var0.method2556();
            if(var20 > 0) {
               for(var21 = 0; var21 < var20; ++var21) {
                  var9 = var0.method2569();
                  var10 = var0.method2569();
                  if(var10 != 32767) {
                     var11 = var0.method2569();
                     var12 = var0.method2556();
                     int var13 = var10 > 0?var0.method2556():var12;
                     var3.method752(var9, Client.gameCycle, var10, var11, var12, var13);
                  } else {
                     var3.method753(var9);
                  }
               }
            }
         }

         if((var4 & 64) != 0) {
            var3.field845 = var0.method2551();
            if(var3.field871 == 0) {
               var3.field835 = var3.field845;
               var3.field845 = -1;
            }
         }

         if((var4 & 4) != 0) {
            var6 = var0.method2551();
            class155[] var26 = new class155[]{class155.field2312, class155.field2314, class155.field2313, class155.field2311, class155.field2320};
            class155 var27 = (class155)class5.method98(var26, var0.method2556());
            boolean var29 = var0.method2556() == 1;
            var10 = var0.method2556();
            var11 = var0.offset;
            if(var3.name != null && null != var3.composition) {
               boolean var30 = false;
               if(var27.field2316 && class140.method2968(var3.name)) {
                  var30 = true;
               }

               if(!var30 && Client.field304 == 0 && !var3.field29) {
                  class34.field769.offset = 0;
                  var0.method2567(class34.field769.payload, 0, var10);
                  class34.field769.offset = 0;
                  Buffer var14 = class34.field769;

                  String var15;
                  int var16;
                  String var18;
                  try {
                     var16 = var14.method2569();
                     if(var16 > 32767) {
                        var16 = 32767;
                     }

                     byte[] var17 = new byte[var16];
                     var14.offset += class225.field3232.method2495(var14.payload, var14.offset, var17, 0, var16);
                     var18 = class14.method169(var17, 0, var16);
                     var15 = var18;
                  } catch (Exception var25) {
                     var15 = "Cabbage";
                  }

                  var15 = class226.method4082(class26.method585(var15));
                  var3.overhead = var15.trim();
                  var3.field834 = var6 >> 8;
                  var3.field862 = var6 & 255;
                  var3.field838 = 150;
                  var3.field828 = var29;
                  var3.inSequence = var3 != class48.localPlayer && var27.field2316 && "" != Client.field499 && var15.toLowerCase().indexOf(Client.field499) == -1;
                  if(var27.field2317) {
                     var16 = var29?91:1;
                  } else {
                     var16 = var29?90:2;
                  }

                  if(var27.field2310 != -1) {
                     int var19 = var27.field2310;
                     var18 = "<img=" + var19 + ">";
                     class23.sendGameMessage(var16, var18 + var3.name, var15);
                  } else {
                     class23.sendGameMessage(var16, var3.name, var15);
                  }
               }
            }

            var0.offset = var11 + var10;
         }

         if((var4 & 512) != 0) {
            var3.graphic = var0.method2551();
            var6 = var0.method2561();
            var3.field858 = var6 >> 16;
            var3.field857 = (var6 & '\uffff') + Client.gameCycle;
            var3.field855 = 0;
            var3.field856 = 0;
            if(var3.field857 > Client.gameCycle) {
               var3.field855 = -1;
            }

            if(var3.graphic == '\uffff') {
               var3.graphic = -1;
            }
         }

         if((var4 & 1024) != 0) {
            var3.field823 = var0.method2557();
            var3.field861 = var0.method2557();
            var3.field860 = var0.method2557();
            var3.field874 = var0.method2557();
            var3.field863 = var0.method2551() + Client.gameCycle;
            var3.field864 = var0.method2551() + Client.gameCycle;
            var3.field865 = var0.method2551();
            if(var3.field49) {
               var3.field823 += var3.field50;
               var3.field861 += var3.field26;
               var3.field860 += var3.field50;
               var3.field874 += var3.field26;
               var3.field871 = 0;
            } else {
               var3.field823 += var3.pathX[0];
               var3.field861 += var3.pathY[0];
               var3.field860 += var3.pathX[0];
               var3.field874 += var3.pathY[0];
               var3.field871 = 1;
            }

            var3.field822 = 0;
         }

         if((var4 & 4096) != 0) {
            class34.field758[var2] = var0.method2557();
         }

         if((var4 & 256) != 0) {
            var5 = var0.method2557();
         }

         if((var4 & 2048) != 0) {
            for(var6 = 0; var6 < 3; ++var6) {
               var3.actions[var6] = var0.method2774();
            }
         }

         if(var3.field49) {
            if(var5 == 127) {
               var3.method36(var3.field50, var3.field26);
            } else {
               byte var28;
               if(var5 != -1) {
                  var28 = var5;
               } else {
                  var28 = class34.field758[var2];
               }

               var3.method17(var3.field50, var3.field26, var28);
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass170;IB)Lclass184;",
      garbageValue = "0"
   )
   static class184 method2220(class170 var0, int var1) {
      byte[] var2 = var0.method3352(var1);
      return var2 == null?null:new class184(var2);
   }
}
