import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("NPC")
public final class class34 extends class37 {
   @ObfuscatedName("w")
   @Export("composition")
   class39 field781;
   @ObfuscatedName("p")
   static byte[][][] field782;
   @ObfuscatedName("x")
   static String field786;
   @ObfuscatedName("m")
   public static short[] field787;

   @ObfuscatedName("y")
   public static void method731() {
      try {
         class149.field2260.method4151();

         for(int var0 = 0; var0 < class149.field2263; ++var0) {
            class177.field2920[var0].method4151();
         }

         class149.field2261.method4151();
         class149.field2252.method4151();
      } catch (Exception var1) {
         ;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "6"
   )
   final void method732(int var1, int var2, boolean var3) {
      if(-1 != super.field821 && class96.method2187(super.field821).field1004 == 1) {
         super.field821 = -1;
      }

      if(!var3) {
         int var4 = var1 - super.field872[0];
         int var5 = var2 - super.field873[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field818 < 9) {
               ++super.field818;
            }

            for(int var6 = super.field818; var6 > 0; --var6) {
               super.field872[var6] = super.field872[var6 - 1];
               super.field873[var6] = super.field873[var6 - 1];
               super.field874[var6] = super.field874[var6 - 1];
            }

            super.field872[0] = var1;
            super.field873[0] = var2;
            super.field874[0] = 1;
            return;
         }
      }

      super.field818 = 0;
      super.field875 = 0;
      super.field845 = 0;
      super.field872[0] = var1;
      super.field873[0] = var2;
      super.field849 = super.field872[0] * 128 + super.field822 * 64;
      super.field819 = super.field822 * 64 + 128 * super.field873[0];
   }

   @ObfuscatedName("t")
   protected final class105 vmethod1901() {
      if(null == this.field781) {
         return null;
      } else {
         class42 var1 = super.field821 != -1 && super.field852 == 0?class96.method2187(super.field821):null;
         class42 var2 = -1 != super.field846 && (super.field823 != super.field846 || var1 == null)?class96.method2187(super.field846):null;
         class105 var3 = this.field781.method792(var1, super.field850, var2, super.field837);
         if(null == var3) {
            return null;
         } else {
            var3.method2323();
            super.field867 = var3.field1467;
            if(-1 != super.field854 && -1 != super.field869) {
               class105 var4 = class29.method669(super.field854).method937(super.field869);
               if(var4 != null) {
                  var4.method2341(0, -super.field858, 0);
                  class105[] var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
               }
            }

            if(this.field781.field885 == 1) {
               var3.field1870 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "239760490"
   )
   final void method735(int var1, byte var2) {
      int var3 = super.field872[0];
      int var4 = super.field873[0];
      if(0 == var1) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.field821 != -1 && class96.method2187(super.field821).field1004 == 1) {
         super.field821 = -1;
      }

      if(super.field818 < 9) {
         ++super.field818;
      }

      for(int var5 = super.field818; var5 > 0; --var5) {
         super.field872[var5] = super.field872[var5 - 1];
         super.field873[var5] = super.field873[var5 - 1];
         super.field874[var5] = super.field874[var5 - 1];
      }

      super.field872[0] = var3;
      super.field873[0] = var4;
      super.field874[0] = var2;
   }

   @ObfuscatedName("m")
   final boolean vmethod781() {
      return this.field781 != null;
   }

   @ObfuscatedName("cz")
   static void method746(class173[] var0, class173 var1, boolean var2) {
      int var3 = 0 != var1.field2790?var1.field2790:var1.field2767;
      int var4 = var1.field2791 != 0?var1.field2791:var1.field2783;
      class185.method3728(var0, var1.field2838, var3, var4, var2);
      if(null != var1.field2891) {
         class185.method3728(var1.field2891, var1.field2838, var3, var4, var2);
      }

      class3 var5 = (class3)client.field455.method3806((long)var1.field2838);
      if(var5 != null) {
         class14.method168(var5.field74, var3, var4, var2);
      }

      if(var1.field2890 == 1337) {
         ;
      }

   }

   @ObfuscatedName("bt")
   static final void method748(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class39.method817(var0)) {
         class76.field1394 = null;
         class23.method604(class173.field2830[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class76.field1394 != null) {
            class23.method604(class76.field1394, -1412584499, var1, var2, var3, var4, class113.field1976, class2.field64, var7);
            class76.field1394 = null;
         }

      } else {
         if(var7 != -1) {
            client.field499[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               client.field499[var8] = true;
            }
         }

      }
   }
}
