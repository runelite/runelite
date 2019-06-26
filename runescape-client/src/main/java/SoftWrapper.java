import java.lang.ref.SoftReference;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ef")
@Implements("SoftWrapper")
public class SoftWrapper extends Wrapper {
   @ObfuscatedName("m")
   @Export("ref")
   SoftReference ref;

   SoftWrapper(Object var1, int var2) {
      super(var2);
      this.ref = new SoftReference(var1);
   }

   @ObfuscatedName("m")
   @Export("get")
   Object get() {
      return this.ref.get();
   }

   @ObfuscatedName("f")
   @Export("isSoft")
   boolean isSoft() {
      return true;
   }
}
