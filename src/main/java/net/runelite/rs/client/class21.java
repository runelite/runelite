package net.runelite.rs.client;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("t")
final class class21 implements Comparator {
   @ObfuscatedName("r")
   static class172 field582;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   @ObfuscatedName("j")
   int method568(class213 var1, class213 var2) {
      if(var1.field3147 == var2.field3147) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field3147 == client.field286) {
               return -1;
            }

            if(var2.field3147 == client.field286) {
               return 1;
            }
         }

         return var1.field3147 < var2.field3147?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method568((class213)var1, (class213)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("w")
   static final void method570() {
      if(client.field339 > 0) {
         class27.method648();
      } else {
         client.method556(40);
         class177.field2911 = class209.field3115;
         class209.field3115 = null;
      }
   }

   class21(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("n")
   static final int method575(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & '\uff00') * var3 + var2 * (var1 & '\uff00') & 16711680) + ((var0 & 16711935) * var3 + (var1 & 16711935) * var2 & -16711936) >> 8;
   }

   @ObfuscatedName("j")
   public static void method576(int var0) {
      class139.field2170 = var0;
   }
}
