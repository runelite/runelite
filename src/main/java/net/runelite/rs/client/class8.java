package net.runelite.rs.client;
import java.awt.datatransfer.Clipboard;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("n")
public class class8 {
   @ObfuscatedName("gt")
   static class172 field141;
   @ObfuscatedName("a")
   boolean field142;
   @ObfuscatedName("i")
   boolean field143;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1546127371
   )
   int field144 = 1;
   @ObfuscatedName("m")
   LinkedHashMap field145 = new LinkedHashMap();
   @ObfuscatedName("pl")
   static Clipboard field146;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1886544583
   )
   static int field149 = 4;

   @ObfuscatedName("l")
   class118 method99() {
      class118 var1 = new class118(100);
      var1.method2438(field149);
      var1.method2438(this.field142?1:0);
      var1.method2438(this.field143?1:0);
      var1.method2438(this.field144);
      var1.method2438(this.field145.size());
      Iterator var2 = this.field145.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2441(((Integer)var3.getKey()).intValue());
         var1.method2441(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   class8(class118 var1) {
      if(null != var1 && var1.field1995 != null) {
         int var2 = var1.method2453();
         if(var2 >= 0 && var2 <= field149) {
            if(var1.method2453() == 1) {
               this.field142 = true;
            }

            if(var2 > 1) {
               this.field143 = var1.method2453() == 1;
            }

            if(var2 > 3) {
               this.field144 = var1.method2453();
            }

            if(var2 > 2) {
               int var3 = var1.method2453();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2458();
                  int var6 = var1.method2458();
                  this.field145.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method101();
         }
      } else {
         this.method101();
      }

   }

   @ObfuscatedName("a")
   static final void method100(class121 var0) {
      int var1 = 0;
      var0.method2688();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class32.field749; ++var2) {
         var3 = class32.field755[var2];
         if(0 == (class32.field746[var3] & 1)) {
            if(var1 > 0) {
               --var1;
               class32.field746[var3] = (byte)(class32.field746[var3] | 2);
            } else {
               var4 = var0.method2689(1);
               if(0 == var4) {
                  var1 = class136.method2856(var0);
                  class32.field746[var3] = (byte)(class32.field746[var3] | 2);
               } else {
                  class0.method4(var0, var3);
               }
            }
         }
      }

      var0.method2690();
      if(0 != var1) {
         throw new RuntimeException();
      } else {
         var0.method2688();

         for(var2 = 0; var2 < class32.field749; ++var2) {
            var3 = class32.field755[var2];
            if(0 != (class32.field746[var3] & 1)) {
               if(var1 > 0) {
                  --var1;
                  class32.field746[var3] = (byte)(class32.field746[var3] | 2);
               } else {
                  var4 = var0.method2689(1);
                  if(0 == var4) {
                     var1 = class136.method2856(var0);
                     class32.field746[var3] = (byte)(class32.field746[var3] | 2);
                  } else {
                     class0.method4(var0, var3);
                  }
               }
            }
         }

         var0.method2690();
         if(0 != var1) {
            throw new RuntimeException();
         } else {
            var0.method2688();

            for(var2 = 0; var2 < class32.field750; ++var2) {
               var3 = class32.field751[var2];
               if(0 != (class32.field746[var3] & 1)) {
                  if(var1 > 0) {
                     --var1;
                     class32.field746[var3] = (byte)(class32.field746[var3] | 2);
                  } else {
                     var4 = var0.method2689(1);
                     if(var4 == 0) {
                        var1 = class136.method2856(var0);
                        class32.field746[var3] = (byte)(class32.field746[var3] | 2);
                     } else if(class33.method722(var0, var3)) {
                        class32.field746[var3] = (byte)(class32.field746[var3] | 2);
                     }
                  }
               }
            }

            var0.method2690();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2688();

               for(var2 = 0; var2 < class32.field750; ++var2) {
                  var3 = class32.field751[var2];
                  if(0 == (class32.field746[var3] & 1)) {
                     if(var1 > 0) {
                        --var1;
                        class32.field746[var3] = (byte)(class32.field746[var3] | 2);
                     } else {
                        var4 = var0.method2689(1);
                        if(var4 == 0) {
                           var1 = class136.method2856(var0);
                           class32.field746[var3] = (byte)(class32.field746[var3] | 2);
                        } else if(class33.method722(var0, var3)) {
                           class32.field746[var3] = (byte)(class32.field746[var3] | 2);
                        }
                     }
                  }
               }

               var0.method2690();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class32.field749 = 0;
                  class32.field750 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class32.field746[var2] = (byte)(class32.field746[var2] >> 1);
                     class2 var5 = client.field410[var2];
                     if(null != var5) {
                        class32.field755[++class32.field749 - 1] = var2;
                     } else {
                        class32.field751[++class32.field750 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("j")
   void method101() {
   }

   @ObfuscatedName("bo")
   static final void method108(class2 var0, int var1, int var2, int var3) {
      if(class148.field2249 != var0) {
         if(client.field430 < 400) {
            String var4;
            int var7;
            if(0 == var0.field40) {
               String var5 = var0.field38[0] + var0.field48 + var0.field38[1];
               var7 = var0.field39;
               int var8 = class148.field2249.field39;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class24.method592(16711680);
               } else if(var9 < -6) {
                  var6 = class24.method592(16723968);
               } else if(var9 < -3) {
                  var6 = class24.method592(16740352);
               } else if(var9 < 0) {
                  var6 = class24.method592(16756736);
               } else if(var9 > 9) {
                  var6 = class24.method592('\uff00');
               } else if(var9 > 6) {
                  var6 = class24.method592(4259584);
               } else if(var9 > 3) {
                  var6 = class24.method592(8453888);
               } else if(var9 > 0) {
                  var6 = class24.method592(12648192);
               } else {
                  var6 = class24.method592(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.field39 + ")" + var0.field38[2];
            } else {
               var4 = var0.field38[0] + var0.field48 + var0.field38[1] + " " + " (" + "skill-" + var0.field40 + ")" + var0.field38[2];
            }

            int var10;
            if(client.field301 == 1) {
               class118.method2510("Use", client.field442 + " " + "->" + " " + class24.method592(16777215) + var4, 14, var1, var2, var3);
            } else if(client.field408) {
               if((client.field573 & 8) == 8) {
                  class118.method2510(client.field446, client.field447 + " " + "->" + " " + class24.method592(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(client.field416[var10] != null) {
                     short var12 = 0;
                     if(client.field416[var10].equalsIgnoreCase("Attack")) {
                        if(class20.field579 == client.field313) {
                           continue;
                        }

                        if(client.field313 == class20.field576 || class20.field578 == client.field313 && var0.field39 > class148.field2249.field39) {
                           var12 = 2000;
                        }

                        if(0 != class148.field2249.field53 && 0 != var0.field53) {
                           if(class148.field2249.field53 == var0.field53) {
                              var12 = 2000;
                           } else {
                              var12 = 0;
                           }
                        }
                     } else if(client.field348[var10]) {
                        var12 = 2000;
                     }

                     boolean var11 = false;
                     var7 = client.field325[var10] + var12;
                     class118.method2510(client.field416[var10], class24.method592(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < client.field430; ++var10) {
               if(client.field433[var10] == 23) {
                  client.field365[var10] = class24.method592(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   class8() {
      this.method101();
   }

   @ObfuscatedName("bj")
   static final void method112(class2 var0, int var1, int var2, byte var3) {
      int var4 = var0.field864[0];
      int var5 = var0.field817[0];
      int var6 = var0.method31();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var9 = var0.method31();
            client.field567.field1889 = var1;
            client.field567.field1885 = var2;
            client.field567.field1886 = 1;
            client.field567.field1888 = 1;
            class10 var10 = client.field567;
            int var11 = class6.method93(var4, var5, var9, var10, client.field346[var0.field55], client.field568, client.field569);
            if(var11 >= 1) {
               for(int var12 = 0; var12 < var11 - 1; ++var12) {
                  var0.method16(client.field568[var12], client.field569[var12], var3);
               }

            }
         }
      }
   }
}
