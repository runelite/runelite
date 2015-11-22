package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("r")
public class class15 extends class207 {
   @ObfuscatedName("nl")
   static class56 field212;
   @ObfuscatedName("f")
   int[] field214 = new int[]{0};
   @ObfuscatedName("j")
   static class195 field216 = new class195(32);
   @ObfuscatedName("m")
   int[] field217 = new int[]{-1};
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 884510855
   )
   static int field219;

   @ObfuscatedName("ca")
   static void method194(class172 var0) {
      class172 var1 = var0.field2742 == -1?null:class48.method1036(var0.field2742);
      int var2;
      int var3;
      if(var1 == null) {
         var2 = class129.field2048;
         var3 = class136.field2101;
      } else {
         var2 = var1.field2749;
         var3 = var1.field2750;
      }

      class49.method1044(var0, var2, var3, false);
      class13.method192(var0, var2, var3);
   }

   @ObfuscatedName("a")
   static final void method195(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class5.field79[var0][var1 + var3][var2 + var4] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class5.field79[var0][var1][var2 + var3] = class5.field79[var0][var1 - 1][var2 + var3];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class5.field79[var0][var3 + var1][var2] = class5.field79[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && 0 != class5.field79[var0][var1 - 1][var2]) {
         class5.field79[var0][var1][var2] = class5.field79[var0][var1 - 1][var2];
      } else if(var2 > 0 && class5.field79[var0][var1][var2 - 1] != 0) {
         class5.field79[var0][var1][var2] = class5.field79[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class5.field79[var0][var1 - 1][var2 - 1] != 0) {
         class5.field79[var0][var1][var2] = class5.field79[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("cd")
   static final void method198(int var0, int var1) {
      if(class167.method3400(var0)) {
         class12.method186(class172.field2857[var0], var1);
      }
   }

   @ObfuscatedName("cp")
   static String method203(String var0, class172 var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = client.method586(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var7 = "";
            if(class4.field68 != null) {
               var7 = class118.method2738(class4.field68.field2202);
               if(class4.field68.field2204 != null) {
                  var7 = (String)class4.field68.field2204;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(4 + var2);
         }
      }

      return var0;
   }

   @ObfuscatedName("l")
   static void method205() {
      field216 = new class195(32);
   }

   @ObfuscatedName("bt")
   static final void method207(int var0) {
      if(var0 >= 0) {
         int var1 = client.field417[var0];
         int var2 = client.field418[var0];
         int var3 = client.field419[var0];
         int var4 = client.field415[var0];
         String var10000 = client.field297[var0];
         String var6 = client.field422[var0];
         class136.method2961(var1, var2, var3, var4, var6, class139.field2130, class139.field2142);
      }
   }

   @ObfuscatedName("i")
   static final void method208(class80 var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class139.field2144.length; ++var2) {
         class139.field2144[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class139.field2144[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class176.field2894[var5] = (class139.field2144[var5 - 128] + class139.field2144[var5 - 1] + class139.field2144[1 + var5] + class139.field2144[var5 + 128]) / 4;
            }
         }

         int[] var8 = class139.field2144;
         class139.field2144 = class176.field2894;
         class176.field2894 = var8;
      }

      if(null != var0) {
         var2 = 0;

         for(var3 = 0; var3 < var0.field1410; ++var3) {
            for(var4 = 0; var4 < var0.field1407; ++var4) {
               if(var0.field1408[var2++] != 0) {
                  var5 = var0.field1411 + var4 + 16;
                  int var6 = var0.field1409 + var3 + 16;
                  int var7 = var5 + (var6 << 7);
                  class139.field2144[var7] = 0;
               }
            }
         }
      }

   }
}
