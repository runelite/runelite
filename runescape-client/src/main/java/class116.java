import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public class class116 {
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = -1054834513
   )
   static int field1957;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -1902645299
   )
   static int field1961;
   @ObfuscatedName("b")
   Inflater field1962;

   public class116() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass119;[BI)V",
      garbageValue = "1995458142"
   )
   public void method2457(class119 var1, byte[] var2) {
      if(var1.field1982[var1.field1976] == 31 && var1.field1982[1 + var1.field1976] == -117) {
         if(this.field1962 == null) {
            this.field1962 = new Inflater(true);
         }

         try {
            this.field1962.setInput(var1.field1982, var1.field1976 + 10, var1.field1982.length - (var1.field1976 + 10 + 8));
            this.field1962.inflate(var2);
         } catch (Exception var4) {
            this.field1962.reset();
            throw new RuntimeException("");
         }

         this.field1962.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class116(int var1, int var2, int var3) {
   }

   @ObfuscatedName("b")
   public static final void method2459(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            class43.method918(var0 - 1L);
            class43.method918(1L);
         } else {
            class43.method918(var0);
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1143831046"
   )
   static final byte[] method2460(byte[] var0) {
      class119 var1 = new class119(var0);
      int var2 = var1.method2514();
      int var3 = var1.method2519();
      if(var3 >= 0 && (class167.field2679 == 0 || var3 <= class167.field2679)) {
         if(var2 == 0) {
            byte[] var4 = new byte[var3];
            var1.method2525(var4, 0, var3);
            return var4;
         } else {
            int var6 = var1.method2519();
            if(var6 < 0 || class167.field2679 != 0 && var6 > class167.field2679) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var6];
               if(var2 == 1) {
                  class117.method2464(var5, var6, var0, var3, 9);
               } else {
                  class167.field2675.method2457(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2010427444"
   )
   public static int method2461(int var0) {
      return var0 >> 11 & 63;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "1922369800"
   )
   static final void method2462(class122 var0, int var1) {
      int var2 = var0.field1976;
      class32.field745 = 0;
      int var3 = 0;
      var0.method2792();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < class32.field738; ++var4) {
         var5 = class32.field739[var4];
         if((class32.field748[var5] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class32.field748[var5] = (byte)(class32.field748[var5] | 2);
            } else {
               var6 = var0.method2784(1);
               if(var6 == 0) {
                  var3 = class56.method1175(var0);
                  class32.field748[var5] = (byte)(class32.field748[var5] | 2);
               } else {
                  class131.method2873(var0, var5);
               }
            }
         }
      }

      var0.method2785();
      if(var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.method2792();

         for(var4 = 0; var4 < class32.field738; ++var4) {
            var5 = class32.field739[var4];
            if((class32.field748[var5] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class32.field748[var5] = (byte)(class32.field748[var5] | 2);
               } else {
                  var6 = var0.method2784(1);
                  if(var6 == 0) {
                     var3 = class56.method1175(var0);
                     class32.field748[var5] = (byte)(class32.field748[var5] | 2);
                  } else {
                     class131.method2873(var0, var5);
                  }
               }
            }
         }

         var0.method2785();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2792();

            for(var4 = 0; var4 < class32.field735; ++var4) {
               var5 = class32.field734[var4];
               if((class32.field748[var5] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class32.field748[var5] = (byte)(class32.field748[var5] | 2);
                  } else {
                     var6 = var0.method2784(1);
                     if(var6 == 0) {
                        var3 = class56.method1175(var0);
                        class32.field748[var5] = (byte)(class32.field748[var5] | 2);
                     } else if(class101.method2288(var0, var5)) {
                        class32.field748[var5] = (byte)(class32.field748[var5] | 2);
                     }
                  }
               }
            }

            var0.method2785();
            if(var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2792();

               for(var4 = 0; var4 < class32.field735; ++var4) {
                  var5 = class32.field734[var4];
                  if((class32.field748[var5] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class32.field748[var5] = (byte)(class32.field748[var5] | 2);
                     } else {
                        var6 = var0.method2784(1);
                        if(var6 == 0) {
                           var3 = class56.method1175(var0);
                           class32.field748[var5] = (byte)(class32.field748[var5] | 2);
                        } else if(class101.method2288(var0, var5)) {
                           class32.field748[var5] = (byte)(class32.field748[var5] | 2);
                        }
                     }
                  }
               }

               var0.method2785();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class32.field738 = 0;
                  class32.field735 = 0;

                  for(var4 = 1; var4 < 2048; ++var4) {
                     class32.field748[var4] = (byte)(class32.field748[var4] >> 1);
                     class2 var7 = client.field410[var4];
                     if(var7 != null) {
                        class32.field739[++class32.field738 - 1] = var4;
                     } else {
                        class32.field734[++class32.field735 - 1] = var4;
                     }
                  }

                  class140.method2999(var0);
                  if(var0.field1976 - var2 != var1) {
                     throw new RuntimeException(var0.field1976 - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }
}
