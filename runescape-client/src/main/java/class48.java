import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class48 extends class204 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 987743573
   )
   public int field1057;
   @ObfuscatedName("c")
   public int[] field1058;
   @ObfuscatedName("m")
   public char field1059;
   @ObfuscatedName("z")
   public char field1060;
   @ObfuscatedName("h")
   public static class193 field1062 = new class193(64);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -273622315
   )
   public int field1063 = 0;
   @ObfuscatedName("x")
   public String field1064 = "null";
   @ObfuscatedName("n")
   public int[] field1065;
   @ObfuscatedName("l")
   public String[] field1066;
   @ObfuscatedName("j")
   public static class167 field1067;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "14"
   )
   public void method984(class119 var1) {
      while(true) {
         int var2 = var1.method2500();
         if(0 == var2) {
            return;
         }

         this.method985(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-191659026"
   )
   void method985(class119 var1, int var2) {
      if(1 == var2) {
         this.field1059 = (char)var1.method2500();
      } else if(var2 == 2) {
         this.field1060 = (char)var1.method2500();
      } else if(var2 == 3) {
         this.field1064 = var1.method2508();
      } else if(var2 == 4) {
         this.field1057 = var1.method2505();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1063 = var1.method2502();
            this.field1058 = new int[this.field1063];
            this.field1066 = new String[this.field1063];

            for(var3 = 0; var3 < this.field1063; ++var3) {
               this.field1058[var3] = var1.method2505();
               this.field1066[var3] = var1.method2508();
            }
         } else if(var2 == 6) {
            this.field1063 = var1.method2502();
            this.field1058 = new int[this.field1063];
            this.field1065 = new int[this.field1063];

            for(var3 = 0; var3 < this.field1063; ++var3) {
               this.field1058[var3] = var1.method2505();
               this.field1065[var3] = var1.method2505();
            }
         }
      }

   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1340382994"
   )
   static final void method989(int var0) {
      class18.method196();
      class115.method2440();
      int var1 = class176.method3415(var0).field1144;
      if(var1 != 0) {
         int var2 = class176.field2900[var0];
         if(var1 == 1) {
            if(1 == var2) {
               class91.method2097(0.9D);
               ((class95)class91.field1566).method2169(0.9D);
            }

            if(var2 == 2) {
               class91.method2097(0.8D);
               ((class95)class91.field1566).method2169(0.8D);
            }

            if(var2 == 3) {
               class91.method2097(0.7D);
               ((class95)class91.field1566).method2169(0.7D);
            }

            if(var2 == 4) {
               class91.method2097(0.6D);
               ((class95)class91.field1566).method2169(0.6D);
            }

            class179.method3445();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(0 == var2) {
               var3 = 255;
            }

            if(1 == var2) {
               var3 = 192;
            }

            if(2 == var2) {
               var3 = 128;
            }

            if(3 == var2) {
               var3 = 64;
            }

            if(4 == var2) {
               var3 = 0;
            }

            if(client.field409 != var3) {
               if(client.field409 == 0 && -1 != client.field532) {
                  class126.method2783(class135.field2069, client.field532, 0, var3, false);
                  client.field512 = false;
               } else if(var3 == 0) {
                  class168.method3332();
                  client.field512 = false;
               } else {
                  class40.method824(var3);
               }

               client.field409 = var3;
            }
         }

         if(var1 == 4) {
            if(0 == var2) {
               client.field513 = 127;
            }

            if(var2 == 1) {
               client.field513 = 96;
            }

            if(var2 == 2) {
               client.field513 = 64;
            }

            if(var2 == 3) {
               client.field513 = 32;
            }

            if(4 == var2) {
               client.field513 = 0;
            }
         }

         if(var1 == 5) {
            client.field327 = var2;
         }

         if(var1 == 6) {
            client.field435 = var2;
         }

         if(9 == var1) {
            client.field436 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               client.field514 = 127;
            }

            if(var2 == 1) {
               client.field514 = 96;
            }

            if(2 == var2) {
               client.field514 = 64;
            }

            if(var2 == 3) {
               client.field514 = 32;
            }

            if(4 == var2) {
               client.field514 = 0;
            }
         }

         if(var1 == 17) {
            client.field379 = var2 & '\uffff';
         }

         class20[] var4;
         if(var1 == 18) {
            var4 = new class20[]{class20.field560, class20.field565, class20.field563, class20.field559};
            client.field301 = (class20)class104.method2282(var4, var2);
            if(null == client.field301) {
               client.field301 = class20.field563;
            }
         }

         if(19 == var1) {
            if(-1 == var2) {
               client.field405 = -1;
            } else {
               client.field405 = var2 & 2047;
            }
         }

         if(22 == var1) {
            var4 = new class20[]{class20.field560, class20.field565, class20.field563, class20.field559};
            client.field335 = (class20)class104.method2282(var4, var2);
            if(client.field335 == null) {
               client.field335 = class20.field563;
            }
         }

      }
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "703901655"
   )
   static final void method993(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(client.field303 && var0 != class28.field655) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class35.field771.method2034(var0, var2, var3);
         }

         if(1 == var1) {
            var7 = class35.field771.method1932(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class35.field771.method1933(var0, var2, var3);
         }

         if(3 == var1) {
            var7 = class35.field771.method1934(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class35.field771.method2072(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            class40 var12;
            if(var1 == 0) {
               class35.field771.method1922(var0, var2, var3);
               var12 = class85.method1903(var13);
               if(0 != var12.field922) {
                  client.field482[var0].method2381(var2, var3, var14, var15, var12.field923);
               }
            }

            if(1 == var1) {
               class35.field771.method1923(var0, var2, var3);
            }

            if(var1 == 2) {
               class35.field771.method1917(var0, var2, var3);
               var12 = class85.method1903(var13);
               if(var2 + var12.field920 > 103 || var3 + var12.field920 > 103 || var2 + var12.field921 > 103 || var3 + var12.field921 > 103) {
                  return;
               }

               if(var12.field922 != 0) {
                  client.field482[var0].method2385(var2, var3, var12.field920, var12.field921, var15, var12.field923);
               }
            }

            if(var1 == 3) {
               class35.field771.method2003(var0, var2, var3);
               var12 = class85.method1903(var13);
               if(var12.field922 == 1) {
                  client.field482[var0].method2387(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && 2 == (class5.field84[1][var2][var3] & 2)) {
               var11 = var0 + 1;
            }

            class161.method3155(var0, var11, var2, var3, var4, var5, var6, class35.field771, client.field482[var0]);
         }
      }

   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)Z",
      garbageValue = "1150635803"
   )
   static final boolean method995(class173 var0) {
      if(null == var0.field2853) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2853.length; ++var1) {
            int var2 = class45.method945(var0, var1);
            int var3 = var0.field2869[var1];
            if(2 == var0.field2853[var1]) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2853[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(4 == var0.field2853[var1]) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(IIIILclass78;Lclass175;I)V",
      garbageValue = "-600550668"
   )
   static final void method996(int var0, int var1, int var2, int var3, class78 var4, class175 var5) {
      if(null != var4) {
         int var6 = client.field521 + client.field346 & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class91.field1571[var6];
            int var9 = class91.field1572[var6];
            var8 = 256 * var8 / (client.field479 + 256);
            var9 = var9 * 256 / (256 + client.field479);
            int var10 = var3 * var8 + var9 * var2 >> 16;
            int var11 = var9 * var3 - var2 * var8 >> 16;
            if(var7 > 2500) {
               var4.method1710(var5.field2890 / 2 + var10 - var4.field1387 / 2, var5.field2891 / 2 - var11 - var4.field1388 / 2, var0, var1, var5.field2890, var5.field2891, var5.field2892, var5.field2895);
            } else {
               var4.method1700(var0 + var5.field2890 / 2 + var10 - var4.field1387 / 2, var5.field2891 / 2 + var1 - var11 - var4.field1388 / 2);
            }

         }
      }
   }
}
