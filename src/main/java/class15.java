import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("XItemContainer")
public class class15 extends class208 {
   @ObfuscatedName("j")
   @Export("itemContainers")
   static class196 field210 = new class196(32);
   @ObfuscatedName("h")
   @Export("itemIds")
   int[] field211 = new int[]{-1};
   @ObfuscatedName("m")
   @Export("stackSizes")
   int[] field212 = new int[]{0};
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = -1200786401
   )
   static int field214;
   @ObfuscatedName("gg")
   static class173 field217;
   @ObfuscatedName("ec")
   static class78[] field219;
   @ObfuscatedName("ea")
   static class78[] field220;
   @ObfuscatedName("d")
   public static class228[] field221;

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1"
   )
   static final void method183(boolean var0) {
      client.field328 = 0;
      client.field541 = 0;
      client.field320.method2736();
      int var1 = client.field320.method2737(8);
      int var2;
      if(var1 < client.field314) {
         for(var2 = var1; var2 < client.field314; ++var2) {
            client.field400[++client.field328 - 1] = client.field459[var2];
         }
      }

      if(var1 > client.field314) {
         throw new RuntimeException("");
      } else {
         client.field314 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = client.field459[var2];
            class34 var4 = client.field517[var3];
            var5 = client.field320.method2737(1);
            if(var5 == 0) {
               client.field459[++client.field314 - 1] = var3;
               var4.field842 = client.field285;
            } else {
               var6 = client.field320.method2737(2);
               if(var6 == 0) {
                  client.field459[++client.field314 - 1] = var3;
                  var4.field842 = client.field285;
                  client.field317[++client.field541 - 1] = var3;
               } else if(var6 == 1) {
                  client.field459[++client.field314 - 1] = var3;
                  var4.field842 = client.field285;
                  var7 = client.field320.method2737(3);
                  var4.method710(var7, (byte)1);
                  var8 = client.field320.method2737(1);
                  if(1 == var8) {
                     client.field317[++client.field541 - 1] = var3;
                  }
               } else if(var6 == 2) {
                  client.field459[++client.field314 - 1] = var3;
                  var4.field842 = client.field285;
                  var7 = client.field320.method2737(3);
                  var4.method710(var7, (byte)2);
                  var8 = client.field320.method2737(3);
                  var4.method710(var8, (byte)2);
                  int var9 = client.field320.method2737(1);
                  if(var9 == 1) {
                     client.field317[++client.field541 - 1] = var3;
                  }
               } else if(var6 == 3) {
                  client.field400[++client.field328 - 1] = var3;
               }
            }
         }

         class34 var11;
         int var12;
         while(client.field320.method2739(client.field523) >= 27) {
            var1 = client.field320.method2737(15);
            if(32767 == var1) {
               break;
            }

            boolean var10 = false;
            if(null == client.field517[var1]) {
               client.field517[var1] = new class34();
               var10 = true;
            }

            var11 = client.field517[var1];
            client.field459[++client.field314 - 1] = var1;
            var11.field842 = client.field285;
            var12 = client.field320.method2737(1);
            if(1 == var12) {
               client.field317[++client.field541 - 1] = var1;
            }

            var5 = client.field320.method2737(1);
            var6 = client.field320.method2737(8);
            if(var6 > 127) {
               var6 -= 256;
            }

            var7 = client.field490[client.field320.method2737(3)];
            if(var10) {
               var11.field844 = var11.field796 = var7;
            }

            var11.field761 = class156.method3130(client.field320.method2737(14));
            var8 = client.field320.method2737(8);
            if(var8 > 127) {
               var8 -= 256;
            }

            var11.field795 = var11.field761.field868;
            var11.field808 = var11.field761.field894;
            if(var11.field808 == 0) {
               var11.field796 = 0;
            }

            var11.field802 = var11.field761.field874;
            var11.field803 = var11.field761.field875;
            var11.field851 = var11.field761.field876;
            var11.field847 = var11.field761.field877;
            var11.field799 = var11.field761.field871;
            var11.field800 = var11.field761.field884;
            var11.field804 = var11.field761.field873;
            var11.method711(var8 + class47.field1053.field848[0], class47.field1053.field822[0] + var6, var5 == 1);
         }

         client.field320.method2733();

         for(var1 = 0; var1 < client.field541; ++var1) {
            var2 = client.field317[var1];
            var11 = client.field517[var2];
            var12 = client.field320.method2500();
            if(0 != (var12 & 32)) {
               var5 = client.field320.method2502();
               if(var5 == '\uffff') {
                  var5 = -1;
               }

               var6 = client.field320.method2527();
               if(var11.field825 == var5 && -1 != var5) {
                  var7 = class161.method3153(var5).field985;
                  if(var7 == 1) {
                     var11.field826 = 0;
                     var11.field827 = 0;
                     var11.field849 = var6;
                     var11.field829 = 0;
                  }

                  if(2 == var7) {
                     var11.field829 = 0;
                  }
               } else if(var5 == -1 || var11.field825 == -1 || class161.method3153(var5).field984 >= class161.method3153(var11.field825).field984) {
                  var11.field825 = var5;
                  var11.field826 = 0;
                  var11.field827 = 0;
                  var11.field849 = var6;
                  var11.field829 = 0;
                  var11.field852 = var11.field820;
               }
            }

            if((var12 & 4) != 0) {
               var11.field856 = client.field320.method2535();
               var5 = client.field320.method2545();
               var11.field834 = var5 >> 16;
               var11.field833 = (var5 & '\uffff') + client.field285;
               var11.field831 = 0;
               var11.field832 = 0;
               if(var11.field833 > client.field285) {
                  var11.field831 = -1;
               }

               if('\uffff' == var11.field856) {
                  var11.field856 = -1;
               }
            }

            if((var12 & 2) != 0) {
               var5 = client.field320.method2527();
               var6 = client.field320.method2500();
               var11.method743(var5, var6, client.field285);
               var11.field828 = client.field285 + 300;
               var11.field817 = client.field320.method2536();
               var11.field818 = client.field320.method2536();
            }

            if(0 != (var12 & 128)) {
               var5 = client.field320.method2536();
               var6 = client.field320.method2502();
               var7 = var11.field816 - 64 * (var5 - class187.field3014 - class187.field3014);
               var8 = var11.field840 - (var6 - class0.field12 - class0.field12) * 64;
               if(var7 != 0 || 0 != var8) {
                  var11.field821 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
               }
            }

            if(0 != (var12 & 64)) {
               var5 = client.field320.method2527();
               var6 = client.field320.method2500();
               var11.method743(var5, var6, client.field285);
               var11.field828 = 300 + client.field285;
               var11.field817 = client.field320.method2534();
               var11.field818 = client.field320.method2534();
            }

            if((var12 & 8) != 0) {
               var11.field807 = client.field320.method2508();
               var11.field810 = 100;
            }

            if((var12 & 16) != 0) {
               var11.field761 = class156.method3130(client.field320.method2535());
               var11.field795 = var11.field761.field868;
               var11.field808 = var11.field761.field894;
               var11.field802 = var11.field761.field874;
               var11.field803 = var11.field761.field875;
               var11.field851 = var11.field761.field876;
               var11.field847 = var11.field761.field877;
               var11.field799 = var11.field761.field871;
               var11.field800 = var11.field761.field884;
               var11.field804 = var11.field761.field873;
            }

            if((var12 & 1) != 0) {
               var11.field819 = client.field320.method2502();
               if(var11.field819 == '\uffff') {
                  var11.field819 = -1;
               }
            }
         }

         for(var1 = 0; var1 < client.field328; ++var1) {
            var2 = client.field400[var1];
            if(client.field285 != client.field517[var2].field842) {
               client.field517[var2].field761 = null;
               client.field517[var2] = null;
            }
         }

         if(client.field320.field1971 != client.field523) {
            throw new RuntimeException(client.field320.field1971 + "," + client.field523);
         } else {
            for(var1 = 0; var1 < client.field314; ++var1) {
               if(client.field517[client.field459[var1]] == null) {
                  throw new RuntimeException(var1 + "," + client.field314);
               }
            }

         }
      }
   }
}
