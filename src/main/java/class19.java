import java.awt.Graphics;
import java.io.EOFException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class19 {
   @ObfuscatedName("t")
   boolean[] field283;
   @ObfuscatedName("p")
   boolean[] field284;
   @ObfuscatedName("e")
   int[] field285;
   @ObfuscatedName("y")
   String[] field286;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 4511773820141176347L
   )
   long field288;
   @ObfuscatedName("bp")
   static class168 field289;
   @ObfuscatedName("m")
   boolean field291 = false;

   @ObfuscatedName("w")
   void method196(int var1, int var2) {
      this.field285[var1] = var2;
      if(this.field283[var1]) {
         this.field291 = true;
      }

   }

   @ObfuscatedName("x")
   int method197(int var1) {
      return this.field285[var1];
   }

   @ObfuscatedName("t")
   void method198(int var1, String var2) {
      this.field286[var1] = var2;
      if(this.field284[var1]) {
         this.field291 = true;
      }

   }

   @ObfuscatedName("y")
   class227 method201(boolean var1) {
      return class104.method2295("2", class18.field270.field2311, var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1668199812"
   )
   void method202() {
      class227 var1 = this.method201(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field285.length; ++var4) {
            if(this.field283[var4] && -1 != this.field285[var4]) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.field286.length; ++var5) {
            if(this.field284[var5] && null != this.field286[var5]) {
               var2 += 2 + class45.method992(this.field286[var5]);
               ++var4;
            }
         }

         class119 var17 = new class119(var2);
         var17.method2573(1);
         var17.method2492(var3);

         int var6;
         for(var6 = 0; var6 < this.field285.length; ++var6) {
            if(this.field283[var6] && -1 != this.field285[var6]) {
               var17.method2492(var6);
               var17.method2494(this.field285[var6]);
            }
         }

         var17.method2492(var4);

         for(var6 = 0; var6 < this.field286.length; ++var6) {
            if(this.field284[var6] && this.field286[var6] != null) {
               var17.method2492(var6);
               var17.method2661(this.field286[var6]);
            }
         }

         var1.method4143(var17.field2012, 0, var17.field2011);
      } catch (Exception var15) {
         ;
      } finally {
         try {
            var1.method4130();
         } catch (Exception var14) {
            ;
         }

      }

      this.field291 = false;
      this.field288 = class14.method165();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1432518831"
   )
   void method203() {
      class227 var1 = this.method201(false);

      label192: {
         try {
            byte[] var2 = new byte[(int)var1.method4132()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method4131(var2, var3, var2.length - var3);
               if(-1 == var4) {
                  throw new EOFException();
               }
            }

            class119 var23 = new class119(var2);
            if(var23.field2012.length - var23.field2011 >= 1) {
               int var5 = var23.method2506();
               if(var5 < 0 || var5 > 1) {
                  return;
               }

               int var6 = var23.method2508();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var23.method2508();
                  var9 = var23.method2511();
                  if(this.field283[var8]) {
                     this.field285[var8] = var9;
                  }
               }

               var7 = var23.method2508();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label192;
                  }

                  var9 = var23.method2508();
                  String var10 = var23.method2683();
                  if(this.field284[var9]) {
                     this.field286[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var21) {
            break label192;
         } finally {
            try {
               var1.method4130();
            } catch (Exception var20) {
               ;
            }

         }

         return;
      }

      this.field291 = false;
   }

   @ObfuscatedName("v")
   void method204() {
      if(this.field291 && this.field288 < class14.method165() - 60000L) {
         this.method202();
      }

   }

   @ObfuscatedName("l")
   boolean method206() {
      return this.field291;
   }

   @ObfuscatedName("q")
   static final int method209(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + var2 * (789221 + var2 * var2 * 15731) & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   class19() {
      this.field285 = new int[class46.field1076.method3330(19)];
      this.field286 = new String[class46.field1076.method3330(15)];
      this.field283 = new boolean[this.field285.length];

      int var1;
      for(var1 = 0; var1 < this.field285.length; ++var1) {
         class45 var3 = (class45)class45.field1050.method3771((long)var1);
         class45 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            byte[] var4 = class45.field1056.method3335(19, var1);
            var3 = new class45();
            if(var4 != null) {
               var3.method981(new class119(var4));
            }

            class45.field1050.method3773(var3, (long)var1);
            var2 = var3;
         }

         this.field283[var1] = var2.field1051;
      }

      this.field284 = new boolean[this.field286.length];

      for(var1 = 0; var1 < this.field286.length; ++var1) {
         class49 var5 = class21.method589(var1);
         this.field284[var1] = var5.field1102;
      }

      for(var1 = 0; var1 < this.field285.length; ++var1) {
         this.field285[var1] = -1;
      }

      this.method203();
   }

   @ObfuscatedName("p")
   String method226(int var1) {
      return this.field286[var1];
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-561651426"
   )
   static final void method228(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = var2 + 6;
      int var5 = class3.field76.method4034(var0, 250);
      int var6 = class3.field76.method4035(var0, 250) * 13;
      class79.method1800(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
      class79.method1790(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 16777215);
      class3.field76.method4066(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class29.method664(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = class87.field1537.getGraphics();
            class42.field991.vmethod1870(var7, 0, 0);
         } catch (Exception var12) {
            class87.field1537.repaint();
         }
      } else {
         int var13 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < client.field497; ++var11) {
            if(client.field361[var11] + client.field558[var11] > var13 && client.field361[var11] < var13 + var9 && client.field486[var11] + client.field505[var11] > var8 && client.field486[var11] < var10 + var8) {
               client.field500[var11] = true;
            }
         }
      }

   }

   @ObfuscatedName("v")
   public static void method229() {
      class39.field886.method3776();
      class39.field888.method3776();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2016818213"
   )
   void method230() {
      int var1;
      for(var1 = 0; var1 < this.field285.length; ++var1) {
         if(!this.field283[var1]) {
            this.field285[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.field286.length; ++var1) {
         if(!this.field284[var1]) {
            this.field286[var1] = null;
         }
      }

   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIIS)V",
      garbageValue = "128"
   )
   static final void method231(class2 var0, int var1, int var2, int var3) {
      if(class167.field2692 != var0) {
         if(client.field435 < 400) {
            String var4;
            int var7;
            if(var0.field44 == 0) {
               String var5 = var0.field42[0] + var0.field59 + var0.field42[1];
               var7 = var0.field50;
               int var8 = class167.field2692.field50;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class72.method1574(16711680);
               } else if(var9 < -6) {
                  var6 = class72.method1574(16723968);
               } else if(var9 < -3) {
                  var6 = class72.method1574(16740352);
               } else if(var9 < 0) {
                  var6 = class72.method1574(16756736);
               } else if(var9 > 9) {
                  var6 = class72.method1574('\uff00');
               } else if(var9 > 6) {
                  var6 = class72.method1574(4259584);
               } else if(var9 > 3) {
                  var6 = class72.method1574(8453888);
               } else if(var9 > 0) {
                  var6 = class72.method1574(12648192);
               } else {
                  var6 = class72.method1574(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.field50 + ")" + var0.field42[2];
            } else {
               var4 = var0.field42[0] + var0.field59 + var0.field42[1] + " " + " (" + "skill-" + var0.field44 + ")" + var0.field42[2];
            }

            int var10;
            if(client.field381 == 1) {
               class75.method1625("Use", client.field366 + " " + "->" + " " + class72.method1574(16777215) + var4, 14, var1, var2, var3);
            } else if(client.field573) {
               if(8 == (class1.field20 & 8)) {
                  class75.method1625(client.field315, client.field453 + " " + "->" + " " + class72.method1574(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(client.field421[var10] != null) {
                     short var12 = 0;
                     if(client.field421[var10].equalsIgnoreCase("Attack")) {
                        if(client.field321 == class20.field586) {
                           continue;
                        }

                        if(class20.field579 == client.field321 || client.field321 == class20.field578 && var0.field50 > class167.field2692.field50) {
                           var12 = 2000;
                        }

                        if(0 != class167.field2692.field66 && var0.field66 != 0) {
                           if(var0.field66 == class167.field2692.field66) {
                              var12 = 2000;
                           } else {
                              var12 = 0;
                           }
                        }
                     } else if(client.field422[var10]) {
                        var12 = 2000;
                     }

                     boolean var11 = false;
                     var7 = var12 + client.field420[var10];
                     class75.method1625(client.field421[var10], class72.method1574(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < client.field435; ++var10) {
               if(client.field448[var10] == 23) {
                  client.field441[var10] = class72.method1574(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
