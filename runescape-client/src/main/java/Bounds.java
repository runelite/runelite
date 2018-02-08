import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kk")
@Implements("Bounds")
public class Bounds {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 230594959
   )
   public int field3858;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1939536623
   )
   public int field3859;

   Bounds(int var1, int var2, int var3, int var4) {
      this.method5542(var1, var2);
      this.method5538(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2079295388"
   )
   void method5542(int var1, int var2) {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1393591327"
   )
   void method5538(int var1, int var2) {
      this.field3858 = var1;
      this.field3859 = var2;
   }
}
