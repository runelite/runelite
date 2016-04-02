import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class8 {
   @ObfuscatedName("h")
   LinkedHashMap field144 = new LinkedHashMap();
   @ObfuscatedName("s")
   boolean field145;
   @ObfuscatedName("f")
   boolean field146;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1217108467
   )
   int field148 = 1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 885334655
   )
   static int field149 = 4;

   class8(class119 var1) {
      if(var1 != null && var1.field1980 != null) {
         int var2 = var1.method2523();
         if(var2 >= 0 && var2 <= field149) {
            if(var1.method2523() == 1) {
               this.field146 = true;
            }

            if(var2 > 1) {
               this.field145 = var1.method2523() == 1;
            }

            if(var2 > 3) {
               this.field148 = var1.method2523();
            }

            if(var2 > 2) {
               int var3 = var1.method2523();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2528();
                  int var6 = var1.method2528();
                  this.field144.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method108();
         }
      } else {
         this.method108();
      }

   }

   @ObfuscatedName("e")
   void method108() {
   }

   @ObfuscatedName("w")
   class119 method109() {
      class119 var1 = new class119(100);
      var1.method2565(field149);
      var1.method2565(this.field146?1:0);
      var1.method2565(this.field145?1:0);
      var1.method2565(this.field148);
      var1.method2565(this.field144.size());
      Iterator var2 = this.field144.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2617(((Integer)var3.getKey()).intValue());
         var1.method2617(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("w")
   public static int method113(int var0, int var1, int var2, int var3, int var4, int var5) {
      if(1 == (var5 & 1)) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(1 == var2?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("h")
   public static boolean method115(int var0) {
      return 0 != (var0 >> 29 & 1);
   }

   class8() {
      this.method108();
   }

   @ObfuscatedName("bj")
   static final void method118(class37 var0, int var1) {
      class113.method2460(var0.field804, var0.field814, var1);
   }

   @ObfuscatedName("ag")
   static void method119(int var0) {
      client.field491 = 0L;
      if(var0 >= 2) {
         client.field398 = true;
      } else {
         client.field398 = false;
      }

      class156.method3167();
      if(client.field287 >= 25) {
         class17.method183();
      }

      class144.field2204 = true;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-112"
   )
   static final void method120() {
      class5.method60();
      if(class142.field2170 == null) {
         if(client.field451 == null) {
            int var0 = class140.field2146;
            int var1;
            int var2;
            int var3;
            int var5;
            int var6;
            int var8;
            int var14;
            int var16;
            String var10000;
            if(client.field331) {
               if(1 != var0 && (class3.field66 || var0 != 4)) {
                  var1 = class140.field2140;
                  var2 = class140.field2141;
                  if(var1 < class126.field2034 - 10 || var1 > 10 + class161.field2642 + class126.field2034 || var2 < class107.field1857 - 10 || var2 > class107.field1857 + client.field320 + 10) {
                     client.field331 = false;
                     class27.method650(class126.field2034, class107.field1857, class161.field2642, client.field320);
                  }
               }

               if(var0 == 1 || !class3.field66 && var0 == 4) {
                  var1 = class126.field2034;
                  var2 = class107.field1857;
                  var3 = class161.field2642;
                  var14 = class140.field2135;
                  var5 = class140.field2148;
                  var6 = -1;

                  for(var16 = 0; var16 < client.field420; ++var16) {
                     var8 = 31 + var2 + 15 * (client.field420 - 1 - var16);
                     if(var14 > var1 && var14 < var3 + var1 && var5 > var8 - 13 && var5 < var8 + 3) {
                        var6 = var16;
                     }
                  }

                  if(var6 != -1 && var6 >= 0) {
                     var16 = client.field494[var6];
                     var8 = client.field422[var6];
                     int var9 = client.field301[var6];
                     int var10 = client.field391[var6];
                     var10000 = client.field425[var6];
                     String var12 = client.field426[var6];
                     class56.method1179(var16, var8, var9, var10, var12, class140.field2135, class140.field2148);
                  }

                  client.field331 = false;
                  class27.method650(class126.field2034, class107.field1857, class161.field2642, client.field320);
               }
            } else {
               if((1 == var0 || !class3.field66 && var0 == 4) && client.field420 > 0) {
                  var1 = client.field301[client.field420 - 1];
                  if(39 == var1 || var1 == 40 || 41 == var1 || var1 == 42 || 43 == var1 || 33 == var1 || var1 == 34 || var1 == 35 || 36 == var1 || 37 == var1 || var1 == 38 || var1 == 1005) {
                     var2 = client.field494[client.field420 - 1];
                     var3 = client.field422[client.field420 - 1];
                     class173 var4 = class148.method3129(var3);
                     if(class0.method2(class75.method1642(var4)) || method115(class75.method1642(var4))) {
                        if(null != class142.field2170 && !client.field397 && client.field417 != 1) {
                           var6 = client.field420 - 1;
                           boolean var15;
                           if(var6 < 0) {
                              var15 = false;
                           } else {
                              var16 = client.field301[var6];
                              if(var16 >= 2000) {
                                 var16 -= 2000;
                              }

                              if(1007 == var16) {
                                 var15 = true;
                              } else {
                                 var15 = false;
                              }
                           }

                           if(!var15 && client.field420 > 0) {
                              var16 = client.field394;
                              var8 = client.field375;
                              class44.method945(class177.field2910, var16, var8);
                              class177.field2910 = null;
                           }
                        }

                        client.field397 = false;
                        client.field524 = 0;
                        if(class142.field2170 != null) {
                           class9.method133(class142.field2170);
                        }

                        class142.field2170 = class148.method3129(var3);
                        client.field393 = var2;
                        client.field394 = class140.field2135;
                        client.field375 = class140.field2148;
                        if(client.field420 > 0) {
                           class15.method177(client.field420 - 1);
                        }

                        class9.method133(class142.field2170);
                        return;
                     }
                  }
               }

               if(var0 == 1 || !class3.field66 && 4 == var0) {
                  label332: {
                     if(1 != client.field417 || client.field420 <= 2) {
                        var2 = client.field420 - 1;
                        boolean var13;
                        if(var2 < 0) {
                           var13 = false;
                        } else {
                           var3 = client.field301[var2];
                           if(var3 >= 2000) {
                              var3 -= 2000;
                           }

                           if(1007 == var3) {
                              var13 = true;
                           } else {
                              var13 = false;
                           }
                        }

                        if(!var13) {
                           break label332;
                        }
                     }

                     var0 = 2;
                  }
               }

               if((var0 == 1 || !class3.field66 && var0 == 4) && client.field420 > 0) {
                  var1 = client.field420 - 1;
                  if(var1 >= 0) {
                     var2 = client.field494[var1];
                     var3 = client.field422[var1];
                     var14 = client.field301[var1];
                     var5 = client.field391[var1];
                     var10000 = client.field425[var1];
                     String var7 = client.field426[var1];
                     class56.method1179(var2, var3, var14, var5, var7, class140.field2135, class140.field2148);
                  }
               }

               if(2 == var0 && client.field420 > 0) {
                  class82.method1905(class140.field2135, class140.field2148);
               }
            }

         }
      }
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1989200114"
   )
   static final void method123(String var0) {
      if(!var0.equals("")) {
         client.field321.method2762(19);
         client.field321.method2565(class47.method982(var0));
         client.field321.method2514(var0);
      }
   }
}
