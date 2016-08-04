import java.awt.datatransfer.Clipboard;
import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class11 {
   @ObfuscatedName("r")
   static final class203 field173 = new class203();
   @ObfuscatedName("g")
   static final class201 field174 = new class201(1024);
   @ObfuscatedName("ps")
   static Clipboard field175;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1193285969
   )
   public static int field176;
   @ObfuscatedName("iw")
   static class176 field177;
   @ObfuscatedName("l")
   @Export("chatLineMap")
   static final Map field182 = new HashMap();
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1492260681
   )
   static int field184 = 0;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass23;",
      garbageValue = "65280"
   )
   static class23 method165(int var0) {
      class23 var1 = (class23)class23.field611.method3905((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class20.field581.method3411(var0, 0);
         if(null == var2) {
            return null;
         } else {
            var1 = new class23();
            class122 var3 = new class122(var2);
            var3.field2050 = var3.field2051.length - 12;
            int var4 = var3.method2620();
            var1.field610 = var3.method2635();
            var1.field606 = var3.method2635();
            var1.field612 = var3.method2635();
            var1.field613 = var3.method2635();
            var3.field2050 = 0;
            var3.method2640();
            var1.field607 = new int[var4];
            var1.field608 = new int[var4];
            var1.field609 = new String[var4];

            int var6;
            for(int var5 = 0; var3.field2050 < var3.field2051.length - 12; var1.field607[var5++] = var6) {
               var6 = var3.method2635();
               if(var6 == 3) {
                  var1.field609[var5] = var3.method2663();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field608[var5] = var3.method2620();
               } else {
                  var1.field608[var5] = var3.method2633();
               }
            }

            class23.field611.method3907(var1, (long)var0);
            return var1;
         }
      }
   }
}
