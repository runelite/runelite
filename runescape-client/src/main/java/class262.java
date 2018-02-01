import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
public class class262 extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   static IndexDataBase field3448;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   static NodeCache field3445;
   @ObfuscatedName("w")
   char field3446;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1032345299
   )
   public int field3451;
   @ObfuscatedName("j")
   public String field3449;
   @ObfuscatedName("a")
   boolean field3450;

   static {
      field3445 = new NodeCache(64);
   }

   class262() {
      this.field3450 = true;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "12"
   )
   void method4703() {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "1194594322"
   )
   void method4690(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4696(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgj;II)V",
      garbageValue = "1896663005"
   )
   void method4696(Buffer var1, int var2) {
      if(var2 == 1) {
         byte var4 = var1.readByte();
         int var5 = var4 & 255;
         if(var5 == 0) {
            throw new IllegalArgumentException("");
         }

         if(var5 >= 128 && var5 < 160) {
            char var6 = class289.cp1252AsciiExtension[var5 - 128];
            if(var6 == 0) {
               var6 = '?';
            }

            var5 = var6;
         }

         char var3 = (char)var5;
         this.field3446 = var3;
      } else if(var2 == 2) {
         this.field3451 = var1.readInt();
      } else if(var2 == 4) {
         this.field3450 = false;
      } else if(var2 == 5) {
         this.field3449 = var1.readString();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "903518701"
   )
   public boolean method4692() {
      return this.field3446 == 's';
   }
}
