import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class4 {
   @ObfuscatedName("i")
   static final BigInteger field70 = new BigInteger("94b842c3a4a0e8dd4cb66cc0232095eb512ca6304a76eaa0b9d27de9b8ae61d8c7e057d562f58fcd5dd8ff0a4b47570f1f724edd280679e3060c345ce26ff52b30ce8650a0d10d2390fd6b2b0e90026c70840750ce8d8a922981c6460405c16db423100d5aa7738558e5816758ee3172ee23944620c2abd62a532b31313f95c9", 16);
   @ObfuscatedName("l")
   static class80 field71;
   @ObfuscatedName("bu")
   static class168 field76;
   @ObfuscatedName("t")
   static final BigInteger field77 = new BigInteger("10001", 16);
   @ObfuscatedName("cz")
   static class224 field79;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = -1679592569
   )
   @Export("cameraY")
   static int field81;

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1181006855"
   )
   static void method36() {
      int var0 = class10.field162;
      int var1 = class41.field966;
      if(class126.field2049 < var0) {
         var0 = class126.field2049;
      }

      if(class109.field1915 < var1) {
         var1 = class109.field1915;
      }

      if(class116.field1988 != null) {
         try {
            client var2 = client.field280;
            int var3 = client.field496?2:1;
            class132.method2822(var2, "resize", new Object[]{Integer.valueOf(var3)});
         } catch (Throwable var4) {
            ;
         }
      }

   }
}
