import java.lang.ref.SoftReference;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hf")
public class class219 extends class224 {
   @ObfuscatedName("d")
   SoftReference field2660;

   class219(Object var1, int var2) {
      super(var2);
      this.field2660 = new SoftReference(var1);
   }

   @ObfuscatedName("d")
   Object vmethod4197() {
      return this.field2660.get();
   }

   @ObfuscatedName("z")
   boolean vmethod4201() {
      return true;
   }
}
