import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class146 {
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 1335786041
   )
   static int field2004;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1211870777
   )
   static int field2005;
   @ObfuscatedName("u")
   Inflater field2006;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class146(int var1, int var2, int var3) {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;ZLclass208;I)V",
      garbageValue = "-1241915485"
   )
   public static void method2712(class182 var0, class182 var1, boolean var2, class208 var3) {
      ItemComposition.field2935 = var0;
      ItemComposition.field2976 = var1;
      Buffer.isMembersWorld = var2;
      ItemComposition.field2975 = ItemComposition.field2935.method3323(10);
      class206.field3075 = var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BI)V",
      garbageValue = "-2146858314"
   )
   public void method2713(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[1 + var1.offset] == -117) {
         if(this.field2006 == null) {
            this.field2006 = new Inflater(true);
         }

         try {
            this.field2006.setInput(var1.payload, 10 + var1.offset, var1.payload.length - (8 + var1.offset + 10));
            this.field2006.inflate(var2);
         } catch (Exception var4) {
            this.field2006.reset();
            throw new RuntimeException("");
         }

         this.field2006.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   public class146() {
      this(-1, 1000000, 1000000);
   }
}
