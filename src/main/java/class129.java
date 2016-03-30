import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public final class class129 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1486237589
   )
   public static int field2058;
   @ObfuscatedName("c")
   static byte[][][] field2062;
   @ObfuscatedName("bb")
   static class80[] field2063;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method2830() {
      if(client.field454 != -1) {
         class24.method609(client.field454);
      }

      int var0;
      for(var0 = 0; var0 < client.field497; ++var0) {
         if(client.field499[var0]) {
            client.field500[var0] = true;
         }

         client.field459[var0] = client.field499[var0];
         client.field499[var0] = false;
      }

      client.field498 = client.field305;
      client.field516 = -1;
      client.field443 = -1;
      class35.field790 = null;
      if(-1 != client.field454) {
         client.field497 = 0;
         class34.method748(client.field454, 0, 0, class15.field235, class15.field233, 0, 0, -1);
      }

      class79.method1772();
      int var1;
      int var2;
      int var3;
      int var5;
      int var6;
      int var7;
      if(!client.field433) {
         if(client.field516 != -1) {
            class9.method119(client.field516, client.field443);
         }
      } else {
         var0 = client.field404;
         var1 = class18.field278;
         var2 = class14.field219;
         var3 = class0.field14;
         int var4 = 6116423;
         class79.method1800(var0, var1, var2, var3, var4);
         class79.method1800(1 + var0, var1 + 1, var2 - 2, 16, 0);
         class79.method1790(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
         class89.field1561.method4037("Choose Option", 3 + var0, var1 + 14, var4, -1);
         var5 = class140.field2168;
         var6 = class140.field2182;

         int var8;
         int var9;
         for(var7 = 0; var7 < client.field435; ++var7) {
            var8 = var1 + 31 + (client.field435 - 1 - var7) * 15;
            var9 = 16777215;
            if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
               var9 = 16776960;
            }

            class89.field1561.method4037(class82.method1885(var7), var0 + 3, var8, var9, 0);
         }

         var7 = client.field404;
         var8 = class18.field278;
         var9 = class14.field219;
         int var10 = class0.field14;

         for(int var11 = 0; var11 < client.field497; ++var11) {
            if(client.field558[var11] + client.field361[var11] > var7 && client.field361[var11] < var7 + var9 && client.field486[var11] + client.field505[var11] > var8 && client.field486[var11] < var8 + var10) {
               client.field500[var11] = true;
            }
         }
      }

      if(3 == client.field506) {
         for(var0 = 0; var0 < client.field497; ++var0) {
            if(client.field459[var0]) {
               class79.method1803(client.field361[var0], client.field486[var0], client.field558[var0], client.field505[var0], 16711935, 128);
            } else if(client.field500[var0]) {
               class79.method1803(client.field361[var0], client.field486[var0], client.field558[var0], client.field505[var0], 16711680, 128);
            }
         }
      }

      var0 = class82.field1437;
      var1 = class167.field2692.field849;
      var2 = class167.field2692.field819;
      var3 = client.field370;

      for(class23 var12 = (class23)class23.field618.method3836(); var12 != null; var12 = (class23)class23.field618.method3841()) {
         if(var12.field616 != -1 || null != var12.field621) {
            var5 = 0;
            if(var1 > var12.field613) {
               var5 += var1 - var12.field613;
            } else if(var1 < var12.field611) {
               var5 += var12.field611 - var1;
            }

            if(var2 > var12.field614) {
               var5 += var2 - var12.field614;
            } else if(var2 < var12.field612) {
               var5 += var12.field612 - var2;
            }

            if(var5 - 64 <= var12.field623 && client.field535 != 0 && var0 == var12.field610) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               var6 = client.field535 * (var12.field623 - var5) / var12.field623;
               class58 var10000;
               if(null == var12.field617) {
                  if(var12.field616 >= 0) {
                     var10000 = (class58)null;
                     class58 var13 = class58.method1254(class47.field1086, var12.field616, 0);
                     if(null != var13) {
                        class62 var14 = var13.method1264().method1295(class3.field73);
                        class64 var16 = class64.method1318(var14, 100, var6);
                        var16.method1322(-1);
                        class72.field1353.method1188(var16);
                        var12.field617 = var16;
                     }
                  }
               } else {
                  var12.field617.method1386(var6);
               }

               if(var12.field620 == null) {
                  if(null != var12.field621 && (var12.field615 -= var3) <= 0) {
                     var7 = (int)(Math.random() * (double)var12.field621.length);
                     var10000 = (class58)null;
                     class58 var15 = class58.method1254(class47.field1086, var12.field621[var7], 0);
                     if(var15 != null) {
                        class62 var18 = var15.method1264().method1295(class3.field73);
                        class64 var17 = class64.method1318(var18, 100, var6);
                        var17.method1322(0);
                        class72.field1353.method1188(var17);
                        var12.field620 = var17;
                        var12.field615 = var12.field609 + (int)(Math.random() * (double)(var12.field619 - var12.field609));
                     }
                  }
               } else {
                  var12.field620.method1386(var6);
                  if(!var12.field620.method3936()) {
                     var12.field620 = null;
                  }
               }
            } else {
               if(null != var12.field617) {
                  class72.field1353.method1153(var12.field617);
                  var12.field617 = null;
               }

               if(var12.field620 != null) {
                  class72.field1353.method1153(var12.field620);
                  var12.field620 = null;
               }
            }
         }
      }

      client.field370 = 0;
   }

   @ObfuscatedName("x")
   static final boolean method2831(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || 45 == var0;
   }
}
