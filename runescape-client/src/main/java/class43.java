import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class43 extends class204 {
   @ObfuscatedName("s")
   public static class167 field1002;
   @ObfuscatedName("j")
   public static class167 field1003;
   @ObfuscatedName("x")
   static class193 field1005 = new class193(30);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 876863089
   )
   int field1006 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 203975987
   )
   int field1007;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1128529487
   )
   public int field1008 = -1;
   @ObfuscatedName("b")
   short[] field1009;
   @ObfuscatedName("k")
   short[] field1010;
   @ObfuscatedName("c")
   short[] field1011;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2082231151
   )
   int field1012 = 128;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -447829635
   )
   int field1013 = 128;
   @ObfuscatedName("l")
   short[] field1014;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -733971701
   )
   int field1015;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 226644811
   )
   int field1016 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1151588445
   )
   int field1017 = 0;
   @ObfuscatedName("ad")
   static int[] field1018;
   @ObfuscatedName("p")
   static class193 field1019 = new class193(64);
   @ObfuscatedName("qw")
   static class133 field1020;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "94"
   )
   public static void method877() {
      class41.field976.method3750();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "-35"
   )
   void method878(class119 var1, int var2) {
      if(1 == var2) {
         this.field1007 = var1.method2584();
      } else if(2 == var2) {
         this.field1008 = var1.method2584();
      } else if(var2 == 4) {
         this.field1013 = var1.method2584();
      } else if(var2 == 5) {
         this.field1012 = var1.method2584();
      } else if(6 == var2) {
         this.field1017 = var1.method2584();
      } else if(var2 == 7) {
         this.field1016 = var1.method2492();
      } else if(var2 == 8) {
         this.field1006 = var1.method2492();
      } else {
         int var3;
         int var4;
         if(40 == var2) {
            var3 = var1.method2492();
            this.field1009 = new short[var3];
            this.field1010 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1009[var4] = (short)var1.method2584();
               this.field1010[var4] = (short)var1.method2584();
            }
         } else if(41 == var2) {
            var3 = var1.method2492();
            this.field1011 = new short[var3];
            this.field1014 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1011[var4] = (short)var1.method2584();
               this.field1014[var4] = (short)var1.method2584();
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Lclass105;",
      garbageValue = "141673441"
   )
   public final class105 method879(int var1) {
      class105 var2 = (class105)field1005.method3743((long)this.field1015);
      if(null == var2) {
         class100 var3 = class100.method2181(field1003, this.field1007, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(this.field1009 != null) {
            for(var4 = 0; var4 < this.field1009.length; ++var4) {
               var3.method2194(this.field1009[var4], this.field1010[var4]);
            }
         }

         if(this.field1011 != null) {
            for(var4 = 0; var4 < this.field1011.length; ++var4) {
               var3.method2195(this.field1011[var4], this.field1014[var4]);
            }
         }

         var2 = var3.method2202(this.field1016 + 64, this.field1006 + 850, -30, -50, -30);
         field1005.method3745(var2, (long)this.field1015);
      }

      class105 var5;
      if(this.field1008 != -1 && var1 != -1) {
         var5 = class4.method42(this.field1008).method843(var2, var1);
      } else {
         var5 = var2.method2285(true);
      }

      if(this.field1013 != 128 || this.field1012 != 128) {
         var5.method2301(this.field1013, this.field1012, this.field1013);
      }

      if(0 != this.field1017) {
         if(this.field1017 == 90) {
            var5.method2293();
         }

         if(this.field1017 == 180) {
            var5.method2293();
            var5.method2293();
         }

         if(this.field1017 == 270) {
            var5.method2293();
            var5.method2293();
            var5.method2293();
         }
      }

      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;IIIIIII)V",
      garbageValue = "1469333322"
   )
   static final void method890(class119 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.field90[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2492();
            if(var7 == 0) {
               if(0 == var1) {
                  int[] var12 = class5.field93[0][var2];
                  int var9 = 932731 + var2 + var4;
                  int var10 = 556238 + var3 + var5;
                  int var11 = class42.method875(var9 + '넵', 91923 + var10, 4) - 128 + (class42.method875(var9 + 10294, var10 + '鎽', 2) - 128 >> 1) + (class42.method875(var9, var10, 1) - 128 >> 2);
                  var11 = 35 + (int)((double)var11 * 0.3D);
                  if(var11 < 10) {
                     var11 = 10;
                  } else if(var11 > 60) {
                     var11 = 60;
                  }

                  var12[var3] = -var11 * 8;
               } else {
                  class5.field93[var1][var2][var3] = class5.field93[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.method2492();
               if(1 == var8) {
                  var8 = 0;
               }

               if(0 == var1) {
                  class5.field93[0][var2][var3] = -var8 * 8;
               } else {
                  class5.field93[var1][var2][var3] = class5.field93[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class5.field86[var1][var2][var3] = var0.method2493();
               class175.field2912[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class102.field1774[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class5.field90[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class5.field94[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2492();
            if(0 == var7) {
               break;
            }

            if(1 == var7) {
               var0.method2492();
               break;
            }

            if(var7 <= 49) {
               var0.method2492();
            }
         }
      }

   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)Z",
      garbageValue = "-1298879049"
   )
   static final boolean method891(class173 var0) {
      int var1 = var0.field2887;
      if(205 == var1) {
         client.field332 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            client.field350.method3458(var2, 1 == var3);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            client.field350.method3466(var2, 1 == var3);
         }

         if(324 == var1) {
            client.field350.method3460(false);
         }

         if(325 == var1) {
            client.field350.method3460(true);
         }

         if(326 == var1) {
            client.field322.method2737(7);
            client.field350.method3479(client.field322);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1915211205"
   )
   public static void method892() {
      while(true) {
         class199 var0 = class170.field2722;
         class199 var2 = class170.field2722;
         class169 var1;
         synchronized(class170.field2722) {
            var1 = (class169)class170.field2720.method3810();
         }

         if(var1 == null) {
            return;
         }

         var1.field2716.method3333(var1.field2713, (int)var1.field3125, var1.field2714, false);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "21"
   )
   void method894(class119 var1) {
      while(true) {
         int var2 = var1.method2492();
         if(var2 == 0) {
            return;
         }

         this.method878(var1, var2);
      }
   }
}
