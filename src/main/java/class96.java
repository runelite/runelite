import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class96 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 582304559
   )
   int field1605;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 457859601
   )
   int field1606;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 279881203
   )
   int field1607;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1605584401
   )
   int field1608;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1263165419
   )
   public static int field1611;

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lclass33;I)V",
      garbageValue = "-160791943"
   )
   static final void method2209(class33 var0) {
      if(client.field432 == class20.field572.field804 >> 7 && class20.field572.field814 >> 7 == client.field513) {
         client.field432 = 0;
      }

      int var1 = class32.field731;
      int[] var2 = class32.field732;
      int var3 = var1;
      if(class33.field745 == var0 || class33.field749 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         class2 var5;
         int var6;
         if(var0 == class33.field745) {
            var5 = class20.field572;
            var6 = class20.field572.field56 << 14;
         } else if(var0 == class33.field749) {
            var5 = client.field387[client.field409];
            var6 = client.field409 << 14;
         } else {
            var5 = client.field387[var2[var4]];
            var6 = var2[var4] << 14;
            if(class33.field747 == var0 && client.field409 == var2[var4]) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod744() && !var5.field54) {
            var5.field52 = false;
            if((client.field285 && var1 > 50 || var1 > 200) && class33.field745 != var0 && var5.field838 == var5.field847) {
               var5.field52 = true;
            }

            int var7 = var5.field804 >> 7;
            int var8 = var5.field814 >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.field47 != null && client.field289 >= var5.field42 && client.field289 < var5.field59) {
                  var5.field52 = false;
                  var5.field41 = class59.method1263(var5.field804, var5.field814, class48.field1063);
                  class151.field2250.method1938(class48.field1063, var5.field804, var5.field814, var5.field41, var5, var5.field790, var6, var5.field48, var5.field49, var5.field50, var5.field51);
               } else {
                  if(64 == (var5.field804 & 127) && 64 == (var5.field814 & 127)) {
                     if(client.field369[var7][var8] == client.field384) {
                        continue;
                     }

                     client.field369[var7][var8] = client.field384;
                  }

                  var5.field41 = class59.method1263(var5.field804, var5.field814, class48.field1063);
                  class151.field2250.method1937(class48.field1063, var5.field804, var5.field814, var5.field41, 60, var5, var5.field790, var6, var5.field791);
               }
            }
         }
      }

   }

   class96(class96 var1) {
      this.field1605 = var1.field1605;
      this.field1608 = var1.field1608;
      this.field1606 = var1.field1606;
      this.field1607 = var1.field1607;
   }

   class96() {
   }
}
