import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public class class87 {
   @ObfuscatedName("p")
   static final BigInteger field1291;
   @ObfuscatedName("i")
   static final BigInteger field1289;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("NetCache_reference")
   static Buffer NetCache_reference;

   static {
      field1291 = new BigInteger("10001", 16);
      field1289 = new BigInteger("89b0f0282c810c24a50b498e8e6005d4bddea54614c2fee190fd95e6e16e78ce0ddd1a2a0f5a2bc56085660dda973a197966a060ba0cc033c8ead8f4282e19986805b5c97bdfc413cb5448726a4dd0f80d59593a1719d00543971c15a4f1d0ad8685b59283e724715a5389f756b8611f887effb2a6d83c470ee3897ddd88d13d", 16);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lbk;I)V",
      garbageValue = "-1524983452"
   )
   public static void method1851(ScriptEvent var0) {
      class213.method3942(var0, 200000);
   }
}
