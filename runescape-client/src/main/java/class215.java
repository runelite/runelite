import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class215 {
   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "0"
   )
   @Export("xteaChanged")
   static final void method3894(boolean var0) {
      client.field345 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!client.field345) {
         var1 = client.field327.method2504();
         var2 = client.field327.method2646();
         var3 = client.field327.method2470();
         class32.field746 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class32.field746[var4][var5] = client.field327.method2505();
            }
         }

         class165.field2691 = new int[var3];
         class98.field1684 = new int[var3];
         client.field343 = new int[var3];
         class115.field1980 = new byte[var3][];
         class22.field587 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (6 + var2) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class165.field2691[var3] = var7;
                  class98.field1684[var3] = class19.field272.method3236("m" + var5 + "_" + var6);
                  client.field343[var3] = class19.field272.method3236("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class42.method852(var1, var2);
      } else {
         var1 = client.field327.method2545();
         var2 = client.field327.method2470();
         var3 = client.field327.method2470();
         client.field327.method2726();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field327.method2713(1);
                  if(var7 == 1) {
                     client.field346[var4][var5][var6] = client.field327.method2713(26);
                  } else {
                     client.field346[var4][var5][var6] = -1;
                  }
               }
            }
         }

         client.field327.method2714();
         class32.field746 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class32.field746[var4][var5] = client.field327.method2505();
            }
         }

         class165.field2691 = new int[var3];
         class98.field1684 = new int[var3];
         client.field343 = new int[var3];
         class115.field1980 = new byte[var3][];
         class22.field587 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field346[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(var10 == class165.field2691[var11]) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class165.field2691[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class98.field1684[var3] = class19.field272.method3236("m" + var11 + "_" + var12);
                        client.field343[var3] = class19.field272.method3236("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class42.method852(var1, var2);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1965360213"
   )
   public static void method3895() {
      class47.field1072.method3717();
   }
}
