import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("varbit_ref")
   public static IndexDataBase varbit_ref;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("varbits")
   public static NodeCache varbits;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2014354667
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -834827071
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -181488447
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "706614808"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgj;II)V",
      garbageValue = "1778882417"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   public static final boolean method4683() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field595 == KeyFocusListener.field593) {
            return false;
         } else {
            WorldMapData.field427 = KeyFocusListener.field576[KeyFocusListener.field593];
            class63.field722 = KeyFocusListener.field582[KeyFocusListener.field593];
            KeyFocusListener.field593 = KeyFocusListener.field593 + 1 & 127;
            return true;
         }
      }
   }
}
