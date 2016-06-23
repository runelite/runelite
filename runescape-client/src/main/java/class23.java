import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public final class class23 extends class208 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -749208191
   )
   int field603;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 742404283
   )
   int field604;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 864980381
   )
   int field605;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -562196121
   )
   int field606;
   @ObfuscatedName("p")
   class64 field607;
   @ObfuscatedName("f")
   static class199 field608 = new class199();
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -712628093
   )
   int field609;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 875280337
   )
   int field610;
   @ObfuscatedName("g")
   class64 field611;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -339975569
   )
   int field612;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1620708791
   )
   int field613;
   @ObfuscatedName("o")
   int[] field614;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1369738293
   )
   int field615;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1623734389
   )
   int field616;
   @ObfuscatedName("r")
   class40 field617;
   @ObfuscatedName("ak")
   static class143 field618;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-653531933"
   )
   @Export("loadWorlds")
   static boolean method623() {
      try {
         if(null == class189.field3050) {
            class189.field3050 = new class18(class7.field136, new URL(class59.field1236));
         } else {
            byte[] var0 = class189.field3050.method209();
            if(null != var0) {
               class119 var1 = new class119(var0);
               class25.field636 = var1.method2556();
               class25.field635 = new class25[class25.field636];

               class25 var3;
               for(int var2 = 0; var2 < class25.field636; var3.field646 = var2++) {
                  var3 = class25.field635[var2] = new class25();
                  var3.field640 = var1.method2556();
                  var3.field641 = var1.method2696();
                  var3.field643 = var1.method2668();
                  var3.field631 = var1.method2668();
                  var3.field650 = var1.method2554();
                  var3.field638 = var1.method2557();
               }

               class214.method3982(class25.field635, 0, class25.field635.length - 1, class25.field639, class25.field649);
               class189.field3050 = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class189.field3050 = null;
      }

      return false;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-145339827"
   )
   void method624() {
      int var1 = this.field610;
      class40 var2 = this.field617.method850();
      if(null != var2) {
         this.field610 = var2.field981;
         this.field603 = var2.field935 * 128;
         this.field612 = var2.field982;
         this.field613 = var2.field983;
         this.field614 = var2.field984;
      } else {
         this.field610 = -1;
         this.field603 = 0;
         this.field612 = 0;
         this.field613 = 0;
         this.field614 = null;
      }

      if(var1 != this.field610 && this.field611 != null) {
         class121.field2014.method1200(this.field611);
         this.field611 = null;
      }

   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(Lclass16;I)V",
      garbageValue = "2141965833"
   )
   static final void method626(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field242 == 0) {
         var1 = class129.field2056.method2001(var0.field241, var0.field233, var0.field231);
      }

      if(var0.field242 == 1) {
         var1 = class129.field2056.method1990(var0.field241, var0.field233, var0.field231);
      }

      if(var0.field242 == 2) {
         var1 = class129.field2056.method2111(var0.field241, var0.field233, var0.field231);
      }

      if(var0.field242 == 3) {
         var1 = class129.field2056.method1979(var0.field241, var0.field233, var0.field231);
      }

      if(var1 != 0) {
         int var5 = class129.field2056.method2094(var0.field241, var0.field233, var0.field231, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field235 = var2;
      var0.field244 = var3;
      var0.field236 = var4;
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(Lclass3;ZI)V",
      garbageValue = "44973171"
   )
   static final void method628(class3 var0, boolean var1) {
      int var2 = var0.field64;
      int var3 = (int)var0.field3115;
      var0.method3946();
      if(var1 && var2 != -1 && class173.field2744[var2]) {
         class173.field2802.method3297(var2);
         if(null != class173.field2770[var2]) {
            boolean var6 = true;

            for(int var5 = 0; var5 < class173.field2770[var2].length; ++var5) {
               if(null != class173.field2770[var2][var5]) {
                  if(class173.field2770[var2][var5].field2798 != 2) {
                     class173.field2770[var2][var5] = null;
                  } else {
                     var6 = false;
                  }
               }
            }

            if(var6) {
               class173.field2770[var2] = null;
            }

            class173.field2744[var2] = false;
         }
      }

      for(class201 var4 = (class201)client.field489.method3825(); var4 != null; var4 = (class201)client.field489.method3823()) {
         if((long)var2 == (var4.field3115 >> 48 & 65535L)) {
            var4.method3946();
         }
      }

      class173 var7 = class153.method3177(var3);
      if(null != var7) {
         class39.method818(var7);
      }

      class191.method3782();
      if(client.field391 != -1) {
         class34.method767(client.field391, 1);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-2140160093"
   )
   public static int method629(String var0) {
      return var0.length() + 1;
   }
}
