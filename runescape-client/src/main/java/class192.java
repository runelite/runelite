import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class192 {
   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "([Lclass176;II)V",
      garbageValue = "2052489029"
   )
   static final void method3800(class176[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class176 var3 = var0[var2];
         if(null != var3 && var3.field2836 == var1 && (!var3.field2794 || !class32.method677(var3))) {
            int var5;
            if(var3.field2929 == 0) {
               if(!var3.field2794 && class32.method677(var3) && var3 != class15.field197) {
                  continue;
               }

               method3800(var0, var3.field2795);
               if(null != var3.field2919) {
                  method3800(var3.field2919, var3.field2795);
               }

               class3 var4 = (class3)client.field535.method3856((long)var3.field2795);
               if(var4 != null) {
                  var5 = var4.field66;
                  if(class122.method2739(var5)) {
                     method3800(class176.field2814[var5], -1);
                  }
               }
            }

            if(var3.field2929 == 6) {
               if(var3.field2831 != -1 || var3.field2843 != -1) {
                  boolean var7 = class59.method1271(var3);
                  if(var7) {
                     var5 = var3.field2843;
                  } else {
                     var5 = var3.field2831;
                  }

                  if(var5 != -1) {
                     class44 var6 = class28.method646(var5);

                     for(var3.field2864 += client.field329; var3.field2864 > var6.field1011[var3.field2917]; class92.method2164(var3)) {
                        var3.field2864 -= var6.field1011[var3.field2917];
                        ++var3.field2917;
                        if(var3.field2917 >= var6.field1009.length) {
                           var3.field2917 -= var6.field1013;
                           if(var3.field2917 < 0 || var3.field2917 >= var6.field1009.length) {
                              var3.field2917 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2845 != 0 && !var3.field2794) {
                  int var8 = var3.field2845 >> 16;
                  var5 = var3.field2845 << 16 >> 16;
                  var8 *= client.field329;
                  var5 *= client.field329;
                  var3.field2853 = var3.field2853 + var8 & 2047;
                  var3.field2847 = var5 + var3.field2847 & 2047;
                  class92.method2164(var3);
               }
            }
         }
      }

   }
}
