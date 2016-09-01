import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class4 {
   @ObfuscatedName("x")
   static final BigInteger field60 = new BigInteger("10001", 16);
   @ObfuscatedName("r")
   static final BigInteger field61 = new BigInteger("92dfddaaa52494bb6800aac4d066a2c189e527f170460e82adbf79310b3e69128c22f6fd13449035391e70284e60bdecc0b3ccf03cf0f7f172ac781cb6bfdd6fd71268c77364450350ca7344cd85c02fe226c167abc91c5c2da19ba8d36600c484a5b4f32de0eb64b77a05d029250cb755a0df67ea648165f9db589b18306b39", 16);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIB)I",
      garbageValue = "40"
   )
   public static int method46(byte[] var0, int var1) {
      return class12.method154(var0, 0, var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-18525"
   )
   static int method47(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3830((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var1 == var2.itemIds[var4]) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-119"
   )
   static final void method48() {
      boolean var0 = false;

      int var1;
      int var4;
      while(!var0) {
         var0 = true;

         for(var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[1 + var1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
               Client.menuOptions[var1 + 1] = var3;
               var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
               Client.menuTypes[1 + var1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[1 + var1];
               Client.menuActionParams0[var1 + 1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[1 + var1];
               Client.menuActionParams1[1 + var1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[1 + var1] = var4;
               var0 = false;
            }
         }
      }

      if(null == class180.field2965) {
         if(Client.field494 == null) {
            int var8;
            int var10;
            int var11;
            int var15;
            label315: {
               int var13 = class143.field2198;
               int var6;
               if(Client.isMenuOpen) {
                  if(var13 != 1 && (class134.field2117 || var13 != 4)) {
                     var1 = class143.field2204;
                     var10 = class143.field2210;
                     if(var1 < class92.menuX - 10 || var1 > 10 + class92.menuX + class109.menuWidth || var10 < class85.menuY - 10 || var10 > 10 + class138.menuHeight + class85.menuY) {
                        Client.isMenuOpen = false;
                        class124.method2815(class92.menuX, class85.menuY, class109.menuWidth, class138.menuHeight);
                     }
                  }

                  if(var13 == 1 || !class134.field2117 && var13 == 4) {
                     var1 = class92.menuX;
                     var10 = class85.menuY;
                     var11 = class109.menuWidth;
                     var4 = class143.field2211;
                     int var14 = class143.field2213;
                     var6 = -1;

                     for(var15 = 0; var15 < Client.menuOptionCount; ++var15) {
                        var8 = 31 + var10 + (Client.menuOptionCount - 1 - var15) * 15;
                        if(var4 > var1 && var4 < var1 + var11 && var14 > var8 - 13 && var14 < 3 + var8) {
                           var6 = var15;
                        }
                     }

                     if(var6 != -1) {
                        Sequence.method897(var6);
                     }

                     Client.isMenuOpen = false;
                     class124.method2815(class92.menuX, class85.menuY, class109.menuWidth, class138.menuHeight);
                  }
               } else {
                  if((var13 == 1 || !class134.field2117 && var13 == 4) && Client.menuOptionCount > 0) {
                     var1 = Client.menuTypes[Client.menuOptionCount - 1];
                     if(var1 == 39 || var1 == 40 || var1 == 41 || var1 == 42 || var1 == 43 || var1 == 33 || var1 == 34 || var1 == 35 || var1 == 36 || var1 == 37 || var1 == 38 || var1 == 1005) {
                        var10 = Client.menuActionParams0[Client.menuOptionCount - 1];
                        var11 = Client.menuActionParams1[Client.menuOptionCount - 1];
                        Widget var12 = World.method628(var11);
                        var6 = class132.method2880(var12);
                        boolean var5 = (var6 >> 28 & 1) != 0;
                        if(var5) {
                           break label315;
                        }

                        var8 = class132.method2880(var12);
                        boolean var7 = (var8 >> 29 & 1) != 0;
                        if(var7) {
                           break label315;
                        }
                     }
                  }

                  if((var13 == 1 || !class134.field2117 && var13 == 4) && (Client.field508 == 1 && Client.menuOptionCount > 2 || class38.method738(Client.menuOptionCount - 1))) {
                     var13 = 2;
                  }

                  if((var13 == 1 || !class134.field2117 && var13 == 4) && Client.menuOptionCount > 0) {
                     Sequence.method897(Client.menuOptionCount - 1);
                  }

                  if(var13 == 2 && Client.menuOptionCount > 0) {
                     BufferProvider.method1725(class143.field2211, class143.field2213);
                  }
               }

               return;
            }

            if(class180.field2965 != null && !Client.field399 && Client.field508 != 1 && !class38.method738(Client.menuOptionCount - 1) && Client.menuOptionCount > 0) {
               var15 = Client.field470;
               var8 = Client.field397;
               class32 var9 = class59.field1242;
               class143.menuAction(var9.field715, var9.field713, var9.field714, var9.field717, var9.field716, var9.field716, var15, var8);
               class59.field1242 = null;
            }

            Client.field399 = false;
            Client.field400 = 0;
            if(class180.field2965 != null) {
               class75.method1606(class180.field2965);
            }

            class180.field2965 = World.method628(var11);
            Client.field395 = var10;
            Client.field470 = class143.field2211;
            Client.field397 = class143.field2213;
            if(Client.menuOptionCount > 0) {
               SecondaryBufferProvider.method1667(Client.menuOptionCount - 1);
            }

            class75.method1606(class180.field2965);
         }
      }
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1222504219"
   )
   static void method49(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class54.field1142; ++var4) {
         ItemComposition var8 = MessageNode.getItemDefinition(var4);
         if((!var1 || var8.field1202) && var8.field1195 == -1 && var8.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class20.field566 = -1;
               class92.field1611 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[2 * var2.length];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class92.field1611 = var2;
      DecorativeObject.field1666 = 0;
      class20.field566 = var3;
      String[] var9 = new String[class20.field566];

      for(int var5 = 0; var5 < class20.field566; ++var5) {
         var9[var5] = MessageNode.getItemDefinition(var2[var5]).name;
      }

      SecondaryBufferProvider.method1671(var9, class92.field1611);
   }
}
