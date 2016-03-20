import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
public class class112 {
   @ObfuscatedName("r")
   byte[] field1954;
   @ObfuscatedName("a")
   int[] field1955;
   @ObfuscatedName("f")
   int[] field1956;
   @ObfuscatedName("ke")
   static class19 field1958;

   public class112(byte[] var1) {
      int var2 = var1.length;
      this.field1955 = new int[var2];
      this.field1954 = var1;
      int[] var3 = new int[33];
      this.field1956 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(0 != var6) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field1955[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if(0 != (var8 & var7)) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if(var8 != var11) {
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
               if(var3[var10] == var8) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if(0 != (var8 & var12)) {
                  if(this.field1956[var10] == 0) {
                     this.field1956[var10] = var4;
                  }

                  var10 = this.field1956[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field1956.length) {
                  int[] var13 = new int[this.field1956.length * 2];

                  for(int var14 = 0; var14 < this.field1956.length; ++var14) {
                     var13[var14] = this.field1956[var14];
                  }

                  this.field1956 = var13;
               }

               var12 >>>= 1;
            }

            this.field1956[var10] = ~var5;
            if(var10 >= var4) {
               var4 = 1 + var10;
            }
         }
      }

   }

   @ObfuscatedName("a")
   public int method2440(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field1955[var8];
         byte var10 = this.field1954[var8];
         if(0 == var10) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = var11 + (var10 + var12 - 1 >> 3);
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

      return (7 + var7 >> 3) - var5;
   }

   @ObfuscatedName("r")
   public int method2441(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(0 == var5) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field1956[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field1956[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field1956[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1956[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field1956[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1956[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 16)) {
               var6 = this.field1956[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1956[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field1956[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1956[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field1956[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1956[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 2)) {
               var6 = this.field1956[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1956[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field1956[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1956[var6]) < 0) {
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass121;S)V",
      garbageValue = "-17692"
   )
   static final void method2444(class121 var0) {
      int var1 = 0;
      var0.method2754();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class32.field774; ++var2) {
         var3 = class32.field759[var2];
         if(0 == (class32.field755[var3] & 1)) {
            if(var1 > 0) {
               --var1;
               class32.field755[var3] = (byte)(class32.field755[var3] | 2);
            } else {
               var4 = var0.method2750(1);
               if(var4 == 0) {
                  var1 = class23.method589(var0);
                  class32.field755[var3] = (byte)(class32.field755[var3] | 2);
               } else {
                  class21.method572(var0, var3);
               }
            }
         }
      }

      var0.method2755();
      if(0 != var1) {
         throw new RuntimeException();
      } else {
         var0.method2754();

         for(var2 = 0; var2 < class32.field774; ++var2) {
            var3 = class32.field759[var2];
            if(0 != (class32.field755[var3] & 1)) {
               if(var1 > 0) {
                  --var1;
                  class32.field755[var3] = (byte)(class32.field755[var3] | 2);
               } else {
                  var4 = var0.method2750(1);
                  if(0 == var4) {
                     var1 = class23.method589(var0);
                     class32.field755[var3] = (byte)(class32.field755[var3] | 2);
                  } else {
                     class21.method572(var0, var3);
                  }
               }
            }
         }

         var0.method2755();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2754();

            for(var2 = 0; var2 < class32.field760; ++var2) {
               var3 = class32.field761[var2];
               if((class32.field755[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class32.field755[var3] = (byte)(class32.field755[var3] | 2);
                  } else {
                     var4 = var0.method2750(1);
                     if(0 == var4) {
                        var1 = class23.method589(var0);
                        class32.field755[var3] = (byte)(class32.field755[var3] | 2);
                     } else if(class3.method50(var0, var3)) {
                        class32.field755[var3] = (byte)(class32.field755[var3] | 2);
                     }
                  }
               }
            }

            var0.method2755();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2754();

               for(var2 = 0; var2 < class32.field760; ++var2) {
                  var3 = class32.field761[var2];
                  if((class32.field755[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class32.field755[var3] = (byte)(class32.field755[var3] | 2);
                     } else {
                        var4 = var0.method2750(1);
                        if(0 == var4) {
                           var1 = class23.method589(var0);
                           class32.field755[var3] = (byte)(class32.field755[var3] | 2);
                        } else if(class3.method50(var0, var3)) {
                           class32.field755[var3] = (byte)(class32.field755[var3] | 2);
                        }
                     }
                  }
               }

               var0.method2755();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class32.field774 = 0;
                  class32.field760 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class32.field755[var2] = (byte)(class32.field755[var2] >> 1);
                     class2 var5 = client.field415[var2];
                     if(null != var5) {
                        class32.field759[++class32.field774 - 1] = var2;
                     } else {
                        class32.field761[++class32.field760 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("f")
   static boolean method2445(String var0, int var1) {
      return class126.method2829(var0, var1, "openjs");
   }

   @ObfuscatedName("dl")
   static final void method2446(class3 var0, boolean var1) {
      int var2 = var0.field56;
      int var3 = (int)var0.field3111;
      var0.method3946();
      if(var1) {
         class95.method2213(var2);
      }

      class210.method3965(var2);
      class172 var4 = class92.method2180(var3);
      if(var4 != null) {
         class36.method745(var4);
      }

      class37.method764();
      if(client.field453 != -1) {
         int var5 = client.field453;
         if(class103.method2303(var5)) {
            class134.method2879(class172.field2850[var5], 1);
         }
      }

   }

   @ObfuscatedName("db")
   static boolean method2447(class172 var0) {
      if(client.field463) {
         if(class101.method2294(var0) != 0) {
            return false;
         }

         if(var0.field2764 == 0) {
            return false;
         }
      }

      return var0.field2763;
   }
}
