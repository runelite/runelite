import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class14 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 593099547
   )
   int field206 = -1;
   @ObfuscatedName("j")
   int[] field207;
   @ObfuscatedName("d")
   String[] field208;
   @ObfuscatedName("p")
   static int[] field212;
   @ObfuscatedName("b")
   class22 field213;
   @ObfuscatedName("a")
   static class119 field214;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2108201630"
   )
   static final int method162(int var0, int var1) {
      int var2 = class34.method735(var0 + '넵', var1 + 91923, 4) - 128 + (class34.method735(var0 + 10294, '鎽' + var1, 2) - 128 >> 1) + (class34.method735(var0, var1, 1) - 128 >> 2);
      var2 = 35 + (int)((double)var2 * 0.3D);
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILclass40;II)V",
      garbageValue = "865437790"
   )
   static void method163(int var0, int var1, int var2, class40 var3, int var4) {
      class23 var5 = new class23();
      var5.field600 = var0;
      var5.field601 = var1 * 128;
      var5.field608 = var2 * 128;
      int var6 = var3.field915;
      int var7 = var3.field904;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.field904;
         var7 = var3.field915;
      }

      var5.field605 = (var6 + var1) * 128;
      var5.field604 = (var7 + var2) * 128;
      var5.field602 = var3.field944;
      var5.field603 = var3.field906 * 128;
      var5.field612 = var3.field931;
      var5.field609 = var3.field947;
      var5.field613 = var3.field948;
      if(null != var3.field949) {
         var5.field599 = var3;
         var5.method573();
      }

      class23.field606.method3819(var5);
      if(null != var5.field613) {
         var5.field611 = var5.field612 + (int)(Math.random() * (double)(var5.field609 - var5.field612));
      }

   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "40"
   )
   static final void method164(int var0) {
      if(class84.method1909(var0)) {
         class173[] var1 = class173.field2750[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class173 var3 = var1[var2];
            if(null != var3) {
               var3.field2870 = 0;
               var3.field2855 = 0;
            }
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-749919677"
   )
   static void method165(int var0, int var1, int var2, int var3) {
      for(class23 var4 = (class23)class23.field606.method3844(); null != var4; var4 = (class23)class23.field606.method3834()) {
         if(var4.field602 != -1 || null != var4.field613) {
            int var5 = 0;
            if(var1 > var4.field605) {
               var5 += var1 - var4.field605;
            } else if(var1 < var4.field601) {
               var5 += var4.field601 - var1;
            }

            if(var2 > var4.field604) {
               var5 += var2 - var4.field604;
            } else if(var2 < var4.field608) {
               var5 += var4.field608 - var2;
            }

            if(var5 - 64 <= var4.field603 && client.field365 != 0 && var0 == var4.field600) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field603 - var5) * client.field365 / var4.field603;
               if(null == var4.field607) {
                  if(var4.field602 >= 0) {
                     class58 var11 = class58.method1251(client.field466, var4.field602, 0);
                     if(var11 != null) {
                        class62 var8 = var11.method1257().method1286(class95.field1589);
                        class64 var9 = class64.method1311(var8, 100, var6);
                        var9.method1314(-1);
                        class52.field1134.method1167(var9);
                        var4.field607 = var9;
                     }
                  }
               } else {
                  var4.field607.method1315(var6);
               }

               if(null == var4.field610) {
                  if(null != var4.field613 && (var4.field611 -= var3) <= 0) {
                     int var7 = (int)(Math.random() * (double)var4.field613.length);
                     class58 var12 = class58.method1251(client.field466, var4.field613[var7], 0);
                     if(var12 != null) {
                        class62 var13 = var12.method1257().method1286(class95.field1589);
                        class64 var10 = class64.method1311(var13, 100, var6);
                        var10.method1314(0);
                        class52.field1134.method1167(var10);
                        var4.field610 = var10;
                        var4.field611 = var4.field612 + (int)(Math.random() * (double)(var4.field609 - var4.field612));
                     }
                  }
               } else {
                  var4.field610.method1315(var6);
                  if(!var4.field610.method3911()) {
                     var4.field610 = null;
                  }
               }
            } else {
               if(var4.field607 != null) {
                  class52.field1134.method1132(var4.field607);
                  var4.field607 = null;
               }

               if(null != var4.field610) {
                  class52.field1134.method1132(var4.field610);
                  var4.field610 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIIB)Z",
      garbageValue = "0"
   )
   static final boolean method166(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      class119 var4 = new class119(var0);
      int var5 = -1;

      label85:
      while(true) {
         int var6 = var4.method2642();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method2642();
               if(var9 == 0) {
                  continue label85;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.method2514() >> 2;
               int var13 = var11 + var1;
               int var14 = var2 + var10;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  class40 var15 = class172.method3399(var5);
                  if(var12 != 22 || !client.field383 || var15.field919 != 0 || var15.field917 == 1 || var15.field938) {
                     if(!var15.method804()) {
                        ++client.field346;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method2642();
            if(var9 == 0) {
               break;
            }

            var4.method2514();
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-545395912"
   )
   public static int method167(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method168() {
      if(client.field456 != -1) {
         class142.method3014(client.field456);
      }

      int var0;
      for(var0 = 0; var0 < client.field490; ++var0) {
         if(client.field507[var0]) {
            client.field283[var0] = true;
         }

         client.field494[var0] = client.field507[var0];
         client.field507[var0] = false;
      }

      client.field491 = client.field296;
      client.field436 = -1;
      client.field437 = -1;
      class119.field1983 = null;
      if(client.field456 != -1) {
         client.field490 = 0;
         client.method272(client.field456, 0, 0, class45.field1026, class143.field2169, 0, 0, -1);
      }

      class79.method1827();
      if(!client.field428) {
         if(client.field436 != -1) {
            class106.method2375(client.field436, client.field437);
         }
      } else {
         class187.method3748();
      }

      if(client.field499 == 3) {
         for(var0 = 0; var0 < client.field490; ++var0) {
            if(client.field494[var0]) {
               class79.method1855(client.field495[var0], client.field496[var0], client.field497[var0], client.field498[var0], 16711935, 128);
            } else if(client.field283[var0]) {
               class79.method1855(client.field495[var0], client.field496[var0], client.field497[var0], client.field498[var0], 16711680, 128);
            }
         }
      }

      method165(class144.field2193, class153.field2262.field813, class153.field2262.field791, client.field538);
      client.field538 = 0;
   }
}
