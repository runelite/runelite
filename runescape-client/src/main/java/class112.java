import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public class class112 {
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = -256514051
   )
   static int field1939;
   @ObfuscatedName("z")
   public static class170 field1941;
   @ObfuscatedName("h")
   public static short[][] field1942;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;I)V",
      garbageValue = "261704680"
   )
   static final void method2389(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var9 + var2 > 0 && var2 + var9 < 103 && var10 + var3 > 0 && var10 + var3 < 103) {
               var8[var1].flags[var9 + var2][var10 + var3] &= -16777217;
            }
         }
      }

      Buffer var21 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var4 == var10 && var11 >= var5 && var11 < 8 + var5 && var12 >= var6 && var12 < var6 + 8) {
                  int var15 = var2 + class33.method712(var11 & 7, var12 & 7, var7);
                  int var18 = var11 & 7;
                  int var19 = var12 & 7;
                  int var20 = var7 & 3;
                  int var17;
                  if(var20 == 0) {
                     var17 = var19;
                  } else if(var20 == 1) {
                     var17 = 7 - var18;
                  } else if(var20 == 2) {
                     var17 = 7 - var19;
                  } else {
                     var17 = var18;
                  }

                  GameObject.method2179(var21, var1, var15, var3 + var17, 0, 0, var7);
               } else {
                  GameObject.method2179(var21, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   static {
      new HashMap();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-749112039"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class45.method923();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field420 = 0;
            Client.field352 = 0;
            Client.field268 = 0;
         }

         if(var0 != 20 && var0 != 40 && null != class75.field1394) {
            class75.field1394.method2986();
            class75.field1394 = null;
         }

         if(Client.gameState == 25) {
            Client.field329 = 0;
            Client.field322 = 0;
            Client.field323 = 1;
            Client.field324 = 0;
            Client.field340 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class22.method566(Frames.canvas, class128.field2074, class152.field2281, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class22.method566(Frames.canvas, class128.field2074, class152.field2281, false, 4);
            } else {
               class186.method3566();
            }
         } else {
            class22.method566(Frames.canvas, class128.field2074, class152.field2281, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-200934983"
   )
   static final void method2393(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(null != var3) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method2393(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3775((long)var3.id);
               if(null != var4) {
                  int var5 = var4.id;
                  if(class174.method3393(var5)) {
                     method2393(Widget.widgets[var5], var1);
                  }
               }
            }

            class0 var6;
            if(var1 == 0 && var3.field2905 != null) {
               var6 = new class0();
               var6.field2 = var3;
               var6.field5 = var3.field2905;
               MessageNode.method754(var6);
            }

            if(var1 == 1 && var3.field2906 != null) {
               if(var3.index >= 0) {
                  Widget var7 = class92.method2078(var3.id);
                  if(null == var7 || null == var7.children || var3.index >= var7.children.length || var7.children[var3.index] != var3) {
                     continue;
                  }
               }

               var6 = new class0();
               var6.field2 = var3;
               var6.field5 = var3.field2906;
               MessageNode.method754(var6);
            }
         }
      }

   }
}
