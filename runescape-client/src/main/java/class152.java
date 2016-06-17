import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class152 implements class112 {
   @ObfuscatedName("j")
   static final class152 field2243 = new class152(2, 1, true, true, false);
   @ObfuscatedName("g")
   static final class152 field2244 = new class152(1, 0, true, true, true);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1083361785
   )
   final int field2245;
   @ObfuscatedName("d")
   static final class152 field2246 = new class152(3, 2, false, false, true);
   @ObfuscatedName("x")
   static final class152 field2247 = new class152(4, 3, false, false, true);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1622803545
   )
   public final int field2249;
   @ObfuscatedName("c")
   public final boolean field2250;
   @ObfuscatedName("b")
   static final class152 field2251 = new class152(0, -1, true, false, true);
   @ObfuscatedName("l")
   public final boolean field2252;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "977914203"
   )
   public int vmethod3185() {
      return this.field2245;
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "0"
   )
   class152(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2245 = var1;
      this.field2249 = var2;
      this.field2250 = var4;
      this.field2252 = var5;
   }
}
