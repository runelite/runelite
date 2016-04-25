import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public final class class94 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2050929451
   )
   int field1586;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1787976929
   )
   int field1587;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1225001005
   )
   int field1588;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2025815441
   )
   int field1589;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1520871297
   )
   int field1590;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1482473541
   )
   int field1591;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1499340045
   )
   int field1592;
   @ObfuscatedName("c")
   public class85 field1593;
   @ObfuscatedName("n")
   public class85 field1594;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1091911809
   )
   public int field1595 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 150417057
   )
   int field1596 = 0;
   @ObfuscatedName("r")
   static int[] field1597;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "0"
   )
   static final void method2162(boolean var0) {
      class13.method165();
      ++client.field291;
      if(client.field291 >= 50) {
         client.field291 = 0;
         if(!client.field329 && class99.field1660 != null) {
            client.field318.method2735(200);

            try {
               class99.field1660.method2967(client.field318.field1973, 0, client.field318.field1971);
               client.field318.field1971 = 0;
            } catch (IOException var2) {
               client.field329 = true;
            }
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1278341243"
   )
   public static int method2163(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }
}
