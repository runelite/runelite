import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class36 {
   @ObfuscatedName("p")
   static final class36 field513;
   @ObfuscatedName("m")
   static final class36 field514;
   @ObfuscatedName("fd")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("mg")
   static class156 field517;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1980832421
   )
   final int field518;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2002862251"
   )
   public static final void method482() {
      class134.field2006 = false;
      class134.field2000 = 0;
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-75"
   )
   static final void method483(int var0) {
      GameEngine.method864();
      WallObject.method2762();
      int var1 = class25.method203(var0).field3295;
      if(var1 != 0) {
         int var2 = class211.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class136.method2498(0.9D);
               ((TextureProvider)class136.field2028).method2280(0.9D);
            }

            if(var2 == 2) {
               class136.method2498(0.8D);
               ((TextureProvider)class136.field2028).method2280(0.8D);
            }

            if(var2 == 3) {
               class136.method2498(0.7D);
               ((TextureProvider)class136.field2028).method2280(0.7D);
            }

            if(var2 == 4) {
               class136.method2498(0.6D);
               ((TextureProvider)class136.field2028).method2280(0.6D);
            }

            PlayerComposition.method3839();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != Client.field1141) {
               if(Client.field1141 == 0 && Client.field1142 != -1) {
                  class13.method75(FaceNormal.indexTrack1, Client.field1142, 0, var3, false);
                  Client.field1143 = false;
               } else if(var3 == 0) {
                  class203.field2516.method3579();
                  class203.field2517 = 1;
                  class203.field2518 = null;
                  Client.field1143 = false;
               } else {
                  class87.method1607(var3);
               }

               Client.field1141 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field1144 = 127;
            }

            if(var2 == 1) {
               Client.field1144 = 96;
            }

            if(var2 == 2) {
               Client.field1144 = 64;
            }

            if(var2 == 3) {
               Client.field1144 = 32;
            }

            if(var2 == 4) {
               Client.field1144 = 0;
            }
         }

         if(var1 == 5) {
            Client.field1043 = var2;
         }

         if(var1 == 6) {
            Client.field1068 = var2;
         }

         if(var1 == 9) {
            Client.field1069 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field1041 = 127;
            }

            if(var2 == 1) {
               Client.field1041 = 96;
            }

            if(var2 == 2) {
               Client.field1041 = 64;
            }

            if(var2 == 3) {
               Client.field1041 = 32;
            }

            if(var2 == 4) {
               Client.field1041 = 0;
            }
         }

         if(var1 == 17) {
            Client.field948 = var2 & '\uffff';
         }

         class91[] var4;
         if(var1 == 18) {
            var4 = new class91[]{class91.field1405, class91.field1404, class91.field1403, class91.field1410};
            Client.field928 = (class91)RSCanvas.method735(var4, var2);
            if(Client.field928 == null) {
               Client.field928 = class91.field1404;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field1035 = -1;
            } else {
               Client.field1035 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            var4 = new class91[]{class91.field1405, class91.field1404, class91.field1403, class91.field1410};
            Client.field910 = (class91)RSCanvas.method735(var4, var2);
            if(Client.field910 == null) {
               Client.field910 = class91.field1404;
            }
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class36(int var1) {
      this.field518 = var1;
   }

   static {
      field513 = new class36(0);
      field514 = new class36(1);
   }
}
