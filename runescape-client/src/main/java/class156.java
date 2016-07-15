import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class156 {
   @ObfuscatedName("c")
   static final class156 field2322 = new class156("RC", 1);
   @ObfuscatedName("l")
   static final class156 field2323 = new class156("BUILDLIVE", 3);
   @ObfuscatedName("e")
   static final class156 field2324 = new class156("LIVE", 0);
   @ObfuscatedName("r")
   public final String field2326;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -302911239
   )
   final int field2327;
   @ObfuscatedName("h")
   static final class156 field2328 = new class156("WIP", 2);

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class156(String var1, int var2) {
      this.field2326 = var1;
      this.field2327 = var2;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "28"
   )
   static final int method3243() {
      if(client.field571.field153) {
         return class50.field1119;
      } else {
         int var0 = 3;
         if(class98.field1694 < 310) {
            int var1 = class85.field1500 >> 7;
            int var2 = class157.field2342 >> 7;
            int var3 = class118.field2035.field896 >> 7;
            int var4 = class118.field2035.field879 >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class50.field1119;
            }

            if((class5.field89[class50.field1119][var1][var2] & 4) != 0) {
               var0 = class50.field1119;
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
               var7 = 65536 * var6 / var5;
               var8 = '耀';

               while(var1 != var3) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class5.field89[class50.field1119][var1][var2] & 4) != 0) {
                     var0 = class50.field1119;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class5.field89[class50.field1119][var1][var2] & 4) != 0) {
                        var0 = class50.field1119;
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

                  if((class5.field89[class50.field1119][var1][var2] & 4) != 0) {
                     var0 = class50.field1119;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class5.field89[class50.field1119][var1][var2] & 4) != 0) {
                        var0 = class50.field1119;
                     }
                  }
               }
            }
         }

         if(class118.field2035.field896 >= 0 && class118.field2035.field879 >= 0 && class118.field2035.field896 < 13312 && class118.field2035.field879 < 13312) {
            if((class5.field89[class50.field1119][class118.field2035.field896 >> 7][class118.field2035.field879 >> 7] & 4) != 0) {
               var0 = class50.field1119;
            }

            return var0;
         } else {
            return class50.field1119;
         }
      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1747412803"
   )
   static final void method3244() {
      for(class16 var0 = (class16)client.field427.method3899(); var0 != null; var0 = (class16)client.field427.method3918()) {
         if(var0.field230 > 0) {
            --var0.field230;
         }

         if(var0.field230 == 0) {
            if(var0.field234 < 0 || class8.method105(var0.field234, var0.field233)) {
               class169.method3334(var0.field238, var0.field231, var0.field232, var0.field242, var0.field234, var0.field235, var0.field233);
               var0.method4000();
            }
         } else {
            if(var0.field239 > 0) {
               --var0.field239;
            }

            if(var0.field239 == 0 && var0.field232 >= 1 && var0.field242 >= 1 && var0.field232 <= 102 && var0.field242 <= 102 && (var0.field237 < 0 || class8.method105(var0.field237, var0.field240))) {
               class169.method3334(var0.field238, var0.field231, var0.field232, var0.field242, var0.field237, var0.field236, var0.field240);
               var0.field239 = -1;
               if(var0.field237 == var0.field234 && var0.field234 == -1) {
                  var0.method4000();
               } else if(var0.field234 == var0.field237 && var0.field236 == var0.field235 && var0.field233 == var0.field240) {
                  var0.method4000();
               }
            }
         }
      }

   }
}
