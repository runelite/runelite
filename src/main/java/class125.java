import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dr")
public abstract class class125 {
   @ObfuscatedName("kd")
   static class19 field2027;
   @ObfuscatedName("pj")
   public static class136 field2028;
   @ObfuscatedName("w")
   static boolean field2029 = false;
   @ObfuscatedName("m")
   public static boolean field2030;

   @ObfuscatedName("e")
   abstract byte[] vmethod2794();

   @ObfuscatedName("w")
   abstract void vmethod2795(byte[] var1);

   @ObfuscatedName("at")
   static final int method2800() {
      if(class39.field865.field146) {
         return class48.field1063;
      } else {
         int var0 = 3;
         if(class216.field3156 < 310) {
            int var1 = class19.field273 >> 7;
            int var2 = class5.field95 >> 7;
            int var3 = class20.field572.field804 >> 7;
            int var4 = class20.field572.field814 >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class48.field1063;
            }

            if(0 != (class5.field80[class48.field1063][var1][var2] & 4)) {
               var0 = class48.field1063;
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

               while(var3 != var1) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class5.field80[class48.field1063][var1][var2] & 4) != 0) {
                     var0 = class48.field1063;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if(0 != (class5.field80[class48.field1063][var1][var2] & 4)) {
                        var0 = class48.field1063;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = '耀';

               while(var2 != var4) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if(0 != (class5.field80[class48.field1063][var1][var2] & 4)) {
                     var0 = class48.field1063;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if(0 != (class5.field80[class48.field1063][var1][var2] & 4)) {
                        var0 = class48.field1063;
                     }
                  }
               }
            }
         }

         if(class20.field572.field804 >= 0 && class20.field572.field814 >= 0 && class20.field572.field804 < 13312 && class20.field572.field814 < 13312) {
            if((class5.field80[class48.field1063][class20.field572.field804 >> 7][class20.field572.field814 >> 7] & 4) != 0) {
               var0 = class48.field1063;
            }

            return var0;
         } else {
            return class48.field1063;
         }
      }
   }

   @ObfuscatedName("s")
   public static int method2801(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }
}
