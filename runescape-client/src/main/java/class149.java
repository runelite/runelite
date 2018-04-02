import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class149 implements Comparator {
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = -1479438809
   )
   static int field2123;
   @ObfuscatedName("c")
   final boolean field2122;

   public class149(boolean var1) {
      this.field2122 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;I)I",
      garbageValue = "-180636979"
   )
   int method3118(ChatPlayer var1, ChatPlayer var2) {
      return this.field2122?var1.field3839 - var2.field3839:var2.field3839 - var1.field3839;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3118((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-2026906917"
   )
   public static String method3123(CharSequence var0) {
      String var1 = GraphicsObject.method1798(FileSystem.method4543(var0));
      if(var1 == null) {
         var1 = "";
      }

      return var1;
   }
}
