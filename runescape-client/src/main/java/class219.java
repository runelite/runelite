import java.lang.ref.SoftReference;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hp")
public class class219 extends class224 {
   @ObfuscatedName("o")
   SoftReference field2659;

   class219(Object var1, int var2) {
      super(var2);
      this.field2659 = new SoftReference(var1);
   }

   @ObfuscatedName("o")
   Object vmethod4084() {
      return this.field2659.get();
   }

   @ObfuscatedName("k")
   boolean vmethod4087() {
      return true;
   }
}
