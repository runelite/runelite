import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class127 {
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = 958905831
   )
   static int field2059;
   @ObfuscatedName("s")
   public static short[][] field2060;

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-60"
   )
   static void method2787(int var0) {
      client.field566 = new class30();
      client.field566.field695 = client.field425[var0];
      client.field566.field696 = client.field426[var0];
      client.field566.field697 = client.field392[var0];
      client.field566.field698 = client.field502[var0];
      client.field566.field699 = client.field429[var0];
   }
}
