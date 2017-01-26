import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1481156695
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1543965989
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2106594923
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;
   @ObfuscatedName("g")
   public static NodeCache field2845 = new NodeCache(64);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1450431449"
   )
   public void method3528(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3531(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-728523324"
   )
   void method3531(Buffer var1, int var2) {
      if(var2 == 1) {
         this.leastSignificantBit = var1.readUnsignedShort();
         this.configId = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "-67"
   )
   public static String method3535(CharSequence var0) {
      String var1 = class149.method2784(class139.method2565(var0));
      if(var1 == null) {
         var1 = "";
      }

      return var1;
   }
}
