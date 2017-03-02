import java.awt.datatransfer.Clipboard;
import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class146 {
   @ObfuscatedName("b")
   Inflater field2012;
   @ObfuscatedName("py")
   static Clipboard field2014;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BB)V",
      garbageValue = "0"
   )
   public void method2782(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(null == this.field2012) {
            this.field2012 = new Inflater(true);
         }

         try {
            this.field2012.setInput(var1.payload, 10 + var1.offset, var1.payload.length - (8 + 10 + var1.offset));
            this.field2012.inflate(var2);
         } catch (Exception var4) {
            this.field2012.reset();
            throw new RuntimeException("");
         }

         this.field2012.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class146(int var1, int var2, int var3) {
   }

   public class146() {
      this(-1, 1000000, 1000000);
   }
}
