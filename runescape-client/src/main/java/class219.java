import java.lang.ref.SoftReference;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hl")
public class class219 extends class224 {
   @ObfuscatedName("g")
   SoftReference field2665;

   class219(Object var1, int var2) {
      super(var2);
      this.field2665 = new SoftReference(var1);
   }

   @ObfuscatedName("g")
   Object vmethod4179() {
      return this.field2665.get();
   }

   @ObfuscatedName("e")
   boolean vmethod4180() {
      return true;
   }
}
