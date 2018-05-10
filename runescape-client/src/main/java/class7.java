import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
final class class7 implements Comparator {
   @ObfuscatedName("kw")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   static Widget field42;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lq;Lq;I)I",
      garbageValue = "-641386920"
   )
   int method79(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.field10 < var2.field10?-1:(var1.field10 == var2.field10?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method79((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([Lgk;IB)Lgk;",
      garbageValue = "64"
   )
   @Export("forOrdinal")
   public static Enumerated forOrdinal(Enumerated[] var0, int var1) {
      Enumerated[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Enumerated var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "103"
   )
   static int method87(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(Lbl;B)V",
      garbageValue = "121"
   )
   static final void method85(PendingSpawn var0) {
      long var1 = 0L;
      int var3 = -1;
      int var4 = 0;
      int var5 = 0;
      if(var0.type == 0) {
         var1 = ScriptEvent.region.method2927(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = ScriptEvent.region.method2928(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = ScriptEvent.region.method3045(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = ScriptEvent.region.method2930(var0.level, var0.x, var0.y);
      }

      if(var1 != 0L) {
         int var6 = ScriptEvent.region.method2931(var0.level, var0.x, var0.y, var1);
         var3 = class8.method93(var1);
         var4 = var6 & 31;
         var5 = var6 >> 6 & 3;
      }

      var0.field870 = var3;
      var0.field872 = var4;
      var0.field871 = var5;
   }
}
