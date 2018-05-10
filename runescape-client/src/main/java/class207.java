import java.lang.ref.SoftReference;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gr")
public class class207 extends class212 {
   @ObfuscatedName("w")
   SoftReference field2455;

   class207(Object var1, int var2) {
      super(var2);
      this.field2455 = new SoftReference(var1);
   }

   @ObfuscatedName("w")
   Object vmethod4169() {
      return this.field2455.get();
   }

   @ObfuscatedName("m")
   boolean vmethod4175() {
      return true;
   }
}
