import java.lang.ref.SoftReference;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ha")
public class class219 extends class224 {
   @ObfuscatedName("c")
   SoftReference field2650;

   class219(Object var1, int var2) {
      super(var2);
      this.field2650 = new SoftReference(var1);
   }

   @ObfuscatedName("c")
   Object vmethod4085() {
      return this.field2650.get();
   }

   @ObfuscatedName("i")
   boolean vmethod4088() {
      return true;
   }
}
