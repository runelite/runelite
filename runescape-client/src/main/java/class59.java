import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class59 {
   @ObfuscatedName("h")
   class167 field1197;
   @ObfuscatedName("m")
   class196 field1199 = new class196(256);
   @ObfuscatedName("z")
   class196 field1200 = new class196(256);
   @ObfuscatedName("p")
   static int[][][] field1201;
   @ObfuscatedName("j")
   class167 field1203;
   @ObfuscatedName("mo")
   static byte field1204;

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
      garbageValue = "1"
   )
   static String method1248(String var0, boolean var1) {
      String var2 = "https://";
      if(client.field431 == 1) {
         var0 = var0 + "-wtrc";
      } else if(client.field431 == 2) {
         var0 = var0 + "-wtqa";
      } else if(client.field431 == 3) {
         var0 = var0 + "-wtwip";
      } else if(5 == client.field431) {
         var0 = var0 + "-wti";
      } else if(client.field431 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class185.field3005 != null) {
         var3 = "/p=" + class185.field3005;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + client.field292 + "/a=" + client.field282 + var3 + "/";
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass62;",
      garbageValue = "1440600934"
   )
   class62 method1249(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class62 var7 = (class62)this.field1200.method3742(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class70 var8 = (class70)this.field1199.method3742(var5);
         if(var8 == null) {
            var8 = class70.method1525(this.field1197, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1199.method3743(var8, var5);
         }

         var7 = var8.method1531(var3);
         if(null == var7) {
            return null;
         } else {
            var8.method3883();
            this.field1200.method3743(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass62;",
      garbageValue = "558220713"
   )
   public class62 method1250(int var1, int[] var2) {
      if(this.field1203.method3250() == 1) {
         return this.method1252(0, var1, var2);
      } else if(this.field1203.method3227(var1) == 1) {
         return this.method1252(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass62;",
      garbageValue = "-151575082"
   )
   public class62 method1251(int var1, int[] var2) {
      if(this.field1197.method3250() == 1) {
         return this.method1249(0, var1, var2);
      } else if(this.field1197.method3227(var1) == 1) {
         return this.method1249(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass62;",
      garbageValue = "11"
   )
   class62 method1252(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class62 var7 = (class62)this.field1200.method3742(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class58 var8 = class58.method1237(this.field1203, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method1246();
            this.field1200.method3743(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1213.length;
            }

            return var7;
         }
      }
   }

   public class59(class167 var1, class167 var2) {
      this.field1203 = var1;
      this.field1197 = var2;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lclass37;IIIIIB)V",
      garbageValue = "16"
   )
   static final void method1260(class37 var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.vmethod742()) {
         if(var0 instanceof class34) {
            class39 var6 = ((class34)var0).field761;
            if(null != var6.field892) {
               var6 = var6.method759();
            }

            if(var6 == null) {
               return;
            }
         }

         int var10 = class32.field737;
         int[] var7 = class32.field738;
         int var8;
         if(var1 < var10) {
            var8 = 30;
            class2 var9 = (class2)var0;
            if(var9.field56) {
               return;
            }

            if(var9.field37 != -1 || var9.field40 != -1) {
               class175.method3414(var0, var0.field794 + 15);
               if(client.field277 > -1) {
                  if(-1 != var9.field37) {
                     class15.field220[var9.field37].method1700(client.field277 + var2 - 12, client.field382 + var3 - var8);
                     var8 += 25;
                  }

                  if(-1 != var9.field40) {
                     class210.field3137[var9.field40].method1700(var2 + client.field277 - 12, client.field382 + var3 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && client.field275 == 10 && client.field309 == var7[var1]) {
               class175.method3414(var0, 15 + var0.field794);
               if(client.field277 > -1) {
                  class129.field2029[1].method1700(client.field277 + var2 - 12, client.field382 + var3 - var8);
               }
            }
         } else {
            class39 var12 = ((class34)var0).field761;
            if(var12.field892 != null) {
               var12 = var12.method759();
            }

            if(var12.field890 >= 0 && var12.field890 < class210.field3137.length) {
               class175.method3414(var0, 15 + var0.field794);
               if(client.field277 > -1) {
                  class210.field3137[var12.field890].method1700(client.field277 + var2 - 12, client.field382 + var3 - 30);
               }
            }

            if(client.field275 == 1 && client.field294 == client.field459[var1 - var10] && client.field285 % 20 < 10) {
               class175.method3414(var0, var0.field794 + 15);
               if(client.field277 > -1) {
                  class129.field2029[0].method1700(client.field277 + var2 - 12, client.field382 + var3 - 28);
               }
            }
         }

         if(var0.field807 != null && (var1 >= var10 || !var0.field830 && (4 == client.field491 || !var0.field846 && (client.field491 == 0 || 3 == client.field491 || 1 == client.field491 && class109.method2418(((class2)var0).field58, false))))) {
            class175.method3414(var0, var0.field794);
            if(client.field277 > -1 && client.field516 < client.field370) {
               client.field374[client.field516] = class95.field1606.method4002(var0.field807) / 2;
               client.field373[client.field516] = class95.field1606.field3192;
               client.field371[client.field516] = client.field277;
               client.field372[client.field516] = client.field382;
               client.field375[client.field516] = var0.field811;
               client.field381[client.field516] = var0.field805;
               client.field377[client.field516] = var0.field810;
               client.field378[client.field516] = var0.field807;
               ++client.field516;
            }
         }

         if(var0.field828 > client.field285) {
            class175.method3414(var0, var0.field794 + 15);
            if(client.field277 > -1) {
               if(var1 < var10) {
                  var8 = 30;
               } else {
                  class39 var11 = ((class34)var0).field761;
                  var8 = var11.field872;
               }

               int var13 = var8 * var0.field817 / var0.field818;
               if(var13 > var8) {
                  var13 = var8;
               } else if(0 == var13 && var0.field817 > 0) {
                  var13 = 1;
               }

               class79.method1783(client.field277 + var2 - var8 / 2, client.field382 + var3 - 3, var13, 5, '\uff00');
               class79.method1783(client.field277 + var2 - var8 / 2 + var13, var3 + client.field382 - 3, var8 - var13, 5, 16711680);
            }
         }

         for(var8 = 0; var8 < 4; ++var8) {
            if(var0.field815[var8] > client.field285) {
               class175.method3414(var0, var0.field794 / 2);
               if(client.field277 > -1) {
                  if(1 == var8) {
                     client.field382 -= 20;
                  }

                  if(2 == var8) {
                     client.field277 -= 15;
                     client.field382 -= 10;
                  }

                  if(3 == var8) {
                     client.field277 += 15;
                     client.field382 -= 10;
                  }

                  class15.field219[var0.field814[var8]].method1700(client.field277 + var2 - 12, var3 + client.field382 - 12);
                  class188.field3044.method4007(Integer.toString(var0.field812[var8]), client.field277 + var2 - 1, 3 + var3 + client.field382, 16777215, 0);
               }
            }
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;III)Lclass224;",
      garbageValue = "-2139323850"
   )
   public static class224 method1261(class167 var0, class167 var1, int var2, int var3) {
      return !class31.method691(var0, var2, var3)?null:class26.method627(var1.method3217(var2, var3));
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Lclass35;",
      garbageValue = "-14436087"
   )
   static class35 method1262(int var0) {
      return (class35)class11.field171.method3764((long)var0);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1944610789"
   )
   public static int method1263(int var0) {
      class47 var2 = (class47)class47.field1047.method3704((long)var0);
      class47 var1;
      if(null != var2) {
         var1 = var2;
      } else {
         byte[] var3 = class47.field1056.method3217(14, var0);
         var2 = new class47();
         if(var3 != null) {
            var2.method981(new class119(var3));
         }

         class47.field1047.method3706(var2, (long)var0);
         var1 = var2;
      }

      int var7 = var1.field1051;
      int var4 = var1.field1049;
      int var5 = var1.field1050;
      int var6 = class176.field2902[var5 - var4];
      return class176.field2900[var7] >> var4 & var6;
   }
}
