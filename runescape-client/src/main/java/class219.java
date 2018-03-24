import java.lang.ref.SoftReference;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hw")
public class class219 extends class224 {
   @ObfuscatedName("t")
   SoftReference field2643;

   class219(Object var1, int var2) {
      super(var2);
      this.field2643 = new SoftReference(var1);
   }

   @ObfuscatedName("t")
   Object vmethod4105() {
      return this.field2643.get();
   }

   @ObfuscatedName("q")
   boolean vmethod4106() {
      return true;
   }
}
