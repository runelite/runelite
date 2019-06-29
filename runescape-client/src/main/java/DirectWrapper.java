import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ew")
@Implements("DirectWrapper")
public class DirectWrapper extends Wrapper {
   @ObfuscatedName("m")
   @Export("obj")
   Object obj;

   DirectWrapper(Object var1, int var2) {
      super(var2);
      this.obj = var1;
   }

   @ObfuscatedName("m")
   @Export("get")
   Object get() {
      return this.obj;
   }

   @ObfuscatedName("f")
   @Export("isSoft")
   boolean isSoft() {
      return false;
   }
}
