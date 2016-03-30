import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ei")
public abstract class class131 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -637536451
   )
   public static int field2071;
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = -815067827
   )
   static int field2074;

   @ObfuscatedName("w")
   public abstract void vmethod3122(Component var1);

   @ObfuscatedName("x")
   public abstract void vmethod3123(Component var1);

   @ObfuscatedName("t")
   public abstract int vmethod3129();

   @ObfuscatedName("t")
   public static boolean method2845(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   @ObfuscatedName("c")
   static void method2846() {
      class32.field751 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class32.field749[var0] = null;
         class32.field750[var0] = null;
         class32.field754[var0] = 1;
      }

   }

   @ObfuscatedName("y")
   static int method2847(int var0) {
      class35 var1 = (class35)class11.field186.method3823((long)var0);
      return null == var1?-1:(class11.field185.field3109 == var1.field3113?-1:((class35)var1.field3113).field794);
   }
}
