import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -2004403351
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1303062905
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("a")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2117820763
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 160198391
   )
   int field1292;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -776369925
   )
   @Export("x")
   int x;
   @ObfuscatedName("aw")
   static boolean field1297;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1027677523
   )
   @Export("y")
   int y;
   @ObfuscatedName("s")
   static int[] field1300;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "215647754"
   )
   public static int method1496(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "1099596624"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            ++Client.menuOptionCount;
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-146937113"
   )
   static void method1498(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = World.worldList[var9];
            int var14 = class26.method598(var11, var8, var2, var3);
            int var10;
            if(var14 != 0) {
               if(var3) {
                  var10 = -var14;
               } else {
                  var10 = var14;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = class26.method598(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var12 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var12;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method1498(var0, var7 - 1, var2, var3, var4, var5);
         method1498(1 + var7, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "763769087"
   )
   static final void method1499(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.field2184 || !WallObject.method1846(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.field2184 && WallObject.method1846(var3) && class188.field2758 != var3) {
                  continue;
               }

               method1499(var0, var3.id);
               if(null != var3.children) {
                  method1499(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2339((long)var3.id);
               if(var4 != null) {
                  var5 = var4.id;
                  if(class94.method1870(var5)) {
                     method1499(Widget.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2250 != -1 || var3.field2233 != -1) {
                  boolean var7 = class94.method1868(var3);
                  if(var7) {
                     var5 = var3.field2233;
                  } else {
                     var5 = var3.field2250;
                  }

                  if(var5 != -1) {
                     Sequence var6 = CombatInfo2.getAnimation(var5);

                     for(var3.field2308 += Client.field462; var3.field2308 > var6.frameLenghts[var3.field2215]; class6.method87(var3)) {
                        var3.field2308 -= var6.frameLenghts[var3.field2215];
                        ++var3.field2215;
                        if(var3.field2215 >= var6.frameIDs.length) {
                           var3.field2215 -= var6.frameStep;
                           if(var3.field2215 < 0 || var3.field2215 >= var6.frameIDs.length) {
                              var3.field2215 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2241 != 0 && !var3.field2184) {
                  int var8 = var3.field2241 >> 16;
                  var5 = var3.field2241 << 16 >> 16;
                  var8 *= Client.field462;
                  var5 *= Client.field462;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var3.rotationZ + var5 & 2047;
                  class6.method87(var3);
               }
            }
         }
      }

   }
}
