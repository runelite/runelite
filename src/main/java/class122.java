import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dm")
public final class class122 extends class119 {
   @ObfuscatedName("r")
   class123 field1998;
   @ObfuscatedName("k")
   static final int[] field1999 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1021506745
   )
   int field2002;

   @ObfuscatedName("j")
   static final int method2752(int var0, int var1) {
      if(-2 == var0) {
         return 12345678;
      } else if(-1 == var0) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   public class122(int var1) {
      super(var1);
   }

   @ObfuscatedName("hf")
   public void method2754() {
      super.field1976 = (this.field2002 + 7) / 8;
   }

   @ObfuscatedName("hr")
   public void method2755() {
      this.field2002 = super.field1976 * 8;
   }

   @ObfuscatedName("ho")
   public int method2756(int var1) {
      int var2 = this.field2002 >> 3;
      int var3 = 8 - (this.field2002 & 7);
      int var4 = 0;

      for(this.field2002 += var1; var1 > var3; var3 = 8) {
         var4 += (super.field1980[var2++] & field1999[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.field1980[var2] & field1999[var3];
      } else {
         var4 += super.field1980[var2] >> var3 - var1 & field1999[var1];
      }

      return var4;
   }

   @ObfuscatedName("hx")
   public int method2758(int var1) {
      return var1 * 8 - this.field2002;
   }

   @ObfuscatedName("hv")
   public void method2762(int var1) {
      super.field1980[++super.field1976 - 1] = (byte)(var1 + this.field1998.method2776());
   }

   @ObfuscatedName("hl")
   public int method2766() {
      return super.field1980[++super.field1976 - 1] - this.field1998.method2776() & 255;
   }

   @ObfuscatedName("hd")
   public void method2772(int[] var1) {
      this.field1998 = new class123(var1);
   }

   @ObfuscatedName("w")
   public static String method2773(CharSequence var0, class212 var1) {
      if(null == var0) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = 160 == var5 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = 160 == var5 || 32 == var5 || 95 == var5 || 45 == var5;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var9 = var3 - var2;
         if(var9 >= 1) {
            byte var6;
            if(null == var1) {
               var6 = 12;
            } else {
               switch(var1.field3140) {
               case 6:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var9 <= var6) {
               StringBuilder var10 = new StringBuilder(var9);

               for(int var11 = var2; var11 < var3; ++var11) {
                  char var7 = var0.charAt(var11);
                  if(class98.method2210(var7)) {
                     char var8 = class9.method132(var7);
                     if(0 != var8) {
                        var10.append(var8);
                     }
                  }
               }

               if(var10.length() == 0) {
                  return null;
               }

               return var10.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("a")
   public static class78[] method2774(class167 var0, String var1, String var2) {
      int var3 = var0.method3255(var1);
      int var4 = var0.method3271(var3, var2);
      return class28.method653(var0, var3, var4);
   }

   @ObfuscatedName("g")
   static int method2775(class25 var0, class25 var1, int var2, boolean var3) {
      if(1 == var2) {
         int var4 = var0.field622;
         int var5 = var1.field622;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(-1 == var5) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.field625 - var1.field625:(var2 == 3?(var0.field624.equals("-")?(var1.field624.equals("-")?0:(var3?-1:1)):(var1.field624.equals("-")?(var3?1:-1):var0.field624.compareTo(var1.field624))):(var2 == 4?(var0.method599()?(var1.method599()?0:1):(var1.method599()?-1:0)):(var2 == 5?(var0.method613()?(var1.method613()?0:1):(var1.method613()?-1:0)):(var2 == 6?(var0.method598()?(var1.method598()?0:1):(var1.method598()?-1:0)):(var2 == 7?(var0.method628()?(var1.method628()?0:1):(var1.method628()?-1:0)):var0.field620 - var1.field620)))));
      }
   }
}
