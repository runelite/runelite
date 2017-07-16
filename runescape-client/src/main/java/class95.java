import java.applet.Applet;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
final class class95 implements Comparator {
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 490894279
   )
   static int field1484;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   class95(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lt;Lt;I)I",
      garbageValue = "-515627641"
   )
   int method1748(class14 var1, class14 var2) {
      if(var2.field301 == var1.field301) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field301) {
               return -1;
            }

            if(var2.field301 == Client.world) {
               return 1;
            }
         }

         return var1.field301 < var2.field301?-1:1;
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1748((class14)var1, (class14)var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)V",
      garbageValue = "102"
   )
   public static void method1747(Applet var0, String var1) {
      class56.field674 = var0;
      class56.field667 = var1;
   }
}
