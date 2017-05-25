import java.util.Comparator;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
final class class95 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lclass154;IIB)Lclass109;",
      garbageValue = "57"
   )
   public static final class109 method1798(class154 var0, int var1, int var2) {
      if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            class109 var3 = CollisionData.field2276.vmethod1947();
            var3.field1625 = new int[(class168.field2315?2:1) * 256];
            var3.field1624 = var2;
            var3.vmethod2073();
            var3.field1623 = (var2 & -1024) + 1024;
            if(var3.field1623 > 16384) {
               var3.field1623 = 16384;
            }

            var3.vmethod2044(var3.field1623);
            if(class243.field3305 > 0 && class83.field1308 == null) {
               class83.field1308 = new class111();
               class60.field737 = Executors.newScheduledThreadPool(1);
               class60.field737.scheduleAtFixedRate(class83.field1308, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class83.field1308 != null) {
               if(class83.field1308.field1651[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class83.field1308.field1651[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new class109();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   class95(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "-513169691"
   )
   int method1800(class14 var1, class14 var2) {
      if(var2.field285 == var1.field285) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field285 == Client.world) {
               return -1;
            }

            if(Client.world == var2.field285) {
               return 1;
            }
         }

         return var1.field285 < var2.field285?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method1800((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
