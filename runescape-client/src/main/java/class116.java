import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public class class116 {
   @ObfuscatedName("r")
   int[] field2018;
   @ObfuscatedName("l")
   int[] field2019;
   @ObfuscatedName("g")
   byte[] field2020;

   public class116(byte[] var1) {
      int var2 = var1.length;
      this.field2019 = new int[var2];
      this.field2020 = var1;
      int[] var3 = new int[33];
      this.field2018 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field2019[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if((var8 & var7) != 0) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if(var11 != var8) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if((var11 & var12) != 0) {
                     var3[var10] = var3[var10 - 1];
                     break;
                  }

                  var3[var10] = var11 | var12;
               }
            }

            var3[var6] = var9;

            for(var10 = 1 + var6; var10 <= 32; ++var10) {
               if(var8 == var3[var10]) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(this.field2018[var10] == 0) {
                     this.field2018[var10] = var4;
                  }

                  var10 = this.field2018[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field2018.length) {
                  int[] var13 = new int[this.field2018.length * 2];

                  for(int var14 = 0; var14 < this.field2018.length; ++var14) {
                     var13[var14] = this.field2018[var14];
                  }

                  this.field2018 = var13;
               }

               var12 >>>= 1;
            }

            this.field2018[var10] = ~var5;
            if(var10 >= var4) {
               var4 = 1 + var10;
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BII[BII)I",
      garbageValue = "-1983086599"
   )
   public int method2550(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field2019[var8];
         byte var10 = this.field2020[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = var11 + (var12 + var10 - 1 >> 3);
         var12 += 24;
         var4[var11] = (byte)(var6 |= var9 >>> var12);
         if(var11 < var13) {
            ++var11;
            var12 -= 8;
            var4[var11] = (byte)(var6 = var9 >>> var12);
            if(var11 < var13) {
               ++var11;
               var12 -= 8;
               var4[var11] = (byte)(var6 = var9 >>> var12);
               if(var11 < var13) {
                  ++var11;
                  var12 -= 8;
                  var4[var11] = (byte)(var6 = var9 >>> var12);
                  if(var11 < var13) {
                     ++var11;
                     var12 -= 8;
                     var4[var11] = (byte)(var6 = var9 << -var12);
                  }
               }
            }
         }

         var7 += var10;
      }

      return (var7 + 7 >> 3) - var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-869289981"
   )
   static void method2552(int var0, int var1, int var2, int var3) {
      for(class24 var4 = (class24)class24.field630.method3980(); null != var4; var4 = (class24)class24.field630.method3970()) {
         if(var4.field627 != -1 || null != var4.field629) {
            int var5 = 0;
            if(var1 > var4.field624) {
               var5 += var1 - var4.field624;
            } else if(var1 < var4.field635) {
               var5 += var4.field635 - var1;
            }

            if(var2 > var4.field628) {
               var5 += var2 - var4.field628;
            } else if(var2 < var4.field623) {
               var5 += var4.field623 - var2;
            }

            if(var5 - 64 <= var4.field626 && client.field535 != 0 && var4.field621 == var0) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = client.field535 * (var4.field626 - var5) / var4.field626;
               if(null == var4.field622) {
                  if(var4.field627 >= 0) {
                     class61 var7 = class61.method1380(class119.field2039, var4.field627, 0);
                     if(var7 != null) {
                        class65 var8 = var7.method1369().method1407(class79.field1463);
                        class67 var9 = class67.method1427(var8, 100, var6);
                        var9.method1430(-1);
                        class20.field585.method1251(var9);
                        var4.field622 = var9;
                     }
                  }
               } else {
                  var4.field622.method1466(var6);
               }

               if(null == var4.field633) {
                  if(null != var4.field629 && (var4.field632 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field629.length);
                     class61 var12 = class61.method1380(class119.field2039, var4.field629[var11], 0);
                     if(var12 != null) {
                        class65 var13 = var12.method1369().method1407(class79.field1463);
                        class67 var10 = class67.method1427(var13, 100, var6);
                        var10.method1430(0);
                        class20.field585.method1251(var10);
                        var4.field633 = var10;
                        var4.field632 = var4.field631 + (int)(Math.random() * (double)(var4.field625 - var4.field631));
                     }
                  }
               } else {
                  var4.field633.method1466(var6);
                  if(!var4.field633.method4068()) {
                     var4.field633 = null;
                  }
               }
            } else {
               if(var4.field622 != null) {
                  class20.field585.method1285(var4.field622);
                  var4.field622 = null;
               }

               if(var4.field633 != null) {
                  class20.field585.method1285(var4.field633);
                  var4.field633 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass171;II)V",
      garbageValue = "-1057820468"
   )
   static void method2555(class171 var0, int var1) {
      if(null != class156.field2338) {
         class156.field2338.field2050 = var1 * 8 + 5;
         int var2 = class156.field2338.method2620();
         int var3 = class156.field2338.method2620();
         var0.method3487(var2, var3);
      } else {
         class126.method2919((class171)null, 255, 255, 0, (byte)0, true);
         class174.field2786[var1] = var0;
      }
   }

   @ObfuscatedName("qy")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/awt/Color;ZI)V",
      garbageValue = "1017952319"
   )
   protected static final void method2556(int var0, String var1, Color var2, boolean var3) {
      try {
         Graphics var4 = class107.field1867.getGraphics();
         if(class1.field18 == null) {
            class1.field18 = new Font("Helvetica", 1, 13);
            class20.field584 = class107.field1867.getFontMetrics(class1.field18);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class189.field3056, class39.field892);
         }

         if(null == var2) {
            var2 = new Color(140, 17, 17);
         }

         try {
            if(null == class137.field2129) {
               class137.field2129 = class107.field1867.createImage(304, 34);
            }

            Graphics var5 = class137.field2129.getGraphics();
            var5.setColor(var2);
            var5.drawRect(0, 0, 303, 33);
            var5.fillRect(2, 2, var0 * 3, 30);
            var5.setColor(Color.black);
            var5.drawRect(1, 1, 301, 31);
            var5.fillRect(2 + var0 * 3, 2, 300 - var0 * 3, 30);
            var5.setFont(class1.field18);
            var5.setColor(Color.white);
            var5.drawString(var1, (304 - class20.field584.stringWidth(var1)) / 2, 22);
            var4.drawImage(class137.field2129, class189.field3056 / 2 - 152, class39.field892 / 2 - 18, (ImageObserver)null);
         } catch (Exception var8) {
            int var6 = class189.field3056 / 2 - 152;
            int var7 = class39.field892 / 2 - 18;
            var4.setColor(var2);
            var4.drawRect(var6, var7, 303, 33);
            var4.fillRect(2 + var6, 2 + var7, 3 * var0, 30);
            var4.setColor(Color.black);
            var4.drawRect(var6 + 1, 1 + var7, 301, 31);
            var4.fillRect(3 * var0 + 2 + var6, 2 + var7, 300 - 3 * var0, 30);
            var4.setFont(class1.field18);
            var4.setColor(Color.white);
            var4.drawString(var1, var6 + (304 - class20.field584.stringWidth(var1)) / 2, 22 + var7);
         }
      } catch (Exception var9) {
         class107.field1867.repaint();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI[BIIB)I",
      garbageValue = "-1"
   )
   public int method2558(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field2018[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field2018[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field2018[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2018[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field2018[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2018[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field2018[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2018[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field2018[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2018[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field2018[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2018[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field2018[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2018[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field2018[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2018[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return var7 + 1 - var2;
      }
   }
}
