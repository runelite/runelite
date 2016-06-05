import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("ChatLineBuffer")
public class class27 {
   @ObfuscatedName("i")
   @Export("lines")
   class35[] field664 = new class35[100];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 22056989
   )
   @Export("length")
   int field665;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = -1177426523
   )
   @Export("menuY")
   static int field668;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = -1632738901
   )
   static int field669;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Lclass35;",
      garbageValue = "-5"
   )
   class35 method618(int var1, String var2, String var3, String var4) {
      class35 var5 = this.field664[99];

      for(int var6 = this.field665; var6 > 0; --var6) {
         if(var6 != 100) {
            this.field664[var6] = this.field664[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new class35(var1, var2, var4, var3);
      } else {
         var5.method3870();
         var5.method3844();
         var5.method719(var1, var2, var4, var3);
      }

      this.field664[0] = var5;
      if(this.field665 < 100) {
         ++this.field665;
      }

      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1437461445"
   )
   int method620() {
      return this.field665;
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "([Lclass173;II)V",
      garbageValue = "2081958722"
   )
   static final void method628(class173[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class173 var3 = var0[var2];
         if(var3 != null && var3.field2795 == var1 && (!var3.field2775 || !class14.method146(var3))) {
            int var5;
            if(var3.field2778 == 0) {
               if(!var3.field2775 && class14.method146(var3) && class131.field2082 != var3) {
                  continue;
               }

               method628(var0, var3.field2776);
               if(null != var3.field2770) {
                  method628(var3.field2770, var3.field2776);
               }

               class3 var7 = (class3)client.field443.method3748((long)var3.field2776);
               if(var7 != null) {
                  var5 = var7.field65;
                  if(class173.method3380(var5)) {
                     method628(class216.field3168[var5], -1);
                  }
               }
            }

            if(var3.field2778 == 6) {
               if(var3.field2893 != -1 || var3.field2842 != -1) {
                  boolean var4 = class77.method1653(var3);
                  if(var4) {
                     var5 = var3.field2842;
                  } else {
                     var5 = var3.field2893;
                  }

                  if(var5 != -1) {
                     class42 var6 = class18.method177(var5);

                     for(var3.field2767 += client.field330; var3.field2767 > var6.field987[var3.field2898]; class20.method547(var3)) {
                        var3.field2767 -= var6.field987[var3.field2898];
                        ++var3.field2898;
                        if(var3.field2898 >= var6.field985.length) {
                           var3.field2898 -= var6.field981;
                           if(var3.field2898 < 0 || var3.field2898 >= var6.field985.length) {
                              var3.field2898 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2869 != 0 && !var3.field2775) {
                  int var8 = var3.field2869 >> 16;
                  var5 = var3.field2869 << 16 >> 16;
                  var8 *= client.field330;
                  var5 *= client.field330;
                  var3.field2789 = var8 + var3.field2789 & 2047;
                  var3.field2798 = var5 + var3.field2798 & 2047;
                  class20.method547(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass35;",
      garbageValue = "786468261"
   )
   class35 method630(int var1) {
      return var1 >= 0 && var1 < this.field665?this.field664[var1]:null;
   }
}
