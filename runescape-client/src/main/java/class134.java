import java.awt.Component;
import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public abstract class class134 {
   @ObfuscatedName("l")
   public static File field2118;
   @ObfuscatedName("rd")
   protected static String field2119;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1961984002"
   )
   static void method2945() {
      client.field336.field2061 = 0;
      client.field338.field2061 = 0;
      client.field549 = -1;
      client.field343 = -1;
      client.field434 = -1;
      client.field345 = -1;
      client.field532 = 0;
      client.field442 = 0;
      client.field310 = 0;
      client.field435 = 0;
      client.field540 = false;
      client.field531 = 0;
      client.field529 = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         client.field467[var0] = null;
      }

      class118.field2035 = null;

      for(var0 = 0; var0 < client.field331.length; ++var0) {
         class36 var1 = client.field331[var0];
         if(var1 != null) {
            var1.field876 = -1;
            var1.field877 = false;
         }
      }

      class6.method92();
      class92.method2179(30);

      for(var0 = 0; var0 < 100; ++var0) {
         client.field500[var0] = true;
      }

      class87.method1995();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1788553424"
   )
   public abstract void vmethod3202(Component var1);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1934603405"
   )
   public abstract int vmethod3197();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1988147428"
   )
   public static void method2958() {
      if(class143.field2194 != null) {
         class143 var0 = class143.field2194;
         synchronized(class143.field2194) {
            class143.field2194 = null;
         }
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-760063908"
   )
   static final void method2959(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = client.field396 + (client.field550 - client.field396) * var5 / 100;
      int var7 = 512 * var3 * var6 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < client.field471) {
         var15 = client.field471;
         var6 = 334 * var15 * var2 / (512 * var3);
         if(var6 > client.field458) {
            var6 = client.field458;
            var8 = var6 * var3 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               class82.method1882();
               class82.method1911(var0, var1, var9, var3, -16777216);
               class82.method1911(var2 + var0 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= 2 * var9;
         }
      } else if(var7 > client.field556) {
         var15 = client.field556;
         var6 = var2 * var15 * 334 / (var3 * 512);
         if(var6 < client.field349) {
            var6 = client.field349;
            var8 = 334 * var2 * var15 / (512 * var6);
            var9 = (var3 - var8) / 2;
            if(var4) {
               class82.method1882();
               class82.method1911(var0, var1, var2, var9, -16777216);
               class82.method1911(var0, var1 + var3 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= 2 * var9;
         }
      }

      var8 = client.field551 + var5 * (client.field552 - client.field551) / 100;
      client.field561 = var6 * var3 * var8 / 85504 << 1;
      if(var2 != client.field559 || var3 != client.field562) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 15 + 32 * var10 + 128;
            int var12 = 600 + var11 * 3;
            int var13 = class94.field1655[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         class89.method2065(var14, 500, 800, var2, var3);
      }

      client.field557 = var0;
      client.field572 = var1;
      client.field559 = var2;
      client.field562 = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;ZLclass227;B)V",
      garbageValue = "119"
   )
   public static void method2960(class170 var0, class170 var1, boolean var2, class227 var3) {
      class55.field1174 = var0;
      class55.field1175 = var1;
      class30.field721 = var2;
      class55.field1176 = class55.field1174.method3352(10);
      class55.field1219 = var3;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1330727811"
   )
   @Export("xteaChanged")
   static final void method2961(boolean var0) {
      client.field355 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!client.field355) {
         var1 = client.field338.method2647();
         var2 = client.field338.method2646();
         var3 = client.field338.method2612();
         class151.field2272 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class151.field2272[var4][var5] = client.field338.method2614();
            }
         }

         class93.field1629 = new int[var3];
         class77.field1440 = new int[var3];
         class24.field643 = new int[var3];
         client.field353 = new byte[var3][];
         class96.field1662 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (6 + var1) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (6 + var2) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class93.field1629[var3] = var7;
                  class77.field1440[var3] = class4.field68.method3342("m" + var5 + "_" + var6);
                  class24.field643[var3] = class4.field68.method3342("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class165.method3280(var1, var2);
      } else {
         var1 = client.field338.method2647();
         var2 = client.field338.method2646();
         var3 = client.field338.method2612();
         client.field338.method2878();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field338.method2859(1);
                  if(var7 == 1) {
                     client.field356[var4][var5][var6] = client.field338.method2859(26);
                  } else {
                     client.field356[var4][var5][var6] = -1;
                  }
               }
            }
         }

         client.field338.method2860();
         class151.field2272 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class151.field2272[var4][var5] = client.field338.method2614();
            }
         }

         class93.field1629 = new int[var3];
         class77.field1440 = new int[var3];
         class24.field643 = new int[var3];
         client.field353 = new byte[var3][];
         class96.field1662 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field356[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = var9 / 8 + (var8 / 8 << 8);

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(class93.field1629[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class93.field1629[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class77.field1440[var3] = class4.field68.method3342("m" + var11 + "_" + var12);
                        class24.field643[var3] = class4.field68.method3342("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class165.method3280(var2, var1);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "2058912018"
   )
   public abstract void vmethod3196(Component var1);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIB)I",
      garbageValue = "73"
   )
   static final int method2963(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class94.field1653[1024 * var2 / var3] >> 1;
      return (var1 * var4 >> 16) + ((65536 - var4) * var0 >> 16);
   }
}
