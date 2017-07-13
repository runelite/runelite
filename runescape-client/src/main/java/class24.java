import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class24 {
   @ObfuscatedName("p")
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("a")
   public static final class24 field355;
   @ObfuscatedName("j")
   public static final class24 field358;
   @ObfuscatedName("n")
   public static final class24 field354;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -928175025
   )
   final int field363;
   @ObfuscatedName("r")
   final String field353;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1093354213
   )
   final int field356;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -160564781
   )
   final int field360;

   static {
      field355 = new class24("SMALL", 0, 0, 4);
      field358 = new class24("MEDIUM", 1, 1, 2);
      field354 = new class24("LARGE", 2, 2, 0);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;III)V",
      garbageValue = "4"
   )
   class24(String var1, int var2, int var3, int var4) {
      this.field353 = var1;
      this.field356 = var2;
      this.field360 = var3;
      this.field363 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "1825937887"
   )
   boolean method170(float var1) {
      return var1 >= (float)this.field363;
   }
}
