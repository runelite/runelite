import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
final class class22 implements Comparator {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -147029275
   )
   public static int field583;
   @ObfuscatedName("bn")
   static class171 field584;
   @ObfuscatedName("dc")
   static byte[][] field587;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "-2008712297"
   )
   public static void method557(class170 var0) {
      class52.field1127 = var0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1815173994"
   )
   public static void method558(boolean var0) {
      if(class174.field2774 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2715(var0?2:3);
            var1.method2742(0);
            class174.field2774.method3043(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class174.field2774.method3044();
            } catch (Exception var3) {
               ;
            }

            ++class174.field2792;
            class174.field2774 = null;
         }

      }
   }

   public int compare(Object var1, Object var2) {
      return this.method563((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   class22(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "995252177"
   )
   int method563(class217 var1, class217 var2) {
      if(var2.field3204 == var1.field3204) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field3204 == Client.world) {
               return -1;
            }

            if(Client.world == var2.field3204) {
               return 1;
            }
         }

         return var1.field3204 < var2.field3204?-1:1;
      }
   }
}
