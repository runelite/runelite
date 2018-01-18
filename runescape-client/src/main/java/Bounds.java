import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kk")
@Implements("Bounds")
public class Bounds {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -252833499
   )
   static int field3817;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -180991053
   )
   public int field3818;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1403568595
   )
   public int field3819;

   Bounds(int var1, int var2, int var3, int var4) {
      this.method5130(var1, var2);
      this.method5131(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-61"
   )
   void method5130(int var1, int var2) {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "20"
   )
   void method5131(int var1, int var2) {
      this.field3818 = var1;
      this.field3819 = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-1872602788"
   )
   public static void method5132(String var0, Throwable var1) {
      var1.printStackTrace();
   }
}
