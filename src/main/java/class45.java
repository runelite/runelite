import java.awt.Canvas;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class45 extends class203 {
   @ObfuscatedName("r")
   public static class192 field1038 = new class192(64);
   @ObfuscatedName("f")
   public boolean field1040 = false;
   @ObfuscatedName("qd")
   public static Canvas field1042;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1616371093
   )
   static int field1043;
   @ObfuscatedName("a")
   public static class166 field1046;

   @ObfuscatedName("s")
   static final boolean method956(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      class118 var4 = new class118(var0);
      int var5 = -1;

      label83:
      while(true) {
         int var6 = var4.method2659();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method2659();
               if(0 == var9) {
                  continue label83;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.method2579() >> 2;
               int var13 = var1 + var11;
               int var14 = var2 + var10;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  class40 var15 = class156.method3176(var5);
                  if(var12 != 22 || !client.field297 || 0 != var15.field942 || 1 == var15.field925 || var15.field961) {
                     if(!var15.method810()) {
                        ++client.field349;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method2659();
            if(var9 == 0) {
               break;
            }

            var4.method2579();
         }
      }
   }

   @ObfuscatedName("a")
   public void method957(class118 var1) {
      while(true) {
         int var2 = var1.method2579();
         if(0 == var2) {
            return;
         }

         this.method958(var2);
      }
   }

   @ObfuscatedName("r")
   void method958(int var1) {
      if(var1 == 2) {
         this.field1040 = true;
      }

   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "102"
   )
   static final void method959(int var0) {
      class46.method990();
      class9.method136();
      int var1 = class5.method101(var0).field1159;
      if(0 != var1) {
         int var2 = class175.field2890[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class90.method2107(0.9D);
               ((class94)class90.field1574).method2185(0.9D);
            }

            if(2 == var2) {
               class90.method2107(0.8D);
               ((class94)class90.field1574).method2185(0.8D);
            }

            if(var2 == 3) {
               class90.method2107(0.7D);
               ((class94)class90.field1574).method2185(0.7D);
            }

            if(4 == var2) {
               class90.method2107(0.6D);
               ((class94)class90.field1574).method2185(0.6D);
            }

            method962();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(2 == var2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(4 == var2) {
               var3 = 0;
            }

            if(client.field531 != var3) {
               if(0 == client.field531 && client.field532 != -1) {
                  class86.method2097(class129.field2054, client.field532, 0, var3, false);
                  client.field533 = false;
               } else if(var3 == 0) {
                  class182.field2942.method3628();
                  class182.field2947 = 1;
                  class182.field2946 = null;
                  client.field533 = false;
               } else {
                  class23.method583(var3);
               }

               client.field531 = var3;
            }
         }

         if(4 == var1) {
            if(var2 == 0) {
               client.field534 = 127;
            }

            if(var2 == 1) {
               client.field534 = 96;
            }

            if(2 == var2) {
               client.field534 = 64;
            }

            if(3 == var2) {
               client.field534 = 32;
            }

            if(4 == var2) {
               client.field534 = 0;
            }
         }

         if(5 == var1) {
            client.field433 = var2;
         }

         if(6 == var1) {
            client.field455 = var2;
         }

         if(9 == var1) {
            client.field456 = var2;
         }

         if(10 == var1) {
            if(var2 == 0) {
               client.field535 = 127;
            }

            if(var2 == 1) {
               client.field535 = 96;
            }

            if(var2 == 2) {
               client.field535 = 64;
            }

            if(3 == var2) {
               client.field535 = 32;
            }

            if(4 == var2) {
               client.field535 = 0;
            }
         }

         if(var1 == 17) {
            client.field461 = var2 & '\uffff';
         }

         class20[] var4;
         if(var1 == 18) {
            var4 = new class20[]{class20.field580, class20.field589, class20.field583, class20.field581};
            client.field319 = (class20)class155.method3174(var4, var2);
            if(null == client.field319) {
               client.field319 = class20.field583;
            }
         }

         if(var1 == 19) {
            if(-1 == var2) {
               client.field521 = -1;
            } else {
               client.field521 = var2 & 2047;
            }
         }

         if(22 == var1) {
            var4 = new class20[]{class20.field580, class20.field589, class20.field583, class20.field581};
            client.field332 = (class20)class155.method3174(var4, var2);
            if(null == client.field332) {
               client.field332 = class20.field583;
            }
         }

      }
   }

   @ObfuscatedName("u")
   public static void method962() {
      class51.field1155.method3800();
   }

   @ObfuscatedName("b")
   static final boolean method963(int var0, int var1) {
      class40 var2 = class156.method3176(var0);
      if(11 == var1) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method831(var1);
   }
}
