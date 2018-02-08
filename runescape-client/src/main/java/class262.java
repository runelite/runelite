import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
public class class262 extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static IndexDataBase field3468;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   public static NodeCache field3466;
   @ObfuscatedName("m")
   char field3467;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1802213605
   )
   public int field3465;
   @ObfuscatedName("i")
   public String field3469;
   @ObfuscatedName("w")
   boolean field3470;

   static {
      field3466 = new NodeCache(64);
   }

   class262() {
      this.field3470 = true;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   void method4845() {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "728607222"
   )
   void method4831(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4830(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgy;IB)V",
      garbageValue = "-82"
   )
   void method4830(Buffer var1, int var2) {
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
         this.field3467 = var3;
      } else if(var2 == 2) {
         this.field3465 = var1.readInt();
      } else if(var2 == 4) {
         this.field3470 = false;
      } else if(var2 == 5) {
         this.field3469 = var1.readString();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2145605090"
   )
   public boolean method4833() {
      return this.field3467 == 's';
   }
}
