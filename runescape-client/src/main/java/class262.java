import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
public class class262 extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static IndexDataBase field3467;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   public static NodeCache field3464;
   @ObfuscatedName("e")
   char field3466;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -3830745
   )
   public int field3469;
   @ObfuscatedName("u")
   public String field3468;
   @ObfuscatedName("z")
   boolean field3465;

   static {
      field3464 = new NodeCache(64);
   }

   class262() {
      this.field3465 = true;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-61"
   )
   void method4572() {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgh;B)V",
      garbageValue = "38"
   )
   void method4573(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4574(var1, var2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgh;II)V",
      garbageValue = "-1132691949"
   )
   void method4574(Buffer var1, int var2) {
      if(var2 == 1) {
         byte var4 = var1.readByte();
         int var5 = var4 & 255;
         if(var5 == 0) {
            throw new IllegalArgumentException("");
         }

         if(var5 >= 128 && var5 < 160) {
            char var6 = class277.cp1252AsciiExtension[var5 - 128];
            if(var6 == 0) {
               var6 = '?';
            }

            var5 = var6;
         }

         char var3 = (char)var5;
         this.field3466 = var3;
      } else if(var2 == 2) {
         this.field3469 = var1.readInt();
      } else if(var2 == 4) {
         this.field3465 = false;
      } else if(var2 == 5) {
         this.field3468 = var1.readString();
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-246940343"
   )
   public boolean method4579() {
      return this.field3466 == 's';
   }
}
