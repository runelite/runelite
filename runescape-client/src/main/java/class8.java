import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class8 {
   @ObfuscatedName("h")
   boolean field144;
   @ObfuscatedName("jb")
   static class176[] field145;
   @ObfuscatedName("a")
   LinkedHashMap field147 = new LinkedHashMap();
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1863977391
   )
   int field148 = 1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 351053967
   )
   static int field149 = 4;
   @ObfuscatedName("cn")
   static class146 field150;
   @ObfuscatedName("b")
   static class81 field151;
   @ObfuscatedName("c")
   boolean field153;
   @ObfuscatedName("ac")
   static class83[] field154;
   @ObfuscatedName("q")
   static int[] field155;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Lclass122;",
      garbageValue = "1750718444"
   )
   class122 method94() {
      class122 var1 = new class122(100);
      var1.method2795(field149);
      var1.method2795(this.field153?1:0);
      var1.method2795(this.field144?1:0);
      var1.method2795(this.field148);
      var1.method2795(this.field147.size());
      Iterator var2 = this.field147.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2598(((Integer)var3.getKey()).intValue());
         var1.method2598(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   class8(class122 var1) {
      if(var1 != null && var1.field2054 != null) {
         int var2 = var1.method2610();
         if(var2 >= 0 && var2 <= field149) {
            if(var1.method2610() == 1) {
               this.field153 = true;
            }

            if(var2 > 1) {
               this.field144 = var1.method2610() == 1;
            }

            if(var2 > 3) {
               this.field148 = var1.method2610();
            }

            if(var2 > 2) {
               int var3 = var1.method2610();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2614();
                  int var6 = var1.method2614();
                  this.field147.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method102(true);
         }
      } else {
         this.method102(true);
      }

   }

   class8() {
      this.method102(true);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1861735381"
   )
   void method102(boolean var1) {
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2119600866"
   )
   static final void method103() {
      for(int var0 = 0; var0 < client.field334; ++var0) {
         int var1 = client.field335[var0];
         class36 var2 = client.field331[var1];
         int var3 = client.field338.method2610();
         int var4;
         int var5;
         int var6;
         int var7;
         if((var3 & 1) != 0) {
            var4 = client.field338.method2789();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = client.field338.method2672();
                  if(var6 == 32767) {
                     var6 = client.field338.method2672();
                     var8 = client.field338.method2672();
                     var7 = client.field338.method2672();
                     var9 = client.field338.method2672();
                  } else if(var6 != 32766) {
                     var8 = client.field338.method2672();
                  } else {
                     var6 = -1;
                  }

                  var10 = client.field338.method2672();
                  var2.method796(var6, var8, var7, var9, client.field567, var10);
               }
            }

            var5 = client.field338.method2610();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = client.field338.method2672();
                  var8 = client.field338.method2672();
                  if(var8 != 32767) {
                     var9 = client.field338.method2672();
                     var10 = client.field338.method2633();
                     int var11 = var8 > 0?client.field338.method2610():var10;
                     var2.method786(var7, client.field567, var8, var9, var10, var11);
                  } else {
                     var2.method794(var7);
                  }
               }
            }
         }

         if((var3 & 8) != 0) {
            var2.field876 = client.field338.method2612();
            if(var2.field876 == '\uffff') {
               var2.field876 = -1;
            }
         }

         if((var3 & 32) != 0) {
            var4 = client.field338.method2646();
            var5 = client.field338.method2612();
            var6 = var2.field896 - 64 * (var4 - class19.field286 - class19.field286);
            var7 = var2.field879 - 64 * (var5 - class6.field128 - class6.field128);
            if(var6 != 0 || var7 != 0) {
               var2.field878 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 64) != 0) {
            var4 = client.field338.method2645();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = client.field338.method2662();
            if(var2.field890 == var4 && var4 != -1) {
               var6 = class13.method153(var4).field1036;
               if(var6 == 1) {
                  var2.field865 = 0;
                  var2.field884 = 0;
                  var2.field904 = var5;
                  var2.field886 = 0;
               }

               if(var6 == 2) {
                  var2.field886 = 0;
               }
            } else if(var4 == -1 || var2.field890 == -1 || class13.method153(var4).field1038 >= class13.method153(var2.field890).field1038) {
               var2.field890 = var4;
               var2.field865 = 0;
               var2.field884 = 0;
               var2.field904 = var5;
               var2.field886 = 0;
               var2.field909 = var2.field852;
            }
         }

         if((var3 & 16) != 0) {
            var2.field825 = class59.method1282(client.field338.method2646());
            var2.field851 = var2.field825.field924;
            var2.field903 = var2.field825.field954;
            var2.field858 = var2.field825.field953;
            var2.field850 = var2.field825.field931;
            var2.field860 = var2.field825.field932;
            var2.field861 = var2.field825.field933;
            var2.field854 = var2.field825.field950;
            var2.field856 = var2.field825.field928;
            var2.field857 = var2.field825.field929;
         }

         if((var3 & 2) != 0) {
            var2.field887 = client.field338.method2647();
            var4 = client.field338.method2655();
            var2.field891 = var4 >> 16;
            var2.field869 = (var4 & '\uffff') + client.field567;
            var2.field888 = 0;
            var2.field882 = 0;
            if(var2.field869 > client.field567) {
               var2.field888 = -1;
            }

            if(var2.field887 == '\uffff') {
               var2.field887 = -1;
            }
         }

         if((var3 & 4) != 0) {
            var2.field873 = client.field338.method2617();
            var2.field866 = 100;
         }
      }

   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-176177390"
   )
   static final void method104(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field457; ++var4) {
         if(client.field503[var4] + client.field505[var4] > var0 && client.field503[var4] < var0 + var2 && client.field504[var4] + client.field466[var4] > var1 && client.field504[var4] < var3 + var1) {
            client.field500[var4] = true;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-564196659"
   )
   static final boolean method105(int var0, int var1) {
      class42 var2 = class146.method3102(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method841(var1);
   }
}
