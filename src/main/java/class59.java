import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public class class59 {
   @ObfuscatedName("a")
   class167 field1222;
   @ObfuscatedName("w")
   class167 field1223;
   @ObfuscatedName("c")
   class196 field1224 = new class196(256);
   @ObfuscatedName("d")
   class196 field1225 = new class196(256);
   @ObfuscatedName("mz")
   @Export("clanMembers")
   static class24[] field1226;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -1790571999
   )
   @Export("cameraPitch")
   static int field1227;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1138958029
   )
   static int field1228;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass62;",
      garbageValue = "45"
   )
   public class62 method1344(int var1, int[] var2) {
      if(this.field1222.method3411() == 1) {
         return this.method1345(0, var1, var2);
      } else if(this.field1222.method3372(var1) == 1) {
         return this.method1345(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass62;",
      garbageValue = "-535454076"
   )
   class62 method1345(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class62 var7 = (class62)this.field1224.method3868(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class58 var8 = class58.method1341(this.field1222, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1330();
            this.field1224.method3875(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1239.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass62;",
      garbageValue = "56"
   )
   class62 method1346(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class62 var7 = (class62)this.field1224.method3868(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class70 var8 = (class70)this.field1225.method3868(var5);
         if(var8 == null) {
            var8 = class70.method1639(this.field1223, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1225.method3875(var8, var5);
         }

         var7 = var8.method1640(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.method3998();
            this.field1224.method3875(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lclass50;",
      garbageValue = "1158924203"
   )
   public static class50 method1347(int var0) {
      class50 var1 = (class50)class50.field1106.method3840((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class219.field3168.method3403(5, var0);
         var1 = new class50();
         if(var2 != null) {
            var1.method1113(new class119(var2));
         }

         class50.field1106.method3842(var1, (long)var0);
         return var1;
      }
   }

   public class59(class167 var1, class167 var2) {
      this.field1222 = var1;
      this.field1223 = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass62;",
      garbageValue = "123"
   )
   public class62 method1353(int var1, int[] var2) {
      if(this.field1223.method3411() == 1) {
         return this.method1346(0, var1, var2);
      } else if(this.field1223.method3372(var1) == 1) {
         return this.method1346(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "0"
   )
   static final void method1357(boolean var0) {
      class41.method935();
      ++client.field416;
      if(client.field416 >= 50) {
         client.field416 = 0;
         if(!client.field349 && null != class127.field2047) {
            client.field338.method2873(226);

            try {
               class127.field2047.method3100(client.field338.field1993, 0, client.field338.field1992);
               client.field338.field1992 = 0;
            } catch (IOException var2) {
               client.field349 = true;
            }
         }

      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-19"
   )
   static final int method1358() {
      if(class134.field2078.field147) {
         return class42.field1002;
      } else {
         int var0 = 3;
         if(field1227 < 310) {
            int var1 = class26.field673 >> 7;
            int var2 = class137.field2129 >> 7;
            int var3 = class5.field93.field844 >> 7;
            int var4 = class5.field93.field819 >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class42.field1002;
            }

            if(0 != (class5.field82[class42.field1002][var1][var2] & 4)) {
               var0 = class42.field1002;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = var6 * 65536 / var5;
               var8 = '耀';

               while(var1 != var3) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if(0 != (class5.field82[class42.field1002][var1][var2] & 4)) {
                     var0 = class42.field1002;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class5.field82[class42.field1002][var1][var2] & 4) != 0) {
                        var0 = class42.field1002;
                     }
                  }
               }
            } else {
               var7 = 65536 * var5 / var6;
               var8 = '耀';

               while(var4 != var2) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class5.field82[class42.field1002][var1][var2] & 4) != 0) {
                     var0 = class42.field1002;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class5.field82[class42.field1002][var1][var2] & 4) != 0) {
                        var0 = class42.field1002;
                     }
                  }
               }
            }
         }

         if(class5.field93.field844 >= 0 && class5.field93.field819 >= 0 && class5.field93.field844 < 13312 && class5.field93.field819 < 13312) {
            if((class5.field82[class42.field1002][class5.field93.field844 >> 7][class5.field93.field819 >> 7] & 4) != 0) {
               var0 = class42.field1002;
            }

            return var0;
         } else {
            return class42.field1002;
         }
      }
   }
}
