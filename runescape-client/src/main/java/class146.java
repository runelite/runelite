import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class146 {
   @ObfuscatedName("q")
   Inflater field2019;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class146(int var1, int var2, int var3) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BI)V",
      garbageValue = "511449347"
   )
   public void method2763(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(null == this.field2019) {
            this.field2019 = new Inflater(true);
         }

         try {
            this.field2019.setInput(var1.payload, 10 + var1.offset, var1.payload.length - (var1.offset + 10 + 8));
            this.field2019.inflate(var2);
         } catch (Exception var4) {
            this.field2019.reset();
            throw new RuntimeException("");
         }

         this.field2019.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-943210874"
   )
   static void method2767(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method2399((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }

   public class146() {
      this(-1, 1000000, 1000000);
   }
}
