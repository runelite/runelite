package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fh")
public class class174 extends class203 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -452953895
   )
   public final int field2877;
   @ObfuscatedName("f")
   public final int[] field2878;
   @ObfuscatedName("l")
   public final int[] field2879;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1834044955
   )
   public final int field2882;

   @ObfuscatedName("j")
   static void method3508() {
      for(class23 var0 = (class23)class23.field590.method3871(); null != var0; var0 = (class23)class23.field590.method3873()) {
         if(var0.field595 != null) {
            class16.field235.method1177(var0.field595);
            var0.field595 = null;
         }

         if(null != var0.field600) {
            class16.field235.method1177(var0.field600);
            var0.field600 = null;
         }
      }

      class23.field590.method3865();
   }

   @ObfuscatedName("j")
   public boolean method3510(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2879.length) {
         int var3 = this.field2879[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2878[var2]) {
            return true;
         }
      }

      return false;
   }

   class174(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2882 = var1;
      this.field2877 = var2;
      this.field2878 = var3;
      this.field2879 = var4;
   }
}
