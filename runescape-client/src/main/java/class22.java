import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
final class class22 implements Comparator {
   @ObfuscatedName("md")
   @Export("clanMembers")
   static class25[] field603;
   @ObfuscatedName("d")
   static int[] field606;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   public int compare(Object var1, Object var2) {
      return this.method557((class217)var1, (class217)var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "103"
   )
   int method557(class217 var1, class217 var2) {
      if(var1.field3197 == var2.field3197) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(client.field468 == var1.field3197) {
               return -1;
            }

            if(var2.field3197 == client.field468) {
               return 1;
            }
         }

         return var1.field3197 < var2.field3197?-1:1;
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1774656729"
   )
   static final boolean method562(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = client.field438[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass170;II)Z",
      garbageValue = "371572371"
   )
   public static boolean method563(class170 var0, int var1) {
      byte[] var2 = var0.method3415(var1);
      if(var2 == null) {
         return false;
      } else {
         class49.method1075(var2);
         return true;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "1"
   )
   public static int method569(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1857750355"
   )
   static boolean method571(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   class22(boolean var1) {
      this.val$preferOwnWorld = var1;
   }
}
