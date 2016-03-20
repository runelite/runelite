import java.io.File;
import java.io.RandomAccessFile;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
final class class21 implements Comparator {
   @ObfuscatedName("k")
   static int[] field590;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;
   @ObfuscatedName("a")
   public static class166 field593;

   @ObfuscatedName("a")
   public static void method562(File var0) {
      class134.field2076 = var0;
      if(!class134.field2076.exists()) {
         throw new RuntimeException("");
      } else {
         class134.field2075 = true;
      }
   }

   class21(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   public int compare(Object var1, Object var2) {
      return this.method570((class213)var1, (class213)var2);
   }

   @ObfuscatedName("a")
   int method570(class213 var1, class213 var2) {
      if(var2.field3142 == var1.field3142) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field3142 == client.field527) {
               return -1;
            }

            if(client.field527 == var2.field3142) {
               return 1;
            }
         }

         return var1.field3142 < var2.field3142?-1:1;
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass121;IB)V",
      garbageValue = "-13"
   )
   static void method572(class121 var0, int var1) {
      boolean var2 = var0.method2750(1) == 1;
      if(var2) {
         class32.field766[++class32.field765 - 1] = var1;
      }

      int var3 = var0.method2750(2);
      class2 var4 = client.field415[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field49 = false;
         } else if(var1 == client.field416) {
            throw new RuntimeException();
         } else {
            class32.field773[var1] = (class147.field2214 + var4.field866[0] >> 6 << 14) + (var4.field47 << 28) + (var4.field867[0] + class17.field257 >> 6);
            if(-1 != var4.field839) {
               class32.field763[var1] = var4.field839;
            } else {
               class32.field763[var1] = var4.field862;
            }

            class32.field758[var1] = var4.field837;
            client.field415[var1] = null;
            if(var0.method2750(1) != 0) {
               class3.method50(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(1 == var3) {
            var5 = var0.method2750(3);
            var6 = var4.field866[0];
            var7 = var4.field867[0];
            if(0 == var5) {
               --var6;
               --var7;
            } else if(1 == var5) {
               --var7;
            } else if(2 == var5) {
               ++var6;
               --var7;
            } else if(3 == var5) {
               --var6;
            } else if(4 == var5) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(6 == var5) {
               ++var7;
            } else if(7 == var5) {
               ++var6;
               ++var7;
            }

            if(var1 == client.field416 && (var4.field870 < 1536 || var4.field813 < 1536 || var4.field870 >= 11776 || var4.field813 >= 11776)) {
               var4.method39(var6, var7);
               var4.field49 = false;
            } else if(var2) {
               var4.field49 = true;
               var4.field28 = var6;
               var4.field29 = var7;
            } else {
               var4.field49 = false;
               var4.method22(var6, var7, class32.field756[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.method2750(4);
            var6 = var4.field866[0];
            var7 = var4.field867[0];
            if(0 == var5) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(2 == var5) {
               var7 -= 2;
            } else if(3 == var5) {
               ++var6;
               var7 -= 2;
            } else if(4 == var5) {
               var6 += 2;
               var7 -= 2;
            } else if(5 == var5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(9 == var5) {
               var6 -= 2;
               ++var7;
            } else if(10 == var5) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(12 == var5) {
               --var6;
               var7 += 2;
            } else if(13 == var5) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(15 == var5) {
               var6 += 2;
               var7 += 2;
            }

            if(var1 == client.field416 && (var4.field870 < 1536 || var4.field813 < 1536 || var4.field870 >= 11776 || var4.field813 >= 11776)) {
               var4.method39(var6, var7);
               var4.field49 = false;
            } else if(var2) {
               var4.field49 = true;
               var4.field28 = var6;
               var4.field29 = var7;
            } else {
               var4.field49 = false;
               var4.method22(var6, var7, class32.field756[var1]);
            }

         } else {
            var5 = var0.method2750(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(0 == var5) {
               var6 = var0.method2750(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.field866[0];
               var11 = var4.field867[0] + var9;
               if(var1 == client.field416 && (var4.field870 < 1536 || var4.field813 < 1536 || var4.field870 >= 11776 || var4.field813 >= 11776)) {
                  var4.method39(var10, var11);
                  var4.field49 = false;
               } else if(var2) {
                  var4.field49 = true;
                  var4.field28 = var10;
                  var4.field29 = var11;
               } else {
                  var4.field49 = false;
                  var4.method22(var10, var11, class32.field756[var1]);
               }

               var4.field47 = (byte)(var7 + var4.field47 & 3);
               if(client.field416 == var1) {
                  class48.field1078 = var4.field47;
               }

            } else {
               var6 = var0.method2750(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class147.field2214 + var4.field866[0] & 16383) - class147.field2214;
               var11 = (var9 + var4.field867[0] + class17.field257 & 16383) - class17.field257;
               if(client.field416 != var1 || var4.field870 >= 1536 && var4.field813 >= 1536 && var4.field870 < 11776 && var4.field813 < 11776) {
                  if(var2) {
                     var4.field49 = true;
                     var4.field28 = var10;
                     var4.field29 = var11;
                  } else {
                     var4.field49 = false;
                     var4.method22(var10, var11, class32.field756[var1]);
                  }
               } else {
                  var4.method39(var10, var11);
                  var4.field49 = false;
               }

               var4.field47 = (byte)(var4.field47 + var7 & 3);
               if(var1 == client.field416) {
                  class48.field1078 = var4.field47;
               }

            }
         }
      }
   }

   @ObfuscatedName("r")
   public static File method574(String var0) {
      if(!class134.field2075) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class134.field2079.get(var0);
         if(null != var1) {
            return var1;
         } else {
            File var2 = new File(class134.field2076, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class134.field2079.put(var0, var2);
                  return var2;
               }
            } catch (Exception var7) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var6) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }
}
