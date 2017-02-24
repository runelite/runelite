import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1843927033
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1980105589
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("qs")
   protected static java.awt.Font field2849;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -178320625
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("d")
   public static NodeCache field2852 = new NodeCache(64);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "72"
   )
   void method3549(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3550(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-936304529"
   )
   void method3550(Buffer var1, int var2) {
      if(var2 == 1) {
         this.leastSignificantBit = var1.readUnsignedShort();
         this.configId = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)LBufferProvider;",
      garbageValue = "-57"
   )
   public static BufferProvider method3558(int var0, int var1, Component var2) {
      try {
         MainBufferProvider var3 = new MainBufferProvider();
         var3.init(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         SecondaryBufferProvider var4 = new SecondaryBufferProvider();
         var4.init(var0, var1, var2);
         return var4;
      }
   }
}
