import java.awt.Font;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("NPC")
public final class class34 extends class37 {
   @ObfuscatedName("cj")
   static class224 field753;
   @ObfuscatedName("ql")
   protected static Font field754;
   @ObfuscatedName("e")
   @Export("composition")
   class39 field755;
   @ObfuscatedName("m")
   static class80 field757;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "1465336186"
   )
   final void method713(int var1, int var2, boolean var3) {
      if(super.field819 != -1 && class46.method974(super.field819).field978 == 1) {
         super.field819 = -1;
      }

      if(!var3) {
         int var4 = var1 - super.field842[0];
         int var5 = var2 - super.field843[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field834 < 9) {
               ++super.field834;
            }

            for(int var6 = super.field834; var6 > 0; --var6) {
               super.field842[var6] = super.field842[var6 - 1];
               super.field843[var6] = super.field843[var6 - 1];
               super.field844[var6] = super.field844[var6 - 1];
            }

            super.field842[0] = var1;
            super.field843[0] = var2;
            super.field844[0] = 1;
            return;
         }
      }

      super.field834 = 0;
      super.field811 = 0;
      super.field832 = 0;
      super.field842[0] = var1;
      super.field843[0] = var2;
      super.field804 = 128 * super.field842[0] + super.field792 * 64;
      super.field814 = super.field792 * 64 + 128 * super.field843[0];
   }

   @ObfuscatedName("g")
   final boolean vmethod744() {
      return this.field755 != null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IBS)V",
      garbageValue = "308"
   )
   final void method716(int var1, byte var2) {
      int var3 = super.field842[0];
      int var4 = super.field843[0];
      if(0 == var1) {
         --var3;
         ++var4;
      }

      if(1 == var1) {
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

      if(5 == var1) {
         --var3;
         --var4;
      }

      if(6 == var1) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.field819 != -1 && class46.method974(super.field819).field978 == 1) {
         super.field819 = -1;
      }

      if(super.field834 < 9) {
         ++super.field834;
      }

      for(int var5 = super.field834; var5 > 0; --var5) {
         super.field842[var5] = super.field842[var5 - 1];
         super.field843[var5] = super.field843[var5 - 1];
         super.field844[var5] = super.field844[var5 - 1];
      }

      super.field842[0] = var3;
      super.field843[0] = var4;
      super.field844[0] = var2;
   }

   @ObfuscatedName("f")
   protected final class105 vmethod1921() {
      if(this.field755 == null) {
         return null;
      } else {
         class42 var1 = super.field819 != -1 && 0 == super.field822?class46.method974(super.field819):null;
         class42 var2 = -1 != super.field838 && (super.field838 != super.field847 || var1 == null)?class46.method974(super.field838):null;
         class105 var3 = this.field755.method760(var1, super.field789, var2, super.field839);
         if(var3 == null) {
            return null;
         } else {
            var3.method2341();
            super.field808 = var3.field1438;
            if(super.field824 != -1 && super.field817 != -1) {
               class105 var4 = class82.method1906(super.field824).method914(super.field817);
               if(null != var4) {
                  var4.method2337(0, -super.field828, 0);
                  class105[] var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
               }
            }

            if(this.field755.field871 == 1) {
               var3.field1801 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("s")
   public static void method725() {
      class140 var0 = class140.field2142;
      synchronized(class140.field2142) {
         class140.field2136 = class140.field2147;
         class140.field2140 = class140.field2137;
         class140.field2141 = class140.field2138;
         class140.field2146 = class140.field2144;
         class140.field2135 = class140.field2143;
         class140.field2148 = class140.field2134;
         class140.field2149 = class140.field2145;
         class140.field2144 = 0;
      }
   }

   @ObfuscatedName("e")
   public static void method726(class167 var0) {
      class45.field1024 = var0;
   }
}
