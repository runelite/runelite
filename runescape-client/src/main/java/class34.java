import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("NPC")
public final class class34 extends class37 {
   @ObfuscatedName("t")
   @Export("composition")
   class39 field772;
   @ObfuscatedName("h")
   static File field774;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "1"
   )
   final void method704(int var1, int var2, boolean var3) {
      if(super.field834 != -1 && class18.method177(super.field834).field992 == 1) {
         super.field834 = -1;
      }

      super.field856 = 0;
      super.field861 = 0;
      super.field860 = 0;
      super.field847[0] = var1;
      super.field839[0] = var2;
      super.field809 = super.field847[0] * 128 + super.field807 * 64;
      super.field804 = super.field807 * 64 + 128 * super.field839[0];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "2124236572"
   )
   protected final class105 vmethod1862() {
      if(null == this.field772) {
         return null;
      } else {
         class42 var1 = super.field834 != -1 && super.field824 == 0?class18.method177(super.field834):null;
         class42 var2 = super.field827 == -1 || super.field827 == super.field808 && var1 != null?null:class18.method177(super.field827);
         class105 var3 = this.field772.method746(var1, super.field819, var2, super.field832);
         if(var3 == null) {
            return null;
         } else {
            var3.method2258();
            super.field852 = var3.field1466;
            if(super.field836 != -1 && super.field840 != -1) {
               class105 var4 = class16.method162(super.field836).method883(super.field840);
               if(var4 != null) {
                  var4.method2268(0, -super.field803, 0);
                  class105[] var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
               }
            }

            if(this.field772.field881 == 1) {
               var3.field1806 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IBB)V",
      garbageValue = "1"
   )
   final void method710(int var1, byte var2) {
      int var3 = super.field847[0];
      int var4 = super.field839[0];
      if(var1 == 0) {
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

      if(super.field834 != -1 && class18.method177(super.field834).field992 == 1) {
         super.field834 = -1;
      }

      if(super.field856 < 9) {
         ++super.field856;
      }

      for(int var5 = super.field856; var5 > 0; --var5) {
         super.field847[var5] = super.field847[var5 - 1];
         super.field839[var5] = super.field839[var5 - 1];
         super.field859[var5] = super.field859[var5 - 1];
      }

      super.field847[0] = var3;
      super.field839[0] = var4;
      super.field859[0] = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-796101794"
   )
   static void method717() {
      client.field308 = -1L;
      client.field297 = -1;
      class47.field1082.field206 = 0;
      class28.field670 = true;
      client.field298 = true;
      client.field508 = -1L;
      class211.field3141 = new class202();
      client.field325.field2000 = 0;
      client.field327.field2000 = 0;
      client.field329 = -1;
      client.field390 = -1;
      client.field333 = -1;
      client.field334 = -1;
      client.field481 = 0;
      client.field300 = 0;
      client.field335 = 0;
      client.field301 = 0;
      client.field294 = 0;
      client.field423 = false;
      class98.method2153(0);
      class43.method892();
      client.field379 = 0;
      client.field437 = false;
      client.field524 = 0;
      client.field445 = (int)(Math.random() * 100.0D) - 50;
      client.field350 = (int)(Math.random() * 110.0D) - 55;
      client.field352 = (int)(Math.random() * 80.0D) - 40;
      client.field355 = (int)(Math.random() * 120.0D) - 60;
      client.field357 = (int)(Math.random() * 30.0D) - 20;
      client.field302 = (int)(Math.random() * 20.0D) - 10 & 2047;
      client.field549 = 0;
      client.field511 = -1;
      client.field545 = 0;
      client.field517 = 0;
      client.field309 = class20.field570;
      client.field458 = class20.field570;
      client.field293 = 0;
      class28.method639();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         client.field405[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         client.field320[var0] = null;
      }

      client.field484 = -1;
      client.field417.method3772();
      client.field446.method3772();

      int var1;
      for(var0 = 0; var0 < 4; ++var0) {
         for(var1 = 0; var1 < 104; ++var1) {
            for(int var2 = 0; var2 < 104; ++var2) {
               client.field415[var0][var1][var2] = null;
            }
         }
      }

      client.field542 = new class199();
      client.field522 = 0;
      client.field418 = 0;
      client.field553 = 0;

      for(var0 = 0; var0 < class52.field1168; ++var0) {
         class52 var4 = class21.method557(var0);
         if(var4 != null) {
            class176.field2924[var0] = 0;
            class176.field2923[var0] = 0;
         }
      }

      class106.field1879.method192();
      client.field370 = -1;
      if(client.field442 != -1) {
         class28.method634(client.field442);
      }

      for(class3 var3 = (class3)client.field443.method3751(); var3 != null; var3 = (class3)client.field443.method3752()) {
         class44.method912(var3, true);
      }

      client.field442 = -1;
      client.field443 = new class196(8);
      client.field399 = null;
      client.field423 = false;
      client.field294 = 0;
      client.field555.method3431((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         client.field461[var0] = null;
         client.field412[var0] = false;
      }

      class15.field222 = new class196(32);
      client.field292 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         client.field396[var0] = true;
      }

      client.field325.method2733(159);
      class122 var5 = client.field325;
      var1 = client.field496?2:1;
      var5.method2453(var1);
      client.field325.method2454(class10.field162);
      client.field325.method2454(class41.field966);
      client.field282 = null;
      class19.field274 = 0;
      class19.field278 = null;

      for(var0 = 0; var0 < 8; ++var0) {
         client.field558[var0] = new class220();
      }

      class140.field2179 = null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2099638997"
   )
   final boolean vmethod735() {
      return this.field772 != null;
   }
}
