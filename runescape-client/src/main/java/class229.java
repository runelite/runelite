import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public enum class229 implements RSEnum {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field3158(5, 0),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field3154(4, 1),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field3162(0, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field3156(2, 3),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field3153(3, 4),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field3155(1, 5),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field3159(6, 6),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field3160(7, 7);

   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -800149355
   )
   final int field3157;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -622571775
   )
   public final int field3161;

   class229(int var3, int var4) {
      this.field3161 = var3;
      this.field3157 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "959363303"
   )
   public int rsOrdinal() {
      return this.field3157;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)V",
      garbageValue = "94"
   )
   public static void method4118(Applet var0, String var1) {
      class56.field697 = var0;
      class56.field692 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CS)Z",
      garbageValue = "9911"
   )
   public static boolean method4117(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
