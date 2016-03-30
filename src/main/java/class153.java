import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class153 {
   @ObfuscatedName("w")
   static final class153 field2298 = new class153("LIVE", 0);
   @ObfuscatedName("ny")
   static class56 field2299;
   @ObfuscatedName("t")
   static final class153 field2300 = new class153("RC", 1);
   @ObfuscatedName("p")
   static final class153 field2301 = new class153("WIP", 2);
   @ObfuscatedName("e")
   public final String field2302;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1013302109
   )
   public final int field2303;
   @ObfuscatedName("x")
   static final class153 field2306 = new class153("BUILDLIVE", 3);

   @ObfuscatedName("p")
   public static void method3180() {
      Object var0 = class170.field2726;
      synchronized(class170.field2726) {
         if(class170.field2728 != 0) {
            class170.field2728 = 1;

            try {
               class170.field2726.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lclass37;I)V",
      garbageValue = "-2013125405"
   )
   static final void method3181(class37 var0) {
      if(var0.field842 != 0) {
         if(-1 != var0.field851) {
            Object var1 = null;
            if(var0.field851 < '耀') {
               var1 = client.field331[var0.field851];
            } else if(var0.field851 >= '耀') {
               var1 = client.field415[var0.field851 - '耀'];
            }

            if(var1 != null) {
               int var2 = var0.field849 - ((class37)var1).field849;
               int var3 = var0.field819 - ((class37)var1).field819;
               if(var2 != 0 || var3 != 0) {
                  var0.field847 = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field844) {
               var0.field851 = -1;
               var0.field844 = false;
            }
         }

         if(var0.field876 != -1 && (var0.field818 == 0 || var0.field845 > 0)) {
            var0.field847 = var0.field876;
            var0.field876 = -1;
         }

         int var4 = var0.field847 - var0.field820 & 2047;
         if(0 == var4 && var0.field844) {
            var0.field851 = -1;
            var0.field844 = false;
         }

         if(var4 != 0) {
            ++var0.field864;
            boolean var5;
            if(var4 > 1024) {
               var0.field820 -= var0.field842;
               var5 = true;
               if(var4 < var0.field842 || var4 > 2048 - var0.field842) {
                  var0.field820 = var0.field847;
                  var5 = false;
               }

               if(var0.field846 == var0.field823 && (var0.field864 > 25 || var5)) {
                  if(var0.field824 != -1) {
                     var0.field846 = var0.field824;
                  } else {
                     var0.field846 = var0.field826;
                  }
               }
            } else {
               var0.field820 += var0.field842;
               var5 = true;
               if(var4 < var0.field842 || var4 > 2048 - var0.field842) {
                  var0.field820 = var0.field847;
                  var5 = false;
               }

               if(var0.field846 == var0.field823 && (var0.field864 > 25 || var5)) {
                  if(var0.field825 != -1) {
                     var0.field846 = var0.field825;
                  } else {
                     var0.field846 = var0.field826;
                  }
               }
            }

            var0.field820 &= 2047;
         } else {
            var0.field864 = 0;
         }

      }
   }

   class153(String var1, int var2) {
      this.field2302 = var1;
      this.field2303 = var2;
   }

   @ObfuscatedName("p")
   public static Class method3184(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }
}
